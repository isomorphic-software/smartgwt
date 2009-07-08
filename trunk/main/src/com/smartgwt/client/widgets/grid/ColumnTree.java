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
 
package com.smartgwt.client.widgets.grid;



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
    * The SmartGWT system supports hierarchical data (also referred to as tree data&#010 due to its "branching" organization) with:&#010 <ul>&#010   <li> the {@link com.smartgwt.client.widgets.tree.Tree} class, which manipulates hierarchical data sets&#010   <li> the TreeGrid widget class, which extends the ListGrid class to visually&#010        present tree data in an expandable/collapsible format.&#010   <li> the ColumnTree widget class, which visually&#010        presents tree data in a so-called &#010        "<a href=http://en.wikipedia.org/wiki/Miller_Columns>Miller Column</a>" format.&#010 </ul>&#010 For information on DataBinding Trees, see {@link com.smartgwt.client.docs.TreeDataBinding}.&#010 <p>&#010 A ColumnTree shows a single branch of the underlying {@link com.smartgwt.client.widgets.tree.Tree} horizontally, from &#010 left to right. Thus, the leftmost column shows all the top-level nodes. When the user clicks&#010 one of those nodes, a new column is shown immediately to the right of the top-level column,&#010 showing the selected node's children. Additional columns are shown as required to present&#010 lower-level children. The behavior of ColumnTree is similar to that of the Browser interface&#010 in the Apple&trade; iTunes&trade; application.

    */
public class ColumnTree extends Layout  implements DataBoundComponent, com.smartgwt.client.widgets.grid.events.HasNodeSelectedHandlers {

    public static ColumnTree getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ColumnTree) obj;
        } else {
            return new ColumnTree(jsObj);
        }
    }


    public ColumnTree(){
        
    }

    public ColumnTree(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.ColumnTree.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************
            
    /**
    * A {@link com.smartgwt.client.widgets.tree.Tree} object consisting of nested {@link com.smartgwt.client.widgets.tree.TreeNode}s to &#010 display in this ColumnTree.  &#010 The <code>data</code> property will typically not be explicitly specified for &#010 databound ColumnTrees, where the data is returned from the server via databound component&#010 methods such as <code>fetchData()</code>
    * Set the {@link com.smartgwt.client.widgets.tree.Tree} object this ColumnTree will view&#010&#010
    *
    * @param data Tree to show. Default value is null
    */
    public void setData(Tree data) {
        setAttribute("data", data.getOrCreateJsObj(), true);
    }
    /**
     * A {@link com.smartgwt.client.widgets.tree.Tree} object consisting of nested {@link com.smartgwt.client.widgets.tree.TreeNode}s to &#010 display in this ColumnTree.  &#010 The <code>data</code> property will typically not be explicitly specified for &#010 databound ColumnTrees, where the data is returned from the server via databound component&#010 methods such as <code>fetchData()</code>
     *
     *
     * @return Returns the {@link com.smartgwt.client.widgets.tree.Tree} object this ColumnTree is viewing&#010&#010
     *
     */
    public Tree getData()  {
            return Tree.getOrCreateRef(getAttributeAsJavaScriptObject("data"));
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ColumnTree#getAutoFetchData autoFetchData} is <code>true</code>, this attribute allows the developer to&#010 specify a textMatchStyle for the initial {@link com.smartgwt.client.widgets.grid.ColumnTree#fetchData} call.
    *
    * @param autoFetchTextMatchStyle autoFetchTextMatchStyle Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAutoFetchTextMatchStyle(String autoFetchTextMatchStyle)  throws IllegalStateException {
        setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ColumnTree#getAutoFetchData autoFetchData} is <code>true</code>, this attribute allows the developer to&#010 specify a textMatchStyle for the initial {@link com.smartgwt.client.widgets.grid.ColumnTree#fetchData} call.
     *
     *
     * @return String
     *
     */
    public String getAutoFetchTextMatchStyle()  {
        return getAttributeAsString("autoFetchTextMatchStyle");
    }

    /**
    * The URL of the base icon for all folder nodes in this columnTree. Note that this URL will&#010 have {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} or {@link com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} appended to &#010 indicate state changes if appropriate - see documentation on  {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons}
    *
    * @param folderIcon folderIcon Default value is "[SKIN]folder.gif"
    */
    public void setFolderIcon(String folderIcon) {
        setAttribute("folderIcon", folderIcon, true);
    }
    /**
     * The URL of the base icon for all folder nodes in this columnTree. Note that this URL will&#010 have {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} or {@link com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} appended to &#010 indicate state changes if appropriate - see documentation on  {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons}
     *
     *
     * @return String
     *
     */
    public String getFolderIcon()  {
        return getAttributeAsString("folderIcon");
    }

    /**
    * This property allows the developer to customize the icon displayed next to a node.&#010 Set <code>node[grid.customIconProperty]</code> to the URL of the desired icon to display and&#010 it will be shown instead of the standard {@link com.smartgwt.client.widgets.grid.ColumnTree#getNodeIcon nodeIcon} for this node.<br>&#010 Note that if {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowCustomIconOpen showCustomIconOpen} &#010 is true for this grid, customized icons for folder nodes will be appended with the &#010 {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} suffix on state change,&#010 as with the standard {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon}.  Also note that for&#010 custom folder icons, the {@link com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} will never be appened.
    *
    * @param customIconProperty customIconProperty Default value is "icon"
    */
    public void setCustomIconProperty(String customIconProperty) {
        setAttribute("customIconProperty", customIconProperty, true);
    }
    /**
     * This property allows the developer to customize the icon displayed next to a node.&#010 Set <code>node[grid.customIconProperty]</code> to the URL of the desired icon to display and&#010 it will be shown instead of the standard {@link com.smartgwt.client.widgets.grid.ColumnTree#getNodeIcon nodeIcon} for this node.<br>&#010 Note that if {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowCustomIconOpen showCustomIconOpen} &#010 is true for this grid, customized icons for folder nodes will be appended with the &#010 {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} suffix on state change,&#010 as with the standard {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon}.  Also note that for&#010 custom folder icons, the {@link com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} will never be appened.
     *
     *
     * @return String
     *
     */
    public String getCustomIconProperty()  {
        return getAttributeAsString("customIconProperty");
    }

    /**
    * The filename of the default icon for all leaf nodes in this grid. To specify a &#010 custom image for an individual node, set the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty} directly on&#010 the node.
    *
    * @param nodeIcon nodeIcon Default value is "[SKIN]file.gif"
    */
    public void setNodeIcon(String nodeIcon) {
        setAttribute("nodeIcon", nodeIcon, true);
    }
    /**
     * The filename of the default icon for all leaf nodes in this grid. To specify a &#010 custom image for an individual node, set the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty} directly on&#010 the node.
     *
     *
     * @return String
     *
     */
    public String getNodeIcon()  {
        return getAttributeAsString("nodeIcon");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons} is true, this suffix will be appended to the&#010 {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} for open folders in this grid.
    *
    * @param openIconSuffix openIconSuffix Default value is "open"
    */
    public void setOpenIconSuffix(String openIconSuffix) {
        setAttribute("openIconSuffix", openIconSuffix, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons} is true, this suffix will be appended to the&#010 {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} for open folders in this grid.
     *
     *
     * @return String
     *
     */
    public String getOpenIconSuffix()  {
        return getAttributeAsString("openIconSuffix");
    }

    /**
    * This suffix will be appended to the {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} for closed folders.&#010 If {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons} is set to <code>false</code> this suffix will also be&#010 appended to open folders' icons.
    *
    * @param closedIconSuffix closedIconSuffix Default value is "closed"
    */
    public void setClosedIconSuffix(String closedIconSuffix) {
        setAttribute("closedIconSuffix", closedIconSuffix, true);
    }
    /**
     * This suffix will be appended to the {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} for closed folders.&#010 If {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons} is set to <code>false</code> this suffix will also be&#010 appended to open folders' icons.
     *
     *
     * @return String
     *
     */
    public String getClosedIconSuffix()  {
        return getAttributeAsString("closedIconSuffix");
    }

    /**
    * If true, show a different icon for <code>open</code> folders than closed folders.&#010 This is achieved by appending the {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} onto the &#010 {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} URL [for example <code>"[SKIN]/folder.gif"</code> might be &#010 replaced by <code>"[SKIN]/folder_open.gif"</code>.<br>&#010 <b>Note</b> If this property is set to <code>false</code> the same icon is shown for&#010 open folders as for closed folders, unless a custom folder icon was specified. This will be&#010 determined by {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} plus the {@link com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix}.
    *
    * @param showOpenIcons showOpenIcons Default value is true
    */
    public void setShowOpenIcons(Boolean showOpenIcons) {
        setAttribute("showOpenIcons", showOpenIcons, true);
    }
    /**
     * If true, show a different icon for <code>open</code> folders than closed folders.&#010 This is achieved by appending the {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} onto the &#010 {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} URL [for example <code>"[SKIN]/folder.gif"</code> might be &#010 replaced by <code>"[SKIN]/folder_open.gif"</code>.<br>&#010 <b>Note</b> If this property is set to <code>false</code> the same icon is shown for&#010 open folders as for closed folders, unless a custom folder icon was specified. This will be&#010 determined by {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} plus the {@link com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowOpenIcons()  {
        return getAttributeAsBoolean("showOpenIcons");
    }

    /**
    * Should folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty}),&#010 show open state images when the folder is opened.&#010 If true, the {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} will be appended to the image URL&#010 (so <code>"customFolder.gif"</code> might be replaced with &#010 <code>"customFolder_open.gif"</code>).<br>&#010 <b>Note</b> that the {@link com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} is never appended to custom folder icons.<br>&#010 Can be overridden at the node level via the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconOpenProperty customIconOpenProperty} property.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showCustomIconOpen showCustomIconOpen Default value is false
    */
    public void setShowCustomIconOpen(Boolean showCustomIconOpen) {
        setAttribute("showCustomIconOpen", showCustomIconOpen, true);
    }
    /**
     * Should folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty}),&#010 show open state images when the folder is opened.&#010 If true, the {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} will be appended to the image URL&#010 (so <code>"customFolder.gif"</code> might be replaced with &#010 <code>"customFolder_open.gif"</code>).<br>&#010 <b>Note</b> that the {@link com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} is never appended to custom folder icons.<br>&#010 Can be overridden at the node level via the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconOpenProperty customIconOpenProperty} property.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowCustomIconOpen()  {
        return getAttributeAsBoolean("showCustomIconOpen");
    }

    /**
    * For folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty}),&#010 this property allows the developer to specify on a per-node basis whether a&#010 open state icon should be displayed when the folder is open.&#010 Set <code>node[treeGrid.customIconOpenProperty]</code> to true to show the open state&#010 icons, or false to suppress this.<br>&#010 If not specified, this behavior is determined by <code>grid.showCustomIconOpen</code>&#010 for this node.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param customIconOpenProperty customIconOpenProperty Default value is "showOpenIcon"
    */
    public void setCustomIconOpenProperty(String customIconOpenProperty) {
        setAttribute("customIconOpenProperty", customIconOpenProperty, true);
    }
    /**
     * For folder nodes showing custom icons (set via the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty}),&#010 this property allows the developer to specify on a per-node basis whether a&#010 open state icon should be displayed when the folder is open.&#010 Set <code>node[treeGrid.customIconOpenProperty]</code> to true to show the open state&#010 icons, or false to suppress this.<br>&#010 If not specified, this behavior is determined by <code>grid.showCustomIconOpen</code>&#010 for this node.
     *
     *
     * @return String
     *
     */
    public String getCustomIconOpenProperty()  {
        return getAttributeAsString("customIconOpenProperty");
    }

    /**
    * For databound columnTree instances, should the entire tree of data be loaded on initial &#010 fetch, or should each coluimn be loaded as needed. If unset the default &#010 ResultTree.loadDataOnDemand setting will be used.
    *
    * @param loadDataOnDemand loadDataOnDemand Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setLoadDataOnDemand(Boolean loadDataOnDemand)  throws IllegalStateException {
        setAttribute("loadDataOnDemand", loadDataOnDemand, false);
    }
    /**
     * For databound columnTree instances, should the entire tree of data be loaded on initial &#010 fetch, or should each coluimn be loaded as needed. If unset the default &#010 ResultTree.loadDataOnDemand setting will be used.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getLoadDataOnDemand()  {
        return getAttributeAsBoolean("loadDataOnDemand");
    }

    /**
    * If set, each column in the ColumnTree will show a header with the title of the selected&#010 node from the column to the left.
    *
    * @param showHeaders showHeaders Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowHeaders(Boolean showHeaders)  throws IllegalStateException {
        setAttribute("showHeaders", showHeaders, false);
    }
    /**
     * If set, each column in the ColumnTree will show a header with the title of the selected&#010 node from the column to the left.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowHeaders()  {
        return getAttributeAsBoolean("showHeaders");
    }

    /**
    * A title for the leftmost column if {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is set (the remaining columns&#010 have their titles derived from the item selected in the column to the left). Ignored&#010 if {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is not set.<br><br>&#010 Note: if you do not want a heading for the first column leave this attribute at its &#010 default value of " ". If you set it to null or the empty string, SmartGWT will&#010 fall back to displaying the field's name in the heading.
    *
    * @param firstColumnTitle firstColumnTitle Default value is " "
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setFirstColumnTitle(String firstColumnTitle)  throws IllegalStateException {
        setAttribute("firstColumnTitle", firstColumnTitle, false);
    }
    /**
     * A title for the leftmost column if {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is set (the remaining columns&#010 have their titles derived from the item selected in the column to the left). Ignored&#010 if {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is not set.<br><br>&#010 Note: if you do not want a heading for the first column leave this attribute at its &#010 default value of " ". If you set it to null or the empty string, SmartGWT will&#010 fall back to displaying the field's name in the heading.
     *
     *
     * @return String
     *
     */
    public String getFirstColumnTitle()  {
        return getAttributeAsString("firstColumnTitle");
    }

    /**
    * If set, and {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is also set, each column's header will show &#010 a count of the number of nodes in that column
    *
    * @param showNodeCount showNodeCount Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowNodeCount(Boolean showNodeCount)  throws IllegalStateException {
        setAttribute("showNodeCount", showNodeCount, false);
    }
    /**
     * If set, and {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is also set, each column's header will show &#010 a count of the number of nodes in that column
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowNodeCount()  {
        return getAttributeAsBoolean("showNodeCount");
    }

    // ********************* Methods ***********************




        /**
         * Whether the indicated column should show a header.  Returns this.showHeaders by default,&#010 override for different behavior.&#010 &#010
         * @param node parent node for the nodes to be shown in the column
     * @param colNum index of the column
         */
        public native void shouldShowHeader(TreeNode node, int colNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.shouldShowHeader(node.@com.smartgwt.client.core.DataClass::getJsObj()(), colNum);
        }-*/;

        /**
         * Returns the title to show for the header of indicated column.  Only called if&#010 {@link com.smartgwt.client.widgets.grid.ColumnTree#shouldShowHeader} returns true for this column.&#010 <P>&#010 By default, returns {@link com.smartgwt.client.widgets.grid.ColumnTree#getFirstColumnTitle firstColumnTitle} for the first column, and for subsequent&#010 columns, the result of {@link com.smartgwt.client.widgets.tree.Tree#getTitle} called on the&#010 <code>node</code> passed to this function.&#010 &#010
         * @param node parent node for the nodes to be shown in the column
     * @param colNum index of the column
         */
        public native void getColumnTitle(TreeNode node, int colNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.getColumnTitle(node.@com.smartgwt.client.core.DataClass::getJsObj()(), colNum);
        }-*/;

        /**
         * Retrieve a record by index.  &#010 <P>&#010 If <code>colNum</code> is passed, returns the record found in that column at that index,&#010 or null if the column doesn't exist or the index is too high.&#010 <P>&#010 With no <code>colNum</code> parameter, a record's index is it's position counting from the&#010 first record of the first column and including all records in each column. Note that both&#010 index and colNum are zero-based - so the first column is column 0, not column 1.&#010 &#010
         * @param index index of record to return.
         *
         * @return node at the specified index
         */
        public native TreeNode getRecord(int index) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.getRecord(index);
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.tree.TreeNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;

        /**
         * Retrieve a record by index.  &#010 <P>&#010 If <code>colNum</code> is passed, returns the record found in that column at that index,&#010 or null if the column doesn't exist or the index is too high.&#010 <P>&#010 With no <code>colNum</code> parameter, a record's index is it's position counting from the&#010 first record of the first column and including all records in each column. Note that both&#010 index and colNum are zero-based - so the first column is column 0, not column 1.&#010 &#010
         * @param index index of record to return.
     * @param colNum optional index of the column
         *
         * @return node at the specified index
         */
        public native TreeNode getRecord(int index, int colNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.getRecord(index, colNum);
            if(ret == null || ret === undefined) return null;
            return @com.smartgwt.client.widgets.tree.TreeNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }-*/;

        /**
         * Get the appropriate icon for a node.&#010 <P>&#010 By default icons are derived from {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} and {@link com.smartgwt.client.widgets.grid.ColumnTree#getNodeIcon nodeIcon}.&#010 Custom icons for individual nodes can be overriden by setting the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty}&#010 on a node.&#010 <p>&#010 If you want to suppress icons altogether, provide an override of this method that simply&#010 returns null.&#010 <p> &#010 Note that the full icon URL will be derived by applying {@link com.smartgwt.client.widgets.Canvas#getImgURL} to the&#010 value returned from this method.&#010&#010
         * @param node tree node in question
         *
         * @return URL for icon to show for this node
         */
        public native String getIcon(TreeNode node) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getIcon(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;













    // ********************* Static Methods ***********************





    
    public void setFields(ListGridField... fields) {
        setAttribute("fields", fields, true);
    }


    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons} is true, this suffix will be
     * appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} when the user
     * drop-hovers over some folder.
     *
     * @param dropIconSuffix dropIconSuffix Default value is "drop"
     */
    public void setDropIconSuffix(String dropIconSuffix) {
        setAttribute("dropIconSuffix", dropIconSuffix, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons} is true, this suffix will be
     * appended to the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} when the user
     * drop-hovers over some folder.
     *
     * @return String
     */
    public String getDropIconSuffix() {
        return getAttributeAsString("dropIconSuffix");
    }

    /**
     * If true, when the user drags a droppable target over a folder in this TreeGrid, show  a different icon folder
     * icon. This is achieved by appending the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix
     * dropIconSuffix} onto the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL (for
     * example <code>"[SKIN]/folder.gif"</code> may be replaced by <code>"[SKIN]/folder_drop.gif"</code>).
     *
     * @param showDropIcons showDropIcons Default value is true
     */
    public void setShowDropIcons(Boolean showDropIcons) {
        setAttribute("showDropIcons", showDropIcons, true);
    }

    /**
     * If true, when the user drags a droppable target over a folder in this TreeGrid, show  a different icon folder
     * icon. This is achieved by appending the {@link com.smartgwt.client.widgets.tree.TreeGrid#getDropIconSuffix
     * dropIconSuffix} onto the {@link com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon folderIcon} URL (for
     * example <code>"[SKIN]/folder.gif"</code> may be replaced by <code>"[SKIN]/folder_drop.gif"</code>).
     *
     * @return Boolean
     */
    public Boolean getShowDropIcons() {
        return getAttributeAsBoolean("showDropIcons");
    }

    public native void deselectRecord(Record record, int colNum)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.deselectRecord(recordJS, colNum);
     }-*/;

    /**
     * Deselect a {@link com.smartgwt.client.data.Record} passed in explicitly, or by index. <P> Synonym for
     * <code>selectRecord(record, false)</code>
     *
     * @param record row number to deselect
     * @param colNum the column number
     */
    public native void deselectRecord(int record, int colNum)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record, colNum);
     }-*/;

    /**
     * Deselect a list of {@link com.smartgwt.client.data.Record}s passed in explicitly, or by index. <P> Synonym
     * for <code>selectRecords(records, false)</code>
     *
     * @param records records (or row numbers) to deselect
     * @param colNum the col num
     */
    public native void deselectRecords(int[] records, int colNum)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.deselectRecords(recordsJS, colNum);
     }-*/;

    /**
     * Deselect a list of {@link com.smartgwt.client.data.Record}s passed in explicitly, or by index. <P> Synonym
     * for <code>selectRecords(records, false)</code>
     *
     * @param records records (or row numbers) to deselect
     */
    public native void deselectRecord(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.deselectRecord(recordsJS);
     }-*/;

    /**
     * Deselect a list of {@link com.smartgwt.client.data.Record}s passed in explicitly, or by index. <P> Synonym
     * for <code>selectRecords(records, false)</code>
     *
     * @param records records (or row numbers) to deselect
     * @param colNum  the col num
     */
    public native void deselectRecords(Record[] records, int colNum)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.deselectRecords(recordsJS, colNum);
     }-*/;

    /**
     * Select/deselect a {@link com.smartgwt.client.data.Record} passed in explicitly, or by index.
     *
     * @param record   record (or row number) to select
     * @param newState new selection state (if null, defaults to true)
     * @param colNum   Column number
     */
    public native void selectRecord(int record, boolean newState, int colNum)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record, newState, colNum);
     }-*/;

    /**
     * Select/deselect a {@link com.smartgwt.client.data.Record} passed in explicitly, or by index.
     *
     * @param record   record (or row number) to select
     * @param newState new selection state (if null, defaults to true)
     * @param colNum   Column number
     */
    public native void selectRecord(Record record, boolean newState, int colNum)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS, newState, colNum);
     }-*/;

    /**
     * Select/deselect a list of {@link com.smartgwt.client.data.Record}s passed in explicitly, or by index.
     *
     * @param records  records (or row numbers) to select
     * @param newState new selection state (if null, defaults to true)
     * @param colNum   Column number
     */
    public native void selectRecords(int[] records, boolean newState, int colNum)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecords(recordsJS, newState, colNum);
     }-*/;


    /**
     * Select/deselect a list of {@link com.smartgwt.client.data.Record}s passed in explicitly, or by index.
     *
     * @param records  records (or row numbers) to select
     * @param newState new selection state (if null, defaults to true)
     * @param colNum   Column number
     */
    public native void selectRecords(Record[] records, boolean newState, int colNum)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS, newState, colNum);
     }-*/;

     /**
     * Returns the array of objects selected in the specified column of the columnTree
     *
     * @param colNum Column within the columnTree to return the selection for
     * @return (Array of ListGridRecord) list of records, empty list if nothing selected
     */
    public native ListGridRecord[] getSelection(int colNum)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var records = self.getSelection(colNum);
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
    }-*/;

    /**
     * Select all records in the supplied column (the first column if none is passed)&#010&#010
     * @param colNum Column number
     */
    public native void selectAllRecords(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectAllRecords(colNum);
    }-*/;

    /**
     * Deselect all records in the supplied column (the first column if none is passed)&#010&#010
     * @param colNum Column number
     */
    public native void deselectAllRecords(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectAllRecords(colNum);
    }-*/;

    /**
     * Whether at least one item is selected in the supplied column (the first column if none is passed)&#010&#010
     * @param colNum Column number
     *
     * @return true == at least one item is selected in the supplied column,  false == nothing at all is selected in the supplied column (note that there may be selections&#010 in other columns in this columnTree)
     */
    public native Boolean anySelected(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.anySelected(colNum);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;


    /**
     * Add a onNodeSelected handler.
     * <p>
     * Notification method fired when a node is selected. Return false to suppress default&#010 behavior.&#010
     *
     * @param handler the onNodeSelected handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addNodeSelectedHandler(com.smartgwt.client.widgets.grid.events.NodeSelectedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.NodeSelectedEvent.getType()) == 0) setupNodeSelectedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.NodeSelectedEvent.getType());
    }
    private native void setupNodeSelectedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onNodeSelected:function(){
                    var param = {"column" : arguments[0], "node" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.grid.events.NodeSelectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onNodeSelected = function(){
                var param = {"column" : arguments[0], "node" : arguments[1]};
                var event = @com.smartgwt.client.widgets.grid.events.NodeSelectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            };
        }
    }-*/;    






    // ********************* DataBoundComponent Properties / Attributes ***********************

    public void setDataPageSize(int dataPageSize) {
        setAttribute("dataPageSize", dataPageSize, true);
    }

    public int getDataPageSize() {
        return getAttributeAsInt("dataPageSize");
    }

    public void setUseAllDataSourceFields(Boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    public Boolean getUseAllDataSourceFields() {
        return getAttributeAsBoolean("useAllDataSourceFields");
    }

    public void setShowHiddenFields(Boolean showHiddenFields) {
        setAttribute("showHiddenFields", showHiddenFields, true);
    }

    public Boolean getShowHiddenFields() {
        return getAttributeAsBoolean("showHiddenFields");
    }

    public void setShowDetailFields(Boolean showDetailFields) {
        setAttribute("showDetailFields", showDetailFields, true);
    }

    public Boolean getShowDetailFields() {
        return getAttributeAsBoolean("showDetailFields");
    }

    public void setShowComplexFields(Boolean showComplexFields) {
        setAttribute("showComplexFields", showComplexFields, true);
    }

    public Boolean getShowComplexFields() {
        return getAttributeAsBoolean("showComplexFields");
    }

    public void setFetchOperation(String fetchOperation) {
        setAttribute("fetchOperation", fetchOperation, true);
    }

    public String getFetchOperation() {
        return getAttributeAsString("fetchOperation");
    }

    public void setUpdateOperation(String updateOperation) {
        setAttribute("updateOperation", updateOperation, true);
    }

    public String getUpdateOperation() {
        return getAttributeAsString("updateOperation");
    }

    public void setAddOperation(String addOperation) {
        setAttribute("addOperation", addOperation, true);
    }

    public String getAddOperation() {
        return getAttributeAsString("addOperation");
    }

    public void setRemoveOperation(String removeOperation) {
        setAttribute("removeOperation", removeOperation, true);
    }

    public String getRemoveOperation() {
        return getAttributeAsString("removeOperation");
    }

    public void setExportFields(String[] exportFields) {
        setAttribute("exportFields", exportFields, true);
    }
    public String[] getExportFields()  {
         return getAttributeAsStringArray("exportFields");
     }

    public void setExportAll(Boolean exportAll) {
        setAttribute("exportAll", exportAll, true);
    }

    public Boolean getExportAll() {
        return getAttributeAsBoolean("exportAll");
    }

    public void setPreventDuplicates(Boolean preventDuplicates) throws IllegalStateException {
        setAttribute("preventDuplicates", preventDuplicates, false);
    }

    public Boolean getPreventDuplicates() {
        return getAttributeAsBoolean("preventDuplicates");
    }

    public void setDuplicateDragMessage(String duplicateDragMessage) throws IllegalStateException {
        setAttribute("duplicateDragMessage", duplicateDragMessage, false);
    }

    public String getDuplicateDragMessage() {
        return getAttributeAsString("duplicateDragMessage");
    }

    public void setAddDropValues(Boolean addDropValues) {
        setAttribute("addDropValues", addDropValues, true);
    }

    public Boolean getAddDropValues() {
        return getAttributeAsBoolean("addDropValues");
    }

    public void setDropValues(Map dropValues) {
         setAttribute("dropValues", dropValues, true);
     }

    public Map getDropValues()  {
         return getAttributeAsMap("dropValues");
     }

    public void setUseFlatFields(Boolean useFlatFields) throws IllegalStateException {
        setAttribute("useFlatFields", useFlatFields, false);
    }

    public Boolean getUseFlatFields() {
        return getAttributeAsBoolean("useFlatFields");
    }

    public void setHiliteProperty(String hiliteProperty) {
        setAttribute("hiliteProperty", hiliteProperty, true);
    }

    public String getHiliteProperty() {
        return getAttributeAsString("hiliteProperty");
    }

    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }

    public DragDataAction getDragDataAction() {
        return (DragDataAction) EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    public void setDragTrackerStyle(String dragTrackerStyle) {
        setAttribute("dragTrackerStyle", dragTrackerStyle, true);
    }

    public String getDragTrackerStyle() {
        return getAttributeAsString("dragTrackerStyle");
    }

    public void setCanAddFormulaFields(Boolean canAddFormulaFields) {
        setAttribute("canAddFormulaFields", canAddFormulaFields, true);
    }

    public native void addSummaryField() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.addSummaryField();
     }-*/;

    public native void addFormulaField() /*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       self.addFormulaField();
    }-*/;

    public Boolean getCanAddFormulaFields() {
        return getAttributeAsBoolean("canAddFormulaFields");
    }

    public void setAddFormulaFieldText(String addFormulaFieldText) {
        setAttribute("addFormulaFieldText", addFormulaFieldText, true);
    }

    public String getAddFormulaFieldText() {
        return getAttributeAsString("addFormulaFieldText");
    }

    public void setEditFormulaFieldText(String editFormulaFieldText) {
        setAttribute("editFormulaFieldText", editFormulaFieldText, true);
    }

    public String getEditFormulaFieldText() {
        return getAttributeAsString("editFormulaFieldText");
    }

    public void setCanAddSummaryFields(Boolean canAddSummaryFields) {
        setAttribute("canAddSummaryFields", canAddSummaryFields, true);
    }

    public Boolean getCanAddSummaryFields() {
        return getAttributeAsBoolean("canAddSummaryFields");
    }

    public void setAddSummaryFieldText(String addSummaryFieldText) {
        setAttribute("addSummaryFieldText", addSummaryFieldText, true);
    }

    public String getAddSummaryFieldText() {
        return getAttributeAsString("addSummaryFieldText");
    }

    public void setEditSummaryFieldText(String editSummaryFieldText) {
        setAttribute("editSummaryFieldText", editSummaryFieldText, true);
    }

    public String getEditSummaryFieldText() {
        return getAttributeAsString("editSummaryFieldText");
    }

    // ********************* Methods ***********************


    public native void selectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS);
     }-*/;

    public native void selectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    public native void selectRecord(int record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record, newState);
     }-*/;

    public native void selectRecord(Record record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS, newState);
     }-*/;

    public native void selectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecord(recordsJS);
     }-*/;

    public native void selectRecords(int[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void selectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS);
     }-*/;

    public native void selectRecords(Record[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void deselectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.deselectRecord(recordJS);
     }-*/;

    public native void deselectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    public native void deselectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void deselectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void selectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.selectAllRecords();
     }-*/;

    public native void deselectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.deselectAllRecords();
     }-*/;

    public native Boolean anySelected() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var retVal =self.anySelected();
         if(retVal == null || retVal === undefined) {
             return null;
         } else {
             return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
         }
     }-*/;

    public native void enableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID);
     }-*/;

    public native void enableHilite(String hiliteID, boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID, enable);
     }-*/;

    public native void disableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHilite(hiliteID);
     }-*/;

    public native void enableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting();
     }-*/;

    public native void enableHiliting(boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting(enable);
     }-*/;

    public native void disableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHiliting();
     }-*/;

    public native Record[] getDragData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.getDragData();
        return @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
     }-*/;

    public native void transferSelectedData(DataBoundComponent source) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
     }-*/;

    public native void transferSelectedData(DataBoundComponent source, int index) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
     }-*/;

    public native int getRecordIndex(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getRecordIndex(record);
     }-*/;

    public native String getTitleFieldValue(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getTitleFieldValue(record);
     }-*/;

    public void setTitleField(String titleField) {
        setAttribute("titleField", titleField, true);
    }

    public String getTitleField()  {
        return getAttributeAsString("titleField");
    }

    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    public void setAutoFetchData(Boolean autoFetchData)  throws IllegalStateException {
        setAttribute("autoFetchData", autoFetchData, false);
    }

    public Boolean getAutoFetchData()  {
        return getAttributeAsBoolean("autoFetchData");
    }

    public void setAutoFetchAsFilter(Boolean autoFetchAsFilter)  throws IllegalStateException {
        setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }

    public Boolean getAutoFetchAsFilter()  {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }

    public void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    public Criteria getInitialCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("initialCriteria"));
    }

    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

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

    public native void filterData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData();
    }-*/;

    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

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

    public native void invalidateCache() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;

}





