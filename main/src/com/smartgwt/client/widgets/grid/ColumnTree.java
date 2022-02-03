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
 
package com.smartgwt.client.widgets.grid;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process

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
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.ace.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

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
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ColumnTree")
public class ColumnTree extends Layout implements  com.smartgwt.client.widgets.grid.events.HasNodeSelectedHandlers, DataBoundComponent {

    public static ColumnTree getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new ColumnTree(jsObj);
        } else {
            assert refInstance instanceof ColumnTree;
            return (ColumnTree)refInstance;
        }
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ColumnTree.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.ColumnTree.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ColumnTree.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.ColumnTree.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************
    
    

    /**
     * When using {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowMultipleColumns single-column mode}, this is the
     * "Back" button that you see hovering above the column UI and that allows backward navigation.
     * <p>
     * This component is an AutoChild named "backButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current backButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getBackButton() throws IllegalStateException {
        errorIfNotCreated("backButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("backButton"));
    }
    

    /**
     * When using {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowMultipleColumns single-column mode}, this i18n
     * property dictates the title for the {@link com.smartgwt.client.widgets.grid.ColumnTree#getBackButton button} docked to
     * the top left  which allows navigation back through the column tree.
     *
     * @param backButtonTitle New backButtonTitle value. Default value is "Back"
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     */
    public ColumnTree setBackButtonTitle(String backButtonTitle) {
        return (ColumnTree)setAttribute("backButtonTitle", backButtonTitle, true);
    }

    /**
     * When using {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowMultipleColumns single-column mode}, this i18n
     * property dictates the title for the {@link com.smartgwt.client.widgets.grid.ColumnTree#getBackButton button} docked to
     * the top left  which allows navigation back through the column tree.
     *
     * @return Current backButtonTitle value. Default value is "Back"
     */
    public String getBackButtonTitle()  {
        return getAttributeAsString("backButtonTitle");
    }
    

    /**
     * Indicates whether records can be dragged from this listGrid and dropped elsewhere. <p> <strong>NOTE:</strong> If
     * <code>canDragRecordsOut</code> is initially enabled or might be dynamically enabled after the grid is created, it may be
     * desirable to disable {@link com.smartgwt.client.widgets.Canvas#getUseTouchScrolling touch scrolling} so that
     * touch-dragging a record starts a drag operation rather than a scroll, but see the discussion of  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#showDragHandles drag handles}. If  {@link
     * com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag Canvas.disableTouchScrollingForDrag} is set to
     * <code>true</code>, then touch scrolling will be disabled automatically. However, for {@link
     * com.smartgwt.client.docs.Accessibility accessibility} reasons, it is recommended to leave touch scrolling enabled and
     * provide an alternative set of controls that can be used to perform drag and drop of records out of the grid.
     *
     * @param canDragRecordsOut New canDragRecordsOut value. Default value is false
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.tree.TreeNode#setCanDrag
     * @see com.smartgwt.client.widgets.tree.TreeNode#setCanAcceptDrop
     * @see com.smartgwt.client.widgets.grid.ListGrid#showDragHandles
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drop_events" target="examples">Drop Events Example</a>
     */
    public ColumnTree setCanDragRecordsOut(Boolean canDragRecordsOut) {
        return (ColumnTree)setAttribute("canDragRecordsOut", canDragRecordsOut, true);
    }

    /**
     * Indicates whether records can be dragged from this listGrid and dropped elsewhere. <p> <strong>NOTE:</strong> If
     * <code>canDragRecordsOut</code> is initially enabled or might be dynamically enabled after the grid is created, it may be
     * desirable to disable {@link com.smartgwt.client.widgets.Canvas#getUseTouchScrolling touch scrolling} so that
     * touch-dragging a record starts a drag operation rather than a scroll, but see the discussion of  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#showDragHandles drag handles}. If  {@link
     * com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag Canvas.disableTouchScrollingForDrag} is set to
     * <code>true</code>, then touch scrolling will be disabled automatically. However, for {@link
     * com.smartgwt.client.docs.Accessibility accessibility} reasons, it is recommended to leave touch scrolling enabled and
     * provide an alternative set of controls that can be used to perform drag and drop of records out of the grid.
     *
     * @return Current canDragRecordsOut value. Default value is false
     * @see com.smartgwt.client.widgets.tree.TreeNode#getCanDrag
     * @see com.smartgwt.client.widgets.tree.TreeNode#getCanAcceptDrop
     * @see com.smartgwt.client.widgets.grid.ListGrid#showDragHandles
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drop_events" target="examples">Drop Events Example</a>
     */
    public Boolean getCanDragRecordsOut()  {
        Boolean result = getAttributeAsBoolean("canDragRecordsOut");
        return result == null ? false : result;
    }
    

    /**
     * This suffix will be appended to the {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} for
     * closed folders. If {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons} is set to
     * <code>false</code> this suffix will also be appended to open folders' icons.
     *
     * @param closedIconSuffix New closedIconSuffix value. Default value is "closed"
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     */
    public ColumnTree setClosedIconSuffix(String closedIconSuffix) {
        return (ColumnTree)setAttribute("closedIconSuffix", closedIconSuffix, true);
    }

    /**
     * This suffix will be appended to the {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} for
     * closed folders. If {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons} is set to
     * <code>false</code> this suffix will also be appended to open folders' icons.
     *
     * @return Current closedIconSuffix value. Default value is "closed"
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
     * With {@link com.smartgwt.client.widgets.grid.ColumnTree#getFixedColumns fixedColumns} enabled, defines the header title
     * for each column.
     *
     * @param columnTitles New columnTitles value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColumnTree setColumnTitles(String... columnTitles)  throws IllegalStateException {
        return (ColumnTree)setAttribute("columnTitles", columnTitles, false);
    }

    /**
     * With {@link com.smartgwt.client.widgets.grid.ColumnTree#getFixedColumns fixedColumns} enabled, defines the header title
     * for each column.
     *
     * @return Current columnTitles value. Default value is null
     */
    public String[] getColumnTitles()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("columnTitles"));
    }
    

    /**
     * With {@link com.smartgwt.client.widgets.grid.ColumnTree#getFixedColumns fixedColumns} enabled, defines the pixel or %
     * width per column.
     *
     * @param columnWidths New columnWidths value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColumnTree setColumnWidths(String... columnWidths)  throws IllegalStateException {
        return (ColumnTree)setAttribute("columnWidths", columnWidths, false);
    }

    /**
     * With {@link com.smartgwt.client.widgets.grid.ColumnTree#getFixedColumns fixedColumns} enabled, defines the pixel or %
     * width per column.
     *
     * @return Current columnWidths value. Default value is null
     */
    public String[] getColumnWidths()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("columnWidths"));
    }
    

    /**
     * This property allows the developer to rename the  {@link com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon
     * default node.showOpenIcon} property.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param customIconOpenProperty New customIconOpenProperty value. Default value is "showOpenIcon"
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setCustomIconProperty
     * @see com.smartgwt.client.widgets.tree.TreeGrid#setShowCustomIconOpen
     */
    public ColumnTree setCustomIconOpenProperty(String customIconOpenProperty) {
        return (ColumnTree)setAttribute("customIconOpenProperty", customIconOpenProperty, true);
    }

    /**
     * This property allows the developer to rename the  {@link com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon
     * default node.showOpenIcon} property.
     *
     * @return Current customIconOpenProperty value. Default value is "showOpenIcon"
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
     * @param customIconProperty New customIconProperty value. Default value is "icon"
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     */
    public ColumnTree setCustomIconProperty(String customIconProperty) {
        return (ColumnTree)setAttribute("customIconProperty", customIconProperty, true);
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
     * @return Current customIconProperty value. Default value is "icon"
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
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     */
    public ColumnTree setData(Tree data) {
        return (ColumnTree)setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }

    /**
     * A {@link com.smartgwt.client.widgets.tree.Tree} object consisting of nested {@link
     * com.smartgwt.client.widgets.tree.TreeNode}s to  display in this ColumnTree.   The <code>data</code> property will
     * typically not be explicitly specified for  databound ColumnTrees, where the data is returned from the server via
     * databound component methods such as <code>fetchData()</code>
     *
     * @return Returns the {@link com.smartgwt.client.widgets.tree.Tree} object this ColumnTree is viewing. Default value is null
     */
    public Tree getData()  {
        return Tree.getOrCreateRef(getAttributeAsJavaScriptObject("data"));
    }
    

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()}.  If a pre-existing ResultSet is passed to setData()
     * instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode ResultSet.fetchMode} applies.
     *
     * @param dataFetchMode New dataFetchMode value. Default value is "paged"
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public ColumnTree setDataFetchMode(FetchMode dataFetchMode) {
        return (ColumnTree)setAttribute("dataFetchMode", dataFetchMode == null ? null : dataFetchMode.getValue(), true);
    }

    /**
     * How to fetch and manage records retrieve from the server.  See {@link com.smartgwt.client.types.FetchMode}. <P> This
     * setting only applies to the {@link com.smartgwt.client.data.ResultSet} automatically created by calling {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()}.  If a pre-existing ResultSet is passed to setData()
     * instead, it's existing setting for {@link com.smartgwt.client.data.ResultSet#getFetchMode ResultSet.fetchMode} applies.
     *
     * @return Current dataFetchMode value. Default value is "paged"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public FetchMode getDataFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }
    

    /**
     * For a <code>ColumnTree</code> that uses a DataSource, these properties will be passed to the automatically-created
     * ResultTree.  This can be used for various customizations such as modifying the automatically-chosen {@link
     * com.smartgwt.client.widgets.tree.Tree#getParentIdField Tree.parentIdField}.
     *
     * @return Current dataProperties value. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Tree getDataProperties()  {
        return Tree.getOrCreateRef(getAttributeAsJavaScriptObject("dataProperties"));
    }
    

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link
     * com.smartgwt.client.data.DSRequest DataSource requests}. <P> Can be specified as either a DataSource instance or the
     * String ID of a DataSource.
     *
     * @param dataSource New dataSource value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_ds_fields" target="examples">DataSource fields Example</a>
     */
    public ColumnTree setDataSource(DataSource dataSource) {
        return (ColumnTree)setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), true);
    }

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link
     * com.smartgwt.client.data.DSRequest DataSource requests}. <P> Can be specified as either a DataSource instance or the
     * String ID of a DataSource.
     *
     * @param dataSource New dataSource value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_ds_fields" target="examples">DataSource fields Example</a>
     */
    public ColumnTree setDataSource(String dataSource) {
        return (ColumnTree)setAttribute("dataSource", dataSource, true);
    }
    

    /**
     * With {@link com.smartgwt.client.widgets.grid.ColumnTree#getFixedColumns fixedColumns} enabled, defines each column's
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessage ListGrid.emptyMessage}.
     *
     * @param emptyColumnMessages New emptyColumnMessages value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColumnTree setEmptyColumnMessages(String... emptyColumnMessages)  throws IllegalStateException {
        return (ColumnTree)setAttribute("emptyColumnMessages", emptyColumnMessages, false);
    }

    /**
     * With {@link com.smartgwt.client.widgets.grid.ColumnTree#getFixedColumns fixedColumns} enabled, defines each column's
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessage ListGrid.emptyMessage}.
     *
     * @return Current emptyColumnMessages value. Default value is null
     */
    public String[] getEmptyColumnMessages()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("emptyColumnMessages"));
    }
    

    /**
     * An array of field objects, specifying the order, layout, dynamic calculation, and sorting behavior of each field in each
     * column in the columnTree object. In ColumnTrees,  the fields array specifies sub-columns within each main column.  Each
     * field in the fields array is a ListGridField object. <p> If {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getDataSource dataSource} is also set, this value acts as a set of overrides
     * as explained in {@link com.smartgwt.client.widgets.DataBoundComponent#getFields DataBoundComponent.fields}.
     *
     * @param fields New fields value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.grid.ListGridField
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public ColumnTree setFields(ListGridField... fields) {
        return (ColumnTree)setAttribute("fields", fields, true);
    }
    

    /**
     * A title for the leftmost column if {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is set
     * (the remaining columns have their titles derived from the item selected in the column to the left). Ignored if {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is not set.<br><br> Note: if you do not want a
     * heading for the first column leave this attribute at its  default value of " ". If you set it to null or the empty
     * string, Smart GWT will fall back to displaying the field's name in the heading.
     *
     * @param firstColumnTitle New firstColumnTitle value. Default value is " "
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColumnTree setFirstColumnTitle(String firstColumnTitle)  throws IllegalStateException {
        return (ColumnTree)setAttribute("firstColumnTitle", firstColumnTitle, false);
    }

    /**
     * A title for the leftmost column if {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is set
     * (the remaining columns have their titles derived from the item selected in the column to the left). Ignored if {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is not set.<br><br> Note: if you do not want a
     * heading for the first column leave this attribute at its  default value of " ". If you set it to null or the empty
     * string, Smart GWT will fall back to displaying the field's name in the heading.
     *
     * @return Current firstColumnTitle value. Default value is " "
     */
    public String getFirstColumnTitle()  {
        return getAttributeAsString("firstColumnTitle");
    }
    

    /**
     * Enables fixed columns mode.  All columns are created in advance instead of as navigation occurs.
     *
     * @param fixedColumns New fixedColumns value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColumnTree setFixedColumns(Integer fixedColumns)  throws IllegalStateException {
        return (ColumnTree)setAttribute("fixedColumns", fixedColumns, false);
    }

    /**
     * Enables fixed columns mode.  All columns are created in advance instead of as navigation occurs.
     *
     * @return Current fixedColumns value. Default value is null
     */
    public Integer getFixedColumns()  {
        return getAttributeAsInt("fixedColumns");
    }
    

    /**
     * The URL of the base icon for all folder nodes in this columnTree. Note that this URL will have {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} or {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} appended to  indicate state changes if
     * appropriate - see documentation on  {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons}
     *
     * @param folderIcon New folderIcon value. Default value is "[SKIN]folder.png"
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public ColumnTree setFolderIcon(String folderIcon) {
        return (ColumnTree)setAttribute("folderIcon", folderIcon, true);
    }

    /**
     * The URL of the base icon for all folder nodes in this columnTree. Note that this URL will have {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} or {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} appended to  indicate state changes if
     * appropriate - see documentation on  {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons}
     *
     * @return Current folderIcon value. Default value is "[SKIN]folder.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getFolderIcon()  {
        return getAttributeAsString("folderIcon");
    }
    
    
    

    /**
     * For databound columnTree instances, should the entire tree of data be loaded on initial  fetch, or should each column be
     * loaded as needed. If unset the default  ResultTree.loadDataOnDemand setting will be used.
     *
     * @param loadDataOnDemand New loadDataOnDemand value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public ColumnTree setLoadDataOnDemand(Boolean loadDataOnDemand)  throws IllegalStateException {
        return (ColumnTree)setAttribute("loadDataOnDemand", loadDataOnDemand, false);
    }

    /**
     * For databound columnTree instances, should the entire tree of data be loaded on initial  fetch, or should each column be
     * loaded as needed. If unset the default  ResultTree.loadDataOnDemand setting will be used.
     *
     * @return Current loadDataOnDemand value. Default value is null
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getLoadDataOnDemand()  {
        return getAttributeAsBoolean("loadDataOnDemand");
    }
    

    /**
     * The filename of the default icon for all leaf nodes in this grid. To specify a  custom image for an individual node, set
     * the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty} directly on the node.
     * <P> See {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowNodeIcons TreeGrid.showNodeIcons} and {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowFolderIcons TreeGrid.showFolderIcons} for details on suppressing 
     * display of icons
     *
     * @param nodeIcon New nodeIcon value. Default value is "[SKIN]file.png"
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_miller_columns" target="examples">Miller Columns Example</a>
     */
    public ColumnTree setNodeIcon(String nodeIcon) {
        return (ColumnTree)setAttribute("nodeIcon", nodeIcon, true);
    }

    /**
     * The filename of the default icon for all leaf nodes in this grid. To specify a  custom image for an individual node, set
     * the {@link com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty} directly on the node.
     * <P> See {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowNodeIcons TreeGrid.showNodeIcons} and {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getShowFolderIcons TreeGrid.showFolderIcons} for details on suppressing 
     * display of icons
     *
     * @return Current nodeIcon value. Default value is "[SKIN]file.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
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
     * @param openIconSuffix New openIconSuffix value. Default value is "open"
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     */
    public ColumnTree setOpenIconSuffix(String openIconSuffix) {
        return (ColumnTree)setAttribute("openIconSuffix", openIconSuffix, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowOpenIcons showOpenIcons} is true, this suffix will be
     * appended to the {@link com.smartgwt.client.widgets.grid.ColumnTree#getFolderIcon folderIcon} for open folders in this
     * grid.
     *
     * @return Current openIconSuffix value. Default value is "open"
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
     * com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon TreeNode.showOpenIcon} and that property can be renamed via
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconOpenProperty TreeGrid.customIconOpenProperty}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showCustomIconOpen New showCustomIconOpen value. Default value is false
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     */
    public ColumnTree setShowCustomIconOpen(Boolean showCustomIconOpen) {
        return (ColumnTree)setAttribute("showCustomIconOpen", showCustomIconOpen, true);
    }

    /**
     * Should folder nodes showing custom icons (set via the {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getCustomIconProperty customIconProperty}), show open state images when the
     * folder is opened. If true, the {@link com.smartgwt.client.widgets.grid.ColumnTree#getOpenIconSuffix openIconSuffix} will
     * be appended to the image URL (so <code>"customFolder.gif"</code> might be replaced with 
     * <code>"customFolder_open.gif"</code>).<br> <b>Note</b> that the {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#getClosedIconSuffix closedIconSuffix} is never appended to custom folder
     * icons.<br> Can be overridden at the node level via the default property {@link
     * com.smartgwt.client.widgets.tree.TreeNode#getShowOpenIcon TreeNode.showOpenIcon} and that property can be renamed via
     * {@link com.smartgwt.client.widgets.tree.TreeGrid#getCustomIconOpenProperty TreeGrid.customIconOpenProperty}.
     *
     * @return Current showCustomIconOpen value. Default value is false
     */
    public Boolean getShowCustomIconOpen()  {
        Boolean result = getAttributeAsBoolean("showCustomIconOpen");
        return result == null ? false : result;
    }
    

    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is  given a DataSource but no
     * <code>component.fields</code>. <p> The <code>detail</code> property is used on DataSource fields to mark fields that 
     * shouldn't appear by default in a view that tries to show many records in a small space.
     *
     * @param showDetailFields New showDetailFields value. Default value is true
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public ColumnTree setShowDetailFields(Boolean showDetailFields)  throws IllegalStateException {
        return (ColumnTree)setAttribute("showDetailFields", showDetailFields, false);
    }

    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is  given a DataSource but no
     * <code>component.fields</code>. <p> The <code>detail</code> property is used on DataSource fields to mark fields that 
     * shouldn't appear by default in a view that tries to show many records in a small space.
     *
     * @return Current showDetailFields value. Default value is true
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getShowDetailFields()  {
        Boolean result = getAttributeAsBoolean("showDetailFields");
        return result == null ? true : result;
    }
    

    /**
     * If set, each column in the ColumnTree will show a header with the title of the selected node from the column to the
     * left.
     *
     * @param showHeaders New showHeaders value. Default value is false
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColumnTree setShowHeaders(Boolean showHeaders)  throws IllegalStateException {
        return (ColumnTree)setAttribute("showHeaders", showHeaders, false);
    }

    /**
     * If set, each column in the ColumnTree will show a header with the title of the selected node from the column to the
     * left.
     *
     * @return Current showHeaders value. Default value is false
     */
    public Boolean getShowHeaders()  {
        Boolean result = getAttributeAsBoolean("showHeaders");
        return result == null ? false : result;
    }
    

    /**
     * When set to false, only displays a single column at a time, showing a slide animation  when moving between columns.
     *
     * @param showMultipleColumns New showMultipleColumns value. Default value is null
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     */
    public ColumnTree setShowMultipleColumns(Boolean showMultipleColumns) {
        return (ColumnTree)setAttribute("showMultipleColumns", showMultipleColumns, true);
    }

    /**
     * When set to false, only displays a single column at a time, showing a slide animation  when moving between columns.
     *
     * @return Current showMultipleColumns value. Default value is null
     */
    public Boolean getShowMultipleColumns()  {
        return getAttributeAsBoolean("showMultipleColumns");
    }
    

    /**
     * If set, and {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is also set, each column's
     * header will show  a count of the number of nodes in that column
     *
     * @param showNodeCount New showNodeCount value. Default value is false
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public ColumnTree setShowNodeCount(Boolean showNodeCount)  throws IllegalStateException {
        return (ColumnTree)setAttribute("showNodeCount", showNodeCount, false);
    }

    /**
     * If set, and {@link com.smartgwt.client.widgets.grid.ColumnTree#getShowHeaders showHeaders} is also set, each column's
     * header will show  a count of the number of nodes in that column
     *
     * @return Current showNodeCount value. Default value is false
     */
    public Boolean getShowNodeCount()  {
        Boolean result = getAttributeAsBoolean("showNodeCount");
        return result == null ? false : result;
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
     * @param showOpenIcons New showOpenIcons value. Default value is true
     * @return {@link com.smartgwt.client.widgets.grid.ColumnTree ColumnTree} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_miller_columns" target="examples">Miller Columns Example</a>
     */
    public ColumnTree setShowOpenIcons(Boolean showOpenIcons) {
        return (ColumnTree)setAttribute("showOpenIcons", showOpenIcons, true);
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
     * @return Current showOpenIcons value. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_miller_columns" target="examples">Miller Columns Example</a>
     */
    public Boolean getShowOpenIcons()  {
        Boolean result = getAttributeAsBoolean("showOpenIcons");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Process a drop of one or more nodes on a TreeGrid folder.   Add logic in your drop handler to perform custom drop
     * behaviors; to suppress the built-in  behavior described below, use <code>event.cancel()</code>  <P> The default behavior
     * is to simply delegate to the {@link com.smartgwt.client.widgets.grid.ColumnTree#transferNodes transferNodes()} method;
     * thus, the  correct way to perform a programmatic folder drop, with all the built-in behaviors described below, is to
     * call <code>transferNodes()</code> <P> If this is a self-drop, nodes are simply reordered. An "update" operation will be
     * submitted to update the {@link com.smartgwt.client.widgets.tree.Tree#getParentIdField parentId} field of the moved
     * node(s).  <P> For a drop from another widget, {@link com.smartgwt.client.widgets.tree.TreeGrid#transferDragData
     * TreeGrid.transferDragData()} is called which, depending on the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getDragDataAction dragDataAction} specified on the source widget, may either
     * remove the source nodes from the original list (<code>dragDataAction:"move"</code>) or just provide a copy to this tree
     * (<code>dragDataAction:"copy"</code>). <P> In either case the new row(s) appear in the <code>folder</code> at the
     * <code>index</code> specified by the arguments of the same name. <P> If this grid is databound, the new nodes will be
     * added to the dataset by calling {@link com.smartgwt.client.data.DataSource#addData DataSource.addData()}.  Further, if
     * the new nodes were dragged from another databound component, and {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getAddDropValues addDropValues} is true, {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getDropValues getDropValues} will be called for every item being dropped.
     * <P> As a special case, if the <code>sourceWidget</code> is also databound and a {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} relationship is declared from the
     * <code>sourceWidget</code>'s DataSource to this TreeGrid's DataSource, the interaction will be treated as a "drag
     * recategorization" use case such as files being placed in folders, employees being assigned to teams, etc.  "update"
     * DSRequests will be submitted that change the foreignKey field in the dropped records to point to the tree folder that
     * was the target of the drop.  In this case no change will be made to the Tree data as such, only to the dropped records. 
     * <P> For multi-record drops, Queuing is automatically used to combine all DSRequests into a single HTTP Request (see
     * QuickStart Guide, Server Framework chapter).  This allows the server to persist all changes caused by the drop in a
     * single transaction (and this is automatically done when using the built-in server DataSources with Power Edition and
     * above). <P> If these default persistence behaviors are undesirable,   use <code>event.cancel()</code>, then implement
     * your own behavior,  typically by using grid.updateData() or addData() to add new records. <p><b>NOTE:</b> the records
     * you receive in this event are the actual Records from the source component.  Use {@link
     * com.smartgwt.client.data.DataSource#copyRecords DataSource.copyRecords()} to create a copy before modifying the records
     * or using them with updateData() or addData().
     * @param nodes List of nodes being dropped
     * @param folder The folder being dropped on
     * @param index Within the folder being dropped on, the index at which the drop is                    occurring.  Only passed if {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getCanReorderRecords canReorderRecords} is true.
     * @param sourceWidget The component that is the source of the nodes (where the nodes                              were dragged from)
     * @see com.smartgwt.client.widgets.grid.ColumnTree#transferNodes
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drop_events" target="examples">Drop Events Example</a>
     */
    public native void folderDrop(TreeNode[] nodes, TreeNode folder, int index, Canvas sourceWidget) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "folderDrop", "TreeNode[],TreeNode,int,Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.folderDrop(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), folder.@com.smartgwt.client.core.DataClass::getJsObj()(), index, sourceWidget == null ? null : sourceWidget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Returns the title to show for the header of indicated column.  Only called if {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#shouldShowHeader shouldShowHeader()} returns true for this column. <P> By
     * default, returns {@link com.smartgwt.client.widgets.grid.ColumnTree#getFirstColumnTitle firstColumnTitle} for the first
     * column, and for subsequent columns, the result of {@link com.smartgwt.client.widgets.tree.Tree#getTitle
     * this.data.getTitle()} called on the <code>node</code> passed to this function.
     * @param node parent node for the nodes to be shown in the column
     * @param colNum index of the column
     */
    public native void getColumnTitle(TreeNode node, int colNum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getColumnTitle", "TreeNode,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getColumnTitle(node.@com.smartgwt.client.core.DataClass::getJsObj()(), colNum);
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getRecord", "int");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getRecord", "int,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRecord(index, colNum == null ? null : colNum.@java.lang.Integer::intValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * Get the selected record, that is, the parent of the nodes in the rightmost visible column. <P> This is generally the
     * most recently clicked node unless programmatic navigation has taken place. <P> If only the first column is showing, the
     * root node is returned (which can be detected via {@link com.smartgwt.client.widgets.tree.Tree#isRoot Tree.isRoot()}).
     *
     * @return the selected record
     */
    public native Record getSelectedRecord() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedRecord", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedRecord();
        if(ret == null) return null;
        return @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Navigate to the previous column.
     */
    public native void navigateBack() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "navigateBack", "");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "shouldShowHeader", "TreeNode,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.shouldShowHeader(node.@com.smartgwt.client.core.DataClass::getJsObj()(), colNum);
    }-*/;

	/**
     * Transfer a list of {@link com.smartgwt.client.widgets.tree.TreeNode}s within this treeGrid or from from some other
     * component  (does not have to be a databound component) into this component.  This method is only  applicable to
     * list-type components, such as {@link com.smartgwt.client.widgets.grid.ListGrid listGrid},  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid treeGrid} or {@link com.smartgwt.client.widgets.tile.TileGrid tileGrid}. 
     * Please see the paragraph below for special rules concerning {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree
     * multi-link trees}. <P> This method implements the automatic drag-copy and drag-move behavior and calling it is
     * equivalent to completing a drag and drop of the <code>nodes</code> (the default  {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#folderDrop folderDrop()} implementation simply calls
     * <code>transferNodes()</code>) <P> Note that this method is asynchronous - it may need to perform server turnarounds to
     * prevent duplicates in the target component's data.  If you wish to be notified when the transfer process has completed,
     * you can either pass the optional callback to this method or implement the {@link
     * com.smartgwt.client.widgets.DataBoundComponent#dropComplete DataBoundComponent.dropComplete()} method on this component.
     * <P> For a TreeGrid, see also {@link com.smartgwt.client.widgets.tree.TreeGrid#transferSelectedData
     * transferSelectedData()}. <p> <b>Multi-link trees</b><br> If both the target treeGrid and the <code>sourceWidget</code>
     * for this transfer are  multi-link treeGrids, the <code>nodes</code> parameter must be an array of  {@link
     * com.smartgwt.client.widgets.tree.NodeLocator}s rather than TreeNodes.  Likewise, if the target (this) component is a
     * multi-link treeGrid, the <code>folder</code> parameter must be a NodeLocator. <p> You can obtain a NodeLocator for a
     * visible node occurence in a multi-link TreeGrid by  calling its data model's {@link
     * com.smartgwt.client.widgets.tree.Tree#getNodeLocator getNodeLocator()} method.
     * @param nodes Nodes to transfer to this component
     * @param folder The target folder (eg, of a drop interaction), for context
     * @param index Insert point within the target folder data for the transferred nodes
     * @param sourceWidget The databound or non-databound component from which the nodes                              are to be transferred.
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drop_events" target="examples">Drop Events Example</a>
     */
    public native void transferNodes(TreeNode[] nodes, TreeNode folder, Integer index, Canvas sourceWidget) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "transferNodes", "TreeNode[],TreeNode,Integer,Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.transferNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), folder.@com.smartgwt.client.core.DataClass::getJsObj()(), index == null ? null : index.@java.lang.Integer::intValue()(), sourceWidget == null ? null : sourceWidget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Transfer a list of {@link com.smartgwt.client.widgets.tree.TreeNode}s within this treeGrid or from from some other
     * component  (does not have to be a databound component) into this component.  This method is only  applicable to
     * list-type components, such as {@link com.smartgwt.client.widgets.grid.ListGrid listGrid},  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid treeGrid} or {@link com.smartgwt.client.widgets.tile.TileGrid tileGrid}. 
     * Please see the paragraph below for special rules concerning {@link com.smartgwt.client.widgets.tree.Tree#isMultiLinkTree
     * multi-link trees}. <P> This method implements the automatic drag-copy and drag-move behavior and calling it is
     * equivalent to completing a drag and drop of the <code>nodes</code> (the default  {@link
     * com.smartgwt.client.widgets.grid.ColumnTree#folderDrop folderDrop()} implementation simply calls
     * <code>transferNodes()</code>) <P> Note that this method is asynchronous - it may need to perform server turnarounds to
     * prevent duplicates in the target component's data.  If you wish to be notified when the transfer process has completed,
     * you can either pass the optional callback to this method or implement the {@link
     * com.smartgwt.client.widgets.DataBoundComponent#dropComplete DataBoundComponent.dropComplete()} method on this component.
     * <P> For a TreeGrid, see also {@link com.smartgwt.client.widgets.tree.TreeGrid#transferSelectedData
     * transferSelectedData()}. <p> <b>Multi-link trees</b><br> If both the target treeGrid and the <code>sourceWidget</code>
     * for this transfer are  multi-link treeGrids, the <code>nodes</code> parameter must be an array of  {@link
     * com.smartgwt.client.widgets.tree.NodeLocator}s rather than TreeNodes.  Likewise, if the target (this) component is a
     * multi-link treeGrid, the <code>folder</code> parameter must be a NodeLocator. <p> You can obtain a NodeLocator for a
     * visible node occurence in a multi-link TreeGrid by  calling its data model's {@link
     * com.smartgwt.client.widgets.tree.Tree#getNodeLocator getNodeLocator()} method.
     * @param nodes Nodes to transfer to this component
     * @param folder The target folder (eg, of a drop interaction), for context
     * @param index Insert point within the target folder data for the transferred nodes
     * @param sourceWidget The databound or non-databound component from which the nodes                              are to be transferred.
     * @param callback optional callback to be fired when the transfer process has                       completed.  The callback will be
     * passed a single parameter "records",                       the list of nodes actually transferred to this component (it
     * is called                       "records" because this is logic shared with {@link
     * com.smartgwt.client.widgets.grid.ListGrid}).
     * See {@link com.smartgwt.client.docs.Callback Callback}
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#tree_interaction_drop_events" target="examples">Drop Events Example</a>
     */
    public native void transferNodes(TreeNode[] nodes, TreeNode folder, Integer index, Canvas sourceWidget, String callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "transferNodes", "TreeNode[],TreeNode,Integer,Canvas,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.transferNodes(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(nodes), folder.@com.smartgwt.client.core.DataClass::getJsObj()(), index == null ? null : index.@java.lang.Integer::intValue()(), sourceWidget == null ? null : sourceWidget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), callback);
    }-*/;
	

    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param columnTreeProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(ColumnTree columnTreeProperties) /*-{
        if (columnTreeProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(ColumnTree.@java.lang.Object::getClass()(), "setDefaultProperties", columnTreeProperties.@java.lang.Object::getClass()());
        }
        columnTreeProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = columnTreeProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
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
            var properties = propertiesJ == null ? null : $wnd.isc.addProperties({},propertiesJ.@com.smartgwt.client.widgets.grid.ListGrid::getConfig()());
            return @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
	    }));
	}-*/;

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
        if(retVal == null) {
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
                    var param = {"_this": this, "column" : arguments[0], "node" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.grid.events.NodeSelectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onNodeSelected = $debox($entry(function(){
                var param = {"_this": this, "column" : arguments[0], "node" : arguments[1]};
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
        if (columnProperties != null) {
            if (columnProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setColumnProperties",
                                                        "ListGrid");
            }                                                                       
            columnProperties.setConfigOnly(true);
        }
    	JavaScriptObject config = columnProperties == null ? null : columnProperties.getConfig();
        config = JSOHelper.cleanProperties(config, true);
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

    /**
     * For databound ColumnTrees, this attribute can be used to customize the 
     * ResultTree object created for this ColumnTree when data is fetched.
     *
     * @param resultTreeProperties the data properties
     */
    public void setDataProperties(Tree resultTreeProperties) {
        if (resultTreeProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setDataProperties", "Tree");
        }                                                                       
        resultTreeProperties.setConfigOnly(true);

        JavaScriptObject config = resultTreeProperties.getConfig();
        setAttribute("dataProperties", JSOHelper.cleanProperties(config, true), true);
    }



    // ********************* DataBoundComponent Properties / Attributes ***********************

    public ColumnTree setDataPageSize(int dataPageSize) {
        return (ColumnTree)setAttribute("dataPageSize", dataPageSize, true);
    }

    public int getDataPageSize() {
        Integer dataPageSize = getAttributeAsInt("dataPageSize");
        return dataPageSize == null ? 0 : dataPageSize;
    }

    public ColumnTree setUseAllDataSourceFields(Boolean useAllDataSourceFields) {
        return (ColumnTree)setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    public Boolean getUseAllDataSourceFields() {
        return getAttributeAsBoolean("useAllDataSourceFields");
    }

    public ColumnTree setShowHiddenFields(Boolean showHiddenFields) {
        return (ColumnTree)setAttribute("showHiddenFields", showHiddenFields, true);
    }

    public Boolean getShowHiddenFields() {
        return getAttributeAsBoolean("showHiddenFields");
    }

    public ColumnTree setShowComplexFields(Boolean showComplexFields) {
        return (ColumnTree)setAttribute("showComplexFields", showComplexFields, true);
    }

    public Boolean getShowComplexFields() {
        return getAttributeAsBoolean("showComplexFields");
    }

    public ColumnTree setFetchOperation(String fetchOperation) {
        return (ColumnTree)setAttribute("fetchOperation", fetchOperation, true);
    }

    public String getFetchOperation() {
        return getAttributeAsString("fetchOperation");
    }

    public ColumnTree setUpdateOperation(String updateOperation) {
        return (ColumnTree)setAttribute("updateOperation", updateOperation, true);
    }

    public String getUpdateOperation() {
        return getAttributeAsString("updateOperation");
    }

    public ColumnTree setAddOperation(String addOperation) {
        return (ColumnTree)setAttribute("addOperation", addOperation, true);
    }

    public String getAddOperation() {
        return getAttributeAsString("addOperation");
    }

    public ColumnTree setRemoveOperation(String removeOperation) {
        return (ColumnTree)setAttribute("removeOperation", removeOperation, true);
    }

    public String getRemoveOperation() {
        return getAttributeAsString("removeOperation");
    }

    public ColumnTree setExportFields(String[] exportFields) {
        return (ColumnTree)setAttribute("exportFields", exportFields, true);
    }

    public String[] getExportFields() {
        return getAttributeAsStringArray("exportFields");
    }

    public ColumnTree setExportAll(Boolean exportAll) {
        return (ColumnTree)setAttribute("exportAll", exportAll, true);
    }

    public Boolean getExportAll() {
        return getAttributeAsBoolean("exportAll");
    }

    public ColumnTree setExportIncludeSummaries(Boolean exportIncludeSummaries) {
        return (ColumnTree)setAttribute("exportIncludeSummaries", exportIncludeSummaries, true);
    }

    public Boolean getExportIncludeSummaries() {
        return getAttributeAsBoolean("exportIncludeSummaries");
    }

    public ColumnTree setPreventDuplicates(Boolean preventDuplicates) throws IllegalStateException {
        return (ColumnTree)setAttribute("preventDuplicates", preventDuplicates, false);
    }

    public Boolean getPreventDuplicates() {
        return getAttributeAsBoolean("preventDuplicates");
    }

    public ColumnTree setDuplicateDragMessage(String duplicateDragMessage) throws IllegalStateException {
        return (ColumnTree)setAttribute("duplicateDragMessage", duplicateDragMessage, false);
    }

    public String getDuplicateDragMessage() {
        return getAttributeAsString("duplicateDragMessage");
    }

    public ColumnTree setAddDropValues(Boolean addDropValues) {
        return (ColumnTree)setAttribute("addDropValues", addDropValues, true);
    }

    public Boolean getAddDropValues() {
        return getAttributeAsBoolean("addDropValues");
    }

    public ColumnTree setDropValues(Map dropValues) {
        return (ColumnTree)setAttribute("dropValues", dropValues, true);
    }

    public Map getDropValues() {
        return getAttributeAsMap("dropValues");
    }

    /**
     * Indicates whether or not this component will load its data
     * {@link DataSource#setProgressiveLoading() progressively}
     * 
     * @see com.smartgwt.client.docs.ProgressiveLoading  
     * @see com.smartgwt.client.data.DataSource#setProgressiveLoading
     * @param progressiveLoading
     * @return {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponent}
     * instance, for chaining setter calls
     */
    public ColumnTree setProgressiveLoading(Boolean progressiveLoading) {
        return (ColumnTree)setAttribute("progressiveLoading", progressiveLoading, false);
    }

    /**
     * Indicates whether or not this component will load its data {@link DataSource#getProgressiveLoading() progressively}
     * 
     * @see com.smartgwt.client.docs.ProgressiveLoading
     * @see com.smartgwt.client.data.DataSource#getProgressiveLoading
     * @return
     */
    public Boolean getProgressiveLoading() {
        return getAttributeAsBoolean("progressiveLoading");
    }

    public ColumnTree setUseFlatFields(Boolean useFlatFields) throws IllegalStateException {
        return (ColumnTree)setAttribute("useFlatFields", useFlatFields, false);
    }

    public Boolean getUseFlatFields() {
        return getAttributeAsBoolean("useFlatFields");
    }

    public ColumnTree setHiliteProperty(String hiliteProperty) {
        return (ColumnTree)setAttribute("hiliteProperty", hiliteProperty, true);
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

    public native void editHilites() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editHilites();
    }-*/;

    public native String getHiliteState()  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getHiliteState();
    }-*/;

    public native ColumnTree setHiliteState(String hiliteState)  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setHiliteState(hiliteState);
        return this;
    }-*/;

    public native ColumnTree setHilites(Hilite[] hilites)/*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()();
        var hilitesJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(hilites);
        if (isCreated) {
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setHilites(hilitesJS);
        } else {
            var obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.hilites = hilitesJS;
        }
        return this;
    }-*/;

    public native Hilite[] getHilites()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var hilitesJS = self.getHilites();
        return @com.smartgwt.client.util.ConvertTo::arrayOfHilite(Lcom/google/gwt/core/client/JavaScriptObject;)(hilitesJS);
    }-*/;

    public ColumnTree setDragDataAction(DragDataAction dragDataAction) {
        return (ColumnTree)setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }

    public DragDataAction getDragDataAction() {
        return EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    public ColumnTree setDragTrackerStyle(String dragTrackerStyle) {
        return (ColumnTree)setAttribute("dragTrackerStyle", dragTrackerStyle, true);
    }

    public String getDragTrackerStyle() {
        return getAttributeAsString("dragTrackerStyle");
    }

    public ColumnTree setCanAddFormulaFields(Boolean canAddFormulaFields) {
        return (ColumnTree)setAttribute("canAddFormulaFields", canAddFormulaFields, true);
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

    public ColumnTree setAddFormulaFieldText(String addFormulaFieldText) {
        return (ColumnTree)setAttribute("addFormulaFieldText", addFormulaFieldText, true);
    }

    public String getAddFormulaFieldText() {
        return getAttributeAsString("addFormulaFieldText");
    }

    public ColumnTree setEditFormulaFieldText(String editFormulaFieldText) {
        return (ColumnTree)setAttribute("editFormulaFieldText", editFormulaFieldText, true);
    }

    public String getEditFormulaFieldText() {
        return getAttributeAsString("editFormulaFieldText");
    }

    public ColumnTree setCanAddSummaryFields(Boolean canAddSummaryFields) {
        return (ColumnTree)setAttribute("canAddSummaryFields", canAddSummaryFields, true);
    }

    public Boolean getCanAddSummaryFields() {
        return getAttributeAsBoolean("canAddSummaryFields");
    }

    public ColumnTree setAddSummaryFieldText(String addSummaryFieldText) {
        return (ColumnTree)setAttribute("addSummaryFieldText", addSummaryFieldText, true);
    }

    public String getAddSummaryFieldText() {
        return getAttributeAsString("addSummaryFieldText");
    }

    public ColumnTree setEditSummaryFieldText(String editSummaryFieldText) {
        return (ColumnTree)setAttribute("editSummaryFieldText", editSummaryFieldText, true);
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return recordsJS == null ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return recordJS == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;
    
    /**
     * Finds the index of the first Record that matches with the AdvacendCriteria passed.
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
         if(retVal == null) {
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

    public ColumnTree setTitleField(String titleField) {
        return (ColumnTree)setAttribute("titleField", titleField, true);
    }

    public String getTitleField() {
        return getAttributeAsString("titleField");
    }

    public native DataSource getDataSource() /*-{
        var dataSourceJS = this.@com.smartgwt.client.widgets.grid.ListGrid::getAttributeAsJavaScriptObject(Ljava/lang/String;)("dataSource");
        if ($wnd.isc.isA.String(dataSourceJS)) dataSourceJS = $wnd.isc.DataSource.get(dataSourceJS);
        return @com.smartgwt.client.data.DataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataSourceJS);
    }-*/;

    public ColumnTree setAutoFetchData(Boolean autoFetchData) throws IllegalStateException {
        return (ColumnTree)setAttribute("autoFetchData", autoFetchData, false);
    }

    public Boolean getAutoFetchData() {
        return getAttributeAsBoolean("autoFetchData");
    }

    public ColumnTree setAutoFetchTextMatchStyle(TextMatchStyle autoFetchTextMatchStyle) throws IllegalStateException {
        return (ColumnTree)setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle.getValue(), false);
    }

    public TextMatchStyle getAutoFetchTextMatchStyle() {
        return TextMatchStyle.valueOf(getAttributeAsString("autoFetchTextMatchStyle"));
    }

    public ColumnTree setAutoFetchAsFilter(Boolean autoFetchAsFilter) throws IllegalStateException {
        return (ColumnTree)setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }

    public Boolean getAutoFetchAsFilter() {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }

    public ColumnTree setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        return (ColumnTree)setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    public Criteria getInitialCriteria() {
        return new Criteria(getAttributeAsJavaScriptObject("initialCriteria"));
    }

    public ColumnTree setImplicitCriteria(Criteria implicitCriteria) {
        if (implicitCriteria instanceof Criterion) {
            implicitCriteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (ColumnTree)setAttribute("implicitCriteria", implicitCriteria == null ?
                            null : implicitCriteria.getJsObj(), true);
    }

    public Criteria getImplicitCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("implicitCriteria"));
    }
    
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
    	if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
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
        return ResultSet.getOrCreateRef(dataJS);
    }

    public native RecordList getRecordList() /*-{
        var dataJS = this.@com.smartgwt.client.widgets.DataBoundComponent::getDataAsJSList()();
        if (dataJS == null) return null;
        if ($wnd.isc.isA.ResultSet(dataJS)) {
            return this.@com.smartgwt.client.widgets.DataBoundComponent::getResultSet()();
        } else if ($wnd.isc.isA.ResultTree(dataJS)) {
            return @com.smartgwt.client.widgets.tree.ResultTree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
        } else if ($wnd.isc.isA.Tree(dataJS)) {
            return @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
        }
        return @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
    }-*/;

    public native JavaScriptObject getDataAsJSList() /*-{
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
    	if (self == null) return null;
    	return self.getDataAsList();
    	
    }-*/;

    public void exportData() {
        exportData(null);
    }

    public native void exportData(DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportData", "DSRequest,RPCCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


    public native void exportData(DSRequest requestProperties, RPCCallback callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportData", "DSRequest,RPCCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()(),
			$entry( function(response, rawData, request) {
				if(callback!=null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(
					@com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response), 
					rawData, 
					@com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request)
				);
			}));
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
                    var param = {"_this": this, "criteria" : arguments[0], "requestProperties" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onFetchData = $debox($entry(function(){
                var param = {"_this": this, "criteria" : arguments[0], "requestProperties" : arguments[1]};
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
                    var param = {"_this": this, "transferredRecords" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dropComplete = $debox($entry(function(){
                var param = {"_this": this, "transferredRecords" : arguments[0]};
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
                    var param = {"_this": this};
                    var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dragComplete = $debox($entry(function(){
                var param = {"_this": this, "transferredRecords" : arguments[0]};
                var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    public native Alignment[] getFieldAlignments()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var alignJS = self.getFieldAlignments();
        return @com.smartgwt.client.util.ConvertTo::arrayOfAlignment(Lcom/google/gwt/core/client/JavaScriptObject;)(alignJS);
    }-*/;

    public Boolean getDeepCloneOnEdit() {
        return getAttributeAsBoolean("deepCloneOnEdit");
    }

    public ColumnTree setDeepCloneOnEdit(Boolean deepCloneOnEdit) {
        return (ColumnTree)setAttribute("deepCloneOnEdit", deepCloneOnEdit, true);
    }

    public ColumnTree setFields(JavaScriptObject... fields) {
        if (fields != null) for(int i = 0; i < fields.length; i++) {
            fields[i] = duplicateFieldConfig(JSOHelper.cleanProperties(fields[i], false));
        }
        return (ColumnTree)setAttribute("fields", fields, true);
    }

    private native JavaScriptObject duplicateFieldConfig(JavaScriptObject config) /*-{
        return $wnd.isc.shallowClone(config);
    }-*/;

    public JavaScriptObject[] getFieldsAsJavaScriptObjects() {
        JavaScriptObject fieldsJsArray = getAttributeAsJavaScriptObject("fields");
        return JSOHelper.isArray(fieldsJsArray) ? JSOHelper.toArray(fieldsJsArray) : null;
    }

    public int getFieldCount() {
        JavaScriptObject[] fields = getFieldsAsJavaScriptObjects();
        return fields != null ? fields.length : 0;
    }
    
    public native void transferRecords(Record[] records, Record targetRecord, Integer index, Canvas sourceWidget, TransferRecordsCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        var targetRecordJS = targetRecord == null ? null : targetRecord.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var indexJS = index == null ? null : index.@java.lang.Integer::intValue()();
        var sourceWidgetJS = sourceWidget == null ? null : sourceWidget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.transferRecords(recordsJS, targetRecordJS, indexJS, sourceWidgetJS, $entry(function(records) {
            if(callback != null) {
	    		var convertedArray = [];
	    		for (var i = 0; i < records.length; i++) {
	    			convertedArray[i] =  @com.smartgwt.client.data.Record::new(Lcom/google/gwt/core/client/JavaScriptObject;)(records[i]);
	    		}
                var recordsJ = @com.smartgwt.client.util.JSOHelper::convertToJavaObjectArray(Lcom/google/gwt/core/client/JavaScriptObject;)(convertedArray);
                callback.@com.smartgwt.client.widgets.TransferRecordsCallback::execute([Lcom/smartgwt/client/data/Record;)(recordsJ);
            }
        }));
    }-*/;

	/**
     * During a drag-and-drop interaction, this method returns the set of records being dragged
     * out of the component.  In the default implementation, this is the list of currently
     * selected records.<p>
     * This method is consulted by
     * {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop willAcceptDrop()}.
     * @param DragDataCustomizer customizer
     * @return {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponent}
     * instance, for chaining setter calls
     */
    public native ColumnTree setDragDataCustomizer(DragDataCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        var componentJ = this;
        self.getDragData = $debox($entry(function() {
        	var returnJ = customizer.@com.smartgwt.client.widgets.DragDataCustomizer::getDragData(Lcom/smartgwt/client/widgets/DataBoundComponent;)(componentJ);
        	return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(returnJ);
    	}));
        return this;
    }-*/;

    public native SortSpecifier[] getSort() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSort", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        if(self == null) return null
        var ret = self.getSort();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfSortSpecifier(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
    
    public native ColumnTree setSort(SortSpecifier... sortSpecifiers) /*-{
        var sortSpecifiersJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(sortSpecifiers);
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSort(sortSpecifiersJS);
        return this;
    }-*/;


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(ColumnTreeLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.backButtonTitle = getAttributeAsString("backButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.backButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.canDragRecordsOut = getAttributeAsString("canDragRecordsOut");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.canDragRecordsOut:" + t.getMessage() + "\n";
        }
        try {
            s.closedIconSuffix = getAttributeAsString("closedIconSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.closedIconSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.columnTitles = getAttributeAsStringArray("columnTitles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.columnTitlesArray:" + t.getMessage() + "\n";
        }
        try {
            s.columnWidths = getAttributeAsStringArray("columnWidths");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.columnWidthsArray:" + t.getMessage() + "\n";
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
            s.dataProperties = getDataProperties();
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.dataProperties:" + t.getMessage() + "\n";
        }
        try {
            s.emptyColumnMessages = getAttributeAsStringArray("emptyColumnMessages");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.emptyColumnMessagesArray:" + t.getMessage() + "\n";
        }
        try {
            s.firstColumnTitle = getAttributeAsString("firstColumnTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.firstColumnTitle:" + t.getMessage() + "\n";
        }
        try {
            s.fixedColumns = getAttributeAsString("fixedColumns");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ColumnTree.fixedColumns:" + t.getMessage() + "\n";
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

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        ColumnTreeLogicalStructure s = new ColumnTreeLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
