
package com.smartgwt.client.docs;

/**
 * <h3>Application Declaration Files</h3>
 * When using the Smart GWT server, server side methods written in java can be directly 
 *  invoked from client side code via the  DMI.call API.
 *  <P>
 *  In order to support this an application configuration file needs to be present on your
 *  server. This file lists out what server side methods are exposed for direct invocation.
 *  The application configuration file should be named <code><i>appID</i>.app.xml</code> (where 
 *  <i>"appID"</i> is some arbitrary id for your application) and must be present at the
 *  location specified by the <code>project.apps</code> setting in 
 *  the <code>server.properties</code> file.
 *  <P>
 *  The application declaration should be written in xml, and should contain a
 * <code>rpcBindings</code> block, which holds {@link
 * com.smartgwt.client.docs.serverds.ServerObject} definitions for each
 *  exposed method. Here's an example demonstrating the specified format:
 *  <pre>
 *     &lt;Application&gt;
 *         &lt;rpcBindings&gt;
 *             &lt;ServerObject ID="MathUtil" className="com.example.package.MathUtil"&gt;
 *                 &lt;visibleMethods&gt;
 *                     &lt;method name="addIntegers"/&gt;
 *                 &lt;/visibleMethods&gt;
 *             &lt;/ServerObject&gt;
 *         &lt;/rpcBindings&gt;
 *     &lt;/Application&gt;
 *  </pre>
 * 
 *  In this example we're exposing a method <i>"addIntegers"</i> on the server side java
 *  class <code>com.example.package.MathUtil</code>. A developer could then call DMI.call(...)
 *  on the client side code to invoke this method on the server, and get at the returned value
 * in the {@link com.smartgwt.client.rpc.RPCResponse} passed to the  RPCCallback. Note that the
 * application
 *  config file does not explicitly list out a method signature - the appropriate method to
 *  call is detected automatically based on the parameters passed to DMI.call on the client side.
 *  <P>
 * See the {@link com.smartgwt.client.docs.DmiOverview DMI overview} for further information on
 * Direct Method Invocation
 *  in Smart GWT.
 */
public interface ApplicationDeclaration {
}
