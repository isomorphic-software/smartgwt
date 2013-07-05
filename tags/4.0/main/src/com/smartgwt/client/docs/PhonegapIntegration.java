
package com.smartgwt.client.docs;

/**
 * <h3>Integration with PhoneGap</h3>
 * <P>
 * PhoneGap documentation, quick start information, and programming guides are available at <a
 * href='http://www.phonegap.com/' onclick="window.open('http://www.phonegap.com/');return
 * false;">http://www.phonegap.com/</a>.
 *  <P>
 * PhoneGap exposes a Contacts API which allows one to find, create and remove contacts from the
 * device's contacts database.
 * Unlike Titanium, which provides many native UI components, PhoneGap relies on 3rd party
 * frameworks for 
 * UI components. Additionally, PhoneGap provides no transitions or other animation effects
 * normally 
 *  accessible in native applications.
 *  <P>
 *  In the following guide, the name "MyMobileApp" refers to a <!----><!---->Smart&nbsp;GWT<!---->
 * mobile application. The instructions are intended to be general, and applicable to other apps
 * by simply substituting the application name
 *  and the few other app-specific details.
 * 
 *  <h3>General Instructions</h3>
 * For each target that PhoneGap supports, there is a special <code>www/</code> folder which
 * contains
 * the application JavaScript code and other assets. If the <code>www/</code> folder was created
 * for you,
 * the only file that is needed within is <code>cordova-x.x.x.js</code>. All other files can be
 * deleted.
 * 
 *  <p>Copy your <!----><!---->compiled Smart&nbsp;GWT<!---->
 * application into the <code>www/</code> folder. You will need to open the application's main
 * HTML
 *  file in a text editor to make a few changes:
 *  <ul>
 *    <li>Change the DOCTYPE to the HTML5 DOCTYPE: <code>&lt;!DOCTYPE html&gt;</code></li>
 * <li>Add a <code>&lt;script&gt;</code> tag to the <code>&lt;head&gt;</code> element to load
 * <code>cordova-x.x.x.js</code>:
 * <pre>    &lt;script type="text/javascript" charset="UTF-8" language="JavaScript"
 * src="cordova-x.x.x.js"&gt;&lt;/script&gt;</pre>
 * 
 *        <p><b>NOTE:</b> There is a <code>cordova-x.x.x.js</code> for each target that PhoneGap
 *        supports; they are different scripts. To set up a single codebase for multiple
 *        targets, see the section titled <b>Multi-Target Codebase</b> below.</li>
 * <li>Ensure that the following <code>&lt;meta&gt;</code> tags are used, also in the
 * <code>&lt;head&gt;</code> element:
 *        <pre>    &lt;meta http-equiv="Content-Type" content="text/html; charset=UTF-8"&gt;
 *     &lt;meta name="format-detection" content="telephone=no"&gt;
 * &lt;meta name="viewport" content="user-scalable=no, initial-scale=1, minimum-scale=1,
 * maximum-scale=1, width=device-width"&gt;</pre></li>
 *  </ul>
 * 
 *  <p>After making those changes, you will need to defer starting the application until the
 * <code><a href='http://docs.phonegap.com/en/edge/cordova_events_events.md.html#deviceready'
 * onclick="window.open('http://docs.phonegap.com/en/edge/cordova_events_events.md.html#deviceready');return
 * false;">deviceready</a></code> event has fired,
 *     particularly if your application invokes any PhoneGap API function.
 * 
 *         <!---->
 * 
 * <!---->To accomplish this in Smart&nbsp;GWT, it is helpful to use a utility class together with
 * a bit of JavaScript.
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
 *     document.removeEventListener("deviceready", arguments.callee, false);
 * }, false);
 * &lt;/script&gt;</pre><!---->
 * 
 *  <h3>iOS Targets (iPhone &amp; iPad)</h3>
 * Beginning with PhoneGap / Cordova 2.0.0, special command-line tooling <a
 * href='http://phonegap.com/2012/07/20/adobe-phonegap-2-0-released.md/'
 * onclick="window.open('http://phonegap.com/2012/07/20/adobe-phonegap-2-0-released.md/');return
 * false;">has been introduced</a>
 *  which replaces the custom Xcode project templates. To create a new project, the
 * <a
 * href='http://docs.phonegap.com/en/edge/guide_command-line_index.md.html#Command-Line%20Usage_ios'
 * onclick="window.open('http://docs.phonegap.com/en/edge/guide_command-line_index.md.html#Command-Line%20Usage_ios');return
 * false;"><code>create</code> program</a>
 *  located at <code>$PHONEGAP_SDK/lib/ios/bin/create</code> is used:
 * 
 * <pre>$PHONEGAP_SDK/lib/ios/bin/create path/to/my_cordova_project com.MyCompany.ProjectName
 * ProjectName</pre>
 * 
 *  <ol>
 * <li>Open <b>Terminal</b> and run <code>$PHONEGAP_SDK/lib/ios/bin/create MyMobileApp-iOS
 * com.mycompany.MyMobileApp MyMobileApp</code></li>
 * <li>Within the newly-created <code>MyMobileApp-iOS/</code> folder, open the Xcode project
 * <code>MyMobileApp.xcodeproj</code>.</li>
 *  <li>Follow the General Instructions above.</li>
 * <li>In Xcode, using the scheme selector toolbar, set the Scheme to <b>MyMobileApp &gt; iPhone
 * 6.0 Simulator</b> or some other simulator destination.
 *      Then click the <b>Run</b> button. Xcode will start the iOS Simulator and run the app.</li>
 * <li>When you are finished testing the application in the simulator, click the <b>Stop</b>
 * button.</li>
 *  </ol>
 * 
 * <p>It is helpful to pay attention to the output window when testing the app within iOS
 * Simulator.
 * The output window contains all logs to <code><a
 * href='https://developer.mozilla.org/en/DOM/console'
 * onclick="window.open('https://developer.mozilla.org/en/DOM/console');return
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
 * <p>You can make changes to your application and re-run it in the simulator without needing to
 * close Xcode:
 *  <ol>
 *  <li>Stop the application if running.</li>
 *  <li>Select <b>Product -&gt; Clean</b></li>
 *  <li>Click the <b>Run</b> button.</li>
 *  </ol>
 * 
 * <p>Once you have completely tested the application within the simulator, you should test the
 * app on
 * real hardware. Refer to Apple's <a
 * href='https://developer.apple.com/library/ios/#documentation/Xcode/Conceptual/ios_development_workflow/00-About_the_iOS_Application_Development_Workflow/introduction.html'
 * onclick="window.open('https://developer.apple.com/library/ios/#documentation/Xcode/Conceptual/ios_development_workflow/00-About_the_iOS_Application_Development_Workflow/introduction.html');return
 * false;">Tools Workflow Guide for iOS</a> for complete instructions on provisioning the app for
 * testing devices, in particular, the section titled
 * <a
 * href='https://developer.apple.com/library/ios/#documentation/Xcode/Conceptual/ios_development_workflow/35-Distributing_Applications/distributing_applications.html#//apple_ref/doc/uid/TP40007959-CH10-SW4'
 * onclick="window.open('https://developer.apple.com/library/ios/#documentation/Xcode/Conceptual/ios_development_workflow/35-Distributing_Applications/distributing_applications.html#//apple_ref/doc/uid/TP40007959-CH10-SW4');return
 * false;">Sending Your App to Testers</a>.
 * Note that you will need to set the Scheme destination to <b>MyMobileApp &gt; iOS Device</b> for
 * the <b>Product -&gt; Archive</b> menu option to be available.
 * <!-- The previous note should help SC devs get past this common sticking point:
 * http://stackoverflow.com/questions/3087089/xcode-build-and-archive-menu-item-disabled -->
 * 
 *  <h3>Android Targets</h3>
 *  To begin targeting Android devices, follow the instructions on the
 * <a
 * href='http://docs.phonegap.com/en/edge/guide_getting-started_android_index.md.html#Getting%20Started%20with%20Android'
 * onclick="window.open('http://docs.phonegap.com/en/edge/guide_getting-started_android_index.md.html#Getting%20Started%20with%20Android');return
 * false;">Getting Started with Android guide</a>.
 *  After creating the new Android app project, follow the General Instructions above.
 * 
 * <p>It is helpful to monitor the LogCat in Eclipse to verify that your application is working
 * correctly.
 *  Common errors include:
 *  <ul>
 *  <li><code>Application Error The protocol is not supported. (gap://ready)</code>
 *      <p>This means that the incorrect <code>cordova-x.x.x.js</code> script is being used. You
 * must use the <code>cordova-x.x.x.js</code> for Android.<!--
 * http://community.phonegap.com/nitobi/topics/error_starting_app_on_android -->
 *      </li>
 *  <li><code>Data exceeds UNCOMPRESS_DATA_MAX</code>
 *    <p>There is a limit to the size of individual Android app assets, typically 1 Megabyte. This
 *        error message means that one asset file exceeds this limit. You should see a popup alert
 *         dialog containing the name of the problematic file, and then the app will crash.
 * <!----><p>The "Data exceeds UNCOMPRESS_DATA_MAX" error can be seen if, for example, the
 * Smart&nbsp;GWT application
 *         was compiled in DETAILED or PRETTY mode.<!---->
 *      </li>
 *  </ul>
 * 
 *  <h3>Multi-Target Codebase</h3>
 *  There is a <code>cordova-x.x.x.js</code> for each target that PhoneGap supports; they are
 *  different scripts. To target multiple platforms using a single codebase, it can be useful to
 *  employ a "script changer" to load the correct <code>cordova-x.x.x.js</code>:
 * 
 *  <!---->
 *  <!----><pre class="sourcefile">&lt;script type="text/javascript" language="JavaScript"&gt;
 *     var scriptName;
 *     if (navigator.userAgent.indexOf("Android") &gt; -1) {
 *         scriptName = "cordova-2.3.0-android.js";
 * } else if (navigator.userAgent.indexOf("iPhone") &gt; -1 || navigator.userAgent.indexOf("iPad")
 * &gt; -1) {
 *         scriptName = "cordova-2.3.0-iOS.js";
 *     }
 *     if (scriptName) document.write("&lt;script type='text/javascript' charset='UTF-8' " +
 *           "language='JavaScript' src='" + encodeURI(scriptName) + "'&gt;&lt;" + "/script&gt;");
 * &lt;/script&gt;</pre><!---->
 * 
 *  <h3>Samples</h3>
 *  <!----><!---->
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
 * <code>cordova-x.x.x.js</code>.
 * Additionally, GWT's <a
 * href='http://developers.google.com/web-toolkit/doc/latest/DevGuideCodingBasicsOverlay'
 * onclick="window.open('http://developers.google.com/web-toolkit/doc/latest/DevGuideCodingBasicsOverlay');return
 * false;">JavaScript overlay types</a>
 *  feature is used to easily wrap the PhoneGap Contacts API for use by the Smart&nbsp;GWT app.
 *  <!---->
 */
public interface PhonegapIntegration {
}
