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

import java.util.HashSet;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.Canvas;

public class SC {
    public static final String REF = "__ref";

    public static native String generateID() /*-{        
        return $wnd.isc.ClassFactory.getNextGlobalID();
    }-*/;
    
    public static native String generateID(String className) /*-{
        var simpleName = className.substring(className.lastIndexOf(".")+1);
        //replace any $ characters from inner class names with an underscore
        simpleName = simpleName.replace("$", "_");
        return $wnd.isc.ClassFactory.getNextGlobalIDForClass(simpleName);
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
     * Gets the name of this underlying SmartClient class as a string.
     *
     * @param jsObj the smartclient object
     * @return the class name or null if not a smartclient class
     */
    public static native String getSCClassName(JavaScriptObject jsObj)/*-{
        return jsObj.getClassName ? jsObj.getClassName() : null;
    }-*/;

    /**
     * Return true if Firebug is enabled.
     *
     * @return true if firebug is enabled
     */
    public static native boolean hasFirebug() /*-{
        return ($wnd.isc.Browser.isMoz && $wnd.console != null && ($wnd.console.firebug != null || $wnd.console.exception != null));
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

    /**
     * Show a modal dialog with a message, icon, and "Yes" and "No" buttons. The callback will receive boolean true for an OK
     * button click, boolean false for a No button click, or null if the Dialog is dismissed via the close button.
     *
     * @param title the title of the message box
     * @param message the message
     * @param callback the callback to fire when the user dismisses the dialog.
     */
    public static native void ask(String title, String message, BooleanCallback callback, Dialog dialogProperties) /*-{
        var dialogPropertiesJS = dialogProperties.@com.smartgwt.client.widgets.Dialog::getConfig()();
        $wnd.isc.addProperties(dialogPropertiesJS, {title:title});
        $wnd.isc.ask(message, function(value) {
            var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
            callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
        }, dialogPropertiesJS);
    }-*/;

    /**
     * Show a modal dialog with a text entry box, asking the user to enter a value.
     * <p>
     * As with other convenience methods that show Dialogs, such as {@link #warn(String, String, BooleanCallback)} , the dialog is shown
     * and the function immediately returns.  When the user responds, the provided callback is called.
     * <p>
     * If the user clicks OK, the value typed in is passed to the callback (including the empty string ("") if nothing was entered.  If the
     * user clicks cancel, the value passed to the callback is null.
     *
     * <p>
     * A default value for the text field can be passed via <code>properties.defaultValue</code>
     *
     * <p>Keyboard focus is automatically placed in the text entry field, and hitting the enter key is the equivalent of pressing OK.
     *
     * @param message message to display
     * @param callback Callback to fire when the user clicks a button to dismiss the dialog. This has the single parameter 'value',
     * indicating the user entry, or null if cancel was pressed or the window closed
     */
    public static native void askforValue(String message, ValueCallback callback) /*-{
        $wnd.isc.askForValue(message, function(value) {
            if(value === undefined) value = null;
            callback.@com.smartgwt.client.util.ValueCallback::execute(Ljava/lang/String;)(value);
        }, {width:275});
    }-*/;

    /**
     * Show a modal dialog with a text entry box, asking the user to enter a value.
     * <p>
     * As with other convenience methods that show Dialogs, such as {@link #warn(String, String, BooleanCallback)} , the dialog is shown
     * and the function immediately returns.  When the user responds, the provided callback is called.
     * <p>
     * If the user clicks OK, the value typed in is passed to the callback (including the empty string ("") if nothing was entered.  If the
     * user clicks cancel, the value passed to the callback is null.
     *
     * <p>Keyboard focus is automatically placed in the text entry field, and hitting the enter key is the equivalent of pressing OK.
     *
     * @param title the title of the dialog
     * @param message message to display
     * @param callback Callback to fire when the user clicks a button to dismiss the dialog. This has the single parameter 'value',
     * indicating the user entry, or null if cancel was pressed or the window closed
     */
    public static native void askforValue(String title, String message, ValueCallback callback) /*-{
        $wnd.isc.askForValue(message, function(value) {
            if(value === undefined) value = null;
            callback.@com.smartgwt.client.util.ValueCallback::execute(Ljava/lang/String;)(value);
        }, {title:title, width:275});
    }-*/;

    /**
     * Show a modal dialog with a text entry box, asking the user to enter a value.
     * <p>
     * As with other convenience methods that show Dialogs, such as {@link #warn(String, String, BooleanCallback)} , the dialog is shown
     * and the function immediately returns.  When the user responds, the provided callback is called.
     * <p>
     * If the user clicks OK, the value typed in is passed to the callback (including the empty string ("") if nothing was entered.  If the
     * user clicks cancel, the value passed to the callback is null.
     *
     *
     * <p>Keyboard focus is automatically placed in the text entry field, and hitting the enter key is the equivalent of pressing OK.
     *
     * @param title the title of the dialog
     * @param message message to display
     * @param defaultValue the default value of the text field
     * @param callback Callback to fire when the user clicks a button to dismiss the dialog. This has the single parameter 'value',
     * indicating the user entry, or null if cancel was pressed or the window closed
     * @param dialogProperties additional properties of the Dialog
     */
    public static native void askforValue(String title, String message, String defaultValue, ValueCallback callback, Dialog dialogProperties) /*-{
        var dialogPropertiesJS = dialogProperties.@com.smartgwt.client.widgets.Dialog::getConfig()();
        $wnd.isc.addProperties(dialogPropertiesJS, {title:title}, {defaultValue:defaultValue});
        $wnd.isc.askForValue(message, function(value) {
            if(value === undefined) value = null;
            callback.@com.smartgwt.client.util.ValueCallback::execute(Ljava/lang/String;)(value);
        }, dialogPropertiesJS);
    }-*/;

    /**
     * Show a modal prompt to the user. This method will display the message using the Dialog.Prompt singleton object.
     * <p>
     * <b>Note</b>: if this prompt is to be shown to the user during some slow logic, we advise calling this method, then
     * using {@link com.google.gwt.user.client.DeferredCommand} to kick off the slow logic in a separate thread. This ensures that
     * the prompt is showing before the lengthy execution begins.
     *
     * @param message message to display
     * @see #clearPrompt()
     */
    public static native void showPrompt(String message) /*-{
        $wnd.isc.showPrompt(message);
    }-*/;

    /**
     * Show a modal prompt to the user. This method will display the message using the Dialog.Prompt singleton object.
     * <p>
     * <b>Note</b>: if this prompt is to be shown to the user during some slow logic, we advise calling this method, then
     * using {@link com.google.gwt.user.client.DeferredCommand} to kick off the slow logic in a separate thread. This ensures that
     * the prompt is showing before the lengthy execution begins.
     *
     * @param title the title of the dialog
     * @param message message to display
     * @param dialogProperties additional properties for the Dialog
     * @see #clearPrompt()
     */
    public static native void showPrompt(String title, String message, Dialog dialogProperties) /*-{
        var dialogPropertiesJS = dialogProperties.@com.smartgwt.client.widgets.Dialog::getConfig()();
        $wnd.isc.addProperties(dialogPropertiesJS, {title:title});
        $wnd.isc.showPrompt(message, dialogPropertiesJS);    
    }-*/;

    /**
     * Show a modal prompt to the user. This method will display the message using the Dialog.Prompt singleton object.
     * <p>
     * <b>Note</b>: if this prompt is to be shown to the user during some slow logic, we advise calling this method, then
     * using {@link com.google.gwt.user.client.DeferredCommand} to kick off the slow logic in a separate thread. This ensures that
     * the prompt is showing before the lengthy execution begins.
     *
     * @param title the title of the dialog
     * @param message message to display
     * @see #clearPrompt()
     */
    public static native void showPrompt(String title, String message) /*-{
        $wnd.isc.showPrompt(message, {title:title});
    }-*/;

    /**
     * Clear the modal prompt being shown to the user.
     */
    public static native void clearPrompt() /*-{
        $wnd.isc.clearPrompt();
    }-*/;

    /**
     * Show a modal dialog with a message, icon, and "OK" and "Cancel" buttons.
     * <p>
     * The callback will receive boolean true for an OK button click, or null for a Cancel click or if the Dialog is dismissed via the close button.
     *
     * @param message message to display
     * @param callback Callback to fire when the user clicks a button to dismiss the dialog.
     */
    public static native void confirm(String message, BooleanCallback callback) /*-{
        $wnd.isc.confirm(message, function(value) {
            var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
            callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
        });
    }-*/;

    /**
     * Show a modal dialog with a message, icon, and "OK" and "Cancel" buttons.
     * <p>
     * The callback will receive boolean true for an OK button click, or null for a Cancel click or if the Dialog is dismissed via the close button.
     *
     * @param title the title of the dialog
     * @param message message to display
     * @param callback Callback to fire when the user clicks a button to dismiss the dialog.
     */
    public static native void confirm(String title, String message, BooleanCallback callback) /*-{
	    $wnd.isc.confirm(message, function(value) {
	        var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
	        callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
	    }, {title:title});
	}-*/;

    /**
     * Show a modal dialog with a message, icon, and "OK" and "Cancel" buttons.
     * <p>
     * The callback will receive boolean true for an OK button click, or null for a Cancel click or if the Dialog is dismissed via the close button.
     *
     * @param title the title of the dialog
     * @param message message to display
     * @param callback Callback to fire when the user clicks a button to dismiss the dialog.
     * @param dialogProperties additional properties for the Dialog
     */
    public static native void confirm(String title, String message, BooleanCallback callback, Dialog dialogProperties) /*-{
        var dialogPropertiesJS = dialogProperties.@com.smartgwt.client.widgets.Dialog::getConfig()();
        $wnd.isc.addProperties(dialogPropertiesJS, {title:title});
	    $wnd.isc.confirm(message, function(value) {
	        var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
	        callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
	    }, dialogPropertiesJS);
	}-*/;

    /**
     * Show a modal dialog with a message, icon, and "OK" button.
     *
     * @param message the message
     */
    public static void warn(String message) {
        warn(message, null);
    }

    /**
     * Show a modal dialog with a message, icon, and "OK" button.
     * <p>
     * The callback will receive boolean true for an OK button click, or null if the Dialog is dismissed via the close button.
     *
     * @param message the message
     * @param callback Optional Callback to fire when the user dismisses the dialog.
     */
    public static native void warn(String message, BooleanCallback callback) /*-{
        $wnd.isc.warn(message, function(value) {
            var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
            if(callback != null) callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
        });
    }-*/;

    /**
     * Show a modal dialog with a message, icon, and "OK" button.
     * <p>
     * The callback will receive boolean true for an OK button click, or null if the Dialog is dismissed via the close button.
     *
     * @param title the title of the dialog
     * @param message the message
     * @param callback Optional Callback to fire when the user dismisses the dialog.
     * @param dialogProperties additional properties for the Dialog
     */
    public static native void warn(String title, String message, BooleanCallback callback, Dialog dialogProperties) /*-{
        var dialogPropertiesJS = dialogProperties.@com.smartgwt.client.widgets.Dialog::getConfig()();
        $wnd.isc.addProperties(dialogPropertiesJS, {title:title});
        $wnd.isc.warn(message, function(value) {
            var valueJ = value == null ? null : @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(value);
            if(callback != null) callback.@com.smartgwt.client.util.BooleanCallback::execute(Ljava/lang/Boolean;)(valueJ);
        }, dialogPropertiesJS);
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
     * Log an informative message.
     *
     * @param message the message to log
     */
    public static native void logInfo(String message) /*-{
    	$wnd.isc.Log.logInfo(message);
	}-*/;

    /**
     * Log an informative message.
     *
     * @param message  the message to log
     * @param category category to log in, defaults to "Log"
     */
    public static native void logInfo(String message, String category) /*-{
    	$wnd.isc.Log.logInfo(message, category);
	}-*/;

    /**
     * Log a debugging.
     *
     * @param message the message to log
     */
    public static native void logDebug(String message) /*-{
    	$wnd.isc.Log.logDebug(message);
	}-*/;

    /**
     * Log a debugging
     *
     * @param message  the message to log
     * @param category category to log in, defaults to "Log"
     */
    public static native void logDebug(String message, String category) /*-{
    	$wnd.isc.Log.logDebug(message, category);
	}-*/;

    /**
     * Logs the echoed object as a warning, prefixed with an optional message.
     *
     * @param value object to echo
     */
    public static native void logEcho(JavaScriptObject value) /*-{
    	$wnd.isc.logEcho(value);
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
     * @param canvas canvas to echo
     */
    public static native void logEcho(Canvas canvas) /*-{
    	$wnd.isc.logEcho(canvas.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()());
	}-*/;

    /**
     * Logs the echoed object as a warning, prefixed with an optional message.
     *
     * @param canvas canvas to echo
     * @param message the message to log
     */
    public static native void logEcho(Canvas canvas, String message) /*-{
    	$wnd.isc.logEcho(canvas.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()(), message);
	}-*/;

    /**
     * Logs the echoed object as a warning, prefixed with an optional message.
     *
     * @param value object to echo
     */
    public static native void logEchoAll(JavaScriptObject value) /*-{
    	$wnd.isc.logEchoAll(value);
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

    /**
     * Logs the echoed object as a warning, prefixed with an optional message.
     *
     * @param canvas canvas to echo
     */
    public static native void logEchoAll(Canvas canvas) /*-{
    	$wnd.isc.logEchoAll(canvas.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()());
	}-*/;

    /**
     * Setting this to true will result in the IE / Firebug / Safari debugger being invoked when a JavaScript error is encountered.
     * This is done by the execution of the commend "debugger;" when the error occurs. Setting this to true is useful
     * for debugging any javascript errors.
     *
     * @param useDebugger default is false
     */
    public static native void setEnableJSDebugger(boolean useDebugger) /*-{
    	$wnd.isc.useIEDebugger = useDebugger;
	}-*/;

    /**
     * Logs the echoed object as a warning, prefixed with an optional message.
     *
     * @param canvas canvas to echo
     * @param message the message to log
     */
    public static native void logEchoAll(Canvas canvas, String message) /*-{
    	$wnd.isc.logEchoAll(canvas.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()(), message);
	}-*/;
    
    /**
     * Returns the passed in JavaScript object as a string
     * @param object
     * @return
     */
    public static native String echo(JavaScriptObject object) /*-{
    	return $wnd.isc.Log.echo(object);
    }-*/;
    /**
     * Returns the passed in JavaScript object as a string (including serializing members
     * one level deep for javascript arrays and nested objects)
     * @param object
     * @return
     */
    public static native String echoAll(JavaScriptObject object) /*-{
		return $wnd.isc.Log.echoAll(object);
	}-*/;

    private static void requiresServerComponents() {
        String message = "This functionality requires SmartGWT server components";
        logWarn(message);
        throw new RuntimeException(message);
    }

    /**
     * Returns true is the optional Analytics module has been loaded.
     *
     * @return true if Analytics module is loaded
     */
    public static native boolean hasAnalytics()/*-{
        return $wnd.isc.CubeGrid != null;
    }-*/;

    /**
     * Returns true is the optional Charts module has been loaded.
     *
     * @return true if Charts module is loaded
     */
    public static native boolean hasCharts()/*-{
        return $wnd.isc.FacetChart != null;
    }-*/;

    /**
     * Returns true is the optional Drawing module has been loaded.
     *
     * @return true if Drawing module is loaded
     */
    public static native boolean hasDrawing()/*-{
        return $wnd.isc.DrawPane != null;
    }-*/;

    /**
     * Returns true is the optional PluginBridges module has been loaded.
     *
     * @return true if PluginBridges module is loaded
     */
    public static native boolean hasPluginBridges()/*-{
        return $wnd.isc.BrowserPlugin != null;
    }-*/;

    /**
     * Returns true is the optional RealtimeMessaging module has been loaded.
     *
     * @return true if RealtimeMessaging module is loaded
     */
    public static native boolean hasRealtimeMessaging()/*-{
        return $wnd.isc.Messaging != null;
    }-*/;
    
    /**
     * Enables full screen reader mode. Must be called before any components are created. See {@link com.smartgwt.client.docs.Accessibility}.
     * @param new state for screen reader mode (true for enabled, false for disabled)
     */
    public static native void setScreenReaderMode(boolean newState) /*-{
        $wnd.isc.setScreenReaderMode(newState);
    }-*/;
}
