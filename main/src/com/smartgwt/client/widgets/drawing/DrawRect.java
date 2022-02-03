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
 * DrawItem subclass to render rectangle shapes, optionally with rounded corners.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawRect")
public class DrawRect extends DrawItem {

    public static DrawRect getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DrawRect(jsObj);
        } else {
            assert refInstance instanceof DrawRect;
            return (DrawRect)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawRect.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawRect.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawRect.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DrawRect.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawRect.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "DrawItem");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawRect.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DrawRect(){
        scClassName = "DrawRect";
    }

    public DrawRect(JavaScriptObject jsObj){
        scClassName = "DrawRect";
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
     * Height in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the height of the drawRect
     *
     * @param height new height. Default value is 100
     * @return {@link com.smartgwt.client.widgets.drawing.DrawRect DrawRect} instance, for chaining setter calls
     */
    public DrawRect setHeight(int height) {
        return (DrawRect)setAttribute("height", height, true);
    }

    /**
     * Height in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current height value. Default value is 100
     */
    public int getHeight()  {
        return (int)Math.round(getAttributeAsDouble("height"));
    }

    /**
     * Height in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current height value. Default value is 100
     */
    public double getHeightAsDouble()  {
        return getAttributeAsDouble("height");
    }
    

    /**
     * Left coordinate in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the left coordinate of the drawRect
     *
     * @param left new left coordinate. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawRect DrawRect} instance, for chaining setter calls
     */
    public DrawRect setLeft(int left) {
        return (DrawRect)setAttribute("left", left, true);
    }

    /**
     * Left coordinate in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current left value. Default value is 0
     */
    public int getLeft()  {
        return (int)Math.round(getAttributeAsDouble("left"));
    }

    /**
     * Left coordinate in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current left value. Default value is 0
     */
    public double getLeftAsDouble()  {
        return getAttributeAsDouble("left");
    }
    

    /**
     * Style of drawing the endpoints of a line. <P> Note that for dashed and dotted lines, the lineCap style affects each dash
     * or dot.
     *
     * @param lineCap New lineCap value. Default value is "butt"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawRect DrawRect} instance, for chaining setter calls
     */
    public DrawRect setLineCap(LineCap lineCap) {
        return (DrawRect)setAttribute("lineCap", lineCap == null ? null : lineCap.getValue(), true);
    }

    /**
     * Style of drawing the endpoints of a line. <P> Note that for dashed and dotted lines, the lineCap style affects each dash
     * or dot.
     *
     * @return Current lineCap value. Default value is "butt"
     */
    public LineCap getLineCap()  {
        return EnumUtil.getEnum(LineCap.values(), getAttribute("lineCap"));
    }
    

    /**
     * Rounding of corners, from 0 (square corners) to 1.0 (shorter edge is a semicircle).
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter method for {@link com.smartgwt.client.widgets.drawing.DrawRect#getRounding rounding}
     *
     * @param rounding new rounding value. Should be between zero (a rectangle) and 1 (shorter   edge is a semicircle). Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawRect DrawRect} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawRect setRounding(float rounding)  throws IllegalStateException {
        return (DrawRect)setAttribute("rounding", rounding, false);
    }

    /**
     * Rounding of corners, from 0 (square corners) to 1.0 (shorter edge is a semicircle).
     *
     * @return Current rounding value. Default value is 0
     */
    public float getRounding()  {
        return getAttributeAsFloat("rounding");
    }
    

    /**
     * The mode in which the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} (if shown) is
     * rotated with this draw item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param titleRotationMode New titleRotationMode value. Default value is "withItemAlwaysUp"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawRect DrawRect} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setTitle
     * 
     */
    public DrawRect setTitleRotationMode(TitleRotationMode titleRotationMode)  throws IllegalStateException {
        return (DrawRect)setAttribute("titleRotationMode", titleRotationMode == null ? null : titleRotationMode.getValue(), false);
    }

    /**
     * The mode in which the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} (if shown) is
     * rotated with this draw item.
     *
     * @return Current titleRotationMode value. Default value is "withItemAlwaysUp"
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getTitle
     * 
     */
    public TitleRotationMode getTitleRotationMode()  {
        return EnumUtil.getEnum(TitleRotationMode.values(), getAttribute("titleRotationMode"));
    }
    

    /**
     * Top coordinate in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the top coordinate of the drawRect
     *
     * @param top new top coordinate. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawRect DrawRect} instance, for chaining setter calls
     */
    public DrawRect setTop(int top) {
        return (DrawRect)setAttribute("top", top, true);
    }

    /**
     * Top coordinate in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current top value. Default value is 0
     */
    public int getTop()  {
        return (int)Math.round(getAttributeAsDouble("top"));
    }

    /**
     * Top coordinate in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current top value. Default value is 0
     */
    public double getTopAsDouble()  {
        return getAttributeAsDouble("top");
    }
    

    /**
     * Width in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the width of the drawRect
     *
     * @param width new width. Default value is 100
     * @return {@link com.smartgwt.client.widgets.drawing.DrawRect DrawRect} instance, for chaining setter calls
     */
    public DrawRect setWidth(int width) {
        return (DrawRect)setAttribute("width", width, true);
    }

    /**
     * Width in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current width value. Default value is 100
     */
    public int getWidth()  {
        return (int)Math.round(getAttributeAsDouble("width"));
    }

    /**
     * Width in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current width value. Default value is 100
     */
    public double getWidthAsDouble()  {
        return getAttributeAsDouble("width");
    }
    

    // ********************* Methods ***********************
	/**
     * Get the center point of the rectangle.
     *
     * @return the center point
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
     * Move the drawRect by the specified delta
     * @param dX number of pixels to move horizontally
     * @param dY number of pixels to move vertically
     */
    public native void moveBy(int dX, int dY) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveBy", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveBy(dX, dY);
    }-*/;

	/**
     * Move the drawRect to the specified position
     * @param left new left coordinate
     * @param top new top coordinate
     */
    public native void moveTo(Integer left, Integer top) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveTo", "Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveTo(left == null ? null : left.@java.lang.Integer::intValue()(), top == null ? null : top.@java.lang.Integer::intValue()());
    }-*/;

	/**
     * Resize by the specified delta
     * @param dX number of pixels to resize by horizontally
     * @param dY number of pixels to resize by vertically
     */
    public native void resizeBy(int dX, int dY) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "resizeBy", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.resizeBy(dX, dY);
    }-*/;

	/**
     * Resize to the specified size
     * @param width new width
     * @param height new height
     */
    public native void resizeTo(Integer width, Integer height) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "resizeTo", "Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.resizeTo(width == null ? null : width.@java.lang.Integer::intValue()(), height == null ? null : height.@java.lang.Integer::intValue()());
    }-*/;

	/**
     * Move the drawRect such that it is centered over the specified coordinates.
     * @param left left coordinate for new center position
     * @param top top coordinate for new center postiion
     */
    public native void setCenter(int left, int top) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setCenter", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setCenter(left, top);
    }-*/;

	/**
     * Move and resize the drawRect to match the specified coordinates and size.
     * @param left new left coordinate
     * @param top new top coordinate
     * @param width new width
     * @param height new height
     */
    public native void setRect(Integer left, Integer top, Integer width, Integer height) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setRect", "Integer,Integer,Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setRect(left == null ? null : left.@java.lang.Integer::intValue()(), top == null ? null : top.@java.lang.Integer::intValue()(), width == null ? null : width.@java.lang.Integer::intValue()(), height == null ? null : height.@java.lang.Integer::intValue()());
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
     * @param drawRectProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DrawRect drawRectProperties) /*-{
        if (drawRectProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DrawRect.@java.lang.Object::getClass()(), "setDefaultProperties", drawRectProperties.@java.lang.Object::getClass()());
        }
        drawRectProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = drawRectProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DrawRect.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DrawRectLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.height = getAttributeAsString("height");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawRect.height:" + t.getMessage() + "\n";
        }
        try {
            s.left = getAttributeAsString("left");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawRect.left:" + t.getMessage() + "\n";
        }
        try {
            s.lineCap = getAttributeAsString("lineCap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawRect.lineCap:" + t.getMessage() + "\n";
        }
        try {
            s.titleRotationMode = getAttributeAsString("titleRotationMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawRect.titleRotationMode:" + t.getMessage() + "\n";
        }
        try {
            s.top = getAttributeAsString("top");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawRect.top:" + t.getMessage() + "\n";
        }
        try {
            s.width = getAttributeAsString("width");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawRect.width:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DrawRectLogicalStructure s = new DrawRectLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
