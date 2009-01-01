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

 




isc.Canvas.addMethods({
    // create a DSRequest object in the context of a dataBound component, by gathering
    // various component-level settings that affect how an operation is performed, and 
    // creating a dsRequest object (called a "context" for legacy reasons)
    buildRequest : function (context, operationType, callback) {
		if (!context) context = {};

        // "afterFlowCallback": supported by the DataSource system, this is a second callback
        // that fires after dsRequest.callback.  This is a convenience for action methods which
        // need to call a basic dataSource method (eg ds.updateData()) and get called back to
        // do post-processing and *also* need to provide a callback to the end developer.
        // "afterFlowCallback" fires after the callback passed to dataSource methods like
        // addData().
        if (callback) context.afterFlowCallback = callback;
    
        // text match style: 
        // - support the legacy "filter" operationType.
        // - pick up setting on ListGrids and DynamicForms
        if (operationType == "filter") {
            operationType = "fetch";
            // If textMatchStyle was explicitly specified respect it - otherwise mark
            // as a substring match (filter rather than fetch)
            if (context.textMatchStyle == null) context.textMatchStyle = "substring";
        }
        if (this.textMatchStyle != null) context.textMatchStyle = this.textMatchStyle;
        
        // support old operationType synonyms
        operationType = isc.DS._getStandardOperationType(operationType);

        // pick up component.dataPageSize for fetches
        if (this.dataPageSize) context.dataPageSize = this.dataPageSize;

        // pick up an operation name from the component, according to the type of operation
        // being performed.  NOTE: if context.operation is already specified, give it
        // precedence, as this indicates manual invocation with an explicitly specified
        // operation.
        var operation = context.operationId || context.operation;
        if (operation == null) {
            switch (operationType) {
                // NOTE: "saveOperation", "deleteOperation" and the non-specific
                // "this.operation"  are backCompat
                case "fetch":
                    operation = this.fetchOperation; break;
                case "add":
                    operation = this.addOperation || this.saveOperation; break;
                case "update":
                    operation = this.updateOperation || this.saveOperation; break;
                case "remove":
                    operation = this.removeOperation || this.deleteOperation; break;
                case "validate":
                    operation = this.validateOperation; break;
            }
            context.operation = operation || this.operation;
        }
        // add component ID
        context.componentId = this.ID;
        
        return isc.rpc.addDefaultOperation(context, this.dataSource, operationType);
    },
    
    // create a ResultTree dataModel based on the component's current config
    createResultTree : function (criteria, callback, requestProperties, type) {
        // The callback is passed in from fetchData() so should be fired when the server
        // responds with the requested nodes.
        this._initialFetchCallback = callback;

        if (type == null) type = "fetch";
        if ( requestProperties == null ) requestProperties = {};
        requestProperties.afterFlowCallback = {target:this, methodName:"_fireFetchCallback"};

        // put together Tree-specific properties for the data model we're auto-creating
        var tree = isc.addProperties({initialData: this.initialData},
                                     this.dataProperties,
                                     requestProperties.dataProperties
                                     //>!BackCompat 2006.10.19
                                     // Provide back-compat support for 'treeProperties' 
                                     ,this.treeProperties,
                                     requestProperties.treeProperties
                                     //<!BackCompat
                                     );
        tree.criteria = criteria;
        tree.operation = requestProperties.operation;
        tree.context = requestProperties;
        tree.dataSource = this.dataSource;
        tree.componentId = this.ID;
        // mark as autoCreated so it gets auto-destroyed, removing DS<->RS links
        tree._autoCreated = true;
        // pick up load data on demand for TreeGrids
        if (this.loadDataOnDemand != null) tree.loadDataOnDemand = this.loadDataOnDemand;

        // for multi-DS trees: cross-DS relations
        if (this.treeDataRelations) tree.treeRelations = this.treeDataRelations;
        if (this.multiDSTree != null) tree.multiDSTree = this.multiDSTree;

        var resultTreeClass = this.getDataSource().resultTreeClass || "ResultTree";
        return isc.ClassFactory.getClass(resultTreeClass).create(tree);
    },
    _fireFetchCallback : function (dsResponse,data,dsRequest) {
        // callback fired whenever we get new data from the server.
        // use this to fire the callback passed into fetchData if there was one (and then
        // drop that callback so we don't fire it repeatedly as the user opens child-nodes etc)
        if (this._initialFetchCallback) {
            this.fireCallback(this._initialFetchCallback, "dsResponse,data,dsRequest", arguments);
            delete this._initialFetchCallback;
        }
    }
});

//>ValuesManager : add buildRequest to ValuesManager, which isn't a Canvas
if (isc.ValuesManager) {
    isc.ValuesManager.addMethods({
        buildRequest : isc.Canvas.getInstanceProperty("buildRequest")
    });
}
//<ValuesManager

// Many flow methods are identical on databound DynamicForms and ValuesManagers.
// Define these methods in an interface to mix into both classes.

isc.ClassFactory.defineInterface("EditorActionMethods");

isc.EditorActionMethods.addInterfaceMethods({
    
    // Editing and Saving
    //-------------------------------------------------------------------------------

    //>!BackCompat 2004.7.23
	save : function (context) { return this.saveData(context) },
	editSelected : function (selectionComponent, context) { 
        return this.editSelectedData(selectionComponent, context) 
    },
	editNew : function (initialValues, context) { 
        return this.editNewRecord(initialValues, context) 
    },
    //<!BackCompat
    
    // NOTE: editNewRecord / editRecord / editSelectedData et al do not go to the server,
    // although in a future implementation of editSelected() it may be necessary to go to the
    // server to get fields not being shown in the selection component.

    //>	@method dynamicForm.editNewRecord()
    //
    // Prepare to edit a new record by clearing the current set of values (or replacing them 
    // with initialValues if specified).
    // <br>
    // This method will also call +link{DynamicForm.setSaveOperationType()} to ensure
    // subsequent calls to <code>saveData()</code> will use an <code>add</code> rather than
    // an <code>update</code> operation.
    //
    // @param [initialValues] (object)
    //     initial set of values for the editor as a map of field names to their corresponding
    //     values
    // @see dynamicForm.saveData()
    //
    // @group dataBoundComponentMethods
    // @visibility external
    //<
	editNewRecord : function (initialValues) {
        this.setSaveOperationType("add");
		this._editRecord(initialValues);
	},
    
    //>	@method dynamicForm.editRecord()
    //
    // Edit an existing record.  Updates this editors values to match the values of the record 
    // passed in.
    // <P>
    // This method will also call +link{DynamicForm.setSaveOperationType()} to ensure 
    // subsequent calls to <code>saveData()</code> will use an <code>update</code> rather than
    // an <code>add</code> operation.
    //
    // @param record (ListGridRecord)
    //     the record to be edited as a map of field names to their corresponding values
    // @see dynamicForm.saveData()
    //
    // @group dataBoundComponentMethods
    // @visibility external
    //<
	editRecord : function (record) {        
        this.setSaveOperationType("update");
        this._editRecord(record);
	},
    
    _editRecord : function (record) {
        delete this._editRecordNum;
        delete this._editList;
        var record = isc.addProperties({}, record);
        this.setData(record);
    },

    //>	@method dynamicForm.editSelectedData()
    //
    // Edit the record selected in the specified selection component (typically a
    // +link{ListGrid}).
    // <P>
    // Updates the values of this editor to match the selected record's values.
    // <P>
    // If this form has a dataSource, then saving via +link{saveData()} will use the 
    // "update" operation type.
    //
    // @param selectionComponent (ListGrid or ID)
    //     the ListGrid or ID of a +link{ListGrid} whose currently selected
    //     record(s) is/are to be edited
    // @see dynamicForm.saveData()
    //
    // @group dataBoundComponentMethods
    // @visibility external
    // @example updateOperation
    //<
    editSelectedData : function (selectionComponent) {
        // support being passed an ID
        if (isc.isA.String(selectionComponent)) selectionComponent = window[selectionComponent];
        if (!selectionComponent) return;
        
        var selection = selectionComponent.selection.getSelection();
        if (selection && selection.length > 0) this.editList(selection);    
	},			

	editList : function (recordList) {
        this.setSaveOperationType("update");
		this._editRecords(recordList);
	},
    
    // actually start editing a recordList (start with the first record in the list) 
    _editRecords : function (recordList) {
        this._editRecordNum = 0;
        this._editList = recordList;
        var record = isc.addProperties({},recordList[this._editRecordNum]);
        this.setData(record);
    },
    editNextRecord : function () {
        this.editOtherRecord(true);
	},

   	editPrevRecord : function () {
        this.editOtherRecord(false);
	},

    editOtherRecord : function (next) {
        // not valid if we never had a call to editList.
        if (!this._editList) return;
        
		if (this.isVisible() && this.valuesHaveChanged()) {
            // remember whether we're editing next or previous
            this._next = next;

            this.saveData({target:this, methodName:"editOtherReply"});
            return;
        };
        
        if (next && this._editRecordNum >= this._editList.length-1) {
            this.logWarn("Unable to edit next record - this is the last selected record");
            return false;
        }
        if (!next && this._editRecordNum <= 0) {
            this.logWarn("Unable to edit previous record - this is the first selected record");
            return false;
        }
        this._editRecordNum += (next ? 1 : -1);
        var nextRecord = isc.addProperties({}, this._editList[this._editRecordNum]);
        this.setData(nextRecord);
    },
	// reply to the 'save editor' call
	editOtherReply : function (response, data, request) {
		
        var next = this._next;
        delete this._next;
        
		// error occurred: the presence of response.errors indicates it's a validation error, which
		// we can handle.  Note we assume the developer meant a validation error if
        // response.errors was provided, regardless of whether you set the correct validation
        // error status code.
		if (response.status < 0 && response.errors) {
			return this.setErrors(response.errors, true);
		}

		// some error we weren't expecting occurred, bail with an error dialog
		if (response.status < 0) return isc.RPCManager._handleError(response, request);
        
        // remember the values in the form and in the _editlist...
        this.rememberValues();
        this._editList[this._editRecordNum] = this.getValues();
        
        // call editOther - to show the next record
        this.editOtherRecord(next)
		return true;
	},
    
    
    //> @method dynamicForm.validateData()
    //
    // Perform validation on the client and the server.
    //
    // @group validation
    // @visibility external
    //<
    validateData : function (callback, requestProperties) {
        // do simple client side validation first 
        if (!this.validate()) return false;
        var values = this.getValues();
        
        // validate the data on the server
        // Note: As written, if a callback is not supplied we use 'saveDataReply' which will
        // redraw the form to show errors - otherwise we rely on the callback to apply errors
        // to the form.
        var context = this.buildRequest(requestProperties, "validate");
    
        context.willHandleError = true;
        context.editor = this;

        // valuesAsParams - also sends the DSRequest values as request parameters
        if (context.valuesAsParams) {
            if (!context.params) context.params = {};
            isc.addProperties(context.params, values);
        }

		var dataSource = this.getDataSource();
        return dataSource.performDSOperation(
                    context.operation.type, values, 
                    callback ? callback : {target:this, methodName:"saveEditorReply"}, 
                    context
                );
    },

    //>	@method	dynamicForm.reset()   ([])
    //
    // Resets values to the state it was the last time <code>setValues()</code> or
    // <code>rememberValues()</code> was called. If neither of those methods has been called,
    // values will be set back to their inital values at init time.
    //
    // @group formValues
    // @visibility external
    //<
    reset : function () {
        this.resetValues();
    },

    //> @method dynamicForm.cancel() ([])
    //
    // This method exists for clean integration with existing server frameworks that have a 'cancel'
    // feature which typically clears session state associated with the form.  When this method is
    // called, an RPC is sent to the server with a parameter named
    // +link{attr:DynamicForm.cancelParamName} with the value
    // +link{attr:DynamicForm.cancelParamValue}.<p>
    //
    // Note that no other form data is sent.  By default the current top-level page is replaced with the
    // reply.  If you wish to ignore the server reply instead, call this method like this:
    // <pre>
    // dynamicFormInstance.cancel({ignoreTimeout: true, target: null});
    // </pre>
    //
    // @param [requestProperties] (DSRequest)   additional properties to set on the RPCRequest
    //                                          that will be issued
    // @group submitting
    // @visibility external
    //<
    cancel : function (requestProps) {
        var cancelRPC = {
            actionURL: this.action,
            target: window,
            sendNoQueue: true,
            ignoreTimeout: true,
            useXmlHttpRequest: false,
            params: { }, // set below
            useSimpleHttp: true
        };
        cancelRPC.params[this.cancelParamName] = this.cancelParamValue;

        //>DEBUG
        if (!cancelRPC.actionURL) {
            this.logWarn("No actionURL defined for the cancel RPC - set 'action' on your form or"
                         + "provide an actionURL in the requestProperties to cancel()");
            return;
        }
        //<DEBUG

        isc.addProperties(cancelRPC, requestProps);
        
        isc.rpc.sendRequest(cancelRPC);
    },

    //>	@method	dynamicForm.submit()
    // <code>submit()</code> is automatically called when a +link{SubmitItem} included in the
    // form is clicked, or, if +link{dynamicForm.saveOnEnter,saveOnEnter} is set, when the
    // "Enter" key is pressed in a text input.  Submit can also be manually called.
    // <P>
    // If +link{dynamicForm.submitValues(),form.submitValues()} exists, it will be called, then
    // immediately return.
    // <P>
    // Otherwise, default behavior varies based on +link{dynamicForm.canSubmit,form.canSubmit}: if
    // <code>canSubmit</code> is false, +link{method:dynamicForm.saveData()} will be called to
    // handle saving via SmartClient databinding.  
    // <P>
    // If <code>canSubmit</code> is true, the form will be submitted like an ordinary HTML
    // form via +link{dynamicForm.submitForm()}.
    // <P>
    // The parameters to <code>submit()</code> apply only if <code>submit()</code> will be
    // calling +link{saveData()}.  If you override <code>submit()</code>, you can safely
    // ignore the parameters as SmartClient framework code does not pass them.
    // 
    // @param [callback]          (DSCallback)  callback to invoke on completion.
    //                                          [Ignored if this.canSubmit is true]
    // @param [requestProperties] (DSRequest)   additional properties to set on the DSRequest
    //                                          that will be issued
    //                                          [Ignored if this.canSubmit is true]    
    // @group dataBoundComponentMethods
    // @see method:dynamicForm.submitValues()
    // @visibility external
    //<
    submit : function (callback, requestProps) {
        if (this.submitValues != null) {
            return this.submitValues(this.getValues(), this);
        }
        if (this.canSubmit) return this.submitForm();
        else return this.saveData(callback, requestProps);
    },

    // returns true if calling saveData() will perform the add operation, false otherwise.
    // Note that the operationType can be overridden by the optional requestProperties arg to
    // saveData.
    
    saveOperationIsAdd : function () {
        if (this.saveOperationType) return this.saveOperationType == "add";
    
        if (this.dataSource) {
            var ds = isc.DataSource.getDataSource(this.dataSource);
            return !ds.recordHasAllKeys(this.getValues());
        }
        return false;
    },

    //>	@method dynamicForm.saveData()
    //
    // Validate and then save the form's current values to the +link{DataSource} this form is
    // bound to.
    // <p>
    // If client-side validators are defined, they are executed first, and if any errors are
    // found the save is aborted and the form will show the errors.
    // <p>
    // If client-side validation passes, a +link{DSRequest} will be sent, exactly as though
    // +link{dataSource.addData()} or +link{dataSource.updateData()} had been called with 
    // +link{dynamicForm.getValues(),the form's values} as data.  The
    // +link{dsRequest.operationType} will be either "update" or "add", depending on the
    // <code>requestProperties</code> passed in, and the current 
    // +link{DynamicForm.saveOperationType}.
    // <P>
    // On either a client-side or server-side validation failure, validation errors will be
    // displayed in the form.  Visible items within a DynamicForms will be redrawn to display
    // errors. Validation failure occuring on hidden items, or DataSource fields with no 
    // associated form items may be handled via +link{DynamicForm.handleHiddenValidationErrors}
    // or +link{ValuesManager.handleHiddenValidationErrors}.
    // <P>
    // +link{dynamicForm.validationURL,validationURL} can be set to do validation against a
    // different URL from where the form will ultimately save, as part of an incremental
    // upgrade strategy for Struts and Struts-like applications.
    //
    // @param [callback]          (DSCallback)  callback to invoke on completion
    // @param [requestProperties] (DSRequest)   additional properties to set on the DSRequest
    //                                            that will be issued
    //
    // @group dataBoundComponentMethods
    // @visibility external
    // @example addOperation
    //<
    // NOTE: not documenting direct submit (If the editor is a multi-part encoded dynamicForm,
    // a direct submit will be performed.)
    saveData : function (callback, requestProperties, noValidation) {
        if (this.dataSource == null) {
            
            this.logWarn("saveData() called on a non-databound DynamicForm. This is not supported. " +
                       " for information on databinding of components look at the documentation" +
                       " for the DataSource class.  " +
                       "If this was intended to be a native HTML form submission, set the " +
                       "canSubmit property to true on this form.");
            return;
        }
       
        //>!BackCompat 2005.3.21 old signature: criteria, requestProperties
        if (requestProperties == null && isc.isAn.Object(callback) && 
            callback.methodName == null) 
        {
            // old style call, second param (callback) is really requestParams
            requestProperties = callback;
            callback = requestProperties.afterFlowCallback;
        } //<!BackCompat

        // do server validation if validationURL is specified            
        if (this.validationURL && !noValidation) {
            var validateProps = {};
            isc.addProperties(validateProps, requestProperties);
            isc.addProperties(validateProps, {
                actionURL: this.validationURL,
                valuesAsParams: true,
                sendNoQueue: true
            });
            validateProps._userProps = requestProperties;
            validateProps._userCallback = callback;            

            // set a special flag to prevent the validation run called by saveData() from
            // clearing any validation errors currently visible in the form if client-side
            // validation succeeds.  When we're in validationURL mode, typically the server
            // will be supplying these errors and it looks lame when the form redraws between
            // validation submits.
            this.performingServerValidation = true;

            this.validateData(this.getID()+"._saveFormValidateCallback(rpcRequest,rpcResponse,data)",
                              validateProps);
            return;
        }
        // If we're showing a fileItem, we'll have to perform a native commit of the fileItemForm
        // rather than submitting our values in the normal way
        var fileItemForm = this.getFileItemForm();
        if (fileItemForm) {
            // copy values across
            var vals = this.getValues(),
                uploadField = fileItemForm.getItem(0).getFieldName();
            delete vals[uploadField]; 
            for (var fieldName in vals) {
                fileItemForm.setValue(fieldName, vals[fieldName]);
            }
            
            // ensure action / target match
            fileItemForm.action = this.action;
            fileItemForm.target = this.target;
            fileItemForm.dataSource = this.dataSource;
            
            // validators are not duplicated on the fileItem form so explicitly validate now
            if (!this.validate()) return false;
            
            return fileItemForm.saveData(callback, requestProperties, noValidation);
        }
        
        var operationType = this.getSaveOperationType(requestProperties);

        // hold on to end user callback, and pass our own to the RPC layer.  We do this to
        // provide the formSaved() mechanism that fires before the end user callback.
        this._userCallback = callback;
      
        callback = this.getID()+"._saveDataReply(dsRequest, dsResponse, data)";
		requestProperties = this.buildRequest(requestProperties, operationType, callback);

        // send oldValues to allow long transactions
        requestProperties.oldValues = this._oldValues;

        // if the form specified an action different from the default, use it as the RPC target
        var doSubmit = false;
        
        if (this.submitParamsOnly) requestProperties.useSimpleHttp = true;

        // DynamicForm-specific code (does not apply to ValuesManager)
        if (isc.DynamicForm && isc.isA.DynamicForm(this)) {
            if (this.action != isc.DynamicForm.getInstanceProperty("action")) {
                requestProperties.actionURL = this.action;
                requestProperties.target = this.target ? this.target : window;
                doSubmit = true;
            }   
    
            // override the httpMethod on the request if the user specified a custom 'method'
            if (this.method != isc.DynamicForm.getInstanceProperty("method")) {
                requestProperties.httpMethod = this.method;
            }
        }
        
        if (!this.validate()) return false
        var values = this.getValues();        
        
        // perform a direct submit if the form is multipart-encoded
        
        if ((isc.DynamicForm && isc.isA.DynamicForm(this) && this.isMultipart())
            || this.canSubmit || doSubmit)
        {
            return this.submitEditorValues(values, requestProperties.operation, 
                                           requestProperties.callback, requestProperties);
        } else {
            return this.saveEditorValues(values, requestProperties.operation,
                                         requestProperties.callback, requestProperties);
        }

	},
    
    // Technically saveOperationType is initializable (IRW rather than just RW) but we don't really
    // anticipate it being used this way
    //> @attr DynamicForm.saveOperationType (DSOperation : null : RW)
    // Default +link{DSOperationType} to be performed when +link{DynamicForm.saveData()} is called.
    // This property is automatically set on a call to +link{DynamicForm.editRecord()} or
    // +link{DynamicForm.editNewRecord()}, or may be set directly via 
    // +link{DynamicForm.setSaveOperationType()}.
    // @visibility external
    // @getter DynamicForm.getSaveOperationType()
    //<
    
    //> @method DynamicForm.setSaveOperationType()
    // Setter for the default +link{DSOperationType} when +link{DyanmicForm.saveData()} is called.
    // Note that this property can also be set by calling +link{DynamicForm.editRecord()} or 
    // +link{DynamicForm.editNewRecord()}
    // @param operationType (DSOperationType) Operation type to use as a default. Valid values are
    //  <code>"add"</code> or <code>"update"</code>.
    // @visibility external
    //<
    setSaveOperationType : function (operationType) {
        this.saveOperationType = operationType;
    },
    
    //> @method DynamicForm.getSaveOperationType()
    // Returns the +link{DSOperationType} to be performed when +link{DynamicForm.saveData()} is
    // called. Valid options are <code>"add"</code> or <code>"update"</code>.
    // <P>
    // If a +link{DSRequest} configuration object is passed in containing an explicit operationType
    // this will be returned. Otherwise +link{DynamicForm.saveOperationType} will be returned.
    // @param [requestProperties] (DSRequest properties) Optional DSRequest config block for the
    //  save operation
    // @return (DSOperationType) Operation type for the save request.
    // @visibility external
    //<
    getSaveOperationType : function (requestProperties) {
        
        var operationType;
        // If no operation was passed in, we're going to have to auto generate one.
        if (!requestProperties || !requestProperties.operation) {
            // Insert or Update?
            // If the operationType is not passed in, use this.saveOperationType (set by
            // editNew et al)
            operationType = (requestProperties && requestProperties.operationType)  
                             ? requestProperties.operationType 
                             : this.saveOperationType;
            // If the saveOperatonType wasn't explicitly provided base it on whether the
            // primary keys for the record are present and whether they've been modified
            
            if (!operationType && this.dataSource != null) {
            
                var pkFields = isc.DataSource.getDataSource(this.dataSource).getPrimaryKeyFieldNames(),
                    values = this.getValues(),
                    undef;
                for (var i = 0; i < pkFields.length; i++) {
                    var key = pkFields[i],
                        value = values[pkFields];
                    if (value == null) {
                        //this.logWarn('saveData(): has no value for a primary key field:' + key 
                        //              + ', assuming this is an add (pk will be genereated by server)');                    
                        operationType = "add";
                        break;
                    }
                    
                    if (this._oldValues[key] !== undef && this._oldValues[key] != value) {
                        //this.logWarn("saveData(): primary key field:" + key + " has been modified" +
                        //             " assuming this is an add operation");
                        operationType = "add";
                    }
                    
                    var item = this.getItem(key);
                    if (item && (item.shouldSaveValue && item.isEditable())) {
                        //this.logWarn("saveData(): value for primary key is editable - assuming this is an add");
                        operationType = "add" 
                        break;
                    }
                }
                // In this case, every primary key is present and either
                // - doesn't have a form item
                // - the form item is not editable (or not being saved out)
                // So we assume it's unchanged, making this an update of an existing record
                if (operationType == null) {
                    //this.logWarn("saveData(): all primary key fields are present for the record, " + 
                    //             "and not editable / edited, so assuming this is an update operation");        
                    operationType = "update";
                }
            }
        }
        
        
        return operationType;
    },
    
    // form.saveData() internal callback
    _saveDataReply : function (request, response, data) {
        // this var keeps the index of the next formItem that we need to call formSaved() on.
        this._formSavedIndex = 0;
        
        // If 'data' is passed back from the server, update this.values with the saved data, except
        // for fields that have subsequently been further updated
        // Exceptions 
        // - provide a non obfuscated flag to suppress this data synch
        // - If the server threw an error the data object may be a simple error message
        if (!this.suppressServerDataSync && response && response.status >= 0 && data != null) {
            if (isc.isAn.Array(data)) data = data[0];
            // Note: if request.originalData is present, use this rather than request.data
            // This handles the case where request.data may have been reformatted / modified before
            // sending to the server
            // [For example see restDataSource / postMessage dataProtocol where request.data will
            //  be a serialized block of XML]
            // request.originalData matches the values as it was retrieved from the form when
            // the save was kicked off.
            // For iscServer operations use request.data
            // - this object will already be in the "standard" format, and we don't save off
            //   request.originalData in this code-path 
            var submittedValues =(request.originalData || request.data),
                currentValues = this.getValues();
            for (var i in data) {
                // We're making the assumption that any fields not present in the data object are
                // unchanged
                var field = this.getField(i);
                if (!this.fieldValuesAreEqual(field, submittedValues[i],data[i]) &&
                    this.fieldValuesAreEqual(field, currentValues[i], submittedValues[i])) 
                {
                    this.setValue(i, data[i]);
                }
            }
        }
        
        this._callbackState = {
            request: request,
            response: response,
            data: data
        };
        this.formSavedComplete();
    },
    
    // notify every FormItem that the form has finished saving.  Used to allow items such as
    // the MultiFileItem to save records which are related a newly created record created by
    // saving of the main form.
    formSavedComplete : function () {

        var fields = this.getFields();
        for (var i = this._formSavedIndex; i < fields.length; i++) {
            this._formSavedIndex++;
            var field = fields[i];
            // call formSaved on the formItem, if defined.  If formSaved() returns false, that
            // means it's going to do some async processing and call this method again when
            // complete.
            if (isc.isA.Function(field.formSaved) && 
                field.formSaved(this._callbackState.request, this._callbackState.response, 
                                this._callbackState.data) === false) return;
        }

        // the _userCallback is the original callback specified by the user to saveData().
        // Once we've completed all formSaved() calls, call the user back.
        if (this._userCallback) {
            this.fireCallback(this._userCallback, "dsResponse,data,dsRequest", 
                                            [this._callbackState.response,
                                             this._callbackState.data,
                                             this._callbackState.request]);
        }
        delete this._userCallbackState;
        delete this._userCallback;
    },
    
	// save the given values, displaying any server-side validation errors in the given editor
	saveEditorValues : function (values, saveOperation, callback, context) {
        
        var undefined;
		if (!context) context = {};
		isc.addProperties(context, {
			prompt:(context.prompt || isc.RPCManager.saveDataPrompt),
			editor:this,
			willHandleError:true
		});

        // valuesAsParams - also sends the DSRequest values as request parameters
        if (context.valuesAsParams) {
            if (!context.params) context.params = {};
            isc.addProperties(context.params, values);
        }

    	var dataSource = this.getDataSource();

        return dataSource.performDSOperation(
                    saveOperation.type, values,
                    callback ? callback : {target:this, methodName:"saveEditorReply"}, context);

	},
	
	// save the given values via direct submit, displaying any server-side validation errors in
    // the given editor
	submitEditorValues : function (values, saveOperation, callback, context) {
		
		if (!context) context = {};
		isc.addProperties(context, {
            directSubmit : true,
            submitForm : this
        });
        return this.saveEditorValues(values, saveOperation, callback, context);
	},    
    
    // reply to the 'save editor' call
	saveEditorReply : function (response, data, request) {
        // error occurred: the presence of results.errors indicates it's a validation error,
        // which we can handle.  XXX should really check for status == validation error constant
		if (response.status == isc.RPCResponse.STATUS_VALIDATION_ERROR && response.errors) {
			this.setErrors(response.errors, true);
            return false; // return false to avoid the end user callback being called
		}

		// some error we weren't expecting occurred, bail with an error dialog
		if (response.status < 0) return isc.RPCManager._handleError(response, request);
        
		return true;
	},    

    _saveFormValidateCallback : function (rpcRequest, rpcResponse, data) {
        if(rpcResponse.status == isc.RPCResponse.STATUS_SUCCESS) {
            this.performingServerValidation = false;
            this.markForRedraw("serverValidationSuccess");
            this.saveData(rpcRequest._userCallback, rpcRequest._userProps, true);
            rpcRequest._userCallback = null;
            rpcRequest._userProps = null;
        } else {
            this.setErrors(rpcResponse.errors, true);
        }
    }
    
});

if (isc.DynamicForm) isc.ClassFactory.mixInInterface("DynamicForm", "EditorActionMethods");

// Overrides to existing methods on the DF class
isc._EditorFlowOverrides = {
    //>	@method DynamicForm.fetchData()
    // Retrieve data that matches the provided criteria, and edit the first record returned
    // 
    // @param [criteria]          (Criteria)	  search criteria
    // @param [callback]          (DSCallback)  callback to invoke on completion
    // @param [requestProperties] (DSRequest)   additional properties to set on the DSRequest
    //                                            that will be issued
    //
    // @group dataBoundComponentMethods
    // @visibility external
    //<
    fetchData : function (criteria, callback, requestProperties) {
        var ds = this.getDataSource();
        if (!ds) {
            this.logWarn("Ignoring call to fetchData() on a DynamicForm with no valid dataSource");
            return;
        }
        if (this._fetchDataCallbackArr == null) this._fetchDataCallbackArr = [];
        this._fetchDataCallbackArr.add(callback); 
        ds.fetchData(criteria, {target:this, methodName:"fetchDataReply"}, requestProperties);
    },
    
    fetchDataReply : function (response, data, request) {
        var record = data ? data.get(0) : null;
        this.editRecord(record);
        var callback = this._fetchDataCallbackArr.pop();
        if (callback) this.fireCallback(callback, "dsResponse,data,dsRequest", [response,data,request]);
    },
    
    //>	@method DynamicForm.filterData()
    // Retrieve data that matches the provided criteria, and edit the first record returned.<br>
    // Differs from +link{DynamicForm.fetchData()} in that a case insensitive substring match
    // will be performed against the criteria to retrieve the data.
    // 
    // @param [criteria]          (Criteria)	  search criteria
    // @param [callback]          (DSCallback)  callback to invoke on completion
    // @param [requestProperties] (DSRequest)   additional properties to set on the DSRequest
    //                                            that will be issued
    //
    // @group dataBoundComponentMethods
    // @visibility external
    //<    
    filterData : function (criteria, callback, requestProperties) {
        var ds = this.getDataSource();
        if (!ds) {
            this.logWarn("Ignoring call to filterData() on a DynamicForm with no valid dataSource");
            return;
        }
        if (this._fetchDataCallbackArr == null) this._fetchDataCallbackArr = [];
        this._fetchDataCallbackArr.add(callback); 
        ds.filterData(criteria, {target:this, methodName:"fetchDataReply"}, requestProperties);
    }
}

if (isc.DynamicForm) isc.DynamicForm.addMethods(isc._EditorFlowOverrides);


//>ValuesManager
if (isc.ValuesManager) isc.ClassFactory.mixInInterface("ValuesManager", "EditorActionMethods");

if (isc.ValuesManager) isc.ValuesManager.addMethods(isc._EditorFlowOverrides);

// Pick up fieldValuesAreEqual from the DataBoundComponent methods.

if (isc.ValuesManager) {
    isc.ValuesManager.addProperties({
        // apply the standard fieldValuesAreEqual method to ValueMaps as well as Canvii
        fieldValuesAreEqual:isc.Canvas.getPrototype().fieldValuesAreEqual
    })
}

// Add JSDocs to the ValuesManager as well as the DynamicForm

// NOTE: filterData/clearCriteria are not documented because they are just
// convenience relative to summary.filterData/clearCriteria, and it's confusing/distracting
// for them to have the same names.   However these two methods were exposed briefly in
// 5.1. 

//>	@method valuesManager.doExport()
// @include dynamicForm.doExport()
//<

//>	@method valuesManager.editNewRecord()
// @include dynamicForm.editNewRecord()
//<

//>	@method valuesManager.editRecord()
// @include dynamicForm.editRecord()
//<

//> @attr valuesManager.saveOperationType
// @include dynamicForm.saveOperationType
//<

//> @method valuesManager.setSaveOperationType()
// @include dynamicForm.setSaveOperationType()
//<

//> @method valuesManager.getSaveOperationType()
// @include dynamicForm.getSaveOperationType()
//<

//>	@method valuesManager.editSelectedData()
// @include dynamicForm.editSelectedData()
//<

//>	@method valuesManager.saveData()
// @include dynamicForm.saveData()
//<

//>	@method valuesManager.submit()
// @include dynamicForm.submit()
//<

//>	@method valuesManager.cancel()
// @include dynamicForm.cancel()
//<

//> @method valuesManager.filterData()
// @include dynamicForm.filterData()
//<

//> @method valuesManager.fetchData()
// @include dynamicForm.fetchData()
//<

//<ValuesManager

if (isc.TreeGrid) {
    
isc.TreeGrid.addProperties({
    
    ignoreEmptyCriteria: true
});

isc.TreeGrid.addMethods({


    // TreeGrid.fetchData() / filterData() documented in DataboundComponent.js
    
    

    useExistingDataModel : function (criteria, operation, context) {
        return false;  // TreeGrid always builds a new tree
    },

    createDataModel : function (criteria, operation, context) {
        return this.createResultTree(criteria, context.afterFlowCallback, context, null);
    }    
    
});

}

// DETAIL VIEWING
// --------------------------------------------------------------------------------------------
if (isc.DetailViewer) {
    
isc.DetailViewer.addMethods({

    //>	@method detailViewer.viewSelectedData()
    //
    // Displays the currently selected record(s) of the selectionComponent widget (typically a
    // listGrid) in the detailViewer.
    //
    // @param selectionComponent (ListGrid or ID)
    //     the ListGrid or ID of a +link{ListGrid} whose currently selected
    //     record(s) is/are to be edited
    //
    // @group dataBoundComponentMethods
    // @visibility external
    //<
    // NOTE: technically, application.viewSelected() has a case where it will issue a DSRequest
    // to fetch the full set of fields, but we don't expose the capability to have a ListGrid
    // load less than the full set of fields right now.
    // @param [callback]         (DSCallback)    callback to invoke on completion
    // @param [requestProperties] (DSRequest)     additional properties to set on the
    //                                             DSRequest that will be issued
    viewSelectedData : function (selectionComponent, callback, requestProperties) {
        
        // support being passed an ID
        if (isc.isA.String(selectionComponent)) selectionComponent = window[selectionComponent];
    
        requestProperties = requestProperties || {};
        
        var selection = selectionComponent.selection.getSelection();
        if (selection && selection.length > 0) {
            
            // if we're not passed an operation, simply show the records from the selection in the
            // viewer
            if (!requestProperties.operation) {
                this.setData(selection);	
            
            
            } else {
    
                // We were passed an operation - perform it to get the record back from the server.
                // This would be required if (for example) the selection components operation is 
                // only getting a subset of fields
                
                // reduce the recordList to just the primary keys
                var operation = requestProperties.operation,
                    dataSource = this.getDataSource(),
                    keys = dataSource.filterPrimaryKeyFields(selection);
                
                if (requestProperties.prompt == null) 
                    requestProperties.prompt = isc.RPCManager.getViewRecordsPrompt;
                requestProperties.viewer = this;
                
                // actually perform the relevant operation       
                return dataSource.performDSOperation(
                                            operation.type, keys, 
                                            (callback ? callback : {target:this, methodName:"viewSelectedDataReply"}), 
                                            requestProperties
                        );
            }
        }
        return false;           
    },
    
    //>!BackCompat 2004.7.23
    viewSelected : function (selectionComponent, context) { 
        return this.viewSelectedData(selectionComponent, context)
    },
    //<!BackCompat
    
    // handle a reply from the viewSelectedData call
	viewSelectedDataReply : function (response, data, request) {
		this.setData(data);
	}
    
});

}
