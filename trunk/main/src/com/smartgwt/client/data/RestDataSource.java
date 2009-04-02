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
    * The RestDataSource implements the 4 core DataSource operations using a simple protocol of XML or JSON requests and responses sent over HTTP, which can be easily fulfilled by any HTTP server technology. <P> RestDataSource is named for the <a href='http://www.google.com/search?hl=en&q=REST+HTTP' onclick="window.open('http://www.google.com/search?hl=en&q=REST+HTTP');return false;">REST</a> (REpresentational State Transfer) pattern, which in brief says that simple messages passed over HTTP is a sufficient protocol for many web applications, without the need for further protocols such as WSDL or SOAP. <P> A RestDataSource is used just like a normal DataSource.  RestDataSources are configured, using the general-purpose databinding facilities of DataSources, to expect a particular format for responses and to send requests in a specific format.   These request and response formats represent Isomorphic's recommended best practices for binding SmartClient to backends which do not already support a similar, pre-existing request and response format. <P> Full source code to the RestDataSource is provided (see  /examples/databinding/RestDataSource.js), intended for possible further modification and an extended example of how to use SmartClient's general databinding engine. <P> RestDataSource is typically used with PHP, Ruby, Python, Perl or custom server technologies, and represents an alternative to installing the SmartClient Server in a Java technology stack, or using WSDL-based binding with .NET or other WSDL-capable technologies. <P> <span style="font-weight:bold;font-size:16px;">Examples</span> <p> <b>XML formatted responses:</b> <P> RestDataSource expects a response to like the following in response to a "fetch" request: <pre> &lt;response&gt;    &lt;status&gt;0&lt;/status&gt;    &lt;data&gt;      &lt;record&gt;          &lt;field1&gt;value&lt;/field1&gt;          &lt;field2&gt;value&lt;/field2&gt;      &lt;/record&gt;      &lt;record&gt;          &lt;field1&gt;value&lt;/field1&gt;          &lt;field2&gt;value&lt;/field2&gt;      &lt;/record&gt;    &lt;/data&gt; &lt;/response&gt; </pre> The status element indicates whether the fetch operation was successful  (see Tree Databinding.

    */
public class RestDataSource extends DataSource {

    public static RestDataSource getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (RestDataSource) obj;
        } else {
            return new RestDataSource(jsObj);
        }
    }


    public RestDataSource(){
        
    }

    public RestDataSource(JavaScriptObject jsObj){
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        return $wnd.isc.RestDataSource.create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * <code>recordXPath</code> mapping to the data node of XML returned by the server. Applies if this.dataFormat is set to <code>"xml"</code>.<br> The default value will pick up data from a response structured as follows:<br> <pre> &lt;response&gt;    &lt;status&gt;0&lt;/status&gt;    &lt;data&gt;      &lt;record&gt;          &lt;field1&gt;value&lt;/field1&gt;          &lt;field2&gt;value&lt;/field2&gt;      &lt;/record&gt;      &lt;record&gt;          &lt;field1&gt;value&lt;/field1&gt;          &lt;field2&gt;value&lt;/field2&gt;      &lt;/record&gt;    &lt;/data&gt; &lt;/response&gt; </pre>
    *
    * @param xmlRecordXPath xmlRecordXPath Default value is "/response/data/*"
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setXmlRecordXPath(String xmlRecordXPath)  throws IllegalStateException {
        setAttribute("xmlRecordXPath", xmlRecordXPath, false);
    }
    /**
     * <code>recordXPath</code> mapping to the data node of XML returned by the server. Applies if this.dataFormat is set to <code>"xml"</code>.<br> The default value will pick up data from a response structured as follows:<br> <pre> &lt;response&gt;    &lt;status&gt;0&lt;/status&gt;    &lt;data&gt;      &lt;record&gt;          &lt;field1&gt;value&lt;/field1&gt;          &lt;field2&gt;value&lt;/field2&gt;      &lt;/record&gt;      &lt;record&gt;          &lt;field1&gt;value&lt;/field1&gt;          &lt;field2&gt;value&lt;/field2&gt;      &lt;/record&gt;    &lt;/data&gt; &lt;/response&gt; </pre>
     *
     *
     * @return String
     *
     */
    public String getXmlRecordXPath()  {
        return getAttributeAsString("xmlRecordXPath");
    }

    /**
    * <code>recordXPath</code> mapping to the data node of json returned by the server. Applies if this.dataFormat is set to <code>"json"</code><br> The default value will pick up data from a response structured as follows:<br> <pre> {response:  {status:0,   data:[      {field1:"value", field2:"value"},      {field1:"value", field2:"value"}   ] } </pre>
    *
    * @param jsonRecordXPath jsonRecordXPath Default value is "/response/data"
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setJsonRecordXPath(String jsonRecordXPath)  throws IllegalStateException {
        setAttribute("jsonRecordXPath", jsonRecordXPath, false);
    }
    /**
     * <code>recordXPath</code> mapping to the data node of json returned by the server. Applies if this.dataFormat is set to <code>"json"</code><br> The default value will pick up data from a response structured as follows:<br> <pre> {response:  {status:0,   data:[      {field1:"value", field2:"value"},      {field1:"value", field2:"value"}   ] } </pre>
     *
     *
     * @return String
     *
     */
    public String getJsonRecordXPath()  {
        return getAttributeAsString("jsonRecordXPath");
    }

    /**
    * For RestDataSources, by default, either the {@link com.smartgwt.client.data.RestDataSource#getXmlRecordXPath xmlRecordXPath} or  {@link com.smartgwt.client.data.RestDataSource#getJsonRecordXPath jsonRecordXPath} is used by default based on the {@link com.smartgwt.client.data.RestDataSource#getDataFormat dataFormat} setting. <P> Note that you can also apply record xpath binding via {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}.
    *
    * @param recordXPath recordXPath Default value is null
    */
    public void setRecordXPath(String recordXPath) {
        setAttribute("recordXPath", recordXPath, true);
    }
    /**
     * For RestDataSources, by default, either the {@link com.smartgwt.client.data.RestDataSource#getXmlRecordXPath xmlRecordXPath} or  {@link com.smartgwt.client.data.RestDataSource#getJsonRecordXPath jsonRecordXPath} is used by default based on the {@link com.smartgwt.client.data.RestDataSource#getDataFormat dataFormat} setting. <P> Note that you can also apply record xpath binding via {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}.
     *
     *
     * @return String
     *
     */
    public String getRecordXPath()  {
        return getAttributeAsString("recordXPath");
    }

    /**
    * When using dataFormat:"json" and dataProtocol:"postMessage" should we use the {@link com.smartgwt.client..JSONEncoder#getPrettyPrint prettyPrint} feature to enable indented, highly readable JSON messages. <P> True by default because the bandwidth involved is generally neglible and the benefits for troubleshooting are key.
    *
    * @param prettyPrintJSON prettyPrintJSON Default value is true
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setPrettyPrintJSON(Boolean prettyPrintJSON)  throws IllegalStateException {
        setAttribute("prettyPrintJSON", prettyPrintJSON, false);
    }
    /**
     * When using dataFormat:"json" and dataProtocol:"postMessage" should we use the {@link com.smartgwt.client..JSONEncoder#getPrettyPrint prettyPrint} feature to enable indented, highly readable JSON messages. <P> True by default because the bandwidth involved is generally neglible and the benefits for troubleshooting are key.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getPrettyPrintJSON()  {
        return getAttributeAsBoolean("prettyPrintJSON");
    }

    /**
    * Default URL to contact to fulfill all DSRequests.   RestDataSources also allow per-operationType dataURLs to be set via <ul> <li>{@link com.smartgwt.client.data.RestDataSource#getFetchDataURL fetchDataURL}</li> <li>{@link com.smartgwt.client.data.RestDataSource#getAddDataURL addDataURL}</li>  <li>{@link com.smartgwt.client.data.RestDataSource#getUpdateDataURL updateDataURL}</li> <li>{@link com.smartgwt.client.data.RestDataSource#getRemoveDataURL removeDataURL}</li> </ul>
    *
    * @param dataURL dataURL Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setDataURL(String dataURL)  throws IllegalStateException {
        setAttribute("dataURL", dataURL, false);
    }
    /**
     * Default URL to contact to fulfill all DSRequests.   RestDataSources also allow per-operationType dataURLs to be set via <ul> <li>{@link com.smartgwt.client.data.RestDataSource#getFetchDataURL fetchDataURL}</li> <li>{@link com.smartgwt.client.data.RestDataSource#getAddDataURL addDataURL}</li>  <li>{@link com.smartgwt.client.data.RestDataSource#getUpdateDataURL updateDataURL}</li> <li>{@link com.smartgwt.client.data.RestDataSource#getRemoveDataURL removeDataURL}</li> </ul>
     *
     *
     * @return String
     *
     */
    public String getDataURL()  {
        return getAttributeAsString("dataURL");
    }

    /**
    * Custom dataURL for fetch type operations
    *
    * @param fetchDataURL fetchDataURL Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setFetchDataURL(String fetchDataURL)  throws IllegalStateException {
        setAttribute("fetchDataURL", fetchDataURL, false);
    }
    /**
     * Custom dataURL for fetch type operations
     *
     *
     * @return String
     *
     */
    public String getFetchDataURL()  {
        return getAttributeAsString("fetchDataURL");
    }

    /**
    * Custom dataURL for update type operations
    *
    * @param updateDataURL updateDataURL Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setUpdateDataURL(String updateDataURL)  throws IllegalStateException {
        setAttribute("updateDataURL", updateDataURL, false);
    }
    /**
     * Custom dataURL for update type operations
     *
     *
     * @return String
     *
     */
    public String getUpdateDataURL()  {
        return getAttributeAsString("updateDataURL");
    }

    /**
    * Custom dataURL for add type operations
    *
    * @param addDataURL addDataURL Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setAddDataURL(String addDataURL)  throws IllegalStateException {
        setAttribute("addDataURL", addDataURL, false);
    }
    /**
     * Custom dataURL for add type operations
     *
     *
     * @return String
     *
     */
    public String getAddDataURL()  {
        return getAttributeAsString("addDataURL");
    }

    /**
    * dataURL for fetch type operations
    *
    * @param removeDataURL removeDataURL Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setRemoveDataURL(String removeDataURL)  throws IllegalStateException {
        setAttribute("removeDataURL", removeDataURL, false);
    }
    /**
     * dataURL for fetch type operations
     *
     *
     * @return String
     *
     */
    public String getRemoveDataURL()  {
        return getAttributeAsString("removeDataURL");
    }

    /**
    * Should  operation meta data be included when assmebling parameters to send  to the server? If true, meta data parameters will be prefixed with the  {@link com.smartgwt.client.data.RestDataSource#getMetaDataPrefix metaDataPrefix}.<br> Applies to operations where OperationBinding.dataProtocol is set to  <code>"getParams"</code> or <code>"postParams"</code> only.
    *
    * @param sendMetaData sendMetaData Default value is true
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setSendMetaData(Boolean sendMetaData)  throws IllegalStateException {
        setAttribute("sendMetaData", sendMetaData, false);
    }
    /**
     * Should  operation meta data be included when assmebling parameters to send  to the server? If true, meta data parameters will be prefixed with the  {@link com.smartgwt.client.data.RestDataSource#getMetaDataPrefix metaDataPrefix}.<br> Applies to operations where OperationBinding.dataProtocol is set to  <code>"getParams"</code> or <code>"postParams"</code> only.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSendMetaData()  {
        return getAttributeAsBoolean("sendMetaData");
    }

    /**
    * I {@link com.smartgwt.client.data.RestDataSource#getSendMetaData sendMetaData} is true, this attribute is used to specify the prefix to apply to 'meta data' properties when assembling parameters to send to the  server.  Applies to operations where OperationBinding.dataProtocol is set to  <code>"getParams"</code> or <code>"postParams"</code> only.
    *
    * @param metaDataPrefix metaDataPrefix Default value is "_"
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setMetaDataPrefix(String metaDataPrefix)  throws IllegalStateException {
        setAttribute("metaDataPrefix", metaDataPrefix, false);
    }
    /**
     * I {@link com.smartgwt.client.data.RestDataSource#getSendMetaData sendMetaData} is true, this attribute is used to specify the prefix to apply to 'meta data' properties when assembling parameters to send to the  server.  Applies to operations where OperationBinding.dataProtocol is set to  <code>"getParams"</code> or <code>"postParams"</code> only.
     *
     *
     * @return String
     *
     */
    public String getMetaDataPrefix()  {
        return getAttributeAsString("metaDataPrefix");
    }

    // ********************* Methods ***********************



    // ********************* Static Methods ***********************

}





