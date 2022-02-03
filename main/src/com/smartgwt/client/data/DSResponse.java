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
 * Response sent by the server in response to a {@link com.smartgwt.client.data.DSRequest DataSource request}.  Contains
 * all the properties available on the basic {@link com.smartgwt.client.rpc.RPCResponse}, in addition to the properties
 * listed here.
 */
@BeanFactory.FrameworkClass
public class DSResponse extends RPCResponse {

    public static DSResponse getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DSResponse(jsObj);
    }
        


    public DSResponse(){
        
    }

    public DSResponse(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public DSResponse(String dataSource) {
        setDataSource(dataSource);
                
    }


    public DSResponse(String dataSource, DSOperationType operationType) {
        setDataSource(dataSource);
		setOperationType(operationType);
                
    }


    public DSResponse(String dataSource, DSOperationType operationType, Record... data) {
        setDataSource(dataSource);
		setOperationType(operationType);
		setData(data);
                
    }


    // ********************* Properties / Attributes ***********************
    

    /**
     * For "fetch" operations, this is the array of Records fetched.  For "update", "add", and "remove" operations, this is
     * typically an array containing a single Record representing the record that was updated, added, or removed.
     *
     * @return Current data value. Default value is null
     */
    public Record[] getData()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfRecord(getAttributeAsJavaScriptObject("data"));
    }

    /**
     * For "fetch" operations, this is the array of Records fetched.  For "update", "add", and "remove" operations, this is
     * typically an array containing a single Record representing the record that was updated, added, or removed.
     *
     * @return Current data value. Default value is null
     */
    public RecordList getDataAsRecordList()  {
        return RecordList.getOrCreateRef(getAttributeAsJavaScriptObject("data"));
    }
    

    /**
     * The DataSource of this DSResponse.
     *
     * @param dataSource New dataSource value. Default value is null
     * @return {@link com.smartgwt.client.data.DSResponse DSResponse} instance, for chaining setter calls
     */
    public DSResponse setDataSource(String dataSource) {
        return (DSResponse)setAttribute("dataSource", dataSource);
    }

    /**
     * The DataSource of this DSResponse.
     *
     * @return Current dataSource value. Default value is null
     */
    public String getDataSource()  {
        return getAttributeAsString("dataSource");
    }
    

    /**
     * End row of returned server results, when using paged result fetching <p> Note that startRow and endRow are zero-based,
     * inclusive at the beginning and exclusive at the end (like substring), so startRow: 0, endRow: 2 is a response containing
     * two records.
     *
     * @return Current endRow value. Default value is null
     */
    public Integer getEndRow()  {
        return getAttributeAsInt("endRow");
    }
    
    

    /**
     * If set, indicates that this response came from the offline cache, not the server.  This  flag is the only reliable way
     * for application code to determine the source of a response.
     *
     * @return Current fromOfflineCache value. Default value is null
     */
    public Boolean getFromOfflineCache()  {
        return getAttributeAsBoolean("fromOfflineCache", true);
    }
    

    /**
     * HTTP headers returned by the server as a map from header name to header value. <P> Headers are available only when the
     * default {@link com.smartgwt.client.types.RPCTransport} "xmlHttpRequest" is in use, and browsers may limit access to
     * headers for cross-domain requests or in other security-sensitive scenarios.
     *
     * @return Current httpHeaders value. Default value is null
     */
    public Map getHttpHeaders()  {
        return getAttributeAsMap("httpHeaders");
    }
    

    /**
     * Optional flag that can be set by the server to force ResultSets to drop any caches of records from the DataSource that
     * was the target of the operation.
     *
     * @return Current invalidateCache value. Default value is null
     */
    public Boolean getInvalidateCache()  {
        return getAttributeAsBoolean("invalidateCache", true);
    }
    

    /**
     * Timestamp (millisecond value) to indicate when this dsResponse was cached in  {@link com.smartgwt.client.util.Offline
     * offline storage}.  Not applicable if the response has never been  stored offline.
     *
     * @return Current offlineTimestamp value. Default value is null
     */
    public Integer getOfflineTimestamp()  {
        return getAttributeAsInt("offlineTimestamp");
    }
    

    /**
     * The operation ID of the request corresponding to this DSResponse.
     *
     * @param operationId New operationId value. Default value is null
     * @return {@link com.smartgwt.client.data.DSResponse DSResponse} instance, for chaining setter calls
     */
    public DSResponse setOperationId(String operationId) {
        return (DSResponse)setAttribute("operationId", operationId);
    }

    /**
     * The operation ID of the request corresponding to this DSResponse.
     *
     * @return Current operationId value. Default value is null
     */
    public String getOperationId()  {
        return getAttributeAsString("operationId");
    }
    

    /**
     * The operation type of the request corresponding to this DSResponse.
     *
     * @param operationType New operationType value. Default value is null
     * @return {@link com.smartgwt.client.data.DSResponse DSResponse} instance, for chaining setter calls
     */
    public DSResponse setOperationType(DSOperationType operationType) {
        return (DSResponse)setAttribute("operationType", operationType == null ? null : operationType.getValue());
    }

    /**
     * The operation type of the request corresponding to this DSResponse.
     *
     * @return Current operationType value. Default value is null
     */
    public DSOperationType getOperationType()  {
        return EnumUtil.getEnum(DSOperationType.values(), getAttribute("operationType"));
    }
    

    /**
     * An extra property of each DSResponse to a queued request that indicates whether the queue as a whole succeeded.  A
     * queueStatus of {@link com.smartgwt.client.rpc.RPCResponse#STATUS_SUCCESS STATUS_SUCCESS}, or 0, indicates that the queue
     * succeeded whereas a queueStatus of {@link com.smartgwt.client.rpc.RPCResponse#STATUS_FAILURE STATUS_FAILURE}, or -1,
     * indicates that the queue failed. <p>For example, if two "update" requests are sent in a queue and the first succeeded,
     * but the second failed validation, then both DSResponses' queueStatus would be -1, but the {@link
     * com.smartgwt.client.data.DSResponse#getStatus status} of the first would be {@link
     * com.smartgwt.client.rpc.RPCResponse#STATUS_SUCCESS STATUS_SUCCESS} and the status of the second would be an error code
     * such as {@link com.smartgwt.client.rpc.RPCResponse#STATUS_VALIDATION_ERROR STATUS_VALIDATION_ERROR}.
     *
     * @param queueStatus New queueStatus value. Default value is see below
     * @return {@link com.smartgwt.client.data.DSResponse DSResponse} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ErrorHandling ErrorHandling overview and related methods
     */
    public DSResponse setQueueStatus(int queueStatus) {
        return (DSResponse)setAttribute("queueStatus", queueStatus);
    }

    /**
     * An extra property of each DSResponse to a queued request that indicates whether the queue as a whole succeeded.  A
     * queueStatus of {@link com.smartgwt.client.rpc.RPCResponse#STATUS_SUCCESS STATUS_SUCCESS}, or 0, indicates that the queue
     * succeeded whereas a queueStatus of {@link com.smartgwt.client.rpc.RPCResponse#STATUS_FAILURE STATUS_FAILURE}, or -1,
     * indicates that the queue failed. <p>For example, if two "update" requests are sent in a queue and the first succeeded,
     * but the second failed validation, then both DSResponses' queueStatus would be -1, but the {@link
     * com.smartgwt.client.data.DSResponse#getStatus status} of the first would be {@link
     * com.smartgwt.client.rpc.RPCResponse#STATUS_SUCCESS STATUS_SUCCESS} and the status of the second would be an error code
     * such as {@link com.smartgwt.client.rpc.RPCResponse#STATUS_VALIDATION_ERROR STATUS_VALIDATION_ERROR}.
     *
     * @return Current queueStatus value. Default value is see below
     * @see com.smartgwt.client.docs.ErrorHandling ErrorHandling overview and related methods
     */
    public int getQueueStatus()  {
        return getAttributeAsInt("queueStatus");
    }
    

    /**
     * Starting row of returned server results, when using paged result fetching <p> Note that startRow and endRow are
     * zero-based, inclusive at the beginning and exclusive at the end (like substring), so startRow: 0, endRow: 2 is a
     * response containing two records.
     *
     * @return Current startRow value. Default value is null
     */
    public Integer getStartRow()  {
        return getAttributeAsInt("startRow");
    }
    

    /**
     * Same meaning as {@link com.smartgwt.client.rpc.RPCResponse#getStatus RPCResponse.status}, except DSResponses have
     * additional error codes, such as {@link com.smartgwt.client.rpc.RPCResponse#STATUS_VALIDATION_ERROR validation failure}.
     *
     * @param status New status value. Default value is see below
     * @return {@link com.smartgwt.client.data.DSResponse DSResponse} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.ErrorHandling ErrorHandling overview and related methods
     */
    public DSResponse setStatus(int status) {
        return (DSResponse)setAttribute("status", status);
    }

    /**
     * Same meaning as {@link com.smartgwt.client.rpc.RPCResponse#getStatus RPCResponse.status}, except DSResponses have
     * additional error codes, such as {@link com.smartgwt.client.rpc.RPCResponse#STATUS_VALIDATION_ERROR validation failure}.
     *
     * @return Current status value. Default value is see below
     * @see com.smartgwt.client.docs.ErrorHandling ErrorHandling overview and related methods
     */
    public int getStatus()  {
        return getAttributeAsInt("status");
    }
    

    /**
     * Total number of rows available from the server that match the current filter criteria, when using paged result fetching.
     *
     * @return Current totalRows value. Default value is null
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
     * For "fetch" operations, this is the array of Records fetched.  For "update", "add", and "remove" operations, this is
     * typically an array containing a single Record representing the record that was updated, added, or removed.
     *
     * @param data data Default value is null
     */
    public void setData(Record... data) {
    	if (data != null && data.length > 0) {
 			Record r1 = data[0];
 			if (!(r1 instanceof ListGridRecord)) {
 				SC.logWarn("setData(): DSResponse data is expected to be an array of ListGridRecords." +
 						" This allows the data to be displayed as expected in ListGrids bound to this dataSource.");
 			}
 		}
    	setAttribute("data", data);
    }

    /**
     * Server-side validation errors for an attempted "update" or "add" operation, as a JS Object where each property
     * name is a field name from the record and each property value is an error message to be shown to the user.  For
     * example:
     * <pre>
     *      {
     *      	userId : ["A user with this userId already exists"],
     *      	orderId : ["Must be a numeric value", "No Order with ID '6A18294' exists"]
     *      }
     * </pre>
     *  The Java API DSResponse.addError(fieldName, errorMessage) is used to send server-side errors to the client.  
     *  See the Java Server Reference for details.
     *
     * @return the errors map
     */
    public Map getErrors() {
        JavaScriptObject jsObj = getErrorsJS(getJsObj());
        if (jsObj == null) return null;
        return JSOHelper.convertToMap(jsObj);
    }

    private native JavaScriptObject getErrorsJS(JavaScriptObject requestJS) /*-{
    	// getSimpleErrors() will convert to the simple fieldName/ error string array format
    	return $wnd.isc.DataSource.getSimpleErrors(requestJS);
    }-*/;


}
