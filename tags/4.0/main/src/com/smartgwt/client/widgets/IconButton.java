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
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * A Button subclass that displays an icon, title and optional menuIcon and is capable of  horizontal and vertical
 * orientation.
 */
public class IconButton extends Button  implements com.smartgwt.client.widgets.menu.events.HasMenuIconClickHandlers {

    public native static IconButton getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("IconButton",jsObj);
        } else {
            return instance;
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }



    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc["IconButton"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc["IconButton"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
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
        this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Ljava/lang/String;Z)(widget.getID(), true);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************


    /**
     * Horizontal alignment of this button's content.  If unset,  {@link com.smartgwt.client.widgets.IconButton#getOrientation
     * vertical buttons} are center-aligned and horizontal buttons left-aligned by default.
     *
     * @param align align Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align == null ? null : align.getValue(), true);
    }

    /**
     * Horizontal alignment of this button's content.  If unset,  {@link com.smartgwt.client.widgets.IconButton#getOrientation
     * vertical buttons} are center-aligned and horizontal buttons left-aligned by default.
     *
     * @return Alignment
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }


    /**
     * Default CSS class.
     *
     * @param baseStyle . See {@link com.smartgwt.client.docs.CSSClassName CSSClassName}. Default value is "iconButton"
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * Default CSS class.
     *
     * @return . See {@link com.smartgwt.client.docs.CSSClassName CSSClassName}
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
     * @param icon . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is null
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
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }


    /**
     * This attribute is not supported in this subclass.  However, RTL mode is still supported.
     *
     * @param iconAlign . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setIconAlign(String iconAlign) {
        setAttribute("iconAlign", iconAlign, true);
    }

    /**
     * This attribute is not supported in this subclass.  However, RTL mode is still supported.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getIconAlign()  {
        return getAttributeAsString("iconAlign");
    }


    /**
     * This attribute is not supported in this subclass.  However, RTL mode is still supported.
     *
     * @param iconOrientation . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setIconOrientation(String iconOrientation) {
        setAttribute("iconOrientation", iconOrientation, true);
    }

    /**
     * This attribute is not supported in this subclass.  However, RTL mode is still supported.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param largeIcon . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is null
     */
    public void setLargeIcon(String largeIcon) {
        setAttribute("largeIcon", largeIcon, true);
    }

    /**
     * Icon to show above the title when {@link com.smartgwt.client.types.Orientation} is "vertical". <P> If a largeIcon is not
     * specified, the {@link com.smartgwt.client.widgets.IconButton#getIcon normal icon} will be stretched to  the {@link
     * com.smartgwt.client.widgets.IconButton#getLargeIconSize largeIconSize}.
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
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
     * @return int
     */
    public int getLargeIconSize()  {
        return getAttributeAsInt("largeIconSize");
    }


    /**
     * Base URL for an Image that shows a {@link com.smartgwt.client.widgets.menu.Menu menu} when clicked.  See also  {@link
     * com.smartgwt.client.widgets.IconButton#getShowMenuIconDisabled showMenuIconDisabled} and {@link
     * com.smartgwt.client.widgets.IconButton#getShowMenuIconOver showMenuIconOver}.
     *
     * @param menuIconSrc . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKINIMG]/Menu/submenu_down.png"
     */
    public void setMenuIconSrc(String menuIconSrc) {
        setAttribute("menuIconSrc", menuIconSrc, true);
    }

    /**
     * Base URL for an Image that shows a {@link com.smartgwt.client.widgets.menu.Menu menu} when clicked.  See also  {@link
     * com.smartgwt.client.widgets.IconButton#getShowMenuIconDisabled showMenuIconDisabled} and {@link
     * com.smartgwt.client.widgets.IconButton#getShowMenuIconOver showMenuIconOver}.
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     */
    public String getMenuIconSrc()  {
        return getAttributeAsString("menuIconSrc");
    }


    /**
     * The orientation of this IconButton.  The default value, "horizontal", renders icon, title and potentially menuIcon from
     * left to right: "vertical" does the same from top to bottom.
     *
     * @param orientation . See {@link com.smartgwt.client.docs.String String}. Default value is "horizontal"
     */
    public void setOrientation(String orientation) {
        setAttribute("orientation", orientation, true);
    }

    /**
     * The orientation of this IconButton.  The default value, "horizontal", renders icon, title and potentially menuIcon from
     * left to right: "vertical" does the same from top to bottom.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getOrientation()  {
        return getAttributeAsString("orientation");
    }


    /**
     * When used in a {@link com.smartgwt.client.widgets.toolbar.RibbonBar}, the number of rows this button should consume.
     *
     * @param rowSpan rowSpan Default value is 1
     */
    public void setRowSpan(int rowSpan) {
        setAttribute("rowSpan", rowSpan, true);
    }

    /**
     * When used in a {@link com.smartgwt.client.widgets.toolbar.RibbonBar}, the number of rows this button should consume.
     *
     * @return int
     */
    public int getRowSpan()  {
        return getAttributeAsInt("rowSpan");
    }


    /**
     * Whether to show the title-text for this IconButton.  If set to false, title-text is omitted altogether and just the icon
     * is displayed.
     *
     * @param showButtonTitle showButtonTitle Default value is true
     */
    public void setShowButtonTitle(Boolean showButtonTitle) {
        setAttribute("showButtonTitle", showButtonTitle, true);
    }

    /**
     * Whether to show the title-text for this IconButton.  If set to false, title-text is omitted altogether and just the icon
     * is displayed.
     *
     * @return Boolean
     */
    public Boolean getShowButtonTitle()  {
        return getAttributeAsBoolean("showButtonTitle");
    }


    /**
     * Whether to show an Icon in this IconButton.  Set to false to render a text-only button.
     *
     * @param showIcon showIcon Default value is null
     */
    public void setShowIcon(Boolean showIcon) {
        setAttribute("showIcon", showIcon, true);
    }

    /**
     * Whether to show an Icon in this IconButton.  Set to false to render a text-only button.
     *
     * @return Boolean
     */
    public Boolean getShowIcon()  {
        return getAttributeAsBoolean("showIcon");
    }


    /**
     * Whether to show the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menu-icon} which fires the {@link
     * com.smartgwt.client.widgets.IconButton#addMenuIconClickHandler IconButton.menuIconClick}  notification method when
     * clicked.
     *
     * @param showMenuIcon showMenuIcon Default value is false
     */
    public void setShowMenuIcon(Boolean showMenuIcon) {
        setAttribute("showMenuIcon", showMenuIcon, true);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.IconButton#getMenuIconSrc menu-icon} which fires the {@link
     * com.smartgwt.client.widgets.IconButton#addMenuIconClickHandler IconButton.menuIconClick}  notification method when
     * clicked.
     *
     * @return Boolean
     */
    public Boolean getShowMenuIcon()  {
        return getAttributeAsBoolean("showMenuIcon");
    }


    /**
     * Whether to show a Disabled version of the {@link com.smartgwt.client.widgets.IconButton#getMenuIcon menuIcon}.
     *
     * @param showMenuIconDisabled showMenuIconDisabled Default value is true
     */
    public void setShowMenuIconDisabled(Boolean showMenuIconDisabled) {
        setAttribute("showMenuIconDisabled", showMenuIconDisabled, true);
    }

    /**
     * Whether to show a Disabled version of the {@link com.smartgwt.client.widgets.IconButton#getMenuIcon menuIcon}.
     *
     * @return Boolean
     */
    public Boolean getShowMenuIconDisabled()  {
        return getAttributeAsBoolean("showMenuIconDisabled");
    }


    /**
     * Whether to show an Over version of the {@link com.smartgwt.client.widgets.IconButton#getMenuIcon menuIcon}.
     *
     * @param showMenuIconOver showMenuIconOver Default value is true
     */
    public void setShowMenuIconOver(Boolean showMenuIconOver) {
        setAttribute("showMenuIconOver", showMenuIconOver, true);
    }

    /**
     * Whether to show an Over version of the {@link com.smartgwt.client.widgets.IconButton#getMenuIcon menuIcon}.
     *
     * @return Boolean
     */
    public Boolean getShowMenuIconOver()  {
        return getAttributeAsBoolean("showMenuIconOver");
    }


    /**
     * showTitle is not applicable to this class - use {@link com.smartgwt.client.widgets.IconButton#getShowButtonTitle
     * showButtonTitle} instead.
     *
     * @param showTitle showTitle Default value is null
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle, true);
    }

    /**
     * showTitle is not applicable to this class - use {@link com.smartgwt.client.widgets.IconButton#getShowButtonTitle
     * showButtonTitle} instead.
     *
     * @return Boolean
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }


    /**
     * Vertical alignment of this button's content.  If unset,  {@link com.smartgwt.client.widgets.IconButton#getOrientation
     * vertical buttons} are top-aligned and horizontal buttons center-aligned by default.
     *
     * @param valign valign Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setValign(VerticalAlignment valign) {
        setAttribute("valign", valign == null ? null : valign.getValue(), true);
    }

    /**
     * Vertical alignment of this button's content.  If unset,  {@link com.smartgwt.client.widgets.IconButton#getOrientation
     * vertical buttons} are top-aligned and horizontal buttons center-aligned by default.
     *
     * @return VerticalAlignment
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public VerticalAlignment getValign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("valign"));
    }

    // ********************* Methods ***********************
    /**
     * Add a menuIconClick handler.
     * <p>
     * Notification method fired when a user clicks on the menuIcon on this IconButton.  Return  false to suppress the standard
     * click handling code.
     *
     * @param handler the menuIconClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addMenuIconClickHandler(com.smartgwt.client.widgets.menu.events.MenuIconClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.menu.events.MenuIconClickEvent.getType()) == 0) setupMenuIconClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.menu.events.MenuIconClickEvent.getType());
    }

    private native void setupMenuIconClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        var menuIconClick = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.menu.events.MenuIconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({menuIconClick: 
                function () {
                    var param = {};
                    return menuIconClick(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.menuIconClick = 
                function () {
                    var param = {};
                    return menuIconClick(param) == true;
                }
            ;
        }
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
            s.menuIconSrc = getAttributeAsString("menuIconSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.menuIconSrc:" + t.getMessage() + "\n";
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
            s.showMenuIconOver = getAttributeAsString("showMenuIconOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "IconButton.showMenuIconOver:" + t.getMessage() + "\n";
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

    public LogicalStructureObject getLogicalStructure() {
        IconButtonLogicalStructure s = new IconButtonLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

