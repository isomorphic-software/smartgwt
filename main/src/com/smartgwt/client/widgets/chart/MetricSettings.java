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
 
package com.smartgwt.client.widgets.chart;



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
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

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
public class MetricSettings extends DataClass {

    public static MetricSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new MetricSettings(jsObj);
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }


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
     * @param axisLineProperties axisLineProperties Default value is null
     */
    public void setAxisLineProperties(DrawLine axisLineProperties) {
        setAttribute("axisLineProperties", axisLineProperties == null ? null : axisLineProperties.getConfig());
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
     *
     * @return DrawLine
     */
    public DrawLine getAxisLineProperties()  {
        return DrawLine.getOrCreateRef(getAttributeAsJavaScriptObject("axisLineProperties"));
    }

    /**
     * See {@link com.smartgwt.client.types.ChartType} for a list of known types - Column, Bar, Line, Pie, Doughnut, Area, and
     * Radar charts are supported.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change the current {@link com.smartgwt.client.types.ChartType chartType}. Will redraw the chart if drawn.  Will use default settings for the new chart type for {@link com.smartgwt.client.widgets.chart.MetricSettings#getStacked stacked} and {@link com.smartgwt.client.widgets.chart.MetricSettings#getFilled filled} if those values are null.
     *
     * @param chartType new chart type. Default value is null
     */
    public void setChartType(ChartType chartType) {
        setAttribute("chartType", chartType == null ? null : chartType.getValue());
    }

    /**
     * See {@link com.smartgwt.client.types.ChartType} for a list of known types - Column, Bar, Line, Pie, Doughnut, Area, and
     * Radar charts are supported.
     *
     *
     * @return ChartType
     */
    public ChartType getChartType()  {
        return EnumUtil.getEnum(ChartType.values(), getAttribute("chartType"));
    }

    /**
     * An array of colors to use for a series of visual elements representing data (eg columns, bars, pie slices), any of which
     * may be adjacent to any other. <P> Colors must be in the format of a leading hash (#) plus 6 hexadecimal digits, for
     * example,  "#FFFFFF" is white, "#FF0000" is pure red.
     *
     * @param dataColors . See {@link com.smartgwt.client.docs.CSSColor CSSColor}. Default value is see below
     */
    public void setDataColors(String... dataColors) {
        setAttribute("dataColors", dataColors);
    }

    /**
     * An array of colors to use for a series of visual elements representing data (eg columns, bars, pie slices), any of which
     * may be adjacent to any other. <P> Colors must be in the format of a leading hash (#) plus 6 hexadecimal digits, for
     * example,  "#FFFFFF" is white, "#FF0000" is pure red.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.CSSColor CSSColor}
     */
    public String[] getDataColors()  {
        return getAttributeAsStringArray("dataColors");
    }

    /**
     * Properties for lines that show data (as opposed to gradations or borders around the data area).
     *
     * @param dataLineProperties dataLineProperties Default value is null
     */
    public void setDataLineProperties(DrawLine dataLineProperties) {
        setAttribute("dataLineProperties", dataLineProperties == null ? null : dataLineProperties.getConfig());
    }

    /**
     * Properties for lines that show data (as opposed to gradations or borders around the data area).
     *
     *
     * @return DrawLine
     */
    public DrawLine getDataLineProperties()  {
        return DrawLine.getOrCreateRef(getAttributeAsJavaScriptObject("dataLineProperties"));
    }

    /**
     * Properties for lines that outline a data shape (in filled charts such as area or radar charts).
     *
     * @param dataOutlineProperties dataOutlineProperties Default value is null
     */
    public void setDataOutlineProperties(DrawItem dataOutlineProperties) {
        setAttribute("dataOutlineProperties", dataOutlineProperties == null ? null : dataOutlineProperties.getConfig());
    }

    /**
     * Properties for lines that outline a data shape (in filled charts such as area or radar charts).
     *
     *
     * @return DrawItem
     */
    public DrawItem getDataOutlineProperties()  {
        return DrawItem.getOrCreateRef(getAttributeAsJavaScriptObject("dataOutlineProperties"));
    }

    /**
     * Common properties to apply for all data points (see {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getShowDataPoints showDataPoints}).
     *
     * @param dataPointProperties dataPointProperties Default value is null
     */
    public void setDataPointProperties(DrawItem dataPointProperties) {
        setAttribute("dataPointProperties", dataPointProperties == null ? null : dataPointProperties.getConfig());
    }

    /**
     * Common properties to apply for all data points (see {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getShowDataPoints showDataPoints}).
     *
     *
     * @return DrawItem
     */
    public DrawItem getDataPointProperties()  {
        return DrawItem.getOrCreateRef(getAttributeAsJavaScriptObject("dataPointProperties"));
    }

    /**
     * Size in pixels for data points drawn for line, area, radar and other chart types.
     *
     * @param dataPointSize dataPointSize Default value is 6
     */
    public void setDataPointSize(int dataPointSize) {
        setAttribute("dataPointSize", dataPointSize);
    }

    /**
     * Size in pixels for data points drawn for line, area, radar and other chart types.
     *
     *
     * @return int
     */
    public int getDataPointSize()  {
        return getAttributeAsInt("dataPointSize");
    }

    /**
     * Properties for data shapes (filled areas in area or radar charts).
     *
     * @param dataShapeProperties dataShapeProperties Default value is null
     */
    public void setDataShapeProperties(DrawPath dataShapeProperties) {
        setAttribute("dataShapeProperties", dataShapeProperties == null ? null : dataShapeProperties.getConfig());
    }

    /**
     * Properties for data shapes (filled areas in area or radar charts).
     *
     *
     * @return DrawPath
     */
    public DrawPath getDataShapeProperties()  {
        return DrawPath.getOrCreateRef(getAttributeAsJavaScriptObject("dataShapeProperties"));
    }

    /**
     * The {@link com.smartgwt.client.widgets.chart.FacetChart#getDecimalPrecision decimalPrecision} used to render the numeric
     * labels of this metric axis.
     *
     * @param decimalPrecision decimalPrecision Default value is 2
     */
    public void setDecimalPrecision(int decimalPrecision) {
        setAttribute("decimalPrecision", decimalPrecision);
    }

    /**
     * The {@link com.smartgwt.client.widgets.chart.FacetChart#getDecimalPrecision decimalPrecision} used to render the numeric
     * labels of this metric axis.
     *
     *
     * @return int
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
     */
    public void setFilled(Boolean filled) {
        setAttribute("filled", filled);
    }

    /**
     * Whether shapes are filled, for example, whether a multi-series line chart appears as a stack of filled regions as
     * opposed to just multiple lines. <P> If unset, fills will be automatically used when there are multiple facets and
     * stacking is active (so Line and Radar charts will show stacked regions).   <P> You can explicitly set filled:false to
     * create multi-facet Line or Radar charts where translucent regions overlap, or filled:true to fill in a single-facet Line
     * or Radar chart.
     *
     *
     * @return Boolean
     */
    public Boolean getFilled()  {
        return getAttributeAsBoolean("filled");
    }

    /**
     * For a {@link com.smartgwt.client.widgets.chart.MetricSettings#getMultiFacet single-facet} chart of an extra value axis,
     * this property provides a constant facet value for the second facet.  By varying the value of the other facet in
     * multi-facet data, the chart obtains the series of values to plot.  The default facet value is the first facet value of
     * the second facet.
     *
     * @param fixedFacetValue . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setFixedFacetValue(String fixedFacetValue) {
        setAttribute("fixedFacetValue", fixedFacetValue);
    }

    /**
     * For a {@link com.smartgwt.client.widgets.chart.MetricSettings#getMultiFacet single-facet} chart of an extra value axis,
     * this property provides a constant facet value for the second facet.  By varying the value of the other facet in
     * multi-facet data, the chart obtains the series of values to plot.  The default facet value is the first facet value of
     * the second facet.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
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
     * @param fixedFacetValue fixedFacetValue Default value is null
     */
    public void setFixedFacetValue(Integer fixedFacetValue) {
        setAttribute("fixedFacetValue", fixedFacetValue);
    }

    /**
     * Properties for gradation labels
     *
     * @param gradationLabelProperties gradationLabelProperties Default value is null
     */
    public void setGradationLabelProperties(DrawLabel gradationLabelProperties) {
        setAttribute("gradationLabelProperties", gradationLabelProperties == null ? null : gradationLabelProperties.getConfig());
    }

    /**
     * Properties for gradation labels
     *
     *
     * @return DrawLabel
     */
    public DrawLabel getGradationLabelProperties()  {
        return DrawLabel.getOrCreateRef(getAttributeAsJavaScriptObject("gradationLabelProperties"));
    }

    /**
     * Properties for gradation lines
     *
     * @param gradationLineProperties gradationLineProperties Default value is null
     */
    public void setGradationLineProperties(DrawLine gradationLineProperties) {
        setAttribute("gradationLineProperties", gradationLineProperties == null ? null : gradationLineProperties.getConfig());
    }

    /**
     * Properties for gradation lines
     *
     *
     * @return DrawLine
     */
    public DrawLine getGradationLineProperties()  {
        return DrawLine.getOrCreateRef(getAttributeAsJavaScriptObject("gradationLineProperties"));
    }

    /**
     * Properties for the gradation line drawn for zero (slightly thicker by default).
     *
     * @param gradationZeroLineProperties gradationZeroLineProperties Default value is null
     */
    public void setGradationZeroLineProperties(DrawLine gradationZeroLineProperties) {
        setAttribute("gradationZeroLineProperties", gradationZeroLineProperties == null ? null : gradationZeroLineProperties.getConfig());
    }

    /**
     * Properties for the gradation line drawn for zero (slightly thicker by default).
     *
     *
     * @return DrawLine
     */
    public DrawLine getGradationZeroLineProperties()  {
        return DrawLine.getOrCreateRef(getAttributeAsJavaScriptObject("gradationZeroLineProperties"));
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.MetricSettings#getUseLogGradations useLogGradations}, base value for
     * logarithmic gradation lines.  Gradation lines will be shown at every power of this value plus intervening values
     * specified by {@link com.smartgwt.client.widgets.chart.MetricSettings#getLogGradations logGradations}.
     *
     * @param logBase logBase Default value is 10
     */
    public void setLogBase(int logBase) {
        setAttribute("logBase", logBase);
    }

    /**
     * When {@link com.smartgwt.client.widgets.chart.MetricSettings#getUseLogGradations useLogGradations}, base value for
     * logarithmic gradation lines.  Gradation lines will be shown at every power of this value plus intervening values
     * specified by {@link com.smartgwt.client.widgets.chart.MetricSettings#getLogGradations logGradations}.
     *
     *
     * @return int
     */
    public int getLogBase()  {
        return getAttributeAsInt("logBase");
    }

    /**
     * Whether to use logarithmic scaling for values. <P> Logarithmic scale charts show an equivalent percentage increase as
     * equivalent distance on the chart.  That is, 10 and 100 are the same distance apart as 100 and 1000 (each being a 10
     * times or 1000% increase).
     *
     * @param logScale logScale Default value is false
     */
    public void setLogScale(Boolean logScale) {
        setAttribute("logScale", logScale);
    }

    /**
     * Whether to use logarithmic scaling for values. <P> Logarithmic scale charts show an equivalent percentage increase as
     * equivalent distance on the chart.  That is, 10 and 100 are the same distance apart as 100 and 1000 (each being a 10
     * times or 1000% increase).
     *
     *
     * @return Boolean
     */
    public Boolean getLogScale()  {
        return getAttributeAsBoolean("logScale");
    }

    /**
     * Whether this extra value axis plots values while varying the facet values of just the first facet (single-facet) or both
     * first and second facets (multi-facet).
     *
     * @param multiFacet multiFacet Default value is true
     */
    public void setMultiFacet(Boolean multiFacet) {
        setAttribute("multiFacet", multiFacet);
    }

    /**
     * Whether this extra value axis plots values while varying the facet values of just the first facet (single-facet) or both
     * first and second facets (multi-facet).
     *
     *
     * @return Boolean
     */
    public Boolean getMultiFacet()  {
        return getAttributeAsBoolean("multiFacet");
    }

    /**
     * Properties for shadows.
     *
     * @param shadowProperties shadowProperties Default value is null
     */
    public void setShadowProperties(DrawOval shadowProperties) {
        setAttribute("shadowProperties", shadowProperties == null ? null : shadowProperties.getConfig());
    }

    /**
     * Properties for shadows.
     *
     *
     * @return DrawOval
     */
    public DrawOval getShadowProperties()  {
        return DrawOval.getOrCreateRef(getAttributeAsJavaScriptObject("shadowProperties"));
    }

    /**
     * Whether to show an axis line for this extra value axis if it is not placed directly adjacent to the chart rect.  The
     * default setting is the value of the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowChartRect showChartRect}
     * property of the FacetChart.
     *
     * @param showAxisLine showAxisLine Default value is null
     */
    public void setShowAxisLine(Boolean showAxisLine) {
        setAttribute("showAxisLine", showAxisLine);
    }

    /**
     * Whether to show an axis line for this extra value axis if it is not placed directly adjacent to the chart rect.  The
     * default setting is the value of the {@link com.smartgwt.client.widgets.chart.FacetChart#getShowChartRect showChartRect}
     * property of the FacetChart.
     *
     *
     * @return Boolean
     */
    public Boolean getShowAxisLine()  {
        return getAttributeAsBoolean("showAxisLine");
    }

    /**
     * For line charts, whether to show data points for each individual data value. <P> If shown, the {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#pointClick MetricSettings.pointClick} and {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getPointHoverHTML MetricSettings.getPointHoverHTML} APIs can be used to
     * create interactivity.
     *
     * @param showDataPoints showDataPoints Default value is false
     */
    public void setShowDataPoints(Boolean showDataPoints) {
        setAttribute("showDataPoints", showDataPoints);
    }

    /**
     * For line charts, whether to show data points for each individual data value. <P> If shown, the {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#pointClick MetricSettings.pointClick} and {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getPointHoverHTML MetricSettings.getPointHoverHTML} APIs can be used to
     * create interactivity.
     *
     *
     * @return Boolean
     */
    public Boolean getShowDataPoints()  {
        return getAttributeAsBoolean("showDataPoints");
    }

    /**
     * If set, data values will be shown as text labels near the shape representing the value, for example, above columns of a
     * column chart, or adjacent to points in a line chart. <p> By default, if data density is high enough that labels will
     * potentially overlap, data values will not be shown and {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getShowValueOnHover showValueOnHover} will be enabled instead.
     *
     * @param showDataValues showDataValues Default value is null
     */
    public void setShowDataValues(Boolean showDataValues) {
        setAttribute("showDataValues", showDataValues);
    }

    /**
     * If set, data values will be shown as text labels near the shape representing the value, for example, above columns of a
     * column chart, or adjacent to points in a line chart. <p> By default, if data density is high enough that labels will
     * potentially overlap, data values will not be shown and {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getShowValueOnHover showValueOnHover} will be enabled instead.
     *
     *
     * @return Boolean
     */
    public Boolean getShowDataValues()  {
        return getAttributeAsBoolean("showDataValues");
    }

    /**
     * Whether to automatically show shadows for various charts.
     *
     * @param showShadows showShadows Default value is true
     */
    public void setShowShadows(Boolean showShadows) {
        setAttribute("showShadows", showShadows);
    }

    /**
     * Whether to automatically show shadows for various charts.
     *
     *
     * @return Boolean
     */
    public Boolean getShowShadows()  {
        return getAttributeAsBoolean("showShadows");
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.chart.MetricSettings#getValueTitle valueTitle} as a label on this
     * extra value axis.
     *
     * @param showValueAxisLabel showValueAxisLabel Default value is null
     */
    public void setShowValueAxisLabel(Boolean showValueAxisLabel) {
        setAttribute("showValueAxisLabel", showValueAxisLabel);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.chart.MetricSettings#getValueTitle valueTitle} as a label on this
     * extra value axis.
     *
     *
     * @return Boolean
     */
    public Boolean getShowValueAxisLabel()  {
        return getAttributeAsBoolean("showValueAxisLabel");
    }

    /**
     * Shows the value of the nearest data value in a floating label whenever the mouse moves within the main chart area.  The
     * visual element representing the data value will also be emphasized by brightening or highlighting it (appearance differs
     * by chart type). <p> Calculates nearest value based on {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue}. <p> The label's
     * appearance is controlled by {@link com.smartgwt.client.widgets.chart.FacetChart#getHoverLabelProperties
     * hoverLabelProperties}.
     *
     * @param showValueOnHover showValueOnHover Default value is null
     */
    public void setShowValueOnHover(Boolean showValueOnHover) {
        setAttribute("showValueOnHover", showValueOnHover);
    }

    /**
     * Shows the value of the nearest data value in a floating label whenever the mouse moves within the main chart area.  The
     * visual element representing the data value will also be emphasized by brightening or highlighting it (appearance differs
     * by chart type). <p> Calculates nearest value based on {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getNearestDrawnValue FacetChart.getNearestDrawnValue}. <p> The label's
     * appearance is controlled by {@link com.smartgwt.client.widgets.chart.FacetChart#getHoverLabelProperties
     * hoverLabelProperties}.
     *
     *
     * @return Boolean
     */
    public Boolean getShowValueOnHover()  {
        return getAttributeAsBoolean("showValueOnHover");
    }

    /**
     * If the {@link com.smartgwt.client.types.ChartType} is "Column" then the metric settings may include a setting for {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStacked stacked}. <p>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Method to change {@link com.smartgwt.client.widgets.chart.MetricSettings#getStacked stacked}. Use null to apply a default value for the current {@link com.smartgwt.client.types.ChartType chartType}.
     *
     * @param stacked new value. Default value is null
     */
    public void setStacked(Boolean stacked) {
        setAttribute("stacked", stacked);
    }

    /**
     * If the {@link com.smartgwt.client.types.ChartType} is "Column" then the metric settings may include a setting for {@link
     * com.smartgwt.client.widgets.chart.FacetChart#getStacked stacked}. <p>
     *
     *
     * @return Boolean
     */
    public Boolean getStacked()  {
        return getAttributeAsBoolean("stacked");
    }

    /**
     * Whether to use classic logarithmic gradations, where each order of magnitude is shown as a gradation as well as a few
     * intervening lines.   Gradations also begin and end on an order of magnitude.  For example, 1,2,4,6,8,10,20,40,60,80,100.
     * <P> Default gradations can be overridden via {@link com.smartgwt.client.widgets.chart.MetricSettings#getLogBase logBase}
     * and {@link com.smartgwt.client.widgets.chart.MetricSettings#getLogGradations logGradations}.
     *
     * @param useLogGradations useLogGradations Default value is false
     */
    public void setUseLogGradations(Boolean useLogGradations) {
        setAttribute("useLogGradations", useLogGradations);
    }

    /**
     * Whether to use classic logarithmic gradations, where each order of magnitude is shown as a gradation as well as a few
     * intervening lines.   Gradations also begin and end on an order of magnitude.  For example, 1,2,4,6,8,10,20,40,60,80,100.
     * <P> Default gradations can be overridden via {@link com.smartgwt.client.widgets.chart.MetricSettings#getLogBase logBase}
     * and {@link com.smartgwt.client.widgets.chart.MetricSettings#getLogGradations logGradations}.
     *
     *
     * @return Boolean
     */
    public Boolean getUseLogGradations()  {
        return getAttributeAsBoolean("useLogGradations");
    }

    /**
     * Properties for labels of value axis.
     *
     * @param valueAxisLabelProperties valueAxisLabelProperties Default value is null
     */
    public void setValueAxisLabelProperties(DrawLabel valueAxisLabelProperties) {
        setAttribute("valueAxisLabelProperties", valueAxisLabelProperties == null ? null : valueAxisLabelProperties.getConfig());
    }

    /**
     * Properties for labels of value axis.
     *
     *
     * @return DrawLabel
     */
    public DrawLabel getValueAxisLabelProperties()  {
        return DrawLabel.getOrCreateRef(getAttributeAsJavaScriptObject("valueAxisLabelProperties"));
    }

    /**
     * Properties for a "value line" - a line shows where a particular discrete value is placed, eg, vertical lines connecting
     * points of a line chart to the X axis, or radial lines in a Radar chart.
     *
     * @param valueLineProperties valueLineProperties Default value is null
     */
    public void setValueLineProperties(DrawLine valueLineProperties) {
        setAttribute("valueLineProperties", valueLineProperties == null ? null : valueLineProperties.getConfig());
    }

    /**
     * Properties for a "value line" - a line shows where a particular discrete value is placed, eg, vertical lines connecting
     * points of a line chart to the X axis, or radial lines in a Radar chart.
     *
     *
     * @return DrawLine
     */
    public DrawLine getValueLineProperties()  {
        return DrawLine.getOrCreateRef(getAttributeAsJavaScriptObject("valueLineProperties"));
    }

    /**
     * A label for the data values, such as "Sales in Thousands", typically used as the label for the value axis.
     *
     * @param valueTitle . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setValueTitle(String valueTitle) {
        setAttribute("valueTitle", valueTitle);
    }

    /**
     * A label for the data values, such as "Sales in Thousands", typically used as the label for the value axis.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getValueTitle()  {
        return getAttributeAsString("valueTitle");
    }

    // ********************* Methods ***********************

    /**
     * Get a color from the {@link com.smartgwt.client.widgets.chart.MetricSettings#getDataColors dataColors} Array <P>
     * Override to provide a dynamic color generation scheme.
     * @param index index of the visual element to be colored
     *
     * @return 
     */
    public native String getDataColor(int index) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getDataColor(index);
    }-*/;

    /**
     * Return an array of the gradation values used in the current chart.  Pass these values to {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getXCoord MetricSettings.getXCoord} / {@link
     * com.smartgwt.client.widgets.chart.MetricSettings#getYCoord MetricSettings.getYCoord} (depending on the orientation of
     * the chart) to discover the coordinates where gradations are drawn. <P> This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     *
     * @return an array of gradation values used in the current chart.
     */
    public native float[] getGradations() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getGradations();
    }-*/;

    /**
     * Returns the X coordination where the passed data value would be drawn.   For example, this would be the X coordinate
     * where a bar would end in a bar chart. <P> This is only allowed to be called when {@link
     * com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     */
    public native void getXCoord() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.getXCoord();
    }-*/;

    /**
     * Returns the Y coordination where the passed data value would be drawn.   For example, this would be the X coordinate
     * that a line would pass through on a line chart, or the top of a column on a column chart. <P> This is only allowed to be
     * called when {@link com.smartgwt.client.widgets.chart.FacetChart#addChartDrawnHandler FacetChart.chartDrawn} fires.
     * @param value the value to be drawn.
     *
     * @return the Y coordinate where the passed data value would be drawn.
     */
    public native float getYCoord(float value) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        return self.getYCoord(value);
    }-*/;

    // ********************* Static Methods ***********************
        
    // ***********************************************************        



    public static MetricSettings[] convertToMetricSettingsArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new MetricSettings[]{};
        }
        if (JSOHelper.isArray(nativeArray)) {
            JavaScriptObject[] metricSettingsJS = JSOHelper.toArray(nativeArray);
            MetricSettings[] objects = new MetricSettings[metricSettingsJS.length];
            for (int i = 0; i < metricSettingsJS.length; i++) {
                objects[i] = new MetricSettings(metricSettingsJS[i]);
            }
            return objects;
        } else {
            MetricSettings[] ret = new MetricSettings[1];
            ret[0] = new MetricSettings(nativeArray);
            return ret;
        }
    }

    private Float[] getAttributeAsFloatArray(String property) {
        JavaScriptObject obj = JSOHelper.getAttributeAsJavaScriptObject(jsObj, property);
        return obj != null ? JSOHelper.convertToJavaFloatArray(obj) : null;
    }

    /**
     * When {@link com.smartgwt.client.chart.MetricSettings#getUseLogGradations useLogGradations} is set, gradation lines
     * to show in between powers,
     * expressed as a series of integer or float values between 1 and {@link
     * com.smartgwt.client.chart.MetricSettings#getLogBase logBase}.
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
     * @param logGradations logGradations Default value is [ 1,2,4,6,8 ]
     */
    public void setLogGradations(Float... logGradations) {
        setAttribute("logGradations", logGradations);
    }

    /**
     * When {@link com.smartgwt.client.chart.MetricSettings#getUseLogGradations useLogGradations} is set, gradation lines
     * to show in between powers,
     * expressed as a series of integer or float values between 1 and {@link
     * com.smartgwt.client.chart.MetricSettings#getLogBase logBase}.
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
     *
     * @return float
     */
    public Float[] getLogGradations()  {
        return getAttributeAsFloatArray("logGradations");
    }

    /**
     * Display custom HTML when {@link com.smartgwt.client.widgets.chart.MetricSettings#getShowDataPoints showDataPoints} is true and the mouse hovers
     * over a point.
     * @param hoverCustomizer
     */
    public native void setPointHoverCustomizer(ChartPointHoverCustomizer hoverCustomizer) /*-{
        var self = this.@com.smartgwt.client.core.JsObject::getJsObj()();
        self.getPointHoverHTML = $debox($entry(function (value, record) {
            var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record),
                valueJ = @java.lang.Float::new(Ljava/lang/String;)("" + value);
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
        self.pointClick = $debox($entry(function (value, record) {
            var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record),
                valueJ = @java.lang.Float::new(Ljava/lang/String;)("" + value),
                eventJ = @com.smartgwt.client.widgets.chart.ChartPointClickEvent::new(Ljava/lang/Float;Lcom/smartgwt/client/data/Record;)(valueJ, recordJ);
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

}



