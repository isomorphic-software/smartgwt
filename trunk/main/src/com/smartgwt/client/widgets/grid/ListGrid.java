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
    * A ListGrid is a {@link com.smartgwt.client.widgets.DataBoundComponent} that displays a list of objects in a grid, where&#010 each row represents one object and each cell in the row represents one property.

    */


























public class ListGrid extends Canvas  implements DataBoundComponent, com.smartgwt.client.widgets.grid.events.HasHeaderClickHandlers, com.smartgwt.client.widgets.grid.events.HasRecordDropHandlers, com.smartgwt.client.widgets.grid.events.HasDataArrivedHandlers, com.smartgwt.client.widgets.grid.events.HasFieldStateChangedHandlers, com.smartgwt.client.widgets.grid.events.HasEditCompleteHandlers, com.smartgwt.client.widgets.grid.events.HasEditFailedHandlers, com.smartgwt.client.widgets.grid.events.HasEditorExitHandlers, com.smartgwt.client.widgets.grid.events.HasRowEditorEnterHandlers, com.smartgwt.client.widgets.grid.events.HasRowEditorExitHandlers, com.smartgwt.client.widgets.grid.events.HasEditorEnterHandlers, com.smartgwt.client.widgets.grid.events.HasCellSavedHandlers, com.smartgwt.client.widgets.grid.events.HasCellOutHandlers, com.smartgwt.client.widgets.grid.events.HasCellOverHandlers, com.smartgwt.client.widgets.grid.events.HasCellContextClickHandlers, com.smartgwt.client.widgets.grid.events.HasCellMouseDownHandlers, com.smartgwt.client.widgets.grid.events.HasCellMouseUpHandlers, com.smartgwt.client.widgets.grid.events.HasCellClickHandlers, com.smartgwt.client.widgets.grid.events.HasCellDoubleClickHandlers, com.smartgwt.client.widgets.grid.events.HasRowOutHandlers, com.smartgwt.client.widgets.grid.events.HasRowOverHandlers, com.smartgwt.client.widgets.grid.events.HasRowContextClickHandlers, com.smartgwt.client.widgets.grid.events.HasRowMouseDownHandlers, com.smartgwt.client.widgets.grid.events.HasRowMouseUpHandlers, com.smartgwt.client.widgets.grid.events.HasRecordClickHandlers, com.smartgwt.client.widgets.grid.events.HasRecordDoubleClickHandlers, com.smartgwt.client.widgets.grid.events.HasCellHoverHandlers, com.smartgwt.client.widgets.grid.events.HasRowHoverHandlers, com.smartgwt.client.widgets.grid.events.HasSelectionChangedHandlers {

    public static ListGrid getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ListGrid) obj;
        } else {
            return new ListGrid(jsObj);
        }
    }


    public ListGrid(){
        setModalEditing(true);setLeaveScrollbarGap(false);
    }

    public ListGrid(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.ListGrid.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * If true, when this component is first drawn, automatically call <code>this.fetchData()</code>&#010 or <code>this.filterData()</code> depending on {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchAsFilter autoFetchAsFilter}.&#010 Criteria for this fetch may be picked up from {@link com.smartgwt.client.widgets.grid.ListGrid#getInitialCriteria initialCriteria}.
    *
    * @param autoFetchData autoFetchData Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAutoFetchData(Boolean autoFetchData)  throws IllegalStateException {
        setAttribute("autoFetchData", autoFetchData, false);
    }
    /**
     * If true, when this component is first drawn, automatically call <code>this.fetchData()</code>&#010 or <code>this.filterData()</code> depending on {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchAsFilter autoFetchAsFilter}.&#010 Criteria for this fetch may be picked up from {@link com.smartgwt.client.widgets.grid.ListGrid#getInitialCriteria initialCriteria}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoFetchData()  {
        return getAttributeAsBoolean("autoFetchData");
    }

    /**
    * Whether to speed up dynamic styling at the expense of slightly slower drawing.&#010 <P>&#010 <code>fastCellUpdates</code> speeds up the dynamic styling system used by rollovers,&#010 selections, and custom styling that calls {@link com.smartgwt.client.grid.GridRenderer#refreshCellStyle}, at&#010 the cost of slightly slower draw() and redraw() times.
    *
    * @param fastCellUpdates fastCellUpdates Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setFastCellUpdates(Boolean fastCellUpdates)  throws IllegalStateException {
        setAttribute("fastCellUpdates", fastCellUpdates, false);
    }

    /**
    * Default CSS class
    *
    * @param styleName styleName Default value is "listGrid"
    */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }
    /**
     * Default CSS class
     *
     *
     * @return String
     *
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
    * If true, automatically fetches a valueMap if an {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} is&#010 set for a ListGrid field.&#010 <P>&#010 If set to false, valueMaps will not be automatically fetched.  In this case, setting&#010 field.optionDataSource on a is effectively a shortcut for setting optionDataSource on&#010 the editor via {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorProperties editorProperties}.&#010 <P>&#010 Can also be disabled on a per-field basis with {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap}.
    *
    * @param autoFetchDisplayMap autoFetchDisplayMap Default value is true
    */
    public void setAutoFetchDisplayMap(Boolean autoFetchDisplayMap) {
        setAttribute("autoFetchDisplayMap", autoFetchDisplayMap, true);
    }
    /**
     * If true, automatically fetches a valueMap if an {@link com.smartgwt.client.widgets.grid.ListGridField#getOptionDataSource optionDataSource} is&#010 set for a ListGrid field.&#010 <P>&#010 If set to false, valueMaps will not be automatically fetched.  In this case, setting&#010 field.optionDataSource on a is effectively a shortcut for setting optionDataSource on&#010 the editor via {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorProperties editorProperties}.&#010 <P>&#010 Can also be disabled on a per-field basis with {@link com.smartgwt.client.widgets.grid.ListGridField#getAutoFetchDisplayMap autoFetchDisplayMap}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoFetchDisplayMap()  {
        return getAttributeAsBoolean("autoFetchDisplayMap");
    }

    /**
    * For grids with a specified {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}, this property can be set to &#010 <code>true</code> to avoid the grid from attempting to save / retrieve data from the&#010 server.  In this case the grid's data should be specified as an array via &#010 the {@link com.smartgwt.client.widgets.grid.ListGrid#getData data} attribute, and the datasource will simply act as a schema to&#010 describe the set of fields visible in the grid. &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit}, or removals via the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} mechanism will update the local data array rather than&#010 attempting to perform operations against the dataSource.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param saveLocally saveLocally Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setSaveLocally(Boolean saveLocally)  throws IllegalStateException {
        setAttribute("saveLocally", saveLocally, false);
    }
    /**
     * For grids with a specified {@link com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}, this property can be set to &#010 <code>true</code> to avoid the grid from attempting to save / retrieve data from the&#010 server.  In this case the grid's data should be specified as an array via &#010 the {@link com.smartgwt.client.widgets.grid.ListGrid#getData data} attribute, and the datasource will simply act as a schema to&#010 describe the set of fields visible in the grid. &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit}, or removals via the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} mechanism will update the local data array rather than&#010 attempting to perform operations against the dataSource.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSaveLocally()  {
        return getAttributeAsBoolean("saveLocally");
    }

    /**
    * The CSS style that group rows will have
    *
    * @param groupNodeStyle groupNodeStyle Default value is "groupNode"
    */
    public void setGroupNodeStyle(String groupNodeStyle) {
        setAttribute("groupNodeStyle", groupNodeStyle, true);
    }
    /**
     * The CSS style that group rows will have
     *
     *
     * @return String
     *
     */
    public String getGroupNodeStyle()  {
        return getAttributeAsString("groupNodeStyle");
    }

    /**
    * The URL of the base icon for the group icons in this treegrid.
    *
    * @param groupIcon groupIcon Default value is "[SKINIMG]/TreeGrid/opener.gif"
    */
    public void setGroupIcon(String groupIcon) {
        setAttribute("groupIcon", groupIcon, true);
    }
    /**
     * The URL of the base icon for the group icons in this treegrid.
     *
     *
     * @return String
     *
     */
    public String getGroupIcon()  {
        return getAttributeAsString("groupIcon");
    }

    /**
    * Default width and height of group icons for this ListGrid.
    *
    * @param groupIconSize groupIconSize Default value is 16
    */
    public void setGroupIconSize(int groupIconSize) {
        setAttribute("groupIconSize", groupIconSize, true);
    }
    /**
     * Default width and height of group icons for this ListGrid.
     *
     *
     * @return int
     *
     */
    public int getGroupIconSize()  {
        return getAttributeAsInt("groupIconSize");
    }

    /**
    * Default number of pixels by which to indent subgroups relative to parent group.
    *
    * @param groupIndentSize groupIndentSize Default value is 20
    */
    public void setGroupIndentSize(int groupIndentSize) {
        setAttribute("groupIndentSize", groupIndentSize, true);
    }
    /**
     * Default number of pixels by which to indent subgroups relative to parent group.
     *
     *
     * @return int
     *
     */
    public int getGroupIndentSize()  {
        return getAttributeAsInt("groupIndentSize");
    }

    /**
    * Default number of pixels by which to indent all groups.
    *
    * @param groupLeadingIndent groupLeadingIndent Default value is 20
    */
    public void setGroupLeadingIndent(int groupLeadingIndent) {
        setAttribute("groupLeadingIndent", groupLeadingIndent, true);
    }
    /**
     * Default number of pixels by which to indent all groups.
     *
     *
     * @return int
     *
     */
    public int getGroupLeadingIndent()  {
        return getAttributeAsInt("groupLeadingIndent");
    }

    /**
    * If false, grouping via context menu will be disabled.
    *
    * @param canGroupBy canGroupBy Default value is true
    */
    public void setCanGroupBy(Boolean canGroupBy) {
        setAttribute("canGroupBy", canGroupBy, true);
    }
    /**
     * If false, grouping via context menu will be disabled.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanGroupBy()  {
        return getAttributeAsBoolean("canGroupBy");
    }

    /**
    * Maximum number of records to which a groupBy can be applied. If there are more records,&#010 grouping will not be available via the default header context menu, and calls to &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy} will be ignored.
    *
    * @param groupByMaxRecords groupByMaxRecords Default value is 1000
    */
    public void setGroupByMaxRecords(int groupByMaxRecords) {
        setAttribute("groupByMaxRecords", groupByMaxRecords, true);
    }
    /**
     * Maximum number of records to which a groupBy can be applied. If there are more records,&#010 grouping will not be available via the default header context menu, and calls to &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy} will be ignored.
     *
     *
     * @return int
     *
     */
    public int getGroupByMaxRecords()  {
        return getAttributeAsInt("groupByMaxRecords");
    }

    /**
     * True if this listgrid is grouped, false otherwise
     *
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Boolean
     *
     * @throws IllegalStateException if widget has not yet been rendered.
     */
    public Boolean getIsGrouped() throws IllegalStateException {
        errorIfNotCreated("isGrouped");
        return getAttributeAsBoolean("isGrouped");
    }

    /**
    * Default alias to use for groups with no value
    *
    * @param nullGroupTitle nullGroupTitle Default value is '-none-'
    */
    public void setNullGroupTitle(String nullGroupTitle) {
        setAttribute("nullGroupTitle", nullGroupTitle, true);
    }
    /**
     * Default alias to use for groups with no value
     *
     *
     * @return String
     *
     */
    public String getNullGroupTitle()  {
        return getAttributeAsString("nullGroupTitle");
    }

    /**
    * Default width and height of value icons for this ListGrid.&#010 Can be overridden at the listGrid level via explicit {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth valueIconWidth} and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight valueIconHeight}, or at the field level via {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize},&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth} and {ListGridField.valueIconHeight}
    *
    * @param valueIconSize valueIconSize Default value is 16
    */
    public void setValueIconSize(int valueIconSize) {
        setAttribute("valueIconSize", valueIconSize, true);
    }
    /**
     * Default width and height of value icons for this ListGrid.&#010 Can be overridden at the listGrid level via explicit {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconWidth valueIconWidth} and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconHeight valueIconHeight}, or at the field level via {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconSize valueIconSize},&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getValueIconWidth valueIconWidth} and {ListGridField.valueIconHeight}
     *
     *
     * @return int
     *
     */
    public int getValueIconSize()  {
        return getAttributeAsInt("valueIconSize");
    }

    /**
    * Width for value icons for this listGrid.&#010 Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}.&#010 Can be overridden at the field level
    *
    * @param valueIconWidth valueIconWidth Default value is null
    */
    public void setValueIconWidth(Integer valueIconWidth) {
        setAttribute("valueIconWidth", valueIconWidth, true);
    }
    /**
     * Width for value icons for this listGrid.&#010 Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}.&#010 Can be overridden at the field level
     *
     *
     * @return Integer
     *
     */
    public Integer getValueIconWidth()  {
        return getAttributeAsInt("valueIconWidth");
    }

    /**
    * Height for value icons for this listGrid.&#010 Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}.&#010 Can be overridden at the field level
    *
    * @param valueIconHeight valueIconHeight Default value is null
    */
    public void setValueIconHeight(Integer valueIconHeight) {
        setAttribute("valueIconHeight", valueIconHeight, true);
    }
    /**
     * Height for value icons for this listGrid.&#010 Overrides {@link com.smartgwt.client.widgets.grid.ListGrid#getValueIconSize valueIconSize}.&#010 Can be overridden at the field level
     *
     *
     * @return Integer
     *
     */
    public Integer getValueIconHeight()  {
        return getAttributeAsInt("valueIconHeight");
    }

    /**
    * How much padding should there be on the left of valueIcons by default&#010 Can be overridden at the field level
    *
    * @param valueIconLeftPadding valueIconLeftPadding Default value is 2
    */
    public void setValueIconLeftPadding(int valueIconLeftPadding) {
        setAttribute("valueIconLeftPadding", valueIconLeftPadding, true);
    }
    /**
     * How much padding should there be on the left of valueIcons by default&#010 Can be overridden at the field level
     *
     *
     * @return int
     *
     */
    public int getValueIconLeftPadding()  {
        return getAttributeAsInt("valueIconLeftPadding");
    }

    /**
    * How much padding should there be on the right of valueIcons by default
    *
    * @param valueIconRightPadding valueIconRightPadding Default value is 2
    */
    public void setValueIconRightPadding(int valueIconRightPadding) {
        setAttribute("valueIconRightPadding", valueIconRightPadding, true);
    }
    /**
     * How much padding should there be on the right of valueIcons by default
     *
     *
     * @return int
     *
     */
    public int getValueIconRightPadding()  {
        return getAttributeAsInt("valueIconRightPadding");
    }

    /**
    * Default size of thumbnails shown for fieldTypes image and imageFile.  Overrideable on a&#010 per-field basis via {@link com.smartgwt.client.widgets.grid.ListGridField#getImageSize imageSize} or&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getImageWidth imageWidth}/{@link com.smartgwt.client.widgets.grid.ListGridField#getImageHeight imageHeight}
    *
    * @param imageSize imageSize Default value is 16
    */
    public void setImageSize(int imageSize) {
        setAttribute("imageSize", imageSize, true);
    }
    /**
     * Default size of thumbnails shown for fieldTypes image and imageFile.  Overrideable on a&#010 per-field basis via {@link com.smartgwt.client.widgets.grid.ListGridField#getImageSize imageSize} or&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getImageWidth imageWidth}/{@link com.smartgwt.client.widgets.grid.ListGridField#getImageHeight imageHeight}
     *
     *
     * @return int
     *
     */
    public int getImageSize()  {
        return getAttributeAsInt("imageSize");
    }

    /**
    * Default height for a {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} with no height specified.&#010 <P>&#010 If <code>headerSpanHeight</code> is not specified (the default), headerSpans will be 1/2&#010 of {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderHeight headerHeight}.
    *
    * @param headerSpanHeight headerSpanHeight Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderSpanHeight(Integer headerSpanHeight)  throws IllegalStateException {
        setAttribute("headerSpanHeight", headerSpanHeight, false);
    }
    /**
     * Default height for a {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} with no height specified.&#010 <P>&#010 If <code>headerSpanHeight</code> is not specified (the default), headerSpans will be 1/2&#010 of {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderHeight headerHeight}.
     *
     *
     * @return Integer
     *
     */
    public Integer getHeaderSpanHeight()  {
        return getAttributeAsInt("headerSpanHeight");
    }

    /**
    * When {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} are in use, whether to show a hierarchical column picker&#010 that includes both headerSpans and normal headers, with normal headers indented under&#010 headerSpans similarly to how a {@link com.smartgwt.client.widgets.tree.TreeGrid} displays a Tree.&#010 <P>&#010 If <code>showTreeColumnPicker</code> is false, no column picker will be shown on the&#010 headerSpan itself, and the column picker for a clicked on a normal field header will include&#010 only normal fields.
    *
    * @param showTreeColumnPicker showTreeColumnPicker Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowTreeColumnPicker(Boolean showTreeColumnPicker)  throws IllegalStateException {
        setAttribute("showTreeColumnPicker", showTreeColumnPicker, false);
    }
    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} are in use, whether to show a hierarchical column picker&#010 that includes both headerSpans and normal headers, with normal headers indented under&#010 headerSpans similarly to how a {@link com.smartgwt.client.widgets.tree.TreeGrid} displays a Tree.&#010 <P>&#010 If <code>showTreeColumnPicker</code> is false, no column picker will be shown on the&#010 headerSpan itself, and the column picker for a clicked on a normal field header will include&#010 only normal fields.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowTreeColumnPicker()  {
        return getAttributeAsBoolean("showTreeColumnPicker");
    }

    /**
    * If this property is true, any mouse click outside of the open cell editors&#010      will end editing mode, hiding the cell editors and saving any changes to those&#010      cell values.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param modalEditing modalEditing Default value is null
    */
    public void setModalEditing(Boolean modalEditing) {
        setAttribute("modalEditing", modalEditing, true);
    }
    /**
     * If this property is true, any mouse click outside of the open cell editors&#010      will end editing mode, hiding the cell editors and saving any changes to those&#010      cell values.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getModalEditing()  {
        return getAttributeAsBoolean("modalEditing");
    }

    /**
    * If we're showing the filterEditor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor} is true), and we're&#010 re-filtering on every keypress ({@link com.smartgwt.client.widgets.grid.ListGrid#getFilterOnKeypress filterOnKeypress} is true), this &#010 property is the delay in milliseconds between the user changing the filter and the &#010 filter request being kicked off. If multiple changes are made to the filter &#010 within this fetch delay, only the most recent will actually cause a re-filter
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param fetchDelay fetchDelay Default value is 300
    */
    public void setFetchDelay(int fetchDelay) {
        setAttribute("fetchDelay", fetchDelay, true);
    }
    /**
     * If we're showing the filterEditor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor} is true), and we're&#010 re-filtering on every keypress ({@link com.smartgwt.client.widgets.grid.ListGrid#getFilterOnKeypress filterOnKeypress} is true), this &#010 property is the delay in milliseconds between the user changing the filter and the &#010 filter request being kicked off. If multiple changes are made to the filter &#010 within this fetch delay, only the most recent will actually cause a re-filter
     *
     *
     * @return int
     *
     */
    public int getFetchDelay()  {
        return getAttributeAsInt("fetchDelay");
    }

    /**
    * Whether all rows should be drawn all at once, or only rows visible in the viewport.<br><br>&#010&#010 Drawing all rows causes longer initial rendering time, but allows smoother vertical scrolling.&#010 With a very large number of rows, showAllRows will become too slow.
    *
    * @param showAllRecords showAllRecords Default value is false
    */
    public void setShowAllRecords(Boolean showAllRecords) {
        setAttribute("showAllRecords", showAllRecords, true);
    }
    /**
     * Whether all rows should be drawn all at once, or only rows visible in the viewport.<br><br>&#010&#010 Drawing all rows causes longer initial rendering time, but allows smoother vertical scrolling.&#010 With a very large number of rows, showAllRows will become too slow.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowAllRecords()  {
        return getAttributeAsBoolean("showAllRecords");
    }

    /**
    * If drawing all rows would cause less than <code>drawAllMaxCells</code> cells to be rendered,&#010 the full dataset will instead be drawn even if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowAllRecords showAllRecords}&#010 is false and the viewport size and {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} setting would normally have caused&#010 incremental rendering to be used.&#010 <P>&#010 The <code>drawAllMaxCells</code> setting prevents incremental rendering from being used in&#010 situations where it's really unnecessary, such as a 40 row, 5 column dataset (only 200&#010 cells) which happens to be in a grid with a viewport showing only 20 or so rows.&#010 Incremental rendering causes a brief "flash" during scrolling as the visible portion of the&#010 dataset is redrawn, and a better scrolling experience can be obtained in this situation by&#010 drawing the entire dataset up front, which in this example would have neglible effect on&#010 initial draw time.&#010 <P>&#010 <code>drawAllMaxCells:0</code> disables this features.  You may want to disable this feature&#010 if performance is an issue and:&#010 <ul>&#010 <li> you are very frequently redraw a grid&#010 <li> you do a lot of computation when rendering each cell (eg formulas)&#010 <li> you are showing many grids on one screen and the user won't scroll most of them&#010 </ul>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param drawAllMaxCells drawAllMaxCells Default value is 250
    */
    public void setDrawAllMaxCells(int drawAllMaxCells) {
        setAttribute("drawAllMaxCells", drawAllMaxCells, true);
    }
    /**
     * If drawing all rows would cause less than <code>drawAllMaxCells</code> cells to be rendered,&#010 the full dataset will instead be drawn even if {@link com.smartgwt.client.widgets.grid.ListGrid#getShowAllRecords showAllRecords}&#010 is false and the viewport size and {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} setting would normally have caused&#010 incremental rendering to be used.&#010 <P>&#010 The <code>drawAllMaxCells</code> setting prevents incremental rendering from being used in&#010 situations where it's really unnecessary, such as a 40 row, 5 column dataset (only 200&#010 cells) which happens to be in a grid with a viewport showing only 20 or so rows.&#010 Incremental rendering causes a brief "flash" during scrolling as the visible portion of the&#010 dataset is redrawn, and a better scrolling experience can be obtained in this situation by&#010 drawing the entire dataset up front, which in this example would have neglible effect on&#010 initial draw time.&#010 <P>&#010 <code>drawAllMaxCells:0</code> disables this features.  You may want to disable this feature&#010 if performance is an issue and:&#010 <ul>&#010 <li> you are very frequently redraw a grid&#010 <li> you do a lot of computation when rendering each cell (eg formulas)&#010 <li> you are showing many grids on one screen and the user won't scroll most of them&#010 </ul>
     *
     *
     * @return int
     *
     */
    public int getDrawAllMaxCells()  {
        return getAttributeAsInt("drawAllMaxCells");
    }

    /**
    * How far should we render rows ahead of the currently visible area?  This is expressed as a&#010 ratio from viewport size to rendered area size.<br><br>&#010 &#010 Tweaking drawAheadRatio allows you to make tradeoffs between continuous scrolling speed vs&#010 initial render time and render time when scrolling by large amounts.<br><br>&#010&#010 NOTE: Only applies when showAllRows is false.
    *
    * @param drawAheadRatio drawAheadRatio Default value is 1.3
    */
    public void setDrawAheadRatio(float drawAheadRatio) {
        setAttribute("drawAheadRatio", drawAheadRatio, true);
    }
    /**
     * How far should we render rows ahead of the currently visible area?  This is expressed as a&#010 ratio from viewport size to rendered area size.<br><br>&#010 &#010 Tweaking drawAheadRatio allows you to make tradeoffs between continuous scrolling speed vs&#010 initial render time and render time when scrolling by large amounts.<br><br>&#010&#010 NOTE: Only applies when showAllRows is false.
     *
     *
     * @return float
     *
     */
    public float getDrawAheadRatio()  {
        return getAttributeAsFloat("drawAheadRatio");
    }

    /**
    * Alternative to {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio}, to be used when the user&#010 is rapidly changing the grids viewport (for example drag scrolling through the grid).&#010 If unspecified {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} will be used in all cases
    *
    * @param quickDrawAheadRatio quickDrawAheadRatio Default value is 1.3
    */
    public void setQuickDrawAheadRatio(float quickDrawAheadRatio) {
        setAttribute("quickDrawAheadRatio", quickDrawAheadRatio, true);
    }
    /**
     * Alternative to {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio}, to be used when the user&#010 is rapidly changing the grids viewport (for example drag scrolling through the grid).&#010 If unspecified {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio} will be used in all cases
     *
     *
     * @return float
     *
     */
    public float getQuickDrawAheadRatio()  {
        return getAttributeAsFloat("quickDrawAheadRatio");
    }

    /**
    * While drag scrolling in an incrementally rendered grid, time in milliseconds to wait&#010 before redrawing, after the last mouse movement by the user.
    *
    * @param scrollRedrawDelay scrollRedrawDelay Default value is 75
    */
    public void setScrollRedrawDelay(int scrollRedrawDelay) {
        setAttribute("scrollRedrawDelay", scrollRedrawDelay, true);
    }
    /**
     * While drag scrolling in an incrementally rendered grid, time in milliseconds to wait&#010 before redrawing, after the last mouse movement by the user.
     *
     *
     * @return int
     *
     */
    public int getScrollRedrawDelay()  {
        return getAttributeAsInt("scrollRedrawDelay");
    }
             
    /**
    * Overflow setting for the "body", that is, the area of the grid where data values are&#010 rendered.&#010 <P>&#010 By setting both the grid itself and the body to overflow:visible, it is possible to&#010 "auto-fit" to the rendered height or width of the rows.  Note that in this case&#010 <code>grid.width</code> and <code>grid.height</code> act as minimums.
    * Update the {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyOverflow bodyOverflow} for this listGrid.&#010
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param bodyOverflow new overflow setting for the body. Default value is Canvas.AUTO
    */
    public void setBodyOverflow(Overflow bodyOverflow) {
        setAttribute("bodyOverflow", bodyOverflow.getValue(), true);
    }
    /**
     * Overflow setting for the "body", that is, the area of the grid where data values are&#010 rendered.&#010 <P>&#010 By setting both the grid itself and the body to overflow:visible, it is possible to&#010 "auto-fit" to the rendered height or width of the rows.  Note that in this case&#010 <code>grid.width</code> and <code>grid.height</code> act as minimums.
     *
     *
     * @return Overflow
     *
     */
    public Overflow getBodyOverflow()  {
        return (Overflow) EnumUtil.getEnum(Overflow.values(), getAttribute("bodyOverflow"));
    }

    /**
    * Background color applied to the ListGrid body (that is, the area of the grid where&#010 data values are rendered).<br>&#010 Note that this will typically not be visible to the user unless there are few enough&#010 rows that there is visible space in the body below the last row. To style data cells,&#010 override {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} instead.
    *
    * @param bodyBackgroundColor bodyBackgroundColor Default value is "white"
    */
    public void setBodyBackgroundColor(String bodyBackgroundColor) {
        setAttribute("bodyBackgroundColor", bodyBackgroundColor, true);
    }
    /**
     * Background color applied to the ListGrid body (that is, the area of the grid where&#010 data values are rendered).<br>&#010 Note that this will typically not be visible to the user unless there are few enough&#010 rows that there is visible space in the body below the last row. To style data cells,&#010 override {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} instead.
     *
     *
     * @return String
     *
     */
    public String getBodyBackgroundColor()  {
        return getAttributeAsString("bodyBackgroundColor");
    }

    /**
    * CSS style used for the body of this grid.  If applying a background-color to the body&#010 via a CSS style applied using this property, be sure to set &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyBackgroundColor bodyBackgroundColor} to <code>null</code>.
    * Update the {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyStyleName bodyStyleName} for this listGrid.&#010
    *
    * @param bodyStyleName new body style name. Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setBodyStyleName(String bodyStyleName)  throws IllegalStateException {
        setAttribute("bodyStyleName", bodyStyleName, false);
    }
    /**
     * CSS style used for the body of this grid.  If applying a background-color to the body&#010 via a CSS style applied using this property, be sure to set &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyBackgroundColor bodyBackgroundColor} to <code>null</code>.
     *
     *
     * @return String
     *
     */
    public String getBodyStyleName()  {
        return getAttributeAsString("bodyStyleName");
    }

    /**
    * The value to display for cells whose value is null or the empty string after applying&#010 formatCellValue and valueMap (if any).&#010 <p>&#010 This is the grid-wide attribute.  You may also set the emptyCellValue on a per-field basis.
    *
    * @param emptyCellValue emptyCellValue Default value is "&nbsp;"
    */
    public void setEmptyCellValue(String emptyCellValue) {
        setAttribute("emptyCellValue", emptyCellValue, true);
    }
    /**
     * The value to display for cells whose value is null or the empty string after applying&#010 formatCellValue and valueMap (if any).&#010 <p>&#010 This is the grid-wide attribute.  You may also set the emptyCellValue on a per-field basis.
     *
     *
     * @return String
     *
     */
    public String getEmptyCellValue()  {
        return getAttributeAsString("emptyCellValue");
    }

    /**
    * The default height of each row in pixels.
    *
    * @param cellHeight cellHeight Default value is 20
    */
    public void setCellHeight(int cellHeight) {
        setAttribute("cellHeight", cellHeight, true);
    }
    /**
     * The default height of each row in pixels.
     *
     *
     * @return int
     *
     */
    public int getCellHeight()  {
        return getAttributeAsInt("cellHeight");
    }

    /**
    * Should we vertically clip cell contents, or allow rows to expand vertically to show all&#010 contents?&#010 <P>&#010 If we allow rows to expand, the row height as derived from&#010 {@link com.smartgwt.client.grid.GridRenderer#getRowHeight} or the&#010 default {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight cellHeight} is treated as a minimum.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param fixedRecordHeights fixedRecordHeights Default value is true
    */
    public void setFixedRecordHeights(Boolean fixedRecordHeights) {
        setAttribute("fixedRecordHeights", fixedRecordHeights, true);
    }
    /**
     * Should we vertically clip cell contents, or allow rows to expand vertically to show all&#010 contents?&#010 <P>&#010 If we allow rows to expand, the row height as derived from&#010 {@link com.smartgwt.client.grid.GridRenderer#getRowHeight} or the&#010 default {@link com.smartgwt.client.widgets.grid.ListGrid#getCellHeight cellHeight} is treated as a minimum.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getFixedRecordHeights()  {
        return getAttributeAsBoolean("fixedRecordHeights");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or <code>"both"</code> this&#010 property provides an upper limit on how far the ListGrid will expand vertically to accomodate&#010 its content. If content exceeds this height, scrollbars will be introduced as usual.  &#010 In addition to this property, {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords} allows you to limit vertical&#010 expansion based on the number of rows to be rendered.
    * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxHeight autoFitMaxHeight}.&#010
    *
    * @param autoFitMaxHeight Maximum height in px we'll expand to accomodate if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is enabled vertically.. Default value is null
    */
    public void setAutoFitMaxHeight(Integer autoFitMaxHeight) {
        setAttribute("autoFitMaxHeight", autoFitMaxHeight, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or <code>"both"</code> this&#010 property provides an upper limit on how far the ListGrid will expand vertically to accomodate&#010 its content. If content exceeds this height, scrollbars will be introduced as usual.  &#010 In addition to this property, {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords} allows you to limit vertical&#010 expansion based on the number of rows to be rendered.
     *
     *
     * @return Integer
     *
     */
    public Integer getAutoFitMaxHeight()  {
        return getAttributeAsInt("autoFitMaxHeight");
    }

    /**
    * if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or <code>"both"</code> this&#010 property provides the maximum number of records for which the ListGrid will expand. If more&#010 records are present, scrolling will be introduced to reach them as normal.&#010 If unset, by default the ListGrid will expand to accomodate as many records as are present.
    * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords}.&#010
    *
    * @param autoFitMaxRecords Maximum number of rows we'll expand to accomodate if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is enabled vertically.. Default value is 50
    */
    public void setAutoFitMaxRecords(int autoFitMaxRecords) {
        setAttribute("autoFitMaxRecords", autoFitMaxRecords, true);
    }
    /**
     * if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"vertical"</code> or <code>"both"</code> this&#010 property provides the maximum number of records for which the ListGrid will expand. If more&#010 records are present, scrolling will be introduced to reach them as normal.&#010 If unset, by default the ListGrid will expand to accomodate as many records as are present.
     *
     *
     * @return int
     *
     */
    public int getAutoFitMaxRecords()  {
        return getAttributeAsInt("autoFitMaxRecords");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or <code>"both"</code>&#010 this property provides an upper limit on how far the ListGrid will expand horizontally to&#010 accomodate its content. &#010 If content exceeds this width, scrollbars will be introduced as usual.  &#010 In addition to this property, {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns} allows you to limit &#010 horizontal expansion based on the number of columns to be rendered.
    * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxWidth autoFitMaxWidth}.&#010
    *
    * @param autoFitMaxWidth Width in px we'll expand to accomodate if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is enabled horizontally.. Default value is null
    */
    public void setAutoFitMaxWidth(Integer autoFitMaxWidth) {
        setAttribute("autoFitMaxWidth", autoFitMaxWidth, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or <code>"both"</code>&#010 this property provides an upper limit on how far the ListGrid will expand horizontally to&#010 accomodate its content. &#010 If content exceeds this width, scrollbars will be introduced as usual.  &#010 In addition to this property, {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns} allows you to limit &#010 horizontal expansion based on the number of columns to be rendered.
     *
     *
     * @return Integer
     *
     */
    public Integer getAutoFitMaxWidth()  {
        return getAttributeAsInt("autoFitMaxWidth");
    }

    /**
    * if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or <code>"both"</code>&#010 this property provides the maximum number of columns for which the ListGrid will expand.&#010 If more columns are present, scrolling will be introduced to reach them as normal.&#010 If unset the ListGrid will expand to accomodate as many columns as are defined for the&#010 grid.
    * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns}.&#010
    *
    * @param autoFitMaxColumns Maximum number of fields we'll expand to accomodate if  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is enabled horizontally.. Default value is 50
    */
    public void setAutoFitMaxColumns(int autoFitMaxColumns) {
        setAttribute("autoFitMaxColumns", autoFitMaxColumns, true);
    }
    /**
     * if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or <code>"both"</code>&#010 this property provides the maximum number of columns for which the ListGrid will expand.&#010 If more columns are present, scrolling will be introduced to reach them as normal.&#010 If unset the ListGrid will expand to accomodate as many columns as are defined for the&#010 grid.
     *
     *
     * @return int
     *
     */
    public int getAutoFitMaxColumns()  {
        return getAttributeAsInt("autoFitMaxColumns");
    }

    /**
    * Whether to leave a gap for the vertical scrollbar, even when it's not present.&#010 <P>&#010 Note that if leaveScrollbarGap is false and vertical scrolling is introduced, fields&#010 will be resized to fit the smaller body area if possible, in order to avoid horizontal&#010 scrolling also being required.
    *
    * @param leaveScrollbarGap leaveScrollbarGap Default value is true
    */
    public void setLeaveScrollbarGap(Boolean leaveScrollbarGap) {
        setAttribute("leaveScrollbarGap", leaveScrollbarGap, true);
    }
    /**
     * Whether to leave a gap for the vertical scrollbar, even when it's not present.&#010 <P>&#010 Note that if leaveScrollbarGap is false and vertical scrolling is introduced, fields&#010 will be resized to fit the smaller body area if possible, in order to avoid horizontal&#010 scrolling also being required.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getLeaveScrollbarGap()  {
        return getAttributeAsBoolean("leaveScrollbarGap");
    }

    /**
    * Should content within cells be allowed to wrap?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param wrapCells wrapCells Default value is false
    */
    public void setWrapCells(Boolean wrapCells) {
        setAttribute("wrapCells", wrapCells, true);
    }
    /**
     * Should content within cells be allowed to wrap?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getWrapCells()  {
        return getAttributeAsBoolean("wrapCells");
    }

    /**
    * The amount of empty space, in pixels, surrounding each value in its cell.
    *
    * @param cellPadding cellPadding Default value is 2
    */
    public void setCellPadding(int cellPadding) {
        setAttribute("cellPadding", cellPadding, true);
    }
    /**
     * The amount of empty space, in pixels, surrounding each value in its cell.
     *
     *
     * @return int
     *
     */
    public int getCellPadding()  {
        return getAttributeAsInt("cellPadding");
    }
             
    /**
    * Display format to use for fields specified as type 'date'.  Default is to use the&#010 system-wide default short date format, configured via&#010 {@link com.smartgwt.client..Date#setShortDisplayFormat}.  Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat}, or&#010 function to change the display format for dates used by this grid.&#010 If specified as  a function, this function will be executed in the scope of the Date&#010 and should return the formatted string.<br>&#010 May also be specified at the field level via&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayFormat displayFormat}.<br>&#010 If this field is editable the dateFormatter will also be passed to the editor created&#010 to edit this field as {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat}.&#010 In this case you may also need to set {@link com.smartgwt.client.widgets.grid.ListGrid#getDateInputFormat dateInputFormat}.
    *
    * @param dateFormatter dateFormatter Default value is null
    */
    public void setDateFormatter(DateDisplayFormat dateFormatter) {
        setAttribute("dateFormatter", dateFormatter.getValue(), true);
    }
    /**
     * Display format to use for fields specified as type 'date'.  Default is to use the&#010 system-wide default short date format, configured via&#010 {@link com.smartgwt.client..Date#setShortDisplayFormat}.  Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat}, or&#010 function to change the display format for dates used by this grid.&#010 If specified as  a function, this function will be executed in the scope of the Date&#010 and should return the formatted string.<br>&#010 May also be specified at the field level via&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayFormat displayFormat}.<br>&#010 If this field is editable the dateFormatter will also be passed to the editor created&#010 to edit this field as {@link com.smartgwt.client.widgets.form.fields.DateItem#getDisplayFormat displayFormat}.&#010 In this case you may also need to set {@link com.smartgwt.client.widgets.grid.ListGrid#getDateInputFormat dateInputFormat}.
     *
     *
     * @return DateDisplayFormat
     *
     */
    public DateDisplayFormat getDateFormatter()  {
        return (DateDisplayFormat) EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
    * Property name on a record that will hold the link text for that record.&#010 <br>&#010 This property is configurable to avoid possible collision with data values in the record.
    *
    * @param linkTextProperty linkTextProperty Default value is "linkText"
    */
    public void setLinkTextProperty(String linkTextProperty) {
        setAttribute("linkTextProperty", linkTextProperty, true);
    }
    /**
     * Property name on a record that will hold the link text for that record.&#010 <br>&#010 This property is configurable to avoid possible collision with data values in the record.
     *
     *
     * @return String
     *
     */
    public String getLinkTextProperty()  {
        return getAttributeAsString("linkTextProperty");
    }

    /**
    * A base name for the CSS class applied to cells when editing has failed.<br>&#010  If this listGrid is editable, this style will be applied to any edited cells for which&#010  validation failed.<br>&#010  As with the default 'baseStyle' property, this style will have "Dark", "Over", "Selected", &#010  or "Disabled" appended to it according to the state of the cell.<br>&#010 If null, cells for which editing has failed will be rendered using the normal base style&#010 classNames, but with custom CSSText applied as derived from <code>this.editFailedCSSText</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param editFailedBaseStyle editFailedBaseStyle Default value is null
    */
    public void setEditFailedBaseStyle(String editFailedBaseStyle) {
        setAttribute("editFailedBaseStyle", editFailedBaseStyle, true);
    }
    /**
     * A base name for the CSS class applied to cells when editing has failed.<br>&#010  If this listGrid is editable, this style will be applied to any edited cells for which&#010  validation failed.<br>&#010  As with the default 'baseStyle' property, this style will have "Dark", "Over", "Selected", &#010  or "Disabled" appended to it according to the state of the cell.<br>&#010 If null, cells for which editing has failed will be rendered using the normal base style&#010 classNames, but with custom CSSText applied as derived from <code>this.editFailedCSSText</code>
     *
     *
     * @return String
     *
     */
    public String getEditFailedBaseStyle()  {
        return getAttributeAsString("editFailedBaseStyle");
    }

    /**
    * Custom CSS text to be applied to cells when editing has failed.<br>&#010  If this listGrid is editable, this css text will be applied to any edited cells for which&#010  validation failed, on top of the base style for the cell.<br>&#010 For further customization of styling for cells that failed editing validation, use&#010 <code>this.editFailedBaseStyle</code> instead.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param editFailedCSSText editFailedCSSText Default value is "color:red;border:1px solid red;"
    */
    public void setEditFailedCSSText(String editFailedCSSText) {
        setAttribute("editFailedCSSText", editFailedCSSText, true);
    }
    /**
     * Custom CSS text to be applied to cells when editing has failed.<br>&#010  If this listGrid is editable, this css text will be applied to any edited cells for which&#010  validation failed, on top of the base style for the cell.<br>&#010 For further customization of styling for cells that failed editing validation, use&#010 <code>this.editFailedBaseStyle</code> instead.
     *
     *
     * @return String
     *
     */
    public String getEditFailedCSSText()  {
        return getAttributeAsString("editFailedCSSText");
    }

    /**
     * A base name for the CSS class applied to cells containing pending (unsaved) edits<br>&#010  As with the default 'baseStyle' property, this style will have "Dark", "Over", "Selected", &#010  or "Disabled" appended to it according to the state of the cell.&#010  If this property is null, cells with pending edits will pick up custom css text to&#010  be applied on top of the normal base style from <code>this.editPendingCSSText</code>
     *
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return String
     *
     * @throws IllegalStateException if widget has not yet been rendered.
     */
    public String getEditPendingBaseStyle() throws IllegalStateException {
        errorIfNotCreated("editPendingBaseStyle");
        return getAttributeAsString("editPendingBaseStyle");
    }

    /**
    * Custom CSS text to be applied to cells with pending edits that have not yet been&#010  submitted.<br>&#010 For further customization of styling for cells with pending edits use&#010 <code>this.editPendingBaseStyle</code> instead.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param editPendingCSSText editPendingCSSText Default value is "border:color:#0066CC;"
    */
    public void setEditPendingCSSText(String editPendingCSSText) {
        setAttribute("editPendingCSSText", editPendingCSSText, true);
    }
    /**
     * Custom CSS text to be applied to cells with pending edits that have not yet been&#010  submitted.<br>&#010 For further customization of styling for cells with pending edits use&#010 <code>this.editPendingBaseStyle</code> instead.
     *
     *
     * @return String
     *
     */
    public String getEditPendingCSSText()  {
        return getAttributeAsString("editPendingCSSText");
    }

    /**
    * This attribute allows custom base styles to be displayed on a per-record basis.&#010 To specify a custom base-style for some record set &#010 <code>record[listGrid.recordBaseStyleProperty]</code> to the desired base style name - &#010 for example if <code>recordBaseStyleProperty</code> is <code>"_baseStyle"</code>, set&#010 <code>record._baseStyle</code> to the custom base style name.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param recordBaseStyleProperty recordBaseStyleProperty Default value is "_baseStyle"
    */
    public void setRecordBaseStyleProperty(String recordBaseStyleProperty) {
        setAttribute("recordBaseStyleProperty", recordBaseStyleProperty, true);
    }
    /**
     * This attribute allows custom base styles to be displayed on a per-record basis.&#010 To specify a custom base-style for some record set &#010 <code>record[listGrid.recordBaseStyleProperty]</code> to the desired base style name - &#010 for example if <code>recordBaseStyleProperty</code> is <code>"_baseStyle"</code>, set&#010 <code>record._baseStyle</code> to the custom base style name.
     *
     *
     * @return String
     *
     */
    public String getRecordBaseStyleProperty()  {
        return getAttributeAsString("recordBaseStyleProperty");
    }

    /**
    * If this listGrid contains any frozen fields, this property can be used to apply a custom&#010 baseStyle to all cells in those frozen fields. If unset, the standard base style will be&#010 used for both frozen and unfrozen cells.
    *
    * @param frozenBaseStyle frozenBaseStyle Default value is null
    */
    public void setFrozenBaseStyle(String frozenBaseStyle) {
        setAttribute("frozenBaseStyle", frozenBaseStyle, true);
    }
    /**
     * If this listGrid contains any frozen fields, this property can be used to apply a custom&#010 baseStyle to all cells in those frozen fields. If unset, the standard base style will be&#010 used for both frozen and unfrozen cells.
     *
     *
     * @return String
     *
     */
    public String getFrozenBaseStyle()  {
        return getAttributeAsString("frozenBaseStyle");
    }

    /**
    * If this list grid is showing any {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} fields, and a horizontal&#010 scrollbar is visible at the bottom of the liquid columns, should an equivalent scrollbar gap&#010 be left visible below the frozen columns?<br>&#010 Note that if set to <code>true</code> any backgroundColor or border applied to the ListGrid&#010 will show up below the bottom row of the frozen column(s).
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param shrinkForFreeze shrinkForFreeze Default value is false
    */
    public void setShrinkForFreeze(Boolean shrinkForFreeze) {
        setAttribute("shrinkForFreeze", shrinkForFreeze, true);
    }
    /**
     * If this list grid is showing any {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} fields, and a horizontal&#010 scrollbar is visible at the bottom of the liquid columns, should an equivalent scrollbar gap&#010 be left visible below the frozen columns?<br>&#010 Note that if set to <code>true</code> any backgroundColor or border applied to the ListGrid&#010 will show up below the bottom row of the frozen column(s).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShrinkForFreeze()  {
        return getAttributeAsBoolean("shrinkForFreeze");
    }

    /**
    * Whether alternating rows should be drawn in alternating styles, in order to create a "ledger"&#010 effect for easier reading.  If enabled, the cell style for alternate rows will have "Dark"&#010 appended to it.
    * Setter for {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles}&#010
    *
    * @param alternateRecordStyles New value for <code>this.alternateRecordStyles</code>. Default value is false
    */
    public void setAlternateRecordStyles(Boolean alternateRecordStyles) {
        setAttribute("alternateRecordStyles", alternateRecordStyles, true);
    }
    /**
     * Whether alternating rows should be drawn in alternating styles, in order to create a "ledger"&#010 effect for easier reading.  If enabled, the cell style for alternate rows will have "Dark"&#010 appended to it.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAlternateRecordStyles()  {
        return getAttributeAsBoolean("alternateRecordStyles");
    }

    /**
    * Optional css style to apply to the body if {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles} is true &#010 for this grid. If unset {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyStyleName bodyStyleName} will be used to style the body&#010 regardless of the {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles} setting.
    * Update the {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateBodyStyleName alternateBodyStyleName} for this listGrid.&#010
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param alternateBodyStyleName new body style name when showing alternateRecordStyles. Default value is null
    */
    public void setAlternateBodyStyleName(String alternateBodyStyleName) {
        setAttribute("alternateBodyStyleName", alternateBodyStyleName, true);
    }
    /**
     * Optional css style to apply to the body if {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles} is true &#010 for this grid. If unset {@link com.smartgwt.client.widgets.grid.ListGrid#getBodyStyleName bodyStyleName} will be used to style the body&#010 regardless of the {@link com.smartgwt.client.widgets.grid.ListGrid#getAlternateRecordStyles alternateRecordStyles} setting.
     *
     *
     * @return String
     *
     */
    public String getAlternateBodyStyleName()  {
        return getAttributeAsString("alternateBodyStyleName");
    }

    /**
    * The number of consecutive rows to draw in the same style before alternating, when&#010 alternateRowStyles is true.
    *
    * @param alternateRecordFrequency alternateRecordFrequency Default value is 1
    */
    public void setAlternateRecordFrequency(int alternateRecordFrequency) {
        setAttribute("alternateRecordFrequency", alternateRecordFrequency, true);
    }
    /**
     * The number of consecutive rows to draw in the same style before alternating, when&#010 alternateRowStyles is true.
     *
     *
     * @return int
     *
     */
    public int getAlternateRecordFrequency()  {
        return getAttributeAsInt("alternateRecordFrequency");
    }

    /**
    * If true, when the user navigates to a cell using arrow keys and hits space, &#010 the cell will respond to a click event.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param generateClickOnSpace generateClickOnSpace Default value is true
    */
    public void setGenerateClickOnSpace(Boolean generateClickOnSpace) {
        setAttribute("generateClickOnSpace", generateClickOnSpace, true);
    }
    /**
     * If true, when the user navigates to a cell using arrow keys and hits space, &#010 the cell will respond to a click event.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getGenerateClickOnSpace()  {
        return getAttributeAsBoolean("generateClickOnSpace");
    }

    /**
    * If true, when the user navigates to a cell using arrow keys and hits Enter, &#010 the cell will respond to a click event.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param generateClickOnEnter generateClickOnEnter Default value is false
    */
    public void setGenerateClickOnEnter(Boolean generateClickOnEnter) {
        setAttribute("generateClickOnEnter", generateClickOnEnter, true);
    }
    /**
     * If true, when the user navigates to a cell using arrow keys and hits Enter, &#010 the cell will respond to a click event.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getGenerateClickOnEnter()  {
        return getAttributeAsBoolean("generateClickOnEnter");
    }

    /**
    * If true, when the user navigates to a cell using arrow keys and hits Space, &#010 the cell will respond to a double click event.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param generateDoubleClickOnSpace generateDoubleClickOnSpace Default value is false
    */
    public void setGenerateDoubleClickOnSpace(Boolean generateDoubleClickOnSpace) {
        setAttribute("generateDoubleClickOnSpace", generateDoubleClickOnSpace, true);
    }
    /**
     * If true, when the user navigates to a cell using arrow keys and hits Space, &#010 the cell will respond to a double click event.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getGenerateDoubleClickOnSpace()  {
        return getAttributeAsBoolean("generateDoubleClickOnSpace");
    }

    /**
    * If true, when the user navigates to a cell using arrow keys and hits Enter, &#010 the cell will respond to a double click event.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param generateDoubleClickOnEnter generateDoubleClickOnEnter Default value is true
    */
    public void setGenerateDoubleClickOnEnter(Boolean generateDoubleClickOnEnter) {
        setAttribute("generateDoubleClickOnEnter", generateDoubleClickOnEnter, true);
    }
    /**
     * If true, when the user navigates to a cell using arrow keys and hits Enter, &#010 the cell will respond to a double click event.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getGenerateDoubleClickOnEnter()  {
        return getAttributeAsBoolean("generateDoubleClickOnEnter");
    }

    /**
    * Action to perform when the listGrid has keyboard focus (but not editing focus) and a user&#010 presses the up or down arrow key. Possible values are:&#010 <ul>&#010 <li><code>select</code> : select the next row in the list (calls <code>recordClick</code> handler)</li>&#010 <li><code>focus</code> : move focus to the next row in the list without changing the selection</li>&#010 <li><code>activate</code> : select and activate the next row in the list (calls&#010  <code>recordDoubleClick</code> handler)</li>&#010 <li><code>none</code> : no action</li>&#010 </ul>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param arrowKeyAction arrowKeyAction Default value is "select"
    */
    public void setArrowKeyAction(String arrowKeyAction) {
        setAttribute("arrowKeyAction", arrowKeyAction, true);
    }
    /**
     * Action to perform when the listGrid has keyboard focus (but not editing focus) and a user&#010 presses the up or down arrow key. Possible values are:&#010 <ul>&#010 <li><code>select</code> : select the next row in the list (calls <code>recordClick</code> handler)</li>&#010 <li><code>focus</code> : move focus to the next row in the list without changing the selection</li>&#010 <li><code>activate</code> : select and activate the next row in the list (calls&#010  <code>recordDoubleClick</code> handler)</li>&#010 <li><code>none</code> : no action</li>&#010 </ul>
     *
     *
     * @return String
     *
     */
    public String getArrowKeyAction()  {
        return getAttributeAsString("arrowKeyAction");
    }

    /**
    * Should we show different styling for the cell the mouse is over?&#010 <br>&#010 If true, the cell style will have the suffix "Over" appended.
    *
    * @param showRollOver showRollOver Default value is true
    */
    public void setShowRollOver(Boolean showRollOver) {
        setAttribute("showRollOver", showRollOver, true);
    }
    /**
     * Should we show different styling for the cell the mouse is over?&#010 <br>&#010 If true, the cell style will have the suffix "Over" appended.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowRollOver()  {
        return getAttributeAsBoolean("showRollOver");
    }

    /**
    * If true, cellHover and rowHover events will fire when the user leaves the mouse over a &#010 row / cell.
    *
    * @param canHover canHover Default value is null
    */
    public void setCanHover(Boolean canHover) {
        setAttribute("canHover", canHover, true);
    }
    /**
     * If true, cellHover and rowHover events will fire when the user leaves the mouse over a &#010 row / cell.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanHover()  {
        return getAttributeAsBoolean("canHover");
    }

    /**
    * If true, and canHover is also true, when the user hovers over a cell, hover text will pop up&#010 next to the mouse.  The contents of the hover is determined by {@link com.smartgwt.client.widgets.grid.ListGrid#cellHoverHTML}.
    *
    * @param showHover showHover Default value is true
    */
    public void setShowHover(Boolean showHover) {
        setAttribute("showHover", showHover, true);
    }
    /**
     * If true, and canHover is also true, when the user hovers over a cell, hover text will pop up&#010 next to the mouse.  The contents of the hover is determined by {@link com.smartgwt.client.widgets.grid.ListGrid#cellHoverHTML}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowHover()  {
        return getAttributeAsBoolean("showHover");
    }

    /**
    * Style to apply to hovers shown over this grid.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param hoverStyle hoverStyle Default value is "gridHover"
    */
    public void setHoverStyle(String hoverStyle) {
        setAttribute("hoverStyle", hoverStyle, true);
    }
    /**
     * Style to apply to hovers shown over this grid.
     *
     *
     * @return String
     *
     */
    public String getHoverStyle()  {
        return getAttributeAsString("hoverStyle");
    }
             
    /**
    * How selection of rows should be presented to the user.&#010 <P>&#010 If using "checkbox", see also {@link com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkboxField} for customization APIs.
    * Changes selectionAppearance on the fly.&#010
    *
    * @param selectionAppearance new selection appearance. Default value is "rowStyle"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setSelectionAppearance(SelectionAppearance selectionAppearance)  throws IllegalStateException {
        setAttribute("selectionAppearance", selectionAppearance.getValue(), false);
    }
    /**
     * How selection of rows should be presented to the user.&#010 <P>&#010 If using "checkbox", see also {@link com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkboxField} for customization APIs.
     *
     *
     * @return SelectionAppearance
     *
     */
    public SelectionAppearance getSelectionAppearance()  {
        return (SelectionAppearance) EnumUtil.getEnum(SelectionAppearance.values(), getAttribute("selectionAppearance"));
    }
             
    /**
    * Defines a listGrid's clickable-selection behavior. The selection appearance is governed&#010 by {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance}. If selectionAppearance is "checkbox", this will&#010 be "simple", otherwise, this will be "multiple".
    * Changes selectionType on the fly.&#010
    *
    * @param selectionType New selection style.    Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is <code>"checkbox"</code>, only selectionType&#010   "simple" is supported.. Default value is null
    */
    public void setSelectionType(SelectionStyle selectionType) {
        setAttribute("selectionType", selectionType.getValue(), true);
    }
    /**
     * Defines a listGrid's clickable-selection behavior. The selection appearance is governed&#010 by {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance}. If selectionAppearance is "checkbox", this will&#010 be "simple", otherwise, this will be "multiple".
     *
     *
     * @return SelectionStyle
     *
     */
    public SelectionStyle getSelectionType()  {
        return (SelectionStyle) EnumUtil.getEnum(SelectionStyle.values(), getAttribute("selectionType"));
    }

    /**
    * If this property is true, users can drag the mouse to select several rows or cells.&#010  This is mutually exclusive with rearranging rows or cells by dragging.
    *
    * @param canDragSelect canDragSelect Default value is false
    */
    public void setCanDragSelect(Boolean canDragSelect) {
        setAttribute("canDragSelect", canDragSelect, true);
    }
    /**
     * If this property is true, users can drag the mouse to select several rows or cells.&#010  This is mutually exclusive with rearranging rows or cells by dragging.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanDragSelect()  {
        return getAttributeAsBoolean("canDragSelect");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to <code>"checkbox"</code> this property&#010 determines the image to display in the checkbox field for a selected row.&#010 If unset, the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} will be used.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param checkboxFieldTrueImage checkboxFieldTrueImage Default value is null
    */
    public void setCheckboxFieldTrueImage(String checkboxFieldTrueImage) {
        setAttribute("checkboxFieldTrueImage", checkboxFieldTrueImage, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to <code>"checkbox"</code> this property&#010 determines the image to display in the checkbox field for a selected row.&#010 If unset, the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} will be used.
     *
     *
     * @return String
     *
     */
    public String getCheckboxFieldTrueImage()  {
        return getAttributeAsString("checkboxFieldTrueImage");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to <code>"checkbox"</code> this property&#010 determines the image to display in the checkbox field for an unselected row.&#010 If unset, the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} will be used.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param checkboxFieldFalseImage checkboxFieldFalseImage Default value is null
    */
    public void setCheckboxFieldFalseImage(String checkboxFieldFalseImage) {
        setAttribute("checkboxFieldFalseImage", checkboxFieldFalseImage, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to <code>"checkbox"</code> this property&#010 determines the image to display in the checkbox field for an unselected row.&#010 If unset, the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} will be used.
     *
     *
     * @return String
     *
     */
    public String getCheckboxFieldFalseImage()  {
        return getAttributeAsString("checkboxFieldFalseImage");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to <code>"checkbox"</code> this property&#010 may be set to govern the width of the checkbox image displayed to indicate whether a row is&#010 selected. If unset, the checkboxField image will be sized to match the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanImageWidth booleanImageWidth} for this grid.
    *
    * @param checkboxFieldImageWidth checkboxFieldImageWidth Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCheckboxFieldImageWidth(Integer checkboxFieldImageWidth)  throws IllegalStateException {
        setAttribute("checkboxFieldImageWidth", checkboxFieldImageWidth, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to <code>"checkbox"</code> this property&#010 may be set to govern the width of the checkbox image displayed to indicate whether a row is&#010 selected. If unset, the checkboxField image will be sized to match the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanImageWidth booleanImageWidth} for this grid.
     *
     *
     * @return Integer
     *
     */
    public Integer getCheckboxFieldImageWidth()  {
        return getAttributeAsInt("checkboxFieldImageWidth");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to <code>"checkbox"</code> this property&#010 may be set to govern the height of the checkbox image displayed to indicate whether a row is&#010 selected. If unset, the checkboxField image will be sized to match the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanImageHeight booleanImageHeight} for this grid.
    *
    * @param checkboxFieldImageHeight checkboxFieldImageHeight Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCheckboxFieldImageHeight(Integer checkboxFieldImageHeight)  throws IllegalStateException {
        setAttribute("checkboxFieldImageHeight", checkboxFieldImageHeight, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionAppearance selectionAppearance} is set to <code>"checkbox"</code> this property&#010 may be set to govern the height of the checkbox image displayed to indicate whether a row is&#010 selected. If unset, the checkboxField image will be sized to match the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanImageHeight booleanImageHeight} for this grid.
     *
     *
     * @return Integer
     *
     */
    public Integer getCheckboxFieldImageHeight()  {
        return getAttributeAsInt("checkboxFieldImageHeight");
    }

    /**
    * Indicates whether the text of the emptyMessage property should be displayed if no data is&#010 available.
    *
    * @param showEmptyMessage showEmptyMessage Default value is true
    */
    public void setShowEmptyMessage(Boolean showEmptyMessage) {
        setAttribute("showEmptyMessage", showEmptyMessage, true);
    }
    /**
     * Indicates whether the text of the emptyMessage property should be displayed if no data is&#010 available.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowEmptyMessage()  {
        return getAttributeAsBoolean("showEmptyMessage");
    }

    /**
    * The string to display in the body of a listGrid with an empty data array, if&#010 showEmptyMessage is true.
    *
    * @param emptyMessage emptyMessage Default value is "No items to show."
    */
    public void setEmptyMessage(String emptyMessage) {
        setAttribute("emptyMessage", emptyMessage, true);
    }
    /**
     * The string to display in the body of a listGrid with an empty data array, if&#010 showEmptyMessage is true.
     *
     *
     * @return String
     *
     */
    public String getEmptyMessage()  {
        return getAttributeAsString("emptyMessage");
    }

    /**
    * The CSS style name applied to the {@link com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessage emptyMessage} if displayed.
    *
    * @param emptyMessageStyle emptyMessageStyle Default value is "emptyMessage"
    */
    public void setEmptyMessageStyle(String emptyMessageStyle) {
        setAttribute("emptyMessageStyle", emptyMessageStyle, true);
    }
    /**
     * The CSS style name applied to the {@link com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessage emptyMessage} if displayed.
     *
     *
     * @return String
     *
     */
    public String getEmptyMessageStyle()  {
        return getAttributeAsString("emptyMessageStyle");
    }

    /**
    * The string to display in the body of a listGrid while data is being loaded.
    *
    * @param loadingDataMessage loadingDataMessage Default value is "Loading data..."
    */
    public void setLoadingDataMessage(String loadingDataMessage) {
        setAttribute("loadingDataMessage", loadingDataMessage, true);
    }
    /**
     * The string to display in the body of a listGrid while data is being loaded.
     *
     *
     * @return String
     *
     */
    public String getLoadingDataMessage()  {
        return getAttributeAsString("loadingDataMessage");
    }

    /**
    * The CSS style name applied to the loadingDataMessage string if displayed.
    *
    * @param loadingDataMessageStyle loadingDataMessageStyle Default value is "loadingDataMessage"
    */
    public void setLoadingDataMessageStyle(String loadingDataMessageStyle) {
        setAttribute("loadingDataMessageStyle", loadingDataMessageStyle, true);
    }
    /**
     * The CSS style name applied to the loadingDataMessage string if displayed.
     *
     *
     * @return String
     *
     */
    public String getLoadingDataMessageStyle()  {
        return getAttributeAsString("loadingDataMessageStyle");
    }

    /**
    * If you have a databound listGrid and you scroll out of the currently loaded dataset, by&#010 default you will see blank rows until the server returns the data for those rows.  The&#010 loadingMessage attribute allows you to specify arbitrary html that will be shown in each&#010 such "blank" record while the data for that record is loading.
    *
    * @param loadingMessage loadingMessage Default value is "\&nbsp;"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setLoadingMessage(String loadingMessage)  throws IllegalStateException {
        setAttribute("loadingMessage", loadingMessage, false);
    }
    /**
     * If you have a databound listGrid and you scroll out of the currently loaded dataset, by&#010 default you will see blank rows until the server returns the data for those rows.  The&#010 loadingMessage attribute allows you to specify arbitrary html that will be shown in each&#010 such "blank" record while the data for that record is loading.
     *
     *
     * @return String
     *
     */
    public String getLoadingMessage()  {
        return getAttributeAsString("loadingMessage");
    }

    /**
    * If <code>record[this.singleCellValueProperty]</code> is set for some record, the &#010 record will be displayed as a single cell spanning every column in the grid, with &#010 contents set to the value of <code>record[this.singleCellValueProperty]</code>.
    *
    * @param singleCellValueProperty singleCellValueProperty Default value is "singleCellValue"
    */
    public void setSingleCellValueProperty(String singleCellValueProperty) {
        setAttribute("singleCellValueProperty", singleCellValueProperty, true);
    }
    /**
     * If <code>record[this.singleCellValueProperty]</code> is set for some record, the &#010 record will be displayed as a single cell spanning every column in the grid, with &#010 contents set to the value of <code>record[this.singleCellValueProperty]</code>.
     *
     *
     * @return String
     *
     */
    public String getSingleCellValueProperty()  {
        return getAttributeAsString("singleCellValueProperty");
    }

    /**
    * If <code>record[this.isSeparatorProperty]</code> is set for some record, the &#010 record will be displayed as a simple separator row.
    *
    * @param isSeparatorProperty isSeparatorProperty Default value is "isSeparator"
    */
    public void setIsSeparatorProperty(String isSeparatorProperty) {
        setAttribute("isSeparatorProperty", isSeparatorProperty, true);
    }
    /**
     * If <code>record[this.isSeparatorProperty]</code> is set for some record, the &#010 record will be displayed as a simple separator row.
     *
     *
     * @return String
     *
     */
    public String getIsSeparatorProperty()  {
        return getAttributeAsString("isSeparatorProperty");
    }

    /**
    * Should this listGrid display a filter row.  If true, this ListGrid&#010 will be drawn with a single editable row, (separate from the body) with a filter button.&#010 Values entered into this row are used as filter criteria to filter this List's data on&#010 enter-keypress or filter button click. {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchAsFilter autoFetchAsFilter} determines whether&#010 the filter occurs as a {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} or {@link com.smartgwt.client.widgets.grid.ListGrid#filterData} call.&#010 <P>&#010 Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#filterData} or {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} is called directly&#010 while the filter editor is showing, the filter editor values will be updated to reflect the&#010 new set of criteria. If you wish to retain the user entered filter criteria and &#010 programatically modify a subset of field values programatically this can be achieved by&#010 deriving new criteria by copying the existing set of criteria and adding other changes - &#010 something like this:&#010 <pre><code>&#010   var newCriteria = isc.clone(myListGrid.getCriteria());&#010   isc.addProperties(newCriteria, {&#010      field1:"new value1",&#010      field2:"new value2"&#010   });&#010   myListGrid.setCriteria(newCriteria);&#010 </code></pre>&#010 <P>&#010 Also note that if you call <code>filterData()</code> and pass in criteria for dataSource &#010 fields that are not present in the ListGrid, these criteria will continue to be applied along&#010 with the user visible criteria.
    * Setter for the {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor} property. Allows the filter editor to be&#010 shown or hidden at runtime.&#010
    *
    * @param showFilterEditor true if the filter editor should be shown, false if it should be hidden. Default value is null
    */
    public void setShowFilterEditor(Boolean showFilterEditor) {
        setAttribute("showFilterEditor", showFilterEditor, true);
    }
    /**
     * Should this listGrid display a filter row.  If true, this ListGrid&#010 will be drawn with a single editable row, (separate from the body) with a filter button.&#010 Values entered into this row are used as filter criteria to filter this List's data on&#010 enter-keypress or filter button click. {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchAsFilter autoFetchAsFilter} determines whether&#010 the filter occurs as a {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} or {@link com.smartgwt.client.widgets.grid.ListGrid#filterData} call.&#010 <P>&#010 Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#filterData} or {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} is called directly&#010 while the filter editor is showing, the filter editor values will be updated to reflect the&#010 new set of criteria. If you wish to retain the user entered filter criteria and &#010 programatically modify a subset of field values programatically this can be achieved by&#010 deriving new criteria by copying the existing set of criteria and adding other changes - &#010 something like this:&#010 <pre><code>&#010   var newCriteria = isc.clone(myListGrid.getCriteria());&#010   isc.addProperties(newCriteria, {&#010      field1:"new value1",&#010      field2:"new value2"&#010   });&#010   myListGrid.setCriteria(newCriteria);&#010 </code></pre>&#010 <P>&#010 Also note that if you call <code>filterData()</code> and pass in criteria for dataSource &#010 fields that are not present in the ListGrid, these criteria will continue to be applied along&#010 with the user visible criteria.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowFilterEditor()  {
        return getAttributeAsBoolean("showFilterEditor");
    }

    /**
    * Height for the filterEditor, if shown.
    *
    * @param filterEditorHeight filterEditorHeight Default value is 22
    */
    public void setFilterEditorHeight(int filterEditorHeight) {
        setAttribute("filterEditorHeight", filterEditorHeight, true);
    }
    /**
     * Height for the filterEditor, if shown.
     *
     *
     * @return int
     *
     */
    public int getFilterEditorHeight()  {
        return getAttributeAsInt("filterEditorHeight");
    }

    /**
    * Determines whether {@link com.smartgwt.client.widgets.grid.ListGrid#filterData} or {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} should be called when this grid&#010 is initially filtered via {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchData autoFetchData}, or filtered by the user via the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}.
    *
    * @param autoFetchAsFilter autoFetchAsFilter Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setAutoFetchAsFilter(Boolean autoFetchAsFilter)  throws IllegalStateException {
        setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }
    /**
     * Determines whether {@link com.smartgwt.client.widgets.grid.ListGrid#filterData} or {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} should be called when this grid&#010 is initially filtered via {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchData autoFetchData}, or filtered by the user via the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoFetchAsFilter()  {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }

    /**
    * Can the user edit cells in this listGrid? Can be set for the listGrid, and overridden for &#010      individual fields.<br>&#010      If 'canEdit' is false at the listGrid level, fields can never be edited - in this case&#010      the canEdit property on individual fields will be ignored.<br>&#010      If 'canEdit' is set to true at the listGrid level, setting the 'canEdit' property to&#010      false at the field level will prevent the field from being edited inline.<br>&#010      If 'canEdit' is not set at the listGrid level, setting 'canEdit' to true at the field &#010      level enables the field to be edited inline.
    *
    * @param canEdit canEdit Default value is null
    */
    public void setCanEdit(Boolean canEdit) {
        setAttribute("canEdit", canEdit, true);
    }
    /**
     * Can the user edit cells in this listGrid? Can be set for the listGrid, and overridden for &#010      individual fields.<br>&#010      If 'canEdit' is false at the listGrid level, fields can never be edited - in this case&#010      the canEdit property on individual fields will be ignored.<br>&#010      If 'canEdit' is set to true at the listGrid level, setting the 'canEdit' property to&#010      false at the field level will prevent the field from being edited inline.<br>&#010      If 'canEdit' is not set at the listGrid level, setting 'canEdit' to true at the field &#010      level enables the field to be edited inline.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanEdit()  {
        return getAttributeAsBoolean("canEdit");
    }

    /**
    * Property name on a record that should be checked to determine whether the record may be&#010 edited.&#010 <br>&#010 This property is configurable to avoid possible collision with data values in record.&#010 With the default setting of "_canEdit", a record can be set non-editable by ensuring&#010 record._canEdit == false.&#010 <br>&#010 For controlling editability for the entire grid or for a field, set grid.canEdit or&#010 field.canEdit.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param recordEditProperty recordEditProperty Default value is "_canEdit"
    */
    public void setRecordEditProperty(String recordEditProperty) {
        setAttribute("recordEditProperty", recordEditProperty, true);
    }
    /**
     * Property name on a record that should be checked to determine whether the record may be&#010 edited.&#010 <br>&#010 This property is configurable to avoid possible collision with data values in record.&#010 With the default setting of "_canEdit", a record can be set non-editable by ensuring&#010 record._canEdit == false.&#010 <br>&#010 For controlling editability for the entire grid or for a field, set grid.canEdit or&#010 field.canEdit.
     *
     *
     * @return String
     *
     */
    public String getRecordEditProperty()  {
        return getAttributeAsString("recordEditProperty");
    }

    /**
    * Determines whether when the user edits a cell in this listGrid the entire row becomes&#010 editable, or just the cell that recieved the edit event.&#010 <P>&#010 No effect if this.canEdit is false or null.
    *
    * @param editByCell editByCell Default value is null
    */
    public void setEditByCell(Boolean editByCell) {
        setAttribute("editByCell", editByCell, true);
    }
    /**
     * Determines whether when the user edits a cell in this listGrid the entire row becomes&#010 editable, or just the cell that recieved the edit event.&#010 <P>&#010 No effect if this.canEdit is false or null.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEditByCell()  {
        return getAttributeAsBoolean("editByCell");
    }

    /**
    * Whether edits should be saved whenever the user moves between cells in the current edit&#010 row.&#010 <P>&#010 If unset, defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getEditByCell editByCell}.&#010 <P>&#010 To avoid automatic saving entirely, set {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits}:false.
    *
    * @param saveByCell saveByCell Default value is null
    */
    public void setSaveByCell(Boolean saveByCell) {
        setAttribute("saveByCell", saveByCell, true);
    }
    /**
     * Whether edits should be saved whenever the user moves between cells in the current edit&#010 row.&#010 <P>&#010 If unset, defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getEditByCell editByCell}.&#010 <P>&#010 To avoid automatic saving entirely, set {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits}:false.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSaveByCell()  {
        return getAttributeAsBoolean("saveByCell");
    }

    /**
    * Whether client-side validation checks should be performed when the user moves between&#010 cells in the current edit row.  If unset, defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getEditByCell editByCell}.&#010 <P>&#010 Note that validation always occurs when a row is to be saved, so setting&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell}:true forces validation on cell transitions.  To completely disable&#010 automatic validation, set {@link com.smartgwt.client.widgets.grid.ListGrid#getNeverValidate neverValidate}:true.
    *
    * @param validateByCell validateByCell Default value is null
    */
    public void setValidateByCell(Boolean validateByCell) {
        setAttribute("validateByCell", validateByCell, true);
    }
    /**
     * Whether client-side validation checks should be performed when the user moves between&#010 cells in the current edit row.  If unset, defaults to {@link com.smartgwt.client.widgets.grid.ListGrid#getEditByCell editByCell}.&#010 <P>&#010 Note that validation always occurs when a row is to be saved, so setting&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell}:true forces validation on cell transitions.  To completely disable&#010 automatic validation, set {@link com.smartgwt.client.widgets.grid.ListGrid#getNeverValidate neverValidate}:true.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getValidateByCell()  {
        return getAttributeAsBoolean("validateByCell");
    }

    /**
    * If true, validation will be perfomed on each edited cell when each editor's &#010 "change" handler is fired.
    *
    * @param validateOnChange validateOnChange Default value is null
    */
    public void setValidateOnChange(Boolean validateOnChange) {
        setAttribute("validateOnChange", validateOnChange, true);
    }
    /**
     * If true, validation will be perfomed on each edited cell when each editor's &#010 "change" handler is fired.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }

    /**
    * If true, validation will not occur as a result of cell editing for this grid.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param neverValidate neverValidate Default value is null
    */
    public void setNeverValidate(Boolean neverValidate) {
        setAttribute("neverValidate", neverValidate, true);
    }
    /**
     * If true, validation will not occur as a result of cell editing for this grid.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getNeverValidate()  {
        return getAttributeAsBoolean("neverValidate");
    }

    /**
    * If set, provide UI for the user to remove records from the grid. This is achieved by&#010 rendering an additional field in the listGrid which, when clicked, will remove the&#010 record associated with the clicked row via a call to {@link com.smartgwt.client.widgets.grid.ListGrid#removeData}.&#010 <P>&#010 If {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord} is true, the removed record will appear to shrink&#010 out of view when it is removed.&#010 <P>&#010 By default the field will display the {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveIcon removeIcon} next to each record, and&#010 will be rendered as the leftmost column. Two mechanisms exist to further modify this field:&#010 <ul>&#010 <li>To change the position of the remove-field, include an explicitly specified field with&#010     the attribute {@link com.smartgwt.client.widgets.grid.ListGridField#getIsRemoveField isRemoveField} set. This will then&#010     be used as the remove field instead of adding a field to the beginning of the set of&#010     columns.</li>&#010 <li>Additional direct configuration of the remove field may be achieved by modifying&#010     {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveFieldProperties removeFieldProperties}.</li>&#010 </ul>
    *
    * @param canRemoveRecords canRemoveRecords Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setCanRemoveRecords(Boolean canRemoveRecords)  throws IllegalStateException {
        setAttribute("canRemoveRecords", canRemoveRecords, false);
    }
    /**
     * If set, provide UI for the user to remove records from the grid. This is achieved by&#010 rendering an additional field in the listGrid which, when clicked, will remove the&#010 record associated with the clicked row via a call to {@link com.smartgwt.client.widgets.grid.ListGrid#removeData}.&#010 <P>&#010 If {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord} is true, the removed record will appear to shrink&#010 out of view when it is removed.&#010 <P>&#010 By default the field will display the {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveIcon removeIcon} next to each record, and&#010 will be rendered as the leftmost column. Two mechanisms exist to further modify this field:&#010 <ul>&#010 <li>To change the position of the remove-field, include an explicitly specified field with&#010     the attribute {@link com.smartgwt.client.widgets.grid.ListGridField#getIsRemoveField isRemoveField} set. This will then&#010     be used as the remove field instead of adding a field to the beginning of the set of&#010     columns.</li>&#010 <li>Additional direct configuration of the remove field may be achieved by modifying&#010     {@link com.smartgwt.client.widgets.grid.ListGrid#getRemoveFieldProperties removeFieldProperties}.</li>&#010 </ul>
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanRemoveRecords()  {
        return getAttributeAsBoolean("canRemoveRecords");
    }

    /**
    * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, default icon to show in&#010 the auto-generated field that allows removing records.
    *
    * @param removeIcon removeIcon Default value is "[SKIN]/actions/remove.png"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setRemoveIcon(String removeIcon)  throws IllegalStateException {
        setAttribute("removeIcon", removeIcon, false);
    }
    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, default icon to show in&#010 the auto-generated field that allows removing records.
     *
     *
     * @return String
     *
     */
    public String getRemoveIcon()  {
        return getAttributeAsString("removeIcon");
    }

    /**
    * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, should records be animated out of view&#010 when they are removed by the user?
    *
    * @param animateRemoveRecord animateRemoveRecord Default value is true
    */
    public void setAnimateRemoveRecord(Boolean animateRemoveRecord) {
        setAttribute("animateRemoveRecord", animateRemoveRecord, true);
    }
    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getCanRemoveRecords canRemoveRecords} is enabled, should records be animated out of view&#010 when they are removed by the user?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAnimateRemoveRecord()  {
        return getAttributeAsBoolean("animateRemoveRecord");
    }

    /**
    * When animating record removal &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord}, if &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveSpeed animateRemoveSpeed} is not&#010 set, this property designates the duration of the animation in ms.
    *
    * @param animateRemoveTime animateRemoveTime Default value is 100
    */
    public void setAnimateRemoveTime(int animateRemoveTime) {
        setAttribute("animateRemoveTime", animateRemoveTime, true);
    }
    /**
     * When animating record removal &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord}, if &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveSpeed animateRemoveSpeed} is not&#010 set, this property designates the duration of the animation in ms.
     *
     *
     * @return int
     *
     */
    public int getAnimateRemoveTime()  {
        return getAttributeAsInt("animateRemoveTime");
    }

    /**
    * When {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord}, this property &#010 designates the speed of the animation in pixels per second. Takes presidence over the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveTime animateRemoveTime} property, which allows the developer to specify a&#010 duration for the animation rather than a speed.
    *
    * @param animateRemoveSpeed animateRemoveSpeed Default value is 200
    */
    public void setAnimateRemoveSpeed(int animateRemoveSpeed) {
        setAttribute("animateRemoveSpeed", animateRemoveSpeed, true);
    }
    /**
     * When {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveRecord animateRemoveRecord}, this property &#010 designates the speed of the animation in pixels per second. Takes presidence over the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getAnimateRemoveTime animateRemoveTime} property, which allows the developer to specify a&#010 duration for the animation rather than a speed.
     *
     *
     * @return int
     *
     */
    public int getAnimateRemoveSpeed()  {
        return getAttributeAsInt("animateRemoveSpeed");
    }

    /**
    * If we're showing the filterEditor (this.showFilterEditor is true), this property &#010 determines whether this list should be filtered every time the user puts focus in&#010 a different field in the filter editor.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param filterByCell filterByCell Default value is null
    */
    public void setFilterByCell(Boolean filterByCell) {
        setAttribute("filterByCell", filterByCell, true);
    }
    /**
     * If we're showing the filterEditor (this.showFilterEditor is true), this property &#010 determines whether this list should be filtered every time the user puts focus in&#010 a different field in the filter editor.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getFilterByCell()  {
        return getAttributeAsBoolean("filterByCell");
    }

    /**
    * If we're showing the filterEditor (this.showFilterEditor is true), this property &#010 determines whether this list should be filtered every time the user modifies the value&#010 in a field of the filter-editor. Can also be set at the field level.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param filterOnKeypress filterOnKeypress Default value is null
    */
    public void setFilterOnKeypress(Boolean filterOnKeypress) {
        setAttribute("filterOnKeypress", filterOnKeypress, true);
    }
    /**
     * If we're showing the filterEditor (this.showFilterEditor is true), this property &#010 determines whether this list should be filtered every time the user modifies the value&#010 in a field of the filter-editor. Can also be set at the field level.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getFilterOnKeypress()  {
        return getAttributeAsBoolean("filterOnKeypress");
    }

    /**
    * If this is an editable listGrid, this property determines whether the user will be&#010 able to dismiss the edit form, or navigate to another cell while the save is in &#010 process (before the asynchronous server response returns).
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param waitForSave waitForSave Default value is false
    */
    public void setWaitForSave(Boolean waitForSave) {
        setAttribute("waitForSave", waitForSave, true);
    }
    /**
     * If this is an editable listGrid, this property determines whether the user will be&#010 able to dismiss the edit form, or navigate to another cell while the save is in &#010 process (before the asynchronous server response returns).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getWaitForSave()  {
        return getAttributeAsBoolean("waitForSave");
    }

    /**
    * If this is an editable listGrid, this property determines how failure to save due to &#010 validation errors should be displayed to the user.&#010 <P>&#010 If this property is true, when validation errors occur the errors will be displayed&#010 to the user in an alert, and focus will be returned to the first cell to fail validation.&#010 <P>&#010 If false, this the cells that failed validation will be silently styled with the &#010 editFailedBaseStyle.<br>&#010 <b>Note:</b> stopOnErrors being set to true implies that 'waitForSave' is also true.&#010 We will not dismiss the editor until save has completed if stopOnErrors is true.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param stopOnErrors stopOnErrors Default value is false
    */
    public void setStopOnErrors(Boolean stopOnErrors) {
        setAttribute("stopOnErrors", stopOnErrors, true);
    }
    /**
     * If this is an editable listGrid, this property determines how failure to save due to &#010 validation errors should be displayed to the user.&#010 <P>&#010 If this property is true, when validation errors occur the errors will be displayed&#010 to the user in an alert, and focus will be returned to the first cell to fail validation.&#010 <P>&#010 If false, this the cells that failed validation will be silently styled with the &#010 editFailedBaseStyle.<br>&#010 <b>Note:</b> stopOnErrors being set to true implies that 'waitForSave' is also true.&#010 We will not dismiss the editor until save has completed if stopOnErrors is true.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getStopOnErrors()  {
        return getAttributeAsBoolean("stopOnErrors");
    }

    /**
    * If this ListGrid is editable, should edits be saved out when the user finishes editing&#010 a row (or a cell if {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell} is true).&#010 <P>&#010 The default of <code>true</code> indicates that edits will be&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell} as the&#010 user navigates through the grid and/or {@link com.smartgwt.client.types.EnterKeyEditAction} to end&#010 editing.  See the {@link com.smartgwt.client.docs.Editing 'Grid Editing'} overview for details. &#010 <P>&#010 Setting <code>autoSaveEdits</code> false creates a "mass update" / "mass delete"&#010 interaction where edits will be retained for all edited cells (across rows if&#010 appropriate) until {@link com.smartgwt.client.widgets.grid.ListGrid#saveEdits} is called to save a particular row, or&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#saveAllEdits} is called to save all changes in a batch.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param autoSaveEdits autoSaveEdits Default value is true
    */
    public void setAutoSaveEdits(Boolean autoSaveEdits) {
        setAttribute("autoSaveEdits", autoSaveEdits, true);
    }
    /**
     * If this ListGrid is editable, should edits be saved out when the user finishes editing&#010 a row (or a cell if {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell} is true).&#010 <P>&#010 The default of <code>true</code> indicates that edits will be&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell} as the&#010 user navigates through the grid and/or {@link com.smartgwt.client.types.EnterKeyEditAction} to end&#010 editing.  See the {@link com.smartgwt.client.docs.Editing 'Grid Editing'} overview for details. &#010 <P>&#010 Setting <code>autoSaveEdits</code> false creates a "mass update" / "mass delete"&#010 interaction where edits will be retained for all edited cells (across rows if&#010 appropriate) until {@link com.smartgwt.client.widgets.grid.ListGrid#saveEdits} is called to save a particular row, or&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#saveAllEdits} is called to save all changes in a batch.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoSaveEdits()  {
        return getAttributeAsBoolean("autoSaveEdits");
    }

    /**
    * If this is an editable listGrid, when the user attempts to cancel an edit, should we&#010 display a confirmation prompt before discarding the edited values for the record?
    *
    * @param confirmCancelEditing confirmCancelEditing Default value is false
    */
    public void setConfirmCancelEditing(Boolean confirmCancelEditing) {
        setAttribute("confirmCancelEditing", confirmCancelEditing, true);
    }
    /**
     * If this is an editable listGrid, when the user attempts to cancel an edit, should we&#010 display a confirmation prompt before discarding the edited values for the record?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getConfirmCancelEditing()  {
        return getAttributeAsBoolean("confirmCancelEditing");
    }

    /**
    * If this is an editable listGrid, and <code>this.confirmCancelEditing</code> is true&#010 this property is used as the message to display in the confirmation dismissal prompt.
    *
    * @param cancelEditingConfirmationMessage cancelEditingConfirmationMessage Default value is Cancelling this edit will clear unsaved edit values for this record. Continue?
    */
    public void setCancelEditingConfirmationMessage(String cancelEditingConfirmationMessage) {
        setAttribute("cancelEditingConfirmationMessage", cancelEditingConfirmationMessage, true);
    }
    /**
     * If this is an editable listGrid, and <code>this.confirmCancelEditing</code> is true&#010 this property is used as the message to display in the confirmation dismissal prompt.
     *
     *
     * @return String
     *
     */
    public String getCancelEditingConfirmationMessage()  {
        return getAttributeAsString("cancelEditingConfirmationMessage");
    }

    /**
    * For editable listGrids, outstanding unsaved edits when the user performs a new filter&#010 or sort will be discarded. This flag determines whether we should display a confirmation&#010 dialog with options to save or discard the edits, or cancel the action in this case.
    *
    * @param confirmDiscardEdits confirmDiscardEdits Default value is true
    */
    public void setConfirmDiscardEdits(Boolean confirmDiscardEdits) {
        setAttribute("confirmDiscardEdits", confirmDiscardEdits, true);
    }
    /**
     * For editable listGrids, outstanding unsaved edits when the user performs a new filter&#010 or sort will be discarded. This flag determines whether we should display a confirmation&#010 dialog with options to save or discard the edits, or cancel the action in this case.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getConfirmDiscardEdits()  {
        return getAttributeAsBoolean("confirmDiscardEdits");
    }

    /**
    * If <code>this.confirmDiscardEdits</code> is true, this property can be used to customize the&#010 error message string displayed to the user in a dialog with options to &#010 cancel the action, or save or discard pending edits in response to sort/filter actions&#010 that would otherwise drop unsaved edit values.
    *
    * @param confirmDiscardEditsMessage confirmDiscardEditsMessage Default value is "This action will discard all unsaved edited values for this list."
    */
    public void setConfirmDiscardEditsMessage(String confirmDiscardEditsMessage) {
        setAttribute("confirmDiscardEditsMessage", confirmDiscardEditsMessage, true);
    }
    /**
     * If <code>this.confirmDiscardEdits</code> is true, this property can be used to customize the&#010 error message string displayed to the user in a dialog with options to &#010 cancel the action, or save or discard pending edits in response to sort/filter actions&#010 that would otherwise drop unsaved edit values.
     *
     *
     * @return String
     *
     */
    public String getConfirmDiscardEditsMessage()  {
        return getAttributeAsString("confirmDiscardEditsMessage");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getConfirmDiscardEdits confirmDiscardEdits} is true this is the title for the save button&#010 appearing in the lost edits confirmation dialog. Override this for localization if necessary.
    *
    * @param discardEditsSaveButtonTitle discardEditsSaveButtonTitle Default value is "Save"
    */
    public void setDiscardEditsSaveButtonTitle(String discardEditsSaveButtonTitle) {
        setAttribute("discardEditsSaveButtonTitle", discardEditsSaveButtonTitle, true);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getConfirmDiscardEdits confirmDiscardEdits} is true this is the title for the save button&#010 appearing in the lost edits confirmation dialog. Override this for localization if necessary.
     *
     *
     * @return String
     *
     */
    public String getDiscardEditsSaveButtonTitle()  {
        return getAttributeAsString("discardEditsSaveButtonTitle");
    }
             
    /**
    * If the user is editing a record in this listGrid, and attempts to navigate to a field&#010 beyond the end of the row, via tab (or shift-tab off the first editable field), this &#010 property determines what action to take:<ul>&#010 <li>"next": start editing the next (or previous) record in the list&#010 <li>"same": put focus back into the first editable field of the same record.&#010 <li>"done": hide the editor&#010 <li>"stop": leave focus in the cell being edited&#010 </ul>
    *
    * @param rowEndEditAction rowEndEditAction Default value is "next"
    */
    public void setRowEndEditAction(RowEndEditAction rowEndEditAction) {
        setAttribute("rowEndEditAction", rowEndEditAction.getValue(), true);
    }
    /**
     * If the user is editing a record in this listGrid, and attempts to navigate to a field&#010 beyond the end of the row, via tab (or shift-tab off the first editable field), this &#010 property determines what action to take:<ul>&#010 <li>"next": start editing the next (or previous) record in the list&#010 <li>"same": put focus back into the first editable field of the same record.&#010 <li>"done": hide the editor&#010 <li>"stop": leave focus in the cell being edited&#010 </ul>
     *
     *
     * @return RowEndEditAction
     *
     */
    public RowEndEditAction getRowEndEditAction()  {
        return (RowEndEditAction) EnumUtil.getEnum(RowEndEditAction.values(), getAttribute("rowEndEditAction"));
    }
             
    /**
    * If the user is editing the last record in this listGrid, and attempts to navigate &#010 beyond the last row either by tabbing off the last editable field, or using the down&#010 arrow key, this property determines what action to take:<ul>&#010 <li>"next": start editing a new record at the end of the list.&#010 <li>"done": hide the editor&#010 <li>"stop": leave focus in the cell being edited&#010 </ul>
    *
    * @param listEndEditAction listEndEditAction Default value is "stop"
    */
    public void setListEndEditAction(RowEndEditAction listEndEditAction) {
        setAttribute("listEndEditAction", listEndEditAction.getValue(), true);
    }
    /**
     * If the user is editing the last record in this listGrid, and attempts to navigate &#010 beyond the last row either by tabbing off the last editable field, or using the down&#010 arrow key, this property determines what action to take:<ul>&#010 <li>"next": start editing a new record at the end of the list.&#010 <li>"done": hide the editor&#010 <li>"stop": leave focus in the cell being edited&#010 </ul>
     *
     *
     * @return RowEndEditAction
     *
     */
    public RowEndEditAction getListEndEditAction()  {
        return (RowEndEditAction) EnumUtil.getEnum(RowEndEditAction.values(), getAttribute("listEndEditAction"));
    }
             
    /**
    * What to do when a user hits enter while editing a cell:&#010 <ul>&#010 <li>"nextCell": start editing the next editable cell in this record (or the first&#010     editable cell in the next record if focus is in the last editable cell in the row)&#010 <li>"nextRow": start editing the same field in the next row (skipping any rows where&#010      that would be a non-editable cell.&#010 <li>"nextRowStart": start editing the first editable cell in the next row.&#010 <li>"done": hide the editor (editing is complete)&#010 </ul>&#010 Note that if this.autoSaveEdits is true, this may cause a save of the current edit values
    *
    * @param enterKeyEditAction enterKeyEditAction Default value is "done"
    */
    public void setEnterKeyEditAction(EnterKeyEditAction enterKeyEditAction) {
        setAttribute("enterKeyEditAction", enterKeyEditAction.getValue(), true);
    }
    /**
     * What to do when a user hits enter while editing a cell:&#010 <ul>&#010 <li>"nextCell": start editing the next editable cell in this record (or the first&#010     editable cell in the next record if focus is in the last editable cell in the row)&#010 <li>"nextRow": start editing the same field in the next row (skipping any rows where&#010      that would be a non-editable cell.&#010 <li>"nextRowStart": start editing the first editable cell in the next row.&#010 <li>"done": hide the editor (editing is complete)&#010 </ul>&#010 Note that if this.autoSaveEdits is true, this may cause a save of the current edit values
     *
     *
     * @return EnterKeyEditAction
     *
     */
    public EnterKeyEditAction getEnterKeyEditAction()  {
        return (EnterKeyEditAction) EnumUtil.getEnum(EnterKeyEditAction.values(), getAttribute("enterKeyEditAction"));
    }
             
    /**
    * What to do when a user hits escape while editing a cell:<ul>&#010 <li>"cancel": close the editor and discard the current set of edit values&#010 <li>"done": just close the editor (the edit is complete, but the edited values are retained).&#010 </ul>&#010 Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} is true, this may cause a save of the current edit values
    *
    * @param escapeKeyEditAction escapeKeyEditAction Default value is "cancel"
    */
    public void setEscapeKeyEditAction(EscapeKeyEditAction escapeKeyEditAction) {
        setAttribute("escapeKeyEditAction", escapeKeyEditAction.getValue(), true);
    }
    /**
     * What to do when a user hits escape while editing a cell:<ul>&#010 <li>"cancel": close the editor and discard the current set of edit values&#010 <li>"done": just close the editor (the edit is complete, but the edited values are retained).&#010 </ul>&#010 Note that if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} is true, this may cause a save of the current edit values
     *
     *
     * @return EscapeKeyEditAction
     *
     */
    public EscapeKeyEditAction getEscapeKeyEditAction()  {
        return (EscapeKeyEditAction) EnumUtil.getEnum(EscapeKeyEditAction.values(), getAttribute("escapeKeyEditAction"));
    }
             
    /**
    * Event that will trigger inline editing, see {@link com.smartgwt.client.types.ListGridEditEvent} for options.&#010 <P>&#010 Note this setting has no effect unless {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} has been set to enable editing.&#010 <P>&#010 See also {@link com.smartgwt.client.widgets.grid.ListGrid#getEditOnFocus editOnFocus} and {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing}.
    *
    * @param editEvent editEvent Default value is "doubleClick"
    */
    public void setEditEvent(ListGridEditEvent editEvent) {
        setAttribute("editEvent", editEvent.getValue(), true);
    }
    /**
     * Event that will trigger inline editing, see {@link com.smartgwt.client.types.ListGridEditEvent} for options.&#010 <P>&#010 Note this setting has no effect unless {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} has been set to enable editing.&#010 <P>&#010 See also {@link com.smartgwt.client.widgets.grid.ListGrid#getEditOnFocus editOnFocus} and {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing}.
     *
     *
     * @return ListGridEditEvent
     *
     */
    public ListGridEditEvent getEditEvent()  {
        return (ListGridEditEvent) EnumUtil.getEnum(ListGridEditEvent.values(), getAttribute("editEvent"));
    }

    /**
    * Should we start editing when this widget recieves focus (if this ListGrid supports&#010 editing)?&#010 <P>&#010 Note that this property being set to true will cause editing to occur on a single&#010 click, even if {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is <code>"doubleClick"</code>, because single clicking&#010 the grid will place keyboard focus there automatically.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param editOnFocus editOnFocus Default value is null
    */
    public void setEditOnFocus(Boolean editOnFocus) {
        setAttribute("editOnFocus", editOnFocus, true);
    }
    /**
     * Should we start editing when this widget recieves focus (if this ListGrid supports&#010 editing)?&#010 <P>&#010 Note that this property being set to true will cause editing to occur on a single&#010 click, even if {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent} is <code>"doubleClick"</code>, because single clicking&#010 the grid will place keyboard focus there automatically.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getEditOnFocus()  {
        return getAttributeAsBoolean("editOnFocus");
    }

    /**
    * When the user starts editing a row, should the data in that row also be selected?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param selectOnEdit selectOnEdit Default value is true
    */
    public void setSelectOnEdit(Boolean selectOnEdit) {
        setAttribute("selectOnEdit", selectOnEdit, true);
    }
    /**
     * When the user starts editing a row, should the data in that row also be selected?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSelectOnEdit()  {
        return getAttributeAsBoolean("selectOnEdit");
    }

    /**
    * When the length of the field specified by {@link com.smartgwt.client.data.DataSourceField#getLength length} exceeds this&#010 value, the ListGrid shows an edit field of type {@link com.smartgwt.client.widgets.grid.ListGrid#getLongTextEditorType longTextEditorType}&#010 rather than the standard text field when the field enters inline edit mode.
    *
    * @param longTextEditorThreshold longTextEditorThreshold Default value is 255
    */
    public void setLongTextEditorThreshold(int longTextEditorThreshold) {
        setAttribute("longTextEditorThreshold", longTextEditorThreshold, true);
    }
    /**
     * When the length of the field specified by {@link com.smartgwt.client.data.DataSourceField#getLength length} exceeds this&#010 value, the ListGrid shows an edit field of type {@link com.smartgwt.client.widgets.grid.ListGrid#getLongTextEditorType longTextEditorType}&#010 rather than the standard text field when the field enters inline edit mode.
     *
     *
     * @return int
     *
     */
    public int getLongTextEditorThreshold()  {
        return getAttributeAsInt("longTextEditorThreshold");
    }

    /**
    * When the length of the field specified by {@link com.smartgwt.client.data.DataSourceField#getLength length} exceeds &#010 <code>this.longTextEditorThreshold</code> show an edit field of this type&#010 rather than the standard text field when the field enters inline edit mode.
    *
    * @param longTextEditorType longTextEditorType Default value is "PopUpTextAreaItem"
    */
    public void setLongTextEditorType(String longTextEditorType) {
        setAttribute("longTextEditorType", longTextEditorType, true);
    }
    /**
     * When the length of the field specified by {@link com.smartgwt.client.data.DataSourceField#getLength length} exceeds &#010 <code>this.longTextEditorThreshold</code> show an edit field of this type&#010 rather than the standard text field when the field enters inline edit mode.
     *
     *
     * @return String
     *
     */
    public String getLongTextEditorType()  {
        return getAttributeAsString("longTextEditorType");
    }

    /**
    * The height of this listGrid's header, in pixels.
    * Modify the height of a listGrid. To hide the header set height to zero.&#010
    *
    * @param headerHeight new height for the header. Default value is 22
    */
    public void setHeaderHeight(int headerHeight) {
        setAttribute("headerHeight", headerHeight, true);
    }
    /**
     * The height of this listGrid's header, in pixels.
     *
     *
     * @return int
     *
     */
    public int getHeaderHeight()  {
        return getAttributeAsInt("headerHeight");
    }

    /**
    * Should we show the header for this ListGrid?
    * Show or hide the ListGrid header.&#010
    *
    * @param showHeader true to show the header, false to hide it.. Default value is true
    */
    public void setShowHeader(Boolean showHeader) {
        setAttribute("showHeader", showHeader, true);
    }
    /**
     * Should we show the header for this ListGrid?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowHeader()  {
        return getAttributeAsBoolean("showHeader");
    }

    /**
    * Set the CSS style used for the header as a whole.
    *
    * @param headerBarStyle headerBarStyle Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderBarStyle(String headerBarStyle)  throws IllegalStateException {
        setAttribute("headerBarStyle", headerBarStyle, false);
    }
    /**
     * Set the CSS style used for the header as a whole.
     *
     *
     * @return String
     *
     */
    public String getHeaderBarStyle()  {
        return getAttributeAsString("headerBarStyle");
    }

    /**
    * BackgroundColor for the header toolbar. Typically this is set to match the color&#010 of the header buttons.
    *
    * @param headerBackgroundColor headerBackgroundColor Default value is "#CCCCCC"
    */
    public void setHeaderBackgroundColor(String headerBackgroundColor) {
        setAttribute("headerBackgroundColor", headerBackgroundColor, true);
    }
    /**
     * BackgroundColor for the header toolbar. Typically this is set to match the color&#010 of the header buttons.
     *
     *
     * @return String
     *
     */
    public String getHeaderBackgroundColor()  {
        return getAttributeAsString("headerBackgroundColor");
    }

    /**
    * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} to apply to the buttons in the header, and the sorter, for &#010 this ListGrid.&#010 Note that depending on the {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor} of the header&#010 buttons you may also need to set {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle headerTitleStyle}.
    *
    * @param headerBaseStyle headerBaseStyle Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderBaseStyle(String headerBaseStyle)  throws IllegalStateException {
        setAttribute("headerBaseStyle", headerBaseStyle, false);
    }
    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} to apply to the buttons in the header, and the sorter, for &#010 this ListGrid.&#010 Note that depending on the {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor} of the header&#010 buttons you may also need to set {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderTitleStyle headerTitleStyle}.
     *
     *
     * @return String
     *
     */
    public String getHeaderBaseStyle()  {
        return getAttributeAsString("headerBaseStyle");
    }

    /**
    * {@link com.smartgwt.client.widgets.StretchImgButton#getTitleStyle titleStyle} to apply to the buttons in the header, and the sorter,&#010 for this ListGrid.&#010 Note that this will typically only have an effect if &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor} is set to {@link com.smartgwt.client.widgets.StretchImgButton} or a subclass &#010 thereof.
    *
    * @param headerTitleStyle headerTitleStyle Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderTitleStyle(String headerTitleStyle)  throws IllegalStateException {
        setAttribute("headerTitleStyle", headerTitleStyle, false);
    }
    /**
     * {@link com.smartgwt.client.widgets.StretchImgButton#getTitleStyle titleStyle} to apply to the buttons in the header, and the sorter,&#010 for this ListGrid.&#010 Note that this will typically only have an effect if &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderButtonConstructor headerButtonConstructor} is set to {@link com.smartgwt.client.widgets.StretchImgButton} or a subclass &#010 thereof.
     *
     *
     * @return String
     *
     */
    public String getHeaderTitleStyle()  {
        return getAttributeAsString("headerTitleStyle");
    }

    /**
    * If this listGrid contains any frozen fields, this property can be used to apply a custom&#010 headerBaseStyle to the frozen fields set of fields. If unset, the standard headerBaseStyle&#010 will be used for both frozen and unfrozen cells.
    *
    * @param frozenHeaderBaseStyle frozenHeaderBaseStyle Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setFrozenHeaderBaseStyle(String frozenHeaderBaseStyle)  throws IllegalStateException {
        setAttribute("frozenHeaderBaseStyle", frozenHeaderBaseStyle, false);
    }
    /**
     * If this listGrid contains any frozen fields, this property can be used to apply a custom&#010 headerBaseStyle to the frozen fields set of fields. If unset, the standard headerBaseStyle&#010 will be used for both frozen and unfrozen cells.
     *
     *
     * @return String
     *
     */
    public String getFrozenHeaderBaseStyle()  {
        return getAttributeAsString("frozenHeaderBaseStyle");
    }

    /**
    * If this listGrid contains any frozen fields, this property can be used to apply a custom&#010 headerTitleStyle to the frozen fields set of fields. If unset, the standard headerTitleStyle&#010 will be used for both frozen and unfrozen cells.
    *
    * @param frozenHeaderTitleStyle frozenHeaderTitleStyle Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setFrozenHeaderTitleStyle(String frozenHeaderTitleStyle)  throws IllegalStateException {
        setAttribute("frozenHeaderTitleStyle", frozenHeaderTitleStyle, false);
    }
    /**
     * If this listGrid contains any frozen fields, this property can be used to apply a custom&#010 headerTitleStyle to the frozen fields set of fields. If unset, the standard headerTitleStyle&#010 will be used for both frozen and unfrozen cells.
     *
     *
     * @return String
     *
     */
    public String getFrozenHeaderTitleStyle()  {
        return getAttributeAsString("frozenHeaderTitleStyle");
    }

    /**
    * Enables or disables interactive sorting behavior for this listGrid. Does not&#010          affect sorting by direct calls to the sort method.
    *
    * @param canSort canSort Default value is true
    */
    public void setCanSort(Boolean canSort) {
        setAttribute("canSort", canSort, true);
    }
    /**
     * Enables or disables interactive sorting behavior for this listGrid. Does not&#010          affect sorting by direct calls to the sort method.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanSort()  {
        return getAttributeAsBoolean("canSort");
    }
             
    /**
    * Indicates whether a sorting arrow should appear for the listGrid, and its&#010          location. See SortArrow type for details.<br>&#010          Clicking the sort arrow reverses the direction of sorting for the current sort&#010          column (if any), or sorts the listGrid by its first sortable column. The arrow&#010          image on the button indicates the current direction of sorting.&#010          If undefined, the sort arrow will show up in the sorted field, and the&#010          corner sort button will be displayed if a vertical scrollbar is being displayed
    *
    * @param showSortArrow showSortArrow Default value is null
    */
    public void setShowSortArrow(SortArrow showSortArrow) {
        setAttribute("showSortArrow", showSortArrow.getValue(), true);
    }
    /**
     * Indicates whether a sorting arrow should appear for the listGrid, and its&#010          location. See SortArrow type for details.<br>&#010          Clicking the sort arrow reverses the direction of sorting for the current sort&#010          column (if any), or sorts the listGrid by its first sortable column. The arrow&#010          image on the button indicates the current direction of sorting.&#010          If undefined, the sort arrow will show up in the sorted field, and the&#010          corner sort button will be displayed if a vertical scrollbar is being displayed
     *
     *
     * @return SortArrow
     *
     */
    public SortArrow getShowSortArrow()  {
        return (SortArrow) EnumUtil.getEnum(SortArrow.values(), getAttribute("showSortArrow"));
    }

    /**
    * Whether an interface should be shown to allow user is allowed to dynamically "freeze" or&#010 "unfreeze" columns with respect to horizontally scrolling. If unset, this property defaults&#010 to <code>true</code> unless:<ul>&#010 <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights fixedRecordHeights} is <code>false</code></li>&#010 <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getBodyOverflow bodyOverflow} is <code>"visible"</code></li>&#010 <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or &#010 <code>"both"</code></li>&#010 <li>Any field has overflow set to <code>"visible"</code></li></ul>&#010 <P>&#010 Note that the <code>canFreezeFields</code> setting enables or disables the user&#010 interface for freezing and unfreezing fields only.  Fields can be programmatically&#010 frozen via setting {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} to true when the grid is&#010 created, or dynamically frozen and unfrozen via {@link com.smartgwt.client.widgets.grid.ListGrid#freezeField} and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#unfreezeField}.
    * Setter method for {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields}&#010
    *
    * @param canFreezeFields New value for <code>listGrid.canFreezeFields</code>. Default value is null
    */
    public void setCanFreezeFields(Boolean canFreezeFields) {
        setAttribute("canFreezeFields", canFreezeFields, true);
    }
    /**
     * Whether an interface should be shown to allow user is allowed to dynamically "freeze" or&#010 "unfreeze" columns with respect to horizontally scrolling. If unset, this property defaults&#010 to <code>true</code> unless:<ul>&#010 <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getFixedRecordHeights fixedRecordHeights} is <code>false</code></li>&#010 <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getBodyOverflow bodyOverflow} is <code>"visible"</code></li>&#010 <li>{@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData} is set to <code>"horizontal"</code> or &#010 <code>"both"</code></li>&#010 <li>Any field has overflow set to <code>"visible"</code></li></ul>&#010 <P>&#010 Note that the <code>canFreezeFields</code> setting enables or disables the user&#010 interface for freezing and unfreezing fields only.  Fields can be programmatically&#010 frozen via setting {@link com.smartgwt.client.widgets.grid.ListGridField#getFrozen frozen} to true when the grid is&#010 created, or dynamically frozen and unfrozen via {@link com.smartgwt.client.widgets.grid.ListGrid#freezeField} and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#unfreezeField}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanFreezeFields()  {
        return getAttributeAsBoolean("canFreezeFields");
    }

    /**
    * Whether to show a context menu on the header with standard items for showing and hiding&#010 fields.
    *
    * @param showHeaderContextMenu showHeaderContextMenu Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowHeaderContextMenu(Boolean showHeaderContextMenu)  throws IllegalStateException {
        setAttribute("showHeaderContextMenu", showHeaderContextMenu, false);
    }
    /**
     * Whether to show a context menu on the header with standard items for showing and hiding&#010 fields.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowHeaderContextMenu()  {
        return getAttributeAsBoolean("showHeaderContextMenu");
    }

    /**
    * If set to true and {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} is true, the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderMenuButton headerMenuButton} will be displayed when the user rolls&#010 over the header buttons in this grid.
    *
    * @param showHeaderMenuButton showHeaderMenuButton Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowHeaderMenuButton(Boolean showHeaderMenuButton)  throws IllegalStateException {
        setAttribute("showHeaderMenuButton", showHeaderMenuButton, false);
    }
    /**
     * If set to true and {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} is true, the&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderMenuButton headerMenuButton} will be displayed when the user rolls&#010 over the header buttons in this grid.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowHeaderMenuButton()  {
        return getAttributeAsBoolean("showHeaderMenuButton");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the icon shown on the&#010 auto-generated <code>headerMenuButton</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param headerMenuButtonIcon headerMenuButtonIcon Default value is "[SKIN]/ListGrid/sort_descending.gif"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderMenuButtonIcon(String headerMenuButtonIcon)  throws IllegalStateException {
        setAttribute("headerMenuButtonIcon", headerMenuButtonIcon, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the icon shown on the&#010 auto-generated <code>headerMenuButton</code>
     *
     *
     * @return String
     *
     */
    public String getHeaderMenuButtonIcon()  {
        return getAttributeAsString("headerMenuButtonIcon");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the width of the icon&#010 shown on the auto-generated <code>headerMenuButton</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param headerMenuButtonIconWidth headerMenuButtonIconWidth Default value is 7
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderMenuButtonIconWidth(int headerMenuButtonIconWidth)  throws IllegalStateException {
        setAttribute("headerMenuButtonIconWidth", headerMenuButtonIconWidth, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the width of the icon&#010 shown on the auto-generated <code>headerMenuButton</code>
     *
     *
     * @return int
     *
     */
    public int getHeaderMenuButtonIconWidth()  {
        return getAttributeAsInt("headerMenuButtonIconWidth");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the height of the icon&#010 shown on the auto-generated <code>headerMenuButton</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param headerMenuButtonIconHeight headerMenuButtonIconHeight Default value is 7
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderMenuButtonIconHeight(int headerMenuButtonIconHeight)  throws IllegalStateException {
        setAttribute("headerMenuButtonIconHeight", headerMenuButtonIconHeight, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the height of the icon&#010 shown on the auto-generated <code>headerMenuButton</code>
     *
     *
     * @return int
     *
     */
    public int getHeaderMenuButtonIconHeight()  {
        return getAttributeAsInt("headerMenuButtonIconHeight");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the width of the &#010 auto-generated <code>headerMenuButton</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param headerMenuButtonWidth headerMenuButtonWidth Default value is 16
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderMenuButtonWidth(int headerMenuButtonWidth)  throws IllegalStateException {
        setAttribute("headerMenuButtonWidth", headerMenuButtonWidth, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the width of the &#010 auto-generated <code>headerMenuButton</code>
     *
     *
     * @return int
     *
     */
    public int getHeaderMenuButtonWidth()  {
        return getAttributeAsInt("headerMenuButtonWidth");
    }

    /**
    * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the height of the &#010 auto-generated <code>headerMenuButton</code>
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param headerMenuButtonHeight headerMenuButtonHeight Default value is "100%"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setHeaderMenuButtonHeight(int headerMenuButtonHeight)  throws IllegalStateException {
        setAttribute("headerMenuButtonHeight", headerMenuButtonHeight, false);
    }
    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderMenuButton showHeaderMenuButton} is true, this property governs the height of the &#010 auto-generated <code>headerMenuButton</code>
     *
     *
     * @return int
     *
     */
    public int getHeaderMenuButtonHeight()  {
        return getAttributeAsInt("headerMenuButtonHeight");
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
    * Indicates whether fields in this listGrid can be reordered by dragging and&#010          dropping header fields.
    *
    * @param canReorderFields canReorderFields Default value is true
    */
    public void setCanReorderFields(Boolean canReorderFields) {
        setAttribute("canReorderFields", canReorderFields, true);
    }
    /**
     * Indicates whether fields in this listGrid can be reordered by dragging and&#010          dropping header fields.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanReorderFields()  {
        return getAttributeAsBoolean("canReorderFields");
    }

    /**
    * Indicates whether fields in this listGrid can be resized by dragging header&#010          fields.
    * Setter method for updating {@link com.smartgwt.client.widgets.grid.ListGrid#getCanResizeFields canResizeFields} at runtime.&#010
    *
    * @param canResizeFields new value for this.canResizeFields. Default value is true
    */
    public void setCanResizeFields(Boolean canResizeFields) {
        setAttribute("canResizeFields", canResizeFields, true);
    }
    /**
     * Indicates whether fields in this listGrid can be resized by dragging header&#010          fields.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanResizeFields()  {
        return getAttributeAsBoolean("canResizeFields");
    }
             
    /**
    * When records are being dragged from within a ListGrid, what sort of drag-tracker&#010 should be displayed?<br>&#010 Note that if multiple records are being dragged the displayed tracker will be&#010 based on the first selected record.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param dragTrackerMode dragTrackerMode Default value is "icon"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setDragTrackerMode(DragTrackerMode dragTrackerMode)  throws IllegalStateException {
        setAttribute("dragTrackerMode", dragTrackerMode.getValue(), false);
    }
    /**
     * When records are being dragged from within a ListGrid, what sort of drag-tracker&#010 should be displayed?<br>&#010 Note that if multiple records are being dragged the displayed tracker will be&#010 based on the first selected record.
     *
     *
     * @return DragTrackerMode
     *
     */
    public DragTrackerMode getDragTrackerMode()  {
        return (DragTrackerMode) EnumUtil.getEnum(DragTrackerMode.values(), getAttribute("dragTrackerMode"));
    }

    /**
    * True == we redraw the list viewer in real time as fields are being resized.&#010  This can be slow with a large list and/or on some platforms.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param resizeFieldsInRealTime resizeFieldsInRealTime Default value is Browser.isIE && isc.Browser.isWin
    */
    public void setResizeFieldsInRealTime(Boolean resizeFieldsInRealTime) {
        setAttribute("resizeFieldsInRealTime", resizeFieldsInRealTime, true);
    }
    /**
     * True == we redraw the list viewer in real time as fields are being resized.&#010  This can be slow with a large list and/or on some platforms.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getResizeFieldsInRealTime()  {
        return getAttributeAsBoolean("resizeFieldsInRealTime");
    }

    /**
    * Where do 'skin' images (those provided with the class) live?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param skinImgDir skinImgDir Default value is "images/ListGrid/"
    */
    public void setSkinImgDir(String skinImgDir) {
        setAttribute("skinImgDir", skinImgDir, true);
    }
    /**
     * Where do 'skin' images (those provided with the class) live?
     *
     *
     * @return String
     *
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }
            
    /**
    * Default image to use for the dragTracker when things are dragged within or out of this &#010 list. See ${isc.DocUtils.linkForRef('object:ImgProperties')} for format.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param trackerImage trackerImage Default value is {...}
    */
    public void setTrackerImage(ImgProperties trackerImage) {
        setAttribute("trackerImage", trackerImage.getJsObj(), true);
    }
    /**
     * Default image to use for the dragTracker when things are dragged within or out of this &#010 list. See ${isc.DocUtils.linkForRef('object:ImgProperties')} for format.
     *
     *
     * @return ImgProperties
     *
     */
    public ImgProperties getTrackerImage()  {
        return new ImgProperties(getAttributeAsJavaScriptObject("trackerImage"));
    }

    /**
    * Image to display for a true value in a boolean field.&#010 <P>&#010 To turn this off explicitly set {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} to true.&#010 <P>&#010 If this and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} are undefined, this will be set to&#010 {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param booleanTrueImage booleanTrueImage Default value is null
    */
    public void setBooleanTrueImage(String booleanTrueImage) {
        setAttribute("booleanTrueImage", booleanTrueImage, true);
    }
    /**
     * Image to display for a true value in a boolean field.&#010 <P>&#010 To turn this off explicitly set {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} to true.&#010 <P>&#010 If this and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage} are undefined, this will be set to&#010 {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage}.
     *
     *
     * @return String
     *
     */
    public String getBooleanTrueImage()  {
        return getAttributeAsString("booleanTrueImage");
    }

    /**
    * Image to display for a false value in a boolean field. Default <code>null</code> value&#010 means no image will be displayed&#010 <P>&#010 To turn this off explicitly set {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} to true&#010 <P>&#010 If this and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} are undefined, this will be set to&#010 {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param booleanFalseImage booleanFalseImage Default value is null
    */
    public void setBooleanFalseImage(String booleanFalseImage) {
        setAttribute("booleanFalseImage", booleanFalseImage, true);
    }
    /**
     * Image to display for a false value in a boolean field. Default <code>null</code> value&#010 means no image will be displayed&#010 <P>&#010 To turn this off explicitly set {@link com.smartgwt.client.widgets.grid.ListGridField#getSuppressValueIcon suppressValueIcon} to true&#010 <P>&#010 If this and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} are undefined, this will be set to&#010 {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getUncheckedImage uncheckedImage}.
     *
     *
     * @return String
     *
     */
    public String getBooleanFalseImage()  {
        return getAttributeAsString("booleanFalseImage");
    }

    /**
    * Width for the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage}.&#010 Note: If {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} is unset, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage}&#010 will be used to indicate a true value in a boolean field. In this case this property is&#010 ignored in favor of {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getValueIconWidth valueIconWidth}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param booleanImageWidth booleanImageWidth Default value is 16
    */
    public void setBooleanImageWidth(int booleanImageWidth) {
        setAttribute("booleanImageWidth", booleanImageWidth, true);
    }
    /**
     * Width for the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} and {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage}.&#010 Note: If {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} is unset, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage}&#010 will be used to indicate a true value in a boolean field. In this case this property is&#010 ignored in favor of {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getValueIconWidth valueIconWidth}.
     *
     *
     * @return int
     *
     */
    public int getBooleanImageWidth()  {
        return getAttributeAsInt("booleanImageWidth");
    }

    /**
    * Height for the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} and the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage}&#010 Note: If {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} is unset, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage}&#010 will be used to indicate a true value in a boolean field. In this case this property is&#010 ignored in favor of {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getValueIconHeight valueIconHeight}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param booleanImageHeight booleanImageHeight Default value is 16
    */
    public void setBooleanImageHeight(int booleanImageHeight) {
        setAttribute("booleanImageHeight", booleanImageHeight, true);
    }
    /**
     * Height for the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} and the {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanFalseImage booleanFalseImage}&#010 Note: If {@link com.smartgwt.client.widgets.grid.ListGrid#getBooleanTrueImage booleanTrueImage} is unset, the {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getCheckedImage checkedImage}&#010 will be used to indicate a true value in a boolean field. In this case this property is&#010 ignored in favor of {@link com.smartgwt.client.widgets.form.fields.CheckboxItem#getValueIconHeight valueIconHeight}.
     *
     *
     * @return int
     *
     */
    public int getBooleanImageHeight()  {
        return getAttributeAsInt("booleanImageHeight");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the&#010 title for the menu item to freeze fields on the right of the scrollable body.
    *
    * @param freezeOnRightText freezeOnRightText Default value is "Freeze on right"
    */
    public void setFreezeOnRightText(String freezeOnRightText) {
        setAttribute("freezeOnRightText", freezeOnRightText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the&#010 title for the menu item to freeze fields on the right of the scrollable body.
     *
     *
     * @return String
     *
     */
    public String getFreezeOnRightText()  {
        return getAttributeAsString("freezeOnRightText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the&#010 title for the menu item to freeze fields on the left of the scrollable body.
    *
    * @param freezeOnLeftText freezeOnLeftText Default value is "Freeze on left"
    */
    public void setFreezeOnLeftText(String freezeOnLeftText) {
        setAttribute("freezeOnLeftText", freezeOnLeftText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the&#010 title for the menu item to freeze fields on the left of the scrollable body.
     *
     *
     * @return String
     *
     */
    public String getFreezeOnLeftText()  {
        return getAttributeAsString("freezeOnLeftText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, this&#010 attribute will be shown as the menu item title to sort a field in ascending order.
    *
    * @param sortFieldAscendingText sortFieldAscendingText Default value is "Sort Ascending"
    */
    public void setSortFieldAscendingText(String sortFieldAscendingText) {
        setAttribute("sortFieldAscendingText", sortFieldAscendingText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, this&#010 attribute will be shown as the menu item title to sort a field in ascending order.
     *
     *
     * @return String
     *
     */
    public String getSortFieldAscendingText()  {
        return getAttributeAsString("sortFieldAscendingText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, this&#010 attribute will be shown as the menu item title to sort a field in descending order.
    *
    * @param sortFieldDescendingText sortFieldDescendingText Default value is "Sort Descending"
    */
    public void setSortFieldDescendingText(String sortFieldDescendingText) {
        setAttribute("sortFieldDescendingText", sortFieldDescendingText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, this&#010 attribute will be shown as the menu item title to sort a field in descending order.
     *
     *
     * @return String
     *
     */
    public String getSortFieldDescendingText()  {
        return getAttributeAsString("sortFieldDescendingText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields canPickFields} is true, this&#010 attribute will be shown as the title for the menu item which contains a submenu with items &#010 allowing the user to show and hide fields in the grid.
    *
    * @param fieldVisibilitySubmenuTitle fieldVisibilitySubmenuTitle Default value is "Columns"
    */
    public void setFieldVisibilitySubmenuTitle(String fieldVisibilitySubmenuTitle) {
        setAttribute("fieldVisibilitySubmenuTitle", fieldVisibilitySubmenuTitle, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanPickFields canPickFields} is true, this&#010 attribute will be shown as the title for the menu item which contains a submenu with items &#010 allowing the user to show and hide fields in the grid.
     *
     *
     * @return String
     *
     */
    public String getFieldVisibilitySubmenuTitle()  {
        return getAttributeAsString("fieldVisibilitySubmenuTitle");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the&#010 title for the menu item to freeze a currently unfrozen field.&#010 <P>&#010 This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code&#010 when the message is displayed, with <code>viewer</code> available as a variable mapped to&#010 the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field.&#010 <P>&#010 Default value returns "Freeze " + the field's summary title.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param freezeFieldText freezeFieldText Default value is "Freeze \${viewer.getSummaryTitle(field)}"
    */
    public void setFreezeFieldText(String freezeFieldText) {
        setAttribute("freezeFieldText", freezeFieldText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the&#010 title for the menu item to freeze a currently unfrozen field.&#010 <P>&#010 This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code&#010 when the message is displayed, with <code>viewer</code> available as a variable mapped to&#010 the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field.&#010 <P>&#010 Default value returns "Freeze " + the field's summary title.
     *
     *
     * @return String
     *
     */
    public String getFreezeFieldText()  {
        return getAttributeAsString("freezeFieldText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the&#010 title for the menu item to unfreeze a currently frozen field.&#010 <P>&#010 This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code&#010 when the message is displayed, with <code>viewer</code> available as a variable mapped to&#010 the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field.&#010 <P>&#010 Default value returns "Unfreeze " + the field's summary title.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param unfreezeFieldText unfreezeFieldText Default value is "Unfreeze \${viewer.getSummaryTitle(field)}"
    */
    public void setUnfreezeFieldText(String unfreezeFieldText) {
        setAttribute("unfreezeFieldText", unfreezeFieldText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the&#010 title for the menu item to unfreeze a currently frozen field.&#010 <P>&#010 This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code&#010 when the message is displayed, with <code>viewer</code> available as a variable mapped to&#010 the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field.&#010 <P>&#010 Default value returns "Unfreeze " + the field's summary title.
     *
     *
     * @return String
     *
     */
    public String getUnfreezeFieldText()  {
        return getAttributeAsString("unfreezeFieldText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy canGroupBy} is true, this string will be shown as the&#010 title for the menu item to toggle the group by setting for a field.&#010 <P>&#010 This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code&#010 when the message is displayed, with <code>viewer</code> available as a variable mapped to&#010 the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field.&#010 <P>&#010 Default value returns "Group by " + the field's summary title.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param groupByText groupByText Default value is "Group by \${title}"
    */
    public void setGroupByText(String groupByText) {
        setAttribute("groupByText", groupByText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy canGroupBy} is true, this string will be shown as the&#010 title for the menu item to toggle the group by setting for a field.&#010 <P>&#010 This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code&#010 when the message is displayed, with <code>viewer</code> available as a variable mapped to&#010 the ListGrid instance, and <code>field</code> as a variable pointing to the ListGrid field.&#010 <P>&#010 Default value returns "Group by " + the field's summary title.
     *
     *
     * @return If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy canGroupBy} is true, this string will be shown as the&#010 title for the menu item to toggle the group by setting for a field.<br>&#010 Default implementation evaulates and returns the dynamic {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupByText groupByText}&#010 string.&#010
     *
     */
    public String getGroupByText()  {
        return getAttributeAsString("groupByText");
    }

    /**
    * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getIsGrouped isGrouped} is true, this&#010 attribute will be shown as the title for the menu item to ungroup the grid.
    *
    * @param ungroupText ungroupText Default value is "Ungroup"
    */
    public void setUngroupText(String ungroupText) {
        setAttribute("ungroupText", ungroupText, true);
    }
    /**
     * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid, and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getIsGrouped isGrouped} is true, this&#010 attribute will be shown as the title for the menu item to ungroup the grid.
     *
     *
     * @return String
     *
     */
    public String getUngroupText()  {
        return getAttributeAsString("ungroupText");
    }

    // ********************* Methods ***********************


        /**
         * Uses a "fetch" operation on the current {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource} to &#010 retrieve data that matches the current filter and sort criteria for this component, then &#010 exports the resulting data to a file or window in the requested format.&#010 <P>&#010 For more information on exporting data, see {@link com.smartgwt.client.data.DataSource#exportData}.&#010&#010
         */
        public native void exportData() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.exportData();
        }-*/;

        /**
         * Uses a "fetch" operation on the current {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource} to &#010 retrieve data that matches the current filter and sort criteria for this component, then &#010 exports the resulting data to a file or window in the requested format.&#010 <P>&#010 For more information on exporting data, see {@link com.smartgwt.client.data.DataSource#exportData}.&#010&#010
         * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
         */
        public native void exportData(DSRequest requestProperties) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.exportData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;




        /**
         * Retrieves the current criteria for this component (may be null)&#010
         *
         * @return current filter criteria
         */
        public native Criteria getCriteria() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.getCriteria();
            if(ret == null || ret === undefined) return null;
            return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }-*/;


        /**
         * Invalidate the current data cache for this databound component via a call to&#010 <code>this.data.invalidateCache()</code>. If necessary, this will cause a new fetch to &#010 be performed with the current set of criteria for this component.&#010 <P>&#010 Has no effect if this component is not showing a set of filtered data.&#010 &#010
         */
        public native void invalidateCache() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.invalidateCache();
        }-*/;

        /**
         * Compares the specified criteria with the current criteria applied to this component's&#010 data object and determines whether the new criteria could be satisfied from the currently cached&#010 set of data, or if a new filter/fetch operation will be required.&#010 <P>&#010 This is equivalent to calling <code>this.data.willFetchData(...)</code>.&#010 Always returns true if this component is not showing a set of data from the dataSource. &#010 &#010
         * @param newCriteria new criteria to test.
         *
         * @return true if server fetch would be required to satisfy new criteria.
         */
        public native Boolean willFetchData(Criteria newCriteria) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.willFetchData(newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Compares the specified criteria with the current criteria applied to this component's&#010 data object and determines whether the new criteria could be satisfied from the currently cached&#010 set of data, or if a new filter/fetch operation will be required.&#010 <P>&#010 This is equivalent to calling <code>this.data.willFetchData(...)</code>.&#010 Always returns true if this component is not showing a set of data from the dataSource. &#010 &#010
         * @param newCriteria new criteria to test.
     * @param textMatchStyle New text match style. If not passed assumes       textMatchStyle will not be modified.
         *
         * @return true if server fetch would be required to satisfy new criteria.
         */
        public native Boolean willFetchData(Criteria newCriteria, String textMatchStyle) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.willFetchData(newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), textMatchStyle);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;





        /**
         * Return the first selected record in this component.<br><br>&#010 This method is appropriate if <code>{@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType}</code> is&#010 <code>"single"</code>, or if you only care about the first selected record in&#010 a multiple-record selection. To access all selected records, use&#010 <code>{@link com.smartgwt.client.widgets.grid.ListGrid#getSelection}</code> instead.&#010
         *
         * @return first selected record, or null if nothing selected
         */
        public native ListGridRecord getSelectedRecord() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.getSelectedRecord();
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;





        /**
         * Refresh the styling of an individual cell without redrawing the grid.&#010 <P>&#010 The cell's CSS class and CSS text will be refreshed, to the current values returned by&#010 getCellStyle() and getCellCSSText() respectively.&#010 <P>&#010 The cell's contents (as returned by getCellValue()) will <b>not</b> be refreshed.  To&#010 refresh both styling and contents, call refreshCell() instead.&#010&#010
         * @param rowNum row number of cell to refresh
     * @param colNum column number of cell to refresh
         */
        public native void refreshCellStyle(int rowNum, int colNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.refreshCellStyle(rowNum, colNum);
        }-*/;

        /**
         * Add a cellOver handler.
         * <p>
         * Called when the mouse pointer enters a cell&#010&#010
         *
         * @param handler the cellOver handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addCellOverHandler(com.smartgwt.client.widgets.grid.events.CellOverHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellOverEvent.getType()) == 0) setupCellOverEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellOverEvent.getType());
        }
        private native void setupCellOverEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellOver:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellOver = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a rowOver handler.
         * <p>
         * Called when the mouse pointer enters a row&#010&#010
         *
         * @param handler the rowOver handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addRowOverHandler(com.smartgwt.client.widgets.grid.events.RowOverHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowOverEvent.getType()) == 0) setupRowOverEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowOverEvent.getType());
        }
        private native void setupRowOverEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowOver:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowOver = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowOverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a cellOut handler.
         * <p>
         * Called when the mouse pointer leaves a cell&#010&#010
         *
         * @param handler the cellOut handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addCellOutHandler(com.smartgwt.client.widgets.grid.events.CellOutHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellOutEvent.getType()) == 0) setupCellOutEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellOutEvent.getType());
        }
        private native void setupCellOutEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellOut:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellOut = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a rowOut handler.
         * <p>
         * Called when the mouse pointer leaves a row&#010&#010
         *
         * @param handler the rowOut handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addRowOutHandler(com.smartgwt.client.widgets.grid.events.RowOutHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowOutEvent.getType()) == 0) setupRowOutEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowOutEvent.getType());
        }
        private native void setupRowOutEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowOut:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowOut = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowOutEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a cellHover handler.
         * <p>
         * Called when the mouse hovers over a cell if this.canHover is true. &#010  Returning false will suppress the hover text from being shown if this.showHover is true.&#010&#010
         *
         * @param handler the cellHover handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addCellHoverHandler(com.smartgwt.client.widgets.grid.events.CellHoverHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellHoverEvent.getType()) == 0) setupCellHoverEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellHoverEvent.getType());
        }
        private native void setupCellHoverEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellHover:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellHover = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a rowHover handler.
         * <p>
         * Called when the mouse hovers over a row if this.canHover is true. &#010  Returning false will suppress the hover text from being shown if this.showHover is true.&#010&#010
         *
         * @param handler the rowHover handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addRowHoverHandler(com.smartgwt.client.widgets.grid.events.RowHoverHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowHoverEvent.getType()) == 0) setupRowHoverEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowHoverEvent.getType());
        }
        private native void setupRowHoverEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowHover:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowHover = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;


        /**
         * Add a cellContextClick handler.
         * <p>
         * Called when a cell receives a contextclick event.&#010&#010
         *
         * @param handler the cellContextClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addCellContextClickHandler(com.smartgwt.client.widgets.grid.events.CellContextClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellContextClickEvent.getType()) == 0) setupCellContextClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellContextClickEvent.getType());
        }
        private native void setupCellContextClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellContextClick:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellContextClick = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a rowContextClick handler.
         * <p>
         * Called when a row receives a contextclick event.&#010
         *
         * @param handler the rowContextClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addRowContextClickHandler(com.smartgwt.client.widgets.grid.events.RowContextClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowContextClickEvent.getType()) == 0) setupRowContextClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowContextClickEvent.getType());
        }
        private native void setupRowContextClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowContextClick:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowContextClick = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowContextClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a cellMouseDown handler.
         * <p>
         * Called when a cell receives a mousedown event.&#010 &#010
         *
         * @param handler the cellMouseDown handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addCellMouseDownHandler(com.smartgwt.client.widgets.grid.events.CellMouseDownHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellMouseDownEvent.getType()) == 0) setupCellMouseDownEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellMouseDownEvent.getType());
        }
        private native void setupCellMouseDownEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellMouseDown:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellMouseDown = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a rowMouseDown handler.
         * <p>
         * Called when a row receives a mousedown event.&#010 &#010
         *
         * @param handler the rowMouseDown handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addRowMouseDownHandler(com.smartgwt.client.widgets.grid.events.RowMouseDownHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowMouseDownEvent.getType()) == 0) setupRowMouseDownEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowMouseDownEvent.getType());
        }
        private native void setupRowMouseDownEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowMouseDown:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowMouseDown = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowMouseDownEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a cellMouseUp handler.
         * <p>
         * Called when a cell receives a mouseup event.&#010&#010
         *
         * @param handler the cellMouseUp handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addCellMouseUpHandler(com.smartgwt.client.widgets.grid.events.CellMouseUpHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellMouseUpEvent.getType()) == 0) setupCellMouseUpEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellMouseUpEvent.getType());
        }
        private native void setupCellMouseUpEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellMouseUp:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellMouseUp = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a rowMouseUp handler.
         * <p>
         * Called when a row receives a mouseup event.&#010&#010
         *
         * @param handler the rowMouseUp handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addRowMouseUpHandler(com.smartgwt.client.widgets.grid.events.RowMouseUpHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowMouseUpEvent.getType()) == 0) setupRowMouseUpEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowMouseUpEvent.getType());
        }
        private native void setupRowMouseUpEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowMouseUp:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowMouseUp = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowMouseUpEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a cellClick handler.
         * <p>
         * Called when a cell receives a click event.&#010&#010
         *
         * @param handler the cellClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addCellClickHandler(com.smartgwt.client.widgets.grid.events.CellClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellClickEvent.getType()) == 0) setupCellClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellClickEvent.getType());
        }
        private native void setupCellClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellClick:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellClick = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a cellDoubleClick handler.
         * <p>
         * Called when a cell receives a double click event.&#010&#010
         *
         * @param handler the cellDoubleClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addCellDoubleClickHandler(com.smartgwt.client.widgets.grid.events.CellDoubleClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent.getType()) == 0) setupCellDoubleClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent.getType());
        }
        private native void setupCellDoubleClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellDoubleClick:function(){
                        var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellDoubleClick = function(){
                    var param = {"record" : arguments[0], "rowNum" : arguments[1], "colNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;






















        /**
         * If the filter editor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}) is visible for this grid, &#010 this method will explictly put focus into the specified field in the filter editor.&#010
         */
        public native void focusInFilterEditor() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.focusInFilterEditor();
        }-*/;

        /**
         * If the filter editor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}) is visible for this grid, &#010 this method will explictly put focus into the specified field in the filter editor.&#010
         * @param fieldName Name of the field to put focus into. If unspecified focus will go                             to the first field in the editor
         */
        public native void focusInFilterEditor(String fieldName) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.focusInFilterEditor(fieldName);
        }-*/;

        /**
         * If the filter editor ({@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor}) is visible for this grid, &#010 this method will perform a filter based on the current values in the editor.&#010
         */
        public native void filterByEditor() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.filterByEditor();
        }-*/;

        /**
         * Returns a snapshot of the current presentation of this listGrid's fields as &#010 a {@link com.smartgwt.client..listGridFieldState} object.&#010 <P>&#010 This object can later be passed to {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldState} to reset this grid's&#010 fields to the current state.&#010 <P>&#010 Note that the information stored includes the current width and visibility of each of this &#010 grid's fields, as well as any {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAddFormulaFields canAddFormulaFields} or&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAddSummaryFields canAddSummaryFields} added by the user.&#010&#010
         *
         * @return current state of this grid's fields.
         */
        public native String getFieldState() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getFieldState();
        }-*/;

        /**
         * Sets some presentation properties (visibility, width, userFormula and userSummary) of the &#010 listGrid fields based on the {@link com.smartgwt.client..listGridFieldState} object passed in.<br>&#010 Used to restore previous state retrieved from the grid by a call to {@link com.smartgwt.client.widgets.grid.ListGrid#getFieldState}.&#010&#010
         * @param fieldState state to apply to the listGrid's fields.
         */
        public native void setFieldState(String fieldState) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setFieldState(fieldState);
        }-*/;

        /**
         * Identifies whether the passed-in field is the specially generated&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCheckboxField checkboxField} used when {@link com.smartgwt.client.types.SelectionAppearance} is&#010 "checkbox".  Use this method in your custom event handlers to avoid inappropriately&#010 performing actions when the checkboxField is clicked on.&#010 &#010
         * @param field field to test
         *
         * @return whether the provided field is the checkbox field
         */
        public native Boolean isCheckboxField(ListGridField field) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.isCheckboxField(field.@com.smartgwt.client.core.DataClass::getJsObj()());
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;







        /**
         * Re-evaluates {@link com.smartgwt.client.widgets.grid.ListGridField#showIf} for each field, dynamically showing and &#010 hiding the appropriate set of fields&#010
         */
        public native void refreshFields() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.refreshFields();
        }-*/;



















        /**
         * Get the row that currently has keyboard focus.  Arrow key navigation moves relative to this&#010 row.&#010 &#010
         *
         * @return rowNum of the current focus row
         */
        public native int getFocusRow() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getFocusRow();
        }-*/;

        /**
         * Add a recordClick handler.
         * <p>
         * Executed when the listGrid receives a 'click' event on an enabled, non-separator&#010 record. The default implementation does nothing -- override to perform some action&#010 when any record or field is clicked.<br>&#010 A record event handler can be specified either as&#010 a function to execute, or as a string of script to evaluate. If the handler is defined&#010 as a string of script, all the parameters below will be available as variables for use&#010 in the script.<br>&#010 To do something specific if a particular field is clicked, add a recordClick&#010 method or string of script to that field (same parameters) when you're setting up&#010 the list.<br>&#010 <b>Notes:</b><ul>&#010  <li>This will not be called if the click is below the last item of the list.</li>&#010  <li>This method is called from the default implementaiton of&#010  {@link com.smartgwt.client.widgets.grid.ListGrid#rowClick}, so if that method is overridden&#010  this method may not be fired.</li></ul>&#010
         *
         * @param handler the recordClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addRecordClickHandler(com.smartgwt.client.widgets.grid.events.RecordClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordClickEvent.getType()) == 0) setupRecordClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RecordClickEvent.getType());
        }
        private native void setupRecordClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({recordClick:function(){
                        var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                        var event = @com.smartgwt.client.widgets.grid.events.RecordClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.recordClick = function(){
                    var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                    var event = @com.smartgwt.client.widgets.grid.events.RecordClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Add a recordDoubleClick handler.
         * <p>
         * Executed when the listGrid receives a 'doubleClick' event on an enabled, non-separator&#010 record. The default implementation does nothing -- override to perform&#010 some action when any record or field is double clicked.<br>&#010 A record event handler can be specified either as a function to execute, or as a string&#010 of script to evaluate. If the handler is defined as a string of script, all the&#010 parameters below will be available as variables for use in the script.<br>&#010 To do something specific if a particular field is double clicked, add a&#010 recordDoubleClick method or string of script to that field (same parameters) when you're&#010 setting up the list.<br>&#010 <b>Notes:</b><ul>&#010 <li>This will not be called if the click is below the last item of the list.</li>&#010 <li>This method is called from the default implementation of {@link com.smartgwt.client.widgets.grid.ListGrid#rowDoubleClick},&#010 so if that method is overridden this method may not be fired.</li></ul>&#010
         *
         * @param handler the recordDoubleClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addRecordDoubleClickHandler(com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent.getType()) == 0) setupRecordDoubleClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent.getType());
        }
        private native void setupRecordDoubleClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({recordDoubleClick:function(){
                        var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                        var event = @com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.recordDoubleClick = function(){
                    var param = {"viewer" : arguments[0], "record" : arguments[1], "recordNum" : arguments[2], "field" : arguments[3], "fieldNum" : arguments[4], "value" : arguments[5], "rawValue" : arguments[6]};
                    var event = @com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;







        /**
         * Start inline editing at the provided coordinates.&#010 <p>&#010 Invoked when a cell is editable and the <code>editEvent</code> occurs on that cell.  Can&#010 also be invoked explicitly.&#010 <P>&#010 If this method is called while editing is already in progress, the value from the current&#010 editCell will either be stored locally as a temporary edit value, or saved via 'saveEdits()'&#010 depending on <code>this.saveByCell</code>, and the position of the new edit cell.<br>&#010 Will update the UI to show the editor for the new cell, and put focus in it unless &#010 explicitly suppressed by the optional <code>suppressFocus</code> parameter.&#010&#010
         *
         * @return true if we are editing the cell, false if not editing for some reason
         */
        public native Boolean startEditing() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.startEditing();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Start inline editing at the provided coordinates.&#010 <p>&#010 Invoked when a cell is editable and the <code>editEvent</code> occurs on that cell.  Can&#010 also be invoked explicitly.&#010 <P>&#010 If this method is called while editing is already in progress, the value from the current&#010 editCell will either be stored locally as a temporary edit value, or saved via 'saveEdits()'&#010 depending on <code>this.saveByCell</code>, and the position of the new edit cell.<br>&#010 Will update the UI to show the editor for the new cell, and put focus in it unless &#010 explicitly suppressed by the optional <code>suppressFocus</code> parameter.&#010&#010
         * @param rowNum Row number of the cell to edit.  Defaults to first                                  editable row
     * @param colNum Column number of the cell to edit.  Defaults to first                                  editable column
     * @param suppressFocus If passed this parameter suppresses the default                                   behavior of focussing in the edit form item when &#010                                  the editor is shown.
         *
         * @return true if we are editing the cell, false if not editing for some reason
         */
        public native Boolean startEditing(int rowNum, int colNum, boolean suppressFocus) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.startEditing(rowNum, colNum, suppressFocus);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Notification that the user is no longer hovering over some cell. Hides the current hover canvas&#010 if one is showing. &#010
         */
        public native void stopHover() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.stopHover();
        }-*/;





        /**
         * Refresh an individual cell without redrawing the grid.&#010 <P>&#010 The cell's value, CSS class, and CSS text will be refreshed, to the current values returned&#010 by getCellValue(), getCellStyle() and getCellCSSText() respectively.&#010&#010
         * @param rowNum row number of cell to refresh
     * @param colNum column number of cell to refresh
         */
        public native void refreshCell(int rowNum, int colNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.refreshCell(rowNum, colNum);
        }-*/;

        /**
         * Refresh an entire row of cells without redrawing the grid.&#010 <P>&#010 The cells' values, CSS classes, and CSS text will be refreshed, to the current values&#010 returned by getCellValue(), getCellStyle() and getCellCSSText() respectively.&#010&#010
         * @param rowNum row number of cell to refresh
         */
        public native void refreshRow(int rowNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.refreshRow(rowNum);
        }-*/;













        /**
         * &#010  Cancel the current edit without saving.&#010&#010
         */
        public native void cancelEditing() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.cancelEditing();
        }-*/;

        /**
         * &#010 Complete the current edit by storing the value and hiding the inline editor. Note that&#010 if {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} is true, the value will be saved to the server. &#010&#010
         */
        public native void endEditing() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.endEditing();
        }-*/;


        /**
         * &#010 Cancel outstanding edits for the specified rows, discarding edit values, and hiding editors &#010 if appropriate.<br>&#010 Note that if this method is called on a new edit row (created via &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#startEditingNew} for example), which has not yet been saved, this method&#010 will remove the row entirely.&#010 &#010
         * @param rowNum Row to cancel
     * @param colNum Column to cancel. Note that this parameter is ignored in ListGrids but                        may be required in subclasses of ListGrid where each cell represents&#010                        one record in the data set (EG CubeGrid)
         */
        public native void discardEdits(int rowNum, int colNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.discardEdits(rowNum, colNum);
        }-*/;

        /**
         * &#010 Cancel outstanding edits for the specified rows, discarding edit values, and hiding editors &#010 if appropriate.<br>&#010 Note that if this method is called on a new edit row (created via &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#startEditingNew} for example), which has not yet been saved, this method&#010 will remove the row entirely.&#010 &#010
         * @param rowNum Row to cancel
     * @param colNum Column to cancel. Note that this parameter is ignored in ListGrids but                        may be required in subclasses of ListGrid where each cell represents&#010                        one record in the data set (EG CubeGrid)
     * @param dontHideEditor By default this method will hide the editor if                              it is currently showing for the row in question. Passing in&#010                              this parameter will leave the editor visible (and just reset&#010                              the edit values underneath the editor).
         */
        public native void discardEdits(int rowNum, int colNum, boolean dontHideEditor) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.discardEdits(rowNum, colNum, dontHideEditor);
        }-*/;


        /**
         * If this listGrid can be edited, this method will return true if the row passed in has been&#010 edited, but the edits have not yet been saved to the ListGrid's data object.&#010
         * @param rowNum index of row to check for changes
         *
         * @return true if the row has changes.
         */
        public native Boolean rowHasChanges(int rowNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.rowHasChanges(rowNum);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Whether the grid as a whole has any unsaved edits, in any row.&#010
         *
         * @return returns true of any unsaved edits are present
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
         * If this listGrid can be edited, this method will return true if the cell passed in has been&#010 edited, but the edits have not yet been saved to the ListGrid's data object.&#010
         * @param rowNum index of row to check for changes
     * @param colNum index of the col to check for changes
         *
         * @return returns true if the cell has unsaved edits
         */
        public native Boolean cellHasChanges(int rowNum, int colNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.cellHasChanges(rowNum, colNum);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;


        /**
         * Validate the current set of edit values for the row in question.&#010 <P>&#010 Called when the user moves to a new edit row, or when an edited record is to be saved if&#010 client side validation is enabled for this grid.&#010 <P>&#010 This method may also be called directly to perform row level validation at any time.&#010&#010
         * @param rowNum index of row to be validated.
         *
         * @return returns true if validation was successful (no errors encountered), false                    otherwise.
         */
        public native Boolean validateRow(int rowNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.validateRow(rowNum);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;



        /**
         * Does this grid currently have errors associated with editValues for any row in the grid.&#010
         *
         * @return true if there are unresolved errors, false otherwise
         */
        public native Boolean hasErrors() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.hasErrors();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;

        /**
         * Does the specified row have unresolved errors?&#010
         * @param rowNum rowNum to check for errors
         *
         * @return true if there are unresolved errors, false otherwise
         */
        public native Boolean rowHasErrors(int rowNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.rowHasErrors(rowNum);
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;







        /**
         * Clear any stored validation errors for some row&#010
         * @param rowNum index of row to clear validation error for
         */
        public native void clearRowErrors(int rowNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.clearRowErrors(rowNum);
        }-*/;




        /**
         * Return "title" HTML to display as a drag tracker when the user drags some record.<br>&#010 Default implementation will display the cell value for the title field (see &#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getTitleField}) for the record(s) being dragged (including any&#010 icons / custom formatting / styling, etc).&#010 <p>&#010 Note: Only called if {@link com.smartgwt.client.widgets.grid.ListGrid#getDragTrackerMode dragTrackerMode} is set to <code>"title"</code>.&#010
         * @param record First selected record being dragged
     * @param rowNum row index of first record being dragged
         *
         * @return Title for the row. Default implementation looks at the value of the                  title-field cell for the row.
         */
        public native String getDragTrackerTitle(ListGridRecord record, int rowNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getDragTrackerTitle(record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum);
        }-*/;

        /**
         * &#010 This method overrides {@link com.smartgwt.client.widgets.Canvas#willAcceptDrop} and works as follows:<br>&#010 <ul>&#010 <li>If {@link com.smartgwt.client.widgets.Canvas#willAcceptDrop} (the superclass definition) returns false, this &#010     method always returns false.  This allows {@link com.smartgwt.client.widgets.Canvas#getDragType dragType} and&#010     {@link com.smartgwt.client.widgets.Canvas#getDropTypes dropTypes} to be used to configure eligibility for drop.  By default,&#010     a ListGrid has no dropTypes configured and so this check will not prevent a drop.</li>&#010 <li>If this is a self-drop, that is, the user is dragging a record within this list, this is&#010     an attempted drag-reorder.  If {@link com.smartgwt.client.widgets.grid.ListGrid#getCanReorderRecords canReorderRecords} is &#010     false, this method returns false.</li>&#010 <li>If the {@link com.smartgwt.client.util.EventHandler#getDragTarget} is another widget, if&#010     {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAcceptDroppedRecords canAcceptDroppedRecords} is false this method returns false.</li>&#010 <li>If a call to {@link com.smartgwt.client.widgets.grid.ListGrid#getDragData} on the <code>dragTarget</code> fails to return&#010     an record object or an array of records, this method returns false.</li> &#010 <li>If a the drop target record is disabled or has {@link com.smartgwt.client.widgets.grid.ListGridRecord#getCanAcceptDrop canAcceptDrop} &#010     set to false, return false.</li>&#010 </ul>&#010 Note that this method may be called repeatedly during a drag-drop interaction to update the&#010 UI and notify the user as to when they may validly drop data.&#010&#010
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
         * Return the pointer to a particular record by record number.&#010 Synonym for {@link com.smartgwt.client.widgets.grid.ListGrid#getCellRecord}.&#010&#010
         * @param recordNum row index of record to return.
         *
         * @return Record object for the row.
         */
        public native ListGridRecord getRecord(int recordNum) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var ret = self.getRecord(recordNum);
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;









        /**
         * Get the index of the provided record.&#010 <P>&#010 This is essentially the same as calling listGrid.data.indexOf(record), except that &#010 the currently visible range of records is checked first.  This is important for&#010 responsiveness in functions that respond to user actions when the user is working near the&#010 end of a very large dataset (eg 500k records).&#010&#010
         * @param record the record whose index is to be retrieved
         *
         * @return indexindex of the record, or -1 if not found
         */
        public native int getRecordIndex(ListGridRecord record) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getRecordIndex(record.@com.smartgwt.client.core.DataClass::getJsObj()());
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
         * Returns the column number of the most recent mouse event.&#010
         *
         * @return column number, or -2 if beyond last drawn column
         */
        public native int getEventColumn() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getEventColumn();
        }-*/;

        /**
         * Returns the column number of the most recent mouse event.&#010
         * @param x optional x-coordinate to obtain column number for, in lieue of the x                        coordinate of the last mouse event
         *
         * @return column number, or -2 if beyond last drawn column
         */
        public native int getEventColumn(int x) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getEventColumn(x);
        }-*/;


        /**
         * Add a selectionChanged handler.
         * <p>
         * Called when (row-based) selection changes within this grid. Note this method fires for&#010 each record for which selection is modified - so when a user clicks inside a grid this&#010 method will typically fire twice (once for the old record being deselected, and once for&#010 the new record being selected).&#010&#010
         *
         * @param handler the selectionChanged handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addSelectionChangedHandler(com.smartgwt.client.widgets.grid.events.SelectionChangedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.SelectionEvent.getType()) == 0) setupSelectionChangedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.SelectionEvent.getType());
        }
        private native void setupSelectionChangedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({selectionChanged:function(){
                        var param = {"record" : arguments[0], "state" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.grid.events.SelectionEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.selectionChanged = function(){
                    var param = {"record" : arguments[0], "state" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.grid.events.SelectionEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;








        /**
         * Reorder a particular field &#010&#010
         * @param fieldNum Number of the field to reorder
     * @param moveToPosition New position for that field
         */
        public native void reorderField(int fieldNum, int moveToPosition) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.reorderField(fieldNum, moveToPosition);
        }-*/;

        /**
         * Reorder a set of adjacent fields, from start to end exclusive at the end, by distance&#010 moveDelta.<br><br>&#010&#010 NOTE: start and end coordinates are in terms of the currently visible fields, not the full set of&#010 fields.&#010&#010
         * @param start Start of the range of fields to move, inclusive
     * @param end End of the range of fields to move, non-inclusive
     * @param moveDelta Distance to move by
         */
        public native void reorderFields(int start, int end, int moveDelta) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.reorderFields(start, end, moveDelta);
        }-*/;


        /**
         * Resize a particular field to a new width.&#010&#010
         * @param fieldNum Number of the field to resize
     * @param newWidth New width of the field
         */
        public native void resizeField(int fieldNum, int newWidth) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.resizeField(fieldNum, newWidth);
        }-*/;


        /**
         * If we're showing a {@link com.smartgwt.client.widgets.grid.ListGrid#getShowHeaderContextMenu showHeaderContextMenu} for this grid and&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getCanFreezeFields canFreezeFields} is true, this string will be shown as the&#010 title for the menu item to toggle whether a field is frozen or unfrozen.&#010 <P>&#010 Default implementation evaluates and returns {@link com.smartgwt.client.widgets.grid.ListGrid#getFreezeFieldText freezeFieldText} or&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getUnfreezeFieldText unfreezeFieldText} depending on whether the field is currently frozen.&#010
         * @param field field to get the menu item title for
         *
         * @return Title to show in the menu item
         */
        public native String getToggleFreezeText(ListGridField field) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getToggleFreezeText(field.@com.smartgwt.client.core.DataClass::getJsObj()());
        }-*/;




        /**
         * Turn sorting off, typically because data has changed and is no longer sorted.&#010 <p>&#010 Calling <code>unsort()</code> disables visual indication of which column is the sort column,&#010 and calls <code>unsort()</code> on the underlying dataset.&#010 <P>&#010 Note that a grid viewing a paged dataset may not be able to support <code>unsort()</code>&#010 because the sort order is what establishes the row numbering that allows data to be&#010 fetched in batches.&#010 <P>&#010 <code>unsort()</code> is automatically called when records are dropped or value of the&#010 sorted column is changed.&#010&#010
         */
        public native void unsort() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.unsort();
        }-*/;







        /**
         * Removes the grouping from the listgrid, restoring its original data&#010&#010
         */
        public native void ungroup() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.ungroup();
        }-*/;


        /**
         * Update the title of a {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} dynamically.&#010&#010
         * @param name name of the headerSpan, as specified via {@link com.smartgwt.client.widgets.grid.HeaderSpan#getName name}.
     * @param newTitle new title for the headerSpan
         */
        public native void setHeaderSpanTitle(String name, String newTitle) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setHeaderSpanTitle(name, newTitle);
        }-*/;

        /**
         * Add a cellSaved handler.
         * <p>
         * Fires after user edits have been successfully saved to the server, when the new value&#010 doesn't match the value before editing.&#010 <p>&#010 If you want immediate notification of a changes <b>before</b> changes has been saved to the&#010 server, implement {@link com.smartgwt.client.widgets.grid.ListGridField#change} or&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#changed} instead.&#010 <P>&#010 You can supply this method on the listGrid instance or on the listGridField(s) that you&#010 want to receive cellChanged events for.  If both a field and the listGrid define a&#010 cellChanged method and that field receives an edit save, only the one defined on the&#010 field is called.&#010&#010
         *
         * @param handler the cellSaved handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addCellSavedHandler(com.smartgwt.client.widgets.grid.events.CellSavedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.CellSavedEvent.getType()) == 0) setupCellSavedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.CellSavedEvent.getType());
        }
        private native void setupCellSavedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({cellChanged:function(){
                        var param = {"record" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4], "grid" : arguments[5]};
                        var event = @com.smartgwt.client.widgets.grid.events.CellSavedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.cellChanged = function(){
                    var param = {"record" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4], "grid" : arguments[5]};
                    var event = @com.smartgwt.client.widgets.grid.events.CellSavedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Add a editComplete handler.
         * <p>
         * Callback fired when inline edits have been successfully saved.&#010 <P>&#010 No default implementation.&#010&#010
         *
         * @param handler the editComplete handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addEditCompleteHandler(com.smartgwt.client.widgets.grid.events.EditCompleteHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.EditCompleteEvent.getType()) == 0) setupEditCompleteEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.EditCompleteEvent.getType());
        }
        private native void setupEditCompleteEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({editComplete:function(){
                        var param = {"rowNum" : arguments[0], "colNum" : arguments[1], "newValues" : arguments[2], "oldValues" : arguments[3], "editCompletionEvent" : arguments[4], "dsResponse" : arguments[5]};
                        var event = @com.smartgwt.client.widgets.grid.events.EditCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.editComplete = function(){
                    var param = {"rowNum" : arguments[0], "colNum" : arguments[1], "newValues" : arguments[2], "oldValues" : arguments[3], "editCompletionEvent" : arguments[4], "dsResponse" : arguments[5]};
                    var event = @com.smartgwt.client.widgets.grid.events.EditCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Add a editFailed handler.
         * <p>
         * Called when an attempt to save inline edits fails, due to a validation error or other&#010 server error.&#010 <P>&#010 The default implementation of editFailed does nothing for normal validation errors,&#010 which are displayed before editFailed() is called.  For any other errors, the default&#010 implementation will call {@link com.smartgwt.client.rpc.RPCManager#handleError}, which by default&#010 will result in a warning dialog.&#010&#010
         *
         * @param handler the editFailed handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addEditFailedHandler(com.smartgwt.client.widgets.grid.events.EditFailedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.EditFailedEvent.getType()) == 0) setupEditFailedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.EditFailedEvent.getType());
        }
        private native void setupEditFailedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({editFailed:function(){
                        var param = {"rowNum" : arguments[0], "colNum" : arguments[1], "newValues" : arguments[2], "oldValues" : arguments[3], "editCompletionEvent" : arguments[4], "dsResponse" : arguments[5]};
                        var event = @com.smartgwt.client.widgets.grid.events.EditFailedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.editFailed = function(){
                    var param = {"rowNum" : arguments[0], "colNum" : arguments[1], "newValues" : arguments[2], "oldValues" : arguments[3], "editCompletionEvent" : arguments[4], "dsResponse" : arguments[5]};
                    var event = @com.smartgwt.client.widgets.grid.events.EditFailedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Add a editorEnter handler.
         * <p>
         * Callback fired when the user starts editing a new cell.&#010 <P>&#010 This callback is typically used to establish dynamic default values via&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValue} or {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValues}.&#010 <P>&#010 Can also be overriden on a per-field basis via&#010 {@link com.smartgwt.client.widgets.grid.ListGridField#editorEnter}.&#010&#010
         *
         * @param handler the editorEnter handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addEditorEnterHandler(com.smartgwt.client.widgets.grid.events.EditorEnterHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.EditorEnterEvent.getType()) == 0) setupEditorEnterEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.EditorEnterEvent.getType());
        }
        private native void setupEditorEnterEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({editorEnter:function(){
                        var param = {"record" : arguments[0], "value" : arguments[1], "rowNum" : arguments[2], "colNum" : arguments[3]};
                        var event = @com.smartgwt.client.widgets.grid.events.EditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.editorEnter = function(){
                    var param = {"record" : arguments[0], "value" : arguments[1], "rowNum" : arguments[2], "colNum" : arguments[3]};
                    var event = @com.smartgwt.client.widgets.grid.events.EditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Add a rowEditorEnter handler.
         * <p>
         * Callback fired when the user starts editing a new row.&#010&#010
         *
         * @param handler the rowEditorEnter handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addRowEditorEnterHandler(com.smartgwt.client.widgets.grid.events.RowEditorEnterHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowEditorEnterEvent.getType()) == 0) setupRowEditorEnterEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowEditorEnterEvent.getType());
        }
        private native void setupRowEditorEnterEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowEditorEnter:function(){
                        var param = {"record" : arguments[0], "editValues" : arguments[1], "rowNum" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowEditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowEditorEnter = function(){
                    var param = {"record" : arguments[0], "editValues" : arguments[1], "rowNum" : arguments[2]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowEditorEnterEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Add a editorExit handler.
         * <p>
         * Callback fired when the user attempts to navigate away from the current edit cell, &#010 or complete the current edit.&#010 <P>&#010 Return false from this method to cancel the default behavior (Saving / cancelling the&#010 current edit / moving to the next edit cell).&#010 <P>&#010 This callback is typically used to dynamically update values or value maps for related&#010 fields (via {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValue} and {@link com.smartgwt.client.widgets.grid.ListGrid#setEditorValueMap} respectively, or to&#010 implement custom navigation (via {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing}.&#010 <P>&#010 Can be overriden at the field level as field.editorExit.&#010&#010
         *
         * @param handler the editorExit handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addEditorExitHandler(com.smartgwt.client.widgets.grid.events.EditorExitHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.EditorExitEvent.getType()) == 0) setupEditorExitEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.EditorExitEvent.getType());
        }
        private native void setupEditorExitEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({editorExit:function(){
                        var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                        var event = @com.smartgwt.client.widgets.grid.events.EditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.editorExit = function(){
                    var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValue" : arguments[2], "rowNum" : arguments[3], "colNum" : arguments[4]};
                    var event = @com.smartgwt.client.widgets.grid.events.EditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Add a rowEditorExit handler.
         * <p>
         * Callback fired when the user attempts to navigate away from the current edit row, &#010 or complete the current edit.&#010 <P>&#010 Return false from this method to cancel the default behavior (Saving / cancelling the&#010 current edit / moving to the next edit cell).&#010&#010
         *
         * @param handler the rowEditorExit handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addRowEditorExitHandler(com.smartgwt.client.widgets.grid.events.RowEditorExitHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RowEditorExitEvent.getType()) == 0) setupRowEditorExitEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RowEditorExitEvent.getType());
        }
        private native void setupRowEditorExitEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({rowEditorExit:function(){
                        var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValues" : arguments[2], "rowNum" : arguments[3]};
                        var event = @com.smartgwt.client.widgets.grid.events.RowEditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.rowEditorExit = function(){
                    var param = {"editCompletionEvent" : arguments[0], "record" : arguments[1], "newValues" : arguments[2], "rowNum" : arguments[3]};
                    var event = @com.smartgwt.client.widgets.grid.events.RowEditorExitEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;




        /**
         * Add a fieldStateChanged handler.
         * <p>
         * Notification method executed when columns are resized or reordered, or fields are &#010 shown or hidden. Has no default implementation.&#010&#010
         *
         * @param handler the fieldStateChanged handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addFieldStateChangedHandler(com.smartgwt.client.widgets.grid.events.FieldStateChangedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.FieldStateChangedEvent.getType()) == 0) setupFieldStateChangedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.FieldStateChangedEvent.getType());
        }
        private native void setupFieldStateChangedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({fieldStateChanged:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.grid.events.FieldStateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.fieldStateChanged = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.grid.events.FieldStateChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

        /**
         * Add a dataArrived handler.
         * <p>
         * Notification method fired when new data arrives from the server to be displayed in this&#010 ListGrid, (for example in response to the user scrolling a new set of rows into view).&#010 Only applies to databound listGrids where the {@link com.smartgwt.client.widgets.grid.ListGrid#getData data} attribute is a&#010 {@link com.smartgwt.client.data.ResultSet}. This ResultSet may have been created manually and applied to the grid via&#010 a call to {@link com.smartgwt.client.widgets.grid.ListGrid#setData} or may have been created and automatically assigned if&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} was used to populate the grid.  This method is fired directly in&#010 response to {@link com.smartgwt.client.data.ResultSet#dataArrived} firing on the data object.&#010
         *
         * @param handler the dataArrived handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addDataArrivedHandler(com.smartgwt.client.widgets.grid.events.DataArrivedHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.grid.events.DataArrivedEvent.getType()) == 0) setupDataArrivedEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.DataArrivedEvent.getType());
        }
        private native void setupDataArrivedEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({dataArrived:function(){
                        var param = {"startRow" : arguments[0], "endRow" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.grid.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.dataArrived = function(){
                    var param = {"startRow" : arguments[0], "endRow" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.grid.events.DataArrivedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

    // ********************* Static Methods ***********************






    protected native void onInit() /*-{

        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self._getCellCSSText = self.getCellCSSText;
        self.getCellCSSText = function(record, rowNum, colNum) {
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return jObj.@com.smartgwt.client.widgets.grid.ListGrid::getCellCSSText(Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(recordJ, rowNum, colNum);
        };

        self._getBaseStyle = self.getBaseStyle;
        self.getBaseStyle = function(record, rowNum, colNum) {
            var jObj = this.__ref;
            var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return jObj.@com.smartgwt.client.widgets.grid.ListGrid::getBaseStyle(Lcom/smartgwt/client/widgets/grid/ListGridRecord;II)(recordJ, rowNum, colNum);
        };

        self.__getHeaderContextMenuItems = self.getHeaderContextMenuItems;
        self.getHeaderContextMenuItems = function(fieldNum) {
            var jObj = this.__ref;
            var fieldNumJ = fieldNum == null ? null : @com.smartgwt.client.util.JSOHelper::toInteger(I)(fieldNum);
            var menuItemsJ = jObj.@com.smartgwt.client.widgets.grid.ListGrid::getHeaderContextMenuItems(Ljava/lang/Integer;)(fieldNumJ);
            var menuItemsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(menuItemsJ);
            return menuItemsJS;
        };

        self._canEditCell = self.canEditCell;
        self.canEditCell = function(rowNum, colNum) {
            var jObj = this.__ref;
            return jObj.@com.smartgwt.client.widgets.grid.ListGrid::canEditCell(II)(rowNum, colNum);
        };
    }-*/;


    /**
     * Return CSS text for styling this cell, which will be applied in addition to the CSS class for the cell, as
     * overrides. <p> "CSS text" means semicolon-separated style settings, suitable for inclusion in a CSS stylesheet or
     * in a STYLE attribute of an HTML element.
     * <br><b>Note: This is an override point</b>
     *
     *
     * @param record cell record as returned by getCellRecord
     * @param rowNum row number for the cell
     * @param colNum column number of the cell
     * @return CSS text for this cell
     */
    protected native String getCellCSSText(ListGridRecord record, int rowNum, int colNum) /*-{

        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._getCellCSSText(record == null ? null : record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum, colNum);
    }-*/;

    /**
     * Can this cell be edited? <P> The default implementation of <code>canEditCell()</code> respects the various property settings affecting
     * editability: {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEdit canEdit} disables editing for a field,
     * a record with the {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordEditProperty recordEditProperty} set to false is not editable,
     * and disabled records are not editable. <P> You can override this method to control editability on a cell-by-cell basis.
     * In order to allow complete control over editing, <code>canEditCell()</code> is called very frequently.  If you see delays on row to row navigation,
     * check that your implementation is efficient <li> If you change the editability of a cell on the fly, for example, during
     * {@link com.smartgwt.client.widgets.grid.ListGrid#editorExit} on another cell, call refreshCell() to show or hide the editor <li>
     * If this ListGrid allows new records to be created, <code>canEditCell()</code> may be called when there is no record available.
     * The values input so far by the user are available via {@link com.smartgwt.client.widgets.grid.ListGrid#getEditValues}.  </ul>
     *
     * <p><b>Note: This is an override point</b>
     *
     * @param rowNum row number for the cell
     * @param colNum column number of the cell
     *
     * @return Whether to allow editing this cell
     */
    protected native boolean canEditCell(int rowNum, int colNum) /*-{

        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._canEditCell(rowNum, colNum);
    }-*/;

    /**
     * If ListGrid.showHeaderContextMenu is true this method returns the menu items to be displayed in the default header context menu.
     * <br>
     * This method will be called each time the menu is displayed, allowing for dynamic content depending on the current state of the fields.
     * <br>
     * The default set of menu items will includes menu items for freezing fields, showing and hiding fields, grouping by fields, or other listGrid features
     * <br><b>Note: This is an override point</b>
     *
     * @param fieldNum index of the field the user clicked in the fields array. Note: if the user right-clicked the sorter button this parameter will be null.
     * @return Array of MenuItem
     */
    protected native MenuItem[] getHeaderContextMenuItems(Integer fieldNum) /*-{

        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var index = fieldNum == null ? null : fieldNum.@java.lang.Integer::intValue()();
        var menuItemsJS = self.__getHeaderContextMenuItems(index);
        var menuItemsJ = @com.smartgwt.client.widgets.menu.Menu::convertToMenuItemArray(Lcom/google/gwt/core/client/JavaScriptObject;)(menuItemsJS);
        return menuItemsJ;
    }-*/;

    /**
     * Return the base stylename for this cell. Has the following implementation by default: <ul> <li>If
     * this.editFailedBaseStyle is defined, and the cell is displaying a validation error return this value.</li> <li>If
     * this.editFailedPendingStyle is defined, and the cell is displaying an edit value that has not yet been saved (see
     * ListGrid.autoSaveEdits) return this value.</li> <li>Otherwise return record[listGrid.recordBaseStyleProperty], if
     * defined, otherwise field.baseStyle, or finally this.baseStyle</li> </ul>
     * <br><b>Note: This is an override point</b>
     *
     * @param record the record
     * @param rowNum the row num
     * @param colNum the colum num
     * @return the CSS class for this cell
     */
    protected native String getBaseStyle(ListGridRecord record, int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._getBaseStyle(record == null ? null : record.@com.smartgwt.client.core.DataClass::getJsObj()(), rowNum, colNum);
    }-*/;

      /**
    * The base name for the CSS class applied to cells. This style will have "Dark",  "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
    *
    * @param baseStyle baseStyle Default value is "cell"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setBaseStyle(String baseStyle)  throws IllegalStateException {
        setAttribute("baseStyle", baseStyle, false);
    }
    
    /**
     * The base name for the CSS class applied to cells. This style will have "Dark",  "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *
     *
     * @return Return the base stylename for this cell.  Has the following implementation by default: <ul> <li>If {@link com.smartgwt.client.widgets.grid.ListGrid#getEditFailedBaseStyle editFailedBaseStyle} is defined, and the     cell is displaying a validation error return this value.</li> <li>If {@link com.smartgwt.client.widgets.grid.ListGrid#getEditPendingBaseStyle editPendingBaseStyle} is defined, and     the cell is displaying an edit value that has not yet been saved (see      {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits}) return this value.</li> <li>Otherwise return {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty recordBaseStyleProperty},     if defined, otherwise {@link com.smartgwt.client.widgets.grid.ListGridField#getBaseStyle baseStyle},      or finally {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle}</li> </ul>
     *
     */
    public String getBaseStyle()  {
        return JSOHelper.getAttribute(config, "baseStyle");
    }

    /**
     * If this is an editable listGrid, this property will specify the {@link com.smartgwt.client.widgets.form.fields.DateItem#setInputFormat(String) inputFormat}
     * applied to editors for fields of type "date"
     *
     * 3 character string containing the "M", "D" and "Y" characters to indicate the format of strings being parsed into Date instances via Date.parseInput().
     *
     * <p>
     * As an example - an input format of "MDY" would parse "01/02/1999" to Jan 2nd 1999
     *
     * @param dateInputFormat the dateInputFormat
     */
    public void setDateInputFormat(String dateInputFormat) {
        setAttribute("dateInputFormat", "dateInputFormat", true);
    }

    /**
     * An array of field objects, specifying the order, layout, formatting, and sorting behavior of each field in the
     * listGrid object.  In ListGrids, the fields array specifies columns.  Each field in the fields array is a
     * ListGridField object.  Any listGrid that will display data should have at least one visible field. <p> If {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource} is also set, this value acts as a set of
     * overrides as explained in {@link com.smartgwt.client..DataBoundComponent#getFields fields}. Sets the fields array
     * and/or field widths to newFields and sizes, respectively.<br><br> If newFields is specified, it is assumed that
     * the new fields may have nothing in common with the old fields, and the component is substantially rebuilt.
     * Consider the following methods for more efficient, more incremental changes: resizeField, reorderField,
     * showField, hideField, setFieldProperty.
     *
     * @param fields array of fields to draw. Default value is null
     */
    public void setFields(ListGridField... fields) {
        setAttribute("fields", fields, true);
    }

    /**
     * A List of ListGridRecord objects, specifying the data to be used to populate the ListGrid.  In ListGrids, the
     * data array specifies rows. Note that ListGrids automatically observe changes to the data List and redraw
     * accordingly. <p> This property is settable directly only as part of a {@link
     * com.smartgwt.client.widgets.grid.ListGrid} constructor.  If you want to change the {@link
     * com.smartgwt.client.widgets.grid.ListGrid}'s data after initial creation, call {@link
     * com.smartgwt.client.widgets.grid.ListGrid#setData}. <p> This property will typically not be explicitly specified
     * for databound ListGrids, where the data is returned from the server via databound component methods such as
     * {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData}. In this case the data objects will be set to a
     * {@link com.smartgwt.client.data.ResultSet} rather than a simple array. Initialize the data object with the given
     * array. Observes methods of the data object so that when the data changes, the listGrid will redraw
     * automatically.
     *
     * @param records data to show in the list. Default value is null
     */
    public void setData(ListGridRecord[] records) {
        setAttribute("data", records, true);
    }

    /**
     * An array of Record objects, specifying the data to be used to populate the DataBoundComponent. Note that not
     * all DataBoundComponents observe the changes to the data to redraw themselves. Refer to the version of setData
     * that accepts component specific records.
     *
     * @param data array of Record objects.
     * @see #setData(ListGridRecord[])   
     */
    public void setData(Record[] data) {
        setAttribute("data", data, true);
    }

    /**
     * Synonym for {@link #setData(ListGridRecord[])}
     *
     * @param records the records
     */
    public void setRecords(ListGridRecord[] records) {
        setAttribute("data", records, true);
    }

    public ListGridRecord[] getRecords() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        ListGridRecord[] data = convertToListGridRecordArray(dataJS);
        return data;
    }

    /**
     * Should this ListGrid automatically expand to accomodate its content? <P> Valid settings are
     * <ul><li><code>"vertical"</code>: expand vertically to accomodate records.</li>     <li><code>"horizontal"</code>:
     * expand horizontally to accomodate fields.</li>     <li><code>"both"</code>: expand horizontally and vertically to
     * accomodate content.</li> </ul> Note that how far the ListGrid will expand may be limited via the following
     * properties: {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxHeight autoFitMaxHeight}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxWidth autoFitMaxWidth}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns}. Setter for {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitData autoFitData}.
     *
     * @param autoFitData One of <code>"vertical"</code>, <code>"horizontal"</code>  or <code>"both"</code>. To disable
     *                    auto fit behavior, pass in <code>null</code>.. Default value is null
     */
    public void setAutoFitData(Autofit autoFitData) {
        setAttribute("autoFitData", autoFitData.getValue(), true);
    }

    /**
     * Should this ListGrid automatically expand to accomodate its content? <P> Valid settings are
     * <ul><li><code>"vertical"</code>: expand vertically to accomodate records.</li>     <li><code>"horizontal"</code>:
     * expand horizontally to accomodate fields.</li>     <li><code>"both"</code>: expand horizontally and vertically to
     * accomodate content.</li> </ul> Note that how far the ListGrid will expand may be limited via the following
     * properties: {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxHeight autoFitMaxHeight}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxRecords autoFitMaxRecords}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxWidth autoFitMaxWidth}, {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFitMaxColumns autoFitMaxColumns}.
     *
     * @return String
     */
    public Autofit getAutoFitData() {
        return Autofit.valueOf(getAttributeAsString("autoFitData"));
    }

    /**
     * Specifies the field by which this grid should be initially sorted.
     *
     * @param fieldName the field Name
     */
    public void setSortField(String fieldName) {
        setAttribute("sortField", fieldName, true);
    }

    /**
     * The field by which this grid should be initially sorted.
     *
     * @return the sort field
     */
    public String getSortField() {
        return getAttribute("sortField");
    }

    /**
     * Criteria to be used when {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchData autoFetchData} is
     * set.
     *
     * @param initialCriteria initialCriteria Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    /**
     * Specifies the field by which this grid should be initially sorted. Note that if sortField is initally specified
     * as a number, it will be converted to a string (field name) after list grid initialization.
     *
     * @param fieldIndex the field index
     */
    public void setSortField(int fieldIndex) {
        setAttribute("sortField", fieldIndex, true);
    }

    /**
     * Header spans are a second level of headers that appear above the normal ListGrid headers, spanning one or more
     * listGrid fields in a manner similar to a column-spanning cell in an  HTML table. <P> A header span can be created
     * by simply naming the fields the header should span.  The example below creates a headerSpan that spans the first
     * two fields of the ListGrid. <pre>    isc.ListGrid.create({        headerHeight:40,        fields : [            {
     * name:"field1" },            { name:"field2" },            { name:"field3" }        ],        headerSpans : [
     *       {                 fields: ["field1", "field2"],                title: "Field 1 and 2"            }        ]
     *    }); </pre> Header spans will automatically react to resizing of the headers they span, and will be hidden
     * automatically when all of the spanned fields are hidden. <P> Header spans appear in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeader header} area of the ListGrid, sharing space with the existing
     * headers, so it's typical to set {@link com.smartgwt.client.widgets.grid.ListGrid#getHeaderHeight headerHeight} to
     * approximately double its normal height when using headerSpans. <P> See {@link com.smartgwt.client.widgets.grid.HeaderSpan}
     * for many properties that allow the control of the appearance of headerSpans.  Note that headerSpans are created
     * via the AutoChild pattern, hence you can change the SmartGWT component
     * being used, or any of it's properties. <P> Neither headerSpans themselves nor the fields within them may be drag
     * reordered, but other unspanned headers may be. <P> Note that headerSpans primarily provide a visual cue for
     * grouping multiple headers  together.  If you have an OLAP, data "cube" or multi-dimensional data model, the
     * {@link com.smartgwt.client..CubeGrid} component is the right choice.
     * Update the headerSpans configuration on the grid dynamically.
     *
     * @param headerSpans same configuration block as that passed to                                   {@link
     *                    com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans}.. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHeaderSpans(HeaderSpan... headerSpans) throws IllegalStateException {
        setAttribute("headerSpans", headerSpans, false);
    }

    /**
     * List of fields to group grid records. If only a single field is used, that field may be specified as a string.
     * After initialization, use {@link com.smartgwt.client.widgets.grid.ListGrid#groupBy}  to update the grouping field
     * list, instead of modifying groupByField directly.
     *
     * @param field groupByField Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGroupByField(String field) throws IllegalStateException {
        setAttribute("groupByField", field, false);
    }

    /**
     * Describes the default state of ListGrid groups when groupBy is called. Possible values are: <ul> <li>"all": open
     * all groups </li><li>"first": open the first group </li><li>"none": start with all groups closed </li><li>Array of
     * values that should be opened </li> </ul>
     *
     * @param group the group
     */
    public void setGroupStartOpen(String group) {
        setAttribute("groupStartOpen", group, true);
    }

    /**
     * @param groupValues Array of values that should be opened
     */
    public void setGroupStartOpen(String... groupValues) {
        setAttribute("groupStartOpen", groupValues, true);
    }

    /**
     * Return the total number of rows in the grid. <P> Note that, when creating new rows via inline editing, this can
     * be more than the total number of rows in the dataset (that is, grid.data.getLength())
     *
     * @return the total rows
     */
    public native int getTotalRows() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getTotalRows();
    }-*/;

    /**
     * Scroll to the specified row number.
     *
     * @param rowNum the row num
     */
    public void scrollToRow(int rowNum) {
        int cellHeight = getCellHeight();
        scrollBodyTo(null, (rowNum - 1) * cellHeight);
    }

    /**
     * Scroll the body of the grid to the scified coordinates.
     *
     * @param left the left position
     * @param top the top position
     */
    public native void scrollBodyTo(Integer left, Integer top)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var body = self.body;

        body.scrollTo(left, top);
     }-*/;

    /**
     * Force a field to be shown. NOTE: If a field.showIf expression exists, it will be destroyed.
     *
     * @param fieldName the field name
     */
    public native void showField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showField(fieldName);
    }-*/;

    /**
     * Force a field to be shown. NOTE: If a field.showIf expression exists, it will be destroyed.
     *
     * @param fieldName        the field name
     * @param suppressRelayout if true, don't relayout non-explicit sized fields to fit the available space
     */
    public native void showField(String fieldName, boolean suppressRelayout) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showField(fieldName, suppressRelayout);
    }-*/;

    /**
     * Change the title of a field after the grid is created.
     *
     * @param fieldName name of the field, or index.
     * @param title    new title
     */
    public native void setFieldTitle(String fieldName, String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFieldTitle(fieldName, title);
    }-*/;

    /**
     * Change the title of a field after the grid is created.
     *
     * @param fieldNum name of the field, or index.
     * @param title    new title
     */
    public native void setFieldTitle(int fieldNum, String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFieldTitle(fieldNum, title);
    }-*/;

    /**
     * Force a field to be hidden. NOTE: If a field.showIf expression exists, it will be destroyed.
     *
     * @param fieldName the field name
     */
    public native void hideField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideField(fieldName);
    }-*/;

    /**
     * Force a field to be hidden. NOTE: If a field.showIf expression exists, it will be destroyed.
     *
     * @param fieldName        the field name
     * @param suppressRelayout if true, don't relayout non-explicit sized fields to fit the available space
     */
    public native void hideField(String fieldName, boolean suppressRelayout) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideField(fieldName, suppressRelayout);
    }-*/;

    /**
     * Start editing a new row, after the last pre-existing record in the current set of data. This new row will be
     * saved via the "add" DataSource operation. If editing is already underway elsewhere in the grid, startEditingNew()
     * behaves just like {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing()}.
     */
    public native void startEditingNew() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.startEditingNew();
    }-*/;

    /**
     * Start editing a new row, after the last pre-existing record in the current set of data. This new row will be
     * saved via the "add" DataSource operation. If editing is already underway elsewhere in the grid, startEditingNew()
     * behaves just like {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing()}.
     *
     * @param defaultValues the default field values for the new record
     */
    public native void startEditingNew(Map defaultValues) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var defaultValuesJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(defaultValues);
        self.startEditingNew(defaultValuesJS);
    }-*/;

    /**
     * Given a field or field id, return it's index in the fields array
     *
     * @param fieldName the field name
     * @return index of the field within this.fields
     */
    public native int getFieldNum(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFieldNum(fieldName);
    }-*/;

    /**
     * Given a column number or field id, return the field name of a field.
     *
     * @param fieldName field name
     * @return Name of the field.
     */
    public native String getFieldName(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFieldName(fieldName);
    }-*/;

    /**
     * Given a column number or field id, return the field name of a field.
     *
     * @param colNum number or id of the field.
     * @return Name of the field.
     */
    public native String getFieldName(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFieldName(colNum);
    }-*/;

    /**
     * Given a column number or field name, return the field definition. <P> When using {@link
     * com.smartgwt.client..DataBoundComponent#getFields fields}, the field definition may be a mix of information
     * derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getFields fields} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}.
     *
     * @param fieldName the field name.
     * @return field definition
     */
    public native ListGridField getField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var field = self.getField(fieldName);

        if(field == null || field === undefined) return null;
        var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);        
        return fieldJ;
    }-*/;

    /**
     * Given a column number or field name, return the field definition. <P> When using {@link
     * com.smartgwt.client..DataBoundComponent#getFields fields}, the field definition may be a mix of information
     * derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getFields fields} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataSource dataSource}.
     *
     * @param colNum number or id of the field.
     * @return field definition
     */
    public native ListGridField getField(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var field = self.getField(colNum);
        if(field == null || field === undefined) return null;
        var fieldJ = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(field);
        return fieldJ;
    }-*/;

    /**
     * The selection associated with the listGrid.
     *
     * @return the selection
     */
    public native ListGridRecord[] getSelection() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selectionJS =  self.getSelection();
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(selectionJS);
    }-*/;


    private static ListGridRecord[] convertToListGridRecordArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new ListGridRecord[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        ListGridRecord[] objects = new ListGridRecord[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            ListGridRecord obj = (ListGridRecord) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new ListGridRecord(componentJS);
            objects[i] = obj;
        }
        return objects;
    }


    /**
     * The ListGrid fields
     *
     * @return the fields
     */
    public native ListGridField[] getFields() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldsJS = self.getProperty('fields');
        return @com.smartgwt.client.widgets.grid.ListGrid::convertToListGridFieldArray(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldsJS);
    }-*/;

    private static ListGridField[] convertToListGridFieldArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new ListGridField[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        ListGridField[] objects = new ListGridField[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            //ListGridField obj = (ListGridField) RefDataClass.getRef(componentJS);
            //if (obj == null)
            ListGridField obj = new ListGridField(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

    /**
     * Returns the index of the row being edited or -1 if there is no current edit row.
     *
     * @return Index of the current edit row
     */
    public native int getEditRow() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEditRow();
        return ret == null ? -1 : ret;
    }-*/;

    /**
     * Returns the index of the column being edited or -1 if there is no edit col.
     *
     * @return Index of the current edit column
     */
    public native int getEditCol() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getEditCol();
        return ret == null ? -1 : ret;
    }-*/;
    
    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link com.smartgwt.client..DataBoundComponent#getFetchOperation fetchOperation} and {@link
     * com.smartgwt.client..DataBoundComponent#getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a {@link com.smartgwt.client.data.DSCallback}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
     */
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.data.DataSource} to retrieve data that matches
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link com.smartgwt.client..DataBoundComponent#getFetchOperation fetchOperation} and {@link
     * com.smartgwt.client..DataBoundComponent#getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a {@link com.smartgwt.client.data.DSCallback}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
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
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link com.smartgwt.client..DataBoundComponent#getFetchOperation fetchOperation} and {@link
     * com.smartgwt.client..DataBoundComponent#getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a {@link com.smartgwt.client.data.DSCallback}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
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
     * the provided criteria, and displays the matching data in this component. <P> If there are a large number of
     * matching records, paging will automatically be enabled, so that initially a smaller number of records will be
     * retrieved and further records will be fetched as the user navigates the dataset. <P> When first called, this
     * method will create a {@link com.smartgwt.client.data.ResultSet}, which will be configured based on component
     * settings such as {@link com.smartgwt.client..DataBoundComponent#getFetchOperation fetchOperation} and {@link
     * com.smartgwt.client..DataBoundComponent#getDataPageSize dataPageSize}, as well as the general purpose {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.  The ResultSet is then available as
     * <code>component.data</code>. <P> Subsequent calls to fetchData() will simply call {@link
     * com.smartgwt.client.data.ResultSet#setCriteria} on the created ResultSet with the passed criteria. <P> In some
     * cases fetchData() will not need to context the server as the new criteria can be satisfied by performing a
     * client-side filter against the currently cached set of data. You can determine whether criteria will cause a
     * fetch by calling  {@link com.smartgwt.client.data.ResultSet#willFetchData}. <P> If you need to force a server
     * fetch, you can call {@link com.smartgwt.client.data.ResultSet#invalidateCache} via
     * <code>component.data.invalidateCache()</code> to do so.   <P> This method takes an optional callback parameter
     * (set to a {@link com.smartgwt.client.data.DSCallback}) to fire when the fetch completes. Note that this
     * callback will not fire if no server fetch is performed. In this case the data is updated synchronously, so as
     * soon as this method completes you can interact with the new data. If necessary we recomment using  {@link
     * com.smartgwt.client.data.ResultSet#willFetchData} before calling this method to determine whether or not a server
     * fetch will occur. <P> In addition to the callback parameter for this method, developers can use  {@link
     * com.smartgwt.client.data.ResultSet#dataArrived} to be notified every time ResultSet data is loaded.  A
     * <code>dataArrived</code> method can be installed in the automatically created ResultSet by adding it to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getDataProperties dataProperties}.
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
     * method behaves exactly like {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} except that {@link
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
     * method behaves exactly like {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} except that {@link
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
     * method behaves exactly like {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData} except that {@link
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
     * Open the current record detail grid inline,
     *
     * @param record the record
     * @param detailDataSource the detail deta source
     */
    public native void openRecordDetailGrid(ListGridRecord record, DataSource detailDataSource)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.widgets.grid.ListGridRecord::getJsObj()();
        var datasourceJS = detailDataSource.@com.smartgwt.client.data.DataSource::getOrCreateJsObj()();
        self.openRecordDetailGrid(recordJS, datasourceJS);
     }-*/;

    /**
     * Close the inline detail grid assoicated with the record.
     *
     * @param record the record
     */
    public native void closeRecord(ListGridRecord record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.widgets.grid.ListGridRecord::getJsObj()();
        self.closeRecord(recordJS);
     }-*/;

    /**
     * Open the record editor associated with the record.
     *
     * @param record the record
     */
    public native void openRecordEditor(ListGridRecord record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.widgets.grid.ListGridRecord::getJsObj()();
        self.openRecordEditor(recordJS);
     }-*/;

    /**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     *
     * @param record new record
     */
    public native void addData(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.addData(recordJS);
    }-*/;

    /**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     *
     * @param record new record
     * @param callback  method to call on operation completion
     */
    public native void addData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.addData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Perform a DataSource "add" operation to add new records to this component's DataSource.
     *
     * @param record         new record
     * @param callback          method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void addData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.addData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Perform a DataSource "update" operation to update existing records in this component's DataSource.
     *
     * @param record updated record
     */
    public native void updateData(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.updateData(recordJS);
    }-*/;

    /**
     * Perform a DataSource "update" operation to update existing records in this component's DataSource.
     *
     * @param record updated record
     * @param callback      method to call on operation completion
     */
    public native void updateData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.updateData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Perform a DataSource "update" operation to update existing records in this component's DataSource.
     *
     * @param record     updated record
     * @param callback          method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void updateData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.updateData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     *
     * @param record primary key values of record to delete,                                           (or complete
     *             record)
     */
    public native void removeData(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.removeData(recordJS);
    }-*/;

    /**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     *
     * @param record     primary key values of record to delete,                                           (or complete
     *                 record)
     * @param callback method to call on operation completion
     */
    public native void removeData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.removeData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Perform a DataSource "remove" operation to remove records from this component's DataSource.
     *
     * @param record              primary key values of record to delete,                                           (or
     *                          complete record)
     * @param callback          method to call on operation completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void removeData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();       
        self.removeData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Remove the currently selected records from this component. If this is a databound grid, the records will be
     * removed directly from the DataSource. <P> If no records are selected, no action is taken. The grid will
     * automatically be updated if the record deletion succeeds.
     */
    public native void removeSelectedData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeSelectedData();
    }-*/;

    /**
     * Remove the currently selected records from this component. If this is a databound grid, the records will be
     * removed directly from the DataSource. <P> If no records are selected, no action is taken. The grid will
     * automatically be updated if the record deletion succeeds.
     *
     * @param callback          callback to fire when the data has been removed
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void removeSelectedData(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.removeData(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Display the current set of records grouped by their values for the given field or fields. With no arguments,
     * disables all grouping. <P> Grouping tranforms the current dataset into a Tree on the fly, then provides a
     * familiar tree interface for exploring the grouped data. <P> Grouping works automatically with any dataset,
     * providing simple default grouping based on each field's declared type.  However, you can use the {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getGroupValue} API to control how records are grouped, and the
     * {@link com.smartgwt.client.widgets.grid.ListGridField#getGroupTitle} API to control how groups are titled. <P>
     * Grouping can be performed programmatically via this API, or you can set {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanGroupBy canGroupBy} to enable menus that allow the user to
     * performing grouping. To group a grid automatically, instantiate the grid with a  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGroupByField groupByField} setting. <P> While grouped, the
     * automatically created Tree is available as {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupTree
     * groupTree} and the original dataset is availabe as {@link com.smartgwt.client.widgets.grid.ListGrid#getOriginalData
     * originalData}.
     */
    public native void groupBy(String... fields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        fieldsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields);
        self.groupBy(fieldsJS);
    }-*/;

    /**
     * Clear the current criteria used to filter data.
     */
    public native void clearCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearCriteria();
    }-*/;

    /**
     * Clear the current criteria used to filter data.
     *
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued
     */
    public native void clearCriteria(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.clearCriteria(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Sort data by given property.
     *
     * @param property  the name
     * @param ascending direction
     */
    public native void sortByProperty(String property, boolean ascending) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.data.sortByProperty(property, ascending);
    }-*/;

    /**
     * Save a number of outstanding edits for this ListGrid. If no rows are specifed, all  outstanding edits will be
     * saved
     */
    public native void saveAllEdits() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveAllEdits();
    }-*/;

    /**
     * Cancel outstanding edits, discarding edit values, and hiding editors for the record[s] passed in if appropriate.
     * If no rows are passed in all outstanding edit values will be dropped.
     */
    public native void discardAllEdits() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.discardAllEdits();
    }-*/;

    /**
     * Freeze the indicated field, so that it remains in place and visible when horizontal scrolling occurs.
     *
     * @param fieldName the field name
     */
    public native void freezeField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.freezeField(fieldName);
    }-*/;

    /**
     * Freeze the indicated field, so that it remains in place and visible when horizontal scrolling occurs.
     *
     * @param colNum the column num
     */
    public native void freezeField(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.freezeField(colNum);
    }-*/;

    /**
     * Unfreeze a frozen field, so that it will now scroll along with other fields when horizontal scrolling occurs.
     *
     * @param fieldName the field name
     */
    public native void unfreezeField(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.freezeField(fieldName);
    }-*/;

    /**
     * Unfreeze a frozen field, so that it will now scroll along with other fields when horizontal scrolling occurs.
     *
     * @param colNum the column num
     */
    public native void unfreezeField(int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.freezeField(colNum);
    }-*/;

    /**
     * Refresh an individual cell without redrawing the grid. <P> The cell's value, CSS class, and CSS text will be
     * refreshed, to the current values returned by getCellValue(), getCellStyle() and getCellCSSText() respectively.
     *
     * @param rowNum row number of cell to refresh
     * @param colNum column number of cell to refresh
         */
    public native void refreshCell(int rowNum, int colNum, boolean refreshingRow, boolean allowEditCellRefresh) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.refreshCell(rowNum, colNum, refreshingRow, allowEditCellRefresh);
    }-*/;

    /**
     * Get the rows that are currently visible in the viewport, as an array of  [firstRowNum, lastRowNum]. If the grid contains no records, will return [-1,-1];
     *
     * @return the visible rows
     */
    public native Integer[] getVisibleRows() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getVisibleRows();
        return @com.smartgwt.client.util.JSOHelper::convertToJavaInterArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Get the rows that are currently drawn (exist in the DOM), as an array of [firstRowNum, lastRowNum].   <P> The drawn rows differ from the {@link com.smartgwt.client.widgets.grid.ListGrid#getVisibleRows} because of {@link com.smartgwt.client.widgets.grid.ListGrid#getDrawAheadRatio drawAheadRatio}.  The drawn rows are the apppropriate range to consider if you need to, eg, using {@link com.smartgwt.client.widgets.grid.ListGrid#refreshCell} to update all the cells in a column. <P> If the grid is undrawn or the {@link com.smartgwt.client.widgets.grid.ListGrid#getEmptyMessage emptyMessage} is currently shown, returns [null,null];
     *
     * @return the drawn rows
     */
    public native Integer[] getDrawnRows() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawnRows();
        return @com.smartgwt.client.util.JSOHelper::convertToJavaInterArray(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Based on the relationship between the DataSource this component is bound to and the DataSource specified as the
     * "schema" argument, call fetchData() to retrieve records in this grid that are related to the passed-in record.
     * <p/>
     * Relationships between DataSources are declared via DataSourceField.foreignKey.
     * <p/>
     * For example, given a DataSource "orders" and another DataSource "orderItems", where "orderItems" declared a field
     * "orderId" pointing to the primary key field of the "orders" DataSource", there is a set of records from the
     * "orderItems" DataSource related to any given record from the "order" DataSource. If this component were bound to
     * "orderItems" and a record from the "orders".
     *
     * @param record     the DataSource record
     * @param dataSource the schema of the DataSource record
     */
    public native void fetchRelatedData(Record record, DataSource dataSource) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var datasourceJS = dataSource.@com.smartgwt.client.data.DataSource::getOrCreateJsObj()();
        self.fetchRelatedData(recordJS, datasourceJS);
    }-*/;

    /**
     * Based on the relationship between the DataSource this component is bound to and the DataSource specified as the
     * "schema" argument, call fetchData() to retrieve records in this grid that are related to the passed-in record.
     * <p/>
     * Relationships between DataSources are declared via DataSourceField.foreignKey.
     * <p/>
     * For example, given a DataSource "orders" and another DataSource "orderItems", where "orderItems" declared a field
     * "orderId" pointing to the primary key field of the "orders" DataSource", there is a set of records from the
     * "orderItems" DataSource related to any given record from the "order" DataSource. If this component were bound to
     * "orderItems" and a record from the "orders".
     *
     * @param record            the DataSource record
     * @param dataSource        the schema of the DataSource record
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest that will be issued
     */
    public native void fetchRelatedData(Record record, DataSource dataSource, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var datasourceJS = dataSource.@com.smartgwt.client.data.DataSource::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();

        self.fetchRelatedData(recordJS, datasourceJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);

    }-*/;


    /**
     * Returns the current value of a cell. If the cell has an outstanding edit value,
     * this will be returned, otherwise the underlying value of the record will be returned.
     *
     * @param rowNum the row number
     * @param fieldName the field name
     *
     *
     * @return the edited cell value
     */
    public native Object getEditedCell(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getEditedCell(rowNum, fieldName);
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;

    /**
     * Returns the current value of a cell. If the cell has an outstanding edit value,
     * this will be returned, otherwise the underlying value of the record will be returned.
     *
     * @param rowNum the row number
     * @param colNum the column number
     *
     *
     * @return the edited cell value
     */
    public native Object getEditedCell(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getEditedCell(rowNum, colNum);
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;



    /**
     * Returns the current value of a cell. If the cell has an outstanding edit value,
     * this will be returned, otherwise the underlying value of the record will be returned.
     *
     * @param record an Object containing values for all the record's primary keys
     * @param fieldName the field name
     *
     *
     * @return the edited cell value
     */
    public native Object getEditedCell(Record record, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var value = self.getEditedCell(recordJS, fieldName);
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;

    /**
     * Returns the current value of a cell. If the cell has an outstanding edit value,
     * this will be returned, otherwise the underlying value of the record will be returned.
     *
     * @param record an Object containing values for all the record's primary keys
     * @param colNum the column number
     *
     *
     * @return the edited cell value
     */
    public native Object getEditedCell(Record record, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var value = self.getEditedCell(recordJS, colNum);
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;

    /**
     * Returns the combination of unsaved edits (if any) and original values (if any) for a given row being edited.
     * <p>
     *
     * The returned value is never null, and can be freely modified.
     *
     * @param rowNum the row num
     * @return A copy of the record with unsaved edits included
     */
    public native Record getEditedRecord(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var record = self.getEditedRecord(rowNum);
        if(record == null || record === undefined) return null;
        var recordJ = @com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
        return recordJ;
    }-*/;

    /**
     * Returns the current temporary locally stored edit value for some field within a record being edited.
     * 
     * @param rowNum index of the row for which the editValue should be returned
     * @param colNum index of the field for which value should be returned
     * 
     * @return   edit value for the field in question
     */
    public native Object getEditValue(int rowNum, int colNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getEditValue(rowNum, colNum);
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     * 
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, String value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, Date value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value);
        self.setEditValue(rowNum, colNum, valueJS);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, double value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, boolean value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, float value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param colNum column number of cell
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, int colNum, int value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;


    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, String value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, fieldName, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, Date value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value);
        self.setEditValue(rowNum, fieldName, valueJS);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, double value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, colNum, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, boolean value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, fieldName, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, float value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, fieldName, value);
    }-*/;

    /**
     * Modifies a field value being tracked as an unsaved user edit.
     *
     * @param rowNum row number
     * @param fieldName the field name
     * @param value new value for the appropriate field
     */
    public native void setEditValue(int rowNum, String fieldName, int value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setEditValue(rowNum, fieldName, value);
    }-*/;

    /**
     * This method sets up a set of editValues for some row / cell. It differs from setEditValue in that:
     * <ul>
     * <li>it takes values for multiple fields</li>
     * <li>it clears out any previous edit values for the record</li>
     * </ul>
     * 
     * @param rowNum the row num for the record being edited
     * @param values new values for the row
     */
    public native void setEditValues(int rowNum, Map values) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valuesJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(values);
        self.setEditValues(rowNum, valuesJS);
    }-*/;
    
    /**
     * Returns the current temporary locally stored edit value for some field within a record being edited.
     *
     * @param rowNum index of the row for which the editValue should be returned
     * @param fieldName field name for which value should be returned
     *
     * @return   edit value for the field in question
     */
    public native Object getEditValue(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getEditValue(rowNum, fieldName);
        var valueJ = $wnd.SmartGWT.convertToJavaType(value);
        return valueJ;
    }-*/;

    /**
     * Returns the current set of unsaved edits for a given row being edited.
     * 
     * @param rowNum rowNum of the record being edited
     * @return current editValues object for the row. This contains the current edit values in {fieldName1:value1, fieldName2:value2} format
     */
    public native Map getEditValues(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getEditValues(rowNum);
        var valueJ = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
        return valueJ;
    }-*/;

    /**
     * Returns the current set of unsaved edits for a given row being edited.
     *
     * @param record an Object containing values for all the record's primary keys
     * @return current editValues object for the row. This contains the current edit values in {fieldName1:value1, fieldName2:value2} format
     */
    public native Map getEditValues(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var value = self.getEditValues(recordJS);
        var valueJ = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
        return valueJ;
    }-*/;


    /**
     * Set the validation errors for some row (replacing any pre-existant validation errors)
     *
     * 
     * @param rowNum row to add validation error for
     * @param errors validation errors for the row. The key of the map must be the field name, and the value can either be a String error message
     * or an array of Strings for multiple errors
     */
    public native void setRowErrors(int rowNum, Map errors) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var errorsJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(errors);
        self.setRowErrors(rowNum, errorsJS);
    }-*/;

    /**
     * Set a validation error for some cell.
     * 
     * @param rowNum row index of cell to add validation error for
     * @param fieldName field name of cell to add validation error for
     * @param errorMessage validation error message
     */
    public native void setFieldError(int rowNum, String fieldName, String errorMessage) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFieldError(rowNum, fieldName, errorMessage);
    }-*/;

    /**
     * Set a validation error for some cell.
     *
     * @param rowNum row index of cell to add validation error for
     * @param fieldName field name of cell to add validation error for
     * @param errorMessages validation error messages
     */
    public native void setFieldError(int rowNum, String fieldName, String[] errorMessages) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var errorsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(errorMessages);
        self.setFieldError(rowNum, fieldName, errorsJS);
    }-*/;

    /**
     * Select a single {@link com.smartgwt.client.data.Record} passed in explicitly, or by index, and deselect everything else. When programmatic selection of records is a requirement and {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType}  is "single", use this method rather than {@link com.smartgwt.client.widgets.grid.ListGrid#selectRecord} to  enforce mutually-exclusive record-selection.
     * @param record record to select
     */
    public native void selectSingleRecord(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectSingleRecord(record.@com.smartgwt.client.data.Record::getJsObj()());
    }-*/;

    /**
     * Select a single {@link com.smartgwt.client.data.Record} passed in explicitly, or by index, and deselect everything else. When programmatic selection of records is a requirement and {@link com.smartgwt.client.widgets.grid.ListGrid#getSelectionType selectionType}  is "single", use this method rather than {@link com.smartgwt.client.widgets.grid.ListGrid#selectRecord} to  enforce mutually-exclusive record-selection.
     * @param rowNum rowNum (or row number) to select
     */
    public native void selectSingleRecord(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectSingleRecord(rowNum);
    }-*/;

    /**
     * Get the computed value of a {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAddFormulaFields canAddFormulaFields}.
     *
     * @param field  field that has a formula
     * @param record record to use to compute formula value
     * @return formula result
     */
    public native int getFormulaFieldValue(ListGridField field, Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getFormulaFieldValue(field.@com.smartgwt.client.widgets.grid.ListGridField::getJsObj()(), record);
    }-*/;

    /**
     * Get the computed value of a {@link com.smartgwt.client.widgets.grid.ListGrid#getCanAddSummaryFields canAddSummaryFields}.
     *
     * @param field  field that has a summary format
     * @param record record to use to compute formula value
     * @return formula result
     */
    public native int getSummaryFieldValue(ListGridField field, Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getSummaryFieldValue(field.@com.smartgwt.client.widgets.grid.ListGridField::getJsObj()(), record);
    }-*/;


    /**
     * Returns any currently stored validation errors for this row
     *
     * @param rowNum the index of row to check for validation errors
     * @return map of validation errors.  If no validation errors stored for the row, null is returned
     */
    public native Map getRowErrors(int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var errorsJS =  self.getRowErrors(rowNum);
        return errorsJS == null ? null : @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(errorsJS);
    }-*/;

    /**
     * Returns the current set of errors for this cell.
     *
     * @param rowNum the index of row to check for validation errors
     * @param fieldName field to check for validation errors
     *
     * @return array of error messages (strings) for the specified cell. If no validation errors are present, returns null.
     */
    public native String[] getCellErrors(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var errorsJS =  self.getCellErrors(rowNum, fieldName);
        return errorsJS == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(errorsJS);
    }-*/;

    /**
    * Sorting direction of this ListGrid. If specified when the ListGrid is initialized, this property will be the default sorting direction for the {@link com.smartgwt.client.widgets.grid.ListGrid#getSortField sortField}. May be overridden by specifying {@link com.smartgwt.client.widgets.grid.ListGridField#getSortDirection sortDirection}. <P> After initialization, this property will be updated on {@link com.smartgwt.client.widgets.grid.ListGrid#sort} to reflect the current sort direction of the grid.
    *
    * @param sortDirection sortDirection Default value is SortDirection.ASCENDING
    */
    public void setSortDirection(SortDirection sortDirection) {
        if(sortDirection == null) {
            setAttribute("sortDirection", (Boolean)null, true);
        } else {
            setAttribute("sortDirection", sortDirection == SortDirection.ASCENDING, true);
        }
    }
    
    /**
     * Sorting direction of this ListGrid. If specified when the ListGrid is initialized, this property will be the default sorting direction for the {@link com.smartgwt.client.widgets.grid.ListGrid#getSortField sortField}. May be overridden by specifying {@link com.smartgwt.client.widgets.grid.ListGridField#getSortDirection sortDirection}. <P> After initialization, this property will be updated on {@link com.smartgwt.client.widgets.grid.ListGrid#sort} to reflect the current sort direction of the grid.
     *
     * @return sort direction Default value is SortDirection.ASCENDING
     */
    public SortDirection getSortDirection()  {
        Boolean sortDir = getAttributeAsBoolean("sortDirection");
        if(sortDir == null) return null;
        return sortDir ? SortDirection.ASCENDING : SortDirection.DESCENDING;
    }

    /**
     * Sets this component's filter criteria. Default implementation calls this.data.setCriteria()
     * @param  criteria new criteria to show
     */
    public native void setCriteria(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setCriteria(criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor} is true, this method will update the criteria shown in the <code>filterEditor</code> without performing a filter.
     * @param criteria New criteria to show
     */
    public native void setFilterEditorCriteria(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFilterEditorCriteria(criteria);
    }-*/;

    /**
     * If {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor showFilterEditor} is true, this method will return the criteria currently displayed in the <code>filterEditor</code>. Note that these values may differ from the criteria returned by {@link com.smartgwt.client.widgets.grid.ListGrid#getCriteria} if the filter editor values have been modified without performing an actual filter.
     *
     * @return criteria currently displayed in the filterEditor
     */
    public native Criteria getFilterEditorCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFilterEditorCriteria();
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Validate the current edit value for the cell in question.  Called when the user moves to a&#010 new edit cell if {@link com.smartgwt.client.widgets.grid.ListGrid#getValidateByCell validateByCell} is true.<br>&#010 This method may also be called directly to perform cell level validation at any time.&#010
     *
     * @param rowNum    index of row to be validated.
     * @param fieldName field name of field to be validated
     * @return returns true if validation was successful (no errors encountered), false  otherwise.
     */
    public native Boolean validateCell(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.validateCell(rowNum, fieldName);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Validate the current edit value for the cell in question.  Called when the user moves to a&#010 new edit cell if {@link com.smartgwt.client.widgets.grid.ListGrid#getValidateByCell validateByCell} is true.<br>&#010 This method may also be called directly to perform cell level validation at any time.&#010
     *
     * @param rowNum    index of row to be validated.
     * @param colIndex column index of field to be validated
     * @return returns true if validation was successful (no errors encountered), false otherwise.
     */
    public native Boolean validateCell(int rowNum, int colIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.validateCell(rowNum, colIndex);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Given a rowNum and a colNum or fieldName, determine whether we currently have stored &#010 validation errors for the record/field in question.&#010
     *
     * @param rowNum  index of row to check for validation errors
     * @param fieldName name of field to check for validation                                       errors
     * @return true if we have validation errors for the row/col in question
     */
    public native Boolean cellHasErrors(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.cellHasErrors(rowNum, fieldName);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Given a rowNum and a colNum or fieldName, determine whether we currently have stored &#010 validation errors for the record/field in question.&#010
     *
     * @param rowNum  index of row to check for validation errors
     * @param colIndex index of column to check for validation                                       errors
     * @return true if we have validation errors for the row/col in question
     */
    public native Boolean cellHasErrors(int rowNum, int colIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.cellHasErrors(rowNum, colIndex);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;


    /**
     * Clears any validation errors for some cell.&#010
     *
     * @param rowNum    row index of cell to add validation error for
     * @param fieldName field name of cell to add validation error for
     */
    public native void clearFieldError(int rowNum, String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearFieldError(rowNum, fieldName);
    }-*/;

    /**
     * Clears any validation errors for some cell.&#010
     *
     * @param rowNum    row index of cell to add validation error for
     * @param colIndex col index of cell to add validation error for
     */
    public native void clearFieldError(int rowNum, int colIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearFieldError(rowNum, colIndex);
    }-*/;

    /**
     * Add a onHeaderClick handler.
     * <p>
     * Handler fired when the user clicks a header in this listGrid before any other processing&#010 occurs.&#010 Return false to suppress the default header click handling&#010
     *
     * @param handler the onHeaderClick handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addHeaderClickHandler(com.smartgwt.client.widgets.grid.events.HeaderClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.HeaderClickEvent.getType()) == 0) setupHeaderClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.HeaderClickEvent.getType());
    }
    private native void setupHeaderClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onHeaderClick:function(){
                    var param = {"fieldNum" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.grid.events.HeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onHeaderClick = function(){
                var param = {"fieldNum" : arguments[0]};
                var event = @com.smartgwt.client.widgets.grid.events.HeaderClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            };
        }
    }-*/;

    /**
     * Add a onRecordDrop handler.
     * <p>
     * Handler fired when the user drops a record onto this listGrid before any other processing&#010 of the drop occurs.&#010 Return false to suppress the default record drop handling.&#010
     *
     * @param handler the onRecordDrop handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRecordDropHandler(com.smartgwt.client.widgets.grid.events.RecordDropHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.grid.events.RecordDropEvent.getType()) == 0) setupRecordDropEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.grid.events.RecordDropEvent.getType());
    }
    private native void setupRecordDropEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onRecordDrop:function(){
                    var param = {"dropRecords" : arguments[0], "targetRecord" : arguments[1], "index" : arguments[2], "sourceWidget" : arguments[3]};
                    var event = @com.smartgwt.client.widgets.grid.events.RecordDropEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onRecordDrop = function(){
                var param = {"dropRecords" : arguments[0], "targetRecord" : arguments[1], "index" : arguments[2], "sourceWidget" : arguments[3]};
                var event = @com.smartgwt.client.widgets.grid.events.RecordDropEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
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

}





