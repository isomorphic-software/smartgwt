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
 * DrawItem subclass to render Pie Slices.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawSector")
public class DrawSector extends DrawItem {

    public static DrawSector getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DrawSector(jsObj);
        } else {
            assert refInstance instanceof DrawSector;
            return (DrawSector)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawSector.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawSector.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawSector.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DrawSector.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawSector.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "DrawItem");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawSector.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DrawSector(){
        scClassName = "DrawSector";
    }

    public DrawSector(JavaScriptObject jsObj){
        scClassName = "DrawSector";
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
     * Center point of the sector
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the center point for this sector.
     *
     * @param centerPoint X coordinate of the center point (in the global coordinate system). Default value is [0,0]
     * @return {@link com.smartgwt.client.widgets.drawing.DrawSector DrawSector} instance, for chaining setter calls
     */
    public DrawSector setCenterPoint(Point centerPoint) {
        return (DrawSector)setAttribute("centerPoint", centerPoint == null ? null : centerPoint.getJsObj(), true);
    }

    /**
     * Center point of the sector
     *
     * @return Current centerPoint value. Default value is [0,0]
     */
    public Point getCenterPoint()  {
        return Point.getOrCreateRef(getAttributeAsJavaScriptObject("centerPoint"));
    }
    

    /**
     * End angle of the sector in degrees. See {@link com.smartgwt.client.widgets.drawing.DrawSector#getStartAngle startAngle}
     * for further details.
     *
     * @param endAngle New endAngle value. Default value is 20.0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawSector DrawSector} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public DrawSector setEndAngle(float endAngle)  throws IllegalStateException {
        return (DrawSector)setAttribute("endAngle", endAngle, false);
    }

    /**
     * End angle of the sector in degrees. See {@link com.smartgwt.client.widgets.drawing.DrawSector#getStartAngle startAngle}
     * for further details.
     *
     * @return Current endAngle value. Default value is 20.0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getEndAngle()  {
        return getAttributeAsFloat("endAngle");
    }

    /**
     * End angle of the sector in degrees. See {@link com.smartgwt.client.widgets.drawing.DrawSector#getStartAngle startAngle}
     * for further details.
     *
     * @param endAngle New endAngle value. Default value is 20.0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawSector DrawSector} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawSector setEndAngle(double endAngle)  throws IllegalStateException {
        return (DrawSector)setAttribute("endAngle", endAngle, false);
    }

    /**
     * End angle of the sector in degrees. See {@link com.smartgwt.client.widgets.drawing.DrawSector#getStartAngle startAngle}
     * for further details.
     *
     * @return Current endAngle value. Default value is 20.0
     */
    public double getEndAngleAsDouble()  {
        return getAttributeAsDouble("endAngle");
    }
    

    /**
     * DrawSector only supports the  {@link com.smartgwt.client.types.KnobType#MOVE} knob type.
     *
     * @param knobs New knobs value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawSector DrawSector} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setKnobs
     * 
     * 
     */
    public DrawSector setKnobs(KnobType... knobs)  throws IllegalStateException {
        return (DrawSector)setAttribute("knobs", knobs, false);
    }

    /**
     * DrawSector only supports the  {@link com.smartgwt.client.types.KnobType#MOVE} knob type.
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
     * Radius of the sector.
     *
     * @param radius New radius value. Default value is 100
     * @return {@link com.smartgwt.client.widgets.drawing.DrawSector DrawSector} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawSector setRadius(int radius)  throws IllegalStateException {
        return (DrawSector)setAttribute("radius", radius, false);
    }

    /**
     * Radius of the sector.
     *
     * @return Current radius value. Default value is 100
     */
    public int getRadius()  {
        return (int)Math.round(getAttributeAsDouble("radius"));
    }

    /**
     * Radius of the sector.
     *
     * @return Current radius value. Default value is 100
     */
    public double getRadiusAsDouble()  {
        return getAttributeAsDouble("radius");
    }
    

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} of the
     * DrawSector. The positive direction is clockwise.
     *
     * @param rotation New rotation value. Default value is 0.0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawSector DrawSector} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public DrawSector setRotation(float rotation)  throws IllegalStateException {
        return (DrawSector)setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} of the
     * DrawSector. The positive direction is clockwise.
     *
     * @return Current rotation value. Default value is 0.0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getRotation()  {
        return getAttributeAsFloat("rotation");
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} of the
     * DrawSector. The positive direction is clockwise.
     *
     * @param rotation New rotation value. Default value is 0.0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawSector DrawSector} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawSector setRotation(double rotation)  throws IllegalStateException {
        return (DrawSector)setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} of the
     * DrawSector. The positive direction is clockwise.
     *
     * @return Current rotation value. Default value is 0.0
     */
    public double getRotationAsDouble()  {
        return getAttributeAsDouble("rotation");
    }
    

    /**
     * If the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} is showing, should the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground titleLabelBackground} be created and placed behind
     * the <code>titleLabel</code>? <p> This defaults to true for {@link com.smartgwt.client.widgets.drawing.DrawSector}s and
     * shapes that are not commonly filled (e.g. {@link com.smartgwt.client.widgets.drawing.DrawLine}s).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTitleLabelBackground New showTitleLabelBackground value. Default value is true
     * @return {@link com.smartgwt.client.widgets.drawing.DrawSector DrawSector} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawSector setShowTitleLabelBackground(boolean showTitleLabelBackground)  throws IllegalStateException {
        return (DrawSector)setAttribute("showTitleLabelBackground", showTitleLabelBackground, false);
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
     * Start angle of the sector in degrees.  Default of 0.0 will create a sector that starts with a line from the {@link
     * com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} and extends horizontally to the right for the
     * indicated {@link com.smartgwt.client.widgets.drawing.DrawSector#getRadius radius}, then sweeps clockwise toward the
     * {@link com.smartgwt.client.widgets.drawing.DrawSector#getEndAngle endAngle}. <P> Note that the startAngle may validly be
     * a greater numeric value than the endAngle. The sector will always be drawn clockwise from startAngle to endAngle, so  a
     * sector with startAngle of 350 and endAngle of 10 would draw a 20-degree segment sticking out to the right of the
     * centerPoint. <P> Drawing a full circle: A developer may have a drawSector transcribe a full circle by using values of
     * 360 or greater as the end point. For example a drawSector with startAngle set to 350 and endAngle set to 710 would
     * transcribe a full circle which starts and ends on the same line (10 degrees above the horizontal, to the right of the
     * centerPoint).
     *
     * @param startAngle New startAngle value. Default value is 0.0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawSector DrawSector} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public DrawSector setStartAngle(float startAngle)  throws IllegalStateException {
        return (DrawSector)setAttribute("startAngle", startAngle, false);
    }

    /**
     * Start angle of the sector in degrees.  Default of 0.0 will create a sector that starts with a line from the {@link
     * com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} and extends horizontally to the right for the
     * indicated {@link com.smartgwt.client.widgets.drawing.DrawSector#getRadius radius}, then sweeps clockwise toward the
     * {@link com.smartgwt.client.widgets.drawing.DrawSector#getEndAngle endAngle}. <P> Note that the startAngle may validly be
     * a greater numeric value than the endAngle. The sector will always be drawn clockwise from startAngle to endAngle, so  a
     * sector with startAngle of 350 and endAngle of 10 would draw a 20-degree segment sticking out to the right of the
     * centerPoint. <P> Drawing a full circle: A developer may have a drawSector transcribe a full circle by using values of
     * 360 or greater as the end point. For example a drawSector with startAngle set to 350 and endAngle set to 710 would
     * transcribe a full circle which starts and ends on the same line (10 degrees above the horizontal, to the right of the
     * centerPoint).
     *
     * @return Current startAngle value. Default value is 0.0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getStartAngle()  {
        return getAttributeAsFloat("startAngle");
    }

    /**
     * Start angle of the sector in degrees.  Default of 0.0 will create a sector that starts with a line from the {@link
     * com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} and extends horizontally to the right for the
     * indicated {@link com.smartgwt.client.widgets.drawing.DrawSector#getRadius radius}, then sweeps clockwise toward the
     * {@link com.smartgwt.client.widgets.drawing.DrawSector#getEndAngle endAngle}. <P> Note that the startAngle may validly be
     * a greater numeric value than the endAngle. The sector will always be drawn clockwise from startAngle to endAngle, so  a
     * sector with startAngle of 350 and endAngle of 10 would draw a 20-degree segment sticking out to the right of the
     * centerPoint. <P> Drawing a full circle: A developer may have a drawSector transcribe a full circle by using values of
     * 360 or greater as the end point. For example a drawSector with startAngle set to 350 and endAngle set to 710 would
     * transcribe a full circle which starts and ends on the same line (10 degrees above the horizontal, to the right of the
     * centerPoint).
     *
     * @param startAngle New startAngle value. Default value is 0.0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawSector DrawSector} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawSector setStartAngle(double startAngle)  throws IllegalStateException {
        return (DrawSector)setAttribute("startAngle", startAngle, false);
    }

    /**
     * Start angle of the sector in degrees.  Default of 0.0 will create a sector that starts with a line from the {@link
     * com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} and extends horizontally to the right for the
     * indicated {@link com.smartgwt.client.widgets.drawing.DrawSector#getRadius radius}, then sweeps clockwise toward the
     * {@link com.smartgwt.client.widgets.drawing.DrawSector#getEndAngle endAngle}. <P> Note that the startAngle may validly be
     * a greater numeric value than the endAngle. The sector will always be drawn clockwise from startAngle to endAngle, so  a
     * sector with startAngle of 350 and endAngle of 10 would draw a 20-degree segment sticking out to the right of the
     * centerPoint. <P> Drawing a full circle: A developer may have a drawSector transcribe a full circle by using values of
     * 360 or greater as the end point. For example a drawSector with startAngle set to 350 and endAngle set to 710 would
     * transcribe a full circle which starts and ends on the same line (10 degrees above the horizontal, to the right of the
     * centerPoint).
     *
     * @return Current startAngle value. Default value is 0.0
     */
    public double getStartAngleAsDouble()  {
        return getAttributeAsDouble("startAngle");
    }
    

    // ********************* Methods ***********************
	/**
     * Calculates the coordinates of the midpoint of this DrawSector's circular arc. The formula
     *  for this point is:
     *  <blockquote>
     *  <pre>var averageAngle = (startAngle + endAngle) / 2; // in degrees
     * [centerX + radius * cosdeg(averageAngle), centerY + radius * sindeg(averageAngle)]</pre>
     *  </blockquote>
     * 
     *
     * @return the coordinates of the midpoint of the arc.
     */
    public native Point getArcMidpoint() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getArcMidpoint", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getArcMidpoint();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.drawing.Point::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the sector's {@link com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint}.
     *
     * @return the current centerPoint
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
     * Move the DrawSector by the specified amounts.
     * @param x number of pixels to move by horizontally
     * @param y number of pixels to move by vertically
     */
    public native void moveBy(int x, int y) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveBy", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveBy(x, y);
    }-*/;


    // ********************* Static Methods ***********************

	/**
     * Calculates the midpoint coordinates of the circular arc of the sector defined by the
     *  given centerPoint, startAngle, endAngle, and radius. The formula for this point is:
     *  <blockquote>
     *  <pre>var averageAngle = (startAngle + endAngle) / 2; // in degrees
     * [centerX + radius * cosdeg(averageAngle), centerY + radius * sindeg(averageAngle)]</pre>
     *  </blockquote>
     * 
     * @param centerX X coordinate of the center point of the sector.
     * @param centerY Y coordinate of the center point of the sector.
     * @param startAngle start angle of the sector in degrees.
     * @param endAngle end angle of the sector in degrees.
     * @param radius radius of the sector.
     *
     * @return the coordinates of the midpoint of the arc.
     */
    public static native Point getArcMidpoint(double centerX, double centerY, double startAngle, double endAngle, double radius) /*-{
        var ret = $wnd.isc.DrawSector.getArcMidpoint(centerX, centerY, startAngle, endAngle, radius);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.drawing.Point::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


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
     * @param drawSectorProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DrawSector drawSectorProperties) /*-{
        if (drawSectorProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DrawSector.@java.lang.Object::getClass()(), "setDefaultProperties", drawSectorProperties.@java.lang.Object::getClass()());
        }
        drawSectorProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = drawSectorProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DrawSector.addProperties(properties);
    }-*/;

    // ***********************************************************


    

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DrawSectorLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.centerPoint = getCenterPoint();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawSector.centerPoint:" + t.getMessage() + "\n";
        }
        try {
            s.knobs = getAttributeAsStringArray("knobs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawSector.knobsArray:" + t.getMessage() + "\n";
        }
        try {
            s.radius = getAttributeAsString("radius");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawSector.radius:" + t.getMessage() + "\n";
        }
        try {
            s.showTitleLabelBackground = getAttributeAsString("showTitleLabelBackground");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawSector.showTitleLabelBackground:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DrawSectorLogicalStructure s = new DrawSectorLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
