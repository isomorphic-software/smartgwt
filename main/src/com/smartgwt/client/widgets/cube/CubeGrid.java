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
 
package com.smartgwt.client.widgets.cube;


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
 * The CubeGrid is an interactive grid component that presents very large, multi-dimensional data sets (also known as data
 * cubes) for reporting or analytic applications. <P> CubeGrids are often called crosstabs, for their cross-tabular display
 * of data dimensions in stacked/nested rows and columns, or pivot tables, for their ability to "pivot" dimensions between
 * rows and columns to view a data cube from different perspectives. They are typically used in the querying and reporting
 * front-ends of data warehousing, decision support, OLAP, and business intelligence systems. <P> For example, CubeGrids
 * can be connected to Pentaho Mondrian, Jasper Reports, Microsoft Analysis Services and any other OLAP technology that
 * supports the XMLA standard - the Isomorphic public wiki has  <a
 * href='http://wiki.smartclient.com/pages/viewpage.action?pageId=1441839' target='_blank'>examples</a>. of such
 * integration. <P> <b>NOTE:</b> you must load the Analytics  {@link com.smartgwt.client.docs.LoadingOptionalModules
 * Optional Module} before you can use CubeGrid. <P> <B>Multi-Dimensional Data Terminology</B> <P> The CubeGrid refers to
 * the dimensions of a data cube as facets, to the possible values in each facet as facet values, and to the values within
 * the data cube as data values or cell values. Equivalent terms that are commonly used in data warehousing or business
 * intelligence systems include:<br> <b>facet:</b> dimension, attribute, feature<br> <b>facet value:</b> dimension member,
 * attribute value, feature value<br> <b>cell value:</b> data value, metric value, measure <P> <B>Visual Structure</B> <P>
 * Like the ListGrid and TreeGrid components, the CubeGrid displays data values in a tabular "body" with adjacent
 * "headers".  While the ListGrid and TreeGrid display rows of records with field values, the CubeGrid displays a body of
 * individual cell values, each associated with a combination of facet values. The facet values for a cell are displayed in
 * the column headers above the cell and row headers to the left of the cell. CubeGrids can display an arbitrary number of
 * facets, by stacking multiple levels of row and/or column headers. <P> Except for the innermost column facet, each facet
 * in a CubeGrid has a facet label adjacent to its row or column headers. The facet labels serve two main purposes: they
 * display the titles of the facets, and they provide drag-and-drop reordering or pivoting of facets within the CubeGrid.
 * The row facet labels also provide interactive selection, resizing, and other operations on the columns of row facet
 * values. <P> The innermost column headers provide special behaviors and controls for manipulating the columns of data in
 * a CubeGrid. End users may select, resize, reorder, minimize, maximize, or auto-fit the columns of data via mouse
 * interactions with these headers. Customizable indicators and controls may be included at the top of each innermost
 * column header. <P> If a CubeGrid is not large enough to display all of its cell values, horizontal and/or vertical
 * scrollbars will appear below and to the right of the body. The body of the CubeGrid may be scrolled on either axis. The
 * headers are "frozen" from scrolling on one axis - row headers only scroll vertically, while column headers only scroll
 * horizontally - so the facet values for the visible cells are always displayed. <P> <B>Data Loading</B> <P> Data can be
 * provided to the Cube via {@link com.smartgwt.client.widgets.cube.CubeGrid#getData data} as an Array of {@link
 * com.smartgwt.client.widgets.cube.CellRecord CellRecords}, each representing the data for one cell. <P> For large
 * datasets, {@link com.smartgwt.client.widgets.cube.CubeGrid#getDataSource provide a DataSource} with one field per
 * facetId, and the CubeGrid will load data on demand to fill the visible area, including lazily loading data for
 * expanding/collapsing tree facets and when facetValues are made visible programmatically or via menus. <P> <B>Picking
 * Facets</B> <P> By "facet" we mean an aspect of the data which is orthogonal to other aspects of the data, that is,
 * combining values from any two "facets" should make sense. <P> For example, in sales data, two facets might be "quarter"
 * and "region" - it makes sense to combine any quarter and region, although for some combinations, there may not be data
 * available. <P>  An example of two aspects that would <b>not</b> be independent facets are "state" and "city" - it's
 * senseless to combine arbitrary states with arbitrary cities - most combinations are invalid.  Consider instead a {@link
 * com.smartgwt.client.widgets.cube.Facet#getIsTree tree facet} that combines "city" and "state" values.   <P> Note that if
 * "city" and "state" are represented as facets, they may look correct if they are both on the same axis of the grid and
 * {@link com.smartgwt.client.widgets.cube.CubeGrid#getHideEmptyFacetValues hideEmptyFacetValues} is used to trim nonsense
 * combinations, but if the data is {@link com.smartgwt.client.widgets.cube.CubeGrid#getCanMoveFacets pivoted} such that
 * "state" and "city" are on opposing axes, there will be a roughly diagonal "stripe" of data for combinations of "state"
 * and "city" that make sense, and all other space will be blank.  This is a strong indication that two facets should be
 * represented as a single tree facet instead.
 * @see com.smartgwt.client.widgets.cube.Facet
 * @see com.smartgwt.client.widgets.cube.FacetValue
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("CubeGrid")
public class CubeGrid extends ListGrid implements com.smartgwt.client.widgets.cube.events.HasFacetAddedHandlers, com.smartgwt.client.widgets.cube.events.HasFacetContextClickHandlers, com.smartgwt.client.widgets.cube.events.HasFacetLabelClickHandlers, com.smartgwt.client.widgets.cube.events.HasFacetMovedHandlers, com.smartgwt.client.widgets.cube.events.HasFacetRemovedHandlers, com.smartgwt.client.widgets.cube.events.HasFacetValueContextClickHandlers, com.smartgwt.client.widgets.cube.events.HasFacetValueSelectionChangedHandlers, com.smartgwt.client.widgets.cube.events.HasFixedFacetValueChangedHandlers, com.smartgwt.client.widgets.cube.events.HasSortByFacetIdHandlers, com.smartgwt.client.widgets.cube.events.HasSortByFacetValuesHandlers {

    public static CubeGrid getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new CubeGrid(jsObj);
        } else {
            assert refInstance instanceof CubeGrid;
            return (CubeGrid)refInstance;
        }
    }

    private static final CubeGrid TEST_INSTANCE = new CubeGrid();
    static {
        TEST_INSTANCE.setID("isc_CubeGrid_testInstance");
    }

    @Override
    protected CubeGrid getTestInstance() {
        return TEST_INSTANCE;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(CubeGrid.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.CubeGrid.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(CubeGrid.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.CubeGrid.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public CubeGrid(){
        checkAnalyticsLoaded();
					setAutoFetchData(false);
                scClassName = "CubeGrid";
    }

    public CubeGrid(JavaScriptObject jsObj){
        scClassName = "CubeGrid";
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
     * Whether alternating rows should be drawn in alternating styles, in order to create a "ledger" effect for easier reading.
     *  If enabled, the cell style for alternate rows will have "Dark" appended to it.
     *
     * @param alternateRecordStyles New alternateRecordStyles value. Default value is true
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CubeGrid setAlternateRecordStyles(Boolean alternateRecordStyles) {
        return (CubeGrid)setAttribute("alternateRecordStyles", alternateRecordStyles, true);
    }

    /**
     * Whether alternating rows should be drawn in alternating styles, in order to create a "ledger" effect for easier reading.
     *  If enabled, the cell style for alternate rows will have "Dark" appended to it.
     *
     * @return Current alternateRecordStyles value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getAlternateRecordStyles()  {
        Boolean result = getAttributeAsBoolean("alternateRecordStyles");
        return result == null ? true : result;
    }
    
    

    /**
     * If {@link com.smartgwt.client.widgets.cube.CubeGrid#getAutoFetchData autoFetchData} is <code>true</code>, this attribute
     * allows the developer to specify a textMatchStyle for the initial {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()} call.
     *
     * @param autoFetchTextMatchStyle New autoFetchTextMatchStyle value. Default value is "exact"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public CubeGrid setAutoFetchTextMatchStyle(TextMatchStyle autoFetchTextMatchStyle)  throws IllegalStateException {
        return (CubeGrid)setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle == null ? null : autoFetchTextMatchStyle.getValue(), false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.cube.CubeGrid#getAutoFetchData autoFetchData} is <code>true</code>, this attribute
     * allows the developer to specify a textMatchStyle for the initial {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()} call.
     *
     * @return Current autoFetchTextMatchStyle value. Default value is "exact"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public TextMatchStyle getAutoFetchTextMatchStyle()  {
        return EnumUtil.getEnum(TextMatchStyle.values(), getAttribute("autoFetchTextMatchStyle"));
    }
    

    /**
     * This property is not supported for <code>CubeGrid</code>. <P> Consider setting explicit widths via {@link
     * com.smartgwt.client.widgets.cube.FacetValue#getWidth FacetValue.width} or {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getDefaultFacetWidth defaultFacetWidth}.
     *
     * @param autoFitFieldWidths New autoFitFieldWidths value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public CubeGrid setAutoFitFieldWidths(Boolean autoFitFieldWidths)  throws IllegalStateException {
        return (CubeGrid)setAttribute("autoFitFieldWidths", autoFitFieldWidths, false);
    }

    /**
     * This property is not supported for <code>CubeGrid</code>. <P> Consider setting explicit widths via {@link
     * com.smartgwt.client.widgets.cube.FacetValue#getWidth FacetValue.width} or {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getDefaultFacetWidth defaultFacetWidth}.
     *
     * @return Current autoFitFieldWidths value. Default value is null
     */
    public Boolean getAutoFitFieldWidths()  {
        return getAttributeAsBoolean("autoFitFieldWidths");
    }
    

    /**
     * If true, when multiple facets appear on one side in a nested headers presentation, the selection state of parent/child
     * headers are automatically kept in sync.
     *
     * @param autoSelectHeaders New autoSelectHeaders value. Default value is true
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setAutoSelectHeaders(Boolean autoSelectHeaders) {
        return (CubeGrid)setAttribute("autoSelectHeaders", autoSelectHeaders, true);
    }

    /**
     * If true, when multiple facets appear on one side in a nested headers presentation, the selection state of parent/child
     * headers are automatically kept in sync.
     *
     * @return Current autoSelectHeaders value. Default value is true
     */
    public Boolean getAutoSelectHeaders()  {
        Boolean result = getAttributeAsBoolean("autoSelectHeaders");
        return result == null ? true : result;
    }
    

    /**
     * Whether to select cells in the body when row or column headers are selected.
     *
     * @param autoSelectValues New autoSelectValues value. Default value is "both"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public CubeGrid setAutoSelectValues(AutoSelectionModel autoSelectValues)  throws IllegalStateException {
        return (CubeGrid)setAttribute("autoSelectValues", autoSelectValues == null ? null : autoSelectValues.getValue(), false);
    }

    /**
     * Whether to select cells in the body when row or column headers are selected.
     *
     * @return Current autoSelectValues value. Default value is "both"
     */
    public AutoSelectionModel getAutoSelectValues()  {
        return EnumUtil.getEnum(AutoSelectionModel.values(), getAttribute("autoSelectValues"));
    }
    

    /**
     * Automatically size row headers to fit wrapped text.
     *
     * @param autoSizeHeaders New autoSizeHeaders value. Default value is false
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setAutoSizeHeaders(Boolean autoSizeHeaders) {
        return (CubeGrid)setAttribute("autoSizeHeaders", autoSizeHeaders, true);
    }

    /**
     * Automatically size row headers to fit wrapped text.
     *
     * @return Current autoSizeHeaders value. Default value is false
     */
    public Boolean getAutoSizeHeaders()  {
        Boolean result = getAttributeAsBoolean("autoSizeHeaders");
        return result == null ? false : result;
    }
    

    /**
     * {@link com.smartgwt.client.widgets.grid.GridRenderer#getBaseStyle base cell style} for this listGrid. If this property
     * is unset, base style may be derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle
     * ListGrid.normalBaseStyle} or {@link com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle ListGrid.tallBaseStyle}
     * as described in {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.getBaseStyle()}. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @param baseStyle New baseStyle value. Default value is "cubeCell"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CubeGrid setBaseStyle(String baseStyle)  throws IllegalStateException {
        return (CubeGrid)setAttribute("baseStyle", baseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.grid.GridRenderer#getBaseStyle base cell style} for this listGrid. If this property
     * is unset, base style may be derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle
     * ListGrid.normalBaseStyle} or {@link com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle ListGrid.tallBaseStyle}
     * as described in {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.getBaseStyle()}. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @return Return the base stylename for this cell.  Default implementation just returns this.baseStyle. See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle getCellStyle()} for a general discussion of how to style cells. Default value is "cubeCell"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * Minimum height for the body of this cubeGrid.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param bodyMinHeight New bodyMinHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setBodyMinHeight(Integer bodyMinHeight) {
        return (CubeGrid)setAttribute("bodyMinHeight", bodyMinHeight, true);
    }

    /**
     * Minimum height for the body of this cubeGrid.
     *
     * @return Current bodyMinHeight value. Default value is null
     */
    public Integer getBodyMinHeight()  {
        return getAttributeAsInt("bodyMinHeight");
    }
    

    /**
     * Minimum width for the body of this cubeGrid.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param bodyMinWidth New bodyMinWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setBodyMinWidth(Integer bodyMinWidth) {
        return (CubeGrid)setAttribute("bodyMinWidth", bodyMinWidth, true);
    }

    /**
     * Minimum width for the body of this cubeGrid.
     *
     * @return Current bodyMinWidth value. Default value is null
     */
    public Integer getBodyMinWidth()  {
        return getAttributeAsInt("bodyMinWidth");
    }
    

    /**
     * CSS class for the CubeGrid body
     *
     * @param bodyStyleName New bodyStyleName value. Default value is "cubeGridBody"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CubeGrid setBodyStyleName(String bodyStyleName) {
        return (CubeGrid)setAttribute("bodyStyleName", bodyStyleName, true);
    }

    /**
     * CSS class for the CubeGrid body
     *
     * @return Current bodyStyleName value. Default value is "cubeGridBody"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBodyStyleName()  {
        return getAttributeAsString("bodyStyleName");
    }
    

    /**
     * If true, hierarchical facets will show expand/collapse controls to allow the user to expand and collapse the tree of
     * facetValues for that facet.
     *
     * @param canCollapseFacets New canCollapseFacets value. Default value is false
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setRowHeaderGridMode
     */
    public CubeGrid setCanCollapseFacets(Boolean canCollapseFacets) {
        return (CubeGrid)setAttribute("canCollapseFacets", canCollapseFacets, true);
    }

    /**
     * If true, hierarchical facets will show expand/collapse controls to allow the user to expand and collapse the tree of
     * facetValues for that facet.
     *
     * @return Current canCollapseFacets value. Default value is false
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getRowHeaderGridMode
     */
    public Boolean getCanCollapseFacets()  {
        Boolean result = getAttributeAsBoolean("canCollapseFacets");
        return result == null ? false : result;
    }
    

    /**
     * For {@link com.smartgwt.client.util.Browser#isTouch touch browsers}, <code>canDragSelect</code> defaults to false so
     * that touch scrolling can be used to navigate scrollable CubeGrids.  In all other browsers it defaults to true. <p>
     * <strong>NOTE:</strong> If <code>canDragSelect</code> is enabled, it may be desirable to disable {@link
     * com.smartgwt.client.widgets.Canvas#getUseTouchScrolling touch scrolling} so that touch-dragging cells of the CubeGrid
     * selects them rather than starting a scroll. If {@link com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag
     * Canvas.disableTouchScrollingForDrag} is set to <code>true</code>, then touch scrolling will be disabled automatically.
     * However, for {@link com.smartgwt.client.docs.Accessibility accessibility} reasons, it is recommended to leave touch
     * scrolling enabled and provide an alternative set of controls that can be used to perform drag-selection.
     *
     * @param canDragSelect New canDragSelect value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public CubeGrid setCanDragSelect(Boolean canDragSelect)  throws IllegalStateException {
        return (CubeGrid)setAttribute("canDragSelect", canDragSelect, false);
    }

    /**
     * For {@link com.smartgwt.client.util.Browser#isTouch touch browsers}, <code>canDragSelect</code> defaults to false so
     * that touch scrolling can be used to navigate scrollable CubeGrids.  In all other browsers it defaults to true. <p>
     * <strong>NOTE:</strong> If <code>canDragSelect</code> is enabled, it may be desirable to disable {@link
     * com.smartgwt.client.widgets.Canvas#getUseTouchScrolling touch scrolling} so that touch-dragging cells of the CubeGrid
     * selects them rather than starting a scroll. If {@link com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag
     * Canvas.disableTouchScrollingForDrag} is set to <code>true</code>, then touch scrolling will be disabled automatically.
     * However, for {@link com.smartgwt.client.docs.Accessibility accessibility} reasons, it is recommended to leave touch
     * scrolling enabled and provide an alternative set of controls that can be used to perform drag-selection.
     *
     * @return Current canDragSelect value. Default value is null
     */
    public Boolean getCanDragSelect()  {
        return getAttributeAsBoolean("canDragSelect");
    }
    

    /**
     * Whether cells can be edited in this grid.  Can be overridden on a per-facetValue basis.
     *
     * @param canEdit New canEdit value. Default value is false
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setCanEdit(Boolean canEdit) {
        return (CubeGrid)setAttribute("canEdit", canEdit, true);
    }

    /**
     * Whether cells can be edited in this grid.  Can be overridden on a per-facetValue basis.
     *
     * @return Current canEdit value. Default value is false
     */
    public Boolean getCanEdit()  {
        Boolean result = getAttributeAsBoolean("canEdit");
        return result == null ? false : result;
    }
    

    /**
     * If true, allow columns in the grid body to be minimized (reduced to the width of the minimize control) by clicking on a
     * minimize control in the innermost column headers.
     *
     * @param canMinimizeColumns New canMinimizeColumns value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setCanMinimizeColumns(Boolean canMinimizeColumns) {
        return (CubeGrid)setAttribute("canMinimizeColumns", canMinimizeColumns, true);
    }

    /**
     * If true, allow columns in the grid body to be minimized (reduced to the width of the minimize control) by clicking on a
     * minimize control in the innermost column headers.
     *
     * @return Current canMinimizeColumns value. Default value is null
     */
    public Boolean getCanMinimizeColumns()  {
        return getAttributeAsBoolean("canMinimizeColumns");
    }
    

    /**
     * If true, when multiple facets are shown on a side, all facetValues in the second level of headers or higher will show
     * controls to "minimize" the values of the next facet. Minimizing means showing only one, or very few, of the next facet's
     * values. <P> Set {@link com.smartgwt.client.widgets.cube.FacetValue#getIsMinimizeValue FacetValue.isMinimizeValue} to
     * indicate which facetValues should be shown when a facet is minimized.
     *
     * @param canMinimizeFacets New canMinimizeFacets value. Default value is false
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setCanMinimizeFacets(Boolean canMinimizeFacets) {
        return (CubeGrid)setAttribute("canMinimizeFacets", canMinimizeFacets, true);
    }

    /**
     * If true, when multiple facets are shown on a side, all facetValues in the second level of headers or higher will show
     * controls to "minimize" the values of the next facet. Minimizing means showing only one, or very few, of the next facet's
     * values. <P> Set {@link com.smartgwt.client.widgets.cube.FacetValue#getIsMinimizeValue FacetValue.isMinimizeValue} to
     * indicate which facetValues should be shown when a facet is minimized.
     *
     * @return Current canMinimizeFacets value. Default value is false
     */
    public Boolean getCanMinimizeFacets()  {
        Boolean result = getAttributeAsBoolean("canMinimizeFacets");
        return result == null ? false : result;
    }
    

    /**
     * Whether row and column facets can be rearranged by the user, by dragging and dropping the facet labels.
     *
     * @param canMoveFacets New canMoveFacets value. Default value is false
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setCanMoveFacets(Boolean canMoveFacets) {
        return (CubeGrid)setAttribute("canMoveFacets", canMoveFacets, true);
    }

    /**
     * Whether row and column facets can be rearranged by the user, by dragging and dropping the facet labels.
     *
     * @return Current canMoveFacets value. Default value is false
     */
    public Boolean getCanMoveFacets()  {
        Boolean result = getAttributeAsBoolean("canMoveFacets");
        return result == null ? false : result;
    }
    

    /**
     * If true, body columns can be reordered via the innermost column headers.
     *
     * @param canReorderColumns New canReorderColumns value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setCanReorderColumns(Boolean canReorderColumns) {
        return (CubeGrid)setAttribute("canReorderColumns", canReorderColumns, true);
    }

    /**
     * If true, body columns can be reordered via the innermost column headers.
     *
     * @return Current canReorderColumns value. Default value is null
     */
    public Boolean getCanReorderColumns()  {
        return getAttributeAsBoolean("canReorderColumns");
    }
    

    /**
     * If true, body columns can be resized via the innermost column headers.
     *
     * @param canResizeColumns New canResizeColumns value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setCanResizeColumns(Boolean canResizeColumns) {
        return (CubeGrid)setAttribute("canResizeColumns", canResizeColumns, true);
    }

    /**
     * If true, body columns can be resized via the innermost column headers.
     *
     * @return Current canResizeColumns value. Default value is null
     */
    public Boolean getCanResizeColumns()  {
        return getAttributeAsBoolean("canResizeColumns");
    }
    

    /**
     * Determines whether row or column facetValue headers can be selected.
     *
     * @param canSelectHeaders New canSelectHeaders value. Default value is true
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setCanSelectHeaders(Boolean canSelectHeaders) {
        return (CubeGrid)setAttribute("canSelectHeaders", canSelectHeaders, true);
    }

    /**
     * Determines whether row or column facetValue headers can be selected.
     *
     * @return Current canSelectHeaders value. Default value is true
     */
    public Boolean getCanSelectHeaders()  {
        Boolean result = getAttributeAsBoolean("canSelectHeaders");
        return result == null ? true : result;
    }
    

    /**
     * Determines whether cell values in the body can be selected.
     *
     * @param canSelectValues New canSelectValues value. Default value is true
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setCanSelectValues(Boolean canSelectValues) {
        return (CubeGrid)setAttribute("canSelectValues", canSelectValues, true);
    }

    /**
     * Determines whether cell values in the body can be selected.
     *
     * @return Current canSelectValues value. Default value is true
     */
    public Boolean getCanSelectValues()  {
        Boolean result = getAttributeAsBoolean("canSelectValues");
        return result == null ? true : result;
    }
    

    /**
     * If true, sort controls will be shown on facet values. <P> When clicked, sort controls call {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#addSortByFacetValuesHandler CubeGrid.sortByFacetValues()}.
     *
     * @param canSortData New canSortData value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setCanSortData(Boolean canSortData) {
        return (CubeGrid)setAttribute("canSortData", canSortData, true);
    }

    /**
     * If true, sort controls will be shown on facet values. <P> When clicked, sort controls call {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#addSortByFacetValuesHandler CubeGrid.sortByFacetValues()}.
     *
     * @return Current canSortData value. Default value is null
     */
    public Boolean getCanSortData()  {
        return getAttributeAsBoolean("canSortData");
    }
    

    /**
     * If true, sort controls will be shown on FacetHeaders. <P> When clicked, sort controls call {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#addSortByFacetIdHandler CubeGrid.sortByFacetId()}.
     *
     * @param canSortFacets New canSortFacets value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setCanSortFacets(Boolean canSortFacets) {
        return (CubeGrid)setAttribute("canSortFacets", canSortFacets, true);
    }

    /**
     * If true, sort controls will be shown on FacetHeaders. <P> When clicked, sort controls call {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#addSortByFacetIdHandler CubeGrid.sortByFacetId()}.
     *
     * @return Current canSortFacets value. Default value is null
     */
    public Boolean getCanSortFacets()  {
        return getAttributeAsBoolean("canSortFacets");
    }
    

    /**
     * Default align for cell values (in body).
     *
     * @param cellAlign New cellAlign value. Default value is "center"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setCellAlign(Alignment cellAlign) {
        return (CubeGrid)setAttribute("cellAlign", cellAlign == null ? null : cellAlign.getValue(), true);
    }

    /**
     * Default align for cell values (in body).
     *
     * @return Current cellAlign value. Default value is "center"
     */
    public Alignment getCellAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("cellAlign"));
    }
    

    /**
     * Name of the property in a cell record that holds it's unique ID.  Note cell record IDs are optional.
     *
     * @param cellIdProperty New cellIdProperty value. Default value is "ID"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public CubeGrid setCellIdProperty(String cellIdProperty)  throws IllegalStateException {
        return (CubeGrid)setAttribute("cellIdProperty", cellIdProperty, false);
    }

    /**
     * Name of the property in a cell record that holds it's unique ID.  Note cell record IDs are optional.
     *
     * @return Current cellIdProperty value. Default value is "ID"
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public String getCellIdProperty()  {
        return getAttributeAsString("cellIdProperty");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.cube.CubeGrid#makeChart makeChart()} is called with a chart specification that
     * will show more than <code>chartConfirmThreshold</code> data elements, the user will be presented with a {@link
     * com.smartgwt.client.util.isc#confirm confirmation dialog}. <P> Set to 0 to disable this confirmation.
     *
     * @param chartConfirmThreshold New chartConfirmThreshold value. Default value is 2000
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public CubeGrid setChartConfirmThreshold(int chartConfirmThreshold)  throws IllegalStateException {
        return (CubeGrid)setAttribute("chartConfirmThreshold", chartConfirmThreshold, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.cube.CubeGrid#makeChart makeChart()} is called with a chart specification that
     * will show more than <code>chartConfirmThreshold</code> data elements, the user will be presented with a {@link
     * com.smartgwt.client.util.isc#confirm confirmation dialog}. <P> Set to 0 to disable this confirmation.
     *
     * @return Current chartConfirmThreshold value. Default value is 2000
     */
    public int getChartConfirmThreshold()  {
        return getAttributeAsInt("chartConfirmThreshold");
    }
    

    /**
     * Name of the Smart GWT Class to be used when creating charts.  Must support the Chart interface.
     *
     * @param chartConstructor New chartConstructor value. Default value is "FacetChart"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public CubeGrid setChartConstructor(String chartConstructor)  throws IllegalStateException {
        return (CubeGrid)setAttribute("chartConstructor", chartConstructor, false);
    }

    /**
     * Name of the Smart GWT Class to be used when creating charts.  Must support the Chart interface.
     *
     * @return Current chartConstructor value. Default value is "FacetChart"
     */
    public String getChartConstructor()  {
        return getAttributeAsString("chartConstructor");
    }
    

    /**
     * Default type of chart to plot.
     *
     * @param chartType New chartType value. Default value is "Column"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setChartType(ChartType chartType) {
        return (CubeGrid)setAttribute("chartType", chartType == null ? null : chartType.getValue(), true);
    }

    /**
     * Default type of chart to plot.
     *
     * @return Current chartType value. Default value is "Column"
     */
    public ChartType getChartType()  {
        return EnumUtil.getEnum(ChartType.values(), getAttribute("chartType"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the buttons in this grid's column headers. <P>
     * Exception: The innermost column header will always be styled using {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getInnerHeaderBaseStyle innerHeaderBaseStyle}.
     *
     * @param colHeaderBaseStyle New colHeaderBaseStyle value. Default value is "colHeader"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CubeGrid setColHeaderBaseStyle(String colHeaderBaseStyle)  throws IllegalStateException {
        return (CubeGrid)setAttribute("colHeaderBaseStyle", colHeaderBaseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the buttons in this grid's column headers. <P>
     * Exception: The innermost column header will always be styled using {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getInnerHeaderBaseStyle innerHeaderBaseStyle}.
     *
     * @return Current colHeaderBaseStyle value. Default value is "colHeader"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getColHeaderBaseStyle()  {
        return getAttributeAsString("colHeaderBaseStyle");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the facet-label buttons above this grid's  column
     * headers.
     *
     * @param colHeaderLabelBaseStyle New colHeaderLabelBaseStyle value. Default value is "colHeaderLabel"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CubeGrid setColHeaderLabelBaseStyle(String colHeaderLabelBaseStyle)  throws IllegalStateException {
        return (CubeGrid)setAttribute("colHeaderLabelBaseStyle", colHeaderLabelBaseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the facet-label buttons above this grid's  column
     * headers.
     *
     * @return Current colHeaderLabelBaseStyle value. Default value is "colHeaderLabel"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getColHeaderLabelBaseStyle()  {
        return getAttributeAsString("colHeaderLabelBaseStyle");
    }
    

    /**
     * The list of {@link com.smartgwt.client.widgets.cube.Facet#getId ids} for facets that will appear on top of the body.
     *
     * @param columnFacets New columnFacets value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public CubeGrid setColumnFacets(String... columnFacets)  throws IllegalStateException {
        return (CubeGrid)setAttribute("columnFacets", columnFacets, false);
    }

    /**
     * The list of {@link com.smartgwt.client.widgets.cube.Facet#getId ids} for facets that will appear on top of the body.
     *
     * @return Current columnFacets value. Default value is null
     */
    public String[] getColumnFacets()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("columnFacets"));
    }
    
    
    

    /**
     * Default width of inner column headers.
     *
     * @param defaultFacetWidth New defaultFacetWidth value. Default value is 100
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setDefaultFacetWidth(int defaultFacetWidth) {
        return (CubeGrid)setAttribute("defaultFacetWidth", defaultFacetWidth, true);
    }

    /**
     * Default width of inner column headers.
     *
     * @return Current defaultFacetWidth value. Default value is 100
     */
    public int getDefaultFacetWidth()  {
        return getAttributeAsInt("defaultFacetWidth");
    }
    

    /**
     * CubeGrids only support editing by cell.
     * <p>
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Current editByCell value. Default value is true
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Boolean getEditByCell() throws IllegalStateException {
        errorIfNotCreated("editByCell");
        Boolean result = getAttributeAsBoolean("editByCell");
        return result == null ? true : result;
    }
    
    

    /**
     * Sets the background color for the column headers of the cube. See also {@link com.smartgwt.client.docs.ExportBGColor}.
     *
     * @param exportColumnFacetBGColor New exportColumnFacetBGColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public CubeGrid setExportColumnFacetBGColor(String exportColumnFacetBGColor)  throws IllegalStateException {
        return (CubeGrid)setAttribute("exportColumnFacetBGColor", exportColumnFacetBGColor, false);
    }

    /**
     * Sets the background color for the column headers of the cube. See also {@link com.smartgwt.client.docs.ExportBGColor}.
     *
     * @return Current exportColumnFacetBGColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getExportColumnFacetBGColor()  {
        return getAttributeAsString("exportColumnFacetBGColor");
    }
    

    /**
     * Sets the text color for the column headers of the cube.
     *
     * @param exportColumnFacetTextColor New exportColumnFacetTextColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public CubeGrid setExportColumnFacetTextColor(String exportColumnFacetTextColor)  throws IllegalStateException {
        return (CubeGrid)setAttribute("exportColumnFacetTextColor", exportColumnFacetTextColor, false);
    }

    /**
     * Sets the text color for the column headers of the cube.
     *
     * @return Current exportColumnFacetTextColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getExportColumnFacetTextColor()  {
        return getAttributeAsString("exportColumnFacetTextColor");
    }
    

    /**
     * Sets the background color for the row and column headers of the cube, if not otherwise set by a more specific property.
     * (see {@link com.smartgwt.client.widgets.cube.CubeGrid#getExportRowFacetBGColor exportRowFacetBGColor()} and {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getExportColumnFacetBGColor exportColumnFacetBGColor()}). See also {@link
     * com.smartgwt.client.docs.ExportBGColor}.
     *
     * @param exportFacetBGColor New exportFacetBGColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public CubeGrid setExportFacetBGColor(String exportFacetBGColor)  throws IllegalStateException {
        return (CubeGrid)setAttribute("exportFacetBGColor", exportFacetBGColor, false);
    }

    /**
     * Sets the background color for the row and column headers of the cube, if not otherwise set by a more specific property.
     * (see {@link com.smartgwt.client.widgets.cube.CubeGrid#getExportRowFacetBGColor exportRowFacetBGColor()} and {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getExportColumnFacetBGColor exportColumnFacetBGColor()}). See also {@link
     * com.smartgwt.client.docs.ExportBGColor}.
     *
     * @return Current exportFacetBGColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getExportFacetBGColor()  {
        return getAttributeAsString("exportFacetBGColor");
    }
    

    /**
     * Default separator string used by {@link com.smartgwt.client.widgets.cube.CubeGrid#exportClientData exportClientData()}
     * to separate column and row facet value titles.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param exportFacetSeparatorString New exportFacetSeparatorString value. Default value is " - "
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setExportFacetSeparatorString(String exportFacetSeparatorString) {
        return (CubeGrid)setAttribute("exportFacetSeparatorString", exportFacetSeparatorString, true);
    }

    /**
     * Default separator string used by {@link com.smartgwt.client.widgets.cube.CubeGrid#exportClientData exportClientData()}
     * to separate column and row facet value titles.
     *
     * @return Current exportFacetSeparatorString value. Default value is " - "
     */
    public String getExportFacetSeparatorString()  {
        return getAttributeAsString("exportFacetSeparatorString");
    }
    

    /**
     * Sets the text color for the row and column headers of the cube,  if not otherwise set by a more specific property. (see
     * {@link com.smartgwt.client.widgets.cube.CubeGrid#getExportRowFacetTextColor exportRowFacetTextColor()} and {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getExportColumnFacetTextColor exportColumnFacetTextColor()}).
     *
     * @param exportFacetTextColor New exportFacetTextColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public CubeGrid setExportFacetTextColor(String exportFacetTextColor)  throws IllegalStateException {
        return (CubeGrid)setAttribute("exportFacetTextColor", exportFacetTextColor, false);
    }

    /**
     * Sets the text color for the row and column headers of the cube,  if not otherwise set by a more specific property. (see
     * {@link com.smartgwt.client.widgets.cube.CubeGrid#getExportRowFacetTextColor exportRowFacetTextColor()} and {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getExportColumnFacetTextColor exportColumnFacetTextColor()}).
     *
     * @return Current exportFacetTextColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getExportFacetTextColor()  {
        return getAttributeAsString("exportFacetTextColor");
    }
    

    /**
     * Sets the background color for the row headers of the cube. See also {@link com.smartgwt.client.docs.ExportBGColor}.
     *
     * @param exportRowFacetBGColor New exportRowFacetBGColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public CubeGrid setExportRowFacetBGColor(String exportRowFacetBGColor)  throws IllegalStateException {
        return (CubeGrid)setAttribute("exportRowFacetBGColor", exportRowFacetBGColor, false);
    }

    /**
     * Sets the background color for the row headers of the cube. See also {@link com.smartgwt.client.docs.ExportBGColor}.
     *
     * @return Current exportRowFacetBGColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getExportRowFacetBGColor()  {
        return getAttributeAsString("exportRowFacetBGColor");
    }
    

    /**
     * Sets the text color for the row headers of the cube.
     *
     * @param exportRowFacetTextColor New exportRowFacetTextColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public CubeGrid setExportRowFacetTextColor(String exportRowFacetTextColor)  throws IllegalStateException {
        return (CubeGrid)setAttribute("exportRowFacetTextColor", exportRowFacetTextColor, false);
    }

    /**
     * Sets the text color for the row headers of the cube.
     *
     * @return Current exportRowFacetTextColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getExportRowFacetTextColor()  {
        return getAttributeAsString("exportRowFacetTextColor");
    }
    

    /**
     * Allows the developer to override the horizontal text alignment of hover tips shown for facetLabels.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverAlign</code> if specified.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetLabelHoverAlign New facetLabelHoverAlign value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverAlign
     */
    public CubeGrid setFacetLabelHoverAlign(Alignment facetLabelHoverAlign) {
        return (CubeGrid)setAttribute("facetLabelHoverAlign", facetLabelHoverAlign == null ? null : facetLabelHoverAlign.getValue(), true);
    }

    /**
     * Allows the developer to override the horizontal text alignment of hover tips shown for facetLabels.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverAlign</code> if specified.
     *
     * @return Current facetLabelHoverAlign value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverAlign
     */
    public Alignment getFacetLabelHoverAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("facetLabelHoverAlign"));
    }
    

    /**
     * If specified and <code>this.showHover</code> is true, this is the default height to apply to hover tips shown for
     * facetLabels. If unset, the hover canvas will be sized to  <code>this.hoverHeight</code> if specified instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetLabelHoverHeight New facetLabelHoverHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverHeight
     */
    public CubeGrid setFacetLabelHoverHeight(Integer facetLabelHoverHeight) {
        return (CubeGrid)setAttribute("facetLabelHoverHeight", facetLabelHoverHeight, true);
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default height to apply to hover tips shown for
     * facetLabels. If unset, the hover canvas will be sized to  <code>this.hoverHeight</code> if specified instead.
     *
     * @return Current facetLabelHoverHeight value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverHeight
     */
    public Integer getFacetLabelHoverHeight()  {
        return getAttributeAsInt("facetLabelHoverHeight");
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default height to apply to hover tips shown for
     * facetLabels. If unset, the hover canvas will be sized to  <code>this.hoverHeight</code> if specified instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetLabelHoverHeight New facetLabelHoverHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverHeight
     */
    public CubeGrid setFacetLabelHoverHeight(String facetLabelHoverHeight) {
        return (CubeGrid)setAttribute("facetLabelHoverHeight", facetLabelHoverHeight, true);
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default height to apply to hover tips shown for
     * facetLabels. If unset, the hover canvas will be sized to  <code>this.hoverHeight</code> if specified instead.
     *
     * @return Current facetLabelHoverHeight value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverHeight
     */
    public String getFacetLabelHoverHeightAsString()  {
        return getAttributeAsString("facetLabelHoverHeight");
    }
    

    /**
     * Allows the developer to override the css class applied to  hover tips shown for facet labels.  If unspecified, and
     * <code>this.hoverStyle</code> is not null, that  css class will be applied to facet label hovers instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetLabelHoverStyle New facetLabelHoverStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public CubeGrid setFacetLabelHoverStyle(String facetLabelHoverStyle) {
        return (CubeGrid)setAttribute("facetLabelHoverStyle", facetLabelHoverStyle, true);
    }

    /**
     * Allows the developer to override the css class applied to  hover tips shown for facet labels.  If unspecified, and
     * <code>this.hoverStyle</code> is not null, that  css class will be applied to facet label hovers instead.
     *
     * @return Current facetLabelHoverStyle value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getFacetLabelHoverStyle()  {
        return getAttributeAsString("facetLabelHoverStyle");
    }
    

    /**
     * Allows the developer to override the vertical text alignment of hover tips shown for facetLabels.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverVAlign</code> if specified.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetLabelHoverVAlign New facetLabelHoverVAlign value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverVAlign
     */
    public CubeGrid setFacetLabelHoverVAlign(VerticalAlignment facetLabelHoverVAlign) {
        return (CubeGrid)setAttribute("facetLabelHoverVAlign", facetLabelHoverVAlign == null ? null : facetLabelHoverVAlign.getValue(), true);
    }

    /**
     * Allows the developer to override the vertical text alignment of hover tips shown for facetLabels.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverVAlign</code> if specified.
     *
     * @return Current facetLabelHoverVAlign value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverVAlign
     */
    public VerticalAlignment getFacetLabelHoverVAlign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("facetLabelHoverVAlign"));
    }
    

    /**
     * If specified and <code>this.showHover</code> is true, this is the default width to apply to hover tips shown for
     * facetLabels. If unset, the hover canvas will be sized to  <code>this.hoverWidth</code> if specified instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetLabelHoverWidth New facetLabelHoverWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverWidth
     */
    public CubeGrid setFacetLabelHoverWidth(Integer facetLabelHoverWidth) {
        return (CubeGrid)setAttribute("facetLabelHoverWidth", facetLabelHoverWidth, true);
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default width to apply to hover tips shown for
     * facetLabels. If unset, the hover canvas will be sized to  <code>this.hoverWidth</code> if specified instead.
     *
     * @return Current facetLabelHoverWidth value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverWidth
     */
    public Integer getFacetLabelHoverWidth()  {
        return getAttributeAsInt("facetLabelHoverWidth");
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default width to apply to hover tips shown for
     * facetLabels. If unset, the hover canvas will be sized to  <code>this.hoverWidth</code> if specified instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetLabelHoverWidth New facetLabelHoverWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverWidth
     */
    public CubeGrid setFacetLabelHoverWidth(String facetLabelHoverWidth) {
        return (CubeGrid)setAttribute("facetLabelHoverWidth", facetLabelHoverWidth, true);
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default width to apply to hover tips shown for
     * facetLabels. If unset, the hover canvas will be sized to  <code>this.hoverWidth</code> if specified instead.
     *
     * @return Current facetLabelHoverWidth value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverWidth
     */
    public String getFacetLabelHoverWidthAsString()  {
        return getAttributeAsString("facetLabelHoverWidth");
    }
    

    /**
     * Facet definitions for this CubeGrid.  Facets, also called "dimensions", are orthogonal aspects of the data model. <P>
     * For example, you can look at profit by the facets "plant and product" or by "product and plant" and it's the same
     * number, because the facets - plant and product - are the same. What would change the profit numbers would be to remove a
     * facet, called "summarizing", or add a new facet, called "drilling down".  For example, showing profit by plant and
     * product, you could "drill down" by adding the region facet, which would divide profit among each region.  Or you could
     * remove the "plant" facet, showing total profit for each "product", summed across all plants. <P> This property need not
     * be set and will automatically be constructed during widget initialization if data is provided up front and {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getRowFacets rowFacets} and  {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getColumnFacets columnFacets} have been set.  If {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getFacets facets} is not set and there is no initial data but a DataSource is
     * present, drawing the grid will automatically issue a fetch to allow {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getFacets facets} to be resolved.
     *
     * @param facets New facets value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFacet
     * @see com.smartgwt.client.widgets.cube.Facet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFacetValue
     * @see com.smartgwt.client.widgets.cube.FacetValue
     */
    public CubeGrid setFacets(Facet... facets)  throws IllegalStateException {
        return (CubeGrid)setAttribute("facets", facets, false);
    }
    

    /**
     * Default alignment for facet labels.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the align of a facet title (appears in facet label).
     *
     * @param facetTitleAlign facet to update. Default value is "center"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setFacetTitleAlign(Alignment facetTitleAlign) {
        return (CubeGrid)setAttribute("facetTitleAlign", facetTitleAlign == null ? null : facetTitleAlign.getValue(), true);
    }

    /**
     * Default alignment for facet labels.
     *
     * @return Current facetTitleAlign value. Default value is "center"
     */
    public Alignment getFacetTitleAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("facetTitleAlign"));
    }
    

    /**
     * Default alignment for facet values (in headers).
     *
     * @param facetValueAlign New facetValueAlign value. Default value is "center"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setFacetValueAlign(Alignment facetValueAlign) {
        return (CubeGrid)setAttribute("facetValueAlign", facetValueAlign == null ? null : facetValueAlign.getValue(), true);
    }

    /**
     * Default alignment for facet values (in headers).
     *
     * @return Current facetValueAlign value. Default value is "center"
     */
    public Alignment getFacetValueAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("facetValueAlign"));
    }
    

    /**
     * Array of MenuItem to replace the default menu.  Call {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getDefaultFacetValueContextItems getDefaultFacetValueContextItems()} to get a
     * default set of items to start with.
     *
     * @param facetValueContextItems New facetValueContextItems value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setFacetValueContextItems(MenuItem... facetValueContextItems) {
        return (CubeGrid)setAttribute("facetValueContextItems", facetValueContextItems, true);
    }

    /**
     * Array of MenuItem to replace the default menu.  Call {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getDefaultFacetValueContextItems getDefaultFacetValueContextItems()} to get a
     * default set of items to start with.
     *
     * @return Current facetValueContextItems value. Default value is null
     */
    public MenuItem[] getFacetValueContextItems()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfMenuItem(getAttributeAsJavaScriptObject("facetValueContextItems"));
    }
    

    /**
     * Allows the developer to override the horizontal text alignment of hover tips shown for facet values.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverAlign</code> if specified.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetValueHoverAlign New facetValueHoverAlign value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverAlign
     */
    public CubeGrid setFacetValueHoverAlign(Alignment facetValueHoverAlign) {
        return (CubeGrid)setAttribute("facetValueHoverAlign", facetValueHoverAlign == null ? null : facetValueHoverAlign.getValue(), true);
    }

    /**
     * Allows the developer to override the horizontal text alignment of hover tips shown for facet values.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverAlign</code> if specified.
     *
     * @return Current facetValueHoverAlign value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverAlign
     */
    public Alignment getFacetValueHoverAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("facetValueHoverAlign"));
    }
    

    /**
     * If specified and <code>this.showHover</code> is true, this is the default height to apply to hover tips shown for
     * facetValues. If unset, the hover canvas will be sized to  <code>this.hoverHeight</code> if specified instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetValueHoverHeight New facetValueHoverHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverHeight
     */
    public CubeGrid setFacetValueHoverHeight(Integer facetValueHoverHeight) {
        return (CubeGrid)setAttribute("facetValueHoverHeight", facetValueHoverHeight, true);
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default height to apply to hover tips shown for
     * facetValues. If unset, the hover canvas will be sized to  <code>this.hoverHeight</code> if specified instead.
     *
     * @return Current facetValueHoverHeight value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverHeight
     */
    public Integer getFacetValueHoverHeight()  {
        return getAttributeAsInt("facetValueHoverHeight");
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default height to apply to hover tips shown for
     * facetValues. If unset, the hover canvas will be sized to  <code>this.hoverHeight</code> if specified instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetValueHoverHeight New facetValueHoverHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverHeight
     */
    public CubeGrid setFacetValueHoverHeight(String facetValueHoverHeight) {
        return (CubeGrid)setAttribute("facetValueHoverHeight", facetValueHoverHeight, true);
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default height to apply to hover tips shown for
     * facetValues. If unset, the hover canvas will be sized to  <code>this.hoverHeight</code> if specified instead.
     *
     * @return Current facetValueHoverHeight value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverHeight
     */
    public String getFacetValueHoverHeightAsString()  {
        return getAttributeAsString("facetValueHoverHeight");
    }
    

    /**
     * Allows the developer to override the css class applied to  hover tips shown for facet values.  If unspecified, and
     * <code>this.hoverStyle</code> is not null, that  css class will be applied to facet value hovers instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetValueHoverStyle New facetValueHoverStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public CubeGrid setFacetValueHoverStyle(String facetValueHoverStyle) {
        return (CubeGrid)setAttribute("facetValueHoverStyle", facetValueHoverStyle, true);
    }

    /**
     * Allows the developer to override the css class applied to  hover tips shown for facet values.  If unspecified, and
     * <code>this.hoverStyle</code> is not null, that  css class will be applied to facet value hovers instead.
     *
     * @return Current facetValueHoverStyle value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getFacetValueHoverStyle()  {
        return getAttributeAsString("facetValueHoverStyle");
    }
    

    /**
     * Allows the developer to override the vertical text alignment of hover tips shown for facet values.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverVAlign</code> if specified.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetValueHoverVAlign New facetValueHoverVAlign value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverVAlign
     */
    public CubeGrid setFacetValueHoverVAlign(VerticalAlignment facetValueHoverVAlign) {
        return (CubeGrid)setAttribute("facetValueHoverVAlign", facetValueHoverVAlign == null ? null : facetValueHoverVAlign.getValue(), true);
    }

    /**
     * Allows the developer to override the vertical text alignment of hover tips shown for facet values.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverVAlign</code> if specified.
     *
     * @return Current facetValueHoverVAlign value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverVAlign
     */
    public VerticalAlignment getFacetValueHoverVAlign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("facetValueHoverVAlign"));
    }
    

    /**
     * If specified and <code>this.showHover</code> is true, this is the default width to apply to hover tips shown for
     * facetValues. If unset, the hover canvas will be sized to  <code>this.hoverWidth</code> if specified instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetValueHoverWidth New facetValueHoverWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverWidth
     */
    public CubeGrid setFacetValueHoverWidth(Integer facetValueHoverWidth) {
        return (CubeGrid)setAttribute("facetValueHoverWidth", facetValueHoverWidth, true);
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default width to apply to hover tips shown for
     * facetValues. If unset, the hover canvas will be sized to  <code>this.hoverWidth</code> if specified instead.
     *
     * @return Current facetValueHoverWidth value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverWidth
     */
    public Integer getFacetValueHoverWidth()  {
        return getAttributeAsInt("facetValueHoverWidth");
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default width to apply to hover tips shown for
     * facetValues. If unset, the hover canvas will be sized to  <code>this.hoverWidth</code> if specified instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetValueHoverWidth New facetValueHoverWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setHoverWidth
     */
    public CubeGrid setFacetValueHoverWidth(String facetValueHoverWidth) {
        return (CubeGrid)setAttribute("facetValueHoverWidth", facetValueHoverWidth, true);
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default width to apply to hover tips shown for
     * facetValues. If unset, the hover canvas will be sized to  <code>this.hoverWidth</code> if specified instead.
     *
     * @return Current facetValueHoverWidth value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getHoverWidth
     */
    public String getFacetValueHoverWidthAsString()  {
        return getAttributeAsString("facetValueHoverWidth");
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.cube.FacetValueMap} describing the set of facet values that should be regarded as
     * "fixed" in this cubeGrid.  These are used as fixed criteria for load on demand, and also allow using a dataset with more
     * facets in it than are currently shown in the grid.
     *
     * @param fixedFacetValues New fixedFacetValues value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.cube.CubeGrid#addFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#removeFacet
     */
    public CubeGrid setFixedFacetValues(FacetValueMap fixedFacetValues)  throws IllegalStateException {
        return (CubeGrid)setAttribute("fixedFacetValues", fixedFacetValues == null ? null : fixedFacetValues.getJsObj(), false);
    }

    /**
     * A {@link com.smartgwt.client.widgets.cube.FacetValueMap} describing the set of facet values that should be regarded as
     * "fixed" in this cubeGrid.  These are used as fixed criteria for load on demand, and also allow using a dataset with more
     * facets in it than are currently shown in the grid.
     *
     * @return Current fixedFacetValues value. Default value is null
     * @see com.smartgwt.client.widgets.cube.CubeGrid#addFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#removeFacet
     */
    public FacetValueMap getFixedFacetValues()  {
        return new FacetValueMap(getAttributeAsJavaScriptObject("fixedFacetValues"));
    }
    

    /**
     * With {@link com.smartgwt.client.widgets.cube.CubeGrid#getHideEmptyFacetValues hideEmptyFacetValues}, controls on which
     * axis hiding of empty values is applied, "row" (only empty rows are hidden), "column" (only empty columns are hidden) or
     * both (the default).
     *
     * @param hideEmptyAxis New hideEmptyAxis value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public CubeGrid setHideEmptyAxis(Axis hideEmptyAxis)  throws IllegalStateException {
        return (CubeGrid)setAttribute("hideEmptyAxis", hideEmptyAxis == null ? null : hideEmptyAxis.getValue(), false);
    }

    /**
     * With {@link com.smartgwt.client.widgets.cube.CubeGrid#getHideEmptyFacetValues hideEmptyFacetValues}, controls on which
     * axis hiding of empty values is applied, "row" (only empty rows are hidden), "column" (only empty columns are hidden) or
     * both (the default).
     *
     * @return Current hideEmptyAxis value. Default value is null
     */
    public Axis getHideEmptyAxis()  {
        return EnumUtil.getEnum(Axis.values(), getAttribute("hideEmptyAxis"));
    }
    

    /**
     * This causes the headers for any combination of facetValues for which there are no  cellRecords to be suppressed. <P> To
     * use this feature, either: <ul> <li> all must be provided via {@link com.smartgwt.client.widgets.grid.ListGrid#setData
     * setData()} before the CubeGrid is first drawn, OR <li> all data must be returned by the first DataSource fetch, OR <li>
     * {@link com.smartgwt.client.widgets.cube.CubeGrid#getHideEmptyAxis hideEmptyAxis} must be set to either "row" or "column"
     * so that empty values are only automatically hidden for one axis </ul> This last point is required because there is no
     * way to determine whether a row is empty unless data for all columns of the row has been loaded (and vice-versa).  For
     * this reason if you set hideEmptyFacetValues but do not set hideEmptyAxis, the default behavior of {@link
     * com.smartgwt.client.data.DataSource loading only visible data} is automatically disabled and only {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues fixedFacetValues} will be sent as criteria.
     *
     * @param hideEmptyFacetValues New hideEmptyFacetValues value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public CubeGrid setHideEmptyFacetValues(Boolean hideEmptyFacetValues)  throws IllegalStateException {
        return (CubeGrid)setAttribute("hideEmptyFacetValues", hideEmptyFacetValues, false);
    }

    /**
     * This causes the headers for any combination of facetValues for which there are no  cellRecords to be suppressed. <P> To
     * use this feature, either: <ul> <li> all must be provided via {@link com.smartgwt.client.widgets.grid.ListGrid#setData
     * setData()} before the CubeGrid is first drawn, OR <li> all data must be returned by the first DataSource fetch, OR <li>
     * {@link com.smartgwt.client.widgets.cube.CubeGrid#getHideEmptyAxis hideEmptyAxis} must be set to either "row" or "column"
     * so that empty values are only automatically hidden for one axis </ul> This last point is required because there is no
     * way to determine whether a row is empty unless data for all columns of the row has been loaded (and vice-versa).  For
     * this reason if you set hideEmptyFacetValues but do not set hideEmptyAxis, the default behavior of {@link
     * com.smartgwt.client.data.DataSource loading only visible data} is automatically disabled and only {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues fixedFacetValues} will be sent as criteria.
     *
     * @return Current hideEmptyFacetValues value. Default value is null
     */
    public Boolean getHideEmptyFacetValues()  {
        return getAttributeAsBoolean("hideEmptyFacetValues");
    }
    

    /**
     * Hilites to be applied to the data for this component.  See {@link com.smartgwt.client.docs.Hiliting}.
     *
     * @param hilites New hilites value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public CubeGrid setHilites(Hilite... hilites) {
        return (CubeGrid)setAttribute("hilites", hilites, true);
    }

    /**
     * Hilites to be applied to the data for this component.  See {@link com.smartgwt.client.docs.Hiliting}.
     *
     * @return Current hilites value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Hilite[] getHilites()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfHilite(getAttributeAsJavaScriptObject("hilites"));
    }
    

    /**
     * Turns on indenting of any {@link com.smartgwt.client.widgets.cube.Facet#getIsTree hierarchical} column facets.  This can
     * be overridden at the facet level via {@link com.smartgwt.client.widgets.cube.Facet#getIndentVTree Facet.indentVTree}. 
     * Setting this property also ensures that the header is sized tall enough to accommodate the fully expanded facet.   <P>
     * The amount of indenting per level can be set with {@link com.smartgwt.client.widgets.cube.CubeGrid#getVTreeFacetIndent
     * vTreeFacetIndent}, and the direction of the indenting specified with {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getVTreeFacetIndentDirection vTreeFacetIndentDirection}. <P> Note that if you
     * specify an explicit height for such a fscet, such as by setting {@link com.smartgwt.client.widgets.cube.Facet#getHeight
     * Facet.height} or {@link com.smartgwt.client.widgets.cube.Facet#getLabelHeight Facet.labelHeight}, then the greater of
     * that or the space required to accommodate the fully expanded facet will determine the actual height used.
     *
     * @param indentVTreeFacets New indentVTreeFacets value. Default value is false
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.cube.Facet#setIndentVTree
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setVTreeFacetIndent
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setVTreeFacetIndentDirection
     */
    public CubeGrid setIndentVTreeFacets(boolean indentVTreeFacets)  throws IllegalStateException {
        return (CubeGrid)setAttribute("indentVTreeFacets", indentVTreeFacets, false);
    }

    /**
     * Turns on indenting of any {@link com.smartgwt.client.widgets.cube.Facet#getIsTree hierarchical} column facets.  This can
     * be overridden at the facet level via {@link com.smartgwt.client.widgets.cube.Facet#getIndentVTree Facet.indentVTree}. 
     * Setting this property also ensures that the header is sized tall enough to accommodate the fully expanded facet.   <P>
     * The amount of indenting per level can be set with {@link com.smartgwt.client.widgets.cube.CubeGrid#getVTreeFacetIndent
     * vTreeFacetIndent}, and the direction of the indenting specified with {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getVTreeFacetIndentDirection vTreeFacetIndentDirection}. <P> Note that if you
     * specify an explicit height for such a fscet, such as by setting {@link com.smartgwt.client.widgets.cube.Facet#getHeight
     * Facet.height} or {@link com.smartgwt.client.widgets.cube.Facet#getLabelHeight Facet.labelHeight}, then the greater of
     * that or the space required to accommodate the fully expanded facet will determine the actual height used.
     *
     * @return Current indentVTreeFacets value. Default value is false
     * @see com.smartgwt.client.widgets.cube.Facet#getIndentVTree
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getVTreeFacetIndent
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getVTreeFacetIndentDirection
     */
    public boolean getIndentVTreeFacets()  {
        Boolean result = getAttributeAsBoolean("indentVTreeFacets");
        return result == null ? false : result;
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the buttons in the innermost column header for 
     * this cubeGrid.
     *
     * @param innerHeaderBaseStyle New innerHeaderBaseStyle value. Default value is "innerHeader"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CubeGrid setInnerHeaderBaseStyle(String innerHeaderBaseStyle)  throws IllegalStateException {
        return (CubeGrid)setAttribute("innerHeaderBaseStyle", innerHeaderBaseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the buttons in the innermost column header for 
     * this cubeGrid.
     *
     * @return Current innerHeaderBaseStyle value. Default value is "innerHeader"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getInnerHeaderBaseStyle()  {
        return getAttributeAsString("innerHeaderBaseStyle");
    }
    

    /**
     * In a CubeGrid that displays values of different types (eg "Revenue" and "Income"), the different types of values on
     * display are enumerated as the facet values of the "metric facet".   <P> The metric facet is treated identically to any
     * other facet by the CubeGrid: it can be represented as row or column headers, can be innermost or have other facets under
     * it, can be moved around, etc.  However when a metric facet is used, {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getMetricFacetId metricFacetId} must be set to allow the CubeGrid to generate
     * meaningful descriptions of values shown in cells for use in hovers and other situations; see {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getValueTitle valueTitle} for a full explanation.
     *
     * @param metricFacetId New metricFacetId value. Default value is "metric"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public CubeGrid setMetricFacetId(String metricFacetId)  throws IllegalStateException {
        return (CubeGrid)setAttribute("metricFacetId", metricFacetId, false);
    }

    /**
     * In a CubeGrid that displays values of different types (eg "Revenue" and "Income"), the different types of values on
     * display are enumerated as the facet values of the "metric facet".   <P> The metric facet is treated identically to any
     * other facet by the CubeGrid: it can be represented as row or column headers, can be innermost or have other facets under
     * it, can be moved around, etc.  However when a metric facet is used, {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getMetricFacetId metricFacetId} must be set to allow the CubeGrid to generate
     * meaningful descriptions of values shown in cells for use in hovers and other situations; see {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getValueTitle valueTitle} for a full explanation.
     *
     * @return Current metricFacetId value. Default value is "metric"
     */
    public String getMetricFacetId()  {
        return getAttributeAsString("metricFacetId");
    }
    

    /**
     * Whether to pad titles so they aren't flush with header borders.
     *
     * @param padTitles New padTitles value. Default value is true
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setPadTitles(Boolean padTitles) {
        return (CubeGrid)setAttribute("padTitles", padTitles, true);
    }

    /**
     * Whether to pad titles so they aren't flush with header borders.
     *
     * @return Current padTitles value. Default value is true
     */
    public Boolean getPadTitles()  {
        Boolean result = getAttributeAsBoolean("padTitles");
        return result == null ? true : result;
    }
    

    /**
     * facetValueId of the default rollupValue for each facet.  Can be overridden per facet via facet.rollupValue.
     *
     * @param rollupValue New rollupValue value. Default value is "sum"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public CubeGrid setRollupValue(String rollupValue)  throws IllegalStateException {
        return (CubeGrid)setAttribute("rollupValue", rollupValue, false);
    }

    /**
     * facetValueId of the default rollupValue for each facet.  Can be overridden per facet via facet.rollupValue.
     *
     * @return Get the facetValue definition for the facetValue to show when this facet is "rolled up" under another facet, during a
     * breakout.<br><br> A facet is not required to have a rollup value, and if it does not have one, then rollups will simply
     * be blank rows.  The facetValueId of the rollup value can be declared as cubeGrid.rollupValue or facet.rollupValue. Default value is "sum"
     */
    public String getRollupValue()  {
        return getAttributeAsString("rollupValue");
    }
    

    /**
     * This property is not supported for <code>CubeGrid</code>.
     *
     * @param rotateHeaderTitles New rotateHeaderTitles value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public CubeGrid setRotateHeaderTitles(Boolean rotateHeaderTitles)  throws IllegalStateException {
        return (CubeGrid)setAttribute("rotateHeaderTitles", rotateHeaderTitles, false);
    }

    /**
     * This property is not supported for <code>CubeGrid</code>.
     *
     * @return Current rotateHeaderTitles value. Default value is null
     */
    public Boolean getRotateHeaderTitles()  {
        return getAttributeAsBoolean("rotateHeaderTitles");
    }
    

    /**
     * The list of {@link com.smartgwt.client.widgets.cube.Facet#getId ids} for facets that will appear to the left of the
     * body.
     *
     * @param rowFacets New rowFacets value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setRowHeaderGridMode
     */
    public CubeGrid setRowFacets(String... rowFacets)  throws IllegalStateException {
        return (CubeGrid)setAttribute("rowFacets", rowFacets, false);
    }

    /**
     * The list of {@link com.smartgwt.client.widgets.cube.Facet#getId ids} for facets that will appear to the left of the
     * body.
     *
     * @return Current rowFacets value. Default value is null
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getRowHeaderGridMode
     */
    public String[] getRowFacets()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("rowFacets"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the buttons in this grid's row headers.
     *
     * @param rowHeaderBaseStyle New rowHeaderBaseStyle value. Default value is "rowHeader"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CubeGrid setRowHeaderBaseStyle(String rowHeaderBaseStyle)  throws IllegalStateException {
        return (CubeGrid)setAttribute("rowHeaderBaseStyle", rowHeaderBaseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the buttons in this grid's row headers.
     *
     * @return Current rowHeaderBaseStyle value. Default value is "rowHeader"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getRowHeaderBaseStyle()  {
        return getAttributeAsString("rowHeaderBaseStyle");
    }
    

    /**
     * If enabled row headers for this cubeGrid will be rendered using a {@link com.smartgwt.client.widgets.grid.GridRenderer}
     * component. This improves performance for very large cubeGrids. <P> Note that this attribute must be set for hierarchical
     * row facets to be indented properly.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param rowHeaderGridMode New rowHeaderGridMode value. Default value is false
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setRowFacets
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setCanCollapseFacets
     */
    public CubeGrid setRowHeaderGridMode(Boolean rowHeaderGridMode)  throws IllegalStateException {
        return (CubeGrid)setAttribute("rowHeaderGridMode", rowHeaderGridMode, false);
    }

    /**
     * If enabled row headers for this cubeGrid will be rendered using a {@link com.smartgwt.client.widgets.grid.GridRenderer}
     * component. This improves performance for very large cubeGrids. <P> Note that this attribute must be set for hierarchical
     * row facets to be indented properly.
     *
     * @return Current rowHeaderGridMode value. Default value is false
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getRowFacets
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getCanCollapseFacets
     */
    public Boolean getRowHeaderGridMode()  {
        Boolean result = getAttributeAsBoolean("rowHeaderGridMode");
        return result == null ? false : result;
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the facet-label buttons above the grid's  row
     * headers.
     *
     * @param rowHeaderLabelBaseStyle New rowHeaderLabelBaseStyle value. Default value is "rowHeaderLabel"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public CubeGrid setRowHeaderLabelBaseStyle(String rowHeaderLabelBaseStyle)  throws IllegalStateException {
        return (CubeGrid)setAttribute("rowHeaderLabelBaseStyle", rowHeaderLabelBaseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the facet-label buttons above the grid's  row
     * headers.
     *
     * @return Current rowHeaderLabelBaseStyle value. Default value is "rowHeaderLabel"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getRowHeaderLabelBaseStyle()  {
        return getAttributeAsString("rowHeaderLabelBaseStyle");
    }
    

    /**
     * CubeGrids only support editing by cell.
     * <p>
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Current saveByCell value. Default value is true
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Boolean getSaveByCell() throws IllegalStateException {
        errorIfNotCreated("saveByCell");
        Boolean result = getAttributeAsBoolean("saveByCell");
        return result == null ? true : result;
    }
    

    /**
     * If true, show facet label context menus with some built-in operations. Otherwise, use generic context menu handling.
     *
     * @param showFacetContextMenus New showFacetContextMenus value. Default value is false
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setShowFacetContextMenus(boolean showFacetContextMenus) {
        return (CubeGrid)setAttribute("showFacetContextMenus", showFacetContextMenus, true);
    }

    /**
     * If true, show facet label context menus with some built-in operations. Otherwise, use generic context menu handling.
     *
     * @return Current showFacetContextMenus value. Default value is false
     */
    public boolean getShowFacetContextMenus()  {
        Boolean result = getAttributeAsBoolean("showFacetContextMenus");
        return result == null ? false : result;
    }
    

    /**
     * If true, show facet value context menus with some built-in operations. Otherwise, use generic context menu handling. Use
     * this in place of {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu
     * ListGrid.showHeaderContextMenu} and {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton
     * ListGrid.showHeaderMenuButton} for CubeGrids.
     *
     * @param showFacetValueContextMenus New showFacetValueContextMenus value. Default value is true
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setShowFacetValueContextMenus(boolean showFacetValueContextMenus) {
        return (CubeGrid)setAttribute("showFacetValueContextMenus", showFacetValueContextMenus, true);
    }

    /**
     * If true, show facet value context menus with some built-in operations. Otherwise, use generic context menu handling. Use
     * this in place of {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu
     * ListGrid.showHeaderContextMenu} and {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton
     * ListGrid.showHeaderMenuButton} for CubeGrids.
     *
     * @return Current showFacetValueContextMenus value. Default value is true
     */
    public boolean getShowFacetValueContextMenus()  {
        Boolean result = getAttributeAsBoolean("showFacetValueContextMenus");
        return result == null ? true : result;
    }
    

    /**
     * If true, clicking on the existing selection causes it to be entirely deselected.
     *
     * @param simpleDeselect New simpleDeselect value. Default value is false
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setSimpleDeselect(Boolean simpleDeselect) {
        return (CubeGrid)setAttribute("simpleDeselect", simpleDeselect, true);
    }

    /**
     * If true, clicking on the existing selection causes it to be entirely deselected.
     *
     * @return Current simpleDeselect value. Default value is false
     */
    public Boolean getSimpleDeselect()  {
        Boolean result = getAttributeAsBoolean("simpleDeselect");
        return result == null ? false : result;
    }
    

    /**
     * Default directory for skin images (those defined by the class), relative to the Page-wide {@link
     * com.smartgwt.client.util.Page#getSkinDir skinDir}.
     *
     * @param skinImgDir New skinImgDir value. Default value is "images/CubeGrid/"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public CubeGrid setSkinImgDir(String skinImgDir)  throws IllegalStateException {
        return (CubeGrid)setAttribute("skinImgDir", skinImgDir, false);
    }

    /**
     * Default directory for skin images (those defined by the class), relative to the Page-wide {@link
     * com.smartgwt.client.util.Page#getSkinDir skinDir}.
     *
     * @return Current skinImgDir value. Default value is "images/CubeGrid/"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }
    

    /**
     * Direction of sorting if sortedFacet or sortedFacetValues is specified.
     *
     * @param sortDirection New sortDirection value. Default value is "ascending"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setSortDirection(SortDirection sortDirection) {
        return (CubeGrid)setAttribute("sortDirection", sortDirection == null ? null : sortDirection.getValue(), true);
    }

    /**
     * Direction of sorting if sortedFacet or sortedFacetValues is specified.
     *
     * @return Current sortDirection value. Default value is "ascending"
     */
    public SortDirection getSortDirection()  {
        return EnumUtil.getEnum(SortDirection.values(), getAttribute("sortDirection"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.cube.FacetValueMap} of facet values representing a set of facetValues by which the
     * cubeGrid data is sorted.
     *
     * @param sortedFacetValues New sortedFacetValues value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setSortedFacetValues(FacetValueMap sortedFacetValues) {
        return (CubeGrid)setAttribute("sortedFacetValues", sortedFacetValues == null ? null : sortedFacetValues.getJsObj(), true);
    }

    /**
     * {@link com.smartgwt.client.widgets.cube.FacetValueMap} of facet values representing a set of facetValues by which the
     * cubeGrid data is sorted.
     *
     * @return Current sortedFacetValues value. Default value is null
     */
    public FacetValueMap getSortedFacetValues()  {
        return new FacetValueMap(getAttributeAsJavaScriptObject("sortedFacetValues"));
    }
    

    /**
     * CSS class for the CubeGrid as a whole
     *
     * @param styleName New styleName value. Default value is "normal"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * CSS class for the CubeGrid as a whole
     *
     * @return Current styleName value. Default value is "normal"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * {@link com.smartgwt.client.docs.FormatString} used during exports for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getExportFormat DataSourceField.exportFormat}.
     *
     * @param valueExportFormat New valueExportFormat value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public CubeGrid setValueExportFormat(String valueExportFormat)  throws IllegalStateException {
        return (CubeGrid)setAttribute("valueExportFormat", valueExportFormat, false);
    }

    /**
     * {@link com.smartgwt.client.docs.FormatString} used during exports for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getExportFormat DataSourceField.exportFormat}.
     *
     * @return Current valueExportFormat value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public String getValueExportFormat()  {
        return getAttributeAsString("valueExportFormat");
    }
    

    /**
     * {@link com.smartgwt.client.docs.FormatString} for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getFormat DataSourceField.format}.
     *
     * @param valueFormat New valueFormat value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public CubeGrid setValueFormat(String valueFormat)  throws IllegalStateException {
        return (CubeGrid)setAttribute("valueFormat", valueFormat, false);
    }

    /**
     * {@link com.smartgwt.client.docs.FormatString} for numeric or date formatting.  See {@link
     * com.smartgwt.client.data.DataSourceField#getFormat DataSourceField.format}.
     *
     * @return Current valueFormat value. Default value is null
     * @see com.smartgwt.client.docs.FormatString FormatString 
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public String getValueFormat()  {
        return getAttributeAsString("valueFormat");
    }
    

    /**
     * Name of the property in a cell record that holds the cell value.
     *
     * @param valueProperty New valueProperty value. Default value is "_value"
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public CubeGrid setValueProperty(String valueProperty)  throws IllegalStateException {
        return (CubeGrid)setAttribute("valueProperty", valueProperty, false);
    }

    /**
     * Name of the property in a cell record that holds the cell value.
     *
     * @return Current valueProperty value. Default value is "_value"
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public String getValueProperty()  {
        return getAttributeAsString("valueProperty");
    }
    

    /**
     * A label for the data values shown in cells, such as "Sales in Thousands", typically used
     *  when the CubeGrid must generate a description for a cell value or set of cell values.
     *  <P>
     *  For example, in a CubeGrid showing "Revenue" by region and product, a cell with a
     *  CellRecord like:
     *  <pre> 
     *  {product:"chairs", region:"northwest", _value:"$5k"}
     *  </pre>
     *  Should be described as "Revenue for Chairs for Northwest Region", not "Chairs for
     *  Revenue for Northwest Region".
     *  <P>
     *  For CubeGrids that show multiple types of values at once (eg both "Revenue" and
     *  "Income") see {@link com.smartgwt.client.widgets.cube.CubeGrid#getMetricFacetId metricFacetId}.
     *
     * @param valueTitle New valueTitle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public CubeGrid setValueTitle(String valueTitle)  throws IllegalStateException {
        return (CubeGrid)setAttribute("valueTitle", valueTitle, false);
    }

    /**
     * A label for the data values shown in cells, such as "Sales in Thousands", typically used
     *  when the CubeGrid must generate a description for a cell value or set of cell values.
     *  <P>
     *  For example, in a CubeGrid showing "Revenue" by region and product, a cell with a
     *  CellRecord like:
     *  <pre> 
     *  {product:"chairs", region:"northwest", _value:"$5k"}
     *  </pre>
     *  Should be described as "Revenue for Chairs for Northwest Region", not "Chairs for
     *  Revenue for Northwest Region".
     *  <P>
     *  For CubeGrids that show multiple types of values at once (eg both "Revenue" and
     *  "Income") see {@link com.smartgwt.client.widgets.cube.CubeGrid#getMetricFacetId metricFacetId}.
     *
     * @return Current valueTitle value. Default value is null
     */
    public String getValueTitle()  {
        return getAttributeAsString("valueTitle");
    }
    

    /**
     * Determines how many pixels to move for each level when {@link com.smartgwt.client.widgets.cube.Facet#getIsTree
     * hierarchical} column facets are being {@link com.smartgwt.client.widgets.cube.CubeGrid#getIndentVTreeFacets indented}.
     *
     * @param vTreeFacetIndent New vTreeFacetIndent value. Default value is 8
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setIndentVTreeFacets
     */
    public CubeGrid setVTreeFacetIndent(int vTreeFacetIndent)  throws IllegalStateException {
        return (CubeGrid)setAttribute("vTreeFacetIndent", vTreeFacetIndent, false);
    }

    /**
     * Determines how many pixels to move for each level when {@link com.smartgwt.client.widgets.cube.Facet#getIsTree
     * hierarchical} column facets are being {@link com.smartgwt.client.widgets.cube.CubeGrid#getIndentVTreeFacets indented}.
     *
     * @return Current vTreeFacetIndent value. Default value is 8
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getIndentVTreeFacets
     */
    public int getVTreeFacetIndent()  {
        return getAttributeAsInt("vTreeFacetIndent");
    }
    

    /**
     * Determines layout of facet value titles in each column facet being  {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getIndentVTreeFacets indented}.
     *
     * @param vTreeFacetIndentDirection New vTreeFacetIndentDirection value. Default value is CubeGrid.DESCENDING
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setIndentVTreeFacets
     */
    public CubeGrid setVTreeFacetIndentDirection(FacetIndentDirection vTreeFacetIndentDirection) {
        return (CubeGrid)setAttribute("vTreeFacetIndentDirection", vTreeFacetIndentDirection == null ? null : vTreeFacetIndentDirection.getValue(), true);
    }

    /**
     * Determines layout of facet value titles in each column facet being  {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getIndentVTreeFacets indented}.
     *
     * @return Current vTreeFacetIndentDirection value. Default value is CubeGrid.DESCENDING
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getIndentVTreeFacets
     */
    public FacetIndentDirection getVTreeFacetIndentDirection()  {
        return EnumUtil.getEnum(FacetIndentDirection.values(), getAttribute("vTreeFacetIndentDirection"));
    }
    

    /**
     * Whether to allow text wrapping on facet titles.
     *
     * @param wrapFacetTitles New wrapFacetTitles value. Default value is false
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setWrapFacetTitles(Boolean wrapFacetTitles) {
        return (CubeGrid)setAttribute("wrapFacetTitles", wrapFacetTitles, true);
    }

    /**
     * Whether to allow text wrapping on facet titles.
     *
     * @return Current wrapFacetTitles value. Default value is false
     */
    public Boolean getWrapFacetTitles()  {
        Boolean result = getAttributeAsBoolean("wrapFacetTitles");
        return result == null ? false : result;
    }
    

    /**
     * Whether to allow text wrapping on facet value titles. <P> Note that this property is incompatible with {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getIndentVTreeFacets indented} column facets.
     *
     * @param wrapFacetValueTitles New wrapFacetValueTitles value. Default value is false
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining setter calls
     */
    public CubeGrid setWrapFacetValueTitles(Boolean wrapFacetValueTitles) {
        return (CubeGrid)setAttribute("wrapFacetValueTitles", wrapFacetValueTitles, true);
    }

    /**
     * Whether to allow text wrapping on facet value titles. <P> Note that this property is incompatible with {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getIndentVTreeFacets indented} column facets.
     *
     * @return Current wrapFacetValueTitles value. Default value is false
     */
    public Boolean getWrapFacetValueTitles()  {
        Boolean result = getAttributeAsBoolean("wrapFacetValueTitles");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Add a column facet to the view at index "index".  Handles the facet already being in the view (does a pivot).<br><br>
     * The facet being added should currently have a fixed facet value (unless it's already part of the view), which will be
     * removed from cubeGrid.fixedFacetValues. <br><i>methodType</i>  action
     * @param facetId facetId to add.  Definition must have been provided at init time.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @see com.smartgwt.client.widgets.cube.CubeGrid#removeFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     * @see com.smartgwt.client.docs.Identifier Identifier
     */
    public native void addColumnFacet(String facetId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addColumnFacet", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addColumnFacet(facetId);
    }-*/;

	/**
     * Add a column facet to the view at index "index".  Handles the facet already being in the view (does a pivot).<br><br>
     * The facet being added should currently have a fixed facet value (unless it's already part of the view), which will be
     * removed from cubeGrid.fixedFacetValues. <br><i>methodType</i>  action
     * @param facetId facetId to add.  Definition must have been provided at init time.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param index index to add the facet at.  0 = outermost (default innermost)
     * @see com.smartgwt.client.widgets.cube.CubeGrid#removeFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     */
    public native void addColumnFacet(String facetId, Integer index) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addColumnFacet", "String,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addColumnFacet(facetId, index == null ? null : index.@java.lang.Integer::intValue()());
    }-*/;
	
	/**
     * Add a facet to the view, into the row or column facets (intoRows true or false), at index "index".  Handles the facet
     * already being in the view (does a pivot). <P> The facet being added should currently have a fixed facet value (unless
     * it's already part of the view), which will be removed from cubeGrid.fixedFacetValues.
     * @param facetId facetId to add.  Definition must have been provided at init time.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @see com.smartgwt.client.widgets.cube.CubeGrid#removeFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     * @see com.smartgwt.client.docs.Identifier Identifier
     */
    public native void addFacet(String facetId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addFacet", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addFacet(facetId);
    }-*/;

    /**
     * @see CubeGrid#addFacet
     */
    public void addFacet(String facetId, Boolean intoRows){
        addFacet(facetId, intoRows, (Integer) null);
    }

	/**
     * Add a facet to the view, into the row or column facets (intoRows true or false), at index "index".  Handles the facet
     * already being in the view (does a pivot). <P> The facet being added should currently have a fixed facet value (unless
     * it's already part of the view), which will be removed from cubeGrid.fixedFacetValues.
     * @param facetId facetId to add.  Definition must have been provided at init time.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param intoRows whether to add facet as a row facet
     * @param index index to add the facet at.  0 = outermost (default innermost)
     * @see com.smartgwt.client.widgets.cube.CubeGrid#removeFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     */
    public native void addFacet(String facetId, Boolean intoRows, Integer index) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addFacet", "String,Boolean,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addFacet(facetId, intoRows == null ? null : intoRows.@java.lang.Boolean::booleanValue()(), index == null ? null : index.@java.lang.Integer::intValue()());
    }-*/;
	
	/**
     * Add a row facet to the view at index "index".  Handles the facet already being in the view (does a pivot).<br><br> The
     * facet being added should currently have a fixed facet value (unless it's already part of the view), which will be
     * removed from cubeGrid.fixedFacetValues. <br><i>methodType</i>  action
     * @param facetId facetId to add.  Definition must have been provided at init time.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @see com.smartgwt.client.widgets.cube.CubeGrid#removeFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     * @see com.smartgwt.client.docs.Identifier Identifier
     */
    public native void addRowFacet(String facetId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addRowFacet", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addRowFacet(facetId);
    }-*/;

	/**
     * Add a row facet to the view at index "index".  Handles the facet already being in the view (does a pivot).<br><br> The
     * facet being added should currently have a fixed facet value (unless it's already part of the view), which will be
     * removed from cubeGrid.fixedFacetValues. <br><i>methodType</i>  action
     * @param facetId facetId to add.  Definition must have been provided at init time.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param index index to add the facet at.  0 = outermost (default innermost)
     * @see com.smartgwt.client.widgets.cube.CubeGrid#removeFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     */
    public native void addRowFacet(String facetId, Integer index) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addRowFacet", "String,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addRowFacet(facetId, index == null ? null : index.@java.lang.Integer::intValue()());
    }-*/;
	
	/**
     * Determine whether any cells are selected in this cubeGrid.  <br><i>methodType</i> tester
     *
     * @return true if any cells are selected
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native Boolean anyCellSelected() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "anyCellSelected", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.anyCellSelected();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * auto-size the header facet horizontally
     * @param facetId ID of facet to resize.
     */
    public native void autoSizeFacet(String facetId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "autoSizeFacet", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.autoSizeFacet(facetId);
    }-*/;

	/**
     * Determine whether the cell passed in is selected in this cubeGrid.  <br><i>methodType</i> tester
     * @param cell cell to test
     *
     * @return true if any cells are selected
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native Boolean cellIsSelected(CellRecord cell) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "cellIsSelected", "CellRecord");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.cellIsSelected(cell.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Handler fired when facet is closed      <br><i>methodType</i> handler
     * @param facetId ID of facet that was closed
     */
    public native void closeFacet(String facetId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "closeFacet", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.closeFacet(facetId);
    }-*/;

	/**
     * Collapses the specified field.  No-ops if it's not showing, or it it's already collapsed.
     * @param facetValueMap field specified as a facetValueMap
     *
     * @return whether specified field was actually collapsed
     */
    public native Boolean collapseField(FacetValueMap facetValueMap) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "collapseField", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.collapseField(facetValueMap == null ? null : facetValueMap.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Notification method fired when new data arrives from the server to be displayed in this CubeGrid.  For example in
     * response to the user openng a collapsed facet, or as a result of an initial fetch request for all data from a CubeGrid
     * where {@link com.smartgwt.client.widgets.cube.CubeGrid#getFacets facets} is not set and there is no initial data.  Only
     * applies to databound CubeGrids.
     */
    public native void dataArrived() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "dataArrived", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.dataArrived();
    }-*/;

	/**
     * Deselect all cells and facetValues.      <br><i>methodType</i> action
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void deselectAll() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectAll", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectAll();
    }-*/;

	/**
     * Deselect all cells.
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void deselectAllCells() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectAllCells", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectAllCells();
    }-*/;

	/**
     * Deselect all headers in a headerBar (specified by facetId) or all headerBars (if no facetId).  <br><i>methodType</i>
     * action
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void deselectAllFacetValues() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectAllFacetValues", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectAllFacetValues();
    }-*/;

	/**
     * Deselect all headers in a headerBar (specified by facetId) or all headerBars (if no facetId).  <br><i>methodType</i>
     * action
     * @param facetId ID of facet - if null, selects all headerbars' headers
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void deselectAllFacetValues(String facetId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectAllFacetValues", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectAllFacetValues(facetId);
    }-*/;
	
	/**
     * Deselect cells that match a {@link com.smartgwt.client.widgets.cube.FacetValueMap}. Also supports an explicit list of
     * CellRecords or cell IDs.
     * @param cellList cells to deselect
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void deselectCells(CellRecord[] cellList) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectCells", "CellRecord[]");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectCells(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(cellList));
    }-*/;

	/**
     * Deselect cells that match a {@link com.smartgwt.client.widgets.cube.FacetValueMap}. Also supports an explicit list of
     * CellRecords or cell IDs.
     * @param cellList cells to deselect
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void deselectCells(FacetValueMap cellList) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectCells", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectCells(cellList == null ? null : cellList.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Deselect cells that match a {@link com.smartgwt.client.widgets.cube.FacetValueMap}. Also supports an explicit list of
     * CellRecords or cell IDs.
     * @param cellList cells to deselect
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void deselectCells(String... cellList) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectCells", "String...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectCells(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(cellList));
    }-*/;

	/**
     * Deselect the header for a given facet value.  <br><i>methodType</i> action
     * @param facetId ID of facet
     * @param facetValueId ID of facetValue to select
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void deselectFacetValue(String facetId, String facetValueId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselectFacetValue", "String,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectFacetValue(facetId, facetValueId);
    }-*/;

	/**
     * Expands the specified field.  No-ops if it's not showing, or if it's already expanded.
     * @param facetValueMap field specified as a facetValueMap
     *
     * @return whether specified field was actually expanded
     */
    public native Boolean expandField(FacetValueMap facetValueMap) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "expandField", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.expandField(facetValueMap == null ? null : facetValueMap.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Exports this component's data with client-side formatters applied, so is suitable for direct display to users.  This
     * feature requires the Smart GWT server. <P> The export format will combine the column facet value titles, generating a
     * single row of column headers at the top with titles such as "All Years - Budget" if Time and Scenario were column
     * facets.  The row facet value titles for separate facets won't be combined, so that each row facet will have a separate
     * column, with the facet titles at the top in the  "column header" row, and the row facet value titles below their
     * corresponding facet title. Data values each get their own row and column position.
     * @param settings contains configuration settings for the export, including: <ul> <li>facetSeparatorString (String) - if specified, the
     * separator to use in favor     of {@link com.smartgwt.client.widgets.cube.CubeGrid#getExportFacetSeparatorString
     * exportFacetSeparatorString} when combining titles from multiple     facet values.</li> </ul>
     * @see com.smartgwt.client.widgets.grid.ListGrid#exportClientData
     */
    public native void exportClientData(Map settings) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportClientData", "Map");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData(settings == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(settings));
    }-*/;

    /**
     * @see CubeGrid#exportClientData
     */
    public void exportClientData(Map settings, DSRequest requestProperties){
        exportClientData(settings, requestProperties, null);
    }

	/**
     * Exports this component's data with client-side formatters applied, so is suitable for direct display to users.  This
     * feature requires the Smart GWT server. <P> The export format will combine the column facet value titles, generating a
     * single row of column headers at the top with titles such as "All Years - Budget" if Time and Scenario were column
     * facets.  The row facet value titles for separate facets won't be combined, so that each row facet will have a separate
     * column, with the facet titles at the top in the  "column header" row, and the row facet value titles below their
     * corresponding facet title. Data values each get their own row and column position.
     * @param settings contains configuration settings for the export, including: <ul> <li>facetSeparatorString (String) - if specified, the
     * separator to use in favor     of {@link com.smartgwt.client.widgets.cube.CubeGrid#getExportFacetSeparatorString
     * exportFacetSeparatorString} when combining titles from multiple     facet values.</li> </ul>
     * @param requestProperties Request properties for the export.
     * @param callback Optional callback.  If  you specify {@link com.smartgwt.client.data.DSRequest#getExportToClient exportToClient}: false
     * in the request  properties, this callback will fire after export completes.  Otherwise the callback will  fire right
     * before the download request is made to the server.
     * @see com.smartgwt.client.widgets.grid.ListGrid#exportClientData
     */
    public native void exportClientData(Map settings, DSRequest requestProperties, RPCCallback callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportClientData", "Map,DSRequest,RPCCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData(settings == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(settings), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(response, rawData, request) { 
				if(callback!=null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(
					@com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response), 
					rawData, 
					@com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request)
				);
			}));
    }-*/;
	
    /**
     * Add a facetAdded handler.
     * <p>
     * Notification fired when a new facet is added.
     *
     * @param handler the facetAdded handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFacetAddedHandler(com.smartgwt.client.widgets.cube.events.FacetAddedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetAddedEvent.getType()) == 0) setupFacetAddedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.cube.events.FacetAddedEvent.getType());
    }

    private native void setupFacetAddedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var facetAdded = $entry(function(){
            var param = {"_this": this, "facetId" : arguments[0]};
            var event = @com.smartgwt.client.widgets.cube.events.FacetAddedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.cube.CubeGrid::handleTearDownFacetAddedEvent()();
            if (hasDefaultHandler) this.Super("facetAdded", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("facetAdded"));
            obj.addProperties({facetAdded:  facetAdded              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("facetAdded"));
            obj.facetAdded =  facetAdded             ;
        }
    }-*/;

    private void handleTearDownFacetAddedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetAddedEvent.getType()) == 0) tearDownFacetAddedEvent();
    }

    private native void tearDownFacetAddedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("facetAdded")) delete obj.facetAdded;
    }-*/;

    /**
     * Add a facetContextClick handler.
     * <p>
     * StringMethod handler fired when the user right clicks on a facet label.
     *
     * @param handler the facetContextClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFacetContextClickHandler(com.smartgwt.client.widgets.cube.events.FacetContextClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetContextClickEvent.getType()) == 0) setupFacetContextClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.cube.events.FacetContextClickEvent.getType());
    }

    private native void setupFacetContextClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var facetContextClick = $entry(function(){
            var param = {"_this": this, "facetId" : arguments[0]};
            var event = @com.smartgwt.client.widgets.cube.events.FacetContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.cube.CubeGrid::handleTearDownFacetContextClickEvent()();
            if (hasDefaultHandler) this.Super("facetContextClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("facetContextClick"));
            obj.addProperties({facetContextClick:  facetContextClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("facetContextClick"));
            obj.facetContextClick =  facetContextClick             ;
        }
    }-*/;

    private void handleTearDownFacetContextClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetContextClickEvent.getType()) == 0) tearDownFacetContextClickEvent();
    }

    private native void tearDownFacetContextClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("facetContextClick")) delete obj.facetContextClick;
    }-*/;

	/**
     * Return whether any facet value for this facet is selected in headers.  If no facetId passed, return whether any facet
     * has a selection.  <br><i>methodType</i> tester
     * @param facetId Id for facet to test
     *
     * @return true if any facet value in this header is selected
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native Boolean facetHasSelection(String facetId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "facetHasSelection", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.facetHasSelection(facetId);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    /**
     * Add a facetLabelClick handler.
     * <p>
     * Method handler fired when the user clicks on a facet label.
     *
     * @param handler the facetLabelClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFacetLabelClickHandler(com.smartgwt.client.widgets.cube.events.FacetLabelClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetLabelClickEvent.getType()) == 0) setupFacetLabelClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.cube.events.FacetLabelClickEvent.getType());
    }

    private native void setupFacetLabelClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var facetLabelClick = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.cube.events.FacetLabelClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.cube.CubeGrid::handleTearDownFacetLabelClickEvent()();
            if (hasDefaultHandler) this.Super("facetLabelClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("facetLabelClick"));
            obj.addProperties({facetLabelClick:  facetLabelClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("facetLabelClick"));
            obj.facetLabelClick =  facetLabelClick             ;
        }
    }-*/;

    private void handleTearDownFacetLabelClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetLabelClickEvent.getType()) == 0) tearDownFacetLabelClickEvent();
    }

    private native void tearDownFacetLabelClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("facetLabelClick")) delete obj.facetLabelClick;
    }-*/;

    /**
     * Add a facetMoved handler.
     * <p>
     * Notification fired when a facet is moved.
     *
     * @param handler the facetMoved handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFacetMovedHandler(com.smartgwt.client.widgets.cube.events.FacetMovedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetMovedEvent.getType()) == 0) setupFacetMovedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.cube.events.FacetMovedEvent.getType());
    }

    private native void setupFacetMovedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var facetMoved = $entry(function(){
            var param = {"_this": this, "facetId" : arguments[0]};
            var event = @com.smartgwt.client.widgets.cube.events.FacetMovedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.cube.CubeGrid::handleTearDownFacetMovedEvent()();
            if (hasDefaultHandler) this.Super("facetMoved", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("facetMoved"));
            obj.addProperties({facetMoved:  facetMoved              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("facetMoved"));
            obj.facetMoved =  facetMoved             ;
        }
    }-*/;

    private void handleTearDownFacetMovedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetMovedEvent.getType()) == 0) tearDownFacetMovedEvent();
    }

    private native void tearDownFacetMovedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("facetMoved")) delete obj.facetMoved;
    }-*/;

    /**
     * Add a facetRemoved handler.
     * <p>
     * Notification fired when a facet is removed.
     *
     * @param handler the facetRemoved handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFacetRemovedHandler(com.smartgwt.client.widgets.cube.events.FacetRemovedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetRemovedEvent.getType()) == 0) setupFacetRemovedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.cube.events.FacetRemovedEvent.getType());
    }

    private native void setupFacetRemovedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var facetRemoved = $entry(function(){
            var param = {"_this": this, "facetId" : arguments[0]};
            var event = @com.smartgwt.client.widgets.cube.events.FacetRemovedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.cube.CubeGrid::handleTearDownFacetRemovedEvent()();
            if (hasDefaultHandler) this.Super("facetRemoved", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("facetRemoved"));
            obj.addProperties({facetRemoved:  facetRemoved              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("facetRemoved"));
            obj.facetRemoved =  facetRemoved             ;
        }
    }-*/;

    private void handleTearDownFacetRemovedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetRemovedEvent.getType()) == 0) tearDownFacetRemovedEvent();
    }

    private native void tearDownFacetRemovedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("facetRemoved")) delete obj.facetRemoved;
    }-*/;

    /**
     * Add a facetValueContextClick handler.
     * <p>
     * StringMethod handler fired when context click occurs over a facetValue button in a header.
     *
     * @param handler the facetValueContextClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFacetValueContextClickHandler(com.smartgwt.client.widgets.cube.events.FacetValueContextClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetValueContextClickEvent.getType()) == 0) setupFacetValueContextClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.cube.events.FacetValueContextClickEvent.getType());
    }

    private native void setupFacetValueContextClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var facetValueContextClick = $entry(function(){
            var param = {"_this": this, "facetValues" : arguments[0]};
            var event = @com.smartgwt.client.widgets.cube.events.FacetValueContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.cube.CubeGrid::handleTearDownFacetValueContextClickEvent()();
            if (hasDefaultHandler) this.Super("facetValueContextClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("facetValueContextClick"));
            obj.addProperties({facetValueContextClick:  facetValueContextClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("facetValueContextClick"));
            obj.facetValueContextClick =  facetValueContextClick             ;
        }
    }-*/;

    private void handleTearDownFacetValueContextClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetValueContextClickEvent.getType()) == 0) tearDownFacetValueContextClickEvent();
    }

    private native void tearDownFacetValueContextClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("facetValueContextClick")) delete obj.facetValueContextClick;
    }-*/;

    /**
     * Add a facetValueSelectionChanged handler.
     * <p>
     * Handler/Notification function for facetValue selection change (no default implementation).
     *
     * @param handler the facetValueSelectionChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFacetValueSelectionChangedHandler(com.smartgwt.client.widgets.cube.events.FacetValueSelectionChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetValueSelectionChangedEvent.getType()) == 0) setupFacetValueSelectionChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.cube.events.FacetValueSelectionChangedEvent.getType());
    }

    private native void setupFacetValueSelectionChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var facetValueSelectionChanged = $entry(function(){
            var param = {"_this": this, "facetValues" : arguments[0], "newState" : arguments[1]};
            var event = @com.smartgwt.client.widgets.cube.events.FacetValueSelectionChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.cube.CubeGrid::handleTearDownFacetValueSelectionChangedEvent()();
            if (hasDefaultHandler) this.Super("facetValueSelectionChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("facetValueSelectionChanged"));
            obj.addProperties({facetValueSelectionChanged:  facetValueSelectionChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("facetValueSelectionChanged"));
            obj.facetValueSelectionChanged =  facetValueSelectionChanged             ;
        }
    }-*/;

    private void handleTearDownFacetValueSelectionChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.cube.events.FacetValueSelectionChangedEvent.getType()) == 0) tearDownFacetValueSelectionChangedEvent();
    }

    private native void tearDownFacetValueSelectionChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("facetValueSelectionChanged")) delete obj.facetValueSelectionChanged;
    }-*/;

    /**
     * Add a fixedFacetValueChanged handler.
     * <p>
     * Notification fired when a fixed facet value is set for some facet.
     *
     * @param handler the fixedFacetValueChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFixedFacetValueChangedHandler(com.smartgwt.client.widgets.cube.events.FixedFacetValueChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.cube.events.FixedFacetValueChangedEvent.getType()) == 0) setupFixedFacetValueChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.cube.events.FixedFacetValueChangedEvent.getType());
    }

    private native void setupFixedFacetValueChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var fixedFacetValueChanged = $entry(function(){
            var param = {"_this": this, "facetId" : arguments[0], "facetValueId" : arguments[1]};
            var event = @com.smartgwt.client.widgets.cube.events.FixedFacetValueChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.cube.CubeGrid::handleTearDownFixedFacetValueChangedEvent()();
            if (hasDefaultHandler) this.Super("fixedFacetValueChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("fixedFacetValueChanged"));
            obj.addProperties({fixedFacetValueChanged:  fixedFacetValueChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("fixedFacetValueChanged"));
            obj.fixedFacetValueChanged =  fixedFacetValueChanged             ;
        }
    }-*/;

    private void handleTearDownFixedFacetValueChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.cube.events.FixedFacetValueChangedEvent.getType()) == 0) tearDownFixedFacetValueChangedEvent();
    }

    private native void tearDownFixedFacetValueChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("fixedFacetValueChanged")) delete obj.fixedFacetValueChanged;
    }-*/;

	/**
     * Given a record in this grid, this method returns the colNum in which the record is displayed.
     * @param cellRecord record to find coordinates for
     *
     * @return Column number for the record. Returns -1 if the record is not found.
     */
    public native int getCellColumn(CellRecord cellRecord) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCellColumn", "CellRecord");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCellColumn(cellRecord.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Given a cell coordinate within this CubeGrid return a {@link com.smartgwt.client.widgets.cube.FacetValueMap} indicating
     * the facet values for the cell.
     * @param rowNum row index of the cell
     * @param colNum column index of the cell
     *
     * @return facet values for the specified cell. Returns null if the specified                         cell is not present in the
     * grid.
     */
    public native FacetValueMap getCellFacetValues(int rowNum, int colNum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCellFacetValues", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCellFacetValues(rowNum, colNum);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.cube.FacetValueMap::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return the pointer to a particular record by record and column number.<br>
     * @param rowNum row index of record to return.
     * @param colNum column index of record to return.
     *
     * @return Record object for the row.
     * @see com.smartgwt.client.widgets.grid.ListGrid#getRecord
     * @see com.smartgwt.client.widgets.grid.ListGrid#getEditedRecord
     */
    public native ListGridRecord getCellRecord(int rowNum, int colNum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCellRecord", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCellRecord(rowNum, colNum);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Given a record in this grid, this method returns the rowNum on which the record is displayed.
     * @param cellRecord record to find coordinates for
     *
     * @return Row number for the record. Returns -1 if the record is not found.
     */
    public native int getCellRow(CellRecord cellRecord) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCellRow", "CellRecord");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCellRow(cellRecord.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Return a {@link com.smartgwt.client.widgets.cube.FacetValueMap} indicating the facet values for a specific  column in
     * the grid.
     * @param colNum index of the column
     *
     * @return facet values for the specified column. Returns null if the specified       column is not present in the grid.
     */
    public native FacetValueMap getColumnFacetValues(int colNum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getColumnFacetValues", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getColumnFacetValues(colNum);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.cube.FacetValueMap::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return a {@link com.smartgwt.client.widgets.cube.FacetValueMap} of the facet values for the column field at the
     * specified level containing the requested column number.  Note that outer column fields may span several grid columns.
     * @param colNum 0-based index into the grid columns (and inner column header fields)
     * @param level target header level; 0 represents the outer column header
     *
     * @return facet values for the targeted column header field
     */
    public native FacetValueMap getColumnHeaderFacetValues(int colNum, int level) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getColumnHeaderFacetValues", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getColumnHeaderFacetValues(colNum, level);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.cube.FacetValueMap::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns a default set of items, which can be updated/modified, and then assigned to  {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getFacetValueContextItems facetValueContextItems} to be used in the context
     * menu of the appropriate   header button.
     * @param facetValues FacetValueMap for the appropriate header button
     *
     * @return Return standard context menu items                               for these facet values.
     */
    public native MenuItem[] getDefaultFacetValueContextItems(FacetValueMap facetValues) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDefaultFacetValueContextItems", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDefaultFacetValueContextItems(facetValues == null ? null : facetValues.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfMenuItem(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the current temporary locally stored edit value for a cell being edited. Note this is the {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getValueProperty valueProperty} that will be saved for the cell in question.
     * @param rowNum index of the row for which the editValue should be returned
     * @param colNum index of the column for which value should be returned
     *
     * @return edit value for the cell
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native Object getEditValue(int rowNum, int colNum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEditValue", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEditValue(rowNum, colNum);
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;

	/**
     * Returns the column number of the most recent mouse event.
     *
     * @return column number, or -2 if beyond last drawn column
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native int getEventColumn() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventColumn", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventColumn();
        return ret;
    }-*/;

	/**
     * Returns the column number of the most recent mouse event.
     * @param x optional x-coordinate to obtain column number for, in lieu of the x                        coordinate of the last mouse
     * event
     *
     * @return column number, or -2 if beyond last drawn column
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native int getEventColumn(Integer x) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventColumn", "Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventColumn(x == null ? null : x.@java.lang.Integer::intValue()());
        return ret;
    }-*/;
	
	/**
     * Returns the row number of the most recent mouse event.
     *
     * @return row number, or -2 if beyond last drawn row
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native int getEventRow() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventRow", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventRow();
        return ret;
    }-*/;

	/**
     * Returns the row number of the most recent mouse event.
     * @param y optional y-coordinate to obtain row number, in lieu of the y                        coordinate of the last mouse event
     *
     * @return row number, or -2 if beyond last drawn row
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native int getEventRow(Integer y) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getEventRow", "Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEventRow(y == null ? null : y.@java.lang.Integer::intValue()());
        return ret;
    }-*/;
	
	/**
     * Get a facet definition by facetId.  Constant time.
     * @param facetId the id of the facet to retrieve
     *
     * @return the Facet if found, or null
     * @see com.smartgwt.client.widgets.cube.Facet
     */
    public native Facet getFacet(String facetId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getFacet", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFacet(facetId);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.cube.Facet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return the list of facets that have any selection in their headers.  <br><i>methodType</i> getter
     *
     * @return list of facets that have any selection in their headers
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native String[] getFacetsHavingSelection() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getFacetsHavingSelection", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFacetsHavingSelection();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfString(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Get a facet value definition by facetId and facetValueId.  Constant time.
     * @param facetId the id of the facet to retrieve
     * @param facetValueId the id of the facet value to retrieve
     *
     * @return the FacetValue if found, or null
     * @see com.smartgwt.client.widgets.cube.FacetValue
     */
    public native FacetValue getFacetValue(String facetId, String facetValueId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getFacetValue", "String,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFacetValue(facetId, facetValueId);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.cube.FacetValue::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Get the index of the first column in the grid that matches the specified FacetValueMap. <P> The facetValues passed in
     * should contain values for at least one column facet.  It may contain properties other than column facets, which will be
     * ignored.  If values are  sparse (values not specified for every column facet), the first column matching the specified
     * facet values will be returned.
     * @param facetValues facet values to find
     *
     * @return index of first column in the grid that matches the facet values passed in,                   or -1 if not found
     */
    public native int getFacetValuesColumn(FacetValueMap facetValues) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getFacetValuesColumn", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFacetValuesColumn(facetValues == null ? null : facetValues.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Get the index of the first row in the grid that matches the specified FacetValueMap. <P> The facetValues passed in
     * should contain values for at least one row facet. It may contain properties other than row facets, which will be
     * ignored.  If values are  sparse (values not specified for every row facet), the first row matching the specified facet
     * values will be returned.
     * @param facetValues facet values to find
     *
     * @return index of first row in the grid that matches the facet values passed in, or                   -1 if not found
     */
    public native int getFacetValuesRow(FacetValueMap facetValues) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getFacetValuesRow", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFacetValuesRow(facetValues == null ? null : facetValues.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Return a {@link com.smartgwt.client.widgets.cube.FacetValueMap} indicating the facet values for a specific  row in the
     * grid.
     * @param rowNum index of the row
     *
     * @return facet values for the specified row. Returns null if the specified row    is not present in the grid.
     */
    public native FacetValueMap getRowFacetValues(int rowNum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getRowFacetValues", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRowFacetValues(rowNum);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.cube.FacetValueMap::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return a {@link com.smartgwt.client.widgets.cube.FacetValueMap} of the facet values for the row field at the specified
     * level containing the requested row number.  Note that outer row fields may span several grid rows.
     * @param rowNum 0-based index into the grid rows (and inner row header fields)
     * @param level target header level; 0 represents the outer row header
     *
     * @return facet values for the targeted row header field
     */
    public native FacetValueMap getRowHeaderFacetValues(int rowNum, int level) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getRowHeaderFacetValues", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRowHeaderFacetValues(rowNum, level);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.cube.FacetValueMap::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns an array of the IDs of all selected cell records.  <br><i>methodType</i> getter
     *
     * @return array of the selected cell IDs
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native String[] getSelectedCellIds() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedCellIds", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedCellIds();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfString(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns an array of the selected cell records.  <br><i>methodType</i> getter
     *
     * @return array of the selected cell records
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native CellRecord[] getSelectedCells() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedCells", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedCells();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfCellRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns an array of facetValues objects indicating the headers that are selected in the headerBar for this facet.  If
     * facetId is not passed, returns selection for all facets.
     *
     * @return selected facetValues
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native FacetValueMap[] getSelectedFacetValues() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedFacetValues", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedFacetValues();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfFacetValueMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns an array of facetValues objects indicating the headers that are selected in the headerBar for this facet.  If
     * facetId is not passed, returns selection for all facets.
     * @param facetId id for facet for which we are getting selected facetValues
     *
     * @return selected facetValues
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native FacetValueMap[] getSelectedFacetValues(String facetId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedFacetValues", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedFacetValues(facetId);
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfFacetValueMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	
	/**
     * <b>Note</b>: This is a ListGrid feature which is inapplicable on this class.
     *
     * @return current view state for the grid.
     * See {@link com.smartgwt.client.docs.ListGridViewState ListGridViewState}
     * @see com.smartgwt.client.docs.ListGridViewState
     * @see com.smartgwt.client.widgets.grid.ListGrid#setViewState
     */
    public native String getViewState() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getViewState", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getViewState();
        return ret;
    }-*/;

	/**
     * Determines whether any cells in this cubeGrid have been edited but not yet saved to the underlying data set.
     *
     * @return true if any record in the grid has been edited but not yet saved
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native Boolean hasChanges() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hasChanges", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.hasChanges();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Hides the specified field if it is currently visible.  No-ops if it's already hidden.
     * @param facetValueMap field specified as a facetValueMap
     *
     * @return whether specified field was actually hidden
     */
    public native boolean hideFacetValues(FacetValueMap facetValueMap) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideFacetValues", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.hideFacetValues(facetValueMap == null ? null : facetValueMap.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret == null ? false : ret;
    }-*/;

	/**
     * Apply a hilite to all cells corresponding to a facetValue.      <br><i>methodType</i> action
     * @param facetID facet ID
     * @param facetValueID facet value ID
     * @param hiliteID hilite ID
     *
     * @return true if the cells were successfully hilited.
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public native Boolean hiliteFacetValue(String facetID, String facetValueID, String hiliteID) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hiliteFacetValue", "String,String,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.hiliteFacetValue(facetID, facetValueID, hiliteID);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Return whether the specified CubeGrid field is open, taking into account both {@link
     * com.smartgwt.client.widgets.cube.Facet#getCanCollapse collapsing} and {@link
     * com.smartgwt.client.widgets.cube.Facet#getCanMinimize minimizing}. <P> Note that if you don't already have a {@link
     * com.smartgwt.client.widgets.cube.FacetValueMap} to the field in question, you can get one by calling {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getRowHeaderFacetValues getRowHeaderFacetValues()} or {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getColumnHeaderFacetValues getColumnHeaderFacetValues()}, <P> You can also
     * construct a {@link com.smartgwt.client.widgets.cube.FacetValueMap} on your own by using the {@link
     * com.smartgwt.client.widgets.cube.Facet#getId Facet.id}s from {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getRowFacets rowFacets} or {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getColumnFacets columnFacets} together with the {@link
     * com.smartgwt.client.widgets.cube.FacetValue#getId FacetValue.id}s of the {@link
     * com.smartgwt.client.widgets.cube.Facet#getValues Facet.values} for the row or column that you want to query.  Given a
     * {@link com.smartgwt.client.widgets.cube.Facet#getId Facet.id}, you can use {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getFacet getFacet()} to obtain the correponding {@link
     * com.smartgwt.client.widgets.cube.Facet}.
     * @param facetValueMap field specified as a facetValueMap
     *
     * @return whether field is open
     */
    public native Boolean isFieldOpen(FacetValueMap facetValueMap) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isFieldOpen", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isFieldOpen(facetValueMap == null ? null : facetValueMap.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * If this cubeGrid can be edited, this method will return true if the record passed in has been edited, but the edits have
     * not yet been saved to the CubeGrid's data object.
     * @param rowNum row index of record to check for changes
     * @param colNum column index of the record to check for changes
     *
     * @return true if the record has been edited but not yet saved
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native Boolean recordHasChanges(int rowNum, int colNum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "recordHasChanges", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.recordHasChanges(rowNum, colNum);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Remove a facet from the current view, using a fixed value from that facet.  For example, remove the "months" facet from
     * the view, collapsing to just January, or total for all months.
     * @param facetId facetId to remove.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @see com.smartgwt.client.widgets.cube.CubeGrid#addFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     * @see com.smartgwt.client.docs.Identifier Identifier
     */
    public native void removeFacet(String facetId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeFacet", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeFacet(facetId);
    }-*/;

	/**
     * Remove a facet from the current view, using a fixed value from that facet.  For example, remove the "months" facet from
     * the view, collapsing to just January, or total for all months.
     * @param facetId facetId to remove.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param fixedFacetValueId New fixed value for the facet, to be added to                          {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues fixedFacetValues}.  Default is the rollup value for the
     * facet.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @see com.smartgwt.client.widgets.cube.CubeGrid#addFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     */
    public native void removeFacet(String facetId, String fixedFacetValueId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeFacet", "String,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeFacet(facetId, fixedFacetValueId);
    }-*/;
	
	/**
     * Resizes all columns for the provided facetValueId, which must be a facetValueId from the innermost column facet.
     * @param facetValueId facetValueId of columns to be resized.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param newWidth column's new width
     */
    public native void resizeFacetValue(String facetValueId, int newWidth) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "resizeFacetValue", "String,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.resizeFacetValue(facetValueId, newWidth);
    }-*/;

	/**
     * Select all cells.
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectAllCells() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectAllCells", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectAllCells();
    }-*/;

	/**
     * Select/deselect all headers in a headerBar (specified by facetId) or all headerBars (if no facetId). 
     * <br><i>methodType</i> action
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectAllFacetValues() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectAllFacetValues", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectAllFacetValues();
    }-*/;

    /**
     * @see CubeGrid#selectAllFacetValues
     */
    public void selectAllFacetValues(String facetId){
        selectAllFacetValues(facetId, null);
    }

	/**
     * Select/deselect all headers in a headerBar (specified by facetId) or all headerBars (if no facetId). 
     * <br><i>methodType</i> action
     * @param facetId ID of facet - if null, selects all headerbars' headers
     * @param newState new selection state - if null defaults to true
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectAllFacetValues(String facetId, Boolean newState) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectAllFacetValues", "String,Boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectAllFacetValues(facetId, newState == null ? null : newState.@java.lang.Boolean::booleanValue()());
    }-*/;
	
	/**
     * Select/deselect cells that match a {@link com.smartgwt.client.widgets.cube.FacetValueMap}. Also supports an explicit
     * list of CellRecords or cell IDs.
     * @param cellList cells to select
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectCells(CellRecord[] cellList) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectCells", "CellRecord[]");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectCells(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(cellList));
    }-*/;

	/**
     * Select/deselect cells that match a {@link com.smartgwt.client.widgets.cube.FacetValueMap}. Also supports an explicit
     * list of CellRecords or cell IDs.
     * @param cellList cells to select
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectCells(FacetValueMap cellList) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectCells", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectCells(cellList == null ? null : cellList.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Select/deselect cells that match a {@link com.smartgwt.client.widgets.cube.FacetValueMap}. Also supports an explicit
     * list of CellRecords or cell IDs.
     * @param cellList cells to select
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectCells(String... cellList) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectCells", "String...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectCells(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(cellList));
    }-*/;

	/**
     * Select/deselect cells that match a {@link com.smartgwt.client.widgets.cube.FacetValueMap}. Also supports an explicit
     * list of CellRecords or cell IDs.
     * @param cellList cells to select
     * @param newState new selection state (if null, defaults to true)
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectCells(CellRecord[] cellList, boolean newState) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectCells", "CellRecord[],boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectCells(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(cellList), newState);
    }-*/;
	
	/**
     * Select/deselect the header for a given facet value.  <br><i>methodType</i> action
     * @param facetId ID of facet
     * @param facetValueId ID of facetValue to select
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectFacetValue(String facetId, String facetValueId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectFacetValue", "String,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectFacetValue(facetId, facetValueId);
    }-*/;

	/**
     * Select/deselect the header for a given facet value.  <br><i>methodType</i> action
     * @param facetId ID of facet
     * @param facetValueId ID of facetValue to select
     * @param newState new selection state - if null defaults to true
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectFacetValue(String facetId, String facetValueId, Boolean newState) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectFacetValue", "String,String,Boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectFacetValue(facetId, facetValueId, newState == null ? null : newState.@java.lang.Boolean::booleanValue()());
    }-*/;
	
	/**
     * Set the edit value for some cell in the cube grid.<p> Note that cubeGrids display one record per cell - the value passed
     * in should be the  desired edit value for the {@link com.smartgwt.client.widgets.cube.CubeGrid#getValueProperty
     * valueProperty} of the record.
     * @param rowNum Row number
     * @param colNum Column number
     * @param value New value for the record
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native void setEditValue(int rowNum, int colNum, Object value) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setEditValue", "int,int,Object");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;

	/**
     * Set the title of a facet (appears in facet label).
     * @param facetId facet to update.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param newTitle title for the facet
     */
    public native void setFacetTitle(String facetId, String newTitle) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setFacetTitle", "String,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFacetTitle(facetId, newTitle);
    }-*/;

	/**
     * Set the title for a facet value.
     * @param facetId facet to update.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param facetValueId facetValue to update.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param newTitle title for the facet
     */
    public native void setFacetValueTitle(String facetId, String facetValueId, String newTitle) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setFacetValueTitle", "String,String,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFacetValueTitle(facetId, facetValueId, newTitle);
    }-*/;

	/**
     * Set the align for the title for a facet value.
     * @param facetId facet to update.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param facetValueId facetValue to update.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param align new alignment for facet value title
     */
    public native void setFacetValueTitleAlign(String facetId, String facetValueId, Alignment align) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setFacetValueTitleAlign", "String,String,Alignment");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFacetValueTitleAlign(facetId, facetValueId, align.@com.smartgwt.client.types.Alignment::getValue()());
    }-*/;

	/**
     * Modify fixedFacetValues for this cubeGrid.
     * @param facetId facetId.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param fixedFacetValueId New fixed value for the facet, to be added to                          {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues fixedFacetValues}.  Default is the rollup value for the
     * facet.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     */
    public native void setFixedFacetValue(String facetId, String fixedFacetValueId) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setFixedFacetValue", "String,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFixedFacetValue(facetId, fixedFacetValueId);
    }-*/;

	/**
     * Shows the specified field if it was previsouly hidden.  No-ops if it's already showing.
     * @param facetValueMap field specified as a facetValueMap
     *
     * @return whether specified field was actually shown
     */
    public native boolean showFacetValues(FacetValueMap facetValueMap) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showFacetValues", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.showFacetValues(facetValueMap == null ? null : facetValueMap.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret == null ? false : ret;
    }-*/;

    /**
     * Add a sortByFacetId handler.
     * <p>
     * Called when a sort control is clicked on a FacetHeader.  Does nothing by default.
     *
     * @param handler the sortByFacetId handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSortByFacetIdHandler(com.smartgwt.client.widgets.cube.events.SortByFacetIdHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.cube.events.SortByFacetIdEvent.getType()) == 0) setupSortByFacetIdEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.cube.events.SortByFacetIdEvent.getType());
    }

    private native void setupSortByFacetIdEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var sortByFacetId = $entry(function(){
            var param = {"_this": this, "facetId" : arguments[0], "sortDirection" : arguments[1]};
            var event = @com.smartgwt.client.widgets.cube.events.SortByFacetIdEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.cube.CubeGrid::handleTearDownSortByFacetIdEvent()();
            if (hasDefaultHandler) this.Super("sortByFacetId", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("sortByFacetId"));
            obj.addProperties({sortByFacetId:  sortByFacetId              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("sortByFacetId"));
            obj.sortByFacetId =  sortByFacetId             ;
        }
    }-*/;

    private void handleTearDownSortByFacetIdEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.cube.events.SortByFacetIdEvent.getType()) == 0) tearDownSortByFacetIdEvent();
    }

    private native void tearDownSortByFacetIdEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("sortByFacetId")) delete obj.sortByFacetId;
    }-*/;

    /**
     * Add a sortByFacetValues handler.
     * <p>
     * Called when a sort control is clicked on a FacetValueHeader.  Does nothing by default.
     *
     * @param handler the sortByFacetValues handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSortByFacetValuesHandler(com.smartgwt.client.widgets.cube.events.SortByFacetValuesHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.cube.events.SortByFacetValuesEvent.getType()) == 0) setupSortByFacetValuesEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.cube.events.SortByFacetValuesEvent.getType());
    }

    private native void setupSortByFacetValuesEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var sortByFacetValues = $entry(function(){
            var param = {"_this": this, "facetValues" : arguments[0], "sortDirection" : arguments[1]};
            var event = @com.smartgwt.client.widgets.cube.events.SortByFacetValuesEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.cube.CubeGrid::handleTearDownSortByFacetValuesEvent()();
            if (hasDefaultHandler) this.Super("sortByFacetValues", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("sortByFacetValues"));
            obj.addProperties({sortByFacetValues:  sortByFacetValues              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("sortByFacetValues"));
            obj.sortByFacetValues =  sortByFacetValues             ;
        }
    }-*/;

    private void handleTearDownSortByFacetValuesEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.cube.events.SortByFacetValuesEvent.getType()) == 0) tearDownSortByFacetValuesEvent();
    }

    private native void tearDownSortByFacetValuesEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("sortByFacetValues")) delete obj.sortByFacetValues;
    }-*/;

	/**
     * Toggles the open state of the specified field.  No-ops if it's not showing.
     * @param facetValueMap field specified as a facetValueMap
     *
     * @return whether specified field's open state was toggled
     */
    public native Boolean toggleFieldOpenState(FacetValueMap facetValueMap) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "toggleFieldOpenState", "FacetValueMap");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.toggleFieldOpenState(facetValueMap == null ? null : facetValueMap.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
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
     * @param cubeGridProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(CubeGrid cubeGridProperties) /*-{
        if (cubeGridProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(CubeGrid.@java.lang.Object::getClass()(), "setDefaultProperties", cubeGridProperties.@java.lang.Object::getClass()());
        }
        cubeGridProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = cubeGridProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.CubeGrid.addProperties(properties);
    }-*/;

    // ***********************************************************




    /**
     * Apply a hilite to a specific cell.      Note: can be called either as           hiliteCell(cellObject, hiliteID) or     
     *      hiliteCell(row, column, hiliteID)      <br><i>methodType</i> action
     * @param row of cell to hilite
     * @param column of cell to hilite
     * @param hilite id
     *
     * @return true if the cell was successfully hilited.
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public native Boolean hiliteCell(int rowNum, int colNum, String hiliteID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal = self.hiliteCell(rowNum, colNum, hiliteID);
        if(retVal == null) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Deselect a single cell - accepts cell ID.
     * @param cell cell to deselect
     */
    public native void deselectCell(String cell) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectCell(cell);
    }-*/;
    
    /**
     * Deselect a single cell - accepts cellRecord.
     * @param cell cell to deselect
     */
    public native void deselectCell(CellRecord cell) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectCell(cell.@com.smartgwt.client.widgets.cube.CellRecord::getJsObj()());
    }-*/;
    
     /**
      * Select a single cell - accepts cell ID or cell record.      <br><i>methodType</i> action
      * @param cell cell to select
      */
     public native void selectCell(String ID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.selectCell(cell);
     }-*/;
    
     /**
      * Select a single cell - accepts cell ID or cell record.      <br><i>methodType</i> action
      * @param cell cell to select
      */
     public native void selectCell(Record cell) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.selectCell(cell.@com.smartgwt.client.data.Record::getJsObj()());
     }-*/;

     /**
      * Given a record in this grid, this method returns the coordinates of the cell in which the  record is displayed as a 2
      * element array.
      * @param cellRecord record to find coordinates for
      *
      * @return 2 element array containing <code>[rowNum,colNum]</code> for the cell, or                  <code>null</code> if the
      * record is not found.
      */
     public int[] getCellCoordinates(CellRecord cellRecord) {
         com.google.gwt.core.client.JsArrayInteger cellCoodJS = doGetCellCoordinates(cellRecord.getJsObj());
         return new int[]{cellCoodJS.get(0), cellCoodJS.get(1)};
     }
    
     private native com.google.gwt.core.client.JsArrayInteger doGetCellCoordinates(JavaScriptObject cellRecord) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var coords = self.getCellCoordinates(cellRecord);
         if (coords == null) return [-1,-1];
         return coords;
     }-*/;
    
     /**
      * Returns the current value of a cell. If the cell has an outstanding edit value, this will be returned, otherwise the
      * underlying value of the record will be returned.
      * @param rowNum rowNum of the record being edited
      * @param colNum colNum of the cell
      *
      * @return Current edit value, or underlying value for the cell.
      * @see com.smartgwt.client.docs.Editing Editing overview and related methods
      */
     public native Object getEditedCell(int rowNum, int colNum) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var ret = self.getEditedCell(rowNum, colNum);
         return $wnd.SmartGWT.convertToJavaType(ret);
     }-*/;
    
     /**
      * Returns the current value of a cell. If the cell has an outstanding edit value, this will be returned, otherwise the
      * underlying value of the record will be returned.
      * @param record rowNum of the record being edited, or an Object                                      containing values for all the
      * record's primary keys
      * @param colNum colNum of the cell. Only required if the first parameter is                              a rowNum
      *
      * @return Current edit value, or underlying value for the cell.
      * @see com.smartgwt.client.docs.Editing Editing overview and related methods
      */
     public native Object getEditedCell(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var ret = self.getEditedCell(record.@com.smartgwt.client.data.Record::getJsObj()());
         return $wnd.SmartGWT.convertToJavaType(ret);
     }-*/;
    
     /**
      * Returns the combination of unsaved edits (if any) and original values (if any) for a given cell being edited. <P> The
      * returned value is never null, and can be freely modified.
      * @param rowNum of the record being edited
      * @param colNum colNum of the record being edited
      *
      * @return A copy of the record with unsaved edits included
      * @see com.smartgwt.client.docs.Editing Editing overview and related methods
      */
     public native CellRecord getEditedRecord(int rowNum, int colNum) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var record = self.getEditedRecord(rowNum, colNum);
         if (record == null) return null;
         return @com.smartgwt.client.widgets.cube.CellRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
     }-*/;

    /**
     * Returns the combination of unsaved edits (if any) and original values (if any) for a given cell being edited. <P> The
     * returned value is never null, and can be freely modified.
     * @param record being edited
     *
     * @return A copy of the record with unsaved edits included
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native CellRecord getEditedRecord(Record baseRecord) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var record = self.getEditedRecord(baseRecord.@com.smartgwt.client.data.Record::getJsObj()());
        if (record == null) return null;
        return @com.smartgwt.client.widgets.cube.CellRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
    }-*/;

    /**
     * If set to true, context menu items will be included on the cells and headers providing the user with an option to create
     * a chart of the cubeGrid's data set. See {@link com.smartgwt.client.widgets.cube.CubeGrid#getChartData chartData} for
     * more information.
     *
     * @param enableCharting enableCharting Default value is false
     */
    public void setEnableCharting(Boolean enableCharting) {
        if (!SC.hasDrawing()) {
            String errorMessage = "setEnableCharting(): Charting requires " +
            		            "the Drawing module which is not present in this build.";
            SC.logWarn(errorMessage);
            throw new UnsupportedOperationException(errorMessage);

        }
        setAttribute("enableCharting", enableCharting, true);
    }

    /**
     * If set to true, context menu items will be included on the cells and headers providing the user with an option to create
     * a chart of the cubeGrid's data set. See {@link com.smartgwt.client.widgets.cube.CubeGrid#getChartData chartData} for
     * more information.
     *
     *
     * @return Boolean
     */
    public Boolean getEnableCharting()  {
        return getAttributeAsBoolean("enableCharting");
    }


    private void checkAnalyticsLoaded () {
        if (!analyticsLoaded()) {
            String errorMessage = "Attempt to create CubeGrid. This class requires the optional " +
            		                "Analytics module which is not present in this build.";
            SC.logWarn(errorMessage);
            throw new UnsupportedOperationException(errorMessage);
        }
    }
    
    /**
     * Set the customizer for the HTML to be shown in hovers over facet values. 
     *
     * @param hoverCustomizer the hover customizer
     */
    public native void setFacetValueHoverCustomizer(FacetValueHoverCustomizer hoverCustomizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self =  this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.facetValueHoverHTML = $debox($entry(function(facetValues) {
            var facetValueMapJ   = @com.smartgwt.client.widgets.cube.FacetValueMap::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(facetValues);
            var gridJ     = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);
            
            hoverCustomizer.@com.smartgwt.client.widgets.cube.FacetValueHoverCustomizer::setGrid(Lcom/smartgwt/client/widgets/cube/CubeGrid;)(gridJ);
            var ret = hoverCustomizer.@com.smartgwt.client.widgets.cube.FacetValueHoverCustomizer::hoverHTML(Lcom/smartgwt/client/widgets/cube/FacetValueMap;)(facetValueMapJ);
            if(ret == null) return null;
            return ret;
        }));
    }-*/;

    /**
     * Static method indicating whether the optional Analytics module is loaded for the page.
     * The CubeGrid component requires this module.
     * @return true if the Analytics module is present
     */
    public static native boolean analyticsLoaded() /*-{
        return ($wnd.isc.CubeGrid != null);
    }-*/;

    /**
     * Chart the portion of the dataset indicated by <code>fixedFacetValues</code>, for all
     * values of the <code>variableFacets</code>.
     * <P>
     * One, two or more variableFacets may be passed.  Two variable facets for a column chart will
     * result in {@link com.smartgwt.client.widgets.chart.FacetChart#setStacked stacking} or clustering.  Three facets or more may be
     * supported by some {@link com.smartgwt.client.widgets.cube.CubeGrid#setChartType chartTypes} or
     * {@link com.smartgwt.client.widgets.cube.CubeGrid#setChartConstructor charting engines}.
     *
     * @param fixedFacetValues (FacetValueMap) set of facet values to hold constant.  Pass null to
     *                                         chart the entire dataset.
     * @param variableFacets (Array of FacetIds) set of facets to be charted
     * @param chartProperties (FacetChart properties) properties to pass through to the created {@link com.smartgwt.client.widgets.chart.FacetChart}
     * @return (FacetChart) created Chart instance
     */
    public native FacetChart makeChart(FacetValueMap fixedFacetValues, String[] variableFacets, FacetChart chartProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fixedFacedValuesJS = (fixedFacetValues == null) ? null : fixedFacetValues.@com.smartgwt.client.core.DataClass::getJsObj()();
        var variableFacetsJS = (variableFacets == null) ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(variableFacets);
        var chartPropertiesJS = (chartProperties == null) ? null : chartProperties.@com.smartgwt.client.widgets.chart.FacetChart::getConfig()();
        var facetChartJS = self.makeChart(fixedFacedValuesJS, variableFacetsJS, chartPropertiesJS);
        return @com.smartgwt.client.widgets.chart.FacetChart::new(Lcom/google/gwt/core/client/JavaScriptObject;)(facetChartJS);
    }-*/;

	/**
     * <b>Note</b>: This is a ListGrid feature which is inapplicable on this class.
     * @param viewState Object describing the desired view state for the grid.
     * @return {@link com.smartgwt.client.widgets.cube.CubeGrid CubeGrid} instance, for chaining
     * setter calls
     * See {@link com.smartgwt.client.docs.ListGridViewState ListGridViewState}
     * @see com.smartgwt.client.widgets.grid.ListGrid#getViewState
     * @see com.smartgwt.client.docs.ListGridViewState ListGridViewState
     */
    public CubeGrid setViewState(String viewState) {
        return (CubeGrid)super.setViewState(viewState);
    }


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(CubeGridLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.alternateRecordStyles = getAttributeAsString("alternateRecordStyles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.alternateRecordStyles:" + t.getMessage() + "\n";
        }
        try {
            s.autoFetchTextMatchStyle = getAttributeAsString("autoFetchTextMatchStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.autoFetchTextMatchStyle:" + t.getMessage() + "\n";
        }
        try {
            s.autoFitFieldWidths = getAttributeAsString("autoFitFieldWidths");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.autoFitFieldWidths:" + t.getMessage() + "\n";
        }
        try {
            s.autoSelectHeaders = getAttributeAsString("autoSelectHeaders");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.autoSelectHeaders:" + t.getMessage() + "\n";
        }
        try {
            s.autoSelectValues = getAttributeAsString("autoSelectValues");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.autoSelectValues:" + t.getMessage() + "\n";
        }
        try {
            s.autoSizeHeaders = getAttributeAsString("autoSizeHeaders");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.autoSizeHeaders:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.bodyMinHeight = getAttributeAsString("bodyMinHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.bodyMinHeight:" + t.getMessage() + "\n";
        }
        try {
            s.bodyMinWidth = getAttributeAsString("bodyMinWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.bodyMinWidth:" + t.getMessage() + "\n";
        }
        try {
            s.bodyStyleName = getAttributeAsString("bodyStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.bodyStyleName:" + t.getMessage() + "\n";
        }
        try {
            s.canCollapseFacets = getAttributeAsString("canCollapseFacets");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.canCollapseFacets:" + t.getMessage() + "\n";
        }
        try {
            s.canDragSelect = getAttributeAsString("canDragSelect");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.canDragSelect:" + t.getMessage() + "\n";
        }
        try {
            s.canEdit = getAttributeAsString("canEdit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.canEdit:" + t.getMessage() + "\n";
        }
        try {
            s.canMinimizeColumns = getAttributeAsString("canMinimizeColumns");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.canMinimizeColumns:" + t.getMessage() + "\n";
        }
        try {
            s.canMinimizeFacets = getAttributeAsString("canMinimizeFacets");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.canMinimizeFacets:" + t.getMessage() + "\n";
        }
        try {
            s.canMoveFacets = getAttributeAsString("canMoveFacets");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.canMoveFacets:" + t.getMessage() + "\n";
        }
        try {
            s.canReorderColumns = getAttributeAsString("canReorderColumns");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.canReorderColumns:" + t.getMessage() + "\n";
        }
        try {
            s.canResizeColumns = getAttributeAsString("canResizeColumns");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.canResizeColumns:" + t.getMessage() + "\n";
        }
        try {
            s.canSelectHeaders = getAttributeAsString("canSelectHeaders");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.canSelectHeaders:" + t.getMessage() + "\n";
        }
        try {
            s.canSelectValues = getAttributeAsString("canSelectValues");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.canSelectValues:" + t.getMessage() + "\n";
        }
        try {
            s.canSortData = getAttributeAsString("canSortData");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.canSortData:" + t.getMessage() + "\n";
        }
        try {
            s.canSortFacets = getAttributeAsString("canSortFacets");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.canSortFacets:" + t.getMessage() + "\n";
        }
        try {
            s.cellAlign = getAttributeAsString("cellAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.cellAlign:" + t.getMessage() + "\n";
        }
        try {
            s.cellIdProperty = getAttributeAsString("cellIdProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.cellIdProperty:" + t.getMessage() + "\n";
        }
        try {
            s.chartConfirmThreshold = getAttributeAsString("chartConfirmThreshold");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.chartConfirmThreshold:" + t.getMessage() + "\n";
        }
        try {
            s.chartConstructor = getAttributeAsString("chartConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.chartConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.chartType = getAttributeAsString("chartType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.chartType:" + t.getMessage() + "\n";
        }
        try {
            s.colHeaderBaseStyle = getAttributeAsString("colHeaderBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.colHeaderBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.colHeaderLabelBaseStyle = getAttributeAsString("colHeaderLabelBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.colHeaderLabelBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.columnFacets = getAttributeAsStringArray("columnFacets");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.columnFacetsArray:" + t.getMessage() + "\n";
        }
        try {
            s.dataSource = getDataSource();
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.dataSource:" + t.getMessage() + "\n";
        }
        try {
            s.defaultFacetWidth = getAttributeAsString("defaultFacetWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.defaultFacetWidth:" + t.getMessage() + "\n";
        }
        try {
            s.editByCell = getAttributeAsString("editByCell");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.editByCell:" + t.getMessage() + "\n";
        }
        try {
            s.enableCharting = getAttributeAsString("enableCharting");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.enableCharting:" + t.getMessage() + "\n";
        }
        try {
            s.exportColumnFacetBGColor = getAttributeAsString("exportColumnFacetBGColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.exportColumnFacetBGColor:" + t.getMessage() + "\n";
        }
        try {
            s.exportColumnFacetTextColor = getAttributeAsString("exportColumnFacetTextColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.exportColumnFacetTextColor:" + t.getMessage() + "\n";
        }
        try {
            s.exportFacetBGColor = getAttributeAsString("exportFacetBGColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.exportFacetBGColor:" + t.getMessage() + "\n";
        }
        try {
            s.exportFacetSeparatorString = getAttributeAsString("exportFacetSeparatorString");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.exportFacetSeparatorString:" + t.getMessage() + "\n";
        }
        try {
            s.exportFacetTextColor = getAttributeAsString("exportFacetTextColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.exportFacetTextColor:" + t.getMessage() + "\n";
        }
        try {
            s.exportRowFacetBGColor = getAttributeAsString("exportRowFacetBGColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.exportRowFacetBGColor:" + t.getMessage() + "\n";
        }
        try {
            s.exportRowFacetTextColor = getAttributeAsString("exportRowFacetTextColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.exportRowFacetTextColor:" + t.getMessage() + "\n";
        }
        try {
            s.facetLabelHoverAlign = getAttributeAsString("facetLabelHoverAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetLabelHoverAlign:" + t.getMessage() + "\n";
        }
        try {
            s.facetLabelHoverHeightAsString = getAttributeAsString("facetLabelHoverHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetLabelHoverHeightAsString:" + t.getMessage() + "\n";
        }
        try {
            s.facetLabelHoverStyle = getAttributeAsString("facetLabelHoverStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetLabelHoverStyle:" + t.getMessage() + "\n";
        }
        try {
            s.facetLabelHoverVAlign = getAttributeAsString("facetLabelHoverVAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetLabelHoverVAlign:" + t.getMessage() + "\n";
        }
        try {
            s.facetLabelHoverWidthAsString = getAttributeAsString("facetLabelHoverWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetLabelHoverWidthAsString:" + t.getMessage() + "\n";
        }
        try {
            s.facetTitleAlign = getAttributeAsString("facetTitleAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetTitleAlign:" + t.getMessage() + "\n";
        }
        try {
            s.facetValueAlign = getAttributeAsString("facetValueAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetValueAlign:" + t.getMessage() + "\n";
        }
        try {
            s.facetValueContextItems = getFacetValueContextItems();
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetValueContextItemsArray:" + t.getMessage() + "\n";
        }
        try {
            s.facetValueHoverAlign = getAttributeAsString("facetValueHoverAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetValueHoverAlign:" + t.getMessage() + "\n";
        }
        try {
            s.facetValueHoverHeightAsString = getAttributeAsString("facetValueHoverHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetValueHoverHeightAsString:" + t.getMessage() + "\n";
        }
        try {
            s.facetValueHoverStyle = getAttributeAsString("facetValueHoverStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetValueHoverStyle:" + t.getMessage() + "\n";
        }
        try {
            s.facetValueHoverVAlign = getAttributeAsString("facetValueHoverVAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetValueHoverVAlign:" + t.getMessage() + "\n";
        }
        try {
            s.facetValueHoverWidthAsString = getAttributeAsString("facetValueHoverWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.facetValueHoverWidthAsString:" + t.getMessage() + "\n";
        }
        try {
            s.fixedFacetValues = getFixedFacetValues();
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.fixedFacetValues:" + t.getMessage() + "\n";
        }
        try {
            s.hideEmptyAxis = getAttributeAsString("hideEmptyAxis");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.hideEmptyAxis:" + t.getMessage() + "\n";
        }
        try {
            s.hideEmptyFacetValues = getAttributeAsString("hideEmptyFacetValues");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.hideEmptyFacetValues:" + t.getMessage() + "\n";
        }
        try {
            s.hilites = getHilites();
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.hilitesArray:" + t.getMessage() + "\n";
        }
        try {
            s.indentVTreeFacets = getAttributeAsString("indentVTreeFacets");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.indentVTreeFacets:" + t.getMessage() + "\n";
        }
        try {
            s.innerHeaderBaseStyle = getAttributeAsString("innerHeaderBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.innerHeaderBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.metricFacetId = getAttributeAsString("metricFacetId");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.metricFacetId:" + t.getMessage() + "\n";
        }
        try {
            s.padTitles = getAttributeAsString("padTitles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.padTitles:" + t.getMessage() + "\n";
        }
        try {
            s.rollupValue = getAttributeAsString("rollupValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.rollupValue:" + t.getMessage() + "\n";
        }
        try {
            s.rotateHeaderTitles = getAttributeAsString("rotateHeaderTitles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.rotateHeaderTitles:" + t.getMessage() + "\n";
        }
        try {
            s.rowFacets = getAttributeAsStringArray("rowFacets");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.rowFacetsArray:" + t.getMessage() + "\n";
        }
        try {
            s.rowHeaderBaseStyle = getAttributeAsString("rowHeaderBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.rowHeaderBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.rowHeaderGridMode = getAttributeAsString("rowHeaderGridMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.rowHeaderGridMode:" + t.getMessage() + "\n";
        }
        try {
            s.rowHeaderLabelBaseStyle = getAttributeAsString("rowHeaderLabelBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.rowHeaderLabelBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.saveByCell = getAttributeAsString("saveByCell");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.saveByCell:" + t.getMessage() + "\n";
        }
        try {
            s.showFacetContextMenus = getAttributeAsString("showFacetContextMenus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.showFacetContextMenus:" + t.getMessage() + "\n";
        }
        try {
            s.showFacetValueContextMenus = getAttributeAsString("showFacetValueContextMenus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.showFacetValueContextMenus:" + t.getMessage() + "\n";
        }
        try {
            s.simpleDeselect = getAttributeAsString("simpleDeselect");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.simpleDeselect:" + t.getMessage() + "\n";
        }
        try {
            s.skinImgDir = getAttributeAsString("skinImgDir");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.skinImgDir:" + t.getMessage() + "\n";
        }
        try {
            s.sortDirection = getAttributeAsString("sortDirection");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.sortDirection:" + t.getMessage() + "\n";
        }
        try {
            s.sortedFacetValues = getSortedFacetValues();
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.sortedFacetValues:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.styleName:" + t.getMessage() + "\n";
        }
        try {
            s.valueExportFormat = getAttributeAsString("valueExportFormat");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.valueExportFormat:" + t.getMessage() + "\n";
        }
        try {
            s.valueFormat = getAttributeAsString("valueFormat");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.valueFormat:" + t.getMessage() + "\n";
        }
        try {
            s.valueProperty = getAttributeAsString("valueProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.valueProperty:" + t.getMessage() + "\n";
        }
        try {
            s.valueTitle = getAttributeAsString("valueTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.valueTitle:" + t.getMessage() + "\n";
        }
        try {
            s.vTreeFacetIndent = getAttributeAsString("vTreeFacetIndent");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.vTreeFacetIndent:" + t.getMessage() + "\n";
        }
        try {
            s.vTreeFacetIndentDirection = getAttributeAsString("vTreeFacetIndentDirection");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.vTreeFacetIndentDirection:" + t.getMessage() + "\n";
        }
        try {
            s.wrapFacetTitles = getAttributeAsString("wrapFacetTitles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.wrapFacetTitles:" + t.getMessage() + "\n";
        }
        try {
            s.wrapFacetValueTitles = getAttributeAsString("wrapFacetValueTitles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "CubeGrid.wrapFacetValueTitles:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        CubeGridLogicalStructure s = new CubeGridLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
