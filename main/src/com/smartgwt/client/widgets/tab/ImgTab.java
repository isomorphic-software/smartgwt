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
 
package com.smartgwt.client.widgets.tab;



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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Specialized StretchImgButton used by TabSet/TabBar for tabs
 */
public class ImgTab extends StretchImgButton {

    public static ImgTab getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ImgTab) obj;
        } else {
            return new ImgTab(jsObj);
        }
    }

    public ImgTab(){
        scClassName = "ImgTab";
    }

    public ImgTab(JavaScriptObject jsObj){
        super(jsObj);
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
     * Alignment of title text
     *
     * @param align align Default value is Canvas.CENTER
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align.getValue(), true);
    }

    /**
     * Alignment of title text
     *
     *
     * @return Alignment
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }

    /**
     * 
     *
     * @param baseStyle baseStyle Default value is "tab"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBaseStyle(String baseStyle)  throws IllegalStateException {
        setAttribute("baseStyle", baseStyle, false);
    }

    /**
     * 
     *
     *
     * @return String
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    /**
     * How big are the end pieces by default
     *
     * @param capSize capSize Default value is 2
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setCapSize(int capSize) {
        setAttribute("capSize", capSize, true);
    }

    /**
     * How big are the end pieces by default
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getCapSize()  {
        return getAttributeAsInt("capSize");
    }

    /**
     * Base path for images shown within this ImgTab's label. This will be used for icons (such as the close icon) by default.
     *
     * @param labelSkinImgDir labelSkinImgDir Default value is "images/"
     */
    public void setLabelSkinImgDir(String labelSkinImgDir) {
        setAttribute("labelSkinImgDir", labelSkinImgDir, true);
    }

    /**
     * Base path for images shown within this ImgTab's label. This will be used for icons (such as the close icon) by default.
     *
     *
     * @return String
     */
    public String getLabelSkinImgDir()  {
        return getAttributeAsString("labelSkinImgDir");
    }

    /**
     * Should we visibly change state when the tab receives keyboard focus?
     *
     * @param showFocused showFocused Default value is true
     */
    public void setShowFocused(Boolean showFocused) {
        setAttribute("showFocused", showFocused, true);
    }

    /**
     * Should we visibly change state when the tab receives keyboard focus?
     *
     *
     * @return Boolean
     */
    public Boolean getShowFocused()  {
        return getAttributeAsBoolean("showFocused");
    }

    /**
     * Should we visibly change state when the mouse goes over this tab
     *
     * @param showRollOver showRollOver Default value is false
     */
    public void setShowRollOver(Boolean showRollOver) {
        setAttribute("showRollOver", showRollOver, true);
    }

    /**
     * Should we visibly change state when the mouse goes over this tab
     *
     *
     * @return Boolean
     */
    public Boolean getShowRollOver()  {
        return getAttributeAsBoolean("showRollOver");
    }

    /**
     * Base path for the images.   <B>Note</B> that when used within a TabSet, the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is appended as an additional path segment,
     * yielding "images/Tab/top/" et al.
     *
     * @param skinImgDir skinImgDir Default value is "images/Tab/"
     */
    public void setSkinImgDir(String skinImgDir) {
        setAttribute("skinImgDir", skinImgDir, true);
    }

    /**
     * Base path for the images.   <B>Note</B> that when used within a TabSet, the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition tabBarPosition} is appended as an additional path segment,
     * yielding "images/Tab/top/" et al.
     *
     *
     * @return String
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }

    /**
     * Base URL for tab images
     *
     * @param src src Default value is "tab.gif"
     */
    public void setSrc(String src) {
        setAttribute("src", src, true);
    }

    /**
     * Base URL for tab images
     *
     *
     * @return String
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
     * Like {@link com.smartgwt.client.widgets.StretchImgButton#getTitleStyle titleStyle}, can set to provide a separate style
     * for the title text. <P> If set and the ImgTab is {@link com.smartgwt.client.widgets.StretchImgButton#getVertical
     * vertical}, a "v" will be automatically prepended to the style name (hence "tabTitle" -> "vtabTitle").
     *
     * @param titleStyle titleStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTitleStyle(String titleStyle)  throws IllegalStateException {
        setAttribute("titleStyle", titleStyle, false);
    }

    /**
     * Like {@link com.smartgwt.client.widgets.StretchImgButton#getTitleStyle titleStyle}, can set to provide a separate style
     * for the title text. <P> If set and the ImgTab is {@link com.smartgwt.client.widgets.StretchImgButton#getVertical
     * vertical}, a "v" will be automatically prepended to the style name (hence "tabTitle" -> "vtabTitle").
     *
     *
     * @return String
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
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
     * @param imgTabProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(ImgTab imgTabProperties) /*-{
    	var properties = $wnd.isc.addProperties({},imgTabProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.ImgTab.addProperties(properties);
    }-*/;
        
    // ***********************************************************        

}



