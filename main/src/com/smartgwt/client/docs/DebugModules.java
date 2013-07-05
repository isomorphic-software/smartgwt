
package com.smartgwt.client.docs;

/**
 * <h3>Using the Debug Modules</h3>
 * <!---->
 *  <!---->
 *  Smart&nbsp;GWT LGPL, Pro, Power, and Enterprise come with debug / readable versions of the
 *  Smart GWT JS files that may be useful during development.
 * 
 *  <p>To enable the use of debug modules, you will need to change the &lt;inherits&gt; lines
 * in the application's GWT module file to reference the debug versions of the Smart&nbsp;GWT
 * modules:
 *  <table border="1" cellpadding="5" cellspacing="0">
 *  <tbody>
 *  <tr><th>Edition</th><th>Original &lt;inherits&gt;</th><th>New &lt;inherits&gt;</th></tr>
 *  <tr>
 *  <th>LGPL</th>
 *  <td><code>&lt;inherits name="com.smartgwt.SmartGwt"/&gt;</code></td>
 *  <td><code>&lt;inherits name="com.smartgwt<b>.debug.</b>SmartGwt<b>Debug</b>"/&gt;</code></td>
 *  </tr>
 *  <tr>
 *  <th>Pro</th>
 *  <td><code>&lt;inherits name="com.smartgwtpro.SmartGwtPro"/&gt;</code></td>
 * <td><code>&lt;inherits
 * name="com.smartgwtpro<b>.debug.</b>SmartGwtPro<b>Debug</b>"/&gt;</code></td>
 *  </tr>
 *  <tr>
 *  <th>Power</th>
 *  <td><code>&lt;inherits name="com.smartgwtpower.SmartGwtPower"/&gt;</code></td>
 * <td><code>&lt;inherits
 * name="com.smartgwtpower<b>.debug.</b>SmartGwtPower<b>Debug</b>"/&gt;</code></td>
 *  </tr>
 *  <tr>
 *  <th>Enterprise</th>
 *  <td><code>&lt;inherits name="com.smartgwtee.SmartGwtEE"/&gt;</code></td>
 * <td><code>&lt;inherits
 * name="com.smartgwtee<b>.debug.</b>SmartGwtEE<b>Debug</b>"/&gt;</code></td>
 *  </tr>
 *  </tbody>
 *  </table>
 * 
 *  <p>The convention is that the names of debug GWT modules end with "Debug".
 * 
 *  <p>If using the NoScript modules, you will need to change the &lt;inherits&gt; lines
 *  <table border="1" cellpadding="5" cellspacing="0">
 *  <tbody>
 *  <tr><th>Edition</th><th>Original &lt;inherits&gt;</th><th>New &lt;inherits&gt;</th></tr>
 *  <tr>
 *  <th>LGPL</th>
 *  <td><code>&lt;inherits name="com.smartgwt.SmartGwtNoScript"/&gt;</code></td>
 * <td><code>&lt;inherits
 * name="com.smartgwt<b>.debug.</b>SmartGwtNoScript<b>Debug</b>"/&gt;</code></td>
 *  </tr>
 *  <tr>
 *  <th>Pro</th>
 *  <td><code>&lt;inherits name="com.smartgwtpro.SmartGwtProNoScript"/&gt;</code></td>
 * <td><code>&lt;inherits
 * name="com.smartgwtpro<b>.debug.</b>SmartGwtProNoScript<b>Debug</b>"/&gt;</code></td>
 *  </tr>
 *  <tr>
 *  <th>Power</th>
 *  <td><code>&lt;inherits name="com.smartgwtpower.SmartGwtPowerNoScript"/&gt;</code></td>
 * <td><code>&lt;inherits
 * name="com.smartgwtpower<b>.debug.</b>SmartGwtPowerNoScript<b>Debug</b>"/&gt;</code></td>
 *  </tr>
 *  <tr>
 *  <th>Enterprise</th>
 *  <td><code>&lt;inherits name="com.smartgwtee.SmartGwtEENoScript"/&gt;</code></td>
 * <td><code>&lt;inherits
 * name="com.smartgwtee<b>.debug.</b>SmartGwtEENoScript<b>Debug</b>"/&gt;</code></td>
 *  </tr>
 *  </tbody>
 *  </table>
 *  and change the &lt;script&gt; tags in the application's HTML file to the debug modules
 *  instead of the normal Smart GWT modules. For example:
 *  <pre>&lt;script src="myapp/sc/modules<b>-debug</b>/ISC_Core.js"&gt;&lt;/script&gt;
 * &lt;script src="myapp/sc/modules<b>-debug</b>/ISC_Foundation.js"&gt;&lt;/script&gt;
 * &lt;script src="myapp/sc/modules<b>-debug</b>/ISC_Containers.js"&gt;&lt;/script&gt;
 * &lt;script src="myapp/sc/modules<b>-debug</b>/ISC_Grids.js"&gt;&lt;/script&gt;
 * &lt;script src="myapp/sc/modules<b>-debug</b>/ISC_Forms.js"&gt;&lt;/script&gt;
 * &lt;script src="myapp/sc/modules<b>-debug</b>/ISC_RichTextEditor.js"&gt;&lt;/script&gt;
 * &lt;script src="myapp/sc/modules<b>-debug</b>/ISC_Calendar.js"&gt;&lt;/script&gt;
 * &lt;script src="myapp/sc/modules<b>-debug</b>/ISC_DataBinding.js"&gt;&lt;/script&gt;
 * &lt;script src="myapp/sc/modules<b>-debug</b>/ISC_Drawing.js"&gt;&lt;/script&gt;</pre>
 * 
 *  <p>Alternatively, the &lt;isomorphic:loadISC&gt; and &lt;isomorphic:loadModules&gt; tags
 *  support a <code>useDebugModules</code> attribute:
 *  <pre>&lt;isomorphic:loadISC skin="Enterprise" useDebugModules="true"/&gt;</pre>
 *  <!---->
 */
public interface DebugModules {
}
