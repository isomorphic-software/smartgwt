
package com.smartgwt.client.docs;

/**
 * <h3>Deploying SmartGWT</h3>
 * This overview serves as a how-to for installing SmartGWT into your web application. Evaluators are urged to use the
 * SmartGWT SDK with the embedded tomcat servlet engine during evaluation rather than pursue installation into an existing
 * web application up front, however, reading this document and the related {@link
 * com.smartgwt.client.docs.ClientServerIntegration 'server integration'} materials is recommended to get an overview. <P>
 * SmartGWT has two pieces - the client components that run in the browser and the server components that run in a J2SE
 * compatible container.  You don't need to use a Java back-end to use SmartGWT, but the SDK comes with some examples that
 * assume the presence of the Java back-end and, for some examples, a SQL Database.  If you will be using SmartGWT with a
 * Java back-end, see below for the list of J2SE application servers supported by the Java implementation of the SmartGWT
 * server. <p> The SDK contains two top-level directories: <code>smartclientSDK</code> and <code>smartclientRuntime</code>.
 * The <code>smartclientSDK</code> directory contains the membedded servlet engine, embedded database, examples, and
 * documentation.  The <code>smartclientRuntime</code> directory contains just the client and server components of the
 * SmartGWT product - use the contents of this directory when deploying SmartGWT into your application environment. <p>
 * <u><b>Client integration</b></u> <p> To install the client-side portion of SmartGWT, simply copy the
 * <code>isomorphic</code> directory from the smartclientRuntime webroot to the webroot of your application.  Having done
 * this you can use SmartGWT components on your pages regardless of the technologies used on your back-end and you can bind
 * to server-side componentry backed by arbitrary technology - see the <i>Data Integration</i> section of the {@link
 * com.smartgwt.client.docs.ClientServerIntegration} section for more information. <p> <u><b>Server integration</b></u> <p>
 * SmartGWT can be {@link com.smartgwt.client.docs.NonJavaBackend 'integrated with any backend'} without installing the
 * SmartGWT Java server.  However, the SmartGWT server accelerates Java integration and provides other useful facilities,
 * including server-push and network performance enhancements.  See the {@link com.smartgwt.client.docs.IscServer 'SmartGWT
 * Server summary'} for details. <P> To integrate the server portion of SmartGWT, you need to follow the steps below for
 * each application (WAR) that uses SmartGWT.  Note that, if installing into an environment that uses multiple WARs,
 * installation of SmartGWT JARs into a directory shared by multiple applications is not supported.  Installation of a
 * separate WAR with client-side SmartGWT modules for maintaining cache coherence across applications using the same
 * version of ISC is supported - contact Isomorphic support for more details on how to set that up. <p> <span
 * style='color:red'>Note:</span> Some of the instructions below ask you to copy files into the WEB-INF/classes folder.  If
 * you're using an IDE such as Eclipse that attempts to manage the WEB-INF/classes folder, we recommend that you copy these
 * files to the src/ directory of your project (next to the top-level folder for your java namespace) such that your IDE
 * auto-deploys them to the WEB-INF/classes folder.  We have seen cases of tools like Eclipse periodically deleting files
 * that are checked into to WEB-INF/classes directly. <p> <ul> <li> Copy all files from the WEB-INF/lib directory of the
 * smartclientRuntime to your WEB-INF/lib.  SmartGWT leverages a number of third-party libraries - if there are conflicts
 * with the versions you want to use, use the versions you want - SmartGWT has minimal dependencies on these libraries. 
 * Contact Isomorphic with any specific questions about compatibility. See the "Java Module Dependencies" section below for
 * a dependency tree that will help you select a minimal set of JARs to deploy. <li> Copy the
 * WEB-INF/classes/log4j.isc.config.xml from the smartclientRuntime to your WEB-INF/classes directory.  This file contains
 * the SmartGWT server log configuration. <li> Copy the WEB-INF/classes/server.properties from the smartclientRuntime to
 * your WEB-INF/classes directory.  This file contains settings for basic file locations such the location of webroot, the
 * SmartGWT SQL engine and DMI.  The version under smartclientRuntime has a basic, secure configuration.  See the version
 * of server.properties under the smartclientSDK directory for sample SQL and other settings. <li> Copy the
 * WEB-INF/iscTaglib.xml from the smartclientRuntime to your WEB-INF directory. This file enables the use of custom
 * SmartGWT tags in your JSPs.   <li> Merge portions of the WEB-INF/web.xml into your application's web.xml.  To use
 * SmartGWT JSP tags like &lt;loadISC&gt;, you'll need to merge the &lt;jsp-config&gt; section from web.xml.  Also there
 * are some mandatory and optional servlets and filters to merge - see below. <li> <b>Power and Enterprise Editions
 * only</b>.  Copy the shared/ds/batchUpload.ds.xml file to the same location in your target webapp directory.  This file
 * is a utility DataSource that is used to provide the initial upload functionality of the {@link
 * com.smartgwt.client.widgets.BatchUploader}  component - strictly speaking, you only need to perform this step if you
 * intend to use that  component. </ul> <p> See {@link com.smartgwt.client.docs.ServletDetails 'Core and Optional SmartGWT
 * servlets'} for details of additional  changes you may need to make to your applications <code>web.xml</code> file.  See 
 * {@link com.smartgwt.client.docs.JavaModuleDependencies 'Java Module Dependencies'} for details of the .JAR files that
 * comprise the SmartGWT Server, and their dependencies on various third-party libraries. <p> <u><b>Troubleshooting</b></u>
 * <p> This section covers some common problems with possible solutions. You may also need to refer to the documentation
 * for your specific application server, web server, or database. If you experience any problems installing and configuring
 * SmartGWT in your environment, please post on the  <a href="http://forums.smartclient.com/" target='_blank'>SmartGWT
 * forums</a> for assistance. <p> <table width="90%" class="normal" align="center" border="1" cellpadding="5"> <tr
 * bgcolor="#808080">  <td width="30%"><b>Problem</b></td>  <td width="30%"><b>Possible Causes</b></td>  <td
 * width="40%"><b>Solution</b></td> </tr><tr>  <td rowspan='3'>Browser displays a generic "page cannot be displayed" or
 * "unable to locate the server" message.</td>  <td>Servlet engine not started.</td>  <td>Start your application
 * server.</td> </tr><tr>  <td>Missing/incorrect port for servlet engine in URL.</td>  <td>Check the startup messages,
 * logs, or documentation for the servlet engine to determine what port it is using.</td> </tr><tr>  <td>Host name is
 * incorrect.</td>  <td>Check whether other pages on the host can be accessed.   Try the base URL http://[host name]:[port
 * number] to see whether the servlet engine or webserver is functioning.</td> </tr><tr>  <td>Browser displays a 404 or
 * other page/file not found error.</td>  <td>Incorrect URL.</td>  <td>Check for errors in the URL, including
 * capitalization.</td> </tr><tr>  <td>Server error: taglib not defined</td>  <td>Missing iscTaglib.xml or iscTaglib.xml
 * not referenced in web.xml</td>  <td>Copy WEB-INF/iscTaglib.xml from smartclientRuntime to your deployment WEB-INF
 * directory  and make sure that you have merged the &lt;jsp-config&gt; section from the  smartclientRuntime web.xml</td>
 * </tr><tr>  <td>ClassNotFound or other Java Exceptions in the server log.</td>  <td>Missing JAR files</td>  <td>Verify
 * every .jar from the smartclientRuntime WEB-INF/lib directory has been copied to  your deployment WEB-INF/lib.  Although
 * you might later be able to remove some .jars, for  initial installation testing, copy every .jar</td> </tr><tr> 
 * <td>"isc" is not defined JS error</td>  <td>Incorrect URLs to SmartGWT modules</td>  <td>Use View Source to look at
 * SCRIPT includes (e.g. for ISC_Core.js), try those URLs  directly in the browser to verify the files are correctly
 * deployed</td> </tr> </table> <P> <u><b>Caching Considerations</b></u> <p> When upgrading from one SmartGWT release to
 * the next, you want to make sure that the user picks up the new version on next access, but you also want to keep the ISC
 * modules cacheable so they're not refetched on every access. <p> SmartGWT deals with this problem by appending a version
 * string as a query parameter to each module load directive.  This is done by the &lt;isomorphic:loadISC&gt; and
 * &lt;isomorphic:loadModules&gt; tags automatically.  As long as you make sure that the file that contains these tags is
 * non-cacheable, you will get the desired behavior. <p> <u><b>Supported J2SE Containers</b></u> <p> Below is the list of
 * J2SE containters that have been tested to be compatible with this version of SmartGWT.  Installation in these containers
 * is supported for deployment by Isomorphic.  If your application server is not on this list, please contact us at the <a
 * href="http://forums.smartclient.com" target='_blank'>SmartGWT forums</a> to see if we can support your deployment.  In
 * general, the Java portion of ISC should work on servlet containers that comply with servlet specification version 2.3
 * and up and utilize a JVM no older than version 1.4. <p> Supported J2SE Containers: <p> <table class='normal'> <tr><td
 * width=40></td><td width=200><i>Apache Tomcat 4.0.x, 4.1.x, 5.0.x, 5.5x, 6.0.x</i></td><td></td></tr>
 * <tr><td></td><td><i>Apache Geronimo 1.x, 2.x</i></td><td></td></tr> <tr><td></td><td><i>BEA WebLogic 6.x, 7x, 8.x, 9.x,
 * 10.x</i></td><td></td></tr> <tr><td></td><td><i>Caucho Resin 2.1.x, 3.0.x, 3.1.x</i></td><td></td></tr>
 * <tr><td></td><td><i>IBM WebSphere 5.x, 6.x</i></td><td></td></tr> <tr><td></td><td><i>IBM WebSphere Community Edition
 * 1.x</i></td><td></td></tr> <tr><td></td><td><i>JBoss 3.2.x, 4.0.x, 4.2.x</i></td><td></td></tr>
 * <tr><td></td><td><i>Mortbay Jetty 4.x, 5.x, 6.x</i></td><td></td></tr> <tr><td></td><td><i>Oracle Containers for J2EE
 * (OC4J) 9.x, 10.x, 11.x</i></td><td></td></tr> <tr><td></td><td><i>Oracle Application Server 10g 9.x,
 * 10.x</i></td><td></td></tr> <tr><td></td><td><i>Sun Application Server 8.x, 9.x</i></td><td></td></tr> </table>
 */
public interface IscInstall {
}
