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
 
package com.smartgwt.client.widgets.menu;


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
 * A menu that can either show its menu options inline, or show them via a drop-down, depending on available space in the
 * surrounding {@link com.smartgwt.client.widgets.layout.Layout} or {@link com.smartgwt.client.widgets.toolbar.ToolStrip}.
 * <p> See {@link com.smartgwt.client.widgets.Canvas#getCanAdaptWidth canAdaptWidth} for background on adaptive layout.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("AdaptiveMenu")
public class AdaptiveMenu extends Layout {

    public static AdaptiveMenu getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new AdaptiveMenu(jsObj);
        } else {
            assert refInstance instanceof AdaptiveMenu;
            return (AdaptiveMenu)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(AdaptiveMenu.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.AdaptiveMenu.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(AdaptiveMenu.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.AdaptiveMenu.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public AdaptiveMenu(){
        scClassName = "AdaptiveMenu";
    }

    public AdaptiveMenu(JavaScriptObject jsObj){
        scClassName = "AdaptiveMenu";
        setJavaScriptObject(jsObj);
    }


    public AdaptiveMenu(MenuItem[] items) {
        setItems(items);
                scClassName = "AdaptiveMenu";
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
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * {@link com.smartgwt.client.widgets.toolbar.ToolStripButton} to display when {@link
     * com.smartgwt.client.widgets.menu.AdaptiveMenu#getShowIconOnlyInline showIconOnlyInline} is set for one {@link
     * com.smartgwt.client.widgets.menu.MenuItem}
     *
     * @return null
     */
    public ImgButton getInlineImgButton()  {
        return null;
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * MultiAutoChild used to create inline menu items. <p> The {@link com.smartgwt.client.widgets.menu.MenuItem#getIcon
     * MenuItem.icon} and {@link com.smartgwt.client.widgets.menu.MenuItem#getTitle MenuItem.title} will be rendered via {@link
     * com.smartgwt.client.widgets.Button#getIcon Button.icon} and {@link com.smartgwt.client.widgets.Button#getTitle
     * Button.title} respectively; other {@link com.smartgwt.client.widgets.menu.MenuItem} appearance-related properties do not
     * apply.
     *
     * @return null
     */
    public ToolStripButton getInlineMenuItem()  {
        return null;
    }
    

    /**
     * Placement of inlined items relative to the main {@link com.smartgwt.client.widgets.menu.MenuButton}.  Default is to
     * place items above the menu if the parent is a Layout with {@link
     * com.smartgwt.client.widgets.layout.Layout#getOrientation vertical orientation}, otherwise to the left of the
     * <code>menuButton</code> (or right if the {@link com.smartgwt.client.util.Page#isRTL page is\n RTL (right-to-left)}. <p>
     * A setting of "center" is invalid and will cause a warning and be ignored
     *
     * @param inlinePlacement New inlinePlacement value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.AdaptiveMenu AdaptiveMenu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public AdaptiveMenu setInlinePlacement(Alignment inlinePlacement)  throws IllegalStateException {
        return (AdaptiveMenu)setAttribute("inlinePlacement", inlinePlacement == null ? null : inlinePlacement.getValue(), false);
    }

    /**
     * Placement of inlined items relative to the main {@link com.smartgwt.client.widgets.menu.MenuButton}.  Default is to
     * place items above the menu if the parent is a Layout with {@link
     * com.smartgwt.client.widgets.layout.Layout#getOrientation vertical orientation}, otherwise to the left of the
     * <code>menuButton</code> (or right if the {@link com.smartgwt.client.util.Page#isRTL page is\n RTL (right-to-left)}. <p>
     * A setting of "center" is invalid and will cause a warning and be ignored
     *
     * @return Current inlinePlacement value. Default value is null
     */
    public Alignment getInlinePlacement()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("inlinePlacement"));
    }

    /**
     * Placement of inlined items relative to the main {@link com.smartgwt.client.widgets.menu.MenuButton}.  Default is to
     * place items above the menu if the parent is a Layout with {@link
     * com.smartgwt.client.widgets.layout.Layout#getOrientation vertical orientation}, otherwise to the left of the
     * <code>menuButton</code> (or right if the {@link com.smartgwt.client.util.Page#isRTL page is\n RTL (right-to-left)}. <p>
     * A setting of "center" is invalid and will cause a warning and be ignored
     *
     * @param inlinePlacement New inlinePlacement value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.AdaptiveMenu AdaptiveMenu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public AdaptiveMenu setInlinePlacement(VerticalAlignment inlinePlacement)  throws IllegalStateException {
        return (AdaptiveMenu)setAttribute("inlinePlacement", inlinePlacement == null ? null : inlinePlacement.getValue(), false);
    }

    /**
     * Placement of inlined items relative to the main {@link com.smartgwt.client.widgets.menu.MenuButton}.  Default is to
     * place items above the menu if the parent is a Layout with {@link
     * com.smartgwt.client.widgets.layout.Layout#getOrientation vertical orientation}, otherwise to the left of the
     * <code>menuButton</code> (or right if the {@link com.smartgwt.client.util.Page#isRTL page is\n RTL (right-to-left)}. <p>
     * A setting of "center" is invalid and will cause a warning and be ignored
     *
     * @return Current inlinePlacement value. Default value is null
     */
    public VerticalAlignment getInlinePlacementAsVerticalAlignment()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("inlinePlacement"));
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * MultiAutoChild used to create inline menu items for menu items that have a submenu. <p> The {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getIcon MenuItem.icon} and {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getTitle MenuItem.title} will be rendered via {@link
     * com.smartgwt.client.widgets.IconButton#getIcon IconButton.icon} and {@link com.smartgwt.client.widgets.Button#getTitle
     * Button.title} respectively; other {@link com.smartgwt.client.widgets.menu.MenuItem} appearance-related properties do not
     * apply.
     *
     * @return null
     */
    public IconMenuButton getInlineSubmenuItem()  {
        return null;
    }
    

    /**
     * MenuItems to be show either inline or as a drop-down {@link com.smartgwt.client.widgets.menu.Menu}. <p> When shown
     * inline, items are rendered as different {@link com.smartgwt.client.types.AutoChild} according to the settings on the
     * MenuItem: <ul> <li> normal MenuItems render as the {@link
     * com.smartgwt.client.widgets.menu.AdaptiveMenu#getInlineMenuItem inlineMenuItem}, a {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripButton} AutoChild <li> MenuItems that have submenus render as the {@link
     * com.smartgwt.client.widgets.menu.AdaptiveMenu#getInlineSubmenuItem inlineSubmenuItem}, a      {@link
     * com.smartgwt.client.widgets.menu.MenuButton} AutoChild <li> MenuItems with {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getShowIconOnlyInline showIconOnlyInline} set render as the      {@link
     * com.smartgwt.client.widgets.menu.AdaptiveMenu#getInlineImgButton inlineImgButton}, a {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripButton} AutoChild <li> MenuItems where {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getEmbeddedComponent MenuItem.embeddedComponent} has been specified will have
     * the      embedded component displayed directly instead (no AutoChild involvement here).  If the      control should have
     * different appearance when inlined vs embedded in the menu, one way      to achieve this is to detect whether the parent
     * is a Menu when it is drawn. </ul>
     *
     * @param items New items value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.AdaptiveMenu AdaptiveMenu} instance, for chaining setter calls
     */
    public AdaptiveMenu setItems(MenuItem... items) {
        return (AdaptiveMenu)setAttribute("items", items, true);
    }

    /**
     * MenuItems to be show either inline or as a drop-down {@link com.smartgwt.client.widgets.menu.Menu}. <p> When shown
     * inline, items are rendered as different {@link com.smartgwt.client.types.AutoChild} according to the settings on the
     * MenuItem: <ul> <li> normal MenuItems render as the {@link
     * com.smartgwt.client.widgets.menu.AdaptiveMenu#getInlineMenuItem inlineMenuItem}, a {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripButton} AutoChild <li> MenuItems that have submenus render as the {@link
     * com.smartgwt.client.widgets.menu.AdaptiveMenu#getInlineSubmenuItem inlineSubmenuItem}, a      {@link
     * com.smartgwt.client.widgets.menu.MenuButton} AutoChild <li> MenuItems with {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getShowIconOnlyInline showIconOnlyInline} set render as the      {@link
     * com.smartgwt.client.widgets.menu.AdaptiveMenu#getInlineImgButton inlineImgButton}, a {@link
     * com.smartgwt.client.widgets.toolbar.ToolStripButton} AutoChild <li> MenuItems where {@link
     * com.smartgwt.client.widgets.menu.MenuItem#getEmbeddedComponent MenuItem.embeddedComponent} has been specified will have
     * the      embedded component displayed directly instead (no AutoChild involvement here).  If the      control should have
     * different appearance when inlined vs embedded in the menu, one way      to achieve this is to detect whether the parent
     * is a Menu when it is drawn. </ul>
     *
     * @return Current items value. Default value is null
     */
    public MenuItem[] getItems()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfMenuItem(getAttributeAsJavaScriptObject("items"));
    }
    

    /**
     * Instance of the normal (non-Adaptive) {@link com.smartgwt.client.widgets.menu.Menu} class used to show items that do not
     * fit inline.
     * <p>
     * This component is an AutoChild named "menu".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current menu value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Menu getMenu() throws IllegalStateException {
        errorIfNotCreated("menu");
        return (Menu)Menu.getByJSObject(getAttributeAsJavaScriptObject("menu"));
    }
    

    /**
     * {@link com.smartgwt.client.widgets.menu.MenuButton} used as a drop-down control for showing any items of the menu that
     * are not displayed inline.
     * <p>
     * This component is an AutoChild named "menuButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current menuButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public MenuButton getMenuButton() throws IllegalStateException {
        errorIfNotCreated("menuButton");
        return (MenuButton)MenuButton.getByJSObject(getAttributeAsJavaScriptObject("menuButton"));
    }
    

    /**
     * Icon used for the {@link com.smartgwt.client.widgets.menu.MenuButton}.  Default of null means to use the default for the
     * {@link com.smartgwt.client.widgets.menu.MenuButton} class.
     *
     * @param menuButtonIcon New menuButtonIcon value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.AdaptiveMenu AdaptiveMenu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public AdaptiveMenu setMenuButtonIcon(String menuButtonIcon)  throws IllegalStateException {
        return (AdaptiveMenu)setAttribute("menuButtonIcon", menuButtonIcon, false);
    }

    /**
     * Icon used for the {@link com.smartgwt.client.widgets.menu.MenuButton}.  Default of null means to use the default for the
     * {@link com.smartgwt.client.widgets.menu.MenuButton} class.
     *
     * @return Current menuButtonIcon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getMenuButtonIcon()  {
        return getAttributeAsString("menuButtonIcon");
    }
    

    /**
     * Title used for the {@link com.smartgwt.client.widgets.menu.MenuButton}.
     *
     * @param menuButtonTitle New menuButtonTitle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.AdaptiveMenu AdaptiveMenu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public AdaptiveMenu setMenuButtonTitle(String menuButtonTitle)  throws IllegalStateException {
        return (AdaptiveMenu)setAttribute("menuButtonTitle", menuButtonTitle, false);
    }

    /**
     * Title used for the {@link com.smartgwt.client.widgets.menu.MenuButton}.
     *
     * @return Current menuButtonTitle value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getMenuButtonTitle()  {
        return getAttributeAsString("menuButtonTitle");
    }
    

    /**
     * Whether the AdaptiveMenu should show some menu items inline as soon as there is enough space, or should strictly switch
     * between showing
     *
     * @param partialInlining New partialInlining value. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.AdaptiveMenu AdaptiveMenu} instance, for chaining setter calls
     */
    public AdaptiveMenu setPartialInlining(boolean partialInlining) {
        return (AdaptiveMenu)setAttribute("partialInlining", partialInlining, true);
    }

    /**
     * Whether the AdaptiveMenu should show some menu items inline as soon as there is enough space, or should strictly switch
     * between showing
     *
     * @return Current partialInlining value. Default value is true
     */
    public boolean getPartialInlining()  {
        Boolean result = getAttributeAsBoolean("partialInlining");
        return result == null ? true : result;
    }
    

    /**
     * Default setting for {@link com.smartgwt.client.widgets.menu.MenuItem#getShowIconOnlyInline MenuItem.showIconOnlyInline}.
     *  Individual items can set <code>showIconOnlyInline</code> to override this setting.
     *
     * @param showIconOnlyInline New showIconOnlyInline value. Default value is false
     * @return {@link com.smartgwt.client.widgets.menu.AdaptiveMenu AdaptiveMenu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public AdaptiveMenu setShowIconOnlyInline(boolean showIconOnlyInline)  throws IllegalStateException {
        return (AdaptiveMenu)setAttribute("showIconOnlyInline", showIconOnlyInline, false);
    }

    /**
     * Default setting for {@link com.smartgwt.client.widgets.menu.MenuItem#getShowIconOnlyInline MenuItem.showIconOnlyInline}.
     *  Individual items can set <code>showIconOnlyInline</code> to override this setting.
     *
     * @return Current showIconOnlyInline value. Default value is false
     */
    public boolean getShowIconOnlyInline()  {
        Boolean result = getAttributeAsBoolean("showIconOnlyInline");
        return result == null ? false : result;
    }
    

    /**
     * Whether {@link com.smartgwt.client.widgets.toolbar.ToolStripSeparator separators} should be shown for inline menu items.
     * True by default for horizontal {@link com.smartgwt.client.widgets.layout.Layout#getOrientation orientation}, false for
     * vertical.
     *
     * @param showInlineSeparators New showInlineSeparators value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.AdaptiveMenu AdaptiveMenu} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public AdaptiveMenu setShowInlineSeparators(Boolean showInlineSeparators)  throws IllegalStateException {
        return (AdaptiveMenu)setAttribute("showInlineSeparators", showInlineSeparators, false);
    }

    /**
     * Whether {@link com.smartgwt.client.widgets.toolbar.ToolStripSeparator separators} should be shown for inline menu items.
     * True by default for horizontal {@link com.smartgwt.client.widgets.layout.Layout#getOrientation orientation}, false for
     * vertical.
     *
     * @return Current showInlineSeparators value. Default value is null
     */
    public Boolean getShowInlineSeparators()  {
        return getAttributeAsBoolean("showInlineSeparators");
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
     * @param adaptiveMenuProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(AdaptiveMenu adaptiveMenuProperties) /*-{
        if (adaptiveMenuProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(AdaptiveMenu.@java.lang.Object::getClass()(), "setDefaultProperties", adaptiveMenuProperties.@java.lang.Object::getClass()());
        }
        adaptiveMenuProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = adaptiveMenuProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.AdaptiveMenu.addProperties(properties);
    }-*/;

    // ***********************************************************



    public AdaptiveMenu(Menu menu) {
        setItems(menu.getItems());
        scClassName = "AdaptiveMenu";
    }

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(AdaptiveMenuLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.inlinePlacementAsString = getAttributeAsString("inlinePlacement");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdaptiveMenu.inlinePlacementAsString:" + t.getMessage() + "\n";
        }
        try {
            s.items = getItems();
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdaptiveMenu.itemsArray:" + t.getMessage() + "\n";
        }
        try {
            s.menuButtonIcon = getAttributeAsString("menuButtonIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdaptiveMenu.menuButtonIcon:" + t.getMessage() + "\n";
        }
        try {
            s.menuButtonTitle = getAttributeAsString("menuButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdaptiveMenu.menuButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.partialInlining = getAttributeAsString("partialInlining");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdaptiveMenu.partialInlining:" + t.getMessage() + "\n";
        }
        try {
            s.showIconOnlyInline = getAttributeAsString("showIconOnlyInline");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdaptiveMenu.showIconOnlyInline:" + t.getMessage() + "\n";
        }
        try {
            s.showInlineSeparators = getAttributeAsString("showInlineSeparators");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdaptiveMenu.showInlineSeparators:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        AdaptiveMenuLogicalStructure s = new AdaptiveMenuLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
