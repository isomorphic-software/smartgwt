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

 






//>	@class	NativeCheckboxItem
// A checkbox for manipulating 2-valued fields based on the native checkbox element.
// @visibility external
//<
isc.ClassFactory.defineClass("NativeCheckboxItem", "FormItem");
isc.NativeCheckboxItem.addProperties({
    
    //>	@attr	nativeCheckboxItem.titleStyle (FormItemBaseStyle : "labelAnchor" : IRW)
	// Base CSS class applied to this item's title
	//		@group	appearance
	//<
    
	titleStyle:"labelAnchor",
    
    // If we're in screenReader mode, this form item will use the native 'title' attribute
    // to show hover prompts.
    implementsPromptNatively:isc.screenReader,

	//>	@attr	nativeCheckboxItem._elementType				(string : "CHECKBOX" : IRW)
	//			type of item ("CHECKBOX" or "RADIO")
	//		@group	appearance
	//<
	_elementType:"CHECKBOX",

    //> @attr   nativeCheckboxItem._hasDataElement    (boolean : true : IRW)
    //      Checkboxes have a data element.
    // @group formValues
    // @visibility   internal
    // @see     method:FormItem.hasDataElement
    // @see     method:FormItem.getDataElement
    //<
    _hasDataElement:true,
    
    //> @attr   nativeCheckboxItem.showLabel    (boolean : true : IRW)
    //  @include CheckboxItem.showLabel
    // @visibility external
    //<
    showLabel:true,
    
    // _nativeEventHandlers is a place to specify native event handlers to be applied to the
    // form item element once it has been written into the DOM (without having to override 
    // '_applyHandlersToElement()'
    _nativeEventHandlers:{
        // Fire change handlers in response to native clicks.
        
        onclick:isc.FormItem._nativeChangeHandler
    }    
    
                                            
});

isc.NativeCheckboxItem.addMethods({

    _$HTMLTemplate:[
        "<TABLE CELLSPACING=0 CELLPADDING=0 BORDER=0><TR>",     // 0
        
        // Actual element (checkbox)
        "<TD WIDTH=20><INPUT TYPE=",                            // 1
        ,                                                       // 2: this._elementType
        " NAME=",                                               // 3
        ,                                                       // 4: this.getElementName()
        " ID=",                                                 // 5
        ,                                                       // 6: this.getDataElementId()
        
        // hang a flag on the element marking it as the data element for the appropriate form item.
        ,                                                       // 7: this._getItemElementAttributeHTML()
        
        ,,,                                                     // 8,9,10: value=',vaue,', or null
        ,                                                       // 11: disabled or null
        " handleNativeEvents=false ",                           // 12
        ,,,                                                     // 13,14,15: title=',prompt,' or null
        " TABINDEX=",                                           // 16 
        ,                                                       // 17: this._getElementTabIndex()
        (isc.Browser.isMoz ? " STYLE='-moz-user-focus:" : null),// 18
        ,                                                       // 19: normal;', ignore;', or null
        // No need to write out the accessKey, since we'll always write that out
        // in the label for the checkbox
        "></TD>",                                               // 20
        ,                                                       // 21: title text cell, or null
        "</TR></TABLE>"
    ],

    _$labelCellTemplate:[
        "<TD CLASS='",   // 0
        ,               // 1: 
        // Note on alignment: It makes sense to align the title as close as
        // possible to the checkbox. For RTL pages we may want to write the
        // title out before the checkbox, and align right instead.
        "' ALIGN=LEFT",  // 2
        ,,              // 3,4: width= and width, or null
        ,,              // 5,6: height= and height, or null
        ">",            // 7
        ,               // 8: title
        "</TD>"
    ],
    
    _$safariTitleTemplate:[
        "<A HREF='javascript:void ",    // 0
        ,                               // 1: itemIDStr 
        ".boxTitleClick()' ONMOUSEOVER='window.status = \"", // 2
        ,                               // 3: this.prompt
        "\"; return true' ONMOUSEOUT='window.status = \"\"; return true' CLASS='",    // 4
        ,                               // 5: this.getTitleStyle()
        "' title=\"",                     // 6
        ,                               // 7: this.prompt
        // Note - safari doesn't allow us to tab to links, so no need to exclude from page's tab order        
        "\">",                          // 8
        ,                               // 9: title
        "</A>"
    ],
    
    // Override getInnerWidth to always return 20 if we're not showing the label - this is
    // enough space for the checkbox itself
    
    getInnerWidth : function (a,b,c,d) {
        
        if (!this.showLabel || this.showValueIconOnly) {
            return 20;
        }
        return this.invokeSuper(isc.NativeCheckboxItem, "getInnerWidth", a,b,c,d);
    },
    
    // Write out a table containing the checkbox followed by its label
    getElementHTML : function (value) {
        
        var formID = this.form.getID(),
			itemIDStr = this.getItemID(),
            template = this._$HTMLTemplate,
            title = this.getAnchorTitle()
		;
        
        template[2] = this._elementType;
        template[4] = this.getElementName();
        template[6] = this.getDataElementId();
        template[7] = this._getItemElementAttributeHTML();
        
        if (value != null) {
            template[8] = " VALUE='"; template[9] = value; template[10] = "'";
        } else {
            template[8] = null; template[9] = null; template[10] = null;
        }
        
        if (this.isDisabled()) template[11] = " DISABLED";
        else template[11] = null;

        
        if (this.implementsPromptNatively) {
            if (this.prompt != null) {
                template[13] = " TITLE='"; template[14] = this.prompt; template[15] = "'";
            } else {
                template[13] = template[14] = template[15] = null;
            }
        }
        
        var tabIndex = this._getElementTabIndex();
        template[17] = tabIndex;
        
        if (isc.Browser.isMoz) {
            template[19] = (tabIndex > 0 ? "normal;'" : "ignore;'");
        }
         
        
        if (this.showLabel && !this.showValueIconOnly) {
            // size the title's cell to the available width less the space taken up by the 
            // checkbox itself.
            var width = this.getElementWidth(),
                height = this.getInnerHeight();     
            if (isc.isA.Number(width)) width = Math.max(20, width - 20);            
            
            
            if (isc.Browser.isSafari && !this.isDisabled()) {
                var titleTemplate = this._$safariTitleTemplate;
                titleTemplate[1] = itemIDStr;
                titleTemplate[3] = this.prompt;
                titleTemplate[5] = this.getTitleStyle();
                titleTemplate[7] = this.prompt;
                titleTemplate[9] = title;
                
                title = titleTemplate.join(isc.emptyString);
            }
            
            // The text beside the checkbox can be described as a 'label' or a title.
            // we apply the title style to it, since it contains the title for the item.
            var titleCellTemplate = this._$labelCellTemplate;
            titleCellTemplate[1] = this.getTitleStyle();
            if (width != null) {
                titleCellTemplate[3] = " WIDTH="; titleCellTemplate[4] = width;
            } else {
                titleCellTemplate[3] = null; titleCellTemplate[4] = null;
            }
            
            if (height != null) {
                titleCellTemplate[5] = " HEIGHT="; titleCellTemplate[6] = height;
            } else {
                titleCellTemplate[5] = null; titleCellTemplate[6] = null;
            }
            titleCellTemplate[8] = title;
            
            // actually write it into the table
            template[21] = titleCellTemplate.join(isc.emptyString);
        } else {
            template[21] = null;
        }
        
        return template.join(isc.emptyString);
    },
    
    // override getOuterElement - we have no textBox element, though we could concievably have
    // a control table or outer table element.
    getOuterElement : function (a,b,c) {
        if (!this.isDrawn()) return null;
        var element;
        if (!this._writeOuterTable(this._wroteOutHint)  && !this.showPickerIcon) {
            element = this.getDataElement()
        }
        
        return this.invokeSuper(isc.NativeCheckboxItem, "getOuterElement", a,b,c);
    },
    
    
	//>	@method	nativeCheckboxItem.getTitleHTML()	(A)
	//		@group	drawing
	//          return the HTML for the title of this formItem - overridden from 
    //          FormItem.getTitleHTML()
	//
	//		@return	(HTML)	title for the formItem
	//<
	getTitleHTML : function () {
        // overridden to return an empty string so that DynamicForm.getTitleHTML() doesn't write
        // a title in the standard way on the left of this form item
		return "";
	},
    
    // Create a new method 'getLinkText' to get the title for the anchor beside the checkbox
    getAnchorTitle : function (a,b,c,d) {
        // use the superclass implementation of getTitle() -- will return the appropriate value, 
        // as an HTML string with any accessKey character underlined.
        // This also sets up the label as a <label> for the checkbox item, and takes care of
        // accessKey behaviour
        return this.invokeSuper(isc.NativeCheckboxItem, "getTitleHTML", a,b,c,d);
    },
	
	//>	@method	nativeCheckboxItem.setElementValue()
	//		@group	elements
	//			set the value of the form element to the value passed in
	//
	//		@param	newValue 	(any)				value to set the element to
	//<
	setElementValue : function (newValue) {
		// get a pointer to the element for this item
		var element = this.getDataElement();
		
		// if no element was found, bail
		if (!element) return null;
		
		// set the "checked" property of the DOM form element
        // NOTE: any non-null String is true in JavaScript, which is generally good, except for
        // the surprising case of specifying "false" as a String
		return element.checked = (newValue && newValue != "false");
	},

	//>	@method	nativeCheckboxItem.getElementValue()
	//		@group	elements
	//			return the value stored in the form element(s) for this item
	//
	//		@return	(any)		value of this element
	//<
	getElementValue : function () {
		// get a pointer to the element for this item
		var element = this.getDataElement();
		
		// if no element was found, bail
		if (!element) return null;

		// get the value of the item
		return (element.checked == true);
	},
	
	//>	@method	nativeCheckboxItem.boxTitleClick()
	//		@group	event handling
	//			handle a click on the label of a checkbox or radio button
	//			this toggles the state of the item
	//
	//<
	boxTitleClick : function () {
		// get a pointer to the element
		var element = this.getDataElement();
		
		// toggle the checked property of the element
		if (element) element.checked = !element.checked;
		
		// have the form call the elementChanged method of the item
		this.form.elementChanged(this.getItemID());
	}      

});


