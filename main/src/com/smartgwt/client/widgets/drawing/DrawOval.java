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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * DrawItem subclass to render oval shapes, including circles.
 */
public class DrawOval extends DrawItem {

    public static DrawOval getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawOval) obj;
        } else {
            return new DrawOval(jsObj);
        }
    }

    public DrawOval(){
        scClassName = "DrawOval";
    }

    public DrawOval(JavaScriptObject jsObj){
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Center point of the oval.  If unset, derived from left/top/width/height.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the center point for this oval.
     *
     * @param centerPoint left coordinate. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setCenterPoint(Point centerPoint)  throws IllegalStateException {
        setAttribute("centerPoint", centerPoint.getJsObj(), false);
    }

    /**
     * Center point of the oval.  If unset, derived from left/top/width/height.
     *
     *
     * @return Point
     */
    public Point getCenterPoint()  {
        return new Point(getAttributeAsJavaScriptObject("centerPoint"));
    }

    /**
     * Height in pixels.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the height of the drawOval
     *
     * @param height new height. Default value is 100
     */
    public void setHeight(int height) {
        setAttribute("height", height, true);
    }

    /**
     * Height in pixels.
     *
     *
     * @return int
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
     * Left coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the left coordinate of the drawOval
     *
     * @param left new left coordinate. Default value is 0
     */
    public void setLeft(int left) {
        setAttribute("left", left, true);
    }

    /**
     * Left coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     *
     * @return int
     */
    public int getLeft()  {
        return getAttributeAsInt("left");
    }

    /**
     * Radius of the oval.  If unset, horizontal and vertical radii are derived from width and height
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Resize the drawOval by setting its radius, and retaining its current center point.
     *
     * @param radius new radius. This will be applied on both axes, meaning calling this  method will always result in the drawOval being
     * rendered as a circle. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRadius(Integer radius)  throws IllegalStateException {
        setAttribute("radius", radius, false);
    }

    /**
     * Radius of the oval.  If unset, horizontal and vertical radii are derived from width and height
     *
     *
     * @return Integer
     */
    public Integer getRadius()  {
        return getAttributeAsInt("radius");
    }

    /**
     * Top coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the top coordinate of the drawOval
     *
     * @param top new top coordinate. Default value is 0
     */
    public void setTop(int top) {
        setAttribute("top", top, true);
    }

    /**
     * Top coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     *
     * @return int
     */
    public int getTop()  {
        return getAttributeAsInt("top");
    }

    /**
     * Width in pixels.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the width of the drawOval
     *
     * @param width new width. Default value is 100
     */
    public void setWidth(int width) {
        setAttribute("width", width, true);
    }

    /**
     * Width in pixels.
     *
     *
     * @return int
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }

    // ********************* Methods ***********************
            
    /**
     * Move the drawOval by the specified delta
     * @param dX number of pixels to move horizontally
     * @param dY number of pixels to move vertically
     */
    public native void moveBy(int dX, int dY) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveBy(dX, dY);
    }-*/;
            
    /**
     * Move the drawOval to the specified left/top position. You may also call {@link
     * com.smartgwt.client.widgets.drawing.DrawOval#setCenterPoint DrawOval.setCenterPoint} to reposition the oval around a new
     * center position.
     * @param left new left coordinate
     * @param top new top coordinate
     */
    public native void moveTo(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveTo(left, top);
    }-*/;
            
    /**
     * Resize by the specified delta. Note that the resize will occur from the current top/left  coordinates, meaning the
     * center positon of the oval may change. You may also use {@link com.smartgwt.client.widgets.drawing.DrawOval#setRadii
     * DrawOval.setRadii} to change the radius in either direction without modifying the centerpoint.
     * @param dX number of pixels to resize by horizontally
     * @param dY number of pixels to resize by vertically
     */
    public native void resizeBy(int dX, int dY) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.resizeBy(dX, dY);
    }-*/;
            
    /**
     * Resize to the specified size. Note that the resize will occur from the current top/left  coordinates, meaning the center
     * positon of the oval may change. You may also use {@link com.smartgwt.client.widgets.drawing.DrawOval#setRadii
     * DrawOval.setRadii} to change the radius in either direction without modifying the centerpoint.
     * @param width new width
     * @param height new height
     */
    public native void resizeTo(int width, int height) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.resizeTo(width, height);
    }-*/;
            
    /**
     * Resize and reposition the drawOval by setting its radius, and centerPoint.
     * @param cx new horizontal center point coordinate
     * @param cy new vertical center point coordinate
     * @param rx new horizontal radius
     * @param ry new vertical radius
     */
    public native void setOval(int cx, int cy, int rx, int ry) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setOval(cx, cy, rx, ry);
    }-*/;
            
    /**
     * Resize the drawOval by setting its horizontal and vertical radius, and retaining its current center point.
     * @param rx new horizontal radius
     * @param ry new vertical radius
     */
    public native void setRadii(int rx, int ry) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setRadii(rx, ry);
    }-*/;
            
    /**
     * Move and resize the drawOval to match the specified coordinates and size.
     * @param left new left coordinate
     * @param top new top coordinate
     * @param width new width
     * @param height new height
     */
    public native void setRect(int left, int top, int width, int height) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setRect(left, top, width, height);
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



