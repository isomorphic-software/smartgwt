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

 



//>	@class	RichTextItem
// FormItem for rich text (HTML) editing. Makes use of a +link{RichTextEditor} as the 
// editing interface.
// @visibility external
//<

isc.ClassFactory.defineClass("RichTextItem", isc.CanvasItem);

isc.RichTextItem.addProperties({

    // Override canFocus to allow focus to go to the RichTextEditor
    canFocus:true,

    shouldSaveValue:true,
    
    //> @attr RichTextItem.showTitle (boolean : false : IR)
    // Don't show the title for rich text items by default
    // @visibility external
    //<
    showTitle:false,
    
    //>@attr RichTextItem.startRow   (boolean : true : IRW)
    // By default RichTextItems take up an entire row
    // @visibility external
    //<
    startRow:true,
    
    //>@attr RichTextItem.endRow (boolean : true : IRW)
    // By default RichTextItems take up an entire row
    // @visibility external
    //<
    endRow:true,
    
    //>@attr RichTextItem.colSpan (number | string : "*": IRW)
    // By default RichTextItems take up an entire row
    // @visibility external
    //<
    colSpan:"*",


    // Realistically rich text editors take up a lot of space because of their toolbars.
    width:550,
    
    //> @attr RichTextItem.controlGroups (Array : null : IA)
    // +link{RichTextEditor.controlGroups} to display for this editor.
    // Each controlGroup should be a property set either on this item or on the RichTextEditor
    // prototype and should be set to an array of +link{type:ControlName}s.
    // @visibility external
    //<
    // For each named control specified, you can override [controlName]Properties to apply
    // specific properties, [controlName]Constructor to supply a class for the control, and
    // [controlName]_autoMaker to supply a function taht actually creates (and returns) the 
    // control.
    //controlGroups : null

    //>@attr RichTextItem.defaultControlConstructor (Array : null : IA)
    // If set, this property will override +link{RichTextEditor.defaultControlConstructor} for
    // this item's RichTextEditor
    // @visibility internal
    //<
    //defaultControlConstructor : null
    
    canvasConstructor: "RichTextEditor"
    
    //>@attr RichTextItem.browserSpellCheck (boolean : null : IRWA)
    // @include FormItem.browserSpellCheck
    // @visibility internal
    //<

});

isc.RichTextItem.addMethods({
        // Override _createCanvas to set up a RichTextEditor as this item's canvas
    _createCanvas : function () {
        var value = this.getValue();
        // Map "undefined" (etc.) to an empty string
        value = this.mapValueToDisplay(value);
        
        var properties = {
            ID: this.getID() + "_editor",
            width:this.width,
            height:this.height,
            getBrowserSpellCheck:function() {
                return this.canvasItem.getBrowserSpellCheck();
            },
            value:value,
            valueChanged:"this.canvasItem.updateValue()"
        }
        
        var cgs = this.controlGroups;
        if (cgs != null) {
            var propsSuffix = "Properties",
                makerSuffix = "_autoMaker",
                constructorSuffix = "Constructor";
                
            properties.controlGroups = cgs;
            for (var i = 0; i < cgs.length; i++) {
                if (this[cgs[i]]) {
                    var groupName = cgs[i],
                        group = this[groupName];
                    
                    properties[groupName] = group;

                    // To allow full customization we need to be able to apply properties / 
                    // custom maker functions to each control.
                    for (var ii = 0; ii < group.length; ii++) {
                        var propName = group[ii] + propsSuffix,
                            makerName = group[ii] + makerSuffix,
                            constructorName = group[ii] + constructorSuffix;
                            
                        if (this[propName]) properties[propName] = this[propName];
                        if (this[makerName]) properties[makerName] = this[makerName];
                        if (this[constructorName]) 
                            properties[constructorName] = this[constructorName];
                    }
                }
            }
        }

        if (this.defaultControlConstructor != null) 
            properties.defaultControlConstructor = this.defaultControlConstructor;
        
        this.canvas = properties;
        this.Super("_createCanvas", arguments);        
    },
    
    // Override mapValueToDisplay to show null/undefined as ""
    
	mapValueToDisplay : function (internalValue) {
		var value = this.Super("mapValueToDisplay", internalValue);
        // always display the empty string for null values, rather than "null" or "undefined"
        if (value == null) return "";
        return value;
	},

    // Override set/getValue to update the value on the RTE
    setValue : function (value) {
        // Use the superclass implementation to perform validation, etc.
        this.Super("setValue", arguments);
        value = this._value;   
        this.canvas.setValue(this.mapValueToDisplay(value));
        this.updateValue();
    },
    
    getValue : function () {
        if (this.canvas) this.updateValue();
        return this.Super("getValue", arguments);
    },
    
    updateValue : function () {
        // Avoid JS error if this method gets called before init
        if (!this.canvas) return

        var value = this.canvas.getValue();
        return this._updateValue(value);
    }
    
    
});
