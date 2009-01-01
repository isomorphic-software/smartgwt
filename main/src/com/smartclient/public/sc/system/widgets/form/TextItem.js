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

 





//>	@class	TextItem
//
// FormItem for managing a text field.
//
// @visibility external
// @example textItem
//<
isc.ClassFactory.defineClass("TextItem", "FormItem");
isc.TextItem.addProperties({
    //>	@attr	textItem.width		(number : 150 : IRW)
	//			Default width for fields.
	//		@group	appearance
    // @visibility external
	//<
	width:150,		
    
    //>	@attr	textItem.height		(number : 19 : IRW)
	//			Default height for text items.
	//		@group	appearance
    // @visibility external
	//<                                       
    
    height:isc.Browser.isSafari ? 22 : 19,

    //>	@attr	textItem.textBoxStyle     (FormItemBaseStyle : "textItem" : IRW)
	//  Base CSS class name for this item's input element.
    // NOTE: See the +link{group:CompoundFormItem_skinning} discussion for special skinning considerations.    
	// @group	appearance
    // @visibility external
	//<
	textBoxStyle:"textItem",		

    //>	@attr	textItem.length		(number : null : IRW)
	//			if set, maximum number of characters for this field
	//		@group	validation
    // @visibility external
	//<
	length:null,

    // whether its possible for this type of FormItem to do autoCompletion
    canAutoComplete:true,

	//>	@attr	textItem._elementType			(string : "TEXT" : IRW)
	//			type of field (eg: "PASSWORD", "UPLOAD", etc)
	//<		
	_elementType:"TEXT",

    //> @attr   textItem._hasDataElement    (boolean : true : IRW)
    //      Text items have a data element.
    // @group formValues
    // @visibility   internal
    // @see     method:FormItem.hasDataElement
    // @see     method:FormItem.getDataElement
    //<
    _hasDataElement:true,
    
    // Set flag to indicate that our data element is used as the textBox for this item.
    // This flag means updateState will apply the result of this.getTextBoxStyle() to this item's
    // data element - appropriate for native text boxes, text areas and selects.
    _dataElementIsTextBox:true,

    //> @attr   textItem.emptyStringValue   (any : null : IRW)
    //      Should the empty string be mapped to null, or stored as an empty string.
    //      Updated on 'setValue(null)' or 'setValue("")'
    // @group formValues
    // @visibility   internal
    //<    
    
    _emptyStringValue:null,
    
    // Override redrawOnShowFormIcon - we can handle dynamically updating the item's HTML to
    // show / hide text item icons
    redrawOnShowIcon:false,
    
    // _nativeEventHandlers is a place to specify native event handlers to be applied to the
    // form item element once it has been written into the DOM (without having to override 
    // '_applyHandlersToElement()'
    _nativeEventHandlers : {
        
        
        onmousedown : (
            isc.Browser.isIE ? function () {
                var element = this,
                    itemInfo = isc.DynamicForm._getItemInfoFromElement(element),
                    item = itemInfo.item;
                if (item) item._setupFocusCheck();
    
            } : null
        )
    }
    
    //>@attr TextItem.browserSpellCheck (boolean : null : IRWA)
    // @include FormItem.browserSpellCheck
    // @visibility internal
    //<
    
    //>@attr TextItem.selectOnFocus (boolean : null : IRW)
    // @include FormItem.selectOnFocus
    // @visibility external
    //<
    
    //>@attr TextItem.readOnly  (boolean : null : IRWA)
    // Setter for the standard HTML readonly property of the input element.
    // If set to true, text will be non editable (though it can still be selected and copied etc)
    // @visibility internal
    //<


                                        
});
isc.TextItem.addMethods({
    // _handlePaste: Handler for the native onpaste event
    // this fires in IE only.
    // Fires before the value is pasted into the form item, so returning false would cancel the
    // paste.
    // Perform update on a delay so we have the new value available from the form item element.
    _handleCutPaste : function () {
        
        // Fire change handlers on paste.
        
        if (this.changeOnKeyPress) this._queueForUpdate();
    },
    
    // _willHandleInput()
    // Can we use the "input" event in this browser / form item?
    // True for Moz and Safari, but not IE. See comments near FormItem._handleInput()
    _willHandleInput : function () {
        return !isc.Browser.isIE;
    },
    
    // by putting 'nowrap' on the text box cell we avoid the value icon / text box appearing 
    // on different lines
    getTextBoxCellCSS : function () {
        return this._$nowrapCSS
    },

    // NOTE: this is here for doc generation
    //>	@method textItem.keyPress		(A)
	//		@group	event handling
	//			event handler for keys pressed in this item
	//<

	//>	@method	textItem.getElementHTML()	(A)
	//			output the HTML for a text field element
	//		@group	drawing
	//		@param	value	(string)	Value of the element [Unused because it is more reliably set by setValue].
	//		@return	(HTML)	HTML output for this element
	//<
    _$elementStartTemplate:[
        ,                   // [0] possible value icon stuff
        "<INPUT TYPE=",         // [1]
        ,                       // [2] this._elementType,
        " NAME=",               // [3]
        ,                       // [4] this.getElementName(),
        " ID=",                 // [5]
        ,                       // [6] this.getDataElementId(),
            // We want the EH system to handle events rather than writing native
            // handlers into the form item.
        " handleNativeEvents=false" // [7]
    ],
    _$tabIndexEquals:" TABINDEX=",
    _$rightAngle:">",
            
    _$disabled:" DISABLED ",
    _$native:"native",
    _$autoCompleteOff:" AUTOCOMPLETE=OFF ",
    _$accessKeyEquals:" ACCESSKEY=",
    
	getElementHTML : function (value, returnArray) {
        var valueIconHTML = this._getValueIconHTML(this._value);
        if (this.showValueIconOnly) return valueIconHTML;
        
		var template = this._$elementStartTemplate,
            form = this.form,
			formID = form.getID(),
			itemID = this.getItemID()
		;

        // May be null
        template[0] = valueIconHTML;
		
        template[2] = this._elementType;
        template[4] = this.getElementName();
        template[6] = this.getDataElementId();
        
        // hang a flag on the element marking it as the data element for the
        // appropriate form item.
        template[8] = this._getItemElementAttributeHTML();
        
        // At this point we're appending to the end of the template Disable spellchecker in
        // Moz if appropriate so we don't get the red wavy line under email addresses etc.
         
        
        if (isc.Browser.isMoz || isc.Browser.isSafari) {
            if (this.getBrowserSpellCheck()) template[template.length] = " spellcheck=true";
            else template[template.length] = " spellcheck=false"
        }
        
        // If we get an oninput event for this browser, write it out into our element's HTML
        
        if (this._willHandleInput) {
            template[template.length] = " ONINPUT='" 
            template[template.length] = this.getID() 
            template[template.length] = "._handleInput()'"
        }
        
        if (this.isDisabled()) template[template.length] = this._$disabled;
        
        // Write out 'readOnly' setting if present
        if (this.containerWidget.isPrinting || this.readOnly) {
            template[template.length] = " READONLY=TRUE"
        }
        
        if (this.containerWidget.isPrinting && value != null && value != isc.emptyString) {
            template[template.length] = " value=" + value;
        }
        
        // disable native autoComplete 
              
        if (this._getAutoCompleteSetting() != this._$native) {
            template[template.length] = this._$autoCompleteOff;
        }
        
        template[template.length] = this.getElementStyleHTML();
        
        
        var tabIndex = this._getElementTabIndex();
        if (tabIndex != null) {
            var end = template.length;
            template[end] = this._$tabIndexEquals;  
            isc._fillNumber(template, tabIndex, end+1, 5);
        }
        
        // Note: if we're showing a title for the element, we don't need to set
        // up an accessKey here, since the label tag takes care of that
        if (this.showTitle == false && this.accessKey != null) {
            template[template.length] = this._$accessKeyEquals;
            template[template.length] = this.accessKey;
        }
        
        template[template.length] = this._$rightAngle;

        var result = template.join(isc.emptyString);
        
        // Trim the entries off the end of the template so we can reuse it.
        template.length = 8;
        return result;
	},  
    
    
    _sizeTextBoxAsContentBox : function () {
        return isc.Browser.isStrict;
    },
    
    // override _nativeElementBlur() to fire blur and change handlers in response to a native 
    // blur
    //
    // Natively onblur is fired when focus is taken from the text item, but onchange will
    // only fire if the value on leaving the text item is different from what it was when
    // the user put focus into the text item.
    //
    // Since we do internal values handling, having the same element value when focus is 
    // taken from a form item as when focus first went to a form item is not a guarantee
    // that our stored value for the form item has not changed, and vice versa - 
    // typically we are saving values in response to key events due to 'changeOnKeypress'.
    // 
    // Therefore instead of relying on the native change handler, on blur we will always fire
    // our change handler if changeOnBlur is true, and otherwise compare our stored value to
    // the current element value, and fire the change handler if they do not match.
    
    _nativeElementBlur : function (element, itemID) {
        var returnVal = this.Super("_nativeElementBlur", arguments);

        if (this.changeOnBlur) this.form.elementChanged(this);
        else {
            var elementValue = this.getElementValue();
            // unmap the value if necessary 
            if (this.mapDisplayToValue) {
                elementValue = this.mapDisplayToValue(elementValue);
            }
            if (this._value != elementValue) this.form.elementChanged(this);
        }
        
        return returnVal;
    },
    
	//>	@method	textItem.getElementStyleHTML()	(I)
    //      	Get the HTML string used to set the visual characteristics for a text item.
    //          This includes the STYLE=... & CLASS=... properties to be written into this
    //          form item's element.
	//			This varies by platform, as we attempt to make Netscape think in pixels rather than 
    //          characters and rows
	//
	//		@group	appearance
	//		@return	(string)    String of HTML containing STYLE=... & CLASS=... properties for 
    //                          this items element.
	//
	//<
    _$styleTemplate:[
        " CLASS='",          // [0]
        ,                   // [1] this.getTextBoxStyle(),
        "' STYLE='",         // [2]
        ,                   // [3] null or 'width:'
        ,,,,                // [4-7] null or width
        ,                   // [8] null or 'px;'

             
        ,                   // [9] null or 'height:'
        ,,,,                // [10-13] null or height
        ,                   // [14] null or 'px;'

            // text align property, known to be supported in IE6 and Moz/Firefox on
            // Windows, not supported on Safari 1.2
        ,                   // [15] null or 'text-align'
        ,                   // [16] null or this.textAlign
        ,                   // [17] null or ";"
        
            // In Mozilla we must use the '-moz-user-focus' css property to govern
            // whether this element can recieve focus or not.
            // (slots 18 and 19)
        (isc.Browser.isMoz ? "-moz-user-focus:" 
            
            : isc.Browser.isIE ? "margin-top:-1px;margin-bottom:-1px;" : null),    // [18]
        ,                   // [19] Moz: 'normal' or 'ignore' - otherwise null
        "' "                // [20]
    ],
    _$widthColon:"WIDTH:",
    _$pxSemi:"px;",
    _$heightColon:"HEIGHT:",
    _$textAlignColon:"text-align:",
    _$semi:";",
    _$normal:"normal;", _$ignore:"ignore;",
	getElementStyleHTML : function () {
        
        var template = this._$styleTemplate,
            width = this.getTextBoxWidth(),
            height = this.getTextBoxHeight(),
            style = this.getTextBoxStyle();

        template[1] = style;
        
        
        if (isc.isA.Number(width)) {
            template[3] = this._$widthColon;
            isc._fillNumber(template, width, 4, 4);            
            template[8] = this._$pxSemi;
        } else {
            template[3] = template[4] = template[5] = template[6] = 
                template[7] = template[8] = null;
        }
        
        if (isc.isA.Number(height)) {
            template[9] = this._$heightColon;
            isc._fillNumber(template, height, 10, 4);                        
            template[14] = this._$pxSemi;
        } else {
            template[9] = template[10] = template[11] = template[12] = 
                template[13] = template[14] = null;            
        }
        
        if (this.textAlign) {
            template[15] = this._$textAlignColon;
            template[16] = this.textAlign;
            template[17] = this._$semi;
        } else {
            template[15] = template[16] = template[17] = null;
        }
        
        if (isc.Browser.isMoz) {
            template[19] = (this._getElementTabIndex() > 0 ? this._$normal
                                                           : this._$ignore);
        }
        return template.join(isc.emptyString);
    },
    
	//>	@method	textItem.mapValueToDisplay()	(A)
	//		@group	drawing
	//			Map from the internal value for this item to the display value.
	//		@param	internalValue		(string)	Internal value for this item.
	//		@return	(string)	Displayed value corresponding to internal value.
	//<
	mapValueToDisplay : function (internalValue) {
        
        var value = isc.FormItem._instancePrototype.mapValueToDisplay.call(this, internalValue);
        // always display the empty string for null values, rather than "null" or "undefined"
        if (value == null) return isc.emptyString;
        
        return value;
	},
	
	//>	@method	textItem.mapDisplayToValue()	(A)
	//		@group	drawing
	//			Map from a the display value for this item to the internal value.
	//
	//		@param	displayValue	(string)	Value displayed to the user.
	//		@return	(string)	Internal value corresponding to that display value.
	//<
	mapDisplayToValue : function (displayValue) {
		var value = this._unmapKey(displayValue);
        // if the value to be saved is an empty string, map it to 'null' if necessary
        if (isc.is.emptyString(value)) value = this._emptyStringValue;
        return value;
	},
    
    // override 'setValue'.
    // If passed null or the empty string, we store this as the 'empty string value' - this will
    // then be returned whenever the user clears out the text item element.
    setValue : function (value,b,c,d) {
        
        
        var undef;
        if (value !== undef && (value == null || isc.is.emptyString(value)))
            this._emptyStringValue = value;
        return this.invokeSuper(isc.TextItem, "setValue", value,b,c,d);
    }

});

