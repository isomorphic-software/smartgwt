
package com.smartgwt.client.docs;

/**
 * <h3>Debugging</h3>
 * <h4>Built-in Diagnostics</h4>&#010 <P>&#010 In any page in which ISC has been loaded, you have access to the Developer
 * Console,&#010 which can be opened by entering the following URL into your browser from the running&#010
 * application:&#010 <pre>&#010     javascript:isc.showConsole()</pre>&#010 Basic information on the features of the
 * Developer Console can be found in the QuickStart&#010 Guide.  This topic focuses on use of the log system and related
 * debugging facilities.&#010 <P>&#010 The Developer Console contains a "Results" pane that displays a list of
 * diagnostic&#010 messages logged by the Smart GWT framework. The "Logging Preferences" menu lets you&#010 enable and
 * disable Smart GWT's built-in diagnostics in several categories. Because&#010 important diagnostic messages may be logged
 * at any time, you should have the Developer&#010 Console open whenever you are working with Smart GWT (and you should
 * bookmark the&#010 "javascript:" expression above to make this easier).&#010 <P>&#010 Log messages are of the
 * format:&#010 <P>&#010 &nbsp;&nbsp;&nbsp;<i>timestamp</i>:<i>priority</i>:<i>category</i>:<i>message</i>&#010 <P>&#010
 * For example, the following log message:&#010 <pre>&#010     11:59:25:806:INFO:Page:Page loading complete.</pre>&#010
 * Occured at 11:59:25 local time and 806 milliseconds.  It's priority was <code>INFO</code>,&#010 it occurred in the
 * category <i>Page</i>, and the message is "Page loading complete.".&#010 <P>&#010 Each logging <i>category</i> has a
 * <i>priority</i> associated with it.  If a message's&#010 priority is lower than the current priority for the category it
 * is logged in, the&#010 message will be suppressed (will not appear in the "Results" pane).  &#010 <p>&#010 It is
 * critical to be familiar with the diagnostic categories built-in to Smart GWT - &#010 you will use them in most debugging
 * sessions.  Open the Logging Preferences menu and select&#010 "More.." to see a list of diagnostic log categories.  
 * Hover over each category name to&#010 see a description of what kind of messages are logged in the category.  &#010
 * <P>&#010 <h4>Debugging JavaScript Errors</h4>&#010 <P>&#010 Isomorphic recommends the FireFox browser as the primary
 * development platform.  In FireFox,&#010 JavaScript errors are reported both in the Smart GWT Developer Console and in
 * the FireFox&#010 JavaScript console, which can be opened by entering the special&#010 url "javascript:" in the address
 * bar.&#010 <P>&#010 Isomorphic currently recommends that every Smart GWT developer install either the &#010 <a
 * href='https://addons.mozilla.org/firefox/1815/' onclick="window.open('https://addons.mozilla.org/firefox/1815/');return
 * false;">Console2</a> or&#010 <a href='http://www.getfirebug.com/'
 * onclick="window.open('http://www.getfirebug.com/');return false;">Firebug</a> extensions for FireFox.  "Console2"
 * simply&#010 replaces the default FireFox JavaScript console with a more functional console;&#010 Firebug aims to be a
 * true debugger.  Both tools will typically load or identify the correct&#010 file and line number where a JS error
 * occured.&#010 <P>&#010 In Internet Explorer, when JS errors occur, Smart GWT is able to report full stack traces&#010 in
 * the Developer Console.  This can be invaluable when your code triggers a JS error&#010 in the Smart GWT libraries
 * themselves, or when it is unclear how your code is being&#010 called.  Stack traces from Internet Explorer should
 * <i>always</i> be included in issue&#010 reports sent to Isomorphic Software, if at all possible. &#010 <P>&#010
 * <h4>Inspecting application state</h4>&#010 <P>&#010 The "Evaluate JS Expression" area of the Results Pane in the
 * Developer Console can be used&#010 to inspect the current state of a Smart GWT application.  Any Smart GWT or
 * browser&#010 built-in API can be called from the "Evaluate JS Expression" area, and the results will&#010 be
 * intelligently summarized (via {@link com.smartgwt.client..Log#echo}).  For example, simply typing a&#010 component's ID
 * and pressing the "Eval JS" button will give you a dump of it's current&#010 property values.  &#010 <P>&#010 Many, many
 * Smart GWT APIs can be usefully called while troubleshooting, eg, &#010 {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getData data} is a {@link com.smartgwt.client.data.ResultSet} when a grid is
 * DataBound and &#010 {@link com.smartgwt.client.data.ResultSet#get} can be called to inspect the current values on
 * records.  In addition,&#010 new application code can be tried out, for example, you might repeatedly instantiate a
 * new&#010 component, trying variants on the properties you could give it.&#010 <P>&#010 <b>Inspecting transient
 * application state with logs</b>&#010 <P>&#010 Transient state, such as the values of local variables in a method that is
 * crashing, can be&#010 sent to the Developer Console via using the {@link com.smartgwt.client..Log} class.  For example,
 * to dump the&#010 value of the local variable "request": &#010 <pre>&#010     isc.logWarn("request is: " +
 * isc.echo(request));&#010 </pre>&#010 <P>&#010 It's a good idea to dump the values of local variables in any method that
 * is crashing or&#010 behaving unexpectedly.&#010 <P>&#010 Note the use of {@link com.smartgwt.client.util.isc#logWarn}
 * above: in typical debugging sessions,&#010 it's best&#010 to simply use <code>logWarn</code> method to output
 * diagnostics to ensure your message will&#010 not be suppressed by log priority settings.&#010 <P>&#010 NOTE: never use
 * the native <code>alert()</code> method to output diagnostics.  Among other&#010 issues, <code>alert()</code> can affect
 * timing, masking or altering the behavior you were&#010 trying to debug.  Smart GWT's logging system doesn't suffer from
 * these problems and&#010 provides much more control.&#010 <P>&#010 <h4>Issue Reports</h4>&#010 <P>&#010 If you believe
 * you've discovered a bug in Smart GWT or you are having trouble using&#010 Smart GWT APIs, you can report it at <a
 * href='http://forums.smartclient.com/' onclick="window.open('http://forums.smartclient.com/');return
 * false;">http://forums.smartclient.com/</a>, or, if&#010 you have Enterprise Support, at the &#010 <a
 * href='http://support.isomorphic.com/' onclick="window.open('http://support.isomorphic.com/');return false;">Customer
 * Support Extranet</a>.&#010 <P>&#010 <b>How quickly your issue is resolved is entirely up to you</b>.  If you follow the
 * steps&#010 below and submit an appropriate issue report, you will generally receive a rapid solution&#010 from
 * Isomorphic Support, regardless of what support level you have, because Isomorphic&#010 aggressively corrects bugs and
 * legitimate usage issues.  If you skip steps you are likely to&#010 be directed back to this document and asked to submit
 * a more complete issue report.&#010 <P>&#010 Before reporting an issue, ensure that you:&#010 <ul>&#010 <li> Have read
 * the ${isc.DocUtils.linkForDocNode('QuickStartGuide', 'QuickStart Guide')} cover to&#010 cover.  Later chapters cover
 * more advanced topics and provide links to further examples and&#010 reference.&#010 <li> Have searched the
 * ${isc.DocUtils.linkForDocNode('FeatureExplorer', 'Feature Explorer')} for examples that show&#010 what you are trying to
 * do&#010 <li> Have searched this reference, trying multiple searches using different, common and&#010 related terms for
 * what you are trying to do (eg for search, try "search", "filter",&#010 "criteria", "find", "match", etc)&#010 <li> Have
 * searched the public <a href='http://forums.smartclient.com' onclick="window.open('http://forums.smartclient.com');return
 * false;">forums</a>&#010 </ul>&#010 Always include:&#010 <ul>&#010 <li> A description of what you are trying to
 * accomplish <b>from a user's perspective</b>.&#010 The best answers often point out a simpler approach.&#010 <li> The
 * browser(s), operating system(s) and Smart GWT version(s) you experience the error&#010 on (Smart GWT version is
 * available in the lower-left handle corner of the Developer&#010 Console)&#010 </ul>&#010 Then, include <b>either</b> a
 * standalone test case (see below), <b>or</b>:&#010 <ul>&#010 <li> For JS errors, Stack traces from Firebug (for Firefox)
 * or the Developer Console (for&#010 IE), as covered under "Debugging JavaScript Errors" above&#010 <li> Results of
 * calling <code>echo()</code> on local variables or other application&#010 state you think is relevant (see "Inspecting
 * Application State" above)&#010 <li> What server platform and {@link com.smartgwt.client.docs.ClientServerIntegration
 * 'databinding approach'} you&#010 are using, if applicable&#010 <li> contents of the Smart GWT Developer Console "Log
 * messages" area, with appropriate&#010 diagnostic categories set the DEBUG or INFO level (see "Built-in Diagnostics"
 * above)&#010 <li> sample code and sample data&#010 </ul>&#010 <b>Preparing a standalone test case</b>&#010 <P>&#010 A
 * standalone test case is one of:&#010 <ol>&#010 <li> a chunk of JavaScript code that can be executed from the "Eval JS"
 * area of the&#010 Developer Console on some specified page within the unmodified Smart GWT SDK,&#010 demonstrating your
 * issue&#010 <li> an .html or .jsp file that can be dropped at a specified location into an unmodified&#010 Smart GWT SDK
 * and will run without changes, demonstrating your issue.&#010 <li> a .zip file that includes a standalone .html/.jsp file
 * as above, as well as&#010 dependencies required to make the test case runnable, such as XML datasets&#010 </ol>&#010
 * <P>&#010 Submitting a standalone test case removes any ambiguity as to whether there is a bug in&#010 Smart GWT or a bug
 * in your code, and eliminates the possibility of Isomorphic Support&#010 responding with a "works for me" result due to
 * incomplete information.  Issues with verified&#010 test cases are routed directly to the engineer that authored the
 * relevant Smart GWT&#010 subsystem, often as the new highest priority task.  In addition, the process of preparing a&#010
 * test case very often allows you to solve the issue yourself.&#010 <P>&#010 There are two approaches to test case
 * preparation:&#010 <ol>&#010 <li> Add code to an existing Smart GWT example until you can reproduce the problem&#010 <li>
 * Remove code from your application until it minimally shows the problem and runs standalone&#010 </ol>&#010 <P>&#010 For
 * approach #1, find the nearest match to your use case in the&#010 ${isc.DocUtils.linkForDocNode('FeatureExplorer')}
 * examples or in the other examples accessible from the Examples&#010 folder of the SDK, then try to minimally modify that
 * example to demonstrate your issue.&#010 Feature Explorer examples are a particularly good starting point because you can
 * simply copy&#010 the code from the Feature Explorer to the Eval JS area of the Developer Console and begin&#010 changing
 * it, and if successful this yields a type #1 test case, the easiest for you to&#010 submit and most efficient for
 * Isomorphic to work with.&#010 <P>&#010 For approach #2,&#010 <ol>&#010 <li> If a server is involved in initial page
 * generation (eg a .jsp file), in most cases you&#010 can eliminate many server dependencies <b>and</b> create an easily
 * modifiable starting point&#010 by using the browser's "View Source" feature to save a copy of the generated HTML output
 * as&#010 an .html file in the same directory as the .jsp file that generated it.  Such a file will&#010 generally
 * continue to function (all relative paths are still correct), and can be modified&#010 freely without the need to later
 * revert changes to a .jsp.&#010 <li> Eliminate any code that isn't involved in the interaction.  Keep running the test
 * case&#010 as you eliminate code to ensure you are still seeing the issue (you may solve it this way,&#010 or find key
 * preconditions that you can report to Isomorphic)&#010 <li> For any issue that isn't cosmetic, revert to a default Smart
 * GWT skin&#010 <li> For any necessary RPC/DataSource interactions, spoof the interaction with one of these&#010
 * approaches:&#010 <ul>&#010 <li> switch any DataSources to one of the sample DataSources from the SDK (eg
 * "supplyItem")&#010 if your issue can still be reproduced in this case.&#010 <li> create a small sample dataset in
 * JavaScript directly in the .html file, and use a&#010 {@link com.smartgwt.client.data.DataSource#getClientOnly
 * 'clientOnly DataSource'} with that dataset.&#010 <li> capture server responses verbatim by setting the RPCManager log
 * category to DEBUG, save&#010 the responses as flat files, and set {@link com.smartgwt.client.data.DataSource#getDataURL
 * dataURL} to point at them.&#010 <li> for RPCs, instead of calling the RPCManager, directly call your own callback
 * function,&#010 passing a spoofed RPCResponse that includes just the fields your code depends upon&#010 </ul>&#010 <li>
 * Finally, move your .html file into the stock Smart GWT SDK along with any remaining&#010 dependencies and verify the
 * problem can still be reproduced&#010 </ol>&#010 Having prepared the test case, combine it with the other required issue
 * report information&#010 covered above, and submit it to the <a href='http://forums.smartclient.com/'
 * onclick="window.open('http://forums.smartclient.com/');return false;">forums</a>,&#010 or, if you have Enterprise
 * Support, at the&#010 <a href='http://support.isomorphic.com/'
 * onclick="window.open('http://support.isomorphic.com/');return false;">Customer Support Extranet</a>.&#010 <P>&#010
 * <h4>Adding your own diagnostic categories</h4>&#010 <P>&#010 Calling <code>logWarn()</code> is fine for a log statement
 * you plan to delete at the end of&#010 the debugging session.  However, many log statements have lasting value if you
 * could enable&#010 or disable them only when you need the relevant diagnostics, like Smart GWT's built-in&#010 diagnostic
 * categories.  To do this, pick a priority level less than <code>WARN</code>&#010 (<code>INFO</code> or
 * <code>DEBUG</code>), and call the corresponding method on the Log&#010 class (<code>logInfo()</code> or
 * <code>logDebug()</code>), passing the category name as a&#010 second parameter.  For example:&#010 <pre>&#010  
 * isc.Log.logInfo("first record is: " + &#010                   isc.Log.echo(myGrid.data.get(0)), &#010                 
 * "myGridLoading");&#010 </pre>&#010 This message will no longer appear in the Results Pane by default, because its
 * priority&#010 (<code>INFO</code>) is less than the default of <code>WARN</code>.  To see this message,&#010 open the
 * Logging Preferences menu and pick "More..", then click the "Add" button, enter&#010 "myGridLoading" as the category name
 * and set the priority to <code>INFO</code>.  The message&#010 will now appear next time it is logged.&#010 <P>&#010 Now
 * you have a custom log category that you and other developers can use to debug your&#010 application, subsystem by
 * subsystem.  These diagnostics will be available to you both in&#010 development and production environments.&#010
 * <P>&#010 As with Smart GWT's built-in diagnostics, you may choose to log certain messages in your&#010 custom category
 * at the <code>DEBUG</code> level and a lesser number of messages at the&#010 <code>INFO</code> level, to create different
 * depths of diagnostic output.&#010 <P>&#010 <h4>Logging refinements</h4>&#010 <P>&#010 The core log methods
 * (<code>logDebug()</code>, <code>logInfo()</code>,&#010 <code>logWarn()</code>) and the "echo" facilities
 * (<code>echo()</code> and&#010 <code>echoAll()</code>) are available on every Smart GWT component and Class.  Hence,&#010
 * in many cases, the special JavaScript value "this" will refer to an object that supports&#010 <code>logWarn()</code> et
 * al.  For example:&#010 <pre>&#010     Canvas.create({&#010        ID:"canvasExample",&#010        contents:"Hello
 * World!",&#010        click:"this.logWarn('the Canvas is: ' + this.echo(this))"&#010     });&#010 </pre>&#010 The special
 * value "this" is not always set to a Smart GWT component, for example, in some&#010 kinds of callbacks (eg {@link
 * com.smartgwt.client.widgets.grid.ListGrid#fetchData}).  When in doubt, use these&#010 methods via the Log class as
 * <code>isc.Log.logWarn()</code>.&#010 <P>&#010 <b>Logging performance</b>&#010 <P>&#010 Because the log message is
 * actually formed <i>before</i> the call to the log system, logs&#010 that are suppressed can still carry a performance
 * penalty.  This is particularly true of&#010 logs that output a lot of data or occur frequently.  To avoid this penalty,
 * you can check in&#010 advance whether a message will be suppressed using &#010 {@link
 * com.smartgwt.client..Class#logIsDebugEnabled} and&#010 {@link com.smartgwt.client..Class#logIsInfoEnabled}.  For
 * example:&#010 <pre>&#010   if (isc.Log.logIsInfoEnabled("myGridLoading")) {&#010      isc.Log.logInfo("first record is:
 * " +&#010                      isc.Log.echo(myGrid.data.get(0)),&#010                      "myGridLoading");&#010  
 * }&#010 </pre>&#010 Generally, it is only important to do this for logs that will occur multiple times during a&#010
 * given user interaction (eg a mousedown or keypress) and/or that call <code>echo()</code> on&#010 objects with many
 * properties.
 */
public interface Debugging {
}
