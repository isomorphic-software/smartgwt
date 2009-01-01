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




//>	@class	TreeGrid
//
// The SmartClient system supports hierarchical data (also referred to as tree data
// due to its "branching" organization) with:
// <ul>
//   <li> the +link{class:Tree} class, which manipulates hierarchical data sets
//   <li> the TreeGrid widget class, which extends the ListGrid class to visually
//        present tree data in an expandable/collapsible format.
// </ul>
// For information on DataBinding Trees, see +link{group:treeDataBinding}.
// <p>
// A TreeGrid works just like a +link{ListGrid}, except one column (specified by
// +link{TreeGridField.treeField} shows a heirarchical +link{Tree}.  A TreeGrid is not limited
// to displaying just the +link{Tree} column - you can define additional columns (via
// +link{TreeGrid.fields}) which will render just like the columns of a +link{ListGrid}, and
// support all of the functionality of ListGrid columns, such as
// +link{listGridField.formatCellValue,formatters}.
// <p>
// Except where explicitly overridden, +link{ListGrid} methods, callbacks, and properties
// apply to TreeGrids as well.  The +link{ListGrid} defines some methods as taking/returning
// +link{ListGridField} and +link{ListGridRecord}.  When using those methods in a TreeGrid,
// those types will be +link{TreeGridField} and +link{TreeNode}, respectively.
// 
// @implements DataBoundComponent    
// @treeLocation Client Reference/Grids
// @visibility external
//<

// define us as a subclass of the ListGrid
isc.ClassFactory.defineClass("TreeGrid", "ListGrid");

// Synonym for backCompat.  NOTE: define an alias rather than make a subclass, otherwise,
// attempts to skin the class using the old name would only affect the subclass!
isc.addGlobal("TreeViewer", isc.TreeGrid);

//>	@class	TreeGridBody
//
//  GridRenderer displayed as the body of a TreeGrid. Includes various overrides for
//  specialized event handling and display.
//
//  @treeLocation Client Reference/Grids/TreeGrid/
//  @visibility internal
//<
isc.defineClass("TreeGridBody", isc.GridBody).addProperties({
    // Override the internal _updateCellStyle() method to style the tree-field's internal
    // table (without regening the HTML)
    _$TABLE:"TABLE",
    _$zeroBorderPadding:"padding:0px;border:0px;",
    _updateCellStyle : function (record, rowNum, colNum, cell, className) {
        if (cell == null) cell = this.getTableElement(rowNum, colNum);
        if (cell == null) return; // cell not currently drawn

        if (!this.showHiliteInCells && 
            colNum == this.grid.getLocalFieldNum(this.grid.getTreeFieldNum())) 
        {
            if (record == null) record = this.getCellRecord(rowNum, colNum);
            // determine the CSS style className if not provided
            if (className == null) className = this.getCellStyle(record, rowNum, colNum);
            // There will be a clip-div around the table.
            // In IE the NOBR also counts as a node.
            var table = cell.childNodes[0];
            while (table && table.tagName != this._$TABLE) table = table.childNodes[0];
            if (table) {
                table.className = className;
                if (this.getCellCSSText) {                    
                    // Use this._getCompleteCellCSSText
                    // This handles the overflow settings for Moz, converting the 
                    // getCellCSSText stringMethod to a method, etc.
                    cell.style.cssText = isc.StringBuffer.concat(
                                            this._getCompleteCellCSSText(record, rowNum, colNum, className),
                                            this._$zeroBorderPadding);
                }
            }
        }
        
        // Actually style the cell itself
        return isc.GridRenderer.getPrototype()._updateCellStyle.apply(
                                        this, [record, rowNum, colNum, cell, className]);
    },

    //>	@method	treeGridBody.click()	(A)
    // Handle a click in the "open" area of a record specially
    //		@group	event handling	
    //
    //		@return	(boolean)	false == cancel further event processing
    //<
    // Note: We override click rather than putting this logic into rowClick / cellClick, as
    // we don't want folder toggling to occur if the user's mouse is hovering over the open
    // area while the user triggers standard record click handling by hitting the Space-bar.
    
    click : function (event, eventInfo) {
        if (!this._suppressEventHandling()) {
                
            var tg = this.grid,
                recordNum = tg.getEventRecordNum(),
                node = tg.getRecord(recordNum);
            // if what they clicked on is a folder, toggle it's state.  The 'open' observation
            // will automaticaly redraw for us
            if (tg.data.isFolder(node) && tg.clickInOpenArea(node)) {
                tg.toggleFolder(node);
                
                // clear out the pointer to the last record clicked, and the last row selected
                // by keyboard navigation. (Prevents index-based keyboard navigation from
                // jumping around due to the number of rows changing as folders toggle)
                tg.clearLastHilite();
                tg._lastRecordClicked = null;
        
                // Note: if you click in the open area to toggle a folder, no nodeClick or
                // folderClick events will be fired, since we've already taken action in
                // response to your click by toggling a folder
                // Return EH.STOP_BUBBLING to stop propogation.
                return isc.EH.STOP_BUBBLING;
            }
        }
        return this.Super("click", arguments);
    },    

    // Override mouseDown and mouseUp in the body to avoid selecting when clicking in open
    // area by default.
    
    //>	@method	treeGridBody.mouseDown()	(A)
    // Handle a click in the open area on mouseDown specially
    //		@group	event handling	
    //
    //		@return	(boolean)	false == cancel further event processing
    //<
    mouseDown : function () {
    	// get the item that was clicked on -- bail if not found
        var rowNum = this.getEventRow(),
            node = this.grid.data.get(rowNum);
        if (node != null && this.grid.clickInOpenArea(node)) {
            // if they clicked in the open area of the record, 
            //	just bail because we're supposed to open the folder instead
            // TreeGrid.click() will actually open the folder
            
            return isc.EH.STOP_BUBBLING;
        } else {
            return this.Super("mouseDown", arguments);
        }
    },

    //>	@method	treeGridBody.mouseUp()	(A)
    // Handle a click in the open area on mouseUp specially
    //		@group	event handling	
    //
    //		@return	(boolean)	false == cancel further event processing
    //<
    mouseUp : function () {
    	// get the item that was clicked on -- bail if not found
    	var rowNum = this.getEventRow(),
    		node = this.grid.data.get(rowNum);
    	if (node != null && this.grid.clickInOpenArea(node)) {
            // don't select the row; on click() we'll open the folder
    		return isc.EH.STOP_BUBBLING;
    	} else {
            // proceed to super (select the row)
    		return this.Super("mouseUp", arguments);
    	}
    }
     
});

isc.TreeGrid.addClassProperties({

	//=	@const	TreeGrid.TREE_FIELD		default field to display a tree
	TREE_FIELD : {name:"nodeTitle", width:"*", treeField:true,

    			getCellValue : function (list,record,recordNum,coNum) {
                    return list.getNodeTitle(record,recordNum, this)
                },
                    
                // return the title for the Header Button over the tree column.
                
                getFieldTitle : function (viewer, fieldNum) {
                    var field = viewer.getField(fieldNum);              
                    if (field.name == "nodeTitle") return viewer.treeFieldTitle;
                    
                    // otherwise just return the title of the field, or failing that, the field's name
                    return field.title || field.name;
                }
    }

});


isc.TreeGrid.addProperties({

	//>	@attr	treeGrid.dataSource		(DataSource or ID : null : IRW)
    // @include dataBoundComponent.dataSource
	//<

	//>	@attr	treeGrid.data		(Tree : null : IRW)
	// A +link{class:Tree} object containing of nested +link{object:TreeNode}s to 
    // display as rows in this TreeGrid.  
    // The <code>data</code> property will typically not be explicitly specified for 
    // databound TreeGrids, where the data is returned from the server via databound component
    // methods such as <code>fetchData()</code>
	//      @visibility external
	//		@group	data
	//<

    //> @attr treeGrid.initialData (List of TreeNode : null : IRA)
    //
    // You can specify the initial set of data for a databound TreeGrid using this property.
    // The value of this attribute should be a list of <code>parentId</code> linked
    // +link{TreeNode}s in a format equivalent to that documented on +link{Tree.data}.
    //
    // @see TreeNode
    // @see Tree.data
    // @visibility external
    // @example initialData
    //<
    
    //> @attr   treeGrid.loadDataOnDemand   (boolean : null : IRW)
    // For databound treeGrid instances, should the entire tree of data be loaded on initial 
    // fetch, or should folders load their children as they are opened.
    // <P>
    // If unset the default +link{resultTree.loadDataOnDemand} setting will be used.
    // <P>
    // Note that when using <code>loadDataOnDemand</code>, every node returned by the server is
    // assumed be a folder which may load further children.  See
    // +link{resultTree.defaultIsFolder} for how to control this behavior.
    // 
    // @group databinding
    // @visibility external
    // @example initialData
    //<
    
    
    //> @attr   treeGrid.fields       (Array of TreeGridField: null : IRW)
    // An array of field objects, specifying the order, layout, dynamic calculation, and
    // sorting behavior of each field in the treeGrid object. In TreeGrids, the fields
    // array specifies columns. Each field in the fields array is TreeGridField object.
    // <p>
    // If +link{TreeGrid.dataSource} is also set, this value acts as a set of overrides as
    // explained in +link{attr:DataBoundComponent.fields}.
    //
    // @group databinding
    // @see TreeGridField
    // @visibility external
    //<

    //> @object TreeGridField
    //
    // An object literal with a particular set of properties used to configure the display of
    // and interaction with the columns of a +link{TreeGrid}.
    // +link{TreeGrid} is a subclass of +link{ListGrid} and as a result, for all fields except
    // the field containing the +link{Tree} itself (specified by
    // +link{treeGridField.treeField}, all properties settable on
    // +link{ListGridField} apply to TreeGridField as well.
    // <p>
    // This class documents just those properties that are specific to TreeGridFields - see
    // +link{ListGridField} for the set of inherited properties.
    // 
    // @see ListGridField
    // @see TreeGrid.fields
    // @see ListGrid.setFields
    //
    // @treeLocation Client Reference/Grids/TreeGrid
    // @visibility external
    //< 

    // Tree Field
    // ---------------------------------------------------------------------------------------

    //> @attr treeGridField.treeField (boolean : see below : IRW)
    //
    // The field containing <code>treeField: true</code> will display the +link{Tree}.  If no
    // field specifies this property, the first field in +link{TreeGrid.fields} is assigned to
    // display the +link{Tree}.
    // @group treeField
    // @visibility external
    //<

    //>	@attr	treeGrid.treeFieldTitle		(string : "Name" : IR)
	//	Visible title for the tree column (field).
    // @group treeField
    // @visibility external
	//<
	treeFieldTitle:"Name",		
    
    //> @attr treeGrid.autoAssignTreeField (boolean : true : IR)
    // If no field was specified as the "tree-field" (showing indentations for tree hierachy
    // and tree icons), should we assign one of the other fields to be the tree-field?
    // Useful when we want to display a tree or partial tree as a flattened list.
    // @group treeField
    //<
    autoAssignTreeField:true,

    //>	@attr	treeGrid.showRoot		(boolean : false : IR)
    // Specifies whether the root node should be displayed in the treeGrid.
    // <P>
    // This property is only available for "children" modelType trees, hence is not allowed for
    // trees that load data from the server dynamically via +link{fetchData()}.  
    // <P>
    // To get the equivalent of a visible "root" node in a tree that loads data dynamically,
    // add a singular, top-level parent to the data.  However, note that this top-level parent
    // will technically be the only child of root, and the implicit root object will be
    // returned by +link{tree.getRoot,this.data.getRoot()}.
    //
    // @group treeField
    // @visibility external
	//<
	showRoot:false,
    
    //>	@attr	treeGrid.separateFolders		(boolean : false : IR)
    //          Specifies whether folders and leaves should be segregated in the treeGrid display.
    //          With separateFolders:true and sortDirection:"descending", folders are displayed
    //          before their sibling leaves; with sortDirection:"ascending", leaves are displayed
    //          before their sibling folders.
    // @group treeField
    //      @visibility external
	//<
	separateFolders:false,

	//>	@attr	treeGrid.displayNodeType (DisplayNodeType : isc.Tree.FOLDERS_AND_LEAVES : [IRW])
    //          Specifies the type of nodes displayed in the treeGrid. 
    // @see type:DisplayNodeType for options
    // @group treeField
    // @visibility external
	//<
	displayNodeType:isc.Tree.FOLDERS_AND_LEAVES,
	
	// Drag and Drop
	// --------------------------------------------------------------------------------------------
    //>	@attr	treeGrid.canDragRecordsOut		(boolean : false : IRW)
	//	@include ListGrid.canDragRecordsOut
    //  @group	dragdrop
    // @see TreeNode.canDrag
    // @see TreeNode.canAcceptDrop
    // @visibility external
    // @example treeDropEvents
    //<
	canDragRecordsOut:false,			

    //>	@attr	treeGrid.canAcceptDroppedRecords		(boolean : false : IRW)
	//	@include ListGrid.canAcceptDroppedRecords
    // @see TreeNode.canDrag
    // @see TreeNode.canAcceptDrop
    //  @group	dragdrop
    // @visibility external
    // @example dragReparent
    //<
	//canAcceptDroppedRecords:false,		
	
    //>	@attr	treeGrid.canReorderRecords		(boolean : false : IRWA)
    // @include ListGrid.canReorderRecords
    // @see TreeNode.canDrag
    // @see TreeNode.canAcceptDrop
    // @group dragdrop
    // @visibility external
    // @example dragReparent
	//<
	//canReorderRecords:false,
 
    //> @attr treeGrid.canDropOnLeaves          (boolean : false : IRWA)   
    // Whether drops are allowed on leaf nodes.
    // <P>
    // Dropping is ordinarily not allowed on leaf nodes unless +link{canReorderRecords} is
    // set.  
    // <P>
    // The default action for a drop on a leaf node is to place the node in that leaf's parent
    // folder.  This can be customized by overriding +link{folderDrop()}.
    //
    // @visibility external
    //<
    
    //> @attr treeGrid.canReparentNodes     (boolean : null : IRW)
    // If set this property allows the user to reparent nodes by dragging them from their
    // current folder to a new folder.<br>
    // <b>Backcompat:</b> For backwards compatibility with versions prior to SmartClient 1.5,
    // if this property is unset, but <code>this.canAcceptDroppedRecords</code> is true, we
    // allow nodes to be dragged to different folders.
    // @see TreeNode.canDrag
    // @see TreeNode.canAcceptDrop
    // @group dragdrop
    // @visibility external
    //<
    //canReparentNodes:null,
	
	//>	@attr	treeGrid.dragDataAction		(DragDataAction : isc.ListGrid.MOVE : IRWA)
    //
    // Specifies what to do with data dragged from this TreeGrid (into another component, or
    // another node in this TreeGrid.  The default action is to move the data.  A setting of
    // "none" is not recommended for trees because Trees maintain the node open state on the nodes
    // themselves, and hence having multiple Tree objects share a reference to a node can have
    // unintended consequences (such as opening a folder in one tree also triggering an open in
    // another tree that shares the same node).
    // <br><br>
    // For DataBound trees (+link{class:ResultTree}), the expectation is that
    // +link{method:TreeGrid.folderDrop} will be overridden to perform whatever action took
    // place as the result of the drag and drop interaction.
	//
    // @see group:sharingNodes
    // @visibility external
	//<
	dragDataAction:isc.ListGrid.MOVE,
    
    
    // dragRecategorize:true,
    
    //> @attr treeGrid.openDropFolderDelay (integer : 600 : IRWA)
    // When dragging something over a closed folder, delay in milliseconds before the folder
    // automatically opens.
    //<
    openDropFolderDelay:600,

    // D&D Error Messages
    // error messages for invalid drag and drop situations.  Can be customized on a per
    // instance basis so something more application-specific can be said, eg "a manager cannot
    // become his own employee"

    //> @attr treeGrid.parentAlreadyContainsChildMessage (String : "This item already contains a child item with that name." : IR)
    // Message displayed when user attempts to drag a node into a parent that already contains
    // a child of the same name.
    // @see attr:treeGrid.canDragRecordsOut
    // @see attr:treeGrid.canAcceptDroppedRecords
    // @see attr:treeGrid.canReorderRecords
    // @group i18nMessages
    // @visibility external
    //<
    parentAlreadyContainsChildMessage:"This item already contains a child item with that name.",
    
	//>	@attr treeGrid.cantDragIntoSelfMessage (String : "You can't drag an item into itself." : IR)
    // Message displayed when user attempts to drop a dragged node onto itself.
    // @see attr:treeGrid.canDragRecordsOut
    // @see attr:treeGrid.canAcceptDroppedRecords
    // @see attr:treeGrid.canReorderRecords
    // @group i18nMessages
    // @visibility external    
    //<
	cantDragIntoSelfMessage:"You can't drag an item into itself.",

	//>	@attr treeGrid.cantDragIntoChildMessage (String : "You can't drag an item into one of it's children." : IR)
    // Message displayed when user attempts to drop a node into a child of itself.
    // @see attr:treeGrid.canDragRecordsOut
    // @see attr:treeGrid.canAcceptDroppedRecords
    // @see attr:treeGrid.canReorderRecords
    // @group i18nMessages
    // @visibility external
    //<
	cantDragIntoChildMessage:"You can't drag an item into one of it's children.",

    // Body Rendering
	// --------------------------------------------------------------------------------------------

    //>	@attr	treeGrid.fixedFieldWidths		(boolean : true : IRWA)
	//			make trees fixedFieldWidths by default
	//		@group	appearance
	//<
	fixedFieldWidths:true,

    //>	@attr	treeGrid.wrapCells		(boolean : false : IRWA)
	//			don't wrap, as that will mess up the look of the trees
	//		@group	appearance
	//<
	wrapCells:false,

	//>	@attr	treeGrid.showHiliteInCells		(boolean : false : IRWA)
	// Should the hilite show across the entire record or just in the text of the item itself	
	//<
	showHiliteInCells:false,
	
	// Images: locations, sizes, and names
	// --------------------------------------------------------------------------------------------
    //>	@attr	treeGrid.indentSize		(number : 20 : [IRW])
    //          The amount of indentation (in pixels) to add to a node's icon/title for each level
    //          down in this tree's hierarchy.
    //      @visibility external
    //      @group  appearance
    //<
	indentSize:20,
    
    //>	@attr	treeGrid.iconSize		(number : 16 : [IRW])
    //          The standard size (same height and width, in pixels) of node icons in this
    //          treeGrid.
    // @group treeIcons
    // @visibility external
    //<
	iconSize:16,

    //>	@attr	treeGrid.openerIconSize		(number : null : [IRW])
    // Width and height in pixels of the opener icons, that is, the icons which show the open
    // or closed state of the node, typically a [+] or [-] symbol.
    // <P>
    // If +link{showConnectors} is true, the opener icon includes the connector line, and
    // defaults to +link{listGrid.cellHeight,cellHeight}.
    // <P>
    // Otherwise, <code>openerIconSize</code> defaults to +link{iconSize}.
    //
    // @group treeIcons
    // @visibility external
    //<

    //>	@attr	treeGrid.skinImgDir		(URL : "images/TreeGrid/" : IRWA)
	//		Where do 'skin' images (those provided with the class) live?
	//		This is local to the Page.skinDir
	//		@group	appearance, images
	//<
	skinImgDir:"images/TreeGrid/",	

    //>	@attr	treeGrid.folderIcon        (SCImgURL : "[SKIN]folder.gif" : [IRW])
    // The URL of the base icon for all folder nodes in this treeGrid. Note that this URL will
    // have +link{treeGrid.openIconSuffix}, +link{treeGrid.closedIconSuffix} or 
    // +link{treeGrid.dropIconSuffix} appended to indicate state changes if appropriate - 
    // see documentation on  +link{treeGrid.showOpenIcons} and +link{treeGrid.showDropIcons}.
    // @group treeIcons
    //      @visibility external
    // @example nodeTitles
    //<
    folderIcon:"[SKIN]/folder.gif",

    //> @attr   treeGrid.dropIconSuffix   (String : "drop" : [IRW])
    // If +link{treeGrid.showDropIcons} is true, this suffix will be appended to the
    // +link{treeGrid.folderIcon} when the user drop-hovers over some folder.
    // @group treeIcons
    // @visibility external
    //<
    dropIconSuffix:"drop",
    
    //> @attr   treeGrid.openIconSuffix   (String : "open" : [IRW])
    // If +link{showOpenIcons} is true, this suffix will be appended to the
    // +link{folderIcon} for open folders in this grid.
    // @group treeIcons
    // @visibility external
    //<
    openIconSuffix:"open",

    //> @attr   treeGrid.closedIconSuffix   (String : "closed : [IRW])
    // This suffix will be appended to the +link{folderIcon} for closed folders.
    // If +link{showOpenIcons} is set to <code>false</code> this suffix will also be
    // appended to open folders' icons.
    // @group treeIcons
    // @visibility external
    //<
    closedIconSuffix:"closed",

    
    //> @attr   treeGrid.nodeIcon  (SCImgURL : "[SKIN]file.gif" : [IRW])
    // The filename of the default icon for all leaf nodes in this grid. To specify a 
    // custom image for an individual node, set the +link{customIconProperty} directly on
    // the node.
    // @group treeIcons
    //      @visibility external
    // @example nodeTitles
    //<
    nodeIcon:"[SKIN]/file.gif",    
    
    //>@attr treeGrid.showOpenIcons (boolean : true : IRW)
    // If true, show a different icon for <code>open</code> folders than closed folders.
    // This is achieved by appending the +link{openIconSuffix} onto the 
    // +link{folderIcon} URL [for example <code>"[SKIN]/folder.gif"</code> might be 
    // replaced by <code>"[SKIN]/folder_open.gif"</code>.<br>
    // <b>Note</b> If this property is set to <code>false</code> the same icon is shown for
    // open folders as for closed folders, unless a custom folder icon was specified. This will be
    // determined by +link{folderIcon} plus the +link{closedIconSuffix}.
    // @group treeIcons
    // @visibility external
    // @example nodeTitles
    //<
    showOpenIcons:true,
    
    //>@attr treeGrid.showDropIcons (boolean : true : IRW)
    // If true, when the user drags a droppable target over a folder in this TreeGrid, show 
    // a different icon folder icon.
    // This is achieved by appending the +link{treeGrid.dropIconSuffix} onto the
    // +link{TreeGrid.folderIcon} URL (for example <code>"[SKIN]/folder.gif"</code> may be
    // replaced by <code>"[SKIN]/folder_drop.gif"</code>).
    // @group treeIcons
    // @visibility external
    // @example nodeTitles
    //<
    showDropIcons:true,
    
    //> @attr   treeGrid.customIconProperty   (String : "icon" : [IRW])
    // This property allows the developer to customize the icon displayed next to a node.
    // Set <code>node[grid.customIconProperty]</code> to the URL of the desired icon to display and
    // it will be shown instead of the standard +link{nodeIcon} for this node.<br>
    // Note that if +link{TreeGrid.showCustomIconOpen} and/or +link{TreeGrid.showCustomIconDrop} 
    // is true for this grid, customized icons for folder nodes will be appended with the 
    // +link{treeGrid.dropIconSuffix} or +link{treeGrid.openIconSuffix} suffixes on state change 
    // as with the standard +link{TreeGrid.folderIcon} for this treeGrid.  Also note that for
    // custom folder icons, the +link{treeGrid.closedIconSuffix} will never be appened.
    // @group treeIcons
    // @visibility external
    //<
    customIconProperty:"icon",
    
    //> @attr   treeGrid.showCustomIconOpen   (boolean : false : [IRWA])
    // Should folder nodes showing custom icons (set via the +link{customIconProperty}),
    // show open state images when the folder is opened.
    // If true, the +link{openIconSuffix} will be appended to the image URL
    // (so <code>"customFolder.gif"</code> might be replaced with 
    // <code>"customFolder_open.gif"</code>).<br>
    // <b>Note</b> that the +link{closedIconSuffix} is never appended to custom folder icons.<br>
    // Can be overridden at the node level via the +link{customIconOpenProperty} property.
    // @group treeIcons
    // @visibility external
    //<
    showCustomIconOpen:false,
    
    //> @attr   treeGrid.showCustomIconDrop   (boolean : false : [IRWA])
    // Should folder nodes showing custom icons (set via the +link{treeGrid.customIconProperty}),
    // show drop state images when the user is drop-hovering over the folder.
    // If true, the +link{treeGrid.dropIconSuffix} will be appended to the image URL
    // (so <code>"customFolder.gif"</code> might be replaced with 
    // <code>"customFolder_drop.gif"</code>).<br>
    // Can be overridden at the node level via the +link{treeGrid.customIconDropProperty} property.
    // @group treeIcons
    // @visibility external
    //<
    showCustomIconDrop:false,

    //> @attr   treeGrid.customIconOpenProperty (string : "showOpenIcon" : [IRWA])
    // For folder nodes showing custom icons (set via the +link{customIconProperty}),
    // this property allows the developer to specify on a per-node basis whether a
    // open state icon should be displayed when the folder is open.
    // Set <code>node[treeGrid.customIconOpenProperty]</code> to true to show the open state
    // icons, or false to suppress this.<br>
    // If not specified, this behavior is determined by <code>grid.showCustomIconOpen</code>
    // for this node.
    // @see treeGrid.customIconProperty
    // @see treeGrid.showCustomIconOpen
    // @visibility external
    // @group treeIcons
    //<
    customIconOpenProperty:"showOpenIcon",
    
    //> @attr   treeGrid.customIconDropProperty (string : "showDropIcon" : [IRWA])
    // For folder nodes showing custom icons (set via the +link{treeGrid.customIconProperty}),
    // this property allows the developer to specify on a per-node basis whether a
    // drop state icon (with +link{treeGrid.dropIconSuffix}) should be displayed when the 
    // user drop-hovers over this folder.<br>
    // Set <code>node[treeGrid.customIconDropProperty]</code> to true to show the drop state
    // icons, or false to suppress this.<br>
    // If not specified this this behavior is determined by <code>treeGrid.showCustomIconDrop</code>
    // for this node.
    // @see treeGrid.customIconProperty
    // @see treeGrid.showCustomIconDrop
    // @visibility external
    // @group treeIcons
    //<
    customIconDropProperty:"showDropIcon",

    // ---------------------------------
    // DEPRECATED ICON PROPERTIES:
    // 
            
    //>	@attr	treeGrid.folderOpenImage        (String : null : [IRW])
    //          The filename of the default icon for all open folder nodes in this treeGrid.
    //      @visibility external
    //  @deprecated as part of SmartClient release 5.5 in favor of +link{TreeGrid.folderIcon}
    //<

    //>	@attr	treeGrid.folderClosedImage		(string : null : [IRW])
    // The filename of the default icon for all closed folder nodes in this treeGrid. Use
    // the node.icon property (null by default) to specify a custom image for an individual
    // folder node. The same custom image will be used for both the open and closed folder
    // images.
    //      @visibility external
    //  @deprecated as part of SmartClient release 5.5 in favor of +link{TreeGrid.folderIcon}
    //<

    //>	@attr	treeGrid.folderDropImage       (String : null : [IRW])
    // The filename of the icon displayed for a folder node that will accept drag-and-drop
    // data when the mouse is released.
    //      @visibility external
    //  @deprecated as part of SmartClient release 5.5 in favor of +link{TreeGrid.folderIcon}    
    //<

    //>	@attr	treeGrid.fileImage             (SCImgURL : "[SKIN]file.gif" : [IRW])
    // The filename of the default icon for all leaf nodes in this treeGrid. Use the
    // node.icon property (null by default) to specify a custom image for an individual
    // node.
    //      @visibility external
    //  @deprecated as part of SmartClient release 5.5 in favor of +link{TreeGrid.nodeIcon}
    //<
    
    // --------------------

    //>	@attr	treeGrid.manyItemsImage        (SCImgURL : "[SKIN]folder_file.gif" : [IRW])
    // The filename of the icon displayed use as the default drag tracker when for multiple
    // files and/or folders are being dragged.
    // @group dragdrop
    //      @visibility external
    //<
	manyItemsImage:"[SKIN]folder_file.gif",
    
    //>	@attr	treeGrid.showConnectors (boolean : false : [IRW])
    // Should this treeGrid show connector lines illustrating the tree's hierachy?
    // <P>
    // For the set of images used to show connectors, see +link{connectorImage}.
    // <P>
    // <b>Note</b>: in order for connector images to be perfectly connected, all styles for
    // cells must have no top or bottom border or padding.  If you see small gaps in connector
    // lines, check your CSS files.  See the example below for an example of correct
    // configuration, including example CSS.
    // 
    // @group treeIcons
    // @example connectors
    // @visibility external
    //<
    
    showConnectors : false,
    
    //>	@attr	treeGrid.showFullConnectors (boolean : true : [IRW])
    // If +link{treeGrid.showConnectors} is true, this property determines whether we should show
    // showing vertical continuation lines for each level of indenting within the tree. Setting to
    // false will show only the hierachy lines are only shown for the most indented path ("sparse"
    // connectors).
    // @group treeIcons
    // @visibility external
    //<
    // Default to false since older skins won't have all the media required to render full
    // connector lines out.
    // The logic to show full connectors involves iterating through the parents for each node
    // being written out. This is a potential performance hit. We could improve this performance
    // by adding cacheing logic to the Tree when calculating where the continuation lines should
    // appear if this is a problem.
    showFullConnectors:true,

    //>	@attr	treeGrid.openerImage        (SCImgURL : "[SKIN]opener.gif" : [IR])
    // The base filename of the opener icon for the folder node when 'showConnectors' is false
    // for this TreeGrid.<br>
    // The opener icon is displayed beside the folder icon in the Tree column for folder nodes.
    // Clicking on this icon will toggle the open state of the folder.<br>
    // The filenames for these icons are assembled from this base filename and the state of the
    // node, as follows:<br>
    // If the openerImage is set to <code>{baseName}.{extension}</code>, 
    // <code>{baseName}_opened.{extension}</code> will be displayed next to opened folders, and
    // <code>{baseName}_closed.{extension}</code> will be displayed next to closed folders, or
    // if this page is in RTL mode, <code>{baseName}_opened_rtl.{extension}</code> and
    // <code>{baseName}_closed_rtl.{extension}</code> will be used.
    //
    // @group treeIcons
    //      @visibility external
    //<
	openerImage:"[SKIN]opener.gif",
    

    //>	@attr	treeGrid.connectorImage        (SCImgURL : "[SKIN]connector.gif" : [IR])
    // The base filename for connector icons shown when +link{TreeGrid.showConnectors} is true.
    // Connector icons are rendered into the title field of each row and show the dotted
    // hierarchy lines between siblings of the same parent node. For each node, a connector icon
    // may be shown:<ul>
    // <li>As an opener icon for folder nodes, next to the folder icon</li>
    // <li>In place of an opener icon for leaf nodes, next to the leaf icon</li>
    // <li>As a standalone vertical continuation line in the indent to the left of the node, to show
    //     a connection between some ancestor node's siblings (only relevant if
    //     +link{TreeGrid.showFullConnectors} is true).</li>
    // </ul>
    // Note that +link{TreeGrid.showFullConnectors} governs whether connector lines will be
    // displayed for all indent levels, or just for the innermost level of the tree.
    // <P>
    // The filenames for these icons are assembled from this base filename and the state of the
    // node.  Assuming the connectorImage is set to <code>{baseName}.{extension}</code>, the
    // full set of images to be displayed will be:
    // <P>
    // <code>{baseName}_ancestor[_rtl].{extension}</code> if +link{TreeGrid.showFullConnectors}
    //  is true, this is the URL for the vertical continuation image to be displayed at the
    //  appropriate indent levels for ancestor nodes with subsequent children.
    // <P>
    // For nodes with no children:
    // <ul>
    // <li><code>{baseName}_single[_rtl].{extension}</code>: Shown when there is no connector line
    //  attached to the parent or previous sibling, and no connector line to the next sibling. For
    //  +link{TreeGrid.showFullConnectors,showFullConnectors:true} trees, there will always be a
    //  connector leading to the parent or previous sibling if its present in the tree so this
    //  icon can only be displayed for the first row.</li>
    // <li><code>{baseName}_start[_rtl].{extension}</code>:  Shown when the there is no connector
    //  line attached to the parent or previous sibling, but there is a connector to the next
    //  sibling. As with <code>_single</code> this will only ever be used for the first row if
    //  +link{TreeGrid.showFullConnectors} is true</li>
    // <li><code>{baseName}_end[_rtl].{extension}</code>:  Shown if we are not showing a connector 
    //  line attached to the next sibling of this node (but are showing a connection to the previous
    //  sibling or parent).</li>
    // <li><code>{baseName}_middle[_rtl].{extension}</code>:  Shown where the we have a connector
    //  line leading to both the previous sibling (or parent) and the next sibling.
    // </ul>
    // For folders with children. Note that if +link{TreeGrid.showFullConnectors} is false, open
    // folders will never show a connector to subsequent siblings:
    // <ul>
    // <li><code>{baseName}_opened_single[_rtl].{extension}</code> opened folder node with 
    //  children when no connector line is shown attaching to either the folder's previous sibling
    //  or parent, or to any subsequent siblings.</li>
    // <li><code>{baseName}_opened_start[_rtl].{extension}</code>:  opened folder with children
    //  when the there is no connector line attached to the parent or previous sibling, but there 
    //  is a connector to the next sibling.</li>
    // <li><code>{baseName}_opened_end[_rtl].{extension}</code>:  opened folder with children 
    //  if we are not showing a connector line attached to the next sibling of this node (but are
    //  showing a connection to the previous sibling or parent).</li>
    // <li><code>{baseName}_opened_middle[_rtl].{extension}</code>: opened folder with children 
    //  where the we have a connector line leading to both the previous sibling (or parent) and the
    //  next sibling.
    // </ul>
    // <ul>
    // <li><code>{baseName}_closed_single[_rtl].{extension}</code> closed folder node with 
    //  children when no connector line is shown attaching to either the folder's previous sibling
    //  or parent, or to any subsequent siblings.</li>
    // <li><code>{baseName}_closed_start[_rtl].{extension}</code>:  closed folder with children
    //  when the there is no connector line attached to the parent or previous sibling, but there 
    //  is a connector to the next sibling.</li>
    // <li><code>{baseName}_closed_end[_rtl].{extension}</code>:  closed folder with children 
    //  if we are not showing a connector line attached to the next sibling of this node (but are
    //  showing a connection to the previous sibling or parent).</li>
    // <li><code>{baseName}_closed_middle[_rtl].{extension}</code>: closed folder with children 
    //  where the we have a connector line leading to both the previous sibling (or parent) and the
    //  next sibling.
    // </ul>
    // (Note '[_rtl]' means that "_rtl" will be attached if isRTL() is true for this widget).
    // @group treeIcons
    //      @visibility external
    //<
	connectorImage:"[SKIN]connector.gif",
    
    // Disble groupBy for TreeGrids altogether - we're already showing data-derived hierachy!
    canGroupBy: false,
    
    
    ignoreEmptyCriteria: false,
    
    
    // heavily used strings for templating
    _openIconIDPrefix: "open_icon_",
    _extraIconIDPreix:"extra_icon_",
    _iconIDPrefix: "icon_",
    _titleField: "nodeTitle"

});

isc.TreeGrid.addMethods({

initWidget : function () {
	this.invokeSuper(isc.TreeGrid, this._$initWidget);
    
    // if no dataSource is specified on this TG, pick up the dataSource off the data model
    if (!this.dataSource && this.data != null && this.data.dataSource) {
        this.dataSource = this.data.dataSource;
    }

	// if the fields are not set or of zero length, initialize with a single TREE_FIELD
    // NB: it is not safe to try to determine the tree field before setFields has been run,
    // since fields in this.fields might not be shown if they have a showIf:false
	if (!this.fields || this.fields.length == 0) {
		this.fields = [isc.TreeGrid.TREE_FIELD];
    }
},

// override setDataSource - if no fields were passed in, default to showing the tree field.
// This matches the behavior if a datbound treeGrid is initialized with no fields.
setDataSource : function (ds, fields) {

    if (fields == null || fields.length == 0) {
        fields = [isc.TreeGrid.TREE_FIELD];
    }
    return this.Super("setDataSource", [ds, fields]);
},

// make sure one of the fields has been set up as the special "tree field"
_initTreeField : function () {

	// if the fields are not set or of zero length, initialize with a single TREE_FIELD
	if (!this.fields || this.fields.length == 0) {
		this.fields = [isc.TreeGrid.TREE_FIELD];
	} else {
    
        // see which field is the tree field.  Note this handles both the case that the special
        // constant TreeGrid.TREE_FIELD was provided as a field, and the case that the caller
        // marked a field as a the treeField.
        
        // if none of the fields is specified as the treeField, we look for a "title" field,
        // then we default to the first field in the array; we use this.completeFields so that
        // the treeField property of hidden fields will be checked as well--otherwise we would
        // default another field to be the tree field, and end up with more than one treeField
        // if the hidden treeField became visible again.
        
        var completeFields = this.completeFields,
            fields = this.fields,
            treeFieldNum;
        
        for (var i = 0; i < completeFields.length; i++) {
            if (completeFields[i].treeField) {
                treeFieldNum = fields.indexOf(completeFields[i]);
                break;
            }
        }

        if (treeFieldNum == null) {
            // if autoAssignTreeField has been set false, don't assign a default tree field in 
            // the absence of an explicit marker
            if (!this.autoAssignTreeField) return;
        
    	    // if there is no explicit marker, look for the field that matches the
            // titleProperty declared on the Tree
    	    var titleProp = this.data.titleProperty,
                fieldNum = fields.findIndex(this.fieldIdProperty, titleProp);
            if (fieldNum != -1) treeFieldNum = fieldNum;
        }

        // use the first field if none were marked as the tree field
        if (treeFieldNum == null) treeFieldNum = 0;

        // store the chosen fieldNum
        this._treeFieldNum = treeFieldNum;

        // use the properties of TREE_FIELD as defaults for the field
        // Note: We're manipulating the field object in the fields array. 
        // this.completeFields also contains a pointer to this object.
        // We don't want to replace the slot in either array with a different object as
        // that would make them out of synch (causes errors sorting, etc.)
        // - instead just copy any unset properties across from the TREE_FIELD field.
        var treeField = fields[treeFieldNum],
            fieldDefaults = isc.TreeGrid.TREE_FIELD;
        for (var property in fieldDefaults) {
            if (treeField[property] == null) {
                treeField[property] = fieldDefaults[property]
            }
        }
    }
},

// because we store _treeFieldNum as a number, we need to recalc when fields are changed or
// their numbering changes.  This include setFields(), reorderFields(), showField() and hideField().
// 
// Note that the chosen treeField won't shift on reorder, because we install the TREE_FIELD
// properties into the chosen field, and the TREE_FIELD properties includes the treeField:true
// marker.
deriveVisibleFields : function (a,b,c,d) {
    this.invokeSuper(isc.TreeGrid, "deriveVisibleFields", a,b,c,d);
    this._initTreeField();
},

getEmptyMessage : function () {
    // can't just check for data != null because ListGrid initWidget sets data to [] if unset
    // and we must make sure we have a tree.
    if (isc.isA.Tree(this.data) && this.data.getLoadState(this.data.getRoot()) == isc.Tree.LOADING) 
        return this.loadingDataMessage;
    return this.emptyMessage;
},

isEmpty : function () {
    // can't just check for data != null because ListGrid initWidget sets data to [] if unset
    // and we must make sure we have a tree.
    if (!isc.isA.Tree(this.data)) return true;

    var root = this.data.getRoot();
    if (root == null) return true;

    var rootHasChildren = this.data.hasChildren(root);
    if (rootHasChildren || this.showRoot || this.data.showRoot) return false;
    return true;
},


// View state stuff
 
//> @type   treeGridOpenState  
// An object containing the open state for a treeGrid.
// Note that this object is not intended to be interrogated directly, but may be stored 
// (for example) as a blob on the server for state persistence across sessions.
// 
// @group viewState
// @visibility external
//<
// treeGridOpenState object is implemented as an array of strings, each of which is the path
// to a currently open folder (all other folders are closed)


//>	@method	treeGrid.getOpenState() 
// Returns a snapshot of the current open state of this grid's data as
// a +link{type:treeGridOpenState} object.<br>
// This object can be passed to +link{treeGrid.getOpenState()} to open the same set of folders
// within the treeGrid's data (assuming the nodes are still present in the data).
// @return (treeGridOpenState) current sort state for the grid.
// @group viewState
// @see treeGrid.getOpenState()
// @visibility external
//<
getOpenState : function () {
    var tree = this.data;
    if (tree == null) {
        this.logWarn("getOpenState() called for a treeGrid with no data");
        return [];
    }
    var root = tree.getRoot(),
        openState = [];
        
    this._addNodeToOpenState(tree, root, openState);
    return isc.Comm.serialize(openState);
},        
_addNodeToOpenState : function (tree, node, openState) {
    if (!tree.isOpen(node) || !tree.isLoaded(node)) return false;
    var children = tree.getFolders(node),
        hasOpenChildren = false;
    if (children != null) {
        for (var i = 0; i < children.length; i++) {
            hasOpenChildren = this._addNodeToOpenState(tree, children[i], openState) 
                              || hasOpenChildren;
        }
    }
    openState[openState.length] = tree.getPath(node);
    return true;
},
    
//>	@method	treeGrid.setOpenState() 
// Reset this set of open folders within this grid's data to match the 
// +link{type:treeGridOpenState} object passed in.<br>
// Used to restore previous state retrieved from the grid by a call to 
// +link{treeGrid.getOpenState()}.
//
// @param openState (treeGridOpenState) Object describing the desired set of open folders.
// @group viewState
// @see treeGrid.getOpenState()
// @visibility external
//<
setOpenState : function (openState) {
    openState = this.evalViewState(openState, "openState")
    if (!openState) return;
    
    if (!this.data) {
        this.logWarn("unable to set open state for this treeGrid as this.data is unset");
        return;
    }
    this.data.closeAll();
    this.data.openFolders(openState);
},

//>	@method	treeGrid.getSelectedPaths() 
// Returns a snapshot of the current selection within this treeGrid as 
// a +link{type:listGridSelectedState} object.<br>
// This object can be passed to +link{treeGrid.setSelectedPaths()} to reset this grid's selection
// the current state (assuming the same data is present in the grid).<br>
// @group viewState
// @see treeGrid.setSelectedPaths();
// @visibility external
// @return (listGridSelectedState) current state of this grid's selection
//<
getSelectedPaths : function () {
    if (!this.selection) return null;

    var selection = this.selection.getSelection() || [],
        selectedPaths = [];
    
    // store paths only.
    for (var i = 0; i < selection.length; i++) {
        selectedPaths[i] = this.data.getPath(selection[i]);
    }
    return isc.Comm.serialize(selectedPaths);
},

//>	@method	treeGrid.setSelectedPaths() 
// Reset this grid's selection to match the +link{type:listGridSelectedState} object passed in.<br>
// Used to restore previous state retrieved from the grid by a call to 
// +link{treeGrid.getSelectedPaths()}.
//
// @group viewState
// @param selectedPaths (listGridSelectedState) Object describing the desired selection state of
//                                              the grid
// @see treeGrid.getSelectedPaths()
// @visibility external
//<
setSelectedPaths : function (selectedPaths) {
    selectedPaths = this.evalViewState(selectedPaths, "selectedPaths")
    if (!selectedPaths) return;
    
    var selection = this.selection, data = this.data;
    if (data && selection) {
        selection.deselectAll();
        var nodes = [];
        // use find to look up node by path
        for (var i = 0; i < selectedPaths.length; i++) {
            var node = data.find(selectedPaths[i]);
            if (node) nodes.add(node);
        }
        this.selection.selectList(nodes);
    }
},

//> @type   treeGridViewState  
// An object containing the "view state" information for a treeGrid. In addition to the 
// state data contained by a +link{type:listGridViewState} object, this will also contain the 
// current open state of the treeGrid in question.<br>
// Note that this object is not intended to be interrogated directly, but may be stored 
// (for example) as a blob on the server for view state persistence across sessions.
// 
// @group viewState
// @visibility external
//<
// treeGridViewState object is implemented as a simple JS object containing the following 
// fields:
// - selected [an (undocumented) treeGridSelectedState object - an array of selected nodes' paths]
// - field [a listGridFieldState object]
// - sort [a listGridSortState object]
// - open [a treeGridOpenState object]

//>	@method	treeGrid.getViewState() 
// Overridden to return a +link{type:treeGridViewState} object for the grid.
// @return (treeGridViewState) current view state for the grid.
// @group viewState
// @see type:treeGridViewState
// @see treeGrid.setViewState();
// @visibility external
//<    
getViewState : function () {
    var state = this.Super("getViewState", [true]);
    state.open = this.getOpenState();
    return "(" + isc.Comm.serialize(state) + ")";
},
    

//>	@method	treeGrid.setViewState() 
// Overridden to take a +link{type:treeGridViewState} object.
//
// @param viewState (treeGridViewState) Object describing the desired view state for the grid
// @group viewState
// @see treeGrid.getViewState()
// @visibility external
//<    
setViewState : function (state) {

    // Ensure we set open state after setting sort state
    this.Super("setViewState", arguments);
    // don't bother warning on error - Super() will have done that already
    state = this.evalViewState(state, "viewState", true)
    if (!state) return;
    
    if (state.open) this.setOpenState(state.open);
},


// if data is not specified, use an empty Tree.
getDefaultData : function () {
    // NOTE: initializing to a ResultTree would effectively trigger fetch on draw.  Don't want
    // to do this unless fetchData() is called (possibly via autoFetchData property), in which
    // case the empty starter Tree will be discarded and replaced by a ResultTree
    //if (this.dataSource) return this.createResultTree();
    return isc.Tree.create();
},

//>	@method	treeGrid.setData()
// Set the +link{class:Tree} object this TreeGrid will view and manipulate.
//
// @param newData (Tree) Tree to show
// @visibility external
//<
setData : function (newData,a,b,c) {
	this.invokeSuper(isc.TreeGrid, "setData", newData,a,b,c);
	if (!this.data) return;
	
	// set the separateFolders and showRoot options of the tree as well
	this.data.separateFolders = this.separateFolders;

    if (this.showRoot && isc.ResultTree && isc.isA.ResultTree(this.data)) {
        this.logWarn("showRoot may not be set with a databound treeGrid, unexpected " +
                     "results may occur");
    }
	this.data.showRoot = this.showRoot;

	// should we show only branches or leaves
	this.data.openDisplayNodeType = this.displayNodeType;
},

draw : function (a,b,c,d) {
    if (this.initialData && (!isc.ResultSet || !isc.isA.ResultSet(this.data))) {
        this.setData(this.createResultTree());
    }
    
    this.invokeSuper(isc.TreeGrid, "draw", a,b,c,d);
},

bodyConstructor:"TreeGridBody",

// Override bodyKeyPress to handle open and closing of trees
// Note: standard windows behavior with Left and Right arrow key presses in a treeGrid is:
// - multiple selection seems to *always* be disallowed, so doesn't come into play
// - arrow right on a closed folder will open the folder
// - arrow right on an open folder (with content) will move selection to the first child node
// - arrow left on an open folder will close the folder
// - arrow left on a node within a folder will move selection to the node's parent folder

bodyKeyPress : function (event) {

    // if exactly one record is selected, mimic windows LV behaviors for arrow left and right
    var selection = this.selection;
    if (this.selectionType != isc.Selection.NONE && 
        this.data.getLength() > 0 &&
        selection.anySelected() && !selection.multipleSelected()) 
    {
        var node = this.selection.getSelectedRecord();
        
        if (event.keyName == "Arrow_Left") {
            if (this.data.isFolder(node) && this.data.isOpen(node)) {
                this.closeFolder(node);
            } else {
                this._generateRecordClick(this.data.getParent(node), true);
            }
            return false;
            
        } else if (event.keyName == "Arrow_Right") {
            if (this.data.isFolder(node)) {
                if (!this.data.isOpen(node)) {
                    this.openFolder(node);
                    return false;
                    
                } else {
                    var nextNode = this.getRecord(this.data.indexOf(node) + 1);
                    if (nextNode != null && this.data.getParent(nextNode) == node) {
                        this._generateRecordClick(nextNode, true);
                        return false;
                    }
                }
            }
        }
    }
    
    return this.Super("bodyKeyPress", arguments);
    
},

// fire synthetic context menu events for nodes
_cellContextClick : function (record, recordNum, fieldNum) {

	if (recordNum < 0 || fieldNum < 0) return true; // not in body, allow native context menu

	var isFolder = this.data.isFolder(record);
    
    // fire synthetic context click events.  Note any of these can cancel further processing by
    // returning an explicit false, which presumably indicates they've shown a context menu
    if (this.nodeContextClick && this.nodeContextClick(this, record, recordNum) == false) {
        return false;
    }
    if (isFolder) {
        if (this.folderContextClick && this.folderContextClick(this, record, recordNum) == false) {
            return false;
        }
    } else {
        if (this.leafContextClick && this.leafContextClick(this, record, recordNum) == false) {
            return false;
        }
    }

    // fire the superclass implementation of this method to fire 'cellContextClick', if defined,
    // and show the default context menu if appropriate
    return this.Super("_cellContextClick", arguments);
	
},

//>	@method	treeGrid.handleEditCellEvent()
//		@group	event handling	
//			Override handleEditCellEvent to not allow editing if the click / doubleClick event 
//          occurred over the open area of the treeGrid
//
//		@return	(boolean)	false == cancel further event processing
//<
handleEditCellEvent : function (recordNum, fieldNum) {

    var record = this.getRecord(recordNum);
	// if they're clicking in the open area of the list, don't allow editing to proceed
	if (this.clickInOpenArea(record)) return false;
	
	// return the results of a call to the superclass method
	return this.Super("handleEditCellEvent",arguments);
},

//>	@method     treeGrid.canEditCell()	
// Overridden to disallow editing of the +link{treeNode.name, name} field of this grid's data
// tree. Also disallows editing of the auto-generated tree field, which displays the result
// of +link{method:Tree.getTitle} on the node.
// @return (boolean) Whether to allow editing this cell
// @visibility external
//<
canEditCell : function (rowNum, colNum) {

    if (this.Super("canEditCell", arguments) == false) return false;

    
    if (this.getField(colNum)[this.fieldIdProperty] == this.data.nameProperty) return false;
    
    
    if (this.getField(colNum)[this.fieldIdProperty] == this._titleField) return false;

    return true;
},

// Override the method to determine the widths of the form items displayed while editing to
// account for the tree-field indents
getEditFormItemFieldWidths : function (record) {

    var level = this.data.getLevel(record);
    if (!this.showRoot) level--;
    var indentSize = level * this.indentSize;
    indentSize += this.iconSize + this.getOpenerIconSize(record);
    if (this.getExtraIcon(record)) indentSize += this.iconSize;
    
    var widths = this.Super("getEditFormItemFieldWidths", arguments),
        treeFieldNum = this.getTreeFieldNum();

    widths[treeFieldNum] -= indentSize;
    return widths;
},

// return the DataSource for the current record, to allow embedded editing
getRecordDataSource : function (record) {
    return this.data.getNodeDataSource(record);
},

//>	@method	treeGrid.rowClick()
//
// This override to +link{ListGrid.rowClick()}.  This implementation calls through to the
// +link{TreeGrid.nodeClick}, +link{TreeGrid.folderClick}, +link{TreeGrid.leafClick} methods, as
// appropriate unless the click was on the expand/collapse control of a folder - in which case
// those callbacks are not fired.
// <p>
// Do not override this method unless you need a rowClick callback that fires even when the
// user clicks on the expand/collapse control.  If you do override this method, be sure to call
// <code>return this.Super("rowClick", arguments);</code> at the end of your override to
// preserver other handler that are called from the superclass (for example,
// +link{ListGrid.recordClick()}.
// <p>
//
//      @param  record      (TreeNode)    record that was clicked on
//		@param	recordNum   (number)	index of the row where the click occurred
//		@param	fieldNum	(number)	index of the col where the click occurred
//
// @see TreeGrid.nodeClick()
// @see TreeGrid.folderClick()
// @see TreeGrid.leafClick()
// @see ListGrid.recordClick()
//
// @visibility external
//<

rowClick : function (record, recordNum, fieldNum) {

    var node = record;

	// if the're clicking in the open area of the list, 
	//  it's already been processed properly on mouseDown so just bail
	if (this.clickInOpenArea(node)) return false;
	
	this._lastRecordClicked = recordNum;
	if (recordNum < 0 || fieldNum < 0) return false; // not in body
	
	var node = this.getRecord(recordNum),
        isFolder = this.data.isFolder(node);

    if (this.nodeClick) this.nodeClick(this, node, recordNum);

    if (isFolder) {
        if (this.folderClick) this.folderClick(this, node, recordNum);
    } else {
        if (this.leafClick) this.leafClick(this, node, recordNum);
    }
	
	// execute the super class click method - to pick up field click and recordClick
    // Note: be sure not to call any handlers the ListGrid will call so as not to get a dup
	return this.Super("rowClick",arguments);
},



//>	@method	treeGrid.recordDoubleClick()
//
// Handle a doubleClick on a tree node - override of ListGrid stringMethod of same name.  If
// the node is a folder, this implementation calls +link{TreeGrid.toggleFolder()} on it.  If
// the node is a leaf, calls +link{TreeGrid.openLeaf()} on it.
// 
// @see listGrid.recordDoubleClick()
// @visibility external
//<
recordDoubleClick : function (viewer, record, recordNum, field, fieldNum, value, rawValue) {
	// if the're clicking in the open area of the list, 
	//  it's already been processed properly on mouseDown so just bail
	if (this.clickInOpenArea(record)) return false;
    
	if (this.data.isFolder(record)) {
		return this.toggleFolder(record);
	} else
		return this.openLeaf(record);
},
    
dataChanged : function () {
    this.Super("dataChanged", arguments);

    
    var folder = this._pendingFolderAnim;
    if (folder && this.data.isOpen(folder) && 
        this.data.getLoadState(folder) == isc.Tree.LOADED) 
    {
        this._startFolderAnimation(folder);
        this._pendingFolderAnim = null;
    }
},
    

//>	@method	treeGrid.openLeaf()   ([A])
// Executed when a leaf node receives a 'doubleClick' event. This handler must be
// specified as a function, whose single parameter is a reference to the relevant leaf node in
// the tree's data.<br>
// See the ListGrid Widget Class for inherited recordClick and recordDoubleClick events.
//
//      @visibility external
//		@param	node		(TreeNode)		node to open
//      @see    class:ListGrid
//<
openLeaf : function (node) {},


// Drag and Drop
// ----------------------------------------------------------------------------------------

//>	@method	TreeGrid.transferDragData()	(A)
//
//  This is just like the superclass' transferDragData(), but avoids infinite recursion in the
//  COPY case by avoiding the _parent key.
//
//		@group	dragging, data
//			update the data object as appropriate on drop.
//          return the data that was dragged -- the selected records
//		@return		(List of TreeNode)		List of TreeNodes that were selected when dragging began
//<
transferDragData : function() {
	
	var selection = this.getDragData();
	if (this.dragDataAction == isc.TreeGrid.COPY || this.dragDataAction == isc.TreeGrid.CLONE) 
    {
        // get a clean copy of the data
		selection = this.data.getCleanNodeData(selection);
	} else {
		selection = this.Super("transferDragData");
	}
	return selection;
},

// ----------------------------------------------------------------------------------
// Customizations of the drag-tracker for tree grids

//> @method treeGrid.getDragTrackerIcon()
// Return an icon to display as a drag tracker when the user drags some node(s).<br>
// Default implementation:<br>
// If multiple nodes are selected and +link{TreeGrid.manyItemsImage} is defined, this
// image wlll be returned<br>
// Otherwise returns the result of +link{TreeGrid.getIcon()} for the first node being 
// dragged.
// <p>
// Note: Only called if +link{listGrid.dragTrackerMode} is set to <code>"icon"</code>. 
// @param records (Array of ListGridRecord) Records being dragged
// @return (string) Image URL of icon to display
// @group dragTracker
// @visibility external
//<
getDragTrackerIcon : function (records) {
    
    var icon;
    if (records && records.length > 1 && this.manyItemsImage !=null)
        icon = this.manyItemsImage;
    else if (records && records[0]) icon = this.getIcon(records[0], true);
    return icon;
},

// Override getDragTrackerTitle() to just return the icon and title of the row, not
// the indent, opener icon, etc.
// Override not currently documented as it's essentially the same as the superclass 
// implementation - we just reformat the title cell value to avoid it showing the
// indent and opener icon.
getDragTrackerTitle : function (record, rowNum, a,b,c,d) {
    var fieldNum = this.getFieldNum(this.getTitleField()); 
    if (fieldNum != this.getTreeFieldNum()) 
        return this.invokeSuper(isc.TreeGrid, "getDragTrackerTitle", record, rowNum, a,b,c,d);
    // Call the standard listGrids 'getCellValue()' method to give us the formatted title
    // of the cell being dragged, excluding the TreeGrid folder/file icons, etc.
    var value = this.invokeSuper(isc.TreeGrid, "getCellValue",  record, rowNum, fieldNum);
    // Now use _getTreeCellTitleArray() to tack on the icon for the node.
    var titleCell = this._getTreeCellTitleArray(value, record, null, false).join(isc.emptyString);
    
    // We need to apply the base (non selected) standard cellStyle/cssText to the drag tracker 
    // table.
    
    var cellStyle = this.getCellStyle(record, rowNum, fieldNum);
    if (this.selection.isSelected(record)) {
        var styleIndex = this.body.getCellStyleIndex(record, rowNum, fieldNum),
            standardSelectedStyle = this.body.getCellStyleName(styleIndex, record, 
                                                                rowNum, fieldNum);
        if (standardSelectedStyle == cellStyle) {
            styleIndex -= 2;
            cellStyle = this.body.getCellStyleName(styleIndex, record, rowNum, fieldNum);
        }
    }
    
    return ["<table class='", cellStyle,
             "' style='", this.getCellCSSText(record, rowNum, fieldNum), 
             "'><tr>", titleCell, "</tr></table>"].join(isc.emptyString);
},


//>	@method	treeGrid.willAcceptDrop()	(A)
// 
// This method overrides +link{ListGrid.willAcceptDrop()} and works as follows:
// <br><br>
// First, +link{ListGrid.willAcceptDrop()} (the superclass definition) is consulted.  If it
// returns false, then this method returns false immediately.<br>
// This handles the following cases:<br>
// - reordering of records withing this TreeGrid when +link{ListGrid.canReorderRecords} is true<br>
// - accepting dropped records from another dragTarget when +link{ListGrid.canAcceptDroppedRecords} 
//   is true and the dragTarget gives us a valid set of records to drop into place.<br>
// - disallowing drop over disabled nodes, or nodes with <code>canAcceptDrop:false</code>
// <br>
// This method will also return false if the drop occurred over a leaf node whos immediate 
// parent has <code>canAcceptDrop</code> set to <code>false</code><br>
// If +link{TreeGrid.canReparentNodes} is true, and the user is dragging a node from one folder
// to another, this method will return true to allow the change of parent folder.<br>
// <br><br>
// Otherwise this method returns true.
//
// @group event handling	
// @return	(boolean)	true if this component will accept a drop of the dragData
//
// @visibility external
//<
willAcceptDrop : function () {
    // Bail if Superclass willAcceptDrop fails
    // (Checks that the record is enabled, etc.)
    if (!this.Super("willAcceptDrop",arguments)) return false;

    isc._useBoxShortcut = true;
	// get the record being dropped on
	var recordNum = this.getEventRecordNum(),
		newParent = this.data.get(recordNum);
    isc._useBoxShortcut = false;

    // dropping in the body in open space means add to root
    if (newParent == null) newParent = this.data.getRoot();

	// if we can't get the new parent, or it can't accept drops, return false
	if (!newParent || newParent.canAcceptDrop == false) return false;
    
    // don't allow drop over non-folder nodes, unless we're allowing record reordering or
    // canDropOnLeaves is set
    var isFolder = this.data.isFolder(newParent);
    if (!isFolder && !(this.canReorderRecords || this.canDropOnLeaves)) return false;
    
    // check for dropErrors (dropping record over self, etc.)
    var moveList = isc.EH.dragTarget.getDragData();
    if (!isc.isAn.Object(moveList) || this.getDropError(moveList, newParent) != null) {
        return false
    }
    // Even if we are allowing record reordering, don't allow the user to drop into a 
    // parent with canAcceptDrop explicitly set to false
    
    if (!isFolder) {
        newParent = this.data.getParent(newParent);
        if (newParent.canAcceptDrop == false) return false;
    }
    
    // If we're dragging data in from another listGrid we're done here
    // (this relies on canAcceptDropRecords getting checked by the superClass implementation
    // for this case).
    if (isc.EH.dragTarget != this) return true;
    
    // If we can reorder records, but not reparent, we need to catch the cases where
    // - records selected currently come from multiple folders
    // - the drop folder doesn't match the source folder for the node[s]
    var canReparent = this.canReparentNodes;
    //>!BackCompat 2006.06.27
    if (canReparent == null && this.canAcceptDroppedRecords) canReparent = true;
    //<!BackCompat
    
    if (!canReparent) {
        if (!isc.isAn.Array(moveList)) moveList = [moveList];
        var currentParent;
        currentParent = this.data.getParent(moveList[0]);

        if (currentParent != newParent) return false;
        
        for (var i = 1; i < moveList.length; i++) {
            if (currentParent != this.data.getParent(moveList[i])) return false;
        }
    }
    
	// if we get here, it should be OK!
	return true;
},

// Override setUpDragProperties to pick up this.canReparentNodes 
_setUpDragProperties : function () {

    // set up our specific drag-and-drop properties
	this.canDrag = (this.canDrag || this.canDragRecordsOut || 
                    this._canDragRecordsToSelf() || this.canDragSelect);
	this.canDrop = (this.canDrop || this.canDragRecordsOut || this._canDragRecordsToSelf());
	this.canAcceptDrop = (this.canAcceptDrop || this.canAcceptDroppedRecords || 
                            this._canDragRecordsToSelf());
},


// allow the user to drag records to self if they can be reordered or reparented
_canDragRecordsToSelf : function () {
    var canReparentNodes = this.canReparentNodes;
    //>!BackCompat 2006.06.27
    if (canReparentNodes == null && this.canAcceptDroppedRecords) {
        if (!this._canReparentBackcompatNotified) {
            this.logInfo("'canReparentNodes' is unset. Allowing node reparenting as " + 
                         "'canAcceptDroppedRecords' is set to true. For explicit control, " +
                         "use 'canReparentNodes' instead.", "dragDrop");
            this._canReparentBackcompatNotified = true;
        }
        canReparentNodes = this.canAcceptDroppedRecords;
    }
    //<!BackCompat
    
    return this.canReorderRecords || canReparentNodes;
},

// if there's a problem that makes this drop invalid, return an error string to display
getDropError : function (moveList, newParent) {

	// don't allow a parent to be dropped on it's own descendant
	for (var i = 0, length = moveList.length; i < length; i++) {
		if (this.data.isDescendantOf(newParent, moveList[i])) {
			return this.cantDragIntoChildMessage;
		}
	}

	// make sure they're not trying to drag a folder into itself
    var isFolder = this.data.isFolder(newParent);
    if (isFolder) {
    	for (i = 0; i < length; i++) {
	    	if (moveList[i] == newParent) {
		    	return this.cantDragIntoSelfMessage;
    		}
	    }
    }

    return null;
},


//>	@method	treeGrid.dropMove()	(A)
//			mouse is moving over the list while dragging is happening
//			show a hilite in the appropriate record if necessary
//		@group	event handling	
//
//		@return	(boolean)	false == cancel further event processing
//<
dropMove : function () {
    var eventRow = this.getEventRow();
    // before the beginning of the rendered area, aka over the header; do nothing
    if (eventRow == -1) return;
    
    // if after the end of the list, choose root
    var eventNode = (eventRow == -2 ? this.data.getRoot() : this.data.get(eventRow)),
        dropFolder = this.getDropFolder(),
        position = (this.canReorderRecords ? this.getReorderPosition(eventRow) : null);
        
    // We used to check willAcceptDrop() here, but that prevented spring-loaded folders
    // from working in the case where the folder being hovered over is will not accept the
    // drop, but one of its children might accept the drop.  So now, we always set the
    // timer to open a folder being hovered on and updateDropFolder() logic checks for
    // willAcceptDrop().
    
    // suppress duplicate runs, but updateDropFolder() whenever the lastDropFolder, eventNode
    // or lastPosition have changed because event though we may still be within the same
    // dropFolder, we may want to change the dropFolder icon state based on whether the tree
    // willAcceptDrop() at the new location.
    if (dropFolder != this.lastDropFolder || 
        eventNode != this._lastEventNode || position != this._lastPosition) {

        // Set up a function to be executed in the global scope to open the drop folder.
        if (!this._openDropFolder) {
            this._openDropFolder = this.getID() + ".openDropFolder()";
        }

        // If there's a running openDropFolderTimer, clear it
        if (this.openDropFolderTimer) isc.Timer.clear(this.openDropFolderTimer);    
			
        // If the dropFolder is closed, set up a new openDropFolderTimer
        if (!this.data.isOpen(dropFolder)) {
            this.openDropFolderTimer = 
                            isc.Timer.setTimeout(this._openDropFolder, this.openDropFolderDelay);
        }

        // remember the new drop-folder as this.lastDropFolder, and update its icon.
        // [note this calls 'willAcceptDrop()']
        this.updateDropFolder(dropFolder);
    }

    // If the drop is disallowed, show the 'no drop' cursor
    
    if (!this.willAcceptDrop()) {
        this.body.setNoDropIndicator();
    } else {        
        this.body.clearNoDropIndicator();
    }
    
    // Show the drag line if appropriate
    if (this.canReorderRecords) {
        if (this.data.isOpen(dropFolder)) this.showDragLineForRecord(eventRow, position);
        else this.hideDragLine();
    }
    this._lastEventNode = eventNode;
    this._lastPosition = position;

    
},

//>	@method	treeGrid.getEventRow()
// @include gridRenderer.getEventRow()
// @group events
// @visibility external
//<

//> @method treeGrid.getDropFolder()
// When the user is dragging a droppable element over this grid, this method returns the folder
// which would contain the item if dropped. This is the current drop node if the user is hovering
// over a folder, or the node's parent if the user is hovering over a leaf.
// @group events
// @return (node) target drop folder
// @visibility external
//<
getDropFolder : function () {

    var eventRow = this.getEventRow(),
        data = this.data,
        // before the beginning of the list (over header), or after the end, use root
        eventNode = (eventNode < 0 ? data.getRoot() : data.get(eventRow));
    
    // if we're over the root, we're going to drop into the root (no choice)
    if (data.isRoot(eventNode)) return data.getRoot();    
    
    var isFolder = data.isFolder(eventNode);

    // if we can't reorder records, it's easy
    if (!this.canReorderRecords) return (isFolder ? eventNode : data.getParent(eventNode));
    
    var position = this.getReorderPosition(eventNode);
    
    // if we're over a leaf (anywhere), or
    // we're over the "before" or "after" part (top / bottom 1/4) of any folder, or
    // we're over the "after" part (bottom 1/4) of a closed or empty folder, return the 
    // parent of the node,
    if (!isFolder || position == isc.ListGrid.BEFORE || 
            (position == isc.ListGrid.AFTER && 
                (!data.isOpen(eventNode) || !data.hasChildren(eventNode)) )  ) 
    {
        return data.getParent(eventNode);  
    } else {
        // In this case we're either over the "over" position of a closed folder, or the 
        // "below" position for an open folder.  In either case we'll want to drop into this 
        // folder, before the first child
        return eventNode;
    }

},


//>	@method	treeGrid.openDropFolder()	(A)
// Method to open the folder we're currently hovering over (about to drop)
// Called on a timer set up by this.dropMove
//		@group	event handling	
//<
openDropFolder : function () {
    var dropFolder = this.lastDropFolder;
    
    // if we're not over a closed folder, bail!
    if (!dropFolder || 
        !this.data.isFolder(dropFolder) || 
        this.data.isOpen(dropFolder))          return false;

    // Open the folder
    this.data.openFolder(dropFolder);
    // show the drag line if we can reorder
    if (this.canReorderRecords) 
        this.showDragLineForRecord(this.data.indexOf(dropFolder), isc.ListGrid.OVER)
    
},

// Override getReorderPosition to return "over" when over the middle part of a closed folder.
getReorderPosition : function (recordNum, y, a,b,c) {
    
	// If a y-coordinate was not passed, get it from the offset of the last event
	if (y == null) y = this.body.getOffsetY();

    // which row is the mouse over?
    if (recordNum == null) recordNum = this.getEventRow(y);

    var data = this.data;
    if (!isc.isA.Number(recordNum)) recordNum = data.indexOf(recordNum);
    
    var record = data.get(recordNum);
        
    if (record && data.isFolder(record)) {

        var localY = y - this.body.getRowTop(recordNum),
            recordHeight = this.body.getRowSize(recordNum);
      
        // Top 1/4, drop above, 
        // Bottom 1/4, drop below
        // Middle - drop into folder 
        if (localY < (recordHeight / 4)) {
            return isc.ListGrid.BEFORE;
        } else if (localY > (3*recordHeight/4) ) {
            return isc.ListGrid.AFTER;
        } else {
            return isc.ListGrid.OVER;
        }        
    }
    
    // If we're over a leaf, allow the super method to take care of it.
    return this.invokeSuper(isc.TreeGrid, "getReorderPosition", recordNum, y, a,b,c);
},

// Override showDragLineFor record - if the drop will occur inside a folder, we'll show the
// drag line after the folder (before the first child)
showDragLineForRecord : function (recordNum, position, a,b,c) {
    
    if (recordNum == null) recordNum = this.getEventRecordNum();    
    if (position == null) position = this.getReorderPosition(recordNum);

    // If dropping over an open folder, show the drag line before the first child (after the
    // folder)    
    if (position == isc.ListGrid.OVER) {
        var node = this.getRecord(recordNum),
            data = this.data;
        if (data.isFolder(node) && data.isOpen(node)) position = isc.ListGrid.AFTER;
    }
    
    // Have the default implementation actually show the drag line.
    return this.invokeSuper(isc.TreeGrid, "showDragLineForRecord", recordNum, position, a,b,c);
},


//>	@method	treeGrid.dropOut()	(A)
//			mouse just moved out of the range of the list while dragging is going on
//			remove the hilite
//		@group	event handling	
//
//		@return	(boolean)	false == cancel further event processing
//<
dropOut : function () {
    // Hide drag line
    this.hideDragLine();
    // clear no-drop indicator
    this.body.clearNoDropIndicator();
    
    // Clear any remembered drop folder
    this._lastEventNode = null;
    this.updateDropFolder();
    
    // If we have a timer waiting to open a drop folder, clear it
    // (Note - if it did fire it would bail anyway because lastDropMoveRow has gone, but
    // this is more efficient)
    if (this.openDropFolderTimer) isc.Timer.clear(this.openDropFolderTimer);    
    
},

//>	@method	treeGrid.updateDropFolder()	(A)
// Takes a record (or record index) as a parameter
// Applies the folderDropImage icon to the parameter (or parent folder, if passed a leaf)
// Clears out any folderDropImage applied to another folder.
// Remembers the folder passed in as this.lastDropFolder.
//		@group	drawing, event handling
//
//		@param newFolder (object or index)
//<
updateDropFolder : function (newFolder) {

    var LDF = this.lastDropFolder;
    this.lastDropFolder = newFolder;

    // Set the icons on both the previous and current drop folder
    //
    // Special _willAcceptDrop flag: set for getIcon() and only update to drop state if the
    // body willAcceptDrop() the new folder - see comments in dropMove()
    if (newFolder) {
        newFolder._willAcceptDrop = this.body.willAcceptDrop(newFolder)
		this.setRowIcon(newFolder, this.getIcon(newFolder));
    }

    if (LDF && LDF != newFolder) {
        delete LDF._willAcceptDrop;   
        this.setRowIcon(LDF, this.getIcon(LDF));
    }
},


//> @method treeGrid.transferSelectedData()
// Simulates a drag / drop type transfer of the selected records in some other grid to this
// treeGrid, without requiring any user interaction.<br>
// See the +link{group:dragging} documentation for an overview of grid drag/drop data
// transfer.
// @param sourceGrid (ListGrid) source grid from which the records will be tranferred
// @param [folder] (TreeNode) parent node into which records should be dropped - if null
//    records will be transferred as children of the root node.
// @param [index] (integer) target index (drop position) within the parent folder 
// @group dragging
// @example dragTree
// @visibility external
//<
transferSelectedData : function (source, folder, index) {
    
    if (!this.isValidTransferSource(source)) return;
    
    // don't check willAcceptDrop() this is essentially a parallel mechanism, so the developer 
    // shouldn't have to set that property directly.
    if (index == null) index = 0;
    if (folder == null) folder = this.data.getRoot();
    
    // Call getDragData() to pull the records out of the source's dataSet
    // Note we don't need to call 'transferDragData' here that'll be handled by folderDrop()
    
    var nodes = source.getDragData();
    this.transferNodes(nodes, folder, index, source);
},

//>	@method	treeGrid.drop()	(A)
//		@group	event handling	
//			handle a drop in the list
//			if possible, move or copy the items automatically
//			NOTE: at this point, we should be assured that we can accept whatever was dragged...
//		@return	(boolean)	false == cancel further event processing
//<
drop : function () {
    if (!this.willAcceptDrop()) return false;

    // NOTE: we perform some redundant checks with willAcceptDrop(), but this is not a time
    // critical method, and the errors being checked for would corrupt the Tree and so should
    // never be allowed, so it makes sense to check them here as well since willAcceptDrop()
    // might be incorrectly overidden.

	// get what was dropped and where it was dropped
	var moveList = isc.EH.dragTarget.getDragData(),
		recordNum = this.getEventRecordNum(),
        position = this.getReorderPosition(recordNum),
        // dropping in the body in open space means add to root
        dropItem = this.data.get(recordNum) || this.data.getRoot(),
        
        newParent = this.getDropFolder();
    

    //this.logWarn("valid drop with parent: " + this.echo(newParent));

    // figure out if this is a drag within the same Tree data model.  This can happen within the
    // same TreeGrid or across two TreeGrids.
    var dragTree = isc.EH.dragTarget.getData(),
        dragWithinTree = ( isc.isA.Tree(dragTree) && 
                           isc.isA.Tree(this.data) && 
                           dragTree.getRoot() == this.data.getRoot() );
    // make sure that they're not trying to drag into parent containing child with same name.
    // NOTE: this particular check is postponed until drop() because it's not self-evident why
    // the widget won't accept drop, so we want to warn() the user
    
    for (var i = 0; i < moveList.length; i++) {
        
        var child = moveList[i];

        // NOTE: If dragging in from another tree - set dragDataAction to "copy" to test the
        // code below, otherwise you end up with 2 trees pointing at the same object

        // name collision: see if there's already a child under the newParent that has the same
        // name as the child we're trying to put under that parent
        var collision = (this.data.findChildNum(newParent, this.data.getName(child)) != -1);

        // this collision is not a problem if we're reordering under the same parent
        var legalReorder = dragWithinTree && this.canReorderRecords && 
                            newParent == this.data.getParent(child);
        if (collision && !legalReorder) {
            this.logInfo("already a child named: " + this.data.getName(child) + 
                         " under parent: " + this.data.getPath(newParent));
            isc.warn(this.parentAlreadyContainsChildMessage);
            return false;
        }            
    }

	// At this point, everything looks OK and we are accepting the drop	

    // figure out where the dropped should be placed in the parent's children 
    var index = null;
    if (this.canReorderRecords) {
        if (recordNum < 0) {
            // already set dropItem to root
            newParent = dropItem;
            // special case: dropped in empty area of body, make last child of root
            index = this.data.getChildren(newParent).getLength();
        } else if (dropItem == newParent) {
            // if dropped directly on a folder, place at beginning of children
            index = 0;
        } else {
            // otherwise place before or after leaf's index within parent
            index = (position == isc.ListGrid.AFTER ? 1 : 0) + 
                        this.data.getChildren(newParent).indexOf(dropItem);
        }
    }
    this.folderDrop(moveList, newParent, index, isc.EH.dragTarget);

	// open the folder the nodes were dropped into
	this.data.openFolder(newParent);
			
	// return false to cancel further event processing
	return false;
},

//> @method treeGrid.folderDrop() [A]
//
// This method processes the drop on a folder in the TreeGrid.  The default implementation
// works as follows:
// <P>
// If the nodes originate in this tree and the +link{TreeGrid.dragDataAction} is "none" or
// "move", then the nodes are simply reordered in this TreeGrid.  Otherwise (if
// +link{TreeGrid.dragDataAction} is "copy" or "none"), this method calls
// +link{ListGrid.transferDragData()} on the <code>sourceWidget</code> and adds the returned
// rows to this TreeGrid.
// <P>
// In either case, the new row(s) appear in the <code>folder</code> at the <code>index</code>
// specified by the arguments of the same name.
// <P>
// For dataBound treeGrids, folderDrop() will initiate +link{DSRequest,DataSource requests}
// to update remote datasets.  For nodes moved within the tree, an "update" operation will
// be submitted to update the +link{tree.parentIdField,parentId} field of the moved node(s).  For
// nodes added to a tree, "add" DataSource requests will be submitted with the dropped
// node(s) as dsRequest.data.
// <P>
// As a special case, if the <code>sourceWidget</code> is also databound, and a 
// +link{dataSourceField.foreignKey,foreignKey} relationship is declared from the
// <code>sourceWidget</code>'s DataSource to this TreeGrid's DataSource, the interaction will
// be treated as a "drag recategorization" use case such as files being placed in folders,
// employees being assigned to teams, etc.  "update" DSRequests will be submitted that
// change the foreignKey field in the dropped records to point to the tree folder that was the
// target of the drop.  In this case no change will be made to the Tree data as such, only to
// the dropped records. 
//
// @param nodes (List of TreeNode) List of nodes being dropped
// @param folder (TreeNode) The folder being dropped on
// @param index (integer) Within the folder being dropped on, the index at which the drop is
//                        occurring.
// @param sourceWidget (Canvas) The component that is the source of the nodes (where the nodes
//                              were dragged from).
//
// @visibility external
// @example treeDropEvents
//<
folderDrop : function (nodes, folder, index, sourceWidget) {

    this.transferNodes(nodes, folder, index, sourceWidget);

},


// Helper for folderDrop and transferSelectedData
transferNodes : function (nodes, folder, index, sourceWidget) {

    // If parent folder is null, we're dropping into the TreeGrid body, which implies root
    folder = folder || this.data.root;

    // figure out if this is a drag within the same Tree (even if from another TreeGrid)
    var dragTree = sourceWidget.getData(),
        dragWithinTree = ( isc.isA.Tree(dragTree) && 
                           isc.isA.Tree(this.data) && 
                           dragTree.getRoot() == this.data.getRoot() );
    // if we're dropping an item from one tree to another that both share the same root, perform a
	// move instead.  Note that this ignores dragType (eg clone vs copy) completely.
    var dataSource = this.getDataSource(),
        sourceDS = sourceWidget.getDataSource();
	if (dragWithinTree && (this.dragDataAction != isc.TreeGrid.COPY && 
                           this.dragDataAction != isc.TreeGrid.CLONE)) 
    {
        if (dataSource != null && this.data != null && 
            isc.ResultTree && isc.isA.ResultTree(this.data)) 
        {
            var wasAlreadyQueuing = isc.rpc.startQueue();
            for (var i = 0; i < nodes.length; i++) {
                
                var node = isc.addProperties({}, this.data.getCleanNodeData(nodes[i])),
                    oldValues = isc.addProperties({}, node);
                node[this.data.parentIdField] = folder[this.data.idField];
                this._updateDataViaDataSource(node, dataSource, { 
                    oldValues : oldValues,  
                    parentNode : this.data.getParent(nodes[i])
                });                          
            }
            // send the queue unless we didn't initiate queuing
            if (!wasAlreadyQueuing) isc.rpc.sendQueue();
            return;
            
        } else {
            // move the nodes within the tree
  	    	dragTree.moveList(nodes, folder, index);
        }
	} else if (dataSource != null) {
         var canRecat;
        if (this.dragRecategorize && sourceDS != null &&
            this.data != null && isc.ResultTree && isc.isA.ResultTree(this.data))
        {
            // check for a foreign key relationship between some field in the source DS to some
            // field in the treeGrid DS
            var relationship = sourceDS.getTreeRelationship(dataSource);
            
            if (relationship != null && relationship.parentIdField) {
                var cannotRecat = false,
                    pkFields = sourceDS.getPrimaryKeyFields();
                
                // If the detected foreignKeyField is a Primary Key, we can't modify it.
                // Catch this case and log a warning
                
                for (var pk in pkFields) {
                    if (pk == relationship.parentIdField) {
                        this.logWarn("dragRecategorize: data source has dataSource:" 
                                    + sourceDS.getID() + ". foreignKey relationship with " +
                                    "target dataSource " + dataSource.getID() + 
                                    " is based on primary key which cannot be modified.");
                        cannotRecat = true;
                    }
                }
                if (!cannotRecat) canRecat = true;
                //>DEBUG
                this.logInfo("Recategorizing dropped nodes in dataSource:" + sourceDS.getID());
                //<DEBUG
            }
    
            var wasAlreadyQueuing = isc.rpc.startQueue();
            for (var i = 0; i < nodes.length; i++) {
                var node = isc.addProperties({}, nodes[i]);
                if (canRecat) {
                    node[relationship.parentIdField] = folder[relationship.idField];
                }
                isc.addProperties(node, 
                    this.getDropValues(node, sourceDS, folder, index, sourceWidget));

                this._updateDataViaDataSource(node, sourceDS);
            }
            // send the queue unless we didn't initiate queuing
            if (!wasAlreadyQueuing) isc.rpc.sendQueue();
            return;
        }

        // calling transferDragData gives the source widget a chance to clear out if 
        // we're doing a move, for example.
        nodes = sourceWidget.transferDragData();

        var wasAlreadyQueuing = isc.rpc.startQueue();
        for (var i = 0; i < nodes.length; i++) {
            var data = nodes[i],
                resultTree = this.data;
            if (resultTree) {
                data[resultTree.parentIdField] = folder[resultTree.idField];
            }
            isc.addProperties(node, 
                this.getDropValues(data, sourceDS, folder, index, sourceWidget));
            this._addIfNotDuplicate(data, sourceDS, null, index, folder);
        }
        // send the queue unless we didn't initiate queuing
        if (!wasAlreadyQueuing) isc.rpc.sendQueue();
    } else {
        // add the dropped nodes to the tree at the specified point - they could be rows from a
        // ListGrid, or anything - it's up to the developer to have it make sense
        //this.logWarn("adding dragData at parent: " + newParent + ", position: " + position);
        nodes = sourceWidget.transferDragData();
        for (var i = 0; i < nodes.length; i++) {
            this._addIfNotDuplicate(nodes[i], sourceDS, null, index, folder);
        }
    }
},

// Tree-specific HTML generation
// --------------------------------------------------------------------------------------------

//>	@method	treeGrid.getTreeCellValue()
//			Returns the HTML to display a cell with
//          <ul>
//          <li>Indentation</li>
//          <li>Open / Close Icon (folders only)</li>
//          <li>Optional extra icon</li>
//          <li>Folder / Node Icon</li>
//          <li>Value for the cell</li>
//          </ul>
//			OVERRIDE in your subclass for a more complicated presentation
//
//      @param  value           (string)    value to display in the cell
//		@param	record			(TreeNode)	tree node in question	
//		@param	recordNum		(number)	number of that tree node
//      @param  fieldNum        (number)    number of the field being output as treeField
//
//		@return	(HTML)	HTML output for the cell
//      @visibility internal
//<
// iconPadding - padding between the folder open/close icon and text.
// Make this customizeable, but not exposed - very unlikely to be modified
iconPadding:3,
_$treeCellTemplate:[
    "<table cellpadding=0 cellspacing=0 class='",       // [0]
    ,                                                   // [1] - this.getCellStyle()
    "' style='",                                        // [2]
    ,                                                   // [3] - get.getCellCSSText()
    // use _$noStyleDoublingCSS to suppress any border / background image etc from the
    // cell style
    isc.Canvas._$noStyleDoublingCSS + "'><tr><td>",                // [4]
    ,                                                   // [5] - indentHTML
    "</td>",
    
    
    "<td>" + (isc.Browser.isSafari || isc.Browser.isIE ? "<nobr>" : ""), // [6]
    ,                                                   // [7] - opener icon HTML
    ,                                                   // [8] - 'extra' icon if there is one
    ,                                                   // [9] - icon for item (eg folder/file icon)
    (isc.Browser.isSafari ? "</nobr>" : "") + 
        "</td><td style='padding-left:",                // [10]
    ,                                                   // [11] - this.iconPadding
    "px;'>",                                            // [12]
    ,                                                   // [13] - NOBR or null
    ,                                                   // [14] - value
    "</td>",
    "</tr></table>"
],
_$semi:";",
getTreeCellValue : function (value, record, recordNum, fieldNum) {

    // This returns HTML to achieve
    //  - an indent equal to what level of the tree you're viewing
    //  - open / close icon
    //  - an optional additional icon
    //  - Folder / Record icon
    //  - title for the cell.

    // If passed a null record just return the value passed in.
    if (record == null) {
       return value;
    }
	// get the level of the node
	var level = this.data.getLevel(record);    
    var template = this._$treeCellTemplate;
    
    template[1] = this.getCellStyle(record, recordNum, fieldNum);
    template[3] = this.getCellCSSText(record, recordNum, fieldNum);

    // catch custom css text with no closing ";"
    if (template[3] != null && !template[3].endsWith(this._$semi)) template[3] += this._$semi;    
    
    template[5] = this.getIndentHTML(level, record);
    
    // Get the HTML for the icons and title from _getTreeCellTitleArray(), and fold them
    // into our template
    var titleCellTemplate = this._getTreeCellTitleArray(value, record, recordNum, true);
    for (var i = 0; i < 10; i++) {
        template[6+i] = titleCellTemplate[i];
    }
    return template.join(isc.emptyString);    
},

// _getTreeCellTitleArray() - helper method for getTreeCellValue() to return the
// "title" portion of the treeCell value - that is: the icons and the title, without
// any indent

_$treeCellTitleTemplate:[
    
    "<td>" + (isc.Browser.isSafari || isc.Browser.isIE ? "<nobr>" : ""), // [0]
    ,                                                   // [1] - opener icon HTML
    ,                                                   // [2] - 'extra' icon if there is one
    ,                                                   // [3] - icon for item (eg folder/file icon)
    (isc.Browser.isSafari ? "</nobr>" : "") + 
        "</td><td style='padding-left:",                // [4]
    ,                                                   // [5] - this.iconPadding
    "px;'>",                                            // [6]
    ,                                                   // [7] - NOBR or null
    ,                                                   // [8] - value
    "</td>"
],
_getTreeCellTitleArray : function (value, record, recordNum, showOpener) {
    
    var template = this._$treeCellTitleTemplate;
    if (showOpener) {
        // opener icon (or small indent)
        var openIcon = this.getOpenIcon(record),        
            openIconSize = this.openerIconSize || (this.showConnectors ? this.cellHeight : null),
            openerID = (recordNum != null ? this._openIconIDPrefix+recordNum : null);
            
        if (openIcon) {
            template[1] = this.getIconHTML(openIcon, openerID, openIconSize);
        } else {
            template[1] = this._indentHTML(openIconSize || this.iconSize);
        }
    } else template[1] = null;
    
    var extraIcon = this.getExtraIcon(record),
        extraIconID = (recordNum != null ? this._extraIconIDPrefix+recordNum : null), 
        icon = this.getIcon(record),
        iconID = (recordNum != null ? this._iconIDPrefix+recordNum : null);
        
    // extra icon if there is one
    template[2] = (extraIcon ? this.getIconHTML(extraIcon, extraIconID) : null);
    // folder or file icon
    template[3] = this.getIconHTML(icon, iconID, record.iconSize);
    
    template[5] = this.iconPadding;
    template[7] = this.wrapCells ? null : "<NOBR>"
    template[8] = value;
    return template;
},


// Override getCellValue() to return custom HTML for the tree-field
// Note: Developers are always advised to override formatCellValue rather than this method
// directly (which could lead to certain conflicts). 
getCellValue : function (record, rowNum, colNum, a, b, c, d) {
    var value = this.invokeSuper(isc.TreeGrid, "getCellValue", record, rowNum, colNum, a,b,c,d);
    if (colNum == this.getTreeFieldNum()) {
        value = this.getTreeCellValue(value, record, rowNum, colNum);
    }
    return value;
},

// overridden to create/clear draw cache
bodyDrawing : function (body,a,b,c,d) {
    this._drawCache = {};
    return this.invokeSuper(isc.TreeGrid, "bodyDrawing", a,b,c,d);
    delete this._drawCache;
},

//> @method TreeGrid.getNodeTitle()
//
// Returns the title to show for a node in the tree column.  If the field specifies the
// <code>name</code> attribute, then the current <code>node[field.name]</code> is returned.
// Otherwise, the result of calling +link{method:Tree.getTitle} on the node is called.
// <br><br>
// You can override this method to return a custom title for node titles in the tree column.
//
// @param node      (TreeNode)  The node for which the title is being requested.
// @param recordNum (Number)  The index of the node.
// @param field     (DSField) The field for which the title is being requested.
// 
// @return (HTML) the title to display.
//
// @see method:Tree.getTitle
//
// @visibility external
//<
getNodeTitle : function (record, recordNum, field) {

    
    if (field.name && field.name != this._titleField) {
        return this.getEditedRecord(recordNum)[field.name];
    }

    return this.data.getTitle(record);
},

//> @method TreeGrid.getTitleField()
// Method to return the fieldName which represents the "title" for records in this
// TreeGrid.<br>
// If <code>this.titleField</code> is explicitly specified for this treeGrid, respect it - 
// otherwise always return the tree-field (+link{TreeGrid.treeField}) for this grid.
// @return (string) fieldName for title field for this grid.
//<
getTitleField : function () {
    if (this.titleField != null) return this.titleField;
    return this.getFieldName(this.getTreeFieldNum());
},

//>	@method	treeGrid.getTreeFieldNum()	(A)
//		Return the number of the tree field for this treeGrid.
//
//		@return	(number)	Number for the tree node.
//<
getTreeFieldNum : function () { return this._treeFieldNum; },

//>	@method	treeGrid.getOpenAreaWidth()	(A)
//		
//		@param	node		(TreeNode)		tree node clicked on
//
//		@return	(number)	Return the width of the open area (relative to wherever the tree field is)
//<
getOpenAreaWidth : function (node) {
	return ((this.data.getLevel(node)-(this.showRoot?0:1)) * this.indentSize) + 
            this.getOpenerIconSize(node);
},

getOpenerIconSize : function (node) {
    return (this.openerIconSize || (this.showConnectors ? this.cellHeight : this.iconSize));
},

//>	@method	treeGrid.clickInOpenArea()	(A)
//			for a given click, was it in the open/close area or on the main part of the item
//			OVERRIDE in your subclasses for different open/close schemes
//		@param	node		(TreeNode)		tree node clicked on
//
//		@return	(boolean)		true == click was in open area, false == normal click
//<
clickInOpenArea : function (node) {
	if (!this.data.isFolder(node)) return false;
	
	// get some dimensions
	var treeFieldNum = this.getTreeFieldNum(),
        body = this.getFieldBody(treeFieldNum),
        localFieldNum = this.getLocalFieldNum(treeFieldNum),
		fieldLeft = body.getColumnLeft(localFieldNum),
		fieldWidth = body.getColumnWidth(localFieldNum),
		openAreaWidth = this.getOpenAreaWidth(node),
		x = body.getOffsetX()
	;

	// textDirection: switch based on drawing in left-to-right (default) or right-to-left order
	if (this.isRTL()) {
		var fieldRight = fieldLeft + fieldWidth;
		return x >= (fieldRight - openAreaWidth) && x <= fieldRight;
	} else {
		return x >= fieldLeft && x < fieldLeft + openAreaWidth;	
	}
},


//>	@method	treeGrid.getIndentHTML()	(A)
//			return the HTML to indent a record
//		@param	level		(number)	indent level (0 == root, 1 == first child, etc)
//  @param record (treeNode) record for which we're returning indent HTML
//
//		@return	(HTML)		HTML to indent the child
//<
getIndentHTML : function (level, record) {
    var drawLevel = level
	if (!this.showRoot) drawLevel--;
    // If showFullConnectors is true we need to write out vertical connector lines between 
    // ancestors who are siblings.
    
    if (this.showConnectors && this.showFullConnectors) {
        // assume the level passed in is correct
        //var level = this.data.getLevel(record),
        var levels = this.data._getFollowingSiblingLevels(record);
        // we don't care about the innermost level (connector written out as part of opener icon)
        levels.remove(level);        
        if (!this.showRoot) levels.remove(0);
        if (levels.length != 0) {
            if (!this._ancestorConnectorURL) {
                var connectorURL = isc.Img.urlForState(this.connectorImage, null, null,
                                                        "ancestor"),
                                    connectorHTML = this.getIconHTML(connectorURL, null,
                                                        this.cellHeight);
                this._ancestorConnectorHTML = connectorHTML;
            }
            var singleIndent = this._indentHTML(this.indentSize),
                indent = isc.StringBuffer.create(isc.emptyString)
            ;

            // explicit NOBR tag required in IE6 to ensure the indents don't wrap
            // when they run out of horizontal space 
            indent.append("<NOBR>");
            for (var i = (this.showRoot ? 0 : 1); i < level; i ++) {                
                if (levels.contains(i)) indent.append(this._ancestorConnectorHTML);
                else indent.append(singleIndent);
            }
            indent = indent.release();            
            return indent;
        }
    }    
    return this._indentHTML(drawLevel * this.indentSize);
},


_indentHTML : function (numPixels) {
	if (numPixels == 0) return isc.emptyString;

    var cache = isc.TreeGrid._indentHTMLCache;
    if (cache == null) cache = isc.TreeGrid._indentHTMLCache = {};

    if (cache[numPixels] == null) cache[numPixels] = isc.Canvas.spacerHTML(numPixels, 1);

    return cache[numPixels];
},

//>	@method	treeGrid.getOpenIcon()	(A)
// Get the appropriate open/close opener icon for a node.
//
// @param	node (TreeNode)	tree node in question
// @return	(URL)		URL for the icon to show the node's open state
//
// @visibility external
//<
getOpenIcon : function (record) {
    if (!this.data) return null;
	if (isc.isA.Number(record)) record = this.data.get(record);
    if (record == null) return null;
    
	// if the record has a specific openIcon, use that
	if (record.openIcon) {
		return record.openIcon;

	} else {

        var isFolder = this.data.isFolder(record),
            // non-folders can never have children, or be open
            hasChildren = isFolder,
            isOpen = isFolder,
            // does this node have adjacent siblings above or below, or is there a gap
            // between it's next sibling at the same level in either direction.
            start,
            end;
            
        if (isFolder) {
    		// If the folder doesn't have it's data fully loaded show the
            // folder as being closed
    		var loadState = this.data.getLoadState(record);
            if (loadState == isc.Tree.UNLOADED || 
                (loadState == isc.Tree.FOLDERS_LOADED && 
                 this.displayNodeType != isc.Tree.FOLDERS_ONLY)) 
            {
                hasChildren = true;
                isOpen = false;
            // If the data is loaded for the folder, use the data APIs to determine
            // whether this has children or not.
    		} else {
                hasChildren = this.data.hasChildren(record, this.displayNodeType);
                isOpen = hasChildren && this.data.isOpen(record);
            }

        }
        
        // if we're an open folder, showing sparse connectors, we have a gap below us
        if (isOpen && !this.showFullConnectors) end = true
        else {
            end = !this._shouldShowNextLine(record);
        }

        start = !this._shouldShowPreviousLine(record);

        // punt it over to getOpenerImageURL which will assmble the URL from the state info.
        return this.getOpenerImageURL(hasChildren, isOpen, start, end);
	}

	// return null as a signal that we don't need an open icon
	return null;
},

// _shouldShowPreviousLine
// Internal method - should we show a continuation connector line going up to the previous row 
// for some record?
// True if the previous row is a sibling of this record, or if this is the first record in
// some folder (so the previous row contains parent of this record)
_shouldShowPreviousLine : function (record) {
    var rowNum = this.data.indexOf(record);
    if (rowNum == 0) return false;
    
    // always show a previous line if we're showing "full connectors"
    if (this.showFullConnectors) return true;
    
    var previousRecord = this.getRecord(rowNum -1),
        parent = this.data.getParent(record);
    
    if (previousRecord == null) return false;
    return (parent == previousRecord || parent == this.data.getParent(previousRecord));
    
},

// _shouldShowNextLine
// Internal method - should we show a continuation connector line going down to the next row for
// some record?
// True only if the next row is a sibling of this record.
_shouldShowNextLine : function (record) {
    if (this.showFullConnectors) {
        var data = this.data,
            parent = data.getParent(record),
            children = data.getChildren(parent);
        return children.indexOf(record) != children.length-1;
    }
    var rowNum = this.data.indexOf(record),
        nextRecord = this.getRecord(rowNum +1);
    
    if (nextRecord == null) return false;
    return (this.data.getParent(record) == this.data.getParent(nextRecord));
},

//>	@method	treeGrid.getOpenerImageURL()	(A)
// Helper method called from getOpenIcon to retrieve the appropriate image URL string for
// the opener.
//
// @param	hasChildren (boolean)   Is the node in question a folder with children?
// @param   isOpen   (boolean)  Is the node an open folder?
// @param   startLine (boolean)   True if the previous row in the TreeGrid is not a sibling
//                                  or the parent of the node in question.  (Node effectively
//                                  starts a new hierachy continuation line).
// @param   endLine   (boolean)   True if the next row in the TreeGrid is not a sibling
//                                  of the node in question.  (Node effectively ends a
//                                  hierachy continuation line).
// @return	(string)		URL for the icon to show the node's state
//
// @visibility internal
//<
getOpenerImageURL : function (hasChildren, isOpen, startLine, endLine) {   

    // Assemble the appropriate filename based on the base filename for connector / opener
    // images
    // Do this once per TreeGrid since each TreeGrid can have a different tg.openerImage /
    // tg.connectorImage.
    
    if (!this._openerImageMap) {
        // Assemble the various file names based on the possible states of these
        // images - the "opened" state (opened, closed, or has no children)
        //        - the position within the parent folder state 
        //          (start, middle, end, separate)
        //         - RTL if appropriate.

        var img = this.openerImage;
            
        this._openerImageMap = {
            // use Img.urlForState
            // This handles splitting the base name into base + extension, and plugging in
            // the state name parameter (third parameter).

            // opener opened.  NOTE: doesn't switch with RTL, which is an assumption that it
            // will generally be a downward pointing glyph.
            opened:isc.Img.urlForState(img, null, null, "opened"),
            // opener closed
            closed:isc.Img.urlForState(img, null, null, (this.isRTL() ? "closed_rtl" : "closed")),
            // opener opening
            
            opening:isc.Img.urlForState(img, null, null, "opening")
        }
    }

    // generate connector / opener w/connector images
    if (this.showConnectors && !this._connectorImageMap) {
        // for connectors, we have start/end/middle for position on a line of connectors,
        // "single" for a node with no peers, and opener/leaf variations.
        var img = this.connectorImage,
            states = ["single", "start", "end", "middle", 
                      "opened_single", "opened_start", "opened_middle", "opened_end",
                      "closed_single", "closed_start", "closed_middle", "closed_end"],
            map = {},
            isRTL = this.isRTL(),
            rtl = "_rtl";
    
        for (var i = 0; i < states.length; i++) {
            var state = states[i],
                suffix = state;
            if (isRTL) suffix += rtl;
            map[state] = isc.Img.urlForState(img, null, null, suffix);
        }

        this._connectorImageMap = map;
    }
    
    if (this.showConnectors) {
        var imageMap = this._connectorImageMap;
    
        if (hasChildren) {
            if (isOpen) {
                
                if (!this.showFullConnectors) {
                    // if we're showing sparse connectors, no need to check for 'end'  - if it's 
                    // open this is always true.
                    if (startLine) return imageMap.opened_single;
                    return imageMap.opened_end;
                }
                if (startLine && endLine) return imageMap.opened_single;
                else if (startLine) return imageMap.opened_start;
                else if (endLine) return imageMap.opened_end;
                else return imageMap.opened_middle;
                
            } else {
                if (startLine && endLine) return imageMap.closed_single;
                if (startLine) return imageMap.closed_start;
                if (endLine) return imageMap.closed_end;
                return imageMap.closed_middle;
            }
        } else {
            // leaf
            if (startLine && endLine) return imageMap.single;
            if (startLine) return imageMap.start;
            if (endLine) return imageMap.end;
            return imageMap.middle;
        }
    } else {
        var imageMap = this._openerImageMap;
        // we don't return any image if we're not showing connectors, and this is not a folder
        // with children.
        if (!hasChildren) return null;
        
        if (isOpen) return imageMap.opened;
        return imageMap.closed;
    }
},

//>	@method	treeGrid.getExtraIcon()	(A)
// Get an additional icon to show between the open icon and folder/node icon for a particular 
// node.
//
// @param	node (TreeNode)	tree node in question
// @return	(URL)		URL for the extra icon (null if none required)
//
// @visibility external
//<
getExtraIcon : function (record) {
    // Default trees don't make use of this.
    return null;
},

//>	@method	treeGrid.getIcon()
// Get the appropriate icon for a node.
// <P>
// By default icons are derived from +link{folderIcon} and +link{nodeIcon}.
// Custom icons for individual nodes can be overriden by setting the +link{customIconProperty}
// on a node.
// <p>
// If you want to suppress icons altogether, provide an override of this method that simply
// returns null.
// <p> 
// Note that the full icon URL will be derived by applying +link{Canvas.getImgURL()} to the
// value returned from this method.
//
// @param	node (TreeNode)	tree node in question
// @return	(URL)		URL for icon to show for this node
// @visibility external
//<
getIcon : function (node, defaultState) {
    if (isc.isA.Number(node)) node = this.data.get(node);
    if (!node) return null;
    
    var icon = node[this.customIconProperty],
        customIcon = (icon != null),
        isFolder = this.data.isFolder(node);
  
    if (!customIcon) {
        if (isFolder) icon = this.folderIcon;
        else icon = this.nodeIcon;
    }
    var state;
    if (isFolder) {
        // Default folder icon is the 'closed' icon. This will be used for dragTrackers, etc
        // Note: check for the special _willAcceptDrop flag set by updateDropFolder() - when a
        // user hovers over a folder for a while, we spring it open, and that causes a redraw,
        // but the folder is not necessarily droppable.
        var isDrop = defaultState ? false : (this.lastDropFolder == node && node._willAcceptDrop),
            isOpen = defaultState ? false : !!this.data.isOpen(node);

        if (isDrop) {
            // backCompat - respect old dropIcon / folderDropImage if specified
            if (node.dropIcon != null) icon = node.dropIcon;
            else if (!customIcon && this.folderDropImage != null) icon = this.folderDropImage;
            else {
                var showDrop;
                if (customIcon) {
                    showDrop = node[this.customIconDropProperty];
                    if (showDrop == null) showDrop = this.showCustomIconDrop;
                } else { 
                    showDrop = this.showDropIcons;
                }
                if (showDrop) state = this.dropIconSuffix;
            }
        } else if (isOpen) {
                
            // backCompat - respect old openIcon / folderOpenImage if specified
            if (node.openedIcon != null) icon = node.openedIcon;
            else if (!customIcon && this.folderOpenImage != null) icon = this.folderOpenImage;
            // Don't override already set drop state
            else {
                var showOpen;
                if (customIcon) {
                    showOpen = node[this.customIconOpenProperty];
                    if (showOpen == null) showOpen = this.showCustomIconOpen;
                } else {
                    showOpen = this.showOpenIcons;
                }
                if (showOpen) state = this.openIconSuffix;                
                
                else if (!customIcon) state = this.closedIconSuffix;
            }
        }  else {
            
            // Respect old 'folderClosedImage' if specified
            // Otherwise - if the icon is not custom, append "_closed" state
            
            if (!customIcon) {
                if (this.folderClosedImage) icon = this.folderClosedImage;
                else state = this.closedIconSuffix;
            }
        }
    // not a folder:
    } else {
        // Pick up the old 'fileImage' for back compat, if specified.
        if (!customIcon && this.fileImage) icon = this.fileImage;
    }
    return isc.Img.urlForState(icon, false, false, state);
},

// helper method - caches generated image templates on a per-draw basis for faster html generation.
_$absMiddle : "absmiddle",
_imgParams : {},
getIconHTML : function (icon, iconID, iconSize) {
    if (icon == null) return isc.emptyString;
    
    if (iconSize == null) iconSize = this.iconSize;

    // make sure the iconHTML cache exists
    var cache = this._drawCache.iconHTML;
    if (cache == null) cache = this._drawCache.iconHTML = {};

    // if not in cache, generate and store - keyed by the image src
    if (cache[icon] == null) {
        
        var imgParams = this._imgParams;
        imgParams.src = icon;
        imgParams.width = imgParams.height = iconSize;
        imgParams.name = iconID;
        imgParams.align = this._$absMiddle;
        cache[icon] = this._getImgHTMLTemplate(imgParams);
    }

    // now there's guaranteed to be a cached version - grab it
    var template = cache[icon];

    // Note: We need to update the image ID for each icon - this is in the 14'th slot in the
    // array of strings used as a template (see Canvas.imgHTML())
    template[14] = iconID;
    
    return template.join(isc._emptyString);
},


//>	@method	treeGrid.setRowIcon()	(A)
// Set the icon for a particular record to a specified URL (relative to Page.imgDir + this.imgDir
//
//		@param	record		(TreeNode)	tree node
//		@param	URL		(URL)		URL for the record icon
//<
setRowIcon : function (record, URL) {

	// normalize the record from a number if necessary
	if (!isc.isA.Number(record)) record = this.data.indexOf(record);
    // set the image
    
    if (record != -1 && this.getIcon(record) != null) {
        this.setImage(this._iconIDPrefix + record, URL);
    }
},

//> @method treeGrid.setNodeIcon() 
// Set the icon for a particular treenode to a specified URL
//
//		@param node		(TreeNode) tree node
//		@param icon		(SCImgUrl) path to the resource
//		@group treeIcons
//		@visibility external
//<		
setNodeIcon : function (node, icon) {
	//make the change persist across redraws 
	node[this.customIconProperty] = icon;
	//efficiently refresh the image
	this.setImage(this._iconIDPrefix + this.getRecordIndex(node), icon);
},

// -------------------
// Printing

getPrintHTML : function (printProperties, callback) {
    var expand = this.printExpandTree;
    if (expand == null) expand = printProperties ? printProperties.expandTrees : null;
    
    if (expand && this.data) {
        if (isc.ResultTree && isc.isA.ResultTree(this.data) && this.data.loadDataOnDemand) {
            this.logWarn("Printing TreeGrid with option to expand folders on print not supported " +
                            "for load on demand trees.");
        } else {
            this.data.openAll();
        }
    }
    return this.Super("getPrintHTML", arguments);
}


});



// Register "stringMethods" for this class
isc.TreeGrid.registerStringMethods({
//    folderDropMove:"viewer,folder,childIndex,child,position",

    //> @method treeGrid.folderOpened()
    //
    // This method is called when a folder is opened either via the user manipulating the
    // expand/collapse control in the UI or via +link{TreeGrid.openFolder()}.  You can return
    // <code>false</code> to cancel the open.
    //
    // @param node (TreeNode) the folder (record) that is being opened
    // 
    // @return (boolean) false to cancel the open, true to all it to proceed
    //
    // @visibility external
    //<
    folderOpened : "node",

    //> @method treeGrid.folderClosed()
    //
    // This method is called when a folder is closed either via the user manipulating the
    // expand/collapse control in the UI or via +link{TreeGrid.closeFolder()}.  You can return
    // <code>false</code> to cancel the close.
    //
    // @param node (TreeNode) the folder (record) that is being closed
    // 
    // @return (boolean) false to cancel the close, true to all it to proceed
    //
    // @visibility external
    //<
    folderClosed : "node",

    //> @method treeGrid.folderClick()
    //
    // This method is called when a folder record is clicked on.
    //
    // @param viewer (TreeGrid) The TreeGrid on which folderClick() occurred.
    // @param folder (TreeNode) The folder (record) that was clicked
    // @param recordNum (number) Index of the row where the click occurred.
    // 
    // @see treeGrid.nodeClick()
    //
    // @visibility external
    //<
    folderClick : "viewer,folder,recordNum",

    //> @method treeGrid.leafClick()
    //
    // This method is called when a leaf record is clicked on.
    //
    // @param viewer (TreeGrid) The TreeGrid on which leafClick() occurred.
    // @param leaf (TreeNode) The leaf (record) that was clicked
    // @param recordNum (number) Index of the row where the click occurred.
    // 
    // @see treeGrid.nodeClick()
    //
    // @visibility external
    //<
    leafClick : "viewer,leaf,recordNum",

    //> @method treeGrid.nodeClick()
    //
    // This method is called when a leaf or folder record is clicked on.  Note that if you set
    // up a callback for <code>nodeClick()</code> and e.g. +link{treeGrid.leafClick()}, then
    // both will fire (in that order) if a leaf is clicked on.
    //
    // @param viewer (TreeGrid) The TreeGrid on which leafClick() occurred.
    // @param node (TreeNode) The node (record) that was clicked
    // @param recordNum (number) Index of the row where the click occurred.
    // 
    // @see treeGrid.folderClick()
    // @see treeGrid.leafClick()
    //
    // @visibility external
    // @example treeDropEvents
    //<
    nodeClick : "viewer,node,recordNum",

    //> @method treeGrid.folderContextClick()
    //
    // This method is called when a context click occurs on a folder record.
    //
    // @param viewer (TreeGrid) The TreeGrid on which the contexclick occurred.
    // @param folder (TreeNode) The folder (record) on which the contextclick occurred.
    // @param recordNum (number) Index of the row where the contextclick occurred.
    //
    // @return (boolean) whether to cancel the event
    //
    // @see treeGrid.nodeContextClick();
    //
    // @visibility external
    //<
    folderContextClick : "viewer,folder,recordNum",

    //> @method treeGrid.leafContextClick()
    //
    // This method is called when a context click occurs on a leaf record.
    //
    // @param viewer (TreeGrid) The TreeGrid on which the contexclick occurred.
    // @param leaf (TreeNode) The leaf (record) on which the contextclick occurred.
    // @param recordNum (number) Index of the row where the contextclick occurred.
    //
    // @return (boolean) whether to cancel the event
    //
    // @see treeGrid.nodeContextClick();
    //
    // @visibility external
    //<
    leafContextClick : "viewer,leaf,recordNum",

    //> @method treeGrid.nodeContextClick()
    //
    // This method is called when a context click occurs on a leaf or folder record.  Note that
    // if you set up a callback for <code>nodeContextClick()</code> and
    // e.g. +link{treeGrid.leafContextClick}, then both will fire (in that order) if a leaf
    // is contextclicked - unless <code>nodeContextClick()</code> returns false, in which case
    // no further contextClick callbacks will be called.
    //
    // @param viewer (TreeGrid) The TreeGrid on which the contexclick occurred.
    // @param node (TreeNode) The node (record) on which the contextclick occurred.
    // @param recordNum (number) Index of the row where the contextclick occurred.
    //
    // @return (boolean) whether to cancel the event
    //
    // @see treeGrid.folderContextClick();
    // @see treeGrid.leafContextClick();
    //
    // @visibility external
    //<
	nodeContextClick : "viewer,node,recordNum"
});


