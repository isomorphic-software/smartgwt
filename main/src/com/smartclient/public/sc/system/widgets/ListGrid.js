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




//>	@class	ListGrid
// A ListGrid is a +link{DataBoundComponent} that displays a list of objects in a grid, where
// each row represents one object and each cell in the row represents one property. 
//
//  @implements DataBoundComponent    
//  @treeLocation Client Reference/Grids
//  @visibility external
//<
isc.ClassFactory.defineClass("ListGrid", "Canvas");

// Synonym for backCompat.  NOTE: define an alias rather than make a subclass, otherwise, attempts
// to skin the class using the old name would only affect the subclass!
isc.addGlobal("ListViewer", isc.ListGrid);
// define groups for documentation purposes

    //> @groupDef data
    //<

    //> @groupDef databinding
    // DataBinding means the automatic, highly customizable process of 'binding' a UI component
    // to a DataSource, so that a UI component displays, edits and saves DataSource records
    // using appropriate formatters, editors, validation rules, and persistance logic.
    // 
    // @see interface:DataBoundComponent
    // @title DataBinding
    //<

    //> @groupDef sorting
    //< 

    //> @groupDef dragging
    //<

    //> @groupDef editing
    // Data being displayed by a grid may be edited within the grid, by showing editing
    // interfaces embedded inside the cells of the grid.
    // <P>
    // <b>Enabling editing</b>
    // <P>
    // Editing is enabled when +link{listGrid.canEdit,canEdit} is <code>true</code>.  When enabled,
    // the user can begin editing via the 
    // +link{listGrid.editEvent,editEvent}, typically click or double-click.  Editing can also be triggered
    // programmatically by a call to +link{listGrid.startEditing,startEditing()} or
    // +link{listGrid.startEditingNew,startEditingNew()}.
    // <P>
    // <b>New record creation</b>
    // <P>
    // By default, editing is restricted to existing records.  Setting +link{listGrid.listEndEditAction} to
    // "next" allows the user to create new records by simply navigating off the end of the dataset
    // with the keyboard.  Editing of new records can also be initiated with 
    // +link{listGrid.startEditingNew()}, for example, from a button outside the grid.
    // <P>
    // <b>Saving changes</b>
    // <P>
    // Saving of changes is triggered automatically when the user navigates out of the row or cell
    // being edited (based on +link{listGrid.saveByCell}) or when the user ends editing.   For
    // a "mass update" interface, automatic saving of changes can be disabled entirely via 
    // +link{listGrid.autoSaveEdits,autoSaveEdits:false}, in which case a manual call to 
    // +link{listGrid.saveEdits,saveEdits()} or +link{listGrid.saveAllEdits,saveAllEdits()} is required
    // to trigger saving. 
    // <P>
    // If a grid has no DataSource, saving means that the properties of the +link{ListGridRecord}s
    // in +link{listGrid.data,grid.data} are directly changed.
    // <P>
    // For a grid with a DataSource, saving will be accomplished by using DataSource "update"
    // operations for existing records, and DataSource "add" operations for new records.  If multiple
    // records have been edited and +link{listGrid.saveAllEdits,saveAllEdits()} is called, 
    // +link{rpcManager.startQueue,request queuing} will be automatically used to enable all
    // edits to be saved in one HTTP turnaround (if using the SmartClient Server).
    // <P>
    // By default, a grid will send only updated fields and the primaryKey field as part of 
    // +link{dsRequest.data} so that the server can discern which fields the user actually changed.
    // However, the grid always includes the original field values in the
    // dsRequest as +link{dsRequest.oldValues}.
    // <P>
    // Note that although it is possible to load DataSource data without actually declaring a
    // +link{dataSourceField.primaryKey,primaryKey field}, a primaryKey must be declared for
    // editing and saving.  The primaryKey value is how SmartClient identifies the changed
    // record to the server.
    // <P>
    // <b>Validation</b>
    // <P>
    // Any time saving is attempted, validation is automatically triggered.  Values entered by the
    // user will be checked against the +link{listGridField.validators} and the
    // +link{dataSourceField.validators}. Any invalid values abort an attempted save.
    // <P>
    // Similar to editing and saving, validation can be done on row transitions or on cell
    // transitions by setting +link{listGrid.validateByCell,validateByCell}, or can be disabled entirely
    // via +link{listGrid.neverValidate,neverValidate:true}.
    // <P>
    // <b>Editability of cells</b>
    // <P>
    // Editors will either be shown for the complete row or for a single cell based on 
    // +link{listGrid,editByCell,editByCell}.  Whether a cell can be edited can be controlled on a
    // per field basis by setting +link{listGridField.canEdit,field.canEdit}, or on a per-record basis
    // by setting +link{listGrid.recordEditProperty,recordEditProperty} on a 
    // +link{ListGridRecord,record}, or can be controlled on an arbitrary, programmatic basis via
    // an override of +link{listGrid.canEditCell()}.
    // <P>
    // Cells which are not editable just display the cell's current value.
    // <P>
    // <b>Keyboard Navigation</b>
    // <P>
    // Full keyboard navigation is supported by default, including Tab and Shift-Tab to navigate
    // between cells in a row, and Up Arrow and Down Arrow to traverse rows.  Several properties
    // on both grids and fields, all named *EditAction, control navigation behavior of certain keys
    // (eg Enter).
    // <P>
    // You can use +link{listGrid.startEditing,startEditing(<i>rowNum</i>, <i>colNum</i>)} to 
    // programmatically move editing to a particular cell, for example, during a 
    // +link{listGridField.changed,field.changed()} event.
    // <P>
    // <b>editValues (unsaved changes)</b>
    // <P>
    // The term "editValues" means changes that the user has made to the dataset which have not
    // been saved.  The grid manages and stores editValues separately from the data itself in order
    // to allow the user to revert to original values, and in order to enable to grid to send only
    // updated fields to the server.  
    // <P>
    // Because editValues are stored separately, if you directly access the dataset (eg via 
    // <code>grid.data.get()</code>) you will see the records without the user's unsaved changes.
    // Many APIs exist for retrieving and managing editValues (search for editValue).
    // For the common case of needing to access the record-as-edited, you can call 
    // +link{listGrid.getEditedRecord,grid.getEditedRecord(rowNum)}.
    // <P>
    // When accessing and manipulating edited data, you should think carefully about whether
    // you want to be working with the original data or with the edited version.  Values entered
    // by the user may not have been validated yet, or may have failed validation, hence you may
    // find a String value in a field of type "date" or "int", which could cause naive formatters or
    // totalling functions to crash.
    // <P>
    // Setting editValues is fully equivalent to the user making changes to data via the editing UI.
    // If you <i>also</i> allow editing external to the grid, setting editValues is one way to 
    // combine changes from external editors into the grid's edits, so that you can do a single 
    // save.
    // <P>
    // <b>Customizing Cell Editors</b>
    // <P>
    // When a cell is being edited, the editor displayed in the cell will be a +link{class:FormItem}.
    // The editor type for the cell will be determined by +link{listGrid.getEditorType()} based on the
    // specified +link{ListGridField.editorType} or +link{ListGridField.type, data type} for the field in
    // question.
    // <P>
    // You can customize the editor by setting +link{listGridField.editorProperties} to a set of
    // properties that is valid for that FormItem type.  Custom FormItem classes are also allowed,
    // for example, you may use +link{formItem.icons} to create an icon that launches a separate
    // +link{Dialog} in order to provide an arbitrary interface that allows the user to select the
    // value for a field.
    // <P>
    // <b>Events</b>
    // <P>
    // Editing triggers several events which you can provide handlers for in order to customize
    // editing behavior.  Some of the most popular are +link{listGridField.change,field.change()},
    // +link{listGridField.changed,field.changed()} for detecting changes made by the user,
    // +link{listGrid.cellChanged()} for detecting changes that have been successfully saved,
    // and +link{listGrid.editorEnter()} and +link{listGrid.editorExit,editorExit()} for detecting user
    // navigation during editing.
    // <P>
    // You can also install event handlers directly on the FormItem-based editors used in the grid
    // via +link{listGridField.editorProperties,editorProperties} as mentioned above.  When handling
    // event on items, or which involve items, be aware that in addition to standard 
    // +link{FormItem} APIs, editors have the following properties:
    // <P>
    // - <code>rowNum</code>: The rowNum of the record being edited.<br>
    // - <code>colNum</code>: The colNum of the cell being edited.<br>
    // - <code>grid</code>: A pointer back to the listGrid containing the record.
    //
    // @title Grid Editing
    // @visibility external
    //<
    // Note: we also include a pointer to the record on the FormItem - don't expose this for now
    // as the user will be more likely to want to work with the result of 'getEditedRecord()' than
    // the underlying record values.

	//> @groupDef imageColumns
	// Columns that show images either as their only appearance or in addition to text.
	//<


isc.defineClass("GridBody", isc.GridRenderer).addProperties({
    // suppress adjustOverflow while pending a redraw so we can resize smaller without seeing 
    // a scrollbar flash in and out of existance
    adjustOverflowWhileDirty:false,
    
    
    // adjustOverflow() - overridden to support 'autoFitData' behavior
    
    adjustOverflow : function (reason, a,b,c,d) {
        
        // If we're showing the loading message, avoid resizing at all
        // when the data returns we'll be resized and we don't want to flash to another size
        // temporarily
        var grid = this.grid;
        if (grid && grid.data && grid.data.getLength() > 0 && Array.isLoading(grid.data.get(0))) 
        {
            return this.invokeSuper(isc.GridBody, "adjustOverflow", reason,a,b,c,d);
        }
        
        var fitVertical = (this.autoFitData == "both"),
            fitHorizontal = fitVertical;
        if (!fitVertical) fitVertical = (this.autoFitData == "vertical");
        if (!fitHorizontal) fitHorizontal = (this.autoFitData == "horizontal");
        if (fitHorizontal || fitVertical) {
            // This logic doesn't currently handle percentage sizes
            // To handle this we'll need to remember the specified percent size, resolve to a number
            // and compare with the overflowing size each time
            if (!this._specifiedHeight) this._specifiedHeight = this.getHeight();
            if (!this._specifiedWidth) this._specifiedWidth = this.getWidth();
            var height, width, hscrollOn, vscrollOn, dX, dY;
            if (fitVertical) {
                height = this._specifiedHeight;
                var totalRows = this.getTotalRows(),
                    rows = totalRows;
                // ignore autoFitMaxRecords if set to zero - this means fit to all records!
                if (this.autoFitMaxRecords) rows = Math.min(rows, this.autoFitMaxRecords);
                if (rows > 0) {
                
                    var rowHeights = 0,
                        // We need to handle variable rowHeights so we're going to have to look at
                        // the table element to determine the heights - we already have a method to
                        // do that
                        drawnRowHeights = this._getDrawnRowHeights();
                        
                    // If we have any undrawn rows assume calculated sizes
                    
                    var firstDrawnRow = this._firstDrawnRow,
                        lastDrawnRow = this._lastDrawnRow;
                    // fdr / ldr unset implies no drawn rows - set such that we calculate
                    // theoretical heights only
                    if (this._firstDrawnRow == null) {
                        firstDrawnRow = rows;
                        lastDrawnRow = rows;
                    }
                    if (firstDrawnRow > 0) {
                        firstDrawnRow = Math.min(firstDrawnRow, rows);
                        for (var i = 0; i < firstDrawnRow; i++) {
                            rowHeights += this.getRowHeight ? 
                                            this.getRowHeight(i) : this.celHeight;
                        }                        
                    }
                    if (lastDrawnRow < rows-1) {
                        for (var i = lastDrawnRow+1; i < rows; i++) {
                            rowHeights += this.getRowHeight ? 
                                            this.getRowHeight(i) : this.celHeight;
                        }                        
                    }
                    // Measure the rendered rows and add up the heights.
                    lastDrawnRow = Math.min(lastDrawnRow, rows-1);
                    for (var i = firstDrawnRow; i <= lastDrawnRow; i++) {                        
                        rowHeights += drawnRowHeights[i];
                    }
                    // If we are clipping off any rows we know we have a v-scrollbar
                    vscrollOn = totalRows > rows;
                    
                    // Treat autoFitMaxHeight:0 as unspecified - resize as large as necessary
                    var autoFitMaxHeight = this.getAutoFitMaxHeight();
                    if (autoFitMaxHeight && rowHeights > autoFitMaxHeight) {
                        rowHeights = autoFitMaxHeight                 
                        vscrollOn = true;
                    }
                    
                    //this.logWarn("total rows to show:"+ rows +
                    // ", rendered:" + [this._firstDrawnRow,this._lastDrawnRow] +
                    // ", rowHeights total up to:"+ rowHeights + ", specified height:" +
                    // this._specifiedHeight);
                    if (rowHeights > height) height = rowHeights;
                    else {
                        // if our specified height exceeds the height of our limited number of rows
                        // we may or may not be showing a scrollbar - just measure this.scrollHeight
                        var contentHeight = this.getScrollHeight();
                        vscrollOn = (contentHeight >= height) 
                    }                    
                }
                
                /*
                // Equivalent code that reaches into the table element directly rather than 
                // relying on this._drawnRowHeights - less code but doesn't make use of 
                // exsiting _drawnRowHeights cacheing / offset height calculations
                for (var i = 0; i < rows; i++) {

                    var row = this.getTableElement(i);
                    if (!row) {
                        rowHeights += this.getRowHeight ? this.getRowHeight(i) : this.cellHeight;
                    } else{
                        
                        rowHeights += row.offsetHeight;
                    }
                }
                */
                
            } else {
                vscrollOn = this.getScrollHeight() > (this._specifiedHeight || this.getHeight());
            }
            
            if (fitHorizontal) {
                var colSizes = this.getColumnSizes();
                var contentWidth = colSizes.sum();
                if (this.autoFitMaxColumns && this.autoFitMaxColumns < colSizes.length) {
                    colSizes = colSizes.slice(0,this.autoFitMaxColumns);
                }
                var colWidths = colSizes.sum();
                if (this.autoFitMaxWidth) colWidths = Math.min(this.autoFitMaxWidth, colWidths);
                
                width = Math.max(this._specifiedWidth, colWidths);
                hscrollOn = contentWidth > width;
            } else {
                hscrollOn = this.getScrollWidth() > (this._specifiedWidth || this.getWidth());
            }
            
            // Adjust height and width for scrollbars / borders / margin if appropriate
            if (height != null && height != this._specifiedHeight) {
                
                height += this.getVBorderPad() + this.getVMarginSize();
                if (hscrollOn) {
                    height += this.getScrollbarSize();
                    var autoFitMaxHeight = this.getAutoFitMaxHeight()
                    if (autoFitMaxHeight && height > autoFitMaxHeight) {
                        height = autoFitMaxHeight;
                    }
                }
            }
            if (width != null && width != this._specifiedWidth) {
                
                width += this.getHBorderPad() + this.getHMarginSize();
                if (vscrollOn || this.alwaysShowVScrollbar) {
                    width += this.getScrollbarSize();
                    if (this.autoFitMaxWidth && width > this.autoFitMaxWidth) {
                        width = this.autoFitMaxWidth;
                    }
                }
            }

            // Calculate the delta with our current size.
            dY = this.getDelta(this._$height, height, this.getHeight());
            dX = this.getDelta(this._$width, width, this.getWidth());
            
            // If necessary resize to accomodate content!
            if (dY != null || dX != null) this.resizeBy(dX, dY, null, null, true);
            
            // if width != null, resize header to match body
            if (width != null) {
                var lg = this.parentElement,
                    header = lg.header;
                if (header && header.isDrawn()) {
                    header.setWidth(width - (vscrollOn ? lg.getScrollbarSize() : 0));
                }
                if (lg.sorter && lg._showSortButton() && !lg.isRTL()) {
                    lg.sorter.setLeft(width - lg.getScrollbarSize());
                    if (!lg.sorter.isVisible()) lg.sorter.show();
                } else if (lg.sorter) {
                    lg.sorter.setLeft(0 - lg.sorter.getWidth());
                }
            }
        
        // if autoFitData is null but we don't match our 'specified size', assume the property
        // has been modified and reset to specified size
        }
        
        // catch the case where autoFitData has been cleared in either direction and
        // reset to specified size.
        if ((!fitVertical && this._specifiedHeight && (this.getHeight() != this._specifiedHeight))
            || (!fitHorizontal && this._specifiedWidth &&
                 (this.getWidth() != this._specifiedWidth)) )
        {
            this.resizeTo(this._specifedHeight, this._specifiedWidth);
            // reset field widths on the grid to resize the header to match the body
            this.parentElement._updateFieldWidths("autoFitData mode changed");
        }
        return this.invokeSuper(isc.GridBody, "adjustOverflow", reason, a,b,c,d);
    },
    
    getAutoFitMaxHeight : function () {
        return this.parentElement ? this.parentElement.getAutoFitMaxBodyHeight() : null;
    },
    
    resizeBy : function (deltaX, deltaY, animating, suppressHandleUpdate, autoFitSize) {
        
        // autoFitSize parameter: When autoFitData is true for this grid, we resize the
        // body to fit the data, and pass in the autoFitSize parameter to this method.
        // In the case of an explicit resize outside the autoFitData system, hang onto the
        // specified size so we can reset to it if the data shrinks, etc
        if (!autoFitSize) {
            this._specifiedHeight = this.getHeight() + (deltaY != null ? deltaY : 0);
            this._specifiedWidth = this.getWidth() + (deltaX != null ? deltaX : 0);
        }

        // Note that return value of resizeBy indicates whether the size actually changed
        return this.invokeSuper(isc.GridBody, "resizeBy", 
                                deltaX, deltaY, animating, suppressHandleUpdate, autoFitSize);
    },
    
	// context menus (NOTE: ListGrid-level handling is identical for cell vs row context click)
    cellContextClick : function (record, rowNum, colNum) {
        return this.grid._cellContextClick(record, rowNum, colNum);
    },
    
    // this ensures that if we're not showing any records we can still scroll the header fields
    // into view.
    expandEmptyMessageToMatchFields:true,
    
    getInnerHTML : function () { 
        // call bodyDrawing on the LG if we are the primary body
        if (this == this.grid.body) this.grid.bodyDrawing(this);
        return this.Super("getInnerHTML", arguments);
    },
    
    // cellAlignment - override to account for the fact that with frozen fields, body 
    // colNum may be offset from ListGrid colNum
    getCellVAlign : function (record, field, rowNum, colNum) {
        if (this.grid && this.grid.getCellVAlign) {
            var gridColNum = this.grid.getFieldNumFromLocal(colNum, this);
            return this.grid.getCellVAlign(record, rowNum, gridColNum);
        }
    },
    getCellAlign : function (record, field, rowNum, colNum) {
        
        if (this.grid && this.grid.getCellAlign != null) {
            var gridColNum = this.grid.getFieldNumFromLocal(colNum, this);
            return this.grid.getCellAlign(record, rowNum, gridColNum);
            
        } else return field.cellAlign || field.align;
    },
    
    // if this is removed, DONTCOMBINE directive no longer needed in GridRenderer.js
    _drawRecordAsSingleCell : function (rowNum, record,c) {
        var lg = this.grid;
        if (lg.showNewRecordRow && lg._isNewRecordRow(rowNum)) return true;
        
        return isc.GridRenderer._instancePrototype.
            _drawRecordAsSingleCell.call(this, rowNum,record,c);    
        //return this.Super("_drawRecordAsSingleCell", arguments);
    },

		// observe the scroll routine of the body so we can sync up
    scrollTo : function (left, top, cssScroll, dontReport) {

        if (isc._traceMarkers) arguments.__this = this;
        // Clamp the positions passed in to the edges of the viewport
        // (avoids the header from getting out of synch with the body.)
        
        if (left != null) {
            var maxScrollLeft = this.getScrollWidth() - this.getViewportWidth();
            left = Math.max(0, Math.min(maxScrollLeft, left));
        }
        if (top != null) {
            var maxScrollTop = this.getScrollHeight() - this.getViewportHeight();
            top = Math.max(0, Math.min(maxScrollTop, top));
        }            
        var lg = this.grid;

    	//this.logWarn("body.scrollTo: " + this.getStackTrace());
        if (!dontReport) lg.bodyScrolled(left, top, this);
        this.invokeSuper(null, "scrollTo", left,top,cssScroll, dontReport);
        
        // If the body scrolled without forcing a redraw, ensure any visible edit form 
        // items are notified that they have moved.
        
        if (!this.isDirty() && lg._editorShowing) {
            lg._editRowForm.itemsMoved();
        }
        
    },
    
    // Redraw overridden:
	// - Update the editRow form items (we don't create more items than we need when
	//   rendering incrementally)
	// - Update the values in the edit row form.
    redraw : function (reason,b,c,d) {
        // flag to note we're redrawing - this is used by getDrawnFields() 
        this._redrawing = true;
        var lg = this.grid,
            
            editForm = lg._editRowForm,
            editing = lg._editorShowing,
            editColNum, editRowNum, editRecord,
            completeWidths,
            fieldsToRemove;

        // if body redraw came from data change, folder opening, or resizing of content,
        // it's likely to introduce a v-scrollbar.
        // If leaveScrollbarGap is false, call '_updateFieldWidths()' before the redraw occurs so
        // we leave a gap for the v-scrollbar, rather than redrawing with both V and H scrollbar,
        // then resizing the fields and redrawing without an H-scrollbar.
        if (!lg.leaveScrollbarGap && lg.predictScrollbarGap && (this.overflow == isc.Canvas.AUTO)) {
            var vScrollOn = this.vscrollOn,
                
                vScrollWillBeOn = !lg.isEmpty() && 
                                  (lg.getTotalRows() * lg.cellHeight)  > this.getInnerHeight();
            
            if (vScrollOn != vScrollWillBeOn) {
                lg._updateFieldWidths("body redrawing with changed vertical scroll-state");            
            }
        } 

        if (editing) {
            
            this.logInfo("redraw with editors showing, editForm.hasFocus: " +
                         editForm.hasFocus, "gridEdit");
            editColNum = lg.getEditCol();                             
            
            // See comments near _storeFocusForRedraw() for how edit form item focus is handled
            // on redraw
            this._storeFocusForRedraw();

            // This will add the new edit items corresponding to the newly displayed fields
            // and return the items that need to be removed (after the body is actually redrawn,
            // which will hide them)
            // It also fires the "redrawing" notification on any items that are about to be redrawn
             fieldsToRemove = this._updateEditItems();
        } 

        

        this.invokeSuper(null, "redraw", reason,b,c,d);
        // clear the "redrawing" flag since the HTML is now up to date
        delete this._redrawing;

        if (editing) {
            // Remove the items that correspond to fields that are no longer rendered in the DOM
            if (fieldsToRemove != null && fieldsToRemove.length > 0) {
                editForm.removeItems(fieldsToRemove);
            }
            
            // Fire the method to notify form items that they have been drawn() / redrawn()
            // or cleared()
                        
            lg._editItemsDrawingNotification(null, true, this);
            
            /*
            var itemColArray = [],
                items = lg._editRowForm.getItems();
            for (var i =0; i < items.length; i++) {
                itemColArray.add(items[i].colNum + " - " + items[i].name);
            }
            this.logWarn("After redraw - edit form covers these cols:" + itemColArray);
            */

        	
            lg.updateEditRow(lg.getEditRow());           
            
            // If the editRowForm is currently marked as having focus, or we took focus from it
            // before a redraw and no other widget has subsequently picked up focus, restore focus
            // to it
            // This catches both a simple redraw and the case where the user scrolls the edit item
            // out of view, it is cleared due to incremental rendering, then scrolls back into view
            // and it gets redrawn
        	
            if (editForm.hasFocus || 
                (this._editorSelection && isc.EH.getFocusCanvas() == null)) 
            {
                this._restoreFocusAfterRedraw(editColNum);
            } else {                
                delete this._editorSelection;
            }
            
        } else if (editForm != null) {      
            // notify the form that it's items have been cleared() (will no-op if they're
            // not currently drawn)
            lg._editItemsDrawingNotification(null, null, this);
        }    
    },
    
    // Add edit items corresponding to newly displayed fields (displayed due to incremental
    // rendering)
    // If any fields are to be hidden, do not remove these here, but return them in an array so
    // they can be removed from the form after the redraw completes
    // Note that the order of items in the form will not match the order of fields necessarily - 
    // acceptable since developers will be interacting with the items' colNum attribute rather than
    // index in the edit form fields array.
    
    _updateEditItems : function () {

        // We keep the set of items in the editForm in synch with the set of 
        // visible columns for performance.
        // Determine which items need to be created or removed here.
        var lg = this.grid, editForm = lg.getEditForm(),
            fieldsToRemove = [],
            editItems = editForm.getItems();
        if (!lg.editByCell) {

            // set up the vars used in creating form items
            var editRowNum = lg.getEditRow(),
                editRecord = lg.getRecord(editRowNum),
                
                completeWidths = lg.getEditFormItemFieldWidths(editRecord);
         
            // Determine what fields are rendered into the body
            // If we have frozen columns, we will always be showing them, in addition to whatever
            // fields are visible
            var editItems = editForm.getItems(),
                itemNames = editItems.getProperty(this.fieldIdProperty),
                fields = lg.getDrawnFields(),
                fieldNames = fields.getProperty(this.fieldIdProperty);
            
            // minor optimization - if possible, avoid iterating through both arrays
            var lengthsMatch = editItems.length == fields.length,
                changed = false;
                
            // fields that are no longer drawn should be removed
            for (var i = 0; i < editItems.length; i++) {
                // don't actually remove the items until they have been removed from the DOM via
                // redraw
                var index = fieldNames.indexOf(itemNames[i]);
                if (index == -1) {
                    changed = true;
                    fieldsToRemove.add(editItems[i]);
                } else {
                    // If we're keeping the item, just update width, and notify the item we're
                    // about to redraw
                    editItems[i].width = completeWidths[editItems[i].colNum];
                    editItems[i].redrawing();
                }
            }
            // newly rendered fields should be added
            if (!lengthsMatch || changed) {      
                var editedVals = lg.getEditedRecord(editRowNum, 0);
                for (var i = 0; i < fields.length; i++) {                    
                    if (!itemNames.contains(fieldNames[i])) {

                        var colNum = lg.fields.indexOf(fields[i]);
                        var item = lg.getEditItem(
                                        fields[i],
                                        editRecord, editedVals, editRowNum,
                                        colNum, completeWidths[colNum]
                                   );
                        editForm.addItem(item);
                    }
                }
            }
        } 
        // if editByCell is true this is not necessary - we consistantly have the editForm contain
        // only the necessary cell
        return fieldsToRemove;
    },  

    // _storeFocusForRedraw()
    // called when the edit form is showing and the body is being redrawn.
    // remember the current focus state / selection of the edit form so we can reset it after
    // redrawing the item in the DOM
    // blur the item (suppressing the handler if the item will be refocussed after redraw) 


    
    
        
    _storeFocusForRedraw : function () {

        var lg = this.grid,
            editForm = lg.getEditForm(),
            editColNum = lg.getEditCol();
        if (editForm.hasFocus) {
            var focusItem = editForm.getFocusItem();      
            if (focusItem) {
                focusItem.updateValue();
                
                // We may be focussed in a sub item, in which case we need to use the
                // parentItem to get the field name wrt our fields array
                while (focusItem.parentItem != null) {
                    focusItem = focusItem.parentItem;
                }
                
                // blur the focus item before removing it from the DOM.
                // If canEditCell for the current focus item returns false, we will
                // not redisplay it at the end of this method, so allow it to fire the
                // standard blur-handler
                
                if (!lg.canEditCell(focusItem.rowNum, focusItem.colNum) ||
                    editColNum != focusItem.colNum) {
                    
                    editForm.blur();
                } else {
                    // remember the current selection, so we can reset it after the redraw
                    // and refocus. [will have no effect if the item is not a text-item]
                    focusItem.rememberSelection();
                    this._editorSelection = 
                        [focusItem._lastSelectionStart, focusItem._lastSelectionEnd];
                    editForm._blurFocusItemWithoutHandler();
                }
                
            }
        }
        
        editForm._setValuesPending = true;        
    },
    
    // If the editForm is visible during a body redraw() this method ensures that after the
    // redraw completes, and the form items are present in the DOM, focus / selection is restored
    // to whatever it was before the redraw
    _restoreFocusAfterRedraw : function (editColNum) {

        var lg = this.grid,
            editForm = lg.getEditForm(),
            editItem = editForm.getItem(lg.getEditorName(lg.getEditRow(), editColNum));
        
        if (editItem != null && editItem.isDrawn()) {
            var scrollLeft = lg.body.getScrollLeft(), 
                scrollTop = lg.body.getScrollTop(),
                viewportWidth = lg.body.getViewportWidth(), 
                viewportHeight = lg.body.getViewportHeight(),
                rect = editItem.getRect(),
                // If we are partially out of the viewport, don't put focus into item -
                // forces a native scroll which can interfere with user scrolling.
                // Note: partially out of viewport actually could be ok for text items
                // where focus will only cause a scroll if the actual text is offscreen.
                outOfViewport = rect[0] < scrollLeft ||
                                rect[1] < scrollTop ||
                                rect[0] + rect[2] > (scrollLeft + viewportWidth) ||
                                rect[1] + rect[3] > (scrollTop + viewportHeight);
            if (!outOfViewport) {
                // Avoid selecting the focussed value - we don't want rapid keypresses
                // to kill what was previously entered  
                editForm._focusInItemWithoutHandler(editItem);
                // Reset the selection / text insertion point to whatever was 
                // remembered before the redraw.
                
                if (this._editorSelection[0] != null) {
                    editItem.setSelectionRange(this._editorSelection[0], this._editorSelection[1]);
                }
                // clear up the _editorSelection flag so we don't try to restore focus again on
                // scroll
                delete this._editorSelection;
            }
        }
    },
    
	// Override isDirty to return true if the parent (ListGrid) is pending a redraw.
    isDirty : function (a,b,c) {
        return this.invokeSuper(null, "isDirty", a,b,c) || this.grid.isDirty();
    },

    // Override shouldShowRollOver to avoid styling the current edit cell with the over
    // style.
    // This avoids the issue where if you roll over the edit form items, the rollover style
    // would flash off as the body recieves a mouseout (looks very weird).        
    shouldShowRollOver : function (rowNum, colNum,a,b) {

        //if (!this.invokeSuper(null, "shouldShowRollOver", rowNum,colNum,a,b)) return false;
        
        if (!this.grid.showRollOver || this._rowAnimationInfo) return false;
 
        // don't show rollover for the edit row if editing the whole row
        var lg = this.grid;
        if (lg._editorShowing && !lg.editByCell && rowNum == lg._editRowNum) return false;
        
        
        // don't show rollover if we have any embedded components expanding this row
        // Do allow if they're the "within" components -- rollover canvas or selection canvas
        if (this._embeddedComponents && this._embeddedComponents.length > 0) {
            var record = this.getCellRecord(rowNum, colNum),
                ecs = record ? record._embeddedComponents : null;
            if (ecs) {
                for (var i = 0; i < ecs.length; i++) {
                    if (ecs[i].embeddedPosition != "within") return false;
                }
            }
        }

        return true;
    },

    updateRollOver : function (rowNum, colNum, movingToNewCell) {

        var lg = this.grid;
        
        if (lg.showRollOverCanvas) {            
            // movingToNewCell param passed when the user rolled off one cell and over another
            // and this method is being called to clear the first cell hilight.
            // we can no-op in this case since we'll update the rollOverCanvas on the subsequent
            // call to this method, and that will avoid a clear/draw cycle (and flash)    
            if (!movingToNewCell) {
                var leaving = !(this.lastOverRow == rowNum && this.lastOverCol == colNum);
                lg.updateRollOverCanvas(rowNum, colNum, leaving);
            }
            // no support for frozen body / rollOverCanvas yet

        }

        this.setRowStyle(rowNum, null, (this.useCellRollOvers ? colNum : null));

        // frozen fields: if there is another body, force its rollover row to match and
        // update it
        var otherBody = (this == lg.body ? lg.frozenBody : lg.body);
        if (otherBody) {
            otherBody.lastOverRow = this.lastOverRow;
            otherBody.lastOverCol = this.lastOverCol;
            otherBody.setRowStyle(rowNum, null, (this.useCellRollOvers ? colNum : null));
        }
    },
    
    // override selectOnMouseDown/Up to disable selection when a row is clicked anywhere
    // besides the checkbox when selectionAppearance is checkbox.
    selectOnMouseDown : function (record, rowNum, colNum) {
        var cbColNum = this.isRTL() ? this.grid.fields.length - 1 : 0,
            selApp = this.grid.selectionAppearance;
        if (selApp != "checkbox" || (selApp == "checkbox" && cbColNum == colNum)) {
            this.invokeSuper(isc.GridBody, "selectOnMouseDown", record, rowNum, colNum);    
        }
        
    },
    
    selectOnMouseUp : function (record, rowNum, colNum) {
        var cbColNum = this.isRTL() ? this.grid.fields.length - 1 : 0,
            selApp = this.grid.selectionAppearance;
        if (selApp != "checkbox" || (selApp == "checkbox" && cbColNum == colNum)) {
            this.invokeSuper(isc.GridBody, "selectOnMouseUp", record, rowNum, colNum);    
        }
    },
    
    // When refreshing cellStyle, notify our edit items that the underlying cell style changed
    // so they can update if necessary
    _updateCellStyle : function (record, rowNum, colNum, cell, className, a,b,c) {
        this.invokeSuper(isc.GridBody, "_updateCellStyle", record, rowNum,colNum,className,a,b,c);
        var lg = this.grid;        
        if (lg && lg.getEditRow() == rowNum) {
            var fieldName = lg.getFieldName(lg.getFieldNumFromLocal(colNum, this)),
                form = lg.getEditForm(),
                item = form ? form.getItem(fieldName) : null;                
            if (item && item.gridCellStyleChanged) {
                if (className == null) className = this.getCellStyle(record,rowNum,colNum);
                item.gridCellStyleChanged(record, rowNum, colNum, className);
            }
        }
        
    },
    
    // hovers: override getHoverTarget to return a pointer to our grid - this allows 
    // the developer to call 'updateHover' directly on the grid.
    getHoverTarget : function () {
        return this.grid;
    },

	// direct keyPresses to the ListGrid as a whole to implement arrow navigation,
	// selection, etc
	
    keyPress : function (event, eventInfo) {
        return this.grid.bodyKeyPress(event, eventInfo);
    },
    
	// Override _focusChanged to implement 'editOnFocus' - start editing the first
	// editable cell if appropriate.
	// See comments in 'editOnFocus' jsdoc comment for details of how this should work.
    _focusChanged : function (hasFocus) {
    	// use the Super implementation to set up this.hasFocus BEFORE we further 
    	// manipulate focus due to editing.
        var returnVal = this.Super("_focusChanged", arguments);
        
        if (hasFocus && this.grid.isEditable()) {      
            var parent = this.grid,
                lastEvent = isc.EH.lastEvent;                
        	// editOnFocus enabled, but not currently editing
            if (parent.editOnFocus && parent.isEditable() &&     
                parent.getEditRow() == null &&            
            	// not in the middle of a click sequence on the body, which gives the body
            	// focus, but should start editing the clicked on row
                !(lastEvent.target == this &&
                  (lastEvent.eventType == isc.EH.MOUSE_DOWN ||
                   lastEvent.eventType == isc.EH.MOUSE_UP ||
                   lastEvent.eventType == isc.EH.CLICK ||
                   lastEvent.eventType == isc.EH.DOUBLE_CLICK))
               ) 
            {
        	//this.logDebug("Editing on focus: eventType: " + lastEvent.eventType +
        	//              ", lastTarget " + lastEvent.target, "gridEdit");
            
            	// If we're explicitly suppressing edit on focus, don't start editing.
                if (parent._suppressEditOnFocus) {
                    delete parent._suppressEditOnFocus;
                } else {
                    // this'll run through every cell in every record until it finds one that's
                    // editable
                    var editCell = parent.findNextEditCell(0,0,true,true);

                    if (editCell != null) 
                        parent.handleEditCellEvent(editCell[0], editCell[1], isc.ListGrid.FOCUS);
                }
            }
        }
        
        return returnVal;
    },
    
    // override updateRowSelection to update selectionCanvas if necessary
    updateRowSelection : function (rowNum) {
        var lg = this.parentElement;
        // when the column is frozen, the parentElement of the bodyLayout is the listGrid
        if (lg && !isc.isA.ListGrid(lg)) lg = lg.parentElement;
        
        
        if (lg && lg.showSelectionCanvas) lg.updateSelectionCanvas();
        this.invokeSuper(isc.GridBody, "updateRowSelection", rowNum);
        if (lg && lg.selectionAppearance == "checkbox") {
            var cellNum = this.isRTL() ? this.fields.length - 1 : 0;
            this.refreshCell(rowNum, cellNum);
            var validData = (isc.isAn.Array(lg.data) || (isc.isA.ResultSet(lg.data) 
                        && lg.data.allMatchingRowsCached()));
            
            if (validData && lg.getSelection.length == lg.data.getLength()) {
                lg._setCheckboxHeaderState(true);        
            } else if (validData) {
                lg._setCheckboxHeaderState(false);
            }
            
        }
    },
    // ditto with _cellSelectionChanged
    _cellSelectionChanged : function (cellList,b,c,d) {
        var lg = this.parentElement;     
        if (lg && lg.showSelectionCanvas) lg.updateSelectionCanvas();
        return this.invokeSuper(isc.GridBody, "_cellSelectionChanged", cellList, b,c,d);
    },
    
    // animateShow selectionCanvas / rollOverCanvas if appropriate
    shouldAnimateEmbeddedComponent : function (component) {
        var grid = this.grid;
        if (component == grid.selectionCanvas) return grid.animateSelection;
        if (component == grid.selectionUnderCanvas) return grid.animateSelectionUnder;
        if (component == grid.rollOverCanvas) return grid.animateRollOver;
        if (component == grid.rollUnderCanvas) return grid.animateRollUnder;
            
        return false;
    },
    
    // Override draw() to scroll to the appropriate cell if 'scrollCellIntoView' was called
	// before the body was drawn/created
	// Also update the edit form item rows if we're already editing.
    draw : function (a,b,c,d) {

        var lg = this.grid;
        
        if (lg.getEditRow() != null) {
            var rowNum = lg.getEditRow(),
                record = lg.getRecord(rowNum),
                fieldNum = lg.getEditCol(),
                form = lg._editRowForm,
                items = lg.getEditRowItems(record, rowNum, fieldNum, lg.editByCell);                  
            form.setItems(items);
            
            
            form._setValuesPending = true;
            
        }
        this.invokeSuper(null, "draw", a,b,c,d);
        
        // If we are showing any edit form items, notify them that they have been written
        // into the DOM.
        
        if (lg._editRowForm) lg._editItemsDrawingNotification(null, null, this);
        
        // Tell the form to update its values (setItemValues())
        // (do this after the items have been notified that they're drawn to ensure items'
        // element values are set)
        lg.updateEditRow(lg.getEditRow());

        
        if (lg._scrollCell != null) {
            lg.scrollCellIntoView(lg._scrollCell);
            delete lg._scrollCell;
        }
    },
    
	// rerun ListGrid-level layout if the body's scrolling state changes, to allow sizing
	// the header appropriately
    layoutChildren : function (reason,a,b,c) {     
        this.invokeSuper(null, "layoutChildren", reason,a,b,c);
        // This method may be called with "scrolling state change" when a bodyLayout is 
        // currently undrawn but drawing out its children - we've seen this in FF 3
        // In this case bail now since if _updateFieldWidths() is fired on an undrawn body it
        // bails, leaving the body mis sized
        
        if (!this.isDrawn() || (this.grid.frozenFields && !this.grid.bodyLayout.isDrawn())) {   
            return;
        }
        if (reason == "scrolling state changed") {
                
            if (this._rowHeightAnimation == null) {
                this.grid.layoutChildren("body scroll changed");
                delete this._scrollbarChangeDuringAnimation;
    
            
            } else {
                this._scrollbarChangeDuringAnimation = true;
            }
        }
    },
    
    // Override rowAnimationComplete to call layoutChildren on the ListGrid if
    // scrollbars were introduced or cleared during animation.
    _rowAnimationComplete : function () {
        this.Super("_rowAnimationComplete", arguments);
        if (this._scrollbarChangeDuringAnimation) {    
            this.grid.layoutChildren("body scroll changed during animation");
            delete this._scrollbarChangeDuringAnimation;
        }
    },

    
    // Override moved to notify any edit form items that they have moved.
    moved : function (a,b,c,d) {
        this.invokeSuper(null, "moved", a,b,c,d);
        
        var lg = this.grid;
        if (lg._editorShowing) {
            lg._editRowForm.itemsMoved();
        }
        
    },
    
    parentMoved : function (a,b,c,d) {
        this.invokeSuper(null, "parentMoved", a,b,c,d);
        var lg = this.grid;
        if (lg._editorShowing) {
            lg._editRowForm.itemsMoved();
        }            
    },
    
    // Override show() / hide() / parentVisibilityChanged() / clear() to notify the Edit 
    // form items that they have been shown / hidden.
    setVisibility : function (newVisibility,b,c,d) {
        this.invokeSuper(null, "setVisibility", newVisibility,b,c,d);
        var lg = this.grid;
        if (lg._editorShowing) lg._editRowForm.itemsVisibilityChanged();
    },
    
    parentVisibilityChanged : function (newVisibility,b,c,d) {
        this.invokeSuper(null, "parentVisibilityChanged", newVisibility,b,c,d);
        var lg = this.grid;
        if (lg._editorShowing) lg._editRowForm.itemsVisibilityChanged();
    },
    
    clear : function () {
        this.Super("clear", arguments);
        var lg = this.grid;
        if (lg._editorShowing) {
            // If we're showing the editRow form, notify the items that they have
            // been removed from the DOM.
            lg._editItemsDrawingNotification(null, null, this);

            // Separate mechanism to notify the form that items are no longer visible.
            
            lg._editRowForm.itemsVisibilityChanged();
        }
    },
    
    // Our tab-index is handled by our parent - similarly use that to manage next/prev
    // tab-widgets.
    _getNextTabWidget : function (backwards) {
        return this.grid._getNextTabWidget(backwards);
    },

    
    _setNextTabWidget : function () {
    },

    
    // also notify the edit form items of z index change
    zIndexChanged : function () {
        this.Super("zIndexChanged", arguments);
        var lg = this.grid;
        // Note: setZIndex can be called at init time to convert "auto" to a numeric
        // zIndex - we therefore can't assume that we've been added to the ListGrid as
        // a child yet.
        if (lg && lg._editorShowing) lg._editRowForm.itemsZIndexChanged();
    },
    parentZIndexChanged : function (a,b,c,d) {
        this.invokeSuper(null, "zIndexChanged", a,b,c,d);
        var lg = this.grid;
        if (lg._editorShowing) lg._editRowForm.itemsZIndexChanged();        
    },
    
    // Implement 'redrawFormItem()' - if one of the edit form items asks to redraw
    // we can simply refresh the cell rather than having the entire body redraw
    redrawFormItem : function (item, reason) {
        var lg = this.grid;
        if (lg && (item.form == lg._editRowForm)) {
            // determine which cell
            var row = lg.getEditRow(), col = lg.getColNum(item.getFieldName());
            lg.refreshCell(row, col, false, true);
            
        } else 
            return this.markForRedraw("Form Item Redraw " + (reason ? reason : isc.emptyString));
    },
	
	//>Animation
    // Override startRowAnimation - if doing a delayed redraw to kick off a row animation
    // to close an open folder, we need to temporarily open the folder again to get the
    // appropriate HTML for the animation rows.
    startRowAnimation : function (show, startRow, endRow, callback, speed, duration, 
                                  effect, slideIn, delayed) 
    {
        var shouldOpenFolder = (delayed && (this._openFolder != null)),
            tg = this.grid;
            
        if (shouldOpenFolder) {
            tg._suppressFolderToggleRedraw = true;
            tg.data.openFolder(this._openFolder);
            tg._suppressFolderToggleRedraw = null;
        }
        this.Super("startRowAnimation", arguments);
        if (shouldOpenFolder) {
            tg._suppressFolderToggleRedraw = true;
            tg.data.closeFolder(this._openFolder);
            tg._suppressFolderToggleRedraw = null;
        }
        delete this._openFolder;
    }
    //<Animation
});


isc.ListGrid.addClassProperties({
    

	//>	@type	SortArrow
	//			Do we display an arrow for the sorted field ?
	//			@group	sorting, appearance
    //	@value	"none"   Don't show a sort arrow at all.
    //	@value	"corner" Display sort arrow in the upper-right corner (above the scrollbar) only.
	CORNER:"corner",	
    //	@value	"field"  Display sort arrow above each field header only.
	FIELD:"field",			
    //	@value	"both"   Display sort arrow above each field header AND in corner above scrollbar.
	//BOTH:"both", // NOTE: Canvas establishes this constant
    // @visibility external
	//<
	// NOTE: Canvas established the constant NONE ( == "none")


	//>	@type	DragDataAction
	//			What do we do with data that's been dropped into another list?
	//			@visibility external
	//			@group	drag
    //	@value	"none"   Don't do anything, resulting in the same data being in both lists. 
    //	@value	isc.ListGrid.COPY		Copy the data leaving the original in our list.
    COPY:"copy",		
    //	@value	isc.ListGrid.MOVE			Remove the data from this list so it can be moved into the other list.
	MOVE:"move",		
	//<
    // Backcompat only: deprecated for 5.5 release in favor of "copy"
	CLONE:"clone",		//	@value	isc.ListGrid.CLONE		Clone the data (so there is another copy), leaving the original in our list.

	// isc.ListGrid.AFTER, isc.ListGrid.BEFORE, isc.ListGrid.OVER
	//  constants used when determining whether to drop before, after or over rows
    AFTER:"after",
    BEFORE:"before",
    OVER:"over",
    
	//> @type   RowEndEditAction
	//  While editing a ListGrid, what cell should we edit when the user attempts to navigate 
	//  into a cell past the end of an editable row, via a Tab keypress, or a programmatic
	//  saveAndEditNextCell() call?
	//
	// @value   "same"   navigate to the first editable cell in the same record
	// @value   "next"   navigate to the first editable cell in the next record
	// @value   "done"   complete the edit.
	// @value   "stop"   Leave focus in the cell being edited (take no action)
	//
	// @visibility external
	// @group editing
	// @see ListGrid.rowEndEditAction
	//
	//<
    
	//>	@type EnterKeyEditAction
	// What to do when a user hits enter while editing a cell
	// @value "done" end editing
	// @value "nextCell" edit the next editable cell in the record
	// @value "nextRow" edit the same field in the next editable record
	// @value "nextRowStart" edit the first editable cell in next editable record
	//
	// @group editing
	// @visibility external
	//<
    
    //> @type EscapeKeyEditAction
    // What to do if the user hits escape while editing a cell.
    // @value "cancel" cancels the current edit and discards edit values
    // @value "done" end editing
    //
    // @group editing
    // @visibility external
    //<

	//>	@type	EditCompletionEvent
	//			What event / user interaction type caused cell editing to complete.
	//			@visibility external
	//			@group	editing
	//
	//          @value  isc.ListGrid.CLICK_OUTSIDE  User clicked outside editor during edit.
	//          @value  isc.ListGrid.CLICK  User started editing another row by clicking on it
	//          @value  isc.ListGrid.DOUBLE_CLICK  User started editing another row by double
    //                               clicking 
	//          @value  isc.ListGrid.ENTER_KEYPRESS Enter pressed.
	//          @value  isc.ListGrid.ESCAPE_KEYPRESS    User pressed Escape.
	//          @value  isc.ListGrid.UP_ARROW_KEYPRESS  Up arrow key pressed.
	//          @value  isc.ListGrid.DOWN_ARROW_KEYPRESS    down arrow key.
	//          @value  isc.ListGrid.TAB_KEYPRESS   User pressed Tab.
	//          @value  isc.ListGrid.SHIFT_TAB_KEYPRESS   User pressed Shift+Tab.
	//          @value  isc.ListGrid.EDIT_FIELD_CHANGE      Edit moved to a different field (same row)
	//          @value  isc.ListGrid.PROGRAMMATIC   Edit completed via explicit function call
	// @visibility external
	//<
    CLICK_OUTSIDE:"click_outside",
    CLICK:"click",
    DOUBLE_CLICK:"doubleClick",
    ENTER_KEYPRESS:"enter",
    ESCAPE_KEYPRESS:"escape",
    UP_ARROW_KEYPRESS:"arrow_up",
    DOWN_ARROW_KEYPRESS:"arrow_down",
    // left/right only used in conjunction with moveEditorOnArrow
    LEFT_ARROW_KEYPRESS:"arrow_left",
    RIGHT_ARROW_KEYPRESS:"arrow_right",
    TAB_KEYPRESS:"tab",
    SHIFT_TAB_KEYPRESS:"shift_tab",
    EDIT_FIELD_CHANGE:"field_change",
    EDIT_ROW_CHANGE:"row_change",
    PROGRAMMATIC:"programmatic",
    // Focus is not a valid edit completion event - focussing in the grid can start an edit
    // if editOnFocus is true but this should not kill an existing edit.
    FOCUS:"focus",
    

	// GridRenderer passthrough
	// --------------------------------------------------------------------------------------------

	// the following properties, when set on the LV, are applied to the Grid
    _gridPassthroughProperties : [
    	// pass it a selection object (this enables selection behaviors)
        "selection", 
        "selectionType",
        "canSelectCells",
        "canDragSelect",
        "canSelectOnRightMouse",
                    
    	// D&D
        "canDrag",
        "canAcceptDrop",
        "canDrop",

    	// table geometry
        "autoFit",
        "wrapCells",
        "cellSpacing",
        "cellPadding",
        "cellHeight",
        "enforceVClipping",
        // autoFitData behavior implemented on GridBody class, not GR class
        "autoFitData",
        "autoFitMaxRecords",
        "autoFitMaxWidth",
        "autoFitMaxColumns",
        "autoFitMaxHeight",
        
    	// incremental rendering
    	// "showAllRecords" -> showAllRows done elsewhere
        "showAllColumns",
        "drawAllMaxCells",
        "drawAheadRatio",
        "quickDrawAheadRatio",
        "scrollRedrawDelay",
        
        //>Animation
        // If we're doing a speed rather than duration based row animation allow the cap to
        // be specified on the ListGrid / TreeGrid
        // (Note that this is documented in the TreeGrid class).
        "animateRowsMaxTime",
        //<Animation

        //> @attr listGrid.fastCellUpdates (boolean: false : I)
    	// @include gridRenderer.fastCellUpdates
        // @group performance
    	//<
        "fastCellUpdates",

    	// rollover
        "showRollOver",
        "useCellRollOvers",

    	// hover
        "canHover",
        "showHover",
        "hoverDelay", 
        "hoverWidth", 
        "hoverHeight", 
        "hoverAlign", 
        "hoverVAlign", 
        "hoverStyle",
        "hoverOpacity",
        "hoverMoveWithMouse",
        
        "hoverByCell",
        "keepHoverActive",
        "cellHoverOutset",

    	// empty message
        "showEmptyMessage",
        "emptyMessageStyle",
        "emptyMessageTableStyle",    
        
        // special presentation of records
        "singleCellValueProperty",
        "isSeparatorProperty",

    	// Focus things -- note no need to pass tabIndex through - this is handled when
    	// we create the body / update the tabIndex on the parent
        "accessKey",
        "canFocus",
        "_useNativeTabIndex",
        "tableStyle",
        "baseStyle",
        "recordCustomStyleProperty",
        
        "showFocusOutline"
    ],

	// the following methods, when called on the LV, will call the same-named method on the
	// GridRenderer (this.body). 
    _lv2GridMethods : [
        // this makes it easier to override getCellStyle at the LV level, since you can call
        // these helpers as this.getCellStyleName()
        "getCellStyleName",
        "getCellStyleIndex",
        
    	// checking table geometry   
        "getRowTop",
        "getRowPageTop",
        "getRowSize",
        "getCellPageRect",
        
        //> @method listGrid.getVisibleRows 
    	// @include gridRenderer.getVisibleRows()
        // @visibility external
    	//<
        "getVisibleRows",

        //> @method listGrid.getDrawnRows
    	// @include gridRenderer.getDrawnRows()
        // @visibility external
    	//<
        "getDrawnRows",

    	// embedded components
        "addEmbeddedComponent",
        "removeEmbeddedComponent"
        
    ],

	// styling
	//>	@method	listGrid.getCellStyle()
	// @include gridRenderer.getCellStyle()
    // @see listGrid.getBaseStyle()
	//<

	//>	@method	listGrid.getCellCSSText()
	// @include gridRenderer.getCellCSSText()
    // @example addStyle
	//<

	// refresh
	//>	@method	listGrid.refreshCellStyle()    
	//  @include    gridRenderer.refreshCellStyle()
	//<

	// events
	//>	@method	listGrid.cellOver()
	// @include gridRenderer.cellOver()
	//<
	//>	@method	listGrid.rowOver()
	// @include gridRenderer.rowOver()
	//<

	//>	@method	listGrid.cellOut()
	// @include gridRenderer.cellOut()
	//<
	//>	@method	listGrid.rowOut()
	// @include gridRenderer.rowOut()
	//<
    
	//>	@method	listGrid.cellHover()
	// @include gridRenderer.cellHover()
	//<
	//>	@method	listGrid.rowHover()
	// @include gridRenderer.rowHover()
	//<
	//>	@method	listGrid.cellHoverHTML()
	// @include gridRenderer.cellHoverHTML()
	//<
    
	//>	@method	listGrid.cellContextClick()
	// @include gridRenderer.cellContextClick()
    // @example cellClicks
	//<
	//>	@method	listGrid.rowContextClick()
	// @include gridRenderer.rowContextClick()
    // @example recordClicks
	//<
    
	//>	@method	listGrid.cellMouseDown()
	// @include gridRenderer.cellMouseDown()
	//<
	//>	@method	listGrid.rowMouseDown()
	// @include gridRenderer.rowMouseDown()
	//<

	//>	@method	listGrid.cellMouseUp()
	// @include gridRenderer.cellMouseUp()
	//<
	//>	@method	listGrid.rowMouseUp()
	// @include gridRenderer.rowMouseUp()
	//<

	//>	@method	listGrid.cellClick()
	// @include gridRenderer.cellClick()
    // @example cellClicks
	//<

	//>	@method	listGrid.cellDoubleClick()
	// @include gridRenderer.cellDoubleClick()
    // @example cellClicks
	//<
    
    // Geometry
	//>	@method	listGrid.getRowTop()    
	//  @include    gridRenderer.getRowTop()
	//<
    
	//>	@method	listGrid.getRowPageTop()    
	//  @include    gridRenderer.getRowPageTop()
	//<

	// the following methods, when called on the GridRenderer used as LV.body, call the same-named
	// method on the ListGrid instance itself
    _grid2LVMethods : [
        
        "getTotalRows",
        "isEmpty",
        "cellIsEnabled",
        "willAcceptDrop",

    	// passed scroll change notification through
        "scrolled",

    	// native element naming
        "getTableElementId",
        "getRowElementId",
        "getCellElementId",

    	// shouldFixRowHeight - enables us to override the ListGrid level 'fixedRecordHeights'
    	// for individual rows
        "shouldFixRowHeight",

        "getEmptyMessage",
        "getCanHover",
        // bubble stopHover on the GR up to stopHover here.
        "stopHover",
        
        "updateEmbeddedComponentZIndex"
        
        // NOTE: These methods pick up their parameters from the stringMethodRegistry on the
        // GridRenderer class. If expanding this list ensure that any methods that take parameters
        // are registered as stringMethods on that class
    ]
});

isc.ListGrid.addClassMethods({
    makeBodyMethods : function (methodNames) {
        var funcTemplate = this._funcTemplate;
        if (funcTemplate == null) {
            funcTemplate = this._funcTemplate = [,"return this.grid.",,"(",,")"];
        }

        var methods = {};

		for (var i = 0; i < methodNames.length; i++) {
			var methodName = methodNames[i],
                argString = isc.GridRenderer.getArgString(methodName);
            
            if (isc.contains(argString, "colNum")) {
                // if there's a colNum argument, map it to the field index in the master
                funcTemplate[0] = "if (this.fields[colNum]) colNum = this.fields[colNum].masterIndex;"
            } else if (isc.isAn.emptyString(argString)) {
                // if there are no arguments, pass the body itself as a means of identifying
                // the calling body
                argString = "body";
                funcTemplate[0] = "body = this;";
            } else {
                funcTemplate[0] = null;
            }
    
			// create a function that routes a function call to the target object
            funcTemplate[2] = methodName;
            funcTemplate[4] = argString;
            var functionText = funcTemplate.join(isc.emptyString);
            //this.logWarn("for method: " + methodName + " with argString :"  + argString +  
            //             " function text is: " + functionText);
			methods[methodName] = 
                new Function(argString, functionText);
		}
        
        return methods;
    },

    classInit : function () {
    	// create functions to have methods on the ListGrid's body call methods on the ListGrid
    	// itself.  This is partly legacy support: the way to customize body rendering used to
    	// be to install functions that controlled body rendering directly on the ListGrid
    	// itself.

    	// make certain grid methods appear on the LV for convenience, so you don't have to go
    	// this.body.someGridMethod()
        this.addMethods(isc.ClassFactory.makePassthroughMethods(
            this._lv2GridMethods, "body"));

		// ----------------------------------------------------------------------------------------
    	// create methods that can be installed on the body to call methods on the LV itself, for:
        var passthroughMethods = {};

    	// - handlers (like cellOver) and overrides (like getCellCSSText) that we allow to be
    	//   defined on the LV but are really grid APIs
        var gridAPIs = isc.getKeys(isc.GridRenderer._gridAPIs),
            passthroughMethods = isc.ListGrid.makeBodyMethods(gridAPIs);

    	// - methods the grid needs to fulfill as the drag/drop target, which are really implemented
    	//   on the LV
        isc.addProperties(passthroughMethods,
                          isc.ListGrid.makeBodyMethods(this._grid2LVMethods));

        this._passthroughMethods = passthroughMethods;

    	

    	// create methods on the ListGrid to act as Super implementations for per-instance
    	// overrides of methods where we want to call the original GridRenderer implementation
    	// as Super.
        var passBackMethods = {},
            funcTemplate = ["if(this.body.__orig_",,")return this.body.__orig_",,"(",,")"],
            origPrefix  = "__orig_",
            gridProto = isc.GridRenderer.getPrototype();
        for (var i = 0; i < gridAPIs.length; i++) {
            var methodName = gridAPIs[i],
                argString = isc.GridRenderer.getArgString(methodName);
            if (isc.ListGrid.getInstanceProperty(methodName) == null) {
                funcTemplate[1] = funcTemplate[3] = methodName;
                funcTemplate[5] = argString
                
                passBackMethods[methodName] = new Function(argString, 
                    funcTemplate.join(isc.emptyString));
                	// XXX this would also work, but imposes another Super call penalty, and is
                	// odd (call to Super from outside of the object)
                	//"return this.body.Super('" + methodName + "', arguments);");
            }
        	
            gridProto[origPrefix + methodName] = gridProto[methodName];
        }
        this._passBackMethods = passBackMethods;
        this.addMethods(passBackMethods);

    }
});

// add default properties to the class
isc.ListGrid.addProperties( {
    
	//>	@attr	listGrid.styleName		(CSSStyleName : "listGrid" : IRW)
	// Default CSS class
	// @group	appearance
    // @visibility external
	//<
    styleName:"listGrid",

	//>	@attr	listGrid.data		(List of ListGridRecord : null : IRW)
	// A List of ListGridRecord objects, specifying the data to be used to populate the
    // ListGrid.  In ListGrids, the data array specifies rows. Note that ListGrids
    // automatically observe changes to the data List and redraw accordingly.
    // <p>
    // This property is settable directly only as part of a +link{ListGrid} constructor.  If
    // you want to change the +link{ListGrid}'s data after initial creation, call
    // +link{listGrid.setData}.
    // <p>
    // This property will typically not be explicitly specified for databound ListGrids, where
    // the data is returned from the server via databound component methods such as
    // +link{fetchData()}. In this case the data objects will be set to a 
    // +link{class:ResultSet,resultSet} rather than a simple array.
	//
	// @group	data
    // @see ListGridRecord
    // @setter ListGrid.setData()
	// @visibility external
    // @example inlineData
    // @example localData
	//<
    
    // useCellRecords - Is our data model going to be one record per cell or one record per row?
    useCellRecords:false,

    //> @object ListGridRecord
    // A ListGridRecord is a JavaScript Object whose properties contain values for each
    // +link{ListGridField}.  A ListGridRecord may have additional properties which affect the
    // record's appearance or behavior, or which hold data for use by custom logic or other,
    // related components.
    // <p>
    // For example a ListGrid that defines the following fields:
    // <pre>
    // fields : [
    //     {name: "field1"},
    //     {name: "field2"}
    // ],
    // </pre>
    // Might have the following data:
    // <pre>
    // data : [
    //     {field1: "foo", field2: "bar", customProperty:5},
    //     {field1: "field1 value", field2: "field2 value", enabled:false}
    // ]
    // </pre>
    // Each line of code in the <code>data</code> array above creates one JavaScript Object via
    // JavaScript {type:ObjectLiteral,object literal} notation.  These JavaScript Objects are
    // used as ListGridRecords.
    // <P>
    // Both records shown above have properties whose names match the name property of a
    // ListGridField, as well as additional properties.  The second record will be disabled due to
    // <code>enabled:false</code>; the first record has a property "customProperty" which will
    // have no effect by default but which may accessed by custom logic.
    // <P>
    // After a ListGrid is created and has loaded data, records may be accessed via
    // +link{listGrid.data}, for example, listGrid.data.get(0) retrieves the first record.
    // ListGridRecords are also passed to many events, such as
    // +link{ListGrid.cellClick,cellClick()}.
    // <P>
    // A ListGridRecord is always an ordinary JavaScript Object regardless of how the grid's
    // dataset is loaded (static data, java server, XML web service, etc), and so supports the
    // normal behaviors of JavaScript Objects, including accessing and assigning to properties
    // via dot notation:
    // <pre>
    //     var fieldValue = record.<i>fieldName</i>;
    //     record.<i>fieldName</i> = newValue;
    // </pre>
    // <P>
    // Note however that simply assigning a value to a record won't cause the display to be
    // automatically refreshed - +link{listGrid.refreshCell()} needs to be called.  Also,
    // consider +link{group:editing,editValues vs saved values} when directly modifying
    // ListGridRecords.
    // <P>
    // See the attributes in the API tab for the full list of special properties on
    // ListGridRecords that will affect the grid's behavior.
    //
    // @treeLocation Client Reference/Grids/ListGrid
    // @see ListGrid.data
    // @inheritsFrom Record
    // @visibility external
    //<
    

    //> @attr listGridRecord.enabled (boolean : null : IR)
    //
    // Affects the visual style and interactivity of the record.  If set to <code>false</code>
    // the record (row in a +link{ListGrid} or +link{TreeGrid}) will not highlight when the
    // mouse moves over it, nor will it respond to mouse clicks.
    //
    // @visibility external
    // @example disabledRows
    //<

    //> @attr listGridRecord.isSeparator (boolean : null : IR)
    //
    // Default property name denoting a separator row.<br>
    // When set to <code>true</code>, defines a horizontal separator in the listGrid
    // object. Typically this is specified as the only property of a record object, since a
    // record with <code>isSeparator:true</code> will not display any values.<br>
    // Note: this attribute name is governed by +link{ListGrid.isSeparatorProperty}.
    // @visibility external
    //<
    
    //>@attr    listGridRecord.singleCellValue (HTML : null : IRW)
    // Default property name denoting the single value to display for all fields of this row.
    // If this property is set for some record, the record will be displayed as a single 
    // cell spanning every column in the grid, with contents set to the value of this
    // property.<br>
    // Note: this attribute name is governed by +link{ListGrid.singleCellValueProperty}.
    // @visibility external
    //<


    //> @attr listGridRecord.canDrag (boolean : null : IR)
    //
    // When set to <code>false</code>, this record cannot be dragged. If canDrag is false for
    // any record in the current selection, none of the records will be draggable.
    //
    // @visibility external
    //<

    //> @attr listGridRecord.canAcceptDrop (boolean : null : IR)
    //
    // When set to <code>false</code>, other records cannot be dropped on (i.e., inserted
    // via drag and drop) immediately before this record.
    //
    // @visibility external
    //<

	//> @attr   listGridRecord.linkText  (string : null : IRW)
    //
    //  The HTML to display in this row for fields with fieldType set to link. This overrides
    //  +link{attr:listGridField.linkText}.
    //
    //  @see type:ListGridFieldType
    //  @see type:FieldType
    //  @see attr:listGridField.linkText
    //  @see attr:listGrid.linkTextProperty
	//  @group  display_values
	//  @visibility external
	//<
    
	// Animation
    // ---------------------------------------------------------------------------------------
    
    //> @attr treeGrid.animateFolders (boolean : true : IRW)
    // If true, when folders are opened / closed children will be animated into view.
    // @group animation
    // @visibility animation
    // @example animateTree
    //<
    animateFolders:true,
    
    //> @attr treeGrid.animateFolderTime (number : 100 : IRW)
    // When animating folder opening / closing, if +link{treeGrid.animateFolderSpeed} is not
    // set, this property designates the duration of the animation in ms.
    // @group animation
    // @visibility animation
    // @see treeGrid.animateFolderSpeed
    //<
    animateFolderTime:100,

    //> @attr treeGrid.animateFolderSpeed (number : 1000 : IRW)
    // When animating folder opening / closing, this property designates the speed of the
    // animation in pixels shown (or hidden) per second. Takes presidence over the 
    // +link{treeGrid.animateFolderTime} property, which allows the developer to specify a
    // duration for the animation rather than a speed.
    // @group animation
    // @visibility animation
    // @see treeGrid.animateFolderTime
    // @example animateTree
    //<    
    animateFolderSpeed:1000,
    
    //> @attr treeGrid.animateFolderEffect (AnimationAcceleration : null : IRW)
    // When animating folder opening / closing, this property can be set to apply an
    // animated acceleration effect.designates the speed of the
    // animation in pixels shown (or hidden) per second.
    // @group animation
    // @visibility animation
    //<    

    //> @attr treeGrid.animateRowsMaxTime (number : 1000 : IRW)
    // If animateFolderSpeed is specified as a pixels / second value, this property will cap
    // the duration of the animation.
    // @group animation
    // @visibility animation_advanced
    //<    
    animateRowsMaxTime:1000,
	
	// DataBinding
	// ----------------------------------------------------------------------------------------

	//>	@attr listGrid.fields (Array of ListGridField : null : [IRW])
	// An array of field objects, specifying the order, layout, formatting, and
	// sorting behavior of each field in the listGrid object.  In ListGrids, the fields
	// array specifies columns.  Each field in the fields array is a ListGridField object. 
    // Any listGrid that will display data should have at least one visible field.
    // <p>
    // If +link{ListGrid.dataSource} is also set, this value acts as a set of overrides as
    // explained in +link{attr:DataBoundComponent.fields}.
    //
	// @see    ListGridField
	// @see    setFields()
    // @group databinding
	// @visibility external
    // @example listGridFields
    // @example mergedFields
	//<

	//>	@attr	listGrid.dataSource		(DataSource or ID : null : IRW)
    // @include dataBoundComponent.dataSource
	//<
    
	//> @attr listGrid.autoFetchDisplayMap (boolean : true : [IRW])
	// If true, automatically fetches a valueMap if an +link{listGridField.optionDataSource} is
    // set for a ListGrid field.
    // <P>
    // If set to false, valueMaps will not be automatically fetched.  In this case, setting
    // field.optionDataSource on a is effectively a shortcut for setting optionDataSource on
    // the editor via +link{field.editorProperties}.
    // <P>
    // Can also be disabled on a per-field basis with +link{listGridField.autoFetchDisplayMap}.
    //
	// @group display_values
	// @see listGridField.autoFetchDisplayMap
	// @see listGridField.optionDataSource
    // @visibility external
	//<
    autoFetchDisplayMap:true,

    //> @attr ListGrid.saveLocally  (boolean : null : IRA)
    // For grids with a specified +link {ListGrid.datasource}, this property can be set to 
    // <code>true</code> to avoid the grid from attempting to save / retrieve data from the
    // server.  In this case data will be saved locally as +link {ListGrid.data}, and the
    // datasource will simply act as a schema to describe the set of fields visible in the
    // grid.
    // @group databinding
    //<
    

	//>	@attr	listGrid.useAllDataSourceFields (boolean : null : IRW)
    // @include dataBoundComponent.useAllDataSourceFields
    // @group databinding
	//<

	//>	@attr	listGrid.showDetailFields (boolean : true : IR)
    // Whether to include fields marked <code>detail:true</code> from this component's 
    // <code>DataSource</code>.
    // <P>
    // Fields may also be included directly in this component's <code>fields</code> array in
    // which case they will be present regardless of the <code>detail</code> attribute.
    // <p>
    // When this property is <code>true</code>, <code>ListGrid</code>s will include all 
    // detail fields, but they will be initially hidden.  The user may show
    // these fields via the default header context menu (+link{listGrid.showHeaderContextMenu}).
    // Setting this property to false will completely exclude all detail fields from the list
    // grid's fields array, such that they cannot be shown by the user or programmatically.
    // <P>
    // To override the visibility of individual fields, use the standard
    // +link{listGrid.showField()}, +link{listGrid.hideField()} and +link{listGridField.showIf}
    // APIs, for example, set showIf:"true" to show a detail field initially.
    // 
    // @group databinding
    // @visibility external
    //<
    showDetailFields:true,
    
    //> @attr ListGrid.titleField (string : see below : IRW)
    // Best field to use for a user-visible title for an individual record from this grid.
    // If +link{ListGrid.dataSource} is non null, this property may be specified on the 
    // dataSource instead.
    // <p>
    // If not explicitly set, titleField looks for fields named "title", "name", and "id" 
    // in that order.  If a field exists with one of those names, it becomes the titleField.  
    // If not, then the first field is designated as the titleField.
    //  @visibility external
    //<

    
    //>@attr    listGrid.dataProperties (object : null :IRWA)
    // For databound ListGrids, this attribute can be used to customize the +link{ResultSet}
    // object created for this grid when data is fetched
    // @group databinding
    // @visibility external
    //<
    
    // Grouping
    // ---------------------------------------------------------------------------------------
    
    //> @object groupNode
    //
    // An auto-generated subclass of +link{TreeNode} representing the group nodes
    // in a grouped listgrid. 
    //
    // @see listGrid.groupBy
    // @treeLocation Client Reference/Grids/ListGrid
    // @group grouping
    // @visibility external    
    //< 
    
    //> @attr groupNode.groupMembers (Array of ListGridRecord or GroupNode : see below : R)
    // Array of ListGridRecord that belong to this group, or, for multi-field grouping, array
    // of groupNodes of subgroups under this groupNode.
    // 
    // @group grouping
    // @see listGrid.groupBy
    // @visibility external
    //<
    
    //> @attr groupNode.groupTitle (HTML : see below : R)
    // The computed title for the group, which results from +link{listGridField.getGroupTitle()}
    // 
    // @group grouping
    // @see listGrid.groupBy
    // @visibility external
    //<
    
    //> @attr groupNode.groupValue (any : see below : R)
    // The value from which groups are computed for a field, 
    // which results from +link{listGridField.getGroupValue()}
    // 
    // @group grouping
    // @see listGrid.groupBy
    // @visibility external
    //<
    
    //> @attr listGrid.originalData (List of ListGridRecord : null : R)
    // When grouped, a copy of the original ungrouped data.
    //
    // @group grouping
    // @see listGrid.groupBy
    // @visibility external
    //<
    
    //> @attr listGrid.groupTree (AutoChild : null : R)
    // The data tree that results from a call to  +link{listGrid.groupBy()}.
    // This will be a +link{ResultTree} if +link{listGrid.dataSource} is
    // present, otherwise it will be a +link{Tree}.
    //
    // @group grouping
    // @see listGrid.groupBy
    // @visibility external
    //<
    
    //> @attr listGrid.groupStartOpen (String || Array : "first" : IRW)
    // Describes the default state of ListGrid groups when groupBy is called. 
    //
    // Possible values are:
    // <ul>
    // <li>"all": open all groups
    // <li>"first": open the first group
    // <li>"none": start with all groups closed 
    // <li>Array of values that should be opened
    // </ul>
    //
    // @group grouping
    // @see listGrid.groupBy
    // @visibility external
    //<
    groupStartOpen:"first",
    
    //> @method listGridField.getGroupValue()
    // Return the value which records should be grouped by.  
    // <P>
    // All records that for which getGroupValue() returns the same value appear in the same
    // group.  Default is the result of +link{listGrid.getCellValue}.
    // <P>
    // While any type of value may be returned, avoiding the use of string values may
    // result in improved performance. In this case, +link{listGridField.getGroupTitle()}
    // may be implemented to map a numeric group value into a legible string.
    //
    // @param   value (any)   raw value for the cell, from the record for the row
    // @param   record   (ListGridRecord) 
    //   Record object for the cell. Note: If this is a new row that has not been saved, in an 
    //   editable grid, it has no associated record object. In this case the edit values will
    //   be passed in as this parameter (see +link{listGrid.getEditValues()})
    // @param   field  (Object)    Field object for which to get group value
    // @param   fieldName  (String)    The name of the field
    // @param   grid    (ListGrid) the ListGrid displaying the cell
    // @return (any) Group value to which this record belongs
    //
    // @see listGrid.groupBy()
    // @see listGridField.getGroupTitle()
    // @group grouping
    // @visibility external
    // @example customGrouping
    //<
    
    //> @method listGridField.getGroupTitle()
    // Return the title that should be shown to the user for the group with the
    // <code>groupValue</code> passed as a parameter.
    // <P>
    // Default title is the groupValue itself. 
    //
    // @group grouping
    //
    // @param   groupValue (any)   the value from the group is created, the result of 
    //  +link{listGridField.getGroupValue()}
    // @param   groupNode   (groupNode) the node in the grid containing the group. 
    // @param   field  (Object)    Field object for which to get group value
    // @param   fieldName  (String)    The name of the field
    // @param   grid    (ListGrid) the ListGrid displaying the cell
    // @return (any) Group value to which this record belongs
    //
    // @see listGrid.groupBy()
    // @see listGridField.getGroupValue()
    // @visibility external
    // @example customGrouping
    //<

    //> @attr listGridField.groupingModes (ValueMap : null : IR)
    // If set, provides several possible styles of grouping that are valid for this field.  For
    // example, a field of type:"date" might be able to be grouped by week, month, or by day of
    // week.
    // <P>
    // If <code>groupingModes</code> are present and
    // +link{listGrid.canGroupBy,grouping is enabled}, the menu for this field includes a
    // submenu of possible grouping modes generated from the <code>groupingModes</code> valueMap.
    // When the user selects a particular grouping mode,
    // +link{listGridField.groupingMode,field.groupingMode} is set to the user's chosen mode,
    // and this choice can be detected via the <code>field</code> parameter to
    // +link{listGridField.getGroupValue()} in order to provide different modes of grouping.
    // <P>
    // The user may also choose to group records without specifying a grouping mode, in this case,
    // the +link{listGridField.defaultGroupingMode} is used.
    // <P>
    // Note that <code>getGroupValue</code>, <code>groupingModes</code> et al can be specified on
    // +link{SimpleType} declaration, and the different grouping modes that are offered
    // automatically for various common types are defined this way.
    //
    // @group grouping
    // @visibility external
    //<

    //> @attr listGridField.groupingMode (identifier : null : IR)
    // For a field that allows multiple +link{listGridField.groupingModes,grouping modes}, 
    // the current grouping mode.
    // <P>
    // This property is set when a user chooses a particular grouping mode, and may be set on
    // ListGrid creation to affect the initial grouping.
    //
    // @group grouping
    // @visibility external
    //<

    //> @attr listGridField.defaultGroupingMode (identifier : null : IR)
    // Default groupingMode used when the user does not specify a mode or grouping is triggered
    // programmatically and +link{listGridField.groupingMode,field.groupingMode} is unset.
    // See +link{listGridField.groupingModes,field.groupingModes}.
    //
    // @group grouping
    // @visibility external
    //<

    //> @attr listGridField.groupPrecision (integer : null : IR)
    // For fields of type:"float" or derived from float, number of digits after the decimal point
    // to consider when grouping.
    // <P>
    // For example, <code>groupPrecision:2</code> indicates that 45.238 and 45.231 group together,
    // but 45.22 and 45.27 are separate.
    // <P>
    // See also +link{listGridField.groupGranularity,groupGranularity} for grouping by broader
    // ranges.
    //
    // @group grouping
    // @visibility external
    //<

    //> @attr listGridField.groupGranularity (integer : null : IR)
    // Granularity of grouping for numeric fields.
    // <P>
    // Groups will be formed based on ranges of values of size <code>groupGranularity</code>.  For
    // example, if groupGranularity were 1000, groups would be 0-1000, 1000-2000, etc.
    //
    // @group grouping
    // @visibility external
    //<

    //> @attr   listGridField.canGroupBy    (Boolean : true : IRW)
    // Determines whether this field will be groupable in the header context menu.
    // 
    // @see listGrid.groupBy()
    // @visibility external
    //<
    
    //> @attr   listGrid.groupNodeStyle     (String : "groupNode" : IRW)
    // The CSS style that group rows will have
    //
    // @group grouping
    // @see group:grouping
    // @visibility external
    //<
    groupNodeStyle: "groupNode",
	
    //> @attr   listGrid.groupIcon     (SCImgURL : "[SKINIMG]/TreeGrid/opener.gif" : IRW)
    // The URL of the base icon for the group icons in this treegrid.
    //
    // @group grouping
    // @see group:grouping
    // @visibility external
    //<
    groupIcon: "[SKINIMG]/TreeGrid/opener.gif",
    
    //> @attr   listGrid.groupIconSize     (Number : 16 : IRW)
    // Default width and height of group icons for this ListGrid.
    //
    // @group grouping
    // @see listGrid.groupBy()
    // @visibility external
    //<
    groupIconSize: 16,
    
    //> @attr   listGrid.groupIndentSize     (Number : 20 : IRW)
    // Default number of pixels by which to indent subgroups relative to parent group.
    //
    // @group grouping
    // @see listGrid.groupBy
    // @see listGrid.getGroupNodeHTML
    // @visibility external
    //<
    groupIndentSize: 20,
    
    //> @attr   listGrid.groupLeadingIndent     (Number : 20 : IRW)
    // Default number of pixels by which to indent all groups.
    //
    // @group grouping
    // @see listGrid.groupBy
    // @see listGrid.getGroupNodeHTML
    // @visibility external
    //<
    groupLeadingIndent: 10,

    //> @attr   listGrid.canGroupBy     (Boolean : true : IRW)
    // If false, grouping via context menu will be disabled.
    //
    // @group grouping
    // @see listGrid.groupBy
    // @visibility external
    //<
    canGroupBy: true,

    //> @attr   listGrid.groupByMaxRecords  (Number : 1000 : IRW)
    // Maximum number of records to which a groupBy can be applied. If there are more records,
    // grouping will not be available via the default header context menu, and calls to 
    // +link{listGrid.groupBy()} will be ignored.
    // 
    // @group grouping
    // @visibility external
    // @see     groupBy
    //<
    groupByMaxRecords: 1000,
    
    //> @attr   listGrid.isGrouped (Boolean : false : R)
    // True if this listgrid is grouped, false otherwise
    //
    // @group grouping
    // @visibility external
    // @see     groupBy
    //<
    
    //> @attr   listGrid.nullGroupTitle (String : '-none-' : IRW)
    // Default alias to use for groups with no value
    //
    // @group grouping
    // @visibility external
    // @see     groupBy
    //<
    nullGroupTitle: "-none-",
    
    //> @attr   listGrid.groupByField ( String or Array of String : see below : IR)
    // List of fields to group grid records. If only a single field is used, that field
    // may be specified as a string. After initialization, use +link{listGrid.groupBy()} 
    // to update the grouping field list, instead of modifying groupByField directly.
    // @group grouping
    // @visibility external
    // @see     groupBy
    // @example dynamicGrouping
    //<
    

    // ----------------------
    // Value icons
    // The valueIcons object is a mapping between values and image URLs - when specified
    // we show the valueIcon image either next to, or instead of the normal cell value.
    // Use cases:
    // - show text, but add an icon as decoration, either to all values, or to emphasize some
    //   values.
    // - use an icon only to minimize space
    // 'showValueIconOnly' allows the developer to explicitly show the valueIcon with or without 
    // text.
    // If showValueIconOnly is unset, we make the assumption that 
    // - if the field is not constrained to a fixed set of values (has no valueMap), there's 
    //   no way to have icons for all the values, so the purpose of the icons is to add
    //   emphasis to certain values [so we show both text and images]
    // - otherwise the developer has an icon for every possible value, so there is no need for
    //   the value to also be displayed - we size the field large enough to accomodate the icon
    //   only, and suppress the text.
        
    //> @attr listGridField.valueIcons (object : null : IRW)
    // This property is a mapping between data values to +link{SCImgURLs} for icons to display
    // for those data values.  For example, given a field named "status" with possible values
    // "Normal", "Slow", "Offline", the follow definition would show various icons for that
    // field:
    // <P>
    // <pre>
    // fields : [
    //     { name:"status", 
    //       valueIcons: {
    //           Normal : "greenIcon.png",
    //           Slow : "yellowIcon.png",
    //           Offline : "redIcon.png"
    //       }
    //     },
    //     ... other fields ...
    // ]
    // </pre>
    // <P>
    // <code>valueIcons</code> can either be displayed alongside the normal value or can
    // replace the normal field value so that only the icon is shown.  See
    // +link{listGridField.showValueIconOnly}.
    // <P>
    // If inline editing is enabled for this field, editors displayed for this field will also
    // show valueIcons.  This may be overridden by explicitly setting
    // +link{listGridField.editorValueIcons}.
    // <P>
    // Note that the following attributes related to valueIcon styling will also be picked up
    // by the editor from the ListGridField object unless explicitly specified via the
    // equivalent <code>editor_</code> attributes:<br>
    // +link{listGridField.valueIconWidth}<br>
    // +link{listGridField.valueIconHeight}<br>
    // +link{listGridField.valueIconSize}<br>
    // +link{listGridField.valueIconLeftPadding}<br>
    // +link{listGridField.valueIconRightPadding}<br>            
    // +link{listGridField.imageURLPrefix}<br>    
    // +link{listGridField.imageURLSuffix}
    //
    // @group imageColumns
    // @visibility external
    //<
    
    //> @attr listGrid.valueIconSize (number : 16 : IRW)
    // Default width and height of value icons for this ListGrid.
    // Can be overridden at the listGrid level via explicit +link{ListGrid.valueIconWidth} and
    // +link{ListGrid.valueIconHeight}, or at the field level via +link{ListGridField.valueIconSize},
    // +link{ListGridField.valueIconWidth} and {ListGridField.valueIconHeight}
    // @visibility external
    // @group imageColumns
    // @see ListGrid.valueIconWidth
    // @see ListGrid.valueIconHeight
    // @see ListGridField.valueIconSize
    //<
    valueIconSize:16,
    
    
    //> @attr listGrid.valueIconWidth (number : null : IRW)
    // Width for value icons for this listGrid.
    // Overrides +link{ListGrid.valueIconSize}.
    // Can be overridden at the field level
    // @group imageColumns
    // @visibility external
    //<
    
    //> @attr listGrid.valueIconHeight (number : null : IRW)
    // Height for value icons for this listGrid.
    // Overrides +link{ListGrid.valueIconSize}.
    // Can be overridden at the field level
    // @group imageColumns
    // @visibility external
    //<
    
    //> @attr listGridField.valueIconSize (number : null : IRW)
    // Default width and height of value icons in this field.
    // Takes precidence over valueIconWidth, valueIconHeight and valueIconSize specified at
    // the ListGrid level.
    // Can be overridden via +link{ListGridField.valueIconWidth} and {ListGridField.valueIconHeight}
    // @visibility external
    // @group imageColumns
    // @see ListGrid.valueIconSize
    // @see ListGridField.valueIconWidth
    // @see ListGridField.valueIconHeight
    //<
    
    //> @attr listGridField.valueIconWidth (number : null : IRW)
    // Width for value icons for this listGrid field.
    // Overrides +link{ListGrid.valueIconSize}, +link{ListGrid.valueIconWidth}, and
    // +link{ListGridField.valueIconSize}.
    // @group imageColumns
    // @visibility external
    //<
    
    //> @attr listGridField.valueIconHeight (number : null : IRW)
    // Height for value icons for this listGrid field.
    // Overrides +link{ListGrid.valueIconSize}, +link{ListGrid.valueIconHeight}, and
    // +link{ListGridField.valueIconSize}.
    // @group imageColumns
    // @visibility external
    //<
    
    //> @attr   listGridField.valueIconLeftPadding (number : null : IRW)
    // How much padding should there be on the left of valueIcons for this field
    // Overrides +link{listGrid.valueIconLeftPadding}
    // @group imageColumns
    // @see ListGridField.valueIcons
    // @visibility external
    //<
    
    //> @attr   listGridField.valueIconRightPadding (number : null : IRW)
    // How much padding should there be on the right of valueIcons for this field
    // Overrides +link{listGrid.valueIconRightPadding}
    // @group imageColumns
    // @see ListGridField.valueIcons
    // @visibility external
    //<
    
    //> @attr listGridField.editorValueIcons (object : null : IRW)
    // When some cell in this field is being edited, setting this property will specify the
    // value icons to display in the cell's editor. If unset, the editor's valueIcons
    // will be determined in the same way as it would be for a static cell.
    // @group imageColumns
    // @visibility external
    //<

    //> @attr listGridField.editorValueIconWidth (number : null : IRW)
    // When some cell in this field is being edited, setting this property will specify the
    // width for value icons in the cell's editor. If unset, the editor's valueIcon width and
    // height will be determined in the same way as it would be for a static cell.
    // @group imageColumns
    // @visibility external
    //<
    
    //> @attr listGridField.editorValueIconHeight (number : null : IRW)
    // When some cell in this field is being edited, setting this property will specify the
    // height for value icons in the cell's editor. If unset, the editor's valueIcon width and
    // height will be determined in the same way as it would be for a static cell.
    // @group imageColumns
    // @visibility external
    //<    
    
    //> @attr listGridField.showValueIconOnly (boolean : null : IRW)
    // If this field has a valueIcons property specified, setting this property causes 
    // the valueIcon for each value to be displayed in the cell without also showing the
    // record's value for the field.
    // <P>
    // If unset the default behavior is to show the icon only if an explicit valueMap is
    // specified as well in addition to a valueIcons map, otherwise show both the valueIcon and
    // value for the cell.
    // <P>
    // Note that if this field is editable +link{FormItem.showValueIconOnly} will be passed
    // through to editors displayed in this field.
    //
    // @group imageColumns
    // @see listGridField.valueIcons
    // @see listGridField.suppressValueIcon
    // @visibility external
    //<
    
    //> @attr   listGridField.suppressValueIcon (boolean : null : IRW)
    // If this field has a valueIcons property specified, setting this property to true will 
    // prevent the valueIcon being written out into this field's cells.
    //
    // @group imageColumns
    // @see listGridField.valueIcons
    // @see listGridField.showValueIconOnly
    // @visibility external
    //<
    
    //> @attr   listGridField.valueIconOrientation (string : null : IRW)
    // If we're showing a valueIcon for this field should it appear to the left or the right
    // of the text?  By default the icon will appear to the left of the textual value - 
    // set this to "right" to show the icon on the right of the text.
    // Has no effect if +link{listGridField.showValueIconOnly} is true
    // @visibility external
    // @group imageColumns
    //<
    
    
    //> @attr   listGrid.valueIconLeftPadding (number : 2 : IRW)
    // How much padding should there be on the left of valueIcons by default
    // Can be overridden at the field level
    // @group imageColumns
    // @see ListGridField.valueIcons
    // @visibility external
    //<
    valueIconLeftPadding:2,
    
    //> @attr   listGrid.valueIconRightPadding (number : 2 : IRW)
    // How much padding should there be on the right of valueIcons by default
    // @group imageColumns
    // Can be overridden at the field level    
    // @see ListGridField.valueIcons
    // @visibility external
    //<
    valueIconRightPadding:2,
    
    
    
    //> @attr   ListGridField.imageURLPrefix (string : null : IRWA)
    // If this field has type [+link{type:ListGridFieldType}] set to <code>"image"</code>
    // and the URL for the image displayed is not absolute, the path of the URL will be relative 
    // to this string<br>
    // Alternatively, if this field displays any valueIcons, this prefix will be applied to
    // the beginning of any +link{ListGridField.valueIcons} when determining the
    // URL for the image.
    // @group imageColumns
    // @visibility external
    // @example imageType
    //<
    
    //> @attr   ListGridField.imageURLSuffix (string : null : IRWA)
    // If any cells in this field are showing a value icon (see: +link{ListGridField.valueIcons})
    // or this is has +link{type:ListGridFieldType} set to <code>"image"</code>, this the value
    // of this property will be appended to the end of the URL for the icon displayed.<br>
    // Typical usage might be to append a file type such as <code>".gif"</code> to the
    // filename of the image.<br>
    // For editable fields, this property will also be passed through to any editors as
    // +link{FormItem.imageURLSuffix}.
    // @group imageColumns
    // @visibility external
    // @example imageType
    //<    
    
    //> @attr   ListGridField.editorImageURLPrefix (string : null : IRWA)
    // When some cell in this field is being edited, this property can be used to apply 
    // an explicit +link{FormItem.imageURLPrefix} to the editor in question. 
    // This can be used to modify the valueIcons within the editor.<br>
    // If unset, but +link{ListGridField.imageURLPrefix} is specified, that will be used
    // instead.
    // @group editing
    // @visibility external
    //<
    
    //> @attr   ListGridField.editorImageURLSuffix (string : null : IRWA)
    // When some cell in this field is being edited, this property can be used to apply 
    // an explicit +link{FormItem.imageURLSuffix} to the editor in question. 
    // This can be used to modify the valueIcons within the editor.<br>
    // If unset, but +link{ListGridField.imageURLPrefix} is specified, that will be used
    // instead.
    // @group editing
    // @visibility external
    //<

  	//>	@attr	listGrid.imageSize (number : 16 : IRW)
    // Default size of thumbnails shown for fieldTypes image and imageFile.  Overrideable on a
    // per-field basis via +link{attr:ListGridField.imageSize} or
    // +link{attr:ListGridField.imageWidth}/+link{attr:ListGridField.imageHeight}
    // 
    // @group imageColumns
    // @visibility external
	//<
    imageSize: 16,

  	//>	@attr	listGridField.imageSize (number : 16 : IRW)
    // Size of images shown for fieldTypes image and imageFile in this field.
    // This setting overrides the global ListGrid default +link{attr:ListGrid.imageSize}.
    // <P>
    // If set to a String, assumed to be a property on each record that specifies the image
    // height.  For example, if <code>field.imageSize</code> is "logoSize",
    // <code>record.logoSize</code> will control the size of the image.
    //
    // @see attr:ListGridField.imageWidth
    // @see attr:ListGridField.imageHeight
    // 
    // @group imageColumns
    // @visibility external
	//<

  	//>	@attr	listGridField.imageWidth (number : 16 : IRW)
    // Width of images shown for fieldTypes image and imageFile in this field.
    // <P>
    // If set to a String, assumed to be a property on each record that specifies the image
    // width.  For example, if <code>field.imageWidth</code> is "logoWidth",
    // <code>record.logoWidth</code> will control the width of the image.
    //
    // @see attr:ListGrid.imageSize
    // @see attr:ListGridField.imageSize
    // @see attr:ListGridField.imageHeight
    // 
    // @group imageColumns
    // @visibility external
	//<

  	//>	@attr	listGridField.imageHeight (number : 16 : IRW)
    // Height of image shown for fieldTypes image and imageFile in this field.
    // <P>
    // If set to a String, assumed to be a property on each record that specifies the image
    // height.  For example, if <code>field.imageHeight</code> is "logoHeight",
    // <code>record.logoHeight</code> will control the heigt of the image.
    //
    // @see attr:ListGrid.imageSize
    // @see attr:ListGridField.imageSize
    // @see attr:ListGridField.imageWidth
    // 
    // @group imageColumns
    // @visibility external
	//<

    // ListGridField
    // ---------------------------------------------------------------------------------------

	//  -- Define the 'listGridField' pseudo class for doc

	//>	@object ListGridField
    // An ordinary JavaScript object containing properties that configures the display of
    // and interaction with the columns of a +link{ListGrid}.
	//
	// @see ListGrid.fields
	// @see ListGrid.setFields
	// @treeLocation Client Reference/Grids/ListGrid
	// @visibility external    
	//<

    //> @type ListGridFieldType
    // ListGrids format data for viewing and editing based on the <i>type</i> attribute of the
    // field.  This table describes how the ListGrid deals with the various built-in types.
    //
    // @value "text"    Simple text rendering for view.  For editing a text entry field is shown.
    // If the length of the field (as specified by the +link{attr:dataSourceField.length}
    // attribute) is larger than the value specified by +link{attr:listGrid.longTextEditorThreshold}, a
    // text input icon is shown that, when clicked on (or field is focused in) opens a larger
    // editor that expands outside the boundaries of the cell (textarea by default, but
    // overrideable via +link{ListGrid.longTextEditorType}).
    //
    // @value "boolean" For viewing and editing a checkbox is shown with a check mark for the
    // <code>true</code> value and no check mark for the <code>false</code> value.  See
    // +link{ListGrid.booleanTrueImage} for customization.
    //
    // @value "integer" Same as <code>text</code>.  Consider setting
    // +link{listGridField.editorType,editorType} to use a +link{SpinnerItem}.
    //
    // @value "float" Same as <code>text</code>.  Consider setting
    // +link{listGridField.editorType,editorType} to use a +link{SpinnerItem}.
    //
    // @value "date"
    // Expected to contain <code>Date</code> type data. Dates will be formatted using
    // +link{listGridField.displayFormat} if specified, otherwise +link{ListGrid.dateFormatter}.
    // If both these attributes are unset, dates are formatted using the standard 
    // +link{Date.setShortDisplayFormat(),short display format} for dates.
    // <P>
    // For editing, by default a +link{DateItem} is used with +link{DateItem.useTextField} set
    // to true, providing textual date entry plus a pop-up date picker. The
    // +link{DateItem.displayFormat, displayFormat} and +link{DateItem.inputFormat, inputFormat}
    // for the editor will be picked up from the ListGridField, if specified.
    //
    // @value "time"
    // Expected to contain Time data encoded in javascript <code>Date</code> objects.
    // Times will be formatted using +link{listGridField.displayFormat} if specified, 
    // otherwise +link{ListGrid.timeFormatter}.
    // <P>
    // If both these attributes are unset, times are formatted using the standard 
    // +link{Time.shortDisplayFormat,short display format} for times.
    // <P>
    // For editing, by default a +link{TimeItem} is used. The
    // +link{TimeItem.displayFormat, displayFormat} for the editor will be picked up from 
    // the ListGridField, if specified.
    //
    // @value "sequence" Same as <code>text</code>
    //
    // @value "link"     Renders a clickable html link (using an HTML anchor tag: &lt;A&gt;).
    // The target URL is the value of the field, which is also default display value.  You can
    // override the display value by setting +link{attr:listGridRecord.linkText} or
    // +link{attr:listGridField.linkText}.
    // <P>
    // Clicking the link opens the URL in a new window by default.  To change this behavior,
    // you can set <code>field.target</code>, which works indentically to the "target"
    // attribute on an HTML anchor (&lt;A&gt;) tag.
    // <P>
    // In inline edit mode, this type works like a text field.
    // <P>
    // To create a link not covered by this feature, consider using
    // +link{listGridField.formatCellValue()} along with +link{Canvas.linkHTML()}, or simply
    // +link{listGrid.getCellStyle,styling the field} to look like a link, and providing
    // interactivity via +link{listGridField.recordClick,field.recordClick()}.
    //
    // @value "image"   Renders a different image in each row based on the value of the field.  If
    // this URL is not absolute, it is assumed to be relative to
    // +link{ListGridField.imageURLPrefix} if specified. The size of the image is controlled by
    // +link{attr:listGridField.imageSize}, +link{attr:listGridField.imageWidth},
    // +link{attr:listGridField.imageHeight} (and by the similarly-named global default
    // attributes on the ListGrid itself).
    // <P>
    // You can also specify the following attributes on the field: <code>activeAreaHTML</code>, and
    // <code>extraStuff</code> - these are passed to +link{method:canvas.imgHTML} to generate the
    // final URL.
    // <P>
    // Note if you want to display icons <b>in addition to</b> the normal cell value, you
    // can use +link{listGridField.valueIcons,valueIcons} instead.
    // 
    // @value "icon" Shows +link{listGridField.icon,field.icon} in every cell, and also in the
    // header.  Useful for a field that is used as a button, for example, launches a detail
    // window or removes a row.  Implement a +link{listGridField.recordClick,field.recordClick}
    // to define a behavior for the button.
    // <P>
    // NOTE: for a field that shows different icons depending on the field value, see
    // +link{listGridField.valueIcons}.
    // <P>
    // <code>type:"icon"</code> also defaults to a small field width, accomodating just the icon
    // with padding, and to a blank header title, so that the header shows the icon only.  
    // <P>
    // +link{listGridField.iconWidth,field.iconWidth} and related properties configure
    // the size of the icon both in the header and in body cells.
    // <P> 
    // If you want the icon to appear only in body cells and not in the header, set
    // +link{listGridField.cellIcon,field.cellIcon} instead, leaving field.icon null.
    // 
    // @value "binary"  For viewing, the grid renders a 'view' icon (looking glass) followed by a
    // 'download' icon and then the name of the file is displayed in text.  If the user clicks the
    // 'view' icon, a new browser window is opened and the file is streamed to that browser
    // instance, using +link{dataSource.viewFile()}.  For images and other file types with
    // known handlers, the content is typically displayed inline - otherwise the browser will
    // ask the user how to handle the content.  If the download icon is clicked,
    // +link{dataSource.downloadFile()} is used to cause the browser to show a "save" dialog.
    // There is no inline editing mode for this field type.
    //
    // @value "imageFile"   Same as <code>binary</code>
    // 
    // @see attr:listGridField.type
    // @see type:FieldType
    // @visibility external
    // @example gridsDataTypes
    //<    

	//> @attr   listGridField.type  (ListGridFieldType : "text" : [IRW])
    //  ListGrids picks a renderer for the view and edit mode of a field based on this attribute.
    //
    //  @see type:ListGridFieldType
    //  @see type:FieldType
	//  @group  appearance
	//  @visibility external
	//<
    
	//> @attr   listGridField.name  (string : null : [IRW])
	// Name of this field.  Must be unique within this ListGrid.
    // <P>
    // The name of field is also the property in each record which holds the value for that
    // field.
    // <P>
    // If a +link{listGrid.dataSource} is specified and the DataSource has a field with the
    // same name, the ListGridField and DataSourceField are merged so that properties on the
    // ListGridField
    // 
	// @group data
	// @visibility external
	//<

	//> @attr   listGridField.title (string : null : [IRW])
	// A title for this field, to display in the header of the listGrid object.  Alternately you can
    // specify a +link{getFieldTitle()} method on the field to return the HTML for the field title.
    //
	// @group  appearance
    // @see method:listGridField.getFieldTitle()
	// @visibility external
	//<

    //> @method listGridField.getFieldTitle()
    // If your derivation of the field title is more complex than specifying a static string,
    // you can specify a getFieldTitle() method on your field to return the title string.
    // Otherwise you can use the +link{title} attribute on the field to specify the title.
    // <P>
    // You can use +link{listGrid.setFieldProperties,setFieldProperties()} to dynamically
    // update the title.
    //
    // @param viewer (ListGrid) pointer back to the ListGrid
    // @param fieldNum (number) index of this field in the grid's fields array.
    // @group appearance
    // @see attr:listGridField.title
    // @visibility external
    //<

	//> @method listGridField.showIf()
	// An optional +link{stringMethod} which if provided, is evaluated to conditionally determine
    // whether this field should be displayed. 
    // Evaluated on initial draw, then reevaluated on explicit 
	// calls to <code>listGrid.refreshFields()</code> or <code>listGrid.setFields()</code>. 
    // <P>
    // Use 'showIf:"false"' to set a ListGrid field to initially hidden.
    // <P>
    // Note that explicit calls to +link{listGrid.showField,grid.showField()} or hideField()
    // will wipe out the <code>showIf</code> expression, as will the end user showing and
    // hiding columns via the +link{listGrid.showHeaderContextMenu,header contextMenu}.
    // <P>
    // Also note that fields marked as +link{DataSourceField.detail,detail:true} will be hidden by
    // default even if +link{ListGrid.showDetailFields} is <code>true</code>. To show detail fields
    // inherited from a DataSource, include an explicit field definition for the field and
    // set this property to return <code>true</code>.
    // @param list (ListGrid) A pointer to the listGrid containing the field
    // @param field (ListGridField) the ListGridField object
    // @param fieldNum (integer) the index of the field
    // 
	// @group appearance
	// @see method:ListGrid.refreshFields
	// @visibility external
	//<
    
    //> @attr listGridField.frozen   (boolean : null : IR)
    // Whether this field should be "frozen" for the purposes of horizontal scrolling.  See
    // +link{group:frozenFields}.
    // @group frozenFields
    // @visibility external
    //<
    
    // Header button icons
    // ---------------------------------------------------------------------------------------
    // Include all relevant docs from StatefulCanvas
    
    //> @attr listGridField.icon    (SCImgURL: null : [IR])
    // Optional icon to show next to the title for this field. 
    // Should be set to a URL to an image. Relative paths will be evaluated starting at
    // the imgDir of this component. This URL is partial - it may be updated to indicate
    // the current disabled (etc) state of the field.
    // <P>
    // If +link{listGridField.type,field.type} is set to "icon", this icon will also be shown
    // in every cell of this field - see also +link{listGridField.cellIcon,field.cellIcon}.
    // 
    // @visibility external
    //<

    //> @attr listGridField.iconSize       (integer : null : [IR])
    // If +link{listGridField.icon} is specified, this property can be used to specify the 
    // size of the icon to be displayed in the ListGrid header button. 
    // (See +link{StatefulCanvas.iconSize})
    // @see listGridField.icon
    // @visibility external
    //<
    
    //> @attr listGridField.iconWidth      (integer : null : [IR])
    // If +link{listGridField.icon} is specified, this property can be used to specify the 
    // width of the icon to be displayed in the ListGrid header button. 
    // (See +link{StatefulCanvas.iconWidth})<br>
    // If this field is editable, and +link{ListGridField.editorIconWidth} is unset, this 
    // property will be passed onto the editors for this field as +link{FormItem.iconWidth}, 
    // which will effect the default size for +link{ListGridField.icons, icons} displayed 
    // in the editor. 
    // @see listGridField.icon
    // @see listGridField.icons
    // @visibility external
    //<

    //> @attr listGridField.iconHeight     (integer : null : [IR])
    // If +link{listGridField.icon} is specified, this property can be used to specify the 
    // height of the icon to be displayed in the ListGrid header button. 
    // (See +link{StatefulCanvas.iconHeight})<br>
    // If this field is editable, and +link{ListGridField.editorIconHeight} is unset, this 
    // property will be passed onto the editors for this field as +link{FormItem.iconWidth}, 
    // which will effect the default size for +link{ListGridField.icons, icons} displayed 
    // in the editor. 
    // @see listGridField.icon
    // @see listGridField.icons
    // @visibility external
    //<

    //> @attr listGridField.iconOrientation     (string : "left" : [IR])
    // If this field is showing an icon, should it appear to the left or right of the title?<br>
    // Valid options are <code>"left"</code> or <code>"right"</code>
    // @see listGridField.icon    
    // @visibility external
    //<
    // iconOrientation JS doc not included from statefulCanvas as that refers to 
    // setIconOrientation(), and we don't have an exposed way to get at the ListGrid field
    // header button at runtime.

    //> @attr listGridField.iconSpacing   (integer : 6 : [IR])
    // @include statefulCanvas.iconSpacing   
    // @see listGridField.icon        
    // @visibility external
    //<

    //> @attr listGridField.showDisabledIcon   (boolean : true : [IR])
    // @include statefulCanvas.showDisabledIcon
    // @see listGridField.icon        
    // @visibility external
    //<

    //> @attr listGridField.showRollOverIcon   (boolean : false : [IR])
    // @include statefulCanvas.showRollOverIcon
    // @see listGridField.icon        
    // @visibility external
    //<

    //> @attr listGridField.showFocusedIcon   (boolean : false : [IR])
    // @include statefulCanvas.showFocusedIcon
    // @see listGridField.icon        
    // @visibility external
    //<
    
    //> @attr listGridField.showDownIcon       (boolean : false : [IR])
    // @include statefulCanvas.showDownIcon
    // @see listGridField.icon        
    // @visibility external
    //<

    //> @attr listGridField.showSelectedIcon   (boolean : false : [IR])
    // @include statefulCanvas.showSelectedIcon   
    // @see listGridField.icon        
    //  @visibility external
    //<

    //> @attr listGridField.cellIcon    (SCImgURL: null : [IR])
    // For a field of type:"icon" only, set the icon that appears in body cells.  Unless
    // setting +link{listGridField.icon,field.icon}, setting field.cellIcon will not show an
    // icon in the header.
    // 
    // @visibility external
    //<

    // FormItem icons
    // ---------------------------------------------------------------------------------------
    
    //> @attr listGridField.icons (Array of FormItemIcon Properties: null : [IRA]) 
    // If this field is editable, this property can be used to specify 
    // +link{FormItem.icons, icons} to be displayed in the editors displayed for this field
    // @group editing
    // @visibility external
    //<
    
    //> @attr listGridField.editorIconWidth (number : null : [IRA])
    // If this field is editable, this property will be passed to editors displayed for
    // cells within this field as +link{FormItem.iconWidth}.<br>
    // If this property unset, the iconWidth property from the editor can be picked up from 
    // +link{listGridField.iconWidth} instead.
    // @see listGridField.icons
    // @group editing    
    // @visibility external
    //<

    //> @attr listGridField.editorIconHeight (number : null : [IRA])
    // If this field is editable, this property will be passed to editors displayed for
    // cells within this field as +link{FormItem.iconHeight}.<br>
    // If this property unset, the iconHeight property from the editor can be picked up from 
    // +link{listGridField.iconHeight} instead.
    // @see listGridField.icons
    // @group editing    
    // @visibility external
    //<
    
    //> @attr listGridField.defaultIconSrc (string : null : [IRA])
    // If this field is editable, this property will be passed to editors displayed for
    // cells within this field as +link{FormItem.defaultIconSrc}.
    // @see listGridField.icons
    // @group editing    
    // @visibility external
    //<
    
    //> @attr listGridField.iconPrompt (string : null : [IRA])
    // If this field is editable, this property will be passed to editors displayed for
    // cells within this field as +link{FormItem.iconPrompt}.
    // @see listGridField.icons
    // @group editing        
    // @visibility internal
    //<

    //> @attr listGridField.iconHSpace (string : null : [IRA])
    // If this field is editable, this property will be passed to editors displayed for
    // cells within this field as +link{FormItem.iconHSpace}.
    // @see listGridField.icons
    // @group editing        
    // @visibility internal
    //<    
    
    //> @attr listGridField.iconVAlign (string : null : [IRA])
    // If this field is editable, this property will be passed to editors displayed for
    // cells within this field as +link{FormItem.iconVAlign}.
    // @see listGridField.icons
    // @group editing        
    // @visibility external
    //<    

    // editor picker icon
    
    //> @attr listGridField.showPickerIcon (boolean : null : [IRA])
    // If this field is editable, this property will be passed to editors displayed for
    // cells within this field as +link{FormItem.showPickerIcon}.
    // @group editing    
    // @visibility pickerIcon
    //<
    
    //> @attr listGridField.pickerIconSrc (string : null : [IRA])
    // If this field is editable, this property will be passed to editors displayed for
    // cells within this field as +link{FormItem.pickerIconSrc}.
    // @group editing        
    // @visibility pickerIcon
    //<
    
    //> @attr listGridField.pickerIconWidth (integer : null : [IRA])
    // If this field is editable, this property will be passed to editors displayed for
    // cells within this field as +link{FormItem.pickerIconWidth}.
    // @group editing        
    // @visibility pickerIcon
    //<
    
    //> @attr listGridField.pickerIconHeight (integer : null : [IRA])
    // If this field is editable, this property will be passed to editors displayed for
    // cells within this field as +link{FormItem.pickerIconHeight}.
    // @group editing        
    // @visibility pickerIcon
    //<

    // Summary Title
    // ---------------------------------------------------------------------------------------
    
    //> @attr listGridField.summaryTitle (string : null : [IRWA])
    // Optional long summary title for this field, provided in addition to 
    // +link{listGridField.title}. This gives the developer an option to use a very short,
    // or empty title for the ListGrid column (where space may be a factor), but have a longer 
    // value available to be used elsewhere.<br>
    // By default this value will be used for the title of the context-menu item
    // for showing/hiding the listGrid field when the user right-clicks on the ListGrid header.
    //
    // @group appearance
    // @see attr:listGridField.title
    // @visibility external
    //<

    //> @method listGridField.getSummaryTitle() [A]
    // Optional string method to return a long summary title for this field, if a dynamic
    // summary title is required for this field.  
    //
    // @param viewer (listGrid) pointer back to the ListGrid
    // @param field (listGridField) pointer to the field object
    // @group appearance
    // @see attr:listGridField.summaryTitle
    // @see attr:listGridField.title
    // @visibility external
    //<

    // Header Appearance
    // ---------------------------------------------------------------------------------------
    
	//> @attr   listGridField.width (number|string : "*" : [IRW])
	//  The width of this field, specified as either an absolute number of pixels,
	//  a percentage of the remaining space, or "*" to allocate an equal portion of the
	//  remaining space. <br>
	//  ListGrid field widths may also be set when the fields are instantiated via the 
	//  listGrid.setFields() method by passing an array of numbers (absolute pixel sizes only) 
	//  as the second parameter 
	//  @group  appearance
	//  @visibility external
	//<

    //> @attr   listGridField.align (string : null : [IRW])
    // Horizontal alignment for field's column header: "left", "right"
    // or "center". Applied to the column header title and cells by default. A separate
    // alignment for cells can be specified via +link{listGridField.cellAlign}.<br>
    // If null, values are left-aligned. If this field is editable, the
    // alignment of cells in the body will also be reflected in any editors for the field.
    //  @group  appearance
    //  @visibility external
    //<

    //> @attr listGridField.headerBaseStyle (cssClass : null : [IRW])
    // Custom base style to apply to this field's header button instead of 
    // +link{listGrid.headerBaseStyle}.<br>
    // Note that depending on the header button constructor, you may have to override
    // +link{listGridField.headerTitleStyle} as well.
    // @group appearance
    // @visibility external
    //<
    
    //> @attr listGridField.headerTitleStyle (cssClass : null : [IRW])
    // Custom titleStyle to apply to this field's header button instead of 
    // +link{listGrid.headerTitleStyle}.<br>
    // Note that this will typically only have an effect if 
    // +link{listGrid.headerButtonConstructor} is set to +link{class:StretchImgButton} or a subclass 
    // thereof.
    // @group appearance
    // @visibility external
    //<
    

    // Header Spans
    // ---------------------------------------------------------------------------------------
    // - known limitations
    //   - can't reorder a column to before or after a spanned set of columns, if the spanned
    //   columns are at the start or end of the visible fields.
    //   - several uses of this.Super(), instead of the faster this.invokeSuper() approach.
    //   Attempt to use invokeSuper() failed, likely because the header is not a discrete
    //   class, but an instance of Toolbar, and my guess (Alex) is that Class.invokeSuper()
    //   doesn't handle this particular case.


    //> @attr listGrid.headerSpans (Array of HeaderSpan : null : IR)
    // Header spans are a second level of headers that appear above the normal ListGrid headers,
    // spanning one or more listGrid fields in a manner similar to a column-spanning cell in an 
    // HTML table.
    // <P>
    // A header span can be created by simply naming the fields the header should span.  The
    // example below creates a headerSpan that spans the first two fields of the ListGrid.
    // <pre>
    //    isc.ListGrid.create({
    //        headerHeight:40,
    //        fields : [
    //            { name:"field1" },
    //            { name:"field2" },
    //            { name:"field3" }
    //        ],
    //        headerSpans : [
    //            { 
    //                fields: ["field1", "field2"],
    //                title: "Field 1 and 2"
    //            }
    //        ]
    //    });
    // </pre>
    // Header spans will automatically react to resizing of the headers they span, and will be
    // hidden automatically when all of the spanned fields are hidden.
    // <P>
    // Header spans appear in the +link{listGrid.header,header} area of the ListGrid, sharing space
    // with the existing headers, so it's typical to set +link{listGrid.headerHeight} to
    // approximately double its normal height when using headerSpans.
    // <P>
    // See +link{headerSpan} for many properties that allow the control of the appearance of
    // headerSpans.  Note that headerSpans are created via the +link{AutoChild} pattern, hence
    // you can change the SmartClient component being used, or any of it's properties.
    // <P>
    // Neither headerSpans themselves nor the fields within them may be drag reordered, but other
    // unspanned headers may be.
    // <P>
    // Note that headerSpans primarily provide a visual cue for grouping multiple headers 
    // together.  If you have an OLAP, data "cube" or multi-dimensional data model, the
    // +link{CubeGrid} component is the right choice.
    //
    // @group headerSpan
    // @visibility external
    //<    

    //> @attr listGrid.headerSpanHeight (integer : null : IR)
    // Default height for a +link{listGrid.headerSpans,headerSpan} with no height specified.
    // <P>
    // If <code>headerSpanHeight</code> is not specified (the default), headerSpans will be 1/2
    // of +link{listGrid.headerHeight}.
    //
    // @group headerSpan
    // @visibility external
    //<

    //> @attr listGrid.headerSpanVAlign (vAlign : "center" : IR)
    // Default alignment for +link{listGrid.headerSpans,headerSpans} with no
    // +link{headerSpan.vAlign} specified.
    //
    // @group headerSpan
    // @visibility external
    //<
    headerSpanVAlign: "center",

    //> @attr listGrid.unspannedHeaderVAlign (vAlign : null : IR) 
    // When +link{listHeader.headerSpans,headerSpans} are in use, this property sets the default
    // vertical alignment for for fields which do <b>not</b> have a headerSpan.
    //
    // @group headerSpan
    // @visibility external
    //<

    //> @attr listGrid.headerSpanConstructor (SCClassName : null : IR)
    // +link{SCClassName,SmartClient Class} to use for headerSpans.  Typically a +link{Button} or
    // +link{StretchImgButton} subclass.
    // <P>
    // If unset, headerSpans will be created using the +link{listGrid.headerButtonConstructor}.
    //
    // @group headerSpan
    // @visibility external
    //<

    //> @attr listGrid.headerSpan (AutoChild : null : IR)
    // +link{listGrid.headerSpans,headerSpans} are created via the +link{AutoChild} pattern, hence
    // <code>headerSpanConstructor</code>, <code>headerSpanDefaults</code> and
    // <code>headerSpanProperties</code> are valid.
    //
    // @group headerSpan
    // @visibility external
    //<

    //> @object HeaderSpan
    // A header span appears as a second level of headers in a ListGrid, spanning one or more
    // ListGrid columns and their associated headers.
    // <P>
    // See +link{listGrid.headerSpans}.
    // <P>
    // In addition to the properties documented here, all other properties specified on the
    // headerSpan object will be passed to the +link{Class.create,create()} method of the
    // +link{listGrid.headerSpanConstructor}.  This allows you to set properties such as
    // +link{button.baseStyle} or +link{stretchImgButton.src} directly in a
    // <code>headerSpan</code>.  
    //
    // @group headerSpan
    // @visibility external
    //<

    //> @attr headerSpan.name (identifier : null : IR)
    // Name for this headerSpan, for use in APIs like +link{listGrid.setHeaderSpanTitle()}.
    // <P>
    // Name is optional, but if specified, must be unique for this ListGrid (but not globally
    // unique).
    //
    // @group headerSpan
    // @visibility external
    //<

    //> @attr headerSpan.fields (Array of String : null : IR)
    // List of fields that this header spans.  Fields should be identified by their value for
    // +link{listGridField.name}.
    //
    // @group headerSpan
    // @visibility external
    //< 

    //> @attr headerSpan.title (String : null : IR)
    // Title for this headerSpan.
    //
    // @group headerSpan
    // @visibility external
    //<

    //> @attr headerSpan.height (integer : null : IR)
    // Height of this headerSpan.  Defaults to +link{listGrid.headerSpanHeight}.
    //
    // @group headerSpan
    // @visibility external
    //<

    //> @attr headerSpan.valign (vAlign: null : IR)
    // Vertical alignment of the title of this headerSpan.
    // <P>
    // Defaults to listGrid.headerSpanVAlign if unset.
    //
    // @group headerSpan
    // @visibility external
    //<

    //> @attr headerSpan.align (Align: "center" : IR)
    // Horizontal alignment of the title of this headerSpan.
    //
    // @group headerSpan
    // @visibility external
    //<

    //> @attr listGrid.showTreeColumnPicker (boolean : true : IR)
    // When +link{listGrid.headerSpans} are in use, whether to show a hierarchical column picker
    // that includes both headerSpans and normal headers, with normal headers indented under
    // headerSpans similarly to how a +link{TreeGrid} displays a Tree.
    // <P>
    // If <code>showTreeColumnPicker</code> is false, no column picker will be shown on the
    // headerSpan itself, and the column picker for a clicked on a normal field header will include
    // only normal fields.
    //
    // @group headerSpan
    // @visibility external
    //<
    showTreeColumnPicker: true,


    // Cell Styling
    // ---------------------------------------------------------------------------------------
    
    //> @attr listGridField.cellAlign (string : null : [IRW])
    // Horizontal alignment for cells in this field's column: "left", "right"
	// or "center".<br>
    // If null, alignment is derived from +link{ListGridField.align}. If this field is editable, 
    // the alignment of cells in the body will also be reflected in any editors for the field.
	//  @group  appearance
	//  @visibility external
	//<
    
    //> @attr   listGridField.baseStyle (cssClass : null : [IRW])
    //  Custom base style to apply to all cells in this field instead of +link{ListGrid.baseStyle}
    //  To override the baseStyle at the row level, use 
    //  +link{ListGrid.recordBaseStyleProperty, record[listGrid.recordBaseStyleProperty]}
    //  instead.
    // @see ListGrid.recordBaseStyleProperty    
    // @group appearance
    // @visibility external
    // @example gridCells
    //<
    
    // Sorting (per field)   
    // ---------------------------------------------------------------------------------------

	//> @attr   listGridField.canSort (boolean : true : [IRW])
	//  Enables or disables sorting by this column. If false, neither interactive
	//  nor scripted (via the sort() method) instructions will sort the listGrid by this
	//  column.
	//  @group  sorting
	//  @see    method:ListGrid.sort
	//  @see    attr:ListGrid.canSort
	//  @visibility external
	//<
    
    //> @attr   listGridField.sortDirection   (SortDirection : null : [IRW])
    // Specifies the default sorting direction for this column. If specified on the
    // +link{listGrid.sortField,default sort field} for the listGrid, sorting occurs
    // automatically, otherwise this will be the default direction when the user clicks the
    // field header, or calls +link{ListGrid.sort()} without specifying an explicit sort direction.
    // <P>
    // Overrides ListGrid.sortDirection
	//  @group  sorting
	//  @see type:SortDirection
	//  @visibility external
	//<
    
	//> @method listGridField.sortNormalizer() (A)
	// Optional function to return the value that should be used when sorting this field.
    // <P>
    // Note that, if the dataset exceeds +link{ListGrid.dataPageSize} and hence paging is
    // introduced, the grid relies on the server to provide sorting, and the sortNormalizer
    // will no longer be called.
    //
	// @param recordObject    (object)    record to normalize
	// @param fieldName       (string)    name of the field on which sorting occurred
    // @param context (ListGrid) A pointer back to the list grid displaying this field will
    //   be available as the <code>context</code> argument. Note that you can also get a pointer
    //   to the field definition object by calling <code>context.getField(fieldName)</code>
	//  @return (any)   normalized value for sorting
	//  @group  sorting
	//  @visibility external
    //  @example dataTypes
	//<

	// Editing (per field)
	// ----------------------------------------------------------------------------------------

	//> @attr   listGridField.canEdit (boolean : null : [IRW])
	//      Can this field be edited? May be overridden by setting the
	//      'canEdit' property at the listGrid level 
	//  @group  editing
	//  @see attr:listGrid.canEdit
    //  @see attr:listGrid.recordEditProperty
    //  @see method:listGrid.canEditCell
	//  @visibility external
    //  @example disableEditing
	//<
    
    //> @attr listGridField.defaultValue (any : null : [IRW])
    // If this field +link{listGridField.canEdit, can be edited}, this property can be used to
    // specify a default value for this field's editor when adding new rows to the grid.
    // @see listGrid.startEditingNew()
    // @group editing
    // @visibility external
    //<
    
    //> @method listGridField.defaultDynamicValue()
    // If this field +link{listGridField.canEdit, can be edited}, this property can be used to
    // set a dynamic default value which will show up in editors for this field. 
    // Will be applied to the editor for the field as +link{FormItem.defaultDynamicValue}
    //
    // @param	item	(FormItem)  The editor for the cell itself (also available as "this").
    //                              Note that in addition to the standard FormItem APIs available
    //                              on the editor, it also has:<br>
    //                              - a pointer back to the containing listGrid 
    //                              [<code>item.grid</code>]<br>
    //                              - the colNum being edited [<code>item.colNum</code>]<br>
    //                              - the rowNum being edited [<code>item.rowNum</code>]
    // @param	form    (DynamicForm) the managing DynamicForm instance
    // @param   values  (Object)      the current set of values for the form as a whole
    // @group editing
    // @visibility external
    //<
    
	//> @attr   listGridField.enterKeyEditAction (EnterKeyEditAction : "done" : [IRW])
	// What to do when a user hits enter while editing this field?<br>
	// Overrides the <code>enterKeyEditAction</code> as specified at the listGrid level while 
	// focus is in this field.
	//  @group  editing
	//  @visibility external
	//<
    
	//> @attr   listGridField.escapeKeyEditAction (EscapeKeyEditAction : "cancel" : [IRW])
	// What to do when a user hits escape while editing this field?<br>
	// Overrides the <code>escapeKeyEditAction</code> as specified at the listGrid level while 
	// focus is in this field.
	//  @group  editing
	//  @visibility external
	//<

    
	//> @attr   listGridField.nextTabColNum (number : null : [IRWA])
	// If specified, when the user hits tab while editing this field, editing will move to the 
	// specified colNum in the next row (or the first editable field after it), rather than the 
	// next editable field in this row.
	//  @group  editing
	//  @visibility advancedInlineEdit
	//<
    
	//> @attr   listGridField.previousTabColNum (number : null : [IRWA])
	// If specified, when the user hits shift+tab while editing this field, editing will move 
	// to the specified colNum in the previous row (or the first editable field before it), 
	// rather than the previous editable field in this row.
	//  @group  editing
	//  @visibility advancedInlineEdit
	//<
    
	//> @attr   listGridField.editorType (FormItem className : null : [IRWA])
	//      Name of form item class to use for the form item created to edit this field. 
	//      (Only used if this field is editable).<br>
	//      Note: If this is not specified, the edit-form item type may be derived from the
	//      <code>editorType</code> property, typically inherited from datasource fields, or 
	//      from the <code>type</code> of the field (showing the appropriate form item for 
	//      the data-type). See the +link{group:editing} overview for more on editing ListGrid
    //      fields.
	//  @group  editing
	//  @see attr:listGrid.canEdit
	//  @visibility external
    //  @example customEditors
	//<
    // link to editing group documentation included as that describes the additional
    // "rowNum", "colNum" and "grid" properties stored on the editor.
    
	//> @attr   listGridField.editorProperties (FormItem properties : null : [IRWA])
	// Properties to apply the the form item created to edit this field. (Only used if
	// this field is editable).
    // <P>
    // For example, if you have a field "shoeSize" with +link{dataSourceField.editorType} set
    // to "SpinnerItem" in order to use a SpinnerItem as your field editor, and you want to pass the
    // +link{spinnerItem.step} property to the created SpinnerItem:
    // <pre>
    //    fields : [
    //        { name:"shoeSize", editorType:"SpinnerItem", 
    //          editorProperties : { step:0.5 } },
    //        ... other fields ...
    //    ]
    // </pre>
    //
	// @group editing
	// @visibility external
    // @example customEditors
	//<
    
	//> @attr   listGrid.modalEditing (boolean : null : [IRWA])
	//      If this property is true, any mouse click outside of the open cell editors
    //      will end editing mode, hiding the cell editors and saving any changes to those
    //      cell values.
	// @group  editing
    // @visibility external
    // @example modalEditing
	//<

	//> @method listGridField.editorEnter   (A)
	// Callback fired when the user first starts editing a cell.
    // <P>
    // This callback is typically used to establish dynamic default values via
    // +link{setEditValue()} or +link{setEditValues()}.
	//
	// @param record (ListGridRecord) record for the cell being edited.  <b>Will be null</b>
    //                                for a new, unsaved record.
	// @param value (any) value for the cell being edited
	// @param rowNum (integer)	row number for the cell
	// @param colNum (integer)	column number of the cell
    // @param grid (ListGrid) ListGrid to which this field belongs
	// @group editing
	// @visibility external
	//<

	//> @method listGridField.editorExit   (A)
	// Callback fired when the user attempts to navigate away from the current edit cell, 
	// or complete the current edit.<br>
	// Return false from this method to cancel the default behavior (Saving / cancelling the
	// current edit / moving to the next edit cell)
	//
	// @param   editCompletionEvent (EditCompletionEvent)  What interaction triggered this
	//                                                          edit cell exit
	// @param	record     (object)	record for the cell being edited
	// @param	newValue   (any)    new value for the cell being edited
	// @param	rowNum	   (number)	row number for the cell
	// @param	colNum	   (number)	column number of the cell
    // @param   grid    (ListGrid)  ListGrid to which this field belongs    
    // @return  (boolean)   Returning false from this method will cancel the default behavior
    //                      (for example saving the row) and leave the editor visible and focus
    //                      in this edit cell.
	//  @group  editing
	//  @see listGrid.editorExit
	// @visibility external
	//<
        
    //> @method  listGridField.cellChanged()
	//  Callback fired when field changes value as the result of a cell edit.  Fired only on
    //  successful save of edit, when the new value doesn't match the value before editing.<br>
    //  <p>
    //  Same signature as +link{method:listGrid.cellChanged()}, but defined on a per-field basis.
    //
	//  @group  editing
	//  @see method:listGrid.cellChanged()
	//  @visibility external
	//<
    
    //> @attr   listGridField.validators    (array of Validator : null : [IRW])
    // Array of +link{class:Validator} objects for this field.  When the user edits cells in
    // this field, these validators will be applied to the edited value.<br>
    // Note: for databound listGrids, this property may be specified on the 
    // +link{class:DataSourceField}, enabling both client and server side validation.
    // @see class:Validator
    // @see listGridField.required
    // @group gridValidation 
    // @visibility external
    // @example dataValidation
    //<
    
    //> @attr   listGridField.validateOnChange    (boolean : null : [IRW])
    // If set to true, any +link{listGridField.validators} for this field will be run whenever
    // the value of the field is edited.<br>
    // Analgous to the +link{FormItem.validateOnChange} property.
    // @group gridValidation
    // @visibility external
    //<
    
    //> @attr   listGridField.required       (boolean : false : [IRW])
    // When the user edits cells in this field, is this value required to be non-empty 
    // in order for validation to pass.<br>
    // Note: for databound listGrids, this property may be specified on the 
    // +link{class:DataSourceField}, enabling both client and server side validation.
    //
    // @see listGridField.validators
    // @group gridValidation
    // @visibility external
    //<
    
    //>@attr    listGridField.displayFormat (varies : null : [IRWA])
    // For fields of type <code>"date"</code>, set this property to a valid
    // +link{dateDisplayFormat} to specify how the date should be formatted.<br>
    // For fields of type <code>"time"</code>, set this property to a valid 
    // +link{type:timeFormatter, timeFormatter} to specify how the time should be formatted.<br>
    // If unset, display format may be set at the listGrid level via +link{ListGrid.dateFormatter}
    // or +link{ListGrid.timeFormatter}.
    // <p>
    // If this field is editable the displayFormat will also be passed to the editor created
    // to edit this field.  For dates you may also need to set +link{listGridField.inputFormat}.
    //
    // @see listGridField.inputFormat
    // @see listGrid.dateFormatter
    // @see listGrid.timeFormatter
    // @visibility external
    //<
    
    //>@attr    listGridField.inputFormat   (DateInputFormat : null : [IRWA])
    // For fields of type <code>"date"</code>, if this is an editable listGrid, this property 
    // allows you to specify the +link{DateItem.inputFormat, inputFormat} applied to the editor 
    // for this field.
    // @see listGridField.displayFormat
    // @visibility external
    //<
    
    //> @attr listGridField.isRemoveField (boolean : null : [IRA])
    // If set to true and +link{listGrid.canRemoveRecords} is true, this field will be rendered
    // as the remove-field for this grid. In most common usage scenarios this field will essentially
    // be a placeholder indicating where the remove field should be rendered, meaning properties 
    // other than <code>isRemoveField</code>, such as <code>name</code> or <code>title</code>, may
    // be left unset.
    // @see listGrid.canRemoveRecords
    // @visibility external
    //<

    //> @method  listGridField.recordClick()
    //
    // Executed when this field is clicked on.  Note that if +link{ListGrid.recordClick()} is
    // also defined, it will be fired for fields that define a recordClick handler if the
    // field-level handler returns true. Return false to prevent the grid-level handler from firing.
    //
    // @param	viewer		(ListGrid)	the listGrid that contains the click event
    // @param	record		(ListGridRecord)	the record that was clicked on
    // @param	recordNum	(number)	number of the record clicked on in the current set of
    //                                  displayed records (starts with 0)
    // @param	field		(ListGridField)	the field that was clicked on (field definition)
    // @param	fieldNum	(number)	number of the field clicked on in the listGrid.fields
    //                                  array
    // @param	value       (object)    value of the cell (after valueMap, etc. applied)
    // @param	rawValue	(object)	raw value of the cell (before valueMap, etc applied)
    // @return	(boolean)	false to stop event bubbling
    //
    // @group	events
    //
	// @see method:listGrid.recordClick()
	// @visibility external
    // @example recordClicks
	//<

    //> @method  listGridField.recordDoubleClick()
    //
    // Executed when this field is double-clicked.  Note that if
    // +link{ListGrid.recordDoubleClick()} is also defined, it will be fired for fields that define
    // a recordDoubleClick handler if the field-level handler returns true. Return false to prevent
    // the grid-level handler from firing.
    //
    //
    // @param	viewer		(ListGrid)	the listGrid that contains doubleclick event
    // @param	record		(ListGridRecord)	the record that was double-clicked
    // @param	recordNum	(number)	number of the record clicked on in the current set of
    //                                  displayed records (starts with 0)
    // @param	field		(ListGridField)	the field that was clicked on (field definition)
    // @param	fieldNum	(number)	number of the field clicked on in the listGrid.fields
    //                                  array
    // @param	value       (object)    value of the cell (after valueMap, etc. applied)
    // @param	rawValue	(object)	raw value of the cell (before valueMap, etc applied)
    // @return	(boolean)	false to stop event bubbling
    //
    // @group	events
    //
	// @see method:listGrid.recordClick()
	// @visibility external
    // @example recordClicks
	//<

    // Filtering
    // ---------------------------------------------------------------------------------------

	//> @attr   listGridField.canFilter (boolean : null : [IRW])
	//      If showing a filter row for this ListGrid, should the filter criteria for this 
	//      field be editable
	//  @group  filterEditor
	//  @visibility external
    //  @example disableFilter
	//<

	//> @attr listGridField.filterEditorValueMap (object : null : [IRW])
	//  If this listGrid is showing a filter row, this property can be used to specify a
	//  mapping of internal data to/from display values to be in the appropriate filter
	//  row form item.
	//  @visibility external
	//  @group filterEditor
	//<
    
	//> @attr   listGridField.filterEditorType (FormItem className : null : [IRWA])
	//      If this ListGrid is showing a filter row, this property can be used to
	//      specify the form item class to use for the filter form item associated with this 
	//      field
	//      (Only used if this field is not canFilter:false).<br>
	//      Note: If this is not specified, the edit-form item type may be derived from the
	//      'editorType' property, typically inherited from datasource fields, or from the
	//      'type' of the field (showing the appropriate form item for the data-type).
	//  @group  filterEditor
	//  @visibility external
	//<
    
    //> @attr   listGridField.defaultFilterValue (any : null : [IRWA])
    // If this ListGrid is showing a filter row, this property can be used to apply a default
    // value to show in the filter editor for this field.
    // @group filterEditor
    // @visibility external
    //<
    

	//> @attr   listGridField.filterEditorProperties (FormItem properties : null : [IRWA])
	// If this ListGrid is showing a filter row
    // (+link{listGrid.showFilterEditor,showFilterEditor}:true), this property
    // can be used to specify properties for the appropriate filter form item.
	// @group filterEditor
    // @visibility external
	//<
        
	//>	@attr     listGridField.filterOnKeypress (boolean : null : [IRWA])
	// If we're showing the filterEditor (listGrid.showFilterEditor is true), this property 
	// determines whether this list should be filtered every time the user edits the value of
    // the filter editor for this field.
	// @group filterEditor
	// @visibility external
	//<
    
    //> @attr listGrid.fetchDelay (number : 300 : IRWA)
	// If we're showing the filterEditor (+link(listGrid.showFilterEditor) is true), and we're
	// re-filtering on every keypress (+link(listGrid.filterOnKeypress) is true), this 
    // property is the delay in milliseconds between the user changing the filter and the 
    // filter request being kicked off. If multiple changes are made to the filter 
    // within this fetch delay, only the most recent will actually cause a re-filter
    // @group filterEditor
    // @visibility external
    //<
    fetchDelay:300,

	//>	@attr listGridField.shouldPrint (boolean : null : IRW)
    // Whether this field should be included in the printable representation of the grid.
	//
    // @group printing
	// @visibility printing
	//<

    // AutoComplete
    // ---------------------------------------------------------------------------------------

	//>	@attr	listGridField.autoComplete   (AutoComplete : null : IRW)
	// Whether to do inline autoComplete when editing this field.
	// <p>
	// If unset, defaults to listGrid.autoComplete
	//
	// @see listGrid.autoComplete
	// @visibility autoComplete
	//<

	//>	@attr	listGridField.uniqueMatch    (boolean : null : IRW)
	// When autoComplete is enabled, whether to offer only unique matches to the user.
	// <p>
	// If unset, defaults to listGrid.uniqueMatch.
	//
	// @see listGrid.uniqueMatch
	// @visibility autoComplete
	//<
    uniqueMatch:true,
    

	// Formatting (per field)
	// --------------------------------------------------------------------------------------------

	//> @method listGridField.getCellValue()    
	// A stringMethod which returns the cell value to display for this field for some record.
	// If defined, called by ListGrid.getCellValue().  Called in the scope of the field object.
    //
    // Deprecated as of Jan 12 05 in favor of field.formatCellValue, because 'getCellValue()'
    // is a lower-level API which handles (for example) returning the HTML for editors within
    // the cell.
	//  
	// @param  viewer  (ListGrid)  the ListGrid for which we're returning a cellValue
	// @param  record  (object)    the current record object
	// @param  recordNum   (nubmer)    row-index of the current record
	// @param  field   (listGridField) current field object
	// @param  fieldNum    (number)    column-index of the current field
	// @param  value   (any)   unformatted value for this field, determined via 
	//                          ListGrid.getRawCellValue()
	// @see    method:listGrid.getCellValue
	// @see method:listGridField.formatCellValue
	// @group  display_values
	// @visibility external
	// @return (any)   value to display in the ListGrid cell
	// @deprecated As of SmartClient 5.5, use +link{listGridField.formatCellValue}.
	//<
    
	// We provide separate formatters for the raw value displayed in a static cell, and the
	// value displayed in an editor.
	// This makes sense because:
	// - developers are likely to want to apply different formats - for example including some
	//   raw HTML in the static value, but not in the value displayed in a text based editor.
	// - the more common 'formatCellValue()' needs no parser to convert from the formatted value
	//   back to the raw value
	// If a developer wishes to apply the same formatter in both cases, the suggested approach
	// would be to write a single formatter function and have it be called from both methods.
    
	//> @method listGridField.formatCellValue()
	// Return the HTML to display in cells of this field.
    // <P>
    // Given the raw value for this field as taken from the record Formatter to apply to the
    // static values displayed in cells for this field.
    // <P>
	// <i>Example usage</i>: formatting a currency value stored in cents (so "100" to "$1.00")<br>
	// The value passed to this method is the raw value for the cell.<br>
	// Takes precedence over <code>formatCellValue</code> defined at the grid level for cells
	// in this field.
    // <P>
	// Note: this formatter will not be applied to the values displayed in cells being edited.
	// The +link{listGridField.formatEditorValue,formatEditorValue()} is provided for that purpose.
	//
	// @group display_values
	//
	// @param   value (any)   raw value for the cell, from the record for the row
	// @param   record   (ListGridRecord) 
    //   Record object for the cell. Note: If this is a new row that has not been saved, in an 
    //   editable grid, it has no associated record object. In this case the edit values will
    //   be passed in as this parameter (see +link{listGrid.getEditValues()})
	// @param   rowNum  (number)    row number for the cell
	// @param   colNum  (number)    column number for the cell.
	// @param   grid    (ListGrid) the ListGrid displaying the cell
	// @return (String) HTML to display in the cell
	//
	// @see listGrid.formatCellValue()
	// @see listGridField.formatEditorValue()
	// @visibility external
    // @example formatValues
	//<
    
	//> @attr   listGridField.linkText  (string : null : IRW)
    //  The HTML to display in cells of this field if the fieldType is set to link. Can be
    //  overridden by +link{attr:listGridRecord.linkText}.
    //
    //  @see type:ListGridFieldType
    //  @see type:FieldType
    //  @see attr:listGridRecord.linkText
    //  @see attr:listGrid.linkTextProperty
	//  @group  display_values
	//  @visibility external
    //  @example linkImage
	//<
    
    // --------------------
    // Editing 
    
	//> @method listGridField.formatEditorValue
	// Return the value to display in cells of this field which are being edited.
    // <P>
	// <i>Example usage</i>: converting a stored value in cents (100) to a dollar-and-cents 
	// value in the editor (1.00)
    // <P>
	// The value passed to this method is the raw value for the cell.
    // <P>
	// <code>formatEditorValue</code> takes precedence over +link{listGrid.formatEditorValue()}
    // defined at the grid level for cells in this field.
    // <P>
	// To convert the formatted value displayed within an editor back to a raw value, implement
	// +link{listGridField.parseEditorValue} as well.
	//
	// @group editing
	//
	// @param   value (any)   raw value for the cell being edited
	// @param   record   (ListGridRecord) 
    //   Record object for the cell. Note: If this is a new row that has not been saved, in an 
    //   editable grid, it has no associated record object. In this case the edit values will
    //   be passed in as this parameter.
	// @param   rowNum  (number)    row number for the cell
	// @param   colNum  (number)    column number for the cell.
	// @param   grid    (ListGrid instance) A pointer to the ListGrid displaying the cell
	// @return (any) formatted value to display in the editor
	//
	// @see listGridField.formatCellValue()
	// @see listGrid.formatEditorValue()
	// @see listGridField.parseEditorValue()
	//
	// @visibility external
	//<
    
	//> @method listGridField.parseEditorValue
	// Method used to convert the value displayed in an editor for some cell in this field into
	// a raw value for saving.<br>
	// Takes precedence over <code>parseEditorValue</code> defined at the grid level.
	//
	// @group editing
	//
	// @param   value (any)   value displayed in the editor for the cell
	// @param   record (object) record object for the row being edited. May be null if this
	//                          is a new row being added to the end of the list.
	// @param   rowNum  (number)    row number for the cell
	// @param   colNum  (number)    column number for the cell.
	// @param   grid    (ListGrid instance) A pointer to the ListGrid displaying the cell
	// @return (any) raw value for the field derived from formatted value in editor
	// @see listGrid.parseEditorValue()
	// @see listGridField.formatEditorValue()
	// @visibility external    
	//<

	//> @attr listGridField.valueMap (Array of Object : null : IRW)
    // Array of legal values for this field, or an Object where each property maps a stored
    // value to a user-displayable value.<br>
    // Note that if this field is editable (see +link{listGrid.canEdit}, 
    // +link{listGridField.canEdit}), editors displayed for this field will pick up their
    // valueMap either from this value or from +link{listGridField.editorValueMap}.
    // <P>
    // See also +link{dataSourceField.valueMap}.
    //
	// @group display_values
    // @see ListGrid.setValueMap()
	// @visibility external
    // @example listType
	//<
    
    //> @attr listGridField.editorValueMap (Array or Object : null : IRW)
    // A valueMap to use for editors shown for this field.  By default if this is not
    // specified +link{listGridField.valueMap,field.valueMap} will be used instead.
    // <P>
    // Dynamic valueMaps can be provided by implementing +link{listGrid.getEditorValueMap()}.
    // 
    // @group editing
    // @visibility external
    // @see listGrid.getEditorValueMap()
    // @see listGrid.setEditorValueMap()
    //<
    
    //> @method listGridField.change()
    // If this field is editable, any +link{formItem.change, change} handler specified
    // on the ListGridField will be passed onto the editors for this field.
    // @param	form    (DynamicForm) the managing DynamicForm instance
    // @param	item	(FormItem)    the editor (form item) itself (also available as "this").
    //                              Note that in addition to the standard FormItem APIs available
    //                              on the editor, it also has:<br>
    //                              - a pointer back to the containing listGrid 
    //                              [<code>item.grid</code>]<br>
    //                              - the colNum being edited [<code>item.colNum</code>]<br>
    //                              - the rowNum being edited [<code>item.rowNum</code>]
    // @param   value   (any)         The new value of the form item
    // @param   oldValue    (any)     The previous value of the form item
    // @see listGridField.changed()
    // @see listGrid.cellChanged()
    // @group editing
    // @visibility external
    //<
    
    //> @method listGridField.changed()
    // If this field is editable, any +link{formItem.changed, changed} handler specified
    // on the ListGridField will be passed onto the editors for this field.
    // @param	form    (DynamicForm) the managing DynamicForm instance
    // @param	item	(FormItem)    the editor (form item) itself (also available as "this").
    //                              Note that in addition to the standard FormItem APIs available
    //                              on the editor, it also has:<br>
    //                              - a pointer back to the containing listGrid 
    //                              [<code>item.grid</code>]<br>
    //                              - the colNum being edited [<code>item.colNum</code>]<br>
    //                              - the rowNum being edited [<code>item.rowNum</code>]
    // @param   value   (any)         The current value (after the change).
    // @see listGridField.change()
    // @see listGrid.cellChanged()
    // @group editing
    // @visibility external
    //<
    
	//> @attr listGridField.emptyCellValue    (string : "&amp;nbsp;" : IRW)
	// The value to display for a cell whose value is null or the empty
	// string after applying formatCellValue and valueMap (if any).
    // <p>
    // This is the field-specific attribute.  You may also set the emptyCellValue at the grid
    // level to define the emptyCellValue for all empty fields in the grid.
    // 
	// @group display_values
    // @see listGrid.emptyCellValue
	// @visibility external
    // @example emptyValues
	//<
    
	// Field.optionDataSource
	// --------------------------------------------------------------------------------------------

	//> @attr listGridField.autoFetchDisplayMap (boolean : null : [IRW])
	// If true, automatically fetches a valueMap if an +link{optionDataSource} is set
    // for this field.
    // <p>
    // Same as +link{listGrid.autoFetchDisplayMap}, but defined on a per-field basis.
    //
	// @group display_values
	// @see listGrid.autoFetchDisplayMap
    // @visibility external
	//<

	//> @attr listGridField.optionDataSource (String : null : [IRW])
	// Derive a +link{valueMap} by fetching records from another DataSource and extracting
    // the +link{listGridField.valueField,valueField} and 
    // +link{listGridField.displayField,displayField} in the loaded records, to derive one
    // valueMap entry per record loaded from the optionDataSource.
    // <P>
    // Unlike the similar use of +link{pickList.optionDataSource} for +link{PickList,pickLists}
    // used during editing or filtering, <code>listGridField.optionDataSource</code> causes the
    // entire set of records from the optionDataSource to be fetched, without paging.   Hence
    // listGridField.optionDataSource is appropriate only for smaller valueMaps.  For very
    // large valueMap situations, such as an accountId field that should be displayed as an
    // accountName where there are thousands of accounts, the recommended approach is:
    // <ul>
    // <li> do not set listGridField.optionDataSource
    // <li> declare two fields in the DataSource, eg "accountId" and "accountName".
    // <li> Set the +link{ListGridField.displayField} attribute on the data field to the
    //      name of the display field.
    // <li> When fetching records for display in a grid, have your server send back values for 
    //      both fields, but show only the data field ("accountId") in the grid.
    // </ul>
    // In this case the cells in the accountId field will show the record value from the 
    // accountName field.  This approach means the valueMap will never be loaded in its
    // entirety, instead, each loaded record contains the valueMapping for that one record, as
    // a pair of fields within the record.
    // <P>
    // Note that it is key that the server return <b>both</b> the underlying stored value
    // <b>and</b> the display value, as suggested above, because this approach allows the
    // +link{pickList.optionDataSource} property to be used to provide paged valueMaps during
    // inline editing and +link{ListGrid.showFilterEditor,inline filtering}.  Note that
    // pickList.optionDataSource is a distinct setting from listGridField.optionDataSource,
    // settable via +link{listGridField.editorProperties} (for editing) and 
    // +link{listGridField.filterEditorProperties,field.filterEditorProperties} (for
    // filtering).
    //
	// @group display_values
	// @visibility external
	//<

	//> @attr   listGridField.valueField (string : null : [IRW])
	// Specifies the +link{listGridField.optionDataSource} field used to retrieve the stored
    // values that are to be mapped to the display values (specified by
    // +link{listGridField.displayField}). Note that if this field is editable this will also
    // be applied to this field's editors.
    //
	// @group display_values
	// @visibility external
	//<

	//> @attr   listGridField.displayField (string : null : [IRW])
	// Specifies the +link{listGridField.optionDataSource} field used to retrieve the display
    // values that are to be mapped from the internal values specified by +link{valueField}.<br>
    // If no <code>optionDataSource</code> is defined for the field, the cell will display
    // the displayField value for the current record instead of the underlying value for
    // this field. Note that if this field is editable this will also
    // be applied to this field's editors.
    //
	// @group display_values
	// @visibility external
	//<

	// ----------------------------------------------------------------------------------------
	// Don't show scrollbars -- scrolling occurs in the body
    overflow:isc.Canvas.HIDDEN,	

	//>	@attr	listGrid.backgroundColor		(string : "white" : IRW)
	//		@group	appearance
	//<
	backgroundColor:"white",
    
	//>	@attr	listGrid.minHeight		(number : 50 : IRW)
	// Minimum height for the entire list (smaller than this doesn't tend to work very well).
	//		@group	sizing
	//<
    minHeight:50,							

    defaultWidth:200,

	//>	@attr	listGrid.fieldIdProperty    (string : "name" : IRWA)
	//  Property to be used as field identifier on listGridField objects.
	//  The ID of the field is also the property in each record which holds the value 
	//  for that field.
	//		@group	data
	//<
    // defaulted on Canvas
    

	// GridRenderer properties
	// ---------------------------------------------------------------------------------------

	//>	@attr	listGrid.showAllRecords		(boolean : false : [IRW])
	// @include gridRenderer.showAllRows
    // @example autofitRows
	//<
	//showAllRecords:false,

	//>	@attr	listGrid.drawAllMaxCells		(integer : 250 : IRWA)
	// @include gridRenderer.drawAllMaxCells
    // @group performance
    // @visibility external
	//<
	 drawAllMaxCells:250,


	//>	@attr	listGrid.drawAheadRatio      (float : 1.3 : IRW)
	// @include gridRenderer.drawAheadRatio
    // @group performance
    // @example databoundFetch
	//<
    drawAheadRatio:1.3,

    //> @attr listGrid.quickDrawAheadRatio (float : 1.3 : IRW)
    // @include gridRenderer.quickDrawAheadRatio
    // @group performance
    //<
    quickDrawAheadRatio:1.0,

    //> @attr listGrid.scrollRedrawDelay (integer : 75 : IRW)
    // @include gridRenderer.scrollRedrawDelay
    // @group performance
    // @visibility external
    //<
    scrollRedrawDelay:75,

    //> @attr listGrid.dataPageSize (integer : 75 : IRW)
    // @include dataBoundComponent.dataPageSize
    // @group performance
    // @visibility external
    // @example databoundFetch
    //<

    // delay in ms before triggering actual fetches
    dataFetchDelay : 300,

    //> @attr listGrid.body (AutoChild : null : R)
    // GridRenderer used to render the dataset.
    // @visibility external
    //<

    bodyConstructor:"GridBody",

	//>	@attr	listGrid.bodyOverflow		(Overflow : isc.Canvas.AUTO : [IRWA])
	// Overflow setting for the "body", that is, the area of the grid where data values are
    // rendered.
    // <P>
    // By setting both the grid itself and the body to overflow:visible, it is possible to
    // "auto-fit" to the rendered height or width of the rows.  Note that in this case
    // <code>grid.width</code> and <code>grid.height</code> act as minimums.
    //
	//      @visibility external
	//		@group	sizing
    //      @example autofitRows
	//<
    bodyOverflow:isc.Canvas.AUTO,
    

	//>	@attr	listGrid.bodyBackgroundColor		(string : "white" : IRW)
    // Background color applied to the ListGrid body (that is, the area of the grid where
    // data values are rendered).<br>
    // Note that this will typically not be visible to the user unless there are few enough
    // rows that there is visible space in the body below the last row. To style data cells,
    // override +link{ListGrid.baseStyle} instead.
	//		@group	appearance
    // @visibility external
	//<
    bodyBackgroundColor:"white",			
    
	//>	@attr	listGrid.bodyStyleName     (CSSStyleName : null : IR)
	// CSS style used for the body of this grid.  If applying a background-color to the body
    // via a CSS style applied using this property, be sure to set 
    // +link{ListGrid.bodyBackgroundColor} to <code>null</code>.
    //		@group	appearance
    // @visibility external
	//<
	//bodyStyleName:null,
    
    // whether to allow the body and header to have different border sizes and automatically
    // adjust the body column sizes to compensate such that column boundaries line up.
    allowMismatchedHeaderBodyBorder : true,

	//>	@attr	listGrid.emptyCellValue		(string : "&nbsp;" : IRW)
	// The value to display for cells whose value is null or the empty string after applying
    // formatCellValue and valueMap (if any).
    // <p>
    // This is the grid-wide attribute.  You may also set the emptyCellValue on a per-field basis.
    //
	// @group cellStyling
    // @see listGridField.emptyCellValue
    // @visibility external
    // @example emptyValues
	//<
	emptyCellValue:"&nbsp;",
    
	//>	@attr	listGrid.cellHeight		(number : 20 : [IRW])
	// @include gridRenderer.cellHeight
    // @example multilineValues
	//<
    cellHeight:20,							

	//>	@attr	listGrid.fixedRecordHeights		(boolean : true : IRWA)
	// @include gridRenderer.fixedRowHeights
    // @example autofitValues
	//<
	fixedRecordHeights:true,				

	//>	@attr	listGrid.fixedFieldWidths		(boolean : true : IRWA)
	// Should we horizontally clip cell contents, or allow columns to expand horizontally to
	// show all contents?
	// <P>
	// If we allow columns to expand, the column width is treated as a minimum.
	// <P>
	// NOTE: the header does not automatically respond to expanded field widths
    // @group cellStyling
	//<
	// NOTE: doc is duplicated here because in the ListGrid we need to discuss the header.
	fixedFieldWidths:true,

    // autoFit attributes
    
    //> @attr listGrid.autoFitData (string : null : IRW)
    // Should this ListGrid automatically expand to accomodate its content?
    // <P>
    // Valid settings are
    // <ul><li><code>"vertical"</code>: expand vertically to accomodate records.</li>
    //     <li><code>"horizontal"</code>: expand horizontally to accomodate fields.</li>
    //     <li><code>"both"</code>: expand horizontally and vertically to accomodate content.</li>
    // </ul>
    // Note that how far the ListGrid will expand may be limited via the following properties:
    // +link{ListGrid.autoFitMaxHeight}, +link{ListGrid.autoFitMaxRecords},
    // +link{ListGrid.autoFitMaxWidth}, +link{ListGrid.autoFitMaxColumns}.
    // @group autoFitData
    // @visibility external
    //<
    
    //> @attr listGrid.autoFitMaxHeight (number : null : IRW) 
    // If +link{listGrid.autoFitData} is set to <code>"vertical"</code> or <code>"both"</code> this
    // property provides an upper limit on how far the ListGrid will expand vertically to accomodate
    // its content. If content exceeds this height, scrollbars will be introduced as usual.  
    // In addition to this property, +link{ListGrid.autoFitMaxRecords} allows you to limit vertical
    // expansion based on the number of rows to be rendered.
    // @group autoFitData
    // @visibility external
    //<

    //> @attr ListGrid.autoFitMaxRecords (number : 50 : IRW)
    // if +link{listGrid.autoFitData} is set to <code>"vertical"</code> or <code>"both"</code> this
    // property provides the maximum number of records for which the ListGrid will expand. If more
    // records are present, scrolling will be introduced to reach them as normal.
    // If unset, by default the ListGrid will expand to accomodate as many records as are present.
    // @group autoFitData
    // @visibility external
    //<
    autoFitMaxRecords:50,
    
    //> @attr listGrid.autoFitMaxWidth (number : null : IRW) 
    // If +link{listGrid.autoFitData} is set to <code>"horizontal"</code> or <code>"both"</code>
    // this property provides an upper limit on how far the ListGrid will expand horizontally to
    // accomodate its content. 
    // If content exceeds this width, scrollbars will be introduced as usual.  
    // In addition to this property, +link{ListGrid.autoFitMaxColumns} allows you to limit 
    // horizontal expansion based on the number of columns to be rendered.
    // @group autoFitData
    // @visibility external
    //<
    
    //> @attr ListGrid.autoFitMaxColumns (number : 50 : IRW)
    // if +link{listGrid.autoFitData} is set to <code>"horizontal"</code> or <code>"both"</code>
    // this property provides the maximum number of columns for which the ListGrid will expand.
    // If more columns are present, scrolling will be introduced to reach them as normal.
    // If unset the ListGrid will expand to accomodate as many columns as are defined for the
    // grid.
    // @group autoFitData
    // @visibility external
    //<    
    autoFitMaxColumns:50,
    
    //> @attr listGrid.leaveScrollbarGap  (boolean : true : IRW)
	// Whether to leave a gap for the vertical scrollbar, even when it's not present.
    // <P>
    // Note that if leaveScrollbarGap is false and vertical scrolling is introduced, fields
    // will be resized to fit the smaller body area if possible, in order to avoid horizontal
    // scrolling also being required.
    //
    // @group appearance
    // @visibility external
    // @example autofitRows
    //<
    
	leaveScrollbarGap:true,

	// if leaveScrollbarGap is false, whether to resize fields when vscrolling is introduced
    resizeFieldsForScrollbar:true,

	//>	@attr	listGrid.autoFit              (boolean : false : IRWA)
	// If true, make columns only wide enough to fit content, ignoring any widths specified.
	// Overrides fixedFieldWidths.
	// <P>
	// NOTE: the header does not automatically respond to expanded field widths
	//	@group	sizing
	//<
	//autoFit:false,

	//>	@attr	listGrid.wrapCells		(boolean : false : IRWA)
	// @include gridRenderer.wrapCells
    // @example autofitValues
	//<
	//wrapCells:false,

	//>	@attr	listGrid.cellSpacing		(number : 0 : [IRW])
	// @include gridRenderer.cellSpacing
    // @visibility internal
	//<
    
	cellSpacing:0,

	//>	@attr	listGrid.cellPadding		(number : 2 : [IRW])
	// @include gridRenderer.cellPadding
	//<
	cellPadding:2,

	//>	@attr   listGrid.dateFormatter  (DateDisplayFormat : null : [IRW])
	// Display format to use for fields specified as type 'date'.  Default is to use the
    // system-wide default short date format, configured via
    // +link{Date.setShortDisplayFormat()}.  Specify any valid +link{type:DateDisplayFormat}, or
    // function to change the display format for dates used by this grid.
    // If specified as  a function, this function will be executed in the scope of the Date
    // and should return the formatted string.<br>
    // May also be specified at the field level via
    // +link{listGridField.displayFormat}.<br>
    // If this field is editable the dateFormatter will also be passed to the editor created
    // to edit this field as +link{DateItem.displayFormat, displayFormat}.
    // In this case you may also need to set +link{listGrid.dateInputFormat}.
    // 
    // @see listGridField.displayFormat
	// @group appearance
    // @visibility external
	//<
    //dateFormatter:null,
    
    //>@attr    listGrid.dateInputFormat   (DateInputFormat : null : [IRWA])
    // If this is an editable listGrid, this property will specify the 
    // +link{DateItem.inputFormat, inputFormat} applied to editors for fields of type 
    // <code>"date"</code>
    // @see listGrid.dateFormatter
    // @visibility external
    //<

	// function to call appropriate date formatter
	// Note: this is executed in the scope of a field object - see 'applyFieldDefaults'
    _formatDateCellValue : function (value, field, grid, record, rowNum, colNum) {
        if (isc.isA.Date(value)) {
            var formatter = grid._getDateFormatter(field);
            
            if (formatter != null) {
                // NOTE: this relies on the fact that there are actual functions installed on
                // Date instances with the same names as the doc'd date formats
                if (isc.isA.Function(value[formatter])) return value[formatter]();
                if (isc.isA.Function(formatter)) return formatter.apply(value);
                
                // In this case an invalid formatter was specified:
                grid.logWarn("Specified dateFormatter '" + formatter + 
                             "' is not a valid date formatter name.  " + 
                             "Displaying date in shortDate format.");
            }
            // Default to toShortDate() which is itself customizeable for all date instances
            return value.toShortDate();
        }
        return value;
    },
    
    _getDateFormatter : function (field) {
        var formatter;
        
        if (field) formatter = (field.displayFormat || field.dateFormatter || field.formatter);
        if (!formatter) formatter = this.dateFormatter;
        return formatter;
    },
    
    _getDateInputFormat : function (field) {
        var inputFormat;
        if (field) inputFormat = field.inputFormat
        if (!inputFormat) inputFormat = this.dateInputFormat;
        return inputFormat;
    },

    // function to call appropriate number formatter
    // If no number formatter is defined, the default formatter will be used [standard 'toString']
    // is the default
    _formatNumberCellValue : function (value, field, grid, record, rowNum, colNum) {
        if (isc.isA.Number(value)) {
            var formatter = (field.numberFormatter || field.formatter || grid.numberFormatter);
            return value.toFormattedString(formatter);
        }
        // If passed a non-number just return it
        return value;
    },
    
	//>	@attr   listGrid.timeFormatter  (timeFormatter : "toShortPaddedTime" : [IRW])
	// Display format to use for fields specified as type 'time'.  May also be specified at 
    // the field level via +link{listGridField.displayFormat}.<br>
    // If unset, time fields will be formatted based on the system wide 
    // +link{Time.shortDisplayFormat}.<br>
    // If this field is editable, the timeFormatter will also be passed to the editor
    // created to edit any time type fields as +link{TimeItem.displayFormat}
	// @group appearance
    // @visibility external
	//<
    timeFormatter:"toShortPaddedTime",
    
    _getTimeFormatter : function (field) {
        var formatter;
        
        
        if (field) formatter = (field.displayFormat || field.timeFormatter || field.formatter);
        if (!formatter) formatter = this.timeFormatter;
        return formatter;
    },

	// function to call appropriate time formatter
	// Note: this is executed in the scope of a field object - see 'applyFieldDefaults'
    _formatTimeCellValue : function (value, field, grid, record, rowNum, colNum) {
        var time = value;
        if (isc.isA.String(time)) {
            time = isc.Time.parseInput(time);
        }
        if (time != null) {
            var formatter = grid._getTimeFormatter(field);
            
            // If we're passed an invalid formatter
            return isc.Time.toTime(time, formatter);
        }
        return value;
    },
    
    _formatBinaryCellValue : function (value, field, grid, record, rowNum, colNum) {
        
        if (isc.isA.String(value)) return value;

        var name = record[field.name + "_filename"];
        var viewIconHTML = isc.Canvas.imgHTML("[SKIN]actions/view.png", 16, 16, null,
                        "style='cursor:"+isc.Canvas.HAND+"' onclick='"+grid.getID()+".viewRow("+rowNum+")'");
        var downloadIconHTML = isc.Canvas.imgHTML("[SKIN]actions/download.png", 16, 16, null,
                        "style='cursor:"+isc.Canvas.HAND+"' onclick='"+grid.getID()+".downloadRow("+rowNum+")'");

        return viewIconHTML + "&nbsp;" + downloadIconHTML + "&nbsp;" + name;
    },

    // value is rendered as an anchor - the href and name of the anchor is the value.  By default
    // opens in a new browser window - this can be overridden by setting the 'target' property on
    // the record.
    //
    // The name of the link can be overridden by setting the 'linkName' property on the record.  By
    // default we use the value.
    _$linkTemplate:[
        "<a href='",
        ,   // 1: HREF
        "' target='",
        ,   // 3: name of target window
        // onclick handler enables us to prevent popping a window if (EG) we're masked.        
        //                      5: ID              
        "' onclick='if(window.",     ,") return ",
                //  7:ID                         9:rowNum,     11:colNum        
                         ,"._linkClicked(event,",        ,",",          ,");'>",
        ,   // 13: link text
        "</a>"
    ],
    _$doubleEscapedQuote:"\\'",
    _$_blank:"_blank",
    
    _formatLinkCellValue : function (value, field, grid, record, rowNum, colNum) {
        if (value == null || isc.is.emptyString(value)) return value;

        // target window
        var target = field.target ? 
                        field.target.replaceAll(grid._$singleQuote, grid._$doubleEscapedQuote) : 
                        grid._$_blank;

        // link text to show
        var linkText = (record && record[this.linkTextProperty]) ? record[this.linkTextProperty] 
                                                            : field[this.linkTextProperty] || value;

        // link URL
        var href = value;

        if (field.linkURLPrefix) href = field.linkURLPrefix + href;
        if (field.linkURLSuffix) href = href + field.linkURLSuffix;

        href = href.replaceAll(grid._$singleQuote, grid._$doubleEscapedQuote);
        
        // combine
        var template = grid._$linkTemplate;
        template[1] = href;
        template[3] = target;
        var ID = grid.getID();
        template[5] = ID;
        template[7] = ID;
        template[9] = rowNum;
        template[11] = colNum;
        template[13] = linkText;

        return template.join(isc.emptyString);
    },
    
    _linkClicked : function (event, rowNum, colNum) {
        // don't allow the click if the cell should not be interactive.
        var mustCancel = (this.destroyed || !this.isDrawn() || !this.isVisible() ||
                          isc.EH.targetIsMasked(this.body) || !this.recordIsEnabled(rowNum, colNum));
        if (mustCancel) {
            
            if (!isc.Browser.isIE) {
                event.preventDefault();
            }
            return false;
        }
    },
    
    //> @attr   listGrid.linkTextProperty    (string : "linkText" : [IRW])
	// Property name on a record that will hold the link text for that record.
	// <br>
	// This property is configurable to avoid possible collision with data values in the record.
	//
	//  @see type:ListGridFieldType
    //  @see type:FieldType
    //  @see attr:listGridField.linkText
	//  @group  display_values
	//  @visibility external
	//<
    linkTextProperty : "linkText",
    
    // value is a URL to an image
    _formatImageCellValue : function (value, field, grid, record, rowNum, colNum) {
        // if no value is stored, just return an empty string so we don't render a broken image
        if (value == null || value == isc.emptyString) return isc.emptyString;

        var width, height;

        // if any of field.imageWidth/Height/Size are set as strings, assume they are property
        // names on the record
        var imageWidthProperty, imageHeightProperty, imageSizeProperty;
        if (isc.isA.String(field.imageWidth)) {
            imageWidthProperty = field.imageWidth;
        } else {
            width = field.imageWidth;
        }
        if (isc.isA.String(field.imageHeight)) {
            imageHeightProperty = field.imageHeight;
        } else {
            height = field.imageHeight;
        }
        if (isc.isA.String(field.imageSize)) {
            imageSizeProperty = field.imageSize;
        } else {
            width = width || field.imageSize;
            height = height || field.imageSize;
        }

        if (record != null) {
            width = width || record[imageWidthProperty] || record[imageSizeProperty];
            height = height || record[imageHeightProperty] || record[imageSizeProperty];
        }
        width = width || grid.imageSize;
        height = height || grid.imageSize;
        
        var src = value,
            prefix = field.imageURLPrefix || field.baseURL || field.imgDir;

        // If imageURLSuffix is specified, apply it to the value
        if (field.imageURLSuffix != null) src += field.imageURLSuffix;            
         
        

        return isc.Canvas.imgHTML(src, width, height, null, field.extraStuff, 
                                  prefix, field.activeAreaHTML);
    },

    // show field.icon in the cell
    _formatIconCellValue : function (value, field, grid, record, rowNum, colNum) {
        if (field._iconHTML) return field._iconHTML;

        field._iconHTML = isc.Canvas.imgHTML(field.cellIcon || field.icon, 
                                             field.iconWidth || field.iconSize,
                                             field.iconHeight || field.iconSize);
        return field._iconHTML;
    },

	// CSS styles
	// --------------------------------------------------------------------------------------------

	//>	@attr	listGrid.baseStyle		(CSSStyleName : "cell" : [IR])
	// @include gridRenderer.baseStyle
	//<
	baseStyle:"cell",

	
    
    //>	@attr	listGrid.editFailedBaseStyle    (CSSStyleName : null : [IRWA])
	//  A base name for the CSS class applied to cells when editing has failed.<br>
	//  If this listGrid is editable, this style will be applied to any edited cells for which
	//  validation failed.<br>
	//  As with the default 'baseStyle' property, this style will have "Dark", "Over", "Selected", 
	//  or "Disabled" appended to it according to the state of the cell.<br>
    // If null, cells for which editing has failed will be rendered using the normal base style
    // classNames, but with custom CSSText applied as derived from <code>this.editFailedCSSText</code>
	// @visibility external
	// @group	appearance
	// @see baseStyle
    // @see editFailedCSSText
	//<
    editFailedBaseStyle:null,   //"cellEditFailed",
    
	//>	@attr	listGrid.editFailedCSSText    (string : "color:red;border:1px solid red;" : [IRWA])
	//  Custom CSS text to be applied to cells when editing has failed.<br>
	//  If this listGrid is editable, this css text will be applied to any edited cells for which
	//  validation failed, on top of the base style for the cell.<br>
    // For further customization of styling for cells that failed editing validation, use
    // <code>this.editFailedBaseStyle</code> instead.
	// @visibility external
	// @group	appearance
    // @see editFailedBaseStyle
	//<
    editFailedCSSText:"color:red;border:1px solid red;",
    
	//>	@attr	listGrid.editPendingBaseStyle    (CSSStyleName : null : [RA])
	//  A base name for the CSS class applied to cells containing pending (unsaved) edits<br>
	//  As with the default 'baseStyle' property, this style will have "Dark", "Over", "Selected", 
	//  or "Disabled" appended to it according to the state of the cell.
    //  If this property is null, cells with pending edits will pick up custom css text to
    //  be applied on top of the normal base style from <code>this.editPendingCSSText</code>
	//      @visibility external
	//		@group	appearance
	//      @see baseStyle
	//<    
    editPendingBaseStyle:null, //"cellEditPending",

	//>	@attr	listGrid.editPendingCSSText    (string : "border:color:#0066CC;" : [IRWA])
	//  Custom CSS text to be applied to cells with pending edits that have not yet been
    //  submitted.<br>
    // For further customization of styling for cells with pending edits use
    // <code>this.editPendingBaseStyle</code> instead.
	// @visibility external
	// @group	appearance
    // @see editFailedBaseStyle
	//<
    editPendingCSSText:"color:#0066CC;",

    //> @attr   ListGrid.recordCustomStyleProperty  ("customStyle" : string : IRW)
    // @include GridRenderer.recordCustomStyleProperty
    // @visibility external
    // @see listGrid.getCellStyle()
    // @see listGrid.recordBaseStyleProperty
    //<
    recordCustomStyleProperty:"customStyle",
    
    //> @attr   listGrid.recordBaseStyleProperty    (string : "_baseStyle" : [IRWA])
    // This attribute allows custom base styles to be displayed on a per-record basis.
    // To specify a custom base-style for some record set 
    // <code>record[listGrid.recordBaseStyleProperty]</code> to the desired base style name - 
    // for example if <code>recordBaseStyleProperty</code> is <code>"_baseStyle"</code>, set
    // <code>record._baseStyle</code> to the custom base style name.
    // 
    // @visibility external
    // @group appearance
    // @see listGrid.baseStyle
    //<
    recordBaseStyleProperty:"_baseStyle",
    
    //> @attr listGrid.frozenBaseStyle (string : null : [IRW])
    // If this listGrid contains any frozen fields, this property can be used to apply a custom
    // baseStyle to all cells in those frozen fields. If unset, the standard base style will be
    // used for both frozen and unfrozen cells.
    // @visibility external
    // @group appearance, frozenFields
    // @see listGrid.baseStyle
    // @see listGridField.frozen
    //<
    
    //> @attr listGrid.shrinkForFreeze (boolean : false : IRWA)
    // If this list grid is showing any +link{listGridField.frozen,frozen} fields, and a horizontal
    // scrollbar is visible at the bottom of the liquid columns, should an equivalent scrollbar gap
    // be left visible below the frozen columns?<br>
    // Note that if set to <code>true</code> any backgroundColor or border applied to the ListGrid
    // will show up below the bottom row of the frozen column(s).
    // @group frozenFields
    // @visibility external
    //<
    shrinkForFreeze:false,
    
    //> @attr listGrid.alternateRecordStyles    (boolean : false : [IRW])
    // @include gridRenderer.alternateRowStyles
	// @group cellStyling
    // @example gridCells
    //<
	//alternateRecordStyles:false,
    
    //> @attr listGrid.alternateBodyStyleName (CSSStyleName : null : [IRWA])
    // Optional css style to apply to the body if +link{listGrid.alternateRecordStyles} is true 
    // for this grid. If unset +link{listGrid.bodyStyleName} will be used to style the body
    // regardless of the +link{listGrid.alternateRecordStyles,alternateRecordStyles} setting.
    // @visibility external
    //<

	//>	@attr	listGrid.alternateRecordFrequency		(number : 1 : [IRW])
	// @include gridRenderer.alternateRowFrequency
	// @group cellStyling
	//<
	alternateRecordFrequency:1,

    // property you can set per-record to add custom CSSText
    recordCSSTextProperty : "cssText",

	//>	@attr	listGrid.showHiliteInCells		(boolean : false : IRWA)
	// When cell styling is being updated (updateCellStyle()), should the HTML content of the
	// cell also be updated?  If false, only the cell's CSS styling will be updated. 
	//
	// You should turn this on if you've implemented a <code>formatCellValue</code> function 
	// that adds styling cues to a cell (like an inline image), which need be updated as the 
	// cell switches states.
	// (eg, if you would use different HTML for a selected cell's contents).
	//		@group	hiliting, drawing
	//<
	//showHiliteInCells:false,				
    
    // Keyboard handling
    // ---------------------------------------------------------------------------------------

    //> @attr   listGrid.generateClickOnSpace   (boolean : true : IRWA)
    // If true, when the user navigates to a cell using arrow keys and hits space, 
    // the cell will respond to a click event.
    // @visibility external
    //<
    generateClickOnSpace : true,
		
    //> @attr   listGrid.generateClickOnEnter  (boolean : false : IRWA)
    // If true, when the user navigates to a cell using arrow keys and hits Enter, 
    // the cell will respond to a click event.
    // @visibility external
    //<
    //generateClickOnEnter : false,

    //>@attr   listGrid.generateDoubleClickOnSpace   (boolean : false : IRWA)
    // If true, when the user navigates to a cell using arrow keys and hits Space, 
    // the cell will respond to a double click event.
    // @visibility external
    //<
    // generateDoubleClickOnSpace : false,
    
    //>@attr   listGrid.generateDoubleClickOnEnter  (boolean : true : IRWA)
    // If true, when the user navigates to a cell using arrow keys and hits Enter, 
    // the cell will respond to a double click event.
    // @visibility external
    //<
    generateDoubleClickOnEnter : true,

    //>@attr    listGrid.arrowKeyAction (string : "select" : IRWA)
    // Action to perform when the listGrid has keyboard focus (but not editing focus) and a user
    // presses the up or down arrow key. Possible values are:
    // <ul>
    // <li><code>select</code> : select the next row in the list (calls <code>recordClick</code> handler)</li>
    // <li><code>focus</code> : move focus to the next row in the list without changing the selection</li>
    // <li><code>activate</code> : select and activate the next row in the list (calls
    //  <code>recordDoubleClick</code> handler)</li>
    // <li><code>none</code> : no action</li>
    // </ul>
    // @group events
    // @visibility external
    //<
    arrowKeyAction:"select",

	// Rollover
	// --------------------------------------------------------------------------------------------
	//>	@attr	listGrid.showRollOver		(boolean : true : IRW)
	// Should we show different styling for the cell the mouse is over?
    // <br>
    // If true, the cell style will have the suffix "Over" appended.
	// @group appearance
    // @visibility external
	//<
	showRollOver:true,
    
    //> @attr listGrid.showRollOverCanvas (boolean : null : IRWA)
    // If +link{listGrid.showRollOver} is true, this property provides an option to show roll over
    // styling with the +link{listGrid.rollOverCanvas} and +link{listGrid.rollUnderCanvas}
    // rather than using css styling.
    // @group rowEffects
    // @visibility rollOverCanvas
    //<
    //showRollOverCanvas:null,
    
    //> @attr listGrid.rollOverCanvas (autoChild : null : RA)
    // AutoChild created and embedded in the body if +link{listGrid.showRollOver} is true, and
    // +link{listGrid.showRollOverCanvas} is true.  This autoChild canvas will be created and 
    // displayed above the current rollOver row.
    // <P>
    // Note that the rollOverCanvas has the following read-only attributes set:<br>
    // - <code>this.grid</code> - a pointer to the ListGrid showing the rollOverCanvas<br>
    // - <code>this.record</code> - a pointer to the current roll over record object in the grid.
    // 
    // @group rowEffects
    // @visibility rollOverCanvas
    //<

	//> @attr listGrid.rollUnderCanvas (autoChild : null : RA)
    // AutoChild created and embedded in the body if +link{listGrid.showRollOver} is true, and
    // +link{listGrid.showRollOverCanvas} is true.  This autoChild canvas will be created and 
    // displayed behind the current rollOver cell in the page's z-order, meaning it will only be
    // visible if the cell styling is transparent. 
    // <P>
    // Note that the rollUnderCanvas has the following read-only attributes set:<br>
    // - <code>this.grid</code> - a pointer to the ListGrid showing the rollUnderCanvas<br>
    // - <code>this.record</code> - a pointer to the current roll over record object in the grid.
    // @group rowEffects
    // @visibility rollOverCanvas
    //<
    
    //>Animation
    
    //> @attr listGrid.animateRollOver (boolean : false : IRWA)
    // If +link{listGrid.showRollOverCanvas} is <code>true</code> setting this property to true
    // ensures that when the rollOver canvas is displayed it animates into view via an
    // +link{Canvas.animateShow()}. Note that the animation effect may be customized via the
    // standard +link{Canvas.animateShowEffect}, +link{Canvas.animateShowTime} and 
    // +link{Canvas.animateShowAccelleration}.
    // @group rowEffects
    // @visibility rollOverCanvas
    //<
    
    //> @attr listGrid.animateRollUnder (boolean : false : IRWA)
    // If +link{listGrid.showRollOverCanvas} is <code>true</code> setting this property to true
    // ensures that when the rollUnder canvas is displayed it animates into view via an
    // +link{Canvas.animateShow()}. Note that the animation effect may be customized via the
    // standard +link{Canvas.animateShowEffect}, +link{Canvas.animateShowTime} and 
    // +link{Canvas.animateShowAccelleration}.
    // @group rowEffects
    // @visibility rollOverCanvas
    //<
    
    //<Animation
    
    // are rollovers cell-level or row-level
	//useCellRollOvers:false,
	
	// Hover
	// --------------------------------------------------------------------------------------------

	//>	@attr listGrid.canHover     (boolean : null : [IRW])
	// @include gridRenderer.canHover
    // @group hovers
    // @see attr:listGrid.showHover
    // @see attr:listGridField.showHover
    // @example valueHoverTips
	//<
	// are hover events and hover popups enabled?
	//canHover:false,							

	//>	@attr listGrid.showHover    (boolean : true : [IRW])
	// @include gridRenderer.showHover
    // @group hovers
	//<
	// if canHover:true, should we show hover popups?
	showHover: true,							

	//>	@attr listGridField.showHover    (boolean : null : [IRW])
	// Whether to show hovers for this field.  The default hover will be the contents of the
    // cell the user is hovering over, and can be customized via
    // +link{listGridField.hoverHTML,field.hoverHTML()}.
    // <P>
    // +link{ListGrid.canHover} can be set to true to cause hovers to be shown for all fields
    // by default.  In this case, <code>field.showHover</code> can be set to false to suppress
    // hovers for an individual field.
    // <P>
    // All hovers can be disabled, regardless of other settings, by setting
    // +link{ListGrid.showHover} to false.
    // @visibility external
    // @example valueHoverTips
	//<
    
	// can be set to false to cause hover to be per-row instead of per-cell
	//hoverByCell:true,
	
	// if canHover:true, should an active hover remain active until we leave the listGrid?
	// default behavior is to clear/deactivate the hover on each cellOut/rowOut
	//keepHoverActive:false,	

	// the space between the borders of the cell and the hover, in pixels
    cellHoverOutset:5,
    
    // Note: hoverWidth, hoverStyle, et al will be picked up by the grid renderer when showing 
    // cell hovers (handled by GridRenderer class)

    //> @attr listGrid.hoverStyle (CSSStyleName : "gridHover" : [IRWA])
    // Style to apply to hovers shown over this grid.
    // @see listGrid.showHover
    // @visibility external
    // @group hovers
    //<
    hoverStyle:"gridHover",

	// Selection
	// --------------------------------------------------------------------------------------------

	//>	@attr	listGrid.selection		(Selection : null : [RA])
	// The Selection object associated with the listGrid.
	// @group  selection
	// @visibility external
	//<

    //> @attr listGrid.selectionAppearance (SelectionAppearance : "rowStyle" : IR)
    // How selection of rows should be presented to the user.
    // <P>
    // If using "checkbox", see also +link{listGrid.checkboxField} for customization APIs.
    //
    // @group selection
    // @visibility external
    //<
    selectionAppearance: "rowStyle",

    //>	@attr	listGrid.selectionType		(SelectionStyle : null : [IRW])
	// Defines a listGrid's clickable-selection behavior. The selection appearance is governed
    // by +link{listGrid.selectionAppearance}. If selectionAppearance is "checkbox", this will
    // be "simple", otherwise, this will be "multiple".
	// 
    // @group	selection, appearance
	// @see type:SelectionStyle
	//      @visibility external
    // @example multipleSelect
	//<
    
	//>	@attr   listGrid.selectionProperty       (string : null : IRW)
	// If specified, the selection object for this list will use this property to mark records
	// as selected.  If null, a unique selection property will be generated automatically.
	// @group  selection, appearance
	//<    
	//selectionProperty:null,	

	//>	@attr	listGrid.canSelectCells (boolean : false : IRW)
	//  @group	selection
	//  If this property is true, users can select individual cells rather than entire rows
	//  at once.
	//<
	//canSelectCells:false,

	//>	@attr	listGrid.canDragSelect (boolean : false : IRW)
	//  If this property is true, users can drag the mouse to select several rows or cells.
	//  This is mutually exclusive with rearranging rows or cells by dragging.
	//  @group	selection
	//  @visibility	external
    //  @example dragListSelect
	//<
	//canDragSelect:false,
    
    //> @attr listGrid.showSelectionCanvas (boolean : null : IRWA)
    // If +link{listGrid.selectionType} is set to <code>"single"</code>, setting this property to
    // true means selection will be displayed to the user with the +link{listGrid.selectionCanvas} 
    // and +link{listGrid.selectionUnderCanvas} rather than using css styling.
    // @group rowEffects
    // @visibility selectionCanvas
    //<
    //showSelectionCanvas:null,
    
    //> @attr listGrid.selectionCanvas (autoChild : null : RA)
    // AutoChild created and embedded in the body if +link{listGrid.showSelectionCanvas} is true,
    // and +link{listGrid.selectionType} is <code>"single"</code>.
    // This autoChild canvas will be created and displayed above the selected record on every 
    // selection change. 
    // <P>
    // Note that the selectionCanvas has the following read-only attributes set:<br>
    // - <code>this.grid</code> - a pointer to the ListGrid showing the selectionCanvas<br>
    // - <code>this.record</code> - a pointer to the currently selected record object in the grid.
    // @group rowEffects
    // @visibility selectionCanvas
    //<

	//> @attr listGrid.selectionUnderCanvas (autoChild : null : RA)
    // AutoChild created and embedded in the body if +link{listGrid.showSelectionCanvas} is true,
    // and +link{listGrid.selectionType} is <code>"single"</code>.
    // displayed behind the current selected cell in the page's z-order, meaning it will only be
    // visible if the cell css styling is transparent. 
    // <P>
    // Note that the selectionUnderCanvas has the following read-only attributes set:<br>
    // - <code>this.grid</code> - a pointer to the ListGrid showing the selectionUnderCanvas<br>
    // - <code>this.record</code> - a pointer to the current selected record object in the grid.
    // @group rowEffects
    // @visibility selectionCanvas
    //<
    
    //> @attr listGrid.checkboxField (AutoChild : null : IR)
    // Returns the specially generated checkbox field used when +link{selectionAppearance} is
    // "checkbox".  Created via the +link{AutoChild} pattern so that
    // <code>checkboxFieldDefaults</code> and <code>checkboxFieldProperties</code> are available
    // for skinning purposes.
    // <P>
    // Note that the default appearance of the checkboxField is rendered via the
    // +link{listGridField.valueIcons} feature, where the data value of the field is considered to
    // be "true" for selected or "false" for not selected.  All properties that control the
    // appearance of <code>valueIcons</code>, such as +link{listGridField.valueIconWidth}, apply
    // for the appearance of the checkbox images shown for this field.
    // <P>
    // The icons used by default in the valueMap are +link{CheckboxItem.checkedImage} and 
    // +link{CheckboxItem.uncheckedImage}, and their sizes are obtained from 
    // +link{CheckboxItem.valueIconWidth} and +link{CheckboxItem.valueIconHeight}. 
    // These can be overriden by supplying a valueIcons array as shown:
    // <code><pre>
    // isc.ListGrid.create({
    //     ...
    //     checkboxFieldProperties: {
    //         valueIcons: {
    //            "true" : "path/trueImage.png",
    //            "false" : "path/falseImage.png"
    //         },
    //         valueIconWidth: 20,
    //         valueIconHeight: 20,
    //         width: 40
    //     }
    //     ...
    // })
    // </pre></code>
    // <P>
    // The checkboxField can be detected by calling +link{isCheckboxField()} on any ListGridField
    // object passed by event handlers.
    //
    // @group checkboxField
    // @visibility external
    //<
          
    //>Animation
    
    //> @attr listGrid.animateSelection (boolean : false : IRWA)
    // If +link{listGrid.showSelectionCanvas} is <code>true</code> setting this property to true
    // ensures that when the selection canvas is displayed it animates into view via an
    // +link{Canvas.animateShow()}.  Note that the animation effect may be customized via the
    // standard +link{Canvas.animateShowEffect}, +link{Canvas.animateShowTime} and 
    // +link{Canvas.animateShowAccelleration}.
    // @group rowEffects
    // @visibility selectionCanvas
    //<
    
    //> @attr listGrid.animateSelectionUnder (boolean : false : IRWA)
    // If +link{listGrid.showSelectionCanvas} is <code>true</code> setting this property to true
    // ensures that when the selectionUnder canvas is displayed it animates into view via an
    // +link{Canvas.animateShow()}. Note that the animation effect may be customized via the
    // standard +link{Canvas.animateShowEffect}, +link{Canvas.animateShowTime} and 
    // +link{Canvas.animateShowAccelleration}.
    // @group rowEffects
    // @visibility selectionCanvas
    //<
    
    //<Animation

	// Empty and loading messages
	// --------------------------------------------------------------------------------------------

    //>	@attr	listGrid.showEmptyMessage		(boolean : true : [IRW])
    // @include gridRenderer.showEmptyMessage
    // @example emptyGrid
    //<
	showEmptyMessage:true,
    
	//>	@attr	listGrid.emptyMessage		(string : "No items to show." : [IRW])
    // @include gridRenderer.emptyMessage
    // @example emptyGrid
	//<
	emptyMessage:"No items to show.",

	//>	@attr	listGrid.emptyMessageStyle		(CSSStyleName : "emptyMessage" : [IRW])
    // The CSS style name applied to the +link{emptyMessage} if displayed.
    // @group emptyMessage
    // @visibility external
	//<
	emptyMessageStyle:"emptyMessage",

	//>	@attr	listGrid.loadingDataMessage		(string : "Loading data..." : [IRW])
    // The string to display in the body of a listGrid while data is being loaded.
    // @see loadingDataMessageStyle
    // @group loadingDataMessage, i18nMessages
    // @visibility external    
	//<
    loadingDataMessage : "Loading data...",

    //>Offline
    offlineDataMessage : "Data is offline...",
    //<Offline

	//>	@attr	listGrid.loadingDataMessageStyle  (CSSStyleName : "loadingDataMessage" : [IRW])
    // The CSS style name applied to the loadingDataMessage string if displayed.
    // @group loadingDataMessage
    // @visibility external    
	//<
    loadingDataMessageStyle: "loadingDataMessage",

	//>	@attr	listGrid.loadingMessage		(string : "\&nbsp;" : IR)
    // If you have a databound listGrid and you scroll out of the currently loaded dataset, by
    // default you will see blank rows until the server returns the data for those rows.  The
    // loadingMessage attribute allows you to specify arbitrary html that will be shown in each
    // such "blank" record while the data for that record is loading.
    //
	// @group emptyMessage, i18nMessages
    // @visibility external
	//<
	loadingMessage:"&nbsp;",	

    //>Offline
    offlineMessage:"Record offline...",    
    //<Offline

    // Separator / Single Cell rows
    // ---------------------------------------------------------------------------------------

    //>@attr    listGrid.singleCellValueProperty    (string : "singleCellValue" : IRW)
    // If <code>record[this.singleCellValueProperty]</code> is set for some record, the 
    // record will be displayed as a single cell spanning every column in the grid, with 
    // contents set to the value of <code>record[this.singleCellValueProperty]</code>.
    // @visibility external
    //<
    singleCellValueProperty:"singleCellValue",

    //>@attr    listGrid.isSeparatorProperty    (string : "isSeparator" : IRW)
    // If <code>record[this.isSeparatorProperty]</code> is set for some record, the 
    // record will be displayed as a simple separator row.
    // @visibility external
    //<
    isSeparatorProperty:"isSeparator",
 
    // Filter Editor (aka QBE)   
    // ---------------------------------------------------------------------------------------

	//>@attr    listGrid.showFilterEditor    (boolean : null : IRW)
	//    Should this listGrid display a filter row.  If true, this ListGrid
	//    will be drawn with a single editable row, (separate from the body).  Values entered
	//    into this row are used as filter criteria to filter this List's data.
	//    
	//  @group filterEditor
	//  @visibility external
    //  @example filter
	//<
	//showFilterEditor:null
    
    filterEditorDefaults : { shouldPrint:false }, 

	//>@attr    listGrid.filterEditorHeight (number : 22 : IRW)
    // Height for the filterEditor, if shown.
	//    
	//  @group filterEditor
	//  @visibility external
	//<
    filterEditorHeight:22,

	// Editing
	// --------------------------------------------------------------------------------------------
	//> @attr	listGrid.canEdit		(boolean : null : [IRW])
	//      Can the user edit cells in this listGrid? Can be set for the listGrid, and overridden for 
	//      individual fields.<br>
	//      If 'canEdit' is false at the listGrid level, fields can never be edited - in this case
	//      the canEdit property on individual fields will be ignored.<br>
	//      If 'canEdit' is set to true at the listGrid level, setting the 'canEdit' property to
	//      false at the field level will prevent the field from being edited inline.<br>
	//      If 'canEdit' is not set at the listGrid level, setting 'canEdit' to true at the field 
	//      level enables the field to be edited inline.
	//      @visibility external
	//      @group  editing
	//      @see    startEditing()
    //      @see listGridField.canEdit
    //      @see listGrid.recordEditProperty
    //      @see listGrid.canEditCell()
	//      @see    fields
    //      @example editByRow
	//<
	//canEdit:null,

	//> @attr   listGrid.recordEditProperty    (string : "_canEdit" : [IRWA])
	// Property name on a record that should be checked to determine whether the record may be
	// edited.
	// <br>
	// This property is configurable to avoid possible collision with data values in record.
	// With the default setting of "_canEdit", a record can be set non-editable by ensuring
	// record._canEdit == false.
	// <br>
	// For controlling editability for the entire grid or for a field, set grid.canEdit or
	// field.canEdit.
	//
	//  @group  editing
	//  @see attr:listGrid.canEdit
	//  @see attr:listGridField.canEdit
    //  @see method:listGrid.canEditCell
	//  @visibility external
	//<
    recordEditProperty:"_canEdit",    

	// Name for property used by internal '_testRowEditData' method to track whether
	// records have been compared to edit-data in order to map rowNums to edit values.
	// Customizable, in case of collision with record data - but unlikely to be overridden.
    editValuesTestedProperty:"_editValuesTested",

	//>	@attr     listGrid.editByCell  (boolean : null : [IRW])
	//      Determines whether when the user edits a cell in this listGrid the entire row becomes
	//      editable, or just the cell that recieved the edit event.<br><br>
	//      No effect if this.canEdit is false or null.
	//  @group  editing
	//  @visibility external
	//  @see listGrid.canEdit
    //  @example editByCell
	//<

	//>	@attr     listGrid.saveByCell   (boolean : null : [IRW])
	// Whether edits should be saved whenever the user moves between cells in the current edit
	// row.
	// <P>
	// If unset, defaults to this.editByCell.
	// <P>
	// To avoid automatic saving entirely, set +link{autoSaveEdits}:false.
	//
	//  @group  editing
	//  @visibility external
	//  @see listGrid.editByCell
	//<
    
	//>	@attr     listGrid.validateByCell   (boolean : null : [IRW])
	// Whether client-side validation checks should be performed when the user moves between
	// cells in the current edit row.  If unset, defaults to +link{listGrid.editByCell}.<br>
    // Note that if false validation occurs on row-transition rather than cell transitions.
    // Validation also always occurs when a row is to be saved.
    // @group gridValidation
    // @visibility external
    // @see group:editing
    //<
    // Notes: 
    // - ValidateOnChange will disable all client side validation. Not currently exposed.
    // - autoValidate will disable validation on row-transitions, so validation will only
    //   occur on save attempts. Not currently exposed.
    
    
    //>	@attr     listGrid.autoValidate (boolean : true : [IRW])
    // If +link{listGrid.validateOnChange} is true, this property governs whether client side 
    // validation will occur when the user navigates away from a validated row (or if
    // +link{listGrid.validateByCell} is true, whenever the user changes edit cell.<br>
    // If set to false, validation will only occur on a save attempt.
    // @group gridValidation
    //<
    
    autoValidate:true,
    
    //> @attr   listGrid.validateOnChange    (boolean : null : [IRW])
    // If true, validation will be perfomed on each edited cell when each editor's 
    // "change" handler is fired.<br>
    // @see ListGridField.validateOnChange
    // @group gridValidation
    // @visibility external
    //<
    //validateOnChange:null
    
    //> @attr	listGrid.neverValidate (boolean : null : [IRWA])
	// If true, validation will not occur as a result of cell editing for this grid.
	//	@group	gridValidation
    // @visibility external
	//<
    //neverValidate:null,
    
    
    //> @attr listGrid.canRemoveRecords (boolean : false : IR)
    // If set, provide UI for the user to remove records from the grid. This is achieved by
    // rendering an additional field in the listGrid which, when clicked, will remove the
    // record associated with the clicked row.
    // <P>
    // By default the field will display the +link{listGrid.removeIcon} next to each record, and
    // will be rendered as the leftmost column. Two mechanisms exist to further modify this field:
    // <ul>
    // <li>To change the position of the remove-field, include an explicitly specified field with
    //     the attribute +link{isRemoveField,isRemoveField:true} set. This will then be used as
    //     the remove field instead of adding a field to the beginning of the set of columns.</li>
    // <li>Additional direct configuration of the remove field may be achieved by modifying
    //     +link{listGrid.removeFieldProperties}.</li>
    // </ul>
    // <P>
    // If the grid has a DataSource, removal is accomplished via a DSRequest with operationType
    // "remove".  For a grid with simple Array data, the Array is directly modified.
    // @visibility external
    //<

    //> @attr listGrid.removeIcon (SCImgURL : "[SKIN]/actions/remove.png" : IR)
    // When +link{ListGrid.canRemoveRecords} is enabled, default icon to show in
    // the auto-generated field that allows removing records.
    // @visibility external
    //<
    removeIcon:"[SKIN]/actions/remove.png",
    
    //> @attr listGrid.animateRemoveRecord (boolean : true : IRW)
    // When +link{ListGrid.canRemoveRecords} is enabled, should records be animated out of view
    // when they are removed by the user? 
    // @visibility external
    //<
    // When showing alternate records styles, the styles will essentially be reassigned after the
    // animation completes which means we finish our smooth animation with what looks a little like
    // a jump - not clear how to avoid this, but we could warn about this in the attribute
    // description.
    animateRemoveRecord:true,
    
    //> @attr listGrid.animateRemoveTime (number : 100 : IRW)
    // When animating record removal 
    // +link{listGrid.animateRemoveRecord,(see animateRemoveRecord)}, if 
    // +link{listGrid.animateRemoveSpeed} is not
    // set, this property designates the duration of the animation in ms.
    // @group animation
    // @visibility animation
    // @see listGrid.animateRemoveRecord
    //<
    animateRemoveTime:100,

    //> @attr listGridGrid.animateRemoveSpeed (number : 200 : IRW)
    // When +link{listGrid.animateRemoveRecord, animating record removal}, this property 
    // designates the speed of the animation in pixels per second. Takes presidence over the
    // +link{listGrid.animateRemoveTime} property, which allows the developer to specify a
    // duration for the animation rather than a speed.
    // @group animation
    // @visibility animation
    // @see listGrid.animateRemoveRecord
    //<    
    animateRemoveSpeed:200,
    
    //> @attr listGrid.removeSummaryTitle (string "[Remove Record]" : IRW)
    // When +link{canRemoveRecords} is true, this attribute may be used to customize the
    // +link{ListGrid.getSummaryTitle(),summary title} for the special "remove" field.
    // @see ListGrid.getRemoveSummaryTitle()
    // @group i18nMessages
    // @visibility external
    //<  
    removeSummaryTitle:"[Remove Record]",
    
    //> @attr listGrid.removeFieldDefaults (ListGridField properties : {...} : IR)
    // Default configuration properties for the "remove field" displayed when
    // +link{ListGrid.canRemoveRecords} is enabled. +link{isc.changeDefaults()} should be used
    // when modifying this object.
    // @visibility external
    //<
    removeFieldDefaults:{
        type:"icon",
        width:20,
        showHeaderContextMenuButton:false,
        canEdit:false,
        canSort:false,
        canGroupBy:false,
        canFilter:false,
        // cellIcon will be set up on the fly to match listGrid.removeIcon
        recordClick : function (viewer,record, rowNum) {
            viewer._removeRecordClick(rowNum, record);
            return false;
        }
    },
    
    //> @attr listGrid.removeFieldProperties (ListGridField properties : null : IR)
    // Configuration properties for the "remove field" displayed when
    // +link{ListGrid.canRemoveRecords} is enabled.
    // @visibility external
    //<


	//>	@attr     listGrid.filterByCell   (boolean : null : [IRWA])
	// If we're showing the filterEditor (this.showFilterEditor is true), this property 
	// determines whether this list should be filtered every time the user puts focus in
	// a different field in the filter editor.
	// @group filterEditor
	// @visibility external
	//<
	
	//>	@attr     listGrid.filterOnKeypress   (boolean : null : [IRWA])
	// If we're showing the filterEditor (this.showFilterEditor is true), this property 
	// determines whether this list should be filtered every time the user modifies the value
    // in a field of the filter-editor. Can also be set at the field level.
	// @group filterEditor
	// @visibility external
	//<
    
	//> @attr	listGrid.waitForSave (boolean : false : [IRWA])
	// If this is an editable listGrid, this property determines whether the user will be
	// able to dismiss the edit form, or navigate to another cell while the save is in 
	// process (before the asynchronous server response returns).
	//	@group	editing
	// @visibility external
	//<
	//waitForSave:false,

	//> @attr	listGrid.stopOnErrors (boolean : false : [IRWA])
	// If this is an editable listGrid, this property determines how failure to save due to 
	// validation errors should be displayed to the user.
	// <P>
	// If this property is true, when validation errors occur the errors will be displayed
	// to the user in an alert, and focus will be returned to the first cell to fail validation.
	// <P>
	// If false, this the cells that failed validation will be silently styled with the 
	// editFailedBaseStyle.<br>
	// <b>Note:</b> stopOnErrors being set to true implies that 'waitForSave' is also true.
	// We will not dismiss the editor until save has completed if stopOnErrors is true.
	//
	//  @visibility external
	//	@group	editing
	//  @see    waitForSave
	//<
	//stopOnErrors:false,

    //> @attr	listGrid.autoSaveEdits (boolean : true : [IRWA])
    // If this ListGrid is editable, should edits be saved out when the user finishes editing
    // a row (or a cell if +link{ListGrid.saveByCell} is true).
    // <P>
    // The default of <code>true</code> indicates that edits will be
    // +link{saveByCell,automatically saved} as the
    // user navigates through the grid and/or +link{enterKeyEditAction,hits 'Enter'} to end
    // editing.  See the +link{group:editing,Grid Editing} overview for details. 
    // <P>
    // Setting <code>autoSaveEdits</code> false creates a "mass update" / "mass delete"
    // interaction where edits will be retained for all edited cells (across rows if
    // appropriate) until +link{saveEdits()} is called to save a particular row, or
    // +link{saveAllEdits()} is called to save all changes in a batch.
    //
    // @group editing
    // @visibility external
    //<
    autoSaveEdits:true,
    
    // ListGrid validation error icon. Very similar API to the FormItem class validation error 
    // icon.
    
    //> @attr   ListGrid.showErrorIcons (boolean : true : IRW)
    //  If this grid is editable, and an edit has caused validation failure for some cell,
    //  should we show an icon to indicate validation failure?
    //  @group  errorIcon
    //  @visibility internal
    //<
    showErrorIcons : true,
    
    //> @attr   ListGrid.errorIconHeight    (number : 16 : IRW)
    //      Height of the error icon, if we're showing icons when validation errors occur.
    //  @group  errorIcon
    //  @visibility internal
    //<
    errorIconHeight : 16,
    
    //> @attr   ListGrid.errorIconWidth    (number : 16 : IRW)
    //      Height of the error icon, if we're showing icons when validation errors occur.
    //  @group  errorIcon
    //  @visibility internal
    //<    
    errorIconWidth : 16,
    
    //> @attr   ListGrid.errorIconSrc    (SCImgURL : "[SKIN]/ListGrid/validation_error_icon.png" : IRW)
    //      Src of the image to show as an error icon, if we're showing icons when validation
    //      errors occur.
    //  @group  errorIcon
    //  @visibility internal
    //<    
    errorIconSrc : "[SKIN]/validation_error_icon.png",    
        
	//> @attr	listGrid.confirmCancelEditing (boolean : false : [IRW])
	// If this is an editable listGrid, when the user attempts to cancel an edit, should we
    // display a confirmation prompt before discarding the edited values for the record?
	//
	//  @visibility external
	//	@group	editing
	//<
	//confirmCancelEditing:false,

	//> @attr	listGrid.cancelEditingConfirmationMessage (string : Cancelling this edit will clear unsaved edit values for this record. Continue? : [IRW])
	// If this is an editable listGrid, and <code>this.confirmCancelEditing</code> is true
    // this property is used as the message to display in the confirmation dismissal prompt.
    //
	//  @visibility external
	//	@group	editing, i18nMessages
	//<
	cancelEditingConfirmationMessage:"Cancelling this edit will clear unsaved edit values for this record. Continue?",

    //> @attr	listGrid.confirmDiscardEdits (boolean : true : [IRW])
	// For editable listGrids, outstanding unsaved edits when the user performs a new filter
    // or sort will be discarded. This flag determines whether we should display a confirmation
    // dialog with options to save or discard the edits, or cancel the action in this case.
	//
	//  @visibility external
	//	@group	editing
	//<
	confirmDiscardEdits:true,
    
	//> @attr	listGrid.confirmDiscardEditsMessage (string : "This action will discard all unsaved edited values for this list.": [IRW])
	// If <code>this.confirmDiscardEdits</code> is true, this property can be used to customize the
    // error message string displayed to the user in a dialog with options to 
    // cancel the action, or save or discard pending edits in response to sort/filter actions
    // that would otherwise drop unsaved edit values.
	// @visibility external
	// @group editing, i18nMessages
	//<
	confirmDiscardEditsMessage:"This action will discard all unsaved edited values for this list.",

    //> @attr listGrid.discardEditsSaveButtonTitle (string :"Save" : IRW)
    // If +link{listGrid.confirmDiscardEdits} is true this is the title for the save button
    // appearing in the lost edits confirmation dialog. Override this for localization if necessary.
    // @visibility external
    // @group editing, i18nMessages
    //<
    discardEditsSaveButtonTitle:"Save",
    
	//> @attr	listGrid.addNewBeforeEditing (boolean : false : IRWA)
	// When creating a new edit record via 'startEditingNew()' [or tabbing beyond the end
	// of the last editable field in a list], should we contact the server to create a
	// server-side record before editing begins?
	// @group	editing
	// @visibility advancedInlineEdit
	//<
	//addNewBeforeEditing:false,

	//> @attr	listGrid.rowEndEditAction (RowEndEditAction : "next" : IRW)
	// If the user is editing a record in this listGrid, and attempts to navigate to a field
	// beyond the end of the row, via tab (or shift-tab off the first editable field), this 
	// property determines what action to take:<ul>
	// <li>"next": start editing the next (or previous) record in the list
	// <li>"same": put focus back into the first editable field of the same record.
	// <li>"done": hide the editor
	// <li>"stop": leave focus in the cell being edited
	// </ul>
	//	@group	editing
	// @visibility external
	//<                                            
    rowEndEditAction:"next",

	//> @attr	listGrid.listEndEditAction (RowEndEditAction : "stop" : IRW)
	// If the user is editing the last record in this listGrid, and attempts to navigate 
	// beyond the last row either by tabbing off the last editable field, or using the down
	// arrow key, this property determines what action to take:<ul>
	// <li>"next": start editing a new record at the end of the list.
	// <li>"done": hide the editor
	// <li>"stop": leave focus in the cell being edited
	// </ul>
	//	@group	editing
	// @visibility external
    // @example enterNewRows
	//<     
	
    listEndEditAction:"stop",
    
    //>@attr    listGrid.showNewRecordRow  (boolean    : null  : [IRW])
    // If this is an editable ListGrid, this property determines whether an extra row should
    // be displayed below the last record, which can be used to add a new record to the dataset
    //<
    
	//>	@attr	listGrid.newRecordRowMessage    (string : "-- Add New Row --" : IR)
    // If this listGrid is showing the 'newRecordRow' (used for adding new rows to the end
    // of the data), this property determines what message should be displayed in this row.
    // @group editing, i18nMessages
    //<
    newRecordRowMessage:"-- Add New Row --",
    
	//> @attr	listGrid.enterKeyEditAction (EnterKeyEditAction : "done" : IRW)
	// What to do when a user hits enter while editing a cell:
    // <ul>
	// <li>"nextCell": start editing the next editable cell in this record (or the first
	//     editable cell in the next record if focus is in the last editable cell in the row)
	// <li>"nextRow": start editing the same field in the next row (skipping any rows where
	//      that would be a non-editable cell.
	// <li>"nextRowStart": start editing the first editable cell in the next row.
	// <li>"done": hide the editor (editing is complete)
    // </ul>
    // Note that if this.autoSaveEdits is true, this may cause a save of the current edit values
	// @group	editing
	// @visibility external
	//<
    enterKeyEditAction:"done",
    
    //> @attr	listGrid.escapeKeyEditAction (EscapeKeyEditAction : "cancel" : IRW)
    // What to do when a user hits escape while editing a cell:<ul>
    // <li>"cancel": close the editor and discard the current set of edit values
    // <li>"done": just close the editor (the edit is complete, but the edited values are retained).
    // </ul>
    // Note that if +link{autoSaveEdits} is true, this may cause a save of the current edit values
    // @group editing
    // @visibility external
    //<
    escapeKeyEditAction:"cancel",
    
	//> @type ListGridEditEvent	
    // Event that will trigger inline editing.
    //
    // @value "click"       A single mouse click triggers inline editing
    // @value "doubleClick" A double click triggers inline editing
    // @value "none"        No mouse event will trigger editing.  Editing must be
    //                      programmatically started via +link{listGrid.startEditing()}
    //                      (perhaps from an external button) or may be triggered by 
    //                      keyboard navigation if +link{listGrid.editOnFocus} is set.
    //
	// @group editing
	// @visibility external
    //<

	//> @attr	listGrid.editEvent	(ListGridEditEvent : "doubleClick" : IRW)
    // Event that will trigger inline editing, see +link{type:ListGridEditEvent} for options.
    // <P>
    // Note this setting has no effect unless +link{canEdit} has been set to enable editing.
    // <P>
    // See also +link{editOnFocus} and +link{startEditing}.
    //
	// @group editing
	// @visibility external
    // @example editByRow
	//<
	editEvent:isc.EH.DOUBLE_CLICK,

	//> @attr   listGrid.editOnFocus (boolean : null : [IRWA])
	// Should we start editing when this widget recieves focus (if this ListGrid supports
	// editing)?
    // <P>
	// Note that this property being set to true will cause editing to occur on a single
	// click, even if +link{editEvent} is <code>"doubleClick"</code>, because single clicking
    // the grid will place keyboard focus there automatically.
    //
	// @group editing
	// @visibility external
	//<
	// Note - editOnFocus behavior is slightly more complicated than might be imagined. Actual
	// behavior:
	// - focus must go to the body (not the header) to start editing.
	// - if we are currently editing, getting focus will not trigger a new edit.
	// - if the focus is a result of clicking on the listGrid body, we will only start editing
	//   if the user clicked on an editable cell -- this is the same behavior as with 
	//   editEvent:"click"
	// - otherwise when this widget recieves focus, the first editable row will become editable.
    
    
	//> @attr   listGrid.editOnKeyPress (boolean : null : [IRWA])
	// If set to true, when this grid has focus, if the user starts typing character keys
    // we'll start editing the focussed cell.
    // @group editing
	// @visibility internal
	//<
    
    //>@attr   listGrid.moveEditorOnArrow (boolean : null : [IRWA])
	// If +link{listGrid.editOnKeyPress, editOnKeyPress} is true, once the user starts editing
    // a cell by typing while focussed in it, should left / right arrow keys cause the 
    // edit cell to shift horizontally?
    // @group editing
	// @visibility internal
	//< 
    
    	        
    //> @attr   listGrid.selectOnEdit (boolean : true : [IRWA])
    //  When the user starts editing a row, should the data in that row also be selected?
    // @group editing
    // @visibility external
    //<
    selectOnEdit : true,
    
    //>@attr    listGridField.canToggle (boolean : null : IRWA)
    // Allows a boolean or +link{valueMap,valueMapped} field to be edited by simply clicking on
    // it to cycle values.
    // <P>
    // To enable this feature, +link{listGrid.canEdit} must be set to true.  Note that you can
    // enable toggling only (without allowing the user to edit other fields) by just setting
    // +link{listGrid.editEvent,grid.editEvent:"none"}.
    // <P>
    // If +link{listGrid.editEvent} is set to "click", when the user clicks on the field, 
    // the value will be toggled, and inline editing will be triggered as usual.
    // Otherwise the toggled value will be saved immediately to the server, or if 
    // +link{listGrid.autoSaveEdits} has been set to false, will be stored as an edit value
    // for the record.
    //
    // @group editing
    // @visibility external
    //<
    // The main purpose of this is to simplify cases where we have a limited set of values
    // displayed as icons (such as checkboxes, etc), and the user wants to just click the field
    // to go through the options.
    // If this.autoSaveEdits is true we'll save the edit automatically, otherwise hang onto it
    // as an edit value.
    
    
    //> listGrid.enumCriteriaAsInitialValues (boolean : true : IR)
    // In a ListGrid that has a DataSource and has filter criteria that include values for
    // fields declared as +link{DSFieldType,type "enum"} in the DataSource, by default a newly
    // edited row will use those filter criteria as initial values.
    // <P>
    // For example, if a ListGrid is showing all Accounts that have status:"Active" and a new row
    // is created, the new row will default to status:"Active" unless this flag is set to false.
    //
    // @group editing
    // @visibility external
    //<
    enumCriteriaAsInitialValues:true,
	
	//> @attr	listGrid.saveOperation (operation : null : IRW)
	//		Operation to use when saving edited values in a databound ListGrid
	//	@group	editing
	//<

	//> @attr	listGrid.application (application : null : IRW)
	//		Application to use when saving edited values in a databound ListGrid
	//	@group	editing
	//<

	//> @type   AutoComplete
	// Possible autoComplete modes.
	//
	// @value   "smart"    Enable SmartClient autoComplete feature.  Suppresses browser's
	//                     built-in autoComplete feature where applicable.
	// @value   "native"   Allow browser's built-in autoComplete feature to function
	// @value   "none"     Suppress brower's built-in autoComplete feature
	// @group autoComplete
	// @visibility autoComplete
	//<

	//>	@attr	listGrid.autoComplete   (AutoComplete : null : IRW)
	// Whether to do inline autoComplete in text fields during inline editing<br>
    // Overridden by +link{ListGridField.autoComplete} if specified.
    // If unset picks up the default from the appropriate editor class (subclass of FormItem).
    // 
	// @see listGridField.autoComplete
	// @group autoComplete
	// @visibility autoComplete
	//<
    //autoComplete:null,

	//>	@attr	listGrid.uniqueMatch    (boolean : true : IRW)
	// When SmartClient autoComplete is enabled, whether to offer only unique matches to the
	// user.
	// <p>
	// Can be individually enabled per TextItem, or if set for the grid as a whole, can
	// be set differently for individual fields.
	//
	// @see listGridField.uniqueMatch
	// @group autoComplete
	// @visibility autoComplete
	//<

    // autoSelectEditors - if true when the user starts editing a cell always select the content
    // of the cell
    autoSelectEditors:true,
	// defaults for the form used for inline editing
    editFormDefaults: {
    	
        canSelectText:true,
        autoDraw:false,
        
        // show error icons on the left by default
        errorOrientation:"left",
        showErrorText:false,
        showErrorStyle:false,
        
        itemKeyPress:function (item, keyName, characterValue) {
            return this.grid.editorKeyPress(item, keyName, characterValue);
        }
    }, 
    
    //> @attr listGrid.longTextEditorThreshold (integer : 255 : IRW) 
    // When the length of the field specified by +link{attr:dataSourceField.length} exceeds this
    // value, the ListGrid shows an edit field of type +link{attr:listGrid.longTextEditorType}
    // rather than the standard text field when the field enters inline edit mode.
    //
    // @group editing
    // @visibility external
    //<
    longTextEditorThreshold : 255,
    
    //> @attr listGrid.longTextEditorType (string : "PopUpTextAreaItem" : IRW) 
    // When the length of the field specified by +link{attr:dataSourceField.length} exceeds 
    // <code>this.longTextEditorThreshold</code> show an edit field of this type
    // rather than the standard text field when the field enters inline edit mode.
    //
    // @group editing
    // @visibility external
    //<
    longTextEditorType : "PopUpTextAreaItem",
    
	// functions installed into FormItems used for inline editing.  
	// Note - these will be executed in the scope of the form item (not in the scope of the
	// ListGrid).
	//
	// Set up keyboard handling on form items to handle user navigation via "Enter", "Escape",
	// "Tab" keypresses, etc.
    //
	// NOTE: in Moz, if the user is holding down tab and we are cancelling the field change
	// *while logging to an open Log window*, we'll be stuck in the field indefinitely.  This
	// is probably a non-bug but can look like a freeze.
	//
	// row editing: Cancel tab to prevent focus cycling through the visible form items, since
	// for the first/last editable or visible item, we want to place focus in newly drawn
	// editors (on next/previous row, or just in newly drawn area that we scrolled into)
    editorKeyDown : function (item, keyName) {
        // In Safari 3.1 on Windows and Mac (both 525.13), to cancel navigation on tab you have to
        // return false from keyDown not keyPress.
        // This does not prevent keyPress from firing.
        // Therefore in this browser always return false from keyDown if it's a tab keypress
        if (isc.Browser.isSafari && isc.Browser.safariVersion >= 525.13 && keyName == "Tab") {
            return false;
        }
    },

    editorKeyPress : function (item, keyName, characterValue) {

    	// We will return false to cancel native behavior on any key event for the keys
    	// used for navigating around the edit cells (arrow keys, tab, etc.)
        var EH = isc.EH,
            returnValue,
            editEvent;        

        if (keyName == "Tab") {
        	// Always cancel the native event that would take focus from this item.
        	// This is appropriate as we will always focus in the next item programmatically, 
        	// even if we are currently showing the entire edit row.
        	
            var shift = EH.shiftKeyDown();
                
            // If this is a container item, with sub items, or has a number of focusable
            // icons, we may be moving focus within the item, rather than going to another
            // edit cell.  This is handled by _moveFocusWithinItem().
            if (this.ns.isA.ContainerItem(item) || 
                (item.icons != null && item.icons.length > 0 
                    // If the event occurred on a PopUpTextAreaItem, native focus is either 
                    // on the icon, or within the TextArea in another form.
                    // In this case we always navigate to the next cell
                    && !this.ns.isA.PopUpTextAreaItem(item))
               ) 
            {
                if (!this._moveFocusWithinItem(item, shift)) {
                    return false;
                }
            }
            
            editEvent = shift ? isc.ListGrid.SHIFT_TAB_KEYPRESS 
                                            : isc.ListGrid.TAB_KEYPRESS;
            returnValue = false;
                    
        } else if (keyName == "Enter") {
        	// If the event occurred over an icon, we don't want to interfere with it, as
        	// enter will activate the link (for accessibility)
            if (item.getFocusIconIndex() != null) return;
            
            // allow enter to work normally for text areas.  Alt + Enter overrides.
            if ((    //>PopUpTextAreaItem
                    isc.isA.PopUpTextAreaItem(item) ||     //<PopUpTextAreaItem
                    isc.isA.TextAreaItem(item)) && 
                    isc.EH.altKeyDown() == false) 
            {
                return returnValue;
            }
            editEvent = isc.ListGrid.ENTER_KEYPRESS;
            returnValue = false;

        } else if (keyName == "Escape") {
            editEvent = isc.ListGrid.ESCAPE_KEYPRESS;
            returnValue = false;
            
        // By default move to a new row in response to
        //  - arrow keypress (up / down)
        //  - ctrl + arrow keypress (up / down), but not if the shift key is also down
        // Exceptions:
        //  - Text area use alt+arrowKeypress only
        //  - explicitly avoid row change on alt+arrow key in SelectItem, where this is used
        //    to show / hide the pickList
        //
        
        } else if (keyName == "Arrow_Up") {
            var textArea =  //>PopUpTextAreaItem
                            isc.isA.PopUpTextAreaItem(item) || //<PopUpTextAreaItem
                            isc.isA.TextAreaItem(item);
            if (textArea && !isc.EH.altKeyDown()) return returnValue;
            
            if (isc.isA.SelectItem(item) && !isc.EH.ctrlKeyDown()) return returnValue;
            
            if (isc.EH.ctrlKeyDown() && isc.EH.shiftKeyDown()) return returnValue;
            editEvent = isc.ListGrid.UP_ARROW_KEYPRESS;
            returnValue = false;

        } else if (keyName == "Arrow_Down") {

            var textArea =  //>PopUpTextAreaItem
                            isc.isA.PopUpTextAreaItem(item) || //<PopUpTextAreaItem
                            isc.isA.TextAreaItem(item);
            if (textArea && !isc.EH.altKeyDown()) return returnValue;
            
            if (isc.isA.SelectItem(item) && !isc.EH.ctrlKeyDown()) return returnValue;
            
            if (isc.EH.ctrlKeyDown && isc.EH.shiftKeyDown()) return returnValue;
            
            editEvent = isc.ListGrid.DOWN_ARROW_KEYPRESS;
            returnValue = false;
            
        // if the user started editing via editOnKeyPress and the 'moveEditorOnArrow' flag is true
        // we shift cells on left/right arrow
        } else if (this.moveEditorOnArrow && this._editSessionFromKeyPress) {
            if (keyName == "Arrow_Left") {
                editEvent = isc.ListGrid.LEFT_ARROW_KEYPRESS;
                returnValue = false;
            } else if (keyName == "Arrow_Right") {
                editEvent = isc.ListGrid.RIGHT_ARROW_KEYPRESS;
                returnValue = false;            
            }
        }
        
        if (editEvent != null) {
            
            if (isc.EH.clickMaskUp()) {
                isc.EH.setMaskedFocusCanvas(null, isc.EH.clickMaskRegistry.last());
            }
    
            // Fire cellEditEnd to handle saving out the value / moving to the next cell as 
            // appropriate
            this.cellEditEnd(editEvent);
        }        
        return returnValue;            
    },

    // _moveFocusWithinItem() Helper method fired when the user hits tab / shift+tab while
    // focussed in some edit item. This will move focus to the appropriate icon or sub item
    // if necessary.  A return value of false indicates focus was moved within the item, so
    // should not move to another edit cell.
    _moveFocusWithinItem : function (item, shift) {
        
        if (!item) return true;
        return (!item._moveFocusWithinItem(!shift));
    },

	// Override elementFocus on the form items:
	// If we're editing the whole row, and the user clicks in a new field to focus in it,
	// call 'editCellEnd' method to perform validation / saving on the previous
	// edit field (if required).
	
    _editFormItem_elementFocus : function (suppressHandlers) {
    	

        var form = this.form,
            lg = form.grid;
    	    
        
        var rowNum, colNum, fieldName, fieldChanged;
        if (lg._editorShowing && !suppressHandlers) {
            rowNum = lg._editRowNum;
            if (!lg.editByCell) {
                rowNum = lg._editRowNum;
                fieldName = this.getFieldName(),
                colNum = lg.fields.findIndex(lg.fieldIdProperty, fieldName);
                
                fieldChanged = (lg._editColNum != colNum);
            	// If the user has clicked in another field in the edit form, fire editField on
            	// the appropriate field
                if (fieldChanged) {
                	// store the new edit cell
                    lg.setNewEditCell(rowNum, colNum);
                	// fire 'cellEditEnd' to save / validate before moving to the new cell
                    lg.cellEditEnd(isc.ListGrid.EDIT_FIELD_CHANGE);
                    
                	// Note - if we could cancel the focus here, it might make sense, as the 
                	// cellEditEnd callback method will re-focus in the new focus cell, but we can't
                	// cancel the focus by simply returning false from this method.
                	// Therefore allow the focus to proceed, and fall through to the super 
                	// implementation of this method which will fire focus handlers, show any
                	// 'showOnFocus' icons, etc.
                }
            } else {
                colNum = lg._editColNum;         
            }
        }
        this.Super("elementFocus", arguments);
        
        if (lg._editorShowing) {
        	// If this is the current edit field, and hasn't yet fired its 'editorEnter' handlers
        	// fire them now.
            var rowEnter = this._rowEnterOnFocus,
                cellEnter = this._cellEnterOnFocus;
            // Note: we're clearing out the flags before we fire the handlers. If the
            // handler trips a change of edit row, etc., we want editorExit to fire.
            delete this._rowEnterOnFocus;
            delete this._cellEnterOnFocus;
            
                   
            if (cellEnter) lg._handleEditorEnter(this, rowNum, colNum, 
                                                    lg._getEditValue(rowNum, colNum));
            if (rowEnter) lg._handleRowEditorEnter(this, rowNum, 
                                                     lg._getEditValues(rowNum, colNum));

        } else {
            lg.logWarn("suppressing editorEnter handlers on focus as listGrid._editorShowing is null");
        }
    },
    
	// Header
	// ----------------------------------------------------------------------------------------

    //> @groupDef gridHeader
    // Properties and methods related to the ListGrid header. ListGrid headers are implemented
    // as a +link{class:Toolbar} of buttons shown at the top of the ListGrid 
    // (one button per column).<br>
    // The toolbar header provides UI for interacting with the ListGrid fields directly (sorting,
    // resizing, reordering columns, etc).
    // @visibility external
    //<
        
    //> @attr listGrid.header (AutoChild : null : R)
    // A Toolbar used to manager the headers shown for each column of the grid.
    // @group gridHeader
    // @visibility external
    //<
    
	//>	@attr   listGrid.canTabToHeader   (boolean : false : RW)
	//      Should the header be included in the tab-order for the page
    //      @group  gridHeader, focus
	//<
	// See comments by _setTabIndex() for how listGrids handle tab-index manipulation
	//canTabToHeader:false,
    
	//>	@attr	listGrid.headerHeight		(number : 22 : [IRW])
	//          The height of this listGrid's header, in pixels.
    //      @setter listGrid.setHeaderHeight()
	//      @visibility external
	//      @group  gridHeader, sizing
	//<
    // Note: we treat a headerHeight of zero as an equivalent of showHeader:false
	headerHeight:22,

	//>	@attr	listGrid.showHeader     (boolean: true : [IRW])
	// Should we show the header for this ListGrid?
    // @group gridHeader, appearance
	// @visibility external
	//<
	showHeader:true,

	//>	@attr	listGrid.headerBarStyle (CSSStyleName : null : IR)
	// Set the CSS style used for the header as a whole.
	// @group	gridHeader, appearance
    // @visibility external
	//<
    //headerBarStyle:null,
    
    //>	@attr	listGrid.headerBackgroundColor	(color : "#CCCCCC" : IRW)
	// BackgroundColor for the header toolbar. Typically this is set to match the color
    // of the header buttons.
	//		@group	gridHeader, appearance
    // @visibility external
	//<
	headerBackgroundColor:"#CCCCCC",		
 
    headerDefaults : {
        // immediately reposition headers during drag resizing, don't delay
        instantRelayout:true,
        // when the user resizes buttons, don't try to fit them into the available space -
        // allow the user to introduce hscrolling
        enforcePolicy:false, 

        // when the header is clicked, have it call headerClick() on us
		itemClick : function (button, buttonNum) {
			this.Super("itemClick",arguments);
		    this.grid.headerClick(buttonNum, this);
		},

        showContextMenu : function () {
            return this.grid.headerBarContextClick(this);
        },

		backgroundRepeat:isc.Canvas.NO_REPEAT,
        
        // don't print the header, we handle this as part of the body instead, to ensure column
        // alignment
        shouldPrint:false
    },
    
    //> @attr   listGrid.headerButtonConstructor (Class : null : IR)
    // Widget class for this ListGrid's header buttons. If unset constructor will be 
    // picked up directly standard +link{class:Toolbar} button constructor.
	// @group	gridHeader, appearance
    // @visibility external
    //<
    
    //>	@attr	listGrid.headerBaseStyle (CSSStyleName : null : IR)
	// +link{Button.baseStyle} to apply to the buttons in the header, and the sorter, for 
    // this ListGrid.
    // Note that depending on the +link{listGrid.headerButtonConstructor, Class} of the header
    // buttons you may also need to set +link{listGrid.headerTitleStyle}.
	// @group	gridHeader, appearance
    // @visibility external
	//<
    
    //> @attr listGrid.headerTitleStyle (CSSStyleName : null : IR) 
    // +link{StretchImgButton.titleStyle} to apply to the buttons in the header, and the sorter,
    // for this ListGrid.
    // Note that this will typically only have an effect if 
    // +link{listGrid.headerButtonConstructor} is set to +link{class:StretchImgButton} or a subclass 
    // thereof.
	// @group	gridHeader, appearance
    // @visibility external
	//<
    
	//>	@attr	listGrid.frozenHeaderBaseStyle (CSSStyleName : null : IR)
    // If this listGrid contains any frozen fields, this property can be used to apply a custom
    // headerBaseStyle to the frozen fields set of fields. If unset, the standard headerBaseStyle
    // will be used for both frozen and unfrozen cells.
    // @visibility external
    // @group gridHeader, appearance, frozenFields
    // @see listGrid.headerBaseStyle
    // @see listGridField.frozen
    //<
    
    //>	@attr	listGrid.frozenHeaderTitleStyle (CSSStyleName : null : IR)
    // If this listGrid contains any frozen fields, this property can be used to apply a custom
    // headerTitleStyle to the frozen fields set of fields. If unset, the standard headerTitleStyle
    // will be used for both frozen and unfrozen cells.
    // @visibility external
    // @group gridHeader, appearance, frozenFields
    // @see listGrid.headerTitleStyle
    // @see listGridField.frozen
    //<
    

    //>	@attr	listGrid.headerButtonDefaults		(Button Properties: {...} : IRA)
	// Defaults to apply to all header buttons. To modify this object, 
    // use +link{class.changeDefaults(), ListGrid.changeDefaults()} 
    // rather than replacing with an entirely new object.
	// @group	gridHeader, appearance
    // @visibility external
	//<
	headerButtonDefaults:{
        dragScrollType:"parentsOnly",
		minWidth:20
	},										

	//>	@attr	listGrid.headerButtonProperties (Button Properties: null : IRA)
	// Properties to apply to all header buttons.
    // Overrides defaults applied via  +link{ListGrid.headerButtonDefaults}.
    // @group	gridHeader, appearance
    // @visibility external
	//<
    
    //> @attr listGrid.sorterConstructor (Class : Button : IR)
    // Widget class for the corner sort button, if showing. For consistent appearance, this
    // is usually set to match +link{listGrid.headerButtonConstructor}
    // @group	gridHeader, appearance
    // @visibility external
    //<
    sorterConstructor:isc.Button,
    
    
    //> @attr   listGrid.sorterDefaults     (object : {...} : IRA)
    // Defaults to apply to the corner sort button. To modify this object, use
    // +link{Class.changeDefaults(), ListGrid.changeDefaults()} rather than replacing with an
    // entirely new object.
    // @group gridHeader, appearance
    // @visibility external
    //<
    sorterDefaults:{
        _redrawWithParent:false,
        getTitle : function () {return this.parentElement.getSortArrowImage() },
        click : function () { return this.parentElement.sorterClick() },
        showContextMenu : function() { return this.parentElement.sorterContextClick() },
        canFocus:false  // no need to focus, since we allow focus-ing on the header buttons
    },
    
	//>	@attr listGrid.sorterProperties (Button Properties: null : IRA)
	// Properties to apply to the sorter button. Overrides defaults applied via 
    // +link{ListGrid.sorterDefaults}.
    // @group	gridHeader, appearance
    // @visibility external
	//<
    
	// Sorting
	// --------------------------------------------------------------------------------------------
	
	//>	@attr	listGrid.canSort		(boolean : true : [IRW])
	//          Enables or disables interactive sorting behavior for this listGrid. Does not
	//          affect sorting by direct calls to the sort method.
	//      @visibility external
	//      @group  sorting
	//<
	canSort:true,
    
	//>	@attr	listGrid.sortFieldNum		(number : null : [IRW])
	//          Specifies the number of the field by which to sort this listGrid. Column numbers
	//          start at 0 for the left-most column.
	//      @visibility external
	//      @group  sorting
    //      @example sort
    // @deprecated as of version 7.0 in favor of +link{listGrid.sortField}
	//<
	//sortFieldNum:null,
    
    
    //> @attr listGrid.sortField (String or integer : null : IR)
    // Specifies the field by which this grid should be initially sorted.  Can be set to either a
    // +link{listGridField.name,field name} or the index of the field in the fields Array. Note that
    // if <code>sortField</code> is initally specified as a number, it will be converted to a
    // string (field name) after list grid initialization.
    // <P>
    // To programmatically change sort field or direction after initialization, call +link{sort()}.
    // @group sorting
    // @example sort
    // @visibility external
    //<
    
	//>	@attr	listGrid.keyboardClickField    (string|number : null : [IRW])
	//      When simulating click events listGrid rows as a result of keyboard events
	//      (navigating using the arrow keys, space, enter for doubleClick), which column
	//      should the event be generated upon?
	//      Should be set to the name or index of the desired column.
	//      If null, defaults to the first column.
	//      @group  events
	//<
    
	//>	@attr	listGrid.sortDirection		(SortDirection : Array.ASCENDING : [IRW])
    // Sorting direction of this ListGrid. If specified when the ListGrid is initialized,
    // this property will be the default sorting direction for the +link{listGrid.sortField}.
    // May be overridden by specifying +link{ListGridField.sortDirection}.
    // <P>
    // After initialization, this property will be updated on +link{ListGrid.sort()} to reflect
    // the current sort direction of the grid.
    // @group  sorting
    // @see type:SortDirection
    // @example sort
    // @setter listGrid.sort()
	// @visibility external
	//<
   	
	sortDirection:Array.ASCENDING,
    
	//>	@attr listGrid.showSortArrow (SortArrow : null : [IRW])
	//          Indicates whether a sorting arrow should appear for the listGrid, and its
	//          location. See SortArrow type for details.<br>
	//          Clicking the sort arrow reverses the direction of sorting for the current sort
	//          column (if any), or sorts the listGrid by its first sortable column. The arrow
	//          image on the button indicates the current direction of sorting.
    //          If undefined, the sort arrow will show up in the sorted field, and the
    //          corner sort button will be displayed if a vertical scrollbar is being displayed
	//      @visibility external
	//      @group  sorting, appearance
	//<
	
    //showSortArrow:null,

    //> @attr listGrid.canPickFields        (Boolean : true : [IRW])
    // Indicates whether the field picker item and submenu should be present in the header
    // context menu
    //
    // @visibility external
    // @group sorting 
    //<
    canPickFields: true,
    
    // Frozen Fields (aka Frozen Columns)
    // ---------------------------------------------------------------------------------------
    
    //> @groupDef frozenFields
    // Frozen fields are fields that do not scroll horizontally with other fields, remaining on
    // the screen while other fields may be scrolled off.  This feature is typically used to
    // allow basic identifying information (like an "accountId") to remain on screen while the
    // user scrolls through a large number of related fields.
    // <P>
    // Fields can be programmatically frozen via setting
    // +link{listGridField.frozen,field.frozen} to true when the grid is created, or
    // dynamically frozen and unfrozen via +link{listGrid.freezeField,freezeField()} and
    // +link{listGrid.unfreezeField,unfreezeField()}.
    // The setting +link{listGrid.canFreezeFields,canFreezeFields} enables a user interface to
    // allow end users to dynamically freeze and unfreeze fields.
    // <P>
    // The frozen fields feature is not compatible with the following features:
    // <ul>
    // <li> variable height auto-sizing records
    //      (+link{listGrid.fixedRecordHeights,fixedRecordHeights:false})
    // <li> headers that autoFit to titles (normally enabled via
    //      <code>field.overflow:"visible"</code>)
    // <li> the +link{CubeGrid} subclass of ListGrid
    // <li> nested grids
    // </ul>
    // The frozen fields feature <b>is</b> compatible with column resize and reorder, selection
    // and multi-selection, loading data on demand, inline editing, drag and drop and reorder
    // of records, the +link{TreeGrid} subclass of ListGrid, and all dynamic styling-related and
    // formatting-related features.
    // 
    // @title Frozen Fields
    // @visibility external
    //<

    //> @attr listGrid.canFreezeFields  (boolean : null : IRW)
    // Whether an interface should be shown to allow user is allowed to dynamically "freeze" or
    // "unfreeze" columns with respect to horizontally scrolling. If unset, this property defaults
    // to <code>true</code> unless:<ul>
    // <li>+link{listGrid.fixedRecordHeights,this.fixedRecordHeights} is <code>false</code></li>
    // <li>+link{listGrid.bodyOverflow,this.bodyOverflow} is <code>"visible"</code></li>
    // <li>+link{listGrid.autoFitData,this.autoFitData} is set to <code>"horizontal"</code> or 
    // <code>"both"</code></li>
    // <li>Any field has overflow set to <code>"visible"</code></li></ul>
    // <P>
    // Note that the <code>canFreezeFields</code> setting enables or disables the user
    // interface for freezing and unfreezing fields only.  Fields can be programmatically
    // frozen via setting +link{listGridField.frozen,field.frozen} to true when the grid is
    // created, or dynamically frozen and unfrozen via +link{freezeField()} and
    // +link{unfreezeField()}.
    //
    // @group frozenFields
    // @visibility external
    //<
    // Note that fixedColumnWidths:false will also disable canFreezeFields but this
    // is not currently public.
    

	// Context Menus
	// --------------------------------------------------------------------------------------------

	//>	@attr	listGrid.showCellContextMenus (boolean : false : [IRW])	
	// Whether to show a context menu with standard items for all context clicks on rows in the
	// body.
    // @visibility experimental
	//<
	//showCellContextMenus:false,
    
    //> @attr   listGrid.openRecordEditorContextMenuItemTitle   (string : "Edit" : [IRW])
    // If +link{listGrid.canOpenRecordEditor} is true and +link{listGrid.showCellContextMenus}
    // is true, this property specifies the title for the context menu item shown allowing the
    // user to perfom editing on a row via an embedded form.
    // @group i18nMessages
    // @visibility nextedGrid
    //<
    openRecordEditorContextMenuItemTitle:"Edit",

    //>@attr listGrid.dismissEmbeddedComponentContextMenuItemTitle (string : "Dismiss" : IRW)
    // If +link{listGrid.showCellContextMenus} is true, and we are currently showing either
    // an embedded editor (see +link{listGrid.canOpenRecordEditor}) or an embedded
    // detail grid (see +link{listGrid.canOpenRecordDetailGrid}, this property
    // specifies the title for the context menu item shown allowing the user to dismiss the
    // embedded component.
    // @group i18nMessages
    // @visibility nextedGrid
    //<
    dismissEmbeddedComponentContextMenuItemTitle:"Dismiss",

    //>@attr listGrid.deleteRecordContextMenuItemTitle (string : "Delete" : IRW)
    // If +link{listGrid.showCellContextMenus} is true, this property
    // specifies the title for the context menu item shown allowing the user to delete the
    // record on which the contextMenu was shown.
    // @group i18nMessages
    // @visibility experimental
    //<    
    deleteRecordContextMenuItemTitle:"Delete",


	//> @attr   listGrid.canOpenRecordDetailGrid (boolean : true : [IRW])
	// Whether context menu items will be shown for viewing records from related DataSources in
	// grids embedded in the record.
	// <P>
	// Valid only when <code>showCellContextMenus</code> is true.
	// @visibility nestedGrid
	//<
    canOpenRecordDetailGrid:true,

	//> @attr   listGrid.recordDetailGridProperties (Object : null : [IR])
	// Properties for detail grids shown embedded inside rows.
	// @visibility nestedGrid
	//<

	//> @attr   listGrid.canOpenRecordEditor (boolean : true : [IRW])
	// Whether a context menu item will be shown for editing records with a form embedded in
	// the record.
	// <P>
	// Valid only when <code>showCellContextMenus</code> is true.
	// @visibility nestedGrid
	//<
    canOpenRecordEditor:true,

	//> @attr   listGrid.recordEditorProperties     (Object : null : [IR])
	// Properties for editor forms shown embedded inside rows.
    // @see listGrid.canOpenRecordEditor
	// @visibility nestedGrid
	//<
    
    //> @attr   listGrid.recordEditorSaveButtonTitle    (string : "Save" : [IRW])
    // Title for the Save button shown in the editor form embedded inside rows if 
    // +link{listGrid.canOpenRecordEditor} is true.
    // @see listGrid.canOpenRecordEditor
    // @group i18nMessages
    // @visibility nestedGrid
    //<
    recordEditorSaveButtonTitle:"Save", 

    //> @attr   listGrid.recordEditorCancelButtonTitle    (string : "Cancel" : [IRW])
    // Title for the Cancel button shown in the editor form embedded inside rows if 
    // +link{listGrid.canOpenRecordEditor} is true.
    // @see listGrid.canOpenRecordEditor
    // @group i18nMessages
    // @visibility nestedGrid
    //<
    recordEditorCancelButtonTitle:"Cancel",


	//>!BackCompat 2007.02.02
    // showCornerContextMenu was never externally documented and we have no in-code comments
    // about having ever exposed this property, so it may be safe to get rid of this
    // back-compat

	//>	@attr	listGrid.showCornerContextMenu (boolean : null : [IR])	
	// Whether to allow a context menu on the sorter with standard items for showing and hiding
	// fields.
    // @deprecated as of 5.6 in favor of +link{attr:listGrid.showHeaderContextMenu}
	//<
    //<!BackCompat
    
	//>	@attr	listGrid.showHeaderContextMenu (boolean : true : [IR])	
	// Whether to show a context menu on the header with standard items for showing and hiding
	// fields.
    // @group gridHeader
    // @see method:listGrid.displayHeaderContextMenu()
    // @see method:listGrid.getHeaderContextMenuItems()
    // @visibility external
	//<
    // NOTE: avoid crashing if Menu class isn't loaded by defaulting to false.
	// when we load the Menu class, we override this default.
	//showHeaderContextMenu:false,
    
    // headerMenuButton
    // ----------------------------
    //>	@attr	listGrid.showHeaderMenuButton (boolean : false : [IR])	
    // If set to true and +link{listGrid.showHeaderContextMenu,showHeaderContextMenu} is true, the
    // +link{listgrid.headerMenuButton} will be displayed when the user rolls
    // over the header buttons in this grid.
    // @group headerMenuButton    
    // @visibility external
	//<
    // As with showHeaderContextMenu, this default should not be set to true until we know
    // for sure that Menu has been loaded (see Menu.js)
    //showHeaderMenuButton:true,
    
    //> @attr listGrid.headerMenuButtonConstructor (className : null : [IRA])
    // Constrocutor for the  +link{listGrid.headerMenuButton}. If unset a standard "Button" will
    // be rendered out. Note that this property may be overridden by different skins.
    // @group headerMenuButton
    // @visibility external
    //<
    //headerMenuButtonConstructor: "StretchImgButton",
    
    //> @attr listGrid.headerMenuButton (AutoChild : null : [RA])
    // If +link{showHeaderMenuButton} is true, when the user rolls over the header buttons in this
    // grid the headerMenuButton will be shown over the header button in question. When clicked
    // this button will display the standard header context menu (see
    // +link{listGrid.displayHeaderContextMenu}).
    // <P>
    // +link{group:headerMenuButton,Several properties} exist to customize the appearance of the
    // headerMenuButton. Also see the +link{type:AutoChild} documentation for information on how 
    // to make freeform modifications to autoChild widgets
    // @group headerMenuButton
    // @visibility external
    //<
    
    //>	@attr	listGrid.headerMenuButtonIcon (URL : "[SKIN]/ListGrid/sort_descending.gif" : [IRA])	
	// If +link{listGrid.showHeaderMenuButton} is true, this property governs the icon shown on the
    // auto-generated <code>headerMenuButton</code>
    // @group headerMenuButton
    // @visibility external
	//<
    headerMenuButtonIcon:"[SKIN]/ListGrid/headerMenuButton_icon.gif",
    
    //>	@attr	listGrid.headerMenuButtonIconWidth (number : 7 : [IRA])	
	// If +link{listGrid.showHeaderMenuButton} is true, this property governs the width of the icon
    // shown on the auto-generated <code>headerMenuButton</code>
    // @group headerMenuButton
    // @visibility external
	//<
    headerMenuButtonIconWidth:7,
    
    //>	@attr	listGrid.headerMenuButtonIconHeight (number : 7 : [IRA])	
	// If +link{listGrid.showHeaderMenuButton} is true, this property governs the height of the icon
    // shown on the auto-generated <code>headerMenuButton</code>
    // @group headerMenuButton
    // @visibility external
	//<
    headerMenuButtonIconHeight:7,
    
    //>	@attr	listGrid.headerMenuButtonWidth (number : 16 : [IRA])	
	// If +link{listGrid.showHeaderMenuButton} is true, this property governs the width of the 
    // auto-generated <code>headerMenuButton</code>
    // @group headerMenuButton
    // @visibility external
	//<
    headerMenuButtonWidth:16,

    //>	@attr	listGrid.headerMenuButtonHeight (measure : "100%" : [IRA])	
	// If +link{listGrid.showHeaderMenuButton} is true, this property governs the height of the 
    // auto-generated <code>headerMenuButton</code>
    // @group headerMenuButton
    // @visibility external
	//<
    headerMenuButtonHeight:"100%",
    

	// Drag Resize / Reorder / Drag and Drop
	// --------------------------------------------------------------------------------------------

	//>	@attr	listGrid.canDragRecordsOut		(boolean : false : [IRW])	
	//          Indicates whether records can be dragged from this listGrid and dropped elsewhere.
	//      @visibility external
	//      @group  dragging
    // @see ListGridRecord.canDrag
    // @see ListGridRecord.canAcceptDrop
    // @example dragListMove
	//<
	canDragRecordsOut:false,
    
	//>	@attr	listGrid.canAcceptDroppedRecords		(boolean : false : [IRW])
	//          Indicates whether records can be dropped into this listGrid.
	//      @visibility external
	//      @group  dragging
    // @see ListGridRecord.canDrag
    // @see ListGridRecord.canAcceptDrop    
    // @example dragListMove
	//<
	//canAcceptDroppedRecords:false,
    
	//>	@attr	listGrid.canReorderRecords		(boolean : false : [IRW])
	//          Indicates whether records can be reordered by dragging within this listGrid.
	//      @visibility external
    //      @group  dragging
    // @see ListGridRecord.canDrag
    // @see ListGridRecord.canAcceptDrop    
    // @example dragListMove
    // @example gridsDragReorder
	//<
	//canReorderRecords:false,
    
	//>	@attr	listGrid.canReorderFields		(boolean : true : [IRW])
	//          Indicates whether fields in this listGrid can be reordered by dragging and
	//          dropping header fields.
	//      @visibility external
	//      @group  dragging
    //      @example columnOrder
	//<
	canReorderFields:true,
    
	//>	@attr	listGrid.canResizeFields		(boolean : true : [IRW])
	//          Indicates whether fields in this listGrid can be resized by dragging header
	//          fields.
	//      @visibility external
	//      @group  dragging
    //      @example columnSize
	//<
	canResizeFields:true,

	// for dragging records out, use the drag tracker
    dragAppearance:isc.EH.TRACKER,
    
    //>@type DragTrackerMode
    // When records are being dragged from within a ListGrid, what sort of drag-tracker
    // should be displayed?
    // @value "none" Don't display a drag tracker at all
    // @value "icon" Display an icon to represent the record(s) being dragged. Icon src is
    //              derived from +link{ListGrid.getDragTrackerIcon()}
    // @value "title" Display a title for the record being dragged. Title derived from
    //              +link{ListGrid.getDragTrackerTitle()}
    // @value "record" Display the entire record being dragged
    // @group dragTracker
    // @visibility external
    //<
    
    //> @attr   listGrid.dragTrackerMode    (DragTrackerMode : "icon" : [IRA])
    // When records are being dragged from within a ListGrid, what sort of drag-tracker
    // should be displayed?<br>
    // Note that if multiple records are being dragged the displayed tracker will be
    // based on the first selected record.
    // @group dragTracker
    // @visibility external
    //<
    dragTrackerMode:"title",
    
    
	//>	@attr	listGrid.resizeFieldsInRealTime   (boolean : isc.Browser.isIE && isc.Browser.isWin : IRWA)
	//		True == we redraw the list viewer in real time as fields are being resized.
	//		This can be slow with a large list and/or on some platforms.
    //
	//		@group	dragging
    //      @visibility external
	//<
	resizeFieldsInRealTime: (isc.Browser.isIE && isc.Browser.isWin) 
                            || (isc.Browser.isFirefox && isc.Browser.geckoVersion >= 20080529),
	
	//>	@attr	listGrid.dragDataAction		(DragDataAction : isc.ListGrid.MOVE : IRW)
	//          Indicates what to do with data dragged into another listGrid. See
	//          DragDataAction type for details.
	//      @visibility external
	//      @group  dragging
    //      @example gridsDragMove
    //      @example gridsDragCopy
	//<
	dragDataAction:isc.ListGrid.MOVE,
    
	// Embedded Components
	// --------------------------------------------------------------------------------------------
    embeddedComponentIndent: 25,

	// Nested Master-Detail
	// --------------------------------------------------------------------------------------------
    nestedGridDefaults : {
        height:150
    },

	// Skinning
	// --------------------------------------------------------------------------------------------
	//>	@attr	listGrid.skinImgDir		(URL : "images/ListGrid/" : IRWA)
	// Where do 'skin' images (those provided with the class) live?
	// @group appearance, images
    // @visibility external
	//<
	skinImgDir:"images/ListGrid/",		

	//>	@attr	listGrid.sortAscendingImage		(ImgProperties : {...} : IRWA)
	// Image to show when sorting ascending. See +link{class:ImgProperties} for format.
	// @group appearance
    // @visibility external
	//<
	sortAscendingImage:{src:"[SKIN]sort_ascending.gif", width:7, height:7},

	//>	@attr	listGrid.sortDescendingImage		(ImgProperties : {...} : IRWA)
	// Image to show when sorting descending. See +link{class:ImgProperties} for format.
	// @group appearance
    // @visibility external
	//<
	sortDescendingImage:{src:"[SKIN]sort_descending.gif", width:7, height:7},

	//>	@attr	listGrid.trackerImage		(ImgProperties : {...} : IRWA)
	// Default image to use for the dragTracker when things are dragged within or out of this 
    // list. See +link{class:ImgProperties} for format.
    //
	// @group dragTracker
    // @see listGrid.dragTrackerMode
    // @see listGrid.getDragTrackerIcon()
    // @visibility external
	//<	
    trackerImage:{src:"[SKIN]tracker.gif", width:16, height:16},
    
    //> @attr listGrid.booleanTrueImage     (SCImgURL : null :IRWA)
    // Image to display for a true value in a boolean field.
    // <P>
    // To turn this off explicitly set +link{listGridField.suppressValueIcon} to true.
    // <P>
    // If this and +link{listGrid.booleanFalseImage} are undefined, this will be set to
    // +link{checkboxItem.checkedImage}.
    // @see listGrid.booleanFalseImage
    // @group imageColumns
    // @visibility external
    //<
    booleanTrueImage:null,
    
    //> @attr listGrid.booleanFalseImage     (string : null :IRWA)
    // Image to display for a false value in a boolean field. Default <code>null</code> value
    // means no image will be displayed
    // <P>
    // To turn this off explicitly set +link{listGridField.suppressValueIcon} to true
    // <P>
    // If this and +link{listGrid.booleanTrueImage} are undefined, this will be set to
    // +link{checkboxItem.uncheckedImage}.
    // @group imageColumns
    // @see listGrid.booleanTrueImage
    // @visibility external
    //<
    booleanFalseImage:null,
    
    //> @attr listGrid.booleanImageWidth (number : 16 : IRWA)
    // Width for the +link{listGrid.booleanTrueImage} and +link{listGrid.booleanFalseImage}
    // @group imageColumns
    // @visibility external
    //<
    booleanImageWidth:16,
    
    //> @attr listGrid.booleanImageHeight (number : 16 : IRWA)
    // Height for the +link{listGrid.booleanTrueImage} and the +link{listGrid.booleanFalseImage}
    // @group imageColumns
    // @visibility external
    //<
    booleanImageHeight:16,
    
    
    //>@attr    listGrid.mozBodyOutlineColor    (string : "white" : IRWA)
    // If we're in Moz Firefox 1.5 or above, and showing a header, what color should the 
    // dotted focus outline show around the body. Must be a color that contrasts with the 
    // header of the ListGrid.
    // @visibility internal
    //<
    mozBodyOutlineColor:"white",
    //>@attr    listGrid.mozBodyNoHeaderOutlineColor    (string : "red" : IRWA)
    // If we're in Moz Firefox 1.5 or above, and we're not showing a header, what color 
    // should the dotted focus outline show around the body. Must be a color that contrasts 
    // with the header of the ListGrid.
    // @visibility internal
    //<
    mozBodyNoHeaderOutlineColor:"red"

});



isc.ListGrid.addMethods({

//>	@method	ListGrid.initWidget()	(A)
// Initialize the canvas and call listGrid.setData()
//		@param	[all arguments]	(object)	objects with properties to override from default
//<
initWidget : function () {
	// force loading rows to contain at least &nbsp; otherwise row height may be reported as less
	// than the actual height.
    if (this.loadingMessage == null || this.loadingMessage == isc.emptyString) 
        this.loadingMessage = "&nbsp";
    
    // default our overflow to "visible" if autoFitData is set
    if (this.autoFitData != null) {
        this._specifiedOverflow = this.overflow;
        this.setOverflow("visible");
    }

	// initialize the data object, setting it to an empty array if it hasn't been defined
	this.setData(this.data ? null : this.getDefaultData());

    // if a grouping is already set, reset it with groupBy
    if (this.groupByField) {
        var fields;
        if (isc.isA.Array(this.groupByField)) fields = this.groupByField;
        else                                  fields = [ this.groupByField ];            
        this.groupByField = null;

        this.groupBy(fields);
    }

    // set up selectionType dynamic default
    this.setSelectionAppearance(this.selectionAppearance);
    
    this._setUpDragProperties(); 
},

getDefaultData : function () { return []; },

_setUpDragProperties : function () {
	// set up our specific drag-and-drop properties
	this.canDrag = (this.canDrag || this.canDragRecordsOut || this.canReorderRecords || 
                    this.canDragSelect);
	this.canDrop = (this.canDrop || this.canDragRecordsOut || this.canReorderRecords);
	this.canAcceptDrop = (this.canAcceptDrop || this.canAcceptDroppedRecords || this.canReorderRecords);

},

getEmptyMessage : function () { 
    if (isc.ResultSet && isc.isA.ResultSet(this.data) && !this.data.lengthIsKnown()) {
        //>Offline
        if (isc.isOffline()) {
            return this.offlineDataMessage;
        } else {
        //<Offline
            return this.loadingDataMessage; 
        //>Offline
        }
        //<Offline
    }
    return this.emptyMessage;
},

isEmpty : function () {
    if (!this.data) return true;
    
    // treat having no fields as being empty so we don't attempt to write out and manipulate
    // an empty table 
    if (!this.fields || this.fields.length == 0) return true;
    
    
    if (isc.ResultSet && isc.isA.ResultSet(this.data)) {

        if (this.data.isPaged()) {
            if (!this.data.isEmpty()) return false;
            
            
            var editRows = this.getAllEditRows();
            if (editRows && editRows.length > 0) {
                for (var i = 0; i < editRows.length; i++) {
                    if (editRows[i] >= 0) return false;
                }
            }
            return true;
        } else {
            // If our length is not known we must be in the process of loading, so return the
            // loading message.
            if (this.data.lengthIsKnown()) return this.getTotalRows() <= 0;
            else return true;
        }
    } else {
        return (this.getTotalRows() <= 0);
    }
},


//>	@attr   listGrid.preserveEditsOnSetData    (boolean : null : IRWA)
// By default any edit values in an editable ListGrid are dropped when 'setData()' is called, 
// as previous edits are almost certainly obsoleted by the new data-set.
// This flag allows the developer to suppress this default behavior.
// @visibility internal
// @group data
//<
// Leave this internal for now - no known use cases for it, but seems like something that
// could come up.
//preserveEditsOnSetData : null,

//>	@method	listGrid.setData()    ([])
// Initialize the data object with the given array. Observes methods of the data object
// so that when the data changes, the listGrid will redraw automatically.
//      @visibility external
//		@group	data
//
//		@param	newData		(List of ListGridRecord)	data to show in the list
//<
setData : function (newData) {

	// if the current data and the newData are the same, bail
	//	(this also handles the case that both are null)
	if (this.data == newData) return;

    if (!this.preserveEditsOnSetData) this.discardAllEdits();
    
    // drop "lastHiliteRow" -no sense in hanging onto it
    this.clearLastHilite();
    
	// if we are currently pointing to data, stop observing it
	if (this.data) {
        this._ignoreData(this.data);
        // if the data was autoCreated, destroy it to clean up RS<->DS links
        if (this.data._autoCreated && isc.isA.Function(this.data.destroy))
            this.data.destroy();
    }

	// if newData was passed in, remember it
	if (newData) this.data = newData;

	// if data is not set, bail
	if (!this.data) return;

	// observe the data so we will update automatically when it changes
	this._observeData(this.data);

	// if we can regroup, do so. 
        
	this.regroup(true);
    
	// create a new selection if we don't have one or if we receive new data
    // Do this after grouping - if we created a new groupTree object we'll have already set up
    // an appropriate selection object
	if (!this.selection || (this.data != this.selection.data)) {
        this.createSelectionModel();
	}


    // Call this._remapEditRows() if we're hanging onto edit values
    // as we know they're now out of date.
    
	if (this.preserveEditsOnSetData) this._remapEditRows();

	// if we're sortable and the sort field is set, sort the data
	if (this.canSort && this._getSortFieldNum() != null) {
		this.sortData();
	}

    
    if (isc.ResultSet && isc.isA.ResultSet(this.data) && 
        this.body && this.body.overflow == "visible") 
    {
        this.body.showAllRows = false;
    }

	// mark us as dirty so we'll be redrawn if necessary
    this._markBodyForRedraw("setData");
},

// Override createSelectionModel, from DataBoundComponent, to set the body's selection object
// with our selection object. Our body GridRenderer will then observe selection.setSelected.
createSelectionModel : function () {

    
    this.invokeSuper(isc.ListGrid, "createSelectionModel", arguments);
    if (isc.isA.Canvas(this.body)) {
        this.body.setSelection(this.selection);
        if (this.frozenBody) this.frozenBody.setSelection(this.selection);
    }
    
},

destroySelectionModel : function () {
    if (this.body) this.body.clearSelection();
    if (this.frozenBody) this.frozenBody.clearSelection();
    return this.Super("destroySelectionModel", arguments);
},

//>	@method	listGrid.setSelectionType()	[A]
// Changes selectionType on the fly.
// @param	selectionType (SelectionStyle)	new selection style
//<
setSelectionType : function (selectionType) {
    // NOTE: this is sufficient because the Selection object dynamically inspects this property
    // on it's grid
    this.selectionType = selectionType;
    if (this.body) this.body.selectionType = selectionType;
},

//>	@method	listGrid.setSelectionAppearance()	
// Changes selectionAppearance on the fly.
// @param	selectionAppearance (String)	new selection appearance
//<
setSelectionAppearance : function (selectionAppearance) {
    this.selectionAppearance = selectionAppearance;
    var selType = selectionAppearance == "checkbox" ? isc.Selection.SIMPLE : isc.Selection.MULTIPLE;
    this.setSelectionType(selType);    
},

//> @method listGrid.setBodyOverflow()  ([A])
// Update the +link{listGrid.bodyOverflow, bodyOverflow} for this listGrid.
// @param overflow (Overflow) new overflow setting for the body
// @visibility external
//<
setBodyOverflow : function (newOverflow) {
    this.bodyOverflow = newOverflow;
    if (this.body) this.body.setOverflow(this.bodyOverflow);
},

//> @method listGrid.setBodyStyleName()
// Update the +link{listGrid.bodyStyleName,bodyStyleName} for this listGrid.
// @param styleName (CSSStyleName) new body style name
// @visibility external
//<
setBodyStyleName : function (styleName) {
    this.bodyStyleName = styleName;
    if (this.body && (!this.alternateBodyStyleName || !this.alternateRecordStyles)) {
        this.body.setStyleName(styleName);
    }
},

//> @method listGrid.setAlternateBodyStyleName()
// Update the +link{listGrid.alternateBodyStyleName,alternateBodyStyleName} for this listGrid.
// @param styleName (CSSStyleName) new body style name when showing alternateRecordStyles
// @visibility external
//<
setAlternateBodyStyleName : function (styleName) {
    this.alternateBodyStyleName = styleName;
    if (this.body && this.alternateRecordStyles) {
        // if passed 'null', reset to this.bodyStyleName
        this.body.setStyleName(styleName || this.bodyStyleName);
    }
},

//> @method listGrid.setAlternateRecordStyles()
// Setter for +link{listGrid.alternateRecordStyles}
// @param alternateStyles (boolean) New value for <code>this.alternateRecordStyles</code>
// @visibility external
//<
setAlternateRecordStyles : function (alternateStyles) {
    if (this.alternateRecordStyles == alternateStyles) return;
    this.alternateRecordStyles = alternateStyles;
    
    if (this.body && (this.alternateBodyStyleName != null)) {
        if (alternateStyles) this.body.setStyleName(this.alternateBodyStyleName);
        else this.body.setStyleName(this.bodyStyleName);
    }
    
},

// Override hasInherentHeight / width: If we're autoFitting to our data, advertise inherent height
// This means that a layout will not expand us to fit the available space.

hasInherentHeight : function (a,b,c,d) {
    if (this.inherentHeight != null) return this.inherentHeight;
    if (this.autoFitData == isc.Canvas.VERTICAL || this.autoFitData == isc.Canvas.BOTH) {
        return true;
    }
    return this.invokeSuper(isc.ListGrid, "hasInherentHeight", a,b,c,d);
},

hasInherentWidth : function (a,b,c,d) {
    if (this.inherentWidth != null) return this.inherentWidth;
    if (this.autoFitData == isc.Canvas.HORIZONTAL || this.autoFitData == isc.Canvas.BOTH) {
        return true;
    }
    return this.invokeSuper(isc.ListGrid, "hasInherentWidth", a,b,c,d);
},

//> @method listGrid.setAutoFitData()
// Setter for +link{listGrid.autoFitData}.
// @param autoFitData (string) One of <code>"vertical"</code>, <code>"horizontal"</code>
//  or <code>"both"</code>. To disable auto fit behavior, pass in <code>null</code>.
// @group autoFitData
// @visibility external
//<
setAutoFitData : function (autoFitData) {
    this.autoFitData = autoFitData;
    
    if (this._autoDerivedCanFreeze && (autoFitData == "both" || autoFitData == "horizontal"
                                 
                                       || autoFitData == "vertical")) {
        delete this._autoDerivedCanFreeze;
        delete this.canFreezeFields;
    }
    if (autoFitData == null && this._specifiedOverflow) {
        this.setOverflow(this._specifiedOverflow);
    } else if (this.overflow != "visible") {
        this._specifiedOverflow = this.overflow;
        this.setOverflow("visible");
    }
    if (this.body) {
        this.body.autoFitData = this.autoFitData;
        this.body.adjustOverflow();
    }
},

//> @method listGrid.setAutoFitMaxRecords()
// Setter for +link{listGrid.autoFitMaxRecords}.
// @param maxRecords (integer) Maximum number of rows we'll expand to accomodate if 
// +link{listGrid.autoFitData,auto fit} is enabled vertically.
// @group autoFitData
// @visibility external
//<
setAutoFitMaxRecords : function (maxRecords) {
    this.autoFitMaxRecords = maxRecords;
    if (this.body) {
        this.body.autoFitMaxRecords = maxRecords;
        this.body.adjustOverflow();
    }
},

//> @method listGrid.setAutoFitMaxHeight()
// Setter for +link{listGrid.autoFitMaxHeight}.
// @param height (integer) Maximum height in px we'll expand to accomodate if 
// +link{listGrid.autoFitData,auto fit} is enabled vertically.
// @group autoFitData
// @visibility external
//<
setAutoFitMaxHeight : function (height) {
    this.autoFitMaxHeight = height;
    if (this.body) {
        this.body.adjustOverflow();
    }
},
getAutoFitMaxBodyHeight : function () {
    if (this.autoFitMaxHeight == null) return null;
    var offset = this.getVBorderPad();
    if (this.showHeader) offset += this.headerHeight;
    if (this.showFilterEditor) offset += this.filterEditorHeight;
    return this.autoFitMaxHeight - offset;
    
},

//> @method listGrid.setAutoFitMaxColumns()
// Setter for +link{listGrid.autoFitMaxColumns}.
// @param maxColumns (integer) Maximum number of fields we'll expand to accomodate if 
// +link{listGrid.autoFitData,auto fit} is enabled horizontally.
// @group autoFitData
// @visibility external
//<
setAutoFitMaxColumns : function (maxColumns) {
    this.autoFitMaxColumns = maxColumns;
    if (this.body) {
        this.body.autoFitMaxColumns = maxColumns;
        this.body.adjustOverflow();
    }
},

//> @method listGrid.setAutoFitMaxWidth()
// Setter for +link{listGrid.autoFitMaxWidth}.
// @param width (integer) Width in px we'll expand to accomodate if 
// +link{listGrid.autoFitData,auto fit} is enabled horizontally.
// @group autoFitData
// @visibility external
//<
setAutoFitMaxWidth : function (width) {
    this.autoFitMaxWidth = width;
    if (this.body) {
        this.body.autoFitMaxWidth = width;
        this.body.adjustOverflow();
    }
},

// mark the body for redraw, or if the body doesn't exist, the widget as a whole
_markBodyForRedraw : function (reason) {
	if (this.bodies) {
        this.bodies.map("markForRedraw", reason);
    } else {
        this.markForRedraw(reason);
    }        
},

redraw : function (a, b, c, d) {
    
    if (this.body) {
        if (this.body._scrollbarChangeDuringAnimation) {
            this._updateFieldWidths("scrollbar change during animation");
            delete this.body._scrollbarChangeDuringAnimation;
        }
    }

    this.invokeSuper(isc.ListGrid, "redraw", a, b, c, d);
},

//>	@method listGrid._observeData() (A)
//		observe methods on the data so we redraw automatically when data changes
//		called automatically by setData
//	@param	data	(object)		new data to be observed
//<
_observeData : function (data) {
	// redraw if the data changed
    this.observe(data, "dataChanged",
                    "observer.dataChanged(" + 
                        (isc.ResultSet && isc.isA.ResultSet(data) ? 
                        "operationType,originalRecord,rowNum,updateData)" : 
                        ")")
    );
    
	// Note - we must check for data being a tree as if it is not defined, the inherited 
    // ListGrid.init() code will set it to an empty array, in which case this observation will 
    // fail.
    if (isc.isA.Tree(data)) {
        // update view in response to folders opening / closing
    	this.observe(data, "changeDataVisibility", "observer._folderToggleObservation()");
    } 
},
//> @method listGrid.groupTreeChanged()
// Callback fired when group tree +link{listGrid.groupTree} is
// manipulated, either directly or as the result of automatic regrouping.
// <p>
// No default implementation.
//
// @group grouping
//<
groupTreeChanged : function () {
    
},
//>	@method listGrid._observeGroupData() (A)
//      observe methods on the group tree object, so that changes to the group layout
//      can be detected
//	@param	data	(object)		new group tree to be observed
//  @visibility internal
//<
_observeGroupData : function (data) {
	// redraw if the data changed 
    this.observe(data, "dataChanged", "observer.groupTreeChanged()");
    this.observe(data, "changeDataVisibility", "observer._folderToggleObservation()");
},

// METHODS MOVED FROM TREEGRID
// The following methods were moved from treegrid to allow the listgrid to support the tree
// as a data model for grouping. They will continue to be doc'd on treegrid for now

// Helper method - fired when folders open/close within the tree
_folderToggleObservation : function () {
    //>Animation
    // During animated folder open/close we suppress redraw in response to the folder toggling
    if (this._suppressFolderToggleRedraw) {
        this._remapEditRows();
        return;
    }
    // Cut short any currently running animated folder open / close 
    // Just call finishAnimation - this will no op if no animation is running
    
    if (this.body) this.body.finishRowAnimation();
    //<Animation
    
    // Length changes so we need to remap edit rows.
    this._remapEditRows();

    // redraw to display the updated folder
    this._markBodyForRedraw('folderToggled');
    
    // recalculate the selection when a folder opens or closes
    this.selection.markForRedraw();
    
},

//> @method treeGrid.toggleFolder()   ([])
//          Opens the folder specified by node if it's closed, and closes it if it's open.
//          TreeGrid will redraw if there's a change in the folder's open/closed state.
//
//      @visibility external
//      @param  node        (TreeNode)      node to toggle
//<
toggleFolder : function (node) {
    if (this.data.isOpen(node)) {
        this.closeFolder(node);
    } else {
        this.openFolder(node);
        
        if (this.frozenBody) this.frozenBody.markForRedraw();
    }
},

//> @method treeGrid.openFolder() ([A])
// Opens a folder.
// <p>
// Executed when a folder node receives a 'doubleClick' event. This handler must be
// specified as a function, whose single parameter is a reference to the relevant folder
// node in the tree's data.<br>
// See the ListGrid Widget Class for inherited recordClick and recordDoubleClick events.
//
// @param   node        (TreeNode)      node to open
// @see closeFolder()
// @see folderOpened()
// @see class:ListGrid
// @visibility external
//<
openFolder : function (node) {
    // CALLBACK API:  available variables:  "node"
    // Convert a string callback to a function
    if (this.folderOpened != null) {
        this.convertToMethod("folderOpened");
        if (this.folderOpened(node) == false) return false;
    }
    
    if (this.animateFolders) {
        this.animateOpen(node);
    } else {
        this.data.openFolder(node);
    }
},   

//> @method treeGrid.animateOpen()
// Animates a folder opening to display its children (which grow into view).
// Automatically triggered from <code>treeGrid.folderOpen()</code> if 
// <code>this.animateFolders</code> is true.
// @group animation
// @param folder (node) node to open
// @visibility animation_advanced
//<
animateOpen : function (folder) {
    var data = this.data;
    if (data.isOpen(folder)) return;

    // Open the data, but don't redraw with the new data visible (we'll handle redrawing 
    // when the animation completes).
    this._suppressFolderToggleRedraw = true;
    data.openFolder(folder);
    delete this._suppressFolderToggleRedraw;

    // parent may be null if we're looking at the root node
    var parent = data.getParent(folder);
    if (parent && !data.isOpen(parent)) return;
     
    if (data.getLoadState(folder) != isc.Tree.LOADED) {
        //this.logWarn("animation for LOD folder");
        // wait for dataChanged() to fire
        this._pendingFolderAnim = folder;
        return;
    }
   
    this._startFolderAnimation(folder);
},

//> @method treeGrid.closeFolder()
// Closes a folder.
//
// @param   node        (TreeNode)      node to close
// @see openFolder()
// @see folderClosed()
// @visibility external
//<
closeFolder : function (node) {
    // CALLBACK API:  available variables:  "node"
    // Convert a string callback to a function
    if (this.folderClosed != null) {
        this.convertToMethod("folderClosed");
        if (this.folderClosed(node) == false) return false;
    }

    // deselect any nodes under this one
    var selectedRows = this.selection.getSelection();
    if (selectedRows) {
        for (var i = 0; i < selectedRows.length; i++) {
            if (this.data.isDescendantOf(selectedRows[i], node))
                this.selection.deselect(selectedRows[i]);
        }
    }
    // cancel editing of any nodes under this one
    if (this.getEditRow() != null) {
        var editRecord = this.getRecord(this.getEditRow());
        if (this.data.isDescendantOf(editRecord, node)) this.endEditing();
    }
    // now tell the data to close the folder
    if (this.animateFolders) 
        this.animateClose(node);
    else 
        this.data.closeFolder(node);
},

//> @method treeGrid.animateClose()
// Animates a folder closing to hide its children (which shrink out of view).
// Automatically triggered from <code>treeGrid.folderOpen()</code> if 
// <code>this.animateFolders</code> is true.
// @param folder (node) node to open
// @group animation
// @visibility animation_advanced
//<
animateClose : function (folder) {
    if (!this.data.isOpen(folder)) return;

    var parent = this.data.getParent(folder);
    if (parent && !this.data.isOpen(parent)) {
        return this.closeFolder(folder);
    }
    
    var data = this.data,
        folderIndex = data.indexOf(folder),
        numChildren = data.getOpenList(folder).getLength()-1;

    
    
    this.startRowAnimation( false, 
                            folderIndex+1, 
                            folderIndex + numChildren + 1, 
                            {target:this, methodName:"redraw"}, 
                            this.animateFolderSpeed, 
                            this.animateFolderTime,
                            this.animateFolderEffect,
                            true
                          );

    this._suppressFolderToggleRedraw = true;
    this.data.closeFolder(folder);
    delete this._suppressFolderToggleRedraw
    
    if (this.body && this.body._delayedRowAnimation != null) {
        this.body._openFolder = folder;
    }

},

_startFolderAnimation : function (folder) {
    var data = this.data,
        folderIndex = data.indexOf(folder),
        numChildren = data.getOpenList(folder).getLength()-1;

    // don't try to animate empty folders
    if (folderIndex < 0 || numChildren <= 0) return;
    
    this.startRowAnimation( true, 
                            folderIndex+1, 
                            (folderIndex + numChildren+1), 
                            {target:(this.bodyLayout || this.body), methodName:"redraw"}, 
                            this.animateFolderSpeed, 
                            this.animateFolderTime,
                            this.animateFolderEffect,
                            true
                          );
},

// END METHODS MOVE FROM TREEGRID
  

dataChanged : function (type, originalRecord, rowNum, updateData) {
    // if a change was made to the groupBy field of a record, regroup
    var groupByFields = this.groupByField;
    if (groupByFields != null && !this._markForRegroup) {

        if (type == "add" || type == "remove" ||
                (type == "update" && (originalRecord == null || rowNum == null)))
            this._markForRegroup = true;
        else if (type == "update") { 
            var currData = this.data;
            if (this.data.isGroupedOutput && this.originalData) currData = this.originalData;
            var updatedRecord = currData.get(rowNum);
            if (updatedRecord == null) this._markForRegroup = true;
            else for (var i = 0; i < groupByFields.length; i++) {
                var undef, fieldName = groupByFields[i];
    
                if (originalRecord[fieldName] !== undef && !this.fieldValuesAreEqual(
                        fieldName, originalRecord[fieldName], updatedRecord[fieldName])) {
                    // XXX incrementalRegroup can handle this case, but more testing is 
                    // necessary. change this post 7.0
                    // this._incrementalRegroup(updatedRecord, originalRecord, rowNum, 
                    //      updateData);
                    this._markForRegroup = true;
                    break;
                }
            }
        }
    }
    
    
    if (this._markForRegroup) {
        this._markForRegroup = false;  
        this.regroup();
    }
    
    //>Animation
    // Call finishRowAnimation - will kill any show/hide row animations.
    // These animations assume the data remains constant for the duration
    // of the animation.
    // (No-ops if appropriate)
    if (this.body) this.body.finishRowAnimation();
    //<Animation
    
    // Call _remapEditRows() to ensure that editValues are associated with the (possibly
    // modified) rowNumbers using pointers between record primary key and edit values 
    
    if (!this._savingEdits) this._remapEditRows();

    
    var lastRow = this.getTotalRows()-1;
    if (this.body) {
        if (this.body.lastOverRow > lastRow) delete this.body.lastOverRow;
        if (this.body._lastHiliteRow > lastRow) delete this.body._lastHiliteRow;
    }
    if (this._lastRecordClicked > lastRow) delete this._lastRecordClicked;
    
    if (this.hilites) this.applyHilites();
    
    
    if (!this._suppressRedrawOnDataChanged) this._markBodyForRedraw("dataChanged");
    
},


//>	@method listGrid._ignoreData() (A)
//		stop observing methods on data when it goes out of scope
//		called automatically by setData
//	@param	data	(object)		old data to be ignored
//<
_ignoreData : function (data) {
    //>Animation
    // Call finishRowAnimation - will kill any show/hide row animations
    // These animations assume the data remains constant for the duration
    // of the animation.    
    // (No-ops if appropriate)
    if (this.body) this.body.finishRowAnimation();
    //<Animation
	
    if (isc.isA.Tree(this.data))
		this.ignore(data, "changeDataVisibility");
	else
		this.ignore(data, "dataChanged");
	
	if (this.selection) this.selection.deselectAll();
	// NOTE: we don't ignore this.selection.setSelected because
	//			we're re-using the same selection object
},

//>	@method	listGrid.applyFieldDefaults()
//		@group	data
//         Derive default field sizes and formatters where possible, based on schema information.
//<
applyFieldDefaults : function (fields) {
    if (fields == null) return;

	// apply ListGrid-specific defaults, like using toShortDate() for Date fields
    for (var i = 0; i < fields.length; i++) {
        var field = fields[i];

        if (field == null) continue;

    	// default the alignment of each field to "left" if not specified
        var defaultAlign = this.isRTL() ? isc.Canvas.RIGHT : isc.Canvas.LEFT;
                                                              
        var type = field.type,
            baseType = (type != null ? isc.SimpleType.getBaseType(type) : null);
            
	// note: needs to be first, as "image" type technically inherits from text
        if (isc.SimpleType.inheritsFrom(field.type, "image")) {
            field._typeFormatter = this._formatImageCellValue; 

    	// Attempt to size columns to fit their content
        } else if (baseType == this._$text) { 

            if (field.width == null && field.length != null) {
                if (field.length < 15 && !field.valueMap) {
                	// use minimal space for small text fields with no value map
                    field.width = field.length * 7;
                }
            } 
 
        } else if (baseType == "integer" || baseType == "float") {
            // align numbers right by default to line up decimal places       
            defaultAlign = isc.Canvas.RIGHT
            field._typeFormatter = this._formatNumberCellValue;

    	// by default size date columns fields to match the default shortDate format applied
        // to date fields
    	
        } else if (baseType == "date") {
            var canEdit = (this.canEdit == true && field.canEdit != false) ||
                          (this.canEdit != false && field.canEdit == true);
            // If the field has unspecified size, size to accomodate formatted date
            // (or editor if the field is editable)
            field.width = field.width || (canEdit ? 100 : 80);
            // right alignment lines up years if day/month values are numeric and not padded
            defaultAlign = isc.Canvas.RIGHT;
            field._typeFormatter = this._formatDateCellValue;
                        
    	// by default size time columns fields to match the default format applied to time 
        // fields
        } else if (baseType == "time") {
            field.width = field.width || 80;
            field._typeFormatter = this._formatTimeCellValue;
            defaultAlign = isc.Canvas.RIGHT;
                        
        } else if (type == "binary" || type == "blob" || type == "upload" || type == "imageFile") {
            field._typeFormatter = this._formatBinaryCellValue;
        } else if (type == "link") {
            field._typeFormatter = this._formatLinkCellValue;        
        } else if (type == "icon") {
            // default to a width that accomodates the icon plus some padding, center aligned
            field.width = field.width || 
                    ((field.iconWidth || field.iconSize) + (2 * this.cellPadding) + 4);
            field.align = field.align || "center";

            // install a formatter that will put button.icon into the cell
            field._typeFormatter = this._formatIconCellValue;

            // default title so that icon appears alone (otherwise would default to field name
            // if title was unset) 
            field.title = field.title || "&nbsp;";
        }
        
        // For boolean fields we show checkbox images by default
        // this is handled via the valueIcon system - see getValueIcon(), getValueIconWidth() and
        // showValueIconOnly()
        
        
        // If formatCellValue was passed to us as a string, convert it to a method
        if (field.formatCellValue != null && !isc.isA.Function(field.formatCellValue)) 
            isc.Func.replaceWithMethod(field, "formatCellValue", "value,record,rowNum,colNum,grid");
        
        if (this.showValueIconOnly(field)) {
            defaultAlign = isc.Canvas.CENTER;
            // If a field has showValueIconOnly explicitly specified, default it's width
            // to the size of the valueIcon (plus padding)
            
                
            if (field.width == null && field.showValueIconOnly) {
                field.width = this.getValueIconWidth(field) + (2* this.cellPadding) +
                              this.getValueIconRightPadding(field) + 
                              this.getValueIconLeftPadding(field);
            }
        }
        // TODO: numeric quantities with range validators could be given specific sizes
        
        if (!field.align) field.align = defaultAlign;
    }
},

// Helper method called on boolean fields to determine whether we should display standard
// checked and unchecked images
_$boolean:"boolean",
_formatBooleanFieldAsImages : function (field) {
    // If we don't have any images to show, always back off to showing text
    if (this.booleanTrueImage == null && this.booleanFalseImage == null) return false;
    
    var type = field.type,
        baseType = (type != null ? isc.SimpleType.getBaseType(type) : null);
    if (baseType != this._$boolean) return false;
   
    return (!field.suppressValueIcons && field.showValueIconOnly == null &&
             field.valueIcons == null && field.valueMap == null && field.formatCellValue == null);    
},


//>	@method	listGrid.setFieldProperties()
// Set properties for a particular field, such as the title.
// <P>
// NOTE: to resize a field, use resizeField() instead.
//
// @param	fieldNum (number or String) name of the field, or index.
// @param	properties (Button Properties) properties to apply to the header
// @visibility external
//<
// NOTE: little testing has been done on which properties can actually be set this way
setFieldProperties : function (fieldNum, properties) {
    fieldNum = this.getFieldNum(fieldNum);
    var field = this.getField(fieldNum);

    isc.addProperties(field, properties);
    if (this.header != null && this.header.isDrawn()) {
        var header = this.getFieldHeader(fieldNum),
            headerButton = header.getMember(this.getLocalFieldNum(fieldNum));
        if (headerButton) headerButton.setProperties(properties);
    }
},

//> @method listGrid.setFieldTitle()
// Change the title of a field after the grid is created.
//
// @param fieldNum (integer or String) name of the field, or index.
// @param title (String) new title
// @visibility external
//<
setFieldTitle : function (fieldNum, title) {
    this.setFieldProperties(fieldNum, {title:title});
},


// AutoComplete
// --------------------------------------------------------------------------------------------

//> @method listGrid.setAutoComplete()
// Change the autoCompletion mode for the grid as a whole.
//
// @param   newSetting (AutoComplete)  new setting
// @group autoComplete
// @visibility autoComplete
//<
setAutoComplete : function (newSetting) {
    this.autoComplete = newSetting;
},

//> @method listGrid.setFieldAutoComplete()
// Change the autoCompletion mode for an individual field.
//
// @param   newSetting (AutoComplete)  new setting
// @group autoComplete
// @visibility autoComplete
//<
setFieldAutoComplete : function (field, newSetting) {
    field = this.getField(field);
    if (field) field.autoComplete = newSetting;
},

// --------------------------------------------------------------------------------------------

//>	@method	listGrid.showField()
// Force a field to be shown.<br><br>
//
// NOTE: If a field.showIf expression exists, it will be destroyed.
//
// @param	field           (field name or ListGridField)	field to show
// @param   [suppressRelayout] (boolean) If passed, don't resize non-explicitly sized columns
//                                       to fill the available space.
// @visibility external
// @example columnOrder
//<
showField : function (field, suppressRelayout) {

    arguments.__this = this;

    var fieldObj = field;
	
    // Use getSpecifiedField() to retrieve the fieldObject from the fields / completeFields
    // array.
    // Note that this returns null for an invalid field object / ID
    fieldObj = this.getSpecifiedField(fieldObj);
    
    if (fieldObj == null) {
        this.logWarn("showField(): unable to find field object for field: " + field
                     + ". Taking no action. Call setFields() to add new fields.")
        return;
    }
    
	// -- We always want to clear out any showIf property on the field, as even if the field is
	//    currently being shown, we want the field to continue to be shown from this point on
	//    regardless of any conditions in a showIf property
    if (fieldObj.showIf != null) fieldObj.showIf = null;
    
    var setFieldsCalled = this.completeFields != null    
    if (!setFieldsCalled || this.frozenFields || fieldObj.frozen || this._suppressedFrozenFields) {
        // Frozen fields: with frozen fields, the partial rebuild attempted below doesn't work.
        // This hasn't been looked into in detail yet.
        this.setFields(this.completeFields || this.fields);
        this.fieldStateChanged();
        return;
    } else {
    	// If this.fields. contains the object, we can assume it's already visible if we're drawn
        // and will show up when we get drawn otherwise.
        if (this.fields.contains(fieldObj)) return;
    
    	// update this.fields
        this.deriveVisibleFields();
    }

    var fieldNum = this.fields.indexOf(fieldObj),
        sortFieldNum = this._getSortFieldNum();
    if (sortFieldNum != null && sortFieldNum >= fieldNum) {
        this._setSortFieldNum(sortFieldNum += 1);
    }
    
    // Update any UI to display the new field, if necessary
    

	// create the header button for the new column
    var header = this.header;
    if (header != null) {
        if (!suppressRelayout) this.header.hPolicy = "fill";        
        this.header.addButtons([fieldObj], fieldNum);
    }

	// tell the body about the new field
    if (this.body) {
    	// Increase the editColNum, since the field will have shifted by one
    	// Note: this means we will never be adding an editable cell if editByCell is true
        if (this.getEditCol() != null && this.getEditCol() >= fieldNum) {
            this._editColNum +=1;
        }
        
    	// If we're showing an editor in the new field we need to create the form item for it
    	// (as asserted above - editByCell will always be false here, but continue to check for
    	// it in case of future changes to this logic)
        if (this._editorShowing && !this.editByCell || this.getEditCol() == fieldNum) {
            var editRowNum = this.getEditRow(),
                record = this.getRecord(editRowNum),

                
                editedRecord = this.getEditedRecord(editRowNum),
                width = this.getEditFormItemFieldWidths(record)[fieldNum],
                item = this.getEditItem(fieldObj, record, editedRecord, editRowNum, fieldNum, width)
            ;
            if (item != null) {
            	// Slot the new form item into the edit form at the right position 
                var itemPosition;
                if (this.editByCell) itemPosition = 0;
                else {
                    var allItems = this._editRowForm.getItems();
                    for (var i = 0; i < allItems.length; i++) {
                        var otherItemColNum = allItems[i].colNum;
                        if (otherItemColNum >= fieldNum) {
                        	// remember the index of the first item for a column past the new one
                            if (itemPosition == null) itemPosition = i;
                        	// Shift the colNum on every subsequent item up by 1
                            allItems[i].colNum +=1;
                        }
                    }
                }
            	// Add the new field, if it's in the rendered area of the body.
            	// itemPosition will be un-set if we didn't find a field representing a later
            	// column, so we'd slot the new field on the end, which is correct.
                var drawnRange = this.body.getDrawArea();
                if (this.editByCell || fieldNum >= drawnRange[2] && fieldNum <= drawnRange[3])
                    this._editRowForm.addItems([item], itemPosition);
            }
        }

        this.body.fields = this.normalFields || this.fields;
        this.setBodyFieldWidths(this.getFieldWidths());        
    	// instant redraw rather than markForRedraw because we have to avoid dropping
    	// values
        if (this.body.isDrawn()) this.body.redraw("show field");
    }
        
	// If we have a filterEditor showing, update its fields too
    if (this.filterEditor != null) this.filterEditor.showField(field, suppressRelayout);

    this.fieldStateChanged();
},

//>	@method	listGrid.hideField()
// Force a field to be hidden.<br><br>
//
// NOTE: If a field.showIf expression exists, it will be destroyed.
// 
// @param	field           (field name or ListGridField)	field to hide
// @param [suppressRelayout] (boolean) if passed, don't relayout non-explicit sized fields 
//                                      to fit the available space
// @visibility external
// @example columnOrder
//<
hideField : function (field, suppressRelayout) {

    arguments.__this = this;

    var fieldObj = field;
    // Use getSpecifiedField() to pick up the field object from the completeFields array
    // (or if setFields has never been called, from the fields array).
    // Note - if we're passed an invalid field object, this method returns null.
    fieldObj = this.getSpecifiedField(fieldObj);
    
    if (fieldObj == null) {
        this.logWarn("hideField(): unable to find field object for field: " + field
                     + ". Taking no action. To add this field use the setFields() method.")
        return;
    }
    
	// -- Set showIf to always evaluate to false.
    fieldObj.showIf = this._$false;
    
    // If the field is not currently present in this.fields, we can safely assume it's already
    // hidden. No need to proceed in this case
    if (!this.fields.contains(fieldObj)) {
        return;
    }
    
    var fieldNum = this.fields.indexOf(fieldObj),
        fieldName = this.getFieldName(fieldNum);

	// if we're hiding the sort field, drop this.sortFieldNum
    var sortFieldNum = this._getSortFieldNum();
    if (sortFieldNum == fieldNum) sortFieldNum = null;
    else if (sortFieldNum != null && sortFieldNum > fieldNum) {
        this._setSortFieldNum(sortFieldNum -1);
    }
    
    
    // If setFields has never been called, call it now.
    // This will handle setting up the completeFields array and removing the field from 
    // the fields array, so this is all that needs to happen in this case.
    // Frozen fields: with frozen fields, the partial rebuild attempted below doesn't work.
    // This hasn't been looked into in detail yet.
    if (this.completeFields == null || this.frozenFields) {
        this.setFields(this.completeFields || this.fields);
        this.fieldStateChanged();
        return;
    }
    
    // If necessary, update the UI here, rather than going through 
	// setFields (much more efficient to avoid complete rebuilding of the header, etc).

    
   
   
    // If we're showing an editor we need to make certain changes to get rid of the
    // form item, etc.
    var editorShowing = this._editorShowing;
    if (editorShowing) {
        var editRow = this.getEditRow(),
            editCol = this.getEditCol();

    	// If we're editing by cell, and hiding the current edit cell just kill the edit.
        if (this.editByCell) {
            if (editCol == fieldNum) this.cancelEditing(isc.ListGrid.PROGRAMMATIC);
            editorShowing = false;
        } else {
        
        	// Whatever happens we're going to clear the edit value from the cell being hidden
        	// pass the additional 3rd parameter to avoid re-displaying the record's value
        	// in the (about to be cleared) cell.
            var focusItem = this.getEditFormItem(fieldNum);
            // (Item may not exist due to incremental rendering)
            if (focusItem) focusItem.blurItem();
            this.clearEditValue(editRow, editCol, true);
            
        	// If we're hiding the current edit cell, we need to put focus into a new
        	// edit cell.
            if (editCol == fieldNum) {
                
            	// Try to put focus in an adjacent field - say the previous one
            	// (try going backwards first, then forwards)
                // Extra param to limit to the current row only!
                var newEditCell = this.findNextEditCell(editRow, editCol, -1, 
                                                        true, false, false, true);
        
                if (newEditCell == null || newEditCell[0] != editRow) { 
                    newEditCell = this.findNextEditCell(editRow, editCol, 1, 
                                                        true, false, false, true);
                }
        
            	// If there isn't another editable cell in this row, just cancel the edit
                if (newEditCell == null || newEditCell[0] != editRow) {
                    this.cancelEditing(isc.ListGrid.PROGRAMMATIC);
                    editorShowing = false;
                } else {
                	// focus in the adjacent field.
                    this._startEditing(newEditCell[0], newEditCell[1]);
                }
                
        	// Otherwise update the current edit field number if necessary...
        	// shift the (subsequent) edit colnum back by one, since the field it refers to will 
        	// have moved back by one.
            } else if (this.getEditCol() > fieldNum) {
                this._editColNum -=1;
            }

        }
    }
    	
	// update this.fields
    this.deriveVisibleFields();

	// destroy the header button
    var header = this.header;
    if (header != null) {
        // Setting the hPolicy to "fill" will cause the header to relay it's buttons out to
        // fill the available space.
        if (!suppressRelayout) this.header.hPolicy = "fill";
        var button = this.header.getButton(fieldNum);        
        this.header.removeButtons([button]);
        if (this.headerMenuButton && this.headerMenuButton.masterElement == button) {
            this.headerMenuButton.depeer();
        }
        button.destroy();
    }
    
	// If we're currently showing any edit form items for this subsequent columns,
	// we must decrement their 'colNum' properties.
	// do this *before* we redraw the body, as the body redraw relies on these values being
	// accurate to create new items for fields that get shifted into view.
    if (editorShowing) {
        var form = this._editRowForm,
            items = form.getItems();
        
        for (var i = items.length-1; i >=0; i--) {
            if (items[i].colNum <= fieldNum) break;
            items[i].colNum -=1;
        }
    }

	// tell the body about the new fields
    if (this.body) {
        this.body.fields = this.normalFields || this.fields;
        this.setBodyFieldWidths(this.getFieldWidths());        
    	// instant redraw rather than markForRedraw because we have to avoid dropping
    	// values
        if (this.body.isDrawn()) this.body.redraw("hide field");
    }

    if (editorShowing) {
    	// If we're currently showing an edit form item for this field, remove it now (already
    	// been cleared from the DOM), and had the edit values cleared.
    	// (Note we've already canceled the edit in the editByCell case)
        if (!this.editByCell) {
        	// Hide the actual item if there is one.
            var item = this._editRowForm.getItem(fieldName);
            if (item != null) {
                this._editRowForm.removeItems([item]);
            }
        } 
    }
        
	// If we have a filterEditor showing, update its fields too
    if (this.filterEditor != null) this.filterEditor.hideField(field, suppressRelayout);

    this.fieldStateChanged();
},

//>	@method	listGrid.fieldIsVisible()
// Check whether a field is currently visible
//
// @param	field           (field name or field object)	field to be checked
// @return (boolean) true if the field is currently visible, false otherwise.
// @visibility external
//<
fieldIsVisible : function (field) {
    var fieldObj = field;
	// If passed a field ID, look for it in the completeFields array rather than the fieldsArray
	// as it is may be defined, but not visible    
    if (!isc.isAn.Object(fieldObj)) fieldObj = this.getSpecifiedField(field);

    return this.fields.contains(fieldObj);
},

//> @method listGrid.getTitleField()
// Method to return the fieldName which represents the "title" for records in this
// ListGrid.<br>
// If this.titleField is explicitly specified it will always be used.
// Otherwise, default implementation will check +link{dataSource.titleField} for databound
// grids.<br>
// For non dataotherwise returns the first defined field name of <code>"title"</code>, 
// <code>"name"</code>, or <code>"id"</code>. If we dont find any field-names that match these
// titles, the first field in the grid will be used instead.
// @return (string) fieldName for title field for this grid.
// @visibility external
//<
getTitleField : function () {
    if (this.titleField != null) return this.titleField;
    
    if (this.dataSource != null) {
        var field = this.getDataSource().getTitleField();
        if (!this.getField(field)) field = this.getFields()[0][this.fieldIdProperty];
        
        this.titleField = field;
    } else {
        // if a title field hasn't been explicitly specified, take a guess.
        // Also, remember the guess (this is an inner loop)
        var fieldNames = this.getFields().getProperty(this.fieldIdProperty);
            this.titleField = fieldNames.contains("title") ? "title" :
                          fieldNames.contains("name") ? "name" :
                          fieldNames.contains("id") ? "id" :
                          fieldNames.first();
   }
   return this.titleField;
},

//>	@method	listGrid.setFields()  ([A])
// Sets the fields array and/or field widths to newFields and sizes, respectively.<br><br>
//
// If newFields is specified, it is assumed that the new fields may have nothing in common with
// the old fields, and the component is substantially rebuilt.  Consider the following methods
// for more efficient, more incremental changes: resizeField, reorderField, showField,
// hideField, setFieldProperty.
//
// @visibility external
//
// @param	[newFields]		(List of ListGridField)	array of fields to draw
//<
_$setFields:"set fields",
setFields : function (newFields) {
    
    if (isc._traceMarkers) arguments.__this = this;
    if (!newFields && this.getDataSource() && !this.getDataSource().fields) {
        isc.logWarn('ListGrid.setFields() : neither this ListGrid nor its dataSource have fields');    
    }
    // set boolean images to default checkboxItem images if unset
    if (!this.booleanFalseImage && !this.booleanTrueImage) { 
        this.booleanTrueImage = isc.CheckboxItem ? 
                        isc.CheckboxItem.getInstanceProperty("checkedImage") : null;
        this.booleanFalseImage = isc.CheckboxItem ? 
                        isc.CheckboxItem.getInstanceProperty("uncheckedImage") : null;
        // set imageWidth from checkboxItem.valueIconWidth to avoid images having different sizes
        // when editing and not editing
        this.booleanImageWidth = isc.CheckboxItem ? 
                        isc.CheckboxItem.getInstanceProperty("valueIconWidth") : null;
        this.booleanImageHeight = isc.CheckboxItem ? 
                        isc.CheckboxItem.getInstanceProperty("valueIconHeight") : null;
                    
    }
    // if there is a sortFieldNum set, get a pointer to that field
	// we'll check later to reset the sort if we need to
	var sortFieldNum = this._getSortFieldNum(),
        oldSortField = (sortFieldNum != null && this.fields
                        ? this.fields[sortFieldNum] : null);
    
	// Interaction of setFields() with editing:
	// - If we have editValues for any row(s) [Pending unsaved edits], it is possible that
	//   some of the fields for which we have edit values will go away - in this case we need
	//   to drop those edit values, and any validation errors for those fields.
	// - If we are currently showing an editor for some row, we may also need to update the
	//   fields in the edit form.
	// * We'll drop the removed fields' edit values silently, [log at info level only] - this
	//   is expected / acceptable behavior when fields are removed.
    var editorShowing = this._editorShowing,
        editRowNum = this.getEditRow(),
        editColNum = this.getEditCol(),
        editForm = this._editRowForm,
        oldEditFieldName = this.fields ? this.getEditFieldName() : null
    ;
    
    
	// listGrid.completeFields and listGrid.fields are set to arrays which contain pointers
	// to the same set of "field" objects.
	// - Any fields with a showIf property that evaluates to false will be removed from
	//   this.fields, making it an array of only the list of *visible* fields.
	// - on a reorder or similar manipulation of the set of fields, you should manipulate 
	//   this.completeFields and pass the result to setFields().  Otherwise, you will lose any
	//   fields that aren't visible at the time.
	
    
	

	// on the first setFields() ever, create a new array for the visible fields
    if (this.completeFields == null) this.fields = [];

	// bind the passed-in fields to the DataSource and store
    this.completeFields = this.bindToDataSource(newFields);
    if (this.completeFields == null) this.completeFields = [];

     // checkboxField for selection
    if (this.selectionAppearance == "checkbox" && this.selectionType != "none") {
        var cbField = this.getCheckboxField(), cbPos = this.getCheckboxFieldPosition();
        // make checkboxField frozen if we have any frozen fields
        if (this.completeFields.find("frozen", true)) cbField.frozen = true;
        this.completeFields.addAt(cbField, cbPos);
    }
    // Add / update the removeField if this.canRemoveRecords is true
    if (this.canRemoveRecords) {
        var removeFieldNum = this.completeFields.findIndex("isRemoveField", true),
            removeField = (removeFieldNum >= 0) ? this.completeFields[removeFieldNum] 
                                                : {isRemoveField:true};
        if (!removeField._removeFieldInitialized) {
            
            isc.addProperties(removeField, this.removeFieldDefaults, this.removeFieldProperties);
            if (removeField.name == null) removeField.name = "_removeField";
            if (removeField.cellIcon == null) removeField.cellIcon = this.removeIcon;
            if (removeField.summaryTitle == null) {
                removeField.summaryTitle = this.getRemoveSummaryTitle();
            }
            if (removeFieldNum == -1) {
                this.completeFields.add(removeField);
            }
            
            removeField._removeFieldInitialized = true;
        }
    }
    // sets things up to look up display maps when LG is drawn
    if (isc.DataSource) this._setOptionDataSources();    

    // set field state if necessary
    if (this.fieldState != null) this.setFieldState();
    
	// apply various type-based defaults
    this.applyFieldDefaults(this.completeFields);
    
	// determine which fields should be shown, and add them to the visible fields array
	// (this.fields)
    this.deriveVisibleFields();
    
    // If we have no visible fields, warn the developer in the console
    
    if (this.fields.length == 0) {
        var hasHiddenFields = this.completeFields.length > 0;
        if (!hasHiddenFields) {
            this.logWarn("This component has no specified fields. In order to display data " +
                        "fields must be set up either via an explicit call to setFields() or " +
                        "by binding to a dataSource.");
        // also warn about the gotcha case of all fields being hidden
        } else {
            this.logWarn("All specified fields for this component are hidden. Note that fields " +
                         "may be hidden via 'showIf' or 'detail' attribute values. " +
                         "In order to display data this grid must have some visible fields.");
        }
    }

	// wipe out the cached fieldWidths, if any
    this._fieldWidths = null;

    var newEditColNum, editFieldStillPresent, hadFocus;
	
    if (editorShowing) {
    	// make sure we get the latest value of the field being edited
        // (Not relevant if we're not drawn since the user can't have updated)
        this.storeUpdatedEditorValue();

    	// assume we should continue editing at the field with the same id
        newEditColNum = this.fields.findIndex(this.fieldIdProperty, oldEditFieldName);
        if (newEditColNum != -1 && !this.canEditCell(editRowNum, newEditColNum)) 
            newEditColNum = -1;
        
    	// if the field with same id isn't editable, find the next editable cell
        if (newEditColNum == -1) {
            var newEditCell;
            // extra param to suppress checking past this row            
            if (!this.editByCell) newEditCell = this.findNextEditCell(editRowNum, 0, 1, 
                                                                      true,true, false, true);
            if (newEditCell != null && newEditCell[0] == editRowNum) {
                newEditColNum = newEditCell[1];
            }

        	// Kill the edit if we're editing by cell, or can't find another editable field
        	// in the edit row.
            if (newEditColNum == -1) {
                this.cancelEditing(isc.ListGrid.PROGRAMMATIC);
                editorShowing = false;
            }
        } else {
        	// field with the same name present and editable: blur and refocus after redraw
            var item = editForm.getItem(oldEditFieldName);
            if (item) {
                hadFocus = item.hasFocus;
                if (hadFocus) editForm._blurFocusItemWithoutHandler();
            }
            editFieldStillPresent = true;
        }
        
    	// Hide the editor if still editing.
    	// Note that this will fire a blur handler unless we have already blurred without 
    	// the handler
    	
        if (editorShowing) this.hideInlineEditor(false, true);
    }
    
    var autoCanFreeze = (this.canFreezeFields == null || this._autoDerivedCanFreeze) &&
                        this.fixedRecordHeights != false && this.fixedFieldWidths != false &&
                        this.autoFitData != "horizontal" && this.autoFitData != "both" &&
                        this.bodyOverflow != "visible";
    if (autoCanFreeze) {
        if (this.completeFields.getProperty("overflow").contains("visible")) autoCanFreeze = false;
    }
    if (autoCanFreeze) {
        this._autoDerivedCanFreeze = true;
        this.canFreezeFields = true;
    } else if (this._autoDerivedCanFreeze) {
        delete this._autoDerivedCanFreeze;
        this.canFreezeFields = null;
    }
    
        
	// if we're working with a cellSelection, it needs to know how many columns are visible
    if (this.canSelectCells) this.selection.numCols = this.fields.length;

	// if there is an oldSortField, try to find it in the new fields array
	if (oldSortField) {
        var newSortField = this.fields.indexOf(oldSortField);
        if (newSortField == -1) newSortField = null;
        this._setSortFieldNum(newSortField);
	}

	// if we are showing the header, rebuild it with the new set of fields
    if (this.showHeader && this.headerHeight > 0 && this.header != null) { 
    	// this method will actually update the header to match this.fields
        this.updateHeader();

    	// sync scroll position of new header with current body scroll position
        if (this.body != null) {
            this.syncHeaderScrolling(this.body.getScrollLeft());
        }
    }
        
    this.updateBody();

	// if we've rebuilt the header, this will place it and draw it.
	// this will also determine new field widths for the new fields (whether from the header or
	// otherwise)
    this.layoutChildren(this._$setFields);

	// Now the fields have been set, update the edit values field:
    
	// Update our editValues, and validation errors to account for any fields that have 
	// gone from the list.
    if (this._editSessions != null) {
        var fieldsDropped = {};
        
        for (var i in this._editSessions) {  
            if (this._editSessions[i] == null) continue;
            var vals = this._editSessions[i]._editValues,
            	// We want to hang onto primary key values, even if they're not shown in the
            	// ListGrid
                pks = (this.dataSource != null 
                    ? this.getDataSource().getPrimaryKeyFieldNames()
                    : [])
            ;

            for (var currentFieldName in vals) {
            	
                if (!this.fields.containsProperty(this.fieldIdProperty, currentFieldName) &&
                    !pks.contains(currentFieldName)) {
                	// track which fields were dropped so we can inform the user / developer
                    fieldsDropped[currentFieldName] = true;
                	// clearEditValue will clear the editValue and any validation errors for 
                	// the field
                	// Pass the additional 3rd parameter to avoid refreshing the updated cells
                    
                    this.clearEditValue(vals, currentFieldName, true);
                }
            }
        }
        
        fieldsDropped = isc.getKeys(fieldsDropped);
        if (fieldsDropped.length > 0) {
            this.logInfo("'setFields()' removed the following fields which had pending edit " +
                         "values for some row[s]: '" + fieldsDropped.join("', '") + "'.\n" +
                         "Edit values for these fields have been dropped.", "gridEdit");
        }
    }

	// re-show the editor, with the new set of fields
    if (editorShowing) {
    	// if the previous edit field is still showing, just re-show the editor
    	// and focus silently if appropriate.
        if (editFieldStillPresent) {
        	// 2nd and 3rd parameters are both false - even though this field may be in a
            // new position, it's the same logical field, so we don't want to fire
            // editorEnter()
            this.showInlineEditor(editRowNum, newEditColNum, false, false, true);
            if (hadFocus) editForm._focusInItemWithoutHandler(newEditFieldName);
        } else {
        	// If we've killed the previous edit field, but still want to be editing, use
        	// _startEditing() to start editing the new cell to ensure editValues get set up
            // if necessary
            this._startEditing(editRowNum, newEditColNum, !hadFocus);
        }
        
    	// Refocus without firing the handler if the old edit field is still around and had
    	// focus before the setFields.
        if (hadFocus) {
            var newEditFieldName = this.getEditFieldName();
            if (newEditFieldName == oldEditFieldName) {
                editForm._focusInItemWithoutHandler(newEditFieldName);
            } else {
                editForm.focusInItem(newEditFieldName)
            }
        }
    }
    
	// if we've already been sorted and we can sort, sort the data
	if (this._getSortFieldNum() != null && this.canSort) this.resort();

	// If we have a filterEditor showing, update its fields too
    if (this.filterEditor != null) this.filterEditor.setFields(this.completeFields.duplicate());
},


//> @method ListGrid.getRemoveSummaryTitle()
// When +link{ListGrid.canRemoveRecords} is true, this method returns the title to show for
// the "remove" field in the show/hide columns header menu.
// <P>
// Default implementation returns the +link{ListGrid.removeIcon} followed by
// +link{listGrid.removeSummaryTitle}.
// @visibility external
//<
getRemoveSummaryTitle : function () {
    var removeField = this.completeFields.find("isRemoveField", true) || {};
    return isc.Canvas.imgHTML(this.removeIcon, removeField.iconWidth || removeField.iconSize,
                                                removeField.iconHeight || removeField.iconSize) 
            + "&nbsp;" + this.removeSummaryTitle;
},

//>@method listGrid.focusInFilterEditor()
// If the filter editor (+link{listGrid.showFilterEditor}) is visible for this grid, 
// this method will explictly put focus into the specified field in the filter editor.
// @group filterEditor
// @visibility external
// @param [fieldName] (String) Name of the field to put focus into. If unspecified focus will go
//                             to the first field in the editor
//<
focusInFilterEditor : function (fieldName) {
    if (this.filterEditor == null) return;
    var fieldNum = fieldName != null ? this.getColNum(fieldName) : null;
    this.filterEditor.startEditing(0, fieldNum);
},

//>@method listGrid.filterByEditor()
// If the filter editor (+link{listGrid.showFilterEditor}) is visible for this grid, 
// this method will perform a filter based on the current values in the editor.
// @group filterEditor
// @visibility external
//<
filterByEditor : function () {
    if (this.filterEditor != null) this.filterEditor.performAction();
},


// Override bindToDataSource. Unlike other data-bound widgets if this.showDetailFields is true
// we want to default our detailFields to be hidden (but accessable via the headerContextMenu)
// Note: We do this at init (setFields) time by setting the showIf property on the field,
// rather than overriding fieldShouldBeVisible() to return false for detail fields, so that
// when showField() is called on the field, that method can return true and allow the field
// to show.
bindToDataSource : function (fields, componentIsDetail, a,b,c,d) {
    var completeFields = this.invokeSuper(isc.ListGrid, "bindToDataSource", 
                                          fields, componentIsDetail, a,b,c,d);
    if (this.showDetailFields && completeFields != null) {
        for (var i = 0; i < completeFields.length; i++) {
            if (completeFields[i].showIf == null && completeFields[i].detail == true) {
                completeFields[i].showIf = this._$false;
            }
        }
    }
    return completeFields;
},

// Field State
// --------------------------------------------------------------------------------------------
// The fieldState is an object capturing presentation information about the fields - 
// expected to be used as a way for developers to save the current presentation (EG in cookies)
// and re-load that presentation when the page is reloaded.
// fieldState is an opaque format. 


  
//> @type   listGridFieldState  
// An object containing the stored presentation information for the fields of a listGrid.
// Information contained in a <code>listGridFieldState</code> object includes the 
// visibility and widths of the listGrid's fields.<br>
// Note that this object is a JavaScript string, and may be stored (for example) as a blob 
// on the server for state persistence across sessions.
// 
// @group viewState
// @visibility external
//<

//>	@method	listGrid.getFieldState() 
// Returns a snapshot of the current presentation of this listGrid's fields as 
// a +link{type:listGridFieldState} object.<br>
// This object can be passed to +link{listGrid.setFieldState()} to reset this grid's fields to
// the current state.<br>
// Note that the information stored includes the current width and visibility of each of this 
// grid's fields.
// @group viewState
// @see listGrid.setFieldState();
// @visibility external
// @return (listGridFieldState) current state of this grid's fields.
//<
getFieldState : function () {
    var fieldStates = [];
    if (this.completeFields) {
        var members = this.header.members;
        for (var i = 0; i < this.completeFields.length; i++) {
            var field = this.completeFields[i],
                fieldName = field[this.fieldIdProperty],
                fieldState = {name:fieldName}
            ;
            if (!this.fieldIsVisible(field)) fieldState.visible = false;
            if (members) {
                var member = members.find(this.fieldIdProperty, fieldName);
                if (member && member._userWidth && isc.isA.Number(member._userWidth)) {
                    fieldState.width = member._userWidth;
                }
            }
            fieldStates.add(fieldState);
        }
    }
    
    return isc.Comm.serialize(fieldStates);
},

// Helper method to evaluate the various viewState objects (stored as strings)
evalViewState : function (state, stateName, suppressWarning) {
    //!OBFUSCATEOK    
    if (isc.isA.String(state)) {
        var origState = state;
        try {
            state = isc.eval(state);
        } catch (e) {
            if (!suppressWarning) 
                this.logWarn("Unable to parse " + stateName + " object passed in: " + origState 
                              + " Ignoring.");
            return;
        }
    }
    return state;
    
},

//>	@method	listGrid.setFieldState() 
// Sets some presentation properties (visibility and width) of the listGrid fields based on the
// +link{type:listGridFieldState} object passed in.<br>
// Used to restore previous state retrieved from the grid by a call to +link{listGrid.getFieldState()}.
//
// @group viewState
// @param fieldState (listGridFieldState) state to apply to the listGrid's fields.
// @visibility external
// @see listGrid.getFieldState()
//<
setFieldState : function (fieldState) {
    //!OBFUSCATEOK
    if (this.completeFields == null) return;

    if (fieldState == null && this.fieldState != null) {
        if (isc.isA.String(this.fieldState)) {
            fieldState = this.evalViewState(this.fieldState, "fieldState")
        }
        this._setFieldState(this.fieldState);
        // fieldState is init-only property, so null after use
        this.fieldState = null;
        return;
    }
    

    fieldState = this.evalViewState(fieldState, "fieldState")
    if (fieldState) {
        this._setFieldState(fieldState);
        this.refreshFields();
    }
},

// internal method that modifies this.completeFields according to the fieldState argument
// doesn't redraw the LG; call setFieldState instead.
_setFieldState : function (fieldState) {
    if (fieldState == null) return;

    var remainingFields = this.completeFields.getProperty(this.fieldIdProperty),
        completeFields = []
    ;
    
    // set visibility and width according to fieldState    
    for (var i = 0; i < fieldState.length; i++) {
        var state = fieldState[i],
            field = this.completeFields.find(this.fieldIdProperty, state.name)
        ;
        // if a field is specified in fieldState which is not present in the grid, ignore it
        if (field == null) continue;
        remainingFields.remove(state.name);
        if (state.visible == false) field.showIf = this._$false;
        else field.showIf = null;
        if (state.width != null && !isNaN(state.width)) field.width = state.width;
        completeFields.add(field);
    }
    
    // if a field is specified for the grid for which there is no entry in fieldState
    //   check for a preceding field in the grid's fields which is specified in the fieldState
    //    and put it after that one
    //   otherwise, place it after the last visible field if it's visible, or last field
    //    altogether if not
    for (var i = 0; i < remainingFields.length; i++) {
        var name = remainingFields[i],
            index = this.completeFields.findIndex(this.fieldIdProperty, name),
            field = this.completeFields[index],
            precedingField = this.completeFields[index-1]
        ;
        
        if (precedingField != null) {
            var precedingIndex = completeFields.indexOf(precedingField);
            if (precedingIndex != -1) {
                completeFields.addAt(field, precedingIndex+1);
                continue;
            }
        }
        if (this.fieldShouldBeVisible(field, index)) {
            completeFields.addAt(field, this._lastVisibleFieldIndex(completeFields)+1);
        } else {
            completeFields.add(field);
        }
    }
    
    this.completeFields = completeFields;
},

// returns the last visible field in an array of fields
_lastVisibleFieldIndex : function (fields) {
    if (fields == null) fields = this.completeFields;
    var visibleFields = this.getVisibleFields(fields);
    if (visibleFields.length == 0) return -1;
    return fields.lastIndexOf(visibleFields.last())
},

// observe this method to be notified on column resize or reorder and show/hide field
fieldStateChanged : function () {},

//> @type SelectionAppearance
// How data selection should be presented to the user.
// @value "rowStyle" selected rows should be shown with different appearance - see
//                   +link{ListGrid.getCellStyle()} and optionally
//                   +link{ListGrid.selectionCanvas}.
// @value "checkbox" an extra, non-data column should be automatically added to the ListGrid,
//                   showing checkboxes that can be toggled to select rows.  
//                   See +link{listGrid.getCheckboxField()}.
// @visibility external
//<

// defaults for checkbox field
checkboxFieldDefaults: {
    name: "_checkboxField",
    canEdit: false,
    canGroupBy: false,
    canSort: false,
    _isCheckboxField: true,
    type:"boolean",
    showHeaderContextMenuButton: false
    
},

//> @method listGrid.getCheckboxField()
// Returns the specially generated checkbox field used when +link{selectionAppearance} is
// "checkbox".
// <P>
// Called during +link{setFields()}, this method can be overridden to add advanced dynamic
// defaults to the checkbox field (call Super, modify the default field returned by Super,
// return the modified field).  Normal customization can be handled by just setting
// +link{AutoChild} properties, as mentioned under the docs for +link{listGrid.checkBoxField}.
//
// @return (ListGridField)
// @group checkboxField
//<
// the ammount to add to the icon width to get the checkbox field width
_checkboxFieldWidth: 15,
getCheckboxField : function () {
    var cbField = {};
    isc.addProperties(cbField, this.checkboxFieldDefaults, this.checkboxFieldProperties);
    cbField.valueIconWidth = isc.CheckboxItem.getInstanceProperty("valueIconWidth");
    cbField.valueIconHeight = isc.CheckboxItem.getInstanceProperty("valueIconHeight");
    cbField.width = cbField.valueIconWidth + this._checkboxFieldWidth;
    var trueImage = isc.CheckboxItem.getInstanceProperty("checkedImage"),
        falseImage = isc.CheckboxItem.getInstanceProperty("uncheckedImage");
         
    cbField.title = this.getValueIconHTML(falseImage, cbField);
    // allow icons to be overriden
    if (!cbField.valueIcons) {
        cbField.valueIcons = {
            "true" : trueImage,
            "false" : falseImage
        }
    }
    return cbField;
},

//> @method listGrid.isCheckboxField()
// Identifies whether the passed-in field is the specially generated
// +link{listGrid.checkboxField,checkboxField} used when +link{selectionAppearance} is
// "checkbox".  Use this method in your custom event handlers to avoid inappropriately
// performing actions when the checkboxField is clicked on.
// 
// @param field (ListGridField) field to test
// @return (boolean) whether the provided field is the checkbox field
// @group checkboxField
// @visibility external
//<
isCheckboxField : function (field) {
    if (!field || !field._isCheckboxField) return false;
    else return true;
},

// helper function to get the checkbox field position
getCheckboxFieldPosition : function () {
    if (!this.selectionAppearance == "checkbox") return -1;
    
    return this.isRTL() ? this.completeFields.length - 1 : 0
},

//> @type   listGridSelectedState  
// An object containing the stored selection information for a listGrid.
// Note that this object is not intended to be interrogated directly, but may be stored 
// (for example) as a blob on the server for state persistence across sessions.
// 
// @group viewState
// @visibility external
//<
// listGridSelectedState object is implemented as an array of primaryKeys indicating the 
// selected set of records.

//>	@method	listGrid.getSelectedState() 
// Returns a snapshot of the current selection within this listGrid as 
// a +link{type:listGridSelectedState} object.<br>
// This object can be passed to +link{listGrid.setSelectedState()} to reset this grid's selection
// the current state (assuming the same data is present in the grid).<br>
// @group viewState
// @see listGrid.setSelectedState();
// @visibility external
// @return (listGridSelectedState) current state of this grid's selection
//<
getSelectedState : function () {
    if (!this.selection) return null;
    if (!this.dataSource || 
        isc.isAn.emptyObject(this.getDataSource().getPrimaryKeyFields())) 
    {
        this.logWarn("can't getSelectedState without a DataSource " +
                     "with a primary key field set");
        return null;
    }
    
    var selection = this.selection.getSelection() || [],
        selectedState = [];
    
    // store primary keys only.  Works only with a DataSource
    for (var i = 0; i < selection.length; i++) {
        selectedState[i] = this.getPrimaryKeys(selection[i]);
    }
    
    return isc.Comm.serialize(selectedState);
},

//>	@method	listGrid.setSelectedState() 
// Reset this grid's selection to match the +link{type:listGridSelectedState} object passed in.<br>
// Used to restore previous state retrieved from the grid by a call to 
// +link{listGrid.getSelectedState()}.
//
// @group viewState
// @param selectedState (listGridSelectedState) Object describing the desired selection state of
//                                              the grid
// @see listGrid.getSelectedState()
// @visibility external
//<
setSelectedState : function (selectedState) {
    
    selectedState = this.evalViewState(selectedState, "selectedState")
    if (!selectedState) return;
    
    var selection = this.selection, data = this.data;
    if (data && selection) {
        selection.deselectAll();
        var records = [];
        for (var i = 0; i < selectedState.length; i++) {
            // resultSet.indexOf() looks up by matching PK values
            var index = data.findByKeys(selectedState[i], this.getDataSource());
            // record may have been removed
            if (index != -1) records.add(data.get(index));
        }
        this.selection.selectList(records);
    }
},
    
//> @type   listGridSortState  
// An object containing the stored sort information for a listGrid.
// Note that this object is not intended to be interrogated directly, but may be stored 
// (for example) as a blob on the server for state persistence across sessions.
// 
// @group viewState
// @visibility external
//<
// listGridSortState object is implemented as a simple JS object containing fieldName and sortDir
// attributes


//>	@method	listGrid.getSortState() 
// Returns a snapshot of the current sort state (sort field and order) within this listGrid as 
// a +link{type:listGridSortState} object.<br>
// This object can be passed to +link{listGrid.setSortState()} to reset this grid's sort to
// the current state (assuming the same fields are present in the grid).<br>
// @group viewState
// @see listGrid.setSortState();
// @visibility external
// @return (listGridSortState) current sort state for the grid.
//<
getSortState : function () {
    var sortFieldNum = this._getSortFieldNum(),
        sortField = (sortFieldNum != null ? this.getField(sortFieldNum) : null),
        sortFieldName = sortField != null ? this.getFieldName(sortField) : null,
        sortDir = sortField && sortField.sortDirection != null ? sortField.sortDirection : this.sortDirection;
    // eval() of a string containing object literal text will js error - enclose in "(" ... ")" to 
    // avoid this.
    return "(" + isc.Comm.serialize({fieldName:sortFieldName, sortDir:sortDir}) + ")";
},


//>	@method	listGrid.setSortState() 
// Reset this grid's sort state (sort field and direction) to match the 
// +link{type:listGridSortState} object passed in.<br>
// Used to restore previous state retrieved from the grid by a call to 
// +link{listGrid.getSortState()}.
//
// @param sortState (listGridSortState) Object describing the desired sort state for the grid.
// @group viewState
// @see listGrid.getSortState()
// @visibility external
//<
setSortState : function (state) {
    state = this.evalViewState(state, "sortState")
    if (!state) return;
    
    if (state.fieldName == null) this.unsort();
    else {
        var fieldNum = this.getFieldNum(state.fieldName)
        if (fieldNum != -1) this.sort(fieldNum, state.sortDir);
    }
},

//> @type   listGridViewState  
// An object containing the "view state" information for a listGrid.<br>
// This object contains state information reflecting<br>
// - +link{type:listGridFieldState}<br>
// - +link{type:listGridSortState}<br>
// - +link{type:listGridSelectedState}<br>
// for the grid.<br>
// Note that this object is not intended to be interrogated directly, but may be stored 
// (for example) as a blob on the server for view state persistence across sessions.
// 
// @group viewState
// @visibility external
//<
// listGridViewState object is implemented as a simple JS object containing the following 
// fields:
// - selected [a listGridSelectedState object]
// - field [a listGridFieldState object]
// - sort [a listGridSortState object]

//>	@method	listGrid.getViewState() 
// Returns a snapshot of the current view state of this ListGrid.<br>
// This includes the field state, sort state and selected state of the grid, returned as a
// +link{type:listGridViewState} object.<br>
// This object can be passed to +link{listGrid.setViewState()} to reset this grid's vew state
// to the current state (assuming the same data / fields are present in the grid).<br>
// @group viewState
// @see type:listGridViewState
// @see listGrid.setViewState();
// @visibility external
// @return (listGridViewState) current view state for the grid.
//<    
getViewState : function (returnObject) {
    var state = {
        selected:this.getSelectedState(),
        field:this.getFieldState(),
        sort:this.getSortState()
    };
    // Available so TG can call Super() and get an object back
    if (returnObject) return state;
    return "(" + isc.Comm.serialize(state) + ")";
},

//>	@method	listGrid.setViewState() 
// Reset this grid's view state to match the +link{type:listGridViewState} object passed in.<br>
// Used to restore previous state retrieved from the grid by a call to 
// +link{listGrid.getViewState()}.
//
// @param viewState (listGridViewState) Object describing the desired view state for the grid
// @group viewState
// @see listGrid.getViewState()
// @visibility external
//<
setViewState : function (state) {
    state = this.evalViewState(state, "viewState")
    if (!state) return;
    
    // Order is somewhat important - for example show fields before potentially sorting 
    // by them, etc
    if (state.field) this.setFieldState(state.field);
    if (state.sort) this.setSortState(state.sort);
    if (state.selected) this.setSelectedState(state.selected);
},

// Override setDataSource() - we need to reset the stored filter criteria in case we are
// showing the filterEditor.
setDataSource : function (dataSource, fields) {
    this.Super("setDataSource", arguments);    
    this.clearFilterValues();
    // discard edits as they don't apply to the new DataSource records
    
    this.discardAllEdits();
},

// fieldShouldBeVisible: intended as a possible advanced override point for a field visibility
// policy not easily expressed via showIf()
_$falseSemi:"false;",
_$false:"false",
fieldShouldBeVisible : function (field, fieldNum) {
    // evaluate a showIf expression if present
    if (field.showIf != null) {
        // CALLBACK API:  available variables:  "list,field,fieldNum"
        // Convert a string callback to a function
        
        
        if (field.showIf == this._$false || field.showIf == this._$falseSemi) return false;
        
        isc.Func.replaceWithMethod(field, "showIf", "list,field,fieldNum");
        if (!field.showIf(this, field, fieldNum)) return false;
    }
    return true;
},

// determine which of the passed fields should be shown, and return them as a new array
getVisibleFields : function (fields) {
    var visibleFields = [];
	for (var i = 0; i < fields.length; i++) {
        var field = fields[i];
    	// make sure we don't have any null fields
		if (field == null) continue;

        if (this.fieldShouldBeVisible(field, i)) visibleFields.add(field);
	}
    return visibleFields;
},

// determine which fields should be shown, and add them to the visible fields array.
// (Used as an internal helper - developers should call 'refreshFields' instead)
deriveVisibleFields : function () {
	// NOTE: we use setArray() so that this.fields remains the same array instance.
    this.fields.setArray(this.getVisibleFields(this.completeFields));
    this.deriveFrozenFields();
    this.refreshMasterIndex();
},


//>@method  ListGrid.refreshFields
// Re-evaluates +link{ListGridField.showIf} for each field, dynamically showing and 
// hiding the appropriate set of fields
// @visibility external
//<
refreshFields : function () {
	// Just fall through to 'setFields()' for now
	
    this.setFields(this.completeFields);
},

getFieldWidths : function (reason) {
	// o appropriate time to get field widths:
	// LG w/ header:
	// - initially: right after we draw the header
	// - after setFields() header rebuilt: right after we rebuild the header
	// LG w/o header:
	// - initially: anytime before the body is drawn
	// - after setFields(): anytime before the body is redrawn

    

    var header = this.header;
    if (isc.isA.Layout(header) && header.isDrawn()) {
         // this.logWarn("using header-based field widths");

    	// derive field widths from header sizes
        var sizes = header.getMemberSizes();
        if (this.allowMismatchedHeaderBodyBorder && sizes.length > 0) {
            
            var leftHeaderBorder = header.getLeftBorderSize() + header.getLeftMargin(),
                rightHeaderBorder = header.getRightBorderSize() + header.getRightMargin();
            if (leftHeaderBorder != 0) {
                sizes[0] += leftHeaderBorder;
            }
            
            var totalSize = sizes.sum(),
                overflowAmount = totalSize - header.getInnerWidth();
            if (overflowAmount > 0) {
                sizes[sizes.length-1] += Math.min(overflowAmount, rightHeaderBorder);
            }
        }
    
        if (this.frozenFields) {
            var frozenWidths = this.frozenHeader.getMemberSizes();
            sizes.addListAt(frozenWidths, this.freezeLeft() ? 0 : sizes.length);
        }
        
        return sizes;
        
    } else {
        //this.logWarn("using stretchResize-based field widths");
        return this.getStretchResizeWidths();
    }
},

getStretchResizeWidths : function () {
    if (this.fields == null) return [];

    // no header: derive field widths via stretch resize policy on widths set in fields
    return isc.Canvas.applyStretchResizePolicy(
                this.fields.getProperty("width"), 
                (this.innerWidth != null ? this.innerWidth : this.getAvailableFieldWidth())
                );
},

getAvailableFieldWidth : function () {

    var width = ((this.autoFitData == "both" || this.autoFitData == "horizontal") 
                    ? this.getVisibleWidth() : this.getWidth()) - this.getHMarginBorder();
	// leave a gap for the scrollbar if vertical scrolling is on or if we're configured to
	// always leave a gap
    var leaveGap = this._shouldLeaveScrollbarGap();
    
    if (leaveGap) {
        width -= this.getScrollbarSize();
    }
    return width;
},


//>@method  ListGrid.getFieldWidth()
// Returns a numeric value for the width of some field within this listGrid.
// @param fieldNum (Number | String) Index or fieldName of field for which width is to be determined.
// @return (Number) width of the field in px, or null if the width can't be determined
// @visibility external
//<
getFieldWidth : function (fieldNum) {
    fieldNum = this.getFieldNum(fieldNum);
    if (fieldNum == -1 || !this.fields || fieldNum >= this.fields.length) return null;
    
    if (this.body != null) return this.getColumnWidth(fieldNum);
    return this.getFieldWidths()[fieldNum];
},

_adjustFieldSizesForBodyStyling : function (sizes, vertical) {
    if (vertical == null) vertical = false;
    
    if (sizes == null || sizes.length == 0) return sizes;
    
    
    if (!this.body) {
        
        return sizes;
    }
    
    // Adjust sizes of first and last field to account for styling on the body.
    
    sizes[sizes.length -1] = 
        this._adjustLastFieldForBodyStyling(sizes[sizes.length-1], sizes.sum(), vertical);
    sizes[0] = this._adjustFirstFieldForBodyStyling(sizes[0], vertical);
    
    return sizes;
},

_adjustFirstFieldForBodyStyling : function (size, vertical) {
    if (!this.body) return size;
    
    // always knock the left (or top) border off the first field, otherwise everything starts
    // shifted too far right (or down)
    var bodyStartAdjust = (vertical ? this.body.getTopBorderSize() + this.body.getTopMargin()
                                    : this.body.getLeftBorderSize() + this.body.getLeftMargin());
    if (bodyStartAdjust != 0) size -= bodyStartAdjust;
    
    return Math.max(0, size);
},

_adjustLastFieldForBodyStyling : function (size, totalFieldsWidth, vertical) {
    if (!this.body) return size;

    // Figure out whether all the sizes will expand as far or further than the bottom or right
    // edge. If so we want to knock off the end border from the last col or row.
    var bodyEndAdjust = (vertical ? this.body.getBottomBorderSize() + this.body.getBottomMargin()
                                  : this.body.getRightBorderSize() + this.body.getRightMargin());
    
    if (bodyEndAdjust != 0) {
        
        var overflowAmount = totalFieldsWidth - 
            (vertical ? this.body.getInnerHeight() : this.body.getInnerWidth());
        if (overflowAmount > 0) {
            size -= Math.min(overflowAmount, bodyEndAdjust);
        }
    }
    return Math.max(size,1);
},

setBodyFieldWidths : function (sizes) {

	// set the _fieldWidths array to the list passed in
    this._fieldWidths = sizes;
    
    // adjust the first / last column width for any left/right border or margin on the body.
    
    var origSizes = sizes;
    if (this.allowMismatchedHeaderBodyBorder) {
        if (isc.isAn.Array(sizes)) {
            sizes = this._adjustFieldSizesForBodyStyling(sizes.duplicate());
        }
    }

    // if we have frozenFields, separate out the sizes for those columns
    var frozenFields = this.frozenFields;
    if (frozenFields) {
        var frozenWidths = this.getFrozenSlots(sizes);
        sizes = this.getUnfrozenSlots(sizes);
        //this.logWarn("frozen widths: " + frozenWidths + ", remaining widths: " + sizes);
        this.frozenBody.setColumnWidths(frozenWidths);

        var freezeWidth = frozenWidths.sum();
        // this will automatically cause the main body to size to fill remaining space
        this.frozenBody.setWidth(freezeWidth);
         
        this.frozenBody._userWidth = freezeWidth;
        if (this.frozenHeader) this.frozenHeader.setWidth(freezeWidth);
    }

	// give the GridRenderer new fieldWidths
	// will mark the body for redraw.
    if (this.body != null) this.body.setColumnWidths(sizes);
	// If we're showing the edit form, update the widths of the form items
	
    if (this._editorShowing) {
        var items = this._editRowForm.getItems(),
            record = this.getRecord(this.getEditRow()),

        	// This method gives the widths of form items for every column - since
        	// we only create a subset of form items, we won't use every one.
            
            completeFormFieldWidths = this.getEditFormItemFieldWidths(record);

        for (var i = 0; i < items.length; i++) {
            var colNum = items[i].colNum;

            if (items[i].width != completeFormFieldWidths[colNum]) 
                items[i].setWidth(completeFormFieldWidths[colNum]);
        }
    }
},


// createChildren fired from 'prepareForDraw()'

createChildren : function () {
	// create the header and body
	if (this.showHeader && this.headerHeight > 0 && !this.header) this.makeHeader();
    if (this.showFilterEditor && !this.filterEditor) this.makeFilterEditor();
    this.createBodies();

    
    if (this.header) this.body.moveAbove(this.header);
    if (isc.Browser.isMoz && isc.Browser.geckoVersion >= 20051111) {
        if (this.header) {
            this.body.mozOutlineOffset = "0px";
            if (this.body.mozOutlineColor == null) 
                this.body.mozOutlineColor = this.mozBodyOutlineColor;
        } else {
            if (this.body.mozOutlineColor == null) 
                this.body.mozOutlineColor = this.mozBodyNoHeaderOutlineColor;
            this.body.mozOutlineOffset = "-1px";
        }
    }    
    
    
    this._useNativeTabIndex = false;
},

layoutChildren : function (reason,b,c) {
    
    isc.Canvas._instancePrototype.layoutChildren.call(this, reason,b,c);    
    //this.Super("layoutChildren", arguments);
    
    if (this.body != null) {
        // This method handles resizing the body if necessary
        this._updateFieldWidths(reason, b,c);
        
        // Every time we layout children (may be due to body resize or body scroll change), if
        // we're showing the frozen body, ensure it's the correct (explicit) height
        if (this.frozenBody) {
            var adjustForHScroll = this.shrinkForFreeze && this.body.hscrollOn;
                    
            var height = this.bodyLayout.getInnerHeight();
            if (adjustForHScroll) height -= this.body.getScrollbarSize();
                
            this.frozenBody.setHeight(height);
            // this will avoid the layout from scrapping this specified height on resize etc
            this.frozenBody._userHeight = height;
        }
    }
},


_updateFieldWidths : function (reason, b,c) {
	// don't do anything until we've created our children (eg resized before draw())
    if (this.body == null) return;
    
	

    // wipe out fieldWidths on resize so they'll be recalculated.  
	
    this._fieldWidths = null;
    
    
    var innerWidth = this.getAvailableFieldWidth(),
        innerWidthChanged = (innerWidth != this.innerWidth);
    this.innerWidth = innerWidth;

    //this.logWarn("total columns width: " + innerWidth + 
    //             (this.body ? ", vscrollon: " + this.body.vscrollOn : ""));
    
    var header = this.header,
        headerHeight = (this.showHeader ? this.headerHeight : 0);
    if (header != null) {
        // place the header
        // in RTL, scrollbar is on left
        var left = (this.isRTL() && this._shouldLeaveScrollbarGap() ? this.getScrollbarSize() : 0);            

    	
        header.hPolicy = "fill";
        if (this.frozenHeader) this.frozenHeader.hPolicy = "fill";
        var headerWidth = this.innerWidth;
        
        if (!this.leaveScrollbarGap && header.isDrawn() && 
            headerWidth != header.getWidth() && reason == "body scroll changed") {
        	
        	//this.logWarn("header changing size" + this.getStackTrace());
            if (this._settingBodyFieldWidths || !this.resizeFieldsForScrollbar) {                
                header.hPolicy = "none";
            }
        }
        
        var headerLayout = this.headerLayout || header;
        headerLayout.setRect(left, 0, headerWidth, headerHeight);
    	// if we're in the middle of the initial drawing process, draw the header now so we can
    	// get fieldWidths from it to give to the body before it draws.  Also draw the header
    	// if we're completely drawn and it's undrawn because it was just recreated.
        if (!header.isDrawn() && (reason == "initial draw" || this.isDrawn())) {
            if (!this.frozenFields) {
                header.draw();
            } else {
                // see getFieldWidths for explanation
                var fieldWidths = this.getFieldWidths(),
                    frozenWidths = this.getFrozenSlots(fieldWidths);
                this.frozenHeader.setWidth(frozenWidths.sum());
                this.headerLayout.draw()
            }
        }
        header.hPolicy = "none";
        if (this.frozenHeader) this.frozenHeader.hPolicy = "none";

        if (this.sorter) {
            // move the sorter button over if necessary    
            this.sorter.setLeft(this.getSorterLeft());
            // If this.showSort is unset, the sort button's visibility is determined by
            // leaveScrollbarGap, and whether the body has a vertical scrollbar.
            // This may have changed, so ensure the sorter is visible or hidden as appropriate.
            var showSorter = this._showSortButton();
            this.sorter.setVisibility(
                this._showSortButton() ? isc.Canvas.INHERIT : isc.Canvas.HIDDEN
            );
        }
    }
	// if we haven't figure out field widths, this is the time to get them, since the header
	// has been drawn if we have one, and the body is yet to be drawn.  
	// NOTE: if we are clear()d and then redrawn, and we have a header, we don't want to get
	// sizes from the header while it's undrawn, as it will not run the layout policy while
	// undrawn.
    if ((!this._fieldWidths || innerWidthChanged) &&
        ((header && header.isDrawn()) || headerHeight == 0)) 
    {
        var fieldWidths = this.getFieldWidths(reason);
        this.setBodyFieldWidths(fieldWidths);
        

        // update the filter editor field widths too [only need to worry about the body]
        if (this.filterEditor) {
            // Duplicate the fieldWidths - we don't want the modifications to this item's array
            // to directly impact the record editor's field widths array
            this.filterEditor.setBodyFieldWidths(fieldWidths.duplicate());
        }
        
    	if (this.logIsDebugEnabled("layout")) {
            this.logDebug("new field widths: " + this._fieldWidths, "layout"); 
        }
    }
    
    // We rely on this method to resize the body to fit the available space, but a body resize is 
    // not actually required every time this method runs - frequently the desired body size is
    // unchanged.
    // 
    // If autoFitData is enabled, the body may already be sized larger than the calculated size
    // below (if the data overflows the specified space). In this case resizing back to the
    // specified size, then allowing adjustOverflow to re-fit to data will cause a flash.
    // If the size and space taken up by the data is unchanged, suppress this resize so we
    // don't get this flash (since we'll end up back at the same size anyway).
    //
      
    if (!this._bodyResizeReasons) {
        this._bodyResizeReasons = {}
        this._bodyResizeReasons[this._$resized] = true;
        
        this._bodyResizeReasons[this._$toggleFrozen] = true;
        this._bodyResizeReasons[this._$setFields] = true;
        this._bodyResizeReasons[this._$headerHeightChanged] = true;
        this._bodyResizeReasons[this._$headerVisibilityChanged] = true;
    }
    // if this is the initial rendering of the body we always need to size it out
    // otherwise only resize if we know the size needs to be updated
    var shouldResizeBody = this.autoFitData == null ||
                            !this.body.isDrawn() || 
                            this._bodyResizeReasons[reason];
                            

    if (shouldResizeBody) {
        // how big should we make the body?
        this.bodyHeight = Math.max(1, (this.getInnerHeight() - headerHeight));
        this.bodyWidth = Math.max(1, this.getInnerWidth());
    
        var bodyLayout = this.bodyLayout || this.body;        
        bodyLayout.setRect(0, headerHeight,
                           this.bodyWidth, this.bodyHeight);
        // force an immediate redraw of the body if it's dirty.
        // This allows overflow:visible bodies to resize immediately
        if (this.body.isDirty() && !this.body._redrawing && !bodyLayout._redrawing) {
            bodyLayout.redraw();
        }
    }
        
},

// Override resizePeersBy()
// If we are showing a filterEditor, we want to resize it horizontally to match our size
// Note that RecordEditors are _resizeWithMaster false, so it will not be resized in response
// to the default implementation (appropriate since we don't want it to grow vertically)
resizePeersBy : function (dX, dY,a,b) {
    this.invokeSuper(isc.ListGrid, "resizePeersBy", dX,dY,a,b);
    if (this.filterEditor != null) {
        this.filterEditor.resizeBy(dX, 0);
    }
},

draw : function (a,b,c,d) {
    if (isc._traceMarkers) arguments.__this = this;

	if (!this.readyToDraw()) return this;

    // create children and set up fields if not already set up
    this.prepareForDraw();

	// call the superclass draw routine to do the actual drawing
	this.invokeSuper(isc.ListGrid, "draw", a,b,c,d);
	// get the actual rendered sizes of the columns
	this.body.getColumnSizes();

	// if the sortFieldNum is specified, tell the header about it
    var sortFieldNum = this._getSortFieldNum();
	if (this.header && sortFieldNum != null) this.header.selectButton(sortFieldNum);
	
	// scroll the header along with the list (necessary for textDirection == RTL)
    this.bodyScrolled();
},

prepareForDraw : function () {
	

	// call setFields() for the first time, if it hasn't already been done 
    if (this.completeFields == null) this.setFields(this.fields);

	// create the header and body. 
    this.createChildren();
},

destroy : function (indirectDestroy) {
    if (this._dragLine) {
        this._dragLine.destroy();
        this._dragLine = null;
    }
    if (this._cornerMenu) this._cornerMenu.destroy();
    if (this._spanContextMenu) this._spanContextMenu.destroy();
    if (this.cellContextMenu) this.cellContextMenu.destroy();
    if (this._editRowForm) {
        this._editRowForm.destroy();
        delete this._editRowForm;
        delete this._editorShowing;
    }

	if (this.data){
        // if the data was autoCreated, destroy it to clean up RS<->DS links
        if (this.data._autoCreated && isc.isA.Function(this.data.destroy)) {
            this.data.destroy();
        } else {
            // ignore so we don't leak memory from the observation references
            this._ignoreData(this.data);
            delete this.data;
        }
    }
    if (this.selection) {
        this.destroySelectionModel();
    }
    if (this.selectionCanvas) this.selectionCanvas.destroy();
    if (this.selectionUnderCanvas) this.selectionUnderCanvas.destroy();
    if (this.rollOverCanvas) this.rollOverCanvas.destroy();
    if (this.rollUnderCanvas) this.rollUnderCanvas.destroy();

    this.Super("destroy", arguments);
},

//>	@method	listGrid.redrawHeader()	(A)
//			redraw the header
//		@group	drawing
//<
redrawHeader : function () {
	if (this.header) this.header.markForRedraw();
},

//>	@method	listGrid.getBaseStyle()
// Return the base stylename for this cell.  Has the following implementation by default:
// <ul>
// <li>If +link{listGrid.editFailedBaseStyle, this.editFailedBaseStyle} is defined, and the
//     cell is displaying a validation error return this value.</li>
// <li>If +link{listGrid.editPendingBaseStyle, this.editFailedPendingStyle} is defined, and
//     the cell is displaying an edit value that has not yet been saved (see 
//     +link{ListGrid.autoSaveEdits}) return this value.</li>
// <li>Otherwise return +link{ListGrid.recordBaseStyleProperty, record[listGrid.recordBaseStyleProperty]},
//     if defined, otherwise +link{ListGridField.baseStyle, field.baseStyle}, 
//     or finally +link{ListGrid.baseStyle, this.baseStyle}</li>
// </ul>
//
// @see getCellStyle()
//
// @param	record  (object)	Record associated with this cell. May be <code>null</code>
//                               for a new edit row at the end of this grid's data set.
// @param	rowNum	(number)	row number for the cell
// @param	colNum	(number)	column number of the cell
// @return	(CSSStyleName)	CSS class for this cell
// @visibility external
// @example replaceStyle
//<
getBaseStyle : function (record, rowNum, colNum) {
    
    
    if (this.canEdit == true && !this.isPrinting) {
        if (this.editFailedBaseStyle && this.cellHasErrors(rowNum, colNum))
            return this.editFailedBaseStyle;
    
        if (this.editPendingBaseStyle && this.cellHasChanges(rowNum, colNum, false))
            return this.editPendingBaseStyle;
    }
    
    if (record && this.recordBaseStyleProperty && record[this.recordBaseStyleProperty]) 
        return record[this.recordBaseStyleProperty];
    
    var field = this.getField(colNum);
    if (field && field.baseStyle) return field.baseStyle;
    
    if (field && field.frozen && this.frozenBaseStyle) return this.frozenBaseStyle;
    
    return this.isPrinting ? this.printBaseStyle || this.baseStyle : this.baseStyle;
},

getCellCSSText : function (record, rowNum, colNum) {
    // per-record cssText
    if (record) {
        var cssText = record[this.recordCSSTextProperty];
        if (cssText != null) return cssText;
    }

    var cssText;

    if (this.isEditable()) {
        if (this.editFailedBaseStyle == null && this.editFailedCSSText && 
            this.cellHasErrors(rowNum, colNum)) 
        {
            cssText = this.editFailedCSSText;
        } else if (this.editPendingBaseStyle == null && this.editPendingCSSText && 
            this.cellHasChanges(rowNum, colNum, false)) 
        {
            cssText = this.editPendingCSSText;
        }
    } 
    // support applying a hilite specified on the record
    if (this.hilites && record[this.hiliteProperty] != null) {
        cssText = this.addObjectHilites(record, cssText, this.getField(colNum));
    // support hilites specified in the hilites object
    } else if (this.hilites && record[this.hiliteMarker] != null) { 
        cssText = this.addHiliteCSSText(record, colNum, cssText);
    }
    
    return cssText;

},

//>	@method	listGrid.getRawCellValue()
//		@group	data
//			return the raw data for one particular cell in the list
//
//		@param	record		(object)	a record in the data
//		@param	recordNum	(number)	number of that record (in case it's important for the output)
//		@param	fieldNum	(number)	number of the field to display
//
//		@return	(string)	raw value for this cell
//<

getRawCellValue : function (record, recordNum, fieldNum, isFieldName) {
    var field,
        fieldName;

    if (isFieldName) {
        fieldName = fieldNum
        // when fieldName specified, search completeFields if available
        field = this.completeFields ? isc.Class.getArrayItem(fieldName, this.completeFields, this.fieldIdProperty) : this.getField(fieldName);
    } else {
        field = this.fields[fieldNum];
        fieldName = field[this.fieldIdProperty];
    }
        
    if (fieldName == null) return this.emptyCellValue;
    // Note even if fieldName is set, field is not guaranteed to be present - this could
    // be a displayField which is being rendered in a different field's cell

    var editValue, value, undef;
    
    if (this.rowEditNotComplete(recordNum)) {
        editValue = this._getEditValue(recordNum, fieldNum);
    }
    
    if (editValue !== undef) {
    	// This ensures that the value for the cell as it is currently stored for local editing
    	// is displayed, rather than the saved value of the cell.
    	
        return editValue;
    } else {
		// record can be null if there's no record for this cell
	    if (record == null) return this.emptyCellValue;
	
    	// let the dataset return a value if it supports doing so
        
        if (this.data.getFieldValue && field) {
            value = this.data.getFieldValue(record, fieldName, field);
        } else if (record.ownerDocument && field) {
            // if working with XML, fetch values via XPath selectors if so configured.  (Needed
            // for viewing XML elements when not dataBound, but could be moved to be a built-in
            // feature of both List and native Array)
            value = isc.xml.getFieldValue(record, fieldName, field);
        } else {
            value = record[fieldName];
        }
    }
		
	// if the field has a 'getRawCellValue' attribute
	if (field && field.getRawCellValue) {
		// CALLBACK API:  available variables:  "viewer,record,recordNum,field,fieldNum,value"
		// Convert a string callback to a function
		isc.Func.replaceWithMethod(field, "getRawCellValue", "viewer,record,recordNum,field,fieldNum,value");

		// call it as a function (returns string | null)
		value = field.getRawCellValue(this, record, recordNum, field, fieldNum, value);
	}
	
	return value;
},

//>	@method	listGrid.getCellValue()   ([A])
//          Obtains the display value for a specific cell according to the given input 
//          parameters.<br>
//          To format the value displayed in the cell, make use of the 
//          <code>formatCellValue</code> methods rather than overriding this method directly.
//      @visibility external
//		@group	data
//
//		@param	record		(object)	the current record object
//		@param	recordNum	(number)	number of the record in the current set of displayed 
//                                      record (e.g. 0 for the first displayed record)
//		@param	fieldNum	(number)	number of the field in the listGrid.fields array
//
//      @see    method:ListGrid.formatCellValue
//		@return	(string)	display value for this cell
//<
_$HR:"<HR>",
getCellValue : function (record, recordNum, fieldNum, gridBody) {
	// If we're handed an empty record, we may be looking at a new edit row - if so get
	// the edit values instead
    if (record == null) {
        if (this.showNewRecordRow && this._isNewRecordRow(recordNum)) {
            return this.getNewRecordRowCellValue();
        }
        record = this._getEditValues(recordNum, fieldNum);
    }

	// get the actual data record
	var field = this.fields[fieldNum],
		value = null;

	// if field is null, we've shrunk the number of columns, so forget it
	if (field == null) return "";

    // check if the field is the checkbox field, but don't treat it as such if its a group node
    if (this.isCheckboxField(field) && !record._isGroup) {
        // checked if selected, otherwise unchecked
        var isSel = this.selection.isSelected(record) ? true : false;
        var icon = this.getValueIcon(field, isSel);
        var html =  this.getValueIconHTML(icon, field);
        return html; 
    }
    // Determine whether we should be showing JUST a valueIcon
    // Do this before we figure out other HTML to avoid calculating stuff we're not going to 
    // actually use.
    var icon,
        iconOnly = this.showValueIconOnly(field),
        isEditCell;

	if (record != null) {
		// if it's a separator row, return a horizontal rule
    	
		if (record[this.isSeparatorProperty]) 
            return this._$HR;

        
		if (record[this.singleCellValueProperty] != null) {
            if (record._isGroup) {
                return this.getGroupNodeHTML(record, gridBody);
            } else {
                return record[this.singleCellValueProperty];
            }
        }
        
		if (Array.isLoading(record)) {
            
            if (!isc.Browser.isSafari || fieldNum == 0) {
                // interpret the LOADING marker differently for offline mode
                //>Offline
                if (isc.isOffline()) { 
                    return this.offlineMessage;
                } else {
                //<Offline
                    return this.loadingMessage;
                //>Offline
                }
                //<Offline
            }
            return "&nbsp;";
        }
        
    	// If we are currently editing there are three possibilities for what we should write
    	// out for each cell:
    	// - This cell is being edited -- write out the edit form's element HTML
    	// - This cell has pending edit values, but is not currently being edited.
    	//   (this can happen if we're editing another cell in this row, or if an edit was not
    	//   successfully saved for this cell) -- display the edit values.
    	// - This cell should display the value for the record (default behavior)
    	// We catch the first case here, and write out the edit-form item into the cell if
    	// appropriate.
    	// The other two cases will be handled by 'getRawCellValue()', which will check for
    	// the presence of editValues on a cell.
    	
        isEditCell = (this._editorShowing && this._editRowNum == recordNum && 
                      (!this.editByCell || this._editColNum == fieldNum) &&
                      this.canEditCell(recordNum, fieldNum));
        if (isEditCell) {        
           value = this.getEditItemCellValue(record, recordNum, fieldNum);
        } else {
        
        	// get the value according to the field specification
            var field = this.fields[fieldNum],
                displayFieldValue,
                pickUpDisplayFieldValue;
            
            // If a displayField was specified on the field, and no separate optionDataSource,
            // we should display the value for the record from the displayField rather than the
            // data field.
            if (field.displayField != null) {
                pickUpDisplayFieldValue = !field.valueMap && 
                                          !field.getCellValue && 
                                          this._useDisplayFieldValue(field);
                                          
                if (pickUpDisplayFieldValue) {
                    var displayField = field.displayField;
                    displayFieldValue = this.getRawCellValue(record, recordNum, displayField, true);
                }
                // Note: we still need to proceed through the rest of the logic, since the
                // underlying data value drives the valueIcon
            }
            
            value = this.getRawCellValue(record, recordNum, fieldNum);
            
     		// if the field has a 'getCellValue' attribute
        	// NOTE: this is deprecated - overriding 'getCellValue()' at the Grid level is very
        	// advanced, so for simple formatting (which is likely to be done at either the Field
        	// or Grid level) we provide 'formatCellValue()' methods instead.)
        	// Leave this code in place for Back-compat only.
    
        	//>!BackCompat 2005.1.12
    		if (field.getCellValue) {
    			// CALLBACK API:  available variables:  "viewer,record,recordNum,field,fieldNum,value"
    			// Convert a string callback to a function
    			isc.Func.replaceWithMethod(field, "getCellValue",
                                                 "viewer,record,recordNum,field,fieldNum,value");
    			value = field.getCellValue(this, record, recordNum, field, fieldNum, value);
    		}
        	//<!BackCompat

            
            icon = this.getValueIcon(field, value, record);
          
            // if we're ONLY showing an icon we don't really need to figure out the text from
            // the valueMap.
            if (!iconOnly) {

                // if the field has an 'valueMap' parameter, treat the value as a key in the map
        		var valueMap = field.valueMap;
        		if (valueMap) {
        			// NOTE: this can be really expensive, since we may eval the function that
                    // returns the value map for each record!!!
        			if (isc.isA.String(valueMap)) valueMap = this.getGlobalReference(valueMap);
                    // NOTE: don't look up displayed values in Array valueMaps, which just list legal
                    // values, and don't provide stored->displayed value mappings.
                    if (!isc.isAn.Array(valueMap)) value = isc.getValueForKey(value, valueMap);
        		}
            }
            
            if (pickUpDisplayFieldValue) value = displayFieldValue;
        }
	}
    
    if (!isEditCell) {
        // If this cell isn't showing an editor we may need to write out an icon
        
        var iconHTML = null;
        
        if (icon != null) {                 
            iconHTML = this.getValueIconHTML(icon, field);
            
        }

        if (iconOnly) {
            // If there's no icon write out the empty cell value. This avoids us having
            // un-styled cells.
            if (!iconHTML || isc.isAn.emptyString(iconHTML)) iconHTML = this.emptyCellValue;
            return iconHTML;
        }
        // use formatCellValue() to perform any additional formatting
        value = this._formatCellValue(value, record, field, recordNum, fieldNum);
        
        if (iconHTML) {
            if (field.valueIconOrientation != isc.Canvas.RIGHT)
                value = iconHTML + value;
            else
                value = value + iconHTML;
        }
        
        // Only show error icon HTML if we're not showing an editor for the cell - otherwise
        // we'd get doubled error icons.
        if (this.isEditable() && this.showErrorIcons && this.cellHasErrors(recordNum, fieldNum)) {
            value = this.getErrorIconHTML(recordNum, fieldNum) + value;
        }        
    }
    
    
    return value;
},

getValueIconHTML : function (icon, field) {
    
    var prefix = field.imageURLPrefix || field.baseURL || field.imgDir,
        suffix = field.imageURLSuffix,
        width = this.getValueIconWidth(field),
        height = this.getValueIconHeight(field),
        leftPad = this.getValueIconLeftPadding(field),
        rightPad = this.getValueIconRightPadding(field);
    
    if (suffix != null) icon += suffix;
                    
    var iconHTML = isc.Canvas._getValueIconHTML(icon, prefix, width, height,
                                      leftPad, rightPad,
                                      // no need for an ID
                                      null,
                                      // pass in the LG as an instance - required
                                      // for generating the path of the valueIcon src
                                      this);
    return iconHTML;
},

//>	@method	listGrid.getCellAlign()
// Return the horizontal alignment for cell contents. Default implementation returns 
// +link{listGridField.cellAlign} if specified, otherwise +link{listGridField.align}.
//
// @see getCellStyle()
//
// @param   record (listGridRecord) this cell's record
// @param	rowNum	(number)	row number for the cell
// @param	colNum	(number)	column number of the cell
// @return	(string)     Horizontal alignment of cell contents: 'right', 'center', or 'left'	
// @visibility external
//<
getCellAlign : function (record, rowNum, colNum) {
    
    // single cells will be aligned left by default
    if (record && (record[this.singleCellValueProperty] != null)) {  
        return isc.Canvas.LEFT;
    }
    var fieldNum = colNum;
    // Adjust for the mismatch between printed fields and this.fields
    if (this.isPrinting) {
        for (var i = 0; i < colNum; i++) {
            if (this.fields[i].shouldPrint == false) {         
                fieldNum +=1;
            }
        }
    }
    var field = this.fields[fieldNum];
    
    return (field.cellAlign || field.align);
    
},

//>	@method	listGrid.getCellVAlign()
// Return the vertical alignment for cell contents.
// Expected values are: 'top', 'center', or 'bottom'
//
// @see getCellStyle()
//
// @param   record (listgridRecord) this cell's record
// @param	rowNum	(number)	row number for the cell
// @param	colNum	(number)	column number of the cell
// @return	(string)     Vertical alignment of cell contents: 'right', 'center', or 'left'	
// @visibility external
//<
// Unset by default


// Helper method: 
// If a displayField was specified on some field, and no separate optionDataSource,
// we should display the value for the record from the displayField rather than the data field.
_useDisplayFieldValue : function (field) {
    return field && field.displayField && 
           (!field.optionDataSource || 
            isc.DS.get(field.optionDataSource) == this.getDataSource());
},                                            

// Value Icons
// ---------------------------------------------------------------------------------------

_valueIconStyleTemplate:[
    "style='margin-left:",  // [0]
    ,                       // [1] - icon padding
    "px;margin-right:",     // [2]
    ,                       // [3] - icon padding
    "px;'"
],

//> @method ListGrid.getValueIcon()
// Returns the appropriate valueIcon for a cell based on the field and the data value for the 
// cell. Default implementation returns null if +link{ListGridField.suppressValueIcon} is true
// otherwise looks at +link{ListGridField.valueIcons}.
// @param field (ListGridField) field associated with the cell
// @param value (any) data value for the cell's record in this field.
// @param record (ListGridRecord) record associated with this cell
// @group imageColumns
// @visibility external
//<
getValueIcon : function (field, value, record) {
    if (!field.valueIcons || field.suppressValueIcon) {
        if (this._formatBooleanFieldAsImages(field)) {
            var img = (value ? this.booleanTrueImage : this.booleanFalseImage); 
            // If no image was specified, still write out a blank gif into the slot - this
            // allows us to recognize events over the (invisible) icon for canToggle behavior
            if (img == null) img = isc.Canvas.getImgURL(isc.Canvas._blankImgURL);
            return img;
        }
        return null;
    }
    var icon = field.valueIcons[value];
    return icon;
},

// Helpers to get padding on each side of a field's valueIcon
getValueIconLeftPadding : function (field) {
    return (field && field.valueIconLeftPadding != null ? field.valueIconLeftPadding 
            : this.valueIconLeftPadding || 0);
},

getValueIconRightPadding : function (field) {
    return (field && field.valueIconRightPadding != null ? field.valueIconRightPadding 
            : this.valueIconRightPadding || 0);
},

// showValueIconOnly - returns true if the valueIcon should be displayed without any 
// text value for some field.
_$boolean:"boolean",
showValueIconOnly : function (field) {
    if (field.showValueIconOnly != null) return field.showValueIconOnly;
    // If we have a valueIcons map, with no vmap, return text AND icon
    // if we have both valueIcons and a vmap, return just the icon
    // if we have no icon map, obviously return text (and icon, which is null)
    if (field.valueIcons != null && field.valueMap != null) return true;
    
    // If we are looking at a boolean field for which we want to show just the checkbox images
    // return true - otherwise false
    return this._formatBooleanFieldAsImages(field);

},

//> @method ListGrid.getValueIconWidth()
// If some field is showing valueIcons, this method returns the width those items should render
// Default implementation derives this from the first specified of 
// +link{ListGridField.valueIconWidth}, +link{ListGridField.valueIconSize}, 
// +link{ListGrid.valueIconWidth}, or +link{ListGrid.valueIconSize}
// @param field (object) field for which we're retrieving the valueIcon width
// @return (number) width for the icon
// @group imageColumns
// @visibility internal
//<
getValueIconWidth : function (field) {
    if (this._formatBooleanFieldAsImages(field)) return this.booleanImageWidth;

    return (field.valueIconWidth != null ? field.valueIconWidth  :
                (field.valueIconSize != null ? field.valueIconSize : 
                    (this.valueIconWidth != null ? this.valueIconWidth : this.valueIconSize)));
},

//> @method ListGrid.getValueIconHeight()
// If some field is showing valueIcons, this method returns the height those items should render
// Default implementation derives this from the first specified of 
// +link{ListGridField.valueIconHeight}, +link{ListGridField.valueIconSize}, 
// +link{ListGrid.valueIconHeight}, or +link{ListGrid.valueIconSize}
// @param field (object) field for which we're retrieving the valueIcon height
// @return (number) height for the icon
// @group imageColumns
// @visibility internal
//<
getValueIconHeight : function (field) {
    if (this._formatBooleanFieldAsImages(field)) return this.booleanImageHeight;
    
    return (field.valueIconHeight != null ? field.valueIconHeight  :
                (field.valueIconSize != null ? field.valueIconSize : 
                    (this.valueIconHeight != null ? this.valueIconHeight : this.valueIconSize)));
},

// New record row: optional special row added to encourage new record entry
// ---------------------------------------------------------------------------------------

_isNewRecordRow : function (recordNum) {
    return this.showNewRecordRow && (recordNum == this.getTotalRows()-1);
},

//> @method  ListGrid.getNewRecordCellValue()
//  Returns the contents to display in the new record row.
//  Note that this row displays a single cell spanning every column.
//  @return (string)    Value to display in new record row. Default 
//                      implementation returns <code>"-- Add New Row --"</code>
//<
getNewRecordRowCellValue : function () {
    return '<div align="center">' + this.newRecordRowMessage + '</div>';
},

// ---------------------------------------------------------------------------------------
getErrorIconHTML : function (rowNum, colNum) {
    var errors = this.getCellErrors(rowNum, colNum);
    if (errors == null) return isc._emptyString;

    
    var promptString = "title='",
        errorString = isc.FormItem.getErrorPromptString(errors, true);
    
    promptString += errorString + "'";
    
    var HTML = this.imgHTML(this.errorIconSrc, this.errorIconWidth, this.errorIconHeight, null, 
                             promptString);
    // Since we're writing the icon out to the left of our content, write a spacer out to the
    // right of the image to give us some padding between the image and the cell content
    
    if (isc.Browser.isIE && this._editorShowing && this.getEditRow() == rowNum && 
        (!this.editByCell || this.getEditCol() == colNum)) {
        HTML += " ";
    } else {
        
        HTML += isc.Canvas.spacerHTML(this.cellPadding, "auto");
    }
    return HTML;

},

// _formatCellValue: Helper method to format the static cell value using developer defined
// formatCellValue() methods.
_$text:"text",
_formatCellValue : function (value, record, field, rowNum, colNum) {

    if (field && field.formatCellValue != null) {
        value = field.formatCellValue(value,record,rowNum,colNum,this);
    } else if (field && field.cellValueTemplate) {
        // NOTE: 
        // - probably don't need grid.cellValueTemplate, as this would be rare
        // - not exposed publicly yet
        // - might want XSLT option
        value = field.cellValueTemplate.evalDynamicString(this, {
                    value:value, record:record, field:field});
    // listGrid-wide formatter
    } else if (this.formatCellValue != null) {
        value = this.formatCellValue(value, record, rowNum, colNum);
    
    // check for formatter defined on a SimpleType definition
    } else if (field && field._shortDisplayFormatter != null) {
        value = field._simpleType.shortDisplayFormatter(value, field, this, record, rowNum, colNum);

    // We apply some standard (default) formatters to fields with particular data types.
    // NOTE: these should be moved to the built-in SimpleType definitions
    } else if (field && field._typeFormatter != null) {
        value = field._typeFormatter(value, field, this, record, rowNum, colNum);
    }

	// Further conversions to ensure that the value displays correctly in the cell:
    
	// For "empty" values, write out the emptyCellValue
    
	if (value == null || isc.is.emptyString(value)) {
		// if the field specifies a 'emptyCellValue' 
		if (field.emptyCellValue != null) {
			// return the field-specific value
			value = field.emptyCellValue;
		} else {
			// otherwise return the emptyCellValue for the entire list
			value = this.emptyCellValue;
		}
        
    // In IE, an element containing only whitespace characters (space or enter) will not show css
    // styling properly.
    
    } else if (this._emptyCellValues[value]) {
        value = this._$nbsp;
	// convert the value to a string if it's not already        
	} else if (!isc.isA.String(value)) {
        
        value = isc.iscToLocaleString(value);
    }

	return value;
},
// these Strings can be considered to be "empty" cells, causing bad styling.  Replace with
// '&nbsp;'

_emptyCellValues:{" ":true, "\n":true, "\r":true, "\r\n":true},
_$nbsp:"&nbsp;",

//>	@method     listGrid.getEditItemCellValue()   ([IA])
//          Returns the HTML for a cell within a row that is being edited (as a result of a call
//          to 'editRow')<br>
//          Will <i>not</i> call 'updateEditRow()' to update the values displayed in the edit
//          row - this must be handled by calling methods, once we know the form element has
//          been written into the DOM.
//      @visibility internal
//		@group	editing
//
//      @param  record      (object)    the current record object
//      @param  rowNum      (number)    index of the record containing this cell
//      @param  colNum      (number)    index of the field containing this cell
//
//		@return	(string)	display value for this cell
//<
getEditItemCellValue : function (record, rowNum, colNum) {
    var itemName = this.getEditorName(rowNum, colNum);

	// Write a form item out into this cell.
	// We have already created the '_editRowForm' - a dynamic form with an appropriate set of
	// form items (see 'editRow').
	// Make use of the appropriate item's getStandaloneHTML() to write out the form element
    
    // If we have any errors for the field, set them on the form item too so the error icon
    // gets rendered out
    var errors = this.getCellErrors(rowNum, colNum);
    if (errors) {
        this._editRowForm.setFieldErrors(itemName, errors);
    }

	// get the HTML for the form item
	// Relies on the form item being present - this is fine as long as our logic to create
	// and remove edit form items for incremental rendering stays in synch with the set of 
	// cells being written out.    
    var item = this._editRowForm.getItem(itemName),    
        HTML = item.getStandaloneItemHTML(false, true);

    // once we've retrieve the HTML, clear the errors so if we re-render the form for another item
    // etc, we don't end up with errors hanging around
    if (errors) {
        this._editRowForm.setFieldErrors(itemName, null);
    }
    
	
    var body = item.containerWidget;
    if (!body._drawnEditItems) body._drawnEditItems = [];   
    if (!body._drawnEditItems.contains(item)) {
        body._drawnEditItems.add(item);
    }

    return HTML;
},

// _editItemsDrawingNotification - function to notify the edit row form items when they are
// drawn, cleared or redrawn.

_editItemsDrawingNotification : function (item, fireMoved, gr) {
    
    var items;
    if (item) items = [item];
    else {
        items = [];
        var allItems = this._editRowForm.getItems();
        for (var i = 0; i < allItems.length; i++) {
            if (allItems[i].containerWidget == gr) items.add(allItems[i]);
        }
    }   
    var newlyDrawnItems = gr._drawnEditItems;

    for (var i = 0; i < items.length; i++) {
        var currentItem = items[i],
            wasDrawn = currentItem.isDrawn(),
            isDrawn = newlyDrawnItems ? newlyDrawnItems.contains(currentItem) : false,
            isCanvasItem = isc.CanvasItem && isc.isA.CanvasItem(currentItem);
        if (wasDrawn) {
            if (isDrawn) {
                currentItem.redrawn();
                // Redraw of the body will frequently result in repositioning the edit cells.
                // Fire the 'moved' handler on any visible form items that were present before
                // the redraw to notify them of being moved.
                
                if (fireMoved) currentItem.moved();
            }
            else {
                currentItem.cleared();
            }
            
        } else if (isDrawn) {
            if (isCanvasItem) currentItem.placeCanvas();
            currentItem.drawn();
        }    
    }
            
    // Get rid of the _drawnEditItems. Next time this method is run we only want to catch 
    // items which have subsequently been drawn
    delete gr._drawnEditItems;
},


//>	@method	listGrid.setRawCellValue()
//		@group	data
//			Set the raw data for one particular cell in the list.
//
//		@param	record		(object)	record in question
//		@param	recordNum	(number)	number of that record
//		@param	fieldNum	(number)	number of the field to display
//		@param	newValue	(any)		new value
//
//<
// Overridden at the cubeGrid level to handle being passed an entire record rather than a single
// field value for the cell
setRawCellValue : function (record, recordNum, fieldNum, newValue) {

	var field = this.fields[fieldNum];
	// if record or field is null, we're dealing with an invalid column, so forget it
	if (!record || !field) return;
	// if the field has a 'setRawCellValue' attribute
	// We'll assume this DIRECTLY sets the value on the LG's data object, so we're basically done 
	// at this point (other than firing dataChanged below to ensure everything gets updated 
	// visually)
	if (field.setRawCellValue) {
		// CALLBACK API:  available variables:  "viewer,record,recordNum,field,fieldNum,value"
		// Convert a string callback to a function
		isc.Func.replaceWithMethod(field, "setRawCellValue", "viewer,record,recordNum,field,fieldNum,value");

		// call it as a function (returns string | null)
		field.setRawCellValue(this, record, recordNum, field, fieldNum, newValue);
        
	// otherwise just use the cells value in the normal way
	} else {

    	// set the value according to the field specification
        record[field[this.fieldIdProperty]] = newValue;
    }    

	// HACK: fire dataChanged() by hand.  Really, we need an interface to update fields on
	// objects in the List so the List can recognize the change and fire dataChanged() itself
    this.data.dataChanged();
},

//>	@method	listGrid.getCellBooleanProperty()	(A)
//  Given a property name, and a cell, check for the value of that property (assumed to be a 
//  boolean) on the ListGrid, and the cell's field, returning false if the value is false at 
//  either level.
//  If true at the ListGrid and Field level, check the value of the the second "recordProperty"
//  on the record object for the cell.
//  (If recordProperty is not passed, the record object will not be examined).
//
//	@param	property	(string)	Name of the property to look for.
//	@param	rowNum	(number)	Row number of the cell.
//	@param	colNum	(string)	Field number for the cell.
//  @param  [recordProperty]    (string)    Name of the equivalent property to check on the
//                                          record object 
//
//	@return	(boolean)	true == at least one is true and none are false
//
//<

_$false:"false", _$true:"true",
getCellBooleanProperty : function (property, recordNum, fieldNum, recordProperty) {
	var trueFound = false,
		listValue = this[property]
	;
	if (listValue == false || listValue == this._$false) return false;

	var fieldValue = this.fields[fieldNum][property];
	if (fieldValue == false || fieldValue == this._$false) return false;
    
    if (recordProperty != null) {

    	var record = this.getRecord(recordNum, fieldNum),
	    	recordValue = (record != null ? record[recordProperty] : false)
    	;
    	if (recordValue == false || recordValue == this._$false) return false;
        if (recordValue == true || recordValue == this._$true) return true;
    }
	
	// At this point we know none of the values was an explicit false - but we only want to 
	// return true if the value was specified as true (rather than undefined) at some level.
	// We've already checked at the record level (if necessary)
	return (listValue == true) || (fieldValue == true) ||
            (listValue == this._$true) || (fieldValue == this._$true);
},


// ---------------------------------------------------------------------------------------

getDrawArea : function () {
    if (this.body) return this.body.getDrawArea();
    
    return null;
},

// notification from each body when getInnerHTML is called.
bodyDrawing : function (body) {
    if (isc._traceMarkers) arguments.__this = this;

    if (this._fetchValueMap) {
        // fetch valueMaps for fields where optionDataSource is set
        var startedQueue = !isc.RPCManager.startQueue();
        
        for (var optionDS in this._optionDataSources) {
            var fields = this._optionDataSources[optionDS].fields,
                outputs = this._optionDataSources[optionDS].outputs,
                ds = isc.DataSource.getDataSource(optionDS)
            ;
            ds.fetchData({}, {target:this, methodName:"_fetchValueMapCallback"},
                         {clientContext:{fields:fields}, 
                          parameters:{outputs:outputs.getUniqueItems()}});
        }
    }
    
    this.requestVisibleRows();
    
    if (this._fetchValueMap) {
        if (startedQueue) isc.RPCManager.sendQueue();
        this._fetchValueMap = null;
    }
},

// ListGridField.optionDataSource handling
// ---------------------------------------------------------------------------------------

// _setOptionDataSources()
// iterate through the list of fields and take note of optionDataSource property to look up the
// display map later when the LG is drawn (see bodyDrawing)
_setOptionDataSources : function () {
    // check for optionDataSource property on fields and store the list of datasources to retrieve
    // if any are found; store in this._optionDataSources in the following format:
    // { optionDSName : { fields:[list of LG fields using optionDS],
    //                    outputs:[list of display and value fields] } }
    this._fetchValueMap = null;
    this._optionDataSources = {};
    var gridDS = this.getDataSource();
    for (var i = 0; i < this.completeFields.length; i++) {
        var field = this.completeFields[i];
        // autoFetchDisplayMap can be set at the field or LG level
        if (field.optionDataSource == null || field.autoFetchDisplayMap == false ||
            (this.autoFetchDisplayMap == false && field.autoFetchDisplayMap == null))
        {
            continue;
        }
        
        var optionDS = isc.DS.get(field.optionDataSource);
        if (optionDS == null) {
            this.logWarn(field.optionDataSource + " dataSource not found, check value of " +
                         "optionDataSource property on the " + field[this.fieldIdProperty] +
                         " field");
            continue;
        // If the optionDataSource is explicitly specified as the grid's dataSource,
        // don't fetch a custom valueMap for it. Instead we just use the value of the 
        // displayField for the record.
        } else if (optionDS == gridDS) continue;
 
        var optionDSID = optionDS.ID;
       
        // set flag to trigger fetches when we draw
        this._fetchValueMap = true;
        // add this field to the list of result sets to retrieve
        if (this._optionDataSources[optionDSID] != null) {
            var context = this._optionDataSources[optionDSID];
            context.fields.add(field);
            context.outputs.add(field.displayField);
            context.outputs.add(field.valueField);
        } else {
            var context = this._optionDataSources[optionDSID] = {};
            context.fields = [field];
            context.outputs = [field.displayField, field.valueField];
        }
    }
},

// _fetchValueMapCallback()
// Callback from request to get all data from some field's optionDS.
// Creates a valueMap so we show the displayField value in the field
_fetchValueMapCallback : function (dsResponse, data, dsRequest) {
    var fields = dsRequest.clientContext.fields;

    for (var i = 0; i < fields.length; i++) {
        var field = fields[i];

        this.setValueMap(field[this.fieldIdProperty],
                         data.getValueMap(field.valueField, field.displayField));
    }
    return true;
},

requestVisibleRows : function () {
	// ask for all the rows we're about to render.  This enables better predictive fetching
    // relative to asking for data one row at a time while we render.
	
    if (isc.ResultSet && isc.isA.ResultSet(this.data)) {

        if (this.body == null) return this.data.getRange(0);
        // if the data set is empty no need to fetch
        if (this.data.lengthIsKnown() && this.data.getLength() == 0) return;

        
        if (!this.data.lengthIsKnown()) {
            this.body.showAllRows = false;
        } else {
            // NOTE: this check is necessary because the body itself forces showAllRows to true
            // on init if overflow:visible.  It would probably be more robust to pass a
            // one-time flag to getTableHTML() so that we don't clobber other changes to
            // showAllRows
            this.body.showAllRows = (this.body.overflow == isc.Canvas.VISIBLE ? 
                                     true : this.showAllRecords);
        }

        var drawRect = this.body.getDrawArea(); 
        
        // force all rows to be grabbed if we're grouping. (We'll need them anyway.)
        if (this.isGrouped) {
            return this.data.getRange(0, this.groupByMaxRecords);
        } else {
            return this.data.getRange(drawRect[0], drawRect[1]);
        }
    }
    return null;
},

// Printing
// --------------------------------------------------------------------------------------------
                  
//>	@attr listGrid.printAutoFit (boolean : true : IRW)
// Whether cell contents should wrap during printing.  Equivalent to +link{autoFit}, but
// specific to printed output.
// @group printing
// @visibility printing
//<
printAutoFit:true,

//>	@attr listGrid.printWrapCells (boolean : true : IRW)
// Whether cell contents should wrap during printing.  Equivalent to +link{wrapCells}, but
// specific to printed output.
// @group printing
// @visibility printing
//<
printWrapCells:true,

//>	@attr listGrid.printHeaderStyle (CSSStyleName : "printHeader" : IRW)
// Style for header cells in printed output.  Defaults to +link{headerBaseStyle} if null.
// @group printing
// @visibility printing
//<
printHeaderStyle:"printHeader",			

//>	@attr listGrid.printBaseStyle (CSSStyleName : null : IRW)
// Style for non-header cells in printed output.  Defaults to +link{baseStyle} if null.
// @group printing
// @visibility printing
//<			

getPrintHeaders : function (startCol, endCol) {
    var output = isc.SB.create();
    output.append("<TR>");
    var defaultAlign = (this.isRTL() ? isc.Canvas.LEFT : isc.Canvas.RIGHT);
	for (var colNum = startCol; colNum < endCol; colNum++) {
        var field = this.body.fields[colNum];
        var align = field.align || defaultAlign;
        output.append("<TD CLASS=", (this.printHeaderStyle || this.headerBaseStyle), 
                       " ALIGN=", align, ">",
                      this.getHeaderButtonTitle(field.masterIndex), "</TD>");
    }
    output.append("</TR>");
    return output.toString();
},

getPrintHTML : function (printProperties, callback) {

    

    var body = this.body;
    // we may have getPrintHTML called while we're undrawn - if we'll need to set up our children
    // here
    if (body == null) {
        this.createChildren();
        body = this.body;
    }
    
    // if the body is pending a redraw, force it now
    if (this.isDirty() || body.isDirty()) {
        this.redraw("updating HTML for printing");
    }
    
    var printProps = isc.addProperties({}, printProperties, this.printProperties);

    // with a partial cache, print only the contiguous cache around the currently visible rows
    
    var startRow, endRow;
    if (isc.isA.ResultSet(this.data) && !this.data.allMatchingRowsCached()) {            
        var visRows = this.body.getVisibleRows(),
            firstVisibleRow = visRows ? visRows[0] : null,
            cachedRange = this.data.getCachedRange(firstVisibleRow);            
        if (cachedRange != null) {
            startRow = cachedRange[0];
            endRow = cachedRange[1];
        }        
    }
    
    
    var printWidths = isc.Canvas.applyStretchResizePolicy(this.fields.getProperty("width"), 
                                                printProps.width || isc.Page.getWidth());
    
    var totalRows = endRow != null ? (endRow - startRow) : this.getTotalRows(),
        maxRows = this.printMaxRows;        
    
    if (maxRows < totalRows) {
        if (startRow == null) startRow = 0;
        if (endRow == null) endRow = this.getTotalRows();     
        this.getPrintHTMLChunk(
            {startRow:startRow, endRow:endRow, maxRows:maxRows, callback:callback,
                printWidths:printWidths, printProps:printProps}
        );
        
        return null;
    }

    var suspendPrintingContext = this._prepareForPrinting(printWidths, printProps);
    
    var printHTML = body.getTableHTML(null, startRow, endRow);
    // restore settings
    this._donePrinting(suspendPrintingContext);

 
    return printHTML;
},

_prepareForPrinting : function (printWidths, printProperties) {
    
    this.isPrinting = this.body.isPrinting = true;
    this.currentPrintProperties = printProperties;
    
    var body = this.body,
        // don't print editors?
        oldEditorShowing = this._editorShowing;
    
    // properties to store off and restore
    var origProps = isc.getProperties(body, ["autoFit", "wrapCells", "showAllRows",
                                "showAllColumns", "fixedRowHeights", "_fieldWidths", "fields"]);                                             

    body.showAllRows = true;
    body.showAllColumns = true;
        
    this._editorShowing = false; // never show editors
    body.autoFit = this.printAutoFit;
    body.wrapCells = this.printWrapCells;
    body.fixedRowHeights = !this.printWrapCells;

    var fields = this.fields.duplicate();
    // suppress rendering out the shouldPrint fields
    fields.removeAll(fields.findAll("shouldPrint", false));
    body.fields = fields;
    
    
    body._fieldWidths = printWidths;
    return {oldEditorShowing:oldEditorShowing, origProps:origProps};                                                

},

_donePrinting : function (context) {    
    var body = this.body,
        origProps = context.origProps,
        oldEditorShowing = context.oldEditorShowing;
        
    isc.addProperties(body, origProps);
    if (origProps.showAllRows == null) body.showAllRows = null;
    this._editorShowing = oldEditorShowing;
    delete this.currentPrintProperties;
    

    this.isPrinting = this.body.isPrinting = false;
},

//> @attr ListGrid.printMaxRows (integer : 200 : IRWA)
// Advanced property - when generating printHTML for this ListGrid, every row in the grid will be
// written out. For very large grids, generating this HTML in a single thread can cause the native
// "Script Is Running Slowly" dialog to appear in some browsers. Therefore the HTML generation is
// split into separate browser threads. This property governs how many rows' HTML is generated at
// a time.
// @visibility printing
//<
// Note that this means getPrintHTML() is frequently asynchronous for ListGrids
printMaxRows:200,
getPrintHTMLChunk : function (context) {
    
    var suspendPrintingContext = this._prepareForPrinting(context.printWidths);
    // printing chunk flag - used by the GR to avoid writing out the outer table tags for each
    // chunk.
    this.body._printingChunk = true;
    
    var startRow = context.startRow, 
        endRow = context.endRow, 
        maxRows = context.maxRows, 
        callback = context.callback;

    this.currentPrintProperties = context.printProps;
        
    if (!context.html) context.html = [];
        
    var chunkEndRow = Math.min(endRow, (startRow + maxRows)),
        chunkHTML = this.body.getTableHTML(null, startRow, chunkEndRow);

    context.html.add(chunkHTML);        
    
    // restore settings
    this._donePrinting(suspendPrintingContext);
    this.body._printingChunk = false;
    
    if (chunkEndRow < endRow) {
        context.startRow = chunkEndRow;
        return this.delayCall("getPrintHTMLChunk", [context], 0);
    }
    if (callback) {
        var html = context.html.join(isc.emptyString);
        this.fireCallback(callback, "HTML,callback", [html,callback]);
    }
    
    
    
},



// Event Handling
// --------------------------------------------------------------------------------------------

//>	@method	listGrid.rowClick()	(A)
//
// Event handler for when rows in the body are clicked upon. The default implementation handles
// firing +link{ListGrid.startEditing()} if appropriate, and fires
// +link{ListGridField.recordClick()} and/or +link{ListGrid.recordClick()} if set. Developers
// should typically implement recordClick rather than overriding this method.
//
//      @param  record      (ListGridRecord)    record object returned from getCellRecord()
//		@param	recordNum   (number)	index of the row where the click occurred
//		@param	fieldNum	(number)	index of the col where the click occurred
//      @param  [keyboardGenerated]   (boolean) indicates whether this was a synthesized record
//                                              click in response to a keyboard event
//		@group	events
//      @see    recordClick()
//
//      @group  events
//		@return	(boolean)	
//      @visibility external
//<
rowClick : function (record, recordNum, fieldNum, keyboardGenerated) {

	// record the last record clicked (used for keyboard navigation)
    this._lastRecordClicked = recordNum;
 
	var record = this.getCellRecord(recordNum, fieldNum),
		field = this.fields[fieldNum];

    // don't fire recordClick on loading rows
    if (Array.isLoading(record)) return;

	// if the field has a 'recordClick' method, call that
	var value = this.getCellValue(record, recordNum, fieldNum);
	var rawValue = this.getRawCellValue(record, recordNum, fieldNum);
    
	// if the record is a group header, expand/collapse the group
	if (record != null && record._isGroup) {
        // row indices are invalidated after folder toggle, so flush all edits first
        var mythis=this, myrecord=record;
        if (this.getEditRow() != null) this.saveAllEdits(null, function () {
            mythis.toggleFolder(myrecord);
        });
        else this.toggleFolder(record);
		return;
	}
    
	if (field.recordClick) {
		// CALLBACK API:  available variables:  "viewer,record,recordNum,field,fieldNum,value,rawValue"
		// Convert a string callback to a function
		isc.Func.replaceWithMethod(field, "recordClick", 
                                         "viewer,record,recordNum,field,fieldNum,value,rawValue");
        var returnVal = field.recordClick(this, record, recordNum, field, fieldNum, value, rawValue);
        if (returnVal == false) return false;
	}

	// Note - there is also a (legacy) recordClick handler on the GridRenderer class, with a
	// different signature.
	// 'recordClick()' is not one of the GridAPIs - so won't be fired automatically from the
	// GridRenderer click handling code.  If the method was defined on both the ListGrid and
	// the Body, both methods would be fired.
	// CALLBACK API:  available variables:  "viewer,record,recordNum,field,fieldNum,value,rawValue"
	if (this.recordClick) {
        var returnVal = this.recordClick(this, record, recordNum, field, fieldNum, value, rawValue);
        if (returnVal == false) return false;
    }
    
	// if the cell is editable on click, edit it now
	// We also start editing if editOnFocus is true.
    var editOnClick = this.isEditable() && (this.editEvent == isc.EH.CLICK || this.editOnFocus);

    // one-click toggling of boolean/valueMapped fields.
    // Note: also allows entering of editing if editEvent is click.
    if (field.canToggle && this.canEditCell(recordNum, fieldNum) && this.shouldToggle(field)) {
        var valueMap = this.getEditorValueMap(field, this.getEditedRecord(recordNum,fieldNum));
        // autocreate a valueMap for boolean
        if (valueMap == null && isc.SimpleType.getBaseType(field.type) == this._$boolean) {
            valueMap = [true,false];
        }
        if (valueMap != null) {
            if (!isc.isAn.Array(valueMap)) valueMap = isc.getKeys(valueMap);
            if (valueMap.length > 1) {

                var fieldName = this.getFieldName(fieldNum),
                    editValue = this.getEditedCell(recordNum, fieldNum),
                    index = valueMap.indexOf(editValue);
                index += 1;
                if (index >= valueMap.length) index = 0;
                editValue = valueMap[index];
                
                // autoSaveEdits: Usually if canToggle is true we instantly commit
                // however if we're also jumping into edit mode it makes more sense to
                // just toggle the edit value and save when the user dismisses the editor
                // as usual.
                if (!editOnClick && this.autoSaveEdits) {

                    this.setEditValue(recordNum, fieldNum, editValue, true, false);
                    this.saveEdits(null, null, recordNum, fieldNum);
                } else {
                    this.setEditValue(recordNum, fieldNum, editValue);
                }
            }
        }
    }

	if (editOnClick) {
        if (this.handleEditCellEvent(recordNum, fieldNum, isc.ListGrid.CLICK) == true) {
            return true;    
        }
    	// If this was a keyboard event, and the keyboard click field is not editable, iterate 
    	// through the other fields, and edit the first editable one we find
        if (keyboardGenerated) {
            for (var i = 0; i< this.fields.length; i++) {
                if (i == fieldNum) continue;
                if (this.handleEditCellEvent(recordNum, i, isc.ListGrid.CLICK) == true) {
                    return true;
                }
            }
        }
    } 
},

// By default we only toggle if the event occurred over a field's value-icon
// Exception: If _formatBooleanFieldAsImage returns false we didn't write out an icon for 
// the cell
shouldToggle : function (field) {
    // Note: no need to check 'canToggle' - this method is only called for fields where
    // canToggle is true.
    if (!this._formatBooleanFieldAsImages(field)) return true;
    var part = this.getEventPart();
    return (part && part.part == "valueicon");
},

//>	@method	listGrid.rowDoubleClick()	(A)
// Event handler for when a body record is double-clicked.
// <P>
// Default implementation fires 'editCell' if appropriate, and handles firing
// 'recordDoubleClick' stringMethod if defined at the field or LG level (That method has a
// different signature from this one)
//
//      @param  record      (ListGridRecord)    record object returned from getCellRecord()
//		@param	recordNum   (number)	index of the row where the click occurred
//		@param	fieldNum	(number)	index of the col where the click occurred
//      @param  [keyboardGenerated]   (boolean) indicates whether this was a synthesized record
//                                              doubleclick in response to a keyboard event
//
//      @see    recordDoubleClick()
//		@group	events
//		@return	(boolean)	false if first click not on same record; true otherwise
//      @visibility external
//<
rowDoubleClick : function (record, recordNum, fieldNum, keyboardGenerated) {

	var field = this.fields[fieldNum], 
        value = this.getCellValue(record, recordNum, fieldNum),
        rawValue = this.getRawCellValue(record, recordNum, fieldNum);

    // suppress user-defined handlers on the group header node
    if (record != null && record._isGroup) return;
    
	if (field.recordDoubleClick) {
		// CALLBACK API:  available variables:  "viewer,record,recordNum,field,fieldNum,value,rawValue"
		// Convert a string callback to a function
		isc.Func.replaceWithMethod(field, "recordDoubleClick", 
                                         "viewer,record,recordNum,field,fieldNum,value,rawValue");
        var returnVal = field.recordDoubleClick(this, record, recordNum, field, fieldNum, value, rawValue);
        if (returnVal == false) return returnVal;
	}
    if (this.recordDoubleClick != null) {
		// CALLBACK API:  available variables: "viewer,record,recordNum,field,fieldNum,value,rawValue"
        var returnVal = this.recordDoubleClick(this, record, recordNum, field, fieldNum, value, rawValue);
        if (returnVal == false) return returnVal;
    }

	// if the cell is editable, edit it now
	//	(editCell will return true if we've brought up the cell editor)
	if (this.isEditable() && this.editEvent == isc.EH.DOUBLE_CLICK) {
        if (this.handleEditCellEvent(recordNum, fieldNum, isc.ListGrid.DOUBLE_CLICK) == true) return true;    
    	// If this was a keyboard event, and the keyboard click field is not editable, iterate 
    	// through the other fields, and edit the first editable one we find
        if (keyboardGenerated) {
            for (var i = 0; i< this.fields.length; i++) {
                if (i == fieldNum) continue;
                if (this.handleEditCellEvent(recordNum, i, isc.ListGrid.DOUBLE_CLICK) == true) return true;
            }
        }
    }
    
},

// If we get a click (bubbled up from the body / header) just stop it from bubbling by default
// since it "has meaning" to this widget
// May be overridden if the developer wants some custom behavior on click within this widget.
click : function () {    
    return isc.EH.STOP_BUBBLING;
},

doubleClick : function () {
    return isc.EH.STOP_BUBBLING;
},

// Body Context Menu
// --------------------------------------------------------------------------------------------
// This will fire 'ListGrid.cellContextClick' if defined.
// Otherwise implements default behavior of showing context menu for the cell.
// enhancement: check for contextMenu,cellContextClick on cell, row, field?
_cellContextClick : function (record, rowNum, colNum) {

	// clear any previous context menu items
	this.cellContextItems = null;

	// Call handler if defined; return false to cancel context menu if handler returns false.  The
	// handler can call lv.makeCellContextItems(record,recordNum,fieldNum), modify the items, and
	// set lv.cellContextItems to customize the context menu.
	if (this.cellContextClick) {
        var record = this.getCellRecord(rowNum, colNum);
		if (this.cellContextClick(record, rowNum, colNum) == false) return false;
    }

	// show cell context menus, or generic context menu?
	if (this.showCellContextMenus) {
	
		// create the cellContextMenu if necessary
		if (!this.cellContextMenu) this.cellContextMenu = isc.Menu.create(this.contextMenuProperties);

		// get standard menu items if the handler above did not set custom items
		if (!this.cellContextItems) {
			this.cellContextItems = this.makeCellContextItems(
                this.getCellRecord(rowNum, colNum), rowNum, colNum);
		}

		// if there are any menu items, set and show the menu
		if (isc.isAn.Array(this.cellContextItems) && this.cellContextItems.length > 0) {
			this.cellContextMenu.setData(this.cellContextItems);
			this.cellContextMenu.showContextMenu(this);
		}
		
		// return false to kill the standard context menu
		return false;
				
	} else {
    	// do normal Canvas context menu handling. Will fall through to this.showContextMenu.
    	return true;
	}
},

//>@method  ListGrid.getShowChildDataSourceContextMenuItemTitle() [A]
// If +link{ListGrid.canOpenRecordDetailGrid} is true and +link{ListGrid.showCellContextMenus}
// is true, we will show menu items to drill into the child datasources in this grid's context
// menu. This method returns the title for that menu item. Override for localization.
// @param ds (DataSource) child datasource to be drilled into
// @return (string) By default returns <code>"Show " + ds.getPluralTitle()</code>
// @group i18nMessages
// @visibility nestedGrid
//<
getShowChildDataSourceContextMenuItemTitle : function (ds) {
    return "Show " + ds.getPluralTitle();
},

// generate standard cell context menu items
makeCellContextItems : function (record, rowNum, colNum) {
    if (this.dataSource != null) {
        var menuItems = [];

    	// menu items to drill into a child DataSource via a nested grid
        if (this.canOpenRecordDetailGrid) {
            var recordDS = isc.DS.get(this.getRecordDataSource(record)),
                childDataSources = recordDS.getChildDataSources();
            if (childDataSources != null) {
                for (var i = 0; i < childDataSources.length; i++) {
                    var ds = childDataSources[i];
                    menuItems.add({
                        title : this.getShowChildDataSourceContextMenuItemTitle(ds),
                        record : record,
                        dataSource : ds,
                        click : "target.openRecordDetailGrid(item.record, item.dataSource)"
                    });
                }
            }
        }

    	// menu item to edit with an embedded form
        if (this.canOpenRecordEditor) {
            
            menuItems.add({
                title : this.openRecordEditorContextMenuItemTitle,
                record : record,
                click : "target.endEditing();target.openRecordEditor(item.record)"
            });
        }

    	// if we are currently showing anything inside the row offer to dismiss it
        if (record != null && this._openRecord == record) {
            menuItems.add({
                title : this.dismissEmbeddedComponentContextMenuItemTitle,
                click : "target.closeRecord()"
            });
        }

    	// menu item to delete a record
        menuItems.add({
            title : this.deleteRecordContextMenuItemTitle,
            click : "target.removeSelectedData()"
        });

        return (menuItems.length > 0 ? menuItems : null);
    }
	return null;
},

// Hover
// ---------------------------------------------------------------------------------------

// override getCanHover.
// If this.canHover is explicitly set to true or false, respect it,
// Otherwise - if any fields are going to show hovers, return true

getCanHover : function () {
    if (this.canHover != null) return this.canHover;
    var fields = this.getFields();
    if (fields != null) {
        for (var i = 0; i < fields.length; i++) {
            if (fields[i].showHover) return true;
        }
    }
    // Either null or false
    return this.canHover;
},

// NOTE: JSDoc imported from GR
cellHoverHTML : function (record, rowNum, colNum) {
    // If we're showing an editor in the cell suppress the standard cell hover.
    if (this._editorShowing && this.getEditRow() == rowNum && 
        (!this.editByCell || this.getEditCol() == colNum)) return null;
    var field = this.getField(colNum);
    if (field.showHover == false) return null;
    if (field.showHover == null && !this.canHover) return null;
    
    var value = this.getCellValue(record, rowNum, colNum);

    if (field.hoverHTML) {
        isc.Func.replaceWithMethod(field, "hoverHTML",
                                         "record,value,rowNum,colNum,grid");
        return field.hoverHTML(record,value,rowNum,colNum,this);
    }

    if (value != null && !isc.isAn.emptyString(value) && value != this.emptyCellValue) {    
        return value;
    }
},

//> @method listGridField.hoverHTML()
// StringMethod override point for returning HTML to be shown in hovers over cells in the
// column described by this field.
// <P>
// Called only when +link{listGrid.canHover,canHover} and +link{listGrid.showHover,showHover}
// are both true.
// <P>
// The value of "this" within the method will by the +link{ListGridField,field definition}.
//
// @param record (ListGridRecord) record being hovered over
// @param value  (any) value of the cell being hovered over
// @param rowNum (number) row number where hover occurred
// @param colNum (number) column number where hover occurred
// @param grid   (ListGrid) ListGrid this field is a part of
// @return (HTML) HTML to show in the hover
// @group hovers
// @visibility external
// @example valueHoverTips
//<

// Selection
// --------------------------------------------------------------------------------------------

// Simple helper methods to avoid having to refer directly to this.selection
// Genericized up to DataBoundComponent, July 2008


//> @method listGrid.selectRecord()
// @include dataBoundComponent.selectRecord()
//<

//> @method listGrid.deselectRecord()
// @include dataBoundComponent.deselectRecord()
//<

//> @method listGrid.selectRecords()
// @include dataBoundComponent.selectRecords()
//<

//> @method listGrid.deselectRecords()
// @include dataBoundComponent.deselectRecords()
//<

//> @method listGrid.selectAllRecords()
// @include dataBoundComponent.selectAllRecords()
//<

//> @method listGrid.deselectAllRecords()
// @include dataBoundComponent.deselectAllRecords()
//<

//> @method listGrid.anySelected()
// @include dataBoundComponent.anySelected()
//<

// Keyboard Navigation
// --------------------------------------------------------------------------------------------

//> @method listGrid.keyPress()
// Handle a keyPress event on the ListGrid as a whole.  
// <P>
// Note that the majority of keyboard handling for a ListGrid is performed by
// +link{bodyKeyPress()} and most overrides are better performed there.
//
// @param  event (ISCEvent) the event details
// @return (EventReturn) return value for the keyPress event.
// @visibility external
//<

//> @method listGrid.bodyKeyPress()
// Handle a keyPress event on the body.  
// <P>
// Default implementation handles navigating between records with arrow keys, and activating
// records with space an enter.
//
// @param  event (ISCEvent) the event details
//
// @return (EventReturn) return value for the keyPress event.
//
// @visibility external
//<

_$ArrowUp:"Arrow_Up", _$ArrowDown:"Arrow_Down",
_$Space:"Space", _$Enter:"Enter",
bodyKeyPress : function (event, eventInfo) {
    if (this.data.getLength() > 0) {

        // if we start editing on keypress, return false to kill the event (avoiding
        // page navigation on backspace keypress, etc)
        var EH = isc.EventHandler,
            keyName = event.keyName;  
        var editOnKeyPress = this.editOnKeyPress && this.isEditable();
        if (editOnKeyPress && this._editOnKeyPress(event, eventInfo)) return false;
        
    	// for arrow keys, navigate to the appropriate record
        if (keyName == this._$ArrowUp) {
            return this._navigateToNextRecord(-1);
        } else if (keyName == this._$ArrowDown) {
            return this._navigateToNextRecord(1);

    	// Generate a click on the current focus record when the user hits Space            
        } else if (keyName == this._$Space) {
            
            if (this.generateClickOnSpace) 
                if (this._generateFocusRecordClick() == false) return false;
                
            if (this.generateDoubleClickOnSpace)
                return this._generateFocusRecordDoubleClick();

    	// Generate a doubleClick on the current focus record when the user hits Enter    
        } else if (keyName == this._$Enter) {
            if (this.generateClickOnEnter)  
                if (this._generateFocusRecordClick() == false) return false;

            if (this.generateDoubleClickOnEnter) 
                return this._generateFocusRecordDoubleClick();
        }
        
    }
    return true
},

// editOnKeyPress behavior
// - modelled on spreadsheet style application editing
// - normal record selection and navigation occurs on click / arrow keypress when not currently
//   editing the grid
// - on character keypress, start editing (respecting the character typed)

_$f2:"f2",
_$Escape:"Escape",
_$Backspace:"Backspace",
_$Delete:"Delete",
_$keyPress:"keyPress",
_editOnKeyPress : function (event, eventInfo) {

    var keyName = eventInfo.keyName,
        charVal = isc.EH.getKeyEventCharacter(event);  
    // We don't want to start editing if the user hit a non character key, such as a function key
    // or escape, etc   
        
    if (keyName != this._$f2 && keyName != this._$Delete && keyName != this._$Backspace && 
        (keyName == this._$Escape || 
            isc.EH._nonCharacterKeyMap[keyName] || charVal == null || charVal == isc.emptyString)) 
    {
        return false;
    }

    var cell = this.getFocusCell(),
        row = cell[0] || 0,
        col = cell[1] || 0;
    // If we're already showing an editor just bail
    if (this._editorShowing) return false;
    
    // on Enter / f2 keypress don't modify the value in the cell
    var undef;
    if (keyName == this._$Enter || keyName == this._$f2) charVal = null;

    var editVal;
    if (charVal != null) {
        if (keyName == this._$Delete || keyName == this._$Backspace) {
            editVal = null;
        } else if (this.autoSelectEditors) {
            editVal = charVal;
        } else {
            editVal = this.getEditedCell(row,col) + charVal;
        }
        // this flag ensures that when we focus in the item we put selection at the end, rather
        // than selecting the entire value.
        this._editorCursorAtEnd = true;
    }
    return this.handleEditCellEvent(cell[0], cell[1], this._$keyPress, editVal);
    
},

// getArrowKeyAction() - used by _navigateToNextRecord() to determine how the record
// should be hilighted.

// Strings used in navigation styles
_$none:"none", _$focus:"focus", _$select:"select", _$activate:"activate",
getArrowKeyAction : function () {

    var action = this.arrowKeyAction;
    // No action at all trumps everything
    if (action == this._$none) return this._$none;
    
    // if ctrl key is down always just hilite / focus
    if (isc.EH.ctrlKeyDown()) return this._$focus;
    
    return action;
},

// _navigateToNextRecord()
// Called from this.bodyKeyPress() on arrow keys, to handle navigating around the listGrid.
// If step == +1, we want to navigate to the next record in the list, if step is -1, we want to
// navigate to the previous record.
// Determines which record to navigate to, and falls through to _generateRecordClick() or 
// _hiliteRecord() depending on the result of this.getArrowKeyAction()
_navigateToNextRecord : function (step) {
	// Are we going to simulate a click on the next record or just hilight it?
    var navStyle = this.getArrowKeyAction();
    
	// If keyboard navigation is disabled return true to allow processing to continue.
    if (navStyle == this._$none) return true;

	// Note: we are either going forward or backward one record - assume jumping over multiple 
	// records is not supported
	//
	// Default to selecting the next record
    if (step == null) step = 1;
    
	// Determine which record was last hilighted or clicked
    var newSelectionIndex;

	// By default we want the last row that had keyboard focus
    newSelectionIndex = this.getFocusRow(step > 0);
    // Otherwise, get the last record clicked
    if (newSelectionIndex == null) newSelectionIndex = this._lastRecordClicked;
    if (isc.isA.Number(newSelectionIndex)) newSelectionIndex += step;
	// Default to the first record
    else newSelectionIndex = 0;
    
    var originalSelection = newSelectionIndex,
        lastRow = this.getTotalRows() -1;
    
	// if we are trying to navigate past the ends just ensure the focus row is selected
    if (newSelectionIndex < 0 || newSelectionIndex > lastRow) {
        // bail if there were no records
        if (lastRow < 0) return true;
        
        // Ensure the original record is selected / focussed
        
        newSelectionIndex = originalSelection;
    }
     
	// At this point we are sure that newSelectionIndex is a number.
	// If the number is beyond the end of the list in either direction, or 
	// the record is not enabled, recordIsEnabled() will return false.
	// Try the next record in the step direction, and so on until we find an enabled record or
	// hit the end of the list.

	// If the record is disabled, find the first non-disabled record (in the appropriate
	// direction)
    while (!this.recordIsEnabled(newSelectionIndex, 0)) {
        newSelectionIndex += step;  
    	// if we are trying to navigate past the ends of the list, bail
        if (newSelectionIndex < 0 || newSelectionIndex > lastRow) {
            newSelectionIndex = originalSelection;
            break;
        }
    }

    // move native focus to the selected row so that screen readers will read it
    if (isc.screenReader) {
        var element = this.body.getTableElement(newSelectionIndex);
        element.focus();
    }

    //this.logWarn("navStyle: " + navStyle + ", target index: " + newSelectionIndex);

    if (navStyle == this._$focus) this._hiliteRecord(newSelectionIndex);

    else if (navStyle == this._$select) this._generateRecordClick(newSelectionIndex);
    else if (navStyle == this._$activate) this._generateRecordDoubleClick(newSelectionIndex);
    
    this.scrollRecordIntoView(newSelectionIndex)
    
	// Don't allow the keypress event handling to continue here.
    return false;
},

_getKeyboardClickNum : function () {

	// If this.keyboardClickField was specified, return the appropriate colNum
	// Note - can be specified as a field number or field name...
    var kcf = this.keyboardClickField;
    if (kcf == null) return 0;
    
    if (isc.isA.Number(kcf) && kcf > 0 && kcf < this.fields.length) return kcf;
    
    var kcCol = this.fields.find(this.fieldIdProperty, kcf),
        colNum = (kcCol ? this.fields.indexOf(kcCol) : 0);

    return colNum;        

},

_generateRecordClick : function (recordNum) {    

    this.clearLastHilite();

	// if passed a record, resolve it to an index!
    if (isc.isAn.Object(recordNum)) recordNum = this.getRecordIndex(recordNum);

	// Make sure we're not trying to select a record beyond the ends of the list.
    if (!isc.isA.Number(recordNum) || recordNum < 0) recordNum = 0;
    if (recordNum >= this.data.getLength()) recordNum = this.data.getLength() -1;

	// remember we artificially selected this record from a keyboard event
    this.body._lastHiliteRow = recordNum;
    
    var colNum = this._getKeyboardClickNum();
    
	// Trigger the methods to perform the selection (selection.selectOnMouseDown AND 
	// selection.selectOnMouseUp)
	
    var performSelection = 
        (this.body.selectionEnabled() && this.recordIsEnabled(recordNum, colNum)) ;
	
    if (performSelection) this.selection.selectOnMouseDown(this, recordNum, colNum);
    
	// explicitly fire this 'rowClick' method, passing in the additional method flagging this
	// as a keyboard generated click
    this.rowClick(this.getCellRecord(recordNum, colNum), recordNum, colNum, true);
    if (performSelection) this.selection.selectOnMouseUp(this, recordNum, colNum);
    
	// Stop event propogation
    return false;

},

//> @method listGrid.getFocusRow() [A]
// Get the row that currently has keyboard focus.  Arrow key navigation moves relative to this
// row.
// 
// @return (Number) rowNum of the current focus row
// @visibility external
//<
// @param last (boolean) if multiple rows are selected, should we return the last row in the
//  selection (rather than the first?
getFocusRow : function (last) {

	// We want the last record hilighted by the keyboard.
	// Note: If the last keyboard hilite type event was a generated record click, the
	// lastHiliteRow will match the lastRecordclicked property for this widget.
	// If the last keyboard hilite type event was a hilite (rollover style) event, the 
	// lastHiliteRow will match the lastOverRow for the body.
	// If neither of these are true, we can assume a subsequent mouse event has occurred over
	// a different row, effectively invalidating the _lastHiliteRow property, so should be
    // ignored and deleted
    if (this.body._lastHiliteRow != null && 
        ((this.body._lastHiliteRow == this.body.lastOverRow) || 
           (this.body._lastHiliteRow == this._lastRecordClicked)) )
    {        
        return this.body._lastHiliteRow;
    }
    delete this.body._lastHiliteRow;
    
    // If there is no valid keyboard hilite row, return a record from the end of the selection
    // We use 'direction' param to indicate whether it's more appropriate to return the
    // first or last selected record of a multiple selection
	var selection = this.getSelection();    
    if (selection.length == 0) return null;
    selection = selection[(last ? selection.length -1 : 0)]
    return this.getRecordIndex(selection);

},

getFocusCell : function () {
    return [this.getFocusRow(), this._getKeyboardClickNum()]
},

_generateFocusRecordClick : function () {

    var currentRecord = this.getFocusRow();

    if (currentRecord != null) {
        this._generateRecordClick(currentRecord);
        return false;
    }
    
	// allow event processing to continue..
    return true;
},

_generateRecordDoubleClick : function (rowNum) {

    // determine the appropriate col
    var colNum = this._getKeyboardClickNum();
    // generate a double click, on the appropriate record (and field), passing in the
	// parameter flagging this as a keyboard synthesized click event.
	//this._handleRecordDoubleClick(currentRecord, colNum);
    this.rowDoubleClick(this.getCellRecord(rowNum, colNum), rowNum, colNum, true);
},

_generateFocusRecordDoubleClick : function () {

    // determine the appropriate col
    var colNum = this._getKeyboardClickNum(),
        currentRecord = this.getFocusRow();

    if (currentRecord != null) {
        
        this._generateRecordDoubleClick(currentRecord);
        return false;
    }
    
	// allow event processing to continue..
    return true;

},

// Scrolling
// --------------------------------------------------------------------------------------------

//>	@method	listGrid.scrollRecordToTop()	(A)
// Scroll the listGrid body such that the specified row is visible at the top of the viewport.
//		@group	scrolling
//		@param	rowNum  (number)    Index of the row to scroll into view
//<
scrollRecordToTop : function (rowNum) { return this.scrollRecordIntoView(rowNum, false); },

//>	@method	listGrid.scrollRecordIntoView()	(A)
// Scroll the listGrid body such that the specified row is visible close to the
// center of the viewport.
//		@group	scrolling
//		@param	rowNum  (number)    Index of the row to scroll into view
//<

scrollRecordIntoView : function (rowNum, center) {
    return this.scrollCellIntoView(rowNum, null, center);
},

//>	@method	listGrid.scrollColumnIntoView()	(A)
//			Will scroll the listGrid body such that the specified column is visible close to the
//          centre of the viewport.
//		@group	scrolling
//		@param	colNum  (number)    Index of the column to scroll into view
//<
// Currently unused by the libraries, included for completeness
scrollColumnIntoView : function (colNum, center) {
    return this.scrollCellIntoView(null, colNum, center);
},

//>	@method	listGrid.scrollCellIntoView()	(A)
//			Will scroll the listGrid body such that the specified cell is visible close to the
//          centre of the viewport.
//		@group	scrolling
//		@param	rowNum  (number)    Row index of the cell to scroll into view
//		@param	colNum  (number)    Column index of the cell to scroll into view
//<
// NOTE: as of 2006.11.28, the 'scrollIntoView' method this eventually falls through to supports
// individual x and y positions of top/left, center, bottom/right.
// Therefore easy to modify this method to take x and y postions rather than a single boolean 
// "center" for either centered or displayed at top and left.
scrollCellIntoView : function (rowNum, colNum, center) {
	// if the body isn't drawn, we can't scroll the cell into view - set a flag to scroll the
	// body when it gets drawn
    if (!this.body || !this.body.isDrawn()) {
        this.logInfo("scrollCellIntoView() called before the body has been drawn.  Cell " +
                     rowNum + "," + colNum + " will scrolled into view on draw().");
        this._scrollCell = [rowNum, colNum];
        return;

    }
    
    if (center == null) center = true;

    var x, y, width, height, body = this.body;
    if (rowNum != null) {
        if (!body._isVirtualScrolling) {
            y = body.getRowTop(rowNum);
            height = body.getRowSize(rowNum);
        } else {
            // If the row is already in the viewport, don't call scrollToTargetRow()
            // as this will shift it about which can be confusing if the user is 
            // navigating through rows with the keyboard.
            var undrawn = body._firstDrawnRow == null || rowNum < body._firstDrawnRow || 
                rowNum > body._lastDrawnRow,
                inViewport = !undrawn;
            if (inViewport) {
                var rowTop = body.getRowTop(rowNum),
                    rowHeight = body.getRowHeight ? 
                                    body.getRowHeight(this.getCellRecord(rowNum), rowNum) :
                                    body.cellHeight,
                    scrollTop = body.getScrollTop();
                if (scrollTop > rowTop || 
                    ((body.getViewportHeight() + scrollTop) < (rowTop + rowHeight))) 
                {
                    inViewport = false;
                }
            }
            if (!inViewport) {
                
                // scrolling to a particular coordinate would be meaningless with unknown row
                // heights
                body._targetRow = rowNum;
                if (center) {
                    body._rowOffset = -1 * ((body.getViewportHeight() / 2) - body.cellHeight);
                } else {
                    body._rowOffset = 0;
                }
                body._scrollToTargetRow();
            }
            return;
        }
    }
    if (colNum != null) {
        x = this.getColumnLeft(colNum);
        width = this.getColumnWidth(colNum);
    }
    
    // Catch the case where we're dirty, and the row being scrolled into view is not yet present
    // in our HTML (so we can't scroll into view until the redraw occurs)
    if (this.isDirty() || this.body.isDirty()) {
        var mustRedraw;
        if (rowNum != null) {
            var scrollHeight = body.getScrollHeight();
            if (y+height > scrollHeight) mustRedraw = true;
        }
        if (!mustRedraw && colNum != null) {
            var scrollWidth = body.getScrollWidth();
            if (x+width > scrollWidth) mustRedraw = true;
        }
        if (mustRedraw) this.redraw("scrollIntoView");
    }
    
	//this.logWarn("ScrollIntoView passed: " + [rowNum, colNum] + 
	//             ", calculated target cell position:" + [x,y] + ", size:" + [width,height]);

    body.scrollIntoView(x,y,width,height, (center ? "center" : "left"), (center ? "center" : "top"))
    
},

// Header/Body Scroll Sync
// --------------------------------------------------------------------------------------------
// Note - we keep the body / header's horizontal scroll position in synch by firing 
// syncHeaderScrolling when the body is scrolled, and syncBodyScrolling where the header is
// scrolled.
// We have to have these no-op if the header / body are already at the same place to avoid an
// infinite loop.
bodyScrolled : function (left, top, body) {
    // frozen fields: match vertical scrolling
    for (var i = 0; i < this.bodies.length; i++) {
        if (this.bodies[i] != body) this.bodies[i].scrollTo(null, top, null, true);
    }
    this.syncHeaderScrolling(left, top);
    this.syncFilterEditorScrolling(left, top);

    // If we took focus from the edit form as part of a redraw and haven't restored it yet
    // restore it now
    
    if (this._editorShowing && this._editorSelection) {
        var editForm = this.getEditForm(), 
            editRow = this.getEditRow(), 
            editColNum = this.getEditCol(),
            editItem = editForm.getItem(this.getEditorName(editRow, editColNum));

        if (editItem) {
            if (!editItem.hasFocus && 
                (editForm.hasFocus || isc.EH.getFocusCanvas() == null))
            {
                this._restoreFocusAfterRedraw(editColNum);
            } else {
                delete this._editorSelection;
            }
        }
    }
},


syncHeaderScrolling : function (left, top) {
    
	if (left != null && this.header) {
        if (!this.isRTL()) {
            if (left != this.header.getScrollLeft()) this.header.scrollTo(left);
        } else {
        	
            var header = this.header,
                body = this.body,
                headerMaxScroll = header.getScrollWidth() - header.getViewportWidth(),
                headerScrollPos = headerMaxScroll - header.getScrollLeft(),
                bodyMaxScroll = body.getScrollWidth() - body.getViewportWidth(),
                bodyScrollPos = bodyMaxScroll - left;
            /*
            this.logWarn("scroll sync: body new left: " + left + 
                         ", body max: " + bodyMaxScroll +
                         ", body pos: " + bodyScrollPos +
                         ", header current left: " + header.getScrollLeft() +
                         ", header max: " + headerMaxScroll +
                         ", header pos: " + headerScrollPos +
                         ", will scroll header to: " + (headerMaxScroll - bodyScrollPos));
            */
                     
            if (bodyScrollPos != headerScrollPos) {
                header.scrollTo(headerMaxScroll - bodyScrollPos);
            }
        }
    }
},

// when the header is scrolled, keep the body scrolled in synch with it!
headerScrolled : function () {
    
    if (!this._delayingBodyScrolling) {
        this._delayingBodyScrolling = this.delayCall("syncBodyScrolling");
    }
},


syncBodyScrolling : function () {
    delete this._delayingBodyScrolling;
    var left = this.header.getScrollLeft();
    if (this.body) { 
        if (!this.isRTL()) {
            if (left != this.body.getScrollLeft()) this.body.scrollTo(left);
            
        } else {
            var header = this.header,
                body = this.body,
                headerMaxScroll = header.getScrollWidth() - header.getViewportWidth(),
                headerScrollPos = headerMaxScroll - header.getScrollLeft(),
                bodyMaxScroll = body.getScrollWidth() - body.getViewportWidth(),
                bodyScrollPos = bodyMaxScroll - left;

            if (bodyScrollPos != headerScrollPos) {
                body.scrollTo(bodyMaxScroll - headerScrollPos);
            }
        }
    }
},

// if we are showing a filter editor we must keep that horizontally scrolled to the same 
// position as the body
syncFilterEditorScrolling : function (left, top) {
    if (this.filterEditor != null && this.filterEditor.body != null &&
    	// No op if they are already in synch to avoid an infinite loop
        this.filterEditor.body.getScrollLeft() != left) 
    {
        this.filterEditor.body.scrollTo(left);
    }
},

// RollOver
// --------------------------------------------------------------------------------------------

_hiliteRecord : function (recordNum) {

    if (!isc.isA.Number(recordNum)) {
        recordNum = this.getRecordIndex(recordNum);
    }

	// Make sure we're not trying to select a record beyond the ends of the list.
    if (!isc.isA.Number(recordNum) || recordNum < 0) recordNum = 0;
    if (recordNum >= this.data.getLength()) recordNum = this.data.getLength() -1;

    this.clearLastHilite();
    
	// note the row number hilighted by keyboard navigation
    this.body._lastHiliteRow = recordNum;

	// set this.body.lastOverRow, so the recordStyle will be updated to the mouseOver style
	// Note: this is something of a hack - arguably this should be customizable as a separate
	// style
    this.body.lastOverRow = recordNum;
    this.body.lastOverCol = 0;  // required to make the GR believe the mouse was over a real cell
    
	// no need to calculate the style - setRowStyle will achieve that
    this.bodies.map("setRowStyle", recordNum); 
    
},

//>	@method	listGrid.clearLastHilite()	(A)
// Unhilites the last hilited item.
//		@group	events, hiliting
//<
clearLastHilite : function () {
    if (!this.body) return;

	// clear the pointer to the last row hilited via keyboard navigation
    this.body._lastHiliteRow = null;

    var rowToClear = this.body.lastOverRow;
	if (isc.isA.Number(rowToClear)) {
        delete this.body.lastOverRow;
    	// no need to calculate new styleName here - let setRowStyle determine that
        if (this.showRollOver) this.body.updateRollOver(rowToClear);
	}

},

// ListGrid tab-index management.
// --------------------------------------------------------------------------------------------


// Note that we basically use the body like a focusProxy - when focus() is called, focus
// will go to the body.
// o Set _useFocusProxy to false - we don't want the grid to ever have native focus 
// o Set _useNativeTabIndex to false - this is done AFTER creating the body so the body can 
//   pick up the '_useNativeTabIndex' as explicitly specified on the ListGrid before that 
//   property gets overridden.
_useFocusProxy:false,

// Override _setTabIndex to also set the tab index of the header and body
_setTabIndex : function (index, auto,a,b) {
    this.invokeSuper(isc.ListGrid, "_setTabIndex", index,auto,a,b);
    
	// update the tab index of the header and body too!
	// Note: we're marking these tabIndices as auto-allocate:false, as we don't want the 
	// standard canvas tabIndex management to be triggered during addChild, etc.
    if (this.header != null && this.canTabToHeader) this.header._setTabIndex(index, false);
    
    if (this.body != null) this.body._setTabIndex(index, false);
},

// Override setAccessKey to set the accessKey on the body rather than on the listGrid
setAccessKey : function (accessKey) {
	// call Super - will remember this.accessKey, (though it won't actually set it on the LV handle)
    this.Super("setAccessKey", arguments)
    if (this.body != null) this.body.setAccessKey(accessKey);
},

// Override setFocus to focus on the body rather than the ListGrid
setFocus : function (newfocus) {
    if (this.body != null) this.body.setFocus(newfocus);
},

// Override _canFocus() - we are focusable if the body is focusable
// Note that the body already picks up the 'canFocus' attribute from the ListGrid, if specified
_canFocus : function () {
    if (this.body) return this.body._canFocus();
    return false;
},

// Body Clicks
// --------------------------------------------------------------------------------------------

//>	@method	listGrid.recordClick()    
// Executed when the listGrid receives a 'click' event on an enabled, non-separator
// record. The default implementation does nothing -- override to perform some action
// when any record or field is clicked.<br>
// A record event handler can be specified either as
// a function to execute, or as a string of script to evaluate. If the handler is defined
// as a string of script, all the parameters below will be available as variables for use
// in the script.<br>
//	To do something specific if a particular field is clicked, add a recordClick
//	method or string of script to that field (same parameters) when you're setting up
//	the list.<br>
//	<b>Notes:</b><ul>
//  <li>This will not be called if the click is below the last item of the list.</li>
//  <li>This method is called from the default implementaiton of
//  +link{method:listGrid.rowClick}, so if that method is overridden
//  this method may not be fired.</li></ul>
//		@group	events
//
// @param	viewer		(listGrid)	the listGrid that contains the click event
// @param	record		(ListGridRecord)	the record that was clicked on
// @param	recordNum	(number)	number of the record clicked on in the current set of
//                                  displayed records (starts with 0)
// @param	field		(ListGridField)	the field that was clicked on (field definition)
// @param	fieldNum	(number)	number of the field clicked on in the listGrid.fields
//                                  array
// @param	value       (object)    value of the cell (after valueMap, etc. applied)
// @param	rawValue	(object)	raw value of the cell (before valueMap, etc applied)
//
// @see    rowClick()
//
// @visibility external
//<
// NOTE: params not needed for default no-op implementation
recordClick : function () {},


//>	@method	listGrid.recordDoubleClick()  
// Executed when the listGrid receives a 'doubleClick' event on an enabled, non-separator
// record. The default implementation does nothing -- override to perform
// some action when any record or field is double clicked.<br>
// A record event handler can be specified either as a function to execute, or as a string
// of script to evaluate. If the handler is defined as a string of script, all the
// parameters below will be available as variables for use in the script.<br>
// To do something specific if a particular field is double clicked, add a
// recordDoubleClick method or string of script to that field (same parameters) when you're
// setting up the list.<br>
// <b>Notes:</b><ul>
// <li>This will not be called if the click is below the last item of the list.</li>
// <li>This method is called from the default implementation of +link{method:listGrid.rowDoubleClick},
// so if that method is overridden this method may not be fired.</li></ul>
//		@group	events
//
// @param	viewer		(listGrid)	the listGrid that contains the doubleclick event
// @param	record		(ListGridRecord)	the record that was double-clicked
// @param	recordNum	(number)	number of the record clicked on in the current set of
//                                  displayed records (starts with 0)
// @param	field		(ListGridField)	the field that was clicked on (field definition)
// @param	fieldNum	(number)	number of the field clicked on in the listGrid.fields
//                                  array
// @param	value       (object)	value of the cell (after valueMap, etc. applied)
// @param	rawValue	(object)	raw value of the cell (before valueMap, etc applied)
//
// @see    rowDoubleClick()
//
// @visibility external
//<
// NOTE: params not needed for default no-op implementation
recordDoubleClick : function () {},

// --------------------------------------------------------------------------------------------
// Filter editor row
// --------------------------------------------------------------------------------------------

// When 'showFilterEditor' is true on a listGrid, it will be drawn with a RecordEditor used to
// filter the List's data.

//> @method listGrid.setShowFilterEditor()
// Setter for the +link{ListGrid.showFilterEditor} property. Allows the filter editor to be
// shown or hidden at runtime.
// @param value (boolean) true if the filter editor should be shown, false if it should be hidden
// @group filterEditor
// @visibility external
//<
setShowFilterEditor : function (value) {
    // No op is required to avoid potentially setting up duplicate FEs etc.
    if (this.showFilterEditor == value) return;
    this.showFilterEditor = value;
    
    if (value) {
        // only call makeFilterEditor if we're drawn - otherwise this will happen lazily
        // in createChildren()
        if (this.isDrawn()) this.makeFilterEditor()
            
    // filterEditor may have never been defined if this widget has not yet been drawn
    } else if (this.filterEditor) {
        this.filterEditor.destroy();
        this.filterEditor = null;
    }
    // necessary because registerAttachedPeer currently only affects margins as drawn by
    // getTagStart()
    if (this.isDrawn()) {
        this.clear(); this.draw();
    }
    //this.layoutChildren();
},

// makeFilterEditor()
// Create a RecordEditor instance as this.filterEditor.
makeFilterEditor : function () {
    this.filterEditor = isc.RecordEditor.create({
        autoDraw:false,

        top:this.getTop() + this.getTopMargin(),
        left:this.getLeft() + this.getLeftMargin(),

        height : this.filterEditorHeight,
        // NOTE: filterEditors handle width sizing themselves
        
        sourceWidget:this,
        ID:this.getID() + "filterEditor",
        
        actionType:"filter",

        // XXX the register/unregisterAttachedPeer is not something we want to go with
        // long-term, but if we did, this should get factored up to Canvas.
        destroy : function () {
            this.sourceWidget._unRegisterAttachedPeer(this, isc.Canvas.TOP);
            this.Super("destroy", arguments);
        },
        
        fetchDelay: this.fetchDelay
        
    
    }, this.filterEditorDefaults, this.filterEditorProperties);
    
	
    this.addPeer(this.filterEditor);
    this.filterEditor.moveAbove(this);
    
    this._registerAttachedPeer(this.filterEditor, isc.Canvas.TOP);

},



//>	@method     listGrid.getFilterEditorValueMap()  ([A])
//
//  If we're showing the filter (query-by-example) row for this ListGrid, this method is
//  used to determine the valueMap to display in the filter row for this field.
//  Default implementation will return the field.filterEditorValueMap if specified, or
//  field.valueMap.
//
//  @group  filterEditor
//
//  @param  field   (ListGridField)    field definition field for which we need a valueMap
//  @return         (ValueMap)  ValueMap for the edit field (or null if no valueMap required)
//  @visibility external 
//<
getFilterEditorValueMap : function (field) {
    return  field.filterEditorValueMap || field.valueMap;
},

//>	@method     listGrid.getFilterEditorType()  ([A])
//
//  If we're showing the filter (query-by-example) row for this ListGrid, this method is
//  used to determine the type of form item to display in the filter edit row for this field.
//  Default implementation will return the field.filterEditorType if specified, or
//  field.valueMap.
//
//  @group  filterEditor
//
//  @param  field   (ListGridField)    field definition field for which we need a valueMap
//  @return         (ValueMap)  ValueMap for the edit field (or null if no valueMap required)
//  @visibility external 
//<
getFilterEditorType : function (field) {
    
    // Simple case: support explicit filterEditorType on the field
    if (field.filterEditorType != null) return field.filterEditorType;
    return this.getEditorType(
                // support specifying the editor type directly in the filterEditorProperties block
                isc.addProperties({}, field, this.getFilterEditorProperties(field))
            );
},

// getFilterEditorProperties - returns a block of properties to apply to the form item displayed
// in the filter row for some field.
getFilterEditorProperties : function (field) {
    return field.filterEditorProperties;
},

// Unexposed but publically accessible method to get a pointer to the filter editor grid

getFilterEditor : function () {
    return this.filterEditor;
},

// setFilterValues() - helper method called when this widgets filter criteria change.
// Will store the criteria locally and call the method to update the filter editor values.
setFilterValues : function (values) {
    // store thin in a local var - this allows us to show and hide the filterEditor independantly
    // and know what the current criteria are.
    this._filterValues = values || {};
    this.updateFilterEditorValues();
},


// update the filter editor's values to match the current filter criteria
// Needs to happen whenever the filter criteria change or the filter editor is shown
updateFilterEditorValues : function () {
    var editor = this.filterEditor;
    if (!editor) return;
    
    var values = this._getFilterEditorValues();
    this.filterEditor.setEditValues(0, values);
},

// _getFilterEditorValues returns the values to be shown in our filter editor (doesn't get the
// values FROM our filter editor).  Called when the filter editor is first created, and used
// by updateFilterEditorValues to update the filterEditor when it is already showing.
_getFilterEditorValues : function () {
    var currentCriteria = this._filterValues,
        values = {};
    // If we've never performed a filter, use our default filter values. Note that if we 
    // explicitly filter with null or empty criteria we do NOT want to reset to defaults - 
    // defaults are only used if we've never filtered this datasource. Handled by the fact
    // that setFilterValues() will always store an object, never null.
    if (currentCriteria == null) {
        values = {};
        for (var i = 0; i < this.completeFields.length; i++) {
            values[this.completeFields[i].name] = this.completeFields[i].defaultFilterValue;
        }
    // If we do have a set of filter values, trim out any that aren't included in filter-editor
    // fields - this avoids the user having inaccessible criteria values [for hidden fields
    // leave the values in place - the user can access them via the right-click functionality to
    // re-show the fields]
    } else {
        for (var i = 0; i < this.completeFields.length; i++) {
            var fieldName = this.completeFields[i].name;
            values[fieldName] = currentCriteria[fieldName]
        }
    }
    return values;
},


// re-set the filterEditor's values to display the defaultFilterValues.
// This will be called if the defaultFilterValues change (can happen from setFields()) [and
// no filter has yet been performed], or if we change datasources so the current filter gets
// invalidated. 

clearFilterValues : function () {
    this._filterValues = null;
    this.updateFilterEditorValues();
},



// --------------------------------------------------------------------------------------------
// Inline Editing
// --------------------------------------------------------------------------------------------



// Editing kickoff
// --------------------------------------------------------------------------------------------

//>	@method     listGrid.canEditCell()	(A)
// Can this cell be edited?
// <P>
// The default implementation of <code>canEditCell()</code> respects the various property
// settings affecting editability: +link{listGridField.canEdit,field.canEdit} disables editing
// for a field, a record with the +link{listGrid.recordEditProperty,recordEditProperty} set to
// false is not editable, and disabled records are not editable.
// <P>
// You can override this method to control editability on a cell-by-cell basis.  For example,
// if you had a grid that allows editing of "orders", and you had a field "shipDate" that is
// normally editable, but should not be editable if the order is already "complete", you might
// implement <code>canEditCell()</code> as follows:
// <P>
// <pre>
//   isc.ListGrid.create({
//       ...
//       canEditCell : function (rowNum, colNum) {
//           var record = this.getRecord(rowNum),
//               fieldName = this.getFieldName(colNum);
//           if (fieldName == "shipDate" && 
//               record.orderStatus == "complete") 
//           {
//               return false;   
//           }
//           // use default rules for all other fields
//           return this.Super("canEditCell", arguments);
//       }
//   });
// </pre>
// <P>
// Notes on providing custom implementations:
// <ul>
// <li> In order to allow complete control over editing, <code>canEditCell()</code> is called
// very frequently.  If you see delays on row to row navigation, check that your implementation
// is efficient
// <li> If you change the editability of a cell on the fly, for example, during 
// +link{editorExit()} on another cell, call refreshCell() to show or hide the editor
// <li> If this ListGrid allows new records to be created, <code>canEditCell()</code> may be
// called when there is no record available.  The values input so far by the user are available
// via +link{getEditValues()}. 
// </ul>
//
// @param rowNum (number) row number for the cell
// @param colNum (number) column number of the cell
// @return (boolean) Whether to allow editing this cell
//
// @group editing
// @visibility external
//<
canEditCell : function (rowNum, colNum) {
    // just return if passed bad colNum
    if (colNum < 0 || colNum >= this.fields.length) return false;
    var cellRecord = this.getCellRecord(rowNum, colNum);
	// Note - we may have no cellRecord - this will occur if we're editing a new row
	if (cellRecord != null) {
        if (!this.recordIsEnabled(rowNum, colNum)) return false;

    	// Suppress editing if we're showing an embedded editor or detailGrid for this row
        if (this._openRecord == cellRecord) return false;
    }
    
    // If the field is explictly marked as disabled, disallow editing
    
    if (this.getField(colNum).disabled) return false;

	// otherwise check the cascaded canEdit property
	if (
    	// Note: the isEditable() check is required as 'getCellBooleanProperty' will not return
    	// false if the record's "_canEdit" property is set to 'true', but canEdit is unset at
    	// the field and listGrid level, and we don't allow editing cells when canEdit is
    	// not set at both the listGrid and field level.
        !this.isEditable() ||    
        this.getCellBooleanProperty(
                "canEdit",
                rowNum,
                colNum,
                (cellRecord != null ? this.recordEditProperty : null)
        ) == false
    ) {
        return false; 
    }
    
    return true;
},

//> @method listGrid.isEditable()   (A)
//  Looks at the 'canEdit' property on both the listGrid and the set of fields to 
//  determine whether any cells in this listGrid can be edited.
//  @return (boolean)   true if any fields in this listGrid can be edited.
//<
_$true:"true",
isEditable : function () {
	// A field can be edited if:
	// listGrid.canEdit is true, and field.canEdit is not set to false
	// listGrid.canEdit is unset, and field.canEdit is set to true
	// No field can be edited if listGrid.canEdit is set to false.
    
    if (this.canEdit == false) return false;
    
    if (this.canEdit == true || this.canEdit == this._$true) {
        var fields = this.getFields();
        for (var i = 0; i < fields.length; i++) {
            if (fields[i].canEdit != false) return true;
        }
        return false;
    } else {
    	// this.canEdit is null
        var fields = this.getFields();
        for (var i = 0; i < fields.length; i++) {
            if (fields[i].canEdit == true) return true;
        }
        return false;
    }
},

//> @method listGrid.setCanEdit()
//  Updates the canEdit property for this listGrid at runtime.
//  If setting canEdit to false, cancel any current edit.
//  @param  (boolean)   desired value of canEdit for this listGrid
//<
setCanEdit : function (canEdit) {
    if (canEdit == false) {
        if (this.getEditRow() != null) this.cancelEditing(isc.ListGrid.PROGRAMMATIC);
        this.canEdit = false;
    } else {
        this.canEdit = canEdit;
    }
},

//> @method listGrid.setFieldCanEdit()
//  Updates the canEdit property for some field at runtime.
//  @param  (boolean)   desired value of canEdit for this field
//<
setFieldCanEdit : function (field, canEdit) {

    if (isc.isA.String(field)) field = this.getField(field);
    if (field == null || !this.completeFields.contains(field) || field.canEdit == canEdit) return;
    
    field.canEdit = canEdit;
    if (this._editorShowing) {
        var editRow = this.getEditRow(),
            fieldName = field[this.fieldIdProperty],
            colNum = this.getColNum(field);
        
    	// If we're editing by cell and making the current edit field non editable, kill the
    	// current edit
        if (this.editByCell) {
            if (!canEdit && colNum == this.getEditCol()) {
                this.cancelEditing(isc.ListGrid.PROGRAMMATIC);
            }

    	// If we're showing editors for the entire row, we need to refresh the appropriate 
    	// field in the edit row to display / hide the editor
        } else if (colNum >= 0) {

        	// If we're hiding the current edit field, we want to shift focus to the nearest
        	// edit field instead.
        	// If there isn't one, just cancel the edit.
            if (!canEdit && colNum == this.getEditCol()) {

                var currentEditItem = this._editRowForm.getItem(fieldName),
                    fieldHasFocus = currentEditItem.hasFocus;
                    
            	// Try to put focus in an adjacent field - say the previous one
            	// (try going backwards first, then forwards)
                var newEditCell = this.findNextEditCell(editRow, colNum, -1, 
                                                        true, false, false, true);
        
                if (newEditCell == null || newEditCell[0] != editRow) 
                    newEditCell = this.findNextEditCell(editRow, colNum, 1, 
                                                        true, false, false, true);
            
            	// If there isn't another editable cell in this row, just cancel the edit
                if (newEditCell == null || newEditCell[0] != editRow) {
                    this.cancelEditing(isc.ListGrid.PROGRAMMATIC);
                    return;
                } 
            	// startEditing the new cell. This will fire the editorExit handler on the
            	// previous cell and save out the value if appropriate.
            	// Note: don't focus in the new cell unless focus was already in the cell being
            	// made un-editable.
                this.startEditing(newEditCell[0], newEditCell[1], !fieldHasFocus);
            }
        	// Refresh the cell to actually display / hide the edit form item.
            this.refreshCell(this.getEditRow(), colNum);
        }
    }
},



//>	@method		listGrid.handleEditCellEvent()	(A)
// Handle an 'editCell' event - typically a click or double click on an editable ListGrid.
// Verifies that the cell passed in is a valid edit candidate before falling through to
// startEditing().
//
//	@group	editing
//
//	@param	rowNum      (number)	Row number of the cell to edit.
//	@param	colNum      (number)	Column number of the cell to edit.
//  @param  event       (editCompletionEvent)   How was this edit event triggered. If 
//                                      we shift focus to a new edit cell this event will be
//                                      passed to the editorExit handler(s) of the previous row.
//                                      Expected vals are "click", "doubleClick" or "focus"
//                                      (or null).
//  @param [newValue] (any) optional new edit value for the cell
//	@return	(boolean)	true if we are editing the cell, false if not editing for some reason
//<
handleEditCellEvent : function (rowNum, colNum, event, newValue) {
    // set a flag to notify us that we started this 'edit session' on keyPress
    // This is required for 'moveEditorOnArrow' behavior, which only applies to edit sessions
    // started on keypress
    // We can't use the _editorCursorAtEnd flag as that won't get set unless the value was 
    // modified, and we want the moveEditorOnArrow behavior even if the user started editing
    // from an f2 keypress...
    // This flag will be cleared 
    // - here if the user double clicks (etc) another cell
    // - by cellEditEnd unless the event is keyboard navigation to another cell
    if (event == this._$keyPress) this._editSessionFromKeyPress = true;
    else delete this._editSessionFromKeyPress

	// if they're trying to edit an invalid cell, return false
	if (rowNum < 0 || colNum < 0) return false;
	// can we actually edit that cell?  If not, bail.
    if (this.editByCell) {
         if (!this.canEditCell(rowNum, colNum)) return false;
    } else {
        // If the user double-clicks on a non-editable field and editByCell is 
        // false assume they want to start editing the row and put focus into the closest 
        // editable cell in that row.
        var editCell = this.findNextEditCell(rowNum, colNum, -1, true, true, false, true);
        if (editCell == null || editCell[0] != rowNum) 
            editCell = this.findNextEditCell(rowNum, colNum, 1, true, false, false, true);
            
        if (editCell == null || editCell[0] != rowNum) return false;
        // Update the colNum to reflect the closest editable cell to the one clicked if the
        // row is editable.
        colNum = editCell[1];
    }
    var undef;
    if (newValue !== undef) {
        this.setEditValue(rowNum,colNum, newValue);
    }
    
    // startEditing will save out the value in the previous edit cell if necessary...    
    return this.startEditing(rowNum, colNum, null, event);
},

// Show/Hide Inline Editor
// --------------------------------------------------------------------------------------------

//>	@method		listGrid.startEditing()	(A)
// Start inline editing at the provided coordinates.
// <p>
// Invoked when a cell is editable and the <code>editEvent</code> occurs on that cell.  Can
// also be invoked explicitly.
// <P>
// If this method is called while editing is already in progress, the value from the current
// editCell will either be stored locally as a temporary edit value, or saved via 'saveEdits()'
// depending on <code>this.saveByCell</code>, and the position of the new edit cell.<br>
// Will update the UI to show the editor for the new cell, and put focus in it unless 
// explicitly suppressed by the optional <code>suppressFocus</code> parameter.
//
//	@group	editing
//
//	@param	[rowNum]      (number)	Row number of the cell to edit.  Defaults to first
//                                  editable row
//	@param	[colNum]      (number)	Column number of the cell to edit.  Defaults to first
//                                  editable column
//  @param  [suppressFocus] (boolean)   If passed this parameter suppresses the default 
//                                  behavior of focussing in the edit form item when 
//                                  the editor is shown.
//	@return	(boolean)	true if we are editing the cell, false if not editing for some reason
//
// @see canEditCell()
// @see editEvent
// @visibility external
//<

startEditing : function (rowNum, colNum, suppressFocus, eCe) {

    // force editing on if it's not configured for any field, but a programmatic call is made
    if (!this.canEdit && !(this.completeFields || this.fields).getProperty("canEdit").or()) {
        this.canEdit = true;
    }

    // if setFields() has never been called, call it now.
    if (this.completeFields == null) this.setFields(this.fields);

	// Possibilities:
	// - This is an entirely new editing flow
	// - We are in an uncompleted editing flow
	// - We are currently showing an editor for another cell
    
	// What needs to happen?
	// - Showing a previous editor:
	//   *Save the new value from the edit cell locally into the temp set of editValues (for
	//     the appropriate record)
	//   *Hide the inline editor (unless it's another field in the same row and we're editing
	//     the whole row)
	// - Update edit info for this edit:
	//   *If we have no editFlowID, set up a new one
	//   *If there are no editValues stored for this record, store those values
	//   *Update the current editRowNum and editColNum, so we know which field is being edited

	// - show the editor:
	//   *Call 'showInlineEditor' to show the editor.  This will draw a new editor if required,
	//       or just focus in the appropriate field of the existing editor.

    // default to editable row / col
    var noRow = (rowNum == null),
        noCol = (colNum == null);
    if (noRow || noCol) {
        var testRow = (noRow ? 0 : rowNum),
            testCol = (noCol ? 0 : colNum);
        var newCell = this.findNextEditCell(testRow, testCol, 1, noCol, true);
        if (newCell == null) {
            this.logInfo("startEditing() passed bad cell coordinates:" + [rowNum, colNum]);
        } else {
            this.logInfo("startEditing() using derived coordinates:"+ newCell);
            rowNum = newCell[0];
            colNum = newCell[1];
        }
    }
    // Legal coordinates are 
    // - any rowNum within the dataSet
    // - any rowNum for which we already have editValues (even if the record has not been saved)
    // - one rowNum past our last row (== this.getTotalRows()). In this case we'll be creating 
    //   a new row on the end of the list.
    // Bail if the coordinates are not legal.
	if (rowNum == null || rowNum < 0 || rowNum > this.getTotalRows()) {
		//>DEBUG
		this.logWarn("startEditing() passed bad cell coordinates:" + [rowNum, colNum] + 
                        ", can't edit", "gridEdit");
		//<DEBUG
		return false;
	}
    
    if (!this.canEditCell(rowNum, colNum)) {
		//>DEBUG
		this.logInfo("startEditing(): cell " + [rowNum, colNum] + 
                     " is non editable. Returning.", "gridEdit");
		//<DEBUG
		return false;
    }
    
    // at this point we have a valid cell to start editing.
    // If we're showing an editor, allow 'changeEditCell()' to handle saving out the
    // previous cell value, etc. - otherwise just call _startEditing() to start the edit 
    // process
    if (this._editorShowing) {
        this._changeEditCell((eCe || isc.ListGrid.PROGRAMMATIC), 
                             this.getEditRow(), this.getEditCol(), rowNum, colNum);
    } else {
    
    	// Punt it over to _startEditing to handle the actual editing
        this._startEditing(rowNum, colNum, suppressFocus);
    }

    // return true to indicate editing has begun
    
    return true;
},

// _changeEditCell()
// Internal method used by both 'startEditing' and 'cellEditEnd' to complete editing one cell
// and start editing another.
// This method will fire user event / change handlers, and save out the edit values if 
// appropriate.
// Falls through to _startEditing() to handle updating the display (hides this editor and shows
// the new one), and setting up the editValues for the new edit row.
_changeEditCell : function (editCompletionEvent, currentRowNum, 
                            currentColNum, newRowNum, newColNum) 
{

    // Note that the getEditValue() method will automatically pick up the current value
    // of the form item and store it in the edit-values
	// Note - this will fire the 'editorChange()' handler if the value has changed.
    var newValue = this.getEditValue(currentRowNum, currentColNum);

	// if we never fired 'editorEnter' avoid firing editor exit.
	
    var fieldName = this.getFieldName(currentColNum),
        editForm = this._editRowForm,
        editItem = editForm ? editForm.getItem(fieldName) : null,
        shouldFireEditorExit = editItem ? !editItem._cellEnterOnFocus : true
    ;
    if (editItem) {
        // If the edit item never got focused, the 'enterOnFocus' tags will still be present
        // just clean these up since we'll reset them if necessary (if focus goes back to the row)
        delete editItem._cellEnterOnFocus;
        delete editItem._rowEnterOnFocus;
        
        
        if (this._shouldParkFocus(editItem, currentRowNum, newRowNum, newColNum)) {
            this._parkFocus(editItem, currentColNum);
        }
    }
    
	// determine whether we need to validate or save on this cell transition
    // Use _getEditValues() - we already updated the editValue if necessary
    var leavingRow = (newRowNum != currentRowNum),
        newValues = this._getEditValues(currentRowNum, currentColNum);
                
	// Fire any developer defined handlers to fire when the user attempts to exit the edit cell
	// Stop if 'editorExit' handlers returned false.
    if (shouldFireEditorExit) {
        var editKilled = !this._handleEditorExit(editCompletionEvent, 
                                                 currentRowNum, currentColNum, newValue);
        if (leavingRow && !editKilled) {
            editKilled = !this._handleRowEditorExit(editCompletionEvent, currentRowNum, newValues);
        }
        
        if (editKilled) {
        	// If the editorExit handlers didn't already cancel this edit, or start a new one, force
        	// focus back into the current edit field.
        	// This is required as focus may not be in this form field
        	
            if (editCompletionEvent == isc.ListGrid.EDIT_FIELD_CHANGE) {
                var newFieldName = this.getFieldName(newColNum);
                if (editItem && editForm.getItem(newFieldName).hasFocus) {
                    editItem.focusInItem();
                }
            }
            return false;
        }
    }
    
    var saveNow = (this.autoSaveEdits &&
                    ((leavingRow && 
                     this.shouldSaveOnRowExit(currentRowNum, currentColNum, editCompletionEvent)) || 
                     this.shouldSaveOnCellExit(currentRowNum, currentColNum, editCompletionEvent)));
            
    // The 'neverValidate' property effectively disables validation for form items. 
    // Otherwise: 
    // - If we're saving, we avoid validating here, since saving will auto-validate for us.                        
    // - otherwise perform cell or row validation based on this.validateByCell / this.autoValidate
    
    if (!saveNow && this._validationEnabled()) {
        var validationFailed,
            validateRow = leavingRow &&
                          this.shouldValidateByRow(currentRowNum, currentColNum, editCompletionEvent);
        // Note that if we're working with cellRecords we call validateCell() directly
        // if we should validate the row
        if (validateRow && !this.usingCellRecords) {                       
            validationFailed = !this.validateRow(currentRowNum);            
        // If we're not validating the entire row, determine whether we should validate the
        // cell individually
        } else {                        
            if (validateRow || 
                this.shouldValidateByCell(currentRowNum, currentColNum, editCompletionEvent)) 
            {    
                validationFailed = !this.validateCell(currentRowNum, currentColNum);
            }
        }

        // Suppress navigation if validation failed. No need to show error to user - already
        // handled by the validation methods.
        if (this.stopOnErrors && validationFailed) return false;
    }  
    
    // At this point the old editor is still showing, but values have been updated, and 
    // handlers fired.  Fall through to _startEditing to handle hiding this editor and showing
    // the new one.
	
    if (saveNow) {    
        return this._saveAndStartEditing(newRowNum, newColNum, editCompletionEvent);
    } else {
    	// proceed immediately to next cell  
        this._startEditing(newRowNum, newColNum);
    }
},


_shouldParkFocus : function (editItem, currentRowNum, newRowNum, newColNum) {
    if (!isc.Browser.isIE) return false;

    // If current focus is in a non-text-based item we don't need to park focus - selection
    // will update as appropriate.
    var textBasedFocusItem = (isc.isA.PopUpTextAreaItem(editItem) && 
                              // in a difficult-to-reproduce case, editItem._popupForm can end up
                              // undefined when hiding columns while editing.  This check
                              // prevents a JS error, but may still cause focus to skip
                              editItem._popupForm && editItem._popUpForm.hasFocus) ||
                             (editItem.hasFocus && isc.FormItem._textBasedItem(editItem));
    //if (!textBasedFocusItem) return false;
    
    // If we will not be removing the current item from the DOM, we don't need to park focus.
    
    if (!this.editByCell && newRowNum == currentRowNum) return false;
    
    // If the new item is text-based - no need to park focus
    var newEditorType = 
        this.getEditorType(this.getField(newColNum), this.getCellRecord(newRowNum, newColNum));
    return !(newEditorType == null || isc.FormItem._textBasedItem(newEditorType, true));
    
},

// Internal method to unconditionally start editing a rowNum / colNum.
// This method will 
//  - hide the current editor (if appropriate)
//  - set up edit values for the new cell
//  - show the editor for the new cell (and focus unless suppressFocus param passed)
// o Does not check for validity of rowNum / colNum
// o Does not save / modify pending edit values for some other cell/row
_startEditing : function (rowNum, colNum, suppressFocus) {

	
    if (rowNum == "delayed") {
    	// we're firing from a timer for a delayed edit
        
    	// another call to startEditing happened while we were waiting for the timer to fire,
    	// and its params took precedence
        var params = this._delayedStartEditing;
        if (params == null) return;

        rowNum = params[0];
        colNum = params[1];

    	
        
    } else if (this.isDrawn() &&
                (!this.body.readyToRedraw() || 
                 (this.frozenBody && !this.frozenBody.readyToRedraw())))
    {
    	// set a timer if we have not already set one, otherwise, just update the parameters
    	// for the delayed edit
        if (!this._delayedStartEditing) {
            this.delayCall("_startEditing", ['delayed'],0);
        }
        this._delayedStartEditing = [rowNum, colNum];
    	
        return;
    }

	// we're starting editing now, we don't need the delayed edit params (the current
	// startEditing invocation overrides them)
    delete this._delayedStartEditing;
    
    var changingRow = this.getEditRow() != rowNum;
        
    // On a call to startEditing the current editRow / col, just put focus into the
    // field editor in question
    if (!changingRow && (this.getEditCol() == colNum)) {
        this.getEditForm().focusInItem(this.getEditorName(rowNum, colNum));
        return;
    }

	//>DEBUG
    this.logInfo("Starting editing at row " + rowNum + ", colNum " + colNum, "gridEdit");
	//<DEBUG
 
    // if we currently have an embedded editor showing, dismiss it   
    if (this._openRecord != null) this.closeRecord();
    if (this._editorShowing) {
    	// if we're changing rows, or only editing one cell at a time, hide the current editor,
    	// as it has no overlap with the old editor
        if (this.editByCell || changingRow) {
        
        	// hide the editor (but don't focus back in the body), and don't hide the CM as
        	// we're about to show another editor.
        	
            this.hideInlineEditor(false, true);
        }
    }
    
    
    
	// We're in a new edit flow if
	// - this._editingFlowID is null
	// - saveByCell is false
	// - we're editing a cell in a different row.
	// Otherwise this method is just showing the editor for a different cell
	
    var newEditFlow = (this._editingFlowID == null)  ||
                      changingRow ||
                      this.saveByCell;
    
    if (newEditFlow) {
        this._editingFlowID = this._getNextEditFlowID();
    }

    //this.logWarn("about to start editing, editValues for row: " + rowNum + " are now: " +
    //             this.echo(this.getEditValues(rowNum)));
    
    // Set up initial empty edit vals
	        
    var displayNewValues = this._editorShowing && (this.getEditRow() == rowNum)
    this.initializeEditValues(rowNum, colNum, displayNewValues);
    
    // At this point - we are definitely going to start editing the new row, and the editValues
    // have been set up.
    // If 'selectOnEdit' is true, select the row.
    
    var record = this.getCellRecord(rowNum, colNum);
    if (this.selectOnEdit && record != null) this.selectRecordForEdit(record);

	// If this is a new record, and 'addNewBeforeEditing' is true, we want to create the new
	// edit record BEFORE we start editing it - we do this via the standard 'saveEdits()' 
	// method - this will save out the newly created editValues.
	// The save, which may be asynchronous, may modify the values of the saved record, setting
	// up default field values, etc.  We want to reflect these changes in the edit data for
	// the record.
	// Handle this by having a method _updateNewEditRowValues() update the edit values for the
	// row with the values taken from the record.
	// We continue to show the editor on the newly created row, either now, or if wait for save
	// is true, after the save occurs.
    if (record == null && this.addNewBeforeEditing) {
    	// Hang onto the editRow / col, so we know what cell we're currently editing
    	// This is usually done in 'showInlineEditor' but we need this for the saveEdits call
    	// in this case
        this._editRowNum = rowNum;        
        this._editColNum = colNum;
        var waitForSave = this.shouldWaitForSave();
    
        
        var callback = "this._updateNewEditRowValues(" + waitForSave + "," + suppressFocus + ")" ;
        this.saveEdits(isc.ListGrid.PROGRAMMATIC, callback);
        if (waitForSave) return;
        else {
        	// The 'saveEdits()' call above may have changed the edit row's position.
            rowNum = this._editRowNum;
            colNum = this._editColNum;
        }
    }
	// - show the editor:
	//      - if the editor is showing for the same row, this will just focus
	//      - if another row, or editByCell, this will update the edit form, and show it in 
	//        the right place
    // Note that 3rd param is always true - we'll be calling showInlineEditor to show the
    // same cell in this method.
    this.showInlineEditor(rowNum, colNum, true, changingRow, suppressFocus);
    
    return true;

},

// Select the record about to be edited
selectRecordForEdit : function (record) {
    // perf: avoid updating the row we're about to draw editors into anyway
    
    if (!this.editByCell) record._ignoreStyleUpdates = true; 
    
    if (this.canSelectCells) {
          var cell = this.getRecordCellIndex(record);
          this.selection.selectSingleCell(cell[0],cell[1]);
    } else {
        this.selection.selectSingle(record);
    }
    delete record._ignoreStyleUpdates;

},


// For text-based editors, update selection on focus
// The behavior we want is:
// - if the user started editing via editOnKeyPress (they started typing in the cell), put focus
//   at the end of the value so they don't wipe out what they already typed
// - otherwise respect this.autoSelectEditors
// We achieve this via a temporary flag set when we start editing a cell via 'editOnKeyPress'
_updateEditorSelection : function (item) {
    // applies only to text items (and subclasses)
    if (!isc.isA.TextItem(item) && !isc.isA.TextAreaItem(item) &&
        !(isc.isA.DateItem(item) && item.useTextField)) return;
    var element = isc.isA.DateItem(item) ? item.dateTextField.getDataElement() : item.getDataElement();
    if (!element) return;
    if (this._editorCursorAtEnd || !this.autoSelectEditors) {
        var val = item.getDataElement().value || "";
        item.setSelectionRange(val.length, val.length);
        // Assertion: we only want this special behavior of putting the cursor at the end after
        // the first 'focus()' on the item the user typed in, so clear out the flag here
        delete this._editorCursorAtEnd;
    } else {
        element.select();        
    }
},

// Helper method to update the edit row values for the special case where we have saved out a
// new record before editing it due to 'addNewBeforeEditing'

_updateNewEditRowValues : function (showEditor, suppressFocus) {

    var rowNum = this._editRowNum,
        colNum = this._editColNum,
        record = this.getCellRecord(rowNum, colNum);

    if (record != null && record != "loading") {
    	
        var values = this.getEditValues(rowNum, colNum);
        for (var i in record) {
        	
            if (record[i] != null && values[i] == null) {
                values[i] = record[i];
            }
        }
    }

    if (showEditor) this.showInlineEditor(rowNum, colNum, true, true, suppressFocus);
    else this.updateEditRow(rowNum);
	// Note - no need to explicitly focus in the editor here - this will be handled by 
	// showInlineEditor if we're showing a new editor - and if we're already showing the
	// editor we don't need to modify it's focus
},

//>	@method		listGrid.editField()	(A)
//
//  Start editing a specific field.  This will save the current edit if appropriate.
//  
//	@group	editing
//
//	@param	fieldName   (string)    Field to start editing
//	@param	[rowNum]  (number)	Optional row to start editing - if null defaults to the current
//                              edit row.
//	@return	(boolean)	true if we are editing the cell, false if not editing for some reason
//
// @see canEditCell()
// @see editEvent
//<
editField : function (fieldName, rowNum) {
    // If this grid has not yet been drawn, this.fields may not have been set up yet
    if (this.completeFields == null) this.setFields(this.fields);

    var colNum;
    if (isc.isA.Number(fieldName)) colNum = fieldName;
    else colNum = this.fields.findIndex(this.fieldIdProperty, fieldName);
    if (rowNum == null) {
        rowNum = this.getEditRow();
        // It's legal to pass in no rowNum param, but if we're not already editing a row,
        // bail with a warning.
        if (rowNum == null) {
            this.logWarn("editField(): unable to determine which row to edit - returning.", 
                        "gridEdit");
            return;
        }
    }
    // Fall through to startEditing() to handle performing the edit.
    return this.startEditing(rowNum, colNum);
},

// create or update the editForm to reflect the editable and visible fields around the given
// coordinate, and show editors.
// Focuses in the target cell unless suppressed.
// internal: assumes we are logically set up to edit this row (editValues created)
// Application developers would call 'startEditing()' instead of this method

// this method is also responsible for firing editorEnter handlers when focus goes to the
// new edit cell - handled by setting up a flag to be checked by the form item's focus() handler.
showInlineEditor : function (rowNum, colNum, newCell, newRow, suppressFocus) {
    // This method is called in the following circumstances:
    // - we need to re-set focus to the current edit cell (example: setFields, redraw of body, etc)
    // - we need to move focus to a new cell that is already showing (called from startEditing())
    // - The editor is currently hidden and we need to show it (and put focus into the
    //   appropriate cell).
    // It is not expected to be called when the editor is currently showing for another
    // row (or for editByCell grids, another cell) - this method should not have to handle
    // hiding the edit form just showing it (if necessary) and assiging focus.
    //
	// NOTE: if we're doing full-row editing and the editForm is already showing, we assume the
	// current edit field's value has already been updated / saved by 'startEditing' call
	// whenever appropriate.
    if (this._editorShowing) {
    	// Catch the case where we're showing the edit form for another row
        if (rowNum != this.getEditRow() || (this.editByCell && colNum != this.getEditCol())) {
            this.logWarn("Unexpected call to 'showInlineEditor' during another edit " +
                         "- cancelling previous edit", "gridEdit");
            this.cancelEditing();
            this.startEditing(rowNum, colNum);
            return;
        }
    } 

    this.logDebug("showing inline editor at: " + [rowNum, colNum] + 
                  ", will focus: " + !suppressFocus, "gridEdit");

	
    var scrollBeforeShowing = this.body && (!this.body.showAllColumns || !this.body.showAllRows);
    if (scrollBeforeShowing) {
        // set scrollRedrawDelay to zero before scrolling into view. This ensures that the body will
        // be marked dirty instantly if a redraw is required, which in turn makes sure we set up the
        // correct set of form items
        var srd = this.body.scrollRedrawDelay;
        this.body.scrollRedrawDelay = 0;
        this.scrollCellIntoView(rowNum, colNum, false);
        this.body.scrollRedrawDelay = srd;
    }
    
    // If we're showing the rollOver canvases, clear them now
    if (this.rollOverCanvas && this.rollOverCanvas._currentRowNum == rowNum) {
        this.updateRollOverCanvas(this.rollOverCanvas._currentRowNum,
                                  this.rollOverCanvas._currentColNum, true);
    }
        
    
    if (!this._editorShowing) {
    	// create or update the editForm used to display editors for the fields.
        this.makeEditForm(rowNum, colNum);
    }    
    
	// Update the remembered editColNum
    this._editRowNum = rowNum;    
    this._editColNum = colNum;
	// write the editor form items into the DOM
    this._showEditForm(rowNum, colNum);

    
    // Ensure the edit cell is visible in the viewport
    
    if (this.body) {   
        var mustScroll;
        if (!scrollBeforeShowing) mustScroll = true;
        else {
            var body = this.body,
                rowTop = body.getRowTop(rowNum),
                rowHeight = body.getRowSize(rowNum),
                scrollTop = body.getScrollTop(),
                portHeight = body.getViewportHeight();                
            mustScroll = (rowTop < scrollTop) || (rowTop + rowHeight > scrollTop + portHeight);
        }
        if (mustScroll) this.scrollCellIntoView(rowNum, colNum, false);
    }    

	// Don't show the click mask, or focus in the form item if we're not drawn.
    if (!this.isDrawn()) return;
    this._showEditClickMask();
    var focusItemName = this.getEditorName(rowNum, colNum),
        focusItem = this._editRowForm.getItem(focusItemName);

	// focusItem should be present since we've just scrolled it into view, but perform
	// check for safety anyway
    if (focusItem == null) {
        this.logWarn("ListGrid showing inline editor. Unable to get a pointer to the edit " +
                        "form item for field:"+ focusItemName);
        return;
    }
    
    // If this is a shift to a new cell, we'll want to fire editorEnter.
    // If a new row, we'll want to fire rowEditorEnter.
    // [Otherwise this method could be a refresh / refocus of current edit cell]
    

	
    if (newCell) focusItem._cellEnterOnFocus = true;
    if (newRow) focusItem._rowEnterOnFocus = true;
	// focus in the field being edited if appropriate
    if (!suppressFocus) {
        
        if (isc.Browser.isMoz) {
        	
            var handle = this.body.getClipHandle(),
                beforeFocus = handle.scrollTop;
        }
        
    	
        var lastEvent = isc.EH.lastEvent;
        var delayFocus = (isc.Browser.isIE && lastEvent.eventType == isc.EH.MOUSE_DOWN && 
                                              lastEvent.target != this._editRowForm);

        
        if (isc.Browser.isIE) {
            var focusParkForm = isc.ListGrid._focusParkForm;
            if (focusParkForm && 
                (focusParkForm.hasFocus || focusParkForm.itemHasFocus())) delayFocus = true;
        }
        if (delayFocus) {            
            this._delayedFocusEvent = isc.Timer.setTimeout(
                this._editRowForm.getID() + ".focusInItem('" + focusItemName + "');",
                0
            );
        
        } else {
            
            if (isc.Browser.isMoz && this.body.overflow == isc.Canvas.VISIBLE) {
                this.adjustOverflow();
            }
            this._editRowForm.focusInItem(focusItemName);
        }
    }
},

// Write the editor form items into the cells in the ListGrid body, by redraw or refresh
// Re-evaluates canEditCell(), so may hide editors or show new editors.
// Internal: purely a helper to showInlineEditor
_showEditForm : function (rowNum, colNum) {
    
    var editorWasShowing = this._editorShowing;    
    this._editorShowing = true;
    if (!this.isDrawn() || !this.body) return;
    
	// The edit form has been created, and we need to show its items in the DOM.
	// 3 cases to catch:
	//  - Some edit form items are already showing for the edit row:
	//     If editByCell is false, it's possible that the 'canEditCell' criteria have changed
	//     for some currently visible edit cells.
	//     Need to refresh any cells where this is the case to show / hide form items.
	//  - No edit form items are showing
	//    - if the edit row is beyond the end of the list, we need to redraw the body to
	//      display the new edit row.
	//    - Otherwise for each cell where canEditCell is true, we must refreshCell() to write
	//      the form item into the DOM.

	// If we're showing the editor for a new edit row at the end of the list that's not currently
	// in the DOM redraw the body
    // Note: if this._editorShowing was true at the start of this method, we know we're
    // editing a new cell in the current edit row (_startEditing will hide the inline editor 
    // if we're editing a different row). In this case we only need to redraw the body if it's
    // already been marked as dirty.
    
	
    var newRow = this.isEmpty() ||
                 (!editorWasShowing &&   
                    (rowNum >= this.data.getLength()) && 
                    (this.showNewRecordRow || 
                     (this.body.getTableElement(rowNum, colNum) == null)));
                  
    if (newRow || this.body.isDirty() || (this.frozenBody && this.frozenBody.isDirty())) {
        
        var body = this.bodyLayout ? this.bodyLayout : this.body;
        body.redraw("Showing editor");
        return;
    }

	// otherwise, editor is showing for the same row   
    if (this.editByCell) {
    	// editing by cell - just refresh the edit cell to show the editor.
        this.refreshCell(rowNum, colNum);
    } else {
    	// editing whole row - draw editors into the currently visible cells
        
        
        
        // use getDrawnFields() to retrieve the set of drawn fields (takes care of frozen fields and
        // incremental rendering)
        var fields = this.getDrawnFields();
    	// Check the 'canEdit' status of each cell in the edit row and refresh to show (or hide)
    	// editors as appropraite.
        
        for (var i = 0; i < fields.length; i++) {
            if (this.isCheckboxField(fields[i])) continue;
                
            var fieldName = fields[i][this.fieldIdProperty],
                formItem = this._editRowForm.getItem(fieldName),
                colNum = formItem.colNum,
                
                formItemVisible = !!(editorWasShowing && formItem.isDrawn()),
                canEditCell = this.canEditCell(rowNum, i)
            ;
            if (formItemVisible != canEditCell) this.refreshCell(rowNum, colNum);
            // For cells we are not redrawing, we need to update the cellStyle if:
            // - This is the last over row - need to clear the current 'over' style since we 
            //   will not be showing  rollovers for the edit row.
            // - ensure the row shows up in the 'selected' state if selectOnEdit is true
            else if (this.selectOnEdit || this.lastOverRow) {
                this.body._updateCellStyle(this.getCellRecord(rowNum, colNum), rowNum, colNum);
            }
        }
    }
},

// show the clickmask to catch clicks outside the editors, which means we're done editing
// the row (and should save) if this.modalEditing is true.

_showEditClickMask : function () {

    //!DONTCOMBINE
	// only show the C.M. if this.modalEditing is true.
    if (!this.modalEditing) {
    	// Note - if a hover is showing, or pending on the body, clear it now.
    	
        if (this.canHover) this.stopHover();
        return;
    }
     
	// if the editRowForm CM is already up, no need to show it.
    if (!this._editRowForm.clickMaskUp()) {
        if (!this._editClickMaskFunction) 
            this._editClickMaskFunction = 
                new Function(this.getID() + "._handleClickOutsideEditor()");
        
        this._editRowForm.showClickMask(this._editClickMaskFunction, 
                                    // If this.stopOnErrors is true, always cancel the
                                    // 'mouseDown' that dismisses the clickMask.
                                    // [technically this should only be required if there 
                                    //  actually *are* errors, but since errors may come
                                    //  back from an asynch save it's appropriate to always
                                    //  cancel here].
                                    (this.stopOnErrors ? isc.EH.SOFT_CANCEL : isc.EH.SOFT), 
                                    // pass in the editForm to ensure that the form items
                                	// are not masked
                                    this._editRowForm);
    }
},

//> @method ListGrid.stopHover()
// Notification that the user is no longer hovering over some cell. Hides the current hover canvas
// if one is showing. 
// @visibility external
//<
// Implemented at the Canvas level

// shouldWaitForSave()
// Should we block user interactions during save, or allow the user to keep editing.
// If this function returns true, we wait for a save to return successfully before moving to
// a new edit cell, or hiding the current editor.
// This depends on this.waitForSave, and this.stopOnErrors.
// Note that we can't really support stopOnErrors = true / waitForSave = false, as we will not
// know if we have validation errors from server logic until a save has completed (performing
// a server round trip), and stopOnErrors implies we want to leave the editor up (as well as 
// alerting the error messages).
shouldWaitForSave : function () {
    if (this.stopOnErrors && !this.waitForSave) {
        var message =
            "Note: ListGrid initialized with 'waitForSave' false, and 'stopOnErrors' true." +
            " In this case user input will be be blocked during save, to allow server side " +
            " errors to be determined before the editor is hidden. Setting 'waitForSave' to true.";

    	// Log this at the info level rather than the warning level unless waitForSave has 
    	// explicitly been set to 'false', as it is very likely to occur
        if (this.waitForSave == false) this.logWarn(message, "gridEdit");
        else this.logInfo(message, "gridEdit");
        
    	// actually update 'waitForSave' -- this will avoid us showing this log repeatedly
    	// when this method is run.
    	// Note - if we want to support modifying these values on the fly 
    	// ("setStopOnErrors" / "setWaitForSave") we will have to take this modification into
    	// account too.
        this.waitForSave = true;
    }
    
    
    return !!(this.waitForSave || this.stopOnErrors);
},

// Hide the editor(s) for the current edit row.  Internal

hideInlineEditor : function (focusInBody, suppressCMHide) {
    
    // focusInBody is intended to restore focus to the body after hiding the (focussed) editor
    // Therefore check for whether the body or the edit form currently has focus and only
    // refocus if so
    focusInBody = focusInBody && (this.hasFocus || this.body.hasFocus || 
                                    (this.getEditForm() && this.getEditForm().hasFocus) ||
                                    (isc.ListGrid._focusParkForm &&
                                     isc.ListGrid._focusParkForm.hasFocus));    
                          
    // - clear out the flags marking the editor as being visible
	// - If we're showing the editor for a new temporary edit row, who's values have been 
	//   cleared, but we're still showing the row in the DOM, redraw the body to clear the row 
	//   from the DOM
	// - otherwise call 'refreshCell()' for each cell currently showing a form item to clear
	//   it from the DOM.
    
	// If we aren't curently editing a row, no-op
    if (!this._editorShowing) return false;
 
	
    this._editorShowing = null;
    
    // clear _editorSelection flag - ensures we don't inappropriately refocus in the edit form
    // after redraw if we subsequently re show the editor.    
    this._editorSelection = null;
    
    var editRow = this._editRowNum,
        editField = this._editColNum;
    this._editRowNum = this._editColNum = null;        

	

	// ensure that the clickmask gets taken down after edit
	// We suppress this step when we're hiding an editor, then reshowing - for example on
	// ListGrid redraw / cell navigation.
	
    if (!suppressCMHide) this._editRowForm.hideClickMask();
    
    // At this point, if we have edit values for the row, but they match the underlying
    // data values, just drop them.
    
    if (this.getEditValues(editRow, editField) != null && 
        (!this._savingEdits || !this._savingEdits[this.getEditValuesID(editRow, editField)]) && 
        !this.recordHasChanges(editRow, editField, false))
    {
        this.logInfo("hideInlineEditor for row with no edits - dropping edit values", "gridEdit");
        // Don't hang onto the empty edit values for the row
        this._clearEditValues(editRow, editField);
    }

    if (!this.body) return true;

	// update the visible cells.  Now that editRow/Field is unset, they'll revert to normal
	// display.  NOTE: don't bother updating if we're already slated to redraw the body
	
    var editForm = this._editRowForm;

    if (editForm.hasFocus) {    
        editForm.blur();
    }
    if (isc.Browser.isIE) {
        var focusItem = editForm.getFocusItem(),
            unconfirmedBlur = isc.EH._unconfirmedBlur;
        if (editForm.hasFocus || 
            (unconfirmedBlur && 
                ((unconfirmedBlur == editForm) || (isc.EH._unconfirmedBlur.form == editForm)) ) ) 
        {
        	
            focusItem.elementBlur();

            // Another artefact of IE's asynchronous focus handling behavior is that
            // if 'blur()' is called on a text item, then the item is cleared from the DOM
            // before onblur fires, and 'focus()' is called on another item in the DOM, when the
            // user hits a key, focus will be pulled from the new focus item for no good reason.
            // We work around this here by putting focus in the 'focus park form'.
            
            this._parkFocus(focusItem, editField);        
        }
    }
    
    if (!this.body.isDirty() && (!this.bodyLayout || !this.bodyLayout.isDirty()) && !this.isDirty()) 
    {
    	// if we're hiding an additional edit row, we have to redraw the body to remove the
    	// row from the DOM.
        if (editRow >= this.getTotalRows()) {            
            var widget = this.bodyLayout || this.body;
            widget.markForRedraw("Editor Hidden");
        } else {            
            if (this.editByCell) this.refreshCell(editRow, editField)
            else this.refreshRow(editRow);
        }
    }
    
    if (focusInBody) {
    	// return focus to the body
    	// -- ensure we don't editOnFocus via the 'suppressEditOnFocus' flag
    	//    (will get cleared out by _focusChanged on the body)
        this._suppressEditOnFocus = true;
        
                
        this.body.focus();
    }
    return true;
},

_parkFocus : function (focusItem, editField) {
    
    if (isc.isA.TextItem(focusItem) || isc.isA.TextAreaItem(focusItem) || 
        isc.isA.PopUpTextAreaItem(focusItem)) 
    {
        var focusParkForm = isc.ListGrid._focusParkForm;
        
        // If the hidden text item we use for managing focus doesn't exist, create it
        // here.
        if (!focusParkForm) {
            focusParkForm = isc.ListGrid._focusParkForm = isc.DynamicForm.create({
                
                // Ensure that if this gets destroy'd we also clear up the pointer to it
                pointersToThis:[{object:isc.ListGrid, property:"_focusParkForm"}],
                getFocusParkItem: function () {
                    return this.getItem(0);
                },
                autoDraw:false,
                _redrawWithParent:false,
                ID:"_ListGrid_focusParkForm",
                _generated:true,
                selectOnFocus:true,
                tabIndex:-1,
                items:[
                    {name:"textItem", type:"text",
                        // Suppress all key event handling - this will avoid the user from 
                        // being able to tab out of this focus parking form (temporarily
                        // putting focus somewhere else on the page)
                        handleKeyPress:function(){return false;}
                    }
                ],
                width:1, height:1, overflow:isc.Canvas.HIDDEN,
                
                itemHasFocus : function () {
                    var item = this.getFocusParkItem();
                    if (item.hasFocus) return true;
                    if (isc.Browser.isIE && this.isDrawn() && this.isVisible() &&
                        (this.getActiveElement() == this.getFocusParkItem().getFocusElement()))
                            return true;
                    return false;
                },
                redraw : function () {
                    var forceRefocus = false;
                    if (this.itemHasFocus()) forceRefocus = true;
                    this.Super("redraw", arguments);
                    if (forceRefocus) this.focusInItem(this.getFocusParkItem());
                }
            })
        }
        // Ensure the hidden text form is drawn in our scope and float it under us.
        // As a child it will be cleared() / destroyed() if we are as well.
        // Avoids any unexpected native scrolling issues with focus change.
        if (focusParkForm.parentElement != this) {
            if (focusParkForm.isVisible()) focusParkForm.hide();
            this.addChild(focusParkForm);
        }
   
        //this.logWarn("moving focusPark form, editCol: " + editField +
        //             ", column left: " + this.getColumnLeft(editField) + 
        //             ", scrollLeft: " + this.body.getScrollLeft());
                    
        focusParkForm.moveTo(
            this.getColumnLeft(editField) - this.body.getScrollLeft(),
            Math.min(
                ((this.showHeader ? this.headerHeight : 0) + this.getRowTop(this.getEditRow()) 
                        - this.body.getScrollTop()),
                this.getScrollHeight()-1
            )
        );
    
        focusParkForm.moveBelow(this.body);
        // focusParkForm must be visible to recieve focus
        focusParkForm.show();
        
        // If we're showing the edit clickMask, unmask the focusParkForm wrt that so we don't
        // dismiss the editor when it recieves focus
        
        if (this._editRowForm.clickMaskUp()) focusParkForm.unmask(this._editRowForm.getID());
        
        // Put focus into the text item.
        focusParkForm.getFocusParkItem().focusInItem();
        
        // Ensure the editRowForm is aware it doesn't have focus any more 
        
        focusItem.form.hasFocus = false;
    }    
},


// Create inline editing form and items
// --------------------------------------------------------------------------------------------

// create a DynamicForm for inline editing.  This form manages FormItems embedded in GR cells,
// but does not actually draw them.
// It's up to the calling function to handle displaying these edit form items in the DOM.
makeEditForm : function (rowNum, colNum) {

    var record = this.getCellRecord(rowNum, colNum),
    	// get currently visible items
        items = this.getEditRowItems(record, rowNum, colNum, this.editByCell),
        // get the values for the form
        
        values = this.getEditDisplayValues(rowNum, colNum)
    ;
    
    if (this._editRowForm != null) {
    	// just update the items array and current values if the form already exists
    	//this.logWarn("rebuilding editRowForm" + this.getStackTrace());
        this._editRowForm.setItems(items);
        this._editRowForm.setValues(values);
        
    } else {
    	//this.logWarn("creating editRowForm..." + this.getStackTrace());
    	// create the editForm.  Done once only per grid lifetime
        this._editRowForm = isc.DynamicForm.create(this.editFormDefaults, {
        	// keep track of the listGrid
            grid:this,
            // for AutoTest apis
            locatorParent:this,
            
            showErrorIcons:this.showErrorIcons,
            
            // Give the form the same tabIndex - this is not relevant in most ListGrids,
            // since the clickMask / keypress handling will prevent tabbing in and out of the 
            // edit form, but we rely on this behavior in the RecordEditor class where the user
            // must be able to tab in and out of the edit row.
            tabIndex:this.getTabIndex(),
                
        	// pass it this widget's datasource too
            dataSource:this.dataSource,

            autoComplete:this.autoComplete,
            uniqueMatch:this.uniqueMatch,
        	// Avoid autoFocus - we explicitly focus and blur when appropriate.
            autoFocus:false,
    
            items:items,
            values:values
        });
    } 
    if (this.logIsDebugEnabled()) {
        this.logDebug("editRowForm created with values: " + 
                      this.echo(this._editRowForm.getValues()), "gridEdit");
    }
},

// Allow direct (undocumented) access to the edit form even in obfuscated builds
getEditForm : function () {
    return this._editRowForm;
},


// These helpers are required to allow rowNum / colNum based edit values management
// rather than fieldName based valuesManagement.


// NOTE: this differs from getEditItem() - it's retrieving an existant item in the edit form 
// for a cell -- not retrieving the properties to create a form item object
getEditFormItem : function (colNum) {
    var editForm = this.getEditForm();
    if (!editForm) return null;
    var fieldName = this.getEditorName(this.getEditRow(), colNum),
        item = editForm.getItem(fieldName);
    // sanity check - if item.colNum != the colNum passed in assume the editorName is reused for
    // multiple fields
    if (item && item.colNum == colNum) return item;
},

getEditFormValue : function (colNum) {
    var item = this.getEditFormItem(colNum);
    return (item ? item.getValue() : null);
},

// helper: sets edit form items to latest editValues (including reverting to original record
// values if editValues have been cleared)
_updateEditItemValues : function () {
    if (!this._editRowForm) return;

    var rowNum = this.getEditRow(), colNum = this.getEditCol(),
        values = this.getEditDisplayValues(rowNum, colNum);
        
    this._editRowForm.setValues(values);
},


// Helper method to get all the values for the edit form at once
getEditDisplayValues : function (rowNum, colNum) {

    var editValues = this.getEditValues(rowNum, colNum),
        record = this.getCellRecord(rowNum, colNum),
        values = {};
    
    for (var fieldName in record) {
        values[fieldName] = record[fieldName];
    }
    for (var fieldName in editValues) {
        values[fieldName] = editValues[fieldName];
    }
    return values;
},

// Method to get the horizontal space available for the form items for each column
// (Note this is not a 1:1 mapping to form items, as not every field is editable, and we
// incrementally create form items for columns as they are rendered out)
// Overridden by TreeGrid to account for indentation in tree field.
getEditFormItemFieldWidths : function (record) {
    var widths = [];
    for (var i =0; i<this.fields.length; i++) {
        var colNum = this.getLocalFieldNum(i),
            field = this.fields[i],
            body = field.frozen ? this.frozenBody : this.body;
        
        
        widths[i] = body.getInnerColumnWidth(colNum);
    }
    return widths;
},

//>	@method     listGrid.getEditorValueMap()  ([A])
//
//  Returns the valueMap to display for a field when it is displayed in the editor while
//  editing some record.<br>
//  Called when a user starts to edit a field, or whenever the field valueMap is updated via
//  a call to +link{listGrid.setValueMap()} or +link{listGrid.setEditorValueMap()}.
//  Default implementation will return the <code>field.editorValueMap</code> if specified, otherwise
//  <code>field.valueMap</code> - can be overriden to provide a
//  different specific valueMap for some field based on the record/field data.
//
//  @group  editing
//
//  @param  field   (ListGridField)    field definition field for which we need a valueMap
//  @param  values  (object)    Field values for record being edited. Note that this will include
//                              the current edit values for fields that have not yet been saved.
//                              May be null, if editing a new record.
//  @return         (ValueMap)  ValueMap for the edit field (or null if no valueMap required)
//  @visibility external 
//<
getEditorValueMap : function (field, values) {
    return field.editorValueMap || field.valueMap;
},


//> @method listGrid.getEditorValueIcons()
// Returns the valueIcons for a field when it is displayed in the editor while editing some
// record. Default implementation will return +link{ListGridField.editorValueIcons} if specified
// otherwise +link{ListGridField.valueIcons}
// @param field (object) field definition
// @param vaules (object) current edit values for the record
// @return (object) valueIcons for the editor
// @visibility external
// @group imageColumns
//<
getEditorValueIcons : function (field, vaues) {
    return  field.editorValueIcons || field.valueIcons;
},

//> @method listGrid.getEditorValueIconWidth()
// Returns the width for any valueIcon for a field when it is displayed in the editor 
// while editing some record.<br>
// Returns +link{listGridField.editorValueIconWidth} if specified - otherwise 
// +link{listGridField.valueIconWidth} or +link{listGridField.valueIconSize}
// @param field (object) field definition
// @return (number) width for the value icon to show in the editor
// @visibility internal
// @group imageColumns
//<
// Don't return listGrid.valueiconWidth / size - this is just a default and likely to break
// form items with standard valueIconSizes, such as checkboxes.
getEditorValueIconWidth : function (field) {
    if (field.editorValueIconWidth != null) return field.editorValueIconWidth;
    return (field.valueIconWidth != null ? field.valueIconWidth : field.valueIconSize);
},

//> @method listGrid.getEditorValueIconHeight()
// Returns the height for any valueIcon for a field when it is displayed in the editor 
// while editing some record.<br>
// Returns +link{listGridField.editorValueIconHeight} if specified - otherwise 
// +link{ListGridField.valueIconHeight} or +link{listGridField.valueIconSize}
// @param field (object) field definition
// @return (number) height for the value icon to show in the editor
// @visibility internal
// @group imageColumns
//<
getEditorValueIconHeight : function (field) {
    if (field.editorValueIconHeight != null) return field.editorValueIconHeight;
    return field.valueIconHeight != null ? field.valueIconHeight : field.valueIconSize;
},

//>@method      listGrid.setEditorValueMap()    ([A])
//
// Set a valueMap to display for this field while editing.<br>
// This method sets the +link{ListGridField.editorValueMap, field.editorValueMap} property - 
// note that if  +link{ListGrid.getEditorValueMap()} has been overridden it may not make use 
// of this property.
// @group editing
// @param fieldID   (object | number | field name)  Field object or identifier
// @param   map     (object)    ValueMap to apply to the field
// @visibility external
//<
setEditorValueMap : function (fieldID, map) {
    var fieldNum = this.getColNum(fieldID),
        field = this.getField(fieldID),
        fieldName = field[this.fieldIdProperty];
    field.editorValueMap = map;
    if (this._editorShowing) {
        var rowNum = this.getEditRow(),
            editRecord = this.getEditedRecord(rowNum, fieldNum);
        // Apply the valueMap to the edit form field - note that we retrieve it via the 
        // getter method in case it has been overridden.
        this._editRowForm.setValueMap(fieldName, this.getEditorValueMap(field, editRecord));
    }
    
},

//>	@method     listGrid.getEditorType()  ([A])
//
//  Returns the form item type (Class Name) to display for a field when it is displayed in the 
//  editor while editing some record.<br>
//  Default implementation will return field.editorType if specified.
//  If not specified, the default form item for the appropriate data type will be displayed
//  - can be overriden to provide a different specific form item type for some field based on 
//  the record/field data.
//
//  @group  editing
//
//  @param  field   (ListGridField)    field definition field for which we need a valueMap
//  @param  values  (object)    current edit values for the record (may be null, if editing a 
//                              new record)
//  @return         (string)  form item type for the edit field
//  @visibility external 
//<
getEditorType : function (field, values) {
    
    // determining type: editorProperties, being most specific, wins.  Otherwise
    // field.editorType, otherwise, you get the default editor picked
    // for field.type (which is the field's *data* type, not editor type).
    // NOTE: editorProps.type will always refer to the form item type, not the data type.
    // NOTE: "formItemType" is a legacy synonym of "editorType"
    var editorProperties = isc.addProperties({},field,field.editorProperties);
    
    // Use the static method on DynamicForm to get the editorType for this field.
    // Pass this ListGrid in as a parameter so the method can examine 
    // this.longTextEditorThreshold and this.longTextEditorType.
    return isc.DynamicForm.getEditorType(editorProperties, this);
},

// getEditorProperties() - return a block of default properties for editor form items displayed
// while editing some field
// Overridden in RecordEditor.
getEditorProperties : function (editField) {
    return isc.addProperties({}, this.editorProperties, editField.editorProperties);
},

//>	@method     listGrid.getEditRowItems()  (IA)
//
//      Given a record to edit, return an appropriate array of dynamicForm item init blocks
//
//  @group  editing
//
//  @param  record  (object)    Record to be edited
//  @param  rowNum  (number)    index of the row being edited
//  @param  fieldNum (number)   index of the field on which the 'startEditing' occurred (typically
//                              used as a focus field)
//  @return         (array)     Array of DynamicForm item object instantiation blocks
// @visibility internal
//<
// Note: if editByCell is false, and we're incrementally rendering, we only create form items 
// for the visible set of fields.

getEditRowItems : function (record, rowNum, fieldNum, singleCell) {

    var body = this.body;
	// if we haven't created the body yet, don't create any form items - they'll get set up
	// at draw, and updated at redraw.
    if (body == null) return [];

	// The set of fields for the form is basically this.fields, with some custom properties, such
	// as 'editorType'
    var firstEditable, lastEditable,
    	widths = [],
        items = [];
        
    var editedRecord = this.getEditedRecord(rowNum, fieldNum);

	// create an array of the fields we want to work with        
    var editFields;
    if (singleCell) editFields = [this.getField(fieldNum)]
    else editFields = this.getDrawnFields();
    
    widths = this.getDrawnFieldWidths(record, editFields);
    
    for (var i = 0; i < editFields.length; i++) {
        
    	// (Set up each item as a property-value map)
        
        
        var colNum = this.getColNum(editFields[i]);
        var item = this.getEditItem(editFields[i], record, editedRecord, rowNum, colNum, widths[i])
        if (item == null) continue;
        
        items[items.length] = item;
    }
    
    return items;

},

getDrawnFields : function () {
    
    if (!this.body) return null;
    
    var drawnFields = [], body = this.body;
    var ff = this.frozenFields, fLeft = this.freezeLeft();

    if (ff && fLeft) {
        // this assumes that we are not dealing with incremental column rendering of frozen
        // fields (should be true as not scrollable)
        drawnFields.addList(ff);
    }
    
    var firstVisible, lastVisible;
    
    if ((body._firstDrawnCol == null) || body.isDirty() || body._redrawing) {    
        var drawnRange = body.getDrawArea();
        firstVisible = drawnRange[2];
        lastVisible = drawnRange[3];        
    } else {
        firstVisible = body._firstDrawnCol;
        lastVisible = body._lastDrawnCol;        
    }
    if (ff && fLeft) {
        firstVisible += ff.length;
        lastVisible += ff.length;
    }    
    for (var i = firstVisible; i <= lastVisible; i++) {
        drawnFields.add(this.fields[i]);        
    }
        
    if (ff && !fLeft) {
        drawnFields.addList(ff);
    }
    return drawnFields
},

getDrawnFieldWidths : function (record, fields) {
    // Allow the developer to pass in the fields to return widths for
    if (!fields) fields = this.getDrawnFields();
    
    if (!fields) return null;
    
    // apply the width from the fieldWidths array 
    var completeWidths = this.getEditFormItemFieldWidths(record),
        widths = [];
    for (var i = 0; i < fields.length; i++) {
        widths[i] = completeWidths[fields[i].masterIndex];
    }    
    return widths;
},

// getEditItem()
// returns an individual property block for edit-form form item.

// Helper methods to be applied to pop up text area items to specially process keydown and
// keypress events.  Fired in the scope of the pop up text area

_popUpTextAreaItemKeyPress : function (item, keyName, characterValue) {
    return this.grid.editorKeyPress(this, keyName, characterValue);
},
_popUpTextAreaItemKeyDown : function (item, keyName, characterValue) {
    return this.grid.editorKeyDown(this, keyName, characterValue);
},

// On focus in a pop up text area item, ensure that we have updated the current edit cell info.
// This handles the case where we got no elementFocus on the PUTA directly - happens if the
// PUTA has no focusable element itself.

_popUpTextAreaItemFocus : function () {
    var form = this.form, lg = this.grid,
        rowNum, colNum, fieldName, fieldChanged;
    if (lg._editorShowing) {
        rowNum = lg._editRowNum;
        // don't worry about editByCell case- for the pop up textareaitem to have got focus we
        // must have already shown it, meaning we must already know which field is being edited
        if (!lg.editByCell) {
            rowNum = lg._editRowNum;
            fieldName = this.getFieldName(),
            colNum = lg.fields.findIndex(lg.fieldIdProperty, fieldName);
                
            fieldChanged = (lg._editColNum != colNum);
            // If the user has clicked in another field in the edit form, fire editField on
            // the appropriate field
            if (fieldChanged) {
                // store the new edit cell
                lg.setNewEditCell(rowNum, colNum);
                // fire 'cellEditEnd' to save / validate before moving to the new cell
                lg.cellEditEnd(isc.ListGrid.EDIT_FIELD_CHANGE);
                    
            }
        }
    }
},

_getPopUpTextAreaTop : function () {
    var grid = this.grid,
        fieldName = this.getFieldName(),
        rowNum = grid.getEditRow(),
        style = grid.getCellStyle(grid.getRecord(rowNum), rowNum, grid.getColNum(fieldName)),
        rowTop = grid.getRowPageTop(rowNum) + 
                 isc.Element._getTopBorderSize(style) + isc.Element._getTopPadding(style);
    return rowTop;
},

_checkboxClick : function (a,b,c,d) {
    if (!this.hasFocus) {
        var lg = this.grid;
        lg.setNewEditCell(this.rowNum, this.colNum);
        lg.cellEditEnd(isc.ListGrid.EDIT_FIELD_CHANGE);
        // and force cellEnterOnFocus, so when the (delayed) focus 
        // handler fires, we get a cellEnter
        this._cellEnterOnFocus = true;
    }
    
    return this.invokeSuper("CheckboxItem", "handleClick", a,b,c,d);
},



// handleEditorChanged()
// Fired when the changed() handler fires for any of our edit items.
// Allows us to perform validation on change
handleEditorChanged : function (item) {
    var fieldName = item.getFieldName(),
        field = this.getField(fieldName),
        validateOnChange;
    
    if (field && field.validateOnChange != null) validateOnChange = field.validateOnChange;
    else validateOnChange = this.validateOnChange;
    
    if (validateOnChange) {
        var rowNum = this.getEditRow();
        // Note: we don't always update the editValue for the cell when the change handler
        // fires on the edit item - instead we usually update when the user moves to a new cell.
        // However, validateCell(), like most other APIs that interact with the editValues,
        // will update the edit value for the cell if it's stale before performing validateion.
        this.validateCell(rowNum, fieldName);
    }
},

// Override for the (internal) handleChanged method so we can be notified when the
// user changes an edit cell's form item value.
_editorHandleChangedOverride : function (a,b,c,d) {
    
    this.invokeSuper(this.getClassName(), "handleChanged", a,b,c,d);
    
    if (!this.destroyed) this.grid.handleEditorChanged(this);
    
},

_editorGetAutoComplete : function () {
    var grid = this.grid;
    // This would imply something like a destroyed form item - so just ignore it.
    if (!grid) return null;

    var field = grid.getField(this.getFieldName());
    if (field.autoComplete != null) return field.autoComplete;
    if (grid.autoComplete != null) return grid.autoComplete;
    return this.Super("_getAutoCompleteSetting", arguments);
},


_timeEditorTypes:{time:true, TimeItem:true},
_$time:"time",
_dateEditorTypes:{date:true, dateTime:true, DateItem:true},
_$date:"date",
_popUpTextAreaEditorTypes:{popUpTextArea:true, PopUpTextAreaItem:true},
_checkboxEditorTypes:{checkbox:true, CheckboxItem:true},
_$boolean:"boolean",
_$checkbox:"checkbox",
_$CycleItem:"CycleItem",
_selectEditorTypes:{select:true, SelectItem:true}, 


_commonEditorStringMethodsFromField:["change", "changed", "defaultDynamicValue"],
_commonEditorStringMethods:["change", "changed", "defaultDynamicValue",
                            "keyPress", "click", 
                            // Not sure if showIf / enableIf would be set on editors - more
                            // likely to set canEdit:false for the cell
                            "showIf", "enableIf"],

getEditItem : function (editField, record, editedRecord, rowNum, colNum, width) {


    var item = {};
    
    // the error icons will be written directly into the form item (so no need to
    // adjust the size of the edit item to account for them).
        
	// Set the "name" of the item
    var fieldName = this.getEditorName(rowNum, editField);
    item[this.fieldIdProperty] = fieldName;
    
    // Pick up autoCompletion settings from the grid in preference to any default settings
    // on the form item
    item._getAutoCompleteSetting = this._editorGetAutoComplete;
    item.autoCompleteCandidates = editField.autoCompleteCandidates;
    item.uniqueMatch = editField.uniqueMatch;

    // containerWidget should point to the ListGrid body (or frozen body if appropriate)
    // this ensures that 'formItem.isVisible()' tests the visibility of this widget, rather than
    // the DynamicForm managing the form's values.
    item.containerWidget = editField.frozen ? this.frozenBody : this.body;
    item.width = width;

    // Set textAlign to match field alignment (required so text within text items etc reflects
    // horizontal alignment even though the item will be sized to take up all the space in the
    // cell).
    item.textAlign = (editField.cellAlign || editField.align);
       
	// Hang some properties onto the form item so keypress handers (etc.) written onto
	// the form item can readily access details about the edit:
    item.record = record;
    item.rowNum = rowNum;

    item.colNum = colNum;
    
    item.grid = this;
    
    // validateOnChange: validation of edits is performed by the grid, not the editForm.
    // Override the internal 'handleChanged()' method to notify us if the edit item value
    // is changed by the user. The grid then checks for validateOnChange, and if appropriate
    // performs validation of the cell.
    item.handleChanged = this._editorHandleChangedOverride;
    
	// Use the accessor function to get the valueMap for the item
	// This allows override of visible options on a per cell basis
	// Note that we pass in the edit values, rather than the record's saved values - we want
	// the valueMap to update as edits are performed
    
    item.valueMap = this.getEditorValueMap(editField, editedRecord);
    
    // If the field has a specified optionDataSource, pass that through to the editor too,
    // along with the valueField / displayField properties
    
    
    if (editField.valueField != null) item.valueField = editField.valueField
    if (editField.displayField != null) item.displayField = editField.displayField
    if (editField.optionDataSource) item.optionDataSource = editField.optionDataSource
        
    // apply valueIcons and related properties to the editor
    // Note that we allow different value icons in the editor from the icons displayed in the
    // static cell
    item.valueIcons = this.getEditorValueIcons(editField, editedRecord);
    
    var valueIconWidth = this.getEditorValueIconWidth(editField),
        valueIconHeight = this.getEditorValueIconHeight(editField);
    if (valueIconWidth) item.valueIconWidth = valueIconWidth;
    if (valueIconHeight) item.valueIconHeight = valueIconHeight;
    
    item.imageURLPrefix = (editField.editorImageURLPrefix || editField.imageURLPrefix);
    item.imageURLSuffix = (editField.editorimageURLSuffix || editField.imageURLSuffix);
    // back compat only:
    item.baseURL = editField.baseURL;
    item.imgDir = editField.imgDir;  
    // Pick up icon-related properties from the edit field (if any set)
    // (most of these will be undef, so pick up standard defaults from item type)
    var undef;
    if (editField.icons !== undef) item.icons = editField.icons;
    if (editField.showPickerIcon !== undef) item.showPickerIcon = editField.showPickerIcon;
    if (editField.pickerIconSrc !== undef) item.pickerIconSrc = editField.pickerIconSrc;
    if (editField.pickerIconWidth !== undef) item.pickerIconWidth = editField.pickerIconWidth;
    if (editField.pickerIconHeight !== undef) item.pickerIconHeight = editField.pickerIconHeight;
    
    // Generic icon properties are unlikely to be set on a per-field basis, but handle them anyway
    if (editField.defaultIconSrc !== undef) item.defaultIconSrc = editField.defaultIconSrc;
    var iconHeight = (editField.editorIconHeight || editField.iconHeight);
    if (iconHeight !== undef) item.iconHeight = iconHeight
    var iconWidth = (editField.editorIconWidth || editField.iconWidth);
    if (iconWidth !== undef) item.iconWidth = iconWidth; 
    if (editField.iconPrompt !== undef) item.iconPrompt = editField.iconPrompt;
    if (editField.iconHSpace !== undef) item.iconHSpace = editField.iconHSpace;
    if (editField.iconVAlign !== undef) item.iconVAlign = editField.iconVAlign;
    
    // ValueIcons properties:
    // Setting showValueIconOnly before getting editor type ensures we get back a cycle item
    // if appropriate rather than a select.
    if (this.showValueIconOnly(editField)) {
        if (editField.editorProperties == null) editField.editorProperties = {};
        editField.editorProperties.showValueIconOnly = true;
    }
    
    // If pickListWidth / fields is defined on the field object, pass it through to the item:
    if (editField.pickListWidth != null) item.pickListWidth = editField.pickListWidth;
    if (editField.pickListFields != null) item.pickListFields = editField.pickListFields;
    
    // Apply a keyDown handler to all items.
    // Allows us to kill native tab navigation in Safari
    item.keyDown = function (item, form, keyName) {
        return this.form.grid.editorKeyDown(item, keyName);
    }

    
    if (editField.editorProperties != null) {
        for (var i = 0; i < this._commonEditorStringMethods.length; i++) {

            var prop = this._commonEditorStringMethods[i],
                value = editField.editorProperties[prop];
            // convert both "action" objects and strings
            if (value != null && !isc.isA.Function(value)) {
                var stringMethodReg = isc.FormItem._stringMethodRegistry;
                editField.editorProperties[prop] = 
                    value = isc.Func.expressionToFunction(stringMethodReg[prop], value);        
            }
            if (value != null) editField.editorProperties[prop] = value;
        }  
    }

    // This block applies field.change, field.changed, and field.defaultDynamicValue
    for (var i = 0; i < this._commonEditorStringMethodsFromField.length; i++) {

        var prop = this._commonEditorStringMethodsFromField[i];
        if (editField.editorProperties && editField.editorProperties[prop] != null) {
            continue;
        }
        var value= editField[prop];
        if (value != null) {
            if (editField.editorProperties == null) editField.editorProperties = {};
            if (!isc.isA.Function(value)) {
                var stringMethodReg = isc.FormItem._stringMethodRegistry;
                
                value = isc.Func.expressionToFunction(stringMethodReg[prop], value);        
            }
            editField.editorProperties[prop] = value;
        }
        
    }

    item.valueIconLeftPadding = this.getValueIconLeftPadding(editField);
    item.valueIconRightPadding = this.getValueIconRightPadding(editField);
        
	// pick a form item type appropriate for embedded editing

	// explicit specification
    item.editorType = this.getEditorType(editField, record);
    var eT = item.editorType; 
    
	// for date items, use the text field rather than the 3 selects
    if (this._dateEditorTypes[eT] || (editField.type == this._$date && eT == null)) {
        item.editorType = this._$date;
        item.useTextField = true;
    	// This improves the appearance for this item type
        item.cellPadding = 0;
        // Don't apply a style to the sub items' cells - we don't want padding, etc.
        item.itemCellStyle = null;
        // have the picker icon butt up against the text box.
        item.pickerIconHSpace = 0;
        
        // pick up display format and input format from field / grid
        var displayFormat = this._getDateFormatter(editField);
        if (displayFormat) item.displayFormat = displayFormat;
        var inputFormat = this._getDateInputFormat(editField);
        if (inputFormat) item.inputFormat = inputFormat;
    }

    if (this._timeEditorTypes[eT] || (editField.type == this._$time && eT == null)) {
        var displayFormat = this._getTimeFormatter(editField);
        if (displayFormat) item.displayFormat = displayFormat
    }

    //>PopUpTextAreaItem    
    // For pop-up textArea type editors, apply the keyPress handling code to the textArea<b></b>
    if (this._popUpTextAreaEditorTypes[eT]) {
        // PopUpTextAreaItems are a subclass of staticTextItems. Override the default textBoxStyle
        // to match the hack - suppress "over" styling when getting the cell style since we
        // always suppress it on the edit row once the editor is showing
        item.getTextBoxStyle = function () {
            var grid = this.grid,
                record = grid.getCellRecord(this.rowNum,this.colNum);
            this.textBoxStyle = grid.getCellStyle(record, this.rowNum,this.colNum);
            return this.Super("getTextBoxStyle", arguments);
        }

        // notification when the grid's cell style changed so we can update our textBoxStyle        
        item.gridCellStyleChanged = function (record, rowNum, colNum, newStyle) {
            var textBox = this._getTextBoxElement();
            if (textBox) {
                textBox.className = this.textBoxStyle = newStyle;
            }
        }
        
        // supppress doubled borders etc
        item.textBoxCellCSS = isc.Canvas._$noStyleDoublingCSS

        // Apply the custom keydown & keypress handlers to the pop up text area's textArea
        item.textAreaKeyDown = this._popUpTextAreaItemKeyDown;
        item.textAreaKeyPress = this._popUpTextAreaItemKeyPress;
        // Override getTextAreaTop() - rather than sticking to the top of the form item (which
        // may not line up with other items), stick to the top of the cell.
        item.getTextAreaTop = this._getPopUpTextAreaTop;        
        // default popUpOnEnter to true.
        if (item.popUpOnEnter == null) item.popUpOnEnter = true;
        
        // react to text area focus as we would to item focus for other items
        // so we know what cell the user is editing
        item.textAreaFocus = this._popUpTextAreaItemFocus;
    }
    //<PopUpTextAreaItem
    
    // Don't show label for checkboxes by default.
    if (this._checkboxEditorTypes[eT] || (editField.type == this._$boolean && eT == null)) {
        if (item.showLabel == null) item.showLabel = false;
        // Also verify that the item has focus on click.
        // Required for IE where focus is asynchronous and would occur after the click changed
        // the value
        
        if (item.handleClick == null) {
            item.handleClick = this._checkboxClick;
        } 
    }   

    item.elementFocus = this._editFormItem_elementFocus;
        
	// By default set 'canTabToIcons' to false for edit fields
	// can be overridden on a per-field basis
    item.canTabToIcons = false;

    // override 'focusInItem' to manage selection
    // - we need more complicated behavior than the standard 'selectOnFocus'.
    //   If we started editing via editOnKeypress we will have updated the value of the item
    //   so should set the cursor at the end of the item value. Otherwise, just select on focus.
    item.focusInItem = this._editFormItem_focusInItem;
    
	// Allow for developer specified defaults / properties for this field
	
    var propertyDefaults = this.getEditorProperties(editField, record);

    isc.addProperties(item, propertyDefaults);
	// if this grid is databound, any other properties specified in the DS will be picked
	// up by the form during databinding
    return item;
},


// focusInItem override for edit form items.
_editFormItem_focusInItem : function () {
    this.Super("focusInItem", arguments);
    this.grid._updateEditorSelection(this);
},
    
// helper to return the editItem name for some cell
getEditorName : function (rowNum, editField) {
    // accept a colNum or a field object
    if (isc.isA.Number(editField)) editField = this.getField(editField);
    return editField ? editField[this.fieldIdProperty] : null;
},


_editItemStringMethodCache:{},

//>	@method	listGrid.refreshCell()    
//  @include    gridRenderer.refreshCell()
//  @example calculatedCellValue
//<
// override refreshCell just to pass the additional params through to refreshCellValue()
refreshCell : function (rowNum, colNum, refreshingRow, allowEditCellRefresh) {
    if (rowNum == null) {
        isc.logWarn('ListGrid.refreshCell(): first parameter rowNum not present, returning');
        return;
    }
    if (!this.isDrawn() || !this.body) return;
    
    var body = this.getFieldBody(colNum);    

	// If the body is already marked for redraw, allow that to handle updating the cell
    if (body.isDirty()) {
        this.logDebug("refresh cell redrawing body", "gridEdit");
        body.redraw("refresh cell");
    	// return false to indicate that we did not update the cell in place, but forced a 
    	// redraw (used to make 'refreshRow' more efficient.
        return false;
    }
    
    var bodyColNum = this.getLocalFieldNum(colNum);
    body.refreshCellStyle(rowNum, bodyColNum);    
    // refresh the value too unless it's already been refreshed as part of styling
    if (!body.shouldRefreshCellHTML()) {
        this.refreshCellValue(rowNum, colNum, refreshingRow, allowEditCellRefresh);
    }
},

// refreshCellValue overridden to handle refreshing cells within the edit row
// If we are showing an edit form item for this cell:
// - if the form item is present in the DOM, and has focus:
//   - we must save out it's element value (may be dirty)
//   - blur the item without firing the handler
// - rewrite the HTML for the cell (including the form item)
// - inform the form item that it has been written out / redrawn in the DOM
// - reset the element value
// - if the item had focus, re-set focus (and selection).

refreshCellValue : function (rowNum, colNum, refreshingRow, allowEditCellRefresh) {

    if (!this.isDrawn() || !this.body) return;

    var body = this.getFieldBody(colNum),
        bodyColNum = this.getLocalFieldNum(colNum);

    // If we need to delay the refresh, fire again after a delay
    if (!body._readyToRefreshCell(rowNum, bodyColNum)) {
        this.delayCall("refreshCellValue", [rowNum, colNum, refreshingRow, allowEditCellRefresh]);
        return;
    }
	// Handle the case of showing an edit form field for this cell.
	 
    var editFieldName = this.getEditorName(rowNum, colNum),
        fieldName = this.getFieldName(colNum),
        form = this._editRowForm,
        editItem, cellHasFocus = false,
        cellShowingEditor, cellWillShowEditor;
    if (form) {    
        var editItem = form.getItem(editFieldName),
            rowHasEditor = (this._editorShowing && rowNum == this.getEditRow());
        
        // sanity check if the colNum on the edit item doesn't match the colNum of the
        // cell we're refreshing, it doesn't relate to this cell.
        // This occurs in CubeGrids where we have one record per cell
        if (editItem && editItem.colNum != colNum) editItem = null;

        if (rowHasEditor) {
            // whether there is currently an editor in the cell
            cellShowingEditor = (editItem && editItem.isDrawn());
            // whether there will be an editor in the cell after refresh
            cellWillShowEditor = this.canEditCell(rowNum, colNum);
            if (editItem != null && form.hasFocus) {
                var formFocusItem = form.getFocusItem();
                cellHasFocus = (formFocusItem == editItem || 
                               (editItem.items && editItem.items.contains(formFocusItem)));
            }
        // catch the case where we're clearing out a drawn item
        
        } else if (editItem && editItem.rowNum == rowNum) {
            cellWillShowEditor = false;
            cellShowingEditor = editItem.isDrawn();
        }
    }
    
	
    if (!allowEditCellRefresh && (cellHasFocus && cellShowingEditor && cellWillShowEditor))
    {  
        return;
    }
	// If there is a visible editor in this cell, update it's value and blur before redrawing
    if (cellShowingEditor) {            
    	
        this.getUpdatedEditorValue();
        if (editItem != null) {            
            if (cellHasFocus) {
                // Note - if the item will be visible after this method, silently blur and
                // refocus. Otherwise allow the blur handler to fire, since we won't be 
                // restoring focus.
                if (cellWillShowEditor) {         
                     form._blurFocusItemWithoutHandler();
                }
                else editItem.blurItem();
            }
            // If this method will redraw a form item, notify it now
            if (cellWillShowEditor) editItem.redrawing();
        }
    }

	// Call the body's method to update the HTML of the cell:    
    body.refreshCellValue(rowNum, bodyColNum);
    if (editItem && (cellShowingEditor || cellWillShowEditor)) {
        // Call our method to fire the appropriate 'drawn()' / 'redrawn()' / 'cleared()' 
        // notification on the edit item.
        this._editItemsDrawingNotification(editItem, null, body);
        if (cellWillShowEditor) {
            // restore the element value (since it's not written out with the element)
            
            editItem.setValue(this.getEditDisplayValue(rowNum, colNum));
        	// restore focus if it had focus
        	
            if (cellHasFocus) {
                form._focusInItemWithoutHandler(editItem);
            }
        }
    }
},


//>	@method	listGrid.refreshRow()
// @include gridRenderer.refreshRow()
//<
refreshRow : function (rowNum) {
    if (!this.body || !this.isDrawn()) return;

	// If the body is already dirty, allow the redraw to handle updating the row.
    var frozenFields = this.frozenFields && this.frozenFields.length > 0;
    // If deriveVisibleFields is called, and then this method fires before the grid has redrawn
    // we won't  have created the frozen body. Treat this case like frozenFields is false;
    if (frozenFields && !this.frozenBody) frozenFields = false;
   
    
    //var dirty = this.body.isDirty() || 
    //            frozenFields ? (this.frozenBody.isDirty() || this.bodyLayout.isDirty()) : false;
    var dirty = false;
    if (this.body.isDirty()) dirty = true;
    if (frozenFields && !dirty) {
        if (this.frozenBody.isDirty() || this.bodyLayout.isDirty()) dirty = true     
    }
    
    if (dirty) {
        var bodyWidget = frozenFields ? this.bodyLayout : this.body;
        return bodyWidget.redraw("refresh row");
    }
    
    if (this._editorShowing && this._editRowForm != null) {
        this.logInfo("refresh row: " + rowNum, "gridEdit");
    }
    
    // just call 'refreshCell' on all drawn cells
    if (frozenFields) {
        for (var i = 0; i < this.frozenFields.length; i++) {            
            this.refreshCell(rowNum, this.getFieldNum(this.frozenFields[i]), true);
        }
    }
    var firstVisible = this.body._firstDrawnCol,
        lastVisible = this.body._lastDrawnCol;
    for (var i = firstVisible; i <= lastVisible; i++) {
        
        var colNum = this.getFieldNumFromLocal(i, this.body);
        this.refreshCell(rowNum, colNum, true);
    }
},

//>	@method listGrid.startEditingNew() (A)
//
// Start editing a new row, after the last pre-existing record in the current set of data.
// <P>
// This new row will be saved via the "add" +link{group:dataSourceOperations,DataSource
// operation}.
// <P>
// If editing is already underway elsewhere in the grid, startEditingNew() behaves just like
// +link{startEditing()}.
//
// @group  editing
//
// @param  [newValues] (object)  Optional initial set of properties for the new record
// @param  [suppressFocus] (boolean) Whether to suppress the default behavior of moving focus
//                                   to the newly shown editor.
// @see    startEditing()
// @visibility external
//<
startEditingNew : function (newValues, suppressFocus) {

    // force editing on if it's not configured for any field, but a programmatic call is made
    if (!this.canEdit && !(this.completeFields || this.fields).getProperty("canEdit").or()) {
        this.canEdit = true;
    }

    
    if (isc.isAn.Array(this.data) && this.data.length == 0 && 
        this.dataSource && !this.saveLocally) 
    {
        this.fetchData(null, null, {_suppressFetch:true});
        this.data.setFullLength(0);
    }    

	// The new row will be added to the end of the current set of rows
	
    
    var newRowNum = this.body ? this.body.getTotalRows() : this.getTotalRows();
    
    // If we're showing the 'edit new record' row, ensure we insert the record over that row,
    // rather than inserting after that row.
    if (this.showNewRecordRow) newRowNum -= 1;
    

    var newEditCell = this.findNextEditCell(newRowNum, 0, 1, true, true, true);
    
    // newEditCell can be null if canEditCell returned false for all fields!
    if (newEditCell == null) {
        this.logInfo("startEditingNew() failed to find any editable fields in this grid.", 
                     "gridEdit");
        return;
    }
    
	// Suppress displaying the new edit values - handled by 'startEditing', which will show
	// the edit form for the row.
    if (newValues != null) this.setEditValues(newEditCell, isc.addProperties({}, newValues), 
                                              true);

    // fall through to 'startEditing()' -- handles any current edit in another cell.
    this.startEditing(newEditCell[0], newEditCell[1], suppressFocus);
},

//>	@method     listGrid.updateEditRow()  (IA)
//
// Internal method to update the set of form fields written into the ListGrid body's
// currently editable row (after a call to editRow()).
// - Updates the values of the form items
// - Focuses in the appropriate item
//
//  @group  editing
//
//  @param  rowNum      (number)    Row number to update.
//
//  @visibility internal
//<
updateEditRow : function (rowNum) {
	// if updateEditRow is called on a delay, by the time this update occurs, we may have moved
	// on to another row.
    if (this._editRowNum != rowNum || !this._editRowForm) {
    	//this.logWarn("updateEditRow bailing, update was for row: " + rowNum + 
    	//             " current editRow is " + this._editRowNum);
        return;
    }

	// update the item values of the edit form.
	
    this._editRowForm.setItemValues();
	// Clear out the _setValuesPending flag
    delete this._editRowForm._setValuesPending;
    this._editRowForm._waitingOnUpdate = false;
},

// shouldFixRowHeight()
// Internal method allowing 'fixedRecordHeights' to be overridden for individual rows in the
// GridRenderer.
// Currently only used for row-level editing.
// When row-level editing is enabled, we want to allow the row showing the embedded editor to
// expand to accomodate it's contents regardless of this.fixedRecordHeights
//

shouldFixRowHeight : function (record, rowNum) {

	// if this row is being edited, don't vertically clip
	// (Note check for != false rather than == true, as if lg.canEdit is unset, we support
	// editing on fields where canEdit is explicitly set to true)
    if (this.canEdit != false && this._editorShowing && rowNum == this._editRowNum) {
       return false;
    }
    return this.fixedRecordHeights;
},

//--- helpers for edit flow methods

// Provide unique identifiers to be used to identify the edit flow.

_getNextEditFlowID : function () {
    if (this.__lastEditFlowID == null) this.__lastEditFlowID = isc.timeStamp();
    return this.__lastEditFlowID ++;
},

// internal helper method for click outside editor - avoids us having to determine the appropriate
// cell's value in a click-mask event handler type stringMethod.
_handleClickOutsideEditor : function () {
    var editRow = this.getEditRow();
    this.cellEditEnd(isc.ListGrid.CLICK_OUTSIDE);
},

// Retrieving / updating editValues.
// We store copies of edited values locally for multiple records in the _editSessions
// object.  This allows us to hang onto edit values for more than one edited record at a time
// - required for records that have been edited but not yet saved, either because a save is
// in process, but hasn't returned from the server, and 'waitForSave' is false, or because a 
// save failed with validation errors, and stopOnErrors is false.



// value to display in a cell for which there may be edit values present.

// Note: optional 'record' parameter passed by 'getEditDisplayValues' only.
getEditDisplayValue : function (rowNum, colNum, record) {    
    var undef;
	// If 'record' is not passed, determine it from rowNum, colNum now.
    if (record === undef) record = this.getCellRecord(rowNum, colNum);

	// use the edit value for the cell if present
    var value = this._getEditValue(rowNum, colNum);

    if (value === undef && record != null) {
    	
        value = this.getRawCellValue(record, rowNum, colNum);
    }
	// If a formatter is defined for the editor values, apply it now
    value = this._formatEditorValue(value, record, rowNum, colNum);
    
    return value;
},

// Internal method to fire developer defined 'formatEditorValue' methods at either the Grid or
// Field level.
_formatEditorValue : function (value, record, rowNum, colNum) {
    // If this is a new row, the record passed in will be null - 
    // In this case pass the edit values to the formatter instead
    
    if (record == null) record = this._getEditValues(rowNum, colNum);
    
	// If a field-level formatter is defined, apply it.
    var field = this.fields[colNum];
    if (field && field._editFormatter != null) {
        value = field._simpleType.editFormatter(value, field, this, record);
    } else if (field && field.formatEditorValue != null) {
    	
        isc.Func.replaceWithMethod(field, "formatEditorValue", 
                                            "value,record,rowNum,colNum,grid");
        value = field.formatEditorValue(value, record, rowNum, colNum, this);
	// Only apply a Grid-level formatter if no formatter exists at the field level.
    } else if (this.formatEditorValue != null) {
        value = this.formatEditorValue(value, record, rowNum, colNum);
    }
    return value;
},

//>	@method     listGrid.getEditValuesID() 
//
//  Given either a rowNum, a set of primary key values,
//  returns a unique identifier for the set of temporary locally stored edit values for some
//  record being edited.
//  If passed the editValuesID, it will just be returned.
//
//  @group  editing
//  @visibility advancedInlineEdit
//  @param  ID (number | object | string)    Identifier for editValues for which we need to
//                                           return the unique editValuesID.
//  @return (string)   Unique identifier for the set of editValues.
//<

getEditValuesID : function (ID) {

    if (ID == null || this._editSessions == null) return null;

    if (isc.isA.String(ID) && this._editSessions[ID] != null) return ID;
    
	// rowNum (common case)
    if (isc.isA.Number(ID)) return this._editRowMap[ID];
    
    // handle primary keys object OR the edit data object itself
    for (var i in this._editSessions) {
        var data = this._editSessions[i];
        if (data == ID) return i;
        if (this.comparePrimaryKeys(this._editSessions[i]._primaryKeys, ID)) {
            return i;
        }
    }
    
    return null;
},

// getEditSession - returns the edit data object for some row.
// This contains the editValues, the rowNum (if known), any validation errors, and primary
// keys for the edited record.
getEditSession : function (editDataID, colNum) {
	// editDataID can be a rowNum, a primary key or an editValuesID string.
    if (this._editSessions == null) return null;
    
    if (!isc.isA.String(editDataID)) editDataID = this.getEditValuesID(editDataID, colNum);
    return this._editSessions[editDataID];
},

// getEditSessionRowNum   - given an edit data object, or an ID for an edit data object, returns
// the rowNum of the record associated with the data.
// May be null if we're editing a new row on the end of the list, or with a paged result-set
// if we don't yet know the rowNum for the record.
getEditSessionRowNum : function (editDataID) {
    editDataID = this.getEditSession(editDataID);
    return (editDataID != null ? editDataID._rowNum : null)
},

getEditSessionColNum : function (editDataID) {
    editDataID = this.getEditSession(editDataID);    
    // Note that the _colNum will be unset if we have 1 record per row
    return (editDataID != null ? editDataID._colNum : null)
},

//>	@method     listGrid.getAllEditRows() 
// Returns an array of every rowNum for which we have pending (unsubmitted) edits.
//  @group  editing
//  @visibility external
//  @return (array) Array of rowNums for rows with edit values pending submission.
//<

getAllEditRows : function (getIds) {
    return this.getAllEditCells(getIds, true);
},


getAllEditCells : function (getIds, rowsOnly) {
    var registry = this._editSessions,
        cells = [];
    if (!registry) return cells;

    if (getIds) return isc.getKeys(this._editSessions);

   
    for (var i in registry) {
        var rowNum = registry[i]._rowNum;
        // Convert "1" to 1, etc.
        
        rowNum = parseInt(rowNum);
        if (rowNum == null || rowNum < 0 || isNaN(rowNum)) continue;
        if (rowsOnly) cells[cells.length] = rowNum
        else {
            var colNum = registry[i]._colNum;
            // If rowNum only was stored on the cell, use the special getRowEditColNum() to
            // figure out the colNum in question
            if (colNum == null) {
                colNum = this._editorShowing && (rowNum == this.getEditRow()) 
                                    ? this.getEditCol() : this.getRowEditColNum(rowNum);
            }
            if (colNum != null && !isc.isA.Number(colNum)) colNum = parseInt(colNum);
            cells[cells.length] = [rowNum, colNum];
        }
    }
    return cells;  
},

//>	@method listGrid.getEditValues() 
// Returns the current set of unsaved edits for a given row being edited.
//
//  @param  valuesID (number | Object)  rowNum of the record being edited, or an Object
//                                      containing values for all the record's primary keys
//  @return (object)   Current editValues object for the row.  This contains the current
//                     edit values in {fieldName1:value1, fieldName2:value2} format.
//  @group  editing
//  @visibility external
//<
//  @param [colNum] (number) colNum of the record being edited. Only required if valuesID
//                           is passed in as a rowNum, and we're displaying one record per cell
//                          as in a +link{CubeGrid}

getEditValues : function (valuesID, colNum) {
    if (valuesID == null) return this.logWarn("getEditValues() called with no valuesID");
    
    // handle being passed a 2 element array [rowNum,colNum] since this is the format we
    // accept for setEditValues()
    if (colNum == null && isc.isA.Array(valuesID)) {
        colNum = valuesID[1];
        valuesID = valuesID[0];
    }
    
    // If we're showing an editor for this row, ensure that the current value in the
    // edit field is present in the editValues we return.
    var rowNum = (isc.isA.Number(valuesID) ? valuesID : this.getEditSessionRowNum(valuesID));
    if (this._editorShowing && (this.getEditRow() == rowNum)) {   
        this.storeUpdatedEditorValue();
    }
    
    return this._getEditValues(valuesID, colNum);
},

// Retrieve the stored edit values for some row (or null)
// Unlike the public method, this will not first update the editvals with the current value 
// from the editForm (if showing)
_getEditValues : function (valuesID, colNum) {
	// we may be passed the editValues object, in which case we're passing it back again, 
    var editSession = this.getEditSession(valuesID, colNum);
    return editSession != null ? editSession._editValues : null;
},

//> @method listGrid.getEditedRecord()
// Returns the combination of unsaved edits (if any) and original values (if any) for a given
// row being edited.
// <P>
// The returned value is never null, and can be freely modified.
//
// @param  valuesID (number | Object)  rowNum of the record being edited, or an Object
//                                      containing values for all the record's primary keys
// @return (Object) A copy of the record with unsaved edits included
// @group  editing
// @visibility external
//<

getEditedRecord : function (rowNum, colNum, suppressUpdate) {
    if (rowNum == null) return this.logWarn("getEditedRecord() called with no valuesID");

    // the valuesID allows for rowNum independant data storage - if passed a valuesID
    // determine resolve to rowNum/colNum here so we can get a pointer to the record object
    if (!isc.isA.Number(rowNum)) {
        rowNum = this.getEditSessionRowNum(rowNum);
        colNum = this.getEditSessionColNum(rowNum);
    }
    
    var record = this.getCellRecord(rowNum, colNum),
        // respect the parameter to avoid checking the edit form for updates                                                        
        editValues = suppressUpdate ? this._getEditValues(rowNum, colNum) 
                                    : this.getEditValues(rowNum, colNum);

    return isc.addProperties({}, record, editValues);
},

//> @method listGrid.getEditedCell()
// Returns the current value of a cell. If the cell has an outstanding edit value, this will
// be returned, otherwise the underlying value of the record will be returned.
//
// @param  record (number | Object)  rowNum of the record being edited, or an Object
//                                      containing values for all the record's primary keys
// @param field (number | string) colNum or fieldName of the cell
// @return (any) Current edit value, or underlying value for the cell 
// @group  editing
// @visibility external
//<
getEditedCell : function (record, field) {
    if (record == null || field == null) 
        return this.logWarn("getEditedCell() called with no record / field parameter");

    var editValues = this.getEditValues(record, field),
        rowNum = isc.isA.Number(record) ? record : this.getEditSessionRowNum(record),
        colNum = isc.isA.Number(field) ? field : this.getFieldNum(field),
        record = this.getCellRecord(rowNum, colNum);

    var editFieldName = this.getEditorName(rowNum, this.getField(colNum))
    var undef;
        
    if (editValues && editValues[editFieldName] !== undef) return editValues[editFieldName];        
    return record ? record[editFieldName] : null;
},

// When we attempt to save an edit remember the edit values
// We use this to perform intelligent change detection while pending a save on the server
rememberSubmittedEditValues : function (valuesID, colNum) {
    
    var editSession = this.getEditSession(valuesID);
    if (editSession != null) {
        editSession._submittedValues = isc.addProperties({}, editSession._editValues);
    }
},

// retrieve the last set of editValues submitted to the server.
getSubmittedEditValues : function (valuesID, colNum) {
    var editSession = this.getEditSession(valuesID, colNum);
    return editSession != null ? editSession._submittedValues : null;
},

// Clear the stored "submitted edit values" 
// called from editFailedCallback method - oldValues object is required so we don't clear
// the submitted editValues if they have been modified since the (failed) save was committed
// a case we can only hit if 2 overlapping saves have been kicked off.
clearSubmittedEditValues : function (valuesID, oldValues) {
    var editSession = this.getEditSession(valuesID);
    if (editSession == null) return;
    var submittedVals = editSession._submittedValues;
    if (!submittedVals) return;
    
    for (var field in oldValues) {
        if (submittedVals[field] == oldValues[field]) delete submittedVals[field];
    }
    if (isc.isA.emptyObject(submittedVals)) editSession._submittedValues = null;
},



//>	@method     listGrid.createEditValues() 
//
// This method creates a new set of editValues for a row at the end of the list, and returns
// the editValuesID which can subsequently be passed to any of the following methods as a
// unique identifier (in place of the 'rowNum' parameter where appropriate):
// 'setEditValue()', 'getEditValues()', 'getEditValue()', 'getEditValues()', 'clearEditValue()'
// and 'clearEditValues()'.<br>
// The new edit values will be displayed at the end of the list.
//
//  @param  values       (any)       New values for the row
//  @visibility advancedInlineEdit
//<

createEditValues : function (values) {
    var rowNum = this.body.getTotalRows();
	// set up the edit values, and display them in the listGrid (don't pass the 
	// suppressDisplay param)
    
    this.setEditValues(rowNum, values);
    return this.getEditValuesID(rowNum);
},



// initializeEditValues() - helper method to set up empty edit vals for some
// record
initializeEditValues : function (rowNum, colNum, displayNewValues) {
    // If we don't have edit values for this record, set them up.
    // (we can use the internal method - we know we don't have outstnding edits in the
    // edit form at this point, as the editor should have been hidden)
    if (this._getEditValues(rowNum, colNum) == null) {
        this.setEditValues([rowNum, colNum], {}, displayNewValues)
        //this.logWarn("editValues for row: " + rowNum + " are now: " + this.echo(this.getEditValues(rowNum)));
    }
},
    

//>	@method     listGrid.setEditValues() 
//
// This method sets up a set of editValues for some row / cell.  It differs from 
// 'setEditValue()' in that:<br>
// &nbsp;- it takes values for multiple fields<br> 
// &nbsp;- it clears out any previous edit values for the record<br>
//
//  @param rowNum (number) Row number for the record being edited
//  @param  values       (any)       New values for the row
//
// @visibility external
//<
// @param   suppressDisplay (boolean)   Additional internal parameter to suppress updating the
//                                      affected row to display the new edit values.
// Note that the first param may be a 2 element array of rowNum, colNum for one record-per-cell
// data models (documented in CubeGrid)

setEditValues : function (rowNum, editValues, suppressDisplay) {
    var colNum;
    if (isc.isAn.Array(rowNum)) {
        colNum = rowNum[1];
        rowNum = rowNum[0];
    }
    
    if (!isc.isA.Number(rowNum)) {
        this.logWarn("setEditValues() called with bad rowNum: " + this.echo(rowNum));
        return;
    }
    
    // Default to an empty set of values - if the user wants to entirely clear an editValues
	// object, they should use 'clearEditValue(s)' instead.
    if (editValues == null) editValues = {};
    
    var oldEditValues, changedFields, addedRow = true;
    if (!suppressDisplay) {

        var record = this.getCellRecord(rowNum, colNum);
        if (record == null) record = {};
        else addedRow = false;
        
        oldEditValues = this.getEditValues(rowNum, colNum);
        if (oldEditValues != null) addedRow = false;
        
        changedFields = isc.addProperties({}, oldEditValues);
        for (var i in changedFields) {
            changedFields[i] = record[i];
        } 
        isc.addProperties(changedFields, editValues);
        
        // At this point changedFields will be a mapping of the new edit display values for
        // each field that has been changed.
    }

    if (this.logIsInfoEnabled("gridEdit")) {
        oldEditValues = oldEditValues || this.getEditValues(rowNum, colNum);
        if (!oldEditValues) {
            this.logInfo("establishing new edit session at row: " + rowNum +
                         (colNum != null ? ", col:" + colNum : "") +
                         (this.logIsDebugEnabled("gridEdit") ?
                         " with values: " + this.echo(editValues) :
                         ""), "gridEdit");
        }
            
    }
	// store the new edit value 
    this._storeEditValues(rowNum, colNum, editValues);
    
    if (suppressDisplay || !this.isDrawn() || !this.body) return;
    
	// values shown in the cells for this row are now stale (whether each cell is being edited
	// or not), so refresh.
    
	// if totalRows changed, it indicates that that a new edit row is being created at the end
	// of the body, hence we need to redraw to add the row to the DOM
    var shouldRedrawBody =  (addedRow || this.body.isDirty());
        
    if (shouldRedrawBody) {
        var editorShowing = this.isEditingRecord(rowNum, colNum) && this._editRowForm != null
    
    	
        if (editorShowing) this._updateEditItemValues();

        this.body.markForRedraw(
        	
        );
        
    } else {        
        this._displayNewEditValues(rowNum, colNum, changedFields);
    }
},

_displayNewEditValues : function (rowNum, colNum, changedFields, errors) {
    
    if (!changedFields) {        
        return;
    }
    var editorShowing = this.isEditingRecord(rowNum, colNum) && this._editRowForm != null
    // update each cell effected by the change, either by setting the form item value or
	// refreshing the cell
    
    for (var fieldName in changedFields) {
        var editItemDrawn;
        if (editorShowing) {

            this._editRowForm.setValue(fieldName, changedFields[fieldName]);
            var editItem = this._editRowForm.getItem(fieldName),
                colNum = this.getFieldNum(fieldName);
            editItemDrawn = (colNum >=0 && editItem && this.canEditCell(rowNum, colNum));
        }

        // If we're not showing an edit form item for the cell, just refresh the cell
        // If colNum is passed in, respect it - likely for one record/cell cases
        // Otherwise figure out the colNum based on the field name
        var fieldColNum = colNum;
        if (colNum == null) fieldColNum = this.getColNum(fieldName);
        if (!editItemDrawn) {
            if (fieldColNum >= 0) this.refreshCell(rowNum, fieldColNum);
        } else if (errors && errors[fieldName]) {
            this.showCellErrors(rowNum, fieldColNum);
        } 
    }    
},


// Internal helper method for 'setEditValues' - actually stores the editValues object for the
// row
// Call 'setEditValues()' rather than calling this method directly.
// NOTE: editValuesId is a *highly internal* param that allows creating of a new editSession
// with a predictable ID

_storeEditValues : function (rowNum, colNum, editValues, editValuesId) {
    
	// Get the record for this row.  Note that this might be null as we may be adding a new
	// edit row to the end of the list.
    var record = this.getCellRecord(rowNum, colNum);

	// Assertion - if we don't have the edit data for this rowNum, we don't have the
	// edit data for this record, since 'getRecord()' will always associate the edit data
	// for some record with the appropriate rowNum, if required.
    var editSession = this.getEditSession(rowNum, colNum) || 
            this.createEditSession(rowNum, colNum, record, editValuesId);
	// Always add the primary keys to edit values for databound lists, so that they are
	// available to identify the record in saveEditedValues().  Non-databound lists are
	// expected to use object identity.
    if (this.dataSource != null) {
        // set the 'newRecord' marker on loading rows to indicate that there's no associated
        // record (and we don't have PKs for the row
        if (record == "loading") {
            editSession._newRecord = true;
        } else if (record != null) {
            var ds = this.getDataSource(),
                pkArray = ds.getPrimaryKeyFieldNames();
        
            for (var i = 0; i < pkArray.length; i++) {
                editValues[pkArray[i]] = record[pkArray[i]];
            }
        }
    }

    // set the _newRecord flag for each row without an associated record     
    if (record == null) {
        editSession._newRecord = true;
        
        // if we have any fields with a specified default value, pick it up as a default
        // edit value.
        // (true even if the field is hidden)
        
        // If we are showing any 'enum' type fields, and 
        var fields = this.completeFields || this.fields || [],
            undef;
            
        for (var i = 0; i < fields.length; i++) {
            var field = fields[i],
                fieldName = field[this.fieldIdProperty];
            if (editValues[fieldName] === undef) {
                if (field.defaultValue != null) {            
                    editValues[fieldName] = field.defaultValue;
                } else if (this.enumCriteriaAsInitialValues && 
                            field.type == "enum" && this._filterValues != null&&
                            this._filterValues[fieldName] != null) 
                {
                    // We could check the value against this.getEditorValueMap(fieldName, null)?
                    editValues[fieldName] = this._filterValues[fieldName];
                }
            }
        }
    }

	// clear out any stored editValues and copy the passed editValues into place, preserving
	// the same instance.
    for (var i in editSession._editValues) {
        delete editSession._editValues[i];
    }
    for (var i in editValues) {
        editSession._editValues[i] = editValues[i];
    }

	// Cache the last edit row - used by 'getTotalRows()'.  This value will also be 
	// updated by 'clearEditValues()'
    
    if (this._lastEditRow == null || rowNum >= this._lastEditRow) {
        this._lastEditRow = rowNum
    }

},

//>	@method     listGrid.createEditSession() (I)
//
//  Internal method to initially set up internal, temporary edit values (and old, pre edit values)
//  for a record.
//  This method doesn't store these editValues - use 'setEditValues()' for that
//  These get updated as the record is edited, and cleared out when the edit is complete.
//
//  @group  editing
//  @visibility internal
//<

createEditSession : function (rowNum, colNum, record, editValuesID) {

    var editSession = {};
    if (record != null && record != "loading") 
        editSession._primaryKeys = this.getPrimaryKeys(record);

	// A null primary key will imply we're editing a new record.
	// Assertion: when initializing edit data we will always be passed a rowNum
	
    editSession._rowNum = rowNum;
    if (this.useCellRecords) {
        editSession._colNum = colNum;
        
        if (this.getCellFacetValues) editSession._facetValues = this.getCellFacetValues(rowNum, colNum);
    }

    editSession._editValues = {};
    
    if (this._editSessions == null) this._editSessions = {};
    
	// generate an editValuesId if not passed one
    if (editValuesID == null) {
        if (this._currentEditValuesID == null) this._currentEditValuesID = 0;
        editValuesID = "_" + this._currentEditValuesID++;
    }
    
    this._editSessions[editValuesID] = editSession; 

    // editRowMap used for retrieving edit sessions / row
    if (this._editRowMap == null) this._editRowMap = {};
    this._editRowMap[rowNum] = editValuesID;
    return editSession;
},    


//>	@method     listGrid.setEditValue()     ([A])
//
//  Modifies a field value being tracked as an unsaved user edit.<P>
//  Use for suggested or reformatted values for edits that remain unsaved.
//
//  @group  editing
//  @visibility external
//
//  @param  rowNum      (number)    Row number (or edit values ID)
//  @param  colNum      (number | string)    Column number of cell, or name of field
//                                           having editValue updated
//  @param  value       (any)       New value for the appropriate field.
//<

setEditValue : function (rowNum, colNum, newValue, suppressDisplay, suppressChange) {
    
    var fieldName = isc.isA.String(colNum) ? colNum : this.getEditorName(rowNum, colNum);
    if (isc.isA.String(colNum)) colNum = this.getFieldNum(colNum);

	// store the new edit value 
    
    var changed = this._storeEditValue(rowNum, colNum, fieldName, newValue, suppressChange);
	// only proceed if there was a change 
    if (!changed) return;
    
    // If this is an edit value for a field with a specified displayField, also update the
    // edit value of the displayField
    
    var field = this.getField(fieldName);
    if (field && this._useDisplayFieldValue(field)) {
        var displayValue;
        // If we're showing an edit form for this row, ask the edit form for the display
        // field's value
        var editForm = this.getEditForm();
        if (editForm && this.getEditRow() == rowNum && 
            this.fieldValuesAreEqual(field, editForm.getValue(fieldName), newValue)) 
        {
            displayValue = editForm.getValue(field.displayField);
        }
        if (displayValue == null) {
            
            var data = this.data;
            if (isc.ResultSet && isc.isA.ResultSet(data)) data = data.localData;
            if (data) {
                var record = data.find(fieldName, newValue);
                displayValue = (record ? record[field.displayField] : newValue);
            } else {
                displayValue = newValue;
            }
        }
        
        this.setEditValue(rowNum, field.displayField, displayValue, suppressDisplay, true);
    }
    // If we're not supposed to update the display we're done.
    
    if (suppressDisplay) return;
    // Remember which field was most recently modified - this will be passed to callbacks as
    // the 'colNum' param
    this.setRowEditFieldName(rowNum, fieldName);
    
    if (!isc.isA.Number(rowNum)) {
        colNum = this.getEditSessionColNum(rowNum);
        rowNum = this.getEditSessionRowNum(rowNum);

    } else if (!isc.isA.Number(colNum)) {
        
        colNum = this.getFieldNum(colNum);
    }
    var vals = {};
    vals[fieldName] = newValue;
    this._displayNewEditValues(rowNum, colNum, vals);
},

// store an edit value, firing editorChange() notification if there was a change.
// internal helper: call setEditValue() instead

_storeEditValue : function (rowNum, colNum, fieldName, newValue, suppressChange) {

    
    var changed = true, saveEqual = false,
        editSession, editValues, oldValue,
        undef;
        
    editSession = this.getEditSession(rowNum, colNum)
    if (editSession != null) {
        editValues = editSession._editValues;
        oldValue = editValues[fieldName];
    } else {
    	// create a new set of edit values as necessary   
        this.logInfo("creating new edit values for row: " + rowNum, "gridEdit");
        this.initializeEditValues(rowNum, colNum, true);
        editSession = this.getEditSession(rowNum, colNum);
        editValues = editSession._editValues;
    }
   
    // if there's no previous editValue, the old value is the original value from the
	// dataset
    if (oldValue === undef) {
        var record = this.getCellRecord(rowNum, colNum);
        oldValue = record ? record[fieldName] : null;
                  
    
    } else saveEqual = true;
    
    
    var field = this.getField(fieldName);        
    if (this.fieldValuesAreEqual(field, oldValue, newValue)) changed = false; // indicate no change

    // store the changed value
    // Note: If newValue was not passed in, clear the field value instead.        
    if (newValue === undef) delete editValues[fieldName];
    else if (saveEqual || changed) editValues[fieldName] = newValue;

    //this.logDebug("edit value changed: oldValue: " + this.echo(oldValue) +
    //              ", new value: " + this.echo(newValue), "gridEdit");
    
	// fire the change notification.
    if (changed && !suppressChange){
        this._editorChange(rowNum, colNum, newValue, oldValue);
    }

    return changed; // indicate change
},

// setRowEditFieldName() - used to track which field was last being edited for some set of edit values
setRowEditFieldName : function (rowNum, fieldName) {

    var editSession = this.getEditSession(rowNum);
    // Set up empty edit values if necessary
    if (!editSession) {
        var colNum = this.getColNum(fieldName);
        this.setEditValues([rowNum, colNum], null, true);
        editSession = this.getEditSession(rowNum);
    }
    
    if (isc.isA.Number(fieldName)) fieldName = this.getFieldName(fieldName);
    editSession._lastField = fieldName;
},

// getEditField() - given an edited row / valuesID, return the name of the last field being
// edited for that row
getRowEditFieldName : function (editValuesID) {
    var editSession = this.getEditSession(editValuesID);
    return (editSession ? editSession._lastField : null);
},

// getRowEditColNum - returns the colNum for the last edited field within some edit row
getRowEditColNum : function (editValuesID) {
    var fieldName = this.getRowEditFieldName(editValuesID);
    return fieldName ? this.getColNum(fieldName) : null;
},


//>	@method     listGrid.getEditValue() 
//
// Returns the current temporary locally stored edit value for some field within a record 
// being edited.
//
// @param  rowNum  (number)    index of the row for which the editValue should be returned
// @param  colNum (number | string) index of the field, or fieldName, for which value should be 
//                              returned
// @return (any)   edit value for the field in question
// @group  editing
// @visibility external
//<

getEditValue : function (rowNum, colNum) {

    var colID = colNum
    if (isc.isA.String(colNum)) colNum = this.getColNum(colNum);
    if (this._editorShowing && 
        (this.getEditRow() == rowNum) && (this.getEditCol() == colNum)) 
    {
        this.storeUpdatedEditorValue();
    }
    
    // Note pass the original column ID (colNum or fieldName) on to the _getEditValue() method
    // since there may be no column associated with the fieldName passed in
    return this._getEditValue(rowNum, colID);
},

// Retrieve the stored edit value for some row / field
// (unlike the public method, this will NOT first check for the value present in the editor 
// if showing)
_getEditValue : function (rowNum, colNum) {
	// Note: Edit values are a case where the distinction between a value being unset and
	// being set to null is important... One case implies the user has not edited a cell,
	// the other implies the user has cleared out an edit value from a cell...
    var vals = this._getEditValues(rowNum, colNum);
	// Return undefined rather than explicit null if the edit row doesn't have any stored 
	// values
    if (vals == null) return;
    
    // Convert the colNum to a fieldName to get the value
    if (!isc.isA.String(colNum)) colNum = this.getEditorName(rowNum, colNum);
    return vals[colNum];
},



//>	@method     listGrid.clearEditValue()   ([A])
//
//  Clear a field value being tracked as an unsaved user edit.<P>
//  The saved record value will be displayed in the the appropriate cell instead.
//  Will also discard any validation errors for the specified field / row.
//
//  @group  editing
//  @visibility external
//
//  @param  editValuesID (number | object)    Row number, primary keys object for the record,
//                                              or editValues object
//  @param  colNum (number | string)    Column number, or Name of field for which 
//                                      the value is to be cleared
//<
// @param   suppressDisplay (boolean)   Optional internal parameter to avoid updating the 
//                                      affected cell to display the field value for the record
//                                      rather than the cleared out edit value.
// Note that in LGs the second parameter can be a fieldName
// If we're dealing with a 1 record / cell data model (EG CubeGrid) we need to 
// be passed either a true editValuesId as the first parameter OR a colNum and a rowNum
clearEditValue : function (editValuesID, colNum, suppressDisplay, dontDropAll) {
    var rowNum = (isc.isA.Number(editValuesID) ? editValuesID 
                                               : this.getEditSessionRowNum(editValuesID));

    var fieldName = colNum;
    if (isc.isA.Number(fieldName)) fieldName == this.getEditorName(rowNum, fieldName);
    
    // If the user is currently editing this field, ensure the current value in the edit form
    // item is stored in this.editValues before clearing it, (so that the focused field is
    // successfully cleared!)
    if (this._editorShowing) {
        if (this.getEditRow() == rowNum && this.getEditFieldName() == fieldName) {
            // Suppress change - we're about to clear the value anyway!
            this.storeUpdatedEditorValue(true);
        }
    }
                                                   
    // 
	// This method will remove the edit value from the appropraite editValues object
	// If that was the last editValue in the object, fall through to clearEditValues to remove
	// the entire object
	// Otherwise, if suppressDisplay is not passed:
	// - if the field had validation errors, re-style the affected cell to hide the validation
	//   style (by default a red outline)
	// - if there is an editRowForm item for the effected cell, update it's value to reflect
	//   the value of the record
	// - otherwise call refresh cell to update the static innerHTML for the cell

    var editSession = this.getEditSession(editValuesID, colNum);
    //this.logWarn("clearEditValue got editSession: " + this.echo(editSession));

    if (editSession == null) return;
    
    var editValues = editSession._editValues,
        hasChanges = false,
        submittedValues = editSession._submittedValues,
        errors = editSession._validationErrors,
        hadErrors = errors && errors[fieldName],
        rowNum = editSession._rowNum;
        
    if (editValues != null) {
        var record = this.getRecord(rowNum);
        hasChanges = isc.propertyDefined(editValues, fieldName) && 
                     ((rowNum == null || record == null) || 
                         !this.fieldValuesAreEqual(this.getField(fieldName), 
                                                   editValues[fieldName], record[fieldName]));
         
        delete editValues[fieldName];
        if (submittedValues) delete submittedValues[fieldName];
        if (errors != null) delete errors[fieldName];

    	// If there's nothing in the editValues, clear the vals for the whole row
    	
        if (!dontDropAll && isc.isAn.emptyObject(editValues)) {
            this.logDebug("no edit values left for row, discarding editSession", "gridEdit");
            return this._clearEditValues(editValuesID, colNum, suppressDisplay);
        }
    }
    
    // If this field has a specified 'display' field, we track edit values on that field that
    // match the record with the editValue specified for this field.
    // Drop the value on the display field as well.
    
    var field = this.getField(fieldName);
    if (field && this._useDisplayFieldValue(field) && (field.displayField != fieldName)) {        
        this.clearEditValue(editValuesID, field.displayField, suppressDisplay, dontDropAll)
    }
    
    // If the edit val isn't displayed in a cell in this grid, we're done
    // otherwise continue to update the value if it changed, and clear any errors from the
    // cell.
    
    if (suppressDisplay || rowNum == null) return;

    var colNum = this.getColNum(fieldName);

	// Update the display:
	// - If the edit form is showing for the row always set its value for the field
    // - If the cell is visible, but we're not showing an edit form item for it, refresh the 
    //   cell to display the value of the record
    // Otherwise if we had errors, refresh the cell to hide the error icons
    if (hasChanges) {
        var editItemDrawn;
        if (this._editorShowing && this.getEditRow() == rowNum) {
            var newVal = record ? record[fieldName] : null;
            this._editRowForm.setValue(fieldName, newVal);
            editItemDrawn = colNum >= 0 && this.canEditCell(rowNum, colNum) && 
                            this._editRowForm.getItem(fieldName);
        }
        
        if (colNum >= 0 && !editItemDrawn) this.refreshCell(rowNum, colNum);

	// If we had validation errors for the cell, call 'refreshCellStyle' to clear the 
    // error hilight from the cell (only necessary if we didn't refresh the entire cell)
    } else if (hadErrors && colNum >= 0) {
        if (hadErrors) this.showCellErrors(rowNum, colNum);
    }
},

//>	@method     listGrid._clearEditValues()
//
//  Clear a whole row of values being tracked as an unsaved user edit.<P>
//  This should not be used for clearing out the edit values for some row after a save
//  has completed.  When a save has been successfully confirmed for some set of cell values, 
//  the stored values should be cleared cell by cell using 'clearEditValue()', rather than 
//  this method.
//
//  @group  editing
//  @visibility internal
//
//  @param  editValuesID      (number | object)    Identifier for the editValues to clear.
//                                                  This can be a rowNum, or a set of 
//                                                  editValues (or a primary key)
//<
//  @param [colNum] (number) colNum of the record being edited. Only required if valuesID
//                           is passed in as a rowNum, and we're displaying one record per cell
//                          as in a +link{CubeGrid}
// @param   dontRefresh (boolean)   Optional internal parameter. If passed, don't update any
//                                  affected cells to display the removed edit values

_clearEditValues : function (editValuesID, colNum, dontRefresh) {
	// This method must 
	// - update the central editSessions object to remove the specified set of edit values
	// - update the editRowMap if these values were mapped to a row.
	// - if this was a row beyond the end of the data for the List, shuffle subsequent 
	//   temporary edit values down a rowNum
	// if refreshing to display the change:
	//   - if this was a row beyond the end of the list, it must be removed from the list:
	//      - if the editRowForm is showing for the row, it must be hidden
	//      - the body must be redrawn.
	//   - otherwise for each cell for which there was an edit value before this method must
	//     be updated.
	//      - if an edit form item is showing for the field 
	//          - its value should be updated to show the record's value
	//          - if there were any validation errors for the row, the style of the relevant
	//            cells should be updated 
	//      - otherwise the cell should be refreshed to show the record's value as static HTML.

    if (editValuesID == null) {
    	
        return;
    }
    

	// If we're passed a rowNum, or primary keys, resolve to an editValuesID
    if (!isc.isA.String(editValuesID)) editValuesID = this.getEditValuesID(editValuesID, colNum);
    var editSession = this.getEditSession(editValuesID);
    

	// Bail if we can't get the object (not necessarily an error - may have already been 
	// cleared)
    if (editSession == null) return;

    var rowNum = editSession._rowNum;
    if (rowNum != null) delete this._editRowMap[rowNum];
    // for cellRecords, ensure we have a valid rowNum and colNum
    if (colNum == null) colNum = editSession._colNum;

    var valuesObj = this._editSessions[editValuesID];
	// clear the object from the array
    delete this._editSessions[editValuesID];

	// Clear out the cached last edit row. Will be recalc'd lazily when required
    
    var lastRow = this._getLastEditRow();
    delete this._lastEditRow;
	// If this is a new record (not yet saved in the dataset), and we have any subsequent new
	// edit rows, we have to shuffle them down to fill the gap left by this record.
    if (rowNum != null && editSession._newRecord) {
        var editRow = this.getEditRow();

        for (var i = rowNum+1; i <= lastRow; i++) {
            var newRowObject = this.getEditSession(i);
            var oldRow = newRowObject._rowNum;
            newRowObject._rowNum = i-1;

        	//this.logWarn("clearEditValues reordering temp rows." + 
        	//             " editSession: " + this.echo(newRowObject) + 
        	//             " was at row: " + oldRow);

        	// No danger of putting this over another edit record, since we have already moved
        	// every one.
            this._editRowMap[i-1] = this._editRowMap[i];
            delete this._editRowMap[i];
        }
    	// If we're currently showing an editor for a subsequent temp-row, shift it up one row
        if (editRow != null && editRow > rowNum) this._editRowNum -= 1;

    	//this.logWarn("clearEditValues: editRow was at: " + editRow + 
    	//             " now at: " + this._editRowNum);

        // We're clearing out edit values for an additional row beyond the end of the grid's data
        // refresh the UI if necessary
        if (!dontRefresh) {
    		if (this._editorShowing) {
                    // if we're showing the inline editor for this row hide it now.
                    if (rowNum == editRow) this.hideInlineEditor();
                    // Otherwise if the edit row was AFTER this row, shuffle it up by 1 row to
                    // account for this row going away
                    else {                        
                        if (rowNum < editRow) this._moveEditor(editRow-1, null, "Earlier temp edit row removed");
                    }
            }
        	// Redraw the body to hide the additional row.
            this.body.markForRedraw("clear edit values, remove row");
        }
        
    } else if (rowNum != null && !dontRefresh) {
        this._displayNewEditValues(rowNum, colNum, valuesObj._editValues, 
                                   valuesObj._validationErrors);
   }
},






//> @method listGrid.newRecordForEditValues()
// Internal method to associate a set of pending edit values with a new record in the
// dataset.<br>
// This method is required to handle the saving of a new edit row on the end of a list.
// When the save returns we need to associate the edit values with the record in the dataSet
// (which may also change the rowNum of the record). 
// With background saving (waitForSave:false), after the attempted save was submitted to the
// server, further editing may have taken place.  This method will make sure any further edits
// get associated with the new record.
//
// @param editValuesId (ID)     id for the editValues which have been saved as a new record
// @param rowNum       (number) index of the newly saved record
// @visibility internal
//<


newRecordForEditValues : function (editValuesId, record) {

    
    var oldEditSession = this.getEditSession(editValuesId),
        editValues = oldEditSession._editValues;
    oldEditSession._primaryKeys = this.getPrimaryKeys(record);
    var pkFields = this.getDataSource().getPrimaryKeyFieldNames();
    for (var i = 0; i<pkFields.length; i++) {
        var field = pkFields[i];
        editValues[field] = record[field];
    }
    
    delete oldEditSession._newRecord;
},




// Re-associate all editValues with the appropriate rowNums for the records.
// Fired in response to dataChanged().
// This will be fired when the data is re-sorted, re-filtered, modified asynchronously from
// the server, or scrolled such that the cache is dropped when we have a partial cache.
// In any of these cases, the rowNums for each record can change (and in some cases rows can 
// be entirely removed from the data cache)
// This method will attempt to match the editValues to the cached records after dataChanged()
// and update the rowNums as appropriate.  It will also take any editValues that represent
// newly created records and renumber them so they are past the new end of the dataset.
// If a record can't be found for some editValues object, there are a couple of possibilities:
// - If we have a complete cache (or local data), we know the record has gone from the dataSet
//   so we warn the user and clear out the editValues for that record
// - If we have a partial cache, the record may have gone from the resultSet (filter change,
//   for example), or it may be available in the resultSet, but not loaded in the client-side 
//   cache (scrolled out of view).
//   In this case we keep the editValues around and set the _hasUnmatchedEdits flag on the 
//   ListGrid.  getCellRecord() will then compare each record with the unmatched edits whenever
//   it is called, so we will reassociate the editValues with the appropriate rowNum as soon as
//   it is scrolled into view.
//   Note that editing will be dismissed if the record that was being edited vanishes in this
//   way.



_remapEditRows : function (dontMoveEditor) {
	// clear out the _lastEditRow and _hasUnmatchedEdits flags 
    // - lastEditRow can ge recalc'd lazily when required.
    // - we'll update _hasUnmatched edits below if required.
    delete this._lastEditRow;
    delete this._hasUnmatchedEdits;
    if (this._editSessions == null) return;

    var oldEditRow = this.getEditRow(),
        oldEditCol = this.getEditCol(),
        foundOldRecord = false;
        
    var lastRowNum = this.data.getLength(),
        editRowMap = {};

	// getKeys() first to avoid possible problems with key deletion during for..in (never
	// observed)
    var sessionList = isc.getKeys(this._editSessions);

    for (var i = 0; i < sessionList.length; i++) {
        
        
        var editValuesId = sessionList[i],
            editSession = this._editSessions[editValuesId];
        var newCell = this._calculateEditCell(editSession, lastRowNum);
        // increment the lastRowNum if we added a row
        
        if (editSession._primaryKeys == null) lastRowNum ++;
        
        // newCell == null -> notification that we totally dropped an edit session
        if (newCell == null) continue;
        
        var newRowNum = newCell[0],
            newColNum = newCell[1];
            
        if (newRowNum != null && newRowNum >= 0) {
            // we found the corresponding record in the modified dataset (or it was an unsaved,
        	// newly created record)
            
        	// Is this the current edit record?
            if (oldEditRow != null && oldEditRow == editSession._rowNum &&
                (!this.useCellRecords || (oldEditCol == editSession._colNum))) 
            {
                foundOldRecord = true;
                // moveEditor will shift the edit form if necessary
                if (!dontMoveEditor) this._moveEditor(newRowNum, newColNum, "remapEditRows")
            }
            
            editRowMap[newRowNum] = editValuesId;            
            
            editSession._rowNum = newRowNum;
            if (this.useCellRecords) editSession._colNum = newColNum;
            
        } else {      
        	// drop the edit if the record being edited was clearly deleted
            if (!this.dataSource || this.saveLocally ||
                (isc.ResultSet && isc.isA.ResultSet(this.data) && this.data.allRowsCached())) 
            {
                this.logWarn("Record:" + this.echo(editSession._primaryKeys) + 
                   ", is no longer present in this List.<br>Clearing edit values for this record.");

                delete this._editSessions[this.getEditValuesID(editValuesId)];
            } else {
            	// the record could be either truly gone, or just not in the cache.  Hold onto
            	// the edits hoping the record reappears (in which case we'll reassociate the
                // edit values with the record).
                // Note: If we're working with a paged result set, the data will typically have
                // disappeared because it has been scrolled out of view (due to data resort, 
                // etc.) In this case it will reappear with scrolling.
                // However the data may have disappeared as it no longer matches the current 
                // filter criteria.
                // We could also add a check for 'data.allMatchingRowsCached()' and handle the
                // case where we have loaded all the records for the current filter criteria
                // differently. We're much more likely to encounter the case of having loaded
                // all rows that match some criteria than caching every row in the data set.
                this.logWarn("Record:" + this.echo(editSession._primaryKeys) + 
                    ", lost from local cache in paged result set. " +
                    "Pending edits for this record will be maintained.");
                delete editSession._rowNum;
                delete editSession._colNum;
                this._hasUnmatchedEdits = true;
            }
        }
    }
    

	// store the new editSession locations
    this._editRowMap = editRowMap;

	
    if (oldEditRow != null && !foundOldRecord && !dontMoveEditor) {
        this.hideInlineEditor(true);
    }
},

// calculateCell - helper for remapEditRows - given an editSession determine which cell it
// currently belongs to so we can update editSession._rowNum/colNum etc
_calculateEditCell : function (editSession, lastRowNum) {
    
    var newRowNum, newColNum,
        pk = editSession._primaryKeys;

    // in the case of a new edit row, we want to just make sure the rowNums are off the
    // end of the data...
    if (pk == null) {
        newRowNum = lastRowNum;
        
    } else {
        
        // if the editValues consist of just primary keys, drop them unless this is the
        // editSession for the current editRow
        
        var editValues = editSession._editValues,
            hasEdits = false,
            undef;
        if (editSession._validationErrors != null &&
            !isc.isA.emptyObject(editSession._validationErrors_)) 
        { 
            hasEdits = true;
        } else {
            for (var val in editValues) {
                if (editValues[val] != pk[val] || pk[val] === undef) {
                    hasEdits = true;
                    break;
                }
            }
        }
        
        if (!hasEdits && editSession._rowNum != null && 
            !this.isEditingRecord(editSession._rowNum, editSession._colNum)) 
        {
            this.logInfo("dropping empty editSession", "gridEdit");
            delete this._editSessions[this.getEditValuesID(editSession)];
            return null;
        }
        
        // look for a row with matching primary keys
        newRowNum = this.findRowNum(pk, editSession);        
        // colNum will only apply when the data model shows 1 record/cell (EG CubeGrid);
        newColNum = this.findColNum(pk, editSession);
    }
    
    return [newRowNum,newColNum];
},

// Override _filter 
// - if we have pending edits, changing the filter criteria means that the
//   edited rows may not show up in the returned set of values.
//   For windowed result sets this is true even if we're broadening our criteria, as the edited
//   row may not be in our viewport.
//   In this case if confirmDiscardEdits is true, show a dialog giving the user a chance to 
//   save or discard unsaved edits.
// - if we are showing a filterEditor, update the filterEditor values to show the new criteria
_filter : function (type, criteria, callback, requestProperties, doneSaving) {
    if (!doneSaving && this.confirmDiscardEdits && this.dataSource != null) {
   
        if (this.hasChanges() &&         
            // If the criteria is unchanged, the filter will be a no-op. In this case
            // no need to drop edit values
                            
            !(isc.ResultSet && isc.isA.ResultSet(this.data) &&
                  this.data.compareCriteria(criteria, this.data.getCriteria()) == 0) ) 
        {
         
            this.showLostEditsConfirmation({target:this, methodName:"_continueFilter"},
                                           {target:this, methodName:"_cancelFilter"});
            this._filterArgs = {
                type:type, criteria:criteria, callback:callback, 
                requestProperties:requestProperties
            }
            return;
        }
    }
    
    this.setFilterValues(criteria);

    return this.Super("_filter", [type,criteria,callback,requestProperties], arguments);
},

// Completes a filter after the user has been prompted to save or discard pending edits.
_continueFilter : function () {
    var args = this._filterArgs,
        type = args.type, criteria = args.criteria, callback = args.callback,
        requestProperties = args.requestProperties;
    delete this._filterArgs;
    this._filter(type, criteria, callback, requestProperties, true);
},

// Fired when a user cancelled a filter to resolve pending edits.
_cancelFilter : function () {
    delete this._filterArgs;
},
  
// showLostEditsConfirmation() - this method is fired from sort / filter if there are 
// outstanding unsaved edits that may be otherwise lost by the sort/filter action.
// Shows the user a dialog with options to save, discard, or cancel.
showLostEditsConfirmation : function (continueCallback, cancelCallback) {
    // these callbacks will be fired, then cleared up when the callback fries from the
    // global warn dialog.
    this._continueCallback = continueCallback;
    this._cancelCallback = cancelCallback;

    isc.confirm(this.confirmDiscardEditsMessage, 
                "if(window[this.targetGridID])window[this.targetGridID].lostEditsCallback(value, this);",
                {   targetGridID:this.getID(),
                    
                    
                    // Show "OK", "Save" and "Cancel" buttons
                    buttons:[isc.Dialog.OK,
                             {title:this.discardEditsSaveButtonTitle, width:75,
                              click:"this.hide();this.topElement.returnValue('save');"},
                             isc.Dialog.CANCEL]
                });
},

// Fired as a callback from the user selecting ok/save/cancel from the dialog displayed in
// showLostEditsConfirmation().
// Will save or discard edits as appropriate, and call any callback (used to fire the action
// after the values have been saved / discarded).
lostEditsCallback : function (value, dialog) {
    var continueCallback = this._continueCallback,
        cancelCallback = this._cancelCallback;
    delete this._continueCallback;
    delete this._cancelCallback;
    
    // CancelClick
    if (value == null) {
        this.fireCallback(cancelCallback);

    // Ok click
    } else if (value == true) {
        this.discardAllEdits();
        this.fireCallback(continueCallback);
    
    // save click
    } else if (value == "save") {
        // Pass continueCallback into saveAllEdits - we want to allow the
        // original action to continue after the save completes
        this.saveAllEdits(null, continueCallback);
    }
    
    // clear out the targetGrid pointer from the global warn dialog
    dialog.targetGrid = null;
},

// Given the primary keys for some record, return the rowNum.
findRowNum : function (primaryKeys) {
	// for local data, we use pointers to the records as special primary keys.
	// for dataSource data, indexOf will handle being passed a set of primary keys, or a record
	// object
	// If the record is not cached, this will return -1
    return this.data.indexOf(primaryKeys);
},

// Given the primary keys for some record return the colNum of the cell displaying the
// record
// Required to support 1 record / cell data model (EG cubeGrid)
findColNum : function (primaryKeys) {
    // ListGrids never show 1 record/cell so just return -1
    return -1;
},




_moveEditor : function (rowNum, colNum, reason) {

    if (!this._editorShowing || rowNum == this._editRowNum) return;

    var previousRow = this._editRowNum;

    this.logInfo(reason + ": editSession: " + this.getEditValuesID(rowNum) +
                 " with values: " + this.echo(this._getEditValues(rowNum, colNum)) +
                 " was being edited at row: " + previousRow + 
                 ", will now edit at row: " + rowNum, "gridEdit");
    this._editRowNum = rowNum;

    var editForm = this._editRowForm,
        items = editForm ? editForm.getItems() : null;
    if (items) {
        for (var i = 0; i < items.length; i++) {
            items[i].rowNum = rowNum;
        }
    }
},

//> @method     listGrid.rowEditNotComplete()
//  Given a rowNum, return true if we have locally stored editValues for the row.  This implies
//  that it is the current edit row (an editor is showing in that row), or that it has not been
//  saved since it was edited - likely due to save / validation errors.
//  @group  editing
//  @visibility internal
//  @param  rowNum (number) index of row for which we want to determine 'edit status'
//  @return (boolean)   true if we still have edit values for the row
//<
rowEditNotComplete : function (rowNum) {
    return (this._editRowMap != null && this._editRowMap[rowNum] != null);
},

// ---------------------------------------------------------------------------------------

_editorChange : function (rowNum, colNum, newValue, oldValue) {
    
	
    var record = this.getCellRecord(rowNum, colNum);
    if (this.editorChange != null) this.editorChange(record,newValue,oldValue,rowNum,colNum);
	//>!BackCompat 2004.12.10
    var fieldName = this.getFieldName(colNum);
    if (this.editValueChanged != null) 
        this.editValueChanged(rowNum, fieldName, newValue, oldValue);
	//<!BackCompat
    

	// If we are providing dynamic edit item value maps for any fields, they may return a 
	// different value since their value may be dependant on the edited field.
	// Therefore we go through and determine whether we need to update the valueMap for any 
	// form items visible in the rowEditForm.
    
    if (this._editorShowing && this.isEditingRecord(rowNum, colNum) && this.fields != null) {
        record = isc.addProperties({}, this._getEditValues(rowNum, colNum), record);
        var fields = !this.editByCell ? this.fields : [this.getEditField()];
        
        
        for (var i =0; i < fields.length; i++) {
            var field = fields[i],
                formItem = this._editRowForm.getItem(field[this.fieldIdProperty]);
            
        	// We don't create form items for unrendered fields if we're incrementally rendering
            if (formItem == null) continue;
            
            var valueMap = this.getEditorValueMap(field, this.getEditedRecord(rowNum, colNum, true));

            if (formItem.valueMap != valueMap) formItem.setValueMap(valueMap);
        }
    }
},


//>	@method     listGrid.getEditRow() 
//
//  Returns the index of the row being edited or null if there is no current edit row.
//
//  @group  editing
//  @visibility external
//
//  @return (number)    Index of the current edit row
//<
getEditRow : function () {
    return this._editRowNum;
},

//>	@method     listGrid.getEditCol() 
//
//  Returns the index of the column being edited or null if there is no edit col.
//
//  @group  editing
//  @visibility external
//
//  @return (number)    Index of the current edit column
//<
getEditCol : function () {
    return this._editColNum;
},

//>	@method     listGrid.getEditField() 
//
//  Returns the field object associated with cell currently being edited
//
//  @group  editing
//  @visibility external
//
//  @return (object)    Field object definition
//<
getEditField : function () {
    return this.getField(this.getEditCol());
},

//>	@method     listGrid.getEditFieldName() 
//
//  Returns the field name for the current edit field
//
//  @group  editing
//  @visibility internal
//
//  @return (string) Field name
//<
getEditFieldName : function () {
    return this.getFieldName(this.getEditCol());
},


//>	@method     listGrid.getEditRecord() 
//
//  Returns the record object currently being edited
//
//  @group  editing
//  @visibility internal
//
//  @return (object)    Current edit record object
//<
getEditRecord : function () {
    return this.getCellRecord(this.getEditRow(), this.getEditCol());
},

//>	@method     listGrid.cancelEditing() 
//
//  Cancel the current edit without saving.
//
//  @group  editing
//  @visibility external
//<
// cancel the current edit, whatever it is (user visible)
cancelEditing : function (editCompletionEvent) {
    if (!this._editorShowing) return;
    if (editCompletionEvent == null) editCompletionEvent = isc.ListGrid.PROGRAMMATIC;
    this._killEdit(this._editingFlowID, editCompletionEvent);
},    

//>	@method     listGrid.cellEditEnd() 
//
//  Method called on when editing ends for a cell as a result of a user interaction.
//  <P>
//  Editing may continue in another cell or row or end entirely, depending on the
//  editCompletionEvent, which represents what action the user took to end editing.  
//  <P>
//  If this.shouldCancelEdit(rowNum, colNum, editCompletionEvent) returns true, the edit is 
//  cancelled.
//  <P>
//  Otherwise the edit will be saved, and we'll proceed to a new cell to edit based on 
//  getNextEditCell(rowNum, colNum, editCompletionEvent).
//  <P>
//  Return false from this method to notify the caller that the intended behavior failed -
//  typically this cancels the cell edit end (restoring focus to the appropriate edit-field).
//
//  @group  editing
//  @visibility internal
//
//  @param  editCompletionEvent (EditCompletionEvent)  Edit completion event constant 
//                                                          indicating how edit was
//                                                          completed
//  @param  [newValue]    (any)   New Value for the edited cell. If not passed will be derived
//                                from current editor value for the edited cell.
//  @return (boolean)    False if the user should still be editing the current cell.
//<
cellEditEnd : function (editCompletionEvent, newValue) {
    // delete the _editSessionFromKeypress flag when editing completes unless the user is
    // simply using the keyboard to shift to another cell
    if (this._editSessionFromKeyPress && 
        editCompletionEvent != isc.ListGrid.TAB_KEYPRESS &&
        editCompletionEvent != isc.ListGrid.SHIFT_TAB_KEYPRESS &&
        editCompletionEvent != isc.ListGrid.UP_ARROW_KEYPRESS &&
        editCompletionEvent != isc.ListGrid.DOWN_ARROW_KEYPRESS &&
        editCompletionEvent != isc.ListGrid.LEFT_ARROW_KEYPRESS &&
        editCompletionEvent != isc.ListGrid.RIGHT_ARROW_KEYPRESS) delete this._editSessionFromKeyPress
    
    var rowNum = this.getEditRow(),
        colNum = this.getEditCol();
    // If we were passed a new value, store it as an editValue
    // (Otherwise the next call to getEditValue() / getEditValues() 
    //  [changeEditCell / saveAndHideEditor] will pick up the current edit value
    //  from the form item)
    if (arguments.length >= 2) {
        this.setEditValue(rowNum, colNum, newValue);
    }
    
	//this.logInfo("cellEditEnd: editValues: " + this.echo(this.getEditValues(rowNum)) + 
	//             ", old values: " + this.echo(this.getRecord(rowNum)), "gridEdit");

    
    var fieldName = this.getFieldName(colNum),
        shouldCancelEdit = this.shouldCancelEdit(rowNum, colNum, editCompletionEvent);
    if (shouldCancelEdit) return this.cancelEditing(editCompletionEvent);

    

	// get the next editCell (if null, we're done with the edit)
    var nextEditCell = this.getNextEditCell(rowNum, colNum, editCompletionEvent);
	// The 'newEditCell' is used by getNextEditCell.  Clear it out now, since we've determined
	// which cell we'll be editing.
    this.clearNewEditCell();
       
	// if we've no next cell to go to, we're done editing
    if (nextEditCell == null) {
    	//>DEBUG
        this.logInfo("cellEditEnd: ending editing, completion event: " + editCompletionEvent,
                     "gridEdit"); //<DEBUG
        this._saveAndHideEditor(editCompletionEvent);
        return;
    }

	// prevent editing of the loading marker.  Can happen with rapid tabbing / shift-tabbing
	// with non-blocking row loading
    if (Array.isLoading(this.getCellRecord(nextEditCell[0], nextEditCell[1]))) {
    	//this.logWarn("prevented edit of loading row at: " + nextEditCell);
        return false;
    }
    this._changeEditCell(editCompletionEvent, rowNum, colNum, nextEditCell[0], nextEditCell[1]);
},


// getUpdatedEditorValue()  
// Retrieves the value from the current edit cell editor item
// NOTE: returns the parsed version [can be saved as a raw value to the record]
getUpdatedEditorValue : function () {
    // If we're not showing an editor return undefined - there is no edit value to save.
    if (!this._editorShowing) return;
        
    var editItem = this._editRowForm.getItem(this.getEditFieldName()),
        editField = this.getEditField(),
        value;
    if (editItem) {

        if (editItem._itemValueIsDirty()) editItem.updateValue();
        value = editItem.getValue();
        return this._parseEditorValue(value, editField,this.getEditRow(), this.getEditCol());

    } else {
        // no edit item, just return the saved value
        return this.getEditDisplayValue(this.getEditRow(), this.getEditCol());
    }
},

// storeUpdatedEditorValue() 
// Retrieves the value from the current edit cell editor item and stores it as an edit value
// for the appropriate row.
storeUpdatedEditorValue : function (suppressChange) {
    if (!this.isDrawn() || !this._editorShowing) return;

    
    var editRow = this.getEditRow(), editCol = this.getEditCol(),

        
        editField = this.getField(editCol),
        editForm = this._editRowForm,
        editItem = this.getEditFormItem(editCol),
        value;
    if (editItem) {
        if (editItem._itemValueIsDirty()) editItem.updateValue();
        value = this._parseEditorValue(editItem.getValue(), 
                                         editField, editRow, editCol);
        this.setEditValue(editRow, editCol, value, true, suppressChange);
    }
},

// Internal handler to fire user-defined editorExit handler functions
_handleEditorExit : function (editCompletionEvent, rowNum, colNum, newValue) {
    var record = this.getCellRecord(rowNum, colNum),
        field = this.getField(colNum),
        editFieldName = this.getEditorName(rowNum, field),
        returnVal = true;
    
    var item = this._editRowForm.getItem(editFieldName);
    //>PopUpTextAreaItem         If this is a pop-up text area, ensure the T.A. is hidden.
    if (isc.isA.PopUpTextAreaItem(item)) item.hidePopUp();  //<PopUpTextAreaItem

	// NOTE: field can be null if hiding focused field
    
    if (field && field.editorExit != null) {
        isc.Func.replaceWithMethod(field, "editorExit",
                                     "editCompletionEvent,record,newValue,rowNum,colNum,grid");
        returnVal = 
            (field.editorExit(editCompletionEvent, record, newValue, rowNum, colNum, this) 
             != false);
    }
    if (returnVal && this.editorExit != null) 
        returnVal = this.editorExit(editCompletionEvent, record, newValue, rowNum, colNum) != false;

    return returnVal;
},

// fired when the user leaves a row
_handleRowEditorExit : function (editCompletionEvent, rowNum, newValues) {
    
    var record = this.getRecord(rowNum);
    if (this.rowEditorExit != null) 
        return (this.rowEditorExit(editCompletionEvent, record, newValues, rowNum) != false);
    // In this case there was no rowEditorExit handler defined.
    return true;

},

// Internal handler to fire user-defined editorEnter handler functions
_handleEditorEnter : function (editorItem, rowNum, colNum, value) {
    
    var record = this.getCellRecord(rowNum, colNum),
        fieldName = this.getFieldName(colNum),
        field = this.getField(colNum),
        returnVal = true;
        

    //>PopUpTextAreaItem
    // If this is a pop-up textArea editor, show the pop-up if appropriate
    
    if (isc.isA.PopUpTextAreaItem(editorItem) && editorItem.popUpOnEnter) {
        // pass in the param to put focus into the pop-up
        editorItem.showPopUp(true);
    }   //<PopUpTextAreaItem

    
    if (field && field.editorEnter != null) {
        isc.Func.replaceWithMethod(field, "editorEnter", "record,value,rowNum,colNum,grid");
        returnVal = field.editorEnter(record, value, rowNum, colNum, this) != false;
    }
    if (returnVal && this.editorEnter != null) 
        returnVal = this.editorEnter(record, value, rowNum, colNum) != false;

    return returnVal;
},

_handleRowEditorEnter : function (editorItem, rowNum, editValues) {
    var record = this.getRecord(rowNum);
    if (this.rowEditorEnter != null)
        return this.rowEditorEnter(record, editValues, rowNum) != false;
    return true;
},

_validationEnabled : function () {
    if (!isc.DS) return false;
    var ds = isc.DS.get(this.dataSource);
    return !this.neverValidate &&
                  	
                      !(ds && ds.useLocalValidators != null &&
                        ds.useLocalValidators == false);
},

// These methods determine what action should be taken on cell edit completion

//>	@method     listGrid.shouldSaveOnCellExit() 
//  When a user exits a field within the current row being edited, but does not exit the edit
//  row, should a save be performed?<br>
//  Default behavior is <br>
//  - Never saveCellOnExit if this is a new edit row (has no corresponding record)<br>
//  - return this.saveByCell if defined, otherwise return true if the user is editing 
//    individual cells, false if the entire row is editable (set via the editByCell property).
//
//  @group  editing
//  @visibility internal
//
//  @param  rowNum      (number)    Index of the row being edited
//  @param  colNum      (number)    Index of the column being edited
//  @return (boolean)    true if the value should be saved when moving to a different field within
//                       the edit row.
//  @see saveByCell
//  @see editByCell
//<
shouldSaveOnCellExit : function (rowNum, colNum) {
    if (this.getCellRecord(rowNum, colNum) == null) return false;
    return (this.saveByCell != null ? this.saveByCell : this.editByCell);
},

//>	@method     listGrid.shouldSaveOnRowExit() 
//
//  When a user exits the current edit row, should a save be performed.
//  Always returns true.
//
//  @group  editing
//  @visibility internal
//
//  @param  rowNum      (number)    Index of the row being edited
//  @param  colNum      (number)    Index of the column being edited
//  @param  editCompletionEvent (EditCompletionEvent) what caused the edit completion
//  @return (boolean)    true if the value should be saved when moving to a different field within
//                       the edit row.
//<
shouldSaveOnRowExit : function (rowNum, colNum, editCompletionEvent) {
    return true;
},

//>	@method     listGrid.shouldValidateByCell() 
//
//  When a user exits a field within the current row being edited, but does not exit the edit
//  row, should validation be performed.<br>
//  Default behavior is to return this.validateByCell if defined, otherwise return true if
//  the user is editing indivdual cells, false if the entire row is editable (set via the
//  editByCell property).<br>
//  Note that all edit-validation will be suppressed if listGrid.neverValidate is set to
//  true.
//
//  @group gridValidation 
//  @visibility internal
//
//  @param  rowNum      (number)    Index of the row being edited
//  @param  colNum      (number)    Index of the column being edited
//  @return (boolean)    true if validation should be performed when moving to a different field 
//                       within the edit row.
//  @see listGrid.validateByCell
//  @see listGrid.autoValidate
//<
shouldValidateByCell : function (rowNum, colNum, editCompletionEvent) {
    var field = this.getField(colNum);
    if (field && field.validateByCell != null) return field.validateByCell;
    
    return (this.validateByCell != null ? this.validateByCell : this.editByCell);
},


//>	@method     listGrid.shouldValidateByRow() 
// Should we perform validation on the current edit row when the user navigates away from it,
// even if the row is not being saved (due to +link{listGrid.autoSaveEdits} being false)?
// Default implementation returns +link{listGrid.autoValidate}.
//  @param  rowNum      (number)    Index of the row being edited
//  @param  colNum      (number)    Index of the column being edited
//  @return (boolean)    true if validation should be performed when moving to a different field 
// @group gridValidation
// @see listGrid.autoValidate
// @see listGrid.autoSaveEdits
//<
shouldValidateByRow : function (rowNum, colNum, editCompletionEvent) {
    // Note: Method will only be called if _validationEnabled() returned true, so we
    // don't need to check this.neverValidate.
    return this.autoValidate;
},

//>	@method     listGrid.shouldCancelEdit() 
//
//  On completion of an edit via some editCompletionEvent, should the edited values be discarded,
//  rather than being saved.
//  Default implementation returns true if the editCompletionEvent was a keypress on the escape
//  key and the escapeKeyEditAction was set to cancel.
//  Override for different cancellation behavior.
//
//  @group  editing
//  @visibility internal
//
//  @param  rowNum      (number)    Index of the row being edited
//  @param  colNum      (number)    Index of the column being edited
//  @param  editCompletionEvent (EditCompletionEvent)  Event that completed the edit
//  @return (boolean)    true if the save should be cancelled
//  @see getNextEditCell()
//<
shouldCancelEdit : function (rowNum, colNum, editCompletionEvent) {
    if (editCompletionEvent == isc.ListGrid.ESCAPE_KEYPRESS) {
        var field = this.getField(colNum), 
            action = field.escapeKeyEditAction || this.escapeKeyEditAction;
        if (action == "cancel") return true;
    }
    return false;
},

// Also see 'getNextEditCell()'


// --  Methods to perform the mechanics of saving / validation / etc.

//>	@method     listGrid._killEdit() 
//
//  Complete editing by hiding the cell editor, and clearing out any edit information.
//  Public API for this is 'cancelEditing()'
//
//  @group  editing
//  @visibility internal
//
//  @param  editingFlowID   (number)    Unique ID for the edit flow to quit.  We take this parameter
//                                      to avoid this method from attempting to quit an edit-flow
//                                      that has already ended (likely to cause a valid new edit-flow
//                                      to close.
//  @param  editCompoletionEvent (EditCompletionEvent) Event that caused the cancellation
//                                      of the edit.
//  @param  [confirmed]   (boolean)     If confirmCancelEditing is true, when the user 
//                                      dismisses the confirmation dialog we call this method
//                                      back, with this additional parameter indicating
//                                      yes or no click.
//  @see cancelEditing()
//<
_killEdit : function (editingFlowID, editCompletionEvent, confirmed) {
    if (this._editingFlowID != editingFlowID) return;

    if (this.confirmCancelEditing) {
        if (confirmed == null) {
            var callback = 
                    this.getID() + "._killEdit('" + editingFlowID + "','" 
                                                 + editCompletionEvent + "',value);";
                                                 
            isc.ask(this.cancelEditingConfirmationMessage, callback);
            
            var yesButton = isc.Dialog.Warn.toolbar.getButton(0);
            if (yesButton.isDrawn()) yesButton.focus()
            else isc.Timer.setTimeout({target:yesButton, methodName:"focus"}, 0);
            return;
        } else if (confirmed == false) return;
    }
    
    // If editorExit / rowEditorExit returns false, don't allow the cancellation
    var rowNum = this.getEditRow(), colNum = this.getEditCol(), 
        newVal = this.getUpdatedEditorValue(),
        newVals = this.getEditValues(rowNum, colNum);
    if (!this._handleEditorExit(editCompletionEvent, rowNum, colNum, newVal) ||
        !this._handleRowEditorExit(editCompletionEvent, rowNum, newVals))
    {
        return;
    }

    // We're going to kill the temp-edit value, but we don't want to update any visible form
    // items' values since we're then going to hide the form items anyway.
    // Therefore track any cells that have no form item showing, but DO have edit values, so
    // we can refresh them individually.
    var mustRedraw,
        cellsToRedraw = [],
        editRowNum = this._editRowNum,
        editValues = this.getEditValues(editRowNum, colNum),
        // if undrawn set start/end col such that we don't attempt to redraw any cells
        drawnArea = this.body ? this.body.getDrawArea() : [null,null,1,0],
        startCol = drawnArea[2], endCol = drawnArea[3],
        undef;
    if (editValues != null) {
        // if the user is editing a new record (no underlying data value) we have to redraw
        // the whole body as the total length will change by discarding the edit
        if (this.isNewEditRecord(editRowNum, colNum)) {
            mustRedraw = true;
        } else {
            for (var i = startCol; i <= endCol; i++) {
                if ( editValues[this.getFieldName(i)] !== undef &&
                     ((this.editByCell && this._editColNum != i) ||
                      !this.canEditCell(editRowNum, i)) )
                {
                    cellsToRedraw.add(i);
                }
            }
        }
        // Kill the temporary edit values for the row (passing in the additional parameter to avoid
        // refreshing the effected cells) 	     
        this._clearEditValues(this._editRowNum, colNum, true);
    }
    
    if (this.body) {
        // hide the editor and put focus back in the body
        this.hideInlineEditor(true);
        if (this.isDrawn()) {
            if (mustRedraw) this.body.markForRedraw("clearing extra edit row");
            else {
                for (var i = 0 ; i < cellsToRedraw.length; i++) {
                    this.refreshCell(editRowNum, cellsToRedraw[i]);
                }
            }
        }
    }
},

isNewEditRecord : function (rowNum) {
    var editData = this.getEditSession(rowNum);
    return editData && editData._newRecord
},

//>	@method     listGrid.endEditing() 
//
// Complete the current edit by storing the value and hiding the inline editor. Note that
// if +link{ListGrid.autoSaveEdits} is true, the value will be saved to the server. 
//
//  @group  editing
//  @visibility external
//  @see startEditing()
//<
endEditing : function () {
    if (this.getEditRow() != null) this._saveAndHideEditor(isc.ListGrid.PROGRAMMATIC);
},

// Called from cellEditEnd when the user completes and edit with an enter keypress / click 
// outside saves the values locally and hides the editor. If autoSaveEdits is true, it will 
// also actually save the outstanding set of edits.

_saveAndHideEditor : function (editCompletionEvent) {
    var rowNum = this.getEditRow(), 
        colNum = this.getEditCol(), 
        // Note getEditValue() will pick up the updated value from the form (and store in
        // this.editValues)
        newValue = this.getEditValue(rowNum, colNum),
        newValues = this.getEditValues(rowNum, colNum);

    // If editorExit or rowEditorExit returns false, don't save and quit.
    if (!this._handleEditorExit(editCompletionEvent, rowNum, colNum, newValue) ||
        !this._handleRowEditorExit(editCompletionEvent, rowNum, newValues)) return;
        
    // Closing the editor: If waitForSave is false we will kick off the save and then close
    // the editor without waiting to see if the save completed successfully.
    // If waitForSave is true - we will pass a callback into the saveEdits method that will
    // close the editor when the save returns.
    // We'll use the "success" parameter to determine whether a validation error occurred
    // on the attempted save. If so, we'll look at this.stopOnErrors to determine whether
    // the navigation should continue
    var waitForSave = (this.autoSaveEdits && this.shouldWaitForSave()),
        stopOnErrors = (this.autoSaveEdits && this.stopOnErrors),
        saveCallback;
        
	// It is possible that the current edit flow will have been completed, and another begun when 
	// the callback function fires for this save (true for any saveEdits call).
	// If this is the case we want to no-op, rather than close the new edit flow.
	// Note - we fire this in the scope of the ListGrid via 'apply'
    if (waitForSave) saveCallback = "if((success||!this.stopOnErrors)&&" +
                                        "(this._editingFlowID==" + this._editingFlowID + "))" +
                                            "this.hideInlineEditor(true);";

    
    var cancelling = editCompletionEvent == isc.ListGrid.ESCAPE_KEYPRESS;
    if (!cancelling && this.autoSaveEdits) {
        this.saveEdits(editCompletionEvent, saveCallback);
    } else {
    
    	// update the locally stored edit info with the new value for the appropriate field
	    // Note - this will fire the 'editorChange()' handler if the value has changed.
        var fieldName = this.getFieldName(colNum);        
        this.setEditValue(rowNum, colNum, newValue);
        // If auto-validate is true, validate now
        var validateNow = !cancelling && this._validationEnabled() && 
                          (this.shouldValidateByCell(rowNum, colNum, editCompletionEvent) ||
                           this.shouldValidateByRow(rowNum, colNum, editCompletionEvent));
        if (validateNow) {
            var validationFailed;
            if (this.useCellRecords) {
                validationFailed = !this.validateCell(rowNum, colNum);
            } else {
                validationFailed = !this.validateRow(rowNum);
            }
            if (this.stopOnErrors && validationFailed) return false;
        }
        
        // drop empty edit sessions, normally accomplished by saving
        
        if (!this.rowHasChanges(rowNum, false)) {
            this.logInfo("editor hiding at " + [rowNum,colNum] + 
                         ", no actual changes, dropping editSession", "gridEdit");
            // Don't hang onto the empty edit values for the row
            this._clearEditValues(rowNum, colNum); 
    	}
    }

	// If we not blocking interaction during save, we want to hide the inline editor here.
	// However, we _killEdit to clear our editValues only after saving, since if there are
	// validation errors, etc. we may yet require the editValues
    if (!waitForSave) this.hideInlineEditor(true);
},

//>	@method     listGrid.saveAndEditNewCell() 
//
//  Save the current edit, and start editing another cell (may be in another row).
//
//  @group  editing
//  @visibility internal
//
//  @param  newRowNum   (number)    Index of new row to edit.
//  @param  newColNum   (number)    Index of new column to edit.
//  @param  editCompletionEvent (EditCompletionEvent)  How was the edit completed?
//  @see editNewCell()
//<

saveAndEditNewCell : function (newRowNum, newColNum, editCompletionEvent) {
    if (editCompletionEvent == null) editCompletionEvent = isc.ListGrid.PROGRAMMATIC;
    
    this._saveAndStartEditing(newRowNum, newColNum, editCompletionEvent);

},

// _saveAndStartEditing.  Saves the current edit, and starts editing the new cell passed in
_saveAndStartEditing : function (newRowNum, newColNum, editCompletionEvent) {
    
    var waitForSave = this.shouldWaitForSave(),
        saveCallback;
    if (waitForSave) {
        saveCallback = "if((success||!this.stopOnErrors)&&" +
                         "(this._editingFlowID==" + this._editingFlowID + "))" +
                          "this._startEditing(" + newRowNum + "," + newColNum + ");";
    }
    
    this.saveEdits(editCompletionEvent, saveCallback);
    if (!waitForSave) {
        this._startEditing(newRowNum, newColNum);
    }

},


// Internal helper method to save the current cell and move to the next one in some direction.
_saveAndEditNextCell : function (direction, stepThroughCells) {
    var rowNum = this.getEditRow(), colNum = this.getEditCol(),
        editCompletionEvent = isc.ListGrid.PROGRAMMATIC,
        
        nextEditCell = this.findNextEditCell(rowNum, colNum, direction, stepThroughCells, false);

    this._saveAndStartEditing(nextEditCell[0], nextEditCell[1], editCompletionEvent);        
},

//>	@method     listGrid.saveAndEditNextCell() 
//
//  Save the current edit, and edit the next editable cell, found by stepping through each field
//  in the current row (and possibly subsequent rows, depending on this.rowEndEditAction).
//
//  @group  editing
//  @visibility internal
//<
saveAndEditNextCell : function () {
    this._saveAndEditNextCell(1, true);
},

//>	@method     listGrid.saveAndEditPreviousCell() 
//
//  Save the current edit, and edit the previous editable cell, found by stepping through each field
//  in the current row (and possibly subsequent rows, depending on this.rowEndEditAction).
//
//  @group  editing
//  @visibility internal
//<
saveAndEditPreviousCell : function () {
    this._saveAndEditNextCell(-1, true);
},

//>	@method     listGrid.saveAndEditNextRow() 
//
//  Save the current edit, and edit the same field in the next editable row.
//
//  @group  editing
//  @visibility internal
//<
saveAndEditNextRow : function () {
    this._saveAndEditNextCell(1, false);
},

//>	@method     listGrid.saveAndEditPreviousRow() 
//
//  Save the current edit, and edit the same field in the previous editable row.
//
//  @group  editing
//  @visibility internal
//<
saveAndEditPreviousRow : function () {
    this._saveAndEditNextCell(-1, false);
},

// Editing Navigation: finding next cell or record
// --------------------------------------------------------------------------------------------

//>	@method     listGrid.getNextEditCell()
//
//  Given a current edit cell, and an edit completion event, return the next cell to be edited,
//  or null if there is no next cell to edit.<br>
//  Default implementation:<ul>
//  <li>return null (editing complete), if the edit completion event was an enter keypress, 
//      a click outside the editor, or an escape keypress</li>
//  <li>return the result of 'getNewEditCell()' if the edit completion event was 
//      ListGrid.EDIT_FIELD_CHANGE or PROGRAMMATIC.  This relies on 'setNewEditCell()' having
//      been called earlier to specify the next cell to edit.</li>
//  <li>return the next editable cell in the same column moving up or down rows if the edit 
//      completion event was an up or down arrow keypress<li>
//  <li>return the next editable cell in the same row, or if there is none, and 
//      this.rowEndEditAction is "next", in subsequent rows, if the edit was
//      completed with a Tab or Shift+Tab keypress.</li>
//  </ul>
//
//  @group  editing
//
//  @param  rowNum      (number)    Index of record edited
//  @param  colNum      (number)    Index of field edited
//  @param  editCompletionEvent (EditCompletionEvent)    Edit completine event constant
//  @return (Array)  2 element array specifying next editable rowNum, colNum.  Will
//                   return null if the edit should be completed without navigating to
//                   another cell.
//  @visibility internal
//<

getNextEditCell : function (rowNum, colNum, editCompletionEvent) {
    
    switch (editCompletionEvent) {
        case isc.ListGrid.CLICK_OUTSIDE :
    	// unlikely to see this case, since this is a 'cancellation' by default, but treat as
    	// not attempting to navigate elsewhere
        case isc.ListGrid.ESCAPE_KEYPRESS :
            return null; 

        case isc.ListGrid.ENTER_KEYPRESS :
            var field = this.getField(colNum),          
                navStyle = field.enterKeyEditAction || this.enterKeyEditAction;
            if (navStyle == "done") return null;
            else if (navStyle == "nextCell") 
                return this.findNextEditCell(rowNum, colNum, 1, true, false);
            else if (navStyle == "nextRow") 
                return this.findNextEditCell(rowNum, colNum, 1, false, false);
            else if (navStyle == "nextRowStart") {
                var listEndAction = this.listEndEditAction;
                if (rowNum+1 < this.getTotalRows() || listEndAction == "next") {
                	// either there are more record or we're allowed to create new records by
                	// navigating off the end of the list, proceed
                    return this.findNextEditCell(rowNum +1, 0, 1, true, true);
                } else {
                	// we've hit Enter on the last row, and we're not allowed to create new
                	// rows.
                	// if we're supposed to "stop", we should return the current coordinates,
                	// so we can't call findNextEditCell with rowNum+1 since it wouldn't know
                	// the current coordinates.
                    if (listEndAction == "stop") return [rowNum, colNum];
                    return null; // "done"
                }
            }
            
        case isc.ListGrid.EDIT_FIELD_CHANGE :
        case isc.ListGrid.PROGRAMMATIC :
    	// In this case we have an explicit cell to move to - should have been saved as
    	// 'newEditCell'
            return this.getNewEditCell();
        
        case isc.ListGrid.UP_ARROW_KEYPRESS :
            return this.findNextEditCell(rowNum, colNum, -1, false, false);
            
        case isc.ListGrid.DOWN_ARROW_KEYPRESS :
            return this.findNextEditCell(rowNum, colNum, 1, false, false);

        case isc.ListGrid.TAB_KEYPRESS :
        case isc.ListGrid.RIGHT_ARROW_KEYPRESS :
            var field = this.getField(colNum);
            if (field.nextTabColNum != null) {
                return this.findNextEditCell(rowNum +1, field.nextTabColNum, 1, true, true);
            } else
                return this.findNextEditCell(rowNum, colNum, 1, true, false);
        case isc.ListGrid.SHIFT_TAB_KEYPRESS :
        case isc.ListGrid.LEFT_ARROW_KEYPRESS :        
            var field = this.getField(colNum)
            if (field.previousTabColNum != null) {
                return this.findNextEditCell(rowNum -1, field.previousTabColNum, -1, true, true);
            } else
                return this.findNextEditCell(rowNum, colNum, -1, true, false);
    }
    
    this.logWarn("getNextEditCell(): Passed unrecognized editCompletionEvent type:" + 
                editCompletionEvent + ", returning null");
    return null;
},

//>	@method     listGrid.findNextEditCell()
//
//  Method to find the next editable cell given a starting row/col, and a direction, 
//  either iterating through fields within each row, or checking the same field in each row.//
//  @group  editing
//
//  @param  rowNum      (number)    Index of record edited
//  @param  colNum      (number)    Index of field edited
//  @param  direction   (number)    +1 if searching forward for the next edit cell, -1 if
//                                  searching backwards
//  @param  stepThroughFields   (boolean)   true if we should check every field in each row -
//                                          false if we should check the same field in each
//                                          row.
//  @param  [checkStartingCell] (boolean)   Should we check whether the cell passed in is 
//                                          editable? Default behavior WILL check that cell - 
//                                          pass false to suppress checking that cell.
//  @return (Array)  2 element array specifying next editable rowNum, colNum.  Will
//                   return null if this method fails to find an editable cell.
//  @visibility internal
//<
// @param [checkPastListEnd]    Optional, internal parameter forces this method to check beyond
// the end of the list if necessary, even if this.listEndEditAction is not "next"
// @param [dontCheckPastRowEnd] Optional, internal parameter suppresses checking beyond the end
// of the row. We use this in handleEditEvent(click) to avoid iterating through the entire grid
// if there's no editable cell in a row!


findNextEditCell : function (rowNum, colNum, direction, stepThroughFields, checkStartingCell,
                                checkPastListEnd, dontCheckPastRowEnd) {

    var newRow = rowNum,
        newCol = colNum,
        lastRow,
        totalCols = this.getFields().length;
        
	// We want to look at every row up until the last drawn row.
	// IF listEditAction is "next", we will also check one row beyond the last drawn record
	// - this allows the user to tab beyond the end of the list and create a new edit row.
	// If we are passed a rowNum greater than the last drawn row, we will check every field
	// within that row (even if it's after tha current last drawn row).  This allows the
	// programmatic editing of rows beyond the end of the list via 'startEditingNew()'.
	// In cases where there is no record associated with a row, canEditCell() checks 
	// editability based on the field definitions.
	
    lastRow = (dontCheckPastRowEnd ? newRow :
                (this.listEndEditAction == "next" || checkPastListEnd) ? this.getTotalRows() 
                                                                       : this.getTotalRows() -1);
    if (newRow > this.getTotalRows()) lastRow = newRow;
    
    // Note: If we have an editable field with a non focusable editor, always skip it.
    // If editing by row this is usually going to be pretty intuitive - the focus jumps over
    // the non editable field. If editing by cell it means that editor actually won't show up unless
    // the user double-clicks the cell (which seems acceptable since if you tabbed into it you'd
    // be unable to tab out again anyway).
    
	// check whether we can edit at the starting coordinates, unless that is being
	// explicitly suppressed
	// Note: The cell passed in may be off the end of the list or past the end of the fields,
	//       since we blindly add 1 to a newRow / colNum in some cases.
    if (  (checkStartingCell != false || direction == 0) && 
          newRow <= lastRow && newRow >=0 && newCol < totalCols && newCol >=0 &&
          this.canEditCell(newRow, newCol) && this._canFocusInEditor(newRow, newCol)
        ) 
    {
        return [newRow, newCol];
    }

	// direction will be either -1 or 1.
	// check for other values is unnecessary so long as this method remains internal, but
	// check for zero anyway, since that would cause real problems!
    if (direction == 0) return null;
    
    var canEditStartingCell = this.canEditCell(newRow, newCol) && 
                              this._canFocusInEditor(newRow, newCol),
        firstRow = dontCheckPastRowEnd ? newRow : 0;

    if (stepThroughFields) {
        var style = this.rowEndEditAction;
        
        while (newRow < (lastRow+1) && newRow >= firstRow) {

            newCol += direction;
        	// If we've looped through the editable cells for this row, and are back at the
        	// initial col return the starting row if it's editable.
            if (style == "same" && colNum == newCol) {
                return canEditStartingCell ? [rowNum, colNum] : null;
            }

        	// if we hit the end of the row, check the rowEndEditAction to determine whether
        	// to move to the next record, etc.
            if (newCol < 0 || newCol >= totalCols) {
                if (style == "done") return null;
                if (style == "stop") return (canEditStartingCell ? [rowNum, colNum] : null)
            	// if we're looping through the same row, set the newCol to be off the end
            	// since we add / subtract one before checking for canEdit()
                else {
                    newCol = (direction > 0 ? -1 : totalCols);
                    if (style == "next") newRow += direction;
                }
            } else if (this.canEditCell(newRow,newCol) && 
                        this._canFocusInEditor(newRow, newCol)) 
            {         
                return [newRow, newCol];
            }
        }
    	// reached the end of the list without finding an editable cell.
    	// If the end action is stop, or we're trying to move past the start of the list and
        // the end action is 'next', start editing the same cell again 
        // - otherwise return null to stop editing
        if (this.listEndEditAction == "stop" ||
            (this.listEndEditAction == "next" && newRow < firstRow)) 
        {
            if (canEditStartingCell) return [rowNum, colNum];
            else return null;
        } else {
            return null;
        }
        
     } else {
        newRow += direction
        while (newRow >= firstRow && newRow <= lastRow) {
            if (this.canEditCell(newRow, newCol) && this._canFocusInEditor(newRow, newCol)) {
                return [newRow, newCol];
            }
            newRow += direction;
        }
    	// reached the end of the list without finding an editable cell.
    	// If listEndEditAction is stop, or "next" - and we're trying to navigate past the
        // beginning of the list, return the cell passed in - otherwise return null to stop
    	// editing
        if (this.listEndEditAction == "stop" || 
            (this.listEndEditAction == "next" && newRow < firstRow)) 
        {
            return canEditStartingCell ? [rowNum, colNum] : null;
        }
        return null;
     }
},

_canFocusInEditor : function (rowNum, colNum) {
    
    var fieldName = this.getFieldName(colNum),
        editForm = this._editRowForm,
        editItem = editForm ? editForm.getItem(fieldName) : null;
    if (editItem) return editItem._canFocus();
    
    var field = this.getField(fieldName);
    if (field.canFocus != null) return field.canFocus;
    var editorType = this.getEditorType(field, this.getEditedRecord(rowNum));
    
    // call getItemClassName on FormItemFactory to actually get a SmartClient class from
    // the editor type (required to get SelectItem from SelectOtherItem, etc)
    editorType = isc.FormItemFactory.getItemClassName(field, editorType, null, true);
    
    // Resolve to an actual class
    var editorClass = editorType = isc.FormItemFactory.getItemClass(editorType);
        
    // This could potentially be broken by an override to _canFocus() which required looking
    // at a live instance.
    
    return editorClass ? editorClass.getPrototype()._canFocus() : false;
},

//>	@method     listGrid.setNewEditCell() (I)
//
//  Internal method to record an explicit 'new edit cell'.  This can be retrieved (as an array)
//  via getNewEditCell();
//  Currently used when focus is put into a new cell by clicking in a field in a visible
//  (row-style) edit form, and by editfield.
//
//  @group  editing
//  @visibility internal
//
//  @param  rowNum      (number)    Index of the new row to edit
//  @param  colNum      (number)    Index of new field to edit
//<
setNewEditCell : function (rowNum, colNum) {
    this._newEditCell = [rowNum, colNum];
},

//>	@method     listGrid.getNewEditCell() (I)
//
//  Internal method to retrieve the 'new edit cell', previously stored by setNewEditCell.
//
//  @group  editing
//  @visibility internal
//
//  @return (array)    2-element array indicating the stored rowNum and coNum
//<
getNewEditCell : function () {
    if (this.canEditCell(this._newEditCell[0], this._newEditCell[1])) return this._newEditCell;
    return null;
},

//>	@method     listGrid.clearNewEditCell() (I)
//
//  Internal method to clear the 'new edit cell' stored by setNewEditCell.
//
//  @group  editing
//  @visibility internal
//<
clearNewEditCell : function () {
    this._newEditCell = null;
},


//>	@method     listGrid.discardAllEdits() (A)
//
// Cancel outstanding edits, discarding edit values, and hiding editors for the record[s] passed
// in if appropriate.
// If no rows are passed in all outstanding edit values will be dropped.
// 
// @param  [rows] (array of numbers) allows you to specify which row(s) to drop edits for
// @param   [dontHideEditor]    (boolean)   By default this method will hide the editor if
//                              it is currently showing for any row in the grid. Passing in
//                              this parameter will leave the editor visible (and just reset
//                              the edit values underneath the editor).
// @visibility external
// @group editing
//<
discardAllEdits : function (rows, dontHideEditor) {
    
    if (rows == null) rows = this.getAllEditRows(true);
    else {
        // Convert numeric rows to edit-values IDs
        for (var i = 0; i < rows.length; i++) {
            if (isc.isA.Array(rows[i])) rows[i] = this.getEditValuesID(rows[i][0], rows[i][1]);
            if (isc.isA.Number(rows[i])) rows[i] = this.getEditValuesID(rows[i]);
        }
    }
    if (rows == null) return;
    
    // call discardEdits()
    // Note that we're passing in an editValuesID rather than a rowNum / colNum here 
    for (var i = 0; i < rows.length; i++) this.discardEdits(rows[i], null, dontHideEditor);
},

//>	@method listGrid.discardEdits() (A)
//
// Cancel outstanding edits for the specified rows, discarding edit values, and hiding editors 
// if appropriate.<br>
// Note that if this method is called on a new edit row (created via 
// +link{listGrid.startEditingNew()} for example), which has not yet been saved, this method
// will remove the row entirely.
// 
// @param  rowNum (number) Row to cancel
// @param colNum (number) Column to cancel. Note that this parameter is ignored in ListGrids but
//                        may be required in subclasses of ListGrid where each cell represents
//                        one record in the data set (EG CubeGrid)
// @param   [dontHideEditor]    (boolean)   By default this method will hide the editor if
//                              it is currently showing for the row in question. Passing in
//                              this parameter will leave the editor visible (and just reset
//                              the edit values underneath the editor).
// @group  editing
// @visibility external
//<
discardEdits : function (rowNum, colNum, dontHideEditor) {
    if (rowNum == null) return;
    // if passed an ID rather than a rowNum, figure out the rowNum, so we can 
    // easily see if its the current edit row.
    var ID;
    if (isc.isA.Number(rowNum)) {
        ID = this.getEditValuesID(rowNum, colNum);
    } else {
        ID = rowNum;
        rowNum = this.getEditSessionRowNum(ID, colNum);
    }
    
    if (!dontHideEditor && this._editorShowing && this.getEditRow() == rowNum) { 
        this.cancelEditing();
    } else {
        
        // If the user is currently editing this row ensure the current value in the edit form
        // item is stored in this.editValues before clearing it, (so that the focused item is
        // refreshed with the underlying record value)
        if (this._editorShowing) {
            if (this.getEditRow() == rowNum) {
                // Suppress change - we're about to clear the value anyway!
                this.storeUpdatedEditorValue(true);
            }
        }    
    }
    this._clearEditValues(ID, colNum);
},

// Saving Inline Edits
// --------------------------------------------------------------------------------------------


//>	@method listGrid.saveEdits() (A)
//
// Validates and saves edits within the row currently being edited (or another row with unsaved
// edits, if indicated).
// <P>
// This method can be called to manually trigger saves if the default mechanisms of
// +link{saveByCell,cell by cell} or row by row saving are not suitable.  
// <P>
// The 'callback' parameter provides a notification when the save attempt completes, which is
// likely to be asynchronous for databound grids.  Cases under which the callback will fire are:
// <ul><li>Save completed successfully</li>
// <li>No changes to the edited row, so save not required</li>
// <li>Validation failure occurred on the client or on the server</li></ul>
// Note that if this method was unable to determine the row to be saved, the callback will NOT
// fire - in this case, the method is a no-op.
// <P>
// Other, standard callbacks such as +link{editComplete()}, +link{editFailed()} and 
// +link{cellChanged()} will fire normally.
// <P>
// Note this method does not hide the inline editors if they are showing - to explicitly save 
// and end editing, use the method 'endEditing()'
//
//  @group  editing
//  @visibility external
//
//  @param  [editCompletionEvent] (EditCompletionEvent) Event used to complete cell editing.
//          Optional, and defaults to <code>"programmatic"</code>.  Can be used by the 
//          <code>callback</code> method to perform custom actions such as navigation when the 
//          save completes.
//  @param  [callback]    (Callback)  Callback to fire on completion of the saving process.
//                                    If no edits were made or client-side validation fails 
//                                    the callback will be fired synchronously at the end of this
//                                    method.<br>
//                                    Takes the following parameters:
//                                    <br>- rowNum <i>(Number) edited row number</i>
//                                    <br>- colNum <i>(Number) edited column number</i>
//                                    <br>- editCompletionEvent <i>(EditCompletionEvent) event 
//                                      passed in (defaults to <code>"programmatic"</code>)</i>
//                                    <br>- success <i>(boolean) false if the save was unable to
//                                      complete due to a validation failure or server-side 
//                                      error.</i>
//  @param  [rowNum] (number) Which row should be saved. If unspecified the current edit row
//                            is saved by default. Note that if there is no current edit row 
//                            this method will no op.
//  @see    endEditing()
//<
// Last parameter 'validateOnly' is used internally to avoid actually saving if validation
// succeeds - just return true to indicate success

saveEdits : function (editCompletionEvent, callback, rowNum, colNum, validateOnly) {
    
	// Since this is being exposed as a public method (allowing saving while leaving
	// the editor visible), default to a "PROGRAMMATIC" editCompletionEvent.
    if (editCompletionEvent == null) editCompletionEvent = isc.ListGrid.PROGRAMMATIC;
             
    if (rowNum == null) {
        rowNum = this.getEditRow()
        colNum = this.getEditCol();
    } else if (colNum == null) {
        // this will not apply to cubeGrid editing
        
        var colNum = (rowNum == this.getEditRow() ? this.getEditCol() : this.getRowEditColNum(rowNum));
    } 

	// clicking rapidly from one row to another when the editEvent is 'CLICK', and editOnFocus
	// is true can sometimes cause this method to get fired before the editRow / col has been
	// set up.  Just bail if this happens.
    if (rowNum == null) return false;

	// If we're actually showing the editor, getEditValues() will ensure any changes are 
    // saved in the editValues object for the row.
    var newValues = this.getEditValues(rowNum, colNum),
        record = this.getCellRecord(rowNum, colNum),
        editValuesID = this.getEditValuesID(rowNum, colNum);

    // don't pass the actual record as oldValues; allows downstream code to modify it freely
    var oldValues;
    if (record != null && !Array.isLoading(record)) {
        if (isc.isA.Tree(this.data)) {
            
            oldValues = this.data.getCleanNodeData(record, false);   
        } else {
            oldValues = isc.addProperties({}, record);
        }
        
        if (oldValues && this.selection) delete oldValues[this.selection.selectionProperty];
    }
	// Assemble the edit information into a single object to be passed to callback
	// methods.  
	// We use this object if we have to call editCompleteCallback or editFailedCallback
	// directly from this method - otherwise we'll re-create this object in 
	// saveEditedValues() / updateRecordsReply()
    var editInfo = {
        	// Note: rowNum / colNum are basically available for callbacks, and for special 
        	// handling if a user overrides this method
            rowNum:rowNum,
            colNum:colNum,
            oldValues:oldValues,
            editValuesID:editValuesID,
            values:newValues, 
            editCompletionEvent:editCompletionEvent,
            newRecord:(rowNum > this.data.getLength())
    };
    
	//>DEBUG
    if (this.logIsDebugEnabled("gridEdit")) {
        this.logDebug("change detection: newValues: " + this.echo(newValues) + 
                      ", oldValues: " + this.echo(oldValues), "gridEdit");
    } //<DEBUG

    // perform validation on the edited row before saving
    // NOTE: we always save, and validate the whole row, even if saveByCell is true
    // as saveByCell really governs when the save is kicked off rather than what is
    // to be saved.
    if (this._validationEnabled()) {
        var validationFailed;
        if (this.useCellRecords) {
            validationFailed = !this.validateCell(rowNum, colNum);
        } else {
            validationFailed = !this.validateRow(rowNum);
        }
        if (validationFailed) {
        	if (!validateOnly) this._editFailedCallback(editInfo, callback);
            return false;
        }
    }
    // If we're only validating return true here to indicate that validation passed.
    if (validateOnly) return true;

    
    if (!this.recordHasChanges(rowNum, colNum, false)) {
        this.logInfo("saveEdits: no actual change, not saving", "gridEdit");
        // Don't hang onto the empty edit values for the row
        this._clearEditValues(editValuesID, colNum);        
    	// fire the saveCallback to finish flow (eg move to next cell, end editing..)
        
        this._fireSaveCallback(callback, rowNum, colNum, editCompletionEvent, true);
        return;
    }

    // get refreshed editValues since validation converts values to declared types, and we need
    // to store with correct types
    newValues = this._getEditValues(rowNum, colNum);

	//>DEBUG
    this.logInfo("Saving newValues '" + isc.echoAll(newValues) + "'", "gridEdit");
	//<DEBUG
    
	// remember this set of editValues as the "last submitted" for this row - this is used
	// for change detection while any save is pending.
    
    this.rememberSubmittedEditValues(rowNum, colNum);

	// NOTE: dupe the new values because they can be the live "editValues" for a row, and the
	// save implementation might integrate them directly into the data set with no copy
    newValues = isc.addProperties({}, newValues);

	// call the 'saveEditedValues' method to actually perform the save.
    this.saveEditedValues(rowNum, colNum, newValues, oldValues, 
                          editValuesID, editCompletionEvent, callback);
        
	// return true to indicate we're (attempting to) save the value
	// (If we're saving to the server, this does not indicate success, the server could still
	// give validation errors back to the asynchronous callback function - don't fire
	// _editCompleteCallback until we know the edit either went through or failed)
    return true;
},

//> @method listGrid.rowHasChanges()
// If this listGrid can be edited, this method will return true if the row passed in has been
// edited, but the edits have not yet been saved to the ListGrid's data object.
// @param rowNum (number) index of row to check for changes
// @return (boolean) true if the row has changes.
// @visibility external
// @group editing
//<


rowHasChanges : function (rowNum, checkEditor) {
    // call cellHasChanges
    // Ignore the 2nd parameter - this method is not supported in 1 record/cell editing
    // pattern (IE CubeGrid)
    return this.recordHasChanges(rowNum, null, checkEditor);
},

// this one is documented at the CG level where it should be used instead of rowHasChanges
recordHasChanges : function (rowNum, colNum, checkEditor) {

    if (checkEditor == null) checkEditor = true;

    var changes = false,
        newValues = (checkEditor ? this.getEditValues(rowNum, colNum) 
                                 : this._getEditValues(rowNum, colNum)),
        oldValues = this.getCellRecord(rowNum, colNum);
    // If there is no record for this row, we're editing a new row.
    // In this case we always want to save the values out.
    if (!oldValues) return true;
    
    // determine whether any changes have occurred by looking at the oldValues.
	// If the record is pending a save, compare the last submitted edit values to the new 
	// values rather than looking at the underlying record values.
	
    var testValues = isc.addProperties({}, oldValues, this.getSubmittedEditValues(rowNum, colNum));
    for (var fieldName in newValues) {
        var oldFieldValue = testValues[fieldName],
            newFieldValue = newValues[fieldName];

        // Use custom comparitor to catch things like Dates where '==' check is not sufficient
        if (!this.fieldValuesAreEqual(this.getField(fieldName), oldFieldValue,newFieldValue)) {
            //this.logWarn("field: " + fieldName + 
            //             " changed from '" + this.echo(oldFieldValue) + 
            //             "' to '" + this.echo(newFieldValue) + "'");
            changes = true;
            break;
        }
    }
    return changes;
},

//> @method listGrid.hasChanges()
// Whether the grid as a whole has any unsaved edits, in any row.
// @return (boolean) returns true of any unsaved edits are present
// @group editing
// @visibility external
//<

hasChanges : function (checkEditor) {
    var editRows = this.getAllEditRows();
    if (editRows != null) {
        for (var i = 0; i < editRows.length; i++) {
            if (this.rowHasChanges(editRows[i], checkEditor)) return true;
        }
    }
    return false;
},

//> @method listGrid.cellHasChanges()
// If this listGrid can be edited, this method will return true if the cell passed in has been
// edited, but the edits have not yet been saved to the ListGrid's data object.
// @param rowNum (number) index of row to check for changes
// @param colNum (number) index of the col to check for changes
// @return (boolean) returns true if the cell has unsaved edits
// @group editing
// @visibility external
//<
// Additional checkEditor param: Should we check for changes in the editor which have not yet been
// stored in our editValues?
// If unset, assumed to be true.
// Useful as when we use this method internally we're typically in the process of writing out
// CSS text, etc for the cell, so if the editor is showing we know the user hasn't had a
// chance to modify it.
cellHasChanges : function (rowNum, colNum, checkEditor) {
                 
    if (rowNum == null || colNum == null) return false;
    var fieldName = isc.isA.String(colNum) ? colNum : this.getEditorName(rowNum, colNum);

    var newValues = (checkEditor ? this.getEditValues(rowNum, colNum) 
                                 : this._getEditValues(rowNum, colNum));
    // No new edit values - therefore no changes
    if (!newValues) return false;

    var savedValues = this.getCellRecord(rowNum, colNum);
    // No record, therefore this is a new row so every cell has a new value
    if (!savedValues) return true;
    
    var undef;
    // Edit values are sparse, so if undef, assume no edit value for the cell
    if (newValues[fieldName] === undef) return false;
 
    // if we have issued a save, don't show edit as pending unless the field was re-edited
    // since the save was kicked off
    var submittedValues = this.getSubmittedEditValues(rowNum, colNum),
        oldValue = submittedValues != null ? 
                        this._firstNonNull(submittedValues[fieldName], savedValues[fieldName])
                                           : savedValues[fieldName];
    var field = this.getField(fieldName);
    return !this.fieldValuesAreEqual(field, oldValue, newValues[fieldName]);
},

//> @method ListGrid.saveAllEdits()
// Save a number of outstanding edits for this ListGrid. If no rows are specifed, all 
// outstanding edits will be saved
// @param [rows] (array of numbers) optionally specify which rows to save
// @param [saveCallback] (callback) If specified this callback will be fired on a successful save
//  of the specified rows. Note that if there are no pending edits to be saved this callback will
//  not fire - you can check for this condition using +link{ListGrid.hasChanges()} or 
//  +link{ListGrid.rowHasChanges()}.
// @group editing
// @visibility external
//<

_saveAllEditsFlow:0,
saveAllEdits : function (rows, saveCallback) {
    
    this._saveAllEditsPendingRows = this._saveAllEditsPendingRows || {};
    this._saveAllEditRowsCallback = this._saveAllEditRowsCallback || {};

    if (rows == null) rows = this.getAllEditCells();
    if (rows == null) return;
    
    // handle being passed just a rowNum
    if (!isc.isAn.Array(rows)) rows = [rows];
    
    // We're going to iterate through our set of edited rows twice - the first time we'll 
    // just perform validation. This allows us to bail if stopOnErrors is true.
    // The second time we iterate through the rows that didn't fail validation only, performing
    // the actual saves.    
    if (this._validationEnabled()) {
        for (var i = 0; i < rows.length; i++) {
            
            // tell saveEdits to just perform validation.
            
            
            var rowNum = isc.isAn.Array(rows[i]) ? rows[i][0] : rows[i],
                colNum = isc.isAn.Array(rows[i]) ? rows[i][1] : null;

            var validated = this.saveEdits(null, null, rowNum, colNum, true);
            if (!validated) {
                if (this.stopOnErrors) return false;
                // don't save rows that failed client validation
                // Also suppress the callback from firing (just clear it) as firing would indicate
                // success
                else {
                    rows[i] = null; // 
                    saveCallback = null;
                }
            }
        }
    }
     
    var shouldQueue = (this.dataSource != null && !this.saveLocally),
        startedQueue = false;
    if (shouldQueue) startedQueue = !isc.RPCManager.startQueue();
    
    // If a callback was provided, we want to fire iff we know every row saved successfully.
    // We handle this by tracking the set of rows committed with each 'saveAllEdits()' call and
    // only firing the callback once we've seen a callback tripped from every row committed.
    // The 'flowNum' logic is required to allow more than one 'saveAllEdits' call to be kicked
    // off before the response from the server without us clobbering info 
    // (and therefore failing to fire the callback) from earlier calls to the method.
    
    var flowNum = this._saveAllEditsFlow ++,
        savingRows = this._saveAllEditsPendingRows[flowNum] = [];

    this._saveAllEditRowsCallback[flowNum] = saveCallback;

    for (var i = 0; i < rows.length; i++) {
    
        // any rows that failed validation have been removed from the array.
        if (rows[i] == null) continue;
        
        var rowNum = rows[i],
            colNum;
        if (isc.isAn.Array(rowNum)) {
            colNum = rowNum[1];
            rowNum = rowNum[0];
        }

        // don't call saveEdits() for an unchanged row, as it will synchronously call the
        // callback and hose tracking of committed changes
        if (!this.recordHasChanges(rowNum,colNum)) continue;
        savingRows[savingRows.length] = rows[i];

        // We only want to fire the 'saveCallback' when we know every row committed has been
        // successfully saved. This is handled by _saveAllEditsRowCallback() 
        var callback = "this._saveAllEditsRowCallback(rowNum," + flowNum + 
                                                        ",colNum,editCompletionEvent,success)";

        this.saveEdits(null, callback, rowNum, colNum);
    }

    // If we're queuing, send the queue now
    if (startedQueue) isc.RPCManager.sendQueue();
   
    // return true to indicate we're (attempting to) save the value unless every save attempt
    // gave a validation error
    // (If we're saving to the server, this does not indicate success, the server could still
	// give validation errors back to the asynchronous callback function - don't fire
    // _editCompleteCallback until we know the edit either went through or failed)
    return true;
},

_saveAllEditsRowCallback : function (rowNum, flowNum, colNum, editCompletionEvent, success) {
    if (!success) {
        // Clean up the stored array of saving rows and the stored callback method.
        // _saveAllEditsRowCallback will successfully recognize if this has occurred and have
        // other (successful) callbacks from this flow no-op.
        delete this._saveAllEditRowsCallback[flowNum];
        delete this._saveAllEditsPendingRows[flowNum];
        return;
    }

    // look up the set of rows that were committed to together
    var savingRows = this._saveAllEditsPendingRows[flowNum];
    // If we have no stored 'saving rows' one of the saves must have failed so we will 
    // never fire our save callback. Just bail in this case.
    if (savingRows == null) return;
    
    // remove the row that we have just successfully saved
    var index, found;
    for (index = 0; index < savingRows.length; index++) {
        var record = savingRows[index];
        if (isc.isA.Number(record)) {
            if (record == rowNum) {
                found = true;
                break;
            }
        } else if (record[0] == rowNum && record[1] == colNum) {
            found = true;
            break;
        }
    }
   
    
    
    savingRows.removeAt(index);

    // if all rows have been successfully saved
    if (savingRows.length == 0) {
        // fire the callback passed into saveAllEdits()
        
        this._fireSaveCallback(this._saveAllEditRowsCallback[flowNum], 
                                rowNum, colNum, editCompletionEvent);
        // clean up:
        delete this._saveAllEditRowsCallback[flowNum];
        delete this._saveAllEditsPendingRows[flowNum];
    }
},
        
// _parseEditorValue - helper method to convert the value currently displayed in an editor into
// the appropriate raw value for saving.
// calls 'parseEditorValue' at the field / grid levels if defined.
_parseEditorValue : function (value, field, rowNum, colNum, record) {
	// allow the record to be passed in as an optional parameter if it happens to be available
	// for the calling function.
    var undef;
    if (record === undef) record = this.getCellRecord(rowNum, colNum);
    
    if (field && field._parseInput != null) {
        value = field._simpleType.parseInput(value, field, this, record);
    } else if (field && field.parseEditorValue != null) {
        isc.Func.replaceWithMethod(field, "parseEditorValue", 
                                            "value,record,rowNum,colNum,grid");
        value = field.parseEditorValue(value, record, rowNum, colNum, this);
    } else if (this.parseEditorValue != null) {
        value = this.parseEditorValue(value, record, rowNum, colNum);
    }
    return value;
    
},

// returns true if edits should not propagate to upstream data sources/sets
shouldSaveLocally : function () {
    return (!this.dataSource || this.saveLocally);
},

//>	@method		listGrid.saveEditedValues()	(A)
//  Save edited values that have passed client-side validation.  Fire the callback when
//  save process completes (with param to indiciate failure if appropriate).
//
//	@group	editing
//
//  @param  rowNum  (number)    index of edited row
//  @param  colNum  (number)    index of edited column
//	@param	newValues   (object)    Values returned by the editor.
//  @param  oldValues   (object)    Values before the edit
//  @param  editCompletionEvent (EditCompletionEvent)  event that caused edit completion
//  @param  [saveCallback]    (Callback)  optional callback function to fire on completion of
//                                        saving process
//  @visibility internal
//<
saveEditedValues : function (rowNum, colNum, newValues, oldValues, 
                             editValuesID, editCompletionEvent, saveCallback) 
{
	// assemble the edit information into a single object, so it can be passed around as part
	// of the context for this event.
	
    
	// NOTE: we use an arbitrary "editValuesID" to track edited values, since newly
	// created records won't have primary keys, and rowNums could change if data is shuffled.
    var editInfo = {
        editValuesID:editValuesID,
        rowNum:rowNum,
        colNum:colNum,
        values:newValues, 
        oldValues:oldValues, 
        editCompletionEvent:editCompletionEvent
    };    
	// At this point we have already validated the change (on the client), so we just need to
	// save changes

	// if there's no dataSource, immediately commit changes locally
    if (this.shouldSaveLocally()) return this._saveLocally(editInfo, saveCallback);

	// otherwise, submit change to server, and wait until it returns without error to commit
    var callback = this.getID() + "._updateRecordReply(dsResponse, dsRequest)",
        request = {
        // allow customizing the operation used to save
        operation : (oldValues == null ? this.addOperation : this.updateOperation) ||
                    this.saveOperation, 
    	// allow customizing the application the operation is performed in
        application : this.application,
        
    	// so we can see validation errors
        willHandleError : true,
    	// show a prompt to block user interaction during save
        showPrompt : this.shouldWaitForSave(),

        // for long transactions, if supported by backend.  NOTE: currently no error codes or
        // frontend UI defined for handling concurrent update error case
        oldValues : oldValues,
        
        // the actual record object that was edited, if present.  Needed for 
        _originalRecord: this.getRecord(rowNum, colNum),

        // Client side context stuff
        clientContext:{
        	// if we were passed an explicit callback, hang onto this
        	// (It will be fired by _updateRecordReply)
            saveCallback : saveCallback,
            
        	// changed values
            newValues : newValues,
            // all other context
            editInfo : editInfo
        },
        
        componentId: this.ID
    };
    // unsort to prevent changed data popping out of viewport
    
    this._unsortOnChange(newValues, oldValues);
   
    // Hang onto a flag noting we're in the process of saving this row
    if (this._savingEdits == null) this._savingEdits = {};
    this._savingEdits[editInfo.editValuesID] = true;

    var ds = isc.DS.get(this.dataSource);

    if (oldValues == null) {
        var newRecord = isc.addProperties({}, oldValues, newValues);
        ds.addData(newRecord, callback, request);
    } else {
	    // combine the new values with primary keys to form the update set for the modified
        // record.  Copy so that we still have the original values intact when the transaction
        // returns.
        var pks = isc.DS.get(this.dataSource).filterPrimaryKeyFields(oldValues),
            updates = isc.addProperties({}, pks, newValues);
        ds.updateData(updates, callback, request);
    }
},

_saveLocally : function (editInfo, saveCallback) {

    var rowNum = editInfo.rowNum,
        colNum = editInfo.colNum, 
        oldValues = editInfo.oldValues,
        newValues = editInfo.values;

    var record = this.getCellRecord(rowNum, colNum),
        addNew = (record == null);
	// Note: This should be split into a separate method, which would handle updating 
	// local data, or server-side data (and the list would automatically unsort as a result
	// of dataChanged())
    if (addNew) {
        var data = this.getData();

        // Associate the new record object with the edit values before adding the record to
        // the data array.
        
        var editValuesContext = this.getEditSession(rowNum);
        editValuesContext._primaryKeys = this.getPrimaryKeys(newValues);
        
        delete editValuesContext._newRecord;

        data.add(newValues);
        data.dataChanged();
    
	// update the record in place with 'setRawCellValue()' if we're editing an existing one
    } else {
        var cellValue, undef;
        
        for (var i = 0; i < this.fields.length; i++) {
            cellValue = newValues[this.fields[i][this.fieldIdProperty]];
            if (cellValue !== undef) this.setRawCellValue(record, rowNum, i, cellValue);
        }
    }

	// un-sort the list if the sorted field value was edited.  Otherwise the record might
	// get sorted out of the viewport.
    this._unsortOnChange(newValues, oldValues);
    this._editCompleteCallback(editInfo, saveCallback);
},

// unsort() if we are sorted and the sort field will be changed in this update
_unsortOnChange : function (newValues, oldValues) {
    //this.logWarn("unsort on change: sortFieldNum: " + this.sortFieldNum + 
    //             ", newValues: " + this.echo(newValues) +
    //             ", oldValues: " + this.echo(oldValues));
    var sortFieldNum = this._getSortFieldNum();
    if (sortFieldNum == null) return;

    var sortField = this.fields[sortFieldNum];
    if (sortField == null) return;

    var sortFieldName = sortField[this.fieldIdProperty];
    var undef;
    if (sortFieldName != null && newValues[sortFieldName] !== undef &&
        (oldValues == null || newValues[sortFieldName] != oldValues[sortFieldName])) 
    {
        this.unsort();        
        //this.logWarn("called unsort, sortProp is: " + this.data._sortProperty);
    }
},

// callback from server save triggerred in commitEditValue
_updateRecordReply : function (dsResponse, dsRequest) {
    var results = dsResponse.data,
        context = dsResponse.clientContext,
        editInfo = context.editInfo,
		colNum = editInfo.colNum,
		field = this.fields[colNum]
    ;

    // Clear out the _savingEdits flag for this row as the save will have completed now.
    
    if (this._savingEdits && this._savingEdits[editInfo.editValuesID]) {
        delete this._savingEdits[editInfo.editValuesID];
        if (isc.isAn.emptyObject(this._savingEdits)) delete this._savingEdits;
    }
    
	// the rowNum may be different by now due to unrelated changes.  Look up the editValues we
	// were trying to save by editValuesId, and see what rowNum they are now associated with.
	
    var editSession = this.getEditSession(editInfo.editValuesID);
    
    if (editSession != null) {
        editInfo.rowNum = editSession._rowNum;
        
    } else {
        
        if (results && results[0]) {
            editInfo.rowNum = this.findRowNum(results[0]);
            if (this.useCellRecords) editInfo.colNum = this.findColNum(results[0]);
        }
        
        // If no record was returned, assume it was an attempt to save a new row which
        // failed to save, and for which editVals have now been discarded
        else editInfo.rowNum = -1;
    }

    var rowNum = editInfo.rowNum, colNum = editInfo.colNum;
    
    if (dsResponse.status < 0) { // error occurred
    	// XXX We should really check for the 'validation failed' error code here
    	// (results.status) rather than just checking for the presence of errors
        
        
        var errors = this.parseServerErrors(dsResponse.errors);
        
        this.logInfo("error on save, status: " + dsResponse.status + 
                     ", errors: " + this.echo(dsResponse.errors), "gridEdit");
        
        // The server will return an array of error object - one per record edited.
        // Since we only support saving out one record at a time, this should be a one element
        // array only.
        // Pull out the error object for the edited row, and pass it back to the setRowErrors()
        // method to store and display the errors
        
        if (isc.isAn.Array(errors)) {
            if (errors.length != 1) 
                this.logWarn("Server reports validation errors for multiple records - only " +
                             "displaying errors for the first record.", "gridEdit");
            
            errors = errors[0];
        }

        // Store, and display the new errors
        if (this.useCellRecords) this.setCellErrors(rowNum, colNum,
                                                    errors[this.getEditorName(rowNum, colNum)]);
        else this.setRowErrors(rowNum, errors);
    
    	// fire the simple callback function indicating the edit failed
    	// (The second param would be any additional callback to fire on completion)
        this._editFailedCallback(editInfo, context.saveCallback, dsResponse, dsRequest);
    
        return false;
    } 
	// if we got here, the edit was successful
    this._editCompleteCallback(editInfo, context.saveCallback, dsResponse, dsRequest)
},

// parseServerErrors():
// Convert the dsResponse.errors object returned by the ISC server to our internal
// errors format

parseServerErrors : function (errors) {
    if (isc.isAn.Array(errors)) {
        if (errors.length > 1) {
            this.logWarn("server returned errors for multiple records - dropping all but the " + 
                        "first record returned");
        }
        errors = errors[0];
    }

    
    if (errors && errors.recordPath) delete errors.recordPath;
    
    for (var fieldName in errors) {
        var fieldErrors = errors[fieldName];
        if (isc.isAn.Array(fieldErrors)) {
            for (var i = 0; i < fieldErrors.length; i++) {
                fieldErrors[i] = fieldErrors[i].errorMessage;
            }
        } else {
            errors[fieldName] = [fieldErrors.errorMessage];
        }
    }
    return errors;
},


//>	@method     listGrid._editCompleteCallback    (I)
//
//      Callback method triggered when a saveEditedValues flow completes successfully.
//      Fired whether the save succeeded on the client or on the server.
//      Calls the 'editComplete' string method (with the same signature) if present.
//
//  @group  editing
//
//  @param  editInfo (object)       Details of the edit
//                                  <br>Contains:
//                                  <ul>
//                                  <li>rowNum - index of edited row</li>
//                                  <li>colNum - index of edited column</li>
//                                  <li>values - edited values for the record</li>
//                                  <li>oldValues - values for the record before this edit</li>
//                                  <li>editCompletionEvent - how the edit was completed</li>
//                                  </ul>
//  @param [callback] (function)      Optional callback function to fire
//  @param [dsResponse] (DSResponse)  DSResponse for DataSource saves
//
//  @visibility internal
//<
_editCompleteCallback : function (editInfo, callback, dsResponse, dsRequest) {

    // If the editForm has focus, ensure the latest values have been stored
    if (this._editorShowing && this.getEditForm().hasFocus) this.storeUpdatedEditorValue(true);

    var rowNum = editInfo.rowNum,
        colNum = editInfo.colNum,
        valuesID = editInfo.editValuesID,
        editSession = this.getEditSession(valuesID);
        
    var record;
    
    // Databound saves will have been passed a dsResponse from the server
    if (dsResponse != null) {
        
        var updateData = isc.DataSource.getUpdatedData(dsRequest, dsResponse, true),
            record = isc.isAn.Array(updateData) ? updateData[0] : updateData;
        if (record == null) {
            
            return;
        }
     
        // If the user was editing a new record, we may not have any primary key field
        // on the editSession object, required to reliably associate the editSession with
        // the record in the dataSet.
        // Catch this case and call newRecordForEditValues() to perform the association
        if (editSession && editSession._primaryKeys == null) {
            this.newRecordForEditValues(valuesID, record);
        }

    } else {
        // for client-only saves assume the save will never change the rowNum
        record = this.getCellRecord(rowNum, colNum)
    }

    // Clear up the editValues that have already been saved to the server.
    // Leave anything that has been edited after the save was committed
    
    var submittedValues = editInfo.values,
        // use th internal getEditValues() since we already stored the updated value if 
        // appropriate
        currentEditValues = this._getEditValues(valuesID),
        
        stillEditing = this.isEditingRecord(rowNum, colNum),
        primaryKeyFields = 
            this.dataSource ? isc.DS.get(this.dataSource).getPrimaryKeyFieldNames()
            : null;

    var hasChanges = false;
    for (var field in currentEditValues) {
        var isPK = primaryKeyFields && primaryKeyFields.contains(field);
        if (this.fieldValuesAreEqual(this.getField(field), 
                                     currentEditValues[field], submittedValues[field]))
        {
            // If we're still showing the editor, don't wipe out primary key fields- we always
            // want these included in our edit values. Only requred for databound grids.
            
            if (!(stillEditing && isPK)) this.clearEditValue(valuesID, field, true, true);
        } else {
            if (!isPK) hasChanges = true;
        }
    }
    // If the editor is no longer showing, and there are no outstanding edits, ensure the
    // editValues object has been cleared
    // Note: If the editor is still showing, we'll drop all unchanged edit values when the
    // editor gets hidden.
    
    if (!stillEditing && !hasChanges) {
        this._clearEditValues(valuesID, colNum);
    }

    // call dataChanged() to to refresh the mapping between pending edit values and rowNums, 
    // and redraw to show new rows
    
    
    if (dsResponse != null || editInfo.newRecord) {
        this.displayUpdatedDSRecord(rowNum, colNum, record);
    }

    // At this point edit context objects match their associated edit rows, and all edit values
    // have been updated.
    // Fire callbacks.
    
    
    
    var newValues = editInfo.values,
        oldValues = editInfo.oldValues,
        editCompletionEvent = editInfo.editCompletionEvent;

    
    if (rowNum == -1) rowNum = editInfo.rowNum;
    
    if (this.convertToMethod("editComplete")) {
        this.editComplete(rowNum, colNum, newValues, oldValues, editCompletionEvent, dsResponse);
    }

    this._fireCellChanged(record, rowNum, colNum, newValues, oldValues, dsRequest);

    if (callback) this._fireSaveCallback(callback, rowNum, colNum, editCompletionEvent, true);
},

// displayUpdatedDSRecord - called from editCompleteCallback on databound save
// just call dataChanged so we refresh to display the change (will already be present in our
// ResultSet)
displayUpdatedDSRecord : function (rowNum, colNum, record) {
    this.dataChanged();
},

isEditingRecord : function (rowNum, colNum) {
    return this.getEditRow() == rowNum;
},

// Fires the single callback explicitly passed into saveEdits() as a parameter
_saveCallbackParams:"rowNum,colNum,editCompletionEvent,success",
_fireSaveCallback : function (callback, rowNum, colNum, editCompletionEvent, success) {
    if (callback != null) {
        this.fireCallback(callback, 
                          this._saveCallbackParams, 
                          [rowNum,colNum,editCompletionEvent,success]
        );
    }
},

_fireCellChanged : function (record, rowNum, colNum, newValues, oldValues, dsRequest) {
	// if a cellChanged was supplied, call that 
	// Currently available at field and LG level (should we allow it per-row too?)
    var changeGroup;
    for (var i in newValues) {
        var oldValue = (oldValues == null ? null : oldValues[i]);
        if (newValues[i] == oldValue) continue;
        var currentField = this.fields.find(this.fieldIdProperty, i);
        
        // if a field was changed which does not exist in the grid's field list,
        // ignore it. It can't be grouped and cellChanged() cannot be called on it.
        if (!currentField) continue;

        // check for the new to re-group this record
        if (this.isGrouped && currentField && this.groupByField.contains(currentField.name)) {
            changeGroup = true;
        }
    
        this._cellChanged(
                            record, currentField, 
                            newValues[i], oldValue,
                            rowNum, 
                            this.fields.indexOf(currentField)
                          );
    }

    if (changeGroup) {
        if (this.shouldSaveLocally())  // if bound, dataChanged will already handle this
            this._incrementalRegroup(record, record, rowNum, newValues);
        
        // redraw grid
        // regardless of if the data is saved locally, folderToggleObservation is not
        // called before this point, so it must exist outside the above codepath.
        this._suppressFolderToggleRedraw = false;
        this._folderToggleObservation();
    }
},

// Fire the 'cellChanged' string method handler(s) at the field or List level, if defined.
// If an entire row was edited this method (and the public cellChanged handlers) will be fired
// for each field edited.
_cellChanged : function (record, field, newValue, oldValue, recordNum, fieldNum) {
    
    if (field && field.cellChanged) {
        if (!isc.isA.Function(field.cellChanged)) {
        	// (We must use replaceWithMethod rather than convertToMethod as the field is
        	// not an ISC class with a string method registry on it)
            isc.Func.replaceWithMethod(field, "cellChanged", 
                        "record,newValue,oldValue,rowNum,colNum,grid,recordNum,fieldNum");
        }

    	// call() to call the function on the grid rather than the field
        field.cellChanged.call(this,
                               record,newValue,oldValue,recordNum,fieldNum,this,recordNum,fieldNum);

    } else if (this.cellChanged) {
    	// call the list.cellChanged method, and note if it returns false (thus rejecting the change)
        this.cellChanged(record,newValue,oldValue,recordNum,fieldNum,this,recordNum,fieldNum);
    }

},

// Called when saving fails due to validation or other errors.  Calls the 'editFailed' 
// string method (with the same signature) if present.  Will be called once per record
// if there was an attempt to save multiple records at once (saveAllEdits())

_editFailedCallback : function (editInfo, callback, dsResponse, dsRequest) {
    
    var rowNum = editInfo.rowNum,
        colNum = editInfo.colNum,
        values = editInfo.values,
        oldValues = editInfo.oldValues,
        eCe = editInfo.editCompletionEvent;

	// note newValue can be a single value or an entire record
    if (this.convertToMethod("editFailed")) {
        this.editFailed(rowNum, colNum, values, oldValues, eCe, dsResponse, dsRequest);
    }
    if (callback != null) this._fireSaveCallback(callback, rowNum,colNum,eCe,false);

    
    this.clearSubmittedEditValues(editInfo.editValuesID, values);
    
},

// see doc near stringMethod declaration, below
editFailed : function (rowNum, colNum, newValues, oldValues, editCompletionEvent, dsResponse, dsRequest) {

	// if this was an attempted server-side commit that returned a failure code from the server
	// (with no specific error messages), pass it on to rpcManager.handleError()
	
    if (dsResponse != null && dsResponse.errors == null) {
        isc.RPCManager._handleError(dsResponse, dsRequest);
    }
},

// ============================================================================================
// Validation
// ============================================================================================

// Performing validation
// ------------------------------------------------

//> @groupDef gridValidation
// ListGrids support automatic validation of edited cells / records. This group is a collection 
// of APIs related to the validation subsystem.
// <p>
// Default validation occurs in response to the user navigating between edit cells 
// (see +link{listGrid.validateByCell}) or whenever edited values are to be committed to the
// server for saving.  Standard validation can also be triggered for a cell or row programatically at
// any time.<br>
// When standard validation occurs, +link{listGridField.validators} will be run on each
// cell to be validated.<br>
// In addition to this standard behavior developers can add custom errors to fields
// via +link{listGrid.setFieldError()} / +link{listGrid.setFieldError()}.
//
// @see group:editing
// @visibility external
//<


//> @method  listGrid.validateRow()
// Validate the current set of edit values for the row in question.
// <P>
// Called when the user moves to a new edit row, or when an edited record is to be saved if
// client side validation is enabled for this grid.
// <P>
// This method may also be called directly to perform row level validation at any time.
//
// @param   rowNum (number) index of row to be validated.
// @return  (boolean) returns true if validation was successful (no errors encountered), false
//                    otherwise.
// @group gridValidation
// @visibility external
//<
validateRow : function (rowNum, suppressRefresh) {
    return this.validateRecord(rowNum, suppressRefresh);
},


// validateRecord()
// Actually perform the validation of edit values for some record
// For one-record-per-cell implementations this will need to be overridden
validateRecord : function (cell, suppressRefresh) {
    
    var rowNum, colNum;
    if (isc.isAn.Array(cell)) {
        rowNum = cell[0];
        colNum = cell[1];
    } else {
        rowNum = cell;
    }
    
        
    var newValues = this.getEditValues(rowNum, colNum);

    // If the row is not being edited always "pass" validation.    
    if (newValues == null) return true;
    
    var record = this.getCellRecord(rowNum,colNum), 
        fields;
        
    // validate every field if we're adding a new row [required to enforce required fields]
    // Otherwise only validate fields with an entry in the editValues array.
    if (record == null) fields = this.getFields().getProperty(this.fieldIdProperty);
    else fields = isc.getKeys(newValues);
    var errorBlock = this.validateRowValues(newValues, record, rowNum, fields);
    // call setRowErrors() to store, and display the new set of editValues for the row.
    this.setRowErrors(rowNum, errorBlock, suppressRefresh);
    
    return (errorBlock == null)
},


//>	@method     listGrid.validateRowValues()
//  Helper method to perform validation on a row.
//  Called by validateRow() - returns any errors found on the row.
//
//	@group gridValidation	
//  @param  newValues   (object)    Field-value mapping showing the edited values for each field
//  @param  oldValues   (object)    Field-value mapping showing the values for each field before 
//                                  editing
//  @param  rowNum      (number)    Index of the row being edited
//  @param  fields      (number | string | array)     
//                          Fields to be validated.  If more than one field is to be validated,
//                          this will be an array.
//                          Note that each field can be designated either by fieldName or the 
//                          numeric index.
//  @return (object)   set of errors returned by validation, in the format 
//                      {fieldName:["errorMessage", ...],...}.
//                     will be null if no errors encountered
//  @visibility internal
//<
validateRowValues : function (newValues, oldValues, rowNum, fields) {

    var validationPassed = true,
        errorBlock = {};
    
	// handle being passed a single field
    if (!isc.isAn.Array(fields)) fields = [fields];        

	// Handle editing a new record - oldvalues for each cell will be undefined.
    var isNewRecord = false;
    if (oldValues == null) {
        isNewRecord = true;
        oldValues = {};
    }

	// validate each field seperately, then show the errors for all fields
    for (var i = 0; i < fields.length; i++) {
        var fieldName,
            colNum;

        // ensure fields[i] is a fieldName and record the colNum
        if (isc.isA.Number(fields[i])) {
            colNum = fields[i];
            fieldName = fields[i] = this.getFieldName(colNum);
        } else {
            fieldName = fields[i];
            colNum = this.getFields().findIndex(this.fieldIdProperty, fieldName)
        }

    	// If the field isn't included in this list, skip it... This is likely to happen
    	// as lists won't show every field, but we will include the primary keys in our edit
    	// values
        if (colNum < 0) continue;
        
        // validate if this is an editable cell in a new record (in order to enforce eg the
        // required validator), or if there if the field has been edited.
        var shouldValidateCell = (
            (isNewRecord && this.canEditCell(rowNum, colNum)) ||
            isc.propertyDefined(newValues, fieldName)
        
        );
        if (!shouldValidateCell) continue;

        var newValue = newValues[fieldName],
            oldValue = oldValues[fieldName],
            
            validationErrors = this.validateCellValue(rowNum, colNum, newValue, oldValue);

        if (validationErrors != null) {
            validationPassed = false;
            errorBlock[fieldName] = validationErrors;
        }
    }
    if (!validationPassed) return errorBlock;
    return null;
},


//>@method  listGrid.validateCell()
// Validate the current edit value for the cell in question.  Called when the user moves to a
// new edit cell if +link{ListGrid.validateByCell} is true.<br>
// This method may also be called directly to perform cell level validation at any time.
// @param   rowNum (number) index of row to be validated.
// @param   fieldName (string | number) field name (or column index) of field to be validated
// @return  (boolean) returns true if validation was successful (no errors encountered), false
//                    otherwise.
// @group gridValidation
// @visibility external
//<
validateCell : function (rowNum, fieldName, suppressDisplay) {

    var colNum;
    if (isc.isA.String(fieldName)) colNum = this.getColNum(fieldName);
    else {
        colNum = fieldName;
        fieldName = this.getEditorName(rowNum, colNum);
    }
    var editVals = this.getEditValues(rowNum, colNum),
        hadErrors = this.cellHasErrors(rowNum, fieldName),
        newValue = editVals ? editVals[fieldName] : null,
        record = this.getCellRecord(rowNum, colNum),
        oldValue = record ? record[fieldName] : null;

    // don't validate if the cell has not been edited (unless this is a new record in which
    // case it will be saved as a null value.
    if (record != null && (!editVals || !isc.propertyDefined(editVals, fieldName))) {
        return true;
    }
    
    var errors = this.validateCellValue(rowNum, colNum, newValue, oldValue);
    if (errors != null) {
        // call setFieldError() to store the error object on the
        // appropriate cell, and display it to the user.
        if (this.useCellRecords) this.setCellErrors(rowNum, colNum, errors);
        else this.setFieldError(rowNum, fieldName, errors);
        return false;
    }

    // if the cell previously had errors, explicitly clear them out
    if (hadErrors) {
        if (this.useCellRecords) this.setCellErrors(rowNum, colNum, null);
        else this.setFieldError(rowNum, fieldName, null);
    }
    return true;
},

//>	@method		listGrid.validateCellValue()	(A)
// Helper method for validateCell(): Validate the new value the user supplied for a single cell.
// <p>
// Default implementation falls through to the stringMethod
// list.validateFieldValue(newValue, oldValue, record, field, rowNum, colNum) to
// perform validation based on the edit field's validators.
//
//	@group gridValidation
//
//  @param  rowNum  (integer)   Edited cell's row number
//  @param  colNum (integer)   Edited cell's field number
//	@param	newValue	(any)		Value returned by the editor.
//  @param  oldValue    (any)   Value before editing
//  @return (array) Array of validation error objects, or null if none found
//<
validateCellValue : function (rowNum, colNum, newValue, oldValue) {
    var record = this.getCellRecord(rowNum, colNum);
    var field = this.getField(colNum);    
    return this.validateFieldValue(newValue, oldValue, record, field, rowNum, colNum);
},

// Allow cusomization of the 'required field' validation error message
//>@method listGrid.getRequiredFieldMessage()
// Returns the message to display when a user attempts to save a required field with an
// empty value. Override for localization if required.
// @param field (object) definition of the field being edited
// @param record (object) record object being edited
// @return (string) "Field is required"
// @group gridValidation, i18nMessages
// @visibility external
//<
getRequiredFieldMessage : function (field, record) {
    return "Field is required";
},

//>	@method		listGrid.validateFieldValue()	(A)
//
// 	Validate the new value the user supplied for a cell via an editCellValue() call against
//  any validators defined on the edit field.
//
//	@group	editing
//
//	@param	newValue	(any)		Value returned by the editor.
//  @param  oldValue    (any)       Value before editing
//  @param  record  (object)    pointer to the record object for the edited cell
//  @param  field   (object)    pointer to the field descriptor object for the edited cell
//  @param  rowNum  (number)    row index of the edited cell
//  @param  colNum  (number)    column index for the edited cell
//  @return (array)     array of error objects, or null if no errors found
//<
validateFieldValue : function (newValue, oldValue, record, field, rowNum, colNum) {
	// Note: We don't take a record parameter, as we have no need for it.  If a developer wishes
	// to override validation and make use of both the record and field object for the edited cell
	// (s)he should override validateCellValue() instead.

	// Set up an errors object to pass through to editFailed (if necessary);
    var errors = [],
        success = true;

    var required = this.cellIsRequired(rowNum, colNum);        
	// Check for required fields
    if (required && (newValue == null || isc.isAn.emptyString(newValue))) {
        var errorMessage = this.getRequiredFieldMessage(field, record);
        errors.add(errorMessage);
        success = false;
    }
	// validate the value if the field specifies validators
    var validators = this.getCellValidators(rowNum, colNum);
    if (validators) {

        if (!isc.isAn.Array(validators)) {
            validators = [validators];
        }	

        if (this.logIsDebugEnabled("gridEdit")) {
            this.logDebug((this.useCellRecords ? "At col:" + colNum : "At field: " + field.name) + 
                          " applying validators: " + this.echoAll(validators) + 
                          " to value:" + newValue,
                          "gridEdit");
        }
        
        for (var i = 0; i < validators.length; i++) {
            var validator = validators[i];
            if (!validator || validator.serverOnly) continue;
            var isValid = isc.Validator.processValidator(field, validator, newValue);
            
            if (isValid != true) {
                success = false;
               
                // Allow the Validator class to get the error message from the validator object
                // This will evaluate any dynamic validation error message strings                
                errors.add(isc.Validator.getErrorMessage(validator));
            } else {
                
                if (validator.resultingValue != null) {
                    this.setEditValue(rowNum, colNum,
                                      validator.resultingValue);
                    newValue = validator.resultingValue;
                }
            }

			// if the validator wants us to stop if it wasn't passed, break out of the
            // validators loop
			if (!isValid && validator.stopIfFalse) break;
        }
        if (this.logIsInfoEnabled("gridEdit")) {
            this.logInfo("validateFieldValue, newValue: " + this.echo(newValue) +
                         ", passed validation: " + isValid + 
                         ", resultingValue: " + this.echo(validator.resultingValue),
                         "gridEdit");
        }
    }

    if (success) return null
    else return errors;
},

// cellIsRequired / getCellValidators allows us to separate our validator definitions from
// true field objects (makes custom cubeGrid validation easier to apply)
cellIsRequired : function (rowNum, colNum) {
    var field = this.getField(colNum);
    return field && field.required;
},

getCellValidators : function (rowNum, colNum) {
    var field = this.getField(colNum);
    return field ? field.validators : null;
},

// Validation Errors 
// ---------------------------------------------------------------------------------------

//> @method     listGrid.hasErrors()
// Does this grid currently have errors associated with editValues for any row in the grid.
// @group gridValidation
// @return  (boolean)   true if there are unresolved errors, false otherwise
// @visibility external
// @see listGrid.rowHasErrors()
// @see listGrid.cellHasErrors()
//<
hasErrors : function () {
    var editRows = this.getAllEditRows(true);
    for (var i = 0; i < editRows.length; i++) {
        if (this.rowHasErrors(editRows[i])) return true;
    }
    return false;
},

//> @method     listGrid.rowHasErrors()
// Does the specified row have unresolved errors?
// @group gridValidation
// @param rowNum (number)   rowNum to check for errors
// @return  (boolean)   true if there are unresolved errors, false otherwise
// @visibility external
// @see listGrid.hasErrors()
// @see listGrid.cellHasErrors()
//<
// Note: the rowNum parameter can also be the editValuesID property associated with some
// set of edit values [IE some edited row] for the grid.
rowHasErrors : function (rowNum, colNum) {
    var editData = this.getEditSession(rowNum, colNum);
    
    return (editData && editData._validationErrors && 
            !isc.isA.emptyObject(editData._validationErrors));
},

//> @method     listGrid.cellHasErrors()
// Given a rowNum and a colNum or fieldName, determine whether we currently have stored 
// validation errors for the record/field in question.
//  @group gridValidation 
//  @param  rowNum  (number)    index of row to check for validation errors
//  @param  fieldID (number|string)    name of field, or index of column to check for validation 
//                                      errors
//  @return (boolean)   true if we have validation errors for the row/col in question
// @visibility external
// @see listGrid.hasErrors()
// @see listGrid.rowHasErrors()
//<
// As with rowHasErrors, the rowNum can be an editValuesID as well as a rowNum

cellHasErrors : function (rowNum, fieldID) {
    var fieldName = (isc.isA.String(fieldID) ? fieldID : this.getEditorName(rowNum, fieldID)),
        editData = this.getEditSession(rowNum, fieldID),
        errors = editData ? editData._validationErrors : null;
        
    return (
        errors != null && 
        errors[fieldName] != null
    );
},


// No obvious use for a listGrid.getErrors() method.

//>!BackCompat 2007.02.14
//> @method     listGrid.getRowValidationErrors()
//  Returns any currently stored validation errors for this row in the following format:<br>
//  &nbsp;&nbsp;<code>{fieldName:[validation error array], ...}</code>
//  @group  editing
//  @visibility internal
//  @param  rowNum (number) index of row to check for validation errors.
//  @return (object)   object showing validation error arrays by field for the row passed in - if
//                      no validation errors stored for the row, null is returned.
// @deprecated in favor of +link{listGrid.getRowErrors()}
//<

getRowValidationErrors : function (rowNum) {
    return this.getRowErrors(rowNum);
},
//<!BackCompat

//> @method     listGrid.getRowErrors()
//  Returns any currently stored validation errors for this row in the following format:<br>
//  &nbsp;&nbsp;<code>{fieldName:[array of error messages], ...}</code>
//  @group gridValidation 
//  @param  rowNum (number) index of row to check for validation errors.
//  @return (object)   object showing validation error arrays by field for the row passed in 
//                      - if no validation errors stored for the row, null is returned.
// @visibility external
// @see listGrid.getCellErrors()
//<
getRowErrors : function (rowNum, colNum) {
    var data = this.getEditSession(rowNum, colNum);
    return (data != null ? data._validationErrors : null);
},

//> @method     listGrid.getCellErrors()
//  Returns the current set of errors for this cell. 
//  @group gridValidation 
//  @param  rowNum (number) index of row to check for validation errors.
//  @param  fieldName   (string | number)   field to check for validation errors - can be fieldName 
//                                          or index of the column.
//  @return (array) array of error messages (strings) for the specified cell. If no validation 
//                  errors are present, returns null.
//  @visibility external
//<
getCellErrors : function (rowNum, fieldName) {
    // assume fieldName is a colNum if we're working with cellrecords
    var data = this.getEditSession(rowNum, fieldName);
    if (data == null) return null;
    
    if (isc.isA.Number(fieldName)) fieldName = this.getEditorName(rowNum, fieldName);
    var errors = data._validationErrors;
    return (errors == null ? null : errors[fieldName]);
},


// Synonym of setFieldError(), since we already supply getCellErrors()
setCellErrors : function (row, field, error, suppressDisplay) {
    return this.setFieldError(row, field, error, suppressDisplay);
}, 

//> @method     listGrid.setFieldError()
// Set a validation error for some cell.
// @group gridValidation 
// @param  rowNum  (number)    row index of cell to add validation error for
// @param  fieldName (number | string)    col index or field name of cell to add validation error for
// @param  errorMessage  (string | array of strings)    validation error/errors for the cell.
// @visibility external
// @see listGrid.getCellErrors()
// @see listGrid.setRowErrors()
//<
setFieldError : function (rowNum, fieldID, errorMessage, dontDisplay) {
    var fieldName = fieldID;
    if (isc.isA.Number(fieldName)) fieldName = this.getEditorName(rowNum, fieldName);

    // If passed an empty set of errors, use delete to clear the error instead
    if (errorMessage == null || (isc.isAn.Array(errorMessage) && errorMessage.length == 0)) {

        if (!this.cellHasErrors(rowNum, fieldID)) return;
        
        var data = this.getEditSession(rowNum, fieldID);
        delete data._validationErrors[fieldName];
        // Dont hang onto an empty errors object - this will confuse hasErrors et al.
        if (isc.isAn.emptyObject(data._validationErrors)) delete data._validationErrors
    } else {
        // If passed a bad fieldNum, for example, just drop it
        if (fieldName == null) {
            this.logWarn("setFieldError() passed field identifier '" + fieldID + "'. " +
                        "Unable to find corresponding field in this grid - not setting error.");
            return;
        }

        // Warn if the user has set errors on non visible fields (or completely random fields)
        var visFields = this.getFields().getProperty(this.fieldIdProperty);
        if (!visFields.contains(fieldName)
            
            ) 
        {
            this.logWarn("setFieldError() passed field identifier '" + fieldID + "'. This " +
                         "is not a visible field in the grid - error may not be visible to user.");
        }
        
        var errors;
        if (isc.isAn.Array(errorMessage)) errors = errorMessage
        else errors = [errorMessage];
        
        var data = this.getEditSession(rowNum, fieldID);
    	// Unlikely to happen, but catch the case of being passed a row with no edit values
        if (data == null) {
            var colNum = this.getColNum(fieldID),
                record = this.getCellRecord(rowNum, colNum);
            data = this.createEditSession(rowNum, colNum, record);
        }
        
        if (data._validationErrors == null) data._validationErrors = {};
        data._validationErrors[fieldName] = errors;
    }

    // If appropriate show the errors to the user
    if (!dontDisplay) {
        
        if (this.useCellRecords) this.showCellErrors(rowNum, fieldID)
        else this.showErrors(rowNum, [fieldName]);
    } 
},

//> @method     listGrid.setRowErrors()
// Set the validation errors for some row (replacing any pre-existant validation errors)
// @group gridValidation
// @param  rowNum  (number)    row to add validation error for
// @param  errors (object) validation errors for the row in the format 
//                          <code>{fieldName:errorMessage, ...}</code> <br>or <br>
//                          <code>{fieldName:[errorMessage1, errorMessage2], ...}</code>
// @visibility external
// @see listGrid.getRowErrors()
// @see listGrid.setFieldError()
//<
setRowErrors : function (rowNum, errors, dontDisplay) {
    
    
    if (rowNum == null || rowNum == -1) return;
    
    var storedErrors = this.getRowErrors(rowNum);
    if (!errors && !storedErrors) return;
    
    var data = this.getEditSession(rowNum);
    
    if (data == null) data = this.createEditSession(rowNum, null, this.getRecord(rowNum));
    if (errors) {

        var visibleFields = this.getFields().getProperty(this.fieldIdProperty);
        for (var fieldName in errors) {
            // Warn if passed an error on a non-visible field as this will not show up
            // via the standard 'error cell' styling
            // Should probably have a customizable method to handle this
            if (!dontDisplay && !visibleFields.contains(fieldName)) {
                this.logWarn("setRowErrors() passed error for non-visible field: '" + fieldName + "'");
            }
            
            // Convert single error message strings into arrays.
            if (!isc.isAn.Array(errors[fieldName])) errors[fieldName] = [errors[fieldName]];
        }
    }
    
    // Actually store the validation object.
    data._validationErrors = errors;
    
    if (!dontDisplay) {

        // For efficiency, only refresh cells that actually need to be refreshed due to
        // new errors, or errors being cleared.
        var fields = errors ? isc.getKeys(errors) : [];
        
        // We need to update each cell in the row to reflect any changes to validation errors, 
        // either new errors, or errors that have been cleared.
        for (var fieldName in storedErrors) {
            var colNum = this.getColNum(fieldName);

            if (!fields.contains(fieldName)) fields.add(fieldName);
        }

        // Call showErrors() to actually update the error styling on the cells and show any
        // error messages to the user
        this.showErrors(rowNum, fields);
    }
},

//> @method     listGrid.clearFieldError()
// Clears any validation errors for some cell.
// @group gridValidation 
// @param  rowNum  (number)    row index of cell to add validation error for
// @param  fieldName (number | string)    col index or field name of cell to add validation error for
// @visibility external
// @see listGrid.setFieldError()
//<
clearFieldError : function (rowNum, fieldName, dontDisplay) {
    return this.setFieldError(rowNum, fieldName, null, dontDisplay);
},


//> @method     listGrid.clearRowErrors()
//  Clear any stored validation errors for some row
//  @group  validtion
//  @param  rowNum  (number)    index of row to clear validation error for
// @visibility external
// @see listGrid.setRowErrors()
//<
clearRowErrors : function (rowNum, dontDisplay) {
    this.setRowErrors(rowNum, null, dontDisplay);
},



// Showing Validation Errors
// ---------------------------------------------------------------------------------------

//>	@method     listGrid.showErrors() ([A])
// Update the specified row to display the current set of validation errors.<br>
// If +link{listGrid.stopOnError} is true and the row has errors, this method will also 
// call display the error messagese to the user in a warning dialog, and reset focus to 
// the first cell that failed validation.
// @param rowNum (number) row to be updated
// @param [fields] (array) Array of fieldNames for which errors should be displayed or cleared.
//                      If not passed defaults to displaying errors for every field in the row.
// @group gridValidation
// @visibility internal
//<
// Notes:
// - This is a potential override point - may want to make this external
// - The fields parameter is for more than just efficiency - it will also modify which
//   errors get displayed to the user via displayRowErrorMessages()
// - falls through to displayRowErrorMessages() to actually show the error messages
//   to the user in a warn dialog if stopOnErrors is true. Not clear that there's much point
//   to exposing this as if a developer wants to perform custom validation display this method
//   would probably be the more natural override point.
showErrors : function (rowNum, fields) {
    
    if (fields == null) fields = this.getFields().getProperty(this.fieldIdProperty);

    var errors = this.getRowErrors(rowNum);
    if (errors == null) errors = {};
    
    var firstFieldName;
    for (var i = 0; i < fields.length; i++) {
        var fieldName = fields[i];
        // Update the cell to display error styling and icon (or clear errorIcon and styling)
        this.showCellErrors(rowNum, fieldName);
                
        if (firstFieldName == null && errors[fieldName]) firstFieldName = fieldName;
    }
    
    // Split the method to convert the errors into a user-visible string into a separate
    // method for localization    
    var errorMessageString = this.assembleErrorMessage(errors, fields);
    
    // Call a simple (overrideable) method to actually inform the user of the validation errors.
    
    if (errorMessageString) {
        this.displayRowErrorMessages(errorMessageString);
    }
    
	// If we're not saving in the background, put focus back into the first cell that failed 
    // the edit (only necessary if the validation failed)
    if (this.stopOnErrors && firstFieldName != null) {
        var firstColNum = this.getFields().findIndex(this.fieldIdProperty, firstFieldName);
        this.showInlineEditor(rowNum, firstColNum);
    }      
},  

// showCellErrors()
// Helper method to update a cell in the body to display errors (or clear errors if appropraite)
showCellErrors : function (rowNum, colNum) {
    
    // Accept the 2nd param as a colNum or fieldName
    var fieldName;
    if (isc.isA.Number(colNum)) {
        this.getEditorName(rowNum, colNum);
    } else {
        fieldName = colNum;
        colNum = this.getColNum(fieldName);
    }
    // If passed a non-visible field, just bail.
    if (colNum == -1) return;
    
    if (this.showErrorIcons) {
        // refresh cell to rewrite the HTML to show (or hide) the icon.
        this.refreshCell(rowNum,colNum, null, true);
    } else {
        this.body._updateCellStyle(null, rowNum, colNum)
    }    
},


//> @method listGrid.assembleErrorMessage()
// This method is called when validation errors occur, and assembles the set of errors into 
// a string to be displayed to the user. Overridable for localization.
// @param errors (object) Object containing <code>fieldName:error</code> mappings. Note that the
//              <code>error</code> object for each field may be a simple error message string, 
//              a pointer to the validator that failed (so the errorMessage is available as 
//              the <code>errorMessage</code> attribute of that object, or 
//              an array of validator type objects (for multiple validaiton failures).
// @return (string) By default returns a string in the following format:<pre>
//                  Validation errors occurred:
//                  Field '[fieldTitle]':
//                  * [errorMessage]
//                  * [errorMessage]
//                  </pre>
// @visibility internal
// @group editing, i18nMessages
//<                 
assembleErrorMessage : function (errors, fields) {

    // Iterate through the set of errors, assembling an 
    // error message string to show the user for the row.
    // Note the errors object is expected to be in the format:
    //   {fieldName:["error message 1", "errorMessage 2", ...],
    //    fieldName2:["error message 1", ...], ... }
    var errorMessageFound = false,
        errorMessageString = "Validation Errors occurred:\r\n";
        
    for (var fieldName in errors) {
        if (fields && !fields.contains(errors)) continue;

        // Assemble the errors together into a string to ultimately be passed to 
        // 'displayRowErrorMessages'
        var errorMessage = this._createFieldErrorString(fieldName, errors[fieldName]);

        if (errorMessage != null) {
            errorMessageFound = true;
            errorMessageString += errorMessage;
        }
                
    }
    return (errorMessageFound ? errorMessageString : null);
},


// Internal helper for assembling all the error messages for a row into a single string
_createFieldErrorString : function (fieldName, errors) {
    // Assemble the errors together into a string to ultimately be passed to 
    // 'displayRowErrorMessages'
    var errorMessageString, fieldErrorMessage,
        field = this.getField(fieldName),
        fieldTitle = field && field.title ? field.title : fieldName;

    // Note that we always normalize the format of stored errorMessages to 
    // an array of strings per field
    for (var i =0; i < errors.length; i++) {
        var errorMessage = errors[i];
        if (errorMessage != null) {
            if (fieldErrorMessage == null) {
                fieldErrorMessage = "<br>Field '" + fieldTitle + "':";
            }
            fieldErrorMessage += "<br>* " + errorMessage;
        }
    }
    return fieldErrorMessage;
},

//>	@method     listGrid.displayRowErrorMessages()
//  A simple method called from 'showErrors' to display errorMessages from validation
//  on some row.
//  Takes a single errorMessage parameter - default implementation alerts this string if 
//  this.stopOnErrors is true.<br>
//  Notes:<br>
//  Override this method to display error messages in some other way.<br>
//  For a more sophisticated validation error handling, the 'showErrors()' method can be
//  overridden instead.<br>
//	@group	editing
//
//  @param  rowNum  (number) Index of the record on which the validation errors occurred.
//  @param  errors  (object) Object containing a map of field names to arrays of validation errors.
//  @see    listGrid.validateCellValue()
//  @see    listGrid.showErrors()
//  @see listGrid.assembleErrorMessage()
//<
displayRowErrorMessages : function (errorString) {
    
    if (this.stopOnErrors) isc.warn(errorString, "var LG=" + this.getID() + 
                                            ";if(LG._editRowForm)LG._editRowForm.focus()");
	// -- in this case we might want to stick the error into a hover, etc. 
	// - but hold off on that for now
},

// Removal of data 
// ---------------------------------------------------------------------------------------
_removeRecordClick : function (rowNum, record) {
    
    if (record == null) return;
    // use delayCall to actually remove the record in a separate thread.
    // required since we can't redraw immediately in response to a mouseDown
    this.delayCall("removeRecord", [rowNum, record]);
},

// Remove a record from this ListGrid.
// If this ListGrid is DataBound this will be achieved via a 'removeData' type operation on the
// dataSource, otherwise the record object will be removed from this ListGrid's client side
// data array.

removeRecord : function (rowNum, record) {
    if (record == null) record = this.data.get(rowNum);
    else rowNum = (this.data ? this.data.indexOf(record) : null)
    
    // Only support removing the record if it's actually showing up in this grid!
    // (This not removing nodes in closed parent folders for example)    
    if (record == null || rowNum == null || rowNum == -1 || !this.data) return;
    
    // animating record removal
    // If we're animating the record removal, we want to remove the data before starting the
    // animation. This ensures the record gets successfully cleared (not guaranteed in the case
    // of a server operation).
    // Set up the row animation before removing the data, then kick off the animation when we know
    // row removal was successful.
     
    var animateRemoveRecord = this.animateRemoveRecord && this.isDrawn() && this.isVisible() &&
                              this.body &&
                              rowNum >= this.body._firstDrawnRow && 
                              rowNum <= this.body._lastDrawnRow;
    
    if (animateRemoveRecord) {
        this._suppressRedrawOnDataChanged = true;
        var delta = 1;
        if (isc.isA.Tree(this.data) && this.data.isFolder(record) && this.data.isOpen(record)) {
            var children = this.data.getChildren(record);
            if (children) delta += children.getLength();
        }
        
        this._removeRowDelta = delta;
        // perform the setup for the animated hide while our data is still present in our dataSet
        this.body._initializeShowHideRow(false, rowNum, rowNum+delta);
    }
    
    var ds = this.getDataSource();
    if (ds) {
        if (!ds.getPrimaryKeyField) {
            this.logWarn("DataSource:"+ ds +
                        " has no primary key field - unable to remove records");
            return;
        } 
        var callback;
        if (animateRemoveRecord) {
            callback = this.getID() + ".removeDataComplete(" + rowNum + ", data,dsResponse);";
        }
        this.removeData(record, callback, {showPrompt:false});
    } else {
        // Data is non-null at this point and data.contains(record) returns true so we can
        // assume it's a valid client-side tree or array
        this.data.remove(record);
        // removeDataComplete starts an animation to show the removed row shrink out of sight
        if (animateRemoveRecord) this.removeDataComplete(rowNum, record);
    }
},

removeDataComplete : function (rowNum, record, response) {
    // if this was a server-based removal, check for errors
    if (response && response.status < 0) {
        this.logWarn("Removal of record failed");
        record = null;
    }
    
    if (!record) {
        delete this._suppressRedrawOnDataChanged;
        
        if (this.body) {
            // clear up the properties set up by _initializeShowHideRow
            delete this.body._animatedShowStartRow;
            delete this.body._animatedShowEndRow;
            delete this.body._animatedShowRowHeight;
            delete this.body._animatedShowCallback;
        }
        this.markForRedraw();
    } else {
        this.startRowAnimation(false, rowNum, rowNum+this._removeRowDelta, 
                                {target:this, methodName:"_removeDataAnimationComplete"},
                                this.animateRemoveSpeed, this.animateRemoveTime);
        delete this._removeRowDelta;                                
    }
},

_removeDataAnimationComplete : function () {
    delete this._suppressRedrawOnDataChanged;
    this.redraw();
},


// Row Animation
// ---------------------------------------------------------------------------------------

//>Animation
// Animated showing and hiding of rows
//> @method listGrid.startRowAnimation()
// @include gridRenderer.startRowAnimation()
//<
startRowAnimation : function (show, startRow, endRow, callback, speed,
                               duration, effect, slideIn, delayed) 
{
    if (!this.body) return;
    // if we have a frozen body too, animate there, but avoid firing the callback twice when
    // both animations complete
    if (this.frozenBody) {
        this.frozenBody.startRowAnimation(show, startRow, endRow, null, speed, 
                                          duration, effect, slideIn, true, delayed);
    }
    this.body.startRowAnimation(show, startRow, endRow, callback, speed, 
                                duration, effect, slideIn, true, delayed);
},

//> @method listGrid.animateRowHeight()
// @include gridRenderer.animateRowHeight()
//<
animateRowHeight : function (rowNum, newHeight, callback, speed, duration, effect, slideIn) {
    if (!this.body) return;
    return this.body.animateRowHeight(rowNum, newHeight, callback, speed, duration, effect, slideIn, true);
},
//<Animation

//> @method listGrid.setCellHeight() 
// Set the cellHeight for the listGrid as a whole. To set the height of individual rows use 
// +link{ListGrid.setRowHeight()} instead.
//<
setCellHeight : function (newHeight) {
    var oldHeight = this.cellHeight;
    this.cellHeight = newHeight;
    if (this.body) this.body.cellHeight = newHeight;
    if (oldHeight != newHeight && this.isDrawn()) this.body.markForRedraw("Cell height changed");
},


//> @method listGrid.setRowHeight() 
// @include gridRenderer.setRowHeight()
//<
setRowHeight : function (rowNum, newHeight) {
    if (!this.body) return;
    return this.body.setRowHeight(rowNum, newHeight);
},


// Body Drag&Drop (selection, reorder records, drag records out, drop records in)
// --------------------------------------------------------------------------------------------

//>@method  listGrid.setDragTracker()
// Sets the custom tracker HTML to display next to the mouse when the user initiates a drag
// operation on this grid. Default implementation will examine +link{listGrid.dragTrackerMode}
// and set the custom drag tracker to display the appropriate HTML based on the selected record.
// <br>
// To display custom drag tracker HTML, this method may be overridden - call 
// +link{EventHandler.setDragTracker()} to actually update the drag tracker HTML.
// @return (boolean) returns false by default to suppress 'setDragTracker' on any ancestors
//                   of this listGrid.
// @group dragTracker
// @visibility external
//<
setDragTracker : function () {

    var EH = isc.EH, dragTrackerMode = this.dragTrackerMode;
    if (dragTrackerMode == "none") {
        // we can't just not call setDragTracker(), or the dragTracker will be set to the
        // default canvas tracker image.
        EH.setDragTracker("");
        return false;
    } else if (dragTrackerMode == "icon") {
        var selection = this.getSelection(),
            icon = this.getDragTrackerIcon(selection);
            
            EH.setDragTracker(this.imgHTML(icon), null,null,null,null, this.getDragTrackerProperties());
            return false;
    } else {
        
        var record = this.getSelectedRecord(),
            rowNum = record && this.data ? this.data.indexOf(record) : -1;
        
        if (dragTrackerMode == "title") {
            var title = this.getDragTrackerTitle(record, rowNum);
            EH.setDragTracker(title,  null,null,null,null, this.getDragTrackerProperties());
            return false;   
        } else if (dragTrackerMode == "record") {
            var rowHTML = this.body.getTableHTML([0, this.fields.length-1], rowNum, rowNum+1);
            //this.logWarn("row html:"+ rowHTML);
            EH.setDragTracker(rowHTML,  null,null,null,null, this.getDragTrackerProperties());
            return false;
        }            
    }
    // If dragTrackerMode is unrecognized, let the normal tracker show up.
},	

//> @method listGrid.getDragTrackerProperties()
// Return properties to apply to the drag tracker when the user drags some record.<br>
// Default implementation returns an object with attribute <code>opacity</code> set 
// to <code>50</code> if +link{listGrid.dragTrackerMode} is set to <code>"record"</code>, 
// otherwise returns null.
// @group dragTracker
// @return (object | null) Properties apply to the drag tracker 
//<
getDragTrackerProperties : function () {
    var props = isc.addProperties({}, this.dragTrackerProperties);
    props.styleName = this.dragTrackerStyle;
    if (this.dragTrackerMode == "record") props.opacity = 50;
    return props;
},

//> @attr listGrid.dragTrackerStyle (CSSStyleName : "gridDragTracker" : IRW)
// CSS Style to apply to the drag tracker when dragging occurs on this grid.
// @visibility external
//<
dragTrackerStyle:"gridDragTracker",

//> @method listGrid.getDragTrackerIcon()
// Return an icon to display as a drag tracker when the user drags some record.<br>
// Default implementation: 
// If +link{listGridField.valueIcons} is specified for the title field of this grid 
// (see +link{listGrid.getTitleField()}), the appropriate value icon will be displayed.
// If no appropriate valueIcon can be found, the icon will be derived from
// +link{ListGrid.trackerImage}.<br>
// If multiple records are selected, only the first record is examined for valueIcons.
// <p>
// Note: Only called if +link{listGrid.dragTrackerMode} is set to <code>"icon"</code>. 
// @param records (Array of ListGridRecord) Records being dragged
// @return (string) Image URL of icon to display
// @group dragTracker
// @visibility external
//<
getDragTrackerIcon : function (records) {
    // we don't expect this method to fire if no records are selected, but if so, just show
    // the generic drag tracker
    var record = records ? records[0] : null,
        icon;
    if (record) {
        var titleFieldName = this.getTitleField();
        icon = this.getValueIcon(this.getField(titleFieldName), record[titleFieldName], record);
    }
    if (icon == null) icon = this.trackerImage;
    return icon;
},

//> @method listGrid.getDragTrackerTitle()
// Return "title" HTML to display as a drag tracker when the user drags some record.<br>
// Default implementation will display the cell value for the title field (see 
// +link{listGrid.getTitleField()}) for the record(s) being dragged (including any
// icons / custom formatting / styling, etc).
// <p>
// Note: Only called if +link{listGrid.dragTrackerMode} is set to <code>"title"</code>.
// @param record (ListGridRecord) First selected record being dragged
// @param rowNum (number) row index of first record being dragged 
// @return (string) Title for the row. Default implementation looks at the value of the
//                  title-field cell for the row.
// @group dragTracker
// @visibility external
//<
getDragTrackerTitle : function (record, rowNum) {
    var titleField = this.getTitleField(),
        titleFieldIndex = this.getColNum(titleField),
        cellValue = this.getCellValue(record, rowNum, titleFieldIndex);
    return "<nobr>" + cellValue + "</nobr>";
            
},

//>	@method	listGrid.dragStart()	(A)
//		@group	events, dragging
//			drag start event
//		@return	(boolean)	false non-existant record or !canDrag; true otherwise
//<
dragStart : function () {

	// if dragging means drag-selection, we do nothing until dragMove
    if (this.canDragSelect) return true;

	// get the selection
	var selection = this.selection.getSelection();
	// if the selection is empty or anything in the selection is canDrag == false, 
	//	cancel the drag by returning false
	if (!selection || selection.length == 0) return false;
	for (var i = 0; i < selection.length; i++) {
		if (selection[i].canDrag == false) return false;
	}
	
	return true;
},

dragMove : function () {
    var dropTarget = isc.EH.dropTarget;
    // if you're not allow to drag records out, cancel dragging over anything that isn't this
    // grid
    if (!this.canDragRecordsOut && dropTarget != null && 
        dropTarget != this && !this.contains(dropTarget))
    {
        return false;
    }
},

//>	@method	listGrid.dropMove()	(A)
//			Handle a dropMove event.  This will show the drag line in the appropriate position.
//		@group	events, dragging
//		@return	(boolean)	true if the list can't reorder 
//<
dropMove : function () {

	// if the list can't be reordered, bail
	if (!this.canReorderRecords) return true;

    // bail on drops from foreign widgets if not configured to accept foreign drops
    if (!this.canAcceptDroppedRecords && isc.EH.dragTarget != this) return true;
    
    // If this.willAcceptDrop() returns false, the user is hovering over a record which
    // wont accept a drop. In this case show the no-drop cursor, but still show the
    // drag-line so the user can see where they would be dropping so it's clear what's 
    // disallowed
    if (!this.willAcceptDrop()) {
        this.body.setNoDropIndicator();
    } else {        
        this.body.clearNoDropIndicator();
    }
    this.showDragLineForRecord();
},

//>	@method	listGrid.dropOut()	(A)
//		@group	events, dragging
//			handle a dragOut event
//<
dropOut : function () {
    this.body.clearNoDropIndicator();
	this.hideDragLine();
},

//>	@method	listGrid.dragStop()	(A)
// handle a dragStop event
//		@group	events, dragging
//<
dragStop : function () {
    this.body.clearNoDropIndicator();
	this.hideDragLine();
},

//>	@method	listGrid.willAcceptDrop()	(A)
//
// This method overrides +link{Canvas.willAcceptDrop()} and works as follows:<br>
// <ul>
// <li>If +link{Canvas.willAcceptDrop()} (the superclass definition) returns false, this 
//     method always returns false.  This allows +link{canvas.dragTypes} and
//     +link{canvas.dropTypes} to be used to configure eligibility for drop.  By default,
//     a ListGrid has no dropTypes configured and so this check will not prevent a drop.</li>
// <li>If this is a self-drop, that is, the user is dragging a record within this list, this is
//     an attempted drag-reorder.  If +link{ListGrid.canReorderRecords} is 
//     false, this method returns false.</li>
// <li>If the +link{EH.getDragTarget(),dragTarget} is another widget, if
//     +link{ListGrid.canAcceptDroppedRecords} is false this method returns false.</li>
// <li>If a call to +link{ListGrid.getDragData()} on the <code>dragTarget</code> fails to return
//     an record object or an array of records, this method returns false.</li> 
// <li>If a the drop target record is disabled or has +link{ListGridRecord.canAcceptDrop} 
//     set to false, return false.</li>
// </ul>
// Note that this method may be called repeatedly during a drag-drop interaction to update the
// UI and notify the user as to when they may validly drop data.
//
// @group	events, dragging
// @return (boolean) true if this component will accept a drop of the dragData
// @see ListGridRecord.canAcceptDrop
// @see ListGrid.getDragData()
//
// @visibility external
//<
willAcceptDrop : function () {

	// Use superclass implementation to check that there is a valid dragTarget, and 
	// that dragType / dropTypes (if set) match up.
	// Note - if we're dragReordering a record within this listGrid, the dragTarget will 
	// be this widget.  This is because we set up the listGrid body's dragTarget property to 
	// point back to this widget (unless this.canDragSelect is true).
	// If we're doing a drag selection, this method will not be called, as drag select doesn't
	// involve dropping.
	// Therefore if the dragTarget is this widget, we can assume we're reordering records within 
	// this widget.
	// If dropTypes are specified on this widget, and a developer wants canReorderRecords
    // behaviour, they must specify a dragType on this LV that matches a dropType -- they can
    // just make up a "reorderDragDrop" dragType/dropType.
    var EH = this.ns.EH;
    if (!this.Super("willAcceptDrop",arguments) && EH.dragTarget != this.body) return false;

    if (EH.dragTarget == this) {
    	// Bail if we're attempting to drag records within LV, and we can't reorder
        if (!this._canDragRecordsToSelf()) return false;
    } else {
    	// Bail if we're attempting to drag from elsewhere and canAcceptDroppedRecords is false
        if (!this.canAcceptDroppedRecords) return false;
    }

	// if the 'getDragData' for the dragTarget doesn't give us a suitable object (Array or
    // Object), bail
    if (!isc.isAn.Object(EH.dragTarget.getDragData())) return false; 

    isc._useBoxShortcut = true;
	// get the record being dropped on
	var rowNum = this.getEventRecordNum(),
		colNum = this.getEventFieldNum();
    var position = this.getReorderPosition(rowNum);
    if (rowNum != -2 && position == isc.ListGrid.AFTER) rowNum += 1;
    isc._useBoxShortcut = false;

	// if cursor is below the list, it's ok (may want to drop below last record)
	if (rowNum < -1) return true;
	// if the cursor is above the list, bail
    if (rowNum == -1) return false;

	// if the record is disabled or can't accept drops, return false to cancel drop
    var record = this.getRecord(rowNum, colNum);
	if (!this.recordIsEnabled(rowNum, colNum) || 
		(record != null && record.canAcceptDrop == false)) return false;
	// if we get here, it should be OK!
	return true;
},

//>	@method	listGrid._canDragRecordsToSelf()	(AR)
//		@group	events, dragging
//		Can we drag records within this LV
//<
_canDragRecordsToSelf : function () {
    return this.canReorderRecords;
},


// helper for transferSelectedData()
isValidTransferSource : function (source) {
    if (!source || !source.transferDragData) {
        this.logWarn("transferSelectedData(): " + (source ? "Invalid " : "No ") + 
                     "source widget passed in - " + (source || "") + 
                     " taking no action.");
        return false;
    }
    if (source == this) {
        this.logWarn("transferSelectedData(): target parameter contains a pointer back to this grid - ignoring");
        return false;
    }
    return true;
},


//> @method listGrid.transferSelectedData()
// Simulates a drag / drop type transfer of the selected records in some other grid to this
// listGrid, without requiring any user interaction.
// <P>
// To transfer <b>all</b> data, call grid.selection.selectAll() first.
// <P>
// See the +link{group:dragging} documentation for an overview of list grid drag/drop data
// transfer.
// 
// @param sourceGrid (ListGrid) source grid from which the records will be tranferred
// @param [index] (integer) target index (drop position) of the rows within this grid.
// @group dragging
// @example dragListMove
// @visibility external
//<
transferSelectedData : function (source, index) {
    
    if (!this.isValidTransferSource(source)) return;
            
    // don't check willAcceptDrop() this is essentially a parallel mechanism, so the developer 
    // shouldn't have to set that property directly.
    if (index == null) index = this.data.getLength()
    else index = Math.min(index, this.data.getLength());
        
        // Call transferDragData to pull the records out of our dataset
        

        // Databound dragging - if this is a databound grid, bound to the same dataSource as the source
        // widget, we're going to update the record.  We can't use transferDragData() because that will
        // delete the record we want to update.
        var dataSource = this.getDataSource(),
            sourceDS = source.getDataSource();
        if (dataSource && dataSource == sourceDS) {
            var dropRecords = source.getDragData();
        } else {        
            dropRecords = source.transferDragData();
        }
        var targetRecord = this.data.get(index);
        
        this.transferRecords(dropRecords, targetRecord, index, source);
},

//>	@method	listGrid.drop()	(A)
//			handle a drop event
//		@return	(boolean)	true if the list can't reorder or dragging did not begin from the list body;
//							false if disabled, no selection, or otherwise
//		@group	events, dragging
//<
drop : function () {

	// verify that the drop is valid
    if (this.willAcceptDrop() == false) return false;
    
	var sourceWidget = this.ns.EH.dragTarget;
	// figure out where the drop occurred
	// ASSERT: this should be a legal record to drop in!
	var dropIndex = this.getEventRecordNum();
    
    if (this.data.getLength() == 0) {
    	// if there's no data, we have to drop in position 0
        dropIndex = 0;
    } else if (this.canReorderRecords) {
    	// if dropRecord is -2, set to last record to slide after last record
    	if (dropIndex == -2) dropIndex = this.data.getLength() -1;

        var position = this.getReorderPosition(dropIndex);
        
        if (position == isc.ListGrid.AFTER) dropIndex += 1;
    }        

    // Databound dragging - if this is a databound grid, bound to the same dataSource as the source
    // widget, we're going to update the record.  We can't use transferDragData() because that will
    // delete the record we want to update.
    var dataSource = this.getDataSource(),
        sourceDS = sourceWidget.getDataSource();
    if (dataSource && dataSource == sourceDS) {
        var dropRecords = sourceWidget.getDragData();
    } else {
    // what was dragged
        dropRecords = (this.canReorderRecords && sourceWidget == this ?
                       this.selection.getSelection() :
    		
                       sourceWidget.transferDragData ? sourceWidget.transferDragData() : null);
    }               

    var targetRecord = this.data.get(dropIndex);
    
    return this.recordDrop(dropRecords, targetRecord, dropIndex, sourceWidget);
},


//> @method listGrid.recordDrop
// Process a drop of one or more records on a ListGrid record.
// <P>
// This method can be overriden to provide custom drop behaviors, and is a more appropriate
// override point than the lower level +link{Canvas.drop()} handler.
// <P>
// If this is a self-drop, records are simply reordered.
// <P>
// For a drop from another widget, +link{ListGrid.transferDragData()} is called, which
// depending on the +link{ListGrid.dragDataAction,dragDataAction} specified on the source
// widget, may either remove the source records from the original list
// (<code>dragDataAction:"move"</code>) or just provide a copy to this list
// (<code>dragDataAction:"copy"</code>).
// <P>
// If this grid is databound, the new records will be added to the dataset by calling
// +link{dataSource.addData()}.  Note that reordering records has no effect on a databound
// grid.
// <P>
// The newly dropped data is then selected automatically.
// <P>
// NOTE: for a drop beyond the last visible record of a ListGrid, <code>targetRecord</code>
// will be null and the <code>index</code> will be one higher than the last record.  This
// includes a drop into an empty ListGrid, where <code>index</code> will be 0.
// 
// @param dropRecords (List of ListGridRecord) records being dropped
// @param targetRecord (ListGridRecord) record being dropped on.  May be null
// @param index (int) index of record being dropped on
// @param sourceWidget (Canvas) widget where dragging began
// 
// @visibility external
//<
recordDrop : function (dropRecords, targetRecord, index, sourceWidget) {
    
    this.transferRecords(dropRecords, targetRecord, (this.canReorderRecords ? index : null),
                         sourceWidget);
    
	// signature "records,rowNum,viewer,sourceWidget"
    if (this.recordsDropped) this.recordsDropped(dropRecords, index, this, sourceWidget);

	// NOTE: we don't need to redraw since we're watching the data and it will change!
		
	// return false to cancel additional event processing
	return false;
},


//>	@method	listGrid.getDragData()	(A)
//
// During a drag-and-drop interaction, this method returns the set of records being dragged out
// of the ListGrid.  In the default implementation, this is the list of currently selected
// records.<p>
// 
// This method is generally called by +link{ListGrid.transferDragData()} and is consulted by
// +link{ListGrid.willAcceptDrop()}.
// 
// @group	dragging, data
//
// @return	(Array of ListGridRecord)		Array of +link{ListGridRecord}s that are currently selected.
// 
// @see ListGrid.transferDragData
// @visibility external
//<
getDragData : function () {
	var selection = this.selection.getSelection();
    return selection;
},

//>	@method	listGrid.transferDragData()	(A)
//
// During a drag-and-drop interaction, this method is called to transfer a set of records that
// were dropped onto some other component.  This method is called once it has already been
// determined that the other component can accept the drop.  What is returned and whether or
// not this ListGrid's data is modified is determined by the value of
// +link{ListGrid.dragDataAction}.
// <P>
// With a <code>dragDragAction</code> of "move", a databound ListGrid will issue "remove"
// dsRequests against it's DataSource to actually remove the data, via
// +link{dataSource.removeData()}.
//
// @return		(Array)		Array of objects that were dragged out of this ListGrid.
// 
// 
// @see ListGrid.getDragData()
// @see ListGrid.willAcceptDrop();
//
// @visibility external
//<
transferDragData : function () {
	var selection = this.getDragData();
    
    var copyData = this.dragDataAction == isc.ListGrid.COPY || 
                   this.dragDataAction == isc.ListGrid.CLONE;
	if (copyData) {
        // clear any embedded components before cloning!
        for (var i = 0; i < selection.length; i++) {
            var record = selection[i];
            if (record._embeddedComponents != null) {
                for (var ii = 0; ii <record._embeddedComponents.length; ii++) {
                    this.removeEmbeddedComponent(record, record._embeddedComponents[ii]);
                } 
            }
            delete record._embeddedComponents;
        }
		selection = isc.clone(selection);
	} else if (this.dragDataAction == isc.ListGrid.MOVE) {
    	// de-select the selection in the context of this list
		//	so if it is dragged *back* into the list, it won't already be selected!
		this.selection.deselectList(selection);
    	    
        if (this.dataSource) {
            var wasAlreadyQueuing = isc.rpc.startQueue();
            for (var i = 0; i < selection.length; i++) {
                this.getDataSource().removeData(selection[i]);
            }
            // send the queue unless we didn't initiate queuing
            if (!wasAlreadyQueuing) isc.rpc.sendQueue();
        } else {
    		this.data.removeList(selection);
        }
	}
    
    
	return selection;
},

// --------------------------------------------------------------------------------------------

viewRow : function (rowNum) {
    this.getDataSource().viewFile(this.getRecord(rowNum));
},

downloadRow : function (rowNum) {
    this.getDataSource().downloadFile(this.getRecord(rowNum));
},

//>	@method	listGrid.autoSizeColumn()	(A)
//	    @group	sizing, positioning
//
//      Can only be called after draw()
//
//      Resize this column to the size it needs to be in order to accomodate it's contents.
//<
autoSizeColumn : function (columnNum) {
	// determine the auto-size
    var columnWidth = this.body.getColumnAutoSize(columnNum);

	// resize the field
    this.resizeField(columnNum, columnWidth);
},

//>	@method	listGrid.getRecord()	(A)
// Return the pointer to a particular record by record number.
// Synonym for +link{ListGrid.getCellRecord()}.
//
// @see ListGrid.getCellRecord()
// @see ListGrid.getEditedRecord()
// @param recordNum	 (number) row index of record to return.
// @return (ListGridRecord) Record object for the row.
// @visibility external
//<  
getRecord : function (rowNum, colNum) {
	return this.getCellRecord(rowNum, colNum);
},

//>	@method	listGrid.getCellRecord()	(A)
// Return the pointer to a particular record by record number.<br>
// Notes:<br>
// - If this is a databound grid, and the record for some row has not yet been loaded, 
//   returns the +link{Array.LOADING} marker, and a fetch will be initialized to retrieve the
//   record from the server.<br>
// - If this is a new row in editable ListGrid, and has not yet been saved, this method will
//   return null.
// @see ListGrid.getRecord()
// @see ListGrid.getEditedRecord()
// @param recordNum	 (number) row index of record to return.
// @return (ListGridRecord) Record object for the row.
// @visibility external
//<
getCellRecord : function (rowNum, colNum) {
    if (!isc.isA.Number(rowNum)) {
        this.logWarn("getCellRecord called with bad rowNum: " + this.echo(rowNum)
        // + this.getStackTrace()
        );
        return;
    }
	// ListGrid assumes one record per row
	// Note - this.getTotalRows() may return a value higher than this.data.length. Don't
	// try to fetch records beyond the end of the dataset
    if (!this.data || rowNum >= this.data.getLength()) return null;

	var record = this.data.get(rowNum);
    if (this._hasUnmatchedEdits) this._testRowEditData(record,rowNum);
    return record;
},


// Internal method to map edit data for some record to that record's rowNum.

_testRowEditData : function (record, rowNum) {
    if (record == null || record[this.editValuesTestedProperty]) return;

    if (this._editRowMap == null) this._editRowMap = {};
    var noUnmatchedEdits = true;

    for (var i in this._editSessions) {
        var vals = this._editSessions[i];
        if (vals != null && vals._rowNum == null) {
            if (this.comparePrimaryKeys(record, vals._primaryKeys)) {
                vals._rowNum = rowNum;
                this._editRowMap[rowNum] = i;
            } else {
            	// We use 'noUnmatchedEdits' to determine whether we have a rowNum for every 
            	// record in this._editValuesArray.
            	// This is used to update the '_hasUnmatchedEdits' flag allowing us to avoid this
            	// method entirely when we have matched every set of edit values to a rowNum.
            	// Note - if this record is the last unmatched edit, and it matches the record,
            	// we  leave this flag set to true, and avoid firing this method again.
                noUnmatchedEdits = false;            
            }
        }
    }
    
    if (noUnmatchedEdits) delete this._hasUnmatchedEdits;
    record[this.editValuesTestedProperty] = true;
},

//>	@method	listGrid.comparePrimaryKeys()	([AI])
//  Compare a record and a primaryKeys object, returning true if the primary keys match the
//  record.
//  @group  data
//  @param  record  (object)    Record to compare to primary keys object
//  @param  keys    (object)    set of primary keys / values
//  @return (boolean)   True if the primary keys match the record.
//<
comparePrimaryKeys : function (record, keys) {
    var rKeys = this.getPrimaryKeys(record);
    
	// For local data sets we use a pointer to the record object as primary keys
    if (!this.dataSource || this.saveLocally) return (rKeys == keys);
    
    for (var keyField in rKeys) {
        if (rKeys[keyField] != keys[keyField]) return false;
    }
    return true;
    
},

// Returns unique primary keys for a record.
// Use 'comparePrimaryKeys()' to compare against some record.

getPrimaryKeys : function (record) {
    
    if (this.dataSource == null || this.saveLocally) return record;
    
    var ds = this.getDataSource(),
        pkArray = ds.getPrimaryKeyFieldNames(),
        keys = {};

    if (!isc.isAn.Array(pkArray)) pkArray = [pkArray];
            
    for (var i = 0; i < pkArray.length; i++) {
        keys[pkArray[i]] = record[pkArray[i]]
    }
    return keys;
},

//>	@method listGrid.getTotalRows()
// Return the total number of rows in the grid.
// <P>
// Note that, when creating new rows via inline editing, this can be more than the total number
// of rows in the dataset (that is, grid.data.getLength())
// @visibility external
//<
// Override 'getTotalRows' - the total set of rows for the grid are the length of the data, and
// any unsaved edit rows beyond the last record.
getTotalRows : function () { 

    if (this.data == null) return 0;
    var totalRows = this.data.getLength(),
        lastEditRow = this._getLastEditRow();
    if (lastEditRow != null && lastEditRow+1 > totalRows) totalRows = lastEditRow+1;

    if (this.showNewRecordRow) totalRows += 1;

    return totalRows;
},

// Internal method to return the last (highest value) row for which we have edit values.
// Note: returns -1 if we have no edit values for any rows.
_getLastEditRow : function () {
    
	// Cache the last edit row for performance reasons.  We update this in the methods to 
	// set / clear edit values
    if (this._lastEditRow == null) {
        var lastER = -1,
            allEditRows = (this._editRowMap ? isc.getKeys(this._editRowMap) : []);
        for (var i = 0; i < allEditRows.length; i++) {    
        	// Note the 'parseInt' is required, because the rowNums returned are strings rather
        	// than numbers
            var currentER = parseInt(allEditRows[i]);
            if (currentER > lastER) lastER = currentER;
        }
        this._lastEditRow = lastER;
    }

    return this._lastEditRow;
},

//>	@method	listGrid.recordIsEnabled()	(A)
//		@group	selection, appearance
//			return if record recordNum is enabled
//			note: also returns false if the <code>record[this.isSeparatorProperty]</code> is true
//		@param	recordNum		(number)	record number to test for enabled
//
//		@return	(boolean)	whether this record is enabled or not
//<
recordIsEnabled : function (row, col) {
	var record = this.getCellRecord(row, col);
	// XXX if we're drawing a sparse table (not guaranteed a record for every row/cell), should we
	// consider the empty spots to be selectable?  In a grid, seems like yes, in a list, probably
	// not..
	if (record == null) return true; 
    
	return (record.enabled != false && record[this.isSeparatorProperty] != true);
},

cellIsEnabled : function (row, col) { return this.recordIsEnabled(row, col); },

//>	@method	listGrid.getCellField()	(A)
//      Takes rowNum / colNum as parameters.
//		Return the pointer to the field structure for a cell
//
//		@group	display
//		@param	rowNum  (number)    Row Index of the cell
//      @param  colNum  (number)    Column index of the cell
//
//		@return	(object)	Field description
//<
getCellField : function (rowNum, colNum) {
    return this.getField(colNum);
},

//>	@method	listGrid.getFields()
// Get the array of all <b>currently visible</b> fields for this ListGrid.
// <P>
// This list fields is only valid once the ListGrid has been +link{draw(),drawn} or once
// +link{setFields()} has been called explicitly.  If called earler, only the list of directly
// specified fields will be returned (the Array passed to create()).
// <P>
// This Array should be treated as <b>read-only</b>.  To modify the set of visible fields, use
// +link{showField()}, +link{hideField()} and related APIs.  To update properties of individual
// fields, use +link{setFieldProperties()} or more specific APIs such as
// +link{setFieldTitle()}.
// <P>
// To get the Array of all fields, including fields that are not currently visible or were
// specified implicitly, use +link{getAllFields()}.
//
// @return (Array of ListGridField) Array of all currently visible fields
//<
getFields : function () {
    return this.fields;
},

//> @method listGrid.getAllFields()
// Get the complete array of fields for this ListGrid, including fields that are not currently
// visible or were specified implicitly via +link{listGrid.dataSource}.
// <P>
// This list fields is only valid once the ListGrid has been +link{draw(),drawn} or once
// +link{setFields()} has been called explicitly.  If called earler, only the list of directly
// specified fields will be returned (the Array passed to create()).
// <P>
// This Array should be treated as <b>read-only</b>.  To modify the set of visible fields, use
// +link{showField()}, +link{hideField()} and related APIs.  To update properties of individual
// fields, use +link{setFieldProperties()} or more specific APIs such as
// +link{setFieldTitle()}.
//
// @return (Array of ListGridField) Array of all fields in the ListGrid
// @visibility external
//<
getAllFields : function () {
    return this.completeFields || this.fields;
},

//>	@method	listGrid.getSpecifiedField()	(A)
// Looks up a field object by name or position.
// <p>
// Returns the field from this.completeFields (if available) rather than this.fields,
// allowing you to get a pointer to any field in the completeFields array
//
//		@group	display
//
//		@param	fieldID		(string || number || ListGridField)	
//          field number or field.name. If passed a field, it will be returned.
//		@return	(object)	Field description
//<
// XXX This isn't an ideal name - really it's a function to 'getFieldFromCompleteFieldsArray()'.
// We may rename this.completeFields to this.fields, and this.fields to this.visibleFields - when
// this refactoring occurs, this method will become this.getField(), and the current 'getField()' 
// method will become this.getVisibleField()
getSpecifiedField : function (fieldID) {
    var fields = this.completeFields;
    if (fields == null) fields = this.fields;
    
    if (isc.isAn.Object(fieldID)) {
        if (fields.contains(fieldID)) return fieldID;
        // Catch the case where we're passed a field that's not present in our 
        // fields/completeFields array.
        return null;
    
    } else if (isc.isA.String(fieldID)) return fields.find(this.fieldIdProperty, fieldID);
     else return (fields[fieldID]);
},


//>	@method	listGrid.getFieldName()	(A)
// Given a column number or field id, return the field name of a field.
//		@group	display
//		@param	colNum      (number or id)	number or id of the field.
//		@return	(string)	Name of the field.
//      @visibility external
//<
getFieldName : function (fieldNum) {
    var field = this.getField(fieldNum);
    return field ? field[this.fieldIdProperty] : null;
},

//> @method listGrid.getField()
// Given a column number or field name, return the field definition.
// <P>
// When using +link{attr:DataBoundComponent.fields,DataBinding}, the field definition may be
// a mix of information derived from +link{listGrid.fields} and +link{listGrid.dataSource}.
//
//		@param	colNum      (number or ID)	number or id of the field.
//		@return	(ListGridField)	field definition
//      @visibility external
//<
// NOTE: implemented on Canvas

//>	@method	listGrid.getFieldNum()	(A)
//		Given a field or field id, return it's index in the fields array
//		@group	display
//		@param	fieldID		(string || number)	field number or field.name
//		@return	(string)	index of the field within this.fields
//      @visibility external
//<
// NOTE: implemented on Canvas

// make 'getColNum' a synonym of getFieldNum() since it's common to refer to 'colNum's 
getColNum : function (fieldId) {
    return this.getFieldNum(fieldId);
},


//>	@method	listGrid.getFieldTitle()	(A)
//		Return the title of particular field, specified by number.
//		@group	display
//
//		@param	fieldNum		(number)	number of the field.
//
//		@return	(string)	Field title.
//<
getFieldTitle : function (fieldNum) {

	var field;
    // Allow a field object to be passed in -- useful if the field is currently hidden, so
    // not present in this.fields
    if (isc.isAn.Object(fieldNum)) field = fieldNum;
    else field = this.fields[fieldNum];
    
	if (!field) return "Unknown field";

	// if the field specifies a "getFieldTitle" method, call that
	if (field.getFieldTitle) {
		// CALLBACK API:  available variables:  "viewer,fieldNum"
		// Convert a string callback to a function
		isc.Func.replaceWithMethod(field, "getFieldTitle", "viewer,fieldNum");

		return field.getFieldTitle(this, fieldNum);
	}

	// otherwise just return the title of the field, or failing that, the field's name
	return field.title || field.name;
},

//>	@method	listGrid.getSummaryTitle()	(A)
// Return the summary title of particular field.  This is the title of
// the field to be used in the show / hide fields context menu. Default implementation will
// use  +link{listGridField.getSummaryTitle()} or +link{ListGridField.summaryTitle} if specified,
// otherwise +link{listGridField.title}.
// @group i18nMessages
// @group display
// @param field (listGridField) field for which we're returning the title
// @return	(string)	Field summary title.
// @visibility external
//<
getSummaryTitle : function (field) {
    var title;
    // If the custom 'summary title' has been specified on the field, use that.
    if (field.getSummaryTitle != null) {
        // CALLBACK API:  available variables:  "viewer,field"
        // Convert a string callback to a function
        isc.Func.replaceWithMethod(field, "getSummaryTitle", "viewer,field");
        title = field.getSummaryTitle(this, field);
    } else if (field.summaryTitle != null) {
        title = field.summaryTitle;
    } else {
        title = this.getFieldTitle(field);
    }
    
    return title;
},
                 

//>	@method	listGrid.setValueMap()	
// Set the +link{listGridField.valueMap, valueMap} for a field.
// See also the +link{ListGrid.setEditorValueMap(), setEditorValueMap()}
// and +link{ListGrid.getEditorValueMap(), getEditorValueMap()} methods which allow further 
// customization of the valueMap displayed while the field is in edit mode.
//
//		@param	fieldID		(string || number)	Name or number of field to update
//      @param  map         (object)            ValueMap for the field
// @visibility external
//<
setValueMap : function (fieldID, map) {

    this.Super('setValueMap', arguments);
    if (this._editorShowing) {
        var fieldName, field;
        var fieldNum = this.getColNum(fieldID);
        // don't crash on hidden fields / bad fieldNames that don't exist
        if (fieldNum != -1 && fieldNum < this.fields.length) {
            var field = this.getField(fieldID),
                fieldName = field[this.fieldIdProperty];
            this._editRowForm.setValueMap(
                fieldName, 
                this.getEditorValueMap(field, this.getEditedRecord(this.getEditRow(), fieldNum))
            );
        }
    }
    if (this.isDrawn() && this.isVisible()) {
        this._markBodyForRedraw("setValueMap");
    }        
},

//>	@method	listGrid.getData()
//		Get the data that is being displayed and observed
//		@return	(object)	The data that is being displayed and observed
//<
getData : function () {
	return this.data;
},

//> @method listGrid.getRecordIndex()
// Get the index of the provided record.
// <P>
// This is essentially the same as calling listGrid.data.indexOf(record), except that 
// the currently visible range of records is checked first.  This is important for
// responsiveness in functions that respond to user actions when the user is working near the
// end of a very large dataset (eg 500k records).
//
// @param record (ListGridRecord) the record whose index is to be retrieved
// @return index (Number) index of the record, or -1 if not found
//
// @visibility external
//<
getRecordIndex : function (record) {
    var index = -1;
    if (this.body && this.body.isDrawn()) {
        index = this.data.indexOf(record, this.body._firstDrawnRow, this.body._lastDrawnRow);
    }
    if (index == -1) index = this.data.indexOf(record);
    return index;
},


//> @method listGrid.getRecordCellIndex()
// Get the row and column index of the provided record.
// <P>
// This only applies to grids that show 1 record per cell - such as the CubeGrid class
// 
// @param record (ListGridRecord) the record whose index is to be retrieved
// @return cell (Array) 2 element array containing the rowNum and colNum of the record 
//                      (or -1 in both slots if not found)
//
// @visibility internal
//<
getRecordCellIndex : function (record) {
    return [this.getRecordIndex(), 0];
},


//>	@method	listGrid.getEventRow()
// @include gridRenderer.getEventRow()
// @group events
// @visibility external
//<
getEventRow : function (y) {

	// If we're over the header, bail
	// XXX this works, but is a little kludgey - ideally we'd not call getEventRow() unless
	// we were over the body.
    if (this.header && this.header.containsPoint(this.ns.EH.getX(), this.ns.EH.getY())) {
        return -1;
    }
    
    return this.body.getEventRow(y);
},

//>	@method	listGrid.getEventColumn()
// @include gridRenderer.getEventColumn()
// @group events
// @visibility external
//<
getEventColumn : function (x) {
    return this.body.getEventColumn(x);
},

// local synonyms reflect ListGrid's row<->record, column<->field convention
getEventRecordNum : function (y) {
    return this.getEventRow(y);
},
getEventFieldNum : function (x) {
    return this.getEventColumn(x);
},

getReorderPosition : function (recordNum, y) {

	// If a y-coordinate was not passed, get it from the offset of the last event
	if (y == null) y = this.body.getOffsetY();
    
	// which row is the mouse over?
    if (recordNum == null) recordNum = this.getEventRow(y);

	// -2 implies we're past the end of the list
	if (recordNum == -2) return isc.ListGrid.AFTER;

	// a number greater than the number of records in the list implies we're past the end
	// of the list, so we want to return before since it's meaningless to position after a
	// non existant row -- we'll actually just be dropping at the end of the list.
    if (recordNum >= this.getTotalRows()) return isc.ListGrid.BEFORE;

    var recordTop = this.body.getRowTop(recordNum),
        recordHeight = this.body.getRowSize(recordNum);
  
	// Top half, drop above, bottom half drop below
    if (y > Math.round(recordTop + recordHeight/2)) {
        return isc.ListGrid.AFTER;
    } else {
        return isc.ListGrid.BEFORE;
    }        
},

getDropRecordNum : function (recordNum, reorderPosition) {
    if (recordNum == null) recordNum = this.getEventRow();
    if (reorderPosition == null) reorderPosition = this.getReorderPosition(recordNum);
    
    return recordNum + (reorderPosition == isc.ListGrid.AFTER ? 1 : -1);
},


// selectionChanged is passed through from the GR - include documentation for it.  
//>	@method	listGrid.selectionChanged()
// @include gridRenderer.selectionChanged()
// @example multipleSelect
//<
    


getSerializeableFields : function (removeFields, keepFields) {
	removeFields.addList(["header", "selection"]);
		
	return this.Super("getSerializeableFields", arguments);
},

// Frozen Fields / Frozen Columns
// ---------------------------------------------------------------------------------------

// detect frozen fields and reoder the fields array to place frozen fields first, also
// establishing this.frozenFields vs this.normalFields.
// Called by deriveVisibleFields(), which in turn is called by setFields and in other
// circumstances where the set of visible fields has changed or been reordered.  
// this.fields is assumed to contain only visible fields.
deriveFrozenFields : function () {
    // detect frozen fields
    var frozenFields = this.frozenFields = this.fields.findAll("frozen", true);
    var allFrozenFields = this.completeFields.findAll("frozen", true);    

    // Exception - disallow having all frozen fields and no 'unfrozen' fields
    // Our code doesn't currently handle this and it's not clear what the expected behavior would
    // be!
    if (frozenFields && frozenFields.length == this.fields.length) {
        frozenFields = this.frozenFields = null;
        // setting this flag lets us know that if we show additional, unfrozen fields
        // we'll have to do a rebuild to properly "freeze" the frozen fields!
        this._suppressedFrozenFields = true;
    } else this._suppressedFrozenFields = false;

    if (frozenFields) {
        // reorder the main fields array to put frozen fields on left or right
        this.fields.slideList(frozenFields, this.freezeLeft() ? 0 : this.fields.length);
        this.completeFields.slideList(allFrozenFields, this.freezeLeft() ? 0 : this.completeFields.length);

        // does not currently work
        this.resizeFieldsInRealTime = false;
    } 

    for (var i = 0; i < this.fields.length; i++) {
        var field = this.fields[i];
        // mark all fields with a masterIndex - their index in the master fields Array
        // (listGrid.fields)
        field.masterIndex = i;
    }

    if (frozenFields) {
        // put together the normal fields for the primary body (excludes frozen fields)
        var normalFields = this.normalFields = [];
        for (var i = 0; i < this.fields.length; i++) {
            var field = this.fields[i];
            if (!field.frozen) normalFields.add(field);
        }
    } else this.normalFields = null;

    
},

// rebuild for possible change in frozen fields.  Can be called as an alternative to
// a full setFields() when only the frozenness of fields has changed.  Unlike setFields(), this
// ends inline editing.

_$toggleFrozen:"toggle frozen fields",
rebuildForFreeze : function (forceRebuild) {
    
    if (!this.body) return; // children have not been created
    // If we're showing a filterEditor, essentially rebuild it for freeze, but without
    // killing the current edit.
    // Do this BEFORE we rebuild ourselves so setBodyFieldWidths() can correctly update
    // the form items on the rebuild filter editor body
    if (this.filterEditor) {
        this.filterEditor.deriveVisibleFields();
        this.filterEditor.updateBody(forceRebuild);
        this.filterEditor.remapEditFieldsForFreeze();
        this.filterEditor.layoutChildren(this._$toggleFrozen);
    }
    this.endEditing();

    this.deriveVisibleFields();

    // NOTE: will destroy old header and re-create.  Always happens for any change in fields
    this.updateHeader();
    
    // will recreate bodies if necessary, otherwise just refresh fields
    this.updateBody(forceRebuild);

    this.layoutChildren(this._$toggleFrozen);
},

//> @method ListGrid.setCanFreezeFields()
// Setter method for +link{ListGrid.canFreezeFields}
// @param canFreeze (boolean) New value for <code>listGrid.canFreezeFields</code>
// @visibility external
//<
setCanFreezeFields : function (canFreeze) {
    this.canFreezeFields = canFreeze;
    delete this._autoDerivedCanFreeze;
},

// refresh the "masterIndex" property on subcomponents that have been created with a copy of
// the fields array
refreshMasterIndex : function () {
    if (!this.body) return;
    if (this.header) this._refreshMasterIndexForFields(this.header.getMembers());
    if (this.body) this._refreshMasterIndexForFields(this.body.fields);
    if (!this.frozenFields) return;
    if (this.frozenHeader) this._refreshMasterIndexForFields(this.frozenHeader.getMembers());
    if (this.frozenBody) this._refreshMasterIndexForFields(this.frozenBody.fields);
},
_refreshMasterIndexForFields : function (fields) {
    for (var i = 0; i < fields.length; i++) {
        fields[i].masterIndex = this.fields.findIndex("name", fields[i].name);
    }
},

getFreezeOn : function () {
    return (this.freezeOn != null ? this.freezeOn : 
                this.isRTL() ? "right" : "left");
},

// whether frozen columns are on the left or right side
freezeLeft : function () {
    return this.getFreezeOn() == "left";
},

getLeftBody : function () {
    return this.frozenFields && this.freezeLeft() ? this.frozenBody : this.body;
},

getRightBody : function () {
    return this.frozenFields && !this.freezeLeft() ? this.frozenBody : this.body;
},

setFreezeOn : function (side) {
    var oldSide = this.get
    this.freezeOn = side;
    if (side != oldSide) this.rebuildForFreeze(true);
},

// given an Array, return a subArray of just the slots corresponding to the frozen fields
// (getFrozenSlots) or unfrozen fields (getUnfrozenSlots).  Can be used on an Array of fields,
// or an Array containing any other value that corresponds 1 to 1 with the fields, such as
// field sizes
getFrozenSlots : function (array) {
    var frozenFields = this.frozenFields;
    if (!frozenFields) return array;
    return this.freezeLeft() ? array.slice(0, frozenFields.length) :
                               array.slice(array.length - frozenFields.length);
},
getUnfrozenSlots : function (array) {
    var frozenFields = this.frozenFields;
    if (!frozenFields) return array;
    return this.freezeLeft() ? array.slice(frozenFields.length) :
                               array.slice(0, array.length - frozenFields.length);
},

fieldIsFrozen : function (colNum) {
    if (!this.frozenFields) return false;

    var field = this.getField(colNum);
    return field && field.frozen;
},

// frozen fields column numbering:
// - frozen fields do appear in this.fields, always first or last depending on which side the
//   frozen body apppears on
// - both header buttons and the fields passed to the body/frozenBody have a masterIndex
//   property indicating their index in this.fields 
// - events coming from either body will have a colNum that matches the index in this.fields.
//   This is done via remapping the colNum in makeBodyMethods
// - if you have a colNum with respect to this.fields:
//   - getFieldBody()/getFieldHeader() will give you the body (GR instance) or header (Toolbar
//     instance) where that column appears
//   - getLocalFieldNum() will give you the field/column number within that component

// return the "body" where a column is rendered
getFieldBody : function (colNum) {
    if (!this.frozenFields) return this.body;
    return this.fieldIsFrozen(colNum) ? this.frozenBody : this.body;
},

// return the "header" where a column is rendered
getFieldHeader : function (colNum) {
    if (!this.frozenFields) return this.header;
    return this.fieldIsFrozen(colNum) ? this.frozenHeader : this.header;
},

// given a colNum, return the index for that column in the body or header where it appears
getLocalFieldNum : function (colNum) {
    if (!this.frozenFields) return colNum;

    var offset = this.freezeLeft() ? this.frozenFields.length : 0;

    // if column is in main body, subtract number of frozen fields if fields are frozen on left
    if (!this.fieldIsFrozen(colNum)) return colNum - offset;

    // otherwise, column is in frozen body.  
    return this.freezeLeft() ? colNum 
                             : colNum - (this.fields.length - this.frozenFields.length);
},

// given a colNum within the body / frozen body, return the 'fieldNum' in our fields array
getFieldNumFromLocal : function (localColNum, body) {
    if (!this.frozenFields) return localColNum;
    
    if (body == this.frozenBody) {
        if (this.freezeLeft()) return localColNum;
        else {
            var unfrozen = this.fields.length - this.frozenFields.length;
            return localColNum + unfrozen;
        }
    } else {
        var offset = this.freezeLeft() ? this.frozenFields.length : 0;
        return localColNum + offset;
    }
},

// map various methods through to the appropriate body.
// if this set continues to grow, we may want to take a code generation approach instead
getColumnLeft : function (colNum) {
    var body = this.getFieldBody(colNum);
    return body.getColumnLeft(this.getLocalFieldNum(colNum));
},

getColumnPageLeft : function (colNum) {
    var body = this.getFieldBody(colNum);
    return body.getColumnPageLeft(this.getLocalFieldNum(colNum));
},

getColumnWidth : function (colNum) {
    var body = this.getFieldBody(colNum);
    return body.getColumnWidth(this.getLocalFieldNum(colNum));
},

refreshCellStyle : function (rowNum, colNum, className) {
    var body = this.getFieldBody(colNum);
    return body.refreshCellStyle(rowNum, this.getLocalFieldNum(colNum), className);
},

//> @method listGrid.freezeField()
// Freeze the indicated field, so that it remains in place and visible when horizontal
// scrolling occurs.
//
// @param field (ListGridField or colNum or ListGridField.name)
// @group frozenFields
// @visibility external
//<
freezeField : function (field) {
    return this.toggleFrozen(field, true);
},

//> @method listGrid.unfreezeField()
// Unfreeze a frozen field, so that it will now scroll along with other fields when horizontal
// scrolling occurs.
//
// @param field (ListGridField or colNum or ListGridField.name)
// @group frozenFields
// @visibility external
//<
unfreezeField : function (field) {
    return this.toggleFrozen(field, false);
},

//> @method listGrid.toggleFrozen()
// Freeze or unfreeze the indicated freeze according to whether it is currently frozen.
// <P>
// Called when the ListGrid freezes or unfreezes fields by user action.
//
// @param field (ListGridField or colNum or ListGridField.name)
// @group frozenFields
// @visibility external
//<
toggleFrozen : function (field, isFrozen) {
    var field = this.getField(field);
    if (!field || !this.fieldIsVisible(field) || this.isCheckboxField(field)) return;
    
    if (field.frozen == isFrozen) return false; // field frozeness did not change

    field.frozen = isFrozen;

    this.rebuildForFreeze();
    
    return true; // field frozeness changed
},

// Body
// --------------------------------------------------------------------------------------------

// update the body for a change in fields
updateBody : function (forceRebuild) {
    // if frozen fields are being introduced or going away entirely, recreate the body[s] and
    // bodyLayout.  Otherwise, just refresh the fields array being used by each body.
    if (forceRebuild ||
        (this.frozenFields && !this.frozenBody) || 
        (this.frozenBody && !this.frozenFields)) 
    {
        if (this.frozenFields) {
            this._showUnfrozenRollOverCanvas = this.showRollOverCanvas;
            this._showUnfrozenSelectionCanvas = this.showSelectionCanvas;
            this.showRollOverCanvas = false;
            this.showSelectionCanvas = false;
            if (this._showUnfrozenRollOverCanvas) this.updateRollOverCanvas();
            if (this._showUnfrozenSelectionCanvas) this.updateSelectionCanvas();
        } else {
            if (this._showUnfrozenRollOverCanvas) this.showRollOverCanvas = true;
            if (this._showUnfrozenSelectionCanvas) this.showSelectionCanvas = true;
            delete this._showUnfrozenRollOverCanvas;
            delete this._showUnfrozenSelectionCanvas;
        }
        // frozen body being introduced or going away, or freeze side changing
        if (this.bodyLayout) this.bodyLayout.destroy();
        if (this.body) this.body.destroy();
        this.body = this.bodyLayout = this.frozenBody = null;
        this.createBodies();
    }

    if (this.body) {
        this.body.fields = this.normalFields || this.fields;
        this.body.markForRedraw("fields change");
    }
    if (this.frozenBody) {
        this.frozenBody.fields = this.frozenFields;
        this.frozenBody.markForRedraw("fields change");
    }
},

createBodies : function () {
    if (this.body != null) return; // already created

	// create the primary body and add it as a child
    this.body = this.createBody(this.ID + "_body", this.normalFields || this.fields);
    
    this.bodies = [this.body];

    var frozenFields = this.frozenFields;
    if (!frozenFields) {
        this.addChild(this.body);
        return;
    }
    

    this.frozenBody = this.createBody(this.ID + "_freezeBody", frozenFields, true);  
    
    // NOTE: Freezing the fields on the left implies we almost certainly have an HScrollbar
    // for the fields on the right, creating a difference in viewport area
    // Add some space to the bottom of the freeze body to make up this difference in the
    // scrollHeight so when the user scrolls to the bottom the grids stay in synch
    if (this.body.hscrollOn && !this.shrinkForFreeze) {
        this.frozenBody.setEndSpace(this.body.getScrollbarSize());
    }
    
    // observe adjustOverflow on the body - if the hscrollbar is added / removed we'll need 
    // to update the frozen body's endSpace
    this.observe(this.body, "adjustOverflow", "observer.bodyOverflowed()");
        
    if (this.freezeLeft()) {
        this.bodies.unshift(this.frozenBody);
    } else {
        this.bodies.add(this.frozenBody);
    }

    this.addAutoChild("bodyLayout", {
        autoDraw:false,
        members : this.bodies
    }, isc.HLayout)
    
},

// bodyOverflowed - notification method when adjustOverflow runs on the body
// Updates the endSpace on this.frozenBody if we're showing frozen cells.
bodyOverflowed : function () {
    if (!this.frozenBody) return;
    this.frozenBody.setEndSpace(this.body.hscrollOn && !this.shrinkForFreeze 
                                    ? this.body.getScrollbarSize() : 0);
},

createBody : function (ID, fields, frozen) {
	// create a body object to show the body of the list
    var body = isc.ClassFactory.getClass(this.bodyConstructor).createRaw();

    body.ID = ID;
    body.autoDraw = false;
    
    body.grid = this;
        
    body.fields = fields;
    
    body.overflow = frozen ? "hidden" : this.bodyOverflow;
    if (frozen) {
        // Essentially a duplication of the standard scrolling code for when scrollbars are
        // showing. 
        body.mouseWheel = function () {
            var wheelDelta = this.ns.EH.lastEvent.wheelDelta;
            var scrollTo = this.scrollTop + Math.round(wheelDelta * this.scrollWheelDelta);
            this.scrollTo(this.getScrollLeft(), scrollTo);
            return false;
        } 
    }
    body.backgroundColor = this.bodyBackgroundColor;
    var bodyStyleName = this.bodyStyleName;
    if (this.alternateBodyStyleName != null && this.alternateRecordStyles) { 
        bodyStyleName = this.alternateBodyStyleName;
    }
    body.styleName = bodyStyleName;
        
    // In order to float widgets above the list, we want to allow contents (the
    // actual table) and children to be drawn for this element.
    body.allowContentAndChildren = true;
        
    // table geometry (NOTE: record -> row terminology translation)
    
    body.fixedRowHeights = this.fixedRecordHeights;
    body.fixedColumnWidths = this.fixedFieldWidths;
    body.alternateRowStyles = this.alternateRecordStyles;
    body.alternateRowFrequency = this.alternateRecordFrequency;
    body.showAllRows = this.showAllRecords;
    if (this.virtualScrolling != null) body.virtualScrolling = this.virtualScrolling;
        
    // Default the tabIndex of the body to match the tabIndex for this widget.
    // See the comments by listGrid._setTabIndex() for how listGrids manage
    // tab index
    body.tabIndex = this.getTabIndex();
        
    // if using drag selection, don't give the Grid a dragTarget
    // - the Grid can handle the selection
    // - the ListGrid won't show a dragTracker
    // Otherwise we're doing dragging of records in and out, so have the ListGrid
    // handle the drag event, and show a tracker.
    body.dragTarget = this.canDragSelect ? null : this;
    body.dragAppearance = isc.EventHandler.NONE;
    
    // For AutoTest APIs
    body.locatorParent = this;

	// support for defining GridRenderer override functions and properties directly
	// on the LV instead of via LV.body.
    var propNames = isc.ListGrid._gridPassthroughProperties;
                
	// pass all of these properties straight through
    for (var i = 0; i < propNames.length; i++) {
        var propName = propNames[i],
            value = this[propName];
        
        if (value != null) body[propName] = value;
    }

    isc.addProperties(body, this.bodyDefaults, this.bodyProperties);
    
	// add passthroughs from the body to the ListGrid for pluggable body APIs defined on the grid
    this._addBodyPassthroughMethods(body);

    body.completeCreation();
    return body;
},

// Freezing and editing
// By default in edit mode we allow form items to overflow the available space (don't fix the edit
// However if we have frozen fields we can have form items of different heights in the 2 bodies
// leading to a mismatch.
// Catch this if we can by applying an explicit min-height matching the space that will be
// required by the edit items (for efficiency only run this logic if we have to)
getRowHeight : function (record,rowNum) {
    var cellHeight = this.cellHeight;
    if (this.frozenFields && this.getEditRow() == rowNum) {
        var editForm = this.getEditForm(),

            items = editForm ? editForm.getItems() : [];
        for (var i = 0; i < items.length; i++) {
            var itemHeight = (items[i].getHeight() + 2*this.cellPadding);            
            if (itemHeight > cellHeight) cellHeight = itemHeight;  
        }
    }
    return this.body.updateHeightForEmbeddedComponents(record, rowNum, cellHeight);
},

// arbitrary selectionCanvasDefaults so the canvas is visible
selectionCanvasDefaults : {
    //backgroundColor:"green",
    opacity:20    
},

selectionUnderCanvasDefaults : {
    //backgroundColor:"blue"
},

// Selection / RollOver effect canvases
makeSelectionCanvas : function (record) {
    this.selectionCanvas = this.createAutoChild("selectionCanvas",
        {   
            eventProxy:this.body,
            snapTo:"TL",
            width:"100%", height:"100%",
            destroyOnUnEmbed:false,
            percentSource:this, percentBox:"custom",
            grid:this,
            autoDraw:false
        }
    );
    this.selectionUnderCanvas = this.createAutoChild("selectionUnderCanvas",
        {
            eventProxy:this.body,
            snapTo:"TL",
            width:"100%", height:"100%",
            destroyOnUnEmbed:false,
            percentSource:this, percentBox:"custom",
            grid:this,
            autoDraw:false
        }
    );
},

getSelectionCanvas : function () {
    if (!this.selectionCanvas) this.makeSelectionCanvas();
    return this.selectionCanvas;
},
getSelectionUnderCanvas : function () {
    if (!this.selectionUnderCanvas) this.makeSelectionCanvas();
    return this.selectionUnderCanvas;
},

updateSelectionCanvas : function () {
    var selection = this.selection, rowNum, colNum, record;
    
    if (isc.isA.CellSelection(selection)) {
        var cell = selection.getSelectedCells()[0];
        rowNum = cell ? cell[0] : -1,
        colNum = cell ? cell[1] : -1;
        record = cell ? this.getCellRecord(rowNum,colNum) : null;
        
    } else {
        var record = this.getSelectedRecord();
        rowNum = this.data ? this.data.indexOf(record) : -1;
    }
    var selectionCanvas = this.selectionCanvas,
        currentRecord = selectionCanvas ? selectionCanvas.embeddedRecord : null,
        currentRowNum = selectionCanvas ? selectionCanvas._currentRowNum : -1,
        currentColNum = selectionCanvas ? selectionCanvas._currentColNum : -1;

    // nothing to do if we don't have a selection canvas or a selection, OR
    // we have a selectionCanvas already assigned tothe selected record
    if (this.selectionCanvas == null) {
        if (record == null || !this.showSelectionCanvas) return;
        
    } else if (this.showSelectionCanvas && currentRecord == record && 
                currentRowNum == rowNum && currentColNum == colNum) 
    {
        return;
    }
    
    if (this.showSelectionCanvas && this.selectionType != isc.Selection.SINGLE &&
        this.selectionType != isc.Selection.NONE) 
    {
        this.logWarn("showSelectionCanvas is set to true, but not supported for selectionType " + 
                    this.selectionType);
        this.showSelectionCanvas = false;
    }
    
    // If we're not showing the row, or we have no selection,
    // ensure the selectionCanvas is hidden and bail.
    if (!record || rowNum == -1 || !this.showSelectionCanvas) {
        if (currentRecord) {
            // selectionCanvas must exist for currentRecord to be non null 
            this.removeEmbeddedComponent(currentRecord, selectionCanvas);
            var selectionUnderCanvas = this.selectionUnderCanvas;
            this.removeEmbeddedComponent(currentRecord, selectionUnderCanvas);
        }

        return;
    }
    // calling the getters will create the selectionCanvas / selectionUnderCanvas if necessary
    var selectionCanvas = this.getSelectionCanvas(),
        selectionUnderCanvas = this.getSelectionUnderCanvas();
    
    selectionCanvas.record = record;
    selectionUnderCanvas.record = record;
    this.addEmbeddedComponent(selectionCanvas, record, rowNum, colNum, "within");
    this.addEmbeddedComponent(selectionUnderCanvas, record, rowNum, colNum, "within");
},

// Roll Over Canvas

rollOverCanvasDefaults : {
    snapTo:"TL",
    width:"100%", height:"100%"
    //backgroundColor:"yellow"
    //opacity:40
},
rollUnderCanvasDefaults : {
    snapTo:"TL",
    width:"100%", height:"100%"
    //backgroundColor:"red"
},

makeRollOverCanvas : function () {
    this.rollOverCanvas = this.createAutoChild("rollOverCanvas",
        {   eventProxy:this.body,
            percentSource:this, percentBox:"custom",
            destroyOnUnEmbed:false,
            grid:this,
            autoDraw:false
        }
    );

    this.rollUnderCanvas = this.createAutoChild("rollUnderCanvas",
        {
            eventProxy:this.body,
            percentSource:this, percentBox:"custom",
            destroyOnUnEmbed:false,
            grid:this,
            autoDraw:false
        }
    );
},

getRollOverCanvas : function () {
    if (!this.rollOverCanvas) this.makeRollOverCanvas();
    return this.rollOverCanvas;
},
getRollUnderCanvas : function () {
    if (!this.rollUnderCanvas) this.makeRollOverCanvas();
    return this.rollUnderCanvas;
},

updateRollOverCanvas : function (rowNum, colNum, leaving) {
    if (leaving || !this.showRollOverCanvas || rowNum == -1) {
        if (this.rollOverCanvas) {
            this.removeEmbeddedComponent(this.rollOverCanvas.embeddedRecord, this.rollOverCanvas);
            this.removeEmbeddedComponent(this.rollUnderCanvas.embeddedRecord, this.rollUnderCanvas);
        }
        return;
    }
    
    
    var record = this.getCellRecord(rowNum, colNum);
    if (!this.useCellRollOvers) colNum = null;
    
    // Assume we will never be called if the rowNum / colNum hasn't changed since we already
    // have a check for this in GR.mouseMove
    var rollOverCanvas = this.getRollOverCanvas(),
        rollUnderCanvas = this.getRollUnderCanvas();
    
    // store a public pointer to the record on the rollOverCanvas
    // This can be accessed by controls, etc
    rollOverCanvas.record = record;
    rollUnderCanvas.record = record;
    
    if (!this.useCellRollOvers) colNum = null;
    
    this.addEmbeddedComponent(rollOverCanvas, record, rowNum, colNum, "within");
    this.addEmbeddedComponent(rollUnderCanvas, record, rowNum, colNum, "within");    
},


// handle embedded components' z-indices here - allows us to float selection canvas behind
// the LG table if appropriate
updateEmbeddedComponentZIndex : function (component) {
    if (!component) return;
    if (this.selectionCanvas == component) {
        var tableIndex = this.body.getTableZIndex();
        this.selectionCanvas.setZIndex(tableIndex + 50);
    }
    if (this.selectionUnderCanvas == component) {
        var tableIndex = this.body.getTableZIndex();
        this.selectionUnderCanvas.setZIndex(tableIndex - 100);
    }
    // rollover should appear on top of selection. 
    if (this.rollOverCanvas == component) {
        var tableIndex = this.body.getTableZIndex();
        component.setZIndex(tableIndex + 100);
    }
    if (this.rollUnderCanvas == component) {
        var tableIndex = this.body.getTableZIndex();
        component.setZIndex(tableIndex - 50);
    }

},

// Header
// --------------------------------------------------------------------------------------------

// get properties common to *both* header buttons and the corner sort button
getButtonProperties : function () {
	var propsFromGrid = {
        // textAlign: wipe out the default alignment, which is center, to cause the default to
        // come from the text direction
        align:null
    };    
    if (this.headerTitleStyle != null) propsFromGrid.titleStyle = this.headerTitleStyle;
    // NOTE: for headerButtons, headerBaseStyle needs to be re-applied after init, because if
    // field.baseStyle is set it overrides this default.  field.baseStyle is meant to apply to 
    // cells only
    if (this.headerBaseStyle != null) propsFromGrid.baseStyle = this.headerBaseStyle;
    
    // headerButtonSrc / frozenHeaderButtonSrc
    // In multiple skins we use an ImgButton for our header buttons, and provide a custom src
    // property to get the appearance we want
    // These properties allow the overriding of that property for frozen and non frozen ImgButton
    // based header buttons
    
    if (this.headerButtonSrc != null) propsFromGrid.src = this.headerButtonSrc;
    // If 'frozenHeaderBaseStyle' / frozenHeaderTitleStyle is specified, store it on the button
    // defaults under a custom property name so we can apply it when creating buttons for frozen
    // fields 
    if (this.frozenHeaderBaseStyle != null)
        propsFromGrid.frozenBaseStyle = this.frozenHeaderBaseStyle;
    if (this.frozenHeaderTitleStyle != null)
        propsFromGrid.frozenTitleStyle = this.frozenHeaderTitleStyle;
    if (this.frozenHeaderButtonSrc != null)
        propsFromGrid.frozenSrc = this.frozenHeaderButtonSrc;
        
    
	var properties = isc.addProperties({}, 
                this.headerButtonDefaults, propsFromGrid, this.headerButtonProperties);
	return properties;
},

// get properties for the headerButtons only (not the sort button)
getHeaderButtonProperties : function (props) {
            
    var properties = this.getButtonProperties();

    if (this.buttonTitleFunction == null) {
        this.buttonTitleFunction = 
            new Function("return this.parentElement.grid.getHeaderButtonTitle(this)");
    }
    
    isc.addProperties(
                properties,
				{
                    // header button selection is mutex
                    
                    defaultRadioGroup: this.getID()+"_header_radioGroup",
                    
                	// If this field is sortable, we want the button to be a radio button
                	// (Note - mutually-exclusive selection is handled by default by toolbars for
                	// radio type buttons)
                    getActionType : function (a,b,c,d) {
                        var header = this.parentElement,
                            grid;
                            
                        if (header) grid = header.grid;
                        
                        if (grid && isc.isA.ListGrid(grid)) {

                            var field = grid.fields[header.getButtonNumber(this)];
                        
                        	// if the list's canSort is false, or the field's 
                        	// 'canSort' property is false, then this field can't be sorted
                            var canSort = (grid.canSort != false);
                            if (canSort && field != null) canSort = (field.canSort != false);
                        
                            if (canSort) return isc.Button.RADIO;
                        }                            
                        
                    	// We either are canSort:false, or couldn't get a pointer to the list.
                        return this.invokeSuper(null, "getActionType", a,b,c,d);
                        
                    },
                    getTitle : this.buttonTitleFunction,
                    
                    // Override mouseOver / mouseOut to show the headerMenuButton if appropriate
                    mouseOver : function () {
                        var grid = this.parentElement.grid;                        
                        if (grid.shouldShowHeaderMenuButton(this)) {
                            var hmb = grid.getHeaderMenuButton();
                            this.addPeer(hmb);
                            hmb.addProperties({dragTarget:this});
                            // bringToFront if necessary
                            if (this.zIndex > hmb.zIndex) hmb.bringToFront();
                            if (!hmb.isVisible()) {
                                hmb.show();
                            }
                        }
                        return this.Super("mouseOver", arguments);
                    },
                    mouseOut : function () {
                        var grid = this.parentElement.grid,
                            headerMenuButton = grid.headerMenuButton;
                        // If the HMB is showing over this button, hide it unless the user rolled
                        // onto it
                        if (headerMenuButton && headerMenuButton.isVisible() && 
                            headerMenuButton.masterElement == this && 
                            isc.EH.getTarget() != headerMenuButton) 
                        {
                            grid.headerMenuButton.hide();
                        }
                        return this.Super("mouseOut", arguments);
                    }
                },
                props
    );
    
    return properties;
    
},


//>	@method	listGrid.makeHeader()	(A)
// Make the headerBar for the body columns.
// @group	gridHeader
//<
makeHeader : function (dontDraw) {
    if (this.header != null) return;

    if (this.headerSpans) {
        this.spanMap = {};

        for (var i = 0; i < this.headerSpans.length; i++) {
            var headerSpanConfig = this.headerSpans[i];        

            // set up reverse map of fields -> span config
            for (var j = 0; j < headerSpanConfig.fields.length; j++) {
                this.spanMap[headerSpanConfig.fields[j]] = headerSpanConfig;
            }            
        }
    }

    var header = this.header = this.makeHeaderForFields(this.normalFields || this.fields);

	// make and add the sorter
    if (this.sorter == null) this.makeCornerSortButton();

    this.headers = [header];
    
    if (!this.frozenFields) {
        this.addChild(header, null, !dontDraw);
        return;
    }

    var frozenHeader = this.frozenHeader = 
            this.makeHeaderForFields(this.frozenFields, "visible", this.getID() + "_frozenHeader");

    if (this.freezeLeft()) {
        this.headers.unshift(this.frozenHeader);
    } else { 
        this.headers.add(this.frozenHeader);
    }

    this.headerLayout = this.createAutoChild("headerLayout", {
        autoDraw: false,
        overflow:"hidden",
        height: this.headerHeight,
        members : this.headers
    }, isc.HLayout)
    this.addChild(this.headerLayout, null, !dontDraw);
},

makeHeaderForFields : function (fields, overflow, ID) {
    
	// make and add the header
    var header = this.createHeader({
        ID:ID,

        grid:this,

	    // both the header and LV are looking at the same set of objects for field/button
    	// config, but they may have them in a different order due to distinct Array instances.
        buttons:fields.duplicate(),

    	// don't actually permanently change the order of the members on drop - we'll handle it from
    	// reorderField
        reorderOnDrop:false,
        
        // wipe the default height of the Toolbar.  Use null instead of headerHeight since, for
        // frozen columns, when there are multiple headers in an HLayout, we don't want heights
        // on each header, just on the overall layout (applied in layoutChildren())
        height:null,

    	// don't force the user to tab between the fields in the toolbar
        tabWithinToolbar:false,
        
        overflow: overflow || "hidden",

        
        _redrawWithParent:!this.fixedFieldWidths
    })

	// observe the scroll routine of the header to ensure we synch scrolling of the body if the
	// header is scrolled 
	// This is necessary when we can natively tab to the button elements (or to focusProxies
	// positioned behind the button elements) because when the native focus goes to a button in 
	// the header, the native behavior is to scroll the button into view 
	// (if it's not  currently in view).
    this.observe(header, "scrollTo", "observer.headerScrolled()");

    return header;
},

//>	@method	listGrid.createHeader()	(A)
// Create a header object suitable for labelling rows or columns
// @group gridHeader
//<
createHeader : function (properties) {
    
    var grid = this;
    var headerProps = isc.addProperties(
        {
            
            // override makeButton to ignore any baseStyle specified directly on the
            // field definition, and instead always use this.headerBaseStyle
            // Also pick up headerTitleStyle from the field if specified
            makeButton : function (button) {
                
                if (button.headerTitleStyle) button.titleStyle = button.headerTitleStyle;
                else if (button.frozen && this.buttonProperties.frozenTitleStyle)
                    button.titleStyle = button.frozenTitleStyle; 
    
                if (button.frozen && this.buttonProperties.frozenSrc) 
                    button.src = this.buttonProperties.frozenSrc;
                
                // Override showIf to be unset - we already handle evaluating showIf on listGrid
                // fields - if it returned false the button will never be created - if it returned
                // true for the field we know we want to show the button rather than re-eval
                // field.showIf on button draw
                button.showIf=null;
                
                var button = this.Super("makeButton", arguments);
                
                // suppress reording of checkboxField
                if (button._isCheckboxField) button.canReorder = false;
                
                // pick up field level headerBaseStyle if specified.
                
                var explicitBaseStyle;
                if (button.headerBaseStyle) {
                    button.baseStyle = button.headerBaseStyle;
                    explicitBaseStyle = true;
                // otherwise rely on the fact that headerBaseStyle is passed to us as part 
                // of our default 'button' config
                } else if (!explicitBaseStyle) {
                    if (button.frozen && this.buttonProperties.frozenBaseStyle) 
                        button.setBaseStyle(this.buttonProperties.frozenBaseStyle);
                    else if (this.buttonProperties.baseStyle != null)
                        button.setBaseStyle(this.buttonProperties.baseStyle);
                }
                return button;
            },
        	// Note: make all headerButton items members of the same radio group for
            // click-sort.  Previously this was taken care of by an auto-init of the radioGroup
            // in the Toolbar class - which was in turn based on the value returned by
            // getActionType() method on the button.  Since our getActionType override assumes a
            // parent chain and Toolbar no longer guarantees that this will be set up before
            // the radio group is auto-inited, we just pass one in here.
			buttonProperties:this.getHeaderButtonProperties(),
			
			border:this.headerBorder,
			styleName:this.headerBarStyle,
			backgroundColor:this.headerBackgroundColor,
            backgroundImage:this.headerBackgroundImage,
            
        	
            tabIndex : (this.canTabToHeader ? this.getTabIndex() : -1),
            
            canResizeItems:this.canResizeFields,
			canReorderItems:this.canReorderFields,
			dontObserve:false,
            
            childVisibilityChanged : function () {
                this.Super("childVisibilityChanged", arguments);
                this._sizeSpans();
            },

            // use this internal API rather than childResized/resized - this leaves those
            // public APIs available for other use, plus reduces the number of reflows by
            // dealing with the layout directly rather than responding to a cascae of
            // childResize()s
            _layoutChildrenDone : function () {
                this.Super("_layoutChildrenDone", arguments);
                this._sizeSpans();
            },
            spannedFields : Array.create({sortUnique: true}),
            addSpan : function (span, spanFields) {
                if (!this._spans) this._spans = [];
                this._spans.add(span);
                this.spannedFields.addList(spanFields);
                
                // unless the user passed an explicit, always size the span to the height of
                // the header
                if (this.isDrawn()) {
                    this._sizeSpan(span);
                    this.addChild(span);
                } 
            },
            _sizeSpans : function () {
                if (!this._spans || !this.isDrawn()) return;
                
                // diable instantRelayout while sizing the spans.
                
                var instantRelayout = this.instantRelayout;
                this.instantRelayout = false;
                for (var i = 0; i < this._spans.length; i++) this._sizeSpan(this._spans[i]);
                this.instantRelayout = instantRelayout;
            },
            _sizeSpan : function (span) {
                if (!this.isDrawn()) {
                    return;
                }
                if (span._spanAutoSizeHeight) {
                    span.setHeight(Math.floor(this.getVisibleHeight()/2));
                }

                var spannedMembers = this.members.findAll("name", span._spansFields);

                // buttons are removed from the layout when hidden, so don't break on the lack
                // of spanned members
                if (!spannedMembers) {
                    span.hide();
                    return;
                }

                var firstVisibleMember, 
                    spanWidth = 0
                ;
                for (var i = 0; i < spannedMembers.length; i++) {
                    var spannedMember = spannedMembers[i];
                    
                    // disable header reorder drop over spanned columns
                    spannedMember.canReorder = false;

                    // if we're spanned, spans will stack on top, force layoutAlign: bottom for
                    // spanned header
                    spannedMember.layoutAlign = "bottom";

                    if (spannedMember.visibility != isc.Canvas.HIDDEN) {
                        spanWidth += spannedMember.getVisibleWidth();
                        if (!firstVisibleMember || this.isRTL()) firstVisibleMember = spannedMember;
                    }
                }

                if (firstVisibleMember) {
                    span.show();
                    span.setLeft(firstVisibleMember.getLeft());
                    span.setWidth(spanWidth);
                }

            },

            _adjustSpans : function () {
                if (!this._spans) return;
                this._sizeSpans();
                var thisHeight = this.getVisibleHeight();
                for (var i = 0; i < this._spans.length; i++) {
                    var span = this._spans[i];
                    this.addChild(span);

                    var spannedMembers = this.members.findAll("name", span._spansFields);
                    if (!spannedMembers) continue;

                    for (var j = 0; j < spannedMembers.length; j++) {
                        var header = spannedMembers[j],
                            headerHeight = header.getVisibleHeight(),
                            spanHeight = span.getVisibleHeight()
                        ;
                        if (spanHeight+headerHeight > thisHeight) header.setHeight(headerHeight - spanHeight);
                    }

                    span.bringToFront();
                }
            },

            addButtons : function (buttons, position) {
                this.Super("addButtons", arguments);
                
                if (grid.headerSpans) grid._addHeaderSpans(buttons, this);
                this._adjustSpans();
            },        

            draw : function () {
                if (this._spans && grid.unspannedHeaderVAlign) {
                    for (var i = 0; i < this.buttons.length; i++) {
                        var button = this.buttons[i];
                        if (!this.spannedFields.contains(button.name)) button.valign = grid.unspannedHeaderVAlign;
                    }
                }
                this.Super("draw", arguments);
                this._adjustSpans();                

            }
            
        }, properties);
  
    if (this.headerButtonConstructor != null) 
        headerProps.buttonConstructor = this.headerButtonConstructor;

    var header = this.createAutoChild("header", headerProps,
        
        isc.Toolbar);

	// if the canReorderFields is true, observe the reorderItem method of the header
	if (header.canReorderItems && !header.dontObserve) {
		this.observe(header, "itemDragReordered", "observer.headerDragReordered(itemNum,newPosition,this)");
    	// NOTE: we don't actually do anything in the LV until reorder completes in the header
	}
	
	// if canResizeFields is true, observe the resizeItem and dragResize* methods of the header
    if (header.canResizeItems && !header.dontObserve) this._observeHeaderResize(header);
    
    if (this.headerSpans) this._addHeaderSpans(properties.buttons, header);
    return header;
},

_addHeaderSpans : function (fields, header) {
	// find headerSpans that match our set of fields
	var headerSpans = [], 
		fieldNames = fields.getProperty(this.fieldIdProperty)
	;

	for (var i = 0; i < this.headerSpans.length; i++) {
		var headerSpanConfig = this.headerSpans[i];
		if (fieldNames.intersect(headerSpanConfig.fields).length) headerSpans.add(headerSpanConfig);
	}

	for (var i = 0; i < headerSpans.length; i++) {
		var headerSpanConfig = headerSpans[i];
		// allow a canvas to be passed in
		
		// default to using the same component that header buttons are made of - this
		// way we get a consistent cross-skin look that's a reasonable default
		var grid = this;
		var dynamicProperties = isc.addProperties(this.getButtonProperties(), {
			_constructor: header.buttonConstructor,
			height: this.headerSpanHeight,
			// typical to align the span text in the center
			align: "center",
			valign: this.headerSpanVAlign,
			showRollOver: false,
			showContextMenu : function () {
				return grid.headerSpanContextClick(this);
			}
		}, headerSpanConfig);
		var span = headerSpanConfig.liveObject = this.createAutoChild("headerSpan", dynamicProperties);

		// auto-size span height unless an explicit height is set somewhere
		span._spanAutoSizeHeight = this.headerSpanHeight == null;
		if (span._spanAutoSizeHeight) {
			[this.headerSpanDefaults, this.headerSpanProperties, headerSpanConfig].map(function(props){
				if (props && props.height != null) span._spanAutoSizeHeight = false;
			});
		}

		span._spansFields = headerSpanConfig.fields;
		header.addSpan(span, span.fields);
	}
},

//>	@method	listGrid.dirtyHeader()	(A)
//			let the header know that it should redraw when we get a chance
//		@group	gridHeader
//<
dirtyHeader : function () {
	if (this.header) this.header.markForRedraw();
},

// update an existing header to match the current set of fields.
updateHeader : function () {
    
    // wipe out the old header if there was one   
    if (this.frozenHeader) this.headerLayout.destroy();
    else if (this.header) this.header.destroy();
    this.header = this.frozenHeader = this.headerLayout = null;
    
    // clear pointer to headerMenuButton if necessary
    if (this.headerMenuButton && this.headerMenuButton.destroyed) {
        this.headerMenuButton = null;
    }

	// create a new header if so configured
    // NOTE: suppress drawing the header when we make it - this will be handled later.
    if (this.showHeader) {        
        this.makeHeader(true);    
    // sorter may be undef (if showSorter is false)
    } else if (this.sorter) {
        this.sorter.hide();
    }

	
},

//> @method listGrid.setHeaderHeight()
// Modify the height of a listGrid. To hide the header set height to zero.
// @param height (number) new height for the header
// @visibility external
// @group sizing, gridHeader
//<
_$headerHeightChanged:"header height changed",
setHeaderHeight : function (height) {
    var oldHeight = this.headerHeight;
    
    if (oldHeight == height) return;

    this.headerHeight = height;    
    
    // No need to update the header if we're not showing it.
    if (this.showHeader == false) return;
    
    if (!this.header && height > 0) {
        // If we're not drawn the header will get created when we get drawn
        // Otherwise create and draw it now.
        if (this.isDrawn()) this.makeHeader();
    } else {
        
        if (oldHeight == 0) this.updateHeader();
        // handles resizing (and showing/hiding if appropriate)
        this.layoutChildren(this._$headerHeightChanged)
    }
    
},

//> @method listGrid.setShowHeader()
// Show or hide the ListGrid header.
// @param show (boolean) true to show the header, false to hide it.
// @visibility external
// @group gridHeader
//<
_$headerVisibilityChanged:"header visibility changed",
setShowHeader : function (show) {
    if (show == this.showHeader) return;
    
    this.showHeader = show;
    
    this.updateHeader();
    this.layoutChildren(this._$headerVisibilityChanged);
},

// Header Menu button
// -------------------------------------------------------------------------------------------

shouldShowHeaderMenuButton : function (header) {
    var shouldShow;
    if (header.showHeaderContextMenuButton != null) {
        shouldShow = header.showHeaderContextMenuButton;
    } else {
        shouldShow = this.showHeaderMenuButton;
    }
    if (this.showHeaderContextMenu && shouldShow) {
        // suppress the headerContextMenuButton if we won't actually show the headerContextMenu
        var items = this.getHeaderContextMenuItems(header.masterIndex);
        return (items.length > 0); 
    }
    return false;
},

// getHeaderMenuButton
// creates the headerMenuButton autoChild. Lazily creates the button if it hasn't been shown yet 
getHeaderMenuButton : function () {
    if (!this.headerMenuButton) {
        var dynamicDefaults = {};
        // don't default anything to explicit null!
        if (this.headerMenuButtonHeight) dynamicDefaults.height = this.headerMenuButtonHeight;
        if (this.headerMenuButtonWidth) dynamicDefaults.width = this.headerMenuButtonWidth;
        if (this.headerMenuButtonIcon) dynamicDefaults.icon = this.headerMenuButtonIcon;
        if (this.headerMenuButtonIconHeight) {
            dynamicDefaults.iconHeight = this.headerMenuButtonIconHeight;
        }
        if (this.headerMenuButtonIconWidth) {
            dynamicDefaults.iconWidth = this.headerMenuButtonIconWidth;
        }
        if (this.headerMenuButtonBaseStyle) {
            dynamicDefaults.baseStyle = this.headerMenuButtonBaseStyle;
        }
        if (this.headerMenuButtonTitleStyle) {
            dynamicDefaults.titleStyle = this.headerMenuButtonTitleStyle;
        }
        if (this.headerMenuButtonSrc) dynamicDefaults.src = this.headerMenuButtonSrc;
        
        this.createAutoChild("headerMenuButton", dynamicDefaults, "Button", true);
    }
    this.headerMenuButton.canDragResize = this.canResizeFields;
    return this.headerMenuButton;
},

headerMenuButtonDefaults: {
    snapTo:"R",
    canFocus:false,
    
    resizeFrom:"R",
    
    // Default the title to explicit null rather than the default Button.title property
    // (EG "Untitled Button")
    title:null,
    iconSpacing:0,
    
    click : function () {this.parentElement.grid.headerMenuButtonClick()},
    mouseOut : function () {
        var target = isc.EH.getTarget();
        if (!target || !this.parentElement.contains(target)) this.hide();
        // call Super to reset 'over' state
        this.Super("mouseOut", arguments);
    }
},

// called from a click on the header menu button                 
headerMenuButtonClick : function () {
    var header = this.header,
        buttonIndex = header.getMouseOverButtonIndex();
    if (buttonIndex == -1 && this.frozenHeader) {
        header = this.frozenHeader;
        buttonIndex = header.getMouseOverButtonIndex();
    }
    if (buttonIndex == -1) return;

    var headerButton = header.getMember(buttonIndex);
    var menuTop = headerButton.getPageBottom(),
        menuWidth = this._cornerMenu ? this._cornerMenu.getVisibleWidth() 
                                     : isc.Menu.getPrototype().defaultWidth,
        menuLeft = Math.max(headerButton.getPageLeft(), (headerButton.getPageRight() - menuWidth));   
    return this.displayHeaderContextMenu(
                headerButton,
                [menuLeft,menuTop]
            );
},



// Header Buttons
// --------------------------------------------------------------------------------------------

//>	@method	listGrid.getHeaderButtonTitle()	(A)
// Given a header button (or column number), returns the title for that header button.
// @group	drawing, gridHeader
// @param	button		(number)
// @return	(string)	HTML for header button contents
// @visibility internal
//<
getHeaderButtonTitle : function (button) {
    var fieldNum = button;
    // passed a header button or field
    if (isc.isA.Object(button)) fieldNum = button.masterIndex;
	var field = this.fields[fieldNum];

	// if field is null, we've shrunk the number of columns, so forget it
	if (!field) return "";
	var showSortArrow = (fieldNum == this._getSortFieldNum()) && 
                        (!this.showSortArrow || this.showSortArrow == isc.ListGrid.FIELD || 
                         this.showSortArrow == isc.ListGrid.BOTH),
		title = this.getFieldTitle(fieldNum)
	;
	return title + (showSortArrow ? "&nbsp;"+ this.getSortArrowImage()	:  "" );

},

_setCheckboxHeaderState : function (state) {
    var fieldNum = this.isRTL() ? this.fields.length : 0,
        field = this.fields[fieldNum];
   // if (field._allSelected == state) return;
    var title = this.getValueIconHTML(this.getValueIcon(field, state), field);
    this.setFieldTitle(fieldNum, title);
    field._allSelected = state;
},

//>	@method	listGrid.headerClick()	(A)
// Handle a click in the list header.
// <P>
// By default, calls +link{sort()} to sort by the field that was clicked, or to reverse the
// direction of sorting if already sorted by that field.
//
// @param fieldNum (number) field number for the header that was clicked
// @group sorting
// @group events
// @group gridHeader
// @visibility external
//<
headerClick : function (headerFieldNum, header) {
    
    var fieldNum = header.getMember(headerFieldNum).masterIndex,
	    field = this.fields[fieldNum];
    // check if the checkbox column header was clicked
    if (this.isCheckboxField(field)) {
        if (field._allSelected) {
            this.deselectAllRecords();
            this._setCheckboxHeaderState(false);
        } else {
            this.selectAllRecords();
            this._setCheckboxHeaderState(true);
        }
        return false;
    }
    //this.logWarn("click on field: " + headerFieldNum + " in header: " + header +
    //             " maps to field: " + fieldNum);

	// if the list's canSort is false, the field wasn't defined or the field's 'canSort' property is
	// false, return false
	if (this.canSort == false || ! field || field.canSort == false ) return false;
    
	// if they're clicking on the current sort field, reverse the direction of the sort
	if (fieldNum == this._getSortFieldNum()) {
        var dir = field.sortDirection == null ? this.sortDirection : field.sortDirection;
        this.sort(fieldNum, !Array.shouldSortAscending(dir));
	} else {
    	// sort by that field, default direction
	    this.sort(fieldNum);
    }        
	
	// return false to stop further event processing
	// if we don't do this, clicks in the header will sometimes select items in the list
	return false;
},


// Field Drag Resize
// --------------------------------------------------------------------------------------------

//>	@method	listGrid.fieldDragResizeStart()	(A)
// Event sent when header column starts drag-resizing.
// <p>
// Current implementation creates a drag line and sizes it to the height of the list body.
// <p>
// Observed from this.header.dragResizeStart()
//
//		@group	dragging
//<
fieldDragResizeStart : function () {
	// make sure the drag line is set up
	this.makeDragLine();
	
	// and resize it to cover the entire height of the listGrid
	this._dragLine.resizeTo(2, this.getVisibleHeight() - (this.body.hscrollOn ? this.getScrollbarSize() : 0));

	// set the overflow of the header being dragged to hidden so that the user can clip the title
	// text if he chooses.
    this.ns.EH.dragTarget.setOverflow("hidden");
},

//>	@method	listGrid.fieldDragResizeMove()	(A)
//		Event sent when header column is drag-resizing.
//
//		Current implementation moves the dragLine to show the new boundary.
//	
//		Observed from this.header.dragResizeMove()
//		@group	dragging, drawing
//<
fieldDragResizeMove : function (x) {
    var EH = this.ns.EH, 
        resizingField = EH.dragTarget;

	// move the drag line to show the new field boundary
    var colNum = this.header._resizePosition;
    this.showDragLineForField(colNum);

	// if we're supposed to resize fields as they're dragging
	if (this.resizeFieldsInRealTime) {
		// change the width of the field and redraw
		var width = EH.dragResizeWidth;
		this._fieldWidths[colNum] = width;

    	
  
        this._settingBodyFieldWidths = true;
        this.setBodyFieldWidths(this._fieldWidths);
        // While resizing fields in real time we want the body's incremental rendering system
        // to use the 'quick' draw ahead ratio.
        this.body.useQuickDrawAheadRatio = true;
        this.body.redraw("fieldDragResize");
        delete this.body.useQuickDrawAheadRatio;
        delete this.body._settingBodyFieldWidths;

		// if we're scrolled, as the body shrinks it's scroll position may become invalid,
    	// so it scrolls back, and the header needs to match
    	// NOTE: RTL: if the body is showing the empty message while the header is
    	// resizing, the body does not expand and is not scrollable hence has scrollLeft 0,
    	// however scrollLeft 0 applied to the header in RTL scrolls it to max!
        var bodyScrollLeft = this.body.getScrollLeft();
        if (bodyScrollLeft > 0) this.header.scrollTo(bodyScrollLeft);
    }
},

//>	@method	listGrid.fieldDragResizeStop()	(A)
//		Event sent when header column is done drag-resizing.
//
//		Current implementation hides the dragLine.
//
//		Observed from this.header.dragResizeStop()
//		@group	dragging, drawing
//<
fieldDragResizeStop : function () {
	this.hideDragLine();
},



// Reorder / Resize Field APIs
// --------------------------------------------------------------------------------------------

headerDragReordered : function (fieldNum, moveToPosition, header) {
    var masterFieldNum = header.getMember(fieldNum).masterIndex,
        masterMoveToPosition = header.getMember(moveToPosition).masterIndex;
    //this.logWarn("reorder of header field from " + fieldNum + 
    //             " to " + moveToPosition + " on header: " + header +
    //             " will move master field from " + masterFieldNum + 
    //             " to : " + masterMoveToPosition);
    this.reorderField(masterFieldNum, masterMoveToPosition);
},

//>	@method	listGrid.reorderField()	(A)
// Reorder a particular field 
//
// @param	fieldNum        (number)	Number of the field to reorder
// @param	moveToPosition	(number)	New position for that field
//
// @visibility external
//<
reorderField : function (fieldNum, moveToPosition) {
    this.reorderFields(fieldNum, fieldNum+1, moveToPosition - fieldNum);
},

//>	@method	listGrid.reorderFields()	(A)
// Reorder a set of adjacent fields, from start to end exclusive at the end, by distance
// moveDelta.<br><br>
//
// NOTE: start and end coordinates are in terms of the currently visible fields, not the full set of
// fields.
//
// @param    start     (number) Start of the range of fields to move, inclusive
// @param    end       (number) End of the range of fields to move, non-inclusive
// @param    moveDelta (number) Distance to move by
//
// @visibility external
//<
reorderFields : function (start, end, moveDelta) {

    var startField = this.fields[start],
        endField = this.fields[end -1],
        targetIndex = start + moveDelta,
        targetField = this.fields[targetIndex];
    
	// preserve the sorted field
    var sortFieldNum = this._getSortFieldNum(),
        sortField = this.fields[sortFieldNum];
    
	// reorder the field widths for the moved field range 
    this._fieldWidths.slideRange(start, end, start+moveDelta);
    
	// update this.completeFields, rather than this.fields.
	// Note that we may have hidden fields, so we have to recalculate start, end and target.
    if (this.completeFields.contains(targetField)) {
        var cfStart = this.completeFields.indexOf(startField),
            cfEnd = this.completeFields.indexOf(endField) + 1,
            cfTargetIndex = this.completeFields.indexOf(targetField);
    	//this.logWarn("start, end, targetIndex of: " + [start,end,targetIndex] + 
    	//             " translated to: " + [cfStart, cfEnd, cfTargetIndex] +
    	//             " fields: " + this.completeFields.getProperty("name"));
        this.completeFields.slideRange(cfStart, cfEnd, cfTargetIndex);
    	//this.logWarn("after slideRange, fields: " +
    	//             this.completeFields.getProperty("name"));
    } 
    
    // set the visibleFields based on newly reordered complete set of fields
    this.deriveVisibleFields()
    // update the sortFieldNum to reflect the slide
    if (sortFieldNum != null) {
        sortFieldNum = this.fields.indexOf(sortField);
        // field no longer visible
        if (sortFieldNum == -1) sortFieldNum = null;
        this._setSortFieldNum(sortFieldNum);
    }
    
    // find the header for this field
    var header;
    if (!this.frozenFields) {
        header = this.getFieldHeader(start);
        // reorder the header items
        if (header) {
            header.reorderItems(this.getLocalFieldNum(start), this.getLocalFieldNum(end), 
                                this.getLocalFieldNum(start+moveDelta));
        }
        
    } else {
        // for frozen fields, just rebuild for freeze
        
        this.rebuildForFreeze();
        header = this.getFieldHeader(start);
    }
    
    // tell that toolbar button to show the sort
    if (sortFieldNum != null && header)
        header.selectButton(this.getLocalFieldNum(sortFieldNum));
    
    // if necessary, preserve the edit field
    var editorShowing = this._editorShowing;
    if (editorShowing) {
    	// If the editor is showing, we will need to update the editForm in 2 ways:
    	// - the colNum property for each item must be updated
    	// - the form items should be reordered so the items are in order wrt to the new
    	//   field order.
    	// When this has been accomplished, we can rely on the body redraw to handle writing
    	// out the appropriate HTML, setting the values of the form items, and updating focus
    	// if required.
        var editForm = this._editRowForm,
            editRowNum = this.getEditRow(),
            editField = this.getEditField(),
            newItemsArray = []
        for (var i = 0; i < editForm.items.length; i++) {
            var item = editForm.items[i];
            item.colNum = this.fields.findIndex(this.fieldIdProperty, item.getFieldName());
            for (var j = 0; j <= newItemsArray.length; j++) {
                if (newItemsArray[j] == null || newItemsArray[j].colNum > item.colNum) {
                    newItemsArray.addAt(item, j);
                    break;
                }
            }
        }
        
    	// Update the items array to match the reordered version of itself
        editForm.items.setArray(newItemsArray);
    	// Update the 'editColNum' to reflect the repositioned edit field.
        this._editColNum = this.fields.indexOf(editField);
    }

    if (this.body) {
        this.body.fields = this.normalFields || this.fields;
        // give the body the reordered field widths
        this.setBodyFieldWidths(this._fieldWidths);
        // redraw (may be required if fields had matching widths)
        if (!this.body.isDirty()) this._markBodyForRedraw("reorderFields");
    }
	// reorder the fields in the filterEditor if showing
    if (this.showFilterEditor) {        
        this.filterEditor.reorderFields(start, end, moveDelta);
    }

    this.fieldStateChanged();
},

// Ensure that the .colNum property is up to date on our editors

remapEditFieldsForFreeze : function () {
    if (this._editorShowing) {
        var form = this.getEditForm(),
            items = form.getItems();
        for (var i = 0; i < items.length; i++) {
            var item = items[i];
            item.colNum = this.fields.findIndex(this.fieldIdProperty, item.getFieldName());
            var field = this.fields[item.colNum];
            
            if (field.frozen) item.containerWidget = this.frozenBody;
            else item.containerWidget = this.body;                                                                    
        }
    }
},

headerDragResized : function (fieldNum, newWidth, header) {
    var masterFieldNum = header.getMember(fieldNum).masterIndex;
    //this.logWarn("resize of header field: " + fieldNum + " on header: " + header +
    //             " will resize master fieldNum: " + masterFieldNum);
    this.resizeField(masterFieldNum, newWidth);
},

//> @method ListGrid.setCanResizeFields()
// Setter method for updating +link{ListGrid.canResizeFields} at runtime.
// @param canResize (boolean) new value for this.canResizeFields
// @visibility external
//<
setCanResizeFields : function (canResize) {
    if (this.canResizeFields == canResize) return;
    this.canResizeFields = canResize;
    if (this.header) this.header.setCanResizeItems(canResize);
    if (this.frozenHeader) this.frozenHeader.setCanResizeItems(canResize);
    if (this.headerMenuButton) this.headerMenuButton.canDragResize = canResize;
    if (canResize) {
        if (this.header && !this.header.dontObserve) this._observeHeaderResize(this.header);
        if (this.frozenHeader && !this.frozenHeader.dontObserve)
            this._observeHeaderResize(this.frozenHeader);
    } else {
        if (this.header) this._ignoreHeaderResize(this.header);
        if (this.frozenHeader) this._ignoreHeaderResize(this.frozenHeader);
    }
},

_observeHeaderResize : function (header) {
    this.observe(header, "itemDragResized", "observer.headerDragResized(itemNum,newSize,this)");
    this.observe(header, "dragResizeMemberStart", "observer.fieldDragResizeStart()");
    this.observe(header, "dragResizeMemberMove", "observer.fieldDragResizeMove()");
    this.observe(header, "dragResizeMemberStop", "observer.fieldDragResizeStop()");
},

_ignoreHeaderResize : function (header) {
    if (this.isObserving(header, "itemDragResized"))
        this.ignore(header,"itemDragResized");
    if (this.isObserving(header, "dragResizeMemberStart")) 
        this.ignore(header, "dragResizeMemberStart");
    if (this.isObserving(header, "dragResizeMemberMove")) 
        this.ignore(header, "dragResizeMemberMove");
    if (this.isObserving(header, "dragResizeMemberStop"))
        this.ignore(header, "dragResizeMemberStop");
},

//>	@method	listGrid.resizeField()	(A)
// Resize a particular field to a new width.
//
// @param	fieldNum	(number)	Number of the field to resize
// @param	newWidth	(number)	New width of the field
//
// @visibility external
//<
resizeField : function (fieldNum, newWidth) {

    // adjust the header for this field, if we have a header
    if (this.header && this.header.isDrawn()) {
        var header = this.getFieldHeader(fieldNum),
            headerFieldNum = this.getLocalFieldNum(fieldNum);
        
        header.getMember(headerFieldNum).setWidth(newWidth);
    }
    
	// store the width in the field config.  We do this because if setFields() is called after
	// init with an overlapping set of field objects, we'd like to be able to pick up any field
	// widths explicitly set by the user.
    this.fields[fieldNum].width = newWidth;

    // don't crash if not drawn
    if (!this.isDrawn()) return;

  	// update the body column widths
    this._fieldWidths[fieldNum] = newWidth;
    
    this._settingBodyFieldWidths = true;
    this.setBodyFieldWidths(this._fieldWidths);

    // force an immediate redraw of the body - this will enable us to check the
    // _settingBodyFieldWidths flag in updateFieldWidths
    if (this.body.isDirty()) this.body.redraw("setting body field widths");
    delete this._settingBodyFieldWidths;
    
    if (this.showFilterEditor && this.filterEditor) {
        this.filterEditor.resizeField(fieldNum, newWidth);
    }

    this.fieldStateChanged();    
},

// Sorter (corner button)
// --------------------------------------------------------------------------------------------

// should we draw the corner sort button in the header?
_showSortButton : function () {
    var showSort = this.showSortArrow;
    if (showSort != null) {
        return (showSort == isc.ListGrid.CORNER || showSort == isc.ListGrid.BOTH);
    }
    // If we haven't been explicitly set to show the corner sort button, show it if we're 
    // leaving a gap for the scrollbar.     
    return this._shouldLeaveScrollbarGap();
},

// predictScrollbarGap - internal but non obfuscated flag - if true, when leaveScrollbarGap is false
// we predict whether the body will show a vertical scrollbar based on cellHeight and number of
// rows.
// This allows us to render the body at the appropriate width to accomodate a vertical scrollbar 
// rather than waiting for the vertical scrollbar to be rendered (which may also introduce a
// horizontal scrollbar), then resizing.
predictScrollbarGap:true,

_shouldLeaveScrollbarGap : function () {
    if (this.leaveScrollbarGap) return true;
    if (!this.body || this.isEmpty()) return false;
    
    if (this.body.vscrollOn) return true;
    
    var body = this.body,
        
        headerHeight = this.headerHeight, 
        
        bodyHeight = this.getInnerHeight() - this.body.getVMarginBorder() - 
                        (this.showHeader ? headerHeight : 0);

    // exception case - when we're auto-fitting to content the body will be allowed to expand
    if (this.autoFitData == isc.Canvas.VERTICAL || this.autoFitData == isc.Canvas.BOTH) {
        bodyHeight = (this.getTotalRows() * this.cellHeight);
        var maxHeight = this.getAutoFitMaxBodyHeight();
        if (maxHeight && maxHeight < bodyHeight) {
            bodyHeight = maxHeight;
        }
        if (this.autoFitMaxRows && (this.autoFitMaxRows * this.cellHeight) > bodyHeight) {
            bodyHeight = (this.autoFitMaxRows * this.cellHeight);
        }
    }
    //this.logWarn("predicting gap: bodyHeight: " + bodyHeight + 
    //             ", rows: " + this.getTotalRows() + 
    //             ", rowsHeight: " + (this.getTotalRows() * this.cellHeight))

    
    if (bodyHeight <= 0) return false;
        
    return this.predictScrollbarGap && this.bodyOverflow == isc.Canvas.AUTO &&
           (this.getTotalRows() * this.cellHeight > bodyHeight);
},

getSorterLeft : function () {
    if (this.isRTL()) {
        return this.getLeftMargin() + this.getLeftBorderSize();
    } else {
        return this.getWidth() - this.getScrollbarSize() - this.getHMarginBorder();
    }
},

//>	@method	listGrid.makeCornerSortButton()	(A)
//		@group	drawing
//			make the sorter button
//<
makeCornerSortButton : function () {

    this.addAutoChild("sorter", 
        isc.addProperties(this.getButtonProperties(),
            // Explicitly lay sorterDefaults on top of the buttonProperties.
            // If we didn't do this, sorterDefaults would be picked up as defaults but would
            // be overridden by the standard button properties, which means headerDefaults 
            // would override sorterDefaults for the button
            this.sorterDefaults,
            {
                ID:this.getID()+"_sorter",
                left:this.getSorterLeft(),
                top:0,
                width:this.getScrollbarSize(),
                height:this.headerHeight,
                
                backgroundColor:this.headerBackgroundColor,
                imgDir:this.widgetImgDir,
                visibility:(this._showSortButton() ? isc.Canvas.INHERIT : isc.Canvas.HIDDEN)
            }
        )
    );
},

sorterContextClick : function () {
    var showContextMenu = this.showHeaderContextMenu;
    //>!BackCompat 2007.02.02
    // If the old showCornerContextMenu attr is defined, have it take presidence
    if (this.showCornerContextMenu != null) showContextMenu = this.showCornerContextMenu;
    //<!BackCompat
    if (showContextMenu) return this.displayHeaderContextMenu(this.sorter);
},

// if the header context menu is enabled, also show it on the headerBar
headerBarContextClick : function (header) {
    var showContextMenu = this.showHeaderContextMenu;
    //>!BackCompat 2007.02.02
    // If the old showCornerContextMenu attr is defined, have it take presidence    
    if (this.showCornerContextMenu != null) showContextMenu = this.showCornerContextMenu;
    //<!BackCompat
    if (showContextMenu) {
        return this.displayHeaderContextMenu(header.getMember(header.getMouseOverButtonIndex()));
    }
},

headerSpanContextClick : function (span) {
    var menuItems = this.getHeaderSpanContextMenuItems(span);
    if (!menuItems || menuItems.length == 0) return false;

    if (!this._spanContextMenu) {
       this._spanContextMenu = isc.Menu.create({
           items: menuItems
       });
    } else {	 
       this._spanContextMenu.setItems(menuItems);	 
    }
    this._spanContextMenu.showContextMenu();
    return false;
},


//>@method ListGrid.displayHeaderContextMenu()
// If +link{attr:listGrid.showHeaderContextMenu} is <code>true</code> this method is fired
// when the user right-clicks on the header for this grid.<br>
// Default implementation will display a menu with entries derived from
// +link{listGrid.getHeaderContextMenuItems()} for the appropriate column.
// @param target (Canvas) which button in the header recieved the right-click event 
//                        (may be the sorter button)
// @param [position] (Array) Optional 2-element array specifying position at which the menu should
//                           be shown. If this is not passed in the menu will be shown at the
//                           mouseEvent position (default context menu behavior).
// @visibility external
// @group gridHeader
// @see listgrid.showHeaderContextMenu
//<
displayHeaderContextMenu : function (headerButton, position) {
    // headerButton will be null when contextClick appears on header background
    if (!headerButton) return;
    // don't display a header context menu for the checkbox column
    var field = this.fields[headerButton.masterIndex];
    if (this.isCheckboxField(field)) return false;
    // Determine the items to show
    var items = this.getHeaderContextMenuItems(headerButton.masterIndex);
    // If there are no items don't show the menu
    if (items.length == 0) return;
    
    if (!this._cornerMenu) this._cornerMenu = this.getHeaderContextMenu(headerButton);
    this._cornerMenu.setData(items);

    if (position != null && position.length > 0) {
        this._cornerMenu.moveTo(position[0], position[1]);
        this._cornerMenu.show();
        return false;
    } else {
        return this._cornerMenu.showContextMenu(headerButton);
    }
},



//> @attr ListGrid.sortFieldAscendingText (string : "Sort Ascending" : IRW)
// If we're showing a +link{listGrid.showHeaderContextMenu,headerContextMenu} for this grid, this
// attribute will be shown as the menu item title to sort a field in ascending order.
// @group i18nMessages
// @visibility external
//<
sortFieldAscendingText: "Sort Ascending",

//> @attr ListGrid.sortFieldDescendingText (string : "Sort Descending" : IRW)
// If we're showing a +link{listGrid.showHeaderContextMenu,headerContextMenu} for this grid, this
// attribute will be shown as the menu item title to sort a field in descending order.
// @group i18nMessages
// @visibility external
//<
sortFieldDescendingText: "Sort Descending",

//> @attr ListGrid.fieldVisibilitySubmenuTitle (string : "Columns" : IRW)
// If we're showing a +link{listGrid.showHeaderContextMenu,headerContextMenu} for this grid, and
// +link{listgrid.canPickFields,this.canPickFields} is true, this
// attribute will be shown as the title for the menu item which contains a submenu with items 
// allowing the user to show and hide fields in the grid.
// @group i18nMessages
// @visibility external
//<
fieldVisibilitySubmenuTitle: "Columns",

//> @attr listGrid.freezeFieldText (string : "Freeze \${viewer.getSummaryTitle(field)}" : IRWA)
// If we're showing a +link{listGrid.showHeaderContextMenu,headerContextMenu} for this grid and
// +link{listGrid.canFreezeFields,this.canFreezeFields} is true, this string will be shown as the
// title for the menu item to freeze a currently unfrozen field.
// <P>
// This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code
// when the message is displayed, with <code>viewer</code> available as a variable mapped to
// the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field.
// <P>
// Default value returns "Freeze " + the field's summary title.
// @group i18nMessages
// @visibility external
//<
freezeFieldText:"Freeze ${viewer.getSummaryTitle(field)}",

//> @attr listGrid.unfreezeFieldText (string : "Unfreeze \${viewer.getSummaryTitle(field)}" : IRWA)
// If we're showing a +link{listGrid.showHeaderContextMenu,headerContextMenu} for this grid and
// +link{listGrid.canFreezeFields,this.canFreezeFields} is true, this string will be shown as the
// title for the menu item to unfreeze a currently frozen field.
// <P>
// This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code
// when the message is displayed, with <code>viewer</code> available as a variable mapped to
// the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field.
// <P>
// Default value returns "Unfreeze " + the field's summary title.
// @group i18nMessages
// @visibility external
//<
unfreezeFieldText:"Unfreeze ${viewer.getSummaryTitle(field)}",

//> @method listGrid.getToggleFreezeText()
// If we're showing a +link{listGrid.showHeaderContextMenu,headerContextMenu} for this grid and
// +link{listGrid.canFreezeFields,this.canFreezeFields} is true, this string will be shown as the
// title for the menu item to toggle whether a field is frozen or unfrozen.
// <P>
// Default implementation evaluates and returns +link{ListGrid.freezeFieldText} or
// +link{ListGrid.unfreezeFieldText} depending on whether the field is currently frozen.
// @param field (ListGridField) field to get the menu item title for
// @return (string) Title to show in the menu item
// @group i18nMessages
// @visibility external
//<
getToggleFreezeText : function (field) {
    var messageArgs = {
        field:field,
        viewer:this
    }
    return field.frozen ? this.unfreezeFieldText.evalDynamicString(this, messageArgs)
                         : this.freezeFieldText.evalDynamicString(this, messageArgs);
},

//> @attr listGrid.groupByText (string : "Group by \${viewer.getSummaryTitle(field)}" : IRWA)
// If we're showing a +link{listGrid.showHeaderContextMenu,headerContextMenu} for this grid and
// +link{listGrid.canGroupBy,this.canGroupBy} is true, this string will be shown as the
// title for the menu item to toggle the group by setting for a field.
// <P>
// This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code
// when the message is displayed, with <code>viewer</code> available as a variable mapped to
// the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field.
// <P>
// Default value returns "Group by " + the field's summary title.
// @group i18nMessages
// @visibility external
//<
groupByText : "Group by ${viewer.getSummaryTitle(field)}",

//> @method listGrid.getGroupByText()
// If we're showing a +link{listGrid.showHeaderContextMenu,headerContextMenu} for this grid and
// +link{listGrid.canGroupBy,this.canGroupBy} is true, this string will be shown as the
// title for the menu item to toggle the group by setting for a field.<br>
// Default implementation evaulates and returns the dynamic +link{listGrid.groupByText}
// string.
// @param field (ListGridField) field to get the menu item title for
// @return (string) Title to show in the menu item
// @group i18nMessages
// @visibility external
//<
getGroupByText : function (field) {
    var messageArgs = {
        field:field,
        viewer:this
    }
    return this.groupByText.evalDynamicString(this, messageArgs);
},




//> @attr ListGrid.ungroupText (string : "Ungroup" : IRW)
// If we're showing a +link{listGrid.showHeaderContextMenu,headerContextMenu} for this grid, and
// +link{listgrid.isGrouped,this.isGrouped} is true, this
// attribute will be shown as the title for the menu item to ungroup the grid.
// @group i18nMessages
// @visibility external
//<
ungroupText: "Ungroup",


_shouldGroupByField : function (field) {
    var field = this.getField(field);
    return !!(field && this._canGroupByField(field) && 
              this.data.getLength() <= this.groupByMaxRecords);
},
_canGroupByField : function (field) {
    var field = this.getField(field);
    return !!(field && 
              ((this.canGroupBy == true && field.canGroupBy != false) ||
               (this.canGroupBy != false && field.canGroupBy == true)));
},



//> @method listGrid.getHeaderSpanContextMenuItems() 
// Return the menus items that should be shown in a menu triggered from a
// +link{listGrid.headerSpans,headerSpan}.  Default behavior is to return false, meaning no
// contextMenu is shown.
//
// @param name (String) name of the header span
// @param headerSpan (Canvas) the component representing the headerSpan.  This component will
//                            have all the properties specified via +link{listGrid.headerSpans}.
// @return (Array of MenuItem) return false instead to avoid showing a menu
//
// @group headerSpan
// @visibility external
//<
getHeaderSpanContextMenuItems : function (span) {
    if (!this.showTreeColumnPicker && !this.showHeaderSpanContextMenu) return false;

    var menuItems = [{
        title: this.fieldVisibilitySubmenuTitle,
        submenu: this.getColumnPickerItems(),
        icon: "[SKINIMG]actions/column_preferences.png"
    }];

    var grid = this,
        frozen
    ;
    for (var i = 0; i < span.fields.length; i++) {
        var fieldName = span.fields[i],
            field = this.getField(fieldName)
        ;
        if (field && field.frozen) {
            frozen = true;
            break;
        }
    }
    	 
    // show menu for freezing and unfreezing spans.  Don't allow all fields to be frozen.	 
    if (this.canFreezeFields && this.fields.length > 1 &&	 
        (frozen ||	 
         this.frozenFields == null || this.normalFields.length > span.fields.length)	 
       ) 	 
    {	 
        menuItems.add({isSeparator: true});	 
        menuItems.add({	 
            title: (frozen ? "Unfreeze " : "Freeze ") + span.title,	 
            grid:this,	 
            spanFields: span.fields,	 
            frozen: frozen,	 
            icon:(frozen ? "[SKINIMG]actions/unfreeze.png" :	 
                                "[SKINIMG]actions/freezeLeft.png"),	 
            click: function () {	 
                for (var i = 0; i < this.spanFields.length; i++) {
                    grid.completeFields.find(grid.fieldIdProperty, this.spanFields[i]).frozen = !this.frozen;	 
                }	 
                grid.rebuildForFreeze();	 
            }	 
        });	 
    }	 
    return menuItems;    
},

shouldShowColumnPicker : function (fld) {
    // don't allow hiding treeField columns or checkbox columns - it doesn't make much sense and is not
    // currently supported
    if (fld.treeField || this.isCheckboxField(fld)) return false;
            
    var title = this.getSummaryTitle(fld);

    // don't allow hiding columns with no title (because the menu item would then appear
    // blank as well)
    if (title == null || isc.isAn.emptyString(title)) return false;
    if (fld.canHide === false) return false;            

    return true; 
},

getColumnPickerItems : function () {
    var showColumns = [],
        grid = this
    ;

    // create show/hide columns menu items
    for (var i = 0; i < this.completeFields.length ; i++) {
        var fld = this.completeFields[i];
  
        if (!this.shouldShowColumnPicker(fld)) continue;
        
        var title = this.getSummaryTitle(fld);

        var spanConfig = this.spanMap ? this.spanMap[fld.name] : null;
        
        if (this.showTreeColumnPicker && spanConfig) {
            // spanned field - output span toggle if we haven't already
            if (!showColumns.find("spanConfig", spanConfig)) {
                showColumns.add({
                    title: spanConfig.title,
                    // don't auto-dismiss, so that users can show and hide multiple columns at once
                    autoDismiss: false,
                    spanConfig: spanConfig,
                    click : function (target, item, menu) {
                        var spannedFields = this.spanConfig.fields;
                        var hide = this.anySpannedFieldsVisible();
                        spannedFields.map(function (fieldName) {
                            hide ? grid.hideField(fieldName) : grid.showField(fieldName);
                        });
                        menu.body.delayCall("markForRedraw");
                    },
                    anySpannedFieldsVisible : function () {
                        var spannedFields = this.spanConfig.fields;
                        for (var i = 0; i < spannedFields.length; i++) {
                            if (grid.fieldIsVisible(spannedFields[i])) return true;
                        }
                        return false;
                    },
                    enableIf : function (target, menu, item) {
                        var spanConfig = this.spanConfig;
                        for (var i = 0; i < menu.data.length; i++) {
                            var item = menu.data[i];
                            if (grid.fieldIsVisible(item.fieldName) &&
                                !spanConfig.fields.contains(item.fieldName)) return true;
                        }
                        return false;
                    },
                    checkIf : function (target, menu, item) {
                        return this.anySpannedFieldsVisible();
                    }
                });
            }
            title = "&nbsp;&nbsp;&nbsp;&nbsp;"+title;
        }

        showColumns.add({
            title: title,
            fieldName: fld.name,
            prompt: fld.prompt,
            // don't auto-dismiss, so that users can show and hide multiple columns at once
            autoDismiss: false,
            checkIf : function (target, menu, item) {
                return grid.fieldIsVisible(this.fieldName);
            },
            enableIf : function (target, menu, item) {
                return !(grid.fields.length == 1 && grid.fieldIsVisible(this.fieldName));
            },
            click : function (target,item,menu) { 
                // if we're being shown as a submenu of the grouping menu, disable group
                // item if it is the same as the item who will no longer be visible
                var  parentMenu = menu._parentMenu,
                     groupItemIndex = parentMenu ? 
                                     parentMenu.data.findIndex("groupItem", true) : null,
                     groupItem = parentMenu ? parentMenu.data[groupItemIndex] : null,
                     togglingCurrentField = (groupItem && groupItem.fieldName == item.fieldName)
                ;

                if (grid.fieldIsVisible(this.fieldName)) {
                    // make sure length of fields doesn't count checkbox field
                    var fieldsLen = grid.fields.length;
                    if (grid.selectionAppearance == "checkbox") fieldsLen -= 1;
                    // Don't hide the last visible field
                    if (fieldsLen > 1) {
                        grid.hideField(item.fieldName);
                    }
                    // Disable the last checked column, as we don't want it to be able to be
                    // hidden
                    if (fieldsLen == 1) {
                        var visibleItem = menu.data.find("fieldName", grid.fields[0].name);
                        menu.setItemEnabled(visibleItem, false);
                        this._disabledItem = visibleItem;
                    }
                } else {
                    grid.showField(item.fieldName);
                    // if there is a disabled item, enable it, because now we're guaranteed that
                    // its no longer the last item
                    if (this._disabledItem) {
                        menu.setItemEnabled(this._disabledItem, true);
                        this._disabledItem = null;
                    }
                }
                if (togglingCurrentField) {
                    parentMenu.setItemEnabled(groupItemIndex,
                                              grid._shouldGroupByField(groupItem.fieldName));
                }
                menu.body.delayCall("markForRedraw");

            }
        });
    }

    return showColumns;
},

getColumnPickerMenu : function (showColumns) {
    var showColumnsMenu = {
        canHover:true,
        showIcons:true,
        showHover:true,
        cellHoverHTML:function (record) {
            return record.prompt;
        },
        items:showColumns
    };

    return {
        title: this.fieldVisibilitySubmenuTitle,
        submenu: showColumnsMenu,
        icon: "[SKINIMG]actions/column_preferences.png"
    }
},

//> @method ListGrid.getHeaderContextMenuItems()
// If +link{attr:listGrid.showHeaderContextMenu} is <code>true</code> this method returns
// the menu items to be displayed in the default header context menu.
// <P>
// This method will be called each time the menu is displayed, allowing for dynamic content
// depending on the current state of the fields.
// <P>
// The default set of menu items will includes menu items for freezing fields, showing and
// hiding fields, grouping by fields, or other listGrid features 
//
// @param [fieldNum] (integer) Index of the field the user clicked in the
//    +link{listgrid.fields,fields} array. <b>Note:</b> if the user right-clicked the sorter button
//    this parameter will be <code>null</code>.
//   
// @return (Array of MenuItem)
// @group gridHeader
// @visibility external
//<
getHeaderContextMenuItems : function (fieldNum) {
    var field = this.getField(fieldNum);
    
    var menuItems = [], 
        needSeparator = false;
    // add sorting items - corner sort button == sort the current sort field...
    var showSortMenu = this.canSort && ((field && field.canSort != false) || 
                                        (!field && this._getSortFieldNum() != null)); 
    if (showSortMenu) {
        var sortFieldNum = fieldNum != null ? fieldNum : this._getSortFieldNum();
        menuItems[0] = {
            title: this.sortFieldAscendingText,
            icon: "[SKINIMG]actions/sort_ascending.png",
            click: "menu.doSort(" + sortFieldNum + ", 'ascending')"
        };
        menuItems[1] = {
            title: this.sortFieldDescendingText,
            icon: "[SKINIMG]actions/sort_descending.png",
            click: "menu.doSort(" + sortFieldNum + ", 'descending')"
        };
        needSeparator = true;
    }
    // add column visibility chooser
    if (this.canPickFields && this.completeFields.length > 1) {
        var showColumns = this.getColumnPickerItems();
        // skip showing the column visibility menu if we can only toggle visibility on a single
        // field.
        if (showColumns.length > 1) {
            if (needSeparator) menuItems.add({ isSeparator: true } );
            menuItems.add(this.getColumnPickerMenu(showColumns));
            needSeparator = true;
        }
    }
    // add group option
    // canGroupBy a field if:
    // - this.canGroupBy is true and field.canGroupBy is not false
    // - this.canGroupBy is unset and field.canGroupBy is true
    // - there are no frozen fields
    var canGroupBy = this._canGroupByField(field),
        isGrouped = (this.canGroupBy != false) && this.isGrouped;
    if (needSeparator && (isGrouped || canGroupBy)) {
        menuItems.add({ isSeparator: true } );
    }

    if (canGroupBy) {
        // if there is no custom getGroupValue defined, check if there is a custom groupingModes
        // or else fallback to the default simpleType one
        var groupingModes = ( !field.getGroupValue ?
                                   field.groupingModes ?
                                        field.groupingModes :
                                       ( field._simpleType ?
                                            field._simpleType.groupingModes
                                       : false )
                               : false );
        
        var groupBySubmenu = null;
        if (groupingModes) {
            groupBySubmenu = [];
            for (var property in groupingModes) {
                groupBySubmenu.add({
                    title: groupingModes[property],
                    groupType: property,
                    targetField: field,
                    fieldName: field.name,
                    prompt: field.prompt,
                    checked: (field.groupingMode == property),
                    //TODO> check if this field is actually grouped but with different option
                    click: function(target, item, menu) {
                        this.targetField.groupingMode = this.groupType;
                        menu._parentMenu.groupField(item);
                    }
                });
            }
        }
        menuItems.add({
            groupItem: true,
            title: this.getGroupByText(field),
            fieldName: field.name,
            targetField: field,
            prompt: field.prompt,
            icon: "[SKINIMG]actions/groupby.png",
            click: function(target, item, menu) {
                this.targetField.groupingMode = this.targetField.defaultGroupingMode || null;
                menu.groupField(item);
            },
            enabled: this._shouldGroupByField(field),
            canSelectParent: true,
            submenu: groupBySubmenu
        });
        needSeparator = true;
    }
    // if grid is grouped, show ungroup option 
   
    if (isGrouped) {
        menuItems.add({ 
            title: this.ungroupText, 
            click: "menu.ungroup()",
            icon: "[SKINIMG]actions/ungroup.png"
        });
        needSeparator = true;
    }
    
    if (!field) return menuItems;
    
    // show menu for freezing and unfreezing fields.  Don't allow all fields to be frozen.
    if (this.canFreezeFields && this.fields.length > 1 && 
        (field.frozen ||
         (this.frozenFields == null || this.normalFields.length > 1)) &&
         // disallow freezeing of spanned fields
        !(this.spanMap && this.spanMap[field.name])
       )
    {
       
        if (needSeparator) menuItems.add({ isSeparator:true });
        
        menuItems.add({
            title:this.getToggleFreezeText(field),
            grid:this,
            field:field,  
            icon:(field.frozen ? "[SKINIMG]actions/unfreeze.png" :
                                "[SKINIMG]actions/freezeLeft.png"),
            click:"item.grid.toggleFrozen(this.field,!this.field.frozen)"
        });
        
    }
    return menuItems;
},


//>@method ListGrid.getHeaderContextMenu()
// If +link{attr:listGrid.showHeaderContextMenu} is <code>true</code> this method returns
// the menu to display when the user right-clicks on the header or corner sort button of
// this listGrid.<br>
// Default implementation displays the list of available columns, and allows the user to
// change the visibility of each column by selecting the appropriate fieldName.
// @group gridHeader
// @visibility internal
//<
// Leave this internal for now - If a developer wishes to display a custom header context menu
// they can override displayHeaderContextMenu() instead.
// Overriding this method is not as clean - the developer would also need to override 
// getHeaderContextMenuItems(), [which will be called each time the menu is actually shown]
getHeaderContextMenu : function () {

    return this.ns.Menu.create({
	    ID:this.getID() + "_cornerMenu",
        grid : this,
        // On Hide, if we're showing the headerMenuButton, hide it
        hide : function () {
            this.Super("hide", arguments);
            if (this.grid && this.grid.headerMenuButton && this.grid.headerMenuButton.isVisible()) {
                this.grid.headerMenuButton.hide();
            }
        },
        // sorting
        doSort : function (fieldNum, direction) {
            this.grid.sort(fieldNum, direction);
        },
        canHover:true,
        showHover:true,
        cellHoverHTML : function(record,rowNum,colNum) { return record.prompt },
        groupField : function (item) {
            var grid = this.grid;
            if ((item.targetField && item.targetField.groupingMode)||
               ((!grid.groupByField) || !grid.groupByField.contains(item.fieldName))) {
            // if a regroup using a different groupingMode is requested, this condition
            // prevented it from regrouping.
                grid.groupBy(item.fieldName);
            }
                
        },
        
        ungroup : function () {
            this.grid.ungroup();
        }

    });
},

//>	@method	listGrid.getSortArrowImage()	(A)
// Return the sort arrow image used in the sorter button and the current sort col header button.
//		@group	drawing
//		@return	(string)	HTML for sorter button
//<
getSortArrowImage : function () {
    var sortFieldNum = this._getSortFieldNum();
	if (this.canSort && sortFieldNum != null) {
		return this.imgHTML(
            (Array.shouldSortAscending(this.getField(sortFieldNum).sortDirection) ? 
                                                this.sortAscendingImage : this.sortDescendingImage),
			null, null, null, null, this.widgetImgDir);
	} else {
		return isc.Canvas.spacerHTML(1,1);
	}
},

//>	@method	listGrid.sorterClick()	(A)
//		@group	events, sorting
//			handle a click in the sorter button
//		@return	(boolean)	false if !listGrid.canSort
//<
sorterClick : function () {
	// if the list can't sort, return false
	if (!this.canSort) return false;

    var sortFieldNum = this._getSortFieldNum();
    this.sort(
        sortFieldNum, 
        (sortFieldNum != null ? 
            !Array.shouldSortAscending(this.getField(sortFieldNum).sortDirection) : 
            null)
    );
    
},



// Drag Line
// --------------------------------------------------------------------------------------------
// Note that the row and column drag lines are the same Canvas

//>	@method	listGrid.makeDragLine()	(A)
//		@group	dragging, drawing
//			make the dragLine 
//		@return	(boolean)	false if listGrid._dragLine already exists
//<
makeDragLine : function () {
	if (this._dragLine) return false;
	
	// create the dragLine and move it to the front
	
    var dragLine = {
        ID:this.getID()+"_dragLine",
		width:2,
		height:2,
		overflow:isc.Canvas.HIDDEN,
        visibility:isc.Canvas.HIDDEN,
        isMouseTransparent:true, // to prevent dragline occlusion of drop events
        dropTarget:this.body, // delegate dropTarget
		redrawOnResize:false,
        styleName:"dragLine"
	};
    //>!BackCompat 2005.01.01 XXX old skin files didn't define a drag line style, so ensure the
    // line shows up.
    if (this.ns.Element.getStyleEdges(dragLine.styleName) == null) {
        dragLine.backgroundColor = "black";
    } //<!BackCompat
	this._dragLine = this.ns.Canvas.create(dragLine);
	
	return true;
},

//>	@method	listGrid.showDragLineForRecord()	(A)
// Show the drag line relative to a particular record.
// <p>
// If no record number is passed, assumes the one under the mouse.
// <p>
// This is used to show feedback in reordering rows or to insert dragged records at a particular
// row.
//		@group	dragging, drawing
//<
showDragLineForRecord : function (recordNum, position) {
	
    var body = this.body;

	// get the event record
	if (recordNum == null) recordNum = this.getEventRecordNum();

	// if 'recordNum' is -2 - we're in the blank area underneath the last record.  Show the
	// drop line underneath the last record.
	// NOTE: recordNum will never be -1 (above top of list) as willAcceptDrop() returns
	// false in that case (for now)
    var lastVisibleRow = body.getVisibleRows()[1];
	if (recordNum == -2) recordNum = lastVisibleRow;
    
	// if the record is not enabled, you can't drop on it (unless you're trying to drop at the end
	// of the list, which is special)
	if (!this.recordIsEnabled(recordNum) && recordNum != lastVisibleRow) return this._dragLine.hide();

	// before, after (or over)?
    if (position == null) position = this.getReorderPosition(recordNum);
	// now move the dragLine to the proper place and show it
    var leftBody = this.getLeftBody();
    var left = leftBody.getPageLeft() + (this.isRTL() && leftBody.vscrollOn ? this.getScrollbarSize() : 0);
    if (position == isc.ListGrid.BEFORE) {
    	// drag line above record
        this.showHDragLine(left, body.getRowPageTop(recordNum));
        this._dragLine.afterRow = recordNum -1;
    } else if (position == isc.ListGrid.AFTER) {
    	// drag line under record
        this.showHDragLine(left,
                           (body.getRowPageTop(recordNum) + body.getRowSize(recordNum)));
        this._dragLine.afterRow = recordNum;
    } else {
    	// if we are not dropping before or after the record, hide the dragLine and bail.
        return this._dragLine.hide();
    }

    if (this.recordDropMove) {
        this.fireCallback("recordDropMove", "viewer,recordNum,record,position", 
                          [this, recordNum, this.getRecord(recordNum), position])
    }

},

showHDragLine : function (pageLeft, pageTop) {
	// make sure the drag line is set up
	this.makeDragLine();
	// and resize it to span the viewport.  Note: needs to be based on the overall ListGrid,
    // not the body, since there may be multiple bodies with frozen columns.
    
	this._dragLine.resizeTo(
            this.getViewportWidth() - (this.body.vscrollOn ? this.getScrollbarSize() : 0), 2);
    
	// place it
    var bodyTop = this.body.getPageTop(),
        bodyBottom = bodyTop + this.body.getVisibleHeight();
    if (pageTop < bodyTop) pageTop = bodyTop;
    else if (pageTop > bodyBottom) pageTop = bodyBottom;
    this._dragLine.setPageRect(pageLeft, pageTop);
    
	// and show it
	this._dragLine.show();
	this._dragLine.bringToFront();
},


//>	@method	listGrid.showDragLineForField()	(A)
//		Show the drag line relative to a particular field.
//		If no field number is passed, assumes the one under the mouse.
//
//		This is used to show feedback in resizing or moving fields (columns).
//
//		@param	[fieldNum]		(number)	Number of the field to show line for.
//											Default is the field under the mouse.
//		@param	[headerOnly]	(boolean)	Show in the header only (true), or over the entire
//                                          list?  Default is over the entire list (false).
//
//		@group	dragging, drawing
//<
showDragLineForField : function (fieldNum, headerOnly) {
	// make sure the drag line is set up
	this.makeDragLine();
	// and resize it to cover the entire height of the listGrid
	if (headerOnly == true) {
		this._dragLine.resizeTo(2, this.headerHeight);
	} else {
		this._dragLine.resizeTo(2, this.getOuterViewportHeight());
	}
	
	// get the event record
	if (fieldNum == null) fieldNum = this.getEventFieldNum();

	if (fieldNum < 0) {
		this._dragLine.hide();
		return;
	}
	
	// now move the dragLine to the proper place and show it
    
	// dragLine placement:
	// - we shouldn't use body.getColumnLeft() or similar because the body could be displaying
	//   the empty message
	// - resize is from right edge in LTR, left edge in RTL
	// - since the header object may not be doing live redraw, use dragResizeWidth rather than
	//   current header widget width
	// - adjust by 1px to center the 2px-wide drag line
    var resizingField = this.ns.EH.dragTarget,
        left = (!this.isRTL() ? 
        	// resize is from right edge
            resizingField.getPageLeft() + this.ns.EH.dragResizeWidth :
        	// resize if from left edge
            resizingField.getPageRight() - this.ns.EH.dragResizeWidth) - 1;

	this._dragLine.setPageRect(left, this.getPageTop() 
                                     + (this.showFilterEditor ? this.filterEditorHeight : 0));
    this._dragLine.bringToFront();
	this._dragLine.show();
},


//>	@method	listGrid.hideDragLine()	(A)
//		@group	dragging, drawing
//			hide the dragLine
//<
hideDragLine : function () {
	if (this._dragLine) this._dragLine.hide();
},


// Sorting
// --------------------------------------------------------------------------------------------

//>	@method	listGrid.unsort()
// Turn sorting off, typically because data has changed and is no longer sorted.
// <p>
// Calling <code>unsort()</code> disables visual indication of which column is the sort column,
// and calls <code>unsort()</code> on the underlying dataset.
// <P>
// Note that a grid viewing a paged dataset may not be able to support <code>unsort()</code>
// because the sort order is what establishes the row numbering that allows data to be
// fetched in batches.
// <P>
// <code>unsort()</code> is automatically called when records are dropped or value of the
// sorted column is changed.
//
// @group	sorting
// @visibility external
//<
unsort : function () {
	
	if (this.data.unsort && this.data.unsort()) {
        var sortField = this._getSortFieldNum();
        // note that we're not sorted anymore
		this._setSortFieldNum(null);
	
        // tell that toolbar button to unselect / get rid of sort arrow
        if (sortField != null && this.header && isc.isA.Toolbar(this.header)) {
            this.header.deselectButton(sortField);
            var button = this.header.getButton(sortField);
            if (button) button.setTitle(this.getHeaderButtonTitle(button));
        }
            
        // Get rid of the sort arrow in the sorter
		if (this.sorter) this.sorter.setTitle(this.sorter.getTitle());
	}
},


//>	@method	listGrid.resort()
// If a list has become unsorted due to data modification or a call to +link{ListGrid.unsort()} 
// this method will resort the list by the previous sort field / direction.
//
//		@group	sorting
//
//		@return	(boolean)	sorting worked
//<
resort : function () {
    var sortFieldNum = this._getSortFieldNum();
    this._setSortFieldNum(null);
	return this.sort(sortFieldNum);
},

//>	@method	listGrid.sort()   ([])
// Sorts a listGrid explicitly by the column given by sortFieldNum, if provided, in 
// ascending or descending order if specified by sortDirection. If sortFieldNum is not
// provided and listGrid.sortFieldNum is undefined, the data will be sorted by the first
// sortable column according to +link{ListGridField.sortDirection} if specified, or
// +link{ListGrid.sortDirection}.
// <P>
// Updates the sortFieldNum and sortDirection to reflect the new sort order of the grid.
//
// @param [sortField] (string | number) the field name or column number to sort by
// @param [sortDirection] (SortDirection) the direction to sort in
// @return (boolean) sorting worked
//
// @see type:SortDirection
// @group sorting
// @visibility external
//<
_$sort:"sort",
sort : function (sortFieldNum, sortDirection) {

	// just bail if canSort has been set to false on the ListGrid as a whole.
    if (this.canSort == false) return false;

    if (isc.isA.String(sortFieldNum)) sortFieldNum = this.getFieldNum(sortFieldNum);
    // If we are databound, and we have pending edits, the sort may cause us to lose edit
    // values (because the rows get lost from the local cache). Catch this case and warn the
    // user if appropriate.
    if (this.confirmDiscardEdits && this.dataSource != null) {

        if (this.hasChanges() && 
            // If the we have a complete cache, the sort will not drop any edit values
            // (and they will be reassociated with the appropriate rows via remapEditValues)
            // This part of the conditional detects the case wehre the            
            isc.ResultSet && isc.isA.ResultSet(this.data) && !this.data.allMatchingRowsCached()) 
        {
            this.showLostEditsConfirmation({target:this, methodName:"_continueSort"},
                                               {target:this, methodName:"_cancelSort"});
            // this._sortArgs gets cleaned up by the callback methods above
            this._sortArgs = {sortFieldNum:sortFieldNum, sortDirection:sortDirection}
            return;
        }
    }
    
	// remember the current sortField num and direction for redrawing sorter images
	var oldSortFieldNum = this._getSortFieldNum(),
        oldSortDirection = 
            (oldSortFieldNum != null ? 
                        Array.shouldSortAscending(this.getField(oldSortFieldNum).sortDirection) :
                        null);
    
	// if no sortField was specified, assume sorting by the current sort field if there is
    // one, or the first sortable field otherwise.
    if (sortFieldNum == null) {
        if (oldSortFieldNum != null) {
    		sortFieldNum = oldSortFieldNum;
        } else {
        	// if this.sortFieldNum is null, default to the first sortable field
    		for (var i = 0; i < this.fields.length; i++) {
    			if (this.fields[i].canSort != false) {
    				sortFieldNum = i;
    				break;
    			}
            }
        }
    }
    
	// if sortFieldNum is still null, no fields are sortable and we should bail
	if (sortFieldNum == null) return false;
    
    var sortField = this.getField(sortFieldNum);
	// if we can't sort by the specified field, bail!    
    if (sortField == null || sortField.canSort == false) return;

    if (sortDirection == null) {
    	// default to the sortField or overall grid sort direction
        sortDirection = (sortField.sortDirection != null ? 
                         sortField.sortDirection : this.sortDirection);
    }
    
    // normalize the sort direction to a boolean and store it on the grid
    this.sortDirection = sortDirection = Array.shouldSortAscending(sortDirection);
    
	// If we're already sorted in the specified direction by the specified field, bail!
    if (oldSortFieldNum == sortFieldNum && sortDirection == sortField.sortDirection) return;

    // At this point we have the sortFieldNum and sortDirection to perform the sort.
	// Update this.sortFieldNum, sortField.sortDirection
    this._setSortFieldNum(sortFieldNum);
    sortField.sortDirection = sortDirection;    

	// call the sortData() routine to actually sort the data
	this.sortData();
    
	// A note on edit-rows:
	// This sort will change the rowNums for records - if we have unsaved edits for any rows,
	// this means the 'rowNum' will have to be updated for that edit information.
	// We handle this via '_remapEditRows()' called in response to 'dataChanged()', so no need
	// to do any special handling for this here

	// tell that toolbar button to select and refresh
	if (this.header && isc.isA.Toolbar(this.header)) {
		// select the appropriate button
        var sortHeader = this.getFieldHeader(sortFieldNum);
		sortHeader.selectButton(this.getLocalFieldNum(sortFieldNum));

    	// If we changed sort fields, redraw the old sortField (clears out the sort arrow image)
        if (oldSortFieldNum != null && oldSortFieldNum != sortFieldNum) {
            var oldHeader = this.getFieldHeader(oldSortFieldNum),
                oldSortButton = oldHeader.getButton(this.getLocalFieldNum(oldSortFieldNum));
            if (oldSortButton != null) {        
                oldSortButton.setTitle(oldSortButton.getTitle());
            }
        }
            
    	// If we need to, redraw the new sort field (to show the appropriate sort arrow image)
        if (sortFieldNum != oldSortFieldNum || sortField.sortDirection != oldSortDirection) {
            var sortButton = sortHeader.getButton(this.getLocalFieldNum(sortFieldNum));
            if (sortButton != null) {      
                sortButton.setTitle(sortButton.getTitle());
            }
        }
	}

	// if there's a sorter button, redraw that
	if (this.sorter && oldSortDirection != sortField.sortDirection) {
        this.sorter.setTitle(this.sorter.getTitle());
    }
	
	// and mark the list as dirty so it will be redrawn
	this._markBodyForRedraw(this._$sort);
	
	// return true so the caller knows that sorting worked
	return true;
},

_getSortFieldNum : function () {
    if (this.sortFieldNum != null) return this.sortFieldNum;
    // sortField is doc'd, sortFieldNum is not. If sortField is set, resolve to a number,
    // store, and return the number
    if (this.sortField != null) {
        var fieldNum = this.getFieldNum(this.sortField);
        if (fieldNum == -1) fieldNum = null;
        this.sortFieldNum = fieldNum;
        // normalize the sortField attribute to a fieldName for consistency, in case it
        // was originally specified as a field index.
        var fieldName = this.getFieldName(this.sortField);
        this.sortField = fieldName;
        return fieldNum;
    }
    return null;
},

_setSortFieldNum : function (fieldNum) {
    this.sortFieldNum = fieldNum;
    var fieldName = this.getFieldName(fieldNum);
    // update the public 'sortField' attribute in case anyone checks it.
    this.sortField = fieldName;
},

// Callback methods fired when the user attempted to sort this grid and was prompted to save
// pending edits.
// _continueSort will finish the sort (fired when the user has discarded or saved edits)
// _cancelSort simply cleans up the temp '_sortArgs' object. Fired if the user chooses to cancel
// the sort to continue editing.
_continueSort : function () {
    var args = this._sortArgs,
        sortFieldNum = args.sortFieldNum, sortDirection = args.sortDirection;
        delete this._sortArgs;
    this.sort(sortFieldNum, sortDirection);
},

_cancelSort : function () {
    var sortFieldNum = this._sortArgs.sortFieldNum;
    delete this._sortArgs;
    if (this.sortFieldNum != sortFieldNum) this.header.deselectButton(sortFieldNum);
},

//>	@method	listGrid.sortData()	(A)
//		@group	sorting
//			actually sort the data according to the sort characteristics of the list
//<
sortData : function () {
	// if the data or fields arrays haven't been defined, skip the sort
	if (!this.data || !this.fields) return;
	
	// get the field object
	var field = this.fields[this._getSortFieldNum()],
		normalizer = null;

	if (field == null) {
		// if field is null, we've shrunk the number of columns, 
		//	sort re-set sort to column 0
		this._setSortFieldNum(0);
		field = this.fields[0];
	}
	
	if (field.sortNormalizer) {
		// custom normalizer defined
		normalizer = field.sortNormalizer;
	} else if (field.valueMap) {
		// if there's a valueMap, use it as the normalizer, so that with eg enums we sort by the
		// text name rather than the numeric order.
		normalizer = field.valueMap;
		if (isc.isA.String(field.valueMap)) normalizer = this.getGlobalReference(field.valueMap);

	// if an explicit field type is declared, pass that in as a normalizer - the sort method
    // understands this.
	} else if (field.type != null) {
	    normalizer = field.type
    }
	// sort by that field's property
    // pass the grid in as the additional 'context' argument for the sort - this will then
    // be available to the normalizer
	this.data.sortByProperty(field[this.fieldIdProperty], field.sortDirection, normalizer, this);
},

// Embedded Components
// --------------------------------------------------------------------------------------------

// 

// These methods actually implemented in GridRenderer

//> @method listGrid.addEmbeddedComponent() [A]
// Attaches the component to the provided record. If <code>position</code> is specified as 
// <code>"within"</code> the component will be rendered at the top/left edge of the record (may be
// overridden by setting a 'snapTo' on the canvas to align with a different edge), and any 
// percentage sizing will be interpreted as percentage of row size.
// Otherwise it will appear to be embedded within the record, underneath the field values.
// <P>
// Embedded components become children of the grid and will stay attached to a record through
// scrolling, sorting and other operations that cause records to shift position.
// <P>
// If <code>position</code> is set to <code>"expand"</code>, embedded components may offer a
// resize interface, eg, by setting +link{canDragResize:true},
// and the grid will react accordingly, growing or shrinking the record to match the embedded
// component's new extents.
// <P>
// Embedded components can be explicitly removed with +link{removeEmbeddedComponent()}.
// <P>
// If a record is removed from the dataset or is replaced in the dataset, for example, it is
// eliminated through filtering (removes record) or is successfully edited in a databound grid
// (replaces record), the component is cleared but not logically removed from the grid. It is the
// responsibility of code that sets up the embedded component to remove it if the record is removed
// from the dataSet. 
// 
// @param component (Canvas) component to embed
// @param record (ListGridRecord) record to attach the component to
// @param [position] (string) "expand" or "within" (Defaults to "expand").
// @visibility embeddedComponents
//<

//> @method listGrid.removeEmbeddedComponent() [A]
// Removes and embedded component previously associated with the provided record. If 
// <code>destroyOnUnEmbed</code> is <code>true</code> for the component, it will also be
// destroyed.
//
// @param record (ListGridRecord) record that the component was previously attached to
// @param component (Canvas) component to unembed
// @visibility embeddedComponents
//<


// Embedded Editing
// --------------------------------------------------------------------------------------------
// "embedded editing" means editing with a complete DynamicForm as an embedded component 
// appearing underneath the edited row.  This is distinct from "inline editing" where we place 
// form items in individual cells, and can only edit the currently visible fields.

// get the DataSource for editing this record
getRecordDataSource : function (record) {
    return this.dataSource;
},

//> @method listGrid.openRecordEditor()           (A)
// Start editing a record, using an editor embedded in the row
// 
// @param   record   (Object)            record whose detail records should be shown
// @visibility advancedInlineEdit
//<

openRecordEditor : function (record) {
	// don't allow more than one openRecord embedded component at once
    if (this._openRecord != null) this.closeRecord();

	
    var editValues = isc.addProperties({}, record);

	// create a form to edit the record
    var editor = this.ns.DynamicForm.create(
    this.recordEditorProperties,
    {
        autoDraw:false,
        dataSource : this.getRecordDataSource(record),
        numCols : 4,
        values : editValues,
        _embeddedEditRecord : record
    });
	// place it in a simple stack with a save button
    var component = this.ns.VStack.create({
        autoDraw:false,
        width:this.getAvailableFieldWidth() - this.embeddedComponentIndent,
        left:this.embeddedComponentIndent,
        destroyOnUnEmbed:true,
        members:[
            editor,
            this.ns.Toolbar.create({
                autoDraw:false,
                width: 200,
                buttons : [
                    { title : this.recordEditorSaveButtonTitle,
                      click : this.getID() + ".embeddedSaveRecord(" + editor.getID() + ")",
                      extraSpace:10
                    },
                    { title : this.recordEditorCancelButtonTitle,
                      record : record,
                      grid : this,
                      click : function () {
                          var stack = this.parentElement.parentElement;
                          this.grid.closeRecord(this.record, stack);
                      }
                    }
                ]
            })
        ]
    });
    this.addEmbeddedComponent(component, record, this.data.indexOf(record));

    this._openRecord = record;
    this._openRecordComponent = component;
},

// when the user hits Save during embedded editing, tell the editor to save
embeddedSaveRecord : function (editor) {
	// hold onto the record via the context since we'll need it to get rid of the embedded editor
    editor.saveData({target:this, methodName:"embeddedEditComplete"},
                    {_embeddedEditRecord:editor._embeddedEditRecord,
                     _embeddedEditor:editor});
},

// when the save attempt completes, if there were no errors, remove the embedded editor.
// Otherwise leave it there to show validation errors and allow further editing
embeddedEditComplete : function (response, data, request) {
    if (response.status == 0) {
        this.removeEmbeddedComponent(request._embeddedEditRecord, request._embeddedEditor);
    }
},

//> @method listGrid.closeRecord()
// Close the currently shown embedded component.
//
// @visibility nestedGrid
//<
closeRecord : function (record, component) {
    if (!record) record = this._openRecord;
    if (!component) component = this._openRecordComponent;
    this.removeEmbeddedComponent(record, component);
    this._openRecord = null;
    this._openRecordComponent = null;
},

// Nested Master-Detail
// --------------------------------------------------------------------------------------------

//>	@method	listGrid.openRecordDetailGrid()	(A)
// Show records from another DataSource which are related to this record, in a nested
// ListGrid.
// <P>
// This is often called a "master-detail" view.  The classic example is salesOrder records
// which contain lineItems.
// <P>
// The <code>childDS</code> should be a DataSource that declares a foreignKey relationship to
// the DataSource the current grid is viewing.
// 
// @param   record   (Object)            record whose detail records should be shown
// @param   childDS  (DataSource or ID)  dataSource to retrieve detail records from
// @visibility nestedGrid
//<
openRecordDetailGrid : function (record, childDS) {
	// don't allow more than one openRecord embedded component at once
    if (this._openRecord != null) this.closeRecord();

    var subGrid = this.getRecordDetailGrid(record, childDS);
	// and embed it in the target record
    var component = isc.VLayout.create({
        autoDraw:false, 
        destroyOnUnEmbed:true,
        height:this.cellHeight, // since the Layout is overflow:visible this is just a minimum
        left:this.embeddedComponentIndent,
        width:this.getAvailableFieldWidth() - this.embeddedComponentIndent,
        resizeBarSize:4,
        members:[subGrid]
    });

    this.addEmbeddedComponent(component, record, this.data.indexOf(record));
    
    var childDS = isc.DataSource.getDataSource(subGrid.dataSource);
    subGrid.fetchRelatedData(record, this.getRecordDataSource(record));

    this._openRecord = record;
    this._openRecordComponent = component;
},

//>	@method	listGrid.getRecordDetailGrid()	(A)
// Returns a ListGrid to show the records from another DataSource which are related to this
// record via a child dataSource
// 
// @param   record   (Object)            record whose detail records should be shown
// @param   childDS  (DataSource or ID)  dataSource to retrieve detail records from
// @visibility internal
//<
getRecordDetailGrid : function (record, childDS) {

    childDS = isc.DataSource.getDataSource(childDS);

	// create a ListGrid to show them
    var subGrid = 
        isc.ListGrid.create(
            this.recordDetailGridProperties,
            {
                autoDraw:false,
                dataSource:childDS,
                showResizeBar:true,
        	    // XXX the embedded grid needs to inherit a lot of properties from it's parent grid -
            	// this particular one is critical because otherwise context menu events will bubble to
            	// this grid, and it will show non-sequitur context menus on the embedded grid.
                showCellContextMenus:this.showCellContextMenus
            }, this.nestedGridDefaults
        );

    return subGrid;
},

// Charting
// ---------------------------------------------------------------------------------------

// types of charting:
// - take any single row and plot it as a single series 
//   - field names label the values
// - take any single column and plot it as a single series 
//   - values from another column label the values
// - take a set of rows and a set of columns and plot it as a multi-series 
//   - dataset is 2d: both field names *and* values from another column label the values 

//> @method listGrid.chartData()
// Chart the data in this listGrid as a multi-series chart.
// <P>
// Each row provides a series of data.  Each series of data is labelled by a value from one
// column, called the <code>labelField</code>.  
// <P>
// For example, cell values are sales figures, and fields are "Product", "August",
// "September", "October".  In this case each row gives a series: sales figures for each of 3
// months.  The <code>labelField</code> in this case is the "Product" field, meaning each row
// represents sales figures for each of 3 months for a particular product.  This dataset
// can be charted via any multi-series chart: stacked or clustered bar or column chart, line
// chart with multiple lines, or area chart (stacked lines).
// <P>
// By default, all visible fields other than the label field are assumed to be labels for
// series values, but an explicit list of fields can be provided as <code>dataFields</code>.
// <P>
// By default, all data is charted if all data is loaded, otherwise, data visible in the
// viewport is charted.  An explicit set of rows can be provided via <code>dataRows</code>.
// 
// @param labelField (String) name of the field
// @param [dataFields] (Array of String) optional list of fields to use as labels.  By
//      default, all fields are used. 
// @param [dataRows] (Array of ListGridRecord) set of records to chart.  Can be obtained by eg
//      +link{ResultSet.getRange,grid.data.getRange()}.
// @param [chartProperties] (Chart Properties) properties to pass to the created chart
// @param [labelFieldFirst] (boolean) if true, use the labelField as the "first" set of labels,
//      for example, as the bar labels in a stacked bar chart, whereas the second set of labels
//      would appear as the legend.
//
// @return (Chart) created Chart instance
//
// @visibility external
// @example gridCharting
//<
chartData : function (labelField, dataFields, dataRows, properties, labelFieldFirst) {
    
    if (labelField) labelField = this.getField(labelField);
    if (dataFields) dataFields = this.map("getField", dataFields);
    else {
        // assume all fields other than a labelField contain values
        dataFields = this.fields.duplicate();
        dataFields.remove(labelField);
    }

    // default for dataRows: all rows, or visible rows if paging
    if (!dataRows) {
        if (!isc.ResultSet || !isc.isA.ResultSet(this.data)) {
            dataRows = this.data;
        } else if (this.data.allMatchingRowsCached()) {
            dataRows = this.data.getAllRows();
        } else {
            var visibleRows = this.getVisibleRows();
            dataRows = this.data.getRange(visibleRows[0], visibleRows[1]);
        }
    }
    
    // form a facet representing the column headers, aka, the fields.  This is an inlinedFacet,
    // meaning it has multiple values per record under property names indicated by its
    // facet.values
    var rowFacet, columnFacet;
    if (dataFields.length > 1) {
        columnFacet = {
            title:this.valueTitle,
            values: dataFields, 
            inlinedValues:true
        };
    }

    // form a facet representing row headers, aka, one column of data intended as labels
    if (dataRows.length > 1 && labelField) {
        rowFacet = { id: labelField.name };
    }

    // remove unspecified facets to allow just single row or single column charting
    var facets = [columnFacet,rowFacet];
    facets.remove(null);

    // for multi-series charts, allow specifying which facet comes first (eg, for stacked bar
    // charts, appears as a bar label (first) or appears as a legend labelling colors (second)
    if (labelFieldFirst) facets.reverse();

    var props = isc.addProperties({
        data: dataRows,
        facets : facets,
        title:this.chartTitle
    }, properties);

    // single column charting: the (singular) dataField holds the value
    if (rowFacet && !columnFacet) props.valueProperty = dataFields[0].name;
    // otherwise, we have an "inlinedValues" facet: there is no single valueProperty, rather
    // each record contains multiple values stored under the ids of the inlinedFacet's values
        
    return this.createAutoChild("chart", props, this.chartConstructor); 
},

chartConstructor:"FusionChart",

//> @method listGrid.chartRow()
// Chart a single row of data, with each cell value labelled by the column header.
//
// @param rowNum (Number) row to chart
// @param [dataFields] (Array of String) optional list of fields to use as labels.  By
//      default, all fields are used. 
// @param [chartProperties] (Chart Properties) properties to pass to the created chart
// @return (Chart) created Chart instance
//
// @visibility external
//<
chartRow : function (rowNum, dataFields, chartProperties) {
    return this.chartData(null, dataFields, [this.getRecord(rowNum)], chartProperties);
},

//> @method listGrid.chartColumn()
// Chart a single column of data, with each cell value labelled by a value from another
// column.
//
// @param dataColumn (String) name of the ListGridField to use as a data
// @param labelColumn (String) name of the ListGridField to use as labels for data
// @param [chartProperties] (Chart Properties) properties to pass to the created chart
// @return (Chart) created Chart instance
//
// @visibility external
//<
chartColumn : function (dataColumn, labelColumn, chartProperties) {
    return this.chartData(labelColumn, [dataColumn], null, chartProperties);
},

// Grouping
// --------------------------------------------------------------------------------------------
// perform the actual operation of grouping the grid. Takes listgrid.data as input,
// and rewrites it (it is also an output); it stores the original object reference in
// listgrid.originalData.
regroup : function (fromSetData) { 
    // This function is responsible for knowing if grouping ought to be performed.
    // Check all reasonable things here.
	if (!this.isGrouped || (this.canGroupBy == false) || !this.groupByField || 
        !this.groupByField.length || this.inhibitRegroup || 
        !(this.originalData || this.data) || 
        !(this.originalData || this.data).getLength()) 
    {
        return;
	}
	
    // if this.data already contains a grouped grid, use the original source
    // data instead.
    var currData;
    if (this.data.isGroupedOutput && this.originalData) currData = this.originalData;
    else                            this.originalData = currData = this.data;
    
    // Ensure all rows are read and available.
    var len = currData.getLength();
    if (isc.ResultSet && isc.isA.ResultSet(currData) 
        && (!currData.lengthIsKnown() || !currData.rangeIsLoaded(0, len - 1))) 
    {
            currData.getRange(0, len-1);
            this._markForRegroup = true;
            this.logInfo("postponing grouping until data is loaded", "grouping");
            return;
    }

    // If there are too many rows, don't group and display the original data.
    if (len >= this.groupByMaxRecords) {
        this.logInfo("Results too numerous - disabling grouping.", "grouping");
        // let other components know that we're not grouped
        this.isGrouped = false;
        if (this.originalData) this.data = this.originalData;
        return;
    }    
   	
	// clean up the previous groupTree, then create it
	if (this.groupTree) {
        this.ignore(this.groupTree, "changeDataVisibility");
        this.groupTree.destroy();
    }

	this.groupTree = this.createAutoChild("groupTree", {
		dataSource: this.dataSource, 
		defaultLoadState: isc.Tree.LOADED,
        loadDataOnDemand: false,
        // specify parentIdField explicitly.  Otherwise, for a DataSource that declares a tree 
        // relationship, ResultTree will pick parentIdField based on the DataSource and clobber
        // that field with parent pointers related to grouping
        parentIdField: "groupParentId",
        titleProperty: "groupValue",
		childrenProperty: "groupMembers",
        parentProperty: "_groupTree_" + this.ID,
        showRoot: false,
		isGroupedOutput: true
	}, (this.dataSource ? isc.ResultTree : isc.Tree ));

    this.logInfo("Adding " + currData.getLength() + " records to groups", "grouping");

	// create grouped tree from flat data
	for (var i = 0; i < currData.getLength(); i++) {
        this._addRecordToGroup(currData.get(i), false);
	}
    
	// set group titles, traverse the tree in level order
    var currNode = this.groupTree.getRoot(), 
        currIndex = 0, 
        groupsVisited = 0, 
        tree = this.groupTree
    ;
    // while there are still more groups, keep going
    while (currNode != null && groupsVisited < this.groupByField.length) {
        // traverse the children, getting the group title for each of them
        var currChildren = tree.getChildren(currNode);
        for (var i = 0; i < currChildren.length; i++) {
            var fld = (this.completeFields||this.fields).find(this.fieldIdProperty, this.groupByField[groupsVisited]);
            
            // Only pick up default groupingModes / groupTitle if getGroupValue has not been
            // overridden.
            // Standard groupingModes will have no meaning to a custom getGroupValue() method.
            // Note that the inverse is not true: groupingModes or getGroupTitle() may be modified
            // for EG localization, but rely on the standard getGroupValue behavior

            var isSimpleType = fld.getGroupTitle ? "false" :
                                   !fld.getGroupValue ?
                                       (fld._simpleType &&
                                        fld._simpleType.getGroupTitle) ? "true" : null
                                   : null;

            if (isSimpleType == "false") {
                var currChild = currChildren[i];
                currChild.singleCellValue = 
                        fld.getGroupTitle(currChild.groupValue, currChild, fld, fld.name, this);
            }
            else if (isSimpleType == "true") {
                var currChild = currChildren[i];
                currChild.singleCellValue =
                        fld._simpleType.getGroupTitle(currChild.groupValue, currChild,
                                fld, fld.name, this);
            }
        }
        // if theres another sibling, move to it and process its groups
        if (tree.getParent(currNode) && 
            tree.getChildren(tree.getParent(currNode))[currIndex + 1]) {
            currIndex++;
            currNode = tree.getChildren(tree.getParent(currNode))[currIndex];
        // otherwise, move down the tree to the next group
        } else {
            currNode = tree.getChildren(currNode).first();
            currIndex = 0;
            groupsVisited++;
        }
    } 
   
    this.openInitialGroups();
    
    // Set .data directly, because this may be called from setData() anyway.
    this.data = tree;
    
    if (!fromSetData) {
        this._observeGroupData(this.data);    
    } else {
        // observe the changeDataVisibility so we redraw and reset editors on folder toggling
        // Note we're still observing 'dataChanged' on this.data 
        this.observe(tree, "changeDataVisibility", "observer._folderToggleObservation()");
    }
    // reset the selection model so the user can select items in the tree
    this.createSelectionModel();
},

// Update grouping of the grid for a single changed record. Originally in
// _fireCellChanged.
_incrementalRegroup : function (record, originalRecord, rowNum, newValues) {
    // If changes are made locally, this code is responsible for updating
    // groups and records. If this grid is databound, the server update will
    // reset this.data to the new values, and regroup() (called from dataChanged())
    // will update the groups.
    
    this._suppressFolderToggleRedraw = true;
    // first remove record
    var groups = this.data.getParents(originalRecord);
    var removeSucceeded = this.data.remove(originalRecord);
    // next recalc group titles and remove empty groups
    for (var i = 0, j = this.groupByField.length - 1; i < groups.length - 1; i++) {
        var currGroup = groups[i];
        if (currGroup.groupMembers.getLength() == 0) {
            this.data.remove(currGroup);
        } else {
            //isc.logWarn(this.groupByField[0]);
            var fld = (this.completeFields||this.fields).find(this.fieldIdProperty, this.groupByField[j]);

            // Only pick up default groupingModes / groupTitle if getGroupValue has not
            // been overridden.
            // Standard groupingModes will have no meaning to a custom getGroupValue()
            // method.
            // Note that the inverse is not true: groupingModes or getGroupTitle() may be
            // modified for EG localization, but rely on the standard getGroupValue
            // behavior.

            var isSimpleType = fld.getGroupTitle ? "false" :
                                   !fld.getGroupValue ?
                                       (fld._simpleType &&
                                        fld._simpleType.getGroupTitle) ? "true" : null
                                   : null;

            if (isSimpleType == "false") {
                currGroup.singleCellValue = fld.getGroupTitle(currGroup.groupValue,
                   currGroup, fld, fld.name, this);
            }
            else if (isSimpleType == "true") {
                currGroup.singleCellValue = fld._simpleType.getGroupTitle(
                    currGroup.groupValue, currGroup, fld, fld.name, this);
            }
        }
        j--;
    }

    // re-add record to group.
    // record may be null if eg adding a new record to unbound data. If it is,
    // add the new values instead - they represent what was added.
    // if original remove failed and we had data to begin with, don't add - 
    // it's already been added elsewhere
    if (!(originalRecord && !removeSucceeded) && (record || newValues))
        this._addRecordToGroup(record || newValues, true);
},

openInitialGroups : function () {
    var tree = this.groupTree;
                  
	// group open options
	if (this.groupStartOpen == "all") {
		tree.openAll();
	} else if (this.groupStartOpen == "first") {
		tree.openAll(tree.getChildren(tree.getRoot()).first())
    } else if (isc.isAn.Array(this.groupStartOpen)) {
        // specific field values
        var children = tree.getChildren(tree.getRoot());
        for (var i = 0; i < this.groupStartOpen.length; i++) {
            var value = this.groupStartOpen[i];
            var folder = children.find("groupValue", value);
            if (folder) tree.openFolder(folder);
        }
    }
},


//> @method listGrid.groupBy()
// Display the current set of records grouped by their values for the given field or
// fields. With no arguments, disables all grouping.
// <P>
// Grouping tranforms the current dataset into a Tree on the fly, then provides a familiar tree
// interface for exploring the grouped data.
// <P>
// Grouping works automatically with any dataset, providing simple default grouping based on
// each field's declared type.  However, you can use the
// +link{listGridField.getGroupValue,field.getGroupValue()} API to control how records are
// grouped, and the +link{listGridField.getGroupTitle,field.getGroupTitle()} API to control
// how groups are titled.
// <P>
// Grouping can be performed programmatically via this API, or you can set
// +link{canGroupBy,grid.canGroupBy:true} to enable menus that allow the user to performing
// grouping. To group a grid automatically, instantiate the grid with a
//  +link{listgrid.groupByField} setting.
// <P>
// While grouped, the automatically created Tree is available as
// +link{groupTree,grid.groupTree} and the original dataset is availabe as
// +link{originalData,grid.originalData}.
//
// @param   [arguments 0-N] (String) name of fields to group by
// @visibility external
// @group grouping
// @example dynamicGrouping
//<
groupBy : function (groupFieldName) {
    // support passing an Array instead of passing as a series of arguments
    var fields = [];
    if (isc.isAn.Array(groupFieldName)) {
        fields = groupFieldName;
    } else {
        fields = arguments;
    }

	// if arguments are null, return to original grouping
	if (fields.length == 0 || fields[0] == null) {
        this.logInfo("ungrouping", "grouping");
        this.isGrouped = false;
		if (this.originalData) {
			this.setData(this.originalData);
			delete this.originalData;
            
            // Clear our pointer to this.groupTree if we have one.
            // Note: setData will actually destroy the groupTree if it's currently being shown
            // (As it destroys this.data)
			delete this.groupTree;
            if (this.groupByField) this.groupByField.setLength(0);
		}
		return;
	}
   
    // store grouped fields for future reference
    if (this.groupByField) this.groupByField.setLength(0);
    else this.groupByField = [];
    for (var i = 0; i < fields.length; i++) {
        // don't allow the checkbox field to be grouped; shouldn't be possible, but check 
        // just in case
        if (this.isCheckboxField(fields[i])) continue;
        this.groupByField.add(fields[i]);    
    }
        
    this.logInfo("groupBy: " + this.groupByField, "grouping");

	this.isGrouped = true;
    this._markForRegroup = true;
    this.dataChanged();
},

groupIconPadding: 5,
//> @method listGrid.getGroupNodeHTML
// Returns the HTML code necessary to render a group node, including icon, title, and padding.
// The amount of the padding is at least +link{listGrid.groupLeadingIndent} pixels, and
// an additional +link{listGrid.groupIndentSize} pixels for each increasing level of the
// node.
// @param node (Object) Specified group node
// @visibility external
//<
getGroupNodeHTML : function (node, gridBody) {
    var isFrozenBody = this.frozenBody === gridBody;
    if (this.frozenBody && !isFrozenBody) return this.emptyCellValue;
    var state = this.data.isOpen(node) ? "opened" : "closed",
        url = isc.Img.urlForState(this.groupIcon, null, null, state),
        iconIndent = isc.Canvas.spacerHTML(this.groupIconPadding, 1),
        groupIndent = 
            isc.Canvas.spacerHTML((this.data.getLevel(node) - 1) * this.groupIndentSize +
            this.groupLeadingIndent, 1);
    var img = this.imgHTML(url, this.groupNodeSize, this.groupNodeSize);
    return groupIndent + img + iconIndent + node[this.singleCellValueProperty];
},
// helper function for adding a record to an existing group, or creating a new group
_addRecordToGroup : function (record, setGroupTitles) {
    var node, currRoot = this.groupTree.getRoot();
	   
    for (var i = 0; i < this.groupByField.length; i++) {
        // find index of field w/ fieldName
        var fieldName = this.groupByField[i],
            fieldIndex = (this.completeFields||this.fields).findIndex(this.fieldIdProperty, fieldName),
		    field = (this.completeFields||this.fields).get(fieldIndex);

        // get the groupValue    
        var fieldValue = this.getRawCellValue(record, i, fieldName, true);
        if (field.getGroupValue) {
            fieldValue = field.getGroupValue(fieldValue, record, field, fieldName, this);
        }
        else if(field._simpleType && field._simpleType.getGroupValue) {
            fieldValue = field._simpleType.getGroupValue(fieldValue, record, field, fieldName, this);
        }
        if (field.valueMap && field.valueMap[fieldValue]) { 
            fieldValue = field.valueMap[fieldValue];
        }
        if (fieldValue == null || isc.isAn.emptyString(fieldValue)) {
            fieldValue = this.nullGroupTitle;
        }
        
        // find the group, if it exists
        if (this.groupTree.getChildren(currRoot) == null) node = null;
        else node = this.groupTree.getChildren(currRoot).find('groupValue', fieldValue);
        if (!node) { // add new group
            node = { singleCellValue: fieldValue, 
                groupValue: fieldValue, _isGroup: true, canDrag: false};
            // make sorting work
            node[fieldName] = fieldValue;
			// set group style
			node[this.recordCustomStyleProperty] = this.groupNodeStyle
			// set non-editable
			node[this.recordEditProperty] = false
            // add to the current group
			this.groupTree.add(node, currRoot);
        }
        // move to next group
        currRoot = node;
    }
    // add record to group   
    this.groupTree.add(record, currRoot);
    // set the group titles if need be, mainly for dragging records in
    // start with the topmost group
    if (setGroupTitles) {
        var groups = this.groupTree.getParents(record);
        for (var i = groups.length - 2, j = 0; i >= 0; i--, j++) {
            var fld = (this.completeFields||this.fields).find(this.fieldIdProperty, this.groupByField[j]);

            // Only pick up default groupingModes / groupTitle if getGroupValue has not been
            // overridden.
            // Standard groupingModes will have no meaning to a custom getGroupValue() method.
            // Note that the inverse is not true: groupingModes or getGroupTitle() may be modified
            // for EG localization, but rely on the standard getGroupValue behavior

            var isSimpleType = fld.getGroupTitle ? "false" :
                                   !fld.getGroupValue ?
                                       (fld._simpleType &&
                                        fld._simpleType.getGroupTitle) ? "true" : null
                                   : null;

            if (isSimpleType == "false") {
                var currGroup = groups[i];
                currGroup.singleCellValue = 
                    fld.getGroupTitle(currGroup.groupValue, currGroup, fld, fld.name, this);
            }
            else if (isSimpleType == "true") {
                var currGroup = groups[i];
                currGroup.singleCellValue =
                    fld._simpleType.getGroupTitle(currGroup.groupValue, currGroup,
                            fld, fld.name, this);
            }
        }
    }
},

//> @method listGrid.ungroup()
// Removes the grouping from the listgrid, restoring its original data
//
// @visibility external
//<
ungroup : function () {
	this.groupBy(null);
},


//> @method listGrid.setHeaderSpans()
// Update the headerSpans configuration on the grid dynamically.
//
// @param name (Array of HeaderSpan) same configuration block as that passed to
//                                   +link{listGrid.headerSpans}.
//
// @group headerSpan
// @visibility external
//<
setHeaderSpans : function (headerSpans) {
    this.headerSpans = headerSpans;
    this.updateHeader();
    this.layoutChildren("headerSpans changed");
},


//> @method listGrid.setHeaderSpanTitle()
// Update the title of a +link{listGrid.headerSpans,headerSpan} dynamically.
//
// @param name (String) name of the headerSpan, as specified via +link{headerSpan.name}.
// @param newTitle (String) new title for the headerSpan
//
// @group headerSpan
// @visibility external
//<
setHeaderSpanTitle : function (name, newTitle) {
    var spanConfig = this.headerSpans.find("name", name);
    if (!spanConfig) {
        this.logWarn("setHeaderSpanTitle() - unable to locate span named: "+name
                     +this.getStackTrace());
        return;
    }
    spanConfig.title = newTitle;
    if (spanConfig.liveObject) spanConfig.liveObject.setTitle(newTitle);
},

// GridRenderer / ListGrid API routing
// --------------------------------------------------------------------------------------------

// if this LV defines any of the GridRenderer's APIs, route those methods through to the LV.  See
// LV.classInit()
addBodyPassthroughMethods : function (body) {
	// if the body hasn't been created yet, bail - we always add the passthrough methods when we
	// create the body
    if (!this.body) return;
    this.bodies.map("_addBodyPassthroughMethods");
},

_addBodyPassthroughMethods : function (body) {

    var body2LGMethods = {},
        methodNames = isc.getKeys(isc.ListGrid._passthroughMethods);
    for (var i = 0; i < methodNames.length; i++) {
        var methodName = methodNames[i],
            methodOnListGrid = this[methodName];

    	// the cellContextClick stringMethod is specially overridden
    	// - The GR.cellContextClick method is overridden to fire LG._cellContextClick()
    	//   That will handle creating the context menu, as well as firing any developer-defined
    	//   'cellContextClick' stringMethod.
        if (methodName == "cellContextClick") continue;

        // If the method is being cleared out, ensure we clear out any passthrough method
        // we may have previously set up
        if (methodOnListGrid == null) {
            
            body2LGMethods[methodName] = body.getClass().getPrototype()[methodName];

    	// if this method has been overriden on the LG
        } else if (methodOnListGrid != isc.ListGrid._passBackMethods[methodName]) {
        	// install a passthrough method on the body to call the LG 
            body2LGMethods[methodName] = isc.ListGrid._passthroughMethods[methodName];
        }
    }
    body.addMethods(body2LGMethods);
},
    
// anytime methods are added on the fly to a ListGrid instance, install passthrough functions
// on the body.  This makes sure that if you eg add a cellHover function on the fly, we notice
// and set up a passthrough from the body.

addProperties : function (methods) {
    this.Super("addProperties", arguments);
    this.addBodyPassthroughMethods();
},

addMethods : function (methods) {
    this.Super("addMethods", arguments);
    this.addBodyPassthroughMethods();
},

// React to 'setProperties()' modifying drag related properties by updating 
// 'canDrag' / 'canAcceptDrop' / etc
_$dragProperties : {
    canDragSelect:true,
    canDragRecordsOut:true,
    canReorderRecords:true,
    canAcceptDroppedRecords:true
},
// React to changes to 'alternateRecordStyles', 'fixedRecordHeights', et al by 
// changing the related property ('alternateRowStyles', etc) on the body.
_$gridPropertyRenames : {

        // We have an explicit setBodyOverflow so no need to catch this case
        // overflow:this.bodyOverflow,
        bodyBackgroundColor:"backgroundColor",
        bodyStyleName:"styleName",
        
    	// Note updating fixedRowHeights on the body is required in addition to the fact
        // we pass our "shouldFixRowHeight()" method through to the body.
        // That method has no effect if fixedRowHeights is false on the GridRenderer.
        fixedRecordHeights:"fixedRowHeights",
        
        fixedFieldWidths:"fixedColumnWidths",
        alternateRecordStyles:"alternateRowStyles",
        alternateRecordFrequency:"alternateRowFrequency",
        showAllRecords:"showAllRows"
},
// propertyChanged - fired by setProperties for each modified property.
propertyChanged : function (propName, value) {
    this.invokeSuper(isc.ListGrid, "propertyChanged", propName, value);
    if (this._$dragProperties[propName]) this._dragPropertyChanged = true;
    if (this.body == null) return;
    if (isc.ListGrid._gridPassthroughProperties.contains(propName)) {
        this.body[propName] = value;
    }
    if (this._$gridPropertyRenames[propName] != null) {
        this.body.setProperty(this._$gridPropertyRenames[propName], value);
        // markForRedraw to display the changes
         
        this.markForRedraw();
    }
},

// doneSettingProperties - fired after all the properties have been updated.
doneSettingProperties : function () {
    if (this._dragPropertyChanged) this._setUpDragProperties();
}

});

//
// Register 'stringMethods' for ListGrid instances
// NOTE: all GridRenderer StringMethods are available on the LV too; see classInit()

isc.ListGrid.registerStringMethods(isc.GridRenderer._gridAPIs);
isc.ListGrid.registerStringMethods({
	// XXX the list of variables available for an expression is good here, but as method signatures
	// these look wacky.  Should probably be:
	// recordClick:"record,field,value,rawValue,rowNum,colNum"
    recordClick : "viewer,record,recordNum,field,fieldNum,value,rawValue",
    recordDoubleClick : "viewer,record,recordNum,field,fieldNum,value,rawValue",
    
    
    recordsDropped : "records,rowNum,viewer,sourceWidget",
    recordDropMove : "viewer,recordNum,record,position",

	//>!BackCompat 2004.12.10
	//> @method listGrid.editValueChanged    
	// Callback fired when an edit modifies the value of a cell (before attempting to save that
	// value permanently)
	//
	// @param	rowNum	   (number)	row number for the cell
	// @param   fieldName   (string)    name of the edited field
	// @param	newValue   (any)    new value for the cell
	// @param	oldValue   (any)    old value for the cell
	// @visibility internal
	// @deprecated  As of SmartClient 5.5, use +link{listGrid.editorChange}.
	//  @group  editing
	//<
    editValueChanged : "rowNum,fieldName,newValue,oldValue",
	//<!BackCompat

	//> @method listGrid.editorChange
	// Callback fired when an edit modifies the value of a cell (before attempting to save that
	// value permanently)
	//
	// @param   record      (ListGridRecord)    record being edited (null if this is a new row)
	// @param	newValue   (any)    new value for the cell
	// @param	oldValue   (any)    old value for the cell
	// @param	rowNum	   (number)	row number for the cell
	// @param   colNum      (number) column number of the cell
	// @visibility advancedInlineEdit
	//  @group  editing
    // @example calculatedCellValue
	//<
    editorChange : "record,newValue,oldValue,rowNum,colNum",
    
	//> @method listGrid.cellChanged    
	// Fires after user edits have been successfully saved to the server, when the new value
    // doesn't match the value before editing.
    // <p>
    // If you want immediate notification of a changes <b>before</b> changes has been saved to the
    // server, implement +link{listGridField.change,field.change()} or
    // +link{listGridField.changed(),field.changed()} instead.
    // <P>
    // You can supply this method on the listGrid instance or on the listGridField(s) that you
    // want to receive cellChanged events for.  If both a field and the listGrid define a
    // cellChanged method and that field receives an edit save, only the one defined on the
    // field is called.
	//
	// @param	record     (ListGridRecord)	record for the cell being changed
	// @param	newValue   (any)    new value for the cell
	// @param	oldValue   (any)    old value for the cell
	// @param	rowNum	   (number)	row number for the cell
	// @param	colNum	   (number)	column number of the cell
	// @param	grid       (ListGrid)	grid where cell was changed.  Also available as "this"
	// @group  editing
    //
	// @see listGridField.cellChanged()
	// @visibility external
	//<
	// NOTE: extra recordNum/fieldNum parameters allow limited backward compatibility, since any
	// time a string expression is provided, parameter order doesn't matter.
	// old signature: recordNum,fieldNum,newValue,oldValue
    cellChanged : "record,newValue,oldValue,rowNum,colNum,grid,recordNum,fieldNum",


    
    
    //> @method listGrid.editComplete()
	// Callback fired when inline edits have been successfully saved.
    // <P>
    // No default implementation.
    //
    //  @group  editing
    //
    // @param rowNum (number) current index of the row that was saved
    // @param colNum (number) index of the column that was saved, if applicable
    // @param newValues (any) new values that were saved
    // @param oldValues (any) old values before the save occurred
    // @param editCompletionEvent (editCompletionEvent) Event that led to the save
    // @param [dsResponse] (DSResponse) for DataSource saves, DSResponse object returned
    // @visibility external
    //<
    editComplete : "rowNum,colNum,newValues,oldValues,editCompletionEvent,dsResponse",

    //> @method listGrid.editFailed   (A)
    // Called when an attempt to save inline edits fails, due to a validation error or other
    // server error.
    // <P>
    // The default implementation of editFailed does nothing for normal validation errors,
    // which are displayed before editFailed() is called.  For any other errors, the default
    // implementation will call +link{classMethod:RPCManager.handleError()}, which by default
    // will result in a warning dialog.
    //
    //  @group  editing
    //
    // @param rowNum (number) current index of the row we attempted to save
    // @param colNum (number) index of the column where the edit failed, if applicable
    // @param newValues (any) new values that we attempted to save
    // @param oldValues (any) old values before the save occurred
    // @param editCompletionEvent (editCompletionEvent) Edit completion event that led to the save
    //                                                  attempt
    // @param [dsResponse]   (DSResponse)    DSResponse, for saves through a DataSource
    //
    // @visibility external
    //<
    editFailed : "rowNum,colNum,newValues,oldValues,editCompletionEvent,dsResponse,dsRequest",

	//> @method listGrid.editorEnter   (A)
	// Callback fired when the user starts editing a new cell.
    // <P>
    // This callback is typically used to establish dynamic default values via
    // +link{setEditValue()} or +link{setEditValues()}.
    // <P>
	// Can also be overriden on a per-field basis via
    // +link{listGridField.editorEnter,field.editorEnter}.
	//
	// @param record (ListGridRecord) record for the cell being edited.  <b>Will be null</b>
    //                                for a new, unsaved record.
	// @param value (any) value for the cell being edited
	// @param rowNum (integer)	row number for the cell
	// @param colNum (integer)	column number of the cell
	// @group editing
	// @see listGridField.editorEnter()
	// @visibility external
	//<
    editorEnter : "record,value,rowNum,colNum",
    
	//> @method listGrid.rowEditorEnter   (A)
	// Callback fired when the user starts editing a new row.
	//
	// @param	record     (ListGridField)	record for the cell being edited
	// @param	editValues  (object)    edit values for the current row
	// @param	rowNum	   (number)	row number for the cell
	//  @group  editing
	//  @see listGrid.editorEnter()
	// @visibility external
	//<
    rowEditorEnter : "record,editValues,rowNum",

	//> @method listGrid.editorExit   (A)
	// Callback fired when the user attempts to navigate away from the current edit cell, 
	// or complete the current edit.
    // <P>
	// Return false from this method to cancel the default behavior (Saving / cancelling the
	// current edit / moving to the next edit cell).
    // <P>
    // This callback is typically used to dynamically update values or value maps for related
    // fields (via +link{setEditValue()} and +link{setEditorValueMap()} respectively, or to
    // implement custom navigation (via +link{startEditing(), startEditing(rowNum,colNum)}.
    // <P>
	// Can be overriden at the field level as field.editorExit.
	//
	// @param editCompletionEvent   (EditCompletionEvent) How was the edit completion fired?
	// @param	record     (ListGridRecord)	record for the cell being edited
	// @param	newValue   (any)    new value for the cell being edited
	// @param	rowNum	   (number)	row number for the cell
	// @param	colNum	   (number)	column number of the cell
	//  @group  editing
    // @return  (boolean)   Returning false from this method will cancel the default behavior
    //                      (for example saving the row) and leave the editor visible and focus
    //                      in this edit cell.
	//  @see listGridField.editorExit()
	// @visibility external
	//<
    
    editorExit : "editCompletionEvent,record,newValue,rowNum,colNum",

	//> @method listGrid.rowEditorExit   (A)
	// Callback fired when the user attempts to navigate away from the current edit row, 
	// or complete the current edit.
    // <P>
	// Return false from this method to cancel the default behavior (Saving / cancelling the
	// current edit / moving to the next edit cell).
	//
	// @param editCompletionEvent   (EditCompletionEvent) How was the edit completion fired?
	// @param	record     (ListGridRecord)	record for the cell being edited
	// @param	newValues  (object)    new values for the record [Note that fields that have
    //                                 not been edited will not be included in this object]
	// @param	rowNum	   (number)	row number for the row being left
	//  @group  editing
    // @return  (boolean)   Returning false from this method will cancel the default behavior
    //                      (for example saving the row) and leave the editor visible and focus
    //                      in this edit cell.
	//  @see listGridField.editorExit()
	// @visibility external
	//<    
    rowEditorExit : "editCompletionEvent,record,newValues,rowNum",
    
	// JS doc comments by default implementation of validateCellValue and validateFieldValue
    validateCellValue : "rowNum,colNum,newValue,oldValue",
    validateFieldValue : "newValue,oldValue,record,field,rowNum,colNum",
    
	//> @method listGrid.formatCellValue
	// Formatter to apply to values displayed within cells.
    // <P>
	// The value passed to this method is either the field value found in the cell record 
    // or, if there are unsaved edits, the current user-entered value for the cell.
    // <b>NOTE:</b> unsaved user edits may contain nulls, bad values or values of the wrong
    // type, so formatters used for editable data should be bulletproof.  For example, if you
    // have a function "myNumberFormatter" that should only be passed actual Numbers, you might
    // define formatCellValue like so:
    // <pre>
    //     isc.isA.Number(parseInt(value)) ? 
    //            myNumberFormatter(parseInt(value)) : value
    // </pre>
	// Note that this formatter will not be applied to the value displayed within editors for
	// cells - use <code>formatEditorValue</code> to achieve this.
    // <P>
	// If <code>formatCellValue</code> is defined at the field level for some cell being edited,
	// the field level method will be used to format the edit value and this method will not
	// be called for that cell.<br>
	//
	// @group display_values
	//
	// @param   value    (any)   raw value for the cell being
	// @param   record   (ListGridRecord) 
    //   Record object for the cell. Note: If this is a new row that has not been saved, in an 
    //   editable grid, it has no associated record object. In this case the edit values will
    //   be passed in as this parameter.
	// @param   rowNum   (number)    row number for the cell
	// @param   colNum   (number)    column number for the cell.
	// @return  (string) formatted value to display in the cell.
	// @see listGridField.formatCellValue()
	// @see listGrid.formatEditorValue()
	// @visibility external
	//<
    formatCellValue : "value,record,rowNum,colNum",
    
	//> @method listGrid.formatEditorValue
	// Formatter to apply to values displayed within editors while a cell is being edited.
	// The value passed to this method is the raw value for the cell.<br>
	// If <code>formatEditorValue</code> is defined at the field level for some cell being edited,
	// the field level method will be used to format the edit value and this method will not
	// be called for that cell.<br>
	// To convert the formatted value displayed within an editor back to a raw value, the
	// <code>parseEditorValue</code> method is used.
	//
	// @group editing
	//
	// @param   value (any)   raw value for the cell being edited
	// @param   record   (ListGridRecord) 
    //   Record object for the cell. Note: If this is a new row that has not been saved, 
    //   it has no associated record object. In this case the edit values will
    //   be passed in as this parameter.
	// @param   rowNum  (number)    row number for the cell
	// @param   colNum  (number)    column number for the cell.
	// @return  (any)   formatted value to display in the editor
	// @see listGridField.formatEditorValue()
	// @see listGrid.parseEditorValue()
	// @visibility external
	//<
	
    formatEditorValue : "value,record,rowNum,colNum",
    
	//> @method listGrid.parseEditorValue
	// Method used to convert the value displayed in an editor for some cell being edited into
	// a raw value for saving.<br>
	// If <code>parseEditorValue</code> is defined at the field level for some cell being edited,
	// the field level method will be used to parse the edit value and this method will not
	// be called for that cell.<br>
	//
	// @group editing
	//
	// @param   value (any)   value displayed in the editor for the cell
	// @param   record (ListGridRecord) record object for the row being edited. May be null if this
	//                          is a new row being added to the end of the list.
	// @param   rowNum  (number)    row number for the cell
	// @param   colNum  (number)    column number for the cell.
	// @return  (any)   value in raw format
	// @see listGridField.parseEditorValue()
	// @see listGrid.formatEditorValue()
	// @visibility external
	//<
    parseEditorValue : "value,record,rowNum,colNum",
    
	//> @method listGrid.fieldStateChanged    
	// Notification method executed when columns are resized or reordered, or fields are 
    // shown or hidden. Has no default implementation.
	//
	// @visibility external
    // @group fieldState
	//<
    fieldStateChanged : ""

});


isc.ListGrid._unskinnedHeaderDefaults = 
    isc.addProperties({}, isc.ListGrid.getInstanceProperty("headerDefaults"));
isc.ListGrid._unskinnedHeaderButtonDefaults = 
    isc.addProperties({}, isc.ListGrid.getInstanceProperty("headerButtonDefaults"));

isc.ListGrid.classInit();

// Hilite Editor
// ---------------------------------------------------------------------------------------
// Interface for defining and editing grid hilites

isc.defineClass("HiliteEditor", "SectionStack").addProperties({

    // DataSource for storing highlights
    // ---------------------------------------------------------------------------------------
    hilitesDSDefaults : {
        _constructor:"DataSource",
        clientOnly:true,
        fields : [
            { name:"id", primaryKey:true, type:"sequence" }
        ]
    },

    // list of current highlights
    // ---------------------------------------------------------------------------------------
    hiliteListDefaults : {
        _constructor:isc.ListGrid,
        selectionType:"single",
        leaveScrollbarGap:false,
        // prevents hilite.cssText from triggering record.cssText behavior
        recordCSSTextProperty:"_none",
        fields : [
            // exists only so that hilite.cssText will apply to it
            {name:"fieldName", title:"Target Field", 
             recordClick:function (grid) { grid.creator.hiliteClicked() }
            },
            // exists only so that hilite.cssText will apply to it
            {name:"sample", title:"Sample", 
             formatCellValue:function (value, record) {
                 return "<span style='" + record.cssText + "'>Sample Text</span>";
             },
             recordClick:function (grid) { grid.creator.hiliteClicked() }
            },
            {name:"Delete", type:"icon", iconSize:16, icon:"[SKINIMG]/actions/remove.png",
             recordClick:function (grid) { grid.removeSelectedData() }
            }
        ]
    },

    // editor for new highlights
    // ---------------------------------------------------------------------------------------
    hiliteEditorDefaults : {
        _constructor:isc.VStack
    },

    filterBuilderDefaults : {
        _constructor:"FilterBuilder",
        autoParent:"hiliteEditor",
        isGroup:true,
        groupTitle:"Filter",
        padding:8
    },
    
    hiliteFormDefaults : {
        _constructor:"DynamicForm",
        autoParent:"hiliteEditor",
        isGroup:true,
        groupTitle:"Appearance",
        extraSpace:4,
        padding:8,
        numCols:4,
        items:[
            {title:"Target Field(s)", name:"fieldName", multiple:true, type:"select", rowSpan:2,
             defaultDynamicValue:"isc.firstKey(item.valueMap)"},
            {title:"Text", name:"textColor", type:"color" },
            {title:"Background", name:"backgroundColor", type:"color" }
        ]
    },

    hiliteButtonsDefaults : {
        _constructor:isc.HLayout, 
        membersMargin:8, height:1,
        autoParent:"hiliteEditor"
    },

    addButtonDefaults : {
        _constructor:"IButton", 
        autoParent:"hiliteButtons",
        title:"Save",
        click : function () {
            this.creator.saveHilite();
        }
    },
    newButtonDefaults : {
        _constructor:"IButton", 
        autoParent:"hiliteButtons",
        title:"New",
        click : function () {
            this.creator.newHilite();
        },
        extraSpace:50
    },
    doneButtonDefaults : {
        _constructor:"IButton", 
        autoParent:"hiliteButtons",
        title:"Done",
        click : function () {
            this.creator.doneEditing();
        }
    },

    // overall layout
    // ---------------------------------------------------------------------------------------
    defaultWidth:800, defaultHeight:600,
    visibilityMode:"multiple",

    initWidget : function () {
        this.Super("initWidget", arguments);

        this.hilitesDS = this.createAutoChild("hilitesDS");
        this.setHilites();

        this.hiliteList = this.createAutoChild("hiliteList", {dataSource:this.hilitesDS});
        this.hiliteList.fetchData();

        this.addSection({ 
            title: "Current Highlights", expanded:true, 
            items : ["autoChild:hiliteList" ]
        });
        this.addSection({
            title: "Define New Highlight", expanded:true, 
            items : ["autoChild:hiliteEditor"]
        });

        var ds = this.getDataSource();

        this.addAutoChild("filterBuilder", {dataSource:ds});
        this.addAutoChild("hiliteForm", {dataSource:this.hilitesDS});
	
        var fieldNames = this.fieldNames || ds.getFieldNames(),
            fieldMap = this.fieldMap = {};
        for (var i = 0; i < fieldNames.length; i++) {
            var fieldName = fieldNames[i],
                field = ds.getField(fieldName),
                fieldTitle = field.title;
            if (field.hidden) continue;
            fieldTitle = fieldTitle ? fieldTitle : fieldName;
            fieldMap[fieldName] = fieldTitle;
        }
        this.hiliteForm.setValueMap("fieldName", fieldMap);
        this.hiliteList.setValueMap("fieldName", fieldMap);

        this.addAutoChildren(["hiliteButtons", "addButton", "newButton", "doneButton"]);
    },

    setHilites : function (hilites) {
        hilites = hilites || this.hilites;
        this.hilitesDS.testData = hilites;
        if (this.hiliteList) this.hiliteList.data.invalidateCache();
        if (this.hiliteForm) this.hiliteForm.clearValues();
    },

    hiliteClicked : function () {
        var hilite = this.hiliteList.getSelectedRecord();
        this.filterBuilder.setCriteria(hilite.criteria);
        this.hiliteForm.setValues(hilite);
    },

    newHilite : function () {
        this.hiliteList.selection.deselectAll();
        this.filterBuilder.clearCriteria()
        this.hiliteForm.editNewRecord();
    },

    // save or add a hilite (depending on whether we edited an existing hilite or not)
    saveHilite : function (callback) {
        this.hiliteForm.setValue("criteria", this.filterBuilder.getCriteria());
        var hilite = this.hiliteForm.getValues();

        hilite.cssText = "" +
                (hilite.textColor ? "color:" + hilite.textColor + ";" : "") +
                (hilite.backgroundColor ? "background-color:" + hilite.backgroundColor + ";" : "");
        this.hiliteForm.setValue("cssText", hilite.cssText);

        var editor = this;
        this.hiliteForm.saveData(function (dsResponse, data) {
            var record = isc.isAn.Array(data) ? data[0] : data;
            editor.hiliteList.selectRecord(record);
            // for change detection
            editor.hiliteForm.setValues(record);
            if (callback) editor.fireCallback(callback);
        });
    },
    doneEditing : function () {
        if (!this.hiliteForm.valuesHaveChanged()) {
            this.completeEditing();
            return;
        }
        var editor = this;
        isc.confirm("Save changes to selected highlight?", function (shouldSave) {
            if (shouldSave) {
                editor.saveHilite(function () {
                    editor.completeEditing();
                });
            } else {
                editor.completeEditing();
            }
        });
        
    },
    completeEditing : function () {
        var hilites = this.hilitesDS.testData;
        //isc.logWarn("returning hilites: " + isc.echoAll(hilites));
        this.fireCallback(this.callback, "hilites", [hilites]);
    }    
});



