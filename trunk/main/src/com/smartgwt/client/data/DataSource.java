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
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A DataSource is data-provider-independent description of a set of objects that will be loaded, edited and saved within
 * the user interface of your application. <P> Each DataSource consists of a list of {@link
 * com.smartgwt.client.data.DataSource#getFields fields} that make up a DataSource <code>record</code>, along with {@link
 * com.smartgwt.client.data.DataSourceField#getType field types},  {@link
 * com.smartgwt.client.data.DataSourceField#getValidators validation rules},  {@link
 * com.smartgwt.client.data.DataSourceField#getForeignKey relationships} to other DataSources, and other metadata. <P> The
 * abstract object description provided by a DataSource is easily mapped to a variety of backend object models and storage
 * schemes.  The following table shows analogous terminology across systems. <table border=1 class="normal"> <tr>  
 * <td>Isomorphic Smart GWT</td>   <td>Relational Database</td>   <td>Enterprise Java Beans (EJB)</td>  
 * <td>Entity/Relationship Modeling</td>   <td>OO/UML</td>   <td>XML Schema/WSDL</td>   <td>LDAP</td> </tr><tr>  
 * <td>DataSource</td>   <td>Table</td>   <td>EJB class</td>   <td>Entity</td>   <td>Class</td>   <td>Element Schema
 * (ComplexType)</td>   <td>Objectclass</td> </tr><tr>   <td>Record</td>   <td>Row</td>   <td>EJB instance</td>  
 * <td>Entity instance</td>   <td>Class instance/Object</td>   <td>Element instance (ComplexType)</td>   <td>Entry</td>
 * </tr><tr>   <td>Field</td>   <td>Column</td>   <td>Property</td>   <td>Attribute</td>   <td>Property/Attribute</td>  
 * <td>Attribute or Element (SimpleType)</td>   <td>Attribute</td> </tr></table> <P> DataSources can be {@link
 * com.smartgwt.client.docs.DataSourceDeclaration declared} in either JavaScript or XML format, and can also be {@link
 * metadataImport imported} from existing metadata formats, including XML Schema. <P> <i>Data Binding</i> is the process by
 * which {@link com.smartgwt.client.widgets.DataBoundComponent Data Binding-capable UI components} can automatically
 * configure themselves for viewing, editing and saving data described by DataSources.  DataBinding is covered in the
 * ${isc.DocUtils.linkForDocNode('QuickStartGuide', 'QuickStart Guide')}, Chapter 6, <i>Data Binding</i>. <P> {@link
 * com.smartgwt.client.docs.ClientServerIntegration Data Integration} is the process by which a DataSource can be connected
 * to server systems such as SQL DataBases, Java Object models, WSDL web services and other data providers.  Data
 * Integration comes in two variants: client-side and server-side.  {@link com.smartgwt.client.docs.ServerDataIntegration
 * Server-side integration} uses the Smart GWT Java-based server to connect to data represented by Java Objects or
 * JDBC-accessible databases.  {@link com.smartgwt.client.docs.ClientDataIntegration Client-side integration} connects
 * Smart GWT DataSources to XML, JSON or other formats accessible via HTTP. <P> DataSources have a concept of {@link
 * com.smartgwt.client.docs.DataSourceOperations 4 core operations} ("fetch", "add", "update" and "remove") that can be
 * performed on the set of objects represented by a DataSource.  Once a DataSource has been integrated with your data
 * store, databinding-capable  UI components can leverage the 4 core DataSource operations to provide many complete user
 * interactions without the need to configure how each individual component loads and saves data. <P> These interactions
 * include {@link com.smartgwt.client.widgets.grid.ListGrid grid views}, {@link com.smartgwt.client.widgets.tree.TreeGrid
 * tree views},  {@link com.smartgwt.client.widgets.viewer.DetailViewer detail views}, {@link
 * com.smartgwt.client.widgets.form.DynamicForm form}-based  {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord
 * editing} and {@link com.smartgwt.client.widgets.form.DynamicForm#saveData saving}, grid-based {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit editing} and {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell saving}, and custom interactions provided by <a
 * href="http://www.smartclient.com/smartgwt/showcase/#pattern_reuse_grid_form_category" target="examples">Pattern Reuse
 * Example</a> custom databinding-capable components.
 * @see com.smartgwt.client.widgets.DataBoundComponent
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
        scClassName = "DataSource";
    }

    public DataSource(JavaScriptObject jsObj){
        super(jsObj);
    }

    public DataSource(String dataURL) {
        setDataURL(dataURL);
        scClassName = "DataSource";
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
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
     */
    public Boolean getAddGlobalId()  {
        return getAttributeAsBoolean("addGlobalId");
    }

    /**
     * When a DataSource is not {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData}:true and a fetch
     * results in the entire dataset being retrieved, this attribute being set to true causes the DataSource to automatically
     * switch to cacheAllData:true and prevent further server-trips for fetch  requests.
     *
     * @param autoCacheAllData autoCacheAllData Default value is false
     */
    public void setAutoCacheAllData(Boolean autoCacheAllData) {
        setAttribute("autoCacheAllData", autoCacheAllData, true);
    }

    /**
     * When a DataSource is not {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData}:true and a fetch
     * results in the entire dataset being retrieved, this attribute being set to true causes the DataSource to automatically
     * switch to cacheAllData:true and prevent further server-trips for fetch  requests.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoCacheAllData()  {
        return getAttributeAsBoolean("autoCacheAllData");
    }

    /**
     * Whether to convert relative date values to concrete date values before sending to the  server.  Default value is true,
     * which means that the server does not need to understand  how to filter using relative dates - it receives all date
     * values as absolute dates.
     *
     * @param autoConvertRelativeDates autoConvertRelativeDates Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setAutoConvertRelativeDates(Boolean autoConvertRelativeDates)  throws IllegalStateException {
        setAttribute("autoConvertRelativeDates", autoConvertRelativeDates, false);
    }

    /**
     * Whether to convert relative date values to concrete date values before sending to the  server.  Default value is true,
     * which means that the server does not need to understand  how to filter using relative dates - it receives all date
     * values as absolute dates.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoConvertRelativeDates()  {
        return getAttributeAsBoolean("autoConvertRelativeDates");
    }

    /**
     * If set, titles are automatically derived from {@link com.smartgwt.client.data.DataSourceField#getName field.name} for
     * any  field that does not have a {@link com.smartgwt.client.data.DataSourceField#getTitle field.title} and is not marked
     * {@link com.smartgwt.client.data.DataSourceField#getHidden hidden}:true, by calling the method {@link
     * com.smartgwt.client.data.DataSource#getAutoTitle DataSource.getAutoTitle}.
     *
     * @param autoDeriveTitles autoDeriveTitles Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setAutoDeriveTitles(Boolean autoDeriveTitles)  throws IllegalStateException {
        setAttribute("autoDeriveTitles", autoDeriveTitles, false);
    }

    /**
     * If set, titles are automatically derived from {@link com.smartgwt.client.data.DataSourceField#getName field.name} for
     * any  field that does not have a {@link com.smartgwt.client.data.DataSourceField#getTitle field.title} and is not marked
     * {@link com.smartgwt.client.data.DataSourceField#getHidden hidden}:true, by calling the method {@link
     * com.smartgwt.client.data.DataSource#getAutoTitle DataSource.getAutoTitle}.
     *
     *
     * @return Boolean
     */
    public Boolean getAutoDeriveTitles()  {
        return getAttributeAsBoolean("autoDeriveTitles");
    }

    /**
     * Set this property to true to have a DataSource fetch all of it's data client-side on the  first fetch request.  However,
     * unlike a {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly} DataSource, this DataSource  will still
     * save changes normally, sending remote requests. <P> You can manually set this attribute after initialization by calling 
     * {@link com.smartgwt.client.data.DataSource#setCacheAllData DataSource.setCacheAllData} and setting {@link
     * com.smartgwt.client.data.DataSource#getAutoCacheAllData autoCacheAllData}:true causes a DataSource to  automatically
     * switch to <code>cacheAllData:true</> when a fetch results in the entire  dataset being brought client-side. <P> To cause
     * automatic cache updates, you can set {@link com.smartgwt.client.data.DataSource#getCacheMaxAge cacheMaxAge} to a number
     * of seconds and once data has been client-side for that length of time, the next fetch causes the cache to be dropped and
     * a new cache retrieved.
     * Call this method to switch cacheAllData on or off after initialization.  Passing a  <code>shouldCache</code> value of false clears any existing client-side cache, cancels any outstanding requests for a full cache and issues any other pending requests normally.
     *
     * @param cacheAllData New value for {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData}. Default value is null
     */
    public void setCacheAllData(Boolean cacheAllData) {
        setAttribute("cacheAllData", cacheAllData, true);
    }

    /**
     * Set this property to true to have a DataSource fetch all of it's data client-side on the  first fetch request.  However,
     * unlike a {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly} DataSource, this DataSource  will still
     * save changes normally, sending remote requests. <P> You can manually set this attribute after initialization by calling 
     * {@link com.smartgwt.client.data.DataSource#setCacheAllData DataSource.setCacheAllData} and setting {@link
     * com.smartgwt.client.data.DataSource#getAutoCacheAllData autoCacheAllData}:true causes a DataSource to  automatically
     * switch to <code>cacheAllData:true</> when a fetch results in the entire  dataset being brought client-side. <P> To cause
     * automatic cache updates, you can set {@link com.smartgwt.client.data.DataSource#getCacheMaxAge cacheMaxAge} to a number
     * of seconds and once data has been client-side for that length of time, the next fetch causes the cache to be dropped and
     * a new cache retrieved.
     *
     *
     * @return Boolean
     */
    public Boolean getCacheAllData()  {
        return getAttributeAsBoolean("cacheAllData");
    }

    /**
     * For a {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} or client-only DataSource, a set of
     * records to use as a dataset,  specified as an Array of JavaScript Objects representing records.
     * Call this method to set the data in the client-side cache after initialization.
     *
     * @param cacheData Array of records to apply as the client-side cache. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setCacheData(Record... cacheData)  throws IllegalStateException {
        setAttribute("cacheData", cacheData, false);
    }

    /**
     * For a {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} or client-only DataSource, a set of
     * records to use as a dataset,  specified as an Array of JavaScript Objects representing records.
     *
     *
     * @return Record
     */
    public Record[] getCacheData()  {
        return Record.convertToRecordArray(getAttributeAsJavaScriptObject("cacheData"));
    }

    /**
     * The maximum time, in seconds, to maintain the client-side cache.  If a fetch occurs after the cacheMaxAge has expired,
     * the current cache will be dropped and another complete cache fetched.
     *
     * @param cacheMaxAge cacheMaxAge Default value is 60
     */
    public void setCacheMaxAge(int cacheMaxAge) {
        setAttribute("cacheMaxAge", cacheMaxAge, true);
    }

    /**
     * The maximum time, in seconds, to maintain the client-side cache.  If a fetch occurs after the cacheMaxAge has expired,
     * the current cache will be dropped and another complete cache fetched.
     *
     *
     * @return int
     */
    public int getCacheMaxAge()  {
        return getAttributeAsInt("cacheMaxAge");
    }

    /**
     * Applies only to dataFormat: "json".  Specifies the name of the query parameter that tells your JSON service what
     * function to call as part of the response.
     *
     * @param callbackParam callbackParam Default value is "callback"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.data.DataSource#setDataFormat
     * @see com.smartgwt.client.data.DataSource#setOperationBindings
     * @see com.smartgwt.client.data.OperationBinding#setCallbackParam
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#edit_save_xml_integration_category" target="examples">Edit and Save Example</a>
     */
    public void setCallbackParam(String callbackParam)  throws IllegalStateException {
        setAttribute("callbackParam", callbackParam, false);
    }

    /**
     * Applies only to dataFormat: "json".  Specifies the name of the query parameter that tells your JSON service what
     * function to call as part of the response.
     *
     *
     * @return String
     * @see com.smartgwt.client.data.DataSource#getDataFormat
     * @see com.smartgwt.client.data.DataSource#getOperationBindings
     * @see com.smartgwt.client.data.OperationBinding#getCallbackParam
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#edit_save_xml_integration_category" target="examples">Edit and Save Example</a>
     */
    public String getCallbackParam()  {
        return getAttributeAsString("callbackParam");
    }

    /**
     * When true, indicates that this DataSource supports multi-level sorting.
     *
     * @param canMultiSort canMultiSort Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setCanMultiSort(Boolean canMultiSort)  throws IllegalStateException {
        setAttribute("canMultiSort", canMultiSort, false);
    }

    /**
     * When true, indicates that this DataSource supports multi-level sorting.
     *
     *
     * @return Boolean
     */
    public Boolean getCanMultiSort()  {
        return getAttributeAsBoolean("canMultiSort");
    }

    /**
     * fieldName for a field in the dataSource expected to contain an explicit array of child nodes.&#010 Enables loading a
     * databound tree as a hierarchical data structure, rather than a flat list of&#010 nodes linked by foreignKey.<br>&#010
     * Note this is an alternative to setting {@link com.smartgwt.client.data.DataSourceField#getChildrenProperty
     * childrenProperty} directly on&#010 the childrenField object.<P>&#010 By default the children field will be assumed to be
     * {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple},&#010 for XML databinding. This implies that child
     * data should be delivered in the format:&#010 <pre>&#010      &lt;childrenFieldName&gt;&#010          &lt;item
     * name="firstChild" ...&gt;&#010          &lt;item name="secondChild" ...&gt;&#010      &lt;/childrenFieldName&gt;&#010
     * </pre>&#010 However data may also be delivered as a direct list of <code>childrenFieldName</code> &#010 elements:&#010
     * <pre>&#010      &lt;childrenFieldName name="firstChild" ...&gt;&#010      &lt;childrenFieldName name="secondChild"
     * ...&gt;&#010 </pre>&#010 If you want to return your data in this format, you will need to explicitly set &#010
     * <code>multiple</code> to false in the appropriate dataSource field definition.
     *
     * @param childrenField childrenField Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.data.DataSourceField#setChildrenProperty
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public void setChildrenField(String childrenField)  throws IllegalStateException {
        setAttribute("childrenField", childrenField, false);
    }

    /**
     * fieldName for a field in the dataSource expected to contain an explicit array of child nodes.&#010 Enables loading a
     * databound tree as a hierarchical data structure, rather than a flat list of&#010 nodes linked by foreignKey.<br>&#010
     * Note this is an alternative to setting {@link com.smartgwt.client.data.DataSourceField#getChildrenProperty
     * childrenProperty} directly on&#010 the childrenField object.<P>&#010 By default the children field will be assumed to be
     * {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple},&#010 for XML databinding. This implies that child
     * data should be delivered in the format:&#010 <pre>&#010      &lt;childrenFieldName&gt;&#010          &lt;item
     * name="firstChild" ...&gt;&#010          &lt;item name="secondChild" ...&gt;&#010      &lt;/childrenFieldName&gt;&#010
     * </pre>&#010 However data may also be delivered as a direct list of <code>childrenFieldName</code> &#010 elements:&#010
     * <pre>&#010      &lt;childrenFieldName name="firstChild" ...&gt;&#010      &lt;childrenFieldName name="secondChild"
     * ...&gt;&#010 </pre>&#010 If you want to return your data in this format, you will need to explicitly set &#010
     * <code>multiple</code> to false in the appropriate dataSource field definition.
     *
     *
     * @return String
     * @see com.smartgwt.client.data.DataSourceField#getChildrenProperty
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public String getChildrenField()  {
        return getAttributeAsString("childrenField");
    }

    /**
     * Whether to act as a "client-only" DataSource, which has no permanent storage and never contacts the server, instead
     * using a set of test data to respond to requests in the same manner as a server-based DataSource might. <P> Note that a
     * client-only DataSource is an entirely client-side variant of a {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} DataSource, where all operations are performed on
     * client-side data, not just fetches. <P> See {@link com.smartgwt.client.docs.ClientOnlyDataSources this discussion} for
     * ways to populate a client-only DataSource with test data.
     * Switch into clientOnly mode, taking the cache from the cacheAllData ResultSet if it  exists.
     *
     * @param clientOnly clientOnly Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.ClientOnlyDataSources ClientOnlyDataSources overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_local_datasource" target="examples">Local DataSource Example</a>
     */
    public void setClientOnly(Boolean clientOnly)  throws IllegalStateException {
        setAttribute("clientOnly", clientOnly, false);
    }

    /**
     * Whether to act as a "client-only" DataSource, which has no permanent storage and never contacts the server, instead
     * using a set of test data to respond to requests in the same manner as a server-based DataSource might. <P> Note that a
     * client-only DataSource is an entirely client-side variant of a {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} DataSource, where all operations are performed on
     * client-side data, not just fetches. <P> See {@link com.smartgwt.client.docs.ClientOnlyDataSources this discussion} for
     * ways to populate a client-only DataSource with test data.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ClientOnlyDataSources ClientOnlyDataSources overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_local_datasource" target="examples">Local DataSource Example</a>
     */
    public Boolean getClientOnly()  {
        return getAttributeAsBoolean("clientOnly");
    }

    /**
     * Decides under what conditions the {@link com.smartgwt.client.data.ResultSet} cache should be dropped when the {@link
     * com.smartgwt.client.data.ResultSet#getCriteria criteria} changes.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param criteriaPolicy criteriaPolicy Default value is "dropOnShortening"
     * @see com.smartgwt.client.data.DataSource#compareCriteria
     */
    public void setCriteriaPolicy(CriteriaPolicy criteriaPolicy) {
        setAttribute("criteriaPolicy", criteriaPolicy.getValue(), true);
    }

    /**
     * Decides under what conditions the {@link com.smartgwt.client.data.ResultSet} cache should be dropped when the {@link
     * com.smartgwt.client.data.ResultSet#getCriteria criteria} changes.
     *
     *
     * @return CriteriaPolicy
     * @see com.smartgwt.client.data.DataSource#compareCriteria
     */
    public CriteriaPolicy getCriteriaPolicy()  {
        return EnumUtil.getEnum(CriteriaPolicy.values(), getAttribute("criteriaPolicy"));
    }

    /**
     * Name of the field that has the most pertinent numeric, date, or enum value, for use when a {@link
     * com.smartgwt.client.widgets.DataBoundComponent} needs to show a short summary of a record. <P> For example, for a
     * DataSource of employees, good choices might be the "salary" field, "hire date" or "status" (active, vacation, on leave,
     * etc). <p> Unlike {@link com.smartgwt.client.data.DataSource#getTitleField titleField}, dataField is not automatically
     * determined in the absence of an explicit setting.
     *
     * @param dataField dataField Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public void setDataField(String dataField)  throws IllegalStateException {
        setAttribute("dataField", dataField, false);
    }

    /**
     * Name of the field that has the most pertinent numeric, date, or enum value, for use when a {@link
     * com.smartgwt.client.widgets.DataBoundComponent} needs to show a short summary of a record. <P> For example, for a
     * DataSource of employees, good choices might be the "salary" field, "hire date" or "status" (active, vacation, on leave,
     * etc). <p> Unlike {@link com.smartgwt.client.data.DataSource#getTitleField titleField}, dataField is not automatically
     * determined in the absence of an explicit setting.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public String getDataField()  {
        return getAttributeAsString("dataField");
    }

    /**
     * Indicates the format to be used for HTTP requests and responses when fulfilling DSRequests (eg, when {@link
     * com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} is called).
     *
     * @param dataFormat dataFormat Default value is "iscServer"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_json_datasource" target="examples">JSON DataSource Example</a>
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#json_integration_category_simple" target="examples">Simple JSON Example</a>
     */
    public void setDataFormat(DSDataFormat dataFormat)  throws IllegalStateException {
        setAttribute("dataFormat", dataFormat.getValue(), false);
    }

    /**
     * Indicates the format to be used for HTTP requests and responses when fulfilling DSRequests (eg, when {@link
     * com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} is called).
     *
     *
     * @return DSDataFormat
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_json_datasource" target="examples">JSON DataSource Example</a>
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#json_integration_category_simple" target="examples">Simple JSON Example</a>
     */
    public DSDataFormat getDataFormat()  {
        return EnumUtil.getEnum(DSDataFormat.values(), getAttribute("dataFormat"));
    }

    /**
     * Transport to use for all operations on this DataSource. Defaults to {@link
     * com.smartgwt.client.rpc.RPCManager#defaultTransport defaultTransport}.  This would typically only be set to enable
     * "scriptInclude" transport for contacting {@link com.smartgwt.client.data.DataSource#getDataFormat JSON} web services
     * hosted on servers other than the origin server. <p> When using the "scriptInclude" transport, be sure to set {@link
     * com.smartgwt.client.data.DataSource#getCallbackParam callbackParam} or {@link
     * com.smartgwt.client.data.OperationBinding#getCallbackParam callbackParam} to match the name of the query parameter name
     * expected by your JSON service provider.
     *
     * @param dataTransport dataTransport Default value is RPCManager.defaultTransport
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.types.RPCTransport
     * @see com.smartgwt.client.data.DataSource#setCallbackParam
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public void setDataTransport(RPCTransport dataTransport)  throws IllegalStateException {
        setAttribute("dataTransport", dataTransport.getValue(), false);
    }

    /**
     * Transport to use for all operations on this DataSource. Defaults to {@link
     * com.smartgwt.client.rpc.RPCManager#defaultTransport defaultTransport}.  This would typically only be set to enable
     * "scriptInclude" transport for contacting {@link com.smartgwt.client.data.DataSource#getDataFormat JSON} web services
     * hosted on servers other than the origin server. <p> When using the "scriptInclude" transport, be sure to set {@link
     * com.smartgwt.client.data.DataSource#getCallbackParam callbackParam} or {@link
     * com.smartgwt.client.data.OperationBinding#getCallbackParam callbackParam} to match the name of the query parameter name
     * expected by your JSON service provider.
     *
     *
     * @return RPCTransport
     * @see com.smartgwt.client.types.RPCTransport
     * @see com.smartgwt.client.data.DataSource#getCallbackParam
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public RPCTransport getDataTransport()  {
        return EnumUtil.getEnum(RPCTransport.values(), getAttribute("dataTransport"));
    }

    /**
     * Default URL to contact to fulfill all DSRequests.  Can also be set on a per-operationType basis via {@link
     * com.smartgwt.client.data.OperationBinding#getDataURL dataURL}. <P> NOTE: Best practice is to use the same
     * <code>dataURL</code> for all DataSources which fulfill DSRequests via the server-side RPCManager API.  Otherwise,
     * cross-DataSource {@link com.smartgwt.client.rpc.RPCManager#startQueue operation queuing} will not be possible.
     *
     * @param dataURL dataURL Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_json_datasource" target="examples">JSON DataSource Example</a>
     */
    public void setDataURL(String dataURL)  throws IllegalStateException {
        setAttribute("dataURL", dataURL, false);
    }

    /**
     * Default URL to contact to fulfill all DSRequests.  Can also be set on a per-operationType basis via {@link
     * com.smartgwt.client.data.OperationBinding#getDataURL dataURL}. <P> NOTE: Best practice is to use the same
     * <code>dataURL</code> for all DataSources which fulfill DSRequests via the server-side RPCManager API.  Otherwise,
     * cross-DataSource {@link com.smartgwt.client.rpc.RPCManager#startQueue operation queuing} will not be possible.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_json_datasource" target="examples">JSON DataSource Example</a>
     */
    public String getDataURL()  {
        return getAttributeAsString("dataURL");
    }

    /**
     * Name of the field that has a long description of the record, or has the primary text data value for a record that
     * represents an email message, SMS, log or similar. <p> For example, for a DataSource representing employees, a field
     * containing the employee's "bio" might be a good choice, or for an email message, the message body. <p> If
     * descriptionField is unset, it defaults to any field named "description" or "desc" in the record, or the first long text
     * field (greater than 255 characters) in the record, or null if no such field exists.
     *
     * @param descriptionField descriptionField Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public void setDescriptionField(String descriptionField)  throws IllegalStateException {
        setAttribute("descriptionField", descriptionField, false);
    }

    /**
     * Name of the field that has a long description of the record, or has the primary text data value for a record that
     * represents an email message, SMS, log or similar. <p> For example, for a DataSource representing employees, a field
     * containing the employee's "bio" might be a good choice, or for an email message, the message body. <p> If
     * descriptionField is unset, it defaults to any field named "description" or "desc" in the record, or the first long text
     * field (greater than 255 characters) in the record, or null if no such field exists.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public String getDescriptionField()  {
        return getAttributeAsString("descriptionField");
    }

    /**
     * Indicates that for server responses, for any data being interpreted as DataSource records,  only data that corresponds
     * to declared fields should be retained; any extra fields should be discarded. <P> For {@link
     * com.smartgwt.client.data.DataSource#getDataFormat JSON} data, this means extra properties in selected objects are
     * dropped. <P> By default, for DMI DSResponses, DSResponse.data is filtered on the server to just the set of fields
     * defined on the DataSource.  This type of filtering can also be enabled for non-DMI DSResponses (see the overview in
     * {@link com.smartgwt.client.data.DataSource#getDmiOverview DMI}).  Setting this property to <code>false</code> disables
     * this filtering for this DataSource only.  This setting overrides the configuration in <code>server.properties</code>. 
     * This setting can be overridden by {@link com.smartgwt.client.docs.serverds.ServerObject#dropExtraFields
     * dropExtraFields}.
     *
     * @param dropExtraFields dropExtraFields Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public void setDropExtraFields(Boolean dropExtraFields)  throws IllegalStateException {
        setAttribute("dropExtraFields", dropExtraFields, false);
    }

    /**
     * Indicates that for server responses, for any data being interpreted as DataSource records,  only data that corresponds
     * to declared fields should be retained; any extra fields should be discarded. <P> For {@link
     * com.smartgwt.client.data.DataSource#getDataFormat JSON} data, this means extra properties in selected objects are
     * dropped. <P> By default, for DMI DSResponses, DSResponse.data is filtered on the server to just the set of fields
     * defined on the DataSource.  This type of filtering can also be enabled for non-DMI DSResponses (see the overview in
     * {@link com.smartgwt.client.data.DataSource#getDmiOverview DMI}).  Setting this property to <code>false</code> disables
     * this filtering for this DataSource only.  This setting overrides the configuration in <code>server.properties</code>. 
     * This setting can be overridden by {@link com.smartgwt.client.docs.serverds.ServerObject#dropExtraFields
     * dropExtraFields}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public Boolean getDropExtraFields()  {
        return getAttributeAsBoolean("dropExtraFields");
    }

    /**
     * The name of the property this DataSource uses for constant name when translating Java enumerated types to and from
     * Javascript, if the {@link com.smartgwt.client.types.EnumTranslateStrategy} is set to "bean".  Defaults to "_constant" if
     * not set. <p>  This property is only applicable if you are using the Smart GWT server
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param enumConstantProperty enumConstantProperty Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEnumConstantProperty(String enumConstantProperty)  throws IllegalStateException {
        setAttribute("enumConstantProperty", enumConstantProperty, false);
    }

    /**
     * The name of the property this DataSource uses for ordinal number when translating Java enumerated types to and from
     * Javascript, if the {@link com.smartgwt.client.types.EnumTranslateStrategy} is set to "bean".  Defaults to "_ordinal" if
     * not set. <p>  This property is only applicable if you are using the Smart GWT server
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param enumOrdinalProperty enumOrdinalProperty Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEnumOrdinalProperty(String enumOrdinalProperty)  throws IllegalStateException {
        setAttribute("enumOrdinalProperty", enumOrdinalProperty, false);
    }

    /**
     * Sets the strategy this DataSource uses to translate Java enumerated types (objects of type enum) to and from Javascript.
     *  This property is only applicable if you are using the Smart GWT server
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param enumTranslateStrategy enumTranslateStrategy Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEnumTranslateStrategy(EnumTranslateStrategy enumTranslateStrategy)  throws IllegalStateException {
        setAttribute("enumTranslateStrategy", enumTranslateStrategy.getValue(), false);
    }

    /**
     * Namespaces definitions to add to the root element of outbound XML messages sent to a web&#010 service, as a mapping from
     * namespace prefix to namespace URI.&#010 <P>&#010 The default value is:&#010 <pre>&#010   globalNamespaces : {&#010     
     * xsi: "http://www.w3.org/2001/XMLSchema-instance",&#010      xsd: "http://www.w3.org/2001/XMLSchema"&#010   },&#010
     * </pre>&#010 This default value allows the use of the xsi:type and xsi:nil attributes without further&#010
     * declarations.&#010 <P>&#010 Note that some web services will only accept specific revisions of the XML Schema URI.&#010
     * If xsi-namespaced attributes seem to be ignored by an older webservice, try the URI&#010
     * "http://www.w3.org/1999/XMLSchema-instance" instead.
     *
     * @param globalNamespaces globalNamespaces Default value is ...
     */
    public void setGlobalNamespaces(Map globalNamespaces) {
        setAttribute("globalNamespaces", globalNamespaces, true);
    }

    /**
     * Namespaces definitions to add to the root element of outbound XML messages sent to a web&#010 service, as a mapping from
     * namespace prefix to namespace URI.&#010 <P>&#010 The default value is:&#010 <pre>&#010   globalNamespaces : {&#010     
     * xsi: "http://www.w3.org/2001/XMLSchema-instance",&#010      xsd: "http://www.w3.org/2001/XMLSchema"&#010   },&#010
     * </pre>&#010 This default value allows the use of the xsi:type and xsi:nil attributes without further&#010
     * declarations.&#010 <P>&#010 Note that some web services will only accept specific revisions of the XML Schema URI.&#010
     * If xsi-namespaced attributes seem to be ignored by an older webservice, try the URI&#010
     * "http://www.w3.org/1999/XMLSchema-instance" instead.
     *
     *
     * @return Map
     */
    public Map getGlobalNamespaces()  {
        return getAttributeAsMap("globalNamespaces");
    }

    /**
     * Designates a field of {@link com.smartgwt.client.types.FieldType type}:"image" as the field to use when rendering a
     * record as an image, for example, in a {@link com.smartgwt.client.widgets.tile.TileGrid}. <p> For example, for a
     * DataSource of employees, a "photo" field of type "image" should be designated as the iconField. <p> If not explicitly
     * set, iconField looks for fields named "picture", "thumbnail", "icon", "image" and "img", in that order, and will use any
     * of these fields as the iconField if it exists and has type "image".  <P> To avoid any field being used as the iconField,
     * set iconField to <code>null</code>.
     *
     * @param iconField iconField Default value is see below
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public void setIconField(String iconField)  throws IllegalStateException {
        setAttribute("iconField", iconField, false);
    }

    /**
     * Designates a field of {@link com.smartgwt.client.types.FieldType type}:"image" as the field to use when rendering a
     * record as an image, for example, in a {@link com.smartgwt.client.widgets.tile.TileGrid}. <p> For example, for a
     * DataSource of employees, a "photo" field of type "image" should be designated as the iconField. <p> If not explicitly
     * set, iconField looks for fields named "picture", "thumbnail", "icon", "image" and "img", in that order, and will use any
     * of these fields as the iconField if it exists and has type "image".  <P> To avoid any field being used as the iconField,
     * set iconField to <code>null</code>.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public String getIconField()  {
        return getAttributeAsString("iconField");
    }

    /**
     * Name of the field that has the second most pertinent piece of textual information in the record, for use when a {@link
     * com.smartgwt.client.widgets.DataBoundComponent} needs to show a short summary of a record. <p> For example, for a
     * DataSource of employees, a "job title" field would probably be the second most pertinent text field aside from the
     * employee's "full name". <p> Unlike {@link com.smartgwt.client.data.DataSource#getTitleField titleField}, infoField is
     * not automatically determined in the absence of an explicit setting.
     *
     * @param infoField infoField Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public void setInfoField(String infoField)  throws IllegalStateException {
        setAttribute("infoField", infoField, false);
    }

    /**
     * Name of the field that has the second most pertinent piece of textual information in the record, for use when a {@link
     * com.smartgwt.client.widgets.DataBoundComponent} needs to show a short summary of a record. <p> For example, for a
     * DataSource of employees, a "job title" field would probably be the second most pertinent text field aside from the
     * employee's "full name". <p> Unlike {@link com.smartgwt.client.data.DataSource#getTitleField titleField}, infoField is
     * not automatically determined in the absence of an explicit setting.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public String getInfoField()  {
        return getAttributeAsString("infoField");
    }

    /**
     * ID of another DataSource this DataSource inherits its {@link com.smartgwt.client.data.DataSource#getFields fields} from.
     * <P> Local fields (fields defined in this DataSource) are added to inherited fields  to form the full set of fields. 
     * Fields with the same name are merged in the same way that {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getFields databound component fields} are merged with DataSource fields.
     * <P> The default order of the combined fields is new local fields first (including any fields present in the parent
     * DataSource which the local DataSource re-declares), then parent fields.  You can set {@link
     * com.smartgwt.client.data.DataSource#getUseParentFieldOrder useParentFieldOrder} to instead use the parent's field order,
     * with new local fields appearing last.  You can set {@link com.smartgwt.client.data.DataSource#getShowLocalFieldsOnly
     * showLocalFieldsOnly} to have all non-local fields hidden. <P> Note that <b>only fields are inherited</b> - other
     * properties such as dataURL and dataFormat are not.  You can use ordinary inheritance, that is, creating a subclass of
     * DataSource, in order to share properties such as dataURL across a series of DataSources that also inherit fields from
     * each other via <code>inheritsFrom</code>. <P> This feature can be used for: <ul> <li>creating a customized view (eg,
     * only certain fields shown) which will be used by multiple {@link com.smartgwt.client.widgets.DataBoundComponent
     * databound components}. <li>adding presentation-specific attributes to metadata that has been automatically derived from
     * {@link com.smartgwt.client.data.XMLTools#loadXMLSchema XML Schema} or other metadata formats <li>modeling object
     * subclassing and extension in server-side code and storage systems <li>modeling relational database joins, and the
     * equivalents in other systems <li>creating hooks for others to customize your application in a maintainable way.  For
     * example, if you have a dataSource "employee", you can create a dataSource "customizedEmployee" which inherits from
     * "employee" but does not initially define any fields, and bind all {@link com.smartgwt.client.widgets.DataBoundComponent
     * databound components} to "customizedEmployee".  Customizations of fields (including appearance changes, field order, new
     * fields, hiding of fields, and custom validation rules) can be added to "customizedEmployee", so that they are kept
     * separately from the original field data and have the best possible chance of working with future versions of the
     * "employee" dataSource. </ul>
     *
     * @param inheritsFrom inheritsFrom Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#featured-xsd-ds" target="examples">Schema Chaining Example</a>
     */
    public void setInheritsFrom(String inheritsFrom)  throws IllegalStateException {
        setAttribute("inheritsFrom", inheritsFrom, false);
    }

    /**
     * ID of another DataSource this DataSource inherits its {@link com.smartgwt.client.data.DataSource#getFields fields} from.
     * <P> Local fields (fields defined in this DataSource) are added to inherited fields  to form the full set of fields. 
     * Fields with the same name are merged in the same way that {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getFields databound component fields} are merged with DataSource fields.
     * <P> The default order of the combined fields is new local fields first (including any fields present in the parent
     * DataSource which the local DataSource re-declares), then parent fields.  You can set {@link
     * com.smartgwt.client.data.DataSource#getUseParentFieldOrder useParentFieldOrder} to instead use the parent's field order,
     * with new local fields appearing last.  You can set {@link com.smartgwt.client.data.DataSource#getShowLocalFieldsOnly
     * showLocalFieldsOnly} to have all non-local fields hidden. <P> Note that <b>only fields are inherited</b> - other
     * properties such as dataURL and dataFormat are not.  You can use ordinary inheritance, that is, creating a subclass of
     * DataSource, in order to share properties such as dataURL across a series of DataSources that also inherit fields from
     * each other via <code>inheritsFrom</code>. <P> This feature can be used for: <ul> <li>creating a customized view (eg,
     * only certain fields shown) which will be used by multiple {@link com.smartgwt.client.widgets.DataBoundComponent
     * databound components}. <li>adding presentation-specific attributes to metadata that has been automatically derived from
     * {@link com.smartgwt.client.data.XMLTools#loadXMLSchema XML Schema} or other metadata formats <li>modeling object
     * subclassing and extension in server-side code and storage systems <li>modeling relational database joins, and the
     * equivalents in other systems <li>creating hooks for others to customize your application in a maintainable way.  For
     * example, if you have a dataSource "employee", you can create a dataSource "customizedEmployee" which inherits from
     * "employee" but does not initially define any fields, and bind all {@link com.smartgwt.client.widgets.DataBoundComponent
     * databound components} to "customizedEmployee".  Customizations of fields (including appearance changes, field order, new
     * fields, hiding of fields, and custom validation rules) can be added to "customizedEmployee", so that they are kept
     * separately from the original field data and have the best possible chance of working with future versions of the
     * "employee" dataSource. </ul>
     *
     *
     * @return String
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#featured-xsd-ds" target="examples">Schema Chaining Example</a>
     */
    public String getInheritsFrom()  {
        return getAttributeAsString("inheritsFrom");
    }

    /**
     * Allows you to specify an arbitrary prefix string to apply to all json format responses  sent from the server to this
     * application. <P> The inclusion of such a prefix ensures your code is not directly executable outside of your
     * application, as a preventative measure against <a href='http://www.google.com/search?q=javascript+hijacking'
     * onclick="window.open('http://www.google.com/search?q=javascript+hijacking');return false;">javascript hijacking</a>. <P>
     * Only applies to responses formatted as json objects. Does not apply to responses returned via scriptInclude type
     * transport.<br> Note: If the prefix / suffix served by your backend is not a constant, you can use  {@link
     * com.smartgwt.client.data.OperationBinding#getDataFormat dataFormat:"custom"} instead and explicitly parse the prefix out
     * as part of {@link com.smartgwt.client.data.DataSource#transformResponse transformResponse()}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param jsonPrefix jsonPrefix Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.data.OperationBinding#setDataFormat
     * @see com.smartgwt.client.data.OperationBinding#setDataTransport
     */
    public void setJsonPrefix(String jsonPrefix)  throws IllegalStateException {
        setAttribute("jsonPrefix", jsonPrefix, false);
    }

    /**
     * Allows you to specify an arbitrary prefix string to apply to all json format responses  sent from the server to this
     * application. <P> The inclusion of such a prefix ensures your code is not directly executable outside of your
     * application, as a preventative measure against <a href='http://www.google.com/search?q=javascript+hijacking'
     * onclick="window.open('http://www.google.com/search?q=javascript+hijacking');return false;">javascript hijacking</a>. <P>
     * Only applies to responses formatted as json objects. Does not apply to responses returned via scriptInclude type
     * transport.<br> Note: If the prefix / suffix served by your backend is not a constant, you can use  {@link
     * com.smartgwt.client.data.OperationBinding#getDataFormat dataFormat:"custom"} instead and explicitly parse the prefix out
     * as part of {@link com.smartgwt.client.data.DataSource#transformResponse transformResponse()}.
     *
     *
     * @return String
     * @see com.smartgwt.client.data.OperationBinding#getDataFormat
     * @see com.smartgwt.client.data.OperationBinding#getDataTransport
     */
    public String getJsonPrefix()  {
        return getAttributeAsString("jsonPrefix");
    }

    /**
     * Allows you to specify an arbitrary suffix string to apply to all json format responses  sent from the server to this
     * application. <P> The inclusion of such a suffix ensures your code is not directly executable outside of your
     * application, as a preventative measure against <a href='http://www.google.com/search?q=javascript+hijacking'
     * onclick="window.open('http://www.google.com/search?q=javascript+hijacking');return false;">javascript hijacking</a>. <P>
     * Only applies to responses formatted as json objects. Does not apply to responses returned via scriptInclude type
     * transport.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param jsonSuffix jsonSuffix Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.data.OperationBinding#setDataFormat
     * @see com.smartgwt.client.data.OperationBinding#setDataTransport
     */
    public void setJsonSuffix(String jsonSuffix)  throws IllegalStateException {
        setAttribute("jsonSuffix", jsonSuffix, false);
    }

    /**
     * Allows you to specify an arbitrary suffix string to apply to all json format responses  sent from the server to this
     * application. <P> The inclusion of such a suffix ensures your code is not directly executable outside of your
     * application, as a preventative measure against <a href='http://www.google.com/search?q=javascript+hijacking'
     * onclick="window.open('http://www.google.com/search?q=javascript+hijacking');return false;">javascript hijacking</a>. <P>
     * Only applies to responses formatted as json objects. Does not apply to responses returned via scriptInclude type
     * transport.
     *
     *
     * @return String
     * @see com.smartgwt.client.data.OperationBinding#getDataFormat
     * @see com.smartgwt.client.data.OperationBinding#getDataTransport
     */
    public String getJsonSuffix()  {
        return getAttributeAsString("jsonSuffix");
    }

    /**
     * Optional array of OperationBindings, which provide instructions to the DataSource about how each&#010 DSOperation is to
     * be performed.&#010 <P>&#010 When using the Smart GWT Server, OperationBindings are specified in your DataSource&#010
     * descriptor (.ds.xml file) and control server-side behavior such as what Java object to route&#010 DSRequest to ({@link
     * com.smartgwt.client.docs.serverds.OperationBinding#serverObject serverObject}) or customizations to SQL / HQL
     * queries&#010 ({@link com.smartgwt.client.data.OperationBinding#getCustomSQL customSQL} and {@link
     * com.smartgwt.client.data.OperationBinding#getCustomHQL customHQL}).  See the &#010 @see <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#javaDataIntegration" target="examples">Java Integration
     * samples</a>.&#010 <P>&#010 For DataSources bound to WSDL-described web services using&#010 {@link
     * com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace}, OperationBindings are used to bind each
     * DataSource&#010 {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} to an&#010 {@link
     * com.smartgwt.client.data.OperationBinding#getWsOperation operation} of a WSDL-described &#010 {@link
     * com.smartgwt.client.data.WebService web service}, so that a DataSource can both fetch and save data to a web&#010
     * service.&#010 <P>&#010 For example, this code accomplishes part of the binding to the &#010 <a
     * href='http://www.google.com/search?q=sforce+partner+wsdl'
     * onclick="window.open('http://www.google.com/search?q=sforce+partner+wsdl');return false;">SalesForce partner web
     * services</a>&#010 <pre>&#010 isc.DataSource.create({&#010    serviceNamespace : "urn:partner.soap.sforce.com",&#010   
     * operationBindings : [&#010        { operationType:"fetch", wsOperation:"query", recordName: "sObject" },&#010        {
     * operationType:"update", wsOperation:"update", recordName: "SaveResult" },&#010        { operationType:"add",
     * wsOperation:"create", recordName: "SaveResult" },&#010        { operationType:"remove", wsOperation:"delete",
     * recordName: "DeleteResult" }&#010    ],&#010    ...&#010 }); &#010 </pre>&#010 NOTE: additional code is required to
     * handle authentication and other details, see the&#010 complete code in
     * smartclientSDK/examples/databinding/SalesForce.&#010 <P>&#010 For DataSources that contact non-WSDL-described XML or
     * JSON services, OperationBindings can&#010 be used to separately configure the URL, HTTP method, input and output
     * processing for each&#010 operationType.  This makes it possible to fetch JSON data from one URL for the "fetch"&#010
     * operationType and save to a web service for the "update" operationType, while appearing as a&#010 single integrated
     * DataSource to a {@link com.smartgwt.client.widgets.DataBoundComponent} such as an&#010 {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit editable ListGrid}.&#010 <P>&#010 If no operationBinding is defined
     * for a given DataSource operation, all of the properties&#010 which are valid on the operationBinding are checked for on
     * the DataSource itself.  &#010 <P>&#010 This also means that for a read-only DataSource, that is, a DataSource only
     * capable of fetch&#010 operations, operationBindings need not be specified, and instead all operationBinding&#010
     * properties can be set on the DataSource itself.  An example of using OperationBinding&#010 properties directly on the
     * DataSource in order to read an RSS feed can be found here:&#010 <P>&#010
     * ${isc.DocUtils.linkForStandaloneExample('/examples/databinding/rss_databinding.html',
     * '/examples/databinding/rss_databinding.html')}
     *
     * @param operationBindings operationBindings Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.data.OperationBinding
     */
    public void setOperationBindings(OperationBinding... operationBindings)  throws IllegalStateException {
        setAttribute("operationBindings", operationBindings, false);
    }

    /**
     * Optional array of OperationBindings, which provide instructions to the DataSource about how each&#010 DSOperation is to
     * be performed.&#010 <P>&#010 When using the Smart GWT Server, OperationBindings are specified in your DataSource&#010
     * descriptor (.ds.xml file) and control server-side behavior such as what Java object to route&#010 DSRequest to ({@link
     * com.smartgwt.client.docs.serverds.OperationBinding#serverObject serverObject}) or customizations to SQL / HQL
     * queries&#010 ({@link com.smartgwt.client.data.OperationBinding#getCustomSQL customSQL} and {@link
     * com.smartgwt.client.data.OperationBinding#getCustomHQL customHQL}).  See the &#010 @see <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#javaDataIntegration" target="examples">Java Integration
     * samples</a>.&#010 <P>&#010 For DataSources bound to WSDL-described web services using&#010 {@link
     * com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace}, OperationBindings are used to bind each
     * DataSource&#010 {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} to an&#010 {@link
     * com.smartgwt.client.data.OperationBinding#getWsOperation operation} of a WSDL-described &#010 {@link
     * com.smartgwt.client.data.WebService web service}, so that a DataSource can both fetch and save data to a web&#010
     * service.&#010 <P>&#010 For example, this code accomplishes part of the binding to the &#010 <a
     * href='http://www.google.com/search?q=sforce+partner+wsdl'
     * onclick="window.open('http://www.google.com/search?q=sforce+partner+wsdl');return false;">SalesForce partner web
     * services</a>&#010 <pre>&#010 isc.DataSource.create({&#010    serviceNamespace : "urn:partner.soap.sforce.com",&#010   
     * operationBindings : [&#010        { operationType:"fetch", wsOperation:"query", recordName: "sObject" },&#010        {
     * operationType:"update", wsOperation:"update", recordName: "SaveResult" },&#010        { operationType:"add",
     * wsOperation:"create", recordName: "SaveResult" },&#010        { operationType:"remove", wsOperation:"delete",
     * recordName: "DeleteResult" }&#010    ],&#010    ...&#010 }); &#010 </pre>&#010 NOTE: additional code is required to
     * handle authentication and other details, see the&#010 complete code in
     * smartclientSDK/examples/databinding/SalesForce.&#010 <P>&#010 For DataSources that contact non-WSDL-described XML or
     * JSON services, OperationBindings can&#010 be used to separately configure the URL, HTTP method, input and output
     * processing for each&#010 operationType.  This makes it possible to fetch JSON data from one URL for the "fetch"&#010
     * operationType and save to a web service for the "update" operationType, while appearing as a&#010 single integrated
     * DataSource to a {@link com.smartgwt.client.widgets.DataBoundComponent} such as an&#010 {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit editable ListGrid}.&#010 <P>&#010 If no operationBinding is defined
     * for a given DataSource operation, all of the properties&#010 which are valid on the operationBinding are checked for on
     * the DataSource itself.  &#010 <P>&#010 This also means that for a read-only DataSource, that is, a DataSource only
     * capable of fetch&#010 operations, operationBindings need not be specified, and instead all operationBinding&#010
     * properties can be set on the DataSource itself.  An example of using OperationBinding&#010 properties directly on the
     * DataSource in order to read an RSS feed can be found here:&#010 <P>&#010
     * ${isc.DocUtils.linkForStandaloneExample('/examples/databinding/rss_databinding.html',
     * '/examples/databinding/rss_databinding.html')}
     *
     *
     * @return OperationBinding
     * @see com.smartgwt.client.data.OperationBinding
     */
    public OperationBinding[] getOperationBindings()  {
        return OperationBinding.convertToOperationBindingArray(getAttributeAsJavaScriptObject("operationBindings"));
    }

    /**
     * User-visible plural name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply Items". <P>
     * Defaults to (<code>dataSource.title</code> or <code>dataSource.ID</code>) + "s".
     *
     * @param pluralTitle pluralTitle Default value is dataSource.ID
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setPluralTitle(String pluralTitle)  throws IllegalStateException {
        setAttribute("pluralTitle", pluralTitle, false);
    }

    /**
     * User-visible plural name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply Items". <P>
     * Defaults to (<code>dataSource.title</code> or <code>dataSource.ID</code>) + "s".
     *
     *
     * @return String
     */
    public String getPluralTitle()  {
        return getAttributeAsString("pluralTitle");
    }

    /**
     * If set, the DataSource will ensure that it never uses a cached HTTP response, even if the server marks the response as
     * cacheable. <P> Note that this does not disable caching at higher levels in the framework, for example, the caching
     * performed by {@link com.smartgwt.client.data.ResultSet}.
     *
     * @param preventHTTPCaching preventHTTPCaching Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setPreventHTTPCaching(Boolean preventHTTPCaching)  throws IllegalStateException {
        setAttribute("preventHTTPCaching", preventHTTPCaching, false);
    }

    /**
     * If set, the DataSource will ensure that it never uses a cached HTTP response, even if the server marks the response as
     * cacheable. <P> Note that this does not disable caching at higher levels in the framework, for example, the caching
     * performed by {@link com.smartgwt.client.data.ResultSet}.
     *
     *
     * @return Boolean
     */
    public Boolean getPreventHTTPCaching()  {
        return getAttributeAsBoolean("preventHTTPCaching");
    }

    /**
     * For dataSources of {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType} "sql", determines whether
     * we qualify column names with table names in any SQL we generate.  This property can be overridden on specific
     * operationBindings.
     *
     * @param qualifyColumnNames qualifyColumnNames Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.serverds.OperationBinding#qualifyColumnNames
     */
    public void setQualifyColumnNames(Boolean qualifyColumnNames)  throws IllegalStateException {
        setAttribute("qualifyColumnNames", qualifyColumnNames, false);
    }

    /**
     * For dataSources of {@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType} "sql", determines whether
     * we qualify column names with table names in any SQL we generate.  This property can be overridden on specific
     * operationBindings.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.serverds.OperationBinding#qualifyColumnNames
     */
    public Boolean getQualifyColumnNames()  {
        return getAttributeAsBoolean("qualifyColumnNames");
    }

    /**
     * See {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}.  <code>recordXPath</code> can be
     * specified directly on the DataSource for a simple read-only DataSource only capable of "fetch" operations.
     *
     * @param recordXPath recordXPath Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_xml_datasource" target="examples">XML DataSource Example</a>
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#json_integration_category_xpath" target="examples">JSON XPath Binding Example</a>
     */
    public void setRecordXPath(String recordXPath)  throws IllegalStateException {
        setAttribute("recordXPath", recordXPath, false);
    }

    /**
     * See {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}.  <code>recordXPath</code> can be
     * specified directly on the DataSource for a simple read-only DataSource only capable of "fetch" operations.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_xml_datasource" target="examples">XML DataSource Example</a>
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#json_integration_category_xpath" target="examples">JSON XPath Binding Example</a>
     */
    public String getRecordXPath()  {
        return getAttributeAsString("recordXPath");
    }

    /**
     * Additional properties to pass through to the {@link com.smartgwt.client.data.DSRequest}s made by this DataSource. <p>
     * These properties are applied before {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest} is called.
     *
     * @param requestProperties requestProperties Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.data.DSRequest
     * @see com.smartgwt.client.data.OperationBinding#setRequestProperties
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public void setRequestProperties(DSRequest requestProperties)  throws IllegalStateException {
        setAttribute("requestProperties", requestProperties.getJsObj(), false);
    }

    /**
     * Additional properties to pass through to the {@link com.smartgwt.client.data.DSRequest}s made by this DataSource. <p>
     * These properties are applied before {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest} is called.
     *
     *
     * @return DSRequest
     * @see com.smartgwt.client.data.DSRequest
     * @see com.smartgwt.client.data.OperationBinding#getRequestProperties
     * @see com.smartgwt.client.docs.ServerDataIntegration ServerDataIntegration overview and related methods
     */
    public DSRequest getRequestProperties()  {
        return new DSRequest(getAttributeAsJavaScriptObject("requestProperties"));
    }

    /**
     * The required message for required field errors.
     *
     * @param requiredMessage requiredMessage Default value is null
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredMessage(String requiredMessage) {
        setAttribute("requiredMessage", requiredMessage, true);
    }

    /**
     * The required message for required field errors.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public String getRequiredMessage()  {
        return getAttributeAsString("requiredMessage");
    }

    /**
     * Very advanced: for servers that do not support paging, and must return large numbers of XML records in one HTTP
     * response, Smart GWT breaks up the processing of the response in order to avoid the "script running slowly" dialog
     * appearing for an end user. <P> If you have a relatively small number of records with a great deal of properties or
     * subobjects on each record, and you have not set {@link com.smartgwt.client.data.DataSource#getDropExtraFields
     * dropExtraFields} to eliminate unused data, and you see the "script running slowly" dialog, you may need to set this
     * number lower.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param resultBatchSize resultBatchSize Default value is 150
     */
    public void setResultBatchSize(int resultBatchSize) {
        setAttribute("resultBatchSize", resultBatchSize, true);
    }

    /**
     * Very advanced: for servers that do not support paging, and must return large numbers of XML records in one HTTP
     * response, Smart GWT breaks up the processing of the response in order to avoid the "script running slowly" dialog
     * appearing for an end user. <P> If you have a relatively small number of records with a great deal of properties or
     * subobjects on each record, and you have not set {@link com.smartgwt.client.data.DataSource#getDropExtraFields
     * dropExtraFields} to eliminate unused data, and you see the "script running slowly" dialog, you may need to set this
     * number lower.
     *
     *
     * @return int
     */
    public int getResultBatchSize()  {
        return getAttributeAsInt("resultBatchSize");
    }

    /**
     * Class for ResultSets used by this datasource.  If null, defaults to using {@link com.smartgwt.client.data.ResultSet}.
     * <P> This can be set to a custom subclass of ResultSet that, for example, hangs onto to extra information necessary for
     * integration with web services.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param resultSetClass resultSetClass Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setResultSetClass(String resultSetClass)  throws IllegalStateException {
        setAttribute("resultSetClass", resultSetClass, false);
    }

    /**
     * Class for ResultSets used by this datasource.  If null, defaults to using {@link com.smartgwt.client.data.ResultSet}.
     * <P> This can be set to a custom subclass of ResultSet that, for example, hangs onto to extra information necessary for
     * integration with web services.
     *
     *
     * @return String
     */
    public String getResultSetClass()  {
        return getAttributeAsString("resultSetClass");
    }


    /**
     * For a DataSource derived from WSDL or XML schema, the XML namespace this schema belongs to.  This is a read-only
     * attribute automatically present on DataSources returned from  SchemaSet.getSchema and {@link
     * com.smartgwt.client.data.WebService#getSchema WebService.getSchema}.
     *
     * <b>Note :</b> This method should be called only after the underlying component has been created.
     *
     * @return String
     * @throws IllegalStateException if underlying component has not yet been created.
     * @see com.smartgwt.client.docs.WsdlBinding WsdlBinding overview and related methods
     */
    public String getSchemaNamespace() throws IllegalStateException {
        errorIfNotCreated("schemaNamespace");
        return getAttributeAsString("schemaNamespace");
    }

    /**
     * Analogous to {@link com.smartgwt.client.data.DataSource#getDropExtraFields dropExtraFields}, for data sent to the
     * server.  Setting this attribute to false ensures that for any records in the data object, only fields that correspond to
     * declared dataSource fields will be present on the dsRequest data object passed to {@link
     * com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest} and ultimately sent to the server.
     *
     * @param sendExtraFields sendExtraFields Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public void setSendExtraFields(Boolean sendExtraFields)  throws IllegalStateException {
        setAttribute("sendExtraFields", sendExtraFields, false);
    }

    /**
     * Analogous to {@link com.smartgwt.client.data.DataSource#getDropExtraFields dropExtraFields}, for data sent to the
     * server.  Setting this attribute to false ensures that for any records in the data object, only fields that correspond to
     * declared dataSource fields will be present on the dsRequest data object passed to {@link
     * com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest} and ultimately sent to the server.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public Boolean getSendExtraFields()  {
        return getAttributeAsBoolean("sendExtraFields");
    }

    /**
     * For an XML DataSource, URN of the WebService to use to invoke operations.  This URN comes from the "targetNamespace"
     * attribute of the &lt;wsdl:definitions&gt; element in a WSDL (Web Service Description Language) document, and serves as
     * the unique identifier of the service. <P> Having loaded a WebService using {@link
     * com.smartgwt.client.data.XMLTools#loadWSDL XMLTools.loadWSDL}, setting <code>serviceNamespace</code> combined with
     * specifying  {@link com.smartgwt.client.data.OperationBinding operationBindings} that set {@link
     * com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation} will cause a DataSource to invoke web service
     * operations to fulfill DataSource requests ({@link com.smartgwt.client.data.DSRequest DSRequests}). <P> Setting
     * <code>serviceNamespace</code> also defaults {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} to the
     * service's location, {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} to "xml" and {@link
     * com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol} to "soap".
     *
     * @param serviceNamespace serviceNamespace Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.WsdlBinding WsdlBinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#data_integration_server_wsdl_generic" target="examples">Weather SOAP Search Example</a>
     */
    public void setServiceNamespace(String serviceNamespace)  throws IllegalStateException {
        setAttribute("serviceNamespace", serviceNamespace, false);
    }

    /**
     * For an XML DataSource, URN of the WebService to use to invoke operations.  This URN comes from the "targetNamespace"
     * attribute of the &lt;wsdl:definitions&gt; element in a WSDL (Web Service Description Language) document, and serves as
     * the unique identifier of the service. <P> Having loaded a WebService using {@link
     * com.smartgwt.client.data.XMLTools#loadWSDL XMLTools.loadWSDL}, setting <code>serviceNamespace</code> combined with
     * specifying  {@link com.smartgwt.client.data.OperationBinding operationBindings} that set {@link
     * com.smartgwt.client.data.OperationBinding#getWsOperation wsOperation} will cause a DataSource to invoke web service
     * operations to fulfill DataSource requests ({@link com.smartgwt.client.data.DSRequest DSRequests}). <P> Setting
     * <code>serviceNamespace</code> also defaults {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} to the
     * service's location, {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} to "xml" and {@link
     * com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol} to "soap".
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.WsdlBinding WsdlBinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#data_integration_server_wsdl_generic" target="examples">Weather SOAP Search Example</a>
     */
    public String getServiceNamespace()  {
        return getAttributeAsString("serviceNamespace");
    }

    /**
     * For a DataSource that inherits {@link com.smartgwt.client.data.DataSource#getFields fields} from another DataSource 
     * (via {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}), indicates that only the fields listed in
     * this DataSource should be shown.  All other inherited parent fields will be marked "hidden:true".
     *
     * @param showLocalFieldsOnly showLocalFieldsOnly Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setShowLocalFieldsOnly(Boolean showLocalFieldsOnly)  throws IllegalStateException {
        setAttribute("showLocalFieldsOnly", showLocalFieldsOnly, false);
    }

    /**
     * For a DataSource that inherits {@link com.smartgwt.client.data.DataSource#getFields fields} from another DataSource 
     * (via {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}), indicates that only the fields listed in
     * this DataSource should be shown.  All other inherited parent fields will be marked "hidden:true".
     *
     *
     * @return Boolean
     */
    public Boolean getShowLocalFieldsOnly()  {
        return getAttributeAsBoolean("showLocalFieldsOnly");
    }

    /**
     * Whether RPCRequests sent by this DataSource should enable  {@link com.smartgwt.client.rpc.RPCRequest#getShowPrompt
     * showPrompt} if it's unset.
     *
     * @param showPrompt showPrompt Default value is true
     */
    public void setShowPrompt(Boolean showPrompt) {
        setAttribute("showPrompt", showPrompt, true);
    }

    /**
     * Whether RPCRequests sent by this DataSource should enable  {@link com.smartgwt.client.rpc.RPCRequest#getShowPrompt
     * showPrompt} if it's unset.
     *
     *
     * @return Boolean
     */
    public Boolean getShowPrompt()  {
        return getAttributeAsBoolean("showPrompt");
    }

    /**
     * [A] If set to true, both client and server-side advanced filtering used by Smart GWT will follow&#010 SQL99 behavior for
     * dealing with NULL values, which is often counter-intuitive to users.&#010 Specifically, when a field has NULL value, all
     * of the following expressions are false:&#010 <pre>&#010    field == "someValue"  (normally false)&#010    field !=
     * "someValue"  (normally true)&#010    not (field == "someValue")   (normally true)&#010    not (field != "someValue")  
     * (normally false)&#010 </pre>
     *
     * @param strictSQLFiltering strictSQLFiltering Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setStrictSQLFiltering(Boolean strictSQLFiltering)  throws IllegalStateException {
        setAttribute("strictSQLFiltering", strictSQLFiltering, false);
    }

    /**
     * [A] If set to true, both client and server-side advanced filtering used by Smart GWT will follow&#010 SQL99 behavior for
     * dealing with NULL values, which is often counter-intuitive to users.&#010 Specifically, when a field has NULL value, all
     * of the following expressions are false:&#010 <pre>&#010    field == "someValue"  (normally false)&#010    field !=
     * "someValue"  (normally true)&#010    not (field == "someValue")   (normally true)&#010    not (field != "someValue")  
     * (normally false)&#010 </pre>
     *
     *
     * @return Boolean
     */
    public Boolean getStrictSQLFiltering()  {
        return getAttributeAsBoolean("strictSQLFiltering");
    }

    /**
     * Tag name to use when serializing to XML.  If unspecified, the <code>dataSource.ID</code> will be used.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param tagName tagName Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public void setTagName(String tagName)  throws IllegalStateException {
        setAttribute("tagName", tagName, false);
    }

    /**
     * Tag name to use when serializing to XML.  If unspecified, the <code>dataSource.ID</code> will be used.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String getTagName()  {
        return getAttributeAsString("tagName");
    }

    /**
     * User-visible name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply Item". <P> Defaults to
     * <code>dataSource.ID</code>.
     *
     * @param title title Default value is dataSource.ID
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * User-visible name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply Item". <P> Defaults to
     * <code>dataSource.ID</code>.
     *
     *
     * @return String
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
     * Best field to use for a user-visible title for an individual record from this dataSource. <p> For example, for a
     * DataSource of employees, a "full name" field would probably most clearly label an employee record. <p> If not explicitly
     * set, titleField looks for fields named "title", "label", "name", and "id" in that order.  If a field exists with one of
     * those names, it becomes the titleField.  If not, then the first field is designated as the titleField.
     *
     * @param titleField titleField Default value is see below
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public void setTitleField(String titleField)  throws IllegalStateException {
        setAttribute("titleField", titleField, false);
    }

    /**
     * Best field to use for a user-visible title for an individual record from this dataSource. <p> For example, for a
     * DataSource of employees, a "full name" field would probably most clearly label an employee record. <p> If not explicitly
     * set, titleField looks for fields named "title", "label", "name", and "id" in that order.  If a field exists with one of
     * those names, it becomes the titleField.  If not, then the first field is designated as the titleField.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.DsSpecialFields DsSpecialFields overview and related methods
     */
    public String getTitleField()  {
        return getAttributeAsString("titleField");
    }

    /**
     * Like {@link com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields useFlatFields}, but applies to all DataBound
     * components that bind to this DataSource.
     *
     * @param useFlatFields useFlatFields Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setUseFlatFields(Boolean useFlatFields)  throws IllegalStateException {
        setAttribute("useFlatFields", useFlatFields, false);
    }

    /**
     * Like {@link com.smartgwt.client.widgets.DataBoundComponent#getUseFlatFields useFlatFields}, but applies to all DataBound
     * components that bind to this DataSource.
     *
     *
     * @return Boolean
     */
    public Boolean getUseFlatFields()  {
        return getAttributeAsBoolean("useFlatFields");
    }

    /**
     * Like {@link com.smartgwt.client.data.OperationBinding#getUseHttpProxy useHttpProxy}, but serves as a default for this
     * DataSource that may be overridden by individual operationBindings.
     *
     * @param useHttpProxy useHttpProxy Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public void setUseHttpProxy(Boolean useHttpProxy)  throws IllegalStateException {
        setAttribute("useHttpProxy", useHttpProxy, false);
    }

    /**
     * Like {@link com.smartgwt.client.data.OperationBinding#getUseHttpProxy useHttpProxy}, but serves as a default for this
     * DataSource that may be overridden by individual operationBindings.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public Boolean getUseHttpProxy()  {
        return getAttributeAsBoolean("useHttpProxy");
    }

    /**
     * Whether to attempt validation on the client at all for this DataSource.  If unset (the default), client-side validation
     * is enabled. <p> Disabling client-side validation entirely is a good way to test server-side validation.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useLocalValidators useLocalValidators Default value is null
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public void setUseLocalValidators(Boolean useLocalValidators) {
        setAttribute("useLocalValidators", useLocalValidators, true);
    }

    /**
     * Whether to attempt validation on the client at all for this DataSource.  If unset (the default), client-side validation
     * is enabled. <p> Disabling client-side validation entirely is a good way to test server-side validation.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getUseLocalValidators()  {
        return getAttributeAsBoolean("useLocalValidators");
    }

    /**
     * For a DataSource that inherits {@link com.smartgwt.client.data.DataSource#getFields fields} from another DataSource 
     * (via {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}), indicates that the parent's field order
     * should be used instead of the order of the fields as declared in this DataSource.  New fields, if any, are placed at the
     * end.
     *
     * @param useParentFieldOrder useParentFieldOrder Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#featured-xsd-ds" target="examples">Schema Chaining Example</a>
     */
    public void setUseParentFieldOrder(Boolean useParentFieldOrder)  throws IllegalStateException {
        setAttribute("useParentFieldOrder", useParentFieldOrder, false);
    }

    /**
     * For a DataSource that inherits {@link com.smartgwt.client.data.DataSource#getFields fields} from another DataSource 
     * (via {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}), indicates that the parent's field order
     * should be used instead of the order of the fields as declared in this DataSource.  New fields, if any, are placed at the
     * end.
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#featured-xsd-ds" target="examples">Schema Chaining Example</a>
     */
    public Boolean getUseParentFieldOrder()  {
        return getAttributeAsBoolean("useParentFieldOrder");
    }

    /**
     * When set, causes a {@link com.smartgwt.client.data.DataSource#getClientOnly client-only} or {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} DataSource to  create a second DataSource to perform
     * it's one-time fetch.  By default, this attribute will be considered true when clientOnly is true, cacheAllData is false
     * or unset and a dataURL or testDataFileName is specified on the DataSource.
     *
     * @param useTestDataFetch useTestDataFetch Default value is null
     */
    public void setUseTestDataFetch(Boolean useTestDataFetch) {
        setAttribute("useTestDataFetch", useTestDataFetch, true);
    }

    /**
     * When set, causes a {@link com.smartgwt.client.data.DataSource#getClientOnly client-only} or {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} DataSource to  create a second DataSource to perform
     * it's one-time fetch.  By default, this attribute will be considered true when clientOnly is true, cacheAllData is false
     * or unset and a dataURL or testDataFileName is specified on the DataSource.
     *
     *
     * @return Boolean
     */
    public Boolean getUseTestDataFetch()  {
        return getAttributeAsBoolean("useTestDataFetch");
    }

    /**
     * If true, indicates that the Smart GWT Server should automatically apply a  {@link
     * com.smartgwt.client.types.ValidatorType} of "hasRelatedRecord" to every field  on this dataSource that has a {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} defined.
     *
     * @param validateRelatedRecords validateRelatedRecords Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValidateRelatedRecords(Boolean validateRelatedRecords)  throws IllegalStateException {
        setAttribute("validateRelatedRecords", validateRelatedRecords, false);
    }

    /**
     * If true, indicates that the Smart GWT Server should automatically apply a  {@link
     * com.smartgwt.client.types.ValidatorType} of "hasRelatedRecord" to every field  on this dataSource that has a {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} defined.
     *
     *
     * @return Boolean
     */
    public Boolean getValidateRelatedRecords()  {
        return getAttributeAsBoolean("validateRelatedRecords");
    }

    // ********************* Methods ***********************
            
    /**
     * Takes all relative date values found anywhere within a Criteria / AdvancedCriteria object and converts them to concrete
     * date values, returning the new criteria object.
     * @param criteria criteria to convert
     *
     * @return new copy of the criteria with all relative dates converted
     */
    public native Criteria convertRelativeDates(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.convertRelativeDates(criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Takes all relative date values found anywhere within a Criteria / AdvancedCriteria object and converts them to concrete
     * date values, returning the new criteria object.
     * @param criteria criteria to convert
     * @param timezoneOffset optional timezone offset.  Defaults to the current timezone
     * @param firstDayOfWeek first day of the week (zero is Sunday).  Defaults to                               {@link
     * com.smartgwt.client.widgets.DateChooser#getFirstDayOfWeek firstDayOfWeek}
     *
     * @return new copy of the criteria with all relative dates converted
     */
    public native Criteria convertRelativeDates(Criteria criteria, String timezoneOffset, int firstDayOfWeek) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.convertRelativeDates(criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), timezoneOffset, firstDayOfWeek);
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
            
    /**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria, retrieving matching records and
     * exporting the results.  See  {@link com.smartgwt.client.data.OperationBinding#getExportResults exportResults} or {@link
     * com.smartgwt.client.data.DSRequest#getExportResults exportResults} and for more information.
     */
    public native void exportData() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.exportData();
    }-*/;

    /**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria, retrieving matching records and
     * exporting the results.  See  {@link com.smartgwt.client.data.OperationBinding#getExportResults exportResults} or {@link
     * com.smartgwt.client.data.DSRequest#getExportResults exportResults} and for more information.
     * @param criteria search criteria
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void exportData(Criteria criteria, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.exportData(criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
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
     * For a DataSource that describes a DOM structure, the list of legal child elements that can be contained by the element
     * described by this DataSource. <p> For a DataSource described by XML schema, this is the list of legal subelements <b>of
     * complexType</b> (elements of simpleType become DataSourceFields with atomic type). <p> Note that currently, if an XML
     * schema file contains ordering constraints, DataSources derived from XML Schema do not capture these constraints.
     */
    public native void getLegalChildTags() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.getLegalChildTags();
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
     * Add a handleError handler.
     * <p>
     * If you define this method on a DataSource, it will be called whenever the server returns a DSResponse with a status
     * other than {@link com.smartgwt.client.rpc.RPCResponse#STATUS_SUCCESS STATUS_SUCCESS}.  You can use this hook to do
     * DataSource-specific error handling.  Unless you return <code>false</code> from this method, {@link
     * com.smartgwt.client.rpc.RPCManager#handleError RPCManager.handleError} will be called by Smart GWT right after this
     * method completes.
     *
     * @param handler the handleError handler
     * @return {@link HandlerRegistration} used to remove this handler
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
                obj.addProperties({handleError:$debox($entry(function(){
                        var param = {"response" : arguments[0], "request" : arguments[1]};
                        var event = @com.smartgwt.client.data.events.ErrorEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    }))
                });
            } else {
                obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
                obj.handleError = $debox($entry(function(){
                    var param = {"response" : arguments[0], "request" : arguments[1]};
                    var event = @com.smartgwt.client.data.events.ErrorEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }));
            }
   }-*/;
            
    /**
     * When {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} is true, has all the data been retrieved
     * to the client?
     *
     * @return All data has been fetched from the server and is available client-side
     */
    public native Boolean hasAllData() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.hasAllData();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Invalidate the cache when {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} or {@link
     * com.smartgwt.client.data.DataSource#getClientOnly clientOnly} are true.
     */
    public native void invalidateCache() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;
            
    /**
     * Does this dataSource support the specified "textMatchStyle" when performing a filter operation against a text field.
     * @param textMatchStyle textMatchStyle to check. If passed a null value,      assume an exact match is being requested.
     */
    public native void supportsTextMatchStyle(TextMatchStyle textMatchStyle) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.supportsTextMatchStyle(textMatchStyle.@com.smartgwt.client.types.TextMatchStyle::getValue()());
    }-*/;
            
    /**
     * Causes any components using this DataSource to be notified of changes that have been made to the remote dataset accessed
     * via this DataSource, as though the provided DSResponse had just successfully completed.  This will cause cache managers
     * such as {@link com.smartgwt.client.data.ResultSet} or  ResultTree to automatically update their caches, and components
     * using such cache managers to visually update to show modified data. <P> This API should be used when you have found out
     * about changes made by other users or by automatic processes.  For example, using the Smart GWT {@link
     * com.smartgwt.client.data.DataSource#getMessaging Messaging} system to receive real-time updates via HTTP streaming, you
     * may get updates that should affect a ListGrid which is using a ResultSet to view a portion of a large dataset.   <P>
     * Alternatively, an operation that removes a record from one DataSource may cause a new record to be added to another
     * DataSource (such as Lead -> Account conversion in CRM applications). This could be accomplished by using the callback
     * from the "remove" operation to call <code>updateCaches</code> with a DSResponse representing an "add" operation on the
     * related DataSource. <P> Cache updates of this kind can also be driven from server-side code - see the related
     * server-side API <code>DSResponse.addRelatedUpdate()</code>. <P> <b>NOTE:</b>: this API should <b>not</b> be used with a
     * {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly} DataSource, because in this case, the "remote
     * dataset" is actually within the browser.  Instead,  {@link com.smartgwt.client.data.DataSource#updateData
     * DataSource.updateData}, addData() or removeData() can be called in order to both change the dataset stored inside the
     * browser and notify all cache managers. <P> If a DataSource has {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} set and a full cache has been obtained, calling
     * <code>updateCaches</code> will automatically update the cache. <P> Note that this DSResponse will <b>not</b> go through
     * {@link com.smartgwt.client.data.DataSource#transformResponse DataSource.transformResponse} or other processing that
     * would normally occur for a DSResponse resulting from a DSRequest sent by  the application in this page.
     * @param dsResponse 
     */
    public native void updateCaches(DSResponse dsResponse) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.updateCaches(dsResponse.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Causes any components using this DataSource to be notified of changes that have been made to the remote dataset accessed
     * via this DataSource, as though the provided DSResponse had just successfully completed.  This will cause cache managers
     * such as {@link com.smartgwt.client.data.ResultSet} or  ResultTree to automatically update their caches, and components
     * using such cache managers to visually update to show modified data. <P> This API should be used when you have found out
     * about changes made by other users or by automatic processes.  For example, using the Smart GWT {@link
     * com.smartgwt.client.data.DataSource#getMessaging Messaging} system to receive real-time updates via HTTP streaming, you
     * may get updates that should affect a ListGrid which is using a ResultSet to view a portion of a large dataset.   <P>
     * Alternatively, an operation that removes a record from one DataSource may cause a new record to be added to another
     * DataSource (such as Lead -> Account conversion in CRM applications). This could be accomplished by using the callback
     * from the "remove" operation to call <code>updateCaches</code> with a DSResponse representing an "add" operation on the
     * related DataSource. <P> Cache updates of this kind can also be driven from server-side code - see the related
     * server-side API <code>DSResponse.addRelatedUpdate()</code>. <P> <b>NOTE:</b>: this API should <b>not</b> be used with a
     * {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly} DataSource, because in this case, the "remote
     * dataset" is actually within the browser.  Instead,  {@link com.smartgwt.client.data.DataSource#updateData
     * DataSource.updateData}, addData() or removeData() can be called in order to both change the dataset stored inside the
     * browser and notify all cache managers. <P> If a DataSource has {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} set and a full cache has been obtained, calling
     * <code>updateCaches</code> will automatically update the cache. <P> Note that this DSResponse will <b>not</b> go through
     * {@link com.smartgwt.client.data.DataSource#transformResponse DataSource.transformResponse} or other processing that
     * would normally occur for a DSResponse resulting from a DSRequest sent by  the application in this page.
     * @param dsResponse 
     * @param dsRequest 
     */
    public native void updateCaches(DSResponse dsResponse, DSRequest dsRequest) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.updateCaches(dsResponse.@com.smartgwt.client.core.DataClass::getJsObj()(), dsRequest.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Contacts the server to run server-side validation on a DSRequest and either returns {@link
     * com.smartgwt.client.data.DSResponse#getErrors errors} validation errors or a {@link
     * com.smartgwt.client.data.DSResponse#getStatus status} code of 0. <p> A "validate" dsRequest is effectively always {@link
     * com.smartgwt.client.rpc.RPCRequest#getWillHandleError willHandleError}:true. It is a normal condition for a "validate"
     * DSResponse to have validation errors and the response will never go to system-wide handling for unexpected errors
     * ({@link com.smartgwt.client.rpc.RPCManager#handleError RPCManager.handleError}).
     */
    public native void validateData() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.validateData();
    }-*/;

    // ********************* Static Methods ***********************
            
    /**
     * Combines two criteria (either simple criteria objects or AdvancedCriteria) using the  "outerOperator".  Note that the
     * combined criteria object will be an AdvancedCriteria unless: <ul> <li>both input criteria objects are simple, and</li>
     * <li>the "outerOperator" is "and", and</li> <li>there is no collision of key names on the two criteria</li> </ul>
     * @param criteria1 first criteria object
     * @param criteria2 second criteria object
     *
     * @return The combined criteria
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#sql_dynamic_reporting" target="examples">Dynamic Reporting Example</a>
     */
    public static native Criteria combineCriteria(Criteria criteria1, Criteria criteria2) /*-{
        var ret = $wnd.isc.DataSource.combineCriteria(criteria1.@com.smartgwt.client.core.DataClass::getJsObj()(), criteria2.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Combines two criteria (either simple criteria objects or AdvancedCriteria) using the  "outerOperator".  Note that the
     * combined criteria object will be an AdvancedCriteria unless: <ul> <li>both input criteria objects are simple, and</li>
     * <li>the "outerOperator" is "and", and</li> <li>there is no collision of key names on the two criteria</li> </ul>
     * @param criteria1 first criteria object
     * @param criteria2 second criteria object
     * @param outerOperator operator to use to combine the criteria.                                           Defaults to "and"
     * @param textMatchStyle style of matching text, if it is necessary to                                          convert a simple criteria object
     * to an                                           AdvancedCriteria.  Defaults to "substring"
     *
     * @return The combined criteria
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#sql_dynamic_reporting" target="examples">Dynamic Reporting Example</a>
     */
    public static native Criteria combineCriteria(Criteria criteria1, Criteria criteria2, CriteriaCombineOperator outerOperator, TextMatchStyle textMatchStyle) /*-{
        var ret = $wnd.isc.DataSource.combineCriteria(criteria1.@com.smartgwt.client.core.DataClass::getJsObj()(), criteria2.@com.smartgwt.client.core.DataClass::getJsObj()(), outerOperator, textMatchStyle.@com.smartgwt.client.types.TextMatchStyle::getValue()());
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
            
    /**
     * Synonym of {@link com.smartgwt.client.data.DataSource#getDataSource DataSource.getDataSource}: Lookup a DataSource by
     * ID.
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
        
    // ***********************************************************        


    protected native void onInit() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();

        self.__transformRequest = self.transformRequest;
        self.transformRequest = $entry(function(dsRequest) {
            var jObj = this.__ref;
            if(jObj === undefined) {
                //handle case where oneTimeDS is cared from original DS (when clientOnly=true with dataURL)
                jObj = $wnd.isc.DS.get(this.inheritsFrom).__ref;
            }
            var dsRequestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            var data = jObj.@com.smartgwt.client.data.DataSource::transformRequest(Lcom/smartgwt/client/data/DSRequest;)(dsRequestJ);
            if(@com.smartgwt.client.data.DataSource::isRecord(Ljava/lang/Object;)(data)) {
                data = data.@com.smartgwt.client.data.Record::getJsObj()();
            } else if (@com.smartgwt.client.data.DataSource::isRecordArray(Ljava/lang/Object;)(data)) {
                data = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(data);
            }
            return data;
        });

        self.__transformResponse = self.transformResponse;
        self.transformResponse = $entry(function(dsResponse, dsRequest, data) {
            var jObj = this.__ref;
            if(jObj === undefined) {
                //handle case where oneTimeDS is cared from original DS (when clientOnly=true with dataURL)
                jObj = $wnd.isc.DS.get(this.inheritsFrom).__ref;
            }
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            jObj.@com.smartgwt.client.data.DataSource::transformResponse(Lcom/smartgwt/client/data/DSResponse;Lcom/smartgwt/client/data/DSRequest;Ljava/lang/Object;)(responseJ, requestJ, data);
        });

        self.__getClientOnlyResponse = self.getClientOnlyResponse;
        self.getClientOnlyResponse = $entry(function(dsRequest) {
            var jObj = this.__ref;
            if(jObj === undefined) {
                //handle case where oneTimeDS is cared from original DS (when clientOnly=true with dataURL)
                jObj = $wnd.isc.DS.get(this.inheritsFrom).__ref;
            }
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            var responseJ = jObj.@com.smartgwt.client.data.DataSource::getClientOnlyResponse(Lcom/smartgwt/client/data/DSRequest;)(requestJ);
            return responseJ == null ? null : responseJ.@com.smartgwt.client.data.DSResponse::getJsObj()();
        });
    }-*/;

    private static boolean isRecord(Object data) {
        return data instanceof Record;
    }

    private static boolean isRecordArray(Object data) {
        return data instanceof Record[];
    }

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
     * HTTP parameters that should be submitted with every DSRequest. <br> Useful for authenticated services that
     * require a sessionId with every request. <br> Can be set for all operations of a given DataSource as
     * DataSource.defaultParams.
     *
     * @return the default params
     */
    public Map getDefaultParams() {
        return JSOHelper.convertToMap(getAttributeAsJavaScriptObject("defaultParams"));
    }

    /**
     * Controls the format in which inputs are sent to the dataURL when fulfilling DSRequests. May be overridden for
     * individual request types using {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol}}
     *
     * @return DSDataProtocol
     */
    public DSProtocol getDataProtocol() {
        return EnumUtil.getEnum(DSProtocol.values(), getAttribute("dataProtocol"));
    }

    /**
     * For a dataSource using client-side data integration, return the data that should be sent to the
     * DataSource.dataURL. <br> By default, HTTP requests sent to non-Smart GWT servers do not include DSRequest
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
     * @return data to be sent to the dataURL (JavaScriptObject, String or Record)
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
     * <p>
     * <b>Note</b>: This is an override point
     * @param response the response
     * @param request the request
     * @param data
     */
    protected native void transformResponse(DSResponse response, DSRequest request, Object data) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.__transformResponse(response.@com.smartgwt.client.data.DSResponse::getJsObj()(), request.@com.smartgwt.client.data.DSRequest::getJsObj()(), data);
    }-*/;

    /**
     * Return a "spoofed" response for a {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly} DataSource.&#010 <P>&#010 The default implementation will {@link com.smartgwt.client.data.DataSource#getTestData testData} to provide an appropriate&#010 response, by using {@link com.smartgwt.client.data.DataSource#applyFilter} for a "fetch" request, and&#010 by modifying the <code>testData</code> for other requests.&#010 <P>&#010 Override this method to provide simulations of other server-side behavior, such as&#010 modifying other records, or to implement <b>synchronous</b> client-side data providers&#010 (such as Google Gears).  For <b>asynchronous</b> third-party data provides, such as&#010 GWT-RPC, HTML5 sockets, or bridges to plug-in based protocols (Java, Flash,&#010 Silverlight..), use ${isc.DocUtils.linkForRef('DSDataProtocol','dataProtocol:"clientCustom"')} instead. &#010 <P>&#010 Overriding this method is also a means of detecting that a normal DataSource (not&#010 clientOnly) would be contacting the server.&#010&#010
     * <p>
     * <b>Note</b>: This is an override point
     * @param request DataSource request to respond to
     *
     * @return DSResponse
    */
    protected native DSResponse getClientOnlyResponse(DSRequest request) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.__getClientOnlyResponse(request.@com.smartgwt.client.data.DSRequest::getJsObj()());
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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
     * ID of another DataSource this DataSource inherits its DataSource fields from.<br><br>Local fields (fields defined
     * in this DataSource) are added to inherited fields to form the full set of fields. Fields with the same name are
     * merged in the same way that databound component fields are merged with DataSource fields.<br><br>The default
     * order of the combined fields is new local fields first (including any fields present in the parent DataSource
     * which the local DataSource re-declares), then parent fields.  You can set {@link
     * com.smartgwt.client.data.DataSource#setUseParentFieldOrder(Boolean) useParentFieldOrder} to instead use the
     * parent's field order, with new local fields appearing last.<br><br>
     * <p/>
     * You can set {@link com.smartgwt.client.data.DataSource#setShowLocalFieldsOnly(Boolean) showLocalFieldsOnly}  to
     * have all non-local fields hidden.<br><br>Note that <b>only fields are inherited</b> - other
     * properties such as dataURL and dataFormat are not.  You can use ordinary inheritance, that is, creating a
     * subclass of DataSource, in order to share properties such as dataURL across a series of DataSources that also
     * inherit fields from each other via <code>inheritsFrom</code> <br><br> This feature can be used for
     * creating a customized view (eg, only certain fields shown) which will be used bymultiple databound
     * components.adding presentation-specific attributes to metadata that has been automatically derived from {@link
     * com.smartgwt.client.data.XMLTools#loadXMLSchema(String, XSDLoadCallback)} or other metadata formats modelling
     * object subclassing and extension in server-side code and storage systems modelling relational database joins, and
     * the equivalents in other systems creating hooks for others to customize your application in a maintainable way.
     * For example, if you have a dataSource &quot;employee&quot;, you can create a
     * dataSource&quot;customizedEmployee&quot; which inherits from &quot;employee&quot; but does not initially define
     * anyfields, and bind all databound components to&quot;customizedEmployee&quot;. Customizations of fields
     * (including appearance changes, fieldorder, new fields, hiding of fields, and custom validation rules) can be
     * added to&quot;customizedEmployee&quot;, so that they are kept separtely from the original field data and have the
     * best possible chance of working with future versions of the &quot;employee&quot;dataSource.
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
    public void setFields(DataSourceField... fields) throws IllegalStateException {
        for (DataSourceField field : fields) {
            addField(field);
        }
    }

    /**
     * Add a field to the DataSource
     *
     * @param field the datasource field
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void addField(DataSourceField field) throws IllegalStateException {
        if(isCreated()) {
            error("Fields cannot be added to a DataSource after the underlying component has been created.");
        }
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
     * The list of fields that compose records from this DataSource.
     * <p>
     * Each DataSource field can have type, user-visible title, validators, and other metadata attached.
     *
     * @return array of DataSourceFields
     */
    public DataSourceField[] getFields() {
        String[] fields = getFieldNames();
        if(fields == null) return null;
        DataSourceField[] dsFields = new DataSourceField[fields.length];
        for (int i = 0; i < fields.length; i++) {
            String field = fields[i];
            dsFields[i] = getField(field);
        }
        return dsFields;
    }

    /**
     * Given a fieldName and a dataValue, apply any {@link com.smartgwt.client.data.DataSourceField#getValueMap valueMap} for
     * the field and return the display value for the field. If the field has no specified valueMap or the value does not
     * resolve to an entry in the valueMap it will be returned unaltered.
     * @param fieldName name of the field to retrieve a value for
     * @param value data value for the field
     *
     * @return display value for the field
     */
    public native Object getDisplayValue(String fieldName, Object value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.getDisplayValue(fieldName, value);
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
     * provided to the grid is "disconnected" data, unmanaged by Smart GWT's databinding facilities and safe to
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
     * com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource optionDataSource} and similar facilities to manage datasets
     * that may become very large. <P> <b>Data-Driven Visual Component Creation</b> <P>
     * <code>DataSource.fetchData()</code> can also be used to create Smart GWT components in a data-driven way.  Many
     * properties on Smart GWT visual components are configured via an Array of Objects - the same data format that
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
     * provided to the grid is "disconnected" data, unmanaged by Smart GWT's databinding facilities and safe to
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
     * com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource optionDataSource} and similar facilities to manage datasets
     * that may become very large. <P> <b>Data-Driven Visual Component Creation</b> <P>
     * <code>DataSource.fetchData()</code> can also be used to create Smart GWT components in a data-driven way.  Many
     * properties on Smart GWT visual components are configured via an Array of Objects - the same data format that
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
     * provided to the grid is "disconnected" data, unmanaged by Smart GWT's databinding facilities and safe to
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
     * com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource optionDataSource} and similar facilities to manage datasets
     * that may become very large. <P> <b>Data-Driven Visual Component Creation</b> <P>
     * <code>DataSource.fetchData()</code> can also be used to create Smart GWT components in a data-driven way.  Many
     * properties on Smart GWT visual components are configured via an Array of Objects - the same data format that
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
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
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
     * provided to the grid is "disconnected" data, unmanaged by Smart GWT's databinding facilities and safe to
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
     * com.smartgwt.client.widgets.form.fields.PickList#getOptionDataSource optionDataSource} and similar facilities to manage datasets
     * that may become very large. <P> <b>Data-Driven Visual Component Creation</b> <P>
     * <code>DataSource.fetchData()</code> can also be used to create Smart GWT components in a data-driven way.  Many
     * properties on Smart GWT visual components are configured via an Array of Objects - the same data format that
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
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
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
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    /**
     * Perform an "add" DataSource operation against this DataSource, to create a new DataSource record.
     *
     * @param record new record
     */
    public native void addData(Record record) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.addData(recordJS);
    }-*/;

    /**
     * Perform an "add" DataSource operation against this DataSource, to create a new DataSource record.
     *
     * @param record new record
     * @param callback  callback to invoke on completion
     */
    public native void addData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.addData(recordJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    /**
     * Perform an "add" DataSource operation against this DataSource, to create a new DataSource record.
     *
     * @param record         new record
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest that will be issued
     */
    public native void addData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.addData(recordJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    /**
     * Perform an "update" DataSource operation against this DataSource, to update values in an existing DataSource
     * record.
     *
     * @param record updated record
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
     * @param record updated record
     * @param callback      callback to invoke on completion
     */
    public native void updateData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.updateData(recordJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    /**
     * Perform an "update" DataSource operation against this DataSource, to update values in an existing DataSource
     * record.
     *
     * @param record     updated record
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest that will be issued
     */
    public native void updateData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.updateData(recordJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    /**
     * Perform a "remove" DataSource operation against this DataSource, to delete an existing DataSource record.
     *
     * @param record primary key values of record to delete,                                             (or complete
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
     * @param record     primary key values of record to delete,                                             (or complete
     *                 record)
     * @param callback callback to invoke on completion
     */
    public native void removeData(Record record, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.removeData(recordJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    /**
     * Perform a "remove" DataSource operation against this DataSource, to delete an existing DataSource record.
     *
     * @param record              primary key values of record to delete,(or complete record)
     * @param callback          callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest that will be issued
     */
    public native void removeData(Record record, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.removeData(recordJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

   /**
    * Serialize a JavaScript object as XML.&#010 <P>&#010 The JavaScript Object passed to {@link com.smartgwt.client.data.DataSource#xmlSerialize} becomes an XML&#010 element named after the {@link com.smartgwt.client.data.DataSource#getTagName tagName} (or {@link com.smartgwt.client.data.DataSource#getID ID} if&#010 tagName is unset).  Each property of the object becomes a subElement.  For example,&#010 using a DataSource to serialize like this:&#010 <pre>&#010     var inputObject = {&#010        startRow : 5,&#010        endRow : 50,&#010        data : [&#010           { field1 : "value1", field2: new Date() },&#010           { field1 : "value3", field2: null }&#010        ]&#010     };&#010     var myDS = isc.DataSource.create({ tagName:"DSRequest" });&#010     myDS.xmlSerialize(inputObject);&#010 </pre>&#010 .. produces the following XML:&#010 <pre>&#010     &lt;DSRequest&gt;&#010         &lt;startRow&gt;5&lt;/startRow&gt;&#010         &lt;endRow&gt;50&lt;/endRow&gt;&#010         &lt;data&gt;&#010             &lt;field1&gt;value1&lt;/field1&gt;&#010             &lt;field2&gt;2005-10-14T18:01:16&lt;/field2&gt;&#010         &lt;/data&gt;&#010         &lt;data&gt;&#010             &lt;field1&gt;value3&lt;/field1&gt;&#010             &lt;field2&gt;&lt;/field2&gt;&#010         &lt;/data&gt;&#010     &lt;/DSRequest&gt;&#010 </pre>&#010 <P>&#010 If you are working with a WSDL-described web service, XML serialization is performed&#010 automatically by APIs like {@link com.smartgwt.client.data.WebService#callOperation} - you only need to&#010 know about serialization in order to understand how to put together JavaScript data that&#010 will fill in an XML message properly.   &#010 <br>&#010 <b>Note:</b> when trying to send data to a web service, it is best to avoid putting&#010 together any XML yourself, instead modify the JavaScript data being fed to ISC's SOAP&#010 engine.  This is because the WSDL and SOAP rules for correctly namespacing and encoding&#010 Web Service messages are very complex and are subject to change with new versions of the&#010 web service you are contacting, whereas the data itself is easy to manipulate and less&#010 likely to change.&#010 <br>&#010 To troubleshoot message formation, you can set the log category "xmlComm" to &#010 <code>DEBUG</code> level in order to see the XML message formed by Smart GWT reported&#010 in log statements in the Developer Console.&#010&#010
    * @param data data to be serialized
    *
    * @return data as serialized to XML
    */
    public native String xmlSerialize(JavaScriptObject data) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.xmlSerialize(data);
    }-*/;

    /**
     * Serialize a JavaScript object as XML.&#010 <P>&#010 The JavaScript Object passed to {@link com.smartgwt.client.data.DataSource#xmlSerialize} becomes an XML&#010 element named after the {@link com.smartgwt.client.data.DataSource#getTagName tagName} (or {@link com.smartgwt.client.data.DataSource#getID ID} if&#010 tagName is unset).  Each property of the object becomes a subElement.  For example,&#010 using a DataSource to serialize like this:&#010 <pre>&#010     var inputObject = {&#010        startRow : 5,&#010        endRow : 50,&#010        data : [&#010           { field1 : "value1", field2: new Date() },&#010           { field1 : "value3", field2: null }&#010        ]&#010     };&#010     var myDS = isc.DataSource.create({ tagName:"DSRequest" });&#010     myDS.xmlSerialize(inputObject);&#010 </pre>&#010 .. produces the following XML:&#010 <pre>&#010     &lt;DSRequest&gt;&#010         &lt;startRow&gt;5&lt;/startRow&gt;&#010         &lt;endRow&gt;50&lt;/endRow&gt;&#010         &lt;data&gt;&#010             &lt;field1&gt;value1&lt;/field1&gt;&#010             &lt;field2&gt;2005-10-14T18:01:16&lt;/field2&gt;&#010         &lt;/data&gt;&#010         &lt;data&gt;&#010             &lt;field1&gt;value3&lt;/field1&gt;&#010             &lt;field2&gt;&lt;/field2&gt;&#010         &lt;/data&gt;&#010     &lt;/DSRequest&gt;&#010 </pre>&#010 <P>&#010 If you are working with a WSDL-described web service, XML serialization is performed&#010 automatically by APIs like {@link com.smartgwt.client.data.WebService#callOperation} - you only need to&#010 know about serialization in order to understand how to put together JavaScript data that&#010 will fill in an XML message properly.   &#010 <br>&#010 <b>Note:</b> when trying to send data to a web service, it is best to avoid putting&#010 together any XML yourself, instead modify the JavaScript data being fed to ISC's SOAP&#010 engine.  This is because the WSDL and SOAP rules for correctly namespacing and encoding&#010 Web Service messages are very complex and are subject to change with new versions of the&#010 web service you are contacting, whereas the data itself is easy to manipulate and less&#010 likely to change.&#010 <br>&#010 To troubleshoot message formation, you can set the log category "xmlComm" to &#010 <code>DEBUG</code> level in order to see the XML message formed by Smart GWT reported&#010 in log statements in the Developer Console.&#010&#010
     * @param data data to be serialized
     * @param flags options for the serialization engine
     *
     * @return data as serialized to XML
     */
    public native String xmlSerialize(JavaScriptObject data, SerializationContext flags) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var flagsJS = flags.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.xmlSerialize(data, flagsJS);
    }-*/;

    /**
     * Serialize a JavaScript object as XML.&#010 <P>&#010 The JavaScript Object passed to {@link com.smartgwt.client.data.DataSource#xmlSerialize} becomes an XML&#010 element named after the {@link com.smartgwt.client.data.DataSource#getTagName tagName} (or {@link com.smartgwt.client.data.DataSource#getID ID} if&#010 tagName is unset).  Each property of the object becomes a subElement.  For example,&#010 using a DataSource to serialize like this:&#010 <pre>&#010     var inputObject = {&#010        startRow : 5,&#010        endRow : 50,&#010        data : [&#010           { field1 : "value1", field2: new Date() },&#010           { field1 : "value3", field2: null }&#010        ]&#010     };&#010     var myDS = isc.DataSource.create({ tagName:"DSRequest" });&#010     myDS.xmlSerialize(inputObject);&#010 </pre>&#010 .. produces the following XML:&#010 <pre>&#010     &lt;DSRequest&gt;&#010         &lt;startRow&gt;5&lt;/startRow&gt;&#010         &lt;endRow&gt;50&lt;/endRow&gt;&#010         &lt;data&gt;&#010             &lt;field1&gt;value1&lt;/field1&gt;&#010             &lt;field2&gt;2005-10-14T18:01:16&lt;/field2&gt;&#010         &lt;/data&gt;&#010         &lt;data&gt;&#010             &lt;field1&gt;value3&lt;/field1&gt;&#010             &lt;field2&gt;&lt;/field2&gt;&#010         &lt;/data&gt;&#010     &lt;/DSRequest&gt;&#010 </pre>&#010 <P>&#010 If you are working with a WSDL-described web service, XML serialization is performed&#010 automatically by APIs like {@link com.smartgwt.client.data.WebService#callOperation} - you only need to&#010 know about serialization in order to understand how to put together JavaScript data that&#010 will fill in an XML message properly.   &#010 <br>&#010 <b>Note:</b> when trying to send data to a web service, it is best to avoid putting&#010 together any XML yourself, instead modify the JavaScript data being fed to ISC's SOAP&#010 engine.  This is because the WSDL and SOAP rules for correctly namespacing and encoding&#010 Web Service messages are very complex and are subject to change with new versions of the&#010 web service you are contacting, whereas the data itself is easy to manipulate and less&#010 likely to change.&#010 <br>&#010 To troubleshoot message formation, you can set the log category "xmlComm" to &#010 <code>DEBUG</code> level in order to see the XML message formed by Smart GWT reported&#010 in log statements in the Developer Console.&#010&#010
     * @param data data to be serialized
     * @param flags options for the serialization engine
     *
     * @return data as serialized to XML
     */
    public native String xmlSerialize(Record data, SerializationContext flags) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var flagsJS = flags.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.xmlSerialize(data.@com.smartgwt.client.core.DataClass::getJsObj()(), flagsJS);
    }-*/;

    /**
     * Serialize a JavaScript object as XML.&#010 <P>&#010 The JavaScript Object passed to {@link com.smartgwt.client.data.DataSource#xmlSerialize} becomes an XML&#010 element named after the {@link com.smartgwt.client.data.DataSource#getTagName tagName} (or {@link com.smartgwt.client.data.DataSource#getID ID} if&#010 tagName is unset).  Each property of the object becomes a subElement.  For example,&#010 using a DataSource to serialize like this:&#010 <pre>&#010     var inputObject = {&#010        startRow : 5,&#010        endRow : 50,&#010        data : [&#010           { field1 : "value1", field2: new Date() },&#010           { field1 : "value3", field2: null }&#010        ]&#010     };&#010     var myDS = isc.DataSource.create({ tagName:"DSRequest" });&#010     myDS.xmlSerialize(inputObject);&#010 </pre>&#010 .. produces the following XML:&#010 <pre>&#010     &lt;DSRequest&gt;&#010         &lt;startRow&gt;5&lt;/startRow&gt;&#010         &lt;endRow&gt;50&lt;/endRow&gt;&#010         &lt;data&gt;&#010             &lt;field1&gt;value1&lt;/field1&gt;&#010             &lt;field2&gt;2005-10-14T18:01:16&lt;/field2&gt;&#010         &lt;/data&gt;&#010         &lt;data&gt;&#010             &lt;field1&gt;value3&lt;/field1&gt;&#010             &lt;field2&gt;&lt;/field2&gt;&#010         &lt;/data&gt;&#010     &lt;/DSRequest&gt;&#010 </pre>&#010 <P>&#010 If you are working with a WSDL-described web service, XML serialization is performed&#010 automatically by APIs like {@link com.smartgwt.client.data.WebService#callOperation} - you only need to&#010 know about serialization in order to understand how to put together JavaScript data that&#010 will fill in an XML message properly.   &#010 <br>&#010 <b>Note:</b> when trying to send data to a web service, it is best to avoid putting&#010 together any XML yourself, instead modify the JavaScript data being fed to ISC's SOAP&#010 engine.  This is because the WSDL and SOAP rules for correctly namespacing and encoding&#010 Web Service messages are very complex and are subject to change with new versions of the&#010 web service you are contacting, whereas the data itself is easy to manipulate and less&#010 likely to change.&#010 <br>&#010 To troubleshoot message formation, you can set the log category "xmlComm" to &#010 <code>DEBUG</code> level in order to see the XML message formed by Smart GWT reported&#010 in log statements in the Developer Console.&#010&#010
     * @param data data to be serialized
     * @param flags options for the serialization engine
     *
     * @return data as serialized to XML
     */
    public native String xmlSerialize(Record[] data, SerializationContext flags) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var flagsJS = flags.@com.smartgwt.client.core.DataClass::getJsObj()();
        var dataJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(data);
        return self.xmlSerialize(dataJS, flagsJS);
    }-*/;

    /**
     * Serialize a JavaScript object as XML.&#010 <P>&#010 The JavaScript Object passed to {@link com.smartgwt.client.data.DataSource#xmlSerialize} becomes an XML&#010 element named after the {@link com.smartgwt.client.data.DataSource#getTagName tagName} (or {@link com.smartgwt.client.data.DataSource#getID ID} if&#010 tagName is unset).  Each property of the object becomes a subElement.  For example,&#010 using a DataSource to serialize like this:&#010 <pre>&#010     var inputObject = {&#010        startRow : 5,&#010        endRow : 50,&#010        data : [&#010           { field1 : "value1", field2: new Date() },&#010           { field1 : "value3", field2: null }&#010        ]&#010     };&#010     var myDS = isc.DataSource.create({ tagName:"DSRequest" });&#010     myDS.xmlSerialize(inputObject);&#010 </pre>&#010 .. produces the following XML:&#010 <pre>&#010     &lt;DSRequest&gt;&#010         &lt;startRow&gt;5&lt;/startRow&gt;&#010         &lt;endRow&gt;50&lt;/endRow&gt;&#010         &lt;data&gt;&#010             &lt;field1&gt;value1&lt;/field1&gt;&#010             &lt;field2&gt;2005-10-14T18:01:16&lt;/field2&gt;&#010         &lt;/data&gt;&#010         &lt;data&gt;&#010             &lt;field1&gt;value3&lt;/field1&gt;&#010             &lt;field2&gt;&lt;/field2&gt;&#010         &lt;/data&gt;&#010     &lt;/DSRequest&gt;&#010 </pre>&#010 <P>&#010 If you are working with a WSDL-described web service, XML serialization is performed&#010 automatically by APIs like {@link com.smartgwt.client.data.WebService#callOperation} - you only need to&#010 know about serialization in order to understand how to put together JavaScript data that&#010 will fill in an XML message properly.   &#010 <br>&#010 <b>Note:</b> when trying to send data to a web service, it is best to avoid putting&#010 together any XML yourself, instead modify the JavaScript data being fed to ISC's SOAP&#010 engine.  This is because the WSDL and SOAP rules for correctly namespacing and encoding&#010 Web Service messages are very complex and are subject to change with new versions of the&#010 web service you are contacting, whereas the data itself is easy to manipulate and less&#010 likely to change.&#010 <br>&#010 To troubleshoot message formation, you can set the log category "xmlComm" to &#010 <code>DEBUG</code> level in order to see the XML message formed by Smart GWT reported&#010 in log statements in the Developer Console.&#010&#010
     * @param data data to be serialized
     * @param flags options for the serialization engine
     *
     * @return data as serialized to XML
     */
    public native String xmlSerialize(Map data, SerializationContext flags) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var flagsJS = flags.@com.smartgwt.client.core.DataClass::getJsObj()();
        var dataJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(data);
        return self.xmlSerialize(dataJS, flagsJS);
    }-*/;


    /**
     * Process a dsResponse for a request initiated by a DataSource with {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol}. <code>requestId</code> parameter should be dsRequest.requestId as found on the dsRequest passed to {@link com.smartgwt.client.data.DataSource#transformRequest}. <P> You must provide a response for both error and non-error cases.  For an error case, a sufficient response is: <pre> { status : -1 } </pre>
     * @param requestId requestId attribute from the associated dataSource request object
     * @param responseProperties Configuration for the dsResponse
     */
    public native void processResponse(String requestId, DSResponse responseProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var responsePropertiesJS = responseProperties == null ? null : responseProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.processResponse(requestId, responsePropertiesJS);
    }-*/;

   /**
    * Transform a list of XML elements to DataSource records.
    * <p>
    * recordsFromXML() will return a List of DataSource Records. The value for each field is extracted from the XML according
    * to the rules described under {@link DataSourceField#setValueXPath(String) valueXPath}.
    *
    * @param elements XML elements to transform, eg, the result of a call to {@link com.smartgwt.client.data.XMLTools#selectNodes(Object, String)}
    *
    * @return list of DataSource records derived from the XML elements
    */
    public native Record[] recordsFromXML(Object elements) /*-{
		var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
		var records = self.recordsFromXML(elements);
        if(records == null || records === undefined) return null;
        return @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
	}-*/;

    /**
     * Retrieves the list of fields declared on this DataSource.
     *
     * @return names of all fields declared on this DataSource, including fields that are marked hidden
     */
    public String[] getFieldNames() {
        return getFieldNames(false);
    }

    /**
     * Retrieves the list of fields declared on this DataSource.
     *
     * @param excludeHidden If true, returns only those fields that are not marked as hidden
     * @return names of all fields declared on this DataSource
     */
    public native String[] getFieldNames(boolean excludeHidden) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var value = self.getFieldNames(excludeHidden);
        if(value == null) return null;
        if(!@com.smartgwt.client.util.JSOHelper::isArray(Lcom/google/gwt/core/client/JavaScriptObject;)(value)) {
            value = [value];
        }
        return @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
    }-*/;

    /**
     * Download a file stored in a field of type:"binary" in a DataSource record. <P> This will trigger the browser's "Save As"
     * dialog and allow the user to save the file.
     * @param data primary key values of record containing the file to download (or the complete record)
     */
    public native void downloadFile(Record data) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if(!self.downloadFile) {
            @com.smartgwt.client.util.SC::requiresServerComponents()();
        }
        self.downloadFile(data.@com.smartgwt.client.data.Record::getJsObj()());
    }-*/;

    /**
     * Download a file stored in a field of type:"binary" in a DataSource record. <P> This will trigger the browser's "Save As"
     * dialog and allow the user to save the file.
     * @param data primary key values of record                                                   containing the file to download (or
     *                                             the complete record)
     * @param fieldName optional name of the binary field containing the                                         file.  If not provided, the
     * first binary field                                         is used
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     */
    public native void downloadFile(Record data, String fieldName, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if(!self.downloadFile) {
            @com.smartgwt.client.util.SC::requiresServerComponents()();
        }
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.downloadFile(data.@com.smartgwt.client.data.Record::getJsObj()(), fieldName, requestPropertiesJS);
    }-*/;

    /**
     * Display a file stored in a field of type:"binary" in a new browser window. <P> This will open a new browser window to
     * show the file.  Depending on the file type, the user's installed plugins and applications, and the user's browser
     * settings, this may cause the file to be actually displayed in the new browser window, or may prompt the user to either
     * launch an external application to view the file or save the file to disk.
     * @param data primary key values of record containing the file to view (or the complete record)
     */
    public native void viewFile(Record data) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if(!self.viewFile) {
            @com.smartgwt.client.util.SC::requiresServerComponents()();
        }
        self.viewFile(data.@com.smartgwt.client.data.Record::getJsObj()());
    }-*/;

    /**
     * Display a file stored in a field of type:"binary" in a new browser window. <P> This will open a new browser window to
     * show the file.  Depending on the file type, the user's installed plugins and applications, and the user's browser
     * settings, this may cause the file to be actually displayed in the new browser window, or may prompt the user to either
     * launch an external application to view the file or save the file to disk.
     * @param data primary key values of record                                                   containing the file to view (or the
     * complete record)
     * @param fieldName optional name of the binary field containing the                                         file.  If not provided, the
     * first binary field                                         is used
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     */
    public native void viewFile(Record data, String fieldName, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if(!self.viewFile) {
            @com.smartgwt.client.util.SC::requiresServerComponents()();
        }
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.viewFile(data.@com.smartgwt.client.data.Record::getJsObj()(), fieldName, requestPropertiesJS);
    }-*/;

    /**
     * Load a DataSource or an array of DataSources using the DataSourceLoader servlet.  When a callback is specified, this is
     * fired after the DataSources are loaded.  If no loading occurs because the requested DataSource(s) are already loaded, a
     * warning is  logged and the callback is fired. <P> To force reloading of DataSources that have already been loaded, pass
     * <code>true</code> in the forceReload parameter.
     * @param dsID DataSource ID
     * @param callback Callback to fire after DataSource loading completes
     * @param forceReload Forcibly reload a dataSource if it's already loaded
     */
    public static native void load(String dsID, Function callback, boolean forceReload) /*-{
        $wnd.isc.DataSource.load(dsID,
                $entry(function() {
                    if(callback != null) callback.@com.smartgwt.client.core.Function::execute()();
                }),
                forceReload);
    }-*/;

    /**
     * Load a DataSource or an array of DataSources using the DataSourceLoader servlet.  When a callback is specified, this is
     * fired after the DataSources are loaded.  If no loading occurs because the requested DataSource(s) are already loaded, a
     * warning is  logged and the callback is fired. <P> To force reloading of DataSources that have already been loaded, pass
     * <code>true</code> in the forceReload parameter.
     * @param dsID Array of DataSource IDs
     * @param callback Callback to fire after DataSource loading completes
     * @param forceReload Forcibly reload a dataSource if it's already loaded
     */
    public static native void load(String[] dsID, Function callback, boolean forceReload) /*-{
        $wnd.isc.DataSource.load(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(dsID),
                $entry(function() {
                    if(callback != null) callback.@com.smartgwt.client.core.Function::execute()();
                }),
                forceReload);
    }-*/;

    /**
     * Given an array of ${isc.DocUtils.linkForRef('object:SortSpecifier')}s, return a simple list of Strings in the format
     * expected by {@link com.smartgwt.client.data.DSRequest#getSortBy sortBy}.
     * @param sortSpecifiers The list of specifiers to return in   sortBy format
     *
     * @return An array of sort-definitions in the format expected by  {@link com.smartgwt.client.data.DSRequest#getSortBy sortBy}
     */
    public static native String[] getSortBy(String[] sortSpecifiers) /*-{
        var sortDefJS = $wnd.isc.DataSource.getSortBy(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(sortSpecifiers));
        return @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(sortDefJS);
    }-*/;

    /**
     * Return a an array of ${isc.DocUtils.linkForRef('object:SortSpecifier')}s, given an array of Strings in the format
     * expected by {@link com.smartgwt.client.data.DSRequest#getSortBy sortBy}.
     * @param sortBy A list of sortBy strings in the format expected by {@link com.smartgwt.client.data.DSRequest#getSortBy sortBy}
     *
     * @return An array of ${isc.DocUtils.linkForRef('SortSpecifiers')} equivalent to the passed in string array
     */
    public static native String[] getSortSpecifiers(String[] sortBy) /*-{
        var sortSpecJS = $wnd.isc.DataSource.getSortSpecifiers(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(sortBy));
        return @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(sortSpecJS);
    }-*/;

    /**
     * Exports arbitrary client-side data, with client-side formatters applied, so is suitable  for direct display to users. 
     * This method can be used to export data formatted outside of any kind of visual component. <P> Requires the Smart GWT
     * server, but does not rely on any server-side DataSources. <P> To export unformatted data, see {@link
     * com.smartgwt.client.data.DataSource#exportData} which does not include client-side formatters, but requires both the
     * Smart GWT server and the  presence of server-side DataSources.
     * @param data Records to export, similar to ListGrid.data
     * @param requestProperties Request properties for the export
     */
    public native void exportClientData(Object[] data, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.exportClientData(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(data), requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Perform a custom DataSource operation against this DataSource.  A custom operation is anything that is not one of the 4
     * CRUD operations - generally, something that is more  complex than a fetch or an update to a single record. 
     * <code>customOperation</code>s  are an alternative to using {@link com.smartgwt.client.rpc.RPCRequest RPCs}; anything
     * that can be sent to the server as a plain RPC can instead be framed as a DataSource  <code>customOperation</code>.
     * @param operationId the operation ID
     * @param data data to pass to the server
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void performCustomOperation(String operationId, Record data, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.performCustomOperation(
            operationId, 
            data.@com.smartgwt.client.core.DataClass::getJsObj()(),
            $entry(function (dsResponse, data, dsRequest) {
                var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
                var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
                if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
            }),
            requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()()
            );
    }-*/;

    /**
     * Optional object declaring namespace prefixes for use in OperationBinding.recordXPath and
     * DataSourceField.valueXPath XPath expressions. xmlNamespaces should be specified as a map
ping from namespace
     * prefix to namespace URI, for example: <br>
     * <p/>
     * xmlNamespaces : { az : "http://webservices.amazon.com/AWSECommerceService/2005-03-23" }
<br> By default, all
     * namespaces declared on the document element (outermost element of the response) are made
 available with the
     * prefix used in the document itself. Then, for non-WSDL-described XML results, if there i
s a default namespace on
     * the document element, it is made available with the special prefix "default". <br>
     * <p/>
     * For results of WSDL-described operations, the prefix "service" means the service namespa
ce, that is, the
     * "targetNamespace" on the element from the WSDL file. The prefix "schema" means the names
pace of the outermost
     * element in the output message for the current operation. "default" will be the schema na
mespace if there is one,
     * otherwise the service namespace. <br> For basic information on XML Namespaces and their
use in XPath, try the
     * following search: http://www.google.com/search?q=XPath+xml+namespaces
     *
     * @param xmlNamespaces xml namespaces
     * @throws IllegalStateException this property cannot be changed after the underlying compo
nent has been created
     */
    public void setXmlNamespaces(XmlNamespaces xmlNamespaces) throws IllegalStateException {
        setAttribute("xmlNamespaces", xmlNamespaces, false);
    }

}





