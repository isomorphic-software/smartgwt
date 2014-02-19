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
 
package com.smartgwt.client.widgets.drawing;



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
 * DrawItem that renders cubic bezier curves.
 */
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
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * First cubic bezier control point.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the first cubic bezier control point
     *
     * @param controlPoint1 left coordinate for control point, in pixels. Default value is [100,0]
     */
    public void setControlPoint1(Point controlPoint1) {
        setAttribute("controlPoint1", controlPoint1.getJsObj(), true);
    }

    /**
     * First cubic bezier control point.
     *
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
     * Update the second cubic bezier control point
     *
     * @param controlPoint2 left coordinate for control point, in pixels. Default value is [0,100]
     */
    public void setControlPoint2(Point controlPoint2) {
        setAttribute("controlPoint2", controlPoint2.getJsObj(), true);
    }

    /**
     * Second cubic bezier control point.
     *
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
     *
     * @return Point
     */
    public Point getEndPoint()  {
        return new Point(getAttributeAsJavaScriptObject("endPoint"));
    }

    /**
     * Style of drawing the endpoints of a line. <P> Note that for dashed and dotted lines, the lineCap style affects each dash
     * or dot.
     *
     * @param lineCap lineCap Default value is "butt"
     */
    public void setLineCap(LineCap lineCap) {
        setAttribute("lineCap", lineCap == null ? null : lineCap.getValue(), true);
    }

    /**
     * Style of drawing the endpoints of a line. <P> Note that for dashed and dotted lines, the lineCap style affects each dash
     * or dot.
     *
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
     *
     * @return Point
     */
    public Point getStartPoint()  {
        return new Point(getAttributeAsJavaScriptObject("startPoint"));
    }

    // ********************* Methods ***********************
            
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
     * Sets start, end and control points of this curve
     * @param x new x coordinate in pixels
     * @param y new y coordinate in pixels
     */
    public native void moveTo(int x, int y) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveTo(x, y);
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



