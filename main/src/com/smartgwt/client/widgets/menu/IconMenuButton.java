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
 * A subclass of {@link com.smartgwt.client.widgets.IconButton} that shows a menuIcon by default and implements showMenu().
 */
public class IconMenuButton extends IconButton {

    public static IconMenuButton getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (IconMenuButton) obj;
        } else {
            return new IconMenuButton(jsObj);
        }
    }

    public IconMenuButton(){
        scClassName = "IconMenuButton";
    }

    public IconMenuButton(JavaScriptObject jsObj){
        super(jsObj);
    }

    public IconMenuButton(String title) {
        setTitle(title);
        scClassName = "IconMenuButton";
    }

    public IconMenuButton(String title, Menu menu) {
        setTitle(title);
		setMenu(menu);
        scClassName = "IconMenuButton";
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
     * The menu to show when the  menu-icon is clicked. <P> For a menu button with no menu (menu: null) the up/down arrow image
     * can be suppressed by setting {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuButtonImage
     * showMenuButtonImage}: <code>false</code>.
     *
     * @param menu menu Default value is null
     */
    public void setMenu(Menu menu) {
        setAttribute("menu", menu == null ? null : menu.getOrCreateJsObj(), true);
    }

    /**
     * The menu to show when the  menu-icon is clicked. <P> For a menu button with no menu (menu: null) the up/down arrow image
     * can be suppressed by setting {@link com.smartgwt.client.widgets.menu.MenuButton#getShowMenuButtonImage
     * showMenuButtonImage}: <code>false</code>.
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

    // ********************* Methods ***********************
            
    /**
     * Shows this button's {@link com.smartgwt.client.widgets.menu.IconMenuButton#getMenu menu}.  Called automatically when a
     * user clicks the  {@link com.smartgwt.client.widgets.menu.IconMenuButton#getMenuIconSrc menuIcon}.
     */
    public native void showMenu() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showMenu();
    }-*/;

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
     * @param iconMenuButtonProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(IconMenuButton iconMenuButtonProperties) /*-{
    	var properties = $wnd.isc.addProperties({},iconMenuButtonProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.IconMenuButton.addProperties(properties);
    }-*/;
        
    // ***********************************************************        

}



