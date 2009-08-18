
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
 * intend to use that  component.  </ul> <u>Merging web.xml</u> <p> The following is a description of the servlets and
 * filters you'll find in the web.xml file contained in the smartclientRuntime and what they do: <p> <i>Core
 * Functionality</i> <ul> <li>Init servlet- <b>required:</b> initializes the SmartGWT server componentry from config files
 * at container startup time.  Notice that this servlet has no mapping - it's purely an initialization servlet. <li>IDACall
 * servlet - <b>required</b> for {@link com.smartgwt.client..DMI}, built-in RPC operations and built-in DataSource
 * operations to work.  All databound examples in the SDK use this servlet.  If you're planning on using a custom actionURL
 * for all your RPC requests, then you don't need this servlet. <li>FileDownload servlet - required for serving the
 * Isomorphic framework code compressed and with caching headers as well as for serving skin images with caching headers. 
 * It is highly recommended that you use this for production but is not required.  <li>PreCache servlet - loads resources
 * into memory on container startup.  Not required, but if you exclude this servlet there may be a slow response to the
 * very first request. <li>jsp-config section - the iscTaglib registration block is required to use &lt;isomorphic&gt;
 * tags, and the *.isc and *.rpc mappings.  These are optional, if you want to use these as handy development tools. </ul>
 * <p> <i>Optional Functionality</i> <ul> <li>HttpProxy - used by the RPCManager when sending AJAX RPCs to a server other
 * than the server that serves the main application page.  You need to install this servlet if, for example, your
 * application will be querying web services exposed by servers other than the server that is serving the rest of the
 * application.  See the javadoc for this servlet for various configuration options, such as how to restrict the URLs that
 * are allowed to be proxied.  <li>MessagingServlet - used by the realtime messaging system.  If you're planning on using
 * this subsystem, you'll need this servlet. <li>CompressionFilter - required if you want to use dynamic compression of
 * html and js files. <li>JSSyntaxScannerFilter - development tool that looks for trailing commas in JS source (scans html
 * files for &lt;script&gt; tags and scans .js files in their entirety). This is a useful development tool, but should not
 * be included in production. <li>NoCacheFilter - development tool that makes any content it intercepts non-cacheable in
 * order to ensure developers are looking at the latest version of a file when modifying examples.  Not for production use.
 * <li>DataSourceLoader - a servlet that returns the definition of one or more DataSources in JavaScript notation.  This
 * servlet is provided as an alternative to using the  <code>&lt;isomorphic:loadDS&gt;</code> JSP tag, and is particularly
 * suitable in environments where JSP tags can't be used for some reason (such as with SmartGWT).  See  {@link
 * com.smartgwt.client.docs.DataSourceDeclaration 'Creating DataSources'} for more details. </ul> Note that not all of the
 * servlets and filters listed under <i>Optional Functionality</i> above are present in the web.xml that ships with the
 * smartclientRuntime - if you need to use any of these, copy their configuration from the web.xml available under the
 * WEB-INF directory of smartclientSDK.  Other servlets, filters and configuration files from the smartclientSDK should not
 * be copied to your deployment, simply because the SDK includes many developer tools that are not extensively audited from
 * a security standpoint. <p> <u><b>Troubleshooting</b></u> <p> This section covers some common problems with possible
 * solutions. You may also need to refer to the documentation for your specific application server, web server, or
 * database. If you experience any problems installing and configuring SmartGWT in your environment, please post on the  <a
 * href="http://forums.smartclient.com/" target='_blank'>SmartGWT forums</a> for assistance. <p> <table width="90%"
 * class="normal" align="center" border="1" cellpadding="5"> <tr bgcolor="#808080">  <td width="30%"><b>Problem</b></td> 
 * <td width="30%"><b>Possible Causes</b></td>  <td width="40%"><b>Solution</b></td> </tr><tr>  <td rowspan='3'>Browser
 * displays a generic "page cannot be displayed" or "unable to locate the server" message.</td>  <td>Servlet engine not
 * started.</td>  <td>Start your application server.</td> </tr><tr>  <td>Missing/incorrect port for servlet engine in
 * URL.</td>  <td>Check the startup messages, logs, or documentation for the servlet engine to determine what port it is
 * using.</td> </tr><tr>  <td>Host name is incorrect.</td>  <td>Check whether other pages on the host can be accessed.  
 * Try the base URL http://[host name]:[port number] to see whether the servlet engine or webserver is functioning.</td>
 * </tr><tr>  <td>Browser displays a 404 or other page/file not found error.</td>  <td>Incorrect URL.</td>  <td>Check for
 * errors in the URL, including capitalization.</td> </tr><tr>  <td>Server error: taglib not defined</td>  <td>Missing
 * iscTaglib.xml or iscTaglib.xml not referenced in web.xml</td>  <td>Copy WEB-INF/iscTaglib.xml from smartclientRuntime to
 * your deployment WEB-INF directory  and make sure that you have merged the &lt;jsp-config&gt; section from the 
 * smartclientRuntime web.xml</td> </tr><tr>  <td>ClassNotFound or other Java Exceptions in the server log.</td> 
 * <td>Missing JAR files</td>  <td>Verify every .jar from the smartclientRuntime WEB-INF/lib directory has been copied to 
 * your deployment WEB-INF/lib.  Although you might later be able to remove some .jars, for  initial installation testing,
 * copy every .jar</td> </tr><tr>  <td>"isc" is not defined JS error</td>  <td>Incorreect URLs to SmartGWT modules</td> 
 * <td>Use View Source to look at SCRIPT includes (e.g. for ISC_Core.js), try those URLs  directly in the browser to verify
 * the files are correctly deployed</td> </tr> </table> <P> <u><b>Java Module Dependencies</b></u> <p> The following is a
 * description of what functionality is contained in each SmartGWT JAR file, and which other SmartGWT JARs and third party
 * libraries are required to enable that functionality.  Note that actual filenames in WEB-INF/lib will typically contain
 * the version number of the library, whereas the library names below simply list the base name. <ul>
 * <li><b>isomorphic_core_rpc</b>: This is the core SmartGWT module.  It provides the RPC, DMI, and DataSource support.<br>
 * &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-cli<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-lang<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-collections<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-pool<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-codec<br> &nbsp;&nbsp;&nbsp;&nbsp;isc-jakarta-oro<br> &nbsp;&nbsp;&nbsp;&nbsp;log4j<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-jxpath<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-httpclient<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;velocity<br> &nbsp;&nbsp;<u>Optionally Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;xercesImpl - if
 * you're using JDK &lt; 1.5<br> &nbsp;&nbsp;&nbsp;&nbsp;xml-apis - if you're using JDK &lt; 1.5<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-fileupload - if you plan to use the upload form item with SmartGWT processing.<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;mail - if you plan to use the Mail messaging feature<br> &nbsp;&nbsp;&nbsp;&nbsp;activation - if
 * you plan to use the Mail messaging feature and you are using a JDK &lt; 1.6<br> </li>
 * <li><b>isomorphic_web_services</b>: Web services examples only.  Contains code backing the SmartGWTOperations.wsdl
 * example.  Do not deploy in production.<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> &nbsp;&nbsp;&nbsp;&nbsp;axis<br> &nbsp;&nbsp;&nbsp;&nbsp;axis-schema<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-discovery<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;jaxrpc<br> &nbsp;&nbsp;&nbsp;&nbsp;saaj<br> &nbsp;&nbsp;&nbsp;&nbsp;wsdl4j<br> </li>
 * <li><b>isomorphic_tools</b>: Contains back-end logic for the "Admin Console" tool visible in the Developer Console, and
 * also standalone from the SDK home page.  This is an SDK-only tool, not intended for production deployment, and further
 * intended for rapid prototyping only.  Do not deploy this module to production, but you may use it in your development if
 * you're using the SmartGWT rapid prototyping SQL engine.<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_sql<br> </li>
 * <li><b>isomorphic_embedded_tomcat</b>: This contains the bootstrap class for the Embedded Tomcat engine shipped with the
 * SmartGWT SDK.  It is not intended to be used in any way other than via the start_embedded_tomcat.bat|sh|command scripts
 * in the webRoot of the SDK.<br> &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;All JARs under WEB-INF/embeddedTomcat/lib<br> </li> <li><b>isomorphic_struts</b>: Contains the
 * ValidationAction and ValidationFailureAction classes that implement RPC-based validation of DynamicForms using the
 * Struts ValidatorPlugIn.  If you're not using Struts or if you don't need this particular feature of SmartGWT, you do not
 * need this module or its dependencies.  An example of this style of validation is available here: <a
 * href='/examples/struts/forms/welcome.do' onclick="window.open('/examples/struts/forms/welcome.do');return
 * false;">/examples/struts/forms/welcome.do</a> - read the info on this page, and follow the "Dynamic Form (With RPC-based
 * Validation)" Link for the actual example.<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> &nbsp;&nbsp;&nbsp;&nbsp;struts<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-digester<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-beanutils<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-fileupload<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-validator<br> &nbsp;&nbsp;&nbsp;&nbsp;jakarta-oro<br> </li>
 * <li><b>isomorphic_spring</b>: Required for {@link com.smartgwt.client..DMI} dispatches to Spring beans (via {@link
 * com.smartgwt.client.docs.serverds.ServerObject#getLookupStyle lookupStyle} : "spring").<br>
 * &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> &nbsp;&nbsp;&nbsp;&nbsp;spring<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br> </li> <li><b>isomorphic_examples</b>: Contains code for various SmartGWT
 * examples shown in the SDK.  Do not deploy to production.  The source code for the compiled classes in this module are
 * present in the SDK in various locations and typically linked to directly from the examples that use them.<br>
 * &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_sql<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_struts<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_spring<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_hibernate<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br> &nbsp;&nbsp;&nbsp;&nbsp;jstl<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;jakarta-taglib-standard<br> </li> <li><b>isomorphic_realtime_messaging</b>: Server support
 * required for the SmartGWT Realtime Messaging Module.  Install this if you're using this 'push' technology.  For more
 * information, see: ${isc.DocUtils.linkForDocNode('Messaging QuickRef')}:<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> </li> <li><b>isomorphic_hibernate</b>: Contains support for Hibernate
 * DataSources as described here: {@link com.smartgwt.client.docs.HibernateIntegration}.<br>
 * &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_sql<br>  &nbsp;&nbsp;&nbsp;&nbsp;hibernate3<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br> &nbsp;&nbsp;&nbsp;&nbsp;dom4j<br> &nbsp;&nbsp;&nbsp;&nbsp;jdbc2_0-stdext<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;asm<br> &nbsp;&nbsp;&nbsp;&nbsp;asm-attrs<br> &nbsp;&nbsp;&nbsp;&nbsp;jta<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;cglib<br> &nbsp;&nbsp;&nbsp;&nbsp;antlr<br> &nbsp;&nbsp;<u>Optionally Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;hsqldb - not required for linking, but needed for Hibernate to actually connect to databases of
 * this type, and hsqldb is what's used in the SDK examples. Note that for production use you will need a JDBC driver for
 * your database type.<br> </li> <li><b>isomorphic_sql</b>: The SmartGWT SQLDataSource.<br>
 * &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-dbcp<br>  &nbsp;&nbsp;&nbsp;&nbsp;hsqldb<br>  </li> <li><b>isomorphic_js_parser</b>: A
 * parser capable of reading a JSON byte stream and creating an in-memory Java object structure to match.  Used by any
 * mechanism that relies on JSON-style configuration.  Examples include FileAssembly definitions in JSON format, any use of
 * the rulesFile with a URIRegexFilter (Java Servlet) or subclass.  Generally not required.<br>
 * &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>  </li>
 * <li><b>isomorphic_compression</b>: This is a part of the Network Performance Module.  The isomorphic_compression module
 * is required for dynamic and static compression of various assets delivered to the browser.  For more information, see: 
 * {@link com.smartgwt.client.docs.Compression}.<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>  </li> <li><b>isomorphic_assembly</b>: This is part of the Network
 * Performance Module.  The isomorphic_assembly module is required for file assembly and stripping.  For more information,
 * see: {@link com.smartgwt.client.docs.FileAssembly}.<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>  &nbsp;&nbsp;<u>Optionally Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_obfuscation - for code obfuscation<br>  </li> <li><b>isomorphic_obfuscation</b>: This
 * is part of the Network Performance Module.  The isomorphic_obfuscation module is required to enable obfuscation of code
 * assembled by the File Assembly system.  For more information, see:  {@link com.smartgwt.client.docs.Compression}.<br>
 * &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>  </li> </ul> <p> <u><b>Caching
 * Considerations</b></u> <p> When upgrading from one SmartGWT release to the next, you want to make sure that the user
 * picks up the new version on next access, but you also want to keep the ISC modules cacheable so they're not refetched on
 * every access. <p> SmartGWT deals with this problem by appending a version string as a query parameter to each module
 * load directive.  This is done by the &lt;isomorphic:loadISC&gt; and &lt;isomorphic:loadModules&gt; tags automatically. 
 * As long as you make sure that the file that contains these tags is non-cacheable, you will get the desired behavior. <p>
 * <u><b>Supported J2SE Containers</b></u> <p> Below is the list of J2SE containters that have been tested to be compatible
 * with this version of SmartGWT.  Installation in these containers is supported for deployment by Isomorphic.  If your
 * application server is not on this list, please contact us at the <a href="http://forums.smartclient.com"
 * target='_blank'>SmartGWT forums</a> to see if we can support your deployment.  In general, the Java portion of ISC
 * should work on servlet containers that comply with servlet specification version 2.3 and up and utilize a JVM no older
 * than version 1.4. <p> Supported J2SE Containers: <p> <table class='normal'> <tr><td width=40></td><td
 * width=200><i>Apache Tomcat 4.0.x, 4.1.x, 5.0.x, 5.5x, 6.0.x</i></td><td></td></tr> <tr><td></td><td><i>Apache Geronimo
 * 1.x, 2.x</i></td><td></td></tr> <tr><td></td><td><i>BEA WebLogic 6.x, 7x, 8.x, 9.x, 10.x</i></td><td></td></tr>
 * <tr><td></td><td><i>Caucho Resin 2.1.x, 3.0.x, 3.1.x</i></td><td></td></tr> <tr><td></td><td><i>IBM WebSphere 5.x,
 * 6.x</i></td><td></td></tr> <tr><td></td><td><i>IBM WebSphere Community Edition 1.x</i></td><td></td></tr>
 * <tr><td></td><td><i>JBoss 3.2.x, 4.0.x, 4.2.x</i></td><td></td></tr> <tr><td></td><td><i>Mortbay Jetty 4.x, 5.x,
 * 6.x</i></td><td></td></tr> <tr><td></td><td><i>Oracle Containers for J2EE (OC4J) 9.x, 10.x, 11.x</i></td><td></td></tr>
 * <tr><td></td><td><i>Oracle Application Server 10g 9.x, 10.x</i></td><td></td></tr> <tr><td></td><td><i>Sun Application
 * Server 8.x, 9.x</i></td><td></td></tr> </table>
 */
public interface IscInstall {
}
