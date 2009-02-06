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
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * Request sent to the server to initiate a  DataSource operation.  All properties which are legal on {@link com.smartgwt.client.rpc.RPCRequest} are legal, in addition to the properties listed here.

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
     * Automatically generated unique ID for this request. This ID will be required by developers  making use of the ${isc.DocUtils.linkForRef('dsProtocol','"clientCustom" dataProtocol')}.
     *
     *
     * @return String
     *
     */
    public String getRequestId()  {
        return getAttributeAsString("requestId");
    }

    /**
    * Starting row of requested results, used only with fetch operations. <p> Note that startRow and endRow are zero-based, so startRow: 0, endRow: 1 is a request for the first two records.
    *
    * @param startRow startRow Default value is 0
    */
    public void setStartRow(int startRow) {
        setAttribute("startRow", startRow);
    }
    /**
     * Starting row of requested results, used only with fetch operations. <p> Note that startRow and endRow are zero-based, so startRow: 0, endRow: 1 is a request for the first two records.
     *
     *
     * @return int
     *
     */
    public int getStartRow()  {
        return getAttributeAsInt("startRow");
    }

    /**
    * End row of requested results, used only with fetch operations. <p> Note that startRow and endRow are zero-based, so startRow: 0, endRow: 1 is a request for the first two records.
    *
    * @param endRow endRow Default value is null
    */
    public void setEndRow(Integer endRow) {
        setAttribute("endRow", endRow);
    }
    /**
     * End row of requested results, used only with fetch operations. <p> Note that startRow and endRow are zero-based, so startRow: 0, endRow: 1 is a request for the first two records.
     *
     *
     * @return Integer
     *
     */
    public Integer getEndRow()  {
        return getAttributeAsInt("endRow");
    }

    /**
    * DataSource this DSRequest will act on. <P> This property is generally automatically populated, for example when calling {@link com.smartgwt.client.data.DataSource#fetchData} the dataSource property is set to the target DataSource.
    *
    * @param dataSource dataSource Default value is null
    */
    public void setDataSource(String dataSource) {
        setAttribute("dataSource", dataSource);
    }
    /**
     * DataSource this DSRequest will act on. <P> This property is generally automatically populated, for example when calling {@link com.smartgwt.client.data.DataSource#fetchData} the dataSource property is set to the target DataSource.
     *
     *
     * @return String
     *
     */
    public String getDataSource()  {
        return getAttributeAsString("dataSource");
    }
             
    /**
    * Type of operation being performed, "fetch", "add", "remove" or "update". <P> This property is generally automatically populated, for example when calling <code>fetchData()</code> on a DataSource or DataBound component the operationType is automatically set to "fetch".
    *
    * @param operationType operationType Default value is null
    */
    public void setOperationType(DSOperationType operationType) {
        setAttribute("operationType", operationType.getValue());
    }
    /**
     * Type of operation being performed, "fetch", "add", "remove" or "update". <P> This property is generally automatically populated, for example when calling <code>fetchData()</code> on a DataSource or DataBound component the operationType is automatically set to "fetch".
     *
     *
     * @return DSOperationType
     *
     */
    public DSOperationType getOperationType()  {
        return (DSOperationType) EnumUtil.getEnum(DSOperationType.values(), getAttribute("operationType"));
    }

    /**
    * Fieldname to sortBy, prefixed with optional "-" indicating descending sort.  For example, to sort by the field "userName" in ascending order, set <code>sortBy</code> to just "userName".  For descending sort on "userName", set <code>sortBy</code> to "-userName".
    *
    * @param sortBy sortBy Default value is null
    */
    public void setSortBy(String sortBy) {
        setAttribute("sortBy", sortBy);
    }
    /**
     * Fieldname to sortBy, prefixed with optional "-" indicating descending sort.  For example, to sort by the field "userName" in ascending order, set <code>sortBy</code> to just "userName".  For descending sort on "userName", set <code>sortBy</code> to "-userName".
     *
     *
     * @return String
     *
     */
    public String getSortBy()  {
        return getAttributeAsString("sortBy");
    }

    /**
    * For requests submitted by a ${isc.DocUtils.linkForRef('interface:DataBoundComponent')}, the {@link com.smartgwt.client.widgets.Canvas#getID ID} of the submitting component. <P> This ID will be present for operations including automatic saves by a ListGrid  ${isc.DocUtils.linkForRef('gridEditing','during editing')}, or calls to {@link com.smartgwt.client.widgets.form.DynamicForm#saveData}.  It will not be present for a direct call to a DataSource method such as {@link com.smartgwt.client.data.DataSource#fetchData}. <P> Note this is the component's <b>String</b> ID - you can retrieve the component itself via {@link com.smartgwt.client.widgets.Canvas#getById}.
    *
    * @param componentId componentId Default value is null
    */
    public void setComponentId(String componentId) {
        setAttribute("componentId", componentId);
    }
    /**
     * For requests submitted by a ${isc.DocUtils.linkForRef('interface:DataBoundComponent')}, the {@link com.smartgwt.client.widgets.Canvas#getID ID} of the submitting component. <P> This ID will be present for operations including automatic saves by a ListGrid  ${isc.DocUtils.linkForRef('gridEditing','during editing')}, or calls to {@link com.smartgwt.client.widgets.form.DynamicForm#saveData}.  It will not be present for a direct call to a DataSource method such as {@link com.smartgwt.client.data.DataSource#fetchData}. <P> Note this is the component's <b>String</b> ID - you can retrieve the component itself via {@link com.smartgwt.client.widgets.Canvas#getById}.
     *
     *
     * @return String
     *
     */
    public String getComponentId()  {
        return getAttributeAsString("componentId");
    }

    /**
    * When a ${isc.DocUtils.linkForRef('interface:DataBoundComponent')} sends a DSRequest, the <code>dsRequest.operationId</code> will be automatically picked up from the <code>fetchOperation</code>, <code>addOperation</code>, etc properties of the DataBoundComponent.   <P> The <code>operationId</code> serves as an identifier that you can use to create variations on the 4 basic DataSource operations that are used by different components in different parts of your application.  For example, you may be using a standard <code>fetch</code> operation in one part of your application, however on another screen you want to perform a <code>fetch</code> operation on the same DataSource but interpret search criteria differently (eg full text search).   <P> If you declare more than one {@link com.smartgwt.client.data.OperationBinding} for the same {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType}, you can specify an <code>operationId</code> {@link com.smartgwt.client.data.OperationBinding#getOperationId operationId} which will cause that operationBinding to be used for dsRequests containing a matching <code>operationId</code>. This allows all the possible settings of an <code>operationBinding</code>, including {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation} or {@link com.smartgwt.client..DMI} settings, to be switched on a per-component or per-request basis.   <P> For example, by setting the <code>fetchOperation</code> on a particular ListGrid, you could cause it to invoke a different server method via DMI, different {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL} or different ${isc.DocUtils.linkForRef('operation.wsOperation','web service operation')}. <P> The <code>operationId</code> can also be directly received by the server in order to affect behavior.  When using the SmartClient Server, <code>operationId</code> can be accessed via dsRequest.getOperationId().  The {@link com.smartgwt.client.data.RestDataSource} will also send the <code>operationId</code> to the server as part of the {@link com.smartgwt.client.data.RestDataSource#getMetaDataPrefix metaDataPrefix}.   <P> Note that if you {@link com.smartgwt.client.data.DataSource#fetchData} a DataSource operation, you can also specify operationId via the <code>requestProperties</code> parameter.
    *
    * @param operationId operationId Default value is null
    */
    public void setOperationId(String operationId) {
        setAttribute("operationId", operationId);
    }

    /**
    * For "fetch" operations, how search criteria should be interpreted for text fields: either "exact" for exact match, "startsWith" for matching at the beginning only, or "substring" for case-insensitive substring match. <p> This setting is respected by the built-in SQLDataSource.  Your custom DataSource implementation can interpret the search criteria passed into "fetch" operations in arbitrary ways; you can safely ignore this flag and use others of your own devising.
    *
    * @param textMatchStyle textMatchStyle Default value is "exact"
    */
    public void setTextMatchStyle(String textMatchStyle) {
        setAttribute("textMatchStyle", textMatchStyle);
    }

    /**
    * When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when creating the input XML message to send to the web service, properties in {@link com.smartgwt.client.data.DSRequest#getData data} will be used as the values for XML elements of the same name, at any level of nesting. <P> <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as extra levels of nested elements, and provides some insulation against changes in the required structure of the input message. <P> For example, given this input message: <pre> &lt;FindServices&gt;     &lt;searchFor&gt;search text&lt;/searchFor&gt;     &lt;Options&gt;         &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;     &lt;/Options&gt;     &lt;IncludeInSearch&gt;         &lt;serviceName&gt;true&lt;/serviceName&gt;         &lt;documentation&gt;true&lt;/documentation&gt;         &lt;keywords&gt;true&lt;/keywords&gt;     &lt;/IncludeInSearch&gt; &lt;/FindServices&gt; </pre> If <code>useFlatFields</code> were <b>not</b> set, in order to fill out this message correctly, <code>request.data</code> would need to be: <pre>{    searchFor: "search text",    Options : {        caseSensitive: false,    },    IncludeInSearch : {        serviceName: true,        documentation : true,        keywords : true    } }</pre> However if useFlatFields were set, <code>request.data</code> could be just: <pre>{    searchFor: "search text",    caseSensitive: false,    serviceName: true,    documentation : true,    keywords : true }</pre> <code>useFlatFields</code> is often set when the input data comes from a {@link com.smartgwt.client.widgets.form.DynamicForm} to avoid the cumbersome and fragile process of mapping input fields to an XML structure. <P> {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} can also be set to cause <b>all</b> dsRequests of a particular type to <code>useFlatFields</code> automatically. <P> For ${isc.DocUtils.linkForRef('interface:DataBoundComponent','DataBoundComponents')},  {@link com.smartgwt.client..DataBoundComponent#getUseFlatFields useFlatFields} can be set use "flattened" binding to fields of a WSDL message or XML Schema. <P> Note that <code>useFlatFields</code> is not generally recommended for use with XML input messages where multiple simple type fields exist with the same name, however if used in this way, the first field to use a given name wins.  "first" means the first field encountered in a depth first search.  "wins" means only the first field will be populated in the generated XML message.
    *
    * @param useFlatFields useFlatFields Default value is null
    */
    public void setUseFlatFields(Boolean useFlatFields) {
        setAttribute("useFlatFields", useFlatFields);
    }
    /**
     * When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when creating the input XML message to send to the web service, properties in {@link com.smartgwt.client.data.DSRequest#getData data} will be used as the values for XML elements of the same name, at any level of nesting. <P> <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as extra levels of nested elements, and provides some insulation against changes in the required structure of the input message. <P> For example, given this input message: <pre> &lt;FindServices&gt;     &lt;searchFor&gt;search text&lt;/searchFor&gt;     &lt;Options&gt;         &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;     &lt;/Options&gt;     &lt;IncludeInSearch&gt;         &lt;serviceName&gt;true&lt;/serviceName&gt;         &lt;documentation&gt;true&lt;/documentation&gt;         &lt;keywords&gt;true&lt;/keywords&gt;     &lt;/IncludeInSearch&gt; &lt;/FindServices&gt; </pre> If <code>useFlatFields</code> were <b>not</b> set, in order to fill out this message correctly, <code>request.data</code> would need to be: <pre>{    searchFor: "search text",    Options : {        caseSensitive: false,    },    IncludeInSearch : {        serviceName: true,        documentation : true,        keywords : true    } }</pre> However if useFlatFields were set, <code>request.data</code> could be just: <pre>{    searchFor: "search text",    caseSensitive: false,    serviceName: true,    documentation : true,    keywords : true }</pre> <code>useFlatFields</code> is often set when the input data comes from a {@link com.smartgwt.client.widgets.form.DynamicForm} to avoid the cumbersome and fragile process of mapping input fields to an XML structure. <P> {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} can also be set to cause <b>all</b> dsRequests of a particular type to <code>useFlatFields</code> automatically. <P> For ${isc.DocUtils.linkForRef('interface:DataBoundComponent','DataBoundComponents')},  {@link com.smartgwt.client..DataBoundComponent#getUseFlatFields useFlatFields} can be set use "flattened" binding to fields of a WSDL message or XML Schema. <P> Note that <code>useFlatFields</code> is not generally recommended for use with XML input messages where multiple simple type fields exist with the same name, however if used in this way, the first field to use a given name wins.  "first" means the first field encountered in a depth first search.  "wins" means only the first field will be populated in the generated XML message.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseFlatFields()  {
        return getAttributeAsBoolean("useFlatFields");
    }

    /**
    * Cause the {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} XML serialization behavior to be used for <b>all</b> soap headers in the request.  See also {@link com.smartgwt.client.data.DSRequest#getHeaderData headerData}.
    *
    * @param useFlatHeaderFields useFlatHeaderFields Default value is null
    */
    public void setUseFlatHeaderFields(Boolean useFlatHeaderFields) {
        setAttribute("useFlatHeaderFields", useFlatHeaderFields);
    }
    /**
     * Cause the {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} XML serialization behavior to be used for <b>all</b> soap headers in the request.  See also {@link com.smartgwt.client.data.DSRequest#getHeaderData headerData}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseFlatHeaderFields()  {
        return getAttributeAsBoolean("useFlatHeaderFields");
    }

    /**
    * When set, causes the results of the DSRequest to be exported to a file, whose name  and format are indicated by {@link com.smartgwt.client.data.DSRequest#getExportFileName exportFileName} and  {@link com.smartgwt.client.data.DSRequest#getExportAs exportAs} respectively.  When no exportFilename is provided, the default is <i>Results</i> and the default value of exportAs is <i>csv</i>.  Once the operation completes,  {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay} specifies whether the exported data should be downloaded to the file-system or displayed in a new window.  The default value of exportDisplay is "download" which displays the Save As dialog.  See ${isc.DocUtils.linkForRef('type:ExportDisplay')}  for more information. <P> Note that an export initiated using dsRequest properties does not provide support for JSON format (see  <a href=http://forums.smartclient.com/showthread.php?t=235>this post</a> for more detail). <P> As well as setting dsRequest.exportResults and related properties, exports can be initiated in two other ways, via {@link com.smartgwt.client.data.OperationBinding}s and via custom server code which sets  export-related properties on the {@link com.smartgwt.client.data.DSResponse}.  Both of those methods support exporting to JSON format. <P> <b>Format Examples</b> <ul> <li>XML format</li> <pre>     &lt;List&gt;         &lt;Object&gt;             &lt;id&gt;10101&lt;/id&gt;             &lt;displayName&gt;Record 10101&lt;/displayName&gt;         &lt;/Object&gt;    &lt;/List&gt; </pre> <li>JSON Format</li> <pre>     [         { id: 10101, displayName: "Record 10101" }     ] </pre> <li>CSV Format</li> <pre>     id,displayName     10101,"Record 10101" </pre> </ul>
    *
    * @param exportResults exportResults Default value is false
    */
    public void setExportResults(Boolean exportResults) {
        setAttribute("exportResults", exportResults);
    }
    /**
     * When set, causes the results of the DSRequest to be exported to a file, whose name  and format are indicated by {@link com.smartgwt.client.data.DSRequest#getExportFileName exportFileName} and  {@link com.smartgwt.client.data.DSRequest#getExportAs exportAs} respectively.  When no exportFilename is provided, the default is <i>Results</i> and the default value of exportAs is <i>csv</i>.  Once the operation completes,  {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay} specifies whether the exported data should be downloaded to the file-system or displayed in a new window.  The default value of exportDisplay is "download" which displays the Save As dialog.  See ${isc.DocUtils.linkForRef('type:ExportDisplay')}  for more information. <P> Note that an export initiated using dsRequest properties does not provide support for JSON format (see  <a href=http://forums.smartclient.com/showthread.php?t=235>this post</a> for more detail). <P> As well as setting dsRequest.exportResults and related properties, exports can be initiated in two other ways, via {@link com.smartgwt.client.data.OperationBinding}s and via custom server code which sets  export-related properties on the {@link com.smartgwt.client.data.DSResponse}.  Both of those methods support exporting to JSON format. <P> <b>Format Examples</b> <ul> <li>XML format</li> <pre>     &lt;List&gt;         &lt;Object&gt;             &lt;id&gt;10101&lt;/id&gt;             &lt;displayName&gt;Record 10101&lt;/displayName&gt;         &lt;/Object&gt;    &lt;/List&gt; </pre> <li>JSON Format</li> <pre>     [         { id: 10101, displayName: "Record 10101" }     ] </pre> <li>CSV Format</li> <pre>     id,displayName     10101,"Record 10101" </pre> </ul>
     *
     *
     * @return Boolean
     *
     */
    public Boolean getExportResults()  {
        return getAttributeAsBoolean("exportResults");
    }
             
    /**
    * The format in which the data should be exported.  See ${isc.DocUtils.linkForRef('type:ExportFormat')} for more  information.
    *
    * @param exportAs exportAs Default value is "csv"
    */
    public void setExportAs(ExportFormat exportAs) {
        setAttribute("exportAs", exportAs.getValue());
    }
    /**
     * The format in which the data should be exported.  See ${isc.DocUtils.linkForRef('type:ExportFormat')} for more  information.
     *
     *
     * @return ExportFormat
     *
     */
    public ExportFormat getExportAs()  {
        return (ExportFormat) EnumUtil.getEnum(ExportFormat.values(), getAttribute("exportAs"));
    }

    /**
    * The name of the file to save the exported data into.
    *
    * @param exportFileName exportFileName Default value is null
    */
    public void setExportFileName(String exportFileName) {
        setAttribute("exportFileName", exportFileName);
    }
    /**
     * The name of the file to save the exported data into.
     *
     *
     * @return String
     *
     */
    public String getExportFileName()  {
        return getAttributeAsString("exportFileName");
    }
             
    /**
    * Specifies whether the exported data will be downloaded to the file-system or displayed in a  new window. See ${isc.DocUtils.linkForRef('type:ExportDisplay')} for more information.
    *
    * @param exportDisplay exportDisplay Default value is "download"
    */
    public void setExportDisplay(ExportDisplay exportDisplay) {
        setAttribute("exportDisplay", exportDisplay.getValue());
    }
    /**
     * Specifies whether the exported data will be downloaded to the file-system or displayed in a  new window. See ${isc.DocUtils.linkForRef('type:ExportDisplay')} for more information.
     *
     *
     * @return ExportDisplay
     *
     */
    public ExportDisplay getExportDisplay()  {
        return (ExportDisplay) EnumUtil.getEnum(ExportDisplay.values(), getAttribute("exportDisplay"));
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

}




