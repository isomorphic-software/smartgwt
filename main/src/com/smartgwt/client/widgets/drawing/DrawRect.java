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
 * DrawItem subclass to render rectangle shapes, optionally with rounded corners.
 */
public class DrawRect extends DrawItem {

    public static DrawRect getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawRect) obj;
        } else {
            return new DrawRect(jsObj);
        }
    }

    public DrawRect(){
        scClassName = "DrawRect";
    }

    public DrawRect(JavaScriptObject jsObj){
        super(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Height in pixels.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the height of the drawRect
     *
     * @param height new height. Default value is 100
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setHeight(int height)  throws IllegalStateException {
        setAttribute("height", height, false);
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
     * Set the left coordinate of the drawRect
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
     * Style of drawing the endpoints of a line. <P> Note that for dashed and dotted lines, the lineCap style affects each dash
     * or dot.
     *
     * @param lineCap lineCap Default value is "butt"
     */
    public void setLineCap(LineCap lineCap) {
        setAttribute("lineCap", lineCap.getValue(), true);
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
     * Rounding of corners, from 0 (square corners) to 1.0 (shorter edge is a semicircle).
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter method for {@link com.smartgwt.client.widgets.drawing.DrawRect#getRounding rounding}
     *
     * @param rounding new rounding value. Should be between zero (a rectangle) and 1 (shorter   edge is a semicircle). Default value is 0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRounding(float rounding)  throws IllegalStateException {
        setAttribute("rounding", rounding, false);
    }

    /**
     * Rounding of corners, from 0 (square corners) to 1.0 (shorter edge is a semicircle).
     *
     *
     * @return float
     */
    public float getRounding()  {
        return getAttributeAsFloat("rounding");
    }

    /**
     * Top coordinate in pixels relative to the DrawPane, or owning DrawGroup.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the top coordinate of the drawRect
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
     * Set the width of the drawRect
     *
     * @param width new width. Default value is 100
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setWidth(int width)  throws IllegalStateException {
        setAttribute("width", width, false);
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
     * Move the drawRect by the specified delta
     * @param dX number of pixels to move horizontally
     * @param dY number of pixels to move vertically
     */
    public native void moveBy(int dX, int dY) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveBy(dX, dY);
    }-*/;
            
    /**
     * Move the drawRect to the specified position
     * @param left new left coordinate
     * @param top new top coordinate
     */
    public native void moveTo(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveTo(left, top);
    }-*/;
            
    /**
     * Resize by the specified delta
     * @param dX number of pixels to resize by horizontally
     * @param dY number of pixels to resize by vertically
     */
    public native void resizeBy(int dX, int dY) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.resizeBy(dX, dY);
    }-*/;
            
    /**
     * Resize to the specified size
     * @param width new width
     * @param height new height
     */
    public native void resizeTo(int width, int height) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.resizeTo(width, height);
    }-*/;
            
    /**
     * Move the drawRect such that it is centered over the specified coordinates.
     * @param left left coordinate for new center position
     * @param top top coordinate for new center postiion
     */
    public native void setCenter(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setCenter(left, top);
    }-*/;
            
    /**
     * Move and resize the drawRect to match the specified coordinates and size.
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



