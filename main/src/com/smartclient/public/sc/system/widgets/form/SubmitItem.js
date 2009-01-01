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

 






//>	@class	SubmitItem
// Button that saves the data in the form, by calling <code>DynamicForm.submit()</code> 
// Behavior depends on the containing form's +link{DynamicForm.canSubmit} property. 
// If <code>form.canSubmit</code> is true, this method will perform a direct submission
// of the underlying HTML form.<br>
// Otherwise standard RPC operations will be used to save the changes.
//
// @see group:operations
// @see attr:dynamicForm.canSubmit
// @see method:dynamicForm.submit
//
// @visibility external
//<
isc.ClassFactory.defineClass("SubmitItem", "ButtonItem");
isc.SubmitItem.addProperties({
    //>@attr    SubmitItem.title    (String : "Submit" : IRW)
    // SubmitItems show a title of <code>"Submit"</code> by default. May be overridden.
    // @visibility external
    //<
    title:"Submit"
});

isc.SubmitItem.addMethods({
    
    handleClick : function () {
        if (this.Super("handleClick", arguments) == false) return false;
        // note that submit() is implemented to perform a native submission (via submitForm())
        // iff form.canSubmit is true - otherwise it falls through to dataBoundComponent 
        // 'saveData()' method
        this.form.submit();
    }
});

