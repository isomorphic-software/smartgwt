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

 






//>	@class	StaticTextItem
//	A FormItem that displays an uneditable value.
// @visibility external
//<
isc.ClassFactory.defineClass("StaticTextItem", "FormItem");
isc.StaticTextItem.addProperties({
    //>	@attr	staticTextItem.height		(number : null : IRW)
	//			don't specify a height so the table cell will expand
	//			to show the entire contents.  Note that this can 
	//			mess up dynamic height calculations in forms.
	//		@group	appearance
	//<
	height:null,

    //>	@attr	staticTextItem.width		(number : null : IRW)
	//			If a width is specified, we write out a table to make width consistent,
	//			if <code>null</code> is used, we write out a SPAN which is cheaper.
	//		@group	appearance
	//<
	width:null,

    //>	@attr	staticTextItem.wrap		(boolean : true : IRW)
	// @include FormItem.wrap
	//		@group	appearance
    // @visibility external
	//<
	wrap:true,
    
    //>@attr    staticTextItem.clipValue (boolean : false : IRW)
    // @include FormItem.clipValue
    // @group appearance
    // @visibility external
    //<
    //clipValue:null,
    

    //>	@attr	staticTextItem.textBoxStyle    (FormItemBaseStyle : "staticTextItem" : IRW)
	//  Base CSS class for this item
	// @group   appearance
    // @visibility external
	//<
	textBoxStyle:"staticTextItem",

    //>	@attr	staticTextItem.outputAsHTML (boolean : false : IRW)
	// By default HTML values in a staticTextItem will be interpreted by the browser.
    // Setting this flag to true will causes HTML characters to be escaped, meaning the
    // raw value of the field (for example <code>"&lt;b&gt;AAA&lt;/b&gt;"</code>) is displayed
    // to the user rather than the interpreted HTML (for example <code>"<b>AAA</b>"</code>)
    // @group appearance
    // @visibility external
	//<
	outputAsHTML:false,
    
     // override 'emptyDisplayValue' to write out "&nbsp;" instead of "" for styling
    emptyDisplayValue:"&nbsp;"
                                       
});
isc.StaticTextItem.addMethods({
	
        
	//>	@method	staticTextItem.mapValueToDisplay()	(A)
	// Map from the internal value for this item to the display value.
	//		@group	drawing
	//		@param	internalValue		(string)	Internal value for this item.
	//		@return	(string)	Displayed value corresponding to internal value.
	//<
	mapValueToDisplay : function (internalValue, a,b,c,d) {
        var value = this.invokeSuper(isc.StaticTextItem, "mapValueToDisplay", 
                                     internalValue, a,b,c,d);
        var asHTML = this.outputAsHTML || this.asHTML;
        // Don't escape &nbsp; unless that's actually the data value!  
        if (asHTML && (internalValue == null || internalValue == isc.emptyString)
            && value == this._$nbsp) 
        {
            asHTML = false;
        }
        if (isc.isA.String(value) && asHTML) {
            value = value.asHTML();
		}
        return value;
	},
    
    
    // Static text items are used for display only - non editable
    isEditable : function () {
        return false;
    }
});

