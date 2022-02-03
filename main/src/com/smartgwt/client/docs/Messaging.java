
package com.smartgwt.client.docs;

/**
 * <h3>Real-Time Messaging</h3>
 * The optional Real-Time Messaging (RTM) module for Smart GWT allows browser-based web
 * applications to:
 *  <ul>
 *  <li>publish and subscribe to client-server messaging channels</li>
 *  <li>send and receive messages via server push, for "real-time" updates without polling</li>
 *  </ul>
 * For examples of publish and subscribe messaging, see: @see <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#FSportfolioGrid"
 * target="examples">Portfolio Grid</a>
 * and @see <a href="http://www.smartclient.com/smartgwtee/showcase/#FSstockQuotesChart"
 * target="examples">Stock Chart</a>
 *  <p>
 *  This functionality is currently supported for deployment on Java server platforms only, and
 *  requires a Power license or better as well as purchase of the Real-Time Messaging
 * module.  See <a href='http://smartclient.com/product'
 * target='_blank'>http://smartclient.com/product</a> for details, and see 
 * {@link com.smartgwt.client.docs.LoadingOptionalModules} for instructions on setting up the
 * Messaging module.
 *  <p>
 *  <h3>Usage Summary</h3>
 *  <p>
 *  Messaging works in terms of <i>channels</i>.  A <i>channel</i> is an abitrary identifier for
 *  a destination for a message.  When messages are sent to a channel, anyone subscribed
 *  to that channel receives the message.
 *  <p>
 *  The same concept appears in JMS (Java Message Service), where the equivalent term to
 *  channel is "topic" (for JMS, queues are supported as well).
 *  <p>
 *  Messages can be sent to a channel from either the client-side ( Messaging.send())
 *  or server-side (ISCMessageDispatcher.send(), or equivalent JMS APIs to send a message to a
 *  Topic).
 *  <p>
 *  You can subscribe to a channel from either the client-side ( Messaging.subscribe())
 * or server-side (ISCMessageDispatcher.register() and ISCMessageDispatcher.subscribe(), or
 * equivalent JMS APIs to subscribe to a
 *  Topic).
 *  <p>
 *  Channels can be used in any way the application needs.  For example, a chat application
 *  similar to IRC would typically create a new channel every time 2 or more people want to talk
 *  to one another.
 *  <p>
 *  <h3>Server API summary</h3>
 *  <p>
 *  Server-side RTM interfaces are provided by the following classes in com.isomorphic.messaging:
 *  <table style="width: 80%;"> <!-- Packages -->
 *  <tr><td><hr /><span style="font-family: monospace;">ISCMessageDispatcher</span>
 *          <table style="width: 90%; margin-left: 10%; float: left;">
 *          <tr><td>
 *          Abstract class; use to obtain a concrete message dispatcher class.
 *          </td></tr><tr><td>
 *             <hr />
 *             <span style="font-family: monospace;">instance()</span>
 *                  <div style="width: 75%; margin-left: 15%; float: left;">
 *                  returns a concrete ISCMessageDispatcher class capable of delivering
 *                  responses within the JVM or JMS (based on configuration)
 *                  </div>
 *          </td></tr><tr><td>
 *             <hr />
 *             <span style="font-family: monospace;">send(ISCMessage msg)</span>
 *                  <div style="width: 75%; margin-left: 15%; float: left;">
 *                  send a message
 *                  </div>
 *          </td></tr><tr><td>
 *             <hr />
 *             <span style="font-family: monospace;">register(ISubscriber subscriber)</span>
 *                  <div style="width: 75%; margin-left: 15%; float: left;">
 *                  register this subscriber
 *                  </div>
 *          </td></tr><tr><td>
 *             <hr />
 *             <span style="font-family: monospace;">unregister(ISubscriber subscriber)</span>
 *                  <div style="width: 75%; margin-left: 15%; float: left;">
 *                  unregister this subscriber
 *                  </div>
 *          </td></tr><tr><td>
 *             <hr />
 *  <span style="font-family: monospace;">subscribe(ISubscriber subscriber, String channel)</span>
 *                  <div style="width: 75%; margin-left: 15%; float: left;">
 *                  subscribe a given subscriber to a given channel
 *                  </div>
 *          </td></tr><tr><td>
 *             <hr />
 * <span style="font-family: monospace;">unsubscribe(ISubscriber subscriber, String
 * channel)</span>
 *                  <div style="width: 75%; margin-left: 15%; float: left;">
 *                  unsubscribe a given subscriber from a given channel
 *                  </div>
 *          </td></tr><tr><td>
 *             <hr />
 * <span style="font-family: monospace;">boolean isSubscribed(ISubscriber subscriber, String
 * channel)</span>
 *                  <div style="width: 75%; margin-left: 15%; float: left;">
 *                  check to see if a given subscriber is subscribed to a given channel
 *                  </div>
 *           </td></tr>
 *          </table>
 *  </td></tr>
 *  
 *  <tr><td><hr /><span style="font-family: monospace;">ISCMessage</span>
 *          <table style="width: 90%; margin-left: 10%; float: left;">
 *          <tr><td>
 *          Message object.
 *          </td></tr><tr><td>
 *             <hr />
 *            <span style="font-family: monospace;">ISCMessage(String channel, Object data)</span>
 *          </td></tr><tr><td>
 *             <hr />
 *             <span style="font-family: monospace;">ISCMessage(List channels, Object data)</span>
 *                  <div style="width: 75%; margin-left: 15%; float: left;">
 *             create a message bound for the specified channel(s) with the specified data payload
 *                  </div>
 *           </td></tr>
 *          </table>
 *  </td></tr>
 *  
 *  <tr><td><hr /><span style="font-family: monospace;">ISubscriber</span>
 *          <table style="width: 90%; margin-left: 10%; float: left;">
 *          <tr><td>
 *          Simple interface for a message subscriber. Required methods are:
 *          </td></tr><tr><td>
 *             <hr />
 * <span style="font-family: monospace;">public void send(ISCMessage msg) throws Exception;</span>
 *          </td></tr><tr><td>
 *             <hr />
 * <span style="font-family: monospace;">public ISCMessage nextMessage(long timeout) throws
 * Exception;</span>
 *           </td></tr>
 *          </table>
 *  </td></tr>
 *  
 *  <tr><td><hr /><span style="font-family: monospace;">ISCSubscriber</span>
 *          <div style="width: 80%; margin-left: 60px; float: left;">
 * Simple concrete implementation of ISubscriber. send() adds message to a queue and nextMessage()
 * retrieves them.
 *          </div>
 *  </td></tr>
 *  </table> <!-- Packages -->
 *  
 *  <p>
 *  <h3>Data Protocols</h3>
 * The Realtime Messaging subsystem supports real-time communication between client and server
 * using 
 * either <a href='https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API'
 * target='_blank'>WebSockets</a> or
 * <a href='https://en.wikipedia.org/wiki/Comet_(programming)' target='_blank'>Comet [HTTP Server
 * Push]</a>.
 *  <P>
 * WebSockets is preferred as the non-websockets implementation requires a persistent connection
 * to the server,
 * and browsers are mandated by the HTTP protocol spec to limit connections to a single host to 6.
 * 
 * This becomes significant if an application with Messaging connections is opened in multiple
 * browser windows or tabs.
 *  The application can be significantly slowed down as as connections are used up by messaging,
 * meaning the app's non-messaging operations will start slowing down and blocking as fewer
 * connections are available
 *  for parallel operations.
 *  <P>
 *  Both client and server are configured to  use WebSockets by default if supported.
 * If the server does not respond correctly to WebSocket requests, the framework will
 * automatically detect
 * this and silently back off to using Comet. The Messaging APIs are not impacted in any way by
 * the protocol being used,
 *  so this process is invisible to end users and to application code.
 *  <P>
 *  Some cases that may cause WebSockets to be unavailable include:
 *  <ul>
 *   <li>Firewalls configured to block the webSocket connnections</li>
 * <li>Proxies / reverse proxies that haven't been configured to handle the webSocket (wss://)
 * protocol</li>
 *   <li>Older servlet engines that don't support websockets</li>
 *  </ul>
 *  </li>
 * If you're unsure which protocol is being used by a running application, you can use the native
 * browser
 *  developer tools to  watch for network requests against the  websocketURL 
 *  and  messagingURL.<br>
 *  If you're unsure <i>why</i> Web Sockets are not being used in your application we'd recommend 
 * enabling DEBUG level server-side logging for com.isomorphic.messaging. This should report
 * details on
 *  the framework's attempts to set up a websocket listener during server startup.
 *  <h3>Server Configuration</h3>
 *  <p>
 *  The Smart GWT message dispatcher can operate in simple mode or enterprise mode:
 *  <ul>
 *  <li>Simple mode uses an in-memory messaging delivery system with no message persistence, and
 *      can operate only in the context of a single JVM</li>
 *  <li>Enterprise mode uses Java Message Service (JMS) as the messaging backend, and can
 *      operate in a clustered environment</li>
 *  </ul>
 *  The default settings will use the Simple Mode (no JMS).  To use JMS, set the following in
 *  {@link com.smartgwt.client.docs.Server_properties server.properties}:
 *  <pre>
 *  # Use com.isomorphic.messaging.JMSMessageDispatcher for JMS-backed messaging
 *  messaging.dispatcherImplementer: com.isomorphic.messaging.JMSMessageDispatcher 
 *  </pre>
 *  <p>
 *  <h4>JMS configuration: setting JNDI properties</h4>
 *  <p>
 *  There are two styles of configuring JNDI and configuring Smart GWT Messaging to find a JMS
 *  Topic or Queue Connection Factory:
 *  <p>
 *  <b>1. Configure JNDI in your servlet engine</b>
 *  <p>
 *  In this case, you would set JNDI properties (java.naming.* properties) via your application's
 * <a href='http://docs.oracle.com/javase/jndi/tutorial/beyond/env/source.html'
 * target='_blank'>jndi.properties</a> file.
 *  <p>
 *  <b>2. Configure JNDI via server.properties</b>
 *  <p>
 *  If you set <code>messaging.jms.context</code> to a string such as "mySettings", it tells
 *  Smart GWT to refer to several other properties in the <code>server.properties</code> file,
 *  prefixed with "jndi" + the value of <code>messaging.jms.context</code>.  For example:
 *  <p>
 *  <pre>
 *  messaging.jms.context: mySettings
 *  jndi.mySettings.java.naming.factory.initial: org.jboss.naming.remote.client.InitialContextFactory
 *  jndi.mySettings.java.naming.provider.url: remote://localhost:4447
 *  jndi.mySettings.java.naming.factory.url.pkgs: org.jboss.naming:org.jnp.interfaces
 *  jndi.mySettings.java.naming.security.authentication: simple
 *  jndi.mySettings.java.naming.security.principal: admin
 *  jndi.mySettings.java.naming.security.credentials: admin
 *  </pre>
 *  The configuration above means that, when the Messaging system uses JNDI to look up
 *  ConnectionFactory instances, the Hashtable of environment information passed to <code>new
 *  InitialContext()</code> will contain entries such as <code>java.naming.provider.url =
 *  remote://localhost:4447</code> and the various other <code>java.naming.*</code> JNDI
 *  properties shown above.
 *  <p>
 *  This is an alternative to using <code>jndi.properties</code> or other means provided by your
 *  servlet engine for JNDI setup.  If you use this mechanism, the JNDI properties shown above
 *  will be used only when Messaging looks up JMS resources, and not for any other JNDI lookups.
 *  <p>
 *  <h4>JMS configuration: JNDI path to find ConnectionFactory instances</h4>
 *  <p>
 *  When using JNDI "lookup()" calls to find your JMS ConnectionFactory instances, Smart GWT
 *  using the following properties from server.properties (shown below with their default
 *  values):
 *  <pre>
 *         messaging.jms.jndiPrefix: jms
 *         messaging.jms.topicConnectionFactory: TopicConnectionFactory
 *         messaging.jms.queueConnectionFactory: QueueConnectionFactory
 *  </pre>
 *  Smart GWT will first call the JNDI API <code>context.lookup()</code> with the
 *  <code>jndiPrefix</code> property shown above, then with either the
 *  <code>topicConnectionFactory</code> or <code>queueConnectionFactory</code> property
 *  depending on whether a topic or queue is being looked up.
 *  <p>
 *  Note that <i>there is horrible confusion and inconsistency across servlet engines</i> as to
 *  how JNDI paths are handled when looking up JMS resources:
 *  <ul>
 *  <li> you <i>may</i> need to specify the prefix "java:comp/env" as part of the
 *       <code>messaging.jms.jndiPrefix</code> property, or it may be considered implicit
 *  <li> when defining the "name" attribute on the JNDI &lt;Resource&gt; tag for your
 *       ConnectionFactory or a specific Topic or Queue, you <i>may</i> need to use the prefix
 *       "jms/" in the "name" attribute, and if you don't, your Resource may be unable to be
 *       found.  So for example, if you meant to name a Topic "MyTopic"
 *       the name may need to be "jms/MyTopic".  Alternatively, adding the "jms/" prefix may mean
 *       that the path to lookup the resource is now "jms/jms/MyTopic" or that it cannot be
 *       found at all.
 *  <li> whether or not you used the prefix "jms" in the "name" attribute of your
 *       &lt;Resource&gt;, it may be required as part of the
 *       <code>messaging.jms.jndiPrefix</code> property.
 *  </ul>
 *  So for example, if you have Topic ConnectionFactory named either "jms/MyFactory" or just
 *  "MyFactory", any of the following settings may work:
 *  <pre>
 *         messaging.jms.jndiPrefix: java:comp/env
 *         messaging.jms.topicConnectionFactory: jms/MyFactory
 *  </pre>
 *  <pre>
 *         messaging.jms.jndiPrefix: 
 *         messaging.jms.topicConnectionFactory: jms/MyFactory
 *  </pre>
 *  <pre>
 *         messaging.jms.jndiPrefix: 
 *         messaging.jms.topicConnectionFactory: MyFactory
 *  </pre>
 *  <pre>
 *         messaging.jms.jndiPrefix: java:comp/env
 *         messaging.jms.topicConnectionFactory: MyFactory
 *  </pre>
 *  Example configurations for various popular JMS engines (ActiveMQ, JBoss, etc) can be found
 *  on the
 * <a href='http://wiki.smartclient.com/' target='_blank'>Isomorphic Public Wiki</a>.  Try
 * searching for 
 * <a href='http://wiki.smartclient.com/dosearchsite.action?queryString=messaging'
 * target='_blank'>"messaging"</a> or
 * <a href='http://wiki.smartclient.com/dosearchsite.action?queryString=jms'
 * target='_blank'>"jms"</a> or the
 *  name of the engine you are trying to configure.
 *  <p>
 *  <h3>Other Messaging properties</h3>
 *  <p>
 *  The following properties that control Messaging can also be set via server.properties.
 *  Generally, do not adjust these properties unless you are extremely familiar with how
 *  web-based streaming works and with the specific details of your network topology.
 *  <pre> 
 *  # how often do we send keepalives to the client (ms) 
 *         messaging.keepaliveInterval: 3000
 * 
 *  # how long the client waits after the keepaliveInterval before re-establishing
 *  # the connection (ms)
 *         messaging.keepaliveReestablishDelay: 1000
 * 
 *  # how long the client waits for the connect handshake to complete before 
 *  # retrying (ms)
 *         messaging.connectTimeout: 4000
 * 
 *  # connection time to live - the maximum amount of time a persistent connection
 *  # is allowed to stay open before being re-established (ms).  Connections are re-created
 *  # every 2 minutes by default because intervening firewalls or web proxies will often sever
 *  # connections that have been open too long, as will the browser itself.
 *         messaging.connectionTTL: 120000
 * 
 *  # total response size to pad out to in order to defeat bufferring by intervening proxies
 *  # (in bytes).  Set higher if you see data leaving the server, but it never arrives at the
 *  # client machine.  With older legacy proxies, values as high as 256k may be required.
 *         messaging.flushBufferSize: 8096
 * 
 *  # dispatcher to use for user registration/message queueing
 *  # com.isomorphic.messaging.LocalMessageDispatcher for simple one-jvm messaging
 *  # com.isomorphic.messaging.JMSMessageDispatcher for JMS-backed messaging
 *         messaging.dispatcherImplementer: com.isomorphic.messaging.LocalMessageDispatcher
 * 
 *  # jms configuration - for JMSMessageDispatcher only
 *         messaging.jms.context: _container_
 *         messaging.jms.jndiPrefix: jms
 *         messaging.jms.topicConnectionFactory: TopicConnectionFactory
 *         messaging.jms.queueConnectionFactory: QueueConnectionFactory
 *  </pre>
 *  <p>
 *  <h3>Tips</h3>
 *  <p>
 *  <ul>
 *  <li>For best performance on legacy browsers (Internet Explorer pre-8.0), we recommend
 *      forwarding the messaging connections to an HTTP 1.0 server.  Otherwise, because older
 *      Internet Explorer browsers use no more than 2 concurrent connections to the same web
 *      server, with the Messaging connection open, all other connections will execute
 *      serially.  This means that something like a data fetch might be held up until all images
 *      on the page have finished loading.</li>
 *  </ul>
 *  <p>
 */
public interface Messaging {
}
