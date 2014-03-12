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
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * A device- and orientation-sensitive layout that implements the common pattern of rendering two panes side-by-side on
 * desktop devices and on tablets in landscape orientation, while switching to showing a single pane for handset-sized
 * devices or tablets in portrait orientation (this type of behavior is sometimes called "responsive design"). <p> A
 * <code>SplitPane</code> can manage either two or three panes &mdash; a {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} and the {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} are required, and a {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} can also be provided which appears in the same place
 * as the navigation pane, with built-in navigation between the panes based on {@link
 * com.smartgwt.client.widgets.layout.NavigationBar}.  An example of 3-pane usage would be an email application: <ul> <li>
 * <code>navigationPane</code>: {@link com.smartgwt.client.widgets.tree.TreeGrid} of folders <li> <code>listPane</code>:
 * {@link com.smartgwt.client.widgets.grid.ListGrid} showing messages in a folder <li> <code>detailPane</code>: message
 * detail view (perhaps a {@link com.smartgwt.client.widgets.viewer.DetailViewer} over an      {@link
 * com.smartgwt.client.widgets.HTMLFlow} or similar arrangement) </ul> <p> The placement of the panes is by default
 * sensitive to whether the device is detected as a handset (phone), tablet or desktop device (see {@link
 * com.smartgwt.client.types.DeviceMode}) and to the current {@link com.smartgwt.client.types.PageOrientation}.  You can
 * also configure a <code>SplitPane</code> with a fixed {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation} or {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode}. <p> Beyond providing the panes listed above,
 * typical usage is simply to call {@link com.smartgwt.client.widgets.layout.SplitPane#showListPane showListPane()} and
 * {@link com.smartgwt.client.widgets.layout.SplitPane#showDetailPane showDetailPane()} when the <code>SplitPane</code>
 * should navigate to a new pane.  For example, in an email application, clicking on a folder in the
 * <code>navigationPane</code> should cause the <code>listPane</code> to show messages from the folder, then
 * <code>showListPane(<em>"folder name"</em>)</code> would be called to show the <code>listPane</code> and give it a new
 * title reflecting the name of the folder. <p> Similarly, clicking on a message in the <code>listPane</code> should show
 * the message details in the <code>detailPane</code> and call <code>showDetailPane(<em>"message title"</em>)</code> to
 * reveal the <code>detailPane</code> and give it an appropriate title. <p> <h3>Automatic control placement</h3> <p> {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getDetailToolButtons detailToolButtons} allows you to define a set of
 * controls that are specially placed based on the <code>deviceMode</code> and <code>pageOrientation</code>.  See {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getDetailButtons detailButtons} for details. <p> <h3>NavigationBar and
 * ToolStrips</h3> <p> By default, a {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar} is
 * created in all modes, and in some modes additional bars are created as follows: <ul> <li> in
 * <code>deviceMode:"desktop"</code> and <code>deviceMode</code> "tablet" with      <code>pageOrientation</code>
 * "landscape", the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} shown     
 * <em>above</em> the <code>detailPane</code>. <li> in <code>deviceMode:"handset"</code>, the {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} is created      <strong>only</strong>
 * if <code>detailToolButtons</code> are specified, and is placed      <em>underneath</em> the <code>detailPane</code>.
 * <li> {@link com.smartgwt.client.widgets.layout.SplitPane#getListToolStrip listToolStrip} - separate bar for the
 * <code>listPane</code>, only present      for <code>deviceMode:"desktop"</code> when a <code>listPane</code> is provided.
 * </ul> All of these bars are {@link com.smartgwt.client.docs.AutoChildUsage AutoChildren} and hence completely optional. 
 * You can omit them entirely, or, if you want navigation bars or tool strips but want to customize them more than the
 * AutoChild system allows, you can prevent the built-in bars from being created and place your own {@link
 * com.smartgwt.client.widgets.layout.NavigationBar}s either <em>inside</em> your navigation, list or detail panes, or
 * <em>outside</em> the <code>SplitPane</code> as a whole. This allows you to completely customize your navigation but
 * still use <code>SplitPane</code> to handle device- and orientation-aware layout. <p> Note that while the {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar} is named after the {@link
 * com.smartgwt.client.widgets.layout.NavigationBar} class, the other automatically created bars are also instances of
 * <code>NavigationBar</code> despite the "toolStrip" naming convention.  These controls will not generally contain
 * navigation elements; the <code>NavigationBar</code> class is used for consistent styling, since the
 * <code>navigationBar</code> appears adjacent to the toolstrips in some modes and orientations, so they should have the
 * same height and styling.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("SplitPane")
public class SplitPane extends VLayout implements com.smartgwt.client.widgets.layout.events.HasNavigationClickHandlers, com.smartgwt.client.widgets.layout.events.HasPaneChangedHandlers {

    public static SplitPane getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new SplitPane(jsObj);
        } else {
            assert refInstance instanceof SplitPane;
            return (SplitPane)refInstance;
        }
    }


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.SplitPane.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc.SplitPane.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public SplitPane(){
        scClassName = "SplitPane";
    }

    public SplitPane(JavaScriptObject jsObj){
        scClassName = "SplitPane";
        setJavaScriptObject(jsObj);
    }


    public SplitPane(Canvas navigationPane, Canvas detailPane) {
        setNavigationPane(navigationPane);
		setDetailPane(detailPane);
                scClassName = "SplitPane";
    }


    public SplitPane(Canvas navigationPane, Canvas listPane, Canvas detailPane) {
        setNavigationPane(navigationPane);
		setListPane(listPane);
		setDetailPane(detailPane);
                scClassName = "SplitPane";
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Should default history-tracking support be enabled? If <code>true</code>, then a history management scheme utilizing 
     * History.addHistoryEntry and  History.registerCallback is enabled. The history callback is registered as an additive
     * callback, allowing other history callbacks including the primary callback to be registered. <p> The default history
     * management scheme is as follows: <ul> <li>History entries are only added after {@link
     * com.smartgwt.client.util.Page#isLoaded page load} and when the <code>SplitPane</code> is drawn.</li> <li>A history entry
     * is added for a pane that is hidden by {@link com.smartgwt.client.widgets.layout.SplitPane#showNavigationPane
     * SplitPane.showNavigationPane}, {@link com.smartgwt.client.widgets.layout.SplitPane#showListPane SplitPane.showListPane},
     * or {@link com.smartgwt.client.widgets.layout.SplitPane#showDetailPane SplitPane.showDetailPane} for the current {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation} settings. <p> Example 1: When
     * <code>deviceMode</code> is "desktop", all 3 panes are shown simultaneously, so no history entries are added. <p> Example
     * 2: When <code>deviceMode</code> is "handset", calling {@link com.smartgwt.client.widgets.layout.SplitPane#showDetailPane
     * SplitPane.showDetailPane} will hide the current pane (the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} if present, otherwise the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}). A history entry is added for the pane
     * that was hidden</li> </ul> <p> The default history management scheme can be supplemented with application-specific
     * history management. For example, when <code>deviceMode</code> is "tablet", the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} is always visible, but changes to the content of
     * the <code>detailPane</code> are transparent to the <code>SplitPane</code>. The application can add history entries of
     * its own when the user causes new information to be displayed in the <code>detailPane</code>.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.SplitPane#getAddHistoryEntries addHistoryEntries}.
     *
     * @param addHistoryEntries the new setting.. Default value is true
     */
    public void setAddHistoryEntries(boolean addHistoryEntries) {
        setAttribute("addHistoryEntries", addHistoryEntries, true);
    }

    /**
     * Should default history-tracking support be enabled? If <code>true</code>, then a history management scheme utilizing 
     * History.addHistoryEntry and  History.registerCallback is enabled. The history callback is registered as an additive
     * callback, allowing other history callbacks including the primary callback to be registered. <p> The default history
     * management scheme is as follows: <ul> <li>History entries are only added after {@link
     * com.smartgwt.client.util.Page#isLoaded page load} and when the <code>SplitPane</code> is drawn.</li> <li>A history entry
     * is added for a pane that is hidden by {@link com.smartgwt.client.widgets.layout.SplitPane#showNavigationPane
     * SplitPane.showNavigationPane}, {@link com.smartgwt.client.widgets.layout.SplitPane#showListPane SplitPane.showListPane},
     * or {@link com.smartgwt.client.widgets.layout.SplitPane#showDetailPane SplitPane.showDetailPane} for the current {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation} settings. <p> Example 1: When
     * <code>deviceMode</code> is "desktop", all 3 panes are shown simultaneously, so no history entries are added. <p> Example
     * 2: When <code>deviceMode</code> is "handset", calling {@link com.smartgwt.client.widgets.layout.SplitPane#showDetailPane
     * SplitPane.showDetailPane} will hide the current pane (the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} if present, otherwise the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}). A history entry is added for the pane
     * that was hidden</li> </ul> <p> The default history management scheme can be supplemented with application-specific
     * history management. For example, when <code>deviceMode</code> is "tablet", the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} is always visible, but changes to the content of
     * the <code>detailPane</code> are transparent to the <code>SplitPane</code>. The application can add history entries of
     * its own when the user causes new information to be displayed in the <code>detailPane</code>.
     *
     * @return boolean
     */
    public boolean getAddHistoryEntries()  {
        return getAttributeAsBoolean("addHistoryEntries");
    }

    /**
     * The most recently shown pane.  In handset {@link com.smartgwt.client.types.DeviceMode}, the <code>currentPane</code> is
     * the only pane that is actually visible to the user.  In other modes more than one pane can be simultaneously visible, so
     * the <code>currentPane</code> is the most recent pane that was brought into view via a call to {@link
     * com.smartgwt.client.widgets.layout.SplitPane#setCurrentPane SplitPane.setCurrentPane} or {@link
     * com.smartgwt.client.widgets.layout.SplitPane#showNavigationPane SplitPane.showNavigationPane}. <p> The default value of
     * <code>currentPane</code> is "navigation".
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Reveals the pane indicated by the <code>newPane</code> parameter. <p> This has different effects based on the {@link com.smartgwt.client.types.DeviceMode} and {@link com.smartgwt.client.types.PageOrientation}.  For example, in "handset" mode, the new pane will be the only one showing.  In other modes such as "desktop", this method may do nothing, but should still be called in order to ensure correct behavior with other {@link com.smartgwt.client.types.DeviceMode} settings.
     *
     * @param currentPane new pane to show.. Default value is "navigation"
     */
    public void setCurrentPane(CurrentPane currentPane) {
        setAttribute("currentPane", currentPane == null ? null : currentPane.getValue(), true);
    }

    /**
     * The most recently shown pane.  In handset {@link com.smartgwt.client.types.DeviceMode}, the <code>currentPane</code> is
     * the only pane that is actually visible to the user.  In other modes more than one pane can be simultaneously visible, so
     * the <code>currentPane</code> is the most recent pane that was brought into view via a call to {@link
     * com.smartgwt.client.widgets.layout.SplitPane#setCurrentPane SplitPane.setCurrentPane} or {@link
     * com.smartgwt.client.widgets.layout.SplitPane#showNavigationPane SplitPane.showNavigationPane}. <p> The default value of
     * <code>currentPane</code> is "navigation".
     *
     * @return CurrentPane
     */
    public CurrentPane getCurrentPane()  {
        return EnumUtil.getEnum(CurrentPane.values(), getAttribute("currentPane"));
    }

    /**
     * Navigation control that appears only when the navigation pane is not showing (showing detail pane on handset, or
     * portrait mode on tablet).
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Navigation control that appears only when the navigation pane is not showing (showing detail pane on handset, or portrait mode on tablet).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param detailNavigationControl  Default value is null
     */
    public void setDetailNavigationControl(Canvas detailNavigationControl) {
        setAttribute("detailNavigationControl", detailNavigationControl == null ? null : detailNavigationControl.getOrCreateJsObj(), true);
    }

    /**
     * Navigation control that appears only when the navigation pane is not showing (showing detail pane on handset, or
     * portrait mode on tablet).
     *
     * @return Canvas
     */
    public Canvas getDetailNavigationControl()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("detailNavigationControl"));
    }

    /**
     * The right-hand of the two panes managed by this widget, used for viewing details.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Sets a new {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} at runtime.
     *
     * @param detailPane new detail pane for this widget.. Default value is null
     */
    public void setDetailPane(Canvas detailPane) {
        setAttribute("detailPane", detailPane == null ? null : detailPane.getOrCreateJsObj(), true);
    }

    /**
     * The right-hand of the two panes managed by this widget, used for viewing details.
     *
     * @return Canvas
     */
    public Canvas getDetailPane()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("detailPane"));
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Sets the title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}.
     *
     * @param detailTitle new title for the detail pane. See {@link com.smartgwt.client.docs.HTMLString HTMLString} . Default value is null
     */
    public void setDetailTitle(String detailTitle) {
        setAttribute("detailTitle", detailTitle, true);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}.
     *
     * @return  See {@link com.smartgwt.client.docs.HTMLString HTMLString} 
     */
    public String getDetailTitle()  {
        return getAttributeAsString("detailTitle");
    }

    /**
     * <code>detailToolButtons</code> allows you to specify a set of controls that are specially placed based on the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation}. This is generally useful for a compact
     * strip of {@link com.smartgwt.client.widgets.ImgButton} controls, approximately 5 of which will fit comfortably using
     * typical size icons and in the most space-constricted modes. <p> These controls are placed as follows: <ul> <li> in
     * <code>deviceMode:"desktop"</code> and <code>deviceMode</code> "tablet" with      <code>pageOrientation</code>
     * "landscape", <code>detailToolButtons</code> appear in the      {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} shown <i>above</i> of the
     * <code>detailPane</code>. <li> in <code>deviceMode:"handset"</code>, <code>detailToolButtons</code> appear in a      
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} <i>underneath</i> the
     * detailPane.  This toolstrip      is only created in "handset" mode if <code>detailToolButtons</code> are provided. <li>
     * in <code>deviceMode:"tablet"</code> and <code>pageOrientation:"portrait"</code>,      <code>detailToolButtons</code>
     * appear in <code>splitPane.navigationBar</code>. </ul>
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Updates the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolButtons detailToolButtons} at runtime.
     *
     * @param detailToolButtons new controls for the toolstrip.. Default value is null
     */
    public void setDetailToolButtons(Canvas... detailToolButtons) {
        setAttribute("detailToolButtons", detailToolButtons, true);
    }

    /**
     * <code>detailToolButtons</code> allows you to specify a set of controls that are specially placed based on the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation}. This is generally useful for a compact
     * strip of {@link com.smartgwt.client.widgets.ImgButton} controls, approximately 5 of which will fit comfortably using
     * typical size icons and in the most space-constricted modes. <p> These controls are placed as follows: <ul> <li> in
     * <code>deviceMode:"desktop"</code> and <code>deviceMode</code> "tablet" with      <code>pageOrientation</code>
     * "landscape", <code>detailToolButtons</code> appear in the      {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} shown <i>above</i> of the
     * <code>detailPane</code>. <li> in <code>deviceMode:"handset"</code>, <code>detailToolButtons</code> appear in a      
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} <i>underneath</i> the
     * detailPane.  This toolstrip      is only created in "handset" mode if <code>detailToolButtons</code> are provided. <li>
     * in <code>deviceMode:"tablet"</code> and <code>pageOrientation:"portrait"</code>,      <code>detailToolButtons</code>
     * appear in <code>splitPane.navigationBar</code>. </ul>
     *
     * @return Canvas...
     */
    public Canvas[] getDetailToolButtons()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("detailToolButtons"));
    }

    /**
     * Toolstrip servicing the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return NavigationBar
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public NavigationBar getDetailToolStrip() throws IllegalStateException {
        errorIfNotCreated("detailToolStrip");
        return (NavigationBar)NavigationBar.getByJSObject(getAttributeAsJavaScriptObject("detailToolStrip"));
    }

    /**
     * UI layout mode used for this <code>SplitPane</code>. <p> A <code>SplitPane</code> can be configured with up to 3 panes:
     * the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}, {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}.  Both {@link
     * com.smartgwt.client.types.DeviceMode} and {@link com.smartgwt.client.types.PageOrientation} influence the placement of
     * these panes as follows: <ul> <li>"handset" <code>deviceMode</code>: only a single pane is shown at a time.  Not     
     * orientation sensitive <li>"tablet" <code>deviceMode</code> with <code>pageOrientation</code>:"landscape": the     
     * <code>detailPane</code> is shown side by side with either the      <code>navigationPane</code> or <code>listPane</code>
     * <li>"tablet" <code>deviceMode</code> with <code>pageOrientation</code>:"portrait": the      <code>detailPane</code> is
     * shown only.  End user navigation that would show the      <code>listPane</code> or <code>navigationPane</code> shows
     * those panes on top of the      <code>detailPane</code> (temporarily covering part of its content) <li>"desktop"
     * <code>deviceMode</code>: all 3 panes are shown simultaneously.  Not      orientation sensitive </ul> The
     * <code>listPane</code> is optional; if not present, wherever the <code>listPane</code> is mentioned above, the
     * <code>navigationPane</code> is shown instead.
     *
     * @param deviceMode  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDeviceMode(DeviceMode deviceMode)  throws IllegalStateException {
        setAttribute("deviceMode", deviceMode == null ? null : deviceMode.getValue(), false);
    }

    /**
     * UI layout mode used for this <code>SplitPane</code>. <p> A <code>SplitPane</code> can be configured with up to 3 panes:
     * the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}, {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}.  Both {@link
     * com.smartgwt.client.types.DeviceMode} and {@link com.smartgwt.client.types.PageOrientation} influence the placement of
     * these panes as follows: <ul> <li>"handset" <code>deviceMode</code>: only a single pane is shown at a time.  Not     
     * orientation sensitive <li>"tablet" <code>deviceMode</code> with <code>pageOrientation</code>:"landscape": the     
     * <code>detailPane</code> is shown side by side with either the      <code>navigationPane</code> or <code>listPane</code>
     * <li>"tablet" <code>deviceMode</code> with <code>pageOrientation</code>:"portrait": the      <code>detailPane</code> is
     * shown only.  End user navigation that would show the      <code>listPane</code> or <code>navigationPane</code> shows
     * those panes on top of the      <code>detailPane</code> (temporarily covering part of its content) <li>"desktop"
     * <code>deviceMode</code>: all 3 panes are shown simultaneously.  Not      orientation sensitive </ul> The
     * <code>listPane</code> is optional; if not present, wherever the <code>listPane</code> is mentioned above, the
     * <code>navigationPane</code> is shown instead.
     *
     * @return DeviceMode
     */
    public DeviceMode getDeviceMode()  {
        return EnumUtil.getEnum(DeviceMode.values(), getAttribute("deviceMode"));
    }

    /**
     * An optional list pane displayed in the left-hand of the panes or in a side panel according to the pane layout.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Sets a new {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} at runtime.
     *
     * @param listPane new list pane for this widget.. Default value is null
     */
    public void setListPane(Canvas listPane) {
        setAttribute("listPane", listPane == null ? null : listPane.getOrCreateJsObj(), true);
    }

    /**
     * An optional list pane displayed in the left-hand of the panes or in a side panel according to the pane layout.
     *
     * @return Canvas
     */
    public Canvas getListPane()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("listPane"));
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Sets the title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}.
     *
     * @param listTitle new title for the list pane. See {@link com.smartgwt.client.docs.HTMLString HTMLString} . Default value is null
     */
    public void setListTitle(String listTitle) {
        setAttribute("listTitle", listTitle, true);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}.
     *
     * @return  See {@link com.smartgwt.client.docs.HTMLString HTMLString} 
     */
    public String getListTitle()  {
        return getAttributeAsString("listTitle");
    }

    /**
     * Bar displayed above the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}, if a
     * <code>listPane</code> is present, <b>only</b> for {@link com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode
     * deviceMode} "desktop".
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return NavigationBar
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public NavigationBar getListToolStrip() throws IllegalStateException {
        errorIfNotCreated("listToolStrip");
        return (NavigationBar)NavigationBar.getByJSObject(getAttributeAsJavaScriptObject("listToolStrip"));
    }

    /**
     * The AutoChild {@link com.smartgwt.client.widgets.layout.NavigationBar} managed by this widget. <p> The following {@link
     * com.smartgwt.client.docs.AutoChildUsage passthroughs} apply: <ul> <li>{@link
     * com.smartgwt.client.widgets.layout.SplitPane#getShowRightButton showRightButton} for NavigationBar.showRightButton.</li>
     * <li>{@link com.smartgwt.client.widgets.layout.SplitPane#getShowLeftButton showLeftButton} for
     * NavigationBar.showLeftButton.</li> </ul>
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return NavigationBar
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public NavigationBar getNavigationBar() throws IllegalStateException {
        errorIfNotCreated("navigationBar");
        return (NavigationBar)NavigationBar.getByJSObject(getAttributeAsJavaScriptObject("navigationBar"));
    }

    /**
     * The left-hand of the two panes managed by this widget, used for navigation.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Update the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} at runtime.
     *
     * @param navigationPane new navigation pane for this widget.. Default value is null
     */
    public void setNavigationPane(Canvas navigationPane) {
        setAttribute("navigationPane", navigationPane == null ? null : navigationPane.getOrCreateJsObj(), true);
    }

    /**
     * The left-hand of the two panes managed by this widget, used for navigation.
     *
     * @return Canvas
     */
    public Canvas getNavigationPane()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("navigationPane"));
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Sets the title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}.
     *
     * @param navigationTitle new title for the navigation pane. See {@link com.smartgwt.client.docs.HTMLString HTMLString} . Default value is null
     */
    public void setNavigationTitle(String navigationTitle) {
        setAttribute("navigationTitle", navigationTitle, true);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}.
     *
     * @return  See {@link com.smartgwt.client.docs.HTMLString HTMLString} 
     */
    public String getNavigationTitle()  {
        return getAttributeAsString("navigationTitle");
    }

    /**
     * Current {@link com.smartgwt.client.types.PageOrientation}.  The default behavior of the <code>SplitPane</code> is to
     * register for orientation change notifications from the device (see {@link com.smartgwt.client.util.Page#getOrientation
     * Page.getOrientation}) and automatically change orientation based on the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode type of device}. <p> You can instead set a specific value for
     * <code>pageOrientation</code> if you only want to use a specific layout, and not respond to orientation information from
     * the device.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Explicitly sets the page orientation to a fixed value instead of being responsive to device orientation changes.  Pass <code>null</code> to return to responding automatically to device orientation. <p> See {@link com.smartgwt.client.types.PageOrientation} for details of how page orientation affects layout.
     *
     * @param pageOrientation new orientation to use.. Default value is null
     */
    public void setPageOrientation(PageOrientation pageOrientation) {
        setAttribute("pageOrientation", pageOrientation == null ? null : pageOrientation.getValue(), true);
    }

    /**
     * Current {@link com.smartgwt.client.types.PageOrientation}.  The default behavior of the <code>SplitPane</code> is to
     * register for orientation change notifications from the device (see {@link com.smartgwt.client.util.Page#getOrientation
     * Page.getOrientation}) and automatically change orientation based on the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode type of device}. <p> You can instead set a specific value for
     * <code>pageOrientation</code> if you only want to use a specific layout, and not respond to orientation information from
     * the device.
     *
     * @return PageOrientation
     */
    public PageOrientation getPageOrientation()  {
        return EnumUtil.getEnum(PageOrientation.values(), getAttribute("pageOrientation"));
    }

    /**
     * Should the {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton} be shown in the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}?
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Show or hide the {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton} of the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}. Note that the default behavior is to automatically create and show a "back button" as the left button that allows transitioning back to the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} (tablet and handset mode) or the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} (handset mode). If <code>showLeftButton</code> is true, then a left button is shown <em>in addition</em> to the automatically-created back button.
     *
     * @param showLeftButton if true, the button will be shown, otherwise hidden.. Default value is false
     */
    public void setShowLeftButton(boolean showLeftButton) {
        setAttribute("showLeftButton", showLeftButton, true);
    }

    /**
     * Should the {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButton leftButton} be shown in the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}?
     *
     * @return boolean
     */
    public boolean getShowLeftButton()  {
        return getAttributeAsBoolean("showLeftButton");
    }

    /**
     * If enabled, the <code>SplitPane</code> will add resize bars between the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} when these panes are shown side-by-side, and
     * between the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} in {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode:"desktop"}.
     *
     * @param showResizeBars  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowResizeBars(boolean showResizeBars)  throws IllegalStateException {
        setAttribute("showResizeBars", showResizeBars, false);
    }

    /**
     * If enabled, the <code>SplitPane</code> will add resize bars between the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} when these panes are shown side-by-side, and
     * between the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} in {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode:"desktop"}.
     *
     * @return boolean
     */
    public boolean getShowResizeBars()  {
        return getAttributeAsBoolean("showResizeBars");
    }

    /**
     * Should the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton} be shown in the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}?
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Show or hide the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton} of the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}.
     *
     * @param showRightButton if true, the button will be shown, otherwise hidden.. Default value is false
     */
    public void setShowRightButton(boolean showRightButton) {
        setAttribute("showRightButton", showRightButton, true);
    }

    /**
     * Should the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton} be shown in the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}?
     *
     * @return boolean
     */
    public boolean getShowRightButton()  {
        return getAttributeAsBoolean("showRightButton");
    }

    // ********************* Methods ***********************
    /**
     * Add a navigationClick handler.
     * <p>
     * Notification method fired when the user clicks the default back / forward buttons on the navigation bar for this
     * <code>SplitPane</code>.
     *
     * @param handler the navigationClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addNavigationClickHandler(com.smartgwt.client.widgets.layout.events.NavigationClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.NavigationClickEvent.getType()) == 0) setupNavigationClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.NavigationClickEvent.getType());
    }

    private native void setupNavigationClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        var navigationClick = $entry(function(){
            var param = {"direction" : arguments[0]};

                var event = @com.smartgwt.client.widgets.layout.events.NavigationClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({navigationClick:  navigationClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.navigationClick =  navigationClick             ;
        }
   }-*/;
    /**
     * Add a paneChanged handler.
     * <p>
     * Notification fired when the {@link com.smartgwt.client.widgets.layout.SplitPane#getCurrentPane currentPane} changes,
     * either due to end-user action or due to a programmatic call to {@link
     * com.smartgwt.client.widgets.layout.SplitPane#setCurrentPane setCurrentPane()} or other APIs that can change the pane.
     * <p> Note that depending on the {@link com.smartgwt.client.types.DeviceMode}, this event may not signal that any pane has
     * actually been shown or hidden, since in some modes multiple panes are shown simultaneously. <p> Never fires while the
     * <code>SplitPane</code> is not drawn.
     *
     * @param handler the paneChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addPaneChangedHandler(com.smartgwt.client.widgets.layout.events.PaneChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.PaneChangedEvent.getType()) == 0) setupPaneChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.PaneChangedEvent.getType());
    }

    private native void setupPaneChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        var paneChanged = $entry(function(){
            var param = {"newPane" : arguments[0]};

                var event = @com.smartgwt.client.widgets.layout.events.PaneChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({paneChanged:  paneChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.paneChanged =  paneChanged             ;
        }
   }-*/;

	/**
     * Setter for {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButtonTitle leftButtonTitle} of the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}.
     * @param newTitle new title for the left button.. See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native void setLeftButtonTitle(String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setLeftButtonTitle(newTitle);
    }-*/;


	/**
     * Setter for the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButtonTitle rightButtonTitle} of the
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}.
     * @param newTitle new title for right button.. See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native void setRightButtonTitle(String newTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setRightButtonTitle(newTitle);
    }-*/;

	/**
     * Causes a transition to the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}, optionally
     * updating the {@link com.smartgwt.client.widgets.layout.SplitPane#setDetailTitle detail title}. <p> If, based on the
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation}, this causes the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} or {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} to be hidden, the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getLeftButton back button} will be updated with the current title of the
     * <code>navigationPane</code> or <code>listPane</code>, or the <code>backButtonTitle</code> passed to this method. When
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getAddHistoryEntries addHistoryEntries} is enabled and
     * <code>backButtonTitle</code> is passed, then <code>backButtonTitle</code> will be used for the back button title if the
     * user goes back to the <code>detailPane</code>.
     */
    public native void showDetailPane() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showDetailPane();
    }-*/;

    /**
     * @see {@link SplitPane#showDetailPane()}
     */
    public void showDetailPane(String detailPaneTitle){
        showDetailPane(detailPaneTitle, null);
    }

	/**
     * Causes a transition to the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}, optionally
     * updating the {@link com.smartgwt.client.widgets.layout.SplitPane#setDetailTitle detail title}. <p> If, based on the
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation}, this causes the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} or {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} to be hidden, the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getLeftButton back button} will be updated with the current title of the
     * <code>navigationPane</code> or <code>listPane</code>, or the <code>backButtonTitle</code> passed to this method. When
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getAddHistoryEntries addHistoryEntries} is enabled and
     * <code>backButtonTitle</code> is passed, then <code>backButtonTitle</code> will be used for the back button title if the
     * user goes back to the <code>detailPane</code>.
     * @param detailPaneTitle optional new detail title.. See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @param backButtonTitle optional new title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getLeftButton back button}.. See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native void showDetailPane(String detailPaneTitle, String backButtonTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showDetailPane(detailPaneTitle, backButtonTitle);
    }-*/;

	/**
     * Causes a transition to the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}, optionally
     * updating the {@link com.smartgwt.client.widgets.layout.SplitPane#setListTitle list title}. <p> If, based on the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation}, this causes the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} to be hidden, the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getLeftButton back button} will be updated with the current title of the
     * <code>navigationPane</code>, or the <code>backButtonTitle</code> passed to this method. When {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getAddHistoryEntries addHistoryEntries} is enabled and
     * <code>backButtonTitle</code> is passed, then <code>backButtonTitle</code> will be used for the back button title if the
     * user goes back to the <code>listPane</code>.
     */
    public native void showListPane() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showListPane();
    }-*/;

    /**
     * @see {@link SplitPane#showListPane()}
     */
    public void showListPane(String listPaneTitle){
        showListPane(listPaneTitle, null);
    }

	/**
     * Causes a transition to the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}, optionally
     * updating the {@link com.smartgwt.client.widgets.layout.SplitPane#setListTitle list title}. <p> If, based on the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation}, this causes the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} to be hidden, the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getLeftButton back button} will be updated with the current title of the
     * <code>navigationPane</code>, or the <code>backButtonTitle</code> passed to this method. When {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getAddHistoryEntries addHistoryEntries} is enabled and
     * <code>backButtonTitle</code> is passed, then <code>backButtonTitle</code> will be used for the back button title if the
     * user goes back to the <code>listPane</code>.
     * @param listPaneTitle optional new list title.. See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @param backButtonTitle optional new title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getLeftButton back button}.. See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native void showListPane(String listPaneTitle, String backButtonTitle) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showListPane(listPaneTitle, backButtonTitle);
    }-*/;

	/**
     * Causes a transition to the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}.
     */
    public native void showNavigationPane() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showNavigationPane();
    }-*/;


    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param splitPaneProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(SplitPane splitPaneProperties) /*-{
    	var properties = $wnd.isc.addProperties({},splitPaneProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.SplitPane.addProperties(properties);
    }-*/;

    // ***********************************************************



    public LogicalStructureObject setLogicalStructure(SplitPaneLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.addHistoryEntries = getAttributeAsString("addHistoryEntries");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.addHistoryEntries:" + t.getMessage() + "\n";
        }
        try {
            s.currentPane = getAttributeAsString("currentPane");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.currentPane:" + t.getMessage() + "\n";
        }
        try {
            s.detailNavigationControl = getDetailNavigationControl();
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.detailNavigationControl:" + t.getMessage() + "\n";
        }
        try {
            s.detailPane = getDetailPane();
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.detailPane:" + t.getMessage() + "\n";
        }
        try {
            s.detailTitle = getAttributeAsString("detailTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.detailTitle:" + t.getMessage() + "\n";
        }
        try {
            s.detailToolButtons = getDetailToolButtons();
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.detailToolButtonsArray:" + t.getMessage() + "\n";
        }
        try {
            s.deviceMode = getAttributeAsString("deviceMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.deviceMode:" + t.getMessage() + "\n";
        }
        try {
            s.listPane = getListPane();
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.listPane:" + t.getMessage() + "\n";
        }
        try {
            s.listTitle = getAttributeAsString("listTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.listTitle:" + t.getMessage() + "\n";
        }
        try {
            s.navigationPane = getNavigationPane();
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.navigationPane:" + t.getMessage() + "\n";
        }
        try {
            s.navigationTitle = getAttributeAsString("navigationTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.navigationTitle:" + t.getMessage() + "\n";
        }
        try {
            s.pageOrientation = getAttributeAsString("pageOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.pageOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.showLeftButton = getAttributeAsString("showLeftButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.showLeftButton:" + t.getMessage() + "\n";
        }
        try {
            s.showResizeBars = getAttributeAsString("showResizeBars");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.showResizeBars:" + t.getMessage() + "\n";
        }
        try {
            s.showRightButton = getAttributeAsString("showRightButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.showRightButton:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        SplitPaneLogicalStructure s = new SplitPaneLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

