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
 
package com.smartgwt.client.widgets.drawing;


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
 * DrawItem subclass to render line segments.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawLine")
public class DrawLine extends DrawItem {

    public static DrawLine getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DrawLine(jsObj);
        } else {
            assert refInstance instanceof DrawLine;
            return (DrawLine)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawLine.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawLine.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawLine.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DrawLine.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;
    /**
     * Changes the defaults for DrawItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults DrawItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, DrawItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawLine.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "DrawItem");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawLine.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DrawLine(){
        scClassName = "DrawLine";
    }

    public DrawLine(JavaScriptObject jsObj){
        scClassName = "DrawLine";
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
     * Ending left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getEndPoint endPoint} if both are set.
     *
     * @param endLeft New endLeft value. Default value is 100
     * @return {@link com.smartgwt.client.widgets.drawing.DrawLine DrawLine} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawLine setEndLeft(int endLeft)  throws IllegalStateException {
        return (DrawLine)setAttribute("endLeft", endLeft, false);
    }

    /**
     * Ending left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getEndPoint endPoint} if both are set.
     *
     * @return Current endLeft value. Default value is 100
     */
    public int getEndLeft()  {
        return (int)Math.round(getAttributeAsDouble("endLeft"));
    }

    /**
     * Ending left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getEndPoint endPoint} if both are set.
     *
     * @return Current endLeft value. Default value is 100
     */
    public double getEndLeftAsDouble()  {
        return getAttributeAsDouble("endLeft");
    }
    

    /**
     * End point of the line
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the endPoint
     *
     * @param endPoint left coordinate for end point, in pixels. Default value is [100,100]
     * @return {@link com.smartgwt.client.widgets.drawing.DrawLine DrawLine} instance, for chaining setter calls
     */
    public DrawLine setEndPoint(Point endPoint) {
        return (DrawLine)setAttribute("endPoint", endPoint == null ? null : endPoint.getJsObj(), true);
    }

    /**
     * End point of the line
     *
     * @return Current endPoint value. Default value is [100,100]
     */
    public Point getEndPoint()  {
        return Point.getOrCreateRef(getAttributeAsJavaScriptObject("endPoint"));
    }
    

    /**
     * Ending top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getEndPoint endPoint} if both are set.
     *
     * @param endTop New endTop value. Default value is 100
     * @return {@link com.smartgwt.client.widgets.drawing.DrawLine DrawLine} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawLine setEndTop(int endTop)  throws IllegalStateException {
        return (DrawLine)setAttribute("endTop", endTop, false);
    }

    /**
     * Ending top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getEndPoint endPoint} if both are set.
     *
     * @return Current endTop value. Default value is 100
     */
    public int getEndTop()  {
        return (int)Math.round(getAttributeAsDouble("endTop"));
    }

    /**
     * Ending top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getEndPoint endPoint} if both are set.
     *
     * @return Current endTop value. Default value is 100
     */
    public double getEndTopAsDouble()  {
        return getAttributeAsDouble("endTop");
    }
    

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this will
     * turn on UI element(s) allowing the user to manipulate this DrawLine.  To update the set of knobs at runtime use {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs()} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs()}. <p> DrawLine supports the  {@link
     * com.smartgwt.client.types.KnobType#STARTPOINT}, {@link com.smartgwt.client.types.KnobType#ENDPOINT}, and {@link
     * com.smartgwt.client.types.KnobType#MOVE} knob types.
     *
     * @param knobs New knobs value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawLine DrawLine} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * 
     * 
     */
    public DrawLine setKnobs(KnobType... knobs)  throws IllegalStateException {
        return (DrawLine)setAttribute("knobs", knobs, false);
    }

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this will
     * turn on UI element(s) allowing the user to manipulate this DrawLine.  To update the set of knobs at runtime use {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs()} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs()}. <p> DrawLine supports the  {@link
     * com.smartgwt.client.types.KnobType#STARTPOINT}, {@link com.smartgwt.client.types.KnobType#ENDPOINT}, and {@link
     * com.smartgwt.client.types.KnobType#MOVE} knob types.
     *
     * @return Current knobs value. Default value is null
     * 
     * 
     */
    public KnobType[] getKnobs()  {
        final String[] strings = getAttributeAsStringArray("knobs");
        return EnumUtil.getEnums(KnobType.values(), strings, strings == null ? null : new KnobType[strings.length]);
    }
    

    /**
     * If the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} is showing, should the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground titleLabelBackground} be created and placed behind
     * the <code>titleLabel</code>? <p> This defaults to true for {@link com.smartgwt.client.widgets.drawing.DrawSector}s and
     * shapes that are not commonly filled (e.g. {@link com.smartgwt.client.widgets.drawing.DrawLine}s).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTitleLabelBackground New showTitleLabelBackground value. Default value is true
     * @return {@link com.smartgwt.client.widgets.drawing.DrawLine DrawLine} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawLine setShowTitleLabelBackground(boolean showTitleLabelBackground)  throws IllegalStateException {
        return (DrawLine)setAttribute("showTitleLabelBackground", showTitleLabelBackground, false);
    }

    /**
     * If the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} is showing, should the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground titleLabelBackground} be created and placed behind
     * the <code>titleLabel</code>? <p> This defaults to true for {@link com.smartgwt.client.widgets.drawing.DrawSector}s and
     * shapes that are not commonly filled (e.g. {@link com.smartgwt.client.widgets.drawing.DrawLine}s).
     *
     * @return Current showTitleLabelBackground value. Default value is true
     */
    public boolean getShowTitleLabelBackground()  {
        Boolean result = getAttributeAsBoolean("showTitleLabelBackground");
        return result == null ? true : result;
    }
    

    /**
     * Starting left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint} if both are set.
     *
     * @param startLeft New startLeft value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawLine DrawLine} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawLine setStartLeft(int startLeft)  throws IllegalStateException {
        return (DrawLine)setAttribute("startLeft", startLeft, false);
    }

    /**
     * Starting left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint} if both are set.
     *
     * @return Current startLeft value. Default value is 0
     */
    public int getStartLeft()  {
        return (int)Math.round(getAttributeAsDouble("startLeft"));
    }

    /**
     * Starting left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint} if both are set.
     *
     * @return Current startLeft value. Default value is 0
     */
    public double getStartLeftAsDouble()  {
        return getAttributeAsDouble("startLeft");
    }
    

    /**
     * Start point of the line
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the startPoint
     *
     * @param startPoint left coordinate for start point, in pixels. Default value is [0,0]
     * @return {@link com.smartgwt.client.widgets.drawing.DrawLine DrawLine} instance, for chaining setter calls
     */
    public DrawLine setStartPoint(Point startPoint) {
        return (DrawLine)setAttribute("startPoint", startPoint == null ? null : startPoint.getJsObj(), true);
    }

    /**
     * Start point of the line
     *
     * @return Current startPoint value. Default value is [0,0]
     */
    public Point getStartPoint()  {
        return Point.getOrCreateRef(getAttributeAsJavaScriptObject("startPoint"));
    }
    

    /**
     * Starting top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint} if both are set.
     *
     * @param startTop New startTop value. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawLine DrawLine} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawLine setStartTop(int startTop)  throws IllegalStateException {
        return (DrawLine)setAttribute("startTop", startTop, false);
    }

    /**
     * Starting top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint} if both are set.
     *
     * @return Current startTop value. Default value is 0
     */
    public int getStartTop()  {
        return (int)Math.round(getAttributeAsDouble("startTop"));
    }

    /**
     * Starting top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint} if both are set.
     *
     * @return Current startTop value. Default value is 0
     */
    public double getStartTopAsDouble()  {
        return getAttributeAsDouble("startTop");
    }
    

    /**
     * The mode in which the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} (if shown) is
     * rotated with this draw item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param titleRotationMode New titleRotationMode value. Default value is "withLineAlwaysUp"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawLine DrawLine} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setTitle
     * 
     */
    public DrawLine setTitleRotationMode(TitleRotationMode titleRotationMode)  throws IllegalStateException {
        return (DrawLine)setAttribute("titleRotationMode", titleRotationMode == null ? null : titleRotationMode.getValue(), false);
    }

    /**
     * The mode in which the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} (if shown) is
     * rotated with this draw item.
     *
     * @return Current titleRotationMode value. Default value is "withLineAlwaysUp"
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getTitle
     * 
     */
    public TitleRotationMode getTitleRotationMode()  {
        return EnumUtil.getEnum(TitleRotationMode.values(), getAttribute("titleRotationMode"));
    }
    

    // ********************* Methods ***********************
	/**
     * Get the midpoint of the line.
     *
     * @return the midpoint
     */
    public native Point getCenter() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCenter", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCenter();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.drawing.Point::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns true if the given point in the drawing coordinate system is within this DrawItem's shape, taking into account
     * local transforms.
     * @param x X coordinate of the test point.
     * @param y Y coordinate of the test point.
     *
     * @return 
     */
    public native boolean isPointInPath(int x, int y) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isPointInPath", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isPointInPath(x, y);
        return ret == null ? false : ret;
    }-*/;

	/**
     * Move both the start and end points of the line by a relative amount.
     * @param left change to left coordinate in pixels
     * @param top change to top coordinate in pixels
     */
    public native void moveBy(int left, int top) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveBy", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveBy(left, top);
    }-*/;

	/**
     * Move both the start and end points of the line such that the {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint} ends up at the specified coordinate and the line
     * length and angle are unchanged.
     * @param left new left coordinate in pixels
     * @param top new top coordinate in pixels
     */
    public native void moveStartPointTo(Integer left, Integer top) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveStartPointTo", "Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveStartPointTo(left == null ? null : left.@java.lang.Integer::intValue()(), top == null ? null : top.@java.lang.Integer::intValue()());
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
     * @param drawLineProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DrawLine drawLineProperties) /*-{
        if (drawLineProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DrawLine.@java.lang.Object::getClass()(), "setDefaultProperties", drawLineProperties.@java.lang.Object::getClass()());
        }
        drawLineProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = drawLineProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DrawLine.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DrawLineLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.endLeft = getAttributeAsString("endLeft");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLine.endLeft:" + t.getMessage() + "\n";
        }
        try {
            s.endPoint = getEndPoint();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLine.endPoint:" + t.getMessage() + "\n";
        }
        try {
            s.endTop = getAttributeAsString("endTop");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLine.endTop:" + t.getMessage() + "\n";
        }
        try {
            s.knobs = getAttributeAsStringArray("knobs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLine.knobsArray:" + t.getMessage() + "\n";
        }
        try {
            s.showTitleLabelBackground = getAttributeAsString("showTitleLabelBackground");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLine.showTitleLabelBackground:" + t.getMessage() + "\n";
        }
        try {
            s.startLeft = getAttributeAsString("startLeft");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLine.startLeft:" + t.getMessage() + "\n";
        }
        try {
            s.startPoint = getStartPoint();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLine.startPoint:" + t.getMessage() + "\n";
        }
        try {
            s.startTop = getAttributeAsString("startTop");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLine.startTop:" + t.getMessage() + "\n";
        }
        try {
            s.titleRotationMode = getAttributeAsString("titleRotationMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLine.titleRotationMode:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DrawLineLogicalStructure s = new DrawLineLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
