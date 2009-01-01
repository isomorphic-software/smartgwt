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

 



//> @groupDef upload
// SmartClient provides special client and server-side support for file upload that allows
// uploaded files to be treated like ordinary DataSource fields.  This includes:
// <ul>
// <li>the +link{FileItem} and +link{MultiFileItem} FormItems that enable users to upload one or
// more files as a background operation, without leaving the current page
// <li>server-side support that allows binary uploads to be treated as a normal DataSource field
// values, with all other aspects of server-side integration unchanged
// <li>built-in SQL DataSource support that can store and retrieve uploaded files from SQL
// databases
// </ul>
// The following documentation assumes you are using the SmartClient Java Server.  If you are
// not, skip to the sections near the end of this document.
// <P>
// <b>Single file upload: "binary" field type</b>
// <P>
// To use SmartClient's client-server upload system, you use a DataSource field of
// +link{dataSourceField.type,type} "binary".  By default, a DynamicForm bound to a DataSource
// with a field of type "binary" will use the +link{FileItem}, which displays a standard HTML
// &lt;input type="upload"&gt; form control.
// <P>
// When you call +link{dynamicForm.saveData()} on a DynamicForm containing a FileItem,
// SmartClient processes the save identically to a saveData() call that did not include a file
// upload:
// <ul>
// <li> if you are using the built-in SQL connectors via serverType:"sql", the file will be
// saved to SQL as described under +link{type:FieldType,field type "binary"}.
// <li> if you have server-side business logic, the inbound request may be routed to your
// business logic via RPCManager dispatch or DMI declarations as normal, your business logic
// will receive a normal DSRequest, and you are expected to provide a normal DSResponse.
// </ul>
// <P>
// Client-side callbacks, such as the callback passed to saveData(), fire normally.
// <P>
// <b>Processing File Uploads with server-side business logic</b>
// <P>
// Server-side business logic that processes file uploads may retrieve upload files via the
// server side API dsRequest.getUploadedFile(<i>fieldName</i>).  The uploaded file is returned
// as an instance of ISCFileItem, which provides access to a Java InputStream as well as
// metadata about the file (size, name).  
// See the +docTreeLink{javaServerReference,Java Server Reference} for details.
// <P>
// <span style="color:red;font-weight:bold;">NOTE:</span> request processing engines such as
// Struts may parse the inbound request before SmartClient receives it.  If you are creating an
// RPCManager object inside of a Struts Action and the file being uploaded is not available via
// <code>dsRequest.getUploadedFile()</code>, this is likely to be the problem, and you should
// use SmartClient +link{DMI} instead.
// <P>
// Server-side validation errors may be provided, including validation errors for the uploaded
// file (such as too large or invalid content), and will be displayed in the form that
// attempted an upload.
// <P>
// Be aware of the following special concerns when processing file uploads:
// <ul>
// <li> if you provide your own Java Servlet or JSP that creates an instance of RPCManager in
// order process SmartClient requests, many APIs of the HttpServletRequest are not safe to call
// before you have created the RPCManager, passing in the HttpServletRequest.  These include
// getReader(), getParameter() and other commonly called methods.  This is a limitation of
// Java Servlets, not specific to SmartClient
// <li> unlike other DataSource "add" and "update" operations, you are not expected to return
// the file as part of the data returned in the DSResponse
// </ul>
// <P>
// <b>Multi file upload: MultiFileItem</b>
// <P>
// The MultiFileItem provides an interface for a user to save one or more files that are
// related to a DataSource record, where each file is represented by a record in a
// related DataSource.
// <P>
// See the +link{MultiFileItem} docs for details.
// <P>
// <b>Upload without the SmartClient Server</b>
// <P>
// If it is acceptable that the application will do a full-page reload after the upload
// completes, you can simply:
// <ul>
// <li> set +link{DynamicForm.encoding} to "multipart"
// <li> include an +link{UploadItem} to get a basic HTML upload control
// <li> set +link{DynamicForm.action} to a URL where you have deployed server-side code to
// handle the upload
// <li> call +link{dynamicForm.submitForm()} to cause the form to be submitted
// </ul>
// This cause the DynamicForm component to submit to the form.action URL like an ordinary HTML
// &lt;form&gt; element.  Many 
// +externalLink{http://www.google.com/search?q=html+file+upload+example,online tutorials}
// are available which explain how to handle HTML form file upload in various server-side
// technologies.
// <P>
// Note that when you submitForm(), the only values that will be sent to your actionURL are 
// values for which actual FormItems exist.  This differs from saveData(), in which the
// entire set of +link{dynamicForm.values,form values} are always sent.  To handle submitting
// extra values, use +link{HiddenItem}s.
// <P>
// For further details, see the +link{UploadItem} docs.
// <P>
// <b>Background upload without the SmartClient Server</b>
// <P>
// Achieving background file upload without using the SmartClient server is also possible
// although considerably more advanced.  In addition to the steps above, create a hidden
// &lt;iframe&gt; element in the page, and use +link{dynamicForm.target} to target the form
// submission at this IFRAME.  In order receive a callback notification when the upload
// completes, after processing the file upload, your server should output HTML content for the
// IFRAME that includes a &lt;SCRIPT&gt; block which will navigate out of the IFRAME (generally
// via the JavaScript global "top") and call a global method you have declared as a callback.
//
// @title Uploading Files
// @visibility external
// @treeLocation Client Reference/Forms/Form Items/FileItem
//<


//>	@class FileItem
//
// Binary data interface for use in DynamicForms. Allows users to select a single file for
// upload.
// <P>
// See the +link{group:upload,Upload Overview} for information on using this control.
//
// @group upload
// @treeLocation Client Reference/Forms/Form Items
// @visibility external
//<
isc.ClassFactory.defineClass("FileItem", "CanvasItem");

isc.FileItem.addProperties({
    // we want our value to show up in the forms values object!
    shouldSaveValue:true,
    
    _createCanvas : function () {
        this.canvas = isc.DynamicForm.create({
            autoDraw:false,
            // suppress redraws as much as possible - redraw == killing the item value.
            _redrawWithParent:false,
            redrawOnResize:false,
            canSubmit:true,
            action:this.action,
            items:[
                {targetItem:this, type:"upload", name:this.getFieldName(), showTitle:false,
                    saveValue : function (a,b,c,d) {
                        this.Super("saveValue", arguments);
                        this.targetItem.saveValue(a,b,c,d);
                    }
                }
            ]
        });
        this.containerWidget.addChild(this.canvas);
    },
    
    getValue : function () {
        return this.canvas.getValue(this.getFieldName());
    },
    
    setValue : function (newValue) {
        this.logWarn("Cannot programatically set the value of an upload field due to security restraints");
        return;
    }

});
