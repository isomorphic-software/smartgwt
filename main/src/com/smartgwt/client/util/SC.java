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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.types.LogPriority;

public class SC {
    public static final String REF = "__ref";
    public static final String MODULE = "__module";
    public static final String AUTOID = "_autoAssignedID";
    public static final String AUTOIDCLASS = "AUTOIDClass";

    /**
     * Internal method - do not call from Application code.
     */
    public static native String getLicenseType() /*-{
        return $wnd.isc.licenseType;
    }-*/;

    /**
     * Internal method - do not call from Application code.
     */
    public static native String getAUTOIDClass(String className) /*-{
        var simpleName = className.substring(className.lastIndexOf(".")+1);
        //replace any $ characters from inner class names with an underscore
        simpleName = simpleName.replace("$", "_");
        return simpleName;
    }-*/;

    /**
     * Internal method - do not call from Application code.
     */
    public static native String generateID() /*-{        
        return $wnd.isc.ClassFactory.getNextGlobalID();
    }-*/;
    
    /**
     * Internal method - do not call from Application code.
     */
    public static native String generateID(String className) /*-{
        return $wnd.isc.ClassFactory.getNextGlobalIDForClass(className);
    }-*/;

    /**
     * Internal method - do not call from Application code.
     */
    // One complication is that in "keep globals" mode, the SGWT wrapper's current SC
    // jsObj will actually also be bound under the old ID!  To avoid problems in this case, we
    // don't immediately release it but merely update the ID class to the right value.  We also
    // log a warning if we're not able to release the ID and it's not expected.
    public static native void releaseID(String className, String id) /*-{
        var simpleName = @com.smartgwt.client.util.SC::getAUTOIDClass(Ljava/lang/String;)(className);
        // handle "keep globals" mode where spurious $wnd bindings are present
        if (id == null || $wnd.window[id] == null) {
            $wnd.isc.ClassFactory.releaseGlobalID(simpleName, id);
        } else {
            if (!$wnd.isc.keepGlobals) {
                var message = "Unexpected global binding found for ID " + id +
                    " in SC::releaseID; unable to release it for use by a new SC JS object.";
                @com.smartgwt.client.util.SC::logWarn(Ljava/lang/String;)(message);
            }
            else if ($wnd.isc.autoAssignedTempGlobals[id]) {
                     $wnd.isc.autoAssignedTempGlobals[id] = simpleName;
            }
        }
    }-*/;

    /**
     * Internal method - do not call from Application code.
     */
    public static native boolean keepGlobals() /*-{
        return !!$wnd.isc.keepGlobals;                                             
    }-*/;

    /**
     * Get the root directory for Isomorphic-supplied SmartClient files - the directory
     * containing the modules/ and system/ subdirectories extracted when the SmartGWT project is
     * built.  This property is commonly specified directly in the bootstrap HTML file by
     * setting <code>window.isomorphicDir</code> before loading the SmartClient library files.
     * @return <code>isomorphicDir</code> {@link com.smartgwt.client.docs.URL URL}
     */
    public static native String getHome() /*-{
        return $wnd.isomorphicDir;
    }-*/;

    /**
     * Launch the browser's JavaScript debugger.  See {@link com.smartgwt.client.docs.Debugging}
     * for how to approach debugging a SmartGWT Application.
     */
    public static native void debugger()/*-{
        debugger;
    }-*/;

    /**
     * Open the SmartClient Developer Console. See {@link com.smartgwt.client.docs.Debugging}
     * for how to approach debugging a SmartGWT Application.
     */
    public static native void showConsole()/*-{
        $wnd.isc.showConsole();
    }-*/;

    /**
     * Opens the DataSource admin console in a separate window.
     *
     * <p><em><b>Requires Smart GWT Pro or better.</b></em>
     */
    public static void openDataSourceConsole() {
        if ("LGPL".equals(getLicenseType())) {
            final String errorMessage = "The DataSource admin console feature requires Smart GWT Pro or better.";
            logWarn(errorMessage);
            throw new UnsupportedOperationException();
        }
        Window.open(GWT.getModuleBaseURL() + "tools/adminConsole.jsp", "ds_blank", null);
    }

    /**
     * Opens the SmartClient Visual Builder in a separate window. Note that the Visual Builder is capable of generating
     * DataSources as well, however unlike the DataSource Generator Wizard, it cannot generate DataSources in batches.
     *
     * <p><em><b>Requires Smart GWT Pro or better.</b></em>
     * @deprecated The Visual Builder tool has been superceded by Reify
     */
    public static void openVisualBuilder() {
        if ("LGPL".equals(getLicenseType())) {
            final String errorMessage = "The VisualBuilder feature requires Smart GWT Pro or better.";
            logWarn(errorMessage);
            throw new UnsupportedOperationException();
        }
        
        SC.logWarn("The Visual Builder tool has been superceded by Reify - see the documentation at " +
                "https://www.smartclient.com/smartgwtee-latest/javadoc/com/smartgwt/client/docs/Reify.html for more information.");
        
        Window.open(GWT.getModuleBaseURL() + "tools/visualBuilder/index.jsp", "vb_blank", null);
    }

    /**
     * Opens the DataSource Generator Wizard in a separate window.
     *
     * <p><em><b>Requires Smart GWT Enterprise or Eval.</b></em>
     */
    public static void openDataSourceGenerator() {
        final String licenseType = getLicenseType();
        if (!"Enterprise".equals(licenseType) &&
            !"Eval".equals(licenseType) &&
            !("$" + "{" + "licenseType}").equals(licenseType))
        {
            final String errorMessage = "The DataSource Generator Wizard feature requires Smart GWT Enterprise or Eval.";
            logWarn(errorMessage);
            throw new UnsupportedOperationException();
        }
        Window.open(GWT.getModuleBaseURL() + "tools/dsGenerator.jsp", "ds_wizard_blank", null);
    }

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
     * Returns <code>true</code> if Firebug is enabled.
     *
     * @return <code>true</code> if Firebug is enabled; <code>false</code> otherwise.
     */
    public static native boolean hasFirebug() /*-{
        // http://stackoverflow.com/questions/398111/javascript-that-detects-firebug
        // Note that console.exception was added to Firefox 28, so we need to check whether console.exception
        // is a native function or not.
        // https://developer.mozilla.org/en-US/docs/Web/API/console.error
        return ($wnd.isc.Browser.isMoz &&
                $wnd.console != null &&
                ($wnd.console.firebug != null ||
                 ($wnd.console.exception != null &&
                  ($wnd.isc.Browser.version <= 27 || $wnd.console.exception.toString().indexOf("[native code]") < 0))));
    }-*/;

    /**
     * Internal method - do not call from Application code.
     */
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
     * Show a modal dialog with a message, icon, and "OK" button. Intended for notifications which are not 
     * really warnings (default icon is less severe). See {@link com.smartgwt.client.widgets.Dialog#setSayIcon sayIcon}.
     *
     * @param message the message
     */
    public static native void say(String message) /*-{
        $wnd.isc.say(message);
    }-*/;

    /**
     * Set the priority for a log category.
     *
     * @param category the name of the category to set the priority for
     * @param priority the LogPriority to set for the passed category 
     */
    public static native void setLogPriority(String category, LogPriority priority) /*-{
        var sPriority = priority.getValue();
        var iPriority = 0;
        if (sPriority == "fatal") iPriority = 1;
        else if (sPriority == "error") iPriority = 2;
        else if (sPriority == "warn") iPriority = 3;
        else if (sPriority == "info") iPriority = 4;
        else if (sPriority == "debug") iPriority = 5;
        $wnd.isc.Log.setPriority(category, iPriority);
    }-*/;

    /**
     * Clear the priority for a log category.
     *
     * @param category the name of the category to clear the log priority of
     */
    public static native void clearLogPriority(String category) /*-{
        $wnd.isc.Log.clearPriority(category);
    }-*/;

    /**
     * Show a modal dialog with a message, icon, and "OK" button. Intended for notifications which are not 
     * really warnings (default icon is less severe). See {@link com.smartgwt.client.widgets.Dialog#setSayIcon sayIcon}.
     *
     * @param title the title of the message box
     * @param message the message
     */
    public static native void say(String title, String message) /*-{
	    $wnd.isc.say(message, {title:title});
	}-*/;



    /**
     * Show a modal dialog with a message, icon, and "OK" button. Intended for notifications which are not 
     * really warnings (default icon is less severe). See {@link com.smartgwt.client.widgets.Dialog#setSayIcon sayIcon}.
     * <p>
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
     * Show a modal dialog with a message, icon, and "OK" button. Intended for notifications which are not 
     * really warnings (default icon is less severe). See {@link com.smartgwt.client.widgets.Dialog#setSayIcon sayIcon}.
     * <p>
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
     * Show a modal dialog with a message, icon, and "Yes" and "No" buttons. See {@link com.smartgwt.client.widgets.Dialog#setAskIcon askIcon}.
     * <P>
     * The callback will receive boolean true for a Yes
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
     * Show a modal dialog with a message, icon, and "Yes" and "No" buttons. See {@link com.smartgwt.client.widgets.Dialog#setAskIcon askIcon}.
     * <P>
     * The callback will receive boolean true for a Yes
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
     * Show a modal dialog with a message, icon, and "Yes" and "No" buttons. See {@link com.smartgwt.client.widgets.Dialog#setAskIcon askIcon}.
     * <P>
     * The callback will receive boolean true for a Yes
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
     * If a dialog triggered via {@link #say(String)}, {@link #ask(String, BooleanCallback)},
     * {@link #warn(String)}, {@link #confirm(String, BooleanCallback)} or {@link #askforValue(String, ValueCallback)}
     * is currently visible, it will be dismissed.  The callback passed to the relevant method will never fire.
     * <p>
     * Note this is a rarely used API with very few valid use cases.  As an example, perhaps some kind of
     * periodic (non-user triggered) event would cause an entire area of the UI to be removed (such as a tab)
     * and the system wants to ensure that no modal dialogs are currently showing from that part of the UI.
     * In this case, while <code>dismissCurrentDialog</code> could be used to ensure the part of the UI being
     * removed didn't leave behind a modal dialog.
     * <p>
     * To clear a modal prompt shown by {@link #showPrompt(String)}, use {@link #clearPrompt()} instead.
     */
    public static native void dismissCurrentDialog() /*-{
        $wnd.isc.dismissCurrentDialog();
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
     * Show a modal dialog with a message, icon, and "OK" and "Cancel" buttons. See {@link com.smartgwt.client.widgets.Dialog#setConfirmIcon confirmIcon}.
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
     * Show a modal dialog with a message, icon, and "OK" and "Cancel" buttons. See {@link com.smartgwt.client.widgets.Dialog#setConfirmIcon confirmIcon}.
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
     * Show a modal dialog with a message, icon, and "OK" and "Cancel" buttons. See {@link com.smartgwt.client.widgets.Dialog#setConfirmIcon confirmIcon}.
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
     * Show a modal dialog with a message, icon, and "OK" button. See {@link com.smartgwt.client.widgets.Dialog#setWarnIcon warnIcon}.
     *
     * @param message the message
     */
    public static void warn(String message) {
        warn(message, (BooleanCallback) null);
    }

    /**
     * Show a modal dialog with a message, icon, and "OK" button. See {@link com.smartgwt.client.widgets.Dialog#setWarnIcon warnIcon}.
     * <p>
     *
     * @param title the title of the dialog
     * @param message the message
     */
    public static native void warn(String title, String message) /*-{
        $wnd.isc.warn(message, {title:title});
    }-*/;

    /**
     * Show a modal dialog with a message, icon, and "OK" button. See {@link com.smartgwt.client.widgets.Dialog#setWarnIcon warnIcon}.
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
     * Show a modal dialog with a message, icon, and "OK" button. See {@link com.smartgwt.client.widgets.Dialog#setWarnIcon warnIcon}.
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
    	$wnd.isc.logWarn(message, category);
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
     * Check whether a message logged at "info" priority would be visible in the log.
     * Use this method to avoid putting together expensive log messages if they will
     * never appear in the log.
     *
     * @param category category to check; defaults to "Log"
     */
    public static native boolean logIsInfoEnabled(String category) /*-{
        return $wnd.isc.Log.logIsInfoEnabled(category);
    }-*/;

    /**
     * Return a very short (generally less than 40 characters) string representation of any object, 
     * suitable for viewing by a developer for debugging purposes.
     *
     * @param value object to echo
     * @return a short string representation of the object.
     */
    public static native String echoLeaf(Object value) /*-{
        return $wnd.isc.echoLeaf(value);
    }-*/;
    
    /**
     * Check whether a message logged at "debug" priority would be visible in the log.
     * Use this method to avoid putting together expensive log messages if they will
     * never appear in the log.
     *
     * @param category category to check; defaults to "Log"
     */
    public static native boolean logIsDebugEnabled(String category) /*-{
        return $wnd.isc.Log.logIsDebugEnabled(category);
    }-*/;

    /**
     * @see #notify
     */
    public static MessageID notify(String contents) {
        return notify(contents, null, null);
    }

    /**
     * @see #notify
     */
    public static MessageID notify(String contents, NotifyAction... actions) {
        return notify(contents, actions, null);
    }

    /**
     * Displays a new message that's automatically dismissed after a configurable amount of
     * time, as an alternative to {@link #confirm,modal notification} dialogs that can lower end
     * user productivity.
     * <P>
     * This method is simply a shorthand way to call
     * {@link com.smartgwt.client.widgets.notify.Notify#addMessage Notify.addMessage()}.  For
     * further study, see the {@link com.smartgwt.client.widgets.notify.Notify Notify} class
     * overview, and the class methods 
     * {@link com.smartgwt.client.widgets.notify.Notify#dismissMessage Notify.dismissMessage()}.
     * {@link com.smartgwt.client.widgets.notify.Notify#configureMessages Notify.configureMessages()}.
     *
     * @param contents message to be displayed.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @param actions actions (if any) for this message
     * @param notifyType category of message; default "message".
     * See {@link com.smartgwt.client.docs.NotifyType NotifyType}
     *
     * @return opaque identifier for message
     */
    public static native MessageID notify(String contents, NotifyAction[] actions, String notifyType) /*-{
        return $wnd.isc.Notify.addMessage(contents, actions, notifyType);
    }-*/;

   /**
     * Returns the current stack trace, from a JavaScript perspective.  This should provide
     * meaningful JS stack frames for Java code in Super Development Mode, and in Production
     * Mode, if GWT compilation has been configured with options such as "&#8209;optimize&nbsp;0"
     * and/or "&#8209;style&nbsp;PRETTY" to disable obfuscation.  Frames corresponding to the
     * native SmartClient Framework will be obfuscated unless the GWT project is 
     * {@link com.smartgwt.client.docs.DebugModules configured for debugging}.
     * <P>
     * In Classic DevMode, this API will provide very limited information - stack frames
     * corresponding to Java code will likely be displayed as anonymous functions, and many or
     * most such frames will be missing.  For DevMode, it's preferable to use GWT-supported Java
     * APIs to capture the stack, such as for example:
     * <pre>
     *     Throwable t = new Throwable();
     *
     *     String stack = "";
     *     for (StackTraceElement element : t.getStackTrace()) {
     *         stack += element + "\n";
     *     }
     *
     *     SC.logDebug("Current location: " + stack);
     * </pre>
     * Grabbing Java <ocde>StackTraceElement</code>s in Super Development Mode or Production
     * Mode will work, but won't provide any added benefit as in DevMode.
     *
     * @see com.smartgwt.client.docs.Debugging
     */
    public static native String getJSStackTrace() /*-{
        return $wnd.isc.Class.getStackTrace();
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
     * Returns true if the optional Analytics module has been loaded.
     *
     * @return true if Analytics module is loaded
     */
    public static native boolean hasAnalytics()/*-{
        return $wnd.isc.hasOptionalModule("Analytics");
    }-*/;

    /**
     * Returns true if the optional Charts module has been loaded.
     *
     * @return true if Charts module is loaded
     */
    public static native boolean hasCharts()/*-{
        return $wnd.isc.FacetChart != null;
    }-*/;

    /**
     * Returns true if the optional Tour module has been loaded.
     *
     * @return true if Tour module is loaded
     */
    public static native boolean hasTour()/*-{
        return $wnd.isc.Tour != null;
    }-*/;
    
    /**
     * Returns true if the optional Workflow module has been loaded.
     *
     * @return true if Drawing module is loaded
     */
    public static native boolean hasWorkflow()/*-{
        return $wnd.isc.Process != null;
    }-*/;
    
    /**
     * Returns true if the optional Drawing module has been loaded.
     *
     * @return true if Drawing module is loaded
     */
    public static native boolean hasDrawing()/*-{
        return $wnd.isc.DrawPane != null;
    }-*/;

    /**
     * Returns true if the optional PluginBridges module has been loaded.
     *
     * @return true if PluginBridges module is loaded
     */
    public static native boolean hasPluginBridges()/*-{
        return $wnd.isc.BrowserPlugin != null;
    }-*/;

    /**
     * Returns true if the optional RealtimeMessaging module has been loaded.
     *
     * @return true if RealtimeMessaging module is loaded
     */
    public static native boolean hasRealtimeMessaging()/*-{
        return $wnd.isc.hasOptionalModule("RealtimeMessaging");
    }-*/;

    /**
     * Returns true if the optional Dashboard &amp; Tools module is available.
     * 
     * @return true if Dashboard &amp; Tools module is available.
     */
    public static native boolean hasDashboardAndTools()/*-{
        return ($wnd.isc.EditContext != null) && !$wnd.isc.EditContext.vbOnly;
    }-*/;
    
    /**
     * Enables full screen reader mode. Must be called before any components are created. See {@link com.smartgwt.client.docs.Accessibility}.
     * @param new state for screen reader mode (true for enabled, false for disabled)
     */
    public static native void setScreenReaderMode(boolean newState) /*-{
        $wnd.isc.setScreenReaderMode(newState);
    }-*/;

    /**
     * Returns true if the method is supported by the class, meaning that it is not null
     * and was not replaced by {@link #markUnsupportedMethods(String, String, String[])}. 
     *
     * @param className className to check
     * @param methodName methodName to check
     * @return boolean true if the method is not null and is not an unsupported method; false otherwise.
     */
    public static native boolean isMethodSupported(String className, String methodName) /*-{
        return $wnd.isc[className].isMethodSupported(methodName);
    }-*/;

    /**
     * Replaces each of the methods named in methodNames with a new implementation that
     * simply logs a warning the first time the method is called, and nothing else.
     * This can be used to mark methods of derived classes which do not support certain
     * parent class methods as unsupported.
     * <P>
     * The messageTemplate parameter is a template for the warning message logged when
     * the unsupported method is first called. The following variables in the template
     * are substituted as follows:
     * <table border="1">
     * <tr>
     *   <th>Variable</th>
     *   <th>Substitution</th>
     * </tr>
     * <tr>
     *   <td><code>$class</code></td>
     *   <td>The +link{getClassName(),class name}.</td>
     * </tr>
     * <tr>
     *   <td><code>$method</code></td>
     *   <td>The name of the method.</td>
     * </tr>
     * </table>
     * <P>
     * If you want the literal string of a substitution variable to appear in the warning message,
     * you can escape it by prefixing with a dollar sign. For example, to include "$class" in the
     * warning message, use "$$class" in the template. 
     *
     * @param className className containing methods to mark
     * @param messageTemplate template for the warning message logged when first called.
     * 						  If null, the default template string "$class does not support
     * 						  the $method() method." is used.
     * @param methodNames the method names to mark as unsupported.
     */
    public static native void markUnsupportedMethods(String className, String messageTemplate, String[] methodNames) /*-{
        $wnd.isc[className].markUnsupportedMethods(messageTemplate, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(methodNames));
    }-*/;

    /**
     *  Causes a stack trace to be logged any time a message containing the provided pattern is
     *  logged.  This can help figure out the origin of warnings or other mysterious logs in a large
     *  complex application.
     *  <p>
     *  The passed <code>messagePattern</code> is interpreted as a JavaScript regular expression.
     *  
     * @param messagePattern
     */
    public static native void traceLogMessage(String messagePattern) /*-{
    	$wnd.isc.Log.traceLogMessage(messagePattern);
    }-*/;

    /**
     *  Causes a stack trace to be logged any time a message containing the provided pattern is
     *  logged.  This can help figure out the origin of warnings or other mysterious logs in a large
     *  complex application.
     *  <p>
     *  The passed <code>messagePattern</code> is interpreted as a JavaScript regular expression.
     *  
     * @param messagePattern
     * @param prefix value to prefix the message
     */
    public static native void traceLogMessage(String messagePattern, String prefix) /*-{
    	$wnd.isc.Log.traceLogMessage(messagePattern, prefix);
    }-*/;


    /**
     * Internal method - do not call from Application code.
     */
    public static native String getScVersion() /*-{
        return $wnd.isc.scVersion;
    }-*/;

    /**
     * Internal method - do not call from Application code.
     */
    public static native String getScVersionNumber() /*-{
        return $wnd.isc.scVersionNumber;
    }-*/;

    /**
     * Internal method - do not call from Application code.
     */
    public static native String getSgwtVersion() /*-{
        return $wnd.isc.sgwtVersion;
    }-*/;


    /**
     * Internal method - do not call from Application code.
     */
    public static native String getSgwtVersionNumber() /*-{
        return $wnd.isc.sgwtVersionNumber;
    }-*/;

    /**
     * Internal method - do not call from Application code.
     */
    public static native String getScParityStableVersionNumber() /*-{
        return $wnd.isc.scParityStableVersionNumber;
    }-*/;

    /**
     * Internal method - do not call from Application code.
     */
    public static native String getSgwtParityStableVersionNumber() /*-{
        return $wnd.isc.sgwtParityStableVersionNumber;
    }-*/;


    /**
     * Internal method - do not call from Application code.
     */
    public static boolean isStable() {
        return getSgwtVersion().endsWith("p");
    }
}
