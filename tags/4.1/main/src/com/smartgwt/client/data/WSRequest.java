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
    * A WSRequest (or "web service request") is an extended RPCRequest will additional properties application to WSDL/SOAP web services.  <P>  All properties which are legal on {@link com.smartgwt.client.rpc.RPCRequest} are legal on a WSRequest, in  addition to the properties listed here.

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
    * When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when  creating the input XML message to send to the web service, properties in  {@link com.smartgwt.client.data.WSRequest#getData data} will be used as the values for XML elements of the same name, at  any level of nesting.  <P>  <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as  extra levels of nested elements, and provides some insulation against changes in the  required structure of the input message.  <P>  For example, given this input message:  <pre>&lt;FindServices&gt;      &lt;searchFor&gt;search text&lt;/searchFor&gt;      &lt;Options&gt;          &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;      &lt;/Options&gt;      &lt;IncludeInSearch&gt;          &lt;serviceName&gt;true&lt;/serviceName&gt;          &lt;documentation&gt;true&lt;/documentation&gt;          &lt;keywords&gt;true&lt;/keywords&gt;      &lt;/IncludeInSearch&gt;  &lt;/FindServices&gt;  </pre>  If <code>useFlatFields</code> were <b>not</b> set, in order to fill out this message  correctly, <code>request.data</code> would need to be:  <pre>{     searchFor: "search text",     Options : {         caseSensitive: false,     },     IncludeInSearch : {         serviceName: true,         documentation : true,         keywords : true     }  }</pre>  However if useFlatFields were set, <code>request.data</code> could be just:  <pre>{     searchFor: "search text",     caseSensitive: false,     serviceName: true,     documentation : true,     keywords : true  }</pre>  <code>useFlatFields</code> is often set when the input data comes from a {@link com.smartgwt.client.widgets.form.DynamicForm}  to avoid the cumbersome and fragile process of mapping input fields to an XML structure.  <P>  {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} can also be set to cause <b>all</b> dsRequests of a  particular type to <code>useFlatFields</code> automatically.  <P>  For {@link com.smartgwt.client.widgets.DataBoundComponent},   {@link com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields useFlatFields} can be set use "flattened"  binding to fields of a WSDL message or XML Schema.  <P>  Note that <code>useFlatFields</code> is not generally recommended for use with XML input  messages where multiple simple type fields exist with the same name, however if used in this  way, the first field to use a given name wins.  "first" means the first field encountered in a  depth first search.  "wins" means only the first field will be populated in the generated  XML message.
    *
    * @param useFlatFields useFlatFields Default value is null
    */
    public void setUseFlatFields(Boolean useFlatFields) {
        setAttribute("useFlatFields", useFlatFields);
    }
    /**
     * When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when  creating the input XML message to send to the web service, properties in  {@link com.smartgwt.client.data.WSRequest#getData data} will be used as the values for XML elements of the same name, at  any level of nesting.  <P>  <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as  extra levels of nested elements, and provides some insulation against changes in the  required structure of the input message.  <P>  For example, given this input message:  <pre>  &lt;FindServices&gt;      &lt;searchFor&gt;search text&lt;/searchFor&gt;      &lt;Options&gt;          &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;      &lt;/Options&gt;      &lt;IncludeInSearch&gt;          &lt;serviceName&gt;true&lt;/serviceName&gt;          &lt;documentation&gt;true&lt;/documentation&gt;          &lt;keywords&gt;true&lt;/keywords&gt;      &lt;/IncludeInSearch&gt;  &lt;/FindServices&gt;  </pre>  If <code>useFlatFields</code> were <b>not</b> set, in order to fill out this message  correctly, <code>request.data</code> would need to be:  <pre>{     searchFor: "search text",     Options : {         caseSensitive: false,     },     IncludeInSearch : {         serviceName: true,         documentation : true,         keywords : true     }  }</pre>  However if useFlatFields were set, <code>request.data</code> could be just:  <pre>{     searchFor: "search text",     caseSensitive: false,     serviceName: true,     documentation : true,     keywords : true  }</pre>  <code>useFlatFields</code> is often set when the input data comes from a {@link com.smartgwt.client.widgets.form.DynamicForm}  to avoid the cumbersome and fragile process of mapping input fields to an XML structure.  <P>  {@link com.smartgwt.client.data.OperationBinding#getUseFlatFields useFlatFields} can also be set to cause <b>all</b> dsRequests of a  particular type to <code>useFlatFields</code> automatically.  <P>  For {@link com.smartgwt.client.widgets.DataBoundComponent},   {@link com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields useFlatFields} can be set use "flattened"  binding to fields of a WSDL message or XML Schema.  <P>  Note that <code>useFlatFields</code> is not generally recommended for use with XML input  messages where multiple simple type fields exist with the same name, however if used in this  way, the first field to use a given name wins.  "first" means the first field encountered in a  depth first search.  "wins" means only the first field will be populated in the generated  XML message.
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
     * Data to be serialized to form the SOAP headers, as a map from the header part name to the  data.  For example, given WSDL like this:  <pre>      &lt;soap:header part="SessionHeader" message="tns:HeaderMessage"/&gt;      &lt;soap:header part="CallOptions" message="tns:HeaderMessage/&gt;  </pre>  <code>headerData</code> like this might be provided:  <pre>      dsRequest.headerData =           { SessionHeader : <i>data</i>            CallOptions : <i>data</i> };  </pre>  The provided data will be serialized to XML by the  {@link com.smartgwt.client.data.WebService#getInputHeaderSchema} via  {@link com.smartgwt.client.data.DataSource#xmlSerialize}
     *
     * @param headerData headerData Default value is null
     */
    public void setHeaderData(Map headerData) {
        setAttribute("headerData", headerData);
    }

    /**
     * Data to be serialized to form the SOAP headers, as a map from the header part name to the  data.  For example, given WSDL like this:  <pre>      &lt;soap:header part="SessionHeader" message="tns:HeaderMessage"/&gt;      &lt;soap:header part="CallOptions" message="tns:HeaderMessage/&gt;  </pre>  <code>headerData</code> like this might be provided:  <pre>      dsRequest.headerData =           { SessionHeader : <i>data</i>            CallOptions : <i>data</i> };  </pre>  The provided data will be serialized to XML by the  {@link com.smartgwt.client.data.WebService#getInputHeaderSchema} via  {@link com.smartgwt.client.data.DataSource#xmlSerialize}
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
    * Optional object declaring namespace prefixes for use in evaluating the  <code>resultType</code> parameter of {@link com.smartgwt.client.data.WebService#callOperation}, if resultType is an  XPath.  <P>  Format is identical to {@link com.smartgwt.client.data.OperationBinding#getXmlNamespaces xmlNamespaces}, and default namespaces  bindings are also identical.
    *
    * @param xmlNamespaces xmlNamespaces Default value is null
    */
    public void setXmlNamespaces(XmlNamespaces xmlNamespaces) {
        setAttribute("xmlNamespaces", xmlNamespaces);
    }

}



