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

 





//>	@class	UploadItem
//
// FormItem that creates an HTML &lt;input type="upload"&gt; control, with an interface that
// allows a user to pick a file from his machine to upload to the server.
// <P>
// See the +link{group:upload,Uploading Files} overview for details.
// <P>
// Note: if a form containing an UploadItem is +link{canvas.redraw(),redrawn} (which may
// happen if other form items are shown or hidden, the form is
// +link{canvas.redrawOnResize,resized}, or other items show validation errors) then the value
// in the upload item is lost (because an HTML upload field may not be created with a value).
// For this reason, if you are building a form that combines an UploadItem with other FormItems
// that could trigger redraw()s, recommended practice is to place each UploadItem in a distinct
// DynamicForm instance and create the visual appearance of a single logical form via combining
// the DynamicForms in a +link{Layout}.
//
// @group upload
// @visibility external
//<


isc.ClassFactory.defineClass("UploadItem", "TextItem");
isc.UploadItem.addProperties({
	_elementType:"FILE"
});


isc.UploadItem.addMethods({
    
    
    
    getTextBoxWidth : function () {
        if (isc.Browser.isMoz) return null;
        return this.Super("getTextBoxWidth", arguments);
    },
    
    elementHeight:(isc.Browser.isMoz ? 18 : null),
    getTextBoxHeight : function () {
        if (this.elementHeight) return this.elementHeight;
        return this.Super("getTextBoxHeight", arguments);
    },
    
    
    _getEventMaskWidth : function () {
        var width = this.getElementWidth();
        if (!isc.isA.Number(width)) width = 185;
        return width;
    },
    
    // Override _updateValue - if the change handler etc attempts to modify the value 
    // log a warning that we can't support this and save the value the user entered.
    _updateValue : function (newValue) {

        // unmap the value if necessary 
        newValue = this.mapDisplayToValue(newValue);

        // Bail if we have already saved the value (avoids firing change on arrow keypresses,
        // etc.)
        if (newValue == this._value) return true;
        
        // fire the change handler, and bail if the change failed validation, etc.
        // Note: this method will call 'setValue()' to reset to the old value, or any value
        // suggested by the validators
        var returnVal = this.handleChange(newValue, this._value);
        
        // UploadItems don't support setting the value. If a change handler returned false, or
        // we otherwiser attempted to change the value, log a warning and drop that changed val
        if (this._changeValue != newValue) {
            this.logWarn("Upload Items do not support programatically modifying the value entered " +
                         "by the user. Ignoring attempt to update from change handler");
        }

        // save the value
        
        this.saveValue(this.mapDisplayToValue(this.getElementValue()));
        return returnVal;    
    },
    
    redrawn : function () {
        this.Super("redrawn", arguments);
        this.updateValue(this.getElementValue());
    },

    //>	@method	uploadItem.setValue()
    // Attempting to set the value for an upload form item is disallowed for security reasons.
    // Therefore this method will just log a warning, and not modify the value of the item.
    // @visibility external
	//<
	setValue : function (newValue) {
        if (newValue == null || isc.isAn.emptyString(newValue)) {
            var val = this.getValue();
            if (val == null || isc.isAn.emptyString(val)) return;
            return this.Super("setValue", arguments);
        }
        this.logWarn("Attempting to set the value for an upload form item. This is disallowed " +
                     "for security reasons - returning the current value of the form item");
	},
    
	//>	@method	uploadItem.setElementValue()
	//		@group	elements
	//			Override setElementValue to explicity NOT manipulate the form element
	//			in Nav, since this is likely to crash.
	//		@param	newValue 	(any)				value to set the element to
	//<
	setElementValue : function (newValue) {
        // we CAN clear an upload item's value, but not set it to anything else.
        if (newValue == null || isc.isAn.emptyString(newValue)) {
            // Moz and Safari do allow setting element value to "" but IE does not
            // However redrawing a form with an uploadItem in it will clear its value natively
            if (isc.Browser.isIE) {
                this.redraw();
                return;
            }
            return this.Super("setElementValue", arguments);
        }

        this.logInfo("Attempting to set the value for an upload form item. This is disallowed " +
                     "for security reasons - returning the current value of the form item");
        
        // don't try to set the value of an upload field.  This should not be allowed by the
        // browser, as part of its security model, and attempting it will cause errors in some
        // browsers.
        return this.getElementValue();
	}
    
    

});

// Safari's style of drawing upload items is different from the Windows/IE style - 
// It requires more horizontal space as the "selected file" part of the item is non-editable
// and non scrollable, shares space with the upload "Choose File" button, and will show "..."
// in the middle of the name if it's truncated (which looks bad when the default is truncated
// to look like "no file ...ed"
// For Safari, default to having upload items appear spanning their own rows, at 300px wide.
if (isc.Browser.isSafari) {
    isc.UploadItem.addProperties({
        colSpan:"*",
        startRow:true,
        endRow:true,
        width:300
    })
}
