package com.smartgwt.client.data;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.rpc.RPCRequest;

import java.util.Map;

public class XMLTools {

    /**
     * Load an XML file containing XML schema definitions and create DataSource and SimpleType objects to represent the schema.
     * You can use to loaded schema to bind ISC components, perform validation, create editing interfaces, and build other
     * metadata-driven interfaces.
     * <p>
     * All &lt;xsd:complexType&gt; declarations become ISC DataSources, and all &lt;xsd:simpleType&gt; definitions become
     * atomic type definitions.
     * <p>
     * By default, named complexType definitions and named element definitions containing complexTypes become global
     * DataSources, that is, they can be fetched with DataSource.getDataSource(). Inline complexType definitions get
     * automatically generated names.
     * <p>
     * Named simpleType declarations become global ISC atomic types, that is, subsequently defined DataSources can use
     * them for DataSourceField.type. XML schema "restrictions" for simple types are automatically translated to
     * DataSourceField.valueMap or DataSourceField.validators as appropriate.
     * <p>
     * The created SchemaSet object is available in the callback as the single parameter "schemaSet", or can retrieved
     * via SchemaSet.get(schemaNamespace).
     * <p>
     * NOTE: required fields: the XML concept of "required" for an attribute or subelement, expressed via use="required"
     * (for an attribute) or minOccurs > 0 (for a subelement), is that the attribute or element must be present in the
     * XML document but can have any value, including being empty or null. The SmartGWT notion of required means non-null.
     * You can express the SmartClient notion of required in XML Schema with the combination of maxOccurs>0 and a minLength
     * or length "restriction", and SmartClient will recognize the field as SmartClient-required, with all of the behaviors
     *  that implies (eg, specially styled form titles, automatic validation, etc).
     * 
     * @param schemaURL URL to load the schema from
     * @param callback the callback
     */
    public static native void loadXMLSchema(String schemaURL, XSDLoadCallback callback) /*-{
        $wnd.isc.XMLTools.loadXMLSchema(schemaURL, function(schemaSet) {
            var schemaSetJ = @com.smartgwt.client.data.SchemaSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(schemaSet);
            callback.@com.smartgwt.client.data.XSDLoadCallback::execute(Lcom/smartgwt/client/data/SchemaSet;)(schemaSetJ);
        });
    }-*/;

    /**
     * Load an XML file containing XML schema definitions and create DataSource and SimpleType objects to represent the schema.
     * You can use to loaded schema to bind ISC components, perform validation, create editing interfaces, and build other
     * metadata-driven interfaces.
     * <p>
     * All &lt;xsd:complexType&gt; declarations become ISC DataSources, and all &lt;xsd:simpleType&gt; definitions become
     * atomic type definitions.
     * <p>
     * By default, named complexType definitions and named element definitions containing complexTypes become global
     * DataSources, that is, they can be fetched with DataSource.getDataSource(). Inline complexType definitions get
     * automatically generated names.
     * <p>
     * Named simpleType declarations become global ISC atomic types, that is, subsequently defined DataSources can use
     * them for DataSourceField.type. XML schema "restrictions" for simple types are automatically translated to
     * DataSourceField.valueMap or DataSourceField.validators as appropriate.
     * <p>
     * The created SchemaSet object is available in the callback as the single parameter "schemaSet", or can retrieved
     * via SchemaSet.get(schemaNamespace).
     * <p>
     * NOTE: required fields: the XML concept of "required" for an attribute or subelement, expressed via use="required"
     * (for an attribute) or minOccurs > 0 (for a subelement), is that the attribute or element must be present in the
     * XML document but can have any value, including being empty or null. The SmartGWT notion of required means non-null.
     * You can express the SmartClient notion of required in XML Schema with the combination of maxOccurs>0 and a minLength
     * or length "restriction", and SmartClient will recognize the field as SmartClient-required, with all of the behaviors
     *  that implies (eg, specially styled form titles, automatic validation, etc).
     *
     * @param schemaURL URL to load the schema from
     * @param callback the callback
     * @param requestProperties additional properties to set on the RPCRequest that will be issued
     */
    public static native void loadXMLSchema(String schemaURL, XSDLoadCallback callback, RPCRequest requestProperties) /*-{
        var reqJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.rpc.RPCRequest::getJsObj()();
        $wnd.isc.XMLTools.loadXMLSchema(schemaURL, function(schemaSet) {
            var schemaSetJ = @com.smartgwt.client.data.SchemaSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(schemaSet);
            callback.@com.smartgwt.client.data.XSDLoadCallback::execute(Lcom/smartgwt/client/data/SchemaSet;)(schemaSetJ);
        }, reqJS);
    }-*/;
    
    /**
     * Load an XML file containing XML schema definitions and create DataSource and SimpleType objects to represent the schema.
     * You can use to loaded schema to bind ISC components, perform validation, create editing interfaces, and build other
     * metadata-driven interfaces.
     * <p>
     * All &lt;xsd:complexType&gt; declarations become ISC DataSources, and all &lt;xsd:simpleType&gt; definitions become
     * atomic type definitions.
     * <p>
     * By default, named complexType definitions and named element definitions containing complexTypes become global
     * DataSources, that is, they can be fetched with DataSource.getDataSource(). Inline complexType definitions get
     * automatically generated names.
     * <p>
     * Named simpleType declarations become global ISC atomic types, that is, subsequently defined DataSources can use
     * them for DataSourceField.type. XML schema "restrictions" for simple types are automatically translated to
     * DataSourceField.valueMap or DataSourceField.validators as appropriate.
     * <p>
     * The created SchemaSet object is available in the callback as the single parameter "schemaSet", or can retrieved
     * via SchemaSet.get(schemaNamespace).
     * <p>
     * NOTE: required fields: the XML concept of "required" for an attribute or subelement, expressed via use="required"
     * (for an attribute) or minOccurs > 0 (for a subelement), is that the attribute or element must be present in the
     * XML document but can have any value, including being empty or null. The SmartGWT notion of required means non-null.
     * You can express the SmartClient notion of required in XML Schema with the combination of maxOccurs>0 and a minLength
     * or length "restriction", and SmartClient will recognize the field as SmartClient-required, with all of the behaviors
     *  that implies (eg, specially styled form titles, automatic validation, etc).
     *
     * @param schemaURL URL to load the schema from
     * @param callback the callback
     * @param requestProperties additional properties to set on the RPCRequest that will be issued
     * @param autoLoadImports if set, xsd:import statements will be processed automatically to load dependent XSD files where a "location" is specified.
     * The callback will not fire until all dependencies have been loaded
     */
    public static native void loadXMLSchema(String schemaURL, XSDLoadCallback callback, RPCRequest requestProperties, boolean autoLoadImports) /*-{
        var reqJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.rpc.RPCRequest::getJsObj()();
        $wnd.isc.XMLTools.loadXMLSchema(schemaURL, function(schemaSet) {
            var schemaSetJ = @com.smartgwt.client.data.SchemaSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(schemaSet);
            callback.@com.smartgwt.client.data.XSDLoadCallback::execute(Lcom/smartgwt/client/data/SchemaSet;)(schemaSetJ);
        }, reqJS, autoLoadImports);
    }-*/;

    /**
     * Load a WSDL file and create an instance of WebService that allows invoking operations and binding DataSources to web service operations.
     * The created WebService object is available in the callback as the single parameter "service", or can retrieved via WebService.get(serviceNamespace).
     * <p>
     * XML Schema present in the WSDL file will also will also be processed as described in XMLTools.loadXMLSchema().
     * <p>
     *
     * Platform notes: loadWSDL() is not supported in Safari 2.0 (but is supported in Safari 3.0.3 and greater)
     * 
     * @param wsdlURL URL to load the WSDL file from
     * @param callback the callback
     */
    public static native void loadWSDL(String wsdlURL, WSDLLoadCallback callback) /*-{
        $wnd.isc.XMLTools.loadWSDL(wsdlURL, function(service) {
            var serviceJ = @com.smartgwt.client.data.WebService::new(Lcom/google/gwt/core/client/JavaScriptObject;)(service);
            callback.@com.smartgwt.client.data.WSDLLoadCallback::execute(Lcom/smartgwt/client/data/WebService;)(serviceJ);
        });
    }-*/;

    /**
     * Load a WSDL file and create an instance of WebService that allows invoking operations and binding DataSources to web service operations.
     * The created WebService object is available in the callback as the single parameter "service", or can retrieved via WebService.get(serviceNamespace).
     * <p>
     * XML Schema present in the WSDL file will also will also be processed as described in XMLTools.loadXMLSchema().
     * <p>
     *
     * Platform notes: loadWSDL() is not supported in Safari 2.0 (but is supported in Safari 3.0.3 and greater)
     *
     * @param wsdlURL URL to load the WSDL file from
     * @param callback the callback
     * @param requestProperties  additional properties to set on the RPCRequest that will be issued
     */
    public static native void loadWSDL(String wsdlURL, WSDLLoadCallback callback, RPCRequest requestProperties) /*-{
        var reqJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.rpc.RPCRequest::getJsObj()();
        $wnd.isc.XMLTools.loadWSDL(wsdlURL, function(service) {
            var serviceJ = @com.smartgwt.client.data.WebService::new(Lcom/google/gwt/core/client/JavaScriptObject;)(service);
            callback.@com.smartgwt.client.data.WSDLLoadCallback::execute(Lcom/smartgwt/client/data/WebService;)(serviceJ);
        }, reqJS);
    }-*/;

    /**
     * Load a WSDL file and create an instance of WebService that allows invoking operations and binding DataSources to web service operations.
     * The created WebService object is available in the callback as the single parameter "service", or can retrieved via WebService.get(serviceNamespace).
     * <p>
     * XML Schema present in the WSDL file will also will also be processed as described in XMLTools.loadXMLSchema().
     * <p>
     *
     * Platform notes: loadWSDL() is not supported in Safari 2.0 (but is supported in Safari 3.0.3 and greater)
     *
     * @param wsdlURL URL to load the WSDL file from
     * @param callback the callback
     * @param requestProperties  additional properties to set on the RPCRequest that will be issued
     * @param autoLoadImports  if set, xsd:import statements will be processed automatically to load dependent XSD files where a "location" is specified.
     * The callback will not fire until all dependencies have been loaded
     */
    public static native void loadWSDL(String wsdlURL, WSDLLoadCallback callback, RPCRequest requestProperties, boolean autoLoadImports) /*-{
        var reqJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.rpc.RPCRequest::getJsObj()();
        $wnd.isc.XMLTools.loadWSDL(wsdlURL, function(service) {
            var serviceJ = @com.smartgwt.client.data.WebService::new(Lcom/google/gwt/core/client/JavaScriptObject;)(service);
            callback.@com.smartgwt.client.data.WSDLLoadCallback::execute(Lcom/smartgwt/client/data/WebService;)(serviceJ);
        }, reqJS, autoLoadImports);
    }-*/;

    /**
     * Retrieve a string value from an XML element or document based on an XPath expression. If more than one node matches,
     * only the first node's value will be returned.
     * <p>
     * Namespacing works as described under XMLTools.selectNodes()
     * <p>
     * NOTE: this API cannot be supported on the Safari web browser for versions prior to 3.0.3.
     *  
     * @param element  Native XMLElement, document or String xml to select from
     * @param expression   XPath expression to use to select nodes
     * @return result of the XPath, in String form
     */
    public static native String selectString(Object element, String expression) /*-{
        return $wnd.isc.XMLTools.selectString(element, expression);
    }-*/;

    /**
     * Retrieve a string value from an XML element or document based on an XPath expression. If more than one node matches,
     * only the first node's value will be returned.
     * <p>
     * Namespacing works as described under XMLTools.selectNodes()
     * <p>
     * NOTE: this API cannot be supported on the Safari web browser for versions prior to 3.0.3.
     *
     * @param element  Native XMLElement, document or String xml to select from
     * @param expression   XPath expression to use to select nodes
     * @param namespaces namespaces 
     * @return result of the XPath, in String form
     */
    public static native String selectString(Object element, String expression, Map namespaces) /*-{
        return $wnd.isc.XMLTools.selectString(element, expression, @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(namespaces));
    }-*/;

    /**
     * Retrieve a set of nodes from an XML element or document based on an XPath expression.
     * 
     * @param element Native XMLElement,document or string xml to select from
     * @param expression XPath expression to use to select nodes
     * @return list of nodes matching XPath
     */
    public static native Object selectNodes(Object element, String expression) /*-{
        return $wnd.isc.XMLTools.selectNodes(element, expression);
    }-*/;


    /**
     * Retrieve a set of nodes from an XML element or document based on an XPath expression.
     * <p>
     * If the target document is namespaced, namespace prefixes declared in the document element of the target document
     * will be available, as well as the default namespace, if declared, under the prefix "default".
     * <p>
     * To declare your own namespace prefixes, provide a prefix to URI mapping as a simple JS Object, for example:
     * <p>
     * {
     *  az : "http://webservices.amazon.com/AWSECommerceService/2005-03-23",
     *  xsd : "http://www.w3.org/2001/XMLSchema"
     * }
     * <p>
     * NOTE: this API cannot be supported on the Safari web browser for versions earlier than 3.0.3.
     *
     * @param element Native XMLElement,document to select from
     * @param expression XPath expression to use to select nodes
     * @param namespaces namespace mapping used by the expression as prefix -> URI mapping
     * @return list of nodes matching XPath
     */
    public static native Object selectNodes(Object element, String expression, Map namespaces) /*-{
        return $wnd.isc.XMLTools.selectNodes(element, expression, @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(namespaces));
    }-*/;

    /**
     * Applies an XPath expression to JavaScript objects, returning matching objects.
     * 
     * @param element Object to select results from
     * @param expression  XPath expression
     * @return Array of matching objects, or null for no match
     */
    public static native JSONArray selectObjects(Object element, String expression) /*-{
        var ret = $wnd.isc.XMLTools.selectObjects(element, expression);
        return @com.google.gwt.json.client.JSONArray::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * ranslates an XML fragment to JavaScript collections.
     * 
     * @param elements  XMLElement or XMLDocument element to tranform to JS
     * @return The resulting JavaScript collection
     */
    public static native JavaScriptObject toJS(Object elements) /*-{
        return $wnd.isc.XMLTools.toJS(elements);
    }-*/;

}
