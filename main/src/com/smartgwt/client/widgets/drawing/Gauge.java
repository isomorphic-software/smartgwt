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
 * The Gauge widget class implements a graphical speedometer-style gauge for displaying a measurement by means of a needle
 * on a dial. The dial is divided into sectors, each having its own color and value. <P> <b>NOTE:</b> you must load the
 * Drawing {@link com.smartgwt.client.docs.LoadingOptionalModules Optional Module} before you can use Gauge.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Gauge")
public class Gauge extends DrawPane {

    public static Gauge getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Gauge(jsObj);
        } else {
            assert refInstance instanceof Gauge;
            return (Gauge)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Gauge.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Gauge.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Gauge.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Gauge.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Gauge(){
        scClassName = "Gauge";
    }

    public Gauge(JavaScriptObject jsObj){
        scClassName = "Gauge";
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
     * Color for gauge sector borders.
     *
     * @param borderColor New borderColor value. Default value is "#333333"
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setLineColor
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public Gauge setBorderColor(String borderColor)  throws IllegalStateException {
        return (Gauge)setAttribute("borderColor", borderColor, false);
    }

    /**
     * Color for gauge sector borders.
     *
     * @return Current borderColor value. Default value is "#333333"
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getLineColor
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getBorderColor()  {
        return getAttributeAsString("borderColor");
    }
    

    /**
     * Pixel width for gauge sector borders.
     *
     * @param borderWidth New borderWidth value. Default value is 1
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setLineWidth
     */
    public Gauge setBorderWidth(int borderWidth)  throws IllegalStateException {
        return (Gauge)setAttribute("borderWidth", borderWidth, false);
    }

    /**
     * Pixel width for gauge sector borders.
     *
     * @return Current borderWidth value. Default value is 1
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getLineWidth
     */
    public int getBorderWidth()  {
        return getAttributeAsInt("borderWidth");
    }
    

    /**
     * Radius in pixels of the dial.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * All DrawItems currently associated with this Gauge are destroyed and  new DrawItems are created instead.
     *
     * @param dialRadius Radius in pixels of the dial. Default value is 150
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public Gauge setDialRadius(float dialRadius) {
        return (Gauge)setAttribute("dialRadius", dialRadius, true);
    }

    /**
     * Radius in pixels of the dial.
     *
     * @return Current dialRadius value. Default value is 150
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getDialRadius()  {
        return getAttributeAsFloat("dialRadius");
    }

    /**
     * Radius in pixels of the dial.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * All DrawItems currently associated with this Gauge are destroyed and  new DrawItems are created instead.
     *
     * @param dialRadius Radius in pixels of the dial. Default value is 150
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     */
    public Gauge setDialRadius(double dialRadius) {
        return (Gauge)setAttribute("dialRadius", dialRadius, true);
    }

    /**
     * Radius in pixels of the dial.
     *
     * @return Current dialRadius value. Default value is 150
     */
    public double getDialRadiusAsDouble()  {
        return getAttributeAsDouble("dialRadius");
    }
    

    /**
     * Whether the sectors are drawn clockwise, and increasing the value causes the needle to move clockwise.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.drawing.Gauge#getDrawnClockwise drawnClockwise} property and redraws the gauge.
     *
     * @param drawnClockwise whether the sectors are drawn clockwise. Default value is true
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     */
    public Gauge setDrawnClockwise(boolean drawnClockwise) {
        return (Gauge)setAttribute("drawnClockwise", drawnClockwise, true);
    }

    /**
     * Whether the sectors are drawn clockwise, and increasing the value causes the needle to move clockwise.
     *
     * @return Current drawnClockwise value. Default value is true
     */
    public boolean getDrawnClockwise()  {
        Boolean result = getAttributeAsBoolean("drawnClockwise");
        return result == null ? true : result;
    }
    

    /**
     * Font size of sector labels. Must be at least 3.
     *
     * @param fontSize New fontSize value. Default value is 11
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#setFontSize
     */
    public Gauge setFontSize(int fontSize)  throws IllegalStateException {
        return (Gauge)setAttribute("fontSize", fontSize, false);
    }

    /**
     * Font size of sector labels. Must be at least 3.
     *
     * @return Current fontSize value. Default value is 11
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#getFontSize
     */
    public int getFontSize()  {
        return getAttributeAsInt("fontSize");
    }
    

    /**
     * The label prefix.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.drawing.Gauge#getLabelPrefix labelPrefix} property and re-creates all sector labels.
     *
     * @param labelPrefix the new label prefix. Default value is ""
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents
     */
    public Gauge setLabelPrefix(String labelPrefix) {
        return (Gauge)setAttribute("labelPrefix", labelPrefix, true);
    }

    /**
     * The label prefix.
     *
     * @return Current labelPrefix value. Default value is ""
     * @see com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents
     */
    public String getLabelPrefix()  {
        return getAttributeAsString("labelPrefix");
    }
    

    /**
     * The label suffix.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.drawing.Gauge#getLabelSuffix labelSuffix} property and re-creates all sector labels.
     *
     * @param labelSuffix the new label suffix. Default value is "%"
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents
     */
    public Gauge setLabelSuffix(String labelSuffix) {
        return (Gauge)setAttribute("labelSuffix", labelSuffix, true);
    }

    /**
     * The label suffix.
     *
     * @return Current labelSuffix value. Default value is "%"
     * @see com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents
     */
    public String getLabelSuffix()  {
        return getAttributeAsString("labelSuffix");
    }
    

    /**
     * The maximum dial value.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the maximum dial value, rescaling all sectors and the dial value.
     *
     * @param maxValue the new maximum dial value. Must be at least 1 greater than the minimum dial value. If <code>maxValue</code> is not at
     * least 1 greater than the minimum value, then it is set to <code>1 + minValue</code>. Default value is 100
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public Gauge setMaxValue(float maxValue) {
        return (Gauge)setAttribute("maxValue", maxValue, true);
    }

    /**
     * The maximum dial value.
     *
     * @return Current maxValue value. Default value is 100
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getMaxValue()  {
        return getAttributeAsFloat("maxValue");
    }

    /**
     * The maximum dial value.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the maximum dial value, rescaling all sectors and the dial value.
     *
     * @param maxValue the new maximum dial value. Must be at least 1 greater than the minimum dial value. If <code>maxValue</code> is not at
     * least 1 greater than the minimum value, then it is set to <code>1 + minValue</code>. Default value is 100
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     */
    public Gauge setMaxValue(double maxValue) {
        return (Gauge)setAttribute("maxValue", maxValue, true);
    }

    /**
     * The maximum dial value.
     *
     * @return Current maxValue value. Default value is 100
     */
    public double getMaxValueAsDouble()  {
        return getAttributeAsDouble("maxValue");
    }
    

    /**
     * The minimum dial value.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the minimum dial value, rescaling all sectors and the dial value.
     *
     * @param minValue the new minimum dial value. Must be at least 1 less than the maximum dial value. If <code>minValue</code> is not at
     * least 1 less than the maximum value, then it is set to <code>maxValue - 1</code>. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public Gauge setMinValue(float minValue) {
        return (Gauge)setAttribute("minValue", minValue, true);
    }

    /**
     * The minimum dial value.
     *
     * @return Current minValue value. Default value is 0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getMinValue()  {
        return getAttributeAsFloat("minValue");
    }

    /**
     * The minimum dial value.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the minimum dial value, rescaling all sectors and the dial value.
     *
     * @param minValue the new minimum dial value. Must be at least 1 less than the maximum dial value. If <code>minValue</code> is not at
     * least 1 less than the maximum value, then it is set to <code>maxValue - 1</code>. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     */
    public Gauge setMinValue(double minValue) {
        return (Gauge)setAttribute("minValue", minValue, true);
    }

    /**
     * The minimum dial value.
     *
     * @return Current minValue value. Default value is 0
     */
    public double getMinValueAsDouble()  {
        return getAttributeAsDouble("minValue");
    }
    

    /**
     * AutoChild representing the needle shape that points to the gauge's current value.  Default is to use a DrawTriangle.
     * <p>
     * This component is an AutoChild named "needle".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current needle value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DrawItem getNeedle() throws IllegalStateException {
        errorIfNotCreated("needle");
        return (DrawItem)DrawItem.getByJSObject(getAttributeAsJavaScriptObject("needle"));
    }
    

    /**
     * The number of major tick lines.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the number of major tick lines. <p><b>NOTE:</b> To divide the dial into <i>n</i> regions, you will need <i>n</i> + 1 ticks. For example, if the minimum value is 0 and the maximum value is 100, then to place major tick lines at 0, 10, 20, 30, ..., 90, 100, you need 11 (10 + 1) major ticks.
     *
     * @param numMajorTicks the number of major tick lines to draw. Must be either 0 or an integer greater than or equal to 2. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     */
    public Gauge setNumMajorTicks(int numMajorTicks) {
        return (Gauge)setAttribute("numMajorTicks", numMajorTicks, true);
    }

    /**
     * The number of major tick lines.
     *
     * @return Current numMajorTicks value. Default value is 0
     */
    public int getNumMajorTicks()  {
        return getAttributeAsInt("numMajorTicks");
    }
    

    /**
     * The number of minor tick lines.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the number of minor tick lines. <p><b>NOTE:</b> To divide the dial into <i>n</i> regions, you will need <i>n</i> + 1 ticks. For example, if the minimum value is 0 and the maximum value is 100, then to place minor tick lines at 0, 1, 2, 3, 4, 5, ..., 99, 100, you need 101 (100 + 1) minor ticks.
     *
     * @param numMinorTicks the number of minor tick lines to draw. Must be either 0 or an integer greater than or equal to 2. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     */
    public Gauge setNumMinorTicks(int numMinorTicks) {
        return (Gauge)setAttribute("numMinorTicks", numMinorTicks, true);
    }

    /**
     * The number of minor tick lines.
     *
     * @return Current numMinorTicks value. Default value is 0
     */
    public int getNumMinorTicks()  {
        return getAttributeAsInt("numMinorTicks");
    }
    

    /**
     * The pivot point of the needle.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * All DrawItems currently associated with this Gauge are destroyed and  new DrawItems are created instead. <P> The pivot point is set by default by choosing 1/2 of width and 70% of height of the Gauge. See {@link com.smartgwt.client.widgets.drawing.Gauge#getPivotPointHeight pivotPointHeight}
     *
     * @param pivotPoint The pivot point of the needle. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     */
    public Gauge setPivotPoint(Point pivotPoint) {
        return (Gauge)setAttribute("pivotPoint", pivotPoint == null ? null : pivotPoint.getJsObj(), true);
    }

    /**
     * The pivot point of the needle.
     *
     * @return Current pivotPoint value. Default value is null
     */
    public Point getPivotPoint()  {
        return Point.getOrCreateRef(getAttributeAsJavaScriptObject("pivotPoint"));
    }
    

    /**
     * Default height of the {@link com.smartgwt.client.widgets.drawing.Gauge#getPivotPoint pivotPoint} if no specific
     * pivotPoint is specified. <P> Can be specified as a numeric pixel value, or a String percentage value.
     *
     * @param pivotPointHeight New pivotPointHeight value. Default value is "70%"
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Gauge setPivotPointHeight(int pivotPointHeight)  throws IllegalStateException {
        return (Gauge)setAttribute("pivotPointHeight", pivotPointHeight, false);
    }

    /**
     * Default height of the {@link com.smartgwt.client.widgets.drawing.Gauge#getPivotPoint pivotPoint} if no specific
     * pivotPoint is specified. <P> Can be specified as a numeric pixel value, or a String percentage value.
     *
     * @return Current pivotPointHeight value. Default value is "70%"
     */
    public int getPivotPointHeight()  {
        return getAttributeAsInt("pivotPointHeight");
    }

    /**
     * Default height of the {@link com.smartgwt.client.widgets.drawing.Gauge#getPivotPoint pivotPoint} if no specific
     * pivotPoint is specified. <P> Can be specified as a numeric pixel value, or a String percentage value.
     *
     * @param pivotPointHeight New pivotPointHeight value. Default value is "70%"
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Gauge setPivotPointHeight(String pivotPointHeight)  throws IllegalStateException {
        return (Gauge)setAttribute("pivotPointHeight", pivotPointHeight, false);
    }

    /**
     * Default height of the {@link com.smartgwt.client.widgets.drawing.Gauge#getPivotPoint pivotPoint} if no specific
     * pivotPoint is specified. <P> Can be specified as a numeric pixel value, or a String percentage value.
     *
     * @return Current pivotPointHeight value. Default value is "70%"
     */
    public String getPivotPointHeightAsString()  {
        return getAttributeAsString("pivotPointHeight");
    }
    

    /**
     * AutoChild representing the shape drawn at the {@link com.smartgwt.client.widgets.drawing.Gauge#getPivotPoint pivotPoint}
     * (where all sectors of the gauge meet).
     * <p>
     * This component is an AutoChild named "pivotShape".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current pivotShape value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DrawItem getPivotShape() throws IllegalStateException {
        errorIfNotCreated("pivotShape");
        return (DrawItem)DrawItem.getByJSObject(getAttributeAsJavaScriptObject("pivotShape"));
    }
    

    /**
     * Array of preset fill colors used by the default implementation of {@link
     * com.smartgwt.client.widgets.drawing.Gauge#getDefaultFillColor getDefaultFillColor()} to initialize the fill color of new
     * sectors. <p>The default array of colors is: <table border="0" cellpadding="0" cellspacing="2">   <tr>     <td
     * style="background-color:#AFFFFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#AFFFFF</a></td>     <td
     * style="background-color:#008080;color:#FFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#008080</a></td>     <td
     * style="background-color:#AAAFFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#AAAFFF</a></td>     <td
     * style="background-color:#FF0000;color:#FFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#FF0000</a></td>     <td
     * style="background-color:#FFCC99;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#FFCC99</a></td>     <td
     * style="background-color:#800080;color:#FFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#800080</a></td>   </tr> </table>
     *
     * @param sectorColors New sectorColors value. Default value is [ "#AFFFFF", "#008080", "#AAAFFF", "#FF0000", "#FFCC99", "#800080" ]
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setFillColor
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public Gauge setSectorColors(String... sectorColors)  throws IllegalStateException {
        return (Gauge)setAttribute("sectorColors", sectorColors, false);
    }

    /**
     * Array of preset fill colors used by the default implementation of {@link
     * com.smartgwt.client.widgets.drawing.Gauge#getDefaultFillColor getDefaultFillColor()} to initialize the fill color of new
     * sectors. <p>The default array of colors is: <table border="0" cellpadding="0" cellspacing="2">   <tr>     <td
     * style="background-color:#AFFFFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#AFFFFF</a></td>     <td
     * style="background-color:#008080;color:#FFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#008080</a></td>     <td
     * style="background-color:#AAAFFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#AAAFFF</a></td>     <td
     * style="background-color:#FF0000;color:#FFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#FF0000</a></td>     <td
     * style="background-color:#FFCC99;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#FFCC99</a></td>     <td
     * style="background-color:#800080;color:#FFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#800080</a></td>   </tr> </table>
     *
     * @return Current sectorColors value. Default value is [ "#AFFFFF", "#008080", "#AAAFFF", "#FF0000", "#FFCC99", "#800080" ]
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getFillColor
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String[] getSectorColors()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("sectorColors"));
    }
    

    /**
     * The GaugeSectors contained in this Gauge.   If this this property is not specified, the gauge will be created with a
     * default sector filling the gauge.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the sectors for this gauge.
     *
     * @param sectors the sectors to show on the gauge. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     */
    public Gauge setSectors(GaugeSector... sectors) {
        return (Gauge)setAttribute("sectors", sectors, true);
    }

    /**
     * The GaugeSectors contained in this Gauge.   If this this property is not specified, the gauge will be created with a
     * default sector filling the gauge.
     *
     * @return Current sectors value. Default value is null
     */
    public GaugeSector[] getSectors()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfGaugeSector(getAttributeAsJavaScriptObject("sectors"));
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * MultiAutoChild representing the sectors drawn to show different segments of the gauge.
     *
     * @return null
     */
    public DrawSector getSectorShape()  {
        return null;
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * MultiAutoChild representing the tick marks drawn along the circumference of the gauge. Default is to use DrawLine.
     *
     * @return null
     */
    public DrawItem getTickLine()  {
        return null;
    }
    

    /**
     * The current value on the dial.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the value on the dial that the needle is displaying.
     *
     * @param value the new dial value. Must be between {@link com.smartgwt.client.widgets.drawing.Gauge#getMinValue minValue} and {@link
     * com.smartgwt.client.widgets.drawing.Gauge#getMaxValue maxValue}. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public Gauge setValue(float value) {
        return (Gauge)setAttribute("value", value, true);
    }

    /**
     * The current value on the dial.
     *
     * @return Current value value. Default value is 0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getValue()  {
        return getAttributeAsFloat("value");
    }

    /**
     * The current value on the dial.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the value on the dial that the needle is displaying.
     *
     * @param value the new dial value. Must be between {@link com.smartgwt.client.widgets.drawing.Gauge#getMinValue minValue} and {@link
     * com.smartgwt.client.widgets.drawing.Gauge#getMaxValue maxValue}. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.Gauge Gauge} instance, for chaining setter calls
     */
    public Gauge setValue(double value) {
        return (Gauge)setAttribute("value", value, true);
    }

    /**
     * The current value on the dial.
     *
     * @return Current value value. Default value is 0
     */
    public double getValueAsDouble()  {
        return getAttributeAsDouble("value");
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * MultiAutoChild representing the labels used to different data points on the gauge.
     *
     * @return null
     */
    public DrawLabel getValueLabel()  {
        return null;
    }
    

    // ********************* Methods ***********************
	/**
     * Adds a new sector.
     * @param newSector the new GaugeSector or the new sector's value. This is formatted with {@link
     * com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents formatLabelContents()} to get its label.
     *
     * @return the index of the newly-added sector.
     */
    public native int addSector(GaugeSector newSector) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addSector", "GaugeSector");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addSector(newSector.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;

	/**
     * Adds a new sector.
     * @param newSector the new GaugeSector or the new sector's value. This is formatted with {@link
     * com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents formatLabelContents()} to get its label.
     *
     * @return the index of the newly-added sector.
     */
    public native int addSector(double newSector) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addSector", "double");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.addSector(newSector);
        return ret;
    }-*/;

	/**
     * Gets the number of sectors.
     *
     * @return the number of sectors on this gauge.
     */
    public native int getNumSectors() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getNumSectors", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNumSectors();
        return ret;
    }-*/;

	/**
     * Gets the fill color of the sector at index <code>sectorIndex</code>.
     * @param sectorIndex index of the target sector.
     *
     * @return the fill color of the sector at <code>sectorIndex</code>.
     * See {@link com.smartgwt.client.docs.CSSColor CSSColor}
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getFillColor
     */
    public native String getSectorFillColor(int sectorIndex) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSectorFillColor", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectorFillColor(sectorIndex);
        return ret;
    }-*/;

	/**
     * Gets the label contents of the label for the sector at sectorIndex.
     * @param sectorIndex index of the target sector.
     *
     * @return the label contents of the sector's label.
     */
    public native String getSectorLabelContents(int sectorIndex) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSectorLabelContents", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectorLabelContents(sectorIndex);
        return ret;
    }-*/;

	/**
     * Gets the value of the sector at <code>sectorIndex</code>.
     * @param sectorIndex index of the target sector.
     *
     * @return the value of the sector at <code>sectorIndex</code>.
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getSectorValue(int sectorIndex) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSectorValue", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectorValue(sectorIndex);
        return ret;
    }-*/;

	/**
     * Gets the value of the sector at <code>sectorIndex</code>.
     * @param sectorIndex index of the target sector.
     *
     * @return the value of the sector at <code>sectorIndex</code>.
     */
    public native double getSectorValueAsDouble(int sectorIndex) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSectorValueAsDouble", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectorValue(sectorIndex);
        return ret;
    }-*/;

	/**
     * Resets the contents of all labels. This involves calling {@link
     * com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents formatLabelContents()} to get the label contents for each
     * corresponding value and repositioning the label.
     */
    public native void reformatLabelContents() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "reformatLabelContents", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reformatLabelContents();
    }-*/;

	/**
     * Removes the sector at sectorIndex. <p> <b>NOTE:</b> There must always be one sector and it is not possible to remove the
     * sole remaining sector. Calling this method to attempt to remove the sole remaining sector is a no-op.
     * @param sectorIndex the index of the sector to remove.
     */
    public native void removeSector(int sectorIndex) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeSector", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeSector(sectorIndex);
    }-*/;

	/**
     * Sets the fill color of the sector at <code>sectorIndex</code>.
     * @param sectorIndex index of the target sector.
     * @param fillColor the new fill color.
     * See {@link com.smartgwt.client.docs.CSSColor CSSColor}
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setFillColor
     */
    public native void setSectorFillColor(int sectorIndex, String fillColor) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setSectorFillColor", "int,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSectorFillColor(sectorIndex, fillColor);
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
     * @param gaugeProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Gauge gaugeProperties) /*-{
        if (gaugeProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Gauge.@java.lang.Object::getClass()(), "setDefaultProperties", gaugeProperties.@java.lang.Object::getClass()());
        }
        gaugeProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = gaugeProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Gauge.addProperties(properties);
    }-*/;

    // ***********************************************************


    @Override
    protected void onInit () {
        super.onInit();
        onInit_Gauge();
    }

    private native void onInit_Gauge() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();

        self.__formatLabelContents = self.formatLabelContents;
        self.formatLabelContents = $entry(function (value) {
            var jObj = this.__ref;
            return jObj.@com.smartgwt.client.widgets.drawing.Gauge::formatLabelContents(F)(value);
        });

        self.__getDefaultFillColor = self.getDefaultFillColor;
        self.getDefaultFillColor = $entry(function (sectorIndex) {
            var jObj = this.__ref;
            return jObj.@com.smartgwt.client.widgets.drawing.Gauge::getDefaultFillColor(I)(sectorIndex);
        });

        var config = this.@com.smartgwt.client.widgets.BaseWidget::config || {};
        for (var i = 0; i < self.sectors.length; i++) {
            var sector = config.sectors && config.sectors[i];
            if (sector && sector.fillColor != null) continue;
            self.sectors[i].fillColor = this.@com.smartgwt.client.widgets.drawing.Gauge::getDefaultFillColor(I)(i);
        }
    }-*/;

    /**
     * Formats a value as a string to be used as the contents of a {@link com.smartgwt.client.widgets.drawing.DrawLabel}.  The default implementation prepends
     * {@link com.smartgwt.client.widgets.drawing.Gauge#getLabelPrefix labelPrefix} and appends
     * {@link com.smartgwt.client.widgets.drawing.Gauge#getLabelSuffix labelSuffix} to
     * <code>value</code>.
     *
     * <p><b>NOTE:</b> This is an override point. If a subclass overrides this, then whenever it changes the way that values are
     * formatted, it should call {@link com.smartgwt.client.widgets.drawing.Gauge#reformatLabelContents Gauge.reformatLabelContents}.
     *
     * @param value the value to format.
     * @return label contents.
     */
    protected native String formatLabelContents(float value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.__formatLabelContents(value);
    }-*/;

    /**
     * Gets the default fill color for the sector at index <code>sectorIndex</code>.
     * The default implementation cycles through {@link com.smartgwt.client.widgets.drawing.Gauge#getSectorColors sectorColors}
     * using modular arithmetic.
     *
     * <p>Note: This is an override point.
     *
     * @param sectorIndex index of the target sector.
     * @return a fill color.
     */
    protected native String getDefaultFillColor(int sectorIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.__getDefaultFillColor(sectorIndex);
    }-*/;

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(GaugeLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.borderColor = getAttributeAsString("borderColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.borderColor:" + t.getMessage() + "\n";
        }
        try {
            s.borderWidth = getAttributeAsString("borderWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.borderWidth:" + t.getMessage() + "\n";
        }
        try {
            s.drawnClockwise = getAttributeAsString("drawnClockwise");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.drawnClockwise:" + t.getMessage() + "\n";
        }
        try {
            s.fontSize = getAttributeAsString("fontSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.fontSize:" + t.getMessage() + "\n";
        }
        try {
            s.labelPrefix = getAttributeAsString("labelPrefix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.labelPrefix:" + t.getMessage() + "\n";
        }
        try {
            s.labelSuffix = getAttributeAsString("labelSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.labelSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.numMajorTicks = getAttributeAsString("numMajorTicks");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.numMajorTicks:" + t.getMessage() + "\n";
        }
        try {
            s.numMinorTicks = getAttributeAsString("numMinorTicks");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.numMinorTicks:" + t.getMessage() + "\n";
        }
        try {
            s.pivotPoint = getPivotPoint();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.pivotPoint:" + t.getMessage() + "\n";
        }
        try {
            s.pivotPointHeightAsString = getAttributeAsString("pivotPointHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.pivotPointHeightAsString:" + t.getMessage() + "\n";
        }
        try {
            s.sectorColors = getAttributeAsStringArray("sectorColors");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.sectorColorsArray:" + t.getMessage() + "\n";
        }
        try {
            s.sectors = getSectors();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.sectorsArray:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        GaugeLogicalStructure s = new GaugeLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
