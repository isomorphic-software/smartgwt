
package com.smartgwt.client.docs;

/**
 * <h3>Java Module Dependencies</h3>
 * The following is a description of what functionality is contained in each Smart GWT JAR file,
 * and which other Smart GWT JARs and third party libraries are required to enable that
 * functionality.  Note that actual filenames in WEB-INF/lib will typically contain the version
 * number of the library, whereas the library names below simply list the base name. <P> All of
 * the libraries that Smart GWT depends upon have either an Apache 1.0 or Apache 2.0 license, with
 * the following exceptions:<br> 1. Optional Hibernate support requires LGPL-licensed .jars from
 * Hibernate<br> 2. Optional bean annotation support requires an implementation of
 * javax.persistence.jar. This is available from several providers - for example, SpringSource,
 * Hibernate or the  Glassfish project.  The licensing of this library varies by provider.<br> 3.
 * Optional support for Java as a JSR223 server-side scripting language is provided by software
 * developed by Isomorphic, but based on the "java-engine" package, originally  developed by Sun. 
 * See {@link com.smartgwt.client.docs.SunNotice}. <P> If you are using GWT, GWT itself also has
 * an Apache 2.0 license, however tools and test environments that you may use during development
 * have different license (such as Eclipse - Eclipse Public License).  Also, specific GWT widgets,
 * not required by Smart GWT,  have licenses different from core GWT (such as JFreeChart's LGPL
 * license).  See  <a href='http://code.google.com/webtoolkit/terms.html'
 * onclick="window.open('http://code.google.com/webtoolkit/terms.html');return false;">Google's
 * summary of terms</a> for details. <ul> <li><b>isomorphic_core_rpc</b>: This is the core Smart
 * GWT module.  It provides the RPC, DMI, and DataSource support.<br>
 * &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-cli<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-lang<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-collections<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-pool<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-codec<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isc-jakarta-oro<br> &nbsp;&nbsp;&nbsp;&nbsp;log4j<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-jxpath<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-httpclient<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-vfs<br> &nbsp;&nbsp;&nbsp;&nbsp;velocity<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-fileupload<br> &nbsp;&nbsp;<u>Optionally Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;xercesImpl - if you're using JDK &lt; 1.5<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;xml-apis - if you're using JDK &lt; 1.5<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;mail - if you plan to use the Mail messaging feature<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;activation - if you plan to use the Mail messaging feature and you are
 * using a JDK &lt; 1.6<br><br> &nbsp;&nbsp;&nbsp;&nbsp;javax.persistence - if you plan to use the
 * metadata-from-annotations  feature.  Note that if you are using JPA, or a recent version of
 * Hibernate, then you are probably already using this library.<br><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;poi - if you plan to export datasets in Microsoft Excel 97 (xls)   or
 * 2007 (xlsx) formats.  Additionally, if you plan to export data in Excel 2007 (xlsx)  format,
 * you will need the following libraries:<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;poi-ooxml,
 * poi-ooxml-schemas, xbean, jsr173_1.0_api<br><br> &nbsp;&nbsp;&nbsp;&nbsp;PDF Export -
 * Additional .jars are required if PDF Export is to be used. These .jars are:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;core-render, iText-2.0.8, jtidy-r938<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Image Export, IE6-8 DrawPane PDF Export - These libraries are required
 * to use {@link com.smartgwt.client.rpc.RPCManager#exportImage RPCManager.exportImage} or if
 * DrawPanes or FacetCharts are to be exported in IE6-8:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;batik-anim, batik-awt-util, batik-bridge, batik-css,
 * batik-dom, batik-ext, batik-gvt, batik-parser, batik-script, batik-svg-dom, batik-util,
 * batik-xml, xml-apis-ext<br><br> &nbsp;&nbsp;&nbsp;&nbsp;<b>NOTE:</b> Between iText 2.0.x and
 * iText 2.1.x there is a binary (but not source) incompatibility that causes a server-side
 * <code>NoSuchMethodError</code> when exporting, e.g., charts in Internet Explorer. This is a <a
 * href='http://code.google.com/p/flying-saucer/issues/detail?id=126'
 * onclick="window.open('http://code.google.com/p/flying-saucer/issues/detail?id=126');return
 * false;">known issue</a> with the Flying Saucer product that is fixed by using
 * core-renderer-R8-isomorphic.jar and iText-2.1.7.jar in the lib-iTextAlternate/ directory
 * instead of core-renderer.jar and iText-2.0.8.jar in the lib/ directory. To use iText 2.1.7 with
 * the Server Framework, exclude lib/core-renderer.jar and lib/iText-2.0.8.jar from the
 * application's classpath and instead add lib-iTextAlternate/core-renderer-R8-isomorphic.jar and
 * lib-iTextAlternate/iText-2.1.7.jar.<br><br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_jpa and its
 * dependencies - if you plan to use BatchDS Generator even if you are not using JPA, although the
 * generated DataSources will not require JPA at runtime if you are not using JPA. </li> <p>
 * <li><b>isomorphic_contentexport.jar</b>: Optional support for PDF Export requires Flying
 * Saucer, iText and jTidy, introducing:<br> &nbsp;&nbsp;- Flying Saucer: core-render.jar: <a
 * href='http://www.gnu.org/licenses/lgpl-2.1.html'
 * onclick="window.open('http://www.gnu.org/licenses/lgpl-2.1.html');return false;">LGPL
 * license</a><br> &nbsp;&nbsp;- iText: iText-2.0.8.jar: <a href='http://www.mozilla.org/MPL/1.1/'
 * onclick="window.open('http://www.mozilla.org/MPL/1.1/');return false;">Mozilla Public License
 * Version 1.1</a><br> &nbsp;&nbsp;- jTidy: jtidy-r938.jar: <a
 * href='http://jtidy.sourceforge.net/license.html'
 * onclick="window.open('http://jtidy.sourceforge.net/license.html');return false;">MIT
 * license</a><br><br> Additionally, to be able to export images or DrawPanes and FacetCharts in
 * IE6-8, the following libraries are needed:<br> &nbsp;&nbsp;- Batik: batik-anim, batik-awt-util,
 * batik-bridge, batik-css, batik-dom, batik-ext, batik-gvt, batik-parser, batik-script,
 * batik-svg-dom, batik-util, batik-xml: <a
 * href='http://xmlgraphics.apache.org/batik/license.html'
 * onclick="window.open('http://xmlgraphics.apache.org/batik/license.html');return false;">Apache
 * License&#44; Version 2.0</a><br> &nbsp;&nbsp;- xml-commons External Components: xml-apis-ext:
 * <a href='http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231'
 * onclick="window.open('http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231');return
 * false;">W3C Software Notice and License</a> </li> <p> <li><b>isomorphic_web_services</b>: Web
 * services examples only.  Contains code backing the Smart GWTOperations.wsdl example.  Do not
 * deploy in production.<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> &nbsp;&nbsp;&nbsp;&nbsp;axis<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;axis-schema<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-discovery<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br> &nbsp;&nbsp;&nbsp;&nbsp;jaxrpc<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;saaj<br> &nbsp;&nbsp;&nbsp;&nbsp;wsdl4j<br> </li>
 * <li><b>isomorphic_tools</b>: Contains back-end logic for the "Admin Console" tool visible in
 * the Developer Console, and also standalone from the SDK home page.  Also contains the the
 * various data importers and exporters, and the server-side components of the BatchUploader.<br>
 * &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_sql<br> </li> <li><b>isomorphic_embedded_tomcat</b>: This
 * contains the bootstrap class for the Embedded Tomcat engine shipped with the Smart GWT SDK.  It
 * is not intended to be used in any way other than via the start_embedded_tomcat.bat|sh|command
 * scripts in the webRoot of the SDK.<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> &nbsp;&nbsp;&nbsp;&nbsp;All JARs under
 * WEB-INF/embeddedTomcat/lib<br> </li> <li><b>isomorphic_spring</b>: Required for {@link
 * com.smartgwt.client.docs.DmiOverview DMI} dispatches to Spring beans (via {@link
 * com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle} : "spring").<br>
 * &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;spring<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br> </li>
 * <li><b>isomorphic_examples</b>: Contains code for various Smart GWT examples shown in the SDK. 
 * Do not deploy to production.  The source code for the compiled classes in this module are
 * present in the SDK in various locations and typically linked to directly from the examples that
 * use them.<br> &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_sql<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_struts<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_spring<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_hibernate<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br> &nbsp;&nbsp;&nbsp;&nbsp;jstl<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;jakarta-taglib-standard<br> </li>
 * <li><b>isomorphic_realtime_messaging</b>: Server support required for the Smart GWT Realtime
 * Messaging Module.  Install this if you're using this 'push' technology.  For more information,
 * see: ${isc.DocUtils.linkForDocNode('Messaging QuickRef')}:<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> </li> <li><b>isomorphic_hibernate</b>: Contains
 * support for Hibernate DataSources as described here: {@link
 * com.smartgwt.client.docs.HibernateIntegration}.<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_sql<br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;hibernate3<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;dom4j<br> &nbsp;&nbsp;&nbsp;&nbsp;jdbc2_0-stdext<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;asm<br> &nbsp;&nbsp;&nbsp;&nbsp;asm-attrs<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;jta<br> &nbsp;&nbsp;&nbsp;&nbsp;cglib<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;antlr<br> &nbsp;&nbsp;<u>Optionally Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;hsqldb - not required for linking, but needed for Hibernate to actually
 * connect to databases of this type, and hsqldb is what's used in the SDK examples. Note that for
 * production use you will need a JDBC driver for your database type.<br> </li>
 * <li><b>isomorphic_jpa</b>: Contains support for JPA DataSources as described {@link
 * com.smartgwt.client.docs.JpaIntegration here}.<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> &nbsp;&nbsp;&nbsp;&nbsp;Hibernate and its
 * dependencies or any other JPA persistence provider<br> </li> <li><b>isomorphic_sql</b>: The
 * Smart GWT SQLDataSource.<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>  &nbsp;&nbsp;&nbsp;&nbsp;commons-dbcp<br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;hsqldb<br>  </li> </li> <li><b>isomorphic_autotest</b>: Support for 
 * {@link com.smartgwt.client.docs.AutomatedTesting automated testing and Continuous
 * Integration}<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>  &nbsp;&nbsp;&nbsp;&nbsp;selenium-server<br>
 * &nbsp;&nbsp;<em>The <code>selenium-server.jar</code> file provided with Smart GWT is a  trimmed
 * version that does not include all of the libraries used by Selenium itself. Therefore the
 * following libraries are also needed:</em><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;backport-util-concurrent<br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-configuration<br>  &nbsp;&nbsp;&nbsp;&nbsp;commons-exec<br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-io<br>  &nbsp;&nbsp;&nbsp;&nbsp;guava<br> 
 * &nbsp;&nbsp;<em><u>NOTE:</u> <code>servlet-api.jar</code> is also required if you intend to run
 * Selenium RC from a standalone process (ie, from a normal Java program, not a webapp).  
 * However, it should <u>not</u> be deployed to a servlet container such as Tomcat or Jetty. The
 * best case is that the file will be unused and a source of confusion for anybody looking at the
 * webapp's library usage; the worst case is that it will conflict with the container's  own
 * implementation of the Servlets API.</em> </li> <li><b>isomorphic_js_parser</b>: A parser
 * capable of reading a JSON byte stream and creating an in-memory Java object structure to match.
 * Used by any mechanism that relies on JSON-style configuration.  Examples include FileAssembly
 * definitions in JSON format, any use of the rulesFile with a URIRegexFilter (Java Servlet) or
 * subclass.  Generally not required.<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>  </li> <li><b>isomorphic_compression</b>: This
 * is a part of the Network Performance Module.  The isomorphic_compression module is required for
 * dynamic and static compression of various assets delivered to the browser.  For more
 * information, see:  {@link com.smartgwt.client.docs.Compression}.<br>
 * &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>  </li>
 * <li><b>isomorphic_assembly</b>: This is part of the Network Performance Module.  The
 * isomorphic_assembly module is required for file assembly and stripping.  For more information,
 * see: {@link com.smartgwt.client.docs.FileAssembly}.<br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>  &nbsp;&nbsp;<u>Optionally Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_obfuscation - for code obfuscation<br>  </li>
 * <li><b>isomorphic_obfuscation</b>: This is part of the Network Performance Module.  The
 * isomorphic_obfuscation module is required to enable obfuscation of code assembled by the File
 * Assembly system.  For more information, see:  {@link com.smartgwt.client.docs.Compression}.<br>
 * &nbsp;&nbsp;<u>Requires</u>:<br> &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>  </li>
 * <li><b>isomorphic_struts</b>: Contains the ValidationAction and ValidationFailureAction classes
 * that implement RPC-based validation of DynamicForms using the Struts ValidatorPlugIn.  If
 * you're not using Struts or if you don't need this particular feature of Smart GWT, you do not
 * need this module or its dependencies (also see the important note  below).  An example of this
 * style of validation is available here:  <a href='/examples/struts/forms/welcome.do'
 * onclick="window.open('/examples/struts/forms/welcome.do');return
 * false;">/examples/struts/forms/welcome.do</a> - read the info on this page, and follow  the
 * "Dynamic Form (With RPC-based Validation)" Link for the actual example.<br><br> <b>NOTE:</b>
 * This support is for Struts 1.0 only, and is only intended to be used in certain edge cases of
 * incremental migration to Smart GWT.  You should only use it if directed to  do so by Isomorphic
 * Support.<br><br> &nbsp;&nbsp;<u>Requires</u>:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> &nbsp;&nbsp;&nbsp;&nbsp;struts<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-digester<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-beanutils<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-fileupload<br> &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;commons-validator<br> &nbsp;&nbsp;&nbsp;&nbsp;jakarta-oro<br> </li>
 * </ul>
 */
public interface JavaModuleDependencies {
}
