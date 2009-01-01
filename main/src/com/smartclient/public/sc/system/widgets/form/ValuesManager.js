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

 


//>	@class	ValuesManager
//
// The ValuesManager manages data from multiple member forms.
// <P>
// If a single logical form needs to be separated into multiple DynamicForm instances for
// Layout purposes (for example, spanning one logical form across multiple Tabs), a
// ValuesManager can be used to make the forms act as one logical form, supporting all
// value-related APIs otherwise called on DynamicForm directly.
// <P>
// A ValuesManager has no visual representation - it is strictly a logical entity, and the
// member forms provide the user interface.  You can initialize a ValuesManager with a set of
// member forms (by setting +link{ValuesManager.members} at init) or add and remove member
// forms dynamically.
// <P>
// Calling +link{ValuesManager.setValues()} on a ValuesManager will automatically route new
// field values to whichever member form is showing an editor for that field.  Likewise,
// calling +link{ValuesManager.validate()} will validate all member forms, and
// +link{ValuesManager.saveData()} will initiate a save operation which aggregates values from
// all member forms.
// <P>
// Like a DynamicForm, a ValuesManager can be databound by setting
// +link{valuesManager.dataSource}.  In this case all member forms must also be bound to the
// same DataSource.
// <P>
// In general, when working with a ValuesManager and its member forms, call APIs on the
// ValuesManager whenever you are dealing with values that span multiple forms, and only call
// APIs on member forms that are specific to that form or its fields.
// <P>
// Note that, just as a DynamicForm can track values that are not shown in any FormItem, a
// ValuesManager may track values for which there is no FormItem in any member form.  However,
// when using a ValuesManager these extra values are only allowed on the ValuesManager itself.
// Member forms will not track values for which they do not have FormItems.
//
// @treeLocation Client Reference/Forms
// @visibility external
// @example formSplitting
//<
isc.ClassFactory.defineClass("ValuesManager");

isc.ValuesManager.addProperties({

    //>@attr  valuesManager.dataSource  (DataSource | string : null : [IRWA])
    // Specifies a dataSource for this valuesManager.  This dataSource will then be used for
    // validation and client-server flow methods.  Can be specified as a dataSource object or
    // an identifier for the dataSource.<br>
    // Note that member forms should have the same dataSource applied to them to allow their
    // items to inherit properties from the DataSource fields.
    // @visibility external
    // @see valuesManager.setDataSource()
    // @see valuesManager.getDataSource()
    //<
    //dataSource : null,
    
    //>@attr  valuesManager.members (Array : null : [IRW])
    // The set of member forms for this valuesManager.  These can be specified at init time via
    // the <code>members</code> property, or updated at runtime via <code>addMember()</code> and
    // <code>removeMember()</code>.<br>
    // Note: Alternatively a form can be initialized as a member of a valuesManager by setting
    // the <code>valuesManager</code> property of the form to a pre-defined valuesManager
    // instance.
    // @visibility external
    // @see valuesManager.addMember()
    // @see valuesManager.removeMember()
    //<
    //members : null,    
    
    //>	@attr	valuesManager.unknownErrorMessage	(string : "Invalid value" : [IRW])
    // @include DynamicForm.unknownErrorMessage
    //<
	unknownErrorMessage : "Invalid value"
    
    //> @attr valuesManager.disableValidation   (boolean : null : [IRWA])
    // @include DynamicForm.disableValidation
    //<

});

//!>Deferred
isc.ValuesManager.addMethods({
    // Allow a V.M to be initialized with member form(s)
    init : function () {
        // get a global ID so we can be called in the global scope
        this.ns.ClassFactory.addGlobalID(this);
        
        if (this.dataSource) this.bindToDataSource(this.dataSource);

        // Set up values based on members / init values.
        if (this.members != null) {
            // Initialize this.values [and ensure it's a new object, so it can't be manipulated
            // externally]
            this.values = isc.addProperties({}, this.values);
            
            if (!isc.isAn.Array(this.members)) this.members = [this.members];

            this._updateValuesFromMembers();
            for (var i = 0; i < this.members.length; i++) {
                var member = this.members[i];
                if (member.valuesManager != null) member.valuesManager.removeMember(member);
                member.valuesManager = this;
        
                // For databinding all member forms are expected to have the same 
                // datasource as this ValuesManager. This ensures they inherit validators,
                // field properties, etc.
                if (member.getDataSource() != this.getDataSource()) {
                    this.logWarn("Member form '"+ member.getID() + "' does not have " 
                         + "the same dataSource property specified as this valuesManager.");
                }          
                
                // If any member forms are multipart, warn the developer - this implies that
                // they need direct submission.
                // (We also log this warning on addMember)
                if (this.getDataSource() != null && member.isMultipart()) {
                    this.logWarn("Member form '" + member.getID() + 
                        "' is flagged as using multipart encoding. Multipart forms require direct form " +
                        "submission to transfer uploaded files to the server - any uploaded files from " +
                        "this member form will be dropped when saving values from this ValuesManager to " +
                        "the server."
                    );
                }
                      
            }
        }
        
        // initialize this.values
        this.values = this.values || {};
                
        // remember the current values for resetting
        this.rememberValues();
    },
    
    // on destroy
    // - disconnect from member forms (Don't destroy - they may want to be re-used in a 
    //   different VM)
    // - clear global ID
    destroy : function () {
        var members = this.members;
        if (members) {
            // iterate backwards so the changing length of the members array doesn't mess up
            // our loop
            for (var i = members.length-1; i >= 0; i--) {
                this.removeMember(members[i]);
            }
        }
        // clear the global ID
        window[this.getID()] = null;

    },
    
    // Helper method to retrieve all the values from the member forms, and apply them to
    // this.values.
    _updateValuesFromMembers : function () {
        for (var i = 0; i < this.members.length; i++) {
            var form = this.members[i],
                values = form.getValues(),
                undef;
                
            if (!isc.isA.DynamicForm(form)) {
                this.logWarn("ValuesManager member object:" + isc.Log.echo(form) 
                             + " is not a DynamicForm.  Removing from members array.");
                this.members.remove(form);
                i -= 1;
                continue;
            }

            for (var j in values) {
                if (this.members[i].getItem(j) == null) {
                    this.logWarn("Member Form:" + this.members[i].getID() + 
                         " Has explicitly specified value for fieldName " + j + ", but has" +
                         " no item associated with this fieldName. Ignoring this value. " +
                         "Values may be set for fields with no associated form item directly " + 
                         "on the valuesManager via valuesManager.setValues(), but not on " +
                         "member forms. See ValuesManager documentation for more info.");
                    continue;
                }
                // catch collisions of values - earlier values win, as they may be explicitly
                // specified at init time.
                
                if (this.values[j] !== undef && this.values[j] != values[j]) {
                    this.logWarn("ValuesManager member form " + form.getID() + 
                        " has specified value '" + j +  
                        "' which collides with an already specified value in this " +
                        "ValuesManager. Resetting the value on the form.");
                    form.setValue(j, this.values[j]);
                } else {
                    this.values[j] = values[j];
                }
            }
        }
        // Note - in order to keep the values up to date we need to be notified when they
        // change in the form.
        // This is done via code embedded in DynamicForm.setItemValue()
        
    },
    
    // _updateValue and _clearValue() -- called by member forms to notify us of field value 
    // changes
    _updateValue : function (field, value, form) {
        if (form.getItem(field) == null) {
            this.logWarn("Member Form:" + form.getID() + 
                 " Has explicitly specified value for fieldName " + field + ", but has" +
                 " no item associated with this fieldName. Ignoring this value. " +
                 "Values may be set for fields with no associated form item directly " + 
                 "on the valuesManager via valuesManager.setValues(), but not on " +
                 "member forms. See ValuesManager documentation for more info.");
            return;
        }
        this.values[field] = value;
    },
    _clearValue : function (field, form) {
        
        delete this.values[field];
    },
    
    // ----------------------------------------------------------------------------------------
    // Databound functionality
    // ----------------------------------------------------------------------------------------
    
    //> @method ValuesManager.bindToDataSource() ([A])
    //   Associate this ValuesManager with a DataSource.  Allows the developer to inherit 
    //   properties from the DataSource fields to be applied to these values, such as validators,
    //   and to call data flow methods using this ValuesManager's data.
    // @param (dataSource)  Datasource object, or identifier
    // @visibility internal
    //<
    // For the public version of this method use 'setDataSource'
    bindToDataSource : function (ds) {

        
        if (!isc.isA.DataSource(ds)) ds = isc.DataSource.getDataSource(ds);
        if (ds != null) this.dataSource = ds;
    },
  
    //>@method  valuesManager.setDataSource() (A)
    // Specifies a dataSource for this valuesManager.  This dataSource will then be used for
    // validation and client-server flow methods.
    // @visibility external
    // @param dataSource (string | DataSource)  Datasource object or identifier to bind to.
    //<
    setDataSource : function (dataSource, fields) {
        // we don't use 'fields'
        this.bindToDataSource(dataSource);
    },
    
    //>@method  valuesManager.getDataSource() (A)
    // Returns the dataSource for this valuesManager.  Will return null if this is not a 
    // data-bound valuesManager instance.
    // @visibility external
    // @return (DataSource)  Datasource object for this valuesManager.
    //<
    getDataSource : function () {
        return this.dataSource;
    },
    
    
    //>@method valuesManager.getItems()
    // Retrieves all form items contained within this valuesManager's member forms
    // @return (array of FormItems) form items present in this valuesManager
    //<
    getItems : function () {
        var items = [];
        for (var i = 0; i < this.members.length; i++) {
            var form = this.members[i];
            items.addList(form.getItems());
        }
        return items;
    },
    // getFields() synonym of getItems
    getFields : function () {
        return this.getItems();
    },
    
    getItem : function (id) {
        for (var i = 0; i < this.members.length; i++) {
            var form = this.members[i],
                item = form.getItem(id);
            if (item) return item; 
        }
    },
    
    getField : function (id) {
        return this.getItem(id);
    },
    
    // How to handle fileItems?
    // Assume onely one fileItem per member form - on saveData(), we'll grab the fileItemForm
    // from our member form and use it to submit all our values.
    getFileItemForm : function () {
        var hasFileItemForm = false, fileItemForm;
        for (var i = 0; i < this.members.length; i++) {
            var form = this.members[i].getFileItemForm();
            if (form) {
                if (hasFileItemForm) {
                    this.logWarn("ValuesManager defined with more than one member form " +
                            " containing a FileItem. This is not supported - binary data may " +
                            "only be uploaded from one FileItem when saving ValuesManager data");                              
                } else {
                    fileItemForm = form;
                    hasFileItemForm = true;
                }
            }
        }
        return fileItemForm;
    },
    
    // Validation:
    
    //> @method valuesManager.validate()
    // Validate the current set of values for this values manager against validators defined
    // in the member forms. For databound valuesManagers, also perform validation against any
    // validators defined on datasource fields.
    // <P>
    // Note that if validation errors occur for a value that is not shown in any member forms,
    // those errors will cause a warning and +link{handleHiddenValidationErrors()} will be
    // called.  This can occur if:<br>
    // - A datasource field has no correspending item in any member form<br>
    // - The item in question is hidden<br>
    // - The member form containing the item is hidden.
    //
    // @return  (boolean)   true if all validation passed
    // @visibility external
    // @example formSplitting
    //<
    validate : function () {
        // Just bail if client-side validation is disabled.
        // Note that we'll still show the errors returned from a failed server save due to
        // 'setErrors' behavior
        if (this.disableValidation) return true;
    
        // clear hidden errors before starting any validation run
        this.clearHiddenErrors();
    
        // For databound valuesManagers, each member form will be responsible for validating
        // the fields it shows, and the valueManager will validate the rest.
        var returnVal = true,
            // fields are returned from ds in {fieldName:fieldObject} format
            dsFields = this.dataSource ? isc.addProperties({}, this.getDataSource().getFields()) 
                                       : null,
            validators = {};

        // First go through all the member forms and perform validation.            
        if (this.members) {
            for (var i = 0; i < this.members.length; i++) {
                var form = this.members[i],
                    disableValidation = form.disableValidation,
                    items = this.members[i].getItems();                    
                    
                if (!disableValidation) {
                    // we don't want any user-defined handleHiddenValidationErrors to fire on the 
                    // form - instead well fire this method at the valuesManager level only.
                    // Implement this by applying our own 'handleHiddenValidationErrors' method to
                    // the form that notifies us what the errors were.
                    if (form.handleHiddenValidationErrors != null) {
                        this.logInfo("form level 'handleHiddenValidationErrors' method suppressed " +
                                     "in favor of valuesManager level handler", "validation");
                        form._prevHHVE = form.handleHiddenValidationErrors;
                    }
                    form.handleHiddenValidationErrors = this._handleHiddenFormErrors;
                }
                
                for (var j = 0; j < items.length; j++) {
                    var fieldName = items[j].getFieldName();
                    // IF the form shares a dataSource with this VM instance, 
                    // remove the appropriate field from our copy of the dataSource fields - 
                    // we have already validated this value.
                    
                    if (dsFields && this.members[i].getDataSource() == this.getDataSource()) 
                        delete dsFields[fieldName];
                }
                // Allow the form to perform its own validation.
                // Validate hidden fields (makes sense since we validate hidden forms!)
                // Pass the additional param to suppress validating DS fields for which there
                // are no items though, since we handle these at the VM level.
                // This will also display validation errors, or fire the method to handle
                // validation errors while hidden.
                var formSuccess = disableValidation ? true : form.validate(true, true)
                returnVal = (returnVal && formSuccess);
                
                if (!disableValidation) {
                    if (form._preHHVE) form.handleHiddenValidationErrors = form._preHHVE;
                    else delete form.handleHiddenValidationErrors;
                }
                // If the form is hidden, add its full set of errors to our hidden form 
                // validation errors object.
                // Note that if there were fields marked as hidden within the form, we already
                // stored those -- this will override that object with the entire set of
                // errors for the form.
                if (!formSuccess && !(form.isDrawn() && form.isVisible())) {
                    this.addHiddenErrors(form.errors, form)
                }
            }
        }


        // we now have to perform validation on the DS fields not present in any member form
        var values = this.getValues(),
            errors = {};
        for (var fieldName  in dsFields) {
        
           var fieldObject = dsFields[fieldName],
               validators = fieldObject.validators,
               required = fieldObject.required,
               value = values[fieldName];

            if (required && value == null) {
                // handle this type of error
                if (errors[fieldName] == null) errors[fieldName] = [];
				errors[fieldName].add(isc.Validator.requiredField);
                
            } else if (validators != null) {
                var value = values[fieldName];

                // iterate through the validators again, this time actually checking each one
                for (var i = 0; i < validators.length; i++) {
                    // validators is an array of validator objects, each of which has the form
                    //    {type:"validatorType", errorMessage:"message", optionalParam:"", ...}
                    var validator = validators[i];
                    if (!validator) continue;
                    // Unless we're looking at a 'requiredIf' field, don't try to validate
                    // null values.
                    if (validator.type != "requiredIf" && value == null) {
                        continue;
                    }
                    // we have no item, so pass the field object to processValidator()
                    // This roughly matches what we do in ListGrid validation
                    if (!this.processValidator(fieldObject, validator, value)) {
                        if (errors[fieldName] == null) errors[fieldName] = [];
                        var errorMessage = validator.errorMessage || this.unknownErrorMessage;
                        errors[fieldName].add(errorMessage);
                    }
                }
            }
            
            // for consistency with forms - if we got a single error, store as a string, not
            // a single element array
            if (errors[fieldName] && errors[fieldName].length == 1) errors[fieldName] = errors[fieldName][0];
            
        }       

        // add hidden errors from fields that are not associated with any form.        
        this.addHiddenErrors(errors);

        // This method will show hidden errors from member forms or from the VM fields.        
        this._handleHiddenValidationErrors(true);

        if (isc.getKeys(errors).length > 0)  returnVal = false;
        return returnVal;
    },
    
    //> @method ValuesManager.getValidatedValues()
    // Call +link{valuesManager.validate()} to check for validation errors. If no errors are found,
    // return the current values for this valuesManager, otherwise return null.
    // @return (object|null) current values or null if validation failed.
    // @group errors
    // @visibility external
    //< 
    getValidatedValues : function () {
        if (!this.validate()) return null;
        return this.getValues();
    },     
    
    // Handler for hidden form validation errors. This method is applied directly to the 
    // member form
    _handleHiddenFormErrors : function (errors) {
        var vm = this.valuesManager;
        vm.addHiddenErrors(errors, this);
        return false;   // suppress the standard warning
    },
    
    
    clearHiddenErrors : function () {
        delete this.hiddenErrors;
    },

    // addHiddenErrors()
    // For a valuesManager, hidden validation errors may come from:
    // - a field in the dataSource not associated with any member form item
    // - a hidden item in a member form
    // - a hidden or undrawn member form.
    
    addHiddenErrors : function (errors, form) {
        if (errors == null || isc.isAn.emptyObject(errors)) return;
        
        if (!this.hiddenErrors) this.hiddenErrors = {};
        if (form) {
            if (isc.isA.Canvas(form)) form = form.getID();
        } else form = this.getID();
        
        if (!this.hiddenErrors[form]) this.hiddenErrors[form] = {};
            
        for (var fieldName in errors) {
            this.hiddenErrors[form][fieldName] = 
                this._addFieldErrors(this.hiddenErrors[form][fieldName], errors[fieldName]);
        }
    },
    
    // Returns the current snapshot of hidden errors in a flat list
    getHiddenErrors : function (suppressSynch) {

        if (!suppressSynch) {
            this.synchHiddenErrors();
        }
        
        if (!this.hiddenErrors) return null;
        var flatErrors = {};
        for (var form in this.hiddenErrors) {
            isc.addProperties(flatErrors, this.hiddenErrors[form]);
        }
        return flatErrors;
    },
    
    
    // synchHiddenErrors()
    // This is a method to ensure that our 'hiddenErrors' object returned by getHiddenErrors()
    // and passed to handleHiddenValidationErrors is in synch with the current set of 
    // visible forms / items.
    // Required in the case where 
    // - setErrors() was called, 
    // - form/item visibility was changed, 
    // - showErrors() called.
    
    synchHiddenErrors : function () {
        
        var hiddenErrors = this.hiddenErrors,
            vmID = this.getID();
                    
        // Logic for errors that occurred on fields with no associated member form item 
        // (when errors were stored)
        if (hiddenErrors && hiddenErrors[vmID]) {
            for (var field in hiddenErrors[vmID]) {
                var errors = hiddenErrors[vmID][field],
                    item = this.getItem(field),
                    memberForm = item ? item.form : null;
                    
                // If there is now an associated member form item, we need to add the
                // field error to the form, and update this.hiddenErrors
                if (item) {
                    memberForm.addFieldErrors(field, errors);
                    // clear out the hidden error under the valuesManager's ID - the error
                    // is now associated with a form.
                    delete hiddenErrors[vmID][field];
                }
            }
        }
        
        // Update hidden errors for each form.
        // Quickest to just re-generate hidden errors per form rather than trying to synch with 
        // existing stored hiddenErrors object.
        var vmErrors = hiddenErrors[vmID];
        hiddenErrors = this.hiddenErrors = {};
        if (vmErrors) hiddenErrors[vmID] = vmErrors;
        // Now iterate through every member's errors and add to hidden members arrays if 
        // necessary
        if (this.members) {
            for (var i = 0; i< this.members.length; i++) {
                var member = this.members[i],
                    memberID = member.getID(),
                    memberErrors = member.errors;
                if (!memberErrors || isc.isAn.emptyObject(memberErrors)) continue;
                
                // shortcut - if the form is hidden always store all its errors. This may
                // overwrite an already up to date this.hiddenErrors[formID] but is quicker
                // than iterating through the errors doing comparisons.
                if (!member.isVisible() || !member.isDrawn()) {
                    memberErrors = isc.addProperties({}, memberErrors);
                    hiddenErrors[memberID] = memberErrors;
                } else {
                    // catch items that have been hidden or removed
                    for (var field in memberErrors) {
                        var item = member.getItem(field);
                        if (!item) {
                            if (!hiddenErrors[vmID]) hiddenErrors[vmID] = {};
                            hiddenErrors[vmID][field] = memberErrors[field];
                            // just delete the field from the form's errors object
                            delete memberErrors[field];
                            
                        } else if (!item.visible) {
                            if (!hiddenErrors[memberID]) hiddenErrors[memberID] = {};
                            hiddenErrors[memberID][field] = memberErrors[field];
                        }
                    }
                }
            }
        }
        
    },
    
    //>	@method	valuesManager.processValidator()	(A)
    //			process a single validator for a field.
    //
    //		@param	[item]		(object)	Form item displaying the value. May be null if no
    //                                      form item exists for the field.
    //		@param	validator	(object)	validation object
    //		@param	value		(string)	value for this field.
    //      @param  [type]      (string)    validator type. if not passed this is derived from
    //                                      the <code>type</code> property on the validation parameter
    //
    //		@return	(boolean)	true == passed validation, false == validation failed
    //		@group	validation
    //<
    processValidator : function (item, validator, value, type) {
        return isc.Validator.processValidator(item, validator, value, type);
    },

    // _handleHiddenValidationErrors()
    // Internal method to display validation errors when we can't show them in a form.
    // This is used to handle 
    // - errors coming from an undrawn or hidden member form
    // - errors coming from hidden items in a member form
    // - errors coming from a dataSource field for which we have no member form item.
    // Note these errors are all combined into a single object retrieved via this.getHiddenErrors()
    // if a developer needs to determine which form an error came from, they can use
    // getMemberForField()
    // Additional suppressSynch parameter - if we know the hidden errors are in synch with
    // the currently visible set of members / fields (IE this has been called directly from
    // setErrors() or validate()) we can skip the logic to ensure that this.hiddenErrors
    // is up to date.
    _handleHiddenValidationErrors : function (suppressSynch) {
        var errors = this.getHiddenErrors(suppressSynch);
        
        // bail if there were no errors on hidden fields
        if (errors == null || isc.getKeys(errors).length == 0) return;
        
        // If we have an implementation to handle the hidden validation errors, call it now.
        var returnVal;
        if (this.handleHiddenValidationErrors) {
            returnVal = this.handleHiddenValidationErrors(errors);
        }
        
        if (returnVal == false) return;
        
        // Log a warning unless this was suppressed by the handleHiddenValidationErrors method.
        var errorString = "Validation failed with the following errors:";
        for (var fieldName in errors) {
            var fieldErrors = errors[fieldName];
            if (!isc.isAn.Array(fieldErrors)) fieldErrors = [fieldErrors];
            if (fieldErrors.length == 0) continue;

            errorString += "\n" + fieldName + ":";
            for (var i = 0; i < fieldErrors.length; i++) {
                errorString += (i == 0 ? "- " : "\n - ") + fieldErrors[i];
            }
        }
        this.logWarn(errorString, "validation");
    },
    
    // Validation errors APIs
    
    //>	@method	valuesManager.setErrors() ([A])
    // Sets validation errors for this valuesManager to the specified set of errors.
    // Errors should be of the format:<br>
    // <code>{field1:errors, field2:errors}</code><br>
    // where each <code>errors</code> object is either a single error message string or an
    // array of error messages.<br>
    // If <code>showErrors</code> is passed in, error messages will be displayed in the 
    // appropriate member form items. For fields with no visible form item, 
    // +link{valuesManager.handleHiddenValidationErrors()} will be fired instead.<br>
    // Note that if <code>showErrors</code> is false, errors may be shown at any time via
    // a call to +link{ValuesManager.showErrors()}.
    //
    // @param   errors  (object) list of errors as an object with the field namesas keys
    // @param   showErrors (boolean) If true display errors now.
    // @group errors
    // @visibility external
    //<
    setErrors : function (errors, showErrors) {
        this.clearHiddenErrors();
        
        errors = isc.DynamicForm.formatValidationErrors(errors);
        
        var memberForms = (this.members ? this.members.duplicate() : []);

        for (var i = 0; i < memberForms.length; i++) {
            var form = memberForms[i],
                hiddenForm = !form.isVisible() || !form.isDrawn(),
                items = form.getItems(),
                formErrors = {},
                hiddenFormErrors = {};
            for (var j = 0;j < items.getLength(); j++) {
                var item = items[j],
                    itemName = item.getFieldName();
                if (errors[itemName] != null) {
                    formErrors[itemName] = errors[itemName];

                    if (hiddenForm || !item.visible) {
                        hiddenFormErrors[itemName] = errors[itemName];
                    }
                    delete errors[itemName];
                        
                }
            }
            // suppress redraw and suppress form-level hiddenValidationError handling
            form.setErrors(formErrors, false);

            // hang onto the hidden form errors so we can fire the hiddenValidationErrors
            // handler.
            // Note: track hidden errors by form - see comments near
            // addHiddenErrors() / _getHiddenErrors() for more on this
            if (!isc.isAn.emptyObject(hiddenFormErrors)) 
                this.addHiddenErrors(hiddenFormErrors, form);
        }
        
        this.addHiddenErrors(errors);
        // We know stored hidden errors object is up to date
        if (showErrors) this.showErrors(true);
    },
    
    // little helper to combine errors into arrays
    // Returns the errors object to use
    _addFieldErrors : function (oldErrors, newErrors) { 
        if (!oldErrors) return newErrors;
        if (!newErrors) return oldErrors;
        if (!isc.isAn.Array(oldErrors)) oldErrors = [oldErrors];
        if (isc.isA.String(newErrors)) oldErrors.add(newErrors);
        else oldErrors.addList(newErrors);

        return oldErrors;
        
    },
    
    //> @method ValuesManager.addFieldErrors()
    // Adds validation errors to the existing set of errors for the field in question.
    // Errors passed in should be a string (for a single error message) or an array of strings.
    // Pass in the showErrors parameter to immediately display the errors to the user by 
    // redrawing the appropriate member form item (or if no visible item is found for the field
    // firing +link{valuesManager.handleHiddenValidationErrors()}.
    // @param fieldName (string) name of field to apply errors to
    // @param errors (string | array of strings) error messages for the field
    // @param showErrors (boolean) should the error(s) be immediately displayed to the user?
    // @group errors
    // @visibility external
    //<
    addFieldErrors : function (fieldName, errors, showErrors) {
        var hidden = true;
        var form = this.getMemberForField(fieldName);
        if (form != null) {
            form.addFieldErrors(fieldName, errors, false);
            var item = form.getItem();
            if (form.isVisible() && form.isDrawn() && item && item.visible) {
                hidden = false;
            }
        }
        
        if (hidden) {    
            if (!this.hiddenErrors) this.hiddenErrors = {};
            var formName = form ? form.getID() : this.getID();
            if (!this.hiddenErrors[formName]) this.hiddenErrors[formName] = {};

            this.hiddenErrors[formName][fieldName] = 
                this._addFieldErrors(this.hiddenErrors[formName][fieldName], errors);

        }
        
        if (showErrors) this.showFieldErrors(fieldName);
    },
    
    //> @method ValuesManager.setFieldErrors()
    // Sets validation errors for some field in the valuesManager.<br>
    // Errors passed in should be a string (for a single error message) or an array of strings.
    // Pass in the showErrors parameter to immediately display the errors to the user by 
    // redrawing the appropriate member form item (or if no visible item is found for the field
    // firing +link{valuesManager.handleHiddenValidationErrors()}.
    // @param fieldName (string) name of field to apply errors to
    // @param errors (string | array of strings) error messages for the field
    // @param showErrors (boolean) should the error(s) be immediately displayed to the user?
    // @group errors
    // @visibility external
    //<    
    setFieldErrors : function (fieldName, errors, showErrors) {
        var hidden = true;
        var form = this.getMemberForField(fieldName);
        if (form != null) {
            form.setFieldErrors(fieldName, errors, false);
            var item = form.getItem();
            if (form.isVisible() && form.isDrawn() && item && item.visible) {
                hidden = false;
            }
        }
        
        if (hidden) {
            if (!this.hiddenErrors) this.hiddenErrors = {};
            this.hiddenErrors[fieldName] = errors;
        }
        
        if (showErrors) this.showFieldErrors(fieldName);    
    },
    
    //>	@method	valuesManager.clearErrors()   ([])
    //			Clears all errors from member forms.
    //      @param  showErrors (boolean)    If true, clear any visible error messages.
    //		@group	errors
    //      @visibility external
    //<
    clearErrors : function (showErrors) {
        this.setErrors({}, showErrors);
    },
    
    //> @method valuesManager.clearFieldErrors()
    // Clear all validation errors associated with some field in this form
    // @param fieldName (string) field for which errors should be cleared
    // @param show (boolean) if true, and the field is present in one of our member forms, 
    //                       redraw it to clear any currently visible validation errors
    // @group errors
    // @visibility external
    //<
    clearFieldErrors : function (fieldName, show) {
        var form = this.getMemberForField(fieldName);
        if (form) form.clearFieldErrors(fieldName, show);
        
        if (this.hiddenErrors) delete this.hiddenErrors[fieldName];
    },

    //> @method valuesManager.getErrors()
    // Returns the set of errors for this valuesManager.
    // Errors will be returned as an object of the format <br>
    // <code>{field1:errors, field2:errors}</code><br>
    // Where each errors object is either a single error message or an array of error message
    // strings.
    // @return (object) Object contining mapping from field names to error strings. Returns null
    //                  if there are no errors for this valuesManager.
    // @group errors
    // @visibility external
    //<
    // Stored errors include those stored as "hiddenErrors", with no associated form (came from
    // a datasource field definition only, presumably), and errors from member forms
    getErrors : function () {
        // pick up stored hidden errors.
        // [don't bother to synch - we're not interested in whether they're truly hidden or not now]
        var errors = isc.addProperties({}, this.getHiddenErrors(true));
        // add errors from each member form                              
        
        if (this.members) {
            for (var i = 0; i < this.members.length; i++) {
                isc.addProperties(errors, this.members[i].getErrors());
            }
        }
        if (!isc.isA.emptyObject(errors)) return errors
        return null
    },
    
    //> @method valuesManager.getFieldErrors()
    // Returns any validation errors for some field in this valuesManager.
    // Errors will be returned as either a string (a single error message), or an array 
    // of strings. If no errors are present, will return null.
    // @param fieldName (string) fieldName to check for errors
    // @return (string | array of strings) error messages for the field passed in
    // @group errors
    // @visibility external
    //<
    getFieldErrors : function (fieldName) {
        var form = this.getMemberForField(fieldName)
        if (form) return form.getFieldErrors(fieldName);
        if (this.hiddenErrors && this.hiddenErrors[this.getID()]) 
            return this.hiddenErrors[this.getID()][fieldName];
    },
    
    //> @method valuesManager.hasErrors()
    // Are there any errors associated with any fields in this valuesManager?
    // @return (boolean) returns true if there are any oustanding validation errors, false 
    //                  otherwise.
    // @group errors
    // @visibility external
    //<
    hasErrors : function () {
        if (this.hiddenErrors && !isc.isA.emptyObject(this.hiddenErrors)) {
            for (var form in this.hiddenErrors) {
                if (this.hiddenErrors[form] && !isc.isAn.emptyObject(this.hiddenErrors[form]))
                    return true;
            }
        }
        if (this.members == null) return false;
        for (var i = 0; i < this.members.length; i++) {
            if (this.members[i].hasErrors()) return true;
        }
        return false;
    },
    
    //> @method valuesManager.hasFieldErrors()
    // Are there any errors associated with a field in this valuesManager?
    // @param fieldName (string) field to check for errors
    // @return (boolean) returns true if there are any oustanding validation errors, false 
    //                  otherwise.
    // @group errors
    // @visibility external
    //<        
    hasFieldErrors : function (fieldName) {
        var form = this.getMemberForField(fieldName);
        if (form && form.hasFieldErrors(fieldName)) return true;
        var hiddenErrors = this.getHiddenErrors(true);
        if (hiddenErrors && hiddenErrors[fieldName] != null) return true;
        return false;
    },
    
    //> @method valuesManager.showErrors()
    // Method to explicitly show the latest set of validation errors present on this 
    // ValuesManager.<br>
    // Will redraw all member forms to display (or clear) currently visible errors, and
    // fire +link{valuesManager.handleHiddenValidationErrors()} to allow custom handling of
    // hidden errors.
    // @group errors
    // @visibility external
    //<
    // suppressHiddenErrorSynch parameter: indicates we know our stored hidden errors match the 
    // currently visible set of fields [so we just ran validate() or setErrors()].
    // passed through to _handleHiddenValidationErrors()
    showErrors : function (suppressHiddenErrorSynch) {
    
        if (this.members) {
            for (var i= 0; i < this.members.length; i++) {
                if (!this.members[i].isDrawn() || !this.members[i].isVisible()) continue;
                this.members[i].markForRedraw("ValuesManager validation errors");
            }
        }
        
        if (this.hiddenErrors != null) {
            this._handleHiddenValidationErrors(suppressHiddenErrorSynch);
        }
    },
    
    //> @method valuesManager.showFieldErrors()
    // Method to explicitly show the latest set of validation errors present on some field 
    // within this ValuesManager.<br>
    // If the field in question is present as a visible item in a member form, the form item
    // will be redrawn to display the error message(s).
    // Otherwise +link{valuesManager.handleHiddenValidationErrors()} will be fired to allow 
    // custom handling of hidden errors.
    // @group errors
    // @visibility external
    //<
    showFieldErrors : function (fieldName) {
        var form = this.getMemberForField(fieldName);
        if (form && form.isVisible() && form.isDrawn()) {
            var item = form.getItem(fieldName);
            if (item && item.visible) {
                item.redraw("Validation errors modified");
                return;
            }
        }
        
        // At this point we know we have a hidden error for the field - fire the 
        // handleHiddenValidationErrors method. Of course that actually 'shows' the
        // errors for all hidden fields, not just this one.
        this._handleHiddenValidationErrors();
    },
    
    // Flow Methods:
    
    //>@method getFilterCriteria()
    // Return the set of filter criteria for this valuesManager based on its current set of 
    // values
    // @return (object) set of name:values pairs to be used as filter criteria
    //<
    getFilterCriteria : function () {
        // get filter criteria from all my members
        
        var crit = {};
        if (this.members) {
            for (var i =0; i < this.members.length; i++) {
                isc.addProperties(crit, this.members[i].getFilterCriteria());
            }
        }
        
        // Mix in any values we have that didn't come from member forms
        var values = this.getValues(),
            undef;
        for (var field in values) {
            if (crit[field] !== undef) delete values[field];
        }
        // filterCriteriaForFormValues will clear out null values, and handle arrays with an
        // empty entry (Implies a null criterion)
        isc.addProperties(crit, isc.DataSource.filterCriteriaForFormValues(values));
        
        return crit;
    },

    
    // ========================================================================================
    //  Values Management APIs
    // ========================================================================================
    
    //>@method  ValuesManager.getValues()   
    //  Returns the current set of values for the values manager instance.  This includes the
    //  values from any form managed by this manager, as well as any values explicitly applied
    //  via +link{valuesManager.setValues()}.
    // @return (object) a map of the values for this manager
    // @visibility external
    // @group formValues
    //<
    getValues : function () {
        // if one of our member forms has focus, ensure its focus-item's value has been saved
        // out [which will update this.values]
        if (this.members != null) {
            var fc = isc.EH.getFocusCanvas();
            if (this.members.contains(fc)) fc.updateFocusItemValue();
        }
        // Never let this.values be externally accessible.
        return isc.addProperties({}, this.values);
    },
    
    //>@method  ValuesManager.setValues()   
    //  Set the values for this values manager.  Member forms will be updated as required by
    //  this change.
    //  Note that pre-existant values in other fields are cleared out by this.
    // 
    // @param   values  (object)    new set of values for this values manager.
    // @visibility external
    // @group formValues
    //<    
    setValues : function (values) {
        if (isc.isAn.Array(values)) {
            var useFirst = isc.isA.Object(values[0]);
            this.logWarn("values specified as an array." + 
                        (useFirst ? " Treating the first item in the array as intended values."
                                  : " Ignoring specified values."));
            if (useFirst) values = values[0];
            else values = null;                                  
        }
    
        
    
        // Duplicate the values object so we can manipulate it and apply it directly to 
        // this.values without interfering with external code.
        values = isc.addProperties({}, values);
        var undef;
        
        for (var i = 0; i < this.members.length; i++) {
            var form = this.members[i],
                fields = form.getItems().getProperty(form.fieldIdProperty),
                changedValues = {};
            for (var ii = 0; ii < fields.length; ii++) {
                var fieldName = fields[ii];
                if (values[fieldName] !== undef) {
                    changedValues[fieldName] = values[fieldName];

                    // If we've set the value on a form item, clear it out of the values object 
                    // passed in - so values will end up as a minimal list of values below
                    delete values[fieldName]
                }
            }

            // set the values on the form
            form.setValues(changedValues);
            
        }
                
        // The values param now contains just the values passed in that didn't exist in any
        // member form.
        // use _updateValuesFromMembers() to add the values from every form, including any 
        // defaults for the form item values
        this.values = values;
        this._updateValuesFromMembers();
        
        // remember values for resetting
        this.rememberValues();
    },
    
    //>@method ValuesManager.setData()
    // Set the data (values) on this valuesManager [synonym for <code>setValues()</code>].
    //<
    // setData() is used in dataBinding rather than setValues.
    setData : function (values) {
        return this.setValues(values);
    },

    //>@method  ValuesManager.clearValues()   
    //  Clear out all the values managed by this values manager.
    // @visibility external
    // @group formValues
    //<
    clearValues : function () {
        this.setValues({});
    },

    //>@method  ValuesManager.getMemberValues()   
    //  Returns the subset of this valuesManager's values associated with some member form.
    //  
    // @param   ID  (string)    ID of the member form for which we want to retrieve the values.
    // @return (object) a map of the values for the appropriate member form.
    // @visibility external
    // @group formValues
    //<    
    getMemberValues : function (ID) {
        var member = this.getMember(ID);
        if (member != null) return member.getValues();
    },
    
    //>@method  ValuesManager.setMemberValues()   
    //  Set the values for some member form
    // @param   ID  (string)    ID of the member form to update
    // @param   values  (object)    new values for the form
    // @visibility external
    // @group formValues
    //<    
    setMemberValues : function (ID, values) {
        var member = this.getMember(ID);
        if (member != null) return member.setValues(values);
    },
    
    
    //> @method ValuesManager.rememberValues ([A])
    // @include dynamicForm.rememberValues()
    //<
    // Values may change as a result of 
    // - adding a new member and picking up values for fields for which we previously had no 
    //   value
    // - the user modifying values in a field
    // - calls to 'setValue()' [not setValues as that will re-remember the values after setting]
    rememberValues : function () {
        
    	var values = this.getValues();
		
        // create a new object to hold the values
		this._oldValues = {}
    	
        for (var prop in values) {
    		if (!isc.isA.Function(values[prop])) {
                // Special case for dates - duplicate them rather than copying the object 
                // across
                if (isc.isA.Date(values[prop])) {
                    this._oldValues[prop] = new Date();
                    this._oldValues[prop].setTime(values[prop].getTime());     
                } else {
                    this._oldValues[prop] = values[prop];
                }
    		}
    	}
    	return this._oldValues;
    },
    
    //> @method ValuesManager.resetValues ([A])
    // @include dynamicForm.resetValues()
    //<
    resetValues : function () {
        
    	// pull the values from form._oldValues into ValuesManager.values
        var values = {};

    	for (var prop in this._oldValues) {
            // special case for dates - we want to reset the value of the date, but not actually 
            // replace the object
            if (isc.isA.Date(this._oldValues[prop])) {
                var currentVal = this.getValue(prop);
                if (isc.isA.Date(currentVal)) {
                    currentVal.setTime(this._oldValues[prop].getTime())
                    values[prop] = currentVal;
                } else {
                    values[prop] = this._oldValues[prop].duplicate();
                }
            } else {
                values[prop] = this._oldValues[prop];
            }
    	}
        this.setValues(values);
            
    },
    
    //> @method ValuesManager.valuesHaveChanged ([A])
    // @include dynamicForm.valuesHaveChanged()
    //<
    valuesHaveChanged : function () {
        var values = isc.addProperties({}, this.getValues()),
            prevValues = this._oldValues,
            different = false;

        for (var i in prevValues) {
            if (isc.isA.Date(prevValues[i])) {
                if (!isc.isA.Date(values[i]) || Date.compareDates(values[i], prevValues[i]) != 0) {
                    different = true;
                }
            } else {
                if (prevValues[i] != values[i]) different = true;
            }
            // If we found a difference, return true.
            // Otherwise remove the field from the cloned values object - we can use this to
            // check whether any new fields have been added to the values object.
            if (different) return true;
            else delete values[i];
        }
        
        // if we have any new values, return true
        for (var i in values) {
            if (values[i] && !isc.isA.Function(values[i])) return true;
        }
        
        return false;
    },

    //> @method ValuesManager.getValue
    // Returns the value for some field.
    // @param   fieldName   (string)    Which value to be returned
    // @return  (any)   current value of the appropriate field
    // @visibility external
    // @group formValues
    //< 
    getValue : function (fieldName) {
        return this.values[fieldName];
    },
    
    //> @method ValuesManager.setValue
    // Set the value for some field.
    // @param   fieldName   (string)    Which field to set the value for
    // @param   newValue    (any)       New value for the field.
    // @visibility external
    // @group formValues
    //< 
    setValue : function (fieldName, newValue) {
        var valueSet = false;
            
        if (this.members) {
    
            var undef;
            for (var i = 0; i < this.members.length; i++) {
                var member = this.members[i]
                if (member.getValues()[fieldName] !== undef || 
                    member.getItem(fieldName) != null) 
                {
                    member.setValue(fieldName, newValue);
                    valueSet = true;
                    break;
                }
            }
        }
        if (!valueSet) this.values[fieldName] = newValue;
    },
    
    // ========================================================================================
    //  Member Management
    // ========================================================================================
    
    //>@method  ValuesManager.addMember()   
    //
    // Add a new member form to this valuesManager.
    // This form's values will subsequently be available through this valuesManager.  <br>
    // Note on pre-existant values:
    // If the valuesManager has a value specified for some field, for which the member form has
    // an item, this value will be applied to the member form.  This is true whether the item
    // has a value or not.<br>
    // However if the member form has a value for some field, and the ValuesManager does not
    // have a specified value for the same field, we allow the valuesManager to pick up the 
    // value from the member form.    
    //
    // @param   member  (DynamicForm | String) form (or ID of form) to add to 
    //                                          this valuesManager as a member.
    // @visibility external
    // @group members
    // @see method:ValuesManager.addMembers
    //<    
    addMember : function (member) {
        // If passed an ID, assume it's a pointer to the form.
        if (isc.isA.String(member)) member = window[member];
        
        if (!isc.isA.DynamicForm(member)) {
            this.logWarn("addMember() passed invalid object: "+ isc.Log.echo(member) + 
                         " - this should be a DynamicForm instance");
            return;
        }
        
        if (member.valuesManager != null) member.valuesManager.removeMember(member);

        // If the member has a different dataSource specified, log a warning.
        // Different dataSources are a problem, as datasource field properties (including
        // specified validators) will not be reflected in the form.
        if (member.getDataSource() != this.getDataSource()) {
            this.logWarn("addMember(): new member form '"+ member.getID() + "' does not have " 
                         + "the same dataSource property specified as this valuesManager.");
        }
        // If any member forms are multipart, warn the developer - this implies that
        // they need direct submission.
        if (this.getDataSource() != null && member.isMultipart()) {
            this.logWarn("addMember(): new member form '" + member.getID() + 
                "' is flagged as using multipart encoding. Multipart forms require direct form " +
                "submission to transfer uploaded files to the server - any uploaded files from " +
                "this member form will be dropped when saving values from this ValuesManager to " +
                "the server."
            );
        }
        
        if (this.members == null) this.members = [];
        this.members.add(member);
        
        var values = member.getValues(),
            items = member.getItems(),
            undef;

        for (var field in values) {
            if (this.values[field] !== undef) {
                this.logWarn("ValuesManager member form " + member.getID() + 
                    " has specified value '" + field +  
                    "' which collides with an already specified value in this " +
                    "ValuesManager. Resetting the value on the form.");
                member.setValue(field, this.values[field]);
            } else {
                this.values[field] = values[field];
            }
        }
        // Go through any items without values, and update their values to come from the VM.
        for (var i = 0; i < items.length; i++) {
            
            var item = items[i],
                field = item[member.fieldIdProperty];

            // If values[field] from the member isn't empty, we've already set the form value 
            // above.
            if (this.values[field] !== undef && values[field] === undef) {
                item.setValue(this.values[field]);
            }
        }
        
        member.valuesManager = this;
        
        // We have directly manipulated the values object, so we should re remember it.
        this.rememberValues();
        
    },
    
    //>@method  ValuesManager.addMembers()   
    //  Add multiple new member forms to this valuesManager.
    // @param   members  (array) array of forms to add to this valuesManager as members.
    // @visibility external
    // @group members
    // @see method:ValuesManager.addMember
    //<        
    addMembers : function (members) {
        if (!isc.isAn.Array(members)) this.addMember(members);
        else {
            for (var i = 0; i< members.length; i++) {
                this.addMember(members[i]);
            }
        }
    },
    
    //>@method  ValuesManager.removeMember()   
    //  Remove a member form from this valuesManager, so its values are no longer managed
    //  by this instance.
    //  This does not clear the values associated with the form from the valuesManager - they
    //  will still be available via <code>valuesManager.getValues()</code>, but will not be
    //  updated as the form is manipulated.
    // @param   member  (DynamicForm | string)   form (or ID of form) to remove from this valuesManager
    // @visibility external
    // @group members
    // @see method:ValuesManager.removeMembers()
    //<    
    removeMember : function (member) {
        
        if (isc.isA.String(member)) {
            member = isc.Class.getArrayItem(member, this.members);
            if (member == null) return;
        } else if (!this.members.contains(member)) return;
        
        this.members.remove(member);
        delete member.valuesManager;
    },
    
    //>@method  ValuesManager.removeMembers()   
    //  Remove multiple member forms from this valuesManager.
    // @param   members  (array)   array of forms to remove
    // @visibility external
    // @group members
    // @see method:ValuesManager.removeMember()
    //<    
    removeMembers : function (members) {
        if (!isc.isAn.Array(members)) this.removeMember(members);
        else {
            for (var i = 0; i< members.length; i++) {
                this.removeMember(members[i]);
            }
        }    
    },

    
    //>@method  ValuesManager.getMembers()   
    //  Retrieves an array of pointers to all the member forms for this valuesManager.
    // @return (array)   array of member forms
    // @visibility external
    // @group members
    //<    
    getMembers : function () {
        return this.members;
    },
    
    //>@method  ValuesManager.getMember()
    //  Returns a pointer to a specific member form.
    // @param   ID  (string)    ID of the form to retrieve
    // @return (DynamicForm)   member form (or null if unable to find a member with the 
    // specified ID).
    // @visibility external
    // @group members
    //<    
    getMember : function (ID) {
        // Since the members are all DynamicForm instances, their IDs are global
        var member = window[ID];
        // sanity check
        if (this.members && this.members.contains(member)) return member;
        return null;
    },
    
    //>@method  ValuesManager.getMemberForField()
    // Given a fieldName, this method will find the member form containing an item for that
    // field. If no member form is found, returns null.
    // @param fieldName (string) fieldName to check
    // @return (DynamicForm) member form containing an item for the fieldName, or null.
    // @group members
    // @visibility external
    //<
    getMemberForField : function (fieldName) {
        if (!this.members) return null;
        for (var i = 0; i < this.members.length; i++) {
            if (this.members[i].getItem(fieldName)) return this.members[i];
        }
        return null;
    },

    
    // Getting pointers to actual items
    //>@method ValuesManager.getItem()
    // Takes an item name (specified via the form.fieldIdProperty value, or retrieved via
    // item.getFieldName()) returns a reference to the appropriate item in this valuesManager.
    // <br>Note: Unlike the <code>DynamicForm</code> class, this method will not return an 
    // item by index
    // @visibility external
    //<
    getItem : function (name) {
        if (this.members) {
            for (var i = 0; i < this.members.length; i++) {
                var form = this.members[i],
                    items = this.members[i].getItems();
                for (var j = 0; j < items.length; j++) {
                    if (items[j].getFieldName() == name) return items[j];
                }
            }
        }
        return null;
    },
    
    // ----------------------------------------------------------------------------------------
    // Display
    // ----------------------------------------------------------------------------------------
    // valuesManagers don't usually display their values directly - but support
    // getPrintHTML() so we can build reports from them.
    getPrintHTML : function () {
        var values = this.getValues(),
            printHTML = isc.StringBuffer.create();

        printHTML.append("<TABLE border=1><TR><TD align='center' style='font-weight:bold;'>Field</TD>",
                         "<TD align='center' style='font-weight:bold;'>Value</TD>");
        for (var fieldName in values) {
            printHTML.append("<TR><TD>",fieldName,"</TD><TD>", values[fieldName], "</TD></TR>");
        }
        printHTML.append("</TABLE>");
        return printHTML.toString();
    }
    
        
});



isc.ValuesManager.registerStringMethods ({

     //> @method valuesManager.handleHiddenValidationErrors (A)
    // Method to display validation error messages for a valuesManager when there is not
    // currently visible form item displaying the errors.
    // This will be called when validation fails for<br>
    // - a field in a hidden or undrawn member form<br>
    // - a hidden field in a visible member form<br>
    // - for databound ValuesManagers, a datasource field with specified validators, but not
    //   associated item in any member.<br>
    // Implement this to provide custom validation error handling for these fields.<br>
    // By default hidden validation errors will be logged as warnings in the developerConsole.
    // Return false from this method to suppress that behavior.
    // @param   errors (object) The set of errors returned - this is an object of the form<br>
    //                      &nbsp;&nbsp;<code>{fieldName:errors}</code><br>
    //                      Where the 'errors' object is either a single string or an array
    //                      of strings containing the error messages for the field.
    // @visibility external
    //<
    handleHiddenValidationErrors:"errors"
});

//!<Deferred
