package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.core.JsObject;

import java.util.Map;

public class WebService extends JsObject {

    public WebService(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public native void callOperation(String operationName, Map paramData, String resultType, WebServiceCallback callback) /*-{
        var self  = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        var paramDataJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(paramData);

        self.callOperation(operationName, paramDataJS, resultType, function(data) {
            var dataJ = @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
            callback.@com.smartgwt.client.data.WebServiceCallback::execute([Ljava/lang/String;)(dataJ);
        });
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

}
