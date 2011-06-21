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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A ListGridRecord is a JavaScript Object whose properties contain values for each&#010 {@link
 * com.smartgwt.client.widgets.grid.ListGridField}.  A ListGridRecord may have additional properties which affect the&#010
 * record's appearance or behavior, or which hold data for use by custom logic or other,&#010 related components.&#010
 * <p>&#010 For example a ListGrid that defines the following fields:&#010 <pre>&#010 fields : [&#010     {name:
 * "field1"},&#010     {name: "field2"}&#010 ],&#010 </pre>&#010 Might have the following data:&#010 <pre>&#010 data :
 * [&#010     {field1: "foo", field2: "bar", customProperty:5},&#010     {field1: "field1 value", field2: "field2 value",
 * enabled:false}&#010 ]&#010 </pre>&#010 Each line of code in the <code>data</code> array above creates one JavaScript
 * Object via&#010 JavaScript {type:ObjectLiteral,object literal} notation.  These JavaScript Objects are&#010 used as
 * ListGridRecords.&#010 <P>&#010 Both records shown above have properties whose names match the name property of a&#010
 * ListGridField, as well as additional properties.  The second record will be disabled due to&#010
 * <code>enabled:false</code>; the first record has a property "customProperty" which will&#010 have no effect by default
 * but which may be accessed by custom logic.&#010 <P>&#010 After a ListGrid is created and has loaded data, records may be
 * accessed via&#010 {@link com.smartgwt.client.widgets.grid.ListGrid#getData data}, for example, listGrid.data.get(0)
 * retrieves the first record.&#010 ListGridRecords are also passed to many events, such as&#010 {@link
 * com.smartgwt.client.widgets.grid.ListGrid#addCellClickHandler cellClick()}.&#010 <P>&#010 A ListGridRecord is always an
 * ordinary JavaScript Object regardless of how the grid's&#010 dataset is loaded (static data, java server, XML web
 * service, etc), and so supports the&#010 normal behaviors of JavaScript Objects, including accessing and assigning to
 * properties&#010 via dot notation:&#010 <pre>&#010     var fieldValue = record.<i>fieldName</i>;&#010    
 * record.<i>fieldName</i> = newValue;&#010 </pre>&#010 <P>&#010 Note however that simply assigning a value to a record
 * won't cause the display to be&#010 automatically refreshed - {@link
 * com.smartgwt.client.widgets.grid.ListGrid#refreshCell ListGrid.refreshCell} needs to be called.  Also,&#010 consider
 * {@link com.smartgwt.client.docs.Editing editValues vs saved values} when directly modifying&#010 ListGridRecords.&#010
 * <P>&#010 See the attributes in the API tab for the full list of special properties on&#010 ListGridRecords that will
 * affect the grid's behavior.
 * @see com.smartgwt.client.widgets.grid.ListGrid#getData
 */
public class ListGridRecord extends Record {

    public static ListGridRecord getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null && obj instanceof ListGridRecord) {
            obj.setJsObj(jsObj);
            return (ListGridRecord) obj;
        } else {
            return new ListGridRecord(jsObj);
        }
    }

    public ListGridRecord(){
        
    }

    public ListGridRecord(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Name of a CSS style to use as the {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} for all cells
     * for this particular record.   <P> The styleName specified with have suffixes appended to it as the record changes state
     * ("Over", "Selected" and so forth) as described by {@link com.smartgwt.client.widgets.grid.ListGrid#getCellStyle
     * ListGrid.getCellStyle}.  For a single, fixed style for a record, use {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getCustomStyle customStyle} instead. <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle ListGrid.getCellStyle} for an overview of various ways to
     * customize styling, both declarative and programmatic. <P> If this property is changed after draw(), to refresh the grid
     * call {@link com.smartgwt.client.widgets.grid.ListGrid#refreshRow ListGrid.refreshRow} (or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markForRedraw ListGrid.markForRedraw} if several rows are being refreshed).
     * <P> If your application's data uses the "_baseStyle" attribute for something else, the property name can be changed via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty recordBaseStyleProperty}.
     *
     * @param _baseStyle _baseStyle Default value is null
     */
    public void set_baseStyle(String _baseStyle) {
        setAttribute("_baseStyle", _baseStyle);
    }

    /**
     * Name of a CSS style to use as the {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle baseStyle} for all cells
     * for this particular record.   <P> The styleName specified with have suffixes appended to it as the record changes state
     * ("Over", "Selected" and so forth) as described by {@link com.smartgwt.client.widgets.grid.ListGrid#getCellStyle
     * ListGrid.getCellStyle}.  For a single, fixed style for a record, use {@link
     * com.smartgwt.client.widgets.grid.ListGridRecord#getCustomStyle customStyle} instead. <P> See {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCellStyle ListGrid.getCellStyle} for an overview of various ways to
     * customize styling, both declarative and programmatic. <P> If this property is changed after draw(), to refresh the grid
     * call {@link com.smartgwt.client.widgets.grid.ListGrid#refreshRow ListGrid.refreshRow} (or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markForRedraw ListGrid.markForRedraw} if several rows are being refreshed).
     * <P> If your application's data uses the "_baseStyle" attribute for something else, the property name can be changed via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordBaseStyleProperty recordBaseStyleProperty}.
     *
     *
     * @return String
     */
    public String get_baseStyle()  {
        return getAttributeAsString("_baseStyle");
    }

    /**
     * Has no effect unless {@link com.smartgwt.client.widgets.grid.ListGrid#getShowBackgroundComponent
     * showBackgroundComponent} is <code>true</code>. <P> Canvas created and embedded in the body behind a given record.   When
     * set, either as a Canvas or Canvas Properties, will be constructed if necessary, combined with the  autoChild properties
     * specified for {@link com.smartgwt.client.widgets.grid.ListGrid#getBackgroundComponent backgroundComponent} and displayed
     *  behind this record in the page's z-order, meaning  it will only be visible if the cell styling is transparent.
     *
     * @param backgroundComponent backgroundComponent Default value is null
     */
    public void setBackgroundComponent(Canvas backgroundComponent) {
        setAttribute("backgroundComponent", backgroundComponent == null ? null : backgroundComponent.getOrCreateJsObj());
    }

    /**
     * Has no effect unless {@link com.smartgwt.client.widgets.grid.ListGrid#getShowBackgroundComponent
     * showBackgroundComponent} is <code>true</code>. <P> Canvas created and embedded in the body behind a given record.   When
     * set, either as a Canvas or Canvas Properties, will be constructed if necessary, combined with the  autoChild properties
     * specified for {@link com.smartgwt.client.widgets.grid.ListGrid#getBackgroundComponent backgroundComponent} and displayed
     *  behind this record in the page's z-order, meaning  it will only be visible if the cell styling is transparent.
     *
     *
     * @return Canvas
     */
    public Canvas getBackgroundComponent()  {
        return Canvas.getOrCreateRef(getAttributeAsJavaScriptObject("backgroundComponent"));
    }

    /**
     * When set to <code>false</code>, other records cannot be dropped on (i.e., inserted via drag and drop) immediately before
     * this record.
     *
     * @param canAcceptDrop canAcceptDrop Default value is null
     */
    public void setCanAcceptDrop(Boolean canAcceptDrop) {
        setAttribute("canAcceptDrop", canAcceptDrop);
    }

    /**
     * When set to <code>false</code>, other records cannot be dropped on (i.e., inserted via drag and drop) immediately before
     * this record.
     *
     *
     * @return Boolean
     */
    public Boolean getCanAcceptDrop()  {
        return getAttributeAsBoolean("canAcceptDrop");
    }

    /**
     * When set to <code>false</code>, this record cannot be dragged. If canDrag is false for any record in the current
     * selection, none of the records will be draggable.
     *
     * @param canDrag canDrag Default value is null
     */
    public void setCanDrag(Boolean canDrag) {
        setAttribute("canDrag", canDrag);
    }

    /**
     * When set to <code>false</code>, this record cannot be dragged. If canDrag is false for any record in the current
     * selection, none of the records will be draggable.
     *
     *
     * @return Boolean
     */
    public Boolean getCanDrag()  {
        return getAttributeAsBoolean("canDrag");
    }

    /**
     * Default property name denoting whether this record can be expanded. Property name may be  modified for some grid via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecordProperty canExpandRecordProperty}.
     *
     * @param canExpand canExpand Default value is null
     */
    public void setCanExpand(Boolean canExpand) {
        setAttribute("canExpand", canExpand);
    }

    /**
     * Default property name denoting whether this record can be expanded. Property name may be  modified for some grid via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanExpandRecordProperty canExpandRecordProperty}.
     *
     *
     * @return Boolean
     */
    public Boolean getCanExpand()  {
        return getAttributeAsBoolean("canExpand");
    }

    /**
     * Name of a CSS style to use for all cells for this particular record.   <P> Note that using this property assigns a
     * single, fixed style to the record, so rollover and selection styling are disabled.  To provide a series of stateful
     * styles for a record use {@link com.smartgwt.client.widgets.grid.ListGridRecord#get_baseStyle _baseStyle} instead. <P>
     * See {@link com.smartgwt.client.widgets.grid.ListGrid#getCellStyle ListGrid.getCellStyle} for an overview of various ways
     * to customize styling, both declarative and programmatic. <P> If this property is changed after draw(), to refresh the
     * grid call {@link com.smartgwt.client.widgets.grid.ListGrid#refreshRow ListGrid.refreshRow} (or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markForRedraw ListGrid.markForRedraw} if several rows are being refreshed).
     * <P> If your application's data uses the "customStyle" attribute for something else, the property name can be changed via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordCustomStyleProperty recordCustomStyleProperty}.
     *
     * @param customStyle customStyle Default value is null
     */
    public void setCustomStyle(String customStyle) {
        setAttribute("customStyle", customStyle);
    }

    /**
     * Name of a CSS style to use for all cells for this particular record.   <P> Note that using this property assigns a
     * single, fixed style to the record, so rollover and selection styling are disabled.  To provide a series of stateful
     * styles for a record use {@link com.smartgwt.client.widgets.grid.ListGridRecord#get_baseStyle _baseStyle} instead. <P>
     * See {@link com.smartgwt.client.widgets.grid.ListGrid#getCellStyle ListGrid.getCellStyle} for an overview of various ways
     * to customize styling, both declarative and programmatic. <P> If this property is changed after draw(), to refresh the
     * grid call {@link com.smartgwt.client.widgets.grid.ListGrid#refreshRow ListGrid.refreshRow} (or {@link
     * com.smartgwt.client.widgets.grid.ListGrid#markForRedraw ListGrid.markForRedraw} if several rows are being refreshed).
     * <P> If your application's data uses the "customStyle" attribute for something else, the property name can be changed via
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordCustomStyleProperty recordCustomStyleProperty}.
     *
     *
     * @return String
     */
    public String getCustomStyle()  {
        return getAttributeAsString("customStyle");
    }

    /**
     * The default value of {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordDetailDSProperty recordDetailDSProperty}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param detailDS detailDS Default value is null
     */
    public void setDetailDS(DataSource detailDS) {
        setAttribute("detailDS", detailDS == null ? null : detailDS.getOrCreateJsObj());
    }

    /**
     * The default value of {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordDetailDSProperty recordDetailDSProperty}.
     *
     *
     * @return DataSource
     */
    public DataSource getDetailDS()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("detailDS"));
    }

    /**
     * Default property name denoting whether this record is enabled. Property name may be modified for some grid via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordEnabledProperty recordEnabledProperty}.
     *
     * @param enabled enabled Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_disabled_rows" target="examples">Disabled rows Example</a>
     */
    public void setEnabled(Boolean enabled) {
        setAttribute("enabled", enabled);
    }

    /**
     * Default property name denoting whether this record is enabled. Property name may be modified for some grid via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getRecordEnabledProperty recordEnabledProperty}.
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_interaction_disabled_rows" target="examples">Disabled rows Example</a>
     */
    public Boolean getEnabled()  {
        return getAttributeAsBoolean("enabled");
    }

    /**
     * If specified as false this record should be ignored when calculating summary totals  to be shown in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary summary row} for this grid. <P> Note that
     * <code>includeInSummary</code> is the default property name for this attribute, but it may be modified via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getIncludeInSummaryProperty includeInSummaryProperty}.
     *
     * @param includeInSummary includeInSummary Default value is null
     */
    public void setIncludeInSummary(Boolean includeInSummary) {
        setAttribute("includeInSummary", includeInSummary);
    }

    /**
     * If specified as false this record should be ignored when calculating summary totals  to be shown in the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary summary row} for this grid. <P> Note that
     * <code>includeInSummary</code> is the default property name for this attribute, but it may be modified via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getIncludeInSummaryProperty includeInSummaryProperty}.
     *
     *
     * @return Boolean
     */
    public Boolean getIncludeInSummary()  {
        return getAttributeAsBoolean("includeInSummary");
    }

    /**
     * This attribute will automatically be set to true for the record representing the  grid-level summary row shown if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} is true. <P> Note that
     * <code>isGridSummary</code> is the default property name for this attribute but it may be modified by setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGridSummaryRecordProperty gridSummaryRecordProperty}
     *
     * @param isGridSummary isGridSummary Default value is null
     */
    public void setIsGridSummary(Boolean isGridSummary) {
        setAttribute("isGridSummary", isGridSummary);
    }

    /**
     * This attribute will automatically be set to true for the record representing the  grid-level summary row shown if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGridSummary showGridSummary} is true. <P> Note that
     * <code>isGridSummary</code> is the default property name for this attribute but it may be modified by setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGridSummaryRecordProperty gridSummaryRecordProperty}
     *
     *
     * @return Boolean
     */
    public Boolean getIsGridSummary()  {
        return getAttributeAsBoolean("isGridSummary");
    }

    /**
     * This attribute will automatically be set to true for records representing   group-level summary rows shown if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true. <P> Note that
     * <code>isGroupSummary</code> is the default property name for this attribute but it may be modified by setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGroupSummaryRecordProperty groupSummaryRecordProperty}
     *
     * @param isGroupSummary isGroupSummary Default value is null
     */
    public void setIsGroupSummary(Boolean isGroupSummary) {
        setAttribute("isGroupSummary", isGroupSummary);
    }

    /**
     * This attribute will automatically be set to true for records representing   group-level summary rows shown if {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getShowGroupSummary showGroupSummary} is true. <P> Note that
     * <code>isGroupSummary</code> is the default property name for this attribute but it may be modified by setting {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getGroupSummaryRecordProperty groupSummaryRecordProperty}
     *
     *
     * @return Boolean
     */
    public Boolean getIsGroupSummary()  {
        return getAttributeAsBoolean("isGroupSummary");
    }

    /**
     * Default property name denoting a separator row.<br> When set to <code>true</code>, defines a horizontal separator in the
     * listGrid object. Typically this is specified as the only property of a record object, since a record with
     * <code>isSeparator:true</code> will not display any values.<br> Note: this attribute name is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getIsSeparatorProperty isSeparatorProperty}.
     *
     * @param isSeparator isSeparator Default value is null
     */
    public void setIsSeparator(Boolean isSeparator) {
        setAttribute("isSeparator", isSeparator);
    }

    /**
     * Default property name denoting a separator row.<br> When set to <code>true</code>, defines a horizontal separator in the
     * listGrid object. Typically this is specified as the only property of a record object, since a record with
     * <code>isSeparator:true</code> will not display any values.<br> Note: this attribute name is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getIsSeparatorProperty isSeparatorProperty}.
     *
     *
     * @return Boolean
     */
    public Boolean getIsSeparator()  {
        return getAttributeAsBoolean("isSeparator");
    }

    /**
     * The HTML to display in this row for fields with fieldType set to link. This overrides  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getLinkText linkText}.
     *
     * @param linkText linkText Default value is null
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.widgets.grid.ListGridField#setLinkText
     * @see com.smartgwt.client.widgets.grid.ListGrid#setLinkTextProperty
     */
    public void setLinkText(String linkText) {
        setAttribute("linkText", linkText);
    }

    /**
     * The HTML to display in this row for fields with fieldType set to link. This overrides  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getLinkText linkText}.
     *
     *
     * @return String
     * @see com.smartgwt.client.types.ListGridFieldType
     * @see com.smartgwt.client.types.FieldType
     * @see com.smartgwt.client.widgets.grid.ListGridField#getLinkText
     * @see com.smartgwt.client.widgets.grid.ListGrid#getLinkTextProperty
     */
    public String getLinkText()  {
        return getAttributeAsString("linkText");
    }

    /**
     * Default property name denoting the single value to display for all fields of this row. If this property is set for some
     * record, the record will be displayed as a single  cell spanning every column in the grid, with contents set to the value
     * of this property.<br> Note: this attribute name is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSingleCellValueProperty singleCellValueProperty}.
     *
     * @param singleCellValue singleCellValue Default value is null
     */
    public void setSingleCellValue(String singleCellValue) {
        setAttribute("singleCellValue", singleCellValue);
    }

    /**
     * Default property name denoting the single value to display for all fields of this row. If this property is set for some
     * record, the record will be displayed as a single  cell spanning every column in the grid, with contents set to the value
     * of this property.<br> Note: this attribute name is governed by {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getSingleCellValueProperty singleCellValueProperty}.
     *
     *
     * @return String
     */
    public String getSingleCellValue()  {
        return getAttributeAsString("singleCellValue");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}




