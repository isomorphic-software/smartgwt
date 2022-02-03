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
 * Encapsulates a client/server RPC request.  You'll need to provide an instance of this class (or a constructor for it) to
 * the {@link com.smartgwt.client.rpc.RPCManager#sendRequest RPCManager.sendRequest()} method.  If you use the  {@link
 * com.smartgwt.client.rpc.RPCManager#send RPCManager.send()} method, an instance of RPCRequest will be created for you.
 * @see com.smartgwt.client.rpc.RPCManager#send
 * @see com.smartgwt.client.rpc.RPCManager#sendRequest
 */
@BeanFactory.FrameworkClass
public class RPCRequest extends DataClass {

    public static RPCRequest getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new RPCRequest(jsObj);
    }
        


    public RPCRequest(){
        
    }

    public RPCRequest(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Overrides RPCManager.actionURL for this request only.  If you're using queuing, note that queues as per-URL - in other
     * words all RPCRequests in a queue must go to a single URL.  If you attempt to send a request with an actionURL that is
     * different from those already in the queue, it will be sent to the server separately, ahead of the queue,  and a warning
     * will be logged to the Developer Console.
     *
     * @param actionURL New actionURL value. Default value is RPCManager.actionURL
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#actionURL
     * @see com.smartgwt.client.docs.URL URL 
     */
    public RPCRequest setActionURL(String actionURL) {
        return (RPCRequest)setAttribute("actionURL", actionURL);
    }

    /**
     * Overrides RPCManager.actionURL for this request only.  If you're using queuing, note that queues as per-URL - in other
     * words all RPCRequests in a queue must go to a single URL.  If you attempt to send a request with an actionURL that is
     * different from those already in the queue, it will be sent to the server separately, ahead of the queue,  and a warning
     * will be logged to the Developer Console.
     *
     * @return Current actionURL value. Default value is RPCManager.actionURL
     * @see com.smartgwt.client.rpc.RPCManager#actionURL
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getActionURL()  {
        return getAttributeAsString("actionURL");
    }
    

    /**
     * Advanced flag to avoid a potential memory leak in Internet Explorer 9 for requests with JSON formatted responses. <P>
     * This attribute may be set to <code>false</code> to explicitly enable the  workaround described {@link
     * com.smartgwt.client.rpc.RPCManager#allowIE9Leak here} for this request,  avoiding a potential memory leak in Internet
     * Explorer 9. <P> This workaround has a limitation in that if parsing the JSON response generates certain object types
     * including JavaScript <code>Date</code> or <code>function</code> objects, attempts to interact with these objects can
     * subsequently lead to a  JavaScript error with the message <code>"Can't execute code from a freed script"</code>. <P>
     * This workaround therefore may not be suitable for all transactions or dataSources within a given application. <P> This
     * property may also be set globally within an application (via  {@link com.smartgwt.client.rpc.RPCManager#allowIE9Leak
     * allowIE9Leak})_. <P> Note: This memory leak and workaround is discussed further in the online  <a
     * href="http://forums.smartclient.com/showthread.php?t=8159">Smart GWT FAQ</a>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param allowIE9Leak New allowIE9Leak value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setAllowIE9Leak(Boolean allowIE9Leak) {
        return (RPCRequest)setAttribute("allowIE9Leak", allowIE9Leak);
    }

    /**
     * Advanced flag to avoid a potential memory leak in Internet Explorer 9 for requests with JSON formatted responses. <P>
     * This attribute may be set to <code>false</code> to explicitly enable the  workaround described {@link
     * com.smartgwt.client.rpc.RPCManager#allowIE9Leak here} for this request,  avoiding a potential memory leak in Internet
     * Explorer 9. <P> This workaround has a limitation in that if parsing the JSON response generates certain object types
     * including JavaScript <code>Date</code> or <code>function</code> objects, attempts to interact with these objects can
     * subsequently lead to a  JavaScript error with the message <code>"Can't execute code from a freed script"</code>. <P>
     * This workaround therefore may not be suitable for all transactions or dataSources within a given application. <P> This
     * property may also be set globally within an application (via  {@link com.smartgwt.client.rpc.RPCManager#allowIE9Leak
     * allowIE9Leak})_. <P> Note: This memory leak and workaround is discussed further in the online  <a
     * href="http://forums.smartclient.com/showthread.php?t=8159">Smart GWT FAQ</a>.
     *
     * @return Current allowIE9Leak value. Default value is null
     */
    public Boolean getAllowIE9Leak()  {
        return getAttributeAsBoolean("allowIE9Leak", true);
    }
    

    /**
     * For xmlHttp transport + httpMethod: "GET" only, set to true to force a conditional GET request even if the browser
     * thinks it has a current cached response.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param bypassCache New bypassCache value. Default value is false
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setBypassCache(Boolean bypassCache) {
        return (RPCRequest)setAttribute("bypassCache", bypassCache);
    }

    /**
     * For xmlHttp transport + httpMethod: "GET" only, set to true to force a conditional GET request even if the browser
     * thinks it has a current cached response.
     *
     * @return Current bypassCache value. Default value is false
     */
    public Boolean getBypassCache()  {
        Boolean result = getAttributeAsBoolean("bypassCache", true);
        return result == null ? false : result;
    }
    
    

    /**
     * For use only with the {@link com.smartgwt.client.types.RPCTransport scriptInclude} transport, this attribute
     *  specifies the name of the URL parameter which is used to specify the callback function that
     *  the server is expected to call by writing out JavaScript code.  The actual function to call
     *  is automatically generated and differs for every request (to allow concurrency).
     *  <P>
     *  For example, with <code>callbackParam</code> set to it's default value of "callback", the
     *  server might be contacted with a URL like:
     *  <pre>
     *     loadData?callback=isc_scriptIncludeCallback_5
     *  </pre>
     *  .. then the server's response should look like:
     *  <pre>
     *     isc_scriptIncludeCallback_5({ .. data .. });
     *  </pre>
     *  The name "isc_scriptIncludeCallback_5" is automatically generated and will differ each time
     *  the server is contacted.
     *  <P>
     *  Smart GWT makes of this server-provided callback mechanism, then calls
     *  {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} normally.
     *  <p>
     *  <code>rpcRequest.callbackParam</code> is ignored by all transport other than
     *  <code>scriptInclude</code>.
     *
     * @param callbackParam New callbackParam value. Default value is "callback"
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setCallbackParam(String callbackParam) {
        return (RPCRequest)setAttribute("callbackParam", callbackParam);
    }

    /**
     * For use only with the {@link com.smartgwt.client.types.RPCTransport scriptInclude} transport, this attribute
     *  specifies the name of the URL parameter which is used to specify the callback function that
     *  the server is expected to call by writing out JavaScript code.  The actual function to call
     *  is automatically generated and differs for every request (to allow concurrency).
     *  <P>
     *  For example, with <code>callbackParam</code> set to it's default value of "callback", the
     *  server might be contacted with a URL like:
     *  <pre>
     *     loadData?callback=isc_scriptIncludeCallback_5
     *  </pre>
     *  .. then the server's response should look like:
     *  <pre>
     *     isc_scriptIncludeCallback_5({ .. data .. });
     *  </pre>
     *  The name "isc_scriptIncludeCallback_5" is automatically generated and will differ each time
     *  the server is contacted.
     *  <P>
     *  Smart GWT makes of this server-provided callback mechanism, then calls
     *  {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} normally.
     *  <p>
     *  <code>rpcRequest.callbackParam</code> is ignored by all transport other than
     *  <code>scriptInclude</code>.
     *
     * @return Current callbackParam value. Default value is "callback"
     */
    public String getCallbackParam()  {
        return getAttributeAsString("callbackParam");
    }
    
    

    /**
     * For use during {@link com.smartgwt.client.docs.Relogin Relogin}, this property marks this request an attempt to login,
     * therefore a response containing the <code>loginRequiredMarker</code> is a normal condition and should result in the
     * status code {@link com.smartgwt.client.rpc.RPCResponse#STATUS_LOGIN_INCORRECT STATUS_LOGIN_INCORRECT} rather than a call
     * to {@link com.smartgwt.client.rpc.RPCManager#loginRequired loginRequired()}. <P> It is not required to set
     * <code>containsCredentials</code>, however, it does typically simplify relogin logic by separating the handling of RPCs
     * that are login attempts from RPCs that are not.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param containsCredentials New containsCredentials value. Default value is false
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Relogin Relogin overview and related methods
     */
    public RPCRequest setContainsCredentials(Boolean containsCredentials) {
        return (RPCRequest)setAttribute("containsCredentials", containsCredentials);
    }

    /**
     * For use during {@link com.smartgwt.client.docs.Relogin Relogin}, this property marks this request an attempt to login,
     * therefore a response containing the <code>loginRequiredMarker</code> is a normal condition and should result in the
     * status code {@link com.smartgwt.client.rpc.RPCResponse#STATUS_LOGIN_INCORRECT STATUS_LOGIN_INCORRECT} rather than a call
     * to {@link com.smartgwt.client.rpc.RPCManager#loginRequired loginRequired()}. <P> It is not required to set
     * <code>containsCredentials</code>, however, it does typically simplify relogin logic by separating the handling of RPCs
     * that are login attempts from RPCs that are not.
     *
     * @return Current containsCredentials value. Default value is false
     * @see com.smartgwt.client.docs.Relogin Relogin overview and related methods
     */
    public Boolean getContainsCredentials()  {
        Boolean result = getAttributeAsBoolean("containsCredentials", true);
        return result == null ? false : result;
    }
    

    /**
     * Valid with the xmlHttpRequest transport only and only when {@link com.smartgwt.client.rpc.RPCRequest#getHttpMethod
     * httpMethod} is set to "POST".
     *
     * @param contentType New contentType value. Default value is "application/x-www-form-urlencoded"
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setContentType(String contentType) {
        return (RPCRequest)setAttribute("contentType", contentType);
    }

    /**
     * Valid with the xmlHttpRequest transport only and only when {@link com.smartgwt.client.rpc.RPCRequest#getHttpMethod
     * httpMethod} is set to "POST".
     *
     * @return Current contentType value. Default value is "application/x-www-form-urlencoded"
     */
    public String getContentType()  {
        return getAttributeAsString("contentType");
    }
    

    /**
     * This attribute specifies the payload of the RPCRequest.     When using the {@link com.smartgwt.client.docs.IscServer
     * Smart GWT server}, objects sent to the server as <code>request.data</code> will be available on the server-side
     * <code>RPCRequest</code> object as Java Objects. This is achieved by serializing the client side data in a JSON type
     * format and generating Java Objects on the server from this serialized data. <P> If the client side
     * <code>request.data</code> is set to a Java object in your SmartGWT code it will be serialized as JSON as follows:<br> -
     * Numeric client side values (int, Integer, etc) will be serialized as JavaScript numbers.<br> - String values will be
     * serialized as JavaScript strings.<br> - Date values will be serialized as JavaScript dates.<br> - Maps or Record objects
     * will be serialized as JavaScript Objects.<br> - Arrays or Lists will become JavaScript arrays<br> Serialization of Maps
     * and Arrays is recursive - each entry in an Array, or attribute on a Map will also be serialized according to the above
     * rules.<br> Note that you can also set <code>request.data</code> directly to a JavaScriptObject, and use the
     * <code>JSOHelper</code> class or <code><i>SomeObject.</i>getJSObj()</code> to  perform your own data conversions on the
     * client. The serialized JavaScript will then be converted back to Java on the server according to the following rules. 
     * <P> Here are the  mapping of JavaScript types to their corresponding server object types:<br><br> <table class='normal'
     * border='1'>   <tr><td><b>JS Type</b></td>     <td><b>Java Type</b></td></tr>   <tr><td>Object: {}</td>        
     * <td>Map</td></tr>   <tr><td>Array: []</td>          <td>List</td></tr>   <tr><td>String</td>            
     * <td>String</td></tr>   <tr><td>Number</td>             <td>Long|Double</td></tr>   <tr><td>Boolean</td>           
     * <td>Boolean</td></tr>   <tr><td>Date</td>               <td>java.util.Date</td></tr>   <tr><td>String</td>            
     * <td>com.smartgwt.client.types.ValueEnum</td></tr> </table> <br><br> Note that the order of keys/values in the Maps
     * created on the server is not guaranteed because JavaScript Object literals do not guarantee order. <p> When using JPA or
     * Hibernate Java value used can be affected by the Java Bean declaration.  See {@link
     * com.smartgwt.client.docs.DsRequestBeanTypes} for details. <p> Server->client conversion follows this table as well, with
     * some extras.  See the toJS() method on JSTranslater in the server documentation for a description of additional
     * behaviors. <P> When <b>not</b> communicating with the Smart GWT server, <code>rpcRequest.data</code> becomes simple HTTP
     * parameters or an HTTP request body - see {@link com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp useSimpleHttp} for
     * details.
     *
     * @param data New data value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCResponse#setData
     */
    public RPCRequest setData(String data) {
        return (RPCRequest)setAttribute("data", data);
    }

    /**
     * This attribute specifies the payload of the RPCRequest.     When using the {@link com.smartgwt.client.docs.IscServer
     * Smart GWT server}, objects sent to the server as <code>request.data</code> will be available on the server-side
     * <code>RPCRequest</code> object as Java Objects. This is achieved by serializing the client side data in a JSON type
     * format and generating Java Objects on the server from this serialized data. <P> If the client side
     * <code>request.data</code> is set to a Java object in your SmartGWT code it will be serialized as JSON as follows:<br> -
     * Numeric client side values (int, Integer, etc) will be serialized as JavaScript numbers.<br> - String values will be
     * serialized as JavaScript strings.<br> - Date values will be serialized as JavaScript dates.<br> - Maps or Record objects
     * will be serialized as JavaScript Objects.<br> - Arrays or Lists will become JavaScript arrays<br> Serialization of Maps
     * and Arrays is recursive - each entry in an Array, or attribute on a Map will also be serialized according to the above
     * rules.<br> Note that you can also set <code>request.data</code> directly to a JavaScriptObject, and use the
     * <code>JSOHelper</code> class or <code><i>SomeObject.</i>getJSObj()</code> to  perform your own data conversions on the
     * client. The serialized JavaScript will then be converted back to Java on the server according to the following rules. 
     * <P> Here are the  mapping of JavaScript types to their corresponding server object types:<br><br> <table class='normal'
     * border='1'>   <tr><td><b>JS Type</b></td>     <td><b>Java Type</b></td></tr>   <tr><td>Object: {}</td>        
     * <td>Map</td></tr>   <tr><td>Array: []</td>          <td>List</td></tr>   <tr><td>String</td>            
     * <td>String</td></tr>   <tr><td>Number</td>             <td>Long|Double</td></tr>   <tr><td>Boolean</td>           
     * <td>Boolean</td></tr>   <tr><td>Date</td>               <td>java.util.Date</td></tr>   <tr><td>String</td>            
     * <td>com.smartgwt.client.types.ValueEnum</td></tr> </table> <br><br> Note that the order of keys/values in the Maps
     * created on the server is not guaranteed because JavaScript Object literals do not guarantee order. <p> When using JPA or
     * Hibernate Java value used can be affected by the Java Bean declaration.  See {@link
     * com.smartgwt.client.docs.DsRequestBeanTypes} for details. <p> Server->client conversion follows this table as well, with
     * some extras.  See the toJS() method on JSTranslater in the server documentation for a description of additional
     * behaviors. <P> When <b>not</b> communicating with the Smart GWT server, <code>rpcRequest.data</code> becomes simple HTTP
     * parameters or an HTTP request body - see {@link com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp useSimpleHttp} for
     * details.
     *
     * @param data New data value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCResponse#setData
     */
    public RPCRequest setData(Record data) {
        return (RPCRequest)setAttribute("data", data == null ? null : data.getJsObj());
    }

    /**
     * This attribute specifies the payload of the RPCRequest.     When using the {@link com.smartgwt.client.docs.IscServer
     * Smart GWT server}, objects sent to the server as <code>request.data</code> will be available on the server-side
     * <code>RPCRequest</code> object as Java Objects. This is achieved by serializing the client side data in a JSON type
     * format and generating Java Objects on the server from this serialized data. <P> If the client side
     * <code>request.data</code> is set to a Java object in your SmartGWT code it will be serialized as JSON as follows:<br> -
     * Numeric client side values (int, Integer, etc) will be serialized as JavaScript numbers.<br> - String values will be
     * serialized as JavaScript strings.<br> - Date values will be serialized as JavaScript dates.<br> - Maps or Record objects
     * will be serialized as JavaScript Objects.<br> - Arrays or Lists will become JavaScript arrays<br> Serialization of Maps
     * and Arrays is recursive - each entry in an Array, or attribute on a Map will also be serialized according to the above
     * rules.<br> Note that you can also set <code>request.data</code> directly to a JavaScriptObject, and use the
     * <code>JSOHelper</code> class or <code><i>SomeObject.</i>getJSObj()</code> to  perform your own data conversions on the
     * client. The serialized JavaScript will then be converted back to Java on the server according to the following rules. 
     * <P> Here are the  mapping of JavaScript types to their corresponding server object types:<br><br> <table class='normal'
     * border='1'>   <tr><td><b>JS Type</b></td>     <td><b>Java Type</b></td></tr>   <tr><td>Object: {}</td>        
     * <td>Map</td></tr>   <tr><td>Array: []</td>          <td>List</td></tr>   <tr><td>String</td>            
     * <td>String</td></tr>   <tr><td>Number</td>             <td>Long|Double</td></tr>   <tr><td>Boolean</td>           
     * <td>Boolean</td></tr>   <tr><td>Date</td>               <td>java.util.Date</td></tr>   <tr><td>String</td>            
     * <td>com.smartgwt.client.types.ValueEnum</td></tr> </table> <br><br> Note that the order of keys/values in the Maps
     * created on the server is not guaranteed because JavaScript Object literals do not guarantee order. <p> When using JPA or
     * Hibernate Java value used can be affected by the Java Bean declaration.  See {@link
     * com.smartgwt.client.docs.DsRequestBeanTypes} for details. <p> Server->client conversion follows this table as well, with
     * some extras.  See the toJS() method on JSTranslater in the server documentation for a description of additional
     * behaviors. <P> When <b>not</b> communicating with the Smart GWT server, <code>rpcRequest.data</code> becomes simple HTTP
     * parameters or an HTTP request body - see {@link com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp useSimpleHttp} for
     * details.
     *
     * @param data New data value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCResponse#setData
     */
    public RPCRequest setData(Map data) {
        return (RPCRequest)setAttribute("data", data);
    }
    

    /**
     * If enabled, causes the RPCRequest to download the requested resource as a file, either  showing the browser's Save
     * dialog or displaying the file-content in  {@link com.smartgwt.client.rpc.RPCRequest#getDownloadToNewWindow a new browser
     * window}. <P> Download requests do not fire a callback.<br> By default the request will use {@link
     * com.smartgwt.client.rpc.RPCRequest#getTransport transport}: "hiddenFrame". Developers may override this by explicitly
     * setting <code>request.transport</code> to "xmlHttpRequest". This mode allows developers to send {@link
     * com.smartgwt.client.rpc.RPCRequest#getHttpHeaders httpHeaders} to the server, but has some drawbacks:
     * <ul><li>xmlHttpRequest download does not have a built-in progress bar to indicate download progress</li>     <li>The
     * browser must hold the entire XHR response in memory, whereas with normal download         data is streamed to disk or to
     * another application</li>     <li>This mode does not currently support {@link
     * com.smartgwt.client.rpc.RPCRequest#getDownloadToNewWindow downloadToNewWindow}</li></ul>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param downloadResult New downloadResult value. Default value is false
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setDownloadResult(Boolean downloadResult) {
        return (RPCRequest)setAttribute("downloadResult", downloadResult);
    }

    /**
     * If enabled, causes the RPCRequest to download the requested resource as a file, either  showing the browser's Save
     * dialog or displaying the file-content in  {@link com.smartgwt.client.rpc.RPCRequest#getDownloadToNewWindow a new browser
     * window}. <P> Download requests do not fire a callback.<br> By default the request will use {@link
     * com.smartgwt.client.rpc.RPCRequest#getTransport transport}: "hiddenFrame". Developers may override this by explicitly
     * setting <code>request.transport</code> to "xmlHttpRequest". This mode allows developers to send {@link
     * com.smartgwt.client.rpc.RPCRequest#getHttpHeaders httpHeaders} to the server, but has some drawbacks:
     * <ul><li>xmlHttpRequest download does not have a built-in progress bar to indicate download progress</li>     <li>The
     * browser must hold the entire XHR response in memory, whereas with normal download         data is streamed to disk or to
     * another application</li>     <li>This mode does not currently support {@link
     * com.smartgwt.client.rpc.RPCRequest#getDownloadToNewWindow downloadToNewWindow}</li></ul>
     *
     * @return Current downloadResult value. Default value is false
     */
    public Boolean getDownloadResult()  {
        Boolean result = getAttributeAsBoolean("downloadResult", true);
        return result == null ? false : result;
    }
    

    /**
     * When {@link com.smartgwt.client.rpc.RPCRequest#getDownloadResult downloadResult} is true, setting this attribute to true
     * causes the content of the downloaded file to be displayed in a new browser window.  <P> Note that this setting is
     * currently incompatible with {@link com.smartgwt.client.rpc.RPCRequest#getTransport transport:"xmlHttpRequest"}. See the 
     * {@link com.smartgwt.client.rpc.RPCRequest#getDownloadResult downloadResult} documentation for more details on 
     * xmlHttpRequest downloads
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param downloadToNewWindow New downloadToNewWindow value. Default value is false
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setDownloadToNewWindow(Boolean downloadToNewWindow) {
        return (RPCRequest)setAttribute("downloadToNewWindow", downloadToNewWindow);
    }

    /**
     * When {@link com.smartgwt.client.rpc.RPCRequest#getDownloadResult downloadResult} is true, setting this attribute to true
     * causes the content of the downloaded file to be displayed in a new browser window.  <P> Note that this setting is
     * currently incompatible with {@link com.smartgwt.client.rpc.RPCRequest#getTransport transport:"xmlHttpRequest"}. See the 
     * {@link com.smartgwt.client.rpc.RPCRequest#getDownloadResult downloadResult} documentation for more details on 
     * xmlHttpRequest downloads
     *
     * @return Current downloadToNewWindow value. Default value is false
     */
    public Boolean getDownloadToNewWindow()  {
        Boolean result = getAttributeAsBoolean("downloadToNewWindow", true);
        return result == null ? false : result;
    }
    

    /**
     * This works similarly to {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} except
     * the resulting String
     *  is automatically evaluated as JavaScript.  The result of the evaluation is then passed to
     * any specified {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} as {@link
     * com.smartgwt.client.rpc.RPCResponse#getData RPCResponse.data}.
     *  <p>
     *  This feature can be used to dynamically load new application modules into a running
     *  application.  An RPCRequest with <code>evalResult</code> enabled can be used to fetch a
     *  static .js file or JavaScript dynamically generated by the server.  The returned JavaScript
     *  can contain anything that a JavaScript file loaded at init time can contain, including new
     *  views and new Smart GWT class definitions.
     *  <p>
     *  <i>Example usage with {@link com.smartgwt.client.rpc.RPCManager#sendRequest RPCManager.sendRequest()}:</i>
     *  
     *  
     *  <pre>
     *       RPCRequest rpcRequestProperties = new RPCRequest();
     *       rpcRequestProperties.setEvalResult(true);
     *       rpcRequestProperties.setActionURL("js/loadLabel.js");
     *       Map evalVars = new HashMap();
     *       evalVars.put(var1, "A Value");
     *       rpcRequestProperties.setEvalVars(evalVars);
     *       RPCManager.sendRequest(rpcRequestProperties);     
     *  </pre>
     *  
     *  This call would execute the code from <code>loadLabel.js</code>, and make the variable
     *  <code>var1</code> available to that code. Therefore if the .js file contained this code:
     *  
     *  
     *  <pre>
     *       Label label = new Label();
     *       label.setContents(var1);
     *  </pre>
     *  
     *  A label would be created with contents set to the value of <code>var1</code> - the string
     *  <code>"A Value"</code>.
     *  
     *  <p>
     *  This feature relies on the XMLHttpRequest object which can be disabled by end-users in some
     *  supported browsers.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more information.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param evalResult New evalResult value. Default value is false
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.ViewLoader
     * @see com.smartgwt.client.rpc.RPCRequest#setEvalVars
     */
    public RPCRequest setEvalResult(Boolean evalResult) {
        return (RPCRequest)setAttribute("evalResult", evalResult);
    }

    /**
     * This works similarly to {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} except
     * the resulting String
     *  is automatically evaluated as JavaScript.  The result of the evaluation is then passed to
     * any specified {@link com.smartgwt.client.rpc.RPCRequest#getCallback callback} as {@link
     * com.smartgwt.client.rpc.RPCResponse#getData RPCResponse.data}.
     *  <p>
     *  This feature can be used to dynamically load new application modules into a running
     *  application.  An RPCRequest with <code>evalResult</code> enabled can be used to fetch a
     *  static .js file or JavaScript dynamically generated by the server.  The returned JavaScript
     *  can contain anything that a JavaScript file loaded at init time can contain, including new
     *  views and new Smart GWT class definitions.
     *  <p>
     *  <i>Example usage with {@link com.smartgwt.client.rpc.RPCManager#sendRequest RPCManager.sendRequest()}:</i>
     *  
     *  
     *  <pre>
     *       RPCRequest rpcRequestProperties = new RPCRequest();
     *       rpcRequestProperties.setEvalResult(true);
     *       rpcRequestProperties.setActionURL("js/loadLabel.js");
     *       Map evalVars = new HashMap();
     *       evalVars.put(var1, "A Value");
     *       rpcRequestProperties.setEvalVars(evalVars);
     *       RPCManager.sendRequest(rpcRequestProperties);     
     *  </pre>
     *  
     *  This call would execute the code from <code>loadLabel.js</code>, and make the variable
     *  <code>var1</code> available to that code. Therefore if the .js file contained this code:
     *  
     *  
     *  <pre>
     *       Label label = new Label();
     *       label.setContents(var1);
     *  </pre>
     *  
     *  A label would be created with contents set to the value of <code>var1</code> - the string
     *  <code>"A Value"</code>.
     *  
     *  <p>
     *  This feature relies on the XMLHttpRequest object which can be disabled by end-users in some
     *  supported browsers.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more information.
     *
     * @return Current evalResult value. Default value is false
     * @see com.smartgwt.client.widgets.ViewLoader
     * @see com.smartgwt.client.rpc.RPCRequest#getEvalVars
     */
    public Boolean getEvalResult()  {
        Boolean result = getAttributeAsBoolean("evalResult", true);
        return result == null ? false : result;
    }
    

    /**
     * If you've set {@link com.smartgwt.client.rpc.RPCRequest#getEvalResult evalResult} : true, then the property values of
     * this object will be available in the evaluation scope of the result under the variable names specified by the property
     * names.  <p> So e.g. if evalVars is: <code>{foo: "bar"}</code> then a reference to the variable <code>foo</code> in the
     * result will evaluate to <code>"bar"</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param evalVars New evalVars value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setEvalVars(Map evalVars) {
        return (RPCRequest)setAttribute("evalVars", evalVars);
    }
    

    /**
     * HTTP headers to send, as a Object mapping Header name -> Header value, eg<br> { "Content-Type" : "text/xml" } <P> Valid
     * with the xmlHttpRequest {@link com.smartgwt.client.rpc.RPCRequest#getTransport transport} only.
     *
     * @param httpHeaders New httpHeaders value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setHttpHeaders(Map httpHeaders) {
        return (RPCRequest)setAttribute("httpHeaders", httpHeaders);
    }

    /**
     * HTTP headers to send, as a Object mapping Header name -> Header value, eg<br> { "Content-Type" : "text/xml" } <P> Valid
     * with the xmlHttpRequest {@link com.smartgwt.client.rpc.RPCRequest#getTransport transport} only.
     *
     * @return Current httpHeaders value. Default value is null
     */
    public Map getHttpHeaders()  {
        return getAttributeAsMap("httpHeaders");
    }
    

    /**
     * Selects the HTTP method that will be used for the request.  Typical values are "POST" and "GET". <P> The more obscure
     * "PUT", "DELETE" and "HEAD" methods are also valid, however, none of these are supported by the Safari browser previous
     * to version 3.0.
     *
     * @param httpMethod New httpMethod value. Default value is "POST"
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setHttpMethod(String httpMethod) {
        return (RPCRequest)setAttribute("httpMethod", httpMethod);
    }

    /**
     * Selects the HTTP method that will be used for the request.  Typical values are "POST" and "GET". <P> The more obscure
     * "PUT", "DELETE" and "HEAD" methods are also valid, however, none of these are supported by the Safari browser previous
     * to version 3.0.
     *
     * @return Current httpMethod value. Default value is "POST"
     */
    public String getHttpMethod()  {
        return getAttributeAsString("httpMethod");
    }
    

    /**
     * The proxy URL to use for this request (if {@link com.smartgwt.client.rpc.RPCRequest#getUseHttpProxy useHttpProxy} is set
     * for this request).  If unset, the value of {@link com.smartgwt.client.rpc.RPCManager#httpProxyURL httpProxyURL} will be
     * used instead.
     *
     * @param httpProxyURL New httpProxyURL value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#httpProxyURL
     */
    public RPCRequest setHttpProxyURL(String httpProxyURL) {
        return (RPCRequest)setAttribute("httpProxyURL", httpProxyURL);
    }

    /**
     * The proxy URL to use for this request (if {@link com.smartgwt.client.rpc.RPCRequest#getUseHttpProxy useHttpProxy} is set
     * for this request).  If unset, the value of {@link com.smartgwt.client.rpc.RPCManager#httpProxyURL httpProxyURL} will be
     * used instead.
     *
     * @return Current httpProxyURL value. Default value is null
     * @see com.smartgwt.client.rpc.RPCManager#httpProxyURL
     */
    public String getHttpProxyURL()  {
        return getAttributeAsString("httpProxyURL");
    }
    

    /**
     * When set to true, no reply is expected from the server.  However, if a reply is received, it will be processed.<p> Note:
     * setting this to true, forces {@link com.smartgwt.client.rpc.RPCRequest#getSendNoQueue sendNoQueue} to <code>true</code>
     * for this request.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param ignoreTimeout New ignoreTimeout value. Default value is false
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setIgnoreTimeout(Boolean ignoreTimeout) {
        return (RPCRequest)setAttribute("ignoreTimeout", ignoreTimeout);
    }

    /**
     * When set to true, no reply is expected from the server.  However, if a reply is received, it will be processed.<p> Note:
     * setting this to true, forces {@link com.smartgwt.client.rpc.RPCRequest#getSendNoQueue sendNoQueue} to <code>true</code>
     * for this request.
     *
     * @return Current ignoreTimeout value. Default value is false
     */
    public Boolean getIgnoreTimeout()  {
        Boolean result = getAttributeAsBoolean("ignoreTimeout", true);
        return result == null ? false : result;
    }
    

    /**
     * If enabled and request is applied to {@link com.smartgwt.client.rpc.RPCManager#cacheScreens RPCManager.cacheScreens()}
     * or {@link com.smartgwt.client.rpc.RPCManager#loadScreen RPCManager.loadScreen()} indicates that referenced DataSources
     * should be loaded in mock mode.
     *
     * @param mockMode New mockMode value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setMockMode(Boolean mockMode) {
        return (RPCRequest)setAttribute("mockMode", mockMode);
    }

    /**
     * If enabled and request is applied to {@link com.smartgwt.client.rpc.RPCManager#cacheScreens RPCManager.cacheScreens()}
     * or {@link com.smartgwt.client.rpc.RPCManager#loadScreen RPCManager.loadScreen()} indicates that referenced DataSources
     * should be loaded in mock mode.
     *
     * @return Current mockMode value. Default value is null
     */
    public Boolean getMockMode()  {
        return getAttributeAsBoolean("mockMode", true);
    }
    

    /**
     * If enabled, the server omits any key/value pairs in map that have null values from the response.  This can reduce the
     * size of the response when many fields have null values. <p> To enable this globally for all responses you can set
     * RPCManager.omitNullMapValuesInResponse in {@link com.smartgwt.client.docs.Server_properties server.properties}. <p> Note
     * that {@link com.smartgwt.client.docs.SqlDataSource SQL DataSources} don't add nulls to results for null values so this
     * flag does nothing in that case.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param omitNullMapValuesInResponse New omitNullMapValuesInResponse value. Default value is false
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setOmitNullMapValuesInResponse(Boolean omitNullMapValuesInResponse) {
        return (RPCRequest)setAttribute("omitNullMapValuesInResponse", omitNullMapValuesInResponse);
    }

    /**
     * If enabled, the server omits any key/value pairs in map that have null values from the response.  This can reduce the
     * size of the response when many fields have null values. <p> To enable this globally for all responses you can set
     * RPCManager.omitNullMapValuesInResponse in {@link com.smartgwt.client.docs.Server_properties server.properties}. <p> Note
     * that {@link com.smartgwt.client.docs.SqlDataSource SQL DataSources} don't add nulls to results for null values so this
     * flag does nothing in that case.
     *
     * @return Current omitNullMapValuesInResponse value. Default value is false
     */
    public Boolean getOmitNullMapValuesInResponse()  {
        Boolean result = getAttributeAsBoolean("omitNullMapValuesInResponse", true);
        return result == null ? false : result;
    }
    

    /**
     * Values to be sent as simple HTTP params, as a JavaScript Object where each property/value pair will become an HTTP
     * parameter name and value.  These parameters are then accessible on the server, for example, using
     * servletRequest.getParameter(paramName) in Java Servlets.   <P> Array-valued parameters will be submitted as multiple
     * instances of the same parameter, similar to an HTML form with a multi-select (?paramName=value1&amp;paramName=value2
     * ...), accessible as getParameterValues(paramName) in Java Servlets.  Any non-atomic type, such as an Object, will be
     * serialized to <a href='http://www.json.org/' target='_blank'>JSON</a> by the {@link
     * com.smartgwt.client.util.JSONEncoder}.  If this isn't desirable, serialize the data in advance so that the value
     * provided in <code>rpcRequest.params</code> is a String. <P> Note that this API is primarily used in combination with
     * {@link com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp useSimpleHttp} - when contacting the Smart GWT Server, use
     * {@link com.smartgwt.client.rpc.RPCRequest#getData data} instead, which provides full JavaScript &lt;-&gt; Java
     * translation of arbitrary structures. <code>rpcRequest.params</code> can also be used with the Smart GWT Server, where it
     * provides an an opportunity to send additional data aside from the main {@link com.smartgwt.client.rpc.RPCRequest#getData
     * data} payload.  This is useful for adding data to DataSource requests which will be kept separate from the automatically
     * sent DataSource data, or for making parts of the request visible in the URL for HTTP-level logging or layer 4 switches.
     * <P> Note that in contrast to {@link com.smartgwt.client.rpc.RPCRequest#getData data} object, the data in
     * <code>rpcRequest.params</code> is not deserialized by the Smart GWT server, and all values arrive on the server as
     * String type (like HTTP parameters always do). <p>  <p> Note: The params are submitted once per http transaction.  If you
     * are using  {@link com.smartgwt.client.rpc.RPCManager#startQueue request queuing} to bundle multiple RPCRequests or
     * DSRequests into a single HTTP turnaround, the params from the various RPCRequests will be merged, with the later-queued
     * transactions winning on parameter name collisions.  A warning will be logged in the Developer Console if multiple
     * RPCRequests specified params.
     *
     * @param params New params value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setParams(Map params) {
        return (RPCRequest)setAttribute("params", params);
    }

    /**
     * Values to be sent as simple HTTP params, as a JavaScript Object where each property/value pair will become an HTTP
     * parameter name and value.  These parameters are then accessible on the server, for example, using
     * servletRequest.getParameter(paramName) in Java Servlets.   <P> Array-valued parameters will be submitted as multiple
     * instances of the same parameter, similar to an HTML form with a multi-select (?paramName=value1&amp;paramName=value2
     * ...), accessible as getParameterValues(paramName) in Java Servlets.  Any non-atomic type, such as an Object, will be
     * serialized to <a href='http://www.json.org/' target='_blank'>JSON</a> by the {@link
     * com.smartgwt.client.util.JSONEncoder}.  If this isn't desirable, serialize the data in advance so that the value
     * provided in <code>rpcRequest.params</code> is a String. <P> Note that this API is primarily used in combination with
     * {@link com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp useSimpleHttp} - when contacting the Smart GWT Server, use
     * {@link com.smartgwt.client.rpc.RPCRequest#getData data} instead, which provides full JavaScript &lt;-&gt; Java
     * translation of arbitrary structures. <code>rpcRequest.params</code> can also be used with the Smart GWT Server, where it
     * provides an an opportunity to send additional data aside from the main {@link com.smartgwt.client.rpc.RPCRequest#getData
     * data} payload.  This is useful for adding data to DataSource requests which will be kept separate from the automatically
     * sent DataSource data, or for making parts of the request visible in the URL for HTTP-level logging or layer 4 switches.
     * <P> Note that in contrast to {@link com.smartgwt.client.rpc.RPCRequest#getData data} object, the data in
     * <code>rpcRequest.params</code> is not deserialized by the Smart GWT server, and all values arrive on the server as
     * String type (like HTTP parameters always do). <p>  <p> Note: The params are submitted once per http transaction.  If you
     * are using  {@link com.smartgwt.client.rpc.RPCManager#startQueue request queuing} to bundle multiple RPCRequests or
     * DSRequests into a single HTTP turnaround, the params from the various RPCRequests will be merged, with the later-queued
     * transactions winning on parameter name collisions.  A warning will be logged in the Developer Console if multiple
     * RPCRequests specified params.
     *
     * @return Current params value. Default value is null
     */
    public Map getParams()  {
        return getAttributeAsMap("params");
    }
    
    

    /**
     * Overrides RPCManager.defaultPrompt for this request only.  If you're using queuing, note that the prompt string from the
     * first request in the queue is the one that is shown to the user.
     *
     * @param prompt New prompt value. Default value is RPCManager.defaultPrompt
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#defaultPrompt
     * @see com.smartgwt.client.rpc.RPCManager#showPrompt
     * @see com.smartgwt.client.rpc.RPCManager#promptStyle
     * @see com.smartgwt.client.rpc.RPCManager#promptCursor
     * @see com.smartgwt.client.rpc.RPCRequest#setShowPrompt
     * @see com.smartgwt.client.rpc.RPCRequest#setPromptStyle
     * @see com.smartgwt.client.rpc.RPCRequest#setPromptCursor
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.RpcPrompt RpcPrompt overview and related methods
     */
    public RPCRequest setPrompt(String prompt) {
        return (RPCRequest)setAttribute("prompt", prompt);
    }

    /**
     * Overrides RPCManager.defaultPrompt for this request only.  If you're using queuing, note that the prompt string from the
     * first request in the queue is the one that is shown to the user.
     *
     * @return Current prompt value. Default value is RPCManager.defaultPrompt
     * @see com.smartgwt.client.rpc.RPCManager#defaultPrompt
     * @see com.smartgwt.client.rpc.RPCManager#showPrompt
     * @see com.smartgwt.client.rpc.RPCManager#promptStyle
     * @see com.smartgwt.client.rpc.RPCManager#promptCursor
     * @see com.smartgwt.client.rpc.RPCRequest#getShowPrompt
     * @see com.smartgwt.client.rpc.RPCRequest#getPromptStyle
     * @see com.smartgwt.client.rpc.RPCRequest#getPromptCursor
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.RpcPrompt RpcPrompt overview and related methods
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }
    

    /**
     * Controls the cursor shown when {@link com.smartgwt.client.rpc.RPCManager#promptStyle promptStyle} is set to
     * <code>"cursor"</code> for this request only. Defaults to {@link com.smartgwt.client.rpc.RPCManager#promptCursor
     * promptCursor}.
     *
     * @param promptCursor New promptCursor value. Default value is "progress"
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#promptCursor
     * @see com.smartgwt.client.docs.RpcPrompt RpcPrompt overview and related methods
     */
    public RPCRequest setPromptCursor(String promptCursor) {
        return (RPCRequest)setAttribute("promptCursor", promptCursor);
    }

    /**
     * Controls the cursor shown when {@link com.smartgwt.client.rpc.RPCManager#promptStyle promptStyle} is set to
     * <code>"cursor"</code> for this request only. Defaults to {@link com.smartgwt.client.rpc.RPCManager#promptCursor
     * promptCursor}.
     *
     * @return Current promptCursor value. Default value is "progress"
     * @see com.smartgwt.client.rpc.RPCManager#promptCursor
     * @see com.smartgwt.client.docs.RpcPrompt RpcPrompt overview and related methods
     */
    public String getPromptCursor()  {
        return getAttributeAsString("promptCursor");
    }
    

    /**
     * Overrides RPCManager.promptDelay for this request only. Defaults to {@link
     * com.smartgwt.client.rpc.RPCManager#promptDelay promptDelay}. <p> If you're using queuing, note that the promptDelay of
     * the first request is used for the entire queue.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param promptDelay New promptDelay value. Default value is RPCManager.promptDelay
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCRequest#setShowPrompt
     * @see com.smartgwt.client.rpc.RPCManager#promptDelay
     * @see com.smartgwt.client.docs.RpcPrompt RpcPrompt overview and related methods
     */
    public RPCRequest setPromptDelay(int promptDelay) {
        return (RPCRequest)setAttribute("promptDelay", promptDelay);
    }

    /**
     * Overrides RPCManager.promptDelay for this request only. Defaults to {@link
     * com.smartgwt.client.rpc.RPCManager#promptDelay promptDelay}. <p> If you're using queuing, note that the promptDelay of
     * the first request is used for the entire queue.
     *
     * @return Current promptDelay value. Default value is RPCManager.promptDelay
     * @see com.smartgwt.client.rpc.RPCRequest#getShowPrompt
     * @see com.smartgwt.client.rpc.RPCManager#promptDelay
     * @see com.smartgwt.client.docs.RpcPrompt RpcPrompt overview and related methods
     */
    public int getPromptDelay()  {
        return getAttributeAsInt("promptDelay");
    }
    

    /**
     * Controls the prompt style for this request only.  Defaults to {@link com.smartgwt.client.rpc.RPCManager#promptStyle
     * promptStyle}.
     *
     * @param promptStyle New promptStyle value. Default value is RPCManager.promptStyle
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#promptStyle
     * @see com.smartgwt.client.docs.RpcPrompt RpcPrompt overview and related methods
     */
    public RPCRequest setPromptStyle(PromptStyle promptStyle) {
        return (RPCRequest)setAttribute("promptStyle", promptStyle == null ? null : promptStyle.getValue());
    }

    /**
     * Controls the prompt style for this request only.  Defaults to {@link com.smartgwt.client.rpc.RPCManager#promptStyle
     * promptStyle}.
     *
     * @return Current promptStyle value. Default value is RPCManager.promptStyle
     * @see com.smartgwt.client.rpc.RPCManager#promptStyle
     * @see com.smartgwt.client.docs.RpcPrompt RpcPrompt overview and related methods
     */
    public PromptStyle getPromptStyle()  {
        return EnumUtil.getEnum(PromptStyle.values(), getAttribute("promptStyle"));
    }
    

    /**
     * When set to true, this request is sent to the server immediately, bypassing any current queue.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param sendNoQueue New sendNoQueue value. Default value is false
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setSendNoQueue(Boolean sendNoQueue) {
        return (RPCRequest)setAttribute("sendNoQueue", sendNoQueue);
    }

    /**
     * When set to true, this request is sent to the server immediately, bypassing any current queue.
     *
     * @return Current sendNoQueue value. Default value is false
     */
    public Boolean getSendNoQueue()  {
        Boolean result = getAttributeAsBoolean("sendNoQueue", true);
        return result == null ? false : result;
    }
    

    /**
     * Setting this flag makes the body of the HTTP response available as a String in the {@link
     * com.smartgwt.client.rpc.RPCRequest#getCallback callback} as {@link com.smartgwt.client.rpc.RPCResponse#getData
     * RPCResponse.data}.  This is typically only useful if you are sending a request that will <b>not</b> be received by the
     * Smart GWT Java Server, however in that case, set {@link com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp
     * useSimpleHttp}:true instead, which implies <code>serverOutputAsString:true</code>. <P>
     * <code>serverOutputAsString:true</code> allows you to, for example, load the contents of static files off your webserver
     * into a string for processing on the client with no server support.  The {@link
     * com.smartgwt.client.rpc.RPCRequest#getActionURL actionURL} must be in the same domain as the current page for this to
     * work. <p> This feature relies on the XMLHttpRequest object which can be disabled by end-users in some supported
     * browsers.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more information. <p> Generally this API is
     * used for either {@link com.smartgwt.client.docs.NonJavaBackend non-Java backends}  or for advanced usage such as content
     * that requires processing before it can be used in Smart GWT components (such as client-side web scraping).  Note that
     * Smart GWT provides higher-level APIs for loading common types of data, see eg {@link
     * com.smartgwt.client.widgets.HTMLFlow} for HTML content, {@link com.smartgwt.client.widgets.ViewLoader} for loading Smart
     * GWT components, {@link com.smartgwt.client.data.XMLTools#loadXML XMLTools.loadXML()} for loading XML, {@link
     * com.smartgwt.client.rpc.RPCRequest#getEvalResult evalResult} for loading <a href='http://www.json.org/'
     * target='_blank'>JSON</a>, and {@link com.smartgwt.client.data.DataSource} for loading structured data in various
     * formats.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param serverOutputAsString New serverOutputAsString value. Default value is false
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setServerOutputAsString(Boolean serverOutputAsString) {
        return (RPCRequest)setAttribute("serverOutputAsString", serverOutputAsString);
    }

    /**
     * Setting this flag makes the body of the HTTP response available as a String in the {@link
     * com.smartgwt.client.rpc.RPCRequest#getCallback callback} as {@link com.smartgwt.client.rpc.RPCResponse#getData
     * RPCResponse.data}.  This is typically only useful if you are sending a request that will <b>not</b> be received by the
     * Smart GWT Java Server, however in that case, set {@link com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp
     * useSimpleHttp}:true instead, which implies <code>serverOutputAsString:true</code>. <P>
     * <code>serverOutputAsString:true</code> allows you to, for example, load the contents of static files off your webserver
     * into a string for processing on the client with no server support.  The {@link
     * com.smartgwt.client.rpc.RPCRequest#getActionURL actionURL} must be in the same domain as the current page for this to
     * work. <p> This feature relies on the XMLHttpRequest object which can be disabled by end-users in some supported
     * browsers.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more information. <p> Generally this API is
     * used for either {@link com.smartgwt.client.docs.NonJavaBackend non-Java backends}  or for advanced usage such as content
     * that requires processing before it can be used in Smart GWT components (such as client-side web scraping).  Note that
     * Smart GWT provides higher-level APIs for loading common types of data, see eg {@link
     * com.smartgwt.client.widgets.HTMLFlow} for HTML content, {@link com.smartgwt.client.widgets.ViewLoader} for loading Smart
     * GWT components, {@link com.smartgwt.client.data.XMLTools#loadXML XMLTools.loadXML()} for loading XML, {@link
     * com.smartgwt.client.rpc.RPCRequest#getEvalResult evalResult} for loading <a href='http://www.json.org/'
     * target='_blank'>JSON</a>, and {@link com.smartgwt.client.data.DataSource} for loading structured data in various
     * formats.
     *
     * @return Current serverOutputAsString value. Default value is false
     */
    public Boolean getServerOutputAsString()  {
        Boolean result = getAttributeAsBoolean("serverOutputAsString", true);
        return result == null ? false : result;
    }
    

    /**
     * Overrides <code>RPCManager.showPrompt</code> for this request only. <p> If you're using queuing, note that if any of the
     * requests in the queue specify showPrompt:true, then a prompt will be shown for the entire queue with the prompt text of
     * the first request in the queue to specify a custom prompt if promptStyle is set to "dialog". <p> If promptStyle is set
     * to "cursor" for the request that specified showPrompt: true, then the entire queue uses the "cursor" style for the
     * prompt.
     *
     * @param showPrompt New showPrompt value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#showPrompt
     * @see com.smartgwt.client.rpc.RPCRequest#setPromptStyle
     * @see com.smartgwt.client.docs.RpcPrompt RpcPrompt overview and related methods
     */
    public RPCRequest setShowPrompt(Boolean showPrompt) {
        return (RPCRequest)setAttribute("showPrompt", showPrompt);
    }

    /**
     * Overrides <code>RPCManager.showPrompt</code> for this request only. <p> If you're using queuing, note that if any of the
     * requests in the queue specify showPrompt:true, then a prompt will be shown for the entire queue with the prompt text of
     * the first request in the queue to specify a custom prompt if promptStyle is set to "dialog". <p> If promptStyle is set
     * to "cursor" for the request that specified showPrompt: true, then the entire queue uses the "cursor" style for the
     * prompt.
     *
     * @return Current showPrompt value. Default value is null
     * @see com.smartgwt.client.rpc.RPCManager#showPrompt
     * @see com.smartgwt.client.rpc.RPCRequest#getPromptStyle
     * @see com.smartgwt.client.docs.RpcPrompt RpcPrompt overview and related methods
     */
    public Boolean getShowPrompt()  {
        return getAttributeAsBoolean("showPrompt", true);
    }
    

    /**
     * If {@link com.smartgwt.client.rpc.RPCRequest#getEvalResult evalResult} is set, setting this property to true causes
     * {@link com.smartgwt.client.widgets.Canvas#getAutoDraw Canvas.autoDraw} to be set to false for the duration of the result
     * evaluation - which is generally what you want if you're returning new components from the server. <P> This also effects
     * components loaded via the {@link com.smartgwt.client.rpc.RPCManager#loadScreen RPCManager.loadScreen()} API.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param suppressAutoDraw New suppressAutoDraw value. Default value is true
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setSuppressAutoDraw(Boolean suppressAutoDraw) {
        return (RPCRequest)setAttribute("suppressAutoDraw", suppressAutoDraw);
    }

    /**
     * If {@link com.smartgwt.client.rpc.RPCRequest#getEvalResult evalResult} is set, setting this property to true causes
     * {@link com.smartgwt.client.widgets.Canvas#getAutoDraw Canvas.autoDraw} to be set to false for the duration of the result
     * evaluation - which is generally what you want if you're returning new components from the server. <P> This also effects
     * components loaded via the {@link com.smartgwt.client.rpc.RPCManager#loadScreen RPCManager.loadScreen()} API.
     *
     * @return Current suppressAutoDraw value. Default value is true
     */
    public Boolean getSuppressAutoDraw()  {
        Boolean result = getAttributeAsBoolean("suppressAutoDraw", true);
        return result == null ? true : result;
    }
    

    /**
     * Sets the timeout on this request.  Default is to use {@link com.smartgwt.client.rpc.RPCManager#defaultTimeout
     * defaultTimeout}.   <p> If you're using {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing}, note that the
     * timeout setting derived from the last request in the queue is used for the entire queue.  If you want to override the
     * timeout for the queue, make sure to set your override at least on the last request in the queue. <p> For the
     * "xmlHttpRequest" {@link com.smartgwt.client.rpc.RPCRequest#getTransport transport}, this timeout can only happen if the
     * server actually fails to respond within the specified number of milliseconds.  For the "hiddenFrame" transport, this
     * timeout will occur for non-200 (HTTP_OK) responses. <p> If <code>timeout</code> is set to zero, the RPCManager will not
     * enforce a timeout for this request.  However, note that all browsers enforce their own timeouts on HTTP requests, and
     * may have different timeouts for different kinds of failures (no response at all from server, hung response after
     * receiving headers, hung response after receiving partial data, etc). Also, intervening web proxies or firewalls may
     * impose timeouts of their own. <p> As a rough rule of thumb, if your server response will have a lengthy pause before
     * data begins to be sent, 1-2 minutes is the maximum allowable pause for a public site and still may not work for a
     * minority of users, but up to 4 minutes may be allowable in a controlled environment (intranet or extranet with
     * well-known user base). <p> Above these limits, your code should return some kind of immediate response to the browser,
     * then kick off a server-side process to complete processing.  The browser can then either poll for completion, or use a
     * server-push notification system such as Smart GWT Real-Time Messaging (see <a href='http://smartclient.com/product'
     * target='_blank'>http://smartclient.com/product</a>).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param timeout New timeout value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#defaultTimeout
     */
    public RPCRequest setTimeout(Integer timeout) {
        return (RPCRequest)setAttribute("timeout", timeout);
    }

    /**
     * Sets the timeout on this request.  Default is to use {@link com.smartgwt.client.rpc.RPCManager#defaultTimeout
     * defaultTimeout}.   <p> If you're using {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing}, note that the
     * timeout setting derived from the last request in the queue is used for the entire queue.  If you want to override the
     * timeout for the queue, make sure to set your override at least on the last request in the queue. <p> For the
     * "xmlHttpRequest" {@link com.smartgwt.client.rpc.RPCRequest#getTransport transport}, this timeout can only happen if the
     * server actually fails to respond within the specified number of milliseconds.  For the "hiddenFrame" transport, this
     * timeout will occur for non-200 (HTTP_OK) responses. <p> If <code>timeout</code> is set to zero, the RPCManager will not
     * enforce a timeout for this request.  However, note that all browsers enforce their own timeouts on HTTP requests, and
     * may have different timeouts for different kinds of failures (no response at all from server, hung response after
     * receiving headers, hung response after receiving partial data, etc). Also, intervening web proxies or firewalls may
     * impose timeouts of their own. <p> As a rough rule of thumb, if your server response will have a lengthy pause before
     * data begins to be sent, 1-2 minutes is the maximum allowable pause for a public site and still may not work for a
     * minority of users, but up to 4 minutes may be allowable in a controlled environment (intranet or extranet with
     * well-known user base). <p> Above these limits, your code should return some kind of immediate response to the browser,
     * then kick off a server-side process to complete processing.  The browser can then either poll for completion, or use a
     * server-push notification system such as Smart GWT Real-Time Messaging (see <a href='http://smartclient.com/product'
     * target='_blank'>http://smartclient.com/product</a>).
     *
     * @return Current timeout value. Default value is null
     * @see com.smartgwt.client.rpc.RPCManager#defaultTimeout
     */
    public Integer getTimeout()  {
        return getAttributeAsInt("timeout");
    }
    

    /**
     * Selects the transport used for this RPCRequest.  If unset, the value of {@link
     * com.smartgwt.client.rpc.RPCManager#defaultTransport defaultTransport} will be used. <p> If you're using queueing, note
     * that all requests in the queue must use the same transport. If you attempt to send a request via a different transport
     * than those that are currently on the queue, it will be sent to the server separately, ahead of the queue, and a warning
     * will be logged to the Developer Console. <p> If you specify an unknown transport, an error will be logged to the
     * DeveloperConsole and {@link com.smartgwt.client.rpc.RPCManager#defaultTransport defaultTransport} will be used instead.
     * <p> If you specify the <code>xmlHttpRequest</code> transport and it is not available, a warning will be logged to the
     * Developer Console and the RPCManager will attempt to use the <code>hiddenFrame</code> transport instead for this
     * request.  Note that some features like {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString
     * serverOutputAsString} require the <code>xmlHttpRequest</code> transport and will not work if the
     * <code>xmlHttpRequest</code> transport is unavailable (this can happen if the end user is using Internet Explorer and has
     * disabled ActiveX).  You can check whether or not the <code>xmlHttpRequest</code> transport is currently available by
     * calling {@link com.smartgwt.client.rpc.RPCManager#xmlHttpRequestAvailable RPCManager.xmlHttpRequestAvailable()}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param transport New transport value. Default value is RPCManager.defaultTransport
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#defaultTransport
     */
    public RPCRequest setTransport(RPCTransport transport) {
        return (RPCRequest)setAttribute("transport", transport == null ? null : transport.getValue());
    }

    /**
     * Selects the transport used for this RPCRequest.  If unset, the value of {@link
     * com.smartgwt.client.rpc.RPCManager#defaultTransport defaultTransport} will be used. <p> If you're using queueing, note
     * that all requests in the queue must use the same transport. If you attempt to send a request via a different transport
     * than those that are currently on the queue, it will be sent to the server separately, ahead of the queue, and a warning
     * will be logged to the Developer Console. <p> If you specify an unknown transport, an error will be logged to the
     * DeveloperConsole and {@link com.smartgwt.client.rpc.RPCManager#defaultTransport defaultTransport} will be used instead.
     * <p> If you specify the <code>xmlHttpRequest</code> transport and it is not available, a warning will be logged to the
     * Developer Console and the RPCManager will attempt to use the <code>hiddenFrame</code> transport instead for this
     * request.  Note that some features like {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString
     * serverOutputAsString} require the <code>xmlHttpRequest</code> transport and will not work if the
     * <code>xmlHttpRequest</code> transport is unavailable (this can happen if the end user is using Internet Explorer and has
     * disabled ActiveX).  You can check whether or not the <code>xmlHttpRequest</code> transport is currently available by
     * calling {@link com.smartgwt.client.rpc.RPCManager#xmlHttpRequestAvailable RPCManager.xmlHttpRequestAvailable()}.
     *
     * @return Current transport value. Default value is RPCManager.defaultTransport
     * @see com.smartgwt.client.rpc.RPCManager#defaultTransport
     */
    public RPCTransport getTransport()  {
        return EnumUtil.getEnum(RPCTransport.values(), getAttribute("transport"));
    }
    

    /**
     * If true, an image is shown to the right of the cursor when {@link com.smartgwt.client.rpc.RPCRequest#getPromptStyle
     * promptStyle} is set to "cursor", otherwise the cursor itself is modified via css to the value of {@link
     * com.smartgwt.client.rpc.RPCRequest#getPromptCursor promptCursor}. <p> If left unspecified, the default value is set by
     * {@link com.smartgwt.client.rpc.RPCManager#useCursorTracker useCursorTracker}.
     *
     * @param useCursorTracker New useCursorTracker value. Default value is false
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#useCursorTracker
     * @see com.smartgwt.client.docs.RpcPrompt RpcPrompt overview and related methods
     */
    public RPCRequest setUseCursorTracker(boolean useCursorTracker) {
        return (RPCRequest)setAttribute("useCursorTracker", useCursorTracker);
    }

    /**
     * If true, an image is shown to the right of the cursor when {@link com.smartgwt.client.rpc.RPCRequest#getPromptStyle
     * promptStyle} is set to "cursor", otherwise the cursor itself is modified via css to the value of {@link
     * com.smartgwt.client.rpc.RPCRequest#getPromptCursor promptCursor}. <p> If left unspecified, the default value is set by
     * {@link com.smartgwt.client.rpc.RPCManager#useCursorTracker useCursorTracker}.
     *
     * @return Current useCursorTracker value. Default value is false
     * @see com.smartgwt.client.rpc.RPCManager#useCursorTracker
     * @see com.smartgwt.client.docs.RpcPrompt RpcPrompt overview and related methods
     */
    public boolean getUseCursorTracker()  {
        Boolean result = getAttributeAsBoolean("useCursorTracker", true);
        return result == null ? false : result;
    }
    

    /**
     * Indicates whether this request should use the HttpProxyServlet in order to enable contacting hosts other than the origin
     * server (available only in Pro Edition or better). <P> When various UI components issues requests automatically, or when
     * a call to {@link com.smartgwt.client.rpc.RPCManager#sendProxied RPCManager.sendProxied()} is made, the HttpProxy will
     * automatically be used for a URL that starts with "http" and uses a hostname other than "localhost" or
     * <code>window.location.hostname</code>, or if the port number differs. <P> <code>rpcRequest.useHttpProxy</code> should
     * only be used to force requests to go through the HttpProxy when the above rules don't work, or to avoid using the
     * HttpProxy when contacting hosts that allow cross-site calls via the <a
     * href='http://www.google.com/search?q=http+access+control' target='_blank'>Http Access Control</a> standard. <P> You can
     * also set {@link com.smartgwt.client.rpc.RPCManager#useHttpProxy useHttpProxy}:false to avoid ever using the
     * HttpProxyServlet.
     *
     * @param useHttpProxy New useHttpProxy value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setUseHttpProxy(Boolean useHttpProxy) {
        return (RPCRequest)setAttribute("useHttpProxy", useHttpProxy);
    }

    /**
     * Indicates whether this request should use the HttpProxyServlet in order to enable contacting hosts other than the origin
     * server (available only in Pro Edition or better). <P> When various UI components issues requests automatically, or when
     * a call to {@link com.smartgwt.client.rpc.RPCManager#sendProxied RPCManager.sendProxied()} is made, the HttpProxy will
     * automatically be used for a URL that starts with "http" and uses a hostname other than "localhost" or
     * <code>window.location.hostname</code>, or if the port number differs. <P> <code>rpcRequest.useHttpProxy</code> should
     * only be used to force requests to go through the HttpProxy when the above rules don't work, or to avoid using the
     * HttpProxy when contacting hosts that allow cross-site calls via the <a
     * href='http://www.google.com/search?q=http+access+control' target='_blank'>Http Access Control</a> standard. <P> You can
     * also set {@link com.smartgwt.client.rpc.RPCManager#useHttpProxy useHttpProxy}:false to avoid ever using the
     * HttpProxyServlet.
     *
     * @return Current useHttpProxy value. Default value is null
     */
    public Boolean getUseHttpProxy()  {
        return getAttributeAsBoolean("useHttpProxy", true);
    }
    

    /**
     * When set to true, assume the request is not going to the Smart GWT server, and hence send a simple HTTP request that
     * does not use Smart GWT-specific request encoding. <P> Values specified in {@link
     * com.smartgwt.client.rpc.RPCRequest#getParams params} are sent to to the server as HTTP request parameters.  If {@link
     * com.smartgwt.client.rpc.RPCRequest#getHttpMethod httpMethod} is "GET", parameters appear in the request URL, otherwise
     * if httpMethod is "POST", parameters are encoded in the request body (exactly like an HTML form does).  These parameters
     * are then accessible via typical server-side APIs for retrieving HTTP parameters, eg,
     * servletRequest.getParameter(paramName) in Java Servlets.   <P> Note that if {@link
     * com.smartgwt.client.rpc.RPCRequest#getHttpMethod httpMethod} method is POST and {@link
     * com.smartgwt.client.rpc.RPCRequest#getData data} is supplied, {@link com.smartgwt.client.rpc.RPCRequest#getData data} is
     * assumed to be a string to post as the HTTP request body, and {@link com.smartgwt.client.rpc.RPCRequest#getParams params}
     * are sent as URL parameters instead.  This usage is for sending custom request bodies such as the XML payloads used for
     * SOAP.  In this case, {@link com.smartgwt.client.rpc.RPCRequest#getContentType contentType} is typically also set to
     * indicate the content type of the request body. <p> Setting <code>useSimpleHttp</code> to true also automatically sets
     * {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} to true as well.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useSimpleHttp New useSimpleHttp value. Default value is false
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setUseSimpleHttp(Boolean useSimpleHttp) {
        return (RPCRequest)setAttribute("useSimpleHttp", useSimpleHttp);
    }

    /**
     * When set to true, assume the request is not going to the Smart GWT server, and hence send a simple HTTP request that
     * does not use Smart GWT-specific request encoding. <P> Values specified in {@link
     * com.smartgwt.client.rpc.RPCRequest#getParams params} are sent to to the server as HTTP request parameters.  If {@link
     * com.smartgwt.client.rpc.RPCRequest#getHttpMethod httpMethod} is "GET", parameters appear in the request URL, otherwise
     * if httpMethod is "POST", parameters are encoded in the request body (exactly like an HTML form does).  These parameters
     * are then accessible via typical server-side APIs for retrieving HTTP parameters, eg,
     * servletRequest.getParameter(paramName) in Java Servlets.   <P> Note that if {@link
     * com.smartgwt.client.rpc.RPCRequest#getHttpMethod httpMethod} method is POST and {@link
     * com.smartgwt.client.rpc.RPCRequest#getData data} is supplied, {@link com.smartgwt.client.rpc.RPCRequest#getData data} is
     * assumed to be a string to post as the HTTP request body, and {@link com.smartgwt.client.rpc.RPCRequest#getParams params}
     * are sent as URL parameters instead.  This usage is for sending custom request bodies such as the XML payloads used for
     * SOAP.  In this case, {@link com.smartgwt.client.rpc.RPCRequest#getContentType contentType} is typically also set to
     * indicate the content type of the request body. <p> Setting <code>useSimpleHttp</code> to true also automatically sets
     * {@link com.smartgwt.client.rpc.RPCRequest#getServerOutputAsString serverOutputAsString} to true as well.
     *
     * @return Current useSimpleHttp value. Default value is false
     */
    public Boolean getUseSimpleHttp()  {
        Boolean result = getAttributeAsBoolean("useSimpleHttp", true);
        return result == null ? false : result;
    }
    

    /**
     * If set true, tells the server to use strict JSON format when serializing the response data.  If set false, tells the
     * server to use a more permissive encoding that is still valid JS, but is not technically valid JSON.  The default value
     * of null tells the server to use the  default global setting (see below). <p> To enable this globally for all responses
     * you can set <code>RPCManager.useStrictJSON</code> in {@link com.smartgwt.client.docs.Server_properties
     * server.properties}.  If the global flag is not set either  way in <code>server.properties</code>, it defaults to false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useStrictJSON New useStrictJSON value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.data.DSRequest#setUseStrictJSON
     */
    public RPCRequest setUseStrictJSON(Boolean useStrictJSON) {
        return (RPCRequest)setAttribute("useStrictJSON", useStrictJSON);
    }

    /**
     * If set true, tells the server to use strict JSON format when serializing the response data.  If set false, tells the
     * server to use a more permissive encoding that is still valid JS, but is not technically valid JSON.  The default value
     * of null tells the server to use the  default global setting (see below). <p> To enable this globally for all responses
     * you can set <code>RPCManager.useStrictJSON</code> in {@link com.smartgwt.client.docs.Server_properties
     * server.properties}.  If the global flag is not set either  way in <code>server.properties</code>, it defaults to false.
     *
     * @return Current useStrictJSON value. Default value is null
     * @see com.smartgwt.client.data.DSRequest#getUseStrictJSON
     */
    public Boolean getUseStrictJSON()  {
        return getAttributeAsBoolean("useStrictJSON", true);
    }
    
    

    /**
     * With willHandleError:false, rpcResponses that indicate an error go through centralized handling in the RPCManager and
     * rpcRequest.callback is never invoked. <P> Setting willHandleError:true means that your rpcRequest.callback will receive
     * rpcResponses that have an error status and must handle them. <P> See also the error handling section in the {@link
     * com.smartgwt.client.rpc.RPCManager} docs.
     *
     * @param willHandleError New willHandleError value. Default value is false
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager
     * @see com.smartgwt.client.docs.ErrorHandling ErrorHandling overview and related methods
     */
    public RPCRequest setWillHandleError(Boolean willHandleError) {
        return (RPCRequest)setAttribute("willHandleError", willHandleError);
    }

    /**
     * With willHandleError:false, rpcResponses that indicate an error go through centralized handling in the RPCManager and
     * rpcRequest.callback is never invoked. <P> Setting willHandleError:true means that your rpcRequest.callback will receive
     * rpcResponses that have an error status and must handle them. <P> See also the error handling section in the {@link
     * com.smartgwt.client.rpc.RPCManager} docs.
     *
     * @return Current willHandleError value. Default value is false
     * @see com.smartgwt.client.rpc.RPCManager
     * @see com.smartgwt.client.docs.ErrorHandling ErrorHandling overview and related methods
     */
    public Boolean getWillHandleError()  {
        Boolean result = getAttributeAsBoolean("willHandleError", true);
        return result == null ? false : result;
    }
    

    /**
     * In browsers that support <a href='http://www.w3.org/TR/cors/' target='_blank'>Cross-Origin Resource Sharing</a> and <a
     * href='http://caniuse.com/#feat=xhr2' target='_blank'>XMLHttpRequest 2</a>, and where the service at the {@link
     * com.smartgwt.client.rpc.RPCRequest#getActionURL actionURL} allows the origin to send credentials (see <a
     * href='http://www.w3.org/TR/cors/#access-control-allow-credentials-response-header'
     * target='_blank'><code>Access-Control-Allow-Credentials</code></a>), should <a
     * href='http://www.w3.org/TR/cors/#user-credentials' target='_blank'>user credentials</a> such as cookies, HTTP
     * authentication, and client-side SSL certificates be sent with the actual CORS request? <p> This setting only applies
     * when the request {@link com.smartgwt.client.rpc.RPCRequest#getTransport transport} is  {@link
     * com.smartgwt.client.types.RPCTransport#XMLHTTPREQUEST}. <p> Note that Internet Explorer 10 and 11 do not send cookies as
     * part of user credentials: <a href='https://connect.microsoft.com/IE/Feedback/Details/759587/' target='_blank'>IE10
     * doesn't support cookies on cross origin XMLHttpRequest withCredentials=true</a>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param withCredentials New withCredentials value. Default value is null
     * @return {@link com.smartgwt.client.rpc.RPCRequest RPCRequest} instance, for chaining setter calls
     */
    public RPCRequest setWithCredentials(Boolean withCredentials) {
        return (RPCRequest)setAttribute("withCredentials", withCredentials);
    }

    /**
     * In browsers that support <a href='http://www.w3.org/TR/cors/' target='_blank'>Cross-Origin Resource Sharing</a> and <a
     * href='http://caniuse.com/#feat=xhr2' target='_blank'>XMLHttpRequest 2</a>, and where the service at the {@link
     * com.smartgwt.client.rpc.RPCRequest#getActionURL actionURL} allows the origin to send credentials (see <a
     * href='http://www.w3.org/TR/cors/#access-control-allow-credentials-response-header'
     * target='_blank'><code>Access-Control-Allow-Credentials</code></a>), should <a
     * href='http://www.w3.org/TR/cors/#user-credentials' target='_blank'>user credentials</a> such as cookies, HTTP
     * authentication, and client-side SSL certificates be sent with the actual CORS request? <p> This setting only applies
     * when the request {@link com.smartgwt.client.rpc.RPCRequest#getTransport transport} is  {@link
     * com.smartgwt.client.types.RPCTransport#XMLHTTPREQUEST}. <p> Note that Internet Explorer 10 and 11 do not send cookies as
     * part of user credentials: <a href='https://connect.microsoft.com/IE/Feedback/Details/759587/' target='_blank'>IE10
     * doesn't support cookies on cross origin XMLHttpRequest withCredentials=true</a>.
     *
     * @return Current withCredentials value. Default value is null
     */
    public Boolean getWithCredentials()  {
        return getAttributeAsBoolean("withCredentials", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



	/**
     * This attribute specifies the payload of the RPCRequest.     
     * When using the {@link com.smartgwt.client.rpc.RPCRequest#getIscServer Smart GWT server}, objects sent to the server as 
     * <code>request.data</code> will be available on the server-side <code>RPCRequest</code> object as Java Objects. This is
     * achieved by serializing the client side data in a JSON type format and generating Java Objects on the server from this
     * serialized data. 
     * <P>
     * If the client side <code>request.data</code> is set to a Java object in your SmartGWT code on the client side, 
     * logic in your server side code will be passed the following equivalent objects:
     * 
     *  <table class='normal' border='1'>   
     *  <tr><td><b>Client</b></td>     <td><b>Server Type</b></td></tr>
     *  <tr><td>boolean primitive or Boolean</td><td>Boolean</td></tr>
     *  <tr><td>Non-fractional numeric value<br>(e.g: int, Integer, long, Long)</td><td>Long</td></tr>
     *  <tr><td>Fractional numeric value<br>(e.g:float, Float, double, Double)</td><td>Double</td></tr>
     *  <tr><td>String</td><td>String</td></tr>
     *  <tr><td>Date</td><td>Date</td></tr>
     *  <tr><td>List, Set, Iterator</td><td>List</td></tr>
     *  <tr><td>Map</td><td>Map</td></tr>
     *  <tr><td>Record</td><td>Map</td></tr>
     *  <tr><td>RecordList</td><td>List of Map</td></tr>
     *  <tr><td>ResultSet</td><td>List of Map <br>(containing only loaded rows if the ResultSet has a partial cache on the client)</td></tr>
     *  </table>
     *  
     * <br><br> Note that the order of keys/values in the Maps created on the server is not guaranteed because
     * JavaScript Object literals do not guarantee order. <p> Server->client conversion follows this table as well, with
     * some extras.  See the toJS() method on JSTranslater in the server documentation for a description of additional
     * behaviors. <P> When <b>not</b> communicating with the Smart GWT server, <code>rpcRequest.data</code> becomes simple HTTP
     * parameters or an HTTP request body - see {@link com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp useSimpleHttp} for
     * details.
     * 
     *
     * @param data data Default value is null
     * @see com.smartgwt.client.rpc.RPCResponse#getDataAsMap()
     * @see com.smartgwt.client.rpc.RPCResponse#getDataAsObject()
     * @see com.smartgwt.client.rpc.RPCResponse#getDataAsString()
     */
    public void setData(JavaScriptObject data) {
        setAttribute("data", data);
    }

    /**
     * Returns the payload of this request to be sent to the server, as a JavaScriptObject.
     * <P>
     * When using the {@link com.smartgwt.client.rpc.RPCRequest#getIscServer Smart GWT server}, objects sent to the server as 
     * <code>request.data</code> will be available on the server-side <code>RPCRequest</code> object as Java Objects. This is
     * achieved by serializing the client side data in a JSON type format and generating Java Objects on the server from this
     * serialized data. 
     * <P>
     * If the client side <code>request.data</code> is set to a Java object in your SmartGWT code on the client side, 
     * logic in your server side code will be passed the following equivalent objects:
     * 
     *  <table class='normal' border='1'>   
     *  <tr><td><b>Client</b></td>     <td><b>Server Type</b></td></tr>
     *  <tr><td>boolean primitive or Boolean</td><td>Boolean</td></tr>
     *  <tr><td>Non-fractional numeric value<br>(e.g: int, Integer, long, Long)</td><td>Long</td></tr>
     *  <tr><td>Fractional numeric value<br>(e.g:float, Float, double, Double)</td><td>Double</td></tr>
     *  <tr><td>String</td><td>String</td></tr>
     *  <tr><td>Date</td><td>Date</td></tr>
     *  <tr><td>List, Set, Iterator</td><td>List</td></tr>
     *  <tr><td>Map</td><td>Map</td></tr>
     *  <tr><td>Record</td><td>Map</td></tr>
     *  <tr><td>RecordList</td><td>List of Map</td></tr>
     *  <tr><td>ResultSet</td><td>List of Map <br>(containing only loaded rows if the ResultSet has a partial cache on the client)</td></tr>
     *  </table>
     *  
     * <br><br> Note that the order of keys/values in the Maps created on the server is not guaranteed because
     * JavaScript Object literals do not guarantee order. <p> Server->client conversion follows this table as well, with
     * some extras.  See the toJS() method on JSTranslater in the server documentation for a description of additional
     * behaviors. <P> When <b>not</b> communicating with the Smart GWT server, <code>rpcRequest.data</code> becomes simple HTTP
     * parameters or an HTTP request body - see {@link com.smartgwt.client.rpc.RPCRequest#getUseSimpleHttp useSimpleHttp} for
     * details.
     * 
     * @see com.smartgwt.client.rpc.RPCResponse#getDataAsMap()
     * @see com.smartgwt.client.rpc.RPCResponse#getDataAsObject()
     * @see com.smartgwt.client.rpc.RPCResponse#getDataAsString()
     */
    public JavaScriptObject getData() {
        return getAttributeAsJavaScriptObject("data");
    }

    public String getDataAsString() {
        return getAttributeAsString("data");
    }

}
