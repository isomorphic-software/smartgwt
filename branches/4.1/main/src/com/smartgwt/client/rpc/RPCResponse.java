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
 
package com.smartgwt.client.rpc;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
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

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Encapsulates an RPC response from the server.  Instances of this class are automatically created and optionally passed
 * to you in the callback you specify as part of your RPCRequest.
 * @see com.smartgwt.client.rpc.RPCRequest
 */
@BeanFactory.FrameworkClass
public class RPCResponse extends DataClass {

    public static RPCResponse getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new RPCResponse(jsObj);
    }


    public RPCResponse(){
        
    }

    public RPCResponse(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * HTTP headers returned by the server as a map from header name to header value. <P> Headers are available only when the
     * default {@link com.smartgwt.client.types.RPCTransport} "xmlHttpRequest" is in use, and browsers may limit access to
     * headers for cross-domain requests or in other security-sensitive scenarios.
     *
     * @return Map
     */
    public Map getHttpHeaders()  {
        return getAttributeAsMap("httpHeaders");
    }

    /**
     * This attribute (available when using the the <code>xmlHttpRequest</code> transport) contains the HTTP response code sent
     * by the server. <p> Note that this is different from {@link com.smartgwt.client.rpc.RPCResponse#getStatus status} - that
     * attribute is used to indicate a status code for the RPC itself whereas httpResponseCode is the raw HTTP response code
     * for the HTTP request that contained the RPCRequest. <p> This feature relies on the XMLHttpRequest object which can be
     * disabled by end-users in some supported browsers.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more
     * information. <p> If you're using this attribute, you'll typically want to avoid the default error handling response of
     * RPCManager.  To do so, set {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError willHandleError} to
     * <code>true</code>.
     *
     * @return Integer
     */
    public Integer getHttpResponseCode()  {
        return getAttributeAsInt("httpResponseCode");
    }

    /**
     * The actual text of the HTTP response.  Only available when the default  {@link com.smartgwt.client.types.RPCTransport}
     * "xmlHttpRequest" transport is in use,
     *
     * @return String
     */
    public String getHttpResponseText()  {
        return getAttributeAsString("httpResponseText");
    }

    /**
     * Status code for this response.  Status codes less than zero are considered errors by the RPCManager, those greater than
     * or equal to zero are considered successes.  Please see the error handling section the {@link
     * com.smartgwt.client.rpc.RPCManager RPCManager docs} for more information on what the RPCManager does with the status
     * code and how you can override this behavior. <P> When using the Smart GWT server you can set the rpcResponse.status by
     * calling the server-side method RPCResponse.setStatus().   <P> When not using the Smart GWT server, the RPCManager makes
     * no assumptions about the structure of the response, so the status code just reflects the {@link
     * com.smartgwt.client.rpc.RPCResponse#getHttpResponseCode httpResponseCode}: status will be  {@link
     * com.smartgwt.client.rpc.RPCResponse#STATUS_TRANSPORT_ERROR STATUS_TRANSPORT_ERROR} if an HTTP-level error occurred such
     * as "500 server error".  If you have a status code you need to transmit you can simply embed it in the response (as part
     * of {@link com.smartgwt.client.rpc.RPCResponse#getData data}) and interpret it from the callback. <P> With or without the
     * Smart GWT server, the {@link com.smartgwt.client.docs.Relogin} status codes (such as  {@link
     * com.smartgwt.client.rpc.RPCResponse#STATUS_LOGIN_REQUIRED STATUS_LOGIN_REQUIRED}) are triggered whenever special
     * markers, such as the loginRequiredMarker, appear in the body of the response.  See the {@link
     * com.smartgwt.client.docs.Relogin Relogin\n Overview} for details.
     *
     * @param status 
     */
    public void setStatus(int status) {
        setAttribute("status", status);
    }

    /**
     * Status code for this response.  Status codes less than zero are considered errors by the RPCManager, those greater than
     * or equal to zero are considered successes.  Please see the error handling section the {@link
     * com.smartgwt.client.rpc.RPCManager RPCManager docs} for more information on what the RPCManager does with the status
     * code and how you can override this behavior. <P> When using the Smart GWT server you can set the rpcResponse.status by
     * calling the server-side method RPCResponse.setStatus().   <P> When not using the Smart GWT server, the RPCManager makes
     * no assumptions about the structure of the response, so the status code just reflects the {@link
     * com.smartgwt.client.rpc.RPCResponse#getHttpResponseCode httpResponseCode}: status will be  {@link
     * com.smartgwt.client.rpc.RPCResponse#STATUS_TRANSPORT_ERROR STATUS_TRANSPORT_ERROR} if an HTTP-level error occurred such
     * as "500 server error".  If you have a status code you need to transmit you can simply embed it in the response (as part
     * of {@link com.smartgwt.client.rpc.RPCResponse#getData data}) and interpret it from the callback. <P> With or without the
     * Smart GWT server, the {@link com.smartgwt.client.docs.Relogin} status codes (such as  {@link
     * com.smartgwt.client.rpc.RPCResponse#STATUS_LOGIN_REQUIRED STATUS_LOGIN_REQUIRED}) are triggered whenever special
     * markers, such as the loginRequiredMarker, appear in the body of the response.  See the {@link
     * com.smartgwt.client.docs.Relogin Relogin\n Overview} for details.
     *
     * @return int
     */
    public int getStatus()  {
        return getAttributeAsInt("status");
    }

    /**
     * ID of the transaction sent to the server via {@link com.smartgwt.client.rpc.RPCManager#sendQueue RPCManager.sendQueue}
     * containing the {@link com.smartgwt.client.rpc.RPCRequest} associated with this response.
     *
     * @return Integer
     */
    public Integer getTransactionNum()  {
        return getAttributeAsInt("transactionNum");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
	/**
     * RPCResponses shouldn't be created directly. Instances of this class are automatically created and optionally passed to
     * you in the callback you specify as part of your  {@link com.smartgwt.client.rpc.RPCRequest}.
     */
    public static native void create() /*-{
        $wnd.isc.RPCResponse.create();
    }-*/;


    // ***********************************************************



    public static final int STATUS_CONNECTION_RESET_ERROR = -92;
    public static final int STATUS_FAILURE = -1;
    public static final int STATUS_LOGIN_INCORRECT = -5;
    public static final int STATUS_LOGIN_REQUIRED = -7;
    public static final int STATUS_LOGIN_SUCCESS = -8;
    public static final int STATUS_MAX_FILE_SIZE_EXCEEDED = -11;
    public static final int STATUS_MAX_LOGIN_ATTEMPTS_EXCEEDED = -6;
    public static final int STATUS_OFFLINE = 1;
    public static final int STATUS_SERVER_TIMEOUT = -100;
    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_TRANSACTION_FAILED = -10;
    public static final int STATUS_TRANSPORT_ERROR = -90;
    public static final int STATUS_UNKNOWN_HOST_ERROR = -91;
    public static final int STATUS_UPDATE_WITHOUT_PK_ERROR = -9;
    public static final int STATUS_VALIDATION_ERROR = -4;



    /**
     * The data sent by the server.
     * <P>
     * When communicating with the SmartClient server, <code>rpcResponse.data</code> is the
     * data passed to the server-side method <code>RPCResponse.setData()</code> by your Java
     * code.  This data is translated into JavaScript objects by the rules described under
     * <code>rpcRequest.data</code> in the SmartClient Reference.
     * Simple types (Numeric values, Strings, Dates, Booleans) will be available as their
     * equivalent Java types in your client side GWT code. Complex objects (such as serialized
     * <code>Map</code>s or <code>List</code>s from the server) will not be automatically
     * translated back into Java on the client - they will arrive as {@link JavaScriptObject}
     * instances. You can easily convert to the appropriate type yourself using the
     * {@link JSOHelper} class. The {@link JSOHelper#convertToJava(JavaScriptObject, boolean)}
     * method performs a recursive conversion of <code>JavaScriptObject</code>s returning a
     * <code>List</code> (or array) for JavaScript arrays or a <code>Map</code> for simple
     * JavaScript objects (key:value pairs).
     * <P>
     * When not communicating with the SmartClient server <code>rpcResponse.data</code>
     * contains the raw HTTP response body. See <code>rpcRequest.useSimpleHttp</code>,
     * </code>rpcRequest.serverOutputAsString</code>, <code>rpcRequest.evalResult</code> in
     * the SmartClient Reference for details.
     *
     * @return the data in the RPC response, as a Map
     * @see com.smartgwt.client.rpc.RPCRequest#setData(JavaScriptObject)
     * @see com.smartgwt.client.rpc.RPCRequest#setData(Map)
     * @see com.smartgwt.client.rpc.RPCRequest#setData(com.smartgwt.client.data.Record)
     * @see com.smartgwt.client.rpc.RPCRequest#setData(String)
     */
    public Map getDataAsMap() {
        return getAttributeAsMap("data");
    }

    /**
     * The data sent by the server.
     * <P>
     * When communicating with the SmartClient server, <code>rpcResponse.data</code> is the
     * data passed to the server-side method <code>RPCResponse.setData()</code> by your Java
     * code.  This data is translated into JavaScript objects by the rules described under
     * <code>rpcRequest.data</code> in the SmartClient Reference.
     * Simple types (Numeric values, Strings, Dates, Booleans) will be available as their
     * equivalent Java types in your client side GWT code. Complex objects (such as serialized
     * <code>Map</code>s or <code>List</code>s from the server) will not be automatically
     * translated back into Java on the client - they will arrive as {@link JavaScriptObject}
     * instances. You can easily convert to the appropriate type yourself using the
     * {@link JSOHelper} class. The {@link JSOHelper#convertToJava(JavaScriptObject, boolean)}
     * method performs a recursive conversion of <code>JavaScriptObject</code>s returning a
     * <code>List</code> (or array) for JavaScript arrays or a <code>Map</code> for simple
     * JavaScript objects (key:value pairs).
     * <P>
     * When not communicating with the SmartClient server <code>rpcResponse.data</code>
     * contains the raw HTTP response body. See <code>rpcRequest.useSimpleHttp</code>,
     * </code>rpcRequest.serverOutputAsString</code>, <code>rpcRequest.evalResult</code> in
     * the SmartClient Reference for details.
     *
     * @return the data in the RPC response, as a String
     * @see com.smartgwt.client.rpc.RPCRequest#setData(JavaScriptObject)
     * @see com.smartgwt.client.rpc.RPCRequest#setData(Map)
     * @see com.smartgwt.client.rpc.RPCRequest#setData(com.smartgwt.client.data.Record)
     * @see com.smartgwt.client.rpc.RPCRequest#setData(String)
     */
    public String getDataAsString() {
        return getAttributeAsString("data");
    }

    /**
     * The data sent by the server.
     * <P>
     * When communicating with the SmartClient server, <code>rpcResponse.data</code> is the
     * data passed to the server-side method <code>RPCResponse.setData()</code> by your Java
     * code.  This data is translated into JavaScript objects by the rules described under
     * <code>rpcRequest.data</code> in the SmartClient Reference.
     * Simple types (Numeric values, Strings, Dates, Booleans) will be available as their
     * equivalent Java types in your client side GWT code. Complex objects (such as serialized
     * <code>Map</code>s or <code>List</code>s from the server) will not be automatically
     * translated back into Java on the client - they will arrive as {@link JavaScriptObject}
     * instances. You can easily convert to the appropriate type yourself using the
     * {@link JSOHelper} class. The {@link JSOHelper#convertToJava(JavaScriptObject, boolean)}
     * method performs a recursive conversion of <code>JavaScriptObject</code>s returning a
     * <code>List</code> (or array) for JavaScript arrays or a <code>Map</code> for simple
     * JavaScript objects (key:value pairs).
     * <P>
     * When not communicating with the SmartClient server <code>rpcResponse.data</code>
     * contains the raw HTTP response body. See <code>rpcRequest.useSimpleHttp</code>,
     * </code>rpcRequest.serverOutputAsString</code>, <code>rpcRequest.evalResult</code> in
     * the SmartClient Reference for details.
     *
     * @return the data in the RPC response, as a JavaScriptObject
     * @see com.smartgwt.client.rpc.RPCRequest#setData(JavaScriptObject)
     * @see com.smartgwt.client.rpc.RPCRequest#setData(Map)
     * @see com.smartgwt.client.rpc.RPCRequest#setData(com.smartgwt.client.data.Record)
     * @see com.smartgwt.client.rpc.RPCRequest#setData(String)
     */
    public JavaScriptObject getDataAsObject() {
        return getAttributeAsJavaScriptObject("data");
    }

}


