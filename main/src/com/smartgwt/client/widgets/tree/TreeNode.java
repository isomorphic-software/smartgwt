/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
package com.smartgwt.client.widgets.tree;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Every node in the tree is represented by a TreeNode object which is an object literal with a set of properties that
 * configure the node. <p> When a Tree is supplied as {@link com.smartgwt.client.widgets.tree.TreeGrid#getData
 * TreeGrid.data} to {@link com.smartgwt.client.widgets.tree.TreeGrid}, you can also set properties from {@link
 * com.smartgwt.client.widgets.grid.ListGridRecord} on the TreeNode (e.g. setting {@link
 * com.smartgwt.client.widgets.grid.ListGridRecord#getEnabled ListGridRecord.enabled}:<code>false</code> on the node).
 */
@BeanFactory.FrameworkClass
public class TreeNode extends ListGridRecord {

    public static TreeNode getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof TreeNode) {
            existingObj.setJsObj(jsObj);
            return (TreeNode)existingObj;
        } else

        {
            return new TreeNode(jsObj);
        }
    }
        


    public TreeNode(){
        
    }

    public TreeNode(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Governs whether dragged data (typically other <code>treeNode</code>s) may be dropped over this node. Only has an effect
     * if this node is displayed in a {@link com.smartgwt.client.widgets.tree.TreeGrid} where {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCanAcceptDroppedRecords TreeGrid.canAcceptDroppedRecords}, {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords TreeGrid.canReorderRecords} or  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCanReparentNodes TreeGrid.canReparentNodes} is true.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canAcceptDrop New canAcceptDrop value. Default value is null
     */
    public void setCanAcceptDrop(Boolean canAcceptDrop) {
        setAttribute("canAcceptDrop", canAcceptDrop);
    }

    /**
     * Governs whether dragged data (typically other <code>treeNode</code>s) may be dropped over this node. Only has an effect
     * if this node is displayed in a {@link com.smartgwt.client.widgets.tree.TreeGrid} where {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCanAcceptDroppedRecords TreeGrid.canAcceptDroppedRecords}, {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords TreeGrid.canReorderRecords} or  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCanReparentNodes TreeGrid.canReparentNodes} is true.
     *
     * @return Current canAcceptDrop value. Default value is null
     */
    public Boolean getCanAcceptDrop()  {
        return getAttributeAsBoolean("canAcceptDrop", true);
    }
    

    /**
     * Governs whether this node can be dragged. Only has an effect if this node is displayed in a {@link
     * com.smartgwt.client.widgets.tree.TreeGrid} where {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanDragRecordsOut
     * TreeGrid.canDragRecordsOut}, {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords
     * TreeGrid.canReorderRecords} or {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReparentNodes
     * TreeGrid.canReparentNodes} is <code>true</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canDrag New canDrag value. Default value is null
     */
    public void setCanDrag(Boolean canDrag) {
        setAttribute("canDrag", canDrag);
    }

    /**
     * Governs whether this node can be dragged. Only has an effect if this node is displayed in a {@link
     * com.smartgwt.client.widgets.tree.TreeGrid} where {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanDragRecordsOut
     * TreeGrid.canDragRecordsOut}, {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords
     * TreeGrid.canReorderRecords} or {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReparentNodes
     * TreeGrid.canReparentNodes} is <code>true</code>.
     *
     * @return Current canDrag value. Default value is null
     */
    public Boolean getCanDrag()  {
        return getAttributeAsBoolean("canDrag", true);
    }
    
    

    /**
     * Default property name denoting whether this record is enabled. Property name may be modified for some grid via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordEnabledProperty ListGrid.recordEnabledProperty}.
     *
     * @param enabled New enabled value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_disabled_rows" target="examples">Disabled rows Example</a>
     */
    public void setEnabled(Boolean enabled) {
        setAttribute("enabled", enabled);
    }

    /**
     * Default property name denoting whether this record is enabled. Property name may be modified for some grid via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordEnabledProperty ListGrid.recordEnabledProperty}.
     *
     * @return Current enabled value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_disabled_rows" target="examples">Disabled rows Example</a>
     */
    public Boolean getEnabled()  {
        return getAttributeAsBoolean("enabled", true);
    }
    

    /**
     * This Property allows the developer to customize the icon displayed next to a node. Set <code>node.icon</code> to the URL
     * of the desired icon to display and it will be shown instead of the standard {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon TreeGrid.nodeIcon} for this node.<br> Note that if {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon showOpenIcon} and/or {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowDropIcon showDropIcon}  is true for this node, customized icons for
     * folder nodes will be appended with the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix
     * TreeGrid.openIconSuffix} or {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix TreeGrid.dropIconSuffix}
     * suffixes on state change  as with the standard {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon
     * TreeGrid.folderIcon} for this treeGrid.  Also note that for custom folder icons, the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix TreeGrid.closedIconSuffix} will never be appended. <P>You
     * can change the name of this property by setting  {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty
     * TreeGrid.customIconProperty}.
     *
     * @param icon New icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon);
    }

    /**
     * This Property allows the developer to customize the icon displayed next to a node. Set <code>node.icon</code> to the URL
     * of the desired icon to display and it will be shown instead of the standard {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon TreeGrid.nodeIcon} for this node.<br> Note that if {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon showOpenIcon} and/or {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowDropIcon showDropIcon}  is true for this node, customized icons for
     * folder nodes will be appended with the  {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix
     * TreeGrid.openIconSuffix} or {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix TreeGrid.dropIconSuffix}
     * suffixes on state change  as with the standard {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon
     * TreeGrid.folderIcon} for this treeGrid.  Also note that for custom folder icons, the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix TreeGrid.closedIconSuffix} will never be appended. <P>You
     * can change the name of this property by setting  {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty
     * TreeGrid.customIconProperty}.
     *
     * @return Current icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * Developers may customize the padding between the folder or leaf node icon and the text content of the tree cell for
     * individual nodes. <P> You can change the name of this property by setting {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getIconPaddingProperty TreeGrid.iconPaddingProperty}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param iconPadding New iconPadding value. Default value is null
     */
    public void setIconPadding(Integer iconPadding) {
        setAttribute("iconPadding", iconPadding);
    }

    /**
     * Developers may customize the padding between the folder or leaf node icon and the text content of the tree cell for
     * individual nodes. <P> You can change the name of this property by setting {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getIconPaddingProperty TreeGrid.iconPaddingProperty}
     *
     * @return Current iconPadding value. Default value is null
     */
    public Integer getIconPadding()  {
        return getAttributeAsInt("iconPadding");
    }
    
    
    

    /**
     * Provides a name for the node that is unique among its immediate siblings, thus allowing a unique path to be used to
     * identify the node, similar to a file system.  See {@link com.smartgwt.client.widgets.tree.Tree#getPath Tree.getPath()}.
     * <p> If the nameProperty is not set on a given node, the {@link com.smartgwt.client.widgets.tree.TreeNode#getId id} will
     * be used instead.  If this is also missing, {@link com.smartgwt.client.widgets.tree.Tree#getName Tree.getName()} and
     * {@link com.smartgwt.client.widgets.tree.Tree#getPath Tree.getPath()} will auto-generate a unique name for you.  Thus
     * names are not required, but if the dataset you are using already has usable names for each node, using them can make
     * APIs such as {@link com.smartgwt.client.widgets.tree.Tree#find Tree.find()} more useful.  Alternatively, if your dataset
     * has unique ids consider providing those as {@link com.smartgwt.client.widgets.tree.TreeNode#getId id}. <P> If a value
     * provided for the nameProperty of a node (e.g. node.name) is not a string, it will be converted to a string by the Tree
     * via ""+value. <p> This property is also used as the default title for the node (see {@link
     * com.smartgwt.client.widgets.tree.Tree#getTitle Tree.getTitle()}) if {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getTitle title} is not specified. <p> Note: the name of this property can be
     * changed by setting {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty Tree.nameProperty}.
     *
     * @param name New name value. Default value is null, but see below
     * @see com.smartgwt.client.widgets.tree.Tree#setNameProperty
     * @see com.smartgwt.client.widgets.tree.Tree#setPathDelim
     * @see com.smartgwt.client.widgets.tree.Tree#getPath
     * @see com.smartgwt.client.widgets.tree.Tree#getTitle
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * Provides a name for the node that is unique among its immediate siblings, thus allowing a unique path to be used to
     * identify the node, similar to a file system.  See {@link com.smartgwt.client.widgets.tree.Tree#getPath Tree.getPath()}.
     * <p> If the nameProperty is not set on a given node, the {@link com.smartgwt.client.widgets.tree.TreeNode#getId id} will
     * be used instead.  If this is also missing, {@link com.smartgwt.client.widgets.tree.Tree#getName Tree.getName()} and
     * {@link com.smartgwt.client.widgets.tree.Tree#getPath Tree.getPath()} will auto-generate a unique name for you.  Thus
     * names are not required, but if the dataset you are using already has usable names for each node, using them can make
     * APIs such as {@link com.smartgwt.client.widgets.tree.Tree#find Tree.find()} more useful.  Alternatively, if your dataset
     * has unique ids consider providing those as {@link com.smartgwt.client.widgets.tree.TreeNode#getId id}. <P> If a value
     * provided for the nameProperty of a node (e.g. node.name) is not a string, it will be converted to a string by the Tree
     * via ""+value. <p> This property is also used as the default title for the node (see {@link
     * com.smartgwt.client.widgets.tree.Tree#getTitle Tree.getTitle()}) if {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getTitle title} is not specified. <p> Note: the name of this property can be
     * changed by setting {@link com.smartgwt.client.widgets.tree.Tree#getNameProperty Tree.nameProperty}.
     *
     * @return Current name value. Default value is null, but see below
     * @see com.smartgwt.client.widgets.tree.Tree#getNameProperty
     * @see com.smartgwt.client.widgets.tree.Tree#getPathDelim
     * @see com.smartgwt.client.widgets.tree.Tree#getPath
     * @see com.smartgwt.client.widgets.tree.Tree#getTitle
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    
    

    /**
     * For folder nodes showing custom icons (set via {@link com.smartgwt.client.widgets.tree.TreeNode#getIcon icon}), this
     * property allows the developer to specify on a per-node basis whether a drop state icon should be displayed when the 
     * user drop-hovers over this folder.<br> Set <code>node.showDropIcon</code> to true to show the drop state icon, or false
     * to suppress this.<br> If not specified, this behavior is determined by {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconDrop TreeGrid.showCustomIconDrop} for this node. <P>You can
     * change the name of this property by setting  {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconDropProperty
     * TreeGrid.customIconDropProperty}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showDropIcon New showDropIcon value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setShowCustomIconDrop
     */
    public void setShowDropIcon(Boolean showDropIcon) {
        setAttribute("showDropIcon", showDropIcon);
    }

    /**
     * For folder nodes showing custom icons (set via {@link com.smartgwt.client.widgets.tree.TreeNode#getIcon icon}), this
     * property allows the developer to specify on a per-node basis whether a drop state icon should be displayed when the 
     * user drop-hovers over this folder.<br> Set <code>node.showDropIcon</code> to true to show the drop state icon, or false
     * to suppress this.<br> If not specified, this behavior is determined by {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconDrop TreeGrid.showCustomIconDrop} for this node. <P>You can
     * change the name of this property by setting  {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconDropProperty
     * TreeGrid.customIconDropProperty}.
     *
     * @return Current showDropIcon value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconDrop
     */
    public Boolean getShowDropIcon()  {
        Boolean result = getAttributeAsBoolean("showDropIcon", true);
        return result == null ? false : result;
    }
    

    /**
     * For folder nodes showing custom icons (set via {@link com.smartgwt.client.widgets.tree.TreeNode#getIcon icon}), this
     * property allows the developer to specify on a per-node basis whether an open state icon should be displayed when the
     * folder is open. Set <code>node.showOpenIcon</code> to true to show the open state icons, or false to suppress this.<br>
     * If not specified, this behavior is determined by {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconOpen
     * TreeGrid.showCustomIconOpen} for this node. <P>You can change the name of this property by setting  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconOpenProperty TreeGrid.customIconOpenProperty}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOpenIcon New showOpenIcon value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setShowCustomIconOpen
     */
    public void setShowOpenIcon(Boolean showOpenIcon) {
        setAttribute("showOpenIcon", showOpenIcon);
    }

    /**
     * For folder nodes showing custom icons (set via {@link com.smartgwt.client.widgets.tree.TreeNode#getIcon icon}), this
     * property allows the developer to specify on a per-node basis whether an open state icon should be displayed when the
     * folder is open. Set <code>node.showOpenIcon</code> to true to show the open state icons, or false to suppress this.<br>
     * If not specified, this behavior is determined by {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconOpen
     * TreeGrid.showCustomIconOpen} for this node. <P>You can change the name of this property by setting  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconOpenProperty TreeGrid.customIconOpenProperty}.
     *
     * @return Current showOpenIcon value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconOpen
     */
    public Boolean getShowOpenIcon()  {
        Boolean result = getAttributeAsBoolean("showOpenIcon", true);
        return result == null ? false : result;
    }
    

    /**
     * For folder nodes showing custom icons (set via {@link com.smartgwt.client.widgets.tree.TreeNode#getIcon icon}), this
     * property allows the developer to specify on a per-node basis whether a selected state icon should be displayed when the
     * folder is open. Set <code>node.showSelectedIcon</code> to true to show the selected state icons, or false to suppress
     * this.<br> If not specified, this behavior is determined by {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconSelected TreeGrid.showCustomIconSelected} for this node.
     * <P>You can change the name of this property by setting  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconSelectedProperty TreeGrid.customIconSelectedProperty}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showSelectedIcon New showSelectedIcon value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setShowCustomIconSelected
     */
    public void setShowSelectedIcon(Boolean showSelectedIcon) {
        setAttribute("showSelectedIcon", showSelectedIcon);
    }

    /**
     * For folder nodes showing custom icons (set via {@link com.smartgwt.client.widgets.tree.TreeNode#getIcon icon}), this
     * property allows the developer to specify on a per-node basis whether a selected state icon should be displayed when the
     * folder is open. Set <code>node.showSelectedIcon</code> to true to show the selected state icons, or false to suppress
     * this.<br> If not specified, this behavior is determined by {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconSelected TreeGrid.showCustomIconSelected} for this node.
     * <P>You can change the name of this property by setting  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconSelectedProperty TreeGrid.customIconSelectedProperty}.
     *
     * @return Current showSelectedIcon value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconSelected
     */
    public Boolean getShowSelectedIcon()  {
        Boolean result = getAttributeAsBoolean("showSelectedIcon", true);
        return result == null ? false : result;
    }
    

    /**
     * The title of the node as it should appear next to the node icon in the {@link com.smartgwt.client.widgets.tree.Tree}. 
     * If left unset, the value of {@link com.smartgwt.client.widgets.tree.TreeNode#getName name} is used by default.  See the
     * description in {@link com.smartgwt.client.widgets.tree.Tree#getTitle Tree.getTitle()} for full details. <p> Note: the
     * name of this property can be changed by setting {@link com.smartgwt.client.widgets.tree.Tree#getTitleProperty
     * Tree.titleProperty}.
     *
     * @param title New title value. Default value is null
     * @see com.smartgwt.client.widgets.tree.Tree#setTitleProperty
     * @see com.smartgwt.client.widgets.tree.Tree#getTitle
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setTitle(String title) {
        setAttribute("title", title);
    }

    /**
     * The title of the node as it should appear next to the node icon in the {@link com.smartgwt.client.widgets.tree.Tree}. 
     * If left unset, the value of {@link com.smartgwt.client.widgets.tree.TreeNode#getName name} is used by default.  See the
     * description in {@link com.smartgwt.client.widgets.tree.Tree#getTitle Tree.getTitle()} for full details. <p> Note: the
     * name of this property can be changed by setting {@link com.smartgwt.client.widgets.tree.Tree#getTitleProperty
     * Tree.titleProperty}.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.widgets.tree.Tree#getTitleProperty
     * @see com.smartgwt.client.widgets.tree.Tree#getTitle
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************


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
