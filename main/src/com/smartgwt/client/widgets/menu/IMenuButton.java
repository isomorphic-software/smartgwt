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
 
package com.smartgwt.client.widgets.menu;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * StretchImgButton based version of the {@link com.smartgwt.client.widgets.menu.MenuButton} class.
 */
public class IMenuButton extends StretchImgButton {

    public static IMenuButton getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (IMenuButton) obj;
        } else {
            return new IMenuButton(jsObj);
        }
    }

    public IMenuButton(){
        scClassName = "IMenuButton";
    }

    public IMenuButton(JavaScriptObject jsObj){
        super(jsObj);
    }

    public IMenuButton(String title) {
        setTitle(title);
        scClassName = "IMenuButton";
    }

    public IMenuButton(String title, Menu menu) {
        setTitle(title);
		setMenu(menu);
        scClassName = "IMenuButton";
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * If this menuButton is {@link com.smartgwt.client.widgets.Canvas#destroy destroyed}, should it also destroy its {@link
     * com.smartgwt.client.widgets.menu.MenuButton#getMenu menu}?
     *
     * @param autoDestroyMenu autoDestroyMenu Default value is true
     */
    public void setAutoDestroyMenu(Boolean autoDestroyMenu) {
        setAttribute("autoDestroyMenu", autoDestroyMenu, true);
    }

    /**
     * If this menuButton is {@link com.smartgwt.client.widgets.Canvas#destroy destroyed}, should it also destroy its {@link
     * com.smartgwt.client.widgets.menu.MenuButton#getMenu menu}?
     *
     *
     * @return Boolean
     */
    public Boolean getAutoDestroyMenu()  {
        return getAttributeAsBoolean("autoDestroyMenu");
    }

    /**
     * If this MenuButton has a specified {@link com.smartgwt.client.widgets.Canvas#getAccessKey accessKey}, underline it in
     * the title of the button by default
     *
     * @param hiliteAccessKey hiliteAccessKey Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHiliteAccessKey(Boolean hiliteAccessKey)  throws IllegalStateException {
        setAttribute("hiliteAccessKey", hiliteAccessKey, false);
    }

    /**
     * If this MenuButton has a specified {@link com.smartgwt.client.widgets.Canvas#getAccessKey accessKey}, underline it in
     * the title of the button by default
     *
     *
     * @return Boolean
     */
    public Boolean getHiliteAccessKey()  {
        return getAttributeAsBoolean("hiliteAccessKey");
    }

    /**
     * The menu to show. <P> For a menu button with no menu (menu: null) the up/down arrow image can be suppressed by setting
     * {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuButtonImage showMenuButtonImage}: <code>false</code>.
     *
     * @param menu menu Default value is null
     */
    public void setMenu(Menu menu) {
        setAttribute("menu", menu == null ? null : menu.getOrCreateJsObj(), true);
    }

    /**
     * The menu to show. <P> For a menu button with no menu (menu: null) the up/down arrow image can be suppressed by setting
     * {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuButtonImage showMenuButtonImage}: <code>false</code>.
     *
     *
     * @return Menu
     */
    public Menu getMenu()  {
        return Menu.getOrCreateRef(getAttributeAsJavaScriptObject("menu"));
    }

    /**
     * Allows you to specify an animation effect to apply to the menu when it is being shown. Valid options are "none" (no
     * animation), "fade", "slide" and "wipe". If unspecified falls through to <code>menu.showAnimationEffect</code>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param menuAnimationEffect menuAnimationEffect Default value is null
     */
    public void setMenuAnimationEffect(String menuAnimationEffect) {
        setAttribute("menuAnimationEffect", menuAnimationEffect, true);
    }

    /**
     * Allows you to specify an animation effect to apply to the menu when it is being shown. Valid options are "none" (no
     * animation), "fade", "slide" and "wipe". If unspecified falls through to <code>menu.showAnimationEffect</code>
     *
     *
     * @return String
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
     * @param menuButtonImage menuButtonImage Default value is "[SKIN]menu_button.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.menu.MenuButton#setMenuButtonImageUp
     */
    public void setMenuButtonImage(String menuButtonImage)  throws IllegalStateException {
        setAttribute("menuButtonImage", menuButtonImage, false);
    }

    /**
     * Image for menu button indicating that the button expands a menu.  This image is shown for menus expanding down from the
     * button.   Menu direction is controlled by {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuBelow
     * showMenuBelow}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.menu.MenuButton#getMenuButtonImageUp
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
     * @param menuButtonImageUp menuButtonImageUp Default value is "[SKIN]menu_button_up.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.menu.MenuButton#setMenuButtonImage
     */
    public void setMenuButtonImageUp(String menuButtonImageUp)  throws IllegalStateException {
        setAttribute("menuButtonImageUp", menuButtonImageUp, false);
    }

    /**
     * Image for menu button indicating that the button expands a menu.  This image is shown for menus expanding up from the
     * button.   Menu direction is controlled by {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuBelow
     * showMenuBelow}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.menu.MenuButton#getMenuButtonImage
     */
    public String getMenuButtonImageUp()  {
        return getAttributeAsString("menuButtonImageUp");
    }

    /**
     * The menu drops down below the menu button.   Set to false if the menu should appear above the menu button.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the 'showMenuButtonBelow' property - determines whether the menu will be shown above or below the menubutton.
     *
     * @param showMenuBelow True if the menu should be shown below the menubutton.. Default value is true
     */
    public void setShowMenuBelow(Boolean showMenuBelow) {
        setAttribute("showMenuBelow", showMenuBelow, true);
    }

    /**
     * The menu drops down below the menu button.   Set to false if the menu should appear above the menu button.
     *
     *
     * @return Boolean
     */
    public Boolean getShowMenuBelow()  {
        return getAttributeAsBoolean("showMenuBelow");
    }

    /**
     * Show menu button image (up / down arrowhead) for this menu button.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the 'showMenuButtonImage' property - shows/hides the menu button image at runtime.
     *
     * @param showMenuButtonImage Should the image be shown. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowMenuButtonImage(Boolean showMenuButtonImage)  throws IllegalStateException {
        setAttribute("showMenuButtonImage", showMenuButtonImage, false);
    }

    /**
     * Show menu button image (up / down arrowhead) for this menu button.
     *
     *
     * @return Boolean
     */
    public Boolean getShowMenuButtonImage()  {
        return getAttributeAsBoolean("showMenuButtonImage");
    }

    /**
     * Default title for the button.
     *
     * @param title title Default value is "Show Menu"
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * Default title for the button.
     *
     *
     * @return String
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript). 
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param iMenuButtonProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(IMenuButton iMenuButtonProperties) /*-{
    	var properties = $wnd.isc.addProperties({},iMenuButtonProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.IMenuButton.addProperties(properties);
    }-*/;
        
    // ***********************************************************        

}



