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
 * Simple subclass of button associated with a menu widget (gets shown below the button).
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("MenuButton")
public class MenuButton extends Button {

    public static MenuButton getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new MenuButton(jsObj);
        } else {
            assert refInstance instanceof MenuButton;
            return (MenuButton)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MenuButton.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.MenuButton.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MenuButton.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.MenuButton.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public MenuButton(){
        scClassName = "MenuButton";
    }

    public MenuButton(JavaScriptObject jsObj){
        scClassName = "MenuButton";
        setJavaScriptObject(jsObj);
    }


    public MenuButton(String title) {
        setTitle(title);
                scClassName = "MenuButton";
    }


    public MenuButton(String title, Menu menu) {
        setTitle(title);
		setMenu(menu);
                scClassName = "MenuButton";
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
     * If this menuButton is {@link com.smartgwt.client.widgets.Canvas#destroy destroyed}, should it also destroy its {@link
     * com.smartgwt.client.widgets.menu.MenuButton#getMenu menu}?
     *
     * @param autoDestroyMenu New autoDestroyMenu value. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     */
    public MenuButton setAutoDestroyMenu(Boolean autoDestroyMenu) {
        return (MenuButton)setAttribute("autoDestroyMenu", autoDestroyMenu, true);
    }

    /**
     * If this menuButton is {@link com.smartgwt.client.widgets.Canvas#destroy destroyed}, should it also destroy its {@link
     * com.smartgwt.client.widgets.menu.MenuButton#getMenu menu}?
     *
     * @return Current autoDestroyMenu value. Default value is true
     */
    public Boolean getAutoDestroyMenu()  {
        Boolean result = getAttributeAsBoolean("autoDestroyMenu");
        return result == null ? true : result;
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "MenuEditProxy"
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public MenuButton setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (MenuButton)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "MenuEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    
    

    /**
     * If this MenuButton has a specified {@link com.smartgwt.client.widgets.Canvas#getAccessKey accessKey}, underline it in
     * the title of the button by default
     *
     * @param hiliteAccessKey New hiliteAccessKey value. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MenuButton setHiliteAccessKey(Boolean hiliteAccessKey)  throws IllegalStateException {
        return (MenuButton)setAttribute("hiliteAccessKey", hiliteAccessKey, false);
    }

    /**
     * If this MenuButton has a specified {@link com.smartgwt.client.widgets.Canvas#getAccessKey accessKey}, underline it in
     * the title of the button by default
     *
     * @return Current hiliteAccessKey value. Default value is true
     */
    public Boolean getHiliteAccessKey()  {
        Boolean result = getAttributeAsBoolean("hiliteAccessKey");
        return result == null ? true : result;
    }
    

    /**
     * This property corresponds to the inherited {@link com.smartgwt.client.widgets.Button#getIcon Button.icon} property,
     * which is used to display the menuButtonImage, so anything you attempt  to set there would be clobbered by the internal
     * usage.  <P> You could add an icon via the {@link com.smartgwt.client.widgets.menu.MenuButton#getTitle title} property, 
     * by using {@link com.smartgwt.client.widgets.Canvas#imgHTML Canvas.imgHTML()} to generate an appropriate  &lt;img&gt; tag
     * and pre-pending it to your title.
     *
     * @param icon New icon value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#buttons_category_icons" target="examples">Icons Example</a>
     */
    public MenuButton setIcon(String icon) {
        return (MenuButton)setAttribute("icon", icon, true);
    }

    /**
     * This property corresponds to the inherited {@link com.smartgwt.client.widgets.Button#getIcon Button.icon} property,
     * which is used to display the menuButtonImage, so anything you attempt  to set there would be clobbered by the internal
     * usage.  <P> You could add an icon via the {@link com.smartgwt.client.widgets.menu.MenuButton#getTitle title} property, 
     * by using {@link com.smartgwt.client.widgets.Canvas#imgHTML Canvas.imgHTML()} to generate an appropriate  &lt;img&gt; tag
     * and pre-pending it to your title.
     *
     * @return Current icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#buttons_category_icons" target="examples">Icons Example</a>
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * The menu to show. <P> For a menu button with no menu (menu: null) the up/down arrow image can be suppressed by setting
     * {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuButtonImage showMenuButtonImage}: <code>false</code>.
     *
     * @param menu New menu value. Default value is null
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     */
    public MenuButton setMenu(Menu menu) {
        return (MenuButton)setAttribute("menu", menu == null ? null : menu.getOrCreateJsObj(), true);
    }

    /**
     * The menu to show. <P> For a menu button with no menu (menu: null) the up/down arrow image can be suppressed by setting
     * {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuButtonImage showMenuButtonImage}: <code>false</code>.
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
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MenuButton setMenuAlign(Alignment menuAlign)  throws IllegalStateException {
        return (MenuButton)setAttribute("menuAlign", menuAlign == null ? null : menuAlign.getValue(), false);
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
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     */
    public MenuButton setMenuAnimationEffect(String menuAnimationEffect) {
        return (MenuButton)setAttribute("menuAnimationEffect", menuAnimationEffect, true);
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
     * Image for menu button indicating that the button expands a menu.  This image is shown for menus expanding down from the
     * button.   Menu direction is controlled by {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuBelow
     * showMenuBelow}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param menuButtonImage New menuButtonImage value. Default value is "[SKIN]menu_button.gif"
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.menu.MenuButton#setMenuButtonImageUp
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public MenuButton setMenuButtonImage(String menuButtonImage)  throws IllegalStateException {
        return (MenuButton)setAttribute("menuButtonImage", menuButtonImage, false);
    }

    /**
     * Image for menu button indicating that the button expands a menu.  This image is shown for menus expanding down from the
     * button.   Menu direction is controlled by {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuBelow
     * showMenuBelow}.
     *
     * @return Current menuButtonImage value. Default value is "[SKIN]menu_button.gif"
     * @see com.smartgwt.client.widgets.menu.MenuButton#getMenuButtonImageUp
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getMenuButtonImage()  {
        return getAttributeAsString("menuButtonImage");
    }
    

    /**
     * Image for menu button indicating that the button expands a menu.  This image is shown for menus expanding up from the
     * button.   Menu direction is controlled by {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuBelow
     * showMenuBelow}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param menuButtonImageUp New menuButtonImageUp value. Default value is "[SKIN]menu_button_up.gif"
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.menu.MenuButton#setMenuButtonImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public MenuButton setMenuButtonImageUp(String menuButtonImageUp)  throws IllegalStateException {
        return (MenuButton)setAttribute("menuButtonImageUp", menuButtonImageUp, false);
    }

    /**
     * Image for menu button indicating that the button expands a menu.  This image is shown for menus expanding up from the
     * button.   Menu direction is controlled by {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuBelow
     * showMenuBelow}.
     *
     * @return Current menuButtonImageUp value. Default value is "[SKIN]menu_button_up.gif"
     * @see com.smartgwt.client.widgets.menu.MenuButton#getMenuButtonImage
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getMenuButtonImageUp()  {
        return getAttributeAsString("menuButtonImageUp");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuOnRollOver showMenuOnRollOver} is true, this is the
     * delay  in milliseconds before the menu is automatically hidden following mouseOut.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param rollOverMenuHideDelay New rollOverMenuHideDelay value. Default value is 250
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public MenuButton setRollOverMenuHideDelay(int rollOverMenuHideDelay)  throws IllegalStateException {
        return (MenuButton)setAttribute("rollOverMenuHideDelay", rollOverMenuHideDelay, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuOnRollOver showMenuOnRollOver} is true, this is the
     * delay  in milliseconds before the menu is automatically hidden following mouseOut.
     *
     * @return Current rollOverMenuHideDelay value. Default value is 250
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getRollOverMenuHideDelay()  {
        return getAttributeAsInt("rollOverMenuHideDelay");
    }
    

    /**
     * The menu drops down below the menu button.   Set to false if the menu should appear above the menu button.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the 'showMenuButtonBelow' property - determines whether the menu will be shown above or below the menubutton.
     *
     * @param showMenuBelow True if the menu should be shown below the menubutton. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     */
    public MenuButton setShowMenuBelow(Boolean showMenuBelow) {
        return (MenuButton)setAttribute("showMenuBelow", showMenuBelow, true);
    }

    /**
     * The menu drops down below the menu button.   Set to false if the menu should appear above the menu button.
     *
     * @return Current showMenuBelow value. Default value is true
     */
    public Boolean getShowMenuBelow()  {
        Boolean result = getAttributeAsBoolean("showMenuBelow");
        return result == null ? true : result;
    }
    

    /**
     * Show menu button image (up / down arrowhead) for this menu button.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the 'showMenuButtonImage' property - shows/hides the menu button image at runtime.
     *
     * @param showMenuButtonImage Should the image be shown. Default value is true
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MenuButton setShowMenuButtonImage(Boolean showMenuButtonImage)  throws IllegalStateException {
        return (MenuButton)setAttribute("showMenuButtonImage", showMenuButtonImage, false);
    }

    /**
     * Show menu button image (up / down arrowhead) for this menu button.
     *
     * @return Current showMenuButtonImage value. Default value is true
     */
    public Boolean getShowMenuButtonImage()  {
        Boolean result = getAttributeAsBoolean("showMenuButtonImage");
        return result == null ? true : result;
    }
    

    /**
     * Should the menu be shown automatically when the mouse moves over the button? <p> When enabled, menus used with this
     * <code>MenuButton</code> should not be used with any other component.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showMenuOnRollOver New showMenuOnRollOver value. Default value is false
     * @return {@link com.smartgwt.client.widgets.menu.MenuButton MenuButton} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public MenuButton setShowMenuOnRollOver(Boolean showMenuOnRollOver)  throws IllegalStateException {
        return (MenuButton)setAttribute("showMenuOnRollOver", showMenuOnRollOver, false);
    }

    /**
     * Should the menu be shown automatically when the mouse moves over the button? <p> When enabled, menus used with this
     * <code>MenuButton</code> should not be used with any other component.
     *
     * @return Current showMenuOnRollOver value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowMenuOnRollOver()  {
        Boolean result = getAttributeAsBoolean("showMenuOnRollOver");
        return result == null ? false : result;
    }
    

    /**
     * Default title for the button.
     *
     * @param title New title value. Default value is "Show Menu"
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * Default title for the button.
     *
     * @return Current title value. Default value is "Show Menu"
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    // ********************* Methods ***********************
	/**
     * Programmaticly forces this MenuButton to show it's menu.
     */
    public native void showMenu() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showMenu", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showMenu();
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
     * @param menuButtonProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(MenuButton menuButtonProperties) /*-{
        if (menuButtonProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(MenuButton.@java.lang.Object::getClass()(), "setDefaultProperties", menuButtonProperties.@java.lang.Object::getClass()());
        }
        menuButtonProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = menuButtonProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.MenuButton.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(MenuButtonLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.autoDestroyMenu = getAttributeAsString("autoDestroyMenu");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.autoDestroyMenu:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteAccessKey = getAttributeAsString("hiliteAccessKey");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.hiliteAccessKey:" + t.getMessage() + "\n";
        }
        try {
            s.icon = getAttributeAsString("icon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.icon:" + t.getMessage() + "\n";
        }
        try {
            s.menu = getMenu();
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.menu:" + t.getMessage() + "\n";
        }
        try {
            s.menuAlign = getAttributeAsString("menuAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.menuAlign:" + t.getMessage() + "\n";
        }
        try {
            s.menuAnimationEffect = getAttributeAsString("menuAnimationEffect");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.menuAnimationEffect:" + t.getMessage() + "\n";
        }
        try {
            s.menuButtonImage = getAttributeAsString("menuButtonImage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.menuButtonImage:" + t.getMessage() + "\n";
        }
        try {
            s.menuButtonImageUp = getAttributeAsString("menuButtonImageUp");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.menuButtonImageUp:" + t.getMessage() + "\n";
        }
        try {
            s.rollOverMenuHideDelay = getAttributeAsString("rollOverMenuHideDelay");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.rollOverMenuHideDelay:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuBelow = getAttributeAsString("showMenuBelow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.showMenuBelow:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuButtonImage = getAttributeAsString("showMenuButtonImage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.showMenuButtonImage:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuOnRollOver = getAttributeAsString("showMenuOnRollOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.showMenuOnRollOver:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MenuButton.title:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        MenuButtonLogicalStructure s = new MenuButtonLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
