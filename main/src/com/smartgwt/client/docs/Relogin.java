
package com.smartgwt.client.docs;

/**
 * <h3>Relogin</h3>
 * When a user's session has expired and the user tries to navigate to a protected resource,&#010 typical authentication
 * systems will redirect the user to a login page.  With Ajax systems&#010 such as Smart GWT, this attempted redirect may
 * happen in response to background data&#010 operations such as a form trying to save.  In this case, the form perceives
 * the login page&#010 as a malformed response and displays a warning, and the login page is never displayed to the&#010
 * user.&#010 <P>&#010 The ideal handling of this scenario is that the form's attempt to save is "suspended" while the&#010
 * user re-authenticates, then is completed normally.  Smart GWT makes it easy to&#010 implement this ideal handling
 * <i>without</i> having to implement session timeout handling in&#010 every codepath that contacts the server, by
 * providing central notification of session timeout,&#010 and the ability to re-send a transaction that encountered
 * session timeout.&#010 <P>&#010 <h3>Detecting session timeout</h3>&#010 <P>&#010 To enable Smart GWT to detect that
 * session timeout has occurred, a special marker needs to&#010 be added to the HTTP response that is sent when a user's
 * session has timed out.  This is&#010 called the <code>loginRequiredMarker</code>.&#010 <P>&#010 If your authentication
 * system will redirect to a login page when a user's session is timed&#010 out, it's sufficient to simply embed the
 * <code>loginRequiredMarker</code> in the login page.  The&#010 <code>loginRequiredMarker</code> is valid HTML and will
 * have no effect on the behavior or&#010 appearance of the page.  The <code>loginRequiredMarker</code> is found in&#010
 * &#010 docs/loginRequiredMarker.html&#010 in your SDK.  Simply copy the contents of this file verbatim into your login
 * page anywhere&#010 inside the &lt;body&gt; tag; it does not need to be customized in any way for your application.&#010
 * <P>&#010 If it's a problem to modify the login page (even with a marker that has no effect on&#010 appearance or
 * behavior), see if you can configure your authentication system to return a&#010 special response specifically for
 * background requests for data.  By default, when using the&#010 Smart GWT Server Framework, all such requests go to the
 * {@link com.smartgwt.client.rpc.RPCManager#actionURL actionURL} and&#010 include an HTTP query parameter "isc_rpc=1";
 * various authentication systems can be&#010 configured to detect these requests and handle them separately.  One approach
 * is to simply&#010 copy loginRequiredMarker.html into your application in an area not protected by&#010 authentication
 * and redirect to it when a background data request with an expired session is&#010 detected.&#010 <P>&#010 <h3>Handling
 * session timeout</h3>&#010 <P>&#010 When Smart GWT detects the <code>loginRequiredMarker</code>, the transaction
 * that&#010 encountered session timeout is put on hold, and &#010 &#010 the RPCManager LoginRequired event is raised.&#010
 * At this point you have a few options:&#010 <ol>&#010 &#010 <li> Leave the Smart GWT application and take the user to the
 * login page, by simply doing a&#010 <code>window.location.replace(<i>myLoginURL</i>)</code>, the simplest but least user
 * friendly&#010 option.&#010 &#010 <li> Open a new browser window that goes to your plain HTML login form (or offer a link
 * that&#010 opens such a browser window), using a modal dialog in the application page that prompts the&#010 user to login
 * before continuing, then re-send the intercepted transaction&#010 ({@link
 * com.smartgwt.client.rpc.RPCManager#resendTransaction RPCManager.resendTransaction} when the user indicates he has logged
 * in.&#010 This is simple, does not drop context, but is not seamless.&#010 &#010 <li> Use a Smart GWT interface,
 * typically a DynamicForm in a Window, to collect credentials,&#010 perform login as a background RPC, and on success
 * re-send the intercepted transaction&#010 ({@link com.smartgwt.client.rpc.RPCManager#resendTransaction
 * RPCManager.resendTransaction}.  &#010 &#010 </ol>&#010 <B>Authentication via background RPC form POST</B>&#010 &#010
 * <span class="smartgwt">&#010 &#010 <P>&#010 To relogin against any system that can accept credentials as an HTTP
 * POST:&#010 <ol>&#010 <li> when the LoginRequired event is raised, show a login form in a modal dialog.  The&#010      
 * LoginWindow component is a simple version of this, or you can create your own&#010 <li> when the user enters
 * credentials, POST them using code like the following:&#010 <pre>&#010    RPCRequest request = new RPCRequest();&#010   
 * request.setContainsCredentials(true);&#010    request.setActionURL(credentialsURL);&#010   
 * request.setUseSimpleHttp(true);&#010    request.setShowPrompt(false);&#010    Map<String,String> params = new
 * HashMap<String,String>();&#010    // adjust parameter names to match your authentication system&#010   
 * params.put("j_username",<i>username</i>);&#010    params.put("j_password",<i>password</i>);&#010   
 * request.setParams(params);&#010    RPCManager.sendRequest(request,new RPCCallback(){&#010        public void
 * execute(RPCResponse response, Object rawData, RPCRequest request) {&#010            if (response.getStatus() ==
 * RPCResponse.STATUS_SUCCESS) {&#010                // get rid of login window&#010               
 * RPCManager.resendTransaction();&#010            } else if (response.getStatus() == RPCResponse.STATUS_LOGIN_INCORRECT)
 * {&#010                // show an error in the login window&#010            }&#010        }&#010    });&#010 </pre>&#010
 * <li> configure your authentication system to send back the loginSuccessMarker as part of a&#010 successful login
 * response, and the loginRequiredMarker as part of a failed login response&#010 </ol>&#010 If your authentication system
 * can accept POST'd credentials at any URL it protects, the last&#010 step may be as simple as configuring the
 * loginSuccessMarker file itself as a protected&#010 resource (isomorphic/login/loginSuccess.html).&#010 &#010
 * </span>&#010 <P>&#010 <B>Authentication via background Smart GWT server RPC/DMI</B>&#010 <P>&#010 If you are using the
 * Smart GWT Java server and your authentication system allows you to mark&#010 a user as authenticated from Java, you can
 * perform a normal RPC or DMI with the credentials&#010 gathered from the user and send back success or failure
 * indications as normal RPC or DMI&#010 responses.  This can be useful if, in addition to logging in, you want to send
 * back additional&#010 data.&#010 <P>&#010 <B>Advanced: concurrency</B>&#010 <P>&#010 If, after loginRequired() has fired
 * and before the user has re-authenticated, you send&#010 additional RPCs to protected URLs, you will get additional
 * loginRequired() notifications.  This&#010 may happen to applications that poll for data or periodically save without
 * user action.  You&#010 may wish to avoid this by setting an application-specific flag to avoid firing requests
 * during&#010 the relogin process.  However, you must ultimately either&#010 {@link
 * com.smartgwt.client.rpc.RPCManager#resendTransaction resend} or {@link
 * com.smartgwt.client.rpc.RPCManager#clearTransaction discard}&#010 every transaction for which loginRequired() fires, or
 * you will have a memory leak due to&#010 suspended transactions.&#010 <P>&#010 Note also that there is no requirement
 * that the relogin process blocks user interaction.&#010 Applications that access multiple services may choose to simply
 * show an unobtrusive error&#010 indication such that the user can log back in at his leisure, or even log the user back
 * in&#010 automatically.
 * @see com.smartgwt.client.rpc.RPCManager#credentialsURL
 * @see com.smartgwt.client.rpc.RPCManager#loginRequired
 * @see com.smartgwt.client.rpc.RPCRequest#getContainsCredentials
 */
public interface Relogin {
}
