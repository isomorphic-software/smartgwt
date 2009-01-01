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

 





//>	@class	FormItem
//
// An Item that can participate in a DynamicForm, managing some value.
// <P>
// FormItems are never directly created, instead, FormItem descriptors are passed to a
// DynamicForm.  See the +link{DynamicForm} documentation for details.
//
// @treeLocation Client Reference/Forms/Form Items
// @visibility external
//<
// XXX this should be a subclass of "TableItem" or something else that understands width,
// height, rowSpan, colSpan et al, but is not necessary a form item, to allow the form layout
// code to be factored out and used elsewhere.
isc.ClassFactory.defineClass("FormItem");



// Copy across the canvas method to generate DOM IDs for the various elements we will be
// creating
isc.FormItem.addMethods({_getDOMID:isc.Canvas.getPrototype()._getDOMID});

isc.FormItem.addClassMethods({
    
    //> @classMethod FormItem.create()
    // FormItem.create() should never be called directly, instead, create a +link{DynamicForm}
    // and specify form items via +link{DynamicForm.items,form.items}.
    //
    // @visibility external
    //<
    // Log a warning if called directly
    create : function (A,B,C,D,E,F,G,H,I,J,K,L,M) {
        this.logWarn(
            "Unsupported call to " + this.getClassName() + ".create(). FormItems must be created " +
            "by their containing form. To create form items, use the 'items' property of a DynamicForm " +
            "instance. See documentation for more details."
        );
        // If we're passed properties combine them into a single raw object - if this is then
        // assigned to a form's "items" attribute the developer will likely get the expected
        // behavior.
        // (No need to call Super)
        return isc.addProperties({}, A,B,C,D,E,F,G,H,I,J,K,L,M);
    },

    // getNewTagID() -- a method to broker out IDs for the form element tags, if no name is
    // specified for the form element
    // (If a name is specified we'll use that instead)
    getNewTagID : function () {
        if (this._currentTagIDNumber == null) this._currentTagIDNumber = 0;
        this._currentTagIDNumber += 1;
        return "isc_FormItemElement_ID_" + this._currentTagIDNumber;
    },
    
    // setElementTabIndex()
    // Given a DOM element (a form item element), and a tabIndex, update the tabIndex on
    // the appropriate element.
    setElementTabIndex : function (element, tabIndex) {
        // Set the tabIndex property on the element
        element.tabIndex = tabIndex;
        
        // In mozilla setting a tabIndex to -1 is not sufficient to remove it from the
        // page's tab order -- update the 'mozUserFocus' property as well to achieve this
        // if we're passed a desired tabIndex less than zero (or revert this property if
        // necessary from a previous exclusion from the page's tab order)
        
        if (isc.Browser.isMoz) {
            element.style.MozUserFocus = (tabIndex < 0 ? "ignore" : "normal");
        }
    },
    
    
    
    _aboutToFireNativeElementFocus : function (item) {
        if (!isc.Browser.isIE) return;
        var activeElement = this.getActiveElement();
        
        if (activeElement && activeElement.tagName == null) activeElement = null;
        
        // Note: this will work for elements in the DOM that are not part of ISC form items.
        if (activeElement && 
            ((activeElement.tagName.toLowerCase() == this._inputElementTagName && 
              activeElement.type.toLowerCase() == this._textElementType) || 
              activeElement.tagName.toLowerCase() == this._textAreaElementTagName)) 
        {
            // IE proprietary API
            var range = activeElement.createTextRange();
            range.execCommand("Unselect");
        }
    },
    

    // Helper method to determine if the item passed in is text based
    _textBasedItem : function (item, checkForPopUp) {
        if (isc.isA.FormItem(item)) item = item.getClassName();
        
        if (!this._textClassNames) {
            this._textClassNames = {
                text:true,
                TextItem:true,
                textItem:true,
                textArea:true,
                TextAreaItem:true,
                textAreaItem:true
            }
            this._popUpClassNames = {
                popUpTextArea:true,
                PopUpTextAreaItem:true,
                popUpTextAreaItem:true
            }
        }
        
        return this._textClassNames[item] || (!checkForPopUp || this._popUpClassNames[item]);
    },
    
    // Native handlers to be applied to elements written into the DOM
    // --------------------------------------------------------------------------------------
    
    // Focus/blur handelers to be applied to Form item elements.
    // Applied directly to the element, so we need to determine which item we are a part of
    // and call the appropriate focus/blur handler method on that item.
    _nativeFocusHandler : function () {
        
        //!DONTCOMBINE
        if (!window.isc || !isc.DynamicForm) return;
        var element = this,
            itemInfo = isc.DynamicForm._getItemInfoFromElement(element),
            item = itemInfo.item;
        
        
        if (item && item.isDisabled()) {
            element.blur();        
            return;
        }
            
        if (item) {
            return item._nativeElementFocus(element, item);
        }
    },
    
    _nativeBlurHandler : function () {
        // Check for blur being fired on page unload (when the isc object is out of scope)
        //!DONTCOMBINE
        if (!window.isc) return;
        var element = this,
            itemInfo = isc.DynamicForm._getItemInfoFromElement(element),
            item = itemInfo.item;
            if (item && item.hasFocus) {
                return item._nativeElementBlur(element, item);
            }
    },
    
    // IE specific handler for oncut / onpaste
    _nativeCutPaste : function () {
        if (!window.isc) return;
        var element = this,
            itemInfo = isc.DynamicForm._getItemInfoFromElement(element),
            item = itemInfo.item;
        if (item && item.hasFocus) {
            return item._nativeCutPaste(element, item);
        }
    },
    
    // For some form items we make use of the native onchange handler.
    // This is a single function that will be applied directly to elements as a change handler
    // Currently used by the nativeSelectItem class and the checkboxItem class
    _nativeChangeHandler : function () {
        
        //!DONTCOMBINE
        if (!window.isc || !isc.DynamicForm) return;
            
        var element = this,
            itemInfo = isc.DynamicForm._getItemInfoFromElement(element),
            item = itemInfo.item;
        if (item) return item._handleElementChanged();
    },
    
    
    // Focus / blur handlers applied directly to icons
    _nativeIconFocus : function () {
        //!DONTCOMBINE

        var element = this,
            itemInfo = isc.DynamicForm._getItemInfoFromElement(element),
            item = itemInfo.item,
            iconID = itemInfo.overIcon;
        if (item) {
            
            if (item.iconIsDisabled(iconID)) element.blur();
            else return item._iconFocus(iconID, element);
        }
    },
    
    _nativeIconBlur : function () { 
        //!DONTCOMBINE
        if (!window.isc) return;
        
        var element = this,
            itemInfo = isc.DynamicForm._getItemInfoFromElement(element),
            item = itemInfo.item,
            iconID = itemInfo.overIcon;
        if (item && !item.iconIsDisabled(iconID)) return item._iconBlur(iconID, element);
    },

    // Native click handler for icons can just return false. This will cancel navigation.
    // We will fire icon.click() via the standard DynamicForm.handleClick method    
    _nativeIconClick : function () {
        return false;
    },
    
    // Helper method to return a string formatted for display as the title attribute of an
    // error icon.
      
    getErrorPromptString : function (errors, escapeSingleQuotes) {
        var errorString = "";
        if (!isc.isAn.Array(errors)) errors = [errors];
        for (var i =0; i< errors.length; i++) {
            errorString += (i > 0 ? (isc.Browser.isMoz ? "  " : "\n") : "") + errors[i];
        };
        // We typically write this prompt out in an img tag as the title attribute
        // "title='...'" - In this case we need to escape the single quote characters using
        // the HTML character code "&#39;" or it'll terminate the string.
        if (escapeSingleQuotes) errorString = errorString.replace(/'/g, "&#39;");
        return errorString;
    }
});

isc.FormItem.addClassProperties({
    
    _inputElementTagName : "input",
    _textElementType : "text",
    _textAreaElementTagName : "textarea"
});

isc.FormItem.addProperties({

    // Basics
    // ---------------------------------------------------------------------------------------

    //> @type FormItemType
    // DynamicForms automatically choose the FormItem type for a field based on the
    // <code>type</code> property of the field.  The table below describes the default FormItem
    // chosen for various values of the <code>type</code> property.
    // <P>
    // You can also set +link{FormItem.editorType,field.editorType} to the classname of a
    // +link{FormItem} to override this default mapping.
    //
    // @value "text"    Rendered as a +link{class:TextItem}, unless the lenght of the field (as
    // specified by +link{attr:dataSourceField.length} attribute) is larger than the value
    // specified by +link{attr:dynamicForm.longTextEditorThreshold}, a
    // +link{class:TextAreaItem} is shown.
    //
    // @value "boolean"  Rendered as a +link{class:CheckBoxItem}
    //
    // @value "integer"  Same as <code>text</code> by default.  
    //                   Consider setting editorType:+link{SpinnerItem}.
    // @value "float"    Same as <code>text</code> by default.  
    //                   Consider setting editorType:+link{SpinnerItem}.
    // @value "date"     Rendered as a +link{class:DateItem}
    // @value "time"     Rendered as a +link{class:TimeItem}
    // @value "enum"     Rendered as a +link{class:SelectItem}.  Also true for any field that
    //                   specifies a +link{formItem.valueMap}.  
    //                   Consider setting editorType:+link{ComboBoxItem}.
    // @value "sequence" Same as <code>text</code>
    // @value "link"     If +link{dataSourceField.canEdit}<code>:false</code> is set on the field,
    // the value is rendered as a +link{class:LinkItem}.  Otherwise the field is rendered as a
    // +link{class:TextItem}.
    //
    // @value "image"    
    // @value "imageFile"
    // @value "binary"   Rendered as a +link{class:UploadItem}
    //
    // @see attr:FormItem.type
    // @see type:FieldType
    // @visibility external
    //<
    
    //> @attr formItem.type (FormItemType : "text" : [IR])
    // The DynamicForm picks a field renderer based on the type of the field (and sometimes other
    // attributes of the field).
    //
    // @see type:FormItemType
    // @see type:FieldType
    // @group appearance
    // @visibility external
    //< 

    //> @attr formItem.editorType (FormItem class : null : [IR])
    // Name of the FormItem to use for editing, eg "TextItem" or "SelectItem".
    // <P>
    // The type of FormItem to use for editing is normally derived automatically from
    // +link{formItem.type,field.type}, which is the data type of the field, by the rules
    // explained +link{type:FormItemType,here}.
    //
    // @see type:FormItemType
    // @see type:FieldType
    // @group appearance
    // @visibility external
    //<

    //> @attr formItem.name              (identifier : null : IRW)
	// Name for this form field.
    // <br><br>
    // The FormItem's name determines the name of the property it edits within the form.
    // 
    // @group basics
    // @visibility external
    //<

    //> @attr formItem.title             (String : null : IRW)
	// User visible title for this form item.
    // 
    // @group basics
    // @visibility external
    //<    

    //> @attr formItem.defaultValue       (any : null : IRW)
	// Value used when no value is provided for this item. Note that whenever this item's value
    // is cleared by the user or set to <code>null</code> programatically, it will be reverted
    // to the <code>defaultValue</code>. Developers should use the +link{DynamicForm.values} 
    // object if their intention is to provide an initial value for a field in a form rather 
    // than a value to use in place of <code>null</code>.
    // 
    // @see method:defaultDynamicValue
    // @group basics
    // @visibility external
    // @example fieldEnableDisable
    //<
    

    //> @attr formItem.ID (identifier : null : IRW)
	// Global identifier for referring to the formItem in JavaScript.  The ID property is
    // optional if you do not need to refer to the widget from JavaScript, or can refer to it
    // indirectly (for example, via <code>form.getItem("<i>itemName</i>")</code>).
    // <P>
    // An internal, unique ID will automatically be created upon instantiation for any formItem
    // where one is not provided.
    //
    // @group basics
    // @visibility external
    //<

    //> @attr formItem.emptyDisplayValue (string : "" : IRW)
    // Text to display when this form item has a null or undefined value.
    //
    // @group display_values
    // @visibility external
    //<
    emptyDisplayValue:"",
    
    
    // ValueMap
	// -----------------------------------------------------------------------------------------
        
	//>	@attr formItem.valueMap		(Array or Object: null : IRW)
    // In a form, valueMaps are used for FormItem types that allow the user to pick from a
    // limited set of values, such as a SelectItem.  The valueMap can be either an Array of
    // legal values or an Object where each property maps a stored value to a user-displayable
    // value.
    // <P>
    // To set the initial selection for a form item with a valueMap, use
    // +link{formItem.defaultValue}.
    // <P>
    // See also +link{dataSourceField.valueMap}.
    // 
	// @group valueMap
    // @visibility external
	//<
    
    // optionDataSource
    // ----------------------------------------------------------------------------------------

    //> @attr    FormItem.optionDataSource        (DataSource | String : null : IR)
	// If set, this FormItem will map stored values to display values as though a
    // +link{valueMap} were specified, by fetching records from the 
    // specified <code>optionDataSource</code> and extracting the
    // +link{formItem.valueField,valueField} and 
    // +link{formItem.displayField,displayField} in loaded records, to derive one
    // valueMap entry per record loaded from the optionDataSource.
    // <P>
    // Fetches will be initiated against the optionDataSource any time the FormItem has a
    // non-null value and no corresponding display value is available.  This includes when the
    // form is first initialized, as well as any subsequent calls to
    // +link{formItem.setValue()}, such as may happen when +link{DynamicForm.editRecord()} is
    // called.  Retrieved values are automatically cached by the FormItem.
    // <P>
    // Note that if a normal, static +link{formItem.valueMap,valueMap} is <b>also</b> specified for
    // the field (either directly in the form item or as part of the field definition in the
    // dataSource), it will be preferred to the data derived from the optionDataSource for
    // whatever mappings are present.
    // <P>
    // In a databound form, if +link{FormItem.displayField} is specified for a FormItem and 
    // <code>optionDataSource</code> is unset, <code>optionDataSource</code> will default to
    // the form's current DataSource 
    //
    // @group display_values
    // @visibility external
    // @getter FormItem.getOptionDataSource()
    // @example listComboBox
    //<
    
    //> @attr    FormItem.valueField  (string : null : IR)
    // If this form item maps data values to display values by retrieving the 
    // +link{FormItem.displayField} values from an 
    // +link{FormItem.optionDataSource,optionDataSource}, this property 
    // denotes the the field to use as the underlying data value in records from the 
    // optionDataSource.<br>
    // If unset, assumed to be the +link{FormItem.name} of this form item.
    // @group display_values
    // @visibility external
    // @getter FormItem.getValueFieldName()
    //<
    
    //> @attr   FormItem.displayField   (string : null : IR) 
    // Specifies an alternative field from which display values should be retrieved for this
    // item.<br>
    // If this item is not databound (+link{FormItem.optionDataSource} is unset), or bound 
    // to the same dataSource as the form as a whole, this is implemented by picking up the
    // value of the specified field from the Form's values object.<br>
    // Otherwise this item will attempt to map its underlying value to a display value
    // by retrieving a record from the +link{FormItem.optionDataSource} where the 
    // +link{FormItem.valueField} matches this item's value, and displaying the 
    // <code>displayField</code> value from that record.<br>
    // This essentially enables the specified <code>optionDataSource</code> to be used as
    // a server based +link{group:valueMap}.
    // @group display_values
    // @visibility external
    // @getter FormItem.getDisplayFieldName()
    //<
    
    //> @attr FormItem.fetchMissingValues   (boolean : true : IRWA)
    // If +link{FormItem.displayField} is specified for this item, should the item 
    // perform a fetch on the +link{FormItem.optionDataSource} to retrieve the display value
    // for the item when +link{FormItem.setValue()} is called with a value for which we
    // do not already have a mapped display value?
    // @group display_values
    // @visibility external
    //<
    fetchMissingValues:true,
    
    //> @attr FormItem.filterLocally (boolean : null : IRA)
    // If this form item is mapping data values to a display value by fetching them from a 
    // dataSource (see +link{FormItem.optionDataSource}, +link{FormItem.displayField} 
    // and +link{FormItem.fetchMissingValues}), setting this property to true ensures that when
    // the form item value is set, entire data-set from the dataSource is loaded at once and 
    // used as a valueMap, rather than just loading the display value for the current value.
    // This avoids the need to perform fetches each time setValue() is called with a new value.
    // <br>
    // See also +link{PickList.filterLocally} for behavior on form items such as SelectItems
    // that show pick-lists.
    //
    // @group display_values
    // @visibility external
    //<
        
    // Data Type Formatters
    // ---------------------------------------------------------------------------------------
    // Note: dateFormatter and timeFormatter provide a way to control format of date or 
    // time data in a generic form item such as a static text item.
    // Consistent name with ListGrid.dateFormatter / timeFormatter
    
    //>	@attr   formItem.dateFormatter  (DateDisplayFormat : null : [IRWA])
    // Display format to use for date type values within this formItem. Default is to use the
    // system-wide default short date format, configured via
    // +link{Date.setShortDisplayFormat()}.  Specify any valid +link{type:DateDisplayFormat} to 
    // change the format used by this item.<br>
    // Note: if both <code>dateFormatter</code> and +link{formItem.timeFormatter, timeFormatter}
    // are specified on an item, Date type values will be formatted as dates using 
    // <code>dateFormatter</code>.<br>
    // See also +link{DateItem.displayFormat} for formatting dates displayed in DateItems.
    // 
	// @group appearance
    // @visibility external
	//<
    //dateFormatter:null
    
    //>	@attr   formItem.timeFormatter  (TimeFormatter : null : [IRWA])
    // Time-format to apply to date type values within this formItem.  If specified, any
    // dates displayed in this item will be formatted as times using the appropriate format.<br>
    // Has no effect if +lilnk{formItem.dateFormatter} is also set.<br>
    // See also +link{TimeItem.displayFormat} for formatting values displayed in TimeItems.
    // 
	// @group appearance
    // @visibility external
	//<
    //timeFormatter:null
    
    // ValueIcons
    // ---------------------------------------------------------------------------------------
    //> @attr formItem.valueIcons   (Object : null : IRW)
    // A mapping of logical form item values to URLs.
    // If specified, when the form item is set to the value in question, an icon will be 
    // displayed with the appropriate source URL.
    // @group   valueIcons
    // @setter  formItem.setValueIcons()
    // @see     formItem.getValueIcon()
    // @visibility external
    //<

    //> @attr formItem.emptyValueIcon (string : null : IRW)
    // This property allows the developer to specify an icon to display when this item has
    // no value. It is configured in the same way as any other valueIcon 
    // (see +link{formItem.valueIcons})
    // @group valueIcons
    // @visibility external
    //<
    
    //> @attr formItem.showValueIconOnly (boolean : null : IRWA) 
    // If +link{FormItem.valueIcons} is set, this property may be set to show the valueIcon
    // only and prevent the standard form item element or text from displaying
    // @group valueIcons
    // @visibility external
    //<
    //> @attr formItem.suppressValueIcon (boolean : null : IRWA)
    // If +link{FormItem.valueIcons} is set, this property may be set to prevent the value
    // icons from showing up next to the form items value
    // @group valueIcons
    // @visibility external
    //<
    
    //> @attr formItem.valueIconWidth (number : null : IRW)
    // If +link{formItem.valueIcons} is specified, use this property to specify a width for
    // the value icon written out.
    // @see FormItem.valueIconHeight
    // @see FormItem.valueIconSize
    // @group valueIcons
    // @visibility external
    //<
    
    //> @attr formItem.valueIconHeight (number : null : IRW)
    // If +link{formItem.valueIcons} is specified, use this property to specify a height for the
    // value icon written out.
    // @see FormItem.valueIconWidth
    // @see FormItem.valueIconSize
    // @group valueIcons
    // @visibility external
    //<
    
    //> @attr formItem.valueIconSize (number : 16 : IRW)
    // If +link{formItem.valueIcons} is specified, this property may be used to specify both
    // the width and height of the icon written out.
    // Note that +link{FormItem.valueIconWidth} and +link{formItem.valueIconHeight} take
    // presidence over this value, if specified.
    // @see FormItem.valueIconWidth
    // @see FormItem.valueIconHeight
    // @group valueIcons
    // @visibility external
    //<
    valueIconSize:16,

    //> @attr formItem.valueIconLeftPadding (number : 0 :  IRW)
    // If we're showing a value icon, this attribute governs the amount of space between the 
    // icon and the left edge of the form item cell
    // @see FormItem.valueIcons
    // @visibility external
    // @group valueIcons
    //<
    valueIconLeftPadding:0,

    //> @attr formItem.valueIconRightPadding (number : 3 :  IRW)
    // If we're showing a value icon, this attribute governs the amount of space between the 
    // icon and the label of the form item
    // @see FormItem.valueIcons
    // @visibility external
    // @group valueIcons
    //<
    valueIconRightPadding:3,                           
                                       
    //> @attr formItem.imageURLPrefix (string : null : IRWA)
    // Prefix to apply to the beginning of any +link{FormItem.valueIcons} when determining the
    // URL for the image.
    // Will not be applied if the <code>valueIcon</code> URL is absolute.
    // @group valueIcons
    // @visibility external
    //<

    //> @attr formItem.imageURLSuffix (string : null : IRWA)
    // Suffix to apply to the end of any +link{FormItem.valueIcons} when determining the URL for
    // the image. A common usage would be to specify a suffix of <code>".gif"</code> in which
    // case the <code>valueIcons</code> property would map values to the names of images without
    // the <code>".gif"</code> extension.
    // @group valueIcons
    // @visibility external
    //<
            
    // Internal
    // ---------------------------------------------------------------------------------------

    //> @attr formItem.form     (DynamicForm : null : R)
	// A Read-Only pointer to this formItem's DynamicForm widget.
    // @visibility external
    //<
    // Handles values for the form item.  Also handles writing the item's HTML by default.
    
    //> @attr formItem.containerWidget  (Canvas : null : R)
	// A pointer to this formItem's "ContainerWidget".  This is the widget that handles writing
    // the HTML for the FormItem into the DOM.  By default this will be the DynamicForm 
    // widget containing this form item.
    // 
    // @visibility internal
    //<    
    

    // RelationItem
    // ---------------------------------------------------------------------------------------
    
   	//> @attr	formItem.dataSource		(DataSource or String : null : [IRWA])
    //
    // If this FormItem represents a foreignKey relationship into the dataSource of the form
    // containing this item, specify it here.
    //
    //  @visibility experimental
	//<


    // Picker
	// -----------------------------------------------------------------------------------------
    
    //> @attr formItem.showPickerIcon (boolean : false : [IRW])
    // Should we show a special 'picker' icon for this form item. Picker icons are customizeable
    // via +link{FormItem.pickerIconProperties}. By default they will be rendered inside the 
    // Form Item's "control box" area, and will call +link{FormItem.showPicker()} when clicked.
    //
    // @visibility pickerIcon
    //<
    
    //> @attr formItem.showFocusedPickerIcon (boolean : false : [IRW])
    // If +link{FormItem.showPickerIcon} is true for this item, should the picker icon show
    // a focused image when the form item has focus?
    // @visibility pickerIcon
    //<
    showFocusedPickerIcon:false,
    
    // We draw the icon into an exactly sized table cell - don't draw with any margin
    
    pickerIconHSpace:0,
    
    //> @attr formItem.pickerIconDefaults (object : null : [IRWA])
    // Block of default properties to apply to the pickerIcon for this widget.
    // Intended for class-level customization: To modifying this value we recommend using
    // +link{isc.changeDefaults()} rather than directly assigning a value to the property.
    // @visibility pickerIcon
    //< 
    
    //> @attr formItem.pickerIconProperties (object : null : [IRWA])
    // If +link{formItem.showPickerIcon} is true for this item, this block of properties will
    // be applied to the pickerIcon. Allows for advanced customization of this icon.
    // @visibility pickerIcon
    //<
    
    //>@attr formItem.pickerIconSrc   (string : "" : [IRWA])
    // If +link{formItem.showPickerIcon} is true for this item, this property governs the
    // src of the picker icon image to be displayed.
    // @visibility pickerIcon
    //<
    pickerIconSrc:"[SKIN]/DynamicForm/pickerIcon.gif",
    
    //> @attr formItem.pickerIconWidth (number : null : [IRWA])
    // If +link{formItem.showPickerIcon} is true for this item, this property governs the
    // size of the picker icon. If unset picker icon will be sized as a square to fit in the
    // avaliable height for the icon.
    // @visibility pickerIcon
    //<
        
    //> @attr formItem.pickerIconHeight (number : null : [IRWA])
    // If +link{formItem.showPickerIcon} is true for this item, this property governs the
    // size of the picker icon. If unset picker icon will be sized as a square to fit in the
    // avaliable height for the icon.
    // @visibility pickerIcon
    //<
    
   	//> @attr	formItem.picker		(Canvas : null : [IRW])
    //
    // This is the component that will be displayed when formItem.showPicker() is called.  This is a
    // a component that helps a user pick a value or set of values.  If not specified, one will be
    // created using the default configuration.  See +link{attr:FormItem.pickerConstructor}
    // and +link{attr:FormItem.pickerProperties}
    //
    //  @visibility experimental
	//<

   	//> @attr	formItem.pickerConstructor		(String : null : [IRW])
    //
    // Class name of the picker to be created.
    //
    //  @visibility experimental
	//<
    
  	//> @attr	formItem.pickerProperties		(Object : {} : [IRW])
    //
    // Default properties for the picker.
    //
    //  @visibility experimental
	//<
    
    //

    // Validation
	// -----------------------------------------------------------------------------------------

    //> @attr   formItem.validators     (Array of Validator : null : IR)
    // Validators for this form item.  
    // <P>
    // <b>Note:</b> these validators will only be run on the client; to
    // do real client-server validation, validators must be specified on the DataSource.
    // @visibility external
    //<

    //> @attr   formItem.required       (boolean : false : [IR])
    // Whether a non-empty value is required for this field to pass validation.
    // <BR>
    // <b>Note:</b> if specified on a FormItem, <code>required</code> is only enforced on the
    // client.  <code>required</code> should generally be specified on a
    // +link{class:DataSourceField}.
    //
    // @group validation
    // @visibility external
    // @example formShowAndHide
    //<

    // Status
	// -----------------------------------------------------------------------------------------
    
    //>	@attr	formItem.visible		(boolean : true : IRW)
	// Whether this item is currently visible.
    // <P>
    // <code>visible</code> can only be set on creation.  After creation, use
    // +link{formItem.show()} and +link{formItem.hide()} to manipulate visibility.
    //
	// @group	appearance
    // @visibility external
	//<
	visible:true,

    //>	@attr	formItem.alwaysTakeSpace    (boolean : false : IRW)
	// If this form item is not visible, should they form it is contained in re-layout to
    // take advantage of the additional space, or should it continue to flow as if the
    // item were visible.  Set to true to have the form continue to flow around the item
    // even if it's not written out.
    //
	// @group	appearance
    // @visibility internal
	//<

	//>	@attr	formItem.disabled		(boolean : false : IRW)
	// Whether this item is disabled.  Can be updated at runtime via the <code>setDisabled()</code>
    // method.  Note that if the widget containing this formItem is disabled, the formItem will
    // behave in a disabled manner regardless of the setting of the item.disabled property.
    // <p>
    // Note that not all items can be disabled, and not all browsers show an obvious disabled style
    // for native form elements.
	//		@group	appearance
    //      @setter FormItem.setDisabled()
    //      @see FormItem.setDisabled()
    // @visibility external
    // @example fieldEnableDisable
	//<

    // Keyboard handling
	// -----------------------------------------------------------------------------------------
    
    //>@attr formItem.canFocus  (boolean : null : IRWA)
    // Is this form item focusable? 
    //<
    // If not set focusability is determined by whether this item has a data element by default.
    // If set to true, and this item has no data element we write out HTML to allow focus
    // on the item's text-box.
    
    
    //>	@attr	formItem.accessKey  (keyChar : null : IRW)
    //      AccessKey - a keyboard shortcut to trigger a form item's default behavior.<br>
    //      Note: Alt+ (or in Moz Firefox 2.0 and above, Shift+Alt+) the specified key will 
    //      trigger the form item's default behavior.
    //		@group	focus
    // @visibility external
    //<
    
    accessKey:null,                                        
    
    //>	@attr formItem.tabIndex		(integer : null : IRW)
    // tabIndex for the form item within the form.  Auto-assigned if not specified.<br>
    // Note: This controls the tab order within the form.
    // <P>
    // To specify the tabindex of an item within the page as a whole (not just this form), use
    // globalTabIndex instead.
    //
    //  @visibility external
    //  @group focus
    //<                          
    //tabIndex:null,

    //>	@attr formItem.globalTabIndex		(integer : null : IRWA)
    // TabIndex for the form item within the page. Takes presidence over any local tab index
    // specified as +link{tabIndex,item.tabIndex}.
    //  @visibility external
    //  @group focus
    //<                          
    //globalTabIndex:null,
    
    //> @attr   formItem.selectOnFocus  (boolean : null : IRW)
    // If this property is set to true, whenever this item is given focus programmatically 
    // (see +link{DynamicForm.focusInItem()}), all text within the item will be selected.<br>
    // If false, the selection is not modified on focus - any previous selection within the
    // item will be restored.<br>
    // If unset, this property is derived from +link{DynamicForm.selectOnFocus}
	// @group focus	
    // @visibility internal
	//<
    // Exposed on TextItem and TextAreaItem directly since it won't apply to other items.
    
    //          If defined, this overrides the 'selectOnFocus' behavior for this element.<br>
    //          if true, we select a field upon focusing into it,<br>
    //          if false, we merely place the insertion pointer into the field.<br>
    //          By Default this behavior is defined by the form's 'selectOnFocus' property value.
    //      @group  eventHandling, focus	
    //      @see    attr:dynamicForm.selectOnFocus
    //<
    
    
    //> @attr   formItem.changeOnKeypress   (boolean : true : RW)
    //  Should this form item fire its changeHandler (and store its value in the form) on every
    //  keypress.
    //  Set to false to suppress the 'change' handler fired (and the value stored) on every keypress.
    //  <br>
    //  Note: If false, the value returned by 'getValue()' will not reflect the value displayed in
    //  the form item element as long as focus is in the form item element.
    // 
    //      @group  eventHandling, values
    //<    
    changeOnKeypress:true,
    
    // maintainSelectionOnTransform
    // Internal, but non obfuscated property.
    // Ensure selection is maintained if:
    // - the value is reverted due to a change handler returning false during typing
    // - the value is modified during typing, but either the value is unchanged except for
    //   case shifting, or the entire value was selected before typing.
    // If this causes a performance hit in any cases, we can disable it.
    maintainSelectionOnTransform:true,
    
    
    //> @attr   formItem.dirtyOnKeyDown (boolean : true : RW)
    //  Should this form item get marked as dirty on every keyDown?
    //  @group  eventHandling, values
    //<    
    dirtyOnKeyDown:true, 

    // Titles
	// --------------------------------------------------------------------------------------------
    //>	@attr	formItem.showTitle		(boolean : true : IRW)
	// Should we show a title cell for this formItem?
    // <p>
    // Note: the default value of this attribute is overridden by some subclasses.
    //
	// @group title
    // @visibility external
	//<
	showTitle:true,
    
    //>	@attr	formItem.titleOrientation		(TitleOrientation : isc.Canvas.LEFT : IRW)
    // On which side of this item should the title be placed.  +link{type:TitleOrientation}
    // lists valid options.
    // <P>
    // Note that titles on the left or right take up a cell in tabular
    // +link{group:formLayout,form layouts}, but titles on top do not.
    // 
	// @group title
    // @see DynamicForm.titleOrientation
    // @visibility external
	//<
//	titleOrientation:isc.Canvas.LEFT,	// dynamically defaulted in DynamicForm

	//>	@attr	formItem.titleAlign		(Alignment : null : IRW)
	// Alignment of this item's title in its cell.
    // <p>
	// If null, dynamically set according to text direction.
	// @group title
    // @visibility external
	//<

    //> @attr formItem.clipTitle (boolean : null : [IRW])
    // If the title for this form item is showing, and is too large for the available space
    // should the title be clipped?<br>
    // Null by default - if set to true or false, overrides the <code>clipItemTitles</code> 
    // setting at the DynamicForm level.
    //<
//    clipTitle:null,
    
    //> @attr formItem.wrapTitle (boolean : null : [IRW])
    // If specified determines whether this items title should wrap.
    // Overrides +link{DynamicForm.wrapItemTitles,wrapItemTitles} at the DynamicForm level.
    // @group title
    // @visibility external
    //<
//    wrapTitle:null,

    // Change handling
	// --------------------------------------------------------------------------------------------

	//>	@attr	formItem.redrawOnChange		(boolean : false : IRW)
	// If true, this item will cause the entire form to be redrawn
	// when the item's "elementChanged" event is done firing
	//		@group changeHandling
	//<

	//>	@attr	formItem.validateOnChange	(boolean : false : IRW)
	// If true, form items will be validated when each item's "change" handler is fired
	// as well as when the entire form is submitted or validated.
    // <p>
	// Note that this property can also be set at the form, level;
	// If true at either level the valiator will be fired on change - displaying errors and
    // rejecting the change on validation failure.
	// @group changeHandling
    // @visibility external
    // @see DynamicForm.validateOnChange
	//<	
    

	//>	@attr	formItem.changeOnBlur		(boolean : false : IRWA)
	// If true, this item will fire it's elementChanged message on BLUR in a field (eg: when the
    // user tabs through without making changes as well as when they actually change something), if
    // false, the message will only fire when the field is actually changed.  This is useful for
    // fields that do validation/value setting on change (such as the TimeItem), to work around a
    // bug in IE where the change event doesn't always fire correctly when you manually set the
    // value of the field in its ONCHANGE handler.  Note that it is not recommended that you set
    // both changeOnBlur==true AND redrawOnChange==true, as this will cause the form to redraw every
    // time you tab through that item.
	//		@group changeHandling
	//<
    

    // Size and Layout
	// --------------------------------------------------------------------------------------------
    //>	@attr	formItem.width		(number : "*" : IRW)
	// By default, items take up the entire width of their cell
	// @group formLayout
    // @visibility external
    // @example columnSpanning
	//<
	width:"*",							

    //>	@attr	formItem.height		(number : 20 : IRW)
	// Default height of this item.
	// @group formLayout
    // @visibility external
    // @example formLayoutFilling
	//<
    
	height:20,

    //>	@attr formItem.colSpan		(number : 1 : IRW)
	// Number of columns that this item spans.  
    // <P>
    // The <code>colSpan</code> setting does not include the title shown for items with
    // +link{showTitle}:true, so the effective <code>colSpan</code> is one higher than this
    // setting for items that are showing a title and whose +link{titleOrientation} is either
    // "left" or "right".
    //
	// @group formLayout
    // @visibility external
	//<	
	colSpan:1,

    //>	@attr formItem.rowSpan		(number : 1 : IRW)
	// Number of rows that this item spans
	// @group formLayout
    // @visibility external
	//<
	rowSpan:1,

	//>	@attr formItem.startRow		(boolean : false : IRW)
	// Whether this item should always start a new row in the form layout.
	// @group formLayout
    // @visibility external
	//<
	
	//>	@attr formItem.endRow		(boolean : false : IRW)
	// Whether this item should end the row it's in in the form layout
	// @group formLayout
    // @visibility external
	//<
    
    // The align property is used by the dynamic form to align the item as a whole (control table
    // and all) in its cell.
    // In addition to this we support textAlign to align the contents within the text-box
    
	//>	@attr formItem.align		(Alignment : isc.Canvas.LEFT : IRW)
	// Alignment of this item in its cell
	//		@group	appearance
    // @visibility external
	//<

    //> @attr   formItem.textAlign  (Alignment : isc.Canvas.LEFT : IRW)
    // Alignment of the text / content within this form item
    // @group appearance
    // @visibility external
    //<

	//>	@attr	formItem.left       (integer : 0 : IRWA)
    // Left coordinate of this item in pixels.  Applies only when the containing DynamicForm
    // sets <code>itemLayout:"absolute"</code>.
    // @visibility absForm
	//<

	//>	@attr	formItem.top        (integer : 0 : IRWA)
    // Top coordinate of this item in pixels.  Applies only when the containing DynamicForm
    // sets <code>itemLayout:"absolute"</code>.
    // @visibility absForm
	//<
    
    //>	@attr	formItem.wrap       (boolean : null : IRW)
	// If true, item contents can wrap. If false, all the contents should appear on a single line.
    // @visibility internal
	//<
    
    //>	@attr	formItem.clipValue  (boolean : null : IRW)
    // If true, text that exceeds the specified size of the form item will be clipped    
    // @visibility internal
	//<
    
    

    // AutoComplete
	// --------------------------------------------------------------------------------------------
    //>	@attr	formItem.autoComplete   (AutoComplete : null : IRW)
    // Whether to do inline autoComplete.
    // <p>
    // If unset, defaults to form.autoComplete
    //
    // @see dynamicForm.autoComplete
    // @visibility autoComplete
    //<

    //>	@attr	formItem.uniqueMatch    (boolean : null : IRW)
    // When autoComplete is enabled, whether to offer only unique matches to the user.
    // <p>
    // If unset, defaults to form.uniqueMatch.
    //
    // @see dynamicForm.uniqueMatch
    // @visibility autoComplete
    //<

    //>	@attr	formItem.autoCompleteCandidates (Array : null : IRW)
    // Optional set of candidate completions.
    // <p>
    // If candidates are not specified, the values in the valueMap, if any, will be used, or
    // within a DataBound form, the other values currently present in the loaded portion of the
    // dataset.
    // @visibility autoComplete
    //<

    
    //>@attr    formItem.browserSpellCheck  (boolean : null : IRWA)
    // If this browser supports spell-checking of text editing elements, do we want this
    // enabled for this item? If unset the property will be inherited from the containing form
    // @visibility internal
    //<
    
    //browserSpellCheck:null
    
    // Icons
	// --------------------------------------------------------------------------------------------
    
    //>@attr    formItem.icons      (Array of FormItemIcon Properties : null  : IRW)
    //  An array of descriptor objects for icons to display in a line after this form item.
    //  These icons are clickable images, often used to display some kind of helper for 
    //  populating a form item.
    //  @group formIcons
    //  @see    class:FormItemIcon
    //  @visibility external
    //  @example formIcons
    //<

    //> @attr   formItem.defaultIconSrc      (SCImgURL : "[SKIN]/DynamicForm/default_formItem_icon.gif" : IRWA)
    // Default icon image source.     
    // Specify as the partial URL to an image, relative to the imgDir of this component.
    // To specify image source for a specific icon use the <code>icon.src</code> property.<br>
    // If this item is drawn in the disabled state, the url will be modified by adding 
    // "_Disabled" to get a disabled state image for the icon.
    // If <code>icon.showOver</code> is true, this url will be modified by adding "_Over" to get
    // an over state image for the icon.
    //  @group  formIcons
    //  @visibility external    
    //<
    defaultIconSrc:"[SKIN]/DynamicForm/default_formItem_icon.gif",

    //> @attr   formItem.showOverIcons  (boolean : null : IRWA)
    //  If we're showing icons, should we change their image source to the appropriate <i>over</i>
    //  source when the user rolls over (or puts focus onto) them?  Can be overridden on a per
    //  icon basis by the formItemIcon <code>showOver</code> property.
    //  @group formIcons
    //  @visibility external
    //<
    
    //> @attr   formItem.showFocusedIcons (boolean : null : IRWA)
    //  If we're showing icons, should we change their image source to the appropriate
    //  <i>focused</i>  source when this item has focus?  Can be overridden on a per
    //  icon basis by the formItemIcon <code>showFocused</code> property.
    //  @group formIcons
    //  @visibility external
    //<

    //> @attr   formItem.iconHSpace (number : 3 : IRWA)
    //      Horizontal space (in px) to leave between form item icons
    //  @group  formIcons
    //  @visibility internal
    //<
    iconHSpace:3,         
                                   
    //> @attr   formItem.iconVAlign (VerticalAlignment: "bottom" : [IRWA])
    //      How should icons be aligned vertically for this form item.
    //  @group  formIcons
    //  @visibility external
    //<
    // Options are "top", "center", "bottom" - Implemented via the css 'vertical-alignment'
    // property
    iconVAlign:isc.Canvas.BOTTOM,
      
    //> @attr   formItem.iconHeight (number : 20 : IRWA)
    //      Default height for form item icons
    //  @group  formIcons
    //  @visibility external    
    //<
    iconHeight:20,

    //> @attr   formItem.iconWidth (number : 20 : IRWA)
    //      Default width for form item icons
    //  @visibility external    
    //  @group  formIcons
    //<
    iconWidth:20,

    //> @attr formItem.prompt (string : null : IRW)
    //
    // This text is shown as a tooltip prompt when the cursor hovers over this item.
    //
    // @group basics
    // @visibility external
    //<
    
    // FormItem.implementsPromptNatively:
    // By default we show prompts in an ISC hover. However for some form items we'll write
    // out HTML that will cause a native hover prompt to show up instead. In these cases
    // we suppress the ISC hover
    
    //implementsPromptNatively:false,

    //> @attr   formItem.iconPrompt (string : "" : IRWA)
    //      Default prompt (and tooltip-text) for icons
    //  @group  formIcons
    //<
    
    iconPrompt:"",

    //> @attr   formItem.showIcons (boolean : true : IRWA)
    // Set to false to suppress writing out any +link{formItem.icons} for this item.
    //  @group  formIcons
    //  @visibility external
    //<
    
    showIcons:true,
    
    

    //> @attr   formItem.redrawOnShowIcon (boolean : true : IRWA)
    //      When dynamically showing/hiding icons for this form  item, should we force a
    //      redraw of the entire form?
    //  @group  formIcons
    //<
    
    redrawOnShowIcon:true,
    
    //> @attr   formItem.canTabToIcons  (boolean : null : IRWA)
    //      If set, this property determines if this form item's icons should be included in 
    //      the page's tab order, with the same tabIndex as this form item?<br>
    //      Note that if this form item has tabIndex -1, neither the form item nor the icons
    //      will be included in the page's tab order.
    //  @group  formIcons
    //  @visibility advancedIcons
    //<
    //canTabToIcons:null,
    
    // Validation Error Icon
    // We write out a special icon to indicate validation errors. This will not be part of the
    // icons array but will be rendered using some of the same code.

    //> @attr   formItem.errorIconHeight    (number : 16 : IRW)
    // Height of the error icon, if we're showing icons when validation errors occur.
    // @group  errorIcon
    // @see FormItem.showErrorIcon
    // @visibility external
    //<
    errorIconHeight: 16,
    
    //> @attr   formItem.errorIconWidth    (number : 16 : IRW)
    // Height of the error icon, if we're showing icons when validation errors occur.
    // @group  errorIcon
    // @see FormItem.showErrorIcon
    // @visibility external
    //<    
    errorIconWidth: 16,
    
    //> @attr   formItem.errorIconSrc    (SCImgURL : "[SKIN]/DynamicForm/validation_error_icon.png" : IRW)
    // URL of the image to show as an error icon, if we're showing icons when validation
    // errors occur.
    // @group  errorIcon
    // @see FormItem.showErrorIcon
    // @visibility external
    //<    
    errorIconSrc: "[SKIN]/DynamicForm/validation_error_icon.png",    
    
    //> @attr   formItem.showErrorIcon (boolean : null : IRW)
    // @include dynamicForm.showErrorIcons
    //  @group  errorIcon, validation, appearance
    //  @visibility external
    //<    
    // Note Actually writing this item (and the error text) into the DOM is handled by the
    // Form (or containerWidget) - but this property governs whether we include the icon in the
    // errorHTML we return.
    //showErrorIcon: null,
    
    //> @attr   formItem.showErrorText (boolean : null : IRW)
    // @include dynamicForm.showErrorIcons
    // @group  validation, appearance
    // @visibility external
    //<    
    //showErrorText: null,
    
    //>	@attr	formItem.showErrorStyle     (boolean : null : IRW)
    // @include dynamicForm.showErrorIcons
	// @group validation, appearance
    // @visibility external
    // @see FormItem.cellStyle
    //<    
	//showErrorStyle: null,
    
    //> @attr formItem.errorOrientation (align : null : IRW)
    // If +link{dynamicForm.showInlineErrors} is true, where should the error icon and text appear
    // relative to the form item itself. Valid options are <code>"top"</code>, 
    // <code>"bottom"</code>, <code>"left"</code> or <code>"right"</code>.<br>
    // If unset the orientation will be derived from +link{dynamicForm.errorOrientation}. 
    // @group validation, appearance
    // @visibility external
    //<
    //errorOrientation: null,

    // Define a jsdoc pseudo-class for form item icon descriptor objects.
    // ------

        //>	@object FormItemIcon
        //
        //  Form item icon descriptor objects used by Form Items to specify the appearance and
        //  behavior of icons displayed after the item in the page flow.
        //  
        //  @treeLocation   Client Reference/Forms/Form Items/FormItem
        //  @see attr:FormItem.icons
        //  @group formIcons
        //  @visibility external
        //  @example formIcons
        //<
    
        //> @attr   formItemIcon.src (string : null : IRW)
        //      If set, this property determines this icon's image source.
        //      If unset the form item's <code>defaultIconSrc</code> property will be used
        //      instead.<br>
        //      As with <code>defaultIconSrc</code> this URL will be modified by adding
        //      "_Over" or "_Disabled" if appropriate to show the icons over or disabled state.
        
        //  @group  formIcons
        //  @visibility external
        //  @see    attr:formItem.defaultIconSrc
        //  @example formIcons
        //<

                
        //> @attr   formItemIcon.showOver (boolean : null : IRWA)
        //  Should this icon's image switch to the appropriate "over" source when the user rolls
        //  over or focuses on the icon?   
        //  @group  formIcons
        //  @visibility external
        //  @see    attr:formItem.showOverIcons
        //<

        //> @attr   formItemIcon.showFocused (boolean : null : IRWA)
        // Should this icon's image switch to the appropriate "focused" source when the user puts
        // focus on the form item or icon? 
        // @see formItem.showFocusedIcons
        // @see formItemIcon.showFocusedWithItem
        //  @group  formIcons
        //  @visibility external
        //<
        
        //> @attr   formItemIcon.showFocusedWithItem (boolean : null : IRWA)
        // If this icon will be updated to show focus (see +link{formItemIcon.showFocused}, 
        // +link{formItem.showFocusedIcons}), this property governs whether the focused state should
        // be shown when the item as a whole recieves focus or just if the icon recieves focus.
        // If this property is unset, default behavior is to show focused state when the item
        // recieves focus. 
        // @see formItem.showFocusedIcons
        // @see formItemIcon.showFocused
        // @group  formIcons
        // @visibility external
        //<
        
        //> @attr   formItemIcon.neverDisable (boolean : null : IRWA)
        //  If <code>icon.neverDisable</code> is true, when this form item is disabled, the 
        //  icon will remain enabled. 
        //  Note that disabling the entire form will disable all items, together with their 
        //  icons including those marked as neverDisable - this property only has an effect 
        //  if the form is enabled and a specific item is disabled within it.
        //  @group  formIcons
        //  @visibility external
        //<
    
        //> @method formItemIcon.click()
        //      StringMethod action to fire when this icon is clicked
        //      If unset the form item's <code>iconClick</code> method will be fired instead (if
        //      specified).
        //  @param  form (DynamicForm)  The Dynamic Form to which this icon's item belongs.
        //  @param  item (FormItem)     The Form Item containing this icon
        //  @param  icon (FormItemIcon) A pointer to the form item icon clicked
        //  @group  formIcons
        //  @visibility external
        //  @example formIcons
        //<    

        //> @method formItemIcon.keyPress()
        //      StringMethod action to fire when this icon has focus and recieves a keypress
        //      event.
        //      If unset the form item's <code>iconKeyPress</code> method will be fired instead 
        //      (if specified).
        //  @param  keyName (string)    Name of the key pressed
        //  @param  character (character) character produced by the keypress
        //  @param  form (DynamicForm)  The Dynamic Form to which this icon's item belongs.
        //  @param  item (FormItem)     The Form Item containing this icon
        //  @param  icon (FormItemIcon) A pointer to the form item icon 
        //  @group  formIcons
        //  @visibility external
        //<
                
        //> @attr   formItemIcon.width (number : null : IRW)
        //      If set, this property determines the width of this icon in px.
        //      If unset the form item's <code>iconWidth</code> property will be used instead.
        //  @group  formIcons
        //  @visibility external
        //  @see    attr:formItem.iconWidth
        //<
        
        //> @attr   formItemIcon.height (number : null : IRW)
        //      If set, this property determines the height of this icon in px.
        //      If unset the form item's <code>iconHeight</code> property will be used instead.
        //  @group  formIcons
        //  @visibility external
        //  @see    attr:formItem.iconHeight
        //<    
        
        //> @attr   formItemIcon.hspace (number : null : IRWA)
        //      If set, this property determines the number of pixels space to be displayed on 
        //      the left of this form item icon.<br>
        //      If unset the form item's <code>iconHSpace</code> property will be used instead.
        //  @group  formIcons
        //  @visibility internal
        //  @see    attr:formItem.iconHSpace
        //<
    
        //> @attr   formItemIcon.prompt (string : null : IRWA)
        //      If set, this property will be displayed as a prompt (and tooltip text) for this form
        //      item icon.
        //      If unset the form item's <code>iconPrompt</code> property will be used instead.
        //  @group  formIcons
        //  @visibility internal
        //  @see    attr:formItem.iconPrompt
        //<

    // Hints
	// --------------------------------------------------------------------------------------------

    //>	@attr formItem.hint (String : null : IRW)
	// Specifies "hint" string to show next to the form item to indicate something to the user.
    // This string generally appears to the right of the form item.
    // 
    // @see hintStyle
	// @group appearance
    // @visibility external
    // @example formHints
	//<

    //>	@attr	formItem.showHint		(boolean : true : IRWA)
	// If a hint is defined for this form item, should it be shown?
    //
	// @group appearance
    // @visibility external
	//<
	showHint:true,
    
    // Styles
	// --------------------------------------------------------------------------------------------
    
    //>	@attr	formItem.showFocused     (boolean : false : IRWA)
	// When this item recieves focus, should it be re-styled to indicate it has focus?
    //
	// @group appearance
    // @visibility external
    // @see formItem.cellStyle
    //<
	showFocused:false,
    
    //>	@attr	formItem.showDisabled     (boolean : true : IRWA)
	// When this item is disabled, should it be re-styled to indicate its disabled state?
    //
	// @group appearance
    // @visibility external
    // @see cellStyle
    //<
	showDisabled:true,
    
    // Discussion on compound item / skinning for jsdoc. This is referred to by other JSDoc 
    // entries but doesn't need to show up in the doc-tree.
    //> @groupDef CompoundFormItem_skinning
    // When skinning basic FormItems like SelectItem and TextItem, consider that compound form
    // items like DateItem and ComboBox reuse simpler items like SelectItem and TextItem, so adding
    // a border to SelectItem would also apply a border to each select item within DateItem.<br>
    // To avoid such side-effects, if you want to add styling to all SelectItems used in your 
    // application, you can create an application-specific subclass like MySelectItem and apply 
    // properties there.<br>
    // @visibility external
    //<
    
    //> @type FormItemBaseStyle
    // This string is the base css class name applied to a FormItem (or some part of a form item).
    // The style name will be modified as the 'state' of the form item changes. Specifically:<ul>
    // <li>If +link{FormItem.showFocused} is true, when the form item recieves focus, this
    //     style will be have the suffix <code>"Focused"</code> appended to it.</li>
    // <li>If +link{FormItem.showErrorStyle} is true, if the form item has errors, this
    //     style will be have the suffix <code>"Error"</code> appended to it.</li>
    // <li>If +link{FormItem.showDisabled} is true, when the form item is disabled, this
    //     style will be have the suffix <code>"Disabled"</code> appended to it.</li></ul>
    // So for example if the <code>cellStyle</code> for some form item is set to <code>"formCell"</code>
    // and <code>FormItem.showFocused</code> is true, when the form item recieves focus, the
    // form item's cell will have the <code>"formCellDisabled"</code> style applied to it.
    // @visibility external
    // @group appearance
    //<
    
    //> @attr formItem.cellStyle  (FormItemBaseStyle : "formCell" : IRW)
    // CSS style applied to the form item as a whole, including the text element, any icons, and
    // any hint text for the item. Applied to the cell containing the form item.
    // <P>
    // NOTE: See the +link{group:CompoundFormItem_skinning} discussion for special skinning considerations.
    // @visibility external
    // @group appearance
    //<
    cellStyle:"formCell",
    
    //>	@attr formItem.hintStyle      (string : "formHint" : IRW)
	// CSS class for the "hint" string.
    //
    // @see hint
	// @group appearance
    // @visibility external
	//<
    
    hintStyle:"formHint",
    
    //> @attr formItem.titleStyle (FormItemBaseStyle : "formTitle" : IRW)
    // Base CSS class name for a form item's title.
    // @group title
    // @visibility external
    // @see formItem.cellStyle
    //<
    titleStyle:"formTitle",
    
    //> @attr formItem.printTitleStyle (FormItemBaseStyle : null : IRW)
    // Base CSS stylename for a form item's title when generating print HTML for the item.
    // If unset +link{formItem.titleStyle} will be used instead.
    // @group printing
    // @group apperance
    // @visibility printing
    //<

    //> @attr formItem.textBoxStyle (FormItemBaseStyle : null : IRW)
    // Base CSS class name for a form item's text box element.
    // <P>
    // NOTE: See the +link{group:CompoundFormItem_skinning} discussion for special skinning considerations.
    // @group appearance
    // @visibility external
    // @see formItem.cellStyle
    //<
    //textBoxStyle:null,
    
    //> @attr formItem.printTextBoxStyle (FormItemBaseStyle : null : IRW)
    // Base CSS class name for a form item's text box element when getting printable HTML for the
    // form. If unset +link{formItem.textBoxStyle} will be used instead. Note that focused styling
    // will never be displayed while printing, though error and disabled styling will.
    // 
    // @group printing
    // @group appearance
    // @visibility printing
    //<
    //printTextBoxStyle:null,
    
    //> @attr formItem.pickerIconStyle (FormItemBaseStyle : null : IRW)
    // Base CSS class name for a form item's picker icon cell. If unset inherits from 
    // this items <code>controlStyle</code>.
    // @visibility pickerIcon
    // @see formItem.controlStyle
    // @group appearance
    // @see formItem.cellStyle
    //<
    //pickerIconStyle:null,
    
    //> @attr formItem.controlStyle (FormItemBaseStyle : null : IRW)
    // Base CSS class name for a form item's control box (surrounds text box and picker).
    // <P>
    // NOTE: See the +link{group:CompoundFormItem_skinning} discussion for special skinning considerations.
    // @group appearance
    // @visibility pickerIcon
    // @see formItem.cellStyle
    //<
    //controlStyle:null,
    
    // -------------------------------
    // Deprecated styling properties:
    
    //>	@attr formItem.cellClassName		(CSSStyleName : "formCell" : IRW)
	// CSS class for a form item's cell in the form layout
    // 
	// @group appearance
    // @visibility external
    // @deprecated As of SmartClient version 5.5, deprecated in favor of +link{formItem.cellStyle}
	//<

    //>	@attr formItem.errorCellClassName		(CSSStyleName : "formError" : IRW)
    // CSS class for a form item's cell when a validation error is showing.
    //
	// @group appearance
    // @visibility external
    // @deprecated As of SmartClient version 5.5 deprecated in favor of +link{formItem.cellStyle}
	//<

	//>	@attr	formItem.titleClassName (CSSStyleName : "formTitle" : IRW)
    // CSS class for the form item's title.
    // @group title
    // @visibility external
    // @deprecated As of SmartClient Version 5.5, use +link{formItem.titleStyle} instead
    //<
	//titleClassName : "formTitle",

	//>	@attr	formItem.titleErrorClassName (CSSStyleName : "formTitleError" : IRW)
    // CSS class for a form item's title when a validation error is showing.
    // @group title
    // @visibility external
    // @deprecated As of SmartClient Version 5.5, use +link{formItem.titleStyle} instead    
    //<
	//titleErrorClassName : "formTitleError",
    
    //>	@attr	formItem.hintClassName		(CSSStyleName : "formHint" : IRW)
	// CSS class for the "hint" string.
    //
    // @see hint
	// @group appearance
    // @visibility external
    // @deprecated As of SmartClient version 5.5, deprecated in favor of +link{FormItem.hintStyle}
	//<

    //> @attr   formItem._hasDataElement    (boolean : false : IRW)
    //      Internal flag designating whether this element type has a data element 
    //      (an actual form element, holding a value).
    //      Accessed via the 'hasDataElement()' method.
    // @group formValues
    // @visibility   internal
    // @see     method:FormItem.hasDataElement
    // @see     method:FormItem.getDataElement
    //<
    _hasDataElement:false
    
    // Hovers
    // -----------------------------------------------------------------------------------------
    //> @attr formItem.hoverDelay (number : null : IRWA)
    // If specified, this is the number of miliseconds to wait between the user rolling over 
    // this form item, and triggering any hover action for it.<br>
    // If not specified <code>this.form.itemHoverDelay</code> will be used instead.
    // @group Hovers
    // @visibility external
    //<
    //,hoverDelay:null
        
    //> @attr formItem.hoverWidth (measure : null : [IRW])
    // Option to specify a width for any hover shown for this item.
    // @see DynamicForm.itemHoverWidth
    // @group Hovers
    // @visibility external
    //<
    
    //> @attr FormItem.hoverHeight  (measure : null : [IRW])
    // Option to specify a height for any hover shown for this item.
    // @see DynamicForm.itemHoverHeight
    // @group Hovers
    // @visibility external
    //<
    
    //> @attr FormItem.hoverAlign (Alignment  : null : [IRW])
    // Text alignment  for text displayed in this item's hover canvas, if shown.
    // @see DynamicForm.itemHoverAlign
    // @group Hovers
    // @visibility external
    //<
    
    //> @attr FormItem.hoverVAlign (measure : null : [IRW])
    // Vertical text alignment  for text displayed in this item's hover canvas, if shown.
    // @see DynamicForm.itemHoverVAlign
    // @group Hovers
    // @visibility external
    //<
    
    //> @attr FormItem.hoverStyle (CSSStyleName  : null : [IRW])
    // Explict CSS Style for any hover shown for this item.
    // @see DynamicForm.itemHoverStyle
    // @group Hovers
    // @visibility external
    //<
    
    //> @attr FormItem.hoverOpacity (number : null : [IRW])
    // Opacity for any hover shown for this item
    // @see DynamicForm.itemHoverOpacity
    // @group Hovers
    // @visibility external
    //<
    
    //> @attr FormItem.hoverRect (object : null : [IRWA])
    // Explicit placement information for any hover shown for this item.
    // Should be specified as an object of the form <br>
    // <code>{left:[value], top:[value], width:[value], height:[value]}</code>
    // @see DynamicForm.itemHoverRect
    // @group Hovers
    // @visibility internal
    //<
    
    
    //> @attr formItem.operator (OperatorId : null : IR)
    // +link{OperatorId} to be used when +link{dynamicForm.getValuesAsCriteria()} is called.
    // <P>
    // <code>item.operator</code> can be used to create a form that offers search functions such
    // as date range filtering, without the more advanced user interface of the +link{FilterBuilder}.
    // <P>
    // When <code>item.operator</code> is set for any FormItem in a form,
    // <code>form.getValuesAsCriteria()</code> will return an +link{AdvancedCriteria} object
    // instead of a normal +link{Criteria} object.  Each FormItem will produce one
    // +link{Criterion} affecting the DataSource field specified by +link{formItem.criteriaField}.
    // The criteria produced by the FormItems will be grouped under the logical operator
    // provided by +link{dynamicForm.operator}.
    // <P>
    // if <code>operator</code> is set for some fields but not others, the default operator is
    // "equals" for fields with a valueMap or an optionDataSource, and for fields of type "enum"
    // (or of a type that inherits from "enum").  The default operator for all other fields is
    // "iContains" (case-insensitive match) 
    // <P>
    // <b>Note:</b> Advanced criteria will only be created for items in a Databound form. If this
    // item is part of a form with no +link{DynamicForm.dataSource,dataSource}, the 
    // <code>operator</code> attribute will have no effect. 
    //
    // @visibility external
    //<
    
    //> @attr formItem.criteriaField (identifier : null : IR)
    // When using +link{formItem.operator}, the name of the DataSource field for the
    // +link{Criterion} this FormItem generates.  If not specified, defaults to
    // +link{FormItem.name}.
    // <P>
    // Generally, because <code>criteriaField</code> defaults to <code>item.name</code>, you don't
    // need to specify it.  However, if more than one FormItem specifies criteria for the same
    // DataSource field, they will need unique values for +link{formItem.name} but should set
    // +link{formItem.criteriaField} to the name of DataSource field they both target.
    // <P>
    // For example, if two DateItems are used to provide a min and max date for a single field called
    // "joinDate", set +link{formItem.criteriaField} to "joinDate" on both fields but give the fields
    // distinct names (eg "minDate" and "maxDate") and use those names for any programmatic access,
    // such as +link{dynamicForm.setValue()}.
    //
    // @visibility external
    //<
    
});

isc.FormItem.addMethods({
	//>	@method	FormItem.init()	(A)
	//			initialize the formItem object 
	//
	//		@param	[all arguments]	(object)	objects with properties to override from default
	//<
    _$height:"height", _$width:"width",
    _$colSpan:"colSpan", _$rowSpan:"rowSpan",
	init : function () {
        if (isc._traceMarkers) arguments.__this = this;
        
        // get a global ID so we can be called in the global scope
        // If getID() is called before this (typically only likely in an override of init),
        // we will already have a global ID - in this case avoid clobbering it.
        if (this.ID == null || window[this.ID] != this) {
            isc.ClassFactory.addGlobalID(this); 
        }
	
		// if "options" was specified, switch to "valueMap"
		if (this.options && !this.valueMap) {
			this.valueMap = this.options;
			delete this.options;
		}
        
        // Make sure that any 'measure' properties are in the correct format
        
        this._convertRawToMeasure(this._$height);
        this._convertRawToMeasure(this._$width);
        this._convertRawToMeasure(this._$colSpan);
        this._convertRawToMeasure(this._$rowSpan);
        
        // Start with our default value
        // - we do this rather than calling 'this.setValue(this.getDefaultValue())' for a
        //   couple of reasons:
        //   a) At this point the form's "values" object may not be initialized
        //   b) In subclass overrides, such as the container item, setValue() makes use of
        //      properties that get set up after this (for them Superclass) init()
        //      implementation
        // - setValue() would also call form.saveItemValue() - it's ok to skip this at this
        //   stage as after the form item has been created this call would be made after form
        //   item creation via 'setValues()' for any items where 'shouldSaveValue' is true.
        // - setValue() would also call setElementValue() - ok to skip as our elements haven't
        //   been set up until draw().
        this._value = this.getDefaultValue();
        // Note that this is the default value.
        this._setToDefault = true;
	
        this._setUpIcons();
	},
    
    
    _$star:"*",
    _convertRawToMeasure : function (property) {
        var value = this[property];        
        if (value == null || isc.isA.Number(value) || value == this._$star) return value;
        var numericVal = parseInt(value);
        if (numericVal == value) {
            this[property] = numericVal;
            return value;
        }
        return value;
    },
    
    destroy : function () {
        if (this.isDrawn()) this.cleared();

        // If this is a form item that shows a unique pickList, destroy it too
        var pickList = this.pickList;
        this.pickList = null;
        if (pickList != null) {
            if (pickList.formItem == this) delete pickList.formItem;
            pickList.hide();
            if (!this.reusePickList()) pickList.destroy();
        }

        this.destroyed = true;
        this.form = null;
        this._dataElement = null;
        var undef;
        if (window[this.ID] == this) window[this.ID] = undef;
        // NOTE: we assume picker recycling as a default
        
        if (isc.EH._focusTarget == this) isc.EH._focusTarget = null;
    },

    clear : function () {
        if (this.picker) this.picker.clear();
    },
    
    // Override toString() so form items show their names rather than their IDs by default
    toString : function () {
        var name = this.getFieldName(),
            ID = this.ID,
        
            string = "[" + this.Class + " instance " + 
                        (name != null ? " name ='" + name + "', " : "") +
                        "global ID=" + ID + "]";
        return string;                        
        
    },
    
    getDataSource : function () {
        if (isc.isA.String(this.dataSource)) return isc.DS.get(this.dataSource);
        return this.dataSource;
    },

    // IDs and names
	// --------------------------------------------------------------------------------------------
    
	//>	@method	formItem.getFieldName()	(A)
	//			Return the name for the this formItem.
	//		@group	drawing
	//
	//		@return	(string)	name for this form item
    // @visibility external
	//<
	getFieldName : function () {
		return this[this.form.fieldIdProperty];
	},
    
    //>	@method	formItem.getItemName()	(A)
	//			Return the name for the this formItem.  Synonym for getFieldName()
	//		@group	drawing
	//
	//		@return	(string)	name for this form item
    // @visibility internal
	//<
    getItemName : function () {
        return this.getFieldName();
    },


	//>	@method	formItem.getElementName()	(A)
	//			Return the name to be written into this form item's HTML element.
    //          This will not necessarily match the value returned by this.getFieldName().
	//		@group	drawing
	//
	//		@return	(string)	name of the form element
	//<
    
    _$underscore:"_",
    _$value:"value",
    getElementName : function () {
		var name = this.getFieldName();

		// if this item has a parentItem, prepend the name of the parentItem
        // This is just for uniqueness - we will not be trying to parse this string to determine
        // what an items' parent element is
		if (this.parentItem) {
			var masterName = this.parentItem.getElementName();
			if (name == isc.emptyString) name = masterName;
			else name = [masterName, this._$underscore, name].join(isc.emptyString);
		}
        
        // If we still don't have a name, or the name matches the ID for the item,
        // return a unique 'name' string for this item.
        // - Note: we can't actually use the ID of the item, because when we write handlers 
        //   into the form items, we want to be able to refer to the item by it's ID. Because 
        //   the handlers are executed in the scope of the native form object in the 
        //   document.forms array, if the native name of the Form Element matches the ID of 
        //   the item, the ID would give us a pointer to the Form Element rather than the item.
        if (name == null || name == this.getID() || name == isc.emptyString) {
            name = this._getDOMID(this._$value);
        }
        
		return name;
	},

	//>	@method	formItem.getDataElementId()	(A)
	// Return the ID for this form item's data element.
    //		@group	drawing
	//		@return	(string)	name of the form element
    // @visibility testAutomation
	//<
    
    _$dataElement:"dataElement",
    getDataElementId : function () {
        if (this.__tagId == null) {
            this.__tagId = this._getDOMID(this._$dataElement, true);
        }
        // This will be a unique ID that can be written into the element tag.
        // It's used for getting a reference to the form item element to be used by the
        // "FOR" property written into the label for the form item.
        // Doesn't necessarily reflect anything about the information carried by the form item.
        return this.__tagId;
        
    },
    
	//>	@method	formItem.getItemID()	(A)
	//		Return the unique global ID for this form item instance.
    //      The item is available in the global scope via this ID as window[itemID].
    //      Synonym for getID().
	//		@group	drawing
	//
	//		@return	(string)	ID of the form item.
	//<
	getItemID : function () {
        return this.getID();
	},
   
    //>	@method	formItem.getID()    (A)
	//		Return the unique global ID for this form item instance.
    //      The item is available in the global scope via this ID as window[itemID].
	//		@group	drawing
	//
	//		@return	(string)    ID of the item.
	//<
    getID : function () {
        
        if (this.ID == null) {
            isc.ClassFactory.addGlobalID(this);
        }
        return this.ID;
    },
    
    
    
    // Titles
	// --------------------------------------------------------------------------------------------
    
   	//>	@method	formItem.shouldShowTitle()	(A)
	//	Draw a cell for this item title?
	//		@group	drawing
	//
	//		@return	(boolean)	true if item title cell should be drawn
	//<
	shouldShowTitle : function () {
		return this.showTitle;
	},
    
	//>	@method	formItem.getTitleHTML()	(A)
	//	Return the HTML for the title of this formItem
	//		@group	drawing
	//
	//		@return	(HTML)	title for the formItem
	//<
	getTitleHTML : function () {
        var title = this.getTitle();

        // If we don't have an element, simply return the title (no need for the "label for..."
        // functionality).
        if (!this._canFocus()) return title;

        if (this.accessKey != null) {
            // underline the accessKey char within the title
            title = isc.Canvas.hiliteCharacter(title, this.accessKey);
        }
        
        // If we don't have a data element, the accessKey should have been written into 
        // whatever our focusable element is (may be a focus proxy)
        if (!this.hasDataElement()) return title;

        // Note: the <LABEL> tag allows us to set an accessKey on the element without writing it
        // directly into the element's HTML.  It also improves on (for example) screen reader 
        // support
        return isc.SB.concat(
            "<LABEL FOR=", this.getDataElementId(),
             (this.accessKey != null ? " ACCESSKEY=" + this.accessKey : isc._emptyString),
            ">", title, "</LABEL>");
	},
	
	//>	@method	formItem.getTitle()	(A)
	//	Return the title of this formItem
	//		@group	drawing
	//
	//		@return	(HTML)	title for the formItem
    // @visibility external
	//<
    getTitle : function () {
        if (this[this.form.titleField] != null) return this[this.form.titleField];
        return this[this.form.fieldIdProperty];
    },

    // Defer to DF to pick up the form's default titleOrientation
    getTitleOrientation : function () { return this.form.getTitleOrientation(this); },

    // Layout
	// --------------------------------------------------------------------------------------------

    //> @method formItem.isVisible()    ()
    //  Return true if the form item is currently visible on the page
    //  @group  visibility
    //  @return (boolean)   true if the form item is visible
    //<
    isVisible : function () {
        if (!this.containerWidget.isVisible()) return false;
            
        // If we have a showIf(), which evaluated to false, we will have been marked as
        // visibility false (done in DynamicForm.getInnerHTML()).
        if (this.visible == false) return false;
        // If we're a child of a container item, check whether the container item has been
        // marked as not-visible.
        if (this.parentItem && !this.parentItem.isVisible()) return false;
        return true;
    },
	
   	//>	@method	formItem.getRowSpan()	(A)
	// Return the rowSpan for this item
	//		@group	formLayout
	//
	//		@return	(number)	rowSpan
	//<
	getRowSpan: function () {
		return this.rowSpan;
	},

   	//>	@method	formItem.getColSpan()	(A)
	// Return the colSpan for this item
	//		@group	formLayout
	//
	//		@return	(number)	colSpan
	//<
	getColSpan : function () {
        // disallow colSpan of zero
        if (this.colSpan == 0) this.colSpan = 1;
		return this.colSpan;
	},

    //> @method formItem.isStartRow()   (A)
    // Should this item be drawn on a new row?
    //      @group tableLayout
    //      @return (boolean) true if a new row should start for this item
    //<
    isStartRow : function () {
        return this.startRow
    },
    
    //> @method formItem.isEndRow()   (A)
    // Should this be the last item on a row?
    //      @group tableLayout
    //      @return (boolean) true if a new row should start after this item
    //<
    isEndRow : function () {
        return this.endRow
    },

    //>	@method	formItem.getRect()
    //			return the coordinates of this object as rendered in LTWH order
    //		@group	positioning, sizing
    //		
    //		@return	(array)		[left, top, width, height]
    //<
    getRect : function () {
	    return [this.getLeft(), this.getTop(), this.getVisibleWidth(), this.getVisibleHeight()];
    },

    getPageRect : function () {
        return [this.getPageLeft(), this.getPageTop(), 
                this.getVisibleWidth(), this.getVisibleHeight()];
    },

    getPeerRect : function () {
        return this.getPageRect();
    },

    
    getCellHeight : function (reportOverflowedSize) {

        var height = this.getHeight(reportOverflowedSize);
        if (!isc.isA.Number(height)) return height;

        // never report a height lower than that required by our visible icons
        // (these are our external icons - not our picker icon)
        var iconsHeight = this.getIconsHeight();
        if (height < iconsHeight) {
            height = iconsHeight;
        }
        
        // If we are showing a picker icon, and it has a specified height, that may also cause
        // our height to be larger than expected.
        // If no specified height, sized to fit in available space, so won't expand the item.
        if (this.showPickerIcon && this.pickerIconHeight) {
            var pickerIconHeight = this.pickerIconHeight + this._getPickerIconVPad();
            if (pickerIconHeight > height) height = pickerIconHeight;
        }

        var form = this.containerWidget;
        if (this._absPos() || !isc.isA.DynamicForm(form)) return height;

        height += this._getCellVBorderPadSpacing();
        
        // If titleOrientation is TOP, and we're showing a title, add our title height to our
        // reported cellHeight, so tableLayoutPolicy code will take it into account
        
        if (this.showTitle && this.form.getTitleOrientation(this) == isc.Canvas.TOP) {
            height += this.form.getTitleHeight(this);
        }
              
        return height;
    },
    
    // Returns the space taken up around this form item by the cell (determined from
    // cellSpacing, border and padding).
    _getCellVBorderPadSpacing : function () {
    
        var height = 0,
            form = this.form,
            cellStyle = this.getCellStyle();

        // For items written into containerIems, cellSpacing/padding will be defined on the
        // parent item, not the form.
        if (this.parentItem) form = this.parentItem;            
            
        // Spacing around cells (above and below)
        height += 2*form.cellSpacing;            
    
        
        var cellPadding = isc.isA.Number(form.cellPadding) ? form.cellPadding : 0,
            paddingTop = isc.Element._getTopPadding(cellStyle, true);
        if (paddingTop == null) paddingTop = cellPadding
        
        var paddingBottom = isc.Element._getBottomPadding(cellStyle, true);
        if (paddingBottom == null) paddingBottom = cellPadding;
        
        height += paddingTop;
        height += paddingBottom;
        height += isc.Element._getVBorderSize(cellStyle);
        
        return height;
    },
    _getCellHBorderPadSpacing : function () {
    
        var height = 0,
            form = this.form,
            cellStyle = this.getCellStyle();
        
        // For items written into containerIems, cellSpacing/padding will be defined on the
        // parent item, not the form.
        if (this.parentItem) form = this.parentItem;
            
        // Spacing around cells (above and below)
        if (isc.isA.Number(form.cellSpacing)) height += 2*form.cellSpacing;            
    
        
        // We have seen a case where a developer set form.cellPadding to a string 
        // ("2" rather than 2), which led to us assembling an inappropriate string like "0220"
        // in this method. If cellPadding is specified as a string just ignore it.
        var formCellPadding = isc.isA.Number(form.cellPadding) ? form.cellPadding : 0,
            paddingLeft = isc.Element._getLeftPadding(cellStyle, true);
        if (paddingLeft == null) paddingLeft = formCellPadding;
        
        var paddingRight = isc.Element._getRightPadding(cellStyle, true);
        if (paddingRight == null) paddingRight = formCellPadding;
        
        height += paddingLeft;
        height += paddingRight;
        height += isc.Element._getHBorderSize(cellStyle);
        
        return height;
    },

    //>@method  FormItem.getInnerHeight()   
    // Returns the available space for content of this FormItem, based on the specified
    // height for the item, and any styling.
    // @return (number) height in px.
    //<
    // Note: the specified FormItem.height governs the size of the control-box / text-box, not
    // the size of the entire formItem cell, so we don't need to worry about the styling applied
    // to the cell.
    
    getInnerHeight : function () {
        var form = this.containerWidget;

        if (this._absPos()) return this._getPercentCoord(this.height, true);

        
        if (this._size) {            
            var height = this._size[1];
            
            if (!isc.isA.Number(height)) return height;
            
                            
            if (this._writtenIntoCell()) {
                height -= this._getCellVBorderPadSpacing();
            }
            return height;
        }
        return this.getHeight();
    },

    getInnerWidth : function (adjustForIcons) {
        var form = this.containerWidget;

        if (this._absPos()) return this._getPercentCoord(this.width);

        var width = this._size ? this._size[0] : this.width;

        // happens if StretchResize hasn't been run and size is specified as eg "*".  In this
        // case the FormItem may not handle the size in string form anyway, but we shouldn't
        // try to do math on it.
        if (!isc.isA.Number(width)) return width;
        
        // _size refers to the total area taken up by this items cell - to get the innerWidth
        // (available for the item and it's icons), deduct the border / padding / spacing
        // of the cell)
                        
        if (this._writtenIntoCell()) {        
            width -= this._getCellHBorderPadSpacing();
        }
        return width;
    },
    
    _absPos : function () {
        return (this.containerWidget._absPos && this.containerWidget._absPos());
    },
    
    _writtenIntoCell : function () {
        return (this.containerItem != null || 
                (this.form == this.containerWidget && !this._absPos()));
    },
    // percent coordinate interpretation for absPos forms
    _$percent:"%",
    _getPercentCoord : function (coord, vertical) {
        // decided against since this re-interprets the default size of "*" for many items
        //if (coord == "*") coord = "100%"; 
        if (isc.isA.String(coord) && isc.endsWith(coord, this._$percent)) {
            var parent = this.containerWidget,
                parentSize = vertical ? parent.getInnerHeight() : parent.getInnerWidth();
            return Math.round((parseInt(coord, 10) / 100) * parentSize);
        }
        return coord;
    },

    
    getElementWidth : function () {
        var width = this.getInnerWidth();
        
        if (!isc.isA.Number(width)) return null;
        width -= this.getTotalIconsWidth();

        return (isc.isA.Number(width) ? Math.max(width, 1) : null);
    },
    
    
    // getTextBoxWidth() / height()
    // returns the size of the text box (used for writing out HTML - not retrieved by looking at
    // the DOM element in question).    
    
    getTextBoxWidth : function (value) {
        var basicWidth = this.getElementWidth();
        if (!isc.isA.Number(basicWidth)) return basicWidth;

        if (this.textBoxStyle) {
            var className = this.getTextBoxStyle();
            basicWidth -= (isc.Element._getLeftMargin(className) + isc.Element._getRightMargin(className));
            if (this._sizeTextBoxAsContentBox()) {
                basicWidth -= isc.Element._getHBorderPad(className);
            }
        }
        if (this.showPickerIcon) {
            basicWidth -= this.getPickerIconWidth();
            var iconProps = this.getPickerIcon();
            if (iconProps.hspace != null) basicWidth -= iconProps.hspace;
            if (this.pickerIconStyle) 
                basicWidth -= isc.Element._getHBorderPad(this.getPickerIconStyle());
            if (this.controlStyle)
                basicWidth -= isc.Element._getHBorderPad(this.getControlStyle());
        }

        
        if (this.hasDataElement() && this._getValueIcon(value)) {
            basicWidth -= ((this.getValueIconWidth() || 0) + 
                                    (this.valueIconLeftPadding + this.valueIconRightPadding));
        }

        // reduce by error width for left or right-oriented errors
        return basicWidth - this.getErrorWidth();
    },

    // anticipated width of the error message, if we are showing errors on the left or right
    getErrorWidth : function () {
        // If we are showing errors on the left/right we should adjust the textBox size to account
        // for them. We don't know how long the error strings will be and it's ok for them to wrap
        // so make the default space we leave for them configurable at the item level
        var errorWidth = 0;
        if (this.form.showInlineErrors && this.hasErrors()) {
            var orientation = this.getErrorOrientation();
            if (orientation == isc.Canvas.LEFT || orientation == isc.Canvas.RIGHT) {
                if (this.shouldShowErrorText()) {
                    errorWidth += this.errorMessageWidth;
                } else if (this.shouldShowErrorIcon()) {
                    
                    errorWidth += this.errorIconWidth + this.iconHSpace;
                }
            }
        }
        return errorWidth;
    },
    
    // configurable settings for error display sizing - used when the error is displayed inline
    // on the left or right of the item
    // total width for message and icon
    errorMessageWidth:80,
    
    // Helpers to avoid code duplication
    getValueIconHeight : function () {
        var height = this.valueIconHeight;
        if (height == null) height = this.valueIconSize;
        return height;
    },
    
    getValueIconWidth : function () {
        var width = this.valueIconWidth;
        if (width == null) width = this.valueIconSize;
        return width;
    },
    
    getTextBoxHeight : function () {
        
        var basicHeight = (isc.isA.Number(this.getHeight()) ? this.getHeight() : this.getInnerHeight());
        if (!isc.isA.Number(basicHeight)) return basicHeight;
        
        // If we're showing a valueIcon, adjust the textBox height to accomodate it if necessary
        if (this.valueIcons != null || this.getValueIcon != null) {
            var valueIconHeight = this.getValueIconHeight();
            if (valueIconHeight > basicHeight) basicHeight = valueIconHeight;
        }

        
        if (this.textBoxStyle) {
            var className = this.getTextBoxStyle();
                            
            basicHeight -= (isc.Element._getTopMargin(className) + 
                            isc.Element._getBottomMargin(className));
            if (this._sizeTextBoxAsContentBox()) {
                basicHeight -= isc.Element._getVBorderPad(className);
            }
        }
        // If we're writing out a control box we also have to adjust the height for the control
        // box's styling
        if (this.showPickerIcon && this.controlStyle) {
            basicHeight -= isc.Element._getVBorderPad(this.getControlStyle());
        }
        
        
        if (this.showTitle && this.form.getTitleOrientation(this) == isc.Canvas.TOP &&
            !isc.isA.Number(this.getCellHeight())) 
        {
            basicHeight -= this.form.getTitleHeight(this);
        }        
        
        return basicHeight;
    },
    
    
    _sizeTextBoxAsContentBox : function () {
        return !isc.Browser.isBorderBox;
    },

    
    // getTextPickerIconidth() / height()
    // returns the size of the picker icon's cell (used for writing out HTML - not retrieved by looking at
    // the DOM element in question).
    getPickerIconWidth : function () {
        return (this.pickerIconWidth != null ? this.pickerIconWidth : this.getPickerIconHeight());
    },
    
    getPickerIconHeight : function () {
        if (this.pickerIconHeight != null) return this.pickerIconHeight;
        else {
            var height = (isc.isA.Number(this.getHeight()) ? this.getHeight() : this.getInnerHeight());
            if (!isc.isA.Number(height)) return null;
            
            height -= this._getPickerIconVPad();
            
            this.pickerIconHeight = height;
            return height;
        }
    },
    
    // Vertical padding between the picker icon and the outer table
    _getPickerIconVPad : function () {
        
        var pad = 0;
        if (this.controlStyle){
            pad += isc.Element._getVBorderPad(this.controlStyle);
        }
        if (this.pickerIconStyle) {
            pad += isc.Element._getVBorderPad(this.pickerIconStyle);
        }
        return pad;
    },
    
	//>	@method	formItem.getHeight()	(A)
	//	Output the height for this element
	//		@group	sizing
	//		@return	(number)	height of the form element
	//<
	getHeight : function () {
		return this.height;		
	},
    

    //>	@method	formItem.getVisibleHeight()	(A)
	//	Output the drawn height for this item in pixels.
    //  Note: this is only reliable after this item has been written out into the DOM.
	//		@group	sizing
	//		@return	(number)	height of the form item
	//<    
    // this returns the height of the outer table for the item 
    getVisibleHeight : function () {
        var element = this.isDrawn() ? this.getOuterElement() : null;
        if (element == null) {
            this.logInfo("getVisibleHeight() - unable to determine drawn height for this item -" +
                         " returning pixel height from specified height", "sizing");
            if (isc.isA.Number(this.height)) {
                return this.height;
            } 
           
            this.logWarn("getVisibleHeight() unable to determine height - returning zero", 
                         "sizing");
            return 0;        
        }
        
        return element.offsetHeight;    
    },

    //>	@method	formItem.getIconHeight()	(A)
	//	Takes an icon definition object, and returns the height for that icon in px.
	//		@group	sizing
    //      @param  icon (object)   icon definition object for this item.
	//		@return	(number)	height of the form item icon in px
    //      @visibility external    
	//<
    getIconHeight : function (icon) {
        // default to the first icon, if possible
        if (icon == null && this.icons != null && this.icons.getLength() > 0) icon = this.icons[0];
        else if (!this._isValidIcon(icon)) {
            this.logWarn("getIconHeight() passed invalid icon:" + isc.Log.echoAll(icon));
            return null;
        }
        
        // Note: we could actually look at the icon element in the DOM, (if it's drawn)
        // but we have full control over the HTML written into form item icons, so this value 
        // should always match the specified size for the icon.
        return (icon.height != null ? icon.height : this.iconHeight);

    },
    

	//>	@method	formItem.getWidth()	(A)
	//	Output the width for this element. Note this returns the specified width for the 
    //  element, which may be "*" or a percentage value. Use 'getVisibleWidth()' to get the
    //  drawn width in pixels.
	//		@group	sizing
	//		@return	(number)	width of the form element
	//<
	getWidth : function () {
		return this.width
	},
     
    //>	@method	formItem.getVisibleWidth()	(A)
	//	Output the drawn width for this item in pixels.
	//		@group	sizing
	//		@return	(number)	width of the form item
	//<    
    
    getVisibleWidth : function () {
        var element = this.isDrawn() ? this.getOuterElement() : null;
        if (element == null) {
            this.logInfo("getVisibleWidth() - unable to determine drawn width for this item -" +
                         " returning pixel width from specified width", "sizing");
            if (isc.isA.Number(this.width)) {
                return this.width;
            // HACK: stretchResizePolicy is run on the form when writing out items into the DOM
            // this will resolve non numeric (* and percentage) sizes to pixel widths, and store
            // the specified column sizes on the items object as _colWidths.  If this is present
            // return the appropriate numeric value.
            } else if (this.form && this.form.items._colWidths != null) {
            
                return this.form.items._colWidths[this.form.getItems().indexOf(this)];
            }
        
            this.logWarn("getVisibleWidth() unable to determine width - returning zero", 
                         "sizing");
            return 0;        
        }
        
        return element.offsetWidth;
    },
    
    //>	@method	formItem.getIconWidth()	(A)
	//	Takes an icon definition object, and returns the width for that icon in px.
	//		@group	sizing
    //      @param  icon (object)   icon definition object for this item.
	//		@return	(number)	width of the form item icon in px
    //      @visibility external    
	//<
    getIconWidth : function (icon) {
        // default to the first icon, if possible
        if (icon == null && this.icons != null && this.icons.getLength() > 0) icon = this.icons[0];
        else if (!this._isValidIcon(icon)) {
            this.logWarn("getIconWidth() passed invalid icon:" + isc.Log.echoAll(icon));
            return null;
        }
        
        // Note: we could actually look at the icon element in the DOM, (if it's drawn)
        // but we have full control over the HTML written into form item icons, so this value 
        // should always match the specified size for the icon.
        return (icon.width != null ? icon.width : this.iconWidth);

    },
    
    //> @method formItem.setHeight()    (A)
    // Set the height for this element
    //      @group  sizing
    //        @param    (number)    new height for the form element
    //<
    setHeight : function (height) {
        this.height = height;
        // redraw the item (default implementation notifies the container widget that the item
        // needs redrawing)
        this.redraw();
    },
    
    //> @method formItem.setWidth()    (A)
    // Set the width for this element
    //      @group  sizing
    //        @param    (number)    new width for the form element
    //<
    setWidth : function (width) {
        this.width = width;
        this.redraw();
    },

    //> @method formItem.setLeft()    (A)
    // For a form with +link{DynamicForm.itemLayout,itemLayout}:"absolute" only, set the left
    // coordinate of this form item.
    // <P>
    // Causes the form to redraw.
    // @visibility absForm
    //<
    setLeft : function (left) {
        this.left = left;
        this.redraw();
    },
    //> @method formItem.setTop()    (A)
    // For a form with +link{DynamicForm.itemLayout,itemLayout}:"absolute" only, set the top
    // coordinate of this form item.
    // <P>
    // Causes the form to redraw.
    // @visibility absForm
    //<
    setTop : function (top) {
        this.top = top;
        this.redraw();
    },
    
    //> @method formItem.moved()    (A)
    // The container widget is responsible for writing the HTML for form items into the DOM.
    // This is a notification function fired by the container items on form items when their
    // global position changes.
    //<
    moved : function () {
        // No default implementation - can be overridden / observed as required.
    },
    
    //> @method formItem.visibilityChanged()    (A)
    // The container widget is responsible for writing the HTML for form items into the DOM.
    // This is a notification function fired by the container items on form items when they are
    // hidden or shown on the page.  May be caused by parent show() / hide(), or calls to
    // showItem / hideItem.
    //<
    
    visibilityChanged : function () {
        // No default implementation - can be overridden / observed as required.
    },
    
    //> @method formItem.zIndexChanged()    (A)
    // The container widget is responsible for writing the HTML for form items into the DOM.
    // This is a notification function fired by the container items on form items when their
    // zIndex is modified on the page.  
    //<
    zIndexChanged : function () {
        // No default implementation - can be overridden / observed as required.
    },
    
    // HTML generation: element, errors, icons and hints
	// --------------------------------------------------------------------------------------------

    //> @method formItem.getStandaloneItemHTML()   (A)
    // This method returns the HTML for any form item not being written into a standard 
    // DynamicForm's table. It allows other widgets to embed form items in their HTML without
    // having to have a DynamicForm as a child.
    //      @group drawing
    //      @return         (HTML)      HTML output for this standalone item's element
    //      @visibility internal
    //<
    // For a widget (other than a DynamicForm) to embed form items, the other widget must
    // - Define a form for it's "standalone" items to belong to.
    // - set the 'containerWidget' property on the form item[s] it wants to write out
    // - use this method to get the HTML for the form item
    // - call 'drawn()' when the HTML for the item has been written out
    // - call 'cleared()' when the HTML for the item is removed from the DOM
    // - call 'redrawn()' when the HTML for the item is re-written in the DOM
    // This is used by the ListGrid to show the edit form items within cells.
    
    _$absDivStart:"<DIV STYLE='position:absolute;left:",
    _$pxSemiTopColon:"px;top:",
    _$pxSemiWidthColon:"px;width:",
    _$pxSemiHeightColon:"px;height:",
    _$pxSemiIDEquals:"px;' ID='",
    _$quoteRightAngle:"'>",
    _$absDivEnd:"</DIV>",
    
    _$standaloneStartTemplate:[
        "<SPAN style='white-space:nowrap;' eventProxy=",        // [0]
        ,                                                       // [1] formID
            // this 'containsItem' property may be used to determine which
            // form item events (passed to the form) occured over.
            
        " " + isc.DynamicForm._containsItem + "='",                                      // [2]
        ,                                                       // [3] itemID
        "' ID='",                                               // [4]
        ,                                                       // [5] ID for span
        "'>"                                                    // [6]
    ],
    _$standaloneEnd:"</SPAN>",
    _$standaloneSpan:"_standaloneSpan",
    getStandaloneItemHTML : function (includeHint, includeErrors) {

        // Write a span around the item with this form's ID as the eventProxy -- this ensures
        // that events are handled by the form rather than whatever the next parent canvas is
        var value = this.getValue(),
            output = isc.SB.create(),
            form = this.form;
        
        // output a <SPAN> so the EventHandler recognizes which form this item belongs to
        if (form) {
            if (this._absPos()) {
                var left = this._getPercentCoord(this.left), 
                    top = this._getPercentCoord(this.top, true),
                    width = this.getInnerWidth(),
                    height = this.getInnerHeight();
                if (!isc.isA.Number(left)) left = 0;
                if (!isc.isA.Number(top)) top = 0;
                output.append(this._$absDivStart);
                output.appendNumber(left);
                output.append(this._$pxSemiTopColon);
                output.appendNumber(top);
                
                if (isc.isA.Number(width)) {
                    output.append(this._$pxSemiWidthColon);
                    output.appendNumber(width);
                }
                if (isc.isA.Number(height)) {
                    output.append(this._$pxSemiHeightColon);
                    output.appendNumber(height);
                }

                output.append(this._$pxSemiIDEquals, this._getAbsDivID(), this._$quoteRightAngle);
            }
            
            var template = this._$standaloneStartTemplate,
                formID = form.getID(),
                itemID = this.getID();
            
            template[1] = formID;
            template[3] = itemID;
            template[5] = this._getDOMID(this._$standaloneSpan);
            output.append(template);


                        
            output.append(this.getInnerHTML(value, includeHint, includeErrors, true));
            
            output.append(this._$standaloneEnd);
            
            if (this._absPos()) {
                output.append(this._$absDivEnd); 
            }
        }
        // return and relese the buffer so it can be reused  
        return output.release();
    },
    
    _$absDiv:"_absDiv",
    _getAbsDivID : function () {
        return this._getDOMID(this._$absDiv);
    },
    
    // cache the absolute div (when 'cleared()' fires this will get cleared)
    getAbsDiv : function () {
        if (this._absDiv) return this._absDiv;
        if (!this.isDrawn()) return;
        this._absDiv = isc.Element.get(this._getAbsDivID());
        return this._absDiv;
    },

    _hasExternalIcons : function () {
        var icons = this.icons;
        if (!icons) return false;
        for (var i = 0; i < icons.length; i++) {
            if (!icons[i].writeIntoItem) return true; // found external icon
        }
        return false; // all icons internal
    },

    // -- Disabled item event mask --
    
    // In some browsers (seen in Moz), native mouse events (such as mousemove) are not generated
    // when the user moves over disabled native form item elements. 
    // If this form item is disabled, we write out a div floating over the native form item
    // so we can still get native mouse events and respond by showing hovers, etc.
    //
    // In IE, we get bogus native events (event.srcElement is an object that can't be
    // enumerated - crashes browser and all event properties produce error if poked) when the
    // mouse is over disabled text in textitems that can be fixed with this workaround
    useDisabledEventMask : function () {
        return (isc.Browser.isMoz && this.hasDataElement()) 
                || (isc.Browser.isIE && isc.isA.TextItem(this));
    },

    
    _eventMaskTemplate:[
        "<DIV isDisabledEventMask='true' style='overflow:hidden;position:absolute;width:",
        null,   // 1 width
        "px;height:",
        null,   // 3 height
        //"px;border:1px solid red;' containsItem='", 
        "px' " + isc.DynamicForm._containsItem + "='",
        null,   // 5 item id
        "' " + isc.DynamicForm._itemPart + "='" + isc.DynamicForm._element + "' ID='",
        ,   // 7 ID for the element - so we can easily clear it from the DOM
        "'>",
        (isc.Browser.isIE ? isc.Canvas.spacerHTML(1600, 100) : "&nbsp;"), 
        "</DIV>"
    ],
    _getEventMaskHTML : function () {
        var template = this._eventMaskTemplate;
        template[1] = this._getEventMaskWidth();
        template[3] = this.getHeight();
        template[5] = this.getItemID();
        template[7] = this._getDOMID("eventMask");
        return template.join(isc.emptyString);        
    },
    
    _getEventMaskElement : function () {
        return isc.Element.get(this._getDOMID("eventMask"));
    },

    
        
    _getEventMaskWidth : function () {
        return this.getElementWidth();
    },
    
    // Browser spell checking
    // (Currently only supported in Moz Firefox 2.0 beta2 and above)
    // Note: if browserSpellCheck is unset, we pick it up from the containing form item
    
    getBrowserSpellCheck : function () {
        if (this.browserSpellCheck != null) return this.browserSpellCheck;
        return this.form.browserSpellCheck;
    },
    
    // -- Hidden data element --
    
    // If this is an item with no native form element, but this form's value is being 
    // submitted directly to the server, we are going to need a hidden item in the form to 
    // represent its value.
    _useHiddenDataElement : function () {
        return (this.shouldSaveValue && !this.hasDataElement() && this.shouldSubmitValue());
    },
    
    // HTML for the hidden data element
    _$hiddenDataElement:"hiddenDataElement",
    _getHiddenDataElementID : function () {
        return this._getDOMID(this._$hiddenDataElement);
    },
    _getHiddenDataElement : function () {
        return this._getHTMLPartHandle(this._$hiddenDataElement);
    },
    
    _getHTMLPartHandle : function (part) {
        if (!this.isDrawn()) return null;
        
        if (!this._htmlPartHandles) this._htmlPartHandles = {};
    
        // Note: we free up this cache on 'cleared()' / 'redrawn()'
        var handle = this._htmlPartHandles[part];
        if (handle == null) {
            handle = isc.Element.get(this._getDOMID(part));
            if (handle != null) this._htmlPartHandles[part] = handle;
        }
        return handle;
    },
    
    _$control:"control",
    _getControlTableID : function () {
        return this._getDOMID(this._$control);
    },
    _getControlTableElement : function () {
        return this._getHTMLPartHandle(this._$control);
    },
    
    _$textBox:"textBox",
    _getTextBoxID : function () {
        return this._getDOMID(this._$textBox);
    },
    _getTextBoxElement : function () {
        if (this.hasDataElement() && this._dataElementIsTextBox) return this.getDataElement();
        return this._getHTMLPartHandle(this._$textBox);
    },
    
    
    _$pickerIconCell:"pickerIconCell",
    _getPickerIconCellID : function () {
        return this._getDOMID(this._$pickerIconCell);
    },
    _getPickerIconCellElement : function () {
        return this._getHTMLPartHandle(this._$pickerIconCell);
    },
      
    
    _getHiddenDataElementHTML : function () {
        return "<INPUT type='hidden' name='" + 
                this.getFieldName() + "' ID='" + this._getHiddenDataElementID() + "'>";
    },
    
    _$hintCell:"hintCell",
    _getHintCellID : function () {
        return this._getDOMID(this._$hintCell);
    },
    _getHintCellElement : function () {
        return this._getHTMLPartHandle(this._$hintCell);
    },
       
    //> @method formItem.updateState() [A]
    // Update the visual state of a FormItem to reflect any changes in state or any changes in
    // style settings (eg +link{formItem.textBoxStyle}). 
    // <P>
    // Calls to <code>updateState()</code> normally occur automatically as a consequence of
    // focus changes, items becoming disabled, etc.  This method is advanced and intended only
    // for use in workarounds.
    //
    // @visibility external
    //<
    
    _$FormItemStyling:"FormItemStyling",
    updateState : function () {
        
        if (!this.isDrawn()) return;
        
        var showDebugLogs = this.logIsDebugEnabled(this._$FormItemStyling);
        
        // elements to style:
        // - cell
        
        if (this.containerWidget == this.form && !this._absPos()) {
            var cellStyle = this.getCellStyle();
            if (showDebugLogs) this.logDebug("About to apply basic cell style:"+ cellStyle, "FormItemStyling");
        
            // We'll either have a form cell around us, or we'll have written out an abolutely positioned
            // div
            var formCell = this.getFormCell();
            if (formCell) formCell.className = cellStyle;
            // If we have an outer table element we also apply the overall cellstyle to that
            var outerTable = this.getOuterTableElement();
            if (outerTable) outerTable.className = cellStyle;
            
            // Tell the form to update our title cell's state too.
            if (this.showTitle) this.form.updateTitleCellState(this);
        }
      
        if (this.showPickerIcon) {
            var controlStyle = this.getControlStyle(),
                pickerIconStyle = this.getPickerIconStyle();
                
                if (showDebugLogs) {
                    this.logDebug("About to apply cell styles to control box and picker icon cell:"+
                                    [controlStyle, pickerIconStyle], "FormItemStyling");
                                    
                }

            // - inner table (control style)
            var controlHandle = this._getControlTableElement();
            if (controlHandle) controlHandle.className = controlStyle;
            // - pickerIconBox
            var pickerIconHandle = this._getPickerIconCellElement();
            if (pickerIconHandle) pickerIconHandle.className = pickerIconStyle;
        }
            
        // - text box
        var textBoxStyle = this.getTextBoxStyle();
        if (showDebugLogs) this.logDebug("About to apply text box style:"+ textBoxStyle, "FormItemStyling");

        var textBoxHandle = this._getTextBoxElement();
        if (textBoxHandle) {
            textBoxHandle.className = textBoxStyle;
        }
        
        
        if (this._writeOutFocusProxy() && textBoxHandle) {
            if (!this._focusOutline) {
                // Size the focus outline to match this item's text box size, adjusted for
                // the fact that we always write out a 1px border
                var width = this.getTextBoxWidth(), height = this.getTextBoxHeight();
                width += isc.Element.getHBorderSize(textBoxHandle) -2;
                height += isc.Element.getVBorderSize(textBoxHandle) -2;
                 
                var focusOutlineID = this._getDOMID("focusOutline");
                isc.Element.insertAdjacentHTML(
                    textBoxHandle,
                    "beforeBegin",
                    "<DIV ID='" +  focusOutlineID + 
                    (this.textBoxStyle ? "' CLASS='" + this.textBoxStyle +  "Focused'" : "'") + 
                    " STYLE='background-image:none;background-color:transparent;position:absolute;width:" 
                    +
                    width + "px;height:" + height + 
                    "px;visibility:hidden;border:1px dotted white;z-index:100;'>&nbsp;</DIV>"
                );
                this._focusOutline = isc.Element.get(focusOutlineID);
            }
            
            if (this.hasFocus) this._focusOutline.style.visibility = "inherit";
            else this._focusOutline.style.visibility = "hidden";
        }
        
        
    },
    
    // We have a number of deprecated classNames as of 5.5 - helper method to log warnings
    _$deprecated:"deprecated",
    _warnDeprecated : function (oldPropertyName, newPropertyName, version) {
        if (!this.logIsInfoEnabled(this._$deprecated)) return;
        // Keep track of which property names we've already warned about on this item.
        if (!this._warnedDeprecated) this._warnedDeprecated = {};
        if (this._warnedDeprecated[oldPropertyName]) return;

        if (version == null) version = "5.5";
        var logString = isc.SB.create();
        logString.append(
            "Using '", oldPropertyName, "': ", this[oldPropertyName], 
            " to style this form item.  This property is deprecated as of SmartClient Version ",
            version, " - we recommend removing this property and using '", newPropertyName, "' instead.");
        this.logInfo(logString.release(), "deprecated");
        
        this._warnedDeprecated[oldPropertyName] = true;
    },
    
	//>	@method	formItem.getInnerHTML()		(A)
	//	Return the HTML for this formItem's element(s) and icons.
	//		@group	drawing
	//
	//		@param	value	(string)	Value of the element.
	//		@return			(HTML)	HTML output for this element
	//<
    
    getInnerHTML : function (value, includeHint, includeErrors, returnArray) {
    
        
        this._gotHintHTML = includeHint;
            
        var output;
        // If this element is disabled we write an event mask over it to capture mouse events.
        // This is required because we don't get any mouse events (at a native level) over 
        // disabled form items       
        if (this.isDisabled() && this.useDisabledEventMask()) {
            output = isc.SB.create();
            output.append(this._getEventMaskHTML());
        }

        // If we need to write out a hidden native data element, do so now.        
        if (this._useHiddenDataElement()) {
            if (!output) output = isc.SB.create();
            output.append(this._getHiddenDataElementHTML());
        }

        // Note that the tableHTML is an array
        var tableHTML = this._getTableHTML(value, includeHint, includeErrors);

        
        if (output != null) {
            output.append(tableHTML);

            if (returnArray) return output.getArray();
            return output.release();
            
        } else {
            return (returnArray ? tableHTML : tableHTML.join(isc.emptyString));
        }
    },
    
    _writeOuterTable : function (includeHint, hasLeftRightErrors) {
        if (hasLeftRightErrors) return true;
        
        if (includeHint && this.getHint() != null) return true;
        
        if (this.icons && this.icons.length > 0) return true;
    },

    // _getValueIcon()
    // Returns the URL for the value icon to show for this cell, or null if there is none.
    // Checks for the presence of this.getValueIcon, or this.valueIcons
     _$Over:"Over", _$Down:"Down", _$Disabled:"Disabled",
    _getValueIcon : function (value) {
        
        if (this.suppressValueIcon) return null;
        
        var icon,
            undef;
        if (value === undef) value = this.getValue();
        if (this.getValueIcon) icon = this.getValueIcon(value);
        // Default behavior
        else {
            if (value == null) icon = this.emptyValueIcon;
            else if (this.valueIcons != null) icon = this.valueIcons[value];
        }
        
        // We may (and commonly do) just not have a valueIcon
        if (icon == null) return null;
        
        // We need to be able to show over, disabled, focussed and 'mouseDown' state 
        // Required for the CheckboxItem
        // This is done independently of the cell style applied to the item's text.
        
        var newState = (this.isDisabled() && this.showValueIconDisabled ? this._$Disabled 
                                                                        : this._iconState);
        if (newState != null) {
            
            // Use caching to speed up image-name generation
            if (!isc.CheckboxItem._valueIconStateCache) isc.CheckboxItem._valueIconStateCache = {};
            var cacheObject = isc.CheckboxItem._valueIconStateCache[icon];
        
            if (!cacheObject) {
                cacheObject = {};
                cacheObject.Over = isc.Img.urlForState(icon, false, false, this._$Over);
                cacheObject.Down = isc.Img.urlForState(icon, false, false, this._$Down);
                cacheObject.Disabled = isc.Img.urlForState(icon, false, false, this._$Disabled);
                
                isc.CheckboxItem._valueIconStateCache[icon] = cacheObject;
            }
            
            icon = cacheObject[newState];
        }
        
        return icon;    
    },
    
    // _getValueIconHTML - returns the IMG tag to write out as our valueIcon
    // or null if we're not showing a valueIcon
    _$valueIcon:"valueIcon",
    _getValueIconHTML : function (value) {
        var valueIcon = this._getValueIcon(value);
        if (valueIcon == null) {
            return isc.emptyString;
        }
        
        var prefix = this.imageURLPrefix || this.baseURL || this.imgDir,
            suffix = this.imageURLSuffix;
        if (suffix) valueIcon = valueIcon + suffix;
        
        var valueIconWidth = this.getValueIconWidth();
        var valueIconHeight = this.getValueIconHeight();
        
        
        return isc.Canvas._getValueIconHTML(valueIcon, prefix, valueIconWidth, valueIconHeight,
                                              this.valueIconLeftPadding, this.valueIconRightPadding,
                                              this._getDOMID(this._$valueIcon));
    },
    
    // method to get a pointer to the valueIcon img element
    _getValueIconHandle : function () {
        if (!this.isDrawn()) return null;
        var img = isc.Element.get(this._getDOMID(this._$valueIcon));
        return img;
    },
    
    _$outerTableStartTemplate:[
        "<TABLE CELLSPACING=0 CELLPADDING=0 BORDER=0 ID='",         // 0
        ,                                                           // 1 [ID for outer table]
        // We'll apply the 'cellStyle' for the item to the outer table as styles won't
        // be inherited by sub elements of the table.
        // Explicitly avoid getting doubled borders etc.
        "' STYLE='" + isc.Canvas._$noStyleDoublingCSS,              // 2
        ,                                                           // 3 [css to override class attrs]
        "' CLASS='",                                                // 4
        ,                                                           // 5 [pick up the cellStyle css class]
        
        "'><TR>",                                                   // 6
        ,                                                           // 7 Potential first cell for 
                                                                    //   error on left...
        // Main cell - If we're showing a picker this will contain the 'control' table
        // If we're not showing a picker, this wll contain the 'text box'                                                                    
        "<TD style='",                                              // 8
        ,                                                           // 9 [possibly css for text box cell]
        "' VALIGN=",                                                // 10 
                
        ,                                                           // 11   [v align]
        ">"                                                         // 12
        // Either the text box element (returned by getElementHTML()) or an inner control table
        
    ],
    _$outerTableEnd:"</TD></TR></TABLE>",
    
    _$controlTableTemplate:[
       // Control table
       "<TABLE ID='",        // 0
       ,                     // 1 [ID for the table] this._getControlTablID()

       // By marking the control table with the 'itemPart' attributes we simplify determining
       // what "part" of the item recieved the event.
       "' " + isc.DynamicForm._containsItem + "='",                // 2
       ,                                                           // 3 [formItem ID]
       "' " + isc.DynamicForm._itemPart + "='" + isc.DynamicForm._controlTableString,       // 4
       "' CELLPADDING=0 CELLSPACING=0 STYLE='",                     // 5
       ,                    // 6 [css text for the control table]
       "' CLASS='",         // 7
       ,                    // 8 [control table className]
       
       // Text box cell
       "'><TR><TD style='", // 9
       ,                    // 10 [css text for textBox cell]
       "'>",                // 11

       // Text
       ,                    // 12 [textBox html]
       
       "</TD><TD ID='",     // 13
       ,                    // 14 [picker icon cell ID]
       "' CLASS='",         // 15
       ,                    // 16 [Picker Icon className]
       "' STYLE='",         // 17
       ,                    // 18 [picker icon css]
       "'>",                // 19
       ,                    // 20 [Picker Icon HTML]                
       "</TD></TR></TABLE>"
    ],
    
    _$iconsCellTemplate:[
        "</TD><TD VALIGN=",     // 0
        ,                       // 1 [v align property for icons]
        
        
        " WIDTH=",              // 2
        ,                       // 3 [total icons width]
        "><NOBR>",              // 4
        ,                       // 5 [icons HTML]
        "</NOBR>"
    ],
    _$hintCellTemplate : ["</TD><TD ID='", // 0
                            ,              // 1 this._getHintCellID()
                            "' CLASS='",   // 2
                            ,              // 3 this.getHintStyle() 
                            "'>"           // 4
                                           // 4 hint
    ],
    
    // helper method to return the HTML for the form item's outer element.
    
    
    // Returns an array of strings that form the appropriate HTML.
    
    _getTableHTML : function (value, includeHint, includeErrors) {
        
        
        var errorOrientation = this.getErrorOrientation(),
            showErrors,
            errorOnLeft = errorOrientation == isc.Canvas.LEFT,
            errorHTML;
        if (includeErrors && 
            (errorOnLeft || errorOrientation == isc.Canvas.RIGHT)) 
        {
            var errors = this.getErrors();
            if (errors) {
                showErrors = true;
                errorHTML = this.getErrorHTML(errors);
            }
        }
        
        var vAlign = this.iconVAlign,
            displayValue = this.mapValueToDisplay(value),
            writeOuterTable = this._writeOuterTable(includeHint, showErrors),
            writeControlTable = this.showPickerIcon;
        ;
        
        var template = writeOuterTable ? this._$outerTableStartTemplate : [];
        if (writeOuterTable) {
        
            
            template.length = 13;
            
            template[1] = this._getOuterTableID();
            template[3] = this.getOuterTableCSS();
            // Apply the cell style to the outer table so (EG) font color / weight get inherited
            // Note that we don't write out the 'cellStyle' at all unless the item is
            // written into a DF cell
            if (this.containerWidget == this.form && !this._absPos()) {            
                template[5] = this.getCellStyle();
            } else {
                template[5] = null;
            }
            
            // If we show the error on the left this is where we output it...
            if (showErrors && errorOnLeft) {
                template[7] = "<TD>" + errorHTML + "</TD>";
            } else template[7] = null;
                    
            // If the first cell of the outer table contains the text box, write out the 
            // appropriate css text
            if (!writeControlTable) template[9] = this.getTextBoxCellCSS();
            else template[9] = null;
            // First cell            
            template[11] = vAlign;
            
        }
        
        
        // Logic is quite different for showing a picker icon vs not showing a picker icon.
        if (!writeControlTable) {

            // write the element HTML (text box) directly into the outer table's first cell
            
            // Note - if we are showing a valueIcon, it will be included in the HTML returned
            // from getElementHTML()
            template[template.length] = this.getElementHTML(displayValue);
        } else {
            
            var pickerIconStyle = this.getPickerIconStyle(),
                itemID = this.getID(),
                controlStyle = this.getControlStyle(),
                controlTemplate = this._$controlTableTemplate,
                controlHandleID = this._getControlTableID(),
                textBoxID = this._getTextBoxID(),
                pickerCellID = this._getPickerIconCellID()
            ;

            controlTemplate[1] = controlHandleID;
            controlTemplate[3] = itemID;
            controlTemplate[6] = this.getControlTableCSS();
            // If no control table style was explicitly specified, pick up the style for the
            // DF cell containing this item (as it will not cascade up through the table element
            
            if (controlStyle == null && this.containerWidget == this.form && !this._absPos()) {
                controlTemplate[8] = this.getCellStyle();
                controlTemplate[6] += isc.Canvas._$noStyleDoublingCSS;
            } else {
            	controlTemplate[8] = controlStyle
            }
            controlTemplate[10] = this.getTextBoxCellCSS();
            controlTemplate[12] = this.getElementHTML(displayValue);
            controlTemplate[14] = pickerCellID;
            controlTemplate[16] = pickerIconStyle;
            controlTemplate[18] = this.getPickerIconCellCSS();
            var PI = this.getPickerIcon(),
                showPIFocus = PI && this.hasFocus && this.showFocusedPickerIcon &&
                                (PI.showFocusedWithItem != false); 
            controlTemplate[20] = this.getIconHTML(this.getPickerIcon(), showPIFocus);
            
            // Actually write out the control table in the cell
            for (var i = 0; i < controlTemplate.length; i++) {
                template[template.length] = controlTemplate[i];
            }
        }
        
                
        if (writeOuterTable) {
            if (this._hasExternalIcons()) {
            
                var iconsTemplate = this._$iconsCellTemplate;
                iconsTemplate[1] = vAlign;
                iconsTemplate[3] = this.getTotalIconsWidth();
                iconsTemplate[5] = this.getIconsHTML();
                
                for (var i = 0; i < iconsTemplate.length; i++) {
                    template[template.length] = iconsTemplate[i];
                }
            } 
        
            var showRightError = (showErrors && !errorOnLeft);
            var hint;
            if (includeHint) {
                hint = this.getHint();
                if (isc.isA.emptyString(hint)) hint = null;
            }
            if (hint || showRightError) {
                var hintCellTemplate = this._$hintCellTemplate;
                hintCellTemplate[1] = this._getHintCellID();
                hintCellTemplate[3] = hint ? this.getHintStyle() : null;
                hintCellTemplate[5] = (hint || "") + (showRightError ? errorHTML || "" : "");
                for (var i = 0; i < hintCellTemplate.length; i++) {
                    template[template.length] = this._$hintCellTemplate[i];
                }
            }
            // close the table
            template[template.length] = this._$outerTableEnd;
        }
        
        return template;
	},
    
    _$outerTable:"_outerTable",
    _getOuterTableID : function () {
        return this._getDOMID(this._$outerTable);
    },
    
    // Retrieving Stylenames
    // --------------------------------------
    
    // Helper to get style name from base style based on current state
    _getCellStyle : function (baseStyle) {
        var hasErrors = this.hasErrors(); 

        // Use caching to speed up style-name generation
        if (!isc.FormItem._cellStyleCache) isc.FormItem._cellStyleCache = {};
        var cacheObject = isc.FormItem._cellStyleCache[baseStyle];
        
        if (!cacheObject) {
            cacheObject = {};
            cacheObject.Error = baseStyle + "Error";
            cacheObject.Focused = baseStyle + "Focused"
            cacheObject.Disabled = baseStyle + "Disabled"
            
            isc.FormItem._cellStyleCache[baseStyle] = cacheObject;
        }
        
        
        // if we have an error always just return the error state
        if (hasErrors) {
            return (this.shouldShowErrorStyle() && this.form.showInlineErrors 
                        ? cacheObject.Error : baseStyle);
        } else {
            // suppress focused styling when printing
            if (this.showFocused && this.hasFocus && !this.isPrinting) 
                return cacheObject.Focused;
            if (this.showDisabled && this.isDisabled()) return cacheObject.Disabled;
            // Otherwise "normal" state.
            return baseStyle;
        }
    },
    
    //>@method  FormItem.getCellStyle() (A)
    // Function to retrieve the css style class name to apply to this form item's cell.
    // Derives the style name from <code>this.cellStyle</code>
    // @return CSSStyleName css class to apply to the cell
    //<
    // In some cases we apply the base cells tyle to sub items within the cell. In this case
    // avoid logging warnings if the deprecated styling property attributes are set, so we
    // don't warn repeatedly per rendered item.
    getCellStyle : function () {
    
        // For items written into a container item, allow the container item to override the
        // cellStyle, so it can re-skin it's child items effectively
        if (this.parentItem != null) {
            if (this.parentItem.itemCellStyle) return this._getCellStyle(this.parentItem.itemCellStyle);
        }
    
        var className = this._getCellStyle(this.cellStyle);
        //>!BackCompat 2006.3.9
        // If the  old styling properties are set have them take precedence over the 
        // new  style names since new names will typically be present from the skin files,
        // but old app code will not know about the new names
        if (!this.hasErrors()) {
            // If the deprecated 'cellClassName' property is set, use that
            if (this.cellClassName != null) {
                this._warnDeprecated("cellClassName", "cellStyle");
                className = this.cellClassName;
            }
        } else {
            // If the deprecated 'errorCellClassName' proeprty is set, use that
            if (this.errorCellClassName != null) {
                this._warnDeprecated("errorCellClassname", "cellStyle");
                className = this.errorCellClassName;
            }
        }
        //<!BackCompat
        return className;
    },

    //>@method  FormItem.getTitleStyle() (A)
    // Function to retrieve the css style class name to apply to this form item's title cell.
    // Derives the style name from <code>this.titleStyle</code>
    // @return CSSStyleName css class to apply to the cell
    //<    
    getTitleStyle : function () {
        // If we are printing default to this.printTitleStyle if specified
        
        if (this.containerWidget && this.containerWidget.isPrinting && this.printTitleStyle) {
            return this._getCellStyle(this.printTitleStyle); 
        } 
        var error = this.getErrors();
        if (error == isc.emptyString) error = null;
        var className = this._getCellStyle(this.titleStyle);
        //>!BackCompat 2006.3.9
        if (!error) {
            // If the deprecated 'titleClassName' property is set, use that
            if (this.titleClassName != null) {
                this._warnDeprecated("titleClassName", "titleStyle");
                className = this.titleClassName;
            }
        } else {
            // If the deprecated 'titleErrorClassName' proeprty is set, use that
            if (this.titleErrorClassName != null) {
                this._warnDeprecated("titleErrorClassName", "titleStyle");
                className = this.titleErrorClassName
            }
        }        
        //<!BackCompat
        return className;
        
    },
    
    //>@method  FormItem.getHintStyle() (A)
    // Function to retrieve the css style class name to apply to this form item's hint text
    // Derives the style name from <code>this.hintStyle</code>
    // @return CSSStyleName css class to apply to the cell
    //<
    getHintStyle : function () {
            
        //>!BackCompat 2006.3.9
        if (this.hintClassName != null) {
            this._warnDeprecated("hintClassName", "hintStyle");
            return this.hintClassName;
        }
        //<!BackCompat
        if (this.hintStyle != null) return this.hintStyle;
        
    },
    
    // The text box is the element that we write into the first cell of the table control
    // table which contains the textual value of the form item.
    // This is written out by this.getElementHTML and by default is a DIV.
    
    getTextBoxStyle : function () {
        if (this.containerWidget && this.containerWidget.isPrinting && this.printTextBoxStyle) {
            return this._getCellStyle(this.printTextBoxStyle);
        }
        var styleName = this.textBoxStyle ? this._getCellStyle(this.textBoxStyle) : null;
        //>!BackCompat 2006.3.9
        // deprecated input element style
        if (this.elementClassName != null) {
            this._warnDeprecated("elementClassName", "textBoxStyle");
            styleName = this.elementClassName;
        } 
        //<!BackCompat
        return styleName;
    },
    
    // Styling applied to the table cell containing the picker icon (if we're showing one)
    getPickerIconStyle : function () {
        if (this.pickerIconStyle != null) return this._getCellStyle(this.pickerIconStyle);
        // allow styling to be inherited from our parent table
        return null;
    },
    
    // Styling applied to the 'control' table - only rendered if we're showing a picker icon - 
    // contains the main text box and the picker icon.
    getControlStyle : function () {
        if (this.controlStyle != null) return this._getCellStyle(this.controlStyle);
        return null;
    },      
    
    // CSS Generation
    // -----------------
    // Method to return custom CSS styling for various parts of the form item
    
    _$wrapCSS:"white-space:normal;",_$nowrapCSS:"white-space:nowrap;",
    _$minWidthColon:"min-width:", _$minHeightColon:"min-height:",
    _$widthColon:"width:", _$heightColon:"height:", _$pxSemi:"px;", _$semi:";",
    
    _$cachedOuterTableCSS:{},
    getOuterTableCSS : function () {
        
        var cacheObject = this._$cachedOuterTableCSS;
        
        
        var width = this.getInnerWidth();
        
        
        if (!isc.isA.Number(width)) {
            if (!this._$nowidthOuterTableCSS) 
                this._$nowidthOuterTableCSS = this._$wrapCSS;
            return this._$nowidthOuterTableCSS;
        } else if (cacheObject[width] != null) {
            return cacheObject[width];
        }
        
        var output = isc.SB.create();
        output.append(this._$wrapCSS);   
        
        output.append(this._$widthColon);
        output.appendNumber(width, 5);
        output.append(isc.semi);
        
        cacheObject[width] = output.release();
        
        return cacheObject[width];
    },
    
    // Control table
    
    // Retrieve style text to apply to the controlbox table, if we're writing one out.
    _$defaultCursor:"cursor:default;",
    getControlTableCSS : function () {
        var output = isc.SB.create();
        output.append(this._$defaultCursor);
        
        // The control-table should be sized to the 'innerWidth', minus the size of any
        // external icons. This is currently available as this.getElementWidth()
        var width = this.getElementWidth() - this.getErrorWidth();
        if (isc.isA.Number(width)) output.append(this._$widthColon, width, this._$pxSemi);
        
        // no need to specify height - we will pick this up from the text box element

        return output.release();
    },

    // Text Box Cell

    // By default we don't need to apply styling to the cell containing the textBox
    // May be overridden by subclasses
    getTextBoxCellCSS : function () {
        return this.textBoxCellCSS;
    },
    
    // Retrieve style text to apply directly to the text box
    _$overflowHiddenCSS:"overflow:hidden;",
    _$textAlignColon:"text-align:",
    getTextBoxCSS : function () {
        var output = isc.SB.create();

        
        var elementWidth = this.getTextBoxWidth();        
        if (isc.isA.Number(elementWidth)) {
            if ((isc.Browser.isOpera || isc.Browser.isMoz || isc.Browser.isSafari) && !this.clipValue) {
                output.append(this._$minWidthColon, elementWidth, this._$pxSemi);
            } else {
                output.append(this._$widthColon, elementWidth, this._$pxSemi);
            }
        }

        var height = this.getTextBoxHeight();
        if (isc.isA.Number(height)) {
            if (isc.Browser.isMoz && !this.clipValue) {
                output.append(this._$minHeightColon, height, this._$pxSemi);
            } else {
                output.append(this._$heightColon, height, this._$pxSemi);
            }
        }

        // Don't allow overflow if clipValue is true.    
        if (this.clipValue) output.append(this._$overflowHiddenCSS);
        
        if (this.wrap) output.append(this._$wrapCSS) 
        else output.append(this._$nowrapCSS);
        
        if (this.textAlign != null) {
            output.append(this._$textAlignColon, this.textAlign, this._$semi);
        }
        
        return output.release();
    },
    
    // custom styling for picker icon cell
    
    _$fontSize:"font-size:",
    getPickerIconCellCSS : function () {
        // Not required in IE
        if (isc.Browser.isIE) return isc.emptyString;
        
        var height = this.getPickerIconHeight();
        if (isc.isA.Number(height) && height < this.getInnerHeight()) {
            return this._$fontSize + height + this._$pxSemi;
        }
        return isc.emptyString;
    },
    
    // Helper method to get the properties this item's picker icon if 'showPickerIcon' is true.
    
    getPickerIcon : function () {
        if (this._pickerIcon == null) {
            var pickerIconWidth = this.getPickerIconWidth(),
                pickerIconHeight = this.getPickerIconHeight();
            
            var props = {
                // Flag this as the picker icon to simplify any special manipulation
                pickerIcon:true,
                
                writeIntoItem:true,
                showOver:this.showOver,
                showFocused:this.showFocusedPickerIcon,
                hspace:this.pickerIconHSpace,
                
                // Customizeable properties:
                width:pickerIconWidth,
                height:pickerIconHeight,
                src:this.pickerIconSrc,
                
                // imgOnly
                
                click: function (form,item,icon) { item.showPicker() }
            };
            
            isc.addProperties(props, this.pickerIconDefaults, this.pickerIconProperties);
            
            // apply an ID to it to make it a 'valid' icon type object - allows us to get
            // a pointer to its HTML element
            if (props._id == null) this._setIconId(props);

            this._pickerIcon = props;
            
            // We need to have the _disabled flag be set from when the picker icon is
            // first drawn so subsequent enable() / disable()s will update it.
            if (this.iconIsDisabled(props)) props._disabled = true;
        }   
        
        return this._pickerIcon;
    },
            
    // getElementHTML() - writes out the valueIcon (if present) and text box for the form item
    // For form items using a native HTML Form element such as <input>, this method returns 
    // that element's HTML
    
    
    _$accessKeyEquals:" ACCESSKEY='",
    _$tabIndexEquals:" TABINDEX='",
    _$singleQuote:"'",
    _$textBoxTemplate:[ "<DIV ID='", // 0
                        ,            // 1: ID for text box
                        // By marking the textBox with the 'itemPart' attributes we simplify 
                        // determining what "part" of the item recieved the event.
                        "' " + isc.DynamicForm._containsItem + "='",                // 2
                        ,            // 3 [formItem ID]
                        "' " + isc.DynamicForm._itemPart + "='" + isc.DynamicForm._textBoxString, // 4
                        "' CLASS='", // 5
                        ,            // 6: this.getTextBoxStyle(),
                        "' STYLE='", // 7
                        ,            // 8: this.getTextBoxCSS(), 
                        "'",         // 9
                        ,            // 10: textBoxFocusAttributes,
                        ">",         // 11
                        ,            // 12: valueIcon HTML (if required)
                        ,            // 13: actual value
                        "</DIV>"
                      ],
    getElementHTML : function (value) {
        
        var output = isc.SB.create(),
            useFocusProxy = this._writeOutFocusProxy();

        
        var canFocus = this._canFocus(),
            textBoxFocusAttributes,
            focusProxyString;
        
        if (canFocus) {
            // If we're disabled tabIndex will currently be -1. However we don't clear 
            // this.accessKey, so do an explicit check to avoid writing out an accessKey on
            // a disabled form item
            var tabIndex = this._getElementTabIndex(),
                accessKey = this.isDisabled() ? null : this.accessKey;
            if (useFocusProxy) {
                focusProxyString = isc.Canvas.getFocusProxyString(
                                        this.getID(),
                                        // position the focus proxy at 0,0 in the approprate
                                        // table cell
                                        
                                        false, 0, 0,
                                        
                                        this.getTextBoxWidth(), this.getTextBoxHeight(),
                                        this.isVisible(), !this.isDisabled(),
                                        tabIndex, accessKey,
                                        // Events on this focus proxy will be handled by the ISC
                                        // eventHandling system 
                                        
                                        false
                            );    
            } else {
                var attrs = isc.SB.create();
                if (accessKey != null) attrs.append(this._$accessKeyEquals, accessKey, this._$singleQuote);
                attrs.append(this._$tabIndexEquals, tabIndex, this._$singleQuote);
                textBoxFocusAttributes = attrs.release();
            }
        }
    
        if (focusProxyString != null) output.append(focusProxyString);
        
        var tbTemplate = this._$textBoxTemplate;
        tbTemplate[1] = this._getTextBoxID();
        tbTemplate[3] = this.getID();
        tbTemplate[6] = this.getTextBoxStyle();        
        tbTemplate[8] = this.getTextBoxCSS();
        tbTemplate[10] = textBoxFocusAttributes; // Will be null if appropriate

        // Pre-pend the value with the valueIconHTML [will be null if appropriate]
        
        tbTemplate[12] = this._getValueIconHTML(this._value);
        tbTemplate[13] = (this.showValueIconOnly ? null : value);
        
        output.append(tbTemplate);
        
        //this.logWarn("element HTML:"+ output.toString());
        return output.release();                      
    },    
    
    // If we are focusable and not flagged as having an 'inputElement' use a focus proxy 
    // wherever we can't make a DIV natively focusable 
    
    _writeOutFocusProxy : function () {
        return (isc.Browser.isSafari || 
                (isc.Browser.isMoz && isc.Browser.geckoVersion < 20051111) && 
                this._canFocus() && !this.hasDataElement());
    },
    
    // Helper method for HTML parts:
    
    _getItemElementAttributeHTML : function () {
        if (!isc.FormItem._itemElementAttrHTML) {
            isc.FormItem._itemElementAttrHTML =  [
                " ", isc.DynamicForm._containsItem, "='", 
                null,   // item ID
                "' ",
                isc.DynamicForm._itemPart, "='", isc.DynamicForm._element, "'"
            ];
        }
        isc.FormItem._itemElementAttrHTML[3] = this.getItemID();
        return isc.FormItem._itemElementAttrHTML.join(isc.emptyString);
    },

	//>	@method	formItem.getErrors()	(A)
	// Return the validation errors in the form associated with this item, if any.
    // Errors will be returned as either a string (single error message) or an array of strings
    // (multiple error messages).
	//  @return	(string | array) Error message(s) for this item.
    // @group errors
	//<
	getErrors : function () {
        if (this.form) return this.form.getFieldErrors(this);
	},
    
    // getError() synonym for getErrors() for backcompat
    
    getError : function () {
        //>DEBUG
        this.logWarn("call to deprecated method FormItem.getError()." +
                     " Use FormItem.getErrors() instead."
                     
                     );
        //<DEBUG
        return this.getErrors();
    },
    
    // getErrorMessage - given an error string or array of errors - return it formatted as HTML for
    // display
    getErrorMessage : function (error) {
        return (isc.isAn.Array(error) ? "<UL><LI>" + error.join("</LI><LI>") + "</LI></UL>" 
                                      : error);
    },
    
    // shouldShowErrorIcon / text / style helpers
    // Allows for form level control of whether error icons/text shows up inline
    shouldShowErrorIcon : function () {
        return this.showErrorIcon != null ? this.showErrorIcon : this.form.showErrorIcons; 
    },
    shouldShowErrorText : function () {
        return this.showErrorText != null ? this.showErrorText : this.form.showErrorText;
    },
    shouldShowErrorStyle : function () {
        return this.showErrorStyle != null ? this.showErrorStyle : this.form.showErrorStyle;
    },
    // by default show hover prompts on the icon if we're showing the icon but not the message
    shouldShowErrorIconPrompt : function () {
        return this.shouldShowErrorIcon && !this.shouldShowErrorText();
    },
    
    // should the error show up above / below / left/right of the item?
    getErrorOrientation : function () {
        return this.errorOrientation != null ? this.errorOrientation : this.form.errorOrientation;
    },

	
    //>	@method	formItem.getErrorHTML()	(A)
    // Output the HTML for an error message in a form element. Default behavior respects
    // +link{FormItem.showErrorIcon} and +link{FormItem.showErrorText} as described in the
    // documentation for those attributes.
    // @param error (string | array) error message string or array of error messages
    // @return (HTML) HTML to display the error
    // @visibility external
	//<
	getErrorHTML : function (error) {
        if (!this.shouldShowErrorText() && !this.shouldShowErrorIcon()) return isc.emptyString;
        
		var form = this.form,
            // If we are writing out an error icon, use a table to insure:
            // - if we're showing a single error message that wraps it doesn't
            //   wrap UNDERNEATH the error icon
            // - if we're showing multiple error messages in a bulleted list the icon
            //   appears to the left of the list rather than appearing above it on a 
            //   separate line
            writeTable = this.shouldShowErrorIcon() && this.shouldShowErrorText(),
                        // We may want to make this setting hierachical - so it can be set at 
                        // the item or validator level as well
            titleText = (this.shouldShowErrorText() && this.form.showTitlesWithErrorMessages &&
                         this.getTitle() != null ? this.getTitle() + ": " : null),
            output;
            
            var messageString = this.shouldShowErrorText() ? this.getErrorMessage(error) : null;
            
            if (!writeTable) {
    			output = isc.SB.concat("<DIV style='display:inline;' CLASS='" 
                        , this.getCellStyle() , "'>" 
                        , (this.shouldShowErrorIcon() ? this.getErrorIconHTML(error) + "&nbsp;" : null)
                        , titleText
						, messageString
						, "</DIV>"
				);
            } else {
                
                output = isc.SB.concat("<TABLE WIDTH=100% CELLSPACING=0 CELLPADDING=0><TR>",
                        "<TD WIDTH=",this.errorIconWidth,">"
                        // If we're writing a table we know we're always writing out the icon
                        , this.getErrorIconHTML(error)
                        , "</TD><TD STYLE='", isc.Canvas._$noStyleDoublingCSS, "' CLASS='" , 
                            this.getCellStyle() , "'>&nbsp;"                         
                        , titleText
                        , messageString
						, "</TD></TR></TABLE>"
	            );
            }
		return output;
	},
    
    getErrorIconHTML : function (error) {
        var id = this.getErrorIconId();
        
        var promptString = this.shouldShowErrorIconPrompt() 
                            ? isc.FormItem.getErrorPromptString(error, true) 
                            : isc.emptyString;
        
        
        return this._getIconImgHTML(
                // unique ID for the img
                id, 
                this.errorIconWidth, this.errorIconHeight,
                //vAlign for the icon
                "top", 
                0,  // vMargin
                // No left margin for the icon, no background-color for this icon
                null,
                null,
                
                // Src 
                
                this.form.getImgURL(this.errorIconSrc),
                // Form item ID
                this.getID(), 
                
                // use the same ID for the icon id (used for event handling) as for the element 
                // in the DOM
                id,
                null,
                // special flag to avoid 'display:block' in standards mode
                true,
                // and extraStuff for the prompt, until we start using iconHovers...
                " title='" + promptString + "'"
        );
    },
    
    getPromptString : function (error) {
        
    },
    
    getErrorIconId : function () {
        return this._getDOMID("error");
    },
    
	//>	@method	textItem.getHint()	(A)
	//	Returns the hint text for this item. Default implementation returns +link{FormItem.hint}, or
    //  null if there is no hint to show.
    //
	// @group	appearance
	// @return	(HTML)		HTML to show as the hint for the item
    // @visibility external
	//<
    getHint : function () {
		if (!this.showHint || !this.hint) return null
        return this.hint;
	},
    
    // Drawing
    // ----------------------------------------------------------------------------------------
    // Form items don't write themselves into the DOM - this is typically handled by their
    // dynamicForm, or for 'standalone items', this is handled by the items' containerWidget.
    // The code to write the items out into the DOM should also notify the form items that they
    // have been written into the DOM, to allow us to perform 'isDrawn()' checks and perform
    // any necessary manipulations of the items' data element.
    
    
    //> @method formItem.drawn() 
    // Notification function to be fired on the form item when the item has been written into
    // the DOM by some container widget.
    //
    // @group drawing
    // @visibility internal
    //<
    _$drawing:"drawing",
    drawn : function () {

    	//>DEBUG
        if (this.logIsInfoEnabled(this._$drawing)) {
        	this.logInfo("Form item drawn " + 
                         (this.containerWidget == this.form ? 
                                "in form " + this.form.getID() :
                                "in container widget " + this.containerWidget.getID()) +
                         (this.logIsDebugEnabled("drawing") ? this.getStackTrace() : ""), 
                         "drawing");
        }
        //<DEBUG

        this._drawn = true;
        if (this._gotHintHTML) this._wroteOutHint = true;
        this._gotHintHTML = null;
        this._applyHandlersToElement();

        if (isc.screenReader) this.addContentRoles();
    },
    
    // fired when this item is about to be redrawn
    
    redrawing : function () {
        this.form.clearingElement(this);
        this._absDiv = null;
    },
    
    //> @method formItem.redrawn() 
    // Notification function to be fired on the form item when the items HTML has been redrawn
    // by some container widget.
    //
    // @group drawing
    // @visibility internal    
    //<
    redrawn : function () {   
    	//>DEBUG
        if (this.logIsInfoEnabled("drawing")) {
        	this.logInfo("Form item redrawn " + 
                         (this.containerWidget == this.form ? 
                                "in form " + this.form.getID() :
                                "in container widget " + this.containerWidget.getID()) +
                         (this.logIsDebugEnabled("drawing") ? this.getStackTrace() : ""), 
                         "drawing");
        }
        //<DEBUG

        // clear pointer to data element
        this._clearCachedHandles();

        this._applyHandlersToElement();

        if (isc.screenReader) this.addContentRoles();
    },
    
    
    _applyHandlersToElement : function () {
        //!DONTCOMBINE

        if (this._canFocus()) {
            var element = this.getFocusElement();
            if (!element) {
                this.logWarn("Attempting to apply event handlers to this item. " + 
                            "Unable to get a pointer to this item's focus element");
                return;
            }
            
            // Apply focus/blur handlers to the focus element. These fall through to 
            // formItem._nativeElementFocus() / formItem._nativeElementBlur()
            element.onfocus = isc.FormItem._nativeFocusHandler;
            element.onblur = isc.FormItem._nativeBlurHandler;
            
            // IE fires proprietary oncut / onpaste events. Set up handlers for these so we 
            // can detect changes due to paste triggered from a menu option as well as from 
            // keypresses.
            
            if (isc.Browser.isIE) {
                element.onpaste = isc.FormItem._nativeCutPaste;
                element.oncut= isc.FormItem._nativeCutPaste;
            }
                
            // Support a generic way to apply native event handlers to the element without
            // overriding this method.
            //  this._nativeEventHandlers is expected to be an object of the format
            //   {nativeHandlerName:function}
            // [Don't apply these handlers to icons!]
            if (this._nativeEventHandlers) {    
                for (var handler in this._nativeEventHandlers) {
                    element[handler] = this._nativeEventHandlers[handler];
                }
            }
        }
        
        this._setUpIconEventHandlers();
    },
    
    _setUpIconEventHandlers : function () {
        // If we have any icons, we need to apply focus/blur handlers to them as well.
        // Note that we may draw/clear icons independantly of redrawing the form item, so we
        // need a separate method to handle them being drawn
        if (this.showPickerIcon) this._iconDrawn(this.getPickerIcon());
        if (this.showIcons && this.icons && this.icons.length > 0) {
    
            for (var i = 0; i < this.icons.length; i++) {
                var icon = this.icons[i];
                if (icon && (this._writeIconIntoItem(icon) || this._shouldShowIcon(icon)))
                    this._iconDrawn(icon);
            }
        }    
    },
    
    // Notification function fired whenever an icons is written into the DOM.
    // Allows us to apply event handlers directly to the icon rather than writing them out
    // as part of the icon's HTML
    _$hash:"#",
    _iconDrawn : function (icon) {
        if (!icon.imgOnly) {
            var link = this._getIconLinkElement(icon);

            if (link) {
                link.onfocus = isc.FormItem._nativeIconFocus
                link.onblur = isc.FormItem._nativeIconBlur
                
                // The link needs an HREF or it will not be focus-able
                link.href = this._$hash;

                // Write out an onclick handler that simply stops us navigating to the href
                // for the icon's link.  We will fire the icon's click action via
                // standard form item click handling 
                link.onclick = isc.FormItem._nativeIconClick;

                // In Safari (1.2.3), by default <a>'s don't get native focus either from clicking 
                // on them or from tabbing to them.
                // However if you explicitly call focus() on those elements, they do get native
                // focus.
                // Put focus onto these items on mousedown by default 
                
                if (isc.Browser.isSafari) {
                    if (!isc.FormItem._nativeIconMouseDown) {
                        isc.FormItem._nativeIconMouseDown = function () {
                            var itemInfo = isc.DynamicForm._getItemInfoFromElement(this),
                                item = itemInfo.item,
                                iconID = itemInfo.overIcon;
                            if (item) return item.focusInIcon(iconID);                          
                        }
                    }
                    link.onmousedown = isc.FormItem._nativeIconMouseDown;
                }
            }
                
        }
        
        
    
    },
    
    //> @method formItem.cleared() 
    // Notification function to be fired on the form item when the items HTML has been removed
    // from the DOM by some container widget.
    //
    // @group drawing
    // @visibility internal    
    //<
    cleared : function () {
    	//>DEBUG
        if (this.logIsInfoEnabled("drawing")) {
        	this.logInfo("Form item cleared " + 
                         (this.containerWidget == this.form ? 
                                "from within form " + this.form.getID() :
                                "from within container widget " + this.containerWidget.getID()) +
                         (this.logIsDebugEnabled("drawing") ? this.getStackTrace() : ""), 
                         "drawing");
        }
        //<DEBUG
        this.form.clearingElement(this);
        
        this._clearCachedHandles();
        this._wroteOutHint = false;
        this._gotHintHTML = false;
        this._drawn = false;
    },

    _clearCachedHandles : function () {
        this._dataElement = null;
        this._absDiv = null;
        this._focusProxyHandle = null;
        this._htmlPartHandles = {};
    },

    //> @method formItem.isDrawn() 
    // Returns true if this item has been written out into the DOM.
    //
    // @group drawing
    // @visibility external
    //<
    isDrawn : function () {
        return this._drawn;
    },
 
    // Icons   
	// -----------------------------------------------------------------------------------------
    
    // _setUpIcons called at init time.  This should apply default properties to icons as
    // required.
    _setUpIcons : function () {
        var icons = this.icons;
        if (icons == null) return;

        for (var i = 0; i < icons.length; i++) {
            var icon = icons[i];
            
            this._setUpIcon(icon);
        }
        
    },
    
    // _setUpIcon - run by setUpIcon() on each specified icon object to apply required 
    // properties such as ID.
    // Split into a separate method so this can be called separately if icons are applied after
    // setUpIcons has been run (See ExpressionItem for an example of this)
    _setUpIcon : function (icon) {
        // apply an identifier to the icon (to be written into the DOM) to ensure that the
        // appropriate click action is fired on a click, and allow us to get a pointer
        // back to the icon image / link elements in the DOM
        if (icon._id == null) this._setIconId(icon);
            
        // Set the '_disabled' flag on the icon. We use this to track whether we need to
        // update HTML when the icon gets enabled / disabled
        if (this.iconIsDisabled(icon)) icon._disabled = true;
    },

    
    //> @method	formItem.getIconsHTML()  (A)
    //  Return the HTML to draw any icons to be displayed after the form item
	//  @group  appearance
    //
    //      @return (HTML)      HTML for the icons
    //<
    getIconsHTML : function () {

        if (!this.showIcons || this.icons == null) return "";
        var hasFocus = this._hasRedrawFocus(true);
        
        if (this.showIconsOnFocus && !hasFocus) {
            this.hideAllIcons();
            return "";
        }
        
        var output = isc.SB.create();
        
        for (var i = 0; i < this.icons.length; i++) {

            var icon = this.icons[i];
            // don't write out the icon if it specified a showIf, which returns false
            if (!this._shouldShowIcon(icon) || this._writeIconIntoItem(icon)) continue;
            
            var showFocused = hasFocus && this._iconShouldShowFocused(icon, true);
            output.append(this.getIconHTML(icon, null, this.isDisabled(), !!showFocused));
        }
        
        return output.release();
    },
    
    // Helper method to determine if an item (or one of it's subItems) has focus before redraw
    _hasRedrawFocus : function (checkSubItems) {
        var hasFocus = this.hasFocus ||  this._hadFocusBeforeRedraw;
        // If we have sub items, check for whether one of those has focus
        if (checkSubItems && !hasFocus && this.items != null) {
            for (var i = 0; i < this.items.length; i++) {
                if (this.items[i].hasFocus || this.items[i]._hadFocusBeforeRedraw) hasFocus = true;
                break;
            }
        }
        
        return hasFocus;
    },
    
    _setIconId : function (icon) {
        if (icon._id != null) return icon;        
        if (this._nextIconId == null) this._nextIconId = 0;
        icon._id =  "_" + this._nextIconId++;
        return icon;
    },
    
    
    _getIconVAlign : function (icon) {
        // Don't write out a vertical-align css property for the picker icon
        if (this._pickerIcon && (icon == this._pickerIcon)) return null;
        
        var alignment = this.iconVAlign;
        
        if (alignment == isc.Canvas.TOP) {
            return "top";            
        } else if (alignment == isc.Canvas.BOTTOM) {
            return (isc.Browser.isSafari ? "bottom" : "text-bottom");
        } else if (alignment == isc.Canvas.CENTER) {
            return "middle"
        }
        
        // if we don't recognize the alignment, just return it. 
        return alignment;
    },
    
    // _getIconVMargin - return a value to write as a top / bottom margin onto the icons' img
    // tag
    
    _getIconVMargin : function () {
        return 0;
    },
    
    // Helper to get the prompt for the icon, if there is one.
    getIconPrompt : function (icon) {
        return icon.prompt || this.iconPrompt;
    },
    
    // Gets the src for an icon's image.
    getIconURL : function (icon, over, disabled, focused) {        
        var src = icon.src || this.defaultIconSrc,
            state = (disabled || this.iconIsDisabled(icon)) ? isc.StatefulCanvas.STATE_DISABLED 
                                                : over ? isc.StatefulCanvas.STATE_OVER : null;

        src = isc.Img.urlForState(src, false, focused, state);
        return src;
    },
    
        
    // getIconHTML() retrieves the HTML for icons.
    // By default icons are written into the DOM after the form item. However we also use this
    // method for icons written directly into the form item's HTML (see the SelectItem for
    // an example of this).
    getIconHTML : function (icon, over,disabled,focused) {            
        var iconSrc = this.getIconURL(icon, over,disabled,focused),
            width = this.getIconWidth(icon),
            height = this.getIconHeight(icon),
            hspace = (icon.hspace != null ? icon.hspace : this.iconHSpace),
            backgroundColor = icon.backgroundColor,
            formID = this.form.getID(),
            // Remember - this is a global ID for this Form Item Instance, so can be used
            // as window[itemID].foo(), as well as being passed to the 'bubbleEvent()' method
            // on the Form.
            itemID = this.getItemID(),
            iconID = icon._id;        
        // If the icon is marked as 'imgOnly', just return the img tag - event handling should
        // be handled by the Form Item itself
        if (icon.imgOnly) {
            
            return this._getIconImgHTML(
                                this._getIconImgId(iconID),
                                width, 
                                height, 
                                this._getIconVAlign(icon),
                                this._getIconVMargin(icon),
                                // If it's just an image we always put hspace onto the image tag
                                // as a left margin
                                hspace,
                                backgroundColor,
                                iconSrc, 
                                itemID,
                                iconID
                    );
        
        // We embed the icon in a link to make it focusable
        
        } else {

            
            if (isc.FormItem._iconTemplate == null) {
                isc.FormItem._iconTemplate = [
                    // link html
                    "<a ID='",                  // 0
                    ,                           // 1: link elementID: this._getIconLinkId(icon._id)
                    "'",                        // 2
                      
                    
                    " style='font-size:1px;margin-left:",     // 3
                    ,                           // 4: icon h-space: hspace
                    "px;"
                    + (isc.Browser.isMoz ? "-moz-user-focus:" : ""),    // 5
                    ,                           // 6: normal / ignore (MOZ ONLY)

                    "' tabIndex=",               // 7
                    ,                           // 8: Tab index
                    
                    // Identifiers for the form item event handling system
                    " ",                        // 9
                    isc.DynamicForm._containsItem,  // 10
                    "='",                       // 11
                    ,                           // 12: itemID
                    "' ",                       // 13
                    isc.DynamicForm._itemPart,  // 14
                    "='",                       // 15
                    ,                           // 16: iconID

                    // Allow the ISC event handling system to handle events occurring over
                    // this link.                    
                    "' handleNativeEvents=false>", // 17
                    ,                           // 18: this._getIconImgHTML()
                    "</a>"                      // 19
                    

                ]
            }
    
            var template = isc.FormItem._iconTemplate;
            
            
            var tabIndex = (this.iconIsDisabled(icon) || this.canTabToIcons == false) ? -1
                                              : this._getIconTabIndex(icon);
    
            
            template[1] = this._getIconLinkId(iconID);
            
            var hspaceToLink = this._applyIconHSpaceToLink(icon);
            if (hspaceToLink) template[4] = hspace;
            else template[4] = "0"

            //In Moz we need to set -moz-user-focus to disable focus if tabIndex < 0
            if (isc.Browser.isMoz) template[6] = (tabIndex < 0 ? "ignore" : "normal");

            template[8] = tabIndex;
            
            template[12] = itemID;
            template[16] = iconID;

            template[18] = this._getIconImgHTML(
                                this._getIconImgId(iconID),
                                width, 
                                height, 
                                this._getIconVAlign(icon),
                                this._getIconVMargin(icon),
                                (!hspaceToLink ? hspace : null),
                                backgroundColor,
                                iconSrc, 
                                itemID,
                                iconID,
                                hspace
                           );

            return template.join(isc.emptyString);

        }
    },
    
    // Helper method - Wherever possibly we apply icon hspace as margin-left on the Link item
    // around an icon rather than on the img tag. This avoids the dotted focus outline extending
    // to the left of the image when the icon has focus.
    // However this doesn't work in IE, and in some cases we don't write out a link element, so
    // we have to apply it to the img tag instead.
    // In Moz strict mode it also introduces styling problems, causing (for example) the date
    // picker icon to appear vertically misaligned with other icons.
    _applyIconHSpaceToLink : function (icon) {
        return (!isc.Browser.isIE && !icon.imgOnly && !isc.Browser.isStrict);
    },
    
    // Use _getIconImgHTML() to get the HTML for the image, without the link tag 
    // Called from _getIconHTML();
    _$vAlignColon:"vertical-align:",
    _getIconImgHTML : function (imgID, width, height, vAlign, vMargin, lMargin,
                                backgroundColor, src, itemID, iconID, leftMargin, 
                                errorIcon, extraStuff) 
    {
        // Get the icon Img HTML from the Canvas 'imgHTML()' method.  This handles displaying
        // PNG type files as well as other img files.

        
        if (isc.FormItem._iconImgPropertiesTemplate == null) {
            isc.FormItem._iconImgPropertiesTemplate = [        
                "ID='",                     // 0
                ,                           // 1: ID

                // Align the icon vertically as specified.
                
                "' style='",                // 2
                ,                           // 3 vertical-align:, or null
                ,                           // 4 valign or null (this._getIconVAlign(icon) 
                ";margin-top:",             // 5
                ,                           // 6: this._getIconVMargin(icon)
                "px;margin-bottom:",        // 7
                ,                           // 8: this._getIconVMargin(icon)
                "px;",                      // 9
                // Optional left margin for the icon
                ,                           // 10
                // Optional background-color for the icon
                ,                           // 11: background-color='xxx'
                ,                           // 12: optional display:block for strict mode
                "'"                         // 13
            ]
        }

        var template = isc.FormItem._iconImgPropertiesTemplate;
        
        template[1] = imgID
        
        if (vAlign != null) {
            template[3] = this._$vAlignColon;
            template[4] = vAlign;
        } else {
            template[3] = null;
            template[4] = null;
        }
        
        // apply any top / bottom margin to the icon
        
        template[6] = vMargin;
        template[8] = vMargin;
        
        if (lMargin != null) {
            template[10] = "margin-left:" + lMargin + "px;"
        } else {
            template[10] = null;
        }
        
        template[11] = (backgroundColor != null ? "background-color:" + backgroundColor + ";" : null);
        
        // display:block - required for strict mode IF the icon is being rendered into a table
        // (which is the default)
        // Avoid this if we're not in strict mode, or this is the error icon
        if (isc.Browser.isStrict && !isc.Browser.isTransitional && !errorIcon) 
            template[12] = "display:block;"
        else template[12] = null;

        if (extraStuff) template[14] = extraStuff;
        
        var extraStuff = template.join(isc.emptyString);
        
        template.length = 14;

        
        var imgParams = isc.FormItem._imgParams = isc.FormItem._imgParams || 
                { align:isc.Browser.isSafari ? "absmiddle" : "TEXTTOP" };
        imgParams.src = src;
        imgParams.width = width;
        imgParams.height = height;
        imgParams.extraStuff = extraStuff;
        return isc.Canvas.imgHTML(imgParams);
    },
    
    // -------------------------
    // icons methods
    //
    
    // Icons consist of 2 elements - an image surrounded by a link
    // Internal methods _getIconLinkId() and _geticonImgId() return a unique identifier for
    // these elements based on some icon's ID
    _ImgIDCache:{},
    _$_iLink_:"_iLink_",
    _$_iImg_:"_iImg_",
    _getIconLinkId : function (id) {
        if (!this._iLinkIDCache) this._iLinkIDCache = {};
        var cache = this._iLinkIDCache;
        if (!cache[id]) {
            // doing our own cacheing so don't have _getDOMID also cache the result
            cache[id] = this._getDOMID(this._$_iLink_ + id, true);
        }
        return cache[id];
    },
    _getIconImgId : function (id) {
        if (!this._iImgIDCache) this._iImgIDCache = {};
        var cache = this._iImgIDCache;
        if (!cache[id]) {
            // doing our own cacheing so don't have _getDOMID also cache the result
            cache[id] = this._getDOMID(this._$_iImg_ + id, true);
        }
        return cache[id];
    },
    

    // Internal methods to get a pointer to Icon's HTML elements in the DOM
    _getIconLinkElement : function (icon) {
        icon = this._getIcon(icon);
        if (icon == null || icon.imgOnly) return null;
        var elementID = this._getIconLinkId(icon._id);
        return isc.Element.get(elementID);
    },
    
    _getIconImgElement : function (icon) {
        icon = this._getIcon(icon);
        if (icon == null) return null;

        var elementID = this._getIconImgId(icon._id);
        return isc.Element.get(elementID);
    },
    
    // Helper method - determines whether the some event occurred over one of our icons based
    // on the native target element for the event.
    
    _getTargetIcon  : function (element) {
        if (!element || !this.icons) return null;
        
        var itemInfo = isc.DynamicForm._getItemInfoFromElement(element);
        if (!itemInfo || itemInfo.item != this) return null;
        return itemInfo.icon;
    },
    
    // _shouldShowIcon() helper method to evaluate 'showIf' property on form item icons
    _shouldShowIcon : function (icon) {
        if (icon.showIf == null) return true;
        // Note - icons are simple objects and have no stringMethodRegistry, so we must
        // use replaceWithMethod() to convert to a method (if it's currently a string)
        isc.Func.replaceWithMethod(icon, "showIf", "form,item");
        return !!icon.showIf(this.form, this);
    },
    
    
    _writeIconIntoItem : function (icon) {
        if (icon.writeIntoItem) return true;
        return false;
    },

    _mayShowIcons : function () {
        if (!this.showIcons || this.icons == null ||
            (this.showIconsOnFocus && !this.hasFocus)) return false;
        return true;
    },

    // getTotalIconsWidth()
    // Method to return the horizontal drawn space taken up by all this form item's icons.
    // This enables us to size the form's HTML element appropriately.
    getTotalIconsWidth : function () {
        if (!this._mayShowIcons()) return 0;

        var width = 0;
        for (var i = 0; i < this.icons.length; i++) {
            var icon = this.icons[i];
            if (!this._shouldShowIcon(icon) || this._writeIconIntoItem(icon)) continue;

            width += (icon.width != null ? icon.width : this.iconWidth) + 
                        (icon.hspace != null ? icon.hspace : this.iconHSpace);
        }
        return width;
    },

    getIconsHeight : function () {
        if (!this._mayShowIcons()) return 0;

        var maxHeight = 0;
        for (var i = 0; i < this.icons.length; i++) {
            var icon = this.icons[i];
            if (!this._shouldShowIcon(icon) || this._writeIconIntoItem(icon)) continue;
            var iconHeight = (icon.height != null ? icon.height : this.iconHeight);
            // If we're writing margins out, the icons will take up more space
            iconHeight += this._getIconVMargin() *2;
            if (iconHeight > maxHeight) maxHeight = iconHeight;
        }

        return maxHeight;
    },
    
    //>@method setIcons() 
    //  Programatically update the icons for this Form Item.  Will redraw the form item to show
    //  the new icons
    //  @param  icons   (Array) Array of icon definition objects
    //<
    
    setIcons : function (icons) {
        this.icons = icons;
        this._setUpIcons();
        this.redraw();
    },
    
    addIcon : function (icon) {
        if (!this.icons) this.icons = [];
        this.icons.add(icon);
        this.setIcons(this.icons);
        return icon;
    },

    getIconByProperty : function (key, value) {
        if (this.icons) return this.icons.find(key, value);
    },

    // enable / disable icons at runtime
    // (Used by 'setDisabled')
    setIconEnabled : function (icon) {
        
        icon = this._getIcon(icon);
        if (!icon) return;
        
        // Track the enabled / disabled state on the icon. This avoids us updating the 
        // HTML if we don't have to.
        var enabled = !this.iconIsDisabled(icon);
        if (!!icon._disabled != enabled) return;
        if (!enabled) icon._disabled = true;
        else delete icon._disabled;
        
        if (!this.isDrawn()) return;

        var linkElement = this._getIconLinkElement(icon),
            imgElement = this._getIconImgElement(icon);
        
        // Enabling / disabling an icon will modify:
        // - tabIndex (can't tab to disabled icons);
        //   - focus altogether
        // - click action should no-op
        // - disabled image should be shown if there is one.
        if (linkElement) {    
            // Note - if we did a 'this.setElementTabIndex(-1)' on 'setDisabled(true)' there
            // would be no need for this, as that will also update the tabIndex of icons.
            // However we don't by default because applying the native 'disabled' state to
            // the native HTML form elements will already remove them from the page's tab order.
            if (!enabled) isc.FormItem.setElementTabIndex(linkElement, -1);
            else isc.FormItem.setElementTabIndex(linkElement, this._getIconTabIndex(icon))
        }    
        if (imgElement) {
            var src = this.getIconURL(icon, null, !enabled);
            isc.Canvas._setImageURL(imgElement, src);
        }
    },
    
    
    //> @method  showIcon()  
    //  This method will show some icon on this form item whos showIf() method previously 
    //  evaluated to false.<br>
    //  Notes:<ul>
    //  <li>This method can only be called for some icon already in the form item's icons array</li>
    //  <li>This method will destroy the icon's "showIf" property (if defined).</li>
    //  <li>If the form item's showIcons property is set to false, no icons will be displayed
    //      for the item. In this case this method will not cause the icon to be displayed</li>
    //  </ul>
    // @visibility internal
    //<
    showIcon : function (icon, focused) {
        // all icons are no longer hidden!
        delete this._allIconsHidden;
    
        if (!isc.isAn.Object(icon)) return;

        // If the icon's ID hasn't been set yet, set it now
        // (Can happen if the icon has never been written out as part of getIconsHTML())
        if (icon._id == null) {
            this._setIconId(icon);
        }

        var currentlyVisible = this._shouldShowIcon(icon);

        // even if the icon is currently visible, set showIf to ensure it is always visible
        // from this point on.
        // For icons written into the form item, the 'getElementHTML()' method should handle
        // this as appropraite.
        icon.showIf = function () {return true;}
        
        // Only force a redraw / insert into the DOM if the icon wasn't previously visible
        if (!currentlyVisible && this.showIcons && this.containerWidget.isDrawn() && 
            this.isVisible()) 
        {
            // If the redrawOnShowIcon property is set, simply mark the form for redraw
            // If writeIntoItem is true we have to redraw since we will be changing the HTML
            // of the whole form item.
            if (this.redrawOnShowIcon || icon.writeIntoItem) {
                this.redraw();
                
            // Otherwise we're going to show/hide the icon without redrawing the whole form
            } else {
                // Get a pointer to the right place, and precisely insert the
                // appropriate icon HTML
                var previousIcon;
                for (var i = (this.icons.indexOf(icon)-1); i>=0; i--) {
                    var testIcon = this.icons[i];

                    if (!testIcon.writeIntoItem && this._shouldShowIcon(testIcon)) {
                        previousIcon = testIcon;                    
                        break;
                    }
                }
                
                var mustRedraw = true;
                
                if (previousIcon != null) {
                    var previousElement;
                    previousElement = previousIcon.imgOnly ? 
                                        this._getIconImgElement(previousIcon) : 
                                        this._getIconLinkElement(previousIcon);
                                        
                    if (previousElement != null) {
                        isc.Element.insertAdjacentHTML(previousElement, "afterEnd",
                                        this.getIconHTML(icon, null, this.isDisabled(), focused));
                        // Fire _iconVisibilityChanged().  This method will handle resizing the form
                        // item element to accomodate the space taken up by the newly shown icon.
                        this._iconVisibilityChanged();                        
                        mustRedraw = false;
                    }
                }
                // If we have no previous icon - do a redraw.
                
                
                if (mustRedraw) {
                    
                    this.logInfo("showIcon(): Unable to dynamically update icon visibility - " +
                                 "redrawing the form");                                 
                    return this.redraw();
                } else {
                
                    // notify the icon that it has been written into the DOM so we can set up
                    // eventHandlers for it.
                    
                    this._iconDrawn(icon);
                }
                

            }
        }
    },
    
    hideIcon : function (icon) {
        if (!isc.isAn.Object(icon)) return;
        var currentlyVisible = this._shouldShowIcon(icon);
        icon.showIf = function () {return false;}
        
        // Only force a redraw / remove from the DOM if the widget was previously visible
        if (currentlyVisible && this.showIcons && this.containerWidget.isDrawn() && 
            this.isVisible()) 
        {
            // If the redrawOnShowIcon property is set, simply mark the form for redraw
            if (this.redrawOnShowIcon || icon.writeIntoItem) {
                this.redraw();
            }
            // Otherwise we're going to show/hide the icon without redrawing the whole form
            else {
                var element = icon.imgOnly  ? this._getIconImgElement(icon) 
                                            : this._getIconLinkElement(icon);
                
                if (element == null) {
                    this.logInfo("hideIcon(): Unable to dynamically update icon visibility - " +
                                 "redrawing the form");
                    return this.redraw();
                }

                //this.logWarn("would remove element: " + this.echo(element) + 
                //             " from parentNode: " + this.echo(element.parentNode));
                isc.Element.clear(element);

                // Fire _iconVisibilityChanged().  This method will handle resizing the form
                // item element to accomodate the space taken up by the newly shown icon.
                this._iconVisibilityChanged();
            }
        }
    },
    
    // _iconVisibilityChanged()
    // Notification fired when showIcon() or hideIcon() succussfully completes having 
    // manipulated the DOM to show/hide an icon.
    // Default implementation will resize the form item element to accomodate the space
    // taken up by it's visible icons.
    // Will not be fired if showIcon() or hideIcon() fell through to form.markForRedraw().
    _iconVisibilityChanged : function () {
        this._resetWidths();
    },

    // showAllIcons / hideAllIcons:
    // Used by 'showIconsOnFocus' / 'hideIconsOnKeypress' behavior.
    showAllIcons : function (focused) {
        
        if (this._hideAllIconsEvent != null) {
            isc.Timer.clear(this._hideAllIconsEvent);
            delete this._hideAllIconsEvent;
        }
        this._showIcons(this.icons, focused);
    },
    
    hideAllIcons : function () {
        if (this._hideAllIconsEvent != null) delete this._hideAllIconsEvent;
        this._hideIcons(this.icons);
        this._allIconsHidden = true;
    },

    // _showIcons / _hideIcons -- helper functions to show/hide multiple icons at a time.
    _showIcons : function (icons, focused) {  
        if (icons == null || icons.length == 0) return;
        for (var i = 0; i < icons.length; i++) {
            focused = focused && this._iconShouldShowFocused(icons[i], true);
            this.showIcon(icons[i], focused);
        }
    },
    
    
    _hideIcons : function (icons) {
        if (icons == null || icons.length == 0) return;

        for (var i = 0; i < icons.length; i++) {
            this.hideIcon(icons[i]);
        }
    },
    
    //_getIcon() given an icon's ID (unique within this form item), retrieve a pointer to the
    // icon.
    // Note this is an internal method - developers have no access to the _id property applied
    // to icons
    _getIcon : function (id) {
        var icon;
        if (this.icons) {
            for (var i = 0; i < this.icons.length; i++) {
                // make sure we fire the click action of the appropriate object in the 'icons' array
                if (this.icons[i] == id || this.icons[i]._id == id) icon = this.icons[i];
            }
        }
        if (!icon && this.showPickerIcon) {
            var pickerIcon = this.getPickerIcon();
            if (pickerIcon.id == id || pickerIcon.id == id.id) icon = pickerIcon;
        }
        if (!icon) {
            this.logInfo("FormItem unable to get pointer to icon with ID:"+ id +
                         " - Invalid ID, or icons array has been inappropriately modified." +
                         " To update icon[s] for some form item, use the method 'setIcons()'.")
        }
        return icon;
    },
    
    // _setIconImgState() - an internal method to show the 'over' / 'focused' image for an icon.
    _setIconImgState : function (icon, over, focused) {
        // We should already be showing the disabled image if we're marked as disabled.
        if (this.isDisabled()) return;
        
        // If we weren't explicitly passed 'focused', look at this.hasFocus 
        if (focused == null) focused = this.hasFocus && this._iconShouldShowFocused(icon, true)
        
        var iconImg = this._getIconImgElement(icon);
        if (iconImg != null) {
        
            var src = this.getIconURL(icon, over, null, focused);            
            isc.Canvas._setImageURL(iconImg, src);
        }
    },
    
    _iconShouldShowOver : function (icon) {
        if (this.isDisabled()) return false;
        if (icon.showOver != null) return icon.showOver;
        return this.showOverIcons;
    },
    
    _iconShouldShowFocused : function (icon, itemFocus) {
        if (!icon || this.isDisabled()) return false;
        if (itemFocus && icon.showFocusedWithItem == false) return false;
        if (icon.showFocused != null) return icon.showFocused;
        return this.showFocusedIcons;
    },
    
    // setIconBackgroundColor() - change the backgroundColor of an icon
    // (used by the colorItem).
    setIconBackgroundColor: function (icon, color) {
        
        icon.backgroundColor = color;        
        var iconImg = this._getIconImgElement(icon);
        if (iconImg != null) {
            
            try {iconImg.style.backgroundColor = color;} catch (e) {}
        }
    },
    
    // Picker
	// -----------------------------------------------------------------------------------------

    //>@method FormItem.showPicker (A)
    // Method to show a picker for this item. By default this method is called if the user
    // clicks on a pickerIcon, shown by setting <code>this.showPickerIcon</code> to true. May
    // also be called programatically.<br>
    // Default implementation lazily creates a 'picker' from the set of defaults defined on
    // this FormItem.
    // @param [modal] (boolean) Is this a modal picker
    // @param [icon] (icon) Pointer to the icon that launched this picker (if applicable)
    // @param [pickerProperties] (object) properties to apply to the picker
    // @param [rect] (object) Object with <code>left, top, width, height</code> properties for
    //                        positioning the picker.
    // @visibility internal
    //<
    showPicker : function (modal, icon, pickerProperties, rect) {

        var picker = this.picker;

        pickerProperties = isc.addProperties(pickerProperties || {}, {
            callingForm: this.form, 
            callingFormItem: this
        });

        // support being passsed the global ID of a picker
        if (isc.isA.String(picker) && isc.isA.Canvas(window[picker])) {
            picker = this.picker = window[picker];
        }

        // lazily create the picker
        if (!picker) {
            picker = this.picker = this.createPicker(pickerProperties);

            // provide observeable dataChanged function to all pickers
            if (!isc.isA.Function(picker.dataChanged)) {
                picker.dataChanged = new Function ();
            }

            // make sure the picker doesn't drift too far away from the original coordinates or
            // off the screen by resizing (items being added or removed)
            picker.observe(picker, "resized",
                                   "observed.placeNear(observed.lastShowRect)");

            // observe dataChanged 
            
            if (this.pickerDataChanged && picker.dataChanged) {
                this.observe(picker, "dataChanged", "observer.pickerDataChanged(observed)");
            }
        } else {
            isc.addProperties(picker, pickerProperties);
        }
        var pickerID = picker.getID();

        //this.logWarn("showPicker with rect: " + this.echo(rect) +
        //             ", getPickerRect: " + this.echoLeaf(this.getPickerRect) +
        //             ", icon: " + this.echo(icon));

        // if no position was specified, use either the top left of the (if it
        // exists) or the last mouse position
        if (!rect) {
            if (this.getPickerRect) {
                rect = this.getPickerRect();
            } else if (icon) {
                var iconRect = this.getIconPageRect(icon);
                rect = [iconRect[0],iconRect[1]]
            }
            else rect = [isc.EH.getX(), isc.EH.getY()];
        }
        // storing the lastShowRect allows the picker to reposition itself if it resizes
        picker.lastShowRect = rect;

        picker.setRect(rect);
        // draw the picker offscreen to get a size before placing it
        if (!picker.isDrawn()) {
            picker.moveTo(null, -9999);
            picker.draw();
        }
        // use placeNear so we don't get clipped by the window.
        this.picker.placeNear(rect);

        // set the picker data.  A picker advertises its desire to have data set on it by
        // defining a setData method.  If the formItem defines the special getPickerData()
        // function, call that - otherwise call getValue() which works for all formItems
        if (isc.isA.Function(picker.setData)) {
            if (isc.isA.Function(this.getPickerData)) {
                picker.setData(this.getPickerData(picker));
            } else picker.setData(this.getValue(picker));
        }

        // show a clickmask.  When the clickmask is clicked notify the picker if it has the
        // clickMaskClicked method defined.  If we're asked to open a modal picker, the picker
        // needs to take care of hiding itself and clearing the clickMask.
        var clickAction = modal ? null : pickerID+".hide()";
        if (modal && isc.isA.Function(picker.clickMaskClicked)) 
            clickAction = pickerID+".clickMaskClicked()";
        
        picker.showClickMask(clickAction, !modal, picker);
        if (modal != null && picker.isModal == null) picker.isModal = modal;
        picker.show();
        picker.bringToFront();
        picker.focus();
        
        // Return false to suppress default click handling from firing
        return false;
    },
    
    createPicker : function (pickerProperties) {
        return this.createAutoChild("picker", pickerProperties);
    },

    hidePicker : function () {
        if (!this.picker) return;
        this.picker.hideClickMask();
        this.picker.hide();
    },

	// ----------------------------------------------------------------------------------------

    

    //> @method	formItem.redraw()  (I)
    // Redraw this form item.  Default implementation will notify containerWidget by calling 
    // containerWidget.redrawFormItem() (if it's present), otherwise just mark the containerWidget
    // for redraw.
    //<
    // DynamicForm 'redrawFormItem()' simply marks the form for redraw.
    
    redraw : function (reason) {

        // we can get redraw() attempts during init before we're actually drawn, which have no
        // effect on a DynamicForm, but will affect inline editing by redrawing the grid body
        if (!this.isDrawn()) return;

        // Note - We record whether we had focus before the redraw.
        // This is required because the form will blur the focus item during redraw, and then
        // refocus when redraw is complete.
        // In some cases getInnerHTML() will return different HTML for an item with focus
        // so we need this flag as the item will not have real focus until after redraw is 
        // complete.
        // This flag is cleared by DynamicForm._refocusAfterRedraw()
        
        
        if (this.hasFocus) this._hadFocusBeforeRedraw = true;
        if (!this.hasFocus && this.items != null) {
            for (var i = 0; i < this.items.length; i++) {
                if (this.items[i].hasFocus) this._hadFocusBeforeRedraw = true;
            }
        }
        if (this.containerWidget.redrawFormItem) {
            this.containerWidget.redrawFormItem(this, reason);
        } else {
            this.containerWidget.markForRedraw("Form item redrawn"+ (reason ? ": " + reason : isc.emptyString));
        }
    },
    
    // adjustOverflow
    // Called when content changes (which may cause size change)
    // By default calls adjustOverflow on DynamicForm 
    
    adjustOverflow : function (reason) {
        if (!this._adjustOverflowReason) {
            this._adjustOverflowReason = [this.getID(), "  overflow changed: "]
        }
        if (reason == null) this._adjustOverflowReason[2] = "No Reason Specified.";
        else this._adjustOverflowReason[2] = reason;
        
        if (isc.isA.DynamicForm(this.containerWidget)) 
            this.containerWidget.adjustOverflow(this._adjustOverflowReason.join(isc.emptyString));
        
    },

    //> @method	formItem.show()  (I)
    // Show this form item.
    // <BR><BR>
    // This will cause the form to redraw.  If this item had an item.showIf expression, it will
    // be destroyed.
    // @visibility external
    //<
    // If the container widget has a redrawFormItem method we use that. This is currently only
    // implemented on the DynamicForm class where it is used to invalidate cached 
    // tableResizePolicy information.
    // If there is no redrawFormItem method we just mark the container widget for redraw
    
    show : function (preserveShowIf) {
        this.visible = true;
        if (!preserveShowIf) this.showIf = null;
        if (this.containerWidget.redrawFormItem) this.containerWidget.redrawFormItem(this, "showing form item");
        else this.containerWidget.markForRedraw("showing form item");
        
        this.visibilityChanged(true);
    },

    //> @method	formItem.hide()  (I)
    // Hide this form item.
    // <BR><BR>
    // This will cause the form to redraw.  If this item had an item.showIf expression, it will
    // be destroyed.
    // @visibility external
    //<    
    hide : function (preserveShowIf) {
        this.visible = false;
        if (!preserveShowIf) this.showIf = null;
        if (this.containerWidget.redrawFormItem) this.containerWidget.redrawFormItem(this, "hiding form item");
        else this.containerWidget.markForRedraw("hiding form item");
        
        this.visibilityChanged(true);        
    },
    
    //>Safari
    
    _updateHTMLForPageLoad : function () {
        if (!isc.Browser.isSafari || !this.isDrawn()) return;
        
        this._resetWidths();
    },
    
    _resetWidths : function () {
        if (!this.isDrawn()) return;
        var shouldClip = this.clipValue;
        
        var outerTable = this.getOuterTableElement();
        if (outerTable) outerTable.style.width = this.getInnerWidth();
        
        if (this.showPickerIcon) {
            var controlTable = this._getControlTableElement();
            if (controlTable) controlTable.style.width = this.getElementWidth();
            
            var iconDef = this.getPickerIcon(),
                img = this._getIconImgElement(iconDef);
                if (img) {
                    img.style.height = this.getPickerIconHeight();
                    img.style.width = this.getPickerIconWidth();
                }
        }
        
        var textBoxWidth = this.getTextBoxWidth(),
            textBoxHeight = this.getTextBoxHeight(),
            textBox = this._getTextBoxElement();
        if (textBox) {
            
            if (shouldClip) textBox.style.width = textBoxWidth;
            else textBox.style.minWidth = textBoxWidth;
            textBox.style.height = textBoxHeight;
        }
        if (this._writeOutFocusProxy()) {
            var focusProxy = this.getFocusElement()
            if (focusProxy) {
                focusProxy.style.width = textBoxWidth;
                focusProxy.style.height = textBoxHeight;
            } 
        }
    },
    //<Safari
 
    // Element management   
	// --------------------------------------------------------------------------------------------


	//>	@method	formItem.hasElement()
	//	Deprecated form of hasDataElement() - kept for backwards compat.
	//		@group	elements
	//		@return	(boolean)		true == item has a form element containing a value for the item
    //      @see    hasDataElement()
    //      @deprecated As of SmartClient 5.5, use +link{formItem.hasDataElement}.
	//<
    hasElement : function () {
        return this.hasDataElement();
	},
    
    //> @method     formItem.hasDataElement()   
    // Does this form item type have an associated form element in the DOM, containing a value?
    // Note - if hasDataElement() returns true, this implies that this data element type
    // has a data element - it doesn't imply that the form is drawn, or that the data element
    // is currently written into the DOM.
    // <P>
    // Use 'getDataElement()' to get a pointer to the data element (will return null if the
    // data element is not found).
    //
    // @group formValues
    // @visibility   internal
    // @see     method:FormItem.getDataElement
    //<
    
    hasDataElement : function () {
        // Most FormItems either always have or always do not have an element, however we make
        // this a function rather than accessing the _hasDataElement flag directly subclasses
        // such as the ContainerItem class may do more complicated things which make this
        // method's return value vary.
        return this._hasDataElement;
    },
    
	//>	@method	formItem.getElement()
	//  Deprecated form of getDataElement() - kept for backwards compatability.
	//		@group	elements
	//
	//		@param	[itemName] 	(string)	Item to get the element for.  If null, use this item.
	//		@return	(Element)		DOM element subclass
    //      @deprecated As of SmartClient 5.5, use +link{formItem.getDataElement}.
	//<
	getElement : function (itemName) {
        return this.getDataElement(itemName);
    },
    
    //> @method formItem.getFocusElement()
    // Returns the HTML element that should recieve focus when 'focusInItem()' is called on this
    // form item.
    // Default implementation returns the data element for the form item. May be overridden by
    // subclasses
    //  @group events
    //  @return (Element) DOM element to recieve native focus
    //  @visibility internal
    //<
    getFocusElement : function () {
        if (!this.isDrawn() || !this._canFocus()) return null;
        if (this.hasDataElement()) return this.getDataElement();
        if (this._writeOutFocusProxy()) {
            if (!this._focusProxyHandle) {
                // this ID is created by the Canvas-level focusProxy string generation
                this._focusProxyHandle = isc.Element.get(this.getID() + "__focusProxy");
            }
            return this._focusProxyHandle;
        }
        return this._getTextBoxElement();
    },
    
    // _getCurrentFocusElement()
    // Since form items can consist of multiple focusable HTML elements (most commonly an input 
    // element and a number of icons (defined as <A> tags), we need a way to determine
    // which DOM element has native focus when formItem.hasFocus is true.
    // In IE we could rely on 'document.activeElement', but there is no equivalent in the
    // other browsers, so instead we hang a flag onto the form item on element focus, 
    // (via the 'nativeFocusHandler()' and 'iconFocus()' methods) and clear it on blur (or 
    // update on focus to a different element).
    _getCurrentFocusElement : function () {
        if (this.hasFocus == null && !isc.EH._lastFocusTarget == this) {
            return null;
        }
        var element = this._currentFocusElement;
        // double check for IE using the native document.activeElement - should not be 
        // necessary
        
        if (isc.Browser.isIE && element != this.getActiveElement()) {
            this.logInfo("not returning focus element since it doesn't match " +
                         "document.activeElement", "nativeFocus");
            if (this.hasFocus) {
                this.elementBlur();
            }
            this._currentFocusElement = null;
            return null;
        }
        
        return element;
    },

	//>	@method	formItem.getDataElement()
    //      Return a pointer to the form element containing the value for this form item, or
    //      null if it doesn't currently exist.
    //      Will always return null if this form item type does not have an associated data element
    //      which can be determined by formItem.hasDataElement()
    //
	//		@group	elements
	//
	//		@param	[itemName]    (String)    Optional form item name - if passed will return that 
    //                                      item's element.  (Item should be a member of the same 
    //                                      form) 
	//		@return	(Element)		DOM element subclass (or null)
	//<
    getDataElement : function (itemName) {
		// if no itemName was specified, assume they mean us!
		if (itemName == null) {
			var item = this;
		} else {
			// otherwise have the form get a pointer to the item
            var item = this.form.getItem(itemName);
		}
        
        // If the item does not have a data element, return null.
        if (!item.hasDataElement()) return null;
        
        
     
        // cache the result of getElementById, cleared in redrawn()/cleared()/destroy()   
        var dataElement = this._dataElement;
        if (dataElement == null) {
            dataElement = (this._dataElement = isc.Element.get(this.getDataElementId()));
        }
        return dataElement
	},
    
    // This method returns a pointer to the outer element of the form item
    
    getOuterElement : function () {
        if (!this.isDrawn()) return null;
        
        // If the "includeHint" parameter was passed to getInnerHTML() when we were written out
        // we pass this on to the method determining whether we wrote an outer table.
        var hasHint = this._wroteOutHint;
        if (this._writeOuterTable(hasHint)) {   
            return this.getOuterTableElement();
        }
        if (this.showPickerIcon) {
            return this._getControlTableElement();
        }
        var element = this._getTextBoxElement();
        // If all else fails (possible due to custom innerHTML) back off to the 
        // containing element for the entire item
        if (element == null) {  
            element = this.getHandle();
        }               
        return element;
    },    

    // getHandle() returns a pointer to the element that contains this form item.
    // One of:
    // - form cell
    // - abs div
    // - standalone 'span' element
    getHandle : function () {
        if (!this.isDrawn()) return null;
        if (this._absPos()) return this.getAbsDiv();
        if (this.containerWidget == this.form) return this.getFormCell();
        return isc.Element.get(this._getDOMID(this._$standaloneSpan));
    },
    
    // pointer to the table around this form item's content
    getOuterTableElement : function () {
        return this._getHTMLPartHandle(this._$outerTable);
    },
    
    // Which part of the form item did the event occur over?
    _overElement : function (event) {
        if (!event) event = isc.EH.lastEvent;
        var itemInfo = event.itemInfo;
        return (itemInfo && itemInfo.overElement);
    },
    
    _overTextBox : function (event) {
        if (!event) event = isc.EH.lastEvent;
        var itemInfo = event.itemInfo;
        
        return (itemInfo && (itemInfo.overTextBox || itemInfo.overElement));
    },

    // control table comprises the text box, picker icon and surrounding table
    _overControlTable : function (event) {
        if (!event) event = isc.EH.lastEvent;
        var itemInfo = event.itemInfo;
        return (itemInfo &&
                (itemInfo.overControlTable || this._overTextBox(event) ||
                 (itemInfo.overIcon && this._getIcon(itemInfo.overIcon) == this.getPickerIcon()) 
                )
               );
    },

    _$cell:"cell",
    getFormCellID : function () {
        return this._getDOMID(this._$cell);
    },
    getFormCell : function () {
        return isc.Element.get(this.getFormCellID());
    },

    // ValueMaps
	// --------------------------------------------------------------------------------------------
    
    //>	@method	formItem.getDisplayValue()
    // Returns this item's value with any valueMap applied to it - the value as currently
    // displayed to the user.
    // @param [value] optional stored value to be mapped to a display value.  Default is to
    //                use the form's current value
	// @return (any) value displayed to the user
    // @group valueMap
    // @visibility external
	//<
    
    getDisplayValue : function (value) {
        var undef;
        return this.mapValueToDisplay(value !== undef ? value : this.getValue());
    },
    
	//>	@method	formItem.mapValueToDisplay()
	//  Given a value for this form item, return the value to be displayed.
    //  Default implementation will apply valueMap if there is one.  May be overridden for 
    //  other implementations by subclasses
	//	@param  value  (any) value to be mapped to a display value
    //  @return (any)        value to display
	//<
    
    mapValueToDisplay : function (value) {

        var displayValue = this._mapKey(value);
        value = this._formatDataType(displayValue);
        return value;
    },

    // If we have a non-string value, use the appropriate formatter to display it as a string.
    _formatDataType : function (value) {
    
        // Special case for dates and times
        // Dates and times are both native Date objects
        // If a dateFormatter is specified on a field (regardless of type) and the
        // value is a date, use the specified date formatter
        
        
        
        if (this.dateFormatter != null && isc.isA.Date(value)) 
            return value.toNormalDate(this.dateFormatter);
            
        // If a timeFormatter is specified on the field (again regardless of type), and the
        // value is a time, use the specified timeFormatter
        if (this.timeFormatter != null && isc.isA.Date(value))
            return isc.Time.toTime(value, this.timeFormatter);
            
        // _normalDisplayFormatter and _shortDisplayFormatter is picked up from SimpleType
        // logic.
        if (this._normalDisplayFormatter) {
            
            return this._simpleType.normalDisplayFormatter(value, this, this.form, this.form.values);
        }
        
        // if the value is null return an empty string rather than the string "null" or "undefined"
        if (value == null) value = this.emptyDisplayValue;
        else {
            value = isc.iscToLocaleString(value);
            // map "" to our 'emptyDisplayValue' - allows subclasses such as selectItems
            // to style the content properly by writing out "&nbsp;" rather than ""
            if (this.emptyDisplayValue != isc.emptyString && value == isc.emptyString) 
                value = this.emptyDisplayValue;
        }
        return value;
    },
    
    //>	@method	formItem.mapDisplayToValue()
	//  Converts a display value for this item to a value to be saved out.
    //  Default implementation will map backwards based on the valueMap specified if there is 
    //  one.
	//	@param  value  (any) display value
    //  @return (any)        value re-mapped for storing
	//<
    
    
    mapDisplayToValue : function (value) {
        return this._unmapKey(value);
    },    
    
	
	//>	@method	formItem._mapKey() (A)
	// Map a key value through the item.valueMap, if defined,
	// to return the display value that we should show to the user.
    // By default returns the key if no mapping was found. 2nd parameter allows the developer
    // to suppress this behavior, and return null if no mapping was found.
	//<
	_mapKey : function (key, dontReturnKey) {
        var defaultValue = dontReturnKey ? null : key;
		var map = this.getValueMap();
		if (!map) return defaultValue;		
		if (isc.isA.String(map)) map = this.getGlobalReference(map);
        // if it's an array, just return the key, it's either in the array or not - no need
        // to transform.
        if (isc.isAn.Array(map)) return defaultValue;
        
		var value = isc.getValueForKey(key, map, defaultValue);
        return value;
	},
	
	
	//>	@method	formItem._unmapKey() (A)
	//		Map a display value through the item.valueMap, if defined,
	//		to return the key value used internally.
	//<
	_unmapKey : function (value) {
//JMD: handle null value in isc.getKeyForValue instead?
		var map = this.getValueMap();
		if (!map) return value;		
		if (isc.isA.String(map)) map = this.getGlobalReference(map);

        // if it's an array, just return the value, it's either in the array or not - no need
        // to transform.
        if (isc.isAn.Array(map)) return value;
        
		return isc.getKeyForValue(value, map);
	},

	//>	@method	formItem.setValueMap()	(A)
	// Set the valueMap for this item.
	// @group	valueMap
	// @param	valueMap (Array or Object) new valueMap
    // @see attr:valueMap
    // @visibility external
	//<
	setValueMap : function (valueMap) {
		this.valueMap = valueMap;
        
        this.updateValueMap();
	},
    
    //> @method formItem.setValueIcons ()
    // Set the valueIcons for this item
    // @param map (object) mapping of logical values for this item to icon src URLs
    // @group valueIcons
    // @visibility external
    //<
    setValueIcons : function (map) {
        this.valueIcons = map;
        if (this.isDrawn()) this.redraw();
    },

	//>	@method	formItem.setOptions()	(A)
	// Set the options for this item (a select or a radioGroup, etc.).  Synonymous with
    // setValueMap().
	//		@group	valueMap
	//		@param	valueMap (Array or Object) new valueMap
	//<
	setOptions : function (valueMap) {
		return this.setValueMap(valueMap);
	},


    //> @method formItem.updateValueMap()
    // Helper method fired whenever the valueMap is modified.
    // Will refresh the displayed value if appropriate.
    // @param   refreshDisplay  (boolean)   Can be passed to explicitly indicate that the new
    //                                      valueMap effects the currently displayed value so
    //                                      a refresh is required, or vice versa. If not passed
    //                                      we always refresh.
    //<
    updateValueMap : function (refreshDisplay) {
        if (refreshDisplay != false) { 
            this.setElementValue(this.mapValueToDisplay(this.getValue()));
        }   
		if (this.hasElement()) this.setElementValueMap(this.getValueMap());
    },
    
	//>	@method	formItem.setElementValueMap()	(A)
	// Set the valueMap in the form representation for this object.<p>
    //
	// Default implementation does nothing -- override in a subclass to actually manipulate the
    // form.
	//		@group	valueMap
	//		@param	valueMap (Array or Object) new valueMap
	//<
	setElementValueMap : function (valueMap) {
		// no default implementation
	},
	
	//>	@method	formItem.getValueMap()	(A)
	// Internal method to compute the actual valueMap from the author-specified valueMap and
    // other properties.
	//		@group	valueMap
	//		@return	(Object) the valueMap
	//<
	getValueMap : function () {


		// get the valueMap from the item
		var valueMap = this.valueMap;
	
		// if valueMap are specified as a string, treat it as a global reference to the actual
        // list
		if (isc.isA.String(valueMap)) {
			valueMap = this.getGlobalReference(valueMap);
		}
        

        // for FormItems with displayFields, this._displayFieldMap is a special map between 
        // data field values and display field values in the items' optionDataSource.
        // Set up in 2 ways:
        // - if the optionDataSource matches the dataSource for the form, this is picked up
        //   from a call to setValues() on the form as a whole (EG editing records)
        // - if the value for the item is set to an unrecognized value as part of 
        //   item.setValue(), mapValueToDisplay will perform an explicit fetch against the 
        //   dataSource to retrieve the displayValue for the value passed in.
        // Combine this special map with the explicitly specified valueMap.
        var displayMap = this._displayFieldValueMap;
        if (displayMap != null) {
            if (valueMap == null) valueMap = displayMap;
            
            else {
                // if the explicit map is an array, convert it to an object
                if (isc.isAn.Array(valueMap)) {
                    var explicitMap = valueMap;
                    valueMap = {};
                    for (var i = 0; i < explicitMap.length; i++) {
                        valueMap[explicitMap[i]] = explicitMap[i];
                    }
                }
                // Add entries for the special displayFieldValueMap
                isc.addProperties(valueMap, displayMap);
            }
        }
        
        return valueMap;
    },

    //> @method FormItem.getValueFieldName()
    // Getter method to retrieve the +link{FormItem.valueField} for this item.
    // If unset, default behavior will return the +link{FormItem.name} of this field.
    // @group display_values
    // @return (string) fieldName to use a "value field" in records from this items 
    //              +link{FormItem.optionDataSource}
    // @visibility external
    //<
    
    getValueFieldName : function () {
        if (this.valueField) return this.valueField;
        
        if (this.form.dataSource && this.foreignKey) 
            return isc.DS.getForeignFieldName(this, this.form.dataSource);

        var fieldName = this.getFieldName(),
            ods = this.getOptionDataSource();
        if (ods && ods.getField(fieldName) == null) {
            // if we have an optionDataSource but our valueField isn't in it at all, use the
            // DataSource's titleField
            fieldName = ods.getTitleField();
        }
        
        return fieldName || "name";
    },
    
    //> @method   FormItem.getDisplayFieldName()
    // Returns the +link{formItem.displayField} for this form item.
    // If unset, and +link{formItem.optionDataSource} is explicitly specified, this method
    // will return the title field for the <code>optionDataSource</code>
    // @return (String) display field name, or null
    // @visibility external
    //<
   getDisplayFieldName : function () {
        if (this.displayField) return this.displayField;
        var optionDataSource = this.getOptionDataSource();

        if (optionDataSource && 
            optionDataSource != isc.DataSource.getDataSource(this.form.dataSource) && 
            optionDataSource.getField(this.getValueFieldName()).hidden == true) {
                return optionDataSource.getTitleField();
        }
    },


    // If this item has a specified displayField, if this item has no optionDataSource, 
    // or the optionDataSource matches the underlying dataSource of the form, we pick up the 
    // display value for the field from the displayField value of the form's values object.
    // (This is based on the assumption that we are editing a 'record' - similar behavior
    // to the ListGrid).
    // This method handles this by creating a special valueMap mapping this field's value to
    // the displayFields value, which can then be retrieved by this.getValueMap()
    //
    // Notes: 
    // - If the optionDataSource is explicitly specified and doesn't match this.dataSource,
    //   we perform an explicit fetch against the data-source get the display value.
    // - In addition to these mechanisms, pickList based items make use of the pickLists
    //   data object directly to perform mappings.
    _displayFieldValueFromFormValues : function () {
        
        // for items with an option dataSource and a specified displayField, display the 
        // form's displayField value by default
        
        if (this.displayField != null) {
            var vals = this.form.getValues(),
                dataVal = vals[this.getFieldName()],
                displayVal = vals[this.displayField];
            if (displayVal != null) {
                var valueMap = {};
                valueMap[dataVal] = displayVal;
            }
            this._displayFieldValueMap = valueMap
        }
    },
	
	//>	@method	formItem.getOptions()	(A)
	// Return the valueMap for this item.  Synonymous with getValueMap()
	//		@group	valueMap
	//
	//		@return	(Object) the valueMap
	//<
	getOptions : function () {
		return this.getValueMap()
	},
    

    //>@method FormItem.getOptionDataSource()
    // Returns the +link{FormItem.optionDataSource} for this item. Default implementation
    // will return the  +link{dataSource} of this item's form if 
    // no explicit <code>optionDataSource</code> is specified.
    // @group display_values
    // @visibility external
    //<
    getOptionDataSource : function () {
        var ods = this.optionDataSource;
        if (ods == null && this.form.dataSource) {
            if (this.foreignKey) ods = isc.DS.getForeignDSName(this);
            else ods = this.form.dataSource;
        }
        // convert identifiers to an actual datasource object
        if (isc.isA.String(ods)) ods = isc.DataSource.getDataSource(ods);
        return ods;
    },
    
	//>	@method	formItem.getValueMapTitle()	(A)
	// Return the title associated with a particular value
	//		@group	valueMap
	//		@return	(string)	title of the option in question
	//<
	getValueMapTitle : function (value) {
		var valueMap = this.getValueMap();
		// return the value as the title if it exists in the valueMap array
		if (isc.isAn.Array(valueMap)) return (valueMap.contains(value) ? value : "");
		return valueMap[value];
	},
	
	// --------------------------------------------------------------------------------------------

	//>	@method	formItem.saveValue()
	// Store a value for this form item internally, and at the form level.<br>
    // This method will update our internal "_value" property and the value stored in the form's
    // "values" array.
    // It is used in 'setValue()', and in  'elementChanged()', and 'handleKeyPress()' to ensure the 
    // stored values for this item reflect the value displayed in this form item's element.
    //      @visibility internal
	//		@group formValues
	//
    // @param	value 	(any)				value to save for this item
    // @param [isDefault] (boolean) Indicates that this value was derived from the default 
    //  value for this item (allowing us to re eval dynamic defaults in setItemValues())
	//<
    saveValue : function (value, isDefault) {

        var undef;
        this._value = value;
        // set or clear the flag indicating whether this is a default value.
        this._setToDefault = isDefault;

        // This value is going to be saved on the form itself under form.values.
        // If we have a hidden data element (for direct submission), update it now so that
        // when the form gets submitted the element value is present.
        if (this.isDrawn()) {
            if (this._useHiddenDataElement()) this._setHiddenDataElementValue(value);      
        }
               
        if (value == undef && this._clearingValue) {
            this.form.clearItemValue(this);
        } else {
            this.form.saveItemValue(this, value);
        }
    },
    
    // If we're using a hidden data element, this method will set its value, so when the form
    // is natively submitted the value is available to the server.
    _setHiddenDataElementValue : function (value) {
        var hde = this._getHiddenDataElement();
        if (hde) hde.value = value;
    },
    
    //>	@method	formItem.setValue()
	// Set the value of the form item to the value passed in
    // <p>
	// NOTE: for valueMap'd items, newValue should be data value not displayed value
    // @visibility external
	// @param	newValue 	(any)				value to set the element to
    //<
    // @param   [allowNullValue]   (boolean) Internal parameter to avoid setting to default when
    // passed a null value. Used when redrawing a form item that the user has explicitly set
    // to null as opposed to a call to 'setValue(null)' which will reset to default.
    _$smart:"smart",
	setValue : function (newValue, allowNullValue) {
        
        this._setValueCalled = true;  
        // If we have focus, remember the selection so we can retain the cursor insertion point
        // - useful for the case where this is a simple data transform, such as case-shifting
        var resetCursor = (this.maintainSelectionOnTransform && this.hasFocus && 
                           (this._getAutoCompleteSetting() != this._$smart));                      
        if (resetCursor) this.rememberSelection();
        
        // since we're being set to an explicit value, cancel delayed save on keyPress
        if (this._pendingUpdate != null) {
            isc.Timer.clearTimeout(this._pendingUpdate);
            this._pendingUpdate = null;
        }
        
        // use the default value if necessary.
        
        var isDefault;

        if (newValue == null && !allowNullValue) {
            var defaultVal = this.getDefaultValue();
            // don't apply the default value if it's not set - this allows for the distinction 
            // between setting the value to 'null' vs 'undefined'
            if (defaultVal != null) {
                isDefault = true;
                newValue = defaultVal;
            }
        }

		// truncate newValue to the length of the field, if specified
		if (this.length != null && newValue != null && isc.isA.String(newValue) &&
            newValue.length > this.length) 
        {
			newValue = newValue.substring(0, this.length);
		}         
        // saveValue will store the value as this._value, and will save the value in the form 
        // if this.shouldSaveValue is true
        this.saveValue(newValue, isDefault);

        // If we're using a displayField, kick off a fetch to retrieve the appropriate value from our
        // optionDataSource if necessary here.
        if (this.fetchMissingValues && newValue != null && this.getDisplayFieldName() != null
            && (!this._gotAllOptions || !this.filterLocally)) 
        {
            // _checkForDisplayFieldValue() will check whether we currently have a display
            // value for the value - if not it will kick off a fetch to retrieve such a value
            this._checkForDisplayFieldValue(newValue);
        }
        
        
		// map the value passed to the visible value as necessary
        var displayValue = this.mapValueToDisplay(newValue);
		// set the value of the item
        
        
        this.setElementValue(displayValue, newValue);
        
        // On simple data transforms (currently case shifting only), we will retain the
        // cursor positon across setValue() calls if the item has focus
        if (resetCursor) this.resetToLastSelection(true);
        
        return newValue
	},

    // used by Visual ISC only
    setDefaultValue : function (newValue) {
        var prevDefaultValue = this.defaultValue, undef;
        this.defaultValue = newValue;
        if (this.isSetToDefaultValue() || (this._value == null && prevDefaultValue === undef)) 
            this.clearValue();
    },
        
    _checkForDisplayFieldValue : function (newValue) {
        var inValueMap = (this._mapKey(newValue, true) != null);

        if (!inValueMap) {
            var ods = this.getOptionDataSource();
            if (ods && 
                (this._fetchingMissingValues == null || !this._fetchingMissingValues[newValue])) 
            {
                // Flag to indicate we're currently getting this missing value from the server
                // so we don't kick off another fetch for the same value.
                // This will be cleared when we get the display value back (at which point the
                // display value  will show up in the result of this.getValueMap())
                if (!this._fetchingMissingValues) this._fetchingMissingValues = {};
                this._fetchingMissingValues[newValue] = true;
                
                // Check for the case where we're already fetching the value
                var recordCrit = {};
                if (!this.filterLocally) {
                    recordCrit[this.getValueFieldName()] = newValue;
                }
                ods.fetchData(recordCrit, 
                    {target:this, 
                     methodName:"fetchMissingValueReply"}, 
                     {showPrompt:false, clientContext:{dataValue:newValue}}
                );
            }
        }
    },
    
    // Callback method fired when the server returns with the display value from 
    // our optionDataSource.
    // Fold this new value into our valueMap, and if necessary refresh to display it.
    fetchMissingValueReply : function (response, data, request) {
        
        // If we fetched all the values in the data-set, use array.find to find the appropriate
        // one
        var record,
            dataVal = response.clientContext.dataValue,
            displayField = this.getDisplayFieldName(),
            valueField = this.getValueFieldName();
        
        // Clean up the _fetchingMissingValues object
        delete this._fetchingMissingValues[dataVal];
        
        if (data) record = data.find(valueField, dataVal);
 
        if (!record) {
            //>DEBUG 

            this.logInfo("Unable to retrieve display value for data value:" + dataVal +
                        " from dataSource " + this.getOptionDataSource());
            //<DEBUG
            
            // If filterLocally is false, we're done - otherwise continue and create the special
            // valueMap anyway
            if (!this.filterLocally) return;
        }
        
        // Add to the special 'displayFieldValueMap'
        // This is combined with any explicitly specified valueMap by 'getValueMap()'
        if (this._displayFieldValueMap == null) this._displayFieldValueMap = {};
        var valueMap = this._displayFieldValueMap;
        
        var undef;
        for (var i = 0; i < data.length; i++) {
            record = data[i];
            var value = record[valueField], display = record[displayField];
            
            // Note: We assume uniqueness here - if multiple records are returned with the same
            // data value, we'd expect them to have the same display value (and we can ignore
            // the later rows).
            if (valueMap[value] !== undef) {
                if (valueMap[value] != display) {
                    // Log a warning if we hit duplicate entries with non duplicate display
                    // values
                    this.logWarn("Deriving valueMap for '" + valueField + 
                                    "' from dataSource based on displayField '" + displayField + 
                                    "'. This dataSource contains more than one record with " + valueField 
                                    + " set to " + value + " with differing " + displayField + " values." 
                                    + " Derived valueMap is therefore unpredictable.");
                }
                continue;
            }
            
            valueMap[record[valueField]] = record[displayField];
        }
        
        // If we retrieved the entire dataSet, set a flag to avoid future fetches that 
        // would otherwise occur if 'setValue()' was called passing in a value that's 
        // not present in this valueMap
        if (this.filterLocally) this._gotAllOptions = true;
 
        // We need to refresh our displayed value if we're still showing the 
        // data value
        var needsRefresh = (this._value == dataVal);
        this.updateValueMap(needsRefresh);
    },
    
    //>	@method	formItem.clearValue()
	// Clear the value for this form item.<br>
    // If a default value is specified, value will be set to that default value, otherwise 
    // value will be cleared, (and removed from the containing form's values).
    //
	//<
    
    clearValue : function () {
        
        this._clearingValue = true;
        this.setValue();
        delete this._clearingValue;
    },
    
	//>	@method	formItem.setElementValue()
	// Update the form item to display the value passed in.  If this item has a true form data
    // element (text box, checkbox, etc), this method will set the value of that element.
    // Otherwise updates the necessary HTML for the form item to display the new value.
    // Note that the <code>newValue</code> passed in is expected to be the display value, 
    // rather than the raw value (should have  already been passed through 
    // <code>this.mapValueToDisplay()</code>).
    //
	//		@group	elements
	//		@param	newValue 	(any)	value to set the element to 
	//<
    // Note this method also update any valueIcon to display the appropriate value for the
    // current form item value
    
	setElementValue : function (newValue, dataValue) {
        if (!this.isDrawn()) return;
        
        var undef;
        if (dataValue === undef) {  
            dataValue = this._value;
        }
        
        
        // If we hae a data element we always set element.value
        if (this.hasDataElement()) {
            
        
        
		    // get a pointer to the native form element for this item
    		var element = this.getDataElement();
            if (element != null) {
                this._updateValueIcon(dataValue);
                return element.value = newValue;
            }
        }
        // otherwise if we have no data element, just redraw the content of our text box
        var textBox = this._getTextBoxElement();
        if (textBox != null) {
            if (this.showValueIconOnly) newValue = isc.emptyString;
            var valueIconHTML = this._getValueIconHTML(dataValue);        
            if (valueIconHTML != null) 
                newValue = valueIconHTML + (newValue != null ? newValue :  isc.emptyString);
            textBox.innerHTML = newValue;
            if (!this.clipValue || this.height == null || this.width == null) {
                this.adjustOverflow("textBox value changed");
            }
        }
        
        // If we didn't get a pointer to our text box, we would expect the sub item to
        // implement an appropriate override to setElementValue()
	},
    
    // _updateValueIcon
    // Explicitly updates the valueIcon image src based on the data value passed in.
    _updateValueIcon : function (value) {
        if (this.suppressValueIcon || !this.isDrawn()) return;
        var src = this._getValueIcon(value),
            valueIconHandle = this._getValueIconHandle();
        if (src != null) {
            if (this.imageURLSuffix != null) src += this.imageURLSuffix;
            src = isc.Canvas.getImgURL(src, this.imageURLPrefix || this.baseURL || this.imgDir);
            // If the image is already written out, just update its src
            if (valueIconHandle != null) {
                valueIconHandle.src = src;
            // In this case the valueIcon has never been written out.
            // Positioning of the valueIcon will vary by form item. 
            // - for data element based items, such as text items, we write the icon out before
            //   the data element
            // - for non data element based items, such as (synthetic) selects, we write the
            //   icon out inside the text box
            
            } else {
                var inserted = false;
                if (this.hasDataElement()) {
                    var element = this.getDataElement();
                    if (element != null) {
                        isc.Element.insertAdjacentHTML(
                            element, "beforeBegin", this._getValueIconHTML(value)            
                        );
                        element.style.width = this.getTextBoxWidth(value);
                        inserted = true;
                    }
                } else {
                    var textBox = this._getTextBoxElement();
                    if (textBox != null) {
                        isc.Element.insertAdjacentHTML(
                            textBox, "afterBegin", this._getValueIconHTML(value)                        
                        );
                        inserted = true;
                    }
                }
                // sanity check - if we failed to insert the icon, redraw
                if (!inserted) this.redraw();
            }
        
        // If we have no current value icon, clear the handle if its present.
        } else if (valueIconHandle != null) {
            isc.Element.clear(valueIconHandle);
            if (this.hasDataElement()) {
                var element = this.getDataElement();
                element.style.width = this.getTextBoxWidth(value);
            }
        }
    },
    
    
    //>@method formItem.setHint()
    // Set the hint text for this item
    // @param hintText (string) new hint for the item
    // @visibility external
    //<
    setHint : function (hintText) {
        this.hint = hintText;
        if (this.showHint) this.redraw();
    },
    
    //>@method formItem.setHintStyle()
    // Set the hintStyle for this item
    // @param hintStyle (CSSStyleName) new style for hint text
    // @visibility external
    //<
    setHintStyle : function (style) {
        if (this.getHint()) {
            var hintHandle = this._getHintCellElement();
            if (hintHandle) hintHandle.className = style;
        }
    },

    // Value Management
	// --------------------------------------------------------------------------------------------

	//>	@method	formItem.getDefaultValue()
	// Return the default value for this item
	//		@group	elements
	//
	//		@return	(any)		value of this element
	//<
	getDefaultValue : function () {
		if (this.defaultDynamicValue) {
			// CALLBACK API:  available variables:  "item,form,values"
			// Convert a string callback to a function
            this.convertToMethod("defaultDynamicValue");
			var item = this,
				form = this.form,
				values = this.form.getValues()
			;
			return this.defaultDynamicValue(item,form,values);
		}
        // Return this.defaultValue - note that this will return null (technically 'undef') if no
        // default value has been set, which is appropriate - allows null values in form items.
		return this.defaultValue;
	},
	
	//>	@method	formItem.setToDefaultValue()
	// Set the value for this item to the default value stored in the item
	//		@group	elements
	//		@return	(any)		value of this element
	//<
    // Since a defaultValue means we don't support setting to null, this is really just a 
    // synonym for clearValue(), which itself calls 'setValue(null)' and lets setValue figure
    // out the defautlValue.
	setToDefaultValue : function () {
        return this.clearValue();
	},
    
    //> @method formItem.isSetToDefaultValue()
    // Is the current value displayed by the form item derived from the default value for the
    // item.
    // @return (boolean) True if this item's value is derived from the default
    //<
    isSetToDefaultValue : function () {
        return (this._setToDefault == true);
    },

    _completionAcceptKeys : {
        "Tab":true,
        "Arrow_Left":true,
        "Arrow_Right":true,
        "Arrow_Up":true,
        "Arrow_Down":true,
        "Home":true,
        "End":true,
        "Page_Up":true,
        "Page_Down":true,
        "Enter":true
    },

    //> @method formItem.updateValue()
    // Update the stored value for this form item based on the current display value.
    // 
    //  @see saveValue()
    //  @see handleChange()
    //  @see mapDisplayToValue()
    //  @visibility internal
    //<
    // Performs the following steps:
    // - takes the current value of this item's form element
    // - maps it to the appropriate value for storage using 'mapDisplayToValue()'
    // - perform validation of the form item [if validateOnChange is true]
    //      - if the resulting value from the validator differs from the value passed in,
    //        update the display and stored value to reflect this.
    // - fire any 'transformInput()' method on the value passed in. If the value is changed,
    //   store and display this new value
    // - fire the change handler for the field.
    //      - if the change handler returns false, revert to the previous value
    // - return false if the change was "rejected". IE:
    //      - a validator failed
    //      - a change handler returned false.
    
    updateValue : function () {
        // this is effectively meaningless if we have no element (override for special cases
        // like container items)
        if (!this.hasElement() || this.getDataElement() == null) return;

        var newValue = this.getElementValue();
        return this._updateValue(newValue);
    },

    
    // Majority of the 'updateValue' logic separated from the need for a native form element
    // to simplify overrides.
    _updateValue : function (newValue) {
        // avoid spurious changes with auto-completion
        if (this._pendingCompletion) {
            newValue = this._handleChangeWithCompletion(newValue);
        }
        
        // unmap the value if necessary 
        newValue = this.mapDisplayToValue(newValue);

        // Bail if we have already saved the value (avoids firing change on arrow keypresses,
        // etc.)
        if (this.compareValues(newValue, this._value)) return true;
        
        // This method may have been tripped by the developer's change handler somehow
        // (most common example - causing formItem to blur() when changeOnBlur is true)
        // If this is the case, bail unless the value passed in differs from the value we're
        // about to save (stored as this._changeValue)
        if (this._changingValue) {
            if (this.compareValues(newValue, this._changeValue)) return true;
            
        }
        
        // fire the change handler, (handles validation etc)
        // Notes:
        // - handleChange may modify the value to be saved (due to validator.suggestedValue,
        //   change handler returning false, etc). 
        //   In this case:
        //   - it will also actually save the value / reset the elementValue via a call to 
        //      setValue()
        //   - It will store the resulting value from the change handler 
        //     (whether modified and saved or not) as this._changeValue. We can then save
        //     this value out iff it hasn't already been saved (!= this._value).
        // - We consider some interactions a change "failure"- such as the change handler
        //   explicitly returning false. In these cases the handleChange() method will return
        //   false. We simply return this to our calling method in case there is any special
        //   handling to be performed.
        var returnVal = this.handleChange(newValue, this._value);
        
        // The change handler may call 'setItems' on the form (particularly likely in LG editing)
        // in which case we'll be destroyed
         
        if (this.destroyed) return;
                
        // Ensure we have the latest value (stored as this._changeValue)
        newValue = this._changeValue;
        // We may need to perform some visual updates based on the new value - do this here
        this.updateAppearance(newValue);

        // save the value
        if (!this.compareValues(newValue, this._value)) this.saveValue(newValue);
        
        delete this._changeValue;
        
        // fire any specifed 'changed' handler for this item.
        
        this.handleChanged(this._value);
        
        return returnVal;
    },
    
    // handleChanged() - helper to fire any user-specified "changed" handler on this item.
    handleChanged : function (value) {
        if (this.changed) this.changed(this.form, this, value);
        if (this.form && this.form.itemChanged != null) {
            this.form.itemChanged(this, value);
        }
    },

    // updateAppearance() - helper method fired in response to updateValue when we have
    // a new value (entered by the user)
    // Default implementation will just rewrite any valueIcon's URL.
    
    updateAppearance : function (newValue) {
        if (this.valueIcons || this.getValueIcon) {
            this._updateValueIcon(newValue);
        }
    },
    

	//>	@method	formItem.getValue()
	// Return this form items value.
    // <p>
    // For valueMap'd items, or items with 'mapValueToDisplay()' / 'mapDisplayToValue()'
    // defined, the data value rather than the display value is returned.
    //		@group formValues
	//		@return	(any)   value of this element
    // @visibility external
	//<
	getValue : function () {
        // We return this._value, rather than looking at the form item's element and deriving
        // the value from there.
        // This is appropriate for a number of reasons.
        //  - this._value may be of a type not supported by the form element, which usually only 
        //    supports strings.  We need to track booleans, null (as distinct from null
        //    string), or a number (as opposed to a number in String form). 
        //    The value set by user interaction in the form may need to be processed before it
        //    can be stored as this._value.
        //  - We want to ensure that a change handler is fired before the value is updated
        //    (allowing users to cancel a change).  
        //    If getValue() were to return the value derived from the element, in some cases we 
        //    would not have recieved a change notification, but the value returned would be 
        //    different from the last stored value.
        //
        // We keep this._value up to date via the 'updateValue()' method, which will fire
        // change handlers and validators for the item, then store the value via 'saveValue()'
        // updateValue() is called whenever the value may have changed (depending on the form
        // item type this may be a result of native onchange, keypress or other event[s]).
        var undef;
        if (this._value !== undef) {
            return this._value;
        }
        
        // If no value has been stored for this element, return the value the form has for this 
        // element.
        
        return this.form.getSavedItemValue(this);
	},

	//>	@method	formItem.getElementValue()
	//			return the value stored in the form element(s) for this item without modification
	//		@group	elements
	//
	//		@return	(any)		value of this element
	//<
    
	getElementValue : function () {
        
        
		// get a pointer to the element for this item
		var element = this.getDataElement();
		
		// if no element was found, bail
		if (!element) return null;

		// get the value of the item
		return element.value;
	},
    
	
	//>	@method	formItem.resetValue()
	// Reset the value for this item to the value stored in the last save point for the form
	//		@group	elements
	//<
	resetValue : function () {
		var oldValue = this.form._oldValues[this.getFieldName()];
		this.setValue(oldValue);
	},
	
    //>	@attr formItem.shouldSaveValue (boolean : true : IR)
    // Should this item's value be saved in the form's values and hence returned from
    // +link{dynamicForm.getValues,form.getValues()}?
    // <p>
    // <code>shouldSaveValue:false</code> is used to mark formItems which do not correspond to
    // the underlying data model and should not save a value into the form's
    // +link{dynamicForm.values,values}.  Example includes visual separators, password re-type fields,
    // or checkboxes used to show/hide other form items.
    // <p>
    // A <code>shouldSaveValue:false</code> item should be given a value either via
    // +link{formItem.defaultValue} or by calling can use
    // +link{dynamicForm.setValue,form.setValue(item, value)} or 
    // +link{formItem.setValue,formItem.setValue(value)}.  Providing a value via
    // +link{dynamicForm.values,form.values} or +link{dynamicForm.setValues,form.setValues()} 
    // will automatically switch the item to <code>shouldSaveValue:true</code>.
    // <P>
    // Note that <ul>
    // <li>if an item is shouldSaveValue true, but has no name, a warning is logged, and 
    //     shouldSaveValue will be set to false.
    // </li></ul>
    //
    // @group formValues
    // @visibility external
    //<
    shouldSaveValue:true,
    
    // Will this form item's value be submitted directly to the server via a native form submit?
    shouldSubmitValue : function () {
        return this.form._formWillSubmit();
    },

    //> @method formItem.isEditable()
    // Can this items value be edited by the user
    // @return (boolean)    true if the user can edit this item's value.
    //<
    // Most form items are editable so return true by default an override for the cases where
    // items are just there to display static values, even though technically an instance of 
    // the FormItem class would not be editable.
    isEditable : function () {
        return true;
    },
    
        
    //> @method formItem.getCriterion() (A)
    // Override this method if you need to provide a specialized criterion from this formItem
	// when creating an AdvancedCriteria via +link{dynamicForm.getValuesAsCriteria()}.
	// <P>
	// This API is provided to allow you to specify a more complex criterion than the 
	// "field-operator-value" criterions that are built-in.  Note that the built-in behavior is
	// generally quite flexible and powerful enough for most requirements.  An example of a case
    // where you might want to override this method is if you wanted to implement a date range 
    // selection (ie, date &gt; x AND date &lt; y) on a form that was combining its other criteria 
    // fields with an OR.
    //
    // @visibility external
    //<
    getCriterion : function () {
        var value = this.getValue();
        if (value == null || isc.is.emptyString(value)) return;
		// multi-selects are returned as an array.  
		if (isc.isAn.Array(value)) {
            // If nothing is selected, or if blank is selected, no criteria
            if (value.length == 0 || value.contains(isc.emptyString)) return;
        }
        
        if (this.operator) {
            var operator = this.operator;
        } else {
            if (this.valueMap || this.optionDataSource || 
                    isc.SimpleType.inheritsFrom(this.type, "enum")) {
                operator = "equals";
            } else {
                operator = "iContains";
            }
        }

        return {
            fieldName: this.criteriaField ? this.criteriaField : this.name,
            operator: operator, 
            value: value
        }
    },
    

    
    // Errors
	// --------------------------------------------------------------------------------------------
	
	//>	@method	formItem.clearErrors()
	//			Clear all error messages for this item
	//		@group	errorhandling
	//<
	clearErrors : function () {
		var name = this.getFieldName();
		if (name) this.form.clearFieldErrors(name, true);
	},

	//>	@method	formItem.setError()
	// Set the error message for this item
	//		@group	errorhandling
	//		@param	message	(string) error message
	//<
	setError : function (message) {
		var name = this.getFieldName();
		if (name) this.form.setError(name, message);
	},

	//>	@method	formItem.hasErrors()
    //		Return whether this item currently has any validation errors as
    //		 a result of a previous validation pass.
    //		@group	errorhandling
    //	@return	(boolean)	true == item currently has validation errors.
	//<
    hasErrors : function () {
        // recurse up parent tree to find the root form item and get the correct error status
        if (this.parentItem != null) return this.parentItem.hasErrors();
        var name = this.getFieldName();
        
        if (name && this.form) return this.form.hasFieldErrors(name);
        return false;
    },
    	
    // AutoComplete
	// -----------------------------------------------------------------------------------------

    // change fires on keyPresses that change value

    // intended key behaviors: no changes needed to accomplish these, generally
    // - accept match:
    //   - Navigate away from field: Tab/Shift-Tab
    //     - inline editing: Arrow Up/Down, Enter
    //   - Enter (w/o inline editing)
    // - remove match:
    //   - Delete/Backspace

    //> @method formItem.setAutoComplete()
    // Change the autoCompletion mode for this form field.
    //
    // @param   newSetting (AutoComplete)  new setting
    // @visibility autoComplete
    //<
    setAutoComplete : function (newSetting) {
        this.autoComplete = newSetting;
        this._handleAutoCompleteChange();
    },

    _handleAutoCompleteChange : function () {
        // get cascaded setting
        var setting = this._getAutoCompleteSetting();
        // toggle setting on native element
        if (isc.Browser.isIE && this.hasDataElement()) {
            var element = this.getDataElement();
            if (element) element.autoComplete = (setting == "native" ? "" : "off");
        }
    },

    // get cascaded autoComplete setting
    _getAutoCompleteSetting : function () {
        if (this.autoComplete != null) return this.autoComplete;
        return this.form.autoComplete;
    },

    // whether ISC auto complete is enabled
    autoCompleteEnabled : function () {
        // unsupportable at the moment
        if (isc.Browser.isSafari) return false;

        return this._getAutoCompleteSetting() == "smart";
    },

    // whether we're set to show unique matches only 
    uniqueMatchOnly : function () {
        if (this.uniqueMatch != null) return this.uniqueMatch;
        return this.form.uniqueMatch;
    },

    // get candidates for autoCompletion
    getCandidates : function () {
        var candidates = this.autoCompleteCandidates;
        
        if (candidates == null) {
            var valueMap = this.getValueMap();
            if (valueMap != null) {
                if (isc.isAn.Array(valueMap)) candidates = valueMap;
                else candidates = isc.getValues(valueMap);
            // return values from adjacent records in the dataset, if available
            } else if (this.form.grid) {
                var data = this.form.grid.data;

                // return all values that happen to be cached
                if (isc.isA.ResultSet!=null && isc.isA.ResultSet(data)) candidates = data.getValuesList(this.name);
                // return all values for the column
                else candidates = data.getProperty(this.name);
            }
        }

        // Clear out duplicates from the candidates - if we have a ListGrid with multiple
        // instances of some string in the results, we want to allow autoCompletion to that
        // string.
        // (Note this will NOT clear out strings that are identical except for case, even 
        // though they don't autoComplete differently, which is appropriate)
        if (candidates != null) candidates = candidates.getUniqueItems();
        return candidates;
    },
    
    // get the completion, if any, for this value
    getCompletion : function (base) {
        if (base == null) return;
        var candidates = this.getCandidates();
        if (candidates == null || candidates.length == 0) return;
        
        var upperBase = base.toUpperCase(),
            uniqueMatchOnly = this.uniqueMatchOnly(),
            firstMatch;        
        for (var i = 0; i < candidates.length; i++) {
            var candidate = candidates[i],
                upperCandidate = candidate != null ? candidate.toUpperCase() : null;
            // if the user has exactly typed one of our auto-complete options, don't show
            // any completions
                        
            if (upperCandidate == upperBase) return null;
            if (isc.startsWith(upperCandidate, upperBase)) {
                // return the first match
                if (!uniqueMatchOnly) return candidate;
     
                // only return a unique match
                if (firstMatch != null) return null;           
                firstMatch = candidate;
            }
        }
        return firstMatch;
    },
    
    // show an autoComplete value, if there's a valid match
    showCompletion : function (value) {

        // drop any existing completion
        this.clearCompletion();

        // check for whether autoCompletion makes sense for this type of FormItem, whether we
        // currently have an element
        if (!this.canAutoComplete || !this.hasDataElement() || 
            !this.autoCompleteEnabled()) return;

        // don't autoComplete on backspace or delete, despite change to form value
        var keyName = isc.EH.lastEvent.keyName;
        
        if (keyName == "Backspace" || keyName == "Delete") return;

        var completion = this.getCompletion(value);
        if (completion == null) {
            
            return;
        }

        // set the autocompletion value
        // NOTE: preserve upper/lowercase of typed-in value; we only convert to the
        // completion's casing when the user accepts the completion

        // Blur, and re-focus in the form item (without firing handlers).
        // This is required if the Input Method Editor (IME) is active to get out of the IME
        // mode, so that additional keypresses will overwrite the (selected) completion 
        // characters
        // (The IME is used to enter multibyte chars, such as Japanese, using a western 
        // keyboard, with multiple keystrokes returning a single character)
        
     
        this.form._blurFocusItemWithoutHandler();
        this.form._focusInItemWithoutHandler(this);


        this.setElementValue(value + completion.substring(value.length));
        this._baseValue = value;
        this._pendingCompletion = completion;

        // select the completion
        this.setSelectionRange(value.length, completion.length);
        
        
    },

    
    _handleChangeWithCompletion : function (newValue) {
        var completion = this._pendingCompletion,
            keyName = isc.EH.lastEvent.keyName;
        
        if (this._completionAcceptKeys[keyName]) {
            // if the completion is accepted, switch value to the exact letter case
            // of the completion value.
            // Note that with the exception of the "Enter" key, all completionAcceptKeys are
            // navigation keys that will modify the selection / text insertion point in the
            // text box.
            // If the user hit Enter, always put focus at the end of the word so the user can
            // continue typing.
            // Otherwise, respect wherever the browser natively put the cursor.
            
            this.acceptCompletion(keyName == this._$Enter);
            return completion;
        }

        var offeredText = completion.substring(this._baseValue.length);
        

        // if the field value doesn't end with the completion, the user must have typed
        // something over the completion, or deleted some characters, etc - handle as a
        // normal change.
        if (!newValue.endsWith(offeredText)) {
            this.clearCompletion();
            return newValue;
        }

        

        // if the completion is still selected, override the value in the field, which contains
        // the completion, returning instead the text as it was when the completion was offered
        if (this.getSelectedText() == offeredText) {
            
            return this._baseValue;
        }
    
        // otherwise the completion is no longer selected, use the value in the field
        
        this.clearCompletion();
        return newValue;

        // alternate approach: 
        //var charValue = isc.EH.lastEvent.characterValue;
        //if (charValue != null) return newValue;
        //this.logWarn("no change, trimmed value to: " + newValue);
        //return this._baseValue;
    },

    clearCompletion : function () {
        delete this._pendingCompletion;
        delete this._baseValue;
    },

    // accept any pending autoCompletion
    acceptCompletion : function (cursorAtEnd) {
        var completion = this._pendingCompletion;
        if (!completion) return;

        if (this.autoCompleteEnabled()) {
            

            // Cursor insertion position:
            // The user can accept completion in several ways. Depending on what interaction
            // occurred we may need to change the cursor insertion point after setting the
            // form item element value.
            // Completion tripped by:
            // - taking focus from the field.
            //      No need to worry about cursor insertion position
            // - via various 'navigation' type keypresses (arrow left, home, etc)
            //      In this case rely on native browser behavior to 'do the right thing'
            //      Observed behavior: On right arrow focus goes to the end of the completion.
            //      On Left arrow, behavior varies by browser
            //      Remember the position before changing the element value so we can re-set 
            //      to that position.
            // - enter keypress
            //      Explicitly put focus at the end of the field so the user can continue typing
            //      We achieve this by passing in a special 'focusAtEnd' parameter if the 
            //      completion was accepted via an enter keypress.
            var selectionRange = cursorAtEnd ? [completion.length, completion.length] : null;
            if (this.getElementValue() != completion) {
                if (!cursorAtEnd) selectionRange = this.getSelectionRange();
                this.setElementValue(completion);
            }
            
            if (this.hasFocus && selectionRange) 
                    this.setSelectionRange(selectionRange[0], selectionRange[1]);
        }
        this.clearCompletion();
    },

    // Text Selection
	// ----------------------------------------------------------------------------------------

    // select characters between the given indices
    _$character:"character",
    setSelectionRange : function (start, end) {

        // applies only to text items (and subclasses)
        if (!isc.isA.TextItem(this) && !isc.isA.TextAreaItem(this)) return;

        var element = this.getDataElement();
        if (element == null) return;
        if (isc.Browser.isIE) {
            // IE proprietary API
            var range = element.createTextRange();
            range.collapse(true);
            range.moveStart(this._$character, start);
            range.moveEnd(this._$character, (end-start));            
            range.select();
        } else if (!isc.Browser.isSafari) {
            // DOM API, known to be supported by Moz but not Safari
            element.focus();
            element.setSelectionRange(start, end);
        }
        
    },
    
    // Returns the indices of the start/end of the current selection
    _$EndToEnd:"EndToEnd", _$EndToStart:"EndToStart", _$character:"character",
    getSelectionRange : function (timeCritical) {
        // applies only to text items (and subclasses)
        if (!isc.isA.TextItem(this) && !isc.isA.TextAreaItem(this)) return;
        
        if (isc.isA.UploadItem(this)) return;
        
        var element = this.getDataElement();
        if (element == null) return;
        if (isc.Browser.isIE) {
            var rangeArray = [],
                selectedRange = this._getIESelectionRange();
            
            var testRange = element.createTextRange();
            if (testRange == null || selectedRange == null) return;
            
            if (isc.isA.TextAreaItem(this)) {
                if (!this.supportsSelectionRange) return null;
                
                var length = testRange.text.length;
                // if they already match then all the text is selected - we're done
                if (length == selectedRange.text.length) {
                    return [0,length];
                } else {

                    // timeCritical parameter is passed in when we're getting the selection range
                    // from keyPress - in this case this method HAS to be quick, so we shortcut the
                    // logic and just check for the three most likely cases - selection at start,
                    // end, or everything selected                    
                    if (timeCritical) {
                        if (testRange.offsetLeft == selectedRange.offsetLeft && 
                            testRange.offsetTop == selectedRange.offsetTop) 
                        {             
                            return [0, selectedRange.text.length];
                        } else {
                            testRange.collapse(false);
                            if (testRange.offsetLeft == selectedRange.offsetLeft && 
                                testRange.offsetTop == selectedRange.offsetTop) 
                            {                
                                return [length, length];
                            }                            
                        }
                    } else {
                        for (var i = 0; i <= length; i++) {
                            if (testRange.offsetLeft == selectedRange.offsetLeft && 
                                testRange.offsetTop == selectedRange.offsetTop) 
                            {                            
                                return [i, i + selectedRange.text.length];
                            }
                            
                            testRange.moveStart(this._$character);
                        }
                    }
                }                
                return null;
            }

            // does the selection end at the end of the input?
            if (testRange.compareEndPoints(this._$EndToEnd, selectedRange) == 0) {

                rangeArray[1] = testRange.text.length;
            } else {
                testRange.setEndPoint(this._$EndToEnd, selectedRange);
                rangeArray[1] = testRange.text.length;
            }
            
            testRange.setEndPoint(this._$EndToStart, selectedRange);
            rangeArray[0] = testRange.text.length;
            return rangeArray;
        } else if (isc.Browser.isMoz) {
            return [element.selectionStart, element.selectionEnd];
        }
        
        
    },
    
    // return the selected text within the form item
    getSelectedText : function () {
        // Only support getting selected text of a textual edit field
        if (!isc.isA.TextItem(this) && !isc.isA.TextAreaItem(this)) {
            return;
        }
        

        if (isc.Browser.isIE) {
            
            var range = this._getIESelectionRange();
            if (range) return range.text;
        } else if (isc.Browser.isMoz) {
            
            var element = this.getElement();
            if (element != null) {
                return element.value.substring(element.selectionStart, element.selectionEnd);
            }
        }
    },
    
    // Helper method for determining form item selection in IE
    _getIESelectionRange : function () {
        if (!isc.Browser.isIE) return;
        
        if (isc.isA.TextAreaItem(this) && !this.supportsSelectionRange) return null;
        
                
        
        var selection = this.getDocument().selection,
            range = (selection != null ? selection.createRange() : null);
            
        if (range != null && range.parentElement().id == this.getDataElementId()) return range;
        return null;
    },

    // helper methods to remember the current text selection / text insertion point within
    // some form item.
    
    rememberSelection : function () {
        // No op if we're not drawn
        if (!this.isDrawn()) return;
        
        // Not currently supported on Safari
        if (isc.Browser.isSafari) return;
        // applies only to text items (and subclasses)
        if (!isc.isA.TextItem(this) && !isc.isA.TextAreaItem(this)) return;

        // If the field is empty we can skip remembering the insertion point!
        var elementValue = this.getElementValue();
        if (elementValue == isc.emptyString) return;

        this._valueAtLastSelection = elementValue;
        
        var range = this.getSelectionRange();        
        if (range) {      
            this._lastSelectionStart = range[0];
            this._lastSelectionEnd = range[1];
        }
        
    },
    
    resetToLastSelection : function (dataTransform) {
        // If we aren't drawn, or don't have a remembered selection we can't reset it!
        if (!this.isDrawn() || this._lastSelectionStart == null) return;
        
        var shouldReset,
            elementValue = this.getElementValue(),
            // valueAtLastSelection will always be a string.
            oldValue = this._valueAtLastSelection;
        if (!dataTransform) shouldReset = (elementValue == oldValue);
        else {
            // If this is a data transform, we want to reset if the value has just case shifted
            // or if everything was selected before the change
            if (this._lastSelectionStart == 0 && this._lastSelectionEnd == oldValue.length) {
                shouldReset = true;
                // Shift the end to ensure we select the entire new value
                this._lastSelectionEnd = elementValue.length;
            } else {
                shouldReset = (elementValue.toLowerCase() == oldValue.toLowerCase());
            }
        }
        if (shouldReset) this.setSelectionRange(this._lastSelectionStart, this._lastSelectionEnd);
        delete this._lastSelectionStart;
        delete this._lastSelectionEnd;
        delete this._valueAtLastSelection;
    },
    

    // Event handling
	// ----------------------------------------------------------------------------------------
    
      
    //> @method formItem.handleChange()
    //      Internal method called whenever this item value is modified by user interaction
    //      (Called from 'updateValue()').<br>
    //      Calls call validators on this item if this.validateOnChange is true<br>
    //      Calls any 'change' handler specified for this item.<br>
    //      If validation fails or the change handler returns false, this method will reset the
    //      element to display the current item value, or validator suggested value (rejecting the 
    //      change).
    //  @return (boolean)   false if the change was rejected
    //  @see updateValue()
    //  @see change()
    //  @see validateOnChange
    //  @visibility internal
    //<
    
    handleChange : function (value, oldValue) {
        
        if (this._changingValue && this.compareValues(value, this._changeValue)) return true;
        
        // Set the flag to indicate that we're performing a change
        this._changingValue = true;
        // By default we will not modify the value passed in.
        this._changeValue = value;
        
        // If the value changes due to a validator, etc. we have to know about it so we can
        // call this.setValue()
        var originalValue = value;
        // Handle the kinds of data that get passed around by reference
        if (isc.isA.Date(originalValue)) originalValue = originalValue.duplicate();
        else if (isc.isAn.Array(originalValue)) originalValue = originalValue.duplicate();
        else if (isc.isAn.Object(originalValue)) originalValue = isc.addProperties({}, originalValue);
    
        // If there's a transformInput method specified, allow it to update the value before
        // we proceed with validation, etc.
        if (this.transformInput) {
            value = this.transformInput(this.form, this, value, oldValue);
        }
    
		// if we're supposed to fire any validators on change, do so now
		var hadErrorsBefore = this.hasErrors(),
            cancelSave = false,
            validateOnChange = false,
		    errors = [],
            suggestedValue
        ;
        
        // If we have a specified length, and the value is a string that exceeds that length
        // trim it down now.
        if (this.length != null && isc.isA.String(value) && value.length > this.length) {
            value = value.substring(0, this.length);
        }
		
		// if the item has validators
		if (this.validators) {
			var validators = this.validators;
			// loop through each validator
			for (var i = 0; i < validators.length; i++) {
				var validator = validators[i];
				if (!validator) continue;
				// if the form, item or validator is set to validateOnChange, 
                validateOnChange = this.form.validateOnChange || this.validateOnChange ||
                                   validator.validateOnChange;
            
				if (validateOnChange) {
	 				//	fire the validator
					var isValid = (this.form.processValidator(this, validator, value) == true);
					cancelSave = !isValid || cancelSave;
					if (!isValid) {
                        var errorMessage = isc.Validator.getErrorMessage(validator);
                        if (errorMessage == null) errorMessage = this.unknownErrorMessage;
                
						// if the validator's errorStyle is alert, show the error immediately
						if (validator.errorStyle == "alert") {
							alert(errorMessage);

						// if the validator is supposed to fail silently, don't do anything
						} else if (validator.errorStyle == "silent") {
													
						// otherwise the errorStyle is "display" and we should add the error to the errors list
						} else {
							errors.add(errorMessage);
						}
					}
					
					// if the validator returned a resultingValue, use that as the new value
					//	whether the validator passed or failed.  This lets us transform data
					//	(such as with the mask validator).
					if (validator.resultingValue != null) { 
						// remember that value in the values list
						suggestedValue = validator.resultingValue;
					}
					// if the validator failed and we're supposed to stop on a false validator
					//	bail!
					if (!isValid && validator.stopIfFalse) break;
				}
			}
            
            
            var undef;
            if (cancelSave && suggestedValue === undef) suggestedValue = oldValue;
            
            // hang onto any suggested value as our working value (so it gets passed to any
            // change handler we have)
            if (suggestedValue !== undef) value = suggestedValue;
		}
		// If we failed validation, update the errors object on the form
        
		if (cancelSave) {
			this.clearErrors();
			this.setError(errors);			
        // otherwise clear old errors if there were any
		} else if (validateOnChange && hadErrorsBefore) {
            this.clearErrors();
        }
        
        // Fire the change handler if 
        // - we passed validation 
        // - or we're supposed to fire the change handler whether an error was found or not
        this._setValueCalled = false; // setValue(), if called, sets this to true
		if ((!cancelSave || this.changeOnError)) {
    		// if either change handler returns false, we'll reset to the old value     
            if (this.change != null) {
                if (this.change(this.form, this, value, oldValue) == false) {
                    value = oldValue;
                    cancelSave = true;             
                }
	    	}          
            // the change handler can do anything including setItems on the form.
            // therefore check whether we got destroyed before continuing with this thread
            if (this.destroyed) return;

            if (!cancelSave && this.form && this.form.itemChange != null) {
                if (this.form.itemChange(this, value, oldValue) == false) {
                    value = oldValue;
                    cancelSave = true;
                }
            }
        }

        
        var userCalledSetValue = this._setValueCalled;

        // if an error was found, or another value was suggested, set the value now
        var valueChanged = !this.compareValues(value, originalValue);

        if ((cancelSave || valueChanged) && !userCalledSetValue)
        {
            this.setValue(value);
            // Reset the selection to whatever it was BEFORE the change occurred if change /
            // validators reset to the old value
            if (cancelSave && this.maintainSelectionOnTransform) this._revertToPreChangeSelection();
        }
        
        
        if (this._setValueCalled) this._changeValue = this._value;
		
		// if this item wants to redraw the form when it's changed, 
		//	or an error was found in validator, 
		//	redraw the form
		if (this.redrawOnChange || errors.length > 0 ||
           (errors.length == 0 && validateOnChange && hadErrorsBefore))
        {
			this.redraw();
		}
        
        // Avoid showing completion if focus is being taken from this item
        if (!cancelSave && this.hasFocus) this.showCompletion(value);
        // Clear out this._changingValue - we're done with our change handler
        // Leave this._changeValue in place, this is used by the calling method to determine
        // the result of the change handler.
        delete this._changingValue;
        
        return (!cancelSave);
    },
    
    // compareValues - undocumented (non obfuscated) helper method: do 2 possible values for
    // this item match
    
    compareValues : function (value1, value2) {    
        // comparison implemented on the DynamicForm class directly
        return isc.DynamicForm.compareValues(value1, value2);
    },
    
    
	//>	@method	formItem.elementChanged()
	// Handle a change event from an element.
    // <p>
    // If redrawOnChange is set, entire form will redraw.
    //
	//		@group	event handling
	//<
	elementChanged : function () {
        isc.EH._setThread("ICHG");

        this.logDebug("native change");
        // updateValue() will handle firing any validators, validate-on-change change handlers,
        // and will save the value.
        this.updateValue();
    
        isc.EH._clearThread();

		// return true so the event terminates normally (and the user can leave the field)
        
		return true;
	},
    
    // Most of our handlers are stringMethods which take 2 params, form and item.
    // To avoid code duplication have a 'fireStandardHandler' method to handle this pattern.
    _fireStandardHandler : function (handlerName) {
        this.convertToMethod(handlerName);
        return this[handlerName](this.form, this, isc.EH.lastEvent);
    },
    
    
	//>	@method	formItem.handleTitleClick()
	// Handle a click event from this items title cell.
	//		@group	event handling
	//<
    handleTitleClick : function () {
        if (this.isDisabled()) return;
        return this._fireStandardHandler("titleClick");
    },
    
    //>	@method	formItem.handleTitleDoubleClick()
	// Handle a double click event from this items title cell.
	//		@group	event handling
	//<
    handleTitleDoubleClick : function () {
        if (this.isDisabled()) return;
        return this._fireStandardHandler("titleDoubleClick");
    },

	//>	@method	formItem.handleClick()
	// Handle a click event over this form item
	//		@group	event handling
	//<
	handleClick : function () {
        if (this.isDisabled()) return;    
        return this._fireStandardHandler("click");
	},

    //>	@method	formItem.handleDoubleClick()
	// Handle a double click event over this form item
	//		@group	event handling
	//<
	handleDoubleClick : function () {
        if (this.isDisabled()) return;    
        return this._fireStandardHandler("doubleClick");
	},
    
	//>	@method	formItem.handleCellClick()
	// Handle a click event from an enclosing cell
	//		@group	event handling
	//<
	handleCellClick : function () {
        if (this.isDisabled()) return;    
        return this._fireStandardHandler("cellClick");
	},
    
    //>	@method	formItem.handleCellDoubleClick()
	// Handle a double click event from an enclosing cell
	//		@group	event handling
	//<
	handleCellDoubleClick : function () {
        if (this.isDisabled()) return;    
        return this._fireStandardHandler("cellDoubleClick");
	},
    
    
    _handleElementChanged : function () {
        return this.form.elementChanged(this.getID());
    },

    // Handlers for mouseOver/Move/Out events (sent from the Form)
    // Fires developer specified mouseOver/move/out and titleOver/move/out handlers if present.
    // handleMouseMove also handles showing icon prompts in the Hover canvas.
    
    handleMouseMove : function () {

        if (!this.isDisabled() && (this.showValueIconOver || this.showValueIconDown)) {
            var itemInfo = isc.EH.lastEvent.itemInfo,
                overItem = (itemInfo.overElement || itemInfo.overTextBox || 
                            itemInfo.overControlTable),
                iconState = this._iconState;
                
            if (overItem) {
                // If appropriate show the 'over' version of the valueIcon
                // _mouseIsDown is a flag set when the user does a mouseDown over the item and 
                // cleared on mouseUp. If this flag is set, the user did a mouseDown on the 
                // item, moved the mouse off, and back on without releasing the mouse, so we 
                // want to show down rather than over state
                if (this._mouseIsDown && this.showValueIconDown) {
                    if (iconState != this._$Down) {
                        this._iconState = this._$Down;
                        this._updateValueIcon();
                    }
                } else if (this.showValueIconOver && iconState != this._$Over) {
                    this._iconState = this._$Over;
                    this._updateValueIcon();
                }
            } else {
                
                var expectedState = (this.showValueIconFocused && this.showValueIconOver 
                                     && this.hasFocus) ? this._$Over : null;
                if (iconState != expectedState) {
                    this._iconState = expectedState;
                    this._updateValueIcon();
                }
            }
        }
        
        if (this._fireStandardHandler("mouseMove") == false) return false;
    },    
    
    handleMouseOver : function () {
        // set up the hover to show a prompt for this cell if appropriate      
        isc.Hover.setAction(this, this._handleHover, null, this._getHoverDelay());
        
        return this._fireStandardHandler("mouseOver")
    },
    handleMouseOut : function () {
        // Clear any valueIcon 'over' state when the user moves off the item
        
        
        var expectedState = (this.showValueIconFocused && this.showValueIconOver 
                              && this.hasFocus) ? this._$Over : null;
        if (this._iconState != expectedState) {
            this._iconState = expectedState;
            this._updateValueIcon();   
        }

        // Clear the hover set up for this item
        
        this.stopHover();    
        return this._fireStandardHandler("mouseOut");
    },
    
    handleMouseDown : function () {
        if (!this.isDisabled() && this.showValueIconDown) {
            var itemInfo = isc.EH.lastEvent.itemInfo,
                overItem = (itemInfo.overElement || itemInfo.overTextBox || itemInfo.overControlTable);
            if (overItem) {
                this._iconState = this._$Down;
                this._mouseIsDown = true;
                
                isc.Page.setEvent(isc.EH.MOUSE_UP, this, isc.Page.FIRE_ONCE, "_clearMouseDown");
                this._updateValueIcon();
            }
        }
        if (this.mouseDown) return this._fireStandardHandler("mouseDown");
    },
    
    //> @method FormItem.stopHover()    [A]
    // This method is fired when the user rolls off this item (or the title for this item) and
    // will clear any hover canvas shown by the item.
    // @group Hovers
    // @visibility external
    //<
    stopHover : function () {
        isc.Hover.clear();  
    },
    
    // _clearMouseDown fired on mouseUp to clear valueIcon mouseDown state.
    // (Fires whether the mouse is over this icon or not - this is how we track the case of
    // the user doing a mouseDown over us, moving off, then back on without releasing the mouse)
    _clearMouseDown : function () {
        this._mouseIsDown = null;
        // If the mouse is over us, we will be in state "Down" - in this case reset to Over
        if (this._iconState == this._$Down) {
            this._iconState = this.showValueIconOver ? this._$Over : null;
            this._updateValueIcon();
        }
    },
    
    handleMouseStillDown : function (event) {
        if (this.mouseStillDown) {
            return this._fireStandardHandler("mouseStillDown");
        }
    },
    
    // Helper method - how long should we delay before showing hovers?
    _getHoverDelay : function () {
        return this.hoverDelay != null ? this.hoverDelay : this.form.itemHoverDelay;
    },
    
    handleTitleMove : function () {
        return this._fireStandardHandler("titleMove");
    },
    
    handleTitleOver : function () {
        // set up the hover to show a prompt for this cell if appropriate
        isc.Hover.setAction(this, this._handleTitleHover, null, this._getHoverDelay());
    
        return this._fireStandardHandler("titleOver");
    },
    handleTitleOut : function () {
        // clear the hover event set up on this item title
        this.stopHover();
        return this._fireStandardHandler("titleOut");
    },
    
    // Icon events:
    
    // On icon focus and blur, update the icon appearance (showing the over style), if showOver 
    // is true, and show the icon prompt in the window's status bar (rather than the href of 
    // the link).
    // Fire _nativeElementFocus() on the form item to handle default focus behavior
    // Note that Safari doesn't fully support focus/blur on icons - see comments in 
    // getIconHTML() for further details
    _iconFocus : function (id, element) {        
        var icon = this._getIcon(id);
        if (icon != null) {
            
            var prompt = (icon.prompt != null ? icon.prompt : this.iconPrompt)    
            window.status=prompt;
            
            if (this._iconShouldShowFocused(icon)) {
                this._setIconImgState(icon, false, true);
            }
            else if (this._iconShouldShowOver(icon)) this._setIconImgState(icon, true);
        }
        return this._nativeElementFocus(element,this);
    },
    
    _iconBlur : function (id, element) {
        var icon = this._getIcon(id);
        if (icon != null) {

            window.status="";

            // If we're showing the icon's focused state, clear it if showFocusedWithItem is false
            // If showFocusedWithItem is true, clear if this.showIconsOnFocus is false since
            // if focus goes to another element within the item, the focus styling will be
            // reapplied, and if showIconsOnFocuse is true and focus goes outside the item the
            // icon will be hidden in any case.
            var showFocused = this._iconShouldShowFocused(icon),
                showFocusedWithItem = icon.showFocusedWithItem != false,
                showOnFocus = this.showIconsOnFocus;                
            if (showFocused && (!showOnFocus || !showFocusedWithItem)) {
                this._setIconImgState(icon, false, false);
            }
            if (this._iconShouldShowOver(icon)) this._setIconImgState(icon, false, false);
        }        
        return this._nativeElementBlur(element,this);        
    },
    
    
    
    // On icon mouseOver / mouseOut, 
    // - update the icon's appearance if showOver is true.
    // - show the prompt in a hover if there is a prompt defined for the icon
    // - update window.status to also show the prompt.
    _iconMouseOver : function (id) {
        // We use the standard icon code to write out our validation error icon - if this is
        // where the event occurred, pass that through to a separate handler.
        if (id == this.getErrorIconId()) return this._handleErrorIconMouseOver();
        var icon = this._getIcon(id);
        if (icon != null) {

            // If appropriate set the 'over' state for the icon img
            if (this._iconShouldShowOver(icon)) this._setIconImgState(icon, true);
            
            // Set up the hover action on this item:
            // Remember which icon we're over, then set hover action (will fire instantly if
            // the hover is already up)
            this._lastPromptIcon = icon;
            isc.Hover.setAction(this, this._handleIconHover, null, this._getHoverDelay());
            
            
            var prompt = (icon.prompt != null ? icon.prompt : this.iconPrompt)    
            window.status=prompt;
            return true;
        }
    },

    _iconMouseOut : function (id) {
        if (id == this.getErrorIconId()) return this._handleErrorIconMouseOut();    
        var icon = this._getIcon(id);
        if (icon != null) {
            window.status = "";
            
            if (this._iconShouldShowOver(icon)) this._setIconImgState(icon, false);        

            // Reset the hover action to show the hover for the item as a whole
            delete this._lastPromptIcon;
            isc.Hover.setAction(this, this._handleHover, null, this._getHoverDelay());
            
            return true;
        }
    },
    
    
    _iconMouseMove : isc.Class.NO_OP,
    
    //> @method	formItem._iconClick()  (I)
    // Handle a click on a form item icon.  Fires the click action defined for the icon.
	//  @group  appearance, events
    //
    //<
    _iconClick : function (id) {
        var icon = this._getIcon(id);
        if (icon == null) return;
        if (this.iconIsDisabled(icon)) return;
        if (icon.click != null) {
            // Note - can't use 'convertToMethod' on the icon object, as it has no registry of 
            // stringMethods.  Must use 'replaceWithMethod' instead.
            if (!isc.isA.Function(icon.click)) {
                isc.Func.replaceWithMethod(icon, "click", "form,item,icon");
            }
            if (icon.click(this.form, this, icon) == false) return false;
        }

        if (this.iconClick) this.iconClick(this.form, this, icon);
    },
    

    _$Enter:"Enter",
    _iconKeyPress : function (id) {
        var icon = this._getIcon(id);
        if (icon) {
            var keyName = isc.EH.getKey(),
                character = isc.EH.getKeyEventCharacter();
            if (icon.keyPress) {
                // Note - can't use 'convertToMethod' on the icon object, as it has no registry 
                // of  stringMethods.  Must use 'replaceWithMethod' instead.
                if (!isc.isA.Function(icon.keyPress)) {
                    isc.Func.replaceWithMethod(icon, "keyPress", "keyName, character,form,item,icon");
                }
                if (icon.keyPress(keyName, character, this.form, this, icon) == false) 
                    return false;
            }
            if (this.iconKeyPress) this.iconKeyPress(keyName, character, this.form, this, icon);

            // by default we always have "enter" fire the icon's click action
            if (keyName == this._$Enter) {
                if (this._iconClick(icon) == false) return false;
            }
            
        }
    },
        
    // error icon events
    _handleErrorIconMouseOver : function () {

    },
    
    _handleErrorIconMouseOut : function () {

    },
    
    
    // Hover events ---------------------------------------------------------------------------
        
    //_handleHover / _handleTitleHover fired when the user hovers over this item/title.
    //
    // Fire any custom hover-handler for the item.
    // If the custom handler does not return false, show a hover canvas for this item.
    // contents for the hover derived from item.itemHoverHTML() or form.itemHoverHTML()
    // (default implementation at the form level shows item prompt)
    _handleHover : function (event) {
        // Note itemHover / titleHover registered as stringMethods taking form/item as params
        if (this.itemHover && this.itemHover(this, this.form) == false) return false;

        var HTML;
        if (this.itemHoverHTML) HTML = this.itemHoverHTML();
        else HTML = this.form.itemHoverHTML(this);
        
        this.form._showItemHover(this, HTML);
    },
    
    _handleTitleHover : function (event) {
        //!DONTCOMBINE
        if (this.titleHover && this.titleHover(this, this.form) == false) return false;

        var HTML;
        if (this.titleHoverHTML) HTML = this.titleHoverHTML();
        else HTML = this.form.titleHoverHTML(this);

        this.form._showItemHover(this, HTML);        
    },

    // _handleIconHover: helper method fired when the user hovers over an icon.  Only fired if
    // the hovered-over icon has a prompt to show.
    // Call 'itemHover()' if defined *(allows the user to suppress the prompt), and then show
    // the icon prompt.
    _handleIconHover : function () {
        // note: we don't want to show the icon prompt if the item level 'itemHover' method 
        // returns false.
        
        //!DONTCOMBINE
        if (this.itemHover && this.itemHover(this, this.form) == false) return false;
        var icon = this._lastPromptIcon,
            prompt = this.getIconPrompt(icon);
        if (prompt && !isc.is.emptyString(prompt)) 
            isc.Hover.show(prompt, this.form._getHoverProperties(this));
        // If there's no prompt, the standard item hover to show the appropriate HTML
        // (will get shown synchronously since the hover's already up)
        else isc.Hover.setAction(this, this._handleHover, null, this._getHoverDelay());        
    },
    
    //>@method  formItem.itemHover()     (A)
    //  Optional stringMethod to fire when the user hovers over this item.
    //  Return false to suppress default behavior of showing a hover canvas containing the
    //  HTML returned by <code>formItem.itemHoverHTML()</code> / 
    //  <code>form.itemHoverHTML()</code>.
    //
    //  @param  form (DynamicForm)  This items form
    //  @param  item (FormItem)     Pointer to this item
    //  @group Hovers
    //  @see FormItem.titleHover()
    //  @see FormItem.itemHoverHTML()
    //  @visibility external
    //<
    
    //>@method  formItem.titleHover()     (A)
    //  Optional stringMethod to fire when the user hovers over this item's title.
    //  Return false to suppress default behavior of showing a hover canvas containing the
    //  HTML returned by <code>formItem.titleHoverHTML()</code> / 
    //  <code>form.titleHoverHTML()</code>.
    //
    //  @param  form (DynamicForm)  This items form
    //  @param  item (FormItem)     Pointer to this item
    //  @group Hovers
    //  @see FormItem.itemHover()
    //  @see FormItem.titleHoverHTML()
    //  @visibility external    
    //<
    
    
    //>@method  formItem.titleHoverHTML()     (A)
    //  If defined, this method should return the HTML to display in a hover canvas when the 
    //  user holds the mousepointer over this item's title.  Return null to suppress the hover 
    //  canvas altogether.<br>
    //  If not defined, <code>dynamicForm.titleHoverHTML()</code> will be evaluated to 
    //  determine hover content instead.
    //
    //  @group Hovers
    //  @see FormItem.prompt
    //  @see FormItem.titleHover()
    //  @see FormItem.itemHoverHTML()
    //  @visibility external    
    //<

    //>@method  formItem.itemHoverHTML()     (A)
    //  If defined, this method should return the HTML to display in a hover canvas when the 
    //  user holds the mousepointer over this item.  Return null to suppress the hover 
    //  canvas altogether.<br>
    //  If not defined, <code>dynamicForm.itemHoverHTML()</code> will be evaluated to 
    //  determine hover content instead.
    //
    //  @group Hovers
    //  @see FormItem.prompt
    //  @see FormItem.itemHover()
    //  @see FormItem.titleHoverHTML()
    //  @example itemHoverHTML
    //  @visibility external    
    //<

    
    
    getGlobalTabIndex : function () {
        if (this.globalTabIndex == null) {
            if (this.tabIndex == -1) this.globalTabIndex = -1;
            else {
                var formIndex = this.form.getTabIndex(),
                    localTabIndex = this.getTabIndex();                
                if (formIndex == -1) return -1;
                return (formIndex + localTabIndex);
            }
        }
        return this.globalTabIndex;
    },
    
    // getTabIndex() - returns the local tabIndex for this item.
    // Probably only to be used by internally
    getTabIndex : function () {
        if (this.tabIndex != null) return this.tabIndex;
        if (this.globalTabIndex || !this._canFocus()) return null;
        if (this._localTabIndex == null) {
            this.form._assignTabIndices();
        }
        return this._localTabIndex;
    },
    
    // setTabIndex() / setGlobalTabIndex()
    // force the form to redraw so the HTML is updated to reflect the changes in tabIndex
    setGlobalTabIndex : function (index) {
        this.globalTabIndex = index;
        this._setElementTabIndex(index);

    },
    setTabIndex : function (tabIndex) {
        this.globalTabIndex = null;
        this.tabIndex = tabIndex;
        
        this._setElementTabIndex(tabIndex);
    },

    // _getElementTabIndex() returns the tab index to actually write into the element.
    // This may differ from the result of this.getGlobalTabIndex() to allow (for example) 
    // taking form items out of the page's tab order without forgetting their global tab index.
    
    _getElementTabIndex : function (ignoreDisabled) {
        //!DONTCOMBINE
        if (!ignoreDisabled && this.isDisabled()) return -1;
        if (this._elementTabIndex != null) return this._elementTabIndex;
        return this.getGlobalTabIndex();
    },
    
    // _setElementTabIndex() - update the tab index written into the HTML element for this 
    // form item.
    
    _setElementTabIndex : function (tabIndex) {
    
        // remember the tabIndex passed in. 
        this._elementTabIndex = tabIndex;

        // If we can't accept focus, or aren't drawn/visible just bail
        if (!this._canFocus() || !this.isVisible() || !this.isDrawn()) return;
        
        // Default implementation will set the tabIndex on whatever element is returned by
        // this.getFocusElement().
        // Note that this may not work for all items - for example items with multiple elements
        // in the DOM.
        if (this.getFocusElement() != null) {
            isc.FormItem.setElementTabIndex(this.getFocusElement(), tabIndex);
            
            // Also update any form item icons.
            // Note that we are only doing this if we have an element, because if we do not
            // the redraw (below) is required in any case, and will cause the icons' tab index
            // to be updated.
            this._updateIconTabIndices();
            
        } else {
            // Make the default implementation for form items with no 'focusElement' to redraw
            // the form - this should reset the innerHTML of the element to whatever is 
            // required for an updated tabIndex in most cases.
            
            this.redraw("set tab index");
        }
    }, 

    // Our element tab index is typically derived based on a local offset from the form's tab-index
    // This notification is fired when the form's tabIndex changes, and allows us to
    // update our element tab index if appropriate
    updateTabIndex : function () {
        if (!this._canFocus() || !this.isVisible() || !this.isDrawn() || this.isDisabled()) return;
        
        var gti = this.getGlobalTabIndex();
        if (this._elementTabIndex != gti) this._setElementTabIndex(gti);
    },
    
    // returns the tab index for some icon
    _getIconTabIndex : function (icon) {
        // We want the developer to be able to specify tabIndex -1 on icons
        
        if (icon.tabIndex == -1 || this.iconIsDisabled(icon)) return -1;
        // Pass in the param to avoid returning -1 if the item is disabled - this allows us to
        // leave 'neverDisable' icons in the tab-order for the page.
        return this._getElementTabIndex(true);
    },
    
    // Helper method to iterate through this item's icons, and update all their tab indices.
    _updateIconTabIndices : function () {
        var icons = [];
        icons.addList(this.icons);
        if (this.showPickerIcon) icons.add(this.getPickerIcon());
        
        for (var i = 0; i < icons.length; i++) {     
            var icon = icons[i];
            if (!icon || icon.imgOnly) continue;
            var iconElement = this._getIconLinkElement(icon);
            
            if (iconElement != null) {
                isc.FormItem.setElementTabIndex(iconElement, this._getIconTabIndex(icon));
            }
            
        }
    },
    
    //> @method formItem.setDisabled()    (A)
    //  Set this item to be enabled or disabled at runtime. 
    //  @param  disabled (boolean)   true if this item should be disabled
    //  @see    attr:FormItem.disabled
    // @group enable
    //  @visibility external
    //<
    setDisabled : function (disabled) {
        var wasDisabled = this.isDisabled();
        this.disabled = disabled;
        var isDisabled = this.isDisabled();
        if (wasDisabled != isDisabled) this.updateDisabled();
    },
    
    //> @method formItem.setShowDisabled()
    // Setter method for +link{formItem.showDisabled}
    // @param showDisabled (boolean) new showDisabled setting
    // @visibility external;
    //<
    setShowDisabled : function (showDisabled) {
        this.showDisabled = showDisabled;
        this.updateDisabled();
    },
    
    // updateDisabled - helper method to update the form item to reflect it's enabled/disabled
    // state
    
    updateDisabled : function () {
        var disabled = this.isDisabled();
        this._setElementEnabled(!disabled);
        this._setIconsEnabled();
        // update the valueIcon if we have one
        this._updateValueIcon();
        // UpdateState is a catch-all method that updates the css classes applied to our elements
        // to reflect the 'disabled' versions
        
        if (this.showDisabled) this.updateState();

    },
    
    // deprecated corollary to setEnabled()
    setEnabled : function (enabled) {
        return this.setDisabled(!enabled);
    },
    
    //> @method formItem.isDisabled()    (A)
    //  Is this item disabled?
    //  @return disabled (boolean)   true if this item is be disabled
    //  @see    attr:FormItem.disabled
    // @group enable
    //  @visibility external
    //<
    isDisabled : function () {
        
        var disabled = this.disabled
        // For members of containerItems, inherit the disabled-ness of the parent item
        if (!disabled) {
            if (this.parentItem != null) disabled = this.parentItem.isDisabled();
            else {
                disabled = this.form.isDisabled();
        
                // Allow disabled-ness to be inherited from either the form or the containerWidget
                if (!disabled && this.containerWidget != this.form) disabled = this.containerWidget.isDisabled();
            }
        }
        return disabled;
        
    },
    
    //>@method formItem.enable()
    // Set this item to be enabled at runtime.
    // @see attr:FormItem.disabled
    // @group enable
    // @visibility external
    //<
    enable : function () {
        this.setDisabled(false);
    },    
    
    //>@method formItem.disable()
    // Set this item to be disabled at runtime.
    // @see attr:FormItem.disabled
    // @group enable
    // @visibility external
    //<
    disable : function () {
        this.setDisabled(true);
    },    
    
    // _setElementEnabled()
    // Actually update the HTML to mark the data element as enabled / disabled
    // (Overriden where appropriate by subclasses)
    
    _setElementEnabled : function (enabled) {
        if (this.hasDataElement()) {     
            var element = this.getDataElement();
            if (element) {
                element.disabled = !enabled;
                element.tabIndex = this._getElementTabIndex();
                // If we use an 'eventMask' clear it out if we're being enabled, or write it
                // over the native form item element if we're being disabled.
                if (this.useDisabledEventMask()) {
                    var maskElement = this._getEventMaskElement();
                    if (maskElement && (!maskElement.getAttribute || 
                        maskElement.getAttribute("isDisabledEventMask") != "true"))
                    {
                        maskElement = null;
                    }
                            
                    if (enabled && maskElement) {
                        isc.Element.clear(maskElement);
                    } else if (!enabled && !maskElement) {
                        isc.Element.insertAdjacentHTML(element, "beforeBegin", this._getEventMaskHTML());
                    }
                }
            }
        } else if (this._canFocus()) {
            var element = this.getFocusElement();
            if (element) element.tabIndex = this._getElementTabIndex();
        }
    },
    // _setIconsEnabled()
    // Update all icons' html to match a new enabled state
    _setIconsEnabled : function () {
        if (this.showPickerIcon) {
            var pickerIcon = this.getPickerIcon();
            this.setIconEnabled(pickerIcon);
        }
        if (!this.icons || this.icons.length < 1) return;
        for (var i = 0; i< this.icons.length; i++) {
            this.setIconEnabled(this.icons[i]);
        }
    },
    
    iconIsDisabled : function (icon) {
        icon = this._getIcon(icon);
        if (!icon) return;
        // if we're in a disabled container that trumps 'neverDisable'
        if (this.containerWidget && this.containerWidget.isDisabled()) return true;
        if (icon.neverDisable) return false;
        return this.isDisabled();
    },
    
    //> @method formItem._canFocus()    ()
    //  Return true if the form item can accept keyboard focus
    //  @group  visibility
    //  @return (boolean)   true if the form item is visible
    //<
    
    _canFocus : function () {
        // If there's an explicit 'canFocus' property, respect it.
        if (this.canFocus != null) return this.canFocus;
        return this.hasDataElement();
    },
    
    
	    
    //>	@method formItem.focusInItem()
    //			Move the keyboard focus into this item's focusable element
    //		@group eventHandling, focus    
    // @visibility external
    //<
    focusInItem : function () {
        // Verify that the form is visible (Script errors occur if you attempt to focus
        // on a hidden item)
        var canFocus = this.isVisible() && this._canFocus() && !this.isDisabled(),


            element = canFocus ? this.getFocusElement() : null;            
        if (!canFocus || !element) {
            // If we are a child element of a containerItem, and we're not focusable, put focus
            // on the parent instead.
            // Catches cases where (for example) the parent's items array has changed or one option 
            // has been disabled on redraw
            if (this.parentItem) this.parentItem.focusInItem();
            // This method will return null if we don't have an HTML element, or the
            // element is currently not drawn into the DOM
            return;
        }

        if (element.focus) {
            var activeElement = this.getActiveElement();
            // In IE - avoid calling 'focus' on an element that already has native focus
            
            if (!isc.Browser.isIE || activeElement != element) {
                //>DEBUG
                this.logInfo("about to call element.focus() " + isc.EH._getActiveElementText() +
                             (this.logIsDebugEnabled("traceFocus") ? this.getStackTrace() : ""), 
                             "nativeFocus");
                //<DEBUG

                // Fire a notification function centrally so we know a programmatic focus
                // change has been triggered
                isc.FormItem._aboutToFireNativeElementFocus(this);
                isc.EventHandler._unconfirmedFocus = this;
                element.focus();

                //if (isc.Browser.isIE) {
                //    this.logDebug("called element focus" + isc.EH._getActiveElementText(),
                //                  "nativeFocus");
                //}
            } else {
                this.logInfo("element already focused, not focus()ing", "nativeFocus");
            }
            
            
            
            if (isc.Browser.isIE) {
                isc.EH._lastFocusTarget = this;
                this._currentFocusElement = element;
            }
        } else {
            //>DEBUG
            this.logInfo("can't call element focus, no element", "nativeFocus");
            //<DEBUG
        }

        var selectOnFocus = this.selectOnFocus;
        if (selectOnFocus == null && this.form) selectOnFocus = this.form.selectOnFocus;
        if (selectOnFocus && element.select) element.select();
    },
    
    //>	@method formItem.blurItem()
    //			Takes focus from this form item's focusable element.
    //		@group eventHandling, focus   
    // @visibility external 
    //<
    blurItem : function () {        
        if (!this.isVisible() || !(this.hasFocus || isc.EH._lastFocusTarget == this)) return;
        
        // Call 'blur()' on whatever element has been recorded as having native focus.
        // We record the current focus element in '_nativeElementFocus()'
         
        var element = this._getCurrentFocusElement();

        if (element && element.blur) {
            //>DEBUG
            this.logInfo("about to call element blur" + isc.EH._getActiveElementText() +
                         (this.logIsDebugEnabled("traceBlur") ? this.getStackTrace() : ""), 
                         "nativeFocus");                         
            //<DEBUG
            isc.EH._unconfirmedBlur = this;            
            element.blur();

            //if (isc.Browser.isIE) {
            //    this.logDebug("called element blur, active element now: " +
            //              document.activeElement.id, "nativeFocus");
            //}
        } else {
            //>DEBUG
            this.logInfo("can't call element blur, no element", "nativeFocus");
            //<DEBUG
            // Note: if this item was marked as having focus, _getCurrentFocusElement()
            // ensures that flag gets cleared
        }
        
        
	},
    
    // focusInIcon()
    // - explicitly puts focus into an icon
    focusInIcon : function (icon) {
        if (isc.isA.String(icon)) icon = this._getIcon(icon);
        if (icon == null || !this.icons || !this.icons.contains(icon) || icon.imgOnly) return;
        var element = this._getIconLinkElement(icon);     
        if (element != null) element.focus();   
    },
    
    // blurIcon()
    // - take focus from an icon
    blurIcon : function (icon) {
        if (isc.isA.String(icon)) icon = this._getIcon(icon);    
        if (icon == null || !this.icons || !this.icons.contains(icon) || icon.imgOnly) return;
        var element = this._getIconLinkElement(icon);

        // Note - we are checking for the icon being present and drawn, but not whether it
        // actually has focus in this method - it is relying on the fact that this should only
        // be called if the passed in icon has focus.
        if (element != null) element.blur();
    },
    
    // _nativeElementFocus
    // Internal method fired when an element of this form item recieves focus.
    // (Fired from focus on the data-element, or icons for most form item types)
    // Sets up formItem.hasFocus, and remembers which native element has focus, before firing
    // Form.elementFocus() to handle bubbling the focus event through the Form item hierachy.
    
    _nativeElementFocus : function (element, itemID) {
        isc.EH._setThread("IFCS");
        if (isc.EH._unconfirmedFocus == this) delete isc.EH._unconfirmedFocus
        isc.EH._logFocus(this, true);
        
        
        if (isc.Browser.isMoz && !this.isVisible()) {
            this.logWarn("calling element.blur() to correct focus in hidden item: " + this, 
                         "nativeFocus");
            element.blur();
            return;
        }

        // set this.hasFocus:
        this.hasFocus = true;
        
        // remember which element got focus:
        this._currentFocusElement = element;
        
        var result = this.form.elementFocus(element, itemID);
        isc.EH._clearThread();

        return result;
    },
    
    _nativeElementBlur : function (element, itemID) {
        isc.EH._setThread("IBLR");
        if (isc.EH._unconfirmedBlur == this) delete isc.EH._unconfirmedBlur

        // If we're pending an update, and we've lost focus, update now 
        if (this._pendingUpdate != null) {
            isc.Timer.clearTimeout(this._pendingUpdate);
            this._delayedUpdate();
        }

        isc.EH._logFocus(this);      
        this.hasFocus = false;
        delete this._currentFocusElement;
        
        var result = this.form.elementBlur(element, itemID);
        isc.EH._clearThread();
        return result;
    },

	//>	@method	formItem.elementFocus()
	// Handle a focus event from an element
    // @param suppressHandlers (boolean) If passed, don't fire any developer-visible focus 
    //                                  handler functions.
	//		@group	event handling
	//<
    // Note: currently our onfocus handler will call 'elementFocus' at the form level, which
    // will then 
    // - mark "hasFocus" as true on this item
    // - call this method.
    // We may want to shift the 'hasFocus' into this file to make it clearer when we get rid of
    // the 'standalone' behavior.
    
	elementFocus : function (suppressHandlers) {  
		// if the item specifies a prompt, show it in the status bar
        
		if (this.prompt) this.form.showPrompt(this.prompt);
        
        // If 'showIconsOnFocus' is set, show the icons
        if (this.showIconsOnFocus && this.showIcons) {
            this.showAllIcons(true);
        } else {
            // if the icons are already visible update their appearance to show "Focused" image
            if (this.icons) this.updateIconsForFocus(this.icons, true);
        }
        
        if (this.showFocusedPickerIcon && this.showPickerIcon) {
            var iconDef = this.getPickerIcon();
            if (iconDef) this.updateIconsForFocus(iconDef, true);
        }
        
        // Update the className of our various bits of HTML to show focused state
        if (this.showFocused) this.updateState();
        // If we're showing a valueIcon, put it into 'over' state if necessary
        
        if (this.showValueIconFocused && this.showValueIconOver && this._iconState == null) {
            this._iconState = this._$Over;
            this._updateValueIcon();
        }
        
        if (suppressHandlers) return;
		
        // If necessary fire this.editorEnter
        this.handleEditorEnter()
        
		// if the item has a "focus" handler
		if (this.focus) {
			// CALLBACK API:  available variables:  "form,item"
			// Convert a string callback to a function
            this.convertToMethod("focus");
			return this.focus(this.form, this);
		}
		
		return true;
	},
    
    updateIconsForFocus : function (icons, hasFocus) {
        
        if (icons == null) return;
        // force hasFocus to a boolean
        hasFocus = !!hasFocus;
        if (!isc.isAn.Array(icons)) icons = [icons];
        for (var i = 0 ; i < icons.length; i++) {
            if (this._iconShouldShowFocused(icons[i], true)) {
                var img = this._getIconImgElement(icons[i]);
                if (img != null) { 
                    isc.Canvas._setImageURL(img,
                                    this.getIconURL(icons[i], false, null, hasFocus));
                }
            }
        }
    },
	
    //>	@method	formItem.elementBlur()
	// Handle a blur event from an element
	//		@group	event handling
	//<
	elementBlur : function () {  
		// if the item specified a prompt, clear it from the status bar since it no longer 
        // applies
		if (this.prompt) this.form.clearPrompt();
        
        // If we're showing icons on focus, we should hide them on blur.
        
        if (this.showIconsOnFocus && this.showIcons) { 

            //this.logWarn("setting icon hide timer") 
            if (this._hideAllIconsEvent == null) {
                this._hideAllIconsEvent = this.delayCall("hideAllIcons", [], 0);
            }
        // If we're hiding icons on keypress, and not showing on focus, we want to have them
        // re-show when the element gets a blur event.                
        } else if (this.hideIconsOnKeypress && this.showIcons) {
            this.showAllIcons();

        // If we just hid, or showed the icons, no need to update state for blur - otherwise
        // we may need to clear "focused" state
        } else {
            if (this.icons) this.updateIconsForFocus(this.icons, false);
        }
        
        if (this.showFocusedPickerIcon && this.showPickerIcon) {
            var iconDef = this.getPickerIcon();
            if (iconDef) this.updateIconsForFocus(iconDef, false);
        }        
        
        // Update the className of our various bits of HTML to show focused state 
        if (this.showFocused) {
            this.updateState();
        }
        
        // If we're showing a valueIcon, we use the "Over" state to indicate focus - 
        // clear this if appropriate
        
        if (this._iconState == this._$Over) {
            this._iconState = null
            this._updateValueIcon();
        }
				

        // if there's a pending autoCompletion, accept it now
        // No need for 'focusAtEnd()' - the element will no longer have focus 
        this.acceptCompletion();
        
        // If necessary fire this.editorExit();
        this.handleEditorExit();

		// if the item has a "blur" handler
		if (this.blur) {
			// CALLBACK API:  available variables:  "form,item"
			// Convert a string callback to a function
            this.convertToMethod("blur");
			return this.blur(this.form, this);
		}
		
		return true;
	},
    
    // _moveFocusWithinItem() - helper method to simulate a tab / shift tab while the
    // user is focussed in this form item.
    // Shifts focus to the next focusable element (may be an icon, or for containerItems a
    // sub element)
    // Returns true if focus was succesfully shifted within this item
    
    _moveFocusWithinItem : function (forward) {
        var items = this.items,
            icons = this.icons;
        // catch the common case where we have only one natively focusable element
        if ((items == null || items.length == 0) && (icons == null || icons.length == 0)) {
            return false;
        }
            
        var iconIndex = this.getFocusIconIndex(),
            itemIndex;

        if (iconIndex == null) {
            var targetItem = isc.EventHandler.lastEvent.keyTarget;
            if (targetItem == this) itemIndex = 0;
            else if (items) {
                itemIndex = items.indexOf(targetItem);
            }
        }
        
        // If we don't have focus, no-op
        if ((itemIndex == null || itemIndex == -1) && iconIndex == null) {
            return false;
        }

        // Now determine where focus should go, based on whether this is a tab or shift
    	// tab, and where the event occurred:
        if (forward) {

        	// We're moving forwards, so start with finding the next sub-item, if there 
        	// is one
            if (itemIndex != null && items != null) {
                while (itemIndex < items.length-1) {
                    itemIndex += 1
                    var focusItem = items[itemIndex];
                        
                    if (focusItem._canFocus()) {
                    	// Found another focusable item after the one that had focus
                        focusItem.focusInItem();
                        // return true to indicate that we shifted the focus
                        return true;
                    }
                }
            }

        	// at this point we know that focus will have to go the next focusable
        	// icon if there is one.
            if (iconIndex == null) iconIndex = -1;

            if (this.canTabToIcons != false && this.showIcons && icons != null) {
       
                while (iconIndex < icons.length -1) {
                    iconIndex += 1;
                    var icon = icons[iconIndex];
                    if (this._shouldShowIcon(icon) && !icon.imgOnly && icon.tabIndex != -1) {
                    	// Found a visible icon after the last focus element - focus
                    	// in it and return.
                        this.focusInIcon(icon);
                        return true;
                    }
                }
            }

        	// If we are here, the user has hit tab on the last focusable sub item or 
        	// icon in this form item.
            return false;

        } else {
        	// No need to check for this.icons == null or this.showIcons, as iconIndex
        	// will only be set if we are currently focussed on an icon
        	// We do need to check for 'canTabToIcons', since we are explicitly putting
        	// focus onto the form item icons, rather than relying on their tabindex
            if (this.canTabToIcons != false && iconIndex != null) {
                while (iconIndex > 0) {
                    iconIndex -= 1;
                	// This icon should get focus - focus on it and return.
                    var icon = icons[iconIndex]
                    if (this._shouldShowIcon(icon) && !this.imgOnly && icon.tabIndex != -1) {
                        this.focusInIcon(icon);
                        return true;
                    }
                }
            }
            
        	// If itemIndex is null, the event was on the first visible icon - start
        	// checking the last visible sub item
            if (itemIndex == null) 
                itemIndex = items != null ? items.length : 1;
                
        	// If we got here we have a valid itemIndex (may be 1 higher than the 
        	// number of subItems).
            while (itemIndex > 0) {
                var focusItem;
                itemIndex -= 1

                if (items == null) {
                    focusItem = this;
                } else {
                    focusItem = items[itemIndex]
                }
                
                if (focusItem._canFocus()) {
                	// This sub-item (or this item, if we have no sub items) should get
                	// focus - focus on it and return false to cancel the event.
                    focusItem.focusInItem();
                    return true;
                }
            }
            
            return false
        }
    },

    // Helper method to determine the index of the icon with focus (or null if no icon has 
    // focus) based on the focus'd HTML element 
    
    getFocusIconIndex : function () {
        var currentFocusElement = this._getCurrentFocusElement();
        if (currentFocusElement == null || this.icons == null) return null;
        for (var i = 0; i < this.icons.length; i++) {
            if (this._getIconLinkElement(this.icons[i]) == currentFocusElement) return i;
        }
        return null;
    },

    _$img:"img",
    _allowNativeTextSelection : function (event, itemInfo) {
        if (itemInfo.overTitle) return;
        // Suppress native dragging of icons
        if (itemInfo.overIcon) return false;
        // Note that imgOnly icons and valueIcons won't set the "overIcon" attribute.
        // Explicitly check for the user attempting to select or drag an IMG tag
        if (event == null) event = isc.EH.lastEvent;
        if (event.nativeTarget && (event.nativeTarget.tagName.toLowerCase() == this._$img))
            return false;
        
        return this.canSelectText != false;
    },
    
    
    handleEditorExit : function () {
        if (!this._hasEditorFocus) return;
        this._hasEditorFocus = null;
        if (this.editorExit) this.editorExit(this.form, this, this.getValue());
    },
    
    handleEditorEnter : function () {
        if (this._hasEditorFocus) return;
        this._hasEditorFocus = true;

        if (this.editorEnter) this.editorEnter(this.form, this, this.getValue());
    },

    
    
    _setupFocusCheck : function () {
        var formItem = this;
        this._nativeFocusCheckEvent = isc.Page.setEvent(
                isc.EH.MOUSE_UP, function () {
                    if (!formItem.destroyed) formItem._checkNativeFocus();
                });
        
    },
    _checkNativeFocus : function () {
        // clear out the event so we don't fire on future clicks
        isc.Page.clearEvent(isc.EH.MOUSE_UP, this._nativeFocusCheckEvent);
        delete this._nativeFocusCheckEvent;
        
        if (this.getActiveElement() == document.body) {
            //this.logWarn("Catching native focus issue");
            this.focusInItem()
        }
    },
    
    // _willHandleInput / _handleInput
    
    _willHandleInput : function () {
        // Only returns true for supported browsers, and for items where we explicitly write out
        // an oninput handler.
        return false;
    },
    _handleInput : function () {   
        if (this.changeOnKeypress) this.updateValue();
    },
    
    // Native oncut / onpaste handlers for IE
    _nativeCutPaste : function (element, item) {
    
        if (this.changeOnKeypress) this._queueForUpdate();
    },

    
    

    // This is called by EventHandler.bubbleEvent - we make use of it to give the special
    // form item specific parameters to the keyPress string method, and to call 'itemKeyPress'
    // on the form.
    _$Tab:"Tab",
    handleKeyPress : function (event, eventInfo) {
        
        // if we don't have a form - we've presumably been removed from our form via a
        // 'setItems()' call since the native keyPress event
        
        if (!this.form) return;
        
        var targetInfo = this.form._getEventTargetItemInfo(event);

        // Fire iconKeyPress if approrpriate
        if (targetInfo.overIcon) {
            if (this._iconKeyPress(targetInfo.overIcon) == false) return false;
            
        // Only update value if focus was on the item itself (not on an icon)
        // Similarly only hideIconsOnKeypress if we were not focussed on an icon
        } else {
    
            // If we're changing on every keypress, set this up to happen asynchronously so
            // the new value is available
            
            if (!this._willHandleInput() && this.changeOnKeypress) this._queueForUpdate();
    
            // If hideIconsOnKeypress is true, we want to hide all the icons (gives the user more
            // space to type).
            // Only do this if this is not the Tab key (in which case the user is just navigating 
            // through the field), and the user is not currently focused on an icon's link element.
            
            var keyName = event.keyName;
            if (this.hideIconsOnKeypress && !this._allIconsHidden && keyName != this._$Tab) {
                this.hideAllIcons();
            }
        }
        
        // Fire this.keyPress and this.form.itemKeyPress
        return this._fireKeyPressHandlers(this,this.form,keyName,event.characterValue);
    },
    
    // _fireKeyPressHandlers - will fire item.keyPress and form.itemKeypress
    _fireKeyPressHandlers : function (item, form, keyName, characterValue) {
        if (this.keyPress != null && this.keyPress(item, form, keyName, characterValue) == false) {
            return false;
        }
        
        // it's possible for the keyPress handler to not return false, but to destroy the form
        // - for example an implementation that uses arrow_up/down to move the inline editor in
        // a ListGrid.
        if (!this.form) return false;

        // itemKeyPress is a method fired on the form when an item recieves a keypress.
        // Differs from "keyPress" on the form in that:
        // - the event is guaranteed to have come from a keypress in an item (not just a
        //   keypress on the form itself)
        // - it tells the form which item generated the event.
        // - itemKeyPress will not bubble up from the form to parent widgets as we're 
        //   calling it directly.
        
        // Don't fire itemKeypress directly from a sub item of a container item. The Container
        // is the logical form item as far as the form is concerned, and the developer can
        // get back to the sub item via event.keyTarget anyway, so wait for the keyPress to
        // bubble to the container and have that fire itemKeyPress at the form level.
        
        if (this.parentItem == null && this.form.itemKeyPress != null) {
            return this.form.itemKeyPress(item , keyName , characterValue);
        }
    },
    
    // If we're firing change on every keypress, we actually do this asynchronously on a timer
    // so that the value is available in the form item when change fires.
    
    _$delayedUpdate:"_delayedUpdate",
    _queueForUpdate : function () {
        if (this._pendingUpdate != null) {
            isc.Timer.clearTimeout(this._pendingUpdate);
            this._delayedUpdate();
        }
        // If we're changing on keypress, remember the current insertion point, so that if
        // the change handler fires and returns FALSE, we can reset the cursor insertion point.
        
        if (this.maintainSelectionOnTransform && 
            (this._getAutoCompleteSetting() != this._$smart)) 
        {
            this._rememberPreChangeSelection();
        }
        
        this._pendingUpdate = isc.Timer.setTimeout({target:this, methodName:this._$delayedUpdate}, 
                                                   0);
    },
    _delayedUpdate : function () {
        delete this._pendingUpdate;
        this.updateValue();
        this._clearPreChangeSelection();
    },    
    
    // Helper methods for resetting the selection if a change handler triggered by a keyPress
    // returns false.
    _rememberPreChangeSelection : function () {
        // This should never happen - but if it does, just return
        if (this._preChangeStart != null) return;
        var preChangeRange = this.getSelectionRange(true);
        if (preChangeRange) {
            this._preChangeStart = preChangeRange[0];
            this._preChangeEnd = preChangeRange[1];
        }
    },
    
    _revertToPreChangeSelection : function () {    
        // No op if this change didn't come from a keypress
        if (this._preChangeStart == null) return;
        this.setSelectionRange(this._preChangeStart, this._preChangeEnd);
    },
    _clearPreChangeSelection : function () {
        delete this._preChangeStart;
        delete this._preChangeEnd;
    },

    
    // HandleKeyDown overridden to mark the item dirty.
    // Also calls formItem.keyDown with appropriate parameters
    handleKeyDown : function (event, eventInfo) {

        // Mark the value as dirty if appropriate
        if (this.dirtyOnKeyDown) this._markValueAsDirty();
        
        var item = this, 
            form = this.form, 
            keyName = event.keyName;
        
        // fire keyDown stringMethod
        if (this.keyDown != null && this.keyDown(item, form, keyName) == false) return false
	},

	//>	@method	formItem._itemValueIsDirty()	(IA)
	//      Is this form item marked as having a dirty value?
	//
    //      @return (boolean)   true if the value is marked as being dirty via the _valueIsDirty 
    //                          flag
	//<
    // Return this value from a method to allow overriding by container items
    _itemValueIsDirty : function () {
        return this._valueIsDirty == true;
    },
    
    _markValueAsDirty : function () {
        this._valueIsDirty = true;
    },
    
    _markValueAsNotDirty : function () {
        this._valueIsDirty = false;
    },
    
    // handleKeyUp
    // Overridden to call this.keyUp with appropriate parameters.d
    handleKeyUp : function (event, eventInfo) {
        // if we don't have a form - we've presumably been removed from our form via a
        // 'setItems()' call since the native keyUp event
        
        if (!this.form) return;

        var item = this, 
            form = this.form, 
            keyName = event.keyName;
        
        // Fire keyUp stringMethod
        if (this.keyUp != null && this.keyUp(item, form, keyName) == false) return false;
	},
    
    // Serialization
	// ----------------------------------------------------------------------------------------
    
	getSerializeableFields : function(removeFields, keepFields) {
		// form is a backref
		removeFields.addList(["form"]); 
		return this.Super("getSerializeableFields", arguments);
	},
 
    // Element coordinates
	// ----------------------------------------------------------------------------------------
    // These are needed by elements that create Canvii that float in the vicinity of the item,
    // such as the ComboBox.
    //
    
    // getLeft and getTop - return the position of the element within the parent
    // Exactly the same logic as in canvas.getCanvasLeft() / top
    getLeft : function () {
        var tableElement = this.isDrawn() ? this.getOuterElement() : null;
        if (tableElement == null) {
            var warning = "getLeft() Unable to determine position for " + 
                          (this.name == null ? "this item " : this.name) + ". ";
            if (this.isDrawn()) {
                warning += "This method is not supported by items of type " + this.getClass();
            } else {
                warning += "Position cannot be determined before the element is drawn"
            }
            warning += " - returning zero.";
            
            this.form.logWarn(warning);
            return 0;
        }
        return this._getElementLeft(tableElement);
    },
    
    // Separate out the method to get the position based on an HTML element.  This simplifies
    // overriding 'getLeft()' to look at something other than the result of this.getElement()
    // for items with no data element.
    _getElementLeft : function (element) {
        var currentNode = element.offsetParent,
            formElement = this.containerWidget.getHandle(),
            formParent = formElement.offsetParent,
            left = isc.Element.getOffsetLeft(element);
            
        // iterate up until we reach the targetElement, or the targetElement's offsetParent
        // We could also check for documentBody to avoid crashing in the case where we were 
        // passed bad params.
        while (currentNode != formElement && currentNode != formParent) {

            // Add the currentNode's offsetLeft - left w.r.t. its offsetParent
            left += isc.Element.getOffsetLeft(currentNode) 

            // Deduct the scrollLeft
            left -= (currentNode.scrollLeft || 0);
            // Add the border thickness 
            // (last offsetLeft relative to inside of border, this one relative to outside of border)
            var borderLeftWidth = (isc.Browser.isIE ? 
                                    parseInt(currentNode.currentStyle.borderLeftWidth) :
                                    parseInt(isc.Element.getComputedStyleAttribute(currentNode, 
                                                                                "borderLeftWidth")));
                                                                                
            if (isc.isA.Number(borderLeftWidth)) left += borderLeftWidth;
            
            // getOffsetLeft() will give the distance from the outside of this element's margin
            // to the parent element -- we want the distance from the inside of the margin, so
            // add the margin thickness
            var marginLeftWidth = (isc.Browser.isIE ? 
                                    parseInt(currentNode.currentStyle.marginLeft) :
                                    parseInt(isc.Element.getComputedStyleAttribute(currentNode, "marginLeft")));
            
            if (isc.isA.Number(marginLeftWidth)) left += marginLeftWidth;

            // Move up the DOM chain
            currentNode = currentNode.offsetParent;
        }

        // OffsetLeft from the last iteration was relative to the content of the offsetParent
        if (currentNode == formParent) {
            // deduct the targetElement's offsetLeft
            // No need to adjust for border / padding in this case
            left -= isc.Element.getOffsetLeft(formElement)
        }           
         
        return left;
    },
    
    _isValidIcon : function (icon) {
        return (icon != null && 
                (this.icons && this.icons.contains(icon) || 
                 this.showPickerIcon && this.getPickerIcon() == icon));
    },

    //>@method  getIconLeft()    (A)
    //  Returns the (offset) left-coordinate of an icon within its containing widget.
    //  @param  icon    (object)    icon definition
    //  @return (number)    icon left position in px
    //  @visibility external    
    //<
    getIconLeft : function (icon) {
        // default to the first icon, if possible
        if (icon == null && this.icons != null && this.icons.getLength() > 0) icon = this.icons[0];
        else  if (!this._isValidIcon(icon)) {
            this.logWarn("getIconLeft() passed invalid icon:" + isc.Log.echoAll(icon));
            return null;
        }
        var iconElement = this._getIconImgElement(icon);
        if (iconElement == null) {
            this.logWarn("getIconLeft() unable to return position of icon - " +
                         "this icon is not currently drawn into the page. Returning null");
            return null;
        }
        
        // Determine offsetLeft wrt containing widget
        return isc.Element._getLeftOffsetFromElement(iconElement, this.containerWidget.getClipHandle());
    },
    
    // Methods to get the rendered position of the form item.
    // Note that these rely on the standard nested table element format - if getInnerHTML() is
    // overridden these may need to also be overridden
    getTop : function () {
        var element = this.isDrawn() ? this.getOuterElement() : null;
        if (element == null) {
            // We will not find an element if we are not drawn into the DOM, or if we don't 
            // have a data element.
            // In either case, bail with an appropriate warning.
            var warning = "getTop() Unable to determine position for " + 
                          (this.name == null ? "this item " : this.name) + ". ";
            if (this.isDrawn()) {
                warning += "This method is not supported by items of type " + this.getClass();
            } else {
                warning += "Position cannot be determined before the element is drawn"
            }
            warning += " - returning zero.";
            
            this.form.logWarn(warning);
            return 0;                              
        }   
        var top = this._getElementTop(element);     
        return top;
    },
    
    _getElementTop : function (element) {
        var formElement = this.containerWidget.getHandle(),
            formParent = formElement.offsetParent,
            currentNode = element.offsetParent,
            top = isc.Element.getOffsetTop(element)
        
        ;

        // iterate up until we reach the targetElement, or the targetElement's offsetParent
        // We could also check for documentBody to avoid crashing in the case where we were 
        // passed bad params.
        while (currentNode != formElement && currentNode != formParent) {
        
            // Add the currentNode's offsetTop - top w.r.t. its offsetParent
            top += isc.Element.getOffsetTop(currentNode) 
            // Deduct the scroll top
            top -= (currentNode.scrollTop || 0);
            // Add the border thickness 
            // (last offsetTop relative to inside of border, this one relative to outside of border)
            
            var borderTopWidth = (isc.Browser.isMoz ? 0 :
                                  (isc.Browser.isIE ? 
                                    parseInt(currentNode.currentStyle.borderTopWidth) :
                                    parseInt(isc.Element.getComputedStyleAttribute(currentNode, 
                                                                                "borderTopWidth"))
                                  )
                                 );
                                                                                                            
            if (isc.isA.Number(borderTopWidth)) top += borderTopWidth;

            // getOffsetTop() will give the distance from the outside of this element's margin
            // to the parent element -- we want the distance from the inside of the margin, so
            // add the margin thickness
            
            var marginTopWidth = (isc.Browser.isIE ? 
                                    parseInt(currentNode.currentStyle.marginTop) :
                                    parseInt(isc.Element.getComputedStyleAttribute(currentNode, "marginTop")));
            if (isc.isA.Number(marginTopWidth)) top += marginTopWidth;

            // Move up the DOM chain
            currentNode = currentNode.offsetParent;
        }

        // OffsetTop from the last iteration was relative to the content of the offsetParent
        if (currentNode == formParent) {
            // deduct the targetElement's offsetTop
            // No need to adjust for border / padding in this case
            top -= isc.Element.getOffsetTop(formElement)
        }
        
        return top;
                      
    },
    
    //>@method  getIconTop()    (A)
    //  Returns the (offset) top-coordinate of an icon within its containing widget.
    //  @param  icon    (object)    icon definition
    //  @return (number)    icon top position in px
    //  @visibility external    
    //<
    getIconTop : function (icon) {
        // default to the first icon, if possible
        if (icon == null && this.icons != null && this.icons.getLength() > 0) icon = this.icons[0];
        else if (!this._isValidIcon(icon)) {
            this.logWarn("getIconTop() passed invalid icon:" + isc.Log.echoAll(icon));
            return null;
        }
        // Note we're interested in the position of the img rather than the actual link element
        var iconElement = this._getIconImgElement(icon);
        if (iconElement == null) {
            this.logWarn("getIconTop() unable to return position of icon - " +
                         "this icon is not currently drawn into the page. Returning null");
            return null;
        }
        
        // Determine offsetTop wrt containing widget
        return isc.Element._getTopOffsetFromElement(iconElement, this.containerWidget.getClipHandle());
    },
    
    getPageLeft : function () {
        return this.getLeft() + 
               ((this.containerWidget.getPageLeft() 
                    + this.containerWidget.getLeftMargin() 
                    + this.containerWidget.getLeftBorderSize())
                - this.containerWidget.getScrollLeft());
    },
    getPageTop : function () {
        return this.getTop() + 
                ((this.containerWidget.getPageTop() 
                    + this.containerWidget.getTopMargin() 
                    + this.containerWidget.getTopBorderSize())
                - this.containerWidget.getScrollTop());
    },

    //>@method  getIconRect()    (A)
    //  Returns the size / position of an icon with respect to the widget rendering out the
    //  form item as an array of coordinates.
    //  @param  icon    (object)    icon definition for the icon you want to determine the 
    //                              position of (defaults to first icon in this.icons).
    //
    //  @return (array)    four element array representing the Left, Top, Width, and Height of
    //                      the icon in px.
    //  @visibility external
    //<
	getIconRect : function (icon) {
        // if the icon param is empty, it will be defaulted to the first icon by each of the
        // getIcon...() methods.
        return [this.getIconLeft(icon), 
                this.getIconTop(icon), 
                this.getIconWidth(icon), 
                this.getIconHeight(icon)];
    },

    //>@method  getIconPageRect()    (A)
    //  Returns the size / position of an icon on the page as an array of coordinates.
    //  @param  icon    (object)    icon definition for the icon you want to determine the 
    //                              position of (defaults to first icon in this.icons).
    //
    //  @return (array)    four element array representing the Left, Top, Width, and Height of
    //                      the icon in px.
    //  @visibility external
    //<
    getIconPageRect : function (icon) {
        var rect = this.getIconRect(icon);
        rect[0] += this.containerWidget.getPageLeft();
        rect[1] += this.containerWidget.getPageTop();
        return rect;
    },
    
    
    // Mark the form for redraw if 'setProperties()' is called passing in
    // any properties that would effect the layout of the form.
    // Call 'updateState()' if setProperties modifies any properties that would effect the
    // styling of the form item elements
    _relayoutProperties : {
        colSpan:true,
        rowSpan:true,
        startRow:true,
        endRow:true,
        showTitle:true,
        showHint:true
    },
    _stylingProperties:{
        baseStyle:true,
        showErrorStyle:true,
        //showDisabled:true // handled by explicit setShowDisabled method
        showFocused:true,
        showErrorStyle:true,
        controlStyle:true,
        pickerIconStyle:true,
        textBoxStyle:true
    },
    _$itemCellStyle:"itemCellStyle",
    propertyChanged : function (prop, val) {
        if (this._relayoutProperties[prop]) this._requiresFormRedraw = true;
        if (this._stylingProperties[prop]) this.updateState();
        if (prop == this._$itemCellStyle && this.items) {
            for (var i = 0; i< this.items.length; i++) {
                this.items[i].updateState();
            }
        }
    },
    
    doneSettingProperties : function () {
        if (this._requiresFormRedraw) {
            var form = this.form, items = form.items;
            
            items._rowTable = null;
            form.markForRedraw();
        }
        delete this._requiresFormRedraw;
    }
    
    
});

isc.FormItem.registerStringMethods({
	//>	@method formItem.showIf() (A)
	// Expression that's evaluated to see if an item should be dynamically hidden.
    // <p>
    // <code>showIf()</code> is evaluated whenever the form draws or redraws.
    //
    // @param	item	(FormItem)    the form item itself (also available as "this")
    // @param	value   (any)         current value of the form item
    // @param	form    (DynamicForm) the managing DynamicForm instance
    // @param   values  (Object)      the current set of values for the form as a whole
    // 
    // @example formShowAndHide
    // @visibility external
	//<
    showIf : "item,value,form,values",

	//> @method formItem.defaultDynamicValue() (A)
    // Expression evaluated to determine the +link{FormItem.defaultValue} when no value is 
    // provided for this item.
    // <P>
    // If you don't need dynamic evaluation, you can just use <code>item.defaultValue</code>.
    //
    // @param	item	(FormItem)    the form item itself (also available as "this")
    // @param	form    (DynamicForm) the managing DynamicForm instance
    // @param   values  (Object)      the current set of values for the form as a whole
    // 
    // @see attr:defaultValue
    // @group formValues
    // @visibility external
    //<
    defaultDynamicValue : "item,form,values",

    //> @method formItem.focus
    // Called when this FormItem receives focus.
    // 
    // @param	form    (DynamicForm) the managing DynamicForm instance
    // @param	item	(FormItem)    the form item itself (also available as "this")
    // @group eventHandling
    // @visibility external
    //<
    focus : "form,item",

    //> @method formItem.blur
    // Called when this FormItem loses focus.
    // 
    // @param	form    (DynamicForm) the managing DynamicForm instance
    // @param	item	(FormItem)    the form item itself (also available as "this")
    // @group eventHandling
    // @visibility external
    //<
    blur : "form,item",
    
        
    
    //> @method formItem.editorEnter
    // Fired when the user enters a form item
    // @param form (DynamicForm) form managing this form item
    // @param item (FormItem) pointer to the form item being managed
    // @param value (any) current value of the form item
    // @group eventHandling
    //<
    editorEnter : "form,item,value",
    
    //> @method formItem.editorExit
    // Fired when the user leaves a form item
    // @param form (DynamicForm) form managing this form item
    // @param item (FormItem) pointer to the form item being managed
    // @param value (any) current value of the form item
    // @group eventHandling
    //<
    editorExit : "form,item,value",
 
    //> @method formItem.click
    // Called when this FormItem is clicked on.
    // <P>
    // Note: <code>click()</code> is available on StaticTextItem, BlurbItems, ButtonItem, and
    // derivatives.  Other form items (such as HiddenItem) do not support <code>click()</code>.
    //
    // @param	form    (DynamicForm) the managing DynamicForm instance
    // @param	item	(FormItem)    the form item itself (also available as "this")
    // @group eventHandling
    // @visibility external
    //<
    click : "form,item",

    //> @method formItem.doubleClick
    // Called when this FormItem is double-clicked.
    //
    // @param	form    (DynamicForm) the managing DynamicForm instance
    // @param	item	(FormItem)    the form item itself (also available as "this")
    // @group eventHandling
    // @visibility external
    //<
    doubleClick : "form,item",
    
    //> @method formItem.iconClick()
    //      StringMethod.
    //      Default action to fire when the user clicks on a form item icon. May be overridden
    //      by setting <code>click</code> on the form item icon directly.
    //  @group  formIcons
    //  @visibility external
    //  @param form (DynamicForm)   a pointer to this item's form
    //  @param  item    (FormItem)  a pointer to this form item
    //  @param  icon    (FormItemIcon)  a pointer to the icon that recieved the click event.
    //<
    // Note - developers would be more likely to set a click handler on each icon.
    iconClick : "form,item,icon",    

    //> @method formItem.iconKeyPress()
    //      StringMethod.
    //      Default action to fire when an icon has keyboard focus and the user types a key.
    //      May be overridden by setting <code>keyPress</code> on the form item icon directly.
    //  @group  formIcons
    //  @visibility external
    //  @param keyName (string) name of the key pressed
    //  @param character (character) character produced by the keypress
    //  @param form (DynamicForm)   a pointer to this item's form
    //  @param  item    (FormItem)  a pointer to this form item
    //  @param  icon    (FormItemIcon)  a pointer to the icon that recieved the click event.
    //<
    iconKeyPress : "keyName,character,form,item,icon",    

    //> @method formItem.change()
    // Called when a FormItem's value is about to change as the result of user interaction.  This
    // method fires after the user performed an action that would change the value of this field,
    // but before the element itself is changed.  
    // <P>
    // Returning false cancels the change.  Note that if what you want to do is
    // <b>transform</b> the user's input, for example, automatically change separator
    // characters to a standard separator character, you should implement
    // +link{formItem.transformInput,transformInput} rather than using a combination of
    // change() and setValue() to accomplish the same thing.  Returning false from
    // <code>change</code> is intended for rejecting input entirely, such as typing invalid
    // characters.
    // <p>
    // Note that if you ask the form for the current value in this handler, you will get the old
    // value because the change has not yet been commited.  The new value is available as a
    // parameter to this method.
    //
    // @param	form    (DynamicForm) the managing DynamicForm instance
    // @param	item	(FormItem)    the form item itself (also available as "this")
    // @param   value   (any)         The new value of the form item
    // @param   oldValue    (any)     The previous value of the form item
    //
    // @return  (boolean) In your handler, return false to cancel the change, true to allow the change
    // @group eventHandling
    // @visibility external
    // @example fieldEnableDisable
    //<
	change : "form,item,value,oldValue",
    
    //> @method formItem.changed()
    // Called when a FormItem's value has been changed as the result of user interaction.  This
    // method fires after the newly specified value has been stored.
    // @param	form    (DynamicForm) the managing DynamicForm instance
    // @param	item	(FormItem)    the form item itself (also available as "this")
    // @param   value   (any)         The current value (after the change).
    // @group eventHandling
    // @visibility external
    //<
    changed : "form,item,value",
	


    //> @method formItem.transformInput()
    // Called when a FormItem's value is about to change as the result of user interaction.  This
    // method fires after the user performed an action that would change the value of this field,
    // and allows the developer to modify / reformat the value before it gets validated / saved.
    // Fires before +link{formItem.change}.
    // <P>
    // Return the reformatted value.
    //
    // @param	form    (DynamicForm) the managing DynamicForm instance
    // @param	item	(FormItem)    the form item itself (also available as "this")
    // @param   value   (any)         The new value of the form item
    // @param   oldValue    (any)     The previous (current) value of the form item
    //
    // @return  (any) The desired new value for the form item
    // @visibility external
    //<
    transformInput : "form,item,value,oldValue",
    
    
    cellClick : "form,item",
    cellDoubleClick : "form,item",
    titleClick : "form,item",
    titleDoubleClick : "form,item",

    mouseMove : "form,item", 
    mouseOver : "form,item", 
    mouseOut : "form,item", 
    titleMove : "form,item", 
    titleOver : "form,item",         
    titleOut : "form,item", 

        
    itemHover : "form,item",
    titleHover : "form,item",
        
    //> @method formItem.keyPress()
    // StringMethod fired when the user presses a key while focused in this form item.
    // @param item (FormItem) Item over which the keypress occurred
    // @param form (DynamicForm) Pointer to the item's form
    // @param keyName (KeyName) Name of the key pressed (Example: <code>"A"</code>, <code>"Enter"</code>)
    // @param characterValue (number) If this was a character key, this is the numeric value
    // for the character
    // @group eventHandling
    // @visibility external
    //<
    keyPress : "item, form, keyName, characterValue",  // was keyNum, form, item

    // NOTE: characterValue not passed because it's not guaranteed to be available
    
    //> @method formItem.keyDown()
    // StringMethod fired in response to a keydown while focused in this form item.
    // @param item (FormItem) Item over which the keydown occurred
    // @param form (DynamicForm) Pointer to the item's form
    // @param keyName (KeyName) Name of the key pressed (Example: <code>"A"</code>, <code>"Enter"</code>)
    // @group eventHandling
    //<    
    keyDown : "item, form, keyName",
    //> @method formItem.keyUp()
    // StringMethod fired in response to a keyup while focused in this form item.
    // @param item (FormItem) Item over which the keyup occurred
    // @param form (DynamicForm) Pointer to the item's form
    // @param keyName (KeyName) Name of the key pressed (Example: <code>"A"</code>, <code>"Enter"</code>)
    // @group eventHandling
    //<    
    keyUp : "item, form, keyName",
    
    //> @method formItem.getValueIcon()
    // If specified this stringMethod allows the developer to specify the image source for an 
    // icon to be displayed for the current form item value. 
    // Takes presidence over +link{FormItem.valueIcons}
    // @param value (any) value of the item for which an item should be returned.
    // @group valueIcons
    // @visibility external
    //<
    getValueIcon : "value",

    // called via DF.saveData() callback.  Return false from this method to perform async
    // processing before saveData() callback is called.  Then call form.saveDataComplete() to
    // tell the form to proceed.
    formSaved: "request,response,data"
});

isc.FormItem.getPrototype().toString = function () {
    return "[" + this.Class + " ID:" + this.ID +
            (this.name != null ? " name:" + this.name : "") + "]";
};
