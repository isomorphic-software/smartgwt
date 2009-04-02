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
    * An operationBinding tells a DataSource how to execute one of the basic DS operations: fetch, add, update, remove.  See {@link com.smartgwt.client.data.DataSource#getOperationBindings operationBindings}.

    */
public class OperationBinding extends DataClass {

    public static OperationBinding getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new OperationBinding(jsObj);
    }


    public OperationBinding(){
        
    }

    public OperationBinding(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************
             
    /**
    * Which operationType this operationBinding is for.  This property is only settable on an operationBinding, not a DataSource as a whole.
    *
    * @param operationType operationType Default value is null
    */
    public void setOperationType(DSOperationType operationType) {
        setAttribute("operationType", operationType.getValue());
    }
    /**
     * Which operationType this operationBinding is for.  This property is only settable on an operationBinding, not a DataSource as a whole.
     *
     *
     * @return DSOperationType
     *
     */
    public DSOperationType getOperationType()  {
        return (DSOperationType) EnumUtil.getEnum(DSOperationType.values(), getAttribute("operationType"));
    }

    /**
    * Optional operationId if this DataSource supports two or more variants of one of the basic DataSource operations, for instance, a "fetch" that uses full text search and a "fetch" that accepts per-field search criteria.  See {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} for usage.
    *
    * @param operationId operationId Default value is null
    */
    public void setOperationId(String operationId) {
        setAttribute("operationId", operationId);
    }
    /**
     * Optional operationId if this DataSource supports two or more variants of one of the basic DataSource operations, for instance, a "fetch" that uses full text search and a "fetch" that accepts per-field search criteria.  See {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} for usage.
     *
     *
     * @return String
     *
     */
    public String getOperationId()  {
        return getAttributeAsString("operationId");
    }

    /**
    * The name of the method to invoke on the {@link com.smartgwt.client..ServerObject} for this operationBinding.
    *
    * @param serverMethod serverMethod Default value is null
    */
    public void setServerMethod(String serverMethod) {
        setAttribute("serverMethod", serverMethod);
    }
    /**
     * The name of the method to invoke on the {@link com.smartgwt.client..ServerObject} for this operationBinding.
     *
     *
     * @return String
     *
     */
    public String getServerMethod()  {
        return getAttributeAsString("serverMethod");
    }

    /**
    * You can explicitly declare the arguments to be passed to {@link com.smartgwt.client.data.OperationBinding#getServerMethod serverMethod} using this attribute.  This isn't required - in the absense of <code>methodArguments</code>, the DMI implementation will still automagically pass a stock set of arguments to your method (see the overview in {@link com.smartgwt.client..ServerObject}), but specifying arguments explicitly gives you more flexibility in what can be passed. <p> The format for specifying <code>methodArguments</code> is as a comma separated list of VTL (Velocity Template Language) expressions.  See the <a href='http://jakarta.apache.org/velocity/docs/vtl-reference-guide.html' onclick="window.open('http://jakarta.apache.org/velocity/docs/vtl-reference-guide.html');return false;">VTL Reference</a> and <a href='http://jakarta.apache.org/velocity/docs/user-guide.html' onclick="window.open('http://jakarta.apache.org/velocity/docs/user-guide.html');return false;">Velocity User Guide</a>  for an overview of how to use VTL. <p> The Velocity context is pre-populated with the following variables - you can pass these verbatim as arguments, or call methods on these objects and pass the resulting values: <ul> <li>dsRequest: instance of the current DSRequest <li>request: the current HttpServletRequest <li>response: the current HttpServletResponse <li>rpcManager: the instance of RPCManager for this request <li>dataSource: a DataSource instance for this request </ul> So, for example, if you had a method signature like the following: <p><code> public DSResponse fetch(SupplyItem creteria, long startRow, long endRow) </code><p> You can invoke it by specifying <code>methodArguments</code> as follows: <p><code> methodArguments="$dsRequest.criteria, $dsRequest.startRow, $dsRequest.endRow" </code></p> Without <code>methodArguments</code>, there would be no way for you to specify <code>startRow/endRow</code> as arguments.  You could, of course, simply declare the method to take a <code>DSRequest</code> object and call <code>getStartRow()/getEndRow()</code> in the body of the method.
    *
    * @param methodArguments methodArguments Default value is null
    */
    public void setMethodArguments(String methodArguments) {
        setAttribute("methodArguments", methodArguments);
    }
    /**
     * You can explicitly declare the arguments to be passed to {@link com.smartgwt.client.data.OperationBinding#getServerMethod serverMethod} using this attribute.  This isn't required - in the absense of <code>methodArguments</code>, the DMI implementation will still automagically pass a stock set of arguments to your method (see the overview in {@link com.smartgwt.client..ServerObject}), but specifying arguments explicitly gives you more flexibility in what can be passed. <p> The format for specifying <code>methodArguments</code> is as a comma separated list of VTL (Velocity Template Language) expressions.  See the <a href='http://jakarta.apache.org/velocity/docs/vtl-reference-guide.html' onclick="window.open('http://jakarta.apache.org/velocity/docs/vtl-reference-guide.html');return false;">VTL Reference</a> and <a href='http://jakarta.apache.org/velocity/docs/user-guide.html' onclick="window.open('http://jakarta.apache.org/velocity/docs/user-guide.html');return false;">Velocity User Guide</a>  for an overview of how to use VTL. <p> The Velocity context is pre-populated with the following variables - you can pass these verbatim as arguments, or call methods on these objects and pass the resulting values: <ul> <li>dsRequest: instance of the current DSRequest <li>request: the current HttpServletRequest <li>response: the current HttpServletResponse <li>rpcManager: the instance of RPCManager for this request <li>dataSource: a DataSource instance for this request </ul> So, for example, if you had a method signature like the following: <p><code> public DSResponse fetch(SupplyItem creteria, long startRow, long endRow) </code><p> You can invoke it by specifying <code>methodArguments</code> as follows: <p><code> methodArguments="$dsRequest.criteria, $dsRequest.startRow, $dsRequest.endRow" </code></p> Without <code>methodArguments</code>, there would be no way for you to specify <code>startRow/endRow</code> as arguments.  You could, of course, simply declare the method to take a <code>DSRequest</code> object and call <code>getStartRow()/getEndRow()</code> in the body of the method.
     *
     *
     * @return String
     *
     */
    public String getMethodArguments()  {
        return getAttributeAsString("methodArguments");
    }

    /**
    * Name of the web service operation that will be invoked in order to execute this DataSource operation. <P> Valid only for a DataSource that has a WebService ({@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace} is set).  Otherwise, use {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL}. <P> Setting <code>wsOperation</code> means that {@link com.smartgwt.client.data.DSRequest#getData data} will be serialized as the request message for the specified web service operation, with namespacing and soap encoding handled automatically.  See {@link com.smartgwt.client.data.DataSource#transformRequest} for how to customize what data is sent to the server.
    *
    * @param wsOperation wsOperation Default value is null
    */
    public void setWsOperation(String wsOperation) {
        setAttribute("wsOperation", wsOperation);
    }
    /**
     * Name of the web service operation that will be invoked in order to execute this DataSource operation. <P> Valid only for a DataSource that has a WebService ({@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace} is set).  Otherwise, use {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL}. <P> Setting <code>wsOperation</code> means that {@link com.smartgwt.client.data.DSRequest#getData data} will be serialized as the request message for the specified web service operation, with namespacing and soap encoding handled automatically.  See {@link com.smartgwt.client.data.DataSource#transformRequest} for how to customize what data is sent to the server.
     *
     *
     * @return String
     *
     */
    public String getWsOperation()  {
        return getAttributeAsString("wsOperation");
    }

    /**
    * URL to contact to fulfill DSRequests for this operationBinding. <P> <code>dataURL</code> is typically set as DataSource.dataURL rather than on each individual operationBinding. <P> <code>dataURL</code> can be omitted for a DataSource using a Web Service ({@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace} is set).
    *
    * @param dataURL dataURL Default value is null
    */
    public void setDataURL(String dataURL) {
        setAttribute("dataURL", dataURL);
    }
    /**
     * URL to contact to fulfill DSRequests for this operationBinding. <P> <code>dataURL</code> is typically set as DataSource.dataURL rather than on each individual operationBinding. <P> <code>dataURL</code> can be omitted for a DataSource using a Web Service ({@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace} is set).
     *
     *
     * @return String
     *
     */
    public String getDataURL()  {
        return getAttributeAsString("dataURL");
    }
             
    /**
    * Controls the format in which inputs are sent to the dataURL. <p> When a DataSource operation such as fetchData() is invoked on this DataSource or a component bound to this DataSource, the data passed to the operation, if any, will be sent to the <code>dataURL</code>.  The <code>dataProtocol</code> property controls the format in which the data is sent: SOAP message, HTTP GET or POST of parameters, etc. <P> The <code>dataProtocol</code> property need not be set for a DataSource with a WebService ( {@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace} is set), in this case, SOAP messaging is used by default. <P> Developers may completely bypass the SmartClient comm system by setting dataProtocol to <code>"clientCustom"</code>. In this case SmartClient will not attempt to send any data to the server after calling {@link com.smartgwt.client.data.DataSource#transformRequest}. Instead the developer is expected to implement <code>transformRequest()</code> such that it performs the necessary data action outside of SmartClient, and then calls {@link com.smartgwt.client.data.DataSource#processResponse},  passing in the {@link com.smartgwt.client.data.DSRequest#getRequestId requestId} and an appropriate set of DSResponse properties to indicate the result of the action. <P> NOTE: when {@link com.smartgwt.client.data.OperationBinding#getDataFormat dataFormat} is "iscServer", <code>dataProtocol</code> is not consulted. Instead, SmartClient uses a proprietary wire format to communicate with the SmartClient server, and the server-side DSRequest and DSResponse objects should be used to access request data and form responses.
    *
    * @param dataProtocol dataProtocol Default value is "getParams"
    */
    public void setDataProtocol(DSProtocol dataProtocol) {
        setAttribute("dataProtocol", dataProtocol.getValue());
    }
    /**
     * Controls the format in which inputs are sent to the dataURL. <p> When a DataSource operation such as fetchData() is invoked on this DataSource or a component bound to this DataSource, the data passed to the operation, if any, will be sent to the <code>dataURL</code>.  The <code>dataProtocol</code> property controls the format in which the data is sent: SOAP message, HTTP GET or POST of parameters, etc. <P> The <code>dataProtocol</code> property need not be set for a DataSource with a WebService ( {@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace} is set), in this case, SOAP messaging is used by default. <P> Developers may completely bypass the SmartClient comm system by setting dataProtocol to <code>"clientCustom"</code>. In this case SmartClient will not attempt to send any data to the server after calling {@link com.smartgwt.client.data.DataSource#transformRequest}. Instead the developer is expected to implement <code>transformRequest()</code> such that it performs the necessary data action outside of SmartClient, and then calls {@link com.smartgwt.client.data.DataSource#processResponse},  passing in the {@link com.smartgwt.client.data.DSRequest#getRequestId requestId} and an appropriate set of DSResponse properties to indicate the result of the action. <P> NOTE: when {@link com.smartgwt.client.data.OperationBinding#getDataFormat dataFormat} is "iscServer", <code>dataProtocol</code> is not consulted. Instead, SmartClient uses a proprietary wire format to communicate with the SmartClient server, and the server-side DSRequest and DSResponse objects should be used to access request data and form responses.
     *
     *
     * @return DSProtocol
     *
     */
    public DSProtocol getDataProtocol()  {
        return (DSProtocol) EnumUtil.getEnum(DSProtocol.values(), getAttribute("dataProtocol"));
    }
             
    /**
    * Format for response data for this operation. <P> Typically set once for the DataSource as a whole via {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat}.
    *
    * @param dataFormat dataFormat Default value is "iscServer"
    */
    public void setDataFormat(DSDataFormat dataFormat) {
        setAttribute("dataFormat", dataFormat.getValue());
    }
    /**
     * Format for response data for this operation. <P> Typically set once for the DataSource as a whole via {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat}.
     *
     *
     * @return DSDataFormat
     *
     */
    public DSDataFormat getDataFormat()  {
        return (DSDataFormat) EnumUtil.getEnum(DSDataFormat.values(), getAttribute("dataFormat"));
    }
             
    /**
    * Transport to use for this operation.  Defaults to {@link com.smartgwt.client.data.DataSource#getDataTransport dataTransport}, which in turn defaults to {@link com.smartgwt.client.rpc.RPCManager#defaultTransport}.  This would typically only be set to enable "scriptInclude" transport for contacting {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} web services hosted on servers other than the origin server. <p> When using the "scriptInclude" transport, be sure to set {@link com.smartgwt.client.data.DataSource#getCallbackParam callbackParam} or {@link com.smartgwt.client.data.OperationBinding#getCallbackParam callbackParam} to match the name of the query parameter name expected by your JSON service provider.
    *
    * @param dataTransport dataTransport Default value is RPCManager.defaultTransport
    */
    public void setDataTransport(RPCTransport dataTransport) {
        setAttribute("dataTransport", dataTransport.getValue());
    }
    /**
     * Transport to use for this operation.  Defaults to {@link com.smartgwt.client.data.DataSource#getDataTransport dataTransport}, which in turn defaults to {@link com.smartgwt.client.rpc.RPCManager#defaultTransport}.  This would typically only be set to enable "scriptInclude" transport for contacting {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} web services hosted on servers other than the origin server. <p> When using the "scriptInclude" transport, be sure to set {@link com.smartgwt.client.data.DataSource#getCallbackParam callbackParam} or {@link com.smartgwt.client.data.OperationBinding#getCallbackParam callbackParam} to match the name of the query parameter name expected by your JSON service provider.
     *
     *
     * @return RPCTransport
     *
     */
    public RPCTransport getDataTransport()  {
        return (RPCTransport) EnumUtil.getEnum(RPCTransport.values(), getAttribute("dataTransport"));
    }

    /**
    * Applies only to dataFormat: "json".  Specifies the name of the query parameter that tells your JSON service what function to call as part of the response for this operation. <P> Typically set once for the DataSource as a whole via {@link com.smartgwt.client.data.DataSource#getCallbackParam callbackParam}.
    *
    * @param callbackParam callbackParam Default value is "callback"
    */
    public void setCallbackParam(String callbackParam) {
        setAttribute("callbackParam", callbackParam);
    }
    /**
     * Applies only to dataFormat: "json".  Specifies the name of the query parameter that tells your JSON service what function to call as part of the response for this operation. <P> Typically set once for the DataSource as a whole via {@link com.smartgwt.client.data.DataSource#getCallbackParam callbackParam}.
     *
     *
     * @return String
     *
     */
    public String getCallbackParam()  {
        return getAttributeAsString("callbackParam");
    }

    /**
    * When set, causes the results of the DataSource Operation to be exported to a file, whose  name and format are indicated by {@link com.smartgwt.client.data.OperationBinding#getExportFileName exportFileName} and  {@link com.smartgwt.client.data.OperationBinding#getExportAs exportAs} respectively.  When no exportFilename is provided, the  default is <i>Results</i> and the default value of exportAs is <i>csv</i>.  Once the Operation  completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay} specifies whether the  exported data will be downloaded to the file-system or displayed in a new window.   The  default value of exportDisplay is "download" which displays the Save As dialog.  See  ${isc.DocUtils.linkForRef('type:ExportDisplay')} for more information. <P> The export field-list can also be configured, see {@link com.smartgwt.client.data.DSRequest#getExportFields exportFields}. <P> You can also configure the style of line-breaks to use when generating the output.  See ${isc.DocUtils.linkForRef('type:LineBreakStyle')} for more information. <P> As well as setting this and other properties on the {@link com.smartgwt.client.data.OperationBinding}, Exports can be  initiated in two other ways.  You can set properties on the dsRequest by passing  <i>requestProperties</i> into {@link com.smartgwt.client.data.DataSource#exportData}.  Note that this method does not support exporting to JSON format (see  <a href=http://forums.smartclient.com/showthread.php?t=235>this post</a> for more detail). Additionally, custom server code may set export-related properties on the  {@link com.smartgwt.client.data.DSResponse}. <P> <b>Format Examples</b> <ul> <li>XML format</li> <pre>     &lt;List&gt;         &lt;Object&gt;             &lt;id&gt;10101&lt;/id&gt;             &lt;displayName&gt;Record 10101&lt;/displayName&gt;         &lt;/Object&gt;    &lt;/List&gt; </pre> <li>JSON Format</li> <pre>     [         { id: 10101, displayName: "Record 10101" }     ] </pre> <li>CSV Format</li> <pre>     id,displayName     10101,"Record 10101" </pre> </ul>
    *
    * @param exportResults exportResults Default value is false
    */
    public void setExportResults(Boolean exportResults) {
        setAttribute("exportResults", exportResults);
    }
    /**
     * When set, causes the results of the DataSource Operation to be exported to a file, whose  name and format are indicated by {@link com.smartgwt.client.data.OperationBinding#getExportFileName exportFileName} and  {@link com.smartgwt.client.data.OperationBinding#getExportAs exportAs} respectively.  When no exportFilename is provided, the  default is <i>Results</i> and the default value of exportAs is <i>csv</i>.  Once the Operation  completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay} specifies whether the  exported data will be downloaded to the file-system or displayed in a new window.   The  default value of exportDisplay is "download" which displays the Save As dialog.  See  ${isc.DocUtils.linkForRef('type:ExportDisplay')} for more information. <P> The export field-list can also be configured, see {@link com.smartgwt.client.data.DSRequest#getExportFields exportFields}. <P> You can also configure the style of line-breaks to use when generating the output.  See ${isc.DocUtils.linkForRef('type:LineBreakStyle')} for more information. <P> As well as setting this and other properties on the {@link com.smartgwt.client.data.OperationBinding}, Exports can be  initiated in two other ways.  You can set properties on the dsRequest by passing  <i>requestProperties</i> into {@link com.smartgwt.client.data.DataSource#exportData}.  Note that this method does not support exporting to JSON format (see  <a href=http://forums.smartclient.com/showthread.php?t=235>this post</a> for more detail). Additionally, custom server code may set export-related properties on the  {@link com.smartgwt.client.data.DSResponse}. <P> <b>Format Examples</b> <ul> <li>XML format</li> <pre>     &lt;List&gt;         &lt;Object&gt;             &lt;id&gt;10101&lt;/id&gt;             &lt;displayName&gt;Record 10101&lt;/displayName&gt;         &lt;/Object&gt;    &lt;/List&gt; </pre> <li>JSON Format</li> <pre>     [         { id: 10101, displayName: "Record 10101" }     ] </pre> <li>CSV Format</li> <pre>     id,displayName     10101,"Record 10101" </pre> </ul>
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
    * The style of line-breaks to use in the exported output.  See ${isc.DocUtils.linkForRef('type:LineBreakStyle')} for more information.
    *
    * @param lineBreakStyle lineBreakStyle Default value is null
    */
    public void setLineBreakStyle(String lineBreakStyle) {
        setAttribute("lineBreakStyle", lineBreakStyle);
    }
    /**
     * The style of line-breaks to use in the exported output.  See ${isc.DocUtils.linkForRef('type:LineBreakStyle')} for more information.
     *
     *
     * @return String
     *
     */
    public String getLineBreakStyle()  {
        return getAttributeAsString("lineBreakStyle");
    }

    /**
    * Configures {@link com.smartgwt.client.data.DataSource#getPreventHTTPCaching preventHTTPCaching} on a per-operationType basis.
    *
    * @param preventHTTPCaching preventHTTPCaching Default value is null
    */
    public void setPreventHTTPCaching(Boolean preventHTTPCaching) {
        setAttribute("preventHTTPCaching", preventHTTPCaching);
    }
    /**
     * Configures {@link com.smartgwt.client.data.DataSource#getPreventHTTPCaching preventHTTPCaching} on a per-operationType basis.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getPreventHTTPCaching()  {
        return getAttributeAsBoolean("preventHTTPCaching");
    }

    /**
    * For an XML or JSON DataSource, XPath expression used to retrieve the objects that will become DataSource records. <p> For example, an "ItemSearch" web service might return a "Results" structure containing metadata along with the set of Items that one might want to display in a grid.  An XPath expression like "/Results/Items" could be used to retrieve just the Items, which would then become DataSource records. <p> For a JSON web service, the <code>recordXPath</code> is applied to the returned JSON data via {@link com.smartgwt.client.util.XMLTools#selectObjects}.  Only limited XPath syntax is allowed; see  {@link com.smartgwt.client.util.XMLTools#selectObjects} for details. <P> For processing XML results, see {@link com.smartgwt.client.data.OperationBinding#getXmlNamespaces xmlNamespaces} for information on the namespaces that are available in this XPath expression. <P> To learn about XPath, try the following search: <a href="http://www.google.com/search?q=xpath+tutorial" target="_blank" >http://www.google.com/search?q=xpath+tutorial</a>
    *
    * @param recordXPath recordXPath Default value is null
    */
    public void setRecordXPath(String recordXPath) {
        setAttribute("recordXPath", recordXPath);
    }
    /**
     * For an XML or JSON DataSource, XPath expression used to retrieve the objects that will become DataSource records. <p> For example, an "ItemSearch" web service might return a "Results" structure containing metadata along with the set of Items that one might want to display in a grid.  An XPath expression like "/Results/Items" could be used to retrieve just the Items, which would then become DataSource records. <p> For a JSON web service, the <code>recordXPath</code> is applied to the returned JSON data via {@link com.smartgwt.client.util.XMLTools#selectObjects}.  Only limited XPath syntax is allowed; see  {@link com.smartgwt.client.util.XMLTools#selectObjects} for details. <P> For processing XML results, see {@link com.smartgwt.client.data.OperationBinding#getXmlNamespaces xmlNamespaces} for information on the namespaces that are available in this XPath expression. <P> To learn about XPath, try the following search: <a href="http://www.google.com/search?q=xpath+tutorial" target="_blank" >http://www.google.com/search?q=xpath+tutorial</a>
     *
     *
     * @return String
     *
     */
    public String getRecordXPath()  {
        return getAttributeAsString("recordXPath");
    }

    /**
    * For an XML DataSource, tagName of the elements to be used as records. <p> This is a simple alternative to {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath} when the elements to be used as records all share a tagName. <p> When a DataSource has a WebService, <code>recordName</code> can also be set to the name of any <code>complexType</code> declared within the WebService's WSDL file.
    *
    * @param recordName recordName Default value is null
    */
    public void setRecordName(String recordName) {
        setAttribute("recordName", recordName);
    }
    /**
     * For an XML DataSource, tagName of the elements to be used as records. <p> This is a simple alternative to {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath} when the elements to be used as records all share a tagName. <p> When a DataSource has a WebService, <code>recordName</code> can also be set to the name of any <code>complexType</code> declared within the WebService's WSDL file.
     *
     *
     * @return String
     *
     */
    public String getRecordName()  {
        return getAttributeAsString("recordName");
    }

    /**
    * Setting <code>useFlatFields</code> on an operationBinding is equivalent to setting {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} on all DataSource requests with the same {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} as this <code>operationBinding</code>. <P> Typical usage is to combine operationBinding.useFlatFields with  {@link com.smartgwt.client..DataBoundComponent#getUseFlatFields useFlatFields}, with the {@link com.smartgwt.client.widgets.form.SearchForm} bound to the {@link com.smartgwt.client..WebService#getInputDS} of the web service operation set as {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation}.  This allows gratuitous nesting to be consistently bypassed in both the user presentation and in the actual XML messaging. <P> Not that <code>useFlatFields</code> is not generally recommended for use with input messages where multiple simple type fields exist with the same name, however if used in this way, the first field to use a given name wins.  "first" means the first field encountered in a depth first search.  "wins" means only the first field will be available in data binding, and only the first field will be populated in the generated XML message.
    *
    * @param useFlatFields useFlatFields Default value is false
    */
    public void setUseFlatFields(Boolean useFlatFields) {
        setAttribute("useFlatFields", useFlatFields);
    }
    /**
     * Setting <code>useFlatFields</code> on an operationBinding is equivalent to setting {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} on all DataSource requests with the same {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} as this <code>operationBinding</code>. <P> Typical usage is to combine operationBinding.useFlatFields with  {@link com.smartgwt.client..DataBoundComponent#getUseFlatFields useFlatFields}, with the {@link com.smartgwt.client.widgets.form.SearchForm} bound to the {@link com.smartgwt.client..WebService#getInputDS} of the web service operation set as {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation}.  This allows gratuitous nesting to be consistently bypassed in both the user presentation and in the actual XML messaging. <P> Not that <code>useFlatFields</code> is not generally recommended for use with input messages where multiple simple type fields exist with the same name, however if used in this way, the first field to use a given name wins.  "first" means the first field encountered in a depth first search.  "wins" means only the first field will be available in data binding, and only the first field will be populated in the generated XML message.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseFlatFields()  {
        return getAttributeAsBoolean("useFlatFields");
    }

    /**
    * Specifies, for this specific operationBinding, whether to qualify column names with table names in any SQL we generate.  Overrides the {@link com.smartgwt.client.data.DataSource#getQualifyColumnNames qualifyColumnNames} property. Only applicable to dataSources of {@link com.smartgwt.client.data.DataSource#getServerType serverType} "sql".
    *
    * @param qualifyColumnNames qualifyColumnNames Default value is true
    */
    public void setQualifyColumnNames(Boolean qualifyColumnNames) {
        setAttribute("qualifyColumnNames", qualifyColumnNames);
    }
    /**
     * Specifies, for this specific operationBinding, whether to qualify column names with table names in any SQL we generate.  Overrides the {@link com.smartgwt.client.data.DataSource#getQualifyColumnNames qualifyColumnNames} property. Only applicable to dataSources of {@link com.smartgwt.client.data.DataSource#getServerType serverType} "sql".
     *
     *
     * @return Boolean
     *
     */
    public Boolean getQualifyColumnNames()  {
        return getAttributeAsBoolean("qualifyColumnNames");
    }

    /**
    * If set, every invocation of this operationBinding will invalidate the local cache, forcing a server visit to refresh the data.
    *
    * @param invalidateCache invalidateCache Default value is null
    */
    public void setInvalidateCache(Boolean invalidateCache) {
        setAttribute("invalidateCache", invalidateCache);
    }
    /**
     * If set, every invocation of this operationBinding will invalidate the local cache, forcing a server visit to refresh the data.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getInvalidateCache()  {
        return getAttributeAsBoolean("invalidateCache");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************






    public OperationBinding(DSOperationType operationType, String dataURL) {
        setOperationType(operationType);
        setDataURL(dataURL);
    }

    /**
     * Optional object declaring namespace prefixes for use in OperationBinding.recordXPath and
     * DataSourceField.valueXPath XPath expressions. xmlNamespaces should be specified as a mapping from namespace
     * prefix to namespace URI, for example: <br>
     * <p/>
     * xmlNamespaces : { az : "http://webservices.amazon.com/AWSECommerceService/2005-03-23" } <br> By default, all
     * namespaces declared on the document element (outermost element of the response) are made available with the
     * prefix used in the document itself. Then, for non-WSDL-described XML results, if there is a default namespace on
     * the document element, it is made available with the special prefix "default". <br>
     * <p/>
     * For results of WSDL-described operations, the prefix "service" means the service namespace, that is, the
     * "targetNamespace" on the element from the WSDL file. The prefix "schema" means the namespace of the outermost
     * element in the output message for the current operation. "default" will be the schema namespace if there is one,
     * otherwise the service namespace. <br> For basic information on XML Namespaces and their use in XPath, try the
     * following search: http://www.google.com/search?q=XPath+xml+namespaces
     *
     * @param xmlNamespaces xml namespaces
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setXmlNamespaces(XmlNamespaces xmlNamespaces) {
        setAttribute("xmlNamespaces", xmlNamespaces);
    }

    /**
     * HTTP parameters that should be submitted with every DSRequest. <br> Useful for authenticated services that
     * require a sessionId with every request. <br> Can be set for all operations of a given DataSource as
     * DataSource.defaultParams.
     *
     * @param defaultParams the default params
     */
    public void setDefaultParams(Map defaultParams) {
        setAttribute("defaultParams", defaultParams);
    }

    /**
     * Additional properties to pass through to the {@link DSRequest} created for this operation. Note that these will be cumulative
     * with and will override on a per-property basis any properties set via DataSource.requestProperties.
     * <br>
     * These properties are applied before {@link DataSource#transformRequest} is called.
     *
     * @param requestProperties the request properties. Default is null.
     */
    public void setRequestProperties (DSRequest requestProperties) {
        setAttribute("requestProperties", requestProperties);
    }

    /**
     * Optional schema describing how to extract DataSource records from the XML elements selected.
     * <br>
     * Once a set of XML elements have been selected via recordXPath or recordName, those elements are normally transformed to
     * JavaScript objects using the fields of the DataSource that owns the operationBinding. An responseDataSchema can be specified
     * instead if the XML differs in some way between different DataSource operations, such that different values for field.valueXPath
     * may be necessary to extract the same DataSource record from slightly different XML structures.
     *
     * @param responseDataSchema the response schema. Default is null
     */
    public void setResponseDataSchema(DataSource responseDataSchema) {
        setAttribute("responseDataSchema", responseDataSchema);            
    }

}



