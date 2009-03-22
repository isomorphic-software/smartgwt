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
     * Specifies URL where credentials should be submitted to attempt relogin when session timeout is encountered during a background RPC.
     * 
     * @param credentialsURL default value http://localhost:8080/isomorphic/login/loginSuccessMarker.html
     */
    public static native void setCredentialsURL(String credentialsURL) /*-{
        $wnd.isc.RPCManager.credentialsURL = credentialsURL;
    }-*/;

    /**
     * If showPrompt is enabled for a given transaction, this is the defaultPrompt to be shown to the user in a modal dialog
     * while the transaction occurs. May be overridden at the request level via RPCRequest.prompt.
     * <p>
     * More targetted default prompts are also supported for certain code-paths. See the following set of
     * properties for details:
     *
     * <ul>
     * <li>RPCManager.removeDataPrompt</li>
     * <li>RPCManager.saveDataPrompt</li>
     * <li>RPCManager.fetchDataPrompt</li>
     * </ul>
     * 
     * @param defaultPrompt the default value is 'Contacting Server...'
     */
    public static native void setDefaultPrompt(String defaultPrompt) /*-{
        $wnd.isc.RPCManager.defaultPrompt = defaultPrompt;
    }-*/;

    /**
     * <p>In milliseconds, how long the RPCManager waits for an RPC request to complete before returning an error.
     * If set to zero, the RPCManager will not enforce a timeout, but note that most browsers enforce their own timeouts
     * on HTTP requests.</p>
     *
     * <p>For the "xmlHttpRequest" transport, this timeout can only happen if the server actually fails to respond within
     * the specified number of milliseconds. For the "hiddenFrames" transport, this timeout will occur for non-200 (HTTP_OK)
     * responses.</p>
     * 
     * @param defaultTimeout the default value is 240000 [4 minutes]
     */
    public static native void setDefaultTimeout(double defaultTimeout) /*-{
        $wnd.isc.RPCManager.defaultTimeout = defaultTimeout;
    }-*/;

    /**
     * Default prompt displayed to the user while an operation is running to fetch data from the server.
     * Displayed as a result of ListGrid.filterData(), ListGrid.fetchData() and ListGrid.clearCriteria() code paths.
     *
     * @param fetchDataPrompt defaults to "Finding Records that match your criteria..."
     */
    public static native void setFetchDataPrompt(String fetchDataPrompt) /*-{
        $wnd.isc.RPCManager.fetchDataPrompt = fetchDataPrompt;
    }-*/;

    /**
     * Default prompt displayed to user while an opration is running to remove data from the server.
     * Displayed as a result of the ListGrid.removeSelectedData() code path.
     * 
     * @param removeDataPrompt default value "Deleting Record(s)..."
     */
    public static native void setRemoveDataPrompt(String removeDataPrompt) /*-{
        $wnd.isc.RPCManager.removeDataPrompt = removeDataPrompt;
    }-*/;

    /**
     * Default prompt displayed to the user while an opreration is running to save data to the server.
     * Displayed as a result of the DynamicForm.saveData() code path.
     *
     * @param saveDataPrompt default value "Saving form..."
     */
    public static native void setSaveDataPrompt(String saveDataPrompt) /*-{
        $wnd.isc.RPCManager.saveDataPrompt = saveDataPrompt;
    }-*/;

    /**
     * Controls the default cursor shown when RPCManager.promptStyle is set to "cursor". Overrideable by RPCRequest.promptCursor.
     * In Safari, IE 5.5 and Firefox 1.0 the default value is "wait", on all other platforms it is "progress". The reason for this split is that the above-mentioned browsers do not support CSS2.1 - which is required for the "progress" cursor type.
     *
     * @param promptCursor default is browser dependant
     */
    public static native void setPromptCursor(String promptCursor) /*-{
        $wnd.isc.RPCManager.promptCursor = promptCursor;
    }-*/;

    /**
     * Controls the default prompt style. Overrideable by RPCRequest.promptStyle.
     * 
     * @param promptStyle default is {@link com.smartgwt.client.types.PromptStyle#DIALOG}
     */
    public static native void setPromptStyle(PromptStyle promptStyle) /*-{
        $wnd.isc.RPCManager.promptCursor = promptStyle.@com.smartgwt.client.types.PromptStyle::getValue()();
    }-*/;

    /**
     * If set to true, the RPCManager will block the UI with a modal dialog containing the text from RPCManager.defaultPrompt (or the per-RPCRequest override) until the RPC to the server completes.
     *
     * If set to false, the RPC happens transparently, allowing the user to continue interacting with the UI

     *
     * @param showPrompt default is false
     */
    public static native void setShowPrompt(boolean showPrompt) /*-{
        $wnd.isc.RPCManager.showPrompt = showPrompt;
    }-*/;

    /**
     * Default message displayed to user when an opration fails to return from the server within the timeout period specified by RPCManager.defaultTimeout.
     * 
     * @param timeoutErrorMessage default value is "Operation timed out"
     */
    public static native void setTimeoutErrorMessage(String timeoutErrorMessage) /*-{
        $wnd.isc.RPCManager.timeoutErrorMessage = timeoutErrorMessage;
    }-*/;

    /**
     * If true, an image is shown to the right of the cursor when RPCRequest.promptStyle is set to "cursor", otherwise the cursor itself is modified via css to the value of RPCRequest.promptCursor. The default is platform-dependent. In Safari, IE 5.5 and Firefox 1.0 the default is true, on all other platforms it is false. The reason for this split is that, the above browsers require that the cursor move before CSS settings are re-evaluated - this means the progress cursor can stick until the user moves the mouse.
     * <p>
     * This value can be overridden on a per-request basis via RPCRequest.useCursorTracker.

     * @param useCursorTracking default value is platform-dependant
     */
    public static native void setUseCursorTracking(boolean useCursorTracking) /*-{
        $wnd.isc.RPCManager.useCursorTracking = useCursorTracking;
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

    /**
     * The rpcRequest parameter can be used to determine whether the suspended transaction can simply be dropped (eg, it's periodic polling request).
     * <p>
     * The rpcResponse parameter has rpcResponse.data set to the raw text of the response that triggered loginRequired(). Some very advanced relogin
     * strategies may need to inspect the raw response to get information needed for re-authentication.
     *
     * @param callback the LoginRequiredCallback
     */
    public static native void setLoginRequiredCallback(LoginRequiredCallback callback) /*-{
        $wnd.isc.RPCManager.addClassProperties({
            loginRequired : function (transactionNum, request, response) {
               var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request);
               var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response);
               callback.@com.smartgwt.client.rpc.LoginRequiredCallback::loginRequired(ILcom/smartgwt/client/rpc/RPCRequest;Lcom/smartgwt/client/rpc/RPCResponse;)(transactionNum, responseJ, requestJ);
            }
        });
    }-*/;

    /**
     * By default handleError() always logs a warning. In addition, if response.data was set to a String, a warning dialog will be shown to the user with response.data as the message,
     * which allows the server to send user error messages back without writing custom client-side error handling.
     * <p>
     *
     * To do custom error handling that is specific to a particular component or type of request, set
     * RPCRequest.willHandleError and deal with errors in the rpcRequest.callback. To change the default
     * system-wide error handling, register this callback.
     * <p>
     * If you're using the xmlHttpRequest RPCRequest.transport, you can access the HTTP status code  of the response
     * (eg 404 Not Found or 500 Server Error) as RPCResponse.httpResponseCode.
     * <p>
     * For very advanced usage, the response.xmlHttpRequest contains the native XMLHttpRequest object used to make the request.
     * Accessing this object is subject to possible cross-platform bugs and inconsistencies, and we recommend that you wrap any
     * access to the XMLHttpRequest object in a try/catch block because some browsers may throw exceptions when certain attributes
     * of this object are accessed. For example, if you try to access XMLHttpRequest.status (for the HTTP status code) when the
     * network cable is unpluged in Windows, you'll get an Exception in Firefox.
     *
     * @param callback the callback
     */
    public static native void setHandleErrorCallback(HandleErrorCallback callback) /*-{
        $wnd.isc.RPCManager.addClassProperties({
            handleError : function (response, request) {
               var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response);
               var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request);
               callback.@com.smartgwt.client.rpc.HandleErrorCallback::handleError(Lcom/smartgwt/client/data/DSResponse;Lcom/smartgwt/client/data/DSRequest;)(responseJ, requestJ);
            }
        });
    }-*/;


}



