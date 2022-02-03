
package com.smartgwt.client.docs;

/**
 * <h3>Manual Setup & Deployment of Smart GWT Pro/EE</h3>
 * Isomorphic recommends starting most new projects from one of the provided templates, and in any
 * case using some form of
 * dependency management as covered in documentation for the {@link
 * com.smartgwt.client.docs.SgwtEESetup standard setup}.  For those unable or
 * unwilling to do so, however, this overview serves as a how-to for adding Smart GWT to your
 * project manually.
 * 
 *  <h3>Creating a new project from scratch</h3>
 *  <P>
 *  If you are starting a new project from scratch, we recommend starting with one of the sample
 *  projects included with SmartGWT EE under the "samples" directory.  Use the project that most
 *  closely matches your integration strategy and follow the instructions in the "readme" file
 *  within the sample directory.  If you have a choice, most projects will benefit from the use
 *  of SQLDataSources, illustrated in the BuiltInDS sample.
 *  <P>
 *  <h3>Adding SmartGWT EE to an existing project</h3>
 *  <P>
 * <B>Important:</b> If you have created a project using the GWT Plugin for Eclipse, a Maven
 * archetype, or
 *  similar tool, first get rid of unused resources typically included in such "starter projects":
 *  <ul>
 *    <li> from your [i]moduleName[/i].gwt.xml file, remove imports of any GWT themes, leaving
 *         only the import of com.google.gwt.user.User.  Proper imports to add for SmartGWT
 *         Pro/EE are shown below.
 *    <li> get rid of any sample servlets or GWT-RPC services (delete both web.xml entries and
 *         server-side source)
 *  </ul>
 *  <P>
 *  Now add SmartGWT EE: all of these steps are required.  <b>Do not skip steps or omit
 *  resources you think you may not need</b>.  Get a working project first, then think about
 *  trimming resources, as needed, once you understand the system.
 *  <P>
 *  In the steps below, copying from eg "war/WEB-INF/..." means copying from the "war"
 *  subdirectory of whichever sample project is closest to your desired integration strategy.
 *  <P>
 *  <ol>
 *  <li>Unless you're <a href="http://github.smartclient.com/isc-maven-plugin/">using Maven</a>
 *      to manage dependencies, you'll need to add all jars from the SmartGWT Pro/EE
 *      distribution (under smartgwtee-<i>version</i>/lib)
 *      to your CLASSPATH.  You can copy the '.classpath' file from the appropriate sample
 *      project for a working set of includes (it's in the same directory as the <i>war/</i>
 *      folder). There are both client- and server-side jars, both kinds go in the classpath.
 * For server-side .jars, dependencies are documented {@link
 * com.smartgwt.client.docs.JavaModuleDependencies here}.
 *  <li>update your <i>modulename</i>.gwt.xml file with these imports:
 *     <pre>
 *     &lt;inherits name="com.smartgwtee.SmartGwtEE"/&gt;
 *     &lt;inherits name="com.smartgwtee.tools.Tools"/&gt;
 *     </pre>
 *     <b>NOTE:</b> if you were previously using SmartGWT LGPL, <b>remove</b> the
 *     &lt;inherit&gt; of 'com.smartgwt.SmartGWT' and ensure the &lt;inherit&gt; of
 *     'com.smartgwt.tools.SmartGwtTools' appears <b>before</b> the imports above.  Also ensure
 *     that all SmartGWT-related inherits appear *before* your &lt;entry-point&gt; declaration.
 *  <li> if you are using Optional Modules such as Analytics or RealtimeMessaging, see
 *       {@link com.smartgwt.client.docs.LoadingOptionalModules} for additional inherits
 *  <li> Copy log4j.isc.config.xml across to the "src" dir of your project (it's
 *       placed in the "src" dir as a means of getting it into the CLASSPATH).  This file is
 *       either in the "src/" dir of a given sample project or in war/WEB-INF/classes.  This
 *       enables default log4 categories for server-side logs appropriate for development.
 * See {@link com.smartgwt.client.docs.ServerLogging} for information on server-side logging and
 * how to configure it.
 * <li> Copy {@link com.smartgwt.client.docs.Server_properties server.properties} across to the
 * "src" dir of your project.
 *      This file is either in the "src/" dir of a given sample project or in war/WEB-INF/classes.
 *       This contains miscellaneous server settings - see the file itself for documentation.
 *     <ul>
 *       <li><b>server.properties contains server-side paths that contain the GWT module name</b>.
 *            Replace the module name from the sample project (eg "builtinds") with the module
 *            name of your actual GWT project
 *        <li> if you're using SQLDataSource, enter your JDBC settings (start with a
 *            server.properties from a project that uses a database to see the required format for
 *             settings)
 *     </ul>
 * <li> If you plan to use JPA, copy src/META-INF/persistence.xml into your src/META-INF
 * directory.
 *      This file will be copied into war/WEB-INF/classes/META-INF directory during build process.
 *    Make sure you specify your entity classes in persistence.xml. If you change persistence unit
 *       name you have to update "jpa.persistenceUnitName" property in
 *       {@link com.smartgwt.client.docs.Server_properties server.properties} file. More
 * information on JPA configuration can be found in {@link
 * com.smartgwt.client.docs.JpaIntegration}.
 *  <li> merge web.xml, starting with the web.xml from the sample project that is closest to
 *       your target application (under war/WEB-INF in the sample project).  The list of
 * servlets and what they do is documented {@link com.smartgwt.client.docs.ServletDetails here}. 
 * See the
 *       server-side JavaDoc for further details on servlet APIs and override points.
 *  <li> (SmartGWT Power or Enterprise only) If using the BatchUpload functionality, copy
 *       war/ds/batchUpload.ds.xml from the Showcase sample project to the shared.datasources
 * directory you configured in {@link com.smartgwt.client.docs.Server_properties
 * server.properties}.
 *  </ol>
 *  <h4>Extra Step Required for GWT 2.8+</h4>
 *  If you're using GWT 2.8 or later, attempting to run SuperDevMode in Eclipse may lead to an
 *  exception being reported such as:<p><pre>
 *      org.apache.xerces.parsers.XIncludeAwareParserConfiguration cannot be cast to
 *          org.apache.xerces.xni.parser.XMLParserConfiguration</code></pre><p>
 *  This is due to xerces classes being included in GWT 2.8+, in addition to being in the JRE.
 *  To solve, add the following extra VM arguments to either your launch configuration or JRE in
 *  Eclipse:
 *  <p><pre>
 *      -Djavax.xml.parsers.SAXParserFactory=com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl
 *      -Djavax.xml.parsers.DocumentBuilderFactory=com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl
 *  </pre><p>
 *  <u><b>Troubleshooting</b></u>
 *  <table width="90%" class="normal" align="center" border="1" cellpadding="5">
 *  <tr bgcolor="#808080">
 *   <td width="30%"><b>Problem</b></td>
 *   <td width="30%"><b>Possible Causes</b></td>
 *   <td width="40%"><b>Solution</b></td>
 *  </tr><tr>
 *   <td>ClassNotFound or other Java Exceptions in the server log.</td>
 *   <td>Missing JAR files</td>
 * <td>Verify every .jar from the smartgwtee-<i>version</i>/lib directory has been added to your
 * CLASSPATH.
 *   Although you might later be able to remove some .jars, for initial installation testing,
 *   copy every .jar</td>
 *  </tr><tr>
 * <td>Client-side error about attempting to use "iscServer" request without server installed</td>
 *   <td>Wrong imports in <i>moduleName</i>.gwt.xml</td>
 *   <td>See correct imports above, note <b>remove</b> com.smartgwt.SmartGWT import and be sure
 *       imports are in the correct order</td>
 *  </tr><tr>
 *   <td>Client-side error about "$debox is not defined"</td>
 *   <td>Wrong order of imports in <i>moduleName</i>.gwt.xml</td>
 *   <td>Make sure all SmartGWT-related imports appear before &lt;entry-point&gt; in your
 *       .gwt.xml file</td>
 *  </tr><tr>
 *   <td>Missing images or failure to load page</td>
 *   <td>Didn't set isomorphicDir in .html bootstrap file</td>
 *   <td>See step above for setting isomorphicDir</td>
 *  </tr><tr>
 *   <td>Server error: "adminConsole" app not found when launching tools such as Reify</td>
 * <td>Bad filesystem paths configured in {@link com.smartgwt.client.docs.Server_properties
 * server.properties}</td>
 *   <td>Correct paths in {@link com.smartgwt.client.docs.Server_properties server.properties}.  
 *       <b>NOTE</b> the samples include the GWT module
 *       name in some settings, search and replace this value with your GWT module name</td>
 *  </tr><tr>
 *   <td>Server error: Can't find DataSource with ID <i>yourDataSourceID</i></td>
 * <td>Bad filesystem paths in {@link com.smartgwt.client.docs.Server_properties
 * server.properties} or 
 *       bad DataSource .ds.xml file</td>
 * <td>Correct paths in {@link com.smartgwt.client.docs.Server_properties server.properties} -
 * search for 
 *       "project.datasources".  Also check that
 *       the DataSource ID you are using matches the "ID" attribute in the .ds.xml file (NOTE:
 *       ID attribute is uppercase "ID" not "id") and that the file is named
 *       <i>dataSourceId</i>.ds.xml.  DataSource IDs are <b>case sensitive</b>, including the
 *       file name.  For more in-depth troubleshooting steps, see 
 *       +link{http://forums.smartclient.com/showthread.php?t=8159#aDSLoad,this FAQ answer}.</td>
 *  </tr><tr>
 *   <td>Server unable to load builtinTypes.xml as it starts up, possibly hitting a 
 *       NullPointerException</td>
 *   <td>Modules have been added to your GWT project (.gwt.xml) but you haven't run
 *       another GWT compile</td>
 *   <td>GWT compile your project again</td>
 *  </tr>
 *  </table>
 *  <P>
 *  For further troubleshooting steps, see
 * <a href='http://forums.smartclient.com/showthread.php?t=8159' target='_blank'>the SmartGWT
 * FAQ</a> and, if
 *  still stuck, try posting in the Forums. <B>NOTE:</B> gather all the information indicated in
 *  the FAQ before posting.
 *  <p>
 *  <b>NOTE:</b>  It is possible to create a server-only SmartGWT EE project that will run 
 *  standalone (ie, not inside a servlet container or application server).  Please see
 * {@link com.smartgwt.client.docs.StandaloneDataSourceUsage Standalone DataSource Usage} for
 * details.
 */
public interface SgwtEEManualSetup {
}
