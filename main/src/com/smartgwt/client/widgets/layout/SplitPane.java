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
import com.smartgwt.client.util.events.*;
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
import com.smartgwt.logicalstructure.widgets.ace.*;
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
 * desktop machines and on tablets in landscape orientation, while switching to showing a single pane for handset-sized
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
 * com.smartgwt.client.widgets.layout.SplitPane#getDetailToolButtons detailToolButtons} for details. <p> <h3>NavigationBar
 * and ToolStrips</h3> <p> By default, bars are created as follows: <ul> <li> in <code>deviceMode:"tablet"</code> and
 * <code>deviceMode</code> "handset", the      {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar
 * navigationBar} is always created. <li> in <code>deviceMode:"desktop"</code>, the <code>navigationBar</code> is created
 * by      default only if the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationTitle navigationTitle} is
 * specified and non-empty or      {@link com.smartgwt.client.widgets.layout.SplitPane#getShowRightButton showRightButton}
 * and/or {@link com.smartgwt.client.widgets.layout.SplitPane#getShowLeftButton showLeftButton} is <code>true</code>,     
 * or {@link com.smartgwt.client.widgets.layout.SplitPane#getShowNavigationBar showNavigationBar} is <code>true</code>.
 * <li> in <code>deviceMode:"desktop"</code> and <code>deviceMode</code> "tablet", the      {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} is shown <em>above</em> the
 * <code>detailPane</code>. <li> in <code>deviceMode:"handset"</code>, the {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} is created      <strong>only</strong>
 * if <code>detailToolButtons</code> are specified, and is placed      <em>underneath</em> the <code>detailPane</code>.
 * <li> {@link com.smartgwt.client.widgets.layout.SplitPane#getListToolStrip listToolStrip} - separate bar for the
 * <code>listPane</code>, only present      for <code>deviceMode:"desktop"</code> when a <code>listPane</code> is provided.
 * </ul> All of these bars are {@link com.smartgwt.client.docs.AutoChildUsage AutoChildren} and hence completely optional. 
 * You can omit them entirely, or, if you want navigation bars or tool strips but want to customize them more than the
 * AutoChild system allows, you can prevent the built-in bars from being created and place your own {@link
 * com.smartgwt.client.widgets.layout.NavigationBar}s either <em>inside</em> your navigation, list or detail panes, or
 * <em>outside</em> the <code>SplitPane</code> as a whole. This allows you to completely customize your navigation but
 * still use <code>SplitPane</code> to handle device- and orientation-aware layout. See {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getShowNavigationBar showNavigationBar}, {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getShowListToolStrip showListToolStrip}, and {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getShowDetailToolStrip showDetailToolStrip}. <p> Note that in addition to
 * the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}, the other automatically created
 * bars are also instances of {@link com.smartgwt.client.widgets.layout.NavigationBar} despite the "toolStrip" naming
 * convention. These controls will not generally contain navigation elements; the <code>NavigationBar</code> class is used
 * for consistent styling, since the <code>navigationBar</code> appears adjacent to the toolstrips in some modes and
 * orientations, so they should have the same height and styling.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("SplitPane")
public class SplitPane extends Layout implements com.smartgwt.client.widgets.layout.events.HasDownClickHandlers, com.smartgwt.client.widgets.layout.events.HasNavigationClickHandlers, com.smartgwt.client.widgets.layout.events.HasPaneChangedHandlers, com.smartgwt.client.widgets.layout.events.HasUpClickHandlers {

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
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(SplitPane.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.SplitPane.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(SplitPane.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.SplitPane.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
     * History.addHistoryEntry() and  History.registerCallback() is enabled. The history callback is registered as an additive
     * callback, allowing other history callbacks including the primary callback to be registered. <p> The default history
     * management scheme is as follows: <ul> <li>History entries are only added after {@link
     * com.smartgwt.client.util.Page#isLoaded page load} and when the <code>SplitPane</code> is drawn.</li> <li>A history entry
     * is added for a pane that is hidden by {@link com.smartgwt.client.widgets.layout.SplitPane#showNavigationPane
     * showNavigationPane()}, {@link com.smartgwt.client.widgets.layout.SplitPane#showListPane showListPane()}, or {@link
     * com.smartgwt.client.widgets.layout.SplitPane#showDetailPane showDetailPane()} for the current {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation} settings. <p> Example 1: When
     * <code>deviceMode</code> is "desktop", all 3 panes are shown simultaneously, so no history entries are added. <p> Example
     * 2: When <code>deviceMode</code> is "handset", calling {@link com.smartgwt.client.widgets.layout.SplitPane#showDetailPane
     * showDetailPane()} will hide the current pane (the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane
     * listPane} if present, otherwise the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane
     * navigationPane}). A history entry is added for the pane that was hidden</li> </ul> <p> The default history management
     * scheme can be supplemented with application-specific history management. For example, when <code>deviceMode</code> is
     * "tablet", the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} is always visible, but
     * changes to the content of the <code>detailPane</code> are transparent to the <code>SplitPane</code>. The application can
     * add history entries of its own when the user causes new information to be displayed in the <code>detailPane</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.SplitPane#getAddHistoryEntries addHistoryEntries}.
     *
     * @param addHistoryEntries the new setting. Default value is false
     */
    public void setAddHistoryEntries(boolean addHistoryEntries) {
        setAttribute("addHistoryEntries", addHistoryEntries, true);
    }

    /**
     * Should default history-tracking support be enabled? If <code>true</code>, then a history management scheme utilizing 
     * History.addHistoryEntry() and  History.registerCallback() is enabled. The history callback is registered as an additive
     * callback, allowing other history callbacks including the primary callback to be registered. <p> The default history
     * management scheme is as follows: <ul> <li>History entries are only added after {@link
     * com.smartgwt.client.util.Page#isLoaded page load} and when the <code>SplitPane</code> is drawn.</li> <li>A history entry
     * is added for a pane that is hidden by {@link com.smartgwt.client.widgets.layout.SplitPane#showNavigationPane
     * showNavigationPane()}, {@link com.smartgwt.client.widgets.layout.SplitPane#showListPane showListPane()}, or {@link
     * com.smartgwt.client.widgets.layout.SplitPane#showDetailPane showDetailPane()} for the current {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation} settings. <p> Example 1: When
     * <code>deviceMode</code> is "desktop", all 3 panes are shown simultaneously, so no history entries are added. <p> Example
     * 2: When <code>deviceMode</code> is "handset", calling {@link com.smartgwt.client.widgets.layout.SplitPane#showDetailPane
     * showDetailPane()} will hide the current pane (the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane
     * listPane} if present, otherwise the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane
     * navigationPane}). A history entry is added for the pane that was hidden</li> </ul> <p> The default history management
     * scheme can be supplemented with application-specific history management. For example, when <code>deviceMode</code> is
     * "tablet", the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} is always visible, but
     * changes to the content of the <code>detailPane</code> are transparent to the <code>SplitPane</code>. The application can
     * add history entries of its own when the user causes new information to be displayed in the <code>detailPane</code>.
     *
     * @return Current addHistoryEntries value. Default value is false
     */
    public boolean getAddHistoryEntries()  {
        Boolean result = getAttributeAsBoolean("addHistoryEntries");
        return result == null ? false : result;
    }
    

    /**
     * Whether to animate state changes of the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar
     * navigationBar}. Enabled by default except when the browser is known to have poor animation performance.
     *
     * @param animateNavigationBarStateChanges New animateNavigationBarStateChanges value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.layout.NavigationBar#setAnimateStateChanges
     */
    public void setAnimateNavigationBarStateChanges(boolean animateNavigationBarStateChanges)  throws IllegalStateException {
        setAttribute("animateNavigationBarStateChanges", animateNavigationBarStateChanges, false);
    }

    /**
     * Whether to animate state changes of the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar
     * navigationBar}. Enabled by default except when the browser is known to have poor animation performance.
     *
     * @return Current animateNavigationBarStateChanges value. Default value is true
     * @see com.smartgwt.client.widgets.layout.NavigationBar#getAnimateStateChanges
     */
    public boolean getAnimateNavigationBarStateChanges()  {
        Boolean result = getAttributeAsBoolean("animateNavigationBarStateChanges");
        return result == null ? true : result;
    }
    

    /**
     * If set, the <code>SplitPane</code> will automatically monitor selection changes in the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}, and call {@link
     * com.smartgwt.client.widgets.layout.SplitPane#navigateListPane navigateListPane()} or {@link
     * com.smartgwt.client.widgets.layout.SplitPane#navigateDetailPane navigateDetailPane()} when selections are changed. <p>
     * If any configured panes lack DataSources or there is no DataSource relationship declared between panes,
     * <code>autoNavigate</code> does nothing.
     *
     * @param autoNavigate New autoNavigate value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_splitpane" target="examples">SplitPane Example</a>
     */
    public void setAutoNavigate(Boolean autoNavigate)  throws IllegalStateException {
        setAttribute("autoNavigate", autoNavigate, false);
    }

    /**
     * If set, the <code>SplitPane</code> will automatically monitor selection changes in the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}, and call {@link
     * com.smartgwt.client.widgets.layout.SplitPane#navigateListPane navigateListPane()} or {@link
     * com.smartgwt.client.widgets.layout.SplitPane#navigateDetailPane navigateDetailPane()} when selections are changed. <p>
     * If any configured panes lack DataSources or there is no DataSource relationship declared between panes,
     * <code>autoNavigate</code> does nothing.
     *
     * @return Current autoNavigate value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_splitpane" target="examples">SplitPane Example</a>
     */
    public Boolean getAutoNavigate()  {
        return getAttributeAsBoolean("autoNavigate");
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.NavigationButton} shown to the left of the  {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationTitle title}  in the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}.  <P> In {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceModes} other than "desktop", this button is 
     * automatically created and allows transitioning back to the  {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} (in tablet and handset modes) or the 
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} (in handset mode).  In these  {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceModes}, setting  {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getShowLeftButton showLeftButton} to true shows the  {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getLeftButton leftButton} <em>in addition to</em> the 
     * automatically-created back button. <P> When {@link com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode
     * deviceMode} is "desktop", this button is never shown. See {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getShowLeftButton showLeftButton} for more information. <P> This button's
     * {@link com.smartgwt.client.widgets.Button#getTitle title} is determined automatically by the  <code>SplitPane</code>. 
     * See {@link com.smartgwt.client.widgets.layout.SplitPane#getListTitle listTitle} and  {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailTitle detailTitle}.
     * <p>
     * This component is an AutoChild named "backButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current backButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public NavigationButton getBackButton() throws IllegalStateException {
        errorIfNotCreated("backButton");
        return (NavigationButton)NavigationButton.getByJSObject(getAttributeAsJavaScriptObject("backButton"));
    }
    

    /**
     * The most recently shown pane.  In handset {@link com.smartgwt.client.types.DeviceMode}, the <code>currentPane</code> is
     * the only pane that is actually visible to the user.  In other modes more than one pane can be simultaneously visible, so
     * the <code>currentPane</code> is the most recent pane that was brought into view via a call to {@link
     * com.smartgwt.client.widgets.layout.SplitPane#setCurrentPane setCurrentPane()} or {@link
     * com.smartgwt.client.widgets.layout.SplitPane#showNavigationPane showNavigationPane()}. <p> The default value of
     * <code>currentPane</code> is "navigation".
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Reveals the pane indicated by the <code>newPane</code> parameter. <p> This has different effects based on the {@link com.smartgwt.client.types.DeviceMode} and {@link com.smartgwt.client.types.PageOrientation}.  For example, in "handset" mode, the new pane will be the only one showing.  In other modes such as "desktop", this method may do nothing, but should still be called in order to ensure correct behavior with other {@link com.smartgwt.client.types.DeviceMode} settings.
     *
     * @param currentPane new pane to show. Default value is "navigation"
     */
    public void setCurrentPane(CurrentPane currentPane) {
        setAttribute("currentPane", currentPane == null ? null : currentPane.getValue(), true);
    }

    /**
     * The most recently shown pane.  In handset {@link com.smartgwt.client.types.DeviceMode}, the <code>currentPane</code> is
     * the only pane that is actually visible to the user.  In other modes more than one pane can be simultaneously visible, so
     * the <code>currentPane</code> is the most recent pane that was brought into view via a call to {@link
     * com.smartgwt.client.widgets.layout.SplitPane#setCurrentPane setCurrentPane()} or {@link
     * com.smartgwt.client.widgets.layout.SplitPane#showNavigationPane showNavigationPane()}. <p> The default value of
     * <code>currentPane</code> is "navigation".
     *
     * @return Current currentPane value. Default value is "navigation"
     */
    public CurrentPane getCurrentPane()  {
        return EnumUtil.getEnum(CurrentPane.values(), getAttribute("currentPane"));
    }
    

    /**
     * Navigation control that appears only when the navigation pane is not showing (showing detail pane on handset, or
     * portrait mode on tablet). <p> See also {@link com.smartgwt.client.widgets.layout.SplitPane#getShowMiniNav showMiniNav}
     * for a way to enable a built-in control.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Navigation control that appears only when the navigation pane is not showing (showing detail pane on handset, or portrait mode on tablet).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param detailNavigationControl New detailNavigationControl value. Default value is null
     */
    public void setDetailNavigationControl(Canvas detailNavigationControl) {
        setAttribute("detailNavigationControl", detailNavigationControl == null ? null : detailNavigationControl.getOrCreateJsObj(), true);
    }

    /**
     * Navigation control that appears only when the navigation pane is not showing (showing detail pane on handset, or
     * portrait mode on tablet). <p> See also {@link com.smartgwt.client.widgets.layout.SplitPane#getShowMiniNav showMiniNav}
     * for a way to enable a built-in control.
     *
     * @return Current detailNavigationControl value. Default value is null
     */
    public Canvas getDetailNavigationControl()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("detailNavigationControl"));
    }
    

    /**
     * The right-hand of the two panes managed by this widget, used for viewing details.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets a new {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} at runtime.
     *
     * @param detailPane new detail pane for this widget. Default value is null
     */
    public void setDetailPane(Canvas detailPane) {
        setAttribute("detailPane", detailPane == null ? null : detailPane.getOrCreateJsObj(), true);
    }

    /**
     * The right-hand of the two panes managed by this widget, used for viewing details.
     *
     * @return Current detailPane value. Default value is null
     */
    public Canvas getDetailPane()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("detailPane"));
    }
    

    /**
     * Default value chosen for {@link com.smartgwt.client.widgets.layout.SplitPane#setDetailTitle detailPaneTitle} when {@link
     * com.smartgwt.client.widgets.layout.SplitPane#navigateDetailPane navigateDetailPane()} is called. <p> Available variables
     * are the same as for {@link com.smartgwt.client.widgets.layout.SplitPane#getListPaneTitleTemplate listPaneTitleTemplate}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets a new {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPaneTitleTemplate detailPaneTitleTemplate} at runtime. <p> By calling this method it is assumed you want the detail pane title to change to the new template.
     *
     * @param detailPaneTitleTemplate new template, can use HTML to be styled. Default value is "${titleField}"
     * @see com.smartgwt.client.widgets.layout.SplitPane#setListPaneTitleTemplate
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_splitpane" target="examples">SplitPane Example</a>
     */
    public void setDetailPaneTitleTemplate(String detailPaneTitleTemplate) {
        setAttribute("detailPaneTitleTemplate", detailPaneTitleTemplate, true);
    }

    /**
     * Default value chosen for {@link com.smartgwt.client.widgets.layout.SplitPane#setDetailTitle detailPaneTitle} when {@link
     * com.smartgwt.client.widgets.layout.SplitPane#navigateDetailPane navigateDetailPane()} is called. <p> Available variables
     * are the same as for {@link com.smartgwt.client.widgets.layout.SplitPane#getListPaneTitleTemplate listPaneTitleTemplate}.
     *
     * @return Current detailPaneTitleTemplate value. Default value is "${titleField}"
     * @see com.smartgwt.client.widgets.layout.SplitPane#getListPaneTitleTemplate
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_splitpane" target="examples">SplitPane Example</a>
     */
    public String getDetailPaneTitleTemplate()  {
        return getAttributeAsString("detailPaneTitleTemplate");
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}.
     *
     * @param detailTitle new title for the detail pane. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setDetailTitle(String detailTitle) {
        setAttribute("detailTitle", detailTitle, true);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}.
     *
     * @return Current detailTitle value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getDetailTitle()  {
        return getAttributeAsString("detailTitle");
    }
    

    /**
     * <code>detailToolButtons</code> allows you to specify a set of controls that are specially placed based on the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation}. This is generally useful for a compact
     * strip of {@link com.smartgwt.client.widgets.ImgButton} controls, approximately 5 of which will fit comfortably using
     * typically-sized icons and in the most space-constricted modes. <p> These controls are placed as follows: <ul> <li> in
     * <code>deviceMode:"desktop"</code> and <code>deviceMode</code> "tablet" with      <code>pageOrientation</code>
     * "landscape", <code>detailToolButtons</code> appear in the      {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} shown <i>above</i> of the
     * <code>detailPane</code>. <li> in <code>deviceMode:"handset"</code>, <code>detailToolButtons</code> appear in a      
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} <i>underneath</i> the
     * detailPane.  This toolstrip      is only created in "handset" mode if <code>detailToolButtons</code> are provided. <li>
     * in <code>deviceMode:"tablet"</code> and <code>pageOrientation:"portrait"</code>,      <code>detailToolButtons</code>
     * appear in <code>splitPane.navigationBar</code>. </ul>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Updates the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolButtons detailToolButtons} at runtime.
     *
     * @param detailToolButtons new controls for the toolstrip. Default value is null
     */
    public void setDetailToolButtons(Canvas... detailToolButtons) {
        setAttribute("detailToolButtons", detailToolButtons, true);
    }

    /**
     * <code>detailToolButtons</code> allows you to specify a set of controls that are specially placed based on the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation}. This is generally useful for a compact
     * strip of {@link com.smartgwt.client.widgets.ImgButton} controls, approximately 5 of which will fit comfortably using
     * typically-sized icons and in the most space-constricted modes. <p> These controls are placed as follows: <ul> <li> in
     * <code>deviceMode:"desktop"</code> and <code>deviceMode</code> "tablet" with      <code>pageOrientation</code>
     * "landscape", <code>detailToolButtons</code> appear in the      {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} shown <i>above</i> of the
     * <code>detailPane</code>. <li> in <code>deviceMode:"handset"</code>, <code>detailToolButtons</code> appear in a      
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} <i>underneath</i> the
     * detailPane.  This toolstrip      is only created in "handset" mode if <code>detailToolButtons</code> are provided. <li>
     * in <code>deviceMode:"tablet"</code> and <code>pageOrientation:"portrait"</code>,      <code>detailToolButtons</code>
     * appear in <code>splitPane.navigationBar</code>. </ul>
     *
     * @return Current detailToolButtons value. Default value is null
     */
    public Canvas[] getDetailToolButtons()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("detailToolButtons"));
    }
    

    /**
     * Toolstrip servicing the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}. <p> In {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode}  {@link
     * com.smartgwt.client.types.DeviceMode#DESKTOP} and <code>deviceMode</code>  {@link
     * com.smartgwt.client.types.DeviceMode#TABLET}, the <code>detailToolStrip</code> is shown <em>above</em> the
     * <code>detailPane</code>. In {@link com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode}  {@link
     * com.smartgwt.client.types.DeviceMode#HANDSET}, the <code>detailToolStrip</code> is created <strong>only</strong> if
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolButtons detailToolButtons} are specified, and is placed
     * <em>underneath</em> the <code>detailPane</code>.
     * <p>
     * This component is an AutoChild named "detailToolStrip".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current detailToolStrip value. Default value is null
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
     * @param deviceMode New deviceMode value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_splitpane" target="examples">SplitPane Example</a>
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
     * @return Current deviceMode value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_splitpane" target="examples">SplitPane Example</a>
     */
    public DeviceMode getDeviceMode()  {
        return EnumUtil.getEnum(DeviceMode.values(), getAttribute("deviceMode"));
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "SplitPaneEditProxy"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public void setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "SplitPaneEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * An additional {@link com.smartgwt.client.widgets.NavigationButton} which may be shown to the left of the  {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationTitle title} in the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigation bar}. <P> <b>Important note:</b> by default,
     * this button has no  {@link com.smartgwt.client.widgets.NavigationButton#getDirection direction} and does not fire the 
     * {@link com.smartgwt.client.widgets.layout.SplitPane#addNavigationClickHandler navigationClick} notification.  You can
     * provide a  <code>direction</code> and apply a click handler via the autoChild system.
     * <p>
     * This component is an AutoChild named "leftButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current leftButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     * @see com.smartgwt.client.widgets.layout.SplitPane#getShowLeftButton
     * @see com.smartgwt.client.widgets.layout.SplitPane#getBackButton
     */
    public NavigationButton getLeftButton() throws IllegalStateException {
        errorIfNotCreated("leftButton");
        return (NavigationButton)NavigationButton.getByJSObject(getAttributeAsJavaScriptObject("leftButton"));
    }
    

    /**
     * An optional list pane displayed in the left-hand of the panes or in a side panel according to the pane layout.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets a new {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} at runtime.
     *
     * @param listPane new list pane for this widget. Default value is null
     */
    public void setListPane(Canvas listPane) {
        setAttribute("listPane", listPane == null ? null : listPane.getOrCreateJsObj(), true);
    }

    /**
     * An optional list pane displayed in the left-hand of the panes or in a side panel according to the pane layout.
     *
     * @return Current listPane value. Default value is null
     */
    public Canvas getListPane()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("listPane"));
    }
    

    /**
     * Default value chosen for {@link com.smartgwt.client.widgets.layout.SplitPane#setListTitle listPaneTitle} when {@link
     * com.smartgwt.client.widgets.layout.SplitPane#navigateListPane navigateListPane()} is called. <p> Available variables
     * are: <ul> <li> "titleField" - the value of the {@link com.smartgwt.client.data.DataSource#getTitleField
     * DataSource.titleField} in the selected record from the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} <li> "index" - position of the selected
     * record <li> "totalRows" - total number of rows in the component where the record is selected <li> "record" - the entire
     * selected Record </ul>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets a new {@link com.smartgwt.client.widgets.layout.SplitPane#getListPaneTitleTemplate listPaneTitleTemplate} at runtime. <p> By calling this method it is assumed you want the list pane title to change to the new template.
     *
     * @param listPaneTitleTemplate new template, can use HTML to be styled. Default value is "${titleField}"
     * @see com.smartgwt.client.widgets.layout.SplitPane#setDetailPaneTitleTemplate
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_splitpane" target="examples">SplitPane Example</a>
     */
    public void setListPaneTitleTemplate(String listPaneTitleTemplate) {
        setAttribute("listPaneTitleTemplate", listPaneTitleTemplate, true);
    }

    /**
     * Default value chosen for {@link com.smartgwt.client.widgets.layout.SplitPane#setListTitle listPaneTitle} when {@link
     * com.smartgwt.client.widgets.layout.SplitPane#navigateListPane navigateListPane()} is called. <p> Available variables
     * are: <ul> <li> "titleField" - the value of the {@link com.smartgwt.client.data.DataSource#getTitleField
     * DataSource.titleField} in the selected record from the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} <li> "index" - position of the selected
     * record <li> "totalRows" - total number of rows in the component where the record is selected <li> "record" - the entire
     * selected Record </ul>
     *
     * @return Current listPaneTitleTemplate value. Default value is "${titleField}"
     * @see com.smartgwt.client.widgets.layout.SplitPane#getDetailPaneTitleTemplate
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_splitpane" target="examples">SplitPane Example</a>
     */
    public String getListPaneTitleTemplate()  {
        return getAttributeAsString("listPaneTitleTemplate");
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}.
     *
     * @param listTitle new title for the list pane. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setListTitle(String listTitle) {
        setAttribute("listTitle", listTitle, true);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}.
     *
     * @return Current listTitle value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getListTitle()  {
        return getAttributeAsString("listTitle");
    }
    

    /**
     * Bar displayed above the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}, if a
     * <code>listPane</code> is present, <b>only</b> for {@link com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode
     * deviceMode} "desktop".
     * <p>
     * This component is an AutoChild named "listToolStrip".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current listToolStrip value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public NavigationBar getListToolStrip() throws IllegalStateException {
        errorIfNotCreated("listToolStrip");
        return (NavigationBar)NavigationBar.getByJSObject(getAttributeAsJavaScriptObject("listToolStrip"));
    }
    

    /**
     * A <code>NavigationBar</code> instance managed by this <code>SplitPane</code> that is placed above the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}. <p> The following {@link
     * com.smartgwt.client.docs.AutoChildUsage passthroughs} apply: <ul> <li>{@link
     * com.smartgwt.client.widgets.layout.SplitPane#getAnimateNavigationBarStateChanges animateNavigationBarStateChanges}    
     * for {@link com.smartgwt.client.widgets.layout.NavigationBar#getAnimateStateChanges NavigationBar.animateStateChanges}
     * <li>{@link com.smartgwt.client.widgets.layout.SplitPane#getShowRightButton showRightButton} for {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#getShowRightButton NavigationBar.showRightButton} </ul> <p> Note that
     * in {@link com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode}  {@link
     * com.smartgwt.client.types.DeviceMode#DESKTOP} with {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getShowNavigationBar showNavigationBar} unset, the
     * <code>navigationBar</code> is automatically hidden when it would be empty ({@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationTitle navigationTitle} is an empty string and
     * <code>showRightButton</code> and <code>showLeftButton</code> are both <code>false</code>). The
     * <code>navigationBar</code> will be shown if the <code>navigationTitle</code> {@link
     * com.smartgwt.client.widgets.layout.SplitPane#setNavigationTitle is set} to a non-empty string, or
     * <code>showRightButton</code> or <code>showLeftButton</code> is set to <code>true</code>.
     * <p>
     * This component is an AutoChild named "navigationBar".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current navigationBar value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     * @see com.smartgwt.client.widgets.layout.SplitPane#getShowNavigationBar
     */
    public NavigationBar getNavigationBar() throws IllegalStateException {
        errorIfNotCreated("navigationBar");
        return (NavigationBar)NavigationBar.getByJSObject(getAttributeAsJavaScriptObject("navigationBar"));
    }
    

    /**
     * An arbitrary widget that is visible in all configurations when the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getCurrentPane currentPane} is  {@link
     * com.smartgwt.client.types.CurrentPane#NAVIGATION} (it may also be visible when the <code>currentPane</code> is  {@link
     * com.smartgwt.client.types.CurrentPane#LIST} or  {@link com.smartgwt.client.types.CurrentPane#DETAIL}). <p> The
     * <code>navigationPane</code> is typically used for navigation, to initialize the content of the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} (when using a <code>listPane</code>) or the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}. For example, in an email application the
     * <code>navigationPane</code> pane widget could be a {@link com.smartgwt.client.widgets.tree.TreeGrid} of the inboxes and
     * folders.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} at runtime.
     *
     * @param navigationPane new navigation pane for this widget. Default value is null
     */
    public void setNavigationPane(Canvas navigationPane) {
        setAttribute("navigationPane", navigationPane == null ? null : navigationPane.getOrCreateJsObj(), true);
    }

    /**
     * An arbitrary widget that is visible in all configurations when the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getCurrentPane currentPane} is  {@link
     * com.smartgwt.client.types.CurrentPane#NAVIGATION} (it may also be visible when the <code>currentPane</code> is  {@link
     * com.smartgwt.client.types.CurrentPane#LIST} or  {@link com.smartgwt.client.types.CurrentPane#DETAIL}). <p> The
     * <code>navigationPane</code> is typically used for navigation, to initialize the content of the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} (when using a <code>listPane</code>) or the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}. For example, in an email application the
     * <code>navigationPane</code> pane widget could be a {@link com.smartgwt.client.widgets.tree.TreeGrid} of the inboxes and
     * folders.
     *
     * @return Current navigationPane value. Default value is null
     */
    public Canvas getNavigationPane()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("navigationPane"));
    }
    

    /**
     * LeftLayout?s initial size
     *
     * @param navigationPaneWidth New navigationPaneWidth value. Default value is 320
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setNavigationPaneWidth(int navigationPaneWidth)  throws IllegalStateException {
        setAttribute("navigationPaneWidth", navigationPaneWidth, false);
    }

    /**
     * LeftLayout?s initial size
     *
     * @return Current navigationPaneWidth value. Default value is 320
     */
    public int getNavigationPaneWidth()  {
        return getAttributeAsInt("navigationPaneWidth");
    }
    

    /**
     * The title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}, displayed in
     * the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar} and also used for the title of a
     * back button in some configurations.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}.
     *
     * @param navigationTitle new title for the navigation pane. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setNavigationTitle(String navigationTitle) {
        setAttribute("navigationTitle", navigationTitle, true);
    }

    /**
     * The title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}, displayed in
     * the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar} and also used for the title of a
     * back button in some configurations.
     *
     * @return Current navigationTitle value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getNavigationTitle()  {
        return getAttributeAsString("navigationTitle");
    }
    

    /**
     * Whether or not to call {@link com.smartgwt.client.widgets.layout.SplitPane#addNavigationClickHandler
     * SplitPane.navigationClick()}, if present, after navigation has already occurred.  This may be set false to allow {@link
     * com.smartgwt.client.widgets.layout.SplitPane#addNavigationClickHandler SplitPane.navigationClick()} to be canceled.
     *
     * @param notifyAfterNavigationClick New notifyAfterNavigationClick value. Default value is true
     * @see com.smartgwt.client.widgets.layout.events.PaneChangedEvent
     * @see com.smartgwt.client.widgets.layout.events.NavigationClickEvent
     */
    public void setNotifyAfterNavigationClick(boolean notifyAfterNavigationClick) {
        setAttribute("notifyAfterNavigationClick", notifyAfterNavigationClick, true);
    }

    /**
     * Whether or not to call {@link com.smartgwt.client.widgets.layout.SplitPane#addNavigationClickHandler
     * SplitPane.navigationClick()}, if present, after navigation has already occurred.  This may be set false to allow {@link
     * com.smartgwt.client.widgets.layout.SplitPane#addNavigationClickHandler SplitPane.navigationClick()} to be canceled.
     *
     * @return Current notifyAfterNavigationClick value. Default value is true
     * @see com.smartgwt.client.widgets.layout.events.PaneChangedEvent
     * @see com.smartgwt.client.widgets.layout.events.NavigationClickEvent
     */
    public boolean getNotifyAfterNavigationClick()  {
        Boolean result = getAttributeAsBoolean("notifyAfterNavigationClick");
        return result == null ? true : result;
    }
    

    /**
     * Current {@link com.smartgwt.client.types.PageOrientation}.  The default behavior of the <code>SplitPane</code> is to
     * register for orientation change notifications from the device (see {@link com.smartgwt.client.util.Page#getOrientation
     * Page.getOrientation()}) and automatically change orientation based on the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode type of device}. <p> You can instead set a specific value for
     * <code>pageOrientation</code> if you only want to use a specific layout, and not respond to orientation information from
     * the device.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Explicitly sets the page orientation to a fixed value instead of being responsive to device orientation changes.  Pass <code>null</code> to return to responding automatically to device orientation. <p> See {@link com.smartgwt.client.types.PageOrientation} for details of how page orientation affects layout.
     *
     * @param pageOrientation new orientation to use. Default value is null
     */
    public void setPageOrientation(PageOrientation pageOrientation) {
        setAttribute("pageOrientation", pageOrientation == null ? null : pageOrientation.getValue(), true);
    }

    /**
     * Current {@link com.smartgwt.client.types.PageOrientation}.  The default behavior of the <code>SplitPane</code> is to
     * register for orientation change notifications from the device (see {@link com.smartgwt.client.util.Page#getOrientation
     * Page.getOrientation()}) and automatically change orientation based on the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode type of device}. <p> You can instead set a specific value for
     * <code>pageOrientation</code> if you only want to use a specific layout, and not respond to orientation information from
     * the device.
     *
     * @return Current pageOrientation value. Default value is null
     */
    public PageOrientation getPageOrientation()  {
        return EnumUtil.getEnum(PageOrientation.values(), getAttribute("pageOrientation"));
    }
    

    /**
     * If set to <code>false</code>, the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip
     * detailToolStrip} will not be shown.
     *
     * @param showDetailToolStrip New showDetailToolStrip value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDetailToolStrip(Boolean showDetailToolStrip)  throws IllegalStateException {
        setAttribute("showDetailToolStrip", showDetailToolStrip, false);
    }

    /**
     * If set to <code>false</code>, the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip
     * detailToolStrip} will not be shown.
     *
     * @return Current showDetailToolStrip value. Default value is null
     */
    public Boolean getShowDetailToolStrip()  {
        return getAttributeAsBoolean("showDetailToolStrip");
    }
    

    /**
     * Should the {@link com.smartgwt.client.widgets.layout.SplitPane#getLeftButton leftButton} be shown in the  {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigation bar}? <p> When set to true, the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getLeftButton leftButton} is displayed to the left of the  {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationTitle navigationTitle}, and to the right of the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getBackButton backButton}, when {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} is not "desktop". <P>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Show or hide the {@link com.smartgwt.client.widgets.layout.SplitPane#getLeftButton leftButton} in the navigation bar.
     *
     * @param showLeftButton if <code>true</code>, the <code>leftButton</code> will be shown, otherwise hidden. Default value is false
     * @see com.smartgwt.client.widgets.layout.SplitPane#setLeftButton
     * @see com.smartgwt.client.widgets.layout.SplitPane#setBackButton
     */
    public void setShowLeftButton(boolean showLeftButton) {
        setAttribute("showLeftButton", showLeftButton, true);
    }

    /**
     * Should the {@link com.smartgwt.client.widgets.layout.SplitPane#getLeftButton leftButton} be shown in the  {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigation bar}? <p> When set to true, the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getLeftButton leftButton} is displayed to the left of the  {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationTitle navigationTitle}, and to the right of the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getBackButton backButton}, when {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} is not "desktop". <P>
     *
     * @return Current showLeftButton value. Default value is false
     * @see com.smartgwt.client.widgets.layout.SplitPane#getLeftButton
     * @see com.smartgwt.client.widgets.layout.SplitPane#getBackButton
     */
    public boolean getShowLeftButton()  {
        Boolean result = getAttributeAsBoolean("showLeftButton");
        return result == null ? false : result;
    }
    

    /**
     * If set to <code>false</code>, the {@link com.smartgwt.client.widgets.layout.SplitPane#getListToolStrip listToolStrip}
     * will not be shown.
     *
     * @param showListToolStrip New showListToolStrip value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowListToolStrip(Boolean showListToolStrip)  throws IllegalStateException {
        setAttribute("showListToolStrip", showListToolStrip, false);
    }

    /**
     * If set to <code>false</code>, the {@link com.smartgwt.client.widgets.layout.SplitPane#getListToolStrip listToolStrip}
     * will not be shown.
     *
     * @return Current showListToolStrip value. Default value is null
     */
    public Boolean getShowListToolStrip()  {
        return getAttributeAsBoolean("showListToolStrip");
    }
    

    /**
     * If true, a {@link com.smartgwt.client.widgets.MiniNavControl} will be shown: <ul> <li>In the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar} when the device mode is          {@link
     * com.smartgwt.client.types.DeviceMode#HANDSET}     and the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getCurrentPane currentPane} is          {@link
     * com.smartgwt.client.types.CurrentPane#DETAIL}. <li>In the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} when the device mode is          {@link
     * com.smartgwt.client.types.DeviceMode#TABLET}     and the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation} is          {@link
     * com.smartgwt.client.types.PageOrientation#PORTRAIT}. </ul> <p>
     *
     * @param showMiniNav New showMiniNav value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.layout.SplitPane#setDetailNavigationControl
     */
    public void setShowMiniNav(Boolean showMiniNav)  throws IllegalStateException {
        setAttribute("showMiniNav", showMiniNav, false);
    }

    /**
     * If true, a {@link com.smartgwt.client.widgets.MiniNavControl} will be shown: <ul> <li>In the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar} when the device mode is          {@link
     * com.smartgwt.client.types.DeviceMode#HANDSET}     and the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getCurrentPane currentPane} is          {@link
     * com.smartgwt.client.types.CurrentPane#DETAIL}. <li>In the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailToolStrip detailToolStrip} when the device mode is          {@link
     * com.smartgwt.client.types.DeviceMode#TABLET}     and the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation} is          {@link
     * com.smartgwt.client.types.PageOrientation#PORTRAIT}. </ul> <p>
     *
     * @return Current showMiniNav value. Default value is false
     * @see com.smartgwt.client.widgets.layout.SplitPane#getDetailNavigationControl
     */
    public Boolean getShowMiniNav()  {
        Boolean result = getAttributeAsBoolean("showMiniNav");
        return result == null ? false : result;
    }
    

    /**
     * If set to <code>false</code>, the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}
     * will not be shown. If set to <code>true</code>, the <code>navigationBar</code> will always be shown, even when the
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} is  {@link
     * com.smartgwt.client.types.DeviceMode#DESKTOP} and the <code>navigationBar</code> would be empty.
     *
     * @param showNavigationBar New showNavigationBar value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowNavigationBar(Boolean showNavigationBar)  throws IllegalStateException {
        setAttribute("showNavigationBar", showNavigationBar, false);
    }

    /**
     * If set to <code>false</code>, the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}
     * will not be shown. If set to <code>true</code>, the <code>navigationBar</code> will always be shown, even when the
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} is  {@link
     * com.smartgwt.client.types.DeviceMode#DESKTOP} and the <code>navigationBar</code> would be empty.
     *
     * @return Current showNavigationBar value. Default value is null
     */
    public Boolean getShowNavigationBar()  {
        return getAttributeAsBoolean("showNavigationBar");
    }
    

    /**
     * If enabled, the <code>SplitPane</code> will add resize bars between the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} when these panes are shown side-by-side, and
     * between the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} in {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode:"desktop"}.
     *
     * @param showResizeBars New showResizeBars value. Default value is true
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
     * @return Current showResizeBars value. Default value is true
     */
    public boolean getShowResizeBars()  {
        Boolean result = getAttributeAsBoolean("showResizeBars");
        return result == null ? true : result;
    }
    

    /**
     * Should the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton} be shown in the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}?
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Show or hide the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton} of the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}.
     *
     * @param showRightButton if <code>true</code>, the button will be shown, otherwise hidden. Default value is false
     */
    public void setShowRightButton(boolean showRightButton) {
        setAttribute("showRightButton", showRightButton, true);
    }

    /**
     * Should the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButton rightButton} be shown in the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}?
     *
     * @return Current showRightButton value. Default value is false
     */
    public boolean getShowRightButton()  {
        Boolean result = getAttributeAsBoolean("showRightButton");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
    /**
     * Add a downClick handler.
     * <p>
     * Notification method fired when the {@link com.smartgwt.client.widgets.layout.SplitPane#getShowMiniNav miniNav is
     * showing} and the down button on the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar
     * navigationBar}'s {@link com.smartgwt.client.widgets.MiniNavControl} is clicked.
     *
     * @param handler the downClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDownClickHandler(com.smartgwt.client.widgets.layout.events.DownClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.DownClickEvent.getType()) == 0) setupDownClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.DownClickEvent.getType());
    }

    private native void setupDownClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var downClick = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.layout.events.DownClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.layout.SplitPane::handleTearDownDownClickEvent()();
            if (hasDefaultHandler) this.Super("downClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("downClick"));
            obj.addProperties({downClick:  downClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("downClick"));
            obj.downClick =  downClick             ;
        }
    }-*/;

    private void handleTearDownDownClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.layout.events.DownClickEvent.getType()) == 0) tearDownDownClickEvent();
    }

    private native void tearDownDownClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("downClick")) delete obj.downClick;
    }-*/;

	/**
     * Calls {@link com.smartgwt.client.widgets.layout.SplitPane#navigatePane navigatePane()} with the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} as the target pane.
     */
    public native void navigateDetailPane() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "navigateDetailPane", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.navigateDetailPane();
    }-*/;

	/**
     * Calls {@link com.smartgwt.client.widgets.layout.SplitPane#navigatePane navigatePane()} with the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} as the target pane.
     * @param title optional title to use instead of the automatically chosen one.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native void navigateDetailPane(String title) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "navigateDetailPane", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.navigateDetailPane(title);
    }-*/;
	
	/**
     * Calls {@link com.smartgwt.client.widgets.layout.SplitPane#navigatePane navigatePane()} with the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} as the target pane.
     */
    public native void navigateListPane() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "navigateListPane", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.navigateListPane();
    }-*/;

	/**
     * Calls {@link com.smartgwt.client.widgets.layout.SplitPane#navigatePane navigatePane()} with the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} as the target pane.
     * @param title optional title to use instead of the automatically chosen one.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native void navigateListPane(String title) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "navigateListPane", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.navigateListPane(title);
    }-*/;
	
	/**
     * Causes the target pane component to load data and update its title based on the current selection in the source pane.
     * <p> Both the source pane and target pane must have a {@link com.smartgwt.client.data.DataSource}, and either: <ul> <li>
     * the two DataSources must have a Many-To-One relationship declared via {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey DataSourceField.foreignKey}, so that {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchRelatedData ListGrid.fetchRelatedData()} can be used on the target pane.
     * <li> the two DataSources must be the same, so that the record selected in the source pane can be displayed in the target
     * pane via simply calling {@link com.smartgwt.client.widgets.viewer.DetailViewer#setData setData()}. </ul> The default
     * <code>target</code> is  {@link com.smartgwt.client.types.CurrentPane#LIST} if the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} is present, otherwise  {@link
     * com.smartgwt.client.types.CurrentPane#DETAIL}. <p> The title applied to the target pane is based on {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPaneTitleTemplate listPaneTitleTemplate} if the target pane is the
     * <code>listPane</code>, otherwise {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPaneTitleTemplate
     * detailPaneTitleTemplate}. <p> The source pane usually does not need to be specified: if the target pane is the
     * <code>detailPane</code>, the default source pane is the <code>listPane</code> if present, otherwise the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}.  If the target pane is the
     * <code>listPane</code>, the source pane is always the <code>navigationPane</code>.
     */
    public native void navigatePane() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "navigatePane", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.navigatePane();
    }-*/;

    /**
     * @see SplitPane#navigatePane
     */
    public void navigatePane(CurrentPane target){
        navigatePane(target, null, null);
    }

    /**
     * @see SplitPane#navigatePane
     */
    public void navigatePane(CurrentPane target, String title){
        navigatePane(target, title, null);
    }

	/**
     * Causes the target pane component to load data and update its title based on the current selection in the source pane.
     * <p> Both the source pane and target pane must have a {@link com.smartgwt.client.data.DataSource}, and either: <ul> <li>
     * the two DataSources must have a Many-To-One relationship declared via {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey DataSourceField.foreignKey}, so that {@link
     * com.smartgwt.client.widgets.grid.ListGrid#fetchRelatedData ListGrid.fetchRelatedData()} can be used on the target pane.
     * <li> the two DataSources must be the same, so that the record selected in the source pane can be displayed in the target
     * pane via simply calling {@link com.smartgwt.client.widgets.viewer.DetailViewer#setData setData()}. </ul> The default
     * <code>target</code> is  {@link com.smartgwt.client.types.CurrentPane#LIST} if the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} is present, otherwise  {@link
     * com.smartgwt.client.types.CurrentPane#DETAIL}. <p> The title applied to the target pane is based on {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPaneTitleTemplate listPaneTitleTemplate} if the target pane is the
     * <code>listPane</code>, otherwise {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPaneTitleTemplate
     * detailPaneTitleTemplate}. <p> The source pane usually does not need to be specified: if the target pane is the
     * <code>detailPane</code>, the default source pane is the <code>listPane</code> if present, otherwise the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}.  If the target pane is the
     * <code>listPane</code>, the source pane is always the <code>navigationPane</code>.
     * @param target pane that should navigate
     * @param title optional title to use for target pane. If not specified, the title is based on {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPaneTitleTemplate listPaneTitleTemplate} if the target pane is the
     * <code>listPane</code>, otherwise {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPaneTitleTemplate
     * detailPaneTitleTemplate}.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @param source source pane used for selection
     */
    public native void navigatePane(CurrentPane target, String title, CurrentPane source) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "navigatePane", "CurrentPane,String,CurrentPane");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.navigatePane(target == null ? null : target.@com.smartgwt.client.types.CurrentPane::getValue()(), title, source == null ? null : source.@com.smartgwt.client.types.CurrentPane::getValue()());
    }-*/;
	
    /**
     * Add a navigationClick handler.
     * <p>
     * Notification method fired when the user clicks the default back / forward buttons on the navigation bar for this
     * <code>SplitPane</code>. <P> Note that the return value will be ignored and cancelation won't be possible unless {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNotifyAfterNavigationClick SplitPane.notifyAfterNavigationClick} has
     * been set false so that the notification occurs <i>before</i> navigation.
     *
     * @param handler the navigationClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addNavigationClickHandler(com.smartgwt.client.widgets.layout.events.NavigationClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.NavigationClickEvent.getType()) == 0) setupNavigationClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.NavigationClickEvent.getType());
    }

    private native void setupNavigationClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var navigationClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.layout.events.NavigationClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.layout.SplitPane::handleTearDownNavigationClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("navigationClick"));
            obj.addProperties({navigationClick: 
                function () {
                    var param = {"_this": this, "direction" : arguments[0]};
                    var ret = navigationClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("navigationClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("navigationClick"));
            obj.navigationClick = 
                function () {
                    var param = {"_this": this, "direction" : arguments[0]};
                    var ret = navigationClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("navigationClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownNavigationClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.layout.events.NavigationClickEvent.getType()) == 0) tearDownNavigationClickEvent();
    }

    private native void tearDownNavigationClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("navigationClick")) delete obj.navigationClick;
    }-*/;

    /**
     * Add a paneChanged handler.
     * <p>
     * Notification fired when the {@link com.smartgwt.client.widgets.layout.SplitPane#getCurrentPane SplitPane.currentPane}
     * changes, either due to end-user action or due to a programmatic call to {@link
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var paneChanged = $entry(function(){
            var param = {"_this": this, "newPane" : arguments[0], "oldPane" : arguments[1], "navigationMethod" : arguments[2]};
            var event = @com.smartgwt.client.widgets.layout.events.PaneChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.layout.SplitPane::handleTearDownPaneChangedEvent()();
            if (hasDefaultHandler) this.Super("paneChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("paneChanged"));
            obj.addProperties({paneChanged:  paneChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("paneChanged"));
            obj.paneChanged =  paneChanged             ;
        }
    }-*/;

    private void handleTearDownPaneChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.layout.events.PaneChangedEvent.getType()) == 0) tearDownPaneChangedEvent();
    }

    private native void tearDownPaneChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("paneChanged")) delete obj.paneChanged;
    }-*/;

	/**
     * Setter for the {@link com.smartgwt.client.widgets.layout.NavigationBar#getLeftButtonTitle leftButtonTitle} of the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}.
     * @param newTitle new title for the left button.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.HTMLString HTMLString
     */
    public native void setLeftButtonTitle(String newTitle) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setLeftButtonTitle", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setLeftButtonTitle(newTitle);
    }-*/;

	/**
     * Setter for the {@link com.smartgwt.client.widgets.layout.NavigationBar#getRightButtonTitle rightButtonTitle} of the
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}.
     * @param newTitle new title for the right button.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.HTMLString HTMLString
     */
    public native void setRightButtonTitle(String newTitle) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setRightButtonTitle", "String");
        }
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
     * com.smartgwt.client.widgets.layout.SplitPane#getBackButton back button} will be updated with the current title of the
     * <code>navigationPane</code> or <code>listPane</code>, or the <code>backButtonTitle</code> passed to this method. When
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getAddHistoryEntries addHistoryEntries} is enabled and
     * <code>backButtonTitle</code> is passed, then <code>backButtonTitle</code> will be used for the back button title if the
     * user goes back to the <code>detailPane</code>.
     */
    public native void showDetailPane() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showDetailPane", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showDetailPane();
    }-*/;

    /**
     * @see SplitPane#showDetailPane
     */
    public void showDetailPane(String detailPaneTitle){
        showDetailPane(detailPaneTitle, null, null);
    }

    /**
     * @see SplitPane#showDetailPane
     */
    public void showDetailPane(String detailPaneTitle, String backButtonTitle){
        showDetailPane(detailPaneTitle, backButtonTitle, null);
    }

	/**
     * Causes a transition to the {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane}, optionally
     * updating the {@link com.smartgwt.client.widgets.layout.SplitPane#setDetailTitle detail title}. <p> If, based on the
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation}, this causes the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} or {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane} to be hidden, the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getBackButton back button} will be updated with the current title of the
     * <code>navigationPane</code> or <code>listPane</code>, or the <code>backButtonTitle</code> passed to this method. When
     * {@link com.smartgwt.client.widgets.layout.SplitPane#getAddHistoryEntries addHistoryEntries} is enabled and
     * <code>backButtonTitle</code> is passed, then <code>backButtonTitle</code> will be used for the back button title if the
     * user goes back to the <code>detailPane</code>.
     * @param detailPaneTitle optional new {@link com.smartgwt.client.widgets.layout.SplitPane#getDetailTitle detail title}.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @param backButtonTitle optional new title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getBackButton back button}.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @param direction when {@link com.smartgwt.client.widgets.layout.SplitPane#getAnimateNavigationBarStateChanges
     * animateNavigationBarStateChanges} is <code>true</code>, this is the direction passed to {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#setViewState NavigationBar.setViewState()}.
     */
    public native void showDetailPane(String detailPaneTitle, String backButtonTitle, NavigationDirection direction) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showDetailPane", "String,String,NavigationDirection");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showDetailPane(detailPaneTitle, backButtonTitle, direction == null ? null : direction.@com.smartgwt.client.types.NavigationDirection::getValue()());
    }-*/;
	
	/**
     * Causes a transition to the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}, optionally
     * updating the {@link com.smartgwt.client.widgets.layout.SplitPane#setListTitle list title}. <p> If, based on the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation}, this causes the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} to be hidden, the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getBackButton back button} will be updated with the current title of the
     * <code>navigationPane</code>, or the <code>backButtonTitle</code> passed to this method. When {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getAddHistoryEntries addHistoryEntries} is enabled and
     * <code>backButtonTitle</code> is passed, then <code>backButtonTitle</code> will be used for the back button title if the
     * user goes back to the <code>listPane</code>.
     */
    public native void showListPane() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showListPane", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showListPane();
    }-*/;

    /**
     * @see SplitPane#showListPane
     */
    public void showListPane(String listPaneTitle){
        showListPane(listPaneTitle, null, null);
    }

    /**
     * @see SplitPane#showListPane
     */
    public void showListPane(String listPaneTitle, String backButtonTitle){
        showListPane(listPaneTitle, backButtonTitle, null);
    }

	/**
     * Causes a transition to the {@link com.smartgwt.client.widgets.layout.SplitPane#getListPane listPane}, optionally
     * updating the {@link com.smartgwt.client.widgets.layout.SplitPane#setListTitle list title}. <p> If, based on the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode deviceMode} and {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getPageOrientation pageOrientation}, this causes the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane} to be hidden, the {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getBackButton back button} will be updated with the current title of the
     * <code>navigationPane</code>, or the <code>backButtonTitle</code> passed to this method. When {@link
     * com.smartgwt.client.widgets.layout.SplitPane#getAddHistoryEntries addHistoryEntries} is enabled and
     * <code>backButtonTitle</code> is passed, then <code>backButtonTitle</code> will be used for the back button title if the
     * user goes back to the <code>listPane</code>.
     * @param listPaneTitle optional new list title.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @param backButtonTitle optional new title for the {@link com.smartgwt.client.widgets.layout.SplitPane#getBackButton back button}.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @param direction when {@link com.smartgwt.client.widgets.layout.SplitPane#getAnimateNavigationBarStateChanges
     * animateNavigationBarStateChanges} is <code>true</code>, this is the direction passed to {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#setViewState NavigationBar.setViewState()}.
     */
    public native void showListPane(String listPaneTitle, String backButtonTitle, NavigationDirection direction) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showListPane", "String,String,NavigationDirection");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showListPane(listPaneTitle, backButtonTitle, direction == null ? null : direction.@com.smartgwt.client.types.NavigationDirection::getValue()());
    }-*/;
	
	/**
     * Causes a transition to the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}.
     */
    public native void showNavigationPane() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showNavigationPane", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showNavigationPane();
    }-*/;

	/**
     * Causes a transition to the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane navigationPane}.
     * @param direction when {@link com.smartgwt.client.widgets.layout.SplitPane#getAnimateNavigationBarStateChanges
     * animateNavigationBarStateChanges} is <code>true</code>, this is the direction passed to {@link
     * com.smartgwt.client.widgets.layout.NavigationBar#setViewState NavigationBar.setViewState()}.
     */
    public native void showNavigationPane(NavigationDirection direction) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showNavigationPane", "NavigationDirection");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showNavigationPane(direction == null ? null : direction.@com.smartgwt.client.types.NavigationDirection::getValue()());
    }-*/;
	
    /**
     * Add a upClick handler.
     * <p>
     * Notification method fired when the {@link com.smartgwt.client.widgets.layout.SplitPane#getShowMiniNav miniNav is
     * showing} and the up button on the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationBar navigationBar}'s
     * {@link com.smartgwt.client.widgets.MiniNavControl} is clicked.
     *
     * @param handler the upClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addUpClickHandler(com.smartgwt.client.widgets.layout.events.UpClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.layout.events.UpClickEvent.getType()) == 0) setupUpClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.layout.events.UpClickEvent.getType());
    }

    private native void setupUpClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var upClick = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.layout.events.UpClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.layout.SplitPane::handleTearDownUpClickEvent()();
            if (hasDefaultHandler) this.Super("upClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("upClick"));
            obj.addProperties({upClick:  upClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("upClick"));
            obj.upClick =  upClick             ;
        }
    }-*/;

    private void handleTearDownUpClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.layout.events.UpClickEvent.getType()) == 0) tearDownUpClickEvent();
    }

    private native void tearDownUpClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("upClick")) delete obj.upClick;
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
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(SplitPane splitPaneProperties) /*-{
        if (splitPaneProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(SplitPane.@java.lang.Object::getClass()(), "setDefaultProperties", splitPaneProperties.@java.lang.Object::getClass()());
        }
        splitPaneProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = splitPaneProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.SplitPane.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(SplitPaneLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.addHistoryEntries = getAttributeAsString("addHistoryEntries");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.addHistoryEntries:" + t.getMessage() + "\n";
        }
        try {
            s.animateNavigationBarStateChanges = getAttributeAsString("animateNavigationBarStateChanges");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.animateNavigationBarStateChanges:" + t.getMessage() + "\n";
        }
        try {
            s.autoNavigate = getAttributeAsString("autoNavigate");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.autoNavigate:" + t.getMessage() + "\n";
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
            s.detailPaneTitleTemplate = getAttributeAsString("detailPaneTitleTemplate");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.detailPaneTitleTemplate:" + t.getMessage() + "\n";
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
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.listPane = getListPane();
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.listPane:" + t.getMessage() + "\n";
        }
        try {
            s.listPaneTitleTemplate = getAttributeAsString("listPaneTitleTemplate");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.listPaneTitleTemplate:" + t.getMessage() + "\n";
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
            s.navigationPaneWidth = getAttributeAsString("navigationPaneWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.navigationPaneWidth:" + t.getMessage() + "\n";
        }
        try {
            s.navigationTitle = getAttributeAsString("navigationTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.navigationTitle:" + t.getMessage() + "\n";
        }
        try {
            s.notifyAfterNavigationClick = getAttributeAsString("notifyAfterNavigationClick");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.notifyAfterNavigationClick:" + t.getMessage() + "\n";
        }
        try {
            s.pageOrientation = getAttributeAsString("pageOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.pageOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.showDetailToolStrip = getAttributeAsString("showDetailToolStrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.showDetailToolStrip:" + t.getMessage() + "\n";
        }
        try {
            s.showLeftButton = getAttributeAsString("showLeftButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.showLeftButton:" + t.getMessage() + "\n";
        }
        try {
            s.showListToolStrip = getAttributeAsString("showListToolStrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.showListToolStrip:" + t.getMessage() + "\n";
        }
        try {
            s.showMiniNav = getAttributeAsString("showMiniNav");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.showMiniNav:" + t.getMessage() + "\n";
        }
        try {
            s.showNavigationBar = getAttributeAsString("showNavigationBar");
        } catch (Throwable t) {
            s.logicalStructureErrors += "SplitPane.showNavigationBar:" + t.getMessage() + "\n";
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

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        SplitPaneLogicalStructure s = new SplitPaneLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
