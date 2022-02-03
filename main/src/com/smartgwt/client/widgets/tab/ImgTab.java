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
 
package com.smartgwt.client.widgets.tab;


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
 * Specialized StretchImgButton used by TabSet/TabBar for tabs
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ImgTab")
public class ImgTab extends StretchImgButton {

    public static ImgTab getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new ImgTab(jsObj);
        } else {
            assert refInstance instanceof ImgTab;
            return (ImgTab)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ImgTab.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.ImgTab.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(ImgTab.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.ImgTab.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public ImgTab(){
        scClassName = "ImgTab";
    }

    public ImgTab(JavaScriptObject jsObj){
        scClassName = "ImgTab";
        setJavaScriptObject(jsObj);
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
     * Alignment of title text
     *
     * @param align New align value. Default value is Canvas.CENTER
     * @return {@link com.smartgwt.client.widgets.tab.ImgTab ImgTab} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public ImgTab setAlign(Alignment align) {
        return (ImgTab)setAttribute("align", align == null ? null : align.getValue(), true);
    }

    /**
     * Alignment of title text
     *
     * @return Current align value. Default value is Canvas.CENTER
     * @see com.smartgwt.client.docs.Positioning Positioning overview and related methods
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }
    

    /**
     * 
     *
     * @param baseStyle New baseStyle value. Default value is "tab"
     * @return {@link com.smartgwt.client.widgets.tab.ImgTab ImgTab} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public ImgTab setBaseStyle(String baseStyle)  throws IllegalStateException {
        return (ImgTab)setAttribute("baseStyle", baseStyle, false);
    }

    /**
     * 
     *
     * @return Current baseStyle value. Default value is "tab"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * How big are the end pieces by default
     *
     * @param capSize New capSize value. Default value is 2
     * @return {@link com.smartgwt.client.widgets.tab.ImgTab ImgTab} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ImgTab setCapSize(int capSize) {
        return (ImgTab)setAttribute("capSize", capSize, true);
    }

    /**
     * How big are the end pieces by default
     *
     * @return Current capSize value. Default value is 2
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getCapSize()  {
        return getAttributeAsInt("capSize");
    }
    

    /**
     * Base path for images shown within this ImgTab's label. This will be used for icons (such as the close icon) by default.
     *
     * @param labelSkinImgDir New labelSkinImgDir value. Default value is "images/"
     * @return {@link com.smartgwt.client.widgets.tab.ImgTab ImgTab} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.URL URL 
     */
    public ImgTab setLabelSkinImgDir(String labelSkinImgDir) {
        return (ImgTab)setAttribute("labelSkinImgDir", labelSkinImgDir, true);
    }

    /**
     * Base path for images shown within this ImgTab's label. This will be used for icons (such as the close icon) by default.
     *
     * @return Current labelSkinImgDir value. Default value is "images/"
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getLabelSkinImgDir()  {
        return getAttributeAsString("labelSkinImgDir");
    }
    
    

    /**
     * Should we visibly change state when the tab receives keyboard focus?
     *
     * @param showFocused New showFocused value. Default value is true
     * @return {@link com.smartgwt.client.widgets.tab.ImgTab ImgTab} instance, for chaining setter calls
     */
    public ImgTab setShowFocused(Boolean showFocused) {
        return (ImgTab)setAttribute("showFocused", showFocused, true);
    }

    /**
     * Should we visibly change state when the tab receives keyboard focus?
     *
     * @return Current showFocused value. Default value is true
     */
    public Boolean getShowFocused()  {
        Boolean result = getAttributeAsBoolean("showFocused");
        return result == null ? true : result;
    }
    

    /**
     * Should we visibly change state when the mouse goes over this tab
     *
     * @param showRollOver New showRollOver value. Default value is false
     * @return {@link com.smartgwt.client.widgets.tab.ImgTab ImgTab} instance, for chaining setter calls
     */
    public ImgTab setShowRollOver(Boolean showRollOver) {
        return (ImgTab)setAttribute("showRollOver", showRollOver, true);
    }

    /**
     * Should we visibly change state when the mouse goes over this tab
     *
     * @return Current showRollOver value. Default value is false
     */
    public Boolean getShowRollOver()  {
        Boolean result = getAttributeAsBoolean("showRollOver");
        return result == null ? false : result;
    }
    

    /**
     * Base path for the images.   <B>Note</B> that when used within a TabSet, the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition TabSet.tabBarPosition} is appended as an additional path
     * segment, yielding "images/Tab/top/" et al.
     *
     * @param skinImgDir New skinImgDir value. Default value is "images/Tab/"
     * @return {@link com.smartgwt.client.widgets.tab.ImgTab ImgTab} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.URL URL 
     */
    public ImgTab setSkinImgDir(String skinImgDir) {
        return (ImgTab)setAttribute("skinImgDir", skinImgDir, true);
    }

    /**
     * Base path for the images.   <B>Note</B> that when used within a TabSet, the {@link
     * com.smartgwt.client.widgets.tab.TabSet#getTabBarPosition TabSet.tabBarPosition} is appended as an additional path
     * segment, yielding "images/Tab/top/" et al.
     *
     * @return Current skinImgDir value. Default value is "images/Tab/"
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }
    

    /**
     * Base URL for tab images
     *
     * @param src New src value. Default value is "[SKIN]tab.gif"
     * @return {@link com.smartgwt.client.widgets.tab.ImgTab ImgTab} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public ImgTab setSrc(String src) {
        return (ImgTab)setAttribute("src", src, true);
    }

    /**
     * Base URL for tab images
     *
     * @return Current src value. Default value is "[SKIN]tab.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }
    

    /**
     * Like {@link com.smartgwt.client.widgets.StretchImgButton#getTitleStyle StretchImgButton.titleStyle}, can set to provide
     * a separate style for the title text. <P> If set and the ImgTab is {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical}, a "v" will be automatically prepended to the style
     * name (hence "tabTitle" -> "vtabTitle").
     *
     * @param titleStyle New titleStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tab.ImgTab ImgTab} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public ImgTab setTitleStyle(String titleStyle)  throws IllegalStateException {
        return (ImgTab)setAttribute("titleStyle", titleStyle, false);
    }

    /**
     * Like {@link com.smartgwt.client.widgets.StretchImgButton#getTitleStyle StretchImgButton.titleStyle}, can set to provide
     * a separate style for the title text. <P> If set and the ImgTab is {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical}, a "v" will be automatically prepended to the style
     * name (hence "tabTitle" -> "vtabTitle").
     *
     * @return Current titleStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
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
     * @param imgTabProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(ImgTab imgTabProperties) /*-{
        if (imgTabProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(ImgTab.@java.lang.Object::getClass()(), "setDefaultProperties", imgTabProperties.@java.lang.Object::getClass()());
        }
        imgTabProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = imgTabProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.ImgTab.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(ImgTabLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.align = getAttributeAsString("align");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgTab.align:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgTab.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.capSize = getAttributeAsString("capSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgTab.capSize:" + t.getMessage() + "\n";
        }
        try {
            s.labelSkinImgDir = getAttributeAsString("labelSkinImgDir");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgTab.labelSkinImgDir:" + t.getMessage() + "\n";
        }
        try {
            s.showFocused = getAttributeAsString("showFocused");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgTab.showFocused:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOver = getAttributeAsString("showRollOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgTab.showRollOver:" + t.getMessage() + "\n";
        }
        try {
            s.skinImgDir = getAttributeAsString("skinImgDir");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgTab.skinImgDir:" + t.getMessage() + "\n";
        }
        try {
            s.src = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgTab.src:" + t.getMessage() + "\n";
        }
        try {
            s.titleStyle = getAttributeAsString("titleStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgTab.titleStyle:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        ImgTabLogicalStructure s = new ImgTabLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
