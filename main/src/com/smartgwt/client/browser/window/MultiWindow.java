/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
package com.smartgwt.client.browser.window;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;


/**
 * Provides tracking of other Smart GWT browser windows opened by the original window, as {@link
 * com.smartgwt.client.browser.window.RemoteWindow RemoteWindows}. <p> Includes APIs for:<ul> <li>Registering event
 * listeners for events on other windows <li>Opening a new window and finding a window by name <li>Moving, activating, or
 * deactiving a window by name <li>Sharing DataSources and their caches between Smart GWT windows <li>Sharing {@link
 * com.smartgwt.client.docs.Messaging} channels between Smart GWT windows</ul> <p> Within the <a
 * href='https://developers.openfin.co/of-docs/docs' target='_blank'>OpenFin</a> environment, the underlying implementation
 * is actually via the OpenFin class. <p> Reloading of child windows is in general supported (but see {@link
 * com.smartgwt.client.browser.window.MultiWindow#autoCopyDataSources autoCopyDataSources}), while reloading the {@link
 * com.smartgwt.client.browser.window.MultiWindow#isMainWindow main window} currently is not. <p> <b>Note:</b> this is
 * currently an experimental feature and not supported except by special arrangement.
 */
@BeanFactory.FrameworkClass
public class MultiWindow {


    // ********************* Properties / Attributes ***********************

    /** 
     * Should {@link com.smartgwt.client.data.DataSource DataSources} from other OpenFin windows with Smart GWT loaded be
     * copied by reference into this window?  Such DataSources will be copied:<ul> <li>when a page in another window is loaded
     * (potentially several DataSources at once) <li>at the moment DataSources are created in a page loaded in another window
     * (just that DataSource)</ul> <p> This property will default to true if OpenFin is present; otherwise, false. <p> Note
     * that reloading a page that created DataSources copied by reference into other windows (via this property) is not
     * supported.
     *
     * @param autoCopyDataSources new autoCopyDataSources.  Default value is varies.
     */
    public static native void setAutoCopyDataSources(Boolean autoCopyDataSources) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/Boolean;)($wnd.isc.MultiWindow, "autoCopyDataSources", autoCopyDataSources);
    }-*/;

    /** 
     * Should {@link com.smartgwt.client.data.DataSource DataSources} from other OpenFin windows with Smart GWT loaded be
     * copied by reference into this window?  Such DataSources will be copied:<ul> <li>when a page in another window is loaded
     * (potentially several DataSources at once) <li>at the moment DataSources are created in a page loaded in another window
     * (just that DataSource)</ul> <p> This property will default to true if OpenFin is present; otherwise, false. <p> Note
     * that reloading a page that created DataSources copied by reference into other windows (via this property) is not
     * supported.
     *
     * @return current value of autoCopyDataSources
     */
    public static native Boolean getAutoCopyDataSources() /*-{
        var result = $wnd.isc.MultiWindow.autoCopyDataSources;
        if (result == null) result = null;
        if (!@com.google.gwt.core.client.GWT::isScript()()) result = result.valueOf();
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(result);
    }-*/;

    /** 
     * Should this window share {@link com.smartgwt.client.docs.Messaging Realtime Messaging} channels with other windows? <p>
     * This property will default to true if OpenFin is present; otherwise, false.
     *
     * @param shareMessageChannels new shareMessageChannels.  Default value is varies.
     */
    public static native void setShareMessageChannels(Boolean shareMessageChannels) /*-{
        @com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/Boolean;)($wnd.isc.MultiWindow, "shareMessageChannels", shareMessageChannels);
    }-*/;

    /** 
     * Should this window share {@link com.smartgwt.client.docs.Messaging Realtime Messaging} channels with other windows? <p>
     * This property will default to true if OpenFin is present; otherwise, false.
     *
     * @return current value of shareMessageChannels
     */
    public static native Boolean getShareMessageChannels() /*-{
        var result = $wnd.isc.MultiWindow.shareMessageChannels;
        if (result == null) result = null;
        if (!@com.google.gwt.core.client.GWT::isScript()()) result = result.valueOf();
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(result);
    }-*/;

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Activates (focuses) the existing window with the specified name,
     * @param name unique window name
     */
    public static native void activate(String name) /*-{
        $wnd.isc.MultiWindow.activate(name);
    }-*/;

	/**
     * Activates (focuses) the existing window with the specified name,
     * @param name unique window name
     * @param callback callback run after {@link com.smartgwt.client.browser.window.RemoteWindow}                                         
     * activated
     */
    public static native void activate(String name, RemoteWindowCallback callback) /*-{
        $wnd.isc.MultiWindow.activate(name, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	

	/**
     * Brings the existing window with the specified name to the top of the window stack.
     * @param name unique window name
     */
    public static native void bringToFront(String name) /*-{
        $wnd.isc.MultiWindow.bringToFront(name);
    }-*/;

	/**
     * Brings the existing window with the specified name to the top of the window stack.
     * @param name unique window name
     * @param callback callback run after {@link com.smartgwt.client.browser.window.RemoteWindow}                                              
     * is brought to the front
     */
    public static native void bringToFront(String name, RemoteWindowCallback callback) /*-{
        $wnd.isc.MultiWindow.bringToFront(name, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	

	/**
     * Unregisters a previously registered window event listener.  The event type and ID returned by the original {@link
     * com.smartgwt.client.browser.window.MultiWindow#setEvent setEvent()} call should be passed.
     * @param eventType event type to register
     * @see com.smartgwt.client.browser.window.MultiWindow#setEvent
     */
    public static native void clearEvent(MultiWindowEvent eventType) /*-{
        $wnd.isc.MultiWindow.clearEvent(eventType.@com.smartgwt.client.types.MultiWindowEvent::getValue()());
    }-*/;

	/**
     * Unregisters a previously registered window event listener.  The event type and ID returned by the original {@link
     * com.smartgwt.client.browser.window.MultiWindow#setEvent setEvent()} call should be passed.
     * @param eventType event type to register
     * @param ID ID of the event to clear.  If not specified, all                                     events of eventType will be
     * cleared.
     * @see com.smartgwt.client.browser.window.MultiWindow#setEvent
     */
    public static native void clearEvent(MultiWindowEvent eventType, int ID) /*-{
        $wnd.isc.MultiWindow.clearEvent(eventType.@com.smartgwt.client.types.MultiWindowEvent::getValue()(), ID);
    }-*/;
	

	/**
     * Closes the existing window with the specified name,
     * @param name unique window name
     */
    public static native void close(String name) /*-{
        $wnd.isc.MultiWindow.close(name);
    }-*/;

    /**
     * @see MultiWindow#close
     */
    public static void close(String name, boolean force){
        close(name, force, null);
    }

	/**
     * Closes the existing window with the specified name,
     * @param name unique window name
     * @param force whether to force it closed
     * @param callback callback run after {@link com.smartgwt.client.browser.window.RemoteWindow} closed
     */
    public static native void close(String name, boolean force, RemoteWindowCallback callback) /*-{
        $wnd.isc.MultiWindow.close(name, force, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	

	/**
     * Deactivates (blurs) the existing window with the specified name,
     * @param name unique window name
     */
    public static native void deactivate(String name) /*-{
        $wnd.isc.MultiWindow.deactivate(name);
    }-*/;

	/**
     * Deactivates (blurs) the existing window with the specified name,
     * @param name unique window name
     * @param callback callback run after {@link com.smartgwt.client.browser.window.RemoteWindow}                                         
     * deactivated
     */
    public static native void deactivate(String name, RemoteWindowCallback callback) /*-{
        $wnd.isc.MultiWindow.deactivate(name, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	

	/**
     * Returns window with the specified name, if it exists in the application.  Note that, without OpenFin, only windows
     * created with {@link com.smartgwt.client.browser.window.MultiWindow#open open()} (and the base window) can be found with
     * this method.
     * @param name unique window name
     *
     * @return requested window
     */
    public static native RemoteWindow find(String name) /*-{
        var ret = $wnd.isc.MultiWindow.find(name);
        if(ret == null) return null;
        return @com.smartgwt.client.browser.window.RemoteWindow::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Returns the {@link com.smartgwt.client.widgets.DataContext} provided by the {@link
     * com.smartgwt.client.browser.window.MultiWindow#open open()} call that opened this window, or a newly created (on demand)
     * {@link com.smartgwt.client.widgets.DataContext} if this is the main application window, or no DataContext was provided.
     *
     * @return {@link com.smartgwt.client.widgets.DataContext} for this window
     */
    public static native DataContext getDataContext() /*-{
        var ret = $wnd.isc.MultiWindow.getDataContext();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.DataContext::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Returns the {@link com.smartgwt.client.browser.window.RemoteWindow} instance for the current window (where the method
     * was called).
     *
     * @return instance wrapping the current window
     */
    public static native RemoteWindow getLocalWindow() /*-{
        var ret = $wnd.isc.MultiWindow.getLocalWindow();
        if(ret == null) return null;
        return @com.smartgwt.client.browser.window.RemoteWindow::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Returns a list of {@link com.smartgwt.client.browser.window.RemoteWindow} for the other currently known windows
     * (excluding the {@link com.smartgwt.client.browser.window.MultiWindow#getLocalWindow local window}).  This would
     * typically only be used to initialize logic dependent on other windows.  You'd want to add a handler for the {@link
     * package com.smartgwt.client.browser.window.events.OtherWindowsChangedEvent}.  to ensure you keep things updated as
     * windows are opened or closed.
     *
     * @return current set of other RemoteWindows.
     */
    public static native RemoteWindow[] getOtherWindows() /*-{
        var ret = $wnd.isc.MultiWindow.getOtherWindows();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfRemoteWindow(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Returns the parent {@link com.smartgwt.client.browser.window.RemoteWindow} instance that opened this window.
     *
     * @return instance wrapping the parent window or null
     */
    public static native RemoteWindow getParentWindow() /*-{
        var ret = $wnd.isc.MultiWindow.getParentWindow();
        if(ret == null) return null;
        return @com.smartgwt.client.browser.window.RemoteWindow::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Hides the existing window with the specified name,
     * @param name unique window name
     */
    public static native void hide(String name) /*-{
        $wnd.isc.MultiWindow.hide(name);
    }-*/;

	/**
     * Hides the existing window with the specified name,
     * @param name unique window name
     * @param callback callback run after {@link com.smartgwt.client.browser.window.RemoteWindow}                                              
     * hidden
     */
    public static native void hide(String name, RemoteWindowCallback callback) /*-{
        $wnd.isc.MultiWindow.hide(name, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	

	/**
     * Returns whether this {@link com.smartgwt.client.browser.window.RemoteWindow} wraps the main application window.
     *
     * @return whether this instance wraps the main application window
     */
    public static native boolean isMainWindow() /*-{
        var ret = $wnd.isc.MultiWindow.isMainWindow();
        return ret == null ? false : ret;
    }-*/;


	/**
     * Checks whether a window with the specified name is showing.  Callback returns null if the window cannot be found;
     * otherwise returns true or false according as it's showing.
     * @param name unique window name
     * @param callback callback to receive output
     */
    public static native void isShowing(String name, RemoteWindowBooleanCallback callback) /*-{
        $wnd.isc.MultiWindow.isShowing(name, 
			$entry( function(remoteWindow, result) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowBooleanCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;Ljava/lang/Boolean;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null, 
					result == null ? null : result.@java.lang.Boolean::booleanValue()()
				);
			}));
    }-*/;


	/**
     * Maximizes the existing window with the specified name,
     * @param name unique window name
     */
    public static native void maximize(String name) /*-{
        $wnd.isc.MultiWindow.maximize(name);
    }-*/;

	/**
     * Maximizes the existing window with the specified name,
     * @param name unique window name
     * @param callback callback run after {@link com.smartgwt.client.browser.window.RemoteWindow}                                              
     * maximized
     */
    public static native void maximize(String name, RemoteWindowCallback callback) /*-{
        $wnd.isc.MultiWindow.maximize(name, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	

	/**
     * Minimizes the existing window with the specified name,
     * @param name unique window name
     */
    public static native void minimize(String name) /*-{
        $wnd.isc.MultiWindow.minimize(name);
    }-*/;

	/**
     * Minimizes the existing window with the specified name,
     * @param name unique window name
     * @param callback callback run after {@link com.smartgwt.client.browser.window.RemoteWindow}                                              
     * minimized
     */
    public static native void minimize(String name, RemoteWindowCallback callback) /*-{
        $wnd.isc.MultiWindow.minimize(name, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	

	/**
     * Moves the existing window with the specified name,
     * @param name unique window name
     * @param x desired x-offset of left edge
     * @param y desired y-offset of top edge
     */
    public static native void move(String name, int x, int y) /*-{
        $wnd.isc.MultiWindow.move(name, x, y);
    }-*/;

	/**
     * Moves the existing window with the specified name,
     * @param name unique window name
     * @param x desired x-offset of left edge
     * @param y desired y-offset of top edge
     * @param callback callback run after {@link com.smartgwt.client.browser.window.RemoteWindow} moved
     */
    public static native void move(String name, int x, int y, RemoteWindowCallback callback) /*-{
        $wnd.isc.MultiWindow.move(name, x, y, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	

	/**
     * Opens a new window with the specified URL, name, and {@link com.smartgwt.client.widgets.DataContext}. <p> Note that if
     * the provided window name already exists, that window will just be {@link
     * com.smartgwt.client.browser.window.MultiWindow#activate activated}, and though the callback will be run, the supplied
     * url, dataContext, windowSettings, and classSettings will be ignored. <p> Support for passing POJOs (Java Object
     * references) to the child window in the {@link com.smartgwt.client.widgets.DataContext} via APIs such as {@link
     * com.smartgwt.client.widgets.DataContext#setSharedJavaObject DataContext.setSharedJavaObject()} is "super experimental"
     * (beyond the feature itself, which is experimental).
     * @param url url to open in the window or null to reuse the current url.
     * See {@link com.smartgwt.client.docs.URL URL}
     * @param name unique window name to open as a new window
     */
    public static native void open(String url, String name) /*-{
        $wnd.isc.MultiWindow.open(url, name);
    }-*/;

    /**
     * @see MultiWindow#open
     */
    public static void open(String url, String name, DataContext dataContext){
        open(url, name, dataContext, null, null, null);
    }

    /**
     * @see MultiWindow#open
     */
    public static void open(String url, String name, DataContext dataContext, RemoteWindowBooleanCallback callback){
        open(url, name, dataContext, callback, null, null);
    }

    /**
     * @see MultiWindow#open
     */
    public static void open(String url, String name, DataContext dataContext, RemoteWindowBooleanCallback callback, BrowserWindowSettings windowSettings){
        open(url, name, dataContext, callback, windowSettings, null);
    }

	/**
     * Opens a new window with the specified URL, name, and {@link com.smartgwt.client.widgets.DataContext}. <p> Note that if
     * the provided window name already exists, that window will just be {@link
     * com.smartgwt.client.browser.window.MultiWindow#activate activated}, and though the callback will be run, the supplied
     * url, dataContext, windowSettings, and classSettings will be ignored. <p> Support for passing POJOs (Java Object
     * references) to the child window in the {@link com.smartgwt.client.widgets.DataContext} via APIs such as {@link
     * com.smartgwt.client.widgets.DataContext#setSharedJavaObject DataContext.setSharedJavaObject()} is "super experimental"
     * (beyond the feature itself, which is experimental).
     * @param url url to open in the window or null to reuse the current url.
     * See {@link com.smartgwt.client.docs.URL URL}
     * @param name unique window name to open as a new window
     * @param dataContext dataContext to apply to window
     * @param callback callback run after {@link com.smartgwt.client.browser.window.RemoteWindow}                                       created
     * or activated (parameter true if created)
     * @param windowSettings settings applied to child browser window
     * @param classSettings settings for child {@link com.smartgwt.client.browser.window.MultiWindow} class
     */
    public static native void open(String url, String name, DataContext dataContext, RemoteWindowBooleanCallback callback, BrowserWindowSettings windowSettings, MultiWindowSettings classSettings) /*-{
        $wnd.isc.MultiWindow.open(url, name, dataContext == null ? null : dataContext.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(remoteWindow, result) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowBooleanCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;Ljava/lang/Boolean;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null, 
					result == null ? null : result.@java.lang.Boolean::booleanValue()()
				);
			}), windowSettings == null ? null : windowSettings.@com.smartgwt.client.core.DataClass::getJsObj()(), classSettings == null ? null : classSettings.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	

	/**
     * Resizes e existing window with the specified name,
     * @param name unique window name
     * @param width desired new width
     * @param height desired new height
     */
    public static native void resize(String name, int width, int height) /*-{
        $wnd.isc.MultiWindow.resize(name, width, height);
    }-*/;

	/**
     * Resizes e existing window with the specified name,
     * @param name unique window name
     * @param width desired new width
     * @param height desired new height
     * @param callback callback run after {@link com.smartgwt.client.browser.window.RemoteWindow} moved
     */
    public static native void resize(String name, int width, int height, RemoteWindowCallback callback) /*-{
        $wnd.isc.MultiWindow.resize(name, width, height, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	

	/**
     * Restores the existing window with the specified name,
     * @param name unique window name
     */
    public static native void restore(String name) /*-{
        $wnd.isc.MultiWindow.restore(name);
    }-*/;

	/**
     * Restores the existing window with the specified name,
     * @param name unique window name
     * @param callback callback run after {@link com.smartgwt.client.browser.window.RemoteWindow}                                              
     * restored
     */
    public static native void restore(String name, RemoteWindowCallback callback) /*-{
        $wnd.isc.MultiWindow.restore(name, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	

	/**
     * Registers a window event listener to be called whenever the event type occurs for any window in the application.
     * @param eventType event type to register
     * @param listener function to be called when event fires
     *
     * @return ID number of this event, may be used to remove the event
     * @see com.smartgwt.client.browser.window.MultiWindow#clearEvent
     */
    public static native int setEvent(MultiWindowEvent eventType, MultiWindowEventCallback listener) /*-{
        var ret = $wnd.isc.MultiWindow.setEvent(eventType.@com.smartgwt.client.types.MultiWindowEvent::getValue()(), 
			$entry( function(remoteWindow, eventType, event) { 
				if(listener!=null) listener.@com.smartgwt.client.browser.window.MultiWindowEventCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;Lcom/smartgwt/client/types/MultiWindowEvent;Ljava/util/Map;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null, 
					@com.smartgwt.client.util.EnumUtil::getEnum([Lcom/smartgwt/client/types/ValueEnum;Ljava/lang/String;)(@com.smartgwt.client.types.MultiWindowEvent::values()(),eventType), 
					event != null ? @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(event) : null
				);
			}));
        return ret;
    }-*/;


	/**
     * Shows the existing window with the specified name,
     * @param name unique window name
     */
    public static native void show(String name) /*-{
        $wnd.isc.MultiWindow.show(name);
    }-*/;

	/**
     * Shows the existing window with the specified name,
     * @param name unique window name
     * @param callback callback run after {@link com.smartgwt.client.browser.window.RemoteWindow}                                              
     * shown
     */
    public static native void show(String name, RemoteWindowCallback callback) /*-{
        $wnd.isc.MultiWindow.show(name, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	

    // ***********************************************************

}
