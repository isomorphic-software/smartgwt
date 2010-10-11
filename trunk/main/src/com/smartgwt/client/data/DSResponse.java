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
 * Response sent by the server in response to a {@link com.smartgwt.client.data.DSRequest DataSource request}.  Contains
 * all the properties available on the basic {@link com.smartgwt.client.rpc.RPCResponse}, in addition to the properties
 * listed here.
 */
public class DSResponse extends RPCResponse {

    public static DSResponse getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DSResponse(jsObj);
    }

    public DSResponse(){
        
    }

    public DSResponse(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************


    /**
     * End row of returned server results, when using paged result fetching <p> Note that startRow and endRow are zero-based -
     * the first record is row zero.
     *
     *
     * @return Integer
     */
    public Integer getEndRow()  {
        return getAttributeAsInt("endRow");
    }


    /**
     * Optional flag that can be set by the server to force ResultSets to drop any caches of records from the DataSource that
     * was the target of the operation.
     *
     *
     * @return Boolean
     */
    public Boolean getInvalidateCache()  {
        return getAttributeAsBoolean("invalidateCache");
    }


    /**
     * Starting row of returned server results, when using paged result fetching <p> Note that startRow and endRow are
     * zero-based - the first record is row zero.
     *
     *
     * @return Integer
     */
    public Integer getStartRow()  {
        return getAttributeAsInt("startRow");
    }


    /**
     * Total number of rows available from the server that match the current filter criteria, when using paged result fetching.
     *
     *
     * @return Integer
     */
    public Integer getTotalRows()  {
        return getAttributeAsInt("totalRows");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        



    /**
     * Starting row of returned server results, when using paged result fetching <p> Note that startRow and endRow are
     * zero-based - the first record is row zero.
     *
     * @param startRow the start row
     */
    public void setStartRow(Integer startRow) {
        setAttribute("startRow", startRow);
    }

    /**
     * End row of returned server results, when using paged result fetching <p> Note that startRow and endRow are
     * zero-based - the first record is row zero.
     *
     * @param endRow the end row
     */
    public void setEndRow(Integer endRow) {
        setAttribute("endRow", endRow);
    }

    /**
     * Total number of rows available from the server that match the current filter criteria, when using paged result
     * fetching.
     *
     * @param totalRows total rows
     */
    public void setTotalRows(Integer totalRows) {
        setAttribute("totalRows", totalRows);
    }

    /**
     * Optional flag that can be set by the server to force ResultSets to drop any caches of records from the DataSource
     * that was the target of the operation.
     *
     * @param invalidateCache invalidateCache
     */
    public void setInvalidateCache(Boolean invalidateCache) {
        setAttribute("invalidateCache", invalidateCache);
    }

    /**
     * Server-side validation errors for an attempted "update" or "add" operation, as a JS Object where each property
     * name is a field name from the record and each property value is an error message to be shown to the user.  For
     * example:<pre>     dsResponse.errors = {         userId : "A user with this userId already exists",
     * orderId : "No Order with ID '6A18294' exists"     } </pre> The Java API DSResponse.addError(fieldName,
     * errorMessage) is used to send server-side errors to the client.  See the Java Server Reference for details.
     *
     * @param errors errors  map
     */
    public void setErrors(Map errors) {
        setAttribute("errors", errors);
    }

   /**
     * Server-side validation errors for an attempted "update" or "add" operation, as a JS Object where each property
     * name is a field name from the record and each property value is an error message to be shown to the user.  For
     * example:<pre>     dsResponse.errors = {         userId : "A user with this userId already exists",
     * orderId : "No Order with ID '6A18294' exists"     } </pre> The Java API DSResponse.addError(fieldName,
     * errorMessage) is used to send server-side errors to the client.  See the Java Server Reference for details.
     *
     * @param errors errors as JavaScriptObject
     */
    public void setErrors(JavaScriptObject errors) {
        setAttribute("errors", errors);
    }    

    /**
     * Server-side validation errors for an attempted "update" or "add" operation, as a JS Object where each property
     * name is a field name from the record and each property value is an error message to be shown to the user.  For
     * example:<pre>     dsResponse.errors = {         userId : "A user with this userId already exists",
     * orderId : "No Order with ID '6A18294' exists"     } </pre> The Java API DSResponse.addError(fieldName,
     * errorMessage) is used to send server-side errors to the client.  See the Java Server Reference for details.
     *
     * @return the errors map
     */
    public Map getErrors() {
    	
        //internally the errors object can be a JSO, or single values array
        JavaScriptObject jsObj = getAttributeAsJavaScriptObject("errors");
        if(JSOHelper.isArray(jsObj)) {
            jsObj = JSOHelper.getJSOArrayValue(jsObj, 0);
        }
        return JSOHelper.convertToMap(jsObj);
    }

    /**
     * For DataSource operations, this is typically either an Array of records representing records (for "fetch"
     * operations) or a array of a single record representing the updated record (for "update", "add" or "remove" operations).
     *
     * @param data the data
     */
    public void setData(Record[] data) {
        setAttribute("data", data);
    }

    /**
     * Return the data as an array of Records.
     *
     * @return the data
     */
    public Record[] getData() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        return Record.convertToRecordArray(dataJS);
    }

    /**
     * Return the data as a RecordList.
     *
     * @return the data
     */
    public RecordList getDataAsRecordList() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        return dataJS == null ? null : new RecordList(dataJS);
    }

}



