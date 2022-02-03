
package com.smartgwt.client.docs;

/**
 * <h3>Debugging</h3>
 * 
 *  <h4>Development Modes in GWT</h4>
 *  GWT applications are written in Java but compiled to JavaScript to be run on the browser.
 *  During application development, code is typically deployed for testing using either
 *  Development Mode (formerly known as "Super Dev Mode"), or Legacy Development Mode.
 *  <P>
 * Legacy <a
 * href='http://www.gwtproject.org/doc/latest/DevGuideCompilingAndDebugging.html#dev_mode'
 * target='_blank'>Development Mode</a>,
 *  runs your Java code in an actual Java VM attached to the browser via a browser plugin,
 *  and is being phased out of the GWT project in favor of a new Development Mode approach
 *  which translates your Java code into JavaScript before running it, 
 *  even when debugging.
 *  <p>
 *  In the new
 * <a href='http://www.gwtproject.org/articles/superdevmode.html' target='_blank'>Development
 * mode</a>
 *  (formerly referred to as Super Dev Mode), 
 * <a href='https://developer.chrome.com/devtools/docs/javascript-debugging#source-maps'
 * target='_blank'>source maps</a> 
 *  provided by a GWT Code Server Java app allow breakpoints to be placed at chosen locations
 *  within the Java source code.  Running this mode in GWT 2.7.0+ is possible by just
 *  launching the (Super) Dev Mode Server in Eclipse using a <i>Web Application</i> Run
 *  Configuration.  This should be available under Run Configurations if the 
 * <a href='http://www.gwtproject.org/download.html' target='_blank'>GWT 2.7.0 Eclipse Plugin</a>
 * has been
 *  installed.  Under such a configuration, the Code Server will be automatically run
 *  for you and source maps loaded whenever you reload the web application in your browser.
 *  <P>
 *  For earlier versions of GWT, running Super Dev mode requires:
 *  <ul>
 * <li> Adding a bit of additional configuration to your GWT project file (gwt.xml) and rebuilding
 *  <li> Running the GWT Code Server Java App (either from the command line or from Eclipse)
 *  </ul><p>
 *  Once these two steps have been completed, you can run the web application through Eclipse,
 *  or deploy it manually to an existing web server.  The code server can then be invoked
 *  by a browser bookmark and the source maps for your project navigated to place breakpoints
 *  where needed.
 *  <P>
 *  Testing with SmartGWT and GWT 2.7.0 and 2.8.x have shown that Google Chrome,
 * <a href='https://www.mozilla.org/en-US/firefox/organizations/' target='_blank'>Firefox 60
 * ESR</a>, and IE11
 *  all support source maps when connecting to Eclipse in Super Development Mode, and allow you
 *  to set breakpoints in Java source which are properly hit during execution to permit stepping.
 *  (Newer, non-ESR versions of Firefox should work as well, but (now unsupported) Firefox 52 ESR
 *  does not).  Note that to connect to Super Development Mode remotely with source map support,
 *  you must configure Eclipse to run SDM with the -bindAddress argument set to your external IP.
 *  For further information, see the official overview and command-line option listing for
 * <a href='http://www.gwtproject.org/articles/superdevmode.html' target='_blank'>Super
 * Development Mode</a>.
 *  <p>
 * <i>Refer to {@link com.smartgwt.client.docs.SuperDevModeTroubleshooting Troubleshooting Super
 * Dev Mode} for more
 *  detailed help running Super Dev Mode.</i>
 *  <P>
 *  Legacy Development Mode is deprecated and support may disappear in future releases of GWT.
 *  The only current browser that works with Legacy Dev Mode is IE11 on Windows, and it does
 *  seem to hit fewer runtime exceptions and crash less often during debugging of Legacy Dev Mode
 *  than the next best choice, an older version of Firefox, such as
 * <a href='https://ftp.mozilla.org/pub/firefox/releases/24.8.1esr/' target='_blank'>Firefox
 * 24ESR</a>
 *  (which is only supported until 10/14/2014).  There are no plans to re-add support in current
 *  versions of Firefox.  Chrome's Development Mode also cannot be used because of
 * <a href='http://forums.smartclient.com/showthread.php?t=8159#aChrome'
 * target='_blank'>limitations of Chrome</a> 
 *  that break core GWT functionality.
 *  <P>
 *  <h4>Stack Details</h4>
 *  When not using one of the GWT development modes described above, the stack trace presented in
 *  the Smart GWT Developer Console will consist of obfuscated method names and provide little
 *  helpful information.  Useful unobfuscated traces may be obtained by adding "-optimize 0" and
 *  "-style DETAILED" or "-style PRETTY" to the gwtc ant target in the build.xml file for your
 *  project.  A more useful stack trace in certain cases can sometimes be obtained by activating
 *  GWT "stack emulation".  To do this, set the property <code>compiler.stackMode</code> to
 *  "emulated" and <code>compiler.emulatedStack.recordLineNumbers</code> to "true" in your
 *  gwt.xml project file.  (Note that enabling stack emulation will increase the size of the
 *  JavaScript files generated by GWT.)  Examples of both of these enhancements are provided 
 *  as commented-out lines in the appropriate files of the BuiltInDS SGWT sample 
 *  <P>
 *  Note that due to how GWT compiles Java code into JavaScript, the top of the stack may
 *  actually go deeper than expected in the visible trace when a crash in the Java code occurs.
 *  So for example if you try to invoke a method on a null object like:
 *  <pre>
 *      ListGrid listGrid = null;
 *      listGrid.setWidth100();</pre>
 *  then the actual Development Console error will look something like:
 *  <pre>
 *  23:11:44.461:WARN:Log:TypeError: this$static is null
 *  Stack from error.stack:
 *      $isCreated_4() @ showcase/239D5C0DDE9A2775E194CC3519D90866.cache.html:22080:7
 *      $setAttribute_20() @ showcase/239D5C0DDE9A2775E194CC3519D90866.cache.html:22132:3
 *      $setWidth_3() @ showcase/239D5C0DDE9A2775E194CC3519D90866.cache.html:23349:3
 *      $setWidth100() @ showcase/239D5C0DDE9A2775E194CC3519D90866.cache.html:23353:3
 *          :</pre>
 *  (where -optimize 0 and -style PRETTY have been added to build.xml as mentioned above).
 *  This is because the JavaScript code emitted by GWT for <code>setWidth100()</code>,
 *  <code> setWidth()</code>, and <code>setAttribute()</code> never actually attempts
 *  to access the widget (<code>this$static</code>) until execution reaches 
 *  <code>BaseWidget.isCreated()</code>.
 *  <P>
 *  
 *  <h4>Built-in Diagnostics</h4>
 *  <P>
 * The Smart GWT Developer Console is a suite of development tools implemented in Smart GWT
 * itself. 
 * The Console runs in its own browser window, parallel to your running application, so it is
 * always 
 *  available in every browser, and in every deployment environment.
 *  <P>
 * The Developer Console can be opened by calling <code>isc.showConsole()</code> on any page in
 * which 
 * Smart GWT has been loaded. You can create a bookmark in your browser to quickly show the
 * Console on 
 *  any Smart GWT application, without any changes to the application code:
 *  <P>
 *  1. Create a new bookmark in your browser.<BR>
 *  2. Enter url "javascript:isc.showConsole()".<BR>
 *  3. Label the bookmark as "Show Console".<BR>
 *  4. Consider adding this to the Bookmarks Toolbar. This allows one-click access to the Console 
 *  from any Smart GWT application.
 *  <P>
 * Note: For most browsers you can evaluate javascript directly from the browser URL bar by
 * entering 
 * <code>javascript:<i>string to evaluate</i></code> directly in the URL bar, so setting up a
 * bookmark 
 * is not strictly necessary. For Firefox 6 and above, this feature has been disallowed, but the
 * bookmark 
 *  approach will still work. Alternatively developers could use 
 * <a href='http://blog.mozilla.com/devtools/2011/08/15/introducing-scratchpad/'
 * target='_blank'>Firefox Scratchpad</a> 
 *  to launch the console.
 *  <P>
 *  Basic information on the features of the Developer Console can be found in the QuickStart
 *  Guide.  For information about the "RPC" tab of the Developer Console and the request 
 *  profiling information it can provide, see 
 * {@link com.smartgwt.client.docs.DevConsoleRPCTab the Developer Console RPC tab}.  The Develper
 * Console also
 *  supports debugging of remote pages (very useful for mobile devices) - see
 *  {@link com.smartgwt.client.docs.RemoteDebugging} for more information.  The remainder of this 
 *  topic focuses on use of the log system and related debugging facilities.
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
 * Javascript errors will typically be reported in the Developer Console. Wherever possible a
 * stack 
 *  trace will be included which can help determine the cause of the error.
 * In addition to this, recent versions of the Firefox browser (versions 6.0 and above) ship with
 * some 
 * useful development tools including the Error Console for reporting errors. We also recommend
 * Console2 
 *  and Firebug for debugging in Firefox.
 *  <P>
 *  When JavaScript errors occur, Smart GWT is usually able to report full stack traces
 *  in the Developer Console.  This can be invaluable when your code triggers a JavaScript error
 *  in the Smart GWT libraries themselves, or when it is unclear how your code is being
 * called.  Stack traces from the Developer Console Explorer should <i>always</i> be included in
 * issue
 *  reports sent to Isomorphic Software, if at all possible.
 *  
 *  <P>
 *  <h4>Inspecting application state</h4>
 *  <P>
 *  The "Evaluate JS Expression" area of the Results Pane in the Developer Console can be used
 *  to inspect the current state of a Smart GWT application by running JavaScript code.
 *  The result of any expression you evaluate will be intelligently summarized (via
 *   Log.echo()).  For example, simply typing a component's ID and pressing the "Eval JS"
 *  button will give you a dump of it's current property values. 
 *  
 *  <p>
 *  Note that when using the "Evaluate JS Expression" area, since you are writing code in
 *  JavaScript, if you call a method on a component via evaluating an expression like
 *  "<i>componentId.someMethod()</i>", you are calling a &#83;martClient JavaScript API.  Most
 *  of the time, component APIs have the same name and same function in &#83;martClient as in
 *  Smart GWT, so you can use such APIs to inspect or modify the runtime state of components
 *  without being proficient in &#83;martClient.  You can refer to the &#83;martClient Reference
 *  available at
 * <a href='http://www.smartclient.com/product/documentation.jsp'
 * target='_blank'>Isomorphic.com</a> for
 *  details on API differences.
 *  
 *  <p>
 *  Many, many component APIs can be usefully called while troubleshooting, eg, 
 * {@link com.smartgwt.client.widgets.grid.ListGrid#getData ListGrid.data} is a {@link
 * com.smartgwt.client.data.ResultSet} when a grid is DataBound and 
 * {@link com.smartgwt.client.data.ResultSet#get ResultSet.get()} can be called to inspect the
 * current values on records.  
 *  
 *  
 *  <p>
 *  Note that methods you have added to a component in Java via GWT will not be present.  You
 *  can only invoke Java methods via JavaScript if you are familiar with the (possibly
 *  obfuscated) JavaScript names that GWT produces for those methods.
 *  
 *  <P>
 *  <b>Inspecting transient application state with logs</b>
 *  <P>
 *  Transient state, such as the values of local variables in a method that is crashing, can be
 *  sent to the Developer Console via using the 
 *  <a href='../util/SC.html' target='_blank'>SC</a> class.  For example, to dump the
 *  value of a local instance of 
 *   Debugging.DataClass "request":
 *  
 *  <pre>
 *      SC.logWarn("request is: " + SC.logEcho(request.getJsObj()));</pre>
 *  
 *  It's a good idea to dump the values of local variables in any method that is crashing or
 *  behaving unexpectedly.
 *  <P>
 *  Note the use of 
 *  <a href='../util/SC.html#logWarn(java.lang.String)' target='_blank'>SC.logWarn()</a>
 *  above: in typical debugging sessions, it's best to simply use the <code>logWarn</code> method
 *  to output diagnostics to ensure your message will not be suppressed by log priority settings.
 *  <P>
 *  
 *  <h4>Issues with the Smart GWT Server</h4>
 * The {@link com.smartgwt.client.docs.IscServer Smart GWT Server} has extensive diagnostic
 * logging capabilities. 
 * See the {@link com.smartgwt.client.docs.ServerLogging Server Logging topic} for details on how
 * to configure
 *  logging.<br>
 *  Developers experiencing java thread deadlocks on the server should also consult the
 * troubleshooting steps documented {@link com.smartgwt.client.docs.TroubleshootingServerDeadlocks
 * here}.
 *  
 *  <h4>Issue Reports</h4>
 *  <P>
 *  If you believe you've discovered a bug in Smart GWT or you are having trouble using
 *  Smart GWT APIs, you can report it in 
 *  <a href='http://forums.smartclient.com/' target='_blank'>the Smart GWT Forums</a>.
 *  <P>
 *  <b>How quickly your issue is resolved is entirely up to you</b>.  If you follow the steps
 *  below and submit an appropriate issue report, you will generally receive a rapid solution
 *  from Isomorphic Support, regardless of what support level you have, because Isomorphic
 *  aggressively corrects bugs and legitimate usage issues.  If you skip steps you are likely to
 *  be directed back to this document and asked to submit a more complete issue report.
 *  <P>
 *  Before reporting an issue, ensure that you:
 *  <ul>
 *  <li> Have read the 'QuickStart Guide' cover to
 *  cover.  Later chapters cover more advanced topics and provide links to further examples and
 *  reference.
 *  <li> Have searched the 
 *  
 *  SGWT Showcase from your installation (e.g.
 * <a href='http://www.smartclient.com/smartgwt/showcase/' target='_blank'>SGWT LGPL Showcase</a>
 * /
 * <a href='http://www.smartclient.com/smartgwtee/showcase/' target='_blank'>SGWT EE Showcase</a>)
 *  
 *  for examples that show what you are trying to do
 *  <li> Have searched this reference, trying multiple searches using different, common and
 *  related terms for what you are trying to do (eg for search, try "search", "filter",
 *  "criteria", "find", "match", etc)
 * <li> Have searched the public <a href='http://forums.smartclient.com'
 * target='_blank'>forums</a>
 *  </ul>
 *  Always include:
 *  <ul>
 *  <li> A description of what you are trying to accomplish <b>from an end user's perspective</b>.
 *  The best answers often point out a simpler approach.
 *  <li> The browser(s), operating system(s) and Smart GWT version(s) you experience the error
 *  on (Smart GWT version is available in the lower-left handle corner of the Developer
 *  Console)
 *  </ul>
 *  Then, include <b>either</b> a standalone test case (see below), <b>or</b>:
 *  <ul>
 *  <li> For JS errors, Stack traces from Firebug (for Firefox) or the Developer Console (for
 *  IE), as covered under "Debugging JavaScript Errors" above
 * <li> What server platform and {@link com.smartgwt.client.docs.ClientServerIntegration
 * databinding approach} you
 *  are using, if applicable
 *  <li> contents of the Smart GWT Developer Console "Log messages" area, with appropriate
 *  diagnostic categories set the DEBUG or INFO level (see "Built-in Diagnostics" above)
 *  <li> for any problem involving server contact, the complete server-side log for the request
 *  that fails or produces unexpected results
 *  
 *  <li> if using GWT Development Mode, any exceptions reported from Java in Eclipse
 *  
 *  <li> Results of calling <code>echo()</code> on local variables or other application
 *  state you think is relevant (see "Inspecting Application State" above)
 *  <li> sample code and sample data
 *  </ul>
 *  <b>Preparing a standalone test case</b>
 *  <P>
 *  A standalone test case is one of:
 *  <ol>
 *  <li>a modified version of one of our sample projects, such as the BuiltInDS sample
 *  with BuiltInDS.java changed to demonstrate your issue
 *  <li>a modified version of any one of our SGWT Showcase samples (e.g. GridSortSample);
 *  choosing one that requires only a slight modification to demonstrate your issue is best
 *  </ol>
 *  Note: Ideally this results in a single Java file you provide to us if possible.
 *  
 *  <P>
 *  Submitting a standalone test case removes any ambiguity as to whether there is a bug in
 *  Smart GWT or a bug in your code, and eliminates the possibility of Isomorphic Support
 *  responding with a "works for me" result due to incomplete information.  Issues with verified
 *  test cases are routed directly to the engineer that authored the relevant Smart GWT
 *  subsystem, often as the new highest priority task.  In addition, the process of preparing a
 *  test case very often allows you to solve the issue yourself, if the underlying issue is not
 *  actually a framework bug.
 *  <P>
 *  There are two approaches to test case preparation:
 *  <ol>
 *  <li> Add code to an existing 
 *  SGWT Showcase sample until you can reproduce the problem
 * <li> Remove code from your application until it minimally shows the problem and runs standalone
 *  </ol>
 *  <P>
 *  For approach #1, find the nearest match to your use case in the 
 *  
 *  SGWT Showcase samples or in the sample projects included in the SGWT download package, then
 *  try to minimally modify that sample to demonstrate your issue.  This should yield a 
 *  #1 test case,
 *  
 *  the easiest for you to submit and most efficient for Isomorphic to work with.
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
 * <li> switch any DataSources to one of the sample DataSources from the SGWT Showcase (e.g.
 * ItemSupplyXmlDS)
 *  if your issue can still be reproduced in this case.
 *  <li> create a small sample dataset in Java directly in the Java sample file and use a
 * {@link com.smartgwt.client.data.DataSource#getClientOnly clientOnly DataSource} with that
 * dataset.
 *  <li> capture server responses verbatim by setting the RPCManager log category to DEBUG, save
 * the responses as flat files, and set {@link com.smartgwt.client.data.DataSource#getDataURL
 * DataSource.dataURL} to point at them.
 *  <li> for RPCs, instead of calling the RPCManager, directly call your own callback function,
 *  passing a spoofed RPCResponse that includes just the fields your code depends upon
 *  </ul>
 *  
 *  
 *  <li> Finally, move your Java file into one of the stock SGWT sample projects,
 *  such as the BuiltInDS sample,
 *  along with any remaining dependencies and verify the problem can still be reproduced
 *  </ol>
 *  Having prepared the test case, combine it with the other required issue report information
 * covered above, and submit it to the <a href='http://forums.smartclient.com/'
 * target='_blank'>forums</a>,
 *  or, if you have Enterprise Support, at the
 *  <a href='http://support.isomorphic.com/' target='_blank'>Customer Support Extranet</a>.
 *  <P>
 *  <h4>Using the Debug Modules (Advanced)</h4>
 *  <P>
 *  See {@link com.smartgwt.client.docs.DebugModules Using the Debug Modules}.
 *  <P>
 *  <h4>Adding your own diagnostic categories</h4>
 *  <P>
 *  Calling <code>logWarn()</code> is fine for a log statement you plan to delete at the end of
 *  the debugging session.  However, many log statements have lasting value if you could enable
 *  or disable them only when you need the relevant diagnostics, like Smart GWT's built-in
 *  diagnostic categories.  To do this, pick a priority level less than <code>WARN</code>
 *  (<code>INFO</code> or <code>DEBUG</code>), and call the corresponding method on the 
 *  SC class (<code>logInfo()</code> or
 *  <code>logDebug()</code>), passing the category name as a second parameter.  For example:
 *  
 *  <pre>
 *      Sc.logInfo("first record is: " + 
 *                 SC.logEcho(myGrid.getDataAsRecordList().get(0).getJsObj()),
 *                 "myGridLoading");
 *  </pre>
 *  
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
 *  
 *  <b>Find the source of logs</b>
 *  Sometimes, you will see a log message with a warning, usage error or other unusual condition,
 * and it won't be clear how your code is causing the log to appear.  In these situations, you can
 *  use  Log.traceLogMessage() to request that a stack trace is logged whether that specific
 *   message appears.
 *  <b>Logging performance</b>
 *  <P>
 *  Because the log message is actually formed <i>before</i> the call to the log system, logs
 *  that are suppressed can still carry a performance penalty.  This is particularly true of
 *  logs that output a lot of data or occur frequently.  To avoid this penalty, you can check in
 *  advance whether a message will be suppressed using
 *  
 * <a href='../util/SC.html#logIsDebugEnabled(java.lang.String)'
 * target='_blank'>SC.logIsDebugEnabled()</a> and
 * <a href='../util/SC.html#logIsInfoEnabled(java.lang.String)'
 * target='_blank'>SC.logIsInfoEnabled()</a>.
 *  For example:
 *  <pre>
 *      if (SC.logIsInfoEnabled("myGridLoading")) {
 *          SC.logInfo("first record is: " +
 *                     SC.logEcho(myGrid.getDataAsRecordList().get(0).getJsObj()),
 *                     "myGridLoading");
 *      }
 *  </pre>
 *  
 *  Generally, it is only important to do this for logs that will occur multiple times during a
 *  given user interaction (eg a mousedown or keypress) and/or that call <code>echo()</code> on
 *  objects with many properties.
     * @see com.smartgwt.client.docs.ServerLogging
     * @see com.smartgwt.client.docs.RemoteDebugging
 */
public interface Debugging {
}
