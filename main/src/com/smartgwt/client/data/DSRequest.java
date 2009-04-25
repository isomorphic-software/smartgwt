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
    * Request sent to the server to initiate a &#010 {@link com.smartgwt.client.docs.DataSourceOperations 'DataSource operation'}.  All properties which are legal on&#010 {@link com.smartgwt.client.rpc.RPCRequest} are legal, in addition to the properties listed here.

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
    * DataSource this DSRequest will act on.&#010 <P>&#010 This property is generally automatically populated, for example when calling&#010 {@link com.smartgwt.client.data.DataSource#fetchData} the dataSource property is set to the target&#010 DataSource.
    *
    * @param dataSource dataSource Default value is null
    */
    public void setDataSource(String dataSource) {
        setAttribute("dataSource", dataSource);
    }
    /**
     * DataSource this DSRequest will act on.&#010 <P>&#010 This property is generally automatically populated, for example when calling&#010 {@link com.smartgwt.client.data.DataSource#fetchData} the dataSource property is set to the target&#010 DataSource.
     *
     *
     * @return String
     *
     */
    public String getDataSource()  {
        return getAttributeAsString("dataSource");
    }
             
    /**
    * Type of operation being performed, "fetch", "add", "remove" or "update".&#010 <P>&#010 This property is generally automatically populated, for example when calling&#010 <code>fetchData()</code> on a DataSource or DataBound component the operationType is&#010 automatically set to "fetch".
    *
    * @param operationType operationType Default value is null
    */
    public void setOperationType(DSOperationType operationType) {
        setAttribute("operationType", operationType.getValue());
    }
    /**
     * Type of operation being performed, "fetch", "add", "remove" or "update".&#010 <P>&#010 This property is generally automatically populated, for example when calling&#010 <code>fetchData()</code> on a DataSource or DataBound component the operationType is&#010 automatically set to "fetch".
     *
     *
     * @return DSOperationType
     *
     */
    public DSOperationType getOperationType()  {
        return (DSOperationType) EnumUtil.getEnum(DSOperationType.values(), getAttribute("operationType"));
    }

    /**
    * Starting row of requested results, used only with fetch operations.&#010 <p>&#010 Note that startRow and endRow are zero-based, so startRow: 0, endRow: 1 is a request&#010 for the first two records.
    *
    * @param startRow startRow Default value is 0
    */
    public void setStartRow(int startRow) {
        setAttribute("startRow", startRow);
    }
    /**
     * Starting row of requested results, used only with fetch operations.&#010 <p>&#010 Note that startRow and endRow are zero-based, so startRow: 0, endRow: 1 is a request&#010 for the first two records.
     *
     *
     * @return int
     *
     */
    public int getStartRow()  {
        return getAttributeAsInt("startRow");
    }

    /**
    * End row of requested results, used only with fetch operations.&#010 <p>&#010 Note that startRow and endRow are zero-based, so startRow: 0, endRow: 1 is a request&#010 for the first two records.
    *
    * @param endRow endRow Default value is null
    */
    public void setEndRow(Integer endRow) {
        setAttribute("endRow", endRow);
    }
    /**
     * End row of requested results, used only with fetch operations.&#010 <p>&#010 Note that startRow and endRow are zero-based, so startRow: 0, endRow: 1 is a request&#010 for the first two records.
     *
     *
     * @return Integer
     *
     */
    public Integer getEndRow()  {
        return getAttributeAsInt("endRow");
    }

    /**
    * Fieldname to sortBy, prefixed with optional "-" indicating descending sort.  For example, to&#010 sort by the field "userName" in ascending order, set <code>sortBy</code> to just&#010 "userName".  For descending sort on "userName", set <code>sortBy</code> to "-userName".
    *
    * @param sortBy sortBy Default value is null
    */
    public void setSortBy(String sortBy) {
        setAttribute("sortBy", sortBy);
    }
    /**
     * Fieldname to sortBy, prefixed with optional "-" indicating descending sort.  For example, to&#010 sort by the field "userName" in ascending order, set <code>sortBy</code> to just&#010 "userName".  For descending sort on "userName", set <code>sortBy</code> to "-userName".
     *
     *
     * @return String
     *
     */
    public String getSortBy()  {
        return getAttributeAsString("sortBy");
    }

    /**
    * For "fetch" operations, how search criteria should be interpreted for text fields: either&#010 "exact" for exact match, "startsWith" for matching at the beginning only, or "substring" for&#010 case-insensitive substring match.&#010 <p>&#010 This setting is respected by the built-in SQLDataSource.  Your custom DataSource&#010 implementation can interpret the search criteria passed into "fetch" operations in arbitrary&#010 ways; you can safely ignore this flag and use others of your own devising.
    *
    * @param textMatchStyle textMatchStyle Default value is "exact"
    */
    public void setTextMatchStyle(String textMatchStyle) {
        setAttribute("textMatchStyle", textMatchStyle);
    }

    /**
    * For requests submitted by a ${isc.DocUtils.linkForRef('interface:DataBoundComponent')}, the {@link com.smartgwt.client.widgets.Canvas#getID ID} of the&#010 submitting component.&#010 <P>&#010 This ID will be present for operations including automatic saves by a ListGrid &#010 {@link com.smartgwt.client.docs.Editing 'during editing'}, or calls to&#010 {@link com.smartgwt.client.widgets.form.DynamicForm#saveData}.  It will not be present for a direct&#010 call to a DataSource method such as {@link com.smartgwt.client.data.DataSource#fetchData}.&#010 <P>&#010 Note this is the component's <b>String</b> ID - you can retrieve the component itself&#010 via {@link com.smartgwt.client.widgets.Canvas#getById}.
    *
    * @param componentId componentId Default value is null
    */
    public void setComponentId(String componentId) {
        setAttribute("componentId", componentId);
    }
    /**
     * For requests submitted by a ${isc.DocUtils.linkForRef('interface:DataBoundComponent')}, the {@link com.smartgwt.client.widgets.Canvas#getID ID} of the&#010 submitting component.&#010 <P>&#010 This ID will be present for operations including automatic saves by a ListGrid &#010 {@link com.smartgwt.client.docs.Editing 'during editing'}, or calls to&#010 {@link com.smartgwt.client.widgets.form.DynamicForm#saveData}.  It will not be present for a direct&#010 call to a DataSource method such as {@link com.smartgwt.client.data.DataSource#fetchData}.&#010 <P>&#010 Note this is the component's <b>String</b> ID - you can retrieve the component itself&#010 via {@link com.smartgwt.client.widgets.Canvas#getById}.
     *
     *
     * @return String
     *
     */
    public String getComponentId()  {
        return getAttributeAsString("componentId");
    }

    /**
    * When a ${isc.DocUtils.linkForRef('interface:DataBoundComponent')} sends a DSRequest, the&#010 <code>dsRequest.operationId</code> will be automatically picked up from the&#010 <code>fetchOperation</code>, <code>addOperation</code>, etc properties of the&#010 DataBoundComponent.  &#010 <P>&#010 The <code>operationId</code> serves as an identifier that you can use to create&#010 variations on the 4 basic DataSource operations that are used by different components in&#010 different parts of your application.  For example, you may be using a standard&#010 <code>fetch</code> operation in one part of your application, however on another screen you&#010 want to perform a <code>fetch</code> operation on the same DataSource but interpret search&#010 criteria differently (eg full text search).  &#010 <P>&#010 If you declare more than one {@link com.smartgwt.client.data.OperationBinding} for the same&#010 {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType}, you can specify an <code>operationId</code>&#010 {@link com.smartgwt.client.data.OperationBinding#getOperationId operationId} which will cause that&#010 operationBinding to be used for dsRequests containing a matching <code>operationId</code>.&#010 This allows all the possible settings of an <code>operationBinding</code>, including&#010 {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation} or {@link com.smartgwt.client..DMI} settings, to be switched on a&#010 per-component or per-request basis.  &#010 <P>&#010 For example, by setting the <code>fetchOperation</code> on a particular ListGrid, you could&#010 cause it to invoke a different server method via DMI, different&#010 {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL} or different {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation}.&#010 <P>&#010 The <code>operationId</code> can also be directly received by the server in order to affect&#010 behavior.  When using the SmartGWT Server, <code>operationId</code> can be accessed via&#010 dsRequest.getOperationId().  The {@link com.smartgwt.client.data.RestDataSource} will also send the&#010 <code>operationId</code> to the server as part of the&#010 {@link com.smartgwt.client.data.RestDataSource#getMetaDataPrefix metaDataPrefix}.  &#010 <P>&#010 Note that if you {@link com.smartgwt.client.data.DataSource#fetchData} a DataSource operation, you can&#010 also specify operationId via the <code>requestProperties</code> parameter.
    *
    * @param operationId operationId Default value is null
    */
    public void setOperationId(String operationId) {
        setAttribute("operationId", operationId);
    }

    /**
     * Automatically generated unique ID for this request. This ID will be required by developers &#010 making use of the ${isc.DocUtils.linkForRef('type:DSProtocol','"clientCustom" dataProtocol')}.
     *
     *
     * @return String
     *
     */
    public String getRequestId()  {
        return getAttributeAsString("requestId");
    }

    /**
    * When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when&#010 creating the input XML message to send to the web service, properties in&#010 {@link com.smartgwt.client.data.DSRequest#getData data} will be used as the values for XML elements of the same name, at&#010 any level of nesting.&#010 <P>&#010 <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as&#010 extra levels of nested elements, and provides some insulation against changes in the&#010 required structure of the input message.&#010 <P>&#010 For example, given this input message:&#010 <pre>&#010 &lt;FindServices&gt;&#010     &lt;searchFor&gt;search text&lt;/searchFor&gt;&#010     &lt;Options&gt;&#010         &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;&#010     &lt;/Options&gt;&#010     &lt;IncludeInSearch&gt;&#010         &lt;serviceName&gt;true&lt;/serviceName&gt;&#010         &lt;documentation&gt;true&lt;/documentation&gt;&#010         &lt;keywords&gt;true&lt;/keywords&gt;&#010     &lt;/IncludeInSearch&gt;&#010 &lt;/FindServices&gt;&#010 </pre>&#010 If <code>useFlatFields</code> were <b>not</b> set, in order to fill out this message&#010 correctly, <code>request.data</code> would need to be:&#010 <pre>{&#010    searchFor: "search text",&#010    Options : {&#010        caseSensitive: false,&#010    },&#010    IncludeInSearch : {&#010        serviceName: true,&#010        documentation : true,&#010        keywords : true&#010    }&#010 }</pre>&#010 However if useFlatFields were set, <code>request.data</code> could be just:&#010 <pre>{&#010    searchFor: "search text",&#010    caseSensitive: false,&#010    serviceName: true,&#010    documentation : true,&#010    keywords : true&#010 }</pre>&#010 <code>useFlatFields</code> is often set when the input data comes from a {@link com.smartgwt.client.widgets.form.DynamicForm}&#010 to avoid the cumbersome and fragile process of mapping input fields to an XML structure.&#010 <P>&#010 {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} can also be set to cause <b>all</b> dsRequests of a&#010 particular type to <code>useFlatFields</code> automatically.&#010 <P>&#010 For ${isc.DocUtils.linkForRef('interface:DataBoundComponent','DataBoundComponents')}, &#010 {@link com.smartgwt.client..DataBoundComponent#getUseFlatFields useFlatFields} can be set use "flattened"&#010 binding to fields of a WSDL message or XML Schema.&#010 <P>&#010 Note that <code>useFlatFields</code> is not generally recommended for use with XML input&#010 messages where multiple simple type fields exist with the same name, however if used in this&#010 way, the first field to use a given name wins.  "first" means the first field encountered in a&#010 depth first search.  "wins" means only the first field will be populated in the generated&#010 XML message.
    *
    * @param useFlatFields useFlatFields Default value is null
    */
    public void setUseFlatFields(Boolean useFlatFields) {
        setAttribute("useFlatFields", useFlatFields);
    }
    /**
     * When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when&#010 creating the input XML message to send to the web service, properties in&#010 {@link com.smartgwt.client.data.DSRequest#getData data} will be used as the values for XML elements of the same name, at&#010 any level of nesting.&#010 <P>&#010 <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as&#010 extra levels of nested elements, and provides some insulation against changes in the&#010 required structure of the input message.&#010 <P>&#010 For example, given this input message:&#010 <pre>&#010 &lt;FindServices&gt;&#010     &lt;searchFor&gt;search text&lt;/searchFor&gt;&#010     &lt;Options&gt;&#010         &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;&#010     &lt;/Options&gt;&#010     &lt;IncludeInSearch&gt;&#010         &lt;serviceName&gt;true&lt;/serviceName&gt;&#010         &lt;documentation&gt;true&lt;/documentation&gt;&#010         &lt;keywords&gt;true&lt;/keywords&gt;&#010     &lt;/IncludeInSearch&gt;&#010 &lt;/FindServices&gt;&#010 </pre>&#010 If <code>useFlatFields</code> were <b>not</b> set, in order to fill out this message&#010 correctly, <code>request.data</code> would need to be:&#010 <pre>{&#010    searchFor: "search text",&#010    Options : {&#010        caseSensitive: false,&#010    },&#010    IncludeInSearch : {&#010        serviceName: true,&#010        documentation : true,&#010        keywords : true&#010    }&#010 }</pre>&#010 However if useFlatFields were set, <code>request.data</code> could be just:&#010 <pre>{&#010    searchFor: "search text",&#010    caseSensitive: false,&#010    serviceName: true,&#010    documentation : true,&#010    keywords : true&#010 }</pre>&#010 <code>useFlatFields</code> is often set when the input data comes from a {@link com.smartgwt.client.widgets.form.DynamicForm}&#010 to avoid the cumbersome and fragile process of mapping input fields to an XML structure.&#010 <P>&#010 {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} can also be set to cause <b>all</b> dsRequests of a&#010 particular type to <code>useFlatFields</code> automatically.&#010 <P>&#010 For ${isc.DocUtils.linkForRef('interface:DataBoundComponent','DataBoundComponents')}, &#010 {@link com.smartgwt.client..DataBoundComponent#getUseFlatFields useFlatFields} can be set use "flattened"&#010 binding to fields of a WSDL message or XML Schema.&#010 <P>&#010 Note that <code>useFlatFields</code> is not generally recommended for use with XML input&#010 messages where multiple simple type fields exist with the same name, however if used in this&#010 way, the first field to use a given name wins.  "first" means the first field encountered in a&#010 depth first search.  "wins" means only the first field will be populated in the generated&#010 XML message.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseFlatFields()  {
        return getAttributeAsBoolean("useFlatFields");
    }

    /**
    * Cause the {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} XML serialization behavior to be used&#010 for <b>all</b> soap headers in the request.  See also {@link com.smartgwt.client.data.DSRequest#getHeaderData headerData}.
    *
    * @param useFlatHeaderFields useFlatHeaderFields Default value is null
    */
    public void setUseFlatHeaderFields(Boolean useFlatHeaderFields) {
        setAttribute("useFlatHeaderFields", useFlatHeaderFields);
    }
    /**
     * Cause the {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} XML serialization behavior to be used&#010 for <b>all</b> soap headers in the request.  See also {@link com.smartgwt.client.data.DSRequest#getHeaderData headerData}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseFlatHeaderFields()  {
        return getAttributeAsBoolean("useFlatHeaderFields");
    }

    /**
    * When set, causes the results of the DSRequest to be exported to a file, whose name &#010 and format are indicated by {@link com.smartgwt.client.data.DSRequest#getExportFilename exportFilename} and &#010 {@link com.smartgwt.client.data.DSRequest#getExportAs exportAs} respectively.  When no exportFilename is provided, the default is&#010 <i>Results</i> and the default value of exportAs is <i>csv</i>.  &#010 <P>&#010 The export field-list can also be configured, see {@link com.smartgwt.client.data.DSRequest#getExportFields exportFields}.&#010 <P>&#010 Once the operation completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay} specifies whether the exported&#010 data should be downloaded to the file-system or displayed in a new window.  The default value&#010 of exportDisplay is "download" which displays the Save As dialog.  See ${isc.DocUtils.linkForRef('type:ExportDisplay')} &#010 for more information.&#010 <P>&#010 You can also configure the style of line-breaks to use when generating the output.  See&#010 ${isc.DocUtils.linkForRef('type:LineBreakStyle')} for more information.&#010 <P>&#010 Note that an export initiated using dsRequest properties does not provide support for JSON&#010 format (see &#010 <a href="http://forums.smartclient.com/showthread.php?t=235">this post</a> for more detail).&#010 <P>&#010 As well as setting dsRequest.exportResults and related properties, exports can be initiated&#010 in two other ways, via {@link com.smartgwt.client.data.OperationBinding}s and via custom server code which sets &#010 export-related properties on the {@link com.smartgwt.client.data.DSResponse}.  Both of those methods support exporting&#010 to JSON format.&#010 <P>&#010 <b>Format Examples</b>&#010 XML format&#010 <pre>&#010     &lt;List&gt;&#010         &lt;Object&gt;&#010             &lt;id&gt;10101&lt;/id&gt;&#010             &lt;displayName&gt;Record 10101&lt;/displayName&gt;&#010         &lt;/Object&gt;&#010    &lt;/List&gt;&#010 </pre>&#010 JSON Format&#010 <pre>&#010     [&#010         { id: 10101, displayName: "Record 10101" }&#010     ]&#010 </pre>&#010 CSV Format&#010 <pre>&#010     id,displayName&#010     10101,"Record 10101"&#010 </pre>
    *
    * @param exportResults exportResults Default value is false
    */
    public void setExportResults(Boolean exportResults) {
        setAttribute("exportResults", exportResults);
    }
    /**
     * When set, causes the results of the DSRequest to be exported to a file, whose name &#010 and format are indicated by {@link com.smartgwt.client.data.DSRequest#getExportFilename exportFilename} and &#010 {@link com.smartgwt.client.data.DSRequest#getExportAs exportAs} respectively.  When no exportFilename is provided, the default is&#010 <i>Results</i> and the default value of exportAs is <i>csv</i>.  &#010 <P>&#010 The export field-list can also be configured, see {@link com.smartgwt.client.data.DSRequest#getExportFields exportFields}.&#010 <P>&#010 Once the operation completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay} specifies whether the exported&#010 data should be downloaded to the file-system or displayed in a new window.  The default value&#010 of exportDisplay is "download" which displays the Save As dialog.  See ${isc.DocUtils.linkForRef('type:ExportDisplay')} &#010 for more information.&#010 <P>&#010 You can also configure the style of line-breaks to use when generating the output.  See&#010 ${isc.DocUtils.linkForRef('type:LineBreakStyle')} for more information.&#010 <P>&#010 Note that an export initiated using dsRequest properties does not provide support for JSON&#010 format (see &#010 <a href="http://forums.smartclient.com/showthread.php?t=235">this post</a> for more detail).&#010 <P>&#010 As well as setting dsRequest.exportResults and related properties, exports can be initiated&#010 in two other ways, via {@link com.smartgwt.client.data.OperationBinding}s and via custom server code which sets &#010 export-related properties on the {@link com.smartgwt.client.data.DSResponse}.  Both of those methods support exporting&#010 to JSON format.&#010 <P>&#010 <b>Format Examples</b>&#010 XML format&#010 <pre>&#010     &lt;List&gt;&#010         &lt;Object&gt;&#010             &lt;id&gt;10101&lt;/id&gt;&#010             &lt;displayName&gt;Record 10101&lt;/displayName&gt;&#010         &lt;/Object&gt;&#010    &lt;/List&gt;&#010 </pre>&#010 JSON Format&#010 <pre>&#010     [&#010         { id: 10101, displayName: "Record 10101" }&#010     ]&#010 </pre>&#010 CSV Format&#010 <pre>&#010     id,displayName&#010     10101,"Record 10101"&#010 </pre>
     *
     *
     * @return Boolean
     *
     */
    public Boolean getExportResults()  {
        return getAttributeAsBoolean("exportResults");
    }
             
    /**
    * The format in which the data should be exported.  See ${isc.DocUtils.linkForRef('type:ExportFormat')} for more &#010 information.
    *
    * @param exportAs exportAs Default value is "csv"
    */
    public void setExportAs(ExportFormat exportAs) {
        setAttribute("exportAs", exportAs.getValue());
    }
    /**
     * The format in which the data should be exported.  See ${isc.DocUtils.linkForRef('type:ExportFormat')} for more &#010 information.
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
     *
     */
    public String getExportFilename()  {
        return getAttributeAsString("exportFilename");
    }
             
    /**
    * Specifies whether the exported data will be downloaded to the file-system or displayed in a &#010 new window. See ${isc.DocUtils.linkForRef('type:ExportDisplay')} for more information.
    *
    * @param exportDisplay exportDisplay Default value is "download"
    */
    public void setExportDisplay(ExportDisplay exportDisplay) {
        setAttribute("exportDisplay", exportDisplay.getValue());
    }
    /**
     * Specifies whether the exported data will be downloaded to the file-system or displayed in a &#010 new window. See ${isc.DocUtils.linkForRef('type:ExportDisplay')} for more information.
     *
     *
     * @return ExportDisplay
     *
     */
    public ExportDisplay getExportDisplay()  {
        return (ExportDisplay) EnumUtil.getEnum(ExportDisplay.values(), getAttribute("exportDisplay"));
    }

    /**
    * The style of line-breaks to use in the exported output.  See ${isc.DocUtils.linkForRef('type:LineBreakStyle')} for&#010 more information.
    *
    * @param lineBreakStyle lineBreakStyle Default value is null
    */
    public void setLineBreakStyle(String lineBreakStyle) {
        setAttribute("lineBreakStyle", lineBreakStyle);
    }
    /**
     * The style of line-breaks to use in the exported output.  See ${isc.DocUtils.linkForRef('type:LineBreakStyle')} for&#010 more information.
     *
     *
     * @return String
     *
     */
    public String getLineBreakStyle()  {
        return getAttributeAsString("lineBreakStyle");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

}




