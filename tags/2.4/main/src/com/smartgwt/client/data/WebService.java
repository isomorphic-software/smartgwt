package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.core.JsObject;

import java.util.Map;

public class WebService extends JsObject {

    public WebService(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Invoke a web service operation.
     * <p>
     * The <code>data</code> parameter will be serialized to XML to form the input message for<br>
     * the operation, as described by ${isc.DocUtils.linkForRef('method:DataSource.xmlSerialize')}.  Namespacing,
     * <br> element ordering, and SOAP encoding rules are automatically followed.  If the web
     * <br> service you are trying to contact requires a complicated nested structure, consider<br> using
     * {@link com.smartgwt.client.data.WSRequest#setUseFlatFields(Boolean)}  to simplify the required JavaScript input data.<br>
     * <P><br> The <code>resultType</code> selects what part of the message should be decoded to<br> JavaScript and made
     * available as the &quot;data&quot; variable in the callback.  The<br> <code>resultType</code> parameter can be either:<br> <ul><br> <li> an XPath.
     * &quot;data&quot; will be always be an Array, containing the selected elements as<br> decoded by XMLTools.toJS.
     * All properties will have String value.<br> <li> the name of an XML Schema type found somewhere in the response.
     * You can use the<br> WSDL tab of the Developer Console to analyze the WSDL file for an appropriate type name.<br> &quot;data&quot;
     * will be an Array, containing the decoded elements as decoded by<br> {@link DataSource#recordsFromXML(Object)} .
     * In this case, since the XML Schema type of the<br> selected data is known, properties will have correct type (eg &quot;date&quot; fields will<br> have JavaScript Date objects)<br> <li> null.
     * &quot;data&quot; will an Object representing the entire &amp;lt;SOAP:Body&amp;gt; as decoded<br> to JavaScript.  As above, properties
     * will have correct type.<br> </ul><br> In the callback, you also receive the XML document returned by the web service as<br> &quot;xmlDoc&quot;.<br> <P>
     * <br> NOTE: <code>callOperation()</code> is appropriate for simple operations that do not<br> involve DataBound Components, such as logging into a web service,
     * or retrieving simple<br> String data.  <code>callOperation()</code> can also be used to retrieve small, read-only<br>
     * datasets such as the option list for a SelectItem, but only if the dataset is guaranteed<br> to remain small enough for paging to be unnecessary.
     * For any larger datasets or<br> anything that will be edited, DataSource integration is more appropriate.<br><br>
     *
     * @param operationName  Name of the operation to invoke
     * @param paramData  data to serialize as XML to form the inbound message of the operation
     * @param resultType  Type, Element name, or XPath that should be selected from the result
     * @param callback Callback to invoke on completion
     */
    public void callOperation(String operationName, Map paramData, String resultType, WebServiceCallback callback){
        callOperation(operationName, paramData, resultType, callback, null);
    }

    /**
     * Invoke a web service operation.
     * <p>
     * The <code>data</code> parameter will be serialized to XML to form the input message for<br>
     * the operation, as described by ${isc.DocUtils.linkForRef('method:DataSource.xmlSerialize')}.  Namespacing,
     * <br> element ordering, and SOAP encoding rules are automatically followed.  If the web
     * <br> service you are trying to contact requires a complicated nested structure, consider<br> using
     * {@link com.smartgwt.client.data.WSRequest#setUseFlatFields(Boolean)}  to simplify the required JavaScript input data.<br>
     * <P><br> The <code>resultType</code> selects what part of the message should be decoded to<br> JavaScript and made
     * available as the &quot;data&quot; variable in the callback.  The<br> <code>resultType</code> parameter can be either:<br> <ul><br> <li> an XPath.
     * &quot;data&quot; will be always be an Array, containing the selected elements as<br> decoded by XMLTools.toJS.
     * All properties will have String value.<br> <li> the name of an XML Schema type found somewhere in the response.
     * You can use the<br> WSDL tab of the Developer Console to analyze the WSDL file for an appropriate type name.<br> &quot;data&quot;
     * will be an Array, containing the decoded elements as decoded by<br> {@link DataSource#recordsFromXML(Object)} .
     * In this case, since the XML Schema type of the<br> selected data is known, properties will have correct type (eg &quot;date&quot; fields will<br> have JavaScript Date objects)<br> <li> null.
     * &quot;data&quot; will an Object representing the entire &amp;lt;SOAP:Body&amp;gt; as decoded<br> to JavaScript.  As above, properties
     * will have correct type.<br> </ul><br> In the callback, you also receive the XML document returned by the web service as<br> &quot;xmlDoc&quot;.<br> <P>
     * <br> NOTE: <code>callOperation()</code> is appropriate for simple operations that do not<br> involve DataBound Components, such as logging into a web service,
     * or retrieving simple<br> String data.  <code>callOperation()</code> can also be used to retrieve small, read-only<br>
     * datasets such as the option list for a SelectItem, but only if the dataset is guaranteed<br> to remain small enough for paging to be unnecessary.
     * For any larger datasets or<br> anything that will be edited, DataSource integration is more appropriate.<br><br>
     *
     * @param operationName  Name of the operation to invoke
     * @param paramData  data to serialize as XML to form the inbound message of the operation
     * @param resultType  Type, Element name, or XPath that should be selected from the result
     * @param callback Callback to invoke on completion
     * @param wsRequestProperties Additional properties for the WSRequest, such as HTTPHeaders
     */
    public native void callOperation(String operationName, Map paramData, String resultType, WebServiceCallback callback, WSRequest wsRequestProperties) /*-{
        var self  = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        var paramDataJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(paramData);

        self.callOperation(operationName, paramDataJS, resultType, function(data, xmlDoc, rpcResponse, wsRequest) {
            var dataJ = null;
            if(data != null) {
                if(!@com.smartgwt.client.util.JSOHelper::isArray(Lcom/google/gwt/core/client/JavaScriptObject;)(data)) {
                    data = [data];
                }
                dataJ = @com.smartgwt.client.util.JSOHelper::convertToJavaObjectArray(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
            }
            var resp = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
            callback.@com.smartgwt.client.data.WebServiceCallback::execute([Ljava/lang/Object;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/smartgwt/client/rpc/RPCResponse;Lcom/google/gwt/core/client/JavaScriptObject;)(dataJ, xmlDoc, resp, wsRequest);
        }, wsRequestProperties == null ? null : wsRequestProperties.@com.smartgwt.client.data.WSRequest::getJsObj()());
    }-*/;
 
    /**
     * Set location can be used when the actual URL where a service will be accessible isn't known until runtime, or changes at runtime, hence can't be embedded in the service definition.
     * <br>
     * With an operation parameter, setLocation() can be used to set a distinct URL for each web service operation. This is a development-time only feature that allows XML flat files to be placed at various URLs on a server, to serve as spoofed responses for each web service operation.
     *
     * @param url the URL where web service can be contacted
     */
    public native void setLocation(String url) /*-{
        var self  = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        self.setLocation(url);
    }-*/;

    /**
     * Set location can be used when the actual URL where a service will be accessible isn't known until runtime, or changes at runtime, hence can't be embedded in the service definition.
     * <br>
     * With an operation parameter, setLocation() can be used to set a distinct URL for each web service operation. This is a development-time only feature that allows XML flat files to be placed at various URLs on a server, to serve as spoofed responses for each web service operation.
     *
     * @param url the URL where web service can be contacted
     * @param operation optional operation name to set the location for, for debugging only
     */
    public native void setLocation(String url, String operation) /*-{
        var self  = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        self.setLocation(url, operation);
    }-*/;


    /**
     * Get a DataSource representing the input message to a web service operation.
     * This DataSource is suitable for use as form.dataSource for a form that the user fills out when providing inputs to call this web service operation. 
     *
     * @param operationName    name of the web service operation whose inputs the returned DataSource will represent
     * @return  DataSource representing the input message of a web service operation
     */
    public native DataSource getInputDS(String operationName)/*-{
        var self  = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        var ds = self.getInputDS(operationName);

        if(ds == null || ds === undefined) {
            return null;
        } else {
            var dsJ = @com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ds);
            return dsJ;
        }
    }-*/;

    /**
     * Retrieve a DataSource that provides read-only access to records returned by a web service operation.
     * <br>
     * DataBound Components can be bound to the returned DataSource, and the fetchData() method can be invoked to retrieve data from the web service.
     * <br>
     * The returned DataSource is only capable of the "fetch" DataSource operation, not "update", "add" or "remove". To create a DataSource capable of
     * full read-write access, use DataSource.operationBindings with the wsOperation property set to associate each DataSource operation with a web
     * service operation.
     *
     * @param operationName name of the web service operation to invoke to fetch records
     * @param resultType  tag or type name of the XML element to be returned as DataSource records
     * @return dDataSource representing the fetch message of a web service operation
     */
    public native DataSource getFetchDS(String operationName, String resultType)/*-{
        var self  = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        var ds = self.getFetchDS(operationName, resultType);

        if(ds == null || ds === undefined) {
            return null;
        } else {
            var dsJ = @com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ds);
            return dsJ;
        }
    }-*/;

    /**
     * Retrieve a DataSource that provides read-only access to records returned by a web service operation.
     * <br>
     * DataBound Components can be bound to the returned DataSource, and the fetchData() method can be invoked to retrieve data from the web service.
     * <br>
     * The returned DataSource is only capable of the "fetch" DataSource operation, not "update", "add" or "remove". To create a DataSource capable of
     * full read-write access, use DataSource.operationBindings with the wsOperation property set to associate each DataSource operation with a web
     * service operation.
     *
     * @param operationName name of the web service operation to invoke to fetch records
     * @param resultType  tag or type name of the XML element to be returned as DataSource records
     * @param operationBindingProperties additional properties for the operationType:"fetch" operationBinding which this method automatically creates.
     *      This can be used to set properties such as {@link com.smartgwt.client.data.OperationBinding#setUseFlatFields(Boolean)}  or {@link com.smartgwt.client.data.OperationBinding#setRecordXPath(String)}
     * @return dDataSource representing the fetch message of a web service operation
     */
    public native DataSource getFetchDS(String operationName, String resultType, OperationBinding operationBindingProperties)/*-{        
        var self  = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        var operationBindingPropertiesJS = operationBindingProperties == null ? null : operationBindingProperties.@com.smartgwt.client.data.OperationBinding::getJsObj()();
        var ds = self.getFetchDS(operationName, resultType);
        if(ds == null || ds === undefined) {
            return null;
        } else {
            var dsJ = @com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ds);
            return dsJ;
        }
    }-*/;
    
    /**
     * Get the schema definition of any complexType or element of complexType defined in any <schema> blocks in the WSDL file this WebService represents.
     *
     * @param schemaName   name of type or element
     * @return requested schema
     */
    public native DataSource getSchema(String schemaName)/*-{
        var self  = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        var ds = self.getSchema(schemaName);

        if(ds == null || ds === undefined) {
            return null;
        } else {
            var dsJ = @com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ds);
            return dsJ;
        }
    }-*/;

    /**
     * Get the schema definition of any complexType or element of complexType defined in any <schema> blocks in the WSDL file this WebService represents.
     *
     * @param schemaName name of type or element
     * @param schemaType optional type of schema to return, either "element" for xs:element definitions only or "type" for xs:complexType definitions.
     * If unspecified, either will be returned, with types preferred if names collide
     *
     * @return requested schema
     */
    public native DataSource getSchema(String schemaName, String schemaType)/*-{
        var self  = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        var ds = self.getSchema(schemaName, schemaType);
        return ds == null || ds === undefined ? null : @com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ds);
    }-*/;

    
    /**
     * Retrieve a WebService object by the targetNamespace declared on the <wsdl:definitions> element in the WSDL
     * file from which the WebService was derived.
     *
     * @param serviceNamespace uri from the "targetNamespace" attribute of the <wsdl:definitions> element in the WSDL file
     * @return the requested WebService, or null if not loaded
     */
    public static native WebService get(String serviceNamespace) /*-{
        var ws = $wnd.isc.WebService.get(serviceNamespace);
        return ws == null ? null : @com.smartgwt.client.data.WebService::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ws);
    }-*/;
}
