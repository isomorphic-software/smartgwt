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
    * An operationBinding tells a DataSource how to execute one of the basic DS operations: fetch,&#010 add, update, remove.  See {@link com.smartgwt.client.data.DataSource#getOperationBindings operationBindings}.

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
    * Which operationType this operationBinding is for.  This property is only settable on an&#010 operationBinding, not a DataSource as a whole.
    *
    * @param operationType operationType Default value is null
    */
    public void setOperationType(DSOperationType operationType) {
        setAttribute("operationType", operationType.getValue());
    }
    /**
     * Which operationType this operationBinding is for.  This property is only settable on an&#010 operationBinding, not a DataSource as a whole.
     *
     *
     * @return DSOperationType
     *
     */
    public DSOperationType getOperationType()  {
        return (DSOperationType) EnumUtil.getEnum(DSOperationType.values(), getAttribute("operationType"));
    }

    /**
    * Optional operationId if this DataSource supports two or more variants of one of the basic&#010 DataSource operations, for instance, a "fetch" that uses full text search and a "fetch" that&#010 accepts per-field search criteria.  See {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} for usage.
    *
    * @param operationId operationId Default value is null
    */
    public void setOperationId(String operationId) {
        setAttribute("operationId", operationId);
    }
    /**
     * Optional operationId if this DataSource supports two or more variants of one of the basic&#010 DataSource operations, for instance, a "fetch" that uses full text search and a "fetch" that&#010 accepts per-field search criteria.  See {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} for usage.
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
    * You can explicitly declare the arguments to be passed to&#010 {@link com.smartgwt.client.data.OperationBinding#getServerMethod serverMethod} using this attribute.  This isn't required - in the&#010 absense of <code>methodArguments</code>, the DMI implementation will still automagically&#010 pass a stock set of arguments to your method (see the overview in {@link com.smartgwt.client..ServerObject}), but&#010 specifying arguments explicitly gives you more flexibility in what can be passed.&#010 <p>&#010 The format for specifying <code>methodArguments</code> is as a comma separated list of VTL&#010 (Velocity Template Language) expressions.  See the&#010 <a href='http://jakarta.apache.org/velocity/docs/vtl-reference-guide.html' onclick="window.open('http://jakarta.apache.org/velocity/docs/vtl-reference-guide.html');return false;">VTL Reference</a>&#010 and <a href='http://jakarta.apache.org/velocity/docs/user-guide.html' onclick="window.open('http://jakarta.apache.org/velocity/docs/user-guide.html');return false;">Velocity User Guide</a> &#010 for an overview of how to use VTL.&#010 <p>&#010 The Velocity context is pre-populated with the following variables - you can pass these&#010 verbatim as arguments, or call methods on these objects and pass the resulting values:&#010 <ul>&#010 <li>dsRequest: instance of the current DSRequest&#010 <li>request: the current HttpServletRequest&#010 <li>response: the current HttpServletResponse&#010 <li>rpcManager: the instance of RPCManager for this request&#010 <li>dataSource: a DataSource instance for this request&#010 </ul>&#010 So, for example, if you had a method signature like the following:&#010 <p><code>&#010 public DSResponse fetch(SupplyItem creteria, long startRow, long endRow)&#010 </code><p>&#010 You can invoke it by specifying <code>methodArguments</code> as follows:&#010 <p><code>&#010 methodArguments="$dsRequest.criteria, $dsRequest.startRow, $dsRequest.endRow"&#010 </code></p>&#010 Without <code>methodArguments</code>, there would be no way for you to specify&#010 <code>startRow/endRow</code> as arguments.  You could, of course, simply declare the method&#010 to take a <code>DSRequest</code> object and call <code>getStartRow()/getEndRow()</code> in&#010 the body of the method.
    *
    * @param methodArguments methodArguments Default value is null
    */
    public void setMethodArguments(String methodArguments) {
        setAttribute("methodArguments", methodArguments);
    }
    /**
     * You can explicitly declare the arguments to be passed to&#010 {@link com.smartgwt.client.data.OperationBinding#getServerMethod serverMethod} using this attribute.  This isn't required - in the&#010 absense of <code>methodArguments</code>, the DMI implementation will still automagically&#010 pass a stock set of arguments to your method (see the overview in {@link com.smartgwt.client..ServerObject}), but&#010 specifying arguments explicitly gives you more flexibility in what can be passed.&#010 <p>&#010 The format for specifying <code>methodArguments</code> is as a comma separated list of VTL&#010 (Velocity Template Language) expressions.  See the&#010 <a href='http://jakarta.apache.org/velocity/docs/vtl-reference-guide.html' onclick="window.open('http://jakarta.apache.org/velocity/docs/vtl-reference-guide.html');return false;">VTL Reference</a>&#010 and <a href='http://jakarta.apache.org/velocity/docs/user-guide.html' onclick="window.open('http://jakarta.apache.org/velocity/docs/user-guide.html');return false;">Velocity User Guide</a> &#010 for an overview of how to use VTL.&#010 <p>&#010 The Velocity context is pre-populated with the following variables - you can pass these&#010 verbatim as arguments, or call methods on these objects and pass the resulting values:&#010 <ul>&#010 <li>dsRequest: instance of the current DSRequest&#010 <li>request: the current HttpServletRequest&#010 <li>response: the current HttpServletResponse&#010 <li>rpcManager: the instance of RPCManager for this request&#010 <li>dataSource: a DataSource instance for this request&#010 </ul>&#010 So, for example, if you had a method signature like the following:&#010 <p><code>&#010 public DSResponse fetch(SupplyItem creteria, long startRow, long endRow)&#010 </code><p>&#010 You can invoke it by specifying <code>methodArguments</code> as follows:&#010 <p><code>&#010 methodArguments="$dsRequest.criteria, $dsRequest.startRow, $dsRequest.endRow"&#010 </code></p>&#010 Without <code>methodArguments</code>, there would be no way for you to specify&#010 <code>startRow/endRow</code> as arguments.  You could, of course, simply declare the method&#010 to take a <code>DSRequest</code> object and call <code>getStartRow()/getEndRow()</code> in&#010 the body of the method.
     *
     *
     * @return String
     *
     */
    public String getMethodArguments()  {
        return getAttributeAsString("methodArguments");
    }

    /**
    * Name of the web service operation that will be invoked in order to execute this DataSource&#010 operation.&#010 <P>&#010 Valid only for a DataSource that has a WebService ({@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace} is&#010 set).  Otherwise, use {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL}.&#010 <P>&#010 Setting <code>wsOperation</code> means that {@link com.smartgwt.client.data.DSRequest#getData data} will be serialized as the&#010 request message for the specified web service operation, with namespacing and soap encoding&#010 handled automatically.  See {@link com.smartgwt.client.data.DataSource#transformRequest} for how to customize what&#010 data is sent to the server.
    *
    * @param wsOperation wsOperation Default value is null
    */
    public void setWsOperation(String wsOperation) {
        setAttribute("wsOperation", wsOperation);
    }
    /**
     * Name of the web service operation that will be invoked in order to execute this DataSource&#010 operation.&#010 <P>&#010 Valid only for a DataSource that has a WebService ({@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace} is&#010 set).  Otherwise, use {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL}.&#010 <P>&#010 Setting <code>wsOperation</code> means that {@link com.smartgwt.client.data.DSRequest#getData data} will be serialized as the&#010 request message for the specified web service operation, with namespacing and soap encoding&#010 handled automatically.  See {@link com.smartgwt.client.data.DataSource#transformRequest} for how to customize what&#010 data is sent to the server.
     *
     *
     * @return String
     *
     */
    public String getWsOperation()  {
        return getAttributeAsString("wsOperation");
    }

    /**
    * URL to contact to fulfill DSRequests for this operationBinding.&#010 <P>&#010 <code>dataURL</code> is typically set as DataSource.dataURL rather than on each individual&#010 operationBinding.&#010 <P>&#010 <code>dataURL</code> can be omitted for a DataSource using a Web Service&#010 ({@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace} is set).
    *
    * @param dataURL dataURL Default value is null
    */
    public void setDataURL(String dataURL) {
        setAttribute("dataURL", dataURL);
    }
    /**
     * URL to contact to fulfill DSRequests for this operationBinding.&#010 <P>&#010 <code>dataURL</code> is typically set as DataSource.dataURL rather than on each individual&#010 operationBinding.&#010 <P>&#010 <code>dataURL</code> can be omitted for a DataSource using a Web Service&#010 ({@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace} is set).
     *
     *
     * @return String
     *
     */
    public String getDataURL()  {
        return getAttributeAsString("dataURL");
    }
             
    /**
    * Controls the format in which inputs are sent to the dataURL.&#010 <p>&#010 When a DataSource operation such as fetchData() is invoked on this DataSource or a component&#010 bound to this DataSource, the data passed to the operation, if any, will be sent to the&#010 <code>dataURL</code>.  The <code>dataProtocol</code> property controls the format in&#010 which the data is sent: SOAP message, HTTP GET or POST of parameters, etc.&#010 <P>&#010 The <code>dataProtocol</code> property need not be set for a DataSource with a WebService&#010 ( {@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace} is set), in this case, SOAP messaging is used by&#010 default.&#010 <P>&#010 Developers may completely bypass the SmartGWT comm system by setting dataProtocol to&#010 <code>"clientCustom"</code>. In this case SmartGWT will not attempt to send any data&#010 to the server after calling {@link com.smartgwt.client.data.DataSource#transformRequest}. Instead the developer is&#010 expected to implement <code>transformRequest()</code> such that it performs the necessary&#010 data action outside of SmartGWT, and then calls {@link com.smartgwt.client.data.DataSource#processResponse}, &#010 passing in the {@link com.smartgwt.client.data.DSRequest#getRequestId requestId} and an appropriate set of DSResponse properties to&#010 indicate the result of the action.&#010 <P>&#010 NOTE: when {@link com.smartgwt.client.data.OperationBinding#getDataFormat dataFormat} is "iscServer", <code>dataProtocol</code> is not consulted.&#010 Instead, SmartGWT uses a proprietary wire format to communicate with the SmartGWT&#010 server, and the server-side DSRequest and DSResponse objects should be used to access&#010 request data and form responses.
    *
    * @param dataProtocol dataProtocol Default value is "getParams"
    */
    public void setDataProtocol(DSProtocol dataProtocol) {
        setAttribute("dataProtocol", dataProtocol.getValue());
    }
    /**
     * Controls the format in which inputs are sent to the dataURL.&#010 <p>&#010 When a DataSource operation such as fetchData() is invoked on this DataSource or a component&#010 bound to this DataSource, the data passed to the operation, if any, will be sent to the&#010 <code>dataURL</code>.  The <code>dataProtocol</code> property controls the format in&#010 which the data is sent: SOAP message, HTTP GET or POST of parameters, etc.&#010 <P>&#010 The <code>dataProtocol</code> property need not be set for a DataSource with a WebService&#010 ( {@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace} is set), in this case, SOAP messaging is used by&#010 default.&#010 <P>&#010 Developers may completely bypass the SmartGWT comm system by setting dataProtocol to&#010 <code>"clientCustom"</code>. In this case SmartGWT will not attempt to send any data&#010 to the server after calling {@link com.smartgwt.client.data.DataSource#transformRequest}. Instead the developer is&#010 expected to implement <code>transformRequest()</code> such that it performs the necessary&#010 data action outside of SmartGWT, and then calls {@link com.smartgwt.client.data.DataSource#processResponse}, &#010 passing in the {@link com.smartgwt.client.data.DSRequest#getRequestId requestId} and an appropriate set of DSResponse properties to&#010 indicate the result of the action.&#010 <P>&#010 NOTE: when {@link com.smartgwt.client.data.OperationBinding#getDataFormat dataFormat} is "iscServer", <code>dataProtocol</code> is not consulted.&#010 Instead, SmartGWT uses a proprietary wire format to communicate with the SmartGWT&#010 server, and the server-side DSRequest and DSResponse objects should be used to access&#010 request data and form responses.
     *
     *
     * @return DSProtocol
     *
     */
    public DSProtocol getDataProtocol()  {
        return (DSProtocol) EnumUtil.getEnum(DSProtocol.values(), getAttribute("dataProtocol"));
    }
             
    /**
    * Format for response data for this operation.&#010 <P>&#010 Typically set once for the DataSource as a whole via {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat}.
    *
    * @param dataFormat dataFormat Default value is "iscServer"
    */
    public void setDataFormat(DSDataFormat dataFormat) {
        setAttribute("dataFormat", dataFormat.getValue());
    }
    /**
     * Format for response data for this operation.&#010 <P>&#010 Typically set once for the DataSource as a whole via {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat}.
     *
     *
     * @return DSDataFormat
     *
     */
    public DSDataFormat getDataFormat()  {
        return (DSDataFormat) EnumUtil.getEnum(DSDataFormat.values(), getAttribute("dataFormat"));
    }
             
    /**
    * Transport to use for this operation.  Defaults to {@link com.smartgwt.client.data.DataSource#getDataTransport dataTransport}, which in&#010 turn defaults to {@link com.smartgwt.client.rpc.RPCManager#defaultTransport}.  This would typically only be set to&#010 enable "scriptInclude" transport for contacting {@link com.smartgwt.client.data.DataSource#getDataFormat 'JSON'} web&#010 services hosted on servers other than the origin server.&#010 <p>&#010 When using the "scriptInclude" transport, be sure to set {@link com.smartgwt.client.data.DataSource#getCallbackParam callbackParam} or&#010 {@link com.smartgwt.client.data.OperationBinding#getCallbackParam callbackParam} to match the name of the query parameter name expected&#010 by your JSON service provider.
    *
    * @param dataTransport dataTransport Default value is RPCManager.defaultTransport
    */
    public void setDataTransport(RPCTransport dataTransport) {
        setAttribute("dataTransport", dataTransport.getValue());
    }
    /**
     * Transport to use for this operation.  Defaults to {@link com.smartgwt.client.data.DataSource#getDataTransport dataTransport}, which in&#010 turn defaults to {@link com.smartgwt.client.rpc.RPCManager#defaultTransport}.  This would typically only be set to&#010 enable "scriptInclude" transport for contacting {@link com.smartgwt.client.data.DataSource#getDataFormat 'JSON'} web&#010 services hosted on servers other than the origin server.&#010 <p>&#010 When using the "scriptInclude" transport, be sure to set {@link com.smartgwt.client.data.DataSource#getCallbackParam callbackParam} or&#010 {@link com.smartgwt.client.data.OperationBinding#getCallbackParam callbackParam} to match the name of the query parameter name expected&#010 by your JSON service provider.
     *
     *
     * @return RPCTransport
     *
     */
    public RPCTransport getDataTransport()  {
        return (RPCTransport) EnumUtil.getEnum(RPCTransport.values(), getAttribute("dataTransport"));
    }

    /**
    * Applies only to dataFormat: "json".  Specifies the name of the query parameter that&#010 tells your JSON service what function to call as part of the response for this operation.&#010 <P>&#010 Typically set once for the DataSource as a whole via {@link com.smartgwt.client.data.DataSource#getCallbackParam callbackParam}.
    *
    * @param callbackParam callbackParam Default value is "callback"
    */
    public void setCallbackParam(String callbackParam) {
        setAttribute("callbackParam", callbackParam);
    }
    /**
     * Applies only to dataFormat: "json".  Specifies the name of the query parameter that&#010 tells your JSON service what function to call as part of the response for this operation.&#010 <P>&#010 Typically set once for the DataSource as a whole via {@link com.smartgwt.client.data.DataSource#getCallbackParam callbackParam}.
     *
     *
     * @return String
     *
     */
    public String getCallbackParam()  {
        return getAttributeAsString("callbackParam");
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
    * Setting <code>useFlatFields</code> on an operationBinding is equivalent to setting&#010 {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} on all DataSource requests with the same {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType}&#010 as this <code>operationBinding</code>.&#010 <P>&#010 Typical usage is to combine operationBinding.useFlatFields with &#010 {@link com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields 'searchForm.useFlatFields'}, with the {@link com.smartgwt.client.widgets.form.SearchForm}&#010 bound to the {@link com.smartgwt.client.data.WebService#getInputDS} of the web service operation set&#010 as {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation}.  This allows gratuitous nesting to be consistently&#010 bypassed in both the user presentation and in the actual XML messaging.&#010 <P>&#010 Not that <code>useFlatFields</code> is not generally recommended for use with input messages&#010 where multiple simple type fields exist with the same name, however if used in this way,&#010 the first field to use a given name wins.  "first" means the first field encountered in a&#010 depth first search.  "wins" means only the first field will be available in data binding,&#010 and only the first field will be populated in the generated XML message.
    *
    * @param useFlatFields useFlatFields Default value is false
    */
    public void setUseFlatFields(Boolean useFlatFields) {
        setAttribute("useFlatFields", useFlatFields);
    }
    /**
     * Setting <code>useFlatFields</code> on an operationBinding is equivalent to setting&#010 {@link com.smartgwt.client.data.DSRequest#getUseFlatFields useFlatFields} on all DataSource requests with the same {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType}&#010 as this <code>operationBinding</code>.&#010 <P>&#010 Typical usage is to combine operationBinding.useFlatFields with &#010 {@link com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields 'searchForm.useFlatFields'}, with the {@link com.smartgwt.client.widgets.form.SearchForm}&#010 bound to the {@link com.smartgwt.client.data.WebService#getInputDS} of the web service operation set&#010 as {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation}.  This allows gratuitous nesting to be consistently&#010 bypassed in both the user presentation and in the actual XML messaging.&#010 <P>&#010 Not that <code>useFlatFields</code> is not generally recommended for use with input messages&#010 where multiple simple type fields exist with the same name, however if used in this way,&#010 the first field to use a given name wins.  "first" means the first field encountered in a&#010 depth first search.  "wins" means only the first field will be available in data binding,&#010 and only the first field will be populated in the generated XML message.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseFlatFields()  {
        return getAttributeAsBoolean("useFlatFields");
    }

    /**
    * For an XML or JSON DataSource, XPath expression used to retrieve the objects that will&#010 become DataSource records.&#010 <p>&#010 For example, an "ItemSearch" web service might return a "Results" structure containing&#010 metadata along with the set of Items that one might want to display in a grid.  An XPath&#010 expression like "/Results/Items" could be used to retrieve just the Items, which would then&#010 become DataSource records.&#010 <p>&#010 For a JSON web service, the <code>recordXPath</code> is applied to the returned JSON data&#010 via {@link com.smartgwt.client.data.XMLTools#selectObjects}.  Only limited XPath syntax is allowed; see &#010 {@link com.smartgwt.client.data.XMLTools#selectObjects} for details.&#010 <P>&#010 For processing XML results, see {@link com.smartgwt.client.data.OperationBinding#getXmlNamespaces xmlNamespaces} for information&#010 on the namespaces that are available in this XPath expression.&#010 <P>&#010 To learn about XPath, try the following search:&#010 <a href="http://www.google.com/search?q=xpath+tutorial" target="_blank"&#010 >http://www.google.com/search?q=xpath+tutorial</a>
    *
    * @param recordXPath recordXPath Default value is null
    */
    public void setRecordXPath(String recordXPath) {
        setAttribute("recordXPath", recordXPath);
    }
    /**
     * For an XML or JSON DataSource, XPath expression used to retrieve the objects that will&#010 become DataSource records.&#010 <p>&#010 For example, an "ItemSearch" web service might return a "Results" structure containing&#010 metadata along with the set of Items that one might want to display in a grid.  An XPath&#010 expression like "/Results/Items" could be used to retrieve just the Items, which would then&#010 become DataSource records.&#010 <p>&#010 For a JSON web service, the <code>recordXPath</code> is applied to the returned JSON data&#010 via {@link com.smartgwt.client.data.XMLTools#selectObjects}.  Only limited XPath syntax is allowed; see &#010 {@link com.smartgwt.client.data.XMLTools#selectObjects} for details.&#010 <P>&#010 For processing XML results, see {@link com.smartgwt.client.data.OperationBinding#getXmlNamespaces xmlNamespaces} for information&#010 on the namespaces that are available in this XPath expression.&#010 <P>&#010 To learn about XPath, try the following search:&#010 <a href="http://www.google.com/search?q=xpath+tutorial" target="_blank"&#010 >http://www.google.com/search?q=xpath+tutorial</a>
     *
     *
     * @return String
     *
     */
    public String getRecordXPath()  {
        return getAttributeAsString("recordXPath");
    }

    /**
    * For an XML DataSource, tagName of the elements to be used as records.&#010 <p>&#010 This is a simple alternative to {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath} when the elements to be used as&#010 records all share a tagName.&#010 <p>&#010 When a DataSource has a WebService, <code>recordName</code> can also be set to the name&#010 of any <code>complexType</code> declared within the WebService's WSDL file.
    *
    * @param recordName recordName Default value is null
    */
    public void setRecordName(String recordName) {
        setAttribute("recordName", recordName);
    }
    /**
     * For an XML DataSource, tagName of the elements to be used as records.&#010 <p>&#010 This is a simple alternative to {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath} when the elements to be used as&#010 records all share a tagName.&#010 <p>&#010 When a DataSource has a WebService, <code>recordName</code> can also be set to the name&#010 of any <code>complexType</code> declared within the WebService's WSDL file.
     *
     *
     * @return String
     *
     */
    public String getRecordName()  {
        return getAttributeAsString("recordName");
    }

    /**
    * For a DataSource contacting a {@link com.smartgwt.client.data.DataSource#getServiceNamespace 'WSDL web service'}, setting&#010 this flag means the DataSource doesn't actually attempt to contact the server but generates&#010 a sample response instead, based on the XML Schema of the response message embedded in the&#010 WSDL.&#010 <P>&#010 The spoofed response will include all complexType elements and will fill in appropriate&#010 values by type for all simpleType elements, although the spoofed data will not conform to&#010 all xs:restriction declarations (eg xs:pattern).&#010 <P>&#010 Note that if your WSDL does not fully describe the response format (some WSDL services just&#010 have a placeholder &lt;xs:any&gt; element), SmartGWT can only produce a partial&#010 response.  To use a hand-generated sample response, just save an XML file to disk and use&#010 the {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL} setting to point to it.
    *
    * @param spoofResponses spoofResponses Default value is false
    */
    public void setSpoofResponses(Boolean spoofResponses) {
        setAttribute("spoofResponses", spoofResponses);
    }
    /**
     * For a DataSource contacting a {@link com.smartgwt.client.data.DataSource#getServiceNamespace 'WSDL web service'}, setting&#010 this flag means the DataSource doesn't actually attempt to contact the server but generates&#010 a sample response instead, based on the XML Schema of the response message embedded in the&#010 WSDL.&#010 <P>&#010 The spoofed response will include all complexType elements and will fill in appropriate&#010 values by type for all simpleType elements, although the spoofed data will not conform to&#010 all xs:restriction declarations (eg xs:pattern).&#010 <P>&#010 Note that if your WSDL does not fully describe the response format (some WSDL services just&#010 have a placeholder &lt;xs:any&gt; element), SmartGWT can only produce a partial&#010 response.  To use a hand-generated sample response, just save an XML file to disk and use&#010 the {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL} setting to point to it.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSpoofResponses()  {
        return getAttributeAsBoolean("spoofResponses");
    }

    /**
    * When set, causes the results of the DataSource Operation to be exported to a file, whose &#010 name and format are indicated by {@link com.smartgwt.client.data.OperationBinding#getExportFilename exportFilename} and &#010 {@link com.smartgwt.client.data.OperationBinding#getExportAs exportAs} respectively.  When no exportFilename is provided, the &#010 default is <i>Results</i> and the default value of exportAs is <i>csv</i>.  Once the Operation &#010 completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay} specifies whether the &#010 exported data will be downloaded to the file-system or displayed in a new window.   The &#010 default value of exportDisplay is "download" which displays the Save As dialog.  See &#010 {@link com.smartgwt.client.types.ExportDisplay} for more information.&#010 <P>&#010 The export field-list can also be configured, see {@link com.smartgwt.client.data.DSRequest#getExportFields exportFields}.&#010 <P>&#010 You can also configure the style of line-breaks to use when generating the output.  See&#010 {@link com.smartgwt.client..LineBreakStyle} for more information.&#010 <P>&#010 As well as setting this and other properties on the {@link com.smartgwt.client.data.OperationBinding}, Exports can be &#010 initiated in two other ways.  You can set properties on the dsRequest by passing &#010 <i>requestProperties</i> into {@link com.smartgwt.client.data.DataSource#exportData}.  Note that this method does&#010 not support exporting to JSON format (see &#010 <a href="http://forums.smartclient.com/showthread.php?t=235">this post</a> for more detail).&#010 Additionally, custom server code may set export-related properties on the &#010 {@link com.smartgwt.client.data.DSResponse}.&#010 <P>&#010 <b>Format Examples</b>&#010 <P>&#010 XML format&#010 <pre>&#010     &lt;List&gt;&#010         &lt;Object&gt;&#010             &lt;id&gt;10101&lt;/id&gt;&#010             &lt;displayName&gt;Record 10101&lt;/displayName&gt;&#010         &lt;/Object&gt;&#010    &lt;/List&gt;&#010 </pre>&#010 JSON Format&#010 <pre>&#010     [&#010         { id: 10101, displayName: "Record 10101" }&#010     ]&#010 </pre>&#010 CSV Format&#010 <pre>&#010     id,displayName&#010     10101,"Record 10101"&#010 </pre>
    *
    * @param exportResults exportResults Default value is false
    */
    public void setExportResults(Boolean exportResults) {
        setAttribute("exportResults", exportResults);
    }
    /**
     * When set, causes the results of the DataSource Operation to be exported to a file, whose &#010 name and format are indicated by {@link com.smartgwt.client.data.OperationBinding#getExportFilename exportFilename} and &#010 {@link com.smartgwt.client.data.OperationBinding#getExportAs exportAs} respectively.  When no exportFilename is provided, the &#010 default is <i>Results</i> and the default value of exportAs is <i>csv</i>.  Once the Operation &#010 completes, {@link com.smartgwt.client.data.DSRequest#getExportDisplay exportDisplay} specifies whether the &#010 exported data will be downloaded to the file-system or displayed in a new window.   The &#010 default value of exportDisplay is "download" which displays the Save As dialog.  See &#010 {@link com.smartgwt.client.types.ExportDisplay} for more information.&#010 <P>&#010 The export field-list can also be configured, see {@link com.smartgwt.client.data.DSRequest#getExportFields exportFields}.&#010 <P>&#010 You can also configure the style of line-breaks to use when generating the output.  See&#010 {@link com.smartgwt.client..LineBreakStyle} for more information.&#010 <P>&#010 As well as setting this and other properties on the {@link com.smartgwt.client.data.OperationBinding}, Exports can be &#010 initiated in two other ways.  You can set properties on the dsRequest by passing &#010 <i>requestProperties</i> into {@link com.smartgwt.client.data.DataSource#exportData}.  Note that this method does&#010 not support exporting to JSON format (see &#010 <a href="http://forums.smartclient.com/showthread.php?t=235">this post</a> for more detail).&#010 Additionally, custom server code may set export-related properties on the &#010 {@link com.smartgwt.client.data.DSResponse}.&#010 <P>&#010 <b>Format Examples</b>&#010 <P>&#010 XML format&#010 <pre>&#010     &lt;List&gt;&#010         &lt;Object&gt;&#010             &lt;id&gt;10101&lt;/id&gt;&#010             &lt;displayName&gt;Record 10101&lt;/displayName&gt;&#010         &lt;/Object&gt;&#010    &lt;/List&gt;&#010 </pre>&#010 JSON Format&#010 <pre>&#010     [&#010         { id: 10101, displayName: "Record 10101" }&#010     ]&#010 </pre>&#010 CSV Format&#010 <pre>&#010     id,displayName&#010     10101,"Record 10101"&#010 </pre>
     *
     *
     * @return Boolean
     *
     */
    public Boolean getExportResults()  {
        return getAttributeAsBoolean("exportResults");
    }
             
    /**
    * The format in which the data should be exported.  See {@link com.smartgwt.client.types.ExportFormat} for more &#010 information.
    *
    * @param exportAs exportAs Default value is "csv"
    */
    public void setExportAs(ExportFormat exportAs) {
        setAttribute("exportAs", exportAs.getValue());
    }
    /**
     * The format in which the data should be exported.  See {@link com.smartgwt.client.types.ExportFormat} for more &#010 information.
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
    * The style of line-breaks to use in the exported output.  See {@link com.smartgwt.client..LineBreakStyle} for&#010 more information.
    *
    * @param lineBreakStyle lineBreakStyle Default value is null
    */
    public void setLineBreakStyle(String lineBreakStyle) {
        setAttribute("lineBreakStyle", lineBreakStyle);
    }
    /**
     * The style of line-breaks to use in the exported output.  See {@link com.smartgwt.client..LineBreakStyle} for&#010 more information.
     *
     *
     * @return String
     *
     */
    public String getLineBreakStyle()  {
        return getAttributeAsString("lineBreakStyle");
    }

    /**
    * Ordinarily, "update" and "remove" operations are only allowed for {@link com.smartgwt.client.data.DataSource}s&#010 that have a {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey 'primaryKey'}, and all primary key values&#010 are present in the request.  This is because an update of a DataSource with no primary key, &#010 or an update request that has missing primary key values, cannot be guaranteed to affect &#010 only one record.&#010 <p>&#010 Setting this property on an operationBinding circumvents this restriction for that operation&#010 only.&#010 <p>&#010 <b>Warning:</b> Be aware that this is a potentially dangerous setting and should be used&#010 with care.  With this flag set, you have no guarantee that an update will not change or &#010 remove every row in a table.
    *
    * @param allowMultiUpdate allowMultiUpdate Default value is null
    */
    public void setAllowMultiUpdate(Boolean allowMultiUpdate) {
        setAttribute("allowMultiUpdate", allowMultiUpdate);
    }
    /**
     * Ordinarily, "update" and "remove" operations are only allowed for {@link com.smartgwt.client.data.DataSource}s&#010 that have a {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey 'primaryKey'}, and all primary key values&#010 are present in the request.  This is because an update of a DataSource with no primary key, &#010 or an update request that has missing primary key values, cannot be guaranteed to affect &#010 only one record.&#010 <p>&#010 Setting this property on an operationBinding circumvents this restriction for that operation&#010 only.&#010 <p>&#010 <b>Warning:</b> Be aware that this is a potentially dangerous setting and should be used&#010 with care.  With this flag set, you have no guarantee that an update will not change or &#010 remove every row in a table.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAllowMultiUpdate()  {
        return getAttributeAsBoolean("allowMultiUpdate");
    }

    /**
    * Specifies, for this specific operationBinding, whether to qualify column names with table&#010 names in any SQL we generate.  Overrides the {@link com.smartgwt.client.data.DataSource#getQualifyColumnNames qualifyColumnNames} property.&#010 Only applicable to dataSources of {@link com.smartgwt.client.data.DataSource#getServerType 'serverType'} "sql".
    *
    * @param qualifyColumnNames qualifyColumnNames Default value is true
    */
    public void setQualifyColumnNames(Boolean qualifyColumnNames) {
        setAttribute("qualifyColumnNames", qualifyColumnNames);
    }
    /**
     * Specifies, for this specific operationBinding, whether to qualify column names with table&#010 names in any SQL we generate.  Overrides the {@link com.smartgwt.client.data.DataSource#getQualifyColumnNames qualifyColumnNames} property.&#010 Only applicable to dataSources of {@link com.smartgwt.client.data.DataSource#getServerType 'serverType'} "sql".
     *
     *
     * @return Boolean
     *
     */
    public Boolean getQualifyColumnNames()  {
        return getAttributeAsBoolean("qualifyColumnNames");
    }

    /**
    * If set, every invocation of this operationBinding will invalidate the local cache, forcing&#010 a server visit to refresh the data.
    *
    * @param invalidateCache invalidateCache Default value is null
    */
    public void setInvalidateCache(Boolean invalidateCache) {
        setAttribute("invalidateCache", invalidateCache);
    }
    /**
     * If set, every invocation of this operationBinding will invalidate the local cache, forcing&#010 a server visit to refresh the data.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getInvalidateCache()  {
        return getAttributeAsBoolean("invalidateCache");
    }

    /**
    * Whether a user must be authenticated in order to access this operation.  For details of &#010 what is meant by "authenticated", see {@link com.smartgwt.client.data.DataSource#getRequiresAuthentication requiresAuthentication}.&#010 <P>&#010 To protect access to an entire operationType (eg, all "fetch" operations), declare an&#010 operationBinding with <code>requiresAuthentication="true"</code>, {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} set&#010 to the operationType to be protected, but no {@link com.smartgwt.client.data.OperationBinding#getOperationId operationId}.  This will then&#010 prevent access to the "fetch" operationType unless another {@link com.smartgwt.client.data.OperationBinding}&#010 declares requiresAuthentication="false" with a specific&#010 {@link com.smartgwt.client.data.OperationBinding#getOperationId 'operationId'}.
    *
    * @param requiresAuthentication requiresAuthentication Default value is null
    */
    public void setRequiresAuthentication(Boolean requiresAuthentication) {
        setAttribute("requiresAuthentication", requiresAuthentication);
    }
    /**
     * Whether a user must be authenticated in order to access this operation.  For details of &#010 what is meant by "authenticated", see {@link com.smartgwt.client.data.DataSource#getRequiresAuthentication requiresAuthentication}.&#010 <P>&#010 To protect access to an entire operationType (eg, all "fetch" operations), declare an&#010 operationBinding with <code>requiresAuthentication="true"</code>, {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} set&#010 to the operationType to be protected, but no {@link com.smartgwt.client.data.OperationBinding#getOperationId operationId}.  This will then&#010 prevent access to the "fetch" operationType unless another {@link com.smartgwt.client.data.OperationBinding}&#010 declares requiresAuthentication="false" with a specific&#010 {@link com.smartgwt.client.data.OperationBinding#getOperationId 'operationId'}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getRequiresAuthentication()  {
        return getAttributeAsBoolean("requiresAuthentication");
    }

    /**
    * Comma-separated list of user roles that are allowed to invoke the operation described by&#010 this operationBinding.&#010 <P>&#010 Whether the current user has a given role is determined by calling the standard Java&#010 servlets method <code>httpServletRequest.isUserInRole()</code>, hence works with both simple&#010 J2EE security (realms and form-based authentication) and JAAS (Java Authentication &&#010 Authorization Service).&#010 <P>&#010 If you wish to use a role-based security scheme that does not make use of the servlet API's &#010 standards, SmartGWT Server also implements the <code>setUserRoles</code> method&#010 on <code>RPCManager</code>.  You can use this API to tell SmartGWT that all the &#010 requests in the queue currently being processed are associated with a user who has the roles&#010 you supply; in this case, SmartGWT will not attempt to resolve the user's roles via &#010 <code>httpServletRequest.isUserInRole()</code>.&#010 <P>&#010 If there an operationBinding declared for a given operationType which does not have an&#010 {@link com.smartgwt.client.data.OperationBinding#getOperationId operationId}, that is, it is the default operationBinding for the type, then any other&#010 operationBinding of the same type is assumed to have the same setting for&#010 <code>requiresRole</code> as the default operationBinding for the operationType.  For&#010 example, given these declarations:&#010 <pre>&#010     &lt;operationBinding operationType="fetch" requiresRole="manager"&gt;&#010           ... settings ...&#010      &lt;/operationBinding&gt;&#010     &lt;operationBinding operationType="fetch" operationId="fetchWithExtraFields"&gt;&#010           ... settings ...&#010      &lt;/operationBinding&gt;&#010 </pre>&#010 The second operationBinding requires the "manager" role even though there is no explicit&#010 <code>requiresRole</code> declaration.  To prevent the "manager" role being required by the&#010 second operationBinding, add <code>requireRole=""</code>.&#010 <P>&#010 Note that if {@link com.smartgwt.client.data.DataSource#getRequiresRole requiresRole} is set, all operations on the DataSource require&#010 the roles set for the DataSource as a whole, even if they declare individual&#010 <code>requiresRole</code> attributes.&#010 <P>&#010 This property is valid only for a server-side DataSource when using the SmartGWT Server.
    *
    * @param requiresRole requiresRole Default value is null
    */
    public void setRequiresRole(String requiresRole) {
        setAttribute("requiresRole", requiresRole);
    }
    /**
     * Comma-separated list of user roles that are allowed to invoke the operation described by&#010 this operationBinding.&#010 <P>&#010 Whether the current user has a given role is determined by calling the standard Java&#010 servlets method <code>httpServletRequest.isUserInRole()</code>, hence works with both simple&#010 J2EE security (realms and form-based authentication) and JAAS (Java Authentication &&#010 Authorization Service).&#010 <P>&#010 If you wish to use a role-based security scheme that does not make use of the servlet API's &#010 standards, SmartGWT Server also implements the <code>setUserRoles</code> method&#010 on <code>RPCManager</code>.  You can use this API to tell SmartGWT that all the &#010 requests in the queue currently being processed are associated with a user who has the roles&#010 you supply; in this case, SmartGWT will not attempt to resolve the user's roles via &#010 <code>httpServletRequest.isUserInRole()</code>.&#010 <P>&#010 If there an operationBinding declared for a given operationType which does not have an&#010 {@link com.smartgwt.client.data.OperationBinding#getOperationId operationId}, that is, it is the default operationBinding for the type, then any other&#010 operationBinding of the same type is assumed to have the same setting for&#010 <code>requiresRole</code> as the default operationBinding for the operationType.  For&#010 example, given these declarations:&#010 <pre>&#010     &lt;operationBinding operationType="fetch" requiresRole="manager"&gt;&#010           ... settings ...&#010      &lt;/operationBinding&gt;&#010     &lt;operationBinding operationType="fetch" operationId="fetchWithExtraFields"&gt;&#010           ... settings ...&#010      &lt;/operationBinding&gt;&#010 </pre>&#010 The second operationBinding requires the "manager" role even though there is no explicit&#010 <code>requiresRole</code> declaration.  To prevent the "manager" role being required by the&#010 second operationBinding, add <code>requireRole=""</code>.&#010 <P>&#010 Note that if {@link com.smartgwt.client.data.DataSource#getRequiresRole requiresRole} is set, all operations on the DataSource require&#010 the roles set for the DataSource as a whole, even if they declare individual&#010 <code>requiresRole</code> attributes.&#010 <P>&#010 This property is valid only for a server-side DataSource when using the SmartGWT Server.
     *
     *
     * @return String
     *
     */
    public String getRequiresRole()  {
        return getAttributeAsString("requiresRole");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************






    public OperationBinding(DSOperationType operationType, String dataURL) {
        setOperationType(operationType);
        setDataURL(dataURL);
    }

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
     *
     */
    public String[] getExportFields()  {
        return getAttributeAsStringArray("exportFields");
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



