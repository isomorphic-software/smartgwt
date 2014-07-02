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
 * DrawItem subclass to render Pie Slices.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawSector")
public class DrawSector extends DrawItem {

    public static DrawSector getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawSector) obj;
        } else {
            return new DrawSector(jsObj);
        }
    }


    public DrawSector(){
        scClassName = "DrawSector";
    }

    public DrawSector(JavaScriptObject jsObj){
        scClassName = "DrawSector";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Center point of the sector
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the center point for this sector.
     *
     * @param centerPoint X coordinate of the center point (in the global coordinate system).. Default value is [0,0]
     */
    public void setCenterPoint(Point centerPoint) {
        setAttribute("centerPoint", centerPoint.getJsObj(), true);
    }

    /**
     * Center point of the sector
     *
     * @return Point
     */
    public Point getCenterPoint()  {
        return new Point(getAttributeAsJavaScriptObject("centerPoint"));
    }
    

    /**
     * End angle of the sector in degrees.
     *
     * @param endAngle  Default value is 20.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public void setEndAngle(float endAngle)  throws IllegalStateException {
        setAttribute("endAngle", endAngle, false);
    }

    /**
     * End angle of the sector in degrees.
     *
     * @return float
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getEndAngle()  {
        return getAttributeAsFloat("endAngle");
    }

    /**
     * End angle of the sector in degrees.
     *
     * @param endAngle  Default value is 20.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setEndAngle(double endAngle)  throws IllegalStateException {
        setAttribute("endAngle", endAngle, false);
    }

    /**
     * End angle of the sector in degrees.
     *
     * @return double
     */
    public double getEndAngleAsDouble()  {
        return getAttributeAsDouble("endAngle");
    }
    

    /**
     * DrawSector only supports the  {@link com.smartgwt.client.types.KnobType#MOVE} knob type.
     *
     * @param knobs  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setKnobs
     * 
     * 
     */
    public void setKnobs(KnobType... knobs)  throws IllegalStateException {
        setAttribute("knobs", knobs, false);
    }

    /**
     * DrawSector only supports the  {@link com.smartgwt.client.types.KnobType#MOVE} knob type.
     *
     * @return KnobType...
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
     * @param radius  Default value is 100
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRadius(int radius)  throws IllegalStateException {
        setAttribute("radius", radius, false);
    }

    /**
     * Radius of the sector.
     *
     * @return int
     */
    public int getRadius()  {
        return getAttributeAsInt("radius");
    }
    

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} of the
     * DrawSector. The positive direction is clockwise.
     *
     * @param rotation  Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public void setRotation(float rotation)  throws IllegalStateException {
        setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} of the
     * DrawSector. The positive direction is clockwise.
     *
     * @return float
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getRotation()  {
        return getAttributeAsFloat("rotation");
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} of the
     * DrawSector. The positive direction is clockwise.
     *
     * @param rotation  Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRotation(double rotation)  throws IllegalStateException {
        setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} of the
     * DrawSector. The positive direction is clockwise.
     *
     * @return double
     */
    public double getRotationAsDouble()  {
        return getAttributeAsDouble("rotation");
    }
    

    /**
     * Start angle of the sector in degrees.  Default of 0.0 will create a sector that starts with a line from the {@link
     * com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} and extends to the right for the indicated
     * {@link com.smartgwt.client.widgets.drawing.DrawSector#getRadius radius}, then sweeps clockwise toward the {@link
     * com.smartgwt.client.widgets.drawing.DrawSector#getEndAngle endAngle}.
     *
     * @param startAngle  Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public void setStartAngle(float startAngle)  throws IllegalStateException {
        setAttribute("startAngle", startAngle, false);
    }

    /**
     * Start angle of the sector in degrees.  Default of 0.0 will create a sector that starts with a line from the {@link
     * com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} and extends to the right for the indicated
     * {@link com.smartgwt.client.widgets.drawing.DrawSector#getRadius radius}, then sweeps clockwise toward the {@link
     * com.smartgwt.client.widgets.drawing.DrawSector#getEndAngle endAngle}.
     *
     * @return float
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getStartAngle()  {
        return getAttributeAsFloat("startAngle");
    }

    /**
     * Start angle of the sector in degrees.  Default of 0.0 will create a sector that starts with a line from the {@link
     * com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} and extends to the right for the indicated
     * {@link com.smartgwt.client.widgets.drawing.DrawSector#getRadius radius}, then sweeps clockwise toward the {@link
     * com.smartgwt.client.widgets.drawing.DrawSector#getEndAngle endAngle}.
     *
     * @param startAngle  Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setStartAngle(double startAngle)  throws IllegalStateException {
        setAttribute("startAngle", startAngle, false);
    }

    /**
     * Start angle of the sector in degrees.  Default of 0.0 will create a sector that starts with a line from the {@link
     * com.smartgwt.client.widgets.drawing.DrawSector#getCenterPoint centerPoint} and extends to the right for the indicated
     * {@link com.smartgwt.client.widgets.drawing.DrawSector#getRadius radius}, then sweeps clockwise toward the {@link
     * com.smartgwt.client.widgets.drawing.DrawSector#getEndAngle endAngle}.
     *
     * @return double
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
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
     */
    public static native void setDefaultProperties(DrawSector drawSectorProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawSectorProperties.@com.smartgwt.client.core.BaseClass::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.DrawSector.addProperties(properties);
    }-*/;

    // ***********************************************************


    

}



