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

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
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
 * DrawItem subclass to render polygons
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawPolygon")
public class DrawPolygon extends DrawPath {

    public static DrawPolygon getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DrawPolygon(jsObj);
        } else {
            assert refInstance instanceof DrawPolygon;
            return (DrawPolygon)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawPolygon.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawPolygon.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawPolygon.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DrawPolygon.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DrawPolygon(){
        scClassName = "DrawPolygon";
    }

    public DrawPolygon(JavaScriptObject jsObj){
        scClassName = "DrawPolygon";
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
     * DrawPolygon only supports the  {@link com.smartgwt.client.types.KnobType#MOVE} knob type.
     *
     * @param knobs New knobs value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setKnobs
     * 
     * 
     */
    public void setKnobs(KnobType... knobs)  throws IllegalStateException {
        setAttribute("knobs", knobs, false);
    }

    /**
     * DrawPolygon only supports the  {@link com.smartgwt.client.types.KnobType#MOVE} knob type.
     *
     * @return Current knobs value. Default value is null
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * 
     * 
     */
    public KnobType[] getKnobs()  {
        final String[] strings = getAttributeAsStringArray("knobs");
        return EnumUtil.getEnums(KnobType.values(), strings, strings == null ? null : new KnobType[strings.length]);
    }
    

    /**
     * Style of drawing the corners of the polygon.
     *
     * @param lineCap New lineCap value. Default value is "butt"
     */
    public void setLineCap(LineCap lineCap) {
        setAttribute("lineCap", lineCap == null ? null : lineCap.getValue(), true);
    }

    /**
     * Style of drawing the corners of the polygon.
     *
     * @return Current lineCap value. Default value is "butt"
     */
    public LineCap getLineCap()  {
        return EnumUtil.getEnum(LineCap.values(), getAttribute("lineCap"));
    }
    

    /**
     * Array of points of the polygon, specified in the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate
     * system}.
     *
     * @param points New points value. Default value is [[0,0], [50,50], [100,0]]
     */
    public void setPoints(Point... points) {
        setAttribute("points", points, true);
    }

    /**
     * Array of points of the polygon, specified in the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate
     * system}.
     *
     * @return Current points value. Default value is [[0,0], [50,50], [100,0]]
     */
    public Point[] getPoints()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfPoint(getAttributeAsJavaScriptObject("points"));
    }
    

    /**
     * If the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} is showing, should the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground titleLabelBackground} be created and placed behind
     * the <code>titleLabel</code>? <p> This defaults to true for {@link com.smartgwt.client.widgets.drawing.DrawSector}s and
     * shapes that are not commonly filled (e.g. {@link com.smartgwt.client.widgets.drawing.DrawLine}s).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTitleLabelBackground New showTitleLabelBackground value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowTitleLabelBackground(boolean showTitleLabelBackground)  throws IllegalStateException {
        setAttribute("showTitleLabelBackground", showTitleLabelBackground, false);
    }

    /**
     * If the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} is showing, should the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground titleLabelBackground} be created and placed behind
     * the <code>titleLabel</code>? <p> This defaults to true for {@link com.smartgwt.client.widgets.drawing.DrawSector}s and
     * shapes that are not commonly filled (e.g. {@link com.smartgwt.client.widgets.drawing.DrawLine}s).
     *
     * @return Current showTitleLabelBackground value. Default value is false
     */
    public boolean getShowTitleLabelBackground()  {
        Boolean result = getAttributeAsBoolean("showTitleLabelBackground");
        return result == null ? false : result;
    }
    

    /**
     * The mode in which the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} (if shown) is
     * rotated with this draw item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param titleRotationMode New titleRotationMode value. Default value is "withItemAlwaysUp"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setTitle
     * 
     */
    public void setTitleRotationMode(TitleRotationMode titleRotationMode)  throws IllegalStateException {
        setAttribute("titleRotationMode", titleRotationMode == null ? null : titleRotationMode.getValue(), false);
    }

    /**
     * The mode in which the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} (if shown) is
     * rotated with this draw item.
     *
     * @return Current titleRotationMode value. Default value is "withItemAlwaysUp"
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getTitle
     * 
     */
    public TitleRotationMode getTitleRotationMode()  {
        return EnumUtil.getEnum(TitleRotationMode.values(), getAttribute("titleRotationMode"));
    }
    

    // ********************* Methods ***********************

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
     * @param drawPolygonProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DrawPolygon drawPolygonProperties) /*-{
        if (drawPolygonProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DrawPolygon.@java.lang.Object::getClass()(), "setDefaultProperties", drawPolygonProperties.@java.lang.Object::getClass()());
        }
        drawPolygonProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = drawPolygonProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DrawPolygon.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DrawPolygonLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.knobs = getAttributeAsStringArray("knobs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPolygon.knobsArray:" + t.getMessage() + "\n";
        }
        try {
            s.lineCap = getAttributeAsString("lineCap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPolygon.lineCap:" + t.getMessage() + "\n";
        }
        try {
            s.points = getPoints();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPolygon.pointsArray:" + t.getMessage() + "\n";
        }
        try {
            s.showTitleLabelBackground = getAttributeAsString("showTitleLabelBackground");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPolygon.showTitleLabelBackground:" + t.getMessage() + "\n";
        }
        try {
            s.titleRotationMode = getAttributeAsString("titleRotationMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPolygon.titleRotationMode:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DrawPolygonLogicalStructure s = new DrawPolygonLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
