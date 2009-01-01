/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */

 


// Class will not work without the ListGrid
if (isc.ListGrid) {





//>	@class	DateItem
//
// Item for manipulating Dates.
// <p>
// Can be rendered as a text field, or as 3 selects for day, month, year.  Includes optional
// pop-up picker.
//
// @visibility external
// @example dateItem
//<
isc.defineClass("DateItem", "ContainerItem");

isc.defineClass("DateTimeItem", "DateItem");

isc.DateItem.addClassProperties({
	//>	@classAttr	DateItem.mapCache		(object : {} : IRW)
	//		Cache for the map of day, month and year values 
	//			-- so we don't have to calculate the values over and over.
	//		Items are keyed in the map by "<code>day|month|year</code>.<code>start</code>.<code>end</code>".
	//<
	mapCache:{},	
 
    //>	@const	DateItem.TEXT_FIELD     (object : {...} : IRW)
	//		Text field to hold the entire date in "type in" format, if 'useTextField' is true
    //      for an item.
	//<	
    TEXT_FIELD:    {name:"dateTextField",   type:"text",    changeOnBlur:true,
                    
                        changeOnKeypress:false,
                        
                        // Override the blur method to update the DateItem value
                        // Using blur rather than saveValue / change allows changeOnKeypress to
                        // be set to true without the dateItem clobbering the user's half-typed
                        // strings
                        blur : function () {
                            if (this.parentItem) this.parentItem.updateValue();
                        },
                        
                        shouldSaveValue:false,
                        // Determine our size based on our parents specified textBox size
                        getInnerWidth : function () {
                            if (this.parentItem) return this.parentItem.getTextBoxWidth();
                            return this.Super("getInnerWidth", arguments);
                        }
                   },
    
	//>	@const	DateItem.DAY_SELECTOR		(object : {...} : IRW)
	//		Select item to hold the day part of the date.
	//<	
	DAY_SELECTOR:	{name:"daySelector",		prompt:"Choose a day", type:"select", 	
                        valueMap:"this.parentItem.getDayOptions()", shouldSaveValue:false,
                        // Override saveValue to update the parent.
                        
                        saveValue:function () {
                            this.Super("saveValue", arguments);
                            this.parentItem.updateValue();
                        },
                        cssText:"padding-left:3px;",
                        width:45},

	//>	@const	DateItem.MONTH_SELECTOR		(object : {...} : IRW)
	//		Select item to hold the month part of the date.
	//<	
	MONTH_SELECTOR:	{name:"monthSelector",	prompt:"Choose a month", type:"select", 	
                        valueMap:"this.parentItem.getMonthOptions()", shouldSaveValue:false,
                        saveValue:function () {
                            this.Super("saveValue", arguments);
                            this.parentItem.updateValue();
                        },
                        width:55},
	

	//>	@const	DateItem.YEAR_SELECTOR		(object : {...} : IRW)
	//		Select item to hold the year part of the date.
	//<	
	YEAR_SELECTOR:	{name:"yearSelector",		prompt:"Choose a year", type:"select",	
                        valueMap:"this.parentItem.getYearOptions()", shouldSaveValue:false,
                        saveValue:function () {
                            this.Super("saveValue", arguments);
                            this.parentItem.updateValue();
                        },
                        cssText:"padding-left:3px;",
                        width:60},
	
	//>	@type	DateItemSelectorFormat
	DAY_MONTH_YEAR:"DMY",		//	@value	isc.DateItem.DAY_MONTH_YEAR		Output fields in day, month, year order.
	MONTH_DAY_YEAR:"MDY",		//	@value	isc.DateItem.MONTH_DAY_YEAR		Output fields in month, day, year order.
	YEAR_MONTH_DAY:"YMD",		//	@value	isc.DateItem.YEAR_MONTH_DAY		Output fields in year, month, day order.
	//<

    DEFAULT_START_DATE:new Date(1995, 0, 1),
    DEFAULT_END_DATE:new Date(2015, 11, 31),
    DEFAULT_CENTURY_THRESHOLD:25,
    
	chooserWidth:150,			//	@classAttr	isc.DateItem.chooserWidth	(number)	Width of the date chooser -- used to choose a date graphically.
	chooserHeight:171			//	@classAttr	isc.DateItem.chooserHeight	(number)	Height of the date chooser -- used to choose a date graphically.

});

isc.DateItem.addProperties({
    
    // Default to 150 wide
    // This is an appropriate default if we're showing the text field 
    // If we're showing the selectors, this value will be forced to 200 during setItems
    width:150,
    
    cellPadding:0,
    
    pickerConstructor: "DateChooser",

    //> @attr dateItem.pickerProperties (DateChooser : see below : [IR])
    // Properties for the +link{DateChooser} created by this form item.
    //<
    
    pickerProperties: {
        width: isc.DateItem.chooserWidth,
        height: isc.DateItem.chooserHeight,
        border:"1px solid black;",
        // show a cancel button that closes the window
        showCancelButton: true,
        autoHide: true
    },

    //>	@attr	dateItem.useTextField   (boolean    : false : IRW)
    //      Should we show the date in a text field, or as 3 select boxes?
    // @group basics
    // @visibility external
    // @example dateItem
    //<                                            
    useTextField:false,
    
    //> @attr   dateItem.textAlign  (Alignment : isc.Canvas.RIGHT : IRW)
    // If +link{dateItem.useTextField} is <code>true</code> this property governs the alignment
    // of text within the text field.
    // @group appearance
    // @visibility external
    //<
    textAlign:isc.Canvas.RIGHT,
    
    //> @attr dateItem.enforceDate  (boolean : false : IRWA)
    // Can this field be set to a non-date value [other than null]?
    // <P>
    // When set to true, the value of the FormItem will <b>always</b> be a valid Date or null.
    // Even a programmatic call to setValue() with a value other than a date,
    // such as <code>dateItem.setValue("[Enter a date]")</code>, will be ignored.
    // <P>
    // When set to false, a user may enter value that is not a valid date (for example, "Not
    // applicable") and the value will not immediately be flagged as an error.  However note
    // that for the value to actually pass validation you would need to declare the field as
    // not of "date" type, for example:
    // <pre>
    //     {name:"startDate", type:"dateOrOther", editorType:"DateItem", useTextField:true },
    // </pre>
    // The type "dateOrOther" could be declared as a +link{SimpleType}, with validators that
    // will accept either a valid date or certain special Strings (like "Not Available").
    // <P>
    // Note that if +link{DateItem.useTextField} is false for the dateItem, non date values are
    // not allowed regardless of this property's value.
    //
    // @visibility external
    //<
    enforceDate:false,
    
    // Allow overriding of properties on the text or select fields on a per-instance basis

    
    //textFieldProperties:null,
    //daySelectorProperties:null,
    //monthSelectorProperties:null,
    //yearSelectorProperties:null,
 
    //>	@attr	dateItem.invalidDateStringMessage   (string : "Invalid date" : IRW)
    //  Validation error message to display if the user enters an invalid date
    // @visibility external
    //<                                            
    invalidDateStringMessage:"Invalid date",
    
    //>	@attr	dateItem.showPickerIcon (boolean : true : IRW)
    //      Should we show the pick button icon?
    // @visibility pickerIcon
    //<
    
    showPickerIcon:true,
    
    //>	@attr	dateItem.pickerIconWidth (number : 20: IRW)
    // Width for the date item's pickerIcon.
    // @visibility pickerIcon
    //<    
    pickerIconWidth:20,

    //>	@attr	dateItem.pickerIconHeight (number : 20 : IRW)
    // Height for the date item's pickerIcon.
    // @visibility pickerIcon
    //<    
    pickerIconHeight:20,
    
    //>	@attr	dateItem.pickerIconSrc (SCImgURL : "[SKIN]/DynamicForm/DatePicker_icon.gif" : IRW)
    // Src for the picker icon image
    // @visibility pickerIcon
    //<
    pickerIconSrc:"[SKIN]/DynamicForm/DatePicker_icon.gif", 
    
    // give the picker icon 3px of horizontal space by default
    pickerIconHSpace:3,
    
    //>@attr dateItem.pickerIconPrompt (string : "Show Date Chooser" : IR)
    // Prompt to show when the user hovers the mouse over the picker icon for this DateItem. May
    // be overridden for localization of your application.
    // @visibility external
    // @group i18nMessages
    //<
    pickerIconPrompt : "Show Date Chooser",
    
    //>	@attr	dateItem.pickerIconProperties (object : {...} : IRW)
    // Properties for the pickerIcon.
    // @visibility pickerIcon
    //<
    pickerIconProperties:{
    },

    
        
    //>	@attr	dateItem.startDate		(Date : 1/1/1995 : IRW)
	// Minimum date the selectors will allow the user to pick.
	//		@group	appearance
    // @visibility external
	//<
    startDate:isc.DateItem.DEFAULT_START_DATE,    

    //>	@attr	dateItem.endDate		(Date : 12/31/2015 : IRW)
	// Maximum date the selectors will allow the user to pick.
	//		@group	appearance
    // @visibility external
	//<
    endDate:isc.DateItem.DEFAULT_END_DATE,

    //>	@attr	dateItem.centuryThreshold		(number : 25 : IRW)
	// Only used if we're showing the date in a text field. When parsing a date, if the year
    // is specified with only 2 digits and is less than the centuryThreshold, then the year will
    // be assumed to be 20xx; otherwise it will be interpreted according to default browser
    // behaviour, which will consider it to be 19xx.
	//		@group	appearance
    // @visibility external
	//<
    centuryThreshold:isc.DateItem.DEFAULT_CENTURY_THRESHOLD,
    
    //>	@attr	dateItem.displayFormat  (DateDisplayFormat : "toShortDate" : IRW)
    // If +link{dateItem.useTextField} is <code>true</code> this property can be used to 
    // customize the format in which dates are displayed.<br>
    // Should be set to a standard +link{type:DateDisplayFormat} or
    // a function which will return a formatted date string.
    // Default setting is <code>"toShortDate"</code> which ensures that if the standard
    // shortDate format is modified via +link{Date.setShortDisplayFormat()} this format
    // will be picked up.<br>
    // Important: the display format and the +link{DateItem.inputFormat, inputFormat} 
    // for dateItems should always be set such that the format of strings displayed by this
    // item matches the expected format of strings the user enters.
    // @see dateItem.inputFormat
    // @visibility external
    //<
    displayFormat:"toShortDate"
    
    //> @attr  dateItem.inputFormat  (DateInputFormat : null : IRW)
    // If +link{dateItem.useTextField} is <code>true</code> this property can be used to specify
    // the input format for date strings. 
    // If unset, the input format will be picked up from the Date class (see
    // +link{Date.setInputFormat()}).<br>
    // Should be set to a standard +link{type:DateInputFormat} or
    // a function which will take a date string as a parameter and return a Javascript Date object.
    // <P>
    // Important: the input format and the +link{DateItem.displayFormat, displayFormat} 
    // for dateItems should always be set such that the format of strings displayed by this
    // item matches the expected format of strings the user enters.
    // @see dateItem.displayFormat
    // @visibility external
    //<
    //inputFormat:null,
    
    //>	@attr	dateItem.selectorFormat		(DateItemSelectorFormat : null : IRW)
    // If showing date selectors rather than the date text field (so when 
    // <code>this.useTextField</code> is false), this property allows customization of the 
    // order of the day, month and year selector fields. If unset these fields will match the
    // specified inputFormat for this item.
    // @visibility external
    //<
	//selectorFormat:null

});

isc.DateItem.addMethods({

    // if selectorFormt is unset, back off to standard inputFormat.
    getSelectorFormat : function () {
        if (this.selectorFormat) { 
            return this.selectorFormat;
        } else if (this.inputFormat && isc.isA.String(this.inputFormat)) {
            return this.inputFormat;
        } else {
            var inputFormat = Date.getInputFormat();
            if (isc.isA.String(inputFormat)) return inputFormat;
            // Asssume US date format if we can't deduce the desired format from the date input
            // format
            this.logInfo("DateItem selectorFormat unspecified - assuming US format");
            return "MDY"
        }
    },

	//>	@method	dateItem.setItems()	(A)
	//
	// 	Override the setItems() routine to set the order of the fields according to this.dateFormat
	//<
	setItems : function (itemList) {
    
		var DI = isc.DateItem,
			format = this.getSelectorFormat()
		;
        
        if (itemList != null && itemList.length != 0) {
            this.logWarn("setItems() called for dateItem with itemList:" + itemList + 
                            " - ignoring, and making use of default date fields");
        }

		// create a new itemList
		itemList = this.items = [];      

        if (this.useTextField) {
            
            var textField = isc.addProperties({textAlign:this.textAlign}, 
                                              DI.TEXT_FIELD, this.textFieldProperties);
            // If we have a specified height, expand the text box to fill the available space
            
            if (this.height && (!this.textFieldProperties || !this.textFieldProperties.height)) 
            {
                textField.height = this.getTextBoxHeight();
            }

            itemList.add(textField);
    
            //>EditMode for dynamically changing useTextField
            var undef;
            this.daySelector = this.yearSelector = this.monthSelector = undef;
            //<EditMode
        
        } else {
            // If we're not showing the text field, force our width to 200px
            
            this.width = 200;
		
    		// iterate through the characters of the format
    		for (var i = 0; i < format.length; i++) {
    			var field = format.charAt(i);
    			// assigning the selector for that format to the itemList
                var dayField, monthField, yearField;
                if (field == "D") {
                    var dayField;
                    if (this.daySelectorProperties != null) {
                        dayField = isc.addProperties({}, DI.DAY_SELECTOR, this.daySelectorProperties);
                    } else {
                        dayField = isc.addProperties({}, DI.DAY_SELECTOR);
                    }
                    itemList.add(dayField);
                } else if (field == "M") {
                    var monthField;
                    if (this.monthSelectorProperties != null) {
                        monthField = isc.addProperties({}, DI.MONTH_SELECTOR, this.monthSelectorProperties);
                    } else {
                        monthField = isc.addProperties({}, DI.MONTH_SELECTOR);
                    }                
                    itemList.add(monthField);
                } else if (field == "Y") {
                    var yearField;
                    if (this.yearSelectorProperties != null) {
                        yearField = isc.addProperties({}, DI.YEAR_SELECTOR, this.yearSelectorProperties);
                    } else {
                        yearField = isc.addProperties({}, DI.YEAR_SELECTOR);
                    }
                    itemList.add(yearField);
                }
    		}
        }
        
		// call the superclass routine to properly set the items
		this.Super("setItems", [itemList]);
	},

    // Override isEditable() to indicate that the user can edit this items value directly
    isEditable : function () {
        return true;
    },

	//>	@method	dateItem.setValue()	(A)
	//  Override setValue to set the values for the sub-items of the date.
	//<
	setValue : function (value) {
        this._setValueCalled = true;    
        
        // may still be null if we're working with a text field
        var setToDefault = false;
        if (value == null) {
            value = this.getDefaultValue();    
            setToDefault = true;
        }
        
        var invalidDate;
        // allow null values if useTextField is true and field is blank
        // Note - we currently don't suport setting null dates on date items showing selectors - 
        // not clear how this mechanism would work 
        // - once a date was null, presumably all 3 selectors would be showing "". 
        // - when the user then chose a value from one selector, would we default the other 2 to
        //   some default?
        // - similarly if the 3 selectors showed a valid date, how would the user set it to an
        //   empty date (one at a time?)
        if (isc.is.emptyString(value)) value = null;
        if (value == null) {
            invalidDate = !this.useTextField;
        } else {
            
            var date = this.parseDate(value);
            // parseDate returns null if passed something it doesn't understand
            if (date == null) {
                invalidDate = true;
                if (this.enforceDate) value = null;
            } else {
                value = date;
            }
        }
        if (invalidDate && (!this.useTextField || this.enforceDate)) {
        	//>DEBUG
			this.logInfo("dateItem.setValue(): invalid date passed: '" + value + 
                            "'.  Not updating value.");
			//<DEBUG
            
            
            if (this.useTextField) {
                var textField = this.dateTextField,
                    textFieldValue = textField.getValue();
                this._suppressUpdates = true;
                if (textFieldValue != null) textField.setElementValue(textFieldValue);
                this._suppressUpdates = null;
            }
            // return false in case anyone is checking the return value
            return false;
        }
        // clear errors if we have any
        if (this._invalidDate) {
            delete this._invalidDate;
            this.clearErrors();
            this.redraw();
        }
         
        // hang onto the value passed in if it is not invalid
        this.saveValue(value, setToDefault);
        
        // Avoid attempting to parse / correct the dates in response to these setValues calls
        this._suppressUpdates = true;
        if (this.useTextField) {
            var textValue;            
            if (isc.isA.Date(value)) textValue = value.toShortDate(this.displayFormat);
            else {
                // we may be hanging onto a local, invalid value entered by the user - clear that
                // if that's the case.
                if (value == null || this.enforceDate) textValue = isc.emptyString;
                else textValue = value;
            }           
            this.dateTextField.setValue(textValue);
        }
		// set the day, month and year selectors
		if (this.daySelector) 		this.daySelector.setValue(value.getDate());
		if (this.monthSelector) 	this.monthSelector.setValue(value.getMonth());
		if (this.yearSelector)		this.yearSelector.setValue(value.getFullYear());
        delete this._suppressUpdates;

        return true;
	},
    
    
    // if we're doing a direct submit of the DateItem value, convert it to the 
    // dbDate format so it can be parsed on the server.
    _setHiddenDataElementValue : function (value) {
        var hde = this._getHiddenDataElement();
        if (hde != null) {
            if (isc.isA.Date(value)) hde.value = value.toDBDate();
            
            else hde.value = value;
        }
    },
    
    // Override getCellHeight() to ensure the containing form leaves enough space for this item.
    
    getCellHeight : function () {
        var cellHeight = this.Super("getCellHeight", arguments);
        if (isc.Browser.isIE && this.useTextField && isc.isA.Number(cellHeight)) cellHeight += 2;
        return cellHeight;
    },    
    
    
    elementChanged : function () {
        return;
    },
    
    // Override updateValue to verify that the contents of the element(s) make a valid date.
    updateValue : function () {
        
        // _suppressUpdates flag set when we're in the process of setting our sub items' values
        // to represent a known, valid date.
        
        if (this._suppressUpdates) return;

        // We're likely to manipulate the values of the form items as this method runs - avoid
        // re-running updateValue in response to 'saveValue()' on the sub items.
        this._suppressUpdates = true;

        var date;
        if (this.useTextField) {
        
            // Note: this method is called from "saveValue()" on the sub-items (after saving out 
            // their values) so typically the sub item values will be up to date.
            // However this method may also be called externally while the text item is pending
            // an update (from blur [or keypress]).
            // Call updateValue() to ensure the text field value matches the current element
            // value for that field.
            this.dateTextField.updateValue();
            var value = this.dateTextField.getValue();
            
            if (value == isc.emptyString || value == null) date = null;
            else {
                // This will return a null value if the date string is invalid.
                
                date = this.parseDate(value);
                if (date == null) {
                    if (this.enforceDate) {
                        this.logInfo("Invalid date string entered in date text field :"+ value);
                        
                        if (!this._invalidDate) {
                            this._invalidDate = true;
                            this.setError(this.invalidDateStringMessage);
                        }
                        // We need to redraw to show the error. We don't want the user's entry
                        // to vanish, so we store it under a temp var. which the text field will
                        // display
                        
                        this.redraw();
                    }
                    
                    
                    this.saveValue(value);
                    delete this._suppressUpdates;
                    return;
                    
                } else {
                       
                    // If the date was valid, the format may have slightly changed
                    // (01/01/01 -> 1/1/2001, for example) - if necessary update the text
                    // field here.
                    var dateString = date.toShortDate(this.displayFormat);
                    if (value != dateString) {
                        // we've set _suppressUpdates, so we won't end up in an infinite loop 
                        // from this call
                        this.dateTextField.setValue(dateString);
                    }
                }
            }
            // at this point we want to make sure we're not showing an old invalid date / error
            if (this._invalidDate) {
                delete this._invalidDate;
                this.clearErrors();
                this.redraw();
            }
            
        } else {
        
            // If we're not showing a text field, start with the last remembered date, and update
            // that based on the values in the selector items
            date = (this._value || this.getDefaultValue());
            // copy the date object to allow us to reset to _value if change handler fails
            date = date.duplicate();

            var day, month, year;

            if (this.yearSelector) {
                year = this.yearSelector.getValue()
                date.setYear(year);
            }
            if (this.monthSelector) {
                month = this.monthSelector.getValue();
                
                // If we have a daySelector, we set the date to 1 so that setting the month will
                // not lead to an invalid date like Feb 30.
                // This avoids the case where 
                //  - the selectors are set to Feb 30, and the previous date was Jan 30.
                //  - the date object has 'setMonth()' called, setting the month is set to "Feb", 
                //    causing the date to be automatically updated to March 2
                //  - the day is set to 30 (from the date selector), leaving us with a date of
                //    March 30.
                //  At this point the logic to roll the days back to the end of the month would fail
                if (this.daySelector) date.setDate(1);
                
                date.setMonth(month);
            }

            if (this.daySelector) {
                day = this.daySelector.getValue();
                date.setDate(day);
            }            
            
            // If set to an invalid date, such as Feb 30, or Feb 29th on a non-leap year, the month 
            // will have been rolled forward (making it easy to catch such errors)
            // make sure the date's month is the same as that specified in the list
            // if it's not, we should roll back the day selector, and update the date to the 
            // appropriate day / month
            if (month != date.getMonth()) {
                // This rolls the date back to the end of the previous month
                day = day - date.getDate();
                if (this.daySelector) this.daySelector.setValue(day);
                date.setMonth(month);
                date.setDate(day);
            } 
        
        }

        delete this._suppressUpdates;
        
        // now fire the default handlers:
        if (this.handleChange(date, this._value) == false) return;

        // In case the change handler modified the date
        date = this._changeValue;
        
        // save the value
        this.saveValue(date);    

        // fire the 'changed' handler
        this.handleChanged(date);
                    
    },
    	
	//>	@method	dateItem.resetValue()
	//      Overridden to get the value from the old value stored in the form, rather than
    //      replacing this item's value with the date object
	//		@group	elements
	//<
	resetValue : function () {
		var oldValue = this.form._oldValues[this.getFieldName()];
        if (isc.isA.Date(oldValue) && isc.isA.Date(this._value)) 
            oldValue = this._value.setTime(oldValue.getTime());
		this.setValue(oldValue);
	},    


    // getItemValue() - method to get the initial value of items when writing out this 
    // containerItem's innerHTML.
    // For the Date Item we give our sub items (selects / text item) the correct value when they
    // are initially set up.
    getItemValue : function (item, values) {
        return item.getValue();
        
    },

    //> @method dateItem.setWidth()    (A)
    //      @group  sizing
    //          set the width for this element
    //          Overridden to set the size of the date text field, if present
    //
    //        @param    (number)    new width for the form element
    //<
    setWidth : function (width) {
        // we don't support any size other than 200 if we're showing the selectors
        if (!this.useTextField) {
            this.width = 200;      
            return;
        }
        
        // Note that the superclass implementation will mark us for redraw if necessary, and
        // the date text field will pick up its new size from the getInnerWidth() override.
        return this.Super("setWidth", arguments);
    },

	//>	@method	dateItem.getDefaultValue()	(A)
	//  Override getDefaultValue to guarantee that it returns a date if 
    //  <code>item.enforceDate</code> is true. If no default date is supplied, defaults to the
    //  current date.
	//<
    // Note: As currently written this method will not consistently return the same date instance
    // unless this.defaultValue is explicitly specifed as a date object. Instead we create a
    // new date instance each time the method is called and return that. 
    // This can be a gotcha - for exmaple when checking for changes to a date item we have to 
    // use compareDates() rather than ==.
	getDefaultValue : function () {
        var value = this.Super("getDefaultValue");
        if (!isc.isA.Date(value)) {
            var dateValue = this.parseDate(value);
            if (isc.isA.Date(dateValue)) value = dateValue;
            else if (!this.useTextField || this.enforceDate) {
                var replaceDefaultValue;
                if (value != null) {
                    this.logWarn("Default DateItem value provided as:" + value + 
                             ". This is not recognized as a valid date - defaulting to a new date");
                    // if this came from a static default value, replace it so we don't see
                    // multiple warnings
                    replaceDefaultValue = this.defaultValue == value;
                }
                
                // if we still don't have a valid date, default to a new Date().
                // NOTE: can't just set the defaultValue to "new Date()" as this object would then
                // be shared amongst all date instances
                value = this._getEmptyDate();
                
                if (replaceDefaultValue) this.defaultValue = value;
            }
        }
        return value;
	},
    
    _getEmptyDate : function () {
        var value = new Date();
        // zero out the time by default
        value.setHours(0);
        value.setMinutes(0);
        value.setSeconds(0);
        value.setMilliseconds(0);
        return value;
    },
    
    //>	@method	dateItem.getStartDate()	(A)
	//		use this method, rather than referring to this.startDate, to guarantee that it
    //      returns a date
    //      Note - Does not update this.startDate - should it?
	//<
	getStartDate : function () {
        var startDate = this.parseDate(this.startDate);
        if(!isc.isA.Date(startDate)) {
            //>DEBUG
            this.logWarn("startDate was not in valid date format - using default start date");
            //<DEBUG
            startDate = isc.DateItem.DEFAULT_START_DATE;
        }
        return startDate;
    },
    
    //>	@method	dateItem.getEndDate()	(A)
	//		use this method, rather than referring to this.endDate, to guarantee that it
    //      returns a date
	//<
	getEndDate : function () {
        var endDate = this.parseDate(this.endDate);
        if(!isc.isA.Date(endDate)) {
            //>DEBUG
            this.logWarn("endDate was not in valid date format - using default end date");
            //<DEBUG
            endDate = isc.DateItem.DEFAULT_END_DATE;
        }
        return endDate;
    },
    
    // Override focusInItem to focus in the appropriate sub-item
    focusInItem : function () {
        if (!this.isVisible()) return;

        if (this.useTextField) {
            if (this.dateTextField) this.dateTextField.focusInItem();
        } else {
			var format = this.getSelectorFormat(),

                // Format will be "DMY" / "YMD" / "MDY" / etc.
                // (Parse the string rather than comparing with the DateItem.DAY_MONTH_YEAR class 
                // constants - it's slower but will support the user specifying just "MY" or something)
                firstSelector = format.charAt(0)
            ;
            
            if (firstSelector == "D" && this.daySelector) this.daySelector.focusInItem();
            if (firstSelector == "M" && this.monthSelector) this.monthSelector.focusInItem();
            if (firstSelector == "Y" && this.yearSelector) this.yearSelector.focusInItem();
        }
        // If it couldn't find the appropriate sub-item, this method is a no-op        
    },

	//>	@method	dateItem.getDayOptions()	(A)
	//		Return the list of options for the day selector.
	//
	//		@return	(array)	Array of day numbers from 1-31;
	//<
	getDayOptions : function () {

        var startDate = this.getStartDate(),
            endDate = this.getEndDate();

        // If the date range spans more than one month, return [1 - 31]
        //  - Even if they are less than a month apart
        //  (startDate = March 30th and endDate = April 6th (Same Year), for example)
        //  we don't want to return [1,2,3,4,5,6,30,31], as this will look wierd in the selector, 
        //  and allow you to select dates outside the range anyway (the March 1st, etc.)
        //  - Only time we want to have this return a range smaller than 1-31 is if we have a range
        //  within a single month (Feb 2 - 20th, 1945), for example.
        var startDay = 1, 
            endDay = 31;
        
        // If it's within a single month in a year, return appropriate subset of days    
        if (startDate.getYear() == endDate.getYear() &&
            startDate.getMonth() == endDate.getMonth()) {
                startDay = startDate.getDate()
                endDay = endDate.getDate()
        }
            
		// if the list of options is already in the mapCache, just pull it from there
		var key = "day." + startDay + "." + endDay;
		if (isc.DateItem.mapCache[key]) return isc.DateItem.mapCache[key];

		// otherwise build the options and store it in the dayMapCache
		var options = isc.DateItem.mapCache[key] = [];
		for (var i = startDay; i <= endDay; i++) options[i - startDay] = i;

		return options;	
	},
	
	//>	@method	dateItem.getMonthOptions()	(A)
	//		Return the list of options for the month selector.
	//
	//		@return	(array)	Object of month number (0-based!) to short month name ["Jan","Feb",...]
	//<
	getMonthOptions : function () {

        var startDate = this.getStartDate(),
            endDate = this.getEndDate();
            
        // If the date range spans more than one year, return ["Jan" - "December"]
        //  - Even if they are less than a year apart
        //  (startDate in December 1995, and endDate in February 1996, for example)
        //  we don't want to return ["Jan", "Feb", "Dec"], as this will look wierd in the selector, 
        //  and allow you to select dates outside the range anyway ("Feb, 1995", for example)
        //  - Only time we want to have this return an incomplete range is if we have a range
        //  within a single year (Feb - April, 1945), for example.
        var startMonth = 0, 
            endMonth = 11;

        // If it's within a single month in a year, return appropriate subset of days    
        if (startDate.getYear() == endDate.getYear()) {
                startMonth = startDate.getMonth()
                endMonth = endDate.getMonth()
        }
    
		// if the list of options is already in the mapCache, just pull it from there
		var key = "month." + startMonth + "." + endMonth;
		if (isc.DateItem.mapCache[key]) return isc.DateItem.mapCache[key];

		// otherwise build the options and store it in the dayMapCache
		var options = isc.DateItem.mapCache[key] = {};

		// get the list of names as an array
		var monthNames = Date.getShortMonthNames();
		// and convert it to an object
		for (; startMonth <= endMonth; startMonth++) {
			options[startMonth] = monthNames[startMonth];
		}

		return options;	
	},
	
	//>	@method	dateItem.getYearOptions()	(A)
	//		Return the list of options for the year selector.
	//
	//		@return	(array)	Array of day numbers from this.startYear - this.endYear;
	//<
	getYearOptions : function () {

        var startYear = this.getStartDate().getFullYear(),
            endYear = this.getEndDate().getFullYear();

		// if the list of options is already in the mapCache, just pull it from there
		var key = "year." + startYear + "." + endYear;
		if (isc.DateItem.mapCache[key]) return isc.DateItem.mapCache[key];

		// otherwise build the options and store it in the dayMapCache
		var options = isc.DateItem.mapCache[key] = [];
        for (var i = startYear; i <= endYear; i++) {
			options[i-startYear] = i;
		}
		return options;	
	},

	
	//>	@method	dateItem.parseDate()
	// Parse a date passed in as a string.
	//		@group	elements
	//
	//		@param	dateString (string)     date value as a string
    //      @param  inputFormat   (DateInputFormat) format for date strings to be parsed
	//
	//		@return	(date)		date value
	//<
	parseDate : function (dateString, inputFormat) {
        if (inputFormat == null) inputFormat = this.inputFormat;        
		return Date.parseInput(dateString, inputFormat, this.centuryThreshold, true);
	},
    

    // Methods effecting the dateChooser
    
    getPickerIcon : function (a,b,c,d) {
        var icon = this.invokeSuper(isc.DateItem, "getPickerIcon", a,b,c,d);
        if (icon.prompt == null) icon.prompt = this.pickerIconPrompt;
        return icon;
    },
    
    // override 'showPicker' - instead of creating a picker instance we're reusing a shared
    // one.
    showPicker : function () {

        if (!this.picker) this.picker = isc.DateChooser.getSharedDateChooser();
        var picker = this.picker;
        
        var oldItem = picker.callingFormItem;
        if (oldItem != this) {
            if (oldItem) oldItem.ignore(picker, "dataChanged");
            this.observe(picker, "dataChanged", "observer.pickerDataChanged(observed)");
            
            picker.callingFormItem = this;
            picker.callingForm = this.form;
        }
        
        return this.Super("showPicker", arguments);
        
    },
    
    // custom code to center the picker over the picker icon
    getPickerRect : function () {
        // we want the date chooser to float centered over the picker icon.
        var left = this.getPageLeft(),
            top = this.getPageTop(),
            
            chooserWidth = isc.DateItem.chooserWidth + 3,
            chooserHeight = isc.DateItem.chooserHeight + 3;

        left += (this.getVisibleWidth() - (this.getPickerIconWidth() /2)) - 
                (chooserWidth/2);
        
        top += (this.getPickerIconHeight() / 2) - (chooserHeight/2);

        // NOTE: don't return chooserWidth/Height as part of the rect, which would cause the
        // picker to actually be resized to those dimensions, and they may match the natural
        // size at which the chooser draws given skinning properties.
        return [left, top];
    },
    

	//>	@method	dateItem.pickerDataChanged()
    //      Store the date passed in, and fire the change handler for this item.
    //      Called when the user selects a date from the date-chooser window.  
    //  @visibility internal
	//<
	pickerDataChanged : function (picker) {

        var date = picker.getData();
        var year = date.getFullYear(),
            month = date.getMonth(),
            day = date.getDate();

        // avoid firing 'updateValue' while setting the values of sub items
        this._suppressUpdates = true;

        if (this.useTextField) {
            this.dateTextField.setValue(date.toShortDate(this.displayFormat));
        } else {
            if (this.yearSelector) this.yearSelector.setValue(year);
            if (this.monthSelector) this.monthSelector.setValue(month);
            if (this.daySelector) this.daySelector.setValue(day);
        }
        this._suppressUpdates = false;
        
        // Explicitly call 'updateValue' to save the new date (handles firing change
        // handlers, etc. too)
        this.updateValue();
        
        // Ensure we have focus
        
        if (!this.hasFocus) this.focusInItem();
	}

    //>EditMode dynamically changing useTextField
    , 
    propertyChanged : function (propertyName) {
        if (propertyName == "useTextField") this.setItems();
    }
    //<EditMode
});

}
