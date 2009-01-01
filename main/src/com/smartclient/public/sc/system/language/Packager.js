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

 

//> @class isc
// The <code>isc</code> object contains global methods and objects of the Isomorphic SmartClient
// framework.
// <P>
// When the ISC framework runs in "simple names" mode (the default), all ISC Classes and several
// global methods are installed as global variables, that is, properties of the browser's
// "window" object.  When simple names mode is disabled (called "portal mode"), the framework
// uses only the global variable: "isc" and global variables prefixed with "isc_".  Portal mode
// is intended for applications which must integrate with fairly arbitrary JavaScript code
// written by third-party developers, and/or third party JavaScript frameworks, where it is
// important that each framework stays within it's own namespace.
// <P>
// In portal mode, all references to ISC classes and global functions must be prefixed with
// "isc.", for example:<pre>
// 
//      Canvas.create(addProperties({}, myDefaults))
//
// </pre>would become<pre>
//
//      isc.Canvas.create(isc.addProperties({}, myDefaults));
//
// </pre>
// Portal mode is enabled by setting <code>window.isc_useSimpleNames = false</code> <b>before</b>
// ISC is loaded.
//
// @treeLocation Client Reference/System
// @visibility external
//<





var isc = window.isc ? window.isc : {};
isc._start = new Date().getTime();

// versioning - values of the form ${value} are replaced with user-provided values at build time.
// Valid values are: version, date, project (not currently used)
isc.version = "7.0beta3/LGPL Development Only";
isc.versionNumber = "7.0beta3";
isc.buildDate = "2008-12-31";
isc.expirationDate = "";

// license template data
isc.licenseType = "LGPL";
isc.licenseCompany = "Isomorphic Software";
isc.licenseSerialNumber = "ISC_LGPL";
isc.licensingPage = "http://smartclient.com/licensing";

isc._optionalModules = {
    SCServer: {present: "false", name: "SmartClient Server", serverOnly: true},
    Drawing: {present: "false", name: "Drawing Module"},
    PluginBridges: {present: "false", name: "PluginBridges Module"},
    RichTextEditor: {present: "true", name: "RichTextEditor Module"},
    Calendar: {present: "true", name: "Calendar Module"},
    Analytics: {present: "false", name: "Analytics Module"},
    NetworkPerformance: {present: "false", name: "Network Performance Module"},
    // alias for NetworkPerformance
    FileLoader: {present: "false", name: "Network Performance Module"},
    RealtimeMessaging: {present: "false", name: "RealtimeMessaging Module"}
};
isc.canonicalizeModules = function (modules) {
    if (!modules) return null;

    // canonicalize to Array, split on comma
    if (isc.isA.String(modules)) {
        if (modules.indexOf(",") != -1) modules = modules.split(",");
        else modules = [modules];
    }
    return modules;
};
isc.hasOptionalModules = function (modules) {
    // ease of use shortcut, null value means no optional module requirements
    if (!modules) return true;

    modules = isc.canonicalizeModules(modules);

    for (var i = 0; i < modules.length; i++) if (!isc.hasOptionalModule(modules[i])) return false;
    return true;
};
isc.getMissingModules = function (requiredModules) {
    var result = [];
    requiredModules = isc.canonicalizeModules(requiredModules);
    for (var i = 0; i < requiredModules.length; i++) {
        var module = requiredModules[i];
        if (!isc.hasOptionalModule(module)) result.add(isc._optionalModules[module]);
    }
    return result;
};
isc.hasOptionalModule = function (module) {
    var v = isc._optionalModules[module];
    if (!v) {
        if(isc.Log) isc.Log.logWarn("isc.hasOptionalModule - unknown module: " + module);
        return false;
    }
    // has module or devenv
    return v.present == "true" || v.present.charAt(0) == "$";
};

// default to "simple names" mode, where all ISC classes are defined as global variables
isc._useSimpleNames = window.isc_useSimpleNames; 
if (isc._useSimpleNames == null) isc._useSimpleNames = true;

// register with the OpenAjax hub, if present
if (window.OpenAjax) {
    // OpenAjax insists on only numbers and dots.  This regex will convert eg 5.6b3 to 5.6.03,
    // which is not really accurate
    isc._numericVersion = isc.versionNumber.replace(/[a-zA-Z_]+/, ".0");
    OpenAjax.registerLibrary("SmartClient", "http://smartclient.com/SmartClient", 
                             isc._numericVersion,
                             { namespacedMode : !isc._useSimpleNames,
                               iscVersion : isc.version,
                               buildDate : isc.buildDate,
                               licenseType : isc.licenseType,
                               licenseCompany : isc.licenseCompany,
                               licenseSerialNumber : isc.licenseSerialNumber });
    OpenAjax.registerGlobals("SmartClient", ["isc"]);
}


isc._longDOMIds = window.isc_useLongDOMIDs; 

// add a property to global scope.  This property will always be available as "isc[propName]" and
// will also be available as "window[propName]" if we are in "simpleNames" mode.
// NOTE: even in simpleNames mode, where we assume it's OK to put things into global scope, we
// should still think carefully about creating globals.  Eg a variable like "params" which holds the
// current URL parameters (which we used to have) could easily get clobbered by some sloppy global
// JS, causing mysterious crashes.  Consider creating a class method (eg Page.getWidth()) or class
// property (Log.logViewer) instead, or making the variable isc.myMethod() or isc.myProperty.
isc._$iscPrefix = "isc.";
isc.addGlobal = function (propName, propValue) {
    if (propName.indexOf(isc._$iscPrefix) == 0) propName = propName.substring(4);
    isc[propName] = propValue;
    if (isc._useSimpleNames) window[propName] = propValue;
}





//>Offline

//XXX need to determine this flag correctly at load time
isc.onLine = true;

isc.isOffline = function () {
    return !isc.onLine;
};
isc.goOffline = function () { isc.onLine = false; };
isc.goOnline = function () { isc.onLine = true; };
if (window.addEventListener) {
    window.addEventListener("online", isc.goOnline, false);
    window.addEventListener("offline", isc.goOffline, false);
}
//<Offline


