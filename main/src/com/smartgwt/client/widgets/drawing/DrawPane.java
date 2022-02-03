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
 * A DrawPane is a container for drawing bitmap and vector graphics using browser's built-in freeform drawing capabilities.
 * These include the HTML5 <code>&lt;canvas&gt;</code> tag and <code>SVG (Scalable Vector Graphics)</code> where available,
 * and the <code>VML (Vector Markup Language)</code> for legacy browsers (Internet Explorer 8 and earlier). <p> To draw in
 * a <code>DrawPane</code> you create {@link com.smartgwt.client.widgets.drawing.DrawLine}s, {@link
 * com.smartgwt.client.widgets.drawing.DrawOval}s, {@link com.smartgwt.client.widgets.drawing.DrawPath}s and other {@link
 * com.smartgwt.client.widgets.drawing.DrawItem}-based components, and place them in the <code>DrawPane</code> via {@link
 * com.smartgwt.client.widgets.drawing.DrawPane#getDrawItems drawItems} or add them incrementally via {@link
 * com.smartgwt.client.widgets.drawing.DrawPane#addDrawItem addDrawItem()}. <p> <code>DrawItems</code> support a variety of
 * common features, such as  {@link com.smartgwt.client.widgets.drawing.Gradient gradient fills}, {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getStartArrow arrowheads}, events such as {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#addClickHandler click()} and built-in {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs} for end user resizing and manipulation of shapes.
 * <p> Common shapes such as {@link com.smartgwt.client.widgets.drawing.DrawRect rectangles}, {@link
 * com.smartgwt.client.widgets.drawing.DrawOval ovals} and {@link com.smartgwt.client.widgets.drawing.DrawTriangle
 * triangles} have dedicated DrawItem subclasses.  For other shapes, consider: <ul> <li> {@link
 * com.smartgwt.client.widgets.drawing.DrawPath} - a multi-segment line with straight segments, defined by a series      of
 * {@link com.smartgwt.client.widgets.drawing.DrawPath#getPoints points} <li> {@link
 * com.smartgwt.client.widgets.drawing.DrawPolygon} - a closed shape with straight sides, defined by a series of     
 * {@link com.smartgwt.client.widgets.drawing.DrawPolygon#getPoints points} <li> {@link
 * com.smartgwt.client.widgets.drawing.DrawShape} - a multi-segment line or closed shape whose sides can be defined by a   
 * series of commands, including curved arcs </ul> <p><b>NOTE:</b>To use the Drawing subsystem, include the Drawing module
 * in your application by including <code>&lt;inherits name="com.smartgwt.Drawing"/&gt;</code> in your GWT module XML.</p>
 * <h3>Note on Coordinate Systems</h3> There are three different coordinate systems involved when a DrawItem is drawn onto
 * a DrawPane: <ul> <li>The "local coordinate system" for a DrawItem refers to the Cartesian coordinate system     in which
 * dimensional and positional values are interpreted.  For example, when a     {@link
 * com.smartgwt.client.widgets.drawing.DrawRect} is configured with left:20, top:30, width:200, and height:100, the    
 * DrawRect represents a rectangle from (20, 30) to (220, 130) in its local coordinate     system.  For this same DrawRect,
 * {@link com.smartgwt.client.widgets.drawing.DrawRect#getTop top} is going to be 30 even if     the shape is scaled by 3x,
 * such that the (transformed) top coordinate in the drawing     coordinate system actually lies outside the visible region
 * of the DrawPane.  Similarly,     no matter what rotation is applied, {@link
 * com.smartgwt.client.widgets.drawing.DrawRect#getTop top} will continue to be 30.     <p>     Use {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getBoundingBox DrawItem.getBoundingBox()} to obtain the bounding box of the
 * item in local     coordinates.  Subclass properties also typically provide data in the local coordinate     system, such
 * as {@link com.smartgwt.client.widgets.drawing.DrawRect#getLeft DrawRect.left}, {@link
 * com.smartgwt.client.widgets.drawing.DrawRect#getTop DrawRect.top}, {@link
 * com.smartgwt.client.widgets.drawing.DrawRect#getWidth DrawRect.width},     {@link
 * com.smartgwt.client.widgets.drawing.DrawRect#getHeight DrawRect.height}, {@link
 * com.smartgwt.client.widgets.drawing.DrawPath#getPoints DrawPath.points}, and {@link
 * com.smartgwt.client.widgets.drawing.DrawTriangle#getPoints DrawTriangle.points}.     <p>     There is a local coordinate
 * system for each DrawItem.</li> <li>The "drawing coordinate system" refers to the Cartesian coordinate system shared by  
 * all DrawItems after their local transforms, such as {@link com.smartgwt.client.widgets.drawing.DrawItem#getScale
 * DrawItem.scale} or     {@link com.smartgwt.client.widgets.drawing.DrawItem#getRotation DrawItem.rotation}, have been
 * applied.     <p>     Since {@link com.smartgwt.client.widgets.drawing.DrawGroup}s pass through applied transforms to the
 * underlying items,     {@link com.smartgwt.client.widgets.drawing.DrawGroup} properties such as {@link
 * com.smartgwt.client.widgets.drawing.DrawGroup#getLeft DrawGroup.left}, {@link
 * com.smartgwt.client.widgets.drawing.DrawGroup#getTop DrawGroup.top},     {@link
 * com.smartgwt.client.widgets.drawing.DrawGroup#getWidth DrawGroup.width}, and {@link
 * com.smartgwt.client.widgets.drawing.DrawGroup#getHeight DrawGroup.height}, represent coordinates in the drawing    
 * coordinate system, as does therefore {@link com.smartgwt.client.widgets.drawing.DrawGroup#getBoundingBox
 * DrawGroup.getBoundingBox()}.  The APIs     {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingPoint
 * getDrawingPoint()}, {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingX getDrawingX()}, and     {@link
 * com.smartgwt.client.widgets.drawing.DrawPane#getDrawingY getDrawingY()}, also return drawing coordinates.     <p>    
 * For DrawItems with no local transforms, the drawing coordinate system is identical to     the local coordinate
 * system.</li> <li>The "global coordinate system" refers to the drawing coordinate system with global     DrawPane
 * transforms {@link com.smartgwt.client.widgets.drawing.DrawPane#getTranslate translate}, {@link
 * com.smartgwt.client.widgets.drawing.DrawPane#getZoomLevel zoomLevel} and     {@link
 * com.smartgwt.client.widgets.drawing.DrawPane#getRotation rotation} applied.     <p>     Use {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getResizeBoundingBox DrawItem.getResizeBoundingBox()} to obtain the
 * bounding box of a     {@link com.smartgwt.client.widgets.drawing.DrawItem} in global coordinates.  The APIs {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getPageLeft DrawItem.getPageLeft()} and      {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getPageTop DrawItem.getPageTop()} reflect global coordinates rounded to the
 * nearest pixel and     offset by the page-relative coordinates of the {@link
 * com.smartgwt.client.widgets.drawing.DrawPane}'s top left corner.     (See for example {@link
 * com.smartgwt.client.widgets.Canvas#getPageLeft Canvas.getPageLeft()} and {@link
 * com.smartgwt.client.widgets.Canvas#getPageTop Canvas.getPageTop()}.)     <p>     With the default global transforms, the
 * global coordinate system is identical to the     drawing coordinate system.</li> </ul> <p> The view port of the DrawPane
 * is the rectangle in the global coordinate system from (0, 0) that is as wide as the DrawPane's {@link
 * com.smartgwt.client.widgets.Canvas#getInnerContentWidth inner content width} and as high as the DrawPane's {@link
 * com.smartgwt.client.widgets.Canvas#getInnerContentHeight inner content height}. Note: In the case of a {@link
 * com.smartgwt.client.widgets.chart.FacetChart} showing a {@link com.smartgwt.client.widgets.chart.FacetChart#getCanZoom
 * zoom chart}, the view port height is decreased by the height of the zoom chart. <p> One other coordinate system in use
 * by a DrawPane when {@link com.smartgwt.client.widgets.drawing.DrawPane#getCanDragScroll drag-scrolling} is enabled is
 * the "viewbox coordinate system". The viewbox coordinate system is the drawing coordinate system with the {@link
 * com.smartgwt.client.widgets.drawing.DrawPane#getTranslate translate} and {@link
 * com.smartgwt.client.widgets.drawing.DrawPane#getZoomLevel zoomLevel} transforms applied.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawPane")
public class DrawPane extends Canvas implements com.smartgwt.client.widgets.drawing.events.HasDrawEndHandlers, com.smartgwt.client.widgets.drawing.events.HasDrawStartHandlers {

    public static DrawPane getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DrawPane(jsObj);
        } else {
            assert refInstance instanceof DrawPane;
            return (DrawPane)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawPane.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawPane.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawPane.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DrawPane.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DrawPane(){
        scClassName = "DrawPane";
    }

    public DrawPane(JavaScriptObject jsObj){
        scClassName = "DrawPane";
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
     * Can the user drag-scroll the DrawPane?
     *
     * @param canDragScroll New canDragScroll value. Default value is false
     * @return {@link com.smartgwt.client.widgets.drawing.DrawPane DrawPane} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawPane#setDrawingWidth
     * @see com.smartgwt.client.widgets.drawing.DrawPane#setDrawingHeight
     * 
     */
    public DrawPane setCanDragScroll(boolean canDragScroll)  throws IllegalStateException {
        return (DrawPane)setAttribute("canDragScroll", canDragScroll, false);
    }

    /**
     * Can the user drag-scroll the DrawPane?
     *
     * @return Current canDragScroll value. Default value is false
     * @see com.smartgwt.client.widgets.drawing.DrawPane#getDrawingWidth
     * @see com.smartgwt.client.widgets.drawing.DrawPane#getDrawingHeight
     * 
     */
    public boolean getCanDragScroll()  {
        Boolean result = getAttributeAsBoolean("canDragScroll");
        return result == null ? false : result;
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.drawing.DrawPane#getCanDragScroll canDragScroll} is enabled, this is the height
     * of the area in viewbox coordinates that can be accessed through drag-scrolling.
     *
     * @param drawingHeight New drawingHeight value. Default value is 1000
     * @return {@link com.smartgwt.client.widgets.drawing.DrawPane DrawPane} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * 
     */
    public DrawPane setDrawingHeight(int drawingHeight)  throws IllegalStateException {
        return (DrawPane)setAttribute("drawingHeight", drawingHeight, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.drawing.DrawPane#getCanDragScroll canDragScroll} is enabled, this is the height
     * of the area in viewbox coordinates that can be accessed through drag-scrolling.
     *
     * @return Current drawingHeight value. Default value is 1000
     * 
     */
    public int getDrawingHeight()  {
        return getAttributeAsInt("drawingHeight");
    }
    

    /**
     * Which type of drawing back-end should be used by this <code>DrawPane</code>? A default drawing back-end is automatically
     * selected based on the browser. <p> The <code>drawingType</code> can only be set to a drawing back-end type that is
     * supported by the browser. It is provided for cases where the browser supports more than one drawing back-end. See the
     * {@link com.smartgwt.client.types.DrawingType} documentation for the supported drawing back-ends and the list of browsers
     * that support each type of drawing back-end.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param drawingType New drawingType value. Default value is based on browser
     * @return {@link com.smartgwt.client.widgets.drawing.DrawPane DrawPane} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawPane setDrawingType(DrawingType drawingType)  throws IllegalStateException {
        return (DrawPane)setAttribute("drawingType", drawingType == null ? null : drawingType.getValue(), false);
    }

    /**
     * Which type of drawing back-end should be used by this <code>DrawPane</code>? A default drawing back-end is automatically
     * selected based on the browser. <p> The <code>drawingType</code> can only be set to a drawing back-end type that is
     * supported by the browser. It is provided for cases where the browser supports more than one drawing back-end. See the
     * {@link com.smartgwt.client.types.DrawingType} documentation for the supported drawing back-ends and the list of browsers
     * that support each type of drawing back-end.
     *
     * @return Current drawingType value. Default value is based on browser
     */
    public DrawingType getDrawingType()  {
        return EnumUtil.getEnum(DrawingType.values(), getAttribute("drawingType"));
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.drawing.DrawPane#getCanDragScroll canDragScroll} is enabled, this is the width
     * of the area in viewbox coordinates that can be accessed through drag-scrolling.
     *
     * @param drawingWidth New drawingWidth value. Default value is 1000
     * @return {@link com.smartgwt.client.widgets.drawing.DrawPane DrawPane} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * 
     */
    public DrawPane setDrawingWidth(int drawingWidth)  throws IllegalStateException {
        return (DrawPane)setAttribute("drawingWidth", drawingWidth, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.drawing.DrawPane#getCanDragScroll canDragScroll} is enabled, this is the width
     * of the area in viewbox coordinates that can be accessed through drag-scrolling.
     *
     * @return Current drawingWidth value. Default value is 1000
     * 
     */
    public int getDrawingWidth()  {
        return getAttributeAsInt("drawingWidth");
    }
    

    /**
     * Array of DrawItems to initially display in this DrawPane.
     *
     * @param drawItems New drawItems value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawPane DrawPane} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawPane setDrawItems(DrawItem... drawItems)  throws IllegalStateException {
        return (DrawPane)setAttribute("drawItems", drawItems, false);
    }

    /**
     * Array of DrawItems to initially display in this DrawPane.
     *
     * @return Current drawItems value. Default value is null
     */
    public DrawItem[] getDrawItems()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfDrawItem(getAttributeAsJavaScriptObject("drawItems"));
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "DrawPaneEditProxy"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawPane DrawPane} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public DrawPane setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (DrawPane)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "DrawPaneEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Array of gradients that can be referenced by DrawItems placed on this DrawPane. Each gradient must have an ID assigned
     * to be used for reference.
     *
     * @param gradients New gradients value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawPane DrawPane} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawPane setGradients(Gradient... gradients)  throws IllegalStateException {
        return (DrawPane)setAttribute("gradients", gradients, false);
    }

    /**
     * Array of gradients that can be referenced by DrawItems placed on this DrawPane. Each gradient must have an ID assigned
     * to be used for reference.
     *
     * @return Current gradients value. Default value is null
     */
    public Gradient[] getGradients()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfGradient(getAttributeAsJavaScriptObject("gradients"));
    }
    

    /**
     * Rotation in degrees for the <code>DrawPane</code> as a whole about the center of the <code>DrawPane</code>. The positive
     * direction corresponds to clockwise rotation (for example, 45 is rotation clockwise by 45 degrees and -10 is rotation
     * counterclockwise by 10 degrees).
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.drawing.DrawPane#getRotation rotation} of the <code>DrawPane</code>.
     *
     * @param rotation the new rotation in degrees. The positive direction corresponds to clockwise rotation. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawPane DrawPane} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public DrawPane setRotation(float rotation) {
        return (DrawPane)setAttribute("rotation", rotation, true);
    }

    /**
     * Rotation in degrees for the <code>DrawPane</code> as a whole about the center of the <code>DrawPane</code>. The positive
     * direction corresponds to clockwise rotation (for example, 45 is rotation clockwise by 45 degrees and -10 is rotation
     * counterclockwise by 10 degrees).
     *
     * @return Current rotation value. Default value is 0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getRotation()  {
        return getAttributeAsFloat("rotation");
    }

    /**
     * Rotation in degrees for the <code>DrawPane</code> as a whole about the center of the <code>DrawPane</code>. The positive
     * direction corresponds to clockwise rotation (for example, 45 is rotation clockwise by 45 degrees and -10 is rotation
     * counterclockwise by 10 degrees).
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.drawing.DrawPane#getRotation rotation} of the <code>DrawPane</code>.
     *
     * @param rotation the new rotation in degrees. The positive direction corresponds to clockwise rotation. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawPane DrawPane} instance, for chaining setter calls
     */
    public DrawPane setRotation(double rotation) {
        return (DrawPane)setAttribute("rotation", rotation, true);
    }

    /**
     * Rotation in degrees for the <code>DrawPane</code> as a whole about the center of the <code>DrawPane</code>. The positive
     * direction corresponds to clockwise rotation (for example, 45 is rotation clockwise by 45 degrees and -10 is rotation
     * counterclockwise by 10 degrees).
     *
     * @return Current rotation value. Default value is 0
     */
    public double getRotationAsDouble()  {
        return getAttributeAsDouble("rotation");
    }
    

    /**
     * Global translation. This array has two numbers. The first number is the X translation amount in pixels and the second
     * number is the Y translation amount in pixels.
     *
     * @param translate New translate value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawPane DrawPane} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DrawPane setTranslate(int[] translate)  throws IllegalStateException {
        return (DrawPane)setAttribute("translate", translate, false);
    }

    /**
     * Global translation. This array has two numbers. The first number is the X translation amount in pixels and the second
     * number is the Y translation amount in pixels.
     *
     * @return Current translate value. Default value is null
     */
    public int[] getTranslate()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfint(getAttributeAsJavaScriptObject("translate"));
    }
    

    /**
     * Zoom for the <code>DrawPane</code> as a whole, where 1 is normal size.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the zoom on this <code>DrawPane</code> to the specified magnification, maintaining the current viewport position.
     *
     * @param zoomLevel Desired zoom level as a float where <code>1.0</code> is equivalent to 100% magnification. Must be greater than 0. Default value is 1
     * @return {@link com.smartgwt.client.widgets.drawing.DrawPane DrawPane} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public DrawPane setZoomLevel(float zoomLevel) {
        return (DrawPane)setAttribute("zoomLevel", zoomLevel, true);
    }

    /**
     * Zoom for the <code>DrawPane</code> as a whole, where 1 is normal size.
     *
     * @return Current zoomLevel value. Default value is 1
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getZoomLevel()  {
        return getAttributeAsFloat("zoomLevel");
    }

    /**
     * Zoom for the <code>DrawPane</code> as a whole, where 1 is normal size.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the zoom on this <code>DrawPane</code> to the specified magnification, maintaining the current viewport position.
     *
     * @param zoomLevel Desired zoom level as a float where <code>1.0</code> is equivalent to 100% magnification. Must be greater than 0. Default value is 1
     * @return {@link com.smartgwt.client.widgets.drawing.DrawPane DrawPane} instance, for chaining setter calls
     */
    public DrawPane setZoomLevel(double zoomLevel) {
        return (DrawPane)setAttribute("zoomLevel", zoomLevel, true);
    }

    /**
     * Zoom for the <code>DrawPane</code> as a whole, where 1 is normal size.
     *
     * @return Current zoomLevel value. Default value is 1
     */
    public double getZoomLevelAsDouble()  {
        return getAttributeAsDouble("zoomLevel");
    }
    

    // ********************* Methods ***********************
	/**
     * Adds a draw item to this <code>DrawPane</code>.  If already added to a <code>DrawPane</code>, the draw item is removed
     * from its current <code>DrawPane</code> and added to this <code>DrawPane</code>. <p> NOTE: For performance reasons, this
     * <code>DrawPane</code> may draw the new item on a delay to allow multiple items to be added and drawn at one time. The
     * {@link com.smartgwt.client.widgets.drawing.DrawPane#refreshNow refreshNow()} API will force the item to be drawn
     * immediately.
     * @param item item to add.
     * @param autoDraw If explicitly set to false, and this drawPane is drawn, don't draw   the newly added item
     */
    public native void addDrawItem(DrawItem item, boolean autoDraw) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addDrawItem", "DrawItem,boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addDrawItem(item == null ? null : item.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), autoDraw);
    }-*/;

	/**
     * Add a new gradient to the drawPane shared gradient list ({@link
     * com.smartgwt.client.widgets.drawing.DrawPane#getGradients gradients}). If the gradient does not have an ID a new one
     * will be assigned.
     * @param gradient gradient to add
     *
     * @return the ID of the gradient (either provided or auto-assigned).
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     */
    public native String addGradient(Gradient gradient) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addGradient", "Gradient");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addGradient(gradient.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Creates a linear gradient which can be used by any DrawItem of this DrawPane. Any DrawItem's {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getFillGradient fillGradient} can reference the gradient by the given ID.
     * @param id the ID of the linear gradient.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param linearGradient the linear gradient
     *
     * @return id.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @deprecated in favor of {@link com.smartgwt.client.widgets.drawing.DrawPane#addGradient addGradient()}
     */
    public native String createLinearGradient(String id, LinearGradient linearGradient) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "createLinearGradient", "String,LinearGradient");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.createLinearGradient(id, linearGradient.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Creates a radial gradient which can be used by any DrawItem of this DrawPane. Any DrawItem's {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getFillGradient fillGradient} can reference the gradient by the given ID.
     * @param id the ID of the radial gradient.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param radialGradient the radial gradient
     *
     * @return id.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @deprecated in favor of {@link com.smartgwt.client.widgets.drawing.DrawPane#addGradient addGradient()}
     */
    public native String createRadialGradient(String id, RadialGradient radialGradient) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "createRadialGradient", "String,RadialGradient");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.createRadialGradient(id, radialGradient.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Creates a simple linear gradient which can be used by any DrawItem of this DrawPane. Any DrawItem's {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getFillGradient fillGradient} can reference the gradient by the given ID.
     * @param id the ID of the simple linear gradient.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @param simple the simple linear gradient
     *
     * @return id.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @deprecated in favor of {@link com.smartgwt.client.widgets.drawing.DrawPane#addGradient addGradient()}
     */
    public native String createSimpleGradient(String id, SimpleGradient simple) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "createSimpleGradient", "String,SimpleGradient");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.createSimpleGradient(id, simple.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Permanently {@link com.smartgwt.client.widgets.drawing.DrawItem#destroy destroy} all DrawItems currently associated with
     * this DrawPane, leaving the DrawPane itself intact
     */
    public native void destroyItems() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "destroyItems", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.destroyItems();
    }-*/;

    /**
     * Add a drawEnd handler.
     * <p>
     * Called after we finish drawing to the underlying HTML5 &lt;canvas&gt; element of a DrawPane, after the last {@link
     * com.smartgwt.client.widgets.drawing.DrawItem} has been drawn.  Only called if the {@link
     * com.smartgwt.client.types.DrawingType} is  {@link com.smartgwt.client.types.DrawingType#BITMAP}.
     *
     * @param handler the drawEnd handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDrawEndHandler(com.smartgwt.client.widgets.drawing.events.DrawEndHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DrawEndEvent.getType()) == 0) setupDrawEndEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DrawEndEvent.getType());
    }

    private native void setupDrawEndEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var drawEnd = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.drawing.events.DrawEndEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawPane::handleTearDownDrawEndEvent()();
            if (hasDefaultHandler) this.Super("drawEnd", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("drawEnd"));
            obj.addProperties({drawEnd:  drawEnd              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("drawEnd"));
            obj.drawEnd =  drawEnd             ;
        }
    }-*/;

    private void handleTearDownDrawEndEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.DrawEndEvent.getType()) == 0) tearDownDrawEndEvent();
    }

    private native void tearDownDrawEndEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("drawEnd")) delete obj.drawEnd;
    }-*/;

    /**
     * Add a drawStart handler.
     * <p>
     * Called when we start drawing to the underlying HTML5 &lt;canvas&gt; element of a DrawPane, right after the element is
     * cleared.  Only called if the {@link com.smartgwt.client.types.DrawingType} is  {@link
     * com.smartgwt.client.types.DrawingType#BITMAP}.
     *
     * @param handler the drawStart handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDrawStartHandler(com.smartgwt.client.widgets.drawing.events.DrawStartHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.drawing.events.DrawStartEvent.getType()) == 0) setupDrawStartEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.drawing.events.DrawStartEvent.getType());
    }

    private native void setupDrawStartEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var drawStart = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.drawing.events.DrawStartEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.drawing.DrawPane::handleTearDownDrawStartEvent()();
            if (hasDefaultHandler) this.Super("drawStart", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("drawStart"));
            obj.addProperties({drawStart:  drawStart              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("drawStart"));
            obj.drawStart =  drawStart             ;
        }
    }-*/;

    private void handleTearDownDrawStartEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.drawing.events.DrawStartEvent.getType()) == 0) tearDownDrawStartEvent();
    }

    private native void tearDownDrawStartEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("drawStart")) delete obj.drawStart;
    }-*/;

	/**
     * Call {@link com.smartgwt.client.widgets.drawing.DrawItem#erase DrawItem.erase()} on all DrawItems currently associated
     * with the DrawPane.   <P> The DrawItems will continue to exist, and you can call draw() on them to make them appear
     * again, or {@link com.smartgwt.client.widgets.drawing.DrawItem#destroy destroy} to get rid of them permanetly.  Use
     * {@link com.smartgwt.client.widgets.drawing.DrawPane#destroyItems destroyItems()} to permanently get rid of all
     * DrawItems.
     */
    public native void erase() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "erase", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.erase();
    }-*/;

	/**
     * Get a "data:" URL encoding the current contents of the <code>DrawPane</code>. <p> The returned "data:" URLs can be used
     * anywhere a URL to an image is valid, for example, {@link com.smartgwt.client.widgets.Img#getSrc Img.src}. <p> This
     * method will directly return the data URL on modern browsers when using &lt;canvas&gt;-style rendering (the default), and
     * if there are no {@link com.smartgwt.client.widgets.drawing.DrawImage}s in this <code>DrawPane</code> that load
     * cross-domain images. <p> On legacy browers (any version of IE in "quirks" mode, all versions of IE prior to 9.0), or if
     * there is a <code>DrawImage</code> that loads a cross-domain image, data URL generation requires a server trip and
     * requires the Smart GWT Server to be installed with the same set of {@link
     * com.smartgwt.client.docs.JavaModuleDependencies required .jars} as are required for PDF export of charts in legacy IE. 
     * The method will return null and a callback must be passed, which fires when the data URL has been retrieved from the
     * server. <p> If the callback is passed but no server trip is required, the callback is fired immediately. <p> For
     * obtaining PNG or other image data for use in server-side processing (such as attaching to automated emails or saving to
     * a database), see also the server-side APIs in com.isomorphic.contentexport.ImageExport. <p> Note: It is recommended to
     * pass a callback instead of relying on the method returning the data URL directly. This is because the callback will
     * always be called with the generated data URL, whereas work-arounds for browser bugs may require asynchronous generation
     * of the data URL, meaning that a data URL might not be returned immediately in certain browsers for certain
     * <code>DrawPane</code> contents.
     *
     * @return the data URL if synchronously generated.
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#chart_image_export" target="examples">Chart Image Export Example</a>
     */
    public native String getDataURL() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDataURL", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDataURL();
        return ret;
    }-*/;

    /**
     * @see DrawPane#getDataURL
     */
    public String getDataURL(DataURLCallback callback){
        return getDataURL(callback, null);
    }

	/**
     * Get a "data:" URL encoding the current contents of the <code>DrawPane</code>. <p> The returned "data:" URLs can be used
     * anywhere a URL to an image is valid, for example, {@link com.smartgwt.client.widgets.Img#getSrc Img.src}. <p> This
     * method will directly return the data URL on modern browsers when using &lt;canvas&gt;-style rendering (the default), and
     * if there are no {@link com.smartgwt.client.widgets.drawing.DrawImage}s in this <code>DrawPane</code> that load
     * cross-domain images. <p> On legacy browers (any version of IE in "quirks" mode, all versions of IE prior to 9.0), or if
     * there is a <code>DrawImage</code> that loads a cross-domain image, data URL generation requires a server trip and
     * requires the Smart GWT Server to be installed with the same set of {@link
     * com.smartgwt.client.docs.JavaModuleDependencies required .jars} as are required for PDF export of charts in legacy IE. 
     * The method will return null and a callback must be passed, which fires when the data URL has been retrieved from the
     * server. <p> If the callback is passed but no server trip is required, the callback is fired immediately. <p> For
     * obtaining PNG or other image data for use in server-side processing (such as attaching to automated emails or saving to
     * a database), see also the server-side APIs in com.isomorphic.contentexport.ImageExport. <p> Note: It is recommended to
     * pass a callback instead of relying on the method returning the data URL directly. This is because the callback will
     * always be called with the generated data URL, whereas work-arounds for browser bugs may require asynchronous generation
     * of the data URL, meaning that a data URL might not be returned immediately in certain browsers for certain
     * <code>DrawPane</code> contents.
     * @param callback callback to fire when the data URL is available. The callback is called regardless of whether the data URL is also
     * returned.
     * @param format the format of the data URL. If not specified, then  {@link com.smartgwt.client.types.DataURLFormat#ALL} is assumed.
     *
     * @return the data URL if synchronously generated.
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#chart_image_export" target="examples">Chart Image Export Example</a>
     */
    public native String getDataURL(DataURLCallback callback, DataURLFormat format) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDataURL", "DataURLCallback,DataURLFormat");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDataURL(
			$entry( function(dataURL) { 
				if(callback!=null) callback.@com.smartgwt.client.widgets.drawing.DataURLCallback::execute(Ljava/lang/String;)(
					dataURL
				);
			}), format == null ? null : format.@com.smartgwt.client.types.DataURLFormat::getValue()());
        return ret;
    }-*/;
	
	/**
     * Returns the point of the last event in the {@link com.smartgwt.client.widgets.drawing.DrawPane drawing coordinate
     * system}. <p> To give a concrete example, suppose that this <code>DrawPane</code> has {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#getZoomLevel zoomLevel} 2 and drag-panning is not enabled (just to simplify
     * this example). If {@link com.smartgwt.client.widgets.Canvas#getOffsetX getOffsetX()} and {@link
     * com.smartgwt.client.widgets.Canvas#getOffsetY getOffsetY()} is (0, 0) (i.e. the mouse pointer is located at the top left
     * point of this <code>DrawPane</code>), then getDrawingPoint() would return (0, 0). If getOffsetX/Y() is (20, 40), then
     * getDrawingPoint() would return (10, 20) because when the 2&times; zoom level is applied, (10, 20) is translated to (20,
     * 40) on the screen. You could, for example, create a new {@link com.smartgwt.client.widgets.drawing.DrawLine} with {@link
     * com.smartgwt.client.widgets.drawing.DrawLine#getStartPoint startPoint} (10, 20) and when this line is drawn on screen,
     * the position of the line's start point would be at offset (20, 40) on screen.
     *
     * @return the point in drawing coordinates of the last event.
     * 
     */
    public native Point getDrawingPoint() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDrawingPoint", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawingPoint();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.drawing.Point::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the X coordinate in the {@link com.smartgwt.client.widgets.drawing.DrawPane drawing coordinate system} of the
     * last event. Note: If you need both the X and Y coordinates in the drawing coordinate system of the last event, it is
     * more efficient to call {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingPoint getDrawingPoint()} instead.
     * <p> See the documentation of {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingPoint getDrawingPoint()} for
     * a clarifying example.
     *
     * @return X coordinate in the drawing coordinate system of the last event.
     */
    public native int getDrawingX() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDrawingX", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawingX();
        return ret;
    }-*/;

	/**
     * Returns the Y coordinate in the {@link com.smartgwt.client.widgets.drawing.DrawPane drawing coordinate system} of the
     * last event. Note: If you need both the X and Y coordinates in the drawing coordinate system of the last event, it is
     * more efficient to call {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingPoint getDrawingPoint()} instead.
     * <p> See the documentation of {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingPoint getDrawingPoint()} for
     * a clarifying example.
     *
     * @return Y coordinate in the drawing coordinate system of the last event.
     */
    public native int getDrawingY() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getDrawingY", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDrawingY();
        return ret;
    }-*/;

	/**
     * Returns gradient for gradientID.
     * @param gradientID ID of gradient to retrieve.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     *
     * @return the gradient or null if not found
     * @see com.smartgwt.client.docs.Identifier Identifier
     */
    public native Gradient getGradient(String gradientID) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getGradient", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getGradient(gradientID);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.drawing.Gradient::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Converts this DrawPane to the source of an <code>&lt;svg&gt;</code> element equivalent to the current drawing. <p> In
     * Pro edition and above, the returned string can be used with {@link com.smartgwt.client.rpc.RPCManager#exportImage
     * RPCManager.exportImage()} to download an image, or with server-side APIs in com.isomorphic.contentexport.ImageExport to
     * obtain various kinds of images for further server-side processing.
     *
     * @return the source of an <code>&lt;svg&gt;</code> element.
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#chart_image_export" target="examples">Chart Image Export Example</a>
     */
    public native String getSvgString() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSvgString", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSvgString();
        return ret;
    }-*/;

	/**
     * Immediately draws or redraws any items of this <code>DrawPane</code> that are scheduled to be drawn or redrawn after a
     * delay. <p> For performance reasons, this <code>DrawPane</code> may delay refreshing its display to allow for multiple
     * draw item updates to be drawn at the same time.  If this is occurring, refreshNow() will immediately refresh the display
     * instead of refreshing the display in a timer.
     */
    public native void refreshNow() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "refreshNow", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.refreshNow();
    }-*/;

	/**
     * Removes gradient for gradientID.
     * @param gradientID ID of gradient to remove.
     * See {@link com.smartgwt.client.docs.Identifier Identifier}
     * @see com.smartgwt.client.docs.Identifier Identifier
     */
    public native void removeGradient(String gradientID) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeGradient", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeGradient(gradientID);
    }-*/;

	/**
     * Synonym of {@link com.smartgwt.client.widgets.drawing.DrawPane#setRotation setRotation()}.
     * @param degrees the new rotation in degrees. The positive direction corresponds to clockwise rotation.
     */
    public native void rotate(double degrees) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "rotate", "double");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.rotate(degrees);
    }-*/;

	/**
     * Synonym of {@link com.smartgwt.client.widgets.drawing.DrawPane#setZoomLevel setZoomLevel()}.
     * @param zoomLevel Desired zoom level as a float where <code>1.0</code> is equivalent to 100% magnification. Must be greater than 0.
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native void zoom(float zoomLevel) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "zoom", "float");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.zoom(zoomLevel);
    }-*/;

	/**
     * Synonym of {@link com.smartgwt.client.widgets.drawing.DrawPane#setZoomLevel setZoomLevel()}.
     * @param zoomLevel Desired zoom level as a float where <code>1.0</code> is equivalent to 100% magnification. Must be greater than 0.
     */
    public native void zoom(double zoomLevel) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "zoom", "double");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.zoom(zoomLevel);
    }-*/;


    // ********************* Static Methods ***********************

	/**
     * Computes a cubic Be&#769;zier curve polynomial: <code> B(t) = (1 - t)<sup>3</sup>P<sub>1</sub> + 3(1 -
     * t)<sup>2</sup>tCP<sub>1</sub> + 3(1 - t)t<sup>2</sup>CP<sub>2</sub> + t<sup>3</sup>P<sub>2</sub> </code>
     * @param p1 starting point coordinate
     * @param cp1 first control point coordinate
     * @param cp2 second control point coordinate
     * @param p2 end point coordinate
     * @param t the value of the parameter of the curve, between 0 and 1
     *
     * @return the value of the polynomial <code>B(t)</code> at <code>t</code>
     */
    public static native double bezier(double p1, double cp1, double cp2, double p2, double t) /*-{
        var ret = $wnd.isc.DrawPane.bezier(p1, cp1, cp2, p2, t);
        return ret;
    }-*/;


	/**
     * Computes the minimum and maximum value of the cubic Be&#769;zier curve polynomial defined in {@link
     * com.smartgwt.client.widgets.drawing.DrawPane#bezier bezier()}, for <code>0 &le; t &le; 1</code>.
     * @param p1 starting point coordinate
     * @param cp1 first control point coordinate
     * @param cp2 second control point coordinate
     * @param p2 end point coordinate
     *
     * @return the minimum and maximum value of the cubic Be&#769;zier curve polynomial
     */
    public static native double[] bezierExtrema(double p1, double cp1, double cp2, double p2) /*-{
        var ret = $wnd.isc.DrawPane.bezierExtrema(p1, cp1, cp2, p2);
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfdouble(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Calculate the bounding box of the cubic Be&#769;zier curve with endpoints <code>p1</code> and <code>p2</code> and
     * control points <code>cp1</code> and <code>cp2</code>.
     * @param p1 start point of the curve
     * @param cp1 first cubic Be&#769;zier control point
     * @param cp2 second cubic Be&#769;zier control point
     * @param p2 end point of the curve
     *
     * @return the x1, y1, x2, y2 coordinates.  The point <code>(x1, y1)</code> is the top-left point of the bounding box and the point
     * <code>(x2, y2)</code> is the bottom-right point of the bounding box.
     */
    public static native double[] getBezierBoundingBox(Point p1, Point cp1, Point cp2, Point p2) /*-{
        var ret = $wnd.isc.DrawPane.getBezierBoundingBox(p1.@com.smartgwt.client.core.DataClass::getJsObj()(), cp1.@com.smartgwt.client.core.DataClass::getJsObj()(), cp2.@com.smartgwt.client.core.DataClass::getJsObj()(), p2.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfdouble(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Computes an array of Points for a polygon that has an equal distance from its center to any of its vertices and that
     * fits in the given width and height.
     * @param width width of target space
     * @param height height of target space
     * @param xc center point x
     * @param yc center point y
     * @param angles the complete list of angles (in radians) with respect to the center point at which the polygon must have vertices
     *
     * @return list of the vertices of the polygon
     */
    public static native Point[] getPolygonPoints(int width, int height, int xc, int yc, double[] angles) /*-{
        var ret = $wnd.isc.DrawPane.getPolygonPoints(width, height, xc, yc, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([D)(angles));
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfPoint(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Calls {@link com.smartgwt.client.widgets.drawing.DrawPane#getPolygonPoints getPolygonPoints()} with angles spread evenly
     * over the full 360 degrees.
     * @param n the number of vertices the polygon
     * @param width width of target space
     * @param height height of target space
     * @param xc center point x
     * @param yc center point y
     * @param startAngle the angle (in radians) with respect to the center point of the first vertex of the polygon
     *
     * @return list of the vertices of the regular polygon
     */
    public static native Point[] getRegularPolygonPoints(int n, int width, int height, int xc, int yc, double startAngle) /*-{
        var ret = $wnd.isc.DrawPane.getRegularPolygonPoints(n, width, height, xc, yc, startAngle);
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfPoint(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Computes the top-, left-, bottom-, and right-most coordinates in a list of points, then translates and scales all points
     * to fit the entire shape into the given width and height.
     * @param width width of target space
     * @param height height of target space
     * @param xc center point x
     * @param yc center point y
     * @param points list of points to scale and translate
     */
    public static native void scaleAndCenter(int width, int height, int xc, int yc, Point... points) /*-{
        $wnd.isc.DrawPane.scaleAndCenter(width, height, xc, yc, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(points));
    }-*/;


	/**
     * Computes the top-, left-, bottom-, and right-most coordinates containing the Be&#769;zier curve defined by
     * <code>startPoint</code>, <code>controlPoint1</code>, <code>controlPoint2</code>, and <code>endPoint</code>, then
     * translates and scales these four points to fit the entire curve into the given width and height.
     * @param width width of target space
     * @param height height of target space
     * @param xc center point x
     * @param yc center point y
     * @param startPoint start point of the curve
     * @param endPoint end point of the curve
     * @param controlPoint1 first cubic Be&#769;zier control point
     * @param controlPoint2 second cubic Be&#769;zier control point
     */
    public static native void scaleAndCenterBezier(int width, int height, int xc, int yc, Point startPoint, Point endPoint, Point controlPoint1, Point controlPoint2) /*-{
        $wnd.isc.DrawPane.scaleAndCenterBezier(width, height, xc, yc, startPoint.@com.smartgwt.client.core.DataClass::getJsObj()(), endPoint.@com.smartgwt.client.core.DataClass::getJsObj()(), controlPoint1.@com.smartgwt.client.core.DataClass::getJsObj()(), controlPoint2.@com.smartgwt.client.core.DataClass::getJsObj()());
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
     * @param drawPaneProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DrawPane drawPaneProperties) /*-{
        if (drawPaneProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DrawPane.@java.lang.Object::getClass()(), "setDefaultProperties", drawPaneProperties.@java.lang.Object::getClass()());
        }
        drawPaneProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = drawPaneProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DrawPane.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Sets the properties for creating a <code>DrawItem</code> AutoChild named <code>autoChildName</code>.
     *
     * <p><code>properties</code> must not have already been created 
     * ({@link com.smartgwt.client.widgets.drawing.DrawItem#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * <p><b>NOTE:</b> Overrides at override points are not applied to the AutoChild created from
     * <code>properties</code>; that is, if the Java {@link java.lang.Class} of <code>properties</code>
     * overrides a Smart&nbsp;GWT override point, the custom method implementation will not be called.
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public void setAutoChildProperties(String autoChildName, DrawItem properties)
        throws IllegalStateException 
    {
        if (properties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(this.getClass(), "setAutoChildProperties",
                                                    properties.getClass());
        }
        properties.setConfigOnly(true);

        final JavaScriptObject selfJS = isCreated() ? getJsObj() : getConfig();
        JSOHelper.setAttribute(selfJS, autoChildName + "Properties",
                               JSOHelper.cleanProperties(properties.getConfig(), true));
    }

    /**
     * Retrieves printable HTML for this component and all printable subcomponents.
     * <p>
     * By default any Canvas with children will simply collect the printable HTML of its
     * children by calling getPrintHTML() on each child that is considered
     * {@link com.smartgwt.client.widgets.Canvas#getShouldPrint printable}.
     * <p>
     * If overriding this method for a custom component, you should <b>either</b> return a String of
     * printable HTML string directly <b>or</b> return null, and fire the callback (if provided).
     * <p>
     * To return an empty print representation, return an empty string ("") rather than null.
     * <p>
     * The <code>printProperties</code> argument, if passed, must be passed to any subcomponents on
     * which <code>getPrintHTML()</code> is called.
     * <p>
     * <b>Notes on printing</b>
     * <p>
     * To print a <code>DrawPane</code> for export on IE8 and earlier, it is 
     * {@link com.smartgwt.client.util.PrintProperties} with {@link com.smartgwt.client.util.PrintProperties#getPrintForExport
     * printForExport}:true:
     * <pre>
     * final PrintProperties pp = new PrintProperties();
     * pp.setPrintForExport(true);
     * final String exportHTML = drawPane.getPrintHTML(pp, null);
     * </pre>
     * <p>
     * <b>Note: this is an override point.</b>
     * @param printProperties properties to configure printing behavior - may be null.
     * @param callback optional callback to fire. Generated HTML should be passed to the
     * {@link com.smartgwt.client.util.PrintHTMLCallback#setHTML(String)} method of the callback.
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintHTML(PrintProperties printProperties, PrintHTMLCallback callback) {
        return super.getPrintHTML(printProperties, callback);
    }

    private static boolean instanceofDrawItem(Object obj) {
        return (obj instanceof DrawItem);
    }

    static native <T extends DrawItem> T createDrawItem(String smartClientClassName, JavaScriptObject javaScriptObject) /*-{
        var drawItem = @com.smartgwt.client.util.ObjectFactory::createBaseClass(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Z)(smartClientClassName, javaScriptObject, false);
        if (@com.smartgwt.client.widgets.drawing.DrawPane::instanceofDrawItem(Ljava/lang/Object;)(drawItem)) {
            return drawItem;
        } else {
            return null;
        }
    }-*/;

    public static class InvalidDrawingTypeException extends RuntimeException {
        public InvalidDrawingTypeException() {
        }
        public InvalidDrawingTypeException(String message) {
            super(message);
        }
    }

    /**
     * Returns the GWT Canvas underlying this DrawPane.  Throws an 
     * {@link com.smartgwt.client.widgets.drawing.DrawPane.InvalidDrawingTypeException} if the 
     * {@link com.smartgwt.client.types.DrawingType} isn't a
     * {@link com.smartgwt.client.types.DrawingType#BITMAP}.
     * <P> 
     * To create a DrawItem drawn by custom GWT Canvas drawing code, you should:<ul>
     * <li>Subclass the {@link com.smartgwt.client.widgets.drawing.DrawRect} class, setting
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#getLineOpacity DrawItem.lineOpacity}
     * to 0, and {@link com.smartgwt.client.widgets.drawing.DrawItem#getEventOpaque DrawItem.eventOpaque}
     * to true.
     * <li>Trigger your drawing routine in a handler for the 
     * {@link com.smartgwt.client.widgets.drawing.events.DrawStartEvent DrawStartEvent} or
     * {@link com.smartgwt.client.widgets.drawing.events.DrawEndEvent DrawEndEvent}, using this
     * method to gain access to the GWT Canvas.
     * <li>Limit your drawing to the DrawItem's
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#getResizeBoundingBox bounding box}.
     * </ul>
     * 
     * @return the GWT Canvas
     * @see addDrawStartHandler
     * @see addDrawEndHandler
     */
    public com.google.gwt.canvas.client.Canvas getUnderlyingGWTCanvas() {
        if (DrawingType.BITMAP != getDrawingType()) {
            throw new InvalidDrawingTypeException("Cannot access the GWT Canvas for a " +
                                        "DrawPane with drawingType " + getDrawingType());
        }
        com.google.gwt.dom.client.Element element = 
            com.google.gwt.dom.client.Element.as(getBitmap());
        return com.google.gwt.canvas.client.Canvas.wrap(
            (com.google.gwt.dom.client.CanvasElement)element);
    }

    private native com.google.gwt.dom.client.Node getBitmap() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getBitmap();
    }-*/;

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DrawPaneLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.canDragScroll = getAttributeAsString("canDragScroll");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPane.canDragScroll:" + t.getMessage() + "\n";
        }
        try {
            s.drawingHeight = getAttributeAsString("drawingHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPane.drawingHeight:" + t.getMessage() + "\n";
        }
        try {
            s.drawingType = getAttributeAsString("drawingType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPane.drawingType:" + t.getMessage() + "\n";
        }
        try {
            s.drawingWidth = getAttributeAsString("drawingWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPane.drawingWidth:" + t.getMessage() + "\n";
        }
        try {
            s.drawItems = getDrawItems();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPane.drawItemsArray:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPane.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.gradients = getGradients();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPane.gradientsArray:" + t.getMessage() + "\n";
        }
        try {
            s.translate = getAttributeAsStringArray("translate");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPane.translateArray:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DrawPaneLogicalStructure s = new DrawPaneLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
