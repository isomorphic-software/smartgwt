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
 * Allows specifying additional browser window settings when calling the underlying JavaScript or OpenFin call to create
 * the child window in {@link com.smartgwt.client.browser.window.MultiWindow#open MultiWindow.open()}.
 */
@BeanFactory.FrameworkClass
public class BrowserWindowSettings extends DataClass {

    public static BrowserWindowSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new BrowserWindowSettings(jsObj);
    }
        


    public BrowserWindowSettings(){
        
    }

    public BrowserWindowSettings(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Should a new window be activated when opened to ensure it's on top?
     *
     * @param activateOnOpen New activateOnOpen value. Default value is true
     * @return {@link com.smartgwt.client.browser.window.BrowserWindowSettings BrowserWindowSettings} instance, for chaining setter calls
     */
    public BrowserWindowSettings setActivateOnOpen(boolean activateOnOpen) {
        return (BrowserWindowSettings)setAttribute("activateOnOpen", activateOnOpen);
    }

    /**
     * Should a new window be activated when opened to ensure it's on top?
     *
     * @return Current activateOnOpen value. Default value is true
     */
    public boolean getActivateOnOpen()  {
        Boolean result = getAttributeAsBoolean("activateOnOpen", true);
        return result == null ? true : result;
    }
    

    /**
     * Persistent setting to position the window at the top of the window stack.
     *
     * @param alwaysOnTop New alwaysOnTop value. Default value is false
     * @return {@link com.smartgwt.client.browser.window.BrowserWindowSettings BrowserWindowSettings} instance, for chaining setter calls
     */
    public BrowserWindowSettings setAlwaysOnTop(boolean alwaysOnTop) {
        return (BrowserWindowSettings)setAttribute("alwaysOnTop", alwaysOnTop);
    }

    /**
     * Persistent setting to position the window at the top of the window stack.
     *
     * @return Current alwaysOnTop value. Default value is false
     */
    public boolean getAlwaysOnTop()  {
        Boolean result = getAttributeAsBoolean("alwaysOnTop", true);
        return result == null ? false : result;
    }
    

    /**
     * Initial height to assign to a new child window created by {@link com.smartgwt.client.browser.window.MultiWindow#open
     * MultiWindow.open()}.
     *
     * @param defaultHeight New defaultHeight value. Default value is null
     * @return {@link com.smartgwt.client.browser.window.BrowserWindowSettings BrowserWindowSettings} instance, for chaining setter calls
     */
    public BrowserWindowSettings setDefaultHeight(Integer defaultHeight) {
        return (BrowserWindowSettings)setAttribute("defaultHeight", defaultHeight);
    }

    /**
     * Initial height to assign to a new child window created by {@link com.smartgwt.client.browser.window.MultiWindow#open
     * MultiWindow.open()}.
     *
     * @return Current defaultHeight value. Default value is null
     */
    public Integer getDefaultHeight()  {
        return getAttributeAsInt("defaultHeight");
    }
    

    /**
     * Initial width to assign to a new child window created by {@link com.smartgwt.client.browser.window.MultiWindow#open
     * MultiWindow.open()}.
     *
     * @param defaultWidth New defaultWidth value. Default value is null
     * @return {@link com.smartgwt.client.browser.window.BrowserWindowSettings BrowserWindowSettings} instance, for chaining setter calls
     */
    public BrowserWindowSettings setDefaultWidth(Integer defaultWidth) {
        return (BrowserWindowSettings)setAttribute("defaultWidth", defaultWidth);
    }

    /**
     * Initial width to assign to a new child window created by {@link com.smartgwt.client.browser.window.MultiWindow#open
     * MultiWindow.open()}.
     *
     * @return Current defaultWidth value. Default value is null
     */
    public Integer getDefaultWidth()  {
        return getAttributeAsInt("defaultWidth");
    }
    

    /**
     * Should the window be opened in a tab or a new browser window in fallback mode without OpenFin?  Unless set explicitly
     * false, fallback mode will open tabs for the new window.
     *
     * @param tab New tab value. Default value is null
     * @return {@link com.smartgwt.client.browser.window.BrowserWindowSettings BrowserWindowSettings} instance, for chaining setter calls
     */
    public BrowserWindowSettings setTab(Boolean tab) {
        return (BrowserWindowSettings)setAttribute("tab", tab);
    }

    /**
     * Should the window be opened in a tab or a new browser window in fallback mode without OpenFin?  Unless set explicitly
     * false, fallback mode will open tabs for the new window.
     *
     * @return Current tab value. Default value is null
     */
    public Boolean getTab()  {
        return getAttributeAsBoolean("tab", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
