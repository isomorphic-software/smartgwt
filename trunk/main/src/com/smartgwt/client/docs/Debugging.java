
package com.smartgwt.client.docs;

/**
 * <h3>Debugging</h3>
 * <h4>Built-in Diagnostics</h4>
 *  <P>
 *  In any page in which ISC has been loaded, you have access to the Developer Console,
 *  which can be opened by entering the following URL into your browser from the running
 *  application:
 *  <pre>
 *      javascript:isc.showConsole()</pre>
 *  Basic information on the features of the Developer Console can be found in the QuickStart
 *  Guide.  This topic focuses on use of the log system and related debugging facilities.
 *  <P>
 *  The Developer Console contains a "Results" pane that displays a list of diagnostic
 *  messages logged by the Smart GWT framework. The "Logging Preferences" menu lets you
 *  enable and disable Smart GWT's built-in diagnostics in several categories. Because
 *  important diagnostic messages may be logged at any time, you should have the Developer
 *  Console open whenever you are working with Smart GWT (and you should bookmark the
 *  "javascript:" expression above to make this easier).
 *  <P>
 *  Log messages are of the format:
 *  <P>
 *  &nbsp;&nbsp;&nbsp;<i>timestamp</i>:<i>priority</i>:<i>category</i>:<i>message</i>
 *  <P>
 *  For example, the following log message:
 *  <pre>
 *      11:59:25:806:INFO:Page:Page loading complete.</pre>
 *  Occurred at 11:59:25 local time and 806 milliseconds.  It's priority was <code>INFO</code>,
 *  it occurred in the category <i>Page</i>, and the message is "Page loading complete.".
 *  <P>
 *  Each logging <i>category</i> has a <i>priority</i> associated with it.  If a message's
 *  priority is lower than the current priority for the category it is logged in, the
 *  message will be suppressed (will not appear in the "Results" pane).  
 *  <p>
 *  It is critical to be familiar with the diagnostic categories built-in to Smart GWT - 
 *  you will use them in most debugging sessions.  Open the Logging Preferences menu and select
 *  "More.." to see a list of diagnostic log categories.   Hover over each category name to
 *  see a description of what kind of messages are logged in the category.  
 *  <P>
 *  <h4>Debugging JavaScript Errors</h4>
 *  <P>
 *  Isomorphic recommends the FireFox browser as the primary development platform.  In FireFox,
 *  JavaScript errors are reported both in the Smart GWT Developer Console and in the FireFox
 *  JavaScript console, which can be opened by entering the special
 *  url "javascript:" in the address bar.
 *  <P>
 *  Isomorphic currently recommends that every Smart GWT developer install either the 
 * <a href='https://addons.mozilla.org/firefox/1815/'
 * onclick="window.open('https://addons.mozilla.org/firefox/1815/');return false;">Console2</a> or
 * <a href='http://www.getfirebug.com/' onclick="window.open('http://www.getfirebug.com/');return false;">Firebug</a>
 * extensions for FireFox.  "Console2" simply
 *  replaces the default FireFox JavaScript console with a more functional console;
 *  Firebug aims to be a true debugger.  Both tools will typically load or identify the correct
 *  file and line number where a JS error occurred.
 *  <P>
 *  In Internet Explorer, when JS errors occur, Smart GWT is able to report full stack traces
 *  in the Developer Console.  This can be invaluable when your code triggers a JS error
 *  in the Smart GWT libraries themselves, or when it is unclear how your code is being
 *  called.  Stack traces from Internet Explorer should <i>always</i> be included in issue
 *  reports sent to Isomorphic Software, if at all possible. 
 *  <P>
 *  <h4>Inspecting application state</h4>
 *  <P>
 *  The "Evaluate JS Expression" area of the Results Pane in the Developer Console can be used
 *  to inspect the current state of a Smart GWT application.  Any Smart GWT or browser
 *  built-in API can be called from the "Evaluate JS Expression" area, and the results will
 *  be intelligently summarized (via  Log.echo).  For example, simply typing a
 *  component's ID and pressing the "Eval JS" button will give you a dump of it's current
 *  property values.  
 *  <P>
 *  Many, many Smart GWT APIs can be usefully called while troubleshooting, eg, 
 * {@link com.smartgwt.client.widgets.grid.ListGrid#getData data} is a {@link com.smartgwt.client.data.ResultSet} when a
 * grid is DataBound and 
 * {@link com.smartgwt.client.data.ResultSet#get ResultSet.get} can be called to inspect the current values on records.  In
 * addition,
 *  new application code can be tried out, for example, you might repeatedly instantiate a new
 *  component, trying variants on the properties you could give it.
 *  <P>
 *  <b>Inspecting transient application state with logs</b>
 *  <P>
 *  Transient state, such as the values of local variables in a method that is crashing, can be
 *  sent to the Developer Console via using the Log class.  For example, to dump the
 *  value of the local variable "request": 
 *  <pre>
 *      isc.logWarn("request is: " + isc.echo(request));
 *  </pre>
 *  <P>
 *  It's a good idea to dump the values of local variables in any method that is crashing or
 *  behaving unexpectedly.
 *  <P>
 *  Note the use of {@link com.smartgwt.client.util.isc#logWarn logWarn()} above: in typical debugging sessions,
 *  it's best
 *  to simply use <code>logWarn</code> method to output diagnostics to ensure your message will
 *  not be suppressed by log priority settings.
 *  <P>
 *  NOTE: never use the native <code>alert()</code> method to output diagnostics.  Among other
 *  issues, <code>alert()</code> can affect timing, masking or altering the behavior you were
 *  trying to debug.  Smart GWT's logging system doesn't suffer from these problems and
 *  provides much more control.
 *  <P>
 *  <h4>Issue Reports</h4>
 *  <P>
 *  If you believe you've discovered a bug in Smart GWT or you are having trouble using
 * Smart GWT APIs, you can report it at <a href='http://forums.smartclient.com/'
 * onclick="window.open('http://forums.smartclient.com/');return false;">http://forums.smartclient.com/</a>, or, if
 *  you have Enterprise Support, at the 
 * <a href='http://support.isomorphic.com/' onclick="window.open('http://support.isomorphic.com/');return false;">Customer
 * Support Extranet</a>.
 *  <P>
 *  <b>How quickly your issue is resolved is entirely up to you</b>.  If you follow the steps
 *  below and submit an appropriate issue report, you will generally receive a rapid solution
 *  from Isomorphic Support, regardless of what support level you have, because Isomorphic
 *  aggressively corrects bugs and legitimate usage issues.  If you skip steps you are likely to
 *  be directed back to this document and asked to submit a more complete issue report.
 *  <P>
 *  Before reporting an issue, ensure that you:
 *  <ul>
 *  <li> Have read the ${isc.DocUtils.linkForDocNode('QuickStartGuide', 'QuickStart Guide')} cover to
 *  cover.  Later chapters cover more advanced topics and provide links to further examples and
 *  reference.
 *  <li> Have searched the ${isc.DocUtils.linkForDocNode('FeatureExplorer', 'Feature Explorer')} for examples that show
 *  what you are trying to do
 *  <li> Have searched this reference, trying multiple searches using different, common and
 *  related terms for what you are trying to do (eg for search, try "search", "filter",
 *  "criteria", "find", "match", etc)
 * <li> Have searched the public <a href='http://forums.smartclient.com'
 * onclick="window.open('http://forums.smartclient.com');return false;">forums</a>
 *  </ul>
 *  Always include:
 *  <ul>
 *  <li> A description of what you are trying to accomplish <b>from a user's perspective</b>.
 *  The best answers often point out a simpler approach.
 *  <li> The browser(s), operating system(s) and Smart GWT version(s) you experience the error
 *  on (Smart GWT version is available in the lower-left handle corner of the Developer
 *  Console)
 *  </ul>
 *  Then, include <b>either</b> a standalone test case (see below), <b>or</b>:
 *  <ul>
 *  <li> For JS errors, Stack traces from Firebug (for Firefox) or the Developer Console (for
 *  IE), as covered under "Debugging JavaScript Errors" above
 *  <li> Results of calling <code>echo()</code> on local variables or other application
 *  state you think is relevant (see "Inspecting Application State" above)
 *  <li> What server platform and {@link com.smartgwt.client.docs.ClientServerIntegration databinding approach} you
 *  are using, if applicable
 *  <li> contents of the Smart GWT Developer Console "Log messages" area, with appropriate
 *  diagnostic categories set the DEBUG or INFO level (see "Built-in Diagnostics" above)
 *  <li> sample code and sample data
 *  </ul>
 *  <b>Preparing a standalone test case</b>
 *  <P>
 *  A standalone test case is one of:
 *  <ol>
 *  <li> a chunk of JavaScript code that can be executed from the "Eval JS" area of the
 *  Developer Console on some specified page within the unmodified Smart GWT SDK,
 *  demonstrating your issue
 *  <li> an .html or .jsp file that can be dropped at a specified location into an unmodified
 *  Smart GWT SDK and will run without changes, demonstrating your issue.
 *  <li> a .zip file that includes a standalone .html/.jsp file  as above, as well as
 *  dependencies required to make the test case runnable, such as XML datasets
 *  </ol>
 *  <P>
 *  Submitting a standalone test case removes any ambiguity as to whether there is a bug in
 *  Smart GWT or a bug in your code, and eliminates the possibility of Isomorphic Support
 *  responding with a "works for me" result due to incomplete information.  Issues with verified
 *  test cases are routed directly to the engineer that authored the relevant Smart GWT
 *  subsystem, often as the new highest priority task.  In addition, the process of preparing a
 *  test case very often allows you to solve the issue yourself.
 *  <P>
 *  There are two approaches to test case preparation:
 *  <ol>
 *  <li> Add code to an existing Smart GWT example until you can reproduce the problem
 *  <li> Remove code from your application until it minimally shows the problem and runs standalone
 *  </ol>
 *  <P>
 *  For approach #1, find the nearest match to your use case in the
 *  ${isc.DocUtils.linkForDocNode('FeatureExplorer')} examples or in the other examples accessible from the Examples
 *  folder of the SDK, then try to minimally modify that example to demonstrate your issue.
 *  Feature Explorer examples are a particularly good starting point because you can simply copy
 *  the code from the Feature Explorer to the Eval JS area of the Developer Console and begin
 *  changing it, and if successful this yields a type #1 test case, the easiest for you to
 *  submit and most efficient for Isomorphic to work with.
 *  <P>
 *  For approach #2,
 *  <ol>
 *  <li> If a server is involved in initial page generation (eg a .jsp file), in most cases you
 *  can eliminate many server dependencies <b>and</b> create an easily modifiable starting point
 *  by using the browser's "View Source" feature to save a copy of the generated HTML output as
 *  an .html file in the same directory as the .jsp file that generated it.  Such a file will
 *  generally continue to function (all relative paths are still correct), and can be modified
 *  freely without the need to later revert changes to a .jsp.
 *  <li> Eliminate any code that isn't involved in the interaction.  Keep running the test case
 *  as you eliminate code to ensure you are still seeing the issue (you may solve it this way,
 *  or find key preconditions that you can report to Isomorphic)
 *  <li> For any issue that isn't cosmetic, revert to a default Smart GWT skin
 *  <li> For any necessary RPC/DataSource interactions, spoof the interaction with one of these
 *  approaches:
 *  <ul>
 *  <li> switch any DataSources to one of the sample DataSources from the SDK (eg "supplyItem")
 *  if your issue can still be reproduced in this case.
 *  <li> create a small sample dataset in JavaScript directly in the .html file, and use a
 *  {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly DataSource} with that dataset.
 *  <li> capture server responses verbatim by setting the RPCManager log category to DEBUG, save
 *  the responses as flat files, and set {@link com.smartgwt.client.data.DataSource#getDataURL dataURL} to point at them.
 *  <li> for RPCs, instead of calling the RPCManager, directly call your own callback function,
 *  passing a spoofed RPCResponse that includes just the fields your code depends upon
 *  </ul>
 *  <li> Finally, move your .html file into the stock Smart GWT SDK along with any remaining
 *  dependencies and verify the problem can still be reproduced
 *  </ol>
 *  Having prepared the test case, combine it with the other required issue report information
 * covered above, and submit it to the <a href='http://forums.smartclient.com/'
 * onclick="window.open('http://forums.smartclient.com/');return false;">forums</a>,
 *  or, if you have Enterprise Support, at the
 * <a href='http://support.isomorphic.com/' onclick="window.open('http://support.isomorphic.com/');return false;">Customer
 * Support Extranet</a>.
 *  <P>
 *  <h4>Adding your own diagnostic categories</h4>
 *  <P>
 *  Calling <code>logWarn()</code> is fine for a log statement you plan to delete at the end of
 *  the debugging session.  However, many log statements have lasting value if you could enable
 *  or disable them only when you need the relevant diagnostics, like Smart GWT's built-in
 *  diagnostic categories.  To do this, pick a priority level less than <code>WARN</code>
 *  (<code>INFO</code> or <code>DEBUG</code>), and call the corresponding method on the Log
 *  class (<code>logInfo()</code> or <code>logDebug()</code>), passing the category name as a
 *  second parameter.  For example:
 *  <pre>
 *    isc.Log.logInfo("first record is: " + 
 *                    isc.Log.echo(myGrid.data.get(0)), 
 *                   "myGridLoading");
 *  </pre>
 *  This message will no longer appear in the Results Pane by default, because its priority
 *  (<code>INFO</code>) is less than the default of <code>WARN</code>.  To see this message,
 *  open the Logging Preferences menu and pick "More..", then click the "Add" button, enter
 *  "myGridLoading" as the category name and set the priority to <code>INFO</code>.  The message
 *  will now appear next time it is logged.
 *  <P>
 *  Now you have a custom log category that you and other developers can use to debug your
 *  application, subsystem by subsystem.  These diagnostics will be available to you both in
 *  development and production environments.
 *  <P>
 *  As with Smart GWT's built-in diagnostics, you may choose to log certain messages in your
 *  custom category at the <code>DEBUG</code> level and a lesser number of messages at the
 *  <code>INFO</code> level, to create different depths of diagnostic output.
 *  <P>
 *  <h4>Logging refinements</h4>
 *  <P>
 *  The core log methods (<code>logDebug()</code>, <code>logInfo()</code>,
 *  <code>logWarn()</code>) and the "echo" facilities (<code>echo()</code> and
 *  <code>echoAll()</code>) are available on every Smart GWT component and Class.  Hence,
 *  in many cases, the special JavaScript value "this" will refer to an object that supports
 *  <code>logWarn()</code> et al.  For example:
 *  <pre>
 *      Canvas.create({
 *         ID:"canvasExample",
 *         contents:"Hello World!",
 *         click:"this.logWarn('the Canvas is: ' + this.echo(this))"
 *      });
 *  </pre>
 *  The special value "this" is not always set to a Smart GWT component, for example, in some
 * kinds of callbacks (eg {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData fetchData()}).  When in doubt, use
 * these
 *  methods via the Log class as <code>isc.Log.logWarn()</code>.
 *  <P>
 *  <b>Logging performance</b>
 *  <P>
 *  Because the log message is actually formed <i>before</i> the call to the log system, logs
 *  that are suppressed can still carry a performance penalty.  This is particularly true of
 *  logs that output a lot of data or occur frequently.  To avoid this penalty, you can check in
 *  advance whether a message will be suppressed using 
 *   isc.Log.logIsDebugEnabled() and
 *   isc.Log.logIsInfoEnabled().  For example:
 *  <pre>
 *    if (isc.Log.logIsInfoEnabled("myGridLoading")) {
 *       isc.Log.logInfo("first record is: " +
 *                       isc.Log.echo(myGrid.data.get(0)),
 *                       "myGridLoading");
 *    }
 *  </pre>
 *  Generally, it is only important to do this for logs that will occur multiple times during a
 *  given user interaction (eg a mousedown or keypress) and/or that call <code>echo()</code> on
 *  objects with many properties.
 */
public interface Debugging {
}
