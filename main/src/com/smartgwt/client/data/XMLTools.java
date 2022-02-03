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
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process


/**
 * Utility methods for dealing with XML elements, XML Schema, WSDL files, XSLT, and other XML-related functionality.
 */
@BeanFactory.FrameworkClass
public class XMLTools {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Disables an Internet Explorer-specific work around for the MSXML bug that the 'xml' namespace
     *  prefix cannot be explicitly declared.
     *  <p>
     *  Though redundant,
     *  the <a href='http://www.w3.org/TR/REC-xml-names/#xmlReserved' target='_blank'>Namespaces in XML spec allows</a>
     *  XML documents to explicitly declare namespace prefix 'xml' bound to namespace name
     *  <code>http://www.w3.org/XML/1998/namespace</code>; e.g.
     *  <pre>xmlns:xml="http://www.w3.org/XML/1998/namespace"</pre>
     *  MSXML does not allow the 'xml' namespace prefix to be declared, and will raise the XML
     *  parse error: The namespace prefix is not allowed to start with the reserved string "xml".
     *  Microsoft has disclosed this bug as a Normative Variation in MSXML:
     * <a href='http://msdn.microsoft.com/en-us/library/ff460535(v=vs.85).aspx'
     * target='_blank'>http://msdn.microsoft.com/en-us/library/ff460535(v=vs.85).aspx</a>.
     * A framework-level work around is used by default in {@link com.smartgwt.client.data.XMLTools#parseXML parseXML()} where
     * if the
     *  string <code>xmlns:xml="http://www.w3.org/XML/1998/namespace"</code> or
     *  <code>xmlns:xml='http://www.w3.org/XML/1998/namespace'</code> is found in the first 1000
     *  characters of the <code>xmlText</code> parameter to parseXML(), then these two strings are
     *  removed from <code>xmlText</code> wherever they appear. This work around may be disabled by
     *  calling disableIEXMLHackaround() at any time before parseXML() is called.
     * 
     */
    public static native void disableIEXMLHackaround() /*-{
        $wnd.isc.XMLTools.disableIEXMLHackaround();
    }-*/;





	/**
     * Returns true if the current browser exposes an XML parser that can be used for Smart GWT XML operations like web service
     * bindings and XML processing.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more information on when the
     * XML parser may not available and what features are impacted as a result.
     *
     * @return true if native XML processing is available, false otherwise.
     */
    public static native boolean nativeXMLAvailable() /*-{
        var ret = $wnd.isc.XMLTools.nativeXMLAvailable();
        return ret == null ? false : ret;
    }-*/;










    // ***********************************************************



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
     * @param autoLoadImports if set, xsd:
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
            var serviceJ = service == null ? null : @com.smartgwt.client.data.WebService::new(Lcom/google/gwt/core/client/JavaScriptObject;)(service);
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
            var serviceJ = service == null ? null : @com.smartgwt.client.data.WebService::new(Lcom/google/gwt/core/client/JavaScriptObject;)(service);
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
     * @param autoLoadImports  if set, xsd:
     * The callback will not fire until all dependencies have been loaded
     */
    public static native void loadWSDL(String wsdlURL, WSDLLoadCallback callback, RPCRequest requestProperties, boolean autoLoadImports) /*-{
        var reqJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.rpc.RPCRequest::getJsObj()();
        $wnd.isc.XMLTools.loadWSDL(wsdlURL, function(service) {
            var serviceJ = service == null ? null : @com.smartgwt.client.data.WebService::new(Lcom/google/gwt/core/client/JavaScriptObject;)(service);
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
     * <pre>
     * {
     *  az : "http://webservices.amazon.com/AWSECommerceService/2005-03-23",
     *  xsd : "http://www.w3.org/2001/XMLSchema"
     * }
     * </pre>
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
    public static native com.google.gwt.json.client.JSONArray selectObjects(Object element, String expression) /*-{
        var ret = $wnd.isc.XMLTools.selectObjects(element, expression);
        return @com.google.gwt.json.client.JSONArray::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Translates an XML fragment to JavaScript collections.
     * 
     * @param elements  XMLElement or XMLDocument element to transform to JS
     * @return The resulting JavaScript collection
     */
    public static native JavaScriptObject toJS(Object elements) /*-{
        return $wnd.isc.XMLTools.toJS(elements);
    }-*/;
    
    /**
     * Retrieve a numeric value from an XML element or document based on an XPath expression.
     * <P>
     * If more than one node matches, only the first node's value will be returned.
     * <P>
     * Namespacing works as described under +link{XMLTools.selectNodes()}
     * <P>
     * <b>NOTE:</b> this API cannot be supported on the Safari web browser for versions prior to
     * 3.0.3.
     *  
     * @param element  Native XMLElement, document or String xml to select from
     * @param expression   XPath expression to use to select nodes
     * @return result of the XPath, in int form
     */
    public static native int selectNumber(Object element, String expression) /*-{
        return $wnd.isc.XMLTools.selectNumber(element, expression);
    }-*/;

    /**
     * Retrieve a numeric value from an XML element or document based on an XPath expression.
     * <P>
     * If more than one node matches, only the first node's value will be returned.
     * <P>
     * Namespacing works as described under +link{XMLTools.selectNodes()}
     * <P>
     * <b>NOTE:</b> this API cannot be supported on the Safari web browser for versions prior to
     * 3.0.3.
     *  
     * @param element  Native XMLElement, document or String xml to select from
     * @param expression   XPath expression to use to select nodes
     * @param namespaces namespaces 
     * @return result of the XPath, in int form
     */
    public static native int selectNumber(Object element, String expression, Map namespaces) /*-{
        return $wnd.isc.XMLTools.selectNumber(element, expression, @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(namespaces));
    }-*/;

}
