package com.smartgwt.client.data;

import com.google.gwt.json.client.JSONArray;
import com.smartgwt.client.rpc.RPCRequest;

public class XMLTools {

    public static native void loadXMLSchema(String schemaURL, XSDLoadCallback callback) /*-{
        $wnd.isc.XMLTools.loadXMLSchema(schemaURL, function(schemaSet) {
            var schemaSetJ = @com.smartgwt.client.data.SchemaSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(schemaSet);
            callback.@com.smartgwt.client.data.XSDLoadCallback::execute(Lcom/smartgwt/client/data/SchemaSet;)(schemaSetJ);
        });
    }-*/;


    public static native void loadXMLSchema(String schemaURL, XSDLoadCallback callback, RPCRequest requestProperties) /*-{
        var reqJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.rpc.RPCRequest::getJsObj()();
        $wnd.isc.XMLTools.loadXMLSchema(schemaURL, function(schemaSet) {
            var schemaSetJ = @com.smartgwt.client.data.SchemaSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(schemaSet);
            callback.@com.smartgwt.client.data.XSDLoadCallback::execute(Lcom/smartgwt/client/data/SchemaSet;)(schemaSetJ);
        }, reqJS);
    }-*/;

    public static native void loadWSDL(String wsdlURL, WSDLLoadCallback callback) /*-{
        $wnd.isc.XMLTools.loadWSDL(wsdlURL, function(service) {
            var serviceJ = @com.smartgwt.client.data.WebService::new(Lcom/google/gwt/core/client/JavaScriptObject;)(service);
            callback.@com.smartgwt.client.data.WSDLLoadCallback::execute(Lcom/smartgwt/client/data/WebService;)(serviceJ);
        });
    }-*/;

    public static native void loadWSDL(String wsdlURL, WSDLLoadCallback callback, RPCRequest requestProperties) /*-{
        var reqJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.rpc.RPCRequest::getJsObj()();
        $wnd.isc.XMLTools.loadWSDL(wsdlURL, function(service) {
            var serviceJ = @com.smartgwt.client.data.WebService::new(Lcom/google/gwt/core/client/JavaScriptObject;)(service);
            callback.@com.smartgwt.client.data.WSDLLoadCallback::execute(Lcom/smartgwt/client/data/WebService;)(serviceJ);
        }, reqJS);
    }-*/;

    public static native String selectString(Object element, String expression) /*-{
        return $wnd.isc.XMLTools.selectString(element, expression);
    }-*/;

    public static native Object selectNodes(Object element, String expression) /*-{
        return $wnd.isc.XMLTools.selectNodes(element, expression);
    }-*/;

    public static native JSONArray selectObjects(Object element, String expression) /*-{
        var ret = $wnd.isc.XMLTools.selectObjects(element, expression);
        return @com.google.gwt.json.client.JSONArray::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    public static native Object toJS(Object elements) /*-{
        return $wnd.isc.XMLTools.toJS(elements);
    }-*/;

}
