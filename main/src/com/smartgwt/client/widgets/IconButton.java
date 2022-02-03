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
 * A Button subclass that displays an {@link com.smartgwt.client.widgets.IconButton#getIcon icon},  {@link
 * com.smartgwt.client.widgets.IconButton#getShowButtonTitle title} and optional {@link
 * com.smartgwt.client.widgets.IconButton#getMenuIconSrc menuIcon}  and is capable of horizontal and vertical {@link
 * com.smartgwt.client.widgets.IconButton#getOrientation orientation}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("IconButton")
public class IconButton extends Button implements com.smartgwt.client.widgets.menu.events.HasMenuIconClickHandlers {

    public static IconButton getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new IconButton(jsObj);
        } else {
            assert refInstance instanceof IconButton;
            return (IconButton)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(IconButton.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.IconButton.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(IconButton.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.IconButton.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public IconButton(){
        scClassName = "IconButton";
    }

    public IconButton(JavaScriptObject jsObj){
        scClassName = "IconButton";
        setJavaScriptObject(jsObj);
    }


    public IconButton(String title) {
        setTitle(title);
                scClassName = "IconButton";
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
     * Horizontal alignment of this button's content.  If unset,  {@link com.smartgwt.client.widgets.IconButton#getOrientation
     * vertical buttons} are center-aligned and horizontal buttons left-aligned by default.
     *
     * @param align New align value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align == null ? null : align.getValue(), true);
    }

    /**
     * Horizontal alignment of this button's content.  If unset,  {@link com.smartgwt.client.widgets.IconButton#getOrientation
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
     * @param baseStyle New baseStyle value. Default value is "iconButton"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * Default CSS class for this button.
     *
     * @return Current baseStyle value. Default value is "iconButton"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
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
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets a new Icon for this button after initialization.
     *
     * @param icon New icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
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
     * @return Current icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * This attribute is not supported in this subclass.  However, RTL mode is still supported.
     *
     * @param iconAlign New iconAlign value. Default value is null
     */
    public void setIconAlign(String iconAlign) {
        setAttribute("iconAlign", iconAlign, true);
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
     */
    public void setIconOrientation(String iconOrientation) {
        setAttribute("iconOrientation", iconOrientation, true);
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
     * specified, the {@link com.smartgwt.client.widgets.IconButton#getIcon normal icon} will be stretched to  the {@link
     * com.smartgwt.client.widgets.IconButton#getLargeIconSize largeIconSize}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets a new Large-Icon for vertical buttons after initialization - synonymous with  {@link com.smartgwt.client.widgets.IconButton#setIcon setIcon} for normal horizontal buttons.
     *
     * @param largeIcon New largeIcon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setLargeIcon(String largeIcon) {
        setAttribute("largeIcon", largeIcon, true);
    }

    /**
     * Icon to show above the title when {@link com.smartgwt.client.types.Orientation} is "vertical". <P> If a largeIcon is not
     * specified, the {@link com.smartgwt.client.widgets.IconButton#getIcon normal icon} will be stretched to  the {@link
     * com.smartgwt.client.widgets.IconButton#getLargeIconSize largeIconSize}.
     *
     * @return Current largeIcon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getLargeIcon()  {
        return getAttributeAsString("largeIcon");
    }
    

    /**
     * The size of the large icon for this button.  If {@link com.smartgwt.client.widgets.IconButton#getLargeIcon largeIcon} is
     * not specified, the {@link com.smartgwt.client.widgets.IconButton#getIcon normal icon} will be stretched to this size.
     *
     * @param largeIconSize New largeIconSize value. Default value is 32
     */
    public void setLargeIconSize(int largeIconSize) {
        setAttribute("largeIconSize", largeIconSize, true);
    }

    /**
     * The size of the large icon for this button.  If {@link com.smartgwt.client.widgets.IconButton#getLargeIcon largeIcon} is
     * not specified, the {@link com.smartgwt.client.widgets.IconButton#getIcon normal icon} will be stretched to this size.
     *
     * @return Current largeIconSize value. Default value is 32
     */
    public int getLargeIconSize()  {
        return getAttributeAsInt("largeIconSize");
    }
    

    /**
     * The height of the icon for this button.
     *
     * @param menuIconHeight New menuIconHeight value. Default value is 13
     */
    public void setMenuIconHeight(int menuIconHeight) {
        setAttribute("menuIconHeight", menuIconHeight, true);
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
     * com.smartgwt.client.widgets.IconButton#getShowMenuIconDisabled showMenuIconDisabled} and {@link
     * com.smartgwt.client.widgets.IconButton#getShowMenuIconOver showMenuIconOver}.
     *
     * @param menuIconSrc New menuIconSrc value. Default value is "[SKINIMG]/Menu/submenu_down.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setMenuIconSrc(String menuIconSrc) {
        setAttribute("menuIconSrc", menuIconSrc, true);
    }

    /**
     * Base URL for an Image that shows a {@link com.smartgwt.client.widgets.menu.Menu menu} when clicked.  See also  {@link
     * com.smartgwt.client.widgets.IconButton#getShowMenuIconDisabled showMenuIconDisabled} and {@link
     * com.smartgwt.client.widgets.IconButton#getShowMenuIconOver showMenuIconOver}.
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
     */
    public void setMenuIconWidth(int menuIconWidth) {
        setAttribute("menuIconWidth", menuIconWidth, true);
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
     * The orientation of this IconButton.  The default value, "horizontal", renders  {@link
     * com.smartgwt.client.widgets.IconButton#getIcon icon}, {@link com.smartgwt.client.widgets.IconButton#getShowButtonTitle
     * title} and potentially  {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menuIcon}, from left to right:
     * "vertical" does the same from  top to bottom.
     *
     * @param orientation New orientation value. Default value is "horizontal"
     */
    public void setOrientation(String orientation) {
        setAttribute("orientation", orientation, true);
    }

    /**
     * The orientation of this IconButton.  The default value, "horizontal", renders  {@link
     * com.smartgwt.client.widgets.IconButton#getIcon icon}, {@link com.smartgwt.client.widgets.IconButton#getShowButtonTitle
     * title} and potentially  {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menuIcon}, from left to right:
     * "vertical" does the same from  top to bottom.
     *
     * @return Current orientation value. Default value is "horizontal"
     */
    public String getOrientation()  {
        return getAttributeAsString("orientation");
    }
    

    /**
     * When used in a {@link com.smartgwt.client.widgets.toolbar.RibbonBar}, the number of rows this button should occupy in a
     * single {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup#getColumnLayout column}.
     *
     * @param rowSpan New rowSpan value. Default value is 1
     */
    public void setRowSpan(int rowSpan) {
        setAttribute("rowSpan", rowSpan, true);
    }

    /**
     * When used in a {@link com.smartgwt.client.widgets.toolbar.RibbonBar}, the number of rows this button should occupy in a
     * single {@link com.smartgwt.client.widgets.toolbar.ToolStripGroup#getColumnLayout column}.
     *
     * @return Current rowSpan value. Default value is 1
     */
    public int getRowSpan()  {
        return getAttributeAsInt("rowSpan");
    }
    

    /**
     * Whether to show the title-text for this IconButton.  If set to false, title-text is omitted altogether and just the icon
     * is displayed.
     *
     * @param showButtonTitle New showButtonTitle value. Default value is true
     */
    public void setShowButtonTitle(Boolean showButtonTitle) {
        setAttribute("showButtonTitle", showButtonTitle, true);
    }

    /**
     * Whether to show the title-text for this IconButton.  If set to false, title-text is omitted altogether and just the icon
     * is displayed.
     *
     * @return Current showButtonTitle value. Default value is true
     */
    public Boolean getShowButtonTitle()  {
        Boolean result = getAttributeAsBoolean("showButtonTitle");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show an Icon in this IconButton.  Set to false to render a text-only button.
     *
     * @param showIcon New showIcon value. Default value is null
     */
    public void setShowIcon(Boolean showIcon) {
        setAttribute("showIcon", showIcon, true);
    }

    /**
     * Whether to show an Icon in this IconButton.  Set to false to render a text-only button.
     *
     * @return Current showIcon value. Default value is null
     */
    public Boolean getShowIcon()  {
        return getAttributeAsBoolean("showIcon");
    }
    

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menu-icon} which fires the {@link
     * com.smartgwt.client.widgets.IconButton#addMenuIconClickHandler IconButton.menuIconClick()}  notification method when
     * clicked.
     *
     * @param showMenuIcon New showMenuIcon value. Default value is false
     */
    public void setShowMenuIcon(Boolean showMenuIcon) {
        setAttribute("showMenuIcon", showMenuIcon, true);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menu-icon} which fires the {@link
     * com.smartgwt.client.widgets.IconButton#addMenuIconClickHandler IconButton.menuIconClick()}  notification method when
     * clicked.
     *
     * @return Current showMenuIcon value. Default value is false
     */
    public Boolean getShowMenuIcon()  {
        Boolean result = getAttributeAsBoolean("showMenuIcon");
        return result == null ? false : result;
    }
    

    /**
     * Whether to show a Disabled version of the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menuIcon}.
     *
     * @param showMenuIconDisabled New showMenuIconDisabled value. Default value is true
     */
    public void setShowMenuIconDisabled(Boolean showMenuIconDisabled) {
        setAttribute("showMenuIconDisabled", showMenuIconDisabled, true);
    }

    /**
     * Whether to show a Disabled version of the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menuIcon}.
     *
     * @return Current showMenuIconDisabled value. Default value is true
     */
    public Boolean getShowMenuIconDisabled()  {
        Boolean result = getAttributeAsBoolean("showMenuIconDisabled");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show a Down version of the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menuIcon}.
     *
     * @param showMenuIconDown New showMenuIconDown value. Default value is false
     */
    public void setShowMenuIconDown(Boolean showMenuIconDown) {
        setAttribute("showMenuIconDown", showMenuIconDown, true);
    }

    /**
     * Whether to show a Down version of the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menuIcon}.
     *
     * @return Current showMenuIconDown value. Default value is false
     */
    public Boolean getShowMenuIconDown()  {
        Boolean result = getAttributeAsBoolean("showMenuIconDown");
        return result == null ? false : result;
    }
    

    /**
     * Whether to show an Over version of the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menuIcon}.
     *
     * @param showMenuIconOver New showMenuIconOver value. Default value is true
     */
    public void setShowMenuIconOver(Boolean showMenuIconOver) {
        setAttribute("showMenuIconOver", showMenuIconOver, true);
    }

    /**
     * Whether to show an Over version of the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menuIcon}.
     *
     * @return Current showMenuIconOver value. Default value is true
     */
    public Boolean getShowMenuIconOver()  {
        Boolean result = getAttributeAsBoolean("showMenuIconOver");
        return result == null ? true : result;
    }
    

    /**
     * If set to true, shows this button's {@link com.smartgwt.client.widgets.menu.Menu menu} when a user clicks anywhere  in
     * the button, rather than specifically on the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menuIcon}. <P>
     * Note that this property has a different meaning than {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowMenuOnClick showMenuOnClick} in the ancestor class {@link
     * com.smartgwt.client.widgets.StatefulCanvas}.
     *
     * @param showMenuOnClick New showMenuOnClick value. Default value is false
     */
    public void setShowMenuOnClick(Boolean showMenuOnClick) {
        setAttribute("showMenuOnClick", showMenuOnClick, true);
    }

    /**
     * If set to true, shows this button's {@link com.smartgwt.client.widgets.menu.Menu menu} when a user clicks anywhere  in
     * the button, rather than specifically on the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menuIcon}. <P>
     * Note that this property has a different meaning than {@link
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
     * showTitle is not applicable to this class - use {@link com.smartgwt.client.widgets.IconButton#getShowButtonTitle
     * showButtonTitle} instead.
     *
     * @param showTitle New showTitle value. Default value is null
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle, true);
    }

    /**
     * showTitle is not applicable to this class - use {@link com.smartgwt.client.widgets.IconButton#getShowButtonTitle
     * showButtonTitle} instead.
     *
     * @return Current showTitle value. Default value is null
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }
    

    /**
     * Vertical alignment of this button's content.  If unset,  {@link com.smartgwt.client.widgets.IconButton#getOrientation
     * vertical buttons} are top-aligned and horizontal buttons center-aligned by default.
     *
     * @param valign New valign value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setValign(VerticalAlignment valign) {
        setAttribute("valign", valign == null ? null : valign.getValue(), true);
    }

    /**
     * Vertical alignment of this button's content.  If unset,  {@link com.smartgwt.client.widgets.IconButton#getOrientation
     * vertical buttons} are top-aligned and horizontal buttons center-aligned by default.
     *
     * @return Current valign value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public VerticalAlignment getValign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("valign"));
    }
    

    // ********************* Methods ***********************
	/**
     * Notification method fired when a user clicks anywhere on this button.  If the click occurred directly on the {@link
     * com.smartgwt.client.widgets.Button#getIcon icon} or the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc
     * menuIcon},  the related notifications {@link com.smartgwt.client.widgets.IconButton#iconClick iconClick} and  {@link
     * com.smartgwt.client.widgets.IconButton#addMenuIconClickHandler menuIconClick} are fired first and must return false to 
     * prevent this notification from firing. <P> If a {@link com.smartgwt.client.widgets.menu.Menu menu} is installed then, by
     * default, it is only displayed when a  user clicks on the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc
     * menuIcon}.  This can be altered via  {@link com.smartgwt.client.widgets.IconButton#getShowMenuOnClick showMenuOnClick}.
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
     * Notification method fired when a user clicks on the {@link com.smartgwt.client.widgets.IconButton#getIcon icon} in this 
     * IconButton.    call <code>event.cancel()</code> to suppress the standard  click handling code.
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
     * Notification method fired when a user clicks on the menuIcon on this IconButton.    call <code>event.cancel()</code> to
     * suppress the standard  click handling code.
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
            selfJ.@com.smartgwt.client.widgets.IconButton::handleTearDownMenuIconClickEvent()();
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
     * @param iconButtonProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(IconButton iconButtonProperties) /*-{
        if (iconButtonProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(IconButton.@java.lang.Object::getClass()(), "setDefaultProperties", iconButtonProperties.@java.lang.Object::getClass()());
        }
        iconButtonProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = iconButtonProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.IconButton.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(IconButtonLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.align = getAttributeAsString("align");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.align:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.icon = getAttributeAsString("icon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.icon:" + t.getMessage() + "\n";
        }
        try {
            s.iconAlign = getAttributeAsString("iconAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.iconAlign:" + t.getMessage() + "\n";
        }
        try {
            s.iconOrientation = getAttributeAsString("iconOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.iconOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.largeIcon = getAttributeAsString("largeIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.largeIcon:" + t.getMessage() + "\n";
        }
        try {
            s.largeIconSize = getAttributeAsString("largeIconSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.largeIconSize:" + t.getMessage() + "\n";
        }
        try {
            s.menuIconHeight = getAttributeAsString("menuIconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.menuIconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.menuIconSrc = getAttributeAsString("menuIconSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.menuIconSrc:" + t.getMessage() + "\n";
        }
        try {
            s.menuIconWidth = getAttributeAsString("menuIconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.menuIconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.orientation = getAttributeAsString("orientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.orientation:" + t.getMessage() + "\n";
        }
        try {
            s.rowSpan = getAttributeAsString("rowSpan");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.rowSpan:" + t.getMessage() + "\n";
        }
        try {
            s.showButtonTitle = getAttributeAsString("showButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.showButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.showIcon = getAttributeAsString("showIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.showIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuIcon = getAttributeAsString("showMenuIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.showMenuIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuIconDisabled = getAttributeAsString("showMenuIconDisabled");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.showMenuIconDisabled:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuIconDown = getAttributeAsString("showMenuIconDown");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.showMenuIconDown:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuIconOver = getAttributeAsString("showMenuIconOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.showMenuIconOver:" + t.getMessage() + "\n";
        }
        try {
            s.showMenuOnClick = getAttributeAsString("showMenuOnClick");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.showMenuOnClick:" + t.getMessage() + "\n";
        }
        try {
            s.showTitle = getAttributeAsString("showTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.showTitle:" + t.getMessage() + "\n";
        }
        try {
            s.valign = getAttributeAsString("valign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.valign:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        IconButtonLogicalStructure s = new IconButtonLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
