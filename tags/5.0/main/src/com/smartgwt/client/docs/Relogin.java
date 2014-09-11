
package com.smartgwt.client.docs;

/**
 * <h3>Relogin</h3>
 * When a user's session has expired and the user tries to navigate to a protected resource,
 *  typical authentication systems will redirect the user to a login page.  With Ajax systems
 *  such as Smart GWT, this attempted redirect may happen in response to background data
 *  operations such as a form trying to save.  In this case, the form perceives the login page
 *  as a malformed response and displays a warning, and the login page is never displayed to the
 *  user.
 *  <P>
 *  The ideal handling of this scenario is that the form's attempt to save is "suspended" while the
 *  user re-authenticates, then is completed normally.  Smart GWT makes it easy to
 *  implement this ideal handling <i>without</i> having to implement session timeout handling in
 *  every codepath that contacts the server, by providing central notification of session timeout,
 *  and the ability to re-send a transaction that encountered session timeout.
 *  <P>
 *  <h3>Detecting session timeout</h3>
 *  <P>
 *  To enable Smart GWT to detect that session timeout has occurred, a special marker needs to
 *  be added to the HTTP response that is sent when a user's session has timed out.  This is
 *  called the <code>loginRequiredMarker</code>.
 *  <P>
 *  If your authentication system will redirect to a login page when a user's session is timed
 *  out, it's sufficient to simply embed the <code>loginRequiredMarker</code> in the login page.  The
 *  <code>loginRequiredMarker</code> is valid HTML and will have no effect on the behavior or
 *  appearance of the page.  The <code>loginRequiredMarker</code> is found in
 *  
 *  docs/loginRequiredMarker.html
 *  in your SDK.  Simply copy the contents of this file verbatim into your login page anywhere
 *  inside the &lt;body&gt; tag; it does not need to be customized in any way for your application.
 *  <P>
 *  If it's a problem to modify the login page (even with a marker that has no effect on
 *  appearance or behavior), see if you can configure your authentication system to return a
 *  special response specifically for background requests for data.  By default, when using the
 * Smart GWT Server Framework, all such requests go to the {@link com.smartgwt.client.rpc.RPCManager#actionURL actionURL}
 * and
 *  include an HTTP query parameter "isc_rpc=1"; various authentication systems can be
 *  configured to detect these requests and handle them separately.  One approach is to simply
 *  copy loginRequiredMarker.html into your application in an area not protected by
 *  authentication and redirect to it when a background data request with an expired session is
 *  detected.
 *  <P>
 *  <h3>Handling session timeout</h3>
 *  <P>
 *  When Smart GWT detects the <code>loginRequiredMarker</code>, the transaction that
 *  encountered session timeout is put on hold, and 
 *  
 *  the RPCManager LoginRequired event is raised.
 *  At this point you have a few options:
 *  <ol>
 *  
 *  <li> Leave the Smart GWT application and take the user to the login page, by simply doing a
 *  <code>window.location.replace(<i>myLoginURL</i>)</code>, the simplest but least user friendly
 *  option.
 *  
 *  <li> Open a new browser window that goes to your plain HTML login form (or offer a link that
 *  opens such a browser window), using a modal dialog in the application page that prompts the
 *  user to login before continuing, then re-send the intercepted transaction
 * ({@link com.smartgwt.client.rpc.RPCManager#resendTransaction RPCManager.resendTransaction} when the user indicates he
 * has logged in.
 *  This is simple, does not drop context, but is not seamless.
 *  
 *  <li> Use a Smart GWT interface, typically a DynamicForm in a Window, to collect credentials,
 *  perform login as a background RPC, and on success re-send the intercepted transaction
 *  ({@link com.smartgwt.client.rpc.RPCManager#resendTransaction RPCManager.resendTransaction}.  
 *  
 *  </ol>
 *  <B>Authentication via background RPC form POST</B>
 *  
 *  <span class="smartgwt">
 *  
 *  <P>
 *  To relogin against any system that can accept credentials as an HTTP POST:
 *  <ol>
 *  <li> when the LoginRequired event is raised, show a login form in a modal dialog.  The
 *        LoginWindow component is a simple version of this, or you can create your own
 *  <li> when the user enters credentials, POST them using code like the following:
 *  <pre>
 *     RPCRequest request = new RPCRequest();
 *     request.setContainsCredentials(true);
 *     request.setActionURL(credentialsURL);
 *     request.setUseSimpleHttp(true);
 *     request.setShowPrompt(false);
 *     Map<String,String> params = new HashMap<String,String>();
 *     // adjust parameter names to match your authentication system
 *     params.put("j_username",<i>username</i>);
 *     params.put("j_password",<i>password</i>);
 *     request.setParams(params);
 *     RPCManager.sendRequest(request,new RPCCallback(){
 *         public void execute(RPCResponse response, Object rawData, RPCRequest request) {
 *             if (response.getStatus() == RPCResponse.STATUS_SUCCESS) {
 *                 // get rid of login window
 *                 RPCManager.resendTransaction();
 *             } else if (response.getStatus() == RPCResponse.STATUS_LOGIN_INCORRECT) {
 *                 // show an error in the login window
 *             }
 *         }
 *     });
 *  </pre>
 *  <li> configure your authentication system to send back the loginSuccessMarker as part of a
 *  successful login response, and the loginRequiredMarker as part of a failed login response
 *  </ol>
 *  If your authentication system can accept POST'd credentials at any URL it protects, the last
 *  step may be as simple as configuring the loginSuccessMarker file itself as a protected
 *  resource (isomorphic/login/loginSuccess.html).
 *  
 *  </span>
 *  <P>
 *  <B>Authentication via background Smart GWT server RPC/DMI</B>
 *  <P>
 *  If you are using the Smart GWT Java server and your authentication system allows you to mark
 *  a user as authenticated from Java, you can perform a normal RPC or DMI with the credentials
 *  gathered from the user and send back success or failure indications as normal RPC or DMI
 *  responses.  This can be useful if, in addition to logging in, you want to send back additional
 *  data.
 *  <P>
 *  <B>Advanced: concurrency</B>
 *  <P>
 *  If, after loginRequired() has fired and before the user has re-authenticated, you send
 *  additional RPCs to protected URLs, you will get additional loginRequired() notifications.  This
 *  may happen to applications that poll for data or periodically save without user action.  You
 *  may wish to avoid this by setting an application-specific flag to avoid firing requests during
 *  the relogin process.  However, you must ultimately either
 * {@link com.smartgwt.client.rpc.RPCManager#resendTransaction resend} or {@link
 * com.smartgwt.client.rpc.RPCManager#clearTransaction discard}
 *  every transaction for which loginRequired() fires, or you will have a memory leak due to
 *  suspended transactions.
 *  <P>
 *  Note also that there is no requirement that the relogin process blocks user interaction.
 *  Applications that access multiple services may choose to simply show an unobtrusive error
 *  indication such that the user can log back in at his leisure, or even log the user back in
 *  automatically.
 * @see com.smartgwt.client.rpc.RPCManager#credentialsURL
 * @see com.smartgwt.client.rpc.RPCManager#loginRequired
 * @see com.smartgwt.client.rpc.RPCRequest#getContainsCredentials
 */
public interface Relogin {
}
