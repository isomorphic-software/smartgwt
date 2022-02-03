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
 * A set of properties that can be used to configure a {@link com.smartgwt.client.widgets.Canvas#getShowPointer canvas
 * pointer}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("PointerSettings")
public class PointerSettings extends BaseWidget {

    public static PointerSettings getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new PointerSettings(jsObj);
        } else {
            assert refInstance instanceof PointerSettings;
            return (PointerSettings)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(PointerSettings.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.PointerSettings.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(PointerSettings.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.PointerSettings.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public PointerSettings(){
        scClassName = "PointerSettings";
    }

    public PointerSettings(JavaScriptObject jsObj){
        scClassName = "PointerSettings";
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
     * By default, the pointer will assume the same color as its parent canvas.  Set  this attribute to enforce a custom color
     * for the pointer.
     *
     * @param color New color value. Default value is null
     * @return {@link com.smartgwt.client.widgets.PointerSettings PointerSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public PointerSettings setColor(String color)  throws IllegalStateException {
        return (PointerSettings)setAttribute("color", color, false);
    }

    /**
     * By default, the pointer will assume the same color as its parent canvas.  Set  this attribute to enforce a custom color
     * for the pointer.
     *
     * @return Current color value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getColor()  {
        return getAttributeAsString("color");
    }
    

    /**
     * Specifies the amount of offset in pixels from the corner to position the pointer when {@link
     * com.smartgwt.client.widgets.PointerSettings#getSnapTo snapTo} is TL, TR, BL or BR. This is useful for a canvas with a
     * rounded corner.
     *
     * @param cornerOffset New cornerOffset value. Default value is null
     * @return {@link com.smartgwt.client.widgets.PointerSettings PointerSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public PointerSettings setCornerOffset(Integer cornerOffset)  throws IllegalStateException {
        return (PointerSettings)setAttribute("cornerOffset", cornerOffset, false);
    }

    /**
     * Specifies the amount of offset in pixels from the corner to position the pointer when {@link
     * com.smartgwt.client.widgets.PointerSettings#getSnapTo snapTo} is TL, TR, BL or BR. This is useful for a canvas with a
     * rounded corner.
     *
     * @return Current cornerOffset value. Default value is null
     */
    public Integer getCornerOffset()  {
        return getAttributeAsInt("cornerOffset");
    }
    

    /**
     * By default, the pointer will show the same shadow as its parent canvas.  Set  <code>showShadow</code> to false to render
     * the pointer without a shadow.
     *
     * @param showShadow New showShadow value. Default value is null
     * @return {@link com.smartgwt.client.widgets.PointerSettings PointerSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public PointerSettings setShowShadow(Boolean showShadow)  throws IllegalStateException {
        return (PointerSettings)setAttribute("showShadow", showShadow, false);
    }

    /**
     * By default, the pointer will show the same shadow as its parent canvas.  Set  <code>showShadow</code> to false to render
     * the pointer without a shadow.
     *
     * @return Current showShadow value. Default value is null
     */
    public Boolean getShowShadow()  {
        return getAttributeAsBoolean("showShadow");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.PointerSettings#getSnapTo snapTo} is defined, this property can be used to specify
     * an offset in px or percentage for the left coordinate of the pointer. <P> For example if <code>snapTo</code> is
     * specified as <code>"L"</code> and <code>snapOffsetLeft</code> is set to 6, the pointer will be rendered 6px inside the
     * left edge of the window. Alternatively if <code>snapTo</code> was set to <code>"R"</code>, a <code>snapOffsetLeft</code>
     * value of -6 would cause the pointer to be rendered 6px inside the right edge of the window.
     *
     * @param snapOffsetLeft New snapOffsetLeft value. Default value is null
     * @return {@link com.smartgwt.client.widgets.PointerSettings PointerSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.PointerSettings#setSnapTo
     * @see com.smartgwt.client.docs.SnapPositioning SnapPositioning overview and related methods
     */
    public PointerSettings setSnapOffsetLeft(Integer snapOffsetLeft)  throws IllegalStateException {
        return (PointerSettings)setAttribute("snapOffsetLeft", snapOffsetLeft, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.PointerSettings#getSnapTo snapTo} is defined, this property can be used to specify
     * an offset in px or percentage for the left coordinate of the pointer. <P> For example if <code>snapTo</code> is
     * specified as <code>"L"</code> and <code>snapOffsetLeft</code> is set to 6, the pointer will be rendered 6px inside the
     * left edge of the window. Alternatively if <code>snapTo</code> was set to <code>"R"</code>, a <code>snapOffsetLeft</code>
     * value of -6 would cause the pointer to be rendered 6px inside the right edge of the window.
     *
     * @return Current snapOffsetLeft value. Default value is null
     * @see com.smartgwt.client.widgets.PointerSettings#getSnapTo
     * @see com.smartgwt.client.docs.SnapPositioning SnapPositioning overview and related methods
     */
    public Integer getSnapOffsetLeft()  {
        return getAttributeAsInt("snapOffsetLeft");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.PointerSettings#getSnapTo snapTo} is defined, this property can be used to specify
     * an offset in px or percentage for the top coordinate of the pointer. <P> For example if <code>snapTo</code> is specified
     * as <code>"T"</code> and <code>snapOffsetTop</code> is set to 6, the pointer will be rendered 6px below the top edge of
     * the window. Alternatively if <code>snapTo</code> was set to <code>"B"</code>, a <code>snapOffsetTop</code> value of -6
     * would cause the pointer to be rendered 6px inside the bottom edge of the window.
     *
     * @param snapOffsetTop New snapOffsetTop value. Default value is null
     * @return {@link com.smartgwt.client.widgets.PointerSettings PointerSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.PointerSettings#setSnapTo
     * @see com.smartgwt.client.docs.SnapPositioning SnapPositioning overview and related methods
     */
    public PointerSettings setSnapOffsetTop(Integer snapOffsetTop)  throws IllegalStateException {
        return (PointerSettings)setAttribute("snapOffsetTop", snapOffsetTop, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.PointerSettings#getSnapTo snapTo} is defined, this property can be used to specify
     * an offset in px or percentage for the top coordinate of the pointer. <P> For example if <code>snapTo</code> is specified
     * as <code>"T"</code> and <code>snapOffsetTop</code> is set to 6, the pointer will be rendered 6px below the top edge of
     * the window. Alternatively if <code>snapTo</code> was set to <code>"B"</code>, a <code>snapOffsetTop</code> value of -6
     * would cause the pointer to be rendered 6px inside the bottom edge of the window.
     *
     * @return Current snapOffsetTop value. Default value is null
     * @see com.smartgwt.client.widgets.PointerSettings#getSnapTo
     * @see com.smartgwt.client.docs.SnapPositioning SnapPositioning overview and related methods
     */
    public Integer getSnapOffsetTop()  {
        return getAttributeAsInt("snapOffsetTop");
    }
    

    /**
     * Specifies the position of the pointer when {@link com.smartgwt.client.widgets.Canvas#getShowPointer showing}. Accepts
     * similar values as {@link com.smartgwt.client.widgets.Canvas#getSnapTo Canvas.snapTo}.  <P> Possible basic values: TL,
     * TR, LT, LB, RT, RB, BL, BR, R, L, B, T where B=Bottom, T=Top, L=Left, R=right. The first letter indicates the edge and
     * the second optional letter indicates the placement along the edge. <P> In addition to the basic values above, two
     * different basic values can be combined with a separating slash (/) to position the pointer between the two locations
     * giving more precise control. For example, <code>BL/L</code> positions the pointer along the bottom edge halfway between
     * the bottom-left and the bottom-center. <P> If {@link com.smartgwt.client.widgets.Canvas#getShowPointer
     * Canvas.showPointer} is enabled and a {@link com.smartgwt.client.widgets.Canvas#getPointerTarget Canvas.pointerTarget} is
     * specified but <code>snapTo</code> is null, a reasonable location is calculated based on the location of the
     * <code>pointerTarget</code>.
     *
     * @param snapTo New snapTo value. Default value is null
     * @return {@link com.smartgwt.client.widgets.PointerSettings PointerSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SnapPositioning SnapPositioning overview and related methods
     */
    public PointerSettings setSnapTo(String snapTo)  throws IllegalStateException {
        return (PointerSettings)setAttribute("snapTo", snapTo, false);
    }

    /**
     * Specifies the position of the pointer when {@link com.smartgwt.client.widgets.Canvas#getShowPointer showing}. Accepts
     * similar values as {@link com.smartgwt.client.widgets.Canvas#getSnapTo Canvas.snapTo}.  <P> Possible basic values: TL,
     * TR, LT, LB, RT, RB, BL, BR, R, L, B, T where B=Bottom, T=Top, L=Left, R=right. The first letter indicates the edge and
     * the second optional letter indicates the placement along the edge. <P> In addition to the basic values above, two
     * different basic values can be combined with a separating slash (/) to position the pointer between the two locations
     * giving more precise control. For example, <code>BL/L</code> positions the pointer along the bottom edge halfway between
     * the bottom-left and the bottom-center. <P> If {@link com.smartgwt.client.widgets.Canvas#getShowPointer
     * Canvas.showPointer} is enabled and a {@link com.smartgwt.client.widgets.Canvas#getPointerTarget Canvas.pointerTarget} is
     * specified but <code>snapTo</code> is null, a reasonable location is calculated based on the location of the
     * <code>pointerTarget</code>.
     *
     * @return Current snapTo value. Default value is null
     * @see com.smartgwt.client.docs.SnapPositioning SnapPositioning overview and related methods
     */
    public String getSnapTo()  {
        return getAttributeAsString("snapTo");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.PointerSettings#getTargetSnapTo targetSnapTo} is defined, this property can be
     * used to specify an offset in px or percentage for the coordinate of the pointer <i>into</i> the {@link
     * com.smartgwt.client.widgets.Canvas#getPointerTarget Canvas.pointerTarget}. <P> While {@link
     * com.smartgwt.client.widgets.PointerSettings#getTargetOffsetLeft targetOffsetLeft} and {@link
     * com.smartgwt.client.widgets.PointerSettings#getTargetOffsetTop targetOffsetTop} can be used to fine tune the pointer's
     * target position the user must be aware of the orientation of the pointer. Instead, this property will be applied to the
     * correct offset so that the pointer points inside (or outside if negative) the target. <P> For example if
     * <code>targetSnapTo</code> is specified as <code>"L"</code> and <code>targetOffsetInto</code> is set to 6, the pointer
     * will be rendered 6px inside the left edge of the position target.
     *
     * @param targetOffsetInto New targetOffsetInto value. Default value is null
     * @return {@link com.smartgwt.client.widgets.PointerSettings PointerSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.PointerSettings#setTargetSnapTo
     */
    public PointerSettings setTargetOffsetInto(Integer targetOffsetInto)  throws IllegalStateException {
        return (PointerSettings)setAttribute("targetOffsetInto", targetOffsetInto, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.PointerSettings#getTargetSnapTo targetSnapTo} is defined, this property can be
     * used to specify an offset in px or percentage for the coordinate of the pointer <i>into</i> the {@link
     * com.smartgwt.client.widgets.Canvas#getPointerTarget Canvas.pointerTarget}. <P> While {@link
     * com.smartgwt.client.widgets.PointerSettings#getTargetOffsetLeft targetOffsetLeft} and {@link
     * com.smartgwt.client.widgets.PointerSettings#getTargetOffsetTop targetOffsetTop} can be used to fine tune the pointer's
     * target position the user must be aware of the orientation of the pointer. Instead, this property will be applied to the
     * correct offset so that the pointer points inside (or outside if negative) the target. <P> For example if
     * <code>targetSnapTo</code> is specified as <code>"L"</code> and <code>targetOffsetInto</code> is set to 6, the pointer
     * will be rendered 6px inside the left edge of the position target.
     *
     * @return Current targetOffsetInto value. Default value is null
     * @see com.smartgwt.client.widgets.PointerSettings#getTargetSnapTo
     */
    public Integer getTargetOffsetInto()  {
        return getAttributeAsInt("targetOffsetInto");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.PointerSettings#getTargetSnapTo targetSnapTo} is defined, this property can be
     * used to specify an offset in px or percentage for the left coordinate of the pointer. <P> For example if
     * <code>targetSnapTo</code> is specified as <code>"L"</code> and <code>targetOffsetLeft</code> is set to 6, the pointer
     * will be rendered 6px inside the left edge of the pointer target canvas. Alternatively if <code>targetSnapTo</code> was
     * set to <code>"R"</code>, a <code>targetOffsetLeft</code> value of -6 would cause the pointer to be rendered 6px inside
     * the right edge of the pointer target canvas. <P> Note that {@link
     * com.smartgwt.client.widgets.PointerSettings#getTargetOffsetInto targetOffsetInto} is likely more suitable for simple
     * customizations.
     *
     * @param targetOffsetLeft New targetOffsetLeft value. Default value is null
     * @return {@link com.smartgwt.client.widgets.PointerSettings PointerSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.PointerSettings#setTargetSnapTo
     * @see com.smartgwt.client.widgets.PointerSettings#setTargetOffsetInto
     */
    public PointerSettings setTargetOffsetLeft(Integer targetOffsetLeft)  throws IllegalStateException {
        return (PointerSettings)setAttribute("targetOffsetLeft", targetOffsetLeft, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.PointerSettings#getTargetSnapTo targetSnapTo} is defined, this property can be
     * used to specify an offset in px or percentage for the left coordinate of the pointer. <P> For example if
     * <code>targetSnapTo</code> is specified as <code>"L"</code> and <code>targetOffsetLeft</code> is set to 6, the pointer
     * will be rendered 6px inside the left edge of the pointer target canvas. Alternatively if <code>targetSnapTo</code> was
     * set to <code>"R"</code>, a <code>targetOffsetLeft</code> value of -6 would cause the pointer to be rendered 6px inside
     * the right edge of the pointer target canvas. <P> Note that {@link
     * com.smartgwt.client.widgets.PointerSettings#getTargetOffsetInto targetOffsetInto} is likely more suitable for simple
     * customizations.
     *
     * @return Current targetOffsetLeft value. Default value is null
     * @see com.smartgwt.client.widgets.PointerSettings#getTargetSnapTo
     * @see com.smartgwt.client.widgets.PointerSettings#getTargetOffsetInto
     */
    public Integer getTargetOffsetLeft()  {
        return getAttributeAsInt("targetOffsetLeft");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.PointerSettings#getTargetSnapTo targetSnapTo} is defined, this property can be
     * used to specify an offset in px or percentage for the top coordinate of the pointer. <P> For example if
     * <code>targetSnapTo</code> is specified as <code>"T"</code> and <code>targetOffsetTop</code> is set to 6, the pointer
     * will be rendered 6px below the top edge of the pointer target canvas. Alternatively if <code>targetSnapTo</code> was set
     * to <code>"B"</code>, a <code>targetOffsetTop</code> value of -6 would cause the pointer to be rendered 6px inside the
     * bottom edge of the pointer target canvas. <P> Note that {@link
     * com.smartgwt.client.widgets.PointerSettings#getTargetOffsetInto targetOffsetInto} is likely more suitable for simple
     * customizations.
     *
     * @param targetOffsetTop New targetOffsetTop value. Default value is null
     * @return {@link com.smartgwt.client.widgets.PointerSettings PointerSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.PointerSettings#setTargetSnapTo
     * @see com.smartgwt.client.widgets.PointerSettings#setTargetOffsetInto
     */
    public PointerSettings setTargetOffsetTop(Integer targetOffsetTop)  throws IllegalStateException {
        return (PointerSettings)setAttribute("targetOffsetTop", targetOffsetTop, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.PointerSettings#getTargetSnapTo targetSnapTo} is defined, this property can be
     * used to specify an offset in px or percentage for the top coordinate of the pointer. <P> For example if
     * <code>targetSnapTo</code> is specified as <code>"T"</code> and <code>targetOffsetTop</code> is set to 6, the pointer
     * will be rendered 6px below the top edge of the pointer target canvas. Alternatively if <code>targetSnapTo</code> was set
     * to <code>"B"</code>, a <code>targetOffsetTop</code> value of -6 would cause the pointer to be rendered 6px inside the
     * bottom edge of the pointer target canvas. <P> Note that {@link
     * com.smartgwt.client.widgets.PointerSettings#getTargetOffsetInto targetOffsetInto} is likely more suitable for simple
     * customizations.
     *
     * @return Current targetOffsetTop value. Default value is null
     * @see com.smartgwt.client.widgets.PointerSettings#getTargetSnapTo
     * @see com.smartgwt.client.widgets.PointerSettings#getTargetOffsetInto
     */
    public Integer getTargetOffsetTop()  {
        return getAttributeAsInt("targetOffsetTop");
    }
    

    /**
     * Specifies the position of the pointer into the target when {@link com.smartgwt.client.widgets.Canvas#getShowPointer
     * showing}. Accepts the same values as {@link com.smartgwt.client.widgets.PointerSettings#getSnapTo snapTo}. <P> If not
     * specified the center location on the appropriate edge is chosen to match up with the {@link
     * com.smartgwt.client.widgets.PointerSettings#getSnapTo snapTo} value.
     *
     * @param targetSnapTo New targetSnapTo value. Default value is null
     * @return {@link com.smartgwt.client.widgets.PointerSettings PointerSettings} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SnapGridDragging SnapGridDragging overview and related methods
     */
    public PointerSettings setTargetSnapTo(String targetSnapTo)  throws IllegalStateException {
        return (PointerSettings)setAttribute("targetSnapTo", targetSnapTo, false);
    }

    /**
     * Specifies the position of the pointer into the target when {@link com.smartgwt.client.widgets.Canvas#getShowPointer
     * showing}. Accepts the same values as {@link com.smartgwt.client.widgets.PointerSettings#getSnapTo snapTo}. <P> If not
     * specified the center location on the appropriate edge is chosen to match up with the {@link
     * com.smartgwt.client.widgets.PointerSettings#getSnapTo snapTo} value.
     *
     * @return Current targetSnapTo value. Default value is null
     * @see com.smartgwt.client.docs.SnapGridDragging SnapGridDragging overview and related methods
     */
    public String getTargetSnapTo()  {
        return getAttributeAsString("targetSnapTo");
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
     * @param pointerSettingsProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(PointerSettings pointerSettingsProperties) /*-{
        if (pointerSettingsProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(PointerSettings.@java.lang.Object::getClass()(), "setDefaultProperties", pointerSettingsProperties.@java.lang.Object::getClass()());
        }
        pointerSettingsProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = pointerSettingsProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.PointerSettings.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(PointerSettingsLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.color = getAttributeAsString("color");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PointerSettings.color:" + t.getMessage() + "\n";
        }
        try {
            s.cornerOffset = getAttributeAsString("cornerOffset");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PointerSettings.cornerOffset:" + t.getMessage() + "\n";
        }
        try {
            s.showShadow = getAttributeAsString("showShadow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PointerSettings.showShadow:" + t.getMessage() + "\n";
        }
        try {
            s.snapOffsetLeft = getAttributeAsString("snapOffsetLeft");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PointerSettings.snapOffsetLeft:" + t.getMessage() + "\n";
        }
        try {
            s.snapOffsetTop = getAttributeAsString("snapOffsetTop");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PointerSettings.snapOffsetTop:" + t.getMessage() + "\n";
        }
        try {
            s.snapTo = getAttributeAsString("snapTo");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PointerSettings.snapTo:" + t.getMessage() + "\n";
        }
        try {
            s.targetOffsetInto = getAttributeAsString("targetOffsetInto");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PointerSettings.targetOffsetInto:" + t.getMessage() + "\n";
        }
        try {
            s.targetOffsetLeft = getAttributeAsString("targetOffsetLeft");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PointerSettings.targetOffsetLeft:" + t.getMessage() + "\n";
        }
        try {
            s.targetOffsetTop = getAttributeAsString("targetOffsetTop");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PointerSettings.targetOffsetTop:" + t.getMessage() + "\n";
        }
        try {
            s.targetSnapTo = getAttributeAsString("targetSnapTo");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PointerSettings.targetSnapTo:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        PointerSettingsLogicalStructure s = new PointerSettingsLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
