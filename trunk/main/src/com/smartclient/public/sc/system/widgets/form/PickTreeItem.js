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

 

// Class will not work without the ListGrid
if (isc.ListGrid) {



//>	@class	PickTreeItem
// FormItem that allows picking a value from a hierarchical data model.
//
// @treeLocation Client Reference/Forms/Form Items
// @visibility external
// @example pickTree
//<
isc.ClassFactory.defineClass("PickTreeItem", "CanvasItem");

isc.PickTreeItem.addClassProperties({
    // create a single 'itemSelected' method to be applied to our menu buttons.
    // (fired in the scope of the button
    _itemSelected : function (item) {
        return this.canvasItem._itemSelected(item);
    },
    
    // getTitle() method for our TreeMenuButton - overridden to handle the case where the
    // form item value represents an as-yet-unloaded node (so 'getTitle()' is not available).
    _getButtonTitle : function () {
        var selection = this.getSelectedItem();
        if (selection == null) {
            // If a value is selected in the item, but we don't have the same node selected in
            // this TreeMenuButton widget, check the static valueMap for a title to display.
            var item = this.canvasItem, value = this.canvasItem.getValue();
            if (value != null) return item.mapValueToDisplay(value);
        }
        return this.Super("getTitle", arguments);
    },
    
    // If this item's menu is databound, and loadDataOnDemand is false, this method will be
    // fired when the entire tree is loaded (happens around init time).
    // We want to ensure that any value we have is associated with the appropriate node at this
    // point. This allows us to call setSelectedItem() on the TreeMenuButton, which hilights
    // the path to the node for our selected value.
    
    _treeDataLoaded : function () {
        var item = this.canvasItem;
        item.setValue(item.getValue());
    }

});

isc.PickTreeItem.addProperties({

     // Override canFocus -- even though buttons have no data element, they can accept focus.
    canFocus:true,
    
    // We will be saving out the selected values
    shouldSaveValue:true,
    
    // Class level defaults to apply to the button we create.
    // Picked up via the addAutoChild mechanism.
    
    buttonDefaults : {
        height:19
    },
    
    // Note: we use the 'addAutoChild()' method to create our canvas, so we can specify
    // properties / defaults via "buttonDefaults" and "buttonProperties".
    
    //> @attr PickTreeItem.dataSource (datasource : null : IRA)
    // If specified, the tree of possible options will be derived from the dataSource as a
    // ResultTree, rather than using this.valueTree.  Options can be loaded on demand or up
    // front according tp +link{attr:PickTreeItem.loadDataOnDemand}.
    // @visibility external
    //<

    //> @attr PickTreeItem.valueTree  (tree : null : IR)
    // A +link{class:Tree} of options from which the user can select.
    // @visibility external
    // @example pickTree
    //<
    
    //> @attr PickTreeItem.loadDataOnDemand   (boolean : null : IRA)
    // If this is a databound item, should the load our set of possible options be loaded
    // on demand (as submenus are displayed), or upfront?
    // @visibility external
    //<
    
    //loadDataOnDemand : false,
    
    //> @attr   PickTreeItem.displayField   (string : null : IR) 
    // Specifies an alternative field from which display values should be retrieved for this
    // item.<br>
    // If this item is not databound (+link{attr:PickTreeItem.dataSource} is unset), this is
    // implemented by picking up the value of the specified field from the
    // +link{attr:valueTree}.<br>
    // Otherwise this item will attempt to map its underlying value to a display value
    // by retrieving a record from the +link{attr:PickTreeItem.dataSource} where the 
    // +link{PickTreeItem.valueField} matches this item's value, and displaying the 
    // <code>displayField</code> value from that record.<br>
    // @visibility external
    //<

    //> @attr PickTreeItem.valueField (string : null : IR)
    // Which field in the tree-data should be returned as this item's value?
    // If unspecified, the path will be used
    // @visibility external
    // @example pickTree
    //<
    

    //> @attr PickTreeItem.emptyMenuMessage   (string : "No items to display" : IRA)
    // This message will be displayed as a singled, disabled option in any empty menu/submenu
    // created from this item's data tree.
    // @visibility external
    // @example pickTree
    //<
    emptyMenuMessage:"No items to display"
    
    //> @attr PickTreeItem.canSelectParentItems (boolean : null : IRW)
    // @include menu.canSelectParentItems
    // @group selection
    // @visibility external
    // @example treesEditing
    //<
});

isc.PickTreeItem.addMethods({
    init : function () {
        this.Super("init", arguments);

        if (this.dataSource == null && this.valueTree == null) 
            this.logWarn("This form item requires a 'valueTree'.");

        
    },
    
    // Override _createCanvas to set up a TreeMenuButton as this item's canvas
    _createCanvas : function () {
    
        var dynamicButtonProperties = {
                // override getTitle to check for the case where the form item value represents
                // a currently unselected node.
                getTitle : isc.PickTreeItem._getButtonTitle,
                
                canFocus : this._canFocus(),
                disabled : this.isDisabled(),
                
                // Allow the tree of options to be specified as item.dataSource or item.data.
                dataSource : this.dataSource,
                data : this.valueTree,
                
                // canSelectParentItems should be inherited from this item's setting
                canSelectParentItems : this.canSelectParentItems,
                
                itemSelected : isc.PickTreeItem._itemSelected,
                
                emptyMenuMessage:this.emptyMenuMessage,
                
                // If databound, should we load the entire set of data up-front?
                loadDataOnDemand : this.loadDataOnDemand,
                treeDataLoaded : isc.PickTreeItem._treeDataLoaded,
                
                // setting the displayField on the button ensures it gets picked up by
                // SelectionTreeMenu.getItemTitle()
                displayField:this.displayField
            };
        
        // Use 'addAutoChild' - this will handle applying the various levels of defaults
        this.canvas = this.addAutoChild("button", dynamicButtonProperties, 
                                        isc.TreeMenuButton, this.container);
        // set autoDestroy to true so the button gets destroyed when this item gets destroyed
        this.autoDestroy = true;                                        
        this.Super("_createCanvas", arguments);
    },

   
    // Values management.
    // We're selecting nodes from a tree data structure.
    // The method 'getSelectedNode()' is available to return a pointer to the actual selected
    // node object, but this is not the 'value' of this form item.
    // If this.valueField is specified, the value of this item will be node[this.valueField].
    // Otherwise:
    // - if this is a databound tree, the value will be the primary key of this node (assumed
    //   to have a single primary key)
    // - if this is a client-only tree, and the modelType of the tree is "parent", the 
    //   idProperty for the selected node will be returned as item's value.
    // - If the modelType is not parent, the path of the node will be returned.
    
    // User selection of value will triger this._itemSelected();
    _itemSelected : function (item) {
        //!DONTCOMBINE
        var value = this._mapNodeToValue(item);
        // updateValue() will store the new value
        // If the change handler didn't return false, also keep a pointer to the node.
        if (this._updateValue(value)) this._selectedNode = item;
    },

    // Given a selected node, what is the 'value' that we'll pass back to a 'getValue()' call
    // (same value should work in a 'setValue()' call to select the node in question).
    _mapNodeToValue : function (node) {

        if (this._usePathAsId()) return this.valueTree.getPath(node);
        
        return node[this._getValueFieldName()];
    },
    
    // _usePathAsId - if we're using a tree with the relationships specified as paths, 
    // we use the paths as IDs by default.
    _usePathAsId : function () {
        return (!this.valueField && this.valueTree && (this.valueTree.modelType != "parent"));
    },

    // If we're using a field-name property on the node as a unique node ID, what is it?    
    _getValueFieldName : function () {
        var fieldName = this.valueField;
        if (!fieldName) {
            fieldName = this.valueTree ? this.valueTree.idField 
                                       : this._getPrimaryKeyFieldName();
        }
        
        return fieldName;       
    },
    
    // For databound items, this method determines the primary key fieldName (used to determine
    // the 'value' property based on the selected node).
    _getPrimaryKeyFieldName : function () {
        
        if (!this.dataSource) return null;

        if (!this._pkfield) {
            
            var ds = isc.DataSource.getDataSource(this.dataSource),
                pkArray = ds.getPrimaryKeyFieldNames(),
                pk = isc.isAn.Array(pkArray) ? pkArray[0] : pkArray;
            
            if (isc.isAn.Array(pkArray) && pkArray.length > 1) {
                this.logWarn("Multiple primary key fields not supported by PickTreeItem - using '" +
                             pk + "' as single primary key field");
            }
            
            this._pkfield = pk;
        }        
        
        return this._pkfield;
    },

    
    // No need for override to 'getValue()' - update value will have already saved out the 
    // selected value
    
    // Special 'getSelectedNode()' method to give us a pointer to the selected object
    //>@method  PickTreeItem.getSelectedNode()  
    //  Returns a pointer to the currently selected node within this item's tree   
    //<
    getSelectedNode : function () {
        // this property is set up when selection changes (or on setValue() calls)
        return this._selectedNode;
    },
    
    
    // setValue - override to how the selected node in the button title and the path in the
    // menus.
    
    setValue : function (newValue) {
        this.Super("setValue", arguments);

        var node = this._getNode(this.getValue());
        // remember the selected node (or null if appropriate)
        this._selectedNode = node;
        
        if (this.canvas) {
            // If we couldn't find a node, this will update the button title to reflect either 
            // the empty message, or the valuemapped version of this item's value.
            this.canvas.setSelectedItem(node);
        }
    },
    
    // Given a specified 'value' for this item, find the approprate node in our data tree.
    _getNode : function (value) {
        if (!value) return null;
        
        // If we have a dataSource we're going to be looking up the item in the
        // ResultTree derived from the dataSource - available as this.canvas.getTree().
        var tree = (this.dataSource ? this.canvas.getTree() : this.valueTree);
        if (this._usePathAsId()) return this.valueTree.find(value);
        
        return tree.find(this._getValueFieldName(), value);

    }

});

}
