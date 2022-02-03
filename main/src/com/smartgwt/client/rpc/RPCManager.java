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

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
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
 *  Smart GWT server also provides the {@link com.smartgwt.client.docs.DmiOverview Direct Method Invocation} feature.
 *  <P>
 *  The RPCManager class can also be used <i>directly</i> to send data to a URL of your
 *  choosing and optionally be called back with server-returned data when the server replies.
 *  <P>
 *  The Smart GWT {@link com.smartgwt.client.docs.IscServer server code} has APIs for processing RPC requests 
 *  providing features such as automatic Java &lt;--&gt; JavaScript object translation 
 *  and handling of queued requests.<br>
 *  The {@link com.smartgwt.client.docs.ServletDetails IDACall servlet} makes use of these features to handle standard
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
 *  
 *  <P>
 *  <u>Simple arbitrary Remote Procedure Call example (server code: /rpcHandler.jsp):</u>
 *  <br><br><pre>
 *  RPCManager rpc = new RPCManager(request, response, out);
 *  Object data = rpc.getData();
 *  System.out.println("client sent: " + data.toString());
 *  rpc.send("here's a response");
 *  </pre>
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
 *  <pre>
 *  boolean wasQueuing = RPCManager.startQueue();
 *   
 *  RPCCallback callback = new RPCCallback() {
 *      public void execute(RPCResponse response, Object rawData, RPCRequest request) {
 *          Window.alert("response from server:" + rawData);
 *      }
 *  };
 *    
 *  RPCRequest request1 = new RPCRequest();
 *  request1.setActionURL("/rpcHandler.jsp");
 *  request1.setData("A String of Data");
 *  RPCManager.sendRequest(request1, callback);
 *    
 *  RPCRequest request2 = new RPCRequest();
 *  request2.setActionURL("/rpcHandler.jsp");
 *  request2.setData("Another String of Data");
 *  RPCManager.sendRequest(request2, callback);
 *    
 *  if (!wasQueuing) RPCManager.sendQueue();
 *  </pre>
 *  
 *  <p>
 *  <u>Queuing example (server code: /rpcHandler.jsp):</u>
 *  <br><br><pre>
 *  RPCManager rpc = new RPCManager(request, response, out);
 * 
 *  for(Iterator i = rpc.getRequests().iterator(); i.hasNext();) {
 *      RPCRequest rpcRequest = (RPCRequest)i.next();
 *      Object data = rpcRequest.getData();
 *      System.out.println("client sent:" + data.toString());
 * 
 *      //send back the data sent to us by the client
 *      rpc.send(rpcRequest, new RPCResponse(data));
 *  }<br>
 *  </pre>
 *  <br><br>
 *  <u><b>Error Handling</b></u><br><br>
 *  Please see this {@link com.smartgwt.client.docs.ErrorHandling separate article} on error handling.
 *  <br>
 */
@BeanFactory.FrameworkClass
public class RPCManager {


    // ********************* Properties / Attributes ***********************

    /** 
     * Specifies the default URL for RPCRequests and DSRequests that do not specify a URL. <p> URLs can be set on a per-request
     * basis via {@link com.smartgwt.client.rpc.RPCRequest#getActionURL RPCRequest.actionURL}, or on a per-DataSource or
     * per-operationType basis via {@link com.smartgwt.client.data.DataSource#getDataURL DataSource.dataURL} and {@link
     * com.smartgwt.client.data.OperationBinding#getDataURL OperationBinding.dataURL} respectively.  However, note that in
     * order to be able to make use of {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing}, you should have all data
     * loading and saving requests go to a single URL unless you are forced to use distinct URLs by legacy services. <p> The
     * primary use case for setting the default <code>actionURL</code> is to add a CSRF / XSRF  (<a
     * href='http://en.wikipedia.org/wiki/Cross-site_request_forgery' target='_blank'>Cross-site Request Forgery</a>)  token. 
     * Assuming you are using a single URL for all data requests as covered above, adding a CSRF token to the default
     * <code>actionURL</code> as a simple HTTP parameter will cause the CSRF token to be included in all RPCRequests and
     * DSRequests from all DataSources without further effort. <P> If the <code>actionURL</code> is changed while transactions
     * are suspended, any suspended transactions whose <code>actionURL</code> was defaulted to this property (e.g. because
     * {@link com.smartgwt.client.rpc.RPCRequest#getActionURL RPCRequest.actionURL} wasn't set) will be updated to have the new
     * <code>actionURL</code>.
     *
     * @param actionURL new actionURL.  Default value is RPCManager.actionURL.
     */
    public static native void setActionURL(String actionURL) /*-{
        $wnd.isc.RPCManager.setActionURL(actionURL);
    }-*/;

    /** 
     * Specifies the default URL for RPCRequests and DSRequests that do not specify a URL. <p> URLs can be set on a per-request
     * basis via {@link com.smartgwt.client.rpc.RPCRequest#getActionURL RPCRequest.actionURL}, or on a per-DataSource or
     * per-operationType basis via {@link com.smartgwt.client.data.DataSource#getDataURL DataSource.dataURL} and {@link
     * com.smartgwt.client.data.OperationBinding#getDataURL OperationBinding.dataURL} respectively.  However, note that in
     * order to be able to make use of {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing}, you should have all data
     * loading and saving requests go to a single URL unless you are forced to use distinct URLs by legacy services. <p> The
     * primary use case for setting the default <code>actionURL</code> is to add a CSRF / XSRF  (<a
     * href='http://en.wikipedia.org/wiki/Cross-site_request_forgery' target='_blank'>Cross-site Request Forgery</a>)  token. 
     * Assuming you are using a single URL for all data requests as covered above, adding a CSRF token to the default
     * <code>actionURL</code> as a simple HTTP parameter will cause the CSRF token to be included in all RPCRequests and
     * DSRequests from all DataSources without further effort. <P> If the <code>actionURL</code> is changed while transactions
     * are suspended, any suspended transactions whose <code>actionURL</code> was defaulted to this property (e.g. because
     * {@link com.smartgwt.client.rpc.RPCRequest#getActionURL RPCRequest.actionURL} wasn't set) will be updated to have the new
     * <code>actionURL</code>.
     *
     * @return current value of actionURL
     */
    public static native String getActionURL() /*-{
        return $wnd.isc.RPCManager.actionURL;
    }-*/;

    /** 
     * By default Smart GWT will show a warning message on attempted requests to another domain as this is usually not
     * supported at the browser level by default due to  security considerations. <P> Some browsers now do support cross domain
     * requests through the use of Http Access Control headers (See the <a href='http://www.w3.org/TR/cors/'
     * target='_blank'>W3C Cross-Origin Resource Sharing recommendation</a>). If your application intends to rely on this
     * behavior to perform cross-domain requests,  you can set <code>allowCrossDomainCalls</code> to true to disable the
     * standard Smart GWT  warning when such calls occur. <P> Note also that this is typically not an issue if you are using
     * the Smart GWT server  (part of Pro, Power and Enterprise editions of Smart GWT), as this includes the  {@link
     * com.smartgwt.client.rpc.RPCManager#sendProxied HTTPProxy servlet}.
     *
     * @param allowCrossDomainCalls new allowCrossDomainCalls.  Default value is false.
     */
    public static native void setAllowCrossDomainCalls(Boolean allowCrossDomainCalls) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/Boolean;)($wnd.isc.RPCManager, "allowCrossDomainCalls", allowCrossDomainCalls);
    }-*/;

    /** 
     * Specifies URL where credentials should be submitted to attempt relogin when session timeout is encountered during a
     * background RPC.  See {@link com.smartgwt.client.docs.Relogin Relogin}
     *
     * @param credentialsURL new credentialsURL.  Default value is http://localhost:8080/isomorphic/login/loginSuccessMarker.html.
     */
    public static native void setCredentialsURL(String credentialsURL) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)($wnd.isc.RPCManager, "credentialsURL", credentialsURL);
    }-*/;

    /** 
     * Specifies URL where credentials should be submitted to attempt relogin when session timeout is encountered during a
     * background RPC.  See {@link com.smartgwt.client.docs.Relogin Relogin}
     *
     * @return current value of credentialsURL
     */
    public static native String getCredentialsURL() /*-{
        return $wnd.isc.RPCManager.credentialsURL;
    }-*/;

    /** 
     * Marker the system will look for in order to detect when login is required. <P> The default loginRequired marker should
     * generally <b>not</b> be customized.  It is designed to be safe to insert into any HTML page or other server response
     * without affecting display or functionality, for example, within an HTML comment.  You should *only* customize the
     * <code>loginRequiredMarker</code> if you have absolutely no ability to change the response that the server will send when
     * login is required. <P> If you do customize the <code>loginRequiredMarker</code>, then the loginRequiredMarker, {@link
     * com.smartgwt.client.rpc.RPCManager#loginSuccessMarker loginSuccessMarker} and {@link
     * com.smartgwt.client.rpc.RPCManager#maxLoginAttemptsExceededMarker maxLoginAttemptsExceededMarker} should all start with
     * the  {@link com.smartgwt.client.rpc.RPCManager#loginStatusCodeMarker loginStatusCodeMarker}.  If they do not, there will
     * be a small impact on  performance as every response must be separately scanned for each marker, instead of just scanning
     * once for the {@link com.smartgwt.client.rpc.RPCManager#loginStatusCodeMarker loginStatusCodeMarker}. <P> In addition,
     * the {@link com.smartgwt.client.rpc.RPCManager#loginStatusCodeMarker loginStatusCodeMarker} should ideally contain text
     * that could not possibly validly appear as a data value in a normal response, since if that were possible, end users
     * could enter the loginRequiredMarker as a data value and cause Smart GWT to falsely detect session timeout when handling
     * an ordinary data response.  This is why the default marker has characters that make it impossible for it to be validly
     * interpreted as a JavaScript String, XML document or HTML content - there is no way that an end user could enter this as
     * a data value in an application and have it appear verbatim in a server response.
     *
     * @param loginRequiredMarker new loginRequiredMarker.  Default value is &lt;SCRIPT&gt;//'\&quot;]]&gt;&gt;isc_loginRequired.
     */
    public static native void setLoginRequiredMarker(String loginRequiredMarker) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)($wnd.isc.RPCManager, "loginRequiredMarker", loginRequiredMarker);
    }-*/;

    /** 
     * Marker the system will look for in order to detect when login is required. <P> The default loginRequired marker should
     * generally <b>not</b> be customized.  It is designed to be safe to insert into any HTML page or other server response
     * without affecting display or functionality, for example, within an HTML comment.  You should *only* customize the
     * <code>loginRequiredMarker</code> if you have absolutely no ability to change the response that the server will send when
     * login is required. <P> If you do customize the <code>loginRequiredMarker</code>, then the loginRequiredMarker, {@link
     * com.smartgwt.client.rpc.RPCManager#loginSuccessMarker loginSuccessMarker} and {@link
     * com.smartgwt.client.rpc.RPCManager#maxLoginAttemptsExceededMarker maxLoginAttemptsExceededMarker} should all start with
     * the  {@link com.smartgwt.client.rpc.RPCManager#loginStatusCodeMarker loginStatusCodeMarker}.  If they do not, there will
     * be a small impact on  performance as every response must be separately scanned for each marker, instead of just scanning
     * once for the {@link com.smartgwt.client.rpc.RPCManager#loginStatusCodeMarker loginStatusCodeMarker}. <P> In addition,
     * the {@link com.smartgwt.client.rpc.RPCManager#loginStatusCodeMarker loginStatusCodeMarker} should ideally contain text
     * that could not possibly validly appear as a data value in a normal response, since if that were possible, end users
     * could enter the loginRequiredMarker as a data value and cause Smart GWT to falsely detect session timeout when handling
     * an ordinary data response.  This is why the default marker has characters that make it impossible for it to be validly
     * interpreted as a JavaScript String, XML document or HTML content - there is no way that an end user could enter this as
     * a data value in an application and have it appear verbatim in a server response.
     *
     * @return current value of loginRequiredMarker
     */
    public static native String getLoginRequiredMarker() /*-{
        return $wnd.isc.RPCManager.loginRequiredMarker;
    }-*/;

    /** 
     * String sequence which marks the response as a one which contains login status information.
     *
     * @param loginStatusCodeMarker new loginStatusCodeMarker.  Default value is &lt;SCRIPT&gt;//'\&quot;]]&gt;&gt;isc_.
     */
    public static native void setLoginStatusCodeMarker(String loginStatusCodeMarker) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)($wnd.isc.RPCManager, "loginStatusCodeMarker", loginStatusCodeMarker);
    }-*/;

    /** 
     * String sequence which marks the response as a one which contains login status information.
     *
     * @return current value of loginStatusCodeMarker
     */
    public static native String getLoginStatusCodeMarker() /*-{
        return $wnd.isc.RPCManager.loginStatusCodeMarker;
    }-*/;

    /** 
     * Marker the system will look for in order to detect when login was successfull.
     *
     * @param loginSuccessMarker new loginSuccessMarker.  Default value is &lt;SCRIPT&gt;//'\&quot;]]&gt;&gt;isc_loginSuccess.
     */
    public static native void setLoginSuccessMarker(String loginSuccessMarker) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)($wnd.isc.RPCManager, "loginSuccessMarker", loginSuccessMarker);
    }-*/;

    /** 
     * Marker the system will look for in order to detect when login was successfull.
     *
     * @return current value of loginSuccessMarker
     */
    public static native String getLoginSuccessMarker() /*-{
        return $wnd.isc.RPCManager.loginSuccessMarker;
    }-*/;

    /** 
     * If set to <code>true</code>, the RPCManager will block the UI with a modal dialog containing the text from
     * RPCManager.defaultPrompt (or the per-RPCRequest override) until the RPC to the server completes. <p> If set to
     * <code>false</code>, the RPC happens transparently, allowing the user to continue interacting with the UI. <p> DataSource
     * requests, which are a particular type of RPCRequest, are controlled by the more-specific DataSource-level setting {@link
     * com.smartgwt.client.data.DataSource#getShowPrompt DataSource.showPrompt}.
     *
     * @param showPrompt new showPrompt.  Default value is RPCManager.showPrompt.
     */
    public static native void setShowPrompt(boolean showPrompt) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Z)($wnd.isc.RPCManager, "showPrompt", showPrompt);
    }-*/;

    /** 
     * Default message displayed to user when an operation fails to return from the server within the timeout period specified
     * by {@link com.smartgwt.client.rpc.RPCManager#defaultTimeout defaultTimeout}.
     *
     * @param timeoutErrorMessage new timeoutErrorMessage.  Default value is "Operation timed out".
     */
    public static native void setTimeoutErrorMessage(String timeoutErrorMessage) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)($wnd.isc.RPCManager, "timeoutErrorMessage", timeoutErrorMessage);
    }-*/;

    /** 
     * Whether the {@link com.smartgwt.client.docs.ServletDetails HttpProxyServlet} should be used in order to get around the
     * "same origin policy" that prevents web pages from contacting other sites. <p> Default behavior is to use the
     * HttpProxyServlet whenever a URL appears to be pointing to another site.  Set {@link
     * com.smartgwt.client.rpc.RPCRequest#getUseHttpProxy RPCRequest.useHttpProxy} false to have a particular request avoid
     * using the HttpProxyServlet even when it appears to be necessary, or set <code>RPCManager.useHttpProxy</code> to false to
     * avoid ever attempting to use the HttpProxyServlet.
     *
     * @param useHttpProxy new useHttpProxy.  Default value is true.
     */
    public static native void setUseHttpProxy(Boolean useHttpProxy) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/Boolean;)($wnd.isc.RPCManager, "useHttpProxy", useHttpProxy);
    }-*/;

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Loads the definitions of a set of screens saved in {@link com.smartgwt.client.docs.ComponentXML Component XML} format,
     * using the {@link com.smartgwt.client.docs.ServletDetails ScreenLoaderServlet}. <p> Unlike {@link
     * com.smartgwt.client.rpc.RPCManager#loadScreen loadScreen()}, <code>cacheScreens()</code> does not cause any UI
     * components to be created or drawn, it just loads the definitions of the screens.  This allows a subsequent, synchronous
     * call to {@link com.smartgwt.client.rpc.RPCManager#createScreen createScreen()} to create the actual screen, rather than
     * contacting the <code>ScreenLoader</code> servlet and showing a loading message. <p> See {@link
     * com.smartgwt.client.rpc.RPCManager#loadScreen loadScreen()} for the meaning of the <code>locale</code> parameter. <p>
     * Calling <code>cacheScreens</code> twice with the same screenName will re-load the definition of that screen from the
     * server such that subsequent calls to <code>createScreen()</code> will use the new definition.
     * @param screenName name of the screens to cache
     * @param callback callback for notification of screens being successfully cached
     */
    public static native void cacheScreens(String[] screenName, Function callback) /*-{
        $wnd.isc.RPCManager.cacheScreens(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(screenName), 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.core.Function::execute()(
				);
			}));
    }-*/;

    /**
     * @see RPCManager#cacheScreens
     */
    public static void cacheScreens(String[] screenName, Function callback, String locale){
        cacheScreens(screenName, callback, locale, null);
    }

	/**
     * Loads the definitions of a set of screens saved in {@link com.smartgwt.client.docs.ComponentXML Component XML} format,
     * using the {@link com.smartgwt.client.docs.ServletDetails ScreenLoaderServlet}. <p> Unlike {@link
     * com.smartgwt.client.rpc.RPCManager#loadScreen loadScreen()}, <code>cacheScreens()</code> does not cause any UI
     * components to be created or drawn, it just loads the definitions of the screens.  This allows a subsequent, synchronous
     * call to {@link com.smartgwt.client.rpc.RPCManager#createScreen createScreen()} to create the actual screen, rather than
     * contacting the <code>ScreenLoader</code> servlet and showing a loading message. <p> See {@link
     * com.smartgwt.client.rpc.RPCManager#loadScreen loadScreen()} for the meaning of the <code>locale</code> parameter. <p>
     * Calling <code>cacheScreens</code> twice with the same screenName will re-load the definition of that screen from the
     * server such that subsequent calls to <code>createScreen()</code> will use the new definition.
     * @param screenName name of the screens to cache
     * @param callback callback for notification of screens being successfully cached
     * @param locale The name of a locale to use for resolving i18n tags in the                          component XML of the screen
     * @param requestProperties optional properties for the request
     */
    public static native void cacheScreens(String[] screenName, Function callback, String locale, RPCRequest requestProperties) /*-{
        $wnd.isc.RPCManager.cacheScreens(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(screenName), 
			$entry( function() { 
				if(callback!=null) callback.@com.smartgwt.client.core.Function::execute()(
				);
			}), locale, requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	

	/**
     * Cancel a queue of requests (also called a transaction). <P> If a transactionId is passed, that transaction will be
     * cancelled, otherwise, the current  (not yet sent) transaction is cancelled.  You can retrieve the id of the current 
     * transaction, if there is one, by calling  {@link com.smartgwt.client.rpc.RPCManager#getQueueTransactionId
     * getQueueTransactionId()} before the transaction has been sent. <P> Note that cancelQueue() calls {@link
     * com.smartgwt.client.rpc.RPCManager#clearTransaction clearTransaction()} and attempts to abort the request.  However,
     * note also that whilst cancelling a  transaction that has already been sent will not necessarily stop the HTTP request
     * that  has been issued - this is only possible on some browsers and with some transports - it  will reliably cause Smart
     * GWT to ignore any response returned by the server and not  fire any callbacks that have been passed in. <P> Also, take
     * into account that this method removes all queued requests from the current queue, but queueing is still active, so if
     * you also want to disable queuing you should call {@link com.smartgwt.client.rpc.RPCManager#startQueue
     * startQueue(false)}.
     */
    public static native void cancelQueue() /*-{
        $wnd.isc.RPCManager.cancelQueue();
    }-*/;

	/**
     * Cancel a queue of requests (also called a transaction). <P> If a transactionId is passed, that transaction will be
     * cancelled, otherwise, the current  (not yet sent) transaction is cancelled.  You can retrieve the id of the current 
     * transaction, if there is one, by calling  {@link com.smartgwt.client.rpc.RPCManager#getQueueTransactionId
     * getQueueTransactionId()} before the transaction has been sent. <P> Note that cancelQueue() calls {@link
     * com.smartgwt.client.rpc.RPCManager#clearTransaction clearTransaction()} and attempts to abort the request.  However,
     * note also that whilst cancelling a  transaction that has already been sent will not necessarily stop the HTTP request
     * that  has been issued - this is only possible on some browsers and with some transports - it  will reliably cause Smart
     * GWT to ignore any response returned by the server and not  fire any callbacks that have been passed in. <P> Also, take
     * into account that this method removes all queued requests from the current queue, but queueing is still active, so if
     * you also want to disable queuing you should call {@link com.smartgwt.client.rpc.RPCManager#startQueue
     * startQueue(false)}.
     * @param transactionNum transactionId of the queue.
     */
    public static native void cancelQueue(int transactionNum) /*-{
        $wnd.isc.RPCManager.cancelQueue(transactionNum);
    }-*/;
	

	/**
     * Erase all client-side record of a transaction, such that any response from the server will be ignored. <P> A transaction
     * means a batch of one or more RPCRequests that have already been sent to the server via {@link
     * com.smartgwt.client.rpc.RPCManager#sendQueue sendQueue()}. <P> You can retrieve the id of the current transaction, if
     * there is one, by  {@link com.smartgwt.client.rpc.RPCManager#getQueueTransactionId getQueueTransactionId()} before the 
     * transaction is sent.
     * @param transactionNum id of the transaction to be cleared
     */
    public static native void clearTransaction(int transactionNum) /*-{
        $wnd.isc.RPCManager.clearTransaction(transactionNum);
    }-*/;



	/**
     * Exports the printable representation of a set of widgets as a .pdf that is then
     *  downloaded to the user (triggering the "Save As.." dialog).
     *  <p>
     *  As with other exports, the resulting file can be 
     *  {@link com.smartgwt.client.data.DSRequest#getExportToFilesystem saved to the server filesystem} instead of, or in
     *  addition to being downloaded to the user.  See server-side docs for
     *  com.isomorphic.contentexport.PdfExport for more details on server-side processing and
     *  code samples for redirecting PDF output to a file or in-memory buffer, as well as
     *  instructions for adding additional stylesheets.
     *  <P>
     *  You can either pass any <code>Canvas</code> to <code>exportContent</code>, or you can
     * pass HTML that you have retrieved by calling {@link com.smartgwt.client.widgets.Canvas#getPrintHTML
     * Canvas.getPrintHTML()}.  When 
     *  calling <code>getPrintHTML()</code> to retrieve HTML for use with
     * <code>exportContent()</code>, you must pass the {@link com.smartgwt.client.util.PrintProperties#getPrintForExport
     * PrintProperties.printForExport} 
     * or {@link com.smartgwt.client.widgets.drawing.DrawPane} and {@link com.smartgwt.client.widgets.chart.FacetChart}
     * instances will not export properly.
     *  <P>
     *  You can use a custom skin when exporting your HTML content. To use a custom skin,
     *  add a line to {@link com.smartgwt.client.docs.Server_properties server.properties}:
     *  <pre>
     *    skin.{skinName}.location: custom/skin
     *  </pre>
     *  Where {skinName} is the name of your custom skin, and the value is the path to your 
     *  skin resources from the application webroot.
     *  <P>
     *  Requires the Smart GWT server framework, but does not require use of server-based
     *  databinding - no .ds.xml files need to exist.
     *  <P> 
     *  You can also inject a small amount of CSS from the browser via
     * {@link com.smartgwt.client.data.DSRequest#getExportCSS DSRequest.exportCSS} - this is intended primarily for switching
     * the page size on
     *  the fly, for exceptionally wide or tall exports.
     * 
     * 
     * @param canvas Canvas or canvas list that has exportable widgets,                    or an HTML fragment derived from {@link
     * com.smartgwt.client.widgets.Canvas#getPrintHTML getPrintHTML()}
     * 
     */
    public static native void exportContent(Canvas canvas) /*-{
        $wnd.isc.RPCManager.exportContent(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Exports the printable representation of a set of widgets as a .pdf that is then
     *  downloaded to the user (triggering the "Save As.." dialog).
     *  <p>
     *  As with other exports, the resulting file can be 
     *  {@link com.smartgwt.client.data.DSRequest#getExportToFilesystem saved to the server filesystem} instead of, or in
     *  addition to being downloaded to the user.  See server-side docs for
     *  com.isomorphic.contentexport.PdfExport for more details on server-side processing and
     *  code samples for redirecting PDF output to a file or in-memory buffer, as well as
     *  instructions for adding additional stylesheets.
     *  <P>
     *  You can either pass any <code>Canvas</code> to <code>exportContent</code>, or you can
     * pass HTML that you have retrieved by calling {@link com.smartgwt.client.widgets.Canvas#getPrintHTML
     * Canvas.getPrintHTML()}.  When 
     *  calling <code>getPrintHTML()</code> to retrieve HTML for use with
     * <code>exportContent()</code>, you must pass the {@link com.smartgwt.client.util.PrintProperties#getPrintForExport
     * PrintProperties.printForExport} 
     * or {@link com.smartgwt.client.widgets.drawing.DrawPane} and {@link com.smartgwt.client.widgets.chart.FacetChart}
     * instances will not export properly.
     *  <P>
     *  You can use a custom skin when exporting your HTML content. To use a custom skin,
     *  add a line to {@link com.smartgwt.client.docs.Server_properties server.properties}:
     *  <pre>
     *    skin.{skinName}.location: custom/skin
     *  </pre>
     *  Where {skinName} is the name of your custom skin, and the value is the path to your 
     *  skin resources from the application webroot.
     *  <P>
     *  Requires the Smart GWT server framework, but does not require use of server-based
     *  databinding - no .ds.xml files need to exist.
     *  <P> 
     *  You can also inject a small amount of CSS from the browser via
     * {@link com.smartgwt.client.data.DSRequest#getExportCSS DSRequest.exportCSS} - this is intended primarily for switching
     * the page size on
     *  the fly, for exceptionally wide or tall exports.
     * 
     * 
     * @param canvas Canvas or canvas list that has exportable widgets,                    or an HTML fragment derived from {@link
     * com.smartgwt.client.widgets.Canvas#getPrintHTML getPrintHTML()}
     * 
     */
    public static native void exportContent(Canvas[] canvas) /*-{
        $wnd.isc.RPCManager.exportContent(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(canvas));
    }-*/;

	/**
     * Exports the printable representation of a set of widgets as a .pdf that is then
     *  downloaded to the user (triggering the "Save As.." dialog).
     *  <p>
     *  As with other exports, the resulting file can be 
     *  {@link com.smartgwt.client.data.DSRequest#getExportToFilesystem saved to the server filesystem} instead of, or in
     *  addition to being downloaded to the user.  See server-side docs for
     *  com.isomorphic.contentexport.PdfExport for more details on server-side processing and
     *  code samples for redirecting PDF output to a file or in-memory buffer, as well as
     *  instructions for adding additional stylesheets.
     *  <P>
     *  You can either pass any <code>Canvas</code> to <code>exportContent</code>, or you can
     * pass HTML that you have retrieved by calling {@link com.smartgwt.client.widgets.Canvas#getPrintHTML
     * Canvas.getPrintHTML()}.  When 
     *  calling <code>getPrintHTML()</code> to retrieve HTML for use with
     * <code>exportContent()</code>, you must pass the {@link com.smartgwt.client.util.PrintProperties#getPrintForExport
     * PrintProperties.printForExport} 
     * or {@link com.smartgwt.client.widgets.drawing.DrawPane} and {@link com.smartgwt.client.widgets.chart.FacetChart}
     * instances will not export properly.
     *  <P>
     *  You can use a custom skin when exporting your HTML content. To use a custom skin,
     *  add a line to {@link com.smartgwt.client.docs.Server_properties server.properties}:
     *  <pre>
     *    skin.{skinName}.location: custom/skin
     *  </pre>
     *  Where {skinName} is the name of your custom skin, and the value is the path to your 
     *  skin resources from the application webroot.
     *  <P>
     *  Requires the Smart GWT server framework, but does not require use of server-based
     *  databinding - no .ds.xml files need to exist.
     *  <P> 
     *  You can also inject a small amount of CSS from the browser via
     * {@link com.smartgwt.client.data.DSRequest#getExportCSS DSRequest.exportCSS} - this is intended primarily for switching
     * the page size on
     *  the fly, for exceptionally wide or tall exports.
     * 
     * 
     * @param canvas Canvas or canvas list that has exportable widgets,                    or an HTML fragment derived from {@link
     * com.smartgwt.client.widgets.Canvas#getPrintHTML getPrintHTML()}
     * @see com.smartgwt.client.docs.HTMLString HTMLString
     * 
     */
    public static native void exportContent(String canvas) /*-{
        $wnd.isc.RPCManager.exportContent(canvas);
    }-*/;

	/**
     * Exports the printable representation of a set of widgets as a .pdf that is then
     *  downloaded to the user (triggering the "Save As.." dialog).
     *  <p>
     *  As with other exports, the resulting file can be 
     *  {@link com.smartgwt.client.data.DSRequest#getExportToFilesystem saved to the server filesystem} instead of, or in
     *  addition to being downloaded to the user.  See server-side docs for
     *  com.isomorphic.contentexport.PdfExport for more details on server-side processing and
     *  code samples for redirecting PDF output to a file or in-memory buffer, as well as
     *  instructions for adding additional stylesheets.
     *  <P>
     *  You can either pass any <code>Canvas</code> to <code>exportContent</code>, or you can
     * pass HTML that you have retrieved by calling {@link com.smartgwt.client.widgets.Canvas#getPrintHTML
     * Canvas.getPrintHTML()}.  When 
     *  calling <code>getPrintHTML()</code> to retrieve HTML for use with
     * <code>exportContent()</code>, you must pass the {@link com.smartgwt.client.util.PrintProperties#getPrintForExport
     * PrintProperties.printForExport} 
     * or {@link com.smartgwt.client.widgets.drawing.DrawPane} and {@link com.smartgwt.client.widgets.chart.FacetChart}
     * instances will not export properly.
     *  <P>
     *  You can use a custom skin when exporting your HTML content. To use a custom skin,
     *  add a line to {@link com.smartgwt.client.docs.Server_properties server.properties}:
     *  <pre>
     *    skin.{skinName}.location: custom/skin
     *  </pre>
     *  Where {skinName} is the name of your custom skin, and the value is the path to your 
     *  skin resources from the application webroot.
     *  <P>
     *  Requires the Smart GWT server framework, but does not require use of server-based
     *  databinding - no .ds.xml files need to exist.
     *  <P> 
     *  You can also inject a small amount of CSS from the browser via
     * {@link com.smartgwt.client.data.DSRequest#getExportCSS DSRequest.exportCSS} - this is intended primarily for switching
     * the page size on
     *  the fly, for exceptionally wide or tall exports.
     * 
     * 
     * @param canvas Canvas or canvas list that has exportable widgets,                    or an HTML fragment derived from {@link
     * com.smartgwt.client.widgets.Canvas#getPrintHTML getPrintHTML()}
     * @param requestProperties Request properties for the export to pdf object
     * 
     */
    public static native void exportContent(Canvas canvas, DSRequest requestProperties) /*-{
        $wnd.isc.RPCManager.exportContent(canvas == null ? null : canvas.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	



	/**
     * Returns the id of the current transaction (a queue of requests). <P> This method will return null if no requests are
     * currently queued, even if {@link com.smartgwt.client.rpc.RPCManager#startQueue startQueue()} has been called.
     *
     * @return the transactionNum of the current transaction, or null
     */
    public static native Integer getQueueTransactionId() /*-{
        var ret = $wnd.isc.RPCManager.getQueueTransactionId();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;



    /**
     * <code>handleError()</code> will be called if {@link com.smartgwt.client.rpc.RPCResponse#getStatus RPCResponse.status} is
     * negative and {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError RPCRequest.willHandleError} was not set.  It
     * is called for both {@link com.smartgwt.client.data.DSResponse}s and {@link com.smartgwt.client.rpc.RPCResponse}s that
     * have a non-success status.  You can check whether the response is a DSResponse by checking
     * <code>response.isDSResponse</code>. <p> By default <code>handleError()</code> always logs a warning.  In addition, if
     * {@link com.smartgwt.client.rpc.RPCResponse#getData response.data} was set to a String, a warning dialog will be shown to
     * the user with response.data as the message, which allows the server to send user error messages back without writing
     * custom client-side error handling. <p> To do custom error handling that is specific to a particular component or type of
     * request, set {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError RPCRequest.willHandleError} and deal with
     * errors in the rpcRequest.callback.  To change the default system-wide error handling,    install a {@link
     * com.smartgwt.client.rpc.RPCManager#getHandleErrorCallback HandleErrorCallback} with this method.  To invoke the default
     * error handling in your new handler, you can simply call the method {@link
     * com.smartgwt.client.rpc.RPCManager#runDefaultErrorHandling runDefaultErrorHandling()}. <p> If you're using the
     * xmlHttpRequest {@link com.smartgwt.client.rpc.RPCRequest#getTransport RPCRequest.transport}, you can access the  <a
     * href='http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html' target='_blank'>HTTP status code</a> of the response (eg
     * 404 Not Found or 500 Server Error) as {@link com.smartgwt.client.rpc.RPCResponse#getHttpResponseCode
     * RPCResponse.httpResponseCode}. <P> For very advanced usage, the response.xmlHttpRequest contains the native
     * XMLHttpRequest object used to make the request.  This can be accessed via {@link
     * com.smartgwt.client.data.DSResponse#getAttributeAsJavaScriptObject DSResponse.getAttributeAsJavaScriptObject()}. 
     * Accessing this object is subject to possible cross-platform bugs and inconsistencies, and Isomorphic recommends that you
     * wrap any access to the XMLHttpRequest object in a try/catch block because some browsers may throw exceptions when
     * certain attributes of this object are accessed.  For example, if you try to access XMLHttpRequest.status (for the HTTP
     * status code) when the network cable  is unpluged in Windows, you'll get an Exception in Firefox. <P> See the {@link
     * com.smartgwt.client.docs.ErrorHandling overview of error handling} for additional guidance.
     * 
     * @param callback HandleErrorCallback the callback to set.
     * @see com.smartgwt.client.data.events.ErrorEvent
     * @see com.smartgwt.client.rpc.HandleTransportErrorCallback#handleTransportError
     * @see com.smartgwt.client.rpc.RPCManager#runDefaultErrorHandling
     */
	public static native void setHandleErrorCallback(HandleErrorCallback callback) /*-{
        $wnd.isc.RPCManager.addClassProperties({
        	handleError:
			$entry( function(response, request) { 
				if(callback!=null) callback.@com.smartgwt.client.rpc.HandleErrorCallback::handleError(Lcom/smartgwt/client/data/DSResponse;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response), 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request)
				);
			})
        });
	}-*/;


	/**
     * Returns true if there is a current transaction (queue of requests) <P> This method will return false if no requests are
     * currently queued, even if {@link com.smartgwt.client.rpc.RPCManager#startQueue startQueue()} has been called.
     *
     * @return true if there is a current transaction
     */
    public static native Boolean hasCurrentTransactionQueued() /*-{
        var ret = $wnd.isc.RPCManager.hasCurrentTransactionQueued();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;




    /**
     * Called when a session timeout is encountered while trying to do a background RPC.  See {@link
     * com.smartgwt.client.docs.Relogin Relogin}. <P> The transaction with the passed <code>transactionId</code> is suspended,
     * and should either be {@link com.smartgwt.client.rpc.RPCManager#clearTransaction cleared} or {@link
     * com.smartgwt.client.rpc.RPCManager#resendTransaction resent} after the user has been re-authenticated.   <P> The
     * <code>rpcRequest</code> parameter can be used to determine whether the suspended transaction can simply be dropped (eg,
     * it's periodic polling request). <P> The <code>rpcResponse</code> parameter has rpcResponse.data set to the raw text of
     * the response that triggered <code>loginRequired()</code>.  Some very advanced relogin strategies may need to inspect the
     * raw response to get information needed for re-authentication.
     * 
     * @param callback LoginRequiredCallback the callback to set.
     */
	public static native void setLoginRequiredCallback(LoginRequiredCallback callback) /*-{
        $wnd.isc.RPCManager.addClassProperties({
        	loginRequired:
			$entry( function(transactionNum, rpcRequest, rpcResponse) { 
				if(callback!=null) callback.@com.smartgwt.client.rpc.LoginRequiredCallback::loginRequired(ILcom/smartgwt/client/rpc/RPCRequest;Lcom/smartgwt/client/rpc/RPCResponse;)(
					transactionNum, 
					@com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest), 
					@com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse)
				);
			})
        });
	}-*/;


    /**
     * This method is called by the RPCManager every time it sends a queue of requests to the server (note that if you are not
     * using queuing, the system simply sends queues containing just one request, so this API is valid regardless).<p> There is
     * no default implementation of this method; it is simply an override point.   It is intended to be used by user code that
     * needs to be notified when Smart GWT sends  requests to the server.  Note that the list of {@link
     * com.smartgwt.client.rpc.RPCRequest}s passed to this method is strictly <b>read-only</b>.
     * 
     * @param callback QueueSentCallback the callback to set.
     */
	public static native void setQueueSentCallback(QueueSentCallback callback) /*-{
        $wnd.isc.RPCManager.addClassProperties({
        	queueSent:
			$entry( function(response) { 
				if(callback!=null) callback.@com.smartgwt.client.rpc.QueueSentCallback::queueSent([Lcom/smartgwt/client/rpc/RPCRequest;)(@com.smartgwt.client.util.ConvertTo::arrayOfRPCRequest(Lcom/google/gwt/core/client/JavaScriptObject;)(response)
				);
			})
        });
	}-*/;

	/**
     * Returns whether there are any pending RPC requests. <P>
     *
     * @return true if one or more RPC requests are pending, false otherwise.
     */
    public static native Boolean requestsArePending() /*-{
        var ret = $wnd.isc.RPCManager.requestsArePending();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Resend a suspended transaction to the server.  See {@link com.smartgwt.client.rpc.RPCManager#suspendTransaction
     * suspendTransaction()} for context.   <P> Note that the transaction must have been previously suspended, and in
     * particular suspended validly according to the rules described in the docs for {@link
     * com.smartgwt.client.rpc.RPCManager#suspendTransaction suspendTransaction()}, or undefined results will occur. <P> You
     * can resend <b>all</b> suspended transactions by calling {@link com.smartgwt.client.rpc.RPCManager#resendTransaction
     * resendTransaction()} with no arguments.
     */
    public static native void resendTransaction() /*-{
        $wnd.isc.RPCManager.resendTransaction();
    }-*/;

	/**
     * Resend a suspended transaction to the server.  See {@link com.smartgwt.client.rpc.RPCManager#suspendTransaction
     * suspendTransaction()} for context.   <P> Note that the transaction must have been previously suspended, and in
     * particular suspended validly according to the rules described in the docs for {@link
     * com.smartgwt.client.rpc.RPCManager#suspendTransaction suspendTransaction()}, or undefined results will occur. <P> You
     * can resend <b>all</b> suspended transactions by calling {@link com.smartgwt.client.rpc.RPCManager#resendTransaction
     * resendTransaction()} with no arguments.
     * @param transactionNum id of the transaction to be re-sent, or null to resend all                              suspended transactions
     */
    public static native void resendTransaction(int transactionNum) /*-{
        $wnd.isc.RPCManager.resendTransaction(transactionNum);
    }-*/;
	

	/**
     * Runs the default error handling normally performed by {@link com.smartgwt.client.rpc.HandleErrorCallback#handleError
     * HandleErrorCallback.handleError()}.  May be called from a custom handler to achieve the default behavior if one has been
     * installed.
     * @param response response the response
     * @param request request the request
     * @see com.smartgwt.client.rpc.HandleErrorCallback#handleError
     */
    public static native void runDefaultErrorHandling(DSResponse response, DSRequest request) /*-{
        $wnd.isc.RPCManager.runDefaultErrorHandling(response.@com.smartgwt.client.core.DataClass::getJsObj()(), request.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;




	/**
     * Send all currently queued requests to the server.  You need only call this method if you are using queuing otherwise
     * your requests are synchronously submitted to the server. <P> This method will do nothing and the callback will not be
     * called if no requests have actually  been queued. You can detect whether the queue is empty by calling  {@link
     * com.smartgwt.client.rpc.RPCManager#getQueueTransactionId getQueueTransactionId()}. <P> NOTE: if you aren't the caller
     * who first enables queuing (startQueue() returns true), you should in general avoid calling sendQueue(), because whoever
     * was first to enable queuing may have more requests to add to the same queue. <P> See {@link
     * com.smartgwt.client.rpc.RPCManager#startQueue startQueue()} for more information about queuing.
     * @see com.smartgwt.client.rpc.RPCManager#send
     * @see com.smartgwt.client.rpc.RPCManager#sendRequest
     * @see com.smartgwt.client.rpc.RPCManager#startQueue
     */
    public static native void sendQueue() /*-{
        $wnd.isc.RPCManager.sendQueue();
    }-*/;

	/**
     * Send all currently queued requests to the server.  You need only call this method if you are using queuing otherwise
     * your requests are synchronously submitted to the server. <P> This method will do nothing and the callback will not be
     * called if no requests have actually  been queued. You can detect whether the queue is empty by calling  {@link
     * com.smartgwt.client.rpc.RPCManager#getQueueTransactionId getQueueTransactionId()}. <P> NOTE: if you aren't the caller
     * who first enables queuing (startQueue() returns true), you should in general avoid calling sendQueue(), because whoever
     * was first to enable queuing may have more requests to add to the same queue. <P> See {@link
     * com.smartgwt.client.rpc.RPCManager#startQueue startQueue()} for more information about queuing.
     * @param callback Callback to fire when the queued operations complete. Callback will be fired with 1 parameter: <code>responses</code> an
     * array of {@link com.smartgwt.client.data.DSResponse} or  {@link com.smartgwt.client.rpc.RPCResponse} objects that were
     * part of the transaction fired by this method.
     * @see com.smartgwt.client.rpc.RPCManager#send
     * @see com.smartgwt.client.rpc.RPCManager#sendRequest
     * @see com.smartgwt.client.rpc.RPCManager#startQueue
     */
    public static native void sendQueue(RPCQueueCallback callback) /*-{
        $wnd.isc.RPCManager.sendQueue(
			$entry( function(response) { 
				if(callback!=null) callback.@com.smartgwt.client.rpc.RPCQueueCallback::execute([Lcom/smartgwt/client/rpc/RPCResponse;)(@com.smartgwt.client.util.ConvertTo::arrayOfRPCResponse(Lcom/google/gwt/core/client/JavaScriptObject;)(response)
				);
			}));
    }-*/;
	



	/**
     * Start queuing {@link com.smartgwt.client.data.DSRequest DSRequests} and {@link com.smartgwt.client.rpc.RPCRequest
     * RPCRequests} system-wide, for later sending when RPCManager.sendQueue() is called, at which time all queued requests
     * will be sent as a single, combined HTTP request. <p> Combining requests via queuing: <ul> <li> allows the server to
     * implement transactional saving when multiple records are      affected by actions in the UI <li> can reduce overhead by
     * combining related requests, avoiding the use of multiple      network connections, redundant authentication checks, and
     * other redundant resource      allocations that would otherwise happen if requests were processed separately <li> can
     * simplify application logic that otherwise has to deal with multiple outstanding      server requests that might complete
     * in any order </ul> <p> Queuing is used automatically by many, many framework features, including multi-row grid editing
     * ({@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits Grid Mass Editing}),  <a
     * href="http://www.smartclient.com/smartgwt/showcase/#grid_db_dragging" target="examples">multi-row drag &amp; drop</a>, 
     * {@link com.smartgwt.client.widgets.tree.ResultTree#getFetchMode data paging for large trees},  {@link
     * com.smartgwt.client.types.ValidatorType "serverCustom" validators}, <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#transactions_queued_md" target="examples">Master-Detail saves</a>,
     * {@link com.smartgwt.client.widgets.cube.CubeGrid OLAP / datacube functionalty}, and many others.   <p> Queuing also has
     * subtler architectural benefits in terms of building reusable services - see the QuickStart Guide sections on Queuing for
     * details. <p> For all the reasons given above, it's extremely important to use DataSources that can support queuing. 
     * Queuing is automatically supported when using server-based DataSources with the Smart GWT Server Framework, and is
     * supported by {@link com.smartgwt.client.data.RestDataSource}.   <p> <b>Order of Execution</b> <p> When the Smart GWT
     * Server framework receives a queued request, it will process all requests, in order, in a single thread, before any
     * response is sent to the client.  All client-side actions related to queued requests, such as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData callbacks firing} on completion, likewise happen in queue order,
     * after all server-side processing has taken place. <p> Therefore when using queuing you can use the callback argument of
     * {@link com.smartgwt.client.rpc.RPCManager#sendQueue sendQueue()} to detect that all operations have completed, which is
     * much simpler than the logic needed to track multiple asynchronous operations and wait for all to complete. <p> <b>Nested
     * Queuing</b> <p> In some cases you may wish to combine requests being sent by application logic with queued requests
     * automatically sent by components.  For example, you may want to call  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#saveAllEdits ListGrid.saveAllEdits()} but also add an additional request to
     * the same queue. <p> To do this, just call <code>startQueue()</code> before <code>saveAllEdits()</code> (or whatever
     * other API would also normally perform a queued request), then call <code>sendQueue()</code>.  Framework features that
     * use queuing will automatically notice that you have already started a queue, and will not automatically call
     * <code>sendQueue()</code> in this case.  You can implement the same behavior in your own reusable components by checking
     * the return value of <code>startQueue()</code>, which tells you whether queuing is already active. <p> <b>Requests that
     * can't be queued</b> <p> When using queuing, all requests in a given queue must go to the same {@link
     * com.smartgwt.client.rpc.RPCRequest#getActionURL RPCRequest.actionURL} and use the same transport (XMLHttp or frames). 
     * If a request specifies a different actionURL or transport than that of the requests currently on the queue, it will be
     * sent to the server separately, ahead of the queue, and a warning will be logged to the Developer Console. <p>
     * <b>Implementing your own Queuing</b> <p> If you are in the rare situation that: <ul> <li> you can't use the Smart GWT
     * Server framework <li> the server you are integrating with some pre-existing support for combining      operations in a
     * flexible way, similar to queuing <li> you are totally unable to implement the RestDataSource protocol for this server,  
     * even through approaches such as adding it as an additional service while leaving      the original services unchanged,
     * or going through an intermediate server </ul> .. then you can implement a crude version of the built-in queuing feature
     * by using {@link com.smartgwt.client.data.DataSource#getDataProtocol dataProtocol:"clientCustom"} to avoid HTTP requests
     * being immediately sent when a DataSource executes.  In outline: <ul> <li> create an API similar to
     * <code>startQueue()</code> for managing a global setting      reflecting whether your special queuing system is active. 
     * Your DataSources should      check for this global setting in {@link
     * com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest()}, and, if      queuing is active,
     * store the request you received in      {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest()} in memory, for example in an Array <li> implement your own equivalent of
     * <code>RPCManager.sendQueue()</code> which sends an      HTTP request representing your combined requests, then once you
     * receive your      combined response, call {@link com.smartgwt.client.data.DataSource#processResponse
     * DataSource.processResponse()} for each request. </ul> Note that attempting to integrate with <code>RPCManager</code>'s
     * queuing system doesn't really make sense - <code>RPCManager</code> won't be aware of your separate, special queue of
     * requests, so will reject calls to <code>sendQueue()</code> since RPCManager's queue is empty.  Similarly, enabling
     * queuing on <code>RPCManager</code> may cause inadvertent queuing of unrelated requests you did not intend to queue. 
     * Maintaining your own separate notion of whether queuing is active is simpler and less error prone.
     *
     * @return whether queuing was already enabled before we called.
     * @see com.smartgwt.client.rpc.RPCManager#sendQueue
     */
    public static native boolean startQueue() /*-{
        var ret = $wnd.isc.RPCManager.startQueue();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Start queuing {@link com.smartgwt.client.data.DSRequest DSRequests} and {@link com.smartgwt.client.rpc.RPCRequest
     * RPCRequests} system-wide, for later sending when RPCManager.sendQueue() is called, at which time all queued requests
     * will be sent as a single, combined HTTP request. <p> Combining requests via queuing: <ul> <li> allows the server to
     * implement transactional saving when multiple records are      affected by actions in the UI <li> can reduce overhead by
     * combining related requests, avoiding the use of multiple      network connections, redundant authentication checks, and
     * other redundant resource      allocations that would otherwise happen if requests were processed separately <li> can
     * simplify application logic that otherwise has to deal with multiple outstanding      server requests that might complete
     * in any order </ul> <p> Queuing is used automatically by many, many framework features, including multi-row grid editing
     * ({@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits Grid Mass Editing}),  <a
     * href="http://www.smartclient.com/smartgwt/showcase/#grid_db_dragging" target="examples">multi-row drag &amp; drop</a>, 
     * {@link com.smartgwt.client.widgets.tree.ResultTree#getFetchMode data paging for large trees},  {@link
     * com.smartgwt.client.types.ValidatorType "serverCustom" validators}, <a
     * href="http://www.smartclient.com/smartgwtee/showcase/#transactions_queued_md" target="examples">Master-Detail saves</a>,
     * {@link com.smartgwt.client.widgets.cube.CubeGrid OLAP / datacube functionalty}, and many others.   <p> Queuing also has
     * subtler architectural benefits in terms of building reusable services - see the QuickStart Guide sections on Queuing for
     * details. <p> For all the reasons given above, it's extremely important to use DataSources that can support queuing. 
     * Queuing is automatically supported when using server-based DataSources with the Smart GWT Server Framework, and is
     * supported by {@link com.smartgwt.client.data.RestDataSource}.   <p> <b>Order of Execution</b> <p> When the Smart GWT
     * Server framework receives a queued request, it will process all requests, in order, in a single thread, before any
     * response is sent to the client.  All client-side actions related to queued requests, such as {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchData callbacks firing} on completion, likewise happen in queue order,
     * after all server-side processing has taken place. <p> Therefore when using queuing you can use the callback argument of
     * {@link com.smartgwt.client.rpc.RPCManager#sendQueue sendQueue()} to detect that all operations have completed, which is
     * much simpler than the logic needed to track multiple asynchronous operations and wait for all to complete. <p> <b>Nested
     * Queuing</b> <p> In some cases you may wish to combine requests being sent by application logic with queued requests
     * automatically sent by components.  For example, you may want to call  {@link
     * com.smartgwt.client.widgets.grid.ListGrid#saveAllEdits ListGrid.saveAllEdits()} but also add an additional request to
     * the same queue. <p> To do this, just call <code>startQueue()</code> before <code>saveAllEdits()</code> (or whatever
     * other API would also normally perform a queued request), then call <code>sendQueue()</code>.  Framework features that
     * use queuing will automatically notice that you have already started a queue, and will not automatically call
     * <code>sendQueue()</code> in this case.  You can implement the same behavior in your own reusable components by checking
     * the return value of <code>startQueue()</code>, which tells you whether queuing is already active. <p> <b>Requests that
     * can't be queued</b> <p> When using queuing, all requests in a given queue must go to the same {@link
     * com.smartgwt.client.rpc.RPCRequest#getActionURL RPCRequest.actionURL} and use the same transport (XMLHttp or frames). 
     * If a request specifies a different actionURL or transport than that of the requests currently on the queue, it will be
     * sent to the server separately, ahead of the queue, and a warning will be logged to the Developer Console. <p>
     * <b>Implementing your own Queuing</b> <p> If you are in the rare situation that: <ul> <li> you can't use the Smart GWT
     * Server framework <li> the server you are integrating with some pre-existing support for combining      operations in a
     * flexible way, similar to queuing <li> you are totally unable to implement the RestDataSource protocol for this server,  
     * even through approaches such as adding it as an additional service while leaving      the original services unchanged,
     * or going through an intermediate server </ul> .. then you can implement a crude version of the built-in queuing feature
     * by using {@link com.smartgwt.client.data.DataSource#getDataProtocol dataProtocol:"clientCustom"} to avoid HTTP requests
     * being immediately sent when a DataSource executes.  In outline: <ul> <li> create an API similar to
     * <code>startQueue()</code> for managing a global setting      reflecting whether your special queuing system is active. 
     * Your DataSources should      check for this global setting in {@link
     * com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest()}, and, if      queuing is active,
     * store the request you received in      {@link com.smartgwt.client.data.DataSource#transformRequest
     * DataSource.transformRequest()} in memory, for example in an Array <li> implement your own equivalent of
     * <code>RPCManager.sendQueue()</code> which sends an      HTTP request representing your combined requests, then once you
     * receive your      combined response, call {@link com.smartgwt.client.data.DataSource#processResponse
     * DataSource.processResponse()} for each request. </ul> Note that attempting to integrate with <code>RPCManager</code>'s
     * queuing system doesn't really make sense - <code>RPCManager</code> won't be aware of your separate, special queue of
     * requests, so will reject calls to <code>sendQueue()</code> since RPCManager's queue is empty.  Similarly, enabling
     * queuing on <code>RPCManager</code> may cause inadvertent queuing of unrelated requests you did not intend to queue. 
     * Maintaining your own separate notion of whether queuing is active is simpler and less error prone.
     * @param shouldQueue whether queuing should be enabled, default true.  Passing false                      will disable queuing but not send
     * the queue yet, so that any                      queued requests will be sent along with the next                     
     * send()/sendRequest()
     *
     * @return whether queuing was already enabled before we called.
     * @see com.smartgwt.client.rpc.RPCManager#sendQueue
     */
    public static native boolean startQueue(boolean shouldQueue) /*-{
        var ret = $wnd.isc.RPCManager.startQueue(shouldQueue);
        return ret == null ? false : ret;
    }-*/;
	


	/**
     * Returns true if the XMLHttpRequest object is available, false otherwise.  See {@link
     * com.smartgwt.client.docs.PlatformDependencies} for more information on when XMLHttpRequest parser may not available and
     * what features are impacted as a result.
     *
     * @return true if XMLHttpRequest is available, false otherwise.
     */
    public static native Boolean xmlHttpRequestAvailable() /*-{
        var ret = $wnd.isc.RPCManager.xmlHttpRequestAvailable();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


    // ***********************************************************


    /**
     * Get the marker the system will look for in order to detect when the number of maximum logins was exceeded.
     * 
     * @see com.smartgwt.client.rpc.RPCManager#setLoginRequiredMarker()
     * @note The default value for the marker is <b><&lt;SCRIPT&gt;//'\&quot;]]&gt;&gt;isc_maxLoginAttemptsExceeded</b>
     */
    public static native void getMaxLoginAttemptsExceededMarker() /*-{
        return $wnd.isc.RPCManager.maxLoginAttemptsExceededMarker;        
    }-*/;

    /**
     * Set the marker the system will look for in order to detect when the number of maximum logins was exceeded.
     *
     * @see com.smartgwt.client.rpc.RPCManager#setLoginRequiredMarker()
     * @param loginSuccessMarker default value <b>&lt;SCRIPT&gt;//'\&quot;]]&gt;&gt;isc_maxLoginAttemptsExceeded</b>
     */
    public static native String setMaxLoginAttemptsExceededMarker(String maxLoginAttemptsExceededMarker) /*-{
        $wnd.isc.RPCManager.maxLoginAttemptsExceededMarker = maxLoginAttemptsExceededMarker;
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
     * More targeted default prompts are also supported for certain code-paths. See the following set of
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
     * Default prompt displayed to user while an operation is running to remove data from the server.
     * Displayed as a result of the ListGrid.removeSelectedData() code path.
     *
     * @param removeDataPrompt default value "Deleting Record(s)..."
     */
    public static native void setRemoveDataPrompt(String removeDataPrompt) /*-{
        @com.smartgwt.client.util.I18nUtil::init()();
        $wnd.isc.RPCManager.removeDataPrompt = removeDataPrompt;
    }-*/;

    /**
     * Default prompt displayed to the user while an operation is running to save data to the server.
     * Displayed as a result of the DynamicForm.saveData() code path.
     *
     * @param saveDataPrompt default value "Saving form..."
     */
    public static native void setSaveDataPrompt(String saveDataPrompt) /*-{
        @com.smartgwt.client.util.I18nUtil::init()();
        $wnd.isc.RPCManager.saveDataPrompt = saveDataPrompt;
    }-*/;

    /**
     * Controls the default cursor shown when RPCManager.promptStyle is set to "cursor". Overridable by RPCRequest.promptCursor.
     * In Safari, IE 5.5 and Firefox 1.0 the default value is "wait", on all other platforms it is "progress". The reason for this split is that the above-mentioned browsers do not support CSS2.1 - which is required for the "progress" cursor type.
     *
     * @param promptCursor default is browser dependent
     */
    public static native void setPromptCursor(String promptCursor) /*-{
        $wnd.isc.RPCManager.promptCursor = promptCursor;
    }-*/;

    /**
     * Controls the default prompt style. Overridable by RPCRequest.promptStyle.
     *
     * @param promptStyle default is {@link com.smartgwt.client.types.PromptStyle#DIALOG}
     */
    public static native void setPromptStyle(PromptStyle promptStyle) /*-{
        $wnd.isc.RPCManager.addClassProperties({ promptStyle: promptStyle.@com.smartgwt.client.types.PromptStyle::getValue()() });
    }-*/;

    /**
     * If true, an image is shown to the right of the cursor when RPCRequest.promptStyle is set to "cursor", otherwise the cursor itself is modified via css to the value of RPCRequest.promptCursor. The default is platform-dependent. In Safari, IE 5.5 and Firefox 1.0 the default is true, on all other platforms it is false. The reason for this split is that, the above browsers require that the cursor move before CSS settings are re-evaluated - this means the progress cursor can stick until the user moves the mouse.
     * <p/>
     * This value can be overridden on a per-request basis via RPCRequest.useCursorTracker.
     *
     * @param useCursorTracking default value is platform-dependent
     */
    public static native void setUseCursorTracking(boolean useCursorTracking) /*-{
        $wnd.isc.RPCManager.useCursorTracking = useCursorTracking;
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
     * @deprecated  please use int methods when dealing with transaction number. 
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
     * @deprecated  please use int methods when dealing with transaction number. 
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
     * @param transactionNum id of the transaction to be re-sent, or null to resend all suspended transactions
     * @deprecated  please use int methods when dealing with transaction number. 
     */
    public static native void resendTransaction(String transactionNum) /*-{
        $wnd.isc.RPCManager.resendTransaction(transactionNum);
    }-*/;

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
     * @deprecated please use int methods when dealing with transaction number. 
     */
    public static native void suspendTransaction(String transactionID) /*-{
        $wnd.isc.RPCManager.suspendTransaction(transactionID);
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
    public static native void suspendTransaction(int transactionID) /*-{
        $wnd.isc.RPCManager.suspendTransaction(transactionID);
    }-*/;

    /**
     * Returns the id of the current transaction (a queue of requests). <P> This method must be called after startQueue() has
     * been called and at least one request has been issued.
     *
     * @return the transactionNum of the current transaction.
     * @deprecated please use int methods when dealing with transaction number. 
     */
    public static native String getCurrentTransactionId() /*-{
        return $wnd.isc.RPCManager.getQueueTransactionId().toString();
    }-*/;
    
    /**
     * Same as getQueueTransactionId() but returns <code>-1</code> instead of <code>null</code> 
     * if there's no currently queued requests.
     *
     * @return the transactionNum of the current transaction.
     */
    public static native int getCurrentTransactionIdAsInt() /*-{
        var transactionId = $wnd.isc.RPCManager.getCurrentTransactionId();
        return (transactionId == null) ? -1 : transactionId;
    }-*/;

    /**
     * Send an HTTP request to a remote host, potentially through the HttpProxy servlet installed on the Smart GWT Server. <P>
     * This API allows contacting services which are hosted on servers other than the origin server if the HttpProxy servlet is
     * enabled on the Smart GWT Server. <P> The HttpProxy will be used if the {@link
     * com.smartgwt.client.rpc.RPCRequest#getActionURL actionURL} starts with "http" and uses a hostname other than "localhost"
     * or <code>window.location.hostname</code>, or if the port number differs, or if <code>request.useHttpProxy</code> is
     * explicitly set.  Otherwise the request goes to the origin server (the server that returned the current page). <P> The
     * {@link com.smartgwt.client.rpc.RPCRequest} properties that will be respected when relaying requests via the HttpProxy
     * are:  {@link com.smartgwt.client.rpc.RPCRequest#getActionURL actionURL}, {@link
     * com.smartgwt.client.rpc.RPCRequest#getHttpMethod httpMethod},  {@link com.smartgwt.client.rpc.RPCRequest#getParams
     * params}, {@link com.smartgwt.client.rpc.RPCRequest#getContentType contentType},  {@link
     * com.smartgwt.client.rpc.RPCRequest#getHttpHeaders httpHeaders}, and {@link com.smartgwt.client.rpc.RPCRequest#getData
     * data}.  In this case "data", if set, will be used as the request body for an HTTP POST. <P> Higher-level APIs like
     * {@link com.smartgwt.client.data.DataSource} or {@link com.smartgwt.client.data.WebService} call through this API, and so
     * automatically use the HttpProxy if {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} or {@link
     * com.smartgwt.client.data.WebService#setLocation webService.location} is set to a foreign server. <P> This API is only
     * suitable for direct use when loading unstructured data that will not be shown in a {@link
     * com.smartgwt.client.widgets.DataBoundComponent}.  For a WSDL-described web service, use {@link
     * com.smartgwt.client.data.XMLTools#loadWSDL XMLTools.loadWSDL} instead.  For other web services, use a {@link
     * com.smartgwt.client.data.DataSource} with {@link com.smartgwt.client.data.DataSource#getDataURL dataURL}, and use {@link
     * com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest} and {@link
     * com.smartgwt.client.data.DataSource#transformResponse DataSource.transformResponse} as necessary to form requests for
     * the service and transform responses for display.
     * @param request rpcRequest to be routed through the HttpProxy
     * @param callback callback to invoke on RPC completion
     */
    public static native void sendProxied(RPCRequest request, final RPCCallback callback) /*-{
        var rpcRequest = request.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (callback != null) {
            rpcRequest.callback = $entry(function (rpcResponse, data, rpcRequest) {
                var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
                var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest);
                callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(responseJ, data, requestJ);
            });
        }
        $wnd.isc.RPCManager.sendRequest(rpcRequest);
    }-*/;

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
        if (callback != null) {
            rpcRequest.callback = $entry(function (rpcResponse, data, rpcRequest) {
                var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
                var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest);
                callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(responseJ, data, requestJ);
            });
        }
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


    /**
     * Loads a screen saved in {@link com.smartgwt.client.docs.ComponentXML Component XML} format.
     * See {@link com.smartgwt.client.rpc.RPCManager#loadScreen(String, LoadScreenCallback, String[], String, RPCRequest)}
     * @param screenName name of the screen to load
     * @param callback callback for notification of screen being loaded
     */
    public static void loadScreen(String screenName, LoadScreenCallback callback) {
        loadScreen(screenName, callback, null, null);
    }

    /**
     * Loads a screen saved in {@link com.smartgwt.client.docs.ComponentXML Component XML} format.
     * See {@link com.smartgwt.client.rpc.RPCManager#loadScreen(String, LoadScreenCallback, String[], String, RPCRequest)}
     * @param screenName name of the screen to load
     * @param callback callback for notification of screen being loaded
     * @param globals widgets to allow to take their global IDs
     */
    public static void loadScreen(String screenName, LoadScreenCallback callback, String[] globals) {
        loadScreen(screenName, callback, globals, null);
    }

    /**
     * Loads a screen saved in {@link com.smartgwt.client.docs.ComponentXML Component XML} format.
     * See {@link com.smartgwt.client.rpc.RPCManager#loadScreen(String, LoadScreenCallback, String[], String, RPCRequest)}
     * @param screenName name of the screen to load
     * @param callback callback for notification of screen being loaded
     * @param globals widgets to allow to take their global IDs
     * @param requestProperties optional properties for the request
     */
    public static native void loadScreen(String screenName, LoadScreenCallback callback, String[] globals, RPCRequest requestProperties) /*-{
        var globalsJ = globals == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals);
        var requestPropertiesJ = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();

        $wnd.isc.RPCManager.loadScreen(screenName, $entry(function (screen,rpcResponse,suppressedGlobals) {
            if(callback != null) {
            	var screenJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(screen);
            	var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
                var suppressedGlobalsJ = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(suppressedGlobals);

				callback.@com.smartgwt.client.rpc.LoadScreenCallback::setSuppressedGlobals(Ljava/util/Map;)(suppressedGlobalsJ);
				callback.@com.smartgwt.client.rpc.LoadScreenCallback::setRpcResponse(Lcom/smartgwt/client/rpc/RPCResponse;)(responseJ);
				callback.@com.smartgwt.client.rpc.LoadScreenCallback::setScreen(Lcom/smartgwt/client/widgets/Canvas;)(screenJ);

                callback.@com.smartgwt.client.rpc.LoadScreenCallback::execute()();
            }
        }), globalsJ,
        // Pass in null as locale specifier. 
        null, requestPropertiesJ);
    }-*/;
    
    /**
     * Loads a screen saved in 
     * {@link com.smartgwt.client.docs.ComponentXML Component XML} format, using the
     * {@link com.smartgwt.client.docs.ServletDetails ScreenLoaderServlet}.
     * <P>
     * The ScreenLoaderServlet will look for a file named <i>screenName</i>.ui.xml in 
     * the directory given by the "project.ui" setting, which defaults
     * <i>webroot</i>/shared/ui and can be configured in server.properties.
     * <p>
     * The <code>screen</code> provided by the callback will be the outermost component if your
     * loaded screen consists of a hierarchy of widgets all contained under one parent (which
     * is true of any screens created in Visual Builder).  
     * <p>
     * If you have multiple widget hierarchies in your screen, the <code>screen</code> returned
     * will be the last top-level component created.
     * <P>
     * By default, components in the loaded screens that have 
     * {@link com.smartgwt.client.widgets.Canvas#getID() global IDs} will not
     * actually be allowed to take those global IDs - instead, only widgets that have one of the
     * global IDs passed as the <code>globals</code> parameter will actually receive their global
     * IDs.  To override this behavior, pass an array containing the special value 
     * {@link com.smartgwt.client.rpc.RPCManager#ALL_GLOBALS}
     * for the <code>globals</code> parameter.
     * <p>
     * When globals are being suppressed, the <code>screen</code> available in the callback
     * will provide access to widgets that did not receive their global IDs via
     * {@link com.smartgwt.client.widgets.Canvas#getByLocalId(String)},
     * and the <code>suppressedGlobals</code> available in the
     * callback will be a mapping from suppressed global ID to the widget or other component
     * that would have used that global ID if globals were not suppressed.
     * <p>
     * To load multiple screens at once, use 
     * {@link com.smartgwt.client.rpc.RPCManager#cacheScreens(String[], Function, String, RPCRequest)} and
     * {@link com.smartgwt.client.rpc.RPCManager#createScreen(String, String[])}
     * instead.
     * <P>
     * Components in the screen will default to having
     * {@link com.smartgwt.client.widgets.Canvas#setAutoDraw(Boolean)} set to false.
     * This may be overridden by setting the 
     * {@link com.smartgwt.client.rpc.RPCRequest#setSuppressAutoDraw(Boolean)} attribute
     * explicitly to <code>false</code> on the request properties object.
     * <P>
     * You can optionally provide a locale name to use when resolving any i18n tags in the 
     * screen's component XML.  If you do not supply this, the locale will be derived from 
     * the servlet API, and so will generally be a locale appropriate to the client's operating
     * system settings.  Only provide a locale manually if you have a special requirement that 
     * requires the user's operating system locale to be overridden in your application.  If 
     * you provide a locale name, it should be of the form "xx" or "xx_YY", where "xx" is a 
     * valid language code and "YY" is a valid country code.  For example, "fr" or "en_GB".
     * <P> 
     * This API assumes the ScreenLoaderServlet is installed at the default location - to use a
     * different location, use the <code>requestProperties</code> parameter to specify a different
     * URL via +link{rpcRequest.actionURL}.  The <code>requestProperties</code> parameter can also
     * be used to pass additional params to a custom ScreenLoaderServlet - see the "Dynamic
     * Component XML" section of the
     * {@link com.smartgwt.client.docs.ComponentXML Component XML overview}.     
     *   
     * @param screenName name of the screen to load
     * @param callback callback for notification of screen being loaded
     * @param globals widgets to allow to take their global IDs
     * @param locale the name of a locale to use for resolving i18n tags in the component XML of the screen
     * @param requestProperties optional properties for the request
     */
    public static native void loadScreen(String screenName, LoadScreenCallback callback, String[] globals, String locale, RPCRequest requestProperties) /*-{
        var globalsJ = globals == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals);
        var requestPropertiesJ = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();

        $wnd.isc.RPCManager.loadScreen(screenName, $entry(function (screen,rpcResponse,suppressedGlobals) {
            if(callback != null) {
                var screenJ= screen == null ? null : @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(screen.getClassName(),screen);
                var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
                var suppressedGlobalsJ = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(suppressedGlobals);

				callback.@com.smartgwt.client.rpc.LoadScreenCallback::setSuppressedGlobals(Ljava/util/Map;)(suppressedGlobalsJ);
				callback.@com.smartgwt.client.rpc.LoadScreenCallback::setRpcResponse(Lcom/smartgwt/client/rpc/RPCResponse;)(responseJ);
				callback.@com.smartgwt.client.rpc.LoadScreenCallback::setScreen(Lcom/smartgwt/client/widgets/Canvas;)(screenJ);

                callback.@com.smartgwt.client.rpc.LoadScreenCallback::execute()();
            }
        }), globalsJ,
        locale, requestPropertiesJ);
    }-*/;
    
    /**
     * ALL_GLOBALS constant used by the {@link com.smartgwt.client.rpc.RPCManager#loadScreen(String, LoadScreenCallback, String[])} API.
     */
    public static final String ALL_GLOBALS = "-ALL_GLOBALS";

    /**
     * In Internet Explorer 9, when a string of
     * JavaScript is evaluated via the native <code>eval()</code> function, objects created
     * within that evaluation are not released from browser memory until the page is
     * reloaded.
     * <P>
     * SmartGWT uses the <code>eval()</code> function to evaluate JSON formatted
     * responses to RPCRequests by default, making long running applications potentially
     * susceptible to memory leaks over time.
     * <P>
     * Setting this property to <code>false</code> enables a workaround suggested on the
     * <a href="http://support.microsoft.com/kb/2572253">Microsoft Knowledge Base</a> to
     * avoid such memory leaks by evaluating script in a hidden iframe and periodically
     * refresh that frame. However developers should be aware of the following
     * limitation with this setting: attempting to access certain object types including
     * <code>Date</code> or <code>function</code> objects generated from such an
     * evaluation can subsequently lead to a JavaScript error with the message
     * <code>"Can't execute code from a freed script"</code>.
     * <P>
     * This workaround therefore may not be suitable for all transactions or dataSources
     * within a given application.
     * <P>
     * This property may also be specified for specific +link{RPCRequest.allowIE9Leak,RPCRequests}.
     * <P>
     * Note: This issue is discussed further in the online
     * <a href="http://forums.smartclient.com/showthread.php?t=8159">SmartGWT FAQ</a>.
     */
    public static native void setAllowIE9Leak(boolean allowLeak) /*-{
        $wnd.isc.RPCManager.allowIE9Leak = allowLeak;
    }-*/;

    /** Creates a screen previously cached by a call to {@link RPCManager#cacheScreens(String[], Function, String, RPCRequest)}.
     * <p>
     * As with {@link RPCManager#loadScreen(String, LoadScreenCallback, String[])}, the default 
     * behavior is to prevent any global widget IDs from
     * being established, the returned Canvas will be the outermost component of the screen,
     * and that Canvas will provide access to other widgets in the screen via {@link Canvas#getByLocalId(String)}
     * <p>
     * Alternatively, as with {@link RPCManager#loadScreen(String, LoadScreenCallback, String[])}, 
     * a list of IDs that should be allowed to become
     * globals can be passed, allowing those widgets to be retrieved via a call to
     * {@link Canvas#getById(String)} after the screen has been created.
     * <p>
     * If you do not pass <code>globals</code> and avoid depending on global IDs within the screen
     * definition itself (for example, by embedding JavaScript event handlers in the screen definition
     * that use global IDs), you can create the same screen multiple times.
     * 
     * @param screenName name of the screen to create
     *
     * @return last top-level widget in the screen definition
     */
    public static Canvas createScreen(String screenName) {
        return createScreen(screenName, null);
    }

    /** Creates a screen previously cached by a call to {@link RPCManager#cacheScreens(String[], Function, String, RPCRequest)}.
     * <p>
     * As with {@link RPCManager#loadScreen(String, LoadScreenCallback, String[])}, 
     * the default behavior is to prevent any global widget IDs from
     * being established, the returned Canvas will be the outermost component of the screen,
     * and that Canvas will provide access to other widgets in the screen via {@link Canvas#getByLocalId(String)}
     * <p>
     * Alternatively, as with {@link RPCManager#loadScreen(String, LoadScreenCallback, String[])}, 
     * a list of IDs that should be allowed to become
     * globals can be passed, allowing those widgets to be retrieved via a call to
     * {@link Canvas#getById(String)} after the screen has been created.
     * <p>
     * If you do not pass <code>globals</code> and avoid depending on global IDs within the screen
     * definition itself (for example, by embedding JavaScript event handlers in the screen definition
     * that use global IDs), you can create the same screen multiple times.
     * 
     * @param screenName name of the screen to create
     * @param globals widgets to allow to take their global IDs
     *
     * @return last top-level widget in the screen definition
     */
    // Note: In order to return the correct SGWT wrapper type (Canvas, ListGrid, etc.), this
    // function needs directly or indirectly call ObjectFactory::createCanvas(), which it
    // currently achieves through the call to Canvas::getByJSObject().  It is not sufficient to
    // call Canvas.getOrCreateRef(), which always creates a SGWT wrapper of type Canvas.
    public static native Canvas createScreen(String screenName, String[] globals) /*-{
        var globalsJ = globals == null ? null : @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(globals);
        var ret = $wnd.isc.RPCManager.createScreen(screenName, globalsJ);

        if(ret == null) return null;
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Converts {@link com.smartgwt.client.widgets.Canvas#getPrintHTML printable HTML} generated from live UI components
     *  into a .pdf and downloads it ("Save As.." dialog).
     *  <P>
     * For {@link com.smartgwt.client.widgets.drawing.DrawPane} and subclasses (e.g. {@link
     * com.smartgwt.client.widgets.chart.FacetChart}) to export properly, the canvas
     * parameter must be the widget itself, not the HTML obtained with {@link com.smartgwt.client.widgets.Canvas#getPrintHTML
     * getPrintHTML()} unless the {@link com.smartgwt.client.util.PrintProperties} passed to getPrintHTML() had
     *  {@link com.smartgwt.client.util.PrintProperties#getPrintForExport printForExport}:true.
     *  <P>
     *  You can use a custom skin when exporting your HTML content. To use a custom skin,
     *  add a line to server.properties:
     *  <pre>
     *    skin.{skinName}.location: custom/skin
     *  </pre>
     *  Where {skinName} is the name of your custom skin, and the value is the path to your 
     *  skin resources from the application webroot.
     *  <P>
     *  Requires the Smart GWT server framework, but does not require use of server-based
     *  databinding - no .ds.xml files need to exist.
     *  <P> 
     *  See server-side docs for com.isomorphic.contentexport.PdfExport for more details on
     *  server-side processing and code samples for redirecting PDF output to a file or
     *  in-memory buffer, as well as instructions for adding additional stylesheets.
     * 
     * 
     * @param components Array of canvases that have exportable widgets.
     * @param requestProperties Request properties for the export to pdf object
     */
    public static void exportContent(Canvas[] components, DSRequest requestProperties) {
        Object[] componentsObjects = new Object[components.length];
        for (int i = 0; i < components.length; i++) {
        	componentsObjects[i] = components[i].getOrCreateJsObj();
        }
    	exportContent(componentsObjects, requestProperties);
    }

    private static native void exportContent(Object[] components, DSRequest requestProperties) /*-{
	    var componentsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(components);
        $wnd.isc.RPCManager.exportContent(componentsJS, requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
	}-*/;

    /**
     * Converts {@link com.smartgwt.client.widgets.Canvas#getPrintHTML printable HTML} generated from live UI components
     *  into a .pdf and downloads it ("Save As.." dialog).
     *  <P>
     * For {@link com.smartgwt.client.widgets.drawing.DrawPane} and subclasses (e.g. {@link
     * com.smartgwt.client.widgets.chart.FacetChart}) to export properly, the canvas
     * parameter must be the widget itself, not the HTML obtained with {@link com.smartgwt.client.widgets.Canvas#getPrintHTML
     * getPrintHTML()} unless the {@link com.smartgwt.client.util.PrintProperties} passed to getPrintHTML() had
     *  {@link com.smartgwt.client.util.PrintProperties#getPrintForExport printForExport}:true.
     *  <P>
     *  You can use a custom skin when exporting your HTML content. To use a custom skin,
     *  add a line to server.properties:
     *  <pre>
     *    skin.{skinName}.location: custom/skin
     *  </pre>
     *  Where {skinName} is the name of your custom skin, and the value is the path to your 
     *  skin resources from the application webroot.
     *  <P>
     *  Requires the Smart GWT server framework, but does not require use of server-based
     *  databinding - no .ds.xml files need to exist.
     *  <P> 
     *  See server-side docs for com.isomorphic.contentexport.PdfExport for more details on
     *  server-side processing and code samples for redirecting PDF output to a file or
     *  in-memory buffer, as well as instructions for adding additional stylesheets.
     * 
     * 
     * @param htmlFragment HTML fragment derived from {@link com.smartgwt.client.widgets.Canvas#getPrintHTML getPrintHTML()}.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}.
     * @param requestProperties Request properties for the export to pdf object
     */
    public static native void exportContent(String htmlFragment, DSRequest requestProperties) /*-{
	    $wnd.isc.RPCManager.exportContent(htmlFragment, requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
	}-*/;

    public static void exportImage(String svgString) {
        exportImage(svgString, null, null);
    }

    public static void exportImage(String svgString, DSRequest requestProperties) {
        exportImage(svgString, requestProperties, null);
    }

    /**
     * Converts an SVG string to one of several possible image formats, and can either initiate
     * a download or return the base64-encoded image data. Control the image format via
     * {@link com.smartgwt.client.data.DSRequest#getExportImageFormat() DSRequest.exportImageFormat}.
     * <p>
     * Default is to download the image (triggering the browser's save dialog).
     * {@link com.smartgwt.client.data.DSRequest#getExportFilename() DSRequest.exportFilename}
     * can be used to control the default filename provided in the save dialog.
     * <p>
     * To instead return the data as a normal <code>DSResponse</code>, set
     * {@link com.smartgwt.client.data.DSRequest#getExportDisplay() exportDisplay} of <code>requestProperties</code>
     * to {@link com.smartgwt.client.types.ExportDisplay#RETURN}. In this case the data is always
     * base64 encoded.
     * <p>
     * Requires the SmartClient server framework, with the same set of required .jars as are
     * required for PDF export of charts in legacy IE.
     * <p>
     * See also {@link com.smartgwt.client.widgets.drawing.DrawPane#getSvgString()} and
     * {@link com.smartgwt.client.widgets.drawing.DrawPane#getDataURL()}.
     * 
     * @param svgString XML string containing SVG data
     * @param requestProperties request properties controlling options for export
     * @param callback optional callback when using exportDisplay:"return". <b>Does not fire</b> for other exportDisplay modes.
     */
    public static native void exportImage(String svgString, DSRequest requestProperties, ExportImageCallback callback) /*-{
        var requestPropertiesJ = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        var callbackJ = (callback == null ? null : $entry(function (imageData) {
            if (callback != null) callback.@com.smartgwt.client.rpc.ExportImageCallback::execute(Ljava/lang/String;)(imageData);
        }));
        $wnd.isc.RPCManager.exportImage(svgString, requestPropertiesJ, callbackJ);
    }-*/;

    /**
     * Sets callback to handle server error responses for submitted transactions.
     * When the server responds to a submitted transaction with an HTTP error code this method
     * will be called before any individual response callbacks are fired, regardless of whether
     * {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError RPCRequest.willHandleError} 
     * was specified on the submitted request[s].
     * <P>
     * This provides the developer with an opportunity to handle a server error by (for example)
     * suspending and resubmitting the transaction before any other handling occurs.
     * <P>
     * The default implementation takes no action - by default transport errors are handled via
     * {@link com.smartgwt.client.rpc.HandleErrorCallback#handleError handleError()}, or by the standard
     * request callback methods, depending on request.willHandleError.  To perform custom
     * handing for transport errors, use this method to install a
     * {@link com.smartgwt.client.rpc.HandleTransportErrorCallback HandleTransportErrorCallback}.
     * <P>
     * See {@link com.smartgwt.client.rpc.RPCManager#cancelDefaultErrorHandling cancelDefaultErrorHandling()}
     * for details on how to stop the default error handling or current
     * {@link com.smartgwt.client.rpc.HandleErrorCallback#handleError error handler} if it
     * interferes with what you're trying to do in the <code>HandleTransportErrorCallback</code>
     * passed to this method.
     * <P>
     * Note: This method only applies to operations submitted via
     * {@link com.smartgwt.client.types.RPCTransport XMLHttpRequest} - it is not possible to
     * provide similar error handling for other transports.
     * <P>
     * See this {@link com.smartgwt.client.docs.ErrorHandling separate article} on error
     * handling for an overview.
     * 
     * @param callback HandleTransportErrorCallback the callback to set.
     *
     * @see com.smartgwt.client.rpc.HandleErrorCallback#handleError
     */
	public static native void setHandleTransportErrorCallback(HandleTransportErrorCallback callback) /*-{
        $wnd.isc.RPCManager.addClassProperties({
        	handleTransportError:
			$entry( function(transactionNum, status, httpResponseCode, httpResponseText) { 
				if (callback != null) {
                    $wnd.isc.RPCManager._handleTransportErrorTNum = transactionNum;
                    callback.@com.smartgwt.client.rpc.HandleTransportErrorCallback::handleTransportError(IIILjava/lang/String;)(
					    transactionNum, 
                        status, 
                        httpResponseCode, 
                        httpResponseText
                    );
                    delete $wnd.isc.RPCManager._handleTransportErrorTNum;
                }
			})
        });
	}-*/;

	/**
     * Cancels default error handling for all {@link com.smartgwt.client.data.DSResponse}s in
     * the current transaction, ensuring that the default error handling or current
     * {@link com.smartgwt.client.rpc.HandleErrorCallback error handler} is not called for any
     * of them.  This method is intended to be called inside a
     * {@link com.smartgwt.client.rpc.HandleTransportErrorCallback HandleTransportErrorCallback},
     * to prevent any potential interference from the default handling.
     */
    public static native void cancelDefaultErrorHandling() /*-{
        var transactionNum = $wnd.isc.RPCManager._handleTransportErrorTNum,
            transaction = $wnd.isc.RPCManager.getTransaction(transactionNum);
        $wnd.isc.RPCManager.cancelDefaultErrorHandling(transaction);
    }-*/;

}
