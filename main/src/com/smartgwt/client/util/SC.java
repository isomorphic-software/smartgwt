/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.util;

import com.google.gwt.core.client.JavaScriptObject;

public class SC {
    public static final String REF = "__ref";

    public static native String generateID() /*-{        
        return $wnd.isc.ClassFactory.getNextGlobalID();
    }-*/;

    public static native String getHome() /*-{
        return $wnd.isomorphicDir;
    }-*/;

    public static native void debugger()/*-{
        debugger;
    }-*/;

    public static native void showConsole()/*-{
        $wnd.isc.showConsole();
    }-*/;

    /**
     * Return true if Firebug is enabled.
     *
     * @return true if firebug is enabled
     */
    public static native boolean hasFirebug() /*-{
		 return $wnd.isc.Browser.isMoz && window.console != null && window.console.trace != null;
    }-*/;

    public static native boolean isIE()/*-{
         return $wnd.isc.Browser.isIE;
    }-*/;

    /**
     * Disable firebug.
     */
    public static native void disableFirebug()/*-{
		var consoleMethods = ["log", "debug", "info", "warn", "error", "assert", "dir", "dirxml", "group", "groupEnd", "time", "timeEnd", "count", "trace", "profile", "profileEnd"];
		window.console = {};

     	for(var i=consoleMethods.length-1; i > -1; i--) {
			window .console[consoleMethods[i]] = function(){};
     	}
	}-*/;

    /**
     * Show a modal dialog with a message, icon, and "OK" button. Intended for notifications which are not really warnings (default icon is less severe).
     *
     * @param message the message
     */
    public static native void say(String message) /*-{
        $wnd.isc.say(message);
    }-*/;

    /**
     * Show a modal dialog with a message, icon, and "OK" button. Intended for notifications which are not really warnings (default icon is less severe).
     *
     * @param title the title of the message box
     * @param message the message
     */
    public static native void say(String title, String message) /*-{
	    $wnd.isc.say(message, {title:title});
	}-*/;



    /**
     * Show a modal dialog with a message, icon, and "OK" button. Intended for notifications which are not really warnings (default icon is less severe).
     * The callback will receive boolean true for an OK button click, or null if the Dialog is dismissed via the close button.
     *
     * @param message the message
     * @param callback the callback to fire when the user dismisses the dialog. 
     */
    public static native void say(String message, BooleanCallback callback) /*-{
        $wnd.isc.say(message, function(value) {
            var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
            callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
        });
    }-*/;

    /**
     * Show a modal dialog with a message, icon, and "OK" button. Intended for notifications which are not really warnings (default icon is less severe).
     * The callback will receive boolean true for an OK button click, or null if the Dialog is dismissed via the close button.
     *
     * @param title the title of the message box
     * @param message the message
     * @param callback the callback to fire when the user dismisses the dialog.
     */
    public static native void say(String title, String message, BooleanCallback callback) /*-{
        $wnd.isc.say(message, function(value) {
            var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
            callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
        }, {title:title});
    }-*/;

    /**
     * Show a modal dialog with a message, icon, and "Yes" and "No" buttons. The callback will receive boolean true for an OK
     * button click, boolean false for a No button click, or null if the Dialog is dismissed via the close button.
     * 
     * @param message the message
     * @param callback the callback to fire when the user dismisses the dialog.
     */
    public static native void ask(String message, BooleanCallback callback) /*-{
        $wnd.isc.ask(message, function(value) {
            var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
            callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
        });
    }-*/;

    /**
     * Show a modal dialog with a message, icon, and "Yes" and "No" buttons. The callback will receive boolean true for an OK
     * button click, boolean false for a No button click, or null if the Dialog is dismissed via the close button.
     *
     * @param title the title of the message box
     * @param message the message
     * @param callback the callback to fire when the user dismisses the dialog.
     */
    public static native void ask(String title, String message, BooleanCallback callback) /*-{
        $wnd.isc.ask(message, function(value) {
            var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
            callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
        }, {title:title});
    }-*/;


    public static native void askforValue(String message, ValueCallback callback) /*-{
        $wnd.isc.askForValue(message, function(value) {
            if(value === undefined) value = null;
            callback.@com.smartgwt.client.util.ValueCallback::execute(Ljava/lang/String;)(value);
        });
    }-*/;

    public static native void askforValue(String title, String message, ValueCallback callback) /*-{
        $wnd.isc.askForValue(message, function(value) {
            if(value === undefined) value = null;
            callback.@com.smartgwt.client.util.ValueCallback::execute(Ljava/lang/String;)(value);
        }, {title:title});
    }-*/;

    public static native void showPrompt(String message) /*-{
        $wnd.isc.showPrompt(message);
    }-*/;

    public static native void showPrompt(String title, String message) /*-{
        $wnd.isc.showPrompt(message, {title:title});
    }-*/;

    public static native void clearPrompt() /*-{
        $wnd.isc.clearPrompt();
    }-*/;

    public static native void confirm(String message, BooleanCallback callback) /*-{
        $wnd.isc.confirm(message, function(value) {
            var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
            callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
        });
    }-*/;

    public static native void confirm(String title, String message, BooleanCallback callback) /*-{
	    $wnd.isc.confirm(message, function(value) {
	        var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
	        callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
	    }, {title:title});
	}-*/;

    public static native void warn(String message, BooleanCallback callback) /*-{
        $wnd.isc.warn(message, function(value) {
            var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
            callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
        });
    }-*/;


     public static native void warn(String title, String message, BooleanCallback callback) /*-{
        $wnd.isc.warn(message, function(value) {
            var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
            callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
        }, {title:title});
    }-*/;

    /**
     * Log a warning.
     *
     * @param message the message to log
     */
    public static native void logWarn(String message) /*-{
    	$wnd.isc.logWarn(message);
	}-*/;

    /**
     * Log a warning.
     *
     * @param message  the message to log
     * @param category category to log in, defaults to "Log"
     */
    public static native void logWarn(String message, String category) /*-{
    	$wnd.isc.logWarn(message);
	}-*/;

    /**
     * Logs the echoed object as a warning, prefixed with an optional message.
     *
     * @param value object to echo
     * @param message the message to log
     */
    public static native void logEcho(JavaScriptObject value, String message) /*-{
    	$wnd.isc.logEcho(value, message);
	}-*/;

    /**
     * Logs the echoed object as a warning, prefixed with an optional message.
     *
     * @param value object to echo
     * @param message the message to log
     */
    public static native void logEchoAll(JavaScriptObject value, String message) /*-{
    	$wnd.isc.logEchoAll(value, message);
	}-*/;


}
