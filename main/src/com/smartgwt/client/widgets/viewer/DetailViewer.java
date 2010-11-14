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
 
package com.smartgwt.client.widgets.viewer;



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
 * Displays one or more records "horizontally" with one property per line.
 */
public class DetailViewer extends Canvas  implements DataBoundComponent {

    public static DetailViewer getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (DetailViewer) obj;
        } else {
            return new DetailViewer(jsObj);
        }
    }

    public DetailViewer(){
        scClassName = "DetailViewer";
    }

    public DetailViewer(JavaScriptObject jsObj){
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
     * A string (HTML acceptable) that will be written to a page to separate blocks.
     *
     * @param blockSeparator blockSeparator Default value is "<BR><BR>"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBlockSeparator(String blockSeparator) {
        setAttribute("blockSeparator", blockSeparator, true);
    }

    /**
     * A string (HTML acceptable) that will be written to a page to separate blocks.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBlockSeparator()  {
        return getAttributeAsString("blockSeparator");
    }

    /**
     * CSS style for each block (one record's worth of data).
     *
     * @param blockStyle blockStyle Default value is "detailBlock"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBlockStyle(String blockStyle) {
        setAttribute("blockStyle", blockStyle, true);
    }

    /**
     * CSS style for each block (one record's worth of data).
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBlockStyle()  {
        return getAttributeAsString("blockStyle");
    }

    /**
     * CSS style for a normal value
     *
     * @param cellStyle cellStyle Default value is "detail"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setCellStyle(String cellStyle) {
        setAttribute("cellStyle", cellStyle, true);
    }

    /**
     * CSS style for a normal value
     *
     *
     * @return Return the CSS class for a cell. Default implementation calls {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getCellStyle getCellStyle()} on the field if defined, otherwise
     * returns {@link com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle this.cellStyle}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getCellStyle()  {
        return getAttributeAsString("cellStyle");
    }

    /**
     * Display format to use for fields specified as type 'date'.  Default is to use the system-wide default normal date
     * format, configured via  Date.setNormalDisplayFormat.  Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat} to change the format used by this detailViewer.
     *
     * @param dateFormatter dateFormatter Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDateFormatter(DateDisplayFormat dateFormatter)  throws IllegalStateException {
        setAttribute("dateFormatter", dateFormatter.getValue(), false);
    }

    /**
     * Display format to use for fields specified as type 'date'.  Default is to use the system-wide default normal date
     * format, configured via  Date.setNormalDisplayFormat.  Specify any valid {@link
     * com.smartgwt.client.types.DateDisplayFormat} to change the format used by this detailViewer.
     *
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
     * Display format to use for fields specified as type 'datetime'. Default is to use the system-wide default datetime format
     * configured via   Date.setShortDatetimeDisplayFormat
     *
     * @param datetimeFormatter datetimeFormatter Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDatetimeFormatter(DateDisplayFormat datetimeFormatter)  throws IllegalStateException {
        setAttribute("datetimeFormatter", datetimeFormatter.getValue(), false);
    }

    /**
     * Display format to use for fields specified as type 'datetime'. Default is to use the system-wide default datetime format
     * configured via   Date.setShortDatetimeDisplayFormat
     *
     *
     * @return DateDisplayFormat
     */
    public DateDisplayFormat getDatetimeFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("datetimeFormatter"));
    }

    /**
     * Text to show for an empty cell
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param emptyCellValue emptyCellValue Default value is "&nbsp;"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setEmptyCellValue(String emptyCellValue) {
        setAttribute("emptyCellValue", emptyCellValue, true);
    }

    /**
     * Text to show for an empty cell
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEmptyCellValue()  {
        return getAttributeAsString("emptyCellValue");
    }

    /**
     * The string to display in the body of a detailViewer with no records.
     *
     * @param emptyMessage emptyMessage Default value is "No items to display."
     */
    public void setEmptyMessage(String emptyMessage) {
        setAttribute("emptyMessage", emptyMessage, true);
    }

    /**
     * The string to display in the body of a detailViewer with no records.
     *
     *
     * @return String
     */
    public String getEmptyMessage()  {
        return getAttributeAsString("emptyMessage");
    }

    /**
     * CSS style to display this message in
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param emptyMessageStyle emptyMessageStyle Default value is "normal"
     */
    public void setEmptyMessageStyle(String emptyMessageStyle) {
        setAttribute("emptyMessageStyle", emptyMessageStyle, true);
    }

    /**
     * CSS style to display this message in
     *
     *
     * @return String
     */
    public String getEmptyMessageStyle()  {
        return getAttributeAsString("emptyMessageStyle");
    }

    /**
     * Name of the field in the DetailViewerRecord which specifies the data property for that record.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fieldIdProperty fieldIdProperty Default value is "name"
     */
    public void setFieldIdProperty(String fieldIdProperty) {
        setAttribute("fieldIdProperty", fieldIdProperty, true);
    }

    /**
     * Name of the field in the DetailViewerRecord which specifies the data property for that record.
     *
     *
     * @return String
     */
    public String getFieldIdProperty()  {
        return getAttributeAsString("fieldIdProperty");
    }

    /**
     * CSS style for a header
     *
     * @param headerStyle headerStyle Default value is "detailHeader"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeaderStyle(String headerStyle) {
        setAttribute("headerStyle", headerStyle, true);
    }

    /**
     * CSS style for a header
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHeaderStyle()  {
        return getAttributeAsString("headerStyle");
    }

    /**
     * text to put before a label
     *
     * @param labelPrefix labelPrefix Default value is ""
     */
    public void setLabelPrefix(String labelPrefix) {
        setAttribute("labelPrefix", labelPrefix, true);
    }

    /**
     * text to put before a label
     *
     *
     * @return String
     */
    public String getLabelPrefix()  {
        return getAttributeAsString("labelPrefix");
    }

    /**
     * CSS style for a normal detail label
     *
     * @param labelStyle labelStyle Default value is "detailLabel"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setLabelStyle(String labelStyle) {
        setAttribute("labelStyle", labelStyle, true);
    }

    /**
     * CSS style for a normal detail label
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getLabelStyle()  {
        return getAttributeAsString("labelStyle");
    }

    /**
     * text to put after a label
     *
     * @param labelSuffix labelSuffix Default value is ":"
     */
    public void setLabelSuffix(String labelSuffix) {
        setAttribute("labelSuffix", labelSuffix, true);
    }

    /**
     * text to put after a label
     *
     *
     * @return String
     */
    public String getLabelSuffix()  {
        return getAttributeAsString("labelSuffix");
    }

    /**
     * The string to display in the body of a detailViewer which is loading records. Use <code>"\${loadingImage}"</code> to
     * include {@link com.smartgwt.client.widgets.Canvas#loadingImageSrc a loading image}.
     *
     * @param loadingMessage loadingMessage Default value is "&amp;nbsp;\${loadingImage}"
     */
    public void setLoadingMessage(String loadingMessage) {
        setAttribute("loadingMessage", loadingMessage, true);
    }

    /**
     * The string to display in the body of a detailViewer which is loading records. Use <code>"\${loadingImage}"</code> to
     * include {@link com.smartgwt.client.widgets.Canvas#loadingImageSrc a loading image}.
     *
     *
     * @return String
     */
    public String getLoadingMessage()  {
        return getAttributeAsString("loadingMessage");
    }

    /**
     * CSS style to use for the {@link com.smartgwt.client.widgets.viewer.DetailViewer#getLoadingMessage loadingMessage}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param loadingMessageStyle loadingMessageStyle Default value is "normal"
     */
    public void setLoadingMessageStyle(String loadingMessageStyle) {
        setAttribute("loadingMessageStyle", loadingMessageStyle, true);
    }

    /**
     * CSS style to use for the {@link com.smartgwt.client.widgets.viewer.DetailViewer#getLoadingMessage loadingMessage}.
     *
     *
     * @return String
     */
    public String getLoadingMessageStyle()  {
        return getAttributeAsString("loadingMessageStyle");
    }

    /**
     * Optional CSS style for a cell in printable HTML for this component. If unset {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle cellStyle} will be used for printing as well as normal
     * presentation.
     *
     * @param printCellStyle printCellStyle Default value is null
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintCellStyle(String printCellStyle) {
        setAttribute("printCellStyle", printCellStyle, true);
    }

    /**
     * Optional CSS style for a cell in printable HTML for this component. If unset {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle cellStyle} will be used for printing as well as normal
     * presentation.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintCellStyle()  {
        return getAttributeAsString("printCellStyle");
    }

    /**
     * Optional CSS style for a header in printable HTML for this component. If unset {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHeaderStyle headerStyle} will be used for printing as well as normal
     * presentation.
     *
     * @param printHeaderStyle printHeaderStyle Default value is null
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintHeaderStyle(String printHeaderStyle) {
        setAttribute("printHeaderStyle", printHeaderStyle, true);
    }

    /**
     * Optional CSS style for a header in printable HTML for this component. If unset {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHeaderStyle headerStyle} will be used for printing as well as normal
     * presentation.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintHeaderStyle()  {
        return getAttributeAsString("printHeaderStyle");
    }

    /**
     * Optional CSS style for a label cell in printable HTML for this component. If unset {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getLabelStyle labelStyle} will be used for printing as well as normal
     * presentation.
     *
     * @param printLabelStyle printLabelStyle Default value is null
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintLabelStyle(String printLabelStyle) {
        setAttribute("printLabelStyle", printLabelStyle, true);
    }

    /**
     * Optional CSS style for a label cell in printable HTML for this component. If unset {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getLabelStyle labelStyle} will be used for printing as well as normal
     * presentation.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintLabelStyle()  {
        return getAttributeAsString("printLabelStyle");
    }

    /**
     * The number of records to display in a block. A block is a horizontal row on a page          containing one or more
     * records, as specified by the value of recordsPerBlock. The          height of a block is equal to the height of a single
     * record. The default setting of          1 causes each record to appear by itself in a vertical row. Setting
     * recordsPerBlock          to 2 would cause records to appear side by side in groups of two.          Use a value of "*"
     * to indicate all records.
     *
     * @param recordsPerBlock recordsPerBlock Default value is 1
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setRecordsPerBlock(int recordsPerBlock) {
        setAttribute("recordsPerBlock", recordsPerBlock, true);
    }

    /**
     * The number of records to display in a block. A block is a horizontal row on a page          containing one or more
     * records, as specified by the value of recordsPerBlock. The          height of a block is equal to the height of a single
     * record. The default setting of          1 causes each record to appear by itself in a vertical row. Setting
     * recordsPerBlock          to 2 would cause records to appear side by side in groups of two.          Use a value of "*"
     * to indicate all records.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getRecordsPerBlock()  {
        return getAttributeAsInt("recordsPerBlock");
    }

    /**
     * CSS style for a separator
     *
     * @param separatorStyle separatorStyle Default value is "detail"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSeparatorStyle(String separatorStyle) {
        setAttribute("separatorStyle", separatorStyle, true);
    }

    /**
     * CSS style for a separator
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSeparatorStyle()  {
        return getAttributeAsString("separatorStyle");
    }

    /**
     * Whether to show the field when the value is null
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showEmptyField showEmptyField Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowEmptyField(Boolean showEmptyField) {
        setAttribute("showEmptyField", showEmptyField, true);
    }

    /**
     * Whether to show the field when the value is null
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowEmptyField()  {
        return getAttributeAsBoolean("showEmptyField");
    }

    /**
     * Show {@link com.smartgwt.client.widgets.viewer.DetailViewer#getEmptyMessage emptyMessage} when there is no data to
     * display?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showEmptyMessage showEmptyMessage Default value is true
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setEmptyMessage
     */
    public void setShowEmptyMessage(Boolean showEmptyMessage) {
        setAttribute("showEmptyMessage", showEmptyMessage, true);
    }

    /**
     * Show {@link com.smartgwt.client.widgets.viewer.DetailViewer#getEmptyMessage emptyMessage} when there is no data to
     * display?
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getEmptyMessage
     */
    public Boolean getShowEmptyMessage()  {
        return getAttributeAsBoolean("showEmptyMessage");
    }

    /**
     * CSS style for the component as a whole.
     *
     * @param styleName styleName Default value is "detailViewer"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * CSS style for the component as a whole.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
     * Should the label be allowed to wrap, or be fixed to one line no matter how long
     *
     * @param wrapLabel wrapLabel Default value is false
     */
    public void setWrapLabel(Boolean wrapLabel) {
        setAttribute("wrapLabel", wrapLabel, true);
    }

    /**
     * Should the label be allowed to wrap, or be fixed to one line no matter how long
     *
     *
     * @return Boolean
     */
    public Boolean getWrapLabel()  {
        return getAttributeAsBoolean("wrapLabel");
    }

    /**
     * Whether values should be allowed to wrap by default, or should be shown on one line regardless of length.
     *
     * @param wrapValues wrapValues Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setWrapValues(Boolean wrapValues)  throws IllegalStateException {
        setAttribute("wrapValues", wrapValues, false);
    }

    /**
     * Whether values should be allowed to wrap by default, or should be shown on one line regardless of length.
     *
     *
     * @return Boolean
     */
    public Boolean getWrapValues()  {
        return getAttributeAsBoolean("wrapValues");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes. 
     *
     * @param detailViewerProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DetailViewer detailViewerProperties) /*-{
        $wnd.isc.DetailViewer.addProperties(detailViewerProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    }-*/;
        
    // ***********************************************************        


	
    /**
     * An array of records, specifying data. Note that DetailViewers do not observe changes to the data array (in other
     * words they will not automatically re-draw when the data provided via this property is altered)
     *
     * @param data the data
     */
    public void setData(DetailViewerRecord[] data) {
        setAttribute("data", data, true);
    }

    /**
     * An array of Record objects, specifying the data to be used to populate the DataBoundComponent. Note that not
     * all DataBoundComponents observe the changes to the data to redraw themselves. Refer to the version of setData
     * that accepts component specific records.
     *
     * @param data array of Record objects.
     * @see #setData(DetailViewerRecord[])   
     */
    public void setData(Record[] data) {
        setAttribute("data", data, true);
    }

    /**
     * An List of Record objects, specifying the data to be used to populate the DataBoundComponent. Note that not
     * all DataBoundComponents observe the changes to the data to redraw themselves. Refer to the version of setData
     * that accepts component specific records.
     *
     * @param data List of Records
     */
    public void setData(RecordList data) {
        setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }

    //TODO
    //public DetailViewerRecord[] getData()

    /**
     * An array of field objects, specifying the order and type of fields to display in this DetailViewer. In
     * DetailViewers, the fields specify rows.
     *
     * @param fields the fields
     */
    public void setFields(DetailViewerField... fields) {
        setAttribute("fields", fields, true);
    }

    //TODO getFields

    /**
     * If true, the set of fields given by the "default binding" (see DataBoundComponent.fields) is used, with any
     * fields specified in component.fields acting as overrides that can suppress or modify the display of individual
     * fields, without having to list the entire set of fields that should be shown.
     * <p/>
     * If component.fields contains fields that are not found in the DataSource, they will be shown after the most
     * recently referred to DataSource field. If the new fields appear first, they will be shown first.
     *
     * @param useAllDataSourceFields useAllDataSourceFields
     */
    public void setUseAllDataSourceFields(boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    /**
     * Displays the currently selected record(s) of the ListGrid in the detailViewer.
     *
     * @param selectionComponent the ListGrid whose currently selected record(s) is/are to be edited
     */
    public native void viewSelectedData(ListGrid selectionComponent) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selectionComponentJS = selectionComponent.@com.smartgwt.client.widgets.grid.ListGrid::getJsObj()();
        self.viewSelectedData(selectionComponentJS);
    }-*/;

    /**
     * Displays the currently selected record(s) of the ListGrid in the detailViewer.
     *
     * @param selectionComponentID the ID of a ListGrid whose currently selected record(s) is/are to be edited
     */
    public native void viewSelectedData(String selectionComponentID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.viewSelectedData(selectionComponentID);
    }-*/;



    // ********************* DataBoundComponent Properties / Attributes ***********************

    public void setDataFetchMode(FetchMode fetchMode) {
        setAttribute("dataFetchMode", fetchMode, true);
    }

    public FetchMode getDataFetchMode() {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }
    
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var hilitesJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(hilites);
        self.setHilites(hilitesJS);
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
        return @com.smartgwt.client.data.Hilite::convertToHiliteArray(Lcom/google/gwt/core/client/JavaScriptObject;)(hilitesJS);
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
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;

        if(ResultSet.isResultSet(dataJS)) {
            return getResultSet();
        }
        return new RecordList(dataJS);
    }

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource DataSource}
     * to  retrieve data that matches the current filter and sort criteria for this component, then  exports the resulting data
     * to a file or window in the requested format. <P> A variety of DSRequest settings, such as  {@link
     * com.smartgwt.client.data.DSRequest#getExportAs exportAs} and {@link com.smartgwt.client.data.DSRequest#getExportFilename
     * exportFilename}, affect the  exporting process: see {@link com.smartgwt.client.data.DSRequest#getExportResults
     * exportResults} for further detail. <P> Note that data exported via this method does not include any client-side
     * formatting and relies on both the Smart GWT server and server-side DataSources.  To export client-data  with formatters
     * applied,  see {@link com.smartgwt.client.widgets.DataBoundComponent#exportClientData exportClientData}, which still
     * requires the Smart GWT server but does not rely on server-side DataSources. <P> For more information on exporting data,
     * see {@link com.smartgwt.client.data.DataSource#exportData DataSource.exportData}.
     */
    public native void exportData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData();
    }-*/;

    /**
     * Uses a "fetch" operation on the current {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource DataSource}
     * to  retrieve data that matches the current filter and sort criteria for this component, then  exports the resulting data
     * to a file or window in the requested format. <P> A variety of DSRequest settings, such as  {@link
     * com.smartgwt.client.data.DSRequest#getExportAs exportAs} and {@link com.smartgwt.client.data.DSRequest#getExportFilename
     * exportFilename}, affect the  exporting process: see {@link com.smartgwt.client.data.DSRequest#getExportResults
     * exportResults} for further detail. <P> Note that data exported via this method does not include any client-side
     * formatting and relies on both the Smart GWT server and server-side DataSources.  To export client-data  with formatters
     * applied,  see {@link com.smartgwt.client.widgets.DataBoundComponent#exportClientData exportClientData}, which still
     * requires the Smart GWT server but does not rely on server-side DataSources. <P> For more information on exporting data,
     * see {@link com.smartgwt.client.data.DataSource#exportData DataSource.exportData}.
     * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void exportData(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    
   /**
    * Exports this component's data with client-side formatters applied, so is suitable for 
    * direct display to users.  This feature requires the SmartClient server, but does not 
    * rely on any server-side DataSources.
    * <P>To export unformatted data from this component's dataSource, see 
    * {@link com.smartgwt.client.widgets.DataBoundComponent#exportData exportData}
    * which does not include client-side formatters, 
    * but relies on both the SmartClient server and server-side DataSources.
    * @see com.smartgwt.client.data.DataSource#exportClientData
    */
    public native void exportClientData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData();
    }-*/;

   /**
    * Exports this component's data with client-side formatters applied, so is suitable for 
    * direct display to users.  This feature requires the SmartClient server, but does not 
    * rely on any server-side DataSources.
    * <P>To export unformatted data from this component's dataSource, see
    * {@link com.smartgwt.client.widgets.DataBoundComponent#exportData exportData}
    * which does not include client-side formatters, 
    * but relies on both the SmartClient server and server-side DataSources.
    * @param requestProperties Request properties for the export
    * @see com.smartgwt.client.data.DataSource#exportClientData
    */
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

}



