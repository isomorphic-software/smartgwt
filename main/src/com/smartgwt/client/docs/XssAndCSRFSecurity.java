
package com.smartgwt.client.docs;

/**
 * <h3>XSS and CSRF Security</h3>
 * Cross-site scripting (XSS) and Cross-site request forgery (CSRF, sometimes XSRF) are 
 *  two separate exploits that can be used to attack a vulnerable web application:<ul>
 *  <li>XSS allows an attacker to execute arbitrary Javascript in the user's browser.
 *      <a href="https://en.wikipedia.org/wiki/Cross-site_scripting">Wikipedia</a></li>
 *  <li>CSRF allows an attacker to mislead the user into carrying out an action they did
 * not intend.  <a
 * href="https://en.wikipedia.org/wiki/Cross-site_request_forgery">Wikipedia</a></li>
 *  </ul>
 * 
 *  <h4>Cross-site scripting</h4>
 *  XSS attacks are made possible when values sent from the client are accepted as data
 *  values without first sanitizing them.  Here, <i>sanitizing</i> means checking values
 *  to ensure that they do not contain structures that would be interpreted as executable 
 *  code if placed into an HTML document.  An example of this in a Smart GWT application
 *  would be a text field into which the user is supposed to enter their name.  If an 
 *  attacker instead enters into that field<pre>
 *     &lt;script&gt;alert("Hacked!")&lt;/script&gt;
 *  </pre>
 *  then inserting that field value into an HTML document will cause the script to execute.
 *  <p>
 * The way to prevent this kind of attack is {@link
 * com.smartgwt.client.data.DataSourceField#getEscapeHTML DataSourceField.escapeHTML}.  Setting
 *  that flag on your fields will ensure that script embedded in field values won't
 *  execute; because it is escaped, the value will be treated as literal text.
 * 
 *  <h4>Cross-site request forgery</h4>
 *  CSRF attacks occur when a malicious website sends a legitimate-looking request to a 
 *  web application that the user is already logged into.  Such attacks rely on the use 
 *  of session cookies as the sole mechanism for identifying and authenticating the user,
 *  so the best way to prevent such an attack is to introduce an additional means of 
 *  identifying the user: this is usually known as a CSRF token.
 *  <p>
 *  A CSRF token is a unique string of text that you generate on the server on session 
 *  creation, and then expect to be passed as a parameter with all future requests.  By 
 *  storing the CSRF token in the session and comparing it to the passed token parameter,
 *  you can be sure that the request came from a source that is privy to the CSRF token,
 *  and thus that the request is not forged.
 *  <p>
 *  implementing a CSRF token strategy is really easy with Smart GWT, especially if you 
 *  are using the Smart GWT server framework.  Since all data-related requests go to a 
 * single URL, specified with {@link com.smartgwt.client.rpc.RPCManager#actionURL actionURL}, you
 * can just add your CSRF 
 *  token to that URL in your bootstrap file.  Alternatively, you could use 
 * {@link com.smartgwt.client.rpc.RPCManager#transformRequest RPCManager.transformRequest()} to
 * add your token, if your authentication system 
 *  requires the CSRF token in another part of the request (for example, in an HTTP header).
 *  Using a CSRF token is a <b>highly recommended</b> security practice.
 * 
 *  <h4>Domain synchronization</h4>
 *  Smart GWT implements a technique called <i>domain synchronization</i> to ensure that 
 *  server communications using the "hiddenFrame" protocol work reliably.
 *  <p>
 *  The "hiddenFrame" protocol uses an iframe to load content from the server.  If your
 *  page sets <code>document.domain</code> at all, an iframe must have a matching 
 *  <code>document.domain</code> setting or it can't contact the main page to report 
 *  results.  Due to proxying and other commonly-used techniques, there is no reliable way
 *  for the server to know what <code>document.domain</code> setting must be used.
 *  Therefore, Smart GWT passes the setting to the server with each "hiddenFrame"
 *  request, in a parameter called <code>isc_dd</code>, and the server echoes that setting
 *  back down to the client.
 *  <p>
 *  Domain synchronization opens up the potential for an obscure hybrid XSS/CSRF attack on
 *  a Smart GWT application, where it shares a domain with another, non-Smart GWT 
 *  application that is vulnerable to XSS attacks - for example, a Smart GWT app at 
 *  <code>payments.example.com</code> and a non-Smart GWT app at 
 *  <code>enquiry.example.com</code>.  This attack would work by injecting an XSS payload 
 *  into the vulnerable, non-Smart GWT app at <code>enquiry.example.com</code>; this 
 *  injected code would set the domain to "example.com", and then create an iframe that
 *  targets the Smart GWT app at "payments.example.com", passing <code>isc_dd</code> as
 *  "example.com".  The return function from that CSRF call would be able to access data 
 *  from "payments.example.com", as a result of exploiting an XSS  vulnerability in the app
 *  at "enquiry.example.com".
 *  <ul>
 *  <li>This exploit is only possible in these exact circumstances: ie, where a Smart GWT 
 *      app is deployed to the same domain as a non-Smart GWT app that is vulnerable to 
 *      XSS attacks</li>
 *  <li>The attack is only meaningful if you have multiple separate apps deployed at 
 *      different subdomains, with separate sets of users for each app</li>
 *  <li>The attack is impossible if CSRF tokens are employed in the Smart GWT app, since 
 *      the forged request to "payments.example.com" would be rejected as lacking a CSRF 
 *      token</li>
 *  <li>If your page does not set <code>document.domain</code>, there is no need for 
 *      domain synchronization, and you can simply switch it off by specifying
 *      <code>domainSync.disabled: true</code> in your <code>server.properties</code> file</li>
 *  <li>If your page <i>does</i> set <code>document.domain</code>, you can prevent this 
 *      kind of exploit by providing a comma-separated list of valid base domains in 
 *      <code>server.properties</code> setting <code>domainSync.baseDomains</code>.  For 
 *      example, the following setting would have prevented the above attack:
 *      <code>domainSync.baseDomains: payments.example.com</code></li>
 *  </ul>
 *  Note that if you leave domain synchronization switched on and do not constrain it by 
 *  providing a <code>baseDomains</code> setting as described above, the system will log a 
 *  warning every time it echoes a client-provided domain name in a response.
 */
public interface XssAndCSRFSecurity {
}
