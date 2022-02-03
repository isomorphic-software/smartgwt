
package com.smartgwt.client.docs;

/**
 * <h3>Supported Browsers</h3>
 * When considering which browser versions are supported, developers should consider which browser
 * versions they wish to support within their application. Generally this will be a subset of what
 * the framework supports, and should be decided based on the needs of your customers (typically
 * corporate policies on browser usage  for intranet applications, or general browser usage for
 * customer facing applications). <P> The Smart GWT framework supports all major browsers, and
 * will always support the current versions at release-time. <P> The full list of Smart GWT
 * browser support (at the time of the initial 11.1p release)  is listed below. Note that support
 * for some framework features may be implemented using different native approaches - or in rare
 * cases, may be unavailable - in some older browser  versions. Such cases are covered in
 * documentation where they occur. For example, see the {@link com.smartgwt.client.docs.Skinning
 * skinning} discussion about CSS3 mode. <P> At the application level, we'd typically recommend
 * advertising support for the latest versions of Chrome, Safari and Firefox, the most recent
 * Firefox ESR release and the most common (and most recent) versions of Internet Explorer. <P>
 * <h4>Support for new browser versions introduced after Smart GWT release</h4> When new browser
 * versions are released we will generally determine whether any issues are introduced by the new
 * version, and update the most recent released Smart GWT version to add support for these new
 * browsers if changes are necessary. These changes will be made available in nightly patch
 * builds. <P> Older branches of Smart GWT may also be updated to support new browser versions.
 * This will be considered on a case-by-case basis, depending on the effort required to work
 * around any newly introduced browser bugs on these older branches. <P> <h4>Unsupported browser
 * handling</h4> Every distributed Smart GWT skin contains an "Unsupported Browser" page. This is
 * an optional placeholder for an application to state its browser support policies. <P> <b>The
 * following browser versions were supported as of the original 11.1p release</b>:    <table
 * class="normal" cellPadding=5>    <tr><td width=40></td><td width=200>    <b>Browser/Version</b>
 * </td><td width=240>    <b>Operating System(s)</b>    </td></tr>    <tr><td></td><td>   
 * <i>Internet Explorer 6.0-11.x</i>    </td><td>    Windows    </td></tr>    <tr><td></td><td>   
 * <i>Edge 20.10240.16384.0+</i>    </td><td>    Windows    </td></tr>    <tr><td></td><td>   
 * <i>Firefox 3.6.x-54.x</i>    </td><td>    Windows/MacOS/Linux    </td></tr>   
 * <tr><td></td><td>    <i>Safari 5.0-10.x</i>    </td><td>    MacOS/Windows    </td></tr>   
 * <tr><td></td><td>    <i>Chrome 10.x-58.x</i>    </td><td>    Windows/MacOS/Linux/ChromeOS   
 * </td></tr>    <tr><td></td><td>    <i>Opera 11.x-36.x</i>    </td><td>    Windows/MacOS   
 * </td></tr>    <tr><td></td><td>    <i>Safari (mobile)</i>    </td><td>    iOS 6+    </td></tr> 
 * <tr><td></td><td>    <i>Android browser</i>    </td><td>    Android 3.2+    </td></tr>   
 * </table>
 * @see com.smartgwt.client.util.Page#checkBrowserAndRedirect
 * @see com.smartgwt.client.util.Page#getUnsupportedBrowserPromptString
 * @see com.smartgwt.client.util.Page#defaultUnsupportedBrowserURL
 * @see com.smartgwt.client.util.Page#unsupportedBrowserAction
 */
public interface BrowserSupport {
}
