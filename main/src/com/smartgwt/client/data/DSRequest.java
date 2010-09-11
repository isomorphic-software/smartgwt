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
 
package com.smartgwt.client.data;



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
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Request sent to the server to initiate a  {@link com.smartgwt.client.docs.DataSourceOperations DataSource operation}. 
 * All properties which are legal on {@link com.smartgwt.client.rpc.RPCRequest} are legal, in addition to the properties
 * listed here.
 * @see com.smartgwt.client.rpc.RPCRequest
 */
public class DSRequest extends RPCRequest {

    public static DSRequest getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DSRequest(jsObj);
    }

    public DSRequest(){
        
    }

    public DSRequest(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
     * For requests submitted by a {@link com.smartgwt.client.widgets.DataBoundComponent}, the {@link
     * com.smartgwt.client.widgets.Canvas#getID ID} of the submitting component. <P> This ID will be present for operations
     * including automatic saves by a ListGrid  {@link com.smartgwt.client.docs.Editing during editing}, or calls to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData form.saveData()}.  It will not be present for a direct call to a
     * DataSource method such as {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData}. <P> Note this is
     * the component's <b>String</b> ID - you can retrieve the component itself via {@link
     * com.smartgwt.client.widgets.Canvas#getById Canvas.getById}.
     *
     * @param componentId componentId Default value is null
     */
    public void setComponentId(String componentId) {
        setAttribute("componentId", componentId);
    }

    /**
     * For requests submitted by a {@link com.smartgwt.client.widgets.DataBoundComponent}, the {@link
     * com.smartgwt.client.widgets.Canvas#getID ID} of the submitting component. <P> This ID will be present for operations
     * including automatic saves by a ListGrid  {@link com.smartgwt.client.docs.Editing during editing}, or calls to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData form.saveData()}.  It will not be present for a direct call to a
     * DataSource method such as {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData}. <P> Note this is
     * the component's <b>String</b> ID - you can retrieve the component itself via {@link
     * com.smartgwt.client.widgets.Canvas#getById Canvas.getById}.
     *
     *
     * @return String
     */
    public String getComponentId()  {
        return getAttributeAsString("componentId");
    }

    /**
     * DataSource this DSRequest will act on. <P> This property is generally automatically populated, for example when calling
     * {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} the dataSource property is set to the target
     * DataSource.
     *
     * @param dataSource dataSource Default value is null
     */
    public void setDataSource(String dataSource) {
        setAttribute("dataSource", dataSource);
    }

    /**
     * DataSource this DSRequest will act on. <P> This property is generally automatically populated, for example when calling
     * {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} the dataSource property is set to the target
     * DataSource.
     *
     *
     * @return String
     */
    public String getDataSource()  {
        return getAttributeAsString("dataSource");
    }

    /**
     * End row of requested results, used only with fetch operations. <p> Note that startRow and endRow are zero-based,
     * inclusive at the beginning and exclusive at the end (like substring), so startRow: 0, endRow: 1 is a request for the
     * first record.
     *
     * @param endRow endRow Default value is null
     */
    public void setEndRow(Integer endRow) {
        setAttribute("endRow", endRow);
    }

    /**
     * End row of requested results, used only with fetch operations. <p> Note that startRow and endRow are zero-based,
     * inclusive at the beginning and exclusive at the end (like substring), so startRow: 0, endRow: 1 is a request for the
     * first record.
     *
     *
     * @return Integer
     */
    public Integer getEndRow()  {
        return getAttributeAsInt("endRow");
    }

    /**
     * The format in which the data should be exported.  See {@link com.smartgwt.client.types.ExportFormat} for more 
     * information.
     *
     * @param exportAs exportAs Default value is "csv"
     */
    public void setExportAs(ExportFormat exportAs) {
        setAttribute("exportAs", exportAs.getValue());
    }

    /**
     * The format in which the data should be exported.  See {@link com.smartgwt.client.types.ExportFormat} for more 
     * information.
     *
     *
     * @return ExportFormat
     */
    public ExportFormat getExportAs()  {
        return EnumUtil.getEnum(ExportFormat.values(), getAttribute("exportAs"));
    }

    /**
     * The character to use as a field-separator in CSV exports.  The default delimiter is comma.
     *
     * @param exportDelimiter exportDelimiter Default value is ","
     */
    public void setExportDelimiter(String exportDelimiter) {
        setAttribute("exportDelimiter", exportDelimiter);
    }

    /**
     * The character to use as a field-separator in CSV exports.  The default delimiter is comma.
     *
     *
     * @return String
     */
    public String getExportDelimiter()  {
        return getAttributeAsString("exportDelimiter");
    }

    /**
     * Specifies whether the exported data will be downloaded to the file-system or displayed in a  new window. See {@link
     * com.smartgwt.client.types.ExportDisplay} for more information.
     *
     * @param exportDisplay exportDisplay Default value is "download"
     */
    public void setExportDisplay(ExportDisplay exportDisplay) {
        setAttribute("exportDisplay", exportDisplay.getValue());
    }

    /**
     * Specifies whether the exported data will be downloaded to the file-system or displayed in a  new window. See {@link
     * com.smartgwt.client.types.ExportDisplay} for more information.
     *
     *
     * @return ExportDisplay
     */
    public ExportDisplay getExportDisplay()  {
        return EnumUtil.getEnum(ExportDisplay.values(), getAttribute("exportDisplay"));
    }

    /**
     * The name of the file to save the exported data into.
     *
     * @param exportFilename exportFilename Default value is null
     */
    public void setExportFilename(String exportFilename) {
        setAttribute("exportFilename", exportFilename);
    }

    /**
     * The name of the file to save the exported data into.
     *
     *
     * @return String
     */
    public String getExportFilename()  {
        return getAttributeAsString("exportFilename");
    }

    /**
     * Optional text to appear at the end of the file.
     *
     * @param exportFooter exportFooter Default value is null
     */
    public void setExportFooter(String exportFooter) {
        setAttribute("exportFooter", exportFooter);
    }

    /**
     * Optional text to appear at the end of the file.
     *
     *
     * @return String
     */
    public String getExportFooter()  {
        return getAttributeAsString("exportFooter");
    }

    /**
     * Optional text to appear at the beginning of the file.
     *
     * @param exportHeader exportHeader Default value is null
     */
    public void setExportHeader(String exportHeader) {
        setAttribute("exportHeader", exportHeader);
    }

    /**
     * Optional text to appear at the beginning of the file.
     *
     *
     * @return String
     */
    public String getExportHeader()  {
        return getAttributeAsString("exportHeader");
    }

    /**
     * When set, causes the results of the DSRequest to be exported to a file, whose name &#010 and format are indicated by
     * {@link com.smartgwt.client.data.DSRequest#getExportFilename exportFilename} and &#010 {@link
     * com.smartgwt.client.data.DSRequest#getExportAs exportAs} respectively.  When no exportFilename is provided, the default
     * is&#010 <i>Results</i> and the default value of exportAs is <i>csv</i>.  &#010 <P>&#010 The export field-list can also
     * be configured, see {@link com.smartgwt.client.data.DSRequest#getExportFields exportFields}.&#010 <P>&#010 Once the
     * operation completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay} specifies whether the
     * exported&#010 data should be downloaded to the file-system or displayed in a new window.  The default value&#010 of
     * exportDisplay is "download" which displays the Save As dialog.  See {@link com.smartgwt.client.types.ExportDisplay}
     * &#010 for more information.&#010 <P>&#010 You can configure the style of  line-breaks to use when &#010 generating the
     * output, the {@link com.smartgwt.client.data.DSRequest#getExportDelimiter delimiter} to use when exporting&#010 to CSV
     * and the {@link com.smartgwt.client.data.DSRequest#getExportTitleSeparatorChar separator-character} to use in &#010
     * field-titles when exporting to XML.&#010 <P>&#010 Additionally, you can output arbitrary text before and after the
     * exported data by setting &#010 {@link com.smartgwt.client.data.DSRequest#getExportHeader exportHeader} and {@link
     * com.smartgwt.client.data.DSRequest#getExportFooter exportFooter}.&#010 <P>&#010 Note that an export initiated using
     * dsRequest properties does not provide support for JSON&#010 format (see &#010 <a
     * href="http://forums.smartclient.com/showthread.php?t=235">this post</a> for more detail).&#010 <P>&#010 As well as
     * setting dsRequest.exportResults and related properties, exports can be initiated&#010 in two other ways, via {@link
     * com.smartgwt.client.data.OperationBinding}s and via custom server code which sets &#010 export-related properties on the
     * {@link com.smartgwt.client.data.DSResponse}.  Both of those methods support exporting&#010 to JSON format.&#010 <P>&#010
     * <b>Format Examples</b>&#010 XML format&#010 <pre>&#010     &lt;List&gt;&#010         &lt;Object&gt;&#010            
     * &lt;id&gt;10101&lt;/id&gt;&#010             &lt;displayName&gt;Record 10101&lt;/displayName&gt;&#010        
     * &lt;/Object&gt;&#010    &lt;/List&gt;&#010 </pre>&#010 JSON Format&#010 <pre>&#010     [&#010         { id: 10101,
     * displayName: "Record 10101" }&#010     ]&#010 </pre>&#010 CSV Format&#010 <pre>&#010     id,displayName&#010    
     * 10101,"Record 10101"&#010 </pre>
     *
     * @param exportResults exportResults Default value is false
     */
    public void setExportResults(Boolean exportResults) {
        setAttribute("exportResults", exportResults);
    }

    /**
     * When set, causes the results of the DSRequest to be exported to a file, whose name &#010 and format are indicated by
     * {@link com.smartgwt.client.data.DSRequest#getExportFilename exportFilename} and &#010 {@link
     * com.smartgwt.client.data.DSRequest#getExportAs exportAs} respectively.  When no exportFilename is provided, the default
     * is&#010 <i>Results</i> and the default value of exportAs is <i>csv</i>.  &#010 <P>&#010 The export field-list can also
     * be configured, see {@link com.smartgwt.client.data.DSRequest#getExportFields exportFields}.&#010 <P>&#010 Once the
     * operation completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay} specifies whether the
     * exported&#010 data should be downloaded to the file-system or displayed in a new window.  The default value&#010 of
     * exportDisplay is "download" which displays the Save As dialog.  See {@link com.smartgwt.client.types.ExportDisplay}
     * &#010 for more information.&#010 <P>&#010 You can configure the style of  line-breaks to use when &#010 generating the
     * output, the {@link com.smartgwt.client.data.DSRequest#getExportDelimiter delimiter} to use when exporting&#010 to CSV
     * and the {@link com.smartgwt.client.data.DSRequest#getExportTitleSeparatorChar separator-character} to use in &#010
     * field-titles when exporting to XML.&#010 <P>&#010 Additionally, you can output arbitrary text before and after the
     * exported data by setting &#010 {@link com.smartgwt.client.data.DSRequest#getExportHeader exportHeader} and {@link
     * com.smartgwt.client.data.DSRequest#getExportFooter exportFooter}.&#010 <P>&#010 Note that an export initiated using
     * dsRequest properties does not provide support for JSON&#010 format (see &#010 <a
     * href="http://forums.smartclient.com/showthread.php?t=235">this post</a> for more detail).&#010 <P>&#010 As well as
     * setting dsRequest.exportResults and related properties, exports can be initiated&#010 in two other ways, via {@link
     * com.smartgwt.client.data.OperationBinding}s and via custom server code which sets &#010 export-related properties on the
     * {@link com.smartgwt.client.data.DSResponse}.  Both of those methods support exporting&#010 to JSON format.&#010 <P>&#010
     * <b>Format Examples</b>&#010 XML format&#010 <pre>&#010     &lt;List&gt;&#010         &lt;Object&gt;&#010            
     * &lt;id&gt;10101&lt;/id&gt;&#010             &lt;displayName&gt;Record 10101&lt;/displayName&gt;&#010        
     * &lt;/Object&gt;&#010    &lt;/List&gt;&#010 </pre>&#010 JSON Format&#010 <pre>&#010     [&#010         { id: 10101,
     * displayName: "Record 10101" }&#010     ]&#010 </pre>&#010 CSV Format&#010 <pre>&#010     id,displayName&#010    
     * 10101,"Record 10101"&#010 </pre>
     *
     *
     * @return Boolean
     */
    public Boolean getExportResults()  {
        return getAttributeAsBoolean("exportResults");
    }

    /**
     * The character with which to replace spaces in field-titles when exporting to XML.
     *
     * @param exportTitleSeparatorChar exportTitleSeparatorChar Default value is null
     */
    public void setExportTitleSeparatorChar(String exportTitleSeparatorChar) {
        setAttribute("exportTitleSeparatorChar", exportTitleSeparatorChar);
    }

    /**
     * The character with which to replace spaces in field-titles when exporting to XML.
     *
     *
     * @return String
     */
    public String getExportTitleSeparatorChar()  {
        return getAttributeAsString("exportTitleSeparatorChar");
    }

    /**
     * The style of line-breaks to use in the exported output.  See LineBreakStyle for more information.
     *
     * @param lineBreakStyle lineBreakStyle Default value is null
     */
    public void setLineBreakStyle(String lineBreakStyle) {
        setAttribute("lineBreakStyle", lineBreakStyle);
    }

    /**
     * The style of line-breaks to use in the exported output.  See LineBreakStyle for more information.
     *
     *
     * @return String
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
     * @param oldValues oldValues Default value is null
     */
    public void setOldValues(Record oldValues) {
        setAttribute("oldValues", oldValues.getJsObj());
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
     *
     * @return Record
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
     * for the same {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType}, you can specify an
     * <code>operationId</code> {@link com.smartgwt.client.data.OperationBinding#getOperationId on the operationBinding} which
     * will cause that operationBinding to be used for dsRequests containing a matching <code>operationId</code>. This allows
     * all the possible settings of an <code>operationBinding</code>, including {@link
     * com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation} or {@link
     * com.smartgwt.client.data.DSRequest#getDmiOverview DMI} settings, to be switched on a per-component or per-request basis.
     * <P> For example, by setting the <code>fetchOperation</code> on a particular ListGrid, you could cause it to invoke a
     * different server method via DMI, different {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL} or
     * different {@link com.smartgwt.client.data.OperationBinding#getWsOperation web service operation}. <P> The
     * <code>operationId</code> can also be directly received by the server in order to affect behavior.  When using the Smart
     * GWT Server, <code>operationId</code> can be accessed via dsRequest.getOperationId().  The {@link
     * com.smartgwt.client.data.RestDataSource} will also send the <code>operationId</code> to the server as part of the {@link
     * com.smartgwt.client.data.RestDataSource#getMetaDataPrefix request metadata}.   <P> Note that if you {@link
     * com.smartgwt.client.data.DataSource#fetchData manually invoke} a DataSource operation, you can also specify operationId
     * via the <code>requestProperties</code> parameter.
     *
     * @param operationId operationId Default value is null
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
     * for the same {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType}, you can specify an
     * <code>operationId</code> {@link com.smartgwt.client.data.OperationBinding#getOperationId on the operationBinding} which
     * will cause that operationBinding to be used for dsRequests containing a matching <code>operationId</code>. This allows
     * all the possible settings of an <code>operationBinding</code>, including {@link
     * com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation} or {@link
     * com.smartgwt.client.data.DSRequest#getDmiOverview DMI} settings, to be switched on a per-component or per-request basis.
     * <P> For example, by setting the <code>fetchOperation</code> on a particular ListGrid, you could cause it to invoke a
     * different server method via DMI, different {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL} or
     * different {@link com.smartgwt.client.data.OperationBinding#getWsOperation web service operation}. <P> The
     * <code>operationId</code> can also be directly received by the server in order to affect behavior.  When using the Smart
     * GWT Server, <code>operationId</code> can be accessed via dsRequest.getOperationId().  The {@link
     * com.smartgwt.client.data.RestDataSource} will also send the <code>operationId</code> to the server as part of the {@link
     * com.smartgwt.client.data.RestDataSource#getMetaDataPrefix request metadata}.   <P> Note that if you {@link
     * com.smartgwt.client.data.DataSource#fetchData manually invoke} a DataSource operation, you can also specify operationId
     * via the <code>requestProperties</code> parameter.
     *
     *
     * @return String
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
     * @param operationType operationType Default value is null
     */
    public void setOperationType(DSOperationType operationType) {
        setAttribute("operationType", operationType.getValue());
    }

    /**
     * Type of operation being performed: "fetch", "add", "remove", "update" or "custom". <P> This property is generally
     * automatically populated, for example when calling <code>fetchData()</code> on a DataSource or DataBound component the
     * operationType is automatically set to "fetch".  Note that "custom" operations are never generated automatically, they
     * are always fired by your code.
     *
     *
     * @return DSOperationType
     */
    public DSOperationType getOperationType()  {
        return EnumUtil.getEnum(DSOperationType.values(), getAttribute("operationType"));
    }


    /**
     * Automatically generated unique ID for this request. This ID will be required by developers  making use of the {@link
     * com.smartgwt.client.types.DSProtocol "clientCustom" dataProtocol}.
     *
     *
     * @return String
     */
    public String getRequestId()  {
        return getAttributeAsString("requestId");
    }

    /**
     * Starting row of requested results, used only with fetch operations.  If unset, 0 is assumed. <p> Note that startRow and
     * endRow are zero-based, inclusive at the beginning and exclusive at the end (like substring), so startRow: 0, endRow: 1
     * is a request for the first record.
     *
     * @param startRow startRow Default value is null
     */
    public void setStartRow(Integer startRow) {
        setAttribute("startRow", startRow);
    }

    /**
     * Starting row of requested results, used only with fetch operations.  If unset, 0 is assumed. <p> Note that startRow and
     * endRow are zero-based, inclusive at the beginning and exclusive at the end (like substring), so startRow: 0, endRow: 1
     * is a request for the first record.
     *
     *
     * @return Integer
     */
    public Integer getStartRow()  {
        return getAttributeAsInt("startRow");
    }

    /**
     * For "fetch" operations, how search criteria should be interpreted for text fields: either "exact" for exact match,
     * "startsWith" for matching at the beginning only, or "substring" for case-insensitive substring match. <p> This setting
     * is respected by the built-in SQLDataSource.  Your custom DataSource implementation can interpret the search criteria
     * passed into "fetch" operations in arbitrary ways; you can safely ignore this flag and use others of your own devising.
     *
     * @param textMatchStyle textMatchStyle Default value is "exact"
     */
    public void setTextMatchStyle(TextMatchStyle textMatchStyle) {
        setAttribute("textMatchStyle", textMatchStyle.getValue());
    }

    /**
     * For "fetch" operations, how search criteria should be interpreted for text fields: either "exact" for exact match,
     * "startsWith" for matching at the beginning only, or "substring" for case-insensitive substring match. <p> This setting
     * is respected by the built-in SQLDataSource.  Your custom DataSource implementation can interpret the search criteria
     * passed into "fetch" operations in arbitrary ways; you can safely ignore this flag and use others of your own devising.
     *
     *
     * @return TextMatchStyle
     */
    public TextMatchStyle getTextMatchStyle()  {
        return EnumUtil.getEnum(TextMatchStyle.values(), getAttribute("textMatchStyle"));
    }

    /**
     * When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when&#010 creating the input XML
     * message to send to the web service, properties in&#010 {@link com.smartgwt.client.data.DSRequest#getData request.data}
     * will be used as the values for XML elements of the same name, at&#010 any level of nesting.&#010 <P>&#010
     * <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as&#010 extra levels of nested
     * elements, and provides some insulation against changes in the&#010 required structure of the input message.&#010
     * <P>&#010 For example, given this input message:&#010 <pre>&#010 &lt;FindServices&gt;&#010     &lt;searchFor&gt;search
     * text&lt;/searchFor&gt;&#010     &lt;Options&gt;&#010         &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;&#010    
     * &lt;/Options&gt;&#010     &lt;IncludeInSearch&gt;&#010         &lt;serviceName&gt;true&lt;/serviceName&gt;&#010        
     * &lt;documentation&gt;true&lt;/documentation&gt;&#010         &lt;keywords&gt;true&lt;/keywords&gt;&#010    
     * &lt;/IncludeInSearch&gt;&#010 &lt;/FindServices&gt;&#010 </pre>&#010 If <code>useFlatFields</code> were <b>not</b> set,
     * in order to fill out this message&#010 correctly, <code>request.data</code> would need to be:&#010 <pre>{&#010   
     * searchFor: "search text",&#010    Options : {&#010        caseSensitive: false,&#010    },&#010    IncludeInSearch :
     * {&#010        serviceName: true,&#010        documentation : true,&#010        keywords : true&#010    }&#010
     * }</pre>&#010 However if useFlatFields were set, <code>request.data</code> could be just:&#010 <pre>{&#010    searchFor:
     * "search text",&#010    caseSensitive: false,&#010    serviceName: true,&#010    documentation : true,&#010    keywords :
     * true&#010 }</pre>&#010 <code>useFlatFields</code> is often set when the input data comes from a {@link
     * com.smartgwt.client.widgets.form.DynamicForm}&#010 to avoid the cumbersome and fragile process of mapping input fields
     * to an XML structure.&#010 <P>&#010 {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} can
     * also be set to cause <b>all</b> dsRequests of a&#010 particular type to <code>useFlatFields</code> automatically.&#010
     * <P>&#010 For {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}, &#010 {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields component.useFlatFields} can be set use "flattened"&#010
     * binding to fields of a WSDL message or XML Schema.&#010 <P>&#010 Note that <code>useFlatFields</code> is not generally
     * recommended for use with XML input&#010 messages where multiple simple type fields exist with the same name, however if
     * used in this&#010 way, the first field to use a given name wins.  "first" means the first field encountered in a&#010
     * depth first search.  "wins" means only the first field will be populated in the generated&#010 XML message.
     *
     * @param useFlatFields useFlatFields Default value is null
     */
    public void setUseFlatFields(Boolean useFlatFields) {
        setAttribute("useFlatFields", useFlatFields);
    }

    /**
     * When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when&#010 creating the input XML
     * message to send to the web service, properties in&#010 {@link com.smartgwt.client.data.DSRequest#getData request.data}
     * will be used as the values for XML elements of the same name, at&#010 any level of nesting.&#010 <P>&#010
     * <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as&#010 extra levels of nested
     * elements, and provides some insulation against changes in the&#010 required structure of the input message.&#010
     * <P>&#010 For example, given this input message:&#010 <pre>&#010 &lt;FindServices&gt;&#010     &lt;searchFor&gt;search
     * text&lt;/searchFor&gt;&#010     &lt;Options&gt;&#010         &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;&#010    
     * &lt;/Options&gt;&#010     &lt;IncludeInSearch&gt;&#010         &lt;serviceName&gt;true&lt;/serviceName&gt;&#010        
     * &lt;documentation&gt;true&lt;/documentation&gt;&#010         &lt;keywords&gt;true&lt;/keywords&gt;&#010    
     * &lt;/IncludeInSearch&gt;&#010 &lt;/FindServices&gt;&#010 </pre>&#010 If <code>useFlatFields</code> were <b>not</b> set,
     * in order to fill out this message&#010 correctly, <code>request.data</code> would need to be:&#010 <pre>{&#010   
     * searchFor: "search text",&#010    Options : {&#010        caseSensitive: false,&#010    },&#010    IncludeInSearch :
     * {&#010        serviceName: true,&#010        documentation : true,&#010        keywords : true&#010    }&#010
     * }</pre>&#010 However if useFlatFields were set, <code>request.data</code> could be just:&#010 <pre>{&#010    searchFor:
     * "search text",&#010    caseSensitive: false,&#010    serviceName: true,&#010    documentation : true,&#010    keywords :
     * true&#010 }</pre>&#010 <code>useFlatFields</code> is often set when the input data comes from a {@link
     * com.smartgwt.client.widgets.form.DynamicForm}&#010 to avoid the cumbersome and fragile process of mapping input fields
     * to an XML structure.&#010 <P>&#010 {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} can
     * also be set to cause <b>all</b> dsRequests of a&#010 particular type to <code>useFlatFields</code> automatically.&#010
     * <P>&#010 For {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}, &#010 {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields component.useFlatFields} can be set use "flattened"&#010
     * binding to fields of a WSDL message or XML Schema.&#010 <P>&#010 Note that <code>useFlatFields</code> is not generally
     * recommended for use with XML input&#010 messages where multiple simple type fields exist with the same name, however if
     * used in this&#010 way, the first field to use a given name wins.  "first" means the first field encountered in a&#010
     * depth first search.  "wins" means only the first field will be populated in the generated&#010 XML message.
     *
     *
     * @return Boolean
     */
    public Boolean getUseFlatFields()  {
        return getAttributeAsBoolean("useFlatFields");
    }

    /**
     * Cause the {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} XML serialization behavior to be
     * used for <b>all</b> soap headers in the request.  See also {@link com.smartgwt.client.data.DSRequest#getHeaderData
     * headerData}.
     *
     * @param useFlatHeaderFields useFlatHeaderFields Default value is null
     */
    public void setUseFlatHeaderFields(Boolean useFlatHeaderFields) {
        setAttribute("useFlatHeaderFields", useFlatHeaderFields);
    }

    /**
     * Cause the {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} XML serialization behavior to be
     * used for <b>all</b> soap headers in the request.  See also {@link com.smartgwt.client.data.DSRequest#getHeaderData
     * headerData}.
     *
     *
     * @return Boolean
     */
    public Boolean getUseFlatHeaderFields()  {
        return getAttributeAsBoolean("useFlatHeaderFields");
    }

    /**
     * Mode of validation for entered data.
     *
     * @param validationMode validationMode Default value is "full"
     */
    public void setValidationMode(ValidationMode validationMode) {
        setAttribute("validationMode", validationMode.getValue());
    }

    /**
     * Mode of validation for entered data.
     *
     *
     * @return ValidationMode
     */
    public ValidationMode getValidationMode()  {
        return EnumUtil.getEnum(ValidationMode.values(), getAttribute("validationMode"));
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        



/**
    * The list of field-names to export.  If provided, the field-list in the exported output is &#010 limited and sorted as per the list.&#010 <P>&#010 If exportFields is not provided, the exported output includes all visible fields &#010 from the DataSource (field.hidden=false), sorted in the order they're defined.
    *
    * @param exportFields exportFields Default value is null
    */
    public void setExportFields(String[]exportFields) {
        setAttribute("exportFields", exportFields);
    }

    /**
     * The list of field-names to export.  If provided, the field-list in the exported output is &#010 limited and sorted as per the list.&#010 <P>&#010 If exportFields is not provided, the exported output includes all visible fields &#010 from the DataSource (field.hidden=false), sorted in the order they're defined.
     *
     * @return the export fields
     */
    public String[] getExportFields()  {
        return getAttributeAsStringArray("exportFields");
    }

    public void setParams(Map params) {
        setAttribute("params", params);
    }

    /**
     * For DataSources using SOAP messaging with a WSDL web service, data to be serialized to form SOAP headers, as a map from the header part name to the data. See WSRequest.headerData for more information.
     * <p>
     * SOAP headers typically contain request metadata such as a session id for authentication, and so dsRequest.headerData is typically populated by DataSource.transformRequest(), or, for data that applies to every request sent to the server,
     * by WebService.getHeaderData().
     * 
     * @param headerData the header data
     */
    public void setHeaderData(Map headerData) {
        setAttribute("headerData", headerData);
    }

    /**
     * For DataSources using SOAP messaging with a WSDL web service, data to be serialized to form SOAP headers, as a map from the header part name to the data. See WSRequest.headerData for more information.
     * <p>
     * SOAP headers typically contain request metadata such as a session id for authentication, and so dsRequest.headerData is typically populated by DataSource.transformRequest(), or, for data that applies to every request sent to the server,
     * by WebService.getHeaderData().
     *
     * @return the header data
     */
    public Map getHeaderData() {
        return getAttributeAsMap("headerData");
    }

    /**
     * For advanced use in integrating dataset paging with web services, the ResultSet that issued this "fetch" DSRequest
     * is automatically made available as the resultSet property.
     * <p>
     * This property can only be read. There is no meaning to setting this property yourself.
     *
     * @return the ResultSet
     */
    public ResultSet getResultSet() {
        return ResultSet.getOrCreateRef(getAttributeAsJavaScriptObject("resultSet"));
    }

    /**
     * Fieldnames to sortBy.
     *
     * @param sortSpecifiers  Default value is null
     */
    public void setSortBy(SortSpecifier[] sortSpecifiers) {
        setAttribute("sortBy", sortSpecifiers);
    }

    /**
     * Fieldname to sortBy
     *
     * @return SortSpecifier array
     */
    public native SortSpecifier[] getSortBy() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var sortSpec = self.sortBy;
        if($wnd.isc.isA.String(sortSpec)) {
            return @com.smartgwt.client.data.SortSpecifier::convertToArray(Ljava/lang/String;)(sortSpec);
        } else {
            return @com.smartgwt.client.data.SortSpecifier::convertToArray(Lcom/google/gwt/core/client/JavaScriptObject;)(sortSpec);
        }
    }-*/;

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
    
    public static DSRequest[] convertToDSRequestArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new DSRequest[]{};
        }
        if (JSOHelper.isArray(nativeArray)) {
            JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
            DSRequest[] objects = new DSRequest[componentsj.length];
            for (int i = 0; i < componentsj.length; i++) {
                JavaScriptObject componentJS = componentsj[i];
                objects[i] = DSRequest.getOrCreateRef(componentJS);
            }
            return objects;
        } else {
            DSRequest[] ret = new DSRequest[1];
            ret[0] = DSRequest.getOrCreateRef(nativeArray);
            return ret;
        }
    }

}




