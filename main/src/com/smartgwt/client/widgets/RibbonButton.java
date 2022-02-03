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
 
package com.smartgwt.client.widgets;


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
import com.smartgwt.logicalstructure.widgets.tour.*;

/**
 * A Button subclass that displays an {@link com.smartgwt.client.widgets.RibbonButton#getIcon icon},  {@link
 * com.smartgwt.client.widgets.RibbonButton#getShowButtonTitle title} and optional {@link
 * com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon}  and is capable of {@link
 * com.smartgwt.client.widgets.RibbonButton#getVertical horizontal and vertical} orientation.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("RibbonButton")
public class RibbonButton extends Button implements com.smartgwt.client.widgets.menu.events.HasMenuIconClickHandlers {

    public static RibbonButton getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new RibbonButton(jsObj);
        } else {
            assert refInstance instanceof RibbonButton;
            return (RibbonButton)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RibbonButton.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.RibbonButton.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RibbonButton.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.RibbonButton.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public RibbonButton(){
        scClassName = "RibbonButton";
    }

    public RibbonButton(JavaScriptObject jsObj){
        scClassName = "RibbonButton";
        setJavaScriptObject(jsObj);
    }


    public RibbonButton(String title) {
        setTitle(title);
                scClassName = "RibbonButton";
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
     * Horizontal alignment of this button's content.  If unset,  {@link com.smartgwt.client.widgets.RibbonButton#getVertical
     * vertical buttons} are center-aligned and horizontal buttons left-aligned by default.
     *
     * @param align New align value. Default value is null
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public RibbonButton setAlign(Alignment align) {
        return (RibbonButton)setAttribute("align", align == null ? null : align.getValue(), true);
    }

    /**
     * Horizontal alignment of this button's content.  If unset,  {@link com.smartgwt.client.widgets.RibbonButton#getVertical
     * vertical buttons} are center-aligned and horizontal buttons left-aligned by default.
     *
     * @return Current align value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }
    

    /**
     * Default CSS class for this button.
     *
     * @param baseStyle New baseStyle value. Default value is "ribbonButton"
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public RibbonButton setBaseStyle(String baseStyle) {
        return (RibbonButton)setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * Default CSS class for this button.
     *
     * @return Current baseStyle value. Default value is "ribbonButton"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "RibbonButtonEditProxy"
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public RibbonButton setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (RibbonButton)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "RibbonButtonEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Icon to show to the left of or above the title, according to the button's  {@link
     * com.smartgwt.client.widgets.RibbonButton#getVertical orientation}. <P> When specifying <code>vertical = true</code>,
     * this icon will be stretched to  the {@link com.smartgwt.client.widgets.RibbonButton#getLargeIconSize largeIconSize}
     * unless a {@link com.smartgwt.client.widgets.RibbonButton#getLargeIcon largeIcon} is specified.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets a new Icon for this button after initialization.
     *
     * @param icon URL of new icon. Default value is null
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public RibbonButton setIcon(String icon) {
        return (RibbonButton)setAttribute("icon", icon, true);
    }

    /**
     * Icon to show to the left of or above the title, according to the button's  {@link
     * com.smartgwt.client.widgets.RibbonButton#getVertical orientation}. <P> When specifying <code>vertical = true</code>,
     * this icon will be stretched to  the {@link com.smartgwt.client.widgets.RibbonButton#getLargeIconSize largeIconSize}
     * unless a {@link com.smartgwt.client.widgets.RibbonButton#getLargeIcon largeIcon} is specified.
     *
     * @return Returns the URL for the current icon. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * This attribute is not supported in this subclass.  However, RTL mode is still supported.
     *
     * @param iconAlign New iconAlign value. Default value is null
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setIconAlign(String iconAlign) {
        return (RibbonButton)setAttribute("iconAlign", iconAlign, true);
    }

    /**
     * This attribute is not supported in this subclass.  However, RTL mode is still supported.
     *
     * @return Current iconAlign value. Default value is null
     */
    public String getIconAlign()  {
        return getAttributeAsString("iconAlign");
    }
    

    /**
     * This attribute is not supported in this subclass.  However, RTL mode is still supported.
     *
     * @param iconOrientation New iconOrientation value. Default value is null
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setIconOrientation(String iconOrientation) {
        return (RibbonButton)setAttribute("iconOrientation", iconOrientation, true);
    }

    /**
     * This attribute is not supported in this subclass.  However, RTL mode is still supported.
     *
     * @return Current iconOrientation value. Default value is null
     */
    public String getIconOrientation()  {
        return getAttributeAsString("iconOrientation");
    }
    
    

    /**
     * Icon to show above the title when {@link com.smartgwt.client.types.Orientation} is "vertical". <P> If a largeIcon is not
     * specified, the {@link com.smartgwt.client.widgets.RibbonButton#getIcon normal icon} will be stretched to  the {@link
     * com.smartgwt.client.widgets.RibbonButton#getLargeIconSize largeIconSize}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets a new Large-Icon for vertical buttons after initialization - synonymous with  {@link com.smartgwt.client.widgets.RibbonButton#setIcon setIcon} for normal horizontal buttons.
     *
     * @param largeIcon New largeIcon value. Default value is null
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public RibbonButton setLargeIcon(String largeIcon) {
        return (RibbonButton)setAttribute("largeIcon", largeIcon, true);
    }

    /**
     * Icon to show above the title when {@link com.smartgwt.client.types.Orientation} is "vertical". <P> If a largeIcon is not
     * specified, the {@link com.smartgwt.client.widgets.RibbonButton#getIcon normal icon} will be stretched to  the {@link
     * com.smartgwt.client.widgets.RibbonButton#getLargeIconSize largeIconSize}.
     *
     * @return Current largeIcon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getLargeIcon()  {
        return getAttributeAsString("largeIcon");
    }
    

    /**
     * The size of the large icon for this button.  If {@link com.smartgwt.client.widgets.RibbonButton#getLargeIcon largeIcon}
     * is not specified, the {@link com.smartgwt.client.widgets.RibbonButton#getIcon normal icon} will be stretched to this
     * size.
     *
     * @param largeIconSize New largeIconSize value. Default value is 32
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setLargeIconSize(int largeIconSize) {
        return (RibbonButton)setAttribute("largeIconSize", largeIconSize, true);
    }

    /**
     * The size of the large icon for this button.  If {@link com.smartgwt.client.widgets.RibbonButton#getLargeIcon largeIcon}
     * is not specified, the {@link com.smartgwt.client.widgets.RibbonButton#getIcon normal icon} will be stretched to this
     * size.
     *
     * @return Current largeIconSize value. Default value is 32
     */
    public int getLargeIconSize()  {
        return getAttributeAsInt("largeIconSize");
    }
    

    /**
     * The menu to show when the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menu-icon} is clicked. <P> For
     * a menu button with no menu (menu: null) the up/down arrow image can be suppressed by setting {@link
     * com.smartgwt.client.widgets.RibbonButton#getShowMenuIcon showMenuIcon}: <code>false</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * The menu to show when the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menu-icon} is clicked. <P> For a menu button with no menu (menu: null) the up/down arrow image can be suppressed by setting {@link com.smartgwt.client.widgets.RibbonButton#getShowMenuIcon showMenuIcon}: <code>false</code>.  Note that  <code>showMenuIcon</code> is updated automatically by calls to  {@link com.smartgwt.client.widgets.RibbonButton#setMenu setMenu()}.
     *
     * @param menu a menu to assign to this button. Default value is null
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setMenu(Menu menu) {
        return (RibbonButton)setAttribute("menu", menu == null ? null : menu.getOrCreateJsObj(), true);
    }

    /**
     * The menu to show when the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menu-icon} is clicked. <P> For
     * a menu button with no menu (menu: null) the up/down arrow image can be suppressed by setting {@link
     * com.smartgwt.client.widgets.RibbonButton#getShowMenuIcon showMenuIcon}: <code>false</code>.
     *
     * @return Current menu value. Default value is null
     */
    public Menu getMenu()  {
        return (Menu)Menu.getByJSObject(getAttributeAsJavaScriptObject("menu"));
    }
    

    /**
     * The horizontal alignment of this button's menu, in relation to the button.  When unset, default behavior is to align the
     * right edges of button and menu if the page is in RTL  mode, and the left edges otherwise.
     *
     * @param menuAlign New menuAlign value. Default value is null
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RibbonButton setMenuAlign(Alignment menuAlign)  throws IllegalStateException {
        return (RibbonButton)setAttribute("menuAlign", menuAlign == null ? null : menuAlign.getValue(), false);
    }

    /**
     * The horizontal alignment of this button's menu, in relation to the button.  When unset, default behavior is to align the
     * right edges of button and menu if the page is in RTL  mode, and the left edges otherwise.
     *
     * @return Current menuAlign value. Default value is null
     */
    public Alignment getMenuAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("menuAlign"));
    }
    

    /**
     * Allows you to specify an animation effect to apply to the menu when it is being shown. Valid options are "none" (no
     * animation), "fade", "slide" and "wipe". If unspecified falls through to <code>menu.showAnimationEffect</code>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param menuAnimationEffect New menuAnimationEffect value. Default value is null
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setMenuAnimationEffect(String menuAnimationEffect) {
        return (RibbonButton)setAttribute("menuAnimationEffect", menuAnimationEffect, true);
    }

    /**
     * Allows you to specify an animation effect to apply to the menu when it is being shown. Valid options are "none" (no
     * animation), "fade", "slide" and "wipe". If unspecified falls through to <code>menu.showAnimationEffect</code>
     *
     * @return Current menuAnimationEffect value. Default value is null
     */
    public String getMenuAnimationEffect()  {
        return getAttributeAsString("menuAnimationEffect");
    }
    

    /**
     * The height of the icon for this button.
     *
     * @param menuIconHeight New menuIconHeight value. Default value is 13
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setMenuIconHeight(int menuIconHeight) {
        return (RibbonButton)setAttribute("menuIconHeight", menuIconHeight, true);
    }

    /**
     * The height of the icon for this button.
     *
     * @return Current menuIconHeight value. Default value is 13
     */
    public int getMenuIconHeight()  {
        return getAttributeAsInt("menuIconHeight");
    }
    

    /**
     * Base URL for an Image that shows a {@link com.smartgwt.client.widgets.menu.Menu menu} when clicked.  See also  {@link
     * com.smartgwt.client.widgets.RibbonButton#getShowMenuIconDisabled showMenuIconDisabled} and {@link
     * com.smartgwt.client.widgets.RibbonButton#getShowMenuIconOver showMenuIconOver}.
     *
     * @param menuIconSrc New menuIconSrc value. Default value is "[SKINIMG]/Menu/submenu_down.png"
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public RibbonButton setMenuIconSrc(String menuIconSrc) {
        return (RibbonButton)setAttribute("menuIconSrc", menuIconSrc, true);
    }

    /**
     * Base URL for an Image that shows a {@link com.smartgwt.client.widgets.menu.Menu menu} when clicked.  See also  {@link
     * com.smartgwt.client.widgets.RibbonButton#getShowMenuIconDisabled showMenuIconDisabled} and {@link
     * com.smartgwt.client.widgets.RibbonButton#getShowMenuIconOver showMenuIconOver}.
     *
     * @return Current menuIconSrc value. Default value is "[SKINIMG]/Menu/submenu_down.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getMenuIconSrc()  {
        return getAttributeAsString("menuIconSrc");
    }
    

    /**
     * The width of the icon for this button.
     *
     * @param menuIconWidth New menuIconWidth value. Default value is 14
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setMenuIconWidth(int menuIconWidth) {
        return (RibbonButton)setAttribute("menuIconWidth", menuIconWidth, true);
    }

    /**
     * The width of the icon for this button.
     *
     * @return Current menuIconWidth value. Default value is 14
     */
    public int getMenuIconWidth()  {
        return getAttributeAsInt("menuIconWidth");
    }
    

    /**
     * The orientation of this RibbonButton.  The default value, "vertical", renders  {@link
     * com.smartgwt.client.widgets.RibbonButton#getIcon icon}, {@link
     * com.smartgwt.client.widgets.RibbonButton#getShowButtonTitle title} and potentially  {@link
     * com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon}, from top to bottom: "horizontal" does the same  from
     * top to bottom.
     *
     * @param orientation New orientation value. Default value is "vertical"
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     * @deprecated in favor of {@link com.smartgwt.client.widgets.RibbonButton#getVertical vertical} which, if set, takes precendence over
     * this setting
     */
    public RibbonButton setOrientation(String orientation) {
        return (RibbonButton)setAttribute("orientation", orientation, true);
    }

    /**
     * The orientation of this RibbonButton.  The default value, "vertical", renders  {@link
     * com.smartgwt.client.widgets.RibbonButton#getIcon icon}, {@link
     * com.smartgwt.client.widgets.RibbonButton#getShowButtonTitle title} and potentially  {@link
     * com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon}, from top to bottom: "horizontal" does the same  from
     * top to bottom.
     *
     * @return Current orientation value. Default value is "vertical"
     * @deprecated in favor of {@link com.smartgwt.client.widgets.RibbonButton#getVertical vertical} which, if set, takes precendence over
     * this setting
     */
    public String getOrientation()  {
        return getAttributeAsString("orientation");
    }
    

    /**
     * When used in a {@link com.smartgwt.client.widgets.toolbar.RibbonBar}, the number of rows this button should occupy in a
     * single {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getColumnLayout column}.
     *
     * @param rowSpan New rowSpan value. Default value is 1
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setRowSpan(int rowSpan) {
        return (RibbonButton)setAttribute("rowSpan", rowSpan, true);
    }

    /**
     * When used in a {@link com.smartgwt.client.widgets.toolbar.RibbonBar}, the number of rows this button should occupy in a
     * single {@link com.smartgwt.client.widgets.toolbar.RibbonGroup#getColumnLayout column}.
     *
     * @return Current rowSpan value. Default value is 1
     */
    public int getRowSpan()  {
        return getAttributeAsInt("rowSpan");
    }
    

    /**
     * Whether to show the title-text for this RibbonButton.  If set to false, title-text is omitted altogether and just the
     * icon is displayed.
     *
     * @param showButtonTitle New showButtonTitle value. Default value is true
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setShowButtonTitle(Boolean showButtonTitle) {
        return (RibbonButton)setAttribute("showButtonTitle", showButtonTitle, true);
    }

    /**
     * Whether to show the title-text for this RibbonButton.  If set to false, title-text is omitted altogether and just the
     * icon is displayed.
     *
     * @return Current showButtonTitle value. Default value is true
     */
    public Boolean getShowButtonTitle()  {
        Boolean result = getAttributeAsBoolean("showButtonTitle");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show an Icon in this RibbonButton.  Set to false to render a text-only button.
     *
     * @param showIcon New showIcon value. Default value is null
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setShowIcon(Boolean showIcon) {
        return (RibbonButton)setAttribute("showIcon", showIcon, true);
    }

    /**
     * Whether to show an Icon in this RibbonButton.  Set to false to render a text-only button.
     *
     * @return Current showIcon value. Default value is null
     */
    public Boolean getShowIcon()  {
        return getAttributeAsBoolean("showIcon");
    }
    

    /**
     * The menu drops down below the menu button. Set to false if the menu should appear above the menu button.
     *
     * @param showMenuBelow New showMenuBelow value. Default value is true
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setShowMenuBelow(Boolean showMenuBelow) {
        return (RibbonButton)setAttribute("showMenuBelow", showMenuBelow, true);
    }

    /**
     * The menu drops down below the menu button. Set to false if the menu should appear above the menu button.
     *
     * @return Current showMenuBelow value. Default value is true
     */
    public Boolean getShowMenuBelow()  {
        Boolean result = getAttributeAsBoolean("showMenuBelow");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menu-icon} which fires the {@link
     * com.smartgwt.client.widgets.RibbonButton#addMenuIconClickHandler RibbonButton.menuIconClick()}  notification method when
     * clicked.
     *
     * @param showMenuIcon New showMenuIcon value. Default value is null
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setShowMenuIcon(Boolean showMenuIcon) {
        return (RibbonButton)setAttribute("showMenuIcon", showMenuIcon, true);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menu-icon} which fires the {@link
     * com.smartgwt.client.widgets.RibbonButton#addMenuIconClickHandler RibbonButton.menuIconClick()}  notification method when
     * clicked.
     *
     * @return Current showMenuIcon value. Default value is null
     */
    public Boolean getShowMenuIcon()  {
        return getAttributeAsBoolean("showMenuIcon");
    }
    

    /**
     * Whether to show a Disabled version of the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon}.
     *
     * @param showMenuIconDisabled New showMenuIconDisabled value. Default value is true
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setShowMenuIconDisabled(Boolean showMenuIconDisabled) {
        return (RibbonButton)setAttribute("showMenuIconDisabled", showMenuIconDisabled, true);
    }

    /**
     * Whether to show a Disabled version of the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon}.
     *
     * @return Current showMenuIconDisabled value. Default value is true
     */
    public Boolean getShowMenuIconDisabled()  {
        Boolean result = getAttributeAsBoolean("showMenuIconDisabled");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show a Down version of the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon}.
     *
     * @param showMenuIconDown New showMenuIconDown value. Default value is false
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setShowMenuIconDown(Boolean showMenuIconDown) {
        return (RibbonButton)setAttribute("showMenuIconDown", showMenuIconDown, true);
    }

    /**
     * Whether to show a Down version of the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon}.
     *
     * @return Current showMenuIconDown value. Default value is false
     */
    public Boolean getShowMenuIconDown()  {
        Boolean result = getAttributeAsBoolean("showMenuIconDown");
        return result == null ? false : result;
    }
    

    /**
     * Whether to show an Over version of the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon}.
     *
     * @param showMenuIconOver New showMenuIconOver value. Default value is true
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setShowMenuIconOver(Boolean showMenuIconOver) {
        return (RibbonButton)setAttribute("showMenuIconOver", showMenuIconOver, true);
    }

    /**
     * Whether to show an Over version of the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon}.
     *
     * @return Current showMenuIconOver value. Default value is true
     */
    public Boolean getShowMenuIconOver()  {
        Boolean result = getAttributeAsBoolean("showMenuIconOver");
        return result == null ? true : result;
    }
    

    /**
     * If set to true, shows this button's {@link com.smartgwt.client.widgets.menu.Menu menu} when a user clicks anywhere  in
     * the button, rather than specifically on the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon}.
     * <P> Note that this property has a different meaning than {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowMenuOnClick showMenuOnClick} in the ancestor class {@link
     * com.smartgwt.client.widgets.StatefulCanvas}.
     *
     * @param showMenuOnClick New showMenuOnClick value. Default value is false
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setShowMenuOnClick(Boolean showMenuOnClick) {
        return (RibbonButton)setAttribute("showMenuOnClick", showMenuOnClick, true);
    }

    /**
     * If set to true, shows this button's {@link com.smartgwt.client.widgets.menu.Menu menu} when a user clicks anywhere  in
     * the button, rather than specifically on the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon}.
     * <P> Note that this property has a different meaning than {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowMenuOnClick showMenuOnClick} in the ancestor class {@link
     * com.smartgwt.client.widgets.StatefulCanvas}.
     *
     * @return Current showMenuOnClick value. Default value is false
     */
    public Boolean getShowMenuOnClick()  {
        Boolean result = getAttributeAsBoolean("showMenuOnClick");
        return result == null ? false : result;
    }
    

    /**
     * showTitle is not applicable to this class - use {@link com.smartgwt.client.widgets.RibbonButton#getShowButtonTitle
     * showButtonTitle} instead.
     *
     * @param showTitle New showTitle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setShowTitle(Boolean showTitle) {
        return (RibbonButton)setAttribute("showTitle", showTitle, true);
    }

    /**
     * showTitle is not applicable to this class - use {@link com.smartgwt.client.widgets.RibbonButton#getShowButtonTitle
     * showButtonTitle} instead.
     *
     * @return Current showTitle value. Default value is null
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }
    

    /**
     * Vertical alignment of this button's content.  If unset,  {@link com.smartgwt.client.widgets.RibbonButton#getVertical
     * vertical buttons} are top-aligned and horizontal buttons center-aligned by default.
     *
     * @param valign New valign value. Default value is null
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public RibbonButton setValign(VerticalAlignment valign) {
        return (RibbonButton)setAttribute("valign", valign == null ? null : valign.getValue(), true);
    }

    /**
     * Vertical alignment of this button's content.  If unset,  {@link com.smartgwt.client.widgets.RibbonButton#getVertical
     * vertical buttons} are top-aligned and horizontal buttons center-aligned by default.
     *
     * @return Current valign value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public VerticalAlignment getValign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("valign"));
    }
    

    /**
     * Whether this button renders vertically.  Renders the  {@link com.smartgwt.client.widgets.RibbonButton#getIcon icon},
     * {@link com.smartgwt.client.widgets.RibbonButton#getShowButtonTitle title} and potentially  {@link
     * com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon} from top to bottom, when true, and from left to right
     * when false.
     *
     * @param vertical New vertical value. Default value is false
     * @return {@link com.smartgwt.client.widgets.RibbonButton RibbonButton} instance, for chaining setter calls
     */
    public RibbonButton setVertical(boolean vertical) {
        return (RibbonButton)setAttribute("vertical", vertical, true);
    }

    /**
     * Whether this button renders vertically.  Renders the  {@link com.smartgwt.client.widgets.RibbonButton#getIcon icon},
     * {@link com.smartgwt.client.widgets.RibbonButton#getShowButtonTitle title} and potentially  {@link
     * com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon} from top to bottom, when true, and from left to right
     * when false.
     *
     * @return Current vertical value. Default value is false
     */
    public boolean getVertical()  {
        Boolean result = getAttributeAsBoolean("vertical");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Notification method fired when a user clicks anywhere on this button.  If the click occurred directly on the {@link
     * com.smartgwt.client.widgets.Button#getIcon icon} or the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc
     * menuIcon},  the related notifications {@link com.smartgwt.client.widgets.RibbonButton#iconClick iconClick} and  {@link
     * com.smartgwt.client.widgets.RibbonButton#addMenuIconClickHandler menuIconClick} are fired first and must return false to
     * prevent this notification from firing. <P> If a {@link com.smartgwt.client.widgets.menu.Menu menu} is installed then, by
     * default, it is only displayed when a  user clicks on the {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc
     * menuIcon}.  This can be altered via  {@link com.smartgwt.client.widgets.RibbonButton#getShowMenuOnClick
     * showMenuOnClick}.
     *
     * @return return false to cancel event-bubbling
     */
    public native Boolean click() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "click", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.click();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Notification method fired when a user clicks on the {@link com.smartgwt.client.widgets.RibbonButton#getIcon icon} in
     * this  RibbonButton.    call <code>event.cancel()</code> to suppress the standard  click handling code.
     *
     * @return return false to cancel event-bubbling
     */
    public native Boolean iconClick() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "iconClick", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.iconClick();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

    /**
     * Add a menuIconClick handler.
     * <p>
     * Notification method fired when a user clicks on the menuIcon on this RibbonButton.    call <code>event.cancel()</code>
     * to suppress the standard  click handling code.
     *
     * @param handler the menuIconClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addMenuIconClickHandler(com.smartgwt.client.widgets.menu.events.MenuIconClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.menu.events.MenuIconClickEvent.getType()) == 0) setupMenuIconClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.menu.events.MenuIconClickEvent.getType());
    }

    private native void setupMenuIconClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var menuIconClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.menu.events.MenuIconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.RibbonButton::handleTearDownMenuIconClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("menuIconClick"));
            obj.addProperties({menuIconClick: 
                function () {
                    var param = {"_this": this};
                    var ret = menuIconClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("menuIconClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("menuIconClick"));
            obj.menuIconClick = 
                function () {
                    var param = {"_this": this};
                    var ret = menuIconClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("menuIconClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownMenuIconClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.menu.events.MenuIconClickEvent.getType()) == 0) tearDownMenuIconClickEvent();
    }

    private native void tearDownMenuIconClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("menuIconClick")) delete obj.menuIconClick;
    }-*/;

	/**
     * Shows this button's {@link com.smartgwt.client.widgets.RibbonButton#getMenu menu}.  Called automatically when a user
     * clicks the  {@link com.smartgwt.client.widgets.RibbonButton#getMenuIconSrc menuIcon}.
     *
     * @return true if a menu was shown
     */
    public native Boolean showMenu() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showMenu", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.showMenu();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
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
     * @param ribbonButtonProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(RibbonButton ribbonButtonProperties) /*-{
        if (ribbonButtonProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(RibbonButton.@java.lang.Object::getClass()(), "setDefaultProperties", ribbonButtonProperties.@java.lang.Object::getClass()());
        }
        ribbonButtonProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = ribbonButtonProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.RibbonButton.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(RibbonButtonLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.align = getAttributeAsString("align");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.align:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.icon = getAttributeAsString("icon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.icon:" + t.getMessage() + "\n";
        }
        try {
            s.iconAlign = getAttributeAsString("iconAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.iconAlign:" + t.getMessage() + "\n";
        }
        try {
            s.iconOrientation = getAttributeAsString("iconOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.iconOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.largeIcon = getAttributeAsString("largeIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.largeIcon:" + t.getMessage() + "\n";
        }
        try {
            s.largeIconSize = getAttributeAsString("largeIconSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.largeIconSize:" + t.getMessage() + "\n";
        }
        try {
            s.menu = getMenu();
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.menu:" + t.getMessage() + "\n";
        }
        try {
            s.menuAlign = getAttributeAsString("menuAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.menuAlign:" + t.getMessage() + "\n";
        }
        try {
            s.menuAnimationEffect = getAttributeAsString("menuAnimationEffect");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.menuAnimationEffect:" + t.getMessage() + "\n";
        }
        try {
            s.menuIconHeight = getAttributeAsString("menuIconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.menuIconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.menuIconSrc = getAttributeAsString("menuIconSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.menuIconSrc:" + t.getMessage() + "\n";
        }
        try {
            s.menuIconWidth = getAttributeAsString("menuIconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.menuIconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.orientation = getAttributeAsString("orientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.orientation:" + t.getMessage() + "\n";
        }
        try {
            s.rowSpan = getAttributeAsString("rowSpan");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.rowSpan:" + t.getMessage() + "\n";
        }
        try {
            s.showButtonTitle = getAttributeAsString("showButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.showButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.showIcon = getAttributeAsString("showIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.showIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuBelow = getAttributeAsString("showMenuBelow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.showMenuBelow:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuIcon = getAttributeAsString("showMenuIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.showMenuIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuIconDisabled = getAttributeAsString("showMenuIconDisabled");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.showMenuIconDisabled:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuIconDown = getAttributeAsString("showMenuIconDown");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.showMenuIconDown:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuIconOver = getAttributeAsString("showMenuIconOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.showMenuIconOver:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuOnClick = getAttributeAsString("showMenuOnClick");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.showMenuOnClick:" + t.getMessage() + "\n";
        }
        try {
            s.showTitle = getAttributeAsString("showTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.showTitle:" + t.getMessage() + "\n";
        }
        try {
            s.valign = getAttributeAsString("valign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.valign:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RibbonButton.vertical:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        RibbonButtonLogicalStructure s = new RibbonButtonLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
