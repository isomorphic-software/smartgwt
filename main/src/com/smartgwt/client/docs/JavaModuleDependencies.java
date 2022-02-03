
package com.smartgwt.client.docs;

/**
 * <h3>Java Module Dependencies</h3>
 * {@link com.smartgwt.client.docs.MavenSupport Maven} users should generally refer to the POMs
 * bundled with the  SDK, and installed for them by the official  <a
 * href='http://github.smartclient.com/isc-maven-plugin/' target='_blank'>Isomorphic plugin for
 * Maven</a>.  For others,  the following is a short description of the functionality contained in
 * each  Smart GWT server JAR, and a link to the documentation listing its dependencies.  Please 
 * refer to that documentation for more detail on the dependency graph, including version 
 * numbers, transitive dependencies, and licensing. <P> Note that if you are using GWT, GWT itself
 * also has an Apache 2.0 license, however tools and test environments that you may use during
 * development have different license (such as Eclipse - Eclipse Public License).  Also, specific
 * GWT widgets, not required by Smart GWT,  have licenses different from core GWT (such as
 * JFreeChart's LGPL license).  See  <a href='http://code.google.com/webtoolkit/terms.html'
 * target='_blank'>Google's summary of terms</a> for details.  <style>   .jmd-module  {     width:
 * 140px;     text-align: right;     vertical-align: top;     padding-right: 10px;   }  
 * .jmd-optional  {     text-decoration: underline;     margin-top: 10px; margin-bottom: 8px;   }
 * </style>  <table width="100%" >   <tr>     <td class="jmd-module">       <a target="_blank"
 * href="./mavendoc/isomorphic-core-rpc.html">isomorphic_core_rpc</a>     </td>     <td>          
 * This is the core Smart GWT module.  It provides the RPC, DMI, and DataSource       support.
 * Please note that both commons-collections-3.x and commons-collections4-4.x        are required
 * and safe to include side by side in the CLASSPATH (different third party        libs rely on
 * one or the other).  The same is true of commons-lang and commons-lang3.       <div
 * class="jmd-optional">         Optional Dependencies       </div>       <ul>        
 * <li><i>freemarker</i>              - if you're using the built-in support for REST via the     
 * {@link com.smartgwt.client.docs.ServletDetails RESTHandler servlet} servlet        
 * <li><i>isomorphic_js_parser</i>               - if you're using the built-in support for REST
 * via the                 {@link com.smartgwt.client.docs.ServletDetails RESTHandler servlet}
 * servlet with JSON payloads         <li><i>xercesImpl</i>               - if you're using JDK
 * &lt; 1.5         <li><i>mail</i>               - if you plan to use the Mail messaging feature 
 * <li><i>javax.persistence</i>               - if you plan to use the metadata-from-annotations
 * feature.  Note that if you                 are using JPA, or a recent version of Hibernate,
 * then you are probably                 already using this library.         <li><i>poi and
 * commons-math</i>               - if you plan to export datasets in Microsoft Excel 97 (xls) or
 * 2007 (xlsx)                 formats.           <li><i>poi-ooxml, poi-ooxml-schemas, and
 * commons-compress</i>              - also needed if you plan to export data in Excel 2007 (xlsx)
 * format         <li><i>isomorphic_contentexport</i>               - if you plan to export to PDF
 * format         <li><i>isomorphic_jpa</i>               - if you plan to use BatchDS Generator
 * (even if you are not using JPA,                 although the generated DataSources will not
 * require JPA at runtime if you                 are not using JPA).         <li><i>log4j</i>     
 * - if you plan to use log4j logging (used by default)         <li><i>slf4j-log4j12</i>          
 * - if you plan to use slf4j with log4j (for example), or any other slf4j bridge                
 * library depending on which logging framework will be used.  See                 {@link
 * com.smartgwt.client.docs.ServerLogging} for information on server-side logging and how to      
 * configure it.         <li><i>groovy</i>               - if you plan to use Groovy with the
 * {@link com.smartgwt.client.docs.ServerScript} feature.                  Note, we also recommend
 * that you use Groovy as the evaluation engine if you                 intend to use Java as an
 * inline scripting language.                  See the "Server Scripting" documentation.        
 * <li><i>commons-digester and commons-beanutils</i>               - if you plan to use Velocity
 * Tools.        </ul>      </td>   </tr>     <tr>     <td class="jmd-module"><a target="_blank"  
 * href="./mavendoc/isomorphic-contentexport.html">isomorphic_contentexport</a>     </td>     <td>
 * Provides support for PDF Export.       <div class="jmd-optional">       Optional Dependencies  
 * </div>       <ul>       <li><i>batik-anim, batik-awt-util, batik-bridge, batik-css, batik-dom,
 * batik-ext,               batik-gvt, batik-parser, batik-script, batik-svg-dom, batik-util,
 * batik-xml           </i> -           <p/>           These are all required to use {@link
 * com.smartgwt.client.rpc.RPCManager#exportImage RPCManager.exportImage()}, or when using        
 * {@link com.smartgwt.client.rpc.RPCManager#exportContent RPCManager.exportContent()} to export a
 * DrawPane or FacetChart only            in IE8 or earlier, or if a DrawPane has a DrawImage
 * which loads a cross-domain            image.           <p/>           <b>NOTE:</b>           
 * Between iText 2.0.x and iText 2.1.x there is a binary (but not source)           
 * incompatibility that causes a server-side <code>NoSuchMethodError</code>            when
 * exporting, e.g., charts in Internet Explorer. This is a        <a
 * href='http://code.google.com/p/flying-saucer/issues/detail?id=126' target='_blank'>known
 * issue</a>            with the Flying Saucer product that is fixed by using           
 * core-renderer-R8-isomorphic.jar and iText-2.1.7.jar in the lib-iTextAlternate/           
 * directory instead of core-renderer.jar and iText-2.0.8.jar in the lib/ directory.            
 * To use iText 2.1.7 with the Server Framework, exclude lib/core-renderer.jar and           
 * lib/iText-2.0.x.jar from the application's classpath and instead add           
 * lib-iTextAlternate/core-renderer-R8-isomorphic.jar and           
 * lib-iTextAlternate/iText-2.1.7.jar.       </ul>     </td> </tr> <tr>   <td class="jmd-module"> 
 * <a target="_blank" href="./mavendoc/isomorphic-tools.html">isomorphic_tools</a>   </td>   <td> 
 * Contains back-end logic for the "Admin Console" tool visible in the Developer Console,      and
 * also standalone from the SDK home page.  Also contains the various data importers      and
 * exporters, and the server-side components of the BatchUploader.   </td> </tr> <tr>   <td
 * class="jmd-module">     <a target="_blank"
 * href="./mavendoc/isomorphic-cdi.html">isomorphic_cdi</a>   </td>   <td>     Support for {@link
 * com.smartgwt.client.docs.DmiOverview DMI} dispatches to Spring beans      (via {@link
 * com.smartgwt.client.docs.serverds.ServerObject#lookupStyle ServerObject.lookupStyle} : "cdi"). 
 * </td> </tr> <tr>   <td class="jmd-module">     <a target="_blank"
 * href="./mavendoc/isomorphic-spring.html">isomorphic_spring</a>   </td>   <td>     Support for
 * {@link com.smartgwt.client.docs.DmiOverview DMI} dispatches to Spring beans      (via {@link
 * com.smartgwt.client.docs.serverds.ServerObject#lookupStyle ServerObject.lookupStyle} :
 * "spring").   </td> </tr> <tr>   <td class="jmd-module"><a target="_blank"
 * href="./mavendoc/isomorphic-messaging.html">     isomorphic_realtime_messaging</a>   </td>  
 * <td>     Server support required for the Smart GWT Realtime Messaging Module.  Install this    
 * if you're using this 'push' technology.  For more information, see      {@link
 * com.smartgwt.client.docs.Messaging Messaging}.   </td> </tr> <tr>   <td class="jmd-module">    
 * <a target="_blank" href="./mavendoc/isomorphic-hibernate.html">isomorphic_hibernate</a>   </td>
 * <td>     Contains support for Hibernate DataSources as described here:      {@link
 * com.smartgwt.client.docs.HibernateIntegration}.   </td> </tr> <tr>   <td class="jmd-module">   
 * <a target="_blank" href="./mavendoc/isomorphic-jpa.html">isomorphic_jpa</a>   </td>   <td>    
 * Contains support for JPA DataSources as described {@link
 * com.smartgwt.client.docs.JpaIntegration here}   </td> </tr> <tr>   <td class="jmd-module">    
 * <a target="_blank" href="./mavendoc/isomorphic-sql.html">isomorphic_sql</a></td>   <td>     The
 * Smart GWT SQLDataSource.   </td> </tr> <tr>   <td class="jmd-module">     <a target="_blank"
 * href="./mavendoc/isomorphic-autotest.html">isomorphic_autotest</a>   </td>   <td>     Support
 * for {@link com.smartgwt.client.docs.AutomatedTesting automated testing and Continuous
 * Integration}     <div class="jmd-optional">     Optional Dependencies     </div>     <ul>      
 * <li><i>jna</i> - if testing with IE on Windows environments       <li><i>servlet-api</i> -
 * needed only if you intend to run TestRunner from a standalone            process (ie, from a
 * normal Java program, not a webapp).              <p/>            However, it should <u>not</u>
 * be deployed to a servlet container such as Tomcat             or Jetty.  The best case is that
 * the file will be unused and a source of             confusion for anybody looking at the
 * webapp's library usage; the worst case is             that it will conflict with the
 * container's own implementation of the Servlet API.     </ul>   </td> </tr> <tr>   <td
 * class="jmd-module">     <a target="_blank"
 * href="./mavendoc/isomorphic-js-parser.html">isomorphic_js_parser</a>   </td>   <td>     A
 * parser capable of reading a JSON byte stream and creating an in-memory Java object     
 * structure to match.  Used by any mechanism that relies on JSON-style configuration.      
 * Examples include FileAssembly definitions in JSON format, any use of the rulesFile with      a
 * URIRegexFilter (Java Servlet) or subclass.     </td> </tr> <tr>   <td class="jmd-module"><a
 * target="_blank" href="./mavendoc/isomorphic-compression.html">     isomorphic_compression</a>  
 * </td>   <td>     This is a part of the Network Performance Module.  The isomorphic_compression
 * module is      required for dynamic and static compression of various assets delivered to the
 * browser.       For more information, see: {@link com.smartgwt.client.docs.Compression}.   </td>
 * </tr> <tr>   <td class="jmd-module"><a target="_blank"
 * href="./mavendoc/isomorphic-assembly.html">     isomorphic_assembly</a>   </td>   <td>     This
 * is part of the Network Performance Module.  The isomorphic_assembly module is      required for
 * file assembly and stripping.  For more information, see:      {@link
 * com.smartgwt.client.docs.FileAssembly}.   </td> </tr> <tr>   <td class="jmd-module"><a
 * target="_blank" href="./mavendoc/isomorphic-scheduler.html">     isomorphic_scheduler</a>  
 * </td>   <td>     Server-side libraries providing {@link com.smartgwt.client.docs.QuartzAdapters
 * DataSource adapters} for the     <a href='http://www.quartz-scheduler.org'
 * target='_blank'>Quartz</a> API.   </td> </tr> <tr>   <td class="jmd-module"><a target="_blank"
 * href="./mavendoc/isomorphic-m2pluginextras.html">     isomorphic_m2pluginextras</a>   </td>  
 * <td>     A small collection of tools / utilities for use by Maven builds, Ant Scripts, and     
 * command line invocation.   </td> </tr> </table>
     * @see com.smartgwt.client.docs.Spring4limits
 */
public interface JavaModuleDependencies {
}
