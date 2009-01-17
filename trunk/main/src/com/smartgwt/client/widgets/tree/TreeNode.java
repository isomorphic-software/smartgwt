/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.tree;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * Every node in the tree is represented by TreeNode object which is an object literal with a set or properties that configure the node. <p> When a Tree is supplied as {@link com.smartgwt.client.widgets.tree.TreeGrid#getData data} to {@link com.smartgwt.client.widgets.tree.TreeGrid}, you can also set properties from ${isc.DocUtils.linkForRef('object:ListGridRecord')} on the TreeNode (e.g. setting {@link com.smartgwt.client.widgets.grid.ListGridRecord#getEnabled enabled}:<code>false</code> on the node).

    */
public class TreeNode extends ListGridRecord {

    public static TreeNode getOrCreateRef(JavaScriptObject jsObj) {
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (TreeNode) obj;
        } else {
            return new TreeNode(jsObj);
        }
    }


    public TreeNode(){
        
    }

    public TreeNode(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Affects the visual style and interactivity of the record.  If set to <code>false</code> the record (row in a {@link com.smartgwt.client.widgets.grid.ListGrid} or {@link com.smartgwt.client.widgets.tree.TreeGrid}) will not highlight when the mouse moves over it, nor will it respond to mouse clicks.
    *
    * @param enabled enabled Default value is null
    */
    public void setEnabled(Boolean enabled) {
        setAttribute("enabled", enabled);
    }
    /**
     * Affects the visual style and interactivity of the record.  If set to <code>false</code> the record (row in a {@link com.smartgwt.client.widgets.grid.ListGrid} or {@link com.smartgwt.client.widgets.tree.TreeGrid}) will not highlight when the mouse moves over it, nor will it respond to mouse clicks.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEnabled()  {
        return getAttributeAsBoolean("enabled");
    }

    /**
    * Governs whether this node can be dragged. Only has an effect if this node is displayed in a {@link com.smartgwt.client.widgets.tree.TreeGrid} where {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanDragRecordsOut canDragRecordsOut}, {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords canReorderRecords} or {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReparentNodes canReparentNodes} is <code>true</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canDrag canDrag Default value is null
    */
    public void setCanDrag(Boolean canDrag) {
        setAttribute("canDrag", canDrag);
    }
    /**
     * Governs whether this node can be dragged. Only has an effect if this node is displayed in a {@link com.smartgwt.client.widgets.tree.TreeGrid} where {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanDragRecordsOut canDragRecordsOut}, {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords canReorderRecords} or {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReparentNodes canReparentNodes} is <code>true</code>
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDrag()  {
        return getAttributeAsBoolean("canDrag");
    }

    /**
    * Governs whether dragged data (typicaly other <code>treeNode</code>s) may be dropped over this node. Only has an effect if this node is displayed in a {@link com.smartgwt.client.widgets.tree.TreeGrid} where {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanAcceptDroppedRecords canAcceptDroppedRecords}, {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords canReorderRecords} or  {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReparentNodes canReparentNodes} is true.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canAcceptDrop canAcceptDrop Default value is null
    */
    public void setCanAcceptDrop(Boolean canAcceptDrop) {
        setAttribute("canAcceptDrop", canAcceptDrop);
    }
    /**
     * Governs whether dragged data (typicaly other <code>treeNode</code>s) may be dropped over this node. Only has an effect if this node is displayed in a {@link com.smartgwt.client.widgets.tree.TreeGrid} where {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanAcceptDroppedRecords canAcceptDroppedRecords}, {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords canReorderRecords} or  {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReparentNodes canReparentNodes} is true.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanAcceptDrop()  {
        return getAttributeAsBoolean("canAcceptDrop");
    }

    /**
    * The <code>name</code> property of a TreeNode is used for assembling a unique path (see {@link com.smartgwt.client.widgets.tree.Tree#getPath}) to the node.  A node's path is the concatenation of all parent names with the {@link com.smartgwt.client.widgets.tree.Tree#getPathDelim pathDelim}. The path can then be used to find any node in the tree using {@link com.smartgwt.client.widgets.tree.Tree#find}. <p> If the nameProperty is not set on a given node, {@link com.smartgwt.client.widgets.tree.Tree#getName} and {@link com.smartgwt.client.widgets.tree.Tree#getPath} will auto-generate a unique name for you. <p> This property  is also used as the default title for the node (see {@link com.smartgwt.client.widgets.tree.Tree#getTitle}) if {@link com.smartgwt.client.widgets.tree.TreeNode#getTitle title} is not specified. <p> Note: the name of this property can be changed by setting {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty}.
    *
    * @param name name Default value is null, but see below
    */
    public void setName(String name) {
        setAttribute("name", name);
    }
    /**
     * The <code>name</code> property of a TreeNode is used for assembling a unique path (see {@link com.smartgwt.client.widgets.tree.Tree#getPath}) to the node.  A node's path is the concatenation of all parent names with the {@link com.smartgwt.client.widgets.tree.Tree#getPathDelim pathDelim}. The path can then be used to find any node in the tree using {@link com.smartgwt.client.widgets.tree.Tree#find}. <p> If the nameProperty is not set on a given node, {@link com.smartgwt.client.widgets.tree.Tree#getName} and {@link com.smartgwt.client.widgets.tree.Tree#getPath} will auto-generate a unique name for you. <p> This property  is also used as the default title for the node (see {@link com.smartgwt.client.widgets.tree.Tree#getTitle}) if {@link com.smartgwt.client.widgets.tree.TreeNode#getTitle title} is not specified. <p> Note: the name of this property can be changed by setting {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty nameProperty}.
     *
     *
     * @return String
     *
     */
    public String getName()  {
        return getAttributeAsString("name");
    }

    /**
    * The title of the node as it should appear next to the node icon in the {@link com.smartgwt.client.widgets.tree.Tree}.  If left unset, the value of {@link com.smartgwt.client.widgets.tree.TreeNode#getName name} is used by default.  See the description in {@link com.smartgwt.client.widgets.tree.Tree#getTitle} for full details. <p> Note: the name of this property can be changed by setting {@link com.smartgwt.client.widgets.tree.Tree#getTitleProperty titleProperty}.
    *
    * @param title title Default value is null
    */
    public void setTitle(String title) {
        setAttribute("title", title);
    }
    /**
     * The title of the node as it should appear next to the node icon in the {@link com.smartgwt.client.widgets.tree.Tree}.  If left unset, the value of {@link com.smartgwt.client.widgets.tree.TreeNode#getName name} is used by default.  See the description in {@link com.smartgwt.client.widgets.tree.Tree#getTitle} for full details. <p> Note: the name of this property can be changed by setting {@link com.smartgwt.client.widgets.tree.Tree#getTitleProperty titleProperty}.
     *
     *
     * @return String
     *
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************




    /**
     * Constructor
     *
     * @param name the name
     */
    public TreeNode(String name) {
        setName(name);
    }

    /**
     * Constructor
     *
     * @param name     the name
     * @param children the children nodes
     */
    public TreeNode(String name, TreeNode... children) {
        setName(name);
        setChildren(children);
    }

    /**
     * For trees with {@link com.smartgwt.client.widgets.tree.Tree#getModelType modelType} "parent", this property
     * specifies the unique ID of this node. The unique ID of a node, together with the unique ID of its parent (see
     * {@link com.smartgwt.client.widgets.tree.TreeNode#getParentId parentId}) is used by {@link
     * com.smartgwt.client.widgets.tree.Tree#linkNodes} to link a list of nodes into a tree. <p> Note: the name of this
     * property can be changed by setting {@link com.smartgwt.client.widgets.tree.Tree#getIdField idField}.
     *
     * @param id id Default value is null
     */
    public void setID(String id) {
        setAttribute("id", id);
    }

    /**
     * For trees with modelType "parent", this property specifies unique parent ID of this node. The unique ID of a
     * node, together with the unique ID of its parent is used by {@link com.smartgwt.client.widgets.tree.Tree#linkNodes}
     * to link a list of nodes into a tree. <p> Note: the name of this property can be changed by setting {@link
     * com.smartgwt.client.widgets.tree.Tree#getParentIdField parentIdField}.
     *
     * @param parentId parentId Default value is null
     */
    public void setParentID(String parentID) {
        setAttribute("parentId", parentID);
    }

    /**
     * Set to <code>true</code> to explicitly mark this node as a folder.  See {@link
     * com.smartgwt.client.widgets.tree.Tree#isFolder} for a full description of how the {@link
     * com.smartgwt.client.widgets.tree.Tree} determines whether a node is a folder or not. <p> Note: the name of this
     * property can be changed by setting {@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}.
     *
     * @param isFolder isFolder Default value is null
     */
    public void setIsFolder(boolean isFolder) {
        setAttribute("isFolder", isFolder);
    }

    /**
     * For trees with the modelType "children", this property specifies the children of this TreeNode. <p> Note: the
     * name of this property can be changed by setting {@link com.smartgwt.client.widgets.tree.Tree#getChildrenProperty
     * childrenProperty}
     *
     * @param children children Default value is null
     */
    public void setChildren(TreeNode[] children) {
        setAttribute("children", children);
    }

    //TODO getChildren

}




