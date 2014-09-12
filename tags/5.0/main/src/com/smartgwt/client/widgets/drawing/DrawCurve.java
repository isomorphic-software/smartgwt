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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
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
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * DrawItem that renders cubic bezier curves.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawCurve")
public class DrawCurve extends DrawItem {

    public static DrawCurve getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawCurve) obj;
        } else {
            return new DrawCurve(jsObj);
        }
    }


    public DrawCurve(){
        scClassName = "DrawCurve";
    }

    public DrawCurve(JavaScriptObject jsObj){
        scClassName = "DrawCurve";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * If this item is showing  {@link com.smartgwt.client.types.KnobType#CONTROLPOINT1} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs}, this attribute specifies the AutoChild for the
     * {@link com.smartgwt.client.widgets.drawing.DrawKnob} for control point 1 of current drawCurve.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DrawKnob
     * @throws IllegalStateException if the underlying component has not yet been created.
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
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DrawKnob
     * @throws IllegalStateException if the underlying component has not yet been created.
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
     */
    public void setControlPoint1(Point controlPoint1) {
        setAttribute("controlPoint1", controlPoint1.getJsObj(), true);
    }

    /**
     * First cubic bezier control point.
     *
     * @return Point
     */
    public Point getControlPoint1()  {
        return new Point(getAttributeAsJavaScriptObject("controlPoint1"));
    }
    

    /**
     * Second cubic bezier control point.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Updates the second cubic B&#233;zier control point.
     *
     * @param controlPoint2 left coordinate for control point, in pixels. Default value is [0,100]
     */
    public void setControlPoint2(Point controlPoint2) {
        setAttribute("controlPoint2", controlPoint2.getJsObj(), true);
    }

    /**
     * Second cubic bezier control point.
     *
     * @return Point
     */
    public Point getControlPoint2()  {
        return new Point(getAttributeAsJavaScriptObject("controlPoint2"));
    }
    

    /**
     * End point of the curve
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the endPoint
     *
     * @param endPoint left coordinate for end point, in pixels. Default value is [100,100]
     */
    public void setEndPoint(Point endPoint) {
        setAttribute("endPoint", endPoint.getJsObj(), true);
    }

    /**
     * End point of the curve
     *
     * @return Point
     */
    public Point getEndPoint()  {
        return new Point(getAttributeAsJavaScriptObject("endPoint"));
    }
    

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this will
     * turn on UI element(s) allowing the user to manipulate this DrawCurve.  To update the set of knobs at runtime use {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs}. <p> DrawCurve supports the  {@link
     * com.smartgwt.client.types.KnobType#STARTPOINT}, {@link com.smartgwt.client.types.KnobType#ENDPOINT}, {@link
     * com.smartgwt.client.types.KnobType#CONTROLPOINT1}, and {@link com.smartgwt.client.types.KnobType#CONTROLPOINT2} knob
     * types.
     *
     * @param knobs  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setKnobs
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#diagramming" target="examples">Diagramming Example</a>
     * 
     */
    public void setKnobs(KnobType... knobs)  throws IllegalStateException {
        setAttribute("knobs", knobs, false);
    }

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this will
     * turn on UI element(s) allowing the user to manipulate this DrawCurve.  To update the set of knobs at runtime use {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs}. <p> DrawCurve supports the  {@link
     * com.smartgwt.client.types.KnobType#STARTPOINT}, {@link com.smartgwt.client.types.KnobType#ENDPOINT}, {@link
     * com.smartgwt.client.types.KnobType#CONTROLPOINT1}, and {@link com.smartgwt.client.types.KnobType#CONTROLPOINT2} knob
     * types.
     *
     * @return KnobType...
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#diagramming" target="examples">Diagramming Example</a>
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
     * @param lineCap  Default value is "butt"
     */
    public void setLineCap(LineCap lineCap) {
        setAttribute("lineCap", lineCap == null ? null : lineCap.getValue(), true);
    }

    /**
     * Style of drawing the endpoints of a line. <P> Note that for dashed and dotted lines, the lineCap style affects each dash
     * or dot.
     *
     * @return LineCap
     */
    public LineCap getLineCap()  {
        return EnumUtil.getEnum(LineCap.values(), getAttribute("lineCap"));
    }
    

    /**
     * Start point of the curve
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the startPoint
     *
     * @param startPoint left coordinate for start point, in pixels. Default value is [0,0]
     */
    public void setStartPoint(Point startPoint) {
        setAttribute("startPoint", startPoint.getJsObj(), true);
    }

    /**
     * Start point of the curve
     *
     * @return Point
     */
    public Point getStartPoint()  {
        return new Point(getAttributeAsJavaScriptObject("startPoint"));
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
     */
    public static native void setDefaultProperties(DrawCurve drawCurveProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawCurveProperties.@com.smartgwt.client.core.BaseClass::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.DrawCurve.addProperties(properties);
    }-*/;

    // ***********************************************************

}


