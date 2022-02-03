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
 
package com.smartgwt.client.widgets.layout;


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
 * Encapsulates state of a {@link com.smartgwt.client.widgets.layout.NavigationBar}'s view. A
 * <code>NavigationBarViewState</code> object is created to pass to {@link
 * com.smartgwt.client.widgets.layout.NavigationBar#setViewState NavigationBar.setViewState()} so that multiple properties
 * of the <code>NavigationBar</code> can be changed at once.
 */
@BeanFactory.FrameworkClass
public class NavigationBarViewState extends DataClass {

    public static NavigationBarViewState getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new NavigationBarViewState(jsObj);
    }
        


    public NavigationBarViewState(){
        
    }

    public NavigationBarViewState(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getAlwaysShowLeftButtonTitle
     * NavigationBar.alwaysShowLeftButtonTitle} setting. If unset, the <code>alwaysShowLeftButtonTitle</code> setting is not
     * changed.
     *
     * @param alwaysShowLeftButtonTitle New alwaysShowLeftButtonTitle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavigationBarViewState NavigationBarViewState} instance, for chaining setter calls
     */
    public NavigationBarViewState setAlwaysShowLeftButtonTitle(Boolean alwaysShowLeftButtonTitle) {
        return (NavigationBarViewState)setAttribute("alwaysShowLeftButtonTitle", alwaysShowLeftButtonTitle);
    }

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getAlwaysShowLeftButtonTitle
     * NavigationBar.alwaysShowLeftButtonTitle} setting. If unset, the <code>alwaysShowLeftButtonTitle</code> setting is not
     * changed.
     *
     * @return Current alwaysShowLeftButtonTitle value. Default value is null
     */
    public Boolean getAlwaysShowLeftButtonTitle()  {
        return getAttributeAsBoolean("alwaysShowLeftButtonTitle", true);
    }
    

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getControls NavigationBar.controls} setting. If unset,
     * the <code>controls</code> array is not changed.
     *
     * @param controls New controls value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavigationBarViewState NavigationBarViewState} instance, for chaining setter calls
     */
    public NavigationBarViewState setControls(String... controls) {
        return (NavigationBarViewState)setAttribute("controls", controls);
    }

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getControls NavigationBar.controls} setting. If unset,
     * the <code>controls</code> array is not changed.
     *
     * @return Current controls value. Default value is null
     */
    public String[] getControls()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("controls"));
    }

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getControls NavigationBar.controls} setting. If unset,
     * the <code>controls</code> array is not changed.
     *
     * @param controls New controls value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavigationBarViewState NavigationBarViewState} instance, for chaining setter calls
     */
    public NavigationBarViewState setControls(Canvas... controls) {
        return (NavigationBarViewState)setAttribute("controls", controls);
    }

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getControls NavigationBar.controls} setting. If unset,
     * the <code>controls</code> array is not changed.
     *
     * @return Current controls value. Default value is null
     */
    public Canvas[] getControlsAsCanvasArray()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("controls"));
    }
    

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButtonTitle NavigationBar.leftButtonTitle}
     * setting. If unset, the <code>leftButtonTitle</code> is not changed.
     *
     * @param leftButtonTitle New leftButtonTitle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavigationBarViewState NavigationBarViewState} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public NavigationBarViewState setLeftButtonTitle(String leftButtonTitle) {
        return (NavigationBarViewState)setAttribute("leftButtonTitle", leftButtonTitle);
    }

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButtonTitle NavigationBar.leftButtonTitle}
     * setting. If unset, the <code>leftButtonTitle</code> is not changed.
     *
     * @return Current leftButtonTitle value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLeftButtonTitle()  {
        return getAttributeAsString("leftButtonTitle");
    }
    

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getShortLeftButtonTitle
     * NavigationBar.shortLeftButtonTitle} setting. If unset, the <code>shortLeftButtonTitle</code> is not changed.
     *
     * @param shortLeftButtonTitle New shortLeftButtonTitle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavigationBarViewState NavigationBarViewState} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public NavigationBarViewState setShortLeftButtonTitle(String shortLeftButtonTitle) {
        return (NavigationBarViewState)setAttribute("shortLeftButtonTitle", shortLeftButtonTitle);
    }

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getShortLeftButtonTitle
     * NavigationBar.shortLeftButtonTitle} setting. If unset, the <code>shortLeftButtonTitle</code> is not changed.
     *
     * @return Current shortLeftButtonTitle value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getShortLeftButtonTitle()  {
        return getAttributeAsString("shortLeftButtonTitle");
    }
    

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getShowLeftButton NavigationBar.showLeftButton} setting.
     * If unset, the <code>showLeftButton</code> setting is not changed.
     *
     * @param showLeftButton New showLeftButton value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavigationBarViewState NavigationBarViewState} instance, for chaining setter calls
     */
    public NavigationBarViewState setShowLeftButton(Boolean showLeftButton) {
        return (NavigationBarViewState)setAttribute("showLeftButton", showLeftButton);
    }

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getShowLeftButton NavigationBar.showLeftButton} setting.
     * If unset, the <code>showLeftButton</code> setting is not changed.
     *
     * @return Current showLeftButton value. Default value is null
     */
    public Boolean getShowLeftButton()  {
        return getAttributeAsBoolean("showLeftButton", true);
    }
    

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getTitle NavigationBar.title} setting. If unset, the
     * <code>title</code> is not changed.
     *
     * @param title New title value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavigationBarViewState NavigationBarViewState} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public NavigationBarViewState setTitle(String title) {
        return (NavigationBarViewState)setAttribute("title", title);
    }

    /**
     * The new {@link com.smartgwt.client.widgets.layout.NavigationBar#getTitle NavigationBar.title} setting. If unset, the
     * <code>title</code> is not changed.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************



    public void unsetShowLeftButton() {
        JSOHelper.deleteAttribute(jsObj, "showLeftButton");
    }

    public void unsetLeftButtonTitle() {
        JSOHelper.deleteAttribute(jsObj, "leftButtonTitle");
    }

    public void unsetShortLeftButtonTitle() {
        JSOHelper.deleteAttribute(jsObj, "shortLeftButtonTitle");
    }

    public void unsetAlwaysShowLeftButtonTitle() {
        JSOHelper.deleteAttribute(jsObj, "alwaysShowLeftButtonTitle");
    }

    public void unsetTitle() {
        JSOHelper.deleteAttribute(jsObj, "title");
    }

    public void unsetControls() {
        JSOHelper.deleteAttribute(jsObj, "controls");
    }

}
