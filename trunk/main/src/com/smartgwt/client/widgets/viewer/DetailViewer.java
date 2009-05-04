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
        
    }

    public DetailViewer(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.DetailViewer.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

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
     *
     */
    public String getFieldIdProperty()  {
        return getAttributeAsString("fieldIdProperty");
    }

    /**
    * The number of records to display in a block. A block is a horizontal row on a page&#010          containing one or more records, as specified by the value of recordsPerBlock. The&#010          height of a block is equal to the height of a single record. The default setting of&#010          1 causes each record to appear by itself in a vertical row. Setting recordsPerBlock&#010          to 2 would cause records to appear side by side in groups of two.&#010          Use a value of "*" to indicate all records.
    *
    * @param recordsPerBlock recordsPerBlock Default value is 1
    */
    public void setRecordsPerBlock(int recordsPerBlock) {
        setAttribute("recordsPerBlock", recordsPerBlock, true);
    }
    /**
     * The number of records to display in a block. A block is a horizontal row on a page&#010          containing one or more records, as specified by the value of recordsPerBlock. The&#010          height of a block is equal to the height of a single record. The default setting of&#010          1 causes each record to appear by itself in a vertical row. Setting recordsPerBlock&#010          to 2 would cause records to appear side by side in groups of two.&#010          Use a value of "*" to indicate all records.
     *
     *
     * @return int
     *
     */
    public int getRecordsPerBlock()  {
        return getAttributeAsInt("recordsPerBlock");
    }

    /**
    * A string (HTML acceptable) that will be written to a page to separate blocks.
    *
    * @param blockSeparator blockSeparator Default value is "<BR><BR>"
    */
    public void setBlockSeparator(String blockSeparator) {
        setAttribute("blockSeparator", blockSeparator, true);
    }
    /**
     * A string (HTML acceptable) that will be written to a page to separate blocks.
     *
     *
     * @return String
     *
     */
    public String getBlockSeparator()  {
        return getAttributeAsString("blockSeparator");
    }

    /**
    * Whether to show the field when the value is null
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showEmptyField showEmptyField Default value is true
    */
    public void setShowEmptyField(Boolean showEmptyField) {
        setAttribute("showEmptyField", showEmptyField, true);
    }
    /**
     * Whether to show the field when the value is null
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowEmptyField()  {
        return getAttributeAsBoolean("showEmptyField");
    }

    /**
    * Text to show for an empty cell
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param emptyCellValue emptyCellValue Default value is "&nbsp;"
    */
    public void setEmptyCellValue(String emptyCellValue) {
        setAttribute("emptyCellValue", emptyCellValue, true);
    }
    /**
     * Text to show for an empty cell
     *
     *
     * @return String
     *
     */
    public String getEmptyCellValue()  {
        return getAttributeAsString("emptyCellValue");
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
     *
     */
    public String getLabelPrefix()  {
        return getAttributeAsString("labelPrefix");
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
     *
     */
    public String getLabelSuffix()  {
        return getAttributeAsString("labelSuffix");
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
     *
     */
    public Boolean getWrapLabel()  {
        return getAttributeAsBoolean("wrapLabel");
    }

    /**
    * Whether values should be allowed to wrap by default, or should be shown on one line&#010 regardless of length.
    *
    * @param wrapValues wrapValues Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setWrapValues(Boolean wrapValues)  throws IllegalStateException {
        setAttribute("wrapValues", wrapValues, false);
    }
    /**
     * Whether values should be allowed to wrap by default, or should be shown on one line&#010 regardless of length.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getWrapValues()  {
        return getAttributeAsBoolean("wrapValues");
    }

    /**
    * CSS style for the component as a whole.
    *
    * @param styleName styleName Default value is "detailViewer"
    */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }
    /**
     * CSS style for the component as a whole.
     *
     *
     * @return String
     *
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }

    /**
    * CSS style for each block (one record's worth of data).
    *
    * @param blockStyle blockStyle Default value is "detailBlock"
    */
    public void setBlockStyle(String blockStyle) {
        setAttribute("blockStyle", blockStyle, true);
    }
    /**
     * CSS style for each block (one record's worth of data).
     *
     *
     * @return String
     *
     */
    public String getBlockStyle()  {
        return getAttributeAsString("blockStyle");
    }

    /**
    * CSS style for a normal detail label
    *
    * @param labelStyle labelStyle Default value is "detailLabel"
    */
    public void setLabelStyle(String labelStyle) {
        setAttribute("labelStyle", labelStyle, true);
    }
    /**
     * CSS style for a normal detail label
     *
     *
     * @return String
     *
     */
    public String getLabelStyle()  {
        return getAttributeAsString("labelStyle");
    }

    /**
    * CSS style for a normal value
    *
    * @param cellStyle cellStyle Default value is "detail"
    */
    public void setCellStyle(String cellStyle) {
        setAttribute("cellStyle", cellStyle, true);
    }
    /**
     * CSS style for a normal value
     *
     *
     * @return Return the CSS class for a cell. Default implementation calls&#010 {@link com.smartgwt.client.widgets.viewer.DetailViewerField#getCellStyle} on the field if defined, otherwise&#010 returns {@link com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle cellStyle}&#010
     *
     */
    public String getCellStyle()  {
        return getAttributeAsString("cellStyle");
    }

    /**
    * CSS style for a header
    *
    * @param headerStyle headerStyle Default value is "detailHeader"
    */
    public void setHeaderStyle(String headerStyle) {
        setAttribute("headerStyle", headerStyle, true);
    }
    /**
     * CSS style for a header
     *
     *
     * @return String
     *
     */
    public String getHeaderStyle()  {
        return getAttributeAsString("headerStyle");
    }

    /**
    * CSS style for a separator
    *
    * @param separatorStyle separatorStyle Default value is "detail"
    */
    public void setSeparatorStyle(String separatorStyle) {
        setAttribute("separatorStyle", separatorStyle, true);
    }
    /**
     * CSS style for a separator
     *
     *
     * @return String
     *
     */
    public String getSeparatorStyle()  {
        return getAttributeAsString("separatorStyle");
    }
             
    /**
    * Display format to use for fields specified as type 'date'.  Default is to use the&#010 system-wide default normal date format, configured via&#010 {@link com.smartgwt.client..Date#setNormalDisplayFormat}.  Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat} to&#010 change the format used by this detailViewer.
    *
    * @param dateFormatter dateFormatter Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setDateFormatter(DateDisplayFormat dateFormatter)  throws IllegalStateException {
        setAttribute("dateFormatter", dateFormatter.getValue(), false);
    }
    /**
     * Display format to use for fields specified as type 'date'.  Default is to use the&#010 system-wide default normal date format, configured via&#010 {@link com.smartgwt.client..Date#setNormalDisplayFormat}.  Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat} to&#010 change the format used by this detailViewer.
     *
     *
     * @return DateDisplayFormat
     *
     */
    public DateDisplayFormat getDateFormatter()  {
        return (DateDisplayFormat) EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }

    /**
    * Show {@link com.smartgwt.client.widgets.viewer.DetailViewer#getEmptyMessage emptyMessage} when there is no data to display?
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param showEmptyMessage showEmptyMessage Default value is true
    */
    public void setShowEmptyMessage(Boolean showEmptyMessage) {
        setAttribute("showEmptyMessage", showEmptyMessage, true);
    }
    /**
     * Show {@link com.smartgwt.client.widgets.viewer.DetailViewer#getEmptyMessage emptyMessage} when there is no data to display?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowEmptyMessage()  {
        return getAttributeAsBoolean("showEmptyMessage");
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
     *
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
     *
     */
    public String getEmptyMessageStyle()  {
        return getAttributeAsString("emptyMessageStyle");
    }

    /**
    * The string to display in the body of a detailViewer which is loading records.
    *
    * @param loadingMessage loadingMessage Default value is "&nbsp;"
    */
    public void setLoadingMessage(String loadingMessage) {
        setAttribute("loadingMessage", loadingMessage, true);
    }
    /**
     * The string to display in the body of a detailViewer which is loading records.
     *
     *
     * @return String
     *
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
     *
     */
    public String getLoadingMessageStyle()  {
        return getAttributeAsString("loadingMessageStyle");
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
         * Get the index of the provided record.&#010 <P>&#010 Override in subclasses to provide more specific behaviour, for instance, when data holds a&#010 large number of records&#010&#010
         * @param record the record whose index is to be retrieved
         *
         * @return indexindex of the record, or -1 if not found
         */
        public native int getRecordIndex(Record record) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.getRecordIndex(record);
        }-*/;

    // ********************* Static Methods ***********************





    /**
     * An array of records, specifying data. Note that DetailViewers do not observe changes to the data array (in other
     * words they will not automatically re-draw when the data provided via this property is altered)
     *
     * @param data the data
     */
    public void setData(Record... data) {
        setAttribute("data", data, true);
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
     * The DataSource that this component should bind to for default fields and for performing&#010 DataSource
     * requests.
     *
     * @param dataSource dataSource Default value is null
     */
    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link com.smartgwt.client.data.DSRequest}. <P> Can be specified as either a DataSource instance or the String ID of a DataSource.
     *
     * @return DataSource
     */
    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }    

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

}



