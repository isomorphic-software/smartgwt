
package com.smartgwt.client.docs;

/**
 * <h3>Loading Optional Modules</h3>
 * 
 *  
 *  <P>
 * <i>See the <a href='https://www.smartclient.com/product/' target='_blank'>SmartGWT product
 * page</a> 
 * for an overview of which optional modules are available with the various editions of
 * SmartGWT.</i>
 *  <p>
 *  If your Smart GWT install includes an optional module, it must be added as an &lt;inherits&gt;
 *  tag in your <i>moduleName</i>.gwt.xml module file for it to be used. Some optional modules 
 *  require an additional .jar file (eg analytics.jar), whereas some are bundled in smartgwt.jar
 *  automatically. Where applicable, additional module .jar files are included in
 * Evaluation SDKs but are separate downloads when using an Optional Module with Power or
 * Enterprise.
 *  <P>
 *  <b>Optional modules and Maven</b><br>
 * Developers using {@link com.smartgwt.client.docs.MavenSupport Maven} may add resources for
 * optional modules
 *  via <code>includeAnalytics</code>, <code>includeMessaging</code> arguments when 
 * <a href='http://github.smartclient.com/isc-maven-plugin/install-mojo.html'
 * target='_blank'>installing modules to the maven repository</a>.
 *  You can then configure configure your project POM to use the new dependency, for example:
 *  <pre>
 *     ....
 *     &lt;!-- The SmartGWT core --&gt;
 *     &lt;dependency&gt;
 *         &lt;groupId&gt;com.isomorphic.smartgwt.enterprise&lt;/groupId&gt;
 *         &lt;artifactId&gt;smartgwt-enterprise&lt;/artifactId&gt;
 *         &lt;version&gt;&#36;{smartgwt.version}&lt;/version&gt;
 *     &lt;/dependency&gt;
 *     &lt;!-- Analytics optional module --&gt;
 *     &lt;dependency&gt;
 *          &lt;groupId&gt;com.isomorphic.smartgwt.enterprise&lt;/groupId&gt;
 *          &lt;artifactId&gt;smartgwt-analytics&lt;/artifactId&gt;
 *          &lt;version&gt;&#36;{smartgwt.version}&lt;/version&gt;
 *     &lt;/dependency&gt;
 *  </pre>
 *  <P>
 *  The table below describes what &lt;inherits&gt; to add for each module.</p>
 *  <table class="normal" border=1>
 *  <tr>
 *  <td><i><b>Module</b></i></td>
 *  <td><i><b>Add this to your .gwt.xml file</b></i></td>
 *  </tr>
 *  <tr>
 *  <td><b>PluginBridges</b> (included in <code>smartgwt.jar</code>)<br>
 * Required for all {@link com.smartgwt.client.widgets.plugins.BrowserPlugin} derivatives (such as
 *  LoadingOptionalModules.Applet and {@link com.smartgwt.client.widgets.plugins.Flashlet}) and
 *  also for FusionChart support.
 *  </td>
 *  <td><pre>&lt;inherits name="com.smartgwt.PluginBridgesWidgets"/&gt;</pre></td>
 *  </tr>
 *  <tr>
 *  <td><b>Charts</b> (included in <code>smartgwt.jar</code>)<br>
 *  Required for {@link com.smartgwt.client.widgets.chart.FacetChart} and FusionChart.
 * Note that {@link com.smartgwt.client.widgets.chart.FacetChart} also requires the
 * <code>Drawing</code> module to be loaded
 *  before this module.
 *  Note that FusionChart also requires the <code>PluginBridges</code> module to be
 *  loaded before this module.
 *  </td>
 *  <td><pre>&lt;inherits name="com.smartgwt.Charts"/&gt;</pre></td>
 *  </tr>
 *  <tr>
 *  <td><b>Analytics</b> (requires <code>analytics.jar</code>)<br>
 * See {@link com.smartgwt.client.widgets.cube.CubeGrid}. Note that if charting is also required,
 * the <code>Charts</code>
 *  module should be loaded before this one.</td>
 *  <td><pre>&lt;inherits name="com.smartgwt.Analytics"/&gt;</pre></td>
 *  </tr>
 *  <tr>
 *  <td><b>RealtimeMessaging</b> (requires <code>messaging.jar</code>)</td>
 *  <td><pre>&lt;inherits name="com.smartgwt.RealtimeMessaging"/&gt;</pre></td>
 *  </tr>
 *  <tr>
 *  <td><b>Tour</b> (included in <code>smartgwt.jar</code>)<br>
 *  Required for {@link com.smartgwt.client.util.tour.Tour}.
 *  </td>
 *  <td><pre>&lt;inherits name="com.smartgwtpower.Tour"/&gt;</pre><br>
 *  or<br>
 *  <pre>&lt;inherits name="com.smartgwtee.Tour"/&gt;</pre>
 *  </td>
 *  </tr>
 *  <tr>
 *  <td><b>SmartGwtTools</b> (included in <code>smartgwt.jar</code>)<br>
 * Required for the {@link com.smartgwt.client.docs.Debugging developer console} in SGWT LGPL. 
 * Imports
 *  <code>/development</code> Framework, including the tools module.  This module should always
 *  be listed <i>before</i> the SmartGwtXXX module and any other modules from above in your
 *  <i>moduleName</i>.gwt.xml file.  Not needed for SGWT Pro/Power/Enterprise as the
 *  <code>/development</code> Framework is present by default.
 *  <BR><BR>
 *  Note that the developer console has minor functionality issues unless Enterprise skin is
 *  used, so by default inheriting the <pre style="display:inline">SmartGwtTools</pre> module
 *  pulls it in.  Using <pre style="display:inline">SmartGwtToolsNoTheme</pre> instead will cause 
 *  the developer console to pick up the skin used by your project.<BR>
 *  </td><td>
 *  <pre style="display:inline;">&lt;inherits name="com.smartgwt.tools.SmartGwtTools"/&gt;</pre>
 *  </td><tr>
 *  <td><b>Tools</b> (included in <code>smartgwt.jar</code> for LGPL, otherwise smartgwtee.jar)
 *  <br>
 * Required for {@link com.smartgwt.client.docs.DevTools}. This module should always be listed
 * <i>after</i> any
 *  other modules from above in your <i>moduleName</i>.gwt.xml file.
 *  <P>
 *  Using these tools to edit hierarchies of Smart GWT components and generate Component XML
 *  for them also requires the system schema to be loaded.
 *  <P>
 *  <i>JSP tag:</i><pre>
 *  &lt;script&gt;&lt;isomorphic:loadSystemSchema /&gt;&lt;/script&gt;</pre>
 *  <P>
 *  <i>HTML tag:</i><pre>
 *  &lt;SCRIPT SRC="../isomorphic/DataSourceLoader?dataSource=$systemSchema"&gt;
 *  &lt;/SCRIPT&gt;</pre>
 *  Certain SGWT Pro/Power/Enterprise tools pulled in by the
 *  <pre style="display:inline">com.smartgwtee.tools.Tools</pre> module may require tool skin
 *  resources:<BR>
 *  <BR>
 *  <pre style="display:inline"
 *  >&lt;inherits name="com.smartclientee.toolskin.ToolSkinResources"/&gt;</pre>
 *  <pre>&lt;inherits name="com.smartclientee.toolskinnative.ToolSkinNativeResources"/&gt;</pre>
 *  <P>
 *  Reify requires inheriting Tahoe Resources:<P>
 *  <pre>&lt;inherits name="com.smartclient.theme.tahoe.TahoeResources"/&gt;</pre>
 *  See the {@link com.smartgwt.client.docs.Skinning} help topic for an overview.
 *  </td>
 *  <td><pre style="display:inline;">&lt;inherits name="com.smartgwt.Tools"/&gt;</pre>
 *  <br>(imports "first class" tools module under /modules)<br><br><br><br>
 *  <pre style="display:inline;">&lt;inherits name="com.smartgwtee.tools.Tools"/&gt;</pre>
 *  <br>(imports SGWT Pro/Power/Enterprise Edition tools)
 *  </td>
 *  </tr>
 *  </table>
 * 
 */
public interface LoadingOptionalModules {
}
