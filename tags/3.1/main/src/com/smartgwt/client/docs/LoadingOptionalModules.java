	    
package com.smartgwt.client.docs;

/**
 * <h3>Loading Optional Modules</h3>
 * 
 *  <var class="SmartGWT">
 * <p>If your Smart GWT install includes an optional module, it must be added as an
 * &lt;inherits&gt;
 *  tag in your <i>moduleName</i>.gwt.xml module file for it to be used. Some optional modules 
 *  require an additional .jar file (eg analytics.jar), whereas some are bundled in smartgwt.jar
 *  automatically. Where applicable, additional module .jar files are included in
 * Evaluation SDKs but are separate downloads when using an Optional Module with Power or
 * Enterprise.
 *  The table below describes what &lt;inherits&gt; to add for each module.</p>
 *  <table class="normal" border=1>
 *  <tr>
 *  <td><i><b>Module</b></i></td>
 *  <td><i><b>Add this to your .gwt.xml file</b></i></td>
 *  </tr>
 *  <tr>
 *  <td><b>Drawing</b> (included in <code>smartgwt.jar</code>)<br>
 * Required for {@link com.smartgwt.client.widgets.drawing.DrawPane} and {@link
 * com.smartgwt.client.widgets.drawing.DrawItem}.
 *  </td>
 *  <td><pre>&lt;inherits name="com.smartgwt.Drawing"/&gt;</pre></td>
 *  </tr>
 *  <tr>
 *  <td><b>PluginBridges</b> (included in <code>smartgwt.jar</code>)<br>
 * Required for all {@link com.smartgwt.client.widgets.plugins.BrowserPlugin} derivatives (such as
 * {@link com.smartgwt.client.widgets.plugins.Applet} and {@link
 * com.smartgwt.client.widgets.plugins.Flashlet}) and
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
 *  <td><b>RealTimeMessaging</b> (requires <code>messaging.jar</code>)</td>
 *  <td><pre>&lt;inherits name="com.smartgwt.RealtimeMessaging"/&gt;</pre></td>
 *  </tr>
 *  </table>
 *  </var>
 */
public interface LoadingOptionalModules {
}
