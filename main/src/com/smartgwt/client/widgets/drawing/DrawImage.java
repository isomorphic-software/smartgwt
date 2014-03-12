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
 * DrawItem subclass to render embedded images.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawImage")
public class DrawImage extends DrawItem {

    public static DrawImage getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawImage) obj;
        } else {
            return new DrawImage(jsObj);
        }
    }


    public DrawImage(){
        scClassName = "DrawImage";
    }

    public DrawImage(JavaScriptObject jsObj){
        scClassName = "DrawImage";
        setJavaScriptObject(jsObj);
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
     * @param height  Default value is 16
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setHeight(int height)  throws IllegalStateException {
        setAttribute("height", height, false);
    }

    /**
     * Height in pixels.
     *
     * @return int
     */
    public int getHeight()  {
        return getAttributeAsInt("height");
    }

    /**
     * Left coordinate in pixels relative to the DrawPane.
     *
     * @param left  Default value is 0
     */
    public void setLeft(int left) {
        setAttribute("left", left, true);
    }

    /**
     * Left coordinate in pixels relative to the DrawPane.
     *
     * @return int
     */
    public int getLeft()  {
        return getAttributeAsInt("left");
    }

    /**
     * URL to the image file.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Change the URL of the image displayed.
     *
     * @param src new URL. Default value is "blank.png"
     */
    public void setSrc(String src) {
        setAttribute("src", src, true);
    }

    /**
     * URL to the image file.
     *
     * @return String
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
     * Title (tooltip hover text) for this image.
     *
     * @param title  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setTitle(String title)  throws IllegalStateException {
        setAttribute("title", title, false);
    }

    /**
     * Title (tooltip hover text) for this image.
     *
     * @return String
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
     * Top coordinate in pixels relative to the DrawPane.
     *
     * @param top  Default value is 0
     */
    public void setTop(int top) {
        setAttribute("top", top, true);
    }

    /**
     * Top coordinate in pixels relative to the DrawPane.
     *
     * @return int
     */
    public int getTop()  {
        return getAttributeAsInt("top");
    }

    /**
     * Width in pixels.
     *
     * @param width  Default value is 16
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setWidth(int width)  throws IllegalStateException {
        setAttribute("width", width, false);
    }

    /**
     * Width in pixels.
     *
     * @return int
     */
    public int getWidth()  {
        return getAttributeAsInt("width");
    }

    // ********************* Methods ***********************
	/**
     * Get the center point of the image.
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
     * Move the drawImage by the specified delta
     * @param dX number of pixels to move horizontally
     * @param dY number of pixels to move vertically
     */
    public native void moveBy(int dX, int dY) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveBy(dX, dY);
    }-*/;


	/**
     * Move the drawImage to the specified position
     * @param left new left coordinate
     * @param top new top coordinate
     */
    public native void moveTo(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveTo(left, top);
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
     * @param drawImageProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DrawImage drawImageProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawImageProperties.@com.smartgwt.client.core.BaseClass::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.DrawImage.addProperties(properties);
    }-*/;

    // ***********************************************************

}


