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
    * A DataSource is data-provider-independant description of a set of objects that will be loaded, edited and saved within the user interface of your application. <P> Each DataSource consists of a list of {@link com.smartgwt.client.data.DataSource#getFields fields} that make up a DataSource <code>record</code>, along with {@link com.smartgwt.client.data.DataSourceField#getType type},  {@link com.smartgwt.client.data.DataSourceField#getValidators validators},  {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} to other DataSources, and other metadata. <P> The abstract object description provided by a DataSource is easily mapped to a variety of backend object models and storage schemes.  The following table shows analogous terminology across systems. <table border=1 class="normal"> <tr>   <td>Isomorphic SmartClient</td>   <td>Relational Database</td>   <td>Enterprise Java Beans (EJB)</td>   <td>Entity/Relationship Modelling</td>   <td>OO/UML</td>   <td>XML Schema/WSDL</td>   <td>LDAP</td> </tr><tr>   <td>DataSource</td>   <td>Table</td>   <td>EJB class</td>   <td>Entity</td>   <td>Class</td>   <td>Element Schema (ComplexType)</td>   <td>Objectclass</td> </tr><tr>   <td>Record</td>   <td>Row</td>   <td>EJB instance</td>   <td>Entity instance</td>   <td>Class instance/Object</td>   <td>Element instance (ComplexType)</td>   <td>Entry</td> </tr><tr>   <td>Field</td>   <td>Column</td>   <td>Property</td>   <td>Attribute</td>   <td>Property/Attribute</td>   <td>Attribute or Element (SimpleType)</td>   <td>Attribute</td> </tr></table> <P> DataSources can be declared in either JavaScript or XML format, and can also be imported from existing metadata formats, including XML Schema. <P> <i>Data Binding</i> is the process by which ${isc.DocUtils.linkForRef('interface:DataBoundComponent','Data Binding-capable UI components')} can automatically configure themselves for viewing, editing and saving data described by DataSources.  DataBinding is covered in the ${isc.DocUtils.linkForDocNode('QuickStartGuide', 'QuickStart Guide')}, Chapter 6, <i>Data Binding</i>. <P> Data Integration is the process by which a DataSource can be connected to server systems such as SQL DataBases, Java Object models, WSDL web services and other data providers.  Data Integration comes in two variants: client-side and server-side.  Server-side integration uses the SmartClient Java-based server to connect to data represented by Java Objects or JDBC-accessible databases.  Client-side integration connects SmartClient DataSources to XML, JSON or other formats accessible via HTTP. <P> DataSources have a concept of 4 core operations ("fetch", "add", "update" and "remove") that can be performed on the set of objects represented by a DataSource.  Once a DataSource has been integrated with your data store, databinding-capable  UI components can leverage the 4 core DataSource operations to provide many complete user interactions without the need to configure how each individual component loads and saves data. <P> These interactions include {@link com.smartgwt.client.widgets.grid.ListGrid}, {@link com.smartgwt.client.widgets.tree.TreeGrid},  {@link com.smartgwt.client.widgets.viewer.DetailViewer}, {@link com.smartgwt.client.widgets.form.DynamicForm}-based  {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord} and {@link com.smartgwt.client.widgets.form.DynamicForm#saveData}, grid-based {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} and {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saveByCell}, and custom interactions provided by ${isc.DocUtils.linkForExampleId('patternReuse')} custom databinding-capable components.

    */

public class DataSource extends BaseClass  implements com.smartgwt.client.data.events.HasHandleErrorHandlers {

    public static DataSource getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DataSource) obj;
        } else {
            return new DataSource(jsObj);
        }
    }


    public DataSource(){
        
    }

    public DataSource(JavaScriptObject jsObj){
        super(jsObj);
    }

    public DataSource(String dataURL) {
        setDataURL(dataURL);
        
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        return $wnd.isc.DataSource.create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * Whether to make this DataSource available as a global variable for convenience.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param addGlobalId addGlobalId Default value is true
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setAddGlobalId(Boolean addGlobalId)  throws IllegalStateException {
        setAttribute("addGlobalId", addGlobalId, false);
    }
    /**
     * Whether to make this DataSource available as a global variable for convenience.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAddGlobalId()  {
        return getAttributeAsBoolean("addGlobalId");
    }
             
    /**
    * Indicates the format to be used for HTTP requests and responses when fulfilling DSRequests (eg {@link com.smartgwt.client.data.DataSource#fetchData} is called).
    *
    * @param dataFormat dataFormat Default value is "iscServer"
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setDataFormat(DSDataFormat dataFormat)  throws IllegalStateException {
        setAttribute("dataFormat", dataFormat.getValue(), false);
    }
    /**
     * Indicates the format to be used for HTTP requests and responses when fulfilling DSRequests (eg {@link com.smartgwt.client.data.DataSource#fetchData} is called).
     *
     *
     * @return DSDataFormat
     *
     */
    public DSDataFormat getDataFormat()  {
        return (DSDataFormat) EnumUtil.getEnum(DSDataFormat.values(), getAttribute("dataFormat"));
    }

    /**
    * Applies only to dataFormat: "json".  Specifies the name of the query parameter that tells your JSON service what function to call as part of the response.
    *
    * @param callbackParam callbackParam Default value is "callback"
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setCallbackParam(String callbackParam)  throws IllegalStateException {
        setAttribute("callbackParam", callbackParam, false);
    }
    /**
     * Applies only to dataFormat: "json".  Specifies the name of the query parameter that tells your JSON service what function to call as part of the response.
     *
     *
     * @return String
     *
     */
    public String getCallbackParam()  {
        return getAttributeAsString("callbackParam");
    }
             
    /**
    * Transport to use for all operations on this DataSource. Defaults to {@link com.smartgwt.client.rpc.RPCManager#defaultTransport}.  This would typically only be set to enable "scriptInclude" transport for contacting {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} web services hosted on servers other than the origin server. <p> When using the "scriptInclude" transport, be sure to set {@link com.smartgwt.client.data.DataSource#getCallbackParam callbackParam} or {@link com.smartgwt.client.data.OperationBinding#getCallbackParam callbackParam} to match the name of the query parameter name expected by your JSON service provider.
    *
    * @param dataTransport dataTransport Default value is RPCManager.defaultTransport
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setDataTransport(RPCTransport dataTransport)  throws IllegalStateException {
        setAttribute("dataTransport", dataTransport.getValue(), false);
    }
    /**
     * Transport to use for all operations on this DataSource. Defaults to {@link com.smartgwt.client.rpc.RPCManager#defaultTransport}.  This would typically only be set to enable "scriptInclude" transport for contacting {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} web services hosted on servers other than the origin server. <p> When using the "scriptInclude" transport, be sure to set {@link com.smartgwt.client.data.DataSource#getCallbackParam callbackParam} or {@link com.smartgwt.client.data.OperationBinding#getCallbackParam callbackParam} to match the name of the query parameter name expected by your JSON service provider.
     *
     *
     * @return RPCTransport
     *
     */
    public RPCTransport getDataTransport()  {
        return (RPCTransport) EnumUtil.getEnum(RPCTransport.values(), getAttribute("dataTransport"));
    }

    /**
    * If set, the DataSource will ensure that it never uses a cached HTTP response, even if the server marks the response as cacheable. <P> Note that this does not disable caching at higher levels in the framework, for example, the caching performed by {@link com.smartgwt.client.data.ResultSet}.
    *
    * @param preventHTTPCaching preventHTTPCaching Default value is true
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setPreventHTTPCaching(Boolean preventHTTPCaching)  throws IllegalStateException {
        setAttribute("preventHTTPCaching", preventHTTPCaching, false);
    }
    /**
     * If set, the DataSource will ensure that it never uses a cached HTTP response, even if the server marks the response as cacheable. <P> Note that this does not disable caching at higher levels in the framework, for example, the caching performed by {@link com.smartgwt.client.data.ResultSet}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getPreventHTTPCaching()  {
        return getAttributeAsBoolean("preventHTTPCaching");
    }
             
    /**
    * For a DataSource stored in .xml format on the ISC server, indicates what server-side connector to use to execute requests, that is, what happens if you call dsRequest.execute() in server code.
    *
    * @param serverType serverType Default value is "generic"
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setServerType(DSServerType serverType)  throws IllegalStateException {
        setAttribute("serverType", serverType.getValue(), false);
    }
    /**
     * For a DataSource stored in .xml format on the ISC server, indicates what server-side connector to use to execute requests, that is, what happens if you call dsRequest.execute() in server code.
     *
     *
     * @return DSServerType
     *
     */
    public DSServerType getServerType()  {
        return (DSServerType) EnumUtil.getEnum(DSServerType.values(), getAttribute("serverType"));
    }

    /**
    * For DataSources using the SmartClient SQL engine for persistence, what database table name to use.  The default is to use the DataSource ID as the table name.
    *
    * @param tableName tableName Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setTableName(String tableName)  throws IllegalStateException {
        setAttribute("tableName", tableName, false);
    }
    /**
     * For DataSources using the SmartClient SQL engine for persistence, what database table name to use.  The default is to use the DataSource ID as the table name.
     *
     *
     * @return String
     *
     */
    public String getTableName()  {
        return getAttributeAsString("tableName");
    }

    /**
    * For DataSources using the SmartClient SQL engine for persistence, which database configuration to use.  Database configurations can be created using the "Databases" tab in the Developer Console.  If unset, the default database configuration is used (which also settable using the "Databases" tab).
    *
    * @param dbName dbName Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setDbName(String dbName)  throws IllegalStateException {
        setAttribute("dbName", dbName, false);
    }
    /**
     * For DataSources using the SmartClient SQL engine for persistence, which database configuration to use.  Database configurations can be created using the "Databases" tab in the Developer Console.  If unset, the default database configuration is used (which also settable using the "Databases" tab).
     *
     *
     * @return String
     *
     */
    public String getDbName()  {
        return getAttributeAsString("dbName");
    }

    /**
    * Allows you to specify an arbitrary prefix string to apply to all json format responses  sent from the server to this application.<br> The inclusion of such a prefix ensures your code is not directly executable outside of your application, as a preventitive measure against <a href='http://www.google.com/search?q=javascript+hijacking' onclick="window.open('http://www.google.com/search?q=javascript+hijacking');return false;">javascript hijacking</a>. <br> Only applies to responses formatted as json objects. Does not apply to responses returned via scriptInclude type transport.<br> Note: If the prefix / suffix served by your backend is not a constant, you can use  {@link com.smartgwt.client.data.OperationBinding#getDataFormat dataFormat} instead and explicitly parse the prefix out as part of {@link com.smartgwt.client.data.DataSource#transformResponse}.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param jsonPrefix jsonPrefix Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setJsonPrefix(String jsonPrefix)  throws IllegalStateException {
        setAttribute("jsonPrefix", jsonPrefix, false);
    }
    /**
     * Allows you to specify an arbitrary prefix string to apply to all json format responses  sent from the server to this application.<br> The inclusion of such a prefix ensures your code is not directly executable outside of your application, as a preventitive measure against <a href='http://www.google.com/search?q=javascript+hijacking' onclick="window.open('http://www.google.com/search?q=javascript+hijacking');return false;">javascript hijacking</a>. <br> Only applies to responses formatted as json objects. Does not apply to responses returned via scriptInclude type transport.<br> Note: If the prefix / suffix served by your backend is not a constant, you can use  {@link com.smartgwt.client.data.OperationBinding#getDataFormat dataFormat} instead and explicitly parse the prefix out as part of {@link com.smartgwt.client.data.DataSource#transformResponse}.
     *
     *
     * @return String
     *
     */
    public String getJsonPrefix()  {
        return getAttributeAsString("jsonPrefix");
    }

    /**
    * Allows you to specify an arbitrary suffix string to apply to all json format responses  sent from the server to this application.<br> The inclusion of such a suffix ensures your code is not directly executable outside of your application, as a preventitive measure against <a href='http://www.google.com/search?q=javascript+hijacking' onclick="window.open('http://www.google.com/search?q=javascript+hijacking');return false;">javascript hijacking</a>. <br> Only applies to responses formatted as json objects. Does not apply to responses returned via scriptInclude type transport.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param jsonSuffix jsonSuffix Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setJsonSuffix(String jsonSuffix)  throws IllegalStateException {
        setAttribute("jsonSuffix", jsonSuffix, false);
    }
    /**
     * Allows you to specify an arbitrary suffix string to apply to all json format responses  sent from the server to this application.<br> The inclusion of such a suffix ensures your code is not directly executable outside of your application, as a preventitive measure against <a href='http://www.google.com/search?q=javascript+hijacking' onclick="window.open('http://www.google.com/search?q=javascript+hijacking');return false;">javascript hijacking</a>. <br> Only applies to responses formatted as json objects. Does not apply to responses returned via scriptInclude type transport.
     *
     *
     * @return String
     *
     */
    public String getJsonSuffix()  {
        return getAttributeAsString("jsonSuffix");
    }

    /**
    * Like {@link com.smartgwt.client..DataBoundComponent#getUseFlatFields useFlatFields}, but applies to all DataBound components that bind to this DataSource.
    *
    * @param useFlatFields useFlatFields Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setUseFlatFields(Boolean useFlatFields)  throws IllegalStateException {
        setAttribute("useFlatFields", useFlatFields, false);
    }
    /**
     * Like {@link com.smartgwt.client..DataBoundComponent#getUseFlatFields useFlatFields}, but applies to all DataBound components that bind to this DataSource.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseFlatFields()  {
        return getAttributeAsBoolean("useFlatFields");
    }

    /**
    * For a DataSource that inherits {@link com.smartgwt.client.data.DataSource#getFields fields} from another DataSource  (via {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}), indicates that only the fields listed in this DataSource should be shown.  All other inherited parent fields will be marked "hidden:true".
    *
    * @param showLocalFieldsOnly showLocalFieldsOnly Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setShowLocalFieldsOnly(Boolean showLocalFieldsOnly)  throws IllegalStateException {
        setAttribute("showLocalFieldsOnly", showLocalFieldsOnly, false);
    }
    /**
     * For a DataSource that inherits {@link com.smartgwt.client.data.DataSource#getFields fields} from another DataSource  (via {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}), indicates that only the fields listed in this DataSource should be shown.  All other inherited parent fields will be marked "hidden:true".
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowLocalFieldsOnly()  {
        return getAttributeAsBoolean("showLocalFieldsOnly");
    }

    /**
    * For a DataSource that inherits {@link com.smartgwt.client.data.DataSource#getFields fields} from another DataSource  (via {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}), indicates that the parent's field order should be used instead of the order of the fields as declared in this DataSource.  New fields, if any, are placed at the end.
    *
    * @param useParentFieldOrder useParentFieldOrder Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setUseParentFieldOrder(Boolean useParentFieldOrder)  throws IllegalStateException {
        setAttribute("useParentFieldOrder", useParentFieldOrder, false);
    }
    /**
     * For a DataSource that inherits {@link com.smartgwt.client.data.DataSource#getFields fields} from another DataSource  (via {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}), indicates that the parent's field order should be used instead of the order of the fields as declared in this DataSource.  New fields, if any, are placed at the end.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseParentFieldOrder()  {
        return getAttributeAsBoolean("useParentFieldOrder");
    }

    /**
    * Indicates that for server responses, for any data being interpreted as DataSource records,  only data that corresponds to declared fields should be retained; any extra fields should be discarded. <P> For {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} data, this means extra properties in selected objects are dropped. <P> By default, for DMI DSResponses, DSResponse.data is filtered on the server to just the set of fields defined on the DataSource.  This type of filtering can also be enabled for non-DMI DSResponses (see the overview in {@link com.smartgwt.client..DMI}).  Setting this property to <code>false</code> disables this filtering for this DataSource only.  This setting overrides the configuration in <code>server.properties</code>.  This setting can be overridden by {@link com.smartgwt.client..ServerObject#getDropExtraFields dropExtraFields}.
    *
    * @param dropExtraFields dropExtraFields Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setDropExtraFields(Boolean dropExtraFields)  throws IllegalStateException {
        setAttribute("dropExtraFields", dropExtraFields, false);
    }
    /**
     * Indicates that for server responses, for any data being interpreted as DataSource records,  only data that corresponds to declared fields should be retained; any extra fields should be discarded. <P> For {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} data, this means extra properties in selected objects are dropped. <P> By default, for DMI DSResponses, DSResponse.data is filtered on the server to just the set of fields defined on the DataSource.  This type of filtering can also be enabled for non-DMI DSResponses (see the overview in {@link com.smartgwt.client..DMI}).  Setting this property to <code>false</code> disables this filtering for this DataSource only.  This setting overrides the configuration in <code>server.properties</code>.  This setting can be overridden by {@link com.smartgwt.client..ServerObject#getDropExtraFields dropExtraFields}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getDropExtraFields()  {
        return getAttributeAsBoolean("dropExtraFields");
    }

    /**
    * Analagous to {@link com.smartgwt.client.data.DataSource#getDropExtraFields dropExtraFields}, for data sent to the server.  Setting this attribute to false ensures that for any records in the data object, only fields that correspond to declared dataSource fields will be present on the dsRequest data object passed to {@link com.smartgwt.client.data.DataSource#transformRequest} and ultimately sent to the server.
    *
    * @param sendExtraFields sendExtraFields Default value is true
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setSendExtraFields(Boolean sendExtraFields)  throws IllegalStateException {
        setAttribute("sendExtraFields", sendExtraFields, false);
    }
    /**
     * Analagous to {@link com.smartgwt.client.data.DataSource#getDropExtraFields dropExtraFields}, for data sent to the server.  Setting this attribute to false ensures that for any records in the data object, only fields that correspond to declared dataSource fields will be present on the dsRequest data object passed to {@link com.smartgwt.client.data.DataSource#transformRequest} and ultimately sent to the server.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSendExtraFields()  {
        return getAttributeAsBoolean("sendExtraFields");
    }

    /**
    * For a DataSource with serverType: "sql" or serverType: "hibernate", automatically derive the dataSource's schema (field definitions) from from the SQL table specified in  {@link com.smartgwt.client.data.DataSource#getTableName tableName}.  This causes SmartClient to create a "super" DataSource, which this dataSource then automatically {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}.  This allows you to  override auto-derived schema as required. <p> This property is only applicable if you are using the SmartClient server.
    *
    * @param autoDeriveSchema autoDeriveSchema Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setAutoDeriveSchema(Boolean autoDeriveSchema)  throws IllegalStateException {
        setAttribute("autoDeriveSchema", autoDeriveSchema, false);
    }
    /**
     * For a DataSource with serverType: "sql" or serverType: "hibernate", automatically derive the dataSource's schema (field definitions) from from the SQL table specified in  {@link com.smartgwt.client.data.DataSource#getTableName tableName}.  This causes SmartClient to create a "super" DataSource, which this dataSource then automatically {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}.  This allows you to  override auto-derived schema as required. <p> This property is only applicable if you are using the SmartClient server.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoDeriveSchema()  {
        return getAttributeAsBoolean("autoDeriveSchema");
    }

    /**
    * For an XML DataSource, URN of the WebService to use to invoke operations.  This URN comes from the "targetNamespace" attribute of the &lt;wsdl:definitions&gt; element in a WSDL (Web Service Description Language) document, and serves as the unique identifier of the service. <P> Having loaded a WebService using {@link com.smartgwt.client.util.XMLTools#loadWSDL}, setting <code>serviceNamespace</code> combined with specifying  {@link com.smartgwt.client.data.OperationBinding} that set {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation} will cause a DataSource to invoke web service operations to fulfill DataSource requests ({@link com.smartgwt.client.data.DSRequest}). <P> Setting <code>serviceNamespace</code> also defaults {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} to the service's location, {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} to "xml" and {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol} to "soap".
    *
    * @param serviceNamespace serviceNamespace Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setServiceNamespace(String serviceNamespace)  throws IllegalStateException {
        setAttribute("serviceNamespace", serviceNamespace, false);
    }
    /**
     * For an XML DataSource, URN of the WebService to use to invoke operations.  This URN comes from the "targetNamespace" attribute of the &lt;wsdl:definitions&gt; element in a WSDL (Web Service Description Language) document, and serves as the unique identifier of the service. <P> Having loaded a WebService using {@link com.smartgwt.client.util.XMLTools#loadWSDL}, setting <code>serviceNamespace</code> combined with specifying  {@link com.smartgwt.client.data.OperationBinding} that set {@link com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation} will cause a DataSource to invoke web service operations to fulfill DataSource requests ({@link com.smartgwt.client.data.DSRequest}). <P> Setting <code>serviceNamespace</code> also defaults {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} to the service's location, {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} to "xml" and {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol} to "soap".
     *
     *
     * @return String
     *
     */
    public String getServiceNamespace()  {
        return getAttributeAsString("serviceNamespace");
    }

    /**
     * For a DataSource derived from WSDL or XML schema, the XML namespace this schema belongs to.  This is a read-only attribute automatically present on DataSources returned from {@link com.smartgwt.client..SchemaSet#getSchema} and {@link com.smartgwt.client..WebService#getSchema}.
     *
     * <b>Note :</b> This method should be called only after the underlying component has been created.
     *
     * @return String
     *
     * @throws IllegalStateException if underlying component has not yet been created.
     */
    public String getSchemaNamespace() throws IllegalStateException {
        errorIfNotCreated("schemaNamespace");
        return getAttributeAsString("schemaNamespace");
    }

    /**
    * See {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}.  <code>recordXPath</code> can be specified directly on the DataSource for a simple read-only DataSource only capable of "fetch" operations.
    *
    * @param recordXPath recordXPath Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setRecordXPath(String recordXPath)  throws IllegalStateException {
        setAttribute("recordXPath", recordXPath, false);
    }
    /**
     * See {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}.  <code>recordXPath</code> can be specified directly on the DataSource for a simple read-only DataSource only capable of "fetch" operations.
     *
     *
     * @return String
     *
     */
    public String getRecordXPath()  {
        return getAttributeAsString("recordXPath");
    }

    /**
    * Default URL to contact to fulfill all DSRequests.  Can also be set on a per-operationType basis via {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL}. <P> NOTE: Best practice is to use the same <code>dataURL</code> for all DataSources which fulfill DSRequests via the server-side RPCManager API.  Otherwise, cross-DataSource {@link com.smartgwt.client.rpc.RPCManager#startQueue} will not be possible.
    *
    * @param dataURL dataURL Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setDataURL(String dataURL)  throws IllegalStateException {
        setAttribute("dataURL", dataURL, false);
    }
    /**
     * Default URL to contact to fulfill all DSRequests.  Can also be set on a per-operationType basis via {@link com.smartgwt.client.data.OperationBinding#getDataURL dataURL}. <P> NOTE: Best practice is to use the same <code>dataURL</code> for all DataSources which fulfill DSRequests via the server-side RPCManager API.  Otherwise, cross-DataSource {@link com.smartgwt.client.rpc.RPCManager#startQueue} will not be possible.
     *
     *
     * @return String
     *
     */
    public String getDataURL()  {
        return getAttributeAsString("dataURL");
    }

    /**
    * Tag name to use when serializing to XML.  If unspecified, the <code>dataSource.ID</code> will be used.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param tagName tagName Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setTagName(String tagName)  throws IllegalStateException {
        setAttribute("tagName", tagName, false);
    }
    /**
     * Tag name to use when serializing to XML.  If unspecified, the <code>dataSource.ID</code> will be used.
     *
     *
     * @return String
     *
     */
    public String getTagName()  {
        return getAttributeAsString("tagName");
    }

    /**
    * Whether to act as a "client-only" DataSource, which has no permanent storage and never contacts the server, instead using a set of test data to respond to requests in the same manner as a server-based DataSource might. <P> See this discussion for ways to populate a client-only DataSource with test data.
    *
    * @param clientOnly clientOnly Default value is false
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setClientOnly(Boolean clientOnly)  throws IllegalStateException {
        setAttribute("clientOnly", clientOnly, false);
    }
    /**
     * Whether to act as a "client-only" DataSource, which has no permanent storage and never contacts the server, instead using a set of test data to respond to requests in the same manner as a server-based DataSource might. <P> See this discussion for ways to populate a client-only DataSource with test data.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getClientOnly()  {
        return getAttributeAsBoolean("clientOnly");
    }
             
    /**
    * Decides under what conditions the {@link com.smartgwt.client.data.ResultSet} cache should be dropped when the {@link com.smartgwt.client.data.ResultSet#getCriteria criteria} changes
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param criteriaPolicy criteriaPolicy Default value is "dropOnShortening"
    */
    public void setCriteriaPolicy(CriteriaPolicy criteriaPolicy) {
        setAttribute("criteriaPolicy", criteriaPolicy.getValue(), true);
    }
    /**
     * Decides under what conditions the {@link com.smartgwt.client.data.ResultSet} cache should be dropped when the {@link com.smartgwt.client.data.ResultSet#getCriteria criteria} changes
     *
     *
     * @return CriteriaPolicy
     *
     */
    public CriteriaPolicy getCriteriaPolicy()  {
        return (CriteriaPolicy) EnumUtil.getEnum(CriteriaPolicy.values(), getAttribute("criteriaPolicy"));
    }

    /**
    * Whether to attempt validation on the client at all for this DataSource.  If unset (the default), client-side validation is enabled. <p> Disabling client-side validation entirely is a good way to test server-side validation.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param useLocalValidators useLocalValidators Default value is null
    */
    public void setUseLocalValidators(Boolean useLocalValidators) {
        setAttribute("useLocalValidators", useLocalValidators, true);
    }
    /**
     * Whether to attempt validation on the client at all for this DataSource.  If unset (the default), client-side validation is enabled. <p> Disabling client-side validation entirely is a good way to test server-side validation.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getUseLocalValidators()  {
        return getAttributeAsBoolean("useLocalValidators");
    }

    /**
    * Whether RPCRequests sent by this DataSource should enable  {@link com.smartgwt.client.rpc.RPCRequest#getShowPrompt showPrompt} if it's unset.
    *
    * @param showPrompt showPrompt Default value is true
    */
    public void setShowPrompt(Boolean showPrompt) {
        setAttribute("showPrompt", showPrompt, true);
    }
    /**
     * Whether RPCRequests sent by this DataSource should enable  {@link com.smartgwt.client.rpc.RPCRequest#getShowPrompt showPrompt} if it's unset.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowPrompt()  {
        return getAttributeAsBoolean("showPrompt");
    }
             
    /**
    * Sets the strategy this DataSource uses to translate Java enumerated types (objects of type enum) to and from Javascript.  This property is only applicable if you are using the SmartClient server
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param enumTranslateStrategy enumTranslateStrategy Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setEnumTranslateStrategy(EnumTranslateStrategy enumTranslateStrategy)  throws IllegalStateException {
        setAttribute("enumTranslateStrategy", enumTranslateStrategy.getValue(), false);
    }

    /**
    * The name of the property this DataSource uses for constant name when translating Java enumerated types to and from Javascript, if the ${isc.DocUtils.linkForRef('type:EnumTranslateStrategy')} is set to "bean".  Defaults to "_constant" if not set. <p>  This property is only applicable if you are using the SmartClient server
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param enumConstantProperty enumConstantProperty Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setEnumConstantProperty(String enumConstantProperty)  throws IllegalStateException {
        setAttribute("enumConstantProperty", enumConstantProperty, false);
    }

    /**
    * The name of the property this DataSource uses for ordinal number when translating Java enumerated types to and from Javascript, if the ${isc.DocUtils.linkForRef('type:EnumTranslateStrategy')} is set to "bean".  Defaults to "_ordinal" if not set. <p>  This property is only applicable if you are using the SmartClient server
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param enumOrdinalProperty enumOrdinalProperty Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setEnumOrdinalProperty(String enumOrdinalProperty)  throws IllegalStateException {
        setAttribute("enumOrdinalProperty", enumOrdinalProperty, false);
    }

    /**
    * If set, titles are automatically derived from {@link com.smartgwt.client.data.DataSourceField#getName name} for any  field that does not have a {@link com.smartgwt.client.data.DataSourceField#getTitle title} and is not marked {@link com.smartgwt.client.data.DataSourceField#getHidden hidden}:true, by calling the method {@link com.smartgwt.client.data.DataSource#getAutoTitle}.
    *
    * @param autoDeriveTitles autoDeriveTitles Default value is true
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setAutoDeriveTitles(Boolean autoDeriveTitles)  throws IllegalStateException {
        setAttribute("autoDeriveTitles", autoDeriveTitles, false);
    }
    /**
     * If set, titles are automatically derived from {@link com.smartgwt.client.data.DataSourceField#getName name} for any  field that does not have a {@link com.smartgwt.client.data.DataSourceField#getTitle title} and is not marked {@link com.smartgwt.client.data.DataSourceField#getHidden hidden}:true, by calling the method {@link com.smartgwt.client.data.DataSource#getAutoTitle}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoDeriveTitles()  {
        return getAttributeAsBoolean("autoDeriveTitles");
    }

    /**
    * User-visible name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply Item". <P> Defaults to <code>dataSource.ID</code>.
    *
    * @param title title Default value is dataSource.ID
    */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }
    /**
     * User-visible name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply Item". <P> Defaults to <code>dataSource.ID</code>.
     *
     *
     * @return String
     *
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
    * User-visible plural name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply Items". <P> Defaults to (<code>dataSource.title</code> or <code>dataSource.ID</code>) + "s".
    *
    * @param pluralTitle pluralTitle Default value is dataSource.ID
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setPluralTitle(String pluralTitle)  throws IllegalStateException {
        setAttribute("pluralTitle", pluralTitle, false);
    }
    /**
     * User-visible plural name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply Items". <P> Defaults to (<code>dataSource.title</code> or <code>dataSource.ID</code>) + "s".
     *
     *
     * @return String
     *
     */
    public String getPluralTitle()  {
        return getAttributeAsString("pluralTitle");
    }

    /**
    * Best field to use for a user-visible title for an individual record from this dataSource. <p> For example, for a DataSource of employees, a "full name" field would probably most clearly labels an employee record. <p> If not explicitly set, titleField looks for fields named "title", "label", "name", and "id" in that order.  If a field exists with one of those names, it becomes the titleField.  If not, then the first field is designated as the titleField.
    *
    * @param titleField titleField Default value is see below
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setTitleField(String titleField)  throws IllegalStateException {
        setAttribute("titleField", titleField, false);
    }
    /**
     * Best field to use for a user-visible title for an individual record from this dataSource. <p> For example, for a DataSource of employees, a "full name" field would probably most clearly labels an employee record. <p> If not explicitly set, titleField looks for fields named "title", "label", "name", and "id" in that order.  If a field exists with one of those names, it becomes the titleField.  If not, then the first field is designated as the titleField.
     *
     *
     * @return String
     *
     */
    public String getTitleField()  {
        return getAttributeAsString("titleField");
    }

    /**
    * Designates a field of ${isc.DocUtils.linkForRef('type:FieldType','type')}:"image" as the field to use when rendering a record as an image, for example, in a {@link com.smartgwt.client.widgets.tile.TileGrid}. <p> For example, for a DataSource of employees, a "photo" field of type "image" should be designated as the iconField. <p> If not explicitly set, iconField looks for fields named "picture", "thumbnail", "icon", "image" and "img", in that order, and will use any of these fields as the iconField if it exists and has type "image".  <P> To avoid any field being used as the iconField, set iconField to <code>null</code>.
    *
    * @param iconField iconField Default value is see below
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setIconField(String iconField)  throws IllegalStateException {
        setAttribute("iconField", iconField, false);
    }
    /**
     * Designates a field of ${isc.DocUtils.linkForRef('type:FieldType','type')}:"image" as the field to use when rendering a record as an image, for example, in a {@link com.smartgwt.client.widgets.tile.TileGrid}. <p> For example, for a DataSource of employees, a "photo" field of type "image" should be designated as the iconField. <p> If not explicitly set, iconField looks for fields named "picture", "thumbnail", "icon", "image" and "img", in that order, and will use any of these fields as the iconField if it exists and has type "image".  <P> To avoid any field being used as the iconField, set iconField to <code>null</code>.
     *
     *
     * @return String
     *
     */
    public String getIconField()  {
        return getAttributeAsString("iconField");
    }

    /**
    * fieldName for a field in the dataSource expected to contain an explicit array of child nodes. Enables loading a databound tree as a hierachical data structure, rather than a flat list of nodes linked by foreignKey.<br> Note this is an alternative to setting {@link com.smartgwt.client.data.DataSourceField#getChildrenProperty childrenProperty} directly on the childrenField object.<P> By default the children field will be assumed to be {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple}, for XML databinding. This implies that child data should be delivered in the format: <pre>      &lt;childrenFieldName&gt;          &lt;item name="firstChild" ...&gt;          &lt;item name="secondChild" ...&gt;      &lt;/childrenFieldName&gt; </pre> However data may also be delivered as a direct list of <code>childrenFieldName</code>  elements: <pre>      &lt;childrenFieldName name="firstChild" ...&gt;      &lt;childrenFieldName name="secondChild" ...&gt; </pre> If you want to return your data in this format, you will need to explicitly set  <code>multiple</code> to false in the appropriate dataSource field definition.
    *
    * @param childrenField childrenField Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setChildrenField(String childrenField)  throws IllegalStateException {
        setAttribute("childrenField", childrenField, false);
    }
    /**
     * fieldName for a field in the dataSource expected to contain an explicit array of child nodes. Enables loading a databound tree as a hierachical data structure, rather than a flat list of nodes linked by foreignKey.<br> Note this is an alternative to setting {@link com.smartgwt.client.data.DataSourceField#getChildrenProperty childrenProperty} directly on the childrenField object.<P> By default the children field will be assumed to be {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple}, for XML databinding. This implies that child data should be delivered in the format: <pre>      &lt;childrenFieldName&gt;          &lt;item name="firstChild" ...&gt;          &lt;item name="secondChild" ...&gt;      &lt;/childrenFieldName&gt; </pre> However data may also be delivered as a direct list of <code>childrenFieldName</code>  elements: <pre>      &lt;childrenFieldName name="firstChild" ...&gt;      &lt;childrenFieldName name="secondChild" ...&gt; </pre> If you want to return your data in this format, you will need to explicitly set  <code>multiple</code> to false in the appropriate dataSource field definition.
     *
     *
     * @return String
     *
     */
    public String getChildrenField()  {
        return getAttributeAsString("childrenField");
    }

    /**
    * Specifies the fully-qualified name of the DataSource subclass that should be instantiated server-side for this dataSource. This property allows you to write and use custom DataSource  subclasses on the server. <p> One reason you might wish to do this would be to override the validate() method to provide  some arbitrary custom validation (such as complex database lookups, validation embedded in  legacy applications, etc).  It is also possible - though obviously a more substantial task - to override the execute() method in your custom DataSource.  This is one way of creating  a completely customized DataSource implementation. <p> <b>Note:</b> If you use this property, you are responsible for making sure that it refers to a valid server-side class that extends <code>com.isomorphic.datasource.DataSource</code>. If your implementation relies on methods or state only present in certain specialized  subclasses of DataSource (for example, you want the normal behavior and features of a  HibernateDataSource, but with a specialized validate() method), then you shoud extend the  subclass rather than the base class.
    *
    * @param serverConstructor serverConstructor Default value is null
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setServerConstructor(String serverConstructor)  throws IllegalStateException {
        setAttribute("serverConstructor", serverConstructor, false);
    }
    /**
     * Specifies the fully-qualified name of the DataSource subclass that should be instantiated server-side for this dataSource. This property allows you to write and use custom DataSource  subclasses on the server. <p> One reason you might wish to do this would be to override the validate() method to provide  some arbitrary custom validation (such as complex database lookups, validation embedded in  legacy applications, etc).  It is also possible - though obviously a more substantial task - to override the execute() method in your custom DataSource.  This is one way of creating  a completely customized DataSource implementation. <p> <b>Note:</b> If you use this property, you are responsible for making sure that it refers to a valid server-side class that extends <code>com.isomorphic.datasource.DataSource</code>. If your implementation relies on methods or state only present in certain specialized  subclasses of DataSource (for example, you want the normal behavior and features of a  HibernateDataSource, but with a specialized validate() method), then you shoud extend the  subclass rather than the base class.
     *
     *
     * @return String
     *
     */
    public String getServerConstructor()  {
        return getAttributeAsString("serverConstructor");
    }

    /**
    * For dataSources of {@link com.smartgwt.client.data.DataSource#getServerType serverType} "sql", determines whether we qualify column names with table names in any SQL we generate.  This property can be overridden on specific operationBindings.
    *
    * @param qualifyColumnNames qualifyColumnNames Default value is true
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setQualifyColumnNames(Boolean qualifyColumnNames)  throws IllegalStateException {
        setAttribute("qualifyColumnNames", qualifyColumnNames, false);
    }
    /**
     * For dataSources of {@link com.smartgwt.client.data.DataSource#getServerType serverType} "sql", determines whether we qualify column names with table names in any SQL we generate.  This property can be overridden on specific operationBindings.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getQualifyColumnNames()  {
        return getAttributeAsBoolean("qualifyColumnNames");
    }

    /**
    * [A] If set to true, both client and server-side advanced filtering used by SmartClient will follow SQL99 behavior for dealing with NULL values, which is often counter-intuitive to users. Specifically, when a field has NULL value, all of the following expression are false: <pre>    field == "someValue"  (normally false)    field != "someValue"  (normally true)    not (field == "someValue")   (normally true)    not (field != "someValue")   (normally false) </pre>
    *
    * @param strictSQLFiltering strictSQLFiltering Default value is false
    * @throws IllegalStateException this property cannot be changed after the underlying component has been created
    */
    public void setStrictSQLFiltering(Boolean strictSQLFiltering)  throws IllegalStateException {
        setAttribute("strictSQLFiltering", strictSQLFiltering, false);
    }
    /**
     * [A] If set to true, both client and server-side advanced filtering used by SmartClient will follow SQL99 behavior for dealing with NULL values, which is often counter-intuitive to users. Specifically, when a field has NULL value, all of the following expression are false: <pre>    field == "someValue"  (normally false)    field != "someValue"  (normally true)    not (field == "someValue")   (normally true)    not (field != "someValue")   (normally false) </pre>
     *
     *
     * @return Boolean
     *
     */
    public Boolean getStrictSQLFiltering()  {
        return getAttributeAsBoolean("strictSQLFiltering");
    }

    // ********************* Methods ***********************

        /**
         * For a DataSource that describes a DOM structure, the list legal child elements that can be contained by the element described by this DataSource. <p> For a DataSource described by XML schema, this is the list of legal subelements <b>of complexType</b> (elements of simpleType become DataSourceFields with atomic type). <p> Note that currently, if an XML schema file contains ordering constraints, DataSources derived from XML Schema do not capture these constraints.
         */
        public native void getLegalChildTags() /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            self.getLegalChildTags();
        }-*/;




















        /**
         * Add a handleError handler.
         * <p>
         * If you define this method on a DataSource, it will be called whenever the server returns a DSResponse with a status other than {@link com.smartgwt.client.rpc.RPCResponse#STATUS_SUCCESS}.  You can use this hook to do DataSource-specific error handling.  Unless you return <code>false</code> from this method, {@link com.smartgwt.client.rpc.RPCManager#handleError} will be called by SmartClient right after this method completes.
         *
         * @param handler the handleError handler
         */
        public HandlerRegistration addHandleErrorHandler(com.smartgwt.client.data.events.HandleErrorHandler handler) {
            if(getHandlerCount(com.smartgwt.client.data.events.ErrorEvent.getType()) == 0) setupHandleErrorEvent();
            return doAddHandler(handler, com.smartgwt.client.data.events.ErrorEvent.getType());
        }
        private native void setupHandleErrorEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
                obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
                obj.addProperties({handleError:function(){
                        var param = {"response" : arguments[0], "request" : arguments[1]};
                        var event = @com.smartgwt.client.data.events.ErrorEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
                obj.handleError = function(){
                    var param = {"response" : arguments[0], "request" : arguments[1]};
                    var event = @com.smartgwt.client.data.events.ErrorEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                };
            }
        }-*/;

        /**
         * Return the field definition object.
         * @param fieldName Name of the field to retrieve
         *
         * @return field object
         */
        public native DataSourceField getField(String fieldName) /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            var ret = self.getField(fieldName);
            if(ret == null || ret === undefined) return null;
            return @com.smartgwt.client.data.DataSourceField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }-*/;


        /**
         * Returns a pointer to the primaryKey field for this DataSource
         *
         * @return primary key field object
         */
        public native DataSourceField getPrimaryKeyField() /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            var ret = self.getPrimaryKeyField();
            if(ret == null || ret === undefined) return null;
            return @com.smartgwt.client.data.DataSourceField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }-*/;

        /**
         * Returns the primary key fieldName for this DataSource
         *
         * @return primary key field name
         */
        public native String getPrimaryKeyFieldName() /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            return self.getPrimaryKeyFieldName();
        }-*/;




        /**
         * Does this dataSource support the specified "textMatchStyle" when performing a filter operation against a text field.
         * @param textMatchStyle textMatchStyle to check. If passed a null value, assume                                an exact match is being requested.
         */
        public native void supportsTextMatchStyle(String textMatchStyle) /*-{
            var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
            self.supportsTextMatchStyle(textMatchStyle);
        }-*/;











    // ********************* Static Methods ***********************

        /**
         * Lookup a DataSource by ID.
         * @param ID DataSource ID
         *
         * @return the DataSource with this ID, if loaded, otherwise null.
         */
        public static native DataSource getDataSource(String ID) /*-{
            var ret = $wnd.isc.DataSource.getDataSource(ID);
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.core.BaseClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;

        /**
         * Synonym of {@link com.smartgwt.client.data.DataSource#getDataSource}: Lookup a DataSource by ID.
         * @param ID DataSource ID
         *
         * @return the DataSource with this ID, if loaded, otherwise null.
         */
        public static native DataSource get(String ID) /*-{
            var ret = $wnd.isc.DataSource.get(ID);
            if(ret == null || ret === undefined) return null;
            var retVal = @com.smartgwt.client.core.BaseClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            if(retVal == null) {
                retVal = @com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
            }
            return retVal;
        }-*/;










    protected native void onInit() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();

        self.__transformRequest = self.transformRequest;
        self.transformRequest = function(dsRequest) {
            var jObj = this.__ref;
            if(jObj === undefined) {
                //handle case where oneTimeDS is cared from original DS (when clientOnly=true with dataURL)
                jObj = $wnd.isc.DS.get(this.inheritsFrom).__ref;
            }
            var dsRequestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            var data = jObj.@com.smartgwt.client.data.DataSource::transformRequest(Lcom/smartgwt/client/data/DSRequest;)(dsRequestJ);
            return data;
        };


        self.__transformResponse = self.transformResponse;
        self.transformResponse = function(dsResponse, dsRequest, data) {
            var jObj = this.__ref;
            if(jObj === undefined) {
                //handle case where oneTimeDS is cared from original DS (when clientOnly=true with dataURL)
                jObj = $wnd.isc.DS.get(this.inheritsFrom).__ref;
            }
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            jObj.@com.smartgwt.client.data.DataSource::transformResponse(Lcom/smartgwt/client/data/DSResponse;Lcom/smartgwt/client/data/DSRequest;Ljava/lang/Object;)(responseJ, requestJ, data);
        };
    }-*/;


    /**
     * Controls the format in which inputs are sent to the dataURL when fulfilling DSRequests. May be overridden for
     * individual request types using {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol}}
     *
     * @param dataProtocol dataProtocol Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDataProtocol(DSProtocol dataProtocol) throws IllegalStateException {
        setAttribute("dataProtocol", dataProtocol.getValue(), false);
    }

    /**
     * HTTP parameters that should be submitted with every DSRequest. <br> Useful for authenticated services that
     * require a sessionId with every request. <br> Can be set for all operations of a given DataSource as
     * DataSource.defaultParams.
     *
     * @param defaultParams the default params
     */
    public void setDefaultParams(Map defaultParams) {
        setAttribute("defaultParams", defaultParams, true);
    }

    /**
     * Controls the format in which inputs are sent to the dataURL when fulfilling DSRequests. May be overridden for
     * individual request types using {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol}}
     *
     * @return DSDataProtocol
     */
    public DSProtocol getDataProtocol() {
        return (DSProtocol) EnumUtil.getEnum(DSProtocol.values(), getAttribute("dataProtocol"));
    }

    /**
     * For a dataSource using client-side data integration, return the data that should be sent to the
     * DataSource.dataURL. <br> By default, HTTP requests sent to non-SmartClient servers do not include DSRequest
     * metadata such as DSRequest.startRow, endRow, and oldValues. Only the core datasource protocol data is sent, such
     * as the criteria passed to fetchData() or the updated values submitted by form.saveData(). <br> transformRequest()
     * allows you to transform dsRequest metadata into a format understood by your server and include it in the HTTP
     * request, so that you can integrate DataSource features such as data paging with servers that support such
     * features. <br> How the data is actually sent to the URL is controlled by OperationBinding.dataProtocol. If using
     * the "getParams" or "postParams" protocol, data is expected to be a JavaScript Object where each property will
     * become a GET or POST'd parameter. If using dataProtocol:"soap" or "postXML", data will be serialized as an XML
     * message by DataSource.xmlSerialize(). <br> Other reasons to implement transformRequest(): <ul> <li>transform a
     * Criteria object into the custom query language of a web service</li> <li>add a session id to requests that
     * require authentication</li> <li>detect colliding updates by sending both updated values and the values the user
     * originally retrieved before editing began (available as DSRequest.oldValues)</li>
     * <p/>
     * <br><b>Note: This is an override point</b>
     *
     * @param dsRequest the DSRequest being processed
     * @return data to be sent to the dataURL (JavaScriptObject or String)
     */
    protected native Object transformRequest(DSRequest dsRequest) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.__transformRequest(dsRequest.@com.smartgwt.client.data.DSRequest::getJsObj()());
    }-*/;

    /**
     * Modify the DSResponse object derived from the response returned from the  {@link
     * com.smartgwt.client.data.DataSource#getDataURL dataURL}. <P> This is an override point that makes it possible to
     * use DataSource features such as paging with web services that support such features, by allowing you to fill in
     * metadata fields in the DSResponse object (such as {@link com.smartgwt.client.data.DSResponse#getStartRow
     * startRow}) based on service-specific metadata fields contained in the service's response. <P> The DSResponse
     * passed to this method already has {@link com.smartgwt.client.data.DSResponse#getData data}, which is derived
     * differently depending on the {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} setting: <ul>
     * <li> <code>dataFormat:"xml"</code> : either the {@link com.smartgwt.client.data.OperationBinding#getRecordXPath
     * recordXPath} or  {@link com.smartgwt.client.data.OperationBinding#getRecordName recordName} is used to select the
     * XML elements that represent DataSource records.  The selected XML elements are passed to {@link
     * com.smartgwt.client.data.DataSource#recordsFromXML}, which transforms the XML elements to typed JavaScript data
     * using the DataSource as a schema. <li> <code>dataFormat:"json"</code> : the {@link
     * com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}, if specified, is used to select records
     * from the returned JSON data via {@link com.smartgwt.client.util.XMLTools#selectObjects}.   {@link
     * com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath} is used to derive correctly typed field
     * values. <li> <code>dataFormat:"custom"</code> : <code>dsResponse.data</code> is the raw response in String form.
     * It must be parsed into an Array of Objects for subsequent processing to work. </ul>  <P> In addition to
     * <code>dsResponse.data</code>, {@link com.smartgwt.client.data.DSResponse#getStatus status} is defaulted to 0
     * (indicating no error), and {@link com.smartgwt.client.data.DSResponse#getStartRow startRow} is assumed to be
     * zero, with {@link com.smartgwt.client.data.DSResponse#getEndRow endRow} and {@link
     * com.smartgwt.client.data.DSResponse#getTotalRows totalRows} both set to <code>dsResponse.data.length - 1</code>,
     * that is, the returned data is assumed to be all records that matched the filter criteria. <P> Examples of using
     * this API include: <ul> <li> setting {@link com.smartgwt.client.data.DSResponse#getStartRow startRow}, {@link
     * com.smartgwt.client.data.DSResponse#getEndRow endRow} and {@link com.smartgwt.client.data.DSResponse#getTotalRows
     * totalRows}      to allow paging for a service that supports it.  For example, if an XML service      returns a
     * "resultRow" tag that contained the row number of the first row of the      returned results:<pre>
     * dsResponse.startRow =         isc.XMLTools.selectNumber(xmlData, "//resultRow"); </pre> <li> setting {@link
     * com.smartgwt.client.data.DSResponse#getStatus status} to recognized ISC error values based on service-specific
     * errors, in order to trigger standard ISC error handling.  For      example, setting
     * <code>dsResponse.status</code> to      {@link com.smartgwt.client.rpc.RPCResponse#STATUS_VALIDATION_ERROR} and
     * filling in      {@link com.smartgwt.client.data.DSResponse#getErrors errors} in order to cause validation errors
     * to be shown in      forms and grids. <li> for services that either do not return cache update data, or return
     * partial data,      using {@link com.smartgwt.client.data.DSRequest#getOldValues oldValues} to create cache update
     * data (whether this is      appropriate is application-specific), or setting      {@link
     * com.smartgwt.client.data.DSResponse#getInvalidateCache invalidateCache}. </ul> <P> <span
     * STYLE="color:red">NOTE:</span> this method is NOT an appropriate time to call methods on visual components such
     * as grids, initiate new DSRequests or RPCRequests, or in general do anything other than fill in fields on the
     * DSResponse based on data that is already available.  Any actions that need to be taken as a result of the web
     * service response should be implemented exactly as for a DataSource where <code>transformResponse()</code> has not
     * been overriden, that is, use the callback passed to high-level methods such as  <code>grid.fetchData()</code>,
     * and do error handling via either {@link com.smartgwt.client.data.DataSource#handleError} or by setting {@link
     * com.smartgwt.client.rpc.RPCRequest#getWillHandleError willHandleError}.
     */
    protected native void transformResponse(DSResponse response, DSRequest request, Object data) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.__transformResponse(response.@com.smartgwt.client.data.DSResponse::getJsObj()(), request.@com.smartgwt.client.data.DSRequest::getJsObj()(), data);
    }-*/;


    public native boolean isCreated()/*-{
        var id = this.@com.smartgwt.client.core.BaseClass::getID()();
        var obj = $wnd.isc.DataSource.getDataSource(id);
        return id != null && obj != null && obj !== undefined;
    }-*/;

    public native JavaScriptObject getJsObj()/*-{
        var id = this.@com.smartgwt.client.core.BaseClass::getID()();
        var obj = $wnd.isc.DataSource.getDataSource(id);
        return obj;
    }-*/;

    /**
     * Additional properties to pass through to the {@link com.smartgwt.client.data.DSRequest}s made by this DataSource.
     * <p> These properties are applied before {@link com.smartgwt.client.data.DataSource#transformRequest} is called.
     *
     * @param requestProperties requestProperties Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRequestProperties(DSRequest requestProperties) throws IllegalStateException {
        setAttribute("requestProperties", requestProperties, false);
    }


    /**
     * ID of another DataSource this DataSource inherits its DataSource fields from.<br><br>Local fields (fields defined
     * in this DataSource) are added to inherited fields to form the full set of fields. Fields with the same name are
     * merged in the same way that databound component fields are merged with DataSource fields.<br><br>The default
     * order of the combined fields is new local fields first (including any fields present in the parent DataSource
     * which the local DataSource re-declares), then parent fields.  You can set {@link
     * com.smartgwt.client.data.DataSource#setUseParentFieldOrder(Boolean) useParentFieldOrder} to instead use the
     * parent's field&amp;#010 order, with new local fields appearing last.<br><br>
     * <p/>
     * You can set {@link com.smartgwt.client.data.DataSource#setShowLocalFieldsOnly(Boolean) showLocalFieldsOnly}  to
     * have all non-local fields hidden.<br><br>Note that &lt;b&gt;only fields are inherited&lt;/b&gt; - other
     * properties such as dataURL and dataFormat are not.  You can use ordinary inheritance, that is, creating a
     * subclass of DataSource, in order to share properties such as dataURL across a series of DataSources that also
     * inherit fields from each other via &lt;code&gt;inheritsFrom&lt;/code&gt; <br><br> This feature can be used for
     * creating a customized view (eg, only certain fields shown) which will be used bymultiple databound
     * components.adding presentation-specific attributes to metadata that has been automatically derived from {@link
     * com.smartgwt.client.data.XMLTools#loadXMLSchema(String, XSDLoadCallback)} or other metadata formats modelling
     * object subclassing and extension in server-side code and storage systems modelling relational database joins, and
     * the equivalents in other systems creating hooks for others to customize your application in a maintainable way.
     * For example, if you have a dataSource &quot;employee&quot;, you can create a
     * dataSource&quot;customizedEmployee&quot; which inherits from &quot;employee&quot; but does not initially define
     * anyfields, and bind all databound components to&quot;customizedEmployee&quot;. Customizations of fields
     * (including appearance changes, fieldorder, new fields, hiding of fields, and custom validation rules) can be
     * added to&quot;customizedEmployee&quot;, so that they are kept separtely from the original field data andhave the
     * best possible chance of working with future versions of the &quot;employee&quot;dataSource.&lt;/ul&gt;
     *
     * @param inheritsFrom the datasource to inherit from
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setInheritsFrom(DataSource inheritsFrom) throws IllegalStateException {
        setAttribute("inheritsFrom", inheritsFrom.getOrCreateJsObj(), false);
    }

    /**
     * The list of fields that compose records from this DataSource. <P> Each DataSource field can have type,
     * user-visible title, validators, and other metadata attached.
     *
     * @param fields fields Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFields(DataSourceField... fields) {
        for (DataSourceField field : fields) {
            addField(field);
        }
    }

    public void addField(DataSourceField field) {
        JavaScriptObject fieldJS = field.getJsObj();
        addFieldPreCreate(fieldJS);
    }

    private native void addFieldPreCreate(JavaScriptObject fieldJS) /*-{
		var config = this.@com.smartgwt.client.core.BaseClass::config;

        if(!config.fields) {
            config.fields = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        config.fields.push(fieldJS);
    }-*/;

    /**
     * For a client-only DataSource, a set of records to use as a dataset, specified as an Array of JavaScript Objects.
     * <P> See this discussion for ways to populate a client-only DataSource with test data.
     *
     * @param testData testData Default value is null
     */
    public void setTestData(DataClass[] testData) {
        setAttribute("testData", testData, true);
    }

    /**
     * For a client-only DataSource, a set of records to use as a dataset, specified as an Array of JavaScript Objects.
     * <P> See this discussion for ways to populate a client-only DataSource with test data.
     *
     * @return the test data
     */
    public DataClass[] getTestData() {
        return convertToTabArray(getAttributeAsJavaScriptObject("testData"));
    }

    private static DataClass[] convertToTabArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new DataClass[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        DataClass[] objects = new DataClass[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            DataClass obj = RefDataClass.getRef(componentJS);
            if (obj == null) {
                obj = new DataClass(componentJS);
            }
            objects[i] = obj;
        }
        return objects;
    }

    /**
     * <br>Optional array of OperationBindings, which provide instructions to the DataSource about how each DSOperation
     * is to be performed. <p> For DataSources bound to WSDL-described web services using {@link
     * com.smartgwt.client.data.DataSource#setServiceNamespace(String) serviceNamespace} </a>, OperationBindings are
     * used to bind each DataSource <a href="" onmouseout="isc.Hover.clear()" onmouseover='isc.DocUtils.$46s("attr:OperationBinding.operationType")'
     * onclick='isc.Hover.clear();isc.DocViewer.instance.$46t("attr:OperationBinding.operationType");return
     * false;'>operationType</a> to an <a href="" onmouseout="isc.Hover.clear()" onmouseover='isc.DocUtils.$46s("attr:OperationBinding.wsOperation")'
     * onclick='isc.Hover.clear();isc.DocViewer.instance.$46t("attr:OperationBinding.wsOperation");return
     * false;'>operation</a> of a WSDL-described <a href="" onmouseout="isc.Hover.clear()"
     * onmouseover='isc.DocUtils.$46s("class:WebService")' onclick='isc.Hover.clear();isc.DocViewer.instance.$46t("class:WebService");return
     * false;'>web service</a>, so that a DataSource can both fetch and save data to a web service. </p><p> For example,
     * this code accomplishes part of the binding to the  <a href="http://www.google.com/search?q=sforce+partner+wsdl"
     * onclick="window.open('http://www.google.com/search?q=sforce+partner+wsdl');return false;">SalesForce partner web
     * services</a>
     * </p><pre>
     *  isc.DataSource.create({
     *  serviceNamespace : "urn:partner.soap.sforce.com",
     *     operationBindings : [
     *         { operationType:"fetch", wsOperation:"query", recordName: "sObject" },
     *         { operationType:"update", wsOperation:"update", recordName: "SaveResult" },
     *         { operationType:"add", wsOperation:"create", recordName: "SaveResult" },
     *         { operationType:"remove", wsOperation:"delete", recordName: "DeleteResult" }
     *     ],
     *     ...
     *  });
     *  </pre>
     * <p/> NOTE: additional code is required to handle authentication and other details, see the complete code in
     * isomorphicSDK/examples/databinding/SalesForce. <p> For DataSources that contact non-WSDL-described XML or JSON
     * services, OperationBindings can be used to separately configure the URL, HTTP method, input and output processing
     * for each operationType.  This makes it possible to fetch JSON data from one URL for the "fetch" operationType and
     * save to a web service for the "update" operationType, while appearing as a single integrated DataSource to a <a
     * href="" onmouseout="isc.Hover.clear()" onmouseover='isc.DocUtils.$46s("interface:DataBoundComponent")'
     * onclick='isc.Hover.clear();isc.DocViewer.instance.$46t("interface:DataBoundComponent");return
     * false;'>DataBoundComponent</a> such as an <a href="" onmouseout="isc.Hover.clear()"
     * onmouseover='isc.DocUtils.$46s("attr:ListGrid.canEdit")' onclick='isc.Hover.clear();isc.DocViewer.instance.$46t("attr:ListGrid.canEdit");return
     * false;'>editable ListGrid</a>. <p/> </p><p> If no operationBinding is defined for a given DataSource operation,
     * all of the properties which are valid on the operationBinding are checked for on the DataSource itself. </p><p>
     * This also means that a read-only DataSource, that is, a DataSource only capable of fetch operations,
     * operationBindings need not be specified, and instead all operationBinding properties can be set on the DataSource
     * itself.  An example of using OperationBinding properties directly on the DataSource in order to read an RSS feed
     * can be found here: </p><p> <a href="/examples/databinding/rss_databinding.html"
     * onclick="window.open('/examples/databinding/rss_databinding.html');return false;">/examples/databinding/rss_databinding.html</a>&nbsp;<img
     * src="http://www.smartclient.com/docs/6.5.1/a/system/reference/skin/images/text_code.gif"
     * onclick='isc.DocUtils.showExampleSource("/examples/databinding/rss_databinding.html")'
     * onmouseover="isc.Hover.setAction(isc.DocUtils, isc.DocUtils.doSourceHover,null,300)"
     * onmouseout="isc.Hover.clear()" style="cursor: pointer;" suppress="TRUE" align="texttop" border="0" height="16"
     * width="16"><br><br><b>See Also:</b><br>&nbsp;&nbsp;<a href="" onmouseout="isc.Hover.clear()"
     * onmouseover='isc.DocUtils.$46s("class:OperationBinding")' onclick='isc.Hover.clear();isc.DocViewer.instance.$46t("class:OperationBinding");return
     * false;'>OperationBinding</a> <br><br></p>
     *
     * @param operationBindings the operation bindings
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setOperationBindings(OperationBinding... operationBindings) throws IllegalStateException {
        setAttribute("operationBindings", operationBindings, false);
    }

    /**
     * See {@link com.smartgwt.client.data.OperationBinding#getRecordName recordName}.  <code>recordName</code> can be
     * specified directly on the DataSource for a simple read-only DataSource only capable of "fetch" operations.
     *
     * @param recordName Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRecordName(String recordName) throws IllegalStateException {
        setAttribute("recordName", recordName, false);
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
    public void setXmlNamespaces(XmlNamespaces xmlNamespaces) throws IllegalStateException {
        setAttribute("xmlNamespaces", xmlNamespaces, false);
    }


    /**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria and retrieving matching
     * records. <P> In contrast to {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData}, which creates a {@link
     * com.smartgwt.client.data.ResultSet} to manage the returned data, calling <code>dataSource.fetchData()</code>
     * provides the returned data in the callback as a simple JavaScript Array of JavaScript Objects.  Calling
     * <code>dataSource.fetchData()</code> does not automatically update any visual components or caches: code in the
     * callback passed to <code>fetchData()</code> decides what to do with the returned data.  <P> For example, given a
     * ListGrid "myGrid" and a DataSource "employees", the following code would populate "myGrid" with data fetched
     * from
     * the DataSource: <pre>    isc.DataSource.get("employees").fetchData(null, "myGrid.setData(data)"); </pre> Unlike
     * calling <code>myGrid.fetchData()</code>, which creates a {@link com.smartgwt.client.data.ResultSet}, the data
     * provided to the grid is "disconnected" data, unmanaged by SmartClient's databinding facilities and safe to
     * directly modify.  This is useful when, for example, a ListGrid is being used as a more sophisticated version of
     * HTML's multi-select component. <P> Disconnected datasets may be used to populate various visual components.  For
     * example, while an individual FormItem can be configured to fetch {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
     * valueMap} options from a DataSource via the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} property, the following code shows storing a dataset to derive valueMaps from later: <pre>
     * isc.DataSource.get("countries").fetchData(null, "window.countries = data");    ... later, a form is created
     * dynamically ...    function showForm() {       isc.DynamicForm.create({           items : [              {
     * name:"country", title:"Pick Country",                valueMap: window.countries.getValueMap("countryId",
     * "countryName")              },       ... </pre> <P> You can also create a ResultSet from the data retrieved from
     * <code>fetchData()</code>, like so: <pre>    isc.DataSource.get("countries").fetchData(null,        function
     * (dsResponse, data) {           isc.ResultSet.create({              dataSource:"countries",
     * allRows:data           })        }    ) </pre> <P> This gives you a dataset that supports client-side filtering
     * (via {@link com.smartgwt.client.data.ResultSet#setCriteria}), can provide  {@link
     * com.smartgwt.client.data.ResultSet#getValueMap}, will  {@link com.smartgwt.client.data.ResultSet#getDisableCacheSync
     * disableCacheSync} to the DataSource made via other components, and can be re-used with multiple visual
     * components. <P> See also the server-side com.isomorphic.js.JSTranslater class in the
     * ${isc.DocUtils.linkForDocNode('javaServerReference', 'Java Server Reference')} for other, similar approaches
     * involving dumping data into the page during initial page load.  <b>Note:</b> care should be taken when using this
     * approach.  Large datasets degrade the basic performance of some browsers, so use {@link
     * com.smartgwt.client..PickList#getOptionDataSource optionDataSource} and similar facilities to manage datasets
     * that may become very large. <P> <b>Data-Driven Visual Component Creation</b> <P>
     * <code>DataSource.fetchData()</code> can also be used to create SmartClient components in a data-driven way.  Many
     * properties on SmartClient visual components are configured via an Array of Objects - the same data format that
     * <code>dataSource.fetchData()</code> returns.  These include {@link com.smartgwt.client.widgets.grid.ListGrid#getFields
     * fields}, {@link com.smartgwt.client.widgets.tab.TabSet#getTabs tabs}, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getItems items}, {@link com.smartgwt.client..Facet#getValues values}
     * and even {@link com.smartgwt.client.data.DataSource#getFields fields}. <P> For example, if you had a DataSource
     * "myFormFields" whose fields included the basic properties of {@link com.smartgwt.client.widgets.form.fields.FormItem}
     * (name, title, type, etc), this example code would create a form based on stored field definitions, loaded from
     * the "myFormFields" DataSource on the fly: <pre>    isc.DataSource.get("myFormFields").fetchData(null,
     * "isc.DynamicForm.create({ items:data })"    ) </pre> This capability to dynamically create visual components
     * from
     * dynamically fetched data provides a foundation for creating interfaces that can be customized by end users. See
     * also {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}.
     */
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    /**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria and retrieving matching
     * records. <P> In contrast to {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData}, which creates a {@link
     * com.smartgwt.client.data.ResultSet} to manage the returned data, calling <code>dataSource.fetchData()</code>
     * provides the returned data in the callback as a simple JavaScript Array of JavaScript Objects.  Calling
     * <code>dataSource.fetchData()</code> does not automatically update any visual components or caches: code in the
     * callback passed to <code>fetchData()</code> decides what to do with the returned data.  <P> For example, given a
     * ListGrid "myGrid" and a DataSource "employees", the following code would populate "myGrid" with data fetched
     * from
     * the DataSource: <pre>    isc.DataSource.get("employees").fetchData(null, "myGrid.setData(data)"); </pre> Unlike
     * calling <code>myGrid.fetchData()</code>, which creates a {@link com.smartgwt.client.data.ResultSet}, the data
     * provided to the grid is "disconnected" data, unmanaged by SmartClient's databinding facilities and safe to
     * directly modify.  This is useful when, for example, a ListGrid is being used as a more sophisticated version of
     * HTML's multi-select component. <P> Disconnected datasets may be used to populate various visual components.  For
     * example, while an individual FormItem can be configured to fetch {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
     * valueMap} options from a DataSource via the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} property, the following code shows storing a dataset to derive valueMaps from later: <pre>
     * isc.DataSource.get("countries").fetchData(null, "window.countries = data");    ... later, a form is created
     * dynamically ...    function showForm() {       isc.DynamicForm.create({           items : [              {
     * name:"country", title:"Pick Country",                valueMap: window.countries.getValueMap("countryId",
     * "countryName")              },       ... </pre> <P> You can also create a ResultSet from the data retrieved from
     * <code>fetchData()</code>, like so: <pre>    isc.DataSource.get("countries").fetchData(null,        function
     * (dsResponse, data) {           isc.ResultSet.create({              dataSource:"countries",
     * allRows:data           })        }    ) </pre> <P> This gives you a dataset that supports client-side filtering
     * (via {@link com.smartgwt.client.data.ResultSet#setCriteria}), can provide  {@link
     * com.smartgwt.client.data.ResultSet#getValueMap}, will  {@link com.smartgwt.client.data.ResultSet#getDisableCacheSync
     * disableCacheSync} to the DataSource made via other components, and can be re-used with multiple visual
     * components. <P> See also the server-side com.isomorphic.js.JSTranslater class in the
     * ${isc.DocUtils.linkForDocNode('javaServerReference', 'Java Server Reference')} for other, similar approaches
     * involving dumping data into the page during initial page load.  <b>Note:</b> care should be taken when using this
     * approach.  Large datasets degrade the basic performance of some browsers, so use {@link
     * com.smartgwt.client..PickList#getOptionDataSource optionDataSource} and similar facilities to manage datasets
     * that may become very large. <P> <b>Data-Driven Visual Component Creation</b> <P>
     * <code>DataSource.fetchData()</code> can also be used to create SmartClient components in a data-driven way.  Many
     * properties on SmartClient visual components are configured via an Array of Objects - the same data format that
     * <code>dataSource.fetchData()</code> returns.  These include {@link com.smartgwt.client.widgets.grid.ListGrid#getFields
     * fields}, {@link com.smartgwt.client.widgets.tab.TabSet#getTabs tabs}, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getItems items}, {@link com.smartgwt.client..Facet#getValues values}
     * and even {@link com.smartgwt.client.data.DataSource#getFields fields}. <P> For example, if you had a DataSource
     * "myFormFields" whose fields included the basic properties of {@link com.smartgwt.client.widgets.form.fields.FormItem}
     * (name, title, type, etc), this example code would create a form based on stored field definitions, loaded from
     * the "myFormFields" DataSource on the fly: <pre>    isc.DataSource.get("myFormFields").fetchData(null,
     * "isc.DynamicForm.create({ items:data })"    ) </pre> This capability to dynamically create visual components
     * from
     * dynamically fetched data provides a foundation for creating interfaces that can be customized by end users. See
     * also {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}.
     *
     * @param criteria search criteria
     */
    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria and retrieving matching
     * records. <P> In contrast to {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData}, which creates a {@link
     * com.smartgwt.client.data.ResultSet} to manage the returned data, calling <code>dataSource.fetchData()</code>
     * provides the returned data in the callback as a simple JavaScript Array of JavaScript Objects.  Calling
     * <code>dataSource.fetchData()</code> does not automatically update any visual components or caches: code in the
     * callback passed to <code>fetchData()</code> decides what to do with the returned data.  <P> For example, given a
     * ListGrid "myGrid" and a DataSource "employees", the following code would populate "myGrid" with data fetched
     * from
     * the DataSource: <pre>    isc.DataSource.get("employees").fetchData(null, "myGrid.setData(data)"); </pre> Unlike
     * calling <code>myGrid.fetchData()</code>, which creates a {@link com.smartgwt.client.data.ResultSet}, the data
     * provided to the grid is "disconnected" data, unmanaged by SmartClient's databinding facilities and safe to
     * directly modify.  This is useful when, for example, a ListGrid is being used as a more sophisticated version of
     * HTML's multi-select component. <P> Disconnected datasets may be used to populate various visual components.  For
     * example, while an individual FormItem can be configured to fetch {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
     * valueMap} options from a DataSource via the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} property, the following code shows storing a dataset to derive valueMaps from later: <pre>
     * isc.DataSource.get("countries").fetchData(null, "window.countries = data");    ... later, a form is created
     * dynamically ...    function showForm() {       isc.DynamicForm.create({           items : [              {
     * name:"country", title:"Pick Country",                valueMap: window.countries.getValueMap("countryId",
     * "countryName")              },       ... </pre> <P> You can also create a ResultSet from the data retrieved from
     * <code>fetchData()</code>, like so: <pre>    isc.DataSource.get("countries").fetchData(null,        function
     * (dsResponse, data) {           isc.ResultSet.create({              dataSource:"countries",
     * allRows:data           })        }    ) </pre> <P> This gives you a dataset that supports client-side filtering
     * (via {@link com.smartgwt.client.data.ResultSet#setCriteria}), can provide  {@link
     * com.smartgwt.client.data.ResultSet#getValueMap}, will  {@link com.smartgwt.client.data.ResultSet#getDisableCacheSync
     * disableCacheSync} to the DataSource made via other components, and can be re-used with multiple visual
     * components. <P> See also the server-side com.isomorphic.js.JSTranslater class in the
     * ${isc.DocUtils.linkForDocNode('javaServerReference', 'Java Server Reference')} for other, similar approaches
     * involving dumping data into the page during initial page load.  <b>Note:</b> care should be taken when using this
     * approach.  Large datasets degrade the basic performance of some browsers, so use {@link
     * com.smartgwt.client..PickList#getOptionDataSource optionDataSource} and similar facilities to manage datasets
     * that may become very large. <P> <b>Data-Driven Visual Component Creation</b> <P>
     * <code>DataSource.fetchData()</code> can also be used to create SmartClient components in a data-driven way.  Many
     * properties on SmartClient visual components are configured via an Array of Objects - the same data format that
     * <code>dataSource.fetchData()</code> returns.  These include {@link com.smartgwt.client.widgets.grid.ListGrid#getFields
     * fields}, {@link com.smartgwt.client.widgets.tab.TabSet#getTabs tabs}, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getItems items}, {@link com.smartgwt.client..Facet#getValues values}
     * and even {@link com.smartgwt.client.data.DataSource#getFields fields}. <P> For example, if you had a DataSource
     * "myFormFields" whose fields included the basic properties of {@link com.smartgwt.client.widgets.form.fields.FormItem}
     * (name, title, type, etc), this example code would create a form based on stored field definitions, loaded from
     * the "myFormFields" DataSource on the fly: <pre>    isc.DataSource.get("myFormFields").fetchData(null,
     * "isc.DynamicForm.create({ items:data })"    ) </pre> This capability to dynamically create visual components
     * from
     * dynamically fetched data provides a foundation for creating interfaces that can be customized by end users. See
     * also {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}.
     *
     * @param criteria search criteria
     * @param callback callback to invoke on completion
     */
    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria and retrieving matching
     * records. <P> In contrast to {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData}, which creates a {@link
     * com.smartgwt.client.data.ResultSet} to manage the returned data, calling <code>dataSource.fetchData()</code>
     * provides the returned data in the callback as a simple JavaScript Array of JavaScript Objects.  Calling
     * <code>dataSource.fetchData()</code> does not automatically update any visual components or caches: code in the
     * callback passed to <code>fetchData()</code> decides what to do with the returned data.  <P> For example, given a
     * ListGrid "myGrid" and a DataSource "employees", the following code would populate "myGrid" with data fetched
     * from
     * the DataSource: <pre>    isc.DataSource.get("employees").fetchData(null, "myGrid.setData(data)"); </pre> Unlike
     * calling <code>myGrid.fetchData()</code>, which creates a {@link com.smartgwt.client.data.ResultSet}, the data
     * provided to the grid is "disconnected" data, unmanaged by SmartClient's databinding facilities and safe to
     * directly modify.  This is useful when, for example, a ListGrid is being used as a more sophisticated version of
     * HTML's multi-select component. <P> Disconnected datasets may be used to populate various visual components.  For
     * example, while an individual FormItem can be configured to fetch {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap
     * valueMap} options from a DataSource via the {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource
     * optionDataSource} property, the following code shows storing a dataset to derive valueMaps from later: <pre>
     * isc.DataSource.get("countries").fetchData(null, "window.countries = data");    ... later, a form is created
     * dynamically ...    function showForm() {       isc.DynamicForm.create({           items : [              {
     * name:"country", title:"Pick Country",                valueMap: window.countries.getValueMap("countryId",
     * "countryName")              },       ... </pre> <P> You can also create a ResultSet from the data retrieved from
     * <code>fetchData()</code>, like so: <pre>    isc.DataSource.get("countries").fetchData(null,        function
     * (dsResponse, data) {           isc.ResultSet.create({              dataSource:"countries",
     * allRows:data           })        }    ) </pre> <P> This gives you a dataset that supports client-side filtering
     * (via {@link com.smartgwt.client.data.ResultSet#setCriteria}), can provide  {@link
     * com.smartgwt.client.data.ResultSet#getValueMap}, will  {@link com.smartgwt.client.data.ResultSet#getDisableCacheSync
     * disableCacheSync} to the DataSource made via other components, and can be re-used with multiple visual
     * components. <P> See also the server-side com.isomorphic.js.JSTranslater class in the
     * ${isc.DocUtils.linkForDocNode('javaServerReference', 'Java Server Reference')} for other, similar approaches
     * involving dumping data into the page during initial page load.  <b>Note:</b> care should be taken when using this
     * approach.  Large datasets degrade the basic performance of some browsers, so use {@link
     * com.smartgwt.client..PickList#getOptionDataSource optionDataSource} and similar facilities to manage datasets
     * that may become very large. <P> <b>Data-Driven Visual Component Creation</b> <P>
     * <code>DataSource.fetchData()</code> can also be used to create SmartClient components in a data-driven way.  Many
     * properties on SmartClient visual components are configured via an Array of Objects - the same data format that
     * <code>dataSource.fetchData()</code> returns.  These include {@link com.smartgwt.client.widgets.grid.ListGrid#getFields
     * fields}, {@link com.smartgwt.client.widgets.tab.TabSet#getTabs tabs}, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getItems items}, {@link com.smartgwt.client..Facet#getValues values}
     * and even {@link com.smartgwt.client.data.DataSource#getFields fields}. <P> For example, if you had a DataSource
     * "myFormFields" whose fields included the basic properties of {@link com.smartgwt.client.widgets.form.fields.FormItem}
     * (name, title, type, etc), this example code would create a form based on stored field definitions, loaded from
     * the "myFormFields" DataSource on the fly: <pre>    isc.DataSource.get("myFormFields").fetchData(null,
     * "isc.DynamicForm.create({ items:data })"    ) </pre> This capability to dynamically create visual components
     * from
     * dynamically fetched data provides a foundation for creating interfaces that can be customized by end users. See
     * also {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}.
     *
     * @param criteria          search criteria
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest that will be issued
     */
    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria and retrieving matching
     * records. <P> This is identical to {@link com.smartgwt.client.data.DataSource#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is set to "substring" to cause case
     * insensitive substring matching (if the server respects this setting).
     *
     * @param criteria search criteria
     */
    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    /**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria and retrieving matching
     * records. <P> This is identical to {@link com.smartgwt.client.data.DataSource#fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is set to "substring" to cause case
     * insensitive substring matching (if the server respects this setting).
     *
     * @param criteria search criteria
     * @param callback callback to invoke on completion
     */
    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Perform an "add" DataSource operation against this DataSource, to create a new DataSource record.
     *
     * @param newRecord new record
     */
    public native void addData(Record record) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.addData(recordJS);
    }-*/;

    /**
     * Perform an "add" DataSource operation against this DataSource, to create a new DataSource record.
     *
     * @param newRecord new record
     * @param callback  callback to invoke on completion
     */
    public native void addData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.addData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Perform an "add" DataSource operation against this DataSource, to create a new DataSource record.
     *
     * @param newRecord         new record
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest that will be issued
     */
    public native void addData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.addData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Perform an "update" DataSource operation against this DataSource, to update values in an existing DataSource
     * record.
     *
     * @param updatedRecord updated record
     */
    public native void updateData(Record record) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.updateData(recordJS);
    }-*/;

    /**
     * Perform an "update" DataSource operation against this DataSource, to update values in an existing DataSource
     * record.
     *
     * @param updatedRecord updated record
     * @param callback      callback to invoke on completion
     */
    public native void updateData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.updateData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Perform an "update" DataSource operation against this DataSource, to update values in an existing DataSource
     * record.
     *
     * @param updatedRecord     updated record
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest that will be issued
     */
    public native void updateData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.updateData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Perform a "remove" DataSource operation against this DataSource, to delete an existing DataSource record.
     *
     * @param data primary key values of record to delete,                                             (or complete
     *             record)
     */
    public native void removeData(Record record) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.removeData(recordJS);
    }-*/;

    /**
     * Perform a "remove" DataSource operation against this DataSource, to delete an existing DataSource record.
     *
     * @param data     primary key values of record to delete,                                             (or complete
     *                 record)
     * @param callback callback to invoke on completion
     */
    public native void removeData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.removeData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        });
    }-*/;

    /**
     * Perform a "remove" DataSource operation against this DataSource, to delete an existing DataSource record.
     *
     * @param data              primary key values of record to delete,                                             (or
     *                          complete record)
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest that will be issued
     */
    public native void removeData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.removeData(recordJS, function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }, requestPropertiesJS);
    }-*/;

    /**
     * Serialize a JavaScript object as XML.
     * <p/>
     * The JavaScript Object passed to DataSource.xmlSerialize() becomes an XML element named after the
     * DataSource.tagName (or DataSource.ID if tagName is unset). Each property of the object becomes a subElement. For
     * example, using a DataSource to serialize like this:
     * <pre>
     * var inputObject = {
     *   startRow : 5,
     *   endRow : 50,
     *   data : [
     *      { field1 : "value1", field2: new Date() },
     *      { field1 : "value3", field2: null }
     *   ]
     * };
     * var myDS = isc.DataSource.create({ tagName:"DSRequest" });
     * myDS.xmlSerialize(inputObject);
     * </pre>
     * <p/>
     * .. produces the following XML:
     * <pre>
     * <DSRequest>
     *     <startRow>5</startRow>
     *     <endRow>50</endRow>
     *     <data>
     *         <field1>value1</field1>
     *         <field2>2005-10-14T18:01:16</field2>
     *     </data>
     *     <data>
     *         <field1>value3</field1>
     *         <field2></field2>
     *     </data>
     * </DSRequest>
     * </pre>
     * <p/>
     * <p/>
     * If you are working with a WSDL-described web service, XML serialization is performed automatically by APIs like
     * WebService.callOperation() - you only need to know about serialization in order to understand how to put together
     * JavaScript data that will fill in an XML message properly.
     * <p/>
     * <p/>
     * Note: when trying to send data to a web service, it is best to avoid putting together any XML yourself, instead
     * modify the JavaScript data being fed to ISC's SOAP engine. This is because the WSDL and SOAP rules for correctly
     * namespacing and encoding Web Service messages are very complex and are subject to change with new versions of the
     * web service you are contacting, whereas the data itself is easy to manipulate and less likely to change. To
     * troubleshoot message formation, you can set the log category "xmlComm" to DEBUG level in order to see the XML
     * message formed by SmartClient reported in log statements in the Developer Console.
     *
     * @param data the data to be serialized
     * @return data as serialized to XML
     */
    public native String xmlSerialize(JavaScriptObject data) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.xmlSerialize(data);
    }-*/;

    /**
     * Serialize a JavaScript object as XML.
     * <p/>
     * The JavaScript Object passed to DataSource.xmlSerialize() becomes an XML element named after the
     * DataSource.tagName (or DataSource.ID if tagName is unset). Each property of the object becomes a subElement. For
     * example, using a DataSource to serialize like this:
     * <pre>
     * var inputObject = {
     *   startRow : 5,
     *   endRow : 50,
     *   data : [
     *      { field1 : "value1", field2: new Date() },
     *      { field1 : "value3", field2: null }
     *   ]
     * };
     * var myDS = isc.DataSource.create({ tagName:"DSRequest" });
     * myDS.xmlSerialize(inputObject);
     * </pre>
     * <p/>
     * .. produces the following XML:
     * <pre>
     * <DSRequest>
     *     <startRow>5</startRow>
     *     <endRow>50</endRow>
     *     <data>
     *         <field1>value1</field1>
     *         <field2>2005-10-14T18:01:16</field2>
     *     </data>
     *     <data>
     *         <field1>value3</field1>
     *         <field2></field2>
     *     </data>
     * </DSRequest>
     * </pre>
     * <p/>
     * <p/>
     * If you are working with a WSDL-described web service, XML serialization is performed automatically by APIs like
     * WebService.callOperation() - you only need to know about serialization in order to understand how to put together
     * JavaScript data that will fill in an XML message properly.
     * <p/>
     * <p/>
     * Note: when trying to send data to a web service, it is best to avoid putting together any XML yourself, instead
     * modify the JavaScript data being fed to ISC's SOAP engine. This is because the WSDL and SOAP rules for correctly
     * namespacing and encoding Web Service messages are very complex and are subject to change with new versions of the
     * web service you are contacting, whereas the data itself is easy to manipulate and less likely to change. To
     * troubleshoot message formation, you can set the log category "xmlComm" to DEBUG level in order to see the XML
     * message formed by SmartClient reported in log statements in the Developer Console.
     *
     * @param data  the data to be serialized
     * @param flags options for the serialization engine
     * @return data as serialized to XML
     */
    public native String xmlSerialize(JavaScriptObject data, SerializationContext flags) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var flagsJS = flags.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.xmlSerialize(data, flagsJS);
    }-*/;


    /**
     * Process a dsResponse for a request initiated by a DataSource with {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol}. <code>requestId</code> parameter should be dsRequest.requestId as found on the dsRequest passed to {@link com.smartgwt.client.data.DataSource#transformRequest}. <P> You must provide a response for both error and non-error cases.  For an error case, a sufficient response is: <pre> { status : -1 } </pre>
     * @param requestId requestId attribute from the associated dataSource request object
 * @param dsResponse Configuration for the dsResponse
     */
    public native void processResponse(String requestId, DSResponse responseProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var responsePropertiesJS = responseProperties == null ? null : responseProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.processResponse(requestId, responsePropertiesJS);
    }-*/;



}




