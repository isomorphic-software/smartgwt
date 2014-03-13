
package com.smartgwt.client.docs;

/**
 * <h3>Integration with PhoneGap</h3>
 * <P>
 * PhoneGap documentation, quick start information, and programming guides are available at <a
 * href='http://phonegap.com' onclick="window.open('http://phonegap.com');return
 * false;">http://phonegap.com</a>.
 *  <P>
 * PhoneGap exposes a Contacts API which allows one to find, create and remove contacts from the
 * device's contacts database.
 * Unlike Titanium, which provides many native UI components, PhoneGap relies on 3rd party
 * frameworks for 
 * UI components. Additionally, PhoneGap provides no transitions or other animation effects
 * normally 
 *  accessible in native applications.
 *  <P>
 *  <em>In the following guide, the name "MyMobileApp" refers to a Smart GWT mobile application.
 * The instructions are intended to be general, and applicable to other apps by simply
 * substituting
 *  the application name and the few other app-specific details.</em>
 * 
 *  <h3>Installing PhoneGap</h3>
 *  Beginning with PhoneGap 2.9.0, PhoneGap is an NPM (Node.js Packager Manager) package.
 * You will need to install Node.js first in order to install PhoneGap. (<b>Tip for Mac users:</b>
 * <a href='http://brew.sh' onclick="window.open('http://brew.sh');return false;">Homebrew</a> is
 * a simple and easy way
 *  to install the latest version of Node.js and npm: <code>brew install node</code>)
 * 
 * <p>Once Node.js is installed, see <a href='http://phonegap.com/install/'
 * onclick="window.open('http://phonegap.com/install/');return
 * false;">http://phonegap.com/install/</a> for
 *  instructions on installing PhoneGap.
 * 
 *  <h3>Creating the PhoneGap Project</h3>
 * Use the <a href='http://docs.phonegap.com/en/edge/guide_cli_index.md.html'
 * onclick="window.open('http://docs.phonegap.com/en/edge/guide_cli_index.md.html');return
 * false;"><code>phonegap</code> command line utility</a>
 *  to create a new folder containing the project files:
 * 
 * <pre style="white-space:nowrap">phonegap create --id com.mycompany.apps.MyMobileApp --name
 * "MyMobileApp" path/to/project_folder</pre>
 * 
 *  <p>The project ID and name should be changed for your app.
 * 
 *  <h3>General Instructions</h3>
 *  Within the project folder, PhoneGap creates a special <code>www/</code> folder which contains
 * the application JavaScript code and other assets. Within this folder, only
 * <code>config.xml</code>
 *  is needed. All other files of the default "Hello PhoneGap" app can be deleted.
 * 
 * <p>You will need to open the application's main HTML file in a text editor to make a few
 * changes:
 *  <ul>
 *    <li>Change the DOCTYPE to the HTML5 DOCTYPE: <code>&lt;!DOCTYPE html&gt;</code></li>
 * <li>Add a <code>&lt;script&gt;</code> tag to the <code>&lt;head&gt;</code> element to load
 * <code>phonegap.js</code>:
 * <pre>&lt;script type="text/javascript" charset="UTF-8" language="JavaScript"
 * src="phonegap.js"&gt;&lt;/script&gt;</pre>
 * 
 *       <p><b>NOTE:</b> The <code>www/</code> folder should not contain <code>phonegap.js</code>.
 *   In other words, don't try to copy <code>phonegap.js</code> into the <code>www/</code> folder.
 *      PhoneGap automatically adds the appropriate version of this script, which is different for
 *        each platform.</li>
 * <li>Ensure that the following <code>&lt;meta&gt;</code> tags are used, also in the
 * <code>&lt;head&gt;</code> element:
 *        <pre>&lt;meta http-equiv="Content-Type" content="text/html;charset=UTF-8"&gt;
 * &lt;meta name="format-detection" content="telephone=no"&gt;
 * &lt;meta name="viewport" content="initial-scale=1, width=device-width, user-scalable=no,
 * minimum-scale=1, maximum-scale=1"&gt;</pre></li>
 *  </ul>
 * 
 *  <p>After making those changes, you will need to defer starting the application until the
 * <code><a href='http://docs.phonegap.com/en/edge/cordova_events_events.md.html#deviceready'
 * onclick="window.open('http://docs.phonegap.com/en/edge/cordova_events_events.md.html#deviceready');return
 * false;">deviceready</a></code> event has fired,
 *     particularly if your application invokes any PhoneGap API function.
 * 
 *         
 * 
 * To accomplish this in Smart&nbsp;GWT, it is helpful to use a utility class together with a bit
 * of JavaScript.
 * 
 * <p>The following utility class can be used to defer the <code>onModuleLoad</code> code until
 * PhoneGap is ready:
 * 
 *  <pre class="sourcefile">package com.mycompany.client;
 * 
 * import com.google.gwt.core.client.EntryPoint;
 * 
 * public abstract class CordovaEntryPoint implements EntryPoint {
 * 
 *     &#x40;Override
 *     public final native void onModuleLoad() &#x2F;*-{
 *         var self = this;
 *   if ($wnd.isDeviceReady) self.&#x40;com.mycompany.client.CordovaEntryPoint::onDeviceReady()();
 *         else {
 *             var listener = $entry(function () {
 *                 $doc.removeEventListener("deviceready", listener, false);
 *                 self.&#x40;com.mycompany.client.CordovaEntryPoint::onDeviceReady()();
 *             });
 *             $doc.addEventListener("deviceready", listener, false);
 *         }
 *     }-*&#x2F;;
 * 
 *     protected abstract void onDeviceReady();
 * }</pre>
 * 
 * <p>The <code>CordovaEntryPoint</code> class is used in conjunction with the following
 * JavaScript,
 *         which should be added before the closing <code>&lt/body&gt;</code> tag:
 * 
 *      <pre class="sourcefile">&lt;script type="text/javascript" language="JavaScript"&gt;
 * document.addEventListener("deviceready", function onDeviceReady() {
 *     window.isDeviceReady = true;
 *     document.removeEventListener("deviceready", onDeviceReady, false);
 * }, false);
 * &lt;/script&gt;</pre>
 * 
 * <p>After compiling your application with PhoneGap/Cordova support, copy the compiled
 * Smart&nbsp;GWT
 *  application to the <code>www/</code> folder.
 *  
 * 
 *  <h3>iOS Platform (iPhone &amp; iPad)</h3>
 * 
 *  <ol>
 *  <li>Open <b>Terminal</b>, <code>cd</code> into the project folder, and run:
 *  <pre>phonegap build ios</pre></li>
 * <li>Within the newly-created <code>platforms/ios/</code> folder, open the Xcode project
 * <code>MyMobileApp.xcodeproj</code>.</li>
 * <li>In Xcode, set the active scheme to <b>MyMobileApp &gt; iPhone Retina (4-inch) &gt; iOS
 * 7.0</b> or some other simulator destination.
 *   Then click the <b>Run</b> button. Xcode will start the iPhone Simulator and run the app.</li>
 * <li>When you are finished testing the application in the simulator, click the <b>Stop</b>
 * button.</li>
 *  </ol>
 * 
 * <p>It is helpful to pay attention to the output window when testing the app within iOS
 * Simulator.
 * The output window contains all logs to <code><a
 * href='https://developer.mozilla.org/en-US/docs/Web/API/console'
 * onclick="window.open('https://developer.mozilla.org/en-US/docs/Web/API/console');return
 * false;">window.console</a></code> and messages from the Cordova
 *  framework itself. One common issue is <code>ERROR whitelist rejection: url='SOMEURL'</code>,
 * which means that SOMEURL has not been added to <code>&lt;access origin="..."/&gt;</code> in
 * <code>config.xml</code>.
 * Refer to the <a
 * href='http://docs.phonegap.com/en/edge/guide_whitelist_index.md.html#Domain%20Whitelist%20Guide'
 * onclick="window.open('http://docs.phonegap.com/en/edge/guide_whitelist_index.md.html#Domain%20Whitelist%20Guide');return
 * false;">Domain Whitelist Guide</a>
 *  for more information.
 * 
 * <p>Once you have completely tested the application within the simulator, you should test the
 * app on
 * real hardware. Refer to Apple's <a
 * href='https://developer.apple.com/library/ios/documentation/IDEs/Conceptual/AppDistributionGuide/Introduction/Introduction.html'
 * onclick="window.open('https://developer.apple.com/library/ios/documentation/IDEs/Conceptual/AppDistributionGuide/Introduction/Introduction.html');return
 * false;">App Distribution Guide</a> for complete instructions on provisioning the app for
 * testing devices, in particular, the section titled
 * <a
 * href='https://developer.apple.com/library/ios/documentation/IDEs/Conceptual/AppDistributionGuide/TestingYouriOSApp/TestingYouriOSApp.html#//apple_ref/doc/uid/TP40012582-CH8-SW1'
 * onclick="window.open('https://developer.apple.com/library/ios/documentation/IDEs/Conceptual/AppDistributionGuide/TestingYouriOSApp/TestingYouriOSApp.html#//apple_ref/doc/uid/TP40012582-CH8-SW1');return
 * false;">Beta Testing Your iOS App</a>.
 * 
 *  <h3>Android Platform</h3>
 *  To begin targeting Android devices, follow the instructions on the
 * <a href='http://docs.phonegap.com/en/edge/guide_platforms_android_index.md.html'
 * onclick="window.open('http://docs.phonegap.com/en/edge/guide_platforms_android_index.md.html');return
 * false;">Android Platform Guide</a>.
 * 
 * <p>It is helpful to monitor the LogCat view in Eclipse to verify that your application is
 * working correctly.
 *  Common errors include:
 *  <ul>
 *  <li><code>Application Error The protocol is not supported. (gap://ready)</code>
 *      <p>This means that the incorrect <code>phonegap.js</code> script is being used. You
 * must use the <code>phonegap.js</code> for Android.<!--
 * http://community.phonegap.com/nitobi/topics/error_starting_app_on_android -->
 *      <p>Try updating the 'android' platform to fix the problem:
 *      <pre>phonegap platform update android</pre>
 *      </li>
 *  <li><code>Data exceeds UNCOMPRESS_DATA_MAX</code>
 * <p>In older versions of Android (pre-2.3.3), there is a 1 Megabyte limit on the size of
 * individual
 *         Android app assets. This error message means that one asset file exceeds this limit.
 * You should see a popup alert dialog containing the name of the problematic file, and then the
 * app will crash.
 * <p>The "Data exceeds UNCOMPRESS_DATA_MAX" error can be seen if, for example, the
 * SmartGWT.mobile application
 *         was compiled in DETAILED or PRETTY mode.
 *      </li>
 *  </ul>
 * 
 *  <h3>Samples</h3>
 *  
 * <p>The Smart&nbsp;GWT Google Code project has a sample application called <a
 * href='http://code.google.com/p/smartgwt/source/browse/#svn%2Ftrunk%2Fsamples%2Fphonegap%2FMyContacts'
 * onclick="window.open('http://code.google.com/p/smartgwt/source/browse/#svn%2Ftrunk%2Fsamples%2Fphonegap%2FMyContacts');return
 * false;">MyContacts</a> which demonstrates how
 * to work with the PhoneGap API in a Smart&nbsp;GWT app. The main Smart&nbsp;GWT code is located
 * at
 * <code><a
 * href='http://code.google.com/p/smartgwt/source/browse/#svn%2Ftrunk%2Fsamples%2Fphonegap%2FMyContacts'
 * onclick="window.open('http://code.google.com/p/smartgwt/source/browse/#svn%2Ftrunk%2Fsamples%2Fphonegap%2FMyContacts');return
 * false;">trunk/samples/phonegap/MyContacts</a></code>. An Xcode project used to package the app
 * for iOS
 * devices is located at <code><a
 * href='http://code.google.com/p/smartgwt/source/browse/#svn%2Ftrunk%2Fsamples%2Fphonegap%2FMyContacts-iOS'
 * onclick="window.open('http://code.google.com/p/smartgwt/source/browse/#svn%2Ftrunk%2Fsamples%2Fphonegap%2FMyContacts-iOS');return
 * false;">trunk/samples/phonegap/MyContacts-iOS</a></code>. An Eclipse project used
 * to package the app for Android devices is located at <code><a
 * href='http://code.google.com/p/smartgwt/source/browse/#svn%2Ftrunk%2Fsamples%2Fphonegap%2FMyContacts-Android'
 * onclick="window.open('http://code.google.com/p/smartgwt/source/browse/#svn%2Ftrunk%2Fsamples%2Fphonegap%2FMyContacts-Android');return
 * false;">trunk/samples/phonegap/MyContacts-Android</a></code>.
 * 
 * <p>This sample application utilizes the script changer technique to load the correct
 * <code>cordova.js</code>.
 * Additionally, GWT's <a
 * href='http://www.gwtproject.org/doc/latest/DevGuideCodingBasicsOverlay.html'
 * onclick="window.open('http://www.gwtproject.org/doc/latest/DevGuideCodingBasicsOverlay.html');return
 * false;">JavaScript overlay types</a>
 *  feature is used to easily wrap the PhoneGap Contacts API for use by the Smart&nbsp;GWT app.
 * 
 */
public interface PhonegapIntegration {
}
