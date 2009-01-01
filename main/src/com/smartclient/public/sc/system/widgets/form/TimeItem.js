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

 




//>	@class TimeItem
//
// Class for editing times in a text field. Values are stored as <code>Date</code> objects.
//
// @visibility external
// @example timeItem
//<
isc.ClassFactory.defineClass("TimeItem", "TextItem");
isc.TimeItem.addClassProperties({
	DEFAULT_TIME:"00:00:00"
});

isc.TimeItem.addProperties({
    // We perform validation on change - the string typed by the user (EG :1pm) is converted
    // to a valid date, and redisplayed in the correct time format (EG 1:00 pm).
    // We don't want this to occur until blur since otherwise partially typed strings will get
    // converted
	changeOnBlur:true,
    changeOnKeypress:false,
    
	width:100,
    
    //> @attr timeItem.displayFormat (timeFormatter: "toShort24HourTime" : IRW)
    // What format should this item's time string be presented in?
    // @visibility external
    //<
	displayFormat:"toShort24HourTime",
    
    // Note: we don't have an inputFormat (as we do with DateItems).
    // Time strings are not ambiguous like dates, and our time parsing function deals 
    // with essentially time format the user is likely to enter.
    
    //> @attr timeItem.allowEmptyValue (boolean : true : IRW)
    // If true, this time item supports empty values when cleared out    
    //<
    // Not clear whether we should mark this visibility external
    allowEmptyValue:true
    
});


isc.TimeItem.addMethods({

    short24TimeFormat:"HH:MM",
    shortTimeFormat:"HH:MM [am|pm]",
    long24TimeFormat:"HH:MM:SS",
    longTimeFormat:"HH:MM:SS [am|pm]",
    //>@method timeItem.getHint()
    // If <code>this.hint</code> is specified, display it as a hint. Otherwise a string display 
    // the format of the time string, based on <code>this.displayFormat</code>.
    // Developer may set a <code>hint</code> value or override this method to show a different
    // hint value.
    //<
    getHint : function () {
        if (!this.showHint) return "";
        if (this.hint != null) return this.hint;
        var formatter = this.displayFormat;
        return (formatter == "to24HourTime" ? this.long24TimeFormat :
                (formatter == "toTime" ? this.longTimeFormat : 
                  (formatter == "toShort24HourTime" ? this.short24TimeFormat : 
                    (formatter == "toShortTime" ? this.shortTimeFormat : "")
                  )
                )
               );
    },
	
	//>	@method	timeItem.getDefaultValue()	(A)
    //  If no default value is set for this item, and <code>this.allowEmptyValue</code> is false
    //  this method will create a default time value based on TimeItem.DEFAULT_TIME
	//		@group	defaults    
	//		@return	(Time)	default Time value
	//<
    getDefaultValue : function () {
    
        var defaultValue = this.defaultValue;
        if (!defaultValue && !this.allowEmptyValue) defaultValue = isc.TimeItem.DEFAULT_TIME;
        if (defaultValue && !isc.isA.Date(defaultValue)) 
            defaultValue = isc.Time.parseInput(defaultValue);   

        return defaultValue;
	},
    
	//>	@method	timeItem.mapValueToDisplay()	(A)
    // Maps this items value (a date) to a formatted string to display. Uses one of the
    // Time class's formatters to perform the conversio
	//		@group	drawing
	//		@param	value		(date|null)	value of this item
	//		@return	(string)	Time value as a formatted time string
	//<
	mapValueToDisplay : function (value) {
        if (this.allowEmptyValue && value == null) return isc.emptyString;

        if (!isc.isA.Date(value)) value = isc.Time.parseInput(value);
        return isc.Time.format(value, this.displayFormat);
	},
	
	//>	@method	timeItem.mapDisplayToValue()	(A)
	//  Maps the string displayed in this item to a Date object with the appropriate time,
    //  using the Time class's formatters.
	//		@group	drawing
    //		@param	value   (string)	String value stored in the form field.
	//		@return	(date|null)	Date value to store with the appropriate time set.
	//<
	mapDisplayToValue : function (value) {
        if (isc.isAn.emptyString(value) && this.allowEmptyValue) value = null;
		else {
            // Returns a date instance
            value = isc.Time.parseInput(value);
        }
		return value;
	},

    // Override updateValue to ensure that the value displayed in the element matches the 
    // saved value, and is formatted correctly.
    updateValue : function () {
        // This will map the value to a valid date
        this.Super("updateValue", arguments);
        // This will update the displayed string so its formatted correctly
        this.setElementValue(this.mapValueToDisplay(this.getValue()));
    },
    
    // Override setValue() - if passed a string, map it to the appropriate date before saving
    // (this is required since the string passed in won't go through 'mapDisplayToValue')
    setValue : function (newValue) {
        if (isc.isA.String(newValue)) newValue = isc.Time.parseInput(newValue);
        return this.Super("setValue", [newValue]);
    },
    
    // Override compareValues - we want to compare date values as times
    compareValues : function (value1, value2) {
        if (value1 == value2) return true;
        if (isc.isA.Date(value1) && isc.isA.Date(value2) && 
             isc.Time.compareTimes(value1, value2)) return true;
            
        return false;
    }
  

});

