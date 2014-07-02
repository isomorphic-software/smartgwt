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
 * DrawItem subclass to render line segments.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawLine")
public class DrawLine extends DrawItem {

    public static DrawLine getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawLine) obj;
        } else {
            return new DrawLine(jsObj);
        }
    }


    public DrawLine(){
        scClassName = "DrawLine";
    }

    public DrawLine(JavaScriptObject jsObj){
        scClassName = "DrawLine";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Ending left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getEndPoint endPoint} if both are set.
     *
     * @param endLeft  Default value is 100
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEndLeft(int endLeft)  throws IllegalStateException {
        setAttribute("endLeft", endLeft, false);
    }

    /**
     * Ending left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getEndPoint endPoint} if both are set.
     *
     * @return int
     */
    public int getEndLeft()  {
        return getAttributeAsInt("endLeft");
    }
    

    /**
     * End point of the line
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
     * End point of the line
     *
     * @return Point
     */
    public Point getEndPoint()  {
        return new Point(getAttributeAsJavaScriptObject("endPoint"));
    }
    

    /**
     * Ending top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getEndPoint endPoint} if both are set.
     *
     * @param endTop  Default value is 100
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEndTop(int endTop)  throws IllegalStateException {
        setAttribute("endTop", endTop, false);
    }

    /**
     * Ending top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getEndPoint endPoint} if both are set.
     *
     * @return int
     */
    public int getEndTop()  {
        return getAttributeAsInt("endTop");
    }
    

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this will
     * turn on UI element(s) allowing the user to manipulate this DrawLine.  To update the set of knobs at runtime use {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs}. <p> DrawLine supports the  {@link
     * com.smartgwt.client.types.KnobType#STARTPOINT}, {@link com.smartgwt.client.types.KnobType#ENDPOINT}, and {@link
     * com.smartgwt.client.types.KnobType#MOVE} knob types.
     *
     * @param knobs  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * 
     * 
     */
    public void setKnobs(KnobType... knobs)  throws IllegalStateException {
        setAttribute("knobs", knobs, false);
    }

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this will
     * turn on UI element(s) allowing the user to manipulate this DrawLine.  To update the set of knobs at runtime use {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs}. <p> DrawLine supports the  {@link
     * com.smartgwt.client.types.KnobType#STARTPOINT}, {@link com.smartgwt.client.types.KnobType#ENDPOINT}, and {@link
     * com.smartgwt.client.types.KnobType#MOVE} knob types.
     *
     * @return KnobType...
     * 
     * 
     */
    public KnobType[] getKnobs()  {
        final String[] strings = getAttributeAsStringArray("knobs");
        return EnumUtil.getEnums(KnobType.values(), strings, strings == null ? null : new KnobType[strings.length]);
    }
    

    /**
     * Starting left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint} if both are set.
     *
     * @param startLeft  Default value is 0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setStartLeft(int startLeft)  throws IllegalStateException {
        setAttribute("startLeft", startLeft, false);
    }

    /**
     * Starting left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint} if both are set.
     *
     * @return int
     */
    public int getStartLeft()  {
        return getAttributeAsInt("startLeft");
    }
    

    /**
     * Start point of the line
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
     * Start point of the line
     *
     * @return Point
     */
    public Point getStartPoint()  {
        return new Point(getAttributeAsJavaScriptObject("startPoint"));
    }
    

    /**
     * Starting top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint} if both are set.
     *
     * @param startTop  Default value is 0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setStartTop(int startTop)  throws IllegalStateException {
        setAttribute("startTop", startTop, false);
    }

    /**
     * Starting top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint} if both are set.
     *
     * @return int
     */
    public int getStartTop()  {
        return getAttributeAsInt("startTop");
    }
    

    // ********************* Methods ***********************
	/**
     * Get the midpoint of the line.
     *
     * @return the midpoint
     */
    public native Point getCenter() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.isPointInPath(x, y);
        return ret;
    }-*/;



	/**
     * Move both the start and end points of the line by a relative amount.
     * @param left change to left coordinate in pixels
     * @param top change to top coordinate in pixels
     */
    public native void moveBy(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
     */
    public static native void setDefaultProperties(DrawLine drawLineProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawLineProperties.@com.smartgwt.client.core.BaseClass::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.DrawLine.addProperties(properties);
    }-*/;

    // ***********************************************************

}



