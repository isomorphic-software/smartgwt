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





//> @class BatchUploader
// The BatchUploader handles the upload, validation, review and saving of a dataset
// expressed in CSV or other upload formats.
// <P>
// By default, a BatchUploader consists of a single +link{FileItem} form field.
// This form field will upload a file using the special "batchUpload" built-in DataSource.
// The uploaded file data will be parsed and validated using the +link{uploadDataSource},
// then streamed back to the browser, along with any errors, for display in a ListGrid.  
// <P>
// The user can then correct any errors and submit the final dataset, which will be
// added to the DataSource via a series of "add" DSRequests, all submitted as a single
// HTTP request via +link{RPCManager.startQueue,request queuing}.
// <P>
// Additional form fields can be added to the form that uploads the data file via 
// +link{uploadFormFields}.  Values entered into these fields are not included in
// the "add" DSRequests used to store the uploaded records.  Instead, they are 
// stored as HttpSession attributes with the names corresponding to the 
// names of the specified +link{uploadFormFields} (optionally with a 
// +link{additionalFieldPrefix,prefix} applied, in case
// this is necessary to avoid name collisions in the session).  This allows any custom logic
// for the "add" operation to access these additional fields via httpSession.getAttribute().  
// <P>
// Because all records are saved in a single HTTP request, a similar strategy of 
// storing data as servletRequest or session attributes allows reuse of objects required to
// perform the "add" operations (such as field values common to all added records,
// or a SQL connection or transaction manager). 
// <p>
// <b>Note:</b> The special "batchUpload" DataSource, which should reside in the shared/ds 
// folder of your application's webroot (see +link{group:iscInstall}), 
// is not part of your application's data flow, and it has nothing to do with the 
// +link{batchUploader.uploadDataSource,uploadDataSource} you use to actually persist the validated
// and error-corrected data: it is simply a means to uploading the raw data in the first place.
// Normally, you should simply ignore its presence and treat it as an internal detail of the 
// SmartClient framework.
// <p>
// However, there are circumstances in which you may wish to change it to achieve specific aims.
// For example, you may wish to override the Java class it invokes, in order to insert your own
// security or other validation logic into the initial upload flow.  This is entirely in keeping
// with the design, but we regard it as an out-of-the-ordinary use-case: normal usage is simply 
// to ignore the presence of the batchUpload DataSource.
//
// @visibility external 
//<
isc.defineClass("BatchUploader", "VStack").addProperties({
	defaultWidth:"80%",

	//> @attr batchUploader.uploadForm (AutoChild : null : IR)
	// Form used to specify file to upload, and any additional fields required.
    //
    // @visibility external
	//<
	uploadFormDefaults : {
		_constructor:"DynamicForm",
        updateOperation: "upload"
	},
	
	//> @attr batchUploader.uploadDataSource (DataSource : null : IR)
	// DataSource used to save uploaded records.  Should have an operation of type "add".
    // <p>
    // Be careful to note that this is the DataSource representing your data as it will be 
    // persisted to your server.  It is completely different from the special "bacthUpload"
    // DataSource which is used purely as a medium to upload the raw data to the server in
    // the first place.
    // @visibility external
	//<
	
	//> @attr batchUploader.uploadOperation (String : null : IR)
	// Optional +link{dsRequest.operationId} for the "add" operation used to add new
	// records to the +link{uploadDataSource}.
    //
    // @visibility external
	//<
	
	//> @attr batchUploader.uploadFormFields (List of FormItem Properties : null : IR)
	// Optional fields for the uploadForm.
    //
    // @visibility external
	//<
	
	//> @attr batchUploader.uploadFileLabel (String : "Upload File" : IR)
	// Title to display next to the +link{FileItem} field where the user enters a filename to upload
    //
    // @visibility external
	//<
    uploadFileLabel: "Upload File",
	
	//> @attr batchUploader.uploadButton (AutoChild : null : IR)
	// Button that triggers the upload.
	//<
	uploadButtonDefaults : {
		_constructor:"IButton",
		title:"Upload",
		click:"this.creator.upload()"
	},
	
	//> @attr batchUploader.grid (AutoChild : null : IR)
	// Grid which will show a preview of data to be uploaded, with errors flagged
	//<
	gridDefaults : {
		_constructor:"ListGrid",
		defaultHeight:500,
		canEdit: true,
		editByCell: true,
		validateByCell: true,
		autoSaveEdits: false
	},
    
    cancelCommitButtonLayoutDefaults : {
        _constructor: "HLayout"
    },
	
	//> @attr batchUploader.commitButton (AutoChild : null : IR)
	// Button that commits changes once user is happy with data.
	//<
	commitButtonDefaults : {
		_constructor:"IButton",
		title:"Commit",
		click:"this.creator.commitClicked()",
        autoParent:"cancelCommitButtonLayout"
	},
	
	//> @attr batchUploader.cancelButton (AutoChild : null : IR)
	// Button that cancels the uncommitted upload
	//<
	cancelButtonDefaults : {
		_constructor:"IButton",
		title:"Cancel",
		click:"this.creator.cancelClicked()",
        autoParent:"cancelCommitButtonLayout"
	},
	
	//> @attr batchUploader.uploadFieldPrefix (String : null : IRW)
	// String to prepend to the names of the additional fields specified in +link{uploadFormFields} 
    // before they are stored in the HttpSession on the server.  This property provides a basic
    // namespace facility, allowing you to avoid name collisions with existing session attributes.
    // <P>
    // Example usage: if you have an additional field called "someDate" and you set 
    // uploadFieldPrefix to "myFields_", your additionalFormField will be available as an
    // HttpSession attribute called "myFields_someDate"
    //
    // @visibility external
	//<
    
    
    //> @type  PartialCommitOption
    // Action to take if a user attempts to save the dataset produced by a +link{BatchUploader}
    // whilst it still contains errors. 
    // 
    // @value  "allow"  Silently allow the partial commit to proceed (note that this will result
    //                  in the user losing those records that contain errors)
    // @value  "prevent" Pop up a message window and prevent the partial commit
    // @value  "prompt" Pop up a confirmation window and allow the user to choose whether or not to
    //                  proceed 
    // @visibility external
    //<
	
	//> @attr batchUploader.partialCommit (PartialCommitOption : "prompt" : IRW)
	// Specifies what action to take if the user attempts to commit a partially validated set
    // of data (ie, one that still contains some errors).
    //
    // @visibility external
	//<
    partialCommit: "prompt",
	
	//> @attr batchUploader.partialCommitPrompt (String : See below : IRW)
	// If +link{partialCommit} is set to "prompt", the text to display to the user in the 
    // confirmation dialog.  By default, this text is "There are errors in your data so it 
    // cannot all be saved.  If you proceed, you will lose the records with errors.  Click 'OK'
    // to proceed anyway, or 'Cancel' to return to your data"
    //
    // @visibility external
	//<
    partialCommitPrompt: "There are errors in your data so it cannot all be saved.  " + 
                         "If you proceed, you will lose the records with errors.  Click 'OK' " +
                         "to proceed anyway, or 'Cancel' to return to your data",
	
	//> @attr batchUploader.partialCommitError (String : See below : IRW)
	// If +link{partialCommit} is set to "prevent", the text to display to the user if they try 
    // to commit a dataset containing errors.  By default, this text is "There are errors in your 
    // data.  Please correct all errors before clicking Commit"
    //
    // @visibility external
	//<
    partialCommitError: "There are errors in your data.  Please correct all errors before " + 
                        "clicking Commit",
	
	//> @attr batchUploader.warnOnCancel (boolean : true : IRW)
	// If set, indicates that a warning dialog should be shown when Cancel is clicked, asking 
    // the user to confirm that this is really what they want to do. The actual warning message
    // is specified with +link{cancelConfirmMessage}
    //
    // @visibility external
	//<
    warnOnCancel: true,

	//> @attr batchUploader.cancelConfirmMessage (String : See below : IRW)
	// Confirmation message to show if the user clicks the "Cancel" button and +link{warnOnCancel}
    // is true.  Defaults to "You will lose any work you have done on this data. Proceed anyway?"
    //
    // @visibility external
	//<
    cancelConfirmMessage: "You will lose any work you have done on this data. Proceed anyway?",
    
	initWidget : function () {
		this.Super("initWidget", arguments);
        if (!this.uploadFormFields) this.uploadFormFields = [];
        this.uploadFormFields.add({name: "file", type: "file", title:this.uploadFileLabel});
        this.uploadFormFields.add({name: "dsName", type: "hidden", 
            defaultValue: isc.DataSource.getDataSource(this.uploadDataSource).ID});
		this.addAutoChild("uploadForm", {
			fields : this.uploadFormFields
		});
		this.addAutoChild("uploadButton");
        
        // Stamp our form's special updateOperation onto the fileItemForm it contains, because
        // this is the form that actually gets submitted to the server
        var fileItemForm = this.uploadForm.getFileItemForm();
        if (fileItemForm) fileItemForm.updateOperation = this.uploadForm.updateOperation;

        // Get the utility DataSource's XML definition from the server
        var uploader = this;
        isc.XMLTools.loadXML(isc.Page.getURL("[APP]shared/ds/batchUpload.ds.xml"), 
            function(xmlDoc, xmlText){
                uploader.createUploadDataSource(xmlDoc, xmlText);
            });
	},
    
    // Convert the XML definition to JS and use it to create our DataSource
    createUploadDataSource : function(xmlDoc, xmlText) {
        var jsDS = isc.XMLTools.toJS(xmlDoc);
        
        // A bit of a pain - if we only have one operationBinding (and we do), this gets 
        // translated as an operationBindings Object encapsulating a single operationBinding
        // Object, but downstream code requires that operationBindings be an Array.
        if (!isc.isAn.Array(jsDS.operationBindings)) {
            jsDS.operationBindings = [jsDS.operationBindings.operationBinding];
        }
        isc.DataSource.create(jsDS);
    },
	
	upload : function () {
        
        // Unset the datasource prior to validating our form.  We are only using the datasource
        // as a means of uploading the file, but SmartClient thinks we'll have databindings in
        // there; when it finds none, it gets confused and doesn't apply any client-side 
        // validations (Note: deliberately not using the setter because we don't want that
        // behavior, we just want the dataSource to appear null to the validation routine)
        this.uploadForm.dataSource = null;
        if (!this.uploadForm.validate(false, false)) return;

        this.uploadForm.dataSource = "batchUpload";
        
    	isc.rpc.startQueue();
        var attrs = this.uploadForm.fields;
        for (var i = 0; i < attrs.length; i++) {
            attrs[i].value = this.uploadForm.getValue(attrs[i].name);
        }
		var uploader = this;
        isc.DMI.call("isc_builtin", "com.isomorphic.tools.BuiltinRPC", "setAttributes", 
                     "session", attrs, this.uploadFieldPrefix, null);
        this.uploadForm.saveData(function (dsResp, data, dsReq) {
            uploader.uploadReply(data);
        });
        isc.rpc.sendQueue();
	},
    
	uploadReply : function (data) {
		var grid = this.grid;
        if (!grid) {
            if (isc.ListGrid) { // Ensure grids module is loaded
                grid = this.addAutoChild("grid");
                this.addAutoChildren(["cancelCommitButtonLayout", "commitButton", "cancelButton"]);
            }
        }
        grid.setDataSource(this.uploadDataSource);
		grid.setData(data.gridRows); 
		if (data.errors) {
		    for (var i = 0; i < data.errors.length; i++) {
		        var error = data.errors[i];
		        isc.logWarn("rowNum: "+error.rowNum+", error: " + isc.echoAll(error.errors));
		        grid.setRowErrors(error.rowNum, error.errors);
		    }
		    // scroll first error into view              
		    var firstError = data.errors[0].rowNum;
		    grid.delayCall("scrollRecordIntoView", [firstError]);
        }
        grid.show();
    },
    
    commitClicked : function () {
        
        var grid = this.grid,
    	    data = grid.data,
            errors = false;
            
        for (var i = 0; i < data.length; i++) {
            if (grid.getRowErrors(i)) {
                errors = true;
                break;
            }
        }
        
        if (errors) {
            if (this.partialCommit == "prevent") {
                isc.say(this.partialCommitError);
                return;
            }
            if (this.partialCommit == "prompt") {
                var _this = this;
                isc.warn(this.partialCommitPrompt, function (value) {
                    if (value) _this.commit();
                }, {buttons: [isc.Dialog.OK, isc.Dialog.CANCEL]});
                return;
            }
        }
        
        this.commit();
    },
    
    commit : function () {
        
    	var data = this.grid.data,
            _this = this;
                    
        for (var i = 0; i < data.length; i++)
    	isc.rpc.startQueue();
        var ds = isc.DataSource.getDataSource(this.grid.dataSource);
    	for (var i = 0; i < data.length; i++) {
    		ds.addData(this.grid.getEditedRecord(i), function () {
                isc.say("Records added", function () {
                    _this.cleanup();
                })
            });
    	}
    	isc.rpc.sendQueue();
    },
    
    cancelClicked : function () {

        if (this.warnOnCancel) {
            var _this = this;
            isc.warn(this.cancelConfirmMessage, function (value) {
                if (value) _this.cleanup();
            }, {buttons: [isc.Dialog.OK, isc.Dialog.CANCEL]});
            return;
        }
        this.cleanup();
    },
    
    cleanup: function(){
        this.grid.destroy();
        this.grid = null;
        this.cancelCommitButtonLayout.destroy();
        this.cancelCommitButtonLayout = null;
        this.commitButton.destroy();
        this.commitButton = null;
        this.cancelButton.destroy();
        this.cancelButton = null;
    }

	
});
