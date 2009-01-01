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

 





//>	@class	Selection
//
// Maintains a 'selected' subset of a List or Array of objects, such as records in a record
// set, or widgets in a selectable header.<br><br>
//
// Includes methods for selecting objects and checking which objects are selected, and also for
// selecting objects as a result of mouse events, including drag selection support.<br>
// The selection object is used automatically to handle selection APIs on +link{class:ListGrid}
// and +link{class:TreeGrid} instances.<br><br>
//
//
// @visibility external
// @treeLocation    Client Reference/System
//<


//
//	create the Selection class
//
isc.ClassFactory.defineClass("Selection");

// add default properties to the class
isc.Selection.addProperties({
    //> @attr selection.selectionProperty (String : null : [IRA])
    // Property to use to mark records as selected.
    // <P>
    // Defaults to an auto-generated property name that starts with an underscore.
    // @visibility serverSelection
    //<
    //selectionProperty:null,

    //>@attr selection.data (Array | List : null : [IRWA])
    //  The set of data for which selection is being managed.  If not specified at init time
    //  this can be set up via the <code>selection.setData()</code> method.
    // @visibility serverSelection
    //< 
    
    // _dirty - manages whether we need to update the cache of selected records.
	_dirty:true

    
});

isc.Selection.addClassProperties({
	//>	@type	SelectionStyle
	//	Different styles of selection that a list, etc. might support
	//		@visibility external
	//		@group	selection
	//
    //	@value	isc.Selection.NONE		don't select at all
	NONE : 		"none",			
    //	@value	isc.Selection.SINGLE	select only one item at a time
    SINGLE:		"single",		
	//	@value	isc.Selection.MULTIPLE	select one or more items
	MULTIPLE:	"multiple",	
    //	@value	isc.Selection.SIMPLE	select one or more items as a toggle
	// 								  so you don't need to hold down control keys to select 
    //                                  more than one object
	SIMPLE:		"simple",		
	//<

	// for generating unique IDs for each Selection 
	_selectionID : 0			
});


isc.Selection.addMethods({

//>	@method	selection.init()	(A)
//  Initialize this selection instance.<br>
//  Note: if the <code>data</code> property is not set at init time, it should be passed to
//  the selection using the <code>selection.setData</code> method
//		@group	selection
//		@param	[all arguments]	(object)	objects with properties to override from default
// @visibility serverSelection
//<
init : function () {

	// get unique ID and selection properties
	if (!this.selectionProperty) this.selectionProperty = "_selection_"+isc.Selection._selectionID++;

	// set the data object so we get notification for add and delete, etc.
	//	NOTE: if the data object wasn't set, use a new arrays
	this.setData((this.data ? this.data : []));
},

// override destroy to clean up pointers to this.data
destroy : function () {
    if (this.data) this.ignoreData(this.data);
    delete this.data;
    
    // selections aren't stored in global scope so no need to clear window[this.ID]
},

//>	@method	selection.setData()
//			Initialize selection data.<br><br>
//			Call this method to associate the selection with a different data object.<br>
//          <i>Note: No need to call this if the contents of the selection's data is modified</i>
//		@group	selection
//		@param		newData	(array)		new data to maintain selection in
// @visibility serverSelection
//<
setData : function (newData) {		

	// if we are currently pointing to data, stop observing it
	if (this.data != null) this.ignoreData(this.data);	

	// remember the new data
	this.data = newData;

	// observe the new data so we will update automatically when it changes
	if (this.data != null) this.observeData(this.data);
},

	
//>	@method	selection.observeData()	(A)
//			Observe methods on the data so we change our state.
//			Called automatically by selection.setData().
//			Observes the data.dataChanged() method to invalidate the selection cache
//		@group	selection
//
//
//	@param	data	(array)		new data to be observed
// @visibility internal
//<
observeData : function (data) {
	    
    this.observe(data, "dataChanged", "observer.dataChanged()");
    
    if (data.dataArrived) this.observe(data, "dataArrived", "observer.dataChanged()");
},

//>	@method	selection.ignoreData()	(A)
//			Stop observing methods on data when it goes out of scope.
//			Called automatically by setData
//		@group	selection
//
//		@param	data	(array)		old data to be ignored
// @visibility internal
//<
ignoreData : function (data) {
    if (!data) return;
    if (this.isObserving(data, "dataChanged")) this.ignore(data, "dataChanged");
    if (this.isObserving(data, "dataArrived")) this.ignore(data, "dataArrived");
},


dataChanged : function () {
    this.markForRedraw();
},


//>	@method	selection.markForRedraw()
//			Mark the selection as dirty, so it will be recalculated automatically			
//		@group	selection
// @visibility internal
//<
markForRedraw : function () {
	this._dirty = true;
},	

//>	@method	selection.isSelected()
//			Return true if a particular item is selected
//		@group	selection
//
//		@param	item	(object)	object to check	
//		@return		(boolean)	true == object is selected
//								false == object is not selected
// @visibility external
//<
isSelected : function (item){
	if (item == null) return false;
    if (isc.isAn.XMLNode(item)) return "true" == item.getAttribute(this.selectionProperty);
	return item[this.selectionProperty];
},


//>	@method	selection.anySelected()
// Whether at least one item is selected
//		@group	selection
//
//		@return		(boolean)	true == at least one item is selected
//								false == nothing at all is selected
// @visibility external
//<
anySelected : function () {
	// return if the selection is non-empty
	return this.getSelection().length > 0;
},


//>	@method	selection.multipleSelected()
//	Whether multiple items are selected
//		@group	selection
//
//		@return		(boolean)	true == more than one item is selected
//								false == no items are selected, or only one item is selected
// @visibility external
//<
multipleSelected : function () {
	return this.getSelection().length > 1;
},


//>	@method	selection.getSelection()
//			Return an ordered array of all of the selected items
//		@group	selection
//
//		@return		(array)		list of selected items
// @visibility external
//<
getSelection : function ()	{
	// if the selection is dirty, cache it again
	if (this._dirty)	this.cacheSelection();

	// return the cached selection list
	return this._cache;
},


//>	@method	selection.getSelectedRecord()
//			Return the first item in the list that is selected.<br><br>
//
//			Note that this should only be used if you know that one only one item
//			 may be selected, or you really don't care about items after the first one.<br><br>
//
//			To get all selected objects, use <code>+link{method:selection.getSelection()}</code>
//		@group	selection
//
//		@return		(object)	first selected record, or null if nothing selected
// @visibility external
//<
getSelectedRecord : function () {
    var selection = this.getSelection();
    if (selection && selection.length > 0) return selection[0];
},


//>	@method	selection.cacheSelection()	(A)
//			Cache the selected records since we operate on it so often.
// 			Sets an internal variable _cache to hold the selection.
//		@group	selection
// @visibility internal
//<
cacheSelection : function () {
	// create a new array to hold the cached selection
	this._cache = [];
    
    var data = this.data,
        isRS = isc.isA.ResultSet != null && isc.isA.ResultSet(data),
        length = data.getLength();
 
    
    if (isRS && !data.lengthIsKnown()) {
        this._dirty = false;
        return;
    }

	// iterate over the records of the list, selecting those that have the selection property set
    for (var i = 0; i < length; i++) {

        // don't trigger fetches if working with a remote dataset
        if (isRS && !data.rowIsLoaded(i)) continue;

        var item = data.get(i);
		if (item != null && this.isSelected(item)) {
			this._cache[this._cache.length] = item
        }
    }               

	// note that the selection is no longer dirty
	this._dirty = false;
},

//>	@method	selection.setSelected()	(A)
// Select or deselect a particular item.<br><br>
// All other selection routines go through this one, so by observing this routine you can
// monitor all selection changes.
//		@group	selection
//
//		@param	item		(object)	object to select
//		@param	newState	(boolean)	turn selection on or off	
// 	
//		@return				(boolean)	true == selection actually changed, false == no change
// @visibility external
//<
setSelected : function (item, newState) {
	// if the item is null, just return
	if (item == null) return false;
	
	// if the item is not enabled, just return
	if (item.enabled == false) return false;
	
    var property = this.selectionProperty,
        isNode = isc.isAn.XMLNode(item);

	// default to selecting the item
	if (newState == null) newState = true;
	
    // get the oldState of the item, for detecting changes
    var oldState = isNode ? item.getAttribute(property) : item[property];
    if (oldState == null) oldState = false;

	// set the state of the item
    if (isNode) {
        
    	item.setAttribute(property, (newState == true) + "");
        //this.logWarn("set attribute on: " + this.echoLeaf(item) + " to: " + newState + 
        //             ", now reads: " + item.getAttribute(property));
    } else {
    	item[property] = newState;
    }
	
	// remember that this was the last item to be selected
	this.lastSelectionItem = item;
	this.lastSelectionState = newState;

	// if no change to state of item, simply return false
	if (newState == oldState) return false;
	
    

	// note that the selection is dirty so it can be recalculated
	this.markForRedraw();
	
    
    if (this.target && this.target.selectionChange) this.target.selectionChange(item, newState);
	// return true to indicate that there was a change in the selection state
	return true;
},

//>	@method	selection.select()
//			Select a particular item
//		@group	selection
//
//		@param		item	(object)	object to select	
//		@return				(boolean)	true == selection actually changed, false == no change
// @visibility external
//<
select : function (item) {
    return this.setSelected(item, true);
},

//>	@method	selection.deselect()
//			Deselect a particular item
//		@group	selection
//
//		@param		item	(object)	object to select	
//		@return				(boolean)	true == selection actually changed, false == no change
// @visibility external
//<
deselect : function (item) {
    return this.setSelected(item, false);
},


//>	@method	selection.selectSingle()
// Select a single item and deselect everything else
//		@group	selection
//
//		@param		item	(object)	object to select	
//		@return				(boolean)	true == selection actually changed, false == no change
// @visibility external
//<
selectSingle : function (item) {
    

	this.deselectAll();
	return this.select(item);
},

//>	@method	selection.selectList()
// Select an array of items (subset of the entire list)
//		@group	selection
//
//		@param		list	(object[])	array of objects to select	
//		@return				(boolean)	true == selection actually changed, false == no change
// @visibility external
//<
selectList : function (list, newState) {
    if (newState == null) newState = true;
	if (!list) return false;
	var anyChanged = false, length = list.getLength();
	for (var i = 0; i < length; i++) {
        var item = list.get(i);
        if (this.isSelected(item) == newState) continue;
		anyChanged = this.setSelected(item, newState) || anyChanged;
	}
    
	return anyChanged;
},

//>	@method	selection.deselectList()
//			Deselect an array of items (subset of the entire list)
//		@group	selection
//
//		@param		list	(object[])	array of objects to select	
//		@return				(boolean)	true == selection actually changed, false == no change
// @visibility external
//<
deselectList : function (list) {
    this.selectList(list, false);
},


//>	@method	selection.selectAll()
//			Select ALL records of the list
//		@group	selection
//
//		@return				(boolean)	true == selection actually changed, false == no change
// @visibility external
//<
selectAll : function () {
	return this.selectRange(0, this.data.getLength());
},

//>	@method	selection.deselectAll()
//			Deselect ALL records of the list
//		@group	selection
//
//		@return				(boolean)	true == selection actually changed, false == no change
// @visibility external
//<
deselectAll : function () {
    
    

    return this.deselectList(this.getSelection());
},


//>	@method	selection.selectItem()
// Select a particular item by its position in the list
//
//		@param	position	(number)	index of the item to be selected
//		@return				(boolean)	true == selection actually changed, false == no change
// @group selection
// @visibility external
//<
selectItem : function (position) {
	return this.selectRange(position, position+1);
},


//>	@method	selection.deselectItem()
// Deselect a particular item by its position in the list
//
//		@param	position	(number)	index of the item to be selected
//		@return				(boolean)	true == selection actually changed, false == no change
// @group selection
// @visibility external
//<
deselectItem : function (position) {
	return this.deselectRange(position, position+1);
},





//>	@method	selection.selectRange()
//			Select range of records from <code>start</code> to <code>end</code>, non-inclusive.
//		@group	selection
//
//		@param	start	    (number)	start index to select
//		@param	end		    (number)	end index (non-inclusive)
//      @param  [newState]  (boolean)   optional new selection state to set.  True means
//                                      selected, false means unselected.  Defaults to true.
//
//		@return				(boolean)	true == selection actually changed, false == no change
// @visibility external
//<
selectRange : function (start, end, newState) {
    if (newState == null) newState = true;

    

    if (isc.isA.ResultSet != null && isc.isA.ResultSet(this.data) && 
        !this.data.rangeIsLoaded(start, end)) 
    {
        isc.warn("Can't select that many records at once.<br><br>" +
                 "Please try working in smaller batches.");
        return false; // no change
    }

	return this.selectList(this.data.getRange(start, end), newState);
},

//>	@method	selection.deselectRange()
//			Deselect range of records from <code>start</code> to <code>end</code>, non-inclusive
//
//		@group	selection
//
//		@param	start	(number)	start index to select
//		@param	end		(number)	end index (non-inclusive)
//
//		@return				(boolean)	true == selection actually changed, false == no change
// @visibility external
//<
deselectRange : function (start, end) {
    return this.selectRange(start, end, false);
},

// DOCFIX: this methods shouldn't require the "target", a Canvas.  Need to fix that before we make
// them public.

//>	@method	selection.selectOnMouseDown()	(A)
//			Update the selection as the result of a mouseDown event.
//			Handles shift, control, etc. key selection as well.
//			Call this from a mouseDown handler.
//
//		@group	selection, mouseEvents
//
//		@param	target	(Canvas)	target object
//		@param	position (number)	position where mouse went down on
//
//		@return			(boolean)	true == selection was changed, false == no change
//<
selectOnMouseDown : function (target, recordNum) {
    
    // modify selection according to the specified style (defaulting to multiple selection)
    var selectionType = target.selectionType || isc.Selection.MULTIPLE;

	// if the target's selectionType is NONE, just bail
	if (selectionType == isc.Selection.NONE)	return false;
	
    // remember mouseDown location in case we start drag selecting
    this.startRow = this.lastRow = recordNum;

	//>DEBUG
	this.logDebug("selectOnMouseDown: recordNum: " + recordNum);
	//<DEBUG
	
	var record = this.data.get(recordNum),
		recordSelected = this.isSelected(record),
		selection = this.getSelection();

    // prevent mouse-based selection of the LOADING record.  This doesn't make sense and create
    // client-side JS errors very easily.
    if (Array.isLoading(record)) return false;

	// clear flags for deselecting records on mouseUp
	// these are set in the simple and normal cases below (3 and 5)
	// see selectOnMouseUp() for details
	this.deselectRecordOnMouseUp = false;
	this.deselectOthersOnMouseUp = false;
    
    
    // In Windows ctrl-click works allows multiple independent row selection/deselection
    // In Mac the equivalent functionality occurs with the Apple key (meta key), since
    //  on that platform ctrl+click == right click
    
    var metaKeyDown = (isc.Browser.isMac ? isc.EventHandler.metaKeyDown() 
                                         : isc.EventHandler.ctrlKeyDown()),
        shiftKeyDown = isc.EH.shiftKeyDown();

	// Case 1: SINGLE selection
	if (selectionType == isc.Selection.SINGLE) {
        // On ctrl+click allow deselection
        
        if (metaKeyDown && recordSelected) this.deselect(record);
        else if (!recordSelected) this.selectSingle(record);

		return true;

    // Case 2: Shift-selection (select contiguous range of records)
    
	} else if (shiftKeyDown) {

		// if nothing was selected,
		if (selection.length == 0) {
			// simply select that record
			this.select(record);
			return true;				

		// otherwise since something was selected
		} else {
			// select a range of records
			var firstRecord = this.data.indexOf(selection[0]),
				lastRecord   = this.data.indexOf(selection.last())
			;
			// if the clicked record is the last record or beyond
			if (recordNum >= lastRecord) {
				// select from the firstRecord to the clicked record
				this.selectRange(firstRecord, recordNum + 1);

			// else if the clicked record is the first record or before
			} else if (recordNum <= firstRecord) {
				// select from the clicked record to the lastRecord
				this.selectRange(recordNum, lastRecord + 1);

			// otherwise it's in between the start and end record
			} else {
				// select from the firstRecord to the clicked record
				this.selectRange(firstRecord, recordNum + 1);
				// and deselect form the clickedRecord + 1 to the lastRecord
				this.deselectRange(recordNum + 1, lastRecord +1);
			}
			return true;
		}


	// Case 3: SIMPLE selection (toggle selection of this record, but defer deselection until
    // mouseUp)
	} else if (selectionType == isc.Selection.SIMPLE) {

		if (!recordSelected) {
			this.select(record);
			return true;
		} else {
			this.deselectRecordOnMouseUp = true;
			return false;
		}


	// Case 4: meta-key selection in a multiple selection range 
    // (simply toggle selection of this record) 
	} else if (metaKeyDown) {

		this.setSelected(record, !recordSelected);
		return true;

	// Case 5: normal selection (no modifier keys) in a multiple selection range
	} else {

        if (!recordSelected) {
            // if you click outside of the selection, select the new record and deselect
            // everything else
			this.selectSingle(record);
			return true;
        } else if (isc.EventHandler.rightButtonDown()) {
            // never deselect if you right click on the selection, unless you start drag
            // selecting
            this.deselectOnDragMove = true;
            return false;
        } else {
            // simpleDeselect mode: this mode is designed to make it easy to entirely get rid
            // of your selection, so you don't have to know about ctrl-clicking.  In a
            // nutshell, if you click on the existing selection, it will be entirely
            // deselected. 

            if (this.dragSelection) {
                if (this.simpleDeselect) {
                    // if you click on the selection, deselect the entire selection including
                    // the clicked-on cell.  Later, if a drag begins, select the clicked-on
                    // cell.
                    this.deselectAll();
                    this.selectOriginOnDragMove = true;
                    return true;
                }
                // for a drag selection, deselect others immediately; otherwise we'll be
                // dragging out a new selection within/overlapping with an existing selection,
                // which we only want to do on a ctrl-click.  This matches Excel.
                this.selectSingle(record);
                return true;
            } else {
                if (this.simpleDeselect) {
                    // deselect everything on mouseUp, including the cell clicked on
                    this.deselectAllOnMouseUp = true;
                } else {
                    // if we click in a multiple selection, deselect everything but the
                    // clicked-on item, but don't do it until mouseUp in order to allow
                    // dragging the current selection.  This matches Windows Explorer.
                    this.deselectOthersOnMouseUp = (selection.length > 1);
                }
                return false;
            }
        }
	}

},

//>	@method	selection.selectOnDragMove()	(A)
//			During drag selection, update the selection as a result of a dragMove event
//
//		@group	selection, mouseEvents
//
//		@param	target	(Canvas)	target object
//		@param	position (number)	position where mouse went down on
//
//		@return			(boolean)	true == selection was changed, false == no change
//
//<
selectOnDragMove : function (target, currRow) {
    var startRow = this.startRow,
        lastRow = this.lastRow;

    // If the mouse has moved further away from the start position since the last dragMove, select
    // more cells.  If it's moved closer to the start position, deselect cells.
    if (currRow < 0) {
        //>DEBUG
        this.logWarn("selectOnDragMove: got negative coordinate: " + currRow);
        //<DEBUG
        return;
    }

    if (currRow == lastRow) return; // no change

    

    if (this.selectOriginOnDragMove) {
        this.select(this.data.getItem(startRow));
        this.selectOriginOnDragMove = false;
    } else if (this.deselectOnDragMove || this.deselectAllOnMouseUp || this.deselectOthersOnMouseUp) {
        // deselect on dragMove is for right-dragging.  The others flags are failsafes in case you
        // use drag selection without setting the flag.
        this.selectSingle(this.data.getItem(startRow));
        this.deselectAllOnMouseUp = this.deselectOthersOnMouseUp = this.deselectOnDragMove = false;
    }

    if ((currRow > startRow && startRow > lastRow) || 
        (lastRow > startRow && startRow > currRow)) 
    {
        //this.logWarn("dragged from one side of start to the other");
        // dragged from one side of start to the other
        this.deselectAll();
        // select from start to current inclusive
        if (startRow > currRow) {
            this.selectRange(currRow, startRow+1);
        } else {
            this.selectRange(startRow, currRow+1);
        }
    } else if (startRow >= lastRow && lastRow > currRow) {
        //this.logWarn("increasing selection on the left of start");
        // increasing selection on the left of start
        this.selectRange(currRow, lastRow);
    } else if (startRow >= currRow && currRow > lastRow) {
        //this.logWarn("decreasing selection on the left of start");
        // decreasing selection on the left of start
        this.deselectRange(lastRow, currRow);
    } else if (startRow <= currRow && currRow < lastRow) {
        //this.logWarn("decreasing selection on the right of start");
        // decreasing selection on the right of start
        this.deselectRange(currRow+1, lastRow+1);
    } else if (startRow <= lastRow && lastRow < currRow) {
        //this.logWarn("increasing selection on the right of start");
        // increasing selection on the right of start
        this.selectRange(lastRow, currRow+1);
    //>DEBUG
    } else {
        this.logWarn("dragMove case not handled: lastRow: " + lastRow + 
                     ", currRow: " + currRow + ", startRow " + startRow);
    //<DEBUG
    }
    
    this.lastRow = currRow;
},

//>	@method	selection.selectOnMouseUp()	(A)s
//		@group	selection, mouseEvents
//			Update the selection as the result of a mouseUp event.
//			We currently use this to defer deselection for drag-and-drop of multiple records.
//			Call this from a mouseUp handler.
//		@see	ListGrid.mouseUp()
//
//		@param	target	(Canvas)	target object
//		@param	recordNum	(number)	record number mouse went down on
//
//		@return			(boolean)	true == selection was changed, false == no change
//<
selectOnMouseUp : function (target, recordNum) {
	// if the target's selectionType is NONE, just bail
	if (target.selectionType == isc.Selection.NONE)	return false;

	//>DEBUG
	this.logDebug("selectOnMouseUp: recordNum: " + recordNum);
	//<DEBUG

	// JMD 020828:
	//		If multiselection is on and no modifier keys are down, we need to
	// deselect any rows other than the one that is clicked. BUT, we can't do this in
	// selectOnMouseDown() because the user might be clicking on a row in a multiple selection
	// to initiate a drag operation with all of the selected rows. So in selectOnMouseDown()
	// we set a deselectOthersOnMouseUp flag that we can check here and do the deselection
	// if necessary.
	//		Similarly, if SIMPLE selection is enabled we don't want to deselect the current
	// record if the user is initiating a drag. We set a deselectRecordOnMouseUp flag for in this case.
	//
    // We never deselect anything on rightMouseUp since you would right click to show a context menu
    // to operate on the current selection.
	if (this.deselectOthersOnMouseUp) {
		this.selectSingle(this.data.getItem(recordNum));
        this.deselectOthersOnMouseUp = false;
		return true;
	} else if (this.deselectRecordOnMouseUp) {
		this.deselect(this.data.getItem(recordNum));
        this.deselectRecordOnMouseUp = false;
		return true;
    } else if (this.deselectAllOnMouseUp) {
        this.deselectAll();
        this.deselectAllOnMouseUp = false;
        return true;
	} else
		return false;
}

});	// END isc.Selection.addMethods()


