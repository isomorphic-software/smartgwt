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


// avoid errors if DataBinding module is loaded without either Grids or Forms
if (isc.ListGrid && isc.DynamicForm) {



//>	@class ListEditor
//
// @implements DataBoundComponent	
// @visibility listEditor
//<
isc.defineClass("ListEditor", isc.Layout);
    
isc.ListEditor.addProperties({
    //> @attr listEditor.inlineEdit (boolean : false : IR)
    // Whether to allow inline editing in the grid.  
    // <P>
    // If enabled, the form will show as a modal dialog instead of being displayed side by side
    // with the grid, to prevent ambiguous simultanous editing within both the grid and form.
    // This mode is suitable for rapid entry/update of records where few properties are
    // normally set.
    //
    // @visibility listEditor
    //<
    //inlineEdit :false,

    //> @attr listEditor.vertical (boolean : false : IR)
    // Whether the form and grid should be shown vertically stacked or horizontally adjacent.
    // <P>
    // Ignored when +link{inlinEdit} is true, since form is then shown in a pop-up.
    //
    // @visibility listEditor
    //< 
    vertical:false,

    // List subcomponent
    // ---------------------------------------------------------------------------------------
    listDefaults:{
        _constructor:isc.ListGrid,
        editEvent:"click",
        listEndEditAction:"next",
        autoParent:"listLayout",
        selectionType:isc.Selection.SINGLE,
        recordClick:"this.creator.recordClick(record)",
        editorEnter:"this.creator.moreButton.enable()",
        selectionChanged:"if (this.anySelected()) this.creator.moreButton.enable()",
        contextMenu : {
            data : [
                {title:"Remove", click: "target.creator.removeRecord()" }
            ]
        }
    },

    // List Buttons
    // ---------------------------------------------------------------------------------------
    listButtonsDefaults:{
        _constructor:isc.HLayout,
        autoParent:"listLayout",
        height:10, width:10, layoutMargin:6, membersMargin:10,
        overflow:isc.Canvas.VISIBLE
    },

    newButtonTitle:"New",
    newButtonDefaults:{
        _constructor:isc.AutoFitButton,
        autoParent:"listButtons",
        click:"this.creator.newRecord()"
    },

    moreButtonTitle:"More..",
    moreButtonDefaults:{
        _constructor:isc.AutoFitButton,
        autoParent:"listButtons",
        click:"this.creator.editMore()",
        disabled:true
    },

    removeButtonTitle:"Remove",
    removeButtonDefaults:{
        _constructor:isc.AutoFitButton,
        autoParent:"listButtons",
        click:"this.creator.removeRecord()"
    },

    // Form subcomponent
    // ---------------------------------------------------------------------------------------
    formDefaults:{
        _constructor:isc.DynamicForm,
        autoParent:"formLayout",
        overflow:isc.Canvas.AUTO
    },

    // Form Buttons
    // ---------------------------------------------------------------------------------------
    formButtonsDefaults:{
        _constructor:isc.HLayout,
        autoParent:"formLayout",
        height:10, width:10, layoutMargin:6, membersMargin:10,
        overflow:isc.Canvas.VISIBLE
    },

    saveButtonTitle:"Save",
    saveButtonDefaults:{
        _constructor:isc.AutoFitButton,
        autoParent:"formButtons",
        click:"this.creator.saveRecord()"
    },

    cancelButtonTitle:"Cancel",
    cancelButtonDefaults:{
        _constructor:isc.AutoFitButton,
        autoParent:"formButtons",
        click:"this.creator.cancelChanges()"
    },

    resetButtonTitle:"Reset",
    resetButtonDefaults:{
        _constructor:isc.AutoFitButton,
        autoParent:"formButtons",
        click:"this.creator.form.resetValues()"
    },

    // Sublayouts
    // ---------------------------------------------------------------------------------------
    listLayoutDefaults : {
        _constructor:isc.VLayout
    },

    listButtonsOrientation:"left",

    formLayoutDefaults : {
        _constructor:isc.VLayout,
        autoFocus:true
    },

    animateMembers:true,
    membersMargin:10,

    // Changes dialog
    // ---------------------------------------------------------------------------------------
    confirmLoseChangesMessage:"Discard changes?", 


    // AutoChildren
    // ---------------------------------------------------------------------------------------
    draw : function () {
        if (isc._traceMarkers) arguments.__this = this;

    	if (!this.readyToDraw()) return this;
     
        // don't show the edit button by default if we're not allowing inline editing, since
        // just clicking triggers editing
        if (!this.inlineEdit) this.showMoreButton = this.showMoreButton || false;
   
        this.addAutoChildren(this.listGroup);
        this.addAutoChildren(this.formGroup);
        
        return this.Super("draw", arguments);
    },

    formGroup : [
        "formLayout", "form", "formButtons", "saveButton", "cancelButton", "resetButton"
    ],
    listGroup : [
        "listLayout", "list", "listButtons", "newButton", "moreButton"
    ],

    configureAutoChild : function (child, childName) {
        if (isc.isA.Button(child)) child.title = this[childName + "Title"];

        if (child == this.list) {
            child.dataSource = this.dataSource;
            child.fields = this.fields;
            child.saveLocally = this.saveLocally;
            child.canEdit = this.inlineEdit;
        }

        if (this.listButtonsOrientation == isc.Canvas.RIGHT) {
            // place buttons to right of list
            if (child == this.listLayout) child.vertical = false;
            if (child == this.formLayout) child.vertical = false;
            // stack buttons vertically
            if (child == this.listButtons) child.vertical = true;
            if (child == this.formButtons) child.vertical = true;
        }

        if (child == this.form) {
            child.dataSource = this.dataSource;
            child.fields = this.formFields;
        }
        if (this.inlineEdit) {
            if (child == this.formLayout) child.visibility = isc.Canvas.HIDDEN;
        } else {
            if (child == this.listLayout) child.showResizeBar = true;
        }
    },

    // DataSources and Data
    // ---------------------------------------------------------------------------------------

    setDataSource : function (dataSource, fields) {
        this.dataSource = dataSource || this.dataSource;
        if (this.list != null) {
            this.list.setDataSource(dataSource, fields);
            this.form.setDataSource(dataSource, fields);
        }
    },
    setData : function (data) {
        if (data != null && data.dataSource) this.setDataSource(data.dataSource);
        if (this.list != null) {
            this.list.setData(data);
            this.form.clearValues();
        } else {
            isc.addProperties(this.listDefaults, {data:data});
        }
    },
    getData : function () {
        // on a getData call, always save the current edit to the dataSet before returning
        if (this.inlineEdit) this.list.endEditing();
        return this.list.getData();
    },

    // Button / Menu actions
    // ---------------------------------------------------------------------------------------
    
    // cancel button while editing in form
    cancelChanges : function () {
        this.form.clearValues();
        this.showList();
    },

    showList : function () {
        if (this.inlineEdit) {
            this.formLayout.animateHide({effect:"wipe", startFrom:"R"});
            this.listLayout.animateShow({effect:"wipe", startFrom:"R"});
        }
    },
    showForm : function () {
        if (this.inlineEdit) {
            this.listLayout.animateHide({effect:"wipe", startFrom:"R"});
            this.formLayout.animateShow({effect:"wipe", startFrom:"R"});
        }
    },

    // edit via form on recordClick in the list, unless inline editing is allowed
    recordClick : function (record) {
        if (this.inlineEdit) return;
        
        
        var proceed  = function () {
            if (!this.inlineEdit) this.editRecord(record);
            this.form.setValues(isc.addProperties({}, this.list.getSelectedRecord()));
        }

        // editing in parallel form: if there are changes, pop up a warning that this will
        // abandon changes to the currently edited item
        if (!this.form.valuesHaveChanged()) proceed();
        else this.confirmLoseChanges(proceed);
    },

    getEditRecord : function () {
        var editRowNum = this.list.getEditRow();
        if (editRowNum != null) {
            return this.list.getEditedRecord(editRowNum);
        } else {
            return isc.addProperties({}, this.list.getSelectedRecord());
        }
    },

    // More... button, inlineEdit only
    editMore : function () {
        this.showForm();
        this.form.setValues(this.getEditRecord());
    },

    newRecord : function () {
        if (this.inlineEdit) return this.list.startEditingNew()

        var proceed = function () {
            this.list.deselectAllRecords();
            this.showForm();
            this.form.editNewRecord();
        }

        // editing in parallel form: if there are changes, pop up a warning that this will
        // abandon changes to the currently edited item
        if (!this.form.valuesHaveChanges()) proceed();
        else this.confirmLoseChanges(proceed);
    },

    // remove record context click
    removeRecord : function () {
        this.form.clearValues();
        this.list.removeSelectedData();
    },
    saveRecord : function () {
        if (!this.form.validate()) return false;
        var values = this.form.getValues();  
    
        this.showList(); 

        if (this.form.saveOperationType == "add") { // new record
            this.list.addData(values);
        } else {
            // if inline editing is occurring just apply the values as editValues.  We can't
            // count on updateData() because we may have edited a new row that doesn't have a
            // primary key
            if (this.inlineEdit && this.list.getEditRow() != null) {
                var rowNum =this.list.getEditRow();
                
                if (this.list.data[rowNum] != null) this.list.updateData(values)
                else this.list.setEditValues(rowNum, values);
            } else {
                this.list.updateData(values);
            }
        }
        
        return true;
    },

    confirmLoseChanges : function (callback) {
        isc.confirm(this.confirmLoseChangesMessages, callback);
    },

    //
    // ---------------------------------------------------------------------------------------
    validate : function () { 
        if (this.form.isVisible() && this.form.valuesHaveChanged()) {
            return this.form.validate(); 
        }
        return true;
    }
});


} // end if (isc.ListGrid && isc.DynamicForm)
