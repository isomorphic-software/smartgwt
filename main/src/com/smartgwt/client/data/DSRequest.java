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
 
package com.smartgwt.client.data;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
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

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Request sent to the server to initiate a  {@link com.smartgwt.client.docs.DataSourceOperations DataSource operation}. 
 * All properties which are legal on {@link com.smartgwt.client.rpc.RPCRequest} are legal, in addition to the properties
 * listed here.
 * @see com.smartgwt.client.rpc.RPCRequest
 */
@BeanFactory.FrameworkClass
public class DSRequest extends RPCRequest {

    public static DSRequest getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DSRequest(jsObj);
    }
        


    public DSRequest(){
        
    }

    public DSRequest(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public DSRequest(DSOperationType operationType) {
        setOperationType(operationType);
                
    }


    public DSRequest(DSOperationType operationType, String operationId) {
        setOperationType(operationType);
		setOperationId(operationId);
                
    }


    public DSRequest(DSOperationType operationType, Record data) {
        setOperationType(operationType);
		setData(data);
                
    }


    public DSRequest(DSOperationType operationType, String operationId, Record data) {
        setOperationType(operationType);
		setOperationId(operationId);
		setData(data);
                
    }


    public DSRequest(DSOperationType operationType, JavaScriptObject data) {
        setOperationType(operationType);
		setData(data);
                
    }


    public DSRequest(DSOperationType operationType, String operationId, JavaScriptObject data) {
        setOperationType(operationType);
		setOperationId(operationId);
		setData(data);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * For fetch, add or update operation, an optional comma separated list of fields to fetch from another,
     *  related DataSource.
     *  <P>
     *  Fields should be specified in the format 
     *  <code>"localFieldName!relatedDataSourceID.relatedDataSourceFieldName"</code>.
     *  where <code><i>relatedDataSourceID</i></code> is the ID of the related dataSource, and
     *  <code><i>relatedDataSourceFieldName</i></code> is the field for which you want to
     *  fetch related values. The returned field values will be stored on 
     *  the data returned to the client under the specified <code><i>localFieldName</i></code>.
     * Note that this will be applied in addition to any specified {@link com.smartgwt.client.data.DSRequest#getOutputs
     * outputs}.
     *  <P>
     * Note that as with {@link com.smartgwt.client.docs.serverds.DataSourceField#includeFrom DataSourceField.includeFrom}, the
     * related dataSource must be
     *  linked to the primary datasource via a foreignKey relationship.
     *  <P>
     *  Note additionalOutputs sent in request from the browser can be completely disabled in 
     *  {@link com.smartgwt.client.docs.Server_properties server.properties} by setting
     *  <code>datasource.allowClientAdditionalOutputs</code>:
     *  <pre>
     *      datasource.allowClientAdditionalOutputs: false
     *  </pre>
     * In this case {@link com.smartgwt.client.data.DSRequest#getAdditionalOutputs additionalOutputs} sent from the browser
     * will be cleared before 
     *  executing request. Note that programatically configured additionalOutputs are always allowed, but 
     *  you can't modify them from within a DMI method, so the only way to execute a request 
     *  with additionalOutputs that differ from what was sent by the client is to create a new DSRequest
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param additionalOutputs New additionalOutputs value. Default value is null
     */
    public void setAdditionalOutputs(String additionalOutputs) {
        setAttribute("additionalOutputs", additionalOutputs);
    }

    /**
     * For fetch, add or update operation, an optional comma separated list of fields to fetch from another,
     *  related DataSource.
     *  <P>
     *  Fields should be specified in the format 
     *  <code>"localFieldName!relatedDataSourceID.relatedDataSourceFieldName"</code>.
     *  where <code><i>relatedDataSourceID</i></code> is the ID of the related dataSource, and
     *  <code><i>relatedDataSourceFieldName</i></code> is the field for which you want to
     *  fetch related values. The returned field values will be stored on 
     *  the data returned to the client under the specified <code><i>localFieldName</i></code>.
     * Note that this will be applied in addition to any specified {@link com.smartgwt.client.data.DSRequest#getOutputs
     * outputs}.
     *  <P>
     * Note that as with {@link com.smartgwt.client.docs.serverds.DataSourceField#includeFrom DataSourceField.includeFrom}, the
     * related dataSource must be
     *  linked to the primary datasource via a foreignKey relationship.
     *  <P>
     *  Note additionalOutputs sent in request from the browser can be completely disabled in 
     *  {@link com.smartgwt.client.docs.Server_properties server.properties} by setting
     *  <code>datasource.allowClientAdditionalOutputs</code>:
     *  <pre>
     *      datasource.allowClientAdditionalOutputs: false
     *  </pre>
     * In this case {@link com.smartgwt.client.data.DSRequest#getAdditionalOutputs additionalOutputs} sent from the browser
     * will be cleared before 
     *  executing request. Note that programatically configured additionalOutputs are always allowed, but 
     *  you can't modify them from within a DMI method, so the only way to execute a request 
     *  with additionalOutputs that differ from what was sent by the client is to create a new DSRequest
     *
     * @return Current additionalOutputs value. Default value is null
     */
    public String getAdditionalOutputs()  {
        return getAttributeAsString("additionalOutputs");
    }
    
    
    

    /**
     * For requests submitted by a {@link com.smartgwt.client.widgets.DataBoundComponent}, the {@link
     * com.smartgwt.client.widgets.Canvas#getID Canvas.ID} of the submitting component. <P> This ID will be present for
     * operations including automatic saves by a ListGrid  {@link com.smartgwt.client.docs.Editing during editing}, or calls to
     * {@link com.smartgwt.client.widgets.form.DynamicForm#saveData form.saveData()}.  It will not be present for a direct call
     * to a DataSource method such as {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData()}. <P> Note
     * this is the component's <b>String</b> ID - you can retrieve the component itself via {@link
     * com.smartgwt.client.widgets.Canvas#getById Canvas.getById()}. <P> This property should be used for debugging purposes
     * only - do not use it to trigger differences in server-side behavior, instead, use {@link
     * com.smartgwt.client.data.DSRequest#getOperationId operationId} because only <code>operationId</code> is considered when
     * assessing {@link com.smartgwt.client.docs.DsRequestEquivalence request equivalence}.
     *
     * @param componentId New componentId value. Default value is null
     */
    public void setComponentId(String componentId) {
        setAttribute("componentId", componentId);
    }

    /**
     * For requests submitted by a {@link com.smartgwt.client.widgets.DataBoundComponent}, the {@link
     * com.smartgwt.client.widgets.Canvas#getID Canvas.ID} of the submitting component. <P> This ID will be present for
     * operations including automatic saves by a ListGrid  {@link com.smartgwt.client.docs.Editing during editing}, or calls to
     * {@link com.smartgwt.client.widgets.form.DynamicForm#saveData form.saveData()}.  It will not be present for a direct call
     * to a DataSource method such as {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData()}. <P> Note
     * this is the component's <b>String</b> ID - you can retrieve the component itself via {@link
     * com.smartgwt.client.widgets.Canvas#getById Canvas.getById()}. <P> This property should be used for debugging purposes
     * only - do not use it to trigger differences in server-side behavior, instead, use {@link
     * com.smartgwt.client.data.DSRequest#getOperationId operationId} because only <code>operationId</code> is considered when
     * assessing {@link com.smartgwt.client.docs.DsRequestEquivalence request equivalence}.
     *
     * @return Current componentId value. Default value is null
     */
    public String getComponentId()  {
        return getAttributeAsString("componentId");
    }
    
    

    /**
     * {@link com.smartgwt.client.data.DataSource#getDataProtocol DataProtocol} for this particular request. <P> <b>Note:</b>
     * Typically developers should use {@link com.smartgwt.client.data.DataSource#getOperationBindings operation bindings} to
     * specify an explicit data protocol for a request. <P> One exception: advanced developers may wish to have a custom 
     * {@link com.smartgwt.client.data.DataSource#transformRequest request transformer} with entirely client-side handling for
     * some requests. This may be achieved by setting the request's <code>dataProtocol</code> to {@link
     * com.smartgwt.client.types.DSProtocol "clientCustom"} within transformRequest, and also triggering application code which
     * will fire {@link com.smartgwt.client.data.DataSource#processResponse DataSource.processResponse()} when complete. <P>
     * The {@link com.smartgwt.client.data.DataSource#getDataProtocol DataSource.getDataProtocol()} method may be used to
     * determine what data protocol will be used to handle a specific request based on this property (if set), otherwise the
     * settings at the {@link com.smartgwt.client.data.OperationBinding#getDataProtocol operationBinding} or  {@link
     * com.smartgwt.client.data.DataSource#getDataProtocol dataSource} levels.
     *
     * @param dataProtocol New dataProtocol value. Default value is null
     */
    public void setDataProtocol(DSProtocol dataProtocol) {
        setAttribute("dataProtocol", dataProtocol == null ? null : dataProtocol.getValue());
    }

    /**
     * {@link com.smartgwt.client.data.DataSource#getDataProtocol DataProtocol} for this particular request. <P> <b>Note:</b>
     * Typically developers should use {@link com.smartgwt.client.data.DataSource#getOperationBindings operation bindings} to
     * specify an explicit data protocol for a request. <P> One exception: advanced developers may wish to have a custom 
     * {@link com.smartgwt.client.data.DataSource#transformRequest request transformer} with entirely client-side handling for
     * some requests. This may be achieved by setting the request's <code>dataProtocol</code> to {@link
     * com.smartgwt.client.types.DSProtocol "clientCustom"} within transformRequest, and also triggering application code which
     * will fire {@link com.smartgwt.client.data.DataSource#processResponse DataSource.processResponse()} when complete. <P>
     * The {@link com.smartgwt.client.data.DataSource#getDataProtocol DataSource.getDataProtocol()} method may be used to
     * determine what data protocol will be used to handle a specific request based on this property (if set), otherwise the
     * settings at the {@link com.smartgwt.client.data.OperationBinding#getDataProtocol operationBinding} or  {@link
     * com.smartgwt.client.data.DataSource#getDataProtocol dataSource} levels.
     *
     * @return Current dataProtocol value. Default value is null
     */
    public DSProtocol getDataProtocol()  {
        return EnumUtil.getEnum(DSProtocol.values(), getAttribute("dataProtocol"));
    }
    

    /**
     * DataSource this DSRequest will act on. <P> This property is generally automatically populated, for example when calling
     * {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData()} the dataSource property is set to the
     * target DataSource.
     *
     * @param dataSource New dataSource value. Default value is null
     */
    public void setDataSource(String dataSource) {
        setAttribute("dataSource", dataSource);
    }

    /**
     * DataSource this DSRequest will act on. <P> This property is generally automatically populated, for example when calling
     * {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData()} the dataSource property is set to the
     * target DataSource.
     *
     * @return Current dataSource value. Default value is null
     */
    public String getDataSource()  {
        return getAttributeAsString("dataSource");
    }
    

    /**
     * End row of requested results, used only with fetch operations. <p> Note that startRow and endRow are zero-based,
     * inclusive at the beginning and exclusive at the end (like substring), so startRow: 0, endRow: 1 is a request for the
     * first record.
     *
     * @param endRow New endRow value. Default value is null
     */
    public void setEndRow(Integer endRow) {
        setAttribute("endRow", endRow);
    }

    /**
     * End row of requested results, used only with fetch operations. <p> Note that startRow and endRow are zero-based,
     * inclusive at the beginning and exclusive at the end (like substring), so startRow: 0, endRow: 1 is a request for the
     * first record.
     *
     * @return Current endRow value. Default value is null
     */
    public Integer getEndRow()  {
        return getAttributeAsInt("endRow");
    }
    

    /**
     * The format in which the data should be exported.  See {@link com.smartgwt.client.types.ExportFormat} for more 
     * information.
     *
     * @param exportAs New exportAs value. Default value is "csv"
     */
    public void setExportAs(ExportFormat exportAs) {
        setAttribute("exportAs", exportAs == null ? null : exportAs.getValue());
    }

    /**
     * The format in which the data should be exported.  See {@link com.smartgwt.client.types.ExportFormat} for more 
     * information.
     *
     * @return Current exportAs value. Default value is "csv"
     */
    public ExportFormat getExportAs()  {
        return EnumUtil.getEnum(ExportFormat.values(), getAttribute("exportAs"));
    }
    

    /**
     * When using {@link com.smartgwt.client.rpc.RPCManager#exportContent RPCManager.exportContent()} to produce a .pdf from a
     * Smart GWT UI, this property allows  dynamic CSS to be passed to the server.  Since the <code>exportContent()</code>
     * system already provides  a way to specify a custom skin or additional stylesheet for export, <code>exportCSS</code>
     * should only be used for small bits of CSS that are necessarily dynamic. <p> For example, when printing a very wide page,
     * such as a grid with many columns or a very wide chart, you could send the string "@page {size: A4 landscape; }" as
     * <code>exportCSS</code> to cause the generated PDF to use landscape mode, so that all content fits without clipping.
     *
     * @param exportCSS New exportCSS value. Default value is null
     */
    public void setExportCSS(String exportCSS) {
        setAttribute("exportCSS", exportCSS);
    }

    /**
     * When using {@link com.smartgwt.client.rpc.RPCManager#exportContent RPCManager.exportContent()} to produce a .pdf from a
     * Smart GWT UI, this property allows  dynamic CSS to be passed to the server.  Since the <code>exportContent()</code>
     * system already provides  a way to specify a custom skin or additional stylesheet for export, <code>exportCSS</code>
     * should only be used for small bits of CSS that are necessarily dynamic. <p> For example, when printing a very wide page,
     * such as a grid with many columns or a very wide chart, you could send the string "@page {size: A4 landscape; }" as
     * <code>exportCSS</code> to cause the generated PDF to use landscape mode, so that all content fits without clipping.
     *
     * @return Current exportCSS value. Default value is null
     */
    public String getExportCSS()  {
        return getAttributeAsString("exportCSS");
    }
    

    /**
     * Only applies to request properties passed to {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData
     * ListGrid.exportClientData()}. If specified this property contains an arbitrary set of data to be exported.
     *
     * @param exportData New exportData value. Default value is null
     */
    public void setExportData(Record... exportData) {
        setAttribute("exportData", exportData);
    }

    /**
     * Only applies to request properties passed to {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData
     * ListGrid.exportClientData()}. If specified this property contains an arbitrary set of data to be exported.
     *
     * @return Current exportData value. Default value is null
     */
    public Record[] getExportData()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfRecord(getAttributeAsJavaScriptObject("exportData"));
    }
    

    /**
     * When exporting via {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()} to an
     * <code>XLS</code> or <code>OOXML</code> spreadsheet, forces dates to export as a string rather than a true date value.
     * <p> If a date value is provided to a spreadsheet as a string, Excel or other spreadsheet applications may not recognize
     * them as being date values that are valid for use in date-specific functions in formulas, filters, etc. <p> For this
     * reason, the default behavior of <code>exportClientData</code> is to provide date values to the spreadsheet as true date
     * values.  If {@link com.smartgwt.client.docs.FormatString Format Strings} are provided via properties like {@link
     * com.smartgwt.client.data.DataSourceField#getFormat dataSourceField.format} these will be translated to Excel /
     * OpenOffice format strings and used when generating spreadsheets.  Other formatting logic, such as {@link
     * com.smartgwt.client.widgets.grid.ListGridField#setCellFormatter cell formatters}, will not be used since they cannot be
     * automatically translated to an Excel format string.  If no translatable format string is available, date values will be
     * provided to the spreadsheet with no formatter and the spreadsheet program's default formatting for date values will be
     * used. <p> If <code>exportDatesAsFormattedString</code> is set to true, date fields will appear as strings that exactly
     * match the formatting shown in the {@link com.smartgwt.client.widgets.DataBoundComponent}. As noted above, this means the
     * spreadsheet program will not recognize the value as a date.
     *
     * @param exportDatesAsFormattedString New exportDatesAsFormattedString value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#setExportFormat
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public void setExportDatesAsFormattedString(Boolean exportDatesAsFormattedString) {
        setAttribute("exportDatesAsFormattedString", exportDatesAsFormattedString);
    }

    /**
     * When exporting via {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()} to an
     * <code>XLS</code> or <code>OOXML</code> spreadsheet, forces dates to export as a string rather than a true date value.
     * <p> If a date value is provided to a spreadsheet as a string, Excel or other spreadsheet applications may not recognize
     * them as being date values that are valid for use in date-specific functions in formulas, filters, etc. <p> For this
     * reason, the default behavior of <code>exportClientData</code> is to provide date values to the spreadsheet as true date
     * values.  If {@link com.smartgwt.client.docs.FormatString Format Strings} are provided via properties like {@link
     * com.smartgwt.client.data.DataSourceField#getFormat dataSourceField.format} these will be translated to Excel /
     * OpenOffice format strings and used when generating spreadsheets.  Other formatting logic, such as {@link
     * com.smartgwt.client.widgets.grid.ListGridField#setCellFormatter cell formatters}, will not be used since they cannot be
     * automatically translated to an Excel format string.  If no translatable format string is available, date values will be
     * provided to the spreadsheet with no formatter and the spreadsheet program's default formatting for date values will be
     * used. <p> If <code>exportDatesAsFormattedString</code> is set to true, date fields will appear as strings that exactly
     * match the formatting shown in the {@link com.smartgwt.client.widgets.DataBoundComponent}. As noted above, this means the
     * spreadsheet program will not recognize the value as a date.
     *
     * @return Current exportDatesAsFormattedString value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#getExportFormat
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public Boolean getExportDatesAsFormattedString()  {
        return getAttributeAsBoolean("exportDatesAsFormattedString", true);
    }
    

    /**
     * The character to use as a field-separator in CSV exports.  The default delimiter is comma.
     *
     * @param exportDelimiter New exportDelimiter value. Default value is ","
     */
    public void setExportDelimiter(String exportDelimiter) {
        setAttribute("exportDelimiter", exportDelimiter);
    }

    /**
     * The character to use as a field-separator in CSV exports.  The default delimiter is comma.
     *
     * @return Current exportDelimiter value. Default value is ","
     */
    public String getExportDelimiter()  {
        return getAttributeAsString("exportDelimiter");
    }
    

    /**
     * Specifies whether the exported data will be downloaded as an attachment or displayed in a  new browser window. See
     * {@link com.smartgwt.client.types.ExportDisplay} for more information.
     *
     * @param exportDisplay New exportDisplay value. Default value is "download"
     */
    public void setExportDisplay(ExportDisplay exportDisplay) {
        setAttribute("exportDisplay", exportDisplay == null ? null : exportDisplay.getValue());
    }

    /**
     * Specifies whether the exported data will be downloaded as an attachment or displayed in a  new browser window. See
     * {@link com.smartgwt.client.types.ExportDisplay} for more information.
     *
     * @return Current exportDisplay value. Default value is "download"
     */
    public ExportDisplay getExportDisplay()  {
        return EnumUtil.getEnum(ExportDisplay.values(), getAttribute("exportDisplay"));
    }
    

    /**
     * The list of field names to export.  If provided, the field list in the exported output is  limited and sorted as per the
     * list. <P> If exportFields is not provided: <ul> <li>If we are exporting via {@link
     * com.smartgwt.client.data.DSRequest#getExportData exportData()}, the field list in the exported output is every
     * non-hidden field defined in the DataSource, in DataSource definition order</li> <li>If we are exporting via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#exportClientData exportClientData()} and we are not  exporting to OOXML, or we
     * are exporting to OOXML but we are not  {@link com.smartgwt.client.data.DSRequest#getExportStreaming streaming}, the
     * field list in the exported output is based on the  client data sent up, taking every row into account (so if there is a
     * value for field "foo" only in row 57, we will output a column "foo", the cells of which are empty except for  row
     * 57)</li> <li>If we are exporting via {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData
     * exportClientData()} and we are  exporting to OOXML and streaming is in force (the default for OOXML), the field list in 
     * the exported output is based on the client data sent up, taking just the first row into  account (so if there is a value
     * for field "foo" only in row 57, we will not output a column "foo" at all)</li>  </ul>
     *
     * @param exportFields New exportFields value. Default value is null
     */
    public void setExportFields(String... exportFields) {
        setAttribute("exportFields", exportFields);
    }

    /**
     * The list of field names to export.  If provided, the field list in the exported output is  limited and sorted as per the
     * list. <P> If exportFields is not provided: <ul> <li>If we are exporting via {@link
     * com.smartgwt.client.data.DSRequest#getExportData exportData()}, the field list in the exported output is every
     * non-hidden field defined in the DataSource, in DataSource definition order</li> <li>If we are exporting via {@link
     * com.smartgwt.client.widgets.grid.ListGrid#exportClientData exportClientData()} and we are not  exporting to OOXML, or we
     * are exporting to OOXML but we are not  {@link com.smartgwt.client.data.DSRequest#getExportStreaming streaming}, the
     * field list in the exported output is based on the  client data sent up, taking every row into account (so if there is a
     * value for field "foo" only in row 57, we will output a column "foo", the cells of which are empty except for  row
     * 57)</li> <li>If we are exporting via {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData
     * exportClientData()} and we are  exporting to OOXML and streaming is in force (the default for OOXML), the field list in 
     * the exported output is based on the client data sent up, taking just the first row into  account (so if there is a value
     * for field "foo" only in row 57, we will not output a column "foo" at all)</li>  </ul>
     *
     * @return Current exportFields value. Default value is null
     */
    public String[] getExportFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("exportFields"));
    }
    

    /**
     * The name of the file to save the exported data into.  If  {@link
     * com.smartgwt.client.data.DSRequest#getExportToFilesystem exportToFilesystem} is set, this is the name of the  file the
     * server creates on its filesystem.  If {@link com.smartgwt.client.data.DSRequest#getExportToClient exportToClient} is
     * set, this is the filename that will appear to the browser. <p> If the exportFilename that you specify does not include
     * an extension, one will be added to it based on the {@link com.smartgwt.client.types.ExportFormat} specified by {@link
     * com.smartgwt.client.data.DSRequest#getExportAs exportAs}. Filename is forced to have the correct extension to work
     * around bugs in IE, but if you don't want the filename to be manipulated, use "custom" {@link
     * com.smartgwt.client.types.ExportFormat exportFormat}, see example.
     *
     * @param exportFilename New exportFilename value. Default value is null
     * @see com.smartgwt.client.data.DSRequest#setExportPath
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#custom_export_custom_response" target="examples">Custom Export (Custom Response) Example</a>
     */
    public void setExportFilename(String exportFilename) {
        setAttribute("exportFilename", exportFilename);
    }

    /**
     * The name of the file to save the exported data into.  If  {@link
     * com.smartgwt.client.data.DSRequest#getExportToFilesystem exportToFilesystem} is set, this is the name of the  file the
     * server creates on its filesystem.  If {@link com.smartgwt.client.data.DSRequest#getExportToClient exportToClient} is
     * set, this is the filename that will appear to the browser. <p> If the exportFilename that you specify does not include
     * an extension, one will be added to it based on the {@link com.smartgwt.client.types.ExportFormat} specified by {@link
     * com.smartgwt.client.data.DSRequest#getExportAs exportAs}. Filename is forced to have the correct extension to work
     * around bugs in IE, but if you don't want the filename to be manipulated, use "custom" {@link
     * com.smartgwt.client.types.ExportFormat exportFormat}, see example.
     *
     * @return Current exportFilename value. Default value is null
     * @see com.smartgwt.client.data.DSRequest#getExportPath
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#custom_export_custom_response" target="examples">Custom Export (Custom Response) Example</a>
     */
    public String getExportFilename()  {
        return getAttributeAsString("exportFilename");
    }
    

    /**
     * Optional text to appear at the end of the file.
     *
     * @param exportFooter New exportFooter value. Default value is null
     */
    public void setExportFooter(String exportFooter) {
        setAttribute("exportFooter", exportFooter);
    }

    /**
     * Optional text to appear at the end of the file.
     *
     * @return Current exportFooter value. Default value is null
     */
    public String getExportFooter()  {
        return getAttributeAsString("exportFooter");
    }
    

    /**
     * Optional text to appear at the beginning of the file.
     *
     * @param exportHeader New exportHeader value. Default value is null
     */
    public void setExportHeader(String exportHeader) {
        setAttribute("exportHeader", exportHeader);
    }

    /**
     * Optional text to appear at the beginning of the file.
     *
     * @return Current exportHeader value. Default value is null
     */
    public String getExportHeader()  {
        return getAttributeAsString("exportHeader");
    }
    

    /**
     * This property allows omitting column names from CSV and Excel exports (no effect on JSON or XML exports).
     *
     * @param exportHeaderless New exportHeaderless value. Default value is false
     */
    public void setExportHeaderless(Boolean exportHeaderless) {
        setAttribute("exportHeaderless", exportHeaderless);
    }

    /**
     * This property allows omitting column names from CSV and Excel exports (no effect on JSON or XML exports).
     *
     * @return Current exportHeaderless value. Default value is false
     */
    public Boolean getExportHeaderless()  {
        Boolean result = getAttributeAsBoolean("exportHeaderless", true);
        return result == null ? false : result;
    }
    

    /**
     * The image format in which the SVG graphic should be exported.
     *
     * @param exportImageFormat New exportImageFormat value. Default value is "png"
     */
    public void setExportImageFormat(ExportImageFormat exportImageFormat) {
        setAttribute("exportImageFormat", exportImageFormat == null ? null : exportImageFormat.getValue());
    }

    /**
     * The image format in which the SVG graphic should be exported.
     *
     * @return Current exportImageFormat value. Default value is "png"
     */
    public ExportImageFormat getExportImageFormat()  {
        return EnumUtil.getEnum(ExportImageFormat.values(), getAttribute("exportImageFormat"));
    }
    

    /**
     * If exporting in {@link com.smartgwt.client.types.ExportImageFormat JPEG format}, the output JPEG quality level. This is
     * a number from 0 to 1, with 1 representing the best quality and 0 representing the least quality but smallest file size.
     *
     * @param exportImageQuality New exportImageQuality value. Default value is null
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public void setExportImageQuality(Float exportImageQuality) {
        setAttribute("exportImageQuality", exportImageQuality);
    }

    /**
     * If exporting in {@link com.smartgwt.client.types.ExportImageFormat JPEG format}, the output JPEG quality level. This is
     * a number from 0 to 1, with 1 representing the best quality and 0 representing the least quality but smallest file size.
     *
     * @return Current exportImageQuality value. Default value is null
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public Float getExportImageQuality()  {
        return getAttributeAsFloat("exportImageQuality");
    }

    /**
     * If exporting in {@link com.smartgwt.client.types.ExportImageFormat JPEG format}, the output JPEG quality level. This is
     * a number from 0 to 1, with 1 representing the best quality and 0 representing the least quality but smallest file size.
     *
     * @param exportImageQuality New exportImageQuality value. Default value is null
     */
    public void setExportImageQuality(Double exportImageQuality) {
        setAttribute("exportImageQuality", exportImageQuality);
    }

    /**
     * If exporting in {@link com.smartgwt.client.types.ExportImageFormat JPEG format}, the output JPEG quality level. This is
     * a number from 0 to 1, with 1 representing the best quality and 0 representing the least quality but smallest file size.
     *
     * @return Current exportImageQuality value. Default value is null
     */
    public Double getExportImageQualityAsDouble()  {
        return getAttributeAsDouble("exportImageQuality");
    }
    

    /**
     * When exporting via {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()} to an
     * <code>XLS</code> or <code>OOXML</code> spreadsheet, forces numbers to export as a string rather than a true numerical
     * value. <p> If a number is provided to a spreadsheet as a string, Excel or other spreadsheet applications may not
     * recognize them as being numbers that are valid for use in numerical formulas, filters, etc. <p> For this reason, the
     * default behavior of <code>exportClientData</code> is to provide numerical values to the spreadsheet as true numbers.  If
     * {@link com.smartgwt.client.docs.FormatString Format Strings} are provided via properties like {@link
     * com.smartgwt.client.data.DataSourceField#getFormat dataSourceField.format} these will be translated to Excel /
     * OpenOffice format strings and used when generating spreadsheets.  Other formatting logic, such as {@link
     * com.smartgwt.client.widgets.grid.ListGridField#setCellFormatter cell formatters}, will not be used since they cannot be
     * automatically translated to an Excel format string.  If no translatable format string is available, numbers will be
     * provided to the spreadsheet with no formatter and the spreadsheet program's default formatting for numerical values will
     * be used. <p> If <code>exportNumbersAsFormattedString</code> is set to true, numbers will appear as strings that exactly
     * match the formatting shown in the {@link com.smartgwt.client.widgets.DataBoundComponent}. As noted above, this means the
     * spreadsheet program will not recognize the value as a number.
     *
     * @param exportNumbersAsFormattedString New exportNumbersAsFormattedString value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#setExportFormat
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public void setExportNumbersAsFormattedString(Boolean exportNumbersAsFormattedString) {
        setAttribute("exportNumbersAsFormattedString", exportNumbersAsFormattedString);
    }

    /**
     * When exporting via {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()} to an
     * <code>XLS</code> or <code>OOXML</code> spreadsheet, forces numbers to export as a string rather than a true numerical
     * value. <p> If a number is provided to a spreadsheet as a string, Excel or other spreadsheet applications may not
     * recognize them as being numbers that are valid for use in numerical formulas, filters, etc. <p> For this reason, the
     * default behavior of <code>exportClientData</code> is to provide numerical values to the spreadsheet as true numbers.  If
     * {@link com.smartgwt.client.docs.FormatString Format Strings} are provided via properties like {@link
     * com.smartgwt.client.data.DataSourceField#getFormat dataSourceField.format} these will be translated to Excel /
     * OpenOffice format strings and used when generating spreadsheets.  Other formatting logic, such as {@link
     * com.smartgwt.client.widgets.grid.ListGridField#setCellFormatter cell formatters}, will not be used since they cannot be
     * automatically translated to an Excel format string.  If no translatable format string is available, numbers will be
     * provided to the spreadsheet with no formatter and the spreadsheet program's default formatting for numerical values will
     * be used. <p> If <code>exportNumbersAsFormattedString</code> is set to true, numbers will appear as strings that exactly
     * match the formatting shown in the {@link com.smartgwt.client.widgets.DataBoundComponent}. As noted above, this means the
     * spreadsheet program will not recognize the value as a number.
     *
     * @return Current exportNumbersAsFormattedString value. Default value is null
     * @see com.smartgwt.client.data.DataSourceField#getExportFormat
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public Boolean getExportNumbersAsFormattedString()  {
        return getAttributeAsBoolean("exportNumbersAsFormattedString", true);
    }
    

    /**
     * If {@link com.smartgwt.client.data.DSRequest#getExportToFilesystem exportToFilesystem} is set, optionally specifies a 
     * path to use when saving the file.  This path is relative to the default export path, which is set using the {@link
     * com.smartgwt.client.docs.Server_properties server.properties} setting <code>export.location</code>; this is the project
     * webRoot by default.  For example, with the default setting of  <code>export.location</code>, an <code>exportPath</code>
     * of <code>"shared/ds"</code> and  an {@link com.smartgwt.client.data.DSRequest#getExportFilename exportFilename} of
     * <code>"exportedData.csv"</code>, Smart GWT Server would export to file <code>$webRoot/shared/ds/exportedData.csv</code>.
     * <p> If you do not specify this property, Smart GWT Server will export to the file indicated  by
     * <code>exportFilename</code> directly in the default export location. <p> This property is only applicable when {@link
     * com.smartgwt.client.data.DSRequest#getExportToFilesystem exportToFilesystem} is set.
     *
     * @param exportPath New exportPath value. Default value is null
     * @see com.smartgwt.client.data.DSRequest#setExportFilename
     */
    public void setExportPath(String exportPath) {
        setAttribute("exportPath", exportPath);
    }

    /**
     * If {@link com.smartgwt.client.data.DSRequest#getExportToFilesystem exportToFilesystem} is set, optionally specifies a 
     * path to use when saving the file.  This path is relative to the default export path, which is set using the {@link
     * com.smartgwt.client.docs.Server_properties server.properties} setting <code>export.location</code>; this is the project
     * webRoot by default.  For example, with the default setting of  <code>export.location</code>, an <code>exportPath</code>
     * of <code>"shared/ds"</code> and  an {@link com.smartgwt.client.data.DSRequest#getExportFilename exportFilename} of
     * <code>"exportedData.csv"</code>, Smart GWT Server would export to file <code>$webRoot/shared/ds/exportedData.csv</code>.
     * <p> If you do not specify this property, Smart GWT Server will export to the file indicated  by
     * <code>exportFilename</code> directly in the default export location. <p> This property is only applicable when {@link
     * com.smartgwt.client.data.DSRequest#getExportToFilesystem exportToFilesystem} is set.
     *
     * @return Current exportPath value. Default value is null
     * @see com.smartgwt.client.data.DSRequest#getExportFilename
     */
    public String getExportPath()  {
        return getAttributeAsString("exportPath");
    }
    

    /**
     * Determines the {@link com.smartgwt.client.types.PropertyIdentifier} to be used in the exported data.  This essentially
     * means, should we export internal field names like "countryCode" or "EMPLOYEE_NO", or localized descriptive field titles
     * like "code du pays" or "Employee Number".  This setting has a lot in common with {@link
     * com.smartgwt.client.data.DSRequest#getExportRawValues exportRawValues}; both are largely dependent on whether the
     * exported data is intended for direct consumption by an end user (in which case it is appropriate to export formatted
     * values and localized field titles), or for interface to some downstream computer system (in which case you probably want
     * raw, unformatted values and internal field names). <p> If this property is not set, the following defaults apply:<ul>
     * <li>If the export format is a native spreadsheet format (XLS or OOXML), localized field  titles are used</li> <li>If the
     * export format is CSV, XML or JSON and this is a client-driven export (ie it was initiated by a call to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#exportClientData exportClientData()}),  localized field titles are used</li>
     * <li>If the export format is CSV, XML or JSON and this is <b>not</b> a client-driven export, internal field names are
     * used</li>  </ul>
     *
     * @param exportPropertyIdentifier New exportPropertyIdentifier value. Default value is null
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public void setExportPropertyIdentifier(PropertyIdentifier exportPropertyIdentifier) {
        setAttribute("exportPropertyIdentifier", exportPropertyIdentifier == null ? null : exportPropertyIdentifier.getValue());
    }

    /**
     * Determines the {@link com.smartgwt.client.types.PropertyIdentifier} to be used in the exported data.  This essentially
     * means, should we export internal field names like "countryCode" or "EMPLOYEE_NO", or localized descriptive field titles
     * like "code du pays" or "Employee Number".  This setting has a lot in common with {@link
     * com.smartgwt.client.data.DSRequest#getExportRawValues exportRawValues}; both are largely dependent on whether the
     * exported data is intended for direct consumption by an end user (in which case it is appropriate to export formatted
     * values and localized field titles), or for interface to some downstream computer system (in which case you probably want
     * raw, unformatted values and internal field names). <p> If this property is not set, the following defaults apply:<ul>
     * <li>If the export format is a native spreadsheet format (XLS or OOXML), localized field  titles are used</li> <li>If the
     * export format is CSV, XML or JSON and this is a client-driven export (ie it was initiated by a call to {@link
     * com.smartgwt.client.widgets.grid.ListGrid#exportClientData exportClientData()}),  localized field titles are used</li>
     * <li>If the export format is CSV, XML or JSON and this is <b>not</b> a client-driven export, internal field names are
     * used</li>  </ul>
     *
     * @return Current exportPropertyIdentifier value. Default value is null
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public PropertyIdentifier getExportPropertyIdentifier()  {
        return EnumUtil.getEnum(PropertyIdentifier.values(), getAttribute("exportPropertyIdentifier"));
    }
    

    /**
     * Whether formatting settings should be applied to data being exported.  Default behavior and the effect of setting of
     * <code>exportRawValues</code> is described in the {@link com.smartgwt.client.docs.ExportFormatting Export Formatting
     * overview}.
     *
     * @param exportRawValues New exportRawValues value. Default value is null
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public void setExportRawValues(Boolean exportRawValues) {
        setAttribute("exportRawValues", exportRawValues);
    }

    /**
     * Whether formatting settings should be applied to data being exported.  Default behavior and the effect of setting of
     * <code>exportRawValues</code> is described in the {@link com.smartgwt.client.docs.ExportFormatting Export Formatting
     * overview}.
     *
     * @return Current exportRawValues value. Default value is null
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public Boolean getExportRawValues()  {
        return getAttributeAsBoolean("exportRawValues", true);
    }
    

    /**
     * When set, causes the results of the DSRequest to be exported to a file, whose name 
     *  and format are indicated by {@link com.smartgwt.client.data.DSRequest#getExportFilename exportFilename} and 
     * {@link com.smartgwt.client.data.DSRequest#getExportAs exportAs} respectively.  When no exportFilename is provided, the
     * default is
     *  <i>Results.csv</i> and the default value of exportAs is <i>csv</i>.  
     *  <P>
     * The export field-list can also be configured, see {@link com.smartgwt.client.data.DSRequest#getExportFields
     * exportFields}.  Formats 
     *  for exported date and numeric are controlled by several settings - see 
     *  {@link com.smartgwt.client.docs.ExportFormatting} for an overview.
     *  <P>
     * Once the operation completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay} specifies
     * whether the exported
     *  data should be downloaded to the file-system or displayed in a new window.  The default value
     *  of exportDisplay is "download" which displays the Save As dialog.  See {@link com.smartgwt.client.types.ExportDisplay} 
     *  for more information.
     *  <P>
     *  You can configure the style of {@link com.smartgwt.client.types.LineBreakStyle line-breaks} to use when 
     * generating the output, the {@link com.smartgwt.client.data.DSRequest#getExportDelimiter delimiter} to use when exporting
     *  to CSV and the {@link com.smartgwt.client.data.DSRequest#getExportTitleSeparatorChar separator-character} to use in 
     *  field-titles when exporting to XML.
     *  <P>
     *  Additionally, you can output arbitrary text before and after the exported data by setting 
     * {@link com.smartgwt.client.data.DSRequest#getExportHeader exportHeader} and {@link
     * com.smartgwt.client.data.DSRequest#getExportFooter exportFooter}.
     *  <P>
     *  Note that for security reasons, an export initiated using dsRequest properties does not
     *  provide support for JSON format (see 
     *  <a href="http://forums.smartclient.com/showthread.php?t=235">this post</a> for more detail). 
     *  However, you can use operationBinding.exportAs:"json" in a server-side .ds.xml file to force 
     *  JSON export to be allowed.
     *  <P>
     *  As well as setting dsRequest.exportResults and related properties, exports can be initiated
     *  in two other ways, via {@link com.smartgwt.client.data.OperationBinding}s and via custom server code which sets 
     *  export-related properties on the {@link com.smartgwt.client.data.DSResponse}.  Both of those methods support exporting
     *  to JSON format.
     *  <P>
     *  <b>Format Examples</b>
     *  XML format
     *  <pre>
     *      &lt;List&gt;
     *          &lt;Object&gt;
     *              &lt;id&gt;10101&lt;/id&gt;
     *              &lt;displayName&gt;Record 10101&lt;/displayName&gt;
     *          &lt;/Object&gt;
     *     &lt;/List&gt;
     *  </pre>
     *  JSON Format
     *  <pre>
     *      [
     *          { id: 10101, displayName: "Record 10101" }
     *      ]
     *  </pre>
     *  CSV Format
     *  <pre>
     *      id,displayName
     *      10101,"Record 10101"
     *  </pre>
     *
     * @param exportResults New exportResults value. Default value is false
     */
    public void setExportResults(Boolean exportResults) {
        setAttribute("exportResults", exportResults);
    }

    /**
     * When set, causes the results of the DSRequest to be exported to a file, whose name 
     *  and format are indicated by {@link com.smartgwt.client.data.DSRequest#getExportFilename exportFilename} and 
     * {@link com.smartgwt.client.data.DSRequest#getExportAs exportAs} respectively.  When no exportFilename is provided, the
     * default is
     *  <i>Results.csv</i> and the default value of exportAs is <i>csv</i>.  
     *  <P>
     * The export field-list can also be configured, see {@link com.smartgwt.client.data.DSRequest#getExportFields
     * exportFields}.  Formats 
     *  for exported date and numeric are controlled by several settings - see 
     *  {@link com.smartgwt.client.docs.ExportFormatting} for an overview.
     *  <P>
     * Once the operation completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay} specifies
     * whether the exported
     *  data should be downloaded to the file-system or displayed in a new window.  The default value
     *  of exportDisplay is "download" which displays the Save As dialog.  See {@link com.smartgwt.client.types.ExportDisplay} 
     *  for more information.
     *  <P>
     *  You can configure the style of {@link com.smartgwt.client.types.LineBreakStyle line-breaks} to use when 
     * generating the output, the {@link com.smartgwt.client.data.DSRequest#getExportDelimiter delimiter} to use when exporting
     *  to CSV and the {@link com.smartgwt.client.data.DSRequest#getExportTitleSeparatorChar separator-character} to use in 
     *  field-titles when exporting to XML.
     *  <P>
     *  Additionally, you can output arbitrary text before and after the exported data by setting 
     * {@link com.smartgwt.client.data.DSRequest#getExportHeader exportHeader} and {@link
     * com.smartgwt.client.data.DSRequest#getExportFooter exportFooter}.
     *  <P>
     *  Note that for security reasons, an export initiated using dsRequest properties does not
     *  provide support for JSON format (see 
     *  <a href="http://forums.smartclient.com/showthread.php?t=235">this post</a> for more detail). 
     *  However, you can use operationBinding.exportAs:"json" in a server-side .ds.xml file to force 
     *  JSON export to be allowed.
     *  <P>
     *  As well as setting dsRequest.exportResults and related properties, exports can be initiated
     *  in two other ways, via {@link com.smartgwt.client.data.OperationBinding}s and via custom server code which sets 
     *  export-related properties on the {@link com.smartgwt.client.data.DSResponse}.  Both of those methods support exporting
     *  to JSON format.
     *  <P>
     *  <b>Format Examples</b>
     *  XML format
     *  <pre>
     *      &lt;List&gt;
     *          &lt;Object&gt;
     *              &lt;id&gt;10101&lt;/id&gt;
     *              &lt;displayName&gt;Record 10101&lt;/displayName&gt;
     *          &lt;/Object&gt;
     *     &lt;/List&gt;
     *  </pre>
     *  JSON Format
     *  <pre>
     *      [
     *          { id: 10101, displayName: "Record 10101" }
     *      ]
     *  </pre>
     *  CSV Format
     *  <pre>
     *      id,displayName
     *      10101,"Record 10101"
     *  </pre>
     *
     * @return Current exportResults value. Default value is false
     */
    public Boolean getExportResults()  {
        Boolean result = getAttributeAsBoolean("exportResults", true);
        return result == null ? false : result;
    }
    

    /**
     * When you erxport a {@link com.smartgwt.client.widgets.grid.ListGrid} that has {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans}, should headerSpans also be exported.  See {@link
     * com.smartgwt.client.data.DSRequest#getExportSpanTitleSeparator exportSpanTitleSeparator} for details of of what it means
     * to export headerSpans to different export targets. <P>     Note that {@link
     * com.smartgwt.client.data.DSRequest#getExportPropertyIdentifier exportPropertyIdentifier} controls whether field names or
     * titles are appended to the headerSpan titles (and used for fields without headerSpans).
     *
     * @param exportShowHeaderSpanTitles New exportShowHeaderSpanTitles value. Default value is true
     */
    public void setExportShowHeaderSpanTitles(Boolean exportShowHeaderSpanTitles) {
        setAttribute("exportShowHeaderSpanTitles", exportShowHeaderSpanTitles);
    }

    /**
     * When you erxport a {@link com.smartgwt.client.widgets.grid.ListGrid} that has {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans}, should headerSpans also be exported.  See {@link
     * com.smartgwt.client.data.DSRequest#getExportSpanTitleSeparator exportSpanTitleSeparator} for details of of what it means
     * to export headerSpans to different export targets. <P>     Note that {@link
     * com.smartgwt.client.data.DSRequest#getExportPropertyIdentifier exportPropertyIdentifier} controls whether field names or
     * titles are appended to the headerSpan titles (and used for fields without headerSpans).
     *
     * @return Current exportShowHeaderSpanTitles value. Default value is true
     */
    public Boolean getExportShowHeaderSpanTitles()  {
        Boolean result = getAttributeAsBoolean("exportShowHeaderSpanTitles", true);
        return result == null ? true : result;
    }
    

    /**
     * When you export a {@link com.smartgwt.client.widgets.grid.ListGrid} that has {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} defined and {@link
     * com.smartgwt.client.data.DSRequest#getExportShowHeaderSpanTitles exportShowHeaderSpanTitles} is true, the behavior is
     * dependent on the export type.  Direct exports to Excel formats (both XLS and OOXML) place the  headerSpans in merged
     * cells in the spreadsheet, giving the same visual effect as the  original ListGrid.  This is not possible with exports to
     * CSV format; instead, we alter the  exported headers so that they contain the titles of the ancestor headerSpan(s). <p>
     * For example, if you had a field titled "Population" inside a headerSpan titled "National", nested inside another
     * headerSpan titled "Demographics", that would result in the exported field being titled "Demographics - National -
     * Population". <p> The <code>exportSpanTitleSeparator</code> property allows you to override the separator  string used
     * when constructing these amalgamated headers.
     *
     * @param exportSpanTitleSeparator New exportSpanTitleSeparator value. Default value is " - "
     */
    public void setExportSpanTitleSeparator(String exportSpanTitleSeparator) {
        setAttribute("exportSpanTitleSeparator", exportSpanTitleSeparator);
    }

    /**
     * When you export a {@link com.smartgwt.client.widgets.grid.ListGrid} that has {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getHeaderSpans headerSpans} defined and {@link
     * com.smartgwt.client.data.DSRequest#getExportShowHeaderSpanTitles exportShowHeaderSpanTitles} is true, the behavior is
     * dependent on the export type.  Direct exports to Excel formats (both XLS and OOXML) place the  headerSpans in merged
     * cells in the spreadsheet, giving the same visual effect as the  original ListGrid.  This is not possible with exports to
     * CSV format; instead, we alter the  exported headers so that they contain the titles of the ancestor headerSpan(s). <p>
     * For example, if you had a field titled "Population" inside a headerSpan titled "National", nested inside another
     * headerSpan titled "Demographics", that would result in the exported field being titled "Demographics - National -
     * Population". <p> The <code>exportSpanTitleSeparator</code> property allows you to override the separator  string used
     * when constructing these amalgamated headers.
     *
     * @return Current exportSpanTitleSeparator value. Default value is " - "
     */
    public String getExportSpanTitleSeparator()  {
        return getAttributeAsString("exportSpanTitleSeparator");
    }
    

    /**
     * When exporting to OOXML format (this is the standard file format used by Excel 2007 and  later), we default to using
     * streaming mode, for memory efficiency.  You can override this  for individual exports by setting this flag false.  You
     * may wish to do this if  you need to grab the spreadsheet object in a DMI and do something with it.  The underlying
     * object in  use - POI's <code>SXSSFWorkbook</code> - is intended for write only and cannot usefully be read. <p> You can
     * switch off Excel streaming altogether by setting "excel.useStreaming" false in  <code>server.properties</code>. <p>
     * Note, OOXML is the only native Excel format that supports streaming: when exporting to the older XLS format, we build
     * the spreadsheet in its entirety in server-side memory  before writing it to disk or returning it to the client.  This is
     * unlikely to change: streaming the XLS format is impractical bcause it is a self-referential binary format, and in any
     * case the problem of huge exports overflowing JVM memory is less likely to arise with  XLS, because it is innately
     * limited to 65535 rows.
     *
     * @param exportStreaming New exportStreaming value. Default value is true
     */
    public void setExportStreaming(boolean exportStreaming) {
        setAttribute("exportStreaming", exportStreaming);
    }

    /**
     * When exporting to OOXML format (this is the standard file format used by Excel 2007 and  later), we default to using
     * streaming mode, for memory efficiency.  You can override this  for individual exports by setting this flag false.  You
     * may wish to do this if  you need to grab the spreadsheet object in a DMI and do something with it.  The underlying
     * object in  use - POI's <code>SXSSFWorkbook</code> - is intended for write only and cannot usefully be read. <p> You can
     * switch off Excel streaming altogether by setting "excel.useStreaming" false in  <code>server.properties</code>. <p>
     * Note, OOXML is the only native Excel format that supports streaming: when exporting to the older XLS format, we build
     * the spreadsheet in its entirety in server-side memory  before writing it to disk or returning it to the client.  This is
     * unlikely to change: streaming the XLS format is impractical bcause it is a self-referential binary format, and in any
     * case the problem of huge exports overflowing JVM memory is less likely to arise with  XLS, because it is innately
     * limited to 65535 rows.
     *
     * @return Current exportStreaming value. Default value is true
     */
    public boolean getExportStreaming()  {
        Boolean result = getAttributeAsBoolean("exportStreaming", true);
        return result == null ? true : result;
    }
    

    /**
     * The character with which to replace spaces in field-titles when exporting to XML. If not specified in the request, the
     * server uses "".
     *
     * @param exportTitleSeparatorChar New exportTitleSeparatorChar value. Default value is null
     */
    public void setExportTitleSeparatorChar(String exportTitleSeparatorChar) {
        setAttribute("exportTitleSeparatorChar", exportTitleSeparatorChar);
    }

    /**
     * The character with which to replace spaces in field-titles when exporting to XML. If not specified in the request, the
     * server uses "".
     *
     * @return Current exportTitleSeparatorChar value. Default value is null
     */
    public String getExportTitleSeparatorChar()  {
        return getAttributeAsString("exportTitleSeparatorChar");
    }
    

    /**
     * If set, Smart GWT Server will export data back to the client, either as a file download  or as content in a new browser
     * window, depending on the setting of {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay}. <p> Note
     * that it is perfectly valid to specify both this property and  {@link
     * com.smartgwt.client.data.DSRequest#getExportToFilesystem exportToFilesystem}; in this case the data is both  exported to
     * a file on the server filesystem, and downloaded to the client.  If you specify  <em>neither</em> property, the export
     * no-ops.
     *
     * @param exportToClient New exportToClient value. Default value is true
     */
    public void setExportToClient(Boolean exportToClient) {
        setAttribute("exportToClient", exportToClient);
    }

    /**
     * If set, Smart GWT Server will export data back to the client, either as a file download  or as content in a new browser
     * window, depending on the setting of {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay}. <p> Note
     * that it is perfectly valid to specify both this property and  {@link
     * com.smartgwt.client.data.DSRequest#getExportToFilesystem exportToFilesystem}; in this case the data is both  exported to
     * a file on the server filesystem, and downloaded to the client.  If you specify  <em>neither</em> property, the export
     * no-ops.
     *
     * @return Current exportToClient value. Default value is true
     */
    public Boolean getExportToClient()  {
        Boolean result = getAttributeAsBoolean("exportToClient", true);
        return result == null ? true : result;
    }
    

    /**
     * If set, Smart GWT Server will export data to a file on the <b>server</b> filesystem.  The file we export to is
     * determined by the {@link com.smartgwt.client.data.DSRequest#getExportFilename exportFilename} and  {@link
     * com.smartgwt.client.data.DSRequest#getExportPath exportPath}.  Note that filesystem exports are disabled by  default,
     * for security reasons.  To enable them, set <code>export.allow.filesystem</code> to true in your
     * <code>server.properties</code> file.  If you enable filesystem exports, you  should also consider setting a default
     * export path, as described in the  {@link com.smartgwt.client.data.DSRequest#getExportPath exportPath} documentation. <p>
     * Note that it is perfectly valid to specify both this property and  {@link
     * com.smartgwt.client.data.DSRequest#getExportToClient exportToClient}; in this case the data is both exported to a file
     * on the server filesystem <em>and</em> downloaded to the client.  If you specify  <em>neither</em> property, the export
     * no-ops. <p> It is possible to redirect the filesystem export to make use of an <code>OutputStream</code> you provide. 
     * You use this when you want to make some use of the export document other than  writing it to a disk file - for example,
     * attaching it to an email or writing it to a  database table.  See the server-side Javadocs for
     * <code>DSRequest.setExportTo()</code>.
     *
     * @param exportToFilesystem New exportToFilesystem value. Default value is false
     */
    public void setExportToFilesystem(Boolean exportToFilesystem) {
        setAttribute("exportToFilesystem", exportToFilesystem);
    }

    /**
     * If set, Smart GWT Server will export data to a file on the <b>server</b> filesystem.  The file we export to is
     * determined by the {@link com.smartgwt.client.data.DSRequest#getExportFilename exportFilename} and  {@link
     * com.smartgwt.client.data.DSRequest#getExportPath exportPath}.  Note that filesystem exports are disabled by  default,
     * for security reasons.  To enable them, set <code>export.allow.filesystem</code> to true in your
     * <code>server.properties</code> file.  If you enable filesystem exports, you  should also consider setting a default
     * export path, as described in the  {@link com.smartgwt.client.data.DSRequest#getExportPath exportPath} documentation. <p>
     * Note that it is perfectly valid to specify both this property and  {@link
     * com.smartgwt.client.data.DSRequest#getExportToClient exportToClient}; in this case the data is both exported to a file
     * on the server filesystem <em>and</em> downloaded to the client.  If you specify  <em>neither</em> property, the export
     * no-ops. <p> It is possible to redirect the filesystem export to make use of an <code>OutputStream</code> you provide. 
     * You use this when you want to make some use of the export document other than  writing it to a disk file - for example,
     * attaching it to an email or writing it to a  database table.  See the server-side Javadocs for
     * <code>DSRequest.setExportTo()</code>.
     *
     * @return Current exportToFilesystem value. Default value is false
     */
    public Boolean getExportToFilesystem()  {
        Boolean result = getAttributeAsBoolean("exportToFilesystem", true);
        return result == null ? false : result;
    }
    

    /**
     * For server-side export with {@link com.smartgwt.client.types.ExportFormat} "xls" or "ooxml" only, timezone to use when
     * saving values from {@link com.smartgwt.client.types.FieldType} "datetime" to the spreadsheet. <p> This setting exists
     * because MS Excel&trade; has no concept of providing a true datetime value that is timezone-independent and will display
     * in the local timezone where the Excel program is launched.  Instead, datetime values must be provided as a rendered
     * string, which implies rendering in a particular timezone when the spreadsheet is generated. <p> <code>exportTZ</code>
     * can either be specified as a timezone offset in the same format expected by String (for example, "+01:00" for one hour
     * after GMT) or as the special constants "client" (meaning the current client display timezone) or "server" (meaning the
     * timezone of the server). <p> Default if unspecified is "server". <p> This setting does not affect fields of type "date"
     * or "time", which are timezone-independent values.  See {@link com.smartgwt.client.docs.DateFormatAndStorage} for more
     * information on how Smart GWT handles date, time and datetime values. <p> All non-spreadsheet export formats always use
     * UTC.  This setting also does not affect client-driven exports ({@link
     * com.smartgwt.client.data.DataSource#exportClientData DataSource.exportClientData()}), which always use client-side time.
     *
     * @param exportTZ New exportTZ value. Default value is null
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public void setExportTZ(String exportTZ) {
        setAttribute("exportTZ", exportTZ);
    }

    /**
     * For server-side export with {@link com.smartgwt.client.types.ExportFormat} "xls" or "ooxml" only, timezone to use when
     * saving values from {@link com.smartgwt.client.types.FieldType} "datetime" to the spreadsheet. <p> This setting exists
     * because MS Excel&trade; has no concept of providing a true datetime value that is timezone-independent and will display
     * in the local timezone where the Excel program is launched.  Instead, datetime values must be provided as a rendered
     * string, which implies rendering in a particular timezone when the spreadsheet is generated. <p> <code>exportTZ</code>
     * can either be specified as a timezone offset in the same format expected by String (for example, "+01:00" for one hour
     * after GMT) or as the special constants "client" (meaning the current client display timezone) or "server" (meaning the
     * timezone of the server). <p> Default if unspecified is "server". <p> This setting does not affect fields of type "date"
     * or "time", which are timezone-independent values.  See {@link com.smartgwt.client.docs.DateFormatAndStorage} for more
     * information on how Smart GWT handles date, time and datetime values. <p> All non-spreadsheet export formats always use
     * UTC.  This setting also does not affect client-driven exports ({@link
     * com.smartgwt.client.data.DataSource#exportClientData DataSource.exportClientData()}), which always use client-side time.
     *
     * @return Current exportTZ value. Default value is null
     * @see com.smartgwt.client.docs.ExportFormatting ExportFormatting overview and related methods
     */
    public String getExportTZ()  {
        return getAttributeAsString("exportTZ");
    }
    

    /**
     * This flag has a different meaning depending on whether you are doing a client-driven or server-driven export. <p> For
     * {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData exportClientData()} calls (client-driven), ordinarily
     * any fields that have a {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField} defined have
     * the value of that displayField exported, rather than the underlying value in the  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueField valueField}.  If you set the <code>exportValueFields</code>
     * property, we export both the underlying value and the displayField value. <p> Again for <code>exportClientData()</code>
     * calls, any fields that have a {@link com.smartgwt.client.widgets.grid.ListGridField#getValueMap valueMap} defined
     * ordinarily have the mapped value of the  field exported, rather than the underlying data value.  If you set the 
     * <code>exportValueFields</code> property, we instead export the underlying data value.   Note, there is only one field in
     * this scenario, not a <code>valueField</code> and a  separate <code>displayField</code>, so we export <b>either</b> the
     * underlying data value or the mapped value, not both as in the <code>displayField</code>/<code>valueField</code> case 
     * described above. <p> For {@link com.smartgwt.client.widgets.DataBoundComponent#exportData exportData()} calls
     * (server-driven), we ordinarily export the underlying data value of all fields.  However, if you set the 
     * <code>exportValueFields</code> property explicitly to <code>false</code>, any fields that have a DataSource-defined
     * {@link com.smartgwt.client.data.DataSourceField#getValueMap valueMap} will have the mapped value exported instead.  This
     * is similar to the client-side treatment of valueMaps, except that the defaults are reversed. <p> For
     * <code>exportData()</code> calls, if we encounter a field that has an in-record  {@link
     * com.smartgwt.client.data.DataSourceField#getDisplayField displayField} declared <i>in the DataSource</i>, by   default
     * we export both the underlying value and the display value, so you end up with two columns in the exported data for that
     * field.  You can influence this by setting  <code>exportValueFields</code> explicitly: if set <code>true</code> we export
     * only the  value field, and if set <code>false</code> we export only the display field.  Note, the  reason for the
     * similar but not identical behavior of this flag between <code>exportData()</code> and <code>exportClientData()</code> is
     * backwards compatibility.
     *
     * @param exportValueFields New exportValueFields value. Default value is null
     */
    public void setExportValueFields(Boolean exportValueFields) {
        setAttribute("exportValueFields", exportValueFields);
    }

    /**
     * This flag has a different meaning depending on whether you are doing a client-driven or server-driven export. <p> For
     * {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData exportClientData()} calls (client-driven), ordinarily
     * any fields that have a {@link com.smartgwt.client.widgets.grid.ListGridField#getDisplayField displayField} defined have
     * the value of that displayField exported, rather than the underlying value in the  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getValueField valueField}.  If you set the <code>exportValueFields</code>
     * property, we export both the underlying value and the displayField value. <p> Again for <code>exportClientData()</code>
     * calls, any fields that have a {@link com.smartgwt.client.widgets.grid.ListGridField#getValueMap valueMap} defined
     * ordinarily have the mapped value of the  field exported, rather than the underlying data value.  If you set the 
     * <code>exportValueFields</code> property, we instead export the underlying data value.   Note, there is only one field in
     * this scenario, not a <code>valueField</code> and a  separate <code>displayField</code>, so we export <b>either</b> the
     * underlying data value or the mapped value, not both as in the <code>displayField</code>/<code>valueField</code> case 
     * described above. <p> For {@link com.smartgwt.client.widgets.DataBoundComponent#exportData exportData()} calls
     * (server-driven), we ordinarily export the underlying data value of all fields.  However, if you set the 
     * <code>exportValueFields</code> property explicitly to <code>false</code>, any fields that have a DataSource-defined
     * {@link com.smartgwt.client.data.DataSourceField#getValueMap valueMap} will have the mapped value exported instead.  This
     * is similar to the client-side treatment of valueMaps, except that the defaults are reversed. <p> For
     * <code>exportData()</code> calls, if we encounter a field that has an in-record  {@link
     * com.smartgwt.client.data.DataSourceField#getDisplayField displayField} declared <i>in the DataSource</i>, by   default
     * we export both the underlying value and the display value, so you end up with two columns in the exported data for that
     * field.  You can influence this by setting  <code>exportValueFields</code> explicitly: if set <code>true</code> we export
     * only the  value field, and if set <code>false</code> we export only the display field.  Note, the  reason for the
     * similar but not identical behavior of this flag between <code>exportData()</code> and <code>exportClientData()</code> is
     * backwards compatibility.
     *
     * @return Current exportValueFields value. Default value is null
     */
    public Boolean getExportValueFields()  {
        return getAttributeAsBoolean("exportValueFields", true);
    }
    

    /**
     * A set of key:value pairs, mapping field names to expressions that will be evaluated 
     *  server-side to derive a value for that field.  This property allows for client-driven 
     *  {@link com.smartgwt.client.docs.TransactionChaining Transaction Chaining}, with some restrictions for security
     *  reasons:<ul>
     * <li>Normal {@link com.smartgwt.client.docs.serverds.OperationBinding#values server-side Transaction Chaining settings}
     * for a 
     *  field take precedence over this property, so server-defined rules cannot be overridden 
     *  from the client</li>
     *  <li>Arbitrary Velocity expressions are not allowed in DSRequests sent from the client 
     *  (<code>fieldValueExpressions</code> is also a valid property on a server-side DSRequest,
     *  and normal Velocity expressions <em>are</em> allowed in that case - see the server-side
     *  Javadoc for <code>DSRequest.setFieldValueExpressions()</code>).  For client-originated 
     *  requests, only the following bindings are allowed - see the 
     *  {@link com.smartgwt.client.docs.VelocitySupport Velocity overview} for details of what these values mean:<ul>
     *    <li>$currentDate</li>
     *    <li>$currentDateUTC</li>
     *    <li>$transactionDate</li>
     *    <li>$transactionDateUTC</li>
     *    <li>$userId</li>
     * <li>$masterId - see {@link com.smartgwt.client.docs.serverds.DSRequestModifier#value DSRequestModifier.value} for
     * details</li>
     *    <li>References to specific fields in prior responses, via $responseData.first and 
     *        $responseData.last, with or without parameters.  For example, 
     *        <b>$responseData.first("myDataSource", "fetch")[0].myField</b>.  See the
     *        {@link com.smartgwt.client.docs.VelocitySupport Velocity overview} for details of $responseData</li>
     *    <li>References to certain metadata properties of prior responses, via $responses.first 
     *        and $responses.last, with or without parameters.  For example, 
     *        <b>$responses.last("myDataSource", "fetch").totalRows</b>.  Note that the only 
     *        properties allowed in a client-driven <code>fieldValueExpression</code> are:
     *        "startRow", "endRow", "totalRows" and "status"; this restriction does not apply to 
     *        server-driven <code>fieldValueExpressions</code>.  See the Velocity overview for 
     *        details of $responses</li>
     *  </ul></li>
     * <li>Normal {@link com.smartgwt.client.docs.serverds.DataSourceField#editRequiresRole declarative security rules} apply:
     * if a
     *  field is not valid for writing, its <code>fieldValueExpression</code> will be ignored.
     *  Again, this only applies to client-originated requests.</li>
     *  </ul>
     *  Note, it is possible to globally disable <code>fieldValueExpression</code> in 
     *  client-originated requests by setting a flag in your <code>server.properties</code> file:
     *  <pre>   dataSource.allowClientFieldValueExpressions: false</pre>
     *
     * @param fieldValueExpressions New fieldValueExpressions value. Default value is null
     * @see com.smartgwt.client.docs.TransactionChaining TransactionChaining overview and related methods
     */
    public void setFieldValueExpressions(Map fieldValueExpressions) {
        setAttribute("fieldValueExpressions", fieldValueExpressions);
    }

    /**
     * A set of key:value pairs, mapping field names to expressions that will be evaluated 
     *  server-side to derive a value for that field.  This property allows for client-driven 
     *  {@link com.smartgwt.client.docs.TransactionChaining Transaction Chaining}, with some restrictions for security
     *  reasons:<ul>
     * <li>Normal {@link com.smartgwt.client.docs.serverds.OperationBinding#values server-side Transaction Chaining settings}
     * for a 
     *  field take precedence over this property, so server-defined rules cannot be overridden 
     *  from the client</li>
     *  <li>Arbitrary Velocity expressions are not allowed in DSRequests sent from the client 
     *  (<code>fieldValueExpressions</code> is also a valid property on a server-side DSRequest,
     *  and normal Velocity expressions <em>are</em> allowed in that case - see the server-side
     *  Javadoc for <code>DSRequest.setFieldValueExpressions()</code>).  For client-originated 
     *  requests, only the following bindings are allowed - see the 
     *  {@link com.smartgwt.client.docs.VelocitySupport Velocity overview} for details of what these values mean:<ul>
     *    <li>$currentDate</li>
     *    <li>$currentDateUTC</li>
     *    <li>$transactionDate</li>
     *    <li>$transactionDateUTC</li>
     *    <li>$userId</li>
     * <li>$masterId - see {@link com.smartgwt.client.docs.serverds.DSRequestModifier#value DSRequestModifier.value} for
     * details</li>
     *    <li>References to specific fields in prior responses, via $responseData.first and 
     *        $responseData.last, with or without parameters.  For example, 
     *        <b>$responseData.first("myDataSource", "fetch")[0].myField</b>.  See the
     *        {@link com.smartgwt.client.docs.VelocitySupport Velocity overview} for details of $responseData</li>
     *    <li>References to certain metadata properties of prior responses, via $responses.first 
     *        and $responses.last, with or without parameters.  For example, 
     *        <b>$responses.last("myDataSource", "fetch").totalRows</b>.  Note that the only 
     *        properties allowed in a client-driven <code>fieldValueExpression</code> are:
     *        "startRow", "endRow", "totalRows" and "status"; this restriction does not apply to 
     *        server-driven <code>fieldValueExpressions</code>.  See the Velocity overview for 
     *        details of $responses</li>
     *  </ul></li>
     * <li>Normal {@link com.smartgwt.client.docs.serverds.DataSourceField#editRequiresRole declarative security rules} apply:
     * if a
     *  field is not valid for writing, its <code>fieldValueExpression</code> will be ignored.
     *  Again, this only applies to client-originated requests.</li>
     *  </ul>
     *  Note, it is possible to globally disable <code>fieldValueExpression</code> in 
     *  client-originated requests by setting a flag in your <code>server.properties</code> file:
     *  <pre>   dataSource.allowClientFieldValueExpressions: false</pre>
     *
     * @return Current fieldValueExpressions value. Default value is null
     * @see com.smartgwt.client.docs.TransactionChaining TransactionChaining overview and related methods
     */
    public Map getFieldValueExpressions()  {
        return getAttributeAsMap("fieldValueExpressions");
    }
    

    /**
     * Specifies should related updates have to be generated. If not set (or set to <code>null</code>) then related updates
     * will be generated only for "add" and "update" operations. This property has to be explicitly set to <code>true</code> to
     * generate related updates for "remove" operation.<p/> This functionality loads related objects from database thus
     * affecting operation performance. For "add" and "update" operations related objects are loaded anyway and performance
     * impact is minimal. Simple "remove" operation does not need to load related objects. Depending on database structure
     * performance impact can be significant if this property is set to <code>true</code>. <P> Note this feature works only
     * with Hibernate/JPA data sources, see  {@link com.smartgwt.client.docs.JpaHibernateRelations JPA & Hibernate Relations}
     * for instructions how to  set up relations. Table below uses "country -&gt; cities" sample data model. <P> <table
     * border=1 class="normal">   <tr>     <td width="20%"><b>Relation and Operation type</b></td>     <td
     * width="40%"><b>Loading complete related objects</b></td>     <td width="40%"><b>Loading related IDs</b></td>   </tr>  
     * <tr>     <td><i>Many-to-one (cities -&gt; country): ADD/UPDATE</i></td>     <td>If operation affected country, for
     * example new city added with existing  countryId, then relatedUpdate is generated. Otherwise if city is added or updated
     * without  countryId set, relatedUpdate is not generated.<br> Note that if provided countryId does not exist, it is
     * created.</td>     <td>Same as with complete related objects, except if provided countryId does not exist,  then it is
     * <i>not</i> created, but reset to NULL.</td>   </tr>   <tr>     <td><i>Many-to-one (cities -&gt; country):
     * REMOVE</i></td>     <td colSpan=2>Removes record, depending on setting generates or not relatedUpdate for parent record.
     * For example if city record is removed and countryId is sent to the server in remove request, then  country record will
     * be generated in relatedUpdates.</td>   </tr>   <tr>     <td><i>One-to-many (country -&gt; cities): ADD/UPDATE</i></td>  
     * <td>If add or update operation provides value sets for cities as well as for country, then  cities are created/updated
     * if necessary and relatedUpdates are generated.<br> Note that all fields in cities value sets can be sent to server.    
     * <td>Same as with complete related objects, except you can only sent primary key values for cities.</td>   <tr>    
     * <td><i>One-to-many (country -&gt; cities): REMOVE</i></td>     <td colSpan=2>Removes country, depending on setting
     * returns or not relatedUpdates for the cities of removed country,  which can be either REMOVE operations of all cities if
     * cascade enabled, or UPDATE operations setting countryId=null to  all cities if cascade is disabled</td>   </tr> </table>
     * <P> Note that Many-to-Many works the same way as One-to-Many.
     *
     * @param generateRelatedUpdates New generateRelatedUpdates value. Default value is null
     */
    public void setGenerateRelatedUpdates(Boolean generateRelatedUpdates) {
        setAttribute("generateRelatedUpdates", generateRelatedUpdates);
    }

    /**
     * Specifies should related updates have to be generated. If not set (or set to <code>null</code>) then related updates
     * will be generated only for "add" and "update" operations. This property has to be explicitly set to <code>true</code> to
     * generate related updates for "remove" operation.<p/> This functionality loads related objects from database thus
     * affecting operation performance. For "add" and "update" operations related objects are loaded anyway and performance
     * impact is minimal. Simple "remove" operation does not need to load related objects. Depending on database structure
     * performance impact can be significant if this property is set to <code>true</code>. <P> Note this feature works only
     * with Hibernate/JPA data sources, see  {@link com.smartgwt.client.docs.JpaHibernateRelations JPA & Hibernate Relations}
     * for instructions how to  set up relations. Table below uses "country -&gt; cities" sample data model. <P> <table
     * border=1 class="normal">   <tr>     <td width="20%"><b>Relation and Operation type</b></td>     <td
     * width="40%"><b>Loading complete related objects</b></td>     <td width="40%"><b>Loading related IDs</b></td>   </tr>  
     * <tr>     <td><i>Many-to-one (cities -&gt; country): ADD/UPDATE</i></td>     <td>If operation affected country, for
     * example new city added with existing  countryId, then relatedUpdate is generated. Otherwise if city is added or updated
     * without  countryId set, relatedUpdate is not generated.<br> Note that if provided countryId does not exist, it is
     * created.</td>     <td>Same as with complete related objects, except if provided countryId does not exist,  then it is
     * <i>not</i> created, but reset to NULL.</td>   </tr>   <tr>     <td><i>Many-to-one (cities -&gt; country):
     * REMOVE</i></td>     <td colSpan=2>Removes record, depending on setting generates or not relatedUpdate for parent record.
     * For example if city record is removed and countryId is sent to the server in remove request, then  country record will
     * be generated in relatedUpdates.</td>   </tr>   <tr>     <td><i>One-to-many (country -&gt; cities): ADD/UPDATE</i></td>  
     * <td>If add or update operation provides value sets for cities as well as for country, then  cities are created/updated
     * if necessary and relatedUpdates are generated.<br> Note that all fields in cities value sets can be sent to server.    
     * <td>Same as with complete related objects, except you can only sent primary key values for cities.</td>   <tr>    
     * <td><i>One-to-many (country -&gt; cities): REMOVE</i></td>     <td colSpan=2>Removes country, depending on setting
     * returns or not relatedUpdates for the cities of removed country,  which can be either REMOVE operations of all cities if
     * cascade enabled, or UPDATE operations setting countryId=null to  all cities if cascade is disabled</td>   </tr> </table>
     * <P> Note that Many-to-Many works the same way as One-to-Many.
     *
     * @return Current generateRelatedUpdates value. Default value is null
     */
    public Boolean getGenerateRelatedUpdates()  {
        return getAttributeAsBoolean("generateRelatedUpdates", true);
    }
    

    /**
     * List of fields to group by when using {@link com.smartgwt.client.docs.ServerSummaries server-side summarization}. <p>
     * Valid only for an operation of type "fetch".  See the  {@link com.smartgwt.client.docs.ServerSummaries Server Summaries
     * overview} for details and examples of usage.
     *
     * @param groupBy New groupBy value. Default value is null
     * @see com.smartgwt.client.data.DSRequest#setSummaryFunctions
     * @see com.smartgwt.client.docs.ServerSummaries ServerSummaries overview and related methods
     */
    public void setGroupBy(String... groupBy) {
        setAttribute("groupBy", groupBy);
    }

    /**
     * List of fields to group by when using {@link com.smartgwt.client.docs.ServerSummaries server-side summarization}. <p>
     * Valid only for an operation of type "fetch".  See the  {@link com.smartgwt.client.docs.ServerSummaries Server Summaries
     * overview} for details and examples of usage.
     *
     * @return Current groupBy value. Default value is null
     * @see com.smartgwt.client.data.DSRequest#getSummaryFunctions
     * @see com.smartgwt.client.docs.ServerSummaries ServerSummaries overview and related methods
     */
    public String[] getGroupBy()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("groupBy"));
    }
    

    /**
     * For DataSources using SOAP messaging with a WSDL web service, data to be serialized to form SOAP headers, as a map from
     * the header part name to the data.  See {@link com.smartgwt.client.data.WSRequest#getHeaderData WSRequest.headerData} for
     * more information. <P> SOAP headers typically contain request metadata such as a session id for authentication, and so
     * <code>dsRequest.headerData</code> is typically populated by {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest()}, or, for data that applies to every request sent to the server, by {@link
     * com.smartgwt.client.data.WebService#getHeaderData WebService.getHeaderData()}. <P> Note that this only applies to SOAP
     * headers. General HTTP headers for requests may be modified using {@link
     * com.smartgwt.client.rpc.RPCRequest#getHttpHeaders RPCRequest.httpHeaders}.
     *
     * @param headerData New headerData value. Default value is null
     */
    public void setHeaderData(Map headerData) {
        setAttribute("headerData", headerData);
    }

    /**
     * For DataSources using SOAP messaging with a WSDL web service, data to be serialized to form SOAP headers, as a map from
     * the header part name to the data.  See {@link com.smartgwt.client.data.WSRequest#getHeaderData WSRequest.headerData} for
     * more information. <P> SOAP headers typically contain request metadata such as a session id for authentication, and so
     * <code>dsRequest.headerData</code> is typically populated by {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest()}, or, for data that applies to every request sent to the server, by {@link
     * com.smartgwt.client.data.WebService#getHeaderData WebService.getHeaderData()}. <P> Note that this only applies to SOAP
     * headers. General HTTP headers for requests may be modified using {@link
     * com.smartgwt.client.rpc.RPCRequest#getHttpHeaders RPCRequest.httpHeaders}.
     *
     * @return Current headerData value. Default value is null
     */
    public Map getHeaderData()  {
        return getAttributeAsMap("headerData");
    }
    

    /**
     * This property is for advanced use in integrating trees that  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand load data on demand} using data paging. When this flag is
     * set, a server fetch operation is expected to return all of the tree nodes that either match the provided criteria
     * <b>or</b> have one or more children that match the criteria. <p> A ResultTree with {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getFetchMode fetchMode:"paged"} and with {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getKeepParentsOnFilter keepParentsOnFilter} enabled will automatically set
     * this property to <code>true</code> on all DSRequests that it sends to the server. <p> Currently, no built-in server-side
     * connectors (SQL, JPA, Hibernate) implement support for the keepParentsOnFilter flag.
     *
     * @param keepParentsOnFilter New keepParentsOnFilter value. Default value is null
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     */
    public void setKeepParentsOnFilter(Boolean keepParentsOnFilter) {
        setAttribute("keepParentsOnFilter", keepParentsOnFilter);
    }

    /**
     * This property is for advanced use in integrating trees that  {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand load data on demand} using data paging. When this flag is
     * set, a server fetch operation is expected to return all of the tree nodes that either match the provided criteria
     * <b>or</b> have one or more children that match the criteria. <p> A ResultTree with {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getFetchMode fetchMode:"paged"} and with {@link
     * com.smartgwt.client.widgets.tree.ResultTree#getKeepParentsOnFilter keepParentsOnFilter} enabled will automatically set
     * this property to <code>true</code> on all DSRequests that it sends to the server. <p> Currently, no built-in server-side
     * connectors (SQL, JPA, Hibernate) implement support for the keepParentsOnFilter flag.
     *
     * @return Current keepParentsOnFilter value. Default value is null
     * @see com.smartgwt.client.docs.TreeDataBinding TreeDataBinding overview and related methods
     */
    public Boolean getKeepParentsOnFilter()  {
        return getAttributeAsBoolean("keepParentsOnFilter", true);
    }
    

    /**
     * The style of line-breaks to use in the exported output.  See {@link com.smartgwt.client.types.LineBreakStyle} for more
     * information.
     *
     * @param lineBreakStyle New lineBreakStyle value. Default value is null
     */
    public void setLineBreakStyle(String lineBreakStyle) {
        setAttribute("lineBreakStyle", lineBreakStyle);
    }

    /**
     * The style of line-breaks to use in the exported output.  See {@link com.smartgwt.client.types.LineBreakStyle} for more
     * information.
     *
     * @return Current lineBreakStyle value. Default value is null
     */
    public String getLineBreakStyle()  {
        return getAttributeAsString("lineBreakStyle");
    }
    

    /**
     * For an <code>update</code> or <code>remove</code> operation, the original values from the record that is being updated
     * or removed.  <code>oldValues</code> is automatically added to DSRequests submitted by DataBound Components.  Available
     * on the server via <code>DSRequest.getOldValues()</code>. <P> The server can compare the <code>oldValues</code> to the
     * most recent stored values in order to detect that the user was looking at stale values when the user submitted changes
     * (NOTE: this means of detecting concurrent edit is sometimes called "optimistic concurrency" or "long transactions").  
     * <P> In applications where a policy of "last update wins" is not appropriate when updating certain fields, special UI can
     * be shown for this case.  For example, on detecting concurrent edit, the server may send back a special
     * <code>dsResponse.status</code> code that the client application detects, offering the user a choice of proceeding with
     * the operation, discarding edits, or reconciling new and old values in a special interface.
     *
     * @param oldValues New oldValues value. Default value is null
     */
    public void setOldValues(Record oldValues) {
        setAttribute("oldValues", oldValues == null ? null : oldValues.getJsObj());
    }

    /**
     * For an <code>update</code> or <code>remove</code> operation, the original values from the record that is being updated
     * or removed.  <code>oldValues</code> is automatically added to DSRequests submitted by DataBound Components.  Available
     * on the server via <code>DSRequest.getOldValues()</code>. <P> The server can compare the <code>oldValues</code> to the
     * most recent stored values in order to detect that the user was looking at stale values when the user submitted changes
     * (NOTE: this means of detecting concurrent edit is sometimes called "optimistic concurrency" or "long transactions").  
     * <P> In applications where a policy of "last update wins" is not appropriate when updating certain fields, special UI can
     * be shown for this case.  For example, on detecting concurrent edit, the server may send back a special
     * <code>dsResponse.status</code> code that the client application detects, offering the user a choice of proceeding with
     * the operation, discarding edits, or reconciling new and old values in a special interface.
     *
     * @return Current oldValues value. Default value is null
     */
    public Record getOldValues()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("oldValues"));
    }
    

    /**
     * When a {@link com.smartgwt.client.widgets.DataBoundComponent} sends a DSRequest, the <code>dsRequest.operationId</code>
     * will be automatically picked up from the <code>fetchOperation</code>, <code>addOperation</code>, etc properties of the
     * DataBoundComponent.   <P> The <code>operationId</code> serves as an identifier that you can use to create variations on
     * the 4 basic DataSource operations that are used by different components in different parts of your application.  For
     * example, you may be using a standard <code>fetch</code> operation in one part of your application, however on another
     * screen you want to perform a <code>fetch</code> operation on the same DataSource but interpret search criteria
     * differently (eg full text search).   <P> If you declare more than one {@link com.smartgwt.client.data.OperationBinding}
     * for the same {@link com.smartgwt.client.data.OperationBinding#getOperationType OperationBinding.operationType}, you can
     * specify an <code>operationId</code> {@link com.smartgwt.client.data.OperationBinding#getOperationId on the
     * operationBinding} which will cause that operationBinding to be used for dsRequests containing a matching
     * <code>operationId</code>. This allows all the possible settings of an <code>operationBinding</code>, including {@link
     * com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation} or {@link com.smartgwt.client.docs.DmiOverview
     * DMI} settings, to be switched on a per-component or per-request basis.   <P> For example, by setting the
     * <code>fetchOperation</code> on a particular ListGrid, you could cause it to invoke a different server method via DMI,
     * different {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL} or different  {@link
     * com.smartgwt.client.data.OperationBinding#getWsOperation web service operation}. <P> The <code>operationId</code> can
     * also be directly received by the server in order to affect behavior.  When using the Smart GWT Server,
     * <code>operationId</code> can be accessed via dsRequest.getOperationId().  The {@link
     * com.smartgwt.client.data.RestDataSource} will also send the <code>operationId</code> to the server as part of the {@link
     * com.smartgwt.client.data.RestDataSource#getMetaDataPrefix request metadata}.   <P> Note that if you {@link
     * com.smartgwt.client.data.DataSource#fetchData manually invoke} a DataSource operation, you can also specify operationId
     * via the <code>requestProperties</code> parameter. <P> Note that the <code>operationId</code> has special significance in
     * terms of whether two DSRequests are considered equivalent for caching and synchronization purposes - see {@link
     * com.smartgwt.client.docs.DsRequestEquivalence}.
     *
     * @param operationId New operationId value. Default value is null
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public void setOperationId(String operationId) {
        setAttribute("operationId", operationId);
    }

    /**
     * When a {@link com.smartgwt.client.widgets.DataBoundComponent} sends a DSRequest, the <code>dsRequest.operationId</code>
     * will be automatically picked up from the <code>fetchOperation</code>, <code>addOperation</code>, etc properties of the
     * DataBoundComponent.   <P> The <code>operationId</code> serves as an identifier that you can use to create variations on
     * the 4 basic DataSource operations that are used by different components in different parts of your application.  For
     * example, you may be using a standard <code>fetch</code> operation in one part of your application, however on another
     * screen you want to perform a <code>fetch</code> operation on the same DataSource but interpret search criteria
     * differently (eg full text search).   <P> If you declare more than one {@link com.smartgwt.client.data.OperationBinding}
     * for the same {@link com.smartgwt.client.data.OperationBinding#getOperationType OperationBinding.operationType}, you can
     * specify an <code>operationId</code> {@link com.smartgwt.client.data.OperationBinding#getOperationId on the
     * operationBinding} which will cause that operationBinding to be used for dsRequests containing a matching
     * <code>operationId</code>. This allows all the possible settings of an <code>operationBinding</code>, including {@link
     * com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation} or {@link com.smartgwt.client.docs.DmiOverview
     * DMI} settings, to be switched on a per-component or per-request basis.   <P> For example, by setting the
     * <code>fetchOperation</code> on a particular ListGrid, you could cause it to invoke a different server method via DMI,
     * different {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL} or different  {@link
     * com.smartgwt.client.data.OperationBinding#getWsOperation web service operation}. <P> The <code>operationId</code> can
     * also be directly received by the server in order to affect behavior.  When using the Smart GWT Server,
     * <code>operationId</code> can be accessed via dsRequest.getOperationId().  The {@link
     * com.smartgwt.client.data.RestDataSource} will also send the <code>operationId</code> to the server as part of the {@link
     * com.smartgwt.client.data.RestDataSource#getMetaDataPrefix request metadata}.   <P> Note that if you {@link
     * com.smartgwt.client.data.DataSource#fetchData manually invoke} a DataSource operation, you can also specify operationId
     * via the <code>requestProperties</code> parameter. <P> Note that the <code>operationId</code> has special significance in
     * terms of whether two DSRequests are considered equivalent for caching and synchronization purposes - see {@link
     * com.smartgwt.client.docs.DsRequestEquivalence}.
     *
     * @return Current operationId value. Default value is null
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public String getOperationId()  {
        return getAttributeAsString("operationId");
    }
    

    /**
     * Type of operation being performed: "fetch", "add", "remove", "update" or "custom". <P> This property is generally
     * automatically populated, for example when calling <code>fetchData()</code> on a DataSource or DataBound component the
     * operationType is automatically set to "fetch".  Note that "custom" operations are never generated automatically, they
     * are always fired by your code.
     *
     * @param operationType New operationType value. Default value is null
     */
    public void setOperationType(DSOperationType operationType) {
        setAttribute("operationType", operationType == null ? null : operationType.getValue());
    }

    /**
     * Type of operation being performed: "fetch", "add", "remove", "update" or "custom". <P> This property is generally
     * automatically populated, for example when calling <code>fetchData()</code> on a DataSource or DataBound component the
     * operationType is automatically set to "fetch".  Note that "custom" operations are never generated automatically, they
     * are always fired by your code.
     *
     * @return Current operationType value. Default value is null
     */
    public DSOperationType getOperationType()  {
        return EnumUtil.getEnum(DSOperationType.values(), getAttribute("operationType"));
    }
    

    /**
     * The list of fields to return in the response, specified as a comma-separated string (eg, <code>"foo, bar, baz"</code>). 
     * You can use this property to indicate to the server that  you are only interested in a subset of the fields that would
     * normally be returned. <p> Note that you cannot use this property to request a <em>superset</em> of the fields that would
     * normally be returned, because that would be a security hole.  It is possible to  configure individual {@link
     * com.smartgwt.client.data.OperationBinding}s to return extra fields, but this must be done in the server's {@link
     * com.smartgwt.client.data.DataSource} descriptor; it cannot be altered on the fly from the client side.
     *
     * @param outputs New outputs value. Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#outputs
     * @see com.smartgwt.client.data.DSRequest#setAdditionalOutputs
     */
    public void setOutputs(String outputs) {
        setAttribute("outputs", outputs);
    }

    /**
     * The list of fields to return in the response, specified as a comma-separated string (eg, <code>"foo, bar, baz"</code>). 
     * You can use this property to indicate to the server that  you are only interested in a subset of the fields that would
     * normally be returned. <p> Note that you cannot use this property to request a <em>superset</em> of the fields that would
     * normally be returned, because that would be a security hole.  It is possible to  configure individual {@link
     * com.smartgwt.client.data.OperationBinding}s to return extra fields, but this must be done in the server's {@link
     * com.smartgwt.client.data.DataSource} descriptor; it cannot be altered on the fly from the client side.
     *
     * @return Current outputs value. Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#outputs
     * @see com.smartgwt.client.data.DSRequest#getAdditionalOutputs
     */
    public String getOutputs()  {
        return getAttributeAsString("outputs");
    }
    

    /**
     * For advanced use in integrating trees that  {@link com.smartgwt.client.widgets.tree.TreeGrid#getLoadDataOnDemand load
     * data on demand} with web services, <code>parentNode</code> is automatically set in "fetch" DSRequests issued by a
     * databound TreeGrid that is loading children for that <code>parentNode</code>. <P> This is sometimes needed if a web
     * service requires that additional properties beyond the ID of the parentNode must be passed in order to accomplished
     * level-by-level loading. A custom implementation of {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest()} can access dsRequest.parentNode and add any such properties to {@link
     * com.smartgwt.client.data.DSRequest#getData data}. <P> <code>parentNode</code> will also be automatically set by a
     * TreeGrid performing databound reparenting of nodes, as implemented by {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#folderDrop TreeGrid.folderDrop()}. <P> This property can only be read.  There
     * is no meaning to setting this property yourself.
     *
     * @return Current parentNode value. Default value is null
     */
    public TreeNode getParentNode()  {
        return TreeNode.getOrCreateRef(getAttributeAsJavaScriptObject("parentNode"));
    }
    

    /**
     * Indicates that a validation request is being made for a record that will ultimately be  saved with an "add" request, as
     * opposed to an "update" request.  This context is necessary for some validators because the nature of the validation
     * depends on whether we are adding or updating a record.  The system sets this flag when processing interim validations,
     * such as those fired when {@link com.smartgwt.client.widgets.form.DynamicForm#getValidateOnChange
     * DynamicForm.validateOnChange} is in force.
     *
     * @param pendingAdd New pendingAdd value. Default value is null
     */
    public void setPendingAdd(Boolean pendingAdd) {
        setAttribute("pendingAdd", pendingAdd);
    }

    /**
     * Indicates that a validation request is being made for a record that will ultimately be  saved with an "add" request, as
     * opposed to an "update" request.  This context is necessary for some validators because the nature of the validation
     * depends on whether we are adding or updating a record.  The system sets this flag when processing interim validations,
     * such as those fired when {@link com.smartgwt.client.widgets.form.DynamicForm#getValidateOnChange
     * DynamicForm.validateOnChange} is in force.
     *
     * @return Current pendingAdd value. Default value is null
     */
    public Boolean getPendingAdd()  {
        return getAttributeAsBoolean("pendingAdd", true);
    }
    

    /**
     * Sets {@link com.smartgwt.client.data.DataSource#getProgressiveLoading progressive loading mode} for this particular
     * request, overriding the OperationBinding- and DataSource-level settings. This setting overrides the {@link
     * com.smartgwt.client.docs.serverds.DataSource#progressiveLoadingThreshold progressiveLoadingThreshold} setting as well,
     * meaning that if <code>DSRequest.progressiveLoading</code> is explicitly set to <code>false</code> Smart GWT won't
     * automatically switch to loading data progressively even if <code>DataSource.progressiveLoadingThreshold</code> is
     * exceeded. <p> Note that this setting applies only to fetch requests - it has no effect if specified on any other kind of
     * request.
     *
     * @param progressiveLoading New progressiveLoading value. Default value is null
     * @see com.smartgwt.client.data.DataSource#setProgressiveLoading
     * @see com.smartgwt.client.docs.serverds.DataSource#progressiveLoadingThreshold
     * @see com.smartgwt.client.docs.serverds.OperationBinding#progressiveLoading
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public void setProgressiveLoading(Boolean progressiveLoading) {
        setAttribute("progressiveLoading", progressiveLoading);
    }

    /**
     * Sets {@link com.smartgwt.client.data.DataSource#getProgressiveLoading progressive loading mode} for this particular
     * request, overriding the OperationBinding- and DataSource-level settings. This setting overrides the {@link
     * com.smartgwt.client.docs.serverds.DataSource#progressiveLoadingThreshold progressiveLoadingThreshold} setting as well,
     * meaning that if <code>DSRequest.progressiveLoading</code> is explicitly set to <code>false</code> Smart GWT won't
     * automatically switch to loading data progressively even if <code>DataSource.progressiveLoadingThreshold</code> is
     * exceeded. <p> Note that this setting applies only to fetch requests - it has no effect if specified on any other kind of
     * request.
     *
     * @return Current progressiveLoading value. Default value is null
     * @see com.smartgwt.client.data.DataSource#getProgressiveLoading
     * @see com.smartgwt.client.docs.serverds.DataSource#progressiveLoadingThreshold
     * @see com.smartgwt.client.docs.serverds.OperationBinding#progressiveLoading
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public Boolean getProgressiveLoading()  {
        return getAttributeAsBoolean("progressiveLoading", true);
    }
    

    /**
     * Automatically generated unique ID for this request. This ID will be required by developers  making use of the {@link
     * com.smartgwt.client.types.DSProtocol "clientCustom" dataProtocol}.
     *
     * @return Current requestId value. Default value is varies
     */
    public String getRequestId()  {
        return getAttributeAsString("requestId");
    }
    

    /**
     * For advanced use in integrating dataset paging with web services, the ResultSet that issued this "fetch" DSRequest is
     * automatically made available as the <code>resultSet</code> property. <P> This property can only be read.  There is no
     * meaning to setting this property yourself.
     *
     * @return Current resultSet value. Default value is null
     */
    public ResultSet getResultSet()  {
        return ResultSet.getOrCreateRef(getAttributeAsJavaScriptObject("resultSet"));
    }
    

    /**
     * For advanced use in integrating trees that  {@link com.smartgwt.client.widgets.tree.ResultTree#getLoadDataOnDemand load
     * data on demand} with web services, the ResultTree that issued this "fetch" DSRequest is automatically made available as
     * the <code>resultTree</code> property. <P> This property can only be read.  There is no meaning to setting this property
     * yourself.
     *
     * @return Current resultTree value. Default value is null
     */
    public ResultTree getResultTree()  {
        return ResultTree.getOrCreateRef(getAttributeAsJavaScriptObject("resultTree"));
    }
    

    /**
     * This is a per-request flag for explicitly controlling whether the cache is used (bypassing it when not wanted, or using
     * it when settings would indicate otherwise). See  {@link com.smartgwt.client.data.DataSource#getCacheAllData
     * DataSource.cacheAllData}, {@link com.smartgwt.client.data.DataSource#getCacheAllOperationId
     * DataSource.cacheAllOperationId} and {@link com.smartgwt.client.data.DataSource#getCacheAcrossOperationIds
     * DataSource.cacheAcrossOperationIds} for caching management for all requests of a  dataSource.
     *
     * @param shouldUseCache New shouldUseCache value. Default value is null
     */
    public void setShouldUseCache(Boolean shouldUseCache) {
        setAttribute("shouldUseCache", shouldUseCache);
    }

    /**
     * This is a per-request flag for explicitly controlling whether the cache is used (bypassing it when not wanted, or using
     * it when settings would indicate otherwise). See  {@link com.smartgwt.client.data.DataSource#getCacheAllData
     * DataSource.cacheAllData}, {@link com.smartgwt.client.data.DataSource#getCacheAllOperationId
     * DataSource.cacheAllOperationId} and {@link com.smartgwt.client.data.DataSource#getCacheAcrossOperationIds
     * DataSource.cacheAcrossOperationIds} for caching management for all requests of a  dataSource.
     *
     * @return Current shouldUseCache value. Default value is null
     */
    public Boolean getShouldUseCache()  {
        return getAttributeAsBoolean("shouldUseCache", true);
    }
    
    

    /**
     * Starting row of requested results, used only with fetch operations.  If unset, 0 is assumed. <p> Note that startRow and
     * endRow are zero-based, inclusive at the beginning and exclusive at the end (like substring), so startRow: 0, endRow: 1
     * is a request for the first record.
     *
     * @param startRow New startRow value. Default value is null
     */
    public void setStartRow(Integer startRow) {
        setAttribute("startRow", startRow);
    }

    /**
     * Starting row of requested results, used only with fetch operations.  If unset, 0 is assumed. <p> Note that startRow and
     * endRow are zero-based, inclusive at the beginning and exclusive at the end (like substring), so startRow: 0, endRow: 1
     * is a request for the first record.
     *
     * @return Current startRow value. Default value is null
     */
    public Integer getStartRow()  {
        return getAttributeAsInt("startRow");
    }
    

    /**
     * If true, results will be streamed on the server, rather than all records being read into  server memory at once; this
     * approach is appropriate for retrieving or exporting large datasets without swamping the server.   <p> Although this
     * property can be set without any particular concerns (small datasets can be  streamed just as readily as large ones),
     * bear in mind that although streaming enables the processing of very large datasets, processing and downloading very
     * large datasets in a  normal client/server flow will very rarely give an acceptable user experience.  Streaming is of
     * more practical use in a batch setting - for example, a disconnected  {@link
     * com.smartgwt.client.data.DSRequest#getExportToFilesystem export}. <p> Note that streaming requires specific server
     * support; of Smart GWT's built-in DataSource types, only <code>SQLDataSource</code> is able to stream results.  This
     * property is ignored by other DataSource types.  If you wish to implement the necessary server-side behavior to  support
     * streaming with a custom DataSource, see the the server-side Javadocs for  <code>DSResponse.hasNextRecord()</code> and
     * <code>DSResponse.nextRecordAsObject()</code>. <p> See also the server-side documentation for <code>DSResponse</code>, 
     * <code>SQLDataSource</code> and <code>StreamingResponseIterator</code>. <p> Note, that streaming results does not support
     * fields with {@link com.smartgwt.client.types.SummaryFunctionType "concat" summary function}  on non-Oracle databases.
     * Such fields will be skipped.
     *
     * @param streamResults New streamResults value. Default value is false
     */
    public void setStreamResults(boolean streamResults) {
        setAttribute("streamResults", streamResults);
    }

    /**
     * If true, results will be streamed on the server, rather than all records being read into  server memory at once; this
     * approach is appropriate for retrieving or exporting large datasets without swamping the server.   <p> Although this
     * property can be set without any particular concerns (small datasets can be  streamed just as readily as large ones),
     * bear in mind that although streaming enables the processing of very large datasets, processing and downloading very
     * large datasets in a  normal client/server flow will very rarely give an acceptable user experience.  Streaming is of
     * more practical use in a batch setting - for example, a disconnected  {@link
     * com.smartgwt.client.data.DSRequest#getExportToFilesystem export}. <p> Note that streaming requires specific server
     * support; of Smart GWT's built-in DataSource types, only <code>SQLDataSource</code> is able to stream results.  This
     * property is ignored by other DataSource types.  If you wish to implement the necessary server-side behavior to  support
     * streaming with a custom DataSource, see the the server-side Javadocs for  <code>DSResponse.hasNextRecord()</code> and
     * <code>DSResponse.nextRecordAsObject()</code>. <p> See also the server-side documentation for <code>DSResponse</code>, 
     * <code>SQLDataSource</code> and <code>StreamingResponseIterator</code>. <p> Note, that streaming results does not support
     * fields with {@link com.smartgwt.client.types.SummaryFunctionType "concat" summary function}  on non-Oracle databases.
     * Such fields will be skipped.
     *
     * @return Current streamResults value. Default value is false
     */
    public boolean getStreamResults()  {
        Boolean result = getAttributeAsBoolean("streamResults", true);
        return result == null ? false : result;
    }
    
    

    /**
     * For "fetch" operations, how search criteria should be interpreted for text fields: one of "exact" for exact match,
     * "exactCase" for case-sensitive exact match, "startsWith" for  matching at the beginning only, or "substring" for
     * substring match.  All  <code>textMatchStyle</code> settings except "exactCase" are case-insensitive; use {@link
     * com.smartgwt.client.data.AdvancedCriteria} for greater control over matching. <p> This property defaults to the value of
     * {@link com.smartgwt.client.data.DataSource#getDefaultTextMatchStyle DataSource.defaultTextMatchStyle} if it is not
     * explicitly provided on the <code>DSRequest</code>.  Note, however, that DSRequests issued  by {@link
     * com.smartgwt.client.widgets.grid.ListGrid}s and other {@link com.smartgwt.client.widgets.DataBoundComponent components}
     * will generally have a  setting for textMatchStyle on the component itself  (see {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle ListGrid.autoFetchTextMatchStyle}, for example).
     * <p> This setting is respected by the built-in server-side connectors for SQL, JPA and Hibernate. A custom server-side
     * DataSource implementation should generally respect this flag as well, or server-side filtering will not match
     * client-side filtering, which will require {@link com.smartgwt.client.data.ResultSet#getUseClientFiltering disabling
     * client-side filtering}, a huge performance loss.
     *
     * @param textMatchStyle New textMatchStyle value. Default value is null
     */
    public void setTextMatchStyle(TextMatchStyle textMatchStyle) {
        setAttribute("textMatchStyle", textMatchStyle == null ? null : textMatchStyle.getValue());
    }

    /**
     * For "fetch" operations, how search criteria should be interpreted for text fields: one of "exact" for exact match,
     * "exactCase" for case-sensitive exact match, "startsWith" for  matching at the beginning only, or "substring" for
     * substring match.  All  <code>textMatchStyle</code> settings except "exactCase" are case-insensitive; use {@link
     * com.smartgwt.client.data.AdvancedCriteria} for greater control over matching. <p> This property defaults to the value of
     * {@link com.smartgwt.client.data.DataSource#getDefaultTextMatchStyle DataSource.defaultTextMatchStyle} if it is not
     * explicitly provided on the <code>DSRequest</code>.  Note, however, that DSRequests issued  by {@link
     * com.smartgwt.client.widgets.grid.ListGrid}s and other {@link com.smartgwt.client.widgets.DataBoundComponent components}
     * will generally have a  setting for textMatchStyle on the component itself  (see {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoFetchTextMatchStyle ListGrid.autoFetchTextMatchStyle}, for example).
     * <p> This setting is respected by the built-in server-side connectors for SQL, JPA and Hibernate. A custom server-side
     * DataSource implementation should generally respect this flag as well, or server-side filtering will not match
     * client-side filtering, which will require {@link com.smartgwt.client.data.ResultSet#getUseClientFiltering disabling
     * client-side filtering}, a huge performance loss.
     *
     * @return Current textMatchStyle value. Default value is null
     */
    public TextMatchStyle getTextMatchStyle()  {
        return EnumUtil.getEnum(TextMatchStyle.values(), getAttribute("textMatchStyle"));
    }
    

    /**
     * When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when
     *  creating the input XML message to send to the web service, properties in
     * {@link com.smartgwt.client.data.DSRequest#getData request.data} will be used as the values for XML elements of the same
     * name, at
     *  any level of nesting.
     *  <P>
     *  <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as
     *  extra levels of nested elements, and provides some insulation against changes in the
     *  required structure of the input message.
     *  <P>
     *  For example, given this input message:
     *  <pre>
     *  &lt;FindServices&gt;
     *      &lt;searchFor&gt;search text&lt;/searchFor&gt;
     *      &lt;Options&gt;
     *          &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;
     *      &lt;/Options&gt;
     *      &lt;IncludeInSearch&gt;
     *          &lt;serviceName&gt;true&lt;/serviceName&gt;
     *          &lt;documentation&gt;true&lt;/documentation&gt;
     *          &lt;keywords&gt;true&lt;/keywords&gt;
     *      &lt;/IncludeInSearch&gt;
     *  &lt;/FindServices&gt;
     *  </pre>
     *  If <code>useFlatFields</code> were <b>not</b> set, in order to fill out this message
     *  correctly, <code>request.data</code> would need to be:
     *  <pre>{
     *     searchFor: "search text",
     *     Options : {
     *         caseSensitive: false,
     *     },
     *     IncludeInSearch : {
     *         serviceName: true,
     *         documentation : true,
     *         keywords : true
     *     }
     *  }</pre>
     *  However if useFlatFields were set, <code>request.data</code> could be just:
     *  <pre>{
     *     searchFor: "search text",
     *     caseSensitive: false,
     *     serviceName: true,
     *     documentation : true,
     *     keywords : true
     *  }</pre>
     * <code>useFlatFields</code> is often set when the input data comes from a {@link
     * com.smartgwt.client.widgets.form.DynamicForm}
     *  to avoid the cumbersome and fragile process of mapping input fields to an XML structure.
     *  <P>
     * {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields OperationBinding.useFlatFields} can also be set to
     * cause <b>all</b> dsRequests of a
     *  particular type to <code>useFlatFields</code> automatically.
     *  <P>
     *  For {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}, 
     * {@link com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields component.useFlatFields} can be set use
     * "flattened"
     *  binding to fields of a WSDL message or XML Schema.
     *  <P>
     *  Note that <code>useFlatFields</code> is not generally recommended for use with XML input
     *  messages where multiple simple type fields exist with the same name, however if used in this
     *  way, the first field to use a given name wins.  "first" means the first field encountered in a
     *  depth first search.  "wins" means only the first field will be populated in the generated
     *  XML message.
     *
     * @param useFlatFields New useFlatFields value. Default value is null
     */
    public void setUseFlatFields(Boolean useFlatFields) {
        setAttribute("useFlatFields", useFlatFields);
    }

    /**
     * When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when
     *  creating the input XML message to send to the web service, properties in
     * {@link com.smartgwt.client.data.DSRequest#getData request.data} will be used as the values for XML elements of the same
     * name, at
     *  any level of nesting.
     *  <P>
     *  <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as
     *  extra levels of nested elements, and provides some insulation against changes in the
     *  required structure of the input message.
     *  <P>
     *  For example, given this input message:
     *  <pre>
     *  &lt;FindServices&gt;
     *      &lt;searchFor&gt;search text&lt;/searchFor&gt;
     *      &lt;Options&gt;
     *          &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;
     *      &lt;/Options&gt;
     *      &lt;IncludeInSearch&gt;
     *          &lt;serviceName&gt;true&lt;/serviceName&gt;
     *          &lt;documentation&gt;true&lt;/documentation&gt;
     *          &lt;keywords&gt;true&lt;/keywords&gt;
     *      &lt;/IncludeInSearch&gt;
     *  &lt;/FindServices&gt;
     *  </pre>
     *  If <code>useFlatFields</code> were <b>not</b> set, in order to fill out this message
     *  correctly, <code>request.data</code> would need to be:
     *  <pre>{
     *     searchFor: "search text",
     *     Options : {
     *         caseSensitive: false,
     *     },
     *     IncludeInSearch : {
     *         serviceName: true,
     *         documentation : true,
     *         keywords : true
     *     }
     *  }</pre>
     *  However if useFlatFields were set, <code>request.data</code> could be just:
     *  <pre>{
     *     searchFor: "search text",
     *     caseSensitive: false,
     *     serviceName: true,
     *     documentation : true,
     *     keywords : true
     *  }</pre>
     * <code>useFlatFields</code> is often set when the input data comes from a {@link
     * com.smartgwt.client.widgets.form.DynamicForm}
     *  to avoid the cumbersome and fragile process of mapping input fields to an XML structure.
     *  <P>
     * {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields OperationBinding.useFlatFields} can also be set to
     * cause <b>all</b> dsRequests of a
     *  particular type to <code>useFlatFields</code> automatically.
     *  <P>
     *  For {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}, 
     * {@link com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields component.useFlatFields} can be set use
     * "flattened"
     *  binding to fields of a WSDL message or XML Schema.
     *  <P>
     *  Note that <code>useFlatFields</code> is not generally recommended for use with XML input
     *  messages where multiple simple type fields exist with the same name, however if used in this
     *  way, the first field to use a given name wins.  "first" means the first field encountered in a
     *  depth first search.  "wins" means only the first field will be populated in the generated
     *  XML message.
     *
     * @return Current useFlatFields value. Default value is null
     */
    public Boolean getUseFlatFields()  {
        return getAttributeAsBoolean("useFlatFields", true);
    }
    

    /**
     * Cause the {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} XML serialization behavior to be
     * used for <b>all</b> soap headers in the request.  See also {@link com.smartgwt.client.data.DSRequest#getHeaderData
     * headerData}.
     *
     * @param useFlatHeaderFields New useFlatHeaderFields value. Default value is null
     */
    public void setUseFlatHeaderFields(Boolean useFlatHeaderFields) {
        setAttribute("useFlatHeaderFields", useFlatHeaderFields);
    }

    /**
     * Cause the {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} XML serialization behavior to be
     * used for <b>all</b> soap headers in the request.  See also {@link com.smartgwt.client.data.DSRequest#getHeaderData
     * headerData}.
     *
     * @return Current useFlatHeaderFields value. Default value is null
     */
    public Boolean getUseFlatHeaderFields()  {
        return getAttributeAsBoolean("useFlatHeaderFields", true);
    }
    

    /**
     * Should the HTTP response to this request be formatted using the strict JSON subset of the javascript language? If set to
     * true, responses returned by the server should match the format described <a href='http://www.json.org/js.html'
     * target='_blank'>here</a>. <P> Only applies to requests sent a server with {@link
     * com.smartgwt.client.data.DataSource#getDataFormat DataSource.dataFormat} set to "json" or "iscServer".
     *
     * @param useStrictJSON New useStrictJSON value. Default value is null
     */
    public void setUseStrictJSON(Boolean useStrictJSON) {
        setAttribute("useStrictJSON", useStrictJSON);
    }

    /**
     * Should the HTTP response to this request be formatted using the strict JSON subset of the javascript language? If set to
     * true, responses returned by the server should match the format described <a href='http://www.json.org/js.html'
     * target='_blank'>here</a>. <P> Only applies to requests sent a server with {@link
     * com.smartgwt.client.data.DataSource#getDataFormat DataSource.dataFormat} set to "json" or "iscServer".
     *
     * @return Current useStrictJSON value. Default value is null
     */
    public Boolean getUseStrictJSON()  {
        return getAttributeAsBoolean("useStrictJSON", true);
    }
    

    /**
     * Mode of validation for entered data.
     *
     * @param validationMode New validationMode value. Default value is "full"
     */
    public void setValidationMode(ValidationMode validationMode) {
        setAttribute("validationMode", validationMode == null ? null : validationMode.getValue());
    }

    /**
     * Mode of validation for entered data.
     *
     * @return Current validationMode value. Default value is "full"
     */
    public ValidationMode getValidationMode()  {
        return EnumUtil.getEnum(ValidationMode.values(), getAttribute("validationMode"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    public DSRequest(DSOperationType operationType, Criteria criteria) {
        this(operationType, criteria.getJsObj());
    }
    public DSRequest(DSOperationType operationType, String operationId, Criteria criteria) {
        this(operationType, operationId, criteria.getJsObj());
    }

    /**
     * Set a custom attribute value on the DSRequest as an Object. Note that this method converts the Java primitive Object types, Dates and Maps to the underyling
     * JavaScriptObject value. All other object types are set as Object type attributes and users are expected to call {@link #getAttributeAsObject(String)}
     * in order to retrieve them.
     * <P>
     * These attributes are available for client-side use only - these attributes are not
     * transmitted to the server.
     * <P>
     * Do not use setAttribute() to set any attribute for which there is a dedicated setter (do not
     * setAttribute("data", <i>data</i>) for example).
     * <P>
     * If you are looking for a way to send additional data to the server, read
     * {@link com.smartgwt.client.docs.DsRequestEquivalence} for the best approach.
     *
     * @param property the attribute name
     * @param value the attribute value.
     */
    @Override
    public void setAttribute(String property, Object value) {
        super.setAttribute(property, value);
    }

    public void setParams(Map params) {
        setAttribute("params", params);
    }

    public final native void setCallback(DSCallback callback) /*-{
        var selfJS = this.@com.smartgwt.client.data.DSRequest::getJsObj()();
        if (callback == null) {
            selfJS.callback = null;
        } else {
            selfJS.callback = function (dsResponseJS, dataJS, dsRequestJS) {
                callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
                    @com.smartgwt.client.data.DSResponse::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponseJS),
                    dataJS,
                    @com.smartgwt.client.data.DSRequest::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequestJS)
                );
            };
        }
    }-*/;

    /**
     * Fieldnames to sortBy.
     *
     * @param sortSpecifiers  Default value is null
     */
    public void setSortBy(SortSpecifier[] sortSpecifiers) {
        if(sortSpecifiers != null && sortSpecifiers.length > 0) {
            String[] sortBy = new String[sortSpecifiers.length];
            for (int i = 0; i < sortSpecifiers.length; i++) {
                SortSpecifier sortSpecifier = sortSpecifiers[i];
                sortBy[i] = ((sortSpecifier.getSortDirection() == SortDirection.DESCENDING ? "-" : "") + sortSpecifier.getField());
            }
            setAttribute("sortBy", sortBy);
        } else {
            setAttribute("sortBy", (String[]) null);
        }
    }

    /**
     * Fieldname to sortBy
     *
     * @return SortSpecifier array
     */
    public native SortSpecifier[] getSortBy() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var sortBy = self.sortBy;
        if(sortBy == null || sortBy === undefined) return null;
        //Unlike ListGrid.getSortBy(), DSRequest always stores sortBy as a String or an array of Strings, and not the SortSpecifier object / array.
        if($wnd.isc.isA.Array(sortBy)) {
            sortBy = sortBy.join(",");
        }
        return @com.smartgwt.client.data.SortSpecifier::convertToArray(Ljava/lang/String;)(sortBy);
    }-*/;

    /**
     * A mapping from field names to summary functions to be applied to each field.
     * <p>
     * Valid only for an operation of type "fetch".  See the Server Summaries overview in the
     * client-side documentation for details and examples of usage.
     * <p>
     * <b>NOTE</b>: this feature is supported only in Power Edition or above, and only when
     * using the built-in SQL, JPA or Hibernate connectors.
     *
     * @param summaryFunctions <code>Map&lt;String,SummaryFunction&gt;</code> with field names as keys and summary functions as values.
     *
     * @see DSRequest2#setGroupBy(java.lang.String[]) DSRequest.setGroupBy(String[])
     */
    public void setSummaryFunctions(Map<String, SummaryFunctionType> summaryFunctions) {
        setAttribute("summaryFunctions", summaryFunctions);
    }

    /**
     * A mapping from field names to summary functions to be applied to each field.
     * <p>
     * Valid only for an operation of type "fetch".  See the Server Summaries overview in the
     * client-side documentation for details and examples of usage.
     * <p>
     * <b>NOTE</b>: this feature is supported only in Power Edition or above, and only when
     * using the built-in SQL, JPA or Hibernate connectors.
     *
     * @return <code>Map&lt;String,SummaryFunction&gt;</code> with field names as keys and summary functions as values.
     *
     * @see DSRequest2#getGroupBy() DSRequest.getGroupBy()
     */
    public Map<String,SummaryFunctionType> getSummaryFunctions() {
        return getAttributeAsMap("summaryFunctions");
    }

    /**
     * For an <code>update</code> or <code>remove</code> operation, the original values from the record that is being updated
     * or removed.  <code>oldValues</code> is automatically added to DSRequests submitted by DataBound Components.  Available
     * on the server via <code>DSRequest.getOldValues()</code>. <P> The server can compare the <code>oldValues</code> to the
     * most recent stored values in order to detect that the user was looking at stale values when the user submitted changes
     * (NOTE: this means of detecting concurrent edit is sometimes called "optimistic concurrency" or "long transactions").
     * <P> In applications where a policy of "last update wins" is not appropriate when updating certain fields, special UI can
     * be shown for this case.  For example, on detecting concurrent edit, the server may send back a special
     * <code>dsResponse.status</code> code that the client application detects, offering the user a choice of proceeding with
     * the operation, discarding edits, or reconciling new and old values in a special interface.
     *
     * @param oldValues oldValues Default value is null
     */
    public void setOldValues(Map oldValues) {
        setAttribute("oldValues", oldValues);
    }

    /**
     * For an <code>update</code> or <code>remove</code> operation, the original values from the record that is being updated
     * or removed.  <code>oldValues</code> is automatically added to DSRequests submitted by DataBound Components.  Available
     * on the server via <code>DSRequest.getOldValues()</code>. <P> The server can compare the <code>oldValues</code> to the
     * most recent stored values in order to detect that the user was looking at stale values when the user submitted changes
     * (NOTE: this means of detecting concurrent edit is sometimes called "optimistic concurrency" or "long transactions").
     * <P> In applications where a policy of "last update wins" is not appropriate when updating certain fields, special UI can
     * be shown for this case.  For example, on detecting concurrent edit, the server may send back a special
     * <code>dsResponse.status</code> code that the client application detects, offering the user a choice of proceeding with
     * the operation, discarding edits, or reconciling new and old values in a special interface.
     *
     * @param oldValues oldValues Default value is null
     */
    public void setOldValues(JavaScriptObject oldValues) {
        setAttribute("oldValues", oldValues);
    }

    /**
     * Return the Criteria associated with a FETCH operation.
     * <p>
     * <b>Note</b> : This method should only be called during a FETCH operation
     *
     * @return the criteria
     * @throws IllegalStateException if called for a non-fetch operation
     */
    public Criteria getCriteria() throws IllegalStateException {
        if(getOperationType() == DSOperationType.FETCH) {
            return getData() == null ? null : new Criteria(getData());
        } else {
            throw new IllegalStateException("This method should only be called during FETCH operations");
        }
    }

    /**
     * Set the skin to use. For example: Enterprise
     *
     * @param skinName the name of the selected skin.
     */
    public void setSkinName(String skinName) {
        setAttribute("skinName", skinName);
    }

    /**
     * This method applies to "fetch" requests only; for update or delete operations pass a
     * Record to setData() which contains primaryKey values as Record attributes.
     * <P>
     * If you need to do a remove with criteria rather than a primary key, the recommended
     * approach is to do it via a
     * {@link com.smartgwt.client.docs.serverds.OperationBinding#operationType custom operation}.
     * so the intent is clear.  You can also do it as a remove, but just use
     * {@link com.smartgwt.client.data.DSRequest#getOldValues DSRequest.oldValues} as the source
     * for whatever criteria values you need.  That covers everything except
     * {@link com.smartgwt.client.docs.serverds.AdvancedCriteria AdvancedCriteria}.
     * @param criteria the criteria to store.
     */
    public void setCriteria(Criteria criteria) {
        if (criteria != null) {
            setAttribute("data", criteria.getJsObj());
        }
    }

}
