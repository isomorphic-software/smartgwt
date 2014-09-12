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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * Canvas that renders a {@link com.smartgwt.client.widgets.drawing.DrawItem} into a {@link
 * com.smartgwt.client.widgets.drawing.DrawPane} and provides interactivity for that drawItem, including drag and drop. <P>
 * A DrawKnob can either be initialized with a {@link com.smartgwt.client.widgets.drawing.DrawKnob#getKnobShape DrawItem
 * knobShape} or created via the {@link com.smartgwt.client.types.AutoChild} pattern. <P> DrawKnobs are used by the {@link
 * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs drawItem control knobs} subsystem.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawKnob")
public class DrawKnob extends Canvas {

    public static DrawKnob getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DrawKnob(jsObj);
        } else {
            assert refInstance instanceof DrawKnob;
            return (DrawKnob)refInstance;
        }
    }


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.DrawKnob.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc.DrawKnob.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;
    /**
     * Changes the defaults for DrawItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults DrawItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, DrawItem defaults) /*-{
        $wnd.isc.DrawKnob.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.drawing.DrawItem::getJsObj()());
    }-*/;

    public DrawKnob(){
        scClassName = "DrawKnob";
    }

    public DrawKnob(JavaScriptObject jsObj){
        scClassName = "DrawKnob";
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
     * {@link com.smartgwt.client.widgets.drawing.DrawPane} into which this DrawKnob's {@link
     * com.smartgwt.client.widgets.drawing.DrawKnob#getKnobShape knobShape} will be rendered.
     *
     * @param drawPane  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDrawPane(DrawPane drawPane)  throws IllegalStateException {
        setAttribute("drawPane", drawPane == null ? null : drawPane.getOrCreateJsObj(), false);
    }

    /**
     * {@link com.smartgwt.client.widgets.drawing.DrawPane} into which this DrawKnob's {@link
     * com.smartgwt.client.widgets.drawing.DrawKnob#getKnobShape knobShape} will be rendered.
     *
     * @return DrawPane
     */
    public DrawPane getDrawPane()  {
        return (DrawPane)DrawPane.getByJSObject(getAttributeAsJavaScriptObject("drawPane"));
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.drawing.DrawItem} instance rendered into this DrawKnob's drawPane
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DrawItem
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DrawItem getKnobShape() throws IllegalStateException {
        errorIfNotCreated("knobShape");
        return DrawItem.getOrCreateRef(getAttributeAsJavaScriptObject("knobShape"));
    }
    

    /**
     * Default properties for this component's {@link com.smartgwt.client.widgets.drawing.DrawKnob#getKnobShape knobShape}. Has
     * the
     *  following properties by default:
     *  <pre>
     *   radius : 5,
     *   lineWidth:2,
     *   fillColor:"#FF0000",
     *   fillOpacity:0.5,
     *  </pre>
     * 
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param knobShapeDefaults  Default value is {...}
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setKnobShapeDefaults(DrawItem knobShapeDefaults)  throws IllegalStateException {
        JavaScriptObject config = knobShapeDefaults == null ? null : knobShapeDefaults.getConfig();
        setAttribute("knobShapeDefaults", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Default properties for this component's {@link com.smartgwt.client.widgets.drawing.DrawKnob#getKnobShape knobShape}. Has
     * the
     *  following properties by default:
     *  <pre>
     *   radius : 5,
     *   lineWidth:2,
     *   fillColor:"#FF0000",
     *   fillOpacity:0.5,
     *  </pre>
     * 
     *
     * @return DrawItem
     */
    public DrawItem getKnobShapeDefaults()  {
        return DrawItem.getOrCreateRef(getAttributeAsJavaScriptObject("knobShapeDefaults"));
    }
    

    /**
     * X-Coordinate for this DrawKnob. DrawKnob will initially be drawn centered over this coordinate
     *
     * @param x  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setX(Integer x)  throws IllegalStateException {
        setAttribute("x", x, false);
    }

    /**
     * X-Coordinate for this DrawKnob. DrawKnob will initially be drawn centered over this coordinate
     *
     * @return Integer
     */
    public Integer getX()  {
        return getAttributeAsInt("x");
    }
    

    /**
     * Y-Coordinate for this DrawKnob. DrawKnob will initially be drawn centered over this coordinate
     *
     * @param y  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setY(Integer y)  throws IllegalStateException {
        setAttribute("y", y, false);
    }

    /**
     * Y-Coordinate for this DrawKnob. DrawKnob will initially be drawn centered over this coordinate
     *
     * @return Integer
     */
    public Integer getY()  {
        return getAttributeAsInt("y");
    }
    

    // ********************* Methods ***********************


	/**
     * Sets the center point of the drawKnob.  If the optional <code>viewboxCoords</code> argument is passed, coordinates are
     * expected to be already adjusted for drawPane pan and zoom.  Otherwise coordinates are expected to be absolute pixel
     * coordinates within the drawPane.
     * @param x new x coordinate for this drawKnob
     * @param y new y coordinate for this drawKnob
     */
    public native void setCenterPoint(Integer x, Integer y) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setCenterPoint(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()());
    }-*/;


	/**
     * Sets the center point of the drawKnob.  If the optional <code>viewboxCoords</code> argument is passed, coordinates are
     * expected to be already adjusted for drawPane pan and zoom.  Otherwise coordinates are expected to be absolute pixel
     * coordinates within the drawPane.
     * @param x new x coordinate for this drawKnob
     * @param y new y coordinate for this drawKnob
     * @param viewboxCoords If <code>true</code>, the <code>x</code> and <code>y</code> values are expected to be in the viewbox coordinate system
     * (described {@link com.smartgwt.client.widgets.drawing.DrawPane here}) - already adjusted for any zoom or pan applied to
     * the drawPane.
     */
    public native void setCenterPoint(Integer x, Integer y, boolean viewboxCoords) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setCenterPoint(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()(), viewboxCoords == null ? false : viewboxCoords);
    }-*/;
	


	/**
     * Method called in response to the user dragging this DrawKnob. May be observed or overridden to allow drawItems to react
     * to user drag interactions on this knob. <P> Note that the default implementation does nothing. When working with draw
     * knobs directly this is typically where you would both update the shape being controlled by the draw knob, and ensure the
     * drawKnob gets repositioned. You may also need to update the drawKnob position in response to the drawItem being
     * repositioned, resized, etc.
     * @param x new x-coordinate of the drawKnob
     * @param y new y-coordinate of the drawKnob
     * @param dX horizontal distance moved
     * @param dY vertical distance moved
     * @param state either "start", "move", or "stop", to indicate the current phase of dragging of the DrawKnob for which the points need
     * to be updated
     */
    public native void updatePoints(Integer x, Integer y, Integer dX, Integer dY, String state) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.updatePoints(x == null ? null : x.@java.lang.Integer::intValue()(), y == null ? null : y.@java.lang.Integer::intValue()(), dX == null ? null : dX.@java.lang.Integer::intValue()(), dY == null ? null : dY.@java.lang.Integer::intValue()(), state);
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
     * @param drawKnobProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DrawKnob drawKnobProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawKnobProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.DrawKnob.addProperties(properties);
    }-*/;

    // ***********************************************************



//
//
//
//
//

    /**
     * Sets the properties for creating a <code>DrawItem</code> AutoChild named <code>autoChildName</code>.
     *
     * <p><code>properties</code> must not have already been created ({@link com.smartgwt.client.widgets.drawing.DrawItem#isCreated() properties.isCreated()}
     * must be <code>false</code>).
     *
     * <p><b>NOTE:</b> Overrides at override points are not applied to the AutoChild created from
     * <code>properties</code>; that is, if the Java {@link java.lang.Class} of <code>properties</code>
     * overrides a Smart&nbsp;GWT override point, the custom method implementation will not be called.
     *
     * @throws IllegalStateException if <code>properties</code> has been created.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public native void setAutoChildProperties(String autoChildName, DrawItem properties) /*-{
        if (properties.@com.smartgwt.client.widgets.drawing.DrawItem::isCreated()()) {
            throw @java.lang.IllegalStateException::new(Ljava/lang/String;)(properties.getClassName() + " passed as configuration properties has been initialized and/or drawn. Calling draw(), fetchData() and other methods will force a component to initialize, after which it cannot be used as configuration properties.");
        }
        var self;
        if (this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self[autoChildName + "Properties"] = properties.@com.smartgwt.client.widgets.drawing.DrawItem::getConfig()();
    }-*/;

    /**
     * Returns the <code>DrawItem</code> AutoChild named <code>autoChildName</code> if already created.
     *
     * @param autoChildName name of an AutoChild to return.
     * @throws RuntimeException if the AutoChild is not a &#83;martClient <code>DrawItem</code> object.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public native final DrawItem getDrawItemAutoChild(String autoChildName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var autoChildJS = self[autoChildName];
        if (autoChildJS == null) return null;
        if (!$wnd.isc.isA.DrawItem(autoChildJS)) throw @java.lang.RuntimeException::new(Ljava/lang/String;)("The '" + autoChildName + "' AutoChild is not a DrawItem.");

        // getDrawItemAutoChild() should return the same Object.
        if (autoChildJS.__ref !== undefined) return autoChildJS.__ref;
        return (autoChildJS.__ref = @com.smartgwt.client.widgets.drawing.DrawPane::createDrawItem(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(autoChildJS.getClassName(), autoChildJS));
    }-*/;

    public LogicalStructureObject setLogicalStructure(DrawKnobLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.drawPane = getDrawPane();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawKnob.drawPane:" + t.getMessage() + "\n";
        }
        try {
            s.knobShapeDefaults = getAttributeAsString("knobShapeDefaults");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawKnob.knobShapeDefaults:" + t.getMessage() + "\n";
        }
        try {
            s.x = getAttributeAsString("x");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawKnob.x:" + t.getMessage() + "\n";
        }
        try {
            s.y = getAttributeAsString("y");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawKnob.y:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        DrawKnobLogicalStructure s = new DrawKnobLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

