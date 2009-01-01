/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */

 


// The log functions below will always be defined even with DEBUG> <DEBUG blocks stripped, so that 
// if an end user calls a log function and forgets to mark it with DEBUG, it doesn't result in a
// JS error.

// write special log accessor functions for Class instances so we can call them
isc._logMethods = 
{
    
	logMessage : function (priority, message, category, timestamp) {
        var log = isc.Log;
		if (!log) return;

        //>DEBUG
		
        // if no priority was passed in, use the default
        if (priority == null) priority = log.defaultPriority;
		
		// automatically add a stack trace for error logs
		if (priority <= log.stackTracePriority && this.getStackTrace != null) {
			// skip two levels of the stack to avoid showing the logMessage() invocation itself 
			message += "\nStack trace:\n" + this.getStackTrace(arguments, 2);
		}

		// If a category was not specified, use the name of this class.
		if (!category) category = this.Class;

		// actually do the log.  NOTE: if we have an instance ID, pass it
		log.log(priority, message, category, this.ID, this, timestamp);

        //<DEBUG
	},

    //> @method class.logDebug()
    // Log a message at "debug" priority
    // <P>
    // A method named log<i>Priority</i> exists for each priority level, on every ISC Class and
    // instance of an ISC Class.  Messages logged on a Class or instance have a default
    // category of the classname.  Messages logged on an instance will also automatically
    // incorporate the instance ID.  General best practice is to call logDebug() et al as
    // "this.logDebug" whenever "this" is an instance, or as "Log.logDebug" otherwise.
    //
    //     @param message    (String)  message to log
    //     @param [category] (String)  category to log in
    //
    // @see Log.echo() for dumping datastructures to the log
    // @see Log.setPriority() for controlling what messages appear in the log
    // @visibility external
    //<
    //> @classMethod class.logDebug()
    // @include method:class.logDebug
    // @visibility external
    //<
	logDebug : function (message, category) { return this.logMessage(isc.Log.DEBUG, message, category)},

    //> @method class.logInfo()
    // Log a message at "info" priority
    // 
    //     @param message    (String)  message to log
    //     @param [category] (String)  category to log in
    //
    // @see Log.logDebug() for usage info
    // @visibility external
    //<
    //> @classMethod class.logInfo()
    // @include method:class.logInfo
    // @visibility external
    //<
	logInfo : function (message, category) { return this.logMessage(isc.Log.INFO, message, category)},

    //> @method class.logWarn()
    // Log a message at "warn" priority
    // 
    //     @param message    (String)  message to log
    //     @param [category] (String)  category to log in
    //
    // @see Log.logDebug() for usage info
    // @visibility external
    //<
    //> @classMethod class.logWarn()
    // @include method:class.logWarn
    // @visibility external
    //<
	logWarn : function (message, category) { return this.logMessage(isc.Log.WARN, message, category)},

    //> @method class.logError()
    // Log a message at "error" priority
    // 
    //     @param message    (String)  message to log
    //     @param [category] (String)  category to log in
    //
    // @see Log.logDebug() for usage info
    // @visibility external
    //<
    //> @classMethod class.logError()
    // @include method:class.logError
    // @visibility external
    //<
	logError : function (message, category) { return this.logMessage(isc.Log.ERROR, message, category)},

    //> @method class.logFatal()
    // Log a message at "fatal" priority
    // 
    //     @param message    (String)  message to log
    //     @param [category] (String)  category to log in
    //
    // @see Log.logDebug() for usage info
    // @visibility external
    //<
    //> @classMethod class.logFatal()
    // @include method:class.logFatal
    // @visibility external
    //<
	logFatal : function (message, category) { return this.logMessage(isc.Log.FATAL, message, category)},

    //> @method class.logIsEnabledFor()
    // Check whether a message logged at the given priority would be visible in the log.
    // <P>
    // As with logDebug, category is defaulted to the current className.  Use this method to avoid
    // putting together expensive log messages if they will never appear in the log.
    //
    //     @param priority   (LogPriority)  priority level
    //     @param [category] (String)            category to log in
    // @visibility external
    //<
    //> @classMethod class.logIsEnabledFor()
    // @include method:class.logIsEnabledFor
    // @visibility external
    //<
	logIsEnabledFor : function (priority, category) {
        return (isc.Log.isEnabledFor && 
                isc.Log.isEnabledFor((category ? category : this.Class), priority, this))
    },

    //> @method class.logIsDebugEnabled()
    // Check whether a message logged at "debug" priority would be visible in the log.
    // <P>
    // As with logDebug, category is defaulted to the current className.  Use this method to avoid
    // putting together expensive log messages if they will never appear in the log.
    //
    //     @param [category] (String)            category to log in
    // @visibility external
    //<
    //> @classMethod class.logIsDebugEnabled()
    // @include method:class.logIsDebugEnabled
    // @visibility external
    //<
	logIsDebugEnabled : function (category) { return this.logIsEnabledFor(isc.Log.DEBUG, category) },
    
    //> @method class.logIsInfoEnabled()
    // Check whether a message logged at "info" priority would be visible in the log.
    // <P>
    // As with logDebug, category is defaulted to the current className.  Use this method to avoid
    // putting together expensive log messages if they will never appear in the log.
    //
    //     @param [category] (String)            category to log in
    // @visibility external
    //<
    //> @classMethod class.logIsInfoEnabled()
    // @include method:class.logIsInfoEnabled
    // @visibility external
    //<
	logIsInfoEnabled : function (category) {    return this.logIsEnabledFor(isc.Log.INFO, category) },
    
    //> @method class.logIsWarnEnabled()
    // Check whether a message logged at "warn" priority would be visible in the log.
    // <P>
    // As with logDebug, category is defaulted to the current className.  Use this method to avoid
    // putting together expensive log messages if they will never appear in the log.
    //
    //     @param [category] (String)            category to log in
    // @visibility external
    //<
    //> @classMethod class.logIsWarnEnabled()
    // @include method:class.logIsWarnEnabled
    // @visibility external
    //<
	logIsWarnEnabled : function (category) {    return this.logIsEnabledFor(isc.Log.WARN, category) },

    //> @method class.logIsErrorEnabled()
    // Check whether a message logged at "error" priority would be visible in the log.
    // <P>
    // As with logDebug, category is defaulted to the current className.  Use this method to avoid
    // putting together expensive log messages if they will never appear in the log.
    //
    //     @param [category] (String)            category to log in
    // @visibility external
    //<
    //> @classMethod class.logIsErrorEnabled()
    // @include method:class.logIsErrorEnabled
    // @visibility external
    //<
	logIsErrorEnabled : function (category) {    return this.logIsEnabledFor(isc.Log.ERROR, category) },

    // Methods to update the log priority directly on objects
    
    //> @method class.setLogPriority()
    // Set the priority of messages that will be visible for some log category, when logged on
    // this Class or Instance object.<br>
    // If called with no category, this priority will be applied to every logged message on this
    // object<br>
    // To set the visible log priority for some category across the entire page, use
    // <code>isc.Log.setPriority()</code> instead.
    // @param category (string) Category for which the log priority will be updated. If not
    //                          all logs on this canvas will be logged at the priority passed in.
    // @param priority (LogPriority) priority level
    // @see Log.setPriority()
    // @visibility external
    //<
    //> @classMethod class.setLogPriority()
    // @include method:class.setLogPriority
    // @visibility external
    //<
    setLogPriority : function (category, priority) {
        isc.Log.setPriority(category, priority, this);
    },
    
    //> @method class.setDefaultLogPriority()
    // Set the default priority of logging for messages logged on this Class or Instance object.
    // All categories for which there is no explicit, instance level logging priority set will
    // log at this level on this object.<br>  
    // To set the default visible log priority across the entire page, use
    // <code>isc.Log.setDefaultPriority()</code> instead.
    // @param category (string) Category for which the log priority will be updated. If not
    //                          all logs on this canvas will be logged at the priority passed in.
    // @param priority (LogPriority) priority level
    // @see Log.setPriority()
    // @visibility external
    //<
    //> @classMethod class.setDefaultLogPriority()
    // @include method:class.setDefaultLogPriority
    // @visibility external
    //<
    setDefaultLogPriority : function (priority) {
        isc.Log.setDefaultPriority(priority, this);
    },
    
    //> @method class.getDefaultLogPriority()
    // Retrieves the default priority of messages for this class or instance.
    // @return (LogPriority) default priority for logging messages on this object.
    // @visibility external
    //<
    //> @classMethod class.getDefaultLogPriority()
    // @include method:class.getDefaultLogPriority
    // @visibility external
    //<
    getDefaultLogPriority : function () {
        return isc.Log.getDefaultPriority(this);
    },

    //> @method class.clearLogPriority()
    // Clear this object's priority setting for a particular category, so that the category's 
    // effective priority returns to the specified priority for this category at the Log level
    // (or <code>Log.defaultPriority</code> if not set).<br>
    // To clear the Page-level priority setting for this log category use 
    // <code>isc.Log.clearPriority()</code> instead.
    //
    // @param category   (String) Category name. If not specified, all logging on this object
    //                              will revert to default priority settings.
    // @visibility external
    // @see Log.clearPriority()
    //<
    //> @classMethod class.clearLogPriority()
    // @include method:class.clearLogPriority
    // @visibility external
    //<
    clearLogPriority : function (category) {
        isc.Log.clearPriority(category, this);
    }    
    
};

// add the methods to Class object prototype and to the Class instance prototype
isc.Class.addMethods(isc._logMethods);
isc.Class.addClassMethods(isc._logMethods);



//>	@groupDef	debug
// Support for debugging and logging
//<

//>	@class	Log
// A logging system similar to the Java log4j package: messages are logged with a "category" and
// "priority", and developers can dynamically set which log messages are being displayed.
// <P>
// 5 log priorities are available, with the following general meaning:
// <ul>
// <li> "debug": diagnostic info which is only likely to be understood by a developer with
// source access, or would occur too frequently for normal usage
// <li> "info": reports of significant events in the normal operation of the subsystem
// <li> "warn": some kind of problem is likely to occur, an API appears is apparently being
// misused or will yield a partial or very slow result
// <li> "error": a definite error has occurred which may be recoverable
// <li> "fatal": total failure with no possibility of recovery
// </ul>
// <P>
// Log categories do not need to be declared in advance - you can simply make up a category name and
// start logging to it, and control whether that category's messages will be displayed via
// <code>setPriority()</code>.
// <P>
// <b>NOTE:</b> to open the Developer Console in any page that loads ISC, type
// javascript:isc.Log.show() in the URL bar - this URL is bookmarkable.  
// <P>
// The Developer Console should <b>always</b> be open while developing any ISC-enabled application,
// because ISC logs many important errors and warnings to the Developer Console.
// <P>
// In Internet Explorer, the Developer Console is able to log a stack trace for every JS error,
// including errors that occur in non-ISC code.
// <P>
// NOTE: if you have the Microsoft JavaScript Debugger installed, ISC will be unable to log stack
// traces on JS errors until you go to Tools->Internet Options->Advanced Tab and check "Disable
// script debugging".  The ability to see stack traces in the Developer Console is generally much
// more useful for debugging ISC-based applications than the generic Javascript Debugging
// facilities.
//
// @treeLocation Client Reference/System
// @group debug
//
// @see Log.setPriority()
//
//  @visibility external
//<
isc.ClassFactory.defineClass("Log");

//> @groupDef debugging
// <h4>Built-in Diagnostics</h4>
// <P>
// In any page in which ISC has been loaded, you have access to the Developer Console,
// which can be opened by entering the following URL into your browser from the running
// application:
// <pre>
//     javascript:isc.showConsole()</pre>
// Basic information on the features of the Developer Console can be found in the QuickStart
// Guide.  This topic focuses on use of the log system and related debugging facilities.
// <P>
// The Developer Console contains a "Results" pane that displays a list of diagnostic
// messages logged by the SmartClient framework. The "Logging Preferences" menu lets you
// enable and disable SmartClient's built-in diagnostics in several categories. Because
// important diagnostic messages may be logged at any time, you should have the Developer
// Console open whenever you are working with SmartClient (and you should bookmark the
// "javascript:" expression above to make this easier).
// <P>
// Log messages are of the format:
// <P>
// &nbsp;&nbsp;&nbsp;<i>timestamp</i>:<i>priority</i>:<i>category</i>:<i>message</i>
// <P>
// For example, the following log message:
// <pre>
//     11:59:25:806:INFO:Page:Page loading complete.</pre>
// Occured at 11:59:25 local time and 806 milliseconds.  It's priority was <code>INFO</code>,
// it occurred in the category <i>Page</i>, and the message is "Page loading complete.".
// <P>
// Each logging <i>category</i> has a <i>priority</i> associated with it.  If a message's
// priority is lower than the current priority for the category it is logged in, the
// message will be suppressed (will not appear in the "Results" pane).  
// <p>
// It is critical to be familiar with the diagnostic categories built-in to SmartClient - 
// you will use them in most debugging sessions.  Open the Logging Preferences menu and select
// "More.." to see a list of diagnostic log categories.   Hover over each category name to
// see a description of what kind of messages are logged in the category.  
// <P>
// <h4>Debugging JavaScript Errors</h4>
// <P>
// Isomorphic recommends the FireFox browser as the primary development platform.  In FireFox,
// JavaScript errors are reported both in the SmartClient Developer Console and in the FireFox
// JavaScript console, which can be opened by entering the special
// url "javascript:" in the address bar.
// <P>
// Isomorphic currently recommends that every SmartClient developer install either the 
// +externalLink{https://addons.mozilla.org/firefox/1815/,Console2} or
// +externalLink{http://www.getfirebug.com/,Firebug} extensions for FireFox.  "Console2" simply
// replaces the default FireFox JavaScript console with a more functional console;
// Firebug aims to be a true debugger.  Both tools will typically load or identify the correct
// file and line number where a JS error occured.
// <P>
// In Internet Explorer, when JS errors occur, SmartClient is able to report full stack traces
// in the Developer Console.  This can be invaluable when your code triggers a JS error
// in the SmartClient libraries themselves, or when it is unclear how your code is being
// called.  Stack traces from Internet Explorer should <i>always</i> be included in issue
// reports sent to Isomorphic Software, if at all possible. 
// <P>
// <h4>Inspecting application state</h4>
// <P>
// The "Evaluate JS Expression" area of the Results Pane in the Developer Console can be used
// to inspect the current state of a SmartClient application.  Any SmartClient or browser
// built-in API can be called from the "Evaluate JS Expression" area, and the results will
// be intelligently summarized (via +link{Log.echo()}).  For example, simply typing a
// component's ID and pressing the "Eval JS" button will give you a dump of it's current
// property values.  
// <P>
// Many, many SmartClient APIs can be usefully called while troubleshooting, eg, 
// +link{listGrid.data} is a +link{ResultSet} when a grid is DataBound and 
// +link{resultSet.get()} can be called to inspect the current values on records.  In addition,
// new application code can be tried out, for example, you might repeatedly instantiate a new
// component, trying variants on the properties you could give it.
// <P>
// <b>Inspecting transient application state with logs</b>
// <P>
// Transient state, such as the values of local variables in a method that is crashing, can be
// sent to the Developer Console via using the +link{Log} class.  For example, to dump the
// value of the local variable "request": 
// <pre>
//     isc.logWarn("request is: " + isc.echo(request));
// </pre>
// <P>
// It's a good idea to dump the values of local variables in any method that is crashing or
// behaving unexpectedly.
// <P>
// Note the use of +link{isc.logWarn,logWarn()} above: in typical debugging sessions, it's best
// to simply use <code>logWarn</code> method to output diagnostics to ensure your message will
// not be suppressed by log priority settings.
// <P>
// NOTE: never use the native <code>alert()</code> method to output diagnostics.  Among other
// issues, <code>alert()</code> can affect timing, masking or altering the behavior you were
// trying to debug.  SmartClient's logging system doesn't suffer from these problems and
// provides much more control.
// <P>
// <h4>Issue Reports</h4>
// <P>
// If you believe you've discovered a bug in SmartClient or you are having trouble using
// SmartClient APIs, you can report it at +externalLink{http://forums.smartclient.com/}, or, if
// you have Enterprise Support, at the 
// +externalLink{http://support.isomorphic.com/,Customer Support Extranet}.
// <P>
// <b>How quickly your issue is resolved is entirely up to you</b>.  If you follow the steps
// below and submit an appropriate issue report, you will generally receive a rapid solution
// from Isomorphic Support, regardless of what support level you have, because Isomorphic
// aggressively corrects bugs and legitimate usage issues.  If you skip steps you are likely to
// be directed back to this document and asked to submit a more complete issue report.
// <P>
// Before reporting an issue, ensure that you:
// <ul>
// <li> Have read the +docTreeLink{QuickStartGuide,QuickStart Guide} cover to
// cover.  Later chapters cover more advanced topics and provide links to further examples and
// reference.
// <li> Have searched the +docTreeLink{FeatureExplorer,Feature Explorer} for examples that show
// what you are trying to do
// <li> Have searched this reference, trying multiple searches using different, common and
// related terms for what you are trying to do (eg for search, try "search", "filter",
// "criteria", "find", "match", etc)
// <li> Have searched the public +externalLink{http://forums.smartclient.com,forums}
// </ul>
// Always include:
// <ul>
// <li> A description of what you are trying to accomplish <b>from a user's perspective</b>.
// The best answers often point out a simpler approach.
// <li> The browser(s), operating system(s) and SmartClient version(s) you experience the error
// on (SmartClient version is available in the lower-left handle corner of the Developer
// Console)
// </ul>
// Then, include <b>either</b> a standalone test case (see below), <b>or</b>:
// <ul>
// <li> For JS errors, Stack traces from Firebug (for Firefox) or the Developer Console (for
// IE), as covered under "Debugging JavaScript Errors" above
// <li> Results of calling <code>echo()</code> on local variables or other application
// state you think is relevant (see "Inspecting Application State" above)
// <li> What server platform and +link{group:clientServerIntegration,databinding approach} you
// are using, if applicable
// <li> contents of the SmartClient Developer Console "Log messages" area, with appropriate
// diagnostic categories set the DEBUG or INFO level (see "Built-in Diagnostics" above)
// <li> sample code and sample data
// </ul>
// <b>Preparing a standalone test case</b>
// <P>
// A standalone test case is one of:
// <ol>
// <li> a chunk of JavaScript code that can be executed from the "Eval JS" area of the
// Developer Console on some specified page within the unmodified SmartClient SDK,
// demonstrating your issue
// <li> an .html or .jsp file that can be dropped at a specified location into an unmodified
// SmartClient SDK and will run without changes, demonstrating your issue.
// <li> a .zip file that includes a standalone .html/.jsp file  as above, as well as
// dependencies required to make the test case runnable, such as XML datasets
// </ol>
// <P>
// Submitting a standalone test case removes any ambiguity as to whether there is a bug in
// SmartClient or a bug in your code, and eliminates the possibility of Isomorphic Support
// responding with a "works for me" result due to incomplete information.  Issues with verified
// test cases are routed directly to the engineer that authored the relevant SmartClient
// subsystem, often as the new highest priority task.  In addition, the process of preparing a
// test case very often allows you to solve the issue yourself.
// <P>
// There are two approaches to test case preparation:
// <ol>
// <li> Add code to an existing SmartClient example until you can reproduce the problem
// <li> Remove code from your application until it minimally shows the problem and runs standalone
// </ol>
// <P>
// For approach #1, find the nearest match to your use case in the
// +docTreeLink{FeatureExplorer} examples or in the other examples accessible from the Examples
// folder of the SDK, then try to minimally modify that example to demonstrate your issue.
// Feature Explorer examples are a particularly good starting point because you can simply copy
// the code from the Feature Explorer to the Eval JS area of the Developer Console and begin
// changing it, and if successful this yields a type #1 test case, the easiest for you to
// submit and most efficient for Isomorphic to work with.
// <P>
// For approach #2,
// <ol>
// <li> If a server is involved in initial page generation (eg a .jsp file), in most cases you
// can eliminate many server dependencies <b>and</b> create an easily modifiable starting point
// by using the browser's "View Source" feature to save a copy of the generated HTML output as
// an .html file in the same directory as the .jsp file that generated it.  Such a file will
// generally continue to function (all relative paths are still correct), and can be modified
// freely without the need to later revert changes to a .jsp.
// <li> Eliminate any code that isn't involved in the interaction.  Keep running the test case
// as you eliminate code to ensure you are still seeing the issue (you may solve it this way,
// or find key preconditions that you can report to Isomorphic)
// <li> For any issue that isn't cosmetic, revert to a default SmartClient skin
// <li> For any necessary RPC/DataSource interactions, spoof the interaction with one of these
// approaches:
// <ul>
// <li> switch any DataSources to one of the sample DataSources from the SDK (eg "supplyItem")
// if your issue can still be reproduced in this case.
// <li> create a small sample dataset in JavaScript directly in the .html file, and use a
// +link{dataSource.clientOnly,clientOnly DataSource} with that dataset.
// <li> capture server responses verbatim by setting the RPCManager log category to DEBUG, save
// the responses as flat files, and set +link{dataSource.dataURL} to point at them.
// <li> for RPCs, instead of calling the RPCManager, directly call your own callback function,
// passing a spoofed RPCResponse that includes just the fields your code depends upon
// </ul>
// <li> Finally, move your .html file into the stock SmartClient SDK along with any remaining
// dependencies and verify the problem can still be reproduced
// </ol>
// Having prepared the test case, combine it with the other required issue report information
// covered above, and submit it to the +externalLink{http://forums.smartclient.com/,forums},
// or, if you have Enterprise Support, at the
// +externalLink{http://support.isomorphic.com/,Customer Support Extranet}.
// <P>
// <h4>Adding your own diagnostic categories</h4>
// <P>
// Calling <code>logWarn()</code> is fine for a log statement you plan to delete at the end of
// the debugging session.  However, many log statements have lasting value if you could enable
// or disable them only when you need the relevant diagnostics, like SmartClient's built-in
// diagnostic categories.  To do this, pick a priority level less than <code>WARN</code>
// (<code>INFO</code> or <code>DEBUG</code>), and call the corresponding method on the Log
// class (<code>logInfo()</code> or <code>logDebug()</code>), passing the category name as a
// second parameter.  For example:
// <pre>
//   isc.Log.logInfo("first record is: " + 
//                   isc.Log.echo(myGrid.data.get(0)), 
//                  "myGridLoading");
// </pre>
// This message will no longer appear in the Results Pane by default, because its priority
// (<code>INFO</code>) is less than the default of <code>WARN</code>.  To see this message,
// open the Logging Preferences menu and pick "More..", then click the "Add" button, enter
// "myGridLoading" as the category name and set the priority to <code>INFO</code>.  The message
// will now appear next time it is logged.
// <P>
// Now you have a custom log category that you and other developers can use to debug your
// application, subsystem by subsystem.  These diagnostics will be available to you both in
// development and production environments.
// <P>
// As with SmartClient's built-in diagnostics, you may choose to log certain messages in your
// custom category at the <code>DEBUG</code> level and a lesser number of messages at the
// <code>INFO</code> level, to create different depths of diagnostic output.
// <P>
// <h4>Logging refinements</h4>
// <P>
// The core log methods (<code>logDebug()</code>, <code>logInfo()</code>,
// <code>logWarn()</code>) and the "echo" facilities (<code>echo()</code> and
// <code>echoAll()</code>) are available on every SmartClient component and Class.  Hence,
// in many cases, the special JavaScript value "this" will refer to an object that supports
// <code>logWarn()</code> et al.  For example:
// <pre>
//     Canvas.create({
//        ID:"canvasExample",
//        contents:"Hello World!",
//        click:"this.logWarn('the Canvas is: ' + this.echo(this))"
//     });
// </pre>
// The special value "this" is not always set to a SmartClient component, for example, in some
// kinds of callbacks (eg +link{ListGrid.fetchData(),fetchData()}).  When in doubt, use these
// methods via the Log class as <code>isc.Log.logWarn()</code>.
// <P>
// <b>Logging performance</b>
// <P>
// Because the log message is actually formed <i>before</i> the call to the log system, logs
// that are suppressed can still carry a performance penalty.  This is particularly true of
// logs that output a lot of data or occur frequently.  To avoid this penalty, you can check in
// advance whether a message will be suppressed using 
// +link{Log.logIsDebugEnabled,isc.Log.logIsDebugEnabled()} and
// +link{Log.logIsInfoEnabled,isc.Log.logIsInfoEnabled()}.  For example:
// <pre>
//   if (isc.Log.logIsInfoEnabled("myGridLoading")) {
//      isc.Log.logInfo("first record is: " +
//                      isc.Log.echo(myGrid.data.get(0)),
//                      "myGridLoading");
//   }
// </pre>
// Generally, it is only important to do this for logs that will occur multiple times during a
// given user interaction (eg a mousedown or keypress) and/or that call <code>echo()</code> on
// objects with many properties.
//
// @title Debugging
// @treeLocation Concepts
// @visibility external
//<


isc.Log.addClassProperties({
	//> @type	LogPriority
    // Priority levels for log messages
    // @value  Log.FATAL   unrecoverable error
	FATAL : 1,
    // @value  Log.ERROR   error, may be recoverable
	ERROR : 2,
    // @value  Log.WARN    apparent problem, misused API, partial result
	WARN : 3,
    // @value  Log.INFO    significant events in normal operation
	INFO : 4,	
    // @value  Log.DEBUG   diagnostics for developers
	DEBUG : 5,
    // @see Log.logDebug()
	//			@visibility external
	//<
	
	//>	@classAttr	Log.PRIORITY_NAMES		(string[] : [...] : IRWA)
	//		User-visible names for log priorities
	//		Note: NONE should never show up...
	//<
	PRIORITY_NAMES :["NONE" ,"FATAL", "ERROR", "WARN", "INFO", "DEBUG"]
});


// Hide the Log class setup when we're not debugging
//	this lets us just include the logger, but makes it all a no-op.
//	Note that the creation of Log and the setting of the LogPriority must always be present.


isc.Log.addClassProperties({

    //>	@classAttr	isc.Log.defaultPriority		(LogPriority : isc.Log.WARN : IRWA)
	// Any logs below this priority will be suppressed, unless a more specific setting exists for
    // the category.
    // @see Log.setPriority() 
    // @visibility external
	//<
	defaultPriority:isc.Log.WARN,	

    //>	@classAttr	isc.Log.stackTracePriority (LogPriority : isc.Log.ERROR : IRWA)
	// At this priority and above, a stack trace will be included automatically along with the log
    // message itself.
    // @visibility external
	//<
	stackTracePriority:isc.Log.ERROR, 

	// priorities setting per category
	_logPriorities: {},		
    // specific priorities for classes / instances
    _objectLogPriorities: {},	
	
	// number of messages to keep
	_messageCount:1000,
    

	// index of the slot for the next message in messageCache
	_messageIndex:0,				

	// array for keeping log messages
	_messageCache:[],

    _semiColon : ":",
    _dot : ".",
    _allCategories : "_allCategories",
    _default : "_default"
});

isc.Log.addClassMethods({

    // Log Priorities
	// --------------------------------------------------------------------------------------------

    //> @classMethod Log.applyLogPriorities()
    // Apply a batch a batch of priority settings, as a object mapping category names to priority
    // levels.
    //
    // @param settings (Object) priority settings for multiple categories
    // @visibility external
    //<
	applyLogPriorities : function (newDefaults) {
		// make a blank priority defaults object if necessary
		if (!this._logPriorities) {
            this._logPriorities = {};
        }            

		// if new defaults were specified, overlay them on the current set
		if (newDefaults) {
			isc.addProperties(this._logPriorities, newDefaults);
		}
	},
	
    //> @classMethod Log.getLogPriorities()
    // Get all priority settings as an object mapping category names to priority levels.
    //
    // @param [object] (Class or Instance object) Optional param to get priorities specific to
    //                                            some ISC class or instance.
    // @param [overridesOnly] (boolean) If this method is retrieving the priorities specific 
    //                                  to logging for some class or instance, this parameter
    //                                  can be used to view only the overrides to the default
    //                                  log priorites on this object.
    // @return (Object) priority settings
    // @visibility external
    //<
	getLogPriorities : function (object, overridesOnly) {
        var overrides;
        if (object != null) {
            var objectID = this._getObjectID(object);
            
            overrides = this._objectLogPriorities[objectID];
            if (overridesOnly) {
                return isc.addProperties({}, overrides);
            }
        }
        
        // copy to avoid unintentional changes
        var priorities = isc.addProperties({}, this._logPriorities);
        if (overrides) priorities = isc.addProperties(priorities, overrides);
        
        return priorities;
	},
    
    
    _getObjectID : function (object) {
        var ID;
        if (object == null) ID = isc.emptyString;
        else ID = (object.getID ? object.getID() : object.getClassName());
        return ID;
    },
	
    //> @classMethod Log.getPriority()
	// Return the priority setting for a particular category.
    // <P>
    // If there is no priority setting specific to this category, <code>null</code> will be
    // returned, NOT <code>Log.defaultPriority</code>.
    //
    // @param   category   (String)            category name
    // @param [object] (Class or Instance object)   Optional class or instance to check for 
    //                                              specific log priority overrides
    // @return  (LogPriority)     priority setting
    // @visibility external
    //<
	// return the priority for a particular category
	getPriority : function (category, object) {
        
        if (object != null) {
            var objectID = this._getObjectID(object),
                overrides = this._objectLogPriorities[objectID];
            if (overrides) {
                if (overrides._allCategories != null) return overrides._allCategories;
                if (overrides[category] != null) return overrides[category];
                if (overrides._default != null) return overrides._default;
            }
        }
        
        // Still going - look at global settings
        var priorities = this._logPriorities;
        return priorities[category] || priorities._default;
	},

    //> @classMethod Log.setPriority()
    // Set the priority of messages that will be visible for this log category.
    // <P>
    // After calling setPriority, any messages logged to the given category whose priority is
    // below the specified priority will not appear in the Log.
    //
    // @param category   (String)            category name
    // @param priority   (LogPriority)  priority level to set
    // @param [object]   (Class or Instance object) 
    //      Optional ISC class or instance - if passed the priority will be set for logging 
    //      occurring on the class or instance only.
    // @see Log.isEnabledFor() to check whether a category would allow a log at a given priority
    // @visibility external
    //<
	setPriority : function (category, priority, object) {
        if (object != null) {
            var objectID = this._getObjectID(object);
            if (this._objectLogPriorities[objectID] == null) 
                this._objectLogPriorities[objectID] = {};
            // If we're not passed a category, ensure we show all logs on the object in question
            // at the appropriate priority.
            if (!category) category = this._allCategories;
            this._objectLogPriorities[objectID][category] = priority;
        } else {
        
            this._logPriorities[category] = priority;
        }
	},
    
    //> @classMethod Log.setDefaultPriority()
    // Set the default priority of messages that will be visible.
    //
    // @param priority   (LogPriority)  priority level to set
    // @param [object]   (Class or Instance object) 
    //      Optional ISC class or instance - if passed the default priority will be set for logging 
    //      occurring on the class or instance only.
    // @visibility external
    //<
    setDefaultPriority : function (priority, object) {
        if (!object || object == isc.Log) isc.Log.defaultPriority = priority;
        else isc.Log.setPriority("_default", priority, object); 
    },
    
    //> @classMethod Log.getDefaultPriority()
    // Retrieves the default priority of messages that will be visible.
    //
    // @param [object]   (Class or Instance object) 
    //      Optional ISC class or instance - if passed the returns the default priority for 
    //     the class or instance only.
    // @return (LogPriority) default priority for which messages will be logged.
    // @visibility external
    //<
    getDefaultPriority : function (object) {
        var defaultPriority;
        if (object && object != isc.Log) defaultPriority = this.getPriority("_default", object);
        return defaultPriority || isc.Log.defaultPriority;
    },

    //> @classMethod Log.clearPriority()
	// Clear the priority setting for a particular category, so that the category's effective
    // priority returns to <code>Log.defaultPriority</code><br>
    // If the optional second parameter is passed, the specific priority setting for the 
    // category on that object will be cleared, so logs in that category on that object will
    // be logged at the global priority level for the category.
    //
    // @param category   (String)            category name
    // @param [object] (Class or Instance object) Optional instance or class object - if passed
    //                                        clear logging priority for the appropriate category
    //                                        on that object.
    // @visibility external
    //<
	clearPriority : function (category, object) {
        if (object) {
            var objectID = this._getObjectID(object);
            
            // If we were passed no category, clear all explicit log priorities on the object
            // in question.
            if (!category) 
                delete this._objectLogPriorities[objectID];
            else if (this._objectLogPriorities[objectID]) 
                delete this._objectLogPriorities[objectID][category];
            
        } else {
            delete this._logPriorities[category];
        }
	},

    //> @classMethod Log.isEnabledFor()
	// Would a message logged to the given category at the given priority appear in the Log?
    // <P>
    // NOTE: if there is no specific priority setting for a given category, the
    // <code>Log.defaultPriority</code> is used.
    //
    // @param category   (String)            category name
    // @param priority   (LogPriority)  priority level to check
    //
    // @visibility external
    //<
    // NOTE: hierarchical categories are not documented; not clear whether we want to expose this
    // feature
	isEnabledFor : function (category, priority, object) {
        if (!category) category = isc._emptyString;
		while (category != isc._emptyString) {
        
			// get the priority for the category
			var categoryPriority = this.getPriority(category, object);
			// if it was found and its priority is set
			if (categoryPriority != null) {
				// return if the message is at the appropriate priority
				return priority <= categoryPriority;
			}
			
			// if the category contains a period, chop it down and try again
			var periodIndex = category.lastIndexOf(this._dot);
			if (periodIndex > 0) {
				// chop off the last category
				category = category.substring(0, periodIndex);
			} else {
				// jump out of the loop
				break;
			}	
		}

		// category not found or was null -- return according to the default logging priority
		return priority <= isc.Log.defaultPriority;
	},

    // Formatting and Displaying Log messages
	// --------------------------------------------------------------------------------------------

	// log a message at an arbitrary priority (for wrappers)
	log : function (priority, message, category, msgPrefix, object, timestamp) {
		if (this.isEnabledFor(category, priority, object))
			this.addLogMessage(priority, message, category, msgPrefix, timestamp);
        else if (this.reportSuppressedLogs) {
            // Useful for detecting unnecessary logs, especially unnecessary logs during
            // critical path code
            this.logWarn("suppressed log, category: " + category + ": " + message
                // + this.getStackTrace()
            );
        }
	},

    // get a timestamp suitable for our short-lived log: millisecond precision, no need to show
    // date 
    
    _1zero : "0",
    _2zero : "00",
	getLogTimestamp : function (date) {
        var tsArray = this._tsArray;
        if (tsArray == null) {
            tsArray = this._tsArray = []; 
            tsArray[2] = this._semiColon;
            tsArray[5] = this._semiColon;
            tsArray[8] = this._dot;
        }

		if (date == null) date = new Date();
        var hours = date.getHours(),
            minutes = date.getMinutes(),
            seconds = date.getSeconds(),
            ms = date.getMilliseconds();
         
        tsArray[1] = hours;
        if (hours < 10) tsArray[0] = this._1zero;
        else tsArray[0] = null;

        tsArray[4] = minutes;
        if (minutes < 10) tsArray[3] = this._1zero;
        else tsArray[3] = null;

        tsArray[7] = seconds;
        if (seconds < 10) tsArray[6] = this._1zero;
        else tsArray[6] = null;

        tsArray[10] = ms;
        if (ms < 10) tsArray[9] = this._2zero;
        else if (ms < 100) tsArray[9] = this._1zero;
        else tsArray[9] = null;
        
        return tsArray.join(isc._emptyString);
	},


	// return the name shown to the user for a particular log priority
	getPriorityName : function (priority) {
		if (priority == null) return isc._emptyString;
		return this.PRIORITY_NAMES[priority];
	},

	// routine to format the log message and officially "log" it
	// override to set your own outputter
	_makeLogMessage : function (priority, message, category, msgPrefix, timestamp) {
        var msg = this._msgArray;
        if (msg == null) {
            msg = this._msgArray = [];
        }
        
		if (!category) category = this.category;
		
        msg[0] = this.getLogTimestamp(timestamp);
        msg[1] = this._semiColon;

        // Add the "thread" if available, eg, what the native source of the JS thread
        // is, such as mouse events, timers, etc
        if (this.ns.EH && this.ns.EH._thread != null) {
            msg[2] = this.ns.EH._thread;
            msg[3] = this._semiColon;
        }

        if (priority != null) {
            msg[4] = this.getPriorityName(priority);
            msg[5] = this._semiColon;
        }

        msg[6] = category;
        msg[7] = this._semiColon;
        // allow a prefix to the message to be passed in, so we can do the concat
        if (msgPrefix) {
            msg[8] = msgPrefix
            msg[9] = this._semiColon;
        }
        msg[10] = message;
		
		var result = msg.join(isc._emptyString);

        // clear out the array used to construct the message
        msg.length = 0;

        return result;
    },

	addLogMessage : function (priority, message, category, msgPrefix, timestamp) {
        

		this.addToMasterLog(this._makeLogMessage(priority, message, category, msgPrefix, timestamp))

		// show alerts in addition for error and fatal level log messages
		if (priority != null && (priority == this.FATAL || priority == this.ERROR)) {
			alert(message);
		}
	},

	// add a message to the master log
	// anyone who wants to know when messages are added should observe this method!
	addToMasterLog : function (message) {
//!DONTOBFUSCATE
// NOTE: we're not obfuscating so the "message" parameter will retain that name later

		// remember the message passed in
		this._messageCache[this._messageIndex] = message;

		// set up for the next message
		this._messageIndex++;
		
		// if we're beyond the appropriate number of messages to remember
		if (this._messageIndex > this._messageCount) {
			// roll over the messsageIndex to 0
			this._messageIndex = 0;
		}
	},
	
	// return the array of messages stored in the master log
	getMessages : function () {
		var cache = this._messageCache,
			index = this._messageIndex,
			count = this._messageCount
		;
		return cache.slice(count-index,count).concat(cache.slice(0, index));
	},
	
    //> @classMethod Log.show()
    // Open the Developer Console.
    // <P>
    // The Developer Console should <b>always</b> be open while developing any ISC-enabled
    // application, because ISC logs many important errors and warnings to the Developer Console.
    // <P>
    // In Internet Explorer, the Developer Console is able to log a stack trace for every JS error,
    // including errors that occur in non-ISC code.
    // <P>
    // NOTE: if you have the Microsoft JavaScript Debugger installed, ISC will be unable to log
    // stack traces on JS errors until you go to Tools->Internet Options->Advanced Tab and check
    // "Disable script debugging".  The ability to see stack traces in the Developer Console is
    // generally much more useful for debugging ISC-based applications than the generic Javascript
    // Debugging facilities.
    // 
    // @group debug
    // @visibility external
    //<
    show : function (loading, logWindow, dontSaveState) {
        if (!this.logViewer) this.logViewer = isc.LogViewer.create();
        this.logViewer.showLog(loading, logWindow, dontSaveState);
    },

    //> @classMethod Log.clear()
	// Clear all currently displayed Log messages
    // @visibility external
    //<
	clear : function () {
         
		this._messageCache = [];
		this._messageIndex = 0;
        if (this.logViewer) this.logViewer.clear(); 
	},
    
    // update the form in the log viewer
    updateStats : function (stat) {
        if (this.logViewer) this.logViewer.updateStats(stat);
    },

    // allow storing log messages before Log class has loaded (advanced internal usage)
    _logPrelogs : function () {
        var preLogs = isc._preLog;
        if (!preLogs) return;
        for (var i = 0; i < preLogs.length; i++) {
            var log = preLogs[i];
            if (isc.isA.String(log)) this.logDebug(log);
            else this.logMessage(log.priority || isc.Log.INFO,
                                 log.message, log.category, log.timestamp);
        }
        isc._preLog = null;
    },

    // Tracing and timing
	// --------------------------------------------------------------------------------------------

	//>	@classMethod		Log.traceMethod()
    //
    //  Observe a method on an object, logging a stack trace whenever the method is called.
    //  <P>
    //  Call a second time with identical arguments to disable tracing.
    //
	//	@param	object		(object)	object to observe
	//	@param	methodName	(string)	name of the method to observe
    //
	//	@group	debug
	//	@visibility external
    //<
    traceMethod : function (obj, methodName, callOnly) {
    	// Bail if the arguments aren't valid
    	var object = this.validObservation(obj, methodName);
    	if (!object) return;
        
        // Keep a list of what objects / methods we're logging traces for
        //      Note: format is {objName:[methodName1, methodName2]}
        
        if (!this._traceRegistry) this._traceRegistry = {};
        if (!this._traceRegistry[obj]) this._traceRegistry[obj] = []; // array of method names

        // observation can only be done by instances, so create an arbitrary instance to
        // observe with
        if (!this._observer) this._observer = isc.Class.create();
        var observer = this._observer;

    	// If this object is already being traced, stop observation
    	if (observer.isObserving(object, methodName) && 
            this._traceRegistry[obj].contains(methodName)) 
        {
    		observer.ignore(object, methodName);
    		this.logWarn("MethodTimer: Stopped logging stack traces for " + methodName + 
                         " method on " + obj);
            // remove it from the registry        
            this._traceRegistry[obj].remove(methodName);
            
    	} else {
            var objName = object.ID ? object.ID : (object.Class ? object.Class : object),
                expression = "isc.Log.logWarn('" + objName + "." + methodName + "() - trace:' +";
            if (callOnly) {
                expression += "'\\n' + isc.Log.getCallTrace(arguments))";
            } else { 
                expression += "isc.Log.getStackTrace())";
            }
            this.logWarn("expression is: " + expression);
    		observer.observe(object, methodName, expression);
    		this.logWarn("MethodTimer: Logging traces whenever " + methodName + 
                         " method on " + obj + " is called");
            // add it to the registry
            this._traceRegistry[obj].add(methodName);                 
    	}
        
    },
    
    traceCall : function (obj, methodName) {
        this.traceMethod(obj, methodName, true);
    },

	//>	@classMethod		Log.timeMethod()
    // 
    //  Observe a method on an object, logging execution time whenever the method is called.
    // <P>
    //  Call a second time with identical arguments to disable tracing.
    //
	//	@param	object		(object)	object to observe
	//	@param	methodName	(string)	name of the method to observe
    //
	//	@group	debug
	//	@visibility external
    //<
	_methodPrefix:"$T_",
    timeMethod : function (obj, methodName, storeTotals, dontLog, causeGC) {

    	// Bail if the arguments aren't valid
    	var object = this.validObservation(obj, methodName);
    	if (!object) return;

        // Keep a list of what objects / methods we're timing
        //      Note: format is {objName:[methodName1, methodName2]}
        if (!this._timeRegistry) this._timeRegistry = {};
        if (!this._timeRegistry[obj]) this._timeRegistry[obj] = []; // array of method names

        // already timing the method       
        if (this._timeRegistry[obj].contains(methodName)) return;

        // Note - to time the method, we rename it, and replace it with a timer method (which will
        // return the same value
    	var saveMethodName = isc.Log._methodPrefix + methodName,
    		observedMethod = isc._obsPrefix + methodName, // Observation saves original method as _$method
    		oldMethodName = (object[observedMethod] ? observedMethod : methodName)
    	;
 
        // If we're not timing the method:
    	// If the method isn't being observed, we save the original method on the object as
    	// (prefix + method) and replace it with a method that times and calls (prefix + method)
    	//
    	// If the method IS being observed, we do the same thing, except instead of saving and
    	// replacing the current method, we save and replace (isc._obsPrefix + method), which is where the
    	// original method's saved for observation.
    	//
    	// This way, we time only the original method, not the original method + its observer queue.
    	//
    	// This works even if we subsequently observe the method, because the method saved by the
    	// observation mechanism (isc._obsPrefix + method) is left untouched if it already exists.
        
    	object[saveMethodName] = object[oldMethodName];
    	object[oldMethodName] = isc.Log.makeTimerFunction(
    		methodName, object, storeTotals, dontLog, causeGC
    	);
    	this.logWarn("MethodTimer: Timing " + methodName + " method on " + obj);
        this._timeRegistry[obj].add(methodName);

    },
    
    stopTimingMethod : function (obj, methodName) {
    	// Bail if the arguments aren't valid
    	var object = this.validObservation(obj, methodName);
    	if (!object) return;

        // If we're already timing the method, stop timing it.
        if (this._timeRegistry[obj].contains(methodName)) {
    	    var saveMethodName = isc.Log._methodPrefix + methodName,
                // Observation saves original method as _$method
    		    observedMethod = isc._obsPrefix + methodName, 
        		oldMethodName = (object[observedMethod] ? observedMethod : methodName)

            if (!object[saveMethodName]) {
                // This should never happen but we'll just clean up by deleting the registry entry
                this.logWarn("Not timing method '" + methodName + "' on object '"+ obj +"'.");
                this._timeRegistry[obj].remove(methodName);
                return;
            }
            
            // Stop timing the method:
            object[oldMethodName] = object[saveMethodName];
            delete object[saveMethodName];
    		this.logWarn("MethodTimer: " + methodName + " method on " + obj + 
                         " is no longer being timed");            
            this._timeRegistry[obj].remove(methodName);
            return;
        }            
    },
	
    // generate a function that calls the original message and logs timing data
	makeTimerFunction : function (methodName, object, storeTotals, dontLog, causeGC) {

		var method = object[methodName],
            fullMethodName = isc.Func.getName(method, true);

        

        
        var timerFunc = function (a,b,c,d,e,f,g,h,i,j,k) {
            // you can use this to take the GC-based variability out of a method being timed
            if (causeGC) isc.Log._causeGC();
			var start = isc.timeStamp();
            var returnValue = method.call(this, a,b,c,d,e,f,g,h,i,j,k);
            var total = (isc.timeStamp()-start);
 
            
            if (!dontLog) isc.Log._logTimerResult(this, fullMethodName, total);
            return returnValue;
        }
		timerFunc._fullName = (object.ID || object.Class || "") + "_" + methodName + "Timing";
        timerFunc._isTimer = true;
        timerFunc._origMethodSlot = isc.Log._methodPrefix + methodName;
        return timerFunc;
	},

    // logTimerResult: log the result of timing a method
    _timerMessage : [
        "Timed ", 
        , // methodName
        ": ",
        , // time
        "ms"
    ],
    _logTimerResult : function (object, methodName, callTime) {
        if (this.deferTimerLogs) return this._deferTimerLog(object, methodName, callTime);
        var template = isc.Log._timerMessage;
            
        // if "logWarn" exists, use it so the object identifies itself, otherwise, 
        // toString() the object as part of the log message
        template[1] = (object.logWarn ? methodName : 
                                        methodName + " on " + this.echoLeaf(object));
        template[3] = callTime.toFixed(3);
    
        var message = template.join(isc.emptyString);
        if (object.logMessage) object.logWarn(message);
        else isc.Log.logWarn(message);
    },

    

    

    // check whether method "method" on "obj" can be observed.  "obj" can be a string expression
    // that evaluates to an object
    validObservation : function (obj, method) {
    	// Check that both fields are defined
    	if (isc.isAn.emptyString(obj) || isc.isAn.emptyString(method)) return false;
    
        var object = obj;
        if (isc.isA.String(obj)) {
            // assume an expression (including a simple global ID)
            object = isc.Class.evaluate(obj);
            if (!object) {
                this.logWarn("MethodTimer: " + obj + " is not an object.");
                return false;
            }
        }
    
        // If the method was specifed with parentheses, remove them:
        if (method.indexOf("(") != -1) {
            method = method.slice(0, method.indexOf("("));
        }
        
    	// If the object is a class, then we check whether there's a static method or an instance
    	// method with the given name on the class.
    	if (isc.isA.ClassObject(object)) {
    		var theProto = object.getPrototype();
            // look for an instance method first and return the instance prototype if an
            // instance method was found
    		if (isc.isA.Function(theProto[method])) return theProto;

    		if (!object[method]) {
    			this.logWarn("MethodTimer: " + method + 
                             " could not be found as a static or instance property on " + obj);
    			return false;
    		}
    	// not a class object, check that the method exists on it.
    	} else if (!object[method]) {
    		this.logWarn("MethodTimer: " + method + " is undefined or null on " + obj);
    		return false;
    	}
    	
    	// Check that the method is in fact a function, and not some other type of object
    	if (!isc.Func.convertToMethod(object, method)) {
    		this.logWarn("MethodTimer: " + method + " is not a method on " + obj);
    		return false;
    	}
    	
    	// Passed all the checks, return the object
    	return object;
    },

    // Hiliting a Canvas
	// --------------------------------------------------------------------------------------------
    hiliteCanvas : function (name) {
        var canvas = name;
        if (isc.isA.String(name)) canvas = window[name];

        if (!isc.isA.Canvas(canvas)) {
            //>DEBUG
            this.logWarn("Unable to find specified canvas '" + name + "'."); //<DEBUG
            return;
        } 

        this.showHiliteCanvas(canvas.getPageRect());
    },

    hiliteElement : function (name) {
        var element = name || this.elementToHilite;
        if (isc.isA.String(name)) element = isc.Element.get(name);
        if (element == null) {
            //>DEBUG
            this.logWarn("Unable to find specified element '" + name + "'."); //<DEBUG
            return;
        } 

        this.showHiliteCanvas(isc.Element.getElementRect(element));
        this.elementToHilite = null;
    },

    showHiliteCanvas : function (rect) {

        // flash an outline around the canvas
        var hiliteCanvas = this._hiliteCanvas;
        if (!hiliteCanvas) {
            hiliteCanvas = this._hiliteCanvas = isc.Canvas.create({
                ID:"logHiliteCanvas",
                autoDraw:false,
                overflow:"hidden",
                hide : function () {
                    this.Super("hide", arguments);
                    this.resizeTo(1,1);
                    this.setTop(-20);
                },
                border1:"2px dotted red",
                border2:"2px dotted white"
            })
        }

        hiliteCanvas.setPageRect(rect);

        isc.Page.setEvent("click", hiliteCanvas.getID() + ".hide()");

        hiliteCanvas.setBorder(hiliteCanvas.border1);
        hiliteCanvas.bringToFront();
        hiliteCanvas.show();
        
        // Flash the border a few times
        this._flashHiliteCanvas()
    },
    
    hideHiliteCanvas : function () {
        if (this._hiliteCanvas) this._hiliteCanvas.hide();
    },

    _flashHiliteCanvas : function () {
        // a function to set the hilite canvas to flash on a timer a few times
        var borders = [this._hiliteCanvas.border1,this._hiliteCanvas.border2];
        
        for (var i=0; i<7; i++) {
            isc.Timer.setTimeout({
                    target:this._hiliteCanvas, methodName:"setBorder",
                    args:[borders[i%2]]
                }, (500*i)
            )
        }
    }
    
});


//	LogViewer -- simple log viewer -- use to display the log visually.
// ---------------------------------------------------------------------------------------
//	Automatically updates whenever the log is added to.

isc.ClassFactory.defineClass("LogViewer");
isc.LogViewer.addClassMethods({
    // the GlobalLogCookie stores Log window sizing info that's required to be at path / to
    // work. 
	getGlobalLogCookie : function () {
		var globalLogCookie = isc.Cookie.get("GLog");
		if (!globalLogCookie) return null;

        try {
    		var fn = new Function("return " + globalLogCookie);
	    	return fn();
        } catch (e) {
            this.logWarn("bad log cookie: " + globalLogCookie + this.getStackTrace());
        }
	},
    // The LogCookie is stored at /isomorphic/system/helpers so as not to pollute the / HTTP
    // header space.  This cookie contains everything except what the GlobalLogCookie has
	getLogCookie : function () {
		var logCookie = isc.Cookie.get("Log");
		if (!logCookie) return null;

        try {
    		var fn = new Function("return " + logCookie);
	    	return fn();
        } catch (e) {
            this.logWarn("bad log cookie: " + logCookie + this.getStackTrace());
        }
	}
});

isc.LogViewer.addMethods({

    // whether the log window is loaded and ready to be accessed
    logWindowLoaded : function () {
        // We get bizarre errors in IE (typically: "trying to execute a freed script") if we
        // try to access elements of the logWindow page from the main frame if the log window
        // is being loaded, and replacing an existing log window.
        // This is probably due to window.open() returning a handle that is in an invalid state
        // until the new log window finished loading.
        // Therefore we wait for the log window to actually call back to the main frame and set
        // a flag telling us it has loaded.
        return (this._logWindowLoaded && this._logWindow != null && !this._logWindow.closed );
    },
    
	// Note: multiple-monitors: the log window position that's saved doesn't work properly
    // unless the log window is in the primary monitor. Also, negative coordinates will mean
    // that the window will be displayed at (0, 0) instead.
	showLog : function (loading, logWindow, dontSaveState, windowName) {
        // allow a log window to be passed in.  This allows the log window to reconnect to the
        // opener after the opener has been navigated to a new ISC page.
        if (logWindow) this._logWindow = logWindow;

        //alert("showLog called: loading: " + loading + ", logWindow: " + this._logWindow + 
        //      ", form: " + (this._logWindow ? this._logWindow.resultsForm : null));
		//	if the _logWindow property is set up, it's a pointer to a log window we previously
        //  opened.  If we can get into its form, just replace the form contents which is much
        //  faster.
		if (this.logWindowLoaded()) {
            this._logWindow.setResultsValue(isc.Log.getMessages().join("\r"));
            this._logWindow.focus();
            return;
        }
	
        // Assume that this is the only logViewer instance running - make sure it's available
        // as Log.logViewer
        if (!isc.Log.logViewer) isc.Log.logViewer = this;

        // if we have a log window, and it's not closed, we're done
        // (Note - if it is in the process of loading, we will rightly leave it alone)
        if (this._logWindow && !this._logWindow.closed) {
            
            return;
        }

        var rect = {},
            globalLogCookie = (dontSaveState ? null : isc.LogViewer.getGlobalLogCookie());

        if (globalLogCookie != null) {
            rect = globalLogCookie;
            // Commented out; in a multi-mon config coordinates could be reset even if they
            // weren't off-screen
            /*
            // make sure the log window doesn't end up off the screen
            rect.left = rect.left > screen.availWidth ? 0 : rect.left;
            rect.top = rect.top > screen.availHeight ? 0 : rect.top;
            */
        } else {
			rect.left = 100;
			rect.top = 100;
            rect.width = 640;
            rect.height = 480;
        }
                
        var windowSettings = "RESIZABLE,WIDTH=" + rect.width + ",HEIGHT=" + rect.height;
    
        if (globalLogCookie) {
            if (isc.Browser.isIE) {
                windowSettings += ",left=" + rect.left + ",top=" + rect.top;
            } else {
                windowSettings += ",screenX=" + rect.left + ",screenY=" + rect.top;
            }
            if (globalLogCookie.evals) this._currentEval = globalLogCookie.evals.length - 1;
                    
            
                    
        }

        
        //var subWindow = (window.opener && window.opener.isc);
        windowName = windowName || "_simpleLog";

        this._logWindow =
            window.open(isc.Page.getIsomorphicClientDir() + "helpers/Log.html", 
                        windowName
                        // avoid log window name collisions between Devenv and released
                        // versions of ISC.  NOTE: we'd use the version number, but 
                        // IE only is unhappy with a window name of eg "log5.5".
                        + (isc.version.contains("version") ? "Dev" : "")
                         , windowSettings);

        this._initLogWindow(dontSaveState);
    },

    _logWindowPollInterval: 25,
    _initLogWindow : function (dontSaveState) {
        if (isc.Browser.isIE) {
            // if we've set document.domain, then attempting to immediately set a property on
            // the new window, before it can adjust its document.domain automatically, results
            // in an 'Access denied' error, so poll.
            try {
                this._logWindow._accessTest = true;
            } catch (e) {
                this.delayCall("_initLogWindow", [dontSaveState], this._logWindowPollInterval);
                return;
            }
        }

        // In IE, set up a pointer to this window in the newly opened log window
        // This is necessary as IE will not replace the 'window.opener' property to point
        // to this window, if the above call replaced the contents of an already open
        // log window.
        if (isc.Browser.isIE) {
            this._logWindow.launchWindow = window;
        }
        
        // If we don't want the log window to attempt to save / retrieve state from cookies
        // set a flag on it
        if (dontSaveState) this._logWindow.dontSaveState = true;
        
        
        // focus in the log window we just opened, to bring it in front of whatever other windows
        // might be occluding it (WinAmp et al).
        // Do this on an idle.  Otherwise some browsers will focus in the log window, then
        // as code continues to execute in the main window, focus back in the main window.
        // (Mac Moz is a specific example of this).
        //
        // Put the code to focus inside a conditional in case the window is dismissed before
        // page idle fires.
                
        var focusFunction = function () {
            if (isc.Log.logViewer) {
                var logWindow = isc.Log.logViewer._logWindow;
                if (logWindow && !logWindow.closed) logWindow.focus();
            }
        }

        // Note - if we're showing the log window on page load, avoid this
        isc.Page.setEvent("idle", focusFunction, isc.Page.FIRE_ONCE);

        // if the log window is already open, then reconnect.  Otherwise the log window will
        // fire initializePage() on its own onload.
        if (this._logWindow.initializePage) this._logWindow.initializePage();
	},
	
    // unlike addToMasterLog(), addToLog() simply updates the log window's results form
    // *without* putting the message into the message index.  This means the log would be lost
    // by log window reload, unlike normal logs.  Used by eval (above)
    // Standard logWarn() et al. use addToMasterLog() - observed by Log.html to keep the
    // results form up to date.
	addToLog : function (message, scrollToEnd) {
        if (this.logWindowLoaded() && !this._suppressRefresh) {
            // append the new message to the existing log
            this._logWindow.addToLog(message, scrollToEnd);        
        }
	},
    
    //_staticFormUpdates:0,
    _$count : "count",
    updateStats : function (stat) {
        // don't update stats during timeExpression() runs
        if (isc._timingRun) return;

        if (!this.logWindowLoaded()) return;

        //this._staticFormUpdates++;
        var canvas = isc.Canvas,
            form = this._logWindow.staticForm;
        if (stat == this._$count) {
            form.setValue(stat,
                          canvas._canvasList.length - canvas._iscInternalCount);
        } else {
            form.setValue(stat, canvas._stats[stat]);
        }
    },
    displayEventTarget : function () {
        var targetID = isc.EH.lastTarget ? isc.EH.lastTarget.getID() : "";
        if (targetID == this._currentTarget) return;
        this._currentTarget = targetID;

        if (this.logWindowLoaded()) {
            this._logWindow.staticForm.setValue("currentCanvas", targetID)
        }                          

        var nativeTarget = isc.EH.lastEvent.nativeTarget;
        var nativeID = (nativeTarget? (nativeTarget.id || nativeTarget.ID || nativeTarget.tagName) : 'none')        

        if (this.logWindowLoaded()) {
            this._logWindow.staticForm.setValue("nativeTarget", nativeID)
        }                          
    },
    displayFocusTarget : function () {
        var target = isc.EH.getFocusCanvas(),
            targetID = target ? target.getID() : "";
        if (targetID == this._currentFocusTarget) return;
        this._currentFocusTarget = targetID;
        if (this.logWindowLoaded()) {
            this._logWindow.staticForm.setValue("currentFocusCanvas", targetID);
        }
    },
    displayMouseDownTarget : function () {
        var target = isc.EH.mouseDownEvent.target,
            targetID = target ? target.getID() : "";
        if (this.logWindowLoaded()) {
            this._logWindow.staticForm.setValue("lastMouseDown", targetID);
        }
    },
    updateRPC : function () {
        if (this.logWindowLoaded() && this._logWindow.RPCTracker) 
            this._logWindow.RPCTracker.dataChanged();
    },

    evaluate : function (expr, evalVars) {

        // execute the expression - and always report execution time
        var start = isc.timeStamp();

        var error,
            result
        ;
        // NOTE: "this" is the Log so that this.logWarn, this.echo et al will work
        if (isc.Browser.isIE) {
            // in IE, if there's an error, we report it via window.onerror
            result = isc.Class.evalWithVars(expr, evalVars, this);
        } else {
            // NOTE: try {} catch is not supported in Safari11, Nav4, or IE4
            try {
                result = isc.Class.evalWithVars(expr, evalVars, this);
            } catch (e) {
                error = e;
            }
        }
        var end = isc.timeStamp(),
            // show a timestamp for the log message itself if enabled
            resultString = isc.Log.getLogTimestamp() + ":";
        
        // don't show the entire expression
        var lines = expr.split(/[\r\n]+/);
        if (lines.length > 1) expr = lines[0] + "...";
        if (expr.length > 200) expr = expr.substring(0,200) + "...";
        if (error) {
            if (isc.Browser.isMoz) {
                isc.Log._reportJSError(error);
                return;
            }

            // In IE the error is an object - get the description property.
            // Unused since we let errors fall through in IE
            //if (isc.Browser.isIE) error = error.description;
            
            resultString += "Evaluator: '" + expr + "' returned a script error: \r\n" 
                         + "'" + error + "'";
        } else {
            resultString = "Evaluator: result of '" + expr + "' (" + (end-start) + 
                "ms):\r\n" + this.echo(result);
        }
        this.addToLog(resultString, true);
	},

    clear : function () {
        if (this.logWindowLoaded()) this._logWindow.clearResults();
    }
    
    
    
});

// Set up the preferences, log priorities etc. saved in a previous session
isc._globalLogCookie = isc.LogViewer.getGlobalLogCookie();
if (isc._globalLogCookie != null) {
    isc.Log.applyLogPriorities(isc._globalLogCookie.priorityDefaults)
    
    if (isc._globalLogCookie.defaultPriority != null) 
        isc.Log.defaultPriority = isc._globalLogCookie.defaultPriority;
} else {
    // For the "Log" category, default to "info"
    isc.Log.setPriority("Log", isc.Log.INFO);
}

isc.showConsole = function (loading, logWindow, dontSaveState, windowName) { 
    isc.showLog(loading, logWindow, dontSaveState, windowName); 
}
// this basically only exists as a convenience for those with old javascript:showLog() bookmarks
isc.addGlobal("showLog", function (loading, logWindow, dontSaveState, windowName) { 
    isc.Log.show(loading, logWindow, dontSaveState, windowName) 
})

// indicate that the log has started
isc.Log.logInfo("initialized");

// allow storing log messages before Log class has loaded (advanced internal usage)
isc.Log._logPrelogs();

// capture a stack trace for every JS error.  
//
// Only IE fires window.onerror.  In IE, window.onerror never fires if you've installed MS' JS
// debugger and have it enabled.  To fix, go to Tools->Internet Options->Advanced Tab and check
// "Disable script debugging"
if (!isc.Browser.isMoz && !isc.Browser.isSafari && !(window.isc_installOnError == false)) {
    
    window.onerror = function (msg, file, lineNo) { 
        // one-time flag to avoid doubled reports for errors that are caught, go through
        // _reportJSError(), and are rethrown
        if (arguments.caller && arguments.caller._errorReported) return;

        var message = "Error:\r\t'" + msg + "'\r\tin " + file + "\r\tat line " + lineNo + 
                       isc.Log.getStackTrace(arguments.caller);
        isc.Log.logWarn(message);
        if (isc.useIEDebugger) {
            if (confirm("Run debugger?" + "\r\r" + message)) {
                debugger;
            }
        }
    };
}

// shared toString method for data model classes (ResultSet, ResultTree)
isc._dataModelToString = function () {
    return "[" + this.Class + " ID:" + this.ID + " (created by: " + this.componentId + ")]";
}

// shared logMessage method for data model classes (Resultset, ResultTree)
isc._dataModelLogMessage = function (priority, message, category, timestamp) {
    var log = isc.Log;
    if (!log) return;

    //>DEBUG
    
    // if no priority was passed in, use the default
    if (priority == null) priority = log.defaultPriority;
    
    // automatically add a stack trace for error logs
    if (priority <= log.stackTracePriority && this.getStackTrace != null) {
        // skip two levels of the stack to avoid showing the logMessage() invocation itself 
        message += "\nStack trace:\n" + this.getStackTrace(arguments, 2);
    }

    // If a category was not specified, use the name of this class.
    if (!category) category = this.Class;

    // actually do the log.  NOTE: if we have an instance ID, pass it
    log.log(priority, message, category, this.ID  + " (created by: " + this.componentId + ")", this, timestamp);

    //<DEBUG
}
