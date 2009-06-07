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
    * RPCManager is a static singleton class that manages transparent client/server RPC (remote&#010 procedure call).  This class provides a generic, low-level client/server communication&#010 integration point.  You can use it to send arbitrary data to a URL of your choosing on the&#010 server and optionally be called back with server-returned data when the server replies.  &#010 You can process the RPC request in a JSP, Servlet or Filter on the server.&#010 <P>&#010 SmartGWT's powerful {@link com.smartgwt.client.widgets.DataBoundComponent} automatically issue&#010 RPCs as necessary, based on the &#010 {@link com.smartgwt.client.docs.DataSourceOperations 'DataSource protocol'}.  To integrate DataBoundComponents&#010 with your server, {@link com.smartgwt.client.docs.ClientServerIntegration 'start here'}.&#010 <P>&#010 <u>Simple example (client code):</u>&#010 <P><code>&#010 var data = { here: "is some data", to: ["send to the server"]};<br>&#010 RPCManager.sendRequest({ data: data, callback: "myCallback(data)", actionURL: "/rpcHandler.jsp"});<br>&#010 function myCallback(data) { alert("response from the server: " + data); }&#010 </code><br><br>&#010 <u>Simple example (server code: /rpcHandler.jsp):</u>&#010 <br><br><code>&#010 RPCManager rpc = new RPCManager(request, response, out);<br>&#010 Object data = rpc.getData();<br>&#010 System.out.println("client sent: " + data.toString());<br>&#010 rpc.send("here's a response");<br>&#010 </code>&#010 <P>&#010 Note that, while the example above uses the SmartGWT Java Server, the RPCManager is also&#010 capable of issuing RPCs that do not require a SmartGWT server.  See&#010 {@link com.smartgwt.client.docs.ClientDataIntegration 'Client-Side Data Integration'} for details.&#010 <P>&#010 <u><b>Queuing</b></u>&#010 <br>&#010 Because of browser limitations on the total number of simultaneous HTTP connections to a given&#010 server, batching multiple RPC requests into a single HTTP request is highly advisable whenever&#010 possible.  The RPCManager provides a queuing mechanism that allows this.&#010 <br><br>&#010 <u>Queuing example (client code):</u>&#010 <br><br><code>&#010 RPCManager.startQueue();<br>&#010 RPCManager.send("a string of data", "myCallback(data)", {actionURL: "/rpcHandler.jsp"});<br>&#010 RPCManager.sendRequest({ data: ["some", "more data", 2], callback: "myCallback(data)", actionURL: "/rpcHandler.jsp"});<br>&#010 RPCManager.sendRequest({ data: "different callback", callback: "myCallback2(data)", actionURL: "/rpcHandler.jsp"});<br>&#010 RPCManager.sendQueue()<br>&#010 function myCallback(data) { alert("response from the server: " + data); }<br>&#010 function myCallback2(data) { alert("response from the server (other callback): " + data); }&#010 </code><br><br>&#010 <u>Queuing example (server code: /rpcHandler.jsp):</u>&#010 <br><br><code>&#010 RPCManager rpc = new RPCManager(request, response, out);<br>&#010 for(Iterator i = rpc.getRequests().iterator(); i.hasNext();) {<br>&#010 &nbsp;&nbsp;&nbsp;&nbsp;RPCRequest rpcRequest = (RPCRequest)i.next();<br>&#010 &nbsp;&nbsp;&nbsp;&nbsp;Object data = rpcRequest.getData();<br>&#010 &nbsp;&nbsp;&nbsp;&nbsp;System.out.println("client sent:" + data.toString());<br>&#010 &nbsp;&nbsp;&nbsp;&nbsp;//send back the data sent to us by the client<br>&#010 &nbsp;&nbsp;&nbsp;&nbsp;rpc.send(rpcRequest, new RPCResponse(data));<br>&#010 }<br>&#010 </code>&#010 <br><br>&#010 <u><b>Error Handling</b></u>&#010 <br>&#010 The {@link com.smartgwt.client.rpc.RPCResponse} object has an integer status field that the RPCManager inspects when&#010 the response is received from the server. If the value of this field is less than zero, the&#010 request is considered to have failed.  Otherwise it is considered to have succeeded.  This&#010 value is settable via the setStatus() method call on the RPCResponse server-side object.&#010 <br><br>&#010 If the status field shows a failure, the RPCManager will, by default, show a dialog with the&#010 contents of the {@link com.smartgwt.client.rpc.RPCRequest#getData data} field (which is assumed to contain a &#010 meaningful description of the error that occured).  If you specified a callback in your&#010 RPCRequest, it will <b>not</b> be called if the status shows a failure (see below for how to&#010 change this).&#010 <br><br>&#010 If the status field shows success, the RPCManager takes no special action.&#010 <br><br>&#010 The built-in status codes and default behavior are there for convenience.  You can choose to&#010 completely ignore it and handle errors as you see fit (for example by encoding them into the data&#010 field returned by the server, and always setting the RPCResponse status field to a success&#010 value).  In fact, the status field is automatically set to a success code&#010 (RPCResponse.STATUS_SUCCESS) by the constructor of the RPCResponse object on the server. &#010 <br><br>&#010 If you choose to use the status field, but want to handle the errors yourself in your callback&#010 (and suppress the default error dialog popped up by the RPCManager), simply specify the&#010 {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError willHandleError} on your RPCRequest object.  This&#010 allows you to use the RPCManager.sendError() convenience methods on the server without the&#010 default error handling behavior on the client.

    */
public class RPCManager {
    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

        /**
         * &#010 Returns true if the XMLHttpRequest object is available, false otherwise.  See&#010 {@link com.smartgwt.client.docs.PlatformDependencies} for more information on when XMLHttpRequest parser may&#010 not available and what features are&#010 impacted as a result.&#010&#010
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
         * Cancel a transaction (a queue of requests being sent to the server). &#010
         */
        public static native void cancelQueue() /*-{
            $wnd.isc.RPCManager.cancelQueue();
        }-*/;

        /**
         * Erase all client-side record of a transaction, such that any response from the server&#010 will be ignored.&#010 <P>&#010 A transaction means a batch of one or more RPCRequests that have already been sent to&#010 the server via {@link com.smartgwt.client.rpc.RPCManager#sendQueue}.&#010&#010
         * @param transactionNum id of the transaction to be cleared
         */
        public static native void clearTransaction(String transactionNum) /*-{
            $wnd.isc.RPCManager.clearTransaction(transactionNum);
        }-*/;


        /**
         * Resend a suspended transaction to the server.  See {@link com.smartgwt.client.rpc.RPCManager#suspendTransaction} for&#010 context.  &#010 <P>&#010 Note that the transaction must have been previously suspended, and in particular&#010 suspended validly according to the rules described in the docs for&#010 {@link com.smartgwt.client.rpc.RPCManager#suspendTransaction}, or undefined results will occur.&#010 <P>&#010 You can resend <b>all</b> suspended transactions by calling&#010 {@link com.smartgwt.client.rpc.RPCManager#resendTransaction} with no arguments.&#010&#010
         */
        public static native void resendTransaction() /*-{
            $wnd.isc.RPCManager.resendTransaction();
        }-*/;

        /**
         * Resend a suspended transaction to the server.  See {@link com.smartgwt.client.rpc.RPCManager#suspendTransaction} for&#010 context.  &#010 <P>&#010 Note that the transaction must have been previously suspended, and in particular&#010 suspended validly according to the rules described in the docs for&#010 {@link com.smartgwt.client.rpc.RPCManager#suspendTransaction}, or undefined results will occur.&#010 <P>&#010 You can resend <b>all</b> suspended transactions by calling&#010 {@link com.smartgwt.client.rpc.RPCManager#resendTransaction} with no arguments.&#010&#010
         * @param transactionNum id of the transaction to be re-sent, or null to resend all                              suspended transactions
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
     * <p>In milliseconds, how long the RPCManager waits for an RPC request to complete before returning an error.
     * If set to zero, the RPCManager will not enforce a timeout, but note that most browsers enforce their own timeouts
     * on HTTP requests.</p>
     * <p/>
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
     * If showPrompt is enabled for a given transaction, this is the defaultPrompt to be shown to the user in a modal dialog
     * while the transaction occurs. May be overridden at the request level via RPCRequest.prompt.
     * <p/>
     * More targetted default prompts are also supported for certain code-paths. See the following set of
     * properties for details:
     * <p/>
     * <ul>
     * <li>RPCManager.removeDataPrompt</li>
     * <li>RPCManager.saveDataPrompt</li>
     * <li>RPCManager.fetchDataPrompt</li>
     * </ul>
     *
     * @param defaultPrompt the default value is 'Contacting Server...'
     */
    public static native void setDefaultPrompt(String defaultPrompt) /*-{
        @com.smartgwt.client.util.I18nUtil::init()();
        $wnd.isc.RPCManager.defaultPrompt = defaultPrompt;
    }-*/;

    /**
     * Default prompt displayed to the user while an operation is running to fetch data from the server.
     * Displayed as a result of ListGrid.filterData(), ListGrid.fetchData() and ListGrid.clearCriteria() code paths.
     *
     * @param fetchDataPrompt defaults to "Finding Records that match your criteria..."
     */
    public static native void setFetchDataPrompt(String fetchDataPrompt) /*-{
        @com.smartgwt.client.util.I18nUtil::init()();
        $wnd.isc.RPCManager.fetchDataPrompt = fetchDataPrompt;
    }-*/;

    /**
     * Default prompt displayed to user while an opration is running to remove data from the server.
     * Displayed as a result of the ListGrid.removeSelectedData() code path.
     *
     * @param removeDataPrompt default value "Deleting Record(s)..."
     */
    public static native void setRemoveDataPrompt(String removeDataPrompt) /*-{
        @com.smartgwt.client.util.I18nUtil::init()();
        $wnd.isc.RPCManager.removeDataPrompt = removeDataPrompt;
    }-*/;

    /**
     * Default prompt displayed to the user while an opreration is running to save data to the server.
     * Displayed as a result of the DynamicForm.saveData() code path.
     *
     * @param saveDataPrompt default value "Saving form..."
     */
    public static native void setSaveDataPrompt(String saveDataPrompt) /*-{
        @com.smartgwt.client.util.I18nUtil::init()();
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
     * <p/>
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
     * <p/>
     * This value can be overridden on a per-request basis via RPCRequest.useCursorTracker.
     *
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
        $wnd.isc.RPCManager.useHttpProxy = (useProxy == null ? null : useProxy.@java.lang.Boolean::booleanValue()());
    }-*/;

    /**
     * The rpcRequest parameter can be used to determine whether the suspended transaction can simply be dropped (eg, it's periodic polling request).
     * <p/>
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
               callback.@com.smartgwt.client.rpc.LoginRequiredCallback::loginRequired(ILcom/smartgwt/client/rpc/RPCRequest;Lcom/smartgwt/client/rpc/RPCResponse;)(transactionNum, requestJ, responseJ);
            }
        });
    }-*/;

    /**
     * By default handleError() always logs a warning. In addition, if response.data was set to a String, a warning dialog will be shown to the user with response.data as the message,
     * which allows the server to send user error messages back without writing custom client-side error handling.
     * <p/>
     * <p/>
     * To do custom error handling that is specific to a particular component or type of request, set
     * RPCRequest.willHandleError and deal with errors in the rpcRequest.callback. To change the default
     * system-wide error handling, register this callback.
     * <p/>
     * If you're using the xmlHttpRequest RPCRequest.transport, you can access the HTTP status code  of the response
     * (eg 404 Not Found or 500 Server Error) as RPCResponse.httpResponseCode.
     * <p/>
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

    /**
     * Start queuing requests. When queuing requests, an HTTP request will not be sent to the server until RPCManager.sendQueue() is called.
     * <p/>
     * All requests in a given queue must go to the same actionURL and use the same transport (XMLHttp or frames). If a request specifies a different actionURL or transport than that of the requests currently on the queue, it will be sent to the server separately, ahead of the queue, and a warning will be logged to the Developer Console.
     * <p/>
     * Note that the server must process all requests sent as part of the queue before any response is sent to the client. You should avoid batching a request that will take a long time to process on the server with any other requests because it will delay the response of all requests in the queue.
     */
    public static native void startQueue() /*-{
        $wnd.isc.RPCManager.startQueue();
    }-*/;

    /**
     * Send all currently queued requests to the server. You need only call this method if you are using queuing otherwise your requests are synchronously submitted to the server.
     * <p>
     * NOTE: if you aren't the caller who first enables queuing (startQueue() returns true), you should in general avoid calling sendQueue(), because whoever was first to enable queuing may have more requests to add to the same queue.
     */
    public static native void sendQueue() /*-{
        $wnd.isc.RPCManager.sendQueue();
    }-*/;

    /**
     * Suspends the current transaction, such that all processing of the transaction is halted, any remaining {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} in the transaction won't fire, and the transaction can never {@link com.smartgwt.client.rpc.RPCRequest#getTimeout timeout}. <P> <code>suspendTransaction()</code> is typically used to handle total failures for an entire transaction, such as HTTP status 500, or session timeout resulting in {@link com.smartgwt.client.rpc.RPCManager#loginRequired} being called.  In both cases the intent is to put the transaction on hold so that a transient problem can be resolved, and then the transaction can be re-sent successfully.  By using suspendTransaction(), components that submitted requests never realize there was a transient failure, and so error handling logic does not have to be implemented in every component. <P> Generally you can only validly suspend a transaction from either {@link com.smartgwt.client.rpc.RPCManager#loginRequired} or {@link com.smartgwt.client.rpc.RPCManager#handleError}, and in the case of handleError(), only when the first response in the transaction has an error.  Suspending and re-sending a partially processed transaction means that some responses will be processed twice, with undefined results for requests issued automatically by UI components. <P> A suspended transaction must ultimately be either cleared via {@link com.smartgwt.client.rpc.RPCManager#clearTransaction} or re-sent via {@link com.smartgwt.client.rpc.RPCManager#resendTransaction} or memory will be leaked.
     */
    public static native void suspendTransaction() /*-{
        $wnd.isc.RPCManager.suspendTransaction();
    }-*/;

    /**
     * Suspends the current transaction, such that all processing of the transaction is halted, any remaining {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} in the transaction won't fire, and the transaction can never {@link com.smartgwt.client.rpc.RPCRequest#getTimeout timeout}. <P> <code>suspendTransaction()</code> is typically used to handle total failures for an entire transaction, such as HTTP status 500, or session timeout resulting in {@link com.smartgwt.client.rpc.RPCManager#loginRequired} being called.  In both cases the intent is to put the transaction on hold so that a transient problem can be resolved, and then the transaction can be re-sent successfully.  By using suspendTransaction(), components that submitted requests never realize there was a transient failure, and so error handling logic does not have to be implemented in every component. <P> Generally you can only validly suspend a transaction from either {@link com.smartgwt.client.rpc.RPCManager#loginRequired} or {@link com.smartgwt.client.rpc.RPCManager#handleError}, and in the case of handleError(), only when the first response in the transaction has an error.  Suspending and re-sending a partially processed transaction means that some responses will be processed twice, with undefined results for requests issued automatically by UI components. <P> A suspended transaction must ultimately be either cleared via {@link com.smartgwt.client.rpc.RPCManager#clearTransaction} or re-sent via {@link com.smartgwt.client.rpc.RPCManager#resendTransaction} or memory will be leaked.
     * @param transactionID transaction to delay.  Defaults to the current transaction if there is one
     */
    public static native void suspendTransaction(String transactionID) /*-{
        $wnd.isc.RPCManager.suspendTransaction(transactionID);
    }-*/;

    /**
     * <p>Register a callback that is called by the RPCManager every time it sends a queue of requests to the
     * server (note that if you not using queuing, the system simply sends queues containing
     * just one request, so this API is valid regardless).
     * <p/>
     * It is intended to be used by user code that needs to be notified when SmartGWT sends
     * requests to the server.  Note that the list of {@link com.smartgwt.client.rpc.RPCRequest}'s passed to this
     * callback is strictly <b>read-only</b>.
     *
     * @param callback the callback
     */
    public static native void setQueueSentCallback(QueueSentCallback callback) /*-{
        $wnd.isc.RPCManager.addClassProperties({
            queueSent : function (requests) {
               var requestsJ = @com.smartgwt.client.rpc.RPCManager::convertToRPCRequestArray(Lcom/google/gwt/core/client/JavaScriptObject;)(requests);
               callback.@com.smartgwt.client.rpc.QueueSentCallback::queueSent([Lcom/smartgwt/client/rpc/RPCRequest;)(requestsJ);
            }
        });
    }-*/;

    private static RPCRequest[] convertToRPCRequestArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new RPCRequest[]{};
        }
        JavaScriptObject[] requestsJS = JSOHelper.toArray(nativeArray);
        RPCRequest[] objects = new RPCRequest[requestsJS.length];
        for (int i = 0; i < requestsJS.length; i++) {
            JavaScriptObject requestJS = requestsJS[i];
            objects[i] = new RPCRequest(requestJS);
        }
        return objects;
    }

    /**
     * Send the passed RPCRequest to the server. If queuing is in effect, this queues the request instead.
     * 
     * @param rpcRequestProperties  RPCRequest to send to the server
     */
    public static native void sendRequest(RPCRequest rpcRequestProperties) /*-{
        $wnd.isc.RPCManager.sendRequest(rpcRequestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * This method is a convenience wrapper on RPCManager.sendRequest() - it calls through to sendRequest().
     * 
     * @param data data to be passed to the server
     * @param callback callback to invoke on RPC completion
     * @param requestParams any additional properties you want to set - these will be applied to the RPCRequest object that will be auto-created for you.
     */
    public static native void send(String data, RPCCallback callback, Map requestParams) /*-{
        $wnd.isc.RPCManager.send(data, function (rpcResponse, data, rpcRequest) {
            var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
            var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest);
            if(callback != null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(responseJ, data, requestJ);
        }, requestParams == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(requestParams));
    }-*/;

    /**
     * This method is a convenience wrapper on RPCManager.sendRequest() - it calls through to sendRequest().
     *
     * @param data data to be passed to the server
     * @param callback callback to invoke on RPC completion
     * @param requestParams any additional properties you want to set - these will be applied to the RPCRequest object that will be auto-created for you.
     */
    public static native void send(JavaScriptObject data, RPCCallback callback, Map requestParams) /*-{
        $wnd.isc.RPCManager.send(data, function (rpcResponse, data, rpcRequest) {
            var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
            var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest);
            if(callback != null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(responseJ, data, requestJ);
        }, requestParams == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(requestParams));
    }-*/;

}



