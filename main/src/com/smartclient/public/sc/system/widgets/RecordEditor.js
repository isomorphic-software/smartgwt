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

 





//>	@class	RecordEditor
//
//  This is a helper class for ListGrids, used to implement showing a filterEditor row.
//  They are created automatically by a ListGrid instance with the 'showFilterEditor' flag set to
//  true, and used to enter criteria, which will then be used to filter the ListGrid.
//
//  RecordEditors are implemented as a subclass of ListGrid, showing no header and a single 
//  row always drawn in the editable state, allowing the user to modify the values at any time.
//  An "action button" is included to perform the filter action action (may also be triggered 
//  by other user interactions).
//  The List Grid that created the RecordEditor will handle sizing, positioning
//  scrolling, field changes/reordering etc. on the RecordEditor.
//

//<

// declare the class itself
isc.ClassFactory.defineClass("RecordEditor", "ListGrid");

isc.RecordEditor.addProperties({
    
    //>	@attr	recordEditor.sourceWidget   (ListGrid : undefined : RW)
    //          Target ListGrid widget for which we're editing data.  Should be defined on
    //          a per-instance basis at init time.
    //<
    //    sourceWidget:null,

    autoDraw:false,
    
    cellSpacing:0, cellPadding:0,

    selectionType:"none",
    showRollOver:false,
    baseStyle:"recordEditorCell",

    // Don't show the header for the list
    showHeader:false,
    
    // If we're set up with no fields, we won't be showing the edit row until setFields is
    // called. In this case don't show the empty message.
    showEmptyMessage:false,

    
    
    bodyOverflow:"hidden",
    
    fixedRecordHeights:true,
    
    
    
    // skinImgDir - used for the button images
    // [Note we are not showing a header so do not need access to the standard listGrid images]
	skinImgDir:"images/RecordEditor/",
    // Images to show on the action button - either add (plus) or filter (funnel)
    saveImg:{src:"[SKIN]add.png", width:16, height:16, showOver:true},
    
    filterImg:{src:"[SKIN]filter.png", width:16, height:16, showOver:true},
    actionButtonStyle:"normal",
    
    // Setting listEndEditAction to "next" allows this list to show an edit row with no associated 
    // record in the data object
    listEndEditAction:"next",
        
    // Don't show the edit click mask - we are not dismissing edits on click outside.
    _showEditClickMask : function () {},

    // specify canEdit true to allow the editRowForm to be shown.
    // Note that we aren't setting an editEvent - this widget is *always* in editable state                                
    canEdit:true,
    
    // Always show the entire row as editable
    editByCell:false,
        
    // avoid focussing on the ListGrid body - we only want to be able to focus on the edit
    // form items within the ListGrid.
    canFocus:false,
    
    // set _resizeWithMaster to false.  We want to resize horizontally with the master, but
    // not vertically - we need to move in order to remain in position below the master instead
    // This is handled by custom logic in listGrid.resizePeersBy()
    _resizeWithMaster:false,
    
    // Apply "normal" style to the body - we don't expect it to have any borders, etc which
    // could get applied to the GR class as a whole
    bodyStyleName:"normal"
    
});

//!>Deferred
isc.RecordEditor.addMethods({

    initWidget : function () {
        
        if (this.sourceWidget != null) {
            
            
            // We want the width to match the sourceWidget's width.  
            // This allows the fields to align with sourceWidget's the body columns
            var source = this.sourceWidget;
            this.setWidth(source.getWidth()-(source.getLeftMargin() + source.getRightMargin()));
            
            // If the sourceWidget is not leaving a scrollbar gap, we shouldn't either - the
            // button will still float over the scrollbar area, but this ensures that any 
            // fields of width "*" will size the same in this widget as in the sourceWidget
            this.leaveScrollbarGap = this.sourceWidget.leaveScrollbarGap;
            
            // If this is a filter editor, perform a filter whenever the user changes fields
            // if this.sourceWidget.filterByCell is true
            if (this.actionType == "filter") {
                this.actOnCellChange = this.sourceWidget.filterByCell;
                this.actOnKeypress = this.sourceWidget.filterOnKeypress;
            } else {
                // Otherwise, if saveByCell is true, perform a save whenever the user changes
                // fields.
                this.actOnCellChange = this.sourceWidget.saveByCell;
            }
            
            // ensure that the editForm is autoFocus:false, we don't want to jump focus into
            // the form everytime it gets redrawn.
            isc.addProperties(this.editFormDefaults, {autoFocus:false});

            // Pick up field ID and fields from the source widget.
            this.fieldIDProperty = this.sourceWidget.fieldIDProperty;
            this.fields = this.sourceWidget.completeFields.duplicate();
        } else {
            this.logWarn("RecordEditor initialized without a sourceWidget property. " +
                         "This widget is not supported as a standalone component.");
        }
        
        return this.Super(this._$initWidget);
    },

    // Override formatCellValue - if this is the removeField, don't show an icon
    // No need to explicitly suppress the "removeRecord" behavior - we already
    // suppress all 'recordClick' behavior for fields
    
    _formatCellValue : function (value, record, field, rowNum, colNum) {
        if (field.isRemoveField) return "&nbsp;"
        return this.Super("_formatCellValue", arguments);
    },

    // Override 'draw()' to ensure that we're editable
    draw : function () {
        var firstEditCell = this.findNextEditCell(0,0,1,true,true);
        if (firstEditCell == null) {
            this.logWarn("No editable fields in this record editor." + 
                        (this.actionType == "filter" ? 
                            " Check the 'canFilter' property for each field in "
                         :
                            " Check the 'canEdit' property for each field in "
                        ) + this.sourceWidget.getID());
        } else {
            // Set up a starting set of edit values based on
            // for filtering: the current filter if there is one, otherwise the field-wise 
            //                defaultFilterValue for each field
            // for editing: the default value of the field
            var isFilter = this.actionType == "filter",
                vals;
            if (isFilter) {
                vals = this.sourceWidget._getFilterEditorValues();            
            } else {
                var undefined;

                vals = {};
                for (var i = 0; i < this.fields.length; i++) {
                    var field = this.fields[i];
                
                    if (field.defaultValue !== undefined) {
                        vals[field[this.fieldIdProperty]] = field.defaultValue;
                    }
                }
            }  
            this.setEditValues(0, vals);
            
            var firstEditCol = firstEditCell[1];
            // Note if we don't have any fields, this is a no-op
            this._startEditing(0,firstEditCol);
        }
        
        this.Super("draw", arguments);
        // Ensure the actionButton shows up on top of the body
        this._actionButton.bringToFront();
    },
    
    setFields : function () {
        this.Super("setFields", arguments);
        
        // If we're drawn(), but we didn't have fields before this setFields call, startEditing
        // now
        var firstEditCell = this.findNextEditCell(0,0,1,true,true);
        if (this.isDrawn() && !this._editorShowing) this._startEditing(0, firstEditCell[1]);
    },

    // Override createChildren to make the actionButton
    createChildren : function () {    
        this.Super("createChildren", arguments);
        // Never allow the body to protrude past the end of the action-button
        if (!this._actionButton) this.makeActionButton();
    },
    
    // MakeActionButton -- this is a button that will float on top of the RecordEditor body, 
    // aligned with the scrollbar of the sourceWidget, with click set to perform the filter
    // or save action using the current set of edit values.
    makeActionButton : function () {
        var actionIcon;

        if (this.actionType == "filter") {
            actionIcon = this.filterImg;
        } else {
            actionIcon = this.saveImg;
        }

        this._actionButton = isc.Button.create({
            
            recordEditor:this,
            
            // Note we want the height to match the rendered inner height of this ListGrid
            // which is the visible height of the body.  However the body hasn't been drawn
            // yet, so we handle this via an override to adjustOverflow(), which also ensures
            // we'll be resized if the body is resized
            //height:this.body.getVisibleHeight(),
            // Float the button over where the body scrollbar would normally appear
            left:this.getInnerWidth() - this.getScrollbarSize(),
            width:this.getScrollbarSize(),
            
            autoDraw: false,

            // use button icon only, no title
            baseStyle: this.actionButtonStyle,
            skinImgDir: this.skinImgDir,
            icon: actionIcon.src,
            showRollOverIcon: actionIcon.showOver,
            // Pick up showFocused if specified
            showFocusedIcon:actionIcon.showFocused,
            showFocusedAsOver:false,

            click : function () {this.recordEditor.performAction();}
        },
        // allow customization of the button
        
        this.actionButtonDefaults, this.actionButtonProperties);
        
        
        this.addChild(this._actionButton);
        
        // use setTabAfter to ensure that the user will tab to the button after tabbing through
        // the edit form fields, which will pick up their tab index from this widget's tabIndex
        this._actionButton._setTabAfter(this);
    },

    
    performAction : function (suppressPrompt) {
        if (this.actionType == "filter") this.performFilter(suppressPrompt);
        else this.performSave(suppressPrompt);
    },

    // performFilter() - filter the source widget with the values from this widget
    // There is a problem with doing this, reported on the forums: http://forums.smartclient.com/showthread.php?t=1933
    // The problem is: if you have a datasource with a hidden field, and you programmatically 
    // filter on that hidden field, and you then try to filter through the filter editor, you lose
    // your programmatic filter.  The solution is to combine the filter editor's values with 
    // values in the existing criteria for fields we don't know about.
    performFilter : function (suppressPrompt) {
        var criteria = this.getValues(),
            oldCriteria = this.sourceWidget.data.criteria;
            
        for (var prop in oldCriteria) {
            // The precise check for undefined here is necessary - if the property is defined but 
            // null, we should be overriding any existing criteria value with null
            var undef;
            if (criteria[prop] === undef) criteria[prop] = oldCriteria[prop];
        }
            
        criteria = isc.DataSource.filterCriteriaForFormValues(criteria);

        
        var context = {};
        if (suppressPrompt) context.showPrompt = false;
        
        // If we're going to hit the server, build in a pause so we don't keep diving off whilst
        // the user is typing rapidly
        var rs = this.sourceWidget.data;
        if (isc.isA.ResultSet(rs) && rs.willFetchData(criteria)) {
            this.fireOnPause("performFilter", {
                target:this.sourceWidget, 
                methodName:"filterData", 
                args:[criteria, null, context]
            }, 
            this.fetchDelay);
        } else {
            this.sourceWidget.filterData(criteria, null, context);
        }
    },
    
    // Add the record to the source widget's data object
    // This method is not completely functional yet - see comments within the method body
    performSave : function (suppressPrompt) {
    
        // ensure we save the value from the current edit field before saving out the
        // entire set of values.
        var rowNum = this.getEditRow(),
            colNum = this.getEditCol(),
            fieldName = this.getFieldName(colNum),
            newValue = this._editRowForm.getValue(fieldName);
        this.setEditValue(rowNum, colNum, newValue);

        // validate the entire row, and save only if validation succeeds:
        var newValues = this.getEditValues(0),
            fields = this.getFields().getProperty(this.fieldIdProperty);

        // This method will show the validation errors, and put focus into the field for 
        // which the validation failed
        if (!this.validateRowValues(newValues, {}, 0, fields)) return;
        
        // xxx
        // At this point we want to fall through to 'saveEditedValues()', but we need to 
        // ensure that the saveEditedValues method on the sourceWidget is aware that we
        // are adding a record rather than overriding exising records.  
        // Currently this does not happen, so we will end up overriding existing records
//        targetList.saveEditedValues(
//            targetList.data.getLength(), 0, null, newValues, {}, isc.ListGrid.PROGRAMMATIC
//        );
  
        // clear out existing edit values, and call startEditing again to start a fresh edit      
        this._clearEditValues(0);
        this._startEditing(0,0);
        // This ensures the edit form values get cleared out.
        for (var fieldName in newValues) {
            this.refreshCell(0,colNum);
        }

    },
    
    // A method to get the current edit-values
    getValues : function () {
        var colNum = this.getEditCol(),
            fieldName = this.getEditFieldName();
        this.setEditValue(0, colNum, this._editRowForm.getValue(fieldName));

        
        return isc.addProperties({},this.getEditValues(0));
            
    },
    
    // Inline Editor overrides:

    // override canEditCell - if this is a filter we want to look at the static 'canFilter'
    // property on the field (inherited from the source widget).  Otherwise just fall through 
    // to the canEditCell implementation on the sourceWidget.
    canEditCell : function (rowNum, colNum) {
        if (this.actionType == "filter") {
            var field = this.getField(colNum);

            if (field == null) return false;
            return (field.canFilter != false);
        } else {
            return this.sourceWidget.canEditCell(rowNum, colNum);
        }
    },

    // Override the various methods to determine the edit form item properties.
    // If this is a filter edit row, we want to use the appropriate 'getFilterEditor...'
    // methods on the source widget -- if this is an editor, we simply inherit the 
    // 'getEditor...' methods from the source widget.
    
    getEditorValueMap : function (field, values) {
        if (this.actionType == "filter") {
            return this.sourceWidget.getFilterEditorValueMap(field);
        } else {
            return this.sourceWidget.getEditorValueMap(field, values);
        }
    },
    
    getEditorType : function (field, values) {
        if (this.actionType == "filter") {
            return this.sourceWidget.getFilterEditorType(field);
        } else {
            return this.sourceWidget.getEditorType(field, values);
        }
    },
    
    // function to re-use as change handler on all our items
    _editorChanged : function () {
        this.form.grid.editorChanged(this);
    },
    
    // Technically this fires on changed, not keypress but it's a cleaner name.
    editorChanged : function (item) {
        var actOnKeypress = item.actOnKeypress != null ? item.actOnKeypress : this.actOnKeypress;                           
        if (actOnKeypress) {
            this.performAction(true);
        }
    },
    
    getEditorProperties : function (field) {
        // Default all items to match this.cellHeight
        var props = {height:this.cellHeight};

        // Pick up optionDataSource from the source widget if a field has a specified dataSource
        // but no optionDataSource.
        
        if (field.displayField && !field.optionDataSource) 
            props.optionDataSource = this.sourceWidget.dataSource;
            
        if (this.actionType == "filter") {
            // For filter editors always allow empty values
            props.allowEmptyValue = true;
            // fire our special changed handler on 'changed'
            props.changed = this._editorChanged;  
            props.actOnKeypress = field.filterOnKeypress;
            
            return isc.addProperties(props, this.sourceWidget.getFilterEditorProperties(field));
        } else {
            return isc.addProperties(props, this.sourceWidget.getEditorProperties(field));
        }
    },
    
    getEditItem : function (editField, record, editedRecord, rowNum, colNum, width) {
        var item = this.Super("getEditItem", arguments),
            filterEditorProps = this.sourceWidget.getFilterEditorProperties(editField),
            undef;
        if (!filterEditorProps) filterEditorProps = {};

        // For filter editors, don't pick up editing related properties such as custom change 
        // handlers from the field. 
        // These are not appropriate on the filter editor since
        // we're not actually performing an edit of a record in the source widget.
        // Note that the developer can still customize these attributes via the
        // filterEditorProperties block for the field.
        // Note: delete rather than setting to explicit null - this ensures the item can pick up
        // the FormItem class defaut properties for these attributes
        if (editField.defaultValue!=null && filterEditorProps.defaultValue === undef) {
            delete item.defaultValue;
        }
        if (editField.change != null && filterEditorProps.change === undef) {
            delete item.change;
        }
        // changed already overridden to '_editorChanged'
        if (editField.defaultDynamicValue != null &&
            filterEditorProps.defaultDynamicValue != null) 
        {
            delete item.defaultDynamicValue;
        }
        if (editField.icons != null && filterEditorProps.icons === undef) {
            delete item.icons;
        }
        if (editField.showPickerIcon != null && filterEditorProps.showPickerIcon === undef) {
            delete item.showPickerIcon;
        }
        return item;
        
    },
    
    
    // cellEditEnd() is fired when the user completes an edit for some cell by tabbing out
    // of that cell, hitting enter or escape, etc.
    // We override the default implementation to avoid cancelling the edit, or saving the
    // edit values into this.values, and to allow us to fire our default action in response
    // to an enter keypress (or a field change).
    cellEditEnd : function (editCompletionEvent, newValue) {

        // Possible editCompletionEvents are:
        // - CLICK_OUTSIDE - suppressed as we don't show the clickMask for this ListGrid
        // - ESCAPE_KEYPRESS - ignore
        // - UP_ARROW_KEYPRESS - ignore
        // - DOWN_ARROW_KEYPRESS - ignore
        // - EDIT_ROW_CHANGE - will not happen as we don't have more than one row
        // - PROGRAMMATIC - ignore
        //
        // - ENTER_KEYPRESS - fire this.performAction - will perform a filter if this
        //                    is a filter editor (or a save if this is an editor)
        // - TAB_KEYPRESS - 
        // - SHIFT_TAB_KEYPRESS - 
        // - EDIT_FIELD_CHANGE - 
        //              For all field changes, save out the edit values, and move to the 
        //              appropriate fields.
        //              If this.actOnCellChange is true, also fire this.performAction().
        if (editCompletionEvent != isc.ListGrid.ENTER_KEYPRESS &&
            editCompletionEvent != isc.ListGrid.TAB_KEYPRESS && 
            editCompletionEvent != isc.ListGrid.SHIFT_TAB_KEYPRESS &&
            editCompletionEvent != isc.ListGrid.EDIT_FIELD_CHANGE) return true;

        var undef;
        if (newValue === undef) newValue = this.getUpdatedEditorValue();
            
        var rowNum = this.getEditRow(),
            colNum = this.getEditCol();

        // update the locally stored edit info with the new value for the appropriate field
        this.setEditValue(rowNum, colNum, newValue);

        // Save / query on enter keypress
        if (editCompletionEvent == isc.ListGrid.ENTER_KEYPRESS || this.actOnCellChange) {
            this.performAction();
            if (editCompletionEvent == isc.ListGrid.ENTER_KEYPRESS) return;            
        }
                
        var nextCell = this.getNextEditCell(rowNum, colNum, editCompletionEvent);
            
        if (nextCell == null || nextCell[0] != rowNum) {
            // if we're tabbing past the end of the row, we want to put focus onto the
            // appropriate object on the page.
            // We have to do this explicitly, because we've overridden the key press
            // method on the editor form items to suppress the native tab-behavior.
            if (editCompletionEvent == isc.ListGrid.TAB_KEYPRESS) {
                // we know that the next tab item is the action button.
                this._actionButton.focus();
            } else {
                // On shift tab, move focus to the previous widget in the tab order.
                // This assumes that this widget has an auto-assigned tab index.
                if (this._previousTabWidget != null) this._previousTabWidget.focus();
            }
            return;
        }
        
        // In this case we want to fall through to the superclass implementation - this
        // will validate the cell value (if necessary), save the editValue locally, and
        // move focus to the appropriate cell.
        // xxx - Could just reimplement the relevant code here rather than calling Super
        //       to avoid (EG) calling 'getNextEditCell()' more than once.
        return this.Super("cellEditEnd", arguments);
    },

    // clearEditValue on the superclass will dismiss the editor if no editValues are left.  The
    // recordEditor never wants to do this.
    clearEditValue : function (editValuesID, fieldName) {
        return this.Super("clearEditValue", [editValuesID, fieldName, null, true]);
    },

    // UI Synching:

    // Ensure the action button stays positioned / sized correctly
    // Override layoutChildren to keep the action button positioned at the right edge of this
    // widget
    layoutChildren : function () {
        this.Super("layoutChildren", arguments);
        // Stick the action button to the left
        if (this._actionButton) 
            this._actionButton.setLeft(this.getInnerWidth() - this.getScrollbarSize())
        // Ensure the body does not extend behind the action button - this avoids issues
        // where we can't scroll the source widget horizontally to get at stuff under the
        // V-Scrollbar
        if (this.body) {
            var body = this.body;
            if (this.bodyLayout) body = this.bodyLayout;
            body.setWidth(this.getInnerWidth() - this.getScrollbarSize())
        }
    },


    // Override adjustOverflow to render the actionButton as tall as this widget
    adjustOverflow : function () {
        this.Super("adjustOverflow", arguments);
        if (this._actionButton) {
            this._actionButton.setHeight(this.body.getVisibleHeight());
        }            
    },
    
    // We need to keep our UI in synch with our source widget.
    // This means:
    // - Show and Hide with source widget.
    //      Handled by standard peer relationship
    // - Move with source widget
    //      Handled by standard peer relationship
    // - Resize with source widget, and remain positioned below source widget
    //      Handled by ListGrid.resizePeersBy() method
    // - Scroll body with the source widget body
    //      RecordEditor bodyScrolled() overridden below to keep source widget body in synch 
    //      with us.
    //      ListGrid bodyScrolled() method handles keeping us in synch with source widget body
    //      scroll position.
    // - Resize fields with the source widget
    //      Handled by source widget resizeField()
    // - Reorder / Change fields with the source widget   
    //      Handled by source widget reorderFields()

    // Override bodyScrolled() to keep the body scrolling in synch.
    // Note that bodyScrolled implementation on the source widget will handle scrolling this
    // widget into place.
    bodyScrolled : function (left, top) {
        this.Super("bodyScrolled", arguments);

        // Scroll the sourceWidget body to our position
        // Only do this if it's not already scrolled to the same position as us
        
        if (this._syncSourceEvent != null) {
            isc.Timer.clear(this._syncSourceEvent);
        }
        this._syncSourceEvent = this.delayCall("syncSourceScrolling", [], 0);
    },
    
    syncSourceScrolling : function () {
        var left = this.body.getScrollLeft();

        if (this.sourceWidget && this.sourceWidget.body && 
            this.sourceWidget.body.getScrollLeft() != left) {
            
                this.sourceWidget.body.scrollTo(left);
        }
    },

    // override 'getFieldWidths' to get the source's field widths.
    
    getFieldWidths : function () {
        var widths = this.sourceWidget.getFieldWidths();
        // duplicate the widths so modifications on the LG widths array won't directly effect
        // our widths
        if (isc.isA.Array(widths)) widths = widths.duplicate();
        return widths;
    },
    // getEditFormItemFieldWidths():
    // Overridden to reduce the size of the last edit item to ensure it fits in the available
    // space (isn't clipped by the filter button), even if the sourceWidget's field is sized larger
    // than the available space
    // Happens when the source widget shows an HScrollbar but no VScrollbar
    _correctForActionButtonClipping : function () {
        return (this.sourceWidget && this.sourceWidget.body &&
                 !this.sourceWidget.body.vscrollOn);
    },
    getEditFormItemFieldWidths : function (record) {
        var widths = this.Super("getEditFormItemFieldWidths", arguments);
        if (this._correctForActionButtonClipping()) {
            var taken = widths.sum(),
                space = this.getInnerWidth() - this.getScrollbarSize();
                
            if (taken > space) {
                widths[widths.length-1] -= Math.min(this.getScrollbarSize(), (taken - space));
            }
        }
        return widths;
    },

    
    getEditItemCellValue : function (record, rowNum, colNum) {
        var HTML = this.Super("getEditItemCellValue", arguments);
        if (colNum == this.fields.length-1 && this._correctForActionButtonClipping()) {
            var item = this.getEditForm().getItem(this.getEditorName(rowNum, colNum)),
                diff = this.getFieldWidth(colNum) - item.getWidth();
            if (diff > 0) {
                HTML += isc.Canvas.spacerHTML(diff, 1);
            }
        }
        return HTML;
    },
    
    // Override rebuildForFreeze to no-op
    // We'll instead respond to our source-element's rebuild for freeze
    rebuildForFreeze : function () {
    },
    
    // Override rowClick / rowDoubleClick to no-op
    // This means if we have any fields which are canFilter:false, we'll avoid executing the
    // field level recordClick / recordDoubleClick handlers when the user clicks them.
    rowClick : function () {},
    rowDoubleClick : function () {}
});
//!<Deferred


