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

 






//>	@class	LinkItem
//	A FormItem that displays an HTML link
// @visibility external
//<
isc.ClassFactory.defineClass("LinkItem", "StaticTextItem");
isc.LinkItem.addProperties({
    wrap: false,
    
    // The link item is focusable
    canFocus:true
    
    //> @attr linkItem.target (string : "_blank" : IRW)
    // By default, clicking a link rendered by this item opens it in a new browser window.  You can
    // alter this behavior by setting this property.  The value of this property will be passed as the
    // value to the <code>target</code> attribute of the anchor tag used to render the link.
    // 
    // @visibility external
    //<
    
    //> @attr   linkItem.linkTitle (string : null : IRW)
    // Optional title text to display for this item's link. If unspecified the value of the item
    // will be the title text as well as the target of the link.
    // @setter linkItem.setLinkTitle()
    // @visibility external
    //<
    
});

isc.LinkItem.addMethods({

    // Even though we don't have a data element, we don't need a focus proxy - <a..> will
    // recieve focus in all browsers
    _writeOutFocusProxy : function () {
        return false;
    },
    
    _getLinkElement : function () {
        if (!this.isDrawn()) return null;
        return (isc.Element.get(this.getID() + "_link"));
    },
    
    // Apply focus/blur handlers to the link itself
    getFocusElement : function () {
        return this._getLinkElement();
    },

    // modify the text box template slightly - we're writing out a text box but it doesn't
    // need to be focusable
    _$textBoxTemplate:[ "<DIV ID='", // 0
                        ,            // 1: ID for text box
                        "' " + isc.DynamicForm._containsItem + "='", // 2
                        ,            // 3 [formItem ID]
                        "' " + isc.DynamicForm._itemPart + "='" + isc.DynamicForm._textBoxString, // 4
                        "' CLASS='", // 5
                        ,            // 6: this.getTextBoxStyle(),
                        "' STYLE='", // 7
                        ,            // 8: this.getTextBoxCSS(), 
                        "'>",        // 9
                        ,            // 10: actual value
                        "</DIV>"
    ],
	getElementHTML : function (value) {
        var linkHTML = this.getLinkHTML(value);
        
        var template = this._$textBoxTemplate;
        template[1] = this._getTextBoxID();
        template[3] = this.getID();
        template[6] = this.getTextBoxStyle();
        template[8] = this.getTextBoxCSS();
        template[10] = linkHTML;
        
        return template.join(isc.emptyString);
    },
    
    getLinkHTML : function (text) {
        var valueIconHTML = this._getValueIconHTML(this._value);
        if (this.showValueIconOnly) return valueIconHTML;

        // convert to String
        if (text != null) text = isc.iscToLocaleString(text);
        if (text == null) text = isc.emptyString;
        var title = this.linkTitle;
        if (title == null) title = text;
        // Convert to actual link
        text = isc.Canvas.linkHTML(text, title, this.target, 
                                    (this.getID() + "_link"), this.getGlobalTabIndex(), 
                                    this.accessKey)
        if (valueIconHTML != null) text = valueIconHTML + text;                                    
        return text;
    },
    
    // Override setElementValue to update the text box with the correct value
    setElementValue : function (value) {
        if (this.isDrawn()) {
            var textBox = this._getTextBoxElement();
            if (textBox) textBox.innerHTML = this.getLinkHTML(value);
            // Re apply the event handlers
            this._applyHandlersToElement();
        }
    },
    
    //> @method linkItem.setLinkTitle()
    // Method to set the linkTitle for this item
    // @param title (string) new linkTitle for this item
    // @visibility external
    //<
    setLinkTitle : function (title) {
        this.linkTitle = title;
        this.redraw();
    }

});