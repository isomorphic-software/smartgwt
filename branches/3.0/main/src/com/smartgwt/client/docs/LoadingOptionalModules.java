
package com.smartgwt.client.docs;

/**
 * <h3>Loading Optional Modules</h3>
 * 
 *  
 *  <p>If your Smart GWT install includes an optional module, it must be added as an &lt;inherits&gt;
 *  tag in your <i>moduleName</i>.gwt.xml module file for it to be used.  Make sure you have downloaded
 *  the appropriate .jar file for the optional modules (eg Analytics.jar) - these are included in
 *  Evaluation SDKs but are separate downloads when using an Optional Module with Power or Enterprise.
 *  The table below describes what &lt;inherits&gt; to add for each module.</p>
 *  <table class="normal" border=1 width="700">
 *  <tr>
 *  <td><i><b>Module name</b></i></td>
 *  <td><i><b>Add this to your .gwt.xml file</b></i></td>
 *  </tr>
 *  <tr>
 *  <td>Charts</td>
 *  <td><pre>&lt;inherits name="com.smartgwt.Charts"/&gt;</pre></td>
 *  </tr>
 *  <tr>
 *  <td>Analytics ({@link com.smartgwt.client.widgets.cube.CubeGrid})</td>
 *  <td><pre>&lt;inherits name="com.smartgwt.Analytics"/&gt;</pre></td>
 *  </tr>
 *  <tr>
 *  <td>RealTimeMessaging</td>
 *  <td><pre>&lt;inherits name="com.smartgwt.RealtimeMessaging"/&gt;</pre></td>
 *  </tr>
 *  </table>
 *  
 *  <b>Note</b> that all optional modules must appear after the rest of Smart GWT is included,
 *  and Charts must be loaded <b>before</b> Analytics.
 */
public interface LoadingOptionalModules {
}
