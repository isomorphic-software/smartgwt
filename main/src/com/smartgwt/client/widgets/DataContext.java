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
 
package com.smartgwt.client.widgets;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.smartgwt.client.util.tour.*;


/**
 * A mapping from {@link com.smartgwt.client.data.DataSource} IDs to specific {@link com.smartgwt.client.data.Record
 * Records}.
 *  <p>
 *  To understand how <code>dataContext</code> is used to automatically populate
 * {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}, see {@link
 * com.smartgwt.client.widgets.Canvas#getAutoPopulateData Canvas.autoPopulateData}.
 *  
 *  
 *  <P>
 *  For example, in SmartGWT:
 *  <pre>
 *    Record customerRecord = new Record();
 *    customerRecord.setAttribute("customerNumber", "15");
 *    customerRecord.setAttribute("name", "Trish Joiner");
 * 
 *    Record employeeRecord = new Record();
 *    employeeRecord.setAttribute("employeeID", "4231");
 *    employeeRecord.setAttribute("name", "Fred Smith");
 * 
 *    DataContext dataContext = new DataContext();
 *    dataContext.addMapping("Customer", customerRecord);
 *    dataContext.addMapping("Employee", employeeRecord);
 *  </pre>
 * 
 */
@BeanFactory.FrameworkClass
public class DataContext extends DataClass {

    public static DataContext getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DataContext(jsObj);
    }
        


    public DataContext(){
        
    }

    public DataContext(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    /**
     * Binds the DataSource to the supplied record.
     * @param dataSource
     * @param record
     * @return {@link com.smartgwt.client.widgets.DataContext DataContext} instance, for
     * chaining setter calls
     */
    public DataContext setDataSourceRecord(DataSource dataSource, Record record) {
        return setDataSourceRecord(dataSource.getID(), record);
    }

    /**
     * Binds the DataSource to the supplied record.
     * @param dataSourceID
     * @param record
     * @return {@link com.smartgwt.client.widgets.DataContext DataContext} instance, for
     * chaining setter calls
     */
    public DataContext setDataSourceRecord(String dataSourceID, Record record) {
        return (DataContext) setAttribute(dataSourceID, record);
    }

    /**
     * Binds the DataSource to the supplied records, as an array.
     * @param dataSource
     * @param record
     * @return {@link com.smartgwt.client.widgets.DataContext DataContext} instance, for
     * chaining setter calls
     */
    public DataContext setDataSourceRecords(DataSource dataSource, Record... record) {
        return setDataSourceRecords(dataSource.getID(), record);
    }

    /**
     * Binds the DataSource to the supplied records, as an array.
     * @param dataSource
     * @param record
     * @return {@link com.smartgwt.client.widgets.DataContext DataContext} instance, for
     * chaining setter calls
     */
    public DataContext setDataSourceRecords(String dataSourceID, Record... record) {
        removeDataSourceRecords(dataSourceID);
        for (int i = 0; i < record.length; i++) {
            addDataSourceRecord(dataSourceID, record[i]);
        }
        return this;
    }

    public DataContext addDataSourceRecord(String dataSourceID, Record record) {
        if (record == null) return this;

        JavaScriptObject recordsJS = getAttributeAsJavaScriptObject(dataSourceID);
        if (recordsJS == null) {
            recordsJS = JSOHelper.createJavaScriptArray();
            setAttribute(dataSourceID, recordsJS);
        }
        int length = JSOHelper.getArrayLength(recordsJS);
        JSOHelper.setArrayValue(recordsJS, length, record.getJsObj());

        return this;
    }

    private static native boolean bindingIsArray(JavaScriptObject bindingJS) /*-{
        return $wnd.isc.isAn.Array(bindingJS);
    }-*/;

    /**
     * Returns record(s) bound to the DataSource as Record or Record[].
     * @param dataSource
     * @return bound record(s), or null
     */
    public Object getDataSourceRecords(DataSource dataSource) {
        return getDataSourceRecords(dataSource.getID());
    }

    /**
     * Returns record(s) bound to the DataSource as Record or Record[].
     * @param dataSourceID
     * @return bound record(s), or null
     */
    public Object getDataSourceRecords(String dataSourceID) {
        JavaScriptObject recordsJS = getAttributeAsJavaScriptObject(dataSourceID);
        if (bindingIsArray(recordsJS)) return ConvertTo.arrayOfRecord(recordsJS);
        return recordsJS != null ? Record.getOrCreateRef(recordsJS) : null;
    }

    /**
     * Returns record bound to the DataSource.  If an array of records is bound to the
     * DataSource, returns the first one.
     * @param dataSource
     * @return bound record, or null
     */
    public Record getDataSourceRecord(DataSource dataSource) {
        return getDataSourceRecord(dataSource.getID());
    }

    /**
     * Returns record bound to the DataSource.  If an array of records is bound to the
     * DataSource, returns the first one.
     * @param dataSourceID
     * @return bound record, or null
     */
    public Record getDataSourceRecord(String dataSourceID) {
        JavaScriptObject recordsJS = getAttributeAsJavaScriptObject(dataSourceID);        
        if (bindingIsArray(recordsJS)) recordsJS = JSOHelper.getJSOArrayValue(recordsJS, 0);
        return recordsJS != null ? Record.getOrCreateRef(recordsJS) : null;
    }

    /**
     * Removes any record binding(s) for the DataSource.
     * @param dataSource
     * @return bound record(s), or null
     */
    public Object removeDataSourceRecords(DataSource dataSource) {
        return removeDataSourceRecords(dataSource.getID());
    }

    /**
     * Removes any record binding(s) for the DataSource.
     * @param dataSourceID
     * @return bound record(s), or null
     */
    public Object removeDataSourceRecords(String dataSourceID) {
        Object result = getDataSourceRecords(dataSourceID);
        JSOHelper.deleteAttribute(jsObj, dataSourceID);
        return result;
    }

    /**
     * Binds the id to the supplied POJO.
     * <p>
     * Passing POJOs to a child window via this API is "super experimental" (beyond the feature
     * itself, which is experimental).  To support this, you must declare the "typeSync" linker
     * in your GWT project:
     * <pre>
     *     &lt;add-linker name="typeSync"/&gt; 
     * </pre>
     * @param id identifier for POJO
     * @param sharedobject POJO to bind
     * @return {@link com.smartgwt.client.widgets.DataContext DataContext} instance, for
     */
    public DataContext setSharedJavaObject(String id, Object sharedObject) {
        return (DataContext) setAttributeAsJavaObject("_" + id, sharedObject);
    }

    /**
     * Returns the POJO bound to this id.
     * <p>
     * Passing POJOs to a child window via this API is "super experimental" (beyond the feature
     * itself, which is experimental).  To support this, you must declare the "typeSync" linker
     * in your GWT project:
     * <pre>
     *     &lt;add-linker name="typeSync"/&gt; 
     * </pre>
     * @param id identifier for POJO
     * @return bound POJO, or null
     */    
    public Object getSharedJavaObject(String id) {
        return getAttributeAsObject("_" + id);
    }

    /**
     * Returns all current DataSource-to-Record and DataSource-to-Record[] bindings for this
     * DataContext.
     * @return map of DataSource IDs to records
     */
    public Map<String, Object> getDataSourceRecordBindings() {
        Map<String, Object> map = new HashMap<String, Object>();
        for (String dataSourceID : getAttributes()) {
            if (dataSourceID.startsWith("_")) continue;
            map.put(dataSourceID, getDataSourceRecords(dataSourceID));
        }
        return map;
    }

    /**
     * Returns set of all DataSource IDs currently bound for this DataContext.
     * @return bound DataSource IDs
     */
    public Set<String> getBoundDataSources() {
        Set<String> set = new HashSet<String>();
        for (String dataSourceID : getAttributes()) {
            if (dataSourceID.startsWith("_")) continue;
            set.add(dataSourceID);
        }
        return set;
    }


}
