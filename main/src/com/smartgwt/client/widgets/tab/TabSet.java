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
 * The TabSet class allows components on several panes to share the same space. The tabs at  the top can be selected by the
 * user to show each pane.  <P> Tabs are configured via the <code>tabs</code> property, each of which has a
 * <code>pane</code> property which will be displayed in the main pane when that tab is selected.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TabSet")
public class TabSet extends Canvas implements com.smartgwt.client.widgets.tab.events.HasAddTabClickedHandlers, com.smartgwt.client.widgets.tab.events.HasCloseClickHandlers, com.smartgwt.client.widgets.tab.events.HasTabContextMenuHandlers, com.smartgwt.client.widgets.tab.events.HasTabDeselectedHandlers, com.smartgwt.client.widgets.tab.events.HasTabIconClickHandlers, com.smartgwt.client.widgets.tab.events.HasTabSelectedHandlers, com.smartgwt.client.widgets.tab.events.HasTabsReorderedHandlers, com.smartgwt.client.widgets.tab.events.HasTabTitleChangedHandlers {

    public static TabSet getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new TabSet(jsObj);
        } else {
            assert refInstance instanceof TabSet;
            return (TabSet)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TabSet.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.TabSet.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TabSet.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.TabSet.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public TabSet(){
        scClassName = "TabSet";
    }

    public TabSet(JavaScriptObject jsObj){
        scClassName = "TabSet";
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
     * Appears when {@link com.smartgwt.client.widgets.tab.TabSet#getCanAddTabs canAddTabs} is enabled.
     * <p>
     * This component is an AutoChild named "addTabButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current addTabButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getAddTabButton() throws IllegalStateException {
        errorIfNotCreated("addTabButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("addTabButton"));
    }
    

    /**
     * Icon for the {@link com.smartgwt.client.widgets.tab.TabSet#getAddTabButton addTabButton}.
     *
     * @param addTabButtonIcon New addTabButtonIcon value. Default value is "[SKIN]actions/add.png"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setAddTabButtonIcon(String addTabButtonIcon)  throws IllegalStateException {
        setAttribute("addTabButtonIcon", addTabButtonIcon, false);
    }

    /**
     * Icon for the {@link com.smartgwt.client.widgets.tab.TabSet#getAddTabButton addTabButton}.
     *
     * @return Current addTabButtonIcon value. Default value is "[SKIN]actions/add.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getAddTabButtonIcon()  {
        return getAttributeAsString("addTabButtonIcon");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller showTabScroller} is true, should tabs be scrolled
     * into view via an  animation when the user interacts with the scroller buttons?
     *
     * @param animateTabScrolling New animateTabScrolling value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAnimateTabScrolling(Boolean animateTabScrolling)  throws IllegalStateException {
        setAttribute("animateTabScrolling", animateTabScrolling, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller showTabScroller} is true, should tabs be scrolled
     * into view via an  animation when the user interacts with the scroller buttons?
     *
     * @return Current animateTabScrolling value. Default value is true
     */
    public Boolean getAnimateTabScrolling()  {
        Boolean result = getAttributeAsBoolean("animateTabScrolling");
        return result == null ? true : result;
    }
    

    /**
     * When {@link com.smartgwt.client.util.isc#setScreenReaderMode screen reader mode} is enabled and a tab is {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs closeable}, the <code>ariaCloseableSuffix</code> is a string that
     * is appended to the label of closeable tabs. This suffix is hidden from sighted users, but is announced by screen readers
     * to indicate that the tab may be closed. <p> Set to <code>null</code> to disable appending this suffix.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param ariaCloseableSuffix New ariaCloseableSuffix value. Default value is ", closeable"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAriaCloseableSuffix(String ariaCloseableSuffix)  throws IllegalStateException {
        setAttribute("ariaCloseableSuffix", ariaCloseableSuffix, false);
    }

    /**
     * When {@link com.smartgwt.client.util.isc#setScreenReaderMode screen reader mode} is enabled and a tab is {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs closeable}, the <code>ariaCloseableSuffix</code> is a string that
     * is appended to the label of closeable tabs. This suffix is hidden from sighted users, but is announced by screen readers
     * to indicate that the tab may be closed. <p> Set to <code>null</code> to disable appending this suffix.
     *
     * @return Current ariaCloseableSuffix value. Default value is ", closeable"
     */
    public String getAriaCloseableSuffix()  {
        return getAttributeAsString("ariaCloseableSuffix");
    }
    
    
    

    /**
     * Causes the {@link com.smartgwt.client.widgets.tab.TabSet#getAddTabButton addTabButton} to appear after the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabs tabs} and before the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarControls tabBarControls}.   <p> There is no default behavior for what
     * happens when the <code>addTabButton</code> is clicked.  Add a handler for the {@link
     * com.smartgwt.client.widgets.tab.TabSet#addAddTabClickedHandler TabSet.addTabClicked()} event to implement a behavior.
     *
     * @param canAddTabs New canAddTabs value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCanAddTabs(Boolean canAddTabs)  throws IllegalStateException {
        setAttribute("canAddTabs", canAddTabs, false);
    }

    /**
     * Causes the {@link com.smartgwt.client.widgets.tab.TabSet#getAddTabButton addTabButton} to appear after the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabs tabs} and before the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarControls tabBarControls}.   <p> There is no default behavior for what
     * happens when the <code>addTabButton</code> is clicked.  Add a handler for the {@link
     * com.smartgwt.client.widgets.tab.TabSet#addAddTabClickedHandler TabSet.addTabClicked()} event to implement a behavior.
     *
     * @return Current canAddTabs value. Default value is null
     */
    public Boolean getCanAddTabs()  {
        return getAttributeAsBoolean("canAddTabs");
    }
    

    /**
     * Should tabs in this tabSet show an icon allowing the user to dismiss the tab by
     *  clicking on it directly. May be overridden for individual tabs by setting 
     *  {@link com.smartgwt.client.widgets.tab.Tab#getCanClose Tab.canClose}.
     *  <P>
     * The URL for this icon's image will be derived from  {@link com.smartgwt.client.widgets.tab.TabSet#getCloseTabIcon
     * closeTabIcon} by 
     * default, but may be overridden by explicitly specifying {@link com.smartgwt.client.widgets.tab.Tab#getCloseIcon
     * Tab.closeIcon}.
     *  <P>
     *  <b>Note</b>: Currently, tabs can only show a single icon, so a closable tab will show
     * the close icon only even if {@link com.smartgwt.client.widgets.tab.Tab#getIcon Tab.icon} is set.  To work around this,
     * add the icon
     *  as an HTML &lt;img&gt; tag to the {@link com.smartgwt.client.widgets.tab.Tab#getTitle Tab.title} property, for example:
     *  
     *  
     *  <pre>
     *     tab.setTitle("&lt;span&gt;" + Canvas.imgHTML("path/to/icon.png") + " Tab Title&lt;/span&gt;");
     *  </pre>
     * 
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes this TabSet's {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs} property.
     *
     * @param canCloseTabs the new value for canCloseTabs. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#closeClick
     */
    public void setCanCloseTabs(Boolean canCloseTabs) {
        setAttribute("canCloseTabs", canCloseTabs, true);
    }

    /**
     * Should tabs in this tabSet show an icon allowing the user to dismiss the tab by
     *  clicking on it directly. May be overridden for individual tabs by setting 
     *  {@link com.smartgwt.client.widgets.tab.Tab#getCanClose Tab.canClose}.
     *  <P>
     * The URL for this icon's image will be derived from  {@link com.smartgwt.client.widgets.tab.TabSet#getCloseTabIcon
     * closeTabIcon} by 
     * default, but may be overridden by explicitly specifying {@link com.smartgwt.client.widgets.tab.Tab#getCloseIcon
     * Tab.closeIcon}.
     *  <P>
     *  <b>Note</b>: Currently, tabs can only show a single icon, so a closable tab will show
     * the close icon only even if {@link com.smartgwt.client.widgets.tab.Tab#getIcon Tab.icon} is set.  To work around this,
     * add the icon
     *  as an HTML &lt;img&gt; tag to the {@link com.smartgwt.client.widgets.tab.Tab#getTitle Tab.title} property, for example:
     *  
     *  
     *  <pre>
     *     tab.setTitle("&lt;span&gt;" + Canvas.imgHTML("path/to/icon.png") + " Tab Title&lt;/span&gt;");
     *  </pre>
     * 
     *
     * @return Current canCloseTabs value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#closeClick
     */
    public Boolean getCanCloseTabs()  {
        return getAttributeAsBoolean("canCloseTabs");
    }
    

    /**
     * If true, users can edit the titles of tabs in this TabSet when the  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTitleEditEvent titleEditEvent} fires.  You can override this behavior per tab 
     * with the {@link com.smartgwt.client.widgets.tab.Tab#getCanEditTitle Tab.canEditTitle} property. <p> Note that this
     * TabSet's {@link com.smartgwt.client.widgets.tab.TabSet#getTitleEditEvent titleEditEvent} must be set to a supported
     * {@link com.smartgwt.client.types.TabTitleEditEvent} in order for users to be able to edit the titles of tabs.
     *
     * @param canEditTabTitles New canEditTabTitles value. Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_title_editable" target="examples">User-Editable Titles Example</a>
     */
    public void setCanEditTabTitles(Boolean canEditTabTitles) {
        setAttribute("canEditTabTitles", canEditTabTitles, true);
    }

    /**
     * If true, users can edit the titles of tabs in this TabSet when the  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTitleEditEvent titleEditEvent} fires.  You can override this behavior per tab 
     * with the {@link com.smartgwt.client.widgets.tab.Tab#getCanEditTitle Tab.canEditTitle} property. <p> Note that this
     * TabSet's {@link com.smartgwt.client.widgets.tab.TabSet#getTitleEditEvent titleEditEvent} must be set to a supported
     * {@link com.smartgwt.client.types.TabTitleEditEvent} in order for users to be able to edit the titles of tabs.
     *
     * @return Current canEditTabTitles value. Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_title_editable" target="examples">User-Editable Titles Example</a>
     */
    public Boolean getCanEditTabTitles()  {
        Boolean result = getAttributeAsBoolean("canEditTabTitles");
        return result == null ? false : result;
    }
    

    /**
     * If true, tabs can be reordered by dragging on them. <P> To disallow drag-reorder of a specific tab, see {@link
     * com.smartgwt.client.widgets.tab.Tab#getCanReorder Tab.canReorder}.
     *
     * @param canReorderTabs New canReorderTabs value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public void setCanReorderTabs(Boolean canReorderTabs)  throws IllegalStateException {
        setAttribute("canReorderTabs", canReorderTabs, false);
    }

    /**
     * If true, tabs can be reordered by dragging on them. <P> To disallow drag-reorder of a specific tab, see {@link
     * com.smartgwt.client.widgets.tab.Tab#getCanReorder Tab.canReorder}.
     *
     * @return Current canReorderTabs value. Default value is null
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public Boolean getCanReorderTabs()  {
        return getAttributeAsBoolean("canReorderTabs");
    }
    

    /**
     * Default src for the close icon for tabs to display if {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs
     * canCloseTabs} is true.
     *
     * @param closeTabIcon New closeTabIcon value. Default value is [SKIN]/TabSet/close.png
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setCloseTabIcon(String closeTabIcon)  throws IllegalStateException {
        setAttribute("closeTabIcon", closeTabIcon, false);
    }

    /**
     * Default src for the close icon for tabs to display if {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs
     * canCloseTabs} is true.
     *
     * @return Current closeTabIcon value. Default value is [SKIN]/TabSet/close.png
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getCloseTabIcon()  {
        return getAttributeAsString("closeTabIcon");
    }
    

    /**
     * Size in pixels of the icon for closing tabs, displayed when {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs} is true.
     *
     * @param closeTabIconSize New closeTabIconSize value. Default value is 16
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCloseTabIconSize(int closeTabIconSize)  throws IllegalStateException {
        setAttribute("closeTabIconSize", closeTabIconSize, false);
    }

    /**
     * Size in pixels of the icon for closing tabs, displayed when {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs} is true.
     *
     * @return Current closeTabIconSize value. Default value is 16
     */
    public int getCloseTabIconSize()  {
        return getAttributeAsInt("closeTabIconSize");
    }
    

    /**
     * If set, is passed as "height" to all tabs when {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition
     * tabBarPosition} is set to  <code>"left"</code> or <code>"right"</code>.  <P> If unset, height will be picked up from the
     * Tab constructor class defaults. Note that tabs expand to fit their content so this height acts as a minimum. May be
     * customized by individual {@link com.smartgwt.client.docs.Skinning skins}.
     *
     * @param defaultTabHeight New defaultTabHeight value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDefaultTabHeight(Integer defaultTabHeight)  throws IllegalStateException {
        setAttribute("defaultTabHeight", defaultTabHeight, false);
    }

    /**
     * If set, is passed as "height" to all tabs when {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition
     * tabBarPosition} is set to  <code>"left"</code> or <code>"right"</code>.  <P> If unset, height will be picked up from the
     * Tab constructor class defaults. Note that tabs expand to fit their content so this height acts as a minimum. May be
     * customized by individual {@link com.smartgwt.client.docs.Skinning skins}.
     *
     * @return Current defaultTabHeight value. Default value is null
     */
    public Integer getDefaultTabHeight()  {
        return getAttributeAsInt("defaultTabHeight");
    }
    

    /**
     * If set, is passed as "width" to all tabs when {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition
     * tabBarPosition} is set to  <code>"top"</code> or <code>"bottom"</code>. <P> If unset, width will be picked up from the
     * Tab constructor class defaults. Tabs expand to fit their content, so  this width acts as a minimum. Setting width:1 will
     * result in tabs that are only as wide as their titles. May be customized by individual {@link
     * com.smartgwt.client.docs.Skinning skins}.
     *
     * @param defaultTabWidth New defaultTabWidth value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDefaultTabWidth(Integer defaultTabWidth)  throws IllegalStateException {
        setAttribute("defaultTabWidth", defaultTabWidth, false);
    }

    /**
     * If set, is passed as "width" to all tabs when {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition
     * tabBarPosition} is set to  <code>"top"</code> or <code>"bottom"</code>. <P> If unset, width will be picked up from the
     * Tab constructor class defaults. Tabs expand to fit their content, so  this width acts as a minimum. Setting width:1 will
     * result in tabs that are only as wide as their titles. May be customized by individual {@link
     * com.smartgwt.client.docs.Skinning skins}.
     *
     * @return Current defaultTabWidth value. Default value is null
     */
    public Integer getDefaultTabWidth()  {
        return getAttributeAsInt("defaultTabWidth");
    }
    

    /**
     * Whether {@link com.smartgwt.client.widgets.Canvas#destroy destroy()} should be called on {@link
     * com.smartgwt.client.widgets.tab.Tab#getPane Tab.pane} when it a tab is removed via {@link
     * com.smartgwt.client.widgets.tab.TabSet#removeTab removeTab()}.   <P> With the default setting of <code>null</code> panes
     * will be automatically destroyed. An application might set this to false in order to re-use panes in different tabs or in
     * different parts of the application.
     *
     * @param destroyPanes New destroyPanes value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDestroyPanes(Boolean destroyPanes)  throws IllegalStateException {
        setAttribute("destroyPanes", destroyPanes, false);
    }

    /**
     * Whether {@link com.smartgwt.client.widgets.Canvas#destroy destroy()} should be called on {@link
     * com.smartgwt.client.widgets.tab.Tab#getPane Tab.pane} when it a tab is removed via {@link
     * com.smartgwt.client.widgets.tab.TabSet#removeTab removeTab()}.   <P> With the default setting of <code>null</code> panes
     * will be automatically destroyed. An application might set this to false in order to re-use panes in different tabs or in
     * different parts of the application.
     *
     * @return Current destroyPanes value. Default value is null
     */
    public Boolean getDestroyPanes()  {
        return getAttributeAsBoolean("destroyPanes");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "TabSetEditProxy"
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
     * @return Current editProxyConstructor value. Default value is "TabSetEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    
    
    

    /**
     * When {@link com.smartgwt.client.util.AutoTest#getElement AutoTest.getElement()} is used to parse locator strings
     * generated by {@link com.smartgwt.client.util.AutoTest#getLocator AutoTest.getLocator()}, how should tabs within this
     * tabset be identified? If the locator has a specified {@link com.smartgwt.client.widgets.tab.Tab#getID Tab.ID} or {@link
     * com.smartgwt.client.widgets.tab.Tab#getName Tab.name}, no fallback approach will be used as those attributes (with
     * {@link com.smartgwt.client.widgets.tab.Tab#getID Tab.ID} having priority) are each alone considered to definitively
     * locate it. <P> Otherwise, the following options are available: <ul> <li><code>"title"</code> use the title as an
     * identifier</li> <li><code>"index"</code> use the index of the tab in the tabset as an identifier</li> </ul><p> If unset,
     * and the locator has no specified ID or name, default behavior is to identify by title (if available), otherwise by
     * index.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param locateTabsBy New locateTabsBy value. Default value is null
     * @see com.smartgwt.client.types.LocatorStrategy
     */
    public void setLocateTabsBy(String locateTabsBy) {
        setAttribute("locateTabsBy", locateTabsBy, true);
    }

    /**
     * When {@link com.smartgwt.client.util.AutoTest#getElement AutoTest.getElement()} is used to parse locator strings
     * generated by {@link com.smartgwt.client.util.AutoTest#getLocator AutoTest.getLocator()}, how should tabs within this
     * tabset be identified? If the locator has a specified {@link com.smartgwt.client.widgets.tab.Tab#getID Tab.ID} or {@link
     * com.smartgwt.client.widgets.tab.Tab#getName Tab.name}, no fallback approach will be used as those attributes (with
     * {@link com.smartgwt.client.widgets.tab.Tab#getID Tab.ID} having priority) are each alone considered to definitively
     * locate it. <P> Otherwise, the following options are available: <ul> <li><code>"title"</code> use the title as an
     * identifier</li> <li><code>"index"</code> use the index of the tab in the tabset as an identifier</li> </ul><p> If unset,
     * and the locator has no specified ID or name, default behavior is to identify by title (if available), otherwise by
     * index.
     *
     * @return Current locateTabsBy value. Default value is null
     * @see com.smartgwt.client.types.LocatorStrategy
     */
    public String getLocateTabsBy()  {
        return getAttributeAsString("locateTabsBy");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.tab.Tab} to be shown when {@link
     * com.smartgwt.client.widgets.tab.TabSet#getShowMoreTab showMoreTab} is enabled more than {@link
     * com.smartgwt.client.widgets.tab.TabSet#getMoreTabCount moreTabCount} tabs are provided.
     * <p>
     * This component is an AutoChild named "moreTab".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current moreTab value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Tab getMoreTab() throws IllegalStateException {
        errorIfNotCreated("moreTab");
        return Tab.getOrCreateRef(getAttributeAsJavaScriptObject("moreTab"));
    }
    

    /**
     * This property defines the number tab buttons that should be shown before automatically adding a "more" button to handle
     * the remaining tabs. This property is only used when {@link com.smartgwt.client.widgets.tab.TabSet#getShowMoreTab
     * showMoreTab} is enabled.
     *
     * @param moreTabCount New moreTabCount value. Default value is 5
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMoreTabCount(int moreTabCount)  throws IllegalStateException {
        setAttribute("moreTabCount", moreTabCount, false);
    }

    /**
     * This property defines the number tab buttons that should be shown before automatically adding a "more" button to handle
     * the remaining tabs. This property is only used when {@link com.smartgwt.client.widgets.tab.TabSet#getShowMoreTab
     * showMoreTab} is enabled.
     *
     * @return Current moreTabCount value. Default value is 5
     */
    public int getMoreTabCount()  {
        return getAttributeAsInt("moreTabCount");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowMoreTab showMoreTab} is enabled this property determines the
     * image to display on the "More" tab button.
     *
     * @param moreTabImage New moreTabImage value. Default value is "[SKINIMG]/iOS/more.png"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setMoreTabImage(String moreTabImage)  throws IllegalStateException {
        setAttribute("moreTabImage", moreTabImage, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowMoreTab showMoreTab} is enabled this property determines the
     * image to display on the "More" tab button.
     *
     * @return Current moreTabImage value. Default value is "[SKINIMG]/iOS/more.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getMoreTabImage()  {
        return getAttributeAsString("moreTabImage");
    }
    

    /**
     * Pane contents for the "more" tab based on a VLayout. Typically contains a {@link
     * com.smartgwt.client.widgets.layout.NavigationBar} and {@link com.smartgwt.client.widgets.tableview.TableView}.
     * <p>
     * This component is an AutoChild named "moreTabPane".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current moreTabPane value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public VLayout getMoreTabPane() throws IllegalStateException {
        errorIfNotCreated("moreTabPane");
        return (VLayout)VLayout.getByJSObject(getAttributeAsJavaScriptObject("moreTabPane"));
    }
    

    /**
     * Default properties for the "more" tab's pane. <p> Currently constructs a VLayout with a {@link
     * com.smartgwt.client.widgets.layout.NavigationBar} and {@link com.smartgwt.client.widgets.tableview.TableView}.
     *
     * @param moreTabPaneDefaults New moreTabPaneDefaults value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public void setMoreTabPaneDefaults(Canvas moreTabPaneDefaults)  throws IllegalStateException {
        if (moreTabPaneDefaults != null) {
            if (moreTabPaneDefaults.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(TabSet.class, "setMoreTabPaneDefaults", "Canvas");
            }                                                                       
            moreTabPaneDefaults.setConfigOnly(true);
        }
        JavaScriptObject config = moreTabPaneDefaults == null ? null : moreTabPaneDefaults.getConfig();
        setAttribute("moreTabPaneDefaults", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Default properties for the "more" tab's pane. <p> Currently constructs a VLayout with a {@link
     * com.smartgwt.client.widgets.layout.NavigationBar} and {@link com.smartgwt.client.widgets.tableview.TableView}.
     *
     * @return Current moreTabPaneDefaults value. Default value is null
     */
    public Canvas getMoreTabPaneDefaults()  {
        Canvas properties = new Canvas();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("moreTabPaneDefaults"));
        return properties;
    }
    

    /**
     * Navigation bar shown in the {@link com.smartgwt.client.widgets.tab.TabSet#getMoreTabPane moreTabPane};
     * <p>
     * This component is an AutoChild named "moreTabPaneNavBar".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current moreTabPaneNavBar value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public NavigationBar getMoreTabPaneNavBar() throws IllegalStateException {
        errorIfNotCreated("moreTabPaneNavBar");
        return (NavigationBar)NavigationBar.getByJSObject(getAttributeAsJavaScriptObject("moreTabPaneNavBar"));
    }
    

    /**
     * Properties to apply to the "more" tab's pane created by this TabSet.
     *
     * @param moreTabPaneProperties New moreTabPaneProperties value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public void setMoreTabPaneProperties(Canvas moreTabPaneProperties)  throws IllegalStateException {
        if (moreTabPaneProperties != null) {
            if (moreTabPaneProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(TabSet.class, "setMoreTabPaneProperties", "Canvas");
            }                                                                       
            moreTabPaneProperties.setConfigOnly(true);
        }
        JavaScriptObject config = moreTabPaneProperties == null ? null : moreTabPaneProperties.getConfig();
        setAttribute("moreTabPaneProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties to apply to the "more" tab's pane created by this TabSet.
     *
     * @return Current moreTabPaneProperties value. Default value is null
     */
    public Canvas getMoreTabPaneProperties()  {
        Canvas properties = new Canvas();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("moreTabPaneProperties"));
        return properties;
    }
    

    /**
     * {@link com.smartgwt.client.widgets.tableview.TableView} used to show links to other tabs in the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getMoreTabPane moreTabPane};
     * <p>
     * This component is an AutoChild named "moreTabPaneTable".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current moreTabPaneTable value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public TableView getMoreTabPaneTable() throws IllegalStateException {
        errorIfNotCreated("moreTabPaneTable");
        return (TableView)TableView.getByJSObject(getAttributeAsJavaScriptObject("moreTabPaneTable"));
    }
    

    /**
     * Properties to apply to the "more" tab created by this TabSet.
     *
     * @param moreTabProperties New moreTabProperties value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMoreTabProperties(Tab moreTabProperties)  throws IllegalStateException {
        JavaScriptObject config = JSOHelper.createObject();
        if (moreTabProperties != null) {
            JSOHelper.addProperties(config, moreTabProperties.getJsObj());
        }
        setAttribute("moreTabProperties", moreTabProperties == null ? null : config, false);
    }

    /**
     * Properties to apply to the "more" tab created by this TabSet.
     *
     * @return Current moreTabProperties value. Default value is null
     */
    public Tab getMoreTabProperties()  {
        return Tab.getOrCreateRef(getAttributeAsJavaScriptObject("moreTabProperties"));
    }
    

    /**
     * Title for the "More" tab.
     *
     * @param moreTabTitle New moreTabTitle value. Default value is "More"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMoreTabTitle(String moreTabTitle)  throws IllegalStateException {
        setAttribute("moreTabTitle", moreTabTitle, false);
    }

    /**
     * Title for the "More" tab.
     *
     * @return Current moreTabTitle value. Default value is "More"
     */
    public String getMoreTabTitle()  {
        return getAttributeAsString("moreTabTitle");
    }
    

    /**
     * Container where the component specified by {@link com.smartgwt.client.widgets.tab.Tab#getPane Tab.pane} is shown.
     *  <P>
     *  Note: paneContainer and showEdges:true for rounded tabsets: you can enable decorative
     * image-based edges on the paneContainer by setting {@link com.smartgwt.client.widgets.Canvas#getShowEdges showEdges:true}
     *  via paneContainerDefaults (to skin all tabsets) or paneContainerProperties (to use
     *  edges on one instance).  In this structure, the {@link com.smartgwt.client.docs.BaseLine} should use media
     *  that matches the appearance of the decorative edges and fully overlaps the edge of the
     *  paneContainer that it is adjacent to.  In the most typical appearance (symmetric edges
     * on all 4 sides), both {@link com.smartgwt.client.widgets.tab.TabBar#getBaseLineCapSize TabBar.baseLineCapSize} and
     * {@link com.smartgwt.client.widgets.tab.TabBar#getBaseLineThickness TabBar.baseLineThickness}
     *  match the {@link com.smartgwt.client.widgets.Canvas#getEdgeSize edgeSize} set on the paneContainer.  See the
     *  load_skin.js file for the "Smart GWT" skin for an example of setting all relevant
     *  properties.
     *  <P>
     *  To disable edges for a particular TabSet, which you may want to do for a TabSet that
     *  is already within a clearly defined container, configure the paneContainer to show only
     *  it's top edge:
     *  <pre>
     *       paneContainerProperties : { customEdges:["T"] },
     *  </pre>
     *  To completely flatten even the top edge of the TabSet:
     *  <pre>
     *       paneContainerProperties : { customEdges:["T"] },
     *       tabBarProperties :{ baseLineCapSize:0 },
     *  </pre>
     *  This "flattens" the baseLine so that only the center image is used.
     * <p>
     * This component is an AutoChild named "paneContainer".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current paneContainer value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public VLayout getPaneContainer() throws IllegalStateException {
        errorIfNotCreated("paneContainer");
        return (VLayout)VLayout.getByJSObject(getAttributeAsJavaScriptObject("paneContainer"));
    }
    

    /**
     * CSS style used for the paneContainer.
     *
     * @param paneContainerClassName New paneContainerClassName value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setPaneContainerClassName(String paneContainerClassName) {
        setAttribute("paneContainerClassName", paneContainerClassName, true);
    }

    /**
     * CSS style used for the paneContainer.
     *
     * @return Current paneContainerClassName value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getPaneContainerClassName()  {
        return getAttributeAsString("paneContainerClassName");
    }
    

    /**
     * Specifies the overflow of the pane container (the component that holds the pane contents for all tabs).  By default this
     * is set to "auto", meaning the pane container will automatically introduce scrolling when the pane contents exceed the
     * TabSet's specified size. <p> For other values and their meaning, see {@link com.smartgwt.client.types.Overflow}
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update {@link com.smartgwt.client.widgets.tab.TabSet#getPaneContainerOverflow paneContainerOverflow} after creation.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param paneContainerOverflow new overflow setting. Default value is Canvas.AUTO
     */
    public void setPaneContainerOverflow(Overflow paneContainerOverflow) {
        setAttribute("paneContainerOverflow", paneContainerOverflow == null ? null : paneContainerOverflow.getValue(), true);
    }

    /**
     * Specifies the overflow of the pane container (the component that holds the pane contents for all tabs).  By default this
     * is set to "auto", meaning the pane container will automatically introduce scrolling when the pane contents exceed the
     * TabSet's specified size. <p> For other values and their meaning, see {@link com.smartgwt.client.types.Overflow}
     *
     * @return Current paneContainerOverflow value. Default value is Canvas.AUTO
     */
    public Overflow getPaneContainerOverflow()  {
        return EnumUtil.getEnum(Overflow.values(), getAttribute("paneContainerOverflow"));
    }
    

    /**
     * Space to leave around the panes in our paneContainer <P> Note that this property may be specified on a per-tab basis via
     * {@link com.smartgwt.client.widgets.tab.Tab#getPaneMargin Tab.paneMargin}.
     *
     * @param paneMargin New paneMargin value. Default value is 0
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPaneMargin(int paneMargin)  throws IllegalStateException {
        setAttribute("paneMargin", paneMargin, false);
    }

    /**
     * Space to leave around the panes in our paneContainer <P> Note that this property may be specified on a per-tab basis via
     * {@link com.smartgwt.client.widgets.tab.Tab#getPaneMargin Tab.paneMargin}.
     *
     * @return Current paneMargin value. Default value is 0
     */
    public int getPaneMargin()  {
        return getAttributeAsInt("paneMargin");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is true, and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getSymmetricPickerButton symmetricPickerButton} is  set to true, this property
     * governs the base URL for the picker button image, when displayed in a horizontal tab-bar [IE {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is set to <code>"top"</code> or
     * <code>"bottom"</code>]. <P> Note that if <code>symmetricPickerButton</code> is false, the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPickerButtonSrc pickerButtonSrc} property will be used instead. <P> This base
     * URL will have a suffix of <code>"Down"</code> appended when the user holds the mouse down over the button, and
     * <code>"Disabled"</code> if the tabset as a whole is  disabled.
     *
     * @param pickerButtonHSrc New pickerButtonHSrc value. Default value is "[SKIN]hpicker.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tab.TabSet#setSymmetricPickerButton
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setPickerButtonHSrc(String pickerButtonHSrc)  throws IllegalStateException {
        setAttribute("pickerButtonHSrc", pickerButtonHSrc, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is true, and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getSymmetricPickerButton symmetricPickerButton} is  set to true, this property
     * governs the base URL for the picker button image, when displayed in a horizontal tab-bar [IE {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is set to <code>"top"</code> or
     * <code>"bottom"</code>]. <P> Note that if <code>symmetricPickerButton</code> is false, the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPickerButtonSrc pickerButtonSrc} property will be used instead. <P> This base
     * URL will have a suffix of <code>"Down"</code> appended when the user holds the mouse down over the button, and
     * <code>"Disabled"</code> if the tabset as a whole is  disabled.
     *
     * @return Current pickerButtonHSrc value. Default value is "[SKIN]hpicker.gif"
     * @see com.smartgwt.client.widgets.tab.TabSet#getSymmetricPickerButton
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getPickerButtonHSrc()  {
        return getAttributeAsString("pickerButtonHSrc");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is <code>true</code> and {@link
     * com.smartgwt.client.util.Browser#isTouch isTouch} is <code>false</code>, this property governs the size of the tab
     * picker button. This value is applied as the width of the tab picker button if the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBar tabBar} is horizontal, or the height if the <code>tabBar</code> is
     * vertical. Note that the other dimension is determined by {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarThickness this.tabBarThickness}. <p> On touch browsers (where {@link
     * com.smartgwt.client.util.Browser#isTouch isTouch} is <code>true</code>), {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTouchPickerButtonSize touchPickerButtonSize} is used instead.
     *
     * @param pickerButtonSize New pickerButtonSize value. Default value is 16
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPickerButtonSize(int pickerButtonSize)  throws IllegalStateException {
        setAttribute("pickerButtonSize", pickerButtonSize, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is <code>true</code> and {@link
     * com.smartgwt.client.util.Browser#isTouch isTouch} is <code>false</code>, this property governs the size of the tab
     * picker button. This value is applied as the width of the tab picker button if the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBar tabBar} is horizontal, or the height if the <code>tabBar</code> is
     * vertical. Note that the other dimension is determined by {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarThickness this.tabBarThickness}. <p> On touch browsers (where {@link
     * com.smartgwt.client.util.Browser#isTouch isTouch} is <code>true</code>), {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTouchPickerButtonSize touchPickerButtonSize} is used instead.
     *
     * @return Current pickerButtonSize value. Default value is 16
     */
    public int getPickerButtonSize()  {
        return getAttributeAsInt("pickerButtonSize");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is true, this property governs the base
     * URL for the picker button image, when {@link com.smartgwt.client.widgets.tab.TabSet#getSymmetricPickerButton
     * symmetricPickerButton} is set to false <P> Note that if <code>symmetricPickerButton</code> is true, the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPickerButtonHSrc pickerButtonHSrc}  and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPickerButtonVSrc pickerButtonVSrc} properties will be used instead. <P> To get
     * the path to the image to display, this base URL will be modified as follows: <ul> <li>If appropriate a state suffix of
     * <code>"Down"</code> or <code>"Disabled"</code> will be     appended.</li> <li>The {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} for this tabSet will be appended.</li> </ul>
     *
     * @param pickerButtonSrc New pickerButtonSrc value. Default value is "[SKIN]/picker.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tab.TabSet#setSymmetricPickerButton
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setPickerButtonSrc(String pickerButtonSrc)  throws IllegalStateException {
        setAttribute("pickerButtonSrc", pickerButtonSrc, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is true, this property governs the base
     * URL for the picker button image, when {@link com.smartgwt.client.widgets.tab.TabSet#getSymmetricPickerButton
     * symmetricPickerButton} is set to false <P> Note that if <code>symmetricPickerButton</code> is true, the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPickerButtonHSrc pickerButtonHSrc}  and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPickerButtonVSrc pickerButtonVSrc} properties will be used instead. <P> To get
     * the path to the image to display, this base URL will be modified as follows: <ul> <li>If appropriate a state suffix of
     * <code>"Down"</code> or <code>"Disabled"</code> will be     appended.</li> <li>The {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} for this tabSet will be appended.</li> </ul>
     *
     * @return Current pickerButtonSrc value. Default value is "[SKIN]/picker.gif"
     * @see com.smartgwt.client.widgets.tab.TabSet#getSymmetricPickerButton
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getPickerButtonSrc()  {
        return getAttributeAsString("pickerButtonSrc");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is true, and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getSymmetricPickerButton symmetricPickerButton} is  set to true, this property
     * governs the base URL for the picker button image, when displayed in a verricaL tab-bar [IE {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is set to <code>"LEFT"</code> or
     * <code>"right"</code>]. <P> Note that if <code>symmetricPickerButton</code> is false, the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPickerButtonSrc pickerButtonSrc} property will be used instead. <P> This base
     * URL will have a suffix of <code>"Down"</code> appended when the user holds the mouse down over the button, and
     * <code>"Disabled"</code> if the tabset as a whole is  disabled.
     *
     * @param pickerButtonVSrc New pickerButtonVSrc value. Default value is "[SKIN]vpicker.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tab.TabSet#setSymmetricPickerButton
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setPickerButtonVSrc(String pickerButtonVSrc)  throws IllegalStateException {
        setAttribute("pickerButtonVSrc", pickerButtonVSrc, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is true, and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getSymmetricPickerButton symmetricPickerButton} is  set to true, this property
     * governs the base URL for the picker button image, when displayed in a verricaL tab-bar [IE {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is set to <code>"LEFT"</code> or
     * <code>"right"</code>]. <P> Note that if <code>symmetricPickerButton</code> is false, the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPickerButtonSrc pickerButtonSrc} property will be used instead. <P> This base
     * URL will have a suffix of <code>"Down"</code> appended when the user holds the mouse down over the button, and
     * <code>"Disabled"</code> if the tabset as a whole is  disabled.
     *
     * @return Current pickerButtonVSrc value. Default value is "[SKIN]vpicker.gif"
     * @see com.smartgwt.client.widgets.tab.TabSet#getSymmetricPickerButton
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getPickerButtonVSrc()  {
        return getAttributeAsString("pickerButtonVSrc");
    }
    
    
    

    /**
     * A component containing back and forward buttons for scrolling through all of the tabs of the TabSet. The scroller is
     * created automatically when needed and when <code>"tabScroller"</code> is specified in the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarControls tabBarControls}. <p> By default, the scroller constructor is
     * {@link com.smartgwt.client.widgets.StretchImgButton}. Note that the scroller {@link
     * com.smartgwt.client.widgets.StretchImg#getItems items} are determined automatically, so any items set in
     * scrollerProperties will be ignored.
     * <p>
     * This component is an AutoChild named "scroller".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current scroller value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public StretchImgButton getScroller() throws IllegalStateException {
        errorIfNotCreated("scroller");
        return (StretchImgButton)StretchImgButton.getByJSObject(getAttributeAsJavaScriptObject("scroller"));
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller showTabScroller} is true, this property governs the
     * size of scroller buttons. Applied as the width of buttons if the tabBar is horizontal, or the height if tabBar is
     * vertical. Note that the other dimension is determined by  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarThickness this.tabBarThickness}
     *
     * @param scrollerButtonSize New scrollerButtonSize value. Default value is 16
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setScrollerButtonSize(int scrollerButtonSize)  throws IllegalStateException {
        setAttribute("scrollerButtonSize", scrollerButtonSize, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller showTabScroller} is true, this property governs the
     * size of scroller buttons. Applied as the width of buttons if the tabBar is horizontal, or the height if tabBar is
     * vertical. Note that the other dimension is determined by  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarThickness this.tabBarThickness}
     *
     * @return Current scrollerButtonSize value. Default value is 16
     */
    public int getScrollerButtonSize()  {
        return getAttributeAsInt("scrollerButtonSize");
    }
    

    /**
     * If this TabSet is showing {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller tab scroller buttons}, and 
     * {@link com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller symmetricScroller} is true, this property governs the
     * base URL for the tab bar back and forward scroller button images for horizontal tab bars [IE for tab sets with {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} set to "top" or "bottom"]. <P> Note that if
     * {@link com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller symmetricScroller} is false,  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getScrollerSrc scrollerSrc} will be used instead. <P> To get the path to the
     * image to display, this base URL will be modified as follows: <ul> <li>If appropriate a state suffix of
     * <code>"Down"</code> or <code>"Disabled"</code> will be     appended.</li> <li>A suffix of <code>"forward"</code> or
     * <code>"back"</code> will be appended for the     forward or backward scrolling button.</li> </ul> For example - if the
     * scrollerHSrc is set to <code>"[SKIN]hscroll.gif"</code>, the image displayed for the back-scroller button on a tabSet
     * with <code>tabBarPosition</code> set to "top" and <code>symmetricScroller</code> set to true would be one of 
     * <code>"[SKIN]hscroll_back.gif"</code>, <code>"[SKIN]hscroll_Down_back.gif"</code>, and
     * <code>"[SKIN]hscroll_Disabled_back.gif"</code>. <P> Note that for best results the media should be sized to match the
     * scroller button sizes,  determined by {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarThickness tabBarThickness}
     * and {@link com.smartgwt.client.widgets.tab.TabSet#getScrollerButtonSize scrollerButtonSize}.
     *
     * @param scrollerHSrc New scrollerHSrc value. Default value is "[SKIN]hscroll.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tab.TabSet#setSymmetricScroller
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setScrollerHSrc(String scrollerHSrc)  throws IllegalStateException {
        setAttribute("scrollerHSrc", scrollerHSrc, false);
    }

    /**
     * If this TabSet is showing {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller tab scroller buttons}, and 
     * {@link com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller symmetricScroller} is true, this property governs the
     * base URL for the tab bar back and forward scroller button images for horizontal tab bars [IE for tab sets with {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} set to "top" or "bottom"]. <P> Note that if
     * {@link com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller symmetricScroller} is false,  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getScrollerSrc scrollerSrc} will be used instead. <P> To get the path to the
     * image to display, this base URL will be modified as follows: <ul> <li>If appropriate a state suffix of
     * <code>"Down"</code> or <code>"Disabled"</code> will be     appended.</li> <li>A suffix of <code>"forward"</code> or
     * <code>"back"</code> will be appended for the     forward or backward scrolling button.</li> </ul> For example - if the
     * scrollerHSrc is set to <code>"[SKIN]hscroll.gif"</code>, the image displayed for the back-scroller button on a tabSet
     * with <code>tabBarPosition</code> set to "top" and <code>symmetricScroller</code> set to true would be one of 
     * <code>"[SKIN]hscroll_back.gif"</code>, <code>"[SKIN]hscroll_Down_back.gif"</code>, and
     * <code>"[SKIN]hscroll_Disabled_back.gif"</code>. <P> Note that for best results the media should be sized to match the
     * scroller button sizes,  determined by {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarThickness tabBarThickness}
     * and {@link com.smartgwt.client.widgets.tab.TabSet#getScrollerButtonSize scrollerButtonSize}.
     *
     * @return Current scrollerHSrc value. Default value is "[SKIN]hscroll.gif"
     * @see com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getScrollerHSrc()  {
        return getAttributeAsString("scrollerHSrc");
    }
    

    /**
     * If this TabSet is showing {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller tab scroller buttons}, and 
     * {@link com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller symmetricScroller} is false, this property governs
     * the base URL for the tab bar back and forward scroller button images. <P> Note that if {@link
     * com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller symmetricScroller} is true,  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getScrollerHSrc scrollerHSrc} and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getScrollerVSrc scrollerVSrc} will be used instead. <P> To get the path to the
     * image to display, this base URL will be modified as follows: <ul> <li>If appropriate a state suffix of
     * <code>"Down"</code> or <code>"Disabled"</code> will be     appended.</li> <li>The {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} for this tabSet will be appended.</li> <li>A
     * suffix of <code>"forward"</code> or <code>"back"</code> will be appended for the     forward or backward scrolling
     * button.</li> </ul> For example - if the scrollerSrc is set to <code>"[SKIN]scroll.gif"</code>, the image displayed for
     * the back-scroller button on a tabSet with <code>tabBarPosition</code> set to "top" and <code>symmetricScroller</code>
     * set to false would be one of  <code>"[SKIN]scroll_top_back.gif"</code>, <code>"[SKIN]scroll_Down_top_back.gif"</code>,
     * and <code>"[SKIN]scroll_Disabled_top_back.gif"</code>. <P> Note that for best results the media should be sized to match
     * the scroller button sizes,  determined by {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarThickness
     * tabBarThickness} and {@link com.smartgwt.client.widgets.tab.TabSet#getScrollerButtonSize scrollerButtonSize}.
     *
     * @param scrollerSrc New scrollerSrc value. Default value is "[SKIN]/scroll.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tab.TabSet#setSymmetricScroller
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setScrollerSrc(String scrollerSrc)  throws IllegalStateException {
        setAttribute("scrollerSrc", scrollerSrc, false);
    }

    /**
     * If this TabSet is showing {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller tab scroller buttons}, and 
     * {@link com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller symmetricScroller} is false, this property governs
     * the base URL for the tab bar back and forward scroller button images. <P> Note that if {@link
     * com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller symmetricScroller} is true,  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getScrollerHSrc scrollerHSrc} and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getScrollerVSrc scrollerVSrc} will be used instead. <P> To get the path to the
     * image to display, this base URL will be modified as follows: <ul> <li>If appropriate a state suffix of
     * <code>"Down"</code> or <code>"Disabled"</code> will be     appended.</li> <li>The {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} for this tabSet will be appended.</li> <li>A
     * suffix of <code>"forward"</code> or <code>"back"</code> will be appended for the     forward or backward scrolling
     * button.</li> </ul> For example - if the scrollerSrc is set to <code>"[SKIN]scroll.gif"</code>, the image displayed for
     * the back-scroller button on a tabSet with <code>tabBarPosition</code> set to "top" and <code>symmetricScroller</code>
     * set to false would be one of  <code>"[SKIN]scroll_top_back.gif"</code>, <code>"[SKIN]scroll_Down_top_back.gif"</code>,
     * and <code>"[SKIN]scroll_Disabled_top_back.gif"</code>. <P> Note that for best results the media should be sized to match
     * the scroller button sizes,  determined by {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarThickness
     * tabBarThickness} and {@link com.smartgwt.client.widgets.tab.TabSet#getScrollerButtonSize scrollerButtonSize}.
     *
     * @return Current scrollerSrc value. Default value is "[SKIN]/scroll.gif"
     * @see com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getScrollerSrc()  {
        return getAttributeAsString("scrollerSrc");
    }
    

    /**
     * If this TabSet is showing {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller tab scroller buttons}, and 
     * {@link com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller symmetricScroller} is true, this property governs the
     * base URL for the tab bar back and forward scroller button images for vertical tab bars [IE for tab sets with {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} set to "left" or "right"]. <P> Note that if
     * {@link com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller symmetricScroller} is false,  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getScrollerSrc scrollerSrc} will be used instead. <P> To get the path to the
     * image to display, this base URL will be modified as follows: <ul> <li>If appropriate a state suffix of
     * <code>"Down"</code> or <code>"Disabled"</code> will be     appended.</li> <li>A suffix of <code>"forward"</code> or
     * <code>"back"</code> will be appended for the     forward or backward scrolling button.</li> </ul> For example - if the
     * scrollerVSrc is set to <code>"[SKIN]vscroll.gif"</code>, the image displayed for the back-scroller button on a tabSet
     * with <code>tabBarPosition</code> set to "left" and <code>symmetricScroller</code> set to true would be one of 
     * <code>"[SKIN]vscroll_back.gif"</code>, <code>"[SKIN]vscroll_Down_back.gif"</code>, and
     * <code>"[SKIN]vscroll_Disabled_back.gif"</code>. <P> Note that for best results the media should be sized to match the
     * scroller button sizes,  determined by {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarThickness tabBarThickness}
     * and {@link com.smartgwt.client.widgets.tab.TabSet#getScrollerButtonSize scrollerButtonSize}.
     *
     * @param scrollerVSrc New scrollerVSrc value. Default value is "[SKIN]vscroll.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tab.TabSet#setSymmetricScroller
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setScrollerVSrc(String scrollerVSrc)  throws IllegalStateException {
        setAttribute("scrollerVSrc", scrollerVSrc, false);
    }

    /**
     * If this TabSet is showing {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller tab scroller buttons}, and 
     * {@link com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller symmetricScroller} is true, this property governs the
     * base URL for the tab bar back and forward scroller button images for vertical tab bars [IE for tab sets with {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} set to "left" or "right"]. <P> Note that if
     * {@link com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller symmetricScroller} is false,  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getScrollerSrc scrollerSrc} will be used instead. <P> To get the path to the
     * image to display, this base URL will be modified as follows: <ul> <li>If appropriate a state suffix of
     * <code>"Down"</code> or <code>"Disabled"</code> will be     appended.</li> <li>A suffix of <code>"forward"</code> or
     * <code>"back"</code> will be appended for the     forward or backward scrolling button.</li> </ul> For example - if the
     * scrollerVSrc is set to <code>"[SKIN]vscroll.gif"</code>, the image displayed for the back-scroller button on a tabSet
     * with <code>tabBarPosition</code> set to "left" and <code>symmetricScroller</code> set to true would be one of 
     * <code>"[SKIN]vscroll_back.gif"</code>, <code>"[SKIN]vscroll_Down_back.gif"</code>, and
     * <code>"[SKIN]vscroll_Disabled_back.gif"</code>. <P> Note that for best results the media should be sized to match the
     * scroller button sizes,  determined by {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarThickness tabBarThickness}
     * and {@link com.smartgwt.client.widgets.tab.TabSet#getScrollerButtonSize scrollerButtonSize}.
     *
     * @return Current scrollerVSrc value. Default value is "[SKIN]vscroll.gif"
     * @see com.smartgwt.client.widgets.tab.TabSet#getSymmetricScroller
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getScrollerVSrc()  {
        return getAttributeAsString("scrollerVSrc");
    }
    
    

    /**
     * Should tabs exceeding {@link com.smartgwt.client.widgets.tab.TabSet#getMoreTabCount moreTabCount} be shown on a "more"
     * tab? <p> This setting is used to emulate an iPhone-style tab bar "more" button.
     *
     * @param showMoreTab New showMoreTab value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowMoreTab(Boolean showMoreTab)  throws IllegalStateException {
        setAttribute("showMoreTab", showMoreTab, false);
    }

    /**
     * Should tabs exceeding {@link com.smartgwt.client.widgets.tab.TabSet#getMoreTabCount moreTabCount} be shown on a "more"
     * tab? <p> This setting is used to emulate an iPhone-style tab bar "more" button.
     *
     * @return Current showMoreTab value. Default value is null
     */
    public Boolean getShowMoreTab()  {
        return getAttributeAsBoolean("showMoreTab");
    }
    

    /**
     * Should the paneContainer for this tabset show {@link com.smartgwt.client.widgets.Canvas#getShowEdges edges}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showPaneContainerEdges New showPaneContainerEdges value. Default value is null
     */
    public void setShowPaneContainerEdges(Boolean showPaneContainerEdges) {
        setAttribute("showPaneContainerEdges", showPaneContainerEdges, true);
    }

    /**
     * Should the paneContainer for this tabset show {@link com.smartgwt.client.widgets.Canvas#getShowEdges edges}.
     *
     * @return Current showPaneContainerEdges value. Default value is null
     */
    public Boolean getShowPaneContainerEdges()  {
        return getAttributeAsBoolean("showPaneContainerEdges");
    }
    

    /**
     * If the paneContainer for this tab set is showing {@link com.smartgwt.client.widgets.Canvas#getShowEdges edges}, setting
     * this attribute to <code>true</code> will set the paneContainer to show {@link
     * com.smartgwt.client.widgets.Canvas#getCustomEdges customEdges} for the three sides opposing the tabBarPosition.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showPartialEdges New showPartialEdges value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowPartialEdges(Boolean showPartialEdges)  throws IllegalStateException {
        setAttribute("showPartialEdges", showPartialEdges, false);
    }

    /**
     * If the paneContainer for this tab set is showing {@link com.smartgwt.client.widgets.Canvas#getShowEdges edges}, setting
     * this attribute to <code>true</code> will set the paneContainer to show {@link
     * com.smartgwt.client.widgets.Canvas#getCustomEdges customEdges} for the three sides opposing the tabBarPosition.
     *
     * @return Current showPartialEdges value. Default value is false
     */
    public Boolean getShowPartialEdges()  {
        Boolean result = getAttributeAsBoolean("showPartialEdges");
        return result == null ? false : result;
    }
    

    /**
     * Should the tabBar be displayed or not If shrinkElementOnHide is true, the paneContainer will expand over the space
     * occupied by TabBar
     *
     * @param showTabBar New showTabBar value. Default value is true
     */
    public void setShowTabBar(Boolean showTabBar) {
        setAttribute("showTabBar", showTabBar, true);
    }

    /**
     * Should the tabBar be displayed or not If shrinkElementOnHide is true, the paneContainer will expand over the space
     * occupied by TabBar
     *
     * @return Current showTabBar value. Default value is true
     */
    public Boolean getShowTabBar()  {
        Boolean result = getAttributeAsBoolean("showTabBar");
        return result == null ? true : result;
    }
    

    /**
     * If there is not enough space to display all the tab-buttons in this tabSet, should a drop-down "picker" be displayed to
     * allow selection of tabs that are clipped?
     *
     * @param showTabPicker New showTabPicker value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowTabPicker(Boolean showTabPicker)  throws IllegalStateException {
        setAttribute("showTabPicker", showTabPicker, false);
    }

    /**
     * If there is not enough space to display all the tab-buttons in this tabSet, should a drop-down "picker" be displayed to
     * allow selection of tabs that are clipped?
     *
     * @return Current showTabPicker value. Default value is true
     */
    public Boolean getShowTabPicker()  {
        Boolean result = getAttributeAsBoolean("showTabPicker");
        return result == null ? true : result;
    }
    

    /**
     * If there is not enough space to display all the tab-buttons in this tabSet, should  scroll buttons be displayed to allow
     * access to tabs that are clipped?  If unset,  defaults to false for {@link com.smartgwt.client.util.Browser#isHandset
     * handsets} and true otherwise.
     *
     * @param showTabScroller New showTabScroller value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowTabScroller(Boolean showTabScroller)  throws IllegalStateException {
        setAttribute("showTabScroller", showTabScroller, false);
    }

    /**
     * If there is not enough space to display all the tab-buttons in this tabSet, should  scroll buttons be displayed to allow
     * access to tabs that are clipped?  If unset,  defaults to false for {@link com.smartgwt.client.util.Browser#isHandset
     * handsets} and true otherwise.
     *
     * @return Current showTabScroller value. Default value is null
     */
    public Boolean getShowTabScroller()  {
        return getAttributeAsBoolean("showTabScroller");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getUseSimpleTabs useSimpleTabs} is true,
     * <code>simpleTabBaseStyle</code> will be the base style used to determine the css style to apply to the tabs.<P> This
     * property will be suffixed with the side on which the tab-bar will appear, followed by with the tab's state (selected,
     * over, etc), resolving to a className like  "tabButtonTopOver".
     *
     * @param simpleTabBaseStyle New simpleTabBaseStyle value. Default value is "tabButton"
     * @see com.smartgwt.client.widgets.Button#setBaseStyle
     * @see com.smartgwt.client.widgets.tab.TabSet#setSimpleTabIconOnlyBaseStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setSimpleTabBaseStyle(String simpleTabBaseStyle) {
        setAttribute("simpleTabBaseStyle", simpleTabBaseStyle, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getUseSimpleTabs useSimpleTabs} is true,
     * <code>simpleTabBaseStyle</code> will be the base style used to determine the css style to apply to the tabs.<P> This
     * property will be suffixed with the side on which the tab-bar will appear, followed by with the tab's state (selected,
     * over, etc), resolving to a className like  "tabButtonTopOver".
     *
     * @return Current simpleTabBaseStyle value. Default value is "tabButton"
     * @see com.smartgwt.client.widgets.Button#getBaseStyle
     * @see com.smartgwt.client.widgets.tab.TabSet#getSimpleTabIconOnlyBaseStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getSimpleTabBaseStyle()  {
        return getAttributeAsString("simpleTabBaseStyle");
    }
    
    

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getUseSimpleTabs useSimpleTabs} is true,
     * <code>simpleTabIconOnlyBaseStyle</code> will be the base style used to determine the css style to apply to the tabs if
     * {@link com.smartgwt.client.widgets.tab.Tab#getCanAdaptWidth Tab.canAdaptWidth} is set and the title is not being shown.
     * <P> This property will be suffixed with the side on which the tab-bar will appear, followed by with the tab's state
     * (selected, over, etc), resolving to a className like  "iconOnlyTabButtonTopOver". <P> Note that this property is only
     * defined for certain skins, where it's needed.  If not defined, {@link
     * com.smartgwt.client.widgets.tab.TabSet#getSimpleTabBaseStyle simpleTabBaseStyle} will serve as base style whether or not
     * the title is hidden.
     *
     * @param simpleTabIconOnlyBaseStyle New simpleTabIconOnlyBaseStyle value. Default value is varies
     * @see com.smartgwt.client.widgets.Button#setBaseStyle
     * @see com.smartgwt.client.widgets.Button#setIconOnlyBaseStyle
     * @see com.smartgwt.client.widgets.tab.TabSet#setSimpleTabBaseStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setSimpleTabIconOnlyBaseStyle(String simpleTabIconOnlyBaseStyle) {
        setAttribute("simpleTabIconOnlyBaseStyle", simpleTabIconOnlyBaseStyle, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.tab.TabSet#getUseSimpleTabs useSimpleTabs} is true,
     * <code>simpleTabIconOnlyBaseStyle</code> will be the base style used to determine the css style to apply to the tabs if
     * {@link com.smartgwt.client.widgets.tab.Tab#getCanAdaptWidth Tab.canAdaptWidth} is set and the title is not being shown.
     * <P> This property will be suffixed with the side on which the tab-bar will appear, followed by with the tab's state
     * (selected, over, etc), resolving to a className like  "iconOnlyTabButtonTopOver". <P> Note that this property is only
     * defined for certain skins, where it's needed.  If not defined, {@link
     * com.smartgwt.client.widgets.tab.TabSet#getSimpleTabBaseStyle simpleTabBaseStyle} will serve as base style whether or not
     * the title is hidden.
     *
     * @return Current simpleTabIconOnlyBaseStyle value. Default value is varies
     * @see com.smartgwt.client.widgets.Button#getBaseStyle
     * @see com.smartgwt.client.widgets.Button#getIconOnlyBaseStyle
     * @see com.smartgwt.client.widgets.tab.TabSet#getSimpleTabBaseStyle
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getSimpleTabIconOnlyBaseStyle()  {
        return getAttributeAsString("simpleTabIconOnlyBaseStyle");
    }
    

    /**
     * Default directory for skin images (those defined by the class), relative to the Page-wide {@link
     * com.smartgwt.client.util.Page#getSkinDir skinDir}.
     *
     * @param skinImgDir New skinImgDir value. Default value is "images/TabSet/"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setSkinImgDir(String skinImgDir)  throws IllegalStateException {
        setAttribute("skinImgDir", skinImgDir, false);
    }

    /**
     * Default directory for skin images (those defined by the class), relative to the Page-wide {@link
     * com.smartgwt.client.util.Page#getSkinDir skinDir}.
     *
     * @return Current skinImgDir value. Default value is "images/TabSet/"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }
    

    /**
     * If this tabSet will {@link com.smartgwt.client.widgets.tab.TabSet#getShowPaneContainerEdges show edges} for the
     * paneContainer, this property determines whether the same edge media will be used regardless of the tab bar position, or
     * whether different media should be used (necessary if the edge appearance is not symmetrical on all sides). <P> If this
     * property is set to false the paneContainer edge image URLs will be prefixed with the tabBarPosition of the tabSet - for
     * example <code>"[SKIN]edge_top_T.gif"</code> rather than just <code>"[SKIN]edge_T.gif"</code>. <P> When
     * <code>symmetricEdges</code> is false, custom edge sizes for the pane container may be specified via {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTopEdgeSizes topEdgeSizes} et al, and custom edge offsets via  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTopEdgeOffsets topEdgeOffsets} et al.
     *
     * @param symmetricEdges New symmetricEdges value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSymmetricEdges(Boolean symmetricEdges)  throws IllegalStateException {
        setAttribute("symmetricEdges", symmetricEdges, false);
    }

    /**
     * If this tabSet will {@link com.smartgwt.client.widgets.tab.TabSet#getShowPaneContainerEdges show edges} for the
     * paneContainer, this property determines whether the same edge media will be used regardless of the tab bar position, or
     * whether different media should be used (necessary if the edge appearance is not symmetrical on all sides). <P> If this
     * property is set to false the paneContainer edge image URLs will be prefixed with the tabBarPosition of the tabSet - for
     * example <code>"[SKIN]edge_top_T.gif"</code> rather than just <code>"[SKIN]edge_T.gif"</code>. <P> When
     * <code>symmetricEdges</code> is false, custom edge sizes for the pane container may be specified via {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTopEdgeSizes topEdgeSizes} et al, and custom edge offsets via  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTopEdgeOffsets topEdgeOffsets} et al.
     *
     * @return Current symmetricEdges value. Default value is true
     */
    public Boolean getSymmetricEdges()  {
        Boolean result = getAttributeAsBoolean("symmetricEdges");
        return result == null ? true : result;
    }
    

    /**
     * If this TabSet is showing a {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker tab picker button}, this
     * property determines whether the {@link com.smartgwt.client.widgets.tab.TabSet#getPickerButtonHSrc pickerButtonHSrc} and
     * {@link com.smartgwt.client.widgets.tab.TabSet#getPickerButtonVSrc pickerButtonVSrc} media will be used for vertical and
     * horizontal tab-bar picker buttons, or whether separate media should be used for each possible  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} based on the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPickerButtonSrc pickerButtonSrc} property  for this tabSet.
     *
     * @param symmetricPickerButton New symmetricPickerButton value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSymmetricPickerButton(Boolean symmetricPickerButton)  throws IllegalStateException {
        setAttribute("symmetricPickerButton", symmetricPickerButton, false);
    }

    /**
     * If this TabSet is showing a {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker tab picker button}, this
     * property determines whether the {@link com.smartgwt.client.widgets.tab.TabSet#getPickerButtonHSrc pickerButtonHSrc} and
     * {@link com.smartgwt.client.widgets.tab.TabSet#getPickerButtonVSrc pickerButtonVSrc} media will be used for vertical and
     * horizontal tab-bar picker buttons, or whether separate media should be used for each possible  {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} based on the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getPickerButtonSrc pickerButtonSrc} property  for this tabSet.
     *
     * @return Current symmetricPickerButton value. Default value is true
     */
    public Boolean getSymmetricPickerButton()  {
        Boolean result = getAttributeAsBoolean("symmetricPickerButton");
        return result == null ? true : result;
    }
    

    /**
     * If this TabSet is showing {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller tab scroller buttons}, this
     * property  determines whether the {@link com.smartgwt.client.widgets.tab.TabSet#getScrollerHSrc scrollerHSrc} and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getScrollerVSrc scrollerVSrc} media will be used for vertical and horizontal
     * tab-bar scroller buttons, or whether separate media should be used for each possible {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} based on the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getScrollerSrc scrollerSrc} property for this tabSet.
     *
     * @param symmetricScroller New symmetricScroller value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSymmetricScroller(Boolean symmetricScroller)  throws IllegalStateException {
        setAttribute("symmetricScroller", symmetricScroller, false);
    }

    /**
     * If this TabSet is showing {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller tab scroller buttons}, this
     * property  determines whether the {@link com.smartgwt.client.widgets.tab.TabSet#getScrollerHSrc scrollerHSrc} and {@link
     * com.smartgwt.client.widgets.tab.TabSet#getScrollerVSrc scrollerVSrc} media will be used for vertical and horizontal
     * tab-bar scroller buttons, or whether separate media should be used for each possible {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} based on the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getScrollerSrc scrollerSrc} property for this tabSet.
     *
     * @return Current symmetricScroller value. Default value is true
     */
    public Boolean getSymmetricScroller()  {
        Boolean result = getAttributeAsBoolean("symmetricScroller");
        return result == null ? true : result;
    }
    

    /**
     * TabBar for this TabSet, an instance of {@link com.smartgwt.client.widgets.tab.TabBar}.
     * <p>
     * This component is an AutoChild named "tabBar".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current tabBar value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public TabBar getTabBar() throws IllegalStateException {
        errorIfNotCreated("tabBar");
        return (TabBar)TabBar.getByJSObject(getAttributeAsJavaScriptObject("tabBar"));
    }
    

    /**
     * Alignment of the tabBar. <P> If the {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is
     * "top" or "bottom", then  this attribute may be set to "left", "right" or "center".  The default is "left", or "right" in
     * {@link com.smartgwt.client.util.Page#isRTL RTL mode}. <P> If the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is "left" or "right", then this attribute may
     * be set to "top", "bottom" or "center".  The default is "top".
     *
     * @param tabBarAlign New tabBarAlign value. Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_align" target="examples">Align Example</a>
     */
    public void setTabBarAlign(Side tabBarAlign)  throws IllegalStateException {
        setAttribute("tabBarAlign", tabBarAlign == null ? null : tabBarAlign.getValue(), false);
    }

    /**
     * Alignment of the tabBar. <P> If the {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is
     * "top" or "bottom", then  this attribute may be set to "left", "right" or "center".  The default is "left", or "right" in
     * {@link com.smartgwt.client.util.Page#isRTL RTL mode}. <P> If the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is "left" or "right", then this attribute may
     * be set to "top", "bottom" or "center".  The default is "top".
     *
     * @return Current tabBarAlign value. Default value is see below
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_align" target="examples">Align Example</a>
     */
    public Side getTabBarAlign()  {
        return EnumUtil.getEnum(Side.values(), getAttribute("tabBarAlign"));
    }

    /**
     * Alignment of the tabBar. <P> If the {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is
     * "top" or "bottom", then  this attribute may be set to "left", "right" or "center".  The default is "left", or "right" in
     * {@link com.smartgwt.client.util.Page#isRTL RTL mode}. <P> If the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is "left" or "right", then this attribute may
     * be set to "top", "bottom" or "center".  The default is "top".
     *
     * @param tabBarAlign New tabBarAlign value. Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_align" target="examples">Align Example</a>
     */
    public void setTabBarAlign(Alignment tabBarAlign)  throws IllegalStateException {
        setAttribute("tabBarAlign", tabBarAlign == null ? null : tabBarAlign.getValue(), false);
    }

    /**
     * Alignment of the tabBar. <P> If the {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is
     * "top" or "bottom", then  this attribute may be set to "left", "right" or "center".  The default is "left", or "right" in
     * {@link com.smartgwt.client.util.Page#isRTL RTL mode}. <P> If the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is "left" or "right", then this attribute may
     * be set to "top", "bottom" or "center".  The default is "top".
     *
     * @return Current tabBarAlign value. Default value is see below
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_align" target="examples">Align Example</a>
     */
    public Alignment getTabBarAlignAsAlignment()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("tabBarAlign"));
    }
    

    /**
     * {@link com.smartgwt.client.types.AutoChild} of type {@link com.smartgwt.client.widgets.layout.Layout} that holds the
     * {@link com.smartgwt.client.widgets.tab.TabSet#getTabBarControls tabBarControls} as well as the built-in controls such as
     * the {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker tab picker menu}.
     * <p>
     * This component is an AutoChild named "tabBarControlLayout".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current tabBarControlLayout value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Layout getTabBarControlLayout() throws IllegalStateException {
        errorIfNotCreated("tabBarControlLayout");
        return (Layout)Layout.getByJSObject(getAttributeAsJavaScriptObject("tabBarControlLayout"));
    }
    
    

    /**
     * Which side of the TabSet the TabBar should appear on.
     *
     * @param tabBarPosition New tabBarPosition value. Default value is Canvas.TOP
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_orientation" target="examples">Orientation Example</a>
     */
    public void setTabBarPosition(Side tabBarPosition)  throws IllegalStateException {
        setAttribute("tabBarPosition", tabBarPosition == null ? null : tabBarPosition.getValue(), false);
    }

    /**
     * Which side of the TabSet the TabBar should appear on.
     *
     * @return Current tabBarPosition value. Default value is Canvas.TOP
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_orientation" target="examples">Orientation Example</a>
     */
    public Side getTabBarPosition()  {
        return EnumUtil.getEnum(Side.values(), getAttribute("tabBarPosition"));
    }
    
    

    /**
     * Thickness of tabBar, applies to either orientation (specifies height for horizontal, width for vertical orientation). 
     * Note that overriding this value for TabSets that are skinned with images generally means providing new media for the
     * borders.
     *
     * @param tabBarThickness New tabBarThickness value. Default value is 21
     */
    public void setTabBarThickness(int tabBarThickness) {
        setAttribute("tabBarThickness", tabBarThickness, true);
    }

    /**
     * Thickness of tabBar, applies to either orientation (specifies height for horizontal, width for vertical orientation). 
     * Note that overriding this value for TabSets that are skinned with images generally means providing new media for the
     * borders.
     *
     * @return Current tabBarThickness value. Default value is 21
     */
    public int getTabBarThickness()  {
        return getAttributeAsInt("tabBarThickness");
    }
    

    /**
     * A button control that allows tabs to be picked directly from a popup menu. The tabPicker is created automatically when
     * needed and when <code>"tabPicker"</code> is specified in the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarControls tabBarControls}.
     * <p>
     * This component is an AutoChild named "tabPicker".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current tabPicker value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getTabPicker() throws IllegalStateException {
        errorIfNotCreated("tabPicker");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("tabPicker"));
    }
    
    
    
    

    /**
     * TextItem we use to edit tab titles in this TabSet.  You can override this property  using the normal {@link
     * com.smartgwt.client.types.AutoChild} facilities.
     * <p>
     * This component is an AutoChild named "titleEditor".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current titleEditor value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     * @see com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles
     * @see com.smartgwt.client.widgets.tab.Tab#getCanEditTitle
     * @see com.smartgwt.client.widgets.tab.TabSet#editTabTitle
     */
    public TextItem getTitleEditor() throws IllegalStateException {
        errorIfNotCreated("titleEditor");
        return TextItem.getOrCreateRef(getAttributeAsJavaScriptObject("titleEditor"));
    }
    

    /**
     * If set, offsets the tab title editor further in from the left-hand edge of the tab, by the number of pixels set in this
     * property.  Note that the editor is always offset to avoid overlapping the endcaps of the tab; this property is applied
     * on top of that  default offset.
     *
     * @param titleEditorLeftOffset New titleEditorLeftOffset value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#setTitleEditorRightOffset
     * @see com.smartgwt.client.widgets.tab.TabSet#setTitleEditorTopOffset
     */
    public void setTitleEditorLeftOffset(Integer titleEditorLeftOffset) {
        setAttribute("titleEditorLeftOffset", titleEditorLeftOffset, true);
    }

    /**
     * If set, offsets the tab title editor further in from the left-hand edge of the tab, by the number of pixels set in this
     * property.  Note that the editor is always offset to avoid overlapping the endcaps of the tab; this property is applied
     * on top of that  default offset.
     *
     * @return Current titleEditorLeftOffset value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#getTitleEditorRightOffset
     * @see com.smartgwt.client.widgets.tab.TabSet#getTitleEditorTopOffset
     */
    public Integer getTitleEditorLeftOffset()  {
        return getAttributeAsInt("titleEditorLeftOffset");
    }
    

    /**
     * Properties for the auto-generated {@link com.smartgwt.client.widgets.tab.TabSet#getTitleEditor titleEditor}. This is the
     * text item we use to edit tab titles in this tabSet.
     *
     * @param titleEditorProperties New titleEditorProperties value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tab.TabSet#setTitleEditor
     * @see com.smartgwt.client.widgets.tab.TabSet#setCanEditTabTitles
     */
    public void setTitleEditorProperties(TextItem titleEditorProperties)  throws IllegalStateException {
        if (titleEditorProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(TabSet.class, "setTitleEditorProperties", "TextItem");
        }                                                                       
        titleEditorProperties.setConfigOnly(true);
        setAttribute("titleEditorProperties", titleEditorProperties == null ? null : titleEditorProperties.getEditorTypeConfig(), false);
    }

    /**
     * Properties for the auto-generated {@link com.smartgwt.client.widgets.tab.TabSet#getTitleEditor titleEditor}. This is the
     * text item we use to edit tab titles in this tabSet.
     *
     * @return Current titleEditorProperties value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#getTitleEditor
     * @see com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles
     */
    public TextItem getTitleEditorProperties()  {
        return TextItem.getOrCreateRef(getAttributeAsJavaScriptObject("titleEditorProperties"));
    }
    

    /**
     * If set, offsets the tab title editor further in from the right-hand edge of the tab, by the number of pixels set in this
     * property.  Note that the editor is always offset to avoid overlapping the endcaps of the tab; this property is applied
     * on top of that  default offset.
     *
     * @param titleEditorRightOffset New titleEditorRightOffset value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#setTitleEditorLeftOffset
     * @see com.smartgwt.client.widgets.tab.TabSet#setTitleEditorTopOffset
     */
    public void setTitleEditorRightOffset(Integer titleEditorRightOffset) {
        setAttribute("titleEditorRightOffset", titleEditorRightOffset, true);
    }

    /**
     * If set, offsets the tab title editor further in from the right-hand edge of the tab, by the number of pixels set in this
     * property.  Note that the editor is always offset to avoid overlapping the endcaps of the tab; this property is applied
     * on top of that  default offset.
     *
     * @return Current titleEditorRightOffset value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#getTitleEditorLeftOffset
     * @see com.smartgwt.client.widgets.tab.TabSet#getTitleEditorTopOffset
     */
    public Integer getTitleEditorRightOffset()  {
        return getAttributeAsInt("titleEditorRightOffset");
    }
    

    /**
     * If set, offsets the tab title editor further down from the top edge of the tab, by the number of pixels set in this
     * property.  You can use this property, together with the  left and right offset properties, to fine tune positioning of
     * the editor within or  around the tab button.<p> <b>Note:</b> The height of the editor is an attribute of the editor
     * itself, and can be set by specifying a "height" property in {@link com.smartgwt.client.widgets.tab.TabSet#getTitleEditor
     * titleEditorDefaults}.
     *
     * @param titleEditorTopOffset New titleEditorTopOffset value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#setTitleEditorLeftOffset
     * @see com.smartgwt.client.widgets.tab.TabSet#setTitleEditorRightOffset
     */
    public void setTitleEditorTopOffset(Integer titleEditorTopOffset) {
        setAttribute("titleEditorTopOffset", titleEditorTopOffset, true);
    }

    /**
     * If set, offsets the tab title editor further down from the top edge of the tab, by the number of pixels set in this
     * property.  You can use this property, together with the  left and right offset properties, to fine tune positioning of
     * the editor within or  around the tab button.<p> <b>Note:</b> The height of the editor is an attribute of the editor
     * itself, and can be set by specifying a "height" property in {@link com.smartgwt.client.widgets.tab.TabSet#getTitleEditor
     * titleEditorDefaults}.
     *
     * @return Current titleEditorTopOffset value. Default value is null
     * @see com.smartgwt.client.widgets.tab.TabSet#getTitleEditorLeftOffset
     * @see com.smartgwt.client.widgets.tab.TabSet#getTitleEditorRightOffset
     */
    public Integer getTitleEditorTopOffset()  {
        return getAttributeAsInt("titleEditorTopOffset");
    }
    
    
    

    /**
     * The size of the tab picker button when {@link com.smartgwt.client.util.Browser#isTouch isTouch} is <code>true</code>.
     *
     * @param touchPickerButtonSize New touchPickerButtonSize value. Default value is 16
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.tab.TabSet#setPickerButtonSize
     */
    public void setTouchPickerButtonSize(int touchPickerButtonSize)  throws IllegalStateException {
        setAttribute("touchPickerButtonSize", touchPickerButtonSize, false);
    }

    /**
     * The size of the tab picker button when {@link com.smartgwt.client.util.Browser#isTouch isTouch} is <code>true</code>.
     *
     * @return Current touchPickerButtonSize value. Default value is 16
     * @see com.smartgwt.client.widgets.tab.TabSet#getPickerButtonSize
     */
    public int getTouchPickerButtonSize()  {
        return getAttributeAsInt("touchPickerButtonSize");
    }
    

    /**
     * Setting this to true turns on a different appearance for tabs, similar to iOS tabs from  the "Music" app, where the
     * tab.icon is enlarged and shown as a black and white mask.   This mode does not support a clickable icon - clicking the
     * enlarged icon just switches  tabs. <P> This attribute only has an effect for tabs that are not {@link
     * com.smartgwt.client.widgets.tab.Tab#getCanClose closable}, and only for Mobile WebKit.
     *
     * @param useIOSTabs New useIOSTabs value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUseIOSTabs(Boolean useIOSTabs)  throws IllegalStateException {
        setAttribute("useIOSTabs", useIOSTabs, false);
    }

    /**
     * Setting this to true turns on a different appearance for tabs, similar to iOS tabs from  the "Music" app, where the
     * tab.icon is enlarged and shown as a black and white mask.   This mode does not support a clickable icon - clicking the
     * enlarged icon just switches  tabs. <P> This attribute only has an effect for tabs that are not {@link
     * com.smartgwt.client.widgets.tab.Tab#getCanClose closable}, and only for Mobile WebKit.
     *
     * @return Current useIOSTabs value. Default value is false
     */
    public Boolean getUseIOSTabs()  {
        Boolean result = getAttributeAsBoolean("useIOSTabs");
        return result == null ? false : result;
    }
    

    /**
     * Should we use simple button based tabs styled with CSS rather than image based {@link
     * com.smartgwt.client.widgets.tab.ImgTab} tabs? <P>   If set to true tabs will instances of {@link
     * com.smartgwt.client.widgets.Button}, styled according to the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getSimpleTabBaseStyle simpleTabBaseStyle}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useSimpleTabs New useSimpleTabs value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUseSimpleTabs(Boolean useSimpleTabs)  throws IllegalStateException {
        setAttribute("useSimpleTabs", useSimpleTabs, false);
    }

    /**
     * Should we use simple button based tabs styled with CSS rather than image based {@link
     * com.smartgwt.client.widgets.tab.ImgTab} tabs? <P>   If set to true tabs will instances of {@link
     * com.smartgwt.client.widgets.Button}, styled according to the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getSimpleTabBaseStyle simpleTabBaseStyle}.
     *
     * @return Current useSimpleTabs value. Default value is false
     */
    public Boolean getUseSimpleTabs()  {
        Boolean result = getAttributeAsBoolean("useSimpleTabs");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
    /**
     * Add a addTabClicked handler.
     * <p>
     * Event that fires when the {@link com.smartgwt.client.widgets.tab.TabSet#getAddTabButton TabSet.addTabButton} is clicked.
     * No default behavior.
     *
     * @param handler the addTabClicked handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addAddTabClickedHandler(com.smartgwt.client.widgets.tab.events.AddTabClickedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tab.events.AddTabClickedEvent.getType()) == 0) setupAddTabClickedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tab.events.AddTabClickedEvent.getType());
    }

    private native void setupAddTabClickedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var addTabClicked = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.tab.events.AddTabClickedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tab.TabSet::handleTearDownAddTabClickedEvent()();
            if (hasDefaultHandler) this.Super("addTabClicked", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("addTabClicked"));
            obj.addProperties({addTabClicked:  addTabClicked              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("addTabClicked"));
            obj.addTabClicked =  addTabClicked             ;
        }
    }-*/;

    private void handleTearDownAddTabClickedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tab.events.AddTabClickedEvent.getType()) == 0) tearDownAddTabClickedEvent();
    }

    private native void tearDownAddTabClickedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("addTabClicked")) delete obj.addTabClicked;
    }-*/;

	/**
     * If the user is currently editing a tab title (see {@link com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles
     * canEditTabTitles}), dismiss the editor and discard the edit value entered by the user.
     */
    public native void cancelTabTitleEditing() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "cancelTabTitleEditing", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancelTabTitleEditing();
    }-*/;

	/**
     * Returns the index of the currently selected tab object.
     *
     * @return the index of the currently selected tab object
     */
    public native int getSelectedTabNumber() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSelectedTabNumber", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedTabNumber();
        return ret;
    }-*/;

    /**
     * Add a closeClick handler.
     * <p>
     * When {@link com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs TabSet.canCloseTabs} is set, this notification method
     * fired when the user clicks  the "close" icon for a tab. Call {@link
     * com.smartgwt.client.widgets.tab.events.TabCloseClickEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.tab.events.CloseClickHandler#onCloseClick} to cancel default behavior of removing the tab
     * from the TabSet
     *
     * @param handler the closeClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCloseClickHandler(com.smartgwt.client.widgets.tab.events.CloseClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tab.events.TabCloseClickEvent.getType()) == 0) setupCloseClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tab.events.TabCloseClickEvent.getType());
    }

    private native void setupCloseClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var onCloseClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.tab.events.TabCloseClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tab.TabSet::handleTearDownCloseClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("onCloseClick"));
            obj.addProperties({onCloseClick: 
                function () {
                    var param = {"_this": this, "tab" : arguments[0]};
                    param.tab = this.getTabObject(arguments[0]);
                    var ret = onCloseClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onCloseClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("onCloseClick"));
            obj.onCloseClick = 
                function () {
                    var param = {"_this": this, "tab" : arguments[0]};
                    param.tab = this.getTabObject(arguments[0]);
                    var ret = onCloseClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("onCloseClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownCloseClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tab.events.TabCloseClickEvent.getType()) == 0) tearDownCloseClickEvent();
    }

    private native void tearDownCloseClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("onCloseClick")) delete obj.onCloseClick;
    }-*/;

	/**
     * Removes the last tab in the TabSet, excluding the {@link com.smartgwt.client.widgets.tab.TabSet#getMoreTab moreTab} if
     * present.
     */
    public native void removeLastTab() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeLastTab", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeLastTab();
    }-*/;

	/**
     * Move a tab to another location in the tabset.
     * @param tab tab to move
     */
    public native void reorderTab(Tab tab) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reorderTab", "Tab");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reorderTab(tab.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

	/**
     * Move a tab to another location in the tabset.
     * @param tab tab to move
     * @param moveToPosition the index to move the tab to - defaults to the end of the                                  tabset if not passed
     */
    public native void reorderTab(Tab tab, int moveToPosition) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reorderTab", "Tab,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reorderTab(tab.@com.smartgwt.client.core.DataClass::getJsObj()(), moveToPosition);
    }-*/;
	
	/**
     * If the user is currently editing a tab title (see {@link com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles
     * canEditTabTitles}), save the edited tab title and hide the editor.
     */
    public native void saveTabTitle() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "saveTabTitle", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveTabTitle();
    }-*/;

	/**
     * If there is not enough space to display all the tabs in this tabSet, this method will  scroll the previous tab (that
     * first tab that is clipped at the beginning of the tab-bar)  into view.
     */
    public native void scrollBack() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scrollBack", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scrollBack();
    }-*/;

	/**
     * If there is not enough space to display all the tabs in this tabSet, this method will  scroll the next tab (that first
     * tab that is clipped at the end of the tab-bar) into view.
     */
    public native void scrollForward() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "scrollForward", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.scrollForward();
    }-*/;

	/**
     * Sets the given tab's {@link com.smartgwt.client.widgets.tab.Tab#getCanClose canClose} property to the boolean parameter
     * canClose. If canClose is null, this will have the effect of causing the tab to fall back on {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanCloseTabs canCloseTabs}.
     * @param tab tab to change
     * @param canClose new value for the tab's canClose property, or null to clear it
     */
    public native void setCanCloseTab(Tab tab, boolean canClose) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setCanCloseTab", "Tab,boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setCanCloseTab(tab.@com.smartgwt.client.core.DataClass::getJsObj()(), canClose);
    }-*/;

	/**
     * Changes the title of the picker menu item of a tab
     * @param tab 
     * @param pickerTitle new title.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public native void setTabPickerTitle(Tab tab, String pickerTitle) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setTabPickerTitle", "Tab,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setTabPickerTitle(tab.@com.smartgwt.client.core.DataClass::getJsObj()(), pickerTitle);
    }-*/;

    /**
     * Add a tabContextMenu handler.
     * <p>
     * Notification fired when the user right-clicks on a tab. Event may be cancelled by returning false
     *
     * @param handler the tabContextMenu handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTabContextMenuHandler(com.smartgwt.client.widgets.tab.events.TabContextMenuHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tab.events.TabContextMenuEvent.getType()) == 0) setupTabContextMenuEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tab.events.TabContextMenuEvent.getType());
    }

    private native void setupTabContextMenuEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var showTabContextMenu = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.tab.events.TabContextMenuEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tab.TabSet::handleTearDownTabContextMenuEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("showTabContextMenu"));
            obj.addProperties({showTabContextMenu: 
                function () {
                    var param = {"_this": this, "tabSet" : arguments[0], "tab" : arguments[1]};
                    var ret = showTabContextMenu(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("showTabContextMenu", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("showTabContextMenu"));
            obj.showTabContextMenu = 
                function () {
                    var param = {"_this": this, "tabSet" : arguments[0], "tab" : arguments[1]};
                    var ret = showTabContextMenu(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("showTabContextMenu", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownTabContextMenuEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tab.events.TabContextMenuEvent.getType()) == 0) tearDownTabContextMenuEvent();
    }

    private native void tearDownTabContextMenuEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("showTabContextMenu")) delete obj.showTabContextMenu;
    }-*/;

    /**
     * Add a tabDeselected handler.
     * <p>
     * Optional handler to fire when a tab is deselected. Calling {@link
     * com.smartgwt.client.widgets.tab.events.TabDeselectedEvent#cancel}  will cancel the new selection, leaving tab
     * <code>ID</code> selected.  As with  {@link com.smartgwt.client.widgets.tab.events.TabSelectedEventl} this method only
     * fires when the tabset is drawn.
     *
     * @param handler the tabDeselected handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTabDeselectedHandler(com.smartgwt.client.widgets.tab.events.TabDeselectedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tab.events.TabDeselectedEvent.getType()) == 0) setupTabDeselectedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tab.events.TabDeselectedEvent.getType());
    }

    private native void setupTabDeselectedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var tabDeselected = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.tab.events.TabDeselectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tab.TabSet::handleTearDownTabDeselectedEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("tabDeselected"));
            obj.addProperties({tabDeselected: 
                function () {
                    var param = {"_this": this, "tabNum" : arguments[0], "tabPane" : arguments[1], "ID" : arguments[2], "tab" : arguments[3], "newTab" : arguments[4], "name" : arguments[5]};
                    var ret = tabDeselected(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("tabDeselected", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("tabDeselected"));
            obj.tabDeselected = 
                function () {
                    var param = {"_this": this, "tabNum" : arguments[0], "tabPane" : arguments[1], "ID" : arguments[2], "tab" : arguments[3], "newTab" : arguments[4], "name" : arguments[5]};
                    var ret = tabDeselected(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("tabDeselected", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownTabDeselectedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tab.events.TabDeselectedEvent.getType()) == 0) tearDownTabDeselectedEvent();
    }

    private native void tearDownTabDeselectedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("tabDeselected")) delete obj.tabDeselected;
    }-*/;

	/**
     * Search for a tab that contains a pane.
     * @param pane pane to show
     *
     * @return tab that contains passed pane
     */
    public native Tab tabForPane(Canvas pane) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "tabForPane", "Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.tabForPane(pane == null ? null : pane.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.tab.Tab::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Add a tabIconClick handler.
     * <p>
     * Method fired when the user clicks the icon for a tab, as specified via {@link
     * com.smartgwt.client.widgets.tab.Tab#getIcon Tab.icon}. <P> Default behavior will fire <code>icon.click()</code> if
     * specified, with two parameters <code>tab</code> (a pointer to the tab object and <code>tabSet</code> a pointer to the
     * tabSet instance.
     *
     * @param handler the tabIconClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTabIconClickHandler(com.smartgwt.client.widgets.tab.events.TabIconClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tab.events.TabClickEvent.getType()) == 0) setupTabIconClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tab.events.TabClickEvent.getType());
    }

    private native void setupTabIconClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var tabIconClick = $entry(function(){
            var param = {"_this": this, "tab" : arguments[0]};
            param.tab = this.getTabObject(arguments[0]);
            var event = @com.smartgwt.client.widgets.tab.events.TabClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tab.TabSet::handleTearDownTabIconClickEvent()();
            if (hasDefaultHandler) this.Super("tabIconClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("tabIconClick"));
            obj.addProperties({tabIconClick:  tabIconClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("tabIconClick"));
            obj.tabIconClick =  tabIconClick             ;
        }
    }-*/;

    private void handleTearDownTabIconClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tab.events.TabClickEvent.getType()) == 0) tearDownTabIconClickEvent();
    }

    private native void tearDownTabIconClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("tabIconClick")) delete obj.tabIconClick;
    }-*/;

    /**
     * Add a tabSelected handler.
     * <p>
     * Notification fired when a tab is selected. Note that this will only fire if  this tabSet is drawn. If a tab is selected
     * before {@link com.smartgwt.client.widgets.Canvas#draw draw}  is called,  {@link
     * com.smartgwt.client.widgets.tab.events.TabSelectedEventl} will fire on <code>draw()</code>.
     *
     * @param handler the tabSelected handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTabSelectedHandler(com.smartgwt.client.widgets.tab.events.TabSelectedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tab.events.TabSelectedEvent.getType()) == 0) setupTabSelectedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tab.events.TabSelectedEvent.getType());
    }

    private native void setupTabSelectedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var tabSelected = $entry(function(){
            var param = {"_this": this, "tabNum" : arguments[0], "tabPane" : arguments[1], "ID" : arguments[2], "tab" : arguments[3], "name" : arguments[4]};
            var event = @com.smartgwt.client.widgets.tab.events.TabSelectedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tab.TabSet::handleTearDownTabSelectedEvent()();
            if (hasDefaultHandler) this.Super("tabSelected", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("tabSelected"));
            obj.addProperties({tabSelected:  tabSelected              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("tabSelected"));
            obj.tabSelected =  tabSelected             ;
        }
    }-*/;

    private void handleTearDownTabSelectedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tab.events.TabSelectedEvent.getType()) == 0) tearDownTabSelectedEvent();
    }

    private native void tearDownTabSelectedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("tabSelected")) delete obj.tabSelected;
    }-*/;

    /**
     * Add a tabsReordered handler.
     * <p>
     * Notification method executed when one or more tabs in the TabSet are reordered.
     *
     * @param handler the tabsReordered handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTabsReorderedHandler(com.smartgwt.client.widgets.tab.events.TabsReorderedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tab.events.TabsReorderedEvent.getType()) == 0) setupTabsReorderedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tab.events.TabsReorderedEvent.getType());
    }

    private native void setupTabsReorderedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var tabsReordered = $entry(function(){
            var param = {"_this": this, "tabCanvas" : arguments[0], "tabIndex" : arguments[1]};
            var event = @com.smartgwt.client.widgets.tab.events.TabsReorderedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tab.TabSet::handleTearDownTabsReorderedEvent()();
            if (hasDefaultHandler) this.Super("tabsReordered", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("tabsReordered"));
            obj.addProperties({tabsReordered:  tabsReordered              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("tabsReordered"));
            obj.tabsReordered =  tabsReordered             ;
        }
    }-*/;

    private void handleTearDownTabsReorderedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tab.events.TabsReorderedEvent.getType()) == 0) tearDownTabsReorderedEvent();
    }

    private native void tearDownTabsReorderedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("tabsReordered")) delete obj.tabsReordered;
    }-*/;

    /**
     * Add a tabTitleChanged handler.
     * <p>
     * This notification method fired when the user changes the title of a tab in this TabSet. This can happen either through
     * user interaction with the UI if  {@link com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles canEditTabTitles} is
     * set, or programmatically if application  code calls {@link com.smartgwt.client.widgets.tab.TabSet#editTabTitle
     * editTabTitle}.<p> Call {@link com.smartgwt.client.widgets.tab.events.TabTitleChangedEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.tab.events.TabTitleChangedHandler#onTabTitleChanged} from this method to cancel the change.
     *
     * @param handler the tabTitleChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTabTitleChangedHandler(com.smartgwt.client.widgets.tab.events.TabTitleChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tab.events.TabTitleChangedEvent.getType()) == 0) setupTabTitleChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tab.events.TabTitleChangedEvent.getType());
    }

    private native void setupTabTitleChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var titleChanged = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.tab.events.TabTitleChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tab.TabSet::handleTearDownTabTitleChangedEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("titleChanged"));
            obj.addProperties({titleChanged: 
                function () {
                    var param = {"_this": this, "newTitle" : arguments[0], "oldTitle" : arguments[1], "tab" : arguments[2]};
                    param.tab = this.getTabObject(arguments[2]);
                    var ret = titleChanged(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("titleChanged", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("titleChanged"));
            obj.titleChanged = 
                function () {
                    var param = {"_this": this, "newTitle" : arguments[0], "oldTitle" : arguments[1], "tab" : arguments[2]};
                    param.tab = this.getTabObject(arguments[2]);
                    var ret = titleChanged(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("titleChanged", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownTabTitleChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tab.events.TabTitleChangedEvent.getType()) == 0) tearDownTabTitleChangedEvent();
    }

    private native void tearDownTabTitleChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("titleChanged")) delete obj.titleChanged;
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
     * @param tabSetProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(TabSet tabSetProperties) /*-{
        if (tabSetProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(TabSet.@java.lang.Object::getClass()(), "setDefaultProperties", tabSetProperties.@java.lang.Object::getClass()());
        }
        tabSetProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = tabSetProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.TabSet.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
    * Specifies the index of the initially selected tab.
    *
    * @param selectedTab selectedTab Default value is 0
    */
    public void setSelectedTab(int selectedTab) {
        setAttribute("selectedTab", selectedTab, true);
    }

    /**
    * An array of {@link com.smartgwt.client.widgets.tab.Tab Tab} objects, specifying the title 
    * and pane contents of each tab in the TabSet.
    * <p>
    * Tab instances are not widgets, they just provide configuration such as title and icon.
    * <p>
    * After providing {@link com.smartgwt.client.widgets.tab.Tab Tab} instances to 
    * <code>setTabs()</code>, the TabSet creates actual UI widgets to serve as interactive 
    * tabs. Any further modifications to tabs should be performed via TabSet APIs such as 
    * {@link com.smartgwt.client.widgets.tab.TabSet#setTabTitle setTabTitle}, 
    * {@link com.smartgwt.client.widgets.tab.TabSet#setTabIcon setTabIcon} and 
    * {@link com.smartgwt.client.widgets.tab.TabSet#setTabPane setTabPane}.
    * <p>
    * You can add and remove tabs after creating the TabSet by calling 
    * {@link com.smartgwt.client.widgets.tab.TabSet#addTab addTab} and 
    * {@link com.smartgwt.client.widgets.tab.TabSet#removeTab removeTab}.
    *
    * @param tabs new tabs for the TabSet
    */
    public void setTabs(Tab... tabs) {
        int tl = getTabs().length;
        int[] tids = new int[tl];
        for (int i = 0; i < tl; i++) {
            tids[i] = i;
        }
        removeTabs(tids);
        for (Tab tab : tabs) {
            addTab(tab);
        }
    }

    native void setTabProperties(Tab tab, JavaScriptObject properties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(),
            tabJS = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setTabProperties(tabJS, properties);
    }-*/;

    /**
     * Properties of the container where the component specified by Tab.pane is shown.
     *
     * @param paneContainerProperties the pane container properties
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPaneContainerProperties(Canvas paneContainerProperties) {
        if (paneContainerProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), 
                                                    "setPaneContainerProperties", "Canvas");
        }                                                                       
        paneContainerProperties.setConfigOnly(true);
        setAttribute("paneContainerProperties", JSOHelper.
                     cleanProperties(paneContainerProperties.getConfig(), true), false);
    }    
    
    /**
     * This property determines what controls should show up after the tabBar for this TabSet.
     *  Standard controls can be included using the strings <code>"tabScroller"</code> and 
     * <code>"tabPicker"</code>. These correspond to the {@link com.smartgwt.client.widgets.tab.TabSet#getScroller scroller}
     * and {@link com.smartgwt.client.widgets.tab.TabSet#getTabPicker tabPicker}
     *  AutoChildren, respectively. The <code>"tabScroller"</code> standard control shows two
     *  buttons for scrolling through the tabs in order and the <code>"tabPicker"</code> standard
     *  control allows tabs to be picked directly from a menu. The standard controls show up only if
     * {@link com.smartgwt.client.widgets.tab.TabSet#getShowTabScroller showTabScroller} or {@link
     * com.smartgwt.client.widgets.tab.TabSet#getShowTabPicker showTabPicker} is true and there is not
     *  enough space available to show all of the tabs in the tabBar.
     *  <P>
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_tabs_custom_controls" target="examples">This
     * sample</a> illustrates the usage of this property
     *  <P>
     *  Additional controls can be included by adding any widget to this array.  Controls will
     *  show up in the order in which they are specified.  For example, the following code would
     *  add a button in the tabBar area, while preserving the normal behavior of the tabScroller
     *  and tabPicker:
     *  
     *  
     *  <pre>
     *   ImgButton addButton = new ImgButton();
     *   addButton.setSrc("[SKINIMG]/actions/add.png");
     *   addButton.setTitle("Add");
     *   addButton.setWidth(16);
     *   addButton.setHeight(16);
     *   addButton.setAlign(Alignment.CENTER);
     *   TabSet ts = new TabSet();
     *   ts.setWidth(300);
     *   ts.setHeight(32);
     *   ts.setTabs(new Tab("Tab one"));
     *   ts.setTabBarControls(addButton, TabBarControls.TAB_SCROLLER, TabBarControls.TAB_PICKER);
     *   contentLayout.addMember(ts);
     *  </pre>
     *  
     *  You can also refer to the default tabPicker/tabScroll controls
     *  from Component XML:
     *  <pre>
     *  &lt;TabSet width="300"&gt; 
     *     &lt;tabBarControls&gt;
     *        &lt;Button title="Custom Button"/&gt;
     *        &lt;value xsi:type="string"&gt;tabPicker&lt;/value&gt;
     *        &lt;value xsi:type="string"&gt;tabScroller&lt;/value&gt;
     *     &lt;/tabBarControls&gt;
     *     &lt;tabs&gt;
     *        &lt;tab title="Foo"/&gt;
     *        &lt;tab title="Bar"/&gt;
     *     &lt;/tabs&gt;
     *  &lt;/TabSet&gt;
     *  </pre>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param tabBarControls tabBarControls Default value is ["tabScroller", "tabPicker"]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTabBarControls(Object... tabBarControls) throws IllegalStateException {
        setAttribute("tabBarControls", tabBarControls, false);
    }

    /**
     * Select a tab.
     *
     * @param tabIndex the tab index
     */
    public native void selectTab(int tabIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectTab(tabIndex);
    }-*/;

    /**
     * Select a tab.
     *
     * @param ID the tab ID
     */
    public native void selectTab(String ID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectTab(ID);
    }-*/;

    /**
     * Select a tab.
     *
     * @param tab the tab
     */
    public native void selectTab(Tab tab) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var tabJS = tab.@com.smartgwt.client.widgets.tab.Tab::getJsObj()();
        self.selectTab(tabJS);
    }-*/;

    /**
     * Changes the title of a tab
     *
     * @param tabIndex the tab index
     * @param title    new title
     */
    public native void setTabTitle(int tabIndex, String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setTabTitle(tabIndex, title);
    }-*/;

    /**
     * Changes the title of a tab
     *
     * @param ID    the tab ID
     * @param title new title
     */
    public native void setTabTitle(String ID, String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setTabTitle(ID, title);
    }-*/;

    /**
     * Changes the title of a tab
     *
     * @param tab   the tab
     * @param title new title
     */
    public native void setTabTitle(Tab tab, String title) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var tabJS = tab.@com.smartgwt.client.widgets.tab.Tab::getJsObj()();
        self.setTabTitle(tabJS, title);
    }-*/;

    /**
     * Changes the icon of a tab
     *
     * @param tabIndex the tab index
     * @param iconURL    new icon
     */
    public native void setTabIcon(int tabIndex, String iconURL) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setTabIcon(tabIndex, iconURL);
    }-*/;

    /**
     * Changes the icon of a tab
     *
     * @param ID    the tab ID
     * @param iconURL new icon
     */
    public native void setTabIcon(String ID, String iconURL) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setTabIcon(ID, iconURL);
    }-*/;

    /**
     * Changes the icon of a tab
     *
     * @param tab   the tab
     * @param iconURL new icon
     */
    public native void setTabIcon(Tab tab, String iconURL) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var tabJS = tab.@com.smartgwt.client.widgets.tab.Tab::getJsObj()();
        self.setTabIcon(tabJS, iconURL);
    }-*/;

    /**
     * If the specified tab is disabled, enable it now.
     *
     * @param tabIndex the tab index
     */
    public native void enableTab(int tabIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.enableTab(tabIndex);
    }-*/;

    /**
     * If the specified tab is disabled, enable it now.
     *
     * @param ID the tab id
     */
    public native void enableTab(String ID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.enableTab(ID);
    }-*/;

    /**
     * If the specified tab is disabled, enable it now.
     *
     * @param tab the tab
     */
    public native void enableTab(Tab tab) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var tabJS = tab.@com.smartgwt.client.widgets.tab.Tab::getJsObj()();
        self.enableTab(tabJS);
    }-*/;

    /**
     * Set the pane for a tab. NOTE: the old pane for the tab is not destroy()d
     *
     * @param tabIndex the tab index
     * @param pane the new pane for the tab
     */
    public native void updateTab(int tabIndex, Canvas pane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var paneJS = pane == null ? null : pane.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.updateTab(tabIndex, paneJS);
    }-*/;

    /**
     * Set the pane for a tab. NOTE: the old pane for the tab is not destroy()d
     *
     * @param tab the tab
     * @param pane the new pane for the tab
     */
    public native void updateTab(Tab tab, Canvas pane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var tabJS = tab.@com.smartgwt.client.widgets.tab.Tab::getJsObj()();
        var paneJS = pane == null ? null : pane.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.updateTab(tabJS, paneJS);
    }-*/;

    /**
     * If the specified tab is enabled, disable it now.
     *
     * @param tabIndex the tab index
     */
    public native void disableTab(int tabIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.disableTab(tabIndex);
    }-*/;

    /**
     * If the specified tab is enabled, disable it now.
     *
     * @param ID the tab id
     */
    public native void disableTab(String ID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.disableTab(ID);
    }-*/;

    /**
     * If the specified tab is enabled, disable it now.
     *
     * @param tab the tab
     */
    public native void disableTab(Tab tab) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var tabJS = tab.@com.smartgwt.client.widgets.tab.Tab::getJsObj()();
        self.disableTab(tabJS);
    }-*/;

    /**
     * Remove a tab. <P> The pane associated with the removed tab is automatically destroyed when you call this method.
     * To avoid this, call {@link com.smartgwt.client.widgets.tab.TabSet#updateTab} with <code>null</code> as the new
     * pane immediately before removing the tab.
     *
     * @param tabIndex the tab index
     */
    public void removeTab(int tabIndex) {
        if (isCreated()) {
            removeTabPostCreate(tabIndex);
        } else {
            removeTabPreCreate(tabIndex);
        }
    }

    private native void removeTabPostCreate(int tabIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeTab(tabIndex);
    }-*/;
    
    private native void removeTabPreCreate(int tabIndex) /*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
        if(!config.tabs) {
            config.tabs = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        config.tabs.splice(tabIndex, 1);
    }-*/;
    
    /**
     * Remove a tab. <P> The pane associated with the removed tab is automatically destroyed when you call this method.
     * To avoid this, call {@link com.smartgwt.client.widgets.tab.TabSet#updateTab} with <code>null</code> as the new
     * pane immediately before removing the tab.
     *
     * @param ID the tabID
     */
    public void removeTab(String ID) {
        if (isCreated()) {
            removeTabPostCreate(ID);
        } else {
            removeTabPreCreate(ID);
        }
    }

    private native void removeTabPreCreate(String ID) /*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
        if(!config.tabs) {
            config.tabs = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        for (var i = 0; i < config.tabs.length; i++) {
            if (config.tabs[i].ID == ID) {
                config.tabs.splice(i, 1);
                return;
            }
        }
    }-*/;

    private native void removeTabPostCreate(String ID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeTab(ID);
    }-*/;

    /**
     * Remove a tab. <P> The pane associated with the removed tab is automatically destroyed when you call this method.
     * To avoid this, call {@link com.smartgwt.client.widgets.tab.TabSet#updateTab} with <code>null</code> as the new
     * pane immediately before removing the tab.
     *
     * @param tab the tab
     */
    public void removeTab(Tab tab) {
        if (isCreated()) {
            removeTabPostCreate(tab);
        } else {
            removeTabPreCreate(tab);
        }
    }

    private native void removeTabPreCreate(Tab tab) /*-{
        var tabJS = tab.@com.smartgwt.client.widgets.tab.Tab::getJsObj()();
        var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
        if(!config.tabs) {
            config.tabs = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        for (var i = 0; i < config.tabs.length; i++) {
            if (config.tabs[i] == tabJS) {
                config.tabs.splice(i, 1);
                return;
            }
        }
    }-*/;

    private native void removeTabPostCreate(Tab tab) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var tabJS = tab.@com.smartgwt.client.widgets.tab.Tab::getJsObj()();
        self.removeTab(tabJS);
    }-*/;

    /**
     * Remove one or more tabs.  The pane(s) associated with the removed tab(s) is automatically destroyed when you call
     * this method.
     *
     * @param tabIndexes the tab indexes
     */
    public void removeTabs(int[] tabIndexes) {
        if (isCreated()) {
            removeTabsPostCreate(tabIndexes);
        } else {
            removeTabsPreCreate(tabIndexes);
        }
    }

    private native void removeTabsPostCreate(int[] tabIndexes) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var tabs = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(tabIndexes);
        self.removeTab(tabs);
    }-*/;
    
    private native void removeTabsPreCreate(int[] tabIndexes) /*-{
        var tabs = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(tabIndexes);
        var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
        if(!config.tabs) {
            config.tabs = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        var newTabs = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        for (var i = 0; i < config.tabs.length; i++) {
            if (tabs.indexOf(i) == -1) {
                newTabs.push(config.tabs[i]);
            }
        }
        config.tabs = newTabs;
    }-*/;

    /**
     * Remove one or more tabs.  The pane(s) associated with the removed tab(s) is automatically destroyed when you call
     * this method.
     *
     * @param ids the tabIDs
     */
    public void removeTabs(String[] ids) {
        if (isCreated()) {
            removeTabsPostCreate(ids);
        } else {
            removeTabsPreCreate(ids);
        }
    }

    private native void removeTabsPostCreate(String[] ids) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var tabs = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(ids);
        self.removeTab(tabs);
    }-*/;

    private native void removeTabsPreCreate(String[] ids) /*-{
        var tabs = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(ids);
        var config = this.@com.smartgwt.client.widgets.BaseWidget::config;
        if(!config.tabs) {
            config.tabs = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        for (var i = 0; i < ids.length; i++) {
            for (var j = 0; j < config.tabs.length; j++) {
                if (config.tabs[j].ID == ids[i]) {
                    config.tabs.splice(j, 1);
                    break;
                }
            }
        }
    }-*/;

    /**
     * The currently selected tab.
     *
     * @return the currently selected Tab
     */
    public native Tab getSelectedTab() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSelectedTab();
        return ret == null ? null : @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Get the live Canvas representing a tab by index.
     * * The underlying SmartClient class of the returned canvas depends on {@link #getUseSimpleTabs}.
     * If this property is false, the returned canvas will be a {@link com.smartgwt.client.widgets.tab.ImgTab}
     * instance. If true the canvas will be a {@link com.smartgwt.client.widgets.tab.Button} instance.
     * Note that you can make use of ImgTab APIs by using the <code>getJsObj()</code> and <code>create()</code>
     * APIs to "cast" to the appropriate type - for example:<br>
     * <code>ImgTab liveTab = ImgTab.create(myTabSet.getTabCanvas(2).getJsObj());</code>
     * <P>
     * Note that live Tab instances are not available until {@link com.smartgwt.client.widgets.Canvas#draw}.
     * <P>
     * <b>Note that this is an advanced method.</b> The returned Tab is considered an internal component of
     * the TabSet.  In order to maximize forward compatibility, wherever possible manipulate tabs
     * through TabSet APIs such as a {@link com.smartgwt.client.widgets.tab.TabSet#setTabTitle} instead of
     * modifying them directly.
     *
     * @param tab
     * @return the tab Canvas, or null if not found or TabSet not drawn yet
     */
    public native StatefulCanvas getTabCanvas(int tabIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getTab(tabIndex);
        return ret == null ? null : @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Get the live Canvas representing a tab by index.
     * The underlying SmartClient class of the returned canvas depends on {@link #getUseSimpleTabs}.
     * If this property is false, the returned canvas will be a {@link com.smartgwt.client.widgets.tab.ImgTab}
     * instance. If true the canvas will be a {@link com.smartgwt.client.widgets.tab.Button} instance.
     * Note that you can make use of ImgTab APIs by using the <code>getJsObj()</code> and <code>create()</code>
     * APIs to "cast" to the appropriate type - for example:<br>
     * <code>ImgTab liveTab = ImgTab.create(myTabSet.getTabCanvas(2).getJsObj());</code>
     * <P>
     * Note that live Tab instances are not available until {@link com.smartgwt.client.widgets.Canvas#draw}.
     * <P>
     * <b>Note that this is an advanced method.</b> The returned Tab is considered an internal component of
     * the TabSet.  In order to maximize forward compatibility, wherever possible manipulate tabs
     * through TabSet APIs such as a {@link com.smartgwt.client.widgets.tab.TabSet#setTabTitle} instead of
     * modifying them directly.
     *
     * @param tab
     * @return the tab Canvas, or null if not found or TabSet not drawn yet
     */
    public native StatefulCanvas getTabCanvas(String ID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getTab(ID);
        return ret == null ? null : @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Retrieves a Tab definition from within this tabSet by index.
     * 
     * @param index of tab to retrieve
     * @return the tab definition
     */
    public native Tab getTab(int tabIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getTabObject(tabIndex);
        return this.@com.smartgwt.client.widgets.tab.TabSet::getTabFromJS(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
    
    private Tab getTabFromJS(JavaScriptObject tabObject) {
   		if (tabObject == null) return null;
   		Tab ret =  (Tab) com.smartgwt.client.core.RefDataClass.getRef(tabObject);
   		if (ret == null) ret = new com.smartgwt.client.widgets.tab.Tab(tabObject);
   		return ret;
    }

    /**
     * Retrieves a Tab definition from within this tabSet by ID.
     * 
     * @param ID of tab to retrieve
     * @return the tab definition
     */
    public native Tab getTab(String ID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getTabObject(ID);
        return this.@com.smartgwt.client.widgets.tab.TabSet::getTabFromJS(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
    /**
     * Get the index of a tab from the tabID.
     *
     * @param ID the tab ID
     * @return  the index of the tab, or -1 if not found
     */
    public native int getTabNumber(String ID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getTabNumber(ID);
    }-*/;

    /**
     * Add a tab
     *
     * @param tab new tab
     */
    public void addTab(Tab tab) {
        tab.setTabSet(this);
        JavaScriptObject tabJS = tab.getJsObj();

        if (isCreated()) {
            addTabPostCreate(tabJS);

        } else {
            addTabPreCreate(tabJS);
        }
    }

    private native void addTabPreCreate(JavaScriptObject tabJS) /*-{
		var config = this.@com.smartgwt.client.widgets.BaseWidget::config;

        if(!config.tabs) {
            config.tabs = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        config.tabs.push(tabJS);
    }-*/;

    private native void addTabPostCreate(JavaScriptObject tabJS) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.addTab(tabJS);
    }-*/;

    /**
     * Add a tab
     *
     * @param tab new tab
     * @param position the position where tab should be added
     */
    public void addTab(Tab tab, int position) {
        tab.setTabSet(this);
        JavaScriptObject tabJS = tab.getJsObj();

        if (isCreated()) {
            addTabPostCreate(tabJS, position);

        } else {
            addTabPreCreate(tabJS, position);
        }
    }

    private native void addTabPreCreate(JavaScriptObject tabJS, int position) /*-{
		var config = this.@com.smartgwt.client.widgets.BaseWidget::config;

        if(!config.tabs) {
            config.tabs = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        config.tabs.splice(position, 0, tabJS);
    }-*/;

    private native void addTabPostCreate(JavaScriptObject tabJS, int position) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.addTab(tabJS, position);
    }-*/;

    /**
     * The number of tabs
     *
     * @return the number of tabs
     */
    public native int getNumTabs()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.tabs.length;
    }-*/;


    /**
     * The event that triggers title editing on this TabSet.
     *
     * @param titleEditEvent titleEditEvent Default value is "doubleClick"
     * @see com.smartgwt.client.widgets.tab.TabSet#setCanEditTabTitles
     * @see com.smartgwt.client.widgets.tab.Tab#setCanEditTitle
     */
    public void setTitleEditEvent(TabTitleEditEvent titleEditEvent) {
        setAttribute("titleEditEvent", titleEditEvent.getValue(), true);
    }

    /**
     * The event that triggers title editing on this TabSet.
     *
     *
     * @return TabTitleEditEvent
     * @see com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles
     * @see com.smartgwt.client.widgets.tab.Tab#getCanEditTitle
     */
    public TabTitleEditEvent getTitleEditEvent()  {
        String event = getAttribute("titleEditEvent");
        return event == "click" ? TabTitleEditEvent.CLICK : TabTitleEditEvent.DOUBLECLICK;
    }


    /**
     * Places an editor in the title of the parameter tab and allows the user to edit the title. Note that this programmatic
     * method will <b.always</b> allow editing of the specified tab's title, regardless of the settings of {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles canEditTabTitles} or {@link
     * com.smartgwt.client.widgets.tab.Tab#getCanEditTitle canEditTitle}.
     * @param tab The tab whose title should be edited (may be   specified by ID or index)
     */
    public native void editTabTitle(String tab) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editTabTitle(tab);
    }-*/;

    /**
     * Places an editor in the title of the parameter tab and allows the user to edit the title. Note that this programmatic
     * method will <b.always</b> allow editing of the specified tab's title, regardless of the settings of {@link
     * com.smartgwt.client.widgets.tab.TabSet#getCanEditTabTitles canEditTabTitles} or {@link
     * com.smartgwt.client.widgets.tab.Tab#getCanEditTitle canEditTitle}.
     * @param tab The tab whose title should be edited (may be   specified by ID or index)
     */
    public native void editTabTitle(int tab) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editTabTitle(tab);
    }-*/;


    /**
     * The tabs
     *
     * @return the tabs
     */
    public Tab[] getTabs() {
        return com.smartgwt.client.util.ConvertTo.arrayOfTab(getAttributeAsJavaScriptObject("tabs"));
    }

    /**
     * This attribute allows developers to specify custom properties for this tabset's {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBar tabBar}
     *
     * @param tabBarProperties tabBarProperties Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTabBarProperties(TabBar tabBarProperties)  throws IllegalStateException {
        if (tabBarProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setTabBarProperties",
                                                    "TabBar");
        }                                                                       
        tabBarProperties.setConfigOnly(true);
        setAttribute("tabBarProperties", tabBarProperties == null ? null : 
                     JSOHelper.cleanProperties(tabBarProperties.getConfig(), true), false);
    }


    /**
     * Apply a new {@link com.smartgwt.client.widgets.tab.Tab#getPane pane} to an existing tab in this tabSet
     * @param tabIndex Tab to update
     * @param pane new Pane for the tab. pass null to drop existing pane
     */
    public native void setTabPane(int tabIndex, Canvas pane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setTabPane(tabIndex, pane == null ? null : pane.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * Apply a new {@link com.smartgwt.client.widgets.tab.Tab#getPane pane} to an existing tab in this tabSet
     * @param tabID Tab to update
     * @param pane new Pane for the tab. pass null to drop existing pane
     */
    public native void setTabPane(String tabID, Canvas pane) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setTabPane(tabID, pane == null ? null : pane.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * Preload primary tab skin images.
     */
    public static native void preloadImages() /*-{
        var imgTabSkinImgDir = $wnd.isc.ImgTab.getInstanceProperty('skinImgDir') + 'top/';
        if($wnd.isc.ImgTab.getInstanceProperty('src')) {
            var src = $wnd.isc.ImgTab.getInstanceProperty('src');
            @com.smartgwt.client.util.FileLoader::cacheStretchImgStates(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)(imgTabSkinImgDir, src, "Selected,Over");
        }
    }-*/;
    
	/**
     * Reveals the child Canvas passed in by selecting the tab containing that child if it is not already selected.  If no tab
     * in this TabSet contains the passed-in Canvas, this method has  no effect<p>
     * <b>NOTE: This is an override point.</b>
     * @param childID the global ID of the child Canvas to reveal
     */
     public native void revealChild(String childID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.__revealChild(childID);
    }-*/;
    
	/**
     * Reveals the child Canvas passed in by selecting the tab containing that child if it is not already selected.  If no tab
     * in this TabSet contains the passed-in Canvas, this method has  no effect<p>
     * <b>NOTE: This is an override point.</b>
     * @param child the child Canvas to reveal
     */
    public native void revealChild(Canvas child) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var childJS = child == null ? null : child.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        self.__revealChild(childJS);
    }-*/;


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(TabSetLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.addTabButtonIcon = getAttributeAsString("addTabButtonIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.addTabButtonIcon:" + t.getMessage() + "\n";
        }
        try {
            s.animateTabScrolling = getAttributeAsString("animateTabScrolling");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.animateTabScrolling:" + t.getMessage() + "\n";
        }
        try {
            s.ariaCloseableSuffix = getAttributeAsString("ariaCloseableSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.ariaCloseableSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.canAddTabs = getAttributeAsString("canAddTabs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.canAddTabs:" + t.getMessage() + "\n";
        }
        try {
            s.canCloseTabs = getAttributeAsString("canCloseTabs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.canCloseTabs:" + t.getMessage() + "\n";
        }
        try {
            s.canEditTabTitles = getAttributeAsString("canEditTabTitles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.canEditTabTitles:" + t.getMessage() + "\n";
        }
        try {
            s.canReorderTabs = getAttributeAsString("canReorderTabs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.canReorderTabs:" + t.getMessage() + "\n";
        }
        try {
            s.closeTabIcon = getAttributeAsString("closeTabIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.closeTabIcon:" + t.getMessage() + "\n";
        }
        try {
            s.closeTabIconSize = getAttributeAsString("closeTabIconSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.closeTabIconSize:" + t.getMessage() + "\n";
        }
        try {
            s.defaultTabHeight = getAttributeAsString("defaultTabHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.defaultTabHeight:" + t.getMessage() + "\n";
        }
        try {
            s.defaultTabWidth = getAttributeAsString("defaultTabWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.defaultTabWidth:" + t.getMessage() + "\n";
        }
        try {
            s.destroyPanes = getAttributeAsString("destroyPanes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.destroyPanes:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.locateTabsBy = getAttributeAsString("locateTabsBy");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.locateTabsBy:" + t.getMessage() + "\n";
        }
        try {
            s.moreTabCount = getAttributeAsString("moreTabCount");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.moreTabCount:" + t.getMessage() + "\n";
        }
        try {
            s.moreTabImage = getAttributeAsString("moreTabImage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.moreTabImage:" + t.getMessage() + "\n";
        }
        try {
            s.moreTabTitle = getAttributeAsString("moreTabTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.moreTabTitle:" + t.getMessage() + "\n";
        }
        try {
            s.paneContainerClassName = getAttributeAsString("paneContainerClassName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.paneContainerClassName:" + t.getMessage() + "\n";
        }
        try {
            s.paneContainerOverflow = getAttributeAsString("paneContainerOverflow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.paneContainerOverflow:" + t.getMessage() + "\n";
        }
        try {
            s.paneMargin = getAttributeAsString("paneMargin");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.paneMargin:" + t.getMessage() + "\n";
        }
        try {
            s.pickerButtonHSrc = getAttributeAsString("pickerButtonHSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.pickerButtonHSrc:" + t.getMessage() + "\n";
        }
        try {
            s.pickerButtonSize = getAttributeAsString("pickerButtonSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.pickerButtonSize:" + t.getMessage() + "\n";
        }
        try {
            s.pickerButtonSrc = getAttributeAsString("pickerButtonSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.pickerButtonSrc:" + t.getMessage() + "\n";
        }
        try {
            s.pickerButtonVSrc = getAttributeAsString("pickerButtonVSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.pickerButtonVSrc:" + t.getMessage() + "\n";
        }
        try {
            s.scrollerButtonSize = getAttributeAsString("scrollerButtonSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.scrollerButtonSize:" + t.getMessage() + "\n";
        }
        try {
            s.scrollerHSrc = getAttributeAsString("scrollerHSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.scrollerHSrc:" + t.getMessage() + "\n";
        }
        try {
            s.scrollerSrc = getAttributeAsString("scrollerSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.scrollerSrc:" + t.getMessage() + "\n";
        }
        try {
            s.scrollerVSrc = getAttributeAsString("scrollerVSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.scrollerVSrc:" + t.getMessage() + "\n";
        }
        try {
            s.selectedTabAsTab = getSelectedTab();
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.selectedTabAsTab:" + t.getMessage() + "\n";
        }
        try {
            s.selectedTabAsString = getAttributeAsString("selectedTab");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.selectedTabAsString:" + t.getMessage() + "\n";
        }
        try {
            s.showMoreTab = getAttributeAsString("showMoreTab");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.showMoreTab:" + t.getMessage() + "\n";
        }
        try {
            s.showPaneContainerEdges = getAttributeAsString("showPaneContainerEdges");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.showPaneContainerEdges:" + t.getMessage() + "\n";
        }
        try {
            s.showPartialEdges = getAttributeAsString("showPartialEdges");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.showPartialEdges:" + t.getMessage() + "\n";
        }
        try {
            s.showTabBar = getAttributeAsString("showTabBar");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.showTabBar:" + t.getMessage() + "\n";
        }
        try {
            s.showTabPicker = getAttributeAsString("showTabPicker");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.showTabPicker:" + t.getMessage() + "\n";
        }
        try {
            s.showTabScroller = getAttributeAsString("showTabScroller");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.showTabScroller:" + t.getMessage() + "\n";
        }
        try {
            s.simpleTabBaseStyle = getAttributeAsString("simpleTabBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.simpleTabBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.simpleTabIconOnlyBaseStyle = getAttributeAsString("simpleTabIconOnlyBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.simpleTabIconOnlyBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.skinImgDir = getAttributeAsString("skinImgDir");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.skinImgDir:" + t.getMessage() + "\n";
        }
        try {
            s.symmetricEdges = getAttributeAsString("symmetricEdges");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.symmetricEdges:" + t.getMessage() + "\n";
        }
        try {
            s.symmetricPickerButton = getAttributeAsString("symmetricPickerButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.symmetricPickerButton:" + t.getMessage() + "\n";
        }
        try {
            s.symmetricScroller = getAttributeAsString("symmetricScroller");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.symmetricScroller:" + t.getMessage() + "\n";
        }
        try {
            s.tabBarAlignAsString = getAttributeAsString("tabBarAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.tabBarAlignAsString:" + t.getMessage() + "\n";
        }
        try {
            s.tabBarControls = getAttributeAsString("tabBarControls");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.tabBarControls:" + t.getMessage() + "\n";
        }
        try {
            s.tabBarPosition = getAttributeAsString("tabBarPosition");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.tabBarPosition:" + t.getMessage() + "\n";
        }
        try {
            s.tabBarThickness = getAttributeAsString("tabBarThickness");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.tabBarThickness:" + t.getMessage() + "\n";
        }
        try {
            s.tabs = getTabs();
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.tabsArray:" + t.getMessage() + "\n";
        }
        try {
            s.titleEditEvent = getAttributeAsString("titleEditEvent");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.titleEditEvent:" + t.getMessage() + "\n";
        }
        try {
            s.titleEditorLeftOffset = getAttributeAsString("titleEditorLeftOffset");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.titleEditorLeftOffset:" + t.getMessage() + "\n";
        }
        try {
            s.titleEditorRightOffset = getAttributeAsString("titleEditorRightOffset");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.titleEditorRightOffset:" + t.getMessage() + "\n";
        }
        try {
            s.titleEditorTopOffset = getAttributeAsString("titleEditorTopOffset");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.titleEditorTopOffset:" + t.getMessage() + "\n";
        }
        try {
            s.touchPickerButtonSize = getAttributeAsString("touchPickerButtonSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.touchPickerButtonSize:" + t.getMessage() + "\n";
        }
        try {
            s.useIOSTabs = getAttributeAsString("useIOSTabs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.useIOSTabs:" + t.getMessage() + "\n";
        }
        try {
            s.useSimpleTabs = getAttributeAsString("useSimpleTabs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TabSet.useSimpleTabs:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        TabSetLogicalStructure s = new TabSetLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
