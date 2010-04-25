
package com.smartgwt.client.docs;

/**
 * <h3>Relogin</h3>
 * For applications that require authentication and use session timeout, a background RPC may occur with an expired
 * session.  The ideal handling of this scenario is that, with the attempted transaction still suspended, a modal dialog is
 * used to re-authenticate the user, and then the original transaction is resumed without loss of data or context.  Smart
 * GWT makes it easy to implement this ideal handling <i>without</i> having to implement session timeout handling in every
 * codepath that contacts the server, by providing central notification of session timeout, and the ability to re-send a
 * transaction that encountered session timeout. <P> When session timeout occurs, typical authentication systems intercept
 * requests to protected resources and return a page that tells the user that login is required.  With a background RPC
 * this page won't be shown to the user. <P> To enable Smart GWT to detect that session timeout has occurred, a snippet of
 * HTML called the loginRequiredMarker must be added to the session timeout response sent by the authentication system. 
 * The loginRequiredMarker is standardized and does not need to be customized for your deployment.  It can be added to an
 * HTML page without visual effect, or if the response sent on session timeout is not an HTML page, simply embedded in any
 * other type of response, or sent as the entirety of the response.  The loginRequiredMarker is in
 * isomorphic/login/loginRequiredMarker.html. <P> When Smart GWT detects the loginRequired marker, the transaction that
 * encountered session timeout is put on hold, and {@link com.smartgwt.client.rpc.RPCManager#loginRequired
 * RPCManager.loginRequired} is called.  At this point you have a few options: <ol>  <li> Leave the Smart GWT application
 * and take the user to the login page, by simply doing a <code>window.location.replace(<i>myLoginURL</i>)</code>, the
 * simplest but least user friendly option.  <li> Open a new browser window that goes to your plain HTML login form (or
 * offer a link that opens such a browser window), using a modal dialog in the application page that prompts the user to
 * login before continuing, then re-send the intercepted transaction ({@link
 * com.smartgwt.client.rpc.RPCManager#resendTransaction RPCManager.resendTransaction} when the user indicates he has logged
 * in. This is simple, does not drop context, but is not seamless.  <li> Use a Smart GWT interface, typically a DynamicForm
 * in a Window, to collect credentials, perform login as a background RPC, and on success re-send the intercepted
 * transaction ({@link com.smartgwt.client.rpc.RPCManager#resendTransaction RPCManager.resendTransaction}.  A complete
 * example of this, which assumes an authentication system that can take credentials as HTTP POST params, is included in
 * the SDK as isomorphic/login/reloginFlow.js.  </ol> <B>Authentication via background RPC form POST</B> <P> The approach
 * shown in reloginFlow.js posts the credentials gathered from the user to {@link
 * com.smartgwt.client.rpc.RPCManager#credentialsURL}.  To make this work with an authentication system that can accept
 * credentials via HTTP POST: <ol> <li> set the RPCManager.credentialsURL to the URL where credentials should be POST'd
 * <li> include reloginFlow.js in your page, modified, if necessary, so that the names of the USERNAME and PASSWORD params
 * match what your authentication system uses <li> configure your authentication system to send back the loginSuccessMarker
 * as part of a successful login response, and the loginRequiredMarker as part of a failed login response </ol> If your
 * authentication system can accept POST'd credentials at any URL it protects, the last step may be as simple as
 * configuring the loginSuccessMarker file itself as a protected resource (isomorphic/login/loginSuccess.html). <P>
 * <B>Authentication via background Smart GWT server RPC/DMI</B> <P> If you are using the Smart GWT Java server and your
 * authentication system allows you to mark a user as authenticated from Java, you can perform a normal RPC or DMI with the
 * credentials gathered from the user and send back success or failure indications as normal RPC or DMI responses.  This
 * can be useful if, in addition to logging in, you want to send back additional data. <P> <B>Advanced: concurrency</B> <P>
 * If, after loginRequired() has fired and before the user has re-authenticated, you send additional RPCs to protected
 * URLs, you will get additional loginRequired() notifications.  This may happen to applications that poll for data or
 * periodically save without user action.  You may wish to avoid this by setting an application-specific flag to avoid
 * firing requests during the relogin process.  However, you must ultimately either {@link
 * com.smartgwt.client.rpc.RPCManager#resendTransaction RPCManager.resendTransaction} or {@link
 * com.smartgwt.client.rpc.RPCManager#clearTransaction RPCManager.clearTransaction} every transaction for which
 * loginRequired() fires, or you will have a memory leak due to suspended transactions. <P> Note also that there is no
 * requirement that the relogin process blocks user interaction. Applications that access multiple services may choose to
 * simply show an unobtrusive error indication such that the user can log back in at his leisure, or even log the user back
 * in automatically.
 * @see com.smartgwt.client.data.DataSourceField#getChildTagName
 * @see com.smartgwt.client.rpc.RPCManager#loginRequired
 * @see com.smartgwt.client.rpc.RPCRequest#getContainsCredentials
 */
public interface Relogin {
}
