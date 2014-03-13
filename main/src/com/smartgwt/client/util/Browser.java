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
 
package com.smartgwt.client.util;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
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
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * The <code>Browser</code> class contains various class attributes that indicate basic properties of the browser and
 * whether certain features are enabled.
 */
@BeanFactory.FrameworkClass
public class Browser {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Setter for {@link com.smartgwt.client.util.Browser#isDesktop isDesktop} to allow this global variable to be changed at
     * runtime. This advanced method is provided to override Smart GWT's detection of devices, since the framework can only
     * detect devices that existed at the time the platform was released. Any changes to {@link
     * com.smartgwt.client.util.Browser#isDesktop isDesktop}, {@link com.smartgwt.client.util.Browser#isHandset isHandset}, or
     * {@link com.smartgwt.client.util.Browser#isTablet isTablet} must be made before any component is created. <p> Note that
     * setting <code>Browser.isDesktop</code> might affect the values of {@link com.smartgwt.client.util.Browser#isHandset
     * isHandset} and {@link com.smartgwt.client.util.Browser#isTablet isTablet}.
     * @param isDesktop new setting for <code>Browser.isDesktop</code>.
     */
    public static native void setIsDesktop(boolean isDesktop) /*-{
        $wnd.isc.Browser.setIsDesktop(isDesktop == null ? false : isDesktop);
    }-*/;


	/**
     * Setter for {@link com.smartgwt.client.util.Browser#isHandset isHandset} to allow this global variable to be changed at
     * runtime. This advanced method is provided to override Smart GWT's detection of devices, since the framework can only
     * detect devices that existed at the time the platform was released. Any changes to {@link
     * com.smartgwt.client.util.Browser#isDesktop isDesktop}, {@link com.smartgwt.client.util.Browser#isHandset isHandset}, or
     * {@link com.smartgwt.client.util.Browser#isTablet isTablet} must be made before any component is created. <p> Note that
     * setting <code>Browser.isHandset</code> might affect the values of {@link com.smartgwt.client.util.Browser#isDesktop
     * isDesktop} and {@link com.smartgwt.client.util.Browser#isTablet isTablet}.
     * @param isHandset new setting for <code>Browser.isHandset</code>.
     */
    public static native void setIsHandset(boolean isHandset) /*-{
        $wnd.isc.Browser.setIsHandset(isHandset == null ? false : isHandset);
    }-*/;


	/**
     * Setter for {@link com.smartgwt.client.util.Browser#isTablet isTablet} to allow this global variable to be changed at
     * runtime. This advanced method is provided to override Smart GWT's detection of devices, since the framework can only
     * detect devices that existed at the time the platform was released. Any changes to {@link
     * com.smartgwt.client.util.Browser#isDesktop isDesktop}, {@link com.smartgwt.client.util.Browser#isHandset isHandset}, or
     * {@link com.smartgwt.client.util.Browser#isTablet isTablet} must be made before any component is created. <p> Note that
     * setting <code>Browser.isTablet</code> might affect the values of {@link com.smartgwt.client.util.Browser#isDesktop
     * isDesktop} and {@link com.smartgwt.client.util.Browser#isHandset isHandset}.
     * @param isTablet new setting for <code>Browser.isTablet</code>.
     */
    public static native void setIsTablet(boolean isTablet) /*-{
        $wnd.isc.Browser.setIsTablet(isTablet == null ? false : isTablet);
    }-*/;


	/**
     * Setter for {@link com.smartgwt.client.util.Browser#isTouch isTouch} to allow this global variable to be changed at
     * runtime. This advanced method is provided to override Smart GWT's auto-detection logic, since the framework can only
     * detect touch devices that existed at the time the platform was released. Any change to {@link
     * com.smartgwt.client.util.Browser#isTouch isTouch} must be made before any component is created. <p> Note that setting
     * <code>Browser.isTouch</code> might affect the values of {@link com.smartgwt.client.util.Browser#isDesktop isDesktop},
     * {@link com.smartgwt.client.util.Browser#isTablet isTablet}, and/or {@link com.smartgwt.client.util.Browser#isHandset
     * isHandset}.
     * @param isTouch new setting for <code>Browser.isTablet</code>.
     */
    public static native void setIsTouch(boolean isTouch) /*-{
        $wnd.isc.Browser.setIsTouch(isTouch == null ? false : isTouch);
    }-*/;


    // ***********************************************************



    /**
     * Is the application running in a desktop browser? This is true if {@link #getIsTablet()}
     * and {@link #getIsHandset()} are both <code>false</code>.
     *
     * @return the value of <code>Browser.isDesktop</code>
     * @see #setIsHandset(boolean)
     */
    public static final native boolean getIsDesktop() /*-{
        return $wnd.isc.Browser.isDesktop;
    }-*/;

    /**
     * Is the application running on a handset-sized device, with a typical screen width of around
     * 3-4 inches?
     * <p>
     * This typically implies that the application will be working with only 300-400 pixels.
     *
     * @return the value of <code>Browser.isHandset</code>
     * @see #setIsHandset(boolean)
     */
    public static final native boolean getIsHandset() /*-{
        return $wnd.isc.Browser.isHandset;
    }-*/;

    /**
     * Is the application running on a tablet device (e.g. iPad, Nexus 7)?
     * <p>
     * Smart&nbsp;GWT can correctly determine whether the device is a tablet in most cases. On any
     * uncommon device for which this variable is incorrect, you can define the <code>isc_isTablet</code>
     * global in the host page with the correct value, and Smart&nbsp;GWT will use <code>isc_isTablet</code> for
     * <code>Browser.isTablet</code> instead of its own detection logic. Alternatively, you can use
     * {@link #setIsTablet(boolean)} to change this global variable before any components are
     * created.
     *
     * @return the value of <code>Browser.isTablet</code>
     * @see #setIsTablet(boolean)
     */
    public static final native boolean getIsTablet() /*-{
        return $wnd.isc.Browser.isTablet;
    }-*/;

    /**
     * Is the application running on a touch device (e.g. iPhone, iPad, Android device, etc.)?
     * <p>
     * Smart&nbsp;GWT's auto-detected value for <code>isTouch</code> can be overridden via
     * {@link #setIsTouch(boolean)}.
     *
     * @return the value of <code>Browser.isTouch</code>
     * @see #setIsTouch(boolean)
     */
    public static final native boolean getIsTouch() /*-{
        return $wnd.isc.Browser.isTouch;
    }-*/;

}


