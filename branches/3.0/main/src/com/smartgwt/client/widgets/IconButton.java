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
 
package com.smartgwt.client.widgets;



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
 * A Button subclass that displays an icon, title and optional menuIcon and is capable of  horizontal and vertical
 * orientation.
 */
public class IconButton extends Button {

    public static IconButton getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (IconButton) obj;
        } else {
            return new IconButton(jsObj);
        }
    }

    public IconButton(){
        scClassName = "IconButton";
    }

    public IconButton(JavaScriptObject jsObj){
        super(jsObj);
    }

    public IconButton(String title) {
        setTitle(title);
        scClassName = "IconButton";
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
     * Default CSS class.
     *
     * @param baseStyle baseStyle Default value is "iconButton"
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * Default CSS class.
     *
     *
     * @return String
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    /**
     * Icon to show to the left of or above the title, according to the button's {@link com.smartgwt.client.types.Orientation}.
     * <P> When specifying <code>titleOrientation = "vertical"</code>, this icon will be stretched to  the {@link
     * com.smartgwt.client.widgets.IconButton#getLargeIconSize largeIconSize} unless a {@link
     * com.smartgwt.client.widgets.IconButton#getLargeIcon largeIcon} is specified.
     *
     * @param icon icon Default value is null
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon, true);
    }

    /**
     * Icon to show to the left of or above the title, according to the button's {@link com.smartgwt.client.types.Orientation}.
     * <P> When specifying <code>titleOrientation = "vertical"</code>, this icon will be stretched to  the {@link
     * com.smartgwt.client.widgets.IconButton#getLargeIconSize largeIconSize} unless a {@link
     * com.smartgwt.client.widgets.IconButton#getLargeIcon largeIcon} is specified.
     *
     *
     * @return String
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }

    /**
     * The size of the normal icon for this button.
     *
     * @param iconSize iconSize Default value is 16
     */
    public void setIconSize(int iconSize) {
        setAttribute("iconSize", iconSize, true);
    }

    /**
     * The size of the normal icon for this button.
     *
     *
     * @return int
     */
    public int getIconSize()  {
        return getAttributeAsInt("iconSize");
    }

    /**
     * Icon to show above the title when {@link com.smartgwt.client.types.Orientation} is "vertical". <P> If a largeIcon is not
     * specified, the {@link com.smartgwt.client.widgets.IconButton#getIcon normal icon} will be stretched to  the {@link
     * com.smartgwt.client.widgets.IconButton#getLargeIconSize largeIconSize}.
     *
     * @param largeIcon largeIcon Default value is null
     */
    public void setLargeIcon(String largeIcon) {
        setAttribute("largeIcon", largeIcon, true);
    }

    /**
     * Icon to show above the title when {@link com.smartgwt.client.types.Orientation} is "vertical". <P> If a largeIcon is not
     * specified, the {@link com.smartgwt.client.widgets.IconButton#getIcon normal icon} will be stretched to  the {@link
     * com.smartgwt.client.widgets.IconButton#getLargeIconSize largeIconSize}.
     *
     *
     * @return String
     */
    public String getLargeIcon()  {
        return getAttributeAsString("largeIcon");
    }

    /**
     * The size of the large icon for this button.  If {@link com.smartgwt.client.widgets.IconButton#getLargeIcon largeIcon} is
     * not specified, the {@link com.smartgwt.client.widgets.IconButton#getIcon normal icon} will be stretched to this size.
     *
     * @param largeIconSize largeIconSize Default value is 32
     */
    public void setLargeIconSize(int largeIconSize) {
        setAttribute("largeIconSize", largeIconSize, true);
    }

    /**
     * The size of the large icon for this button.  If {@link com.smartgwt.client.widgets.IconButton#getLargeIcon largeIcon} is
     * not specified, the {@link com.smartgwt.client.widgets.IconButton#getIcon normal icon} will be stretched to this size.
     *
     *
     * @return int
     */
    public int getLargeIconSize()  {
        return getAttributeAsInt("largeIconSize");
    }

    /**
     * Image that shows a {@link com.smartgwt.client.widgets.menu.Menu menu} when clicked.
     *
     * @param menuIconSrc menuIconSrc Default value is "[SKINIMG]/Menu/submenu_down.png"
     */
    public void setMenuIconSrc(String menuIconSrc) {
        setAttribute("menuIconSrc", menuIconSrc, true);
    }

    /**
     * Image that shows a {@link com.smartgwt.client.widgets.menu.Menu menu} when clicked.
     *
     *
     * @return String
     */
    public String getMenuIconSrc()  {
        return getAttributeAsString("menuIconSrc");
    }

    /**
     * The orientation of this IconButton.  The default value, "horizontal", renders icon, title and potentially menuIcon from
     * left to right: "vertical" does the same from top to bottom.
     *
     * @param orientation orientation Default value is "horizontal"
     */
    public void setOrientation(String orientation) {
        setAttribute("orientation", orientation, true);
    }

    /**
     * The orientation of this IconButton.  The default value, "horizontal", renders icon, title and potentially menuIcon from
     * left to right: "vertical" does the same from top to bottom.
     *
     *
     * @return String
     */
    public String getOrientation()  {
        return getAttributeAsString("orientation");
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menu-icon} which fires the {@link
     * com.smartgwt.client.widgets.IconButton#getMenuIconClicked menuIconClicked}  notification method when clicked.
     *
     * @param showMenuIcon showMenuIcon Default value is false
     */
    public void setShowMenuIcon(Boolean showMenuIcon) {
        setAttribute("showMenuIcon", showMenuIcon, true);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menu-icon} which fires the {@link
     * com.smartgwt.client.widgets.IconButton#getMenuIconClicked menuIconClicked}  notification method when clicked.
     *
     *
     * @return Boolean
     */
    public Boolean getShowMenuIcon()  {
        return getAttributeAsBoolean("showMenuIcon");
    }

    /**
     * Image that shows a {@link com.smartgwt.client.widgets.menu.Menu menu} when clicked.
     *
     * @param showMenuIconOver showMenuIconOver Default value is false
     */
    public void setShowMenuIconOver(Boolean showMenuIconOver) {
        setAttribute("showMenuIconOver", showMenuIconOver, true);
    }

    /**
     * Image that shows a {@link com.smartgwt.client.widgets.menu.Menu menu} when clicked.
     *
     *
     * @return Boolean
     */
    public Boolean getShowMenuIconOver()  {
        return getAttributeAsBoolean("showMenuIconOver");
    }

    // ********************* Methods ***********************
            
    /**
     * Notification method fired when a user clicks on the menuIcon on this IconButton.
     */
    public native void menuIconClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.menuIconClick();
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
     * @param iconButtonProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(IconButton iconButtonProperties) /*-{
    	var properties = $wnd.isc.addProperties({},iconButtonProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.IconButton.addProperties(properties);
    }-*/;
        
    // ***********************************************************        

}



