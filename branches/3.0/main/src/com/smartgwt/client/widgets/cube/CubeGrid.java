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
 
package com.smartgwt.client.widgets.cube;



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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * The CubeGrid is an interactive grid component that presents very large, multi-dimensional data sets (also known as data
 * cubes) for reporting or analytic applications. <P> <var class="SmartGWT"> Note that the CubeGrid is implemented as part
 * of the optional Analytics module. Attempting to create a CubeGrid without having the module loaded will throw a
 * RuntimeException. <P> </var> CubeGrids are often called crosstabs, for their cross-tabular display of data dimensions in
 * stacked/nested rows and columns, or pivot tables, for their ability to "pivot" dimensions between rows and columns to
 * view a data cube from different perspectives. They are typically used in the querying and reporting front-ends of data
 * warehousing, decision support, OLAP, and business intelligence systems. <P> <B>Multi-Dimensional Data Terminology</B>
 * <P> The CubeGrid refers to the dimensions of a data cube as facets, to the possible values in each facet as facet
 * values, and to the values within the data cube as data values or cell values. Equivalent terms that are commonly used in
 * data warehousing or business intelligence systems include:<br> <b>facet:</b> dimension, attribute, feature<br> <b>facet
 * value:</b> dimension member, attribute value, feature value<br> <b>cell value:</b> data value, metric value, measure <P>
 * <B>Visual Structure</B> <P> Like the ListGrid and TreeGrid components, the CubeGrid displays data values in a tabular
 * "body" with adjacent "headers".  While the ListGrid and TreeGrid display rows of records with field values, the CubeGrid
 * displays a body of individual cell values, each associated with a combination of facet values. The facet values for a
 * cell are displayed in the column headers above the cell and row headers to the left of the cell. CubeGrids can display
 * an arbitrary number of facets, by stacking multiple levels of row and/or column headers. <P> Except for the innermost
 * column facet, each facet in a CubeGrid has a facet label adjacent to its row or column headers. The facet labels serve
 * two main purposes: they display the titles of the facets, and they provide drag-and-drop reordering or pivoting of
 * facets within the CubeGrid. The row facet labels also provide interactive selection, resizing, and other operations on
 * the columns of row facet values. <P> The innermost column headers provide special behaviors and controls for
 * manipulating the columns of data in a CubeGrid. End users may select, resize, reorder, minimize, maximize, or auto-fit
 * the columns of data via mouse interactions with these headers. Customizable indicators and controls may be included at
 * the top of each innermost column header. <P> If a CubeGrid is not large enough to display all of its cell values,
 * horizontal and/or vertical scrollbars will appear below and to the right of the body. The body of the CubeGrid may be
 * scrolled on either axis. The headers are "frozen" from scrolling on one axis - row headers only scroll vertically, while
 * column headers only scroll horizontally - so the facet values for the visible cells are always displayed. <P> <B>Data
 * Loading</B> <P> Data can be provided to the Cube via  data as an Array of {@link
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
public class CubeGrid extends ListGrid  implements com.smartgwt.client.widgets.cube.events.HasFacetAddedHandlers, com.smartgwt.client.widgets.cube.events.HasFacetMovedHandlers, com.smartgwt.client.widgets.cube.events.HasFacetRemovedHandlers, com.smartgwt.client.widgets.cube.events.HasFixedFacetValueChangedHandlers, com.smartgwt.client.widgets.cube.events.HasFacetValueSelectionChangedHandlers, com.smartgwt.client.widgets.cube.events.HasSortByFacetIdHandlers, com.smartgwt.client.widgets.cube.events.HasSortByFacetValuesHandlers {

    public static CubeGrid getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (CubeGrid) obj;
        } else {
            return new CubeGrid(jsObj);
        }
    }

    public CubeGrid(){
        checkAnalyticsLoaded();
					setAutoFetchData(false);
                scClassName = "CubeGrid";
    }

    public CubeGrid(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Whether alternating rows should be drawn in alternating styles, in order to create a "ledger" effect for easier reading.
     *  If enabled, the cell style for alternate rows will have "Dark" appended to it.
     *
     * @param alternateRecordStyles alternateRecordStyles Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAlternateRecordStyles(Boolean alternateRecordStyles) {
        setAttribute("alternateRecordStyles", alternateRecordStyles, true);
    }

    /**
     * Whether alternating rows should be drawn in alternating styles, in order to create a "ledger" effect for easier reading.
     *  If enabled, the cell style for alternate rows will have "Dark" appended to it.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getAlternateRecordStyles()  {
        return getAttributeAsBoolean("alternateRecordStyles");
    }

    /**
     * If true, when multiple facets appear on one side in a nested headers presentation, the selection state of parent/child
     * headers are automatically kept in sync.
     *
     * @param autoSelectHeaders autoSelectHeaders Default value is true
     */
    public void setAutoSelectHeaders(Boolean autoSelectHeaders) {
        setAttribute("autoSelectHeaders", autoSelectHeaders, true);
    }

    /**
     * If true, when multiple facets appear on one side in a nested headers presentation, the selection state of parent/child
     * headers are automatically kept in sync.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoSelectHeaders()  {
        return getAttributeAsBoolean("autoSelectHeaders");
    }

    /**
     * Whether to select cells in the body when row or column headers are selected.
     *
     * @param autoSelectValues autoSelectValues Default value is "both"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoSelectValues(AutoSelectionModel autoSelectValues)  throws IllegalStateException {
        setAttribute("autoSelectValues", autoSelectValues.getValue(), false);
    }

    /**
     * Whether to select cells in the body when row or column headers are selected.
     *
     *
     * @return AutoSelectionModel
     */
    public AutoSelectionModel getAutoSelectValues()  {
        return EnumUtil.getEnum(AutoSelectionModel.values(), getAttribute("autoSelectValues"));
    }

    /**
     * Automatically size row headers to fit wrapped text.
     *
     * @param autoSizeHeaders autoSizeHeaders Default value is false
     */
    public void setAutoSizeHeaders(Boolean autoSizeHeaders) {
        setAttribute("autoSizeHeaders", autoSizeHeaders, true);
    }

    /**
     * Automatically size row headers to fit wrapped text.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoSizeHeaders()  {
        return getAttributeAsBoolean("autoSizeHeaders");
    }

    /**
     * {@link com.smartgwt.client.grid.GridRenderer#getBaseStyle base cell style} for this listGrid. If this property is unset,
     * base style may be derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle normalBaseStyle} or
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle tallBaseStyle} as described in {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.getBaseStyle}.
     *
     * @param baseStyle baseStyle Default value is "cubeCell"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBaseStyle(String baseStyle)  throws IllegalStateException {
        setAttribute("baseStyle", baseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.grid.GridRenderer#getBaseStyle base cell style} for this listGrid. If this property is unset,
     * base style may be derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle normalBaseStyle} or
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle tallBaseStyle} as described in {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.getBaseStyle}.
     *
     *
     * @return Return the base stylename for this cell.  Default implementation just returns this.baseStyle. See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle getCellStyle()} for a general discussion of how to style cells.
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    /**
     * Minimum height for the body of this cubeGrid.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param bodyMinHeight bodyMinHeight Default value is null
     */
    public void setBodyMinHeight(Integer bodyMinHeight) {
        setAttribute("bodyMinHeight", bodyMinHeight, true);
    }

    /**
     * Minimum height for the body of this cubeGrid.
     *
     *
     * @return Integer
     */
    public Integer getBodyMinHeight()  {
        return getAttributeAsInt("bodyMinHeight");
    }

    /**
     * Minimum width for the body of this cubeGrid.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param bodyMinWidth bodyMinWidth Default value is null
     */
    public void setBodyMinWidth(Integer bodyMinWidth) {
        setAttribute("bodyMinWidth", bodyMinWidth, true);
    }

    /**
     * Minimum width for the body of this cubeGrid.
     *
     *
     * @return Integer
     */
    public Integer getBodyMinWidth()  {
        return getAttributeAsInt("bodyMinWidth");
    }

    /**
     * CSS class for the CubeGrid body
     *
     * @param bodyStyleName bodyStyleName Default value is "cubeGridBody"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBodyStyleName(String bodyStyleName) {
        setAttribute("bodyStyleName", bodyStyleName, true);
    }

    /**
     * CSS class for the CubeGrid body
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBodyStyleName()  {
        return getAttributeAsString("bodyStyleName");
    }

    /**
     * If true, hierarchical facets will show expand/collapse controls to allow the user to expand and collapse the tree of
     * facetValues for that facet.
     *
     * @param canCollapseFacets canCollapseFacets Default value is false
     */
    public void setCanCollapseFacets(Boolean canCollapseFacets) {
        setAttribute("canCollapseFacets", canCollapseFacets, true);
    }

    /**
     * If true, hierarchical facets will show expand/collapse controls to allow the user to expand and collapse the tree of
     * facetValues for that facet.
     *
     *
     * @return Boolean
     */
    public Boolean getCanCollapseFacets()  {
        return getAttributeAsBoolean("canCollapseFacets");
    }

    /**
     * Whether cells can be edited in this grid.  Can be overridden on a per-facetValue basis.
     *
     * @param canEdit canEdit Default value is false
     */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit, true);
    }

    /**
     * Whether cells can be edited in this grid.  Can be overridden on a per-facetValue basis.
     *
     *
     * @return Boolean
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit");
    }

    /**
     * If true, allow columns in the grid body to be minimized (reduced to the width of the minimize control) by clicking on a
     * minimize control in the innermost column headers.
     *
     * @param canMinimizeColumns canMinimizeColumns Default value is null
     */
    public void setCanMinimizeColumns(Boolean canMinimizeColumns) {
        setAttribute("canMinimizeColumns", canMinimizeColumns, true);
    }

    /**
     * If true, allow columns in the grid body to be minimized (reduced to the width of the minimize control) by clicking on a
     * minimize control in the innermost column headers.
     *
     *
     * @return Boolean
     */
    public Boolean getCanMinimizeColumns()  {
        return getAttributeAsBoolean("canMinimizeColumns");
    }

    /**
     * If true, when multiple facets are shown on a side, all facetValues in the second level of headers or higher will show
     * controls to "minimize" the values of the next facet. Minimizing means showing only one, or very few, of the next facet's
     * values. <P> Set {@link com.smartgwt.client.widgets.cube.FacetValue#getIsMinimizeValue isMinimizeValue} to indicate which
     * facetValues should be shown when a facet is minimized.
     *
     * @param canMinimizeFacets canMinimizeFacets Default value is false
     */
    public void setCanMinimizeFacets(Boolean canMinimizeFacets) {
        setAttribute("canMinimizeFacets", canMinimizeFacets, true);
    }

    /**
     * If true, when multiple facets are shown on a side, all facetValues in the second level of headers or higher will show
     * controls to "minimize" the values of the next facet. Minimizing means showing only one, or very few, of the next facet's
     * values. <P> Set {@link com.smartgwt.client.widgets.cube.FacetValue#getIsMinimizeValue isMinimizeValue} to indicate which
     * facetValues should be shown when a facet is minimized.
     *
     *
     * @return Boolean
     */
    public Boolean getCanMinimizeFacets()  {
        return getAttributeAsBoolean("canMinimizeFacets");
    }

    /**
     * Whether row and column facets can be rearranged by the user, by dragging and dropping the facet labels.
     *
     * @param canMoveFacets canMoveFacets Default value is false
     */
    public void setCanMoveFacets(Boolean canMoveFacets) {
        setAttribute("canMoveFacets", canMoveFacets, true);
    }

    /**
     * Whether row and column facets can be rearranged by the user, by dragging and dropping the facet labels.
     *
     *
     * @return Boolean
     */
    public Boolean getCanMoveFacets()  {
        return getAttributeAsBoolean("canMoveFacets");
    }

    /**
     * If true, body columns can be reordered via the innermost column headers.
     *
     * @param canReorderColumns canReorderColumns Default value is null
     */
    public void setCanReorderColumns(Boolean canReorderColumns) {
        setAttribute("canReorderColumns", canReorderColumns, true);
    }

    /**
     * If true, body columns can be reordered via the innermost column headers.
     *
     *
     * @return Boolean
     */
    public Boolean getCanReorderColumns()  {
        return getAttributeAsBoolean("canReorderColumns");
    }

    /**
     * If true, body columns can be resized via the innermost column headers.
     *
     * @param canResizeColumns canResizeColumns Default value is null
     */
    public void setCanResizeColumns(Boolean canResizeColumns) {
        setAttribute("canResizeColumns", canResizeColumns, true);
    }

    /**
     * If true, body columns can be resized via the innermost column headers.
     *
     *
     * @return Boolean
     */
    public Boolean getCanResizeColumns()  {
        return getAttributeAsBoolean("canResizeColumns");
    }

    /**
     * Determines whether row or column facetValue headers can be selected.
     *
     * @param canSelectHeaders canSelectHeaders Default value is true
     */
    public void setCanSelectHeaders(Boolean canSelectHeaders) {
        setAttribute("canSelectHeaders", canSelectHeaders, true);
    }

    /**
     * Determines whether row or column facetValue headers can be selected.
     *
     *
     * @return Boolean
     */
    public Boolean getCanSelectHeaders()  {
        return getAttributeAsBoolean("canSelectHeaders");
    }

    /**
     * Determines whether cell values in the body can be selected.
     *
     * @param canSelectValues canSelectValues Default value is true
     */
    public void setCanSelectValues(Boolean canSelectValues) {
        setAttribute("canSelectValues", canSelectValues, true);
    }

    /**
     * Determines whether cell values in the body can be selected.
     *
     *
     * @return Boolean
     */
    public Boolean getCanSelectValues()  {
        return getAttributeAsBoolean("canSelectValues");
    }

    /**
     * If true, sort controls will be shown on facet values. <P> When clicked, sort controls call {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#addSortByFacetValuesHandler CubeGrid.sortByFacetValues}.
     *
     * @param canSortData canSortData Default value is null
     */
    public void setCanSortData(Boolean canSortData) {
        setAttribute("canSortData", canSortData, true);
    }

    /**
     * If true, sort controls will be shown on facet values. <P> When clicked, sort controls call {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#addSortByFacetValuesHandler CubeGrid.sortByFacetValues}.
     *
     *
     * @return Boolean
     */
    public Boolean getCanSortData()  {
        return getAttributeAsBoolean("canSortData");
    }

    /**
     * If true, sort controls will be shown on FacetHeaders. <P> When clicked, sort controls call {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#addSortByFacetIdHandler CubeGrid.sortByFacetId}.
     *
     * @param canSortFacets canSortFacets Default value is null
     */
    public void setCanSortFacets(Boolean canSortFacets) {
        setAttribute("canSortFacets", canSortFacets, true);
    }

    /**
     * If true, sort controls will be shown on FacetHeaders. <P> When clicked, sort controls call {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#addSortByFacetIdHandler CubeGrid.sortByFacetId}.
     *
     *
     * @return Boolean
     */
    public Boolean getCanSortFacets()  {
        return getAttributeAsBoolean("canSortFacets");
    }

    /**
     * Default align for cell values (in body).
     *
     * @param cellAlign cellAlign Default value is "center"
     */
    public void setCellAlign(Alignment cellAlign) {
        setAttribute("cellAlign", cellAlign.getValue(), true);
    }

    /**
     * Default align for cell values (in body).
     *
     *
     * @return Alignment
     */
    public Alignment getCellAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("cellAlign"));
    }

    /**
     * Name of the property in a cell record that holds it's unique ID.  Note cell record IDs are optional.
     *
     * @param cellIdProperty cellIdProperty Default value is "ID"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCellIdProperty(String cellIdProperty)  throws IllegalStateException {
        setAttribute("cellIdProperty", cellIdProperty, false);
    }

    /**
     * Name of the property in a cell record that holds it's unique ID.  Note cell record IDs are optional.
     *
     *
     * @return String
     */
    public String getCellIdProperty()  {
        return getAttributeAsString("cellIdProperty");
    }

    /**
     * If {@link com.smartgwt.client.widgets.cube.CubeGrid#makeChart CubeGrid.makeChart} is called with a chart specification
     * that will show more than <code>chartConfirmThreshold</code> data elements, the user will be presented with a {@link
     * com.smartgwt.client.util.isc#confirm confirmation dialog}. <P> Set to 0 to disable this confirmation.
     *
     * @param chartConfirmThreshold chartConfirmThreshold Default value is 2000
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setChartConfirmThreshold(int chartConfirmThreshold)  throws IllegalStateException {
        setAttribute("chartConfirmThreshold", chartConfirmThreshold, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.cube.CubeGrid#makeChart CubeGrid.makeChart} is called with a chart specification
     * that will show more than <code>chartConfirmThreshold</code> data elements, the user will be presented with a {@link
     * com.smartgwt.client.util.isc#confirm confirmation dialog}. <P> Set to 0 to disable this confirmation.
     *
     *
     * @return int
     */
    public int getChartConfirmThreshold()  {
        return getAttributeAsInt("chartConfirmThreshold");
    }

    /**
     * Name of the Smart GWT Class to be used when creating charts.  Must support the Chart interface.
     *
     * @param chartConstructor chartConstructor Default value is "FacetChart"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setChartConstructor(String chartConstructor)  throws IllegalStateException {
        setAttribute("chartConstructor", chartConstructor, false);
    }

    /**
     * Name of the Smart GWT Class to be used when creating charts.  Must support the Chart interface.
     *
     *
     * @return String
     */
    public String getChartConstructor()  {
        return getAttributeAsString("chartConstructor");
    }

    /**
     * Default type of chart to plot.
     *
     * @param chartType chartType Default value is "Column"
     */
    public void setChartType(ChartType chartType) {
        setAttribute("chartType", chartType.getValue(), true);
    }

    /**
     * Default type of chart to plot.
     *
     *
     * @return ChartType
     */
    public ChartType getChartType()  {
        return EnumUtil.getEnum(ChartType.values(), getAttribute("chartType"));
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the buttons in this grid's column headers. <P>
     * Exception: The innermost column header will always be styled using {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getInnerHeaderBaseStyle innerHeaderBaseStyle}.
     *
     * @param colHeaderBaseStyle colHeaderBaseStyle Default value is colHeader
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setColHeaderBaseStyle(String colHeaderBaseStyle)  throws IllegalStateException {
        setAttribute("colHeaderBaseStyle", colHeaderBaseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the buttons in this grid's column headers. <P>
     * Exception: The innermost column header will always be styled using {@link
     * com.smartgwt.client.widgets.cube.CubeGrid#getInnerHeaderBaseStyle innerHeaderBaseStyle}.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getColHeaderBaseStyle()  {
        return getAttributeAsString("colHeaderBaseStyle");
    }

    /**
     * The list of {@link com.smartgwt.client.widgets.cube.Facet#getId ids} for facets that will appear on top of the body.
     *
     * @param columnFacets columnFacets Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setColumnFacets(String... columnFacets)  throws IllegalStateException {
        setAttribute("columnFacets", columnFacets, false);
    }

    /**
     * The list of {@link com.smartgwt.client.widgets.cube.Facet#getId ids} for facets that will appear on top of the body.
     *
     *
     * @return String
     */
    public String[] getColumnFacets()  {
        return getAttributeAsStringArray("columnFacets");
    }

    /**
     * Default width of inner column headers.
     *
     * @param defaultFacetWidth defaultFacetWidth Default value is 100
     */
    public void setDefaultFacetWidth(int defaultFacetWidth) {
        setAttribute("defaultFacetWidth", defaultFacetWidth, true);
    }

    /**
     * Default width of inner column headers.
     *
     *
     * @return int
     */
    public int getDefaultFacetWidth()  {
        return getAttributeAsInt("defaultFacetWidth");
    }


    /**
     * CubeGrids only support editing by cell.
     *
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Boolean
     * @throws IllegalStateException if widget has not yet been rendered.
     */
    public Boolean getEditByCell() throws IllegalStateException {
        errorIfNotCreated("editByCell");
        return getAttributeAsBoolean("editByCell");
    }

    /**
     * Allows the developer to override the horizontal text alignment of hover tips shown for facetLabels.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverAlign</code> if specified.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetLabelHoverAlign facetLabelHoverAlign Default value is null
     * @see com.smartgwt.client.widgets.Canvas#setHoverAlign
     */
    public void setFacetLabelHoverAlign(Alignment facetLabelHoverAlign) {
        setAttribute("facetLabelHoverAlign", facetLabelHoverAlign.getValue(), true);
    }

    /**
     * Allows the developer to override the horizontal text alignment of hover tips shown for facetLabels.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverAlign</code> if specified.
     *
     *
     * @return Alignment
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
     * @param facetLabelHoverHeight facetLabelHoverHeight Default value is null
     * @see com.smartgwt.client.widgets.Canvas#setHoverHeight
     */
    public void setFacetLabelHoverHeight(Integer facetLabelHoverHeight) {
        setAttribute("facetLabelHoverHeight", facetLabelHoverHeight, true);
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default height to apply to hover tips shown for
     * facetLabels. If unset, the hover canvas will be sized to  <code>this.hoverHeight</code> if specified instead.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.Canvas#getHoverHeight
     */
    public Integer getFacetLabelHoverHeight()  {
        return getAttributeAsInt("facetLabelHoverHeight");
    }

    /**
     * Allows the developer to override the css class applied to  hover tips shown for facet labels.  If unspecified, and
     * <code>this.hoverStyle</code> is not null, that  css class will be applied to facet label hovers instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetLabelHoverStyle facetLabelHoverStyle Default value is null
     * @see com.smartgwt.client.widgets.Canvas#setHoverStyle
     */
    public void setFacetLabelHoverStyle(String facetLabelHoverStyle) {
        setAttribute("facetLabelHoverStyle", facetLabelHoverStyle, true);
    }

    /**
     * Allows the developer to override the css class applied to  hover tips shown for facet labels.  If unspecified, and
     * <code>this.hoverStyle</code> is not null, that  css class will be applied to facet label hovers instead.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.Canvas#getHoverStyle
     */
    public String getFacetLabelHoverStyle()  {
        return getAttributeAsString("facetLabelHoverStyle");
    }

    /**
     * Allows the developer to override the vertical text alignment of hover tips shown for facetLabels.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverVAlign</code> if specified.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetLabelHoverVAlign facetLabelHoverVAlign Default value is null
     * @see com.smartgwt.client.widgets.Canvas#setHoverVAlign
     */
    public void setFacetLabelHoverVAlign(VerticalAlignment facetLabelHoverVAlign) {
        setAttribute("facetLabelHoverVAlign", facetLabelHoverVAlign.getValue(), true);
    }

    /**
     * Allows the developer to override the vertical text alignment of hover tips shown for facetLabels.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverVAlign</code> if specified.
     *
     *
     * @return VerticalAlignment
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
     * @param facetLabelHoverWidth facetLabelHoverWidth Default value is null
     * @see com.smartgwt.client.widgets.Canvas#setHoverWidth
     */
    public void setFacetLabelHoverWidth(Integer facetLabelHoverWidth) {
        setAttribute("facetLabelHoverWidth", facetLabelHoverWidth, true);
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default width to apply to hover tips shown for
     * facetLabels. If unset, the hover canvas will be sized to  <code>this.hoverWidth</code> if specified instead.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.Canvas#getHoverWidth
     */
    public Integer getFacetLabelHoverWidth()  {
        return getAttributeAsInt("facetLabelHoverWidth");
    }

    /**
     * Facet definitions for this CubeGrid.  Facets, also called "dimensions", are orthogonal aspects of the data model. <P>
     * For example, you can look at profit by the facets "plant and product" or by "product and plant" and it's the same
     * number, because the facets - plant and product - are the same. What would change the profit numbers would be to remove a
     * facet, called "summarizing", or add a new facet, called "drilling down".  For example, showing profit by plant and
     * product, you could "drill down" by adding the region facet, which would divide profit among each region.  Or you could
     * remove the "plant" facet, showing total profit for each "product", summed across all plants.
     *
     * @param facets facets Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFacet
     * @see com.smartgwt.client.widgets.cube.Facet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFacetValue
     * @see com.smartgwt.client.widgets.cube.FacetValue
     */
    public void setFacets(Facet... facets)  throws IllegalStateException {
        setAttribute("facets", facets, false);
    }

    /**
     * Default alignment for facet labels.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the align of a facet title (appears in facet label).
     *
     * @param facetTitleAlign facet to update. Default value is "center"
     */
    public void setFacetTitleAlign(Alignment facetTitleAlign) {
        setAttribute("facetTitleAlign", facetTitleAlign.getValue(), true);
    }

    /**
     * Default alignment for facet labels.
     *
     *
     * @return Alignment
     */
    public Alignment getFacetTitleAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("facetTitleAlign"));
    }

    /**
     * Default alignment for facet values (in headers).
     *
     * @param facetValueAlign facetValueAlign Default value is "center"
     */
    public void setFacetValueAlign(Alignment facetValueAlign) {
        setAttribute("facetValueAlign", facetValueAlign.getValue(), true);
    }

    /**
     * Default alignment for facet values (in headers).
     *
     *
     * @return Alignment
     */
    public Alignment getFacetValueAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("facetValueAlign"));
    }

    /**
     * Allows the developer to override the horizontal text alignment of hover tips shown for facet values.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverAlign</code> if specified.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetValueHoverAlign facetValueHoverAlign Default value is null
     * @see com.smartgwt.client.widgets.Canvas#setHoverAlign
     */
    public void setFacetValueHoverAlign(Alignment facetValueHoverAlign) {
        setAttribute("facetValueHoverAlign", facetValueHoverAlign.getValue(), true);
    }

    /**
     * Allows the developer to override the horizontal text alignment of hover tips shown for facet values.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverAlign</code> if specified.
     *
     *
     * @return Alignment
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
     * @param facetValueHoverHeight facetValueHoverHeight Default value is null
     * @see com.smartgwt.client.widgets.Canvas#setHoverHeight
     */
    public void setFacetValueHoverHeight(Integer facetValueHoverHeight) {
        setAttribute("facetValueHoverHeight", facetValueHoverHeight, true);
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default height to apply to hover tips shown for
     * facetValues. If unset, the hover canvas will be sized to  <code>this.hoverHeight</code> if specified instead.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.Canvas#getHoverHeight
     */
    public Integer getFacetValueHoverHeight()  {
        return getAttributeAsInt("facetValueHoverHeight");
    }

    /**
     * Allows the developer to override the css class applied to  hover tips shown for facet values.  If unspecified, and
     * <code>this.hoverStyle</code> is not null, that  css class will be applied to facet value hovers instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetValueHoverStyle facetValueHoverStyle Default value is null
     * @see com.smartgwt.client.widgets.Canvas#setHoverStyle
     */
    public void setFacetValueHoverStyle(String facetValueHoverStyle) {
        setAttribute("facetValueHoverStyle", facetValueHoverStyle, true);
    }

    /**
     * Allows the developer to override the css class applied to  hover tips shown for facet values.  If unspecified, and
     * <code>this.hoverStyle</code> is not null, that  css class will be applied to facet value hovers instead.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.Canvas#getHoverStyle
     */
    public String getFacetValueHoverStyle()  {
        return getAttributeAsString("facetValueHoverStyle");
    }

    /**
     * Allows the developer to override the vertical text alignment of hover tips shown for facet values.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverVAlign</code> if specified.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param facetValueHoverVAlign facetValueHoverVAlign Default value is null
     * @see com.smartgwt.client.widgets.Canvas#setHoverVAlign
     */
    public void setFacetValueHoverVAlign(VerticalAlignment facetValueHoverVAlign) {
        setAttribute("facetValueHoverVAlign", facetValueHoverVAlign.getValue(), true);
    }

    /**
     * Allows the developer to override the vertical text alignment of hover tips shown for facet values.  If unspecified the
     * hover canvas content alignment will be set by <code>this.hoverVAlign</code> if specified.
     *
     *
     * @return VerticalAlignment
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
     * @param facetValueHoverWidth facetValueHoverWidth Default value is null
     * @see com.smartgwt.client.widgets.Canvas#setHoverWidth
     */
    public void setFacetValueHoverWidth(Integer facetValueHoverWidth) {
        setAttribute("facetValueHoverWidth", facetValueHoverWidth, true);
    }

    /**
     * If specified and <code>this.showHover</code> is true, this is the default width to apply to hover tips shown for
     * facetValues. If unset, the hover canvas will be sized to  <code>this.hoverWidth</code> if specified instead.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.Canvas#getHoverWidth
     */
    public Integer getFacetValueHoverWidth()  {
        return getAttributeAsInt("facetValueHoverWidth");
    }

    /**
     * A {@link com.smartgwt.client.widgets.cube.FacetValueMap} describing the set of facet values that should be regarded as
     * "fixed" in this cubeGrid.  These are used as fixed criteria for load on demand, and also allow using a dataset with more
     * facets in it than are currently shown in the grid.
     *
     * @param fixedFacetValues fixedFacetValues Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.cube.CubeGrid#addFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#removeFacet
     */
    public void setFixedFacetValues(FacetValueMap fixedFacetValues)  throws IllegalStateException {
        setAttribute("fixedFacetValues", fixedFacetValues.getJsObj(), false);
    }

    /**
     * A {@link com.smartgwt.client.widgets.cube.FacetValueMap} describing the set of facet values that should be regarded as
     * "fixed" in this cubeGrid.  These are used as fixed criteria for load on demand, and also allow using a dataset with more
     * facets in it than are currently shown in the grid.
     *
     *
     * @return FacetValueMap
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
     * @param hideEmptyAxis hideEmptyAxis Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHideEmptyAxis(Axis hideEmptyAxis)  throws IllegalStateException {
        setAttribute("hideEmptyAxis", hideEmptyAxis.getValue(), false);
    }

    /**
     * With {@link com.smartgwt.client.widgets.cube.CubeGrid#getHideEmptyFacetValues hideEmptyFacetValues}, controls on which
     * axis hiding of empty values is applied, "row" (only empty rows are hidden), "column" (only empty columns are hidden) or
     * both (the default).
     *
     *
     * @return Axis
     */
    public Axis getHideEmptyAxis()  {
        return EnumUtil.getEnum(Axis.values(), getAttribute("hideEmptyAxis"));
    }

    /**
     * This causes the headers for any combination of facetValues for which there are no  cellRecords to be suppressed. (Note:
     * Valid only for CubeGrids that specify the complete dataset upfront -   don't use load on demand)
     *
     * @param hideEmptyFacetValues hideEmptyFacetValues Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHideEmptyFacetValues(Boolean hideEmptyFacetValues)  throws IllegalStateException {
        setAttribute("hideEmptyFacetValues", hideEmptyFacetValues, false);
    }

    /**
     * This causes the headers for any combination of facetValues for which there are no  cellRecords to be suppressed. (Note:
     * Valid only for CubeGrids that specify the complete dataset upfront -   don't use load on demand)
     *
     *
     * @return Boolean
     */
    public Boolean getHideEmptyFacetValues()  {
        return getAttributeAsBoolean("hideEmptyFacetValues");
    }

    /**
     * Hilites to be applied to the data for this component.  See {@link com.smartgwt.client.docs.Hiliting}.
     *
     * @param hilites hilites Default value is null
     */
    public void setHilites(Hilite... hilites) {
        setAttribute("hilites", hilites, true);
    }

    /**
     * Hilites to be applied to the data for this component.  See {@link com.smartgwt.client.docs.Hiliting}.
     *
     *
     * @return Hilite
     */
    public Hilite[] getHilites()  {
        return Hilite.convertToHiliteArray(getAttributeAsJavaScriptObject("hilites"));
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the buttons in the innermost column header for 
     * this cubeGrid.
     *
     * @param innerHeaderBaseStyle innerHeaderBaseStyle Default value is innerHeader
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setInnerHeaderBaseStyle(String innerHeaderBaseStyle)  throws IllegalStateException {
        setAttribute("innerHeaderBaseStyle", innerHeaderBaseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the buttons in the innermost column header for 
     * this cubeGrid.
     *
     *
     * @return String
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
     * @param metricFacetId metricFacetId Default value is "metric"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMetricFacetId(String metricFacetId)  throws IllegalStateException {
        setAttribute("metricFacetId", metricFacetId, false);
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
     *
     * @return String
     */
    public String getMetricFacetId()  {
        return getAttributeAsString("metricFacetId");
    }

    /**
     * Whether to pad titles so they aren't flush with header borders.
     *
     * @param padTitles padTitles Default value is true
     */
    public void setPadTitles(Boolean padTitles) {
        setAttribute("padTitles", padTitles, true);
    }

    /**
     * Whether to pad titles so they aren't flush with header borders.
     *
     *
     * @return Boolean
     */
    public Boolean getPadTitles()  {
        return getAttributeAsBoolean("padTitles");
    }

    /**
     * facetValueId of the default rollupValue for each facet.  Can be overridden per facet via facet.rollupValue.
     *
     * @param rollupValue rollupValue Default value is "sum"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRollupValue(String rollupValue)  throws IllegalStateException {
        setAttribute("rollupValue", rollupValue, false);
    }

    /**
     * facetValueId of the default rollupValue for each facet.  Can be overridden per facet via facet.rollupValue.
     *
     *
     * @return Get the facetValue definition for the facetValue to show when this facet is "rolled up" under another facet, during a
     * breakout.<br><br> A facet is not required to have a rollup value, and if it does not have one, then rollups will simply
     * be blank rows.  The facetValueId of the rollup value can be declared as cubeGrid.rollupValue or facet.rollupValue.
     */
    public String getRollupValue()  {
        return getAttributeAsString("rollupValue");
    }

    /**
     * The list of {@link com.smartgwt.client.widgets.cube.Facet#getId ids} for facets that will appear to the left of the
     * body.
     *
     * @param rowFacets rowFacets Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRowFacets(String... rowFacets)  throws IllegalStateException {
        setAttribute("rowFacets", rowFacets, false);
    }

    /**
     * The list of {@link com.smartgwt.client.widgets.cube.Facet#getId ids} for facets that will appear to the left of the
     * body.
     *
     *
     * @return String
     */
    public String[] getRowFacets()  {
        return getAttributeAsStringArray("rowFacets");
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the buttons in this grid's row headers.
     *
     * @param rowHeaderBaseStyle rowHeaderBaseStyle Default value is rowHeader
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setRowHeaderBaseStyle(String rowHeaderBaseStyle)  throws IllegalStateException {
        setAttribute("rowHeaderBaseStyle", rowHeaderBaseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the buttons in this grid's row headers.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getRowHeaderBaseStyle()  {
        return getAttributeAsString("rowHeaderBaseStyle");
    }

    /**
     * If enabled row headers for this cubeGrid will be rendered using a {@link com.smartgwt.client.grid.GridRenderer}
     * component. This improves performance for very large cubeGrids.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param rowHeaderGridMode rowHeaderGridMode Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRowHeaderGridMode(Boolean rowHeaderGridMode)  throws IllegalStateException {
        setAttribute("rowHeaderGridMode", rowHeaderGridMode, false);
    }

    /**
     * If enabled row headers for this cubeGrid will be rendered using a {@link com.smartgwt.client.grid.GridRenderer}
     * component. This improves performance for very large cubeGrids.
     *
     *
     * @return Boolean
     */
    public Boolean getRowHeaderGridMode()  {
        return getAttributeAsBoolean("rowHeaderGridMode");
    }


    /**
     * CubeGrids only support editing by cell.
     *
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Boolean
     * @throws IllegalStateException if widget has not yet been rendered.
     */
    public Boolean getSaveByCell() throws IllegalStateException {
        errorIfNotCreated("saveByCell");
        return getAttributeAsBoolean("saveByCell");
    }

    /**
     * If true, clicking on the existing selection causes it to be entirely deselected.
     *
     * @param simpleDeselect simpleDeselect Default value is false
     */
    public void setSimpleDeselect(Boolean simpleDeselect) {
        setAttribute("simpleDeselect", simpleDeselect, true);
    }

    /**
     * If true, clicking on the existing selection causes it to be entirely deselected.
     *
     *
     * @return Boolean
     */
    public Boolean getSimpleDeselect()  {
        return getAttributeAsBoolean("simpleDeselect");
    }

    /**
     * Default directory for skin images (those defined by the class), relative to the Page-wide {@link
     * com.smartgwt.client.util.Page#getSkinDir skinDir}.
     *
     * @param skinImgDir skinImgDir Default value is "images/CubeGrid/"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setSkinImgDir(String skinImgDir)  throws IllegalStateException {
        setAttribute("skinImgDir", skinImgDir, false);
    }

    /**
     * Default directory for skin images (those defined by the class), relative to the Page-wide {@link
     * com.smartgwt.client.util.Page#getSkinDir skinDir}.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }

    /**
     * Direction of sorting if sortedFacet or sortedFacetValues is specified.
     *
     * @param sortDirection sortDirection Default value is Array.ASCENDING
     */
    public void setSortDirection(SortDirection sortDirection) {
        setAttribute("sortDirection", sortDirection.getValue(), true);
    }

    /**
     * Direction of sorting if sortedFacet or sortedFacetValues is specified.
     *
     *
     * @return SortDirection
     */
    public SortDirection getSortDirection()  {
        return EnumUtil.getEnum(SortDirection.values(), getAttribute("sortDirection"));
    }

    /**
     * {@link com.smartgwt.client.widgets.cube.FacetValueMap} of facet values representing a set of facetValues by which the
     * cubeGrid data is sorted.
     *
     * @param sortedFacetValues sortedFacetValues Default value is null
     */
    public void setSortedFacetValues(FacetValueMap sortedFacetValues) {
        setAttribute("sortedFacetValues", sortedFacetValues.getJsObj(), true);
    }

    /**
     * {@link com.smartgwt.client.widgets.cube.FacetValueMap} of facet values representing a set of facetValues by which the
     * cubeGrid data is sorted.
     *
     *
     * @return FacetValueMap
     */
    public FacetValueMap getSortedFacetValues()  {
        return new FacetValueMap(getAttributeAsJavaScriptObject("sortedFacetValues"));
    }

    /**
     * CSS class for the CubeGrid as a whole
     *
     * @param styleName styleName Default value is "normal"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * CSS class for the CubeGrid as a whole
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
     * Name of the property in a cell record that holds the cell value.
     *
     * @param valueProperty valueProperty Default value is "_value"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValueProperty(String valueProperty)  throws IllegalStateException {
        setAttribute("valueProperty", valueProperty, false);
    }

    /**
     * Name of the property in a cell record that holds the cell value.
     *
     *
     * @return String
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
     * @param valueTitle valueTitle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValueTitle(String valueTitle)  throws IllegalStateException {
        setAttribute("valueTitle", valueTitle, false);
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
     *
     * @return String
     */
    public String getValueTitle()  {
        return getAttributeAsString("valueTitle");
    }

    /**
     * Whether to allow text wrapping on facet titles.
     *
     * @param wrapFacetTitles wrapFacetTitles Default value is false
     */
    public void setWrapFacetTitles(Boolean wrapFacetTitles) {
        setAttribute("wrapFacetTitles", wrapFacetTitles, true);
    }

    /**
     * Whether to allow text wrapping on facet titles.
     *
     *
     * @return Boolean
     */
    public Boolean getWrapFacetTitles()  {
        return getAttributeAsBoolean("wrapFacetTitles");
    }

    /**
     * Whether to allow text wrapping on facet value titles.
     *
     * @param wrapFacetValueTitles wrapFacetValueTitles Default value is false
     */
    public void setWrapFacetValueTitles(Boolean wrapFacetValueTitles) {
        setAttribute("wrapFacetValueTitles", wrapFacetValueTitles, true);
    }

    /**
     * Whether to allow text wrapping on facet value titles.
     *
     *
     * @return Boolean
     */
    public Boolean getWrapFacetValueTitles()  {
        return getAttributeAsBoolean("wrapFacetValueTitles");
    }

    // ********************* Methods ***********************
            
    /**
     * Add a column facet to the view at index "index".  Handles the facet already being in the view (does a pivot).<br><br>
     * The facet being added should currently have a fixed facet value (unless it's already part of the view), which will be
     * removed from cubeGrid.fixedFacetValues. <br><i>methodType</i>  action
     * @param facetId facetId to add.  Definition must have been provided at init time.
     */
    public native void addColumnFacet(String facetId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addColumnFacet(facetId);
    }-*/;

    /**
     * Add a column facet to the view at index "index".  Handles the facet already being in the view (does a pivot).<br><br>
     * The facet being added should currently have a fixed facet value (unless it's already part of the view), which will be
     * removed from cubeGrid.fixedFacetValues. <br><i>methodType</i>  action
     * @param facetId facetId to add.  Definition must have been provided at init time.
     * @param index index to add the facet at.  0 = outermost (default innermost)
     * @see com.smartgwt.client.widgets.cube.CubeGrid#removeFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     */
    public native void addColumnFacet(String facetId, int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addColumnFacet(facetId, index);
    }-*/;
            
    /**
     * Add a facet to the view, into the row or column facets (intoRows true or false), at index "index".  Handles the facet
     * already being in the view (does a pivot). <P> The facet being added should currently have a fixed facet value (unless
     * it's already part of the view), which will be removed from cubeGrid.fixedFacetValues.
     * @param facetId facetId to add.  Definition must have been provided at init time.
     */
    public native void addFacet(String facetId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addFacet(facetId);
    }-*/;

    /**
     * Add a facet to the view, into the row or column facets (intoRows true or false), at index "index".  Handles the facet
     * already being in the view (does a pivot). <P> The facet being added should currently have a fixed facet value (unless
     * it's already part of the view), which will be removed from cubeGrid.fixedFacetValues.
     * @param facetId facetId to add.  Definition must have been provided at init time.
     * @param intoRows whether to add facet as a row facet
     * @param index index to add the facet at.  0 = outermost (default innermost)
     * @see com.smartgwt.client.widgets.cube.CubeGrid#removeFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     */
    public native void addFacet(String facetId, boolean intoRows, int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addFacet(facetId, intoRows, index);
    }-*/;
            
    /**
     * Add a row facet to the view at index "index".  Handles the facet already being in the view (does a pivot).<br><br> The
     * facet being added should currently have a fixed facet value (unless it's already part of the view), which will be
     * removed from cubeGrid.fixedFacetValues. <br><i>methodType</i>  action
     * @param facetId facetId to add.  Definition must have been provided at init time.
     */
    public native void addRowFacet(String facetId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addRowFacet(facetId);
    }-*/;

    /**
     * Add a row facet to the view at index "index".  Handles the facet already being in the view (does a pivot).<br><br> The
     * facet being added should currently have a fixed facet value (unless it's already part of the view), which will be
     * removed from cubeGrid.fixedFacetValues. <br><i>methodType</i>  action
     * @param facetId facetId to add.  Definition must have been provided at init time.
     * @param index index to add the facet at.  0 = outermost (default innermost)
     * @see com.smartgwt.client.widgets.cube.CubeGrid#removeFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     */
    public native void addRowFacet(String facetId, int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addRowFacet(facetId, index);
    }-*/;
            
    /**
     * Determine whether any cells are selected in this cubeGrid.  <br><i>methodType</i> tester
     *
     * @return true if any cells are selected
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native Boolean anyCellSelected() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.anyCellSelected();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Determine whether the cell passed in is selected in this cubeGrid.  <br><i>methodType</i> tester
     * @param cell cell to test
     *
     * @return true if any cells are selected
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native Boolean cellIsSelected(CellRecord cell) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.cellIsSelected(cell.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Handler fired when facet is closed      <br><i>methodType</i> handler
     * @param facetId ID of facet that was closed
     */
    public native void closeFacet(String facetId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.closeFacet(facetId);
    }-*/;
            
    /**
     * Deselect all cells and facetValues.      <br><i>methodType</i> action
     */
    public native void deselectAll() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectAll();
    }-*/;
            
    /**
     * Deselect all cells.      <br><i>methodType</i> action
     */
    public native void deselectAllCells() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectAllCells();
    }-*/;
            
    /**
     * Deselect all headers in a headerBar (specified by facetId) or all headerBars (if no facetId).  <br><i>methodType</i>
     * action
     */
    public native void deselectAllFacetValues() /*-{
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectAllFacetValues(facetId);
    }-*/;
            
    /**
     * Deselect the header for a given facet value.  <br><i>methodType</i> action
     * @param facetId ID of facet
     * @param facetValueId ID of facetValue to select
     */
    public native void deselectFacetValue(String facetId, String facetValueId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectFacetValue(facetId, facetValueId);
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
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({facetAdded:$entry(function(){
                        var param = {"facetId" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.cube.events.FacetAddedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.facetAdded = $entry(function(){
                   var param = {"facetId" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.cube.events.FacetAddedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.facetHasSelection(facetId);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({facetMoved:$entry(function(){
                        var param = {"facetId" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.cube.events.FacetMovedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.facetMoved = $entry(function(){
                   var param = {"facetId" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.cube.events.FacetMovedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
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
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({facetRemoved:$entry(function(){
                        var param = {"facetId" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.cube.events.FacetRemovedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.facetRemoved = $entry(function(){
                   var param = {"facetId" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.cube.events.FacetRemovedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
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
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({facetValueSelectionChanged:$entry(function(){
                        var param = {"facetValues" : arguments[0], "newState" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.cube.events.FacetValueSelectionChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.facetValueSelectionChanged = $entry(function(){
                   var param = {"facetValues" : arguments[0], "newState" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.cube.events.FacetValueSelectionChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
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
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({fixedFacetValueChanged:$entry(function(){
                        var param = {"facetId" : arguments[0], "facetValueId" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.cube.events.FixedFacetValueChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.fixedFacetValueChanged = $entry(function(){
                   var param = {"facetId" : arguments[0], "facetValueId" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.cube.events.FixedFacetValueChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Given a record in this grid, this method returns the colNum in which the record is displayed.
     * @param cellRecord record to find coordinates for
     *
     * @return Column number for the record. Returns -1 if the record is not found.
     */
    public native int getCellColumn(CellRecord cellRecord) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getCellColumn(cellRecord.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Given a cell coordinate within this CubeGrid return a {@link com.smartgwt.client.widgets.cube.FacetValueMap
     * FacetValueMap} indicating the facet values for the cell.
     * @param rowNum row index of the cell
     * @param colNum column index of the cell
     *
     * @return facet values for the specified cell. Returns null if the specified cell    is not present in the grid.
     */
    public native FacetValueMap getCellFacetValues(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCellFacetValues(rowNum, colNum);
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.widgets.cube.FacetValueMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCellRecord(rowNum, colNum);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;
            
    /**
     * Given a record in this grid, this method returns the rowNum on which the record is displayed.
     * @param cellRecord record to find coordinates for
     *
     * @return Row number for the record. Returns -1 if the record is not found.
     */
    public native int getCellRow(CellRecord cellRecord) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getCellRow(cellRecord.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Return a {@link com.smartgwt.client.widgets.cube.FacetValueMap FacetValueMap} indicating the facet values for a specific
     *  column in the grid.
     * @param colNum index of the column
     *
     * @return facet values for the specified column. Returns null if the specified       column is not present in the grid.
     */
    public native FacetValueMap getColumnFacetValues(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getColumnFacetValues(colNum);
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.widgets.cube.FacetValueMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getEventColumn();
    }-*/;

    /**
     * Returns the column number of the most recent mouse event.
     * @param x optional x-coordinate to obtain column number for, in lieu of the x                        coordinate of the last mouse
     * event
     *
     * @return column number, or -2 if beyond last drawn column
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native int getEventColumn(int x) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getEventColumn(x);
    }-*/;
            
    /**
     * Returns the row number of the most recent mouse event.
     *
     * @return row number, or -2 if beyond last drawn row
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native int getEventRow() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getEventRow();
    }-*/;

    /**
     * Returns the row number of the most recent mouse event.
     * @param y optional y-coordinate to obtain row number, in lieu of the y                        coordinate of the last mouse event
     *
     * @return row number, or -2 if beyond last drawn row
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native int getEventRow(int y) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getEventRow(y);
    }-*/;
            
    /**
     * Get a facet definition by facetId.  Constant time.
     * @param facetId the id of the facet to retrieve
     *
     * @return the Facet if found, or null
     * @see com.smartgwt.client.widgets.cube.Facet
     */
    public native Facet getFacet(String facetId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFacet(facetId);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.cube.Facet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFacetValue(facetId, facetValueId);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.cube.FacetValue::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFacetValuesColumn(facetValues.@com.smartgwt.client.core.DataClass::getJsObj()());
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFacetValuesRow(facetValues.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Return a {@link com.smartgwt.client.widgets.cube.FacetValueMap FacetValueMap} indicating the facet values for a specific
     *  row in the grid.
     * @param rowNum index of the row
     *
     * @return facet values for the specified row. Returns null if the specified row    is not present in the grid.
     */
    public native FacetValueMap getRowFacetValues(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getRowFacetValues(rowNum);
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.widgets.cube.FacetValueMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
            
    /**
     * Determines whether any cells in this cubeGrid have been edited but not yet saved to the underlying data set.
     *
     * @return true if any record in the grid has been edited but not yet saved
     * @see com.smartgwt.client.docs.Editing Editing overview and related methods
     */
    public native Boolean hasChanges() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.hasChanges();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.hiliteFacetValue(facetID, facetValueID, hiliteID);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.recordHasChanges(rowNum, colNum);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Remove a facet from the current view, using a fixed value from that facet.  For example, remove the "months" facet from
     * the view, collapsing to just January, or total for all months.
     * @param facetId facetId to remove
     */
    public native void removeFacet(String facetId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeFacet(facetId);
    }-*/;

    /**
     * Remove a facet from the current view, using a fixed value from that facet.  For example, remove the "months" facet from
     * the view, collapsing to just January, or total for all months.
     * @param facetId facetId to remove
     * @param fixedFacetValueId New fixed value for the facet, to be added to cubeGrid.fixedFacetValues.  Default is the     rollup value for the facet.
     * @see com.smartgwt.client.widgets.cube.CubeGrid#addFacet
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     */
    public native void removeFacet(String facetId, String fixedFacetValueId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeFacet(facetId, fixedFacetValueId);
    }-*/;
            
    /**
     * Resizes all columns for the provided facetValueId, which must be a facetValueId from the innermost column facet.
     * @param facetValueId facetValueId of columns to be resized
     * @param newWidth column's new width
     */
    public native void resizeFacetValue(String facetValueId, int newWidth) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.resizeFacetValue(facetValueId, newWidth);
    }-*/;
            
    /**
     * Select all cells.      <br><i>methodType</i> action
     */
    public native void selectAllCells() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectAllCells();
    }-*/;
            
    /**
     * Select/deselect all headers in a headerBar (specified by facetId) or all headerBars (if no facetId). 
     * <br><i>methodType</i> action
     */
    public native void selectAllFacetValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectAllFacetValues();
    }-*/;

    /**
     * Select/deselect all headers in a headerBar (specified by facetId) or all headerBars (if no facetId). 
     * <br><i>methodType</i> action
     * @param facetId ID of facet - if null, selects all headerbars' headers
     * @param newState new selection state - if null defaults to true
     * @see com.smartgwt.client.docs.Selection Selection overview and related methods
     */
    public native void selectAllFacetValues(String facetId, boolean newState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectAllFacetValues(facetId, newState);
    }-*/;
            
    /**
     * Select/deselect the header for a given facet value.  <br><i>methodType</i> action
     * @param facetId ID of facet
     * @param facetValueId ID of facetValue to select
     */
    public native void selectFacetValue(String facetId, String facetValueId) /*-{
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
    public native void selectFacetValue(String facetId, String facetValueId, boolean newState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectFacetValue(facetId, facetValueId, newState);
    }-*/;
            
    /**
     * Set the edit value for some cell in the cube grid.<p> Note that cubeGrids display one record per cell - the value passed
     * in should be the  desired edit value for the {@link com.smartgwt.client.widgets.cube.CubeGrid#getValueProperty
     * valueProperty} of the record.
     * @param rowNum Row number
     * @param colNum Column number
     * @param value New value for the record
     */
    public native void setEditValue(int rowNum, int colNum, Object value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;
            
    /**
     * Set the title of a facet (appears in facet label).
     * @param facetId facet to update
     * @param newTitle title for the facet
     */
    public native void setFacetTitle(String facetId, String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFacetTitle(facetId, newTitle);
    }-*/;
            
    /**
     * Set the title for a facet value.
     * @param facetId facet to update
     * @param facetValueId facetValue to update
     * @param newTitle title for the facet
     */
    public native void setFacetValueTitle(String facetId, String facetValueId, String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFacetValueTitle(facetId, facetValueId, newTitle);
    }-*/;
            
    /**
     * Set the align for the title for a facet value.
     * @param facetId facet to update
     * @param facetValueId facetValue to update
     * @param align new alignment for facet value title
     */
    public native void setFacetValueTitleAlign(String facetId, String facetValueId, Alignment align) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFacetValueTitleAlign(facetId, facetValueId, align.@com.smartgwt.client.types.Alignment::getValue()());
    }-*/;
            
    /**
     * Modify fixedFacetValues for this cubeGrid.
     * @param facetId facetId
     * @param fixedFacetValueId fixedFacetValue     New fixed value for the facet, to be added to cubeGrid.fixedFacetValues.  Default is the     rollup
     * value for the facet.
     */
    public native void setFixedFacetValue(String facetId, String fixedFacetValueId) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFixedFacetValue(facetId, fixedFacetValueId);
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
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({sortByFacetId:$entry(function(){
                        var param = {"facetId" : arguments[0], "sortDirection" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.cube.events.SortByFacetIdEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.sortByFacetId = $entry(function(){
                   var param = {"facetId" : arguments[0], "sortDirection" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.cube.events.SortByFacetIdEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
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
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({sortByFacetValues:$entry(function(){
                        var param = {"facetValues" : arguments[0], "sortDirection" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.cube.events.SortByFacetValuesEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.sortByFacetValues = $entry(function(){
                   var param = {"facetValues" : arguments[0], "sortDirection" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.cube.events.SortByFacetValuesEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
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
     * @param cubeGridProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(CubeGrid cubeGridProperties) /*-{
    	var properties = $wnd.isc.addProperties({},cubeGridProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.CubeGrid.addProperties(properties);
    }-*/;
        
    // ***********************************************************        


	/**
     * An array of "cellRecords", each of which represents data for one cell of the body area.
     *
     * @param data data Default value is null
     * @see com.smartgwt.client.widgets.cube.CubeGrid#setFixedFacetValues
     */
    public void setData(CellRecord[] data) {
        setAttribute("data", data, true);
    }


    /**
     * An array of "cellRecords", each of which represents data for one cell of the body area.
     *
     *
     * @return CellRecord
     * @see com.smartgwt.client.widgets.cube.CubeGrid#getFixedFacetValues
     */
    public CellRecord[] getData()  {

        return convertToCellRecordArray(getAttributeAsJavaScriptObject("data"));
    }
    
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
      * Deselect cells that match a list of facetValues.  Also supports an explicit list of cells or cellIds.     
      * <br><i>methodType</i> action
      * @param cellList cells to deselect
      */
     public native void deselectCells(String... cellList) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.deselectCells(cellList);
     }-*/;
     
     /**
      * Deselect cells that match a list of facetValues.  Also supports an explicit list of cells or cellIds.     
      * <br><i>methodType</i> action
      * @param cellList cells to deselect
      */
     public native void deselectCells(FacetValueMap cellList) /*-{
     	if (cellList == null) return;
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.deselectCells(cellList.@com.smartgwt.client.widgets.cube.FacetValueMap::getJsObj()());
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
      * Select cells that match a list of facetValues.    Also supports an explicit list of cells or cellIds.     
      * <br><i>methodType</i> action
      * @param cellList cells to select
      */
     public native void selectCells(String... cellList) /*-{
	      var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
	      self.selectCells(cellList);
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
         var retVal =self.hiliteCell(cellObj, hiliteID);
         if(retVal == null || retVal === undefined) {
             return null;
         } else {
             return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
         }
     }-*/;

     /**
      * Return the list of facets that have any selection in their headers.  <br><i>methodType</i> getter
      *
      * @return list of facets that have any selection in their headers
      * @see com.smartgwt.client.docs.Selection Selection overview and related methods
      */
     public native String[] getFacetsHavingSelection() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var facets = self.getFacetsHavingSelection();
         if (facets == null) return null;
         return @com.smartgwt.client.util.JSOHelper::convertToArray(Lcom/google/gwt/core/client/JavaScriptObject;)(facets);
     }-*/;
     
     /**
      * Returns an array of the IDs of all selected cell records.  <br><i>methodType</i> getter
      *
      * @return array of the selected cell IDs
      * @see com.smartgwt.client.docs.Selection Selection overview and related methods
      */
     public native String[] getSelectedCellIds() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var cells = self.getSelectedCellIds();
         if (cells == null) return null;
         return @com.smartgwt.client.util.JSOHelper::convertToArray(Lcom/google/gwt/core/client/JavaScriptObject;)(cells);
     }-*/;
             
     
     
     /**
      * Returns an array of the selected cell records.  <br><i>methodType</i> getter
      *
      * @return array of the selected cell records
      * @see com.smartgwt.client.docs.Selection Selection overview and related methods
      */
     public native CellRecord[] getSelectedCells() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var cells = self.getSelectedCells();
         if (cells == null) return cells;
         return @com.smartgwt.client.widgets.cube.CubeGrid::convertToCellRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(cells);
     }-*/;
     
     /**
      * Returns an array of facetValues objects indicating the headers that are selected in the  headerBar for this facet.  If
      * facetId is not passed, returns selection for all  facets.  <br><i>methodType</i> getter
      * @param facetId Id for facet for which we are getting selected facetValues.
      *
      * @return selected facetValues
      * @see com.smartgwt.client.docs.Selection Selection overview and related methods
      */
     public native FacetValueMap[] getSelectedFacetValues(String facetId) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var fvs = self.getSelectedFacetValues(facetId);
         if (fvs == null) return null;
         return @com.smartgwt.client.widgets.cube.CubeGrid::convertToFacetValueMapArray(Lcom/google/gwt/core/client/JavaScriptObject;)(fvs);
     }-*/;

     
     private static CellRecord[] convertToCellRecordArray(JavaScriptObject nativeArray) {
    	if (nativeArray == null) {
            return new CellRecord[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        CellRecord[] objects = new CellRecord[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            CellRecord obj = (CellRecord) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new CellRecord(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

    private static FacetValueMap[] convertToFacetValueMapArray(JavaScriptObject nativeArray) {
    	if (nativeArray == null) {
            return new FacetValueMap[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        FacetValueMap[] objects = new FacetValueMap[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            FacetValueMap obj = new FacetValueMap(componentJS);
            objects[i] = obj;
        }
        return objects;
    }
    
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
     * Static method indicating whether the optional Analytics module is loaded for the page.
     * The CubeGrid component requires this module.
     * @return true if the Analytics module is present
     */
    public static native boolean analyticsLoaded() /*-{
        return ($wnd.isc.CubeGrid != null);
    }-*/;

}



