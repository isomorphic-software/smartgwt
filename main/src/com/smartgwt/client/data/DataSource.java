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
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

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
 * 'QuickStart Guide', Chapter 6, <i>Data Binding</i>. <P> {@link com.smartgwt.client.docs.ClientServerIntegration Data
 * Integration} is the process by which a DataSource can be connected to server systems such as SQL DataBases, Java Object
 * models, WSDL web services and other data providers.  Data Integration comes in two variants: client-side and
 * server-side.  {@link com.smartgwt.client.docs.ServerDataIntegration Server-side integration} uses the Smart GWT
 * Java-based server to connect to data represented by Java Objects or JDBC-accessible databases.  {@link
 * com.smartgwt.client.docs.ClientDataIntegration Client-side integration} connects Smart GWT DataSources to XML, JSON or
 * other formats accessible via HTTP. <P> DataSources have a concept of {@link
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
 * @see com.smartgwt.client.docs.ClientOnlyDataSources ClientOnlyDataSources overview and related methods
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

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }



    public DataSource(){
        registerSgwtDS(getID());scClassName = "DataSource";
    }

    public DataSource(JavaScriptObject jsObj){
        scClassName = "DataSource";
        setJavaScriptObject(jsObj);
        
    }

    public DataSource(String dataURL) {
        setDataURL(dataURL);
        registerSgwtDS(getID());scClassName = "DataSource";
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************



    /**
     * By default, all DataSources are assumed to be capable of handling  {@link com.smartgwt.client.data.AdvancedCriteria} on
     * fetch or filter type operations.  This property may be set to <code>false</code> to indicate that this dataSource does
     * not support  advancedCriteria. See {@link com.smartgwt.client.data.DataSource#supportsAdvancedCriteria
     * DataSource.supportsAdvancedCriteria} for further information on this. <p> <b>NOTE:</b> If you specify this property in a
     * DataSource descriptor  (<code>.ds.xml</code> file), it is enforced on the server.  This means that if you run  a request
     * containing AdvancedCriteria against a DataSource that advertises itself as  <code>allowAdvancedCriteria:false</code>, it
     * will be rejected.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param allowAdvancedCriteria allowAdvancedCriteria Default value is null
     * @see com.smartgwt.client.data.OperationBinding#setAllowAdvancedCriteria
     */
    public void setAllowAdvancedCriteria(Boolean allowAdvancedCriteria) {
        setAttribute("allowAdvancedCriteria", allowAdvancedCriteria, true);
    }

    /**
     * By default, all DataSources are assumed to be capable of handling  {@link com.smartgwt.client.data.AdvancedCriteria} on
     * fetch or filter type operations.  This property may be set to <code>false</code> to indicate that this dataSource does
     * not support  advancedCriteria. See {@link com.smartgwt.client.data.DataSource#supportsAdvancedCriteria
     * DataSource.supportsAdvancedCriteria} for further information on this. <p> <b>NOTE:</b> If you specify this property in a
     * DataSource descriptor  (<code>.ds.xml</code> file), it is enforced on the server.  This means that if you run  a request
     * containing AdvancedCriteria against a DataSource that advertises itself as  <code>allowAdvancedCriteria:false</code>, it
     * will be rejected.
     *
     * @return Boolean
     * @see com.smartgwt.client.data.OperationBinding#getAllowAdvancedCriteria
     */
    public Boolean getAllowAdvancedCriteria()  {
        return getAttributeAsBoolean("allowAdvancedCriteria");
    }


    /**
     * When a DataSource is not {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData}:true and a fetch
     * results in the entire dataset being retrieved, this attribute being set to true causes the DataSource to automatically
     * switch to <code>cacheAllData:true</code> and prevent further server-trips for fetch  requests. <p> {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} is automatically enabled in either of these
     * conditions: <ul>   <li>     The request has no criteria and no startRow/endRow request properties. The latter can     be
     * accomplished by disabling paging with a {@link com.smartgwt.client.widgets.DataBoundComponent#getDataFetchMode
     * dataFetchMode}     setting of "basic" or "local" or by an explicit fetchData request with those request properties    
     * excluded.  </li>  <li>     The request has no criteria but has startRow/endRow specified and the response received has  
     *   all data available (<code>startRow:0</code> and <code>endRow:totalRows</code>).  </li> </ul>
     *
     * @param autoCacheAllData autoCacheAllData Default value is false
     */
    public void setAutoCacheAllData(Boolean autoCacheAllData) {
        setAttribute("autoCacheAllData", autoCacheAllData, true);
    }

    /**
     * When a DataSource is not {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData}:true and a fetch
     * results in the entire dataset being retrieved, this attribute being set to true causes the DataSource to automatically
     * switch to <code>cacheAllData:true</code> and prevent further server-trips for fetch  requests. <p> {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} is automatically enabled in either of these
     * conditions: <ul>   <li>     The request has no criteria and no startRow/endRow request properties. The latter can     be
     * accomplished by disabling paging with a {@link com.smartgwt.client.widgets.DataBoundComponent#getDataFetchMode
     * dataFetchMode}     setting of "basic" or "local" or by an explicit fetchData request with those request properties    
     * excluded.  </li>  <li>     The request has no criteria but has startRow/endRow specified and the response received has  
     *   all data available (<code>startRow:0</code> and <code>endRow:totalRows</code>).  </li> </ul>
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
    public void setAutoDeriveTitles(boolean autoDeriveTitles)  throws IllegalStateException {
        setAttribute("autoDeriveTitles", autoDeriveTitles, false);
    }

    /**
     * If set, titles are automatically derived from {@link com.smartgwt.client.data.DataSourceField#getName field.name} for
     * any  field that does not have a {@link com.smartgwt.client.data.DataSourceField#getTitle field.title} and is not marked
     * {@link com.smartgwt.client.data.DataSourceField#getHidden hidden}:true, by calling the method {@link
     * com.smartgwt.client.data.DataSource#getAutoTitle DataSource.getAutoTitle}.
     *
     * @return boolean
     */
    public boolean getAutoDeriveTitles()  {
        return getAttributeAsBoolean("autoDeriveTitles");
    }



    /**
     * Set this property to true to have a DataSource fetch all of its data client-side on the  first fetch request.  However,
     * unlike a {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly} DataSource, this DataSource  will still
     * save changes normally, sending remote requests. <P> You can manually set this attribute after initialization by calling 
     * {@link com.smartgwt.client.data.DataSource#setCacheAllData DataSource.setCacheAllData}; setting {@link
     * com.smartgwt.client.data.DataSource#getAutoCacheAllData autoCacheAllData}:true causes a DataSource to  automatically
     * switch to <code>cacheAllData:true</code> when a fetch results in the entire dataset being brought client-side. <P> To
     * cause automatic cache updates, you can set {@link com.smartgwt.client.data.DataSource#getCacheMaxAge cacheMaxAge} to a
     * number of seconds and once data has been client-side for that length of time, the next fetch causes the cache to be
     * dropped and a new cache retrieved. <P> Note that multiple {@link
     * com.smartgwt.client.data.DataSource#getOperationBindings operationBindings} of type "fetch" which return distinct
     * results will not work with <code>cacheAllData</code>: only one cache is created and is used for all fetch operations,
     * regardless of whether {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} has been set.  However,
     * "fetch" operationBindings used as a {@link com.smartgwt.client.data.OperationBinding#getCacheSyncOperation
     * cacheSyncOperation} will work normally, so long as they return all data fields that are returned by the default "fetch"
     * operation, so that the cache can be updated.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Call this method to switch cacheAllData on or off after initialization.  Passing a  <code>shouldCache</code> value of false clears any existing client-side cache, cancels any outstanding requests for a full cache and issues any other pending requests normally.
     *
     * @param cacheAllData New value for {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData}. Default value is null
     */
    public void setCacheAllData(Boolean cacheAllData) {
        setAttribute("cacheAllData", cacheAllData, true);
    }

    /**
     * Set this property to true to have a DataSource fetch all of its data client-side on the  first fetch request.  However,
     * unlike a {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly} DataSource, this DataSource  will still
     * save changes normally, sending remote requests. <P> You can manually set this attribute after initialization by calling 
     * {@link com.smartgwt.client.data.DataSource#setCacheAllData DataSource.setCacheAllData}; setting {@link
     * com.smartgwt.client.data.DataSource#getAutoCacheAllData autoCacheAllData}:true causes a DataSource to  automatically
     * switch to <code>cacheAllData:true</code> when a fetch results in the entire dataset being brought client-side. <P> To
     * cause automatic cache updates, you can set {@link com.smartgwt.client.data.DataSource#getCacheMaxAge cacheMaxAge} to a
     * number of seconds and once data has been client-side for that length of time, the next fetch causes the cache to be
     * dropped and a new cache retrieved. <P> Note that multiple {@link
     * com.smartgwt.client.data.DataSource#getOperationBindings operationBindings} of type "fetch" which return distinct
     * results will not work with <code>cacheAllData</code>: only one cache is created and is used for all fetch operations,
     * regardless of whether {@link com.smartgwt.client.data.DSRequest#getOperationId operationId} has been set.  However,
     * "fetch" operationBindings used as a {@link com.smartgwt.client.data.OperationBinding#getCacheSyncOperation
     * cacheSyncOperation} will work normally, so long as they return all data fields that are returned by the default "fetch"
     * operation, so that the cache can be updated.
     *
     * @return Boolean
     */
    public Boolean getCacheAllData()  {
        return getAttributeAsBoolean("cacheAllData");
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
     * @return int
     */
    public int getCacheMaxAge()  {
        return getAttributeAsInt("cacheMaxAge");
    }


    /**
     * Applies only to dataFormat: "json" and {@link com.smartgwt.client.data.DataSource#getDataTransport
     * dataTransport}:"scriptInclude".  Specifies the name of the query parameter that tells your JSON service what function to
     * call as part of the response.
     *
     * @param callbackParam . See {@link com.smartgwt.client.docs.String String}. Default value is "callback"
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
     * Applies only to dataFormat: "json" and {@link com.smartgwt.client.data.DataSource#getDataTransport
     * dataTransport}:"scriptInclude".  Specifies the name of the query parameter that tells your JSON service what function to
     * call as part of the response.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
    public void setCanMultiSort(boolean canMultiSort)  throws IllegalStateException {
        setAttribute("canMultiSort", canMultiSort, false);
    }

    /**
     * When true, indicates that this DataSource supports multi-level sorting.
     *
     * @return boolean
     */
    public boolean getCanMultiSort()  {
        return getAttributeAsBoolean("canMultiSort");
    }


    /**
     * fieldName for a field in the dataSource expected to contain an explicit array of child nodes.
     *  Enables loading a databound tree as a hierarchical data structure, rather than a flat list of
     *  nodes linked by foreignKey.<br>
     * Note this is an alternative to setting {@link com.smartgwt.client.data.DataSourceField#getChildrenProperty
     * childrenProperty} directly on
     *  the childrenField object.<P>
     * By default the children field will be assumed to be {@link com.smartgwt.client.data.DataSourceField#getMultiple
     * multiple},
     *  for XML databinding. This implies that child data should be delivered in the format:
     *  <pre>
     *       &lt;childrenFieldName&gt;
     *           &lt;item name="firstChild" ...&gt;
     *           &lt;item name="secondChild" ...&gt;
     *       &lt;/childrenFieldName&gt;
     *  </pre>
     *  However data may also be delivered as a direct list of <code>childrenFieldName</code> 
     *  elements:
     *  <pre>
     *       &lt;childrenFieldName name="firstChild" ...&gt;
     *       &lt;childrenFieldName name="secondChild" ...&gt;
     *  </pre>
     *  If you want to return your data in this format, you will need to explicitly set 
     *  <code>multiple</code> to false in the appropriate dataSource field definition.
     *
     * @param childrenField . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.data.DataSourceField#setChildrenProperty
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public void setChildrenField(String childrenField)  throws IllegalStateException {
        setAttribute("childrenField", childrenField, false);
    }

    /**
     * fieldName for a field in the dataSource expected to contain an explicit array of child nodes.
     *  Enables loading a databound tree as a hierarchical data structure, rather than a flat list of
     *  nodes linked by foreignKey.<br>
     * Note this is an alternative to setting {@link com.smartgwt.client.data.DataSourceField#getChildrenProperty
     * childrenProperty} directly on
     *  the childrenField object.<P>
     * By default the children field will be assumed to be {@link com.smartgwt.client.data.DataSourceField#getMultiple
     * multiple},
     *  for XML databinding. This implies that child data should be delivered in the format:
     *  <pre>
     *       &lt;childrenFieldName&gt;
     *           &lt;item name="firstChild" ...&gt;
     *           &lt;item name="secondChild" ...&gt;
     *       &lt;/childrenFieldName&gt;
     *  </pre>
     *  However data may also be delivered as a direct list of <code>childrenFieldName</code> 
     *  elements:
     *  <pre>
     *       &lt;childrenFieldName name="firstChild" ...&gt;
     *       &lt;childrenFieldName name="secondChild" ...&gt;
     *  </pre>
     *  If you want to return your data in this format, you will need to explicitly set 
     *  <code>multiple</code> to false in the appropriate dataSource field definition.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.data.DataSourceField#getChildrenProperty
     * @see com.smartgwt.client.docs.DataSourceRelations DataSourceRelations overview and related methods
     */
    public String getChildrenField()  {
        return getAttributeAsString("childrenField");
    }


    /**
     * A clientOnly DataSource simulates the behavior of a remote data store by manipulating a static dataset in memory as
     * {@link com.smartgwt.client.data.DSRequest DSRequests} are executed on it.  Any changes are lost when the user reloads
     * the page or navigates away. <P> A clientOnly DataSource will return responses asynchronously, just as a DataSource
     * accessing remote data does.  This allows a clientOnly DataSource to be used as a temporary placeholder while a real
     * DataSource is being implemented - if a clientOnly DataSource is replaced by a DataSource that accesses a remote data
     * store, UI code for components that used the clientOnly DataSource will not need be changed. <P> A clientOnly DataSource
     * can also be used as a shared cache of modifiable data across multiple UI components when immediate saving is not
     * desirable.  In this case, several components may interact with a clientOnly DataSource and get the benefit of {@link
     * com.smartgwt.client.data.ResultSet} behaviors such as automatic cache sync and in-browser data filtering and sorting. 
     * When it's finally time to save, {@link com.smartgwt.client.data.DataSource#getCacheData cacheData} can be inspected for
     * changes and data can be saved to the original DataSource via {@link com.smartgwt.client.data.DataSource#addData
     * DataSource.addData}, {@link com.smartgwt.client.data.DataSource#updateData DataSource.updateData} and {@link
     * com.smartgwt.client.data.DataSource#removeData DataSource.removeData}, possibly in a {@link
     * com.smartgwt.client.rpc.RPCManager#startQueue transactional queue}.  Note that {@link
     * com.smartgwt.client.data.DataSource#getClientOnlyDataSource DataSource.getClientOnlyDataSource} lets you easily obtain a
     * <code>clientOnly</code> DataSource representing a subset of the data available from a normal DataSource.   <P> See also
     * {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} - a <code>cacheAllData</code> behaves like a
     * write-through cache, performing fetch and filter operations locally while still performing remote save operations
     * immediately. <P> ClientOnly DataSources can be populated programmatically via {@link
     * com.smartgwt.client.data.DataSource#getCacheData cacheData} - see {@link com.smartgwt.client.docs.ClientOnlyDataSources
     * this discussion} for other ways to populate a client-only DataSource with data.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
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
     * A clientOnly DataSource simulates the behavior of a remote data store by manipulating a static dataset in memory as
     * {@link com.smartgwt.client.data.DSRequest DSRequests} are executed on it.  Any changes are lost when the user reloads
     * the page or navigates away. <P> A clientOnly DataSource will return responses asynchronously, just as a DataSource
     * accessing remote data does.  This allows a clientOnly DataSource to be used as a temporary placeholder while a real
     * DataSource is being implemented - if a clientOnly DataSource is replaced by a DataSource that accesses a remote data
     * store, UI code for components that used the clientOnly DataSource will not need be changed. <P> A clientOnly DataSource
     * can also be used as a shared cache of modifiable data across multiple UI components when immediate saving is not
     * desirable.  In this case, several components may interact with a clientOnly DataSource and get the benefit of {@link
     * com.smartgwt.client.data.ResultSet} behaviors such as automatic cache sync and in-browser data filtering and sorting. 
     * When it's finally time to save, {@link com.smartgwt.client.data.DataSource#getCacheData cacheData} can be inspected for
     * changes and data can be saved to the original DataSource via {@link com.smartgwt.client.data.DataSource#addData
     * DataSource.addData}, {@link com.smartgwt.client.data.DataSource#updateData DataSource.updateData} and {@link
     * com.smartgwt.client.data.DataSource#removeData DataSource.removeData}, possibly in a {@link
     * com.smartgwt.client.rpc.RPCManager#startQueue transactional queue}.  Note that {@link
     * com.smartgwt.client.data.DataSource#getClientOnlyDataSource DataSource.getClientOnlyDataSource} lets you easily obtain a
     * <code>clientOnly</code> DataSource representing a subset of the data available from a normal DataSource.   <P> See also
     * {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} - a <code>cacheAllData</code> behaves like a
     * write-through cache, performing fetch and filter operations locally while still performing remote save operations
     * immediately. <P> ClientOnly DataSources can be populated programmatically via {@link
     * com.smartgwt.client.data.DataSource#getCacheData cacheData} - see {@link com.smartgwt.client.docs.ClientOnlyDataSources
     * this discussion} for other ways to populate a client-only DataSource with data.
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
        setAttribute("criteriaPolicy", criteriaPolicy == null ? null : criteriaPolicy.getValue(), true);
    }

    /**
     * Decides under what conditions the {@link com.smartgwt.client.data.ResultSet} cache should be dropped when the {@link
     * com.smartgwt.client.data.ResultSet#getCriteria criteria} changes.
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
     * @param dataField . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_json_datasource" target="examples">JSON DataSource Example</a>
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#json_integration_category_simple" target="examples">Simple JSON Example</a>
     */
    public void setDataFormat(DSDataFormat dataFormat)  throws IllegalStateException {
        setAttribute("dataFormat", dataFormat == null ? null : dataFormat.getValue(), false);
    }

    /**
     * Indicates the format to be used for HTTP requests and responses when fulfilling DSRequests (eg, when {@link
     * com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} is called).
     *
     * @return DSDataFormat
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
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
        setAttribute("dataTransport", dataTransport == null ? null : dataTransport.getValue(), false);
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
     * @param dataURL . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param descriptionField . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @return Boolean
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public Boolean getDropExtraFields()  {
        return getAttributeAsBoolean("dropExtraFields");
    }


    /**
     * If the criteria applied to a fetch type operation contain fields that are not present in the dataSource, should they be
     * ignored when performing filtering on the client. This property is useful for cases where you custom server logic makes
     * use of criteria  values to determine what set of records to return to the client, but the data does not actually have
     * record values for these fields and as such the client-side filtering logic should ignore them.
     *
     * @param dropUnknownCriteria dropUnknownCriteria Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setDropUnknownCriteria(Boolean dropUnknownCriteria)  throws IllegalStateException {
        setAttribute("dropUnknownCriteria", dropUnknownCriteria, false);
    }

    /**
     * If the criteria applied to a fetch type operation contain fields that are not present in the dataSource, should they be
     * ignored when performing filtering on the client. This property is useful for cases where you custom server logic makes
     * use of criteria  values to determine what set of records to return to the client, but the data does not actually have
     * record values for these fields and as such the client-side filtering logic should ignore them.
     *
     * @return Boolean
     */
    public Boolean getDropUnknownCriteria()  {
        return getAttributeAsBoolean("dropUnknownCriteria");
    }



    /**
     * The name of the property this DataSource uses for constant name when translating Java enumerated types to and from
     * Javascript, if the {@link com.smartgwt.client.types.EnumTranslateStrategy} is set to "bean".  Defaults to "_constant" if
     * not set. <p>  This property is only applicable if you are using the Smart GWT server
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param enumConstantProperty . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @param enumOrdinalProperty . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
        setAttribute("enumTranslateStrategy", enumTranslateStrategy == null ? null : enumTranslateStrategy.getValue(), false);
    }



    /**
     * Namespaces definitions to add to the root element of outbound XML messages sent to a web
     *  service, as a mapping from namespace prefix to namespace URI.
     *  <P>
     *  The default value is:
     *  <pre>
     *    globalNamespaces : {
     *       xsi: "http://www.w3.org/2001/XMLSchema-instance",
     *       xsd: "http://www.w3.org/2001/XMLSchema"
     *    },
     *  </pre>
     *  This default value allows the use of the xsi:type and xsi:nil attributes without further
     *  declarations.
     *  <P>
     *  Note that some web services will only accept specific revisions of the XML Schema URI.
     *  If xsi-namespaced attributes seem to be ignored by an older webservice, try the URI
     *  "http://www.w3.org/1999/XMLSchema-instance" instead.
     *
     * @param globalNamespaces globalNamespaces Default value is ...
     */
    public void setGlobalNamespaces(Map globalNamespaces) {
        setAttribute("globalNamespaces", globalNamespaces, true);
    }

    /**
     * Namespaces definitions to add to the root element of outbound XML messages sent to a web
     *  service, as a mapping from namespace prefix to namespace URI.
     *  <P>
     *  The default value is:
     *  <pre>
     *    globalNamespaces : {
     *       xsi: "http://www.w3.org/2001/XMLSchema-instance",
     *       xsd: "http://www.w3.org/2001/XMLSchema"
     *    },
     *  </pre>
     *  This default value allows the use of the xsi:type and xsi:nil attributes without further
     *  declarations.
     *  <P>
     *  Note that some web services will only accept specific revisions of the XML Schema URI.
     *  If xsi-namespaced attributes seem to be ignored by an older webservice, try the URI
     *  "http://www.w3.org/1999/XMLSchema-instance" instead.
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
     * @param iconField . See {@link com.smartgwt.client.docs.String String}. Default value is see below
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
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param infoField . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param inheritsFrom . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param jsonPrefix . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param jsonSuffix . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.data.OperationBinding#getDataFormat
     * @see com.smartgwt.client.data.OperationBinding#getDataTransport
     */
    public String getJsonSuffix()  {
        return getAttributeAsString("jsonSuffix");
    }










    /**
     * Optional array of OperationBindings, which provide instructions to the DataSource about how each
     *  DSOperation is to be performed.
     *  <P>
     *  When using the Smart GWT Server, OperationBindings are specified in your DataSource
     *  descriptor (.ds.xml file) and control server-side behavior such as what Java object to route
     * DSRequest to ({@link com.smartgwt.client.docs.serverds.OperationBinding#serverObject serverObject}) or customizations to
     * SQL / HQL queries
     * ({@link com.smartgwt.client.data.OperationBinding#getCustomSQL customSQL} and {@link
     * com.smartgwt.client.data.OperationBinding#getCustomHQL customHQL}).  See the 
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#javaDataIntegration" target="examples">Java Integration
     * samples</a>.
     *  <P>
     *  For DataSources bound to WSDL-described web services using
     * {@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace}, OperationBindings are used to bind
     * each DataSource
     *  {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} to an
     *  {@link com.smartgwt.client.data.OperationBinding#getWsOperation operation} of a WSDL-described 
     *  {@link com.smartgwt.client.data.WebService web service}, so that a DataSource can both fetch and save data to a web
     *  service.
     *  <P>
     *  For example, this code accomplishes part of the binding to the 
     * <a href='http://www.google.com/search?q=sforce+partner+wsdl'
     * onclick="window.open('http://www.google.com/search?q=sforce+partner+wsdl');return false;">SalesForce partner web
     * services</a>
     *  <pre>
     *  isc.DataSource.create({
     *     serviceNamespace : "urn:partner.soap.sforce.com",
     *     operationBindings : [
     *         { operationType:"fetch", wsOperation:"query", recordName: "sObject" },
     *         { operationType:"update", wsOperation:"update", recordName: "SaveResult" },
     *         { operationType:"add", wsOperation:"create", recordName: "SaveResult" },
     *         { operationType:"remove", wsOperation:"delete", recordName: "DeleteResult" }
     *     ],
     *     ...
     *  }); 
     *  </pre>
     *  NOTE: additional code is required to handle authentication and other details, see the
     *  complete code in smartclientSDK/examples/databinding/SalesForce.
     *  <P>
     *  For DataSources that contact non-WSDL-described XML or JSON services, OperationBindings can
     *  be used to separately configure the URL, HTTP method, input and output processing for each
     *  operationType.  This makes it possible to fetch JSON data from one URL for the "fetch"
     *  operationType and save to a web service for the "update" operationType, while appearing as a
     *  single integrated DataSource to a {@link com.smartgwt.client.widgets.DataBoundComponent} such as an
     *  {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit editable ListGrid}.
     *  <P>
     *  If no operationBinding is defined for a given DataSource operation, all of the properties
     *  which are valid on the operationBinding are checked for on the DataSource itself.  
     *  <P>
     *  This also means that for a read-only DataSource, that is, a DataSource only capable of fetch
     *  operations, operationBindings need not be specified, and instead all operationBinding
     *  properties can be set on the DataSource itself.  An example of using OperationBinding
     *  properties directly on the DataSource in order to read an RSS feed can be found here:
     *  <P>
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
     * Optional array of OperationBindings, which provide instructions to the DataSource about how each
     *  DSOperation is to be performed.
     *  <P>
     *  When using the Smart GWT Server, OperationBindings are specified in your DataSource
     *  descriptor (.ds.xml file) and control server-side behavior such as what Java object to route
     * DSRequest to ({@link com.smartgwt.client.docs.serverds.OperationBinding#serverObject serverObject}) or customizations to
     * SQL / HQL queries
     * ({@link com.smartgwt.client.data.OperationBinding#getCustomSQL customSQL} and {@link
     * com.smartgwt.client.data.OperationBinding#getCustomHQL customHQL}).  See the 
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#javaDataIntegration" target="examples">Java Integration
     * samples</a>.
     *  <P>
     *  For DataSources bound to WSDL-described web services using
     * {@link com.smartgwt.client.data.DataSource#getServiceNamespace serviceNamespace}, OperationBindings are used to bind
     * each DataSource
     *  {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} to an
     *  {@link com.smartgwt.client.data.OperationBinding#getWsOperation operation} of a WSDL-described 
     *  {@link com.smartgwt.client.data.WebService web service}, so that a DataSource can both fetch and save data to a web
     *  service.
     *  <P>
     *  For example, this code accomplishes part of the binding to the 
     * <a href='http://www.google.com/search?q=sforce+partner+wsdl'
     * onclick="window.open('http://www.google.com/search?q=sforce+partner+wsdl');return false;">SalesForce partner web
     * services</a>
     *  <pre>
     *  isc.DataSource.create({
     *     serviceNamespace : "urn:partner.soap.sforce.com",
     *     operationBindings : [
     *         { operationType:"fetch", wsOperation:"query", recordName: "sObject" },
     *         { operationType:"update", wsOperation:"update", recordName: "SaveResult" },
     *         { operationType:"add", wsOperation:"create", recordName: "SaveResult" },
     *         { operationType:"remove", wsOperation:"delete", recordName: "DeleteResult" }
     *     ],
     *     ...
     *  }); 
     *  </pre>
     *  NOTE: additional code is required to handle authentication and other details, see the
     *  complete code in smartclientSDK/examples/databinding/SalesForce.
     *  <P>
     *  For DataSources that contact non-WSDL-described XML or JSON services, OperationBindings can
     *  be used to separately configure the URL, HTTP method, input and output processing for each
     *  operationType.  This makes it possible to fetch JSON data from one URL for the "fetch"
     *  operationType and save to a web service for the "update" operationType, while appearing as a
     *  single integrated DataSource to a {@link com.smartgwt.client.widgets.DataBoundComponent} such as an
     *  {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit editable ListGrid}.
     *  <P>
     *  If no operationBinding is defined for a given DataSource operation, all of the properties
     *  which are valid on the operationBinding are checked for on the DataSource itself.  
     *  <P>
     *  This also means that for a read-only DataSource, that is, a DataSource only capable of fetch
     *  operations, operationBindings need not be specified, and instead all operationBinding
     *  properties can be set on the DataSource itself.  An example of using OperationBinding
     *  properties directly on the DataSource in order to read an RSS feed can be found here:
     *  <P>
     * ${isc.DocUtils.linkForStandaloneExample('/examples/databinding/rss_databinding.html',
     * '/examples/databinding/rss_databinding.html')}
     *
     * @return OperationBinding
     * @see com.smartgwt.client.data.OperationBinding
     */
    public OperationBinding[] getOperationBindings()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfOperationBinding(getAttributeAsJavaScriptObject("operationBindings"));
    }


    /**
     * User-visible plural name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply Items". <P>
     * Defaults to (<code>dataSource.title</code> or <code>dataSource.ID</code>) + "s".
     *
     * @param pluralTitle . See {@link com.smartgwt.client.docs.String String}. Default value is dataSource.ID
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setPluralTitle(String pluralTitle)  throws IllegalStateException {
        setAttribute("pluralTitle", pluralTitle, false);
    }

    /**
     * User-visible plural name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply Items". <P>
     * Defaults to (<code>dataSource.title</code> or <code>dataSource.ID</code>) + "s".
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @return Boolean
     */
    public Boolean getPreventHTTPCaching()  {
        return getAttributeAsBoolean("preventHTTPCaching");
    }


    /**
     * If true, causes Smart GWT Server to use the "progressive loading" pattern for  fetches on this dataSource, as described
     * in the <b>Paging and total dataset length</b> section of the {@link com.smartgwt.client.data.ResultSet ResultSet
     * documentation}.  Essentially, this means that we avoid issuing a row count query and instead advertise total rows as
     * being slightly  more than the number of rows we have already read (see {@link
     * com.smartgwt.client.docs.serverds.DataSource#endGap endGap}).  This  allows users to load more of a dataset by scrolling
     * past the end of the currently-loaded rows, but it prevents them from scrolling directly to the end of the dataset. <p>
     * Generally, progressive loading is appropriate when you have to deal with very large  datasets. Note that by default, a
     * dataSource will switch into progressive loading mode  automatically when it detects that it is dealing with a dataset
     * beyond a certain size -  see {@link com.smartgwt.client.docs.serverds.DataSource#progressiveLoadingThreshold
     * progressiveLoadingThreshold}. <p> This setting can be overridden for individual fetch operations with the  {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#progressiveLoading progressiveLoading} property, and also at the
     * level of the individual {@link com.smartgwt.client.data.DSRequest#getProgressiveLoading DSRequest}.  You can also
     * specify  <code>progressiveLoading</code> on  {@link com.smartgwt.client.widgets.DataBoundComponent#getProgressiveLoading
     * DataBoundComponents} and certain types of  <code>FormItem</code> - {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getProgressiveLoading SelectItem} and  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getProgressiveLoading ComboBoxItem}. <p> Currently, this property
     * only applies to users of the built-in SQLDataSource, but you  could use it in custom DataSource implementations to
     * trigger the server behavior  described in the <code>ResultSet</code> documentation linked to above.
     *
     * @param progressiveLoading progressiveLoading Default value is null
     * @see com.smartgwt.client.docs.serverds.OperationBinding#progressiveLoading
     * @see com.smartgwt.client.docs.serverds.DataSource#progressiveLoadingThreshold
     * @see com.smartgwt.client.docs.serverds.DataSource#lookAhead
     * @see com.smartgwt.client.docs.serverds.DataSource#endGap
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public void setProgressiveLoading(Boolean progressiveLoading) {
        setAttribute("progressiveLoading", progressiveLoading, true);
    }

    /**
     * If true, causes Smart GWT Server to use the "progressive loading" pattern for  fetches on this dataSource, as described
     * in the <b>Paging and total dataset length</b> section of the {@link com.smartgwt.client.data.ResultSet ResultSet
     * documentation}.  Essentially, this means that we avoid issuing a row count query and instead advertise total rows as
     * being slightly  more than the number of rows we have already read (see {@link
     * com.smartgwt.client.docs.serverds.DataSource#endGap endGap}).  This  allows users to load more of a dataset by scrolling
     * past the end of the currently-loaded rows, but it prevents them from scrolling directly to the end of the dataset. <p>
     * Generally, progressive loading is appropriate when you have to deal with very large  datasets. Note that by default, a
     * dataSource will switch into progressive loading mode  automatically when it detects that it is dealing with a dataset
     * beyond a certain size -  see {@link com.smartgwt.client.docs.serverds.DataSource#progressiveLoadingThreshold
     * progressiveLoadingThreshold}. <p> This setting can be overridden for individual fetch operations with the  {@link
     * com.smartgwt.client.docs.serverds.OperationBinding#progressiveLoading progressiveLoading} property, and also at the
     * level of the individual {@link com.smartgwt.client.data.DSRequest#getProgressiveLoading DSRequest}.  You can also
     * specify  <code>progressiveLoading</code> on  {@link com.smartgwt.client.widgets.DataBoundComponent#getProgressiveLoading
     * DataBoundComponents} and certain types of  <code>FormItem</code> - {@link
     * com.smartgwt.client.widgets.form.fields.SelectItem#getProgressiveLoading SelectItem} and  {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getProgressiveLoading ComboBoxItem}. <p> Currently, this property
     * only applies to users of the built-in SQLDataSource, but you  could use it in custom DataSource implementations to
     * trigger the server behavior  described in the <code>ResultSet</code> documentation linked to above.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.serverds.OperationBinding#progressiveLoading
     * @see com.smartgwt.client.docs.serverds.DataSource#progressiveLoadingThreshold
     * @see com.smartgwt.client.docs.serverds.DataSource#lookAhead
     * @see com.smartgwt.client.docs.serverds.DataSource#endGap
     * @see com.smartgwt.client.docs.ProgressiveLoading ProgressiveLoading overview and related methods
     */
    public Boolean getProgressiveLoading()  {
        return getAttributeAsBoolean("progressiveLoading");
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
     * @param recordXPath . See {@link com.smartgwt.client.docs.XPathExpression XPathExpression}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.XPathExpression XPathExpression}
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
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public void setRequestProperties(DSRequest requestProperties)  throws IllegalStateException {
        setAttribute("requestProperties", requestProperties.getJsObj(), false);
    }

    /**
     * Additional properties to pass through to the {@link com.smartgwt.client.data.DSRequest}s made by this DataSource. <p>
     * These properties are applied before {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest} is called.
     *
     * @return DSRequest
     * @see com.smartgwt.client.data.DSRequest
     * @see com.smartgwt.client.data.OperationBinding#getRequestProperties
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public DSRequest getRequestProperties()  {
        return new DSRequest(getAttributeAsJavaScriptObject("requestProperties"));
    }


    /**
     * The required message when a field that has been marked as {@link com.smartgwt.client.data.DataSourceField#getRequired
     * required} is not filled in by the user.
     *
     * @param requiredMessage . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.FormTitles FormTitles overview and related methods
     */
    public void setRequiredMessage(String requiredMessage) {
        setAttribute("requiredMessage", requiredMessage, true);
    }

    /**
     * The required message when a field that has been marked as {@link com.smartgwt.client.data.DataSourceField#getRequired
     * required} is not filled in by the user.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param resultSetClass . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getResultSetClass()  {
        return getAttributeAsString("resultSetClass");
    }





    /**
     * For a DataSource derived from WSDL or XML schema, the XML namespace this schema belongs to.  This is a read-only
     * attribute automatically present on DataSources returned from  SchemaSet.getSchema and {@link
     * com.smartgwt.client.data.WebService#getSchema WebService.getSchema}.
     * <p>
     * <b>Note :</b> This method should be called only after the underlying component has been created.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @throws IllegalStateException if the underlying component has not yet been created.
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
     * @return Boolean
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public Boolean getSendExtraFields()  {
        return getAttributeAsBoolean("sendExtraFields");
    }


    /**
     * Set this attribute if you need to send the dsRequest.parentNode to the server-side.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param sendParentNode sendParentNode Default value is false
     */
    public void setSendParentNode(Boolean sendParentNode) {
        setAttribute("sendParentNode", sendParentNode, true);
    }

    /**
     * Set this attribute if you need to send the dsRequest.parentNode to the server-side.
     *
     * @return Boolean
     */
    public Boolean getSendParentNode()  {
        return getAttributeAsBoolean("sendParentNode");
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
     * @param serviceNamespace . See {@link com.smartgwt.client.docs.String String}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @return Boolean
     */
    public Boolean getShowLocalFieldsOnly()  {
        return getAttributeAsBoolean("showLocalFieldsOnly");
    }


    /**
     * Whether RPCRequests sent by this DataSource should enable {@link com.smartgwt.client.rpc.RPCRequest#getShowPrompt
     * showPrompt} in order to block user interactions until the request completes.   <p> DataSource requests default to
     * blocking UI interaction because, very often, if the user continues to interact with an application that is waiting for a
     * server response, some kind of invalid or ambiguous situation can arise. <p> Examples include pressing a "Save" button a
     * second time before the first save completes, making further edits while edits are still being saved, or trying to
     * initiate editing on a grid that hasn't loaded data. <p> Defaulting to blocking the UI prevents these bad interactions,
     * or alternatively, avoids the developer having to write repetitive code to block invalid interactions on every screen.
     * <p> If an operation should ever be non-blocking, methods that initiate DataSource requests (such as {@link
     * com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData}) will generally have a
     * <code>requestProperties</code> argument allowing <code>showPrompt</code> to be set to false for a specific request.
     *
     * @param showPrompt showPrompt Default value is true
     */
    public void setShowPrompt(Boolean showPrompt) {
        setAttribute("showPrompt", showPrompt, true);
    }

    /**
     * Whether RPCRequests sent by this DataSource should enable {@link com.smartgwt.client.rpc.RPCRequest#getShowPrompt
     * showPrompt} in order to block user interactions until the request completes.   <p> DataSource requests default to
     * blocking UI interaction because, very often, if the user continues to interact with an application that is waiting for a
     * server response, some kind of invalid or ambiguous situation can arise. <p> Examples include pressing a "Save" button a
     * second time before the first save completes, making further edits while edits are still being saved, or trying to
     * initiate editing on a grid that hasn't loaded data. <p> Defaulting to blocking the UI prevents these bad interactions,
     * or alternatively, avoids the developer having to write repetitive code to block invalid interactions on every screen.
     * <p> If an operation should ever be non-blocking, methods that initiate DataSource requests (such as {@link
     * com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData}) will generally have a
     * <code>requestProperties</code> argument allowing <code>showPrompt</code> to be set to false for a specific request.
     *
     * @return Boolean
     */
    public Boolean getShowPrompt()  {
        return getAttributeAsBoolean("showPrompt");
    }





    /**
     * If set to true, both client and server-side advanced filtering used by Smart GWT will follow
     *  SQL99 behavior for dealing with NULL values, which is often counter-intuitive to users.
     *  Specifically, when a field has NULL value, all of the following expressions are false:
     *  <pre>
     *     field == "someValue"  (normally false)
     *     field != "someValue"  (normally true)
     *     not (field == "someValue")   (normally true)
     *     not (field != "someValue")   (normally false)
     *  </pre>
     *  This property can be overridden per-query by specifying <code>strictSQLFiltering</code>
     *  directly as a property on the {@link com.smartgwt.client.data.AdvancedCriteria}.
     *  <p>
     *  <b>NOTE:</b> On the server side, this property is only applicable if you are using the 
     *  SQL DataSource; the other built-in types (Hibernate and JPA/JPA2) do not offer this mode.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param strictSQLFiltering strictSQLFiltering Default value is false
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setStrictSQLFiltering(Boolean strictSQLFiltering)  throws IllegalStateException {
        setAttribute("strictSQLFiltering", strictSQLFiltering, false);
    }

    /**
     * If set to true, both client and server-side advanced filtering used by Smart GWT will follow
     *  SQL99 behavior for dealing with NULL values, which is often counter-intuitive to users.
     *  Specifically, when a field has NULL value, all of the following expressions are false:
     *  <pre>
     *     field == "someValue"  (normally false)
     *     field != "someValue"  (normally true)
     *     not (field == "someValue")   (normally true)
     *     not (field != "someValue")   (normally false)
     *  </pre>
     *  This property can be overridden per-query by specifying <code>strictSQLFiltering</code>
     *  directly as a property on the {@link com.smartgwt.client.data.AdvancedCriteria}.
     *  <p>
     *  <b>NOTE:</b> On the server side, this property is only applicable if you are using the 
     *  SQL DataSource; the other built-in types (Hibernate and JPA/JPA2) do not offer this mode.
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
     * @param tagName . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public void setTagName(String tagName)  throws IllegalStateException {
        setAttribute("tagName", tagName, false);
    }

    /**
     * Tag name to use when serializing to XML.  If unspecified, the <code>dataSource.ID</code> will be used.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.ClientDataIntegration ClientDataIntegration overview and related methods
     */
    public String getTagName()  {
        return getAttributeAsString("tagName");
    }



    /**
     * User-visible name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply Item". <P> Defaults to
     * <code>dataSource.ID</code>.
     *
     * @param title . See {@link com.smartgwt.client.docs.String String}. Default value is dataSource.ID
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * User-visible name for this DataSource. <P> For example, for the supplyItem DataSource, "Supply Item". <P> Defaults to
     * <code>dataSource.ID</code>.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param titleField . See {@link com.smartgwt.client.docs.String String}. Default value is see below
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
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @return Boolean
     * @see com.smartgwt.client.docs.Validation Validation overview and related methods
     */
    public Boolean getUseLocalValidators()  {
        return getAttributeAsBoolean("useLocalValidators");
    }


    /**
     * Whether we store server responses for this DataSource into  {@link com.smartgwt.client.util.Offline browser-based
     * offline storage}, and then use those stored responses at a later time if we are offline (ie, the application cannot
     * connect to the server).   Note that by default we do NOT use offline storage for a dataSource.
     *
     * @param useOfflineStorage useOfflineStorage Default value is null
     */
    public void setUseOfflineStorage(Boolean useOfflineStorage) {
        setAttribute("useOfflineStorage", useOfflineStorage, true);
    }

    /**
     * Whether we store server responses for this DataSource into  {@link com.smartgwt.client.util.Offline browser-based
     * offline storage}, and then use those stored responses at a later time if we are offline (ie, the application cannot
     * connect to the server).   Note that by default we do NOT use offline storage for a dataSource.
     *
     * @return Boolean
     */
    public Boolean getUseOfflineStorage()  {
        return getAttributeAsBoolean("useOfflineStorage");
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
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#featured-xsd-ds" target="examples">Schema Chaining Example</a>
     */
    public Boolean getUseParentFieldOrder()  {
        return getAttributeAsBoolean("useParentFieldOrder");
    }


    /**
     * Should HTTP responses to requests by this dataSource be formatted using the strict JSON subset of the javascript
     * language? If set to true, responses returned by the server should match the format described <a
     * href='http://www.json.org/js.html' onclick="window.open('http://www.json.org/js.html');return false;">here</a>. <P> Only
     * applies to dataSources which send requests to a server and have {@link com.smartgwt.client.data.DataSource#getDataFormat
     * dataFormat} set to "json" or "iscServer". <P> <b>Note:</b> using strict JSON avoids a known issue in Internet Explorer 9
     * where datasource transactions can leak memory due to a browser behavior where the native <code>eval()</code> method
     * fails to clean up references when the objects go out of scope. See {@link
     * com.smartgwt.client.rpc.RPCManager#allowIE9Leak allowIE9Leak} for more on this.
     *
     * @param useStrictJSON useStrictJSON Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setUseStrictJSON(Boolean useStrictJSON)  throws IllegalStateException {
        setAttribute("useStrictJSON", useStrictJSON, false);
    }

    /**
     * Should HTTP responses to requests by this dataSource be formatted using the strict JSON subset of the javascript
     * language? If set to true, responses returned by the server should match the format described <a
     * href='http://www.json.org/js.html' onclick="window.open('http://www.json.org/js.html');return false;">here</a>. <P> Only
     * applies to dataSources which send requests to a server and have {@link com.smartgwt.client.data.DataSource#getDataFormat
     * dataFormat} set to "json" or "iscServer". <P> <b>Note:</b> using strict JSON avoids a known issue in Internet Explorer 9
     * where datasource transactions can leak memory due to a browser behavior where the native <code>eval()</code> method
     * fails to clean up references when the objects go out of scope. See {@link
     * com.smartgwt.client.rpc.RPCManager#allowIE9Leak allowIE9Leak} for more on this.
     *
     * @return Boolean
     */
    public Boolean getUseStrictJSON()  {
        return getAttributeAsBoolean("useStrictJSON");
    }



    /**
     * When set, causes a {@link com.smartgwt.client.data.DataSource#getClientOnly client-only} or {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} DataSource to  create a second DataSource to perform
     * it's one-time fetch.  By default, this attribute will be considered true when clientOnly is true, cacheAllData is false
     * or unset and a dataURL or testFileName is specified on the DataSource.
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
     * or unset and a dataURL or testFileName is specified on the DataSource.
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
     * @return Boolean
     */
    public Boolean getValidateRelatedRecords()  {
        return getAttributeAsBoolean("validateRelatedRecords");
    }


    // ********************* Methods ***********************
	/**
     * Perform an "add" DataSource operation against this DataSource, to create a new DataSource record. <P> <b>NOTE:</b> do
     * not use this method to populate a {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly} DataSource.  Set
     * {@link com.smartgwt.client.data.DataSource#getCacheData cacheData} instead.
     * @param newRecord new record
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void addData(Record newRecord) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addData(newRecord.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
	 * @see {@link DataSource#addData()}
	 */
	public void addData(Record newRecord, DSCallback callback){
		addData(newRecord,callback,null);
	}
	/**
     * Perform an "add" DataSource operation against this DataSource, to create a new DataSource record. <P> <b>NOTE:</b> do
     * not use this method to populate a {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly} DataSource.  Set
     * {@link com.smartgwt.client.data.DataSource#getCacheData cacheData} instead.
     * @param newRecord new record
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void addData(Record newRecord, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addData(newRecord.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse,data,dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Given two sets of criteria, determine whether they are equivalent, the new criteria is guaranteed more restrictive, or
     * the new criteria is not guaranteed more restrictive, returning 0, 1 or -1 respectively. <P> Comparisons between {@link
     * com.smartgwt.client.data.AdvancedCriteria} are made via recursively calling  Operator.compareCriteria for all criteria
     * involved. <P> For simple {@link com.smartgwt.client.data.Criteria}, by default ({@link
     * com.smartgwt.client.types.CriteriaPolicy}:"dropOnShortening"), returns: <ul> <li> -1 if the new criteria has fewer
     * properties than the old criteria (indicating that it      isn't more restrictive) <li> -1 if the value for any property
     * in the old criteria is an array and 1) the value for      the same property in the new criteria isn't an array, or 2) is
     * an array but      of different length, or 3) the arrays do not contain the exact same set of objects      (order can be
     * different) <li> -1 if the value for any given property in the old criteria is not an array, and the      the value for
     * the same property property in the new criteria is different <li> -1 if both values for a given property are strings and
     * the new criteria value doesn't      contain the old criteria value <li> 1 if none of the above are true and, for at
     * least one of the properties, the      respective criteria values are both strings, and the old criteria value is a
     * substring      of, and is shorter than, the new criteria value <li> 0 otherwise (indicating the sets of criteria are
     * equivalent) </ul> <P> For ({@link com.smartgwt.client.types.CriteriaPolicy}:"dropOnChange"), returns: <ul> <li> -1 if
     * the two sets of criteria have a different number of properties <li> -1 if the value for any property in the old criteria
     * is an array and 1) the value for      the same property in the new criteria isn't an array, or 2) is an array but     
     * of different length, or 3) the arrays do not contain the exact same set of objects      (order can be different) <li> -1
     * if the value for any given property in the old criteria is not an array, and the      the value for the same property in
     * the new criteria is different <li> 0 otherwise (indicating the sets of criteria are equivalent) </ul> This method is
     * called by {@link com.smartgwt.client.data.ResultSet#compareCriteria ResultSet.compareCriteria} to determine whether a
     * change in criteria should cause the cache to be invalidated. You may want to override this method in order to mimic the
     * filtering behavior that your server performs.
     * @param newCriteria new filter criteria
     * @param oldCriteria previous filter criteria
     *
     * @return 0 if the filters are equivalent, 1 if newCriteria is guaranteed more                      restrictive, and -1 if
     * newCriteria is not guaranteed more restrictive
     * @see com.smartgwt.client.types.CriteriaPolicy
     */
    public native int compareCriteria(Criteria newCriteria, Criteria oldCriteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.compareCriteria(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), oldCriteria == null ? null : oldCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
	 * @see {@link DataSource#compareCriteria()}
	 */
	public int compareCriteria(Criteria newCriteria, Criteria oldCriteria, DSRequest requestProperties){
		return compareCriteria(newCriteria,oldCriteria,requestProperties,null);
	}
	/**
     * Given two sets of criteria, determine whether they are equivalent, the new criteria is guaranteed more restrictive, or
     * the new criteria is not guaranteed more restrictive, returning 0, 1 or -1 respectively. <P> Comparisons between {@link
     * com.smartgwt.client.data.AdvancedCriteria} are made via recursively calling  Operator.compareCriteria for all criteria
     * involved. <P> For simple {@link com.smartgwt.client.data.Criteria}, by default ({@link
     * com.smartgwt.client.types.CriteriaPolicy}:"dropOnShortening"), returns: <ul> <li> -1 if the new criteria has fewer
     * properties than the old criteria (indicating that it      isn't more restrictive) <li> -1 if the value for any property
     * in the old criteria is an array and 1) the value for      the same property in the new criteria isn't an array, or 2) is
     * an array but      of different length, or 3) the arrays do not contain the exact same set of objects      (order can be
     * different) <li> -1 if the value for any given property in the old criteria is not an array, and the      the value for
     * the same property property in the new criteria is different <li> -1 if both values for a given property are strings and
     * the new criteria value doesn't      contain the old criteria value <li> 1 if none of the above are true and, for at
     * least one of the properties, the      respective criteria values are both strings, and the old criteria value is a
     * substring      of, and is shorter than, the new criteria value <li> 0 otherwise (indicating the sets of criteria are
     * equivalent) </ul> <P> For ({@link com.smartgwt.client.types.CriteriaPolicy}:"dropOnChange"), returns: <ul> <li> -1 if
     * the two sets of criteria have a different number of properties <li> -1 if the value for any property in the old criteria
     * is an array and 1) the value for      the same property in the new criteria isn't an array, or 2) is an array but     
     * of different length, or 3) the arrays do not contain the exact same set of objects      (order can be different) <li> -1
     * if the value for any given property in the old criteria is not an array, and the      the value for the same property in
     * the new criteria is different <li> 0 otherwise (indicating the sets of criteria are equivalent) </ul> This method is
     * called by {@link com.smartgwt.client.data.ResultSet#compareCriteria ResultSet.compareCriteria} to determine whether a
     * change in criteria should cause the cache to be invalidated. You may want to override this method in order to mimic the
     * filtering behavior that your server performs.
     * @param newCriteria new filter criteria
     * @param oldCriteria previous filter criteria
     * @param requestProperties dataSource request properties
     * @param policy overrides {@link com.smartgwt.client.types.CriteriaPolicy}
     *
     * @return 0 if the filters are equivalent, 1 if newCriteria is guaranteed more                      restrictive, and -1 if
     * newCriteria is not guaranteed more restrictive
     * @see com.smartgwt.client.types.CriteriaPolicy
     */
    public native int compareCriteria(Criteria newCriteria, Criteria oldCriteria, DSRequest requestProperties, String policy) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.compareCriteria(newCriteria == null ? null : newCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), oldCriteria == null ? null : oldCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()(), policy);
        return ret;
    }-*/;
	/**
     * Convenience method to compare two Date objects appropriately, depending on whether the passed-in fieldName refers to a
     * field of {@link com.smartgwt.client.types.FieldType type} "datetime" or  "date".  In the former case, the dates are
     * compared using {@link com.smartgwt.client.util.Date#compareDates Date.compareDates}; in the latter case, or if the
     * supplied fieldName is null or unknown to this DataSource, the dates are compared using {@link
     * com.smartgwt.client.util.Date#compareLogicalDates Date.compareLogicalDates}.
     * @param date1 First date in comparison
     * @param date2 Second date in comparison
     * @param fieldName The name of the field for which the comparison is being run
     *
     * @return 0 if equal, -1 if first date &gt; second date, 1 if second date &gt;                  first date
     */
    public native int compareDates(Date date1, Date date2, String fieldName) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.compareDates(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date1), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date2), fieldName);
        return ret;
    }-*/;
	/**
     * Takes all relative date values found anywhere within a Criteria / AdvancedCriteria object and converts them to concrete
     * date values, returning the new criteria object.
     * @param criteria criteria to convert
     *
     * @return new copy of the criteria with all relative dates converted
     */
    public native Criteria convertRelativeDates(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.convertRelativeDates(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.data.Criteria::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
	 * @see {@link DataSource#convertRelativeDates()}
	 */
	public Criteria convertRelativeDates(Criteria criteria, String timezoneOffset){
		return convertRelativeDates(criteria,timezoneOffset,(Integer) null);
	}
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
    public native Criteria convertRelativeDates(Criteria criteria, String timezoneOffset, Integer firstDayOfWeek) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.convertRelativeDates(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), timezoneOffset, firstDayOfWeek == null ? null : firstDayOfWeek.@java.lang.Integer::intValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.data.Criteria::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Copies all DataSource field values of a Record (including a TreeNode) to a new  Record, omitting component-specific
     * metadata such as selected state from grids,  or parent folders for TreeNodes.
     * @param record The record to be copied.
     *
     * @return A new copy of the record provided as an argument, with  component-specific metata data removed.
     */
    public native Record copyRecord(Record record) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.copyRecord(record.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Copies all DataSource field values of an (Array) of Records (including a TreeNode)  to a new array of Records, omitting
     * component-specific metadata such as selected state  from grids, or parent folders for TreeNodes. This method calls 
     * {@link com.smartgwt.client.data.DataSource#copyRecord DataSource.copyRecord} for each item in the array.
     * @param records The array of Record objects to be copied.
     *
     * @return A new copy of each record provided in the array argument,  with component-specific metata data removed.
     */
    public native Record[] copyRecords(Record... records) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.copyRecords(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records));
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Download a file stored in a field of type:"binary" in a DataSource record. <P> This will trigger the browser's "Save As"
     * dialog and allow the user to save the file associated with some record. <P> Note that if this method is called for a
     * record with no associated file, the download URL may not be functional.  By default when dataSources encounter a  {@link
     * com.smartgwt.client.types.FieldType binary type fields}, an additional field, <code>&lt;fieldName&gt;_filename</code>,
     * is generated to store the filename for the binary field value. If this field is present in the data source but has no
     * value for this record, developers can assume they're working with a record with no stored file. If this field is not
     * present in some custom dataSource configuration, or the record is not loaded on the client, an additional server
     * transaction may be required to determine whether the record has an associated file before calling this method to
     * download a file. <P> See the overview of {@link com.smartgwt.client.docs.BinaryFields Binary Fields} for more details.
     * @param data Record to download.  Only required to have a value                                       for the primary key field.
     */
    public native void downloadFile(Record data) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if(!self.viewFile) { @com.smartgwt.client.util.SC::requiresServerComponents()(); }
        self.downloadFile(data.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
	 * @see {@link DataSource#downloadFile()}
	 */
	public void downloadFile(Record data, String fieldName){
		downloadFile(data,fieldName,null);
	}
	/**
     * Download a file stored in a field of type:"binary" in a DataSource record. <P> This will trigger the browser's "Save As"
     * dialog and allow the user to save the file associated with some record. <P> Note that if this method is called for a
     * record with no associated file, the download URL may not be functional.  By default when dataSources encounter a  {@link
     * com.smartgwt.client.types.FieldType binary type fields}, an additional field, <code>&lt;fieldName&gt;_filename</code>,
     * is generated to store the filename for the binary field value. If this field is present in the data source but has no
     * value for this record, developers can assume they're working with a record with no stored file. If this field is not
     * present in some custom dataSource configuration, or the record is not loaded on the client, an additional server
     * transaction may be required to determine whether the record has an associated file before calling this method to
     * download a file. <P> See the overview of {@link com.smartgwt.client.docs.BinaryFields Binary Fields} for more details.
     * @param data Record to download.  Only required to have a value                                       for the primary key field.
     * @param fieldName optional name of the binary field containing the                                         file.  If not provided, the
     * first binary field                                         is used
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     */
    public native void downloadFile(Record data, String fieldName, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if(!self.viewFile) { @com.smartgwt.client.util.SC::requiresServerComponents()(); }
        self.downloadFile(data.@com.smartgwt.client.core.DataClass::getJsObj()(), fieldName, requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Evaluate the given criterion with respect to the passed record. <P> Typically called by the  condition function of a
     * custom Operator to evaluate {@link com.smartgwt.client.data.Criterion#getCriteria sub-criteria}.
     * @param record record to evaluate
     * @param criterion criterion to use
     *
     * @return whether the record meets the supplied {@link com.smartgwt.client.data.Criterion}
     */
    public native boolean evaluateCriterion(Record record, Criterion criterion) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.evaluateCriterion(record.@com.smartgwt.client.core.DataClass::getJsObj()(), criterion.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	/**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria, retrieving matching records and
     * exporting the results.  See  {@link com.smartgwt.client.data.OperationBinding#getExportResults exportResults} or {@link
     * com.smartgwt.client.data.DSRequest#getExportResults exportResults} and for more information.
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void exportData() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.exportData();
    }-*/;

	/**
	 * @see {@link DataSource#exportData()}
	 */
	public void exportData(Criteria criteria){
		exportData(criteria,null,null);
	}

	/**
	 * @see {@link DataSource#exportData()}
	 */
	public void exportData(Criteria criteria, DSRequest requestProperties){
		exportData(criteria,requestProperties,null);
	}
	/**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria, retrieving matching records and
     * exporting the results.  See  {@link com.smartgwt.client.data.OperationBinding#getExportResults exportResults} or {@link
     * com.smartgwt.client.data.DSRequest#getExportResults exportResults} and for more information.
     * @param criteria search criteria
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     * @param callback callback to invoke on completion.  Note that this parameter                                  only applies where {@link
     * com.smartgwt.client.data.DSRequest#getExportToClient exportToClient} is                                   explicitly set
     * to false, because  file downloads do not                                   provide ordinary Smart GWT callbacks
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void exportData(Criteria criteria, DSRequest requestProperties, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.exportData(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse,data,dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}));
    }-*/;
	/**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria
     *  and retrieving matching records.
     *  <P>
     *  <b>NOTE:</b> do not attempt to override this method to create a custom DataSource.  For
     * a server-side custom DataSource, use the {@link com.smartgwt.client.docs.serverds.DataSource#serverConstructor
     * serverConstructor} attribute,
     * and the @see <a href="http://www.smartclient.com/smartgwtee/showcase/#customDataSource" target="examples">Custom
     * DataSource samples</a>.  For a
     *  client-side custom DataSource, see {@link com.smartgwt.client.data.DataSource#getDataProtocol dataProtocol:"custom"}.
     *  <P>
     * In contrast to {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData}, which creates a {@link
     * com.smartgwt.client.data.ResultSet} to manage
     *  the returned data, calling <code>dataSource.fetchData()</code> provides the returned
     *  data in the callback as a 
     *  
     *  RecordList or simple Array of Record objects.  Calling
     *  <code>dataSource.fetchData()</code> does not automatically update any visual components or
     *  caches: code in the callback passed to <code>fetchData()</code> decides what to do with
     *  the returned data. 
     *  <P>
     *  For example, given a ListGrid "myGrid" and a DataSource "employees", the following code
     *  would populate "myGrid" with data fetched from the DataSource:
     *  <pre>
     *     
     *     DataSource.get("employees").fetchData(null, new DSCallback() {
     *         public void execute(DSResponse response, Object rawData, DSRequest request) {
     *             myGrid.setData(response.getData());
     *         }
     *     });
     *  </pre>
     *  Unlike calling <code>myGrid.fetchData()</code>, which creates a {@link com.smartgwt.client.data.ResultSet}, the
     *  data provided to the grid is "disconnected" data, unmanaged by Smart GWT's databinding
     *  facilities and safe to directly modify.  This is useful when, for example, a ListGrid is
     *  being used as a more sophisticated version of HTML's multi-select component.
     *  <P>
     *  Disconnected datasets may be used to populate various visual components.  For example,
     *  while an individual FormItem can be configured to fetch
     *  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap} options from a DataSource via the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} property, the following
     * code shows
     *  storing a dataset to derive valueMaps from later:
     *  <pre>
     *     
     *     
     *       // Assume GlobalStore.allCountries is a public static variable of type RecordList 
     *       DataSource.get("countries").fetchData(null, new DSCallback(){
     *          public void execute(DSResponse response, Object rawData, DSRequest request) {
     *             GlobalStore.allCountries = response.getDataAsRecordList();
     *          }
     *       });
     *       ... later, while a DynamicForm is being created ...    
     *       SelectItem select = new SelectItem("country", "Pick Country");
     *       Map valueMap = GlobalStore.countries.getValueMap("countryId", "countryName");
     *       myItem.setValueMap(new LinkedHashMap(valueMap));
     *     
     *  </pre>
     *  <P>
     *  You can also create a ResultSet from the data retrieved from <code>fetchData()</code>,
     *  like so:
     *  <pre>
     *     
     *     
     *     DataSource.get("countries").fetchData(null, new DSCallback() {
     *         public void execute(DSResponse response, Object rawData, DSRequest request) {
     *             ResultSet rs = new ResultSet(DataSource.get("countries"));
     *             rs.setAllRows(response.getData());
     *         }
     *     });
     *     
     *  </pre>
     *  <P>
     *  This gives you a dataset that supports client-side filtering (via
     *  {@link com.smartgwt.client.data.ResultSet#setCriteria setCriteria()}), can provide 
     *  {@link com.smartgwt.client.data.ResultSet#getValueMap filtered valueMaps}, will 
     *  {@link com.smartgwt.client.data.ResultSet#getDisableCacheSync automatically reflect updates} to the DataSource made via
     *  other components, and can be re-used with multiple visual components.
     *  <P>
     * See also {@link com.smartgwt.client.data.DataSource#getClientOnlyDataSource DataSource.getClientOnlyDataSource} and
     * {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} for
     *  similar capabilities for dealing with smaller datasets entirely within the browser, or working
     *  with modifiable caches representing subsets of the data available from a DataSource.
     *  <P>
     *  See also the server-side com.isomorphic.js.JSTranslater class in the
     *  ${isc.DocUtils.linkForDocNode('javaServerReference', 'Java Server Reference')} for other, similar approaches
     *  involving dumping data into the page during initial page load.  <b>Note:</b> care should
     *  be taken when using this approach.  Large datasets degrade the basic performance of some
     *  browsers, so use  optionDataSource and similar
     *  facilities to manage datasets that may become very large.
     *  <P>
     *  <b>Data-Driven Visual Component Creation</b>
     *  <P>
     *  
     *  
     *  <code>DataSource.fetchData()</code> can also be used to create Smart GWT components in a
     *  data-driven way.  For example, if you had a DataSource "myGridFields" whose fields included the
     *  basic properties of {@link com.smartgwt.client.widgets.grid.ListGridField} (name, title, type,
     *  etc), this example code would create a form based on stored field definitions, loaded from the
     *  "myFormFields" DataSource on the fly: 
     *  <pre>    
     *    DataSource.get("myFormFields").fetchData(null, new DSCallback(){
     *        public void execute(DSResponse response, Object rawData, DSRequest request) {
     *           Record[] records = response.getData();
     *           ListGridField[] fields = new ListGridField[records.length];
     *           for (Record record in records) {
     *               ListGridField field = new ListGridField();
     *               field.setName(record.getAttribute("name"));
     *               field.setTitle(record.getAttribute("title"));
     *               field.setType(ListGridFieldType.valueOf(record.getAttribute("type")));
     *           }
     *           ListGrid grid = new ListGrid();
     *           grid.setFields(fields);
     *        }
     *    });
     *  </pre>  
     *  
     *  This capability to dynamically create visual components from dynamically fetched data
     *  provides a foundation for creating interfaces that can be customized by end users.
     *  See also the server-side API com.isomorphic.datasource.DataSource.addDynamicDSGenerator() for
     *  dynamically creating DataSources supporting all server-side DataSource features, and
     * {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom} for sharing field definitions across multiple
     * DataSources.
     * 
     * 
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

	/**
	 * @see {@link DataSource#fetchData()}
	 */
	public void fetchData(Criteria criteria){
		fetchData(criteria,null,null);
	}

	/**
	 * @see {@link DataSource#fetchData()}
	 */
	public void fetchData(Criteria criteria, DSCallback callback){
		fetchData(criteria,callback,null);
	}
	/**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria
     *  and retrieving matching records.
     *  <P>
     *  <b>NOTE:</b> do not attempt to override this method to create a custom DataSource.  For
     * a server-side custom DataSource, use the {@link com.smartgwt.client.docs.serverds.DataSource#serverConstructor
     * serverConstructor} attribute,
     * and the @see <a href="http://www.smartclient.com/smartgwtee/showcase/#customDataSource" target="examples">Custom
     * DataSource samples</a>.  For a
     *  client-side custom DataSource, see {@link com.smartgwt.client.data.DataSource#getDataProtocol dataProtocol:"custom"}.
     *  <P>
     * In contrast to {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData}, which creates a {@link
     * com.smartgwt.client.data.ResultSet} to manage
     *  the returned data, calling <code>dataSource.fetchData()</code> provides the returned
     *  data in the callback as a 
     *  
     *  RecordList or simple Array of Record objects.  Calling
     *  <code>dataSource.fetchData()</code> does not automatically update any visual components or
     *  caches: code in the callback passed to <code>fetchData()</code> decides what to do with
     *  the returned data. 
     *  <P>
     *  For example, given a ListGrid "myGrid" and a DataSource "employees", the following code
     *  would populate "myGrid" with data fetched from the DataSource:
     *  <pre>
     *     
     *     DataSource.get("employees").fetchData(null, new DSCallback() {
     *         public void execute(DSResponse response, Object rawData, DSRequest request) {
     *             myGrid.setData(response.getData());
     *         }
     *     });
     *  </pre>
     *  Unlike calling <code>myGrid.fetchData()</code>, which creates a {@link com.smartgwt.client.data.ResultSet}, the
     *  data provided to the grid is "disconnected" data, unmanaged by Smart GWT's databinding
     *  facilities and safe to directly modify.  This is useful when, for example, a ListGrid is
     *  being used as a more sophisticated version of HTML's multi-select component.
     *  <P>
     *  Disconnected datasets may be used to populate various visual components.  For example,
     *  while an individual FormItem can be configured to fetch
     *  {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap} options from a DataSource via the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getOptionDataSource optionDataSource} property, the following
     * code shows
     *  storing a dataset to derive valueMaps from later:
     *  <pre>
     *     
     *     
     *       // Assume GlobalStore.allCountries is a public static variable of type RecordList 
     *       DataSource.get("countries").fetchData(null, new DSCallback(){
     *          public void execute(DSResponse response, Object rawData, DSRequest request) {
     *             GlobalStore.allCountries = response.getDataAsRecordList();
     *          }
     *       });
     *       ... later, while a DynamicForm is being created ...    
     *       SelectItem select = new SelectItem("country", "Pick Country");
     *       Map valueMap = GlobalStore.countries.getValueMap("countryId", "countryName");
     *       myItem.setValueMap(new LinkedHashMap(valueMap));
     *     
     *  </pre>
     *  <P>
     *  You can also create a ResultSet from the data retrieved from <code>fetchData()</code>,
     *  like so:
     *  <pre>
     *     
     *     
     *     DataSource.get("countries").fetchData(null, new DSCallback() {
     *         public void execute(DSResponse response, Object rawData, DSRequest request) {
     *             ResultSet rs = new ResultSet(DataSource.get("countries"));
     *             rs.setAllRows(response.getData());
     *         }
     *     });
     *     
     *  </pre>
     *  <P>
     *  This gives you a dataset that supports client-side filtering (via
     *  {@link com.smartgwt.client.data.ResultSet#setCriteria setCriteria()}), can provide 
     *  {@link com.smartgwt.client.data.ResultSet#getValueMap filtered valueMaps}, will 
     *  {@link com.smartgwt.client.data.ResultSet#getDisableCacheSync automatically reflect updates} to the DataSource made via
     *  other components, and can be re-used with multiple visual components.
     *  <P>
     * See also {@link com.smartgwt.client.data.DataSource#getClientOnlyDataSource DataSource.getClientOnlyDataSource} and
     * {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} for
     *  similar capabilities for dealing with smaller datasets entirely within the browser, or working
     *  with modifiable caches representing subsets of the data available from a DataSource.
     *  <P>
     *  See also the server-side com.isomorphic.js.JSTranslater class in the
     *  ${isc.DocUtils.linkForDocNode('javaServerReference', 'Java Server Reference')} for other, similar approaches
     *  involving dumping data into the page during initial page load.  <b>Note:</b> care should
     *  be taken when using this approach.  Large datasets degrade the basic performance of some
     *  browsers, so use  optionDataSource and similar
     *  facilities to manage datasets that may become very large.
     *  <P>
     *  <b>Data-Driven Visual Component Creation</b>
     *  <P>
     *  
     *  
     *  <code>DataSource.fetchData()</code> can also be used to create Smart GWT components in a
     *  data-driven way.  For example, if you had a DataSource "myGridFields" whose fields included the
     *  basic properties of {@link com.smartgwt.client.widgets.grid.ListGridField} (name, title, type,
     *  etc), this example code would create a form based on stored field definitions, loaded from the
     *  "myFormFields" DataSource on the fly: 
     *  <pre>    
     *    DataSource.get("myFormFields").fetchData(null, new DSCallback(){
     *        public void execute(DSResponse response, Object rawData, DSRequest request) {
     *           Record[] records = response.getData();
     *           ListGridField[] fields = new ListGridField[records.length];
     *           for (Record record in records) {
     *               ListGridField field = new ListGridField();
     *               field.setName(record.getAttribute("name"));
     *               field.setTitle(record.getAttribute("title"));
     *               field.setType(ListGridFieldType.valueOf(record.getAttribute("type")));
     *           }
     *           ListGrid grid = new ListGrid();
     *           grid.setFields(fields);
     *        }
     *    });
     *  </pre>  
     *  
     *  This capability to dynamically create visual components from dynamically fetched data
     *  provides a foundation for creating interfaces that can be customized by end users.
     *  See also the server-side API com.isomorphic.datasource.DataSource.addDynamicDSGenerator() for
     *  dynamically creating DataSources supporting all server-side DataSource features, and
     * {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom} for sharing field definitions across multiple
     * DataSources.
     * 
     * 
     * @param criteria search criteria
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse,data,dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Fetch a single record from the DataSource by {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primary key}.
     * This simply calls {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} after creating {@link
     * com.smartgwt.client.data.Criteria} that contain the primary key field and value. <p> If you call this method on a
     * DataSource with a composite primary key - ie, one with  multiple primaryKey fields - this method returns the first
     * record where the first  defined primary field matches the supplied pkValue; this may or may not be meaningful, 
     * depending on your use case.  Generally, for DataSources with composite keys, it makes more sense to use
     * <code>fetchData()</code> directly, rather than this convenience  method.
     * @param pkValue value for the field marked                      {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey
     * primaryKey}:true in this DataSource                      (or the first field so marked if there is more than one)
     */
    public native void fetchRecord(Object pkValue) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.fetchRecord(pkValue);
    }-*/;

	/**
	 * @see {@link DataSource#fetchRecord()}
	 */
	public void fetchRecord(Object pkValue, DSCallback callback){
		fetchRecord(pkValue,callback,null);
	}
	/**
     * Fetch a single record from the DataSource by {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primary key}.
     * This simply calls {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} after creating {@link
     * com.smartgwt.client.data.Criteria} that contain the primary key field and value. <p> If you call this method on a
     * DataSource with a composite primary key - ie, one with  multiple primaryKey fields - this method returns the first
     * record where the first  defined primary field matches the supplied pkValue; this may or may not be meaningful, 
     * depending on your use case.  Generally, for DataSources with composite keys, it makes more sense to use
     * <code>fetchData()</code> directly, rather than this convenience  method.
     * @param pkValue value for the field marked                      {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey
     * primaryKey}:true in this DataSource                      (or the first field so marked if there is more than one)
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on the                                                   DSRequest that will be issued
     */
    public native void fetchRecord(Object pkValue, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.fetchRecord(pkValue, 
			$entry( function(dsResponse,data,dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Compares a criteria value to a field value and returns whether they match, as follows: <ul> <li> any non-String filter
     * value is directly compared (==) to the field value <li> any String filter value is compared according to      {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} in the passed <code>requestProperties</code>,     
     * regardless of the actual field type <li> if the filter value is an Array, it matches if the field value is contained in
     * the      Array </ul>
     * @param fieldValue field value to be compared
     * @param filterValue filter value to be compared
     *
     * @return true if the filter and field values match, false otherwise
     */
    public native boolean fieldMatchesFilter(Object fieldValue, Object filterValue) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.fieldMatchesFilter(fieldValue, filterValue);
        return ret;
    }-*/;
	/**
     * Compares a criteria value to a field value and returns whether they match, as follows: <ul> <li> any non-String filter
     * value is directly compared (==) to the field value <li> any String filter value is compared according to      {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} in the passed <code>requestProperties</code>,     
     * regardless of the actual field type <li> if the filter value is an Array, it matches if the field value is contained in
     * the      Array </ul>
     * @param fieldValue field value to be compared
     * @param filterValue filter value to be compared
     * @param requestProperties optional dataSource request properties
     *
     * @return true if the filter and field values match, false otherwise
     */
    public native boolean fieldMatchesFilter(Object fieldValue, Object filterValue, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.fieldMatchesFilter(fieldValue, filterValue, requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	/**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria and retrieving matching records.
     * <P> This is identical to {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is set to "substring" to cause case insensitive
     * substring matching (if the server respects this setting).
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void filterData() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.filterData();
    }-*/;

	/**
	 * @see {@link DataSource#filterData()}
	 */
	public void filterData(Criteria criteria){
		filterData(criteria,null,null);
	}

	/**
	 * @see {@link DataSource#filterData()}
	 */
	public void filterData(Criteria criteria, DSCallback callback){
		filterData(criteria,callback,null);
	}
	/**
     * Perform a "fetch" DataSource operation against this DataSource, sending search criteria and retrieving matching records.
     * <P> This is identical to {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData} except that {@link
     * com.smartgwt.client.data.DSRequest#getTextMatchStyle textMatchStyle} is set to "substring" to cause case insensitive
     * substring matching (if the server respects this setting).
     * @param criteria search criteria
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse,data,dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Produces a clientOnly "copy" of a particular subset of data from a normal  DataSource, via calling fetchData() to fetch
     * matching rows, and constructing  a clientOnly DataSource that {@link com.smartgwt.client.data.DataSource#getInheritsFrom
     * inheritsFrom} the original DataSource. <P> This clientOnly "copy" can be useful in situations where you want to allow  a
     * series of local changes without immediately committing to the server.   See also {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} for more fine-grained tracking of  edits (eg,
     * special styling for uncommitted changes). <P> The new DataSource is returned via the "callback" argument.  If {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} is enabled and {@link
     * com.smartgwt.client.data.DataSource#hasAllData DataSource.hasAllData} returns true, the new DataSource is synchronously
     * returned as the result of the method.  In this case, if a callback was passed, it also is executed synchronously.
     * @param criteria The criteria for the clientOnly DS
     * @param callback The callback to fire passing the clientOnly DS
     */
    public native void getClientOnlyDataSource(Criteria criteria, ClientOnlyDataSourceCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.getClientOnlyDataSource(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(clientOnly) { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.ClientOnlyDataSourceCallback::execute(Lcom/smartgwt/client/data/DataSource;)(
					@com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(clientOnly)
				);
			}));
    }-*/;

	/**
	 * @see {@link DataSource#getClientOnlyDataSource()}
	 */
	public void getClientOnlyDataSource(Criteria criteria, ClientOnlyDataSourceCallback callback, DSRequest requestProperties){
		getClientOnlyDataSource(criteria,callback,requestProperties,null);
	}
	/**
     * Produces a clientOnly "copy" of a particular subset of data from a normal  DataSource, via calling fetchData() to fetch
     * matching rows, and constructing  a clientOnly DataSource that {@link com.smartgwt.client.data.DataSource#getInheritsFrom
     * inheritsFrom} the original DataSource. <P> This clientOnly "copy" can be useful in situations where you want to allow  a
     * series of local changes without immediately committing to the server.   See also {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits} for more fine-grained tracking of  edits (eg,
     * special styling for uncommitted changes). <P> The new DataSource is returned via the "callback" argument.  If {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} is enabled and {@link
     * com.smartgwt.client.data.DataSource#hasAllData DataSource.hasAllData} returns true, the new DataSource is synchronously
     * returned as the result of the method.  In this case, if a callback was passed, it also is executed synchronously.
     * @param criteria The criteria for the clientOnly DS
     * @param callback The callback to fire passing the clientOnly DS
     * @param requestProperties optional properties to pass through to the DSRequest
     * @param dataSourceProperties optional properties to pass                                                        through to the clientOnly DS
     */
    public native void getClientOnlyDataSource(Criteria criteria, ClientOnlyDataSourceCallback callback, DSRequest requestProperties, DataSource dataSourceProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.getClientOnlyDataSource(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(clientOnly) { 
				if(callback!=null) callback.@com.smartgwt.client.callbacks.ClientOnlyDataSourceCallback::execute(Lcom/smartgwt/client/data/DataSource;)(
					@com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(clientOnly)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()(), dataSourceProperties == null ? null : dataSourceProperties.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
    }-*/;
	/**
     * Return a "spoofed" response for a {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly} or {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} DataSource. <P> The default implementation will use
     * {@link com.smartgwt.client.data.DataSource#getCacheData cacheData} to provide an appropriate response, by using {@link
     * com.smartgwt.client.data.DataSource#applyFilter client-side filtering} for a "fetch" request, and by modifying the
     * <code>testData</code> for other requests. <P> Override this method to provide simulations of other server-side behavior,
     * such as modifying other records, or to implement <b>synchronous</b> client-side data providers (such as Google Gears). 
     * For <b>asynchronous</b> third-party data providers, such as GWT-RPC, HTML5 sockets, or bridges to plug-in based
     * protocols (Java, Flash, Silverlight..), use {@link com.smartgwt.client.types.DSProtocol dataProtocol:"clientCustom"}
     * instead.  <P> Overriding this method is also a means of detecting that a normal DataSource (not clientOnly) would be
     * contacting the server.
     * @param request DataSource request to respond to
     * @param serverData for cacheAllData DataSources, the data from the local cache
     *
     * @return 
     */
    protected native DSResponse getClientOnlyResponse(DSRequest request, Record... serverData) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.__getClientOnlyResponse(request.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(serverData));
        if(ret == null) return null;
        return @com.smartgwt.client.data.DSResponse::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Given a fieldName and a dataValue, apply any {@link com.smartgwt.client.data.DataSourceField#getValueMap valueMap} for
     * the field and return the display value for the field
     * @param fieldName name of the field to retrieve a value for
     * @param value data value for the field
     *
     * @return display value for the field
     */
    public native Object getDisplayValue(String fieldName, Object value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getDisplayValue(fieldName, value);
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;
	/**
     * Returns a URL to DataSource fetch operation.  This API is intended to return media such as images or videos to the
     * browser.   <P> Note that because the entirety of the request is encoded in the URL, there is an inherent limitation on
     * the amount of data that you can send viat he criteria argument to the server.  The actual length depends on your server
     * configuration and other factors such as the size of cookies (if any) being sent to the server and other HTTP headers in
     * use.  Conservatively, assume that you have about 2 kilobytes to work with.
     * @param criteria Criteria to be sent to server.
     *
     * @return a URL that targets the specified fetch operation.
     */
    public native String getFetchDataURL(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getFetchDataURL(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	/**
     * Returns a URL to DataSource fetch operation.  This API is intended to return media such as images or videos to the
     * browser.   <P> Note that because the entirety of the request is encoded in the URL, there is an inherent limitation on
     * the amount of data that you can send viat he criteria argument to the server.  The actual length depends on your server
     * configuration and other factors such as the size of cookies (if any) being sent to the server and other HTTP headers in
     * use.  Conservatively, assume that you have about 2 kilobytes to work with.
     * @param criteria Criteria to be sent to server.
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     *
     * @return a URL that targets the specified fetch operation.
     */
    public native String getFetchDataURL(Criteria criteria, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getFetchDataURL(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
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
        if(ret == null) return null;
        return @com.smartgwt.client.data.DataSourceField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Returns the depth-first match of a criterion matching the given fieldName.
     * @param criterion the criteria to search
     * @param fieldName the fieldName to find criteria for
     *
     * @return the depth-first matching criterion for the passed fieldName
     */
    public native Criteria getFieldCriterion(Criteria criterion, String fieldName) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getFieldCriterion(criterion == null ? null : criterion.@com.smartgwt.client.core.DataClass::getJsObj()(), fieldName);
        if(ret == null) return null;
        return @com.smartgwt.client.data.Criteria::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Return the field definition object corresponding to the supplied dataPath
     * @param dataPath dataPath of the field to retrieve
     *
     * @return field object, or null if no field corresponds to the                            supplied dataPath
     */
    public native DataSourceField getFieldForDataPath(String dataPath) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getFieldForDataPath(dataPath);
        if(ret == null) return null;
        return @com.smartgwt.client.data.DataSourceField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
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
     * Returns a pointer to the primaryKey field for this DataSource.  If this dataSource has a composite primary key (ie,
     * multiple primaryKey fields), returns just the first  primaryKey field.
     *
     * @return primary key field object
     * @see com.smartgwt.client.data.DataSource#getPrimaryKeyFields
     */
    public native DataSourceField getPrimaryKeyField() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getPrimaryKeyField();
        if(ret == null) return null;
        return @com.smartgwt.client.data.DataSourceField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Returns the primary key fieldName for this DataSource.    If this dataSource has a composite primary key (ie, multiple
     * primaryKey fields), returns just the first  primaryKey field name.
     *
     * @return primary key field name
     * @see com.smartgwt.client.data.DataSource#getPrimaryKeyFieldNames
     */
    public native String getPrimaryKeyFieldName() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getPrimaryKeyFieldName();
        return ret;
    }-*/;
	/**
     * Returns a list of the names of this DataSource's  {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey
     * primaryKey} fields.
     *
     * @return The list of the names of this datasource's primaryKey fields
     * @see com.smartgwt.client.data.DataSource#getPrimaryKeyFields
     */
    public native String[] getPrimaryKeyFieldNames() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getPrimaryKeyFieldNames();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfString(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Returns this DataSource's {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} fields as a map of
     * fieldName to field.
     *
     * @return Javascript object containing all this datasource's primaryKey fields,                  as a map of field name to field
     * @see com.smartgwt.client.data.DataSource#getPrimaryKeyField
     * @see com.smartgwt.client.data.DataSource#getPrimaryKeyFieldNames
     */
    public native Record getPrimaryKeyFields() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getPrimaryKeyFields();
        if(ret == null) return null;
        return @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
    
	/**
     * If you define this method on a DataSource, it will be called whenever the server returns a DSResponse with a status
     * other than {@link com.smartgwt.client.rpc.RPCResponse#STATUS_SUCCESS STATUS_SUCCESS}.  You can use this hook to do
     * DataSource-specific error handling.  Unless you return <code>false</code> from this method, {@link
     * com.smartgwt.client.rpc.RPCManager#handleError RPCManager.handleError} will be called by Smart GWT right after this
     * method completes.
     * 
     * @param callback HandleErrorCallback the callback to set.
     */
	public native void setHandleErrorCallback(HandleErrorCallback callback) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setProperties({
        	handleError:
			$entry( function(response,request) { 
				if(callback!=null) callback.@com.smartgwt.client.rpc.HandleErrorCallback::handleError(Lcom/smartgwt/client/data/DSResponse;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response), 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request)
				);
			})
        });
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
        var handleError = $debox($entry(function(param){
                var event = @com.smartgwt.client.data.events.ErrorEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({handleError: 
                function () {
                    var param = {"response" : arguments[0], "request" : arguments[1]};
                    return handleError(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.handleError = 
                function () {
                    var param = {"response" : arguments[0], "request" : arguments[1]};
                    return handleError(param) == true;
                }
            ;
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
        var ret = self.hasAllData();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
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
     * Invoke an operation declared with {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType}
     * "custom". <P> <b>This is a rarely used API.</b>  If the operation you are performing can be thought of as one of the
     * standard "CRUD" {@link com.smartgwt.client.types.DSOperationType operation types}, declare it with a CRUD operationType.
     * For example, if your operation updates a record, declare it with operationType "update" and invoke it via {@link
     * com.smartgwt.client.data.DataSource#updateData DataSource.updateData} - this will cause {@link
     * com.smartgwt.client.data.ResultSet cache sync} to work correctly. <P> In particular: <ul> <li> do not use this API just
     * because you need to add additional server-side logic to a CRUD operation (DMI allows this) <li> do not use this API to
     * implement variants of core CRUD operations ({@link com.smartgwt.client.data.DSRequest#getOperationId operationId} is the
     * correct way to do this) <li> do not use this API just because an operation affects more than one record.  Most kinds of
     * multi-record operations should use {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing}. <li> do not use this
     * API just because you are calling a stored procedure in SQL - if the stored procedure performs some kind of CRUD
     * operation on the records of this DataSource, use a standard CRUD operationType </ul> <P> Instead, the specific purpose
     * of this API is to bypass all checks and side effects that normally occur for CRUD operations, for example, that a
     * "fetch" requires valid Criteria or that an "update" or "remove" operation contains a valid primary key, or that an "add"
     * operation returns the newly added record.  <code>performCustomOperation</code> allows you to pass an arbitrary Record to
     * the server, act on it with custom code, and return arbitray results or even no results. <P> The "data" parameter becomes
     * {@link com.smartgwt.client.data.DSRequest#getData data}.  With the Smart GWT Server Framework, the data is accessible
     * server-side via DSRequest.getValues() and in Velocity templates (such as &lt;customSQL&gt;) as $values. <P> Note that
     * with SQLDataSource, <code>performCustomOperation</code> must be used if you plan to have a &lt;customSQL&gt; tag in your
     * operationBinding that will execute SQL operations other than SELECT, UPDATE, INSERT, DELETE (such as creating a new
     * table). By declaring {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} "custom" in your
     * .ds.xml file, all checks related to normal CRUD operations will be skipped and your &lt;customSQL&gt; can do arbitrary
     * things.
     * @param operationId the operation ID
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void performCustomOperation(String operationId) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.performCustomOperation(operationId);
    }-*/;

	/**
	 * @see {@link DataSource#performCustomOperation()}
	 */
	public void performCustomOperation(String operationId, Record data){
		performCustomOperation(operationId,data,null,null);
	}

	/**
	 * @see {@link DataSource#performCustomOperation()}
	 */
	public void performCustomOperation(String operationId, Record data, DSCallback callback){
		performCustomOperation(operationId,data,callback,null);
	}
	/**
     * Invoke an operation declared with {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType}
     * "custom". <P> <b>This is a rarely used API.</b>  If the operation you are performing can be thought of as one of the
     * standard "CRUD" {@link com.smartgwt.client.types.DSOperationType operation types}, declare it with a CRUD operationType.
     * For example, if your operation updates a record, declare it with operationType "update" and invoke it via {@link
     * com.smartgwt.client.data.DataSource#updateData DataSource.updateData} - this will cause {@link
     * com.smartgwt.client.data.ResultSet cache sync} to work correctly. <P> In particular: <ul> <li> do not use this API just
     * because you need to add additional server-side logic to a CRUD operation (DMI allows this) <li> do not use this API to
     * implement variants of core CRUD operations ({@link com.smartgwt.client.data.DSRequest#getOperationId operationId} is the
     * correct way to do this) <li> do not use this API just because an operation affects more than one record.  Most kinds of
     * multi-record operations should use {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing}. <li> do not use this
     * API just because you are calling a stored procedure in SQL - if the stored procedure performs some kind of CRUD
     * operation on the records of this DataSource, use a standard CRUD operationType </ul> <P> Instead, the specific purpose
     * of this API is to bypass all checks and side effects that normally occur for CRUD operations, for example, that a
     * "fetch" requires valid Criteria or that an "update" or "remove" operation contains a valid primary key, or that an "add"
     * operation returns the newly added record.  <code>performCustomOperation</code> allows you to pass an arbitrary Record to
     * the server, act on it with custom code, and return arbitray results or even no results. <P> The "data" parameter becomes
     * {@link com.smartgwt.client.data.DSRequest#getData data}.  With the Smart GWT Server Framework, the data is accessible
     * server-side via DSRequest.getValues() and in Velocity templates (such as &lt;customSQL&gt;) as $values. <P> Note that
     * with SQLDataSource, <code>performCustomOperation</code> must be used if you plan to have a &lt;customSQL&gt; tag in your
     * operationBinding that will execute SQL operations other than SELECT, UPDATE, INSERT, DELETE (such as creating a new
     * table). By declaring {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} "custom" in your
     * .ds.xml file, all checks related to normal CRUD operations will be skipped and your &lt;customSQL&gt; can do arbitrary
     * things.
     * @param operationId the operation ID
     * @param data data to pass to the server.
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void performCustomOperation(String operationId, Record data, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.performCustomOperation(operationId, data == null ? null : data.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse,data,dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Process a dsResponse for a request initiated by a DataSource with
     *  {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol:"clientCustom"}.
     *  <code>requestId</code> parameter should be dsRequest.requestId as found on the dsRequest
     *  passed to {@link com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest}.
     *  <P>
     *  You must provide a response for both error and non-error cases.  For an error case, a
     *  sufficient response is:
     *  <pre>
     *  { status : -1 }
     *  </pre>
     * 
     * @param requestId requestId attribute from the associated dataSource request object
     * @param dsResponse Configuration for the dsResponse
     */
    public native void processResponse(String requestId, DSResponse dsResponse) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.processResponse(requestId, dsResponse.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Perform a "remove" DataSource operation against this DataSource, to delete an existing DataSource record.
     * @param data primary key values of record to delete,                                             (or complete record)
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void removeData(Record data) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeData(data.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
	 * @see {@link DataSource#removeData()}
	 */
	public void removeData(Record data, DSCallback callback){
		removeData(data,callback,null);
	}
	/**
     * Perform a "remove" DataSource operation against this DataSource, to delete an existing DataSource record.
     * @param data primary key values of record to delete,                                             (or complete record)
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void removeData(Record data, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeData(data.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse,data,dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Split a criteria apart based on <code>fields</code>. A new simple criteria is returned with any criteria applicable to
     * the specified fields. The passed <code>criteria</code> is then <u>modified</u> to remove these fields resulting in two
     * distinct criteria. <P> Incoming criteria can be a simple or advanced criteria. For an {@link
     * com.smartgwt.client.data.AdvancedCriteria} only a single level of criteria with a top-level operator of "and" is
     * supported. <P> To avoid modifying an original criteria, use {@link com.smartgwt.client.data.DataSource#copyCriteria
     * DataSource.copyCriteria} to make a copy to be passed in.
     * @param criteria criteria to be split. May be modified if criteria is                            extracted.
     * @param fields list of fields to extract from criteria
     *
     * @return extracted criteria
     */
    public native Criteria splitCriteria(Criteria criteria, String[] fields) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.splitCriteria(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(fields));
        if(ret == null) return null;
        return @com.smartgwt.client.data.Criteria::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Do fetch and filter operations on this dataSource support being passed  {@link
     * com.smartgwt.client.data.AdvancedCriteria}? <P> For a DataSource to support being passed AdvancedCriteria, it must be 
     * {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly:true} or {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData:true}, or have  server side logic which can process
     * AdvancedCriteria objects passed from the client. <P> AdvancedCriteria are supported on the server for standard  {@link
     * com.smartgwt.client.docs.SqlDataSource SQL}, {@link com.smartgwt.client.docs.HibernateIntegration Hibernate} and  {@link
     * com.smartgwt.client.docs.JpaIntegration JPA} DataSources in Smart GWT Enterprise or Power editions (not supported in
     * Smart GWT Pro). <P> The framework assumes that custom dataSources support AdvancedCriteria; if you have a  a custom
     * DataSOurce implementation that does not support AdvancedCriteria, you can set the {@link
     * com.smartgwt.client.data.DataSource#getAllowAdvancedCriteria allowAdvancedCriteria} property to false.
     *
     * @return true if this dataSource supports being passed AdvancedCriteria in fetch  and filter type operations, false otherwise.
     */
    public native Boolean supportsAdvancedCriteria() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.supportsAdvancedCriteria();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
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
     * For a dataSource using {@link com.smartgwt.client.docs.ClientDataIntegration client-side data integration},
     *  return the data that should be sent to the {@link com.smartgwt.client.data.DataSource#getDataURL dataURL}.
     *  <P>
     *  By default, HTTP requests sent to non-Smart GWT servers do not include DSRequest
     * metadata such as {@link com.smartgwt.client.data.DSRequest#getStartRow startRow}, {@link
     * com.smartgwt.client.data.DSRequest#getEndRow endRow},
     *  and {@link com.smartgwt.client.data.DSRequest#getOldValues oldValues}.  Only the core
     *  {@link com.smartgwt.client.docs.DataSourceOperations datasource protocol data} is sent, such as the criteria
     *  passed to {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()} or the updated values submitted by
     *  {@link com.smartgwt.client.widgets.form.DynamicForm#saveData form.saveData()}.  
     *  <P>
     *  transformRequest() allows you to transform dsRequest metadata into a
     *  format understood by your server and include it in the HTTP request, so that you can
     *  integrate DataSource features such as data paging with servers that support such
     *  features.
     *  <P>
     *  How the data is actually sent to the URL is controlled by 
     *  {@link com.smartgwt.client.data.OperationBinding#getDataProtocol dataProtocol}.  If using the "getParams" or
     *  "postParams" protocol, data is expected to be a JavaScript Object where each property
     *  will become a GET or POST'd parameter.  If using dataProtocol:"soap" or "postXML", data
     * will be serialized as an XML message by {@link com.smartgwt.client.data.DataSource#xmlSerialize
     * DataSource.xmlSerialize}.
     *  <P>
     *  As an example, if you have a dataURL that can return paged data given URL parameters
     *  "start" and "end", you could implement transformRequest like so:
     *  <pre>
     *    isc.DataSource.create({
     *       ... 
     *       transformRequest : function (dsRequest) {
     *          if (dsRequest.operationType == "fetch") {
     *              var params = {
     *                 start : dsRequest.startRow,
     *                 end : dsRequest.endRow
     *              };
     *              // combine paging parameters with criteria
     *              return isc.addProperties({}, dsRequest.data, params);
     *          }
     *       }
     *    });
     *  </pre>
     *  Other reasons to implement transformRequest():
     *  <ul>
     *  <li> transform a {@link com.smartgwt.client.data.Criteria} object into the custom query language of a web
     *       service
     *  <li> add a session id to requests that require authentication
     *  <li> detect colliding updates by sending both updated values and the values the user
     * originally retrieved before editing began (available as {@link com.smartgwt.client.data.DSRequest#getOldValues
     * oldValues})
     *  </ul>
     *  <i>Special case:</i> If the <code>dataProtocol</code> is <code>"clientCustom"</code>
     *  the Smart GWT system will not attempt to send data to the server in any way. Instead 
     *  transformRequest should be implemented such that it accesses or updates the underlying
     * data-set and calls {@link com.smartgwt.client.data.DataSource#processResponse DataSource.processResponse} when the
     * operation is complete. This
     *  setting allows straightforward integration with non Smart GWT comm mechanisms that 
     *  directly send requests to the server (such as GWT-RPC), or handle data manipulation without
     *  sending HTTP at all (such as Google Gears).
     *  <P>
     *  Note: The {@link com.smartgwt.client.data.RestDataSource} class overrides transformRequest() to handle xml-serializing
     *  the request (including meta data) into a standard format.
     * 
     * 
     * @param dsRequest the DSRequest being processed
     *
     * @return data to be sent to the dataURL
     */
    protected native Object transformRequest(DSRequest dsRequest) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.__jsTransformRequest(dsRequest.@com.smartgwt.client.core.DataClass::getJsObj()());
        return $wnd.SmartGWT.convertToJavaType(ret);
    }-*/;
	/**
     * Modify the DSResponse object derived from the response returned from the 
     *  {@link com.smartgwt.client.data.DataSource#getDataURL dataURL}.
     *  <P>
     *  This is an override point that makes it possible to use DataSource features such as
     *  paging with web services that support such features, by allowing you to fill in metadata
     *  fields in the DSResponse object (such as {@link com.smartgwt.client.data.DSResponse#getStartRow startRow}) based on
     *  service-specific metadata fields contained in the service's response.
     *  <P>
     *  The DSResponse passed to this method already has {@link com.smartgwt.client.data.DSResponse#getData data}, which is
     *  derived differently depending on the {@link com.smartgwt.client.data.DataSource#getDataFormat dataFormat} setting:
     *  <ul>
     *  <li> <code>dataFormat:"xml"</code> : either the
     *  {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath} or 
     *  {@link com.smartgwt.client.data.OperationBinding#getRecordName recordName} is used to select the XML elements
     *  that represent DataSource records.  The selected XML elements are passed to
     * {@link com.smartgwt.client.data.DataSource#recordsFromXML DataSource.recordsFromXML}, which transforms the XML elements
     * to typed
     *  JavaScript data using the DataSource as a schema.
     *  <li> <code>dataFormat:"json"</code> : the
     *  {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}, if specified, is used to select
     * records from the returned JSON data via {@link com.smartgwt.client.data.XMLTools#selectObjects XMLTools.selectObjects}. 
     * 
     * {@link com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath} is used to derive correctly typed field
     * values.
     *  <li> <code>dataFormat:"custom"</code> : <code>dsResponse.data</code> is the raw response
     *  in String form.  It must be parsed into an Array of Objects for subsequent processing to
     *  work.
     *  </ul> 
     *  <P>
     *  In addition to <code>dsResponse.data</code>, {@link com.smartgwt.client.data.DSResponse#getStatus status} is defaulted
     *  to 0 (indicating no error), and {@link com.smartgwt.client.data.DSResponse#getStartRow startRow} is assumed to be zero,
     * with {@link com.smartgwt.client.data.DSResponse#getEndRow endRow} and {@link
     * com.smartgwt.client.data.DSResponse#getTotalRows totalRows}
     *  both set to <code>dsResponse.data.length - 1</code>, that is, the returned data is
     *  assumed to be all records that matched the filter criteria.
     *  <P>
     *  Examples of using this API include:
     *  <ul>
     *  <li> setting {@link com.smartgwt.client.data.DSResponse#getStartRow startRow}, 
     * {@link com.smartgwt.client.data.DSResponse#getEndRow endRow} and {@link com.smartgwt.client.data.DSResponse#getTotalRows
     * totalRows}
     *       to allow paging for a service that supports it.  For example, if an XML service
     *       returns a "resultRow" tag that contained the row number of the first row of the
     *       returned results:<pre>
     *     dsResponse.startRow = 
     *         isc.XMLTools.selectNumber(xmlData, "//resultRow");
     *  </pre>
     *  <li> setting {@link com.smartgwt.client.data.DSResponse#getStatus status} to recognized ISC error values based on
     *       service-specific errors, in order to trigger standard ISC error handling.  For
     *       example, setting <code>dsResponse.status</code> to
     *       {@link com.smartgwt.client.rpc.RPCResponse#STATUS_VALIDATION_ERROR STATUS_VALIDATION_ERROR} and filling in
     *       {@link com.smartgwt.client.data.DSResponse#getErrors errors} in order to cause validation errors to be shown in
     *       forms and grids.
     *  <li> for services that either do not return cache update data, or return partial data,
     *     using {@link com.smartgwt.client.data.DSRequest#getOldValues oldValues} to create cache update data (whether this is
     *       appropriate is application-specific), or setting
     *       {@link com.smartgwt.client.data.DSResponse#getInvalidateCache invalidateCache}.
     *  </ul>
     *  <P>
     *  <span STYLE="color:red">NOTE:</span> this method is NOT an appropriate time to call
     *  methods on visual components such as grids, initiate new DSRequests or RPCRequests, or
     *  in general do anything other than fill in fields on the DSResponse based on data that is
     *  already available.  Any actions that need to be taken as a result of the web
     *  service response should be implemented exactly as for a DataSource where
     *  <code>transformResponse()</code> has not been overridden, that is, use the callback
     *  passed to high-level methods such as 
     *  {@link com.smartgwt.client.docs.DataBoundComponentMethods <code>grid.fetchData()</code>}, and do error
     * handling via either {@link com.smartgwt.client.data.DataSource#addHandleErrorHandler DataSource.handleError} or by
     * setting
     *  {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError willHandleError}.
     * 
     * 
     * @param dsResponse default DSResponse derived from the response data
     * @param dsRequest DSRequest object that initiated this request
     * @param data XML document or JSON objects returned by the web                                   service
     * 
     */
    protected native void transformResponse(DSResponse dsResponse, DSRequest dsRequest, Object data) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.__jsTransformResponse(dsResponse.@com.smartgwt.client.core.DataClass::getJsObj()(), dsRequest.@com.smartgwt.client.core.DataClass::getJsObj()(), data);
    }-*/;
	/**
     * Causes any components using this DataSource to be notified of changes that have been made to the remote dataset accessed
     * via this DataSource, as though the provided DSResponse had just successfully completed.  This will cause cache managers
     * such as {@link com.smartgwt.client.data.ResultSet} or  {@link com.smartgwt.client.widgets.tree.ResultTree} to
     * automatically update their caches, and components using such cache managers to visually update to show modified data.
     * <P> This API should be used when you have found out about changes made by other users or by automatic processes.  For
     * example, using the Smart GWT {@link com.smartgwt.client.data.DataSource#getMessaging Messaging} system to receive
     * real-time updates via HTTP streaming, you may get updates that should affect a ListGrid which is using a ResultSet to
     * view a portion of a large dataset.   <P> The provided <code>DSResponse</code> should have {@link
     * com.smartgwt.client.data.DSResponse#getOperationType operationType} "update", "add" or "remove" - there is no way for a
     * "fetch" response to meaningfully update arbitrary caches.  However, if you have a list of updated records (possibly
     * retrieved via {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData}) you can call
     * <code>updateCaches()</code> multiple times with DSResponses of type "update" formed from the list of records retrieved
     * via <code>fetchData()</code> <P> To cause all components that have cache managers to drop their caches, provide a
     * DSResponse with {@link com.smartgwt.client.data.DSResponse#getInvalidateCache invalidateCache} set. <P> As an
     * alternative to calling <code>updateCaches()</code> directly, if updates to other DataSources occur as a result of
     * server-side logic, you can use the server-side API DSResponse.addRelatedUpdate(DSResponse) (Pro Edition and above),
     * which ultimately calls <code>updateCaches()</code> for you - see that method's documentation for details. <P>
     * <b>NOTE:</b>: this API should <b>not</b> be used with a {@link com.smartgwt.client.data.DataSource#getClientOnly
     * clientOnly} DataSource, because in this case, the "remote dataset" is actually within the browser.  Instead,  {@link
     * com.smartgwt.client.data.DataSource#updateData DataSource.updateData}, addData() or removeData() can be called in order
     * to both change the dataset stored inside the browser and notify all cache managers. <P> If a DataSource has {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} set and a full cache has been obtained, calling
     * <code>updateCaches</code> will automatically update the cache. <P> Note that the DSResponse provided to this method will
     * <b>not</b> go through {@link com.smartgwt.client.data.DataSource#transformResponse DataSource.transformResponse} or
     * other processing that would normally occur for a DSResponse resulting from a DSRequest sent by the application in this
     * page.
     * @param dsResponse the provided DSResponse must minimally have                                 dataSource, operationType, and data set
     */
    public native void updateCaches(DSResponse dsResponse) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.updateCaches(dsResponse.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Causes any components using this DataSource to be notified of changes that have been made to the remote dataset accessed
     * via this DataSource, as though the provided DSResponse had just successfully completed.  This will cause cache managers
     * such as {@link com.smartgwt.client.data.ResultSet} or  {@link com.smartgwt.client.widgets.tree.ResultTree} to
     * automatically update their caches, and components using such cache managers to visually update to show modified data.
     * <P> This API should be used when you have found out about changes made by other users or by automatic processes.  For
     * example, using the Smart GWT {@link com.smartgwt.client.data.DataSource#getMessaging Messaging} system to receive
     * real-time updates via HTTP streaming, you may get updates that should affect a ListGrid which is using a ResultSet to
     * view a portion of a large dataset.   <P> The provided <code>DSResponse</code> should have {@link
     * com.smartgwt.client.data.DSResponse#getOperationType operationType} "update", "add" or "remove" - there is no way for a
     * "fetch" response to meaningfully update arbitrary caches.  However, if you have a list of updated records (possibly
     * retrieved via {@link com.smartgwt.client.data.DataSource#fetchData DataSource.fetchData}) you can call
     * <code>updateCaches()</code> multiple times with DSResponses of type "update" formed from the list of records retrieved
     * via <code>fetchData()</code> <P> To cause all components that have cache managers to drop their caches, provide a
     * DSResponse with {@link com.smartgwt.client.data.DSResponse#getInvalidateCache invalidateCache} set. <P> As an
     * alternative to calling <code>updateCaches()</code> directly, if updates to other DataSources occur as a result of
     * server-side logic, you can use the server-side API DSResponse.addRelatedUpdate(DSResponse) (Pro Edition and above),
     * which ultimately calls <code>updateCaches()</code> for you - see that method's documentation for details. <P>
     * <b>NOTE:</b>: this API should <b>not</b> be used with a {@link com.smartgwt.client.data.DataSource#getClientOnly
     * clientOnly} DataSource, because in this case, the "remote dataset" is actually within the browser.  Instead,  {@link
     * com.smartgwt.client.data.DataSource#updateData DataSource.updateData}, addData() or removeData() can be called in order
     * to both change the dataset stored inside the browser and notify all cache managers. <P> If a DataSource has {@link
     * com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} set and a full cache has been obtained, calling
     * <code>updateCaches</code> will automatically update the cache. <P> Note that the DSResponse provided to this method will
     * <b>not</b> go through {@link com.smartgwt.client.data.DataSource#transformResponse DataSource.transformResponse} or
     * other processing that would normally occur for a DSResponse resulting from a DSRequest sent by the application in this
     * page.
     * @param dsResponse the provided DSResponse must minimally have                                 dataSource, operationType, and data set
     * @param dsRequest optional dsRequest.  If not specified, a DSRequest will be                                automatically created based on
     * the DataSource and operationType of                                the DSResponse
     */
    public native void updateCaches(DSResponse dsResponse, DSRequest dsRequest) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.updateCaches(dsResponse.@com.smartgwt.client.core.DataClass::getJsObj()(), dsRequest == null ? null : dsRequest.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Perform an "update" DataSource operation against this DataSource, to update values in an existing DataSource record.
     * @param updatedRecord updated record
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void updateData(Record updatedRecord) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.updateData(updatedRecord.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
	 * @see {@link DataSource#updateData()}
	 */
	public void updateData(Record updatedRecord, DSCallback callback){
		updateData(updatedRecord,callback,null);
	}
	/**
     * Perform an "update" DataSource operation against this DataSource, to update values in an existing DataSource record.
     * @param updatedRecord updated record
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void updateData(Record updatedRecord, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.updateData(updatedRecord.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse,data,dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Contacts the server to run server-side validation on a DSRequest and either returns {@link
     * com.smartgwt.client.data.DSResponse#getErrors errors} validation errors or a {@link
     * com.smartgwt.client.data.DSResponse#getStatus status} code of 0. <p> A "validate" dsRequest is effectively always {@link
     * com.smartgwt.client.rpc.RPCRequest#getWillHandleError willHandleError}:true. It is a normal condition for a "validate"
     * DSResponse to have validation errors and the response will never go to system-wide handling for unexpected errors
     * ({@link com.smartgwt.client.rpc.RPCManager#handleError RPCManager.handleError}).
     * @param values record values to validate
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void validateData(Record values) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.validateData(values.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
	 * @see {@link DataSource#validateData()}
	 */
	public void validateData(Record values, DSCallback callback){
		validateData(values,callback,null);
	}
	/**
     * Contacts the server to run server-side validation on a DSRequest and either returns {@link
     * com.smartgwt.client.data.DSResponse#getErrors errors} validation errors or a {@link
     * com.smartgwt.client.data.DSResponse#getStatus status} code of 0. <p> A "validate" dsRequest is effectively always {@link
     * com.smartgwt.client.rpc.RPCRequest#getWillHandleError willHandleError}:true. It is a normal condition for a "validate"
     * DSResponse to have validation errors and the response will never go to system-wide handling for unexpected errors
     * ({@link com.smartgwt.client.rpc.RPCManager#handleError RPCManager.handleError}).
     * @param values record values to validate
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on                                                   the DSRequest that will be issued
     * @see com.smartgwt.client.docs.Operations Operations overview and related methods
     */
    public native void validateData(Record values, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.validateData(values.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(dsResponse,data,dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	/**
     * Display a file stored in a field of type:"binary" in a new browser window. <P> This will open a new browser window to
     * show the file.  Depending on the file type, the user's installed plugins and applications, and the user's browser
     * settings, this may cause the file to be actually displayed in the new browser window, or may prompt the user to either
     * launch an external application to view the file or save the file to disk. <P> Note that if this method is called for a
     * record with no associated file, the target window's new URL may not be functional.  By default when dataSources
     * encounter a  {@link com.smartgwt.client.types.FieldType binary type fields}, an additional field,
     * <code>&lt;fieldName&gt;_filename</code>, is generated to store the filename for the binary field value. If this field is
     * present in the data source but has no value for this record, developers can assume they're working with a record with no
     * stored file. If this field is not present in some custom dataSource configuration, or the record is not loaded on the
     * client, an additional server transaction may be required to determine whether the record has an associated file before
     * calling this method to view a file. <P> See the overview of {@link com.smartgwt.client.docs.BinaryFields Binary Fields}
     * for details.
     * @param data Record to download.  Only required to have a value                                       for the primary key field.
     */
    public native void viewFile(Record data) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if(!self.viewFile) { @com.smartgwt.client.util.SC::requiresServerComponents()(); }
        self.viewFile(data.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
	 * @see {@link DataSource#viewFile()}
	 */
	public void viewFile(Record data, String fieldName){
		viewFile(data,fieldName,null);
	}
	/**
     * Display a file stored in a field of type:"binary" in a new browser window. <P> This will open a new browser window to
     * show the file.  Depending on the file type, the user's installed plugins and applications, and the user's browser
     * settings, this may cause the file to be actually displayed in the new browser window, or may prompt the user to either
     * launch an external application to view the file or save the file to disk. <P> Note that if this method is called for a
     * record with no associated file, the target window's new URL may not be functional.  By default when dataSources
     * encounter a  {@link com.smartgwt.client.types.FieldType binary type fields}, an additional field,
     * <code>&lt;fieldName&gt;_filename</code>, is generated to store the filename for the binary field value. If this field is
     * present in the data source but has no value for this record, developers can assume they're working with a record with no
     * stored file. If this field is not present in some custom dataSource configuration, or the record is not loaded on the
     * client, an additional server transaction may be required to determine whether the record has an associated file before
     * calling this method to view a file. <P> See the overview of {@link com.smartgwt.client.docs.BinaryFields Binary Fields}
     * for details.
     * @param data Record to download.  Only required to have a value                                       for the primary key field.
     * @param fieldName optional name of the binary field containing the                                         file.  If not provided, the
     * first binary field                                         is used
     * @param requestProperties additional properties to set on                                                       the DSRequest that will be issued
     */
    public native void viewFile(Record data, String fieldName, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        if(!self.viewFile) { @com.smartgwt.client.util.SC::requiresServerComponents()(); }
        self.viewFile(data.@com.smartgwt.client.core.DataClass::getJsObj()(), fieldName, requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    // ********************* Static Methods ***********************
	/**
     * Converts criteria expressed in Smart GWT's simple criteria format to an AdvancedCriteria object.
     * @param criteria simple criteria
     *
     * @return equivalent AdvancedCriteria object
     */
    public static native AdvancedCriteria convertCriteria(Criteria criteria) /*-{
        var ret = $wnd.isc.DataSource.convertCriteria(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.data.AdvancedCriteria::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Converts criteria expressed in Smart GWT's simple criteria format to an AdvancedCriteria object.
     * @param criteria simple criteria
     * @param textMatchStyle default style of matching text.  Defaults to                                          "substring"
     *
     * @return equivalent AdvancedCriteria object
     */
    public static native AdvancedCriteria convertCriteria(Criteria criteria, TextMatchStyle textMatchStyle) /*-{
        var ret = $wnd.isc.DataSource.convertCriteria(criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()(), textMatchStyle == null ? null : textMatchStyle.@com.smartgwt.client.types.TextMatchStyle::getValue()());
        if(ret == null) return null;
        return @com.smartgwt.client.data.AdvancedCriteria::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Create a copy of a criteria.
     *
     * @return copy of criteria
     */
    public static native Criteria copyCriteria() /*-{
        var ret = $wnd.isc.DataSource.copyCriteria();
        if(ret == null) return null;
        return @com.smartgwt.client.data.Criteria::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Lookup a DataSource by ID.
     * @param ID DataSource ID
     *
     * @return the DataSource with this ID, if loaded, otherwise null.
     */
    public static native DataSource getDataSource(String ID) /*-{
        var ret = $wnd.isc.DataSource.getDataSource(ID);
        if(ret == null) return null;
        return @com.smartgwt.client.data.DataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
	/**
     * Return a an array of {@link com.smartgwt.client.data.SortSpecifier}s, given an array of Strings in the format expected
     * by {@link com.smartgwt.client.data.DSRequest#getSortBy sortBy}.
     * @param sortBy A list of sortBy strings in the format expected by {@link com.smartgwt.client.data.DSRequest#getSortBy sortBy}
     *
     * @return An array of {@link com.smartgwt.client.data.SortSpecifier}s equivalent to the passed in string array
     */
    public static native String[] getSortSpecifiers(String[] sortBy) /*-{
        var ret = $wnd.isc.DataSource.getSortSpecifiers(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(sortBy));
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfString(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    // ***********************************************************


    protected native void onInit() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();

        self.__jsTransformRequest = self.transformRequest;
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

        self.__jsTransformResponse = self.transformResponse;
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
        self.getClientOnlyResponse = $entry(function(dsRequest, serverData) {
            var jObj = this.__ref;
            if(jObj === undefined) {
                //handle case where oneTimeDS is cared from original DS (when clientOnly=true with dataURL)
                jObj = $wnd.isc.DS.get(this.inheritsFrom).__ref;
            }
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            var serverDataJ = serverData == null ? null : @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(serverData);
            var responseJ = jObj.@com.smartgwt.client.data.DataSource::getClientOnlyResponse(Lcom/smartgwt/client/data/DSRequest;[Lcom/smartgwt/client/data/Record;)(requestJ,serverDataJ);
            return responseJ == null ? null : responseJ.@com.smartgwt.client.data.DSResponse::getJsObj()();
        });

        self.__useOfflineResponse = self.useOfflineResponse;
        self.useOfflineResponse = $entry(function(dsRequest, dsResponse) {
            var jObj = this.__ref;
            if(jObj === undefined) {
                //handle case where oneTimeDS is cared from original DS (when clientOnly=true with dataURL)
                jObj = $wnd.isc.DS.get(this.inheritsFrom).__ref;
            }
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);

            return jObj.@com.smartgwt.client.data.DataSource::useOfflineResponse(Lcom/smartgwt/client/data/DSRequest;Lcom/smartgwt/client/data/DSResponse;)(requestJ, responseJ);
        });

    }-*/;

    // override setID() - if this.addGlobalID is false, don't register the ID with the IDManager
    // Note: this is called directly from BaseClass init method so this.scClassName may not yet have
    // been set. Catch this case and avoid calling 'getAddGlobalID' as that ultimately relies on this
    // property being set correctly
    public void setID(String id) {
        // Default behavior at the SmartClient level is to add global IDs
        if (scClassName == null || this.getAddGlobalId()) {
            if (this.id != null) {
                IDManager.unregisterID(this.id);
            }

            IDManager.registerID(id);
        }

        reregisterSgwtDS(this.id, id);

        setAttribute("_autoAssignedID", false, false);
        setAttribute("ID", id, false);
        this.id = id;
    }

    /**
     * Registers a command object with SC so that from JS an SGWT DataSource can object be used to create the underlying SC DataSource.
     * @param id the datasource ID
     */
    private native void registerSgwtDS(String id)/*-{
        var self = this;
        $wnd.isc.DataSource.registerSgwtDS(id, function() {
            self.@com.smartgwt.client.data.DataSource::createAndUnregisterSgwtDS(Ljava/lang/String;)(id);
        });
    }-*/;

    /**
     * Creates the underlying SC datasource object if required and unregisters the command object from the SC datasource map.
     * @param id the datasource ID
     */
    private native void createAndUnregisterSgwtDS(String id)/*-{
        this.@com.smartgwt.client.data.DataSource::getOrCreateJsObj()();
        $wnd.isc.DataSource.unregisterSgwtDS(id);
    }-*/;

    /**
     * Re-registers a previously registered command object with SC.  This is required when user code calls setID()
     * to give a DataSource a different identifier
     * @param id the datasource ID
     */
    private native void reregisterSgwtDS(String oldId, String newId)/*-{
        $wnd.isc.DataSource.reregisterSgwtDS(oldId, newId);
    }-*/;

    /**
     * Whether to make this DataSource available as a global variable for convenience.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param addGlobalId addGlobalId Default value is true
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setAddGlobalId(Boolean addGlobalId)  throws IllegalStateException {
        setAttribute("addGlobalId", addGlobalId, false);
        if (addGlobalId) {
            IDManager.registerID(id);
        } else {
            IDManager.unregisterID(id);
        }
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
     * Synonym of {@link com.smartgwt.client.data.DataSource#getDataSource DataSource.getDataSource}: Lookup a DataSource by
     * ID.
     * @param ID DataSource ID
     *
     * @return the DataSource with this ID, if loaded, otherwise null.
     */
    public static DataSource get(String ID) {
        return getDataSource(ID);
    }

 /**
     * Synonym of {@link com.smartgwt.client.data.DataSource#getDataSource DataSource.getDataSource}: Lookup a DataSource by
     * ID.
     * @param ID DataSource ID
     * @param requestTransformer the request transformer. Pass null to use the default transform
     * @param responseTransformer the response transformer. Pass null to use the default transform
  *
     * @return the DataSource with this ID, if loaded, otherwise null.
     */
    public static DataSource get(String ID, RequestTransformer requestTransformer, ResponseTransformer responseTransformer) {
        return getDataSource(ID, requestTransformer, responseTransformer);
    }

    /**
     * Lookup a DataSource by ID with an optional RequestTransformer and ResponseTransformer. The RequestTransformer and ResponseTransformer parameters
     * provide the equivalent functionality of overriding {@link #transformRequest(DSRequest)} and {@link #transformResponse(DSResponse, DSRequest, Object)} when
     * instantiating a DataSource on the client. However when obtaining a DataSource instance from the server using this API, {@link #transformRequest(DSRequest)} and {@link #transformResponse(DSResponse, DSRequest, Object)}
     * cannot be overridden and so the requestTransformer and responseTransformer parameters can be passed instead.
     *
     * @param ID DataSource ID
     * @param requestTransformer the request transformer. Pass null to use the default transform
     * @param responseTransformer the response transformer. Pass null to use the default transform
     *
     * @return the DataSource with this ID, if loaded, otherwise null.
     */
    public static native DataSource getDataSource(String ID, RequestTransformer requestTransformer, ResponseTransformer responseTransformer) /*-{
        var ret = $wnd.isc.DataSource.getDataSource(ID);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.core.BaseClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        if(requestTransformer != null) {
            if (ret.__transformRequest == null) ret.__transformRequest = ret.transformRequest;
            requestTransformer.@com.smartgwt.client.data.RequestTransformer::dsJsObj = ret;
            ret.transformRequest = $entry(function(dsRequest) {
                var dsRequestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
                var data = requestTransformer.@com.smartgwt.client.data.RequestTransformer::transformRequest(Lcom/smartgwt/client/data/DSRequest;)(dsRequestJ);
                if(@com.smartgwt.client.data.DataSource::isRecord(Ljava/lang/Object;)(data)) {
                    data = data.@com.smartgwt.client.data.Record::getJsObj()();
                } else if (@com.smartgwt.client.data.DataSource::isRecordArray(Ljava/lang/Object;)(data)) {
                    data = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(data);
                }
                return data;
            });
        }

        if(responseTransformer != null) {
            if (ret.__transformResponse == null) ret.__transformResponse = ret.transformResponse;
            responseTransformer.@com.smartgwt.client.data.ResponseTransformer::dsJsObj = ret;
            ret.transformResponse = $entry(function(dsResponse, dsRequest, data) {
                var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
                var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
                responseTransformer.@com.smartgwt.client.data.ResponseTransformer::transformResponse(Lcom/smartgwt/client/data/DSResponse;Lcom/smartgwt/client/data/DSRequest;Ljava/lang/Object;)(responseJ, requestJ, data);
            });
        }
        return retVal;
    }-*/;

    /**
     * Override point to allow application code to suppress use of a particular offline response.  For example, application
     * code may wish to examine the response's  {@link DSResponse#getOfflineTimestamp
     * offlineTimestamp} to make a decision about whether the response is too stale to be useful. <p> This is an application
     * override point only; there is no default implementation.
     * <p>
     * <b>Note</b>: This is an override point
     *
     * @param dsRequest The dsRequest object
     * @param dsResponse The corresponding dsResponse object returned from                                 offline cache
     *
     * @return true to allow this response to be used, false to prevent it
     */
    protected native boolean useOfflineResponse(DSRequest dsRequest, DSResponse dsResponse) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =  self.__useOfflineResponse(dsRequest.@com.smartgwt.client.core.DataClass::getJsObj()(), dsResponse.@com.smartgwt.client.core.DataClass::getJsObj()());
        return retVal == null || retVal === undefined ? false : retVal;
    }-*/;

    public native boolean isCreated()/*-{
        var id = this.@com.smartgwt.client.core.BaseClass::getID()();
        var exists = $wnd.isc.DataSource.isLoaded(id);
        return id != null && exists;
    }-*/;

    public native JavaScriptObject getJsObj()/*-{
        var id = this.@com.smartgwt.client.core.BaseClass::getID()();
        var exists = $wnd.isc.DataSource.isLoaded(id);
        if (!exists) return null;
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
        return @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
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
        return @com.smartgwt.client.util.ConvertTo::arrayOfString(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
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
     * Variation of {@link com.smartgwt.client.data.DataSource#load DataSource.load} that will also automatically load any
     * DataSources that the requested DataSources inherit from
     * (via {@link com.smartgwt.client.data.DataSource#inheritsFrom DataSource.inheritsFrom))
     * <p>
     * If the parent DataSource is already loaded, calling loadWithParents will not automatically reload them unless the
     * forceReload parameter is passed.
     * @param dsID DataSource ID
     * @param callback Callback to fire after DataSource loading completes
     * @param forceReload Forcibly reload a dataSource if it's already loaded
     */
    public static native void loadWithParents(String dsID, Function callback, boolean forceReload) /*-{
        $wnd.isc.DataSource.loadWithParents(dsID,
                $entry(function() {
                    if(callback != null) callback.@com.smartgwt.client.core.Function::execute()();
                }),
                forceReload);
    }-*/;

    /**
     * Variation of {@link com.smartgwt.client.data.DataSource#load DataSource.load} that will also automatically load any
     * DataSources that the requested DataSources inherit from
     * (via {@link com.smartgwt.client.data.DataSource#inheritsFrom DataSource.inheritsFrom))
     * <p>
     * If the parent DataSource is already loaded, calling loadWithParents will not automatically reload them unless the
     * forceReload parameter is passed.
     * @param dsID DataSource ID
     * @param callback Callback to fire after DataSource loading completes
     * @param forceReload Forcibly reload a dataSource if it's already loaded
     */
    public static native void loadWithParents(String[] dsID, Function callback, boolean forceReload) /*-{
        $wnd.isc.DataSource.loadWithParents(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(dsID),
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
     * Exports arbitrary client-side data, with client-side formatters applied, so is suitable  for direct display to users.
     * This method can be used to export data formatted outside of any kind of visual component. <P> If you do not specify an
     * {@link com.smartgwt.client.data.DSRequest#setOperationId operationId} in the <code>requestProperties</code> you pass to this method, it behaves
     * exactly the same as the {@link com.smartgwt.client.data.DataSource#exportClientDataStatic exportClientDataStatic} static classMethod.
     * If you do specify an <code>operationId</code>, the framework expects your DataSource to configure an {@link com.smartgwt.client.data.OperationBinding}
     * of {@link com.smartgwt.client.data.OperationBinding#getOperationType operationType} <code>DSOperationType.CLIENTEXPORT</code>, with the same
     * <code>operationId</code>.  The framework will then send the <code>exportClientData</code> request via the ordinary
     * {@link com.smartgwt.client.data.DSRequest} mechanism, which allows you to use normal framework features in the client data export.  For example,
     * you could add a {@link com.smartgwt.client.docs.DmiOverview DMI declaration} to your <code>operationBinding</code>, which would allow you to write
     * server-side code that intervenes in the export process - for instance, by calling the <code>getExportObject()</code> API to
     * do something special with the export document, like saving it to a database table or sending it to an email list.
     * <p>
     * When you use the specific <code>operationId</code> version of this API, both the SmartClient Server and server-side DataSources are required.
     * <p>
     * To export unformatted data, see {@link com.smartgwt.client.data.DataSource#exportData} which does not include client-side formatters, but requires both the
     * Smart GWT server and the  presence of server-side DataSources.
     * @param data Records to export, similar to ListGrid.data
     * @param requestProperties Request properties for the export
     */
    public native void exportClientData(Object[] data, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.exportClientData(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(data), requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Exports arbitrary client-side data, with client-side formatters applied, so is suitable for direct display to users.  This
     * method can be used to export data formatted outside of any kind of visual component.<P>Requires the SmartClient server, but
     * does not rely on any server-side DataSources.  If you need to intervene in the export process server-side - for example, if
     * you need to do something not directly supported with the exported object, such as attach it to an email - use the
     * {@link com.smartgwt.client.data.DataSource#exportClientData exportClientData} instance method with an appropriate
     * {@link com.smartgwt.client.data.OperationBinding}, as described in the method documentation.<P>To export unformatted data,
     * see {@link com.smartgwt.client.data.DataSource#exportData}, which does not include client-side formatters, but requires both
     * the SmartClient server and the presence of server-side DataSources.<P>Note that field
     * {@link com.smartgwt.client.data.DataSourceField#setDisplayFormat displayFormat} is honored for "date" and "datetime" fields when exporting
     * direct to Excel; see the displayFormat docs for details.<P>
     * NOTE: The "Static" in this method name merely indicates that it is the static version of this method, as opposed to the
     * similar instance method {@link com.smartgwt.client.data.DataSource#exportClientData exportClientData}.  Restrictions of the Java language
     * itself prevent us from giving the instance method and the static method the same name.
     */
    public static native void exportClientDataStatic(Object[] data, DSRequest requestProperties) /*-{
        $wnd.isc.DataSource.exportClientData(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(data), requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Returns a direct URL to access a file stored in a field of type:"binary". <P> This URL as be used as the "src" attribute
     * of an Img widget or &lt;img&gt; tag (if the file is an image), or can be used in an ordinary HTML link (&lt;a&gt; tag)
     * to download the file. However, for the latter use case, see also {@link com.smartgwt.client.data.DataSource#downloadFile
     * DataSource.downloadFile} and {@link com.smartgwt.client.data.DataSource#viewFile DataSource.viewFile}. <P> The URL
     * returned is not to a static file on disk, rather, the returned URL essentially encodes a DSRequest as URL parameters, in
     * a format understood by the IDACall servlet that comes with the Server Framework.   <P> Hence, this URL will dynamically
     * retrieve whatever file is currently stored in the binary field via executing a normal DSRequest server side.  The
     * request will run through normal security checks, so if your application requires authentication, the user must have a
     * valid session and be authorized to access the binary field. <P> Similarly, accessing this URL has the same performance
     * as using {@link com.smartgwt.client.data.DataSource#downloadFile DataSource.downloadFile}.
     * @param data Record or value of primary key field for record containing the file to view.
     * @return a URL to directly access the stored file
     */
    public native String getFileURL(Record data) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = data.@com.smartgwt.client.data.Record::getJsObj()();
        return self.getFileURL(recordJS);
    }-*/;

    /**
     * Returns a direct URL to access a file stored in a field of type:"binary". <P> This URL as be used as the "src" attribute
     * of an Img widget or &lt;img&gt; tag (if the file is an image), or can be used in an ordinary HTML link (&lt;a&gt; tag)
     * to download the file. However, for the latter use case, see also {@link com.smartgwt.client.data.DataSource#downloadFile
     * DataSource.downloadFile} and {@link com.smartgwt.client.data.DataSource#viewFile DataSource.viewFile}. <P> The URL
     * returned is not to a static file on disk, rather, the returned URL essentially encodes a DSRequest as URL parameters, in
     * a format understood by the IDACall servlet that comes with the Server Framework.   <P> Hence, this URL will dynamically
     * retrieve whatever file is currently stored in the binary field via executing a normal DSRequest server side.  The
     * request will run through normal security checks, so if your application requires authentication, the user must have a
     * valid session and be authorized to access the binary field. <P> Similarly, accessing this URL has the same performance
     * as using {@link com.smartgwt.client.data.DataSource#downloadFile DataSource.downloadFile}.
     * @param data Record or value of primary key field for record containing the file to view.
     * @param fieldName optional name of the binary field containing the file.  If not provided, the first binary field is used
     * @return a URL to directly access the stored file
     */
    public native String getFileURL(Record data, String fieldName) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = data.@com.smartgwt.client.data.Record::getJsObj()();
        return self.getFileURL(data, fieldName);
    }-*/;

    /**
     * Returns a direct URL to access a file stored in a field of type:"binary". <P> This URL as be used as the "src" attribute
     * of an Img widget or &lt;img&gt; tag (if the file is an image), or can be used in an ordinary HTML link (&lt;a&gt; tag)
     * to download the file. However, for the latter use case, see also {@link com.smartgwt.client.data.DataSource#downloadFile
     * DataSource.downloadFile} and {@link com.smartgwt.client.data.DataSource#viewFile DataSource.viewFile}. <P> The URL
     * returned is not to a static file on disk, rather, the returned URL essentially encodes a DSRequest as URL parameters, in
     * a format understood by the IDACall servlet that comes with the Server Framework.   <P> Hence, this URL will dynamically
     * retrieve whatever file is currently stored in the binary field via executing a normal DSRequest server side.  The
     * request will run through normal security checks, so if your application requires authentication, the user must have a
     * valid session and be authorized to access the binary field. <P> Similarly, accessing this URL has the same performance
     * as using {@link com.smartgwt.client.data.DataSource#downloadFile DataSource.downloadFile}.
     * @param data Record or value of primary key field for record containing the file to view.
     * @param fieldName optional name of the binary field containing the file.  If not provided, the first binary field is used
     * @param requestProperties additional properties to set on the DSRequest that will be issued
     * @return a URL to directly access the stored file
     */
    public native String getFileURL(Record data, String fieldName, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = data.@com.smartgwt.client.data.Record::getJsObj()();
        return self.getFileURL(data, fieldName, requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
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

    /**
     * Set the list of {@link com.smartgwt.client.types.OperatorId OperatorIds} valid for a given FieldType.
     *
     * @param fieldType the field type
     * @param operators available Operators
     */
    public native void setTypeOperators(FieldType fieldType, OperatorId[] operators)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var fieldTypeJS = fieldType == null ? null : fieldType.@com.smartgwt.client.types.ValueEnum::getValue()();
        var operatorsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(operators);
        self.setTypeOperators(fieldTypeJS, operatorsJS);
    }-*/;

    /**
     * Get the list of OperatorIds available on this DataSource for the given FieldType.
     * <p>
     * If DataSource.setTypeOperators() has been called for this DataSource and Fieldtype, returns that list, otherwise, returns the set of
     * valid operators for the FieldType as specified by SimpleType.validOperators, otherwise, the system-wide set of valid operators for the
     * type as registered via DataSource.addSearchOperator().
     *
     * @param fieldType the field type
     * @return the available Operators
     */
    public native OperatorId[] getTypeOperators(FieldType fieldType)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var fieldTypeJS = fieldType == null ? null : fieldType.@com.smartgwt.client.types.ValueEnum::getValue()();
        var operatorsJS = self.getTypeOperators(fieldTypeJS);
        return @com.smartgwt.client.util.ConvertTo::arrayOfOperatorId(Lcom/google/gwt/core/client/JavaScriptObject;)(operatorsJS);
    }-*/;

    /**
     * Get the list of OperatorId's available for this field. By default if the validOperators is set on the DataSourceField, it returns the list, otherwise returns
     * the result of {@link #getTypeOperators(com.smartgwt.client.types.FieldType)}.
     *
     * @param fieldName the field name to obtain operators for
     * @return the available Operators
     */
    public native OperatorId[] getFieldOperators(String fieldName)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var operatorsJS = self.getFieldOperators(fieldName);
        return @com.smartgwt.client.util.ConvertTo::arrayOfOperatorId(Lcom/google/gwt/core/client/JavaScriptObject;)(operatorsJS);
    }-*/;

    /**
     * Get the list of OperatorId's available for this field. By default if the validOperators is set on the DataSourceField, it returns the list, otherwise returns
     * the result of {@link #getTypeOperators(com.smartgwt.client.types.FieldType)}.
     *
     * @param field the field to obtain operators for
     * @return the available Operators
     */
    public native OperatorId[] getFieldOperators(DataSourceField field)/*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var fieldName = field.@com.smartgwt.client.data.DataSourceField::getName()();
        var operatorsJS = self.getFieldOperators(fieldName);
        return @com.smartgwt.client.util.ConvertTo::arrayOfOperatorId(Lcom/google/gwt/core/client/JavaScriptObject;)(operatorsJS);
    }-*/;

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
        var jsC1 = criteria1 == null ? null : criteria1.@com.smartgwt.client.core.DataClass::getJsObj()();
        var jsC2 = criteria2 == null ? null : criteria2.@com.smartgwt.client.core.DataClass::getJsObj()();

        if (jsC1 != null) jsC1 = $wnd.isc.addProperties({_constructor:"AdvancedCriteria"},jsC1);
        if (jsC2 != null) jsC2 = $wnd.isc.addProperties({_constructor:"AdvancedCriteria"},jsC2);

        var ret = $wnd.isc.DataSource.combineCriteria(jsC1,jsC2);
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
     *
     * @return The combined criteria
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#sql_dynamic_reporting" target="examples">Dynamic Reporting Example</a>
     */
    public static native Criteria combineCriteria(Criteria criteria1, Criteria criteria2, CriteriaCombineOperator outerOperator) /*-{

        var jsC1 = criteria1 == null ? null : criteria1.@com.smartgwt.client.core.DataClass::getJsObj()();
        var jsC2 = criteria2 == null ? null : criteria2.@com.smartgwt.client.core.DataClass::getJsObj()();

        if (jsC1 != null) jsC1 = $wnd.isc.addProperties({_constructor:"AdvancedCriteria"},jsC1);
        if (jsC2 != null) jsC2 = $wnd.isc.addProperties({_constructor:"AdvancedCriteria"},jsC2);

        var ret = $wnd.isc.DataSource.combineCriteria(jsC1, jsC2, outerOperator.@com.smartgwt.client.types.CriteriaCombineOperator::getValue()());
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

        var jsC1 = criteria1 == null ? null : criteria1.@com.smartgwt.client.core.DataClass::getJsObj()();
        var jsC2 = criteria2 == null ? null : criteria2.@com.smartgwt.client.core.DataClass::getJsObj()();

        if (jsC1 != null) jsC1 = $wnd.isc.addProperties({_constructor:"AdvancedCriteria"},jsC1);
        if (jsC2 != null) jsC2 = $wnd.isc.addProperties({_constructor:"AdvancedCriteria"},jsC2);

        var ret = $wnd.isc.DataSource.combineCriteria(jsC1, jsC2, outerOperator.@com.smartgwt.client.types.CriteriaCombineOperator::getValue()(), textMatchStyle.@com.smartgwt.client.types.TextMatchStyle::getValue()());
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Returns records in the passed Record that match the provided filter {@link com.smartgwt.client.data.Criteria}.
     * <P>
     * By default:
     * <ul>
     * <li> any criteria that do not correspond to a DataSource field are ignored
     * <li> any null or empty string criteria are ignored
     * </ul>
     *
     * @param   records     		(Record[])  the list of rows
     * @param   criteria    		(Criteria)  the filter criteria
     * @param   requestProperties  	(DSRequest Properties)  optional dataSource request properties
     * @return  Record[]     		the list of matching rows
	 */
    public native Record[] applyFilter(Record[] records, Criteria criteria, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var jsCriteria = criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
        var jsRecords = records == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        var jsRequestProperties = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        var recordsFiltered = self.applyFilter(jsRecords,jsCriteria,jsRequestProperties);
        return @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsFiltered);
    }-*/;

    /**
     * Returns records in the passed Record that match the provided filter {@link com.smartgwt.client.data.Criteria}.
     * <P>
     * By default:
     * <ul>
     * <li> any criteria that do not correspond to a DataSource field are ignored
     * <li> any null or empty string criteria are ignored
     * </ul>
     *
     * @param   records     		(Record[])  the list of rows
     * @param   criteria    		(Criteria)  the filter criteria
     * @return  Record[]     		the list of matching rows
	 */
    public native Record[] applyFilter(Record[] records, Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var jsCriteria = criteria == null ? null : criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
        var jsRecords = records == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        var recordsFiltered = self.applyFilter(jsRecords,jsCriteria,null);
        return @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsFiltered);
    }-*/;

    /**
     * Converts a list of Records to simple text formats with a Record per line and values separated by a configurable
     * separator, including both tab-separated-values and comma-separated-values (aka CSV).
     * <P>
     * In addition to the <code>settings</code> parameter for this method,
     * {@link com.smartgwt.client.data.DataSourceField#exportForceText DataSourceField.exportForceText} can be set.
     * <P>
     * If two or more different text exports are needed for the same DataSource creating a conflict for any
     * DataSourceField setting, {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom} can be used
     * to create a child DataSource where these settings can be changed without recapitulating all field definitions.
     * @param records records to convert
     *
     * @return records as CSV/TSV (separator can be specified)
     */
    public native String recordsAsText(Record[] records) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = records == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        return self.recordsAsText(recordsJS);
    }-*/;

    /**
     * Converts a list of Records to simple text formats with a Record per line and values separated by a configurable
     * separator, including both tab-separated-values and comma-separated-values (aka CSV).
     * <P>
     * In addition to the <code>settings</code> parameter for this method,
     * {@link com.smartgwt.client.data.DataSourceField#exportForceText DataSourceField.exportForceText} can be set.
     * <P>
     * If two or more different text exports are needed for the same DataSource creating a conflict for any
     * DataSourceField setting, {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}
     * can be used to create a child DataSource where these settings can be changed without recapitulating
     * all field definitions.
     * @param records records to convert
     * @param settings settings for the export
     *
     * @return records as CSV/TSV (separator can be specified)
     */
    public native String recordsAsText(Record[] records, TextExportSettings settings) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = records == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        var settingsJS = settings.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.recordsAsText(recordsJS, settingsJS);
    }-*/;

   /**
     * Derive a set of Records from Microsoft Excel-compatible tab-separated-values format, using the current DataSource field
     * order, or an explicitly specified list of fields.
     * <P>
     * If a specified field does not exist in the DataSource, it's
     * assumed the values for that field should end up as Strings.
     * @param text records as CSV/TSV (separator can be specified)
     *
     * @return records derived from TSV
     */
    public native Record[] recordsFromText(String text) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
		var records = self.recordsFromText(text);
        if (records == null || records === undefined) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
    }-*/;

    /**
     * Derive a set of Records from Microsoft Excel-compatible tab-separated-values format, using the current DataSource field
     * order, or an explicitly specified list of fields.
     * <P>
     * If a specified field does not exist in the DataSource, it's
     * assumed the values for that field should end up as Strings.
     * @param text records as CSV/TSV (separator can be specified)
     * @param settings optional settings for the 
     *
     * @return records derived from TSV
     */
    public native Record[] recordsFromText(String text, TextImportSettings settings) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var settingsJS = settings.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
		var records = self.recordsFromText(text, settingsJS);
        if (records == null || records === undefined) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfRecord(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
    }-*/;
    
    /**
     * For a {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} or client-only DataSource, a set of
     * records to use as a dataset,  specified as an Array of JavaScript Objects representing records.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Call this method to set the data in the client-side cache after initialization.
     *
     * @param cacheData Array of records to apply as the client-side cache. Default value is null
     */
    public void setCacheData(Record... cacheData) {
    	if (cacheData != null && cacheData.length > 0) {
			Record r1 = cacheData[0];
			if (!(r1 instanceof ListGridRecord)) {
				SC.logWarn("setCacheData(): DataSource cache data is expected to be an array of ListGridRecords." +
						" This allows the data to be displayed as expected in ListGrids bound to this dataSource.");
			}
		}
    	setAttribute("cacheData", cacheData, true);
    }
    
    /**
     * For a {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} or client-only DataSource, a set of
     * records to use as a dataset,  specified as an Array of JavaScript Objects representing records.
     *
     *
     * @return Returns the complete set of data cached by this dataSource. Note that this may  have been supplied via {@link
     * com.smartgwt.client.data.DataSource#getCacheData cacheData}, or may have been fetched from the server for dataSources
     * with {@link com.smartgwt.client.data.DataSource#getCacheAllData cacheAllData} set to true.
     */
    public Record[] getCacheData()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfRecord(getAttributeAsJavaScriptObject("cacheData"));
    }
    
    /**
     * For a client-only DataSource, a set of records to use as a dataset, specified as an Array of JavaScript Objects. 
     * Deprecated in favor of {@link com.smartgwt.client.data.DataSource#getCacheData cacheData}. <P> See {@link
     * com.smartgwt.client.docs.ClientOnlyDataSources this discussion} for ways to populate a client-only DataSource with test
     * data.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Call this method to set the data in the client-side test-data after initialization.  {@link com.smartgwt.client.data.DataSource#setCacheData setCacheData()} should be called instead and setTestData() is deprecated and will eventually be removed.
     *
     * @param testData Array of records to apply as the client-side test-data. Default value is null
     */
    public void setTestData(Record... cacheData) {
     	if (cacheData != null && cacheData.length > 0) {
 			Record r1 = cacheData[0];
 			if (!(r1 instanceof ListGridRecord)) {
 				SC.logWarn("setTestData(): DataSource cache data is expected to be an array of ListGridRecords." +
 						" This allows the data to be displayed as expected in ListGrids bound to this dataSource.");
 			}
 		}
     	setAttribute("testData", cacheData, true);
     }
    

    /**
     * For a client-only DataSource, a set of records to use as a dataset, specified as an Array of JavaScript Objects. 
     * Deprecated in favor of {@link com.smartgwt.client.data.DataSource#getCacheData cacheData}. <P> See {@link
     * com.smartgwt.client.docs.ClientOnlyDataSources this discussion} for ways to populate a client-only DataSource with test
     * data.
     *
     *
     * @return Record
     */
    public Record[] getTestData()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfRecord(getAttributeAsJavaScriptObject("testData"));
    }

    /**
     * Return a reasonable user-visible title given a fieldName.  Called when {@link
     * com.smartgwt.client.data.DataSource#getAutoDeriveTitles autoDeriveTitles} is true and by default, calls the class method
     * {@link com.smartgwt.client.data.DataSource#getAutoTitle DataSource.getAutoTitle}.  Override to provide a different
     * policy for auto-deriving titles for a particular DataSource or subclass of DataSource.
     * @param identifier identifier for which a title is desired.
     *
     * @return auto-derived title
     */
    public native String getFieldAutoTitle(String identifier) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getAutoTitle(identifier);
        return ret;
    }-*/;

    /**
     * Utility method to derive a reasonable user-visible title from an identifier. <P> The following approach is taken: <ul>
     * <li> any underscores (_) or dollar signs ($) become spaces, except that there will never      be either a leading or
     * trailing space. <li> if the fieldName is either entirely uppercase or lowercase, all words separated by      spaces are
     * given a leading capital letter.  Example USER_NAME or user_name -> "User      Name". <li> if there is any use of mixed
     * case, camelCaps convention is assumed, and the field name      is split into separate words based on 1) everywhere an
     * uppercase letter appears after a      lowercase letter 2) everywhere a series of uppercase letters ends.  Letter case
     * will      not be modified, with the exception that the first word will have its first letter       capitalized.
     * Example: useHTTPProxy -> "Use HTTP Proxy" </ul>
     * @param identifier identifier for which a title is desired.
     *
     * @return auto-derived title
     */
    public static native String getAutoTitle(String identifier) /*-{
        var ret = $wnd.isc.DataSource.getAutoTitle(identifier);
        return ret;
    }-*/;
    
	/**
     * Given a field definition and a record object, this method will return the field value for the record. <P> This method
     * will follow any {@link com.smartgwt.client.widgets.grid.ListGridField#getDataPath dataPath} specified on the  component
     * field if necessary, and will extract  {@link com.smartgwt.client.data.SimpleType#getAtomicValue atomic values} from
     * custom {@link com.smartgwt.client.data.SimpleType} fields where this is required.
     * @param field Field definition from a dataSource or dataBoundComponent.
     * @param record data object
     *
     * @return extracted field value
     */
    public static Object getFieldValue(DataSourceField field, Record record) {
    	return getFieldValue((DataClass)field, record);
    }

	/**
     * Given a field definition and a record object, this method will return the field value for the record. <P> This method
     * will follow any {@link com.smartgwt.client.widgets.grid.ListGridField#getDataPath dataPath} specified on the  component
     * field if necessary, and will extract  {@link com.smartgwt.client.data.SimpleType#getAtomicValue atomic values} from
     * custom {@link com.smartgwt.client.data.SimpleType} fields where this is required.
     * @param field Field definition from a dataSource or dataBoundComponent.
     * @param record data object
     *
     * @return extracted field value
     */
    public static Object getFieldValue(ListGridField field, Record record) {
    	return getFieldValue((DataClass)field, record);
    }

	/**
     * Given a field definition and a record object, this method will return the field value for the record. <P> This method
     * will follow any {@link com.smartgwt.client.widgets.grid.ListGridField#getDataPath dataPath} specified on the  component
     * field if necessary, and will extract  {@link com.smartgwt.client.data.SimpleType#getAtomicValue atomic values} from
     * custom {@link com.smartgwt.client.data.SimpleType} fields where this is required.
     * @param field Field definition from a dataSource or dataBoundComponent.
     * @param record data object
     *
     * @return extracted field value
     */
    public static Object getFieldValue(DetailViewerField field, Record record) {
    	return getFieldValue((DataClass)field, record);
    }

	/**
     * Given a field definition and a record object, this method will return the field value for the record. <P> This method
     * will follow any {@link com.smartgwt.client.widgets.grid.ListGridField#getDataPath dataPath} specified on the  component
     * field if necessary, and will extract  {@link com.smartgwt.client.data.SimpleType#getAtomicValue atomic values} from
     * custom {@link com.smartgwt.client.data.SimpleType} fields where this is required.
     * @param field Field definition from a dataSource or dataBoundComponent.
     * @param record data object
     *
     * @return extracted field value
     */
    public static Object getFieldValue(FormItem field, Record record) {
    	return getFieldValue((DataClass)field, record);
    }


    private static native Object getFieldValue(DataClass field, Record record) /*-{
	    var ret = $wnd.isc.DataSource.getFieldValue(field.@com.smartgwt.client.core.DataClass::getJsObj()(), record.@com.smartgwt.client.core.DataClass::getJsObj()());
	    return $wnd.SmartGWT.convertToJavaType(ret);
	}-*/;

}




