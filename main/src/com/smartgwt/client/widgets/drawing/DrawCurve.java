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
 * DrawItem that renders cubic bezier curves.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawCurve")
public class DrawCurve extends DrawItem {

    public static DrawCurve getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DrawCurve(jsObj);
        } else {
            assert refInstance instanceof DrawCurve;
            return (DrawCurve)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawCurve.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawCurve.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawCurve.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DrawCurve.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawCurve.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "DrawItem");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawCurve.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DrawCurve(){
        scClassName = "DrawCurve";
    }

    public DrawCurve(JavaScriptObject jsObj){
        scClassName = "DrawCurve";
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
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#CONTROLPOINT1} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the AutoChild for the
     * {@link com.smartgwt.client.widgets.drawing.DrawKnob} for control point 1 of current drawCurve.
     * <p>
     * This component is an AutoChild named "c1Knob".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current c1Knob value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DrawKnob getC1Knob() throws IllegalStateException {
        errorIfNotCreated("c1Knob");
        return (DrawKnob)DrawKnob.getByJSObject(getAttributeAsJavaScriptObject("c1Knob"));
    }
    

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#CONTROLPOINT2} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the AutoChild for the
     * {@link com.smartgwt.client.widgets.drawing.DrawKnob} for control point 2 of current drawCurve.
     * <p>
     * This component is an AutoChild named "c2Knob".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current c2Knob value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DrawKnob getC2Knob() throws IllegalStateException {
        errorIfNotCreated("c2Knob");
        return (DrawKnob)DrawKnob.getByJSObject(getAttributeAsJavaScriptObject("c2Knob"));
    }
    

    /**
     * First cubic bezier control point.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Updates the first cubic B&#233;zier control point.
     *
     * @param controlPoint1 left coordinate for control point, in pixels. Default value is [100,0]
     * @return {@link com.smartgwt.client.widgets.drawing.DrawCurve DrawCurve} instance, for chaining setter calls
     */
    public DrawCurve setControlPoint1(Point controlPoint1) {
        return (DrawCurve)setAttribute("controlPoint1", controlPoint1 == null ? null : controlPoint1.getJsObj(), true);
    }

    /**
     * First cubic bezier control point.
     *
     * @return Current controlPoint1 value. Default value is [100,0]
     */
    public Point getControlPoint1()  {
        return Point.getOrCreateRef(getAttributeAsJavaScriptObject("controlPoint1"));
    }
    

    /**
     * Second cubic bezier control point.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Updates the second cubic B&#233;zier control point.
     *
     * @param controlPoint2 left coordinate for control point, in pixels. Default value is [0,100]
     * @return {@link com.smartgwt.client.widgets.drawing.DrawCurve DrawCurve} instance, for chaining setter calls
     */
    public DrawCurve setControlPoint2(Point controlPoint2) {
        return (DrawCurve)setAttribute("controlPoint2", controlPoint2 == null ? null : controlPoint2.getJsObj(), true);
    }

    /**
     * Second cubic bezier control point.
     *
     * @return Current controlPoint2 value. Default value is [0,100]
     */
    public Point getControlPoint2()  {
        return Point.getOrCreateRef(getAttributeAsJavaScriptObject("controlPoint2"));
    }
    

    /**
     * End point of the curve
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the endPoint
     *
     * @param endPoint left coordinate for end point, in pixels. Default value is [100,100]
     * @return {@link com.smartgwt.client.widgets.drawing.DrawCurve DrawCurve} instance, for chaining setter calls
     */
    public DrawCurve setEndPoint(Point endPoint) {
        return (DrawCurve)setAttribute("endPoint", endPoint == null ? null : endPoint.getJsObj(), true);
    }

    /**
     * End point of the curve
     *
     * @return Current endPoint value. Default value is [100,100]
     */
    public Point getEndPoint()  {
        return Point.getOrCreateRef(getAttributeAsJavaScriptObject("endPoint"));
    }
    

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this will
     * turn on UI element(s) allowing the user to manipulate this DrawCurve.  To update the set of knobs at runtime use {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs()} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs()}. <p> DrawCurve supports the  {@link
     * com.smartgwt.client.types.KnobType#STARTPOINT}, {@link com.smartgwt.client.types.KnobType#ENDPOINT}, {@link
     * com.smartgwt.client.types.KnobType#CONTROLPOINT1}, and {@link com.smartgwt.client.types.KnobType#CONTROLPOINT2} knob
     * types.
     *
     * @param knobs New knobs value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawCurve DrawCurve} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setKnobs
     * 
     * 
     */
    public DrawCurve setKnobs(KnobType... knobs)  throws IllegalStateException {
        return (DrawCurve)setAttribute("knobs", knobs, false);
    }

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this will
     * turn on UI element(s) allowing the user to manipulate this DrawCurve.  To update the set of knobs at runtime use {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs()} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs()}. <p> DrawCurve supports the  {@link
     * com.smartgwt.client.types.KnobType#STARTPOINT}, {@link com.smartgwt.client.types.KnobType#ENDPOINT}, {@link
     * com.smartgwt.client.types.KnobType#CONTROLPOINT1}, and {@link com.smartgwt.client.types.KnobType#CONTROLPOINT2} knob
     * types.
     *
     * @return Current knobs value. Default value is null
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * 
     * 
     */
    public KnobType[] getKnobs()  {
        final String[] strings = getAttributeAsStringArray("knobs");
        return EnumUtil.getEnums(KnobType.values(), strings, strings == null ? null : new KnobType[strings.length]);
    }
    

    /**
     * Style of drawing the endpoints of a line. <P> Note that for dashed and dotted lines, the lineCap style affects each dash
     * or dot.
     *
     * @param lineCap New lineCap value. Default value is "butt"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawCurve DrawCurve} instance, for chaining setter calls
     */
    public DrawCurve setLineCap(LineCap lineCap) {
        return (DrawCurve)setAttribute("lineCap", lineCap == null ? null : lineCap.getValue(), true);
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
     * If the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} is showing, should the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground titleLabelBackground} be created and placed behind
     * the <code>titleLabel</code>? <p> This defaults to true for {@link com.smartgwt.client.widgets.drawing.DrawSector}s and
     * shapes that are not commonly filled (e.g. {@link com.smartgwt.client.widgets.drawing.DrawLine}s).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTitleLabelBackground New showTitleLabelBackground value. Default value is true
     * @return {@link com.smartgwt.client.widgets.drawing.DrawCurve DrawCurve} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawCurve setShowTitleLabelBackground(boolean showTitleLabelBackground)  throws IllegalStateException {
        return (DrawCurve)setAttribute("showTitleLabelBackground", showTitleLabelBackground, false);
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
     * Start point of the curve
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the startPoint
     *
     * @param startPoint left coordinate for start point, in pixels. Default value is [0,0]
     * @return {@link com.smartgwt.client.widgets.drawing.DrawCurve DrawCurve} instance, for chaining setter calls
     */
    public DrawCurve setStartPoint(Point startPoint) {
        return (DrawCurve)setAttribute("startPoint", startPoint == null ? null : startPoint.getJsObj(), true);
    }

    /**
     * Start point of the curve
     *
     * @return Current startPoint value. Default value is [0,0]
     */
    public Point getStartPoint()  {
        return Point.getOrCreateRef(getAttributeAsJavaScriptObject("startPoint"));
    }
    

    // ********************* Methods ***********************
	/**
     * Get the center point of the rectangle from the curve's {@link
     * com.smartgwt.client.widgets.drawing.DrawCurve#getStartPoint startPoint} to the {@link
     * com.smartgwt.client.widgets.drawing.DrawCurve#getEndPoint endPoint}.
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
     * Increment start, end and control points of this curve
     * @param x new x coordinate in pixels
     * @param y new y coordinate in pixels
     */
    public native void moveBy(int x, int y) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveBy", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveBy(x, y);
    }-*/;

	/**
     * Move the start point, end point, and control points of the curve such that the {@link
     * com.smartgwt.client.widgets.drawing.DrawCurve#getStartPoint startPoint} ends up at the specified coordinates and the
     * shape of the curve is unchanged.
     * @param x new x coordinate in pixels
     * @param y new y coordinate in pixels
     */
    public native void moveStartPointTo(Integer x, Integer y) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveStartPointTo", "Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveStartPointTo(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()());
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
     * @param drawCurveProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DrawCurve drawCurveProperties) /*-{
        if (drawCurveProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DrawCurve.@java.lang.Object::getClass()(), "setDefaultProperties", drawCurveProperties.@java.lang.Object::getClass()());
        }
        drawCurveProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = drawCurveProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DrawCurve.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DrawCurveLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.controlPoint1 = getControlPoint1();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawCurve.controlPoint1:" + t.getMessage() + "\n";
        }
        try {
            s.controlPoint2 = getControlPoint2();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawCurve.controlPoint2:" + t.getMessage() + "\n";
        }
        try {
            s.endPoint = getEndPoint();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawCurve.endPoint:" + t.getMessage() + "\n";
        }
        try {
            s.knobs = getAttributeAsStringArray("knobs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawCurve.knobsArray:" + t.getMessage() + "\n";
        }
        try {
            s.lineCap = getAttributeAsString("lineCap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawCurve.lineCap:" + t.getMessage() + "\n";
        }
        try {
            s.showTitleLabelBackground = getAttributeAsString("showTitleLabelBackground");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawCurve.showTitleLabelBackground:" + t.getMessage() + "\n";
        }
        try {
            s.startPoint = getStartPoint();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawCurve.startPoint:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DrawCurveLogicalStructure s = new DrawCurveLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
