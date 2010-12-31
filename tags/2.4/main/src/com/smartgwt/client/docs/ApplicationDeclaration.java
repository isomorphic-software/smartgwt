
package com.smartgwt.client.docs;

/**
 * <h3>Application Declaration Files</h3>
 * When using the Smart GWT server, server side methods written in java can be directly &#010 invoked from client side code
 * via the  DMI.call API.&#010 <P>&#010 In order to support this an application configuration file needs to be present on
 * your&#010 server. This file lists out what server side methods are exposed for direct invocation.&#010 The application
 * configuration file should be named <code><i>appID</i>.app.xml</code> (where &#010 <i>"appID"</i> is some arbitrary id
 * for your application) and must be present at the&#010 location specified by the <code>project.apps</code> setting in
 * &#010 the <code>server.properties</code> file.&#010 <P>&#010 The application declaration should be written in xml, and
 * should contain a&#010 <code>rpcBindings</code> block, which holds {@link com.smartgwt.client.docs.serverds.ServerObject}
 * definitions for each&#010 exposed method. Here's an example demonstrating the specified format:&#010 <pre>&#010   
 * &lt;Application&gt;&#010        &lt;rpcBindings&gt;&#010            &lt;ServerObject ID="MathUtil"
 * className="com.example.package.MathUtil"&gt;&#010                &lt;visibleMethods&gt;&#010                   
 * &lt;method name="addIntegers"/&gt;&#010                &lt;/visibleMethods&gt;&#010           
 * &lt;/ServerObject&gt;&#010        &lt;/rpcBindings&gt;&#010    &lt;/Application&gt;&#010 </pre>&#010&#010 In this
 * example we're exposing a method <i>"addIntegers"</i> on the server side java&#010 class
 * <code>com.example.package.MathUtil</code>. A developer could then call DMI.call(...)&#010 on the client side code to
 * invoke this method on the server, and get at the returned value&#010 in the {@link com.smartgwt.client.rpc.RPCResponse}
 * passed to the RPCCallback. Note that the application&#010 config file does not explicitly list out a method signature -
 * the appropriate method to&#010 call is detected automatically based on the parameters passed to DMI.call on the client
 * side.&#010 <P>&#010 See the {@link com.smartgwt.client.docs.DmiOverview DMI overview} for further information on Direct
 * Method Invocation&#010 in Smart GWT.
 */
public interface ApplicationDeclaration {
}
