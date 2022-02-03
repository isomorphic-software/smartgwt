
package com.smartgwt.client.docs;

/**
 * <h3>Server logging</h3>
 * <h3>Default logging</h3>
 *  <p>
 *  Smart GWT's server-side classes have extensive built-in diagnostics which are output via
 * the <a href='http://logging.apache.org/log4j/1.2/' target='_blank'>Apache Log4j library</a>
 * (see below for
 *  other alternatives).
 *  <p>
 *  At startup, Smart GWT will automatically load the file <code>log4j.isc.config.xml</code>
 *  from the classpath and use it to configure Log4j.  <code>log4j.isc.config.xml</code> is in
 *  Log4j's standard 
 * <a href='http://wiki.apache.org/logging-log4j/Log4jXmlFormat' target='_blank'>XML configuration
 * format</a>,
 *  and sets default log threshold levels for various subsystems to produce output that is
 *  generally appropriate for both development and production systems.  Various Smart GWT
 *  documentation may encourage you to enable certain diagnostic logs using this file when
 *  troubleshooting specific problems.
 *  <p>
 *  <h3>Server Logs tab (Smart GWT Developer Console)</h3>
 *  <p>
 * The Server Logs tab of the {@link com.smartgwt.client.docs.Debugging Smart GWT Developer
 * Console} provides the
 *  ability to view the most recent 500 log entries, and change log threshold levels dynamically 
 *  at runtime.
 *  <p>
 *  <h3>Redirecting logging to other frameworks</h3>
 *  <p>
 *  Smart GWT server logging can alternatively use the Simple Logging Facade for Java (slf4j),
 *  which allows logs to be sent to a variety of different logging frameworks that support
 *  slf4j.
 *  <p>
 *  To send all logging to slf4j, the <code>iscUseSlf4j</code> VM argument must be set to true
 *  on the command line, like this:
 *  <pre>
 *  -DiscUseSlf4j=true
 *  </pre>
 *  If slf4j is used and the underlying log system is still Log4j, Smart GWT will still
 *  configure Log4j using <code>log4j.isc.config.xml</code> as describe above <i>unless</i> you
 *  pass an additional command line argument to prevent this:
 *  <pre>
 *  -DiscUseLog4jConfig=false
 *  </pre>
 *  If slf4j is used with any other logging system, Smart GWT will not attempt to apply
 *  configuration - see the
 * <a href='http://www.slf4j.org/manual.html' target='_blank'>SLF4J user manual</a> for details on
 * 
 *  how to configure slf4j.
 *  <p>
 *  Note that the features of the "Server Logs" tab will <b>not</b> be available if using slf4j,
 *  even if Log4j is also used.
 *  <p>
 *  <h3>Configure custom log4j loggers</h3>
 *  <p>
 *  If log4j is used and custom loggers are configured in <code>log4j.isc.config.xml</code> 
 *  file, use <code>DataTools.getLoggerRespository()</code> method to access them on server side, 
 *  like this:
 *  <pre>
 *  DataTools.getLoggerRepository().getLogger(CustomClass.class.getName());
 *  </pre>
 */
public interface ServerLogging {
}
