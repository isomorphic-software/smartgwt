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
    * RPCManager is a static singleton class that manages transparent client/server RPC (remote procedure call).  This class provides a generic, low-level client/server communication integration point.  You can use it to send arbitrary data to a URL of your choosing on the server and optionally be called back with server-returned data when the server replies.   You can process the RPC request in a JSP, Servlet or Filter on the server. <P> SmartClient's powerful ${isc.DocUtils.linkForRef('interface:DataBoundComponent','DataBoundComponents')} automatically issue RPCs as necessary, based on the  DataSource protocol.  To integrate DataBoundComponents with your server, start here. <P> <u>Simple example (client code):</u> <P><code> var data = { here: "is some data", to: ["send to the server"]};<br> RPCManager.sendRequest({ data: data, callback: "myCallback(data)", actionURL: "/rpcHandler.jsp"});<br> function myCallback(data) { alert("response from the server: " + data); } </code><br><br> <u>Simple example (server code: /rpcHandler.jsp):</u> <br><br><code> RPCManager rpc = new RPCManager(request, response, out);<br> Object data = rpc.getData();<br> System.out.println("client sent: " + data.toString());<br> rpc.send("here's a response");<br> </code> <P> Note that, while the example above uses the SmartClient Java Server, the RPCManager is also capable of issuing RPCs that do not require a SmartClient server.  See Client-Side Data Integration for details. <P> <u><b>Queuing</b></u> <br> Because of browser limitations on the total number of simultaneous HTTP connections to a given server, batching multiple RPC requests into a single HTTP request is highly advisable whenever possible.  The RPCManager provides a queuing mechanism that allows this. <br><br> <u>Queuing example (client code):</u> <br><br><code> RPCManager.startQueue();<br> RPCManager.send("a string of data", "myCallback(data)", {actionURL: "/rpcHandler.jsp"});<br> RPCManager.sendRequest({ data: ["some", "more data", 2], callback: "myCallback(data)", actionURL: "/rpcHandler.jsp"});<br> RPCManager.sendRequest({ data: "different callback", callback: "myCallback2(data)", actionURL: "/rpcHandler.jsp"});<br> RPCManager.sendQueue()<br> function myCallback(data) { alert("response from the server: " + data); }<br> function myCallback2(data) { alert("response from the server (other callback): " + data); } </code><br><br> <u>Queuing example (server code: /rpcHandler.jsp):</u> <br><br><code> RPCManager rpc = new RPCManager(request, response, out);<br> for(Iterator i = rpc.getRequests().iterator(); i.hasNext();) {<br> &nbsp;&nbsp;&nbsp;&nbsp;RPCRequest rpcRequest = (RPCRequest)i.next();<br> &nbsp;&nbsp;&nbsp;&nbsp;Object data = rpcRequest.getData();<br> &nbsp;&nbsp;&nbsp;&nbsp;System.out.println("client sent:" + data.toString());<br> &nbsp;&nbsp;&nbsp;&nbsp;//send back the data sent to us by the client<br> &nbsp;&nbsp;&nbsp;&nbsp;rpc.send(rpcRequest, new RPCResponse(data));<br> }<br> </code> <br><br> <u><b>Error Handling</b></u> <br> The {@link com.smartgwt.client.rpc.RPCResponse} object has an integer status field that the RPCManager inspects when the response is received from the server. If the value of this field is less than zero, the request is considered to have failed.  Otherwise it is considered to have succeeded.  This value is settable via the setStatus() method call on the RPCResponse server-side object. <br><br> If the status field shows a failure, the RPCManager will, by default, show a dialog with the contents of the {@link com.smartgwt.client.rpc.RPCRequest#getData data} field (which is assumed to contain a  meaningful description of the error that occured).  If you specified a callback in your RPCRequest, it will <b>not</b> be called if the status shows a failure (see below for how to change this). <br><br> If the status field shows success, the RPCManager takes no special action. <br><br> The built-in status codes and default behavior are there for convenience.  You can choose to completely ignore it and handle errors as you see fit (for example by encoding them into the data field returned by the server, and always setting the RPCResponse status field to a success value).  In fact, the status field is automatically set to a success code (RPCResponse.STATUS_SUCCESS) by the constructor of the RPCResponse object on the server.  <br><br> If you choose to use the status field, but want to handle the errors yourself in your callback (and suppress the default error dialog popped up by the RPCManager), simply specify the {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError willHandleError} on your RPCRequest object.  This allows you to use the RPCManager.sendError() convenience methods on the server without the default error handling behavior on the client.

    */
public class RPCManager {
    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

        /**
         * Returns true if the XMLHttpRequest object is available, false otherwise.  See ${isc.DocUtils.linkForRef('group:platformDependencies')} for more information on when XMLHttpRequest parser may not available and what features are impacted as a result.
         *
         * @return true if XMLHttpRequest is available, false otherwise.
         */
        public static native Boolean xmlHttpRequestAvailable() /*-{
            var retVal =$wnd.isc.RPCManager.xmlHttpRequestAvailable();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;





        /**
         * Cancel a transaction (a queue of requests being sent to the server).
         */
        public static native void cancelQueue() /*-{
            $wnd.isc.RPCManager.cancelQueue();
        }-*/;

        /**
         * Erase all client-side record of a transaction, such that any response from the server will be ignored. <P> A transaction means a batch of one or more RPCRequests that have already been sent to the server via {@link com.smartgwt.client.rpc.RPCManager#sendQueue}.
         * @param transactionNum id of the transaction to be cleared
         */
        public static native void clearTransaction(String transactionNum) /*-{
            $wnd.isc.RPCManager.clearTransaction(transactionNum);
        }-*/;

        /**
         * Resend a transaction to the server. <P> A transaction means a batch of one or more RPCRequests that have already been sent to the server via {@link com.smartgwt.client.rpc.RPCManager#sendQueue}. <P> This is typically used as part of Relogin handling to resend a request that encountered a session timeout.
         * @param transactionNum id of the transaction to be re-sent
         */
        public static native void resendTransaction(String transactionNum) /*-{
            $wnd.isc.RPCManager.resendTransaction(transactionNum);
        }-*/;







    /**
     * The actionURL specifies the URL to which the RPC request will be sent. Note that if you override this global
     * default and your application uses DataSource databound components, you'll need to dispatch the DataSource
     * requests from your RPC handler. Your other option is to specify a url on a per-request basis.
     *
     * @param actionURL the action URL.
     */
    public static native void setActionURL(String actionURL) /*-{
        $wnd.isc.RPCManager.actionURL = actionURL;
    }-*/;

    /**
     * Whether to ever attempt to use the "HttpProxy" servlet to enable web service requests to
     * servers other than the origin server.
     *
     * @param useProxy enable or disable attempting to use the "HttpProxy" servlet
     */
    public static native void setUseHttpProxy(Boolean useProxy) /*-{
        $wnd.isc.RPCManager.useHttpProxy = useProxy;
    }-*/;

}



