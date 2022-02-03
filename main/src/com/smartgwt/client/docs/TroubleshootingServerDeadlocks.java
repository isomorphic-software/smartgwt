
package com.smartgwt.client.docs;

/**
 * <h3>Troubleshooting thread deadlocks on the server</h3>
 * Java thread deadlocking can occur in a multi-threaded application when two or more threads 
 * need the same lock and block while waiting for it. These threads can be permanently blocked
 * (deadlocked), waiting for each other. <P> For developers using the Smart GWT server, if
 * deadlocks are encountered we recommend the following troubleshooting steps: <ul> <li>Search
 * server code for calls to DataSourceManager and audit whether you are     following the
 * documented pooling rules for obtaining and releasing dataSources</li> <li>Look at the
 * deadlocked thread ID and looked at the server logs for the logs for      the last request that
 * thread serviced.<br>     Our default logging messages include the thread ID so you can easily
 * correlate      the logs with the hung thread. You can also adjust server logging sensitivity
 * via     settings in the log4j configuration file (<i>log4j.isc.config.xml</i>).<br>     Note
 * that the logged thread IDs are shortened by default. If there isn't enough      information
 * shown to correlate with the deadlocked thread you can also change the      logging format
 * (pattern) in the log4j configuration file.<br>     If you are using some other log package, it
 * should be easy to turn on logging of      thread IDs, and you should do so - this is a basic
 * logging best practice.<br>     See documentation {@link com.smartgwt.client.docs.ServerLogging
 * here} for more information on server side     logging.</li>  <li>Attach a tool such as
 * Dynatrace so that you can inspect the hung thread.</li>  <li>Examine any threaded code you may
 * have, and made sure it likewise follows the       rules of pooling (see also {@link
 * com.smartgwt.client.docs.StandaloneDataSourceUsage Standalone DataSource Usage})</li> </ul>
 */
public interface TroubleshootingServerDeadlocks {
}
