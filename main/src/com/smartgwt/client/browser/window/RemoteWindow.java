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
 * Provides APIs that manipulate a Smart GWT browser window. Within the <a
 * href='https://developers.openfin.co/of-docs/docs' target='_blank'>OpenFin</a> environment, the underlying implementation
 * is actually via the {@link com.smartgwt.client.browser.window.OpenFinWindow} class. <p> <b>Note:</b> this is currently
 * an experimental feature and not supported except by special arrangement
 * @see com.smartgwt.client.browser.window.MultiWindow
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("RemoteWindow")
public class RemoteWindow extends BaseClass implements com.smartgwt.client.browser.window.events.HasOtherWindowsChangedHandlers {

    public static RemoteWindow getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if (obj != null && !((RemoteWindow)obj).hasCreationContextWindow()) {
            obj = null;
        }
        if(obj != null) {
            return (RemoteWindow) obj;
        } else {
            return new RemoteWindow(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        internalSetID(jsObj);
        JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
        JSOHelper.setObjectAttribute(jsObj, SC.MODULE, BeanFactory.getSGWTModule());
        if (!JSOHelper.isScClassInstance(jsObj)) {
            setConfig(jsObj);
            return;
        }
        JSOHelper.setObjectAttribute(getConfig(), SC.REF, this);
        JSOHelper.setObjectAttribute(getConfig(), SC.MODULE, BeanFactory.getSGWTModule());
        this.jsObj = jsObj;
        setCreationContextWindow();           
        onBind();
    }
        


    public RemoteWindow(){
        setCreationContextWindow();
        scClassName = "RemoteWindow";
    }

    public RemoteWindow(JavaScriptObject jsObj){
        scClassName = "RemoteWindow";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    private JavaScriptObject jsObj;
    
    @Override
    public boolean isCreated(){
        return this.jsObj != null;
    }

    @Override
    public JavaScriptObject getJsObj(){
        return this.jsObj;
    }

    @Override
    public JavaScriptObject getOrCreateJsObj() {
        if (!isCreated()) {
            this.jsObj = createJsObj();
            doInit();
        }
        return this.jsObj;
    }


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************
	/**
     * Focuses (activates) this RemoteWindow.
     */
    public native void activate() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "activate", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.activate();
    }-*/;

	/**
     * Focuses (activates) this RemoteWindow.
     * @param callback callback run after it's activated
     */
    public native void activate(RemoteWindowCallback callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "activate", "RemoteWindowCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.activate(
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	
	/**
     * Blurs (deactivates) this RemoteWindow.
     */
    public native void blur() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "blur", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.blur();
    }-*/;

	/**
     * Blurs (deactivates) this RemoteWindow.
     * @param callback callback run after it's deactivated
     */
    public native void blur(RemoteWindowCallback callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "blur", "RemoteWindowCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.blur(
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	
	/**
     * Brings this RemoteWindow to the front in window stacking order.
     */
    public native void bringToFront() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "bringToFront", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.bringToFront();
    }-*/;

    /**
     * @see RemoteWindow#bringToFront
     */
    public void bringToFront(RemoteWindowCallback callback){
        bringToFront(callback, null);
    }

	/**
     * Brings this RemoteWindow to the front in window stacking order.
     * @param callback callback run after raising window
     * @param errorCallback callback run if raising fails
     */
    public native void bringToFront(RemoteWindowCallback callback, RemoteWindowErrorCallback errorCallback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "bringToFront", "RemoteWindowCallback,RemoteWindowErrorCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.bringToFront(
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}), 
			$entry( function(remoteWindow, errorMessage) { 
				if(errorCallback!=null) errorCallback.@com.smartgwt.client.browser.window.RemoteWindowErrorCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;Ljava/lang/String;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null, 
					errorMessage
				);
			}));
    }-*/;
	
	/**
     * Closes this RemoteWindow.
     */
    public native void close() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "close", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.close();
    }-*/;

    /**
     * @see RemoteWindow#close
     */
    public void close(boolean force){
        close(force, null);
    }

	/**
     * Closes this RemoteWindow.
     * @param force whether to force it closed
     * @param callback callback run after it's closed
     */
    public native void close(boolean force, RemoteWindowCallback callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "close", "boolean,RemoteWindowCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.close(force, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	
	/**
     * Blurs (deactivates) this RemoteWindow.
     */
    public native void deactivate() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deactivate", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.deactivate();
    }-*/;

	/**
     * Blurs (deactivates) this RemoteWindow.
     * @param callback callback run after it's deactivated
     */
    public native void deactivate(RemoteWindowCallback callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deactivate", "RemoteWindowCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.deactivate(
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	
	/**
     * Focuses (activates) this RemoteWindow.
     */
    public native void focus() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "focus", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.focus();
    }-*/;

	/**
     * Focuses (activates) this RemoteWindow.
     * @param callback callback run after it's activated
     */
    public native void focus(RemoteWindowCallback callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "focus", "RemoteWindowCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.focus(
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	
	/**
     * Get the height of the entire browser window, including browser chrome.
     *
     * @return height of the browser
     */
    public native int getBrowserHeight() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getBrowserHeight", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getBrowserHeight();
        return ret;
    }-*/;

	/**
     * Get the width of the entire browser window, including browser chrome.
     *
     * @return width of the browser
     */
    public native int getBrowserWidth() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getBrowserWidth", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getBrowserWidth();
        return ret;
    }-*/;

	/**
     * Returns the container window, if present, wrapping the browser window for this RemoteWindow.  If OpenFin is present,
     * this will return the associated OpenFin <a href='https://cdn.openfin.co/docs/javascript/stable/Window.html'
     * target='_blank'>Window</a>.
     *
     * @return OpenFin window
     */
    public native Map getContainerWindow() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getContainerWindow", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getContainerWindow();
        return @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Checks whether this RemoteWindow is showing.
     * @param callback callback to receive output
     */
    public native void getInfo(RemoteWindowMapCallback callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getInfo", "RemoteWindowMapCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.getInfo(
			$entry( function(remoteWindow, result) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowMapCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;Ljava/util/Map;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null, 
					result != null ? @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(result) : null
				);
			}));
    }-*/;

	/**
     * Returns the name of this RemoteWindow.
     *
     * @return window name
     */
    public native String getName() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getName", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getName();
        return ret;
    }-*/;

	/**
     * Get the height of the visible portion of the window, not including browser chrome or the scrollbar area.
     *
     * @return height of the page
     */
    public native int getPageHeight() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPageHeight", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getPageHeight();
        return ret;
    }-*/;

	/**
     * Get the width of the visible portion of the window, not including browser chrome or the scrollbar area.
     *
     * @return width of the page
     */
    public native int getPageWidth() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPageWidth", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getPageWidth();
        return ret;
    }-*/;

	/**
     * Returns the parent {@link com.smartgwt.client.browser.window.RemoteWindow} instance that opened this RemoteWindow.
     *
     * @return instance wrapping the parent window or null
     */
    public native RemoteWindow getParent() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getParent", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getParent();
        if(ret == null) return null;
        return @com.smartgwt.client.browser.window.RemoteWindow::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the browser <code>window</code> object associated with this RemoteWindow.
     *
     * @return browser window
     */
    public native Map getWindow() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getWindow", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getWindow();
        return @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Hides this RemoteWindow.
     */
    public native void hide() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hide", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.hide();
    }-*/;

    /**
     * @see RemoteWindow#hide
     */
    public void hide(RemoteWindowCallback callback){
        hide(callback, null);
    }

	/**
     * Hides this RemoteWindow.
     * @param callback callback run after hiding the window
     * @param errorCallback callback run if hiding fails
     */
    public native void hide(RemoteWindowCallback callback, RemoteWindowErrorCallback errorCallback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hide", "RemoteWindowCallback,RemoteWindowErrorCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.hide(
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}), 
			$entry( function(remoteWindow, errorMessage) { 
				if(errorCallback!=null) errorCallback.@com.smartgwt.client.browser.window.RemoteWindowErrorCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;Ljava/lang/String;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null, 
					errorMessage
				);
			}));
    }-*/;
	
	/**
     * Checks whether this RemoteWindow is showing.
     * @param callback callback to receive output
     */
    public native void isShowing(RemoteWindowBooleanCallback callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isShowing", "RemoteWindowBooleanCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.isShowing(
			$entry( function(remoteWindow, result) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowBooleanCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;Ljava/lang/Boolean;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null, 
					result == null ? null : result.@java.lang.Boolean::booleanValue()()
				);
			}));
    }-*/;

	/**
     * Maximizes this RemoteWindow.
     */
    public native void maximize() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "maximize", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.maximize();
    }-*/;

    /**
     * @see RemoteWindow#maximize
     */
    public void maximize(RemoteWindowCallback callback){
        maximize(callback, null);
    }

	/**
     * Maximizes this RemoteWindow.
     * @param callback callback run after maximization
     * @param errorCallback callback run if maximizing fails
     */
    public native void maximize(RemoteWindowCallback callback, RemoteWindowErrorCallback errorCallback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "maximize", "RemoteWindowCallback,RemoteWindowErrorCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.maximize(
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}), 
			$entry( function(remoteWindow, errorMessage) { 
				if(errorCallback!=null) errorCallback.@com.smartgwt.client.browser.window.RemoteWindowErrorCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;Ljava/lang/String;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null, 
					errorMessage
				);
			}));
    }-*/;
	
	/**
     * Minimizes this RemoteWindow.
     */
    public native void minimize() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "minimize", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.minimize();
    }-*/;

    /**
     * @see RemoteWindow#minimize
     */
    public void minimize(RemoteWindowCallback callback){
        minimize(callback, null);
    }

	/**
     * Minimizes this RemoteWindow.
     * @param callback callback run after minimization
     * @param errorCallback callback run if minimizing fails
     */
    public native void minimize(RemoteWindowCallback callback, RemoteWindowErrorCallback errorCallback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "minimize", "RemoteWindowCallback,RemoteWindowErrorCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.minimize(
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}), 
			$entry( function(remoteWindow, errorMessage) { 
				if(errorCallback!=null) errorCallback.@com.smartgwt.client.browser.window.RemoteWindowErrorCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;Ljava/lang/String;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null, 
					errorMessage
				);
			}));
    }-*/;
	
	/**
     * Moves this RemoteWindow.
     * @param x desired x-offset of left edge
     * @param y desired y-offset of top edge
     */
    public native void move(int x, int y) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "move", "int,int");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.move(x, y);
    }-*/;

	/**
     * Moves this RemoteWindow.
     * @param x desired x-offset of left edge
     * @param y desired y-offset of top edge
     * @param callback callback run after it's moved
     */
    public native void move(int x, int y, RemoteWindowCallback callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "move", "int,int,RemoteWindowCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.move(x, y, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	
    /**
     * Add a otherWindowsChanged handler.
     * <p>
     * Notification fired when the set of other {@link com.smartgwt.client.browser.window.RemoteWindow RemoteWindows} changes
     * or requires re-synchronization due a call to  create(), {@link com.smartgwt.client.browser.window.RemoteWindow#close
     * close()}, or a page reload in a different RemoteWindow. <p> This method has no default implementation.
     *
     * @param handler the otherWindowsChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addOtherWindowsChangedHandler(com.smartgwt.client.browser.window.events.OtherWindowsChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.browser.window.events.OtherWindowsChangedEvent.getType()) == 0) setupOtherWindowsChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.browser.window.events.OtherWindowsChangedEvent.getType());
    }

    private native void setupOtherWindowsChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var otherWindowsChanged = $entry(function(){
            var param = {"_this": this, "otherWindows" : arguments[0]};
                var event = @com.smartgwt.client.browser.window.events.OtherWindowsChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                selfJ.@com.smartgwt.client.browser.window.RemoteWindow::handleTearDownOtherWindowsChangedEvent()();
            });
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
            obj.addProperties({otherWindowsChanged:  otherWindowsChanged              });
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
            obj.otherWindowsChanged =  otherWindowsChanged             ;
        }
    }-*/;

    private void handleTearDownOtherWindowsChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.browser.window.events.OtherWindowsChangedEvent.getType()) == 0) tearDownOtherWindowsChangedEvent();
    }

    private native void tearDownOtherWindowsChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        if (obj && obj.hasOwnProperty("otherWindowsChanged")) delete obj.otherWindowsChanged;
    }-*/;

	/**
     * Resizes this RemoteWindow.
     * @param width desired new width
     * @param height desired new height
     */
    public native void resize(int width, int height) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "resize", "int,int");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.resize(width, height);
    }-*/;

	/**
     * Resizes this RemoteWindow.
     * @param width desired new width
     * @param height desired new height
     * @param callback callback run after it's resized
     */
    public native void resize(int width, int height, RemoteWindowCallback callback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "resize", "int,int,RemoteWindowCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.resize(width, height, 
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}));
    }-*/;
	
	/**
     * Restores this RemoteWindow from being maximized or minimized.
     */
    public native void restore() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "restore", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.restore();
    }-*/;

    /**
     * @see RemoteWindow#restore
     */
    public void restore(RemoteWindowCallback callback){
        restore(callback, null);
    }

	/**
     * Restores this RemoteWindow from being maximized or minimized.
     * @param callback callback run after restoration
     * @param errorCallback callback run if restoring fails
     */
    public native void restore(RemoteWindowCallback callback, RemoteWindowErrorCallback errorCallback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "restore", "RemoteWindowCallback,RemoteWindowErrorCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.restore(
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}), 
			$entry( function(remoteWindow, errorMessage) { 
				if(errorCallback!=null) errorCallback.@com.smartgwt.client.browser.window.RemoteWindowErrorCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;Ljava/lang/String;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null, 
					errorMessage
				);
			}));
    }-*/;
	
	/**
     * Shows this RemoteWindow.
     */
    public native void show() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "show", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.show();
    }-*/;

    /**
     * @see RemoteWindow#show
     */
    public void show(RemoteWindowCallback callback){
        show(callback, null);
    }

	/**
     * Shows this RemoteWindow.
     * @param callback callback run after showing the window
     * @param errorCallback callback run if showing fails
     */
    public native void show(RemoteWindowCallback callback, RemoteWindowErrorCallback errorCallback) /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "show", "RemoteWindowCallback,RemoteWindowErrorCallback");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.show(
			$entry( function(remoteWindow) { 
				if(callback!=null) callback.@com.smartgwt.client.browser.window.RemoteWindowCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null
				);
			}), 
			$entry( function(remoteWindow, errorMessage) { 
				if(errorCallback!=null) errorCallback.@com.smartgwt.client.browser.window.RemoteWindowErrorCallback::execute(Lcom/smartgwt/client/browser/window/RemoteWindow;Ljava/lang/String;)(
					remoteWindow != null ? @com.smartgwt.client.browser.window.RemoteWindow::new(Lcom/google/gwt/core/client/JavaScriptObject;)(remoteWindow) : null, 
					errorMessage
				);
			}));
    }-*/;
	

    // ********************* Static Methods ***********************

    // ***********************************************************



    private native void setCreationContextWindow() /*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        if (config) config.__window = $wnd.window;
    }-*/;

    protected native boolean hasCreationContextWindow() /*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        return config && config.__window == $wnd.window;
    }-*/;


}
