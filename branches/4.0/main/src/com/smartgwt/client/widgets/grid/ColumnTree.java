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
 
package com.smartgwt.client.widgets.grid;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * The Smart GWT system supports hierarchical data (also referred to as tree data due to its "branching" organization)
 * with: <ul>   <li> the {@link com.smartgwt.client.widgets.tree.Tree} class, which manipulates hierarchical data sets  
 * <li> the TreeGrid widget class, which extends the ListGrid class to visually        present tree data in an
 * expandable/collapsible format.   <li> the ColumnTree widget class, which visually        presents tree data in a
 * so-called         "<a href=http://en.wikipedia.org/wiki/Miller_Columns>Miller Column</a>" format. </ul> For information
 * on DataBinding Trees, see {@link com.smartgwt.client.docs.TreeDataBinding}. <p> A ColumnTree shows a single branch of
 * the underlying {@link com.smartgwt.client.widgets.tree.Tree} horizontally, from  left to right. Thus, the leftmost
 * column shows all the top-level nodes. When the user clicks one of those nodes, a new column is shown immediately to the
 * right of the top-level column, showing the selected node's children. Additional columns are shown as required to present
 * lower-level children. The behavior of ColumnTree is similar to that of the Browser interface in the Apple&trade;
 * iTunes&trade; application.
 */
public class ColumnTree extends Layout  implements DataBoundComponent, com.smartgwt.client.widgets.grid.events.HasNodeSelectedHandlers {

    public native static ColumnTree getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("ColumnTree",jsObj);
        } else {
            return instance;
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }



    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc["ColumnTree"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc["ColumnTree"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public ColumnTree(){
        scClassName = "ColumnTree";
    }

    public ColumnTree(JavaScriptObject jsObj){
        scClassName = "ColumnTree";
        setJavaScriptObject(jsObj);
        
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Ljava/lang/String;Z)(widget.getID(), true);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************




    /**
     * When using {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowMultipleColumns single-column mode}, this is the
     * "Back" button that you see hovering above the column UI and that allows backward navigation.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getBackButton() throws IllegalStateException {
        errorIfNotCreated("backButton");
        return IButton.getOrCreateRef(getAttributeAsJavaScriptObject("backButton"));
    }


    /**
     * When using {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowMultipleColumns single-column mode}, this i18n
     * property dictates the title for the {@link com.smartgwt.client.widgets.grid.ColumnTree#getBackButton button} docked to
     * the top left  which allows navigation back through the column tree.
     *
     * @param backButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Back"
     */
    public void setBackButtonTitle(String backButtonTitle) {
        setAttribute("backButtonTitle", backButtonTitle, true);
    }

    /**
     * When using {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowMultipleColumns single-column mode}, this i18n
     * property dictates the title for the {@link com.smartgwt.client.widgets.grid.ColumnTree#getBackButton button} docked to
     * the top left  which allows navigation back through the column tree.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getBackButtonTitle()  {
        return getAttributeAsString("backButtonTitle");
    }


    /**
     * This suffix will be appended to the {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} for
     * closed folders. If {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons} is set to
     * <code>false</code> this suffix will also be appended to open folders' icons.
     *
     * @param closedIconSuffix . See {@link com.smartgwt.client.docs.String String}. Default value is "closed"
     */
    public void setClosedIconSuffix(String closedIconSuffix) {
        setAttribute("closedIconSuffix", closedIconSuffix, true);
    }

    /**
     * This suffix will be appended to the {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} for
     * closed folders. If {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons} is set to
     * <code>false</code> this suffix will also be appended to open folders' icons.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getClosedIconSuffix()  {
        return getAttributeAsString("closedIconSuffix");
    }


    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * Instance of ListGrid used to display each column of the tree.
     *
     * @return null
     */
    public ListGrid getColumn()  {
        return null;
    }



    /**
     * This property allows the developer to rename the  {@link com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon
     * default node.showOpenIcon} property.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param customIconOpenProperty . See {@link com.smartgwt.client.docs.String String}. Default value is "showOpenIcon"
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setShowCustomIconOpen
     */
    public void setCustomIconOpenProperty(String customIconOpenProperty) {
        setAttribute("customIconOpenProperty", customIconOpenProperty, true);
    }

    /**
     * This property allows the developer to rename the  {@link com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon
     * default node.showOpenIcon} property.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#getShowCustomIconOpen
     */
    public String getCustomIconOpenProperty()  {
        return getAttributeAsString("customIconOpenProperty");
    }


    /**
     * This property allows the developer to customize the icon displayed next to a node. Set
     * <code>node[grid.customIconProperty]</code> to the URL of the desired icon to display and it will be shown instead of the
     * standard {@link com.smartgwt.client.widgets.grid.ColumnTree#getNodeIcon nodeIcon} for this node.<br> Note that if {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getShowCustomIconOpen showCustomIconOpen}  is true for this grid, customized
     * icons for folder nodes will be appended with the  {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix
     * openIconSuffix} suffix on state change, as with the standard {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon}.  Also note that for custom folder icons, the
     * {@link com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} will never be appended.
     *
     * @param customIconProperty . See {@link com.smartgwt.client.docs.String String}. Default value is "icon"
     */
    public void setCustomIconProperty(String customIconProperty) {
        setAttribute("customIconProperty", customIconProperty, true);
    }

    /**
     * This property allows the developer to customize the icon displayed next to a node. Set
     * <code>node[grid.customIconProperty]</code> to the URL of the desired icon to display and it will be shown instead of the
     * standard {@link com.smartgwt.client.widgets.grid.ColumnTree#getNodeIcon nodeIcon} for this node.<br> Note that if {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getShowCustomIconOpen showCustomIconOpen}  is true for this grid, customized
     * icons for folder nodes will be appended with the  {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix
     * openIconSuffix} suffix on state change, as with the standard {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon}.  Also note that for custom folder icons, the
     * {@link com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} will never be appended.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getCustomIconProperty()  {
        return getAttributeAsString("customIconProperty");
    }


    /**
     * A {@link com.smartgwt.client.widgets.tree.Tree} object consisting of nested {@link
     * com.smartgwt.client.widgets.tree.TreeNode}s to  display in this ColumnTree.   The <code>data</code> property will
     * typically not be explicitly specified for  databound ColumnTrees, where the data is returned from the server via
     * databound component methods such as <code>fetchData()</code>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the {@link com.smartgwt.client.widgets.tree.Tree} object this ColumnTree will view
     *
     * @param data Tree to show. Default value is null
     */
    public void setData(Tree data) {
        setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }

    /**
     * A {@link com.smartgwt.client.widgets.tree.Tree} object consisting of nested {@link
     * com.smartgwt.client.widgets.tree.TreeNode}s to  display in this ColumnTree.   The <code>data</code> property will
     * typically not be explicitly specified for  databound ColumnTrees, where the data is returned from the server via
     * databound component methods such as <code>fetchData()</code>
     *
     * @return Returns the {@link com.smartgwt.client.widgets.tree.Tree} object this ColumnTree is viewing
     */
    public Tree getData()  {
        return Tree.getOrCreateRef(getAttributeAsJavaScriptObject("data"));
    }


    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#fetchData ColumnTree.fetchData}.  If a pre-existing ResultSet is passed to
     * setData() instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode fetchMode} applies.
     *
     * @param dataFetchMode dataFetchMode Default value is "paged"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setDataFetchMode(FetchMode dataFetchMode) {
        setAttribute("dataFetchMode", dataFetchMode == null ? null : dataFetchMode.getValue(), true);
    }

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#fetchData ColumnTree.fetchData}.  If a pre-existing ResultSet is passed to
     * setData() instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode fetchMode} applies.
     *
     * @return FetchMode
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public FetchMode getDataFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }




    /**
     * A title for the leftmost column if {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is set
     * (the remaining columns have their titles derived from the item selected in the column to the left). Ignored if {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is not set.<br><br> Note: if you do not want a
     * heading for the first column leave this attribute at its  default value of " ". If you set it to null or the empty
     * string, Smart GWT will fall back to displaying the field's name in the heading.
     *
     * @param firstColumnTitle . See {@link com.smartgwt.client.docs.String String}. Default value is " "
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFirstColumnTitle(String firstColumnTitle)  throws IllegalStateException {
        setAttribute("firstColumnTitle", firstColumnTitle, false);
    }

    /**
     * A title for the leftmost column if {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is set
     * (the remaining columns have their titles derived from the item selected in the column to the left). Ignored if {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is not set.<br><br> Note: if you do not want a
     * heading for the first column leave this attribute at its  default value of " ". If you set it to null or the empty
     * string, Smart GWT will fall back to displaying the field's name in the heading.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getFirstColumnTitle()  {
        return getAttributeAsString("firstColumnTitle");
    }


    /**
     * The URL of the base icon for all folder nodes in this columnTree. Note that this URL will have {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} or {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} appended to  indicate state changes if
     * appropriate - see documentation on  {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons}
     *
     * @param folderIcon . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKIN]folder.gif"
     */
    public void setFolderIcon(String folderIcon) {
        setAttribute("folderIcon", folderIcon, true);
    }

    /**
     * The URL of the base icon for all folder nodes in this columnTree. Note that this URL will have {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} or {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} appended to  indicate state changes if
     * appropriate - see documentation on  {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons}
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     */
    public String getFolderIcon()  {
        return getAttributeAsString("folderIcon");
    }



    /**
     * For databound columnTree instances, should the entire tree of data be loaded on initial  fetch, or should each column be
     * loaded as needed. If unset the default  ResultTree.loadDataOnDemand setting will be used.
     *
     * @param loadDataOnDemand loadDataOnDemand Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setLoadDataOnDemand(Boolean loadDataOnDemand)  throws IllegalStateException {
        setAttribute("loadDataOnDemand", loadDataOnDemand, false);
    }

    /**
     * For databound columnTree instances, should the entire tree of data be loaded on initial  fetch, or should each column be
     * loaded as needed. If unset the default  ResultTree.loadDataOnDemand setting will be used.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getLoadDataOnDemand()  {
        return getAttributeAsBoolean("loadDataOnDemand");
    }


    /**
     * The filename of the default icon for all leaf nodes in this grid. To specify a  custom image for an individual node, set
     * the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty} directly on the node.
     *
     * @param nodeIcon . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKIN]file.gif"
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_miller_columns" target="examples">Miller Columns Example</a>
     */
    public void setNodeIcon(String nodeIcon) {
        setAttribute("nodeIcon", nodeIcon, true);
    }

    /**
     * The filename of the default icon for all leaf nodes in this grid. To specify a  custom image for an individual node, set
     * the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty} directly on the node.
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_miller_columns" target="examples">Miller Columns Example</a>
     */
    public String getNodeIcon()  {
        return getAttributeAsString("nodeIcon");
    }


    /**
     * If {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons} is true, this suffix will be
     * appended to the {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} for open folders in this
     * grid.
     *
     * @param openIconSuffix . See {@link com.smartgwt.client.docs.String String}. Default value is "open"
     */
    public void setOpenIconSuffix(String openIconSuffix) {
        setAttribute("openIconSuffix", openIconSuffix, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons} is true, this suffix will be
     * appended to the {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} for open folders in this
     * grid.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getOpenIconSuffix()  {
        return getAttributeAsString("openIconSuffix");
    }


    /**
     * Should folder nodes showing custom icons (set via the {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty}), show open state images when the
     * folder is opened. If true, the {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} will
     * be appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with 
     * <code>"customFolder_open.gif"</code>).<br> <b>Note</b> that the {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} is never appended to custom folder
     * icons.<br> Can be overridden at the node level via the default property {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon showOpenIcon} and that property can be renamed via {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconOpenProperty customIconOpenProperty}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showCustomIconOpen showCustomIconOpen Default value is false
     */
    public void setShowCustomIconOpen(Boolean showCustomIconOpen) {
        setAttribute("showCustomIconOpen", showCustomIconOpen, true);
    }

    /**
     * Should folder nodes showing custom icons (set via the {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty}), show open state images when the
     * folder is opened. If true, the {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} will
     * be appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with 
     * <code>"customFolder_open.gif"</code>).<br> <b>Note</b> that the {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} is never appended to custom folder
     * icons.<br> Can be overridden at the node level via the default property {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon showOpenIcon} and that property can be renamed via {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconOpenProperty customIconOpenProperty}.
     *
     * @return Boolean
     */
    public Boolean getShowCustomIconOpen()  {
        return getAttributeAsBoolean("showCustomIconOpen");
    }


    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is  given a DataSource but no
     * <code>component.fields</code>. <p> The <code>detail</code> property is used on DataSource fields to mark fields that 
     * shouldn't appear by default in a view that tries to show many records in a small space.
     *
     * @param showDetailFields showDetailFields Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public void setShowDetailFields(Boolean showDetailFields)  throws IllegalStateException {
        setAttribute("showDetailFields", showDetailFields, false);
    }

    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is  given a DataSource but no
     * <code>component.fields</code>. <p> The <code>detail</code> property is used on DataSource fields to mark fields that 
     * shouldn't appear by default in a view that tries to show many records in a small space.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getShowDetailFields()  {
        return getAttributeAsBoolean("showDetailFields");
    }


    /**
     * If set, each column in the ColumnTree will show a header with the title of the selected node from the column to the
     * left.
     *
     * @param showHeaders showHeaders Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowHeaders(Boolean showHeaders)  throws IllegalStateException {
        setAttribute("showHeaders", showHeaders, false);
    }

    /**
     * If set, each column in the ColumnTree will show a header with the title of the selected node from the column to the
     * left.
     *
     * @return Boolean
     */
    public Boolean getShowHeaders()  {
        return getAttributeAsBoolean("showHeaders");
    }


    /**
     * When set to false, only displays a single column at a time, showing a slide animation  when moving between columns.
     *
     * @param showMultipleColumns showMultipleColumns Default value is null
     */
    public void setShowMultipleColumns(Boolean showMultipleColumns) {
        setAttribute("showMultipleColumns", showMultipleColumns, true);
    }

    /**
     * When set to false, only displays a single column at a time, showing a slide animation  when moving between columns.
     *
     * @return Boolean
     */
    public Boolean getShowMultipleColumns()  {
        return getAttributeAsBoolean("showMultipleColumns");
    }


    /**
     * If set, and {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is also set, each column's
     * header will show  a count of the number of nodes in that column
     *
     * @param showNodeCount showNodeCount Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowNodeCount(Boolean showNodeCount)  throws IllegalStateException {
        setAttribute("showNodeCount", showNodeCount, false);
    }

    /**
     * If set, and {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is also set, each column's
     * header will show  a count of the number of nodes in that column
     *
     * @return Boolean
     */
    public Boolean getShowNodeCount()  {
        return getAttributeAsBoolean("showNodeCount");
    }


    /**
     * If true, show a different icon for <code>open</code> folders than closed folders. This is achieved by appending the
     * {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} onto the  {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} URL [for example <code>"[SKIN]/folder.gif"</code>
     * might be  replaced by <code>"[SKIN]/folder_open.gif"</code>.<br> <b>Note</b> If this property is set to
     * <code>false</code> the same icon is shown for open folders as for closed folders, unless a custom folder icon was
     * specified. This will be determined by {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} plus
     * the {@link com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix}.
     *
     * @param showOpenIcons showOpenIcons Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_miller_columns" target="examples">Miller Columns Example</a>
     */
    public void setShowOpenIcons(Boolean showOpenIcons) {
        setAttribute("showOpenIcons", showOpenIcons, true);
    }

    /**
     * If true, show a different icon for <code>open</code> folders than closed folders. This is achieved by appending the
     * {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} onto the  {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} URL [for example <code>"[SKIN]/folder.gif"</code>
     * might be  replaced by <code>"[SKIN]/folder_open.gif"</code>.<br> <b>Note</b> If this property is set to
     * <code>false</code> the same icon is shown for open folders as for closed folders, unless a custom folder icon was
     * specified. This will be determined by {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} plus
     * the {@link com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix}.
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_miller_columns" target="examples">Miller Columns Example</a>
     */
    public Boolean getShowOpenIcons()  {
        return getAttributeAsBoolean("showOpenIcons");
    }

    // ********************* Methods ***********************
	/**
     * Returns the title to show for the header of indicated column.  Only called if {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#shouldShowHeader ColumnTree.shouldShowHeader} returns true for this column.
     * <P> By default, returns {@link com.smartgwt.client.widgets.grid.ColumnTree#getFirstColumnTitle firstColumnTitle} for the
     * first column, and for subsequent columns, the result of {@link com.smartgwt.client.widgets.tree.Tree#getTitle
     * this.data.getTitle()} called on the <code>node</code> passed to this function.
     * @param node parent node for the nodes to be shown in the column
     * @param colNum index of the column
     */
    public native void getColumnTitle(TreeNode node, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getColumnTitle(node.@com.smartgwt.client.core.DataClass::getJsObj()(), colNum);
    }-*/;
	/**
     * Get the appropriate icon for a node. <P> By default icons are derived from {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} and {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getNodeIcon nodeIcon}. Custom icons for individual nodes can be overridden
     * by setting the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty} on a node.
     * <p> If you want to suppress icons altogether, provide an override of this method that simply returns null. <p>  Note
     * that the full icon URL will be derived by applying {@link com.smartgwt.client.widgets.Canvas#getImgURL Canvas.getImgURL}
     * to the value returned from this method.
     * @param node tree node in question
     *
     * @return URL for the icon to show for this node
     */
    public native String getIcon(TreeNode node) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getIcon(node.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	/**
     * Retrieve a record by index.   <P> If <code>colNum</code> is passed, returns the record found in that column at that
     * index, or null if the column doesn't exist or the index is too high. <P> With no <code>colNum</code> parameter, a
     * record's index is it's position counting from the first record of the first column and including all records in each
     * column. Note that both index and colNum are zero-based - so the first column is column 0, not column 1.
     * @param index index of record to return.
     *
     * @return node at the specified index
     */
    public native TreeNode getRecord(int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRecord(index);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Retrieve a record by index.   <P> If <code>colNum</code> is passed, returns the record found in that column at that
     * index, or null if the column doesn't exist or the index is too high. <P> With no <code>colNum</code> parameter, a
     * record's index is it's position counting from the first record of the first column and including all records in each
     * column. Note that both index and colNum are zero-based - so the first column is column 0, not column 1.
     * @param index index of record to return.
     * @param colNum optional index of the column
     *
     * @return node at the specified index
     */
    public native TreeNode getRecord(int index, Integer colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRecord(index, colNum == null ? null : colNum.@java.lang.Integer::intValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Get the selected record, that is, the parent of the nodes in the rightmost visible column. <P> This is generally the
     * most recently clicked node unless programmatic navigation has taken place. <P> If only the first column is showing, the
     * root node is returned (which can be detected via {@link com.smartgwt.client.widgets.tree.Tree#isRoot Tree.isRoot}).
     *
     * @return the selected record
     */
    public native Record getSelectedRecord() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedRecord();
        if(ret == null) return null;
        return @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Navigate to the previous column.
     */
    public native void navigateBack() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.navigateBack();
    }-*/;
	/**
     * Whether the indicated column should show a header.  Returns this.showHeaders by default, override for different
     * behavior.
     * @param node parent node for the nodes to be shown in the column
     * @param colNum index of the column
     */
    public native void shouldShowHeader(TreeNode node, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.shouldShowHeader(node.@com.smartgwt.client.core.DataClass::getJsObj()(), colNum);
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript).
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param columnTreeProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(ColumnTree columnTreeProperties) /*-{
    	var properties = $wnd.isc.addProperties({},columnTreeProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.ColumnTree.addProperties(properties);
    }-*/;

    // ***********************************************************




	protected void onInit () {
		super.onInit();
		onInit_ColumnTree();
	}
    protected native void onInit_ColumnTree() /*-{

	    var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	    self.getColumnProperties = $debox($entry(function(node, colNum) {
				var jObj = this.__ref;
	        var nodeJ = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(node);

	        var propertiesJ = jObj.@com.smartgwt.client.widgets.grid.ColumnTree::getCustomColumnProperties(Lcom/smartgwt/client/widgets/tree/TreeNode;I)(nodeJ,colNum);
	        var properties = propertiesJ == null ? null : propertiesJ.@com.smartgwt.client.widgets.grid.ListGrid::getConfig()();
	        if (properties != null) delete properties.ID;
	        return properties;
	    }));
	}-*/;


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
     * @param colNum  the col num
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
     * @return (ArrayofListGridRecord) list of records, empty list if nothing selected
     */
    public native ListGridRecord[] getSelection(int colNum)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var records = self.getSelection(colNum);
        return @com.smartgwt.client.util.ConvertTo::arrayOfListGridRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
    }-*/;

    /**
     * Select all records in the supplied column (the first column if none is passed)&#010&#010
     *
     * @param colNum Column number
     */
    public native void selectAllRecords(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectAllRecords(colNum);
    }-*/;

    /**
     * Deselect all records in the supplied column (the first column if none is passed)&#010&#010
     *
     * @param colNum Column number
     */
    public native void deselectAllRecords(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectAllRecords(colNum);
    }-*/;

    /**
     * Whether at least one item is selected in the supplied column (the first column if none is passed)&#010&#010
     *
     * @param colNum Column number
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
     * <p/>
     * Notification method fired when a node is selected. Return false to suppress default&#010 behavior.&#010
     *
     * @param handler the onNodeSelected handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addNodeSelectedHandler(com.smartgwt.client.widgets.grid.events.NodeSelectedHandler handler) {
        if (getHandlerCount(com.smartgwt.client.widgets.grid.events.NodeSelectedEvent.getType()) == 0)
            setupNodeSelectedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.NodeSelectedEvent.getType());
    }

    private native void setupNodeSelectedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onNodeSelected:$debox($entry(function(){
                    var param = {"column" : arguments[0], "node" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.grid.events.NodeSelectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onNodeSelected = $debox($entry(function(){
                var param = {"column" : arguments[0], "node" : arguments[1]};
                var event = @com.smartgwt.client.widgets.grid.events.NodeSelectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        }
    }-*/;


    /**
     * Standard set of properties to apply to each generated {@link com.smartgwt.client.widgets.grid.ColumnTree#getColumn
     * column} in this columnTree. Developers may also override {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getCustomColumnProperties ColumnTree.getCustomColumnProperties} to return dynamic
     * properties based on the node being displayed.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param columnProperties columnProperties Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setColumnProperties(ListGrid columnProperties)  throws IllegalStateException {
    	JavaScriptObject config = columnProperties == null ? null : columnProperties.getConfig();
    	if (config != null) JSOHelper.setAttribute(config, "ID", (String)null);
        setAttribute("columnProperties", config, false);
    }

    /**
     * Standard set of properties to apply to each generated {@link com.smartgwt.client.widgets.grid.ColumnTree#getColumn
     * column} in this columnTree. Developers may also override {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getColumnProperties ColumnTree.getColumnProperties} to return dynamic
     * properties based on the node being displayed.
     *
     * @return "template" listGrid with attributes that will be applied to each generated column
     */
    public ListGrid getColumnProperties()  {
        return ListGrid.getOrCreateRef(getAttributeAsJavaScriptObject("columnProperties"));
    }

    /**
     * Additional properties to apply to the ListGrid that will show the indicated column.
     * Returns null by default. This method can be overridden to allow, for example, different
     * styling, icons or row heights per column.
     * @param node parent node for the nodes to be shown in the column
     * @param colNum index of the column
     * @return "template" listgrid with dynamically determined attributes to apply to the generated
     *    column.
     */
    public ListGrid getCustomColumnProperties(TreeNode node, int colNum) {
    	return null;
    }

    /**
     * Bind to a DataSource.
     * <P>
     * Binding to a DataSource means that the component will use the DataSource to provide default data for
     * its fields.
     * <P>
     * When binding to a new DataSource, if the component has any existing "fields" or has a dataset,
     * these will be discarded by default, since it is assumed the new DataSource may represent a completely
     * unrelated set of objects. If the old "fields" are still relevant, pass them to setDataSource().
     * @param dataSource
     * @param fields
     */
    public void setDataSource(DataSource dataSource, ListGridField... fields) {
        if (!isCreated()) {
            setFields(fields);
            setDataSource(dataSource);
        } else {
            JavaScriptObject jsFields = null;
            if (fields != null) {
                jsFields = JSOHelper.createJavaScriptArray();
                for (int i = 0; i < fields.length; i++) {
                    JSOHelper.setArrayValue(jsFields, i, fields[i].getJsObj());
                }
            }
            setDataSourceJS(dataSource.getOrCreateJsObj(), jsFields);
        }
    }
    private native void setDataSourceJS(JavaScriptObject dataSource, JavaScriptObject fields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setDataSource(dataSource, fields);
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

    public String[] getExportFields() {
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

    public Map getDropValues() {
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

    /** 
     * Shows a FieldPicker interface allowing end-users to rearrange the order and visibiility
     * of the fields in the associated DataBoundComponent.
     */
    public native void editFields() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editFields();
    }-*/;

    /**
     * Shows a HiliteEditor interface allowing end-users to edit the data-hilites currently in use by this DataBoundComponent.
     */
    public native void editHilites() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editHilites();
    }-*/;

    /**
     * Get the current hilites encoded as a String, for saving.
     *
     * @return the hilite state
     */
    public native String getHiliteState()  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getHiliteState();
    }-*/;

    /**
     * Set the current hilites based on a hiliteState String previously returned from getHilitesState.
     *
     * @param hiliteState hilites state encoded as a String
     */
    public native void setHiliteState(String hiliteState)  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.setHiliteState(hiliteState);
    }-*/;

    /**
     * Accepts an array of hilite objects and applies them to this DataBoundComponent. See also {@link #getHilites() getHilites} for a method of
     * retrieving the hilite array for storage, including hilites manually added by the user.
     *
     * @param hilites array of hilite objects
     */
    public native void setHilites(Hilite[] hilites)/*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()();
        var hilitesJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(hilites);
        if (isCreated) {
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setHilites(hilitesJS);
        } else {
            var obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.hilites = hilitesJS;
        }
    }-*/;

    /**
     * Return the set of hilite-objects currently applied to this DataBoundComponent. These can be saved for
     * storage and then restored to a component later via setHilites().
     *
     * @return array of hilite objects
     */
    public native Hilite[] getHilites()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var hilitesJS = self.getHilites();
        return @com.smartgwt.client.util.ConvertTo::arrayOfHilite(Lcom/google/gwt/core/client/JavaScriptObject;)(hilitesJS);
    }-*/;

    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }

    public DragDataAction getDragDataAction() {
        return EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
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
    /**
     * Filters all objects according to the AdvancedCriteria passed
     *
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.findAll(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;
    
    /**
     * Filters all objects according to the AdvancedCriteria passed and returns the first matching object or null if not found
     *
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return first matching object or null if not found
     */
    public native Record find(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = self.find(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;
    
    /**
     * Finds the index of the first Record that matches with the AdvacendCriteria passed.
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.findIndex(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    
    /**
     * Like {@link RecordList#findIndex}, but considering the startIndex and endIndex parameters.
     * @param startIndex first index to consider
     * @param adCriteria AdvancedCriteria to use to filter results
     * @param endIndex last index to consider
     * 
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, AdvancedCriteria adCriteria, int endIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), null, endIndex);
    }-*/;
    
    /**
     * Like {@link RecordList#findIndex}, but considering the startIndex parameter.
     * @param startIndex first index to consider
     * @param adCriteria AdvancedCriteria to use to filter results
     * 
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

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
        self.deselectRecord(record);
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
         return self.getRecordIndex(record.@com.smartgwt.client.core.DataClass::getJsObj()());
     }-*/;

    public native String getTitleFieldValue(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getTitleFieldValue(record);
     }-*/;

    public void setTitleField(String titleField) {
        setAttribute("titleField", titleField, true);
    }

    public String getTitleField() {
        return getAttributeAsString("titleField");
    }

    public void setDataSource(DataSource dataSource) {
    	if(dataSource==null) {
    		throw new IllegalArgumentException("Invalid call to setDataSource() passing null.  If you're having trouble with loading DataSources, please see the following FAQ: http://forums.smartclient.com/showthread.php?t=8159#aDSLoad");
    	}
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    public void setAutoFetchData(Boolean autoFetchData) throws IllegalStateException {
        setAttribute("autoFetchData", autoFetchData, false);
    }

    public Boolean getAutoFetchData() {
        return getAttributeAsBoolean("autoFetchData");
    }

    public void setAutoFetchTextMatchStyle(TextMatchStyle autoFetchTextMatchStyle) throws IllegalStateException {
        setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle.getValue(), false);
    }

    public TextMatchStyle getAutoFetchTextMatchStyle() {
        return TextMatchStyle.valueOf(getAttributeAsString("autoFetchTextMatchStyle"));
    }

    public void setAutoFetchAsFilter(Boolean autoFetchAsFilter) throws IllegalStateException {
        setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }

    public Boolean getAutoFetchAsFilter() {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }

    public void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    public Criteria getInitialCriteria() {
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
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
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
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void invalidateCache() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;

    public ResultSet getResultSet() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;
        if(!ResultSet.isResultSet(dataJS)) {
            SC.logWarn("getResultSet(): data is not a ResultSet; returning null " +
                "(if grouped, use getOriginalResultSet(); if unbound, use getRecordList(); " +
                "can only be called on DataBoundComponents after initial data has been fetched)");
            return null;
        }
        return new ResultSet(dataJS);
    }

    public RecordList getRecordList() {
        JavaScriptObject dataJS = getDataAsJSList();
        if(dataJS == null) return null;

        if(ResultSet.isResultSet(dataJS)) {
            return getResultSet();
        }
        return new RecordList(dataJS);
    }
    public native JavaScriptObject getDataAsJSList() /*-{
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
    	if (self == null) return null;
    	return self.getDataAsList();
    	
    }-*/;

    public native void exportData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData();
    }-*/;

    public native void exportData(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public native void exportClientData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData();
    }-*/;

    public native void exportClientData(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Add a fetchData handler.
     * <p>
     * Notification function fired on fetchData() or filterData()
     *
     * @param handler the filterData handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFetchDataHandler(FetchDataHandler handler) {
        if(getHandlerCount(FetchDataEvent.getType()) == 0) setupFetchDataEvent();
        return doAddHandler(handler, FetchDataEvent.getType());
    }

    private native void setupFetchDataEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onFetchData:$debox($entry(function(){
                    var param = {"criteria" : arguments[0], "requestProperties" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onFetchData = $debox($entry(function(){
                var param = {"criteria" : arguments[0], "requestProperties" : arguments[1]};
                var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    /**
     * Add a {@link com.smartgwt.client.widgets.DropCompleteHandler}.  See that class's documentation for a definition of "drop complete",
     * and how it differs from "drag complete" ({@link com.smartgwt.client.widgets.DragCompleteHandler}).
     *
     * @param handler the DropCompleteHandler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDropCompleteHandler(DropCompleteHandler handler) {
        if(getHandlerCount(DropCompleteEvent.getType()) == 0) setupDropCompleteEvent();
        return doAddHandler(handler, DropCompleteEvent.getType());
    }

    private native void setupDropCompleteEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dropComplete:$debox($entry(function(){
                    var param = {"transferredRecords" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dropComplete = $debox($entry(function(){
                var param = {"transferredRecords" : arguments[0]};
                var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    /**
     * Add a {@link com.smartgwt.client.widgets.DragCompleteHandler}.  See that class's documentation for a definition of "drag complete",
     * and how it differs from "drop complete" ({@link com.smartgwt.client.widgets.DropCompleteHandler}).
     *
     * @param handler the DropCompleteHandler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragCompleteHandler(DragCompleteHandler handler) {
        if(getHandlerCount(DragCompleteEvent.getType()) == 0) setupDragCompleteEvent();
        return doAddHandler(handler, DragCompleteEvent.getType());
    }

    private native void setupDragCompleteEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dragComplete:$debox($entry(function(){
                    var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)();
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dragComplete = $debox($entry(function(){
                var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)();
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    public LogicalStructureObject setLogicalStructure(ColumnTreeLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.backButtonTitle = getAttributeAsString("backButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.backButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.closedIconSuffix = getAttributeAsString("closedIconSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.closedIconSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.columnProperties = getAttributeAsString("columnProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.columnProperties:" + t.getMessage() + "\n";
        }
        try {
            s.customIconOpenProperty = getAttributeAsString("customIconOpenProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.customIconOpenProperty:" + t.getMessage() + "\n";
        }
        try {
            s.customIconProperty = getAttributeAsString("customIconProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.customIconProperty:" + t.getMessage() + "\n";
        }
        try {
            s.data = getData();
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.data:" + t.getMessage() + "\n";
        }
        try {
            s.dataFetchMode = getAttributeAsString("dataFetchMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.dataFetchMode:" + t.getMessage() + "\n";
        }
        try {
            s.dataSourceAsDataSource = getDataSource();
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.dataSourceAsDataSource:" + t.getMessage() + "\n";
        }
        try {
            s.dataSourceAsString = getAttributeAsString("dataSource");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.dataSourceAsString:" + t.getMessage() + "\n";
        }
        try {
            s.firstColumnTitle = getAttributeAsString("firstColumnTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.firstColumnTitle:" + t.getMessage() + "\n";
        }
        try {
            s.folderIcon = getAttributeAsString("folderIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.folderIcon:" + t.getMessage() + "\n";
        }
        try {
            s.loadDataOnDemand = getAttributeAsString("loadDataOnDemand");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.loadDataOnDemand:" + t.getMessage() + "\n";
        }
        try {
            s.nodeIcon = getAttributeAsString("nodeIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.nodeIcon:" + t.getMessage() + "\n";
        }
        try {
            s.openIconSuffix = getAttributeAsString("openIconSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.openIconSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.showCustomIconOpen = getAttributeAsString("showCustomIconOpen");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.showCustomIconOpen:" + t.getMessage() + "\n";
        }
        try {
            s.showDetailFields = getAttributeAsString("showDetailFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.showDetailFields:" + t.getMessage() + "\n";
        }
        try {
            s.showHeaders = getAttributeAsString("showHeaders");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.showHeaders:" + t.getMessage() + "\n";
        }
        try {
            s.showMultipleColumns = getAttributeAsString("showMultipleColumns");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.showMultipleColumns:" + t.getMessage() + "\n";
        }
        try {
            s.showNodeCount = getAttributeAsString("showNodeCount");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.showNodeCount:" + t.getMessage() + "\n";
        }
        try {
            s.showOpenIcons = getAttributeAsString("showOpenIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.showOpenIcons:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        ColumnTreeLogicalStructure s = new ColumnTreeLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

