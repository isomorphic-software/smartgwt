
package com.smartgwt.client.docs;

/**
 * <h3>Real-Time Messaging</h3>
 * The optional Real-Time Messaging (RTM) module for Smart GWT allows browser-based web
 * applications to:
 *  <ul>
 *  <li>publish and subscribe to HTTP messaging channels</li>
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
 * onclick="window.open('http://smartclient.com/product');return
 * false;">http://smartclient.com/product</a> for details, and see 
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
 *  channel is "topic".
 *  <p>
 *  Messages can be sent to a channel from either the client-side ( Messaging.send)
 *  or server-side (ISCMessageDispatcher.send(), or equivalent JMS APIs to send a message to a
 *  Topic).
 *  <p>
 *  You can subscribe to a channel from either the client-side ( Messaging.subscribe)
 *  or server-side (ISCMessageDispatcher.register(), or equivalent JMS APIs to subscribe to a
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
 *    returns a concrete ISCMessageDispatcher class capable of delivering responses within the JVM
 *                  </div>
 *          </td></tr><tr><td>
 *             <hr />
 *             <span style="font-family: monospace;">instance(RequestContext context)</span>
 *                  <div style="width: 75%; margin-left: 15%; float: left;">
 *   returns a concrete ISCMessageDispatcher class capable of delivering responses to web browsers
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
 *  <h3>Configuration</h3>
 *  <p>
 *  The Smart GWT message dispatcher can operate in simple mode or enterprise mode:
 *  <ul>
 *  <li>Simple mode uses an in-memory messaging delivery system with no message persistence, and
 *      can operate only in the context of a single JVM.</li>
 *  <li>Enterprise mode uses Java Message Service (JMS) as the messaging backend, and can
 *      operate in a clustered environment.</li>
 *  </ul>
 * You can set the following properties in WEB-INF/classes/server.properties to control this mode
 * and other parameters:
 *  <table style="border: 1px solid black;">
 *  <tr><td style="background-color: #f4f4f4;">
 *  <pre> 
 *  # how often do we send keepalives to the client (ms) 
 *         messaging.keepaliveInterval: 3000
 * 
 *  # how long the client waits after the keepaliveInterval before re-establishing
 *  # the connection (ms)
 *         messaging.keepaliveReestablishDelay: 1000
 * 
 *  # how long the client waits for the connect handshake to complete before 
 *  # retrying 
 *         messaging.connectTimeout: 4000
 * 
 *  # connection time to live - the maximum amount of time a persistent connection
 *  # is allowed to stay open before being re-established (ms) 
 *         messaging.connectionTTL: 120000
 * 
 *  # total response size to pad out to in order to defeat intervening
 *  # bufferring by proxies (bytes)
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
 *  </pre>
 *  </td></tr>
 *  </table>
 *  
 *  <p>
 *  Example configurations for various populate JMS engines (ActiveMQ, JBoss, etc) can be found
 *  on the
 * <a href='http://wiki.smartclient.com/'
 * onclick="window.open('http://wiki.smartclient.com/');return false;">Isomorphic Public Wiki</a>.
 *  Try searching for 
 * <a href='http://wiki.smartclient.com/dosearchsite.action?queryString=messaging'
 * onclick="window.open('http://wiki.smartclient.com/dosearchsite.action?queryString=messaging');return
 * false;">"messaging"</a> or
 * <a href='http://wiki.smartclient.com/dosearchsite.action?queryString=jms'
 * onclick="window.open('http://wiki.smartclient.com/dosearchsite.action?queryString=jms');return
 * false;">"jms"</a> or the
 *  name of the engine you are trying to configure.
 * 
 *  <h3>Tips</h3>
 *  <p>
 *  <ul>
 *  <li>We recommend developing using a single container with the LocalMessageDispatcher and
 *      then switching to the JMSMessageDispatcher for production.</li>
 *  <li>For best performance, we recommend forwarding the messaging connections to an HTTP 1.0
 *      server. This results in better interactive behaviour in older Internet Explorer web
 *      browsers (pre-8.0)</li>
 *  </ul>
 *  <p>
 */
public interface Messaging {
}
