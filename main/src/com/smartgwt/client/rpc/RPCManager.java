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
 * RPCManager is a static singleton class that manages transparent client/server RPC (remote
 *  procedure call).  This class provides a generic, low-level client/server communication
 *  integration point.
 *  <P>
 *  Smart GWT's powerful databinding subsystem (see {@link com.smartgwt.client.data.DataSource}, 
 * {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents}) automatically make use of this class to
 * issue
 *  RPCs as necessary, based on the 
 *  {@link com.smartgwt.client.docs.DataSourceOperations DataSource protocol}. To integrate DataBoundComponents
 *  with your server, {@link com.smartgwt.client.docs.ClientServerIntegration start here}.
 *  <P>
 *  For arbitrary client/server interactions outside of the DataSource subsystem, the
 * Smart GWT server also provides the {@link com.smartgwt.client.rpc.RPCManager#getDmiOverview Direct Method Invocation}
 * feature.
 *  <P>
 *  The RPCManager class can also be used <i>directly</i> to send data to a URL of your
 *  choosing and optionally be called back with server-returned data when the server replies.
 *  <P>
 *  The Smart GWT {@link com.smartgwt.client.rpc.RPCManager#getIscServer server code} has APIs for processing RPC requests 
 *  providing features such as automatic Java &lt;--&gt; JavaScript object translation 
 *  and handling of queued requests.<br>
 * The {@link com.smartgwt.client.rpc.RPCManager#getServletDetails IDACall servlet} makes use of these features to handle
 * standard
 *  {@link com.smartgwt.client.data.DataSource} requests and DMI calls. Developers can also override the
 *  <code>actionURL</code> of specific requests and use these APIs directly in a 
 *  JSP, Servlet or Filter.
 *  <P>
 *  Note: the client-side RPCManager class can also be used without the Smart GWT server.
 *  For an overview of client/server interactions without the Smart GWT server, see
 *  {@link com.smartgwt.client.docs.NonJavaBackend this overview}.
 *  <P>
 *  <u>Simple arbitrary Remote Procedure Call example (client code):</u>
 *  
 *  
 *  <P>
 *  <code>
 *  <pre>
 *   RPCRequest request = new RPCRequest();
 *   // Note data could be a String, Map or Record
 *   request.setData("Some data to send to the client");
 *   request.setActionURL("/rpcHandler.jsp");
 *  
 *   RPCManager.sendRequest(request, 
 *       new RPCCallback () {
 *           public void execute(RPCResponse response, Object rawData, RPCRequest request) {
 *               SC.say("Response from the server:" + rawData);
 *           }
 *       }
 *   );
 *  </pre>
 *  </code>
 *  
 *  <P>
 *  <u>Simple arbitrary Remote Procedure Call example (server code: /rpcHandler.jsp):</u>
 *  <br><br><code>
 *  RPCManager rpc = new RPCManager(request, response, out);<br>
 *  Object data = rpc.getData();<br>
 *  System.out.println("client sent: " + data.toString());<br>
 *  rpc.send("here's a response");<br>
 *  </code>
 *  <P>
 *  <u><b>Queuing</b></u>
 *  <br>
 *  Because of browser limitations on the total number of simultaneous HTTP connections to a given
 *  server, batching multiple RPC requests into a single HTTP request is highly advisable whenever
 *  possible.  The RPCManager provides a queuing mechanism that allows this.
 *  <br><br>
 *  <u>Queuing example (client code):</u>
 *  
 *  
 *  <br><br><code><pre>
 *   boolean wasQueuing = RPCManager.startQueue();
 *   
 *   RPCCallback callback = new RPCCallback() {
 *       public void execute(RPCResponse response, Object rawData, RPCRequest request) {
 *           Window.alert("response from server:" + rawData);
 *       }
 *   };
 *    
 *   RPCRequest request1 = new RPCRequest();
 *   request1.setActionURL("/rpcHandler.jsp");
 *   request1.setData("A String of Data");
 *   RPCManager.sendRequest(request1, callback);
 *    
 *   RPCRequest request2 = new RPCRequest();
 *   request2.setActionURL("/rpcHandler.jsp");
 *   request2.setData("Another String of Data");
 *   RPCManager.sendRequest(request2, callback);
 *    
 *   if (!wasQueuing) RPCManager.sendQueue();
 *  </pre></code>
 *  
 *  <p>
 *  <u>Queuing example (server code: /rpcHandler.jsp):</u>
 *  <br><br><code>
 *  RPCManager rpc = new RPCManager(request, response, out);<br>
 *  for(Iterator i = rpc.getRequests().iterator(); i.hasNext();) {<br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;RPCRequest rpcRequest = (RPCRequest)i.next();<br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;Object data = rpcRequest.getData();<br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;System.out.println("client sent:" + data.toString());<br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;//send back the data sent to us by the client<br>
 *  &nbsp;&nbsp;&nbsp;&nbsp;rpc.send(rpcRequest, new RPCResponse(data));<br>
 *  }<br>
 *  </code>
 *  <br><br>
 *  <u><b>Error Handling</b></u>
 *  <br>
 *  The {@link com.smartgwt.client.rpc.RPCResponse} object has an integer status field that the RPCManager inspects when
 *  the response is received from the server. If the value of this field is less than zero, the
 *  request is considered to have failed.  Otherwise it is considered to have succeeded.  This
 *  value is settable via the setStatus() method call on the RPCResponse server-side object.
 *  <br><br>
 *  If the status field shows a failure, the RPCManager will, by default, show a dialog with the
 *  contents of the {@link com.smartgwt.client.rpc.RPCRequest#getData data} field (which is assumed to contain a 
 *  meaningful description of the error that occurred).  If you specified a callback in your
 *  RPCRequest, it will <b>not</b> be called if the status shows a failure (see below for how to
 *  change this).
 *  <br><br>
 *  If the status field shows success, the RPCManager takes no special action.
 *  <br><br>
 *  The built-in status codes and default behavior are there for convenience.  You can choose to
 *  completely ignore it and handle errors as you see fit (for example by encoding them into the data
 *  field returned by the server, and always setting the RPCResponse status field to a success
 *  value).  In fact, the status field is automatically set to a success code
 *  (RPCResponse.STATUS_SUCCESS) by the constructor of the RPCResponse object on the server. 
 *  <br><br>
 *  If you choose to use the status field, but want to handle the errors yourself in your callback
 *  (and suppress the default error dialog popped up by the RPCManager), simply specify the
 *  {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError willHandleError:true} on your RPCRequest object.  This
 *  allows you to use the RPCManager.sendFailure() convenience methods on the server without the
 *  default error handling behavior on the client.
 */
public class RPCManager {

    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
            
    /**
     * Cancel a queue of requests (also called a transaction). <P> If a transactionId is passed, that transaction will be
     * cancelled, otherwise, the current  (not yet sent) transaction is cancelled.  You can retrieve the id of the current 
     * transaction, if there is one, by calling  {@link com.smartgwt.client.rpc.RPCManager#getCurrentTransactionId
     * getCurrentTransactionId()} before the transaction has been sent. <P> Note that cancelQueue() calls {@link
     * com.smartgwt.client.rpc.RPCManager#clearTransaction clearTransaction()} and attempts to abort the request.  However,
     * note also that whilst cancelling a  transaction that has already been sent will not necessarily stop the HTTP request
     * that  has been issued - this is only possible on some browsers and with some transports - it  will reliably cause Smart
     * GWT to ignore any response returned by the server and not  fire any callbacks that have been passed in.
     */
    public static native void cancelQueue() /*-{
        $wnd.isc.RPCManager.cancelQueue();
    }-*/;

    /**
     * Cancel a queue of requests (also called a transaction). <P> If a transactionId is passed, that transaction will be
     * cancelled, otherwise, the current  (not yet sent) transaction is cancelled.  You can retrieve the id of the current 
     * transaction, if there is one, by calling  {@link com.smartgwt.client.rpc.RPCManager#getCurrentTransactionId
     * getCurrentTransactionId()} before the transaction has been sent. <P> Note that cancelQueue() calls {@link
     * com.smartgwt.client.rpc.RPCManager#clearTransaction clearTransaction()} and attempts to abort the request.  However,
     * note also that whilst cancelling a  transaction that has already been sent will not necessarily stop the HTTP request
     * that  has been issued - this is only possible on some browsers and with some transports - it  will reliably cause Smart
     * GWT to ignore any response returned by the server and not  fire any callbacks that have been passed in.
     * @param transactionNum transactionId of the queue.
     */
    public static native void cancelQueue(String transactionNum) /*-{
        $wnd.isc.RPCManager.cancelQueue(transactionNum);
    }-*/;
            
    /**
     * Erase all client-side record of a transaction, such that any response from the server will be ignored. <P> A transaction
     * means a batch of one or more RPCRequests that have already been sent to the server via {@link
     * com.smartgwt.client.rpc.RPCManager#sendQueue RPCManager.sendQueue}. <P> You can retrieve the id of the current
     * transaction, if there is one, by  {@link com.smartgwt.client.rpc.RPCManager#getCurrentTransactionId
     * getCurrentTransactionId()} before the  transaction is sent.
     * @param transactionNum id of the transaction to be cleared
     */
    public static native void clearTransaction(String transactionNum) /*-{
        $wnd.isc.RPCManager.clearTransaction(transactionNum);
    }-*/;
            
    /**
     * Resend a suspended transaction to the server.  See {@link com.smartgwt.client.rpc.RPCManager#suspendTransaction
     * RPCManager.suspendTransaction} for context.   <P> Note that the transaction must have been previously suspended, and in
     * particular suspended validly according to the rules described in the docs for {@link
     * com.smartgwt.client.rpc.RPCManager#suspendTransaction RPCManager.suspendTransaction}, or undefined results will occur.
     * <P> You can resend <b>all</b> suspended transactions by calling {@link
     * com.smartgwt.client.rpc.RPCManager#resendTransaction RPCManager.resendTransaction} with no arguments.
     */
    public static native void resendTransaction() /*-{
        $wnd.isc.RPCManager.resendTransaction();
    }-*/;

    /**
     * Resend a suspended transaction to the server.  See {@link com.smartgwt.client.rpc.RPCManager#suspendTransaction
     * RPCManager.suspendTransaction} for context.   <P> Note that the transaction must have been previously suspended, and in
     * particular suspended validly according to the rules described in the docs for {@link
     * com.smartgwt.client.rpc.RPCManager#suspendTransaction RPCManager.suspendTransaction}, or undefined results will occur.
     * <P> You can resend <b>all</b> suspended transactions by calling {@link
     * com.smartgwt.client.rpc.RPCManager#resendTransaction RPCManager.resendTransaction} with no arguments.
     * @param transactionNum id of the transaction to be re-sent, or null to resend all                              suspended transactions
     */
    public static native void resendTransaction(String transactionNum) /*-{
        $wnd.isc.RPCManager.resendTransaction(transactionNum);
    }-*/;
            
    /**
     * Returns true if the XMLHttpRequest object is available, false otherwise.  See {@link
     * com.smartgwt.client.docs.PlatformDependencies} for more information on when XMLHttpRequest parser may not available and
     * what features are impacted as a result.
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
        
    // ***********************************************************        


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
     * Converts {@link com.smartgwt.client.widgets.Canvas#getPrintHTML printable HTML} generated from live UI components into a
     * .pdf and downloads it ("Save As.." dialog). <P> Requires the Smart GWT server framework, but does not require use of
     * server-based databinding.
     * @param canvas Canvas that has exportable widgets, or HTML fragment                                     derived from
     * @param requestProperties Request properties for the export to pdf object
     */

    public static native void exportContent(Canvas canvas, DSRequest requestProperties) /*-{
        var jsCanvas = canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        $wnd.isc.RPCManager.exportContent(jsCanvas, requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
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
        $wnd.isc.RPCManager.addClassProperties({ promptStyle: promptStyle.@com.smartgwt.client.types.PromptStyle::getValue()() });
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
     * By default SmartGWT will show a warning message on attempted requests to another domain as
     * this is usually not supported at the browser level by default due to 
     * security considerations.
     * <P>
     * Some browsers now do support cross domain requests through the use of Http Access Control headers
     * (See the {@link http://www.w3.org/TR/cors/,W3C Cross-Origin Resource Sharing recommendation}).
     * If your application intends to rely on this behavior to perform cross-domain requests, 
     * you can set <code>allowCrossDomainCalls</code> to true to disable the standard SmartGWT 
     * warning when such calls occur.
     * <P>
     * Note also that this is typically not an issue if you are using the SmartGWT server 
     * (part of Pro, Power and Enterprise editions of SmartClient), as this includes the HTTPProxy servlet.
     * @param
     */
    public static native void setAllowCrossDomainCalls(Boolean allowCrossDomainCalls) /*-{
        $wnd.isc.RPCManager.allowCrossDomainCalls = allowCrossDomainCalls;
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
            loginRequired : $entry(function (transactionNum, request, response) {
               var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request);
               var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response);
               callback.@com.smartgwt.client.rpc.LoginRequiredCallback::loginRequired(ILcom/smartgwt/client/rpc/RPCRequest;Lcom/smartgwt/client/rpc/RPCResponse;)(transactionNum, requestJ, responseJ);
            })
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
            handleError : $entry(function (response, request) {
               var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response);
               var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request);
               callback.@com.smartgwt.client.rpc.HandleErrorCallback::handleError(Lcom/smartgwt/client/data/DSResponse;Lcom/smartgwt/client/data/DSRequest;)(responseJ, requestJ);
            })
        });
    }-*/;

    /**
     * Method to handle server error responses to submitted transactions. When the server responds to a submitted transaction with an HTTP error code this method
     * will be called before any individual response callbacks are fired, regardless of whether RPCRequest.willHandleError was specified on the submitted request[s].
     * <p>
     * This provides the developer with an opportunity to handle a server error by (for example) suspending and resubmitting the transaction before any other
     * handling occurs.
     * <p>
     * The default implementation takes no action - by default transport errors are handled via {#setHandleErrorCallback()}, or by the standard request callback
     * methods, depending on request.willHandleError.
     *
     * @param callback the handleTransportError callback
     */
    public static native void setHandleTransportErrorCallback(HandleTransportErrorCallback callback) /*-{
        $wnd.isc.RPCManager.addClassProperties({
            handleTransportError : $entry(function (transactionNum, status, httpResponseCode, httpResponseText) {
               callback.@com.smartgwt.client.rpc.HandleTransportErrorCallback::handleTransportError(IIILjava/lang/String;)(transactionNum, status, httpResponseCode, httpResponseText);
            })
        });
    }-*/;
    

    /**
     * Start queuing requests. When queuing requests, an HTTP request will not be sent to the server until RPCManager.sendQueue() is called.
     * <p/>
     * All requests in a given queue must go to the same actionURL and use the same transport (XMLHttp or frames). If a request specifies a different actionURL or transport than that of the requests currently on the queue, it will be sent to the server separately, ahead of the queue, and a warning will be logged to the Developer Console.
     * <p/>
     * Note that the server must process all requests sent as part of the queue before any response is sent to the client. You should avoid batching a request that will take a long time to process on the server with any other requests because it will delay the response of all requests in the queue.
     *
     * @return whether queuing was already enabled before we called
     */
    public static native boolean startQueue() /*-{
        var isQueuing = $wnd.isc.RPCManager.startQueue();
        if (isQueuing == null) isQueuing = false;
        return isQueuing;
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
     * Send all currently queued requests to the server. You need only call this method if you are using queuing otherwise your requests are synchronously submitted to the server.
     * <p>
     * NOTE: if you aren't the caller who first enables queuing (startQueue() returns true), you should in general avoid calling sendQueue(), because whoever was first to enable queuing may have more requests to add to the same queue.
     */
    public static native void sendQueue(RPCQueueCallback callback) /*-{
        var jsCallback = $entry(function (responses) {
            var responsesJ = @com.smartgwt.client.rpc.RPCManager::convertToRPCResponseArray(Lcom/google/gwt/core/client/JavaScriptObject;)(responses);
            callback.@com.smartgwt.client.rpc.RPCQueueCallback::execute([Lcom/smartgwt/client/rpc/RPCResponse;)(responsesJ);
        });
        $wnd.isc.RPCManager.sendQueue(jsCallback);
    }-*/;
    
    private static RPCResponse[] convertToRPCResponseArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new RPCResponse[]{};
        }
        JavaScriptObject[] responsesJS = JSOHelper.toArray(nativeArray);
        RPCResponse[] objects = new RPCResponse[responsesJS.length];
        for (int i = 0; i < responsesJS.length; i++) {
            JavaScriptObject responseJS = responsesJS[i];
            objects[i] = new RPCResponse(responseJS);
        }
        return objects;
    }


    /**
     * Suspends the current transaction, such that all processing of the transaction is halted, any remaining {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} in the
     * transaction won't fire, and the transaction can never {@link com.smartgwt.client.rpc.RPCRequest#getTimeout timeout}. <P> <code>suspendTransaction()</code> is typically used
     * to handle total failures for an entire transaction, such as HTTP status 500, or session timeout resulting in {@link com.smartgwt.client.rpc.RPCManager#loginRequired} being
     * called.  In both cases the intent is to put the transaction on hold so that a transient problem can be resolved, and then the transaction can be re-sent successfully.
     * By using suspendTransaction(), components that submitted requests never realize there was a transient failure, and so error handling logic does not have to be implemented
     * in every component. <P> Generally you can only validly suspend a transaction from either {@link com.smartgwt.client.rpc.RPCManager#loginRequired} or
     * {@link com.smartgwt.client.rpc.RPCManager#handleError}, and in the case of handleError(), only when the first response in the transaction has an error.
     * Suspending and re-sending a partially processed transaction means that some responses will be processed twice, with undefined results for requests issued
     * automatically by UI components. <P> A suspended transaction must ultimately be either cleared via {@link com.smartgwt.client.rpc.RPCManager#clearTransaction}
     * or re-sent via {@link com.smartgwt.client.rpc.RPCManager#resendTransaction} or memory will be leaked.
     */
    public static native void suspendTransaction() /*-{
        $wnd.isc.RPCManager.suspendTransaction();
    }-*/;

    /**
     * Suspends the current transaction, such that all processing of the transaction is halted, any remaining {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} in
     * the transaction won't fire, and the transaction can never {@link com.smartgwt.client.rpc.RPCRequest#getTimeout timeout}. <P> <code>suspendTransaction()</code> is
     * typically used to handle total failures for an entire transaction, such as HTTP status 500, or session timeout resulting in {@link com.smartgwt.client.rpc.RPCManager#loginRequired}
     * being called.  In both cases the intent is to put the transaction on hold so that a transient problem can be resolved, and then the transaction can be re-sent successfully.
     * By using suspendTransaction(), components that submitted requests never realize there was a transient failure, and so error handling logic does not have to be implemented
     * in every component. <P> Generally you can only validly suspend a transaction from either {@link com.smartgwt.client.rpc.RPCManager#loginRequired} or
     * {@link com.smartgwt.client.rpc.RPCManager#handleError}, and in the case of handleError(), only when the first response in the transaction has an error.  Suspending and re-sending a partially processed transaction means that some responses will be processed twice, with undefined results for requests issued automatically by UI components. <P> A suspended transaction must ultimately be either cleared via {@link com.smartgwt.client.rpc.RPCManager#clearTransaction} or re-sent via {@link com.smartgwt.client.rpc.RPCManager#resendTransaction} or memory will be leaked.
     * @param transactionID transaction to delay.  Defaults to the current transaction if there is one
     */
    public static native void suspendTransaction(String transactionID) /*-{
        $wnd.isc.RPCManager.suspendTransaction(transactionID);
    }-*/;

    
    /**
     * Returns the id of the current transaction (a queue of requests). <P> This method must be called after startQueue() has
     * been called and at least one request has been issued.
     *
     * @return the transactionNum of the current transaction.
     */
    public static native String getCurrentTransactionId() /*-{
        return $wnd.isc.RPCManager.getCurrentTransactionId().toString();
    }-*/;

    /**
     * <p>Register a callback that is called by the RPCManager every time it sends a queue of requests to the
     * server (note that if you not using queuing, the system simply sends queues containing
     * just one request, so this API is valid regardless).
     * <p/>
     * It is intended to be used by user code that needs to be notified when Smart GWT sends
     * requests to the server.  Note that the list of {@link com.smartgwt.client.rpc.RPCRequest}'s passed to this
     * callback is strictly <b>read-only</b>.
     *
     * @param callback the callback
     */
    public static native void setQueueSentCallback(QueueSentCallback callback) /*-{
        $wnd.isc.RPCManager.addClassProperties({
            queueSent : $entry(function (requests) {
               var requestsJ = @com.smartgwt.client.rpc.RPCManager::convertToRPCRequestArray(Lcom/google/gwt/core/client/JavaScriptObject;)(requests);
               callback.@com.smartgwt.client.rpc.QueueSentCallback::queueSent([Lcom/smartgwt/client/rpc/RPCRequest;)(requestsJ);
            })
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
     * Send the passed RPCRequest to the server. If queuing is in effect, this queues the request instead.
     *
     * @param rpcRequestProperties  RPCRequest to send to the server
     * @param callback callback to invoke on RPC completion
     */
    public static native void sendRequest(RPCRequest rpcRequestProperties, RPCCallback callback) /*-{
        var rpcRequest = rpcRequestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        rpcRequest.callback = $entry(function (rpcResponse, data, rpcRequest) {
            var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
            var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest);
            if(callback != null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(responseJ, data, requestJ);
        });
        $wnd.isc.RPCManager.sendRequest(rpcRequest);
    }-*/;

    /**
     * This method is a convenience wrapper on RPCManager.sendRequest() - it calls through to sendRequest().
     *
     * @param data data to be passed to the server
     * @param callback callback to invoke on RPC completion
     * @param requestParams any additional properties you want to set - these will be applied to the RPCRequest object that will be auto-created for you.
     */
    public static native void send(String data, RPCCallback callback, RPCRequest requestParams) /*-{
        $wnd.isc.RPCManager.send(data, $entry(function (rpcResponse, data, rpcRequest) {
            var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
            var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest);
            if(callback != null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(responseJ, data, requestJ);
        }), requestParams == null ? null : requestParams.@com.smartgwt.client.rpc.RPCRequest::getJsObj());
    }-*/;

    /**
     * This method is a convenience wrapper on RPCManager.sendRequest() - it calls through to sendRequest().
     *
     * @param data data to be passed to the server
     * @param callback callback to invoke on RPC completion
     * @param requestParams any additional properties you want to set - these will be applied to the RPCRequest object that will be auto-created for you.
     *
     */
    public static native void send(String data, RPCCallback callback, Map requestParams) /*-{
        $wnd.isc.RPCManager.send(data, $entry(function (rpcResponse, data, rpcRequest) {
            var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
            var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest);
            if(callback != null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(responseJ, data, requestJ);
        }), requestParams == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(requestParams));
    }-*/;

    /**
     * This method is a convenience wrapper on RPCManager.sendRequest() - it calls through to sendRequest().
     *
     * @param data data to be passed to the server
     * @param callback callback to invoke on RPC completion
     * @param requestParams any additional properties you want to set - these will be applied to the RPCRequest object that will be auto-created for you.
     */
    public static native void send(JavaScriptObject data, RPCCallback callback, RPCRequest requestParams) /*-{
        $wnd.isc.RPCManager.send(data, $entry(function (rpcResponse, data, rpcRequest) {
            var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
            var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest);
            if(callback != null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(responseJ, data, requestJ);
        }), requestParams == null ? null : requestParams.@com.smartgwt.client.rpc.RPCRequest::getJsObj());
    }-*/;

    /**
     * This method is a convenience wrapper on RPCManager.sendRequest() - it calls through to sendRequest().
     *
     * @param data data to be passed to the server
     * @param callback callback to invoke on RPC completion
     * @param requestParams any additional properties you want to set - these will be applied to the RPCRequest object that will be auto-created for you.
     */
    public static native void send(JavaScriptObject data, RPCCallback callback, Map requestParams) /*-{
        $wnd.isc.RPCManager.send(data, $entry(function (rpcResponse, data, rpcRequest) {
            var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
            var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest);
            if(callback != null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(responseJ, data, requestJ);
        }), requestParams == null ? null : @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(requestParams));
    }-*/;

}



