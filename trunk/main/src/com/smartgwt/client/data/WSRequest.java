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
    * A WSRequest (or "web service request") is an extended RPCRequest will additional properties&#010 application to WSDL/SOAP web services.&#010 <P>&#010 All properties which are legal on {@link com.smartgwt.client.rpc.RPCRequest} are legal on a WSRequest, in&#010 addition to the properties listed here.

    */
public class WSRequest extends RPCRequest {

    public static WSRequest getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new WSRequest(jsObj);
    }


    public WSRequest(){
        
    }

    public WSRequest(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Name of the web service operation to invoke.
    *
    * @param wsOperation wsOperation Default value is null
    */
    public void setWsOperation(String wsOperation) {
        setAttribute("wsOperation", wsOperation);
    }
    /**
     * Name of the web service operation to invoke.
     *
     *
     * @return String
     *
     */
    public String getWsOperation()  {
        return getAttributeAsString("wsOperation");
    }

    /**
    * When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when&#010 creating the input XML message to send to the web service, properties in&#010 {@link com.smartgwt.client.data.WSRequest#getData data} will be used as the values for XML elements of the same name, at&#010 any level of nesting.&#010 <P>&#010 <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as&#010 extra levels of nested elements, and provides some insulation against changes in the&#010 required structure of the input message.&#010 <P>&#010 For example, given this input message:&#010 <pre>&#010 &lt;FindServices&gt;&#010     &lt;searchFor&gt;search text&lt;/searchFor&gt;&#010     &lt;Options&gt;&#010         &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;&#010     &lt;/Options&gt;&#010     &lt;IncludeInSearch&gt;&#010         &lt;serviceName&gt;true&lt;/serviceName&gt;&#010         &lt;documentation&gt;true&lt;/documentation&gt;&#010         &lt;keywords&gt;true&lt;/keywords&gt;&#010     &lt;/IncludeInSearch&gt;&#010 &lt;/FindServices&gt;&#010 </pre>&#010 If <code>useFlatFields</code> were <b>not</b> set, in order to fill out this message&#010 correctly, <code>request.data</code> would need to be:&#010 <pre>{&#010    searchFor: "search text",&#010    Options : {&#010        caseSensitive: false,&#010    },&#010    IncludeInSearch : {&#010        serviceName: true,&#010        documentation : true,&#010        keywords : true&#010    }&#010 }</pre>&#010 However if useFlatFields were set, <code>request.data</code> could be just:&#010 <pre>{&#010    searchFor: "search text",&#010    caseSensitive: false,&#010    serviceName: true,&#010    documentation : true,&#010    keywords : true&#010 }</pre>&#010 <code>useFlatFields</code> is often set when the input data comes from a {@link com.smartgwt.client.widgets.form.DynamicForm}&#010 to avoid the cumbersome and fragile process of mapping input fields to an XML structure.&#010 <P>&#010 {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} can also be set to cause <b>all</b> dsRequests of a&#010 particular type to <code>useFlatFields</code> automatically.&#010 <P>&#010 For {@link com.smartgwt.client.widgets.DataBoundComponent}, &#010 {@link com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields useFlatFields} can be set use "flattened"&#010 binding to fields of a WSDL message or XML Schema.&#010 <P>&#010 Note that <code>useFlatFields</code> is not generally recommended for use with XML input&#010 messages where multiple simple type fields exist with the same name, however if used in this&#010 way, the first field to use a given name wins.  "first" means the first field encountered in a&#010 depth first search.  "wins" means only the first field will be populated in the generated&#010 XML message.
    *
    * @param useFlatFields useFlatFields Default value is null
    */
    public void setUseFlatFields(Boolean useFlatFields) {
        setAttribute("useFlatFields", useFlatFields);
    }
    /**
     * When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when&#010 creating the input XML message to send to the web service, properties in&#010 {@link com.smartgwt.client.data.WSRequest#getData data} will be used as the values for XML elements of the same name, at&#010 any level of nesting.&#010 <P>&#010 <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as&#010 extra levels of nested elements, and provides some insulation against changes in the&#010 required structure of the input message.&#010 <P>&#010 For example, given this input message:&#010 <pre>&#010 &lt;FindServices&gt;&#010     &lt;searchFor&gt;search text&lt;/searchFor&gt;&#010     &lt;Options&gt;&#010         &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;&#010     &lt;/Options&gt;&#010     &lt;IncludeInSearch&gt;&#010         &lt;serviceName&gt;true&lt;/serviceName&gt;&#010         &lt;documentation&gt;true&lt;/documentation&gt;&#010         &lt;keywords&gt;true&lt;/keywords&gt;&#010     &lt;/IncludeInSearch&gt;&#010 &lt;/FindServices&gt;&#010 </pre>&#010 If <code>useFlatFields</code> were <b>not</b> set, in order to fill out this message&#010 correctly, <code>request.data</code> would need to be:&#010 <pre>{&#010    searchFor: "search text",&#010    Options : {&#010        caseSensitive: false,&#010    },&#010    IncludeInSearch : {&#010        serviceName: true,&#010        documentation : true,&#010        keywords : true&#010    }&#010 }</pre>&#010 However if useFlatFields were set, <code>request.data</code> could be just:&#010 <pre>{&#010    searchFor: "search text",&#010    caseSensitive: false,&#010    serviceName: true,&#010    documentation : true,&#010    keywords : true&#010 }</pre>&#010 <code>useFlatFields</code> is often set when the input data comes from a {@link com.smartgwt.client.widgets.form.DynamicForm}&#010 to avoid the cumbersome and fragile process of mapping input fields to an XML structure.&#010 <P>&#010 {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} can also be set to cause <b>all</b> dsRequests of a&#010 particular type to <code>useFlatFields</code> automatically.&#010 <P>&#010 For {@link com.smartgwt.client.widgets.DataBoundComponent}, &#010 {@link com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields useFlatFields} can be set use "flattened"&#010 binding to fields of a WSDL message or XML Schema.&#010 <P>&#010 Note that <code>useFlatFields</code> is not generally recommended for use with XML input&#010 messages where multiple simple type fields exist with the same name, however if used in this&#010 way, the first field to use a given name wins.  "first" means the first field encountered in a&#010 depth first search.  "wins" means only the first field will be populated in the generated&#010 XML message.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseFlatFields()  {
        return getAttributeAsBoolean("useFlatFields");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************





    /**
     * Data to be serialized to form the SOAP headers, as a map from the header part name to the&#010 data.  For example, given WSDL like this:&#010 <pre>&#010     &lt;soap:header part="SessionHeader" message="tns:HeaderMessage"/&gt;&#010     &lt;soap:header part="CallOptions" message="tns:HeaderMessage/&gt;&#010 </pre>&#010 <code>headerData</code> like this might be provided:&#010 <pre>&#010     dsRequest.headerData = &#010         { SessionHeader : <i>data</i>&#010           CallOptions : <i>data</i> };&#010 </pre>&#010 The provided data will be serialized to XML by the&#010 {@link com.smartgwt.client.data.WebService#getInputHeaderSchema} via&#010 {@link com.smartgwt.client.data.DataSource#xmlSerialize}
     *
     * @param headerData headerData Default value is null
     */
    public void setHeaderData(Map headerData) {
        setAttribute("headerData", headerData);
    }

    /**
     * Data to be serialized to form the SOAP headers, as a map from the header part name to the&#010 data.  For example, given WSDL like this:&#010 <pre>&#010     &lt;soap:header part="SessionHeader" message="tns:HeaderMessage"/&gt;&#010     &lt;soap:header part="CallOptions" message="tns:HeaderMessage/&gt;&#010 </pre>&#010 <code>headerData</code> like this might be provided:&#010 <pre>&#010     dsRequest.headerData = &#010         { SessionHeader : <i>data</i>&#010           CallOptions : <i>data</i> };&#010 </pre>&#010 The provided data will be serialized to XML by the&#010 {@link com.smartgwt.client.data.WebService#getInputHeaderSchema} via&#010 {@link com.smartgwt.client.data.DataSource#xmlSerialize}
     *
     * @return headerData Default value is null
     */
    public Map getHeaderData() {
        return getAttributeAsMap("headerData");
    }

    /**
     * Data to be serialized to XML to form the SOAP body.
     *
     * @param data data Default value is null
     */
    public void setData(JavaScriptObject data) {
        setAttribute("data", data);
    }

    /**
     * Data to be serialized to XML to form the SOAP body.
     *
     * @param data data Default value is null
     */
    public void setData(Map data) {
        setAttribute("data", data);
    }

    /**
     * Data to be serialized to XML to form the SOAP body.
     *
     * @return the data
     */
    public JavaScriptObject getData() {
        return getAttributeAsJavaScriptObject("data");
    }

    public Map getDataAsMap() {
        return getAttributeAsMap("data");
    }

    /**
    * Optional object declaring namespace prefixes for use in evaluating the&#010 <code>resultType</code> parameter of {@link com.smartgwt.client.data.WebService#callOperation}, if resultType is an&#010 XPath.&#010 <P>&#010 Format is identical to {@link com.smartgwt.client.data.OperationBinding#getXmlNamespaces xmlNamespaces}, and default namespaces&#010 bindings are also identical.
    *
    * @param xmlNamespaces xmlNamespaces Default value is null
    */
    public void setXmlNamespaces(XmlNamespaces xmlNamespaces) {
        setAttribute("xmlNamespaces", xmlNamespaces);
    }

}



