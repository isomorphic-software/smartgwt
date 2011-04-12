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
 
package com.smartgwt.client.rpc;



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
import com.smartgwt.client.widgets.cube.*;

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
 * Encapsulates an RPC response from the server.  Instances of this class are automatically created and optionally passed
 * to you in the callback you specify as part of your RPCRequest.
 * @see com.smartgwt.client.rpc.RPCRequest
 */
public class RPCResponse extends DataClass {

    public static RPCResponse getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new RPCResponse(jsObj);
    }

    public RPCResponse(){
        
    }

    public RPCResponse(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************


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
     *
     * @return Integer
     */
    public Integer getHttpResponseCode()  {
        return getAttributeAsInt("httpResponseCode");
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
     * com.smartgwt.client.docs.Relogin Relogin Overview} for details.
     *
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
     *
     * @return Integer
     */
    public Integer getTransactionNum()  {
        return getAttributeAsInt("transactionNum");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        



    public static int STATUS_FAILURE = -1;
    public static int STATUS_LOGIN_INCORRECT = -5;
    public static int STATUS_LOGIN_REQUIRED = -7;
    public static int STATUS_LOGIN_SUCCESS = -8;
    public static int STATUS_MAX_LOGIN_ATTEMPTS_EXCEEDED = -6;
    public static int STATUS_SERVER_TIMEOUT = -100;
    public static int STATUS_SUCCESS = 0;
    public static int STATUS_TRANSPORT_ERROR = -90;
    public static int STATUS_VALIDATION_ERROR = -4;

    /**
     * Status code for this response.  Status codes less than zero are considered errors by the RPCManager, those
     * greater than or equal to zero are considered successes.  Please see the error handling section the {@link
     * com.smartgwt.client.rpc.RPCManager} for more information on what the RPCManager does with the status code and how
     * you can override this behavior. <P> When using the Smart GWT server you can set the rpcResponse.status by
     * calling the server-side method RPCResponse.setStatus().   <P> When not using the Smart GWT server, the
     * RPCManager makes no assumptions about the structure of the response, so the status code just reflects the {@link
     * com.smartgwt.client.rpc.RPCResponse#getHttpResponseCode httpResponseCode}: status will be  {@link
     * com.smartgwt.client.rpc.RPCResponse#STATUS_TRANSPORT_ERROR} if an HTTP-level error occurred such as "500 server
     * error".  If you have a status code you need to transmit you can simply embed it in the response (as part of
     * {@link com.smartgwt.client.rpc.RPCResponse#getData data}) and interpret it from the callback. <P> With or without
     * the Smart GWT server, the Relogin Overview for details.
     *
     * @param status status
     */
    public void setStatus(int status) {
        setAttribute("status", status);
    }

}



