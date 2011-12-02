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
 * Container for DrawLine, DrawOval, DrawPath, and other DrawItem-based components. These components provide consistent
 * cross-browser APIs for rendering shapes using using the browsers' built in vector graphics capabilities. These include
 * <code>SVG (Scalable Vector Graphics)</code> where available, <code>VML (Vector Markup Language)</code> for Microsoft
 * browsers, and the HTML5 <code>&lt;canvas&gt;</code> tag. <P> You can use any of the following approaches to create
 * DrawPanes and DrawItems: <P> <dl> <dt>DrawPane only</dt> <dd> Create a DrawPane with drawItems set to an array of
 * DrawItem instances or DrawItem declaration objects, and it will manage those DrawItems. </dd> <dt>DrawItem only</dt>
 * <dd> Create and draw a DrawItem, and it will use a default DrawPane, which you can      access via the drawPane
 * property, eg myDrawItem.drawPane.bringToFront().</dd> <dt>Both</dt> <dd>Create DrawPanes with or without initial
 * drawItems, then create DrawItems     with their drawPane property set to an existing DrawPane instance.</dd> </dl> <p>To
 * use DrawPane in SmartGWT, include the Drawing module in your application by including <code>&lt;inherits
 * name="com.smartgwt.Drawing"/&gt;</code> in your GWT module XML. </p>
 */
public class DrawPane extends Canvas {

    public static DrawPane getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (DrawPane) obj;
        } else {
            return new DrawPane(jsObj);
        }
    }

    public DrawPane(){
        scClassName = "DrawPane";
    }

    public DrawPane(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Array of DrawItems to initially display in this DrawPane.
     *
     * @param drawItems drawItems Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDrawItems(DrawItem... drawItems)  throws IllegalStateException {
        setAttribute("drawItems", drawItems, false);
    }

    /**
     * Array of DrawItems to initially display in this DrawPane.
     *
     *
     * @return DrawItem
     */
    public DrawItem[] getDrawItems()  {
        return DrawItem.convertToDrawItemArray(getAttributeAsJavaScriptObject("drawItems"));
    }

    /**
     * Rotation for the DrawPane as a whole, in degrees.  Applied to all DrawItems.
     *
     * @param rotation rotation Default value is 0
     */
    public void setRotation(float rotation) {
        setAttribute("rotation", rotation, true);
    }

    /**
     * Rotation for the DrawPane as a whole, in degrees.  Applied to all DrawItems.
     *
     *
     * @return float
     */
    public float getRotation()  {
        return getAttributeAsFloat("rotation");
    }

    /**
     * Zoom for the drawPane as a whole, where 1 is normal size.  Applied to all DrawItems.
     *
     * @param zoomLevel zoomLevel Default value is 1
     */
    public void setZoomLevel(float zoomLevel) {
        setAttribute("zoomLevel", zoomLevel, true);
    }

    /**
     * Zoom for the drawPane as a whole, where 1 is normal size.  Applied to all DrawItems.
     *
     *
     * @return float
     */
    public float getZoomLevel()  {
        return getAttributeAsFloat("zoomLevel");
    }

    // ********************* Methods ***********************
            
    /**
     * Add a drawItem to this drawPane (if necessary removing it from any other drawPanes)
     * @param item drawItem to add
     * @param autoDraw If explicitly set to false, and this drawPane is drawn, don't draw   the newly added item
     */
    public native void addDrawItem(DrawItem item, boolean autoDraw) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addDrawItem(item.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()(), autoDraw);
    }-*/;
            
    /**
     * Creates a linear gradient which can be used within any DrawItem  Any DrawItems fillGradient can reference this gradient
     * by the given name.
     * @param id the name of the linear gradient
     * @param linearGradient the linear gradient
     */
    public native void createLinearGradient(String id, LinearGradient linearGradient) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.createLinearGradient(id, linearGradient.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Creates a radial gradient which can be used within any DrawItem  Any DrawItems fillGradient can reference this gradient
     * by the given name.
     * @param id the name of the radial gradient
     * @param radialGradient the radial gradient
     */
    public native void createRadialGradient(String id, RadialGradient radialGradient) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.createRadialGradient(id, radialGradient.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Creates a simple linear gradient which can be used within any DrawItem  Any DrawItems fillGradient can reference this
     * gradient by the given name.
     * @param id the name of the linear gradient
     * @param simple 
     */
    public native void createSimpleGradient(String id, SimpleGradient simple) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.createSimpleGradient(id, simple.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Permanently {@link com.smartgwt.client.widgets.drawing.DrawItem#destroy destroy} all DrawItems currently associated with
     * this DrawPane, leaving the DrawPane itself intact
     */
    public native void destroyItems() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.destroyItems();
    }-*/;
            
    /**
     * Call {@link com.smartgwt.client.widgets.drawing.DrawItem#erase DrawItem.erase} on all DrawItems currently associated
     * with the DrawPane.   <P> The DrawItems will continue to exist, and you can call draw() on them to make them appear
     * again, or {@link com.smartgwt.client.widgets.drawing.DrawItem#destroy destroy} to get rid of them permanetly.  Use
     * {@link com.smartgwt.client.widgets.drawing.DrawPane#getDestroyAll destroyAll} to permanently get rid of all DrawItems.
     */
    public native void erase() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.erase();
    }-*/;
            
    /**
     * Zoom this drawPane to the specified magnification, maintaining the current viewport position
     * @param zoom Desired zoom level as a float where <code>1.0</code> is equivalent to 100%  magnification.
     */
    public native void zoom(float zoom) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.zoom(zoom);
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript). 
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param drawPaneProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DrawPane drawPaneProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawPaneProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.DrawPane.addProperties(properties);
    }-*/;
        
    // ***********************************************************        

}



