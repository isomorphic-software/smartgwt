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
    * The SmartGWT system supports hierarchical data (also referred to as tree data&#010 due to its "branching" organization) with:&#010 <ul>&#010   <li> the {@link com.smartgwt.client.widgets.tree.Tree} class, which manipulates hierarchical data sets&#010   <li> the TreeGrid widget class, which extends the ListGrid class to visually&#010        present tree data in an expandable/collapsible format.&#010 </ul>&#010 For information on DataBinding Trees, see {@link com.smartgwt.client.docs.TreeDataBinding}.&#010 <p>&#010 A TreeGrid works just like a {@link com.smartgwt.client.widgets.grid.ListGrid}, except one column (specified by&#010 {@link com.smartgwt.client.widgets.tree.TreeGridField#getTreeField treeField} shows a heirarchical {@link com.smartgwt.client.widgets.tree.Tree}.  A TreeGrid is not limited&#010 to displaying just the {@link com.smartgwt.client.widgets.tree.Tree} column - you can define additional columns (via&#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getFields fields}) which will render just like the columns of a {@link com.smartgwt.client.widgets.grid.ListGrid}, and&#010 support all of the functionality of ListGrid columns, such as&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#formatCellValue}.&#010 <p>&#010 Except where explicitly overridden, {@link com.smartgwt.client.widgets.grid.ListGrid} methods, callbacks, and properties&#010 apply to TreeGrids as well.  The {@link com.smartgwt.client.widgets.grid.ListGrid} defines some methods as taking/returning&#010 ${isc.DocUtils.linkForRef('object:ListGridField')} and {@link com.smartgwt.client.widgets.grid.ListGridRecord}.  When using those methods in a TreeGrid,&#010 those types will be ${isc.DocUtils.linkForRef('object:TreeGridField')} and {@link com.smartgwt.client.widgets.tree.TreeNode}, respectively.

    */









public class TreeGrid extends ListGrid  implements com.smartgwt.client.widgets.tree.events.HasFolderDropHandlers, com.smartgwt.client.widgets.tree.events.HasDataArrivedHandlers, com.smartgwt.client.widgets.tree.events.HasFolderOpenedHandlers, com.smartgwt.client.widgets.tree.events.HasFolderClosedHandlers, com.smartgwt.client.widgets.tree.events.HasFolderClickHandlers, com.smartgwt.client.widgets.tree.events.HasLeafClickHandlers, com.smartgwt.client.widgets.tree.events.HasNodeClickHandlers, com.smartgwt.client.widgets.tree.events.HasFolderContextClickHandlers, com.smartgwt.client.widgets.tree.events.HasLeafContextClickHandlers, com.smartgwt.client.widgets.tree.events.HasNodeContextClickHandlers {

    public static TreeGrid getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (TreeGrid) obj;
        } else {
            return new TreeGrid(jsObj);
        }
    }


    public TreeGrid(){
        
    }

    public TreeGrid(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.TreeGrid.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * If true, when folders are opened / closed children will be animated into view.
    *
    * @param animateFolders animateFolders Default value is true
    */
    public void setAnimateFolders(Boolean animateFolders) {
        setAttribute("animateFolders", animateFolders, true);
    }
    /**
     * If true, when folders are opened / closed children will be animated into view.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAnimateFolders()  {
        return getAttributeAsBoolean("animateFolders");
    }

    /**
    * When animating folder opening / closing, if {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderSpeed animateFolderSpeed} is not&#010 set, this property designates the duration of the animation in ms.
    *
    * @param animateFolderTime animateFolderTime Default value is 100
    */
    public void setAnimateFolderTime(int animateFolderTime) {
        setAttribute("animateFolderTime", animateFolderTime, true);
    }
    /**
     * When animating folder opening / closing, if {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderSpeed animateFolderSpeed} is not&#010 set, this property designates the duration of the animation in ms.
     *
     *
     * @return int
     *
     */
    public int getAnimateFolderTime()  {
        return getAttributeAsInt("animateFolderTime");
    }

    /**
    * When animating folder opening / closing, this property designates the speed of the&#010 animation in pixels shown (or hidden) per second. Takes presidence over the &#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderTime animateFolderTime} property, which allows the developer to specify a&#010 duration for the animation rather than a speed.
    *
    * @param animateFolderSpeed animateFolderSpeed Default value is 1000
    */
    public void setAnimateFolderSpeed(int animateFolderSpeed) {
        setAttribute("animateFolderSpeed", animateFolderSpeed, true);
    }
    /**
     * When animating folder opening / closing, this property designates the speed of the&#010 animation in pixels shown (or hidden) per second. Takes presidence over the &#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getAnimateFolderTime animateFolderTime} property, which allows the developer to specify a&#010 duration for the animation rather than a speed.
     *
     *
     * @return int
     *
     */
    public int getAnimateFolderSpeed()  {
        return getAttributeAsInt("animateFolderSpeed");
    }
             
    /**
    * When animating folder opening / closing, this property can be set to apply an&#010 animated acceleration effect.designates the speed of the&#010 animation in pixels shown (or hidden) per second.
    *
    * @param animateFolderEffect animateFolderEffect Default value is null
    */
    public void setAnimateFolderEffect(AnimationAcceleration animateFolderEffect) {
        setAttribute("animateFolderEffect", animateFolderEffect.getValue(), true);
    }
    /**
     * When animating folder opening / closing, this property can be set to apply an&#010 animated acceleration effect.designates the speed of the&#010 animation in pixels shown (or hidden) per second.
     *
     *
     * @return AnimationAcceleration
     *
     */
    public AnimationAcceleration getAnimateFolderEffect()  {
        return (AnimationAcceleration) EnumUtil.getEnum(AnimationAcceleration.values(), getAttribute("animateFolderEffect"));
    }
            
    /**
    * A {@link com.smartgwt.client.widgets.tree.Tree} object containing of nested {@link com.smartgwt.client.widgets.tree.TreeNode}s to &#010 display as rows in this TreeGrid.  &#010 The <code>data</code> property will typically not be explicitly specified for &#010 databound TreeGrids, where the data is returned from the server via databound component&#010 methods such as <code>fetchData()</code>
    * Set the {@link com.smartgwt.client.widgets.tree.Tree} object this TreeGrid will view and manipulate.&#010&#010
    *
    * @param data Tree to show. Default value is null
    */
    public void setData(Tree data) {
        setAttribute("data", data.getOrCreateJsObj(), true);
    }
    /**
     * A {@link com.smartgwt.client.widgets.tree.Tree} object containing of nested {@link com.smartgwt.client.widgets.tree.TreeNode}s to &#010 display as rows in this TreeGrid.  &#010 The <code>data</code> property will typically not be explicitly specified for &#010 databound TreeGrids, where the data is returned from the server via databound component&#010 methods such as <code>fetchData()</code>
     *
     *
     * @return Tree
     *
     */
    public Tree getData()  {
            return Tree.getOrCreateRef(getAttributeAsJavaScriptObject("data"));
    }

    /**
    * For databound treeGrid instances, should the entire tree of data be loaded on initial &#010 fetch, or should folders load their children as they are opened.&#010 <P>&#010 If unset the default {@link com.smartgwt.client..ResultTree#getLoadDataOnDemand loadDataOnDemand} setting will be used.&#010 <P>&#010 Note that when using <code>loadDataOnDemand</code>, every node returned by the server is&#010 assumed be a folder which may load further children.  See&#010 {@link com.smartgwt.client..ResultTree#getDefaultIsFolder defaultIsFolder} for how to control this behavior.
    *
    * @param loadDataOnDemand loadDataOnDemand Default value is null
    */
    public void setLoadDataOnDemand(Boolean loadDataOnDemand) {
        setAttribute("loadDataOnDemand", loadDataOnDemand, true);
    }
    /**
     * For databound treeGrid instances, should the entire tree of data be loaded on initial &#010 fetch, or should folders load their children as they are opened.&#010 <P>&#010 If unset the default {@link com.smartgwt.client..ResultTree#getLoadDataOnDemand loadDataOnDemand} setting will be used.&#010 <P>&#010 Note that when using <code>loadDataOnDemand</code>, every node returned by the server is&#010 assumed be a folder which may load further children.  See&#010 {@link com.smartgwt.client..ResultTree#getDefaultIsFolder defaultIsFolder} for how to control this behavior.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getLoadDataOnDemand()  {
        return getAttributeAsBoolean("loadDataOnDemand");
    }

    /**
    * With ${isc.DocUtils.linkForRef('loadDataOnDemand:true')}, TreeGrids fetch data by selecting the child nodes of&#010 each parent, which should be exact match, so we default to&#010 <code>autoFetchTextMatchStyle:"exact"</code>.&#010 See {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle autoFetchTextMatchStyle} for details.
    *
    * @param autoFetchTextMatchStyle autoFetchTextMatchStyle Default value is "exact"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAutoFetchTextMatchStyle(String autoFetchTextMatchStyle)  throws IllegalStateException {
        setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle, false);
    }
    /**
     * With ${isc.DocUtils.linkForRef('loadDataOnDemand:true')}, TreeGrids fetch data by selecting the child nodes of&#010 each parent, which should be exact match, so we default to&#010 <code>autoFetchTextMatchStyle:"exact"</code>.&#010 See {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle autoFetchTextMatchStyle} for details.
     *
     *
     * @return String
     *
     */
    public String getAutoFetchTextMatchStyle()  {
        return getAttributeAsString("autoFetchTextMatchStyle");
    }

    /**
    * Visible title for the tree column (field).
    *
    * @param treeFieldTitle treeFieldTitle Default value is "Name"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setTreeFieldTitle(String treeFieldTitle)  throws IllegalStateException {
        setAttribute("treeFieldTitle", treeFieldTitle, false);
    }
    /**
     * Visible title for the tree column (field).
     *
     *
     * @return String
     *
     */
    public String getTreeFieldTitle()  {
        return getAttributeAsString("treeFieldTitle");
    }

    /**
    * Specifies whether the root node should be displayed in the treeGrid.&#010 <P>&#010 This property is only available for "children" modelType trees, hence is not allowed for&#010 trees that load data from the server dynamically via {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData}.  &#010 <P>&#010 To get the equivalent of a visible "root" node in a tree that loads data dynamically,&#010 add a singular, top-level parent to the data.  However, note that this top-level parent&#010 will technically be the only child of root, and the implicit root object will be&#010 returned by {@link com.smartgwt.client.widgets.tree.Tree#getRoot}.
    *
    * @param showRoot showRoot Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowRoot(Boolean showRoot)  throws IllegalStateException {
        setAttribute("showRoot", showRoot, false);
    }
    /**
     * Specifies whether the root node should be displayed in the treeGrid.&#010 <P>&#010 This property is only available for "children" modelType trees, hence is not allowed for&#010 trees that load data from the server dynamically via {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData}.  &#010 <P>&#010 To get the equivalent of a visible "root" node in a tree that loads data dynamically,&#010 add a singular, top-level parent to the data.  However, note that this top-level parent&#010 will technically be the only child of root, and the implicit root object will be&#010 returned by {@link com.smartgwt.client.widgets.tree.Tree#getRoot}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowRoot()  {
        return getAttributeAsBoolean("showRoot");
    }

    /**
    * Specifies whether folders and leaves should be segregated in the treeGrid display.&#010          With separateFolders:true and sortDirection:"descending", folders are displayed&#010          before their sibling leaves; with sortDirection:"ascending", leaves are displayed&#010          before their sibling folders.
    *
    * @param separateFolders separateFolders Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setSeparateFolders(Boolean separateFolders)  throws IllegalStateException {
        setAttribute("separateFolders", separateFolders, false);
    }
    /**
     * Specifies whether folders and leaves should be segregated in the treeGrid display.&#010          With separateFolders:true and sortDirection:"descending", folders are displayed&#010          before their sibling leaves; with sortDirection:"ascending", leaves are displayed&#010          before their sibling folders.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSeparateFolders()  {
        return getAttributeAsBoolean("separateFolders");
    }
             
    /**
    * Specifies the type of nodes displayed in the treeGrid.
    *
    * @param displayNodeType displayNodeType Default value is Tree.FOLDERS_AND_LEAVES
    */
    public void setDisplayNodeType(DisplayNodeType displayNodeType) {
        setAttribute("displayNodeType", displayNodeType.getValue(), true);
    }
    /**
     * Specifies the type of nodes displayed in the treeGrid.
     *
     *
     * @return DisplayNodeType
     *
     */
    public DisplayNodeType getDisplayNodeType()  {
        return (DisplayNodeType) EnumUtil.getEnum(DisplayNodeType.values(), getAttribute("displayNodeType"));
    }

    /**
    * Indicates whether records can be dragged from this listGrid and dropped elsewhere.
    *
    * @param canDragRecordsOut canDragRecordsOut Default value is false
    */
    public void setCanDragRecordsOut(Boolean canDragRecordsOut) {
        setAttribute("canDragRecordsOut", canDragRecordsOut, true);
    }
    /**
     * Indicates whether records can be dragged from this listGrid and dropped elsewhere.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDragRecordsOut()  {
        return getAttributeAsBoolean("canDragRecordsOut");
    }

    /**
    * Indicates whether records can be dropped into this listGrid.
    *
    * @param canAcceptDroppedRecords canAcceptDroppedRecords Default value is false
    */
    public void setCanAcceptDroppedRecords(Boolean canAcceptDroppedRecords) {
        setAttribute("canAcceptDroppedRecords", canAcceptDroppedRecords, true);
    }
    /**
     * Indicates whether records can be dropped into this listGrid.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanAcceptDroppedRecords()  {
        return getAttributeAsBoolean("canAcceptDroppedRecords");
    }

    /**
    * Indicates whether records can be reordered by dragging within this listGrid.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canReorderRecords canReorderRecords Default value is false
    */
    public void setCanReorderRecords(Boolean canReorderRecords) {
        setAttribute("canReorderRecords", canReorderRecords, true);
    }
    /**
     * Indicates whether records can be reordered by dragging within this listGrid.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanReorderRecords()  {
        return getAttributeAsBoolean("canReorderRecords");
    }

    /**
    * Whether drops are allowed on leaf nodes.&#010 <P>&#010 Dropping is ordinarily not allowed on leaf nodes unless {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords canReorderRecords} is&#010 set.  &#010 <P>&#010 The default action for a drop on a leaf node is to place the node in that leaf's parent&#010 folder.  This can be customized by overriding {@link com.smartgwt.client.widgets.tree.TreeGrid#folderDrop}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canDropOnLeaves canDropOnLeaves Default value is false
    */
    public void setCanDropOnLeaves(Boolean canDropOnLeaves) {
        setAttribute("canDropOnLeaves", canDropOnLeaves, true);
    }
    /**
     * Whether drops are allowed on leaf nodes.&#010 <P>&#010 Dropping is ordinarily not allowed on leaf nodes unless {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords canReorderRecords} is&#010 set.  &#010 <P>&#010 The default action for a drop on a leaf node is to place the node in that leaf's parent&#010 folder.  This can be customized by overriding {@link com.smartgwt.client.widgets.tree.TreeGrid#folderDrop}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDropOnLeaves()  {
        return getAttributeAsBoolean("canDropOnLeaves");
    }

    /**
    * If set this property allows the user to reparent nodes by dragging them from their&#010 current folder to a new folder.<br>&#010 <b>Backcompat:</b> For backwards compatibility with versions prior to SmartGWT 1.5,&#010 if this property is unset, but <code>this.canAcceptDroppedRecords</code> is true, we&#010 allow nodes to be dragged to different folders.
    *
    * @param canReparentNodes canReparentNodes Default value is null
    */
    public void setCanReparentNodes(Boolean canReparentNodes) {
        setAttribute("canReparentNodes", canReparentNodes, true);
    }
    /**
     * If set this property allows the user to reparent nodes by dragging them from their&#010 current folder to a new folder.<br>&#010 <b>Backcompat:</b> For backwards compatibility with versions prior to SmartGWT 1.5,&#010 if this property is unset, but <code>this.canAcceptDroppedRecords</code> is true, we&#010 allow nodes to be dragged to different folders.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanReparentNodes()  {
        return getAttributeAsBoolean("canReparentNodes");
    }

    /**
    * Message displayed when user attempts to drag a node into a parent that already contains&#010 a child of the same name.
    *
    * @param parentAlreadyContainsChildMessage parentAlreadyContainsChildMessage Default value is "This item already contains a child item with that name."
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setParentAlreadyContainsChildMessage(String parentAlreadyContainsChildMessage)  throws IllegalStateException {
        setAttribute("parentAlreadyContainsChildMessage", parentAlreadyContainsChildMessage, false);
    }
    /**
     * Message displayed when user attempts to drag a node into a parent that already contains&#010 a child of the same name.
     *
     *
     * @return String
     *
     */
    public String getParentAlreadyContainsChildMessage()  {
        return getAttributeAsString("parentAlreadyContainsChildMessage");
    }

    /**
    * Message displayed when user attempts to drop a dragged node onto itself.
    *
    * @param cantDragIntoSelfMessage cantDragIntoSelfMessage Default value is "You can't drag an item into itself."
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCantDragIntoSelfMessage(String cantDragIntoSelfMessage)  throws IllegalStateException {
        setAttribute("cantDragIntoSelfMessage", cantDragIntoSelfMessage, false);
    }
    /**
     * Message displayed when user attempts to drop a dragged node onto itself.
     *
     *
     * @return String
     *
     */
    public String getCantDragIntoSelfMessage()  {
        return getAttributeAsString("cantDragIntoSelfMessage");
    }

    /**
    * Message displayed when user attempts to drop a node into a child of itself.
    *
    * @param cantDragIntoChildMessage cantDragIntoChildMessage Default value is "You can't drag an item into one of it's children."
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCantDragIntoChildMessage(String cantDragIntoChildMessage)  throws IllegalStateException {
        setAttribute("cantDragIntoChildMessage", cantDragIntoChildMessage, false);
    }
    /**
     * Message displayed when user attempts to drop a node into a child of itself.
     *
     *
     * @return String
     *
     */
    public String getCantDragIntoChildMessage()  {
        return getAttributeAsString("cantDragIntoChildMessage");
    }

    /**
    * The amount of indentation (in pixels) to add to a node's icon/title for each level&#010          down in this tree's hierarchy.
    *
    * @param indentSize indentSize Default value is 20
    */
    public void setIndentSize(int indentSize) {
        setAttribute("indentSize", indentSize, true);
    }
    /**
     * The amount of indentation (in pixels) to add to a node's icon/title for each level&#010          down in this tree's hierarchy.
     *
     *
     * @return int
     *
     */
    public int getIndentSize()  {
        return getAttributeAsInt("indentSize");
    }

    /**
    * The standard size (same height and width, in pixels) of node icons in this&#010          treeGrid.
    *
    * @param iconSize iconSize Default value is 16
    */
    public void setIconSize(int iconSize) {
        setAttribute("iconSize", iconSize, true);
    }
    /**
     * The standard size (same height and width, in pixels) of node icons in this&#010          treeGrid.
     *
     *
     * @return int
     *
     */
    public int getIconSize()  {
        return getAttributeAsInt("iconSize");
    }

    /**
    * Width and height in pixels of the opener icons, that is, the icons which show the open&#010 or closed state of the node, typically a [+] or [-] symbol.&#010 <P>&#010 If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true, the opener icon includes the connector line, and&#010 defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight 'cellHeight'}.&#010 <P>&#010 Otherwise, <code>openerIconSize</code> defaults to {@link com.smartgwt.client.widgets.tree.TreeGrid#getIconSize iconSize}.
    *
    * @param openerIconSize openerIconSize Default value is null
    */
    public void setOpenerIconSize(Integer openerIconSize) {
        setAttribute("openerIconSize", openerIconSize, true);
    }
    /**
     * Width and height in pixels of the opener icons, that is, the icons which show the open&#010 or closed state of the node, typically a [+] or [-] symbol.&#010 <P>&#010 If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true, the opener icon includes the connector line, and&#010 defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight 'cellHeight'}.&#010 <P>&#010 Otherwise, <code>openerIconSize</code> defaults to {@link com.smartgwt.client.widgets.tree.TreeGrid#getIconSize iconSize}.
     *
     *
     * @return Integer
     *
     */
    public Integer getOpenerIconSize()  {
        return getAttributeAsInt("openerIconSize");
    }

    /**
    * The URL of the base icon for all folder nodes in this treeGrid. Note that this URL will&#010 have {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix}, {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} or &#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} appended to indicate state changes if appropriate - &#010 see documentation on  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} and {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons}.
    *
    * @param folderIcon folderIcon Default value is "[SKIN]folder.gif"
    */
    public void setFolderIcon(String folderIcon) {
        setAttribute("folderIcon", folderIcon, true);
    }
    /**
     * The URL of the base icon for all folder nodes in this treeGrid. Note that this URL will&#010 have {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix}, {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} or &#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} appended to indicate state changes if appropriate - &#010 see documentation on  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} and {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons}.
     *
     *
     * @return String
     *
     */
    public String getFolderIcon()  {
        return getAttributeAsString("folderIcon");
    }

    /**
    * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons} is true, this suffix will be appended to the&#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} when the user drop-hovers over some folder.
    *
    * @param dropIconSuffix dropIconSuffix Default value is "drop"
    */
    public void setDropIconSuffix(String dropIconSuffix) {
        setAttribute("dropIconSuffix", dropIconSuffix, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons} is true, this suffix will be appended to the&#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} when the user drop-hovers over some folder.
     *
     *
     * @return String
     *
     */
    public String getDropIconSuffix()  {
        return getAttributeAsString("dropIconSuffix");
    }

    /**
    * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} is true, this suffix will be appended to the&#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for open folders in this grid.
    *
    * @param openIconSuffix openIconSuffix Default value is "open"
    */
    public void setOpenIconSuffix(String openIconSuffix) {
        setAttribute("openIconSuffix", openIconSuffix, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} is true, this suffix will be appended to the&#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for open folders in this grid.
     *
     *
     * @return String
     *
     */
    public String getOpenIconSuffix()  {
        return getAttributeAsString("openIconSuffix");
    }

    /**
    * This suffix will be appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for closed folders.&#010 If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} is set to <code>false</code> this suffix will also be&#010 appended to open folders' icons.
    *
    * @param closedIconSuffix closedIconSuffix Default value is "closed"
    */
    public void setClosedIconSuffix(String closedIconSuffix) {
        setAttribute("closedIconSuffix", closedIconSuffix, true);
    }
    /**
     * This suffix will be appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for closed folders.&#010 If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpenIcons showOpenIcons} is set to <code>false</code> this suffix will also be&#010 appended to open folders' icons.
     *
     *
     * @return String
     *
     */
    public String getClosedIconSuffix()  {
        return getAttributeAsString("closedIconSuffix");
    }

    /**
    * The filename of the default icon for all leaf nodes in this grid. To specify a &#010 custom image for an individual node, set the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty} directly on&#010 the node.
    * Set the icon for a particular treenode to a specified URL&#010&#010
    *
    * @param nodeIcon tree node. Default value is "[SKIN]file.gif"
    */
    public void setNodeIcon(String nodeIcon) {
        setAttribute("nodeIcon", nodeIcon, true);
    }
    /**
     * The filename of the default icon for all leaf nodes in this grid. To specify a &#010 custom image for an individual node, set the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty} directly on&#010 the node.
     *
     *
     * @return String
     *
     */
    public String getNodeIcon()  {
        return getAttributeAsString("nodeIcon");
    }

    /**
    * If true, show a different icon for <code>open</code> folders than closed folders.&#010 This is achieved by appending the {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} onto the &#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL [for example <code>"[SKIN]/folder.gif"</code> might be &#010 replaced by <code>"[SKIN]/folder_open.gif"</code>.<br>&#010 <b>Note</b> If this property is set to <code>false</code> the same icon is shown for&#010 open folders as for closed folders, unless a custom folder icon was specified. This will be&#010 determined by {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} plus the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix}.
    *
    * @param showOpenIcons showOpenIcons Default value is true
    */
    public void setShowOpenIcons(Boolean showOpenIcons) {
        setAttribute("showOpenIcons", showOpenIcons, true);
    }
    /**
     * If true, show a different icon for <code>open</code> folders than closed folders.&#010 This is achieved by appending the {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} onto the &#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL [for example <code>"[SKIN]/folder.gif"</code> might be &#010 replaced by <code>"[SKIN]/folder_open.gif"</code>.<br>&#010 <b>Note</b> If this property is set to <code>false</code> the same icon is shown for&#010 open folders as for closed folders, unless a custom folder icon was specified. This will be&#010 determined by {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} plus the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowOpenIcons()  {
        return getAttributeAsBoolean("showOpenIcons");
    }

    /**
    * If true, when the user drags a droppable target over a folder in this TreeGrid, show &#010 a different icon folder icon.&#010 This is achieved by appending the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} onto the&#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL (for example <code>"[SKIN]/folder.gif"</code> may be&#010 replaced by <code>"[SKIN]/folder_drop.gif"</code>).
    *
    * @param showDropIcons showDropIcons Default value is true
    */
    public void setShowDropIcons(Boolean showDropIcons) {
        setAttribute("showDropIcons", showDropIcons, true);
    }
    /**
     * If true, when the user drags a droppable target over a folder in this TreeGrid, show &#010 a different icon folder icon.&#010 This is achieved by appending the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} onto the&#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL (for example <code>"[SKIN]/folder.gif"</code> may be&#010 replaced by <code>"[SKIN]/folder_drop.gif"</code>).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDropIcons()  {
        return getAttributeAsBoolean("showDropIcons");
    }

    /**
    * This property allows the developer to customize the icon displayed next to a node.&#010 Set <code>node[grid.customIconProperty]</code> to the URL of the desired icon to display and&#010 it will be shown instead of the standard {@link com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon nodeIcon} for this node.<br>&#010 Note that if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconOpen showCustomIconOpen} and/or {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconDrop showCustomIconDrop} &#010 is true for this grid, customized icons for folder nodes will be appended with the &#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} or {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} suffixes on state change &#010 as with the standard {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for this treeGrid.  Also note that for&#010 custom folder icons, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} will never be appened.
    *
    * @param customIconProperty customIconProperty Default value is "icon"
    */
    public void setCustomIconProperty(String customIconProperty) {
        setAttribute("customIconProperty", customIconProperty, true);
    }
    /**
     * This property allows the developer to customize the icon displayed next to a node.&#010 Set <code>node[grid.customIconProperty]</code> to the URL of the desired icon to display and&#010 it will be shown instead of the standard {@link com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon nodeIcon} for this node.<br>&#010 Note that if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconOpen showCustomIconOpen} and/or {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconDrop showCustomIconDrop} &#010 is true for this grid, customized icons for folder nodes will be appended with the &#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} or {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} suffixes on state change &#010 as with the standard {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} for this treeGrid.  Also note that for&#010 custom folder icons, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} will never be appened.
     *
     *
     * @return String
     *
     */
    public String getCustomIconProperty()  {
        return getAttributeAsString("customIconProperty");
    }

    /**
    * Should folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}),&#010 show open state images when the folder is opened.&#010 If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} will be appended to the image URL&#010 (so <code>"customFolder.gif"</code> might be replaced with &#010 <code>"customFolder_open.gif"</code>).<br>&#010 <b>Note</b> that the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} is never appended to custom folder icons.<br>&#010 Can be overridden at the node level via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconOpenProperty customIconOpenProperty} property.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showCustomIconOpen showCustomIconOpen Default value is false
    */
    public void setShowCustomIconOpen(Boolean showCustomIconOpen) {
        setAttribute("showCustomIconOpen", showCustomIconOpen, true);
    }
    /**
     * Should folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}),&#010 show open state images when the folder is opened.&#010 If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenIconSuffix openIconSuffix} will be appended to the image URL&#010 (so <code>"customFolder.gif"</code> might be replaced with &#010 <code>"customFolder_open.gif"</code>).<br>&#010 <b>Note</b> that the {@link com.smartgwt.client.widgets.tree.TreeGrid#getClosedIconSuffix closedIconSuffix} is never appended to custom folder icons.<br>&#010 Can be overridden at the node level via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconOpenProperty customIconOpenProperty} property.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowCustomIconOpen()  {
        return getAttributeAsBoolean("showCustomIconOpen");
    }

    /**
    * Should folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}),&#010 show drop state images when the user is drop-hovering over the folder.&#010 If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} will be appended to the image URL&#010 (so <code>"customFolder.gif"</code> might be replaced with &#010 <code>"customFolder_drop.gif"</code>).<br>&#010 Can be overridden at the node level via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconDropProperty customIconDropProperty} property.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showCustomIconDrop showCustomIconDrop Default value is false
    */
    public void setShowCustomIconDrop(Boolean showCustomIconDrop) {
        setAttribute("showCustomIconDrop", showCustomIconDrop, true);
    }
    /**
     * Should folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}),&#010 show drop state images when the user is drop-hovering over the folder.&#010 If true, the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix} will be appended to the image URL&#010 (so <code>"customFolder.gif"</code> might be replaced with &#010 <code>"customFolder_drop.gif"</code>).<br>&#010 Can be overridden at the node level via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconDropProperty customIconDropProperty} property.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowCustomIconDrop()  {
        return getAttributeAsBoolean("showCustomIconDrop");
    }

    /**
    * For folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}),&#010 this property allows the developer to specify on a per-node basis whether a&#010 open state icon should be displayed when the folder is open.&#010 Set <code>node[treeGrid.customIconOpenProperty]</code> to true to show the open state&#010 icons, or false to suppress this.<br>&#010 If not specified, this behavior is determined by <code>grid.showCustomIconOpen</code>&#010 for this node.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param customIconOpenProperty customIconOpenProperty Default value is "showOpenIcon"
    */
    public void setCustomIconOpenProperty(String customIconOpenProperty) {
        setAttribute("customIconOpenProperty", customIconOpenProperty, true);
    }
    /**
     * For folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}),&#010 this property allows the developer to specify on a per-node basis whether a&#010 open state icon should be displayed when the folder is open.&#010 Set <code>node[treeGrid.customIconOpenProperty]</code> to true to show the open state&#010 icons, or false to suppress this.<br>&#010 If not specified, this behavior is determined by <code>grid.showCustomIconOpen</code>&#010 for this node.
     *
     *
     * @return String
     *
     */
    public String getCustomIconOpenProperty()  {
        return getAttributeAsString("customIconOpenProperty");
    }

    /**
    * For folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}),&#010 this property allows the developer to specify on a per-node basis whether a&#010 drop state icon (with {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix}) should be displayed when the &#010 user drop-hovers over this folder.<br>&#010 Set <code>node[treeGrid.customIconDropProperty]</code> to true to show the drop state&#010 icons, or false to suppress this.<br>&#010 If not specified this this behavior is determined by <code>treeGrid.showCustomIconDrop</code>&#010 for this node.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param customIconDropProperty customIconDropProperty Default value is "showDropIcon"
    */
    public void setCustomIconDropProperty(String customIconDropProperty) {
        setAttribute("customIconDropProperty", customIconDropProperty, true);
    }
    /**
     * For folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}),&#010 this property allows the developer to specify on a per-node basis whether a&#010 drop state icon (with {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix dropIconSuffix}) should be displayed when the &#010 user drop-hovers over this folder.<br>&#010 Set <code>node[treeGrid.customIconDropProperty]</code> to true to show the drop state&#010 icons, or false to suppress this.<br>&#010 If not specified this this behavior is determined by <code>treeGrid.showCustomIconDrop</code>&#010 for this node.
     *
     *
     * @return String
     *
     */
    public String getCustomIconDropProperty()  {
        return getAttributeAsString("customIconDropProperty");
    }

    /**
    * The filename of the icon displayed use as the default drag tracker when for multiple&#010 files and/or folders are being dragged.
    *
    * @param manyItemsImage manyItemsImage Default value is "[SKIN]folder_file.gif"
    */
    public void setManyItemsImage(String manyItemsImage) {
        setAttribute("manyItemsImage", manyItemsImage, true);
    }
    /**
     * The filename of the icon displayed use as the default drag tracker when for multiple&#010 files and/or folders are being dragged.
     *
     *
     * @return String
     *
     */
    public String getManyItemsImage()  {
        return getAttributeAsString("manyItemsImage");
    }

    /**
    * Should this treeGrid show connector lines illustrating the tree's hierachy?&#010 <P>&#010 For the set of images used to show connectors, see {@link com.smartgwt.client.widgets.tree.TreeGrid#getConnectorImage connectorImage}.&#010 <P>&#010 <b>Note</b>: in order for connector images to be perfectly connected, all styles for&#010 cells must have no top or bottom border or padding.  If you see small gaps in connector&#010 lines, check your CSS files.  See the example below for an example of correct&#010 configuration, including example CSS.
    *
    * @param showConnectors showConnectors Default value is false
    */
    public void setShowConnectors(Boolean showConnectors) {
        setAttribute("showConnectors", showConnectors, true);
    }
    /**
     * Should this treeGrid show connector lines illustrating the tree's hierachy?&#010 <P>&#010 For the set of images used to show connectors, see {@link com.smartgwt.client.widgets.tree.TreeGrid#getConnectorImage connectorImage}.&#010 <P>&#010 <b>Note</b>: in order for connector images to be perfectly connected, all styles for&#010 cells must have no top or bottom border or padding.  If you see small gaps in connector&#010 lines, check your CSS files.  See the example below for an example of correct&#010 configuration, including example CSS.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowConnectors()  {
        return getAttributeAsBoolean("showConnectors");
    }

    /**
    * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true, this property determines whether we should show&#010 showing vertical continuation lines for each level of indenting within the tree. Setting to&#010 false will show only the hierachy lines are only shown for the most indented path ("sparse"&#010 connectors).
    *
    * @param showFullConnectors showFullConnectors Default value is true
    */
    public void setShowFullConnectors(Boolean showFullConnectors) {
        setAttribute("showFullConnectors", showFullConnectors, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true, this property determines whether we should show&#010 showing vertical continuation lines for each level of indenting within the tree. Setting to&#010 false will show only the hierachy lines are only shown for the most indented path ("sparse"&#010 connectors).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowFullConnectors()  {
        return getAttributeAsBoolean("showFullConnectors");
    }

    /**
    * The base filename of the opener icon for the folder node when 'showConnectors' is false&#010 for this TreeGrid.<br>&#010 The opener icon is displayed beside the folder icon in the Tree column for folder nodes.&#010 Clicking on this icon will toggle the open state of the folder.<br>&#010 The filenames for these icons are assembled from this base filename and the state of the&#010 node, as follows:<br>&#010 If the openerImage is set to <code>{baseName}.{extension}</code>, &#010 <code>{baseName}_opened.{extension}</code> will be displayed next to opened folders, and&#010 <code>{baseName}_closed.{extension}</code> will be displayed next to closed folders, or&#010 if this page is in RTL mode, <code>{baseName}_opened_rtl.{extension}</code> and&#010 <code>{baseName}_closed_rtl.{extension}</code> will be used.
    *
    * @param openerImage openerImage Default value is "[SKIN]opener.gif"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setOpenerImage(String openerImage)  throws IllegalStateException {
        setAttribute("openerImage", openerImage, false);
    }
    /**
     * The base filename of the opener icon for the folder node when 'showConnectors' is false&#010 for this TreeGrid.<br>&#010 The opener icon is displayed beside the folder icon in the Tree column for folder nodes.&#010 Clicking on this icon will toggle the open state of the folder.<br>&#010 The filenames for these icons are assembled from this base filename and the state of the&#010 node, as follows:<br>&#010 If the openerImage is set to <code>{baseName}.{extension}</code>, &#010 <code>{baseName}_opened.{extension}</code> will be displayed next to opened folders, and&#010 <code>{baseName}_closed.{extension}</code> will be displayed next to closed folders, or&#010 if this page is in RTL mode, <code>{baseName}_opened_rtl.{extension}</code> and&#010 <code>{baseName}_closed_rtl.{extension}</code> will be used.
     *
     *
     * @return String
     *
     */
    public String getOpenerImage()  {
        return getAttributeAsString("openerImage");
    }

    /**
    * The base filename for connector icons shown when {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true.&#010 Connector icons are rendered into the title field of each row and show the dotted&#010 hierarchy lines between siblings of the same parent node. For each node, a connector icon&#010 may be shown:<ul>&#010 <li>As an opener icon for folder nodes, next to the folder icon</li>&#010 <li>In place of an opener icon for leaf nodes, next to the leaf icon</li>&#010 <li>As a standalone vertical continuation line in the indent to the left of the node, to show&#010     a connection between some ancestor node's siblings (only relevant if&#010     {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is true).</li>&#010 </ul>&#010 Note that {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} governs whether connector lines will be&#010 displayed for all indent levels, or just for the innermost level of the tree.&#010 <P>&#010 The filenames for these icons are assembled from this base filename and the state of the&#010 node.  Assuming the connectorImage is set to <code>{baseName}.{extension}</code>, the&#010 full set of images to be displayed will be:&#010 <P>&#010 <code>{baseName}_ancestor[_rtl].{extension}</code> if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors}&#010  is true, this is the URL for the vertical continuation image to be displayed at the&#010  appropriate indent levels for ancestor nodes with subsequent children.&#010 <P>&#010 For nodes with no children:&#010 <ul>&#010 <li><code>{baseName}_single[_rtl].{extension}</code>: Shown when there is no connector line&#010  attached to the parent or previous sibling, and no connector line to the next sibling. For&#010  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors 'showFullConnectors:true'} trees, there will always be a&#010  connector leading to the parent or previous sibling if its present in the tree so this&#010  icon can only be displayed for the first row.</li>&#010 <li><code>{baseName}_start[_rtl].{extension}</code>:  Shown when the there is no connector&#010  line attached to the parent or previous sibling, but there is a connector to the next&#010  sibling. As with <code>_single</code> this will only ever be used for the first row if&#010  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is true</li>&#010 <li><code>{baseName}_end[_rtl].{extension}</code>:  Shown if we are not showing a connector &#010  line attached to the next sibling of this node (but are showing a connection to the previous&#010  sibling or parent).</li>&#010 <li><code>{baseName}_middle[_rtl].{extension}</code>:  Shown where the we have a connector&#010  line leading to both the previous sibling (or parent) and the next sibling.&#010 </ul>&#010 For folders with children. Note that if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is false, open&#010 folders will never show a connector to subsequent siblings:&#010 <ul>&#010 <li><code>{baseName}_opened_single[_rtl].{extension}</code> opened folder node with &#010  children when no connector line is shown attaching to either the folder's previous sibling&#010  or parent, or to any subsequent siblings.</li>&#010 <li><code>{baseName}_opened_start[_rtl].{extension}</code>:  opened folder with children&#010  when the there is no connector line attached to the parent or previous sibling, but there &#010  is a connector to the next sibling.</li>&#010 <li><code>{baseName}_opened_end[_rtl].{extension}</code>:  opened folder with children &#010  if we are not showing a connector line attached to the next sibling of this node (but are&#010  showing a connection to the previous sibling or parent).</li>&#010 <li><code>{baseName}_opened_middle[_rtl].{extension}</code>: opened folder with children &#010  where the we have a connector line leading to both the previous sibling (or parent) and the&#010  next sibling.&#010 </ul>&#010 <ul>&#010 <li><code>{baseName}_closed_single[_rtl].{extension}</code> closed folder node with &#010  children when no connector line is shown attaching to either the folder's previous sibling&#010  or parent, or to any subsequent siblings.</li>&#010 <li><code>{baseName}_closed_start[_rtl].{extension}</code>:  closed folder with children&#010  when the there is no connector line attached to the parent or previous sibling, but there &#010  is a connector to the next sibling.</li>&#010 <li><code>{baseName}_closed_end[_rtl].{extension}</code>:  closed folder with children &#010  if we are not showing a connector line attached to the next sibling of this node (but are&#010  showing a connection to the previous sibling or parent).</li>&#010 <li><code>{baseName}_closed_middle[_rtl].{extension}</code>: closed folder with children &#010  where the we have a connector line leading to both the previous sibling (or parent) and the&#010  next sibling.&#010 </ul>&#010 (Note '[_rtl]' means that "_rtl" will be attached if isRTL() is true for this widget).
    *
    * @param connectorImage connectorImage Default value is "[SKIN]connector.gif"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setConnectorImage(String connectorImage)  throws IllegalStateException {
        setAttribute("connectorImage", connectorImage, false);
    }
    /**
     * The base filename for connector icons shown when {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowConnectors showConnectors} is true.&#010 Connector icons are rendered into the title field of each row and show the dotted&#010 hierarchy lines between siblings of the same parent node. For each node, a connector icon&#010 may be shown:<ul>&#010 <li>As an opener icon for folder nodes, next to the folder icon</li>&#010 <li>In place of an opener icon for leaf nodes, next to the leaf icon</li>&#010 <li>As a standalone vertical continuation line in the indent to the left of the node, to show&#010     a connection between some ancestor node's siblings (only relevant if&#010     {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is true).</li>&#010 </ul>&#010 Note that {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} governs whether connector lines will be&#010 displayed for all indent levels, or just for the innermost level of the tree.&#010 <P>&#010 The filenames for these icons are assembled from this base filename and the state of the&#010 node.  Assuming the connectorImage is set to <code>{baseName}.{extension}</code>, the&#010 full set of images to be displayed will be:&#010 <P>&#010 <code>{baseName}_ancestor[_rtl].{extension}</code> if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors}&#010  is true, this is the URL for the vertical continuation image to be displayed at the&#010  appropriate indent levels for ancestor nodes with subsequent children.&#010 <P>&#010 For nodes with no children:&#010 <ul>&#010 <li><code>{baseName}_single[_rtl].{extension}</code>: Shown when there is no connector line&#010  attached to the parent or previous sibling, and no connector line to the next sibling. For&#010  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors 'showFullConnectors:true'} trees, there will always be a&#010  connector leading to the parent or previous sibling if its present in the tree so this&#010  icon can only be displayed for the first row.</li>&#010 <li><code>{baseName}_start[_rtl].{extension}</code>:  Shown when the there is no connector&#010  line attached to the parent or previous sibling, but there is a connector to the next&#010  sibling. As with <code>_single</code> this will only ever be used for the first row if&#010  {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is true</li>&#010 <li><code>{baseName}_end[_rtl].{extension}</code>:  Shown if we are not showing a connector &#010  line attached to the next sibling of this node (but are showing a connection to the previous&#010  sibling or parent).</li>&#010 <li><code>{baseName}_middle[_rtl].{extension}</code>:  Shown where the we have a connector&#010  line leading to both the previous sibling (or parent) and the next sibling.&#010 </ul>&#010 For folders with children. Note that if {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowFullConnectors showFullConnectors} is false, open&#010 folders will never show a connector to subsequent siblings:&#010 <ul>&#010 <li><code>{baseName}_opened_single[_rtl].{extension}</code> opened folder node with &#010  children when no connector line is shown attaching to either the folder's previous sibling&#010  or parent, or to any subsequent siblings.</li>&#010 <li><code>{baseName}_opened_start[_rtl].{extension}</code>:  opened folder with children&#010  when the there is no connector line attached to the parent or previous sibling, but there &#010  is a connector to the next sibling.</li>&#010 <li><code>{baseName}_opened_end[_rtl].{extension}</code>:  opened folder with children &#010  if we are not showing a connector line attached to the next sibling of this node (but are&#010  showing a connection to the previous sibling or parent).</li>&#010 <li><code>{baseName}_opened_middle[_rtl].{extension}</code>: opened folder with children &#010  where the we have a connector line leading to both the previous sibling (or parent) and the&#010  next sibling.&#010 </ul>&#010 <ul>&#010 <li><code>{baseName}_closed_single[_rtl].{extension}</code> closed folder node with &#010  children when no connector line is shown attaching to either the folder's previous sibling&#010  or parent, or to any subsequent siblings.</li>&#010 <li><code>{baseName}_closed_start[_rtl].{extension}</code>:  closed folder with children&#010  when the there is no connector line attached to the parent or previous sibling, but there &#010  is a connector to the next sibling.</li>&#010 <li><code>{baseName}_closed_end[_rtl].{extension}</code>:  closed folder with children &#010  if we are not showing a connector line attached to the next sibling of this node (but are&#010  showing a connection to the previous sibling or parent).</li>&#010 <li><code>{baseName}_closed_middle[_rtl].{extension}</code>: closed folder with children &#010  where the we have a connector line leading to both the previous sibling (or parent) and the&#010  next sibling.&#010 </ul>&#010 (Note '[_rtl]' means that "_rtl" will be attached if isRTL() is true for this widget).
     *
     *
     * @return String
     *
     */
    public String getConnectorImage()  {
        return getAttributeAsString("connectorImage");
    }

    // ********************* Methods ***********************






        /**
         * Returns a snapshot of the current open state of this grid's data as&#010 a {@link java.lang.String} object.<br>&#010 This object can be passed to {@link com.smartgwt.client.widgets.tree.TreeGrid#setOpenState} to open the same set of folders&#010 within the treeGrid's data (assuming the nodes are still present in the data).&#010
         *
         * @return current sort state for the grid.
         */
        public native String getOpenState() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getOpenState();
        }-*/;

        /**
         * Reset this set of open folders within this grid's data to match the &#010 {@link java.lang.String} object passed in.<br>&#010 Used to restore previous state retrieved from the grid by a call to &#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getOpenState}.&#010&#010
         * @param openState Object describing the desired set of open folders.
         */
        public native void setOpenState(String openState) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setOpenState(openState);
        }-*/;

        /**
         * Returns a snapshot of the current selection within this treeGrid as &#010 a {@link java.lang.String} object.<br>&#010 This object can be passed to {@link com.smartgwt.client.widgets.tree.TreeGrid#setSelectedPaths} to reset this grid's selection&#010 the current state (assuming the same data is present in the grid).<br>&#010
         *
         * @return current state of this grid's selection
         */
        public native String getSelectedPaths() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getSelectedPaths();
        }-*/;

        /**
         * Reset this grid's selection to match the {@link java.lang.String} object passed in.<br>&#010 Used to restore previous state retrieved from the grid by a call to &#010 {@link com.smartgwt.client.widgets.tree.TreeGrid#getSelectedPaths}.&#010&#010
         * @param selectedPaths Object describing the desired selection state of                                              the grid
         */
        public native void setSelectedPaths(String selectedPaths) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setSelectedPaths(selectedPaths);
        }-*/;




        /**
         * Overridden to disallow editing of the {@link com.smartgwt.client.widgets.tree.TreeNode#getName 'name'} field of this grid's data&#010 tree. Also disallows editing of the auto-generated tree field, which displays the result&#010 of {@link com.smartgwt.client.widgets.tree.Tree#getTitle} on the node.&#010
         *
         * @return Whether to allow editing this cell
         */
        public native Boolean canEditCell() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.canEditCell();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;


        /**
         * &#010 Handle a doubleClick on a tree node - override of ListGrid stringMethod of same name.  If&#010 the node is a folder, this implementation calls {@link com.smartgwt.client.widgets.tree.TreeGrid#toggleFolder} on it.  If&#010 the node is a leaf, calls {@link com.smartgwt.client.widgets.tree.TreeGrid#openLeaf} on it.&#010 &#010
         */
        public native void recordDoubleClick() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.recordDoubleClick();
        }-*/;




        /**
         * &#010 This method overrides {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop} and works as follows:&#010 <br><br>&#010 First, {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop} (the superclass definition) is consulted.  If it&#010 returns false, then this method returns false immediately.<br>&#010 This handles the following cases:<br>&#010 - reordering of records withing this TreeGrid when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanReorderRecords canReorderRecords} is true<br>&#010 - accepting dropped records from another dragTarget when {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAcceptDroppedRecords canAcceptDroppedRecords} &#010   is true and the dragTarget gives us a valid set of records to drop into place.<br>&#010 - disallowing drop over disabled nodes, or nodes with <code>canAcceptDrop:false</code>&#010 <br>&#010 This method will also return false if the drop occurred over a leaf node whos immediate &#010 parent has <code>canAcceptDrop</code> set to <code>false</code><br>&#010 If {@link com.smartgwt.client.widgets.tree.TreeGrid#getCanReparentNodes canReparentNodes} is true, and the user is dragging a node from one folder&#010 to another, this method will return true to allow the change of parent folder.<br>&#010 <br><br>&#010 Otherwise this method returns true.&#010&#010
         *
         * @return true if this component will accept a drop of the dragData
         */
        public native Boolean willAcceptDrop() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.willAcceptDrop();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Returns the row number of the most recent mouse event.&#010
         *
         * @return row number, or -2 if beyond last drawn row
         */
        public native int getEventRow() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getEventRow();
        }-*/;

        /**
         * Returns the row number of the most recent mouse event.&#010
         * @param y optional y-coordinate to obtain row number, in lieue of the y                        coordinate of the last mouse event
         *
         * @return row number, or -2 if beyond last drawn row
         */
        public native int getEventRow(int y) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getEventRow(y);
        }-*/;






        /**
         * Get the appropriate open/close opener icon for a node.&#010&#010
         * @param node tree node in question
         *
         * @return URL for the icon to show the node's open state
         */
        public native String getOpenIcon(TreeNode node) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getOpenIcon(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;

        /**
         * Get an additional icon to show between the open icon and folder/node icon for a particular &#010 node.&#010&#010
         * @param node tree node in question
         *
         * @return URL for the extra icon (null if none required)
         */
        public native String getExtraIcon(TreeNode node) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getExtraIcon(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;



        /**
         * Add a folderOpened handler.
         * <p>
         * &#010 This method is called when a folder is opened either via the user manipulating the&#010 expand/collapse control in the UI or via {@link com.smartgwt.client.widgets.tree.TreeGrid#openFolder}.  You can return&#010 <code>false</code> to cancel the open.&#010&#010
         *
         * @param handler the folderOpened handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addFolderOpenedHandler(com.smartgwt.client.widgets.tree.events.FolderOpenedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderOpenedEvent.getType()) == 0) setupFolderOpenedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderOpenedEvent.getType());
        }
        private native void setupFolderOpenedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({folderOpened:function(){
                        var param = {"node" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.tree.events.FolderOpenedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.folderOpened = function(){
                    var param = {"node" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.tree.events.FolderOpenedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a folderClosed handler.
         * <p>
         * &#010 This method is called when a folder is closed either via the user manipulating the&#010 expand/collapse control in the UI or via {@link com.smartgwt.client.widgets.tree.TreeGrid#closeFolder}.  You can return&#010 <code>false</code> to cancel the close.&#010&#010
         *
         * @param handler the folderClosed handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addFolderClosedHandler(com.smartgwt.client.widgets.tree.events.FolderClosedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderClosedEvent.getType()) == 0) setupFolderClosedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderClosedEvent.getType());
        }
        private native void setupFolderClosedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({folderClosed:function(){
                        var param = {"node" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.tree.events.FolderClosedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.folderClosed = function(){
                    var param = {"node" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.tree.events.FolderClosedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a folderClick handler.
         * <p>
         * &#010 This method is called when a folder record is clicked on.&#010&#010
         *
         * @param handler the folderClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addFolderClickHandler(com.smartgwt.client.widgets.tree.events.FolderClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderClickEvent.getType()) == 0) setupFolderClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderClickEvent.getType());
        }
        private native void setupFolderClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({folderClick:function(){
                        var param = {"viewer" : arguments[0], "folder" : arguments[1], "recordNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tree.events.FolderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.folderClick = function(){
                    var param = {"viewer" : arguments[0], "folder" : arguments[1], "recordNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tree.events.FolderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Add a leafClick handler.
         * <p>
         * &#010 This method is called when a leaf record is clicked on.&#010&#010
         *
         * @param handler the leafClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addLeafClickHandler(com.smartgwt.client.widgets.tree.events.LeafClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.LeafClickEvent.getType()) == 0) setupLeafClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.LeafClickEvent.getType());
        }
        private native void setupLeafClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({leafClick:function(){
                        var param = {"viewer" : arguments[0], "leaf" : arguments[1], "recordNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tree.events.LeafClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.leafClick = function(){
                    var param = {"viewer" : arguments[0], "leaf" : arguments[1], "recordNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tree.events.LeafClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Add a nodeClick handler.
         * <p>
         * &#010 This method is called when a leaf or folder record is clicked on.  Note that if you set&#010 up a callback for <code>nodeClick()</code> and e.g. {@link com.smartgwt.client.widgets.tree.TreeGrid#addLeafClickHandler}, then&#010 both will fire (in that order) if a leaf is clicked on.&#010&#010
         *
         * @param handler the nodeClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addNodeClickHandler(com.smartgwt.client.widgets.tree.events.NodeClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.NodeClickEvent.getType()) == 0) setupNodeClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.NodeClickEvent.getType());
        }
        private native void setupNodeClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({nodeClick:function(){
                        var param = {"viewer" : arguments[0], "node" : arguments[1], "recordNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tree.events.NodeClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.nodeClick = function(){
                    var param = {"viewer" : arguments[0], "node" : arguments[1], "recordNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tree.events.NodeClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Add a folderContextClick handler.
         * <p>
         * &#010 This method is called when a context click occurs on a folder record.&#010&#010
         *
         * @param handler the folderContextClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addFolderContextClickHandler(com.smartgwt.client.widgets.tree.events.FolderContextClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderContextClickEvent.getType()) == 0) setupFolderContextClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderContextClickEvent.getType());
        }
        private native void setupFolderContextClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({folderContextClick:function(){
                        var param = {"viewer" : arguments[0], "folder" : arguments[1], "recordNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tree.events.FolderContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.folderContextClick = function(){
                    var param = {"viewer" : arguments[0], "folder" : arguments[1], "recordNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tree.events.FolderContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a leafContextClick handler.
         * <p>
         * &#010 This method is called when a context click occurs on a leaf record.&#010&#010
         *
         * @param handler the leafContextClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addLeafContextClickHandler(com.smartgwt.client.widgets.tree.events.LeafContextClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.LeafContextClickEvent.getType()) == 0) setupLeafContextClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.LeafContextClickEvent.getType());
        }
        private native void setupLeafContextClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({leafContextClick:function(){
                        var param = {"viewer" : arguments[0], "leaf" : arguments[1], "recordNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tree.events.LeafContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.leafContextClick = function(){
                    var param = {"viewer" : arguments[0], "leaf" : arguments[1], "recordNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tree.events.LeafContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a nodeContextClick handler.
         * <p>
         * &#010 This method is called when a context click occurs on a leaf or folder record.  Note that&#010 if you set up a callback for <code>nodeContextClick()</code> and&#010 e.g. {@link com.smartgwt.client.widgets.tree.TreeGrid#addLeafContextClickHandler}, then both will fire (in that order) if a leaf&#010 is contextclicked - unless <code>nodeContextClick()</code> returns false, in which case&#010 no further contextClick callbacks will be called.&#010&#010
         *
         * @param handler the nodeContextClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addNodeContextClickHandler(com.smartgwt.client.widgets.tree.events.NodeContextClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.NodeContextClickEvent.getType()) == 0) setupNodeContextClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.NodeContextClickEvent.getType());
        }
        private native void setupNodeContextClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({nodeContextClick:function(){
                        var param = {"viewer" : arguments[0], "node" : arguments[1], "recordNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.tree.events.NodeContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.nodeContextClick = function(){
                    var param = {"viewer" : arguments[0], "node" : arguments[1], "recordNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.tree.events.NodeContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a dataArrived handler.
         * <p>
         * Notification method fired whenever this TreeGrid recieves new data nodes from the &#010 dataSource. Only applies to databound TreeGrids where {@link com.smartgwt.client.widgets.tree.TreeGrid#getData data} is a &#010 {@link com.smartgwt.client..ResultTree} - either explicitly created and applied via {@link com.smartgwt.client.widgets.tree.TreeGrid#setData} or&#010 automatically generated via a {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} call.&#010
         *
         * @param handler the dataArrived handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDataArrivedHandler(com.smartgwt.client.widgets.tree.events.DataArrivedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.tree.events.DataArrivedEvent.getType()) == 0) setupDataArrivedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.DataArrivedEvent.getType());
        }
        private native void setupDataArrivedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dataArrived:function(){
                        var param = {"parentNode" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.tree.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dataArrived = function(){
                    var param = {"parentNode" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.tree.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

    // ********************* Static Methods ***********************





    protected void onInit() {
        super.onInit();
        onInit2();
    }

    private native void onInit2() /*-{

        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self._getNodeTitle = self.getNodeTitle;
        self.getNodeTitle = function(node, recordNum, field) {
            var jObj = this.__ref;
            var nodeJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
            var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
            return jObj.@com.smartgwt.client.widgets.tree.TreeGrid::getNodeTitle(Lcom/smartgwt/client/data/Record;ILcom/smartgwt/client/widgets/grid/ListGridField;)(nodeJ, recordNum, fieldJ);
        };

        self._getIcon = self.getIcon;
        self.getIcon = function(node, defaultState) {
            defaultState = !!defaultState;
            if ($wnd.isc.isA.Number(node)) node = this.data.get(node);
            var jObj = this.__ref;
            var nodeJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
            return jObj.@com.smartgwt.client.widgets.tree.TreeGrid::getIcon(Lcom/smartgwt/client/data/Record;Z)(nodeJ, defaultState);
        };
    }-*/;

    /**
     * &#010 Returns the title to show for a node in the tree column.  If the field specifies the&#010 <code>name</code> attribute, then the current <code>node[field.name]</code> is returned.&#010 Otherwise, the result of calling {@link com.smartgwt.client.widgets.tree.Tree#getTitle} on the node is called.&#010 <br><br>&#010 You can override this method to return a custom title for node titles in the tree column.&#010&#010
     *
     * <b>Note</b> : This is an override point
     *
     * @param node      The node for which the title is being requested.
     * @param recordNum The index of the node.
     * @param field     The field for which the title is being requested.
     * @return the title to display.
     */
    protected native String getNodeTitle(Record node, int recordNum, ListGridField field) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self._getNodeTitle(node.@com.smartgwt.client.core.DataClass::getJsObj()(), recordNum, field.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Get the appropriate icon for a node.&#010 <P>&#010 By default icons are derived from {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} and {@link com.smartgwt.client.widgets.tree.TreeGrid#getNodeIcon nodeIcon}.&#010 Custom icons for individual nodes can be overriden by setting the {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty customIconProperty}&#010 on a node.&#010 <p>&#010 If you want to suppress icons altogether, provide an override of this method that simply&#010 returns null.&#010 <p> &#010 Note that the full icon URL will be derived by applying {@link com.smartgwt.client.widgets.Canvas#getImgURL} to the&#010 value returned from this method.&#010&#010
     * <p>
     * <b>Note</b>: This is an override point
     *
     * @param node tree node in question
     * @param defaultState defaultState
     *
     * @return URL for icon to show for this node
     */
    protected native String getIcon(Record node, boolean defaultState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._getIcon(node.@com.smartgwt.client.core.DataClass::getJsObj()(), defaultState);
    }-*/;

    /**
     * When the user is dragging a droppable element over this grid, this method returns the folder&#010 which would contain the item if dropped. This is the current drop node if the user is hovering&#010 over a folder, or the node's parent if the user is hovering over a leaf.&#010
     *
     * @return target drop folder
     */
    public native TreeNode getDropFolder() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var node = self.getDropFolder();
        if(node == null || node === undefined) return null;
        return @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
    }-*/;

    /**
     * An array of field objects, specifying the order, layout, dynamic calculation, and sorting behavior of each field
     * in the treeGrid object. In TreeGrids, the fields array specifies columns. Each field in the fields array is
     * TreeGridField object. <p> If {@link com.smartgwt.client.widgets.tree.TreeGrid#getDataSource dataSource} is also
     * set, this value acts as a set of overrides as explained in {@link com.smartgwt.client..DataBoundComponent#getFields
     * fields}.
     *
     * @param fields fields Default value is null
     */
    public void setFields(TreeGridField... fields) {
        setAttribute("fields", fields, true);
    }

    /**
     * Synonmy for {#link #getData)
     *
     * @return the underlying tree
     */
    public Tree getTree() {
        return getData();
    }

    public ListGridRecord[] getRecords() {
        Tree tree = getData();
        return tree.getData();
    }
    
    /**
     * You can specify the initial set of data for a databound TreeGrid using this property. The value of this attribute
     * should be a list of <code>parentId</code> linked ${isc.DocUtils.linkForRef('object:TreeNode')}s in a format
     * equivalent to that documented on {@link com.smartgwt.client.widgets.tree.Tree#getData data}.
     * <p/>
     *
     * @param initialData initialData Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInitialData(TreeNode[] data) throws IllegalStateException {
        setAttribute("initialData", data, false);
    }

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component as a tree. <P> This method will create a
     * {@link com.smartgwt.client..ResultTree} to manage tree data, which will subsequently be available as
     * <code>treeGrid.data</code>.  DataSource records returned by the "fetch" operation are linked into a tree
     * structure according to {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} declarations on DataSource fields.  See the
     * {@link com.smartgwt.client.docs.TreeDataBinding} topic for complete details. <P> By default, the created
     * ResultTree will use folder-by-folder load on demand, asking the server for the children of each folder as the
     * user opens it. <P> The {@link com.smartgwt.client..ResultTree} created by <code>fetchData()</code> can be
     * customized by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties} to an
     * Object containing properties and methods to apply to the created ResultTree.  For example, the property that
     * determines whether a node is a folder ({@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}) can be customized, or level-by-level loading can be disabled via {@link
     * com.smartgwt.client..ResultTree#getLoadDataOnDemand loadDataOnDemand}. <P> The callback passed to
     * <code>fetchData</code> will fire once, the first time that data is loaded from the server.  If using
     * folder-by-folder load on demand, use the {@link com.smartgwt.client..ResultTree#dataArrived} notification to be
     * notified each time new nodes are loaded. <P> Note that, if criteria are passed to <code>fetchData()</code>, they
     * will be passed every time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
     * different tree structures from the same DataSource.  However note that the server is expected to always respond
     * with an intact tree - returned nodes which do not have parents are dropped from the dataset and not displayed.
     */
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component as a tree. <P> This method will create a
     * {@link com.smartgwt.client..ResultTree} to manage tree data, which will subsequently be available as
     * <code>treeGrid.data</code>.  DataSource records returned by the "fetch" operation are linked into a tree
     * structure according to {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} declarations on DataSource fields.  See the
     * {@link com.smartgwt.client.docs.TreeDataBinding} topic for complete details. <P> By default, the created
     * ResultTree will use folder-by-folder load on demand, asking the server for the children of each folder as the
     * user opens it. <P> The {@link com.smartgwt.client..ResultTree} created by <code>fetchData()</code> can be
     * customized by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties} to an
     * Object containing properties and methods to apply to the created ResultTree.  For example, the property that
     * determines whether a node is a folder ({@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}) can be customized, or level-by-level loading can be disabled via {@link
     * com.smartgwt.client..ResultTree#getLoadDataOnDemand loadDataOnDemand}. <P> The callback passed to
     * <code>fetchData</code> will fire once, the first time that data is loaded from the server.  If using
     * folder-by-folder load on demand, use the {@link com.smartgwt.client..ResultTree#dataArrived} notification to be
     * notified each time new nodes are loaded. <P> Note that, if criteria are passed to <code>fetchData()</code>, they
     * will be passed every time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
     * different tree structures from the same DataSource.  However note that the server is expected to always respond
     * with an intact tree - returned nodes which do not have parents are dropped from the dataset and not displayed.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     */
    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component as a tree. <P> This method will create a
     * {@link com.smartgwt.client..ResultTree} to manage tree data, which will subsequently be available as
     * <code>treeGrid.data</code>.  DataSource records returned by the "fetch" operation are linked into a tree
     * structure according to {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} declarations on DataSource fields.  See the
     * {@link com.smartgwt.client.docs.TreeDataBinding} topic for complete details. <P> By default, the created
     * ResultTree will use folder-by-folder load on demand, asking the server for the children of each folder as the
     * user opens it. <P> The {@link com.smartgwt.client..ResultTree} created by <code>fetchData()</code> can be
     * customized by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties} to an
     * Object containing properties and methods to apply to the created ResultTree.  For example, the property that
     * determines whether a node is a folder ({@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}) can be customized, or level-by-level loading can be disabled via {@link
     * com.smartgwt.client..ResultTree#getLoadDataOnDemand loadDataOnDemand}. <P> The callback passed to
     * <code>fetchData</code> will fire once, the first time that data is loaded from the server.  If using
     * folder-by-folder load on demand, use the {@link com.smartgwt.client..ResultTree#dataArrived} notification to be
     * notified each time new nodes are loaded. <P> Note that, if criteria are passed to <code>fetchData()</code>, they
     * will be passed every time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
     * different tree structures from the same DataSource.  However note that the server is expected to always respond
     * with an intact tree - returned nodes which do not have parents are dropped from the dataset and not displayed.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback callback to invoke when a fetch is complete.  Fires                                          only
     *                 if server contact was required
     */
    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component as a tree. <P> This method will create a
     * {@link com.smartgwt.client..ResultTree} to manage tree data, which will subsequently be available as
     * <code>treeGrid.data</code>.  DataSource records returned by the "fetch" operation are linked into a tree
     * structure according to {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} and {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} declarations on DataSource fields.  See the
     * {@link com.smartgwt.client.docs.TreeDataBinding} topic for complete details. <P> By default, the created
     * ResultTree will use folder-by-folder load on demand, asking the server for the children of each folder as the
     * user opens it. <P> The {@link com.smartgwt.client..ResultTree} created by <code>fetchData()</code> can be
     * customized by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties} to an
     * Object containing properties and methods to apply to the created ResultTree.  For example, the property that
     * determines whether a node is a folder ({@link com.smartgwt.client.widgets.tree.Tree#getIsFolderProperty
     * isFolderProperty}) can be customized, or level-by-level loading can be disabled via {@link
     * com.smartgwt.client..ResultTree#getLoadDataOnDemand loadDataOnDemand}. <P> The callback passed to
     * <code>fetchData</code> will fire once, the first time that data is loaded from the server.  If using
     * folder-by-folder load on demand, use the {@link com.smartgwt.client..ResultTree#dataArrived} notification to be
     * notified each time new nodes are loaded. <P> Note that, if criteria are passed to <code>fetchData()</code>, they
     * will be passed every time a new "fetch" operation is sent to the server.  This allows you to retrieve multiple
     * different tree structures from the same DataSource.  However note that the server is expected to always respond
     * with an intact tree - returned nodes which do not have parents are dropped from the dataset and not displayed.
     *
     * @param criteria          Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                          is passed in as this argument                      instead of a raw criteria object,
     *                          will be derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback          callback to invoke when a fetch is complete.  Fires
     *                          only if server contact was required
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     */
    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                 is passed in as this argument                      instead of a raw criteria object, will be
     *                 derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback callback to invoke when a fetch is complete.  Fires                                          only
     *                 if server contact was required; see                                          {@link
     *                 com.smartgwt.client..DataBoundComponent#fetchData} for details
     */
    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Retrieves data that matches the provided criteria and displays the matching data in this component. <P> This
     * method behaves exactly like {@link com.smartgwt.client.widgets.tree.TreeGrid#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is automatically set to "substring" so that
     * String-valued fields are matched by case-insensitive substring comparison.
     *
     * @param criteria          Search criteria.                       If a {@link com.smartgwt.client.widgets.form.DynamicForm}
     *                          is passed in as this argument                      instead of a raw criteria object,
     *                          will be derived by calling                      {@link com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}
     * @param callback          callback to invoke when a fetch is complete.  Fires
     *                              only if server contact was required; see
     *                          {@link com.smartgwt.client..DataBoundComponent#fetchData} for details
     * @param requestProperties for databound components only - optional                            additional
     *                          properties to set on the DSRequest that will be issued
     */
    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Return the first selected record in this component.<br><br> This method is appropriate if <code>{@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType}</code> is <code>"single"</code>, or if you only care about the first selected record in a multiple-record selection. To access all selected records, use <code>{@link com.smartgwt.client.widgets.grid.ListGrid#getSelection}</code> instead.
     *
     * @return first selected record, or null if nothing selected
     */
    public native ListGridRecord getSelectedRecord() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedRecord();
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        return retVal;
    }-*/;

    /**
     * Return the pointer to a particular record by record number. Synonym for {@link com.smartgwt.client.widgets.grid.ListGrid#getCellRecord}.
     * @param recordNum row index of record to return.
     *
     * @return Record object for the row.
     */
    public native ListGridRecord getRecord(int recordNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRecord(recordNum);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        return retVal;
    }-*/;

    /**
     * For databound trees, use this attribute to supply a ${isc.DocUtils.linkForRef('ResultTree.rootValue')} for this component's generated data object. <P>  This property allows you to have a particular component navigate a tree starting from any given node as the root.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param treeRootValue treeRootValue Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTreeRootValue(String treeRootValue) throws IllegalStateException {
        setAttribute("treeRootValue", treeRootValue, false);
    }

    /**
     * For databound trees, use this attribute to supply a ${isc.DocUtils.linkForRef('ResultTree.rootValue')} for this component's generated data object. <P>  This property allows you to have a particular component navigate a tree starting from any given node as the root.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param treeRootValue treeRootValue Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTreeRootValue(Integer treeRootValue) throws IllegalStateException {
        setAttribute("treeRootValue", treeRootValue, false);
    }

    /**
     * For databound trees, use this attribute to supply a ${isc.DocUtils.linkForRef('ResultTree.rootValue')} for this component's generated data object. <P>  This property allows you to have a particular component navigate a tree starting from any given node as the root.
     *
     * @return tree root value as String
     */
    public String getTreeRootValue() {
        return getAttribute("treeRootValue");
    }

    /**
     * Add a onFolderDrop handler.
     * <p>
     * Notification method fired when treeNode(s) are dropped into a folder of this TreeGrid.&#010 This method fires before the standard {@link com.smartgwt.client.widgets.tree.TreeGrid#folderDrop} processing occurs&#010 and returning false will suppress that default behavior.&#010
     *
     * @param handler the onFolderDrop handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFolderDropHandler(com.smartgwt.client.widgets.tree.events.FolderDropHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tree.events.FolderDropEvent.getType()) == 0) setupFolderDropEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tree.events.FolderDropEvent.getType());
    }
    private native void setupFolderDropEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onFolderDrop:function(){
                    var param = {"nodes" : arguments[0], "folder" : arguments[1], "index" : arguments[2], "sourceWidget" : arguments[3]};
                    var event = @com.smartgwt.client.widgets.tree.events.FolderDropEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onFolderDrop = function(){
                var param = {"nodes" : arguments[0], "folder" : arguments[1], "index" : arguments[2], "sourceWidget" : arguments[3]};
                var event = @com.smartgwt.client.widgets.tree.events.FolderDropEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            };
        }
    }-*/;
    
    /**
     * This ListGrid suporclass event does not fire on a TreeGrid, use {@link #addFolderDropHandler(com.smartgwt.client.widgets.tree.events.FolderDropHandler)} instead.
     *
     * @param handler the onRecordDrop handler
     * @return {@link HandlerRegistration} used to remove this handler
     *
     * @throws UnsupportedOperationException
     */
    public HandlerRegistration addRecordDropHandler(com.smartgwt.client.widgets.grid.events.RecordDropHandler handler) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This event inherited from ListGrid does not fire for a TreeGrid. Use TreeGrid.addFolgerDropHandler instead");
    }

}



