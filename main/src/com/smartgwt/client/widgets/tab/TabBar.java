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
 
package com.smartgwt.client.widgets.tab;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process

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
 * Shows a set of Tabs.  TabBars are automatically created by TabSets and shouldn't be used directly.  The TabBar is
 * documented for skinning purposes.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TabBar")
public class TabBar extends Toolbar {

    public static TabBar getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new TabBar(jsObj);
        } else {
            assert refInstance instanceof TabBar;
            return (TabBar)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TabBar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.TabBar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TabBar.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.TabBar.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public TabBar(){
        scClassName = "TabBar";
    }

    public TabBar(JavaScriptObject jsObj){
        scClassName = "TabBar";
        setJavaScriptObject(jsObj);
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
     * Set {@link com.smartgwt.client.widgets.StretchImg#getCapSize StretchImg.capSize} for the {@link
     * com.smartgwt.client.docs.BaseLine} stretchImg.
     *
     * @param baseLineCapSize New baseLineCapSize value. Default value is 2
     * @return {@link com.smartgwt.client.widgets.tab.TabBar TabBar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.BaseLine BaseLine overview and related methods
     */
    public TabBar setBaseLineCapSize(int baseLineCapSize)  throws IllegalStateException {
        return (TabBar)setAttribute("baseLineCapSize", baseLineCapSize, false);
    }

    /**
     * Set {@link com.smartgwt.client.widgets.StretchImg#getCapSize StretchImg.capSize} for the {@link
     * com.smartgwt.client.docs.BaseLine} stretchImg.
     *
     * @return Current baseLineCapSize value. Default value is 2
     * @see com.smartgwt.client.docs.BaseLine BaseLine overview and related methods
     */
    public int getBaseLineCapSize()  {
        return getAttributeAsInt("baseLineCapSize");
    }
    

    /**
     * Sets {@link com.smartgwt.client.widgets.StretchImg#getSrc StretchImg.src} for the {@link
     * com.smartgwt.client.docs.BaseLine} StretchImg.
     *
     * @param baseLineSrc New baseLineSrc value. Default value is "[SKIN]baseline.gif"
     * @return {@link com.smartgwt.client.widgets.tab.TabBar TabBar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.BaseLine BaseLine overview and related methods
     */
    public TabBar setBaseLineSrc(String baseLineSrc)  throws IllegalStateException {
        return (TabBar)setAttribute("baseLineSrc", baseLineSrc, false);
    }

    /**
     * Sets {@link com.smartgwt.client.widgets.StretchImg#getSrc StretchImg.src} for the {@link
     * com.smartgwt.client.docs.BaseLine} StretchImg.
     *
     * @return Current baseLineSrc value. Default value is "[SKIN]baseline.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.BaseLine BaseLine overview and related methods
     */
    public String getBaseLineSrc()  {
        return getAttributeAsString("baseLineSrc");
    }
    

    /**
     * Thickness of the baseLine, in pixels.  This should be set to match the media specified by {@link
     * com.smartgwt.client.widgets.tab.TabBar#getBaseLineSrc baseLineSrc}.  The baseLineThickness also determines the degree of
     * overlap with the TabSet's paneContainer when using decorative edges - see {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPaneContainer TabSet.paneContainer} for details.
     *
     * @param baseLineThickness New baseLineThickness value. Default value is 1
     * @return {@link com.smartgwt.client.widgets.tab.TabBar TabBar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.BaseLine BaseLine overview and related methods
     */
    public TabBar setBaseLineThickness(int baseLineThickness)  throws IllegalStateException {
        return (TabBar)setAttribute("baseLineThickness", baseLineThickness, false);
    }

    /**
     * Thickness of the baseLine, in pixels.  This should be set to match the media specified by {@link
     * com.smartgwt.client.widgets.tab.TabBar#getBaseLineSrc baseLineSrc}.  The baseLineThickness also determines the degree of
     * overlap with the TabSet's paneContainer when using decorative edges - see {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPaneContainer TabSet.paneContainer} for details.
     *
     * @return Current baseLineThickness value. Default value is 1
     * @see com.smartgwt.client.docs.BaseLine BaseLine overview and related methods
     */
    public int getBaseLineThickness()  {
        return getAttributeAsInt("baseLineThickness");
    }
    

    /**
     * Breadth of the tabBar (including baseline breadth)
     *
     * @param breadth New breadth value. Default value is 21
     * @return {@link com.smartgwt.client.widgets.tab.TabBar TabBar} instance, for chaining setter calls
     */
    public TabBar setBreadth(int breadth) {
        return (TabBar)setAttribute("breadth", breadth, true);
    }

    /**
     * Breadth of the tabBar (including baseline breadth)
     *
     * @return Current breadth value. Default value is 21
     */
    public int getBreadth()  {
        return getAttributeAsInt("breadth");
    }
    
    

    /**
     * An array of shortcut keyboard commands which will close the currently selected tab, if
     *  the currently selected tab is closeable. Either this <code>TabBar</code> or the currently
     *  selected tab must have keyboard focus.
     *  <p>
     *  By default, this is an array of two <code>KeyIdentifier</code>s: <code>Alt+Delete</code>,
     *  which is the keyboard command recommended by
     *  <a href='http://www.w3.org/WAI/PF/aria-practices/#tabpanel' target='_blank'>WAI-ARIA Authoring Practices</a>
     *  and
     * <a href='http://access.aol.com/dhtml-style-guide-working-group/#tabpanel' target='_blank'>DHTML Style Guide Working
     * Group</a>,
     *  and <code>Ctrl+W</code>.
     *  Notes:
     *  <ul>
     *  <li>On Mac, the <code>Alt+Delete</code> keyboard command is accomplished via
     *  <code>Fn-Option-Delete</code>.
     *  <li><code>Alt+Delete</code> is a
     * <a href='http://doccenter.freedomscientific.com/doccenter/archives/training/jawskeystrokes.htm' target='_blank'>JAWS
     * Keystroke</a>
     *  to "Say Active Cursor". If using JAWS, pressing <code>Alt+Shift+Delete</code> will close
     *  the tab.
     *  <li>In Chrome, Firefox, and Internet Explorer on Windows, <code>Ctrl+W</code> will also
     *  close the browser tab/window if focus is not within a <code>TabBar</code>.
     *  If <code>Ctrl+W</code> will be used frequently by the application's users, it may be useful to
     *  
     *  
     *  {@link com.smartgwt.client.util.Page#registerKey(KeyIdentifier, PageKeyHandler) register this key}
     *  to cancel it by default:
     *  <pre>final KeyIdentifier ctrlWKey = new KeyIdentifier();
     * ctrlWKey.setCtrlKey(true);
     * ctrlWKey.setKeyName("W");
     * Page.registerKey(ctrlWKey, new PageKeyHandler() {
     *     &#64;Override
     *     public void execute(String keyName) {
     *         cancel();
     *     }
     * });</pre>
     *  
     *  </ul>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param closeTabKeys New closeTabKeys value. Default value is see below
     * @return {@link com.smartgwt.client.widgets.tab.TabBar TabBar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TabBar setCloseTabKeys(KeyIdentifier... closeTabKeys)  throws IllegalStateException {
        return (TabBar)setAttribute("closeTabKeys", closeTabKeys, false);
    }

    /**
     * An array of shortcut keyboard commands which will close the currently selected tab, if
     *  the currently selected tab is closeable. Either this <code>TabBar</code> or the currently
     *  selected tab must have keyboard focus.
     *  <p>
     *  By default, this is an array of two <code>KeyIdentifier</code>s: <code>Alt+Delete</code>,
     *  which is the keyboard command recommended by
     *  <a href='http://www.w3.org/WAI/PF/aria-practices/#tabpanel' target='_blank'>WAI-ARIA Authoring Practices</a>
     *  and
     * <a href='http://access.aol.com/dhtml-style-guide-working-group/#tabpanel' target='_blank'>DHTML Style Guide Working
     * Group</a>,
     *  and <code>Ctrl+W</code>.
     *  Notes:
     *  <ul>
     *  <li>On Mac, the <code>Alt+Delete</code> keyboard command is accomplished via
     *  <code>Fn-Option-Delete</code>.
     *  <li><code>Alt+Delete</code> is a
     * <a href='http://doccenter.freedomscientific.com/doccenter/archives/training/jawskeystrokes.htm' target='_blank'>JAWS
     * Keystroke</a>
     *  to "Say Active Cursor". If using JAWS, pressing <code>Alt+Shift+Delete</code> will close
     *  the tab.
     *  <li>In Chrome, Firefox, and Internet Explorer on Windows, <code>Ctrl+W</code> will also
     *  close the browser tab/window if focus is not within a <code>TabBar</code>.
     *  If <code>Ctrl+W</code> will be used frequently by the application's users, it may be useful to
     *  
     *  
     *  {@link com.smartgwt.client.util.Page#registerKey(KeyIdentifier, PageKeyHandler) register this key}
     *  to cancel it by default:
     *  <pre>final KeyIdentifier ctrlWKey = new KeyIdentifier();
     * ctrlWKey.setCtrlKey(true);
     * ctrlWKey.setKeyName("W");
     * Page.registerKey(ctrlWKey, new PageKeyHandler() {
     *     &#64;Override
     *     public void execute(String keyName) {
     *         cancel();
     *     }
     * });</pre>
     *  
     *  </ul>
     *
     * @return Current closeTabKeys value. Default value is see below
     */
    public KeyIdentifier[] getCloseTabKeys()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfKeyIdentifier(getAttributeAsJavaScriptObject("closeTabKeys"));
    }
    

    /**
     * Default size (length) in pixels for tabs within this tabBar
     *
     * @param defaultTabSize New defaultTabSize value. Default value is 80
     * @return {@link com.smartgwt.client.widgets.tab.TabBar TabBar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TabBar setDefaultTabSize(int defaultTabSize)  throws IllegalStateException {
        return (TabBar)setAttribute("defaultTabSize", defaultTabSize, false);
    }

    /**
     * Default size (length) in pixels for tabs within this tabBar
     *
     * @return Current defaultTabSize value. Default value is 80
     */
    public int getDefaultTabSize()  {
        return getAttributeAsInt("defaultTabSize");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "TabBarEditProxy"
     * @return {@link com.smartgwt.client.widgets.tab.TabBar TabBar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public TabBar setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (TabBar)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "TabBarEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Tab to show as the "more" tab when {@link com.smartgwt.client.widgets.tab.TabBar#getShowMoreTab showMoreTab} is enabled
     * and the number of tabs to show exceeds {@link com.smartgwt.client.widgets.tab.TabBar#getMoreTabCount moreTabCount}.
     *
     * @param moreTab New moreTab value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tab.TabBar TabBar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TabBar setMoreTab(Tab moreTab)  throws IllegalStateException {
        return (TabBar)setAttribute("moreTab", moreTab == null ? null : moreTab.getJsObj(), false);
    }

    /**
     * Tab to show as the "more" tab when {@link com.smartgwt.client.widgets.tab.TabBar#getShowMoreTab showMoreTab} is enabled
     * and the number of tabs to show exceeds {@link com.smartgwt.client.widgets.tab.TabBar#getMoreTabCount moreTabCount}.
     *
     * @return Current moreTab value. Default value is null
     */
    public Tab getMoreTab()  {
        return Tab.getOrCreateRef(getAttributeAsJavaScriptObject("moreTab"));
    }
    

    /**
     * This property defines the number tab buttons that should be shown before automatically adding a "more" button to handle
     * the remaining tabs. This property is only used when {@link com.smartgwt.client.widgets.tab.TabBar#getShowMoreTab
     * showMoreTab} is enabled.
     *
     * @param moreTabCount New moreTabCount value. Default value is 5
     * @return {@link com.smartgwt.client.widgets.tab.TabBar TabBar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TabBar setMoreTabCount(int moreTabCount)  throws IllegalStateException {
        return (TabBar)setAttribute("moreTabCount", moreTabCount, false);
    }

    /**
     * This property defines the number tab buttons that should be shown before automatically adding a "more" button to handle
     * the remaining tabs. This property is only used when {@link com.smartgwt.client.widgets.tab.TabBar#getShowMoreTab
     * showMoreTab} is enabled.
     *
     * @return Current moreTabCount value. Default value is 5
     */
    public int getMoreTabCount()  {
        return getAttributeAsInt("moreTabCount");
    }
    

    /**
     * Should tabs exceeding {@link com.smartgwt.client.widgets.tab.TabBar#getMoreTabCount moreTabCount} be shown on a "more"
     * tab? <p> This setting is used to emulate an iPhone-style tab bar "more" button.
     *
     * @param showMoreTab New showMoreTab value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tab.TabBar TabBar} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TabBar setShowMoreTab(Boolean showMoreTab)  throws IllegalStateException {
        return (TabBar)setAttribute("showMoreTab", showMoreTab, false);
    }

    /**
     * Should tabs exceeding {@link com.smartgwt.client.widgets.tab.TabBar#getMoreTabCount moreTabCount} be shown on a "more"
     * tab? <p> This setting is used to emulate an iPhone-style tab bar "more" button.
     *
     * @return Current showMoreTab value. Default value is null
     */
    public Boolean getShowMoreTab()  {
        return getAttributeAsBoolean("showMoreTab");
    }
    
    

    // ********************* Methods ***********************
	/**
     * Select a tab
     * @param tabNum index of tab to select
     */
    public native void selectTab(int tabNum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "selectTab", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectTab(tabNum);
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
     * @param tabBarProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(TabBar tabBarProperties) /*-{
        if (tabBarProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(TabBar.@java.lang.Object::getClass()(), "setDefaultProperties", tabBarProperties.@java.lang.Object::getClass()());
        }
        tabBarProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = tabBarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.TabBar.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(TabBarLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.baseLineCapSize = getAttributeAsString("baseLineCapSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.baseLineCapSize:" + t.getMessage() + "\n";
        }
        try {
            s.baseLineSrc = getAttributeAsString("baseLineSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.baseLineSrc:" + t.getMessage() + "\n";
        }
        try {
            s.baseLineThickness = getAttributeAsString("baseLineThickness");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.baseLineThickness:" + t.getMessage() + "\n";
        }
        try {
            s.breadth = getAttributeAsString("breadth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.breadth:" + t.getMessage() + "\n";
        }
        try {
            s.closeTabKeys = getCloseTabKeys();
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.closeTabKeysArray:" + t.getMessage() + "\n";
        }
        try {
            s.defaultTabSize = getAttributeAsString("defaultTabSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.defaultTabSize:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.moreTab = getMoreTab();
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.moreTab:" + t.getMessage() + "\n";
        }
        try {
            s.moreTabCount = getAttributeAsString("moreTabCount");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.moreTabCount:" + t.getMessage() + "\n";
        }
        try {
            s.showMoreTab = getAttributeAsString("showMoreTab");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabBar.showMoreTab:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        TabBarLogicalStructure s = new TabBarLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
