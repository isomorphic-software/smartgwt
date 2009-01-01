/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */

 



//>	@class RPCManager
// 
// RPCManager is a static singleton class that manages transparent client/server RPC (remote
// procedure call).  This class provides a generic, low-level client/server communication
// integration point.  You can use it to send arbitrary data to a URL of your choosing on the
// server and optionally be called back with server-returned data when the server replies.  
// You can process the RPC request in a JSP, Servlet or Filter on the server.
// <P>
// SmartClient's powerful +link{DataBoundComponent,DataBoundComponents} automatically issue
// RPCs as necessary, based on the 
// +link{group:dataSourceOperations,DataSource protocol}.  To integrate DataBoundComponents
// with your server, +link{group:clientServerIntegration,start here}.
// <P>
// <u>Simple example (client code):</u>
// <P><code>
// var data = { here: "is some data", to: ["send to the server"]};<br>
// RPCManager.sendRequest({ data: data, callback: "myCallback(data)", actionURL: "/rpcHandler.jsp"});<br>
// function myCallback(data) { alert("response from the server: " + data); }
// </code><br><br>
// <u>Simple example (server code: /rpcHandler.jsp):</u>
// <br><br><code>
// RPCManager rpc = new RPCManager(request, response, out);<br>
// Object data = rpc.getData();<br>
// System.out.println("client sent: " + data.toString());<br>
// rpc.send("here's a response");<br>
// </code>
// <P>
// Note that, while the example above uses the SmartClient Java Server, the RPCManager is also
// capable of issuing RPCs that do not require a SmartClient server.  See
// +link{group:clientDataIntegration,Client-Side Data Integration} for details.
// <P>
// <u><b>Queuing</b></u>
// <br>
// Because of browser limitations on the total number of simultaneous HTTP connections to a given
// server, batching multiple RPC requests into a single HTTP request is highly advisable whenever
// possible.  The RPCManager provides a queuing mechanism that allows this.
// <br><br>
// <u>Queuing example (client code):</u>
// <br><br><code>
// RPCManager.startQueue();<br>
// RPCManager.send("a string of data", "myCallback(data)", {actionURL: "/rpcHandler.jsp"});<br>
// RPCManager.sendRequest({ data: ["some", "more data", 2], callback: "myCallback(data)", actionURL: "/rpcHandler.jsp"});<br>
// RPCManager.sendRequest({ data: "different callback", callback: "myCallback2(data)", actionURL: "/rpcHandler.jsp"});<br>
// RPCManager.sendQueue()<br>
// function myCallback(data) { alert("response from the server: " + data); }<br>
// function myCallback2(data) { alert("response from the server (other callback): " + data); }
// </code><br><br>
// <u>Queuing example (server code: /rpcHandler.jsp):</u>
// <br><br><code>
// RPCManager rpc = new RPCManager(request, response, out);<br>
// for(Iterator i = rpc.getRequests().iterator(); i.hasNext();) {<br>
// &nbsp;&nbsp;&nbsp;&nbsp;RPCRequest rpcRequest = (RPCRequest)i.next();<br>
// &nbsp;&nbsp;&nbsp;&nbsp;Object data = rpcRequest.getData();<br>
// &nbsp;&nbsp;&nbsp;&nbsp;System.out.println("client sent:" + data.toString());<br>
// &nbsp;&nbsp;&nbsp;&nbsp;//send back the data sent to us by the client<br>
// &nbsp;&nbsp;&nbsp;&nbsp;rpc.send(rpcRequest, new RPCResponse(data));<br>
// }<br>
// </code>
// <br><br>
// <u><b>Error Handling</b></u>
// <br>
// The +link{RPCResponse} object has an integer status field that the RPCManager inspects when
// the response is received from the server. If the value of this field is less than zero, the
// request is considered to have failed.  Otherwise it is considered to have succeeded.  This
// value is settable via the setStatus() method call on the RPCResponse server-side object.
// <br><br>
// If the status field shows a failure, the RPCManager will, by default, show a dialog with the
// contents of the +link{rpcRequest.data} field (which is assumed to contain a 
// meaningful description of the error that occured).  If you specified a callback in your
// RPCRequest, it will <b>not</b> be called if the status shows a failure (see below for how to
// change this).
// <br><br>
// If the status field shows success, the RPCManager takes no special action.
// <br><br>
// The built-in status codes and default behavior are there for convenience.  You can choose to
// completely ignore it and handle errors as you see fit (for example by encoding them into the data
// field returned by the server, and always setting the RPCResponse status field to a success
// value).  In fact, the status field is automatically set to a success code
// (RPCResponse.STATUS_SUCCESS) by the constructor of the RPCResponse object on the server. 
// <br><br>
// If you choose to use the status field, but want to handle the errors yourself in your callback
// (and suppress the default error dialog popped up by the RPCManager), simply specify the
// +link{rpcRequest.willHandleError,willHandleError:true} on your RPCRequest object.  This
// allows you to use the RPCManager.sendError() convenience methods on the server without the
// default error handling behavior on the client.
//
// @treeLocation Client Reference/RPC
// @visibility external
//<
isc.ClassFactory.defineClass("RPCManager");
isc.RPC = isc.rpc = isc.RPCManager;
//>Offline
isc.Page.observe(isc, "goOffline", "isc.rpc.goOffline()");
isc.Page.observe(isc, "goOnline", "isc.rpc.goOnline()");
//<Offline

// ---------------------------------------------------------------------------------------
//>	@class RPCRequest
// 
// Encapsulates a client/server RPC request.  You'll need to provide an instance of this class (or a
// constructor for it) to the +link{classMethod:RPCManager.sendRequest()} method.  If you use the 
// +link{classMethod:RPCManager.send()} method, an instance of RPCRequest will be created for you.
//
// @see RPCManager.send()
// @see RPCManager.sendRequest()
// @visibility external
// @treeLocation Client Reference/RPC
//<
isc.ClassFactory.defineClass("RPCRequest");

isc.RPCRequest.addClassMethods({
    //> @classMethod RPCRequest.create()
    // RPCRequest shouldn't be created directly. Instead, pass +link{Properties} to 
    // +link{RPCManager.sendRequest()} and +link{RPCManager.send()}.
    // @visibility external
    //<
    // Log a warning if called directly
    create : function (A,B,C,D,E,F,G,H,I,J,K,L,M) {
        this.logWarn(
            "An RPCRequest does not need to be created. Instead, pass properties to methods " +
            "such as RPCManager.send() and RPCManger.sendRequest."
        );
       
        return isc.addProperties({}, A,B,C,D,E,F,G,H,I,J,K,L,M);
    }
});

//> @attr rpcRequest.data (any serializeable : null : IRW)
//
// This attribute specifies the payload of the RPCRequest.  When using the SmartClient server,
// any JavaScript simple type or arbitrarily nested set of Objects and Arrays can be sent
// to server and automatically translated to Java Objects.  Here are the 
// mapping of JavaScript types to their corresponding server object types:<br><br>
//
// <table class='normal' border='1'>
//   <tr><td><b>JS Type</b></td>     <td><b>Java Type</b></td> <td><b>C# Type</b></td> <td><b>Perl Type</b></td></tr>
//
//   <tr><td>Object: {}</td>         <td>Map</td>              <td>IDictionary</td>      <td>Associative Array: {}</td></tr>
//   <tr><td>Array: []</td>          <td>List</td>             <td>IList</td>      <td>Array: []</td></tr>
//   <tr><td>String</td>             <td>String</td>           <td>string</td>         <td>string</td></tr>
//   <tr><td>Number</td>             <td>Long|Double</td>      <td>long|double</td>    <td>string</td></tr>
//   <tr><td>Boolean</td>            <td>Boolean</td>          <td>bool</td>           <td>string</td></tr>
//   <tr><td>Date</td>               <td>java.util.Date</td>   <td>DateTime</td>       <td>string</td></tr>
// 
// </table>
// <br><br>
// Note that the order of keys/values in the Maps created on the server is not guaranteed
// because JavaScript Object literals do not guarantee order.
// <p>
// Server->client conversion follows the this table as well, with some extras.  See the toJS()
// method on JSTranslater in the server documentation for a description of additional
// behaviors.
// <P>
// When <b>not</b> communicating with the SmartClient server, <code>rpcRequest.data</code>
// becomes simple HTTP parameters or an HTTP request body - see +link{rpcRequest.useSimpleHttp}
// for details.
//
// @visibility external
//<

//> @attr rpcRequest.actionURL (URL : RPCManager.actionURL : IRW)
//
// Overrides RPCManager.actionURL for this request only.  If you're using queuing, note that queues
// as per-URL - in other words all RPCRequests in a queue must go to a single URL.  If you attempt
// to send a request with an actionURL that is different from those already in the queue, it
// will be sent to the server separately, ahead of the queue,  and a warning will be logged to
// the Developer Console.
// 
// @see classAttr:RPCManager.actionURL
//
// @visibility external
//<

//>@groupDef    rpcPrompt
// The properties in this group all deal with setting and styling a modal prompt during an RPC
// call to the server.
// @visibility external
//<

//> @attr rpcRequest.promptStyle (PromptStyle : RPCManager.promptStyle : IRW)
// Controls the prompt style for this request only.  Defaults to
// +link{RPCManager.promptStyle}.
//
// @see RPCManager.promptStyle
// @group rpcPrompt
// @visibility external
//<

//> @classAttr rpcRequest.useCursorTracker (boolean : platform-dependent : IRW)
//
// If true, an image is shown to the right of the cursor when +link{rpcRequest.promptStyle} is
// set to "cursor", otherwise the cursor itself is modified via css to the value of
// +link{rpcRequest.promptCursor}.  The default is platform-dependent.  In Safari, IE 5.5 and
// Firefox 1.0 the default is true, on all other platforms it is false.  The reason for this
// split is that the above browsers require that the cursor move before CSS settings are
// re-evaluated - this means the progress cursor can stick until the user moves the mouse.
// <p>
// If left unspecified, the default value is set by +link{RPCManager.useCursorTracker}.
//
// @see RPCManager.useCursorTracker
// @group rpcPrompt
// @visibility external
//<

//> @attr rpcRequest.promptCursor (String : browser-dependent : IRW)
// Controls the cursor shown when +link{rpcManager.promptStyle} is set to
// <code>"cursor"</code> for this request only. Defaults to +link{RPCManager.promptCursor}.
// <p>
// In Safari, IE 5.5 and Firefox 1.0 the default value is "wait", on all other platforms it is
// "progress".  The reason for this split is that the above-mentioned browsers do not support
// CSS2.1 - which is required for the "progress" cursor type.
//
// @see RPCManager.promptCursor
// @group rpcPrompt
// @visibility external
//<


//> @attr rpcRequest.prompt (string : RPCManager.defaultPrompt : IRW)
//
// Overrides RPCManager.defaultPrompt for this request only.  If you're using queuing, note that the
// prompt string from the first request in the queue is the one that is shown to the user.
// 
// @see classAttr:RPCManager.defaultPrompt
// @see classAttr:RPCManager.showPrompt
// @see classAttr:RPCManager.promptStyle
// @see classAttr:RPCManager.promptCursor
// @see attr:rpcRequest.showPrompt
// @see attr:rpcRequest.promptStyle
// @see attr:rpcRequest.promptCursor
//
// @group rpcPrompt
// @visibility external
//<

//> @attr rpcRequest.showPrompt (boolean : RPCManager.showPrompt : IRW)
//
// Overrides RPCManager.showPrompt for this request only.  If you're using queuing, note that
// if any of the requests in the queue specify showPrompt:true, then a prompt will be shown for
// the entire queue with the prompt text of the first request in the queue to specify a custom
// prompt if promptStyle is set to "dialog".  If promptStyle is set to "cursor" for the request
// that specified showPrompt: true, then the entire queue uses the "cursor" style for the
// prompt.
//
// @see classAttr:RPCManager.showPrompt
// @group rpcPrompt
// @visibility external
//<

//> @attr rpcRequest.callback (RPCCallback : null : IRW)
// 
// If you expect to receive a response to your RPC request, you can specify a callback that
// will be called with an instance or RPCResponse class as sent by the server.  Queuing does
// not affect callbacks in any way - your specified callback will be invoked for each
// RPCRequest that contained a callback regardless of whether the request was sent as part of a
// queue or not.
//
// @visibility external
//<

//> @attr rpcRequest.clientContext (Object : null : IRW)
// 
// An object to be held onto for the duration of the RPC turnaround to track
// application-specific context.
// <br>
// When an RPC turnaround completes, the <code>clientContext</code> is available in the
// +link{type:RPCCallback} as <code>rpcResponse.clientContext</code>.  The
// <code>clientContext</code> is never sent to the server.
// <br>
// The <code>clientContext</code> is useful for holding onto state that will be used when the
// +link{type:RPCCallback} fires, such as the name of a component that will receive the
// returned data.
// 
// @see RPCResponse.clientContext
//
// @visibility external
//<

//> @attr rpcRequest.willHandleError (boolean : false : IRW)
//
// With willHandleError:false, rpcResponses that indicate an error go through centralized
// handling in the RPCManager and rpcRequest.callback is never invoked.
// <P>
// Setting willHandleError:true means that your rpcRequest.callback will receive rpcResponses
// that have an error status and must handle them.
// <P>
// See also the error handling section in the +link{class:RPCManager} docs.
// 
// @see class:RPCManager
//
// @visibility external
//<

//> @attr rpcRequest.timeout (number : RPCManager.defaultTimeout : IRWA)
//
// Overrides RPCManager.defaultTimeout for this request only.  If you're using queuing, note
// that the timeout setting derived from the last request in the queue is used for the entire
// queue.  If you want to override the timeout for the queue, make sure to set your override at
// least on the last request in the queue.
//
// @see classAttr:RPCManager.defaultTimeout
//
// @visibility external
//<

//> @attr rpcRequest.clientOnly (boolean : false : IRWA)
// 
// Used for testing/prototyping without a server.  <code>clientOnly</code> requests don't get
// sent to the server, but the standard callback chain is still invoked.  If all requests in a
// transaction are clientOnly then the callbacks are called immediately otherwise they're
// called when the server returns responses to the non-clientOnly requests.
// 
// @visibility internal
//<

//> @attr rpcRequest.params (Object, others - see below : null : IRW)
// 
// Values to be sent as simple HTTP params, as a JavaScript Object where each property/value
// pair will become an HTTP parameter name and value.  These parameters are then accessible on
// the server, for example, using servletRequest.getParameter(paramName) in Java Servlets.  
// <P>
// This API is primarily used in combination with +link{rpcRequest.useSimpleHttp}.
// <P>
// When contacting the SmartClient server, setting <code>params</code> is an opportunity to
// send additional data aside from the main +link{rpcRequest.data} payload; this is useful for 
// adding data to DataSource requests which will be kept separate from the automatically sent
// DataSource data.
// <P>
// Note that in contrast to +link{rpcRequest.data} object, the data in
// <code>rpcRequest.params</code> is not serialized/deserialized by the SmartClient server, and
// all values arrive on the server as String type (like HTTP parameters always do).
// <p>
// The params value can also be a componentID or component instance that provides a method
// getValues() that returns an Object literal.  SmartClient components
// +link{class:DynamicForm}, +link{class:ValuesManager} are two such classes.  Lastly, you may
// specify the ID of a native form element (retreivable via getElementById()) and the params
// will be populated from there.  If there is an error resolving your params directive, it will
// be logged to the Developer Console.
// <p>
// Note: The params are submitted once per http transaction.  If you are using 
// +link{RPCManager.startQueue(),request queuing} to bundle multiple RPCRequests or DSRequests
// into a single HTTP turnaround, the params from the various RPCRequests will be merged,
// with the later-queued transactions winning on parameter name collisions.  A warning will be
// logged in the Developer Console if multiple RPCRequests specified params.
//
// @visibility external
//<

//> @attr rpcRequest.evalResult (boolean : false : IRWA)
// 
// This works similarly to +link{RPCRequest.serverOutputAsString} except the resulting String
// is automatically evaluated as JavaScript.  The result of the evaluation is then passed to
// any specified +link{RPCRequest.callback} as +link{RPCResponse.data}.
// <p>
// This feature can be used to dynamically load new application modules into a running
// application.  An RPCRequest with <code>evalResult</code> enabled can be used to fetch a
// static .js file or JavaScript dynamically generated by the server.  The returned JavaScript
// can contain anything that a JavaScript file loaded at init time can contain, including new
// views and new SmartClient class definitions.
// <p>
// <i>Example usage with +link{RPCManager.sendRequest()}:</i>
// <pre>
// isc.RPCManager.sendRequest({
//     evalResult:true,
//     actionURL:"js/loadLabel.js",
//     evalVars:{var1:"A Value"}
// });
// </pre>
// This call would execute the code from <code>loadLabel.js</code>, and make the variable
// <code>var1</code> available to that code. Therefore if the .js file contained this code:
// <pre>
// isc.Label.create({
//     contents:var1
// })
// </pre>
// A label would be created with contents set to the value of <code>var1</code> - the string
// <code>"A Value"</code>.
// 
// <p>
// This feature relies on the XMLHttpRequest object which can be disabled by end-users in some
// supported browsers.  See +link{group:platformDependencies} for more information.
//
// @see class:ViewLoader
// @see rpcRequest.evalVars
// @group viewLoading
// @visibility external
//<

//> @attr rpcRequest.evalVars (Object : null : IRWA)
// 
// If you've set +link{RPCRequest.evalResult} : true, then the property values of this object
// will be available in the evaluation scope of the result under the variable names
// specified by the property names. 
// <p>
// So e.g. if evalVars is: <code>{foo: "bar"}</code> then a reference to the
// variable <code>foo</code> in the result will evaluate to <code>"bar"</code>.
//
// @group viewLoading
// @visibility external
//<

//> @attr rpcRequest.callbackParam (String : "callback" : IRW) 
//
// For use only with the <code>scriptInclude</code> transport, this attribute specifies the
// name of the parameter from which the server expects to read the name of the JavaScript
// callback function.
// <P>
// SmartClient will use the callback mechanism provided by the server, then call
// +link{rpcRequest.callback} normally.
// <p>
// This attribute is ignored by all other transports.
//
// @visibility external
//<

//> @attr rpcRequest.suppressAutoDraw (boolean : true : IRWA)
// 
// If +link{attr:RPCRequest.evalResult} is set, setting this property to true causes
// +link{attr:Canvas.autoDraw} to be set to false for the duration of the result evaluation -
// which is generally what you want if you're returning new components from the server.
//
// @visibility internal
//<

//> @attr rpcRequest.serverOutputAsString (boolean : false : IRWA)
//
// Setting this flag makes the body of the HTTP response available as a String in the
// +link{RPCRequest.callback} as +link{RPCResponse.data}.  This is typically only useful if you
// are sending a request that will <b>not</b> be received by the SmartClient Java Server,
// however in that case, set +link{useSimpleHttp}:true instead, which implies
// <code>serverOutputAsString:true</code>.
// <P>
// <code>serverOutputAsString:true</code> allows you to, for example, load the contents of
// static files off your webserver into a string for processing on the client with no server
// support.  The +link{RPCRequest.actionURL} must be in the same domain as the current page for
// this to work.
// <p>
// This feature relies on the XMLHttpRequest object which can be disabled by end-users in some
// supported browsers.  See +link{group:platformDependencies} for more information.
// <p>
// Generally this API is used for either +link{group:nonJavaBackend,non-Java backends} 
// or for advanced usage such as content that requires processing before it can be used in
// SmartClient components (such as client-side web scraping).  Note that SmartClient provides
// higher-level APIs for loading common types of data, see eg +link{HTMLFlow} for HTML content,
// +link{ViewLoader} for loading SmartClient components, +link{XMLTools.loadXML()} for loading
// XML, +link{RPCRequest.evalResult} for loading +externalLink{http://www.json.org/,JSON}, and
// +link{DataSource} for loading structured data in various formats.
//
// @visibility external
//<

//> @attr rpcRequest.transport (RPCTransport : RPCManager.defaultTransport : IRWA)
//
// Selects the transport used for this RPCRequest.  If unset, the value of
// +link{RPCManager.defaultTransport} will be used.
// <p>
// If you're using queueing, note that all requests in the queue must use the same transport.
// If you attempt to send a request via a different transport than those that are currently on
// the queue, it will be sent to the server separately, ahead of the queue, and a warning will
// be logged to the Developer Console.
// <p>
// If you specify an unknown transport, an error will be logged to the DeveloperConsole and
// +link{RPCManager.defaultTransport} will be used instead.
// <p>
// If you specify the <code>xmlHttpRequest</code> transport and it is not available, a warning will be
// logged to the Developer Console and the RPCManager will attempt to use the
// <code>hiddenFrame</code> transport instead for this request.  Note that some features like
// +link{RPCRequest.serverOutputAsString} requre the <code>xmlHttpRequest</code> transport and will not
// work if the <code>xmlHttpRequest</code> transport is unavailable (this can happen if the end user is
// using Internet Explorer and has disabled ActiveX).  You can check whether or not the
// <code>xmlHttpRequest</code> transport is currently available by calling
// +link{RPCManager.xmlHttpRequestAvailable}.
//
// @see RPCManager.defaultTransport
//
// @visibility external
//<

//> @attr rpcRequest.useXmlHttpRequest (boolean : RPCManager.useXmlHttpRequest : IRWA)
//  
// Selects the default http transport for this RPCRequest.  If set to true, this request will use
// XMLHttpRequest for the transport to the server.  If set to false it will use a hidden frame.  If
// left unset, the transport mechanism is determined from the RPCManager default set in 
// +link{RPCManager.useXmlHttpRequest}
// <p>
// If you're using queueing, note that all requests in the queue must use the same transport.
// If you attempt to send a request via a different transport than those that are currently on
// the queue, it will be sent to the server separately, ahead of the queue, and a warning will
// be logged to the Developer Console.
// <p>
// If you specify <code>true</code> for this attribute and XMLHttp is not available, a warning
// will be logged to the Developer Console and RPCManager will attempt to use the frames
// transport for this request.  Note that some features like
// +link{RPCRequest.serverOutputAsString} requre the XMLHttp transport and will not work if the
// XMLHttp transport is unavailable (this can happen if the end user is using Internet Explorer
// and has disabled ActiveX).  You can query the availability of XMLHttp by calling
// +link{RPCManager.xmlHttpRequestAvailable()}
// 
// @deprecated As of SmartClient 5.5, use +link{RPCRequest.transport}.  If you specify a value
// for this property, it will take precedence over +link{RPCRequest.transport}.
//
// @see RPCManager.useXmlHttpRequest
// @see RPCManager.xmlHttpRequestAvailable()
//
// @visibility external
//<

					
//> @attr RPCRequest.httpMethod (String : "POST" : IRW)
//
// Selects the HTTP method that will be used for the request.  Typical values are "POST" and
// "GET".
// <P>
// The more obscure "PUT", "DELETE" and "HEAD" methods are also valid, however, none of these
// are supported by the Safari browser previous to version 3.0.
//
// @visibility external
//<

					
//> @attr RPCRequest.contentType (String : "application/x-www-form-urlencoded" : IRW)
//
// Valid with the xmlHttpRequest transport only and only when
// +link{attr:RPCRequest.httpMethod} is set to "POST".  
//
// @visibility external
//<
					
//> @attr RPCRequest.httpHeaders (Object : null : IRW)
// HTTP headers to send, as a Object mapping Header name -> Header value, eg<br>
// { "Content-Type" : "text/xml" }
// <P>
// Valid with the xmlHttpRequest +link{rpcRequest.transport,transport} only.
//
// @visibility external
//<


//> @attr RPCRequest.containsCredentials (boolean : false : IRWA)
// For use during +link{group:relogin,Relogin}, this property marks this request an attempt to
// login, therefore a response containing the <code>loginRequiredMarker</code> is a normal
// condition and should result in the status code +link{RPCResponse.STATUS_LOGIN_INCORRECT}
// rather than a call to +link{RPCManager.loginRequired(),loginRequired()}.
// <P>
// It is not required to set <code>containsCredentials</code>, however, it does typically
// simplify relogin logic by separating the handling of RPCs that are login attempts from RPCs
// that are not.
// 
// @group relogin
// @visibility external
//<

//> @attr RPCRequest.canDropOnDelay (boolean : false : IRWA)
//  
// If the transaction containing this request is requested to be delayed for some reason
// (Authentication relogin is one case), then this flag notifies the server that this request does
// not have to be ultimately fulfilled when the transaction is unblocked.<p>
//
// Typically you would set this flag on requests that periodically refresh a component every N
// seconds, so only the last update is important.
//
// @visibility internal
//<

//> @attr RPCRequest.ignoreTimeout (boolean : false : IRWA)
//
// When set to true, no reply is expected from the server.  However, if a reply is received, it will
// be processed.<p>
//
// Note: setting this to true, forces +link{attr:RPCRequest.sendNoQueue} to <code>true</code> for
// this request.
//
// @visibility external
//<

//> @attr RPCRequest.sendNoQueue (boolean : false : IRWA)
//
// When set to true, this request is sent to the server immediately, bypassing any current queue.
//
// @visibility external
//<

//> @attr RPCRequest.paramsOnly (boolean : false : IRWA)
//
// When set to true, assume the request is not going to the SmartClient server, and hence send
// a simple HTTP request.  Values specified in +link{attr:RPCRequest.params} are sent to to the
// server as HTTP request parameters.  If +link{httpMethod} method is POST and
// +link{rpcRequest.data} is supplied, it is assumed to be a string to post as the HTTP
// requestBody.
// <p>
// Setting this to true automatically defaults +link{RPCRequest.serverOutputAsString} to true
// as well.
//
// @deprecated As of SmartClient 5.6, use +link{RPCRequest.useSimpleHttp} instead.
// @visibility external
//<

//> @attr RPCRequest.useSimpleHttp (boolean : false : IRWA)
//
// When set to true, assume the request is not going to the SmartClient server, and hence send
// a simple HTTP request that does not use SmartClient-specific request encoding.
// <P>
// Values specified in +link{attr:RPCRequest.params} are sent to to the server as HTTP request
// parameters.  If +link{httpMethod} is "GET", parameters appear in the request URL, otherwise
// if httpMethod is "POST", parameters are encoded in the request body (exactly like an HTML form
// does).  These parameters are then accessible via typical server-side APIs for retrieving
// HTTP parameters, eg, servletRequest.getParameter(paramName) in Java Servlets.  
// <P>
// Note that if +link{httpMethod} method is POST and +link{rpcRequest.data} is supplied,
// +link{rpcRequest.data} is assumed to be a string to post as the HTTP request body, and
// +link{rpcRequest.params} are sent as URL parameters instead.  This usage is for sending
// custom request bodies such as the XML payloads used for SOAP.  In this case,
// +link{rpcRequest.contentType} is typically also set to indicate the content type of the
// request body.
// <p>
// Setting <code>useSimpleHttp</code> to true also automatically sets
// +link{RPCRequest.serverOutputAsString} to true as well.
//
// @visibility external
//<

//> @attr RPCRequest.bypassCache (boolean : false : IRWA)
//
// For xmlHttp transport + httpMethod: "GET"  only, set to true to force IE to send a conditional
// GET request even if the browser thinks it has a current cached response.
//
// @visibility external
//<


//> @attr RPCRequest.omitNullMapValuesInResponse (boolean : false : IRWA)
//
// If enabled, the server omits any key/value pairs in map that have null values from the
// response.  This can reduce the size of the response when many fields have null values.
// <p>
// To enable this globally for all responses you can set RPCManager.omitNullMapValuesInResponse
// in server.properties.
//
// @visibility external
//<

// ---------------------------------------------------------------------------------------
//> @type RPCCallback
// A +link{type:Callback} to evaluate when an RPCRequest completes.
// <p>
// Parameters passed to this callback are:
// <ul>
// <li>rpcResponse: an +link{class:RPCResponse} encapsulating the server response to your
//     request
// <li>data: just the "data" property from the RPCResponse, for convenience
// <li>rpcRequest: the +link{class:RPCRequest} that was sent.  You can use
//     +link{attr:rpcRequest.clientContext} to track state during the server turnaround.
// </ul>
// For example, to take the data returned by the server and display it in a previously created
// ListGrid with the ID "myGrid":
// <pre>
//     isc.RPCManager.send("getData", "myGrid.setData(data)");
// </pre>
// Or
// <pre>
//     isc.RPCManager.send("getData", function (rpcResponse, data, rpcRequest) { 
//                                        myGrid.setData(data)
//                                    });
// </pre>
//
// @see class:RPCRequest
// @see class:RPCResponse
// @treeLocation Client Reference/RPC
// @visibility external
//<



// ---------------------------------------------------------------------------------------
//>	@class	RPCResponse
//
// Encapsulates an RPC response from the server.  Instances of this class are automatically created
// and optionally passed to you in the callback you specify as part of your RPCRequest.
//
// @see class:RPCRequest
// @see type:RPCCallback
// @visibility external
// @treeLocation Client Reference/RPC
//<

//> @attr rpcResponse.data (boolean : false : R)
// The data sent by the server.
// <P>
// When communicating with the SmartClient server, rpcResponse.data is the data passed to the
// server-side method RPCResponse.setData() by your Java code, as translated into JavaScript
// objects by the rules described under +link{rpcRequest.data}.
// <P>
// When not communicating with the SmartClient server (+link{rpcRequest.useSimpleHttp} or
// another flag that implies it is set), rpcResponse.data contains the raw HTTP response body.
// For an exception, see +link{rpcRequest.evalResult}.
// 
// @visibility external
//<

//> @attr rpcResponse.status (integer : false : R)
// 
// Status code for this response.  Status codes less than zero are considered errors by the
// RPCManager, those greater than or equal to zero are considered successes.  Please see the
// error handling section the +link{class:RPCManager,RPCManager docs} for more information on
// what the RPCManager does with the status code and how you can override this behavior.
// <P>
// When using the SmartClient server you can set the rpcResponse.status by calling the
// server-side method RPCResponse.setStatus().  
// <P>
// When not using the SmartClient server, the RPCManager makes no assumptions about the
// structure of the response, so the status code just reflects the
// +link{attr:RPCResponse.httpResponseCode}: status will be 
// +link{RPCResponse.STATUS_TRANSPORT_ERROR,STATUS_TRANSPORT_ERROR} if an HTTP-level error
// occurred such as "500 server error".  If you have a status code you need to transmit you can
// simply embed it in the response (as part of +link{rpcResponse.data}) and interpret it from
// the callback.
// <P>
// With or without the SmartClient server, the +link{group:relogin} status codes (such as 
// +link{STATUS_LOGIN_REQUIRED}) are triggered whenever special markers, such as the
// loginRequiredMarker, appear in the body of the response.  See the +link{group:relogin,Relogin
// Overview} for details.
//
// @visibility external
//<

//> @attr rpcResponse.httpResponseCode (integer : null : R) 
//
// This attribute (avialable when using the the <code>xmlHttpRequest</code> transport) contains
// the HTTP response code sent by the server.
// <p>
// Note that this is different from +link{attr:RPCResponse.status} - that attribute is used to
// indicate a status code for the RPC itself whereas httpResponseCode is the raw HTTP response
// code for the HTTP request that contained the RPCRequest.
// <p>
// This feature relies on the XMLHttpRequest object which can be disabled by end-users in some
// supported browsers.  See +link{group:platformDependencies} for more information.
// <p>
// If you're using this attribute, you'll typically want to avoid the default error
// handling response of RPCManager.  To do so, set
// +link{attr:rpcRequest.willHandleError} to <code>true</code>.
//
// @visibility external
//<

//> @attr rpcResponse.clientContext (Object : null : R)
//
// The +link{RPCRequest.clientContext} object as set on the +link{RPCRequest}.
//
// @see rpcRequest.clientContext
//
// @visibility external
//<

//> @attr rpcResponse.transactionNum (number : null : R)
// ID of the transaction sent to the server via +link{RPCManager.sendQueue()} containing the
// +link{RPCRequest} associated with this response.
// @visibility external
//<

//> @type RPCTransport
//
// SmartClient supports multiple RPC transports for maximum compatibility and feature richness.
// All of transports use HTTP as the underlying protocol, but use different mechanisms for
// sending the HTTP request and processing the response.  The transport is typically
// auto-selected for by based on the feature being used and the current browser settings.  For
// advanced use cases, +link{RPCRequest.transport} and +link{RPCManager.defaultTransport} are
// exposed as override points.
// <p>
// @value "xmlHttpRequest"  Uses the XMLHttpRequest object to make the request to the server.
// Note that in some browsers with certain configurations, this transport may not be
// available.  See +link{group:platformDependencies} for more information.  This transport is
// not useful with file uploads.  Cannot be used to target cross-domain URLs directly.
//
// @value "scriptInclude"   Write a SCRIPT tag into the DOM with a SRC attribute that targets
// an arbitrary URL.  This transport is the only one that allows direct cross-domain URL
// access.  
// <P>
// For +link{rpcRequest.callback} to work, the server being contacted must support the ability
// to generate JavaScript code in the response that will call a JavaScript function generated
// by SmartClient.  SmartClient passes the name of the function to call via a URL parameter,
// which can be controlled with +link{rpcRequest.callbackParam}.
//
// @value "hiddenFrame"     Available with SmartClient Server only.  An HTML form is
// dynamically assembled that targets a hidden IFRAME.  This mechanism is supported on all
// browsers and cannot be disabled by end users.  
// <P>
// If using the SmartClient Server and using 
// +link{group:serverDataIntegration,Server-side data integration}, the "hiddenFrame" transport
// is automatically used for all RPCManager and DataSource requests if the "xmlHttpRequest"
// transport is not available.
// <P>
// Cannot be used to target cross-domain URLs directly.
//
//
// @visibility external
//<

//> @groupDef platformDependencies
//
// Client-side processing of web services, XML parsing, and some UI loading mechanisms rely on
// a native in-browser XML parser and/or the XMLHttpRequest object - one or both of which will
// not be available if the end user disables ActiveX support in Internet Explorer.  Note that
// these features do not require plugins or downloads of any kind - IE simply exposes certain
// built-in functionality like the XML parser and XMLHttpRequest through the ActiveX
// interface.  Disabling ActiveX also disables all browser plugins such as Flash, Java, SVG, etc.
// <p>
// Barring ActiveX being disabled, the XMLHttpRequest object is available to SmartClient on all
// supported browsers and an XML parser is available on all supported browsers except Safari
// versions prior to 3.0.3.
// <p>
// SmartClient client-server communication is not affected by the lack of an XML parser or the
// XMLHttpRequest object, but the <code>xmlHttpRequest</code> transport will not be available
// if the XMLHttpRequest object is not available.  Instead, the <code>hiddenFrame</code> or the
// <code>scriptInclude</code> transports are used for client-server communication.
// <p>
// <b><u>XML Parser</u></b>
// <p>
// If an XML Parser is not available to SmartClient, all client-side web service bindings and
// related methods will be unavailable.  Turning off ActiveX disables integration paths 2 and 3
// in the diagram below.  If you want to bind to web services and require deployment to IE
// without ActiveX (or you need to support Safari pre 3.0.3), you'll need to do all XML processing on the
// server and use either the SmartClient DSRequest or JSON operation pathways (integration
// paths 1 and 4 in the diagram below).  See the discussion in +link{clientServerIntegration}
// for more information on the integration paths shown in the diagram below.
// <p>
// You call +link{XMLTools.nativeXMLAvailable()} to check for the avialability of a native XML
// parser at runtime.
// <p>
// <img src="${isc.DocViewer.instance.referenceRoot}skin/ds_bindings.png" width=763 height=475>
// <p>
// <b><u>XMLHttpRequest</u></b>
// <p>
// The XMLHttpRequest object is used for the <code>xmlHttpRequest</code> +link{RPCTransport}.
// Safari, Mozilla, Firefox, and IE 7 provide a native XMLHttpRequest implementation that is
// not affected by ActiveX being disabled (although the native IE 7 implementation can still be
// explicitly disabled by the end user).  IE 5.5 and IE 6.0 rely on the ActiveX bridge to
// support XMLHttpRequest, so if ActiveX is disabled in these browsers, XMLHttpRequest will not
// be available.
// <p>
// The lack of the XMLHttpRequest objects affects UI loading features like +link{ViewLoader},
// and +link{HTMLFlow} when used in remote loading mode (via +link{HTMLFlow.contentsURL},
// +link{HTMLFlow.setContentsURL}, but does not affect the typical client/server communication
// pathways (integration paths 1 and 5 in the diagram above).
// <p>
// Also affected are low level features +link{RPCRequest.serverOutputAsString},
// +link{RPCRequest.evalResult}, and +link{RPCResponse.httpResponseCode}.
// <p>
// In all of the above cases, it is possible to use the <code>hiddenFrame</code> transport to
// support these features when XMLHttpRequest is not available.  SmartClient will automatically
// send the request using the <code>hiddenFrame</code> transport when it detects that
// XMLHttpRequest is unavailable.  To support the above features, you'll need to use the
// RPCManager APIs on the server to send back the data that would normally be returned by
// XMLHttpRequest.  Since XMLHttpRequest cannot target URLs outside of the current domain, this
// strategy applies also to using the above features with cross-domain URLs.
// <p>
// You can call +link{RPCManager.xmlHttpRequestAvailable()} to check for the availability of
// XMLHttpRequest at runtime.
//
// @title Platform Dependencies
// @treeLocation /Client Reference/System
// @visibility external
//<

isc.ClassFactory.defineClass("RPCResponse");
isc.RPCResponse.addClassProperties({
//> @groupDef  statusCodes
// Status codes returned by the server as rpcResponse.status.<br>
// See the error handling doc section in +link{class:RPCManager, RPCManager} for more 
// information on these codes
// @visibility external
//<

// NOTE: error codes are both added as a subobject (to allow code -> text name lookup) and
// directly (via addProperties below)
errorCodes : {


    //> @classAttr rpcResponse.STATUS_SUCCESS (integer : 0 : R)
    //
    // Indicates successful completion of the request.  This is the default status and is
    // automatically used by the RPCResponse on the server unless you override it with
    // setStatus().
    // <br><br>
    // See the error handling section in +link{class:RPCManager, RPCManager documentation}
    // for more information.
    // 
    // @see class:RPCRequest
    // @group statusCodes
    // @visibility external
    //<
    STATUS_SUCCESS: 0,

    //> @classAttr rpcResponse.STATUS_FAILURE (integer : -1 : R)
    //
    // Indicates a generic failure on the server.  
    // See the error handling section in +link{class:RPCManager, RPCManager documentation}
    // for more information.
    // 
    // @see class:RPCRequest
    // @group statusCodes
    // @visibility external
    //<
    STATUS_FAILURE: -1,

    //> @classAttr rpcResponse.STATUS_VALIDATION_ERROR (integer : -4 : R)
    //
    // Indicates a validation failure on the server.
    // See the error handling section in +link{class:RPCManager, RPCManager documentation}
    // for more information.    
    // 
    // @see class:RPCRequest
    // @group statusCodes
    // @visibility external
    //<
    STATUS_VALIDATION_ERROR: -4,

    //> @classAttr rpcResponse.STATUS_LOGIN_INCORRECT (integer : -5 : R)
    //
    // Indicates that the RPC has been intercepted by an authenticator that requires the user
    // to log in.
    // 
    // @see class:RPCRequest
    // @group statusCodes
    // @visibility external
    //<
    STATUS_LOGIN_INCORRECT: -5,

    //> @classAttr rpcResponse.STATUS_MAX_LOGIN_ATTEMPTS_EXCEEDED (integer : -6 : R)
    //
    // Indicates that too many authentication attempts have been made and the server refuses to
    // accept any more login attempts.
    // 
    // @see class:RPCRequest
    // @group statusCodes
    // @visibility external
    //<
    STATUS_MAX_LOGIN_ATTEMPTS_EXCEEDED: -6,

    //> @classAttr rpcResponse.STATUS_LOGIN_REQUIRED (integer : -7 : R)
    //
    // Indicates that a login is required before this RPCRequest can proceed.
    // 
    // @see class:RPCRequest
    // @group statusCodes
    // @visibility external
    //<
    STATUS_LOGIN_REQUIRED: -7,

    //> @classAttr rpcResponse.STATUS_LOGIN_SUCCESS (integer : -8 : R)
    //
    // Indicates that the login succeeded.
    // 
    // @see class:RPCRequest
    // @group statusCodes
    // @visibility external
    //<
    STATUS_LOGIN_SUCCESS: -8,

    //> @classAttr rpcResponse.STATUS_TRANSPORT_ERROR (integer : -90 : R)
    //
    // This response code is usable only with the XMLHttpRequest transport and indicates that
    // the server returned an HTTP response code outside the range 200-299 (all of these statuses
	// indicate success, but ordinarily only 200 is used).  To get the actual
    // response code, you can query rpcResponse.httpResponseCode in your callback.
    // <p>
    // Note that currently this error code will never occur for the <code>hiddenFrame</code>
    // transport - instead, use +link{RPCResponse.STATUS_SERVER_TIMEOUT} to detect
    // <code>hiddenFrame</code> transport errors.
    //
    // @group statusCodes
    // @visibility external
    //<
    STATUS_TRANSPORT_ERROR: -90,

    //> @classAttr rpcResponse.STATUS_SERVER_TIMEOUT (integer : -100 : R)
    //
    // Indicates a request timed out with no server response.
    // <p>
    // This is a client-only error code - never sent by the server (since it's the server
    // that times out).
    // <p>
    // NOTE that if using <code>hiddenFrame</code> as the transport (not the default), a
    // malformed response such as a "500 Server Error" or 404 errors will be reported as a
    // timeout. 
    //
    // @group statusCodes
    // @visibility external
    //<
    STATUS_SERVER_TIMEOUT: -100
}

});
isc.RPCResponse.addClassProperties(isc.RPCResponse.errorCodes);

// alias DSResponse to RPCResponse so that end users can use the response codes as
// e.g. DSResponse.STATUS_SUCCESS
isc.addGlobal("DSResponse", isc.RPCResponse);

isc.RPCManager.addClassProperties({
    // truncate warn() dialog with server error to this many chars
    maxErrorMessageLength: 1000,

    // truncate extra long RPCManager log messages unless RPCManagerResponse has been set
    maxLogMessageLength: 25000,

    //> @classAttr RPCManager.defaultTimeout (number : 240000 [4 minutes] : RW)
    //
    // In milliseconds, how long the RPCManager waits for an RPC request to complete before
    // returning an error.  If set to zero, the RPCManager will not enforce a timeout, but note that
    // most browsers enforce their own timeouts on HTTP requests.
    // <p>
    // For the "xmlHttpRequest" transport, this timeout can only happen if the server actually fails to
    // respond within the specified number of milliseconds.  For the "hiddenFrames" transport,
    // this timeout will occur for non-200 (HTTP_OK) responses.
    // 
    // @visibility external
    //<
    defaultTimeout: 240000, 

    //>@groupDef    i18nMessages
    // The properties in this group are default system messages that a localized 
    // application will want to override on a per-locale basis
    // @see group:i18n
    // @visibility external
    //<
    
    //> @classAttr RPCManager.defaultPrompt (string : "Contacting Server..." : IRW)
    //
    // If showPrompt is enabled for a given transaction, this is the defaultPrompt to be shown
    // to the user in a modal dialog while the transaction occurs.
    // May be overridden at the request level via +link{attr:rpcRequest.prompt}.<br>
    // More targetted default prompts are also supported for certain code-paths. See the following 
    // set of properties for details:<ul>
    // <li>+link{RPCManager.removeDataPrompt}</li>
    // <li>+link{RPCManager.saveDataPrompt}</li>
    // <li>+link{RPCManager.fetchDataPrompt}</li>
    // </ul>
    //
    // @see classAttr:RPCManager.showPrompt
    // @see classAttr:RPCManager.promptStyle
    // @see classAttr:RPCManager.promptCursor
    // @see attr:rpcRequest.showPrompt
    // @see attr:rpcRequest.prompt
    // @see attr:rpcRequest.promptStyle
    // @see attr:rpcRequest.promptCursor
    //
    // @visibility external
    // @group rpcPrompt
    // @group i18nMessages
    //<
    defaultPrompt:"Contacting server...",
    
    //> @classAttr RPCManager.timeoutErrorMessage   (string : "Operation timed out" : IRW)
    // Default message displayed to user when an opration fails to return from the server within
    // the timeout period specified by +link{RPCManager.defaultTimeout}.
    // @see classAttr:RPCManager.defaultTimeout
    // @visibility external
    // @group i18nMessages
    //<
    timeoutErrorMessage:"Operation timed out",
    
    //> @classAttr RPCManager.removeDataPrompt  (string : "Deleting Record(s)..." : IRW)
    // Default prompt displayed to user while an opration is running to remove data from
    // the server.<br>
    // Displayed as a result of the +link{ListGrid.removeSelectedData()} code path.
    // @visibility external
    // @group i18nMessages
    //<
    removeDataPrompt:"Deleting record(s)...",
    
    
    //> @classAttr  RPCManager.saveDataPrompt   (string : "Saving form..." : IRW)
    // Default prompt displayed to the user while an opreration is running to save data to
    // the server.<br>
    // Displayed as a result of the +link{DynamicForm.saveData()} code path.
    // @visibility external
    // @group i18nMessages
    //<
    saveDataPrompt:"Saving form...",
    
    //> @type PromptStyle
    //
    // @value "dialog" Displays a centered modal prompt with text specified by
    //                 +link{rpcRequest.prompt}
    // @value "cursor" Changes the current cursor to the style specified by
    //                 +link{rpcRequest.promptCursor}
    //
    // @visibility external
    //<

    //> @classAttr  RPCManager.promptStyle   (PromptStyle : "dialog" : IRW)
    // Controls the default prompt style.  Overrideable by +link{attr:rpcRequest.promptStyle}.
    //
    // @visibility external
    // @see attr:rpcRequest.promptStyle
    // @group rpcPrompt
    //<
    promptStyle: "dialog",

    //> @classAttr RPCManager.useCursorTracker (boolean : platform-dependent : IRW)
    //
    // If true, an image is shown to the right of the cursor when +link{rpcRequest.promptStyle} is
    // set to "cursor", otherwise the cursor itself is modified via css to the value of
    // +link{rpcRequest.promptCursor}.  The default is platform-dependent.  In Safari, IE 5.5 and
    // Firefox 1.0 the default is true, on all other platforms it is false.  The reason for
    // this split is that, the above browsers require that the cursor move before CSS settings are
    // re-evaluated - this means the progress cursor can stick until the user moves the mouse.
    // <p>
    // This value can be overridden on a per-request basis via +link{rpcRequest.useCursorTracker}.
    //
    // @see rpcRequest.useCursorTracker
    // @group rpcPrompt
    // @visibility external
    //<
    useCursorTracker: isc.Browser.isSafari || (isc.Browser.isMoz && isc.Browser.geckoVersion < 20051111),
    cursorTrackerConstructor: "Img",
    cursorTrackerDefaults: {
        src : isc.Page.getSkinDir()+"/images/shared/progressCursorTracker.png",
        size: 16,
        offsetX: 12,
        offsetY: 0,
        _updatePosition : function () {
            this.setLeft(isc.EH.getX()+this.offsetX);
            this.setTop(isc.EH.getY()+this.offsetY);
        },
        initWidget : function () {
            this.Super("initWidget", arguments);
            this._updatePosition();
            this._updateEvent = isc.Page.setEvent("mouseMove", this.getID()+"._updatePosition()");            
            this.bringToFront();
        },
        destroy : function () {
            isc.Page.clearEvent("mouseMove", this._updateEvent);
            this.Super("destroy", arguments);
        }
    },

    //> @classAttr  RPCManager.promptCursor   (String : browser-dependent : IRW)
    // Controls the default cursor shown when +link{rpcManager.promptStyle} is set to
    // <code>"cursor"</code>.  Overrideable by +link{attr:rpcRequest.promptCursor}.
    // <p>
    // In Safari, IE 5.5 and Firefox 1.0 the default value is "wait", on all other platforms it is
    // "progress".  The reason for this split is that the above-mentioned browsers do not support
    // CSS2.1 - which is required for the "progress" cursor type.
    //
    // @visibility external
    // @see attr:rpcRequest.promptCursor
    // @group rpcPrompt
    //<
    // FF1.0, Safari don't support CSS2.1, so must use 'wait' - otherwise 'progress'
    promptCursor: isc.Browser.isSafari || 
        (isc.Browser.isMoz && isc.Browser.geckoVersion < 20051111) || 
        (isc.Browser.isIE && isc.Browser.minorVersion <= 5.5) ? "wait" : "progress",

    //> @classAttr  RPCManager.fetchDataPrompt  (string : "Finding Records that match your criteria..." : IRW)
    // Default prompt displayed to the user while an operation is running to fetch data from
    // the server.<br>
    // Displayed as a result of +link{ListGrid.filterData()}, +link{ListGrid.fetchData()} and
    // +link{ListGrid.clearCriteria()} code paths.
    // @visibility external
    // @group i18nMessages
    //<
	fetchDataPrompt:"Finding records that match your criteria...",
    
    
    // Hidden prompts (not currently used by any exposed code path)
    // ---------------------------------------------------------------
    
    getViewRecordsPrompt:"Loading record...",
    	
    //> @classAttr RPCManager.showPrompt (boolean : RPCManager.showPrompt : RW)
    // 
    // If set to <code>true</code>, the RPCManager will block the UI with a modal dialog containing
    // the text from RPCManager.defaultPrompt (or the per-RPCRequest override) until the RPC to the
    // server completes.
    // <br><br>
    // If set to <code>false</code>, the RPC happens transparently, allowing the user to continue
    // interacting with the UI
    //
    // @see classAttr:RPCManager.defaultPrompt
    // @see attr:rpcRequest.showPrompt
    // @group rpcPrompt
    // @visibility external
    //<
    showPrompt: false,

    
    neverShowPrompt: false,

    //> @classAttr RPCManager.actionURL (URL : RPCManager.actionURL : RW)
    //
    // The actionURL specifies the URL to which the RPC request will be sent.  Note that if you
    // override this global default and your application uses DataSource databound components,
    // you'll need to dispatch the DataSource requests from your RPC handler.  Your other option is
    // to specify a url on a per-request basis.
    // 
    // @see attr:rpcRequest.actionURL
    //
    // @visibility external
    //<
	actionURL:"[ISOMORPHIC]/IDACall",	
    
    //> @classAttr RPCManager.useXmlHttpRequest (boolean : true if XMLHttpRequest is supported, false otherwise : RW)
    //  
    // Selects the default http transport for all RPC requests.  If set to true, RPCManager
    // will use XMLHttp for requests to the server.  If set to false, it will use hidden
    // frames.  Overrideable on a per-request basis via +link{RPCRequest.useXmlHttpRequest}.
    // <p>
    // Note that if the end user disables ActiveX controls in Internet Explorer, the XMLHttpRequest
    // object will not be available and SmartClient will automatically fall back on frames
    // communication.
    //
    // @deprecated As of SmartClient 5.5, use +link{RPCManager.defaultTransport}.  If you
    // specify a value for this property, it will take precedence over
    // +link{RPCManager.defaultTransport} for requests that do not specify a
    // +link{RPCRequest.transport} or +link{RPCRequest.useXmlHttpRequest}.
    //
    // @see attr:rpcRequest.useXmlHttpRequest
    //
    // @visibility external
    //<

    //> @classAttr RPCManager.defaultTransport (RPCTransport : "xmlHttpRequest": IRW)
    //
    // Selects the transport use for RPC requests by default.  You can override this setting on
    // a per-request basis by setting +link{rpcRequest.transport}.
    //
    // @see rpcRequest.transport
    // @visibility external
    //<
    defaultTransport: "xmlHttpRequest",

    // whether to ever attempt to use the "HttpProxy" servlet to enable web service requests to
    // servers other than the origin server.
    
    
    useHttpProxy : (!isc.Browser.isApollo),
   
    //> @classAttr RPCManager.dataEncoding (string : RPCManager.dataEncoding : RWA)
    //
    // Controls the encoding of the _transaction field of the client->server comm.  Valid values are
    // "XML" and "JS" and enable the XML and Javascript encoding, respectively.
    //
    // @visibility internal
    //<
    dataEncoding: "XML",

    //> @classAttr RPCManager.preserveTypes (boolean : RPCManager.preserveTypes : RWA)
    //
    // If true, numbers and booleans become Number and Boolean on the server.  Otherwise they are
    // Strings.  A true value is currently supported only with dataEncoding: XML.
    //
    // @visibility internal
    //<
    preserveTypes: true,

    //> @classAttr RPCManager.credentialsURL (string : RPCManager.credentialsURL : RWA)
    //
    // Specifies URL where credentials should be submitted to attempt relogin when session
    // timeout is encountered during a background RPC.  See +link{group:relogin,Relogin}
    //
    // @group relogin
    // @visibility external
    //<
    credentialsURL: isc.Page.getIsomorphicDir()+"login/loginSuccessMarker.html",

    // XXX document
    loginWindowSettings: "WIDTH=550,HEIGHT=250",

    // don't scan RPC responses longer than this for relogin commands: 1 Megabyte.  Scanning a
    // file this large for the relogin string on a Core 2 Duo 6700 CPU in IE takes 2.66ms
    maxLoginPageLength: 1048576,

    // outstanding transactions to the server and counter.  A transaction is a set of
    // RPCRequests sent to one URL 
    _transactions: Array.create({
        // these methods are here for the RPCTracker class that's part of the DevConsole (RPC
        // tracking)
        addTrack : function (object, secondArg) {
            this._lastChanged = object;
            this.add(object, secondArg);
            this._lastChanged = null;
        },
        setLastChanged : function (transaction) {
            this._lastChanged = transaction;
        },
        clearLastChanged : function () {
            this._lastChanged = null;
        },
        getLastChanged : function () {
            return this._lastChanged;
        }
    }),
    _nextTransactionNum: 0,
    _activeTransactions:[],
	getTransactions : function () { return this._transactions; }
	

});


isc.RPCManager.addClassMethods({
    
    //> @classMethod RPCManager.xmlHttpRequestAvailable()
    //
    // Returns true if the XMLHttpRequest object is available, false otherwise.  See
    // +link{group:platformDependencies} for more information on when XMLHttpRequest parser may
    // not available and what features are
    // impacted as a result.
    //
    // @return (boolean) true if XMLHttpRequest is available, false otherwise.
    //
    // @visibility external
    //<
    xmlHttpRequestAvailable : function () {
        // createXMLHttpRequest() actually does a new ActiveXObject() in IE, but
        // we don't cache the result because the user can change ActiveX settings on the fly.
        // This probably won't happen in actual usage, but developers will almost certainly try
        // it this way and it needs to work
        if (isc.Browser.isIE) return (isc.Comm.createXMLHttpRequest() != null);
        return true;
    },

	// return the action URL, dereferencing any special local directories.
    // used internally by the RPCManager for url interpolation
	getActionURL : function () { return isc.Page.getURL(this.actionURL); },

    //> @classMethod RPCManager.send()
    //
    // This method is a convenience wrapper on <code>RPCManager.sendRequest()</code> - it calls
    // through to sendRequest().
    //
    // @param data            (any)           data to be passed to the server
    // @param [callback]      (RPCCallback)   method to call on RPC completion
    // @param [requestParams] (Object)        object literal containing any additional properties
    //                                        you want to set - these will be applied to the
    //                                        RPCRequest object that will be auto-created for you.
    //
    // @see RPCManager.sendRequest()
    // @see class:RPCRequest
    //
    // @visibility external
    //<
    send : function (data, callback, requestParams) { 
        var rpcRequest = (requestParams || {});
        isc.addProperties(rpcRequest, {
            data: data,
            callback: callback
        });
        return this.sendRequest(rpcRequest);
    },


    _warnIfXmlHttpRequestUnavailable : function (featureName) {
        if (this.xmlHttpRequestAvailable() || !this.logIsWarnEnabled()) return false;
        
        var message = "Feature "+featureName+" requires the xmlHttpRequest transport"
                     +" which is not currently available because ActiveX is disabled."
                     +" Please see the 'Features requiring ActiveX or Native support'"
                     +" topic in the client-side reference under Client Reference/System"
                     +" for more information.";
        this.logWarn(message);
        return true;
    },

// sendProxied() : send an RPC through an HTTP Proxy
// ---------------------------------------------------------------------------------------
//> @classMethod RPCManager.sendProxied()
// Send an HTTP request to a remote host, potentially through the HttpProxy servlet installed
// on the ISC server.
// <P>
// This API allows contacting services which are hosted on servers other than the origin server
// if the HttpProxy servlet is enabled on the ISC server.
// <P>
// The HttpProxy will be used if the +link{rpcRequest.actionURL} starts with "http" and uses a
// hostname other than "localhost" or <code>window.location.hostname</code>, or if the port
// number differs, or if <code>request.useHttpProxy</code> is explicitly set.  Otherwise the
// request goes to the origin server (the server that returned the current page).
// <P>
// The +link{RPCRequest} properties that will be respected when relaying requests via the
// HttpProxy are: 
// +link{RPCRequest.actionURL,actionURL}, +link{RPCRequest.httpMethod,httpMethod}, 
// +link{RPCRequest.params,params}, +link{RPCRequest.contentType,contentType}, 
// +link{RPCRequest.httpHeaders,httpHeaders}, and +link{RPCRequest.data,data}.  In this case
// "data", if set, will be used as the request body for an HTTP POST.
// <P>
// Higher-level APIs like +link{DataSource} or +link{WebService} call through this API, and so
// automatically use the HttpProxy if +link{dataSource.dataURL} or
// +link{webService.setLocation(),webService.location} is set to a foreign server.
// <P>
// This API is only suitable for direct use when loading unstructured data that will not be
// shown in a +link{DataBoundComponent}.  For a WSDL-described web service, use
// +link{XMLTools.loadWSDL()} instead.  For other web services, use a +link{DataSource} with
// +link{DataSource.dataURL,dataURL}, and use +link{DataSource.transformRequest()} and
// +link{DataSource.transformResponse()} as necessary to form requests for the service and
// transform responses for display.
//
// @param request (RPCRequest Properties) rpcRequest to be routed through the HttpProxy
// @requiresModules SCServer
// @visibility external
//<
sendProxied : function (request, allowRPCFormat) {
    

    request.serverOutputAsString = true;
    request.sendNoQueue = true; // don't use ISC-format multi-op

    var url = request.actionURL || isc.RPCManager.actionURL;
    //this.logWarn("url is: " + url);
    // use the proxy if request.useHttpProxy has been specifically set for this request, or..
    var useProxy = (request.useHttpProxy != null ? request.useHttpProxy :  
            // the proxy is available and ..
            (isc.RPCManager.useHttpProxy && 
                // and the URL appears to be remote (starts with http and not obviously local)
                url.startsWith("http") && !this.isLocalURL(url)));

    if (!useProxy)
    {
        // contact origin server directly, but don't send the ISC-specific transaction
        // structure        
        if (!allowRPCFormat) request.useSimpleHttp = true;
        
    } else {
        // contact foreign server by way of HttpProxy, which expects an RPCRequest where "data"
        // contains configuration for sending an HTTPRequest
        request = isc.addProperties({}, request, {
            actionURL : isc.XMLTools.httpProxyURL,
            // mark as proxied so we can perform better error reporting
            isProxied: true,
            // data is parameters the HttpProxy understands
            useSimpleHttp: true,
            proxiedURL: url,
            params : {
                data : isc.Comm.xmlSerialize("data", {
                    url : url,
                    httpMethod : request.httpMethod,
                    params : request.params,
                    contentType : request.contentType,
                    requestBody : request.data,
                    // NOTE: the only header the proxy actually supports sending through is
                    // "SOAPAction", but we send all headers to the server in case someone wants to
                    // customize this
                    httpHeaders : request.httpHeaders,
                    uploadFileName : request.uploadFileName
                })
            },
            // Force XHR on for this request because the proxy will feed us the response
            // directly and this is the only way to capture it without additional server
            // support.
            transport: "xmlHttpRequest",
            // wipe out these properties since they apply only to the relayed request, not to
            // the request intended for the HttpProxy servlet.  NOTE: we leave httpHeaders
            // intact in case someone has some kind of advanced usage in mind; RPCManager
            // ignores all headers by default
            httpMethod: null, data: null, contentType:null
        });
        //this.logWarn("proxied request: " + this.echo(request) + 
        //             ", data for proxy: " + this.echo(request.data) +
        //             ", requestBody: " + this.echo(request.data.requestBody));
    }
    return isc.rpc.sendRequest(request);
},

// given a URL, get the host without port
_getHostAndPort : function (url) {
    var protocol = isc.Page.getProtocol(url),
        // first slash after the protocol
        endHostSlash = url.indexOf("/", protocol.length),
        host = url.substring(protocol.length, endHostSlash),
        port
    ;
    var colIndex = host.indexOf(":");
    if (colIndex != -1) {
       port = host.substring(colIndex+1);
       host = host.substring(0, colIndex);
    }
       
    return [host, port];
},

// see if this is a URL that we can access locally
isLocalURL : function (url) {
    var hostAndPort = this._getHostAndPort(url),
        host = hostAndPort[0],
        port = hostAndPort[1]
    ;
    // NOTE: bad case: might be accessing wrath.isomorphic.com as just "wrath", in
    // which case we can't detect that wrath.isomorphic.com is actually a local URL.
    // To make this check better we might need to actually attempt an XMLHttpRequest for the
    // ambiguous cases, catch the error, and cache the URL as known good or bad.  However
    // depending on security settings, attempting to access a foreign URL may launch a
    // confirmation dialog, so the best we can do is probably to try to detect whether the
    // HttpProxy servlet is installed (whether via a flag dumped by the loadISC tag or a
    // dynamic request to the server), and assume direct access if its missing
    return (host == "localhost" || host == this.getWindow().location.hostname)
           && port == this.getWindow().location.port
    ;

    // Theoretically document.domain would allow xmlHttpRequests throughout a domain,
    // but quick testing reveals that setting document.domain to "isomorphic.com" on a page
    // served from "wrath.isomorphic.com" causes security exceptions in Moz even for attempts
    // to contact "wrath.isomorphic.com", the origin server.  IE also wedges.
    //return this._getHost(url).endsWith(this.getWindow().document.domain);
},

// ---------------------------------------------------------------------------------------
    

    //> @classMethod RPCManager.sendRequest()
    //
    // Send the passed <code>RPCRequest</code> to the server.  If queuing is in effect, this queues
    // the request instead.
    //
    // @param rpcRequest  (RPCRequest Properties)  RPCRequest to send to the server
    // 
    // @visibility external
    //<
    sendRequest : function (request) {
        // we are delaying transactions and this is a periodic polling or similar request that
        // can be ignored in this circumstance, so drop it
        if (request.canDropOnDelay && this.delayingTransactions) return;

        // make a copy of the request to allow callers to re-use the same object, with
        // modifications, when calling sendRequest() - note: shallow copy
        request = isc.addProperties({}, request);
        
        // default is true, so set it unless it's been explicitly disabled
        if (request.suppressAutoDraw !== false) request.suppressAutoDraw = true;

        // actionURL can also be specified as URL or url
        request.actionURL = 
                // NOTE use Page.getURL() to support special directories such as "[APPFILES]"
                isc.Page.getURL(request.actionURL || request.url || 
                                request.URL || this.getActionURL());


        // check if requested transport is available and fall back if necessary
        // ---------------------------------------------------------------------------------------

        
        
        // if the request specifies an explicit transport, we use that.  Otherwise, check
        // backcompat APIs first, then use RPCManager.defaultTransport    
        var explicitTransport = request.transport;
        if (!explicitTransport) {
            if (request.useXmlHttpRequest != null || this.useXmlHttpRequest != null) {
                // use of backcompat API on RPCRequest or RPCManager
                if (request.useXmlHttpRequest == null) {
                    if (this.useXmlHttpRequest != null) {
                        request.transport = this.useXmlHttpRequest ? "xmlHttpRequest" : "hiddenFrame";
                    } else {
                        request.transport = this.defaultTransport;
                    }
                } else {
                    request.transport = explicitTransport = request.useXmlHttpRequest ? "xmlHttpRequest" : "hiddenFrame";
                }
            } else {
                request.transport = this.defaultTransport;
            }
        }
        
        // Verify that the transport is available
        this.checkTransportAvailable(request, (explicitTransport != null));


        //>!BackCompat 2007.2.14 paramsOnly renamed to useSimpleHttp 
        if (request.useSimpleHttp == null) request.useSimpleHttp = request.paramsOnly;
        //<!BackCompat

    
        // default prompt-related settings on request to RPCManager defaults
        // ---------------------------------------------------------------------------------------
        isc.addDefaults(request, {
            showPrompt: this.showPrompt,
            promptStyle: this.promptStyle,
            promptCursor: this.promptCursor,
            useCursorTracker: this.useCursorTracker,
            cursorTrackerConstructor: this.cursorTrackerConstructor
        });

        request.cursorTrackerProperties = isc.addProperties({}, this.cursorTrackerDefaults, 
                                                            this.cursorTrackerProperties, 
                                                            request.cursorTrackerProperties);

        if (request.cursorTrackerProperties == null) 
            request.cursorTrackerProperties = this.cursorTrackerProperties;

        // if request.operation is supplied by callers doing DataSource operations.  If not
        // supplied, add it so we can assume its there for logging, etc.
        if (!request.operation) {
            request.operation = {
                ID: "custom",
                type: "rpc"
            }
        }

        if (this.canQueueRequest(request, (explicitTransport!=null))) {
            if (!this.currentTransaction) this.currentTransaction = this._createTransaction();
            this._addRequestToTransaction(request, this.currentTransaction);
    
            // if we're not queuing, send it off
            if (!this.queuing) return this.sendQueue();
            return request;

        } else {
            return this.sendNoQueue(request);
        }
    },
    
    // verify that the specified request.transport is available
    checkTransportAvailable : function (request, isExplicit) {
    
        var xmlHttpRequestAvailable = this.xmlHttpRequestAvailable();
        
        var transport = request.transport || this.defaultTransport;
        if (!xmlHttpRequestAvailable) {
            if (transport == "xmlHttpRequest") {
                if (isExplicit) {
                    this.logWarn("RPC/DS request specifically requesting the xmlHttpRequest" +
                                " transport, but xmlHttpRequest not currently available -" +
                                " switching transport to hiddenFrame.");
                } else {
                    this.logWarn("RPCManager.defaultTransport specifies xmlHttpRequest, but"
                             +" xmlHttpRequest not currently available - switching transport " 
                             + "to hiddenFrame.");
                }
            }
            request.transport = "hiddenFrame";
        }
    },

    // determine whether a request can be queued
    canQueueRequest : function (request, transportIsExplicit) {
        // since timeouts are controlled on a per-transaction basis, this type of request must be
        // sent separately of any queue
        if (request.ignoreTimeout) request.sendNoQueue = true;
        
        var transport = request.transport;
        

        // relogin flow: request is attempting login while transactions are suspended - bypass
        // queuing
        if (request.containsCredentials) {
            return false
        }

        // explicitly avoid any existing queue
        // scriptInclude-based requests can't be queued by nature
        if (request.sendNoQueue || request.transport == "scriptInclude") return false;

        // this tracks if we have at least one request on the queue - we can't use this.queuing here
        // because queuing can be disabled while there are still requests on the queue:
        // startQueue(false) - also for the checks below we really only care about requests that go
        // to the server, so we can ignore clientOnlyRequests
        var haveServerRequestsOnQueue = (this.currentTransaction && 
            this.currentTransaction.requestData.operations.length > 0);
            
        // - current request specifies URL other than that for which we're queueing
        //     - send errant request, continue queueing
        if (haveServerRequestsOnQueue && (request.actionURL != this.currentTransaction.URL)) { 
            //>DEBUG
            this.logWarn("RPCRequest specified (or defaulted to) URL: " + request.actionURL
                + " which is different than the URL for which the RPCManager is currently queuing: "
                + this.currentTransaction.URL + " - sending this request to server and continuing to queue");
            //<DEBUG
            return false;
        }

        // - multiop with mixed xmlHttp/frames transports
        //      - send the offending current request, continue queuing
        if (haveServerRequestsOnQueue && 
            (this.currentTransaction.transport != request.transport)) 
        {
            //>DEBUG
            this.logWarn("RPCRequest with conflicting transport while queuing, sending request to"
                + " server and continuing to queue.");
            //<DEBUG
            return false;
        }
        
        // can queue
        return true;
    },

    // send a request immediately, bypassing the current queue.
    sendNoQueue : function (request) {
        var currentTransaction = this.currentTransaction;
        this.currentTransaction = this._createTransaction();
        this._addRequestToTransaction(request, this.currentTransaction);
        var sendResult = this.sendQueue();
        this.currentTransaction = currentTransaction;
        return sendResult;
    },

    _createTransaction : function () {
        // create a new transaction
    	var transactionNum = this._nextTransactionNum++;

  	    var transaction = {
            timeout: this.defaultTimeout,
			transactionNum:transactionNum,
			// the request data and context for all operations in the transaction
			operations:[], 
            responses:[],
			// the actual data to go to the server
			requestData:{transactionNum:transactionNum, operations:[]},
            // prompt to show
            prompt: this.defaultPrompt,
            showPrompt: false,
            changed : function () {       
                isc.RPCManager._transactions.setLastChanged(this);
                isc.RPCManager._transactions.dataChanged();
                isc.RPCManager._transactions.clearLastChanged();
            }
	    }
        // explicitly notify RPCTracker that this is the changed transaction
		this._transactions.addTrack(transaction);
        this._transactions.clearLastChanged();

        return transaction;
    },

    _addRequestToTransaction : function (request, transaction) {
        transaction.URL = request.actionURL;
                
        // mark transaction as a loginRPC if the request specifies it so we can quickly
        // determine this later (w/o scanning requests)
        if (request.containsCredentials) transaction.containsCredentials = true;

        // for operations that result in downloaded file, make the browser give the
        // downloaded file a particular default name
        if (request.exportFilename) transaction.URL += "/" + request.exportFilename;

        if(!transaction.download_filename) transaction.download_filename = request.download_filename;

        if (request.downloadResult || request.downloadToNewWindow) {
            transaction.download_filename = request.download_filename;
            transaction.URL += "/" + request.download_filename;
            // hitting 'cancel' on a download box can cause the server to stall and eventually time
            // out - ignore this error case
            transaction.ignoreError = true;
        }


        // grab the prompt of the first operation to define one
		if (request.prompt && !transaction.customPromptIsSet) {
			//>DEBUG
            this.logDebug("Grabbed prompt from first request that defined one: " + request.prompt);
			//<DEBUG
			transaction.prompt = request.prompt;
            transaction.customPromptIsSet = true;
		}



        // set the showPrompt for the transaction and mark the request that forced the prompt so we
        // can hide it once we're done processing that request
        if (request.showPrompt && !transaction.showPrompt && !this.neverShowPrompt) {
            request.showedPrompt = true;
            isc.addProperties(transaction, {
                showPrompt: true,
                promptStyle: request.promptStyle,
                promptCursor: request.promptCursor,
                useCursorTracker: request.useCursorTracker,
                cursorTrackerConstructor: request.cursorTrackerConstructor,
                cursorTrackerProperties: request.cursorTrackerProperties
            });
        }

        if (request.isProxied) {
            isc.addProperties(transaction, {
                isProxied: true,
                proxiedURL: request.proxiedURL
            });
        }

        transaction.transport = request.transport;    
        
        // if any request in a transaction specifies ignoreReloginMarkers, then it applies to
        // the whole transaction since relogin marker processing happens on the whole
        // transaction response.
        if (request.ignoreReloginMarkers) transaction.ignoreReloginMarkers = true;

        transaction.operations.add(request);
    
        // add request.data to list of operations.
        // XXX null and empty strings become <elem></elem> on the server which means they can't be
        // disambiguated from one another.  Also <elem></elem> doesn't translate to an entry of any
        // kind in the operations list on the server (e.g. a list with just <elem></elem> is a zero
        // length list).  This means we have to encode these two values to reliably pick them up on
        // the server.
        var data = request.data;
        if (data == null) data = "__ISC_NULL__";
        else if (data === "") data = "__ISC_EMPTY_STRING__";

        // if this is a clientOnly request, no data will be sent to the server for it
        if (!request.clientOnly) transaction.requestData.operations.add(data);

        // omit nulls must be on for all requests in transaction for us to enable the flag
        if (transaction.omitNullMapValuesInResponse !== false && request.omitNullMapValuesInResponse != null) {
            transaction.omitNullMapValuesInResponse = 
                transaction.requestData.omitNullMapValuesInResponse = request.omitNullMapValuesInResponse;
        } else {
           transaction.omitNullMapValuesInResponse = false;
        }

        if (request.ignoreTimeout) transaction._clearOnTimeout = true;

        request.transactionNum = transaction.transactionNum;

        // XXX expand this?
        if (request.timeout || request.timeout === 0) transaction.timeout = request.timeout;

        transaction.changed();
    },

    //> @classMethod RPCManager.startQueue()    
    //
    // Start queuing requests.  When queuing requests, an HTTP request will not be sent to
    // the server until RPCManager.sendQueue() is called.
    // <p>
    // All requests in a given queue must go to the same actionURL and use the same transport
    // (XMLHttp or frames).  If a request specifies a different actionURL or transport than
    // that of the requests currently on the queue, it will be sent to the server separately,
    // ahead of the queue, and a warning will be logged to the Developer Console.
    // <p>
    // Note that the server must process all requests sent as part of the queue before any
    // response is sent to the client.  You should avoid batching a request that will take a
    // long time to process on the server with any other requests because it will delay the
    // response of all requests in the queue.
    //
    // @param [shouldQueue] whether queuing should be enabled, default true.  Passing false
    //                      will disable queuing but not send the queue yet, so that any
    //                      queued requests will be sent along with the next
    //                      send()/sendRequest()
    //
	// @return	(boolean)	whether queuing was already enabled before we called
    //
    // @see RPCManager.sendQueue()
    //
    // @requiresModules SCServer
    // @visibility external
    //<       
	startQueue : function (shouldQueue) {
		var wasAlreadyQueuing = this.queuing;
		this.queuing = (shouldQueue == null ? true : shouldQueue);
		return wasAlreadyQueuing;
	},

    _promptCounter: 0,
    doShowPrompt : function (transaction, prompt) {
        if (this._promptCounter++ != 0) return;

        if (transaction.promptStyle == "dialog" && prompt != null) {
            isc.showPrompt(prompt);
            this._showedPrompt = true;
        } else {
            // cursor
            isc.EH.showClickMask(null, "hard", null, "blockingRPC");
            if (transaction.useCursorTracker) {
                this._cursorTracker = isc.ClassFactory.getClass(transaction.cursorTrackerConstructor)
                    .create(transaction.cursorTrackerProperties);
                this._cursorTracker.show();
            } else {
                isc.EH._screenSpan.setCursor(transaction.promptCursor);
            }
        }
    },

    // cursors: http://www.gtalbot.org/DHTMLSection/Cursors.html
    doClearPrompt : function (transaction) {
        if (transaction.clearedPrompt) return;
        transaction.clearedPrompt = true;

        if (--this._promptCounter != 0) {
            // safety net - whouldn't need to reset this, but we check for zero explicitly in
            // doShowPrompt
            if (this._promptCounter < 0 ) this._promptCounter = 0;
            return;
        }

        if (this._showedPrompt) {
            isc.clearPrompt();
        } else {
            if (this._cursorTracker) {
                this._cursorTracker.destroy();
                this._cursorTracker = null;
            } else {
               isc.EH._screenSpan.setCursor(isc.Canvas.DEFAULT);
            }
            isc.EH.hideClickMask("blockingRPC");
        }
        this._showedPrompt = null;
    },

    //> @classMethod RPCManager.cancelQueue()
    // Cancel a transaction (a queue of requests being sent to the server). 
    // @visibility external
    //<     
    // Note: after the transaction has been sent via sendQueue(), this method may not prevent 
    // the transaction from reaching the server
    // @param [transaction] (transaction object or identifier) Transaction to cancel - defaults
    //       to cancelling any outstanding (un-sent) queue.
    cancelQueue : function (transaction) {
        if (transaction == null) {
            // cancel the current transaction
            this.currentTransaction = null;  
            return;      
        }
        // cancel a specific transaction (outstanding)
        var transaction = this.getTransaction(transaction);
        if (transaction == null) return;        

        // clear the prompt if any of our operations showed it.
        if (transaction.showPrompt) this.doClearPrompt(transaction);

        // If an abort function is present on the transportRequest object
        // returned from the transport function, fire it to kill the transport
        // Note that this is not guaranteed to be present - depends on the implementation of
        // the transport function called by sendQueue
        if (transaction.transportRequest && transaction.transportRequest.abort) {
            transaction.transportRequest.abort();
        }

        this.clearTransaction(transaction);
    },

    // Returns the transaction object for a transasctionNum.  If passed a transaction object,
    // returns that.
    getTransaction : function (transaction) {
        if (transaction == null) return null;

        // window object
        if (transaction.location && transaction.document) {
            var win = transaction;
            // no transactionNum in the URL - this is probably because the server send an
            // HTTP redirect to a login URL instead of just feeding the login page contents
            // in response to our RPC.
            var hiddenFrames = isc.HiddenFrame._hiddenFrames;
            for (var i = 0; i < hiddenFrames.length; i++) {
                if (win == hiddenFrames[i].getHandle()) {
                    transaction = hiddenFrames[i].transactionNum;
                    break;
                }
            }   
            // still haven't found it
            if (transaction == win) {
                this.logDebug("Can't find transactionNum in getTransaction from iframe");
                return null;
            }
        }

        // index into transactions array 
        //
        // NOTE: this has to be last, because the code above that finds the transaction via the
        // window object depends on leaving transaction as a Number when it's done
        if (isc.isA.Number(transaction)) return this._transactions.find({transactionNum: transaction});

        return transaction;        
    },
    
    getCurrentTransaction : function () {
        return this.currentTransaction;
    },

    getLastSubmittedTransaction : function () {
        return this._transactions[this._transactions.length-1];
    },

    //> @classMethod RPCManager.clearTransaction() [A]
    // Erase all client-side record of a transaction, such that any response from the server
    // will be ignored.
    // <P>
    // A transaction means a batch of one or more RPCRequests that have already been sent to
    // the server via +link{RPCManager.sendQueue()}.
    //
    // @param transactionNum (id) id of the transaction to be cleared
    // @see group:relogin
    // @visibility external
    //<
    clearTransaction : function (transaction) {
        transaction = this.getTransaction(transaction);
        this.clearTransactionTimeout(transaction);
        

        // Don't remove RPCs from the transaction queue until we've had a chance to read the
        // log cookie that tells us whether the user wants to track them or not
        //
        // Have to wait until page load to read cookies
        if (!this._initializedTrackRPC && isc.Page.isLoaded()) {
            var globalLogCookie = isc.LogViewer.getGlobalLogCookie();   
            this.setTrackRPC(globalLogCookie ? globalLogCookie.trackRPC : false);
        }

        // flag transaction as cleared, if not tracking, remove from transactions queue
        transaction.cleared = true;
        if (!this._trackRPC) this._transactions.remove(transaction);
        else transaction.changed();
    },

    // internal method to flip the _trackRPC bit.  If tracking is disabled, clear any
    // transactions from the transactions queue that have completed (were marked as cleared)
    setTrackRPC : function (track) {
        this._trackRPC = track;
        if (!track) this.removeClearedRPC();
    },

    removeClearedRPC : function () {
        var cleared = this._transactions.findAll("cleared", true);
        if (cleared) this._transactions.removeList(cleared);
    },

    // Usually called by server to block new transactions and delay outstanding ones from timing out
    // while waiting for the user to do something - e.g. complete reauthentication.  

    //> @classMethod RPCManager.delayAllPendingTransactions()
    // 
    // Clears the timeouts for all currently pending RPCRequests/DSRequests and forces any
    // future RPCRequests/DSRequests into an internal queue that doesn't go to the server until
    // you call +link{RPCManager.resendTransaction()}.
    // 
    // @see RPCManager.resendTransaction()
    //<     
    delayAllPendingTransactions : function () {

        // set a global flag so any newly created transactions don't get sent to the server
        this.delayingTransactions = true;

        // clear the timeouts for outstanding transactions
        for (var i = 0; i < this._transactions.length; i++) {
            var transaction = this._transactions[i];
            this.delayTransaction(transaction);
        }
    },

    //> @classMethod RPCManager.suspendTransaction()
    // 
    // Clears the timeout for specified transaction.  You can all transactions delayed in this
    // manner by calling +link{RPCManager.resendTransaction}
    // 
    // RPC requests marked with <code>containsCredentials: true</code> ignore the delay queue.
    //
    // @param transaction (transaction Obj or ID) transaction to delay
    // @see RPCManager.resendTransaction()
    //<     
    
    suspendTransaction : function (transaction) {
        transaction = this.getTransaction(transaction);
        if (transaction.suspended) return;

        transaction.suspended = true;
        this.clearTransactionTimeout(transaction);        
        if (transaction.showPrompt) this.doClearPrompt(transaction);

        transaction.changed();
    },

    // this is called by the internal RPC page load defer mechanism
    delayTransaction : function (transaction) {
        transaction = this.getTransaction(transaction);
        if (transaction.delayed) return;
        transaction.delayed = true;
        this.clearTransactionTimeout(transaction);

        transaction.changed();
    },
    

    //>Offline
    onLine: !isc.isOffline(),

    goOffline : function () {
        this.logInfo("Going offline...");
        this.onLine = false;
    },
    goOnline : function () {
        this.logInfo("Going online...");
        // replay transactions
        this.offlinePlayback = true;
        this.playbackNextOfflineTransaction();
    },

    // observable
    offlineTransactionPlaybackComplete : function () { },

    playbackNextOfflineTransaction : function () {
        var transaction = this.offlineTransactionLog ? this.offlineTransactionLog.removeAt(0) : null;
        if (transaction == null) {
            this.logInfo("Offline transaction playback complete");
            // no more to playback, go online if the browser is online
            this.offlinePlayback = false;
            this.onLine = !isc.isOffline();            
            this.offlineTransactionPlaybackComplete();
            return;
        }

        // play it back
        // We'll get called back by performTransactionReply()
        this.resubmitTransaction(transaction);  
    },

    offlineTransaction : function (transaction) {
        if (transaction.offline) return;
        transaction = this.getTransaction(transaction);
        transaction.offline = true;
        
        this.clearTransactionTimeout(transaction);

        if (!this.offlineTransactionLog) {
            this.offlineTransactionLog = [];
            // keep it sorted by timestamp.  this is important to keep transactions that are
            // added via transactionTimeout(0 in order
            this.offlineTransactionLog.sortByProperty("timestamp", Array.ASCENDING);
        }
        this.offlineTransactionLog.add(transaction);

        transaction.changed();

        // fire fake reply callbacks
        var requests = transaction.operations;
        for (var i = 0; i < requests.length; i++) {
            var request = requests[i];
            var response = this.createRPCResponse(transaction, request, {
                httpResponseCode: 200,
                offlineResponse: true
            });

            this.delayCall("fireReplyCallbacks", [request, response], 0);
        }
    },
    //<Offline

    // if we're delaying transactions, this resubmits outstanding transactions and allows new ones
    // to go to the server.

    //> @classMethod RPCManager.resendTransaction() [A]
    // Resend a transaction to the server.
    // <P>
    // A transaction means a batch of one or more RPCRequests that have already been sent to
    // the server via +link{RPCManager.sendQueue()}.
    // <P>
    // This is typically used as part of +link{group:relogin,Relogin} handling to resend a
    // request that encountered a session timeout.
    //
    // @param transactionNum (id) id of the transaction to be re-sent
    // @see group:relogin
    // @visibility external
    //<     
    resendTransaction : function (transaction) {
        this.resendTransactionsFlagged(transaction, "suspended");
    },

    // this is called by the internal RPC page load defer mechanism
    resendDelayedTransactions : function () { 
        this.delayingTransactions = false;
        this.resendTransactionsFlagged(null, "delayed");
    },
    resendTransactionsFlagged : function (transaction, flag) {
        // resend either just the transaction passed in or all intercepted transactions (no
        // args)
        var transactions = transaction ? [this.getTransaction(transaction)] : this._transactions;

        for (var i = 0; i < transactions.length; i++) {
            transaction = transactions[i];
            if (transaction[flag]) {
                delete transaction[flag];
                this.resubmitTransaction(transaction);
            }
        }
    },

    // returns all rpcRequests for a given operation
    //
    // This may be needed for some very advanced cases of relogin or other queuing and
    // cancelling logic.
    getTransactionRequests : function (transaction) {
        return this.getTransaction(transaction).operations;
    },

    _setTransactionTimeoutTimer : function (transaction) {
        transaction = this.getTransaction(transaction);

        var timeout = transaction.timeout;
        if(!timeout && timeout !== 0) timeout = this.defaultTimeout;
        if(timeout == 0) return;

        transaction.timeoutTimer = 
            isc.Timer.setTimeout("isc.RPCManager._timeoutTransaction(" 
                                 + transaction.transactionNum + ")", timeout);
    },
    
    clearTransactionTimeout : function (transaction) {
        transaction = this.getTransaction(transaction) || 
                      this.getCurrentTransaction() ||
                      this.getLastSubmittedTransaction();
        if(!transaction) return;

        isc.Timer.clear(transaction.timeoutTimer);
    },

    _timeoutTransaction : function (transaction) {
        transaction = this.getTransaction(transaction);
        
        if (transaction._clearOnTimeout) {
            
            this.clearTransaction(transaction);
            return;
        }

        //>Offline
        if (!this.onLine) {
            // we went offline after the transaction was sent - consider this transaction
            // offline instead of returning an error
            this.offlineTransaction(transaction);
            return;
        }
        //<Offline

        transaction.results = this._makeErrorResults(transaction, {
             data: isc.RPCManager.timeoutErrorMessage,
             status: isc.RPCResponse.STATUS_SERVER_TIMEOUT
        });
        this._performTransactionReply(transaction.transactionNum)
    },

    _makeErrorResults : function (transaction, result) {
        var results = [];
        for(var i = 0; i < transaction.operations.length; i++)
            results[i] = isc.clone(result);
        return results;
    },

    // resubmit a transaction to the server.  Used to proceed after a transient or temporary
    // error, like being unable to contact the server or needing to authenticate again because
    // your session timed out.
    resubmitTransaction : function (transaction) {
        transaction = this.getTransaction(transaction) || 
                      this.getLastSubmittedTransaction();

        // wipe out stored status (eg transport error)
        transaction.status = null;

        // could be queuing a new transaction - save it off
        var queuingTransaction = this.currentTransaction;
    
        // sendQueue() operates on this.currentTransaction, so set it to the resubmitTransaction
        this.currentTransaction = transaction;

        if (transaction != null) {
            //>DEBUG
            this.logInfo("Resubmitting transaction number: " + transaction.transactionNum);
            //<DEBUG

            // if there is an operation window open from the transaction being
            // resubmitted, get rid of it
            
            
            
            delete transaction.suspended;
            delete transaction.clearedPrompt;  
            this.sendQueue();
        //>DEBUG
        } else {
            this.logWarn("No transaction to resubmit: transaction number " 
                         + transaction + " does not exist");
        //<DEBUG 
        }
        // reinstate the original currentTransaction
        this.currentTransaction = queuingTransaction;
    }, 

    // called by the SmartClient server to work around an IE issue specific to a single service
    // pack, where the browser occasionally submits an empty form
    retryOperation : function (commFrameID) {
        this.logDebug("Server-initiated operation retry for commFrameID: " + commFrameID);
        var commFrame = window[commFrameID];
        if(!commFrame) {
            this.logError("comm operation retry failed - can't locate object: " + commFrameID);
            return;
        }
        commFrame.sendData();
    },

    transactionAsGetRequest : function (transaction, baseURL, params) {
        transaction = this.getTransaction(transaction) || this.getCurrentTransaction();
        baseURL = (baseURL || transaction.URL || this.getActionURL());
        if(!params) params = {};
        params._transaction = this.serializeTransaction(transaction);
        
        return this.addParamsToURL(this.markURLAsRPC(baseURL), params);
    },

    // encode a parameter for use in a URL query string or form-style HTTP POST.
    // What to do with non-String param values:
    // While Strings, Numbers, and Booleans can be sent just as an HTML form sends
    // them, we're not in a context here to know what the server expects for Dates or
    // other types - if a particular caller wants a specific type of serialization that
    // caller needs to serialize the data before it gets to this layer.
    // NOTE: Dates: Comm.serialize would currently return "new Date(.." for a Date;
    // using the XML Schema format is a better default.  Note also that we support a flag
    // on Dates "logicalDate" that causes it to be serialized showing just the date with no
    // time values.
    encodeParameter : function (paramName, paramValue) {
        if (isc.isA.Date(paramValue)) {
            isc.Comm.xmlSchemaMode = true;
            paramValue = paramValue.toSchemaDate();
            isc.Comm.xmlSchemaMode = null;
        } else if (isc.isA.Array(paramValue)) {
            // for Array values, list the same parameter multiple times.  This
            // matches what HTML forms do for multiple selects
            var output = isc.SB.create();
            for (var i = 0; i < paramValue.length; i++) {
               output.append(this.encodeParameter(paramName, paramValue[i]));
               if (i < paramValue.length-1) output.append("&");
            }
            return output.toString();
        } if (!isc.isA.String(paramValue)) {
            paramValue = isc.Comm.serialize(paramValue);
        }
        return isc.SB.concat(encodeURIComponent(paramName), "=",
                             encodeURIComponent(paramValue));
    },

    addParamsToURL : function (baseURL, params) {
        var result = baseURL;
        if (!params) return baseURL;
        for (var paramName in params) {
            var paramValue = params[paramName];

            result += result.contains("?") ? "&" : "?";
            result += this.encodeParameter(paramName, paramValue);
        }
        return result;
    },

	// based on the dataEncoding setting returns the string-serialized version of the
	// requestData member of the passed in transaction object.
	serializeTransaction : function (transaction) {
        var result;
		if (this.dataEncoding == "JS") {
            
            isc.Comm._legacyJSMode = true;
            result = isc.Comm.serialize(transaction.requestData);
            isc.Comm._legacyJSMode = null;
        } else {
            result = isc.Comm.xmlSerialize("transaction", transaction.requestData);
        }
        //this.logWarn("serialized transaction: " + result);
        return result;
	},

    
    markURLAsRPC : function (URL) {
        if(!URL.contains("isc_rpc=")) URL += (URL.contains("?") ? "&" : "?")  
                                                    + "isc_rpc=1&isc_v="+isc.versionNumber;
        return URL;
    },
    
    markURLAsXmlHttp : function (URL) {
        if(!URL.contains("isc_xhr=")) URL += (URL.contains("?") ? "&" : "?")  + "isc_xhr=1";
        return URL;
    },

    addDocumentDomain : function (URL) {
        if(!URL.contains("isc_dd=")) URL += (URL.contains("?") ? "&" : "?")  + "isc_dd="+document.domain;
        return URL;
    },

    //> @classMethod RPCManager.sendQueue()
    //
    // Send all currently queued requests to the server.  You need only call this method if you are
    // using queuing otherwise your requests are synchronously submitted to the server.
    // <br><br>
	// NOTE: if you aren't the caller who first enables queuing (startQueue() returns
    // true), you should in general avoid calling sendQueue(), because whoever was
    // first to enable queuing may have more requests to add to the same queue.
    //
    // @param [callback] (Callback) Callback to fire when the queued operations complete. Callback
    // will be fired with 1 paramter: <code>responses</code> an array of +link{DSResponse} or 
    // +link{RPCResponse} objects that were part of the transaction fired by this method.
    // 
    // @see classMethod:RPCManager.send()
    // @see classMethod:RPCManager.sendRequest()
    // @see classMethod:RPCManager.startQueue()
    //
    // @requiresModules SCServer
    // @visibility external
    //<
	sendQueue : function (callback, prompt, URL) {
		var transaction = this.currentTransaction;
        // we're going to submit this transaction or error out in some way - in either way we're not
        // going to continue queueing
        this.currentTransaction = null;
		this.queuing = false;

		if (!transaction) {
			//>DEBUG
			this.logWarn("sendQueue called with no current queue, ignoring");
			//<DEBUG
			return false;
		}

        // for flags such as "directSubmit" that affect the entire transaction, use the first
        // request
        var request = transaction.operations[0];

        
        if (!isc.Page.isLoaded()) {
            if (!this.delayingTransactions) isc.Page.setEvent("load", this, isc.Page.FIRE_ONCE,
                                                               "resendDelayedTransactions");
            this.delayingTransactions = true;
        }

        if (this.delayingTransactions) {
            this.delayTransaction(transaction);
            return request;
        }

        //>Offline
        // keep a timestamp of when the transaction was sent for offline mode
        transaction.timestamp = new Date().getTime();
        if (!this.onLine && !this.offlinePlayback) {
            // check internal onLine flag instead of isc.isOffline() because we want to make
            // sure that offline transaction playback completes before new requests are sent to
            // the server, preserving order
            this.offlineTransaction(transaction);
            return request;
        }
        //<Offline

        // if all the operations are clientOnly, we don't need to go to the server at all
		var allClientOnly = true;
		for (var i = 0; i < transaction.operations.length; i++) {
			if (!transaction.operations[i].clientOnly) {
				allClientOnly = false;
				break;
			}
		}
		if (allClientOnly) {
            transaction.allClientOnly = true;   
            
            this.delayCall("_performTransactionReply", [transaction.transactionNum], 0);
			return request;
		}
		
        // figure out the prompt and URL, saving them on the transaction object in case we need to
        // delay
        // NOTE use Page.getURL() to support special directories such as "[APPFILES]"
        URL = transaction.URL = isc.Page.getURL(URL || transaction.URL || this.getActionURL());        
        if (!request.useSimpleHttp && transaction.transport != "scriptInclude") {
            URL = this.markURLAsRPC(URL);
            if (transaction.transport == "xmlHttpRequest") URL = this.markURLAsXmlHttp(URL);
            if (document.domain != location.hostname) URL = this.addDocumentDomain(URL);
            // add transactionNum to URI
            URL = this.addParamsToURL(URL, {isc_tnum: transaction.transactionNum});
        }
        prompt = transaction.prompt = ((transaction.showPrompt == null || transaction.showPrompt) ? 
            (prompt || transaction.prompt || this.defaultPrompt) : null);

        if (prompt) this.doShowPrompt(transaction, prompt);

        // support RPCRequest.params
        var transactionParams = {};
        var haveParams = false;
        for (var i = 0; i < transaction.operations.length; i++) {
            var rpcRequest = transaction.operations[i];
            var params = rpcRequest.params;
            var queryParams = rpcRequest.queryParams;
            var origParams = params;

            // undocumented - request.queryParams applied to URL - key collisions
            // result in multivalued param on server (which is in contrast to the way
            // request.params works, where last key overrides)
            if (queryParams && isc.isAn.Object(queryParams)) {
                URL = transaction.URL = this.addParamsToURL(URL, queryParams);
            }

            //>DEBUG
            if (params && haveParams)
                this.logWarn("Multiple RPCRequests with params attribute in one transaction - merging");
            //<DEBUG

            if (params) {
                if (isc.isA.String(params)) {
                    if (window[params]) params = window[params]; // component
                    else if (isc.Canvas.getForm(params)) params = isc.Canvas.getForm(params); // native form
                    else {
                        //>DEBUG
                        this.logWarn("RPCRequest: " + isc.Log.echo(rpcRequest) 
                            + " was passed a params value: " + params 
                            + " which does not resolve to a component or a native"
                            + " form - request to server will not include these params");
                        //<DEBUG
                        params = null;
                    }   
                }
                if (isc.isA.Class(params)) {
                    if (params.getValues) params = params.getValues();
                    //>DEBUG
                    else {
                        this.logWarn("RPCRequest: " + isc.Log.echo(rpcRequest)
                            + " was passed an instance of class " + params.getClassName()
                            + " (or a global ID that resolved to this class)"
                            + " - this class does not support the getValues() method - request to"
                            + " server will not include these params");
                    }
                    //<DEBUG
                }
            
                if (params && !isc.isAn.Object(params)) {
                    //>DEBUG
                    this.logWarn("params value: " + origParams + " for RPCrequest: " 
                        + isc.Log.echo(rpcRequest) + " resolved to non-object: " 
                        + isc.Log.echo(params) + " - request to server will not include these params");
                    //<DEBUG
                    params = null;
                }

                if (params) {
                    isc.addProperties(transactionParams, params);
                    haveParams = true;
                }
            }
        }

		//>DEBUG
        if (this.logIsInfoEnabled()) {
    		this.logInfo("sendQueue[" + transaction.transactionNum + "]: " +
	    				 transaction.operations.length + " RPCRequest(s); transport: " +
                         transaction.transport + "; target: " + URL);
        }
		//<DEBUG

		//>DEBUG
		transaction.sendTime = isc.timeStamp();
		//<DEBUG
        
        // about to send
        transaction.changed();
        
        
        // call performTransactionReply when the transaction completes (regardless of transport)
        //if (callback) transaction.callback = callback;
        transaction.callback = "isc.RPCManager.performTransactionReply(transactionNum,results,wd)";
        if (callback) transaction._userCallback = callback;
               
            // send the request to the server via the configured transport
            var params = transactionParams;

            // Call isc.Comm.send<TransportType>(...)
            var transport = transaction.transport,
                transportMethodName = "send" + (transport.substring(0,1).toUpperCase()) + transport.substring(1);

            if (isc.Comm[transportMethodName] == null) {
                this.logWarn("Attempt to send transaction with specified transport '"
                             + transaction.transport + "' failed - unsupported transaction type.");
                return;
            }

            this._setTransactionTimeoutTimer(transaction);
            
            // Track the transactions that have been sent but not yet returned
            
            isc.RPCManager._activeTransactions.push(transaction.transactionNum);

            // Allow the transport method to return a transactionRequest object 
            transaction.transactionRequest = isc.Comm[transportMethodName]({
                URL: URL, 
                httpMethod: request.httpMethod,
                contentType: request.contentType,
                httpHeaders: request.httpHeaders,
                bypassCache: request.bypassCache,
                data: request.useSimpleHttp ? request.data : null,
                fields: params, 
                target: request.target,
                // valid only for scriptInclude
                callbackParam: request.callbackParam,
                transport: transaction.transport,
                blocking: request.blocking,
                useSimpleHttp:request.useSimpleHttp,
                transactionNum: transaction.transactionNum,
                transaction: transaction
            });

        

		return request;
	},

	// called by the rpcRequest.transport with the server results.
    // - for xmlHttpRequest transport, "results" is an xmlHttpRequest, and it's contents may be
    //   eval'd or delivering directly based on settings like evalResult
    // - for other transports, a JavaScript object is delivered
	performTransactionReply : function (transactionNum, results, wd) {
    	// look up this transaction
		var transaction = this.getTransaction(transactionNum);
		if (!transaction) {
            
			//>DEBUG
			this.logWarn("No such transaction " + transactionNum);
			//<DEBUG
			return false;
		}

        transaction.receiveTime = isc.timeStamp();
        transaction.changed();
        
        isc.RPCManager._activeTransactions.remove(transactionNum);
		//>DEBUG
		this.logInfo("transaction "+transactionNum + " arrived after " +
					 (transaction.receiveTime - transaction.sendTime) + "ms");
		//<DEBUG

        

		// if there are no results, something catastrophic happened
		if (results == null) {
			//>DEBUG
			this.logFatal("No results for transaction " + transactionNum);
			//<DEBUG
            
			return false;
		}

        // results is the xmlHttpRequest object - the results is the responseText
        if (transaction.transport == "xmlHttpRequest") {
            var xmlHttpRequest = results;

            transaction.xmlHttpRequest = xmlHttpRequest;
            results = xmlHttpRequest.responseText;

            // Crazy FF bug - if the network cable is unplugged, accessing xhr.status throws a
            // chrome exception and stops execution - but accessing other attributes such as
            // responseText works fine
            var status;
            try {            
                status = xmlHttpRequest.status;
            } catch (e) {
                this.logWarn("Unable to access XHR.status - network cable unplugged?");
                status = -1;
            }

            // In IE, the status code will sometimes be reported as "1223" when IE has
            // actually received "204: No content".  We've seen this with the local HTTPProxy
            // relaying a 204 response from Amazon S3, and this has been publicly reported in
            // connection with "kupu", try searching for "http status 1223"
            if (status == 1223) status = 204;

            // using XMLHttpRequest against the filesystem results in an HTTP code of zero -
            // very strange, but need to support this as a non-error case.
            //
            // Note that status == 0 can also mean a security violation whereby an XHR request
            // to the origin server receives a 302 redirect to a non-origin server.  IE reports
            // this is status 0, so we check against location.protocol here to disambiguate.
            // Note the "app-resource:" protocol is returned by Adobe AIR when accessing 
            // files as local resources
            if (status == 0 && 
                (location.protocol == "file:" || location.protocol == "app-resource:")) 
                    status = 200;

            // actually modify the response code so upstream code works without handling these
            // cases
            transaction.httpResponseCode = status;
            transaction.httpResponseText = xmlHttpRequest.responseText;

            // relogin support
            // users can specify the ignoreReloginMarkers flag to have login response code
            // processing be disabled - useful for custom network formats where the relogin
            // marker could appear
            if (status != -1 && !transaction.ignoreReloginMarkers && 
                 this.processLoginStatusText(xmlHttpRequest, transactionNum))
            {
                return;
            }
            
            // additional end-user hook just in case
            if (status != -1 && this.responseRequiresLogin(xmlHttpRequest, transactionNum)) {
                this.handleLoginRequired(transactionNum);
                return;
            }

            if (status != -1 && this.responseIsRelogin(xmlHttpRequest, transactionNum)) {
                this.handleLoginRequired(transactionNum);
                return;
            }
            // All HTTP 2xx codes indicate success.  Success codes other than 200 OK are
            // somewhat obscure, but are used by Amazon S3 and possibly other REST APIs
            if (status > 299 || status < 200) { //error
                var url = transaction.URL;
                if (transaction.isProxied) {
                    url = transaction.proxiedURL+" (via proxy: " + url +")";
                }
                results = this._makeErrorResults(transaction, {
                    data : "Transport error - HTTP code: "+ status
                           +" for URL: " + url
                           + (status == 302 ? " This error is likely the result"
                              + " of a redirect to a server other than the origin"
                              + " server or a redirect loop." : ""),
                    status: isc.RPCResponse.STATUS_TRANSPORT_ERROR
                });

                this.logDebug("RPC request to: " + url 
                             + " returned with http response code: " 
                             + status +". Response text:\n"
                             + xmlHttpRequest.responseText);
                transaction.status = isc.RPCResponse.STATUS_TRANSPORT_ERROR;
            }
        }

        // store the results array in the transaction results
        transaction.results = results;
        this._performTransactionReply(transactionNum);
		return true;
	},

    responseIsRelogin : function (xmlHttpRequest, transactionNum) {
        var status = xmlHttpRequest.status;

        // When the user session has timed out, an HTTP authenticator will typically respond to
        // a request with a 302 redirect.  When document.domain is set, and the redirect
        // targets what looks to the browser like a non-origin server, browsers behave
        // inconsistently (probably because the XHR spec doesn't deal with this issue).  The
        // problem is that since the content targeted by the XHR request doesn't execute,
        // there's no way for the browser to know that it's safe relative to the document.domain
        // setting of the page.  As a result, browsers simply block access to the content that
        // ultimately comes back via the 302 redirect.
        //
        // This is a problem for us because we rely on our relogin markers to execute or arrive
        // as a string so we can tell that a relogin is required.  The solution is as follows:
        //
        // FF: when the above occurs, FF returns an HTTP status code of 302, which is normally
        // impossible, except for a redirect loop.  If the user sets the special
        // treatRedirectAsRelogin flag, we'll use that as the discriminator.  One problem with
        // this is that if the page has set document.domain and the server returns a 302, even
        // one that targets the origin server, FF will report the status as 302.  This means
        // that relogin in FF with document.domain set is not transparently compatible with
        // other logic on the page that may rely on local redirects.
        //
        // IE: If the request that triggered the redirect contained no body, IE reports a
        // status code of 0.  If there was a body, IE bogusly reports status 200, but the xhr
        // contains an empty responseText and empty response headers, so we use these two
        // discriminators in IE.
        //
        // Safari untested.
        if (document.domain != location.hostname &&
            (
             // FF
             (status == 302 && this.treatRedirectAsRelogin) ||
             // IE - no body sent in request that generated the off-site redirect
             (status == 0) ||
             // IE - body was sent in request that generated the off-site redirect
             (status == 200 && xmlHttpRequest.getAllResponseHeaders() == isc.emptyString &&
              xmlHttpRequest.responseText == isc.emptyString)
            ))
        {
            this.logDebug("Detected document.domain 302 relogin condition - status: "+status);
            return true;
        }
        return false;
    },

    // NOTE: because we scan *any* response for these markers, there is the
    // potential for a spoof attack where such a marker is embedded in user data such as a
    // forum post, where every time that post is loaded via RPC, we would think session timeout
    // had occurred.  Hence this marker is designed so that it would be invalid in:
    // - a JS string or XML attribute (embedded quotes of each type)
    // - XML payload (CDATA terminator, followed by additional >)
    // - HTML content, because the most rudimentary data cleaners should remove or deactivate
    //   <SCRIPT> in user data displayed within HTML
    loginStatusCodeMarker: "<SCRIPT>//'\"]]>>isc_",
    loginRequiredMarker: "<SCRIPT>//'\"]]>>isc_loginRequired",
    loginSuccessMarker: "<SCRIPT>//'\"]]>>isc_loginSuccess",
    maxLoginAttemptsExceededMarker: "<SCRIPT>//'\"]]>>isc_maxLoginAttemptsExceeded",
    processLoginStatusText : function (xhr, transactionNum) {
        // don't scan long RPC responses for relogin
        var text = xhr.responseText;
        // In Safari, if you target a file that is empty, the response text is null
        if (text && text.length < this.maxLoginPageLength) {
            var iscIndex = text.indexOf(this.loginStatusCodeMarker);
            if (iscIndex == -1) return false;
            if (text.indexOf(this.loginRequiredMarker, iscIndex) != -1) {
                this.handleLoginRequired(transactionNum);
                return true;
            } else if (text.indexOf(this.loginSuccessMarker, iscIndex) != -1) {
                this.handleLoginSuccess(transactionNum);
                return true;
            } else if (text.indexOf(this.maxLoginAttemptsExceededMarker, iscIndex) != -1) {
                this.handleMaxLoginAttemptsExceeded(transactionNum);
                return true;
            }
        }
        return false;
    },
    processLoginStatusCode : function (rpcResponse, transactionNum) {
        if (rpcResponse.status == isc.RPCResponse.STATUS_LOGIN_REQUIRED) {
            this.handleLoginRequired(rpcResponse.transactionNum);
            return true;
        } else if (rpcResponse.status == isc.RPCResponse.STATUS_LOGIN_SUCCESS) {
            this.handleLoginSuccess(rpcResponse.transactionNum);
            return true;
        } else if (rpcResponse.status == isc.RPCResponse.STATUS_MAX_LOGIN_ATTEMPTS_EXCEEDED) {                
            this.handleMaxLoginAttemptsExceeded(rpcResponse.transactionNum);
            return true;
        }
        return false;
    },
    // extra end-user hook
    responseRequiresLogin : function (xmlHttpRequest, transactionNum) {
        return false;
    },

    // create an RPCResponse, defaulting various fields based on the HTTP transaction it was
    // part of
    createRPCResponse : function (transaction, request, props) {
        return isc.addProperties({
            operationId: request.operation.ID,
            // expose the passed clientContext
            clientContext : request.clientContext,
            // backcompat: expose the entirety of the dsRequest as context (flags used to be
            // merged with preserved data)
            context: request,
            transactionNum: transaction.transactionNum, 
            httpResponseCode: transaction.httpResponseCode,
            httpResponseText: transaction.httpResponseText,
            xmlHttpRequest: transaction.xmlHttpRequest,
            transport: transaction.transport,
            status: transaction.status,
            clientOnly: request.clientOnly
        }, props);
    },

    
	_performTransactionReply : function (transactionNum) {
        //!OBFUSCATEOK
		// get a pointer to the specified transaction
		var transaction = this.getTransaction(transactionNum);

        // we no longer clear transactions here as they can be suspended during an rpcResponse
        // callback, but we do need to clear the timeout here since the server has definitely
        // replied.
        this.clearTransactionTimeout(transactionNum);

        // The transaction could have timed out, but the server could in theory return just
        // after the timeout.  Since the timeout will have cleared the transaction object,
        // check it here.
		if (!transaction) return;

        //>DEBUG
        if (this.logIsDebugEnabled()) {
            this.logDebug("Result string for transaction "+transactionNum+": " + isc.Log.echoAll(transaction.results));
        }
        //<DEBUG
        
        
        
        if (transaction.allClientOnly) {
            

            transaction.results = {status:0};
        } else {
            // the results are available as a single string, which we can eval to get JS
            // objects.  

            
        }

        var results = transaction.results;

        

        var requests = transaction.operations,
            responses = [];
        
        // pair up the requests with their results.  
		for (var i = 0, j = 0; i < requests.length; i++) {
            
            var request = requests[i];
            var response = isc.addProperties(this.createRPCResponse(transaction, request), {
                
                // for scriptInclude, make all values available via callbackArgs - typically
                // there will be only one - and that's accessible via "data", but all args
                // are available via this callbackArgs - not currently exposed
                callbackArgs : transaction.transport == "scriptInclude" ? results : null,
                
                // get the results from the server results array; 
                //
                // if the response is not an rpc, then the same response applies to all
                // requests.  In general we really expect there to be only one request for non
                // RPC responses.
                results: 
                                                results
                });

            // if no status has been set on the response, set to SUCCESS.  This can happen with
            // unstructured responses that simply load a file.
            if (response.status == null) response.status = 0;

            
            responses[i] = response;
            transaction.responses[i] = response;
            transaction.changed();
		}

        var requestNum = 0;
        while (requestNum < requests.length && !transaction.suspended) {
            var request = requests[requestNum],
                response = responses[requestNum];

            this.performOperationReply(request, response);
            requestNum++;
        }
        if (transaction.showPrompt) this.doClearPrompt(transaction);

        // cleanup the transaction unless it's been suspended
        if (!transaction.suspended) {
            this.clearTransaction(transactionNum);
        }

        // if this was an offline transaction, we're in playback mode - playback the next one
        if (transaction.offline) this.playbackNextOfflineTransaction();
        // fire the callback passed into sendqueue()
        if (transaction._userCallback) {
            var application = request.application ? request.application 
                                              : this.getDefaultApplication();
            if (isc.isA.String(application)) application = window[application];
            application.fireCallback(transaction._userCallback, "responses", [transaction.responses]);        
        }
	},

	performOperationReply : function (request, response) {
		var results = response.results,
			operation = request.operation;

		//>DEBUG
        if (this.logIsInfoEnabled()) {
            
                this.logInfo("rpcResponse(unstructured) results -->" 
                    + isc.Log.echoAll(results) + "<--");
            
        }
		//<DEBUG

        // support override of login response code handling
        if (this.processLoginStatusCode(response, response.transactionNum)) return;

        

        return this.fireReplyCallbacks(request, response);
	},

    fireReplyCallback : function (callback, request, response, data) {
        
        var application = request.application ? request.application 
                                              : this.getDefaultApplication();
        if (isc.isA.String(application)) application = window[application];
        var callbackResult = application.fireCallback(callback,
                                "rpcResponse,data,rpcRequest", [response, data,request]);
        return callbackResult;
    },

    evalResult : function (request, response, results) {
        var evalVars = request.evalVars;
        this.logDebug("evaling result" + (evalVars ? " with evalVars: " + isc.Log.echo(evalVars) : ""));

        var origAutoDraw = isc.Canvas.getInstanceProperty("autoDraw");
        if (request.suppressAutoDraw) isc.Canvas.setInstanceProperty("autoDraw", false);
        
        var evalResult = isc.Class.evalWithVars(results, evalVars);
        if (request.suppressAutoDraw) isc.Canvas.setInstanceProperty("autoDraw", origAutoDraw);
        return evalResult;
    },

    // called by performOperationReply
    fireReplyCallbacks : function (request, response) {
        var operation = request.operation,
            results = response.results,
            // ignore evalResult for scriptInclude - not relevant
            evalResult = request.evalResult && request.transport != "scriptInclude" ? 
                this.evalResult(request, response, results) : null
        ;

        // for RPC rsponses, 'data' is the data value in the response object literal.  For
        // evalResult, it's the result of the eval (see above).  For serverOutputAsString, it's
        // the server string
        var data;
        
            data = (request.evalResult ? evalResult : results);

        // always have 'data' be available on the response object as well
        response.data = data;

        var transaction = this.getTransaction(response.transactionNum);

        // fire all callbacks set on the request
        // call callbacks:
        // - request.callback is passed to RPCManager.send/sendRequest
		// - context.afterFlowCallback is passed to actionMethods such as ListGrid.fetchData(),
        //   generally by application code that needs to do something after a canonical flow
        //   completes
        // Really, "flows" implemented on top of the RPC mechanism should provide their own,
        // chained callback to any higher layer.  Instead, for the moment, the RPCManager fires
        // exactly two level of callbacks in series.
		var callback = request.callback;
        if (callback != null) {

            // use fireCallback() to fire the callback
            this.fireReplyCallback(callback, request, response, data);
		}
    },

    // Error handling
	// --------------------------------------------------------------------------------------------
	
    //> @classMethod RPCManager.handleError()
    // <code>handleError</code> will be called if +link{rpcResponse.status} is negative and
    // +link{rpcRequest.willHandleError} was not set.
    // <p>
    // This method is called for both +link{DSResponse}s and +link{RPCResponse}s that have a
    // non-success status.  You can check whether the response is a DSResponse by checking
    // <code>response.isDSResponse</code>.
    // <p>
    // By default <code>handleError()</code> always logs a warning.  In addition, if
    // +link{rpcResponse.data, response.data} was set to a String, a warning dialog will be
    // shown to the user with response.data as the message, which allows the server to send
    // user error messages back without writing custom client-side error handling.
    // <p>
    // To do custom error handling that is specific to a particular component or type of
    // request, set +link{rpcRequest.willHandleError} and deal with errors in the
    // rpcRequest.callback.  To change the default system-wide error handling, override this
    // method.  Note that since <code>handleError()</code> is a class method, to override it
    // you will call +link{Class.addClassProperties(),addClassProperties()} rather than
    // addProperties(), like so:
    // <pre>
    //     isc.RPCManager.addClassProperties({
    //         handleError : function (response, request) { .. custom handling .. }
    //     })
    // </pre>
    // <p>
    // If you're using the xmlHttpRequest +link{rpcRequest.transport}, you can access the 
    // +externalLink{http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html,HTTP status code}
    // of the response (eg 404 Not Found or 500 Server Error) as +link{rpcResponse.httpResponseCode}.
    // <P>
    // For very advanced usage, the response.xmlHttpRequest contains the native XMLHttpRequest
    // object used to make the request.  Accessing this object is subject to possible
    // cross-platform bugs and inconsistencies, and Isomorphic recommends that you wrap any
    // access to the XMLHttpRequest object in a try/catch block because some browsers may throw
    // exceptions when certain attributes of this object are accessed.  For example, if you try
    // to access XMLHttpRequest.status (for the HTTP status code) when the network cable 
    // is unpluged in Windows, you'll get an Exception in Firefox.
    //
    // @param response (Response) the RPCResponse or DSResponse object returned from the server
    // @param request (Request) the RPCRequest or DSRequest that was sent to the server
    // 
    // @see DataSource.handleError()
    // @group operations
    // @visibility external
    //<
    _handleError : function (response, request) {
        if (response.ignoreError) return;

        // if this is a dsRequest, check for a handleError() method on the DataSource and call
        // that if it exists    
        if (request.dataSource) {
            var ds = isc.DataSource.get(request.dataSource);
            if (ds && ds.handleError) {
                // call the handler - if it returns false, suppress call to handleError
                var val = ds.handleError(response, request);
                if (val == false) return;
            }
        }
        this.handleError(response, request);
    },
	handleError : function (response, request) {
		var context = (response.context ? response.context : {}),
            message;
		if (isc.isA.String(response.data)) {
			// this lets the developer show an arbitrary error message generated by the server,
            // for things like authorization code that a developer doesn't want to build
            // client-side
			message = response.data;
            if (isc.isA.String(message)) {
                var messageToShow = message;
                if (messageToShow.length > this.maxErrorMessageLength) {
                    var delta = messageToShow.length - this.maxErrorMessageLength;
                    messageToShow = messageToShow.substring(0, this.maxErrorMessageLength)
                                    + "<br><br>...("+delta+" bytes truncated - set"
                                    + " isc.RPCManager.maxErrorMessageLength > "
                                    + this.maxErrorMessageLength 
                                    + " to see more or check the Developer Console for full error)...";
                }
                isc.warn(messageToShow.asHTML());
            }
		} else {
            // find the name of the constant for the reported error num, if there is one
            var codeName = isc.getKeyForValue(response.status, isc.RPCResponse.errorCodes);
            if (isc.isA.String(codeName)) { 
                if (codeName.startsWith("STATUS_")) codeName = codeName.substring(7);
            } else {
                codeName = "number: " + (response.status != null ? response.status : "unknown");
            }
            var opName = response.operationId || response.operationType;
            message = "Error performing " + (opName ? "operation: '" + opName + "'" : "rpcRequest")
                        + ": error: " + codeName;
		}
        // log regardless
        this.logWarn(message + ", response: " + this.echo(response));
		
		// return false meaning don't proceed 
		return false;
	},
	
	
//> @groupDef relogin
// 
// For applications that require authentication and use session timeout, a background RPC may
// occur with an expired session.  The ideal handling of this scenario is that, with the attempted
// transaction still suspended, a modal dialog is used to re-authenticate the user, and then the
// original transaction is resumed without loss of data or context.  SmartClient makes it easy to
// implement this ideal handling <i>without</i> having to implement session timeout handling in
// every codepath that contacts the server, by providing central notification of session timeout,
// and the ability to re-send a transaction that encountered session timeout.
// <P>
// When session timeout occurs, typical authentication systems intercept requests to protected
// resources and return a page that tells the user that login is required.  With a background RPC
// this page won't be shown to the user.
// <P>
// To enable SmartClient to detect that session timeout has occurred, a snippet of HTML called the
// loginRequiredMarker must be added to the session timeout response sent by the authentication
// system.  The loginRequiredMarker is standardized and does not need to be customized for your
// deployment.  It can be added to an HTML page without visual effect, or if the response sent on
// session timeout is not an HTML page, simply embedded in any other type of response, or sent
// as the entirety of the response.  The loginRequiredMarker is in
// isomorphic/login/loginRequiredMarker.html.
// <P>
// When SmartClient detects the loginRequired marker, the transaction that encountered session
// timeout is put on hold, and +link{RPCManager.loginRequired()} is called.  At this point you
// have a few options:
// <ol>
// 
// <li> Leave the SmartClient application and take the user to the login page, by simply doing a
// <code>window.location.replace(<i>myLoginURL</i>)</code>, the simplest but least user friendly
// option.
// 
// <li> Open a new browser window that goes to your plain HTML login form (or offer a link that
// opens such a browser window), using a modal dialog in the application page that prompts the
// user to login before continuing, then re-send the intercepted transaction
// (+link{RPCManager.resendTransaction()} when the user indicates he has logged in.
// This is simple, does not drop context, but is not seamless.
// 
// <li> Use a SmartClient interface, typically a DynamicForm in a Window, to collect credentials,
// perform login as a background RPC, and on success re-send the intercepted transaction
// (+link{RPCManager.resendTransaction()}.  A complete example of this, which assumes
// an authentication system that can take credentials as HTTP POST params, is included in the SDK
// as isomorphic/login/reloginFlow.js.
// 
// </ol>
// <B>Authentication via background RPC form POST</B>
// <P>
// The approach shown in reloginFlow.js posts the credentials gathered from the user to
// +link{RPCManager.credentialsURL}.  To make this work with an authentication system that can
// accept credentials via HTTP POST:
// <ol>
// <li> set the RPCManager.credentialsURL to the URL where credentials should be POST'd
// <li> include reloginFlow.js in your page, modified, if necessary, so that the names of the
// USERNAME and PASSWORD params match what your authentication system uses
// <li> configure your authentication system to send back the loginSuccessMarker as part of a
// successful login response, and the loginRequiredMarker as part of a failed login response
// </ol>
// If your authentication system can accept POST'd credentials at any URL it protects, the last
// step may be as simple as configuring the loginSuccessMarker file itself as a protected
// resource (isomorphic/login/loginSuccess.html).
// <P>
// <B>Authentication via background SmartClient server RPC/DMI</B>
// <P>
// If you are using the SmartClient Java server and your authentication system allows you to mark
// a user as authenticated from Java, you can perform a normal RPC or DMI with the credentials
// gathered from the user and send back success or failure indications as normal RPC or DMI
// responses.  This can be useful if, in addition to logging in, you want to send back additional
// data.
// <P>
// <B>Advanced: concurrency</B>
// <P>
// If, after loginRequired() has fired and before the user has re-authenticated, you send
// additional RPCs to protected URLs, you will get additional loginRequired() notifications.  This
// may happen to applications that poll for data or periodically save without user action.  You
// may wish to avoid this by setting an application-specific flag to avoid firing requests during
// the relogin process.  However, you must ultimately either
// +link{RPCManager.resendTransaction(),resend} or +link{RPCManager.clearTransaction(),discard}
// every transaction for which loginRequired() fires, or you will have a memory leak due to
// suspended transactions.
// <P>
// Note also that there is no requirement that the relogin process blocks user interaction.
// Applications that access multiple services may choose to simply show an unobtrusive error
// indication such that the user can log back in at his liesure, or even log the user back in
// automatically.
//
// @title Relogin
// @visibility external
// @treeLocation Client Reference/RPC
//<



    // Relogin design:
    //  - NOTE: relogin is unlike other error codes that might be returned in an RPCResponse
    //    because the ideal handling is to process relogin and then proceed with the original
    //    request, transparently to the requesting code.  Since the requesting code ultimately
    //    receives a normal response, representing a login failure as an RPCResponse would mean
    //    two responses to the same request
    //  - two types of interceptor:
    //    - 1. server code is capable of adding a canned snippet to indicate login required
    //      - this is how the SmartClient server authenticator works
    //      - this covers SiteMinder-style interceptors that send back HTML pages 
    //    - 2. non-ISC backends that send WSDL, XML or JSON responses with error codes, which
    //        cannot be modified to return special snippets, hence must be interpreted by
    //        custom logic in the client-side DataSource layer 
    //    - NOTE: the above only covers detection scenarios - the other half of the problem is
    //      how to pull off reauthentication in the background with various types of
    //      authentication systems
    //
    // - SiteMinder-style intercept relogin flow: authentication system will send back an HTML
    //   page rather than a clean RPC response
    //   - a snippet added to the login page calls rpc.loginRequired
    //     - in xmlHttp this is detected by scanning the response.  In hiddenFrames comm the
    //       code executes automatically and calls RPC layer 
    //   - relogin flows:
    //     - case 1: login is possible via get/post of params or other background RPC
    //     - case 2: login is only possible via using the login form sent back by the
    //       interceptor, because eg it writes out a form with some state in it
    //   - for case 1, you could:
    //     1. use an ISC-based relogin form to gather credentials from the user
    //     2. relogin via RPC, either:
    //        a. as a normal RPC with the ISC server
    //        b. for non-ISC server: embed standardized response markers that ISC recognizes as
    //           success vs failure
    //          - NOTE: someone could roll their own success/failure detection here, but it's
    //            complicated to do so if you need hiddenFrames comm backCompat, and adds
    //            complexity to the explanation
    //     3. call resubmitTransaction() once relogin has been achieved
    //     .. or your could take the approach for case 2, which might be simpler
    //   - for case 2
    //     1. use either an ISC Window or a separate browser window to show the actual HTML
    //        login form sent by the interceptor.  This window (either kind) should be directed
    //        to isomorphic/login/loginSuccessMarker.html and this resource should be
    //        protected by the interceptor such that, after successful login,
    //        loginSuccessMarker.html is loaded
    //        - reloginSuccess.html has a snippet of code that calls rpc.loginSuccess, the
    //          default implementation being to resubmit transactions that were intercepted
    //
    // - DataSource error code-based relogin
    //   - need for relogin is indicated by some error code that can only be detected in the
    //     DataSource layer
    //   - NOTE: in eg DataSource.transformResponse() the appropriate spot to interpret error
    //     codes, we are still in a position to transparently resubmit an intercepted request:
    //     - the custom DS layer is responsible for firing the DBComponent-level callback, so
    //       can leave the DBComponent in limbo during relogin interaction
    //     - the RPC layer will not remove the prompt until the DS layer is done processing 
    //   - call suspendTransaction(dsResponse.transactionNum)
    //   - show UI and accomplish relogin as for SiteMinder case
    //
    //  Note: while we are handling relogin, eg, waiting for the user to type in credentials,
    //  further requests to the same protected resource will trigger repeated loginRequired()
    //  notifications.  This situation is fairly rare but could arise with eg, polling.
    //  We shouldn't try to handle this by blocking all RPCs because an application may consume
    //  multiple services and requiring login may not be an application-halting event (eg,
    //  multi-service IM client).  So we expect that in this case, the application developer
    //  either sets a flag to avoid doing more RPCs during relogin or handles multiple
    //  loginRequired() notifications.
    //  Note that, for the case of polling in particular, it is basically required that either
    //  polling stops or polling requests are cleared immediately from loginRequired(), as
    //  otherwise if the application hits session timeout with the user not around, multiple
    //  hours worth of polling requests might queue up before the user comes back.
    handleLoginRequired : function (transactionNum) {
        // in the default flow at the bottom of this method, we open a new browser window to
        // the login page - that'll call handleLoginRequired(), so ignore that call so we don't
        // loop
        if (this._iscReloginWindow && this._iscReloginWindow == transactionNum) return;

        var transaction = this.getTransaction(transactionNum);
    
        // bogus call - default login.html with a new window - e.g. password-protected
        // DevConsole
        if (transaction == null) return;

        

        transactionNum = transaction.transactionNum;

        // clear the timeout on the transaction to let the user deal with reauth without getting
        // a timeout - this is universally useful, so we do it by default.  If the user wants
        // to cancel the transaction due to the auth delay, he's still free do so in a custom
        // rpc.loginRequired() implementation
        this.clearTransactionTimeout(transaction);
    
        var rpcRequest = transaction.operations[0],
            rpcResponse = this.createRPCResponse(transaction, rpcRequest);

        this.logInfo("loginRequired for transaction: " + transactionNum +
                     (transaction.containsCredentials ? 
                      ", transaction containsCredentials" : ""));

        if (transaction.containsCredentials) {
            // the user used an RPC to attempt a login, but auth failed for some reason - don't
            // if a callback was set on the request, then the user is expected to be able to
            // handle the AUTH_REQUIRED state - otherwise we'll just call loginRequired()
            // again.
            if (rpcRequest.callback) {
                rpcResponse.status = isc.RPCResponse.STATUS_LOGIN_INCORRECT;
                this.fireReplyCallbacks(rpcRequest, rpcResponse);
    
                this.clearTransaction(transaction);
                return;
            }
            this.clearTransaction(transaction);
        }

        this.suspendTransaction(transaction);

        // A non-auth RPC was trapped by auth required. 
        if (this.loginRequired) {
            // user has specified a custom loginRequired function , call through
            rpcResponse.status = isc.RPCResponse.STATUS_LOGIN_REQUIRED;
            this.loginRequired(transactionNum, rpcRequest, rpcResponse);
            return;
        }

        // default implementation - just open a new window to the login page.  This is
        // guaranteed to work, but isn't the best solution since the user can just close the
        // login window and then be forced to reload the app
    
        // don't allow page to be cached
        var URL = this.addParamsToURL(this.credentialsURL, {ts:new Date().getTime()});
        this._iscReloginWindow = window.open(URL, this.loginWindowSettings);
    },

//> @classMethod RPCManager.loginRequired()
// Called when a session timeout is encountered while trying to do a background RPC.  See
// +link{group:relogin,Relogin}.
// <P>
// The transaction with the passed <code>transactionId</code> is suspended, and should either
// be +link{RPCManager.clearTransaction,cleared} or +link{RPCManager.resendTransaction,resent}
// after the user has been re-authenticated.  
// <P>
// The <code>rpcRequest</code> parameter can be used to determine whether the suspended
// transaction can simply be dropped (eg, it's periodic polling request).
// <P>
// The <code>rpcResponse</code> parameter has rpcResponse.data set to the raw text of the
// response that triggered <code>loginRequired()</code>.  Some very advanced relogin strategies
// may need to inspect the raw response to get information needed for re-authentication.
//
// @param transactionNum (id) id of the transaction
// @param rpcRequest (RPCRequest) first RPCRequest of the transaction
// @param rpcResponse (RPCResponse) RPCResponse containing the session timeout response that
//                                  caused loginRequired() to be invoked
// @group relogin
// @visibility external
//<

    // called by AuthenticationFilter when relogin succeeds (by way of normal
    // performOperationReply() and transaction.containsCredentials detection and by canned "dumb http
    // server" code snippet in reloginSuccess.html
    handleLoginSuccess : function (transactionNum) {
        var transaction = this.getTransaction(transactionNum);
        // transaction may be null if the user popped a visible iframe that targets
        // loginSuccess and is using that as the UI for the user instead of e.g. a SmartClient
        // form that makes login RPCs
        if (transaction && transaction.containsCredentials) {
            this.clearTransactionTimeout(transaction);
            var rpcRequest = transaction.operations[0];
            if (rpcRequest.callback) {
                var rpcResponse = this.createRPCResponse(transaction, rpcRequest, {
                    status: isc.RPCResponse.STATUS_SUCCESS
                });
                this.fireReplyCallbacks(rpcRequest, rpcResponse);
                this.clearTransaction(transaction);
                return;
            }
            this.clearTransaction(transaction);
        }

        if (this._iscReloginWindow) this._iscReloginWindow.close();
        if (this.loginSuccess && this.loginSuccess() === false) return;

        // default handling
        this.resendTransaction();

    },

    // called by AuthenticationFilter or by canned "dumb http server" code snippet in
    // maxLoginAttemptsExceeded.html when too many login attempts have been made
    handleMaxLoginAttemptsExceeded : function (transactionNum) {
        var transaction = this.getTransaction(transactionNum);
        // transaction may be null if the user popped a visible iframe that targets
        // loginSuccess and is using that as the UI for the user instead of e.g. a SmartClient
        // form that makes login RPCs
        if (transaction && transaction.containsCredentials) {
            this.clearTransactionTimeout(transaction);
            var rpcRequest = transaction.operations[0];
            if (rpcRequest.callback) {
                var rpcResponse = this.createRPCResponse(transaction, rpcRequest, {
                    status: isc.RPCResponse.STATUS_MAX_LOGIN_ATTEMPTS_EXCEEDED
                });
                this.fireReplyCallbacks(rpcRequest, rpcResponse);
                this.clearTransaction(transaction);
                return;
            }
            this.clearTransaction(transaction);
        }
    
        // default handling
        if (this._iscReloginWindow) this._iscReloginWindow.close();

        if (this.maxLoginAttemptsExceeded) this.maxLoginAttemptsExceeded();
        else {
            var message = "Max login attempts exceeded.";
            if (isc.warn) isc.warn(message);
            else alert(message);
        }
    }
});
// patch RPCManager logging to truncate anything abot maxLogMessageLength with a warning and
// allow a second category to enable full logs.  We do this to prevent accidentall logging of
// large responses such as roundripping a WSDL file or toJS.
isc.RPCManager.rpc_logMessage = isc.RPCManager.logMessage;
isc.RPCManager.logMessage = function (priority, message, category, timestamp) {
    if (this.logIsEnabledFor(priority, category)) {
        if (isc.isA.String(message) && message.length > this.maxLogMessageLength
            && !this.logIsEnabledFor(priority, "RPCManagerResponse")) 
        {
            var delta = message.length - this.maxLogMessageLength;
            message = message.substring(0, this.maxLogMessageLength)
                +"\n...("+delta+" bytes truncated).  Enable RPCManagerResponse log at same threshold to see full message."
        }
    }
    this.rpc_logMessage(priority, message, category, timestamp);
};

//>	@class	InstantDataApp
// An InstantDataApp provides the ability to send data to an ISC server and retrieve results, and
// also to determine what users are authorized to perform what operations.
// <br><br>
// All server contact in the ISC system goes through InstantDataApp.  In higher-level APIs, such as
// the component databinding methods, the InstantDataApp is not directly visible because of the
// concept of the "default application", however, all such methods boil down to the
// <code>performOperation()</code> call, which allows arbitrary data to be sent and retrieved.
// <br><br>
// An InstantDataApp is created by loading an ISC Application File (.app.xml), which is read by both
// the ISC server and ISC client system.  The Application File allows you to specify the server-side
// Class which should handle operations submitted by the client, so that you can write custom
// operations. 
// 
// @see classMethod:InstantDataApp.getDefaultApplication()
// @group operations
// @treeLocation Client Reference/Data Binding
// @visibility ida
//<
isc.addGlobal("InstantDataApp", isc.RPCManager);
isc.isA.InstantDataApp = isc.isA.RPCManager; // make isA.InstantDataApp(app) work

isc.InstantDataApp.addClassMethods({

	// Operations
	// ----------------------------------------------------------------------------------------

    // legacy compatibility for performOperation(): ensures a client-side operation definition
    // exists for the operation name, because performOperation() needs one to exist, since for
    // DataSource operations the parameters to performOperation are insufficient to give
    // dataSource name and operationType
    addDefaultOperation : function (context, dataSource, operationType) {
		if (!context) context = {};
        
        context.operation = isc.DataSource.makeDefaultOperation(dataSource, operationType,
                                                                context.operation);

		return context;
    },

    
	// Default Application handling
	// --------------------------------------------------------------------------------------------
	setDefaultApplication : function (defaultApplication) {
		isc.InstantDataApp.defaultApplication = defaultApplication;

        
	},
 
    //> @classMethod RPCManager.getDefaultApplication()
    // Get the default application.
    // <br><br>
    // The default application is the first RPCManager created in a given page, or if no
    // RPCManagers are created, an automatically generated RPCManager with the ID
    // "builtinApplication".
    // <br><br>
    // The default application will be used any time an operation needs to be performed and no
    // application has been explicitly specified.  For example, a databound ListGrid is asked to
    // fetchData() and no application is passed.
    // <br><br>
    // The special automatically-generated "builtinApplication" is for rapid prototyping; it allows
    // you to perform the built-in operations against any DataSource, so that you can prototype a
    // complete client-server application without writing any server code and without writing an ISC
    // Application File (.app.xml file).
    // 
    // @return (RPCManager) the default application
    // @visibility internal
    //<
	getDefaultApplication : function () {
        // If the default application has never been created or has been destroyed we need to
        // create a new one.
		if (this.defaultApplication == null) {
            // create a barebones default application, which will automatically register itself
            // as the default application
            this.create({
                ID:"builtinApplication",
				dataSources:[],
                operations:{},
                // Ensure that should the default app get destroy()d, our pointer to it gets
                // cleared
                pointersToThis:[{object:this, property:"defaultApplication"}]
			});
		}
		return this.defaultApplication;
	},
    app : function () { return this.getDefaultApplication(); }
});

isc.InstantDataApp.addMethods({

	init : function () {
		// Create a global ID for this application so we can refer to it in the global scope.
		// If the app already has an ID property, this will be used as its global ID.
		if (this.ID != "builtinApplication") isc.ClassFactory.addGlobalID(this);

        // if there's no current default application, or the auto-generated
        // "builtinApplication" has been set as the default application, replace it
		if (isc.rpc.defaultApplication == null || 
            isc.rpc.defaultApplication.getID() == "builtinApplication") 
        {
			isc.rpc.setDefaultApplication(this);
		}
	}

});

//> @groupDef operations
// SmartClient Operations are dynamic, transparent communications made from the client-side
// SmartClient system running in the browser, to the server-side SmartClient system running in
// a servlet engine, or to other non-SmartClient servers available via HTTP. Operations are
// used to load new data or new behavior into a running SmartClient application. Operations are
// also used to save data entered by users, and in general, to get the result of any process
// which must be run on the server for security reasons.
// <br><br>
//
// <b>RPC Operations</b>
// <br><br>
// RPC Operations are low-level communications that send and retrieve arbitrary data.  RPC
// Operations are supported by the +link{class:RPCManager} class, which when used with the
// SmartClient server, provides Java to JavaScript +link{rpcRequest.data,2-way translation} of
// basic data structures.  The RPCManager also provides a mechanism for client-side code to be
// invoked when an operation completes (called a "callback").  RPC Operations are intended for
// unstructured data; data that is ultimately destined for display in SmartClient components
// will generally come from DataSource operations.
// <br><br>
//
// <b>DataSource Operations and DataBound Components</b>
// <br><br>
// A +link{group:dataSourceOperations,DataSource Operation} is an operation that acts on a
// DataSource, performing one of the basic actions that makes sense on a set of similar
// records: "fetch", "add", "update" or "remove".  Unlike RPC operations, DataSource operations
// have specific request data and response data, for example, in the "fetch" DataSource
// operation, the request data is expected to be search criteria, and the response data is
// expected to be a list of matching DataSource records.  Although DataSource operations can be
// invoked manually from the client, they are generally automatically invoked by DataBound
// components.
// <br><br>
// DataBound Components are components that understand DataSources.  Databound components
// configured with a DataSource are able to offer complete user interactions without further
// configuration (extensive customization is also supported).
// <br><br>
// For example, given a DataSource, the ListGrid component supports a sophisticated inline
// editing interaction, complete with automatically chosen editors like date pickers for dates,
// type-aware validation, saving, and error reporting. 
// <br><br>
// A DataBound component supporting an interaction such as inline editing will automatically
// submit DataSource operations to the server at appropriate times.
// <br><br>
//
// <b>DataSource Operation Integration</b>
// <br><br>
// Integrating DataSource operations with an existing system is best approached by implementing
// the the 4 basic DataSource operations in terms of your existing object model or data store.
// With these 4 operations implemented, the entire range of user interactions supported by
// SmartClient +link{dataBoundComponent,databinding-capable components} becomes applicable to
// your server.  At that point authentication, authorization and other business rules can be
// layered on top.
// <br><br>
//
// <b>Built-in SQL Connectivity</b>
// <br><br>
// The SmartClient server comes with built-in SQL connectivity, so that SQL-based DataSources
// can be created and used without any server-side code needing to be written.  In contrast,
// any operation which uses custom server-side code is called a "Custom Operation".
// <br><br>
// Generally it makes sense to prototype an application using Built-in DataSource Operations,
// then on the backend, create Custom DataSource Operations to retrieve data from the data
// store you will use in production.  As you switch from using Built-in DataSources to Custom
// Operations, no client-side code changes will be required, because the client cares only
// about the DataSource definition, not the data store which the data is ultimately retrieved
// from.
// <br><br>
//
// <b>Data Managers: ResultSet and ResultTree</b>
// <br><br>
// Data Managers manage datasets retrieved from DataSources.  Data Managers are automatically
// created by DataBound components, but can be created directly when more control is needed.
// <br><br>
// Data Managers provide load-on-demand for datasets too large to be loaded on the client,
// automatically invoking DataSource operations as necessary to retrieve data as it is
// requested, and optionally fetching ahead to anticipate further requests.   Data Managers
// will automatically perform actions locally when it is possible, for example, a sort
// action can be performed locally with a complete cache.  Data Managers also automatically
// manage the consistency of the client-side cache, observing update operations performed
// against DataSources and integrating updated rows automatically.
// <br><br>
// 
//
// @see class:RPCManager for RPC Operations
// @see interface:DataBoundComponent for information on DataBound Components
// @see group:dataSourceOperations for more information on DataSource Operations
// @see group:clientServerIntegration for information on integrating DataSource Operations with existing servers
// @see method:DataSource.fetchData() for manually invoked DataSource operations
// @see class:ResultSet for managing lists of records
// @see class:ResultTree for managing trees of records
// 
// @title Operations Overview
// @treeLocation Client Reference/Data Binding
// @visibility external
//<

//> @groupDef dataSourceOperations
// A DataSource Operation is a type of +link{group:operations,operation} that acts on the set
// of stored objects represented by a +link{DataSource}, performing one of the basic actions
// that makes sense on a set of similar records: "fetch", "add", "update" or "remove".  
// <P>
// Each DataSource operation has specific request and response data, for example, in the
// "fetch" DataSource operation, the request data is expected to be search criteria, and the
// response data is expected to be a list of matching DataSource records.  Listed below are the
// request data and response data for each DataSource operation type, and what they mean.  
// <P>
// DataSource records are represented on the client by a JavaScript Object,
// where each property in the Object maps a DataSource field name to the field value - hence
// the DataSource operations below are in essence a way of exchanging records from client to
// server and back.
// <P>
// If you are using +link{group:serverDataIntegration,server-side data integration} with the
// SmartClient Java server, see the +docTreeLink{javaServerReference,Java Server Reference} for
// information about how DataSource Requests arrive on the server (specifically
// com.isomophic.datasource.DSRequest) and how to provide responses 
// (specifically com.isomorphic.datasource.DSResponse.setData()).
// <P>
// If you are using +link{group:clientDataIntegration,client-side data integration} to directly
// consume services that use XML, JSON or other formats, see the "Editing and Saving" section
// of the +link{group:clientDataIntegration,client-side data integration} topic.
// <P>
//
// <b>fetch</b>
// <ul>
// <li>Request data: filter criteria, as an Object
// <li>Response data: matching records, as an Array of Objects
// </ul>
//
// <b>add</b>
// <ul>
// <li>Request data: new record, as an Object
// <li>Response data: new record as stored, as an Object
// </ul>
//
// <b>update</b>
// <ul>
// <li>Request data: primary keys of record to update, and new values (or just complete updated
// record), as an Object
// <li>Response data: new record as stored, as an Object
// </ul>
//
// <b>remove</b>
// <ul>
// <li>Request data: primary keys of record to delete, as an Object
// <li>Response data: minimally the primary keys of deleted record (can be complete record), as
// an Object
// </ul>
//
// @title DataSource Operations
// @treeLocation Client Reference/Data Binding
// @visibility external
//<

//> @groupDef clientServerIntegration
//
// Like client-server desktop applications, SmartClient browser-based applications interact
// with remote data and services via background communication channels. Background requests
// retrieve chunks of data rather than new HTML pages, and update your visual components in
// place rather than rebuilding the entire user interface.
// <P>
// SmartClient supports two general classes of client-server operations:
// +link{DSRequest,DSRequests} (DataSource Requests) and +link{RPCRequest}s (Remote Procedure
// Call Requests).  DataSource requests are for manipulating structured data described by
// +link{DataSource,DataSources}.  RPCRequests are a low-level, very flexible mechanism for
// custom client-server communications.  In an nutshell, RPCRequests:
// <ul>
// <li> may contain arbitrary data
// <li> are always initiated by custom code (a call to +link{RPCManager.send()}), and have
// their responses handled by custom code (the callback passed to <code>send()</code>)
// </ul>
// <P>
// DSRequests:
// <ul>
// <li> contain data that follows the +link{group:dataSourceOperations,DataSource protocol},
// which reflect the 4 basic operations on stored records: fetch, update, create, remove.
// <li> are initiated by +link{DataBoundComponent,DataBoundComponents} in response to user
// actions, and have their responses automatically managed (for example, 
// +link{ResultSet,cache management} and 
// +link{DynamicForm.saveData(),validation error handling}).  DSRequests can also be
// initiated manually and have their responses handled with custom code.
// </ul>
// See the +link{RPCManager} documentation for further information on RPCRequests - the
// remainder of this document focuses on integrating DataSource operations with your server.
// <P>
// <b>DataSource Creation</b>
// <p>
// First you must create +link{class:DataSource,DataSources} that describe the objects from
// your object model that will be loaded or manipulated within your application.  All of ISC's
// most powerful functionality builds on the concept of a DataSource, and because of ISC's 
// databinding framework (see +link{DataBoundComponent}), it's as easy to create a
// DataSource that can configure an unlimited number of components as it is to configure a
// single component.
// <P>
// There are a number of options for creating DataSources; for early prototyping, creating a
// DataSource by hand in either JavaScript or XML is simplest (this is covered under 
// +link{group:dataSourceDeclaration,DataSource declaration}).  Later on, you can persue one of
// many +link{metadataImport,metadata import} strategies for automatically leveraging
// your existing metadata.
// <p>
// Once you have a DataSource, you can bind a +link{interface:DataBoundComponent} such as a 
// +link{class:ListGrid} to it, call one of the 
// +link{group:dataBoundComponentMethods,DataBound Component Methods} on it, such as
// +link{method:ListGrid.fetchData()}, the ListGrid will send a background HTTP request to the
// server asking for data.  You can set the log category "RPCManager" to DEBUG threshold to see
// the outbound request and the server's response.
// <P>
// In this case, the ListGrid is sending a DataSource operation request of type "fetch".  To
// fulfill it, you will need to provide a set of matching records in one of many possible
// formats.
// <P>
// At this point your code is just a handful of lines (this example shows a DataSource created
// in JavaScript):
// <pre>
//     DataSource.create({
//         ID:"employees",
//         fields:[ 
//             ... 
//         ]
//     });
//     ListGrid.create({
//         ID:"myGrid",
//         dataSource:"employees"
//     });
//     myGrid.fetchData();
// </pre>
// If you now bind a +link{class:DynamicForm} to your DataSource, you can use the 
// +link{method:DynamicForm.editSelectedData()} and +link{method:DynamicForm.saveData()}
// methods to cause the client to submit "update" operations.  For both "update" and "add"
// operations, the DSRequest object you receive will have inbound data that is expected to be
// committed to your data model.  
// <P>
// <b>Data Integration</b>
// <P>
// There are two main approaches to integrating DataSources with your server technology:
// <ul>
// <li> +link{group:serverDataIntegration,Server-side integration}: DataSource requests from
// the browser arrive as Java Objects on the server.  You deliver responses to the browser by
// returning Java Objects.
// <li> +link{group:clientDataIntegration,Client-side integration}: DataSource requests arrive
// as simple HTTP requests which your server code receives directly (in Java, you use the
// Servlet API or .jsps to handle the requests).  Responses are sent as XML or JSON which you
// directly generate.  
// </ul>
// Note that using WSDL-described web services is also considered a client-side integration
// approach, although in this case it is typical to use extensive third-party web service
// libraries such as +externalLink{http://ws.apache.org/axis/,Apache Axis} to provide Java
// bindings.
// <P>
// The possible approaches are summarized in the diagram below.  Paths 2, 3, and 4 are
// client-side integration approaches, and path 1 includes all server-side integration
// approaches.
// <P>
// <img src="${isc.DocViewer.instance.referenceRoot}skin/ds_bindings.png" width=763 height=475>
// <P>
// All of these integration options can be used in parallel within the same application.  For
// example, an application that typically talks to a Java backend may contact Yahoo's
// JSON-based search services to get related search results, or integrate with SalesForce
// applications via the AppForce WSDL-described web service.
// <P>
// If you cannot install the SmartClient Server or must integrate with a pre-existing web
// service, then you must pursue +link{group:clientDataIntegration,client-side integration}.
// Otherwise there are several factors to consider:
//
// <ul>
//
// <li> With an existing Java backend, the fastest integration approach is
// +link{group:serverDataIntegration,server-side integration} using 
// +link{class:DMI,Direct Method Invocation (DMI)}.  Given 
// a Java method that returns a Collection of POJOs, a short XML declaration will achieve
// data loading.</li>
//
// <li> If you are building an 
// +externalLink{http://www.google.com/search?q=SOA+architecture,SOA Architecture}, and some of
// the services that your SmartClient application needs to contact could be shared with other
// kinds of clients, consider the WSDL- or XML-based
// +link{group:clientDataIntegration,Client-Side Integration}.</li>
//
// <li> The SmartClient server accelerates Java integration and provides various useful
// facilities, including the broadest possible browser support, server-push, and network
// performance enhancements.  See the +link{group:iscServer,SmartClient Server Summary} for
// details.</li>
//
// </ul>
// 
// @title Client-Server Integration
// @treeLocation Concepts
// @visibility external
//<

//> @groupDef serverDataIntegration
// Server Data Integration means:
// <ul>
// <li> You +link{iscInstall,install} the +link{group:iscServer,SmartClient Java
// Server} into any J2SE/J2EE environment
// <li> You +link{group:dataSourceDeclaration,create DataSources} in either XML or JavaScript,
// possibly on-the-fly from +link{group:metadataImport,existing metadata}.  
// <li> When you bind +link{dataBoundComponent,databinding-capable UI components} to these
// DataSources, the +link{DSRequest,DataSource requests} issued by these components will be
// transmitted to the server using a proprietary HTTP-based protocol, and the DataSource
// responses likewise sent back via a proprietary protocol
// <li> You will use SmartClient server APIs to receive the request data as Java Objects, and
// you will provide response data as Java Objects
// </ul>
// This approach is in contrast to 
// +link{group:clientDataIntegration,Client-side Data Integration}, which does not require the
// SmartClient server, and in which client-side DataSources are configured to directly send and
// receive HTTP messages containing XML, JSON or other content.
// <P>
// <B>Handling DataSource Requests</B>
// <P>
// Client-side +link{DataBoundComponent,DataBoundComponents} will send
// +link{DSRequest,DSRequests} to the ISC server as background communications transparent to
// the user.  Integrating SmartClient's DataSource layer with your data model is a matter of
// handling these DSRequests and sending back DSResponses, in order to fulfill the 4 basic
// operations of the +link{group:dataSourceOperations,DataSource Protocol}.
// <P>
// There are two approaches for routing inbound dsRequests to your business logic:
// <dl>
// <dt>RPCManager dispatch</dt>
// <dd>inbound requests are handled by a single dispatcher implemented as a Java servlet or
// .jsp.  The +link{RPCManager} is used to retrieve requests and provide responses</dd>
// <dt>+link{DMI,Direct Method Invocation}</dt>
// <dd>XML declarations route requests to existing business logic methods.  Inbound request
// data is adapted to method parameters, and method return values are delivered as
// responses</dd>
// </dl>
// <P>
// Which approach you use is largely a matter of preference.  Direct Method Invocation (DMI)
// may allow simple integration without writing any SmartClient-specific server code.
// RPCManager dispatch integration provides an earlier point of control, allowing logic that
// applies across different DataSource operations to be shared more easily.
// <P>
// Whether using RPCManager dispatch or DMI request routing, you must return data which, 
// translated to JavaScript via the rules described in com.isomorphic.js.JSTranslater.toJS(),
// matches the +link{group:dataSourceOperations,response data required for the operationType}.
// <P>
// For example, for a "fetch" request, your return data should translate to an Array of
// JavaScript objects.  Your backend may be capable of returning data in a number of ways - you
// should compare each format you can readily retrieve against the capabilities of the
// JSTranslater.  Common options are to pass an XML document fragment or a Collection of Java
// Beans/POJOs directly to DSResponse.setData().
// <p>
// For "update" and "add" DataSource requests, the inbound data is intended to be permanently
// stored.  If you are using a DataSource specified in XML format, you can run the validators
// you declared in the DataSource by calling the DSRequest.validate() method.  Assuming the
// declared validation is passed, you can run custom validation logic, if any, and finally
// create or update objects in your object model.  If you are using Beans/POJOs, the method
// DataSource.applyProperties(map, bean) is an easy way to apply the validated values to an
// Object tree or XML structure.
// <P>
// For more information on the DMI subsystem, see the +link{DMI} class and the 
// +externalLink{/examples/server_integration/#customDataSourceIntegrationDMI,DMI example} in
// the SDK.
// <P>
// Note that, as you continue to integrate your prototype with your backend, you can use a
// mixture of DataSources that have been fully integrated with your backend and DataSources
// that are either running in "client-only" mode (see +link{group:clientOnlyDataSources}) or
// that use ISC's built-in SQL connectivity (see +link{group:sqlDataSource}).
// <P>
// <b>RPCManager dispatch</b>
// <P>
// The basic flow of logic for handling DataSource requests using RPCManager dispatch is:
// <P>
// <table class="normal" border=1>
// <tr>
// <td>1. Get current list of requests from the client.</td>
// <td>rpcManager.getRequests()</td>
// </tr>
//
// <tr>
// <td>2. Determine operation type (Fetch, Add, Update, Remove) for a single request.</td>
// <td>dsRequest.getOperationType()</td>
// </tr>
//
// <tr>
// <td>3. Get inbound values (Add, Update) and/or criteria (Fetch, Update, Remove) for this
// request.</td>
// <td>dsRequest.getFieldValue()<br>
// dsRequest.getValues()<br> 
// dsRequest.getCriteria()</td>
// </tr>
//
// <tr>
// <td>4. Business logic, validation, calls to data and service tiers... anything you can code.
// </td>
// <td><b>execute custom logic</b></td>
// </tr>
//
// <tr>
// <td>5. Set status and data for the response.</td>
// <td>dsResponse.setStatus()<br>
// dsResponse.setData()</td>
// </tr>
//
// <tr>
// <td>6. Send response to the client.</td>
// <td>rpcManager.send()</td>
// </tr>
// </table>
// <P>
// For more information, see the +link{RPCManager,RPCManager documentation}, and the 
// +externalLink{/examples/server_integration/#customDataSourceIntegration,RPCManager example}. 
//
// @title Server DataSource Integration
// @treeLocation Concepts/Client-Server Integration
// @treeLocation Java Server Reference
// @visibility external
//<

//> @groupDef metadataImport
// In SmartClient, metadata is expressed through +link{DataSource,DataSources}, which in turn
// drive +link{DataBoundComponent,DataBoundComponents}.  If you have existing metadata, there
// are several possible approaches to transforming it to SmartClient DataSources, either one
// time or on the fly.
// <P>
// There are two possible targets for metadata import: XML format or JavaScript format.
// The XML format is more general purpose, since the ISC server can transform it to JavaScript
// via the +link{group:loadDSTag,loadDS tag}, and DataSources in XML format can be used by the
// ISC server for server-side validation (this split is covered in more detail under
// +link{dataSourceDeclaration,Data Source Declaration}).
// <P>
// You may also transform your metadata dynamically (while the application is running in
// production) or staticly (one time ever or at packaging time).  Generally for a static
// or dynamic transform targetting JavaScript format you will want to produce one .js file
// containing all your DataSource definitions, to be loaded by your application via a normal
// &lt;SCRIPT SRC&gt; tag.  For a static transform targetting XML format, you will want to
// produce a series of .ds.xml files and place them in the directories expected by the ISC
// server (see +link{group:dataSourceDeclaration,DataSource Declaration}).  Staticly generated
// XML DataSources can be delivered to the browser as a single .js file via a .jsp containing
// several +link{loadDSTag,<code>loadDS</code> tags}.
// <P>
// If you want to do dynamic transform targetting XML format and use ISC server-side
// validation, the server-side API DataSource.fromXML() can be used to create a DataSource
// dynamically from XML, so that you can then call DataSource.validate().  Either the XML
// DataSource definition or the live DataSource itself can be passed to the server-side API
// XML.toJS() to produce JavaScript.
// <P>
// How to actually produce JavaScript or XML DataSource definitions from your existing metadata
// depends on the format of your metadata.
// <P>
// <b>XML Schema</b>
// <P>
// The method +link{XMLTools.loadXMLSchema()} and the 
// +link{group:loadXMLSchemaTag,loadXMLSchema JSP tag} provide dynamic transform of XML Schema
// to JavaScript.  This is essentially accomplished by running
// <code>isomorphic/system/schema/schemaTranslator.xsl</code> on the XML schema file to produce
// XML DataSource definitions, and then translating those to JavaScript.  You can run the
// <code>schemaTranslator</code> stylesheet using any standard XSLT processor and capture the
// XML output.
// <P>
// <b>Java Beans</b>
// <P>
// Metadata available via Java's "reflection" APIs allows a basic DataSource to be generated
// from Java beans.  Sample Java code can be found in
// <code>examples/server_integraton/DataSourceGenerator.java</code>.
// <P>
// <b>Other XML formats</b>
// <P>
// If you are familiar with XSLT or other XML transform languages, you
// could use it to do an XML to XML transform, and then use XML.toJS() to get to JavaScript.
// <P>
// <b>Schema represented as Java Objects</b>
// <P>
// If you are targetting XML, hand-coded generation of DataSource XML is straightforward, and
// from XML you can use XML.toJS() to get to JavaScript.
// 
// 
// @title Metadata Import
// @treeLocation Client Reference/Data Binding
// @visibility external
//<


    // Comm and Transactions
	// ----------------------------------------------------------------------------------------
 
	// ---------------------------------------------------------------------------------------
    //> @object OperationContext
    // OperationContext is the bundle of settings that can be passed to performOperation() as
    // the "context" argument, or to any method that ultimately performs an operation and
    // supports a context argument.
    // <P>
    // There is no need to instatiate an OperationContext instance.  Just pass a normal
    // JavaScript object with the desired properties.
    //
    // @treeLocation Client Reference/Data Binding/RPCManager
    // @visibility ida
    //<

    //> @attr operationContext.showPrompt (boolean : true : IR)
    //  Whether to show a prompt in a modal dialog while this operation is being performed, in
    //  order to prevent user interaction. 
    // @visibility ida
    //<

    //> @attr operationContext.prompt (string: "Contacting server..." : IR)
    //  Text to show in the operation prompt if one is shown.
    // @see showPrompt
    // @visibility ida
    //<

    //> @attr operationContext.afterFlowCallback (callback : null : IR)
    //  An additional callback that will be invoked after the callback passed as an argument to
    //  performOperation.
    // @visibility ida
    //<

    //> @attr operationContext.willHandleError (boolean : false : IR)
    // Set this flag to indicate you are willing to handle error results from the server.  If
    // this flag is not set, standard RPCManager/DataSource error handling will be invoked.
    // <p>
    // The most common use of this flag is to directly handle validation errors.
    // <p>
    // Note that if you see context.willHandleError, the OperationResult object passed to your
    // IDACallback may be missing properties or be otherwise malformed, depending on
    // the severity of the server error.
    // <p>
    //
    // @see class:OperationResult
    // @see RPCManager.handleError()
    // @see dataSource.handleError()
    // @visibility ida
    //<

    //> @attr operationContext.operation (OperationID : null : IR)
    // Only applicable when calling Action Methods, specifies the operation ID to use instead
    // of the default DataSource operation.
    //
    // @group dataBoundComponentMethods
    // @see group:dataBoundComponentMethods
    //<

    




	// ---------------------------------------------------------------------------------------
    //> @type IDACallback
    // A function to call or expression to evaluate when an operation completes.
    // <p>
    // An IDACallback can be:
    // <ul>
    // <li>a string expression
    // <li>an object with the properties "caller" and "methodName", indicating an object to be
    // called and the method to call on it
    // </ul>
    // Regardless of the form of the callback, the callback method will be invoked with the
    // arguments (operationResult, results, data, context) with the meaning:
    // <ul>
    // <li>operationResult: an OperationResult object containing all the data returned by the
    // server for this operation
    // <li>data: just the "result.data" property from the OperationResult, for convenience
    // <li>context: just the "context" property from the OperationResult, for convenience
    // </ul>
    // @see class:OperationResult
    // @treeLocation Client Reference/Data Binding/RPCManager
    // @visibility ida
    //<
    // NOTE: intentionally omitted mention of passing an IDACallback that is the name of a
    // function on the IDA instance.


//> @groupDef smartArchitecture
// SmartClient can add interactivity and performance benefits to any web application with a
// variety of integration approaches.  This topic discusses the optimal architecture for a
// SmartClient application, which can be adopted in whole or in part.
// <p>
// In a typical HTML-based web application, every time a new view is shown to a user, a round
// trip to the server is required to retrieve new presentation information, such as a search
// screen.  However in an ISC-based application, showing a new view can be accomplished by
// simply hiding some components and showing others.
// <p>
// Because ISC components are expressed in a concise declarative form, and because ISC
// components have essentially no runtime performance impact until used, dozens of application
// views can be downloaded to the browser using the same bandwidth that would have been
// required to render just the initial view in plain HTML.  
// <p> 
// This architectural pattern of "preloading views" has tremendous benefits.  View transitions
// which do not require new data from the server can be performed near-instantaneously and
// without server involvement, boosting both interactivity and scalability.
// <p>
// Showing a dialog containing a "wizard" is a straightforward example of showing a "preloaded
// view".  For example:
// <pre>
//    function showNewUserWizard() {
//        Window.create({
//            items:[
//                DynamicForm.create({ ... })
//            ]
//        });
//    }
//    Button.create({
//        title:"New User..",
//        click:"showNewUserWizard()"
//    });
// </pre>
// In this example, none of the components involved in a potentially multi-pane wizard are 
// created until they are needed.  Showing the wizard has near-instantaneous response and
// causes no server load.
// <p>
// However, let's say that the first pane of the wizard is going to incorporate some dynamic
// user-specific data, such as the current user's name.  To load the username, we'll use an RPC
// operation targetting a .jsp called "getUserName.jsp" and show the wizard when it completes
// (see +link{class:RPCManager} for information on RPCs and how to construct a .jsp that can
// send an RPC response).
// <pre>
//    function showNewUserWizard() {
//        RPCManager.sendRequest({
//            actionURL:"getUserName.jsp",
//            callback:"doShow(rpcResponse)"
//        });
//    }
//    function doShow(rpcResponse) {
//        Window.create({
//            items:[
//                Canvas.create({contents:"Hello, " + rpcResponse.userName}),
//                DynamicForm.create({ ... })
//            ]
//        });
//    }
//    Button.create({
//        title:"New User..",
//        click:"showNewUserWizard()"
//    });
// </pre>
// In this example, we've simply incorporated a user name into the first pane of a wizard.
// However, this pattern allows us to arbitrarily change user interactions based on data from
// the server.  For example, the RPCResponse might have contained a flag indicating that the
// wizard should skip the first two steps, or an arbitrary warning message for the user, or
// even JavaScript code to be evaluated on the client.
// <P>
// This architecture has several key advantages:
// <dl>
//
// <dt><b>Performance: Cacheable UI</b></dt>
// <dd>
// A dynamic, data-driven UI can be expressed completely in <i>cacheable</i> JavaScript.
// This is in contrast to any architecture based on server-side HTML generation, where static
// parts of the presentation are mixed in with dynamic data, preventing cacheability so that
// bandwidth and server time are wasted repeatedly delivering the same static presentation
// data.
// <br>
// Even generated JavaScript is cacheable.  For example, a SmartClient View expressed in XML
// and contained within a JSP is still a separately cacheable resource when loaded via a
// &lt;SCRIPT SRC&gt; tag and advertised as a cacheable resource via HTTP headers, because it
// is ultimately delivered to the browser as simple JavaScript.  Hence standard 
// +link{group:i18n,internationalization} techniques such as using JSTL tags in a JSP remain
// applicable.
// <br>
// The SmartClient Architecture even allows you to capture all the gradations of cacheability
// from completely static (changes once per application rollout) to completely dynamic
// (timestamp).  In the example above, the user name wouldn't actually change for the lifetime
// of the page, so could be loaded once only.
// <br>&nbsp;</dd>
//
// <dt><b>Performance: Minimal Server State</b></dt>
// <dd>
// Any architecture that relies on component descriptions being generated by the server
// must track a great deal of state, which, in the SmartClient Architecture, is either
// completely eliminated or greatly reduced.
// <br>&nbsp;</dd>
//
// <dt><b>True Presentation / Business Logic separation</b></dt>
// <dd>
// The RPCResponse object represents the client's exact, minimal needs for server data.
// This is much easier to understand and to audit than a slew of .jsp files which access and
// update miscellaneous state.  It is also far easier to spot reusable patterns of data access,
// which in server-side HTML generation systems often end up as duplicated code.
// <br>&nbsp;</dd>
//
// <dt><b>Parallel Development and Testability</b></dt>
// <dd>
// Using the SmartClient architecture allows you to build a complete, working application
// that can run without a server, based on sample data.  In the example above, it would be 
// straightforward to create a testing mode that returned a faked RPC response consisting of
// simply <code>{ userName : "Bob" }</code>.
// <br>
// This allows better parallel development by enabling the client side of the system to be
// tested in isolation, and creates clearer communication between client and server-side
// developers since creation of test data tends to develop into data requirements
// specifications.
// <br>
// For more info on creating applications that support client-only testing, see
// +link{group:clientOnlyDataSources,Client Only DataSources}.
// <br>&nbsp;</dd>
// </dl>
// <br>
// <h3>Refinements</h3>
// <br>
// <b>Creating vs Showing a View</b>
// <br>
// Many views will be shown to the user repeatedly, for example, the user may repeatedly switch
// back and forth between two panes of a TabSet.  In that usage it makes sense to make a
// distinction between <i>creating</i> a view and <i>showing</i> an existing view.  When
// showing an existing view, the same components and/or data may be able to be reused.
// <br>
// In the following variant on the original example, we only create the Window object and
// do the RPC to retrieve the user name the first time <code>showNewUserWizard()</code> is
// called.  Subsequently we reuse the existing window, and we assume the user name has not
// changed, so we need not do the RPC again. (<i>Note: "New User" button omitted for brevity
// from here on</i>)
// <pre>
//    function showNewUserWizard() {
//        if (!window.myWindow) {
//            Window.create({
//                ID:"myWindow",
//                autoDraw:false,
//                items:[
//                    Canvas.create({ ID: "welcomeCanvas" }),
//                    DynamicForm.create({ ... })
//                ]
//            });
//            RPCManager.sendRequest({
//                actionURL:"getUserName.jsp",
//                callback:"doShow(rpcResponse)"
//            });
//        } else {
//            myWindow.show();
//        }
//    }
//    function doShow(rpcResponse) {
//        welcomeCanvas.setContents("Hello, " + rpcResponse.userName);
//        myWindow.show();
//    }
// </pre>
// 
// <b>Batching Operations</b>
// <br>
// A view may incorporate multiple components, each of which requires data.  In the following
// example, a DataBound ListGrid has been incorporated into the wizard, and we'd like to fetch
// the user's name and the beginning dataset for the grid in the same batch.  We use 
// +link{RPCManager.startQueue()} to do so.
// <pre>
//    function showNewUserWizard() {
//        if (!window.myWindow) {
//            Window.create({
//                ID:"myWindow",
//                autoDraw:false,
//                items:[
//                    Canvas.create({ ID: "welcomeCanvas" }),
//                    <b>ListGrid.create({ 
//                        ID: "myGrid",
//                        dataSource:"myDataSource"
//                    }),</b>
//                    DynamicForm.create({ ... })
//                ]
//            });
//            <b>RPCManager.startQueue();
//            myGrid.fetchData();</b>
//            RPCManager.sendRequest({
//                actionURL:"getUserName.jsp",
//                callback:"doShow(rpcResponse)"
//            });
//            <b>RPCManager.sendQueue();</b>
//        } else {
//            myWindow.show();
//        }
//    }
//    function doShow(rpcResponse) {
//        welcomeCanvas.setContents("Hello, " + rpcResponse.userName);
//        myWindow.show();
//    }
// </pre>
//
// <b>Segmenting very large Applications</b>
// <P>
// If an application has many hundreds of views, but only a handful of views are used by a
// given user in a typical session, for the fastest loading performance you should consider
// loading only the most commonly used views initially then loading further views on demand.
// <P>
// You can use +link{FileLoader.loadJSFiles()} to load a set of JavaScript files
// compromising an application module that defines a set of related views.  The loaded
// JavaScript files may define new component classes and new DataSources in addition to
// defining new views and their associated logic.
//
// @title SmartClient Architecture
// @treeLocation Concepts
// @visibility external
//<

