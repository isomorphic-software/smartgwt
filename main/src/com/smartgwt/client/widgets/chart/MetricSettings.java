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
 
package com.smartgwt.client.widgets.chart;


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


/**
 * Defines a set of properties that are applicable to {@link
 * com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics additional value axes} of a {@link
 * com.smartgwt.client.widgets.chart.FacetChart}. <p> These properties behave identically to the same-named properties of
 * FacetChart.  Two exceptions are the properties {@link
 * com.smartgwt.client.widgets.chart.MetricSettings#getGradationLineProperties gradationLineProperties} and {@link
 * com.smartgwt.client.widgets.chart.MetricSettings#getGradationZeroLineProperties gradationZeroLineProperties} because
 * they are used to draw tick marks along an extra value axis instead of lines through the chart rectangle.  Also the
 * default behavior of the {@link com.smartgwt.client.widgets.chart.MetricSettings#getDataColors dataColors} property is
 * different, in that the default is to use unused colors from, and in the order of, the  {@link
 * com.smartgwt.client.widgets.chart.FacetChart#getDataColors main data colors array}. <p> The extra value axes that are
 * not positioned directly adjacent to the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowChartRect chart
 * rect.} of the FacetChart may additionally have an axis line to connect the gradation tick marks.  Whether to draw this
 * line is controlled by the {@link com.smartgwt.client.widgets.chart.MetricSettings#getShowAxisLine showAxisLine}
 * property, and the properties of the line are specified using {@link
 * com.smartgwt.client.widgets.chart.MetricSettings#getAxisLineProperties axisLineProperties}.  The default is to draw the
 * axis lines whenever the chart rect. is drawn and to draw the line using the same properties as the lines of the chart
 * rect. (for example, lineColor and lineWidth). <p> The extra value axis charts may be  {@link
 * com.smartgwt.client.widgets.chart.MetricSettings#getMultiFacet single- or multi-facet} charts.  If the underlying {@link
 * com.smartgwt.client.widgets.chart.FacetChart#getData data} is multi-facet then the extra value axes may use the facet
 * whose values are labelled on the data axis or the facet used to create the legend (the first and second facets,
 * respectively).  Both types of charts vary the first facet to get a data series to plot.  Multi-facet charts also vary
 * the second facet, but single-facet charts keep the second facet fixed at a constant {@link
 * com.smartgwt.client.widgets.cube.FacetValue}. <p> The exact facet value to use for the second facet is specified using
 * the {@link com.smartgwt.client.widgets.chart.MetricSettings#getFixedFacetValue fixedFacetValue} property.
 */
@BeanFactory.FrameworkClass
public class MetricSettings extends DataClass {

    public static MetricSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new MetricSettings(jsObj);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MetricSettings.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.MetricSettings.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MetricSettings.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.MetricSettings.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public MetricSettings(){
        
    }

    public MetricSettings(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Properties for the axis line drawn if this extra value axis is not positioned directly adjacent to the chart rect.  The
     * default is to match the {@link com.smartgwt.client.widgets.drawing.DrawItem#getLineCap lineCap}, {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getLineColor lineColor}, {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getLineOpacity lineOpacity}, {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getLinePattern linePattern}, and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getLineWidth lineWidth} of the FacetChart's {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getChartRectProperties chart rect.} for each axis line.
     *
     * @param axisLineProperties New axisLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public MetricSettings setAxisLineProperties(DrawLine axisLineProperties) {
        if (axisLineProperties != null) {
            if (axisLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(MetricSettings.class, "setAxisLineProperties", "DrawLine");
            }                                                                       
            axisLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = axisLineProperties == null ? null : axisLineProperties.getConfig();
        return (MetricSettings)setAttribute("axisLineProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties for the axis line drawn if this extra value axis is not positioned directly adjacent to the chart rect.  The
     * default is to match the {@link com.smartgwt.client.widgets.drawing.DrawItem#getLineCap lineCap}, {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getLineColor lineColor}, {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getLineOpacity lineOpacity}, {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getLinePattern linePattern}, and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getLineWidth lineWidth} of the FacetChart's {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getChartRectProperties chart rect.} for each axis line.
     *
     * @return Current axisLineProperties value. Default value is null
     */
    public DrawLine getAxisLineProperties()  {
        DrawLine properties = new DrawLine();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("axisLineProperties"));
        return properties;
    }
    

    /**
     * Same as {@link com.smartgwt.client.widgets.chart.FacetChart#getAxisStartValue FacetChart.axisStartValue} but affects
     * only one metric.
     *
     * @param axisStartValue New axisStartValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setAxisStartValue(Double axisStartValue) {
        return (MetricSettings)setAttribute("axisStartValue", axisStartValue);
    }

    /**
     * Same as {@link com.smartgwt.client.widgets.chart.FacetChart#getAxisStartValue FacetChart.axisStartValue} but affects
     * only one metric.
     *
     * @return Current axisStartValue value. Default value is null
     */
    public Double getAxisStartValue()  {
        return getAttributeAsDouble("axisStartValue");
    }
    

    /**
     * See {@link com.smartgwt.client.types.ChartType} for a list of known types - Column, Bar, Line, Pie, Doughnut, Area,
     * Radar, and Histogram charts are supported.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change the current {@link com.smartgwt.client.types.ChartType chartType}. Will redraw the chart if drawn.  Will use default settings for the new chart type for {@link com.smartgwt.client.widgets.chart.MetricSettings#getStacked stacked} and {@link com.smartgwt.client.widgets.chart.MetricSettings#getFilled filled} if those values are null. <p> Note that for {@link com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics multi-axis} charts this method changes the <code>chartType</code> for the main value axis only.
     *
     * @param chartType new chart type. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setChartType(ChartType chartType) {
        return (MetricSettings)setAttribute("chartType", chartType == null ? null : chartType.getValue());
    }

    /**
     * See {@link com.smartgwt.client.types.ChartType} for a list of known types - Column, Bar, Line, Pie, Doughnut, Area,
     * Radar, and Histogram charts are supported.
     *
     * @return Current chartType value. Default value is null
     */
    public ChartType getChartType()  {
        return EnumUtil.getEnum(ChartType.values(), getAttribute("chartType"));
    }
    

    /**
     * An array of colors to use for a series of visual elements representing data (eg columns, bars, pie slices), any of which
     * may be adjacent to any other. <P> Colors must be in the format of a leading hash (#) plus 6 hexadecimal digits, for
     * example,  "#FFFFFF" is white, "#FF0000" is pure red.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.MetricSettings#getDataColors dataColors}.
     *
     * @param dataColors New set of data colors. Default value is see below
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public MetricSettings setDataColors(String... dataColors) {
        return (MetricSettings)setAttribute("dataColors", dataColors);
    }

    /**
     * An array of colors to use for a series of visual elements representing data (eg columns, bars, pie slices), any of which
     * may be adjacent to any other. <P> Colors must be in the format of a leading hash (#) plus 6 hexadecimal digits, for
     * example,  "#FFFFFF" is white, "#FF0000" is pure red.
     *
     * @return Current dataColors value. Default value is see below
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String[] getDataColors()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("dataColors"));
    }
    
    

    /**
     * Properties for lines that show data (as opposed to gradations or borders around the data area).
     *
     * @param dataLineProperties New dataLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public MetricSettings setDataLineProperties(DrawLine dataLineProperties) {
        if (dataLineProperties != null) {
            if (dataLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(MetricSettings.class, "setDataLineProperties", "DrawLine");
            }                                                                       
            dataLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = dataLineProperties == null ? null : dataLineProperties.getConfig();
        return (MetricSettings)setAttribute("dataLineProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties for lines that show data (as opposed to gradations or borders around the data area).
     *
     * @return Current dataLineProperties value. Default value is null
     */
    public DrawLine getDataLineProperties()  {
        DrawLine properties = new DrawLine();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("dataLineProperties"));
        return properties;
    }
    

    /**
     * Properties for lines that outline a data shape (in filled charts such as area or radar charts).
     *
     * @param dataOutlineProperties New dataOutlineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public MetricSettings setDataOutlineProperties(DrawItem dataOutlineProperties) {
        if (dataOutlineProperties != null) {
            if (dataOutlineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(MetricSettings.class, "setDataOutlineProperties", "DrawItem");
            }                                                                       
            dataOutlineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = dataOutlineProperties == null ? null : dataOutlineProperties.getConfig();
        return (MetricSettings)setAttribute("dataOutlineProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties for lines that outline a data shape (in filled charts such as area or radar charts).
     *
     * @return Current dataOutlineProperties value. Default value is null
     */
    public DrawItem getDataOutlineProperties()  {
        DrawItem properties = new DrawItem();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("dataOutlineProperties"));
        return properties;
    }
    

    /**
     * Common properties to apply for all data points (see {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getShowDataPoints showDataPoints}).
     *
     * @param dataPointProperties New dataPointProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public MetricSettings setDataPointProperties(DrawItem dataPointProperties) {
        if (dataPointProperties != null) {
            if (dataPointProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(MetricSettings.class, "setDataPointProperties", "DrawItem");
            }                                                                       
            dataPointProperties.setConfigOnly(true);
        }
        JavaScriptObject config = dataPointProperties == null ? null : dataPointProperties.getConfig();
        return (MetricSettings)setAttribute("dataPointProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Common properties to apply for all data points (see {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getShowDataPoints showDataPoints}).
     *
     * @return Current dataPointProperties value. Default value is null
     */
    public DrawItem getDataPointProperties()  {
        DrawItem properties = new DrawItem();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("dataPointProperties"));
        return properties;
    }
    

    /**
     * Size in pixels for data points drawn for line, area, radar and other chart types.
     *
     * @param dataPointSize New dataPointSize value. Default value is 6
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setDataPointSize(int dataPointSize) {
        return (MetricSettings)setAttribute("dataPointSize", dataPointSize);
    }

    /**
     * Size in pixels for data points drawn for line, area, radar and other chart types.
     *
     * @return Current dataPointSize value. Default value is 6
     */
    public int getDataPointSize()  {
        return getAttributeAsInt("dataPointSize");
    }
    

    /**
     * Properties for data shapes (filled areas in area or radar charts).
     *
     * @param dataShapeProperties New dataShapeProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public MetricSettings setDataShapeProperties(DrawPath dataShapeProperties) {
        if (dataShapeProperties != null) {
            if (dataShapeProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(MetricSettings.class, "setDataShapeProperties", "DrawPath");
            }                                                                       
            dataShapeProperties.setConfigOnly(true);
        }
        JavaScriptObject config = dataShapeProperties == null ? null : dataShapeProperties.getConfig();
        return (MetricSettings)setAttribute("dataShapeProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties for data shapes (filled areas in area or radar charts).
     *
     * @return Current dataShapeProperties value. Default value is null
     */
    public DrawPath getDataShapeProperties()  {
        DrawPath properties = new DrawPath();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("dataShapeProperties"));
        return properties;
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.chart.FacetChart#getDecimalPrecision FacetChart.decimalPrecision} used to render
     * the numeric labels of this metric axis.
     *
     * @param decimalPrecision New decimalPrecision value. Default value is 2
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setDecimalPrecision(int decimalPrecision) {
        return (MetricSettings)setAttribute("decimalPrecision", decimalPrecision);
    }

    /**
     * The {@link com.smartgwt.client.widgets.chart.FacetChart#getDecimalPrecision FacetChart.decimalPrecision} used to render
     * the numeric labels of this metric axis.
     *
     * @return Current decimalPrecision value. Default value is 2
     */
    public int getDecimalPrecision()  {
        return getAttributeAsInt("decimalPrecision");
    }
    

    /**
     * Whether shapes are filled, for example, whether a multi-series line chart appears as a stack of filled regions as
     * opposed to just multiple lines. <P> If unset, fills will be automatically used when there are multiple facets and
     * stacking is active (so Line and Radar charts will show stacked regions).   <P> You can explicitly set filled:false to
     * create multi-facet Line or Radar charts where translucent regions overlap, or filled:true to fill in a single-facet Line
     * or Radar chart.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change {@link com.smartgwt.client.widgets.chart.MetricSettings#getFilled filled}. Use null to apply a default value for the current {@link com.smartgwt.client.types.ChartType chartType}.
     *
     * @param filled new value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setFilled(Boolean filled) {
        return (MetricSettings)setAttribute("filled", filled);
    }

    /**
     * Whether shapes are filled, for example, whether a multi-series line chart appears as a stack of filled regions as
     * opposed to just multiple lines. <P> If unset, fills will be automatically used when there are multiple facets and
     * stacking is active (so Line and Radar charts will show stacked regions).   <P> You can explicitly set filled:false to
     * create multi-facet Line or Radar charts where translucent regions overlap, or filled:true to fill in a single-facet Line
     * or Radar chart.
     *
     * @return Current filled value. Default value is null
     */
    public Boolean getFilled()  {
        return getAttributeAsBoolean("filled", true);
    }
    

    /**
     * For a {@link com.smartgwt.client.widgets.chart.MetricSettings#getMultiFacet single-facet} chart of an extra value axis,
     * this property provides a constant facet value for the second facet.  By varying the value of the other facet in
     * multi-facet data, the chart obtains the series of values to plot.  The default facet value is the first facet value of
     * the second facet.
     *
     * @param fixedFacetValue New fixedFacetValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setFixedFacetValue(String fixedFacetValue) {
        return (MetricSettings)setAttribute("fixedFacetValue", fixedFacetValue);
    }

    /**
     * For a {@link com.smartgwt.client.widgets.chart.MetricSettings#getMultiFacet single-facet} chart of an extra value axis,
     * this property provides a constant facet value for the second facet.  By varying the value of the other facet in
     * multi-facet data, the chart obtains the series of values to plot.  The default facet value is the first facet value of
     * the second facet.
     *
     * @return Current fixedFacetValue value. Default value is null
     */
    public String getFixedFacetValue()  {
        return getAttributeAsString("fixedFacetValue");
    }

    /**
     * For a {@link com.smartgwt.client.widgets.chart.MetricSettings#getMultiFacet single-facet} chart of an extra value axis,
     * this property provides a constant facet value for the second facet.  By varying the value of the other facet in
     * multi-facet data, the chart obtains the series of values to plot.  The default facet value is the first facet value of
     * the second facet.
     *
     * @param fixedFacetValue New fixedFacetValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setFixedFacetValue(Integer fixedFacetValue) {
        return (MetricSettings)setAttribute("fixedFacetValue", fixedFacetValue);
    }
    

    /**
     * Properties for gradation labels
     *
     * @param gradationLabelProperties New gradationLabelProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public MetricSettings setGradationLabelProperties(DrawLabel gradationLabelProperties) {
        if (gradationLabelProperties != null) {
            if (gradationLabelProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(MetricSettings.class, "setGradationLabelProperties", "DrawLabel");
            }                                                                       
            gradationLabelProperties.setConfigOnly(true);
        }
        JavaScriptObject config = gradationLabelProperties == null ? null : gradationLabelProperties.getConfig();
        return (MetricSettings)setAttribute("gradationLabelProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties for gradation labels
     *
     * @return Current gradationLabelProperties value. Default value is null
     */
    public DrawLabel getGradationLabelProperties()  {
        DrawLabel properties = new DrawLabel();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("gradationLabelProperties"));
        return properties;
    }
    

    /**
     * Properties for gradation lines
     *
     * @param gradationLineProperties New gradationLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public MetricSettings setGradationLineProperties(DrawLine gradationLineProperties) {
        if (gradationLineProperties != null) {
            if (gradationLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(MetricSettings.class, "setGradationLineProperties", "DrawLine");
            }                                                                       
            gradationLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = gradationLineProperties == null ? null : gradationLineProperties.getConfig();
        return (MetricSettings)setAttribute("gradationLineProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties for gradation lines
     *
     * @return Current gradationLineProperties value. Default value is null
     */
    public DrawLine getGradationLineProperties()  {
        DrawLine properties = new DrawLine();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("gradationLineProperties"));
        return properties;
    }
    

    /**
     * Properties for the gradation line drawn for zero (slightly thicker by default).
     *
     * @param gradationZeroLineProperties New gradationZeroLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public MetricSettings setGradationZeroLineProperties(DrawLine gradationZeroLineProperties) {
        if (gradationZeroLineProperties != null) {
            if (gradationZeroLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(MetricSettings.class, "setGradationZeroLineProperties", "DrawLine");
            }                                                                       
            gradationZeroLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = gradationZeroLineProperties == null ? null : gradationZeroLineProperties.getConfig();
        return (MetricSettings)setAttribute("gradationZeroLineProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties for the gradation line drawn for zero (slightly thicker by default).
     *
     * @return Current gradationZeroLineProperties value. Default value is null
     */
    public DrawLine getGradationZeroLineProperties()  {
        DrawLine properties = new DrawLine();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("gradationZeroLineProperties"));
        return properties;
    }
    

    /**
     * For {@link com.smartgwt.client.widgets.chart.MetricSettings#getMultiFacet single-facet} charts embedded in a multi-facet
     * main chart, the <code>legendLabel</code> defines the text of the legend label for this chart. The default text is the
     * {@link com.smartgwt.client.widgets.cube.FacetValue#getTitle title} of the metric facet value of this value axis
     * concatenated with the {@link com.smartgwt.client.widgets.cube.FacetValue#getTitle title} of the {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getFixedFacetValue fixed facet value} in parentheses.  Set the
     * <code>legendLabel</code> to provide custom text for the legend label.
     *
     * @param legendLabel New legendLabel value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setLegendLabel(String legendLabel) {
        return (MetricSettings)setAttribute("legendLabel", legendLabel);
    }

    /**
     * For {@link com.smartgwt.client.widgets.chart.MetricSettings#getMultiFacet single-facet} charts embedded in a multi-facet
     * main chart, the <code>legendLabel</code> defines the text of the legend label for this chart. The default text is the
     * {@link com.smartgwt.client.widgets.cube.FacetValue#getTitle title} of the metric facet value of this value axis
     * concatenated with the {@link com.smartgwt.client.widgets.cube.FacetValue#getTitle title} of the {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getFixedFacetValue fixed facet value} in parentheses.  Set the
     * <code>legendLabel</code> to provide custom text for the legend label.
     *
     * @return Current legendLabel value. Default value is null
     */
    public String getLegendLabel()  {
        return getAttributeAsString("legendLabel");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.chart.MetricSettings#getUseLogGradations useLogGradations}, base value for
     * logarithmic gradation lines.  Gradation lines will be shown at every power of this value plus intervening values
     * specified by {@link com.smartgwt.client.widgets.chart.MetricSettings#getLogGradations logGradations}.
     *
     * @param logBase New logBase value. Default value is 10
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setLogBase(int logBase) {
        return (MetricSettings)setAttribute("logBase", logBase);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.MetricSettings#getUseLogGradations useLogGradations}, base value for
     * logarithmic gradation lines.  Gradation lines will be shown at every power of this value plus intervening values
     * specified by {@link com.smartgwt.client.widgets.chart.MetricSettings#getLogGradations logGradations}.
     *
     * @return Current logBase value. Default value is 10
     */
    public int getLogBase()  {
        return getAttributeAsInt("logBase");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.chart.MetricSettings#getUseLogGradations useLogGradations} is set, gradation
     * lines to show in between powers,
     * expressed as a series of integer or float values between 1 and {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getLogBase logBase}.
     *  <P>
     *  Some common possibilities (for base 10):
     *  <pre>
     *     [ 1 ] // show only orders of magnitude (0.1, 1, 10, 100, etc)
     *     [ 1, 5 ] // show only orders of magnitude plus halfway mark
     *     [ 1, 2, 4, 8 ] // show powers of 2 between orders
     *     [ 1, 2.5, 5, 7.5 ] // show quarters
     *  </pre>
     *  Or base 2:
     *  <pre>
     *     [ 1 ]
     *     [ 1, 1.5 ]
     *  </pre>
     *
     * @param logGradations New logGradations value. Default value is [ 1,2,4,6,8 ]
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setLogGradations(float... logGradations) {
        return (MetricSettings)setAttribute("logGradations", logGradations);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.MetricSettings#getUseLogGradations useLogGradations} is set, gradation
     * lines to show in between powers,
     * expressed as a series of integer or float values between 1 and {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getLogBase logBase}.
     *  <P>
     *  Some common possibilities (for base 10):
     *  <pre>
     *     [ 1 ] // show only orders of magnitude (0.1, 1, 10, 100, etc)
     *     [ 1, 5 ] // show only orders of magnitude plus halfway mark
     *     [ 1, 2, 4, 8 ] // show powers of 2 between orders
     *     [ 1, 2.5, 5, 7.5 ] // show quarters
     *  </pre>
     *  Or base 2:
     *  <pre>
     *     [ 1 ]
     *     [ 1, 1.5 ]
     *  </pre>
     *
     * @return Current logGradations value. Default value is [ 1,2,4,6,8 ]
     */
    public float[] getLogGradations()  {
        return com.smartgwt.client.util.ConvertTo.arrayOffloat(getAttributeAsJavaScriptObject("logGradations"));
    }
    

    /**
     * Whether to use logarithmic scaling for values. <P> Logarithmic scale charts show an equivalent percentage increase as
     * equivalent distance on the chart.  That is, 10 and 100 are the same distance apart as 100 and 1000 (each being a 10
     * times or 1000% increase).
     *
     * @param logScale New logScale value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setLogScale(Boolean logScale) {
        return (MetricSettings)setAttribute("logScale", logScale);
    }

    /**
     * Whether to use logarithmic scaling for values. <P> Logarithmic scale charts show an equivalent percentage increase as
     * equivalent distance on the chart.  That is, 10 and 100 are the same distance apart as 100 and 1000 (each being a 10
     * times or 1000% increase).
     *
     * @return Current logScale value. Default value is false
     */
    public Boolean getLogScale()  {
        Boolean result = getAttributeAsBoolean("logScale", true);
        return result == null ? false : result;
    }
    

    /**
     * When this property is set to the metric of another MetricSettings object, the extra value axis and chart corresponding
     * to these settings will use the same scale for the gradations as the extra value axis and chart of the other
     * MetricSettings object.  The value of <code>matchGradations</code> can only be one of the metrics of the metric facet
     * whose values will be displayed by the chart.
     *
     * @param matchGradations New matchGradations value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.chart.FacetChart#setExtraAxisMetrics
     */
    public MetricSettings setMatchGradations(String matchGradations) {
        return (MetricSettings)setAttribute("matchGradations", matchGradations);
    }

    /**
     * When this property is set to the metric of another MetricSettings object, the extra value axis and chart corresponding
     * to these settings will use the same scale for the gradations as the extra value axis and chart of the other
     * MetricSettings object.  The value of <code>matchGradations</code> can only be one of the metrics of the metric facet
     * whose values will be displayed by the chart.
     *
     * @return Current matchGradations value. Default value is null
     * @see com.smartgwt.client.widgets.chart.FacetChart#getExtraAxisMetrics
     */
    public String getMatchGradations()  {
        return getAttributeAsString("matchGradations");
    }
    

    /**
     * Same as {@link com.smartgwt.client.widgets.chart.FacetChart#getMinDataSpreadPercent FacetChart.minDataSpreadPercent} but
     * affects only one metric.  Default of null means that the chart-wide setting <code>facetChart.minDataSpreadPercent</code>
     * will be used.
     *
     * @param minDataSpreadPercent New minDataSpreadPercent value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setMinDataSpreadPercent(Integer minDataSpreadPercent) {
        return (MetricSettings)setAttribute("minDataSpreadPercent", minDataSpreadPercent);
    }

    /**
     * Same as {@link com.smartgwt.client.widgets.chart.FacetChart#getMinDataSpreadPercent FacetChart.minDataSpreadPercent} but
     * affects only one metric.  Default of null means that the chart-wide setting <code>facetChart.minDataSpreadPercent</code>
     * will be used.
     *
     * @return Current minDataSpreadPercent value. Default value is null
     */
    public Integer getMinDataSpreadPercent()  {
        return getAttributeAsInt("minDataSpreadPercent");
    }
    

    /**
     * Whether this extra value axis plots values while varying the facet values of just the first facet (single-facet) or both
     * first and second facets (multi-facet).
     *
     * @param multiFacet New multiFacet value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setMultiFacet(Boolean multiFacet) {
        return (MetricSettings)setAttribute("multiFacet", multiFacet);
    }

    /**
     * Whether this extra value axis plots values while varying the facet values of just the first facet (single-facet) or both
     * first and second facets (multi-facet).
     *
     * @return Current multiFacet value. Default value is true
     */
    public Boolean getMultiFacet()  {
        Boolean result = getAttributeAsBoolean("multiFacet", true);
        return result == null ? true : result;
    }
    

    /**
     * For multi-facet charts, render data values as a proportion of the sum of all data values that have the same label. <p>
     * Gradation labels will be switched to show percentage instead of absolute values. <p> This setting is valid only for
     * Column, Bar, Area and Radar chart types and only in {@link com.smartgwt.client.widgets.chart.MetricSettings#getStacked
     * stacked} mode.  Stacked columns will be as tall as the chart rect and stacked bars will be as wide as the chart rect. 
     * Area and Radar charts will be completely filled except for facet values where all values are 0.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.chart.MetricSettings#getProportional proportional}.
     *
     * @param proportional Whether the chart should now use proportional mode. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#multiSeriesChart" target="examples">Multi-Series Chart Example</a>
     */
    public MetricSettings setProportional(Boolean proportional) {
        return (MetricSettings)setAttribute("proportional", proportional);
    }

    /**
     * For multi-facet charts, render data values as a proportion of the sum of all data values that have the same label. <p>
     * Gradation labels will be switched to show percentage instead of absolute values. <p> This setting is valid only for
     * Column, Bar, Area and Radar chart types and only in {@link com.smartgwt.client.widgets.chart.MetricSettings#getStacked
     * stacked} mode.  Stacked columns will be as tall as the chart rect and stacked bars will be as wide as the chart rect. 
     * Area and Radar charts will be completely filled except for facet values where all values are 0.
     *
     * @return Current proportional value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#multiSeriesChart" target="examples">Multi-Series Chart Example</a>
     */
    public Boolean getProportional()  {
        return getAttributeAsBoolean("proportional", true);
    }
    

    /**
     * Default title for the value axis label when the chart is in {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getProportional proportional rendering mode}.  This title will be used
     * unless the {@link com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet} defines a {@link
     * com.smartgwt.client.widgets.cube.Facet#getProportionalTitle proportionalTitle}.
     *
     * @param proportionalAxisLabel New proportionalAxisLabel value. Default value is "Percent"
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setProportionalAxisLabel(String proportionalAxisLabel) {
        return (MetricSettings)setAttribute("proportionalAxisLabel", proportionalAxisLabel);
    }

    /**
     * Default title for the value axis label when the chart is in {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getProportional proportional rendering mode}.  This title will be used
     * unless the {@link com.smartgwt.client.widgets.chart.FacetChart#getLegendFacet legend facet} defines a {@link
     * com.smartgwt.client.widgets.cube.Facet#getProportionalTitle proportionalTitle}.
     *
     * @return Current proportionalAxisLabel value. Default value is "Percent"
     */
    public String getProportionalAxisLabel()  {
        return getAttributeAsString("proportionalAxisLabel");
    }
    

    /**
     * Properties for shadows.
     *
     * @param shadowProperties New shadowProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public MetricSettings setShadowProperties(DrawOval shadowProperties) {
        if (shadowProperties != null) {
            if (shadowProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(MetricSettings.class, "setShadowProperties", "DrawOval");
            }                                                                       
            shadowProperties.setConfigOnly(true);
        }
        JavaScriptObject config = shadowProperties == null ? null : shadowProperties.getConfig();
        return (MetricSettings)setAttribute("shadowProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties for shadows.
     *
     * @return Current shadowProperties value. Default value is null
     */
    public DrawOval getShadowProperties()  {
        DrawOval properties = new DrawOval();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("shadowProperties"));
        return properties;
    }
    

    /**
     * Whether to show the extra value axis.
     *
     * @param showAxis New showAxis value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setShowAxis(Boolean showAxis) {
        return (MetricSettings)setAttribute("showAxis", showAxis);
    }

    /**
     * Whether to show the extra value axis.
     *
     * @return Current showAxis value. Default value is null
     */
    public Boolean getShowAxis()  {
        return getAttributeAsBoolean("showAxis", true);
    }
    

    /**
     * Whether to show an axis line for this extra value axis if it is not placed directly adjacent to the chart rect.  The
     * default setting is the value of the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowChartRect showChartRect}
     * property of the FacetChart.
     *
     * @param showAxisLine New showAxisLine value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setShowAxisLine(Boolean showAxisLine) {
        return (MetricSettings)setAttribute("showAxisLine", showAxisLine);
    }

    /**
     * Whether to show an axis line for this extra value axis if it is not placed directly adjacent to the chart rect.  The
     * default setting is the value of the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowChartRect showChartRect}
     * property of the FacetChart.
     *
     * @return Current showAxisLine value. Default value is null
     */
    public Boolean getShowAxisLine()  {
        return getAttributeAsBoolean("showAxisLine", true);
    }
    

    /**
     * For Line, Area, Radar, Scatter or Bubble charts, whether to show data points for each individual data value. <P> If
     * shown, the {@link com.smartgwt.client.widgets.chart.MetricSettings#pointClick pointClick()} and {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getPointHoverHTML getPointHoverHTML()} APIs can be used to create
     * interactivity.
     *
     * @param showDataPoints New showDataPoints value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setShowDataPoints(Boolean showDataPoints) {
        return (MetricSettings)setAttribute("showDataPoints", showDataPoints);
    }

    /**
     * For Line, Area, Radar, Scatter or Bubble charts, whether to show data points for each individual data value. <P> If
     * shown, the {@link com.smartgwt.client.widgets.chart.MetricSettings#pointClick pointClick()} and {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getPointHoverHTML getPointHoverHTML()} APIs can be used to create
     * interactivity.
     *
     * @return Current showDataPoints value. Default value is false
     */
    public Boolean getShowDataPoints()  {
        Boolean result = getAttributeAsBoolean("showDataPoints", true);
        return result == null ? false : result;
    }
    

    /**
     * Should data values be shown as text labels near the shape representing the value, for example, above columns of a column
     * chart, or adjacent to points in a line chart? <p> If set to false, then data values will not be shown. <p> If set to
     * true, data values will be shown unless the data density is high enough that labels will potentially overlap, in which
     * case, data values will not be shown and hovers will be shown instead, in the same way as {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getShowValueOnHover showValueOnHover} shows hovers.
     *
     * @param showDataValues New showDataValues value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @deprecated in favor of {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataValuesMode FacetChart.showDataValuesMode},
     * which is an enum of supported modes
     */
    public MetricSettings setShowDataValues(Boolean showDataValues) {
        return (MetricSettings)setAttribute("showDataValues", showDataValues);
    }

    /**
     * Should data values be shown as text labels near the shape representing the value, for example, above columns of a column
     * chart, or adjacent to points in a line chart? <p> If set to false, then data values will not be shown. <p> If set to
     * true, data values will be shown unless the data density is high enough that labels will potentially overlap, in which
     * case, data values will not be shown and hovers will be shown instead, in the same way as {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getShowValueOnHover showValueOnHover} shows hovers.
     *
     * @return Current showDataValues value. Default value is null
     * @deprecated in favor of {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataValuesMode FacetChart.showDataValuesMode},
     * which is an enum of supported modes
     */
    public Boolean getShowDataValues()  {
        return getAttributeAsBoolean("showDataValues", true);
    }
    

    /**
     * Whether to automatically show shadows for various charts.
     *
     * @param showShadows New showShadows value. Default value is true
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setShowShadows(Boolean showShadows) {
        return (MetricSettings)setAttribute("showShadows", showShadows);
    }

    /**
     * Whether to automatically show shadows for various charts.
     *
     * @return Current showShadows value. Default value is true
     */
    public Boolean getShowShadows()  {
        Boolean result = getAttributeAsBoolean("showShadows", true);
        return result == null ? true : result;
    }
    

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.chart.MetricSettings#getValueTitle valueTitle} (or, in the case
     * of {@link com.smartgwt.client.widgets.chart.MetricSettings#getProportional proportional rendering mode}, {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getProportionalAxisLabel proportionalAxisLabel}) as a label on this
     * extra value axis.
     *
     * @param showValueAxisLabel New showValueAxisLabel value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setShowValueAxisLabel(Boolean showValueAxisLabel) {
        return (MetricSettings)setAttribute("showValueAxisLabel", showValueAxisLabel);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.chart.MetricSettings#getValueTitle valueTitle} (or, in the case
     * of {@link com.smartgwt.client.widgets.chart.MetricSettings#getProportional proportional rendering mode}, {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getProportionalAxisLabel proportionalAxisLabel}) as a label on this
     * extra value axis.
     *
     * @return Current showValueAxisLabel value. Default value is null
     */
    public Boolean getShowValueAxisLabel()  {
        return getAttributeAsBoolean("showValueAxisLabel", true);
    }
    

    /**
     * Shows the value of the nearest data value in a floating label whenever the mouse moves within the main chart area.  The
     * visual element representing the data value will also be emphasized by brightening or highlighting it (appearance differs
     * by chart type). <p> Calculates nearest value based on {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue()}. <p> The data value
     * will be formatted using {@link com.smartgwt.client.widgets.chart.FacetChart#setDataValueFormatter
     * FacetChart.setDataValueFormatter()}. The label's appearance is controlled by {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getHoverLabelProperties FacetChart.hoverLabelProperties}.
     *
     * @param showValueOnHover New showValueOnHover value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @deprecated See {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataValuesMode FacetChart.showDataValuesMode} for details
     */
    public MetricSettings setShowValueOnHover(Boolean showValueOnHover) {
        return (MetricSettings)setAttribute("showValueOnHover", showValueOnHover);
    }

    /**
     * Shows the value of the nearest data value in a floating label whenever the mouse moves within the main chart area.  The
     * visual element representing the data value will also be emphasized by brightening or highlighting it (appearance differs
     * by chart type). <p> Calculates nearest value based on {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue()}. <p> The data value
     * will be formatted using {@link com.smartgwt.client.widgets.chart.FacetChart#setDataValueFormatter
     * FacetChart.setDataValueFormatter()}. The label's appearance is controlled by {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getHoverLabelProperties FacetChart.hoverLabelProperties}.
     *
     * @return Current showValueOnHover value. Default value is null
     * @deprecated See {@link com.smartgwt.client.widgets.chart.FacetChart#getShowDataValuesMode FacetChart.showDataValuesMode} for details
     */
    public Boolean getShowValueOnHover()  {
        return getAttributeAsBoolean("showValueOnHover", true);
    }
    

    /**
     * If the {@link com.smartgwt.client.types.ChartType} is "Column" then the metric settings may include a setting for {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStacked FacetChart.stacked}. <p>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change {@link com.smartgwt.client.widgets.chart.MetricSettings#getStacked stacked}. Use null to apply a default value for the current {@link com.smartgwt.client.types.ChartType chartType}.
     *
     * @param stacked new value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setStacked(Boolean stacked) {
        return (MetricSettings)setAttribute("stacked", stacked);
    }

    /**
     * If the {@link com.smartgwt.client.types.ChartType} is "Column" then the metric settings may include a setting for {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStacked FacetChart.stacked}. <p>
     *
     * @return Current stacked value. Default value is null
     */
    public Boolean getStacked()  {
        return getAttributeAsBoolean("stacked", true);
    }
    

    /**
     * Whether to use classic logarithmic gradations, where each order of magnitude is shown as a gradation as well as a few
     * intervening lines.   Gradations also begin and end on an order of magnitude.  For example, 1,2,4,6,8,10,20,40,60,80,100.
     * <P> Default gradations can be overridden via {@link com.smartgwt.client.widgets.chart.MetricSettings#getLogBase logBase}
     * and {@link com.smartgwt.client.widgets.chart.MetricSettings#getLogGradations logGradations}.
     *
     * @param useLogGradations New useLogGradations value. Default value is false
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setUseLogGradations(Boolean useLogGradations) {
        return (MetricSettings)setAttribute("useLogGradations", useLogGradations);
    }

    /**
     * Whether to use classic logarithmic gradations, where each order of magnitude is shown as a gradation as well as a few
     * intervening lines.   Gradations also begin and end on an order of magnitude.  For example, 1,2,4,6,8,10,20,40,60,80,100.
     * <P> Default gradations can be overridden via {@link com.smartgwt.client.widgets.chart.MetricSettings#getLogBase logBase}
     * and {@link com.smartgwt.client.widgets.chart.MetricSettings#getLogGradations logGradations}.
     *
     * @return Current useLogGradations value. Default value is false
     */
    public Boolean getUseLogGradations()  {
        Boolean result = getAttributeAsBoolean("useLogGradations", true);
        return result == null ? false : result;
    }
    

    /**
     * Properties for labels of value axis.
     *
     * @param valueAxisLabelProperties New valueAxisLabelProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public MetricSettings setValueAxisLabelProperties(DrawLabel valueAxisLabelProperties) {
        if (valueAxisLabelProperties != null) {
            if (valueAxisLabelProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(MetricSettings.class, "setValueAxisLabelProperties", "DrawLabel");
            }                                                                       
            valueAxisLabelProperties.setConfigOnly(true);
        }
        JavaScriptObject config = valueAxisLabelProperties == null ? null : valueAxisLabelProperties.getConfig();
        return (MetricSettings)setAttribute("valueAxisLabelProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties for labels of value axis.
     *
     * @return Current valueAxisLabelProperties value. Default value is null
     */
    public DrawLabel getValueAxisLabelProperties()  {
        DrawLabel properties = new DrawLabel();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("valueAxisLabelProperties"));
        return properties;
    }
    

    /**
     * Properties for a "value line" - a line shows where a particular discrete value is placed, eg, vertical lines connecting
     * points of a line chart to the X axis, or radial lines in a Radar chart.
     *
     * @param valueLineProperties New valueLineProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public MetricSettings setValueLineProperties(DrawLine valueLineProperties) {
        if (valueLineProperties != null) {
            if (valueLineProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(MetricSettings.class, "setValueLineProperties", "DrawLine");
            }                                                                       
            valueLineProperties.setConfigOnly(true);
        }
        JavaScriptObject config = valueLineProperties == null ? null : valueLineProperties.getConfig();
        return (MetricSettings)setAttribute("valueLineProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Properties for a "value line" - a line shows where a particular discrete value is placed, eg, vertical lines connecting
     * points of a line chart to the X axis, or radial lines in a Radar chart.
     *
     * @return Current valueLineProperties value. Default value is null
     */
    public DrawLine getValueLineProperties()  {
        DrawLine properties = new DrawLine();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("valueLineProperties"));
        return properties;
    }
    

    /**
     * A label for the data values, such as "Sales in Thousands", typically used as the label for the value axis.
     *
     * @param valueTitle New valueTitle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setValueTitle(String valueTitle) {
        return (MetricSettings)setAttribute("valueTitle", valueTitle);
    }

    /**
     * A label for the data values, such as "Sales in Thousands", typically used as the label for the value axis.
     *
     * @return Current valueTitle value. Default value is null
     */
    public String getValueTitle()  {
        return getAttributeAsString("valueTitle");
    }
    

    /**
     * Same as {@link com.smartgwt.client.widgets.chart.FacetChart#getXAxisEndValue FacetChart.xAxisEndValue} but affects only
     * one metric.
     *
     * @param xAxisEndValue New xAxisEndValue value. Default value is null
     * @return {@link com.smartgwt.client.widgets.chart.MetricSettings MetricSettings} instance, for chaining setter calls
     */
    public MetricSettings setXAxisEndValue(Double xAxisEndValue) {
        return (MetricSettings)setAttribute("xAxisEndValue", xAxisEndValue);
    }

    /**
     * Same as {@link com.smartgwt.client.widgets.chart.FacetChart#getXAxisEndValue FacetChart.xAxisEndValue} but affects only
     * one metric.
     *
     * @return Current xAxisEndValue value. Default value is null
     */
    public Double getXAxisEndValue()  {
        return getAttributeAsDouble("xAxisEndValue");
    }
    

    // ********************* Methods ***********************
	/**
     * Return an array of the gradation values used in the current chart.  Pass these values to {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getXCoord getXCoord()} / {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getYCoord getYCoord()} (depending on the orientation of the chart) to
     * discover the coordinates where gradations are drawn. <P> This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires.
     *
     * @return an array of gradation values used in the current chart.
     */
    public native float[] getGradations() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getGradations();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOffloat(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Returns the X coordinate where the passed data value either was or would be drawn. For example, this would be the X
     * coordinate where a bar would end in a bar chart. <P> This is only allowed to be called after {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires. <P> If the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getChartType chartType} is  {@link
     * com.smartgwt.client.types.ChartType#BAR}, {@link com.smartgwt.client.types.ChartType#BUBBLE}, or {@link
     * com.smartgwt.client.types.ChartType#SCATTER} then the <code>value</code> argument should be a number.  For other
     * rectangular charts, this method expects a {@link com.smartgwt.client.widgets.cube.FacetValueMap} that uniquely
     * identifies the data cell whose X-axis coordinate is to be retrieved. <p> Note that when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getCanZoom canZoom} is enabled, this API is valid only for data values
     * between {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomStartValue zoomStartValue} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomEndValue zoomEndValue}.
     * @param value the value to be drawn.
     *
     * @return the X coordinate where the passed data value would be drawn; or null if the passed <code>FacetValueMap</code> does not
     * identify a currently-drawn data cell.
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getXCoord(float value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getXCoord(value);
        return ret;
    }-*/;

	/**
     * Returns the X coordinate where the passed data value either was or would be drawn. For example, this would be the X
     * coordinate where a bar would end in a bar chart. <P> This is only allowed to be called after {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn()} fires. <P> If the {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getChartType chartType} is  {@link
     * com.smartgwt.client.types.ChartType#BAR}, {@link com.smartgwt.client.types.ChartType#BUBBLE}, or {@link
     * com.smartgwt.client.types.ChartType#SCATTER} then the <code>value</code> argument should be a number.  For other
     * rectangular charts, this method expects a {@link com.smartgwt.client.widgets.cube.FacetValueMap} that uniquely
     * identifies the data cell whose X-axis coordinate is to be retrieved. <p> Note that when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getCanZoom canZoom} is enabled, this API is valid only for data values
     * between {@link com.smartgwt.client.widgets.chart.FacetChart#getZoomStartValue zoomStartValue} and {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getZoomEndValue zoomEndValue}.
     * @param value the value to be drawn.
     *
     * @return the X coordinate where the passed data value would be drawn; or null if the passed <code>FacetValueMap</code> does not
     * identify a currently-drawn data cell.
     */
    public native Double getXCoordAsDouble(double value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getXCoord(value);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDouble(D)(ret);
    }-*/;

	/**
     * Returns the Y coordinate where the passed data value either was or would be drawn. For example, this would be the Y
     * coordinate that a line would pass through on a line chart, or the top of a column on a column chart. <P> This is only
     * allowed to be called after {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler
     * FacetChart.chartDrawn()} fires. <P> If the {@link com.smartgwt.client.widgets.chart.FacetChart#getChartType chartType}
     * is  {@link com.smartgwt.client.types.ChartType#AREA}, {@link com.smartgwt.client.types.ChartType#BUBBLE}, {@link
     * com.smartgwt.client.types.ChartType#COLUMN}, {@link com.smartgwt.client.types.ChartType#HISTOGRAM}, {@link
     * com.smartgwt.client.types.ChartType#LINE}, or {@link com.smartgwt.client.types.ChartType#SCATTER} then the
     * <code>value</code> argument should be a number.  For {@link com.smartgwt.client.types.ChartType#BAR} charts this method
     * expects a {@link com.smartgwt.client.widgets.cube.FacetValueMap} that uniquely identifies the data cell whose Y-axis
     * coordinate is to be retrieved.
     * @param value the value to be drawn.
     *
     * @return the Y coordinate where the passed data value would be drawn.
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public native float getYCoord(float value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getYCoord(value);
        return ret;
    }-*/;

	/**
     * Returns the Y coordinate where the passed data value either was or would be drawn. For example, this would be the Y
     * coordinate that a line would pass through on a line chart, or the top of a column on a column chart. <P> This is only
     * allowed to be called after {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler
     * FacetChart.chartDrawn()} fires. <P> If the {@link com.smartgwt.client.widgets.chart.FacetChart#getChartType chartType}
     * is  {@link com.smartgwt.client.types.ChartType#AREA}, {@link com.smartgwt.client.types.ChartType#BUBBLE}, {@link
     * com.smartgwt.client.types.ChartType#COLUMN}, {@link com.smartgwt.client.types.ChartType#HISTOGRAM}, {@link
     * com.smartgwt.client.types.ChartType#LINE}, or {@link com.smartgwt.client.types.ChartType#SCATTER} then the
     * <code>value</code> argument should be a number.  For {@link com.smartgwt.client.types.ChartType#BAR} charts this method
     * expects a {@link com.smartgwt.client.widgets.cube.FacetValueMap} that uniquely identifies the data cell whose Y-axis
     * coordinate is to be retrieved.
     * @param value the value to be drawn.
     *
     * @return the Y coordinate where the passed data value would be drawn.
     */
    public native double getYCoordAsDouble(double value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.getYCoord(value);
        return ret;
    }-*/;


    // ********************* Static Methods ***********************

    // ***********************************************************



    /**
     * Display custom HTML when {@link com.smartgwt.client.widgets.chart.MetricSettings#getShowDataPoints showDataPoints} is true and the mouse hovers
     * over a point.
     * @param hoverCustomizer
     */
    public native void setPointHoverCustomizer(ChartPointHoverCustomizer hoverCustomizer) /*-{
        var self = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        self.getPointHoverHTML = $debox($entry(function (value, record) {
            var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            var valueJ = @java.lang.Float::new(Ljava/lang/String;)("" + value);
            var metricIdJ = metricId;

            hoverCustomizer.@com.smartgwt.client.widgets.chart.ChartPointHoverCustomizer::setMetricId(Ljava/lang/String;)(metricIdJ);
            return hoverCustomizer.@com.smartgwt.client.widgets.chart.ChartPointHoverCustomizer::hoverHTML(Ljava/lang/Float;Lcom/smartgwt/client/data/Record;)(valueJ, recordJ);
        }));
    }-*/;

    /**
     * Apply a handler to fire when {@link com.smartgwt.client.widgets.chart.MetricSettings#getShowDataPoints showDataPoints} is true,
     * and the user clicks on a point.
     * @param handler
     */
    public native void setPointClickHandler(ChartPointClickHandler handler) /*-{
        var self = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        self.pointClick = $debox($entry(function (value, record, metricId) {
	        var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
	        var valueJ = @java.lang.Float::new(Ljava/lang/String;)("" + value);
            var metricIdJ = metricId;

	        var eventJ = @com.smartgwt.client.widgets.chart.ChartPointClickEvent::new(Ljava/lang/Float;Lcom/smartgwt/client/data/Record;)(valueJ,recordJ);
            eventJ.@com.smartgwt.client.widgets.chart.ChartPointClickEvent::setMetricId(Ljava/lang/String;)(metricIdJ);

            handler.@com.smartgwt.client.widgets.chart.ChartPointClickHandler::onPointClick(Lcom/smartgwt/client/widgets/chart/ChartPointClickEvent;)(eventJ);
        }));
    }-*/;

    /**
     * Formatter to apply to values displayed in the gradation labels.
     * @param formatter Formatter to apply to values displayed in the gradation labels
     */
    public native void setAxisValueFormatter(ValueFormatter formatter) /*-{
        var self = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        self.formatAxisValue = $debox($entry(function (value) {
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            return formatter.@com.smartgwt.client.widgets.chart.ValueFormatter::format(Ljava/lang/Object;)(valueJ);
        }));
    }-*/;

    /**
     * Formatter to apply to values displayed in the hover labels and other value labels
     * @param formatter Formatter to apply to values displayed in the hover labels and other value labels
     */
    public native void setDataValueFormatter(ValueFormatter formatter) /*-{
        var self = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        self.formatDataValue = $debox($entry(function (value) {
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            return formatter.@com.smartgwt.client.widgets.chart.ValueFormatter::format(Ljava/lang/Object;)(valueJ);
        }));
    }-*/;

    // ************************************ getDataColor() ************************************

	/**
     * Get a color from the {@link #getDataColors dataColors} Array.  The colors returned by
     * this method define what colors are used for the data in the chart.
     * <P>
     * This is not an override point, but you can provide your own function by setting a
     * customizer with {@link #setDataColorMapper setDataColorMapper()}.
     * @param index index of the visual element to be colored
     * @param facetValueId id of the facet value to be colored
     * @param purpose purpose for the requested color - such as "legend", "line", "area", 
     *                "points", etc.
     * @return chosen color
     * @see com.smartgwt.client.widgets.chart.ColorMapper
     * @see #setDataLineColorMapper
     * @see #setDataGradientMapper
     */
    public native String getDataColor(int index, String facetValueId, String purpose) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getDataColor(index, facetValueId, purpose);
    }-*/;

	/**
     * See {@link #getDataColor}
     */
    public native String getDataColor(int index, Integer facetValueId, String purpose) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getDataColor(index, facetValueId == null ? null : facetValueId.@java.lang.Integer::intValue()(), purpose);
    }-*/;

	/**
     * See {@link #getDataColor}
     */
    public native String getDataColor(int index, Double facetValueId, String purpose) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getDataColor(index, facetValueId == null ? null : facetValueId.@java.lang.Double::doubleValue()(), purpose);
    }-*/;

	/**
     * See {@link #getDataColor}
     */
    public native String getDataColor(int index, Date facetValueId, String purpose) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getDataColor(index, @com.smartgwt.client.util.JSOHelper::toDateJS(Ljava/util/Date;)(facetValueId), purpose);
    }-*/;

	/**
     * See {@link #getDataColor}
     */
    public String getDataColor(int index) {
        return getDataColor(index, (String)null, null);
    }

    // **************************** Data Color/Gradient Customizers ****************************

	/**
     * Sets a customizer to redefine what colors are used when rendering the chart data.
     *
     * @param colorMapper the customizer redefining what colors are used for chart data
     * @see #getDataColor
     * @see #setDataLineColorMapper
     * @see #setDataGradientMapper
     */
    public native void setDataColorMapper(ColorMapper colorMapper) /*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()(),
            self = isCreated ? this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()() :
                               this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        if (colorMapper != null) {
            self.getDataColor = $debox($entry(function (index, facetValueId, purpose) {
                var indexJ = $wnd.isc.isA.Number(index) ? index.valueOf() : 0,
                    facetValueIdJ = $wnd.SmartGWT.convertToJavaType(facetValueId);
                return colorMapper.@com.smartgwt.client.widgets.chart.ColorMapper::getColor(ILjava/lang/Object;Ljava/lang/String;)(indexJ, facetValueIdJ, purpose);
            }));
        } else if (!isCreated) {
            delete self.getDataColor;
        } else {
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            self.getDataColor = $wnd.isc[scClassName].getInstanceProperty("getDataColor");
        }
    }-*/;

	/**
     * Sets a customizer to redefine what colors are used when rendering lines for the chart
     * data.  No default implementation.  If not defined or null is returned, the Framework will
     * default to using the datacolor - either {@link #getDataColor getDataColor()} or the
     * {@link com.smartgwt.client.widgets.chart.ColorMapper ColorMapper} installed by
     * {@link #setDataColorMapper setDataColorMapper()} if one has been provided.
     *
     * @param colorMapper the customizer redefining what line colors are used for chart data
     * @see #getDataColor
     * @see #setDataColorMapper
     * @see #setDataGradientMapper
     */
    public native void setDataLineColorMapper(ColorMapper colorMapper) /*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()(),
            self = isCreated ? this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()() :
                               this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        if (colorMapper != null) {
            self.getDataLineColor = $debox($entry(function (index, facetValueId, purpose) {
                var indexJ = $wnd.isc.isA.Number(index) ? index.valueOf() : 0,
                    facetValueIdJ = $wnd.SmartGWT.convertToJavaType(facetValueId);
                return colorMapper.@com.smartgwt.client.widgets.chart.ColorMapper::getColor(ILjava/lang/Object;Ljava/lang/String;)(indexJ, facetValueIdJ, purpose);
            }));
        } else if (!isCreated) {
            delete self.getDataLineColor;
        } else {
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            self.getDataLineColor = $wnd.isc[scClassName].getInstanceProperty("getDataLineColor");
        }
    }-*/;

	/**
     * Sets a customizer to redefine what gradients are used when rendering the chart data.
     *
     * @param gradientMapper the customizer redefining what gradients are used for chart data
     *
     * @see #getDataColor
     * @see #setDataLineColorMapper
     * @see #setDataGradientMapper
     */
    public native void setDataGradientMapper(GradientMapper gradientMapper) /*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()(),
            self = isCreated ? this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()() :
                               this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        if (gradientMapper != null) {
            self.getDataGradient = $debox($entry(function (index, facetValueId, purpose) {
                var indexJ = $wnd.isc.isA.Number(index) ? index.valueOf() : 0,
                    facetValueIdJ = $wnd.SmartGWT.convertToJavaType(facetValueId);
                return gradientMapper.@com.smartgwt.client.widgets.chart.ColorMapper::getColor(ILjava/lang/Object;Ljava/lang/String;)(indexJ, facetValueIdJ, purpose);
            }));
        } else if (!isCreated) {
            delete self.getDataGradient;
        } else {
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            self.getDataGradient = $wnd.isc[scClassName].getInstanceProperty("getDataGradient");
        }
    }-*/;

}
