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
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

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
        var widget = $wnd.isc.ImgTab.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************
 
    /**
     * Alignment of title text
     *
     * @param align align Default value is Canvas.CENTER
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align.getValue(), true);
    }

    /**
     * Alignment of title text
     *
     *
     * @return Alignment
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
     */
    public void setCapSize(int capSize) {
        setAttribute("capSize", capSize, true);
    }

    /**
     * How big are the end pieces by default
     *
     *
     * @return int
     */
    public int getCapSize()  {
        return getAttributeAsInt("capSize");
    }

    /**
     * Should we visibly change state when the tab recieves keyboard focus?
     *
     * @param showFocused showFocused Default value is true
     */
    public void setShowFocused(Boolean showFocused) {
        setAttribute("showFocused", showFocused, true);
    }

    /**
     * Should we visibly change state when the tab recieves keyboard focus?
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
     * 'vertical'}, a "v" will be automatically prepended to the style name (hence "tabTitle" -> "vtabTitle").
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
     * 'vertical'}, a "v" will be automatically prepended to the style name (hence "tabTitle" -> "vtabTitle").
     *
     *
     * @return String
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

}





