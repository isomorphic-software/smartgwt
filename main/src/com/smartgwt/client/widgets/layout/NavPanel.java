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
 * Provides a list or tree of {@link com.smartgwt.client.widgets.layout.NavItem navigation items}, each of which specifies
 * a component to be displayed in a mutually exclusive fashion in the {@link
 * com.smartgwt.client.widgets.layout.NavPanel#getNavDeck navDeck}. <p> A NavPanel can either have a flat list of
 * <code>NavItems</code> or a hierarchy via {@link com.smartgwt.client.widgets.layout.NavItem#getItems NavItem.items} - use
 * {@link com.smartgwt.client.widgets.layout.NavPanel#getIsTree isTree} to explicitly control this. <p> Because NavPanel
 * extends {@link com.smartgwt.client.widgets.layout.SplitPane}, it automatically shifts between side-by-side vs single
 * panel display on handset-sized devices.  Specifically, the {@link com.smartgwt.client.widgets.layout.NavPanel#getNavGrid
 * navGrid} is set as the {@link com.smartgwt.client.widgets.layout.SplitPane#getNavigationPane SplitPane.navigationPane}
 * and the {@link com.smartgwt.client.widgets.layout.NavPanel#getNavDeck navDeck} is set as the {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane SplitPane.detailPane}. <p> Note that <code>NavPanel</code> is
 * a fairly simple component to replicate by composing other Smart GWT widgets.  If you need a component that looks roughly
 * like a <code>NavPanel</code> but will require lots of visual and behavioral customization, consider using the underlying
 * components directly instead of deeply customizing the <code>NavPanel</code> class.  A <code>NavPanel</code> is
 * essentially just a {@link com.smartgwt.client.widgets.tree.TreeGrid} and {@link com.smartgwt.client.widgets.layout.Deck}
 * in a {@link com.smartgwt.client.widgets.layout.SplitPane}, with a {@link
 * com.smartgwt.client.widgets.grid.ListGrid#recordClick recordClick} handler to call {@link
 * com.smartgwt.client.widgets.layout.Deck#setCurrentPane Deck.setCurrentPane()} with a component ID stored as an attribute
 * of each Record.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("NavPanel")
public class NavPanel extends SplitPane {

    public static NavPanel getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new NavPanel(jsObj);
        } else {
            assert refInstance instanceof NavPanel;
            return (NavPanel)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(NavPanel.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.NavPanel.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(NavPanel.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.NavPanel.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public NavPanel(){
        scClassName = "NavPanel";
    }

    public NavPanel(JavaScriptObject jsObj){
        scClassName = "NavPanel";
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
     * The current {@link com.smartgwt.client.widgets.layout.NavItem} whose {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane pane} is showing in the {@link
     * com.smartgwt.client.widgets.layout.NavPanel#getNavDeck navDeck}.  This must be an item of this <code>NavPanel</code> if
     * set.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.NavPanel#getCurrentItem currentItem}.  Note that {@link com.smartgwt.client.widgets.layout.NavPanel#getCurrentItemId currentItemId} is also updated by this setter.
     *
     * @param currentItem the new <code>currentItem</code>.  May be <code>null</code> to hide the current item.  If <code>newCurrentItem</code> is
     * a separator or header item, then setCurrentItem() has no effect. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavPanel NavPanel} instance, for chaining setter calls
     */
    public NavPanel setCurrentItem(NavItem currentItem) {
        return (NavPanel)setAttribute("currentItem", currentItem == null ? null : currentItem.getJsObj(), true);
    }

    /**
     * The current {@link com.smartgwt.client.widgets.layout.NavItem} whose {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane pane} is showing in the {@link
     * com.smartgwt.client.widgets.layout.NavPanel#getNavDeck navDeck}.  This must be an item of this <code>NavPanel</code> if
     * set.
     *
     * @return Current currentItem value. Default value is null
     */
    public NavItem getCurrentItem()  {
        return new NavItem(getAttributeAsJavaScriptObject("currentItem"));
    }
    

    /**
     * The ID of the current {@link com.smartgwt.client.widgets.layout.NavItem} whose {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane pane} is showing in the {@link
     * com.smartgwt.client.widgets.layout.NavPanel#getNavDeck navDeck}.  The <code>NavItem</code> must be an item of this
     * <code>NavPanel</code> if set. <p> The ID of a <code>NavItem</code> is the item's {@link
     * com.smartgwt.client.widgets.layout.NavItem#getId NavItem.id} if set; otherwise, it is the ID of the item's {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane NavItem.pane}, though <code>currentItemId</code> may be initialized
     * to either identifier.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.layout.NavPanel#getCurrentItemId currentItemId}.  Note that {@link com.smartgwt.client.widgets.layout.NavPanel#getCurrentItem currentItem} is also updated by this setter and <code>this.currentItemId</code> may be normalized to a different identifier.
     *
     * @param currentItemId the ID of the new current item, which may be either the item's {@link com.smartgwt.client.widgets.layout.NavItem#getId
     * NavItem.id} or the ID of the item's {@link com.smartgwt.client.widgets.layout.NavItem#getPane NavItem.pane}.  May be
     * <code>null</code> or an empty string to hide the current item.  If the item with ID <code>newCurrentItemId</code> is a
     * separator or header item, then setCurrentItemId() has no effect. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavPanel NavPanel} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public NavPanel setCurrentItemId(String currentItemId) {
        return (NavPanel)setAttribute("currentItemId", currentItemId, true);
    }

    /**
     * The ID of the current {@link com.smartgwt.client.widgets.layout.NavItem} whose {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane pane} is showing in the {@link
     * com.smartgwt.client.widgets.layout.NavPanel#getNavDeck navDeck}.  The <code>NavItem</code> must be an item of this
     * <code>NavPanel</code> if set. <p> The ID of a <code>NavItem</code> is the item's {@link
     * com.smartgwt.client.widgets.layout.NavItem#getId NavItem.id} if set; otherwise, it is the ID of the item's {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane NavItem.pane}, though <code>currentItemId</code> may be initialized
     * to either identifier.
     *
     * @return Current currentItemId value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public String getCurrentItemId()  {
        return getAttributeAsString("currentItemId");
    }
    

    /**
     * Select the first {@link com.smartgwt.client.widgets.layout.NavItem} on initialization if neither {@link
     * com.smartgwt.client.widgets.layout.NavPanel#getCurrentItemId currentItemId} nor {@link
     * com.smartgwt.client.widgets.layout.NavPanel#getCurrentItem currentItem} are provided.
     *
     * @param defaultToFirstItem New defaultToFirstItem value. Default value is false
     * @return {@link com.smartgwt.client.widgets.layout.NavPanel NavPanel} instance, for chaining setter calls
     */
    public NavPanel setDefaultToFirstItem(Boolean defaultToFirstItem) {
        return (NavPanel)setAttribute("defaultToFirstItem", defaultToFirstItem, true);
    }

    /**
     * Select the first {@link com.smartgwt.client.widgets.layout.NavItem} on initialization if neither {@link
     * com.smartgwt.client.widgets.layout.NavPanel#getCurrentItemId currentItemId} nor {@link
     * com.smartgwt.client.widgets.layout.NavPanel#getCurrentItem currentItem} are provided.
     *
     * @return Current defaultToFirstItem value. Default value is false
     */
    public Boolean getDefaultToFirstItem()  {
        Boolean result = getAttributeAsBoolean("defaultToFirstItem");
        return result == null ? false : result;
    }
    

    /**
     * CSS style used when {@link com.smartgwt.client.widgets.layout.NavItem#getIsHeader NavItem.isHeader} is set on an item.
     * May be overridden for a specific header item by {@link com.smartgwt.client.widgets.layout.NavItem#getCustomStyle
     * NavItem.customStyle}.
     *
     * @param headerStyle New headerStyle value. Default value is "navItemHeader"
     * @return {@link com.smartgwt.client.widgets.layout.NavPanel NavPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public NavPanel setHeaderStyle(String headerStyle)  throws IllegalStateException {
        return (NavPanel)setAttribute("headerStyle", headerStyle, false);
    }

    /**
     * CSS style used when {@link com.smartgwt.client.widgets.layout.NavItem#getIsHeader NavItem.isHeader} is set on an item.
     * May be overridden for a specific header item by {@link com.smartgwt.client.widgets.layout.NavItem#getCustomStyle
     * NavItem.customStyle}.
     *
     * @return Current headerStyle value. Default value is "navItemHeader"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getHeaderStyle()  {
        return getAttributeAsString("headerStyle");
    }
    

    /**
     * Whether the {@link com.smartgwt.client.widgets.layout.NavItem}s form a {@link com.smartgwt.client.widgets.tree.Tree} or
     * are just a flat list.  If <code>isTree</code> is false, {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpener
     * TreeGrid.showOpener} will be set false on the {@link com.smartgwt.client.widgets.layout.NavPanel#getNavGrid navGrid} so
     * that space isn't wasted. <p> The setting for <code>isTree</code> is defaulted immediately before initial draw, based on
     * whether any {@link com.smartgwt.client.widgets.layout.NavItem} has a list of subitems specified via {@link
     * com.smartgwt.client.widgets.layout.NavItem#getItems NavItem.items}. If no {@link
     * com.smartgwt.client.widgets.layout.NavItem}s are provided before draw, <code>isTree</code> defaults to
     * <code>true</code>. Auto-detection is never attempted again even if all <code>NavItems</code> are replaced. <p> Set
     * <code>isTree</code> explicitly if auto-detection doesn't yield the correct result for your application.
     *
     * @param isTree New isTree value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavPanel NavPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public NavPanel setIsTree(Boolean isTree)  throws IllegalStateException {
        return (NavPanel)setAttribute("isTree", isTree, false);
    }

    /**
     * Whether the {@link com.smartgwt.client.widgets.layout.NavItem}s form a {@link com.smartgwt.client.widgets.tree.Tree} or
     * are just a flat list.  If <code>isTree</code> is false, {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowOpener
     * TreeGrid.showOpener} will be set false on the {@link com.smartgwt.client.widgets.layout.NavPanel#getNavGrid navGrid} so
     * that space isn't wasted. <p> The setting for <code>isTree</code> is defaulted immediately before initial draw, based on
     * whether any {@link com.smartgwt.client.widgets.layout.NavItem} has a list of subitems specified via {@link
     * com.smartgwt.client.widgets.layout.NavItem#getItems NavItem.items}. If no {@link
     * com.smartgwt.client.widgets.layout.NavItem}s are provided before draw, <code>isTree</code> defaults to
     * <code>true</code>. Auto-detection is never attempted again even if all <code>NavItems</code> are replaced. <p> Set
     * <code>isTree</code> explicitly if auto-detection doesn't yield the correct result for your application.
     *
     * @return Current isTree value. Default value is null
     */
    public Boolean getIsTree()  {
        return getAttributeAsBoolean("isTree");
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.layout.Deck} area where components specified via {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane NavItem.pane} are displayed.
     * <p>
     * This component is an AutoChild named "navDeck".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current navDeck value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Deck getNavDeck() throws IllegalStateException {
        errorIfNotCreated("navDeck");
        return (Deck)Deck.getByJSObject(getAttributeAsJavaScriptObject("navDeck"));
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.tree.TreeGrid} used to display {@link
     * com.smartgwt.client.widgets.layout.NavItem}s.
     * <p>
     * This component is an AutoChild named "navGrid".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current navGrid value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public TreeGrid getNavGrid() throws IllegalStateException {
        errorIfNotCreated("navGrid");
        return (TreeGrid)TreeGrid.getByJSObject(getAttributeAsJavaScriptObject("navGrid"));
    }
    

    /**
     * Top-level navigation items to display.  You can optionally specify a tree of items using {@link
     * com.smartgwt.client.widgets.layout.NavItem#getItems NavItem.items}. <p> A separator between navigation items can be
     * created by setting {@link com.smartgwt.client.widgets.layout.NavItem#getIsSeparator NavItem.isSeparator}, and a header
     * can be created via {@link com.smartgwt.client.widgets.layout.NavItem#getIsHeader NavItem.isHeader}. <p> Each
     * non-separator and non-header <code>NavItem</code> specifies a component to be displayed in the {@link
     * com.smartgwt.client.widgets.layout.NavPanel#getNavDeck navDeck} via {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane NavItem.pane}. <p> <code>NavItem</code>s can also be individually
     * styled via {@link com.smartgwt.client.widgets.grid.ListGridRecord#get_baseStyle ListGridRecord._baseStyle} or {@link
     * com.smartgwt.client.widgets.layout.NavItem#getCustomStyle NavItem.customStyle}.
     *
     * @param navItems New navItems value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavPanel NavPanel} instance, for chaining setter calls
     */
    public NavPanel setNavItems(NavItem... navItems) {
        return (NavPanel)setAttribute("navItems", navItems, true);
    }

    /**
     * Top-level navigation items to display.  You can optionally specify a tree of items using {@link
     * com.smartgwt.client.widgets.layout.NavItem#getItems NavItem.items}. <p> A separator between navigation items can be
     * created by setting {@link com.smartgwt.client.widgets.layout.NavItem#getIsSeparator NavItem.isSeparator}, and a header
     * can be created via {@link com.smartgwt.client.widgets.layout.NavItem#getIsHeader NavItem.isHeader}. <p> Each
     * non-separator and non-header <code>NavItem</code> specifies a component to be displayed in the {@link
     * com.smartgwt.client.widgets.layout.NavPanel#getNavDeck navDeck} via {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane NavItem.pane}. <p> <code>NavItem</code>s can also be individually
     * styled via {@link com.smartgwt.client.widgets.grid.ListGridRecord#get_baseStyle ListGridRecord._baseStyle} or {@link
     * com.smartgwt.client.widgets.layout.NavItem#getCustomStyle NavItem.customStyle}.
     *
     * @return Current navItems value. Default value is null
     */
    public NavItem[] getNavItems()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfNavItem(getAttributeAsJavaScriptObject("navItems"));
    }
    

    // ********************* Methods ***********************

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
     * @param navPanelProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(NavPanel navPanelProperties) /*-{
        if (navPanelProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(NavPanel.@java.lang.Object::getClass()(), "setDefaultProperties", navPanelProperties.@java.lang.Object::getClass()());
        }
        navPanelProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = navPanelProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.NavPanel.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(NavPanelLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.currentItem = getCurrentItem();
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavPanel.currentItem:" + t.getMessage() + "\n";
        }
        try {
            s.currentItemId = getAttributeAsString("currentItemId");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavPanel.currentItemId:" + t.getMessage() + "\n";
        }
        try {
            s.defaultToFirstItem = getAttributeAsString("defaultToFirstItem");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavPanel.defaultToFirstItem:" + t.getMessage() + "\n";
        }
        try {
            s.headerStyle = getAttributeAsString("headerStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavPanel.headerStyle:" + t.getMessage() + "\n";
        }
        try {
            s.isTree = getAttributeAsString("isTree");
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavPanel.isTree:" + t.getMessage() + "\n";
        }
        try {
            s.navItems = getNavItems();
        } catch (Throwable t) {
            s.logicalStructureErrors += "NavPanel.navItemsArray:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        NavPanelLogicalStructure s = new NavPanelLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
